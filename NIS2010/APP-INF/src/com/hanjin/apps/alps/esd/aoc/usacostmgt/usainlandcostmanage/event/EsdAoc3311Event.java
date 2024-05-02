/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsdAoc3311Event.java
*@FileTitle : Cost & Guideline Tariff Status Monitoring
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

import com.hanjin.apps.alps.esd.aoc.usacostmgt.usainlandcostmanage.vo.UsaStatusMonitorVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_AOC_3311 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_AOC_3311HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see ESD_AOC_3011HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdAoc3311Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public EsdAoc3311Event(){}
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private UsaStatusMonitorVO usaStatusMonitorVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private UsaStatusMonitorVO[] usaStatusMonitorVOs = null;

	public UsaStatusMonitorVO getSearchStatusMonitorVO() {
		return usaStatusMonitorVO;
	}

	public void setSearchStatusMonitorVO(UsaStatusMonitorVO usaStatusMonitorVO) {
		this.usaStatusMonitorVO = usaStatusMonitorVO;
	}

	public UsaStatusMonitorVO[] getSearchStatusMonitorVOs() {
		UsaStatusMonitorVO[] rtnVOs = null;
		if (this.usaStatusMonitorVOs != null) {
			rtnVOs = new UsaStatusMonitorVO[usaStatusMonitorVOs.length];
			System.arraycopy(usaStatusMonitorVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setSearchStatusMonitorVOs(UsaStatusMonitorVO[] searchStatusMonitorVOs){
		if(searchStatusMonitorVOs != null){
			UsaStatusMonitorVO[] tmpVOs = new UsaStatusMonitorVO[searchStatusMonitorVOs.length];
			System.arraycopy(searchStatusMonitorVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.usaStatusMonitorVOs = tmpVOs;
		}
	}
}
