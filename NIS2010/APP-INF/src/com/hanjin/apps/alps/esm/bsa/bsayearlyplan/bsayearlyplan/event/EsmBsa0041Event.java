/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EsmBsa0041Event.java
*@FileTitle : Slot Price Creation (Yearly Plan)
*Open Issues :
*Change history :
*@LastModifyDate : 2011.01.25
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2011.01.25 이행지
* 1.0 Creation
*=========================================================
* History :
* 2011.01.25 이행지 [CHM-201108497-01] 사업계획 노출 방지를 위한 사업계획용 메뉴 추가 개발
* 2015.03.27 김용습 [CHM-201534456] 2015년 1월 소스 보안 결함 건 조치 요청
=========================================================*/
package com.hanjin.apps.alps.esm.bsa.bsayearlyplan.bsayearlyplan.event;

import com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.vo.SearchBsaCrrRgstListVO;
import com.hanjin.apps.alps.esm.bsa.bsayearlyplan.bsayearlyplan.vo.BsaYearlyPlanConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.BsaBudSltPrcCrrVO;
import com.hanjin.syscommon.common.table.BsaBudSltPrcVO;


/**
 * ESM_BSA_0041 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BSA_0041HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Haeng-ji,Lee
 * @see ESM_BSA_0041HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBsa0041Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	/** 조회 조건 단건처리 */

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchBsaCrrRgstListVO searchBsaCrrRgstListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchBsaCrrRgstListVO[] searchBsaCrrRgstListVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private BsaYearlyPlanConditionVO bsaYearlyPlanConditionVO=null;
	
	private BsaBudSltPrcVO[] bsaBudSltPrcVOs = null;
	
	private BsaBudSltPrcCrrVO[] bsaBudSltPrcCrrVOs = null;
	

	public EsmBsa0041Event(){}
	
	public void setSearchBsaCrrRgstListVO(SearchBsaCrrRgstListVO searchBsaCrrRgstListVO){
		this. searchBsaCrrRgstListVO = searchBsaCrrRgstListVO;
	}

	//Yongseup Kim - Secure Coding [CWE-496]
	public void setSearchBsaCrrRgstListVOS(SearchBsaCrrRgstListVO[] searchBsaCrrRgstListVOs){
		this.searchBsaCrrRgstListVOs = new SearchBsaCrrRgstListVO[searchBsaCrrRgstListVOs.length];
		for(int i=0; i< searchBsaCrrRgstListVOs.length; ++i){
			this.searchBsaCrrRgstListVOs[i] = searchBsaCrrRgstListVOs[i];
		}
	}


	public SearchBsaCrrRgstListVO getSearchBsaCrrRgstListVO(){
		return searchBsaCrrRgstListVO;
	}

	//Yongseup Kim - Secure Coding [CWE-495]
	public SearchBsaCrrRgstListVO[] getSearchBsaCrrRgstListVOS(){
		SearchBsaCrrRgstListVO[] ret = null;
		if(this.searchBsaCrrRgstListVOs != null){
			ret = new SearchBsaCrrRgstListVO[searchBsaCrrRgstListVOs.length];
			for(int i=0; i< searchBsaCrrRgstListVOs.length; i++){
				ret[i] = this.searchBsaCrrRgstListVOs[i];
			}
		}
		return ret;
	}

	public BsaYearlyPlanConditionVO getBsaYearlyPlanConditionVO() {
		return bsaYearlyPlanConditionVO;
	}

	public void setBsaYearlyPlanConditionVO(
			BsaYearlyPlanConditionVO bsaYearlyPlanConditionVO) {
		this.bsaYearlyPlanConditionVO = bsaYearlyPlanConditionVO;
	}

	//Yongseup Kim - Secure Coding [CWE-495]
	public SearchBsaCrrRgstListVO[] getSearchBsaCrrRgstListVOs() {
		SearchBsaCrrRgstListVO[] ret = null;
		if(this.searchBsaCrrRgstListVOs != null){
			ret = new SearchBsaCrrRgstListVO[searchBsaCrrRgstListVOs.length];
			for(int i=0; i< searchBsaCrrRgstListVOs.length; i++){
				ret[i] = this.searchBsaCrrRgstListVOs[i];
			}
		}
		return ret;
	}

	//Yongseup Kim - Secure Coding [CWE-496]
	public void setSearchBsaCrrRgstListVOs(
			SearchBsaCrrRgstListVO[] searchBsaCrrRgstListVOs) {
		this.searchBsaCrrRgstListVOs = new SearchBsaCrrRgstListVO[searchBsaCrrRgstListVOs.length];
		for(int i=0; i< searchBsaCrrRgstListVOs.length; ++i){
			this.searchBsaCrrRgstListVOs[i] = searchBsaCrrRgstListVOs[i];
		}
	}

	//Yongseup Kim - Secure Coding [CWE-495]
	public BsaBudSltPrcVO[] getBsaBudSltPrcVOs() {
		BsaBudSltPrcVO[] ret = null;
		if(this.bsaBudSltPrcVOs != null){
			ret = new BsaBudSltPrcVO[bsaBudSltPrcVOs.length];
			for(int i=0; i< bsaBudSltPrcVOs.length; i++){
				ret[i] = this.bsaBudSltPrcVOs[i];
			}
		}
		return ret;
	}

	//Yongseup Kim - Secure Coding [CWE-496]
	public void setBsaBudSltPrcVOs(BsaBudSltPrcVO[] bsaBudSltPrcVOs) {
		this.bsaBudSltPrcVOs = new BsaBudSltPrcVO[bsaBudSltPrcVOs.length];
		for(int i=0; i< bsaBudSltPrcVOs.length; ++i){
			this.bsaBudSltPrcVOs[i] = bsaBudSltPrcVOs[i];
		}
	}

	//Yongseup Kim - Secure Coding [CWE-495]
	public BsaBudSltPrcCrrVO[] getBsaBudSltPrcCrrVOs() {
		BsaBudSltPrcCrrVO[] ret = null;
		if(this.bsaBudSltPrcCrrVOs != null){
			ret = new BsaBudSltPrcCrrVO[bsaBudSltPrcCrrVOs.length];
			for(int i=0; i< bsaBudSltPrcCrrVOs.length; i++){
				ret[i] = this.bsaBudSltPrcCrrVOs[i];
			}
		}
		return ret;
	}

	//Yongseup Kim - Secure Coding [CWE-496]
	public void setBsaBudSltPrcCrrVOs(BsaBudSltPrcCrrVO[] bsaBudSltPrcCrrVOs) {
		this.bsaBudSltPrcCrrVOs = new BsaBudSltPrcCrrVO[bsaBudSltPrcCrrVOs.length];
		for(int i=0; i< bsaBudSltPrcCrrVOs.length; ++i){
			this.bsaBudSltPrcCrrVOs[i] = bsaBudSltPrcCrrVOs[i];
		}
	}
	
}