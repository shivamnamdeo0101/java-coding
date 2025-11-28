from collections import Counter

def freq(arr):
    # return dict(Counter(arr))
    mp = {}
    for c in arr:
        mp[c] = mp.get(c,0) + 1

    return mp

print(freq([1,2,2,3,3,3]))