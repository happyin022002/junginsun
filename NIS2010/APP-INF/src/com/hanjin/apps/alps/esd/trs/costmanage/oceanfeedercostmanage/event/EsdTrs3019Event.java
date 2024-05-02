/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsdTrs3019Event.java
*@FileTitle : Ocean Feeder Cost Management - Cost Detail
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.hanjin.apps.alps.esd.trs.costmanage.oceanfeedercostmanage.event;

import com.hanjin.apps.alps.esd.trs.costmanage.oceanfeedercostmanage.vo.SearchOceanFeederCostAccountVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_TRS_3019 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_TRS_3019HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see ESD_TRS_3019HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdTrs3019Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	
	public EsdTrs3019Event(){}
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchOceanFeederCostAccountVO searchOceanFeederCostAccountVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchOceanFeederCostAccountVO[] searchOceanFeederCostAccountVOs = null;

	public SearchOceanFeederCostAccountVO getSearchOceanFeederCostAccountVO() {
		return searchOceanFeederCostAccountVO;
	}

	public void setSearchOceanFeederCostAccountVO(
			SearchOceanFeederCostAccountVO searchOceanFeederCostAccountVO) {
		this.searchOceanFeederCostAccountVO = searchOceanFeederCostAccountVO;
	}

	public SearchOceanFeederCostAccountVO[] getSearchOceanFeederCostAccountVOs() {
		return searchOceanFeederCostAccountVOs;
	}

	public void setSearchOceanFeederCostAccountVOs(
			SearchOceanFeederCostAccountVO[] searchOceanFeederCostAccountVOs) {
		this.searchOceanFeederCostAccountVOs = searchOceanFeederCostAccountVOs;
	}
}
