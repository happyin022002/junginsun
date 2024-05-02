/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri000305Event.java
*@FileTitle : S/C Proposal Origin/Destination IHC Charge-Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.22
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.05.22 김재연
* 1.0 Creation
* 
* 2012.02.23 이석준[CHM-201216153-01] S/C Amendment History 화면 기능 개선 요청
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.sctransportationadditionalchargeproposal.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriSpScpTrspAddChgVO;
import com.hanjin.apps.alps.esm.pri.scproposal.sctransportationadditionalchargeproposal.vo.ChkFontStyleVO;
import com.hanjin.apps.alps.esm.pri.scproposal.sctransportationadditionalchargeproposal.vo.CstPriSpScpTrspAddChgVO;
import com.hanjin.apps.alps.esm.pri.scproposal.sctransportationadditionalchargeproposal.vo.RsltIhcChgListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.PriSpHistoryInquiryParamVO;

/**
 * ESM_PRI_0003_05 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_0003_05HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author JaeYeon Kim
 * @see ESM_PRI_0003_05HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri005715Event extends EventSupport {

private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSpScpTrspAddChgVO priSpScpTrspAddChgVO = null;
	private CstPriSpScpTrspAddChgVO cstPriSpScpTrspAddChgVO = null;
	private ChkFontStyleVO chkFontStyleVO = null;
	 
	/** Table Value Object Multi Data 처리 */
	private PriSpScpTrspAddChgVO[] priSpScpTrspAddChgVOs = null;
	private RsltIhcChgListVO[] rsltIhcChgListVOs = null;
	private PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO = null;
	
	public EsmPri005715Event(){}
	
	public void setPriSpScpTrspAddChgVO(PriSpScpTrspAddChgVO priSpScpTrspAddChgVO){
		this. priSpScpTrspAddChgVO = priSpScpTrspAddChgVO;
	}

	public void setPriSpScpTrspAddChgVOS(PriSpScpTrspAddChgVO[] priSpScpTrspAddChgVOs){
		this. priSpScpTrspAddChgVOs = priSpScpTrspAddChgVOs;
	}
	
	public void setRsltIhcChgListVOS(RsltIhcChgListVO[] rsltIhcChgListVOs){
		this. rsltIhcChgListVOs = rsltIhcChgListVOs;
	}
	
	public PriSpScpTrspAddChgVO getPriSpScpTrspAddChgVO(){
		return priSpScpTrspAddChgVO;
	}

	public PriSpScpTrspAddChgVO[] getPriSpScpTrspAddChgVOS(){
		return priSpScpTrspAddChgVOs;
	}
	
	public RsltIhcChgListVO[] getRsltIhcChgListVOS(){
		return rsltIhcChgListVOs;
	}
	
	public void setCstPriSpScpTrspAddChgVO(CstPriSpScpTrspAddChgVO cstPriSpScpTrspAddChgVO){
		this. cstPriSpScpTrspAddChgVO = cstPriSpScpTrspAddChgVO;
	}
	
	public CstPriSpScpTrspAddChgVO getCstPriSpScpTrspAddChgVO(){
		return cstPriSpScpTrspAddChgVO;
	}
	
	public void setChkFontStyleVO(ChkFontStyleVO chkFontStyleVO) {
		this. chkFontStyleVO = chkFontStyleVO;
	}
	
	public ChkFontStyleVO getChkFontStyleVO() {
		return chkFontStyleVO;
	}

	public PriSpHistoryInquiryParamVO getPriSpHistoryInquiryParamVO() {
		return priSpHistoryInquiryParamVO;
	}

	public void setPriSpHistoryInquiryParamVO(
			PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO) {
		this.priSpHistoryInquiryParamVO = priSpHistoryInquiryParamVO;
	}
	
	
}