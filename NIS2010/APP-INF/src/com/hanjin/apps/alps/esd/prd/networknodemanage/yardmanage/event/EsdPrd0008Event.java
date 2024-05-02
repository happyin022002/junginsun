/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : EsdPrd0003Event.java
 *@FileTitle : YardManage
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-10-24
 *@LastModifier : kimyoungchul
 *@LastVersion : 1.0
 * 2006-10-24 kimyoungchul
 * 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networknodemanage.yardmanage.event;

import com.hanjin.apps.alps.esd.prd.networknodemanage.yardmanage.vo.SearchYardDwellHistoryVO;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESD_PRD_008 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_PRD_008HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author kimyoungchul
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdPrd0008Event extends EventSupport{

	private SearchYardDwellHistoryVO searchYardDwellHistoryVO = null;
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public EsdPrd0008Event(){
	}
	private SearchYardDwellHistoryVO[] searchYardDwellHistoryVOs = null;

	/**
	 *
	 * @return
	 */
	public SearchYardDwellHistoryVO getSearchYardDwellHistoryVO(){
		return searchYardDwellHistoryVO;
	}

	/**
	 *
	 * @param searchYardDwellHistoryVO
	 */
	public void setSearchYardDwellHistoryVO(SearchYardDwellHistoryVO searchYardDwellHistoryVO){
		this.searchYardDwellHistoryVO = searchYardDwellHistoryVO;
	}

	/**
	 *
	 * @return
	 */
	public SearchYardDwellHistoryVO[] getSearchYardDwellHistoryVOs(){
		return searchYardDwellHistoryVOs;
	}

	/**
	 *
	 * @param searchYardDwellHistoryVOs
	 */
	public void setSearchYardDwellHistoryVOs(SearchYardDwellHistoryVO[] searchYardDwellHistoryVOs){
		this.searchYardDwellHistoryVOs = searchYardDwellHistoryVOs;
	}
}
