/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBsa0023Event.java
*@FileTitle : EsmBsa0023Event
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

import com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.vo.BsaAddCarrierSaveVO;
import com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.vo.SearchBsaConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_BSA_0021 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BSA_0021HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Ki Dae
 * @see ESM_BSA_0021HTMLAction 참조
 * @since J2EE 1.6
 */
@SuppressWarnings("serial")
public class EsmBsa0023Event extends EventSupport {
	
	private String bsaOpCd=null;
		
	/** 단건처리 */
	private BsaAddCarrierSaveVO bsaAddCarrierSaveVO = null;
	
	/** Multi Data 처리 - Create/Update/Delete */
	private BsaAddCarrierSaveVO[] bsaAddCarrierSaveVOs = null;	
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchBsaConditionVO searchBsaConditionVO=null;
	
	
	/** Constructor */
	public EsmBsa0023Event(){}	
	
	/** Search Condition */	
	public String getBsaOpCd() {
		return bsaOpCd;
	}

	public void setBsaOpCd(String bsaOpCd) {
		this.bsaOpCd = bsaOpCd;
	}

	public BsaAddCarrierSaveVO getBsaAddCarrierSaveVO() {
		return bsaAddCarrierSaveVO;
	}

	public void setBsaAddCarrierSaveVO(BsaAddCarrierSaveVO bsaAddCarrierSaveVO) {
		this.bsaAddCarrierSaveVO = bsaAddCarrierSaveVO;
	}

	//Yongseup Kim - Secure Coding [CWE-495]
	public BsaAddCarrierSaveVO[] getBsaAddCarrierSaveVOs() {
		BsaAddCarrierSaveVO[] ret = null;
		if(this.bsaAddCarrierSaveVOs != null){
			ret = new BsaAddCarrierSaveVO[bsaAddCarrierSaveVOs.length];
			for(int i=0; i<bsaAddCarrierSaveVOs.length; i++){
				ret[i]=this.bsaAddCarrierSaveVOs[i];
			}
		}
		return ret;
	}

	//Yongseup Kim - Secure Coding [CWE-496]
	public void setBsaAddCarrierSaveVOs(BsaAddCarrierSaveVO[] bsaAddCarrierSaveVOs) {
		this.bsaAddCarrierSaveVOs = new BsaAddCarrierSaveVO[bsaAddCarrierSaveVOs.length];
		for(int i=0; i< bsaAddCarrierSaveVOs.length; ++i){
			this.bsaAddCarrierSaveVOs[i] = bsaAddCarrierSaveVOs[i];
		}
	}
	
	public SearchBsaConditionVO getSearchBsaConditionVO() {
		return searchBsaConditionVO;
	}


	public void setSearchBsaConditionVO(SearchBsaConditionVO searchBsaConditionVO) {
		this.searchBsaConditionVO = searchBsaConditionVO;
	}
	

}
