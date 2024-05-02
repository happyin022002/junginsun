/*=========================================================
 *Copyright(c) 2018 SM Lines
 *@FileName : EsdPrd0025Event.java
 *@FileTitle :
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2018-01-08
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2018-01-08 
 * 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.constraintmanage.event;

import com.hanjin.apps.alps.esd.prd.networklinkmanage.constraintmanage.vo.SearchListCnstExptVO;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESD_PRD_0025 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_PRD_0025HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdPrd0025Event extends EventSupport{

	private static final long serialVersionUID = 1L;

	private String row = "";
	
	private SearchListCnstExptVO searchListCnstExptVO = null;
	private SearchListCnstExptVO[] searchListCnstExptVOs = null;
	
	public SearchListCnstExptVO getSearchListCnstExptVO() {
		return searchListCnstExptVO;
	}

	public void setSearchListCnstExptVO(SearchListCnstExptVO searchListCnstExptVO) {
		this.searchListCnstExptVO = searchListCnstExptVO;
	}

	public SearchListCnstExptVO[] getSearchListCnstExptVOs() {
		return searchListCnstExptVOs;
	}

	public void setSearchListCnstExptVOs(
			SearchListCnstExptVO[] searchListCnstExptVOs) {
		this.searchListCnstExptVOs = searchListCnstExptVOs;
	}
	
	public String getString(String val){
		return "";
	}
	
	public String[] getObject(String val){
		String[] temp = new String[2];
		return temp;

	}
	
	public void putValue(String key, Object value){
		if(key == null){
			return;
		}
		this.setAttribute(key, value);
	}	
}
