/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : OpusbkgEdiErrUsReceiveEvent
 *@FileTitle : 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.11.20
 *@LastModifier : 김민정
 *@LastVersion : 1.0
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.event;

import com.clt.apps.opus.esm.bkg.servicesio.CustomsDeclarationProxy;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * EDI 수신용 이벤트
 * 
 * @author 김민정
 * @see CustomsDeclarationProxy 참조
 * @since J2EE 1.6
 */
public class OpusbkgEdiErrUsReceiveEvent extends EventSupport {
	private static final long serialVersionUID = 1L;
	
	public String flatFile = null;
	public String orgMsgKey = null;
	public String msg = null;

	/**
	 * @return the flatFile
	 */
	public String getFlatFile() {
		return flatFile;
	}

	/**
	 * @param flatFile the flatFile to set
	 */
	public void setFlatFile(String flatFile) {
		this.flatFile = flatFile;
	}
	
	/**
	 * @return orgMsgKey
	 */
	public String getOrgMsgKey() {
		return orgMsgKey;
	}

	/**
	 * @param orgMsgKey
	 */
	public void setOrgMsgKey(String orgMsgKey) {
		this.orgMsgKey = orgMsgKey;
	}
	
	/**
	 * @return msg
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * @param msg
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
