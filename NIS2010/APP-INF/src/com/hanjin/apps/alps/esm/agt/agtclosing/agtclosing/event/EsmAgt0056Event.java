/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmAgt0032Event.java
*@FileTitle : Estimation Closing Report
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.18
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2010.10.18 박성진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtclosing.agtclosing.event;

import com.hanjin.apps.alps.esm.agt.agtclosing.agtclosing.vo.SearchCSRSelectionVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_AGT_0032 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_AGT_0032HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kyung-won Chu
 * @see ESM_AGT_0032HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmAgt0056Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchCSRSelectionVO searchCSRSelectionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchCSRSelectionVO[] searchCSRSelectionVOs = null;

	public EsmAgt0056Event(){}

	public SearchCSRSelectionVO getSearchCSRSelectionVO() {
		return searchCSRSelectionVO;
	}

	public void setSearchCSRSelectionVO(SearchCSRSelectionVO searchCSRSelectionVO) {
		this.searchCSRSelectionVO = searchCSRSelectionVO;
	}

	public SearchCSRSelectionVO[] getSearchCSRSelectionVOs() {
		return searchCSRSelectionVOs;
	}

	public void setSearchCSRSelectionVOs(
			SearchCSRSelectionVO[] searchCSRSelectionVOs) {
		this.searchCSRSelectionVOs = searchCSRSelectionVOs;
	}

}