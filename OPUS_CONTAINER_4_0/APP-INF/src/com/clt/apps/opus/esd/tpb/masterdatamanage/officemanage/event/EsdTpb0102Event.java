/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdTbp0102Event.java
*@FileTitle : CodeManage
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.11
*@LastModifier : 최 선
*@LastVersion : 1.0
* 2009.07.02 황건하
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tpb.masterdatamanage.officemanage.event;

import java.util.Arrays;

import com.clt.apps.opus.esd.tpb.masterdatamanage.officemanage.vo.SearchOfficeListVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESD_TBP_0102 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_TBP_0102HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author GUN-HA HWANG
 * @see ESD_TPB_0102HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdTpb0102Event extends EventSupport {

private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchOfficeListVO searchOfficeListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchOfficeListVO[] searchOfficeListVOs = null;

	public EsdTpb0102Event(){}
	
	public void setSearchOfficeListVO(SearchOfficeListVO searchOfficeListVO){
		this. searchOfficeListVO = searchOfficeListVO;
	}

	public void setSearchOfficeListVOS(SearchOfficeListVO[] searchOfficeListVOs){
		if(searchOfficeListVOs != null){
			SearchOfficeListVO[] tmpVOs = Arrays.copyOf(searchOfficeListVOs, searchOfficeListVOs.length);
			this.searchOfficeListVOs = tmpVOs;
		}
	}

	public SearchOfficeListVO getSearchOfficeListVO(){
		return searchOfficeListVO;
	}

	public SearchOfficeListVO[] getSearchOfficeListVOS(){
		SearchOfficeListVO[] rtnVOs = null;
		if (this.searchOfficeListVOs != null) {
			rtnVOs = Arrays.copyOf(searchOfficeListVOs, searchOfficeListVOs.length);
		}
		return rtnVOs;
	}

}