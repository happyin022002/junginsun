/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EesDod0012Event.java
*@FileTitle : Approval Invoice Detail
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.13
*@LastModifier : 손진환
*@LastVersion : 1.0
* 2015.11.13 손진환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dod.doddropoff.dropoffcreation.event;

import java.util.Arrays;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.ees.dod.doddropoff.dropoffcreation.vo.SearchDodDrpOffChgVO;


/**
 * EES_DOD_0012 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_DOD_0012HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Son, Jin-Hwan
 * @see EES_DOD_0012HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesDod0012Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private String authAproRqstNo = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	SearchDodDrpOffChgVO searchDodDrpOffChgVO = null;
	
	/** Table Value Object Multi Data 처리 */
	SearchDodDrpOffChgVO[] searchDodDrpOffChgVOs = null;

	public EesDod0012Event(){}
	
	public void setSearchDodDrpOffChgVO(SearchDodDrpOffChgVO searchDodDrpOffChgVO){
		this. searchDodDrpOffChgVO = searchDodDrpOffChgVO;
	}

	public void setSearchDodDrpOffChgVOS(SearchDodDrpOffChgVO[] searchDodDrpOffChgVOs){
		if (searchDodDrpOffChgVOs != null) {
			SearchDodDrpOffChgVO[] tmpVOs = Arrays.copyOf(searchDodDrpOffChgVOs, searchDodDrpOffChgVOs .length);
			this. searchDodDrpOffChgVOs = tmpVOs;
		}
	}

	public SearchDodDrpOffChgVO getSearchDodDrpOffChgVO(){
		return searchDodDrpOffChgVO;
	}

	public SearchDodDrpOffChgVO[] getSearchDodDrpOffChgVOS(){
		SearchDodDrpOffChgVO[] tmpVOs = null;
		if (this. searchDodDrpOffChgVOs != null) {
			tmpVOs = Arrays.copyOf(searchDodDrpOffChgVOs, searchDodDrpOffChgVOs .length);
		}
		return tmpVOs;
	}
	
	public String getAuthAproRqstNo() {
		return authAproRqstNo;
	}

	
	public void setAuthAproRqstNo(String authAproRqstNo) {
		this.authAproRqstNo = authAproRqstNo;
	}
}