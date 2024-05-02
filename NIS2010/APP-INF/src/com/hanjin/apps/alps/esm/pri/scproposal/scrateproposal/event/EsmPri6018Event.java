/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri6018Event.java
*@FileTitle : PRS-Surcharge Detail
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.02
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2009.07.02 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.event;

import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.profitabilitysimulation.vo.InpPrsSurchargeDetailApplicableRouteVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriRpScpRtScgVO;
import com.hanjin.syscommon.common.table.PriRqRtScgVO;
import com.hanjin.syscommon.common.table.PriSpScpRtScgVO;
import com.hanjin.syscommon.common.table.PriSqRtScgVO;


/**
 * ESM_PRI_6018 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_6018HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SONG MIN SEOK
 * @see ESM_PRI_6018HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri6018Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSpScpRtScgVO priSpScpRtScgVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriSpScpRtScgVO[] priSpScpRtScgVOs = null;
	  
	 

	/** Table Value Object 조회 조건 및 단건 처리  */
	private InpPrsSurchargeDetailApplicableRouteVO inpPrsSurchargeDetailApplicableRouteVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private InpPrsSurchargeDetailApplicableRouteVO[] inpPrsSurchargeDetailApplicableRouteVOs = null;

	public EsmPri6018Event(){}
	
	
	
	public void setPriSpScpRtScgVO(PriSpScpRtScgVO priSpScpRtScgVO){
		this. priSpScpRtScgVO = priSpScpRtScgVO;
	}

	public void setPriSpScpRtScgVOS(PriSpScpRtScgVO[] priSpScpRtScgVOs){
		this. priSpScpRtScgVOs = priSpScpRtScgVOs;
	}
	 

	public void setInpPrsSurchargeDetailApplicableRouteVO(InpPrsSurchargeDetailApplicableRouteVO inpPrsSurchargeDetailApplicableRouteVO){
		this. inpPrsSurchargeDetailApplicableRouteVO = inpPrsSurchargeDetailApplicableRouteVO;
	}

	public void setInpPrsSurchargeDetailApplicableRouteVOS(InpPrsSurchargeDetailApplicableRouteVO[] inpPrsSurchargeDetailApplicableRouteVOs){
		this. inpPrsSurchargeDetailApplicableRouteVOs = inpPrsSurchargeDetailApplicableRouteVOs;
	}
	
	public PriSpScpRtScgVO getPriSpScpRtScgVO(){
		return priSpScpRtScgVO;
	}

	public PriSpScpRtScgVO[] getPriSpScpRtScgVOS(){
		return priSpScpRtScgVOs;
	}
 
	
	
	public InpPrsSurchargeDetailApplicableRouteVO getInpPrsSurchargeDetailApplicableRouteVO(){
		return inpPrsSurchargeDetailApplicableRouteVO;
	}

	public InpPrsSurchargeDetailApplicableRouteVO[] getInpPrsSurchargeDetailApplicableRouteVOS(){
		return inpPrsSurchargeDetailApplicableRouteVOs;
	}

}