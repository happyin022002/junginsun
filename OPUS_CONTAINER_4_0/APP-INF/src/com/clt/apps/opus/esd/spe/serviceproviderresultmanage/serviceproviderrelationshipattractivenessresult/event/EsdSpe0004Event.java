/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdSpe0004Event.java
*@FileTitle : RA Analysis Result
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.03
*@LastModifier : 권정화
*@LastVersion : 1.0
* 2009.08.03 권정화
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.spe.serviceproviderresultmanage.serviceproviderrelationshipattractivenessresult.event;

import com.clt.apps.opus.esd.spe.mastermanage.evaluationgroupmanage.vo.SearchEGIdAllListVO;
import com.clt.apps.opus.esd.spe.serviceproviderresultmanage.serviceproviderrelationshipattractivenessresult.vo.SearchInputListVO;
import com.clt.apps.opus.esd.spe.serviceproviderresultmanage.serviceproviderrelationshipattractivenessresult.vo.SpeRltAtrcRsltAddVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESD_SPE_0004 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_SPE_0004HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kown Jeong hwa
 * @see ESD_SPE_0004HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdSpe0004Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SpeRltAtrcRsltAddVO speRltAtrcRsltAddVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SpeRltAtrcRsltAddVO[] speRltAtrcRsltAddVOs = null;

	public EsdSpe0004Event(){}
	
	public void setSpeRltAtrcRsltAddVO(SpeRltAtrcRsltAddVO speRltAtrcRsltAddVO){
		this. speRltAtrcRsltAddVO = speRltAtrcRsltAddVO;
	}

	public void setSpeRltAtrcRsltAddVOS(SpeRltAtrcRsltAddVO[] speRltAtrcRsltAddVOs){
		this. speRltAtrcRsltAddVOs = speRltAtrcRsltAddVOs;
	}

	public SpeRltAtrcRsltAddVO getSpeRltAtrcRsltAddVO(){
		return speRltAtrcRsltAddVO;
	}

	public SpeRltAtrcRsltAddVO[] getSpeRltAtrcRsltAddVOS(){
		return speRltAtrcRsltAddVOs;
	}
	
	private SearchInputListVO searchInputListVO = null; 
	
	private SearchInputListVO[] searchInputListVOs = null; 
	
	// 조회조건용 VO
	public void setSearchInputListVO(SearchInputListVO searchInputListVO) {
		this.searchInputListVO = searchInputListVO;
	}

	public void setSearchInputListVOs(SearchInputListVO[] searchInputListVOs) {
		this.searchInputListVOs= searchInputListVOs;
	}
	
	public SearchInputListVO getSearchInputListVO() {
		return searchInputListVO;
	}
	
	public SearchInputListVO[] getSearchInputListVOs() {
		return searchInputListVOs;
	}	
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchEGIdAllListVO searchEGIdAllListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchEGIdAllListVO[] searchEGIdAllListVOs = null;

	public void setSearchEGIdAllListVO(SearchEGIdAllListVO searchEGIdAllListVO) {
		this.searchEGIdAllListVO = searchEGIdAllListVO;
	}

	public void setSearchEGIdAllListVOs(SearchEGIdAllListVO[] searchEGIdAllListVOs) {
		this.searchEGIdAllListVOs = searchEGIdAllListVOs;
	}
	
	public SearchEGIdAllListVO getSearchEGIdAllListVO() {
		return searchEGIdAllListVO;
	}
	
	public SearchEGIdAllListVO[] getSearchEGIdAllListVOs() {
		return searchEGIdAllListVOs;
	}
}