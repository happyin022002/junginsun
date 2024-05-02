/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : StmSap0350Event.java
*@FileTitle : LocationList
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.event;

import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.APVendorInfoVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * HTTP Parser<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 AccountPayableCommonSC 실행요청<br>
 * - AccountPayableCommonSC View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author ORKIM
 * @see AccountPayableCommonSC 참조
 * @since J2EE 1.4
 */

public class StmSap0350Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private String vndrNo = "";
	private String vndrNm = "";
	private APVendorInfoVO[] aPVendorInfoVOs = null;

	public StmSap0350Event() {}

	public String getVndrNo() {
		return vndrNo;
	}

	public void setVndrNo(String vndrNo) {
		this.vndrNo = vndrNo;
	}

	public String getVndrNm() {
		return vndrNm;
	}

	public void setVndrNm(String vndrNm) {
		this.vndrNm = vndrNm;
	}

	public APVendorInfoVO[] getAPVendorInfoVOs() {
		APVendorInfoVO[] rtnVOs = null;
		if(this.aPVendorInfoVOs != null) {
			rtnVOs = new APVendorInfoVO[aPVendorInfoVOs.length];
			System.arraycopy(aPVendorInfoVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;

	}

	public void setAPVendorInfoVOs(APVendorInfoVO[] aPVendorInfoVOs) {
		if(aPVendorInfoVOs != null) {
			APVendorInfoVO[] tmpVOs = new APVendorInfoVO[aPVendorInfoVOs.length];
			System.arraycopy(aPVendorInfoVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.aPVendorInfoVOs = tmpVOs;
		}

	}

}