/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0596Event.java
*@FileTitle : Manual BDR
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.21
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.05.21 김기종
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.event;

import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.SearchBDRTimeVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0596 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0596HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Ki Jong
 * @see ESM_BKG_0596HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0596Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchBDRTimeVO searchBDRTimeVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchBDRTimeVO[] searchBDRTimeVOs = null;

	public EsmBkg0596Event(){}
	
	public void setSearchBDRTimeVO(SearchBDRTimeVO searchBDRTimeVO){
		this. searchBDRTimeVO = searchBDRTimeVO;
	}

//	public void setSearchBDRTimeVOS(SearchBDRTimeVO[] searchBDRTimeVOs){
//		this. searchBDRTimeVOs = searchBDRTimeVOs;
//	}

	//2015.04.10 Secure Coding 적용[CWE-496]
	public void setSearchBDRTimeVOS(SearchBDRTimeVO[] searchBDRTimeVOs){
		if (searchBDRTimeVOs != null) {
			SearchBDRTimeVO[] tmpVOs = new SearchBDRTimeVO[searchBDRTimeVOs.length];
			System.arraycopy(searchBDRTimeVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.searchBDRTimeVOs = tmpVOs;
		}		
	}		
	
	public SearchBDRTimeVO getSearchBDRTimeVO(){
		return searchBDRTimeVO;
	}

//	public SearchBDRTimeVO[] getSearchBDRTimeVOS(){
//		return searchBDRTimeVOs;
//	}

	//2015.04.10 Secure Coding 적용[CWE-496]
	public SearchBDRTimeVO[] getSearchBDRTimeVOS(){
		SearchBDRTimeVO[] tmpVOs = null;
		if (this.searchBDRTimeVOs != null) {
			tmpVOs = new SearchBDRTimeVO[searchBDRTimeVOs.length];
			System.arraycopy(searchBDRTimeVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;		
	}	
}