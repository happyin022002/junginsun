
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBsa0024Event.java
*@FileTitle : EsmBsa0024Event
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.14
*@LastModifier : 김기대
*@LastVersion : 1.0
* 2009.07.14 김기대
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.event;

import com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.vo.BsaSlotInfoForSpcCntrSaveVO;
import com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.vo.SearchBsaConditionVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.BsaSpcCtrlSwapVO;
import java.util.Arrays;									//SJH.20150507.소스품질

/**
 * ESM_BSA_0024 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BSA_0024HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Ki Dae
 * @see ESM_BSA_0024HTMLAction 참조
 * @since J2EE 1.6
 */
@SuppressWarnings("serial")
public class EsmBsa0024Event extends EventSupport {

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchBsaConditionVO searchBsaConditionVO = null;
	
	/** 단건처리 */
	private BsaSlotInfoForSpcCntrSaveVO bsaSlotInfoForSpcCntrSaveVO = null;
	
	/** Multi Data 처리 - Create/Update/Delete */
	private BsaSlotInfoForSpcCntrSaveVO[] bsaSlotInfoForSpcCntrSaveVOs = null;
		
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BsaSpcCtrlSwapVO bsaSpcCtrlSwapVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BsaSpcCtrlSwapVO[] bsaSpcCtrlSwapVOs = null;
	
	/** Constructor */
	public EsmBsa0024Event(){}	
	

	public SearchBsaConditionVO getSearchBsaConditionVO() {
		return searchBsaConditionVO;
	}

	public void setSearchBsaConditionVO(SearchBsaConditionVO searchBsaConditionVO) {
		this.searchBsaConditionVO = searchBsaConditionVO;
	}

	public BsaSpcCtrlSwapVO getBsaSpcCtrlSwapVO() {
		return bsaSpcCtrlSwapVO;
	}

	public void setBsaSpcCtrlSwapVO(BsaSpcCtrlSwapVO bsaSpcCtrlSwapVO) {
		this.bsaSpcCtrlSwapVO = bsaSpcCtrlSwapVO;
	}

	public BsaSpcCtrlSwapVO[] getBsaSpcCtrlSwapVOs() {
		BsaSpcCtrlSwapVO[] rtnVOs = null;
		if (this.bsaSpcCtrlSwapVOs != null) {
			rtnVOs = Arrays.copyOf(bsaSpcCtrlSwapVOs, bsaSpcCtrlSwapVOs.length);
		}
		return rtnVOs;
	}

	public void setBsaSpcCtrlSwapVOs(BsaSpcCtrlSwapVO[] bsaSpcCtrlSwapVOs){
		if(bsaSpcCtrlSwapVOs != null){
			BsaSpcCtrlSwapVO[] tmpVOs = Arrays.copyOf(bsaSpcCtrlSwapVOs, bsaSpcCtrlSwapVOs.length);
			this.bsaSpcCtrlSwapVOs = tmpVOs;
		}
	}

	public BsaSlotInfoForSpcCntrSaveVO getBsaSlotInfoForSpcCntrSaveVO() {
		return bsaSlotInfoForSpcCntrSaveVO;
	}

	public void setBsaSlotInfoForSpcCntrSaveVO(
			BsaSlotInfoForSpcCntrSaveVO bsaSlotInfoForSpcCntrSaveVO) {
		this.bsaSlotInfoForSpcCntrSaveVO = bsaSlotInfoForSpcCntrSaveVO;
	}
	
	//SJH.20150507.소스품질
	public BsaSlotInfoForSpcCntrSaveVO[] getBsaSlotInfoForSpcCntrSaveVOs() {
		BsaSlotInfoForSpcCntrSaveVO[] rtnVOs = null;
		if (this.bsaSlotInfoForSpcCntrSaveVOs != null) {
			rtnVOs = Arrays.copyOf(bsaSlotInfoForSpcCntrSaveVOs, bsaSlotInfoForSpcCntrSaveVOs.length);
		}
		return rtnVOs;
	}
	//SJH.20150507.소스품질
	public void setBsaSlotInfoForSpcCntrSaveVOs(BsaSlotInfoForSpcCntrSaveVO[] bsaSlotInfoForSpcCntrSaveVOs){
		if(bsaSlotInfoForSpcCntrSaveVOs != null){
			BsaSlotInfoForSpcCntrSaveVO[] tmpVOs = Arrays.copyOf(bsaSlotInfoForSpcCntrSaveVOs, bsaSlotInfoForSpcCntrSaveVOs.length);
			this.bsaSlotInfoForSpcCntrSaveVOs = tmpVOs;
		}
	}

	
	
	
}
