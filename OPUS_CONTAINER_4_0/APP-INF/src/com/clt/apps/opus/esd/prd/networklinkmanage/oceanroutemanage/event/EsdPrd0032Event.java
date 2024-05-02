/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : EsdPrd0032Event.java
 *@FileTitle : OceanRoute Auto Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-09-26
 *@LastModifier : kimyoungchul
 *@LastVersion : 1.0
 * 2006-09-26 kimyoungchul
 * 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.prd.networklinkmanage.oceanroutemanage.event;

import com.clt.apps.opus.esd.prd.networklinkmanage.oceanroutemanage.vo.RowSearchOceanRouteManageVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.oceanroutemanage.vo.SearchOceanRouteAutoCreationVO;
import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESD_PRD_032 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_PRD_032HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author kimyoungchul
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdPrd0032Event extends EventSupport {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public EsdPrd0032Event() {
	}

	private String row = "";
	private String col = "";
	/* ★kim kiwjin 추가 2009-08-31 */
	private RowSearchOceanRouteManageVO rowSearchOceanRouteManageVO = null;
	private RowSearchOceanRouteManageVO[] rowSearchOceanRouteManageVOs = null;
	private SearchOceanRouteAutoCreationVO searchOceanRouteAutoCreationVO = null;
	private SearchOceanRouteAutoCreationVO[] searchOceanRouteAutoCreationVOs = null;

	/* ★end kim kiwjin 추가 2009-08-31 */
	/**
	 * 
	 * @return
	 */
	public SearchOceanRouteAutoCreationVO getSearchOceanRouteAutoCreationVO() {
		return searchOceanRouteAutoCreationVO;
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
	public String getCol() {
		return col;
	}

	/**
	 * 
	 * @param col
	 */
	public void setCol(String col) {
		this.col = col;
	}

	/**
	 * 
	 * @param searchOceanRouteAutoCreationVO
	 */
	public void setSearchOceanRouteAutoCreationVO(SearchOceanRouteAutoCreationVO searchOceanRouteAutoCreationVO) {
		this.searchOceanRouteAutoCreationVO = searchOceanRouteAutoCreationVO;
	}

	/**
	 * 
	 * @return
	 */
	public SearchOceanRouteAutoCreationVO[] getSearchOceanRouteAutoCreationVOs() {
		SearchOceanRouteAutoCreationVO[] tmpVOs = null;
		if (this.searchOceanRouteAutoCreationVOs != null) {
			tmpVOs = new SearchOceanRouteAutoCreationVO[this.searchOceanRouteAutoCreationVOs.length];
			System.arraycopy(this.searchOceanRouteAutoCreationVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	/**
	 * 
	 * @param searchOceanRouteAutoCreationVOs
	 */
	public void setSearchOceanRouteAutoCreationVOs(SearchOceanRouteAutoCreationVO[] searchOceanRouteAutoCreationVOs) {
		if (searchOceanRouteAutoCreationVOs != null) {
			SearchOceanRouteAutoCreationVO[] tmpVOs = new SearchOceanRouteAutoCreationVO[searchOceanRouteAutoCreationVOs.length];
			System.arraycopy(searchOceanRouteAutoCreationVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.searchOceanRouteAutoCreationVOs = tmpVOs;
		}
	}

	/**
	 * 
	 * @return
	 */
	public RowSearchOceanRouteManageVO getRowSearchOceanRouteManageVO() {
		return rowSearchOceanRouteManageVO;
	}

	/**
	 * 
	 * @param rowSearchOceanRouteManageVO
	 */
	public void setRowSearchOceanRouteManageVO(RowSearchOceanRouteManageVO rowSearchOceanRouteManageVO) {
		this.rowSearchOceanRouteManageVO = rowSearchOceanRouteManageVO;
	}

	/**
	 * 
	 * @return
	 */
	public RowSearchOceanRouteManageVO[] getRowSearchOceanRouteManageVOs() {
		RowSearchOceanRouteManageVO[] tmpVOs = null;
		if (this.rowSearchOceanRouteManageVOs != null) {
			tmpVOs = new RowSearchOceanRouteManageVO[this.rowSearchOceanRouteManageVOs.length];
			System.arraycopy(this.rowSearchOceanRouteManageVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	/**
	 * 
	 * @param rowSearchOceanRouteManageVOs
	 */
	public void setRowSearchOceanRouteManageVOs(RowSearchOceanRouteManageVO[] rowSearchOceanRouteManageVOs) {
		if (rowSearchOceanRouteManageVOs != null) {
			RowSearchOceanRouteManageVO[] tmpVOs = new RowSearchOceanRouteManageVO[rowSearchOceanRouteManageVOs.length];
			System.arraycopy(rowSearchOceanRouteManageVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.rowSearchOceanRouteManageVOs = tmpVOs;
		}
	}
}
