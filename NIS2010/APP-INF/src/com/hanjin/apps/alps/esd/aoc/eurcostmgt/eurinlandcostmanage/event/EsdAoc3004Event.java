/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsdAoc3004Event.java
*@FileTitle : Inland Cost Management Cost Detail(EUR)
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
* --------------------------------------------------------
* History
* 2012.05.25 변종건 [CHM-201217633] Inland Cost Management - Cost Detail 생성
* 2015.03.06 최성환 [CHM-201534710] AOC 2차 소스 보안 품질 진행 요청
=========================================================*/
package com.hanjin.apps.alps.esd.aoc.eurcostmgt.eurinlandcostmanage.event;

import com.hanjin.apps.alps.esd.aoc.eurcostmgt.eurinlandcostmanage.vo.EurInlandCostAccountVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_AOC_3004 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_AOC_3004HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see ESD_AOC_3004HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdAoc3004Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	
	public EsdAoc3004Event(){}
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private EurInlandCostAccountVO eurInlandCostAccountVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private EurInlandCostAccountVO[] eurInlandCostAccountVOs = null;

	
	public EurInlandCostAccountVO getSearchInlandCostAccountVO() {
		return eurInlandCostAccountVO;
	}

	public void setSearchInlandCostAccountVO(
			EurInlandCostAccountVO eurInlandCostAccountVO) {
		this.eurInlandCostAccountVO = eurInlandCostAccountVO;
	}

	public EurInlandCostAccountVO[] getSearchInlandCostAccountVOs() {
		EurInlandCostAccountVO[] rtnVOs = null;
		if (this.eurInlandCostAccountVOs != null) {
			rtnVOs = new EurInlandCostAccountVO[eurInlandCostAccountVOs.length];
			System.arraycopy(eurInlandCostAccountVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setSearchInlandCostAccountVOs(EurInlandCostAccountVO[] searchInlandCostAccountVOs){
		if(searchInlandCostAccountVOs != null){
			EurInlandCostAccountVO[] tmpVOs = new EurInlandCostAccountVO[searchInlandCostAccountVOs.length];
			System.arraycopy(searchInlandCostAccountVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.eurInlandCostAccountVOs = tmpVOs;
		}
	}
	
}
