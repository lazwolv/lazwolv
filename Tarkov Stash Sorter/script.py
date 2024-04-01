class Item:
    def __init__(self, width, height):
        self.width = width
        self.height = height

def get_item_specs_from_user():
    item_specs = []
    while True:
        width = int(input("Enter the width of the item (0 to finish): "))
        if width == 0:
            break
        height = int(input("Enter the height of the item: "))
        count = int(input("Enter the count of this item: "))
        item_specs.append((width, height, count))
    return item_specs

def pack_items(item_specs):
    items = []
    for width, height, count in item_specs:
        items.extend([Item(width, height)] * count)
    
    # Sort items by area (size) in descending order
    items.sort(key=lambda x: x.width * x.height, reverse=True)
    
    # Initialize a grid with zeros representing empty spaces
    grid_width = 10
    grid_height = 1000
    grid = [[0 for _ in range(grid_width)] for _ in range(grid_height)]
    
    # Dictionary to store the position of each placed item
    item_positions = {}
    
    # Iterate through each item
    for item in items:
        # Try all possible positions for the item
        best_position = None
        min_height = float('inf')
        for rotation in range(4):  # Try all 4 possible rotations
            for y in range(len(grid) - item.height + 1):
                for x in range(len(grid[0]) - item.width + 1):
                    # Check if item can be placed at this position
                    if all(grid[y + dy][x + dx] == 0 for dy in range(item.height) for dx in range(item.width)):
                        # Calculate the height after placing the item
                        height_after_placing = max(y + item.height, max(max(row[x:x+item.width]) for row in grid))
                        if height_after_placing < min_height:
                            min_height = height_after_placing
                            best_position = (x, y, rotation)
        
            # Rotate the item
            item.width, item.height = item.height, item.width
        
        # Place the item at the best position
        if best_position:
            x, y, rotation = best_position
            item_positions[item] = (x, y, rotation)
            for dy in range(item.height):
                for dx in range(item.width):
                    grid[y + dy][x + dx] = 1
    
    return item_positions

# Get item specifications from user
item_specs = get_item_specs_from_user()

# Pack items and print positions
item_positions = pack_items(item_specs)
for item, position in item_positions.items():
    print(f"Item {item.width}x{item.height} placed at position {position}")
