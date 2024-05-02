/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdTpb0130Event.java
*@FileTitle : JOStatusInquiryConfirm
*Open Issues :
*Change history :
*@LastModifyDate : 2009-10-12
*@LastModifier : Jong-Geon Byeon
*@LastVersion : 1.1
* 2008-08-27 O Wan-Ki 			1.0	최초 생성
* 2009-10-12 Jong-Geon Byeon	1.1 ALPS Migration
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.jocasemanage.jostatusinquiry.event;

import com.hanjin.apps.alps.esd.tpb.jocasemanage.jostatusinquiry.vo.SearchProcessListVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_TPB_0130 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_TPB_0130HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author GUN-HA HWANG
 * @see ESD_TPB_0130HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdTpb0130Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchProcessListVO searchProcessListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchProcessListVO[] searchProcessListVOs = null;

	public EsdTpb0130Event(){}
	
	public void setSearchProcessListVO(SearchProcessListVO searchProcessListVO){
		this. searchProcessListVO = searchProcessListVO;
	}

	public void setSearchProcessListVOS(SearchProcessListVO[] searchProcessListVOs){
		this. searchProcessListVOs = searchProcessListVOs;
	}

	public SearchProcessListVO getSearchProcessListVO(){
		return searchProcessListVO;
	}

	public SearchProcessListVO[] getSearchProcessListVOS(){
		return searchProcessListVOs;
	}

}