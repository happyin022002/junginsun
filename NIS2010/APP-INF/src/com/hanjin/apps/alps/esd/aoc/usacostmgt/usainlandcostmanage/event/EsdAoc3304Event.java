/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsdAoc3304Event.java
*@FileTitle : Inland Cost Management Cost Detail(Usa)
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
* --------------------------------------------------------
* History
* 2015.03.06 최성환 [CHM-201534710] AOC 2차 소스 보안 품질 진행 요청
=========================================================*/
package com.hanjin.apps.alps.esd.aoc.usacostmgt.usainlandcostmanage.event;

import com.hanjin.apps.alps.esd.aoc.usacostmgt.usainlandcostmanage.vo.UsaInlandCostAccountVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_AOC_3304 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_AOC_3304HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see ESD_AOC_3304HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdAoc3304Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	
	public EsdAoc3304Event(){}
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private UsaInlandCostAccountVO usaInlandCostAccountVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private UsaInlandCostAccountVO[] usaInlandCostAccountVOs = null;

	
	public UsaInlandCostAccountVO getSearchInlandCostAccountVO() {
		return usaInlandCostAccountVO;
	}

	public void setSearchInlandCostAccountVO(
			UsaInlandCostAccountVO usaInlandCostAccountVO) {
		this.usaInlandCostAccountVO = usaInlandCostAccountVO;
	}

	public UsaInlandCostAccountVO[] getSearchInlandCostAccountVOs() {
		UsaInlandCostAccountVO[] rtnVOs = null;
		if (this.usaInlandCostAccountVOs != null) {
			rtnVOs = new UsaInlandCostAccountVO[usaInlandCostAccountVOs.length];
			System.arraycopy(usaInlandCostAccountVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setSearchInlandCostAccountVOs(UsaInlandCostAccountVO[] searchInlandCostAccountVOs){
		if(searchInlandCostAccountVOs != null){
			UsaInlandCostAccountVO[] tmpVOs = new UsaInlandCostAccountVO[searchInlandCostAccountVOs.length];
			System.arraycopy(searchInlandCostAccountVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.usaInlandCostAccountVOs = tmpVOs;
		}
	}
	
}
