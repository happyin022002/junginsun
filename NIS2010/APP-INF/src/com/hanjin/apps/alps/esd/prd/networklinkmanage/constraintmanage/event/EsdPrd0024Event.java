/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : EsdPrd0024Event.java
 *@FileTitle :
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2008-01-15
 *@LastModifier : Su-Jung Kim
 *@LastVersion : 1.0
 * 2008-01-15 Su-Jung Kim
 * 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.constraintmanage.event;

import com.hanjin.apps.alps.esd.prd.networklinkmanage.constraintmanage.vo.CheckCommodityVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.constraintmanage.vo.ConstraintVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.constraintmanage.vo.SearchLinkConstraintVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.constraintmanage.vo.SearchNodeConstraintVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.constraintmanage.vo.SearchRouteConstraintVO;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESD_PRD_024 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_PRD_024HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Su-Jung Kim
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdPrd0024Event extends EventSupport{

	private static final long serialVersionUID = 1L;
	private ConstraintVO constraintVO = null;
	private ConstraintVO[] constraintVOs = null;
	private SearchLinkConstraintVO searchLinkConstraintVO = null;
	private SearchNodeConstraintVO searchNodeConstraintVO = null;
	private SearchRouteConstraintVO searchRouteConstraintVO = null;
	private SearchLinkConstraintVO[] searchLinkConstraintVOs = null;
	private SearchNodeConstraintVO[] searchNodeConstraintVOs = null;
	private SearchRouteConstraintVO[] searchRouteConstraintVOs = null;
	private CheckCommodityVO checkCommodityVO = null;
	private CheckCommodityVO[] checkCommodityVOs = null;
	private String row = "";

	/**
	 *
	 * @return
	 */
	public CheckCommodityVO getCheckCommodityVO(){
		return checkCommodityVO;
	}

	/**
	 *
	 * @param checkCommodityVO
	 */
	public void setCheckCommodityVO(CheckCommodityVO checkCommodityVO){
		this.checkCommodityVO = checkCommodityVO;
	}

	/**
	 *
	 * @return
	 */
	public CheckCommodityVO[] getCheckCommodityVOs(){
		return checkCommodityVOs;
	}

	/**
	 *
	 * @param checkCommodityVOs
	 */
	public void setCheckCommodityVOs(CheckCommodityVO[] checkCommodityVOs){
		this.checkCommodityVOs = checkCommodityVOs;
	}

	/**
	 *
	 * @return
	 */
	public SearchLinkConstraintVO getSearchLinkConstraintVO(){
		return searchLinkConstraintVO;
	}

	/**
	 *
	 * @param searchLinkConstraintVO
	 */
	public void setSearchLinkConstraintVO(
			SearchLinkConstraintVO searchLinkConstraintVO){
		this.searchLinkConstraintVO = searchLinkConstraintVO;
	}

	/**
	 *
	 * @return
	 */
	public SearchNodeConstraintVO getSearchNodeConstraintVO(){
		return searchNodeConstraintVO;
	}

	/**
	 *
	 * @param searchNodeConstraintVO
	 */
	public void setSearchNodeConstraintVO(
			SearchNodeConstraintVO searchNodeConstraintVO){
		this.searchNodeConstraintVO = searchNodeConstraintVO;
	}

	/**
	 *
	 * @return
	 */
	public SearchRouteConstraintVO getSearchRouteConstraintVO(){
		return searchRouteConstraintVO;
	}

	/**
	 *
	 * @param searchRouteConstraintVO
	 */
	public void setSearchRouteConstraintVO(
			SearchRouteConstraintVO searchRouteConstraintVO){
		this.searchRouteConstraintVO = searchRouteConstraintVO;
	}

	/**
	 *
	 * @return
	 */
	public SearchLinkConstraintVO[] getSearchLinkConstraintVOs(){
		return searchLinkConstraintVOs;
	}

	/**
	 *
	 * @param searchLinkConstraintVOs
	 */
	public void setSearchLinkConstraintVOs(
			SearchLinkConstraintVO[] searchLinkConstraintVOs){
		this.searchLinkConstraintVOs = searchLinkConstraintVOs;
	}

	/**
	 *
	 * @return
	 */
	public SearchNodeConstraintVO[] getSearchNodeConstraintVOs(){
		return searchNodeConstraintVOs;
	}

	/**
	 *
	 * @param searchNodeConstraintVOs
	 */
	public void setSearchNodeConstraintVOs(
			SearchNodeConstraintVO[] searchNodeConstraintVOs){
		this.searchNodeConstraintVOs = searchNodeConstraintVOs;
	}

	/**
	 *
	 * @return
	 */
	public SearchRouteConstraintVO[] getSearchRouteConstraintVOs(){
		return searchRouteConstraintVOs;
	}

	/**
	 *
	 * @param searchRouteConstraintVOs
	 */
	public void setSearchRouteConstraintVOs(
			SearchRouteConstraintVO[] searchRouteConstraintVOs){
		this.searchRouteConstraintVOs = searchRouteConstraintVOs;
	}

	/**
	 *
	 * @return
	 */
	public String getRow(){
		return row;
	}

	/**
	 *
	 * @param row
	 */
	public void setRow(String row){
		this.row = row;
	}

	/**
	 *
	 * @return
	 */
	public ConstraintVO getConstraintVO(){
		return constraintVO;
	}

	/**
	 *
	 * @param constraintVO
	 */
	public void setConstraintVO(ConstraintVO constraintVO){
		this.constraintVO = constraintVO;
	}

	/**
	 *
	 * @return
	 */
	public ConstraintVO[] getConstraintVOs(){
		return constraintVOs;
	}

	/**
	 *
	 * @param constraintVOs
	 */
	public void setConstraintVOs(ConstraintVO[] constraintVOs){
		this.constraintVOs = constraintVOs;
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
	public String[] getObject(String val){
		String[] temp = new String[2];
		return temp;

	}
}
