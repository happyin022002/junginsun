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

public class CHSAgreementGroupVO {
	
	public String[] getHead() {
		return head;
	}

	public void setHead(String[] head) {
		this.head = head;
	}
	
    private String[] head = null;

    private  Map<String, String> etcData = null;
    
    private List<CHSAgreementMGTVO> chsagreementmgtvo  = null;
    private List<CHSAgreementMGTVO> chsagreementmgtvo2 = null;
    private List<CHSAgreementMGTVO> chsagreementmgtvo3 = null;
    private List<CHSAgreementMGTVO> chsagreementmgtvo4 = null;
    private List<CHSAgreementMGTVO> chsagreementmgtvo5 = null;
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
	 * @return the chsagreementmgtvo
	 */
	public List<CHSAgreementMGTVO> getChsagreementmgtvo() {
		return chsagreementmgtvo;
	}

	/**
	 * @param chsagreementmgtvo the chsagreementmgtvo to set
	 */
	public void setChsagreementmgtvo(List<CHSAgreementMGTVO> chsagreementmgtvo) {
		this.chsagreementmgtvo = chsagreementmgtvo;
	}

	/**
	 * @return the chsagreementmgtvo2
	 */
	public List<CHSAgreementMGTVO> getChsagreementmgtvo2() {
		return chsagreementmgtvo2;
	}

	/**
	 * @param chsagreementmgtvo2 the chsagreementmgtvo2 to set
	 */
	public void setChsagreementmgtvo2(List<CHSAgreementMGTVO> chsagreementmgtvo2) {
		this.chsagreementmgtvo2 = chsagreementmgtvo2;
	}

	/**
	 * @return the chsagreementmgtvo3
	 */
	public List<CHSAgreementMGTVO> getChsagreementmgtvo3() {
		return chsagreementmgtvo3;
	}

	/**
	 * @param chsagreementmgtvo3 the chsagreementmgtvo3 to set
	 */
	public void setChsagreementmgtvo3(List<CHSAgreementMGTVO> chsagreementmgtvo3) {
		this.chsagreementmgtvo3 = chsagreementmgtvo3;
	}

	/**
	 * @return the chsagreementmgtvo4
	 */
	public List<CHSAgreementMGTVO> getChsagreementmgtvo4() {
		return chsagreementmgtvo4;
	}

	/**
	 * @param chsagreementmgtvo4 the chsagreementmgtvo4 to set
	 */
	public void setChsagreementmgtvo4(List<CHSAgreementMGTVO> chsagreementmgtvo4) {
		this.chsagreementmgtvo4 = chsagreementmgtvo4;
	}

	/**
	 * @return the chsagreementmgtvo5
	 */
	public List<CHSAgreementMGTVO> getChsagreementmgtvo5() {
		return chsagreementmgtvo5;
	}

	/**
	 * @param chsagreementmgtvo5 the chsagreementmgtvo5 to set
	 */
	public void setChsagreementmgtvo5(List<CHSAgreementMGTVO> chsagreementmgtvo5) {
		this.chsagreementmgtvo5 = chsagreementmgtvo5;
	}
    
    
    
}
