/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg1057Event.java
*@FileTitle : Freight & Charge List by VVD
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.12
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2009.09.12 김태경
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingreport.performancereport.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.SearchFCLListVO;
import com.clt.framework.support.layer.event.EventSupport;



/**
 * ESM_BKG_1057 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1057HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author kim tae kyoung
 * @see ESM_BKG_1057HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg1057Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchFCLListVO searchFCLListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchFCLListVO[] searchFCLListVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */

	
	/** Table Value Object Multi Data 처리 */


	public EsmBkg1057Event(){}


	
	public void setsearchFCLListVO(SearchFCLListVO searchFCLListVO){
		this. searchFCLListVO = searchFCLListVO;
	}

	public void setsearchFCLListVOS(SearchFCLListVO[] searchFCLListsVOs){
		if(searchFCLListsVOs != null){
			SearchFCLListVO[] tmpVOs = Arrays.copyOf(searchFCLListVOs, searchFCLListVOs.length);
			this.searchFCLListVOs = tmpVOs;
		}
	}


	public SearchFCLListVO getSearchFCLListVO(){
		return searchFCLListVO;
	}

	public SearchFCLListVO[] getSearchFCLListVOS(){
		SearchFCLListVO[] rtnVOs = null;
		if(this.searchFCLListVOs != null){
			rtnVOs= Arrays.copyOf(searchFCLListVOs, searchFCLListVOs.length);
		}
		return rtnVOs;
	}

	


}