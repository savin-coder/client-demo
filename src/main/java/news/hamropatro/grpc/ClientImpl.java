package news.hamropatro.grpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import jakarta.inject.Singleton;
import news.hamropatro.NRSReply;
import news.hamropatro.NRSRequest;
import news.hamropatro.NRSServiceGrpc;


@Singleton
public class ClientImpl {

    public static void main(String[] args) {
        ManagedChannel managedChannel = ManagedChannelBuilder
                .forAddress("192.168.86.202", 50059)
                .usePlaintext().build();


        NRSServiceGrpc.NRSServiceBlockingStub stubs = NRSServiceGrpc.newBlockingStub(managedChannel);

        NRSRequest request = NRSRequest.newBuilder()
                .setName("Sabin Gautam")
                .setAddress("Kathmandu")
                .build();

        NRSReply reply = stubs.send(request);
        System.out.println("Message: " + reply.getMessage());
        //System.out.println("GivenAddress: " + reply.getGivenAdd());

    }
}