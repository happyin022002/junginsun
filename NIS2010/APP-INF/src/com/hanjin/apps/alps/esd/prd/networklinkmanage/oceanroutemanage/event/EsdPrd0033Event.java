/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : EsdPrd0033Event.java
 *@FileTitle : 터미널별 Lane Connection
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-11-15
 *@LastModifier : Jeongseon An
 *@LastVersion : 1.0
 * 2006-11-15 Jeongseon An
 * 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.event;

import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.vo.SearchLaneConnectionVO;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESD_PRD_033 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_PRD_033HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jeongseon An
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdPrd0033Event extends EventSupport{

	private SearchLaneConnectionVO searchLaneConnectionVO = null;

	/**
	 *
	 * @return
	 */
	public SearchLaneConnectionVO getSearchLaneConnectionVO(){
		return searchLaneConnectionVO;
	}

	/**
	 *
	 * @param searchLaneConnectionVO
	 */
	public void setSearchLaneConnectionVO(
			SearchLaneConnectionVO searchLaneConnectionVO){
		this.searchLaneConnectionVO = searchLaneConnectionVO;
	}
}
