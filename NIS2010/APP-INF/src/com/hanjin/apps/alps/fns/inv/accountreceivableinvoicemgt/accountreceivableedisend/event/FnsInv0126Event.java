/**
 * Copyright(c) 2012 CyberLogitec
 * @FileName : FnsInv0126Event.java
 * @FileTitle : EDI Submission(Honey Well)
 * Open Issues :
 * Change history :
 * @LastModifyDate : 2012.05.17
 * @LastModifier : Sang-Hyun Kim
 * @LastVersion : 1.0
 * 1.0 Creation 2012.05.17 Sang-Hyun Kim.
 */
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.event;

import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * DHL EDI에 대한 parameter value object.
 * 
 * @author Sang-Hyun Kim
 * @see 각 DAO Class 참조.
 * @since J2EE 1.4
 */
public class FnsInv0126Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	private String row = null;
	private String orderNos = null;

	/**
	 * @return the row
	 */
	public String getRow() {
		return row;
	}
	/**
	 * @param row the row to set
	 */
	public void setRow(String row) {
		this.row = row;
	}
	/**
	 * @return the orderNos
	 */
	public String getOrderNos() {
		return orderNos;
	}
	/**
	 * @param orderNos the orderNos to set
	 */
	public void setOrderNos(String orderNos) {
		this.orderNos = orderNos;
	}
}
