/*=========================================================
*Copyright(c) 2015 CyberLogitec 
*@FileName : EsdEas0317Event.java
*@FileTitle : Performance For Logistics Expense
*Open Issues :
*Change history :
*@LastModifyDate : 2015-02-02
*@LastModifier : 9014613
*@LastVersion : 1.0
* 2015-02-02
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.expnaud.audperf.event;

import com.hanjin.apps.alps.esd.eas.expnaud.audperf.vo.SearchLgsCostCdVO;
import com.hanjin.apps.alps.esd.eas.expnaud.audperf.vo.SearchPerfOfcListVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_EAS_3017 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_EAS_3017HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 9014613
 * @see ESD_EAS_3017HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdEas0317Event extends EventSupport {
	/** Table Value Object MultiCombo 조회 조건 및 단건 처리  */
	SearchPerfOfcListVO searchPerfOfcListVO = null;
	
	/** Table Value Object MultiCombo 다건 처리  */
	SearchPerfOfcListVO[] searchPerfOfcListVOs = null;
	
	private SearchLgsCostCdVO searchLgsCostCdVO = null;
	
	
	private static final long serialVersionUID = 1L;
	
	public SearchPerfOfcListVO getSearchPerfOfcListVO() {
		return searchPerfOfcListVO;
	}
	public void setSearchPerfOfcListVO(SearchPerfOfcListVO searchPerfOfcListVO) {
		this.searchPerfOfcListVO = searchPerfOfcListVO;
	}
	public SearchPerfOfcListVO[] getSearchPerfOfcListVOs() {
		SearchPerfOfcListVO[] rtnVOs = null;
		if (this.searchPerfOfcListVOs != null) {
			rtnVOs = new SearchPerfOfcListVO[searchPerfOfcListVOs.length];
			System.arraycopy(searchPerfOfcListVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	public void setSearchPerfOfcListVOs(SearchPerfOfcListVO[] searchPerfOfcListVOs){
		if(searchPerfOfcListVOs != null){
			SearchPerfOfcListVO[] tmpVOs = new SearchPerfOfcListVO[searchPerfOfcListVOs.length];
			System.arraycopy(searchPerfOfcListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.searchPerfOfcListVOs = tmpVOs;
		}
	}	
	public SearchLgsCostCdVO getSearchLgsCostCdVO() {
		return searchLgsCostCdVO;
	}	
	public void setSearchLgsCostCdVO(SearchLgsCostCdVO searchLgsCostCdVO) {
		this.searchLgsCostCdVO = searchLgsCostCdVO;
	}
	
	
	


}