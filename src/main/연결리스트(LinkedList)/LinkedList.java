// List를 구성하는 Node 클래스
class ListNode {
    private String data;    // 데이터 저장 변수
    public ListNode link;   // 다른 노드를 참조할 링크 노드

    public ListNode() {
        this.data = null;
        this.link = null;
    }

    public ListNode(String data) {
        this.data = data;
        this.link = link;
    }

    public String getData() {
        return data;
    }
}

public class LinkedList {
    private ListNode head;  // ListNode 타입의 head 노드 인스턴스 변수

    // LinkedList 생성자
    public LinkedList() {
        head = null;    // head 노드 초기화
    }

    // Node 삽입(중간 삽입)
    public void insertNode(ListNode preNode, String data) {
        ListNode newNode = new ListNode(data);  // 새로운 노드 생성

        // preNode.link는 preNode의 다음 노드이므로,
        // newNode.link = preNode.link는 새로운 노드의 link가 preNode의 다음 노드를 참조하도록 함.
        newNode.link = preNode.link;
    }

    // Node 삽입(마지막에 삽입)
    public void insertNode(String data) {
        ListNode newNode = new ListNode(data);
        if (head == null) {
            // head 노드가 null인 경우 새로운 노드를 참조하도록 함
            this.head = newNode;
        } else {
            // head 노드가 null이 아닌 경우 temp 노드가 head를 참조.
            // tempNode는 마지막 노드를 찾아서 참조하기 위해 사용.
            ListNode tempNode = head;
            // temp 노드의link가 null이 아닐 때까지 다음 노드를 참조.
            // tempNode.link는 다음 노드를 참조하고 있으므로,
            // tempNode=tempNode.link는 tempNode에 다음 노드를 참조하도록 하는 것.
            // while문이 모두 실행되면 tempNode는 가장 마지막 노드를 참조하게 됨.
            while (tempNode.link != null) {
                tempNode = tempNode.link;
            }
            // tempNode(마지막 노드)의 link가 다음 노드를 참조하도록 한다.
            tempNode.link = newNode;
        }
    }

    // Node 삭제(중간 노드 삭제)
    public void deleteNode(String data) {
        // preNode는 head가 가리키는 노드를 할당
        ListNode preNode = head;
        // tempNode는 head가 가리키는 노드의 다음 노드. 즉, preNode의 다음 노드를 할당
        ListNode tempNode = head.link;

        // 주어진 데이터가 preNode의 데이터와 일치하는 경우
        // 즉, 첫번째 노드의 데이터와 일치하는 경우
        if (data.equals(preNode.getData())) {
            // head는 preNode의 다음 노드를 참조하도록 함.
            head = preNode.link;
            // preNode의 link는 null을 할당하여 연결을 끊음.
            preNode.link = null;
        } else {
            // tempNode가 null일 때까지 반복하여 탐색
            while (tempNode != null) {
                // 주어진 데이터와  temp 노드의 데이터가 일치할 경우.
                if (data.equals(tempNode.getData())) {
                    // tempNode가 마지막 노드인 경우
                    if (tempNode.link == null) {
                        preNode.link = null;
                    } else {
                        // tempNode가 마지막 노드가 아닌 경우
                        // preNode의 link는 tempNode의 다음 노드를 참조.
                        // tempNode의 link는 null을 할당하여 다음 노드로의 연결을 끊음.
                        preNode.link = tempNode.link;
                        tempNode.link = null;
                    }
                    break;
                } else {
                    // 데이터가 일치하지 않을 경우
                    // preNode에 tempNode를 할당하고, tempNode에 다음 노드 할당.
                    preNode = tempNode;
                    tempNode = tempNode.link;
                }
            }
        }
    }

