/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0409Event.java
*@FileTitle : Performance Report by Error
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.10
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.07.10 김기종
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event;

import java.util.Arrays;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.SearchDPCSPfmcErrorListVO;


/**
 * ESM_BKG_0409 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0409HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Ki Jong
 * @see ESM_BKG_0409HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0409Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchDPCSPfmcErrorListVO searchDPCSPfmcErrorListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchDPCSPfmcErrorListVO[] searchDPCSPfmcErrorListVOs = null;

	public EsmBkg0409Event(){}
	
	public void setSearchDPCSPfmcErrorListVO(SearchDPCSPfmcErrorListVO searchDPCSPfmcErrorListVO){
		this. searchDPCSPfmcErrorListVO = searchDPCSPfmcErrorListVO;
	}

	public void setSearchDPCSPfmcErrorListVOS(SearchDPCSPfmcErrorListVO[] searchDPCSPfmcErrorListVOs){
		if(searchDPCSPfmcErrorListVOs != null){
			SearchDPCSPfmcErrorListVO[] tmpVOs = Arrays.copyOf(searchDPCSPfmcErrorListVOs, searchDPCSPfmcErrorListVOs.length);
			this.searchDPCSPfmcErrorListVOs = tmpVOs;
		}
	}

	public SearchDPCSPfmcErrorListVO getSearchDPCSPfmcErrorListVO(){
		return searchDPCSPfmcErrorListVO;
	}

	public SearchDPCSPfmcErrorListVO[] getSearchDPCSPfmcErrorListVOS(){
		SearchDPCSPfmcErrorListVO[] rtnVOs = null;
		if (this.searchDPCSPfmcErrorListVOs != null) {
			rtnVOs = Arrays.copyOf(searchDPCSPfmcErrorListVOs, searchDPCSPfmcErrorListVOs.length);
		}
		return rtnVOs;
	}

}