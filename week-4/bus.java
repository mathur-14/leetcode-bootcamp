class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target)
            return 0;

        final Map<Integer, List<Integer>> graph = new HashMap<>();

        for(int i = 0; i < routes.length; ++i) {
            for(final int stop : routes[i]) {
                graph.putIfAbsent(stop, new ArrayList<>());
                graph.get(stop).add(i);
            }
        }

        if(!graph.containsKey(source) || !graph.containsKey(target))
            return -1;

        final Queue<Integer> queue = new LinkedList<>();
        final boolean[] seenBuses = new boolean[routes.length];
        final Set<Integer> seenStops = new HashSet<>();

        queue.offer(source);
        seenStops.add(source);

        int count = 0;

        while(!queue.isEmpty()) {
            count++;

            final int size = queue.size();

            for(int i = 0; i < size; ++i) {
                final int stop = queue.poll();

                for(final int bus : graph.get(stop)) {
                    if(seenBuses[bus])
                        continue;

                    seenBuses[bus] = true;

                    for(final int nextStop : routes[bus]) {
                        if(seenStops.contains(nextStop))
                            continue;

                        if(nextStop == target)
                            return count;

                        queue.add(nextStop);
                        seenStops.add(nextStop);
                    }
                }
            }
        }

        return -1;
    }
}