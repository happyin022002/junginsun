/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChassisMgsetInventoryBC.java
*@FileTitle : Factor Adjustment by Location
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.basic;

import java.util.List;

import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSEspFactorINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSEspFactorMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSEspReportINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSEspReportMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSHistoricalRptINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSHistoricalRptMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSInventoryByAgmtINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSInventoryByAgmtMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSInventoryByOnhireYearINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSInventoryByOnhireYearMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSInventoryByStaydaysINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSInventoryByStaydaysMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSInventoryByVariationDtlINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSInventoryByVariationDtlMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSInventoryByVariationINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSInventoryByVariationMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSInventoryDtlINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSInventoryDtlMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSInventoryGeneralINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSInventoryGeneralMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSLongStaydaysEnvINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSLongStaydaysEnvMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSUtilFactorINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSUtilFactorMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSUtilizationINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSUtilizationMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.MGSInventoryByLessorAgmtINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.MGSInventoryByLessorAgmtMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.MGSInventoryByLessorTermINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.MGSInventoryByLessorTermMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.MGSInventoryByLocationLessorINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.MGSInventoryByLocationLessorMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.MGSInventoryByOfficeINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.MGSInventoryByOfficeMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.MGSInventoryDtlINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.MGSInventoryDtlMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.MGSInventoryGeneralINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.MGSInventoryGeneralMGTVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-Chassismgsetmgt Business Logic Command Interface<br>
 * - OPUS-Chassismgsetmgt Business Logic Interface<br>
 *
 * @author 
 * @see Ees_cgm_1114EventResponse reference
 * @since J2EE 1.4
 */

public interface ChassisMgsetInventoryBC {

	/**
	 * Retrieve detail list counted on Chassis Inventory by Eq. Retrieve [EES_CGM_1091]<br>
	 * 
	 * @param chsInventoryDtlINVO CHSInventoryDtlINVO
	 * @return List<CHSInventoryDtlMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<CHSInventoryDtlMGTVO> searchCHSInventoryGeneralListBasic(CHSInventoryDtlINVO chsInventoryDtlINVO) throws EventException;
	
	/**
	 * Retrieve detail list counted on M.G.Set Inventory by Eq. Retrieve [EES_CGM_2084]<br>
	 * 
	 * @param mgsInventoryDtlINVO MGSInventoryDtlINVO
	 * @return List<MGSInventoryDtlMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<MGSInventoryDtlMGTVO> searchMGSInventoryGeneralListBasic(MGSInventoryDtlINVO mgsInventoryDtlINVO) throws EventException;
	
	/**
	 * Retrieve General Inventory.. Retrieve [EES_CGM_1089]<br>
	 * 
	 * @param chsInventoryGeneralINVO CHSInventoryGeneralINVO
	 * @return List<CHSInventoryGeneralMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<CHSInventoryGeneralMGTVO> searchCHSInventoryGeneralBasic(CHSInventoryGeneralINVO chsInventoryGeneralINVO) throws EventException;
	
	/**
	 * Inventory By staying days calculating.  [EES_CGM_1092]<br>
	 * 
	 * @param chsInventoryByStaydaysINVO CHSInventoryByStaydaysINVO   
	 * @return List<CHSInventoryByStaydaysMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */	
	public List<CHSInventoryByStaydaysMGTVO> searchCHSInventoryByStaydaysBasic(CHSInventoryByStaydaysINVO chsInventoryByStaydaysINVO) throws EventException;
	
	/**
	 *  (each User ID) Inventory By Long Staying Days page group date information retrieve.  [EES_CGM_1094]<br>
	 * 
	 * @param chsLongStaydaysEnvINVO CHSLongStaydaysEnvINVO 
	 * @param account SignOnUserAccount  
	 * @return List<CHSLongStaydaysEnvMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */		
	public List<CHSLongStaydaysEnvMGTVO> searchCHSLongstayEnvBasic(CHSLongStaydaysEnvINVO chsLongStaydaysEnvINVO, SignOnUserAccount account) throws EventException;

	
	/**
	 * (each User ID) Inventory By Long Staying Days group date setting.  [EES_CGM_1094]<br>
	 * 
	 * @param cHSLongStaydaysEnvINVOs CHSLongStaydaysEnvINVO[] 
	 * @param account SignOnUserAccount  
	 * @exception DAOException
	 * @exception Exception
	 */		
	public void manageCHSLongstayEnvBasic(CHSLongStaydaysEnvINVO[] cHSLongStaydaysEnvINVOs, SignOnUserAccount account) throws EventException;
	
	
	/**
	 * Inventory By Agreement calculating. [EES_CGM_1098]<br>
	 * 
	 * @param cHSInventoryByAgmtINVO CHSInventoryByAgmtINVO 
	 * @return List<CHSInventoryByAgmtMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */		
	public List<CHSInventoryByAgmtMGTVO> searchCHSInventoryByAgmtBasic(CHSInventoryByAgmtINVO cHSInventoryByAgmtINVO) throws EventException;	
	
	
	/**
	 * Inventory By On-hire year  calculating. [EES_CGM_1100]<br>
	 * 
	 * @param cHSInventoryByOnhireYearINVO CHSInventoryByOnhireYearINVO 
	 * @return List<CHSInventoryByOnhireYearMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */			
	public List<CHSInventoryByOnhireYearMGTVO> searchCHSInventoryByOnhireYearBasic (CHSInventoryByOnhireYearINVO cHSInventoryByOnhireYearINVO) throws EventException;	
	
