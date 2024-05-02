/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCgm2012Event.java
*@FileTitle : On & Off-Hire Status Summary Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.02
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.06.02 최민회
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.event;

import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSOnOffhireSummaryINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSOnOffhireSummaryMGTVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * EES_CGM_2012 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CGM_2012HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CHOI MIN HOI
 * @see EES_CGM_2012HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesCgm2012Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MGSOnOffhireSummaryMGTVO mgsOnOffhireSummaryMGTVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private MGSOnOffhireSummaryMGTVO[] mgsOnOffhireSummaryMGTVOs = null;
	
	/** Table Value Object 조회 조건    */
	private MGSOnOffhireSummaryINVO mgsOnOffhireSummaryINVO = null;

	public EesCgm2012Event(){}
	
	/**
	 * @return the MGSOnOffhireSummaryINVO
	 */
	public MGSOnOffhireSummaryINVO getMGSOnOffhireSummaryINVO() {
		return mgsOnOffhireSummaryINVO;
	}

	/**
	 * @param OnOffhireSummaryINVO the MGSOnOffhireSummaryINVO to set
	 */
	public void setMGSOnOffhireSummaryINVO(
			MGSOnOffhireSummaryINVO mgsOnOffhireSummaryINVO) {
		this.mgsOnOffhireSummaryINVO = mgsOnOffhireSummaryINVO;
	}

	public void setMGSOnOffhireSummaryMGTVO(MGSOnOffhireSummaryMGTVO mgsOnOffhireSummaryMGTVO){
		this. mgsOnOffhireSummaryMGTVO = mgsOnOffhireSummaryMGTVO;
	}

	public void setMGSOnOffhireSummaryMGTVOS(MGSOnOffhireSummaryMGTVO[] mgsOnOffhireSummaryMGTVOs){
		this. mgsOnOffhireSummaryMGTVOs = mgsOnOffhireSummaryMGTVOs;
	}

	public MGSOnOffhireSummaryMGTVO getMGSOnOffhireSummaryMGTVO(){
		return mgsOnOffhireSummaryMGTVO;
	}

	public MGSOnOffhireSummaryMGTVO[] getMGSOnOffhireSummaryMGTVOS(){
		return mgsOnOffhireSummaryMGTVOs;
	}

}