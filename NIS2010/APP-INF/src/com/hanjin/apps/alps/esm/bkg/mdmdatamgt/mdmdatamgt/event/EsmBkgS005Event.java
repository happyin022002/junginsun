/*=========================================================
*Copyright(c) 2017 Hiplus Card
*@FileName : EsmBkgS005Event.java
*@FileTitle : SAC Master Data (India)
*Open Issues :
*Change history :
*@LastModifyDate : 2017.06.27
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2017.06.27 송민석 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.mdmdatamgt.mdmdatamgt.event;

import com.hanjin.apps.alps.esm.bkg.mdmdatamgt.mdmdatamgt.vo.SearchBkgIdaSacMstVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * esm_bkg_S005 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  esm_bkg_S005HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SONG Min Seok
 * @see esm_bkg_S005HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkgS005Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchBkgIdaSacMstVO searchBkgIdaSacMstVO = null;
	   /** Table Value Object Multi Data 처리 */

	private SearchBkgIdaSacMstVO[] searchBkgIdaSacMstVOs = null;

 
    
	public EsmBkgS005Event(){}
	
	public void setSearchBkgIdaSacMstVO(SearchBkgIdaSacMstVO searchBkgIdaSacMstVO){
		this. searchBkgIdaSacMstVO = searchBkgIdaSacMstVO;
	}

	public void setSearchBkgIdaSacMstVOS(SearchBkgIdaSacMstVO[] searchBkgIdaSacMstVOs){
		this. searchBkgIdaSacMstVOs = searchBkgIdaSacMstVOs;
	}

	public SearchBkgIdaSacMstVO getSearchBkgIdaSacMstVO(){
		return searchBkgIdaSacMstVO;
	}

	public SearchBkgIdaSacMstVO[] getSearchBkgIdaSacMstVOS(){
		return searchBkgIdaSacMstVOs;
	}
	
	 

}