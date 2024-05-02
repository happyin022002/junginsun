/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChassisMgsetInvoiceDBDAO.java
*@FileTitle : Agreement Matching
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.29
*@LastModifier : 김창식
*@LastVersion : 1.0
* 2009.04.29 김창식
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.basic.ChassisMgsetInvoiceBCImpl;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSChargeCreationINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSChargeCreationMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSCoPoolChargeINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSCoPoolChargeMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSConfirmPayableAmountINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSConfirmPayableAmountMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSEstimateExpenseINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSEstimateExpenseMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSInvoiceImportAuditINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSInvoiceImportAuditMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSInvoiceInquiryINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSInvoiceInquiryMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSLessorAgmtMatchingINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSLessorAgmtMatchingMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSNuPoolChargeINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSNuPoolChargeMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSPayableInvoiceCreationINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSPayableInvoiceCreationMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSChargeCreationINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSChargeCreationMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSConfirmPayableAmountINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSConfirmPayableAmountMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSEstimateExpenseINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSEstimateExpenseMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSInvoiceImportAuditINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSInvoiceImportAuditMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSInvoiceInquiryINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSInvoiceInquiryMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSLessorAgmtMatchingINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSLessorAgmtMatchingMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSPayableInvoiceCreationINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSPayableInvoiceCreationMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.PoolEstmExpenseINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.PoolEstmExpenseMGTVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/**
 * OPUS ChassisMgsetInvoiceDBDAO <br>
 * - OPUS-ChassisMgsetAgreementInvoice system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author KIM CHANG SIK
 * @see ChassisMgsetInvoiceBCImpl 참조
 * @since J2EE 1.4  
 */
public class ChassisMgsetInvoiceDBDAO extends DBDAOSupport {

