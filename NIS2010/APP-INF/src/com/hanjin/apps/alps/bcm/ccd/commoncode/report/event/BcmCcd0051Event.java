/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BcmCcd0025Event.java
*@FileTitle : activity
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.15
*@LastModifier : 
*@LastVersion : 1.0
* 2011.02.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.report.event;
 
import com.hanjin.apps.alps.bcm.ccd.commoncode.report.vo.SearchOfficHierarchyVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * BCM_CCD_0047 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  BCM_CCD_0047HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see BCM_CCD_0047HTMLAction 참조
 * @since J2EE 1.6
 */

public class BcmCcd0051Event extends EventSupport {

private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchOfficHierarchyVO searchOfficHierarchyVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchOfficHierarchyVO[] searchOfficHierarchyVOs = null;

	public BcmCcd0051Event(){}
	
	public void setSearchOfficHierarchyVO(SearchOfficHierarchyVO searchOfficHierarchyVO){
		this. searchOfficHierarchyVO = searchOfficHierarchyVO;
	}

	public void setSearchOfficHierarchyVOS(SearchOfficHierarchyVO[] searchOfficHierarchyVOs){
		if(searchOfficHierarchyVOs != null){
			SearchOfficHierarchyVO[] tmpVOs = java.util.Arrays.copyOf(searchOfficHierarchyVOs, searchOfficHierarchyVOs.length);
			this.searchOfficHierarchyVOs = tmpVOs;
		}
	}

	public SearchOfficHierarchyVO getSearchOfficHierarchyVO(){
		return searchOfficHierarchyVO;
	}

	public SearchOfficHierarchyVO[] getSearchOfficHierarchyVOS(){
		SearchOfficHierarchyVO[] rtnVOs = null;
		if (this.searchOfficHierarchyVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(searchOfficHierarchyVOs, searchOfficHierarchyVOs.length);
		}
		return rtnVOs;
	}
}