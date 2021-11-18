class LIFO:
    def __init__(self, capacity: int=10) -> None:
        self.__buffer: list['Point']=[]
        self.__top: int = 0
        self.__status: str()=""

        if capacity <= 0:
            raise ValueError("Capacity must be greater than 0")

        self.__capacity: int = capacity

    def push(self, pos: 'Point') -> None:
        if self.__top == self.__capacity:
            raise OverflowError("LIFO is full!")

        if self.__top >= len(self.__buffer):
            self.__buffer.append(pos)
            self.__status = "Inserted"
        else:
            self.__buffer[self.__top] = pos
            self.__status = "DATA LOST"
        self.__top += 1

    def pop(self) -> None:
        if self.__top > 0:
            self.__top -= 1
        else:
            raise OverflowError("NO DATA")
    
    def __str__(self) -> str:
        string: str=""
        for item in self.__buffer:
            string += str(item) + "\n"
            
        return string + "H: " + str(self.__top)

    def see(self) -> str:
        string: str=""
        for i in range(self.__top):
            string += str(self.__buffer[i]) + "\n"
            
        return string + "H: " + str(self.__top)
    
    def freeCap(self) -> int:
        return self.__capacity - self.__top

    def clear(self) -> None:
        self.__top = 0

    def getTop(self) -> int:
        return self.__top
    
    def head(self) -> "Point":
        if not self.__top == 0:
            return self.__buffer[self.__top-1]
        else:
            raise OverflowError("NO DATA")

    def getStatus(self) -> str:
        return self.__status
    
    def getCapacity(self) -> int:
        return self.__capacity
    
class Point:
    def __init__(self, x: float, y: float) -> None:
        self.x: float = x
        self.y: float = y

    def __str__(self) -> str:
        return "[" + str(self.x) + ", " + str(self.y) + "]"

# examples
if __name__ == "__main__":
    lifo = LIFO(3)
    lifo.push(Point(0, 0))
    print(lifo.getStatus())
    print(lifo.getTop())

    lifo.push(Point(0, 1))
    print(lifo.getStatus())
    print(lifo.getTop())

    lifo.push(Point(0, 2))
    print(lifo.getStatus())
    print(lifo.getTop())

    print(lifo)
    print(lifo.see())

    lifo.clear()
    print(lifo.freeCap())

    print(lifo)
    print(lifo.see())