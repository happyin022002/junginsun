/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdTpb0135Event.java
*@FileTitle : Activity - TPB Confirmation
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.10
*@LastModifier : 손은주
*@LastVersion : 1.0
* 2010.11.10 손은주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.statusinquiry.statusinquiry.event;

import com.hanjin.apps.alps.esd.tpb.statusinquiry.statusinquiry.vo.SearchActivityByConfirmedTPBVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_TPB_0135 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_TPB_0135HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author eunju son
 * @see ESD_TPB_0135HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdTpb0135Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchActivityByConfirmedTPBVO searchActivityByConfirmedTPBVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchActivityByConfirmedTPBVO[] searchActivityByConfirmedTPBVOs = null;

	public EsdTpb0135Event(){}
	
	public void setSearchActivityByConfirmedTPBVO(SearchActivityByConfirmedTPBVO searchActivityByConfirmedTPBVO){
		this. searchActivityByConfirmedTPBVO = searchActivityByConfirmedTPBVO;
	}

	public void setSearchActivityByConfirmedTPBVOS(SearchActivityByConfirmedTPBVO[] searchActivityByConfirmedTPBVOs){
		this. searchActivityByConfirmedTPBVOs = searchActivityByConfirmedTPBVOs;
	}

	public SearchActivityByConfirmedTPBVO getSearchActivityByConfirmedTPBVO(){
		return searchActivityByConfirmedTPBVO;
	}

	public SearchActivityByConfirmedTPBVO[] getSearchActivityByConfirmedTPBVOS(){
		return searchActivityByConfirmedTPBVOs;
	}

}