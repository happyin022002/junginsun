/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri6062Event.java
*@FileTitle : PRS-Cost Detail
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.13
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2009.07.13 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.event;

import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo.InPriPrsRoutCsVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.InCostSimulationCheckRouteVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.RsltPriPrsCostDetailVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.RsltPriPrsCostListVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriPrsRoutCsInfoVO;
import com.hanjin.syscommon.common.table.PriSqRtUsdRoutCsVO;


/**
 * ESM_PRI_6062 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_6062HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SONG MIN SEOK
 * @see ESM_PRI_6062HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri6062Event extends EventSupport {

	private static final long serialVersionUID = 1L;
 
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltPriPrsCostListVO rsltPriPrsCostListVO = null;
	
	private InCostSimulationCheckRouteVO inCostSimulationCheckRouteVO = null;
	private InPriPrsRoutCsVO inPriPrsRoutCsVO = null;

	private PriSqRtUsdRoutCsVO priSqRtUsdRoutCsVO= null;
	
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

	public EsmPri6062Event(){}
	
	public void setRsltPriPrsCostListVO(RsltPriPrsCostListVO rsltPriPrsCostListVO){
		this. rsltPriPrsCostListVO = rsltPriPrsCostListVO;
	}
	
	public void setInCostSimulationCheckRouteVO(InCostSimulationCheckRouteVO inCostSimulationCheckRouteVO){
		this. inCostSimulationCheckRouteVO = inCostSimulationCheckRouteVO;
	}
	public void setInPriPrsRoutCsVO(InPriPrsRoutCsVO inPriPrsRoutCsVO){
		this. inPriPrsRoutCsVO = inPriPrsRoutCsVO;
	}
	
	public void setPriSqRtUsdRoutCsVO(PriSqRtUsdRoutCsVO priSqRtUsdRoutCsVO){
		this. priSqRtUsdRoutCsVO = priSqRtUsdRoutCsVO;
	}

	public void setRsltPriPrsCostListVOS(RsltPriPrsCostListVO[] rsltPriPrsCostListVOs){
		this. rsltPriPrsCostListVOs = rsltPriPrsCostListVOs;
	}

	public void setRsltPriPrsCostDetailVO(RsltPriPrsCostDetailVO rsltPriPrsCostDetailVO){
		this. rsltPriPrsCostDetailVO = rsltPriPrsCostDetailVO;
	}

	public void setRsltPriPrsCostDetailVOS(RsltPriPrsCostDetailVO[] rsltPriPrsCostDetailVOs){
		this. rsltPriPrsCostDetailVOs = rsltPriPrsCostDetailVOs;
	}

	public void setPriPrsRoutCsInfoVO(PriPrsRoutCsInfoVO priPrsRoutCsInfoVO){
		this. priPrsRoutCsInfoVO = priPrsRoutCsInfoVO;
	}

	public void setPriPrsRoutCsInfoVOS(PriPrsRoutCsInfoVO[] priPrsRoutCsInfoVOs){
		this. priPrsRoutCsInfoVOs = priPrsRoutCsInfoVOs;
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
	
	public PriSqRtUsdRoutCsVO getPriSqRtUsdRoutCsVO(){
		return priSqRtUsdRoutCsVO;
	}

	public RsltPriPrsCostListVO[] getRsltPriPrsCostListVOS(){
		return rsltPriPrsCostListVOs;
	}

	public RsltPriPrsCostDetailVO getRsltPriPrsCostDetailVO(){
		return rsltPriPrsCostDetailVO;
	}

	public RsltPriPrsCostDetailVO[] getRsltPriPrsCostDetailVOS(){
		return rsltPriPrsCostDetailVOs;
	}

	public PriPrsRoutCsInfoVO getPriPrsRoutCsInfoVO(){
		return priPrsRoutCsInfoVO;
	}

	public PriPrsRoutCsInfoVO[] getPriPrsRoutCsInfoVOS(){
		return priPrsRoutCsInfoVOs;
	}
 
}