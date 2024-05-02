/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : EsdPrd0060Event.java
 *@FileTitle : OceanLink 정보관리 (본사관리)
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-09-22
 *@LastModifier : kimyoungchul
 *@LastVersion : 1.0
 * 2006-09-22 kimyoungchul
 * 1.0 최초 생성
 * 2011.09.19 변종건 [CHM-201113069-01] Ocean Route Management상의 Auto & Multi Creation 화면 관련 변경사항
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.event;

import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.vo.SaveOceanRouteVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.vo.SearchOceanRouteMultiCreationVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.vo.SearchOceanRouteSingleCreationVO;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESD_PRD_060 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_PRD_060HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author kimyoungchul
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdPrd0060Event extends EventSupport{

	/**
	 * 
	 */
	public EsdPrd0060Event(){
	}

	private SearchOceanRouteMultiCreationVO searchOceanRouteMultiCreationVO = null;
	private SearchOceanRouteMultiCreationVO[] searchOceanRouteMultiCreationVOs = null;
	
	private SaveOceanRouteVO saveOceanRouteVO = null;
	private SaveOceanRouteVO[] saveOceanRouteVOs = null;
	
	private SearchOceanRouteSingleCreationVO searchOceanRouteSingleCreationVO = null;
	private SearchOceanRouteSingleCreationVO[] searchOceanRouteSingleCreationVOs = null;


	
	
	public SearchOceanRouteSingleCreationVO getSearchOceanRouteSingleCreationVO() {
		return searchOceanRouteSingleCreationVO;
	}

	public void setSearchOceanRouteSingleCreationVO(
			SearchOceanRouteSingleCreationVO searchOceanRouteSingleCreationVO) {
		this.searchOceanRouteSingleCreationVO = searchOceanRouteSingleCreationVO;
	}

	public SearchOceanRouteSingleCreationVO[] getSearchOceanRouteSingleCreationVOs() {
		return searchOceanRouteSingleCreationVOs;
	}

	public void setSearchOceanRouteSingleCreationVOs(
			SearchOceanRouteSingleCreationVO[] searchOceanRouteSingleCreationVOs) {
		this.searchOceanRouteSingleCreationVOs = searchOceanRouteSingleCreationVOs;
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
	public SaveOceanRouteVO getSaveOceanRouteVO(){
		return saveOceanRouteVO;
	}
	
	/**
	 *
	 * @param saveOceanRouteVO
	 */
	public void setSaveOceanRouteVO(SaveOceanRouteVO saveOceanRouteVO){
		this.saveOceanRouteVO = saveOceanRouteVO;
	}
	
	
	
	/**
	 *
	 * @return
	 */
	public SearchOceanRouteMultiCreationVO getSearchOceanRouteMultiCreationVO(){
		return searchOceanRouteMultiCreationVO;
	}

	/**
	 *
	 * @param searchOceanRouteMultiCreationVO
	 */
	public void setSearchOceanRouteMultiCreationVO(
			SearchOceanRouteMultiCreationVO searchOceanRouteMultiCreationVO){
		this.searchOceanRouteMultiCreationVO = searchOceanRouteMultiCreationVO;
	}

	/**
	 *
	 * @return
	 */
	public SearchOceanRouteMultiCreationVO[] getSearchOceanRouteMultiCreationVOs(){
		return searchOceanRouteMultiCreationVOs;
	}

	/**
	 *
	 * @param searchOceanRouteMultiCreationVOs
	 */
	public void setSearchOceanRouteMultiCreationVOs(
			SearchOceanRouteMultiCreationVO[] searchOceanRouteMultiCreationVOs){
		this.searchOceanRouteMultiCreationVOs = searchOceanRouteMultiCreationVOs;
	}

	/**
	 * 에러 안나게하기 위해 임시로
	 * @param arg1
	 * @return
	 */
	public String getString(String arg1){
		return "";
	}

	/**
	 * 에러 안나게하기 위해 임시로
	 * @param arg1
	 * @return
	 */
	public String[] getObject(String arg1){
		return new String[1];
	}
}
