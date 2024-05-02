/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri6084Event.java
*@FileTitle : PRS-Cost Detail
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.13
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2009.07.13 송민석
* 1.0 Creation
=========================================================*/
        
package com.hanjin.apps.alps.esm.pri.triproposal.triproposal.event;

import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo.InPriPrsRoutCsVO;
import com.hanjin.apps.alps.esm.pri.triproposal.triproposal.vo.InCostSimulationCheckRouteVO;
import com.hanjin.apps.alps.esm.pri.triproposal.triproposal.vo.RsltTriPrsCostDetailVO;
import com.hanjin.apps.alps.esm.pri.triproposal.triproposal.vo.RsltTriPrsCostListVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriPrsRoutCsInfoVO;
import com.hanjin.syscommon.common.table.PriTriRtUsdRoutCsVO;


/**
 * ESM_PRI_6084 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_6084HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SONG MIN SEOK
 * @see ESM_PRI_6084HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri6084Event extends EventSupport {

	private static final long serialVersionUID = 1L;
 
	
	private InCostSimulationCheckRouteVO inCostSimulationCheckRouteVO = null;
	private InPriPrsRoutCsVO inPriPrsRoutCsVO = null;
	
	private PriTriRtUsdRoutCsVO priTriRtUsdRoutCsVO = null;
	
	
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltTriPrsCostListVO rsltTriPrsCostListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private RsltTriPrsCostListVO[] rsltTriPrsCostListVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltTriPrsCostDetailVO rsltTriPrsCostDetailVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private RsltTriPrsCostDetailVO[] rsltTriPrsCostDetailVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriPrsRoutCsInfoVO priPrsRoutCsInfoVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriPrsRoutCsInfoVO[] priPrsRoutCsInfoVOs = null;

	public EsmPri6084Event(){}
	
	public void setInCostSimulationCheckRouteVO(InCostSimulationCheckRouteVO inCostSimulationCheckRouteVO){
		this. inCostSimulationCheckRouteVO = inCostSimulationCheckRouteVO;
	}
	public void setInPriPrsRoutCsVO(InPriPrsRoutCsVO inPriPrsRoutCsVO){
		this. inPriPrsRoutCsVO = inPriPrsRoutCsVO;
	}
	
	public void setPriTriRtUsdRoutCsVO(PriTriRtUsdRoutCsVO priTriRtUsdRoutCsVO){
		this. priTriRtUsdRoutCsVO = priTriRtUsdRoutCsVO;
	}
	
	public void setRsltTriPrsCostListVO(RsltTriPrsCostListVO rsltTriPrsCostListVO){
		this. rsltTriPrsCostListVO = rsltTriPrsCostListVO;
	}

	public void setRsltTriPrsCostListVOS(RsltTriPrsCostListVO[] rsltTriPrsCostListVOs){
		this. rsltTriPrsCostListVOs = rsltTriPrsCostListVOs;
	}

	public void setRsltTriPrsCostDetailVO(RsltTriPrsCostDetailVO rsltTriPrsCostDetailVO){
		this. rsltTriPrsCostDetailVO = rsltTriPrsCostDetailVO;
	}

	public void setRsltTriPrsCostDetailVOS(RsltTriPrsCostDetailVO[] rsltTriPrsCostDetailVOs){
		this. rsltTriPrsCostDetailVOs = rsltTriPrsCostDetailVOs;
	}

	public void setPriPrsRoutCsInfoVO(PriPrsRoutCsInfoVO priPrsRoutCsInfoVO){
		this. priPrsRoutCsInfoVO = priPrsRoutCsInfoVO;
	}

	public void setPriPrsRoutCsInfoVOS(PriPrsRoutCsInfoVO[] priPrsRoutCsInfoVOs){
		this. priPrsRoutCsInfoVOs = priPrsRoutCsInfoVOs;
	}
	
	
	public InCostSimulationCheckRouteVO getInCostSimulationCheckRouteVO(){
		return inCostSimulationCheckRouteVO;
	}
	public InPriPrsRoutCsVO getInPriPrsRoutCsVO(){
		return inPriPrsRoutCsVO;
	}
	
	public PriTriRtUsdRoutCsVO getPriTriRtUsdRoutCsVO(){
		return priTriRtUsdRoutCsVO;
	}
	
	public RsltTriPrsCostListVO getRsltTriPrsCostListVO(){
		return rsltTriPrsCostListVO;
	}

	public RsltTriPrsCostListVO[] getRsltTriPrsCostListVOS(){
		return rsltTriPrsCostListVOs;
	}

	public RsltTriPrsCostDetailVO getRsltTriPrsCostDetailVO(){
		return rsltTriPrsCostDetailVO;
	}

	public RsltTriPrsCostDetailVO[] getRsltTriPrsCostDetailVOS(){
		return rsltTriPrsCostDetailVOs;
	}

	public PriPrsRoutCsInfoVO getPriPrsRoutCsInfoVO(){
		return priPrsRoutCsInfoVO;
	}

	public PriPrsRoutCsInfoVO[] getPriPrsRoutCsInfoVOS(){
		return priPrsRoutCsInfoVOs;
	}
 
}