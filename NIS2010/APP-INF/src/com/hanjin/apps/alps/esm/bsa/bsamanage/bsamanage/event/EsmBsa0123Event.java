/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EsmBsa0123Event.java
*@FileTitle : EsmBsa0123Event
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.09
*@LastModifier : 신자영
*@LastVersion : 1.0
* 2014.06.09 신자영
* 1.0 Creation
* 2015.03.27 김용습 [CHM-201534456] 2015년 1월 소스 보안 결함 건 조치 요청
=========================================================*/
package com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.event;

import com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.vo.BsaTableSaveVO;
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
public class EsmBsa0123Event extends EventSupport {
	/** 조회 조건 단건처리 */
	private SearchBsaConditionVO searchBsaConditionVO = null;

	/** 단건처리 */
	private BsaTableSaveVO bsaTableSaveVO = null;
	
	/** 멀티처리 */
	private BsaTableSaveVO[] bsaTableSaveVOs= null;
	

	/** Constructor */
	public EsmBsa0123Event(){}	
	
	/** Search Condition Getter */
	public SearchBsaConditionVO getSearchBsaConditionVO() {
		return searchBsaConditionVO;
	}

	/** Search Condition Setter */
	public void setSearchBsaConditionVO(SearchBsaConditionVO searchBsaConditionVO) {
		this.searchBsaConditionVO = searchBsaConditionVO;
	}

	/** Save Getter */	
	public BsaTableSaveVO getBsaTableSaveVO() {
		return bsaTableSaveVO;
	}
	/** Save Setter */
	public void setBsaTableSaveVO(BsaTableSaveVO bsaTableSaveVO) {
		this.bsaTableSaveVO = bsaTableSaveVO;
	}
		
	/** Save Getter */	
	//Yongseup Kim - Secure Coding [CWE-495]
	public BsaTableSaveVO[] getBsaTableSaveVOs() {
		BsaTableSaveVO[] ret = null;
		if(this.bsaTableSaveVOs != null){
			ret = new BsaTableSaveVO[bsaTableSaveVOs.length];
			for(int i=0; i<bsaTableSaveVOs.length; i++){
				ret[i] = this.bsaTableSaveVOs[i];
			}
		}
		return ret;
	}
	/** Save Setter */	
	//Yongseup Kim - Secure Coding [CWE-496]
	public void setBsaTableSaveVOs(BsaTableSaveVO[] bsaTableSaveVOs) {
		this.bsaTableSaveVOs = new BsaTableSaveVO[bsaTableSaveVOs.length];
		for(int i=0; i< bsaTableSaveVOs.length; ++i){
			this.bsaTableSaveVOs[i] = bsaTableSaveVOs[i];
		}
	}

}
