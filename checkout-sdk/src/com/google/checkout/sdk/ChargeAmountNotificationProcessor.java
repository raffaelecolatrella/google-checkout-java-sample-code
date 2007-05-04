/*******************************************************************************
 * Copyright (C) 2007 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 ******************************************************************************/

package com.google.checkout.sdk;

import com.google.checkout.CheckoutException;
import com.google.checkout.MerchantConstants;
import com.google.checkout.example.GoogleOrder;
import com.google.checkout.example.notification.AbstractNotificationProcessor;
import com.google.checkout.notification.ChargeAmountNotification;

/**
 * @author simonjsmith
 * @author Inderjeet Singh (inder@google.com)
 */
public class ChargeAmountNotificationProcessor extends
    AbstractNotificationProcessor implements NotificationProcessor {
  
  
  public String process(MerchantConstants mc, String notificationMsg)
  throws CheckoutException {
    try {
      ChargeAmountNotification notification = new ChargeAmountNotification(notificationMsg);
      String ack = getAckString();
      GoogleOrder order = GoogleOrder.findOrCreate(mc.getMerchantId(),
          notification.getGoogleOrderNo());
      order.addIncomingMessage(notification.getTimestamp(), notification
          .getRootNodeName(), notification.getXmlPretty(), ack);
      return ack;
    } catch (Exception e) {
      throw new CheckoutException(e);
    }
  }
}
