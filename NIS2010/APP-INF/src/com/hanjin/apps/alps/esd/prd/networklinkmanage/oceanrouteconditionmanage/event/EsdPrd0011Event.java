/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : EsdPrd0011Event.java
 *@FileTitle : Carrier별 이용터미널 정보관리
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-10-02
 *@LastModifier : jungsunyoung
 *@LastVersion : 1.0
 * 2006-10-02 jungsunyoung
 * 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanrouteconditionmanage.event;

import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanrouteconditionmanage.vo.SearchOceanRouteConditionVO;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESD_PRD_011 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_PRD_011HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author jungsunyoung
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdPrd0011Event extends EventSupport{

	private SearchOceanRouteConditionVO searchOceanRouteConditionVO = null;
	private SearchOceanRouteConditionVO[] searchOceanRouteConditionVOs = null;
	private String userId = null;

	/**
	 *
	 * @return
	 */
	public String getUserId(){
		return userId;
	}

	/**
	 *
	 * @param userId
	 */
	public void setUserId(String userId){
		this.userId = userId;
	}

	/**
	 *
	 * @return
	 */
	public SearchOceanRouteConditionVO[] getSearchOceanRouteConditionVOs(){
		return searchOceanRouteConditionVOs;
	}

	/**
	 *
	 * @param searchOceanRouteConditionVOs
	 */
	public void setSearchOceanRouteConditionVOs(
			SearchOceanRouteConditionVO[] searchOceanRouteConditionVOs){
		this.searchOceanRouteConditionVOs = searchOceanRouteConditionVOs;
	}

	/**
	 *
	 * @return
	 */
	public SearchOceanRouteConditionVO getSearchOceanRouteConditionVO(){
		return searchOceanRouteConditionVO;
	}

	/**
	 *
	 * @param searchOceanRouteConditionVO
	 */
	public void setSearchOceanRouteConditionVO(
			SearchOceanRouteConditionVO searchOceanRouteConditionVO){
		this.searchOceanRouteConditionVO = searchOceanRouteConditionVO;
	}

	/**
	 *
	 * @param arg1
	 * @return
	 */
	public String[] getObject(String arg1){
		return new String[1];
	}

	/**
	 *
	 * @param arg1
	 * @return
	 */
	public String getString(String arg1){
		return "";
	}
}
