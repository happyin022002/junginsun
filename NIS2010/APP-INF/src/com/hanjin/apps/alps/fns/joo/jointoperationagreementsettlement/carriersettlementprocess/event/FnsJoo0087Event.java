/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : FnsJoo0087Event.java
*@FileTitle : Intergrated Loging Summary Report
*Open Issues :
*Change history :
*@LastModifyDate : 2012.01.25
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.01.26 김영오
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.event;

import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.IntloadSumReportVO;
import com.hanjin.framework.support.layer.event.EventSupport;

 
/**
 * FNS_JOO_0087 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_JOO_0087HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Young Oh
 * @see FNS_JOO_0087HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsJoo0087Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private IntloadSumReportVO intloadSumReportVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private IntloadSumReportVO[] intloadSumReportVOs = null;

	public FnsJoo0087Event(){}

	public IntloadSumReportVO getIntloadSumReportVO() {
		return intloadSumReportVO;
	}

	public void setIntloadSumReportVO(IntloadSumReportVO intloadSumReportVO) {
		this.intloadSumReportVO = intloadSumReportVO;
	}

	public IntloadSumReportVO[] getIntloadSumReportVOs() {
		IntloadSumReportVO[] rtnVOs = null;
		if (this.intloadSumReportVOs != null) {
			rtnVOs = new IntloadSumReportVO[intloadSumReportVOs.length];
			System.arraycopy(intloadSumReportVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;		
	}

	public void setIntloadSumReportVOs(IntloadSumReportVO[] intloadSumReportVOs) {
		if (intloadSumReportVOs != null) {
			IntloadSumReportVO[] tmpVOs = new IntloadSumReportVO[intloadSumReportVOs.length];
			System.arraycopy(intloadSumReportVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.intloadSumReportVOs = tmpVOs;
		}		
	}
}