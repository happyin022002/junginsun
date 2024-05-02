/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : LocationBC.java
*@FileTitle : Location조회(공통 Popup)
*Open Issues :
*Change history :
*@LastModifyDate : 2006-08-03
*@LastModifier : HyungChoonRoh
*@LastVersion : 1.0
* 2006-08-03 HyungChoonRoh
* 1.0 최초 생성
=========================================================*/
package com.hanjin.bizcommon.location.basic;

import java.util.List;

import com.hanjin.bizcommon.location.vo.SearchLocationDetailVO;
import com.hanjin.bizcommon.location.vo.SearchLocationListVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;

/**
 * ENIS-BIZCOMMON Business Logic Command Interface<br>
 * - ENIS-BIZCOMMON에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author HyungChoonRoh
 * @see ComEns051EventResponse 참조
 * @since J2EE 1.4
 */
public interface LocationBC  {
	
	/**
     * Location의 모든 목록을 가져온다.<br>
     * @param String locCd
     * @param String locNm
     * @param String unLocIndCd
     * @param String cntCd
     * @param String locEqOfc
     * @param String select
     * @param String rccCd
     * @param String lccCd
     * @param String locState
     * @param int iPage
     * @return List<SearchLocationListVO>
     * @throws DAOException
     */
    public List<SearchLocationListVO> searchLocationList(String locCd, String locNm, String unLocIndCd, String cntCd, String locEqOfc, String select, String rccCd, String lccCd, String locState, int iPage) throws EventException;
    
    /**
     * 
     * @param locCd
     * @return List<SearchLocationDetailVO>
     * @Exception EventException
     */
    public List<SearchLocationDetailVO> searchLocationDetail(String locCd) throws EventException;
    
}