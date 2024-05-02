/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CHSCpsAgreementGroupVO.java
*@FileTitle : CHSCpsAgreementGroupVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.21
*@LastModifier : 이영헌
*@LastVersion : 1.0
* 2013.03.21 이영헌 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo;

import java.util.List;
import java.util.Map;

import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 이영헌
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class CHSCpsAgreementGroupVO {
	
	public String[] getHead() {
		return head;
	}

	public void setHead(String[] head) {
		this.head = head;
	}
	
    private String[] head = null;

    private  Map<String, String> etcData = null;
    
    private List<CHSCpsAgreementMGTVO> chsCpsAgreementMGTVO  = null;
    private List<CHSCpsAgreementMGTVO> chsCpsAgreementMGTVO2 = null;
    private List<CHSCpsAgreementMGTVO> chsCpsAgreementMGTVO3 = null;
    
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
	 * @return the chsCpsAgreementMGTVO
	 */
	public List<CHSCpsAgreementMGTVO> getChsCpsAgreementMGTVO() {
		return chsCpsAgreementMGTVO;
	}

	/**
	 * @param chsCpsAgreementMGTVO the chsCpsAgreementMGTVO to set
	 */
	public void setChsCpsAgreementMGTVO(List<CHSCpsAgreementMGTVO> chsCpsAgreementMGTVO) {
		this.chsCpsAgreementMGTVO = chsCpsAgreementMGTVO;
	}

	/**
	 * @return the chsCpsAgreementMGTVO2
	 */
	public List<CHSCpsAgreementMGTVO> getChsCpsAgreementMGTVO2() {
		return chsCpsAgreementMGTVO2;
	}

	/**
	 * @param chsCpsAgreementMGTVO2 the chsCpsAgreementMGTVO2 to set
	 */
	public void setChsCpsAgreementMGTVO2(List<CHSCpsAgreementMGTVO> chsCpsAgreementMGTVO2) {
		this.chsCpsAgreementMGTVO2 = chsCpsAgreementMGTVO2;
	}

	/**
	 * @return the chsCpsAgreementMGTVO3
	 */
	public List<CHSCpsAgreementMGTVO> getChsCpsAgreementMGTVO3() {
		return chsCpsAgreementMGTVO3;
	}

	/**
	 * @param chsCpsAgreementMGTVO3 the chsCpsAgreementMGTVO3 to set
	 */
	public void setChsCpsAgreementMGTVO3(List<CHSCpsAgreementMGTVO> chsCpsAgreementMGTVO3) {
		this.chsCpsAgreementMGTVO3 = chsCpsAgreementMGTVO3;
	}
}