	/**
	 * Lessor 와 match 되는 agreement 정보를 조회한다.[EES_CGM_1028]<br>
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
	 * 기존에 등록된 Reference No 와 Agreement No 가 있는지 체크한다. [EES_CGM_1028]<br>
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
	 * 기존에 등록된 Agreement No 가 있는지 체크한다. [EES_CGM_1028]<br>
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
	 * CGM_INV_REF_NO_RGST 테이블에 데이터를 일괄적으로 생성한다. [EES_CGM_1028]<br>
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
	 * CGM_INV_REF_NO_RGST 테이블의 데이터를 일괄적으로 갱신한다. [EES_CGM_1028]<br>
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
	 * CGM_INV_REF_NO_RGST 테이블의 데이터를 일괄적으로 삭제한다. [EES_CGM_1028].<br>
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
	 * Lessor 와 match 되는 agreement 정보를 조회한다. [EES_CGM_2086]<br>
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
	 * 기존에 등록된 Reference No 와 Agreement No 가 있는지 체크한다. [EES_CGM_2086]<br>
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
	 * 기존에 등록된 Agreement No 가 있는지 체크한다. [EES_CGM_2086]<br>
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
	 * CGM_INV_REF_NO_RGST 테이블에 데이터를 일괄적으로 생성한다. [EES_CGM_2086]<br>
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
	 * CGM_INV_REF_NO_RGST 테이블의 데이터를 일괄적으로 갱신한다. [EES_CGM_2086]<br>
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
	 * CGM_INV_REF_NO_RGST 테이블의 데이터를 일괄적으로 삭제한다. [EES_CGM_2086].<br>
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
	 * CGM_PAY_INV 테이블에서 Cost Month 에 해당하는 INV_NO 와 상태값을 가져온다. [EES_CGM_1123]<br>
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
	 * Co-Pool Charge 의 초기값을 불러온다. [EES_CGM_1123]<br>
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
	 * Co-Pool Charge 목록을 불러온다. [EES_CGM_1123]<br>
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
	 * CGM_PAY_INV 테이블에 payInvSeq 를 가져온다. [EES_CGM_1123]<br>
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
	 * CGM_PAY_INV 테이블에 데이터를 일괄적으로 생성한다. [EES_CGM_1123]<br>
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
		        //신규 입력
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
	 * CGM_PAY_INV_POOL_DTL 테이블에 데이터를 일괄적으로 생성한다. [EES_CGM_1123]<br>
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
	 * CGM_PAY_INV 테이블에 데이터를 일괄적으로 수정한다. [EES_CGM_1123]<br>
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
		        //삭제 
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
	 * CGM_PAY_INV_POOL_DTL 의 데이터를 일괄적으로 수정한다. [EES_CGM_1123]<br>
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
	 * CGM_PAY_INV 테이블의 데이터를 삭제한다.<br>
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
		        //삭제 
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
	 * CGM_PAY_INV_POOL_DTL 테이블의 데이터를 일괄적으로 삭제한다.<br>
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
		        //삭제 
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
	 * Co-Pool Charge Main 정보를 불러온다. [EES_CGM_1123]<br>
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
	 * Chassis Charge Creation 대상 목록을 불러온다. [EES_CGM_1029]<br>
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
	 * Chassis Charge Creation 결과를 불러온다. [EES_CGM_1029]<br>
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
	 * Charge Creation PDM 데이터를 일괄적으로 생성한다. [EES_CGM_1029]<br>
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
	 * Charge Creation HON 데이터를 일괄적으로 생성한다. [EES_CGM_1029]<br>
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
	 * Charge Creation HOF 데이터를 일괄적으로 생성한다. [EES_CGM_1029]<br>
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
	 * Charge Creation Header 데이터를 일괄적으로 생성한다. [EES_CGM_1029]<br>
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
	 * Charge Creation Header 데이터의 총합을 일괄적으로 Update 한다.. [EES_CGM_1029]<br>
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
	 * Charge Creation Detail 데이터를 일괄적으로 삭제한다. [EES_CGM_1029]<br>
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
		        //삭제 
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
	 * Charge Creation Header 데이터를 삭제한다. [EES_CGM_1029]<br>
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
		        //삭제 
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
	 * CGM_PAY_INV의 데이터를 삭제한다. [EES_CGM_1029]<br>
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
		        //삭제 
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
	 * Charge Creation Sequence 를 가져온다. [EES_CGM_1029]<br>
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
	 * M.G.Set Charge Creation 대상 목록을 불러온다. [EES_CGM_2032]<br>
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
	 * M.G.Set Charge Creation 결과를 불러온다. [EES_CGM_2032]<br>
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
	 * Charge Creation PDM 데이터를 일괄적으로 생성한다. [EES_CGM_2032]<br>
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
	 * Charge Creation HON 데이터를 일괄적으로 생성한다. [EES_CGM_2032]<br>
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
	 * Charge Creation HOF 데이터를 일괄적으로 생성한다. [EES_CGM_2032]<br>
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
	 * Charge Creation Header 데이터를 일괄적으로 생성한다. [EES_CGM_2032]<br>
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
	 * Charge Creation Header 데이터 합계를 일괄적으로 update 한다. [EES_CGM_2032]<br>
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
	 * CGM_LSE_CHG_DTL 데이터를 삭제한다. [EES_CGM_2032]<br>
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
		        //삭제 
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
	 * CGM_LSE_CHG_HDR 데이터를 삭제한다. [EES_CGM_2032]<br>
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
		        //삭제 
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
	 * CGM_PAY_INV 데이터를 삭제한다. [EES_CGM_2032]<br>
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
		        //삭제 
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
	 * Charge Creation Sequence 를 가져온다. [EES_CGM_2032]<br>
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
	 *  년,월별 각 해당 Estimate, Actual Amount 를 조회한다 [EES_CGM_1125].<br>
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
	 * CGM_CHSS_POOL_EXPN_ESTM 엔티티에 입력 저장.. .[EES_CGM_1125].<br>
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
				rtn = true;	// 데이터가 존재함. (사용)
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
	 * CGM_CHSS_POOL_EXPN_ESTM 엔티티에 입력 저장.. .[EES_CGM_1125].<br>
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
	 *  입력된 년도, Pool TYPE 에 해당하는 Pool List 별, 월별 Estimate amount 를 조회하였다. Retrieve . [EES_CGM_1126].<br>
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
	 * Chassis No 존재 유무 Check 한다. [EES_CGM_1030]<br>
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
	 * Lessor Chassis No 존재 유무 Check 한다. [EES_CGM_1030]<br>
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
	 * Reference No 존재 유무 Check 한다. [EES_CGM_1030]<br>
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
	 * Auding 하기위해 CGM_LSE_CHG_DTL 테이블을 일괄적으로 갱신한다. [EES_CGM_1030]<br>
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
	 * CGM_LSE_CHG_DTL 테이블에 Invoice 데이터를 일괄적으로 생성한다. [EES_CGM_1030]<br>
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
	 * Audit 된 Summary 데이터를 가져온다. [EES_CGM_1030]<br>
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
	 * CGM_LSE_CHG_HDR 테이블에서 Invoice, Credit, Tax 의 Summary 를 일괄적으로 갱신한다. [EES_CGM_1030]<br>
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
	 * Location Code 를 가져온다. [EES_CGM_1030] <br>
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
				if(!"".equals(locCd)){
					
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
	 * Invoice Only 상태인 CGM_LSE_CHG_DTL 테이블 데이터를 삭제한다. [EES_CGM_1030]<br>
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
		        //삭제 
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
	 * CGM_LSE_CHG_DTL 테이블에서 Audit 하기 전의 상태로 데이터를 일괄적으로 수정한다. [EES_CGM_1030]<br>
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
		        //삭제 
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
	 * CGM_LSE_CHG_HDR 테이블에서 Audit 하기 전의 상태로 데이터를 일괄적으로 수정한다. [EES_CGM_1030]<br>
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
		        //삭제 
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
	 * CGM_EQ_STS_HIS 테이블에서 해당 EQ_NO 의 최신 EQ_ASET_STS_CD 를 가져온다. [EES_CGM_1030]<br>
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
	 * Chassis CC(Charge Creation)정보와 EXCEL데이터를 CGM_LSE_INV_TMP테이블에 일괄 INSERT한다. [EES_CGM_1030]<br>
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
	 * CGM_LSE_INV_TMP테이블의 Chassis 데이터를 삭제한다. [EES_CGM_1030]<br>
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
		        //삭제 
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
	 * CGM_LSE_INV_TMP테이블의 Chassis 데이터를 조회한다. [EES_CGM_1030]<br>
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
	 * CGM_LSE_INV_TMP테이블의 Chassis Verify 데이터를 조회한다. [EES_CGM_1030]<br>
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
	 * CGM_LSE_INV_TMP테이블의 조회된 Chassis Save 데이터를 업데이트한다. [EES_CGM_1030]<br>
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
	 * M.G.Set CC(Charge Creation)정보와 EXCEL데이터를 CGM_LSE_INV_TMP테이블에 일괄 INSERT한다. [EES_CGM_1030]<br>
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
	 * CGM_LSE_INV_TMP테이블의 M.G.Set 데이터를 삭제한다. [EES_CGM_1030]<br>
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
		        //삭제 
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
	 * CGM_LSE_INV_TMP테이블의 M.G.Set 데이터를 조회한다. [EES_CGM_1030]<br>
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
	 * CGM_LSE_INV_TMP테이블의 M.G.Set Verify 데이터를 조회한다. [EES_CGM_1030]<br>
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
	 * M.G.Set EqNo 존재 유무 Check 한다. [EES_CGM_2085] <br>
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
	 * Lessor M.G.Set No 존재 유무 Check 한다. [EES_CGM_2085]<br>
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
	 * Reference No 존재 유무 Check 한다. [EES_CGM_2085]<br>
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
	 * Auding 하기위해 CGM_LSE_CHG_DTL 테이블을 일괄적으로 갱신한다. [EES_CGM_2085]<br>
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
	 * CGM_LSE_CHG_DTL 테이블에 Invoice 데이터를 일괄적으로 생성한다. [EES_CGM_2085]<br>
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
	 * Audit 된 Summary 데이터를 가져온다. [EES_CGM_2085]<br>
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
	 * CGM_LSE_CHG_HDR 테이블에서 Invoice, Credit, Tax 의 Summary 를 일괄적으로 갱신한다. [EES_CGM_2085]<br>
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
	 * Location Code 를 가져온다. [EES_CGM_2085] <br>
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
				if(!"".equals(locCd)){
					
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
	 * Invoice Only 상태인 CGM_LSE_CHG_DTL 테이블 데이터를 삭제한다. [EES_CGM_2085]<br>
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
		        //삭제 
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
	 * CGM_LSE_CHG_DTL 테이블에서 Audit 하기 전의 상태로 데이터를 일괄적으로 수정한다. [EES_CGM_2085]<br>
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
		        //삭제 
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
	 * CGM_LSE_CHG_HDR 테이블에서 Audit 하기 전의 상태로 데이터를 일괄적으로 수정한다. [EES_CGM_2085]<br>
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
		        //삭제 
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
	 * CGM_EQ_STS_HIS 테이블에서 해당 EQ_NO 의 최신 EQ_ASET_STS_CD 를 가져온다. [EES_CGM_2085]<br>
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
	 * CGM_LSE_CHG_DTL 테이블에서 AUD_UMCH_EQ_STS_EVNT_YD_CD, AUD_UMCH_EQ_ASET_STS_CD, AUD_UMCH_EQ_STS_EVNT_DT
	 * 데이터를 수정한다. [EES_CGM_1030]<br>
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
		        //삭제 
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
	 * CGM_LSE_CHG_DTL 테이블에서 AUD_UMCH_EQ_STS_EVNT_YD_CD, AUD_UMCH_EQ_ASET_STS_CD, AUD_UMCH_EQ_STS_EVNT_DT
	 * 데이터를 수정한다. [EES_CGM_2085]<br>
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
		        //삭제 
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
	 * CGM_LSE_CHG_DTL 테이블의 LSE_CHG_AUD_STS_CD 컬럼 값의 따라 Data를 가져온다.<br>
	 * - Coincidence : C - Coincidenc :e (Agreement,Invoice Rate,금액,일자 일치) [EES_CGM_1031]
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
	 * CGM_LSE_CHG_DTL 테이블의 LSE_CHG_AUD_STS_CD 컬럼 값의 따라 Data를 가져온다.<br>
 	 * - Discrepancy : D - Discrepancy(Agreement,Invocie Rate,금액,일자 불일치).<br>
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
	 * CGM_LSE_CHG_DTL 테이블의 LSE_CHG_AUD_STS_CD 컬럼 값의 따라 Data를 가져온다.<br>
	 * - Charge Only : H - Chassis 가 Nis Only 존재.Invoice에는 없음 [EES_CGM_1031] <br>
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
	 * CGM_LSE_CHG_DTL 테이블의 LSE_CHG_AUD_STS_CD 컬럼 값의 따라 Data를 가져온다.<br>
	 * - Charge Only : H - Chassis 가 Nis Only 존재.Invoice에는 없음. [EES_CGM_1031]<br>
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
	 * CGM_LSE_CHG_DTL 테이블에 Invoice Only 인 데이터를 일괄적으로 생성한다. [EES_CGM_1031]<br>
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
	 * CGM_LSE_CHG_DTL 테이블에 Invoice Only 인 데이터 중 Remark를 포함한 데이터들을 일괄적으로 수정한다. [EES_CGM_1031]<br>
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
	 * CGM_LSE_CHG_DTL 테이블에 Invoice Only 인 데이터를 일괄적으로 삭제한다. [EES_CGM_1031]<br>
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
	 * CGM_LSE_CHG_DTL 테이블에 Invoice Only 인 데이터를 일괄적으로 삭제한다. [EES_CGM_2098]<br>
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
	 * CGM_LSE_CHG_DTL 테이블에서 Concidency 상태로 일괄적으로 갱신한다. [EES_CGM_1031]<br>
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
	 * CGM_LSE_CHG_DTL 테이블에서 Decrepancy 의 remark 정보를 일괄적으로 갱신한다. [EES_CGM_1031]<br>
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
	 * CGM_LSE_CHG_HDR 테이블에서 INV_SMRY_AMT, CR_SMRY_AMT, TAX_SMRY_AMT 정보를 갱신한다. [EES_CGM_1031]<br>
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
	 * CGM_LSE_CHG_DTL 테이블에서 Concidece 로 옮긴 모든 데이터를 Concidence 상태로 일괄적으로 갱신한다. [EES_CGM_1031]<br>
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
	 * CGM_LSE_CHG_HDR 테이블에서 CR_SMRY_AMT, TAX_SMRY_AMT, LSE_CHG_STS_CD 데이터를 수정한다. [EES_CGM_1031]<br>
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
		        //삭제 
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
	 * CGM_PAY_INV 테이블 데이터를 삭제한다. [EES_CGM_1031]<br>
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
		        //삭제 
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
	 * CGM_PAY_INV 테이블의 데이터를 생성한다. [EES_CGM_1031]<br>
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
		        //삭제 
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
	 * CGM_LSE_CHG_DTL 테이블에서 PAY_INV_SEQ 를 수정한다. [EES_CGM_1031]<br>
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
		        //삭제 
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
	 * CGM_LSE_CHG_DTL에서 LSE_CHG_AUD_STS_CD = 'I' 상태인 데이터를 삭제한다. [EES_CGM_1031]<br>
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
		        //삭제 
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
	 * CGM_LSE_CHG_DTL 테이블을 Invoice Import & Audit 상태로 데이터를 수정한다. [EES_CGM_1031]<br>
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
		        //실행
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
	 * CGM_LSE_CHG_HDR 테이블를 Invoice Import & Audit 상태로 데이터를 수정한다. [EES_CGM_1031]<br>
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
		        //실행 
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
	 * Invoice 데이터를 삭제한다. [EES_CGM_1031]<br>
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
		        //삭제 
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
	 * CGM_LSE_CHG_DTL 테이블의 LSE_CHG_AUD_STS_CD 컬럼 값의 따라 Data를 가져온다.<br>
	 * - Coincidence : C - Coincidenc :e (Agreement,Invoice Rate,금액,일자 일치) [EES_CGM_2098] <br>
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
	 * CGM_LSE_CHG_DTL 테이블의 LSE_CHG_AUD_STS_CD 컬럼 값의 따라 Data를 가져온다.<br>
 	 * - Discrepancy : D - Discrepancy(Agreement,Invocie Rate,금액,일자 불일치). [EES_CGM_2098]<br>
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
	 * CGM_LSE_CHG_DTL 테이블의 LSE_CHG_AUD_STS_CD 컬럼 값의 따라 Data를 가져온다.<br>
	 * - Charge Only : H - Chassis 가 Nis Only 존재.Invoice에는 없음 [EES_CGM_2098] <br>
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
	 * CGM_LSE_CHG_DTL 테이블의 LSE_CHG_AUD_STS_CD 컬럼 값의 따라 Data를 가져온다.<br>
	 * - Charge Only : H - Chassis 가 Nis Only 존재.Invoice에는 없음. [EES_CGM_2098]<br>
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
	 * CGM_LSE_CHG_DTL 테이블에 Invoice Only 인 데이터를 일괄적으로 생성한다. [EES_CGM_2098]<br>
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
	 * CGM_LSE_CHG_DTL 테이블에 Invoice Only 인 데이터 중 Remark 를 일괄적으로 수정한다. [EES_CGM_2098]<br>
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
	 * CGM_LSE_CHG_DTL 테이블에서 Concidency 상태로 일괄적으로 갱신한다. [EES_CGM_2098]<br>
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
	 * CGM_LSE_CHG_DTL 테이블에서 Decrepancy 의 remark 정보를 일괄적으로 갱신한다. [EES_CGM_2098]<br>
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
	 * CGM_LSE_CHG_HDR 테이블에서 INV_SMRY_AMT, CR_SMRY_AMT, TAX_SMRY_AMT 정보를 갱신한다. [EES_CGM_2098]<br>
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
	 * CGM_LSE_CHG_DTL 테이블에서 Concidece 로 옮긴 모든 데이터를 Concidence 상태로 일괄적으로 갱신한다. [EES_CGM_2098]<br>
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
	 * CGM_LSE_CHG_HDR 테이블에서 CR_SMRY_AMT, TAX_SMRY_AMT, LSE_CHG_STS_CD 데이터를 수정한다. [EES_CGM_2098]<br>
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
		        //삭제 
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
	 * CGM_PAY_INV 테이블 데이터를 삭제한다. [EES_CGM_2098]<br>
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
		        //삭제 
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
	 * CGM_PAY_INV 테이블의 데이터를 생성한다. [EES_CGM_2098]<br>
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
		        //삭제 
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
	 * CGM_LSE_CHG_DTL 테이블에서 PAY_INV_SEQ 를 수정한다. [EES_CGM_2098]<br>
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
		        //삭제 
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
	 * CGM_LSE_CHG_DTL에서 LSE_CHG_AUD_STS_CD = 'I' 상태인 데이터를 삭제한다. [EES_CGM_2098]<br>
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
		        //삭제 
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
	 * CGM_LSE_CHG_DTL 테이블을 Invoice Import & Audit 상태로 데이터를 수정한다. [EES_CGM_2098]<br>
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
		        //실행
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
	 * CGM_LSE_CHG_HDR 테이블를 Invoice Import & Audit 상태로 데이터를 수정한다. [EES_CGM_2098]<br>
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
		        //실행
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
	 * Invoice 데이터를 삭제한다. [EES_CGM_2098]<br>
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
		        //삭제 
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
	 * CGM_PAY_INV 의 Invoice No 가 'LS' 또는 'NP'에 존재하는지 체크한다. [EES_CGM_1124]<br>
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
	 * CP 안에서 다른 Cost Month 에 Invoice No 가 존재하는지 체크한다. [EES_CGM_1124]<br>
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
	 * Neutral Pool Charge 목록을 조회한다. [EES_CGM_1124]<br>
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
	 * Neutral Pool Charge 초기 항목을 조회한다. [EES_CGM_1124]<br>
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
	 * Neutral Pool Charge 상세 내역을 조회한다. [EES_CGM_1024]<br>
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
	 * CGM_PAY_INV 테이블에 Neutral Pool Charge payInvSeq 가져온다 . [EES_CGM_1024]<br>
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
	 * CGM_PAY_INV 테이블에 Neutral Pool Charge 데이터를 생성한다. [EES_CGM_1024]<br>
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
		        //신규 입력
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
	 * CGM_PAY_INV_POOL_DTL 테이블에 Neutral Pool Charge 상세 데이터를 생성한다. [EES_CGM_1024]<br>
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
	 * CGM_PAY_INV 테이블에 Neutral Pool Main 데이터를 수정한다. [EES_CGM_1024]<br>
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
		        //삭제 
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
	 * CGM_PAY_INV 테이블에 Neutral Pool Detail 데이터를 수정한다. [EES_CGM_1024]<br>
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
	 * CGM_PAY_INV 테이블에서 Neutral Pool Main 데이터를 삭제한다. [EES_CGM_1024]<br>
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
		        //삭제 
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
	 * CGM_PAY_INV 테이블에서 Neutral Pool Detail 데이터를 삭제한다. [EES_CGM_1024]<br>
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
		        //삭제 
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
	 * Neutral Pool Charge Main 정보를 불러온다. [EES_CGM_1024]<br>
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
	 * Payable Invoice Creation 목록을 가져온다. [EES_CGM_1034]<br>
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
	 * Payable Invoice Creation 상세정보를 불러온다. [EES_CGM_1034]<br>
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
	 * Payable Invoice Creation 데이터를 일괄적으로 수정한다. [EES_CGM_1034]<br>
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
	 * Payable Invoice Commit 이전 상태(P.Amt)로 CGM_PAY_INV 데이터를 일괄적으로 수정한다. [EES_CGM_1034]<br>
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
	 * Payable Invoice Commit 이전 상태(P.Amt)로 CGM_LSE_CHG_HDR 데이터를 일괄적으로 수정한다. [EES_CGM_1034]<br>
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
	 * CGM_LSE_CHG_DTL 테이블을 Charge Creation 상태로 일괄적으로 수정한다. [EES_CGM_1034]<br>
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
	 * CGM_PAY_INV 데이터를 일괄적으로 삭제한다. [EES_CGM_1034]<br>
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
	 * Payable Invoice Creation 에서 AP_INV_MAIN 에 넘길 값을 조회한다. [EES_CGM_1034]<br>
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
	 * Payable Invoice Creation 에서 AP_INV_DTL 에 넘길 값을 조회한다. [EES_CGM_1034]<br>
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
	 * Payable Invoice Creation 목록을 가져온다. [EES_CGM_2035]<br>
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
	 * Payable Invoice Creation 상세정보를 불러온다. [EES_CGM_2035]<br>
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
	 * Payable Invoice Creation 데이터를 일괄적으로 수정한다. [EES_CGM_2035]<br>
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
	 * Payable Invoice Commit 이전 상태(P.Amt)로 CGM_PAY_INV 데이터를 일괄적으로 수정한다. [EES_CGM_2035]<br>
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
	 * Payable Invoice Commit 이전 상태(P.Amt)로 CGM_LSE_CHG_HDR 데이터를 일괄적으로 수정한다. [EES_CGM_2035]<br>
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
	 * CGM_LSE_CHG_DTL 테이블을 Charge Creation 상태로 일괄적으로 수정한다. [EES_CGM_2035]<br>
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
	 * CGM_PAY_INV 데이터를 일괄적으로 삭제한다. [EES_CGM_2035]<br>
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
	 * Payable Invoice Creation 에서 AP_INV_MAIN 에 넘길 값을 조회한다. [EES_CGM_2035]<br>
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
	 * Payable Invoice Creation 에서 AP_INV_DTL 에 넘길 값을 조회한다. [EES_CGM_2035]<br>
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
	 * 월별 Chassis 추정결산 데이터를 조회한다. [EES_CGM_1107]<br>
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
	 * 월별 Chassis 추정결산 데이터를 산정한다. [EES_CGM_1107]<br>
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
	 * 월별 Chassis 추정결산 Summary 데이터를 조회한다. [EES_CGM_1107]<br>
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
	 * 월별 Chassis 추정결산 데이터를 Insert 한다. [EES_CGM_1107].<br>
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
	 * 월별 Chassis 추정결산 데이터를 remove 한다. [EES_CGM_1107].<br>
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
	 * 월별 M.G. Set 추정결산 데이터를 조회한다. [EES_CGM_2206]<br>
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
	 * 월별 M.G. Set 추정결산 데이터를 산정한다. [EES_CGM_2206]<br>
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
	 * 월별 M.G. Set 추정결산 Summary데이터를 조회한다. [EES_CGM_2206]<br>
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
	 * 월별 M.G. Set 추정결산 데이터를 Insert 한다. [EES_CGM_2206].<br>
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
	 * 월별 M.G. Set 추정결산 데이터를 remove 한다. [EES_CGM_2206].<br>
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
	 * CGN_PAY_INV 에 Concidency 에 해당하는 Invoice No 가 존재하는지 체크한다. [EES_CGM_1031]<br>
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
	 * CGN_PAY_INV 에 Concidency 에 해당하는 Invoice No 가 존재하는지 체크한다. [EES_CGM_2098]<br>
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
	 *  CGM_LSE_CHG_HDR 데이터의 상태를 'C' 로 수정한다. [EES_CGM_1034]<br>
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
	 * CGM_LSE_CHG_HDR 데이터의 상태를 'C' 로 수정한다. [EES_CGM_2035]<br>
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
	 * Chassis의 INVOICE를 Summary 하여 보여준다. [EES_CGM_1035]<br>
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
	 * Chassis의 INVOICE Detail 데이터를 보여준다. [EES_CGM_1035]<br>
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
	 * M.G.Set의 INVOICE를 Summary 하여 보여준다. [EES_CGM_2036]<br>
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
	 * M.G.Set의 INVOICE Detail 데이터를 보여준다. [EES_CGM_2036]<br>
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
	
}

