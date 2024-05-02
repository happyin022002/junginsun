/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdTpb0133Event.java
*@FileTitle : InterfacedCancel
*Open Issues :
*Change history :
*@LastModifyDate : 2009-09-16
*@LastModifier : Jong-Geon Byeon
*@LastVersion : 1.1
* 2009-04-01 O Wan-Ki 			1.0		최초 생성
* 2009-09-16 Jong-Geon Byeon	1.1 	ALPS Migration
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.candidatemanage.interfacedcancel.event;

import com.hanjin.apps.alps.esd.tpb.candidatemanage.interfacedcancel.vo.SearchInterfacedCancelListVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESD_TPB_0133 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_TPB_0133HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author GUN-HA HWANG
 * @see ESD_TPB_0133HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdTpb0133Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchInterfacedCancelListVO searchInterfacedCancelListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchInterfacedCancelListVO[] searchInterfacedCancelListVOs = null;

	
	public EsdTpb0133Event(){}
	
	public void setSearchInterfacedCancelListVO(SearchInterfacedCancelListVO SearchInterfacedCancelListVO){
		this. searchInterfacedCancelListVO = SearchInterfacedCancelListVO;
	}

	public void setSearchInterfacedCancelListVOS(SearchInterfacedCancelListVO[] SearchInterfacedCancelListVOs){
		this. searchInterfacedCancelListVOs = SearchInterfacedCancelListVOs;
	}
	
	public SearchInterfacedCancelListVO getSearchInterfacedCancelListVO(){
		return searchInterfacedCancelListVO;
	}

	public SearchInterfacedCancelListVO[] getSearchInterfacedCancelListVOS(){
		return searchInterfacedCancelListVOs;
	}
}