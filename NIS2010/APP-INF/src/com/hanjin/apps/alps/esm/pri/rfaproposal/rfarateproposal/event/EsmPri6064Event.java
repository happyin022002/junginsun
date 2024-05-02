/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri6016Event.java
*@FileTitle : PRS-Cost Detail
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.13
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2009.07.13 송민석
* 1.0 Creation
=========================================================
* History
* [CHM-201534517] 1월 소스 보안 결함 건 조치 요청
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.event;

import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.InCostSimulationCheckRouteVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltPriPrsCostDetailVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltPriPrsCostListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.event.ESM_PRI_6016HTMLAction;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo.InPriPrsRoutCsVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriPrsRoutCsInfoVO;
import com.hanjin.syscommon.common.table.PriRpScpRtUsdRoutCsVO;


/**
 * ESM_PRI_6016 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_6016HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SONG MIN SEOK
 * @see ESM_PRI_6016HTMLAction 참조
 * @since J2EE 1.6
 */
 
public class EsmPri6064Event extends EventSupport {

	private static final long serialVersionUID = 1L;
 
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltPriPrsCostListVO rsltPriPrsCostListVO = null;
	
	private InPriPrsRoutCsVO inPriPrsRoutCsVO = null;
	private InCostSimulationCheckRouteVO inCostSimulationCheckRouteVO = null;
	private PriRpScpRtUsdRoutCsVO priRpScpRtUsdRoutCsVO= null;
	
	
	/** Table Value Object Multi Data 처리 */
	private RsltPriPrsCostListVO[] rsltPriPrsCostListVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltPriPrsCostDetailVO rsltPriPrsCostDetailVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private RsltPriPrsCostDetailVO[] rsltPriPrsCostDetailVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriPrsRoutCsInfoVO priPrsRoutCsInfoVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriPrsRoutCsInfoVO[] priPrsRoutCsInfoVOs = null;

	public EsmPri6064Event(){}
	
	public void setRsltPriPrsCostListVO(RsltPriPrsCostListVO rsltPriPrsCostListVO){
		this. rsltPriPrsCostListVO = rsltPriPrsCostListVO;
	}
	
	public void setInCostSimulationCheckRouteVO(InCostSimulationCheckRouteVO inCostSimulationCheckRouteVO){
		this. inCostSimulationCheckRouteVO = inCostSimulationCheckRouteVO;
	}
	
	public void setInPriPrsRoutCsVO(InPriPrsRoutCsVO inPriPrsRoutCsVO){
		this. inPriPrsRoutCsVO = inPriPrsRoutCsVO;
	}
	
	public void setPriRpScpRtUsdRoutCsVO(PriRpScpRtUsdRoutCsVO priRpScpRtUsdRoutCsVO){
		this. priRpScpRtUsdRoutCsVO = priRpScpRtUsdRoutCsVO;
	}
	

	public void setRsltPriPrsCostListVOS(RsltPriPrsCostListVO[] rsltPriPrsCostListVOs){
		if(rsltPriPrsCostListVOs != null){
			RsltPriPrsCostListVO[] tmpVOs = new RsltPriPrsCostListVO[rsltPriPrsCostListVOs.length];
			System.arraycopy(rsltPriPrsCostListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.rsltPriPrsCostListVOs = tmpVOs;
		}
	}

	public void setRsltPriPrsCostDetailVO(RsltPriPrsCostDetailVO rsltPriPrsCostDetailVO){
		this. rsltPriPrsCostDetailVO = rsltPriPrsCostDetailVO;
	}

	public void setRsltPriPrsCostDetailVOS(RsltPriPrsCostDetailVO[] rsltPriPrsCostDetailVOs){
		if(rsltPriPrsCostDetailVOs != null){
			RsltPriPrsCostDetailVO[] tmpVOs = new RsltPriPrsCostDetailVO[rsltPriPrsCostDetailVOs.length];
			System.arraycopy(rsltPriPrsCostDetailVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.rsltPriPrsCostDetailVOs = tmpVOs;
		}
	}

	public void setPriPrsRoutCsInfoVO(PriPrsRoutCsInfoVO priPrsRoutCsInfoVO){
		this. priPrsRoutCsInfoVO = priPrsRoutCsInfoVO;
	}

	public void setPriPrsRoutCsInfoVOS(PriPrsRoutCsInfoVO[] priPrsRoutCsInfoVOs){
		if(priPrsRoutCsInfoVOs != null){
			PriPrsRoutCsInfoVO[] tmpVOs = new PriPrsRoutCsInfoVO[priPrsRoutCsInfoVOs.length];
			System.arraycopy(priPrsRoutCsInfoVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priPrsRoutCsInfoVOs = tmpVOs;
		}
	}

	public RsltPriPrsCostListVO getRsltPriPrsCostListVO(){
		return rsltPriPrsCostListVO;
	}
	
	public InCostSimulationCheckRouteVO getInCostSimulationCheckRouteVO(){
		return inCostSimulationCheckRouteVO;
	}
	public InPriPrsRoutCsVO getInPriPrsRoutCsVO(){
		return inPriPrsRoutCsVO;
	}
	public PriRpScpRtUsdRoutCsVO getPriRpScpRtUsdRoutCsVO(){
		return priRpScpRtUsdRoutCsVO;
	}

	public RsltPriPrsCostListVO[] getRsltPriPrsCostListVOS(){
		RsltPriPrsCostListVO[] rtnVOs = null;
		if (this.rsltPriPrsCostListVOs != null) {
			rtnVOs = new RsltPriPrsCostListVO[rsltPriPrsCostListVOs.length];
			System.arraycopy(rsltPriPrsCostListVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public RsltPriPrsCostDetailVO getRsltPriPrsCostDetailVO(){
		return rsltPriPrsCostDetailVO;
	}

	public RsltPriPrsCostDetailVO[] getRsltPriPrsCostDetailVOS(){
		RsltPriPrsCostDetailVO[] rtnVOs = null;
		if (this.rsltPriPrsCostDetailVOs != null) {
			rtnVOs = new RsltPriPrsCostDetailVO[rsltPriPrsCostDetailVOs.length];
			System.arraycopy(rsltPriPrsCostDetailVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public PriPrsRoutCsInfoVO getPriPrsRoutCsInfoVO(){
		return priPrsRoutCsInfoVO;
	}

	public PriPrsRoutCsInfoVO[] getPriPrsRoutCsInfoVOS(){
		PriPrsRoutCsInfoVO[] rtnVOs = null;
		if (this.priPrsRoutCsInfoVOs != null) {
			rtnVOs = new PriPrsRoutCsInfoVO[priPrsRoutCsInfoVOs.length];
			System.arraycopy(priPrsRoutCsInfoVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
 
}