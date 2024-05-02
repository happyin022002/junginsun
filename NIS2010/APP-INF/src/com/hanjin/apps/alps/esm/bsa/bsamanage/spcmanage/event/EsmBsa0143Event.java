/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBsa0143Event.java
*@FileTitle : Solt Information By VVD For Vessels
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.09
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2009.10.09 남궁진호
* 1.0 Creation
* 2015.03.27 김용습 [CHM-201534456] 2015년 1월 소스 보안 결함 건 조치 요청
=========================================================*/
package com.hanjin.apps.alps.esm.bsa.bsamanage.spcmanage.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.bsa.bsamanage.spcmanage.vo.SearchSpcConditionVO;
import com.hanjin.apps.alps.esm.bsa.bsamanage.spcmanage.vo.SearchSpcSlotInfoByVvdOnVesselListVO;


/**
 * ESM_BSA_0143 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BSA_0143HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author NAMKOONG Jin Ho
 * @see ESM_BSA_0143HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBsa0143Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchSpcSlotInfoByVvdOnVesselListVO searchSpcSlotInfoByVvdOnVesselListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchSpcSlotInfoByVvdOnVesselListVO[] searchSpcSlotInfoByVvdOnVesselListVOs = null;
	
	/** Table Value Object 조회 조건 처리 */
	private SearchSpcConditionVO searchSpcConditionVO = null;
	
	
	public EsmBsa0143Event(){}
	
	public void setSearchSpcSlotInfoByVvdOnVesselListVO(SearchSpcSlotInfoByVvdOnVesselListVO searchSpcSlotInfoByVvdOnVesselListVO){
		this. searchSpcSlotInfoByVvdOnVesselListVO = searchSpcSlotInfoByVvdOnVesselListVO;
	}

	//Yongseup Kim - Secure Coding [CWE-496]
	public void setSearchSpcSlotInfoByVvdOnVesselListVOS(SearchSpcSlotInfoByVvdOnVesselListVO[] searchSpcSlotInfoByVvdOnVesselListVOs){
		this.searchSpcSlotInfoByVvdOnVesselListVOs = new SearchSpcSlotInfoByVvdOnVesselListVO[searchSpcSlotInfoByVvdOnVesselListVOs.length];
		for(int i=0; i< searchSpcSlotInfoByVvdOnVesselListVOs.length; ++i){
			this.searchSpcSlotInfoByVvdOnVesselListVOs[i] = searchSpcSlotInfoByVvdOnVesselListVOs[i];
		}
	}

	public SearchSpcSlotInfoByVvdOnVesselListVO getSearchSpcSlotInfoByVvdOnVesselListVO(){
		return searchSpcSlotInfoByVvdOnVesselListVO;
	}

	//Yongseup Kim - Secure Coding [CWE-495]
	public SearchSpcSlotInfoByVvdOnVesselListVO[] getSearchSpcSlotInfoByVvdOnVesselListVOS(){
		SearchSpcSlotInfoByVvdOnVesselListVO[] ret = null;
		if(this.searchSpcSlotInfoByVvdOnVesselListVOs != null){
			ret = new SearchSpcSlotInfoByVvdOnVesselListVO[searchSpcSlotInfoByVvdOnVesselListVOs.length];
			for(int i=0; i< searchSpcSlotInfoByVvdOnVesselListVOs.length; i++){
				ret[i] = this.searchSpcSlotInfoByVvdOnVesselListVOs[i];
			}
		}
		return ret;
	}
	
	public SearchSpcConditionVO getSearchSpcConditionVO() {
		return searchSpcConditionVO;
	}

	public void setSearchSpcConditionVO(SearchSpcConditionVO searchSpcConditionVO) {
		this.searchSpcConditionVO = searchSpcConditionVO;
	}

}