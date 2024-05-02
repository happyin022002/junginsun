/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : EsdPrd0012Event.java
 *@FileTitle : OceanLink 정보관리 (본사관리)
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-09-19
 *@LastModifier : kimyoungchul
 *@LastVersion : 1.0
 * 2006-09-19 kimyoungchul
 * 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanlinkmanage.event;

import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanlinkmanage.vo.SaveOceanLinkVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanlinkmanage.vo.SearchOceanLinkVO;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESD_PRD_012 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_PRD_012HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author kimyoungchul
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdPrd0012Event extends EventSupport{

	private SearchOceanLinkVO searchOceanLinkVO = null;
	private SearchOceanLinkVO[] searchOceanLinkVOs = null;
	private SaveOceanLinkVO[] saveOceanLinkVOs = null;
	private String backEndJobKey = null;

	/**
	 *
	 * @return
	 */
	public SearchOceanLinkVO getSearchOceanLinkVO(){
		return searchOceanLinkVO;
	}

	/**
	 *
	 * @return
	 */
	public SaveOceanLinkVO[] getSaveOceanLinkVOs(){
		return saveOceanLinkVOs;
	}

	/**
	 *
	 * @param saveOceanLinkVOs
	 */
	public void setSaveOceanLinkVOs(SaveOceanLinkVO[] saveOceanLinkVOs){
		this.saveOceanLinkVOs = saveOceanLinkVOs;
	}

	/**
	 *
	 * @param searchOceanLinkVO
	 */
	public void setSearchOceanLinkVO(SearchOceanLinkVO searchOceanLinkVO){
		this.searchOceanLinkVO = searchOceanLinkVO;
	}

	/**
	 *
	 * @return
	 */
	public SearchOceanLinkVO[] getSearchOceanLinkVOs(){
		return searchOceanLinkVOs;
	}

	/**
	 *
	 * @param searchOceanLinkVOs
	 */
	public void setSearchOceanLinkVOs(SearchOceanLinkVO[] searchOceanLinkVOs){
		this.searchOceanLinkVOs = searchOceanLinkVOs;
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

	/**
	 * 
	 * @return
	 */
	public String getBackEndJobKey() {
		return backEndJobKey;
	}

	/**
	 * 
	 * @param backEndJobKey
	 */
	public void setBackEndJobKey(String backEndJobKey) {
		this.backEndJobKey = backEndJobKey;
	}
	
	
}
