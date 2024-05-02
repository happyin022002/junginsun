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
package com.clt.apps.opus.ees.lse.containerleasemgt.termchange.event;

import com.clt.apps.opus.ees.lse.containerleasemgt.termchange.vo.SearchParamVO;
import com.clt.apps.opus.ees.lse.containerleasemgt.termchange.vo.TermChangeCreationVO;
import com.clt.framework.support.layer.event.EventSupport;


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
	private TermChangeCreationVO[] termChangeCreationVOs = null;
	
	/** 검색결과 **/
	private SearchParamVO[] searchParamVOs = null;

	public EesLse0005Event(){}
	
	public void setSearchParamVO(SearchParamVO searchParamVO){
		this. searchParamVO = searchParamVO;
	}

	public void setTermChangeCreationVOs(TermChangeCreationVO[] termChangeCreationVOs){
		if (termChangeCreationVOs != null) {
			TermChangeCreationVO[] tmpVOs = new TermChangeCreationVO[termChangeCreationVOs.length];
			System.arraycopy(termChangeCreationVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.termChangeCreationVOs = tmpVOs;
		}
	}

	public SearchParamVO getSearchParamVO(){
		return searchParamVO;
	}

	public TermChangeCreationVO[] getTermChangeCreationVOs(){
		TermChangeCreationVO[] tmpVOs = null;
		if (this.termChangeCreationVOs != null) {
			tmpVOs = new TermChangeCreationVO[termChangeCreationVOs.length];
			System.arraycopy(termChangeCreationVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	
	/**
	 * @return the searchParamVOs
	 */
	public SearchParamVO[] getSearchParamVOs() {
		SearchParamVO[] tmpVOs = null;
		if (this.searchParamVOs != null) {
			tmpVOs = new SearchParamVO[searchParamVOs.length];
			System.arraycopy(searchParamVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;

	}

	/**
	 * @param searchParamVOs
	 *            the searchParamVOs to set
	 */
	public void setSearchParamVOs(SearchParamVO[] searchParamVOs) {
		if (searchParamVOs != null) {
			SearchParamVO[] tmpVOs = new SearchParamVO[searchParamVOs.length];
			System.arraycopy(searchParamVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.searchParamVOs = tmpVOs;
		}

	}

}