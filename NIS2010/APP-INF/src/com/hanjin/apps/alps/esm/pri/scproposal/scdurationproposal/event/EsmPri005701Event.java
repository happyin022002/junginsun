/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri005701Event.java
*@FileTitle : Duration
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.18
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.05.18 공백진
* 1.0 Creation
* 
* 2012.02.23 이석준[CHM-201216153-01] S/C Amendment History 화면 기능 개선 요청
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scdurationproposal.event;

import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.PriSpHistoryInquiryParamVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriSpScpDurVO;


/**
 * ESM_PRI_0057_01 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_0057_01HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kong Back Jin
 * @see ESM_PRI_0057_01HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri005701Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 저장시 사용되는 커스텀 VO */
	private PriSpScpDurVO priSpScpDurVO = null;
    private PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO = null;
	public PriSpScpDurVO getPriSpScpDurVO() {
		return priSpScpDurVO;
	}
	public void setPriSpScpDurVO(PriSpScpDurVO priSpScpDurVO) {
		this.priSpScpDurVO = priSpScpDurVO;
	}
	public PriSpHistoryInquiryParamVO getPriSpHistoryInquiryParamVO() {
		return priSpHistoryInquiryParamVO;
	}
	public void setPriSpHistoryInquiryParamVO(
			PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO) {
		this.priSpHistoryInquiryParamVO = priSpHistoryInquiryParamVO;
	}
    
     
    

	

}