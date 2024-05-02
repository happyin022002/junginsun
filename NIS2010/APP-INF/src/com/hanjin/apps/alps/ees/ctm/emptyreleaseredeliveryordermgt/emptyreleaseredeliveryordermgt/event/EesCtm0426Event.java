/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCtm0426Event.java
*@FileTitle : Release/Re-delivery Order
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.27
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2009.07.27 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.event;

import com.hanjin.apps.alps.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.vo.CimCStockVO;
import com.hanjin.apps.alps.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.vo.RDFaxMailEAIVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * EES_CTM_0426 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CTM_0426HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM, Sang Soo
 * @see EES_CTM_0426HTMLAction 참조
 * @since J2EE 1.6
 */
public class EesCtm0426Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CimCStockVO cimCStockVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CimCStockVO[] cimCStockVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private RDFaxMailEAIVO rdFaxMailEAIVO = null;
	
	public EesCtm0426Event(){}
	
	public void setCimCStockVO(CimCStockVO cimCStockVO){
		this. cimCStockVO = cimCStockVO;
	}

	public void setCimCStockVOS(CimCStockVO[] cimCStockVOs){
		this. cimCStockVOs = cimCStockVOs;
	}

	public void setRDFaxMailEAIVO(RDFaxMailEAIVO rdFaxMailEAIVO){
		this. rdFaxMailEAIVO = rdFaxMailEAIVO;
	}

	public CimCStockVO getCimCStockVO(){
		return cimCStockVO;
	}

	public CimCStockVO[] getCimCStockVOS(){
		return cimCStockVOs;
	}

	public RDFaxMailEAIVO getRDFaxMailEAIVO(){
		return rdFaxMailEAIVO;
	}

}