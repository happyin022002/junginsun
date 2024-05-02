/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChassisMgsetInventoryBC.java
*@FileTitle : Factor Adjustment by Location
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.29
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2009.05.13 박의수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSAssetsDetailVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSAssetsOptionVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSAssetsSmryVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSEspFactorINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSEspFactorMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSEspReportINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSEspReportMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSHistoricalRptINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSHistoricalRptMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSInventoryByAgmtINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSInventoryByAgmtMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSInventoryByOnhireYearINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSInventoryByOnhireYearMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSInventoryByStaydaysINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSInventoryByStaydaysMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSInventoryByVariationDtlINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSInventoryByVariationDtlMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSInventoryByVariationINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSInventoryByVariationMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSInventoryDtlINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSInventoryDtlMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSInventoryGeneralINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSInventoryGeneralMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSLongStaydaysEnvINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSLongStaydaysEnvMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSUtilFactorINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSUtilFactorMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSUtilizationINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSUtilizationMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.MGSInventoryByLessorAgmtINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.MGSInventoryByLessorAgmtMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.MGSInventoryByLessorTermINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.MGSInventoryByLessorTermMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.MGSInventoryByLocationLessorINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.MGSInventoryByLocationLessorMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.MGSInventoryByOfficeINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.MGSInventoryByOfficeMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.MGSInventoryDetailINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.MGSInventoryDetailMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.MGSInventoryDtlINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.MGSInventoryDtlMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.MGSInventoryGeneralINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.MGSInventoryGeneralMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.MGSBareMVMTDataVO;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-Chassismgsetmgt Business Logic Command Interface<br>
 * - ALPS-Chassismgsetmgt에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Eui-su Park 
 * @see Ees_cgm_1114EventResponse 참조
 * @since J2EE 1.4
 */

public interface ChassisMgsetInventoryBC {

	/**
	 * Chassis Inventory 에 count 된 장비별 상세 list 를 조회. Retrieve [EES_CGM_1091]<br>
	 * 
	 * @param chsInventoryDtlINVO CHSInventoryDtlINVO
	 * @return List<CHSInventoryDtlMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<CHSInventoryDtlMGTVO> searchCHSInventoryGeneralListBasic(CHSInventoryDtlINVO chsInventoryDtlINVO) throws EventException;
	
	/**
	 * M.G.Set Inventory 에 count 된 장비별 상세 list 를 조회. Retrieve [EES_CGM_2084]<br>
	 * 
	 * @param mgsInventoryDtlINVO MGSInventoryDtlINVO
	 * @return List<MGSInventoryDtlMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<MGSInventoryDtlMGTVO> searchMGSInventoryGeneralListBasic(MGSInventoryDtlINVO mgsInventoryDtlINVO) throws EventException;
	
	/**
	 * Chassis 기본적 인벤토리 조회 화면인 General Inventory 산출.. Retrieve [EES_CGM_1089]<br>
	 * 
	 * @param chsInventoryGeneralINVO CHSInventoryGeneralINVO
	 * @return List<CHSInventoryGeneralMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<CHSInventoryGeneralMGTVO> searchCHSInventoryGeneralBasic(CHSInventoryGeneralINVO chsInventoryGeneralINVO) throws EventException;
	
	/**
	 * Inventory By staying days 산출.  [EES_CGM_1092]<br>
	 * 
	 * @param chsInventoryByStaydaysINVO CHSInventoryByStaydaysINVO   
	 * @return List<CHSInventoryByStaydaysMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */	
	public List<CHSInventoryByStaydaysMGTVO> searchCHSInventoryByStaydaysBasic(CHSInventoryByStaydaysINVO chsInventoryByStaydaysINVO) throws EventException;
	
