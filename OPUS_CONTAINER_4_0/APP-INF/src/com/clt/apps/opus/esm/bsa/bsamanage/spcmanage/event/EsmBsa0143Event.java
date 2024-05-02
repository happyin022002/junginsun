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
=========================================================*/
package com.clt.apps.opus.esm.bsa.bsamanage.spcmanage.event;

import com.clt.apps.opus.esm.bsa.bsamanage.spcmanage.vo.SearchSpcConditionVO;
import com.clt.apps.opus.esm.bsa.bsamanage.spcmanage.vo.SearchSpcSlotInfoByVvdOnVesselListVO;
import com.clt.framework.support.layer.event.EventSupport;
import java.util.Arrays;									//SJH.20150507.소스품질


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
	
	//SJH.20150507.소스품질
	public void setSearchSpcSlotInfoByVvdOnVesselListVOS(SearchSpcSlotInfoByVvdOnVesselListVO[] searchSpcSlotInfoByVvdOnVesselListVOs){
		if(searchSpcSlotInfoByVvdOnVesselListVOs != null){
			SearchSpcSlotInfoByVvdOnVesselListVO[] tmpVOs = Arrays.copyOf(searchSpcSlotInfoByVvdOnVesselListVOs, searchSpcSlotInfoByVvdOnVesselListVOs.length);
			this.searchSpcSlotInfoByVvdOnVesselListVOs = tmpVOs;
		}
	}

	public SearchSpcSlotInfoByVvdOnVesselListVO getSearchSpcSlotInfoByVvdOnVesselListVO(){
		return searchSpcSlotInfoByVvdOnVesselListVO;
	}
	
	//SJH.20150507.소스품질
	public SearchSpcSlotInfoByVvdOnVesselListVO[] getSearchSpcSlotInfoByVvdOnVesselListVOS(){
		SearchSpcSlotInfoByVvdOnVesselListVO[] rtnVOs = null;
		if (this.searchSpcSlotInfoByVvdOnVesselListVOs != null) {
			rtnVOs = Arrays.copyOf(searchSpcSlotInfoByVvdOnVesselListVOs, searchSpcSlotInfoByVvdOnVesselListVOs.length);
		}
		return rtnVOs;
	}
	
	public SearchSpcConditionVO getSearchSpcConditionVO() {
		return searchSpcConditionVO;
	}

	public void setSearchSpcConditionVO(SearchSpcConditionVO searchSpcConditionVO) {
		this.searchSpcConditionVO = searchSpcConditionVO;
	}

}