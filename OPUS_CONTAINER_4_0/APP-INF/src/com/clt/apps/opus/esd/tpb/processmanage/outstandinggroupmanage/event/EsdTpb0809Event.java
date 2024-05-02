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
* 2009.09.04 Sun, CHOI		1.1 Renewal Migration
=========================================================*/
package com.clt.apps.opus.esd.tpb.processmanage.outstandinggroupmanage.event;

import java.util.Arrays;

import com.clt.apps.opus.esd.tpb.processmanage.outstandinggroupmanage.vo.SearchOutstandinggroupManageListVO;
import com.clt.framework.support.layer.event.EventSupport;


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
		if(searchOutstandinggroupManageListVOs != null){
			SearchOutstandinggroupManageListVO[] tmpVOs = Arrays.copyOf(searchOutstandinggroupManageListVOs, searchOutstandinggroupManageListVOs.length);
			this.searchOutstandinggroupManageListVOs = tmpVOs;
		}
	}

	public SearchOutstandinggroupManageListVO getSearchOutstandinggroupManageListVO(){
		return searchOutstandinggroupManageListVO;
	}

	public SearchOutstandinggroupManageListVO[] getSearchOutstandinggroupManageListVOS(){
		SearchOutstandinggroupManageListVO[] rtnVOs = null;
		if (this.searchOutstandinggroupManageListVOs != null) {
			rtnVOs = Arrays.copyOf(searchOutstandinggroupManageListVOs, searchOutstandinggroupManageListVOs.length);
		}
		return rtnVOs;
	}

}