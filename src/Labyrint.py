from LIFO import LIFO, Point

if __name__ == "__main__":
    path = LIFO(75)
    path.push(Point(1, 7))
    map: list=[]

    with open("labyrint.txt") as file:
        map = [line.strip().split() for line in file.readlines()]

    while True:
        current = path.head()
        print(current)
        value = int(map[current.y][current.x])
        print(value)
        string: str=""

        if value >= 8:
            value -= 8
            string += " ZAPAD"
        if value >= 4:
            value -= 4
            string += " JUH"
        if value >= 2:
            value -= 2
            string += " VYCHOD"
        if value >= 1:
            value -= 1
            string += " SEVER"

        print(" P: "+str(path.getTop())+"\n"+string)
        direction = input().strip()

        if direction in string:
            if not path.freeCap() == 0:
                if direction == "JUH":
                    path.push(Point(current.x, current.y+1))
                if direction == "SEVER":
                    path.push(Point(current.x, current.y-1))
                if direction == "VYCHOD":
                    path.push(Point(current.x+1, current.y))
                if direction == "ZAPAD":
                    path.push(Point(current.x-1, current.y))
            else:
                print("You have reached maximum steps!")

        elif direction == "NAVRAT":
            if path.getTop() > 1:
                path.pop()
            else:
                print("Si na zaciatku labyrintu!")