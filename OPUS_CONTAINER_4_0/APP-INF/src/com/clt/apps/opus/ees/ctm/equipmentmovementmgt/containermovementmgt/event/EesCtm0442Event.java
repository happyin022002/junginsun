/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCtm0442Event.java
*@FileTitle : Detail Information
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.20
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2009.06.20 김상수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.event;

import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.SearchEDIByContainerVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.SearchEDIByResultRemarkVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_CTM_0442 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - EES_CTM_0442HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM, Sang-Soo
 * @see ees_ctm_0442HTMLAction 참조
 * @since J2EE 1.6
 */
public class EesCtm0442Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchEDIByContainerVO searchEDIByContainerVO = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchEDIByResultRemarkVO searchEDIByResultRemarkVO = null;


	public EesCtm0442Event(){}

	public void setSearchEDIByContainerVO(SearchEDIByContainerVO searchEDIByContainerVO){
		this.searchEDIByContainerVO = searchEDIByContainerVO;
	}

	public void setSearchEDIByResultRemarkVO(SearchEDIByResultRemarkVO searchEDIByResultRemarkVO){
		this.searchEDIByResultRemarkVO = searchEDIByResultRemarkVO;
	}

	public SearchEDIByContainerVO getSearchEDIByContainerVO(){
		return searchEDIByContainerVO;
	}

	public SearchEDIByResultRemarkVO getSearchEDIByResultRemarkVO(){
		return searchEDIByResultRemarkVO;
	}

}