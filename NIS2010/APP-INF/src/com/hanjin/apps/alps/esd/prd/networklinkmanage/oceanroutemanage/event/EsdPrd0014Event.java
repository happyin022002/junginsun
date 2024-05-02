/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : EsdPrd0014Event.java
 *@FileTitle : OceanLink 정보관리 (본사관리)
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-09-22
 *@LastModifier : kimyoungchul
 *@LastVersion : 1.0
 * 2006-09-22 kimyoungchul
 * 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.event;

import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.vo.SaveOceanRouteVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.vo.SearchConditionVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.vo.SearchOceanRouteListVO;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESD_PRD_014 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_PRD_014HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author kimyoungchul
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdPrd0014Event extends EventSupport{

	/**
	 * 
	 */
	private int iPage 			= 0;
	
	public EsdPrd0014Event(){
	}
	SearchConditionVO searchConditionVO = null;
	SearchOceanRouteListVO searchOceanRouteListVO = null;
	SearchConditionVO[] searchConditionVOs = null;
	SearchOceanRouteListVO[] searchOceanRouteListVOs = null;
	SaveOceanRouteVO[] saveOceanRouteVOs = null;

	public int getIPage() {
		return iPage;
	}

	public void setIPage(int iPage) {
		this.iPage = iPage;
	}

	/**
	 *
	 * @return
	 */
	public SaveOceanRouteVO[] getSaveOceanRouteVOs(){
		return saveOceanRouteVOs;
	}

	/**
	 *
	 * @param saveOceanRouteVOs
	 */
	public void setSaveOceanRouteVOs(SaveOceanRouteVO[] saveOceanRouteVOs){
		this.saveOceanRouteVOs = saveOceanRouteVOs;
	}

	/**
	 *
	 * @return
	 */
	public SearchConditionVO getSearchConditionVO(){
		return searchConditionVO;
	}

	/**
	 *
	 * @param searchConditionVO
	 */
	public void setSearchConditionVO(SearchConditionVO searchConditionVO){
		this.searchConditionVO = searchConditionVO;
	}

	/**
	 *
	 * @return
	 */
	public SearchOceanRouteListVO getSearchOceanRouteListVO(){
		return searchOceanRouteListVO;
	}

	/**
	 *
	 * @param searchOceanRouteListVO
	 */
	public void setSearchOceanRouteListVO(
			SearchOceanRouteListVO searchOceanRouteListVO){
		this.searchOceanRouteListVO = searchOceanRouteListVO;
	}

	/**
	 *
	 * @return
	 */
	public SearchConditionVO[] getSearchConditionVOs(){
		return searchConditionVOs;
	}

	/**
	 *
	 * @param searchConditionVOs
	 */
	public void setSearchConditionVOs(SearchConditionVO[] searchConditionVOs){
		this.searchConditionVOs = searchConditionVOs;
	}

	/**
	 *
	 * @return
	 */
	public SearchOceanRouteListVO[] getSearchOceanRouteListVOs(){
		return searchOceanRouteListVOs;
	}

	/**
	 *
	 * @param searchOceanRouteListVOs
	 */
	public void setSearchOceanRouteListVOs(
			SearchOceanRouteListVO[] searchOceanRouteListVOs){
		this.searchOceanRouteListVOs = searchOceanRouteListVOs;
	}

	/**
	 *
	 * @param val
	 * @return
	 */
	public String getString(String val){
		return "";
	}

	/**
	 *
	 * @param val
	 * @return
	 */
	public int getInt(String val){
		return -1;
	}

	/**
	 *
	 * @param val
	 * @return
	 */
	public String[] getObject(String val){
		String[] a = new String[1];
		return a;
	}
}
