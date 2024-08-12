# GildedRose
This README will be used as a devlog.

### Info
Sun 11-08-24 15:00 - 18:00 + Mon 12-08-24 09:00 - 11:00

#### Approach
GildedRose file is unreadable and full of code smells; needs to be refactored. 
Tests have been set up already, TDD will be applied. According to description: Do NOT alter item class. 

1. Get rid of magic strings, introduce static properties or enum. 
1. If tree makes file a chore to read, and there's a lot of redundancy and duplication. Separate items based by name. 
3. items[i] reused, move code to subclass updateQuality with item param and pass items[i].
4. Rename old updateQuality to updateStock to better represent what the method does. 
5. Duplication of .quality checks and increments?
6. Accessing and assigning items directly does not seem like a good idea. Introduce subclasses and a Factory. 
7. Ideally I would move updateQuality to the item class, unfortunately this is not allowed. Subclasses are a no go.
8. Implement Strategy pattern to execute unique strat based on type of item.
9. Repurpose factory to create the right strat. 

#### What to test
##### Quality property
1. Quality always 0 < 50
2. Quality decreases by 1 every day
2. Quality degrades twice as fast once each sell date has been passed
3. Aged Brie increases in Quality the older it gets
4. 'Sulfuras' never decreases in quality
5. Backstage passes and aged brie quality +3 when sellIn < 5, + 2 when sellIn < 10 and 0 when sellIn -1? 
6. Conjured items degrade in Quality twice as fast (introduce const)

### Notes
Fun exercise that reminds me of inventory logic for games. 

