/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsdAoc3111Event.java
*@FileTitle : Cost & Guideline Tariff Status Monitoring
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
* --------------------------------------------------------
* History
=========================================================*/
package com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiainlandcostmanage.event;

import com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiainlandcostmanage.vo.AsiaStatusMonitorVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_AOC_3111 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_AOC_3111HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see ESD_AOC_3011HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdAoc3111Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public EsdAoc3111Event(){}
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private AsiaStatusMonitorVO asiaStatusMonitorVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private AsiaStatusMonitorVO[] asiaStatusMonitorVOs = null;

	public AsiaStatusMonitorVO getSearchStatusMonitorVO() {
		return asiaStatusMonitorVO;
	}

	public void setSearchStatusMonitorVO(AsiaStatusMonitorVO asiaStatusMonitorVO) {
		this.asiaStatusMonitorVO = asiaStatusMonitorVO;
	}

	public AsiaStatusMonitorVO[] getSearchStatusMonitorVOs() {
		AsiaStatusMonitorVO[] rtnVOs = null;
		if (this.asiaStatusMonitorVOs != null) {
			rtnVOs = new AsiaStatusMonitorVO[asiaStatusMonitorVOs.length];
			System.arraycopy(asiaStatusMonitorVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setSearchStatusMonitorVOs(AsiaStatusMonitorVO[] searchStatusMonitorVOs){
		if(searchStatusMonitorVOs != null){
			AsiaStatusMonitorVO[] tmpVOs = new AsiaStatusMonitorVO[searchStatusMonitorVOs.length];
			System.arraycopy(searchStatusMonitorVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.asiaStatusMonitorVOs = tmpVOs;
		}
	}
}
