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
package com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.event;

import com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.vo.BsaManageSltPrcSaveVO;
import com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.vo.SearchBsaConditionVO;
import com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.vo.SearchBsaCrrRgstListVO;
import com.clt.framework.support.layer.event.EventSupport;
import java.util.Arrays;									//SJH.20150507.소스품질


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
	
	//SJH.20150507.소스품질
	public void setSearchBsaCrrRgstListVOS(SearchBsaCrrRgstListVO[] searchBsaCrrRgstListVOs){
		if(searchBsaCrrRgstListVOs != null){
			SearchBsaCrrRgstListVO[] tmpVOs = Arrays.copyOf(searchBsaCrrRgstListVOs, searchBsaCrrRgstListVOs.length);
			this.searchBsaCrrRgstListVOs = tmpVOs;
		}
	}

	public SearchBsaCrrRgstListVO getSearchBsaCrrRgstListVO(){
		return searchBsaCrrRgstListVO;
	}

	//SJH.20150507.소스품질
	public SearchBsaCrrRgstListVO[] getSearchBsaCrrRgstListVOS(){
		SearchBsaCrrRgstListVO[] rtnVOs = null;
		if (this.searchBsaCrrRgstListVOs != null) {
			rtnVOs = Arrays.copyOf(searchBsaCrrRgstListVOs, searchBsaCrrRgstListVOs.length);
		}
		return rtnVOs;
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

	//SJH.20150507.소스품질
	public BsaManageSltPrcSaveVO[] getBsaManageSltPrcSaveVOs() {
		BsaManageSltPrcSaveVO[] rtnVOs = null;
		if (this.bsaManageSltPrcSaveVOs != null) {
			rtnVOs = Arrays.copyOf(bsaManageSltPrcSaveVOs, bsaManageSltPrcSaveVOs.length);
		}
		return rtnVOs;
	}
	//SJH.20150507.소스품질
	public void setBsaManageSltPrcSaveVOs(BsaManageSltPrcSaveVO[] bsaManageSltPrcSaveVOs){
		if(bsaManageSltPrcSaveVOs != null){
			BsaManageSltPrcSaveVO[] tmpVOs = Arrays.copyOf(bsaManageSltPrcSaveVOs, bsaManageSltPrcSaveVOs.length);
			this.bsaManageSltPrcSaveVOs = tmpVOs;
		}
	}

}