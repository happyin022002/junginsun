/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBsa0030Event.java
*@FileTitle : BSA & Slot-swap by VVD 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.10
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2009.09.10 남궁진호
* 1.0 Creation
* 2015.03.27 김용습 [CHM-201534456] 2015년 1월 소스 보안 결함 건 조치 요청
* 2016.01.29 김성욱 [CHM-201539410] BSA System 개선의 건 / 동일 날짜에 서로 다른 항차 BSA 입력 가능 실현
=========================================================*/
package com.hanjin.apps.alps.esm.bsa.bsamanage.spcmanage.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.bsa.bsamanage.spcmanage.vo.MultiSupplySwapVvdVO;
import com.hanjin.apps.alps.esm.bsa.bsamanage.spcmanage.vo.SearchOpJobCarrierListVO;
import com.hanjin.apps.alps.esm.bsa.bsamanage.spcmanage.vo.SearchSpcConditionVO;


/**
 * ESM_BSA_0030 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BSA_0030HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author NAMKOONG Jin Ho
 * @see ESM_BSA_0030HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBsa0030Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchOpJobCarrierListVO searchOpJobCarrierListVO = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private MultiSupplySwapVvdVO multiSupplySwapVvdVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchOpJobCarrierListVO[] searchOpJobCarrierListVOs = null;

	/** Table Value Object Multi Data 처리 */
	private MultiSupplySwapVvdVO[] multiSupplySwapVvdVOs = null;
	
	/** Table Value Object 조회 조건 처리 */
	private SearchSpcConditionVO searchSpcConditionVO = null;
	

	public EsmBsa0030Event(){}
	
	public void setSearchOpJobCarrierListVO(SearchOpJobCarrierListVO searchOpJobCarrierListVO){
		this. searchOpJobCarrierListVO = searchOpJobCarrierListVO;
	}

	//Yongseup Kim - Secure Coding [CWE-496]
	public void setSearchOpJobCarrierListVOS(SearchOpJobCarrierListVO[] searchOpJobCarrierListVOs){
		this.searchOpJobCarrierListVOs = new SearchOpJobCarrierListVO[searchOpJobCarrierListVOs.length];
		for(int i=0; i< searchOpJobCarrierListVOs.length; ++i){
			this.searchOpJobCarrierListVOs[i] = searchOpJobCarrierListVOs[i];
		}
	}
	
	public void setSearchSpcConditionVO(
			SearchSpcConditionVO searchSpcConditionVO) {
		this.searchSpcConditionVO = searchSpcConditionVO;
	}
	
	public SearchOpJobCarrierListVO getSearchOpJobCarrierListVO(){
		return searchOpJobCarrierListVO;
	}

	//Yongseup Kim - Secure Coding [CWE-495]
	public SearchOpJobCarrierListVO[] getSearchOpJobCarrierListVOS(){
		SearchOpJobCarrierListVO[] ret = null;
		if(this.searchOpJobCarrierListVOs != null){
			ret = new SearchOpJobCarrierListVO[searchOpJobCarrierListVOs.length];
			for(int i=0; i<searchOpJobCarrierListVOs.length; i++){
				ret[i] = this.searchOpJobCarrierListVOs[i];
			}
		}
		return ret;
	}

	public SearchSpcConditionVO getSearchSpcConditionVO() {
		return searchSpcConditionVO;
	}

	///////#### 김성욱 추가 / 2015.12.21 / SAVE 동작추가로 인함.
	
	public MultiSupplySwapVvdVO getMultiSupplySwapVvdVO(){
		return multiSupplySwapVvdVO;
	}
	
	public MultiSupplySwapVvdVO[] getMultiSupplySwapVvdVOs(){
		MultiSupplySwapVvdVO[] ret = null;
		if(this.multiSupplySwapVvdVOs != null){
			ret = new MultiSupplySwapVvdVO[multiSupplySwapVvdVOs.length];
			for(int i=0; i<multiSupplySwapVvdVOs.length; i++){
				ret[i] = this.multiSupplySwapVvdVOs[i];
			}
		}
		return ret;
	}

	
	public void setMultiSupplySwapVvdVO(MultiSupplySwapVvdVO multiSupplySwapVvdVO){
		this. multiSupplySwapVvdVO = multiSupplySwapVvdVO;
	}
	
	public void setMultiSupplySwapVvdVOs(MultiSupplySwapVvdVO[] multiSupplySwapVvdVOs){
		this.multiSupplySwapVvdVOs = new MultiSupplySwapVvdVO[multiSupplySwapVvdVOs.length];
		for(int i=0; i< multiSupplySwapVvdVOs.length; i++){
			this.multiSupplySwapVvdVOs[i] = multiSupplySwapVvdVOs[i];
		}
	}
}
