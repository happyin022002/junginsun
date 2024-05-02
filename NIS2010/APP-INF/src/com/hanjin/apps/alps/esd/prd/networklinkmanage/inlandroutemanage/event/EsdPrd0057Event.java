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
package com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.event;

import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.vo.CheckWrsVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.vo.InlandRouteMsUSVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.vo.InlandRouteUSDetVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.vo.SearchConditionVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.vo.lnlandRouteUSVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * EsdPrd0057Event 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EST_PRD_057HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author kIm kwi-jin
 * @see UI_TESTHTMLAction 참조
 * @since J2EE 1.6
 */
public class EsdPrd0057Event extends EventSupport{

	private static final long serialVersionUID = 1L;
	private lnlandRouteUSVO inlandRouteUSVO = null;
	private lnlandRouteUSVO[] inlandRouteUSVOs = null;
	private InlandRouteUSDetVO inlandRouteUSDetVO = null;
	private InlandRouteMsUSVO inlandRouteMsUSVO = null;
	private InlandRouteMsUSVO[] inlandRouteMsUSVOs = null;

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
	public InlandRouteMsUSVO[] getInlandRouteMsUSVOs(){
		return inlandRouteMsUSVOs;
	}

	/**
	 *
	 * @param inlandRouteMsUSVOs
	 */
	public void setInlandRouteMsUSVOs(InlandRouteMsUSVO[] inlandRouteMsUSVOs){
		this.inlandRouteMsUSVOs = inlandRouteMsUSVOs;
	}
	private CheckWrsVO checkWrsVO = null;
	private CheckWrsVO[] checkWrsVOs = null;

	/**
	 *
	 * @return
	 */
	public CheckWrsVO getCheckWrsVO(){
		return checkWrsVO;
	}

	/**
	 *
	 * @param checkWrsVO
	 */
	public void setCheckWrsVO(CheckWrsVO checkWrsVO){
		this.checkWrsVO = checkWrsVO;
	}

	/**
	 *
	 * @return
	 */
	public CheckWrsVO[] getCheckWrsVOs(){
		return checkWrsVOs;
	}

	/**
	 *
	 * @param checkWrsVOs
	 */
	public void setCheckWrsVOs(CheckWrsVO[] checkWrsVOs){
		this.checkWrsVOs = checkWrsVOs;
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
	private InlandRouteUSDetVO[] inlandRouteUSDetVOs = null;
	private SearchConditionVO searchConditionVO = null;

	/**
	 *
	 * @return
	 */
	public InlandRouteUSDetVO getInlandRouteUSDetVO(){
		return inlandRouteUSDetVO;
	}

	/**
	 *
	 * @param inlandRouteUSDetVO
	 */
	public void setInlandRouteUSDetVO(InlandRouteUSDetVO inlandRouteUSDetVO){
		this.inlandRouteUSDetVO = inlandRouteUSDetVO;
	}

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

	/**
	 *
	 * @return
	 */
	public lnlandRouteUSVO getInlandRouteUSVO(){
		return inlandRouteUSVO;
	}

	/**
	 *
	 * @param inlandRouteUSVO
	 */
	public void setInlandRouteUSVO(lnlandRouteUSVO inlandRouteUSVO){
		this.inlandRouteUSVO = inlandRouteUSVO;
	}

	/**
	 *
	 * @return
	 */
	public lnlandRouteUSVO[] getInlandRouteUSVOs(){
		return inlandRouteUSVOs;
	}

	/**
	 *
	 * @param inlandRouteUSVOs
	 */
	public void setInlandRouteUSVOs(lnlandRouteUSVO[] inlandRouteUSVOs){
		this.inlandRouteUSVOs = inlandRouteUSVOs;
	}
}
