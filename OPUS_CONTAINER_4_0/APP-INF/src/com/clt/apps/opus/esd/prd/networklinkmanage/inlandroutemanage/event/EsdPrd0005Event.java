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
package com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.event;

import com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.vo.GetReferenceNoVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.vo.InlandRouteDetVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.vo.InlandRouteMsUSVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.vo.InlandRouteUSDetVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.vo.InlandRouteVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.vo.RowSearchInlandRouteManageVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.vo.SearchConditionVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.vo.SearchInlandRouteManageAsiaEuVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * EsdPrd0005Event 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - EST_PRD_005HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author kIm kwi-jin
 * @see UI_TESTHTMLAction 참조
 * @since J2EE 1.6
 */
public class EsdPrd0005Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	private InlandRouteVO inlandRouteVO = null;
	private InlandRouteVO[] inlandRouteVOs = null;
	private InlandRouteDetVO inlandRouteDetVO = null;
	private InlandRouteDetVO[] inlandRouteDetVOs = null;
	private RowSearchInlandRouteManageVO rowSearchInlandRouteManageVO = null;
	private RowSearchInlandRouteManageVO[] rowSearchInlandRouteManageVOs = null;
	private SearchInlandRouteManageAsiaEuVO[] searchInlandRouteManageAsiaEuVOs = null;
	private SearchConditionVO searchConditionVO = null;
	private InlandRouteMsUSVO inlandRouteMsUSVO = null;
	private InlandRouteUSDetVO[] inlandRouteUSDetVOs = null;
	private GetReferenceNoVO getReferenceNoVO = null;
	private GetReferenceNoVO[] getReferenceNoVOs = null;

	/**
	 * 
	 * @return
	 */
	public InlandRouteUSDetVO[] getInlandRouteUSDetVOs() {
		InlandRouteUSDetVO[] tmpVOs = null;
		if (this.inlandRouteUSDetVOs != null) {
			tmpVOs = new InlandRouteUSDetVO[this.inlandRouteUSDetVOs.length];
			System.arraycopy(this.inlandRouteUSDetVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	/**
	 * 
	 * @param inlandRouteUSDetVOs
	 */
	public void setInlandRouteUSDetVOs(InlandRouteUSDetVO[] inlandRouteUSDetVOs) {
		if (inlandRouteUSDetVOs != null) {
			InlandRouteUSDetVO[] tmpVOs = new InlandRouteUSDetVO[inlandRouteUSDetVOs.length];
			System.arraycopy(inlandRouteUSDetVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.inlandRouteUSDetVOs = tmpVOs;
		}
	}

	/**
	 * 
	 * @return
	 */
	public InlandRouteMsUSVO getInlandRouteMsUSVO() {
		return inlandRouteMsUSVO;
	}

	/**
	 * 
	 * @param inlandRouteMsUSVO
	 */
	public void setInlandRouteMsUSVO(InlandRouteMsUSVO inlandRouteMsUSVO) {
		this.inlandRouteMsUSVO = inlandRouteMsUSVO;
	}

	/**
	 * 
	 * @return
	 */
	public SearchConditionVO getSearchConditionVO() {
		return searchConditionVO;
	}

	/**
	 * 
	 * @param searchConditionVO
	 */
	public void setSearchConditionVO(SearchConditionVO searchConditionVO) {
		this.searchConditionVO = searchConditionVO;
	}

	/**
	 * 
	 * @return
	 */
	public SearchInlandRouteManageAsiaEuVO[] getSearchInlandRouteManageAsiaEuVOs() {
		SearchInlandRouteManageAsiaEuVO[] tmpVOs = null;
		if (this.searchInlandRouteManageAsiaEuVOs != null) {
			tmpVOs = new SearchInlandRouteManageAsiaEuVO[this.searchInlandRouteManageAsiaEuVOs.length];
			System.arraycopy(this.searchInlandRouteManageAsiaEuVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	/**
	 * 
	 * @param searchInlandRouteManageAsiaEuVOs
	 */
	public void setSearchInlandRouteManageAsiaEuVOs(SearchInlandRouteManageAsiaEuVO[] searchInlandRouteManageAsiaEuVOs) {
		if (searchInlandRouteManageAsiaEuVOs != null) {
			SearchInlandRouteManageAsiaEuVO[] tmpVOs = new SearchInlandRouteManageAsiaEuVO[searchInlandRouteManageAsiaEuVOs.length];
			System.arraycopy(searchInlandRouteManageAsiaEuVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.searchInlandRouteManageAsiaEuVOs = tmpVOs;
		}
	}

	/**
	 * 
	 * @return
	 */
	public GetReferenceNoVO getGetReferenceNoVO() {
		return getReferenceNoVO;
	}

	/**
	 * 
	 * @param getReferenceNoVO
	 */
	public void setGetReferenceNoVO(GetReferenceNoVO getReferenceNoVO) {
		this.getReferenceNoVO = getReferenceNoVO;
	}

	/**
	 * 
	 * @return
	 */
	public GetReferenceNoVO[] getGetReferenceNoVOs() {
		GetReferenceNoVO[] tmpVOs = null;
		if (this.getReferenceNoVOs != null) {
			tmpVOs = new GetReferenceNoVO[this.getReferenceNoVOs.length];
			System.arraycopy(this.getReferenceNoVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	/**
	 * 
	 * @param getReferenceNoVOs
	 */
	public void setGetReferenceNoVOs(GetReferenceNoVO[] getReferenceNoVOs) {
		if (getReferenceNoVOs != null) {
			GetReferenceNoVO[] tmpVOs = new GetReferenceNoVO[getReferenceNoVOs.length];
			System.arraycopy(getReferenceNoVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.getReferenceNoVOs = tmpVOs;
		}
	}

	/**
	 * 
	 * @return
	 */
	public RowSearchInlandRouteManageVO getRowSearchInlandRouteManageVO() {
		return rowSearchInlandRouteManageVO;
	}

	/**
	 * 
	 * @param rowSearchInlandRouteManageVO
	 */
	public void setRowSearchInlandRouteManageVO(RowSearchInlandRouteManageVO rowSearchInlandRouteManageVO) {
		this.rowSearchInlandRouteManageVO = rowSearchInlandRouteManageVO;
	}

	/**
	 * 
	 * @return
	 */
	public RowSearchInlandRouteManageVO[] getRowSearchInlandRouteManageVOs() {
		RowSearchInlandRouteManageVO[] tmpVOs = null;
		if (this.rowSearchInlandRouteManageVOs != null) {
			tmpVOs = new RowSearchInlandRouteManageVO[this.rowSearchInlandRouteManageVOs.length];
			System.arraycopy(this.rowSearchInlandRouteManageVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	/**
	 * 
	 * @param rowSearchInlandRouteManageVOs
	 */
	public void setRowSearchInlandRouteManageVOs(RowSearchInlandRouteManageVO[] rowSearchInlandRouteManageVOs) {
		if (rowSearchInlandRouteManageVOs != null) {
			RowSearchInlandRouteManageVO[] tmpVOs = new RowSearchInlandRouteManageVO[rowSearchInlandRouteManageVOs.length];
			System.arraycopy(rowSearchInlandRouteManageVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.rowSearchInlandRouteManageVOs = tmpVOs;
		}
	}

	/**
	 * 
	 * @return
	 */
	public InlandRouteDetVO getInlandRouteDetVO() {
		return inlandRouteDetVO;
	}

	/**
	 * 
	 * @param inlandRouteDetVO
	 */
	public void setInlandRouteDetVO(InlandRouteDetVO inlandRouteDetVO) {
		this.inlandRouteDetVO = inlandRouteDetVO;
	}

	/**
	 * 
	 * @return
	 */
	public InlandRouteDetVO[] getInlandRouteDetVOs() {
		InlandRouteDetVO[] tmpVOs = null;
		if (this.inlandRouteDetVOs != null) {
			tmpVOs = new InlandRouteDetVO[this.inlandRouteDetVOs.length];
			System.arraycopy(this.inlandRouteDetVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	/**
	 * 
	 * @param inlandRouteDetVOs
	 */
	public void setInlandRouteDetVOs(InlandRouteDetVO[] inlandRouteDetVOs) {
		if (inlandRouteDetVOs != null) {
			InlandRouteDetVO[] tmpVOs = new InlandRouteDetVO[inlandRouteDetVOs.length];
			System.arraycopy(inlandRouteDetVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.inlandRouteDetVOs = tmpVOs;
		}
	}

	/**
	 * 
	 * @return
	 */
	public InlandRouteVO getInlandRouteVO() {
		return inlandRouteVO;
	}

	/**
	 * 
	 * @param inlandRouteVO
	 */
	public void setInlandRouteVO(InlandRouteVO inlandRouteVO) {
		this.inlandRouteVO = inlandRouteVO;
	}

	/**
	 * 
	 * @return
	 */
	public InlandRouteVO[] getInlandRouteVOs() {
		InlandRouteVO[] tmpVOs = null;
		if (this.inlandRouteVOs != null) {
			tmpVOs = new InlandRouteVO[this.inlandRouteVOs.length];
			System.arraycopy(this.inlandRouteVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	/**
	 * 
	 * @param inlandRouteVOs
	 */
	public void setInlandRouteVOs(InlandRouteVO[] inlandRouteVOs) {
		if (inlandRouteVOs != null) {
			InlandRouteVO[] tmpVOs = new InlandRouteVO[inlandRouteVOs.length];
			System.arraycopy(inlandRouteVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.inlandRouteVOs = tmpVOs;
		}
	}
}
