/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BcmCcd0004Event.java
*@FileTitle : Currency
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.18
*@LastModifier : 조인영
*@LastVersion : 1.0
* 2011.02.18 조인영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.bcm.ccd.commoncode.account.event;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.apps.opus.bcm.ccd.commoncode.account.vo.CurrencyVO;


/**
 * BCM_CCD_0004 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  BCM_CCD_0004HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 조인영
 * @see BCM_CCD_0004HTMLAction 참조
 * @since J2EE 1.6
 */

public class BcmCcd0004Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Charge Code */
	private String currCd = "";
	
	/** Country Code */
	private String cntCd = "";
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CurrencyVO currVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CurrencyVO[] currVOs = null;

	public BcmCcd0004Event(){}

	public void setCurrencyVO(CurrencyVO currVO){
		this. currVO = currVO;
	}
	
	public void setCurrencyVOS(CurrencyVO[] currVOs){
		if(currVOs != null){
			CurrencyVO[] tmpVOs = java.util.Arrays.copyOf(currVOs, currVOs.length);
			this.currVOs = tmpVOs;
		}
	}

	public CurrencyVO getCurrencyVO(){
		return currVO;
	}

	public CurrencyVO[] getCurrencyVOS(){
		CurrencyVO[] rtnVOs = null;
		if (this.currVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(currVOs, currVOs.length);
		}
		return rtnVOs;
	}

	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}
	
	public String getCurrCd() {
		return currCd;
	}
	
	public String getCntCd() {
		return cntCd;
	}

	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
	}
}