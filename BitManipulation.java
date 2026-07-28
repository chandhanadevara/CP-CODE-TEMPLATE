// Set the kth bit to 1
static int setKthBit(int n, int k) {
    return n | (1 << k);
}

// Clear the kth bit to 0
static int clearKthBit(int n, int k) {
    return n & ~(1 << k);
}

// Toggle the kth bit
static int toggleKthBit(int n, int k) {
    return n ^ (1 << k);
}

// Get the kth bit
static int getKthBit(int n, int k) {
    return (n >> k) & 1;
}
