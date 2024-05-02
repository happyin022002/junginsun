/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : EsdPrd0041Event.java
 *@FileTitle : Carrier별 이용터미널 예외 정보관리
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009-02-27
 *@LastModifier : jungsunyoung
 *@LastVersion : 1.0
 * 2009-02-27 jungsunyoung
 * 1.0 최초 생성
 * * N200902100240 2009-02-27 Terminal Matrix Exception UI 추가 개발 (ESD_PRD_041)
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanrouteconditionmanage.event;

import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanrouteconditionmanage.vo.SearchCallingTmlMtxExptVO;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESD_PRD_041 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_PRD_041HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author jungsunyoung
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdPrd0041Event extends EventSupport{

	private SearchCallingTmlMtxExptVO searchCallingTmlMtxExptVO = null;
	private SearchCallingTmlMtxExptVO[] searchCallingTmlMtxExptVOs = null;

	/**
	 *
	 * @return
	 */
	public SearchCallingTmlMtxExptVO[] getSearchCallingTmlMtxExptVOs(){
		return searchCallingTmlMtxExptVOs;
	}

	/**
	 *
	 * @param searchCallingTmlMtxExptVOs
	 */
	public void setSearchCallingTmlMtxExptVOs(
			SearchCallingTmlMtxExptVO[] searchCallingTmlMtxExptVOs){
		this.searchCallingTmlMtxExptVOs = searchCallingTmlMtxExptVOs;
	}

	/**
	 *
	 * @return
	 */
	public SearchCallingTmlMtxExptVO getSearchCallingTmlMtxExptVO(){
		return searchCallingTmlMtxExptVO;
	}

	/**
	 *
	 * @param searchCallingTmlMtxExptVO
	 */
	public void setSearchCallingTmlMtxExptVO(
			SearchCallingTmlMtxExptVO searchCallingTmlMtxExptVO){
		this.searchCallingTmlMtxExptVO = searchCallingTmlMtxExptVO;
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
