/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCtm0405Event.java
*@FileTitle : Empty VL List without BKG
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.14
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2009.05.14 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchEmptyBookingListVO;


/**
 * ees_ctm_0405 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ees_ctm_0405HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM, Sang-Soo
 * @see ees_ctm_0405HTMLAction 참조
 * @since J2EE 1.4
 */

public class EesCtm0405Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchEmptyBookingListVO searchEmptyBookingListVO = null;

	public EesCtm0405Event(){}

	public void setSearchEmptyBookingListVO(SearchEmptyBookingListVO searchEmptyBookingListVO){
		this. searchEmptyBookingListVO = searchEmptyBookingListVO;
	}

	public SearchEmptyBookingListVO getSearchEmptyBookingListVO(){
		return searchEmptyBookingListVO;
	}

}