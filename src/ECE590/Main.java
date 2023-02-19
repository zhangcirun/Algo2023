package ECE590;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Edge {
    String start;
    String end;

    public Edge(String start, String end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "start='" + start + '\'' +
                ", end='" + end + '\'' +
                '}';
    }
}

public class Main {
    static List<Edge> edges = new ArrayList<>();

    public static void readLine(String line) {
        String words[] = line.split(",");
        for (int i = 0; i < words.length - 1; i++) {
            edges.add(new Edge(words[i], words[i + 1]));
        }
    }

    private static int getOccurrence(String state) {
        int count = 0;

        for (Edge edge : edges) {
            if (edge.start.equals(state)) {
                count++;
            }
        }

        return count;
    }

    private static int getBranch(String start, String end) {
        int count = 0;
        for (Edge edge : edges) {
            if (edge.start.equals(start) && edge.end.equals(end)) {
                count++;
            }
        }
        return count;
    }
    public static void getTransitionProb(String start, String end) {
        int total = getOccurrence(start);
        int branch = getBranch(start, end);

        if (total > 0) {
            System.out.println("P(" + start + "," + end + ") = " + branch + " out of " + total + " = " + (branch / (double)total));
        } else {
            System.out.println("P(" + start + "," + end + ") = 0");
        }

    }

    public static void main(String[] args) throws IOException {
        String fileName = "CgogICAgICAgIEhlbGxvLAoKICAgICAgICBXZSdyZSBnbGFkIHlvdSdyZSBoZXJlIQoKICAgICAgICBSYW1wIGhhcyBiZWVuIGZvcnR1bmF0ZSB0byBleHBlcmllbmNlIGV4cG9uZW50aWFsIGdyb3d0aCBvdmVyIHRoZSBwYXN0CiAgICAgICAgZmV3IHllYXJzIGFuZCB3aXRoIGl0IG91ciBhcHBsaWNhdGlvbiB2b2x1bWUgaGFzIHN1cmdlZC4KCiAgICAgICAgSW4gdGhpcyBzaXR1YXRpb24sIG1hbnkgc3RhcnR1cHMgb3B0IHRvIHVzZSBvZmYtdGhlLXNoZWxmIHRpbWVkIGxlZXRjb2RlCiAgICAgICAgc3R5bGUgU2FhUyB0b29scyB0byB0aGluIGFwcGxpY2F0aW9uIHZvbHVtZS4KCiAgICAgICAgV2UgdGhvdWdodCBwdXp6bGVzIGluIHRoZSBzcGlyaXQgb2YgYSBDVEZbMV0gd291bGQgYmUgbW9yZSBmdW4gYW5kIGEKICAgICAgICBiZXR0ZXIgZXhwcmVzc2lvbiBvZiBvdXIgdmFsdWVzLiBBcyB3ZSBleHBlY3QgeW91IHRvIHNwZW5kIGEgbGl0dGxlIGJpdAogICAgICAgIG9mIHRpbWUgb24gdGhpcyBnYXRpbmcgY2hhbGxlbmdlLCB3ZSB0aG91Z2h0IGl0IHdhcyBhcHByb3ByaWF0ZSB0aGF0IHdlCiAgICAgICAgcHV0IHRpbWUgYW5kIGVmZm9ydCBpbnRvIGNyYWZ0aW5nIGl0IG91cnNlbHZlcy4KCiAgICAgICAgV2UncmUgYXdhcmUgYW5zd2VycyBoZXJlIG1pZ2h0IGV2ZW50dWFsbHkgYmUgbGVha2VkIGFuZCB3ZSdsbCBwcm9iYWJseQogICAgICAgIGhhdmUgdG8gcmVmcmVzaCB0aGlzIGV2ZXJ5IGNvdXBsZSBtb250aHMgb3Igc28sIGJ1dCBwbGVhc2Uga2VlcCBpbiBtaW5kCiAgICAgICAgaXQnbGwgYmUgdmVyeSBlYXN5IHRvIHRlbGwgb25jZSB0aGF0IGhhcHBlbnMgYW5kIHdpbGwgb25seSByZXN1bHQgaW4KICAgICAgICBzbG93aW5nIGRvd24gb3VyIGFiaWxpdHkgdG8gcHJvY2VzcyBhcHBsaWNhdGlvbnMgLSBzbyBwbGVhc2Uga2VlcCB0aGUKICAgICAgICBmbGFncyB0byB5b3Vyc2VsZi4KCiAgICAgICAgQWxsIGZsYWdzIGFyZSBzZXZlbiBsZXR0ZXIgZGljdGlvbmFyeSB3b3Jkcy4KCiAgICAgICAgQWxsIGZsYWcgZ2F0ZXMgYXJlIGluZGVwZW5kZW50IG9mIGVhY2ggb3RoZXIgLSBpLmUuIHlvdSBkb24ndCBuZWVkIHRvCiAgICAgICAgZmluZCBvbmUgZmxhZyB0byB1bmxvY2sgdGhlIG5leHQgb25lLgoKICAgICAgICBQbGVhc2Ugc3VibWl0IGF0IGxlYXN0IHR3byBmbGFncywgYnV0IGZlZWwgZnJlZSB0byBzdWJtaXQgYXMgbWFueSBhcyB5b3UKICAgICAgICBjYW4gZmluZC4KCiAgICAgICAgRW5qb3khCgogICAgICAgIC0gUmFtcCBFbmdpbmVlcmluZyA8Y3RmQHJhbXAuY29tPgoKCiAgICAgICAgMTogaHR0cHM6Ly9lbi53aWtpcGVkaWEub3JnL3dpa2kvQ2FwdHVyZV90aGVfZmxhZ18oY3liZXJzZWN1cml0eSkKCgogICAgICAgIA==";

        for (int i = 0; i + 7 < fileName.length(); i++) {
            System.out.println(fileName.substring(i, i + 7));
        }
     }
}
