/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCim1033Event.java
*@FileTitle : Repo Result by Port
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.26
*@LastModifier : 박광석
*@LastVersion : 1.0
* 2009.05.26 박광석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.mtyrepositionperformanceanalysis.event;

import java.util.Arrays;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.mtyrepositionperformanceanalysis.vo.REPOResultSearchOptionByPortVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioestimated.vo.SearchEstimatedProRevenueListVO;


/**
 * EES_CIM_1033 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CIM_1033HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Prak Kwang Seok
 * @see EES_CIM_1033HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesCim1033Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private REPOResultSearchOptionByPortVO rEPOResultSearchOptionByPortVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private REPOResultSearchOptionByPortVO[] rEPOResultSearchOptionByPortVOs = null;

	public EesCim1033Event(){}
	
	public void setREPOResultSearchOptionByPortVO(REPOResultSearchOptionByPortVO rEPOResultSearchOptionByPortVO){
		this. rEPOResultSearchOptionByPortVO = rEPOResultSearchOptionByPortVO;
	}

	public void setREPOResultSearchOptionByPortVOS(REPOResultSearchOptionByPortVO[] rEPOResultSearchOptionByPortVOs){
		if (rEPOResultSearchOptionByPortVOs != null) {
			REPOResultSearchOptionByPortVO[] tmpVOs = Arrays.copyOf(rEPOResultSearchOptionByPortVOs, rEPOResultSearchOptionByPortVOs.length);
			this.rEPOResultSearchOptionByPortVOs = tmpVOs;
		}
	}

	public REPOResultSearchOptionByPortVO getREPOResultSearchOptionByPortVO(){
		return rEPOResultSearchOptionByPortVO;
	}

	public REPOResultSearchOptionByPortVO[] getREPOResultSearchOptionByPortVOS(){
		REPOResultSearchOptionByPortVO[] rtnVOs = null;
		if (this.rEPOResultSearchOptionByPortVOs != null) {
			rtnVOs = Arrays.copyOf(rEPOResultSearchOptionByPortVOs, rEPOResultSearchOptionByPortVOs.length);
		}
		return rtnVOs;
	}

}