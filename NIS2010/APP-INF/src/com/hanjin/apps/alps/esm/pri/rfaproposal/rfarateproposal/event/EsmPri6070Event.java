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
=========================================================
* History
* [CHM-201534517] 1월 소스 보안 결함 건 조치 요청
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.event;

import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.profitabilitysimulation.vo.InpPrsSurchargeDetailApplicableRouteVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriRpScpRtScgVO;


/**
 * ESM_PRI_6070 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_6070HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SONG MIN SEOK
 * @see ESM_PRI_6018HTMLAction 참조
 * @since J2EE 1.6
 */
 
public class EsmPri6070Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	 
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriRpScpRtScgVO priRpScpRtScgVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriRpScpRtScgVO[] priRpScpRtScgVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private InpPrsSurchargeDetailApplicableRouteVO inpPrsSurchargeDetailApplicableRouteVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private InpPrsSurchargeDetailApplicableRouteVO[] inpPrsSurchargeDetailApplicableRouteVOs = null;

	public EsmPri6070Event(){}
	 
	public void setPriRpScpRtScgVO(PriRpScpRtScgVO priRpScpRtScgVO){
		this. priRpScpRtScgVO = priRpScpRtScgVO;
	}

	public void setPriRpScpRtScgVOS(PriRpScpRtScgVO[] priRpScpRtScgVOs){
		if(priRpScpRtScgVOs != null){
			PriRpScpRtScgVO[] tmpVOs = new PriRpScpRtScgVO[priRpScpRtScgVOs.length];
			System.arraycopy(priRpScpRtScgVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priRpScpRtScgVOs = tmpVOs;
		}
	}
	 

	public void setInpPrsSurchargeDetailApplicableRouteVO(InpPrsSurchargeDetailApplicableRouteVO inpPrsSurchargeDetailApplicableRouteVO){
		this. inpPrsSurchargeDetailApplicableRouteVO = inpPrsSurchargeDetailApplicableRouteVO;
	}

	public void setInpPrsSurchargeDetailApplicableRouteVOS(InpPrsSurchargeDetailApplicableRouteVO[] inpPrsSurchargeDetailApplicableRouteVOs){
		if(inpPrsSurchargeDetailApplicableRouteVOs != null){
			InpPrsSurchargeDetailApplicableRouteVO[] tmpVOs = new InpPrsSurchargeDetailApplicableRouteVO[inpPrsSurchargeDetailApplicableRouteVOs.length];
			System.arraycopy(inpPrsSurchargeDetailApplicableRouteVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.inpPrsSurchargeDetailApplicableRouteVOs = tmpVOs;
		}
	}
	 
	public PriRpScpRtScgVO getPriRpScpRtScgVO(){
		return priRpScpRtScgVO;
	}

	public PriRpScpRtScgVO[] getPriRpScpRtScgVOS(){
		PriRpScpRtScgVO[] rtnVOs = null;
		if (this.priRpScpRtScgVOs != null) {
			rtnVOs = new PriRpScpRtScgVO[priRpScpRtScgVOs.length];
			System.arraycopy(priRpScpRtScgVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	 
	
	
	public InpPrsSurchargeDetailApplicableRouteVO getInpPrsSurchargeDetailApplicableRouteVO(){
		return inpPrsSurchargeDetailApplicableRouteVO;
	}

	public InpPrsSurchargeDetailApplicableRouteVO[] getInpPrsSurchargeDetailApplicableRouteVOS(){
		InpPrsSurchargeDetailApplicableRouteVO[] rtnVOs = null;
		if (this.inpPrsSurchargeDetailApplicableRouteVOs != null) {
			rtnVOs = new InpPrsSurchargeDetailApplicableRouteVO[inpPrsSurchargeDetailApplicableRouteVOs.length];
			System.arraycopy(inpPrsSurchargeDetailApplicableRouteVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

}