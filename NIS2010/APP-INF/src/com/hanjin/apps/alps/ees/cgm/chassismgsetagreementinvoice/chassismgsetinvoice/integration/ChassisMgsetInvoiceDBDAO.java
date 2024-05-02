/*=========================================================
*Copyright(c) 2009 CyberLogitec 
*@FileName : ChassisMgsetInvoiceDBDAO.java
*@FileTitle : Agreement Matching
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.31
*@LastModifier : Chang Young Kim
*@LastVersion : 1.01
* 2009.04.29 源?갹??
* 1.0 Creation
* -------------------------------------------------------
* Change History
* 2014.07.31 Modified by Chang Young Kim
* 2015-04-02 Chang Young Kim
*  [CHM-201431711] COPS Charge Creation - Charge Audit Result & Payable Amount Confirm
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.basic.ChassisMgsetInvoiceBCImpl;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSChargeCreationINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSChargeCreationMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSCoPoolChargeINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSCoPoolChargeMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSConfirmPayableAmountINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSConfirmPayableAmountMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSCpsAuditResultUpdateINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSCpsAuditResultUpdateMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSCpsInvoiceAuditResultCmmtCrMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSCpsPayableInvoiceCreationINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSCpsPayableInvoiceCreationMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSEstimateExpenseINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSEstimateExpenseMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSInvoiceImportAuditINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSInvoiceImportAuditMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSInvoiceInquiryINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSInvoiceInquiryMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSLessorAgmtMatchingINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSLessorAgmtMatchingMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSNuPoolChargeINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSNuPoolChargeMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSPayableInvoiceCreationINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSPayableInvoiceCreationMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSPoolSCCReportINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSPoolSCCReportMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSSCNOReportINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSSCNOReportMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSScExceptionINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSChargeCreationINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSChargeCreationMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSConfirmPayableAmountINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSConfirmPayableAmountMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSEstimateExpenseINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSEstimateExpenseMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSInvoiceImportAuditINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSInvoiceImportAuditMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSInvoiceInquiryINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSInvoiceInquiryMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSLessorAgmtMatchingINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSLessorAgmtMatchingMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSPayableInvoiceCreationINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSPayableInvoiceCreationMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.PoolEstmExpenseINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.PoolEstmExpenseMGTVO;
import com.hanjin.apps.alps.ees.eqr.cntrcommon.Utils;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.integration.DisposalMgtDBDAOsearchVerifyDisposalNoDataRSQL;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.vo.CustomMnrDispHdrVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.vo.DisposalNVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * ALPS ChassisMgsetInvoiceDBDAO <br>
 * - ALPS-ChassisMgsetAgreementInvoice system Business Logic??泥섎━?섍린 ?꾪븳 JDBC ?묒뾽?섑뻾.<br>
 * 
 * @author KIM CHANG SIK
 * @see ChassisMgsetInvoiceBCImpl 李몄“
 * @since J2EE 1.4  
 */
public class ChassisMgsetInvoiceDBDAO extends DBDAOSupport {

