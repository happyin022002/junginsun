/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BcmCcd0001Event.java
*@FileTitle : Account
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.18
*@LastModifier : 조인영
*@LastVersion : 1.0
* 2011.02.18 조인영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.account.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.bcm.ccd.commoncode.account.vo.AccountVO;
 

/**
 * BCM_CCD_0001 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  BCM_CCD_0001HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 조인영
 * @see BCM_CCD_0001HTMLAction 참조
 * @since J2EE 1.6
 */

public class BcmCcd0001Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Acct Code */
	private String acctCd = "";
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private AccountVO acctVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private AccountVO[] acctVOs = null;

	public BcmCcd0001Event(){}
	
	public void setAccountVO(AccountVO acctVO){
		this. acctVO = acctVO;
	}

	public void setAccountVOS(AccountVO[] acctVOs){
		if(acctVOs != null){
			AccountVO[] tmpVOs = java.util.Arrays.copyOf(acctVOs, acctVOs.length);
			this.acctVOs = tmpVOs;
		}
	}

	public AccountVO getAccountVO(){
		return acctVO;
	}

	public AccountVO[] getAccountVOS(){
		AccountVO[] rtnVOs = null;
		if (this.acctVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(acctVOs, acctVOs.length);
		}
		return rtnVOs;
	}

	public void setAcctCd(String acctCd) {
		this.acctCd = acctCd;
	}
	
	public String getAcctCd() {
		return acctCd;
	}
}