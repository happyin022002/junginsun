/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : EsdPrd0016Event.java
 *@FileTitle : Ocean Route Lane Status
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-10-09
 *@LastModifier : kimyoungchul
 *@LastVersion : 1.0
 * 2006-10-09 kimyoungchul
 * 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.event;

import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.vo.SaveOceanRouteStatusVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.vo.SearchOceanRouteStatusVO;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESD_PRD_016 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_PRD_016HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author kimyoungchul
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdPrd0016Event extends EventSupport{

	private SearchOceanRouteStatusVO searchOceanRouteStatusVO = null;
	private SaveOceanRouteStatusVO[] saveOceanRouteStatusVOs = null;

	/**
	 *
	 * @return
	 */
	public SaveOceanRouteStatusVO[] getSaveOceanRouteStatusVOs(){
		return saveOceanRouteStatusVOs;
	}

	/**
	 *
	 * @param saveOceanRouteStatusVOs
	 */
	public void setSaveOceanRouteStatusVOs(
			SaveOceanRouteStatusVO[] saveOceanRouteStatusVOs){
		this.saveOceanRouteStatusVOs = saveOceanRouteStatusVOs;
	}

	/**
	 *
	 * @return
	 */
	public SearchOceanRouteStatusVO getSearchOceanRouteStatusVO(){
		return searchOceanRouteStatusVO;
	}

	/**
	 *
	 * @param searchOceanRouteStatusVO
	 */
	public void setSearchOceanRouteStatusVO(
			SearchOceanRouteStatusVO searchOceanRouteStatusVO){
		this.searchOceanRouteStatusVO = searchOceanRouteStatusVO;
	}
}
