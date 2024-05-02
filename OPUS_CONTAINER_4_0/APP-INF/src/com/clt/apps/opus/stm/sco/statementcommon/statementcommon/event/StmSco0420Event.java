/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : StmSap0120Event.java
 *@FileTitle : 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
 * 
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sco.statementcommon.statementcommon.event;

import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.AccrualVerificationVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * HTTP Parser<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아
 * AccountReceivableInvoiceMasterDataMgtSC로 실행요청<br>
 * - AccountReceivableInvoiceMasterDataMgtSC에서 View(JSP)로 실행결과를 전송하는
 * EventResponse를 request에 셋팅<br>
 * 
 * @author Han Dong Hoon
 * @see AccountReceivableInvoiceMasterDataMgtEvent 참조
 * @since J2EE 1.4
 */

public class StmSco0420Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private String key = "";

	private AccrualVerificationVO accrualVerificationVO = null;
	
	public AccrualVerificationVO getAccrualVerificationVO() {
		return accrualVerificationVO;
	}
	public void setAccrualVerificationVO(AccrualVerificationVO accrualVerificationVO) {
		this.accrualVerificationVO = accrualVerificationVO;
	}
	
	private AccrualVerificationVO[] accrualVerificationVOs = null;

	public AccrualVerificationVO[] getAccrualVerificationVOs() {
		AccrualVerificationVO[] rtnVOs = null;
		if (this.accrualVerificationVOs != null) {
			rtnVOs = new AccrualVerificationVO[accrualVerificationVOs.length];
			System.arraycopy(accrualVerificationVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setAccrualVerificationVOs(AccrualVerificationVO[] accrualVerificationVOs) {
		if (accrualVerificationVOs != null) {
			AccrualVerificationVO[] tmpVOs = new AccrualVerificationVO[accrualVerificationVOs.length];
			System.arraycopy(accrualVerificationVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.accrualVerificationVOs = tmpVOs;
		}
	}

	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}
	
	

}