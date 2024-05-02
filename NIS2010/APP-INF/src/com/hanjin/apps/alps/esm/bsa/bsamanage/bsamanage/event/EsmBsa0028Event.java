/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBsa0028Event.java
*@FileTitle : Inquire/Edit Slot-Cost
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.24
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2009.08.24 남궁진호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.event;

import com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.vo.BsaManageSltPrcSaveVO;
import com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.vo.SearchBsaCrrRgstListVO;
import com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.vo.SearchBsaConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BSA_0028 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BSA_0028HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author NAMKOONG Jin Ho
 * @see ESM_BSA_0028HTMLAction 참조
 * @since J2EE 1.6 
 */

public class EsmBsa0028Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchBsaCrrRgstListVO searchBsaCrrRgstListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchBsaCrrRgstListVO[] searchBsaCrrRgstListVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchBsaConditionVO searchBsaConditionVO=null;
	
	private BsaManageSltPrcSaveVO bsaManageSltPrcSaveVO = null;
	
	private BsaManageSltPrcSaveVO[] bsaManageSltPrcSaveVOs = null;
	

	public EsmBsa0028Event(){}
	
	public void setSearchBsaCrrRgstListVO(SearchBsaCrrRgstListVO searchBsaCrrRgstListVO){
		this. searchBsaCrrRgstListVO = searchBsaCrrRgstListVO;
	}

	//Yongseup Kim - Secure Coding [CWE-496]
	public void setSearchBsaCrrRgstListVOS(SearchBsaCrrRgstListVO[] searchBsaCrrRgstListVOs){
		this.searchBsaCrrRgstListVOs = new SearchBsaCrrRgstListVO[searchBsaCrrRgstListVOs.length];
		for(int i=0; i< searchBsaCrrRgstListVOs.length; ++i){
			this.searchBsaCrrRgstListVOs[i] = searchBsaCrrRgstListVOs[i];
		}
	}


	public SearchBsaCrrRgstListVO getSearchBsaCrrRgstListVO(){
		return searchBsaCrrRgstListVO;
	}

	//Yongseup Kim - Secure Coding [CWE-495]
	public SearchBsaCrrRgstListVO[] getSearchBsaCrrRgstListVOS(){
		SearchBsaCrrRgstListVO[] ret = null;
		if(this.searchBsaCrrRgstListVOs != null){
			ret = new SearchBsaCrrRgstListVO[searchBsaCrrRgstListVOs.length];
			for(int i=0; i<searchBsaCrrRgstListVOs.length; i++){
				ret[i] = this.searchBsaCrrRgstListVOs[i];
			}
		}
		return ret;
	}

	public SearchBsaConditionVO getSearchBsaConditionVO() {
		return searchBsaConditionVO;
	}

	public void setSearchBsaConditionVO(
			SearchBsaConditionVO searchBsaConditionVO) {
		this.searchBsaConditionVO = searchBsaConditionVO;
	}

	
	public BsaManageSltPrcSaveVO getBsaManageSltPrcSaveVO() {
		return bsaManageSltPrcSaveVO;
	}

	public void setBsaManageSltPrcSaveVO(BsaManageSltPrcSaveVO bsaManageSltPrcSaveVO) {
		this.bsaManageSltPrcSaveVO = bsaManageSltPrcSaveVO;
	}
	
	//Yongseup Kim - Secure Coding [CWE-495]
	public BsaManageSltPrcSaveVO[] getBsaManageSltPrcSaveVOs() {
		BsaManageSltPrcSaveVO[] ret = null;
		if(this.bsaManageSltPrcSaveVOs != null){
			ret = new BsaManageSltPrcSaveVO[bsaManageSltPrcSaveVOs.length];
			for(int i=0; i<bsaManageSltPrcSaveVOs.length; i++){
				ret[i] = this.bsaManageSltPrcSaveVOs[i];
			}
		}
		return ret;
	}

	//Yongseup Kim - Secure Coding [CWE-496]
	public void setBsaManageSltPrcSaveVOs(
			BsaManageSltPrcSaveVO[] bsaManageSltPrcSaveVOs) {
		this.bsaManageSltPrcSaveVOs = new BsaManageSltPrcSaveVO[bsaManageSltPrcSaveVOs.length];
		for(int i=0; i< bsaManageSltPrcSaveVOs.length; ++i){
			this.bsaManageSltPrcSaveVOs[i] = bsaManageSltPrcSaveVOs[i];
		}
	}

}