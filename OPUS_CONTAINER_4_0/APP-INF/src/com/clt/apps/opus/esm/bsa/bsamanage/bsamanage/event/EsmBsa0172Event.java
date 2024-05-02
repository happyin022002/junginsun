/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBsa0172Event.java
*@FileTitle : H/C Rate for D3 & D5 & D7 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.16
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2009.10.16 남궁진호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.event;

import com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.vo.BsaHighCubicRateSaveVO;
import com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.vo.SearchBsaConditionVO;
import com.clt.framework.support.layer.event.EventSupport;
import java.util.Arrays;									//SJH.20150507.소스품질

/**
 * ESM_BSA_0172 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BSA_0172HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author NAMKOONG Jin Ho
 * @see ESM_BSA_0172HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBsa0172Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchBsaConditionVO searchBsaConditionVO=null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BsaHighCubicRateSaveVO bsaHighCubicRateSaveVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private BsaHighCubicRateSaveVO[] bsaHighCubicRateSaveVOs = null;

	public EsmBsa0172Event(){}
	
	public SearchBsaConditionVO getSearchBsaConditionVO() {
		return searchBsaConditionVO;
	}

	public void setSearchBsaConditionVO(
			SearchBsaConditionVO searchBsaConditionVO) {
		this.searchBsaConditionVO = searchBsaConditionVO;
	}

	public BsaHighCubicRateSaveVO getBsaHighCubicRateSaveVO() {
		return bsaHighCubicRateSaveVO;
	}

	public void setBsaHighCubicRateSaveVO(
			BsaHighCubicRateSaveVO bsaHighCubicRateSaveVO) {
		this.bsaHighCubicRateSaveVO = bsaHighCubicRateSaveVO;
	}
	
	//SJH.20150507.소스품질
	public BsaHighCubicRateSaveVO[] getBsaHighCubicRateSaveVOs() {
		BsaHighCubicRateSaveVO[] rtnVOs = null;
		if (this.bsaHighCubicRateSaveVOs != null) {
			rtnVOs = Arrays.copyOf(bsaHighCubicRateSaveVOs, bsaHighCubicRateSaveVOs.length);
		}
		return rtnVOs;
	}
	//SJH.20150507.소스품질
	public void setBsaHighCubicRateSaveVOs(BsaHighCubicRateSaveVO[] bsaHighCubicRateSaveVOs){
		if(bsaHighCubicRateSaveVOs != null){
			BsaHighCubicRateSaveVO[] tmpVOs = Arrays.copyOf(bsaHighCubicRateSaveVOs, bsaHighCubicRateSaveVOs.length);
			this.bsaHighCubicRateSaveVOs = tmpVOs;
		}
	}

	
	

}