/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsdAoc3903Event.java
*@FileTitle : Inland Cost Management - Location Group
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
* --------------------------------------------------------
* History
* 2015.03.06 최성환 [CHM-201534710] AOC 2차 소스 보안 품질 진행 요청
=========================================================*/
package com.hanjin.apps.alps.esd.aoc.common.aocpopup.event;

import com.hanjin.apps.alps.esd.aoc.eurcostmgt.eurinlandcostmanage.vo.EurInlandCostConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_AOC_3903 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_AOC_3903HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see ESD_AOC_3903HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdAoc3903Event extends EventSupport {
	
	private static final long serialVersionUID = 1L;
	
	private EurInlandCostConditionVO eurInlandCostConditionVO = null;
	private EurInlandCostConditionVO[] eurInlandCostConditionVOs = null;
	
	public EurInlandCostConditionVO getInlandCostConditionVO() {
		return eurInlandCostConditionVO;
	}
	public void setInlandCostConditionVO(EurInlandCostConditionVO eurInlandCostConditionVO) {
		this.eurInlandCostConditionVO = eurInlandCostConditionVO;
	}
	public EurInlandCostConditionVO[] getInlandCostConditionVOs() {
		EurInlandCostConditionVO[] rtnVOs = null;
		if (this.eurInlandCostConditionVOs != null) {
			rtnVOs = new EurInlandCostConditionVO[eurInlandCostConditionVOs.length];
			System.arraycopy(eurInlandCostConditionVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	public void setInlandCostConditionVOs(EurInlandCostConditionVO[] inlandCostConditionVOs){
		if(inlandCostConditionVOs != null){
			EurInlandCostConditionVO[] tmpVOs = new EurInlandCostConditionVO[inlandCostConditionVOs.length];
			System.arraycopy(inlandCostConditionVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.eurInlandCostConditionVOs = tmpVOs;
		}
	}
	
}
