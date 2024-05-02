/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBsa0104Event.java
*@FileTitle : Slot-info by VVD
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.06
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2009.10.06 남궁진호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bsa.bsamanage.spcmanage.event;

import com.clt.apps.opus.esm.bsa.bsamanage.spcmanage.vo.BsaSpcSlotInfoByVvdSaveVO;
import com.clt.apps.opus.esm.bsa.bsamanage.spcmanage.vo.SearchSpcConditionVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.BsaVvdSwapInfoVO;
import java.util.Arrays;									//SJH.20150507.소스품질

/**
 * ESM_BSA_0104 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BSA_0104HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author NAMKOONG Jin Ho
 * @see ESM_BSA_0104HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBsa0104Event extends  EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 처리 */
	private BsaSpcSlotInfoByVvdSaveVO bsaSpcSlotInfoByVvdSaveVO = null;
	
	/** Table Value Object 조회 조건 처리 */
	private BsaSpcSlotInfoByVvdSaveVO[] bsaSpcSlotInfoByVvdSaveVOs = null;
	
	/** Table Value Object 조회 조건 처리 */
	private BsaVvdSwapInfoVO bsaVvdSwapInfoVO = null;
	
	/** Table Value Object 조회 조건 처리 */
	private BsaVvdSwapInfoVO[] bsaVvdSwapInfoVOs = null;
	
	/** Table Value Object 조회 조건 처리 */
	private SearchSpcConditionVO searchSpcConditionVO = null;
	
	
	public EsmBsa0104Event(){}
	
	
	
	public BsaSpcSlotInfoByVvdSaveVO getBsaSpcSlotInfoByVvdSaveVO() {
		return bsaSpcSlotInfoByVvdSaveVO;
	}

	public void setBsaSpcSlotInfoByVvdSaveVO(
			BsaSpcSlotInfoByVvdSaveVO bsaSpcSlotInfoByVvdSaveVO) {
		this.bsaSpcSlotInfoByVvdSaveVO = bsaSpcSlotInfoByVvdSaveVO;
	}

	//SJH.20150507.소스품질
	public BsaSpcSlotInfoByVvdSaveVO[] getBsaSpcSlotInfoByVvdSaveVOs() {
		BsaSpcSlotInfoByVvdSaveVO[] rtnVOs = null;
		if (this.bsaSpcSlotInfoByVvdSaveVOs != null) {
			rtnVOs = Arrays.copyOf(bsaSpcSlotInfoByVvdSaveVOs, bsaSpcSlotInfoByVvdSaveVOs.length);
		}
		return rtnVOs;
	}


	//SJH.20150507.소스품질
	public void setBsaSpcSlotInfoByVvdSaveVOs(BsaSpcSlotInfoByVvdSaveVO[] bsaSpcSlotInfoByVvdSaveVOs){
		if(bsaSpcSlotInfoByVvdSaveVOs != null){
			BsaSpcSlotInfoByVvdSaveVO[] tmpVOs = Arrays.copyOf(bsaSpcSlotInfoByVvdSaveVOs, bsaSpcSlotInfoByVvdSaveVOs.length);
			this.bsaSpcSlotInfoByVvdSaveVOs = tmpVOs;
		}
	}



	public SearchSpcConditionVO getSearchSpcConditionVO() {
		return searchSpcConditionVO;
	}

	public void setSearchSpcConditionVO(SearchSpcConditionVO searchSpcConditionVO) {
		this.searchSpcConditionVO = searchSpcConditionVO;
	}


	public BsaVvdSwapInfoVO getBsaVvdSwapInfoVO() {
		return bsaVvdSwapInfoVO;
	}


	public void setBsaVvdSwapInfoVO(BsaVvdSwapInfoVO bsaVvdSwapInfoVO) {
		this.bsaVvdSwapInfoVO = bsaVvdSwapInfoVO;
	}

	//SJH.20150507.소스품질
	public BsaVvdSwapInfoVO[] getBsaVvdSwapInfoVOs() {
		BsaVvdSwapInfoVO[] rtnVOs = null;
		if (this.bsaVvdSwapInfoVOs != null) {
			rtnVOs = Arrays.copyOf(bsaVvdSwapInfoVOs, bsaVvdSwapInfoVOs.length);
		}
		return rtnVOs;
	}

	//SJH.20150507.소스품질
	public void setBsaVvdSwapInfoVOs(BsaVvdSwapInfoVO[] bsaVvdSwapInfoVOs){
		if(bsaVvdSwapInfoVOs != null){
			BsaVvdSwapInfoVO[] tmpVOs = Arrays.copyOf(bsaVvdSwapInfoVOs, bsaVvdSwapInfoVOs.length);
			this.bsaVvdSwapInfoVOs = tmpVOs;
		}
	}

}