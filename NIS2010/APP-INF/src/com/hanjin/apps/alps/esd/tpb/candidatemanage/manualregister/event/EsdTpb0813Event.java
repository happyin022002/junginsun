/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdTpb916Event.java
*@FileTitle : Select Staff
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.06
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2009.08.06 박성진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.candidatemanage.manualregister.event;

import com.hanjin.apps.alps.esd.tpb.candidatemanage.manualregister.vo.SearchTPBOfficeListVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_TPB_916 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_TPB_916HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SungJin Park
 * @see ESD_TPB_0813HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdTpb0813Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchTPBOfficeListVO searchTPBOfficeListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchTPBOfficeListVO[] searchTPBOfficeListVOs = null;

	public EsdTpb0813Event(){}
	
	
	
	public SearchTPBOfficeListVO getSearchTPBOfficeListVO() {
		return searchTPBOfficeListVO;
	}



	public void setSearchTPBOfficeListVO(SearchTPBOfficeListVO searchTPBOfficeListVO) {
		this.searchTPBOfficeListVO = searchTPBOfficeListVO;
	}



	public SearchTPBOfficeListVO[] getSearchTPBOfficeListVOs() {
		return searchTPBOfficeListVOs;
	}



	public void setSearchTPBOfficeListVOs(
			SearchTPBOfficeListVO[] searchTPBOfficeListVOs) {
		this.searchTPBOfficeListVOs = searchTPBOfficeListVOs;
	}

}