	/**
	 *  User ID 별 Inventory By Long Staying Days 화면에서 쓰이는 그룹 기준 날짜 정보를 조회한다.  [EES_CGM_1094]<br>
	 * 
	 * @param chsLongStaydaysEnvINVO CHSLongStaydaysEnvINVO 
	 * @param account SignOnUserAccount  
	 * @return List<CHSLongStaydaysEnvMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */		
	public List<CHSLongStaydaysEnvMGTVO> searchCHSLongstayEnvBasic(CHSLongStaydaysEnvINVO chsLongStaydaysEnvINVO, SignOnUserAccount account) throws EventException;

	
	/**
	 * User ID 별 Inventory By Long Staying Days 화면에서 쓰이는 그룹 기준 날짜를 설정한다.  [EES_CGM_1094]<br>
	 * 
	 * @param cHSLongStaydaysEnvINVOs CHSLongStaydaysEnvINVO[] 
	 * @param account SignOnUserAccount  
	 * @exception DAOException
	 * @exception Exception
	 */		
	public void manageCHSLongstayEnvBasic(CHSLongStaydaysEnvINVO[] cHSLongStaydaysEnvINVOs, SignOnUserAccount account) throws EventException;
	
	
	/**
	 * Inventory By Agreement 산출. [EES_CGM_1098]<br>
	 * 
	 * @param cHSInventoryByAgmtINVO CHSInventoryByAgmtINVO 
	 * @return List<CHSInventoryByAgmtMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */		
	public List<CHSInventoryByAgmtMGTVO> searchCHSInventoryByAgmtBasic(CHSInventoryByAgmtINVO cHSInventoryByAgmtINVO) throws EventException;	
	
	
	/**
	 * Inventory By On-hire year  산출. [EES_CGM_1100]<br>
	 * 
	 * @param cHSInventoryByOnhireYearINVO CHSInventoryByOnhireYearINVO 
	 * @return List<CHSInventoryByOnhireYearMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */			
	public List<CHSInventoryByOnhireYearMGTVO> searchCHSInventoryByOnhireYearBasic (CHSInventoryByOnhireYearINVO cHSInventoryByOnhireYearINVO) throws EventException;	
	
	/**
	 * Inventory Variation 산출. [EES_CGM_1102]<br>
	 * 
	 * @param cHSInventoryByVariationINVO CHSInventoryByVariationINVO 
	 * @return List<CHSInventoryByVariationMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */		
	public List<CHSInventoryByVariationMGTVO> searchCHSInventoryByVariationBasic  (CHSInventoryByVariationINVO cHSInventoryByVariationINVO) throws EventException;
	
	/**
	 * Inventory Variation Detail List 산출. [EES_CGM_1103]<br>
	 * 
	 * @param cHSInventoryByVariationDtlINVO CHSInventoryByVariationDtlINVO 
	 * @return List<CHSInventoryByVariationDtlMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */		
	public List<CHSInventoryByVariationDtlMGTVO> searchCHSInventoryByVariationDtlListBasic (CHSInventoryByVariationDtlINVO cHSInventoryByVariationDtlINVO) throws EventException;
	
	
	/**
	 * Utilization Factor by Yard 정보 조회(Yard 조회)  [EES_CGM_1111]<br>
	 * 
	 * @param cHSUtilFactorINVO CHSUtilFactorINVO   
	 * @return List<CHSUtilFactorMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<CHSUtilFactorMGTVO> searchCHSUtilFactorBasic(CHSUtilFactorINVO cHSUtilFactorINVO) throws EventException;	

	/**
	 * Utilization Factor by Yard 상세 정보 조회(Container status 조회)  [EES_CGM_1111]<br>
	 * 
	 * @param cHSUtilFactorINVO CHSUtilFactorINVO 
	 * @return List<CHSUtilFactorMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<CHSUtilFactorMGTVO> searchCHSUtilFactorDtlBasic(CHSUtilFactorINVO cHSUtilFactorINVO) throws EventException;	
	
	
	/**
	 * Utilization Factor by Yard 정보 저장(Yard/Status 저장)  [EES_CGM_1111]<br>
	 * 
	 * @param cHSUtilFactorINVO CHSUtilFactorINVO
	 * @param cHSUtilFactorINVOs1 CHSUtilFactorINVO[]  
	 * @param cHSUtilFactorINVOs2 CHSUtilFactorINVO[]  
	 * @param account SignOnUserAccount 	
	 * @exception DAOException
	 * @exception Exception
	 */
	public void manageCHSUtilFactorBasic(CHSUtilFactorINVO  cHSUtilFactorINVO, CHSUtilFactorINVO[]  cHSUtilFactorINVOs1, CHSUtilFactorINVO[]  cHSUtilFactorINVOs2, SignOnUserAccount account ) throws EventException;
	
	
	/**
	 * Chassis Utilization report 정보 조회(Chassis Utilization조회) [EES_CGM_1112] <br>
	 *  
	 * @param cHSUtilizationINVO CHSUtilizationINVO 
	 * @return CHSUtilizationMGTVO
	 * @exception DAOException
	 * @exception Exception
	 */	
	public CHSUtilizationMGTVO searchCHSUtilizationRptBasic (CHSUtilizationINVO cHSUtilizationINVO) throws EventException;

	
	/**
	 * 조회 조건별 Historical Report 산출. [EES_CGM_1113] <br>
	 *  
	 * @param cHSHistoricalRptINVO CHSHistoricalRptINVO 
	 * @return List<CHSHistoricalRptMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */		
	public List<CHSHistoricalRptMGTVO> searchCHSHistoricalReportBasic (CHSHistoricalRptINVO cHSHistoricalRptINVO) throws EventException;
	
