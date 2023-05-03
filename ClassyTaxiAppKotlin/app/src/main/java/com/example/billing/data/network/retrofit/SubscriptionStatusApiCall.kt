package com.example.billing.data.network.retrofit

import com.example.billing.data.ContentResource
import com.example.billing.data.SubscriptionStatus
import com.example.billing.data.SubscriptionStatusList
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PUT

/**
 * [SubscriptionStatusApiCall] defines the API endpoints that are called in [ServerFunctionsImpl].
 */
interface SubscriptionStatusApiCall {

    // Fetch Basic content.
    @GET("content_basic")
    suspend fun fetchBasicContent(): ContentResource

    // Fetch Premium content.
    @GET("content_premium")
    suspend fun fetchPremiumContent(): ContentResource

    // Fetch Subscription Status.
    @GET("subscription_status")
    suspend fun fetchSubscriptionStatus(): Response<SubscriptionStatusList>

    // Registers Instance ID for Firebase Cloud Messaging.
    @PUT("instanceId_register")
    suspend fun registerInstanceID(@Body instanceId: Map<String, String>): String

    // Unregisters Instance ID for Firebase Cloud Messaging.
    @PUT("instanceId_unregister")
    suspend fun unregisterInstanceID(@Body instanceId: Map<String, String>): String

    // Registers subscription status to the server and get updated list of subscriptions
    @PUT("subscription_register")
    suspend fun registerSubscription(@Body registerStatus: SubscriptionStatus):
            Response<SubscriptionStatusList>

    // Transfers subscription status to another account.
    @PUT("subscription_transfer")
    suspend fun transferSubscription(@Body transferStatus: SubscriptionStatus)
            : SubscriptionStatusList

    @PUT("acknowledge_purchase")
    suspend fun acknowledgeSubscription(@Body acknowledge: SubscriptionStatus)
            : Response<SubscriptionStatusList>
}