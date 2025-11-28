#Find two numbers in array whose sum = target.
def two_sum(nums, target):
    mp = {}     # {2:0}
    for i, num in enumerate(nums):
        rem = target - num
        if rem in mp:
            return [mp[rem],i]
        mp[num] = i

    return []


print(two_sum([2,7,11,15],9))