	/**
	 * ESP(Equipment Standard Pool)  Report 산출 변수를 조회한다. [EES_CGM_1114] <br>
	 *  
	 * @param cHSEspFactorINVO CHSEspFactorINVO 
	 * @return List<CHSEspFactorMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */	
	public List<CHSEspFactorMGTVO> searchCHSEspFactorBasic (CHSEspFactorINVO cHSEspFactorINVO) throws EventException;
	
	
	/**
	 * ESP(Equipment Standard Pool)  Report 산출 변수를 설정한다. [EES_CGM_1114] <br>
	 *  
	 * @param cHSEspFactorINVOs CHSEspFactorINVO[] 
	 * @exception DAOException
	 * @exception Exception
	 */	
	public void manageCHSEspFactorBasic (CHSEspFactorINVO[] cHSEspFactorINVOs) throws EventException;

	/**
	 * 1. Container BOX (Thorughput) 계산 2. Turn Time 계산 3. Domestic Booking 카운트하여 Container BOX (Throughput) 계산 4. ESP Adjust 에서 입력된 변수를 조회시작  [EES_CGM_1115] <br>
	 *  
	 * @param cHSEspReportINVO CHSEspReportINVO 
	 * @return String
	 * @exception Exception
	 */	
	public String searchCHSEspReportBasicBackEndJobStart  (CHSEspReportINVO cHSEspReportINVO) throws EventException;
	
	/**
	 * 1. Container BOX (Thorughput) 계산 2. Turn Time 계산 3. Domestic Booking 카운트하여 Container BOX (Throughput) 계산 4. ESP Adjust 에서 입력된 변수를 조회  [EES_CGM_1115] <br>
	 *  
	 * @param key String 
	 * @return List<CHSEspReportMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */	
	public List<CHSEspReportMGTVO> searchCHSEspReportBasic(String key) throws EventException;	
	//public List<CHSEspReportMGTVO> searchCHSEspReportBasic  (CHSEspReportINVO cHSEspReportINVO) throws EventException;
	
	/**
	 * 기본적 인벤토리 조회 화면인 M.G.Set Inventory Summary 산출.  [EES_CGM_2076]<br>
	 * 
	 * @param mGSInventoryGeneralINVO MGSInventoryGeneralINVO   
	 * @return List<MGSInventoryGeneralMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */	
	public List<MGSInventoryGeneralMGTVO> searchMGSInventoryGeneralBasic(MGSInventoryGeneralINVO mGSInventoryGeneralINVO) throws EventException;
	
