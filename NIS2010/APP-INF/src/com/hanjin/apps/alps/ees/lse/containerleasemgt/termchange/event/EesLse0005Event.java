/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesLse0005Event.java
*@FileTitle : Term Change Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.03
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2009.07.03 장준우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleasemgt.termchange.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.termchange.vo.SearchParamVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.termchange.vo.TermChangeCreationVO;


/**
 * EES_LSE_0005 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_LSE_0005HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jang Jun-Woo
 * @see EES_LSE_0005HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesLse0005Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchParamVO searchParamVO = null;
	
	/** Table Value Object Multi Data 처리 */
	public TermChangeCreationVO[] termChangeCreationVOs = null;

	public EesLse0005Event(){}
	
	public void setSearchParamVO(SearchParamVO searchParamVO){
		this. searchParamVO = searchParamVO;
	}

	public void setTermChangeCreationVOs(TermChangeCreationVO[] termChangeCreationVOs){
		this. termChangeCreationVOs = termChangeCreationVOs;
	}

	public SearchParamVO getSearchParamVO(){
		return searchParamVO;
	}

	public TermChangeCreationVO[] getTermChangeCreationVOs(){
		return termChangeCreationVOs;
	}

}