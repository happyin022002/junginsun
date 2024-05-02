/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmFms0077Event.java
*@FileTitle : Carrier Code Selection - Window
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.13
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.05.13 윤세영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.fmscommon.externalfinder.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.fms.fmscommon.externalfinder.vo.SearchCarrierCodeListVO;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxoutputmasterdatamgt.vo.BsaVO;


/**
 * ESM_FMS_0077 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_FMS_0077HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Yoon Seyeong
 * @see ESM_FMS_0077HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmFms0077Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** carrNm Carrior Name */
	private String carrNm = "";
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchCarrierCodeListVO searchCarrierCodeListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchCarrierCodeListVO[] searchCarrierCodeListVOs = null;

	public EsmFms0077Event(){}
	
	public void setSearchCarrierCodeListVO(SearchCarrierCodeListVO searchCarrierCodeListVO){
		this. searchCarrierCodeListVO = searchCarrierCodeListVO;
	}

	public void setSearchCarrierCodeListVOS(SearchCarrierCodeListVO[] searchCarrierCodeListVOs){
		if (searchCarrierCodeListVOs != null) {
			SearchCarrierCodeListVO[] tmpVOs = new SearchCarrierCodeListVO[searchCarrierCodeListVOs.length];
			System.arraycopy(searchCarrierCodeListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.searchCarrierCodeListVOs = tmpVOs;
		}
	}

	public void setCarrNm(String carrNm) {
		this.carrNm = carrNm;
	}

	public SearchCarrierCodeListVO getSearchCarrierCodeListVO(){
		return searchCarrierCodeListVO;
	}

	public SearchCarrierCodeListVO[] getSearchCarrierCodeListVOS(){
		SearchCarrierCodeListVO[] rtnVOs = null;
		if (this.searchCarrierCodeListVOs != null) {
			rtnVOs = new SearchCarrierCodeListVO[searchCarrierCodeListVOs.length];
			System.arraycopy(searchCarrierCodeListVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	
	public String getCarrNm() {
		return carrNm;
	}

}