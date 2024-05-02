/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCtm0451Event.java
*@FileTitle : Release/Re-delivery Order
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.27
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2009.07.27 김상수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.event;

import com.clt.apps.opus.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.vo.CimCStockVO;
import com.clt.apps.opus.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.vo.RDFaxMailEAIVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.ProcSettlementVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_CTM_0451 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CTM_0451HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM, Sang Soo
 * @see EES_CTM_0451HTMLAction 참조
 * @since J2EE 1.6
 */
public class EesCtm0451Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private CimCStockVO cimCStockVO = null;

	/** Table Value Object Multi Data 처리 */
	private CimCStockVO[] cimCStockVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private RDFaxMailEAIVO rdFaxMailEAIVO = null;

	public EesCtm0451Event(){}

	public void setCimCStockVO(CimCStockVO cimCStockVO){
		this. cimCStockVO = cimCStockVO;
	}

	public void setCimCStockVOS(CimCStockVO[] cimCStockVOs){
		if (cimCStockVOs != null) {
			CimCStockVO[] tmpVOs = new CimCStockVO[cimCStockVOs.length];
			System.arraycopy(cimCStockVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.cimCStockVOs = tmpVOs;
		}
	}

	public void setRDFaxMailEAIVO(RDFaxMailEAIVO rdFaxMailEAIVO){
		this. rdFaxMailEAIVO = rdFaxMailEAIVO;
	}

	public CimCStockVO getCimCStockVO(){
		return cimCStockVO;
	}

	public CimCStockVO[] getCimCStockVOS(){
		CimCStockVO[] tmpVOs = null;
		if (this.cimCStockVOs != null) {
			tmpVOs = new CimCStockVO[cimCStockVOs.length];
			System.arraycopy(cimCStockVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public RDFaxMailEAIVO getRDFaxMailEAIVO(){
		return rdFaxMailEAIVO;
	}

}