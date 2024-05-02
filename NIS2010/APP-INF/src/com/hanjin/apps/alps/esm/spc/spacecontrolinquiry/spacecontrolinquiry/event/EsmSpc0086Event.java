/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmSpc0086Event.java
*@FileTitle : dailyforecastmanage
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.21
*@LastModifier : 한상훈
*@LastVersion : 1.0
* 2009.08.21 한상훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.event;

import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiryConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.SpcTgtVvdVO;


/**
 * ESM_SPC_0103 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SPC_0086HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Han Sang Hoon
 * @see ESM_SPC_0086HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSpc0086Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchSpaceControlInquiryConditionVO[] searchSpaceControlInquiryConditionVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SpcTgtVvdVO spcTgtVvdVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SpcTgtVvdVO[] spcTgtVvdVOs = null;
	
	private String vvd;

	public EsmSpc0086Event(){}

	/**
	 * @return the searchSpaceControlInquiryConditionVO
	 */
	public SearchSpaceControlInquiryConditionVO getSearchSpaceControlInquiryConditionVO() {
		return searchSpaceControlInquiryConditionVO;
	}

	/**
	 * @param searchSpaceControlInquiryConditionVO the searchSpaceControlInquiryConditionVO to set
	 */
	public void setSearchSpaceControlInquiryConditionVO(
			SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO) {
		this.searchSpaceControlInquiryConditionVO = searchSpaceControlInquiryConditionVO;
	}

	/**
	 * @return the searchSpaceControlInquiryConditionVOs
	 */
	public SearchSpaceControlInquiryConditionVO[] getSearchSpaceControlInquiryConditionVOs() {
		SearchSpaceControlInquiryConditionVO[] rtnVOs = null;
		if (this.searchSpaceControlInquiryConditionVOs != null) {
			rtnVOs = new SearchSpaceControlInquiryConditionVO[searchSpaceControlInquiryConditionVOs.length];
			System.arraycopy(searchSpaceControlInquiryConditionVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;	
	}

	/**
	 * @param searchSpaceControlInquiryConditionVOs the searchSpaceControlInquiryConditionVOs to set
	 */
	public void setSearchSpaceControlInquiryConditionVOs(
			SearchSpaceControlInquiryConditionVO[] searchSpaceControlInquiryConditionVOs) {
		if (searchSpaceControlInquiryConditionVOs != null) {
			SearchSpaceControlInquiryConditionVO[] tmpVOs = new SearchSpaceControlInquiryConditionVO[searchSpaceControlInquiryConditionVOs.length];
			System.arraycopy(searchSpaceControlInquiryConditionVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.searchSpaceControlInquiryConditionVOs = tmpVOs;
		}

	}

	/**
	 * @return the spcTgtVvdVO
	 */
	public SpcTgtVvdVO getSpcTgtVvdVO() {
		return spcTgtVvdVO;
	}

	/**
	 * @param spcTgtVvdVO the spcTgtVvdVO to set
	 */
	public void setSpcTgtVvdVO(SpcTgtVvdVO spcTgtVvdVO) {
		this.spcTgtVvdVO = spcTgtVvdVO;
	}

	/**
	 * @return the spcTgtVvdVOs
	 */
	public SpcTgtVvdVO[] getSpcTgtVvdVOs() {
		SpcTgtVvdVO[] rtnVOs = null;
		if (this.spcTgtVvdVOs != null) {
			rtnVOs = new SpcTgtVvdVO[spcTgtVvdVOs.length];
			System.arraycopy(spcTgtVvdVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;	
	}

	/**
	 * @param spcTgtVvdVOs the spcTgtVvdVOs to set
	 */
	public void setSpcTgtVvdVOs(SpcTgtVvdVO[] spcTgtVvdVOs) {
		if (spcTgtVvdVOs != null) {
			SpcTgtVvdVO[] tmpVOs = new SpcTgtVvdVO[spcTgtVvdVOs.length];
			System.arraycopy(spcTgtVvdVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.spcTgtVvdVOs = tmpVOs;
		}
	}

	/**
	 * @return the vvd
	 */
	public String getVvd() {
		return vvd;
	}

	/**
	 * @param vvd the vvd to set
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}

	
	
	

}