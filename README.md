# MultiSorter (Work in Progress)

This is a **JavaFX-based application** designed to **visualize sorting algorithms**.
The application provides an interactive interface for triggering various sorting algorithms and observing the sorting process in step-by-step.
The main goal of the project is to serve as an educational tool, 
helping users to understand sorting algorithms through clear visualization.

## Project Status

This project is currently a **work in progress**.

Having implemented the last sorting algorithms and a basic prototype UI, 
my next task is to implement the 
backend **teaching queue** and **notification queue** and their corresponding user interface's.

## Features:

### Backend:
- **Bubble Sort**: Repeatedly compares and swaps adjacent elements until the array is sorted. Simple but inefficient for large datasets.
- **Insertion Sort**: Builds a sorted section of the array by inserting each element into its correct position. Efficient for small or nearly sorted datasets.
- **Quick Sort**: A "divide and conquer" algorithm that partitions the array around a pivot and recursively sorts sub-arrays. Highly efficient for large datasets.
- **Selection Sort**:  Repeatedly selects the smallest (or largest) element from the unsorted portion and moves it to the sorted portion.
- **Merge Sort**:  Recursively divides the array into halves, sorts each half, and merges them.
- **Thread-safe arrays**: Unsorted and Sorted thread-safe arrays to decouple the frontend and backend preventing UI stuttering for large arrays.
- **Notification Queue:** ***(Not Implemented)*** Queue's notification events decoupling the notification producer and consumer.
- **Teaching Operations Queue:** ***(Not Implemented)*** Queue's sorting actions in a standardised way that can be displayed graphically , 
 also decouples in the same way as the notification queue.


### User Interface:
- **Splash Scene**: Displays the splash scene logo.
- **Prototype Sorting UI and Splash Scene** ***(Partial Implementation)*** Basic UI Layout as a prototype facilitating basic sorting and I/O functionality
- **Notification Queue UI**: ***(Not Implemented)*** Displays important messages such as validation errors and info that needs the user's attention. 
- **Teaching Operations Queue UI**: ***(Not Implemented)*** Displays step-by-step operations like swaps, comparisons, and recursion documenting the sorting process.

## Potential Future Improvements:
- **Algorithms**: Addition of Heap Sort, Radix Sort, Shell Sort etc.
- **UX:** Implement Playback Controls i.e.  play, pause, step forward, step back, speed control for the teaching queue.
- **Accessibility:** Add the ability to modify the color scheme (color blindness), text-to-speech, ability to modify the font size etc.

## Getting Started

### Prerequisites

- **Java 17 or higher**
- **[JavaFX SDK](https://gluonhq.com/products/javafx/)** (required for Java 11+) 
- **IDE**: Any modern Java IDE (e.g., Eclipse, IntelliJ IDEA, or NetBeans)

### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/HWStradling/MultiSorterFX.git
2. Run the main method in the SplashScene class.
3. Enjoy !!!
