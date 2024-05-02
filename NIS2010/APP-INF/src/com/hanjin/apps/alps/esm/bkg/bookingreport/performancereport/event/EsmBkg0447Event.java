/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EsmBkg0447Event.java
*@FileTitle : SR FAX  Recving List - EMLContents 조회 팝업
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.14
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2011.03.14 김기종
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event;

import java.util.Arrays;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.SearchSREmlAtchFileListVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.SearchSREmlCtntVO;


/**
 * ESM_BKG_0447 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0447HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Ki Jong
 * @see ESM_BKG_0447HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0447Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchSREmlCtntVO searchSREmlCtntVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchSREmlCtntVO[] searchSREmlCtntVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchSREmlAtchFileListVO searchSREmlAtchFileListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchSREmlAtchFileListVO[] searchSREmlAtchFileListVOs = null;

	
	public EsmBkg0447Event(){}
	
	public void setSearchSREmlCtntVO(SearchSREmlCtntVO searchSREmlCtntVO){
		this. searchSREmlCtntVO = searchSREmlCtntVO;
	}

	public void setSearchSREmlCtntVOS(SearchSREmlCtntVO[] searchSREmlCtntVOs){
		if(searchSREmlCtntVOs != null){
			SearchSREmlCtntVO[] tmpVOs = Arrays.copyOf(searchSREmlCtntVOs, searchSREmlCtntVOs.length);
			this.searchSREmlCtntVOs = tmpVOs;
		}
	}

	public SearchSREmlCtntVO getSearchSREmlCtntVO(){
		return searchSREmlCtntVO;
	}

	public SearchSREmlCtntVO[] getSearchSREmlCtntVOS(){
		SearchSREmlCtntVO[] rtnVOs = null;
		if (this.searchSREmlCtntVOs != null) {
			rtnVOs = Arrays.copyOf(searchSREmlCtntVOs, searchSREmlCtntVOs.length);
		}
		return rtnVOs;
	}

	public SearchSREmlAtchFileListVO getSearchSREmlAtchFileListVO() {
		return searchSREmlAtchFileListVO;
	}

	public void setSearchSREmlAtchFileListVO(
			SearchSREmlAtchFileListVO searchSREmlAtchFileListVO) {
		this.searchSREmlAtchFileListVO = searchSREmlAtchFileListVO;
	}

	public SearchSREmlAtchFileListVO[] getSearchSREmlAtchFileListVOs() {
		SearchSREmlAtchFileListVO[] rtnVOs = null;
		if (this.searchSREmlAtchFileListVOs != null) {
			rtnVOs = Arrays.copyOf(searchSREmlAtchFileListVOs, searchSREmlAtchFileListVOs.length);
		}
		return rtnVOs;
	}

	public void setSearchSREmlAtchFileListVOs(SearchSREmlAtchFileListVO[] searchSREmlAtchFileListVOs){
		if(searchSREmlAtchFileListVOs != null){
			SearchSREmlAtchFileListVO[] tmpVOs = Arrays.copyOf(searchSREmlAtchFileListVOs, searchSREmlAtchFileListVOs.length);
			this.searchSREmlAtchFileListVOs = tmpVOs;
		}
	}

	
}