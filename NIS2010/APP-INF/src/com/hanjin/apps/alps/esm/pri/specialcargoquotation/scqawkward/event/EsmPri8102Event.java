/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EsmPri8102Event.java
*@FileTitle : Select Route
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.18
*@LastModifier : 문동선
*@LastVersion : 1.0
* 2013.02.18 문동선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.event;

import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.vo.SearchOceanRouteListVO;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.vo.SearchOceanRouteYDListVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriAuthorizationVO;


/**
 * ESM_PRI_8102 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_8102HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Dong-sun Moon
 * @see ESM_PRI_8102HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri8102Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriAuthorizationVO priAuthorizationVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriAuthorizationVO[] priAuthorizationVOs = null;

	SearchConditionVO searchConditionVO = null;
	SearchOceanRouteYDListVO searchOceanRouteYDListVO = null;
	SearchConditionVO[] searchConditionVOs = null;
	SearchOceanRouteYDListVO[] searchOceanRouteYDListVOs = null;
	
	public EsmPri8102Event(){}
	
	public void setPriAuthorizationVO(PriAuthorizationVO priAuthorizationVO){
		this. priAuthorizationVO = priAuthorizationVO;
	}

	public void setPriAuthorizationVOS(PriAuthorizationVO[] priAuthorizationVOs){
		this. priAuthorizationVOs = priAuthorizationVOs;
	}

	public PriAuthorizationVO getPriAuthorizationVO(){
		return priAuthorizationVO;
	}

	public PriAuthorizationVO[] getPriAuthorizationVOS(){
		return priAuthorizationVOs;
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
	public SearchOceanRouteYDListVO getSearchOceanRouteListVO(){
		return searchOceanRouteYDListVO;
	}

	/**
	 *
	 * @param searchOceanRouteYDListVO
	 */
	public void setSearchOceanRouteListVO(
			SearchOceanRouteYDListVO searchOceanRouteYDListVO){
		this.searchOceanRouteYDListVO = searchOceanRouteYDListVO;
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
	public SearchOceanRouteYDListVO[] getSearchOceanRouteYDListVOs(){
		return searchOceanRouteYDListVOs;
	}

	/**
	 *
	 * @param searchOceanRouteYDListVOs
	 */
	public void setSearchOceanRouteYDListVOs(
			SearchOceanRouteYDListVO[] searchOceanRouteYDListVOs){
		this.searchOceanRouteYDListVOs = searchOceanRouteYDListVOs;
	}
}