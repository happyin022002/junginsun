/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : EsdPrd0010Event.java
 *@FileTitle : Carrier별 이용터미널 정보관리
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-10-09
 *@LastModifier : jungsunyoung
 *@LastVersion : 1.0
 * 2006-10-09 jungsunyoung
 * 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanrouteconditionmanage.event;

import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanrouteconditionmanage.vo.SearchEmbargoVO;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESD_PRD_010 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_PRD_010HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author jungsunyoung
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdPrd0010Event extends EventSupport{

	private SearchEmbargoVO searchEmbargoVO = null;
	private SearchEmbargoVO[] searchEmbargoVOs = null;

	/**
	 *
	 * @return
	 */
	public SearchEmbargoVO getSearchEmbargoVO(){
		return searchEmbargoVO;
	}

	/**
	 *
	 * @param searchEmbargoVO
	 */
	public void setSearchEmbargoVO(SearchEmbargoVO searchEmbargoVO){
		this.searchEmbargoVO = searchEmbargoVO;
	}

	/**
	 *
	 * @return
	 */
	public SearchEmbargoVO[] getSearchEmbargoVOs(){
		return searchEmbargoVOs;
	}

	/**
	 *
	 * @param searchEmbargoVOs
	 */
	public void setSearchEmbargoVOs(SearchEmbargoVO[] searchEmbargoVOs){
		this.searchEmbargoVOs = searchEmbargoVOs;
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
