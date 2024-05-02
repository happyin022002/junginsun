/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdTpb0128Event.java
*@FileTitle : JOStatusInquiryConfirm
*Open Issues :
*Change history :
*@LastModifyDate : 2009-11-02
*@LastModifier : Jong-Geon Byeon
*@LastVersion : 1.1
* 2008-09-16 O Wan-Ki 			1.0	 최초 생성
* 2009-11-02 Jong-Geon Byeon	1.1 ALPS Migration
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.jocasemanage.jostatusinquiry.event;

import com.hanjin.apps.alps.esd.tpb.jocasemanage.jostatusinquiry.vo.SearchJOTPBDetailInfoVO;
import com.hanjin.apps.alps.esd.tpb.jocasemanage.jostatusinquiry.vo.SearchJOTPBDetailListVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_TPB_0128 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_TPB_0128HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author GUN-HA HWANG
 * @see ESD_TPB_0128HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdTpb0128Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchJOTPBDetailInfoVO searchJOTpbDetailInfoVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchJOTPBDetailInfoVO[] searchJOTpbDetailInfoVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchJOTPBDetailListVO searchJOTpbDetailListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchJOTPBDetailListVO[] searchJOTpbDetailListVOs = null;

	public EsdTpb0128Event(){}
	
	public void setSearchJOTpbDetailInfoVO(SearchJOTPBDetailInfoVO searchJOTpbDetailInfoVO){
		this. searchJOTpbDetailInfoVO = searchJOTpbDetailInfoVO;
	}

	public void setSearchJOTpbDetailInfoVOS(SearchJOTPBDetailInfoVO[] searchJOTpbDetailInfoVOs){
		this. searchJOTpbDetailInfoVOs = searchJOTpbDetailInfoVOs;
	}

	public SearchJOTPBDetailInfoVO getSearchJOTpbDetailInfoVO(){
		return searchJOTpbDetailInfoVO;
	}

	public SearchJOTPBDetailInfoVO[] getSearchJOTpbDetailInfoVOS(){
		return searchJOTpbDetailInfoVOs;
	}
	
	
	public void setSearchJOTpbDetailListVO(SearchJOTPBDetailListVO searchJOTpbDetailListVO){
		this. searchJOTpbDetailListVO = searchJOTpbDetailListVO;
	}

	public void setSearchJOTpbDetailListVOS(SearchJOTPBDetailListVO[] searchJOTpbDetailListVOs){
		this. searchJOTpbDetailListVOs = searchJOTpbDetailListVOs;
	}

	public SearchJOTPBDetailListVO getSearchJOTpbDetailListVO(){
		return searchJOTpbDetailListVO;
	}

	public SearchJOTPBDetailListVO[] getSearchJOTpbDetailListVOS(){
		return searchJOTpbDetailListVOs;
	}

}