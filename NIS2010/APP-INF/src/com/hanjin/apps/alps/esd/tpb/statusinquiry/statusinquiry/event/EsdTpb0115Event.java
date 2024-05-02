/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdTpb0115Event.java
*@FileTitle : StatusInquiryConfirm
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.11
*@LastModifier : 최 선
*@LastVersion : 1.0
* 2009.07.17 황건하
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.statusinquiry.statusinquiry.event;

import com.hanjin.apps.alps.esd.tpb.statusinquiry.statusinquiry.vo.SearchTPBDetailInfoVO;
import com.hanjin.apps.alps.esd.tpb.statusinquiry.statusinquiry.vo.SearchTPBDetailListVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_TPB_0115 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_TPB_0115HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author GUN-HA HWANG
 * @see ESD_TPB_0115HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdTpb0115Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchTPBDetailListVO searchTPBDetailListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchTPBDetailListVO[] searchTPBDetailListVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchTPBDetailInfoVO searchTPBDetailInfoVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchTPBDetailInfoVO[] searchTPBDetailInfoVOs = null;

	public EsdTpb0115Event(){}
	
	public void setSearchTPBDetailListVO(SearchTPBDetailListVO searchTPBDetailListVO){
		this. searchTPBDetailListVO = searchTPBDetailListVO;
	}

	public void setSearchTPBDetailListVOS(SearchTPBDetailListVO[] searchTPBDetailListVOs){
		this. searchTPBDetailListVOs = searchTPBDetailListVOs;
	}

	public SearchTPBDetailListVO getSearchTPBDetailListVO(){
		return searchTPBDetailListVO;
	}

	public SearchTPBDetailListVO[] getSearchTPBDetailListVOS(){
		return searchTPBDetailListVOs;
	}
	
	public void setSearchTPBDetailInfoVO(SearchTPBDetailInfoVO searchTPBDetailInfoVO){
		this. searchTPBDetailInfoVO = searchTPBDetailInfoVO;
	}

	public void setSearchTPBDetailInfoVOS(SearchTPBDetailInfoVO[] searchTPBDetailInfoVOs){
		this. searchTPBDetailInfoVOs = searchTPBDetailInfoVOs;
	}

	public SearchTPBDetailInfoVO getSearchTPBDetailInfoVO(){
		return searchTPBDetailInfoVO;
	}

	public SearchTPBDetailInfoVO[] getSearchTPBDetailInfoVOS(){
		return searchTPBDetailInfoVOs;
	}

}