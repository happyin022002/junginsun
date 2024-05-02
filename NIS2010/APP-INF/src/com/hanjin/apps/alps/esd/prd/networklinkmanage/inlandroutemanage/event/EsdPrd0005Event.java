/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsdPrd0005Event.java
 *@FileTitle : ROUTE INQUIRY
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.29
 *@LastModifier : 김귀진
 *@LastVersion : 1.0
 * 2009.07.29 김귀진
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.event;

import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.vo.GetReferenceNoVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.vo.InlandRouteDetVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.vo.InlandRouteMsUSVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.vo.InlandRouteUSDetVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.vo.InlandRouteVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.vo.RowSearchInlandRouteManageVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.vo.SearchConditionVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.vo.SearchInlandRouteManageAsiaEuVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * EsdPrd0005Event 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EST_PRD_005HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author kIm kwi-jin
 * @see UI_TESTHTMLAction 참조
 * @since J2EE 1.6
 */
public class EsdPrd0005Event extends EventSupport{

	private static final long serialVersionUID = 1L;
	private InlandRouteVO inlandRouteVO = null;
	private InlandRouteVO[] inlandRouteVOs = null;
	private InlandRouteDetVO inlandRouteDetVO = null;
	private InlandRouteDetVO[] inlandRouteDetVOs = null;
	private RowSearchInlandRouteManageVO rowSearchInlandRouteManageVO = null;
	private RowSearchInlandRouteManageVO[] rowSearchInlandRouteManageVOs = null;
	private SearchInlandRouteManageAsiaEuVO[] searchInlandRouteManageAsiaEuVOs = null;
	private SearchConditionVO searchConditionVO = null;

	/**
	 *
	 * @return
	 */
	public InlandRouteUSDetVO[] getInlandRouteUSDetVOs(){
		return inlandRouteUSDetVOs;
	}

	/**
	 *
	 * @param inlandRouteUSDetVOs
	 */
	public void setInlandRouteUSDetVOs(InlandRouteUSDetVO[] inlandRouteUSDetVOs){
		this.inlandRouteUSDetVOs = inlandRouteUSDetVOs;
	}
	private InlandRouteMsUSVO inlandRouteMsUSVO = null;
	private InlandRouteUSDetVO[] inlandRouteUSDetVOs = null;

	/**
	 *
	 * @return
	 */
	public InlandRouteMsUSVO getInlandRouteMsUSVO(){
		return inlandRouteMsUSVO;
	}

	/**
	 *
	 * @param inlandRouteMsUSVO
	 */
	public void setInlandRouteMsUSVO(InlandRouteMsUSVO inlandRouteMsUSVO){
		this.inlandRouteMsUSVO = inlandRouteMsUSVO;
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
	public SearchInlandRouteManageAsiaEuVO[] getSearchInlandRouteManageAsiaEuVOs(){
		return searchInlandRouteManageAsiaEuVOs;
	}

	/**
	 *
	 * @param searchInlandRouteManageAsiaEuVOs
	 */
	public void setSearchInlandRouteManageAsiaEuVOs(
			SearchInlandRouteManageAsiaEuVO[] searchInlandRouteManageAsiaEuVOs){
		this.searchInlandRouteManageAsiaEuVOs = searchInlandRouteManageAsiaEuVOs;
	}
	private GetReferenceNoVO getReferenceNoVO = null;
	private GetReferenceNoVO[] getReferenceNoVOs = null;

	/**
	 *
	 * @return
	 */
	public GetReferenceNoVO getGetReferenceNoVO(){
		return getReferenceNoVO;
	}

	/**
	 *
	 * @param getReferenceNoVO
	 */
	public void setGetReferenceNoVO(GetReferenceNoVO getReferenceNoVO){
		this.getReferenceNoVO = getReferenceNoVO;
	}

	/**
	 *
	 * @return
	 */
	public GetReferenceNoVO[] getGetReferenceNoVOs(){
		return getReferenceNoVOs;
	}

	/**
	 *
	 * @param getReferenceNoVOs
	 */
	public void setGetReferenceNoVOs(GetReferenceNoVO[] getReferenceNoVOs){
		this.getReferenceNoVOs = getReferenceNoVOs;
	}

	/**
	 *
	 * @return
	 */
	public RowSearchInlandRouteManageVO getRowSearchInlandRouteManageVO(){
		return rowSearchInlandRouteManageVO;
	}

	/**
	 *
	 * @param rowSearchInlandRouteManageVO
	 */
	public void setRowSearchInlandRouteManageVO(
			RowSearchInlandRouteManageVO rowSearchInlandRouteManageVO){
		this.rowSearchInlandRouteManageVO = rowSearchInlandRouteManageVO;
	}

	/**
	 *
	 * @return
	 */
	public RowSearchInlandRouteManageVO[] getRowSearchInlandRouteManageVOs(){
		return rowSearchInlandRouteManageVOs;
	}

	/**
	 *
	 * @param rowSearchInlandRouteManageVOs
	 */
	public void setRowSearchInlandRouteManageVOs(
			RowSearchInlandRouteManageVO[] rowSearchInlandRouteManageVOs){
		this.rowSearchInlandRouteManageVOs = rowSearchInlandRouteManageVOs;
	}

	/**
	 *
	 * @return
	 */
	public InlandRouteDetVO getInlandRouteDetVO(){
		return inlandRouteDetVO;
	}

	/**
	 *
	 * @param inlandRouteDetVO
	 */
	public void setInlandRouteDetVO(InlandRouteDetVO inlandRouteDetVO){
		this.inlandRouteDetVO = inlandRouteDetVO;
	}

	/**
	 *
	 * @return
	 */
	public InlandRouteDetVO[] getInlandRouteDetVOs(){
		return inlandRouteDetVOs;
	}

	/**
	 *
	 * @param inlandRouteDetVOs
	 */
	public void setInlandRouteDetVOs(InlandRouteDetVO[] inlandRouteDetVOs){
		inlandRouteDetVOs = inlandRouteDetVOs;
	}

	/**
	 *
	 * @return
	 */
	public InlandRouteVO getInlandRouteVO(){
		return inlandRouteVO;
	}

	/**
	 *
	 * @param inlandRouteVO
	 */
	public void setInlandRouteVO(InlandRouteVO inlandRouteVO){
		this.inlandRouteVO = inlandRouteVO;
	}

	/**
	 *
	 * @return
	 */
	public InlandRouteVO[] getInlandRouteVOs(){
		return inlandRouteVOs;
	}

	/**
	 *
	 * @param inlandRouteVOs
	 */
	public void setInlandRouteVOs(InlandRouteVO[] inlandRouteVOs){
		inlandRouteVOs = inlandRouteVOs;
	}
}
