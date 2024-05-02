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
package com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.basic;

import java.util.List;

import com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.event.EsdTrs0980Event;
import com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.vo.SearchLocationDetailVO;
import com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.vo.SearchLocationListVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;

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
     * Location의 모든 목록을 가져온다.(mdm yn , deltflg add)
     * 
     * @param locCd
     * @param locNm
     * @param unLocIndCd
     * @param cntCd
     * @param locEqOfc
     * @param select
     * @param rccCd
     * @param lccCd
     * @param locState
     * @param iPage
     * @param mdmYN
     * @param deltFlg
     * @return
     * @throws EventException
     */
    public List<SearchLocationListVO> searchLocationList(String locCd, String locNm, String unLocIndCd, String cntCd, String locEqOfc, String select, String rccCd, String lccCd, String locState, int iPage, String mdmYN, String deltFlg)throws EventException;
    
    /**
     * Location의 모든 목록을 가져온다.(scc flag add)
     * 
     * @param locCd
     * @param locNm
     * @param unLocIndCd
     * @param cntCd
     * @param locEqOfc
     * @param select
     * @param rccCd
     * @param lccCd
     * @param locState
     * @param iPage
     * @param mdmYN
     * @param deltFlg
     * @param sccFlg
     * @return
     * @throws EventException
     */
    public List<SearchLocationListVO> searchLocationList(String locCd, String locNm, String unLocIndCd, String cntCd, String locEqOfc, String select, String rccCd, String lccCd, String locState, int iPage, String mdmYN, String deltFlg, String sccFlg)throws EventException;
    
    /**
     * 
     * @param locCd
     * @return List<SearchLocationDetailVO>
     * @Exception EventException
     */
    public List<SearchLocationDetailVO> searchLocationDetail(String locCd) throws EventException;

    /**
     * 
     * @param event
     * @return
     * @throws EventException
     */
	public List<SearchLocationDetailVO> searchLocationDetail( EsdTrs0980Event event)throws EventException;

	

    
    
}