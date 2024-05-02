
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
* 2015.03.27 김용습 [CHM-201534456] 2015년 1월 소스 보안 결함 건 조치 요청
=========================================================*/
package com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.event;

import com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.vo.BsaSlotInfoForSpcCntrSaveVO;
import com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.vo.SearchBsaConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.BsaSpcCtrlSwapVO;

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

	//Yongseup Kim - Secure Coding [CWE-495]
	public BsaSpcCtrlSwapVO[] getBsaSpcCtrlSwapVOs() {
		BsaSpcCtrlSwapVO[] ret = null;
		if(this.bsaSpcCtrlSwapVOs != null){
			ret = new BsaSpcCtrlSwapVO[bsaSpcCtrlSwapVOs.length];
			for(int i=0; i<bsaSpcCtrlSwapVOs.length; i++){
				ret[i] = this.bsaSpcCtrlSwapVOs[i];
			}
		}
		return ret;
	}

	//Yongseup Kim - Secure Coding [CWE-496]
	public void setBsaSpcCtrlSwapVOs(BsaSpcCtrlSwapVO[] bsaSpcCtrlSwapVOs) {
		this.bsaSpcCtrlSwapVOs = new BsaSpcCtrlSwapVO[bsaSpcCtrlSwapVOs.length];
		for(int i=0; i< bsaSpcCtrlSwapVOs.length; ++i){
			this.bsaSpcCtrlSwapVOs[i] = bsaSpcCtrlSwapVOs[i];
		}
	}

	public BsaSlotInfoForSpcCntrSaveVO getBsaSlotInfoForSpcCntrSaveVO() {
		return bsaSlotInfoForSpcCntrSaveVO;
	}

	public void setBsaSlotInfoForSpcCntrSaveVO(
			BsaSlotInfoForSpcCntrSaveVO bsaSlotInfoForSpcCntrSaveVO) {
		this.bsaSlotInfoForSpcCntrSaveVO = bsaSlotInfoForSpcCntrSaveVO;
	}
	
	//Yongseup Kim - Secure Coding [CWE-495]
	public BsaSlotInfoForSpcCntrSaveVO[] getBsaSlotInfoForSpcCntrSaveVOs() {
		BsaSlotInfoForSpcCntrSaveVO[] ret = null;
		if(this.bsaSlotInfoForSpcCntrSaveVOs != null){
			ret = new BsaSlotInfoForSpcCntrSaveVO[bsaSlotInfoForSpcCntrSaveVOs.length];
			for(int i=0; i<bsaSlotInfoForSpcCntrSaveVOs.length; i++){
				ret[i] = this.bsaSlotInfoForSpcCntrSaveVOs[i];
			}
		}
		return ret;
	}

	//Yongseup Kim - Secure Coding [CWE-496]
	public void setBsaSlotInfoForSpcCntrSaveVOs(
			BsaSlotInfoForSpcCntrSaveVO[] bsaSlotInfoForSpcCntrSaveVOs) {
		this.bsaSlotInfoForSpcCntrSaveVOs = new BsaSlotInfoForSpcCntrSaveVO[bsaSlotInfoForSpcCntrSaveVOs.length];
		for(int i=0; i< bsaSlotInfoForSpcCntrSaveVOs.length; ++i){
			this.bsaSlotInfoForSpcCntrSaveVOs[i] = bsaSlotInfoForSpcCntrSaveVOs[i];
		}
	}

	
	
	
}
