# MultiSorter (Work in Progress)

This is a **JavaFX-based application** designed to **visualize sorting algorithms**.
The application provides an interactive interface for triggering various sorting algorithms and observing the sorting process in step-by-step.
The main goal of the project is to serve as an educational tool, 
helping users to understand sorting algorithms through clear visualization.

## Project Status

This project is currently a **work in progress**.
I'm currently implementing the selection and merge sort classes before I develop the queues.

## Features:

### Algorithms:
- **Bubble Sort**: Repeatedly compares and swaps adjacent elements until the array is sorted. Simple but inefficient for large datasets.
- **Insertion Sort**: Builds a sorted section of the array by inserting each element into its correct position. Efficient for small or nearly sorted datasets.
- **Quick Sort**: A "divide and conquer" algorithm that partitions the array around a pivot and recursively sorts subarrays. Highly efficient for large datasets.
- **Selection Sort**: ***(Not Implemented)*** Repeatedly selects the smallest (or largest) element from the unsorted portion and moves it to the sorted portion.
- **Merge Sort**: ***(Not Implemented)*** Recursively divides the array into halves, sorts each half, and merges them.

### User Interface:
- **Basic Sorting UI and Splash Scene**: Displays the splash scene with a logo.
- **Basic Sorting UI and Splash Scene** Basic UI Layout as a prototype facilitating the basic sorting and user input functionality
- **Notification Queue**: ***(Not Implemented)*** Displays important messages such as validation errors and info that needs the user's attention. 
- **Teaching Operations Queue**: ***(Not Implemented)*** Displays step-by-step operations like swaps, comparisons, and recursion during the sorting process.

## Potential Future Improvements:
- **Algorithms**: Addition of Heap Sort, Radix Sort, Shell Sort etc.
-  **UX/UI:** Implement Playback Controls i.e.  play, pause, step forward, step back, speed control for the teaching queue.
- **Accessibility:** Add the ability to modify the color scheme (color blindness), text-to-speech, ability to modify the font size etc.

## Getting Started

### Prerequisites

- **Java 17 or higher**
- **[JavaFX SDK](https://gluonhq.com/products/javafx/)** (required for Java 11+) 
- **IDE**: Any modern Java IDE (e.g., Eclipse, IntelliJ IDEA, or NetBeans)

### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/HWStradling/MultiSorter.git