	/**
	 * [EES_CGM_2075] : [Retrieve] <br>
	 * M.G.Set Inventory Detail SEARCH Basic<br>
	 *
	 * @param mGSInventoryDetailINVO MGSInventoryDetailINVO
	 * @return List<MGSInventoryDetailMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<MGSInventoryDetailMGTVO> searchMGSInventoryDetailBasic(MGSInventoryDetailINVO mGSInventoryDetailINVO) throws EventException;

	/**
	 * Inventory By Lessor and Agreement Type (UMG/CLG) 별 Summary 조회.  [EES_CGM_2077]<br>
	 * 
	 * @param mGSInventoryByLessorAgmtINVO MGSInventoryByLessorAgmtINVO   
	 * @return List<MGSInventoryByLessorAgmtMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */	
	public List<MGSInventoryByLessorAgmtMGTVO> searchMGSInventoryByLessorAgmtBasic (MGSInventoryByLessorAgmtINVO mGSInventoryByLessorAgmtINVO) throws EventException;

	/**
	 * Inventory By Lessor and Term(Lessor, Lease Term 별 장비 Inventory)에서 Location 별 Term 별 장비 TP/SZ 를 카운트하여 조회.  [EES_CGM_2078]<br>
	 * 
	 * @param mGSInventoryByLessorTermINVO MGSInventoryByLessorTermINVO   
	 * @return List<MGSInventoryByLessorTermMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */	
	public List<MGSInventoryByLessorTermMGTVO> searchMGSInventoryByLessorTermBasic  (MGSInventoryByLessorTermINVO mGSInventoryByLessorTermINVO) throws EventException;

	/**
	 * Inventory By Creation office On-hire Office 별, 기간별 장비 Inventory 산출.  [EES_CGM_2079]<br>
	 * 
	 * @param mGSInventoryByOfficeINVO MGSInventoryByOfficeINVO   
	 * @return List<MGSInventoryByOfficeMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */	
	public List<MGSInventoryByOfficeMGTVO> searchMGSInventoryByOfficeBasic (MGSInventoryByOfficeINVO mGSInventoryByOfficeINVO) throws EventException;

	/**
	 * Location& Lessor별 Inventory를 산출.  [EES_CGM_2080]<br>
	 * 
	 * @param mGSInventoryByLocationLessorINVO MGSInventoryByLocationLessorINVO   
	 * @return List<MGSInventoryByLocationLessorMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */	
	public List<MGSInventoryByLocationLessorMGTVO> searchMGSInventoryByLocationLessorBasic (MGSInventoryByLocationLessorINVO mGSInventoryByLocationLessorINVO) throws EventException;
	
	
	/**
	 * Inventory Variation 산출시작. Back End Job  [EES_CGM_1102] <br>
	 *  
	 * @param cHSInventoryByVariationINVO CHSInventoryByVariationINVO 
	 * @return String
	 * @exception Exception
	 */	
	public String searchCHSInventoryByVariationBasicBackEndJobStart  (CHSInventoryByVariationINVO cHSInventoryByVariationINVO) throws EventException;

	/**
	 * Inventory Variation 산출끝. Back End Job  [EES_CGM_1102] <br>
	 *  
	 * @param key String 
	 * @return List<CHSInventoryByVariationMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */	
	public List<CHSInventoryByVariationMGTVO> searchCHSInventoryByVariationBasicFile  (String key) throws EventException;

	/**
	 * Inventory Variation 산출시작. Back End Job  [EES_CGM_1103] <br>
	 *  
	 * @param cHSInventoryByVariationDtlINVO CHSInventoryByVariationDtlINVO 
	 * @return String
	 * @exception Exception
	 */	
	public String searchCHSInventoryByVariationDtlBasicBackEndJobStart  (CHSInventoryByVariationDtlINVO cHSInventoryByVariationDtlINVO) throws EventException;

	/**
	 * Inventory Variation 산출끝. Back End Job  [EES_CGM_1103] <br>
	 *  
	 * @param key String 
	 * @return List<CHSInventoryByVariationMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */	
	public List<CHSInventoryByVariationDtlMGTVO> searchCHSInventoryByVariationDtlBasicFile  (String key) throws EventException;
	
	/**
	 * 연도별 자산 집계현황을 조회한다.<br>
	 * 
	 * @author J.H
	 * @category EES_CGM_1153
	 * @category searchCHSAssetsSmryListBasic   
	 * 
	 * @param CHSAssetsOptionVO chsAssetsOptionVO
	 * @return List<CHSAssetsSmryVO>
	 * @exception EventException
	 */			
	public List<CHSAssetsSmryVO> searchCHSAssetsSmryListBasic(CHSAssetsOptionVO chsAssetsOptionVO) throws EventException;	
	
	/**
	 * 연도별 자산 현황을 장비별로 상세 조회한다.<br>
	 * 
	 * @param CHSAssetsSmryVO chsAssetsSmryVO
	 * @return List<CHSAssetsDetailVO>
	 * @exception EventException
	 */			
	public List<CHSAssetsDetailVO> searchCHSAssetsDetailListBasic(CHSAssetsSmryVO chsAssetsSmryVO) throws EventException;
	/**
	 *  조회한다.<br>
	 * 
	 * @param MGSBareMVMTDataVO mGSBareMVMTDataVO
	 * @return List<MGSBareMVMTDataVO>
	 * @exception EventException
	 */
	public List<MGSBareMVMTDataVO> searchBareMGSet(MGSBareMVMTDataVO mGSBareMVMTDataVO) throws EventException;
	/**
	 *  조회한다.<br>
	 * 
	 * @param MGSBareMVMTDataVO mGSBareMVMTDataVO
	 * @return String
	 * @exception EventException
	 */
	public String searchMGSetNo(MGSBareMVMTDataVO mGSBareMVMTDataVO) throws EventException;
	/**
	 *  조회한다.<br>
	 * 
	 * @param MGSBareMVMTDataVO mGSBareMVMTDataVO
	 * @return String[]
	 * @exception EventException
	 */
	public String[] searchEqTpszCd(MGSBareMVMTDataVO mGSBareMVMTDataVO) throws EventException;
	/**
	 *  MGSetUMG 조회한다.<br>
	 * 
	 * @param MGSBareMVMTDataVO mGSBareMVMTDataVO
	 * @return String
	 * @exception EventException
	 */
	public String checkBareMGSetContNoData(MGSBareMVMTDataVO mGSBareMVMTDataVO) throws EventException;
	/**
	 *  MGSetUMG 조회한다.<br>
	 * 
	 * @param MGSBareMVMTDataVO mGSBareMVMTDataVO
	 * @return String[]
	 * @exception EventException
	 */
	public String[] searchBareMGSetCLGData(MGSBareMVMTDataVO mGSBareMVMTDataVO) throws EventException;
	/**
	 *  MGSetUMG 조회한다.<br>
	 * 
	 * @param MGSBareMVMTDataVO mGSBareMVMTDataVO
	 * @return String
	 * @exception EventException
	 */
	public String checkBareMGSetChsNoData(MGSBareMVMTDataVO mGSBareMVMTDataVO) throws EventException;
	/**
	 *  MGSetUMG 조회한다.<br>
	 * 
	 * @param MGSBareMVMTDataVO mGSBareMVMTDataVO
	 * @return String[]
	 * @exception EventException
	 */
	public String[] searchBareMGSetUMGData(MGSBareMVMTDataVO mGSBareMVMTDataVO) throws EventException;
	/**
	 *  save<br>
	 * 
	 * @param MGSBareMVMTDataVO[] mGSBareMVMTDataVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiMGSetDefaultData(MGSBareMVMTDataVO[] mGSBareMVMTDataVOs, SignOnUserAccount account) throws EventException;
	
}
