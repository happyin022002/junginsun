/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EesDod0001Event.java
*@FileTitle : Invoice Creation & Correction
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.28
*@LastModifier : 손진환
*@LastVersion : 1.0
* 2015.10.28 손진환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dod.doddropoff.dropoffcreation.event;

import java.util.Arrays;

import com.hanjin.apps.alps.ees.dod.doddropoff.dropoffcreation.vo.SearchDodDrpOffChgVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * EES_DOD_0001 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_DOD_0001HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Son, Jin-Hwan
 * @see EES_DOD_0001HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesDod0001Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	SearchDodDrpOffChgVO searchDodDrpOffChgVO = null;
	
	/** Table Value Object Multi Data 처리 */
	SearchDodDrpOffChgVO[] searchDodDrpOffChgVOs = null;

	/** 사후결재 진행을 위한 AUTH_APRO_RQST_NO */
	String authAproRqstNo = "";
	
	public EesDod0001Event(){}
	
	public void setSearchDodDrpOffChgVO(SearchDodDrpOffChgVO searchDodDrpOffChgVO){
		this.searchDodDrpOffChgVO = searchDodDrpOffChgVO;
	}

	public void setSearchDodDrpOffChgVOS(SearchDodDrpOffChgVO[] searchDodDrpOffChgVOs){
		if (searchDodDrpOffChgVOs != null) {
			SearchDodDrpOffChgVO[] tmpVOs = Arrays.copyOf(searchDodDrpOffChgVOs, searchDodDrpOffChgVOs.length);
			this.searchDodDrpOffChgVOs = tmpVOs;
		}
	}

	public SearchDodDrpOffChgVO getSearchDodDrpOffChgVO(){
		return searchDodDrpOffChgVO;
	}

	public SearchDodDrpOffChgVO[] getSearchDodDrpOffChgVOS(){
		SearchDodDrpOffChgVO[] rtnVOs = null;
		if (this.searchDodDrpOffChgVOs != null) {
			rtnVOs = Arrays.copyOf(searchDodDrpOffChgVOs, searchDodDrpOffChgVOs.length);
		}
		return rtnVOs;
	}

	public String getAuthAproRqstNo() {
		return authAproRqstNo;
	}

	public void setAuthAproRqstNo(String authAproRqstNo) {
		this.authAproRqstNo = authAproRqstNo;
	}

}