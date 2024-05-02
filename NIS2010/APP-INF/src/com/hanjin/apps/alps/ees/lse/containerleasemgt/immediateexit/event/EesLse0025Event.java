/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesLse0025Event.java
*@FileTitle : Immediate Exit Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.10
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2009.07.10 장준우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleasemgt.immediateexit.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.immediateexit.vo.ImmediateExitCreationVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.immediateexit.vo.SearchParamVO;


/**
 * EES_LSE_0025 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_LSE_0025HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jang Jun-Woo
 * @see EES_LSE_0025HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesLse0025Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchParamVO searchParamVO = null;
	
	/** Table Value Object Multi Data 처리 */
	public ImmediateExitCreationVO[] immediateExitCreationVOs = null;

	public EesLse0025Event(){}
	
	public void setSearchParamVO(SearchParamVO searchParamVO){
		this. searchParamVO = searchParamVO;
	}

	public void setImmediateExitCreationVOs(ImmediateExitCreationVO[] immediateExitCreationVOs){
		this. immediateExitCreationVOs = immediateExitCreationVOs;
	}

	public SearchParamVO getSearchParamVO(){
		return searchParamVO;
	}

	public ImmediateExitCreationVO[] getImmediateExitCreationVOs(){
		return immediateExitCreationVOs;
	}

}