/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsdAoc3023Event.java
*@FileTitle : Ocean Feeder Cost Management - Cost Detail(EUR)
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
* --------------------------------------------------------
* History
* 2012.10.04 변종건 [CHM-201220395] Ocean Feeder Cost Management - Cost Detail(EUR) 신규 개발
* 2015.03.06 최성환 [CHM-201534710] AOC 2차 소스 보안 품질 진행 요청
=========================================================*/
package com.hanjin.apps.alps.esd.aoc.eurcostmgt.euroceanfeedercostmanage.event;

import com.hanjin.apps.alps.esd.aoc.eurcostmgt.euroceanfeedercostmanage.vo.EurFeederCostAccountVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_AOC_3023 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_AOC_3023HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see ESD_AOC_3023HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdAoc3023Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	
	public EsdAoc3023Event(){}
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private EurFeederCostAccountVO eurFeederCostAccountVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private EurFeederCostAccountVO[] eurFeederCostAccountVOs = null;

	public EurFeederCostAccountVO getSearchOceanFeederCostAccountVO() {
		return eurFeederCostAccountVO;
	}

	public void setSearchOceanFeederCostAccountVO(
			EurFeederCostAccountVO eurFeederCostAccountVO) {
		this.eurFeederCostAccountVO = eurFeederCostAccountVO;
	}

	public EurFeederCostAccountVO[] getSearchOceanFeederCostAccountVOs() {
		EurFeederCostAccountVO[] rtnVOs = null;
		if (this.eurFeederCostAccountVOs != null) {
			rtnVOs = new EurFeederCostAccountVO[eurFeederCostAccountVOs.length];
			System.arraycopy(eurFeederCostAccountVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setSearchOceanFeederCostAccountVOs(EurFeederCostAccountVO[] searchOceanFeederCostAccountVOs){
		if(searchOceanFeederCostAccountVOs != null){
			EurFeederCostAccountVO[] tmpVOs = new EurFeederCostAccountVO[searchOceanFeederCostAccountVOs.length];
			System.arraycopy(searchOceanFeederCostAccountVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.eurFeederCostAccountVOs = tmpVOs;
		}
	}
}
