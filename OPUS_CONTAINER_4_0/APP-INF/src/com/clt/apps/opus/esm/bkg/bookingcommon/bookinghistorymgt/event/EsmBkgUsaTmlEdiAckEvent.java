/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmBkgUsaTmlEdiAckEvent.java
 *@FileTitle : 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.09.22
 *@LastModifier : 류대영
 *@LastVersion : 1.0
 * 2009.12.08 류대영
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.event;
import com.clt.apps.opus.esm.bkg.servicesio.GeneralBookingConductMQProxy;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * 미주 terminal EDI 수신용 이벤트
 * 
 * @author Ryu Daeyoung
 * @see GeneralBookingConductMQProxy 참조
 * @since J2EE 1.4
 */
public class EsmBkgUsaTmlEdiAckEvent extends EventSupport {
	private static final long serialVersionUID = 1L;	
	private String rcvMsg = null;
	
	public String getRcvMsg() {
		return rcvMsg;
	}
	public void setRcvMsg(String rcvMsg) {
		this.rcvMsg = rcvMsg;
	}
}