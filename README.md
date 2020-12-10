# zookeeper-manager
This project is written in an agnostic manner in as simple of a process as possible.

To use:
1. Import jar into project
2. Initialize ZookeeperConfiguration with the Zookeeper host to connect to
3. Use the instance of ZookeepConfiguration that you created to call getZNodeData with the path to your data on Zookeeper. Do the same for create and update.
