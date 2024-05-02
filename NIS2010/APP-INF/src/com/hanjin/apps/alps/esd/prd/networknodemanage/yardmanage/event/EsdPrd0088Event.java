/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : EsdPrd0088Event.java
 *@FileTitle : YardManage
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014-12-12
 *@LastModifier : kimseungman
 *@LastVersion : 1.0
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networknodemanage.yardmanage.event;

import com.hanjin.apps.alps.esd.prd.networknodemanage.yardmanage.vo.SearchNodeDefaultSpInfoListVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESD_PRD_002 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_PRD_002HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author kimyoungchul
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdPrd0088Event extends EventSupport{
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public EsdPrd0088Event(){
	}
	private SearchNodeDefaultSpInfoListVO searchNodeDefaultSpInfoListVO=null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchNodeDefaultSpInfoListVO[] searchNodeDefaultSpInfoListVOS = null;
	
	public SearchNodeDefaultSpInfoListVO[] getSearchNodeDefaultSpInfoListVOS() {
		return searchNodeDefaultSpInfoListVOS;
	}

	public void setSearchNodeDefaultSpInfoListVOS(
			SearchNodeDefaultSpInfoListVO[] searchNodeDefaultSpInfoListVOS) {
		this.searchNodeDefaultSpInfoListVOS = searchNodeDefaultSpInfoListVOS;
	}

	/**
	 * @return the searchLeaseListVO
	 */

	public SearchNodeDefaultSpInfoListVO getSearchNodeDefaultSpInfoListVO() {
		return searchNodeDefaultSpInfoListVO;
	}

	public void setSearchNodeDefaultSpInfoListVO(SearchNodeDefaultSpInfoListVO searchNodeDefaultSpInfoListVO) {
		this.searchNodeDefaultSpInfoListVO = searchNodeDefaultSpInfoListVO;
	}

}
