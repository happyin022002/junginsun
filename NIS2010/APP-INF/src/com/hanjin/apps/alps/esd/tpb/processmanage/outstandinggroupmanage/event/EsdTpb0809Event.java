/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdTpb0809Event.java
*@FileTitle : OutstandinggroupManageConfirm
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.04
*@LastModifier : 최 선
*@LastVersion : 1.1
* 2008-09-16 Kim Jin-seung	1.0	최초 생성
* 2009.09.04 Sun, CHOI		1.1 ALPS Migration
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.processmanage.outstandinggroupmanage.event;

import com.hanjin.apps.alps.esd.tpb.processmanage.outstandinggroupmanage.vo.SearchOutstandinggroupManageListVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_TPB_0809 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_TPB_0809HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Sun, CHOI
 * @see ESD_TPB_0809HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdTpb0809Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchOutstandinggroupManageListVO searchOutstandinggroupManageListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchOutstandinggroupManageListVO[] searchOutstandinggroupManageListVOs = null;

	public EsdTpb0809Event(){}
	
	public void setSearchOutstandinggroupManageListVO(SearchOutstandinggroupManageListVO searchOutstandinggroupManageListVO){
		this. searchOutstandinggroupManageListVO = searchOutstandinggroupManageListVO;
	}

	public void setSearchOutstandinggroupManageListVOS(SearchOutstandinggroupManageListVO[] searchOutstandinggroupManageListVOs){
		this. searchOutstandinggroupManageListVOs = searchOutstandinggroupManageListVOs;
	}

	public SearchOutstandinggroupManageListVO getSearchOutstandinggroupManageListVO(){
		return searchOutstandinggroupManageListVO;
	}

	public SearchOutstandinggroupManageListVO[] getSearchOutstandinggroupManageListVOS(){
		return searchOutstandinggroupManageListVOs;
	}

}