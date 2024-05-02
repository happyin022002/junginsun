/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PoolMvmtINVO.java
*@FileTitle : PoolMvmtINVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.12
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.08.12 최민회 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo;

import java.util.List;
import java.util.Map;

import com.clt.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 최민회
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class MGSAgreementGroupVO {
	
	public String[] getHead() {
		return head;
	}

	public void setHead(String[] head) {
		this.head = head;
	}
	
    private String[] head = null;

    private  Map<String, String> etcData = null;
    private List<MGSAgreementMGTVO> mgsagreementmgtvervo  = null;
    
    private List<MGSAgreementMGTVO> mgsagreementmgtvo  = null;
    
    private List<MGSAgreementMGTVO> mgsagreementmgtvo2 = null;
    private List<MGSAgreementMGTVO> mgsagreementmgtvo3 = null;
    

    
	public List<MGSAgreementMGTVO> getMgsagreementmgtvervo() {
		return mgsagreementmgtvervo;
	}

	public void setMgsagreementmgtvervo(List<MGSAgreementMGTVO> mgsagreementmgtvervo) {
		this.mgsagreementmgtvervo = mgsagreementmgtvervo;
	}

	public List<MGSAgreementMGTVO> getMgsagreementmgtvo2() {
		return mgsagreementmgtvo2;
	}

	public void setMgsagreementmgtvo2(List<MGSAgreementMGTVO> mgsagreementmgtvo2) {
		this.mgsagreementmgtvo2 = mgsagreementmgtvo2;
	}

	public List<MGSAgreementMGTVO> getMgsagreementmgtvo3() {
		return mgsagreementmgtvo3;
	}

	public void setMgsagreementmgtvo3(List<MGSAgreementMGTVO> mgsagreementmgtvo3) {
		this.mgsagreementmgtvo3 = mgsagreementmgtvo3;
	}

	/**
	 * @return the etcData
	 */
	public Map<String, String> getEtcData() {
		return etcData;
	}

	/**
	 * @param etcData the etcData to set
	 */
	public void setEtcData(Map<String, String> etcData) {
		this.etcData = etcData;
	}

	/**
	 * @return the mgsagreementmgtvo
	 */
	public List<MGSAgreementMGTVO> getMgsagreementmgtvo() {
		return mgsagreementmgtvo;
	}

	/**
	 * @param mgsagreementmgtvo the mgsagreementmgtvo to set
	 */
	public void setMgsagreementmgtvo(List<MGSAgreementMGTVO> mgsagreementmgtvo) {
		this.mgsagreementmgtvo = mgsagreementmgtvo;
	}
 
    
    
}
