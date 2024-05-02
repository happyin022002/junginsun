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
* 2015.03.27 김용습 [CHM-201534456] 2015년 1월 소스 보안 결함 건 조치 요청
=========================================================*/
package com.hanjin.apps.alps.esm.bsa.bsamanage.spcmanage.event;

import com.hanjin.apps.alps.esm.bsa.bsamanage.spcmanage.vo.BsaSpcSlotInfoByVvdSaveVO;
import com.hanjin.apps.alps.esm.bsa.bsamanage.spcmanage.vo.SearchSpcConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.BsaVvdSwapInfoVO;


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

	//Yongseup Kim - Secure Coding [CWE-495]
	public BsaSpcSlotInfoByVvdSaveVO[] getBsaSpcSlotInfoByVvdSaveVOs() {
		BsaSpcSlotInfoByVvdSaveVO[] ret = null;
		if(this.bsaSpcSlotInfoByVvdSaveVOs != null){
			ret = new BsaSpcSlotInfoByVvdSaveVO[bsaSpcSlotInfoByVvdSaveVOs.length];
			for(int i=0; i<bsaSpcSlotInfoByVvdSaveVOs.length; i++){
				ret[i] = this.bsaSpcSlotInfoByVvdSaveVOs[i];
			}
		}
		return ret;
	}

	//Yongseup Kim - Secure Coding [CWE-496]
	public void setBsaSpcSlotInfoByVvdSaveVOs(
			BsaSpcSlotInfoByVvdSaveVO[] bsaSpcSlotInfoByVvdSaveVOs) {
		this.bsaSpcSlotInfoByVvdSaveVOs = new BsaSpcSlotInfoByVvdSaveVO[bsaSpcSlotInfoByVvdSaveVOs.length];
		for(int i=0; i< bsaSpcSlotInfoByVvdSaveVOs.length; ++i){
			this.bsaSpcSlotInfoByVvdSaveVOs[i] = bsaSpcSlotInfoByVvdSaveVOs[i];
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

	//Yongseup Kim - Secure Coding [CWE-495]
	public BsaVvdSwapInfoVO[] getBsaVvdSwapInfoVOs() {
		BsaVvdSwapInfoVO[] ret = null;
		if(this.bsaVvdSwapInfoVOs != null){
			ret = new BsaVvdSwapInfoVO[bsaVvdSwapInfoVOs.length];
			for(int i=0; i<bsaVvdSwapInfoVOs.length; i++){
				ret[i] = this.bsaVvdSwapInfoVOs[i];
			}
		}
		return ret;
	}

	//Yongseup Kim - Secure Coding [CWE-496]
	public void setBsaVvdSwapInfoVOs(BsaVvdSwapInfoVO[] bsaVvdSwapInfoVOs) {
		this.bsaVvdSwapInfoVOs = new BsaVvdSwapInfoVO[bsaVvdSwapInfoVOs.length];
		for(int i=0; i< bsaVvdSwapInfoVOs.length; ++i){
			this.bsaVvdSwapInfoVOs[i] = bsaVvdSwapInfoVOs[i];
		}
	}

}