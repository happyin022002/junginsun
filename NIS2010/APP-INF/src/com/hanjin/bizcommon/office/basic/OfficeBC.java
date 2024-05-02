/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : OfficeBC.java
*@FileTitle : Office 조회(공통 Popup)
*Open Issues :
*Change history :
*@LastModifyDate : 2006-08-02
*@LastModifier : Hyunsu, Ryu
*@LastVersion : 1.0
* 2006-08-02 Hyunsu, Ryu
* 1.0 최초 생성
=========================================================*/
package com.hanjin.bizcommon.office.basic;

import java.util.List;

import com.hanjin.bizcommon.office.vo.SearchOfficeListVO;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * ENIS-BIZCOMMON Business Logic Command Interface<br>
 * - ENIS-BIZCOMMON에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Hyunsu, Ryu
 * @see COM_ENS_071EventResponse 참조
 * @since J2EE 1.4
 */
public interface OfficeBC  {

	/**
	 * 조회 이벤트 처리<br>
	 * @param locCd
	 * @param ofcLev
	 * @param ofcPtsCd
	 * @param ofcCd
	 * @param ofcNm
	 * @param calltype
	 * @param iPage
	 * @param ofcAddr
	 * @return
	 * @throws EventException
	 */
    public List<SearchOfficeListVO> searchOfficeList(String locCd, String ofcLev, String ofcPtsCd, String ofcCd, String ofcNm, String calltype, int iPage, String ofcAddr) throws EventException;

}