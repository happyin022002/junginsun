/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri005704Event.java
*@FileTitle : Amendment History Inquiry - Origin/Destination
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.04
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.09.04 최성민
* 1.0 Creation
* 
* 2012.02.23 이석준[CHM-201216153-01] S/C Amendment History 화면 기능 개선 요청
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scroutepointproposal.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.pri.scproposal.scroutepointproposal.vo.RsltRoutPntLocListVO;
import com.hanjin.syscommon.common.table.PriSpScpRoutPntVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.PriSpHistoryInquiryParamVO;


/**
 * ESM_PRI_0057_04 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_0057_04HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CHOI SUNG MIN
 * @see ESM_PRI_0057_04HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri005704Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltRoutPntLocListVO rsltRoutPntLocListVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSpScpRoutPntVO priSpScpRoutPntVO = null;
	private PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO = null;
	public EsmPri005704Event(){}
	
	public void setRsltRoutPntLocListVO(RsltRoutPntLocListVO rsltRoutPntLocListVO){
		this. rsltRoutPntLocListVO = rsltRoutPntLocListVO;
	}
 
	public void setPriSpScpRoutPntVO(PriSpScpRoutPntVO priSpScpRoutPntVO){
		this. priSpScpRoutPntVO = priSpScpRoutPntVO;
	}

	public RsltRoutPntLocListVO getRsltRoutPntLocListVO(){
		return rsltRoutPntLocListVO;
	}

	public PriSpScpRoutPntVO getPriSpScpRoutPntVO(){
		return priSpScpRoutPntVO;
	}

	public PriSpHistoryInquiryParamVO getPriSpHistoryInquiryParamVO() {
		return priSpHistoryInquiryParamVO;
	}

	public void setPriSpHistoryInquiryParamVO(
			PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO) {
		this.priSpHistoryInquiryParamVO = priSpHistoryInquiryParamVO;
	}

}