    // Node 삭제(마지막 노드 삭제)
    public void deleteNode() {
        ListNode preNode;
        ListNode tempNode;

        // head 노드가 null인 경우 모든 노드가 삭제되었으므로 return
        if (head == null) {
            return;
        }

        // head 노드의 link가 null인 경우
        // 노드가 1개 남아을 경우
        if (head.link == null) {
            // head에 null을 할당하여 남은 노드와 연결을 끊음.
            head = null;
        } else {
            // preNode는 head가 가리키는 노드를 할당
            preNode = head;
            // tempNode는 head가 가리키는 노드의 다음 노드, 즉, preNode의 다음 노드를 할당
            tempNode = head.link;

            // tempNode의 link가 null이 아닐 때까지 한 노드씩 다음 노드로 이동.
            // preNode는 tempNode를 할당하고
            // tempNode는 tempNode의  다음 노드를 할당.
            // 이렇게 하면 preNode는 마지막 노드의 이전 노드가 되고, tempNode는 마지막 노드가 된다.
            while (tempNode.link != null) {
                preNode = tempNode;
                tempNode = tempNode.link;
            }
            // preNode의 link를 null로 만들어서 가장 마지막 노드를 삭제
            // 즉, preNode의 다음 노드인 tempNode로의 연결을 끊음.
            preNode.link = null;
        }
    }

    // Node 탐색
    public ListNode searchNode(String data) {
        // tempNode에 head가 가리키는 첫 번째 할당.
        ListNode tempNode = this.head;

        // tempNode가 null이 아닐 때까지 반복하여 탐색
        while (tempNode != null) {
            // 주어진 데이터와 tempNode의 데이터가 일치할 경우 해당 temp 노드를 return
            if (data.equals(tempNode.getData())) {
                return tempNode;
            } else {
                // 데이터가 일치하지 않을 경우 tempNode에 다음 노드 할당.
                tempNode = tempNode.link;
            }
        }

        return tempNode;
    }

    // 리스트의 노드를 역순으로 구성
    public void reverseList() {
        // head가 참조하는 첫번째 노드를 할당.
        ListNode nextNode = head;
        ListNode currentNode = null;
        ListNode preNode = null;

        // nextNode가 순차적으로 이동하며 currentNode의 link가 preNode를 참조하도록 함.
        // 1) preNode를 currentNode 위치로 이동
        // 2) currentNode는 nextNode 위치로 이동
        // 3) nextNode는 다음 노드 위치로 이동
        // 4) currentNode의 link는 preNode를 참조하도록 함
        while (nextNode != null) {
            preNode = currentNode;  // preNode를 currentNode 위치로 이동
            currentNode = nextNode; // currentNode는 nextNode 위치로 이동
            nextNode = nextNode.link;   // nextNode는 다음 노드 위치로 이동
            currentNode.link = preNode; // currentNode의 link는 preNode를 참조하도록 함
        }
        // currentNode가 마지막 노드를 가리킬 때, head는 currentNode를 참조하도록 함.
        head = currentNode;
    }

    // 연결리스트에 저장된 모든 데이터를 출력
    public void printList() {
        ListNode tempNode = this.head;  // tempNode에 head가 가리키는 첫 번째 노드를 할당

        // tempNode가 null이 아닐 때ㅔ까지 반복하여 출력
        while (tempNode != null) {
            System.out.println(tempNode.getData() + " ");
            tempNode = tempNode.link;   // tempNode에 다음 노드(tempNode.link) 할당
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        String str = "wed";

        linkedList.insertNode("sun");
        linkedList.insertNode("mon");
        linkedList.insertNode("tue");
        linkedList.insertNode("wed");
        linkedList.insertNode("thu");
        linkedList.insertNode("fri");
        linkedList.insertNode("sat");
        linkedList.printList();

        System.out.println(linkedList.searchNode(str).getData());

        linkedList.deleteNode(linkedList.searchNode(str).getData());
        linkedList.printList();

        str = "sun";

        linkedList.deleteNode(linkedList.searchNode(str).getData());
        linkedList.printList();

        linkedList.reverseList();
        linkedList.printList();
    }

}
