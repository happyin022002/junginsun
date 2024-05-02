/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBsa0162Event.java
*@FileTitle : Inquire/Edit Over Used Slot Price
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.16
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2009.10.16 남궁진호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.event;

import com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.vo.BsaOverUsedSlotCostSaveVO;
import com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.vo.SearchBsaConditionVO;
import com.clt.framework.support.layer.event.EventSupport;
import java.util.Arrays;									//SJH.20150507.소스품질

/**
 * ESM_BSA_0162 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BSA_0162HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author NAMKOONG Jin Ho
 * @see ESM_BSA_0162HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBsa0162Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchBsaConditionVO searchBsaConditionVO=null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BsaOverUsedSlotCostSaveVO bsaOverUsedSlotCostSaveVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private BsaOverUsedSlotCostSaveVO[] bsaOverUsedSlotCostSaveVOs = null;
	
	public EsmBsa0162Event(){}
	
	public SearchBsaConditionVO getSearchBsaConditionVO() {
		return searchBsaConditionVO;
	}

	public void setSearchBsaConditionVO(
			SearchBsaConditionVO searchBsaConditionVO) {
		this.searchBsaConditionVO = searchBsaConditionVO;
	}	
	
	public void setBsaOverUsedSlotCostSaveVO(BsaOverUsedSlotCostSaveVO bsaOverUsedSlotCostSaveVO){
		this. bsaOverUsedSlotCostSaveVO = bsaOverUsedSlotCostSaveVO;
	}
	
	//SJH.20150507.소스품질
	public void setBsaOverUsedSlotCostSaveVOS(BsaOverUsedSlotCostSaveVO[] bsaOverUsedSlotCostSaveVOs){
		if(bsaOverUsedSlotCostSaveVOs != null){
			BsaOverUsedSlotCostSaveVO[] tmpVOs = Arrays.copyOf(bsaOverUsedSlotCostSaveVOs, bsaOverUsedSlotCostSaveVOs.length);
			this.bsaOverUsedSlotCostSaveVOs = tmpVOs;
		}
	}

	public BsaOverUsedSlotCostSaveVO getBsaOverUsedSlotCostSaveVO(){
		return bsaOverUsedSlotCostSaveVO;
	}
	
	//SJH.20150507.소스품질
	public BsaOverUsedSlotCostSaveVO[] getBsaOverUsedSlotCostSaveVOS(){
		BsaOverUsedSlotCostSaveVO[] rtnVOs = null;
		if (this.bsaOverUsedSlotCostSaveVOs != null) {
			rtnVOs = Arrays.copyOf(bsaOverUsedSlotCostSaveVOs, bsaOverUsedSlotCostSaveVOs.length);
		}
		return rtnVOs;
	}

}