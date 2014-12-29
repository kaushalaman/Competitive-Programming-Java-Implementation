int MinGlasses(int* guest_arrival, int* guest_departure, int n) {
    int arrivals[600], departures[600], i;
    for (i = 0 ; i < 600; i++)
        arrivals[i] = departures[i] = 0;
    for (i = 0 ; i < n ; i++) { // format the time into the interval [0, 559]
        arrivals[guest_arrival[i] - 1800]++;//we could format into an interval
        departures[guest_departure[i] - 1800]++; // [0, 359] to save space
    }
    int res = 0, available_glasses = 0;
    for (i = 0 ; i <= 559; i++) {
        available_glasses += departures[i];
        if (arrivals[i] > available_glasses) {
            res += arrivals[i] - available_glasses;
            available_glasses = 0;
        } else
            available_glasses -= arrivals[i];
    }
    return res;
}
