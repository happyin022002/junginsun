/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MdmCurrencyEvent.java
*@FileTitle : curr_cd check
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.07
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.09.07 최민회
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmvalidation.event;

import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmvalidation.vo.MdmCurrencyMGTVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * MDM_CURRENCY 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  MDM_CURRENCYHTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CHOI MIN HOI
 * @see CGM_CURRENCYHTMLAction 참조
 * @since J2EE 1.6
 */

public class CgmCurrencyEvent extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MdmCurrencyMGTVO mdmCurrencyMGTVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private MdmCurrencyMGTVO[] mdmCurrencyMGTVOs = null;

	public CgmCurrencyEvent(){}

	/**
	 * @return the mdmCurrencyMGTVO
	 */
	public MdmCurrencyMGTVO getMdmCurrencyMGTVO() {
		return mdmCurrencyMGTVO;
	}

	/**
	 * @param mdmCurrencyMGTVO the mdmCurrencyMGTVO to set
	 */
	public void setMdmCurrencyMGTVO(MdmCurrencyMGTVO mdmCurrencyMGTVO) {
		this.mdmCurrencyMGTVO = mdmCurrencyMGTVO;
	}

	/**
	 * @return the mdmCurrencyMGTVOs
	 */
	public MdmCurrencyMGTVO[] getMdmCurrencyMGTVOs() {
		return mdmCurrencyMGTVOs;
	}

	/**
	 * @param mdmCurrencyMGTVOs the mdmCurrencyMGTVOs to set
	 */
	public void setMdmCurrencyMGTVOs(MdmCurrencyMGTVO[] mdmCurrencyMGTVOs) {
		this.mdmCurrencyMGTVOs = mdmCurrencyMGTVOs;
	}
	


}