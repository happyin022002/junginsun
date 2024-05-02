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
package com.clt.apps.opus.esd.prd.networklinkmanage.constraintmanage.event;

import com.clt.apps.opus.esd.prd.networklinkmanage.constraintmanage.vo.CheckCommodityVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.constraintmanage.vo.ConstraintVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.constraintmanage.vo.SearchHubConstraintListVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.constraintmanage.vo.SearchLinkConstraintVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.constraintmanage.vo.SearchNodeConstraintVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.constraintmanage.vo.SearchRouteConstraintVO;
import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESD_PRD_024 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_PRD_024HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Su-Jung Kim
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdPrd0024Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	private ConstraintVO constraintVO = null;
	private SearchLinkConstraintVO searchLinkConstraintVO = null;
	private SearchNodeConstraintVO searchNodeConstraintVO = null;
	private SearchRouteConstraintVO searchRouteConstraintVO = null;
	private SearchLinkConstraintVO[] searchLinkConstraintVOs = null;
	private SearchNodeConstraintVO[] searchNodeConstraintVOs = null;
	private SearchRouteConstraintVO[] searchRouteConstraintVOs = null;
	private ConstraintVO[] constraintVOs = null;
	private CheckCommodityVO checkCommodityVO = null;
	private CheckCommodityVO[] checkCommodityVOs = null;
	private SearchHubConstraintListVO[] searchHubConstraintListVOs = null;
	private String row = "";

	/**
	 * 
	 * @return
	 */
	public CheckCommodityVO getCheckCommodityVO() {
		return checkCommodityVO;
	}

	/**
	 * 
	 * @param checkCommodityVO
	 */
	public void setCheckCommodityVO(CheckCommodityVO checkCommodityVO) {
		this.checkCommodityVO = checkCommodityVO;
	}

	/**
	 * 
	 * @return
	 */
	public CheckCommodityVO[] getCheckCommodityVOs() {
		CheckCommodityVO[] tmpVOs = null;
		if (this.checkCommodityVOs != null) {
			tmpVOs = new CheckCommodityVO[checkCommodityVOs.length];
			System.arraycopy(checkCommodityVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	/**
	 * 
	 * @param checkCommodityVOs
	 */
	public void setCheckCommodityVOs(CheckCommodityVO[] checkCommodityVOs) {
		if (checkCommodityVOs != null) {
			CheckCommodityVO[] tmpVOs = new CheckCommodityVO[checkCommodityVOs.length];
			System.arraycopy(checkCommodityVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.checkCommodityVOs = tmpVOs;
		}
	}

	/**
	 * 
	 * @return
	 */
	public SearchLinkConstraintVO getSearchLinkConstraintVO() {
		return searchLinkConstraintVO;
	}

	/**
	 * 
	 * @param searchLinkConstraintVO
	 */
	public void setSearchLinkConstraintVO(SearchLinkConstraintVO searchLinkConstraintVO) {
		this.searchLinkConstraintVO = searchLinkConstraintVO;
	}

	/**
	 * 
	 * @return
	 */
	public SearchNodeConstraintVO getSearchNodeConstraintVO() {
		return searchNodeConstraintVO;
	}

	/**
	 * 
	 * @param searchNodeConstraintVO
	 */
	public void setSearchNodeConstraintVO(SearchNodeConstraintVO searchNodeConstraintVO) {
		this.searchNodeConstraintVO = searchNodeConstraintVO;
	}

	/**
	 * 
	 * @return
	 */
	public SearchRouteConstraintVO getSearchRouteConstraintVO() {
		return searchRouteConstraintVO;
	}

	/**
	 * 
	 * @param searchRouteConstraintVO
	 */
	public void setSearchRouteConstraintVO(SearchRouteConstraintVO searchRouteConstraintVO) {
		this.searchRouteConstraintVO = searchRouteConstraintVO;
	}

	/**
	 * 
	 * @return
	 */
	public SearchLinkConstraintVO[] getSearchLinkConstraintVOs() {
		SearchLinkConstraintVO[] tmpVOs = null;
		if (this.searchLinkConstraintVOs != null) {
			tmpVOs = new SearchLinkConstraintVO[searchLinkConstraintVOs.length];
			System.arraycopy(searchLinkConstraintVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	/**
	 * 
	 * @param searchLinkConstraintVOs
	 */
	public void setSearchLinkConstraintVOs(SearchLinkConstraintVO[] searchLinkConstraintVOs) {
		if (searchLinkConstraintVOs != null) {
			SearchLinkConstraintVO[] tmpVOs = new SearchLinkConstraintVO[searchLinkConstraintVOs.length];
			System.arraycopy(searchLinkConstraintVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.searchLinkConstraintVOs = tmpVOs;
		}
	}

	/**
	 * 
	 * @return
	 */
	public SearchNodeConstraintVO[] getSearchNodeConstraintVOs() {
		SearchNodeConstraintVO[] tmpVOs = null;
		if (this.searchNodeConstraintVOs != null) {
			tmpVOs = new SearchNodeConstraintVO[this.searchNodeConstraintVOs.length];
			System.arraycopy(this.searchNodeConstraintVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	/**
	 * 
	 * @param searchNodeConstraintVOs
	 */
	public void setSearchNodeConstraintVOs(SearchNodeConstraintVO[] searchNodeConstraintVOs) {
		if (searchNodeConstraintVOs != null) {
			SearchNodeConstraintVO[] tmpVOs = new SearchNodeConstraintVO[searchNodeConstraintVOs.length];
			System.arraycopy(searchNodeConstraintVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.searchNodeConstraintVOs = tmpVOs;
		}
	}

	/**
	 * 
	 * @return
	 */
	public SearchRouteConstraintVO[] getSearchRouteConstraintVOs() {
		SearchRouteConstraintVO[] tmpVOs = null;
		if (this.searchRouteConstraintVOs != null) {
			tmpVOs = new SearchRouteConstraintVO[this.searchRouteConstraintVOs.length];
			System.arraycopy(this.searchRouteConstraintVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	/**
	 * 
	 * @param searchRouteConstraintVOs
	 */
	public void setSearchRouteConstraintVOs(SearchRouteConstraintVO[] searchRouteConstraintVOs) {
		if (searchRouteConstraintVOs != null) {
			SearchRouteConstraintVO[] tmpVOs = new SearchRouteConstraintVO[searchRouteConstraintVOs.length];
			System.arraycopy(searchRouteConstraintVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.searchRouteConstraintVOs = tmpVOs;
		}
	}

	/**
	 * 
	 * @return
	 */
	public SearchHubConstraintListVO[] getSearchHubConstraintListVOs() {
		SearchHubConstraintListVO[] tmpVOs = null;
		if (this.searchHubConstraintListVOs != null) {
			tmpVOs = new SearchHubConstraintListVO[this.searchHubConstraintListVOs.length];
			System.arraycopy(this.searchHubConstraintListVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	/**
	 * 
	 * @param searchHubConstraintListVOs
	 */
	public void setSearchHubConstraintListVOs(SearchHubConstraintListVO[] searchHubConstraintListVOs) {
		if (searchHubConstraintListVOs != null) {
			SearchHubConstraintListVO[] tmpVOs = new SearchHubConstraintListVO[searchHubConstraintListVOs.length];
			System.arraycopy(searchHubConstraintListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.searchHubConstraintListVOs = tmpVOs;
		}
	}

	/**
	 * 
	 * @return
	 */
	public String getRow() {
		return row;
	}

	/**
	 * 
	 * @param row
	 */
	public void setRow(String row) {
		this.row = row;
	}

	/**
	 * 
	 * @return
	 */
	public ConstraintVO getConstraintVO() {
		return constraintVO;
	}

	/**
	 * 
	 * @param constraintVO
	 */
	public void setConstraintVO(ConstraintVO constraintVO) {
		this.constraintVO = constraintVO;
	}

	/**
	 * 
	 * @return
	 */
	public ConstraintVO[] getConstraintVOs() {
		ConstraintVO[] tmpVOs = null;
		if (this.constraintVOs != null) {
			tmpVOs = new ConstraintVO[this.constraintVOs.length];
			System.arraycopy(this.constraintVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	/**
	 * 
	 * @param constraintVOs
	 */
	public void setConstraintVOs(ConstraintVO[] constraintVOs) {
		if (constraintVOs != null) {
			ConstraintVO[] tmpVOs = new ConstraintVO[constraintVOs.length];
			System.arraycopy(constraintVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.constraintVOs = tmpVOs;
		}
	}

	/**
	 * 
	 * @param val
	 * @return
	 */
	public String getString(String val) {
		return "";
	}

	/**
	 * 
	 * @param val
	 * @return
	 */
	public String[] getObject(String val) {
		String[] temp = new String[2];
		return temp;

	}
}