	/**
	 * Lessor ??match ?섎뒗 agreement ?뺣낫瑜?議고쉶?쒕떎.[EES_CGM_1028]<br>
	 * 
	 * @param chsLessorAgmtMatchingINVO CHSLessorAgmtMatchingINVO
	 * @return List<CHSLessorAgmtMatchingMGTVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CHSLessorAgmtMatchingMGTVO> searchCHSLessorAgmtMatchingData(CHSLessorAgmtMatchingINVO chsLessorAgmtMatchingINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CHSLessorAgmtMatchingMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(chsLessorAgmtMatchingINVO != null){
				Map<String, String> mapVO = chsLessorAgmtMatchingINVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInvoiceDBDAOSearchCHSLessorAgmtMatchingDataRSQL(), param, velParam);
			
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CHSLessorAgmtMatchingMGTVO.class);
				
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 
	/**
	 * 湲곗〈???깅줉??Reference No ??Agreement No 媛??덈뒗吏?泥댄겕?쒕떎. [EES_CGM_1028]<br>
	 * 
	 * @param chsLessorAgmtMatchingINVOs List<CHSLessorAgmtMatchingINVO>
	 * @return int
	 * @exception DAOException
	 */
	public int checkCHSLessorAgmtMatchingCountData(List<CHSLessorAgmtMatchingINVO> chsLessorAgmtMatchingINVOs) throws DAOException {
		DBRowSet dbRowset = null;
		int cnt = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
				
		try{
			for(int i=0; i < chsLessorAgmtMatchingINVOs.size(); i++){
				CHSLessorAgmtMatchingINVO chsLessorAgmtMatchingINVO = (CHSLessorAgmtMatchingINVO)chsLessorAgmtMatchingINVOs.get(i);
					
				if(chsLessorAgmtMatchingINVO != null){
					Map<String, String> mapVO = chsLessorAgmtMatchingINVO.getColumnValues();
					
					param.putAll(mapVO);
					velParam.putAll(mapVO);
						
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInvoiceDBDAOCheckCHSLessorAgmtMatchingCountDataRSQL(), param, velParam);
							
					if(dbRowset.next()){
						cnt = dbRowset.getInt("cnt");
					}
							
					if(cnt > 0)	break;
				}
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return cnt;
	}	 

	/**
	 * 湲곗〈???깅줉??Agreement No 媛??덈뒗吏?泥댄겕?쒕떎. [EES_CGM_1028]<br>
	 * 
	 * @param chsLessorAgmtMatchingINVO CHSLessorAgmtMatchingINVO
	 * @return CHSLessorAgmtMatchingMGTVO
	 * @exception DAOException
	 */
	public CHSLessorAgmtMatchingMGTVO checkCHSAgmtData(CHSLessorAgmtMatchingINVO chsLessorAgmtMatchingINVO) throws DAOException {
		DBRowSet dbRowset = null;
		CHSLessorAgmtMatchingMGTVO chsLessorAgmtMatchingMGTVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
			
		try{
			if(chsLessorAgmtMatchingINVO != null){
				Map<String, String> mapVO = chsLessorAgmtMatchingINVO.getColumnValues();
					
				param.putAll(mapVO);
				velParam.putAll(mapVO);
					
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInvoiceDBDAOCheckCHSAgmtDataRSQL(), param, velParam);
			
				if(dbRowset.next()){
					chsLessorAgmtMatchingMGTVO = new CHSLessorAgmtMatchingMGTVO();
					
					chsLessorAgmtMatchingMGTVO.setVndrSeq(dbRowset.getString("vndr_seq"));
					chsLessorAgmtMatchingMGTVO.setVndrLglEngNm(dbRowset.getString("vndr_lgl_eng_nm"));
				}	
			}
				
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return chsLessorAgmtMatchingMGTVO;
	}	 
	 
	/**
	 * CGM_INV_REF_NO_RGST ?뚯씠釉붿뿉 ?곗씠?곕? ?쇨큵?곸쑝濡??앹꽦?쒕떎. [EES_CGM_1028]<br>
	 * 
	 * @param chsLessorAgmtMatchingINVOs List<CHSLessorAgmtMatchingINVO>
	 * @exception DAOException
	 */
	public void addCHSLessorAgmtMatchingData(List<CHSLessorAgmtMatchingINVO> chsLessorAgmtMatchingINVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(chsLessorAgmtMatchingINVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ChassisMgsetInvoiceDBDAOAddCHSLessorAgmtMatchingDataCSQL(), chsLessorAgmtMatchingINVOs,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * CGM_INV_REF_NO_RGST ?뚯씠釉붿쓽 ?곗씠?곕? ?쇨큵?곸쑝濡?媛깆떊?쒕떎. [EES_CGM_1028]<br>
	 * 
	 * @param chsLessorAgmtMatchingINVOs List<CHSLessorAgmtMatchingINVO>
	 * @exception DAOException
	 */
	public void modifyCHSLessorAgmtMatchingData(List<CHSLessorAgmtMatchingINVO> chsLessorAgmtMatchingINVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(chsLessorAgmtMatchingINVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ChassisMgsetInvoiceDBDAOModifyCHSLessorAgmtMatchingDataUSQL(), chsLessorAgmtMatchingINVOs,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * CGM_INV_REF_NO_RGST ?뚯씠釉붿쓽 ?곗씠?곕? ?쇨큵?곸쑝濡???젣?쒕떎. [EES_CGM_1028].<br>
	 * 
	 * @param chsLessorAgmtMatchingINVOs List<CHSLessorAgmtMatchingINVO>
	 * @exception DAOException
	 */
	public void removeCHSLessorAgmtMatchingData(List<CHSLessorAgmtMatchingINVO> chsLessorAgmtMatchingINVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(chsLessorAgmtMatchingINVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new ChassisMgsetInvoiceDBDAORemoveCHSLessorAgmtMatchingDataDSQL(), chsLessorAgmtMatchingINVOs,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Lessor ??match ?섎뒗 agreement ?뺣낫瑜?議고쉶?쒕떎. [EES_CGM_2086]<br>
	 * 
	 * @param mgsLessorAgmtMatchingINVO MGSLessorAgmtMatchingINVO
	 * @return List<MGSLessorAgmtMatchingMGTVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<MGSLessorAgmtMatchingMGTVO> searchMGSLessorAgmtMatchingData(MGSLessorAgmtMatchingINVO mgsLessorAgmtMatchingINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MGSLessorAgmtMatchingMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(mgsLessorAgmtMatchingINVO != null){
				Map<String, String> mapVO = mgsLessorAgmtMatchingINVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInvoiceDBDAOSearchMGSLessorAgmtMatchingDataRSQL(), param, velParam);
			
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MGSLessorAgmtMatchingMGTVO.class);
				
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 
	/**
	 * 湲곗〈???깅줉??Reference No ??Agreement No 媛??덈뒗吏?泥댄겕?쒕떎. [EES_CGM_2086]<br>
	 * 
	 * @param mgsLessorAgmtMatchingINVOs List<MGSLessorAgmtMatchingINVO>
	 * @return int
	 * @exception DAOException
	 */
	public int checkMGSLessorAgmtMatchingCountData(List<MGSLessorAgmtMatchingINVO> mgsLessorAgmtMatchingINVOs) throws DAOException {
		DBRowSet dbRowset = null;
		int cnt = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
				
		try{
			for(int i=0; i < mgsLessorAgmtMatchingINVOs.size(); i++){
				MGSLessorAgmtMatchingINVO mgsLessorAgmtMatchingINVO = (MGSLessorAgmtMatchingINVO)mgsLessorAgmtMatchingINVOs.get(i);
					
				if(mgsLessorAgmtMatchingINVO != null){
					Map<String, String> mapVO = mgsLessorAgmtMatchingINVO.getColumnValues();
					
					param.putAll(mapVO);
					velParam.putAll(mapVO);
						
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInvoiceDBDAOCheckMGSLessorAgmtMatchingCountDataRSQL(), param, velParam);
							
					if(dbRowset.next()){
						cnt = dbRowset.getInt("cnt");
					}
							
					if(cnt > 0)	break;
				}
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return cnt;
	}	 

	/**
	 * 湲곗〈???깅줉??Agreement No 媛??덈뒗吏?泥댄겕?쒕떎. [EES_CGM_2086]<br>
	 * 
	 * @param mgsLessorAgmtMatchingINVO MGSLessorAgmtMatchingINVO
	 * @return MGSLessorAgmtMatchingMGTVO
	 * @exception DAOException
	 */
	public MGSLessorAgmtMatchingMGTVO checkMGSAgmtData(MGSLessorAgmtMatchingINVO mgsLessorAgmtMatchingINVO) throws DAOException {
		DBRowSet dbRowset = null;
		MGSLessorAgmtMatchingMGTVO mgsLessorAgmtMatchingMGTVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
			
		try{
			if(mgsLessorAgmtMatchingINVO != null){
				Map<String, String> mapVO = mgsLessorAgmtMatchingINVO.getColumnValues();
					
				param.putAll(mapVO);
				velParam.putAll(mapVO);
					
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInvoiceDBDAOCheckCHSAgmtDataRSQL(), param, velParam);
			
				if(dbRowset.next()){
					mgsLessorAgmtMatchingMGTVO = new MGSLessorAgmtMatchingMGTVO();
					
					mgsLessorAgmtMatchingMGTVO.setVndrSeq(dbRowset.getString("vndr_seq"));
					mgsLessorAgmtMatchingMGTVO.setVndrLglEngNm(dbRowset.getString("vndr_lgl_eng_nm"));
				}	
			}
				
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return mgsLessorAgmtMatchingMGTVO;
	}	 
	 
	/**
	 * CGM_INV_REF_NO_RGST ?뚯씠釉붿뿉 ?곗씠?곕? ?쇨큵?곸쑝濡??앹꽦?쒕떎. [EES_CGM_2086]<br>
	 * 
	 * @param mgsLessorAgmtMatchingINVOs List<MGSLessorAgmtMatchingINVO>
	 * @exception DAOException
	 */
	public void addMGSLessorAgmtMatchingData(List<MGSLessorAgmtMatchingINVO> mgsLessorAgmtMatchingINVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(mgsLessorAgmtMatchingINVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ChassisMgsetInvoiceDBDAOAddMGSLessorAgmtMatchingDataCSQL(), mgsLessorAgmtMatchingINVOs,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * CGM_INV_REF_NO_RGST ?뚯씠釉붿쓽 ?곗씠?곕? ?쇨큵?곸쑝濡?媛깆떊?쒕떎. [EES_CGM_2086]<br>
	 * 
	 * @param mgsLessorAgmtMatchingINVOs List<MGSLessorAgmtMatchingINVO>
	 * @exception DAOException
	 */
	public void modifyMGSLessorAgmtMatchingData(List<MGSLessorAgmtMatchingINVO> mgsLessorAgmtMatchingINVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(mgsLessorAgmtMatchingINVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ChassisMgsetInvoiceDBDAOModifyMGSLessorAgmtMatchingDataUSQL(), mgsLessorAgmtMatchingINVOs,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * CGM_INV_REF_NO_RGST ?뚯씠釉붿쓽 ?곗씠?곕? ?쇨큵?곸쑝濡???젣?쒕떎. [EES_CGM_2086].<br>
	 * 
	 * @param mgsLessorAgmtMatchingINVOs List<MGSLessorAgmtMatchingINVO>
	 * @exception DAOException
	 */
	public void removeMGSLessorAgmtMatchingData(List<MGSLessorAgmtMatchingINVO> mgsLessorAgmtMatchingINVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(mgsLessorAgmtMatchingINVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new ChassisMgsetInvoiceDBDAORemoveMGSLessorAgmtMatchingDataDSQL(), mgsLessorAgmtMatchingINVOs,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * CGM_PAY_INV ?뚯씠釉붿뿉??Cost Month ???대떦?섎뒗 INV_NO ???곹깭媛믪쓣 媛?졇?⑤떎. [EES_CGM_1123]<br>
	 * 
	 * @param chsCoPoolChargeINVO CHSCoPoolChargeINVO
	 * @return List<CHSCoPoolChargeMGTVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CHSCoPoolChargeMGTVO> searchCHSCoPoolChargeListData(CHSCoPoolChargeINVO chsCoPoolChargeINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CHSCoPoolChargeMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(chsCoPoolChargeINVO != null){
				Map<String, String> mapVO = chsCoPoolChargeINVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInvoiceDBDAOSearchCHSCoPoolChargeListDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CHSCoPoolChargeMGTVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 
	/**
	 * Co-Pool Charge ??珥덇린媛믪쓣 遺덈윭?⑤떎. [EES_CGM_1123]<br>
	 * 
	 * @param chsCoPoolChargeINVO CHSCoPoolChargeINVO
	 * @return List<CHSCoPoolChargeMGTVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CHSCoPoolChargeMGTVO> searchCHSCoPoolChargeInitData(CHSCoPoolChargeINVO chsCoPoolChargeINVO) throws DAOException {
		DBRowSet dbRowset = null; 
		List<CHSCoPoolChargeMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(chsCoPoolChargeINVO != null){
				Map<String, String> mapVO = chsCoPoolChargeINVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInvoiceDBDAOSearchCHSCoPoolChargeInitDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CHSCoPoolChargeMGTVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 
	/**
	 * Co-Pool Charge 紐⑸줉??遺덈윭?⑤떎. [EES_CGM_1123]<br>
	 * 
	 * @param chsCoPoolChargeINVO CHSCoPoolChargeINVO
	 * @return List<CHSCoPoolChargeMGTVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CHSCoPoolChargeMGTVO> searchCHSCoPoolChargeDtlData(CHSCoPoolChargeINVO chsCoPoolChargeINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CHSCoPoolChargeMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(chsCoPoolChargeINVO != null){
				Map<String, String> mapVO = chsCoPoolChargeINVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInvoiceDBDAOSearchCHSCoPoolChargeDtlDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CHSCoPoolChargeMGTVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	
	 
	 /**
	 * CGM_PAY_INV ?뚯씠釉붿뿉 payInvSeq 瑜?媛?졇?⑤떎. [EES_CGM_1123]<br>
	 * 
	 * @param chsCoPoolChargeINVO CHSCoPoolChargeINVO
	 * @return long
	 * @exception DAOException
	 */
	public long searchCHSCoPoolChargePayInvSeqData(CHSCoPoolChargeINVO chsCoPoolChargeINVO) throws DAOException,Exception {
		
		DBRowSet dbRowset = null;
		long payInvSeq = 0;
		
		try {
			
			if(chsCoPoolChargeINVO != null){
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInvoiceDBDAOSearchCHSCoPoolChargePayInvSeqDataRSQL(), null, null);
				
				if(dbRowset.next()){
					payInvSeq = dbRowset.getInt("pay_inv_seq");
					chsCoPoolChargeINVO.setPayInvSeq(String.valueOf(payInvSeq));
				}
 
				
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return payInvSeq;
	}
		
    /**
	 * CGM_PAY_INV ?뚯씠釉붿뿉 ?곗씠?곕? ?쇨큵?곸쑝濡??앹꽦?쒕떎. [EES_CGM_1123]<br>
	 * 
	 * @param chsCoPoolChargeINVO CHSCoPoolChargeINVO
	 * @exception DAOException
	 */
	public void addCHSCoPoolChargeMainData(CHSCoPoolChargeINVO chsCoPoolChargeINVO) throws DAOException,Exception {
		
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(chsCoPoolChargeINVO != null){
				//query parameter
		        Map<String, String> param = chsCoPoolChargeINVO.getColumnValues();
		        //?좉퇋 ?낅젰
		        int result = sqlExe.executeUpdate((ISQLTemplate) new ChassisMgsetInvoiceDBDAOAddCHSCoPoolChargeMainDataCSQL() , param, null);
				
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
				
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * CGM_PAY_INV_POOL_DTL ?뚯씠釉붿뿉 ?곗씠?곕? ?쇨큵?곸쑝濡??앹꽦?쒕떎. [EES_CGM_1123]<br>
	 * 
	 * @param chsCoPoolChargeINVOs List<CHSCoPoolChargeINVO>
	 * @exception DAOException
	 */
	public void addCHSCoPoolChargeDtlData(List<CHSCoPoolChargeINVO> chsCoPoolChargeINVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(chsCoPoolChargeINVOs != null)
				if(chsCoPoolChargeINVOs.size() > 0){
					insCnt = sqlExe.executeBatch((ISQLTemplate)new ChassisMgsetInvoiceDBDAOAddCHSCoPoolChargeDtlDataCSQL(), chsCoPoolChargeINVOs,null);
					for(int i = 0; i < insCnt.length; i++){
						if(insCnt[i]== Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to insert No"+ i + " SQL");
					}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * CGM_PAY_INV ?뚯씠釉붿뿉 ?곗씠?곕? ?쇨큵?곸쑝濡??섏젙?쒕떎. [EES_CGM_1123]<br>
	 * 
	 * @param chsCoPoolChargeINVO CHSCoPoolChargeINVO
	 * @exception DAOException
	 */
	public void modifyCHSCoPoolChargeMainData(CHSCoPoolChargeINVO chsCoPoolChargeINVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(chsCoPoolChargeINVO != null){
				//query parameter
		        Map<String, String> param = chsCoPoolChargeINVO.getColumnValues();
		        //??젣 
		        int result = sqlExe.executeUpdate((ISQLTemplate) new ChassisMgsetInvoiceDBDAOModifyCHSCoPoolChargeMainDataUSQL() , param, null);
				
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
				
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * CGM_PAY_INV_POOL_DTL ???곗씠?곕? ?쇨큵?곸쑝濡??섏젙?쒕떎. [EES_CGM_1123]<br>
	 * 
	 * @param chsCoPoolChargeINVOs List<CHSCoPoolChargeINVO>
	 * @exception DAOException
	 */
	public void modifyCHSCoPoolChargeDtlData(List<CHSCoPoolChargeINVO> chsCoPoolChargeINVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(chsCoPoolChargeINVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ChassisMgsetInvoiceDBDAOModifyCHSCoPoolChargeDtlDataUSQL(), chsCoPoolChargeINVOs,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * CGM_PAY_INV ?뚯씠釉붿쓽 ?곗씠?곕? ??젣?쒕떎.<br>
	 * 
	 * @param chsCoPoolChargeINVO CHSCoPoolChargeINVO
	 * @exception DAOException
	 */
	public void removeCHSCoPoolChargeMainData(CHSCoPoolChargeINVO chsCoPoolChargeINVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(chsCoPoolChargeINVO != null){
				//query parameter
		        Map<String, String> param = chsCoPoolChargeINVO.getColumnValues();
		        //??젣 
		        int result = sqlExe.executeUpdate((ISQLTemplate) new ChassisMgsetInvoiceDBDAORemoveCHSCoPoolChargeMainDataDSQL() , param, null);
				
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
				
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * CGM_PAY_INV_POOL_DTL ?뚯씠釉붿쓽 ?곗씠?곕? ?쇨큵?곸쑝濡???젣?쒕떎.<br>
	 * 
	 * @param chsCoPoolChargeINVO CHSCoPoolChargeINVO
	 * @exception DAOException
	 */
	public void removeCHSCoPoolChargeDtlData(CHSCoPoolChargeINVO chsCoPoolChargeINVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(chsCoPoolChargeINVO != null){
				//query parameter
		        Map<String, String> param = chsCoPoolChargeINVO.getColumnValues();
		        //??젣 
		        int result = sqlExe.executeUpdate((ISQLTemplate) new ChassisMgsetInvoiceDBDAORemoveCHSCoPoolChargeDtlDataDSQL() , param, null);
				
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
				
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Co-Pool Charge Main ?뺣낫瑜?遺덈윭?⑤떎. [EES_CGM_1123]<br>
	 * 
	 * @param chsCoPoolChargeINVO CHSCoPoolChargeINVO
	 * @return CHSCoPoolChargeMGTVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public CHSCoPoolChargeMGTVO searchCHSCoPoolChargeMainData(CHSCoPoolChargeINVO chsCoPoolChargeINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CHSCoPoolChargeMGTVO> list = null;
		CHSCoPoolChargeMGTVO chsCoPoolChargeMGTVO = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(chsCoPoolChargeINVO != null){
				Map<String, String> mapVO = chsCoPoolChargeINVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInvoiceDBDAOSearchCHSCoPoolChargeMainDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CHSCoPoolChargeMGTVO.class);
			
			if(list.size() > 0){
				chsCoPoolChargeMGTVO = new CHSCoPoolChargeMGTVO();
				chsCoPoolChargeMGTVO = list.get(0);
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return chsCoPoolChargeMGTVO;
	}
	 
	/**
	 * Chassis Charge Creation ??긽 紐⑸줉??遺덈윭?⑤떎. [EES_CGM_1029]<br>
	 * 
	 * @param chsChargeCreationINVO CHSChargeCreationINVO
	 * @return List<CHSChargeCreationMGTVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CHSChargeCreationMGTVO> searchCHSChargeCreationListData(CHSChargeCreationINVO chsChargeCreationINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CHSChargeCreationMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(chsChargeCreationINVO != null){
				Map<String, String> mapVO = chsChargeCreationINVO.getColumnValues();
							
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInvoiceDBDAOSearchCHSChargeCreationListDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CHSChargeCreationMGTVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
				 
	/**
	 * Chassis Charge Creation 寃곌낵瑜?遺덈윭?⑤떎. [EES_CGM_1029]<br>
	 * 
	 * @param chsChargeCreationINVO CHSChargeCreationINVO
	 * @return List<CHSChargeCreationMGTVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CHSChargeCreationMGTVO> searchCHSChargeCreationResultData(CHSChargeCreationINVO chsChargeCreationINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CHSChargeCreationMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(chsChargeCreationINVO != null){
				Map<String, String> mapVO = chsChargeCreationINVO.getColumnValues();
									
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInvoiceDBDAOSearchCHSChargeCreationResultDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CHSChargeCreationMGTVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	 
				 
	/**
	 * Charge Creation PDM ?곗씠?곕? ?쇨큵?곸쑝濡??앹꽦?쒕떎. [EES_CGM_1029]<br>
	 * 
	 * @param chsChargeCreationINVOs List<CHSChargeCreationINVO>
	 * @exception DAOException
	 */
	public void addCHSChargeCreatePDMData(List<CHSChargeCreationINVO> chsChargeCreationINVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(chsChargeCreationINVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ChassisMgsetInvoiceDBDAOAddCHSChargeCreatePDMDataCSQL(), chsChargeCreationINVOs,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
				
	/**
	 * Charge Creation HON ?곗씠?곕? ?쇨큵?곸쑝濡??앹꽦?쒕떎. [EES_CGM_1029]<br>
	 * 
	 * @param chsChargeCreationINVOs List<CHSChargeCreationINVO>
	 * @exception DAOException
	 */
	public void addCHSChargeCreateHONData(List<CHSChargeCreationINVO> chsChargeCreationINVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(chsChargeCreationINVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ChassisMgsetInvoiceDBDAOAddCHSChargeCreateHONDataCSQL(), chsChargeCreationINVOs,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
				
	/**
	 * Charge Creation HOF ?곗씠?곕? ?쇨큵?곸쑝濡??앹꽦?쒕떎. [EES_CGM_1029]<br>
	 * 
	 * @param chsChargeCreationINVOs List<CHSChargeCreationINVO>
	 * @exception DAOException
	 */
	public void addCHSChargeCreateHOFData(List<CHSChargeCreationINVO> chsChargeCreationINVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(chsChargeCreationINVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ChassisMgsetInvoiceDBDAOAddCHSChargeCreateHOFDataCSQL(), chsChargeCreationINVOs,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
				
	/**
	 * Charge Creation Header ?곗씠?곕? ?쇨큵?곸쑝濡??앹꽦?쒕떎. [EES_CGM_1029]<br>
	 * 
	 * @param chsChargeCreationINVOs List<CHSChargeCreationINVO>
	 * @exception DAOException
	 */
	public void addCHSChageCreateSummaryData(List<CHSChargeCreationINVO> chsChargeCreationINVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(chsChargeCreationINVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ChassisMgsetInvoiceDBDAOAddCHSChargeCreateSummaryDataCSQL(), chsChargeCreationINVOs,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
				
	/**
	 * Charge Creation Header ?곗씠?곗쓽 珥앺빀???쇨큵?곸쑝濡?Update ?쒕떎.. [EES_CGM_1029]<br>
	 * 
	 * @param chsChargeCreationINVOs List<CHSChargeCreationINVO>
	 * @exception DAOException
	 */
	public void modifyCHSChargeCreateChgSummaryData(List<CHSChargeCreationINVO> chsChargeCreationINVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(chsChargeCreationINVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ChassisMgsetInvoiceDBDAOmodifyCHSChargeCreateChgSummaryDataUSQL(), chsChargeCreationINVOs,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Charge Creation Detail ?곗씠?곕? ?쇨큵?곸쑝濡???젣?쒕떎. [EES_CGM_1029]<br>
	 * 
	 * @param chsChargeCreationINVO CHSChargeCreationINVO
	 * @exception DAOException
	 */
	public void removeCHSChargeDetailData(CHSChargeCreationINVO chsChargeCreationINVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(chsChargeCreationINVO != null){
				//query parameter
		        Map<String, String> param = chsChargeCreationINVO.getColumnValues();
		        //??젣 
		        int result = sqlExe.executeUpdate((ISQLTemplate) new ChassisMgsetInvoiceDBDAORemoveCHSChargeDetailDataDSQL() , param, null);
				
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
				
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Charge Creation Header ?곗씠?곕? ??젣?쒕떎. [EES_CGM_1029]<br>
	 * 
	 * @param chsChargeCreationINVO CHSChargeCreationINVO
	 * @exception DAOException
	 */
	public void removeCHSChargeSummaryData(CHSChargeCreationINVO chsChargeCreationINVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(chsChargeCreationINVO != null){
				//query parameter
		        Map<String, String> param = chsChargeCreationINVO.getColumnValues();
		        //??젣 
		        int result = sqlExe.executeUpdate((ISQLTemplate) new ChassisMgsetInvoiceDBDAORemoveCHSChargeSummaryDataDSQL() , param, null);
				
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
				
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * CGM_PAY_INV???곗씠?곕? ??젣?쒕떎. [EES_CGM_1029]<br>
	 * 
	 * @param chsChargeCreationINVO CHSChargeCreationINVO
	 * @exception DAOException
	 */
	public void removeCHSChargeInvoiceData(CHSChargeCreationINVO chsChargeCreationINVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(chsChargeCreationINVO != null){
				//query parameter
		        Map<String, String> param = chsChargeCreationINVO.getColumnValues();
		        //??젣 
		        int result = sqlExe.executeUpdate((ISQLTemplate) new ChassisMgsetInvoiceDBDAORemoveCHSChargeInvoiceDataDSQL() , param, null);
				
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
				
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
						
	/**
	 * Charge Creation Sequence 瑜?媛?졇?⑤떎. [EES_CGM_1029]<br>
	 * 
	 * @return long
	 * @exception DAOException
	 */
	public long searchCHSChargeCreateSeqData() throws DAOException {
		DBRowSet dbRowset = null;
		long seq = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
				
		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInvoiceDBDAOSearchCHSChargeCreateSeqRSQL(), param, velParam);
								
			if(dbRowset.next()){
				seq = dbRowset.getLong("chg_cre_seq");
			}
								
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return seq;
	}	 
	 
	/**
	 * M.G.Set Charge Creation ??긽 紐⑸줉??遺덈윭?⑤떎. [EES_CGM_2032]<br>
	 * 
	 * @param mgsChargeCreationINVO MGSChargeCreationINVO
	 * @return List<MGSChargeCreationMGTVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<MGSChargeCreationMGTVO> searchMGSChargeCreationListData(MGSChargeCreationINVO mgsChargeCreationINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MGSChargeCreationMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(mgsChargeCreationINVO != null){
				Map<String, String> mapVO = mgsChargeCreationINVO.getColumnValues();
					
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInvoiceDBDAOSearchMGSChargeCreationListDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MGSChargeCreationMGTVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 
	/**
	 * M.G.Set Charge Creation 寃곌낵瑜?遺덈윭?⑤떎. [EES_CGM_2032]<br>
	 * 
	 * @param mgsChargeCreationINVO MGSChargeCreationINVO
	 * @return List<MGSChargeCreationMGTVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<MGSChargeCreationMGTVO> searchMGSChargeCreationResultData(MGSChargeCreationINVO mgsChargeCreationINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MGSChargeCreationMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(mgsChargeCreationINVO != null){
				Map<String, String> mapVO = mgsChargeCreationINVO.getColumnValues();
						
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInvoiceDBDAOSearchMGSChargeCreationResultDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MGSChargeCreationMGTVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	 
	 
	/**
	 * Charge Creation PDM ?곗씠?곕? ?쇨큵?곸쑝濡??앹꽦?쒕떎. [EES_CGM_2032]<br>
	 * 
	 * @param mgsChargeCreationINVOs List<MGSChargeCreationINVO>
	 * @exception DAOException
	 */
	public void addMGSChargeCreatePDMData(List<MGSChargeCreationINVO> mgsChargeCreationINVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(mgsChargeCreationINVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ChassisMgsetInvoiceDBDAOAddMGSChargeCreatePDMDataCSQL(), mgsChargeCreationINVOs,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Charge Creation HON ?곗씠?곕? ?쇨큵?곸쑝濡??앹꽦?쒕떎. [EES_CGM_2032]<br>
	 * 
	 * @param mgsChargeCreationINVOs List<MGSChargeCreationINVO>
	 * @exception DAOException
	 */
	public void addMGSChargeCreateHONData(List<MGSChargeCreationINVO> mgsChargeCreationINVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(mgsChargeCreationINVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ChassisMgsetInvoiceDBDAOAddMGSChargeCreateHONDataCSQL(), mgsChargeCreationINVOs,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Charge Creation HOF ?곗씠?곕? ?쇨큵?곸쑝濡??앹꽦?쒕떎. [EES_CGM_2032]<br>
	 * 
	 * @param mgsChargeCreationINVOs List<MGSChargeCreationINVO>
	 * @exception DAOException
	 */
	public void addMGSChargeCreateHOFData(List<MGSChargeCreationINVO> mgsChargeCreationINVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(mgsChargeCreationINVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ChassisMgsetInvoiceDBDAOAddMGSChargeCreateHOFDataCSQL(), mgsChargeCreationINVOs,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Charge Creation Header ?곗씠?곕? ?쇨큵?곸쑝濡??앹꽦?쒕떎. [EES_CGM_2032]<br>
	 * 
	 * @param mgsChargeCreationINVOs List<MGSChargeCreationINVO>
	 * @exception DAOException
	 */
	public void addMGSChageCreateSummaryData(List<MGSChargeCreationINVO> mgsChargeCreationINVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(mgsChargeCreationINVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ChassisMgsetInvoiceDBDAOAddMGSChargeCreateSummaryDataCSQL(), mgsChargeCreationINVOs,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
		
	/**
	 * Charge Creation Header ?곗씠???⑷퀎瑜??쇨큵?곸쑝濡?update ?쒕떎. [EES_CGM_2032]<br>
	 * 
	 * @param mgsChargeCreationINVOs List<MGSChargeCreationINVO>
	 * @exception DAOException
	 */
	public void modifyMGSChargeCreateChgSummaryData(List<MGSChargeCreationINVO> mgsChargeCreationINVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(mgsChargeCreationINVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ChassisMgsetInvoiceDBDAOmodifyMGSChargeCreateChgSummaryDataUSQL(), mgsChargeCreationINVOs,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * CGM_LSE_CHG_DTL ?곗씠?곕? ??젣?쒕떎. [EES_CGM_2032]<br>
	 * 
	 * @param mgsChargeCreationINVO MGSChargeCreationINVO
	 * @exception DAOException
	 */
	public void removeMGSChargeDetailData(MGSChargeCreationINVO mgsChargeCreationINVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(mgsChargeCreationINVO != null){
				//query parameter
		        Map<String, String> param = mgsChargeCreationINVO.getColumnValues();
		        //??젣 
		        int result = sqlExe.executeUpdate((ISQLTemplate) new ChassisMgsetInvoiceDBDAORemoveMGSChargeDetailDataDSQL() , param, null);
				
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
				
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * CGM_LSE_CHG_HDR ?곗씠?곕? ??젣?쒕떎. [EES_CGM_2032]<br>
	 * 
	 * @param mgsChargeCreationINVO MGSChargeCreationINVO
	 * @exception DAOException
	 */
	public void removeMGSChargeSummaryData(MGSChargeCreationINVO mgsChargeCreationINVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(mgsChargeCreationINVO != null){
				//query parameter
		        Map<String, String> param = mgsChargeCreationINVO.getColumnValues();
		        //??젣 
		        int result = sqlExe.executeUpdate((ISQLTemplate) new ChassisMgsetInvoiceDBDAORemoveMGSChargeSummaryDataDSQL() , param, null);
				
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
				
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * CGM_PAY_INV ?곗씠?곕? ??젣?쒕떎. [EES_CGM_2032]<br>
	 * 
	 * @param mgsChargeCreationINVO MGSChargeCreationINVO
	 * @exception DAOException
	 */
	public void removeMGSChargeInvoiceData(MGSChargeCreationINVO mgsChargeCreationINVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(mgsChargeCreationINVO != null){
				//query parameter
		        Map<String, String> param = mgsChargeCreationINVO.getColumnValues();
		        //??젣 
		        int result = sqlExe.executeUpdate((ISQLTemplate) new ChassisMgsetInvoiceDBDAORemoveMGSChargeInvoiceDataDSQL() , param, null);
				
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
				
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Charge Creation Sequence 瑜?媛?졇?⑤떎. [EES_CGM_2032]<br>
	 * 
	 * @return long
	 * @exception DAOException
	 */
	public long searchMGSChargeCreateSeqData() throws DAOException {
		DBRowSet dbRowset = null;
		long seq = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
				
		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInvoiceDBDAOSearchMGSChargeCreateSeqRSQL(), param, velParam);
							
			if(dbRowset.next()){
				seq = dbRowset.getLong("chg_cre_seq");
			}
							
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return seq;
	}

	/**
	 *  ???붾퀎 媛??대떦 Estimate, Actual Amount 瑜?議고쉶?쒕떎 [EES_CGM_1125].<br>
	 * 
	 * @param poolEstmExpenseINVO PoolEstmExpenseINVO 
	 * @return List<PoolEstmExpenseMGTVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<PoolEstmExpenseMGTVO> searchPoolEstimateAmtData(PoolEstmExpenseINVO poolEstmExpenseINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PoolEstmExpenseMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(poolEstmExpenseINVO != null){
				Map<String, String> mapVO = poolEstmExpenseINVO.getColumnValues();
					
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInvoiceDBDAOSearchPoolEstimateAmtDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PoolEstmExpenseMGTVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	
	/**
	 * CGM_CHSS_POOL_EXPN_ESTM의 데이터 유무 체크 [EES_CGM_1225].<br>
	 * 
	 * @param poolEstmExpenseMGTVO PoolEstmExpenseMGTVO
	 * @return int cnt
	 * @exception DAOException
	 */
	public int checkPoolEstimateAmtData(PoolEstmExpenseMGTVO poolEstmExpenseMGTVO) throws DAOException, Exception {
		DBRowSet dbRowset = null;
		int cnt = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(poolEstmExpenseMGTVO != null){
				Map<String, String> mapVO = poolEstmExpenseMGTVO.getColumnValues();
					
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInvoiceDBDAOCheckCntZPPoolEstimateAmtDataRSQL(), param, velParam);
			
			if(dbRowset.next()){
				cnt = dbRowset.getInt("cnt");
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return cnt;
	}
	
	/**
	 * CGM_CHSS_POOL_EXPN_ESTM Entity에 Insert [EES_CGM_1125][EES_CGM_1225].<br>
	 * 
	 * @param poolEstmExpenseMGTVOs List<PoolEstmExpenseMGTVO> 
	 * @exception DAOException
	 */
	public void addPoolEstimateAmtData(List<PoolEstmExpenseMGTVO> poolEstmExpenseMGTVOs) throws DAOException, Exception {
		@SuppressWarnings("unused")
		boolean rtn = false;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		PoolEstmExpenseMGTVO chass = new PoolEstmExpenseMGTVO();
		int result=0;
		//query parameter
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (poolEstmExpenseMGTVOs.size() > 0) {
				for (int i = 0; i < poolEstmExpenseMGTVOs.size(); i++) {
					chass = new PoolEstmExpenseMGTVO();
					chass = poolEstmExpenseMGTVOs.get(i);
					 
					Map<String, String> mapVO = chass.getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);		
					result = sqlExe.executeUpdate((ISQLTemplate)new ChassisMgsetInvoiceDBDAOAddPoolEstimateAmtDataCSQL(), param, velParam);
					if(result == Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to insert SQL");
					
				}
				rtn = true;	// ?곗씠?곌? 議댁옱?? (?ъ슜)
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	  
	/**
	 * CGM_CHSS_POOL_EXPN_ESTM ?뷀떚?곗뿉 ?낅젰 ??옣.. .[EES_CGM_1125].<br>
	 * 
	 * @param poolEstmExpenseMGTVOs List<PoolEstmExpenseMGTVO> 
	 * @exception DAOException
	 */
	public void modifyPoolEstimateAmtData(List<PoolEstmExpenseMGTVO> poolEstmExpenseMGTVOs) throws DAOException, Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		PoolEstmExpenseMGTVO chass = new PoolEstmExpenseMGTVO();
		int result=0;
		//query parameter
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (poolEstmExpenseMGTVOs.size() > 0) {
				for (int i = 0; i < poolEstmExpenseMGTVOs.size(); i++) {
					chass = new PoolEstmExpenseMGTVO();
					chass = poolEstmExpenseMGTVOs.get(i);
						 
					Map<String, String> mapVO = chass.getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);		
					result = sqlExe.executeUpdate((ISQLTemplate)new ChassisMgsetInvoiceDBDAOModifyPoolEstimateAmtDataUSQL(), param, velParam);
					if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
					
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
		  
		  
	/**
	 *  ?낅젰???꾨룄, Pool TYPE ???대떦?섎뒗 Pool List 蹂? ?붾퀎 Estimate amount 瑜?議고쉶?섏??? Retrieve . [EES_CGM_1126].<br>
	 * 
	 * @param poolEstmExpenseINVO PoolEstmExpenseINVO 
	 * @return List<PoolEstmExpenseMGTVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<PoolEstmExpenseMGTVO> searchPoolEstimateReportData(PoolEstmExpenseINVO poolEstmExpenseINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PoolEstmExpenseMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(poolEstmExpenseINVO != null){
				Map<String, String> mapVO = poolEstmExpenseINVO.getColumnValues();
						
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInvoiceDBDAOSearchPoolEstimateReportDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PoolEstmExpenseMGTVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 
	/**
	 * Chassis No 議댁옱 ?좊Т Check ?쒕떎. [EES_CGM_1030]<br>
	 * 
	 * @param chsInvoiceImportAuditINVO CHSInvoiceImportAuditINVO
	 * @return int
	 * @exception DAOException
	 */
	public int checkCHSInvImportEqNoData(CHSInvoiceImportAuditINVO chsInvoiceImportAuditINVO) throws DAOException {
		DBRowSet dbRowset = null;
		int cnt = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
					
		try{
				if(chsInvoiceImportAuditINVO != null){
					Map<String, String> mapVO = chsInvoiceImportAuditINVO.getColumnValues();
						
					param.putAll(mapVO);
					velParam.putAll(mapVO);
							
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInvoiceDBDAOCheckCHSInvImportEqNoDataRSQL(), param, velParam);
							
					if(dbRowset.next()){
						cnt = dbRowset.getInt("cnt");
					}
				}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return cnt;
	}
	
	/**
	 * Lessor Chassis No 議댁옱 ?좊Т Check ?쒕떎. [EES_CGM_1030]<br>
	 * 
	 * @param chsInvoiceImportAuditINVO CHSInvoiceImportAuditINVO
	 * @return String
	 * @exception DAOException
	 */
	public String checkCHSInvImportLessorEqNoData(CHSInvoiceImportAuditINVO chsInvoiceImportAuditINVO) throws DAOException {
		DBRowSet dbRowset = null;
		String invEqNo = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
					
		try{
				if(chsInvoiceImportAuditINVO != null){
					Map<String, String> mapVO = chsInvoiceImportAuditINVO.getColumnValues();
						
					param.putAll(mapVO);
					velParam.putAll(mapVO);
							
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInvoiceDBDAOCheckCHSInvImportLessorEqNoDataRSQL(), param, velParam);
							
					if(dbRowset.next()){
						invEqNo = dbRowset.getString("inv_eq_no");
					}
				}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return invEqNo;
	}
	
	/**
	 * Reference No 議댁옱 ?좊Т Check ?쒕떎. [EES_CGM_1030]<br>
	 * 
	 * @param chsInvoiceImportAuditINVO CHSInvoiceImportAuditINVO
	 * @return CHSInvoiceImportAuditMGTVO
	 * @exception DAOException
	 */
	public CHSInvoiceImportAuditMGTVO checkCHSInvImportRefNoData(CHSInvoiceImportAuditINVO chsInvoiceImportAuditINVO) throws DAOException {
		DBRowSet dbRowset = null;
		CHSInvoiceImportAuditMGTVO chsInvoiceImportAuditMGTVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
					
		try{
				if(chsInvoiceImportAuditINVO != null){
					Map<String, String> mapVO = chsInvoiceImportAuditINVO.getColumnValues();
						
					param.putAll(mapVO);
					velParam.putAll(mapVO);
							
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInvoiceDBDAOCheckCHSInvImportRefNoDataRSQL(), param, velParam);
							
					if(dbRowset.next()){
						chsInvoiceImportAuditMGTVO = new CHSInvoiceImportAuditMGTVO();
						
						chsInvoiceImportAuditMGTVO.setAgmtOfcCtyCd(dbRowset.getString("agmt_ofc_cty_cd"));
						chsInvoiceImportAuditMGTVO.setAgmtSeq(dbRowset.getString("agmt_seq"));
						chsInvoiceImportAuditMGTVO.setAgmtVerNo(dbRowset.getString("agmt_ver_no"));
						chsInvoiceImportAuditMGTVO.setAgmtLstmCd(dbRowset.getString("agmt_lstm_cd"));
					}
				}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return chsInvoiceImportAuditMGTVO;
	}
	
	/**
	 * Auding ?섍린?꾪빐 CGM_LSE_CHG_DTL ?뚯씠釉붿쓣 ?쇨큵?곸쑝濡?媛깆떊?쒕떎. [EES_CGM_1030]<br>
	 * 
	 * @param chsInvoiceImportAuditINVOs List<CHSInvoiceImportAuditINVO>
	 * @exception DAOException
	 */
	public void modifyCHSAuditInvoiceDetailData(List<CHSInvoiceImportAuditINVO> chsInvoiceImportAuditINVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(chsInvoiceImportAuditINVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ChassisMgsetInvoiceDBDAOModifyCHSAuditInvoiceDetailDataUSQL(), chsInvoiceImportAuditINVOs,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * CGM_LSE_CHG_DTL ?뚯씠釉붿뿉 Invoice ?곗씠?곕? ?쇨큵?곸쑝濡??앹꽦?쒕떎. [EES_CGM_1030]<br>
	 * 
	 * @param chsInvoiceImportAuditINVOs List<CHSInvoiceImportAuditINVO>
	 * @exception DAOException
	 */
	public void addCHSAuditInvoiceDetailData(List<CHSInvoiceImportAuditINVO> chsInvoiceImportAuditINVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(chsInvoiceImportAuditINVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ChassisMgsetInvoiceDBDAOAddCHSAuditInvoiceDetailDataCSQL(), chsInvoiceImportAuditINVOs,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Audit ??Summary ?곗씠?곕? 媛?졇?⑤떎. [EES_CGM_1030]<br>
	 * 
	 * @param chsInvoiceImportAuditINVO CHSInvoiceImportAuditINVO
	 * @return List<CHSInvoiceImportAuditMGTVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CHSInvoiceImportAuditMGTVO> searchCHSInvImportSumAmtData(CHSInvoiceImportAuditINVO chsInvoiceImportAuditINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CHSInvoiceImportAuditMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(chsInvoiceImportAuditINVO != null){
				Map<String, String> mapVO = chsInvoiceImportAuditINVO.getColumnValues();
						
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInvoiceDBDAOSearchCHSInvImportSumAmtDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CHSInvoiceImportAuditMGTVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 
	/**
	 * CGM_LSE_CHG_HDR ?뚯씠釉붿뿉??Invoice, Credit, Tax ??Summary 瑜??쇨큵?곸쑝濡?媛깆떊?쒕떎. [EES_CGM_1030]<br>
	 * 
	 * @param chsInvoiceImportAuditINVOs List<CHSInvoiceImportAuditINVO>
	 * @exception DAOException
	 */
	public void modifyCHSAuditInvoiceHeaderData(List<CHSInvoiceImportAuditINVO> chsInvoiceImportAuditINVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(chsInvoiceImportAuditINVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ChassisMgsetInvoiceDBDAOModifyCHSAuditInvoiceHeaderDataUSQL(), chsInvoiceImportAuditINVOs,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Location Code 瑜?媛?졇?⑤떎. [EES_CGM_1030] <br>
	 * 
	 * @param locCd String
	 * @return int
	 * @exception DAOException
	 */
	public int checkCHSOnOffLocationData(String locCd) throws DAOException {
		DBRowSet dbRowset = null;
		int cnt = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
					
		try{
				//2011.06.14 locCd != ""  -> locCd != null濡??섏젙
				//臾몄옄??鍮꾧탳??臾몄옄??鍮꾧탳 硫붿냼?쒕? ?ъ슜?댁빞 ?쒕떎.
				if(locCd != null){
					
					param.put("loc_cd", locCd);
					velParam.put("loc_cd", locCd);
							
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInvoiceDBDAOCheckCHSOnOffLocationDataRSQL(), param, velParam);
							
					if(dbRowset.next()){
						cnt = dbRowset.getInt("cnt");
					}
				}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return cnt;
	}
	
	/**
	 * Invoice Only ?곹깭??CGM_LSE_CHG_DTL ?뚯씠釉??곗씠?곕? ??젣?쒕떎. [EES_CGM_1030]<br>
	 * 
	 * @param chsInvoiceImportAuditINVO CHSInvoiceImportAuditINVO
	 * @exception DAOException
	 */
	public void removeCHSInvImportDtlData(CHSInvoiceImportAuditINVO chsInvoiceImportAuditINVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(chsInvoiceImportAuditINVO != null){
				//query parameter
		        Map<String, String> param = chsInvoiceImportAuditINVO.getColumnValues();
		        //??젣 
		        int result = sqlExe.executeUpdate((ISQLTemplate) new ChassisMgsetInvoiceDBDAORemoveCHSInvImportDtlDataDSQL() , param, null);
				
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to delete SQL");
				
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * CGM_LSE_CHG_DTL ?뚯씠釉붿뿉??Audit ?섍린 ?꾩쓽 ?곹깭濡??곗씠?곕? ?쇨큵?곸쑝濡??섏젙?쒕떎. [EES_CGM_1030]<br>
	 * 
	 * @param chsInvoiceImportAuditINVO CHSInvoiceImportAuditINVO
	 * @exception DAOException
	 */
	public void modifyCHSInvImportDtlData(CHSInvoiceImportAuditINVO chsInvoiceImportAuditINVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(chsInvoiceImportAuditINVO != null){
				//query parameter
		        Map<String, String> param = chsInvoiceImportAuditINVO.getColumnValues();
		        //??젣 
		        int result = sqlExe.executeUpdate((ISQLTemplate) new ChassisMgsetInvoiceDBDAOModifyCHSInvImportDtlDataUSQL() , param, null);
				
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
				
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * CGM_LSE_CHG_HDR ?뚯씠釉붿뿉??Audit ?섍린 ?꾩쓽 ?곹깭濡??곗씠?곕? ?쇨큵?곸쑝濡??섏젙?쒕떎. [EES_CGM_1030]<br>
	 * 
	 * @param chsInvoiceImportAuditINVO CHSInvoiceImportAuditINVO
	 * @exception DAOException
	 */
	public void modifyCHSInvImportHdrData(CHSInvoiceImportAuditINVO chsInvoiceImportAuditINVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(chsInvoiceImportAuditINVO != null){
				//query parameter
		        Map<String, String> param = chsInvoiceImportAuditINVO.getColumnValues();
		        //??젣 
		        int result = sqlExe.executeUpdate((ISQLTemplate) new ChassisMgsetInvoiceDBDAOModifyCHSInvImportHdrDataUSQL() , param, null);
				
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
				
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * CGM_EQ_STS_HIS ?뚯씠釉붿뿉???대떦 EQ_NO ??理쒖떊 EQ_ASET_STS_CD 瑜?媛?졇?⑤떎. [EES_CGM_1030]<br>
	 * 
	 * @param chsInvoiceImportAuditINVO CHSInvoiceImportAuditINVO
	 * @return CHSInvoiceImportAuditMGTVO
	 * @exception DAOException
	 */
	public CHSInvoiceImportAuditMGTVO checkCHSInvOnlyResultData(CHSInvoiceImportAuditINVO chsInvoiceImportAuditINVO) throws DAOException {
		DBRowSet dbRowset = null;
		CHSInvoiceImportAuditMGTVO chsInvoiceImportAuditMGTVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
					
		try{
				if(chsInvoiceImportAuditINVO != null){
					Map<String, String> mapVO = chsInvoiceImportAuditINVO.getColumnValues();
						
					param.putAll(mapVO);
					velParam.putAll(mapVO);
							
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInvoiceDBDAOCheckCHSInvOnlyResultDataRSQL(), param, velParam);
							
					if(dbRowset.next()){
						chsInvoiceImportAuditMGTVO = new CHSInvoiceImportAuditMGTVO();
						
						chsInvoiceImportAuditMGTVO.setEqAsetStsCd(dbRowset.getString("eq_aset_sts_cd"));
					}
				}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return chsInvoiceImportAuditMGTVO;
	}
	
	/**
	 * Chassis CC(Charge Creation)?뺣낫??EXCEL?곗씠?곕? CGM_LSE_INV_TMP?뚯씠釉붿뿉 ?쇨큵 INSERT?쒕떎. [EES_CGM_1030]<br>
	 * 
	 * @param cHSInvoiceImportAuditINVOs List<CHSInvoiceImportAuditINVO>
	 * @exception DAOException
	 */
	public void addCHSLeaseInvoiceData(List<CHSInvoiceImportAuditINVO> cHSInvoiceImportAuditINVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(cHSInvoiceImportAuditINVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ChassisMgsetInvoiceDBDAOaddCHSLeaseInvoiceDataCSQL(), cHSInvoiceImportAuditINVOs,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * CGM_LSE_INV_TMP?뚯씠釉붿쓽 Chassis ?곗씠?곕? ??젣?쒕떎. [EES_CGM_1030]<br>
	 * 
	 * @param cHSInvoiceImportAuditINVO CHSInvoiceImportAuditINVO
	 * @exception DAOException
	 */
	public void removeCHSLeaseInvoiceData (CHSInvoiceImportAuditINVO cHSInvoiceImportAuditINVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(cHSInvoiceImportAuditINVO != null){
				//query parameter
		        Map<String, String> param = cHSInvoiceImportAuditINVO.getColumnValues();
		        //??젣 
		        int result = sqlExe.executeUpdate((ISQLTemplate) new ChassisMgsetInvoiceDBDAOremoveCHSLeaseInvoiceDataDSQL() , param, null);
				
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
				
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	
	/**
	 * CGM_LSE_INV_TMP?뚯씠釉붿쓽 Chassis ?곗씠?곕? 議고쉶?쒕떎. [EES_CGM_1030]<br>
	 * 
	 * @param cHSInvoiceImportAuditINVO CHSInvoiceImportAuditINVO
	 * @return List<CHSInvoiceImportAuditMGTVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CHSInvoiceImportAuditMGTVO> searchCHSLeaseInvoiceData(CHSInvoiceImportAuditINVO cHSInvoiceImportAuditINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CHSInvoiceImportAuditMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(cHSInvoiceImportAuditINVO != null){
				Map<String, String> mapVO = cHSInvoiceImportAuditINVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInvoiceDBDAOsearchCHSLeaseInvoiceDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CHSInvoiceImportAuditMGTVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	

	/**
	 * CGM_LSE_INV_TMP?뚯씠釉붿쓽 Chassis Verify ?곗씠?곕? 議고쉶?쒕떎. [EES_CGM_1030]<br>
	 * 
	 * @param cHSInvoiceImportAuditINVO CHSInvoiceImportAuditINVO
	 * @return List<CHSInvoiceImportAuditMGTVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CHSInvoiceImportAuditMGTVO> searchCHSLeaseInvoiceVerifyData(CHSInvoiceImportAuditINVO cHSInvoiceImportAuditINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CHSInvoiceImportAuditMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(cHSInvoiceImportAuditINVO != null){
				Map<String, String> mapVO = cHSInvoiceImportAuditINVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInvoiceDBDAOsearchCHSLeaseInvoiceVerifyDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CHSInvoiceImportAuditMGTVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	
		 
	/**
	 * CGM_LSE_INV_TMP?뚯씠釉붿쓽 議고쉶??Chassis Save ?곗씠?곕? ?낅뜲?댄듃?쒕떎. [EES_CGM_1030]<br>
	 * 
	 * @param cHSInvoiceImportAuditMGTVOs List<CHSInvoiceImportAuditMGTVO>
	 * @exception DAOException
	 */
	public void modifyCHSLeaseInvoiceSaveData (List<CHSInvoiceImportAuditMGTVO> cHSInvoiceImportAuditMGTVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(cHSInvoiceImportAuditMGTVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ChassisMgsetInvoiceDBDAOSearchCHSLeaseInvoiceSaveDataRSQL(), cHSInvoiceImportAuditMGTVOs,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * M.G.Set CC(Charge Creation)?뺣낫??EXCEL?곗씠?곕? CGM_LSE_INV_TMP?뚯씠釉붿뿉 ?쇨큵 INSERT?쒕떎. [EES_CGM_1030]<br>
	 * 
	 * @param mGSInvoiceImportAuditINVOs List<MGSInvoiceImportAuditINVO>
	 * @exception DAOException
	 */
	public void addMGSLeaseInvoiceData(List<MGSInvoiceImportAuditINVO> mGSInvoiceImportAuditINVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(mGSInvoiceImportAuditINVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ChassisMgsetInvoiceDBDAOaddMGSLeaseInvoiceDataCSQL(), mGSInvoiceImportAuditINVOs,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * CGM_LSE_INV_TMP?뚯씠釉붿쓽 M.G.Set ?곗씠?곕? ??젣?쒕떎. [EES_CGM_1030]<br>
	 * 
	 * @param mGSInvoiceImportAuditINVO MGSInvoiceImportAuditINVO
	 * @exception DAOException
	 */
	public void removeMGSLeaseInvoiceData (MGSInvoiceImportAuditINVO mGSInvoiceImportAuditINVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(mGSInvoiceImportAuditINVO != null){
				//query parameter
		        Map<String, String> param = mGSInvoiceImportAuditINVO.getColumnValues();
		        //??젣 
		        int result = sqlExe.executeUpdate((ISQLTemplate) new ChassisMgsetInvoiceDBDAOremoveMGSLeaseInvoiceDataDSQL() , param, null);
				
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
				
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	
	/**
	 * CGM_LSE_INV_TMP?뚯씠釉붿쓽 M.G.Set ?곗씠?곕? 議고쉶?쒕떎. [EES_CGM_1030]<br>
	 * 
	 * @param mGSInvoiceImportAuditINVO MGSInvoiceImportAuditINVO
	 * @return List<MGSInvoiceImportAuditMGTVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<MGSInvoiceImportAuditMGTVO> searchMGSLeaseInvoiceData(MGSInvoiceImportAuditINVO mGSInvoiceImportAuditINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MGSInvoiceImportAuditMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(mGSInvoiceImportAuditINVO != null){
				Map<String, String> mapVO = mGSInvoiceImportAuditINVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInvoiceDBDAOsearchMGSLeaseInvoiceDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MGSInvoiceImportAuditMGTVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	

	/**
	 * CGM_LSE_INV_TMP?뚯씠釉붿쓽 M.G.Set Verify ?곗씠?곕? 議고쉶?쒕떎. [EES_CGM_1030]<br>
	 * 
	 * @param mGSInvoiceImportAuditINVO MGSInvoiceImportAuditINVO
	 * @return List<MGSInvoiceImportAuditMGTVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<MGSInvoiceImportAuditMGTVO> searchMGSLeaseInvoiceVerifyData(MGSInvoiceImportAuditINVO mGSInvoiceImportAuditINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MGSInvoiceImportAuditMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(mGSInvoiceImportAuditINVO != null){
				Map<String, String> mapVO = mGSInvoiceImportAuditINVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInvoiceDBDAOsearchMGSLeaseInvoiceVerifyDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MGSInvoiceImportAuditMGTVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}		
	
	/**
	 * M.G.Set EqNo 議댁옱 ?좊Т Check ?쒕떎. [EES_CGM_2085] <br>
	 * 
	 * @param mgsInvoiceImportAuditINVO MGSInvoiceImportAuditINVO
	 * @return int
	 * @exception DAOException
	 */
	public int checkMGSInvImportEqNoData(MGSInvoiceImportAuditINVO mgsInvoiceImportAuditINVO) throws DAOException {
		DBRowSet dbRowset = null;
		int cnt = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
					
		try{
				if(mgsInvoiceImportAuditINVO != null){
					Map<String, String> mapVO = mgsInvoiceImportAuditINVO.getColumnValues();
						
					param.putAll(mapVO);
					velParam.putAll(mapVO);
							
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInvoiceDBDAOCheckMGSInvImportEqNoDataRSQL(), param, velParam);
							
					if(dbRowset.next()){
						cnt = dbRowset.getInt("cnt");
					}
				}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return cnt;
	}
	
	/**
	 * Lessor M.G.Set No 議댁옱 ?좊Т Check ?쒕떎. [EES_CGM_2085]<br>
	 * 
	 * @param mgsInvoiceImportAuditINVO MGSInvoiceImportAuditINVO
	 * @return String
	 * @exception DAOException
	 */
	public String checkMGSInvImportLessorEqNoData(MGSInvoiceImportAuditINVO mgsInvoiceImportAuditINVO) throws DAOException {
		DBRowSet dbRowset = null;
		String invEqNo = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
					
		try{
				if(mgsInvoiceImportAuditINVO != null){
					Map<String, String> mapVO = mgsInvoiceImportAuditINVO.getColumnValues();
						
					param.putAll(mapVO);
					velParam.putAll(mapVO);
							
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInvoiceDBDAOCheckMGSInvImportLessorEqNoDataRSQL(), param, velParam);
							
					if(dbRowset.next()){
						invEqNo = dbRowset.getString("inv_eq_no");
					}
				}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return invEqNo;
	}
	
	/**
	 * Reference No 議댁옱 ?좊Т Check ?쒕떎. [EES_CGM_2085]<br>
	 * 
	 * @param mgsInvoiceImportAuditINVO MGSInvoiceImportAuditINVO
	 * @return MGSInvoiceImportAuditMGTVO
	 * @exception DAOException
	 */
	public MGSInvoiceImportAuditMGTVO checkMGSInvImportRefNoData(MGSInvoiceImportAuditINVO mgsInvoiceImportAuditINVO) throws DAOException {
		DBRowSet dbRowset = null;
		MGSInvoiceImportAuditMGTVO mgsInvoiceImportAuditMGTVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
					
		try{
				if(mgsInvoiceImportAuditINVO != null){
					Map<String, String> mapVO = mgsInvoiceImportAuditINVO.getColumnValues();
						
					param.putAll(mapVO);
					velParam.putAll(mapVO);
							
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInvoiceDBDAOCheckMGSInvImportRefNoDataRSQL(), param, velParam);
							
					if(dbRowset.next()){
						mgsInvoiceImportAuditMGTVO = new MGSInvoiceImportAuditMGTVO();
						
						mgsInvoiceImportAuditMGTVO.setAgmtOfcCtyCd(dbRowset.getString("agmt_ofc_cty_cd"));
						mgsInvoiceImportAuditMGTVO.setAgmtSeq(dbRowset.getString("agmt_seq"));
						mgsInvoiceImportAuditMGTVO.setAgmtVerNo(dbRowset.getString("agmt_ver_no"));
						mgsInvoiceImportAuditMGTVO.setAgmtLstmCd(dbRowset.getString("agmt_lstm_cd"));
					}
				}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return mgsInvoiceImportAuditMGTVO;
	}
	
	/**
	 * Auding ?섍린?꾪빐 CGM_LSE_CHG_DTL ?뚯씠釉붿쓣 ?쇨큵?곸쑝濡?媛깆떊?쒕떎. [EES_CGM_2085]<br>
	 * 
	 * @param mgsInvoiceImportAuditINVOs List<MGSInvoiceImportAuditINVO>
	 * @exception DAOException
	 */
	public void modifyMGSAuditInvoiceDetailData(List<MGSInvoiceImportAuditINVO> mgsInvoiceImportAuditINVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(mgsInvoiceImportAuditINVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ChassisMgsetInvoiceDBDAOModifyMGSAuditInvoiceDetailDataUSQL(), mgsInvoiceImportAuditINVOs,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * CGM_LSE_CHG_DTL ?뚯씠釉붿뿉 Invoice ?곗씠?곕? ?쇨큵?곸쑝濡??앹꽦?쒕떎. [EES_CGM_2085]<br>
	 * 
	 * @param mgsInvoiceImportAuditINVOs List<MGSInvoiceImportAuditINVO>
	 * @exception DAOException
	 */
	public void addMGSAuditInvoiceDetailData(List<MGSInvoiceImportAuditINVO> mgsInvoiceImportAuditINVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(mgsInvoiceImportAuditINVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ChassisMgsetInvoiceDBDAOAddMGSAuditInvoiceDetailDataCSQL(), mgsInvoiceImportAuditINVOs,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Audit ??Summary ?곗씠?곕? 媛?졇?⑤떎. [EES_CGM_2085]<br>
	 * 
	 * @param mgsInvoiceImportAuditINVO MGSInvoiceImportAuditINVO
	 * @return List<MGSInvoiceImportAuditMGTVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<MGSInvoiceImportAuditMGTVO> searchMGSInvImportSumAmtData(MGSInvoiceImportAuditINVO mgsInvoiceImportAuditINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MGSInvoiceImportAuditMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(mgsInvoiceImportAuditINVO != null){
				Map<String, String> mapVO = mgsInvoiceImportAuditINVO.getColumnValues();
						
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInvoiceDBDAOSearchMGSInvImportSumAmtDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MGSInvoiceImportAuditMGTVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 
	/**
	 * CGM_LSE_CHG_HDR ?뚯씠釉붿뿉??Invoice, Credit, Tax ??Summary 瑜??쇨큵?곸쑝濡?媛깆떊?쒕떎. [EES_CGM_2085]<br>
	 * 
	 * @param mgsInvoiceImportAuditINVOs List<MGSInvoiceImportAuditINVO>
	 * @exception DAOException
	 */
	public void modifyMGSAuditInvoiceHeaderData(List<MGSInvoiceImportAuditINVO> mgsInvoiceImportAuditINVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(mgsInvoiceImportAuditINVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ChassisMgsetInvoiceDBDAOModifyMGSAuditInvoiceHeaderDataUSQL(), mgsInvoiceImportAuditINVOs,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Location Code 瑜?媛?졇?⑤떎. [EES_CGM_2085] <br>
	 * 
	 * @param locCd String
	 * @return int
	 * @exception DAOException
	 */
	public int checkMGSOnOffLocationData(String locCd) throws DAOException {
		DBRowSet dbRowset = null;
		int cnt = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
					
		try{

				//2011.06.14 locCd != ""  -> locCd != null濡??섏젙
				//臾몄옄??鍮꾧탳??臾몄옄??鍮꾧탳 硫붿냼?쒕? ?ъ슜?댁빞 ?쒕떎.
				if(locCd != null){
					
					param.put("loc_cd", locCd);
					velParam.put("loc_cd", locCd);
							
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInvoiceDBDAOCheckMGSOnOffLocationDataRSQL(), param, velParam);
							
					if(dbRowset.next()){
						cnt = dbRowset.getInt("cnt");
					}
				}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return cnt;
	}
	
	/**
	 * Invoice Only ?곹깭??CGM_LSE_CHG_DTL ?뚯씠釉??곗씠?곕? ??젣?쒕떎. [EES_CGM_2085]<br>
	 * 
	 * @param mgsInvoiceImportAuditINVO MGSInvoiceImportAuditINVO
	 * @exception DAOException
	 */
	public void removeMGSInvImportDtlData(MGSInvoiceImportAuditINVO mgsInvoiceImportAuditINVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(mgsInvoiceImportAuditINVO != null){
				//query parameter
		        Map<String, String> param = mgsInvoiceImportAuditINVO.getColumnValues();
		        //??젣 
		        int result = sqlExe.executeUpdate((ISQLTemplate) new ChassisMgsetInvoiceDBDAORemoveMGSInvImportDtlDataDSQL() , param, null);
				
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to delete SQL");
				
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * CGM_LSE_CHG_DTL ?뚯씠釉붿뿉??Audit ?섍린 ?꾩쓽 ?곹깭濡??곗씠?곕? ?쇨큵?곸쑝濡??섏젙?쒕떎. [EES_CGM_2085]<br>
	 * 
	 * @param mgsInvoiceImportAuditINVO MGSInvoiceImportAuditINVO
	 * @exception DAOException
	 */
	public void modifyMGSInvImportDtlData(MGSInvoiceImportAuditINVO mgsInvoiceImportAuditINVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(mgsInvoiceImportAuditINVO != null){
				//query parameter
		        Map<String, String> param = mgsInvoiceImportAuditINVO.getColumnValues();
		        //??젣 
		        int result = sqlExe.executeUpdate((ISQLTemplate) new ChassisMgsetInvoiceDBDAOModifyMGSInvImportDtlDataUSQL() , param, null);
				
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
				
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * CGM_LSE_CHG_HDR ?뚯씠釉붿뿉??Audit ?섍린 ?꾩쓽 ?곹깭濡??곗씠?곕? ?쇨큵?곸쑝濡??섏젙?쒕떎. [EES_CGM_2085]<br>
	 * 
	 * @param mgsInvoiceImportAuditINVO MGSInvoiceImportAuditINVO
	 * @exception DAOException
	 */
	public void modifyMGSInvImportHdrData(MGSInvoiceImportAuditINVO mgsInvoiceImportAuditINVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(mgsInvoiceImportAuditINVO != null){
				//query parameter
		        Map<String, String> param = mgsInvoiceImportAuditINVO.getColumnValues();
		        //??젣 
		        int result = sqlExe.executeUpdate((ISQLTemplate) new ChassisMgsetInvoiceDBDAOModifyMGSInvImportHdrDataUSQL() , param, null);
				
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
				
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * CGM_EQ_STS_HIS ?뚯씠釉붿뿉???대떦 EQ_NO ??理쒖떊 EQ_ASET_STS_CD 瑜?媛?졇?⑤떎. [EES_CGM_2085]<br>
	 * 
	 * @param mgsInvoiceImportAuditINVO MGSInvoiceImportAuditINVO
	 * @return MGSInvoiceImportAuditMGTVO
	 * @exception DAOException
	 */
	public MGSInvoiceImportAuditMGTVO checkMGSInvOnlyResultData(MGSInvoiceImportAuditINVO mgsInvoiceImportAuditINVO) throws DAOException {
		DBRowSet dbRowset = null;
		MGSInvoiceImportAuditMGTVO mgsInvoiceImportAuditMGTVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
					
		try{
				if(mgsInvoiceImportAuditINVO != null){
					Map<String, String> mapVO = mgsInvoiceImportAuditINVO.getColumnValues();
						
					param.putAll(mapVO);
					velParam.putAll(mapVO);
							
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInvoiceDBDAOCheckMGSInvOnlyResultDataRSQL(), param, velParam);
							
					if(dbRowset.next()){
						mgsInvoiceImportAuditMGTVO = new MGSInvoiceImportAuditMGTVO();
						
						mgsInvoiceImportAuditMGTVO.setEqAsetStsCd(dbRowset.getString("eq_aset_sts_cd"));
					}
				}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return mgsInvoiceImportAuditMGTVO;
	}
	
	/**
	 * CGM_LSE_CHG_DTL ?뚯씠釉붿뿉??AUD_UMCH_EQ_STS_EVNT_YD_CD, AUD_UMCH_EQ_ASET_STS_CD, AUD_UMCH_EQ_STS_EVNT_DT
	 * ?곗씠?곕? ?섏젙?쒕떎. [EES_CGM_1030]<br>
	 * 
	 * @param chsInvoiceImportAuditINVO CHSInvoiceImportAuditINVO
	 * @exception DAOException
	 */
	public void modifyCHSChargeOnlyUmchStatusData(CHSInvoiceImportAuditINVO chsInvoiceImportAuditINVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(chsInvoiceImportAuditINVO != null){
				//query parameter
		        Map<String, String> param = chsInvoiceImportAuditINVO.getColumnValues();
		        //??젣 
		        int result = sqlExe.executeUpdate((ISQLTemplate) new ChassisMgsetInvoiceDBDAOModifyCHSChargeOnlyUmchStatusDataUSQL() , param, null);
				
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
				
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * CGM_LSE_CHG_DTL ?뚯씠釉붿뿉??AUD_UMCH_EQ_STS_EVNT_YD_CD, AUD_UMCH_EQ_ASET_STS_CD, AUD_UMCH_EQ_STS_EVNT_DT
	 * ?곗씠?곕? ?섏젙?쒕떎. [EES_CGM_2085]<br>
	 * 
	 * @param mgsInvoiceImportAuditINVO MGSInvoiceImportAuditINVO
	 * @exception DAOException
	 */
	public void modifyMGSChargeOnlyUmchStatusData(MGSInvoiceImportAuditINVO mgsInvoiceImportAuditINVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(mgsInvoiceImportAuditINVO != null){
				//query parameter
		        Map<String, String> param = mgsInvoiceImportAuditINVO.getColumnValues();
		        //??젣 
		        int result = sqlExe.executeUpdate((ISQLTemplate) new ChassisMgsetInvoiceDBDAOModifyMGSChargeOnlyUmchStatusDataUSQL() , param, null);
				
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
				
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * CGM_LSE_CHG_DTL ?뚯씠釉붿쓽 LSE_CHG_AUD_STS_CD 而щ읆 媛믪쓽 ?곕씪 Data瑜?媛?졇?⑤떎.<br>
	 * - Coincidence : C - Coincidenc :e (Agreement,Invoice Rate,湲덉븸,?쇱옄 ?쇱튂) [EES_CGM_1031]
	 * 
	 * @param chsConfirmPayableAmountINVO CHSConfirmPayableAmountINVO
	 * @return List<CHSConfirmPayableAmountMGTVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CHSConfirmPayableAmountMGTVO> searchCHSConcidenceStatusData(CHSConfirmPayableAmountINVO chsConfirmPayableAmountINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CHSConfirmPayableAmountMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(chsConfirmPayableAmountINVO != null){
				Map<String, String> mapVO = chsConfirmPayableAmountINVO.getColumnValues();
						
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInvoiceDBDAOSearchCHSConcidenceStatusDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CHSConfirmPayableAmountMGTVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 
	/**
	 * CGM_LSE_CHG_DTL ?뚯씠釉붿쓽 LSE_CHG_AUD_STS_CD 而щ읆 媛믪쓽 ?곕씪 Data瑜?媛?졇?⑤떎.<br>
 	 * - Discrepancy : D - Discrepancy(Agreement,Invocie Rate,湲덉븸,?쇱옄 遺덉씪移?.<br>
	 * 
	 * @param chsConfirmPayableAmountINVO CHSConfirmPayableAmountINVO
	 * @return List<CHSConfirmPayableAmountMGTVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CHSConfirmPayableAmountMGTVO> searchCHSDiscrepancyStatusData(CHSConfirmPayableAmountINVO chsConfirmPayableAmountINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CHSConfirmPayableAmountMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(chsConfirmPayableAmountINVO != null){
				Map<String, String> mapVO = chsConfirmPayableAmountINVO.getColumnValues();
							
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInvoiceDBDAOSearchCHSDiscrepancyStatusDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CHSConfirmPayableAmountMGTVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 
	/**
	 * CGM_LSE_CHG_DTL ?뚯씠釉붿쓽 LSE_CHG_AUD_STS_CD 而щ읆 媛믪쓽 ?곕씪 Data瑜?媛?졇?⑤떎.<br>
	 * - Charge Only : H - Chassis 媛?Nis Only 議댁옱.Invoice?먮뒗 ?놁쓬 [EES_CGM_1031] <br>
	 * 
	 * @param chsConfirmPayableAmountINVO CHSConfirmPayableAmountINVO
	 * @return List<CHSConfirmPayableAmountMGTVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CHSConfirmPayableAmountMGTVO> searchCHSChargeOnlyStatusData(CHSConfirmPayableAmountINVO chsConfirmPayableAmountINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CHSConfirmPayableAmountMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(chsConfirmPayableAmountINVO != null){
				Map<String, String> mapVO = chsConfirmPayableAmountINVO.getColumnValues();
								
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInvoiceDBDAOSearchCHSChargeOnlyStatusDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CHSConfirmPayableAmountMGTVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	} 
	
	/**
	 * CGM_LSE_CHG_DTL ?뚯씠釉붿쓽 LSE_CHG_AUD_STS_CD 而щ읆 媛믪쓽 ?곕씪 Data瑜?媛?졇?⑤떎.<br>
	 * - Charge Only : H - Chassis 媛?Nis Only 議댁옱.Invoice?먮뒗 ?놁쓬. [EES_CGM_1031]<br>
	 * 
	 * @param chsConfirmPayableAmountINVO CHSConfirmPayableAmountINVO
	 * @return List<CHSConfirmPayableAmountMGTVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CHSConfirmPayableAmountMGTVO> searchCHSInvoiceOnlyStatusData(CHSConfirmPayableAmountINVO chsConfirmPayableAmountINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CHSConfirmPayableAmountMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(chsConfirmPayableAmountINVO != null){
				Map<String, String> mapVO = chsConfirmPayableAmountINVO.getColumnValues();
									
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInvoiceDBDAOSearchCHSInvoiceOnlyStatusDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CHSConfirmPayableAmountMGTVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	} 
	 
	/**
	 * CGM_LSE_CHG_DTL ?뚯씠釉붿뿉 Invoice Only ???곗씠?곕? ?쇨큵?곸쑝濡??앹꽦?쒕떎. [EES_CGM_1031]<br>
	 * 
	 * @param chsConfirmPayableAmountINVOs List<CHSConfirmPayableAmountINVO>
	 * @exception DAOException
	 */
	public void addCHSAuditInvoiceOnlyDetailData(List<CHSConfirmPayableAmountINVO> chsConfirmPayableAmountINVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(chsConfirmPayableAmountINVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ChassisMgsetInvoiceDBDAOAddCHSAuditInvoiceOnlyDetailDataCSQL(), chsConfirmPayableAmountINVOs,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * CGM_LSE_CHG_DTL ?뚯씠釉붿뿉 Invoice Only ???곗씠??以?Remark瑜??ы븿???곗씠?곕뱾???쇨큵?곸쑝濡??섏젙?쒕떎. [EES_CGM_1031]<br>
	 * 
	 * @param chsConfirmPayableAmountINVOs List<CHSConfirmPayableAmountINVO>
	 * @exception DAOException
	 */
	public void modifyCHSAuditInvoiceOnlyDetailData(List<CHSConfirmPayableAmountINVO> chsConfirmPayableAmountINVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(chsConfirmPayableAmountINVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ChassisMgsetInvoiceDBDAOModifyCHSAuditInvoiceOnlyDetailDataUSQL(), chsConfirmPayableAmountINVOs,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * CGM_LSE_CHG_DTL ?뚯씠釉붿뿉 Invoice Only ???곗씠?곕? ?쇨큵?곸쑝濡???젣?쒕떎. [EES_CGM_1031]<br>
	 * 
	 * @param chsConfirmPayableAmountINVOs List<CHSConfirmPayableAmountINVO>
	 * @exception DAOException
	 */
	public void removeCHSAuditInvoiceOnlyDetailData(List<CHSConfirmPayableAmountINVO> chsConfirmPayableAmountINVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(chsConfirmPayableAmountINVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ChassisMgsetInvoiceDBDAOremoveCHSAuditInvoiceOnlyDetailDataDSQL(), chsConfirmPayableAmountINVOs,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	
	/**
	 * CGM_LSE_CHG_DTL ?뚯씠釉붿뿉 Invoice Only ???곗씠?곕? ?쇨큵?곸쑝濡???젣?쒕떎. [EES_CGM_2098]<br>
	 * 
	 * @param mGSConfirmPayableAmountINVOs List<MGSConfirmPayableAmountINVO>
	 * @exception DAOException
	 */
	public void removeMGSAuditInvoiceOnlyDetailData(List<MGSConfirmPayableAmountINVO> mGSConfirmPayableAmountINVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(mGSConfirmPayableAmountINVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ChassisMgsetInvoiceDBDAOremoveMGSAuditInvoiceOnlyDetailDataDSQL(), mGSConfirmPayableAmountINVOs,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	
	/**
	 * CGM_LSE_CHG_DTL ?뚯씠釉붿뿉??Concidency ?곹깭濡??쇨큵?곸쑝濡?媛깆떊?쒕떎. [EES_CGM_1031]<br>
	 * 
	 * @param chsConfirmPayableAmountINVOs List<CHSConfirmPayableAmountINVO>
	 * @exception DAOException
	 */
	public void modifyCHSAuditInvoiceConcidenceData(List<CHSConfirmPayableAmountINVO> chsConfirmPayableAmountINVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(chsConfirmPayableAmountINVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ChassisMgsetInvoiceDBDAOModifyCHSAuditInvoiceConcidenceDataUSQL(), chsConfirmPayableAmountINVOs,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * CGM_LSE_CHG_DTL ?뚯씠釉붿뿉??Decrepancy ??remark ?뺣낫瑜??쇨큵?곸쑝濡?媛깆떊?쒕떎. [EES_CGM_1031]<br>
	 * 
	 * @param chsConfirmPayableAmountINVOs List<CHSConfirmPayableAmountINVO>
	 * @exception DAOException
	 */
	public void modifyCHSAuditInvoiceDiscrepancyData(List<CHSConfirmPayableAmountINVO> chsConfirmPayableAmountINVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(chsConfirmPayableAmountINVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ChassisMgsetInvoiceDBDAOModifyCHSAuditInvoiceDiscrepancyDataUSQL(), chsConfirmPayableAmountINVOs,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * CGM_LSE_CHG_HDR ?뚯씠釉붿뿉??INV_SMRY_AMT, CR_SMRY_AMT, TAX_SMRY_AMT ?뺣낫瑜?媛깆떊?쒕떎. [EES_CGM_1031]<br>
	 * 
	 * @param chsConfirmPayableAmountINVOs List<CHSConfirmPayableAmountINVO>
	 * @exception DAOException
	 */
	public void modifyCHSInvoiceAuditResultHeaderData(List<CHSConfirmPayableAmountINVO> chsConfirmPayableAmountINVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(chsConfirmPayableAmountINVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ChassisMgsetInvoiceDBDAOModifyCHSInvoiceAuditResultHeaderDataUSQL(), chsConfirmPayableAmountINVOs,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * CGM_LSE_CHG_DTL ?뚯씠釉붿뿉??Concidece 濡???릿 紐⑤뱺 ?곗씠?곕? Concidence ?곹깭濡??쇨큵?곸쑝濡?媛깆떊?쒕떎. [EES_CGM_1031]<br>
	 * 
	 * @param chsConfirmPayableAmountINVOs List<CHSConfirmPayableAmountINVO>
	 * @exception DAOException
	 */
	public void modifyCHSPayableAmountDetailData(List<CHSConfirmPayableAmountINVO> chsConfirmPayableAmountINVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(chsConfirmPayableAmountINVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ChassisMgsetInvoiceDBDAOModifyCHSPayableAmountDetailDataUSQL(), chsConfirmPayableAmountINVOs,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * CGM_LSE_CHG_HDR ?뚯씠釉붿뿉??CR_SMRY_AMT, TAX_SMRY_AMT, LSE_CHG_STS_CD ?곗씠?곕? ?섏젙?쒕떎. [EES_CGM_1031]<br>
	 * 
	 * @param chsConfirmPayableAmountINVO CHSConfirmPayableAmountINVO
	 * @exception DAOException
	 */
	public void modifyCHSPayableAmountHeaderData(CHSConfirmPayableAmountINVO chsConfirmPayableAmountINVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(chsConfirmPayableAmountINVO != null){
				//query parameter
		        Map<String, String> param = chsConfirmPayableAmountINVO.getColumnValues();
		        //??젣 
		        int result = sqlExe.executeUpdate((ISQLTemplate) new ChassisMgsetInvoiceDBDAOModifyCHSPayableAmountHeaderDataUSQL() , param, null);
				
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
				
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * CGM_PAY_INV ?뚯씠釉??곗씠?곕? ??젣?쒕떎. [EES_CGM_1031]<br>
	 * 
	 * @param chsConfirmPayableAmountINVO CHSConfirmPayableAmountINVO
	 * @exception DAOException
	 */
	public void removeCHSPayableAmountData(CHSConfirmPayableAmountINVO chsConfirmPayableAmountINVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(chsConfirmPayableAmountINVO != null){
				//query parameter
		        Map<String, String> param = chsConfirmPayableAmountINVO.getColumnValues();
		        //??젣 
		        int result = sqlExe.executeUpdate((ISQLTemplate) new ChassisMgsetInvoiceDBDAORemoveCHSPayableAmountDataDSQL() , param, null);
				
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to delete SQL");
				
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * CGM_PAY_INV ?뚯씠釉붿쓽 ?곗씠?곕? ?앹꽦?쒕떎. [EES_CGM_1031]<br>
	 * 
	 * @param chsConfirmPayableAmountINVO CHSConfirmPayableAmountINVO
	 * @exception DAOException
	 */
	public void addCHSPayableAmountData(CHSConfirmPayableAmountINVO chsConfirmPayableAmountINVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(chsConfirmPayableAmountINVO != null){
				//query parameter
		        Map<String, String> param = chsConfirmPayableAmountINVO.getColumnValues();
		        //??젣 
		        int result = sqlExe.executeUpdate((ISQLTemplate) new ChassisMgsetInvoiceDBDAOAddCHSPayableAmountDataCSQL() , param, null);
				
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to Insert SQL");
				
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * CGM_LSE_CHG_DTL ?뚯씠釉붿뿉??PAY_INV_SEQ 瑜??섏젙?쒕떎. [EES_CGM_1031]<br>
	 * 
	 * @param chsConfirmPayableAmountINVO CHSConfirmPayableAmountINVO
	 * @exception DAOException
	 */
	public void modifyCHSPayableInvoiceSeqData(CHSConfirmPayableAmountINVO chsConfirmPayableAmountINVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(chsConfirmPayableAmountINVO != null){
				//query parameter
		        Map<String, String> param = chsConfirmPayableAmountINVO.getColumnValues();
		        //??젣 
		        int result = sqlExe.executeUpdate((ISQLTemplate) new ChassisMgsetInvoiceDBDAOModifyCHSPayableInvoiceSeqDataUSQL() , param, null);
				
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
				
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * CGM_LSE_CHG_DTL?먯꽌 LSE_CHG_AUD_STS_CD = 'I' ?곹깭???곗씠?곕? ??젣?쒕떎. [EES_CGM_1031]<br>
	 * 
	 * @param chsConfirmPayableAmountINVO CHSConfirmPayableAmountINVO
	 * @exception DAOException
	 */
	public void removeCHSPayableAddInvOnlyData(CHSConfirmPayableAmountINVO chsConfirmPayableAmountINVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(chsConfirmPayableAmountINVO != null){
				//query parameter
		        Map<String, String> param = chsConfirmPayableAmountINVO.getColumnValues();
		        //??젣 
		        int result = sqlExe.executeUpdate((ISQLTemplate) new ChassisMgsetInvoiceDBDAORemoveCHSPayableAddInvOnlyDataDSQL() , param, null);
				
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to Remove SQL");
				
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * CGM_LSE_CHG_DTL ?뚯씠釉붿쓣 Invoice Import & Audit ?곹깭濡??곗씠?곕? ?섏젙?쒕떎. [EES_CGM_1031]<br>
	 * 
	 * @param chsConfirmPayableAmountINVO CHSConfirmPayableAmountINVO
	 * @exception DAOException
	 */
	public void modifyCHSPayableChgDtlCancelData(CHSConfirmPayableAmountINVO chsConfirmPayableAmountINVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(chsConfirmPayableAmountINVO != null){
				//query parameter
		        Map<String, String> param = chsConfirmPayableAmountINVO.getColumnValues();
		        //?ㅽ뻾
		        int result = sqlExe.executeUpdate((ISQLTemplate) new ChassisMgsetInvoiceDBDAOModifyCHSPayableChgDtlCancelDataUSQL() , param, null);
				
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to Update SQL");
				
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * CGM_LSE_CHG_HDR ?뚯씠釉붾? Invoice Import & Audit ?곹깭濡??곗씠?곕? ?섏젙?쒕떎. [EES_CGM_1031]<br>
	 * 
	 * @param chsConfirmPayableAmountINVO CHSConfirmPayableAmountINVO
	 * @exception DAOException
	 */
	public void modifyCHSPayableChgHdrCancelData(CHSConfirmPayableAmountINVO chsConfirmPayableAmountINVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(chsConfirmPayableAmountINVO != null){
				//query parameter
		        Map<String, String> param = chsConfirmPayableAmountINVO.getColumnValues();
		        //?ㅽ뻾 
		        int result = sqlExe.executeUpdate((ISQLTemplate) new ChassisMgsetInvoiceDBDAOModifyCHSPayableChgHdrCancelDataUSQL() , param, null);
				
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to Update SQL");
				
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Invoice ?곗씠?곕? ??젣?쒕떎. [EES_CGM_1031]<br>
	 * 
	 * @param chsConfirmPayableAmountINVO CHSConfirmPayableAmountINVO
	 * @exception DAOException
	 */
	public void removeCHSPayableInvCreationData(CHSConfirmPayableAmountINVO chsConfirmPayableAmountINVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(chsConfirmPayableAmountINVO != null){
				//query parameter
		        Map<String, String> param = chsConfirmPayableAmountINVO.getColumnValues();
		        //??젣 
		        int result = sqlExe.executeUpdate((ISQLTemplate) new ChassisMgsetInvoiceDBDAORemoveCHSPayableInvCreationDataDSQL() , param, null);
				
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to Remove SQL");
				
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * CGM_LSE_CHG_DTL ?뚯씠釉붿쓽 LSE_CHG_AUD_STS_CD 而щ읆 媛믪쓽 ?곕씪 Data瑜?媛?졇?⑤떎.<br>
	 * - Coincidence : C - Coincidenc :e (Agreement,Invoice Rate,湲덉븸,?쇱옄 ?쇱튂) [EES_CGM_2098] <br>
	 * 
	 * @param mgsConfirmPayableAmountINVO MGSConfirmPayableAmountINVO
	 * @return List<MGSConfirmPayableAmountMGTVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<MGSConfirmPayableAmountMGTVO> searchMGSConcidenceStatusData(MGSConfirmPayableAmountINVO mgsConfirmPayableAmountINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MGSConfirmPayableAmountMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(mgsConfirmPayableAmountINVO != null){
				Map<String, String> mapVO = mgsConfirmPayableAmountINVO.getColumnValues();
						
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInvoiceDBDAOSearchMGSConcidenceStatusDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MGSConfirmPayableAmountMGTVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 
	/**
	 * CGM_LSE_CHG_DTL ?뚯씠釉붿쓽 LSE_CHG_AUD_STS_CD 而щ읆 媛믪쓽 ?곕씪 Data瑜?媛?졇?⑤떎.<br>
 	 * - Discrepancy : D - Discrepancy(Agreement,Invocie Rate,湲덉븸,?쇱옄 遺덉씪移?. [EES_CGM_2098]<br>
	 * 
	 * @param mgsConfirmPayableAmountINVO MGSConfirmPayableAmountINVO
	 * @return List<MGSConfirmPayableAmountMGTVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<MGSConfirmPayableAmountMGTVO> searchMGSDiscrepancyStatusData(MGSConfirmPayableAmountINVO mgsConfirmPayableAmountINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MGSConfirmPayableAmountMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(mgsConfirmPayableAmountINVO != null){
				Map<String, String> mapVO = mgsConfirmPayableAmountINVO.getColumnValues();
							
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInvoiceDBDAOSearchMGSDiscrepancyStatusDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MGSConfirmPayableAmountMGTVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 
	/**
	 * CGM_LSE_CHG_DTL ?뚯씠釉붿쓽 LSE_CHG_AUD_STS_CD 而щ읆 媛믪쓽 ?곕씪 Data瑜?媛?졇?⑤떎.<br>
	 * - Charge Only : H - Chassis 媛?Nis Only 議댁옱.Invoice?먮뒗 ?놁쓬 [EES_CGM_2098] <br>
	 * 
	 * @param mgsConfirmPayableAmountINVO MGSConfirmPayableAmountINVO
	 * @return List<MGSConfirmPayableAmountMGTVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<MGSConfirmPayableAmountMGTVO> searchMGSChargeOnlyStatusData(MGSConfirmPayableAmountINVO mgsConfirmPayableAmountINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MGSConfirmPayableAmountMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(mgsConfirmPayableAmountINVO != null){
				Map<String, String> mapVO = mgsConfirmPayableAmountINVO.getColumnValues();
								
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInvoiceDBDAOSearchMGSChargeOnlyStatusDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MGSConfirmPayableAmountMGTVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	} 
	
	/**
	 * CGM_LSE_CHG_DTL ?뚯씠釉붿쓽 LSE_CHG_AUD_STS_CD 而щ읆 媛믪쓽 ?곕씪 Data瑜?媛?졇?⑤떎.<br>
	 * - Charge Only : H - Chassis 媛?Nis Only 議댁옱.Invoice?먮뒗 ?놁쓬. [EES_CGM_2098]<br>
	 * 
	 * @param mgsConfirmPayableAmountINVO MGSConfirmPayableAmountINVO
	 * @return List<MGSConfirmPayableAmountMGTVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<MGSConfirmPayableAmountMGTVO> searchMGSInvoiceOnlyStatusData(MGSConfirmPayableAmountINVO mgsConfirmPayableAmountINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MGSConfirmPayableAmountMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(mgsConfirmPayableAmountINVO != null){
				Map<String, String> mapVO = mgsConfirmPayableAmountINVO.getColumnValues();
									
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInvoiceDBDAOSearchMGSInvoiceOnlyStatusDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MGSConfirmPayableAmountMGTVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	} 
	 
	/**
	 * CGM_LSE_CHG_DTL ?뚯씠釉붿뿉 Invoice Only ???곗씠?곕? ?쇨큵?곸쑝濡??앹꽦?쒕떎. [EES_CGM_2098]<br>
	 * 
	 * @param mgsConfirmPayableAmountINVOs List<MGSConfirmPayableAmountINVO>
	 * @exception DAOException
	 */
	public void addMGSAuditInvoiceOnlyDetailData(List<MGSConfirmPayableAmountINVO> mgsConfirmPayableAmountINVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(mgsConfirmPayableAmountINVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ChassisMgsetInvoiceDBDAOAddMGSAuditInvoiceOnlyDetailDataCSQL(), mgsConfirmPayableAmountINVOs,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	} 
	
	/**
	 * CGM_LSE_CHG_DTL ?뚯씠釉붿뿉 Invoice Only ???곗씠??以?Remark 瑜??쇨큵?곸쑝濡??섏젙?쒕떎. [EES_CGM_2098]<br>
	 * 
	 * @param mgsConfirmPayableAmountINVOs List<MGSConfirmPayableAmountINVO>
	 * @exception DAOException
	 */
	public void modifyMGSAuditInvoiceOnlyDetailData(List<MGSConfirmPayableAmountINVO> mgsConfirmPayableAmountINVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(mgsConfirmPayableAmountINVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ChassisMgsetInvoiceDBDAOModifyMGSAuditInvoiceOnlyDetailDataUSQL(), mgsConfirmPayableAmountINVOs,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	} 
	
	/**
	 * CGM_LSE_CHG_DTL ?뚯씠釉붿뿉??Concidency ?곹깭濡??쇨큵?곸쑝濡?媛깆떊?쒕떎. [EES_CGM_2098]<br>
	 * 
	 * @param mgsConfirmPayableAmountINVOs List<MGSConfirmPayableAmountINVO>
	 * @exception DAOException
	 */
	public void modifyMGSAuditInvoiceConcidenceData(List<MGSConfirmPayableAmountINVO> mgsConfirmPayableAmountINVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(mgsConfirmPayableAmountINVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ChassisMgsetInvoiceDBDAOModifyMGSAuditInvoiceConcidenceDataUSQL(), mgsConfirmPayableAmountINVOs,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * CGM_LSE_CHG_DTL ?뚯씠釉붿뿉??Decrepancy ??remark ?뺣낫瑜??쇨큵?곸쑝濡?媛깆떊?쒕떎. [EES_CGM_2098]<br>
	 * 
	 * @param mgsConfirmPayableAmountINVOs List<MGSConfirmPayableAmountINVO>
	 * @exception DAOException
	 */
	public void modifyMGSAuditInvoiceDiscrepancyData(List<MGSConfirmPayableAmountINVO> mgsConfirmPayableAmountINVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(mgsConfirmPayableAmountINVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ChassisMgsetInvoiceDBDAOModifyMGSAuditInvoiceDiscrepancyDataUSQL(), mgsConfirmPayableAmountINVOs,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * CGM_LSE_CHG_HDR ?뚯씠釉붿뿉??INV_SMRY_AMT, CR_SMRY_AMT, TAX_SMRY_AMT ?뺣낫瑜?媛깆떊?쒕떎. [EES_CGM_2098]<br>
	 * 
	 * @param mgsConfirmPayableAmountINVOs List<MGSConfirmPayableAmountINVO>
	 * @exception DAOException
	 */
	public void modifyMGSInvoiceAuditResultHeaderData(List<MGSConfirmPayableAmountINVO> mgsConfirmPayableAmountINVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(mgsConfirmPayableAmountINVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ChassisMgsetInvoiceDBDAOModifyMGSInvoiceAuditResultHeaderDataUSQL(), mgsConfirmPayableAmountINVOs,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * CGM_LSE_CHG_DTL ?뚯씠釉붿뿉??Concidece 濡???릿 紐⑤뱺 ?곗씠?곕? Concidence ?곹깭濡??쇨큵?곸쑝濡?媛깆떊?쒕떎. [EES_CGM_2098]<br>
	 * 
	 * @param mgsConfirmPayableAmountINVO List<MGSConfirmPayableAmountINVO>
	 * @exception DAOException
	 */
	public void modifyMGSPayableAmountDetailData(List<MGSConfirmPayableAmountINVO> mgsConfirmPayableAmountINVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(mgsConfirmPayableAmountINVO.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ChassisMgsetInvoiceDBDAOModifyMGSPayableAmountDetailDataUSQL(), mgsConfirmPayableAmountINVO,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * CGM_LSE_CHG_HDR ?뚯씠釉붿뿉??CR_SMRY_AMT, TAX_SMRY_AMT, LSE_CHG_STS_CD ?곗씠?곕? ?섏젙?쒕떎. [EES_CGM_2098]<br>
	 * 
	 * @param mgsConfirmPayableAmountINVO MGSConfirmPayableAmountINVO
	 * @exception DAOException
	 */
	public void modifyMGSPayableAmountHeaderData(MGSConfirmPayableAmountINVO mgsConfirmPayableAmountINVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(mgsConfirmPayableAmountINVO != null){
				//query parameter
		        Map<String, String> param = mgsConfirmPayableAmountINVO.getColumnValues();
		        //??젣 
		        int result = sqlExe.executeUpdate((ISQLTemplate) new ChassisMgsetInvoiceDBDAOModifyMGSPayableAmountHeaderDataUSQL() , param, null);
				
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
				
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * CGM_PAY_INV ?뚯씠釉??곗씠?곕? ??젣?쒕떎. [EES_CGM_2098]<br>
	 * 
	 * @param mgsConfirmPayableAmountINVO MGSConfirmPayableAmountINVO
	 * @exception DAOException
	 */
	public void removeMGSPayableAmountData(MGSConfirmPayableAmountINVO mgsConfirmPayableAmountINVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(mgsConfirmPayableAmountINVO != null){
				//query parameter
		        Map<String, String> param = mgsConfirmPayableAmountINVO.getColumnValues();
		        //??젣 
		        int result = sqlExe.executeUpdate((ISQLTemplate) new ChassisMgsetInvoiceDBDAORemoveMGSPayableAmountDataDSQL() , param, null);
				
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to delete SQL");
				
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 
	/**
	 * CGM_PAY_INV ?뚯씠釉붿쓽 ?곗씠?곕? ?앹꽦?쒕떎. [EES_CGM_2098]<br>
	 * 
	 * @param mgsConfirmPayableAmountINVO MGSConfirmPayableAmountINVO
	 * @exception DAOException
	 */
	public void addMGSPayableAmountData(MGSConfirmPayableAmountINVO mgsConfirmPayableAmountINVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(mgsConfirmPayableAmountINVO != null){
				//query parameter
		        Map<String, String> param = mgsConfirmPayableAmountINVO.getColumnValues();
		        //??젣 
		        int result = sqlExe.executeUpdate((ISQLTemplate) new ChassisMgsetInvoiceDBDAOAddCHSPayableAmountDataCSQL() , param, null);
				
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to Insert SQL");
				
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * CGM_LSE_CHG_DTL ?뚯씠釉붿뿉??PAY_INV_SEQ 瑜??섏젙?쒕떎. [EES_CGM_2098]<br>
	 * 
	 * @param mgsConfirmPayableAmountINVO MGSConfirmPayableAmountINVO
	 * @exception DAOException
	 */
	public void modifyMGSPayableInvoiceSeqData(MGSConfirmPayableAmountINVO mgsConfirmPayableAmountINVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(mgsConfirmPayableAmountINVO != null){
				//query parameter
		        Map<String, String> param = mgsConfirmPayableAmountINVO.getColumnValues();
		        //??젣 
		        int result = sqlExe.executeUpdate((ISQLTemplate) new ChassisMgsetInvoiceDBDAOModifyMGSPayableInvoiceSeqDataUSQL() , param, null);
				
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
				
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * CGM_LSE_CHG_DTL?먯꽌 LSE_CHG_AUD_STS_CD = 'I' ?곹깭???곗씠?곕? ??젣?쒕떎. [EES_CGM_2098]<br>
	 * 
	 * @param mgsConfirmPayableAmountINVO MGSConfirmPayableAmountINVO
	 * @exception DAOException
	 */
	public void removeMGSPayableAddInvOnlyData(MGSConfirmPayableAmountINVO mgsConfirmPayableAmountINVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(mgsConfirmPayableAmountINVO != null){
				//query parameter
		        Map<String, String> param = mgsConfirmPayableAmountINVO.getColumnValues();
		        //??젣 
		        int result = sqlExe.executeUpdate((ISQLTemplate) new ChassisMgsetInvoiceDBDAORemoveMGSPayableAddInvOnlyDataDSQL() , param, null);
				
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to delete SQL");
				
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * CGM_LSE_CHG_DTL ?뚯씠釉붿쓣 Invoice Import & Audit ?곹깭濡??곗씠?곕? ?섏젙?쒕떎. [EES_CGM_2098]<br>
	 * 
	 * @param mgsConfirmPayableAmountINVO MGSConfirmPayableAmountINVO
	 * @exception DAOException
	 */
	public void modifyMGSPayableChgDtlCancelData(MGSConfirmPayableAmountINVO mgsConfirmPayableAmountINVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(mgsConfirmPayableAmountINVO != null){
				//query parameter
		        Map<String, String> param = mgsConfirmPayableAmountINVO.getColumnValues();
		        //?ㅽ뻾
		        int result = sqlExe.executeUpdate((ISQLTemplate) new ChassisMgsetInvoiceDBDAOModifyMGSPayableChgDtlCancelDataUSQL() , param, null);
				
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
				
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * CGM_LSE_CHG_HDR ?뚯씠釉붾? Invoice Import & Audit ?곹깭濡??곗씠?곕? ?섏젙?쒕떎. [EES_CGM_2098]<br>
	 * 
	 * @param mgsConfirmPayableAmountINVO MGSConfirmPayableAmountINVO
	 * @exception DAOException
	 */
	public void modifyMGSPayableChgHdrCancelData(MGSConfirmPayableAmountINVO mgsConfirmPayableAmountINVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(mgsConfirmPayableAmountINVO != null){
				//query parameter
		        Map<String, String> param = mgsConfirmPayableAmountINVO.getColumnValues();
		        //?ㅽ뻾
		        int result = sqlExe.executeUpdate((ISQLTemplate) new ChassisMgsetInvoiceDBDAOModifyMGSPayableChgHdrCancelDataUSQL() , param, null);
				
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
				
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Invoice ?곗씠?곕? ??젣?쒕떎. [EES_CGM_2098]<br>
	 * 
	 * @param mgsConfirmPayableAmountINVO MGSConfirmPayableAmountINVO
	 * @exception DAOException
	 */
	public void removeMGSPayableInvCreationData(MGSConfirmPayableAmountINVO mgsConfirmPayableAmountINVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(mgsConfirmPayableAmountINVO != null){
				//query parameter
		        Map<String, String> param = mgsConfirmPayableAmountINVO.getColumnValues();
		        //??젣 
		        int result = sqlExe.executeUpdate((ISQLTemplate) new ChassisMgsetInvoiceDBDAORemoveMGSPayableInvCreationDataDSQL() , param, null);
				
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to delete SQL");
				
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * CGM_PAY_INV 데이터중 Invoice No.와 CHSS_MGST_INV_KND_CD가 같은 데이터가 존재하는지 체크하여 Count 반환 처리. <br>
	 * [EES_CGM_1123][EES_CGM_1124][EES_CGM_1223][EES_CGM_1204] <br>
	 * 
	 * @param invNo String
	 * @param chssMgstInvKndCd String
	 * @return long
	 * @exception DAOException
	 */
	public long checkCHSInvoiceNoData(String invNo, String chssMgstInvKndCd) throws DAOException {
		DBRowSet dbRowset = null;
		long cnt = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
				
		try{
			param.put("inv_no", invNo);
			param.put("chss_mgst_inv_knd_cd", chssMgstInvKndCd);
			velParam.put("inv_no", invNo);
			velParam.put("chss_mgst_inv_knd_cd", chssMgstInvKndCd);
						
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInvoiceDBDAOCheckCHSInvoiceNoDataRSQL(), param, velParam);
							
			if(dbRowset.next()){
				cnt = dbRowset.getInt("cnt");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return cnt;
	}
	
	/**
	 * CP ?덉뿉???ㅻⅨ Cost Month ??Invoice No 媛?議댁옱?섎뒗吏?泥댄겕?쒕떎. [EES_CGM_1124]<br>
	 * 
	 * @param invNo String
	 * @param chssMgstInvKndCd String
	 * @param costYrmon String
	 * @return long
	 * @exception DAOException
	 */
	public long checkCHSInvoiceNoByCostMonthData(String invNo, String chssMgstInvKndCd, String costYrmon) throws DAOException {
		DBRowSet dbRowset = null;
		long cnt = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
				
		try{
			param.put("inv_no", invNo);
			param.put("chss_mgst_inv_knd_cd", chssMgstInvKndCd);
			param.put("cost_yrmon", costYrmon);
			velParam.put("inv_no", invNo);
			velParam.put("chss_mgst_inv_knd_cd", chssMgstInvKndCd);
			velParam.put("cost_yrmon", costYrmon);
						
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInvoiceDBDAOCheckCHSInvoiceNoByCostMonthDataRSQL(), param, velParam);
							
			if(dbRowset.next()){
				cnt = dbRowset.getInt("cnt");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return cnt;
	}
	
	/**
	 * Neutral Pool Charge 紐⑸줉??議고쉶?쒕떎. [EES_CGM_1124]<br>
	 * 
	 * @param chsNuPoolChargeINVO CHSNuPoolChargeINVO
	 * @return List<CHSNuPoolChargeMGTVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CHSNuPoolChargeMGTVO> searchCHSNuPoolChargeListData(CHSNuPoolChargeINVO chsNuPoolChargeINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CHSNuPoolChargeMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(chsNuPoolChargeINVO != null){
				Map<String, String> mapVO = chsNuPoolChargeINVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInvoiceDBDAOSearchCHSNuPoolChargeListDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CHSNuPoolChargeMGTVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 
	/**
	 * Neutral Pool Charge 珥덇린 ??ぉ??議고쉶?쒕떎. [EES_CGM_1124]<br>
	 * 
	 * @param chsNuPoolChargeINVO CHSNuPoolChargeINVO
	 * @return List<CHSNuPoolChargeMGTVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CHSNuPoolChargeMGTVO> searchCHSNuPoolChargeInitData(CHSNuPoolChargeINVO chsNuPoolChargeINVO) throws DAOException {
		DBRowSet dbRowset = null; 
		List<CHSNuPoolChargeMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(chsNuPoolChargeINVO != null){
				Map<String, String> mapVO = chsNuPoolChargeINVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInvoiceDBDAOSearchCHSNuPoolChargeInitDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CHSNuPoolChargeMGTVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 
	/**
	 * Neutral Pool Charge ?곸꽭 ?댁뿭??議고쉶?쒕떎. [EES_CGM_1024]<br>
	 * 
	 * @param chsNuPoolChargeINVO CHSNuPoolChargeINVO
	 * @return List<CHSNuPoolChargeMGTVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CHSNuPoolChargeMGTVO> searchCHSNuPoolChargeDtlData(CHSNuPoolChargeINVO chsNuPoolChargeINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CHSNuPoolChargeMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(chsNuPoolChargeINVO != null){
				Map<String, String> mapVO = chsNuPoolChargeINVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInvoiceDBDAOSearchCHSNuPoolChargeDtlDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CHSNuPoolChargeMGTVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	 
	 
	 /**
	 * CGM_PAY_INV ?뚯씠釉붿뿉 Neutral Pool Charge payInvSeq 媛?졇?⑤떎 . [EES_CGM_1024]<br>
	 * 
	 * @param chsNuPoolChargeINVO CHSNuPoolChargeINVO
	 * @return long
	 * @exception DAOException
	 */
	public long searchCHSNuPoolChargePayInvSeqData(CHSNuPoolChargeINVO chsNuPoolChargeINVO) throws DAOException,Exception {
		
		DBRowSet dbRowset = null;
		long payInvSeq = 0;
		
		try {
			
			if(chsNuPoolChargeINVO != null){
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInvoiceDBDAOSearchCHSNuPoolChargePayInvSeqDataRSQL(), null, null);
				
				if(dbRowset.next()){
					payInvSeq = dbRowset.getInt("pay_inv_seq");
					chsNuPoolChargeINVO.setPayInvSeq(String.valueOf(payInvSeq));
				}
				 
				
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return payInvSeq;
	}
		
    /**
	 * CGM_PAY_INV ?뚯씠釉붿뿉 Neutral Pool Charge ?곗씠?곕? ?앹꽦?쒕떎. [EES_CGM_1024]<br>
	 * 
	 * @param chsNuPoolChargeINVO CHSNuPoolChargeINVO
	 * @exception DAOException
	 */
	public void addCHSNuPoolChargeMainData(CHSNuPoolChargeINVO chsNuPoolChargeINVO) throws DAOException,Exception {
		
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(chsNuPoolChargeINVO != null){
				
				//query parameter
		        Map<String, String> param = chsNuPoolChargeINVO.getColumnValues();
		        //?좉퇋 ?낅젰
		        int result = sqlExe.executeUpdate((ISQLTemplate) new ChassisMgsetInvoiceDBDAOAddCHSNuPoolChargeMainDataCSQL() , param, null);
				
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
				
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * CGM_PAY_INV_POOL_DTL ?뚯씠釉붿뿉 Neutral Pool Charge ?곸꽭 ?곗씠?곕? ?앹꽦?쒕떎. [EES_CGM_1024]<br>
	 * 
	 * @param chsNuPoolChargeINVOs List<CHSNuPoolChargeINVO>
	 * @exception DAOException
	 */
	public void addCHSNuPoolChargeDtlData(List<CHSNuPoolChargeINVO> chsNuPoolChargeINVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(chsNuPoolChargeINVOs != null)
				if(chsNuPoolChargeINVOs.size() > 0){
					insCnt = sqlExe.executeBatch((ISQLTemplate)new ChassisMgsetInvoiceDBDAOAddCHSNuPoolChargeDtlDataCSQL(), chsNuPoolChargeINVOs,null);
					for(int i = 0; i < insCnt.length; i++){
						if(insCnt[i]== Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to insert No"+ i + " SQL");
					}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * CGM_PAY_INV ?뚯씠釉붿뿉 Neutral Pool Main ?곗씠?곕? ?섏젙?쒕떎. [EES_CGM_1024]<br>
	 * 
	 * @param chsNuPoolChargeINVO CHSCoPoolChargeINVO
	 * @exception DAOException
	 */
	public void modifyCHSNuPoolChargeMainData(CHSNuPoolChargeINVO chsNuPoolChargeINVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(chsNuPoolChargeINVO != null){
				//query parameter
		        Map<String, String> param = chsNuPoolChargeINVO.getColumnValues();
		        //??젣 
		        int result = sqlExe.executeUpdate((ISQLTemplate) new ChassisMgsetInvoiceDBDAOModifyCHSNuPoolChargeMainDataUSQL() , param, null);
				
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
				
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * CGM_PAY_INV ?뚯씠釉붿뿉 Neutral Pool Detail ?곗씠?곕? ?섏젙?쒕떎. [EES_CGM_1024]<br>
	 * 
	 * @param chsNuPoolChargeINVOs List<CHSNuPoolChargeINVO>
	 * @exception DAOException
	 */
	public void modifyCHSNuPoolChargeDtlData(List<CHSNuPoolChargeINVO> chsNuPoolChargeINVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(chsNuPoolChargeINVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ChassisMgsetInvoiceDBDAOModifyCHSNuPoolChargeDtlDataUSQL(), chsNuPoolChargeINVOs,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * CGM_PAY_INV ?뚯씠釉붿뿉??Neutral Pool Main ?곗씠?곕? ??젣?쒕떎. [EES_CGM_1024]<br>
	 * 
	 * @param chsNuPoolChargeINVO CHSNuPoolChargeINVO
	 * @exception DAOException
	 */
	public void removeCHSNuPoolChargeMainData(CHSNuPoolChargeINVO chsNuPoolChargeINVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(chsNuPoolChargeINVO != null){
				//query parameter
		        Map<String, String> param = chsNuPoolChargeINVO.getColumnValues();
		        //??젣 
		        int result = sqlExe.executeUpdate((ISQLTemplate) new ChassisMgsetInvoiceDBDAORemoveCHSNuPoolChargeMainDataDSQL() , param, null);
				
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
				
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * CGM_PAY_INV ?뚯씠釉붿뿉??Neutral Pool Detail ?곗씠?곕? ??젣?쒕떎. [EES_CGM_1024]<br>
	 * 
	 * @param chsNuPoolChargeINVO CHSNuPoolChargeINVO
	 * @exception DAOException
	 */
	public void removeCHSNuPoolChargeDtlData(CHSNuPoolChargeINVO chsNuPoolChargeINVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(chsNuPoolChargeINVO != null){
				//query parameter
		        Map<String, String> param = chsNuPoolChargeINVO.getColumnValues();
		        //??젣 
		        int result = sqlExe.executeUpdate((ISQLTemplate) new ChassisMgsetInvoiceDBDAORemoveCHSNuPoolChargeDtlDataDSQL() , param, null);
				
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
				
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Neutral Pool Charge Main ?뺣낫瑜?遺덈윭?⑤떎. [EES_CGM_1024]<br>
	 * 
	 * @param chsNuPoolChargeINVO CHSNuPoolChargeINVO
	 * @return CHSNuPoolChargeMGTVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public CHSNuPoolChargeMGTVO searchCHSNuPoolChargeMainData(CHSNuPoolChargeINVO chsNuPoolChargeINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CHSNuPoolChargeMGTVO> list = null;
		CHSNuPoolChargeMGTVO chsNuPoolChargeMGTVO = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(chsNuPoolChargeINVO != null){
				Map<String, String> mapVO = chsNuPoolChargeINVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInvoiceDBDAOSearchCHSNuPoolChargeMainDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CHSNuPoolChargeMGTVO.class);
			
			if(list.size() > 0){
				chsNuPoolChargeMGTVO = new CHSNuPoolChargeMGTVO();
				chsNuPoolChargeMGTVO = list.get(0);
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return chsNuPoolChargeMGTVO;
	}
	 
	/**
	 * Payable Invoice Creation 紐⑸줉??媛?졇?⑤떎. [EES_CGM_1034]<br>
	 * 
	 * @param chsPayableInvoiceCreationINVO CHSPayableInvoiceCreationINVO
	 * @return List<CHSPayableInvoiceCreationMGTVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CHSPayableInvoiceCreationMGTVO> searchCHSInvoiceListData(CHSPayableInvoiceCreationINVO chsPayableInvoiceCreationINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CHSPayableInvoiceCreationMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(chsPayableInvoiceCreationINVO != null){
				Map<String, String> mapVO = chsPayableInvoiceCreationINVO.getColumnValues();
					
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInvoiceDBDAOSearchCHSInvoiceListDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CHSPayableInvoiceCreationMGTVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	 
	 
	/**
	 * Payable Invoice Creation ?곸꽭?뺣낫瑜?遺덈윭?⑤떎. [EES_CGM_1034]<br>
	 * 
	 * @param chsPayableInvoiceCreationINVO CHSPayableInvoiceCreationINVO
	 * @return List<CHSPayableInvoiceCreationMGTVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CHSPayableInvoiceCreationMGTVO> searchCHSInvoiceDetailData(CHSPayableInvoiceCreationINVO chsPayableInvoiceCreationINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CHSPayableInvoiceCreationMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(chsPayableInvoiceCreationINVO != null){
				Map<String, String> mapVO = chsPayableInvoiceCreationINVO.getColumnValues();
						
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInvoiceDBDAOSearchCHSInvoiceDetailDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CHSPayableInvoiceCreationMGTVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 
	/**
	 * Payable Invoice Creation ?곗씠?곕? ?쇨큵?곸쑝濡??섏젙?쒕떎. [EES_CGM_1034]<br>
	 * 
	 * @param chsPayableInvoiceCreationINVOs List<CHSPayableInvoiceCreationINVO>
	 * @exception DAOException
	 */
	public void modifyCHSInvoiceCreationData(List<CHSPayableInvoiceCreationINVO> chsPayableInvoiceCreationINVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(chsPayableInvoiceCreationINVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ChassisMgsetInvoiceDBDAOModifyCHSInvoiceCreationDataUSQL(), chsPayableInvoiceCreationINVOs,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	} 
	
	/**
	 * Payable Invoice Commit ?댁쟾 ?곹깭(P.Amt)濡?CGM_PAY_INV ?곗씠?곕? ?쇨큵?곸쑝濡??섏젙?쒕떎. [EES_CGM_1034]<br>
	 * 
	 * @param chsPayableInvoiceCreationINVOs List<CHSPayableInvoiceCreationINVO>
	 * @exception DAOException
	 */
	public void modifyCHSInvoiceDeleteData(List<CHSPayableInvoiceCreationINVO> chsPayableInvoiceCreationINVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(chsPayableInvoiceCreationINVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ChassisMgsetInvoiceDBDAOModifyCHSInvoiceDeleteDataUSQL(), chsPayableInvoiceCreationINVOs,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Payable Invoice Commit ?댁쟾 ?곹깭(P.Amt)濡?CGM_LSE_CHG_HDR ?곗씠?곕? ?쇨큵?곸쑝濡??섏젙?쒕떎. [EES_CGM_1034]<br>
	 * 
	 * @param chsPayableInvoiceCreationINVOs List<CHSPayableInvoiceCreationINVO>
	 * @exception DAOException
	 */
	public void modifyCHSInvoiceDeleteHdrData(List<CHSPayableInvoiceCreationINVO> chsPayableInvoiceCreationINVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(chsPayableInvoiceCreationINVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ChassisMgsetInvoiceDBDAOModifyCHSInvoiceDeleteHdrDataUSQL(), chsPayableInvoiceCreationINVOs,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * CGM_LSE_CHG_DTL ?뚯씠釉붿쓣 Charge Creation ?곹깭濡??쇨큵?곸쑝濡??섏젙?쒕떎. [EES_CGM_1034]<br>
	 * 
	 * @param CHSPayableInvoiceCreationINVOs List<CHSPayableInvoiceCreationINVO>
	 * @exception DAOException
	 */
	public void modifyCHSInvoiceDeleteDtlData(List<CHSPayableInvoiceCreationINVO> CHSPayableInvoiceCreationINVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(CHSPayableInvoiceCreationINVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ChassisMgsetInvoiceDBDAOModifyCHSInvoiceDeleteDtlDataUSQL(), CHSPayableInvoiceCreationINVOs,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * CGM_PAY_INV ?곗씠?곕? ?쇨큵?곸쑝濡???젣?쒕떎. [EES_CGM_1034]<br>
	 * 
	 * @param chsPayableInvoiceCreationINVOs List<CHSPayableInvoiceCreationINVO>
	 * @exception DAOException
	 */
	public void removeCHSInvoiceDeleteData(List<CHSPayableInvoiceCreationINVO> chsPayableInvoiceCreationINVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(chsPayableInvoiceCreationINVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ChassisMgsetInvoiceDBDAORemoveCHSInvoiceDeleteDataDSQL(), chsPayableInvoiceCreationINVOs,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Payable Invoice Creation ?먯꽌 AP_INV_MAIN ???섍만 媛믪쓣 議고쉶?쒕떎. [EES_CGM_1034]<br>
	 * 
	 * @param chsPayableInvoiceCreationINVO CHSPayableInvoiceCreationINVO
	 * @return List<CHSPayableInvoiceCreationMGTVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CHSPayableInvoiceCreationMGTVO> searchCHSInvoiceCreateMainData(CHSPayableInvoiceCreationINVO chsPayableInvoiceCreationINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CHSPayableInvoiceCreationMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(chsPayableInvoiceCreationINVO != null){
				Map<String, String> mapVO = chsPayableInvoiceCreationINVO.getColumnValues();
					
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInvoiceDBDAOSearchCHSInvoiceCreateMainDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CHSPayableInvoiceCreationMGTVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 
	/**
	 * Payable Invoice Creation ?먯꽌 AP_INV_DTL ???섍만 媛믪쓣 議고쉶?쒕떎. [EES_CGM_1034]<br>
	 * 
	 * @param chsPayableInvoiceCreationINVO CHSPayableInvoiceCreationINVO
	 * @return List<CHSPayableInvoiceCreationMGTVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CHSPayableInvoiceCreationMGTVO> searchCHSInvoiceCreateDetailData(CHSPayableInvoiceCreationINVO chsPayableInvoiceCreationINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CHSPayableInvoiceCreationMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(chsPayableInvoiceCreationINVO != null){
				Map<String, String> mapVO = chsPayableInvoiceCreationINVO.getColumnValues();
						
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInvoiceDBDAOSearchCHSInvoiceCreateDetailDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CHSPayableInvoiceCreationMGTVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	 
	 
	/**
	 * Payable Invoice Creation 紐⑸줉??媛?졇?⑤떎. [EES_CGM_2035]<br>
	 * 
	 * @param mgsPayableInvoiceCreationINVO MGSPayableInvoiceCreationINVO
	 * @return List<MGSPayableInvoiceCreationMGTVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<MGSPayableInvoiceCreationMGTVO> searchMGSInvoiceListData(MGSPayableInvoiceCreationINVO mgsPayableInvoiceCreationINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MGSPayableInvoiceCreationMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(mgsPayableInvoiceCreationINVO != null){
				Map<String, String> mapVO = mgsPayableInvoiceCreationINVO.getColumnValues();
						
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInvoiceDBDAOSearchMGSInvoiceListDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MGSPayableInvoiceCreationMGTVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	 
		 
	/**
	 * Payable Invoice Creation ?곸꽭?뺣낫瑜?遺덈윭?⑤떎. [EES_CGM_2035]<br>
	 * 
	 * @param mgsPayableInvoiceCreationINVO MGSPayableInvoiceCreationINVO
	 * @return List<MGSPayableInvoiceCreationMGTVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<MGSPayableInvoiceCreationMGTVO> searchMGSInvoiceDetailData(MGSPayableInvoiceCreationINVO mgsPayableInvoiceCreationINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MGSPayableInvoiceCreationMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(mgsPayableInvoiceCreationINVO != null){
				Map<String, String> mapVO = mgsPayableInvoiceCreationINVO.getColumnValues();
							
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInvoiceDBDAOSearchMGSInvoiceDetailDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MGSPayableInvoiceCreationMGTVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){ 
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
		 
	/**
	 * Payable Invoice Creation ?곗씠?곕? ?쇨큵?곸쑝濡??섏젙?쒕떎. [EES_CGM_2035]<br>
	 * 
	 * @param mgsPayableInvoiceCreationINVOs List<MGSPayableInvoiceCreationINVO>
	 * @exception DAOException
	 */
	public void modifyMGSInvoiceCreationData(List<MGSPayableInvoiceCreationINVO> mgsPayableInvoiceCreationINVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(mgsPayableInvoiceCreationINVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ChassisMgsetInvoiceDBDAOModifyMGSInvoiceCreationDataUSQL(), mgsPayableInvoiceCreationINVOs,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	} 
		
	/**
	 * Payable Invoice Commit ?댁쟾 ?곹깭(P.Amt)濡?CGM_PAY_INV ?곗씠?곕? ?쇨큵?곸쑝濡??섏젙?쒕떎. [EES_CGM_2035]<br>
	 * 
	 * @param mgsPayableInvoiceCreationINVOs List<MGSPayableInvoiceCreationINVO>
	 * @exception DAOException
	 */
	public void modifyMGSInvoiceDeleteData(List<MGSPayableInvoiceCreationINVO> mgsPayableInvoiceCreationINVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(mgsPayableInvoiceCreationINVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ChassisMgsetInvoiceDBDAOModifyMGSInvoiceDeleteDataUSQL(), mgsPayableInvoiceCreationINVOs,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
		
	/**
	 * Payable Invoice Commit ?댁쟾 ?곹깭(P.Amt)濡?CGM_LSE_CHG_HDR ?곗씠?곕? ?쇨큵?곸쑝濡??섏젙?쒕떎. [EES_CGM_2035]<br>
	 * 
	 * @param mgsPayableInvoiceCreationINVOs List<MGSPayableInvoiceCreationINVO>
	 * @exception DAOException
	 */
	public void modifyMGSInvoiceDeleteHdrData(List<MGSPayableInvoiceCreationINVO> mgsPayableInvoiceCreationINVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(mgsPayableInvoiceCreationINVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ChassisMgsetInvoiceDBDAOModifyMGSInvoiceDeleteHdrDataUSQL(), mgsPayableInvoiceCreationINVOs,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
		
	/**
	 * CGM_LSE_CHG_DTL ?뚯씠釉붿쓣 Charge Creation ?곹깭濡??쇨큵?곸쑝濡??섏젙?쒕떎. [EES_CGM_2035]<br>
	 * 
	 * @param mgsPayableInvoiceCreationINVOs List<MGSPayableInvoiceCreationINVO>
	 * @exception DAOException
	 */
	public void modifyMGSInvoiceDeleteDtlData(List<MGSPayableInvoiceCreationINVO> mgsPayableInvoiceCreationINVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(mgsPayableInvoiceCreationINVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ChassisMgsetInvoiceDBDAOModifyMGSInvoiceDeleteDtlDataUSQL(), mgsPayableInvoiceCreationINVOs,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
		
	/**
	 * CGM_PAY_INV ?곗씠?곕? ?쇨큵?곸쑝濡???젣?쒕떎. [EES_CGM_2035]<br>
	 * 
	 * @param mgsPayableInvoiceCreationINVOs List<MGSPayableInvoiceCreationINVO>
	 * @exception DAOException
	 */
	public void removeMGSInvoiceDeleteData(List<MGSPayableInvoiceCreationINVO> mgsPayableInvoiceCreationINVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(mgsPayableInvoiceCreationINVOs.size() > 0){   
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ChassisMgsetInvoiceDBDAORemoveMGSInvoiceDeleteDataDSQL(), mgsPayableInvoiceCreationINVOs,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
		
	/**
	 * Payable Invoice Creation ?먯꽌 AP_INV_MAIN ???섍만 媛믪쓣 議고쉶?쒕떎. [EES_CGM_2035]<br>
	 * 
	 * @param mgsPayableInvoiceCreationINVO MGSPayableInvoiceCreationINVO
	 * @return List<MGSPayableInvoiceCreationMGTVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<MGSPayableInvoiceCreationMGTVO> searchMGSInvoiceCreateMainData(MGSPayableInvoiceCreationINVO mgsPayableInvoiceCreationINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MGSPayableInvoiceCreationMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(mgsPayableInvoiceCreationINVO != null){
				Map<String, String> mapVO = mgsPayableInvoiceCreationINVO.getColumnValues();
						
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInvoiceDBDAOSearchMGSInvoiceCreateMainDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MGSPayableInvoiceCreationMGTVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
		 
	/**
	 * Payable Invoice Creation ?먯꽌 AP_INV_DTL ???섍만 媛믪쓣 議고쉶?쒕떎. [EES_CGM_2035]<br>
	 * 
	 * @param mgsPayableInvoiceCreationINVO MGSPayableInvoiceCreationINVO
	 * @return List<MGSPayableInvoiceCreationMGTVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<MGSPayableInvoiceCreationMGTVO> searchMGSInvoiceCreateDetailData(MGSPayableInvoiceCreationINVO mgsPayableInvoiceCreationINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MGSPayableInvoiceCreationMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(mgsPayableInvoiceCreationINVO != null){
				Map<String, String> mapVO = mgsPayableInvoiceCreationINVO.getColumnValues();
							
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInvoiceDBDAOSearchMGSInvoiceCreateDetailDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MGSPayableInvoiceCreationMGTVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	  
	 
	 
	/**
	 * ?붾퀎 Chassis 異붿젙寃곗궛 ?곗씠?곕? 議고쉶?쒕떎. [EES_CGM_1107]<br>
	 * 
	 * @param cHSEstimateExpenseINVO CHSEstimateExpenseINVO
	 * @return List<CHSEstimateExpenseMGTVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CHSEstimateExpenseMGTVO> searchCHSEstimateExpenseData(CHSEstimateExpenseINVO cHSEstimateExpenseINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CHSEstimateExpenseMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
			
		try{
			if(cHSEstimateExpenseINVO != null){
				Map<String, String> mapVO = cHSEstimateExpenseINVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInvoiceDBDAOsearchCHSEstimateExpenseDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CHSEstimateExpenseMGTVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}		 
	 
	/**
	 * ?붾퀎 Chassis 異붿젙寃곗궛 ?곗씠?곕? ?곗젙?쒕떎. [EES_CGM_1107]<br>
	 * 
	 * @param cHSEstimateExpenseINVO CHSEstimateExpenseINVO
	 * @return List<CHSEstimateExpenseMGTVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CHSEstimateExpenseMGTVO> searchCHSEstimateExpenseCalcData(CHSEstimateExpenseINVO cHSEstimateExpenseINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CHSEstimateExpenseMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
			
		try{
			if(cHSEstimateExpenseINVO != null){
				Map<String, String> mapVO = cHSEstimateExpenseINVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInvoiceDBDAOsearchCHSEstimateExpenseCalcDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CHSEstimateExpenseMGTVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}			 

	/**
	 * ?붾퀎 Chassis 異붿젙寃곗궛 Summary ?곗씠?곕? 議고쉶?쒕떎. [EES_CGM_1107]<br>
	 * 
	 * @param cHSEstimateExpenseINVO CHSEstimateExpenseINVO
	 * @return List<CHSEstimateExpenseMGTVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CHSEstimateExpenseMGTVO> searchCHSEstimateExpenseSummaryData(CHSEstimateExpenseINVO cHSEstimateExpenseINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CHSEstimateExpenseMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
			
		try{
			if(cHSEstimateExpenseINVO != null){
				Map<String, String> mapVO = cHSEstimateExpenseINVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInvoiceDBDAOsearchCHSEstimateExpenseSummaryDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CHSEstimateExpenseMGTVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}			 
	 
		 
	 
	/**
	 * ?붾퀎 Chassis 異붿젙寃곗궛 ?곗씠?곕? Insert ?쒕떎. [EES_CGM_1107].<br>
	 * 
	 * @param cHSEstimateExpenseINVO CHSEstimateExpenseINVO
	 * @exception DAOException
	 */
	public void addCHSEstimateExpenseCalcData (CHSEstimateExpenseINVO cHSEstimateExpenseINVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			//int delCnt[] = null;
			if(cHSEstimateExpenseINVO != null){
				Map<String, String> param = cHSEstimateExpenseINVO.getColumnValues();
				int result = sqlExe.executeUpdate((ISQLTemplate) new ChassisMgsetInvoiceDBDAOaddCHSEstimateExpenseCalcDataCSQL() , param, null);
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to Delete SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
    }
	
	/**
	 * ?붾퀎 Chassis 異붿젙寃곗궛 ?곗씠?곕? remove ?쒕떎. [EES_CGM_1107].<br>
	 * 
	 * @param cHSEstimateExpenseINVO CHSEstimateExpenseINVO
	 * @exception DAOException
	 */
	public void removeCHSEstimateExpenseCalcData (CHSEstimateExpenseINVO cHSEstimateExpenseINVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			//int delCnt[] = null;
			if(cHSEstimateExpenseINVO != null){
				Map<String, String> param = cHSEstimateExpenseINVO.getColumnValues();
				int result = sqlExe.executeUpdate((ISQLTemplate) new ChassisMgsetInvoiceDBDAOremoveCHSEstimateExpenseCalcDataDSQL() , param, null);
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to Delete SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
    }
	
	/**
	 * ?붾퀎 M.G. Set 異붿젙寃곗궛 ?곗씠?곕? 議고쉶?쒕떎. [EES_CGM_2206]<br>
	 * 
	 * @param mGSEstimateExpenseINVO MGSEstimateExpenseINVO
	 * @return List<MGSEstimateExpenseMGTVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<MGSEstimateExpenseMGTVO> searchMGSEstimateExpenseData(MGSEstimateExpenseINVO mGSEstimateExpenseINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MGSEstimateExpenseMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
			
		try{
			if(mGSEstimateExpenseINVO != null){
				Map<String, String> mapVO = mGSEstimateExpenseINVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInvoiceDBDAOsearchMGSEstimateExpenseDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MGSEstimateExpenseMGTVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}		 
	 
	/**
	 * ?붾퀎 M.G. Set 異붿젙寃곗궛 ?곗씠?곕? ?곗젙?쒕떎. [EES_CGM_2206]<br>
	 * 
	 * @param mGSEstimateExpenseINVO MGSEstimateExpenseINVO
	 * @return List<MGSEstimateExpenseMGTVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<MGSEstimateExpenseMGTVO> searchMGSEstimateExpenseCalcData(MGSEstimateExpenseINVO mGSEstimateExpenseINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MGSEstimateExpenseMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
			
		try{
			if(mGSEstimateExpenseINVO != null){
				Map<String, String> mapVO = mGSEstimateExpenseINVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInvoiceDBDAOsearchMGSEstimateExpenseCalcDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MGSEstimateExpenseMGTVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}			 
	 
	/**
	 * ?붾퀎 M.G. Set 異붿젙寃곗궛 Summary?곗씠?곕? 議고쉶?쒕떎. [EES_CGM_2206]<br>
	 * 
	 * @param mGSEstimateExpenseINVO MGSEstimateExpenseINVO
	 * @return List<MGSEstimateExpenseMGTVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<MGSEstimateExpenseMGTVO> searchMGSEstimateExpenseSummaryData(MGSEstimateExpenseINVO mGSEstimateExpenseINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MGSEstimateExpenseMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
			
		try{
			if(mGSEstimateExpenseINVO != null){
				Map<String, String> mapVO = mGSEstimateExpenseINVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInvoiceDBDAOsearchMGSEstimateExpenseSummaryDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MGSEstimateExpenseMGTVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	
	 
	/**
	 * ?붾퀎 M.G. Set 異붿젙寃곗궛 ?곗씠?곕? Insert ?쒕떎. [EES_CGM_2206].<br>
	 * 
	 * @param mGSEstimateExpenseINVO MGSEstimateExpenseINVO
	 * @exception DAOException
	 */
	public void addMGSEstimateExpenseCalcData (MGSEstimateExpenseINVO mGSEstimateExpenseINVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			//int delCnt[] = null;
			if(mGSEstimateExpenseINVO != null){
				Map<String, String> param = mGSEstimateExpenseINVO.getColumnValues();
				int result = sqlExe.executeUpdate((ISQLTemplate) new ChassisMgsetInvoiceDBDAOaddMGSEstimateExpenseCalcDataCSQL() , param, null);
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to Delete SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
    }
	
	/**
	 * ?붾퀎 M.G. Set 異붿젙寃곗궛 ?곗씠?곕? remove ?쒕떎. [EES_CGM_2206].<br>
	 * 
	 * @param mGSEstimateExpenseINVO MGSEstimateExpenseINVO
	 * @exception DAOException
	 */
	public void removeMGSEstimateExpenseCalcData (MGSEstimateExpenseINVO mGSEstimateExpenseINVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			//int delCnt[] = null;
			if(mGSEstimateExpenseINVO != null){
				Map<String, String> param = mGSEstimateExpenseINVO.getColumnValues();
				int result = sqlExe.executeUpdate((ISQLTemplate) new ChassisMgsetInvoiceDBDAOremoveMGSEstimateExpenseCalcDataDSQL() , param, null);
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to Delete SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
    }		
	
	/**
	 * CGN_PAY_INV ??Concidency ???대떦?섎뒗 Invoice No 媛?議댁옱?섎뒗吏?泥댄겕?쒕떎. [EES_CGM_1031]<br>
	 * 
	 * @param chsConfirmPayableAmountINVO CHSConfirmPayableAmountINVO
	 * @return int
	 * @exception DAOException
	 */
	public int checkCHSPayableInvoiceNoData(CHSConfirmPayableAmountINVO chsConfirmPayableAmountINVO) throws DAOException {
		DBRowSet dbRowset = null;
		int cnt = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
			
		try{
			if(chsConfirmPayableAmountINVO != null){
				Map<String, String> mapVO = chsConfirmPayableAmountINVO.getColumnValues();
					
				param.putAll(mapVO);
				velParam.putAll(mapVO);
					
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInvoiceDBDAOCheckCHSPayableInvoiceNoDataRSQL(), param, velParam);
			
				if(dbRowset.next()){
					cnt = dbRowset.getInt("cnt");
				}	
			}
				
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return cnt;
	}
	
	/**
	 * CGM_LSE_CHG_CMMT_CR_DTL 에 VO로 담아온 PK에 해당하는 Data가 존재가 하는지 Check한다. [EES_CGM_1205]<br>
	 * 
	 * @param CHSCpsInvoiceAuditResultCmmtCrMGTVO cHSCpsInvoiceAuditResultCmmtCrMGTVO
	 * @return int
	 * @exception DAOException
	 */
	public int checkCHSCpsInvoiceAuditResultCmmtCrData(CHSCpsInvoiceAuditResultCmmtCrMGTVO cHSCpsInvoiceAuditResultCmmtCrMGTVO) throws DAOException {
		DBRowSet dbRowset = null;
		int cnt = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
			
		try{
			if(cHSCpsInvoiceAuditResultCmmtCrMGTVO != null){
				Map<String, String> mapVO = cHSCpsInvoiceAuditResultCmmtCrMGTVO.getColumnValues();
					
				param.putAll(mapVO);
					
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInvoiceDBDAOCheckCHSCpsInvoiceAuditResultCmmtCrDataRSQL(), param, null);
			
				if(dbRowset.next()){
					cnt = dbRowset.getInt("cnt");
				}	
			}
				
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return cnt;
	}
	
	/**
	 * CGN_PAY_INV ??Concidency ???대떦?섎뒗 Invoice No 媛?議댁옱?섎뒗吏?泥댄겕?쒕떎. [EES_CGM_2098]<br>
	 * 
	 * @param mgsConfirmPayableAmountINVO MGSConfirmPayableAmountINVO
	 * @return int
	 * @exception DAOException
	 */
	public int checkMGSPayableInvoiceNoData(MGSConfirmPayableAmountINVO mgsConfirmPayableAmountINVO) throws DAOException {
		DBRowSet dbRowset = null;
		int cnt = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
			
		try{
			if(mgsConfirmPayableAmountINVO != null){
				Map<String, String> mapVO = mgsConfirmPayableAmountINVO.getColumnValues();
					
				param.putAll(mapVO);
				velParam.putAll(mapVO);
					
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInvoiceDBDAOCheckMGSPayableInvoiceNoDataRSQL(), param, velParam);
			
				if(dbRowset.next()){
					cnt = dbRowset.getInt("cnt");
				}	
			}
				
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return cnt;
	}
	
	/**
	 *  CGM_LSE_CHG_HDR ?곗씠?곗쓽 ?곹깭瑜?'C' 濡??섏젙?쒕떎. [EES_CGM_1034]<br>
	 * 
	 * @param chsPayableInvoiceCreationINVOs List<CHSPayableInvoiceCreationINVO>
	 * @exception DAOException
	 */
	public void modifyCHSInvoiceCreationHeaderData(List<CHSPayableInvoiceCreationINVO> chsPayableInvoiceCreationINVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(chsPayableInvoiceCreationINVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ChassisMgsetInvoiceDBDAOModifyCHSInvoiceCreationHeaderDataUSQL(), chsPayableInvoiceCreationINVOs,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * CGM_LSE_CHG_HDR ?곗씠?곗쓽 ?곹깭瑜?'C' 濡??섏젙?쒕떎. [EES_CGM_2035]<br>
	 * 
	 * @param mgsPayableInvoiceCreationINVOs List<MGSPayableInvoiceCreationINVO>
	 * @exception DAOException
	 */
	public void modifyMGSInvoiceCreationHeaderData(List<MGSPayableInvoiceCreationINVO> mgsPayableInvoiceCreationINVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(mgsPayableInvoiceCreationINVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ChassisMgsetInvoiceDBDAOModifyMGSInvoiceCreationHeaderDataUSQL(), mgsPayableInvoiceCreationINVOs,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Chassis??INVOICE瑜?Summary ?섏뿬 蹂댁뿬以?떎. [EES_CGM_1035]<br>
	 * 
	 * @param cHSInvoiceInquiryINVO CHSInvoiceInquiryINVO
	 * @return List<CHSInvoiceInquiryMGTVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CHSInvoiceInquiryMGTVO> searchCHSInvoiceInqListData (CHSInvoiceInquiryINVO cHSInvoiceInquiryINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CHSInvoiceInquiryMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(cHSInvoiceInquiryINVO != null){
				Map<String, String> mapVO = cHSInvoiceInquiryINVO.getColumnValues();
					
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInvoiceDBDAOsearchCHSInvoiceInqListDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CHSInvoiceInquiryMGTVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	 
	 
	/**
	 * Chassis??INVOICE Detail ?곗씠?곕? 蹂댁뿬以?떎. [EES_CGM_1035]<br>
	 * 
	 * @param cHSInvoiceInquiryINVO CHSInvoiceInquiryINVO
	 * @return List<CHSInvoiceInquiryMGTVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CHSInvoiceInquiryMGTVO> searchCHSInvoiceInqDtlData (CHSInvoiceInquiryINVO cHSInvoiceInquiryINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CHSInvoiceInquiryMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(cHSInvoiceInquiryINVO != null){
				Map<String, String> mapVO = cHSInvoiceInquiryINVO.getColumnValues();
						
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInvoiceDBDAOsearchCHSInvoiceInqDtlDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CHSInvoiceInquiryMGTVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	
	/**
	 * M.G.Set??INVOICE瑜?Summary ?섏뿬 蹂댁뿬以?떎. [EES_CGM_2036]<br>
	 * 
	 * @param mGSInvoiceInquiryINVO MGSInvoiceInquiryINVO
	 * @return List<MGSInvoiceInquiryMGTVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<MGSInvoiceInquiryMGTVO> searchMGSInvoiceInqListData (MGSInvoiceInquiryINVO mGSInvoiceInquiryINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MGSInvoiceInquiryMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(mGSInvoiceInquiryINVO != null){
				Map<String, String> mapVO = mGSInvoiceInquiryINVO.getColumnValues();
					
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInvoiceDBDAOsearchMGSInvoiceInqListDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MGSInvoiceInquiryMGTVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	 
	 
	/**
	 * M.G.Set??INVOICE Detail ?곗씠?곕? 蹂댁뿬以?떎. [EES_CGM_2036]<br>
	 * 
	 * @param mGSInvoiceInquiryINVO MGSInvoiceInquiryINVO
	 * @return List<MGSInvoiceInquiryMGTVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<MGSInvoiceInquiryMGTVO> searchMGSInvoiceInqDtlData (MGSInvoiceInquiryINVO mGSInvoiceInquiryINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MGSInvoiceInquiryMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(mGSInvoiceInquiryINVO != null){
				Map<String, String> mapVO = mGSInvoiceInquiryINVO.getColumnValues();
						
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInvoiceDBDAOsearchMGSInvoiceInqDtlDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MGSInvoiceInquiryMGTVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	 
	 
	 /**
	 * Cps Chassis Charge Creation ??긽 紐⑸줉??遺덈윭?⑤떎. [EES_CGM_1203]<br>
	 * 
	 * @param chsChargeCreationINVO CHSChargeCreationINVO
	 * @return List<CHSChargeCreationMGTVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CHSChargeCreationMGTVO> searchCHSCpsChargeCreationListData(CHSChargeCreationINVO chsChargeCreationINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CHSChargeCreationMGTVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (chsChargeCreationINVO != null) {
				Map<String, String> mapVO = chsChargeCreationINVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ChassisMgsetInvoiceDBDAOSearchCHSCpsChargeCreationListDataRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CHSChargeCreationMGTVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * Chassis CC(Charge Creation)?뺣낫??EXCEL?곗씠?곕? CGM_LSE_INV_TMP?뚯씠釉붿뿉 ?쇨큵 INSERT?쒕떎. [EES_CGM_1204]<br>
	 * 
	 * @param cHSInvoiceImportAuditINVOs List<CHSInvoiceImportAuditINVO>
	 * @exception DAOException
	 */
	public void addCHSCpsLeaseInvoiceData(List<CHSInvoiceImportAuditINVO> cHSInvoiceImportAuditINVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(cHSInvoiceImportAuditINVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ChassisMgsetInvoiceDBDAOaddCHSCpsLeaseInvoiceDataCSQL(), cHSInvoiceImportAuditINVOs,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * CGM_LSE_INV_TMP?뚯씠釉붿쓽 Chassis Verify ?곗씠?곕? 議고쉶?쒕떎. [EES_CGM_1204]<br>
	 * 
	 * @param cHSInvoiceImportAuditINVO CHSInvoiceImportAuditINVO
	 * @return List<CHSInvoiceImportAuditMGTVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CHSInvoiceImportAuditMGTVO> searchCHSCpsLeaseInvoiceVerifyData(CHSInvoiceImportAuditINVO cHSInvoiceImportAuditINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CHSInvoiceImportAuditMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(cHSInvoiceImportAuditINVO != null){
				Map<String, String> mapVO = cHSInvoiceImportAuditINVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInvoiceDBDAOSearchCHSCpsLeaseInvoiceVerifyDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CHSInvoiceImportAuditMGTVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 
	 /**
	 * Charge Creation Detail ?곗씠?곕? ?쇨큵?곸쑝濡???젣?쒕떎. [EES_CGM_1204]<br>
	 * 
	 * @param CHSInvoiceImportAuditINVO cHSInvoiceImportAuditINVO
	 * @exception DAOException
	 */
	public void removeCHSCpsChargeDetailData(CHSInvoiceImportAuditINVO cHSInvoiceImportAuditINVO) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");

			if (cHSInvoiceImportAuditINVO != null) {
				// query parameter
				Map<String, String> param = cHSInvoiceImportAuditINVO.getColumnValues();
				// ??젣
				int result = sqlExe.executeUpdate((ISQLTemplate) new ChassisMgsetInvoiceDBDAORemoveCHSChargeDetailDataDSQL(), param, null);

				if (result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");

			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Charge Creation Header ?곗씠?곕? ??젣?쒕떎. [EES_CGM_1204]<br>
	 * 
	 * @param CHSInvoiceImportAuditINVO cHSInvoiceImportAuditINVO
	 * @exception DAOException
	 */
	public void removeCHSCpsChargeSummaryData(CHSInvoiceImportAuditINVO cHSInvoiceImportAuditINVO) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");

			if (cHSInvoiceImportAuditINVO != null) {
				// query parameter
				Map<String, String> param = cHSInvoiceImportAuditINVO.getColumnValues();
				// ??젣
				int result = sqlExe.executeUpdate((ISQLTemplate) new ChassisMgsetInvoiceDBDAORemoveCHSChargeSummaryDataDSQL(), param, null);

				if (result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");

			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Chassis Lease Charge Header Creation [insert into CGM_LSE_CHG_HDR] [EES_CGM_1204]<br>
	 * 
	 * @param chsChargeCreationINVOs List<CHSChargeCreationINVO>
	 * @exception DAOException
	 */
	public void addCHSCpsChageCreateSummaryData(List<CHSChargeCreationINVO> chsChargeCreationINVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(chsChargeCreationINVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ChassisMgsetInvoiceDBDAOAddCHSChargeCreateSummaryDataZPCSQL(), chsChargeCreationINVOs,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Agreement Version No 瑜?議고쉶?쒕떎. [EES_CGM_1204]<br>
	 * 
	 * @param cHSInvoiceImportAuditINVO CHSInvoiceImportAuditINVO
	 * @return String 
	 * @exception DAOException
	 */
	public String searchCHSAgmtVerNoData(CHSInvoiceImportAuditINVO cHSInvoiceImportAuditINVO) throws DAOException {
		DBRowSet dbRowset = null;
		String result = "";
		int val = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(cHSInvoiceImportAuditINVO != null){
				Map<String, String> mapVO = cHSInvoiceImportAuditINVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInvoiceDBDAOSearchCHSAgmtSeqDataRSQL(), param, velParam);
			if(dbRowset.next()){
				val = dbRowset.getInt("agmt_ver_no");
			}
			result = val + "";
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	/**
	 * CGM_LSE_CHG_DTL ?뚯씠釉붿뿉 Invoice ?곗씠?곕? ?쇨큵?곸쑝濡??앹꽦?쒕떎. [EES_CGM_1204]<br>
	 * 
	 * @param CHSInvoiceImportAuditINVO chsInvoiceImportAuditINVO
	 * @exception DAOException
	 */
	public void addCHSCpsAuditInvoiceDetailData(CHSInvoiceImportAuditINVO chsInvoiceImportAuditINVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(chsInvoiceImportAuditINVO != null){
				//query parameter
		        Map<String, String> param = chsInvoiceImportAuditINVO.getColumnValues();
		        //??젣 
		        int result = sqlExe.executeUpdate((ISQLTemplate) new ChassisMgsetInvoiceDBDAOAddCHSCpsAuditInvoiceDetailDataCSQL() , param, null);

				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
				
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * CGM_LSE_CHG_DTL ?뚯씠釉붿쓽 LSE_CHG_AUD_STS_CD 而щ읆 媛믪쓽 ?곕씪 Data瑜?媛?졇?⑤떎.<br>
	 * - Coincidence : C Discrepancy : D Invoice Only : I [EES_CGM_1205]<br>
	 * @param CHSCpsPayableInvoiceCreationINVO chsCpsPayableInvoiceCreationINVO
	 * @return List<CHSCpsPayableInvoiceCreationMGTVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CHSCpsPayableInvoiceCreationMGTVO> searchCHSCpsAuditStatusData(CHSCpsPayableInvoiceCreationINVO chsCpsPayableInvoiceCreationINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CHSCpsPayableInvoiceCreationMGTVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (chsCpsPayableInvoiceCreationINVO != null) {
				Map<String, String> mapVO = chsCpsPayableInvoiceCreationINVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ChassisMgsetInvoiceDBDAOSearchCHSCpsAuditStatusDataRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CHSCpsPayableInvoiceCreationMGTVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * CPS payable amount confirm 화면에서 화면 open 시 선택된 Agreement Audit result 를 조회한다.(Chassis) [EES_CGM_1205]<br>
	 * Invoice Type : Min Commitment[CMT], MH Credit[MCD]
	 * 
	 * @param String agmtOfcCtyCd
	 * @param String agmtSeq
	 * @param String agmtVerNo
	 * @param String costYrmon
	 * @param String costYrmonSeq 
	 * @return List<CHSCpsInvoiceAuditResultCmmtCrMGTVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CHSCpsInvoiceAuditResultCmmtCrMGTVO> searchCHSCpsInvoiceAuditResultCmmtCrData(String agmtOfcCtyCd, String agmtSeq, String agmtVerNo, String costYrmon, String costYrmonSeq) throws DAOException {
		DBRowSet dbRowset = null;
		List<CHSCpsInvoiceAuditResultCmmtCrMGTVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("agmt_ofc_cty_cd", agmtOfcCtyCd);
			mapVO.put("agmt_seq", agmtSeq);
			mapVO.put("agmt_ver_no", agmtVerNo);
			mapVO.put("cost_yrmon", costYrmon);
			mapVO.put("cost_yrmon_seq", costYrmonSeq);

			param.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ChassisMgsetInvoiceDBDAOsearchCHSCpsInvoiceAuditResultCmmtCrDataRSQL(), param, null);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CHSCpsInvoiceAuditResultCmmtCrMGTVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * CGM_LSE_CHG_CMMT_CR_DTL에 Data(Min Commitment / MH Credit)를 insert한다. [EES_CGM_1205]<br>
	 * 
	 * @param List<CHSCpsInvoiceAuditResultCmmtCrMGTVO> cHSCpsInvoiceAuditResultCmmtCrMGTVOs
	 * @exception DAOException
	 */
	public void addCHSCpsInvoiceAuditResultCmmtCrData(List<CHSCpsInvoiceAuditResultCmmtCrMGTVO> cHSCpsInvoiceAuditResultCmmtCrMGTVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(cHSCpsInvoiceAuditResultCmmtCrMGTVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ChassisMgsetInvoiceDBDAOAddCHSCpsInvoiceAuditResultCmmtCrDataCSQL(), cHSCpsInvoiceAuditResultCmmtCrMGTVOs,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * CGM_LSE_CHG_CMMT_CR_DTL에 Data(Min Commitment / MH Credit)를 update한다. [EES_CGM_1205]<br>
	 * 
	 * @param List<CHSCpsInvoiceAuditResultCmmtCrMGTVO> cHSCpsInvoiceAuditResultCmmtCrMGTVOs
	 * @exception DAOException
	 */
	public void modifyCHSCpsInvoiceAuditResultCmmtCrData(List<CHSCpsInvoiceAuditResultCmmtCrMGTVO> cHSCpsInvoiceAuditResultCmmtCrMGTVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(cHSCpsInvoiceAuditResultCmmtCrMGTVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ChassisMgsetInvoiceDBDAOModifyCHSCpsInvoiceAuditResultCmmtCrDataUSQL(), cHSCpsInvoiceAuditResultCmmtCrMGTVOs,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modify No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * CGM_LSE_CHG_DTL ?뚯씠釉붿뿉??Concidency ?곹깭濡??쇨큵?곸쑝濡?媛깆떊?쒕떎. [EES_CGM_1205]<br>
	 * 
	 * @param List<CHSCpsPayableInvoiceCreationINVO> chsCpsPayableInvoiceCreationINVOs
	 * @exception DAOException
	 */
	public void modifyCHSCpsAuditInvoiceConcidenceData(List<CHSCpsPayableInvoiceCreationINVO> chsCpsPayableInvoiceCreationINVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(chsCpsPayableInvoiceCreationINVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ChassisMgsetInvoiceDBDAOModifyCHSAuditInvoiceCoincidenceDataUSQL(), chsCpsPayableInvoiceCreationINVOs,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * CGM_LSE_CHG_DTL ?뚯씠釉붿뿉??Decrepancy ??remark ?뺣낫瑜??쇨큵?곸쑝濡?媛깆떊?쒕떎. [EES_CGM_1205]<br>
	 * 
	 * @param List<CHSCpsPayableInvoiceCreationINVO> chsCpsPayableInvoiceCreationINVOs
	 * @exception DAOException
	 */
	public void modifyCHSCpsAuditInvoiceDiscrepancyData(List<CHSCpsPayableInvoiceCreationINVO> chsCpsPayableInvoiceCreationINVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(chsCpsPayableInvoiceCreationINVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ChassisMgsetInvoiceDBDAOModifyCHSAuditInvoiceDiscrepancyDataUSQL(), chsCpsPayableInvoiceCreationINVOs,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * CGM_LSE_CHG_DTL ?뚯씠釉붿뿉 Invoice Only ???곗씠?곕? ?쇨큵?곸쑝濡???젣?쒕떎. [EES_CGM_1205]<br>
	 * 
	 * @param List<CHSCpsPayableInvoiceCreationINVO> chsCpsPayableInvoiceCreationINVOs
	 * @exception DAOException
	 */
	public void removeCHSCpsAuditInvoiceOnlyDetailData(List<CHSCpsPayableInvoiceCreationINVO> chsCpsPayableInvoiceCreationINVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(chsCpsPayableInvoiceCreationINVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ChassisMgsetInvoiceDBDAOremoveCHSAuditInvoiceOnlyDetailDataDSQL(), chsCpsPayableInvoiceCreationINVOs,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * CGM_LSE_CHG_DTL ?뚯씠釉붿뿉 Coincidence ???곗씠?곕? ?쇨큵?곸쑝濡??앹꽦?쒕떎. [EES_CGM_1205]<br>
	 * 
	 * @param List<CHSCpsPayableInvoiceCreationINVO> chsCpsPayableInvoiceCreationINVOs
	 * @exception DAOException
	 */
	public void addCHSCpsAuditCoincidenceDetailData(List<CHSCpsPayableInvoiceCreationINVO> chsCpsPayableInvoiceCreationINVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(chsCpsPayableInvoiceCreationINVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ChassisMgsetInvoiceDBDAOAddCHSCpsAuditCoincidenceDetailDataCSQL(), chsCpsPayableInvoiceCreationINVOs,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * CGM_LSE_CHG_DTL ?뚯씠釉붿뿉 Invoice Only ???곗씠??以?Remark瑜??ы븿???곗씠?곕뱾???쇨큵?곸쑝濡??섏젙?쒕떎. [EES_CGM_1205]<br>
	 * 
	 * @param List<CHSCpsPayableInvoiceCreationINVO> chsCpsPayableInvoiceCreationINVOs
	 * @exception DAOException
	 */
	public void modifyCHSCpsAuditInvoiceOnlyDetailData(List<CHSCpsPayableInvoiceCreationINVO> chsCpsPayableInvoiceCreationINVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(chsCpsPayableInvoiceCreationINVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ChassisMgsetInvoiceDBDAOModifyCHSCpsAuditInvoiceOnlyDetailDataUSQL(), chsCpsPayableInvoiceCreationINVOs,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * CGM_LSE_CHG_HDR ?뚯씠釉붿뿉??INV_SMRY_AMT, CR_SMRY_AMT, TAX_SMRY_AMT ?뺣낫瑜?媛깆떊?쒕떎. [EES_CGM_1205]<br>
	 * 
	 * @param List<CHSCpsPayableInvoiceCreationINVO> chsCpsPayableInvoiceCreationINVOs
	 * @exception DAOException
	 */
	public void modifyCHSCpsInvoiceAuditResultHeaderData(List<CHSCpsPayableInvoiceCreationINVO> chsCpsPayableInvoiceCreationINVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(chsCpsPayableInvoiceCreationINVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ChassisMgsetInvoiceDBDAOModifyCHSInvoiceAuditResultHeaderDataUSQL(), chsCpsPayableInvoiceCreationINVOs,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * CGM_PAY_INV ?뚯씠釉붿쓽 ?곗씠??CPS)瑜??앹꽦?쒕떎. [EES_CGM_1205]<br>
	 * 
	 * @param chsConfirmPayableAmountINVO CHSConfirmPayableAmountINVO
	 * @exception DAOException
	 */
	public void addCHSCpsPayableAmountData(CHSConfirmPayableAmountINVO chsConfirmPayableAmountINVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(chsConfirmPayableAmountINVO != null){
				//query parameter
		        Map<String, String> param = chsConfirmPayableAmountINVO.getColumnValues();
		        //??젣 
		        int result = sqlExe.executeUpdate((ISQLTemplate) new ChassisMgsetInvoiceDBDAOAddCHSCpsPayableAmountDataCSQL() , param, null);
				
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to Insert SQL");
				
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Payable Invoice Creation 紐⑸줉??媛?졇?⑤떎. [EES_CGM_1207]<br>
	 * 
	 * @param chsPayableInvoiceCreationINVO CHSPayableInvoiceCreationINVO
	 * @return List<CHSPayableInvoiceCreationMGTVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CHSPayableInvoiceCreationMGTVO> searchCHSCpsInvoiceListData(CHSPayableInvoiceCreationINVO chsPayableInvoiceCreationINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CHSPayableInvoiceCreationMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(chsPayableInvoiceCreationINVO != null){
				Map<String, String> mapVO = chsPayableInvoiceCreationINVO.getColumnValues();
					
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInvoiceDBDAOSearchCHSCpsInvoiceListDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CHSPayableInvoiceCreationMGTVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	 }
	 
	 /**
	  * Payable Invoice Creation ?곸꽭?뺣낫瑜?遺덈윭?⑤떎. [EES_CGM_1207]<br>
	  * 
      * @param chsPayableInvoiceCreationINVO CHSPayableInvoiceCreationINVO
	  * @return List<CHSPayableInvoiceCreationMGTVO>
	  * @exception DAOException
	  */
	  @SuppressWarnings("unchecked")
	 public List<CHSPayableInvoiceCreationMGTVO> searchCHSCpsInvoiceDetailData(CHSPayableInvoiceCreationINVO chsPayableInvoiceCreationINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CHSPayableInvoiceCreationMGTVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (chsPayableInvoiceCreationINVO != null) {
				Map<String, String> mapVO = chsPayableInvoiceCreationINVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ChassisMgsetInvoiceDBDAOSearchCHSCpsInvoiceDetailDataRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CHSPayableInvoiceCreationMGTVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	/**
	 * CGM_LSE_CHG_HDR ?뚯씠釉붿뿉??LSE_CHG_SMRY_AMT, INV_SMRY_AMY, CR_SMRY_AMT, TAX_SMRY_AMT, LSE_CHG_STS_CD ?곗씠?곕?
	 * ?섏젙?쒕떎. [EES_CGM_1205]<br>
	 * 
	 * @param chsConfirmPayableAmountINVO CHSConfirmPayableAmountINVO
	 * @exception DAOException
	 */
	public void modifyCHSCpsPayableAmountHeaderData(CHSConfirmPayableAmountINVO chsConfirmPayableAmountINVO) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");

			if (chsConfirmPayableAmountINVO != null) {
				// query parameter
				Map<String, String> param = chsConfirmPayableAmountINVO.getColumnValues();
				// ??젣
				int result = sqlExe.executeUpdate((ISQLTemplate) new ChassisMgsetInvoiceDBDAOModifyCHSCpsInvoiceAuditResultHeaderDataUSQL(), param, null);

				if (result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");

			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	* ?꾩옱?쇱쓣 湲곗??쇰줈 -3?? ?꾩옱????議고쉶<br>
	* 
	* @return CHSPoolSCCReportINVO
	* @exception DAOException
	*/
	@SuppressWarnings("unchecked")
	public CHSPoolSCCReportINVO searchDefaultMonthWeek() throws DAOException {
		DBRowSet dbRowset = null;
		List<CHSPoolSCCReportINVO> list = null;
		try{

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInvoiceDBDAOsearchDefaultMonthWeekRSQL(), null, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CHSPoolSCCReportINVO.class);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list.get(0);
	}	
	
	/**
	 * 二쇱뼱吏?湲곌컙???꾩썡 紐⑸줉??議고쉶<br>
	 * 
	 * @param CHSPoolSCCReportINVO chsPoolSCCReportINVO
	 * @return List<CHSPoolSCCReportMGTVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CHSPoolSCCReportMGTVO> searchMonthList(CHSPoolSCCReportINVO chsPoolSCCReportINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CHSPoolSCCReportMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(chsPoolSCCReportINVO != null){
				chsPoolSCCReportINVO.unDataFormat();
				Map<String, String> mapVO = chsPoolSCCReportINVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInvoiceDBDAOsearchMonthListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CHSPoolSCCReportMGTVO.class);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	
	
	/**
	 * Chassis Amount Pool?⑥쐞 議고쉶 <br>
	 * 
	 * @param CHSPoolSCCReportINVO chsPoolSCCReportINVO
	 * @return List<CHSPoolSCCReportMGTVO>
	 * @exception EventException
	 */
	 @SuppressWarnings("unchecked")
	public List<CHSPoolSCCReportMGTVO> searchCHSPoolReportData(CHSPoolSCCReportINVO chsPoolSCCReportINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CHSPoolSCCReportMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(chsPoolSCCReportINVO != null){
				String fromBseDt = chsPoolSCCReportINVO.getFromBseDt().replaceAll("-", "");
				String toBseDt   = chsPoolSCCReportINVO.getToBseDt().replaceAll("-", "");
				chsPoolSCCReportINVO.setFromBseDt(fromBseDt);
				chsPoolSCCReportINVO.setToBseDt(toBseDt);
				Map<String, String> mapVO = chsPoolSCCReportINVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
	 			// Lessor ?ㅼ쨷議곌굔 ?곸슜
	 			List arr_vndr_seq = Utils.replaceStrToList(chsPoolSCCReportINVO.getSearchVndrSeq());
	 			velParam.put("arr_vndr_seq", arr_vndr_seq);	 			
	 			
	 			// Yard ?ㅼ쨷議곌굔 ?곸슜
	 			List arr_yd_cd = Utils.replaceStrToList(chsPoolSCCReportINVO.getSearchYdCd());
	 			velParam.put("arr_yd_cd", arr_yd_cd);	 		 			
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInvoiceDBDAOsearchCHSPoolReportDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CHSPoolSCCReportMGTVO.class);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	


	 /**
	  * Chassis Amount S/C NO 議고쉶 <br>
	  * 
	  * @param CHSSCNOReportINVO chsSCNOReportINVO
	  * @return List<CHSSCNOReportMGTVO>
	  * @exception EventException
	  */
	  @SuppressWarnings("unchecked")
	 public List<CHSSCNOReportMGTVO> searchCHSSCNOReportData(CHSSCNOReportINVO chsSCNOReportINVO) throws DAOException {
	 	DBRowSet dbRowset = null;
	 	List<CHSSCNOReportMGTVO> list = null;
	 	//query parameter
	 	Map<String, Object> param = new HashMap<String, Object>();
	 	//velocity parameter
	 	Map<String, Object> velParam = new HashMap<String, Object>();
	 	try{
	 		if(chsSCNOReportINVO != null){
	 			String fromBseDt = chsSCNOReportINVO.getFromBseDt().replaceAll("-", "");
	 			String toBseDt   = chsSCNOReportINVO.getToBseDt().replaceAll("-", "");
	 			chsSCNOReportINVO.setFromBseDt(fromBseDt);
	 			chsSCNOReportINVO.setToBseDt(toBseDt);
	 			Map<String, String> mapVO = chsSCNOReportINVO.getColumnValues();
	 			
	 			param.putAll(mapVO);
	 			velParam.putAll(mapVO);
	 				 			
	 			// S/C No ?ㅼ쨷議곌굔 ?곸슜
	 			List arr_sc_cd = Utils.replaceStrToList(chsSCNOReportINVO.getSearchScNo());
	 			velParam.put("arr_sc_cd", 		arr_sc_cd);	 	

	 			// Yard Code ?ㅼ쨷議곌굔 ?곸슜
	 			List arr_yd_cd = Utils.replaceStrToList(chsSCNOReportINVO.getSearchYdCd());
	 			velParam.put("arr_yd_cd", 		arr_yd_cd);	 
	 			
//	 			//硫?떚濡??섏뼱??媛?SC NO
//				String scNo = chsSCNOReportINVO.getScNo();
//				List<String> scNoList = new ArrayList<String>();
//				StringTokenizer st3 = new StringTokenizer(scNo, ",");
//				if(!("").equals(scNo)) {
//					while (st3.hasMoreTokens()) {
//						scNoList.add(st3.nextToken());
//					}
//					velParam.put("sc_no_list",  scNoList);
//				} else {
//					velParam.put("sc_no_list",  "");
//				}
	 		}
	 		
	 		dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInvoiceDBDAOsearchCHSSCNOReportDataRSQL(), param, velParam);
	 		list = (List)RowSetUtil.rowSetToVOs(dbRowset, CHSSCNOReportMGTVO.class);
	 		
	 	}catch(SQLException se){
	 		log.error(se.getMessage(),se);
	 		throw new DAOException(new ErrorHandler(se).getMessage());
	 	}catch(Exception ex){
	 		log.error(ex.getMessage(),ex);
	 		throw new DAOException(new ErrorHandler(ex).getMessage());
	 	}
	 	return list;
	 }	
	  
	  
	/**
	 * Chassis Exception Qinquiry list 議고쉶<br>
	 * 
	 * @param CHSScExceptionINVO cHSScExceptionINVO
	 * @return List<CHSScExceptionINVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CHSScExceptionINVO> searchCHSSCExceptionService(CHSScExceptionINVO cHSScExceptionINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CHSScExceptionINVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(cHSScExceptionINVO != null){
				Map<String, String> mapVO = cHSScExceptionINVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//SC No. Velocity ?뚮씪誘명꽣 援ъ꽦 
				if(!cHSScExceptionINVO.getScNo().equals("")){
					String scNo = cHSScExceptionINVO.getScNo();
					List<String> scNoList = new ArrayList<String>();
					StringTokenizer st = new StringTokenizer(scNo, ",");
				    while (st.hasMoreTokens()) {
				    	scNoList.add(st.nextToken());
				    }
				    velParam.put("sc_no", scNoList);
				}
				
				//Location Code Velocity ?뚮씪誘명꽣 援ъ꽦 
				if(!cHSScExceptionINVO.getLocCd().equals("")){
					String locCd = cHSScExceptionINVO.getLocCd();
					List<String> locCdList = new ArrayList<String>();
					StringTokenizer st = new StringTokenizer(locCd, ",");
				    while (st.hasMoreTokens()) {
				    	locCdList.add(st.nextToken());
				    }
				    velParam.put("loc_cd", locCdList);
				}

			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInvoiceDBDAOSearchSCExceptionRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CHSScExceptionINVO.class);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	
	/**
	  * SCC瑜?泥댄겕 ?⑸땲?? <br>
	  *
	  * @param CHSScExceptionINVO cHSScExceptionINVO
	  * @return List<CHSScExceptionINVO>
	  * @exception DAOException
	  */
	@SuppressWarnings("unchecked")
	public List<CHSScExceptionINVO> searchVerifySccService(CHSScExceptionINVO cHSScExceptionINVO) throws DAOException {
		DBRowSet dbRowset = null;   
		List<CHSScExceptionINVO> list = null;   
		
		//query parameter      
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter 
		Map<String, Object> velParam = new HashMap<String, Object>();
	    	               
		try{   
			Map<String, String> mapVO = cHSScExceptionINVO.getColumnValues();
					
			param.putAll(mapVO);       	 	            
			velParam.putAll(mapVO); 
			
			List<String> locCds = new ArrayList(); 
			String[] arraylocCd =  cHSScExceptionINVO.getLocCd().split(",");
			
			for(int i = 0; i < arraylocCd.length; i ++){      
				locCds.add(arraylocCd[i]); 	      
			} 		
					
			param.put("locCd", locCds);     	  	                    
			velParam.put("locCd", locCds);   
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInvoiceDBDAOSearchSCCInfoDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CHSScExceptionINVO .class);  
		}catch(SQLException se){  
			log.error(se.getMessage(),se); 
			throw new DAOException(new ErrorHandler(se).getMessage()); 
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}     
		return list;    
	}
	
	/**
	  * SCNo.瑜?泥댄겕 ?⑸땲?? <br>
	  *
	  * @param CHSScExceptionINVO cHSScExceptionINVO
	  * @return List<CHSScExceptionINVO>
	  * @exception DAOException
	  */
	@SuppressWarnings("unchecked")
	public List<CHSScExceptionINVO> searchVerifyScNoService(CHSScExceptionINVO cHSScExceptionINVO) throws DAOException {
		DBRowSet dbRowset = null;   
		List<CHSScExceptionINVO> list = null;   
		
		//query parameter      
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter 
		Map<String, Object> velParam = new HashMap<String, Object>();
	    	               
		try{   
			Map<String, String> mapVO = cHSScExceptionINVO.getColumnValues();
					
			param.putAll(mapVO);       	 	            
			velParam.putAll(mapVO); 
			
			List<String> scNos = new ArrayList(); 
			String[] arrayscNo =  cHSScExceptionINVO.getScNo().split(",");
			
			for(int i = 0; i < arrayscNo.length; i ++){      
				scNos.add(arrayscNo[i]); 	      
			} 		
					
			param.put("scNo", scNos);     	  	                    
			velParam.put("scNo", scNos);   
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInvoiceDBDAOSearchSCNoInfoDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CHSScExceptionINVO .class);  
		}catch(SQLException se){  
			log.error(se.getMessage(),se); 
			throw new DAOException(new ErrorHandler(se).getMessage()); 
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}     
		return list;    
	}
	
	/**
	 * "CGM_LSE_INV_TMP"."CHG_CRE_SEQ"의 MAX Value를 Search하여 전달.<br>
	 *
	 * @return int
	 * @exception DAOException
	 */
	public int getMaxSeqAuditResultUpdate() throws DAOException {
		DBRowSet dbRowset = null;
		int maxSeq = 0;
		
		try{
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInvoiceDBDAOGetMaxSeqAuditResultUpdateRSQL(), null, null);
			
			if(dbRowset.next()){
				maxSeq = dbRowset.getInt("MAX_SEQ");
			}
			
			return maxSeq;
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 데이터를 CGM_LSE_INV_TMP에 insert. <br>
	 *
	 * @param List<CHSCpsAuditResultUpdateINVO> cHSCpsAuditResultUpdateINVOS
	 * @return int
	 * @exception DAOException,Exception
	 */
	public int insertAuditResultUpdate(List<CHSCpsAuditResultUpdateINVO> cHSCpsAuditResultUpdateINVOS) throws DAOException,Exception {
//		try {
//			SQLExecuter sqlExe = new SQLExecuter("");
//			
//			if(cHSCpsAuditResultUpdateINVO != null){
//				//query parameter
//				Map<String, String> param = cHSCpsAuditResultUpdateINVO.getColumnValues();
//				param.put("account_id", account.getUsr_id());
//				param.put("max_seq", Integer.toString(maxSeq));
//				
//				//insert
//				int result = sqlExe.executeUpdate((ISQLTemplate) new ChassisMgsetInvoiceDBDAOAddCHSCpsAuditResultUpdateDataCSQL() , param, null);
//				
//				if(result == Statement.EXECUTE_FAILED)
//					throw new DAOException("Fail to insert " + cHSCpsAuditResultUpdateINVO.getSeq() + " SQL");
//				
//			}
//		}
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = new int[0];
			if(cHSCpsAuditResultUpdateINVOS.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ChassisMgsetInvoiceDBDAOAddCHSCpsAuditResultUpdateDataCSQL(), cHSCpsAuditResultUpdateINVOS,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
			return insCnt.length;
		}
		catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * CGM_LSE_INV_TMP에 insert된 데이터를 CGM_LSE_CHG_DTL와 비교 Check한 <br>
	 * 데이터 List를 조회 후 전달 <br>
	 *
	 * @param int maxSeq
	 * @param String costYrmon
	 * @param String costYrmonSeq
	 * @param String agmtOfcCtyCd
	 * @param String agmtSeq
	 * @param String agmtVerNo
	 * @return List<CHSCpsAuditResultUpdateMGTVO>
	 * @exception EventException
	 */ 
	@SuppressWarnings("unchecked")
	public List<CHSCpsAuditResultUpdateMGTVO> checkAuditResultUpdate(int maxSeq, String costYrmon, String costYrmonSeq, String agmtOfcCtyCd, String agmtSeq, String agmtVerNo) throws DAOException {
		DBRowSet dbRowset = null;   
		List<CHSCpsAuditResultUpdateMGTVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("max_seq", maxSeq);
			param.put("cost_yrmon", costYrmon);
			param.put("cost_yrmon_seq", Integer.parseInt(costYrmonSeq));
			param.put("agmt_ofc_cty_cd", agmtOfcCtyCd);
			param.put("agmt_seq", Integer.parseInt(agmtSeq));
			param.put("agmt_ver_no", Integer.parseInt(agmtVerNo));
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInvoiceDBDAOCheckAuditResultUpdateRSQL(), param, null);

			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CHSCpsAuditResultUpdateMGTVO.class);
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return list;
	}
	
	/**
	 * 데이터를 CGM_LSE_CHG_DTL에 update. <br>
	 *
	 * @param List<CHSCpsAuditResultUpdateINVO> cHSCpsAuditResultUpdateINVOS
	 * @param SignOnUserAccount account
	 * @return int
	 * @exception EventException
	 */
	public int updateAuditResultUpdate(List<CHSCpsAuditResultUpdateINVO> cHSCpsAuditResultUpdateINVOS, SignOnUserAccount account) throws DAOException,Exception {
		try {
			int updCnt[] = new int[0];
			SQLExecuter sqlExe = new SQLExecuter("");
			if(cHSCpsAuditResultUpdateINVOS.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ChassisMgsetInvoiceDBDAOModifyAuditResultUpdateUSQL(), cHSCpsAuditResultUpdateINVOS,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
			return updCnt.length; 
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Invoice import 화면에서 Usage/Rebill를 제외한 Invoice Type을 Save한다. : Only CGM_LSE_CHG_HDR (Chassis)[EES_CGM_1204]<br>
	 * 
	 * @param CHSChargeCreationINVO cHSChargeCreationINVO
	 * @exception DAOException
	 */
	public void addCHSCpsInvoiceDraft(CHSChargeCreationINVO cHSChargeCreationINVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");

			if (cHSChargeCreationINVO != null) {
				//query parameter
				Map<String, String> param = cHSChargeCreationINVO.getColumnValues();
				
				int result = sqlExe.executeUpdate((ISQLTemplate) new ChassisMgsetInvoiceDBDAOAddCHSChargeCreateSummaryDataZPCSQL(), param, null);
				
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to Insert SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * CGM_LSE_CHG_DTL테이블 LSE_CHG_AUD_STS_CD = 'I' 데이터를 삭제. [EES_CGM_1025]<br>
	 * 
	 * @param CHSCpsPayableInvoiceCreationINVO cHSCpsPayableInvoiceCreationINVO
	 * @exception DAOException
	 */
	public void removeCHSCpsPayableAddInvOnlyData(CHSCpsPayableInvoiceCreationINVO cHSCpsPayableInvoiceCreationINVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(cHSCpsPayableInvoiceCreationINVO != null){
				//query parameter
		        Map<String, String> param = cHSCpsPayableInvoiceCreationINVO.getColumnValues();
		        //??젣 
		        int result = sqlExe.executeUpdate((ISQLTemplate) new ChassisMgsetInvoiceDBDAORemoveCHSPayableAddInvOnlyDataDSQL() , param, null);
				
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to Remove SQL");
				
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * CGM_LSE_CHG_DTL 테이블 데이터를 Invoice Import & Audit 상태로 변경. [EES_CGM_1025]<br>
	 * 
	 * @param CHSCpsPayableInvoiceCreationINVO cHSCpsPayableInvoiceCreationINVO
	 * @exception DAOException
	 */
	public void modifyCHSCpsPayableChgDtlCancelData(CHSCpsPayableInvoiceCreationINVO cHSCpsPayableInvoiceCreationINVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(cHSCpsPayableInvoiceCreationINVO != null){
				//query parameter
		        Map<String, String> param = cHSCpsPayableInvoiceCreationINVO.getColumnValues();
		        //?ㅽ뻾
		        int result = sqlExe.executeUpdate((ISQLTemplate) new ChassisMgsetInvoiceDBDAOModifyCHSPayableChgDtlCancelDataUSQL() , param, null);
				
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to Update SQL");
				
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * CGM_LSE_CHG_HDR 테이블 데이터를 Invoice Import & Audit 상태로 변경. [EES_CGM_1025]<br>
	 * 
	 * @param CHSCpsPayableInvoiceCreationINVO cHSCpsPayableInvoiceCreationINVO
	 * @exception DAOException
	 */
	public void modifyCHSCpsPayableChgHdrCancelData(CHSCpsPayableInvoiceCreationINVO cHSCpsPayableInvoiceCreationINVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(cHSCpsPayableInvoiceCreationINVO != null){
				//query parameter
		        Map<String, String> param = cHSCpsPayableInvoiceCreationINVO.getColumnValues();
		        //?ㅽ뻾 
		        int result = sqlExe.executeUpdate((ISQLTemplate) new ChassisMgsetInvoiceDBDAOModifyCHSPayableChgHdrCancelDataUSQL() , param, null);
				
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to Update SQL");
				
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Invoice 데이터를 삭제(CGM_PAY_INV). [EES_CGM_1025]<br>
	 * 
	 * @param CHSCpsPayableInvoiceCreationINVO cHSCpsPayableInvoiceCreationINVO
	 * @exception DAOException
	 */
	public void removeCHSCpsPayableInvCreationData(CHSCpsPayableInvoiceCreationINVO cHSCpsPayableInvoiceCreationINVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(cHSCpsPayableInvoiceCreationINVO != null){
				//query parameter
		        Map<String, String> param = cHSCpsPayableInvoiceCreationINVO.getColumnValues();
		        //??젣 
		        int result = sqlExe.executeUpdate((ISQLTemplate) new ChassisMgsetInvoiceDBDAORemoveCHSPayableInvCreationDataDSQL() , param, null);
				
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to Remove SQL");
				
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * CGM_LSE_CHG_CMMT_CR_DTL에 Data(Min Commitment / MH Credit)를 delete한다. [EES_CGM_1205]<br>
	 * 
	 * @param CHSCpsInvoiceAuditResultCmmtCrMGTVO cHSCpsInvoiceAuditResultCmmtCrMGTVO
	 * @exception DAOException
	 */
	public void removeCHSCpsInvoiceAuditResultCmmtCrData(CHSCpsInvoiceAuditResultCmmtCrMGTVO cHSCpsInvoiceAuditResultCmmtCrMGTVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(cHSCpsInvoiceAuditResultCmmtCrMGTVO != null) {
				// query parameter
				Map<String, String> param = cHSCpsInvoiceAuditResultCmmtCrMGTVO.getColumnValues();
				
				// 데이터 삭제
				int result = sqlExe.executeUpdate((ISQLTemplate) new ChassisMgsetInvoiceDBDAOModifyCHSCpsInvoiceAuditResultCmmtCrDataDSQL(), param, null);
				
				if (result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to delete SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 *  MAS(MAS_DMDT_COST_RPT_BKG_DTL)에서 Pool Estimate Amount 를 조회한다. Calculation (BackEndJob) [EES_CGM_1225]<br>
	 * 
	 * @param poolEstmExpenseINVO PoolEstmExpenseINVO 
	 * @return List<PoolEstmExpenseMGTVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<PoolEstmExpenseMGTVO> searchZPPoolEstimateAmtFromMASData(PoolEstmExpenseINVO poolEstmExpenseINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PoolEstmExpenseMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(poolEstmExpenseINVO != null){
				Map<String, String> mapVO = poolEstmExpenseINVO.getColumnValues();
					
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInvoiceDBDAOSearchZPPoolEstimateAmtFromMASDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PoolEstmExpenseMGTVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 *  CGM_CHSS_POOL_EXPN_ESTM에서 Estimate, Actual Amount를 조회한다. [EES_CGM_1225].<br>
	 * 
	 * @param poolEstmExpenseINVO PoolEstmExpenseINVO 
	 * @return List<PoolEstmExpenseMGTVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<PoolEstmExpenseMGTVO> searchZPPoolEstimateAmtData(PoolEstmExpenseINVO poolEstmExpenseINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PoolEstmExpenseMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(poolEstmExpenseINVO != null){
				Map<String, String> mapVO = poolEstmExpenseINVO.getColumnValues();
					
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInvoiceDBDAOSearchZPPoolEstimateAmtDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PoolEstmExpenseMGTVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
}
