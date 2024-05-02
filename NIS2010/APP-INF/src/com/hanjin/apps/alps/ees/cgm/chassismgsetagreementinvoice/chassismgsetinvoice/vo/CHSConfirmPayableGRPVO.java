/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OnOffHireAuditGroupVO.java
*@FileTitle : OnOffHireAuditGroupVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.20
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2010.07.20 장준우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo;

import java.util.List;

import org.apache.log4j.Logger;


/**
 * Search Param VO Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 장준우
 * @since J2EE 1.6
 * @see OnOffHireAuditDetailVO, OnOffHireAuditSearchVO
 */
public class CHSConfirmPayableGRPVO {

	private static final long serialVersionUID = 1L;

	private Logger log = Logger.getLogger("com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo");


	/** Table Value Object Multi Data 처리 */
	/** 샤시용 */
	private  List<List<CHSConfirmPayableAmountMGTVO>> cHSConfirmPayableAmountMGTVOs = null;
	/** MG Set 용 */
    private  List<List<MGSConfirmPayableAmountMGTVO>> mGSConfirmPayableAmountMGTVOs = null;

	public List<List<MGSConfirmPayableAmountMGTVO>> getmGSConfirmPayableAmountMGTVOs() {
		return mGSConfirmPayableAmountMGTVOs;
	}


	public void setmGSConfirmPayableAmountMGTVOs(
			List<List<MGSConfirmPayableAmountMGTVO>> mGSConfirmPayableAmountMGTVOs) {
		this.mGSConfirmPayableAmountMGTVOs = mGSConfirmPayableAmountMGTVOs;
	}


	public List<List<CHSConfirmPayableAmountMGTVO>> getcHSConfirmPayableAmountMGTVOs() {
		return cHSConfirmPayableAmountMGTVOs;
	}


	public void setcHSConfirmPayableAmountMGTVOs(
			List<List<CHSConfirmPayableAmountMGTVO>> cHSConfirmPayableAmountMGTVOs) {
		this.cHSConfirmPayableAmountMGTVOs = cHSConfirmPayableAmountMGTVOs;
	}


}
