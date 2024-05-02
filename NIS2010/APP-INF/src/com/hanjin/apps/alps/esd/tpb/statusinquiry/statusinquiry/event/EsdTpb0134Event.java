/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdTpb0134Event.java
*@FileTitle : StatusByTPB
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.19
*@LastModifier : 최 선
*@LastVersion : 1.0
* 2010.01.19 최 선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.statusinquiry.statusinquiry.event;

import com.hanjin.apps.alps.esd.tpb.statusinquiry.statusinquiry.vo.SearchStatusByTPBBKGVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_TPB_0134 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_TPB_0134HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Sun, CHOI
 * @see ESD_TPB_0134HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdTpb0134Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchStatusByTPBBKGVO searchStatusByTPBBKGVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchStatusByTPBBKGVO[] searchStatusByTPBBKGVOs = null;

	public EsdTpb0134Event(){}
	
	public void setSearchStatusByTPBBKGVO(SearchStatusByTPBBKGVO searchStatusByTPBBKGVO){
		this. searchStatusByTPBBKGVO = searchStatusByTPBBKGVO;
	}

	public void setSearchStatusByTPBBKGVOS(SearchStatusByTPBBKGVO[] searchStatusByTPBBKGVOs){
		this. searchStatusByTPBBKGVOs = searchStatusByTPBBKGVOs;
	}

	public SearchStatusByTPBBKGVO getSearchStatusByTPBBKGVO(){
		return searchStatusByTPBBKGVO;
	}

	public SearchStatusByTPBBKGVO[] getSearchStatusByTPBBKGVOS(){
		return searchStatusByTPBBKGVOs;
	}

}