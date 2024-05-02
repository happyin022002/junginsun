/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdTpb0116Event.java
*@FileTitle : StatusByTPB
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.11
*@LastModifier : 최 선
*@LastVersion : 1.0
* 2009.07.17 황건하
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.statusinquiry.statusinquiry.event;

import com.hanjin.apps.alps.esd.tpb.statusinquiry.statusinquiry.vo.SearchStatusByTPBVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_TPB_0116 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_TPB_0116HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author GUN-HA HWANG
 * @see ESD_TPB_0116HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdTpb0116Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchStatusByTPBVO searchStatusByTPBVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchStatusByTPBVO[] searchStatusByTPBVOs = null;

	public EsdTpb0116Event(){}
	
	public void setSearchStatusByTPBVO(SearchStatusByTPBVO searchStatusByTPBVO){
		this. searchStatusByTPBVO = searchStatusByTPBVO;
	}

	public void setSearchStatusByTPBVOS(SearchStatusByTPBVO[] searchStatusByTPBVOs){
		this. searchStatusByTPBVOs = searchStatusByTPBVOs;
	}

	public SearchStatusByTPBVO getSearchStatusByTPBVO(){
		return searchStatusByTPBVO;
	}

	public SearchStatusByTPBVO[] getSearchStatusByTPBVOS(){
		return searchStatusByTPBVOs;
	}

}