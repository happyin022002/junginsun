/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0451Event.java
*@FileTitle : bookringreport
*Open Issues :
*Change history :
*@LastModifyDate : 2011.08.25
*@LastModifier : jsy
*@LastVersion : 1.0
* 2011.08.25 jsy
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event;

import java.util.Arrays;

import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.BkgSrFaxVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.SearchBkgSrProcHisListVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.SearchSREmlAtchFileListVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.SearchSREmlCtntVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.SearchSREmlReceivingListVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.SearchSRReceivingListVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0451 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0451HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author kang dong yun
 * @see ESM_BKG_0451HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0451Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchBkgSrProcHisListVO searchBkgSrProcHisListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchBkgSrProcHisListVO[] searchBkgSrProcHisListVOs = null;
	
	
 

	public EsmBkg0451Event(){}
	
	
	
	public SearchBkgSrProcHisListVO getSearchBkgSrProcHisListVO() {
		return searchBkgSrProcHisListVO;
	}



	public void setSearchBkgSrProcHisListVO(
			SearchBkgSrProcHisListVO searchBkgSrProcHisListVO) {
		this.searchBkgSrProcHisListVO = searchBkgSrProcHisListVO;
	}



	public SearchBkgSrProcHisListVO[] getSearchBkgSrProcHisListVOs() {
		SearchBkgSrProcHisListVO[] rtnVOs = null;
		if (this.searchBkgSrProcHisListVOs != null) {
			rtnVOs = Arrays.copyOf(searchBkgSrProcHisListVOs, searchBkgSrProcHisListVOs.length);
		}
		return rtnVOs;
	}



	public void setSearchBkgSrProcHisListVOs(SearchBkgSrProcHisListVO[] searchBkgSrProcHisListVOs){
		if(searchBkgSrProcHisListVOs != null){
			SearchBkgSrProcHisListVO[] tmpVOs = Arrays.copyOf(searchBkgSrProcHisListVOs, searchBkgSrProcHisListVOs.length);
			this.searchBkgSrProcHisListVOs = tmpVOs;
		}
	}

 
	
}