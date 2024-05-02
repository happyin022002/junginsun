/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BLInformationMgtBC.java
*@FileTitle : C/A Summary
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.14
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2010.01.14 강동윤
* 1.0 Creation
* History
* 2012.08.22 김기택 [CHM-201219155-01j] B/L Preview 기능 추가 
=========================================================*/
package com.hanjin.apps.alps.esm.bis.blinformationmgt.blinformationmgt.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.bis.blinformationmgt.blinformationmgt.vo.BisManualListVO;
import com.hanjin.apps.alps.esm.bis.blinformationmgt.blinformationmgt.vo.BisMonitorListVO;
import com.hanjin.apps.alps.esm.bis.blinformationmgt.blinformationmgt.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bis.blinformationmgt.blinformationmgt.vo.CaDetailVO;
import com.hanjin.apps.alps.esm.bis.blinformationmgt.blinformationmgt.vo.CaInfoByBkgVO;
import com.hanjin.apps.alps.esm.bis.blinformationmgt.blinformationmgt.vo.CaSummaryReportInVO;
import com.hanjin.apps.alps.esm.bis.blinformationmgt.blinformationmgt.vo.CaSummaryReportOutVO;
import com.hanjin.apps.alps.esm.bis.blinformationmgt.blinformationmgt.vo.GrpBlPrtInVO;
import com.hanjin.apps.alps.esm.bis.blinformationmgt.blinformationmgt.vo.GrpBlPrtOutVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * ALPS-Blinformationmgt Business Logic Command Interface<br>
 * - ALPS-Blinformationmgt에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author kang dong yun
 * @see Ui_bkg-0079-04EventResponse 참조
 * @since J2EE 1.6
 */

public interface BLInformationMgtBC {

	/**
	 * C/A Summary Report 결과를 조회한다. (ESM_BKG_0174)<br>
	 * 
	 * @param  CaSummaryReportInVO vo
	 * @return List<CaSummaryReportOutVO>
	 * @throws EventException
	 */	
    public List<CaSummaryReportOutVO> searchCaSummaryReport(CaSummaryReportInVO vo) throws EventException;
    
    /**
	 * C/A Summary Report BL List 결과를 조회한다. (ESM_BKG_0174)<br>
	 * 
	 * @param  CaSummaryReportInVO vo
	 * @return List<CaSummaryReportOutVO>
	 * @throws EventException
	 */	
    public List<CaSummaryReportOutVO> searchCaSummaryReportBLList(CaSummaryReportInVO vo) throws EventException;
    
	/**
	 * 조회 이벤트 처리
	 *  MultiCombo 조회 이벤트 처리 ESM_BKG_0278
	 *
	 * @param BkgComboVO bkgComboVO
	 * @return List<BkgComboVO>
	 * @exception EventException
	 */
	public List<BkgComboVO> searchSRouteFromList(BkgComboVO bkgComboVO) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 *  ESM_BKG_0280화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param GrpBlPrtInVO grpBlPrtInVO
	 * @return GrpBlPrtOutVO
	 * @exception EventException
	 */
	public GrpBlPrtOutVO searchBkgListForGrpBlPr(GrpBlPrtInVO grpBlPrtInVO) throws EventException;
	
	/**
     * bkg별 기본 정보와 C/A 변경 list를 조회한다.<br>
     * @author Lee NamKyung 
     * @param  BkgBlNoVO bkgBlNoVO
     * @return CaInfoByBkgVO 
     * @exception EventException
     */
    public CaInfoByBkgVO searchCaInfoByBkg(BkgBlNoVO bkgBlNoVO) throws EventException;
    
    /**
     *  C/A 변경 건 별 상세 정보를 조회한다.<br>
     * @author Lee NamKyung 
     * @param  BkgBlNoVO bkgBlNoVO
     * @return CaDetailVO 
     * @exception EventException
     */
    public CaDetailVO searchCaDetail(BkgBlNoVO bkgBlNoVO) throws EventException;
    
    /**
     *  BIS MonitorList 를 조회한다.(ESM_BIS_0001)<br>
     * @author KIM TAE KYOUNG 
     * @param  String fromDt
     * @param  String toDt
     * @return List<BisMonitorListVO> 
     * @exception EventException
     */
    public List<BisMonitorListVO> searchBisMonitorList(String fromDt,String toDt) throws EventException;
    
    /**
     *  BIS MonitorList 를 조회한다.(ESM_BIS_0000)<br>
     * @author KIM TAE KYOUNG 
     * @param  String fromDt
     * @param  String toDt
     * @return List<BisMonitorListVO> 
     * @exception EventException
     */
    public List<BisManualListVO> searchBisManualList(String fromDt,String toDt) throws EventException;
 
    /**
     *  BIS MonitorList 를 수정한다.(ESM_BIS_0000)<br>
     * @param BisManualListVO bisManualListVO
     */
    
    public void manageBisBkgManual(BisManualListVO bisManualListVO) throws EventException;
    
    /**
     *  BIS MonitorList 를 수정한다.(ESM_BIS_0000)<br>
     * @param  String fromDt
     * @param  String toDt
     */
    public void manageBisManual(String fromDt,String toDt) throws EventException;
    
    /**
	 * 조회 이벤트 처리
	 *  Rider 여부판단 ESM_BIS_0927
	 *
	 * @param String bkg_no
	 * @param String hiddenData
	 * @param String rate
	 * @param String cntr
	 * @param String corr_no
	 * @return String
	 * @exception EventException
	 */
	public String searchRiderYn(String bkg_no, String hiddenData, String rate, String cntr, String corr_no) throws EventException;
	
	/**
	 * 조회 이벤트 처리
	 *  HouseB/L 여부판단 ESM_BIS_0927
	 *
	 * @param String bkg_no
	 * @return String
	 * @exception EventException
	 */
	public String searchHouseBlYn(String bkg_no) throws EventException;

	/**
	 * EsmBis0927Event 조회 이벤트 처리<br>
	 * B/L Iss 정보 조회<br>
	 *
	 * @param String bkg_no
	 * @return String
	 * @exception EventException
	 */
	public String searchOblIssFlg(String bkg_no) throws EventException;

}