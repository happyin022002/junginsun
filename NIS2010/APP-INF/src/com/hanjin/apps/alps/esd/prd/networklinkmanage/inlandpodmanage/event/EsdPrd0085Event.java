/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ESD_PRD_085Event.java
 *@FileTitle : ESD_PRD_085Event
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009-08-24
 *@LastModifier : Noh Seung Bae
 *@LastVersion : 1.0
 * 2009-08-24 Noh Seung Bae
 * 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandpodmanage.event;

import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandpodmanage.vo.SearchPodListVO;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESD_PRD_085 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_PRD_085HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author noh seung bae
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdPrd0085Event extends EventSupport{

	/**
	 * 
	 */
	public EsdPrd0085Event(){
	}
	private SearchPodListVO searchPodListVO = null;
	private SearchPodListVO[] searchPodListVOs = null;

	/**
	 *
	 * @return
	 */
	public SearchPodListVO getSearchPodListVO(){
		return searchPodListVO;
	}

	/**
	 *
	 * @param searchPodListVO
	 */
	public void setSearchPodListVO(SearchPodListVO searchPodListVO){
		this.searchPodListVO = searchPodListVO;
	}

	/**
	 *
	 * @return
	 */
	public SearchPodListVO[] getSearchPodListVOs(){
		return searchPodListVOs;
	}

	/**
	 *
	 * @param searchPodListVOs
	 */
	public void setSearchPodListVOs(SearchPodListVO[] searchPodListVOs){
		this.searchPodListVOs = searchPodListVOs;
	}

	/**
	 *
	 * @param args
	 * @return
	 */
	public String getString(String args){
		return "";
	}
}
