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
package com.hanjin.apps.alps.ees.dod.doddropoff.dropoffinquiry.event;

import java.util.Arrays;

import com.hanjin.apps.alps.ees.dod.doddropoff.dropoffcreation.vo.SearchDodDrpOffChgVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * EES_DOD_0003 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_DOD_0003HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Son, Jin-Hwan
 * @see EES_DOD_0003HTMLAction 참조
 * @since J2EE 1.6 
 */

public class EesDod0003Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	SearchDodDrpOffChgVO searchDodDrpOffChgVO = null;
	
	public EesDod0003Event(){}
	
	public void setSearchDodDrpOffChgVO(SearchDodDrpOffChgVO searchDodDrpOffChgVO){
		this.searchDodDrpOffChgVO = searchDodDrpOffChgVO;
	}

	public SearchDodDrpOffChgVO getSearchDodDrpOffChgVO(){
		return searchDodDrpOffChgVO;
	}
}