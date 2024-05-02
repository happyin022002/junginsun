/*=========================================================
*Copyright(c) 2015 CyberLogitec 
*@FileName : EsdEas0318Event
*@FileTitle : Performance For Logistics Expense - S/P Detail
*Open Issues :
*Change history :
*@LastModifyDate : 2015-02-02
*@LastModifier : 9014613
*@LastVersion : 1.0
* 2015-02-02
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.expnaud.audperf.event;

import com.hanjin.apps.alps.esd.eas.expnaud.audperf.vo.SearchPerfSpDtlListVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_EAS_0318 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_EAS_0318HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 9014613
 * @see ESD_EAS_0318HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdEas0318Event extends EventSupport {
	/** Table Value Object MultiCombo 조회 조건 및 단건 처리  */
	SearchPerfSpDtlListVO searchPerfSpDtlListVO = null;
	
	/** Table Value Object MultiCombo 다건 처리  */
	SearchPerfSpDtlListVO[] searchPerfSpDtlListVOs = null;
	
	private static final long serialVersionUID = 1L;
	
	public SearchPerfSpDtlListVO getSearchPerfSpDtlListVO() {
		return searchPerfSpDtlListVO;
	}
	public void setSearchPerfSpDtlListVO(SearchPerfSpDtlListVO searchPerfSpDtlListVO) {
		this.searchPerfSpDtlListVO = searchPerfSpDtlListVO;
	}
	public SearchPerfSpDtlListVO[] getSearchPerfSpDtlListVOs() {
		SearchPerfSpDtlListVO[] rtnVOs = null;
		if (this.searchPerfSpDtlListVOs != null) {
			rtnVOs = new SearchPerfSpDtlListVO[searchPerfSpDtlListVOs.length];
			System.arraycopy(searchPerfSpDtlListVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	public void setSearchPerfSpDtlListVOs(SearchPerfSpDtlListVO[] searchPerfSpDtlListVOs){
		if(searchPerfSpDtlListVOs != null){
			SearchPerfSpDtlListVO[] tmpVOs = new SearchPerfSpDtlListVO[searchPerfSpDtlListVOs.length];
			System.arraycopy(searchPerfSpDtlListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.searchPerfSpDtlListVOs = tmpVOs;
		}
	}
}