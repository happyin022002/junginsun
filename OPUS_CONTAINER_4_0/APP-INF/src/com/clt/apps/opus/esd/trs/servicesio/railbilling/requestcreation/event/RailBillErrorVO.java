/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : RailBillErrorVO.java
*@FileTitle : RailBillErrorVO Info
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-20
*@LastModifier : leebh
*@LastVersion : 1.0
* 2006-12-20 leebh
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.servicesio.railbilling.requestcreation.event;

import com.clt.apps.opus.esd.trs.servicesio.railbilling.RailBillingIWSProxy;

/**
 * WebService Document Object including Parameters<br>
 * - RailBillingIWSProxy Output Parameter<br>
 * - EventResponse에서 변환하여 사용<br>
 *
 * @author leebh
 * @see RailBillingIWSProxy 참조
 * @since J2EE 1.4
 */
public class RailBillErrorVO implements java.io.Serializable {
	/** (Param 객체) */
	private String err_msg_cd = null;
	private String lang_tp_cd = null;
	private String err_tp_cd = null;
	private String err_msg = null;
	/**
	 * @return Returns the err_msg.
	 */
	public String getErr_msg() {
		return err_msg;
	}
	/**
	 * @param err_msg The err_msg to set.
	 */
	public void setErr_msg(String err_msg) {
		this.err_msg = err_msg;
	}
	/**
	 * @return Returns the err_msg_cd.
	 */
	public String getErr_msg_cd() {
		return err_msg_cd;
	}
	/**
	 * @param err_msg_cd The err_msg_cd to set.
	 */
	public void setErr_msg_cd(String err_msg_cd) {
		this.err_msg_cd = err_msg_cd;
	}
	/**
	 * @return Returns the lang_tp_cd.
	 */
	public String getLang_tp_cd() {
		return lang_tp_cd;
	}
	/**
	 * @param lang_tp_cd The lang_tp_cd to set.
	 */
	public void setLang_tp_cd(String lang_tp_cd) {
		this.lang_tp_cd = lang_tp_cd;
	}
	/**
	 * @return Returns the err_tp_cd.
	 */
	public String getErr_tp_cd() {
		return err_tp_cd;
	}
	/**
	 * @param err_tp_cd The err_tp_cd to set.
	 */
	public void setErr_tp_cd(String err_tp_cd) {
		this.err_tp_cd = err_tp_cd;
	}
	
}
