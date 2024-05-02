/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TPB_0101Event.java
*@FileTitle : TPB Code Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.11
*@LastModifier : 최 선
*@LastVersion : 1.2
* 2008.08.29 O Wan-Ki 1.0 Creation
* 2009.07.02 황건하         1.1 ALPS Migration
* 2009.08.11 최 선             1.2 UI-ID 변경 (101->0101)
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.masterdatamanage.codemanage.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esd.tpb.masterdatamanage.codemanage.vo.SearchCodeListVO;


/**
 * ESD_TPB_0101 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_TPB_0101HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author GUN-HA HWANG
 * @see ESD_TPB_0101HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdTpb0101Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchCodeListVO searchCodeListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchCodeListVO[] searchCodeListVOs = null;

	public EsdTpb0101Event(){}
	
	public void setSearchCodeListVO(SearchCodeListVO searchCodeListVO){
		this. searchCodeListVO = searchCodeListVO;
	}

	public void setSearchCodeListVOS(SearchCodeListVO[] searchCodeListVOs){
		this. searchCodeListVOs = searchCodeListVOs;
	}

	public SearchCodeListVO getSearchCodeListVO(){
		return searchCodeListVO;
	}

	public SearchCodeListVO[] getSearchCodeListVOS(){
		return searchCodeListVOs;
	}
	
}