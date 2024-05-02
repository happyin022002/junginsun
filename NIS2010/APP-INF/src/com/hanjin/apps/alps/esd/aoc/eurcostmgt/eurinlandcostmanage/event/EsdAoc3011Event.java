/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsdAoc3011Event.java
*@FileTitle : Cost & Guideline Tariff Status Monitoring
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
* --------------------------------------------------------
* History
* 2012.10.04 변종건 [CHM-201220395] Add-on Tariff Management 개선 프로젝트
* 2015.03.06 최성환 [CHM-201534710] AOC 2차 소스 보안 품질 진행 요청
=========================================================*/
package com.hanjin.apps.alps.esd.aoc.eurcostmgt.eurinlandcostmanage.event;

import com.hanjin.apps.alps.esd.aoc.eurcostmgt.eurinlandcostmanage.vo.EurStatusMonitorVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_AOC_3011 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_AOC_3011HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see ESD_AOC_3011HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdAoc3011Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public EsdAoc3011Event(){}
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private EurStatusMonitorVO eurStatusMonitorVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private EurStatusMonitorVO[] eurStatusMonitorVOs = null;

	public EurStatusMonitorVO getSearchStatusMonitorVO() {
		return eurStatusMonitorVO;
	}

	public void setSearchStatusMonitorVO(EurStatusMonitorVO eurStatusMonitorVO) {
		this.eurStatusMonitorVO = eurStatusMonitorVO;
	}

	public EurStatusMonitorVO[] getSearchStatusMonitorVOs() {
		EurStatusMonitorVO[] rtnVOs = null;
		if (this.eurStatusMonitorVOs != null) {
			rtnVOs = new EurStatusMonitorVO[eurStatusMonitorVOs.length];
			System.arraycopy(eurStatusMonitorVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setSearchStatusMonitorVOs(EurStatusMonitorVO[] searchStatusMonitorVOs){
		if(searchStatusMonitorVOs != null){
			EurStatusMonitorVO[] tmpVOs = new EurStatusMonitorVO[searchStatusMonitorVOs.length];
			System.arraycopy(searchStatusMonitorVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.eurStatusMonitorVOs = tmpVOs;
		}
	}
}
