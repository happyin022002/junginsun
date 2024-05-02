/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCgm1010Event.java
*@FileTitle : On & Off-Hire Status Summary Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.29
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.05.29 최민회
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.event;

import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSOnOffhireSummaryINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSOnOffhireSummaryMGTVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_CGM_1010 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CGM_1010HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CHOI MIN HOI
 * @see EES_CGM_1010HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesCgm1010Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CHSOnOffhireSummaryMGTVO cHSOnOffhireSummaryMGTVO = null;
	
	/** Table Value Object 조회 조건    */
	private CHSOnOffhireSummaryINVO cHSOnOffhireSummaryINVO = null;
	
	/**
	 * @return the cHSOnOffhireSummaryIN
	 */
	public CHSOnOffhireSummaryINVO getCHSOnOffhireSummaryINVO() {
		return cHSOnOffhireSummaryINVO;
	}

	/**
	 * @param OnOffhireSummaryIN the cHSOnOffhireSummaryIN to set
	 */
	public void setCHSOnOffhireSummaryINVO(
			CHSOnOffhireSummaryINVO OnOffhireSummaryINVO) {
		cHSOnOffhireSummaryINVO = OnOffhireSummaryINVO;
	}

	/** Table Value Object Multi Data 처리 */
	private CHSOnOffhireSummaryMGTVO[] cHSOnOffhireSummaryMGTs = null;

	public EesCgm1010Event(){}
	
	public void setCHSOnOffhireSummaryMGT(CHSOnOffhireSummaryMGTVO cHSOnOffhireSummaryMGT){
		this. cHSOnOffhireSummaryMGTVO = cHSOnOffhireSummaryMGT;
	}

	public void setCHSOnOffhireSummaryMGTS(CHSOnOffhireSummaryMGTVO[] cHSOnOffhireSummaryMGTs){
		if(cHSOnOffhireSummaryMGTs != null){
			CHSOnOffhireSummaryMGTVO[] tmpVOs = java.util.Arrays.copyOf(cHSOnOffhireSummaryMGTs, cHSOnOffhireSummaryMGTs.length);
			this.cHSOnOffhireSummaryMGTs = tmpVOs;
		}
	}

	public CHSOnOffhireSummaryMGTVO getCHSOnOffhireSummaryMGT(){
		return cHSOnOffhireSummaryMGTVO;
	}

	public CHSOnOffhireSummaryMGTVO[] getCHSOnOffhireSummaryMGTS(){
		CHSOnOffhireSummaryMGTVO[] rtnVOs = null;
		if (this.cHSOnOffhireSummaryMGTs != null) {
			rtnVOs = java.util.Arrays.copyOf(cHSOnOffhireSummaryMGTs, cHSOnOffhireSummaryMGTs.length);
		}
		return rtnVOs;
	}

}