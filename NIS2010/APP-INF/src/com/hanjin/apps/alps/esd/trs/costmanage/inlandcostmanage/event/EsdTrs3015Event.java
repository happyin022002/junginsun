/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsdTrs3015Event.java
*@FileTitle : Cost & Guideline Tariff Status Monitoring
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
* --------------------------------------------------------
* History
* 2012.06.07 변종건 [CHM-201217633] Cost & Guideline Tariff Status Monitoring 신규 개발
=========================================================*/
package com.hanjin.apps.alps.esd.trs.costmanage.inlandcostmanage.event;

import com.hanjin.apps.alps.esd.trs.costmanage.inlandcostmanage.vo.SearchStatusMonitorVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_TRS_3015 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_TRS_3015HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see ESD_TRS_3015HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdTrs3015Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public EsdTrs3015Event(){}
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchStatusMonitorVO searchStatusMonitorVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchStatusMonitorVO[] searchStatusMonitorVOs = null;

	public SearchStatusMonitorVO getSearchStatusMonitorVO() {
		return searchStatusMonitorVO;
	}

	public void setSearchStatusMonitorVO(SearchStatusMonitorVO searchStatusMonitorVO) {
		this.searchStatusMonitorVO = searchStatusMonitorVO;
	}

	public SearchStatusMonitorVO[] getSearchStatusMonitorVOs() {
		return searchStatusMonitorVOs;
	}

	public void setSearchStatusMonitorVOs(
			SearchStatusMonitorVO[] searchStatusMonitorVOs) {
		this.searchStatusMonitorVOs = searchStatusMonitorVOs;
	}
}
