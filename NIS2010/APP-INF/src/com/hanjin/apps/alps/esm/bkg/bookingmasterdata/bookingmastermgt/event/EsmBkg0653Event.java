/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0653Event.java
*@FileTitle : Package Table
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.19
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.05.19 김기종
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.SearchCmdtCdRepCmdtCdVO;


/**
 * ESM_BKG_0653 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0653HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Ki Jong
 * @see ESM_BKG_0653HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0653Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchCmdtCdRepCmdtCdVO searchCmdtCdRepCmdtCdVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchCmdtCdRepCmdtCdVO[] searchCmdtCdRepCmdtCdVOs = null;

	/*private String rdo_search_type =null;
	
	public String getRdo_search_type() {
		return rdo_search_type;
	}

	public void setRdo_search_type(String rdo_search_type) {
		this.rdo_search_type = rdo_search_type;
	}
	 */
	public EsmBkg0653Event(){}
	
	public void setSearchCmdtCdRepCmdtCdVO(SearchCmdtCdRepCmdtCdVO searchCmdtCdRepCmdtCdVO){
		this. searchCmdtCdRepCmdtCdVO = searchCmdtCdRepCmdtCdVO;
	}

	public void setSearchCmdtCdRepCmdtCdVOS(SearchCmdtCdRepCmdtCdVO[] searchCmdtCdRepCmdtCdVOs){
		this. searchCmdtCdRepCmdtCdVOs = searchCmdtCdRepCmdtCdVOs;
	}

	public SearchCmdtCdRepCmdtCdVO getSearchCmdtCdRepCmdtCdVO(){
		return searchCmdtCdRepCmdtCdVO;
	}

	public SearchCmdtCdRepCmdtCdVO[] getSearchCmdtCdRepCmdtCdVOS(){
		return searchCmdtCdRepCmdtCdVOs;
	}

}