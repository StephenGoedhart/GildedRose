# GildedRose
GildedRose assessment for DPG. This README will be used as a devlog.

### Info
Sun 11-08024 15:00 - 18:00 

#### At first glance
GildedRose file is unreadable and full of code smells; needs to be refactored. 
Tests have been set up already so TDD will be applied. According to description: Do NOT alter item class. 

1. If tree makes file a chore to read 
2. Name is used as discriminatory factor, introduce enum?
3. items[i] reused, should be var
4. Duplication of .quality checks and increments?
5. Accessing and assigning items directly does not seem like a good idea. Introduce subclasses and a Factory. 
6. Ideally I would move updateQuality to the item class, unfortunately this is not allowed. 
7. 

#### What to test
##### Quality property
1. Quality always 0 < 50
2. Quality decreases by 1 every day
2. Quality degrades twice as fast once each sell date has been passed
3. Aged Brie increases in Quality the older it gets
4. 'Sulfuras' never decreases in quality
5. Backstage passes and aged brie quality +3 when sellIn < 5, + 2 when sellIn < 10 and 0 when sellIn -1? 
6. Conjured items degrade in Quality twice as fast (introduce const)

What to test:

### Notes
Fun exercise that reminds me of inventory logic for games. 

