package com.google.checkout.orderprocessing;

import com.google.checkout.AbstractCheckoutRequest;
import com.google.checkout.MerchantConstants;

public abstract class AbstractCancelOrderRequest extends AbstractCheckoutRequest implements CancelOrderRequest {

	public AbstractCancelOrderRequest(MerchantConstants merchantConstants, String googleOrderNo, String reason) {

		super(merchantConstants);
		this.setGoogleOrderNo(googleOrderNo);
		this.setReason(reason);
	}

	public AbstractCancelOrderRequest(MerchantConstants merchantConstants, String googleOrderNo, String reason, String comment) {

		super(merchantConstants);
		this.setGoogleOrderNo(googleOrderNo);
		this.setReason(reason);
		this.setComment(comment);

	}

}
