from collections import defaultdict

def group_anagrams(words):
    """
    Input: ["eat","tea","tan","ate","nat","bat"]
    Output: [["eat","tea","ate"], ["tan","nat"], ["bat"]]
    """
    mp = defaultdict(list)

    for w in words:
        key = ''.join(sorted(w))
        mp[key].append(w)
    return list(mp.values())


print(group_anagrams(["eat","tea","tan","ate","nat","bat"]))