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
=========================================================*/
package com.clt.apps.opus.esm.bsa.bsamanage.spcmanage.event;

import com.clt.apps.opus.esm.bsa.bsamanage.spcmanage.vo.SearchOpJobCarrierListVO;
import com.clt.apps.opus.esm.bsa.bsamanage.spcmanage.vo.SearchSpcConditionVO;
import com.clt.framework.support.layer.event.EventSupport;
import java.util.Arrays;									//SJH.20150507.소스품질

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
	
	/** Table Value Object Multi Data 처리 */
	private SearchOpJobCarrierListVO[] searchOpJobCarrierListVOs = null;
	
	/** Table Value Object 조회 조건 처리 */
	private SearchSpcConditionVO searchSpcConditionVO = null;
	

	public EsmBsa0030Event(){}
	
	public void setSearchOpJobCarrierListVO(SearchOpJobCarrierListVO searchOpJobCarrierListVO){
		this. searchOpJobCarrierListVO = searchOpJobCarrierListVO;
	}

	//SJH.20150507.소스품질
	public void setSearchOpJobCarrierListVOS(SearchOpJobCarrierListVO[] searchOpJobCarrierListVOs){
		if(searchOpJobCarrierListVOs != null){
			SearchOpJobCarrierListVO[] tmpVOs = Arrays.copyOf(searchOpJobCarrierListVOs, searchOpJobCarrierListVOs.length);
			this.searchOpJobCarrierListVOs = tmpVOs;
		}
	}
	
	public void setSearchSpcConditionVO(
			SearchSpcConditionVO searchSpcConditionVO) {
		this.searchSpcConditionVO = searchSpcConditionVO;
	}
	
	public SearchOpJobCarrierListVO getSearchOpJobCarrierListVO(){
		return searchOpJobCarrierListVO;
	}
	
	//SJH.20150507.소스품질
	public SearchOpJobCarrierListVO[] getSearchOpJobCarrierListVOS(){
		SearchOpJobCarrierListVO[] rtnVOs = null;
		if (this.searchOpJobCarrierListVOs != null) {
			rtnVOs = Arrays.copyOf(searchOpJobCarrierListVOs, searchOpJobCarrierListVOs.length);
		}
		return rtnVOs;
	}

	public SearchSpcConditionVO getSearchSpcConditionVO() {
		return searchSpcConditionVO;
	}

	

}