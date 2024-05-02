/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCim1034Event.java
*@FileTitle : Repo Result by Location
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.27
*@LastModifier : 박광석
*@LastVersion : 1.0
* 2009.05.27 박광석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.mtyrepositionperformanceanalysis.event;

import java.util.Arrays;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.mtyrepositionperformanceanalysis.vo.REPOResultSearchOptionByLocationVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioestimated.vo.SearchEstimatedProRevenueListVO;


/**
 * EES_CIM_1034 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CIM_1034HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Prak Kwang Seok
 * @see EES_CIM_1034HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesCim1034Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private REPOResultSearchOptionByLocationVO rEPOResultSearchOptionByLocation = null;
	
	/** Table Value Object Multi Data 처리 */
	private REPOResultSearchOptionByLocationVO[] rEPOResultSearchOptionByLocations = null;

	public EesCim1034Event(){}
	
	public void setREPOResultSearchOptionByLocation(REPOResultSearchOptionByLocationVO rEPOResultSearchOptionByLocation){
		this. rEPOResultSearchOptionByLocation = rEPOResultSearchOptionByLocation;
	}

	public void setREPOResultSearchOptionByLocationS(REPOResultSearchOptionByLocationVO[] rEPOResultSearchOptionByLocations){
		if (rEPOResultSearchOptionByLocations != null) {
			REPOResultSearchOptionByLocationVO[] tmpVOs = Arrays.copyOf(rEPOResultSearchOptionByLocations, rEPOResultSearchOptionByLocations.length);
			this.rEPOResultSearchOptionByLocations = tmpVOs;
		}
	}

	public REPOResultSearchOptionByLocationVO getREPOResultSearchOptionByLocation(){
		return rEPOResultSearchOptionByLocation;
	}

	public REPOResultSearchOptionByLocationVO[] getREPOResultSearchOptionByLocationS(){
		REPOResultSearchOptionByLocationVO[] rtnVOs = null;
		if (this.rEPOResultSearchOptionByLocations != null) {
			rtnVOs = Arrays.copyOf(rEPOResultSearchOptionByLocations, rEPOResultSearchOptionByLocations.length);
		}
		return rtnVOs;
	}

}