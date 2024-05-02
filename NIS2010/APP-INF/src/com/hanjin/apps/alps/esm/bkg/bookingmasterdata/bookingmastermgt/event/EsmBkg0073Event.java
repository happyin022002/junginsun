/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0073Event.java
*@FileTitle : BDR Time Table
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.28
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.05.28 김기종
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.SearchBDRPolVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.SearchBDRTimeTableVO;


/**
 * ESM_BKG_0073 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0073HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Ki Jong
 * @see ESM_BKG_0073HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0073Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchBDRPolVO searchBDRPolVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchBDRPolVO[] searchBDRPolVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchBDRTimeTableVO searchBDRTimeTableVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchBDRTimeTableVO[] searchBDRTimeTableVOs = null;

	public EsmBkg0073Event(){}
	
	public void setSearchBDRPolVO(SearchBDRPolVO searchBDRPolVO){
		this. searchBDRPolVO = searchBDRPolVO;
	}

	public void setSearchBDRPolVOS(SearchBDRPolVO[] searchBDRPolVOs){
		this. searchBDRPolVOs = searchBDRPolVOs;
	}

	public void setSearchBDRTimeTableVO(SearchBDRTimeTableVO searchBDRTimeTableVO){
		this. searchBDRTimeTableVO = searchBDRTimeTableVO;
	}

	public void setSearchBDRTimeTableVOS(SearchBDRTimeTableVO[] searchBDRTimeTableVOs){
		this. searchBDRTimeTableVOs = searchBDRTimeTableVOs;
	}

	public SearchBDRPolVO getSearchBDRPolVO(){
		return searchBDRPolVO;
	}

	public SearchBDRPolVO[] getSearchBDRPolVOS(){
		return searchBDRPolVOs;
	}

	public SearchBDRTimeTableVO getSearchBDRTimeTableVO(){
		return searchBDRTimeTableVO;
	}

	public SearchBDRTimeTableVO[] getSearchBDRTimeTableVOS(){
		return searchBDRTimeTableVOs;
	}

}