/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GEMCommonDBDAO.java
*@FileTitle : Expense Office Maintenance
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.17
*@LastModifier : 최정미
*@LastVersion : 1.0
* 2009.04.17 최정미
* 1.0 Creation
* -------------------------------------------------------
* History
* 2012.04.27 이준범 [CHM-201217079-01]
* 제목 : GEM 시스템 개발(기능 추가)
* 내용 : 현지법인 실적관리(전표) 신규 기능 개발
*       기존 - 현지법인은 비용별 합계 금액만 관리
*       변경 – 현지법인 자체 ERP 데이터(전표 단위)를 Upload
=========================================================*/
package com.hanjin.apps.alps.cps.gem.gemcommon.gemcommon.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.cps.gem.common.GemUtil;
import com.hanjin.apps.alps.cps.gem.gemcommon.gemcommon.basic.GEMCommonBCImpl;
import com.hanjin.apps.alps.cps.gem.gemcommon.gemcommon.vo.SlipPerfVO;
import com.hanjin.apps.alps.cps.gem.gemcommon.gemcommon.vo.SumGenExpnAmtVO;
import com.hanjin.apps.alps.cps.gem.gemcommon.gemcommon.vo.SumSlipPerfAmtVO;
import com.hanjin.apps.alps.cps.gem.gemcommon.gemmastercodemgt.integration.GEMMasterCodeMgtDBDAOAddInitialExchangeRateInfoCSQL;
import com.hanjin.apps.alps.cps.gem.gemcommon.gemmastercodemgt.integration.GEMMasterCodeMgtDBDAOSearchAccountListRSQL;
import com.hanjin.apps.alps.cps.gem.gemcommon.gemmastercodemgt.integration.GEMMasterCodeMgtDBDAOSearchExpenseListRSQL;
import com.hanjin.apps.alps.cps.gem.gemcommon.gemmastercodemgt.integration.GEMMasterCodeMgtDBDAOSearchGroupListByExpenseRSQL;
import com.hanjin.apps.alps.cps.gem.gemcommon.gemmastercodemgt.integration.GEMMasterCodeMgtDBDAOSearchSumUpListByOfficeRSQL;
import com.hanjin.apps.alps.cps.gem.gemcommon.gemmastercodemgt.vo.GemAcctMtxVO;
import com.hanjin.apps.alps.cps.gem.gemcommon.gemmastercodemgt.vo.GemExpenseVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * NIS2010 GEMCommonDBDAO <br>
 * - NIS2010-GEMCommon system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author cjm
 * @see GEMCommonBCImpl 참조
 * @since J2EE 1.4
 */
public class GEMCommonDBDAO extends DBDAOSupport {

	
	// J.Y.O ===========================================================================	
	
	// ---------------------------------------------------------------------------
	// 
	// ---------------------------------------------------------------------------
	
    

    
	// C.J.M ===========================================================================
	
