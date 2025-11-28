#Find the first character that appears only once.
def first_non_repeating(s):
    freq ={}
    #swis => s=3, w=>1, i=>1
    #count the freq
    for c in s:
        freq[c] = freq.get(c,0)+1

    #find first non-repeat char

    for c in s:
        if freq[c] == 1:
            return c

    return 0

print(first_non_repeating("swiss"))