	/**
	 * Inventory Variation calculating. [EES_CGM_1102]<br>
	 * 
	 * @param cHSInventoryByVariationINVO CHSInventoryByVariationINVO 
	 * @return List<CHSInventoryByVariationMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */		
	public List<CHSInventoryByVariationMGTVO> searchCHSInventoryByVariationBasic  (CHSInventoryByVariationINVO cHSInventoryByVariationINVO) throws EventException;
	
	/**
	 * Inventory Variation Detail List calculating. [EES_CGM_1103]<br>
	 * 
	 * @param cHSInventoryByVariationDtlINVO CHSInventoryByVariationDtlINVO 
	 * @return List<CHSInventoryByVariationDtlMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */		
	public List<CHSInventoryByVariationDtlMGTVO> searchCHSInventoryByVariationDtlListBasic (CHSInventoryByVariationDtlINVO cHSInventoryByVariationDtlINVO) throws EventException;
	
	
	/**
	 * Utilization Factor by Yard information retrieve(Yard retrieve)  [EES_CGM_1111]<br>
	 * 
	 * @param cHSUtilFactorINVO CHSUtilFactorINVO   
	 * @return List<CHSUtilFactorMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<CHSUtilFactorMGTVO> searchCHSUtilFactorBasic(CHSUtilFactorINVO cHSUtilFactorINVO) throws EventException;	

	/**
	 * Utilization Factor by Yard details information retrieve(Container status retrieve)  [EES_CGM_1111]<br>
	 * 
	 * @param cHSUtilFactorINVO CHSUtilFactorINVO 
	 * @return List<CHSUtilFactorMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<CHSUtilFactorMGTVO> searchCHSUtilFactorDtlBasic(CHSUtilFactorINVO cHSUtilFactorINVO) throws EventException;	
	
	
	/**
	 * Utilization Factor by Yard information saving(Yard/Status saving)  [EES_CGM_1111]<br>
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
	 * Chassis Utilization report information retrieve(Chassis Utilizationretrieve) [EES_CGM_1112] <br>
	 *  
	 * @param cHSUtilizationINVO CHSUtilizationINVO 
	 * @return CHSUtilizationMGTVO
	 * @exception DAOException
	 * @exception Exception
	 */	
	public CHSUtilizationMGTVO searchCHSUtilizationRptBasic (CHSUtilizationINVO cHSUtilizationINVO) throws EventException;

	
	/**
	 * retrieve Historical Report calculating by condition. [EES_CGM_1113] <br>
	 *  
	 * @param cHSHistoricalRptINVO CHSHistoricalRptINVO 
	 * @return List<CHSHistoricalRptMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */		
	public List<CHSHistoricalRptMGTVO> searchCHSHistoricalReportBasic (CHSHistoricalRptINVO cHSHistoricalRptINVO) throws EventException;
	
	/**
	 * ESP(Equipment Standard Pool)  Report calculating var retrieve. [EES_CGM_1114] <br>
	 *  
	 * @param cHSEspFactorINVO CHSEspFactorINVO 
	 * @return List<CHSEspFactorMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */	
	public List<CHSEspFactorMGTVO> searchCHSEspFactorBasic (CHSEspFactorINVO cHSEspFactorINVO) throws EventException;
	
	
	/**
	 * ESP(Equipment Standard Pool)  Report calculating var setting. [EES_CGM_1114] <br>
	 *  
	 * @param cHSEspFactorINVOs CHSEspFactorINVO[] 
	 * @exception DAOException
	 * @exception Exception
	 */	
	public void manageCHSEspFactorBasic (CHSEspFactorINVO[] cHSEspFactorINVOs) throws EventException;

	/**
   *  
	 * @param cHSEspReportINVO CHSEspReportINVO 
	 * @return String
	 * @exception Exception
	 */	
	public String searchCHSEspReportBasicBackEndJobStart  (CHSEspReportINVO cHSEspReportINVO) throws EventException;
	
	/**
   *  
	 * @param key String 
	 * @return List<CHSEspReportMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */	
	public List<CHSEspReportMGTVO> searchCHSEspReportBasic(String key) throws EventException;	
	//public List<CHSEspReportMGTVO> searchCHSEspReportBasic  (CHSEspReportINVO cHSEspReportINVO) throws EventException;
	
	/**
	 * inventory retrieve page General Inventory calculating.  [EES_CGM_2076]<br>
	 * 
	 * @param mGSInventoryGeneralINVO MGSInventoryGeneralINVO   
	 * @return List<MGSInventoryGeneralMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */	
	public List<MGSInventoryGeneralMGTVO> searchMGSInventoryGeneralBasic(MGSInventoryGeneralINVO mGSInventoryGeneralINVO) throws EventException;

	/**
	 * Inventory By Lessor and Agreement Type (UMG/CLG) Summary retrieve.  [EES_CGM_2077]<br>
	 * 
	 * @param mGSInventoryByLessorAgmtINVO MGSInventoryByLessorAgmtINVO   
	 * @return List<MGSInventoryByLessorAgmtMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */	
	public List<MGSInventoryByLessorAgmtMGTVO> searchMGSInventoryByLessorAgmtBasic (MGSInventoryByLessorAgmtINVO mGSInventoryByLessorAgmtINVO) throws EventException;

	/**
	 * Inventory By Lessor and Term(Lessor, Lease Term by Eq Inventory) Location by Term /by Eq TP/SZ count retrieve.  [EES_CGM_2078]<br>
	 * 
	 * @param mGSInventoryByLessorTermINVO MGSInventoryByLessorTermINVO   
	 * @return List<MGSInventoryByLessorTermMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */	
	public List<MGSInventoryByLessorTermMGTVO> searchMGSInventoryByLessorTermBasic  (MGSInventoryByLessorTermINVO mGSInventoryByLessorTermINVO) throws EventException;

	/**
	 * Inventory By Creation office On-hire (by Office , by term) Eq Inventory calculating.  [EES_CGM_2079]<br>
	 * 
	 * @param mGSInventoryByOfficeINVO MGSInventoryByOfficeINVO   
	 * @return List<MGSInventoryByOfficeMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */	
	public List<MGSInventoryByOfficeMGTVO> searchMGSInventoryByOfficeBasic (MGSInventoryByOfficeINVO mGSInventoryByOfficeINVO) throws EventException;

	/**
	 * Location& Lessor Inventory calculating.  [EES_CGM_2080]<br>
	 * 
	 * @param mGSInventoryByLocationLessorINVO MGSInventoryByLocationLessorINVO   
	 * @return List<MGSInventoryByLocationLessorMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */	
	public List<MGSInventoryByLocationLessorMGTVO> searchMGSInventoryByLocationLessorBasic (MGSInventoryByLocationLessorINVO mGSInventoryByLocationLessorINVO) throws EventException;
	
	
	/**
	 * Inventory Variation calculating start. Back End Job  [EES_CGM_1102] <br>
	 *  
	 * @param cHSInventoryByVariationINVO CHSInventoryByVariationINVO 
	 * @return String
	 * @exception Exception
	 */	
	public String searchCHSInventoryByVariationBasicBackEndJobStart  (CHSInventoryByVariationINVO cHSInventoryByVariationINVO) throws EventException;

	/**
	 * Inventory Variation calculating end. Back End Job  [EES_CGM_1102] <br>
	 *  
	 * @param key String 
	 * @return List<CHSInventoryByVariationMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */	
	public List<CHSInventoryByVariationMGTVO> searchCHSInventoryByVariationBasicFile  (String key) throws EventException;

	/**
	 * Inventory Variation calculating start. Back End Job  [EES_CGM_1103] <br>
	 *  
	 * @param cHSInventoryByVariationDtlINVO CHSInventoryByVariationDtlINVO 
	 * @return String
	 * @exception Exception
	 */	
	public String searchCHSInventoryByVariationDtlBasicBackEndJobStart  (CHSInventoryByVariationDtlINVO cHSInventoryByVariationDtlINVO) throws EventException;

	/**
	 * Inventory Variation calculating end. Back End Job  [EES_CGM_1103] <br>
	 *  
	 * @param key String 
	 * @return List<CHSInventoryByVariationMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */	
	public List<CHSInventoryByVariationDtlMGTVO> searchCHSInventoryByVariationDtlBasicFile  (String key) throws EventException;
}