    // ---------------------------------------------------------------------------
	// BU , HO, HQ 정보 콤보 박스 리스트 공통
	// ---------------------------------------------------------------------------
	/**
	 * 일반관리비 BU 조직코드 조회
	 * 
	 * @author choijungmi
	 * @category searchBUOffice
	 * @return String[]
	 * @throws DAOException
	 */
	public String[] searchBUOffice() throws DAOException {
		DBRowSet dbRowset = null;
		String[] returnStr = null;
		
		try {
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GEMCommonDBDAOSearchBUOfficeRSQL(),null, null);
			returnStr = GemUtil.getArrayString(dbRowset, "code");
			
		} catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        } catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        }
		
		return returnStr;
	}
	
	/**
	 * 일반관리비 Major 조직코드 조회
	 * 
	 * @author choijungmi
	 * @category searchMajorListByOffice
	 * 
	 * @param rgnOfcFlg
	 * @param ofcCd
	 * @return String[]
	 * @throws DAOException
	 */
	public String[] searchMajorListByOffice(String rgnOfcFlg, String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		String[] returnStr = null;
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		//velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
		try {
			
			param.put("rgn_ofc_flg", rgnOfcFlg);
			param.put("ofc_cd", ofcCd);
			
			velParam.put("rgn_ofc_flg", rgnOfcFlg);
			velParam.put("ofc_cd", ofcCd);
						
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GEMCommonDBDAOSearchMajorListByOfficeRSQL(),param, velParam);
			returnStr = GemUtil.getArrayString(dbRowset, "code");
			
		} catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        } catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        }
		
		return returnStr;
	}
	
	/**
	 * 일반관리비 Minor 조직코드 조회
	 * 
	 * @author choijungmi
	 * @category searchMinorListByOffice
	 * 
	 * @param rgnOfcFlg
	 * @param ofcCd
	 * @return String[]
	 * @throws DAOException
	 */
	public String[] searchMinorListByOffice(String rgnOfcFlg, String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		String[] returnStr = null;
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		//velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
		try {
			
			param.put("rgn_ofc_flg", rgnOfcFlg);
			param.put("ofc_cd", ofcCd);
			
			velParam.put("rgn_ofc_flg", rgnOfcFlg);
			velParam.put("ofc_cd", ofcCd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GEMCommonDBDAOSearchMinorListByOfficeRSQL(),param, velParam);
			returnStr = GemUtil.getArrayString(dbRowset, "code");
			
		} catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        } catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        }
		
		return returnStr;
	}
	
	// ---------------------------------------------------------------------------
	// Expense , Account, Expense Group 정보 콤보 박스 리스트 공통
	// ---------------------------------------------------------------------------
	
	/**
	 * 일반관리비 비용코드 조회
	 * 
	 * @author choijungmi
	 * @category searchExpenseList
	 * @return List<GemExpenseVO>
	 * @throws DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<GemExpenseVO> searchExpenseList() throws DAOException {
		DBRowSet dbRowset = null;
		List<GemExpenseVO> list = null;
		
		try {
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GEMMasterCodeMgtDBDAOSearchExpenseListRSQL(),null, null);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, GemExpenseVO.class);
			
		} catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        } catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        }
		
		return list;
	}
	
	/**
	 * 일반관리비 회계계정코드 조회
	 * 
	 * @author choijungmi
	 * @category searchAccountList
	 * @return List<GemAcctMtxVO>
	 * @throws DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<GemAcctMtxVO> searchAccountList() throws DAOException {
		DBRowSet dbRowset = null;
		List<GemAcctMtxVO> list = null;
		
		try {
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GEMMasterCodeMgtDBDAOSearchAccountListRSQL(),null, null);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, GemAcctMtxVO.class);
			
		} catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        } catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        }
		
		return list;
	}
	
	/**
	 * 일반관리비 1st Group비용코드 조회
	 * 
	 * @author choijungmi
	 * @category searchExpenseList
	 * @return List<GemExpenseVO>
	 * @throws DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<GemExpenseVO> searchGroupListByExpense() throws DAOException {
		DBRowSet dbRowset = null;
		List<GemExpenseVO> list = null;
		
		try {
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GEMMasterCodeMgtDBDAOSearchGroupListByExpenseRSQL(),null, null);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, GemExpenseVO.class);
			
		} catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        } catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        }
		
		return list;
	}
    
    // ---------------------------------------------------------------------------
	// Sumup Office 정보 콤보 박스 리스트 공통
	// ---------------------------------------------------------------------------
    
    /**
	 * SUMUP OFFICE코드 조회
	 * 
	 * @author choijungmi
	 * @category searchSumUpListByOffice
	 * @return String[]
	 * @throws DAOException
	 */
	public String[] searchSumUpListByOffice() throws DAOException {
		DBRowSet dbRowset = null;
		String[] returnStr = null;
		
		try {
						
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GEMMasterCodeMgtDBDAOSearchSumUpListByOfficeRSQL(),null, null);
			returnStr = GemUtil.getArrayString(dbRowset, "code");
			
		} catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        } catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        }
		
		return returnStr;
	}
    
	// P.C.J ===========================================================================
	
	/**
	 * [투자법인] BU조직에 속한 HO본사,HQ지역그룹,BU주관부서 코드 리스트 조회
	 * 
	 * @author Park Chang June
	 * @category searchSubsMajorListByOffice
	 * 
	 * @param rgnOfcFlg
	 * @param ofcCd
	 * @return String[]
	 * @throws DAOException
	 */
	public String[] searchSubsMajorListByOffice(String rgnOfcFlg, String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		String[] returnStr = null;
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		//velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
		try {
			
			param.put("rgn_ofc_flg", rgnOfcFlg);
			param.put("ofc_cd", ofcCd);
			
			velParam.put("rgn_ofc_flg", rgnOfcFlg);
			velParam.put("ofc_cd", ofcCd);
						
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GEMCommonDBDAOSearchSubsMajorListByOfficeRSQL(),param, velParam);
			returnStr = GemUtil.getArrayString(dbRowset, "code");
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return returnStr;
	}
	
	/**
	 * [투자법인] HO본사,HQ지역그룹,BU주관부서의 속한 조직코드 리스트 조회
	 * 
	 * @author Park Chang June
	 * @category searchSubsMinorListByOffice
	 * 
	 * @param rgnOfcFlg
	 * @param ofcCd
	 * @return String[]
	 * @throws DAOException
	 */
	public String[] searchSubsMinorListByOffice(String rgnOfcFlg, String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		String[] returnStr = null;
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		//velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
		try {
			
			param.put("rgn_ofc_flg", rgnOfcFlg);
			param.put("ofc_cd", ofcCd);
			
			velParam.put("rgn_ofc_flg", rgnOfcFlg);
			velParam.put("ofc_cd", ofcCd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GEMCommonDBDAOSearchSubsMinorListByOfficeRSQL(),param, velParam);
			returnStr = GemUtil.getArrayString(dbRowset, "code");
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return returnStr;
	}
	
    // ---------------------------------------------------------------------------
	//  로그인 사용자 권한에 따른 조회 가능한 오피스 정보 취득
	// ---------------------------------------------------------------------------
	
	/**
	 * 로그인 사용자 권한에 따른 조회 가능한 오피스 정보 취득
	 * 
	 * @author j.y.o
	 * @category searchOfficeByRole
	 * 
	 * @param rgnOfcFlg BO,BQ 구분
	 * @param ofcLvl1 1레벨
	 * @param ofcLvl2 2레벨
	 * @param ofcLvl3   2레벨
	 * @return String[]
	 * @throws DAOException
	 */
	public String[] searchOfficeByRole(String rgnOfcFlg, String ofcLvl1 , String ofcLvl2, String ofcLvl3 ) throws DAOException {
	
		DBRowSet dbRowset = null;
		String[] returnStr = null;
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		//velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
		try {
			
			param.put("rgn_ofc_flg", rgnOfcFlg);
			param.put("ofc_lvl1", ofcLvl1);
			param.put("ofc_lvl2", ofcLvl2);
			param.put("ofc_lvl3", ofcLvl3);			
			velParam.putAll(param);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GEMCommonDBDAOSearchOfficeByRoleRSQL(),param, velParam);
			returnStr = GemUtil.getArrayString(dbRowset, "ofc_cd");
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return returnStr;
	}	
	
	/**
	 * 조직별 사용가능한 비용 코드 조회
	 * 
	 * @author j.y.o
	 * @category searchOfficeByRole 
	 * @param String ofcCd 
	 * @return String[]
	 * @throws DAOException
	 */
	public String[] searchExpenseCdByRole(String ofcCd) throws DAOException {
	
		DBRowSet dbRowset = null;
		String[] returnStr = null;
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		//velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
		try {
			param.put("ofc_cd", ofcCd);

			velParam.put("ofc_cd", ofcCd);
				
			velParam.putAll(param);			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GEMCommonDBDAOSearchExpenseCdByRoleRSQL(),param, velParam);
			returnStr = GemUtil.getArrayString(dbRowset, "gen_expn_cd");
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return returnStr;
	}	
	
	
	/**
	 * 해당월까지 예산금액 합계취득
	 * 
	 * @author cyo
	 * @category searchSumGenExpnAmt
	 * @param String rsltYrmonStart
	 * @param String rsltYrmonEnd
	 * @param String ofcCd
	 * @param String genExpnCd
	 * @return SumGenExpnAmtVO
	 * @throws DAOException
	 */
    @SuppressWarnings("unchecked")
	public SumGenExpnAmtVO searchSumGenExpnAmt(String rsltYrmonStart ,String rsltYrmonEnd, String ofcCd,String genExpnCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<SumGenExpnAmtVO> list = null;
		
		try {
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("rslt_rymon_start", rsltYrmonStart);
			param.put("rslt_rymon_end", rsltYrmonEnd);
			param.put("ofc_cd", ofcCd);
			param.put("gen_expn_cd", genExpnCd);
			Map<String, Object> vparam = new HashMap<String, Object>();
			vparam.putAll(param);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GEMCommonDBDAOSearchSumGenExpnAmtRSQL(),param, vparam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SumGenExpnAmtVO.class);
			
			if (list != null && !list.isEmpty()) {
				return list.get(0);
			}
			
			return null;
			
		} catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        } catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        }
		
	}	
	
    
	/**
	 * 해당월까지 실적금액 합계취득
	 * 
	 * @author cyo
	 * @category searchSumSlipPerfAmt
	 * @param String rsltYrmonStart
	 * @param String rsltYrmonEnd
	 * @param String ofcCd
	 * @param String genExpnCd
	 * @return SumSlipPerfAmtVO
	 * @throws DAOException
	 */
    @SuppressWarnings("unchecked")
	public SumSlipPerfAmtVO searchSumSlipPerfAmt(String rsltYrmonStart ,String rsltYrmonEnd, String ofcCd,String genExpnCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<SumSlipPerfAmtVO> list = null;
		
		try {
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("rslt_rymon_start", rsltYrmonStart);
			param.put("rslt_rymon_end", rsltYrmonEnd);
			param.put("ofc_cd", ofcCd);
			param.put("gen_expn_cd", genExpnCd);
			Map<String, Object> vparam = new HashMap<String, Object>();
			vparam.putAll(param);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GEMCommonDBDAOSearchSumSlipPerfAmtRSQL(),param, vparam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SumSlipPerfAmtVO.class);
			
			if (list != null && !list.isEmpty()) {
				return list.get(0);
			}
			
			return null;
			
		} catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        } catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        }
		
	
	}    

	/**
	 * 해당월 전표정보 취득
	 * 
	 * @author cyo
	 * @category searchSlipPerf
	 * @param String rsltYrmon
	 * @param String ofcCd
	 * @param String genExpnCd
	 * @return List<SlipPerfVO>
	 * @throws DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<SlipPerfVO> searchSlipPerf(String rsltYrmon ,String ofcCd,String genExpnCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<SlipPerfVO> list = null;
		
		try {
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("rslt_yrmon", rsltYrmon);			
			param.put("ofc_cd", ofcCd);
			param.put("gen_expn_cd", genExpnCd);
			Map<String, Object> vparam = new HashMap<String, Object>();
			vparam.putAll(param);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GEMCommonDBDAOSearchSlipPerfRSQL(),param, vparam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SlipPerfVO.class);
			
		} catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        } catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        }
		
		return list;
	}    
    
	/**
	 * slip 예산 , 전표 금액 수정
	 * 
	 * @param List<SlipPerfVO> slipPerfVOList
	 * @throws DAOException
	 * @throws Exception
	 * @return int
	 */
	public int modifySlipPerf(List<SlipPerfVO> slipPerfVOList) throws DAOException,Exception {
		
		try {
			int cnt = 0;
			SQLExecuter sqlExe = new SQLExecuter("");				
			for (SlipPerfVO slipPerfVO : slipPerfVOList) {			
				Map<String , String> paramMap = slipPerfVO.getColumnValues();				
				cnt += sqlExe.executeUpdate((ISQLTemplate)new GEMCommonDBDAOModifySlipPerfUSQL(),paramMap ,null);			
			}
			
			return cnt;
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

	}    
	
	/**
	 * slip 예산 , 전표 금액 수정
	 * 
	 * @param List<SlipPerfVO> list
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int modifyRsltSmryByYrmon(List<SlipPerfVO> list) throws DAOException,Exception {
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			int insCnt[] = null;
			if (list.size() > 0) {
				//velocity parameter
		        Map<String, Object> velParam = new HashMap<String, Object>();
				insCnt = sqlExe.executeBatch((ISQLTemplate) new GEMCommonDBDAOModifyRsltSmryByYrmonUSQL(), list,velParam);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}			
			
			return insCnt.length;
			
							
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

	}   
	/**
	 * slip 실적누계금액 초기화 년월별
	 * 
	 * @param String rsltYrmon
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int modifyRsltSmryInitByYrmon(String rsltYrmon) throws DAOException,Exception {
		
		try {			
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String , String> paramMap = new HashMap<String, String>();
			paramMap.put("rslt_yrmon", rsltYrmon);
			return sqlExe.executeUpdate((ISQLTemplate)new GEMCommonDBDAOModifyRsltSmryInitByYrmonUSQL(),paramMap ,null);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

	}   	
    
}
