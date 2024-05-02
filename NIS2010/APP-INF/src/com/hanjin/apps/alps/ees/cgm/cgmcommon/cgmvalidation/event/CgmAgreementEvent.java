/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CgmAgreementEvent.java
*@FileTitle : AGREEMENT chk
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.15
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.06.15 최민회
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmvalidation.event;

import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmvalidation.vo.AgrementINVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmvalidation.vo.AgrementMGTVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * CGM_AGREEMENT 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  CGM_AGREEMENTHTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CHOI MIN HOI
 * @see CGM_AGREEMENT_HTMLAction 참조
 * @since J2EE 1.6
 */

public class CgmAgreementEvent extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private AgrementINVO agrementINVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리 */
	private AgrementMGTVO agrementMGTVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private AgrementMGTVO[] agrementMGTVOs = null;
	
	/**
	 * @return the agrementMGTVOs
	 */
	public AgrementMGTVO[] getAgrementMGTVOs() {
		return agrementMGTVOs;
	}

	/**
	 * @param agrementMGTVOs the agrementMGTVOs to set
	 */
	public void setAgrementMGTVOs(AgrementMGTVO[] agrementMGTVOs) {
		this.agrementMGTVOs = agrementMGTVOs;
	}

	/**
	 * @return the agrementMGTVO
	 */
	public AgrementMGTVO getAgrementMGTVO() {
		return agrementMGTVO;
	}

	/**
	 * @param agrementMGTVO the agrementMGTVO to set
	 */
	public void setAgrementMGTVO(AgrementMGTVO agrementMGTVO) {
		this.agrementMGTVO = agrementMGTVO;
	}

	public CgmAgreementEvent(){}

	/**
	 * @return the agrementINVO
	 */
	public AgrementINVO getAgrementINVO() {
		return agrementINVO;
	}

	/**
	 * @param agrementINVO the agrementINVO to set
	 */
	public void setAgrementINVO(AgrementINVO agrementINVO) {
		this.agrementINVO = agrementINVO;
	}
	


}