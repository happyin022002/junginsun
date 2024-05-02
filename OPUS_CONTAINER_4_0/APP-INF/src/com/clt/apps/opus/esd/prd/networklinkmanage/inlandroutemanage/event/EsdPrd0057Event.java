/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsdPrd0057Event.java
 *@FileTitle : Inland Route Management USA
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.03.03
 *@LastModifier : 김귀진
 *@LastVersion : 1.0
 * 2009.08.03 김귀진
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.event;

import com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.vo.InlandRouteMsUSVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.vo.InlandRouteUSDetVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.vo.SearchConditionVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.vo.lnlandRouteUSVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * EsdPrd0057Event 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - EST_PRD_057HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author kIm kwi-jin
 * @see UI_TESTHTMLAction 참조
 * @since J2EE 1.6
 */
public class EsdPrd0057Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	private lnlandRouteUSVO inlandRouteUSVO = null;
	private lnlandRouteUSVO[] inlandRouteUSVOs = null;
	private InlandRouteUSDetVO inlandRouteUSDetVO = null;
	private InlandRouteMsUSVO inlandRouteMsUSVO = null;
	private InlandRouteMsUSVO[] inlandRouteMsUSVOs = null;

	private InlandRouteUSDetVO[] inlandRouteUSDetVOs = null;
	private SearchConditionVO searchConditionVO = null;

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
	public InlandRouteMsUSVO[] getInlandRouteMsUSVOs() {
		InlandRouteMsUSVO[] tmpVOs = null;
		if (this.inlandRouteMsUSVOs != null) {
			tmpVOs = new InlandRouteMsUSVO[this.inlandRouteMsUSVOs.length];
			System.arraycopy(this.inlandRouteMsUSVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	/**
	 * 
	 * @param inlandRouteMsUSVOs
	 */
	public void setInlandRouteMsUSVOs(InlandRouteMsUSVO[] inlandRouteMsUSVOs) {
		if (inlandRouteMsUSVOs != null) {
			InlandRouteMsUSVO[] tmpVOs = new InlandRouteMsUSVO[inlandRouteMsUSVOs.length];
			System.arraycopy(inlandRouteMsUSVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.inlandRouteMsUSVOs = tmpVOs;
		}
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
	public InlandRouteUSDetVO getInlandRouteUSDetVO() {
		return inlandRouteUSDetVO;
	}

	/**
	 * 
	 * @param inlandRouteUSDetVO
	 */
	public void setInlandRouteUSDetVO(InlandRouteUSDetVO inlandRouteUSDetVO) {
		this.inlandRouteUSDetVO = inlandRouteUSDetVO;
	}

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
	public lnlandRouteUSVO getInlandRouteUSVO() {
		return inlandRouteUSVO;
	}

	/**
	 * 
	 * @param inlandRouteUSVO
	 */
	public void setInlandRouteUSVO(lnlandRouteUSVO inlandRouteUSVO) {
		this.inlandRouteUSVO = inlandRouteUSVO;
	}

	/**
	 * 
	 * @return
	 */
	public lnlandRouteUSVO[] getInlandRouteUSVOs() {
		lnlandRouteUSVO[] tmpVOs = null;
		if (this.inlandRouteUSVOs != null) {
			tmpVOs = new lnlandRouteUSVO[this.inlandRouteUSVOs.length];
			System.arraycopy(this.inlandRouteUSVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	/**
	 * 
	 * @param inlandRouteUSVOs
	 */
	public void setInlandRouteUSVOs(lnlandRouteUSVO[] inlandRouteUSVOs) {
		if (inlandRouteUSVOs != null) {
			lnlandRouteUSVO[] tmpVOs = new lnlandRouteUSVO[inlandRouteUSVOs.length];
			System.arraycopy(inlandRouteUSVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.inlandRouteUSVOs = tmpVOs;
		}
	}
}
