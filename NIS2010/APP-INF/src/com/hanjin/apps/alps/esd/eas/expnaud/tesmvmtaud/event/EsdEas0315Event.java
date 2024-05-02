/*=========================================================
*Copyright(c) 2015 CyberLogitec 
*@FileName : EsdEas0315Event.java
*@FileTitle : Contianer Movement - Reefer
*Open Issues :
*Change history :
*@LastModifyDate : 2015-02-02
*@LastModifier : 9014613
*@LastVersion : 1.0
* 2015-02-02
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.expnaud.tesmvmtaud.event;

import com.hanjin.apps.alps.esd.eas.expnaud.tesmvmtaud.vo.SearchMvmtLegListVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_EAS_0315 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_EAS_0315HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 9014613
 * @see ESD_EAS_0315HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdEas0315Event extends EventSupport {
	/** Table Value Object MultiCombo 조회 조건 및 단건 처리  */
	SearchMvmtLegListVO searchMvmtLegListVO = null;
	
	/** Table Value Object MultiCombo 다건 처리  */
	SearchMvmtLegListVO[] searchMvmtLegListVOs = null;
	private static final long serialVersionUID = 1L;
	
	
	
	public SearchMvmtLegListVO getSearchMvmtLegListVO() {
		return searchMvmtLegListVO;
	}
	public void setSearchMvmtLegListVO(SearchMvmtLegListVO searchMvmtLegListVO) {
		this.searchMvmtLegListVO = searchMvmtLegListVO;
	}

	public void setSearchMvmtLegListVOs(SearchMvmtLegListVO[] searchMvmtLegListVOs) {
		if (searchMvmtLegListVOs != null) {
			SearchMvmtLegListVO[] tmpVOs = new SearchMvmtLegListVO[searchMvmtLegListVOs.length];
			System.arraycopy(searchMvmtLegListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.searchMvmtLegListVOs = tmpVOs;
		}
	}
	
	public SearchMvmtLegListVO getSearchMvmtLegListVOs(){
		return searchMvmtLegListVO;
	}
	
	public SearchMvmtLegListVO[] getBookingContractVOS() {
		SearchMvmtLegListVO[] rtnVOs = null;
		if (this.searchMvmtLegListVOs != null) {
			rtnVOs = new SearchMvmtLegListVO[searchMvmtLegListVOs.length];
			System.arraycopy(searchMvmtLegListVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}



}