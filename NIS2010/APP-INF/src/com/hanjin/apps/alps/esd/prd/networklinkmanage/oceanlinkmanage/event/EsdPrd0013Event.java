/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : EsdPrd0013Event.java
 *@FileTitle : OceanLink Mnage (EQ)
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-09-26
 *@LastModifier : kimyoungchul
 *@LastVersion : 1.0
 * 2006-09-26 kimyoungchul
 * 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanlinkmanage.event;

import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanlinkmanage.vo.SaveOceanLinkRHQVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanlinkmanage.vo.SearchOceanLinkRHQVO;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESD_PRD_013 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_PRD_013HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author kim kwijin
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdPrd0013Event extends EventSupport{

	private SearchOceanLinkRHQVO searchOceanLinkRHQVO = null;
	private SaveOceanLinkRHQVO[] saveOceanLinkRHQVOs = null;

	/**
	 *
	 * @return
	 */
	public SaveOceanLinkRHQVO[] getSaveOceanLinkRHQVOs(){
		return saveOceanLinkRHQVOs;
	}

	/**
	 *
	 * @param saveOceanLinkRHQVOs
	 */
	public void setSaveOceanLinkRHQVOs(SaveOceanLinkRHQVO[] saveOceanLinkRHQVOs){
		this.saveOceanLinkRHQVOs = saveOceanLinkRHQVOs;
	}

	/**
	 *
	 * @return
	 */
	public SearchOceanLinkRHQVO getSearchOceanLinkRHQVO(){
		return searchOceanLinkRHQVO;
	}

	/**
	 *
	 * @param searchOceanLinkRHQVO
	 */
	public void setSearchOceanLinkRHQVO(SearchOceanLinkRHQVO searchOceanLinkRHQVO){
		this.searchOceanLinkRHQVO = searchOceanLinkRHQVO;
	}

	/**
	 *
	 * @param arg1
	 * @return
	 */
	public String getString(String arg1){
		return "";
	}

	/**
	 *
	 * @param arg1
	 * @return
	 */
	public String[] getObject(String arg1){
		return new String[1];
	}
}
