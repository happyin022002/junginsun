/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : EsdPrd0009Event.java
 *@FileTitle : Inland Link 정보관리
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-09-19
 *@LastModifier : jungsunyong
 *@LastVersion : 1.0
 * 2006-09-19 jungsunyong
 * 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandlinkmanage.event;

import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandlinkmanage.vo.PrdInlndEachLnkVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandlinkmanage.vo.SearchInlandLinkManageListVO;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESD_PRD_009 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_PRD_009HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author jungsunyong
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdPrd0009Event extends EventSupport{

	private static final long serialVersionUID = 1L;
	PrdInlndEachLnkVO prdInlndEachLnkVO = null;
	PrdInlndEachLnkVO[] prdInlndEachLnkVOs = null;
	SearchInlandLinkManageListVO searchInlandLinkManageListVO = null;
	SearchInlandLinkManageListVO[] searchInlandLinkManageListVOs = null;

	/**
	 *
	 * @return
	 */
	public SearchInlandLinkManageListVO getSearchInlandLinkManageListVO(){
		return searchInlandLinkManageListVO;
	}

	/**
	 *
	 * @param searchInlandLinkManageListVO
	 */
	public void setSearchInlandLinkManageListVO(SearchInlandLinkManageListVO searchInlandLinkManageListVO){
		this.searchInlandLinkManageListVO = searchInlandLinkManageListVO;
	}

	/**
	 *
	 * @return
	 */
	public SearchInlandLinkManageListVO[] getSearchInlandLinkManageListVOs(){
		return searchInlandLinkManageListVOs;
	}

	/**
	 *
	 * @param searchInlandLinkManageListVOs
	 */
	public void setSearchInlandLinkManageListVOs(SearchInlandLinkManageListVO[] searchInlandLinkManageListVOs){
		this.searchInlandLinkManageListVOs = searchInlandLinkManageListVOs;
	}

	/**
	 *
	 * @return
	 */
	public PrdInlndEachLnkVO getPrdInlndEachLnkVO(){
		return prdInlndEachLnkVO;
	}

	/**
	 *
	 * @param prdInlndEachLnkVO
	 */
	public void setPrdInlndEachLnkVO(PrdInlndEachLnkVO prdInlndEachLnkVO){
		this.prdInlndEachLnkVO = prdInlndEachLnkVO;
	}

	/**
	 *
	 * @return
	 */
	public PrdInlndEachLnkVO[] getPrdInlndEachLnkVOs(){
		return prdInlndEachLnkVOs;
	}

	/**
	 *
	 * @param prdInlndEachLnkVOs
	 */
	public void setPrdInlndEachLnkVOs(PrdInlndEachLnkVO[] prdInlndEachLnkVOs){
		this.prdInlndEachLnkVOs = prdInlndEachLnkVOs;
	}
}
