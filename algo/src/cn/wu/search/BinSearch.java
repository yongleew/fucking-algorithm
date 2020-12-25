package cn.wu.search;

public class BinSearch {

    public int firstEquals(int[] a, int val) {
        int low = 0;
        int hi = a.length - 1;
        int mid;
        while (low <= hi) {
            mid = low + (hi - low) / 2;
            if (a[mid] > val) {
                hi = mid - 1;
            } else if (a[mid] < val) {
                low = mid + 1;
            } else {
                if (mid == low || a[mid - 1] != val) {
                    return mid;
                } else {
                    hi = mid - 1;
                }
            }
        }
        return -1;
    }

    public int firstGtEq(int[] a, int v) {
        int low = 0;
        int hi = a.length - 1;
        int mid;
        while (low <= hi) {
            mid = low + (hi - low) / 2;
            if (a[mid] >= v) {
                if (mid == low || a[mid - 1] < v) {
                    return mid;
                } else {
                    hi = mid - 1;
                }
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public int lastEq(int[] a, int v) {
        int low = 0;
        int hi = a.length - 1;
        int mid;
        while (low <= hi) {
            mid = low + (hi - low) / 2;
            if (a[mid] < v) {
                low = mid + 1;
            } else if (a[mid] > v) {
                hi = mid - 1;
            } else {
                if (mid == hi || a[mid + 1] != v) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    public int lastLtEq(int[] a, int v) {
        int low = 0;
        int hi = a.length - 1;
        int mid;
        while (low <= hi) {
            mid = low + (hi - low) / 2;
            if (a[mid] <= v) {
                if (mid == hi || a[mid + 1] > v) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            } else {
                hi = mid - 1;
            }
        }
        return -1;
    }

    public double quart(int n) {
        int low = 1;
        int hi = n - 1;

        while (low <= hi) {
            int mid = low + (hi - low) / 2;
            if (mid * mid == n) {
                return mid;
            }
            if (mid * mid > n) {
                hi = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        double i = hi;
        double j = low;
        double mid = i + (j - i) / 2;
        while (Math.pow(10, 6) * mid % 10 < 0) {
            if (mid * mid == n) {
                return mid;
            } else if (mid * mid > n) {
                j = mid;
                mid = i + (j - i) / 2;
            } else {
                i = mid;
                mid = i + (j - i) / 2;
            }
        }
        return mid;
    }
}
