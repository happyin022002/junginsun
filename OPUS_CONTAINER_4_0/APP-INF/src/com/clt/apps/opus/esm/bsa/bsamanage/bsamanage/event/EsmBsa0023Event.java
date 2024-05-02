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
=========================================================*/
package com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.event;

import com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.vo.BsaAddCarrierSaveVO;
import com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.vo.SearchBsaConditionVO;
import com.clt.framework.support.layer.event.EventSupport;
import java.util.Arrays;									//SJH.20150507.소스품질

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

	//SJH.20150507.소스품질
	public BsaAddCarrierSaveVO[] getBsaAddCarrierSaveVOs() {
		BsaAddCarrierSaveVO[] rtnVOs = null;
		if (this.bsaAddCarrierSaveVOs != null) {
			rtnVOs = Arrays.copyOf(bsaAddCarrierSaveVOs, bsaAddCarrierSaveVOs.length);
		}
		return rtnVOs;
	}

	//SJH.20150507.소스품질
	public void setBsaAddCarrierSaveVOs(BsaAddCarrierSaveVO[] bsaAddCarrierSaveVOs){
		if(bsaAddCarrierSaveVOs != null){
			BsaAddCarrierSaveVO[] tmpVOs = Arrays.copyOf(bsaAddCarrierSaveVOs, bsaAddCarrierSaveVOs.length);
			this.bsaAddCarrierSaveVOs = tmpVOs;
		}
	}
	
	public SearchBsaConditionVO getSearchBsaConditionVO() {
		return searchBsaConditionVO;
	}


	public void setSearchBsaConditionVO(SearchBsaConditionVO searchBsaConditionVO) {
		this.searchBsaConditionVO = searchBsaConditionVO;
	}
	

}
