/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : CostStructureDBDAO.java
*@FileTitle : 물류비용 코드 등록, 전사계정과목 등록
*Open Issues :
*Change history :
*@LastModifyDate : 2009-10-21
*@LastModifier : 김기식
*@LastVersion : 1.23
* 2006-10-13 OKYOUNG IM
* 1.0 최초 생성
* 
* Change history : 
* 2008.02.13 전윤주 CSR NO.N200802010006 
*                  장비 부족지역 data 생성 시 기존 실적이 없는 ECC에 대해서도 data 생성, X level data delete 안함   
* 2008.04.28 전성진 CSR No.N200804210008
*            		- cost fixed 설정               
* 2008.07.29 김태윤 CSR No.N200807280011
*            		- Agreement 적용 제한 대상 Route 관리용 화면 추가 요청   
* 2008.09.05 전성진 CSR No.N200809030003
* 					- searchList변경.7레벨 추가
* 2008.09.09 전성진 CSR No.N200808228856
* 					- [001] Special Type Size 관련 쿼리 변경
* 2008.12.23 김태윤 CSR No.N200812230006 MAS Office 월별관리 후 table 수정 (MAS_OFC_LVL), mas_mon_vvd 와 조건 추가
* 2009.03.24 전윤주 CSR No.N200903190080 node 단가 조회 화면에 Trade 컬럼 추가
* 2009.03.26 박은주 : 품질검토결과 수정사항 반영                   
* 2009.07.09 김기대  New Framework 적용 [0002]
* 2009.07.10 박은주  New Framework 적용 [0001]
* 2009.08.03 전윤주  New Framework 적용 [0140]
* 2009.08.24 장영석  New Framework 적용 [0139]
* 2009.08.28 임옥영  New Framework 적용 [0137]
* 2009.10.07 장영석  New Framework 적용 [0160]
* 2009.10.21 김기식  New Framework 적용 [0003]
=========================================================*/

package com.hanjin.apps.alps.esm.mas.stdunitcost.coststructure.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.coststructure.basic.CostStructureBCImpl;
import com.hanjin.apps.alps.esm.mas.stdunitcost.coststructure.event.EsmMas0002Event;
import com.hanjin.apps.alps.esm.mas.stdunitcost.coststructure.vo.CostStructureCommonVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.coststructure.vo.CostStructureConditionVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.coststructure.vo.GetVariableheader2VO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.coststructure.vo.InqOffice0138VO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.coststructure.vo.NodLnkCostCodeVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.coststructure.vo.SearchCostCodeListVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.coststructure.vo.SearchCostStructure0139ListVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.coststructure.vo.SearchCostStructure0140ListVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.coststructure.vo.SearchSoCode0160ListVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.coststructure.vo.SearchSoCodeListVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.coststructure.vo.SpclRepoCntrVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.coststructure.vo.TableColumnVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.coststructure.vo.RevExpChargeVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.MasSpclRepoCntrRgstVO;
import com.hanjin.syscommon.common.table.MasTrnsFdrTermVO;
import com.hanjin.syscommon.common.table.MasTrnsTermCalcVO;



/**
 * eNIS-MAS에 대한 DB 처리를 담당<br>
 * - eNIS-MAS Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author OKYOUNG IM
 * @see CostStructureBCImpl 참조
 * @since J2EE 1.4
 */
public class CostStructureDBDAO extends DBDAOSupport {

	/**
	 * CostStructureDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @return List<SpclRepoCntrVO>
	 * @throws DAOException
	 */
	public List<SpclRepoCntrVO> searchSpclRepoCntrList() throws DAOException {
		DBRowSet dbRowset = null;
		List<SpclRepoCntrVO> list = null;

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CostStructureDBDAOSearchSpclRepoCntrRSQL(), null, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SpclRepoCntrVO.class);
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
	 * 다건의 데이터를 일괄적으로 생성한다.<br>
	 * 
	 * @param List<MasSpclRepoCntrRgstVO> insModels
	 * @throws DAOException
	 */
	public void addSpclRepoCntr(List<MasSpclRepoCntrRgstVO> insModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new CostStructureDBDAOMultiSpclRepoCntrCSQL(), insModels,null);
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
	 * 다건의 데이터를 일괄적으로 갱신한다.<br>
	 * 
	 * @param List<MasSpclRepoCntrRgstVO> updModels
	 * @throws DAOException
	 */
	public void modifySpclRepoCntr(List<MasSpclRepoCntrRgstVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new CostStructureDBDAOMultiSpclRepoCntrUSQL(), updModels,null);
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
	 * 다건의 데이터를 일괄적으로 삭제한다.<br>
	 * 
	 * @param List<MasSpclRepoCntrRgstVO> delModels
	 * @throws DAOException
	 */
	public void removeSpclRepoCntr(List<MasSpclRepoCntrRgstVO> delModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new CostStructureDBDAOMultiSpclRepoCntrDSQL(), delModels,null);
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
	 * Cost Element의 모든 목록을 가져온다.<br>
	 * join table MAS_STND_ACCT, MAS_MN_GRP_COST, MAS_SUB_GRP_COST<br>
	 * main table MAS_STND_ACCT<br>
	 * ESM_MAS_0002
	 * 
	 * @param CostStructureCommonVO vo
	 * @return List<SearchCostCodeListVO>
	 * @throws DAOException
	 */
	 public List<SearchCostCodeListVO> searchCostCodeList(CostStructureCommonVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchCostCodeListVO> list = null;
		try{
			if(vo == null) return null;	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CostStructureDBDAOSearchCostCodeListRSQL(), vo.getIndirectQueryParameter(), vo.getIndirectVelocityParameter());
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchCostCodeListVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			log.error("err "+se.toString(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			log.error("err "+ex.toString(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	 }	

		/**
	 	 * Inquiry_Office의 데이타 모델에 해당되는 값을 불러온다.<br>
		 * 
		 * @param SearchConditionVO searchConditionVO
		 * @return List<InqOffice0138VO>
		 * @throws DAOException
		 */
		public List<InqOffice0138VO> searchInqOffice0138List(SearchConditionVO searchConditionVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<InqOffice0138VO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(searchConditionVO != null){
					Map<String, String> mapVO = searchConditionVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CostStructureDBDAOSearchInqOffice0138ListRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, InqOffice0138VO .class);
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return list;
		}
	
	/**
	 * Cost Element의 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정, 삭제)<br>
	 * 입력, 삭제 작업은 MAS_STND_ACCT 테이블에서만 일어난다.<br>
	 * 수정 작업은 MAS_COST_SRC_ACCT, MAS_STND_ACCT에서 일어난다.<br>
	 * 
	 * @param CostStructureCommonVO vo
	 * @see EsmMas0002Event
	 * @throws DAOException
	 */
	 public void multiCostCode(CostStructureCommonVO vo) throws DAOException {
        int insCnt[] = null;
        int updCnt[] = null;
        int delCnt[] = null;
		
        try{
            //SQLExecuter sqlExe = new SQLExecuter("ENIS");
        	SQLExecuter sqlExe = new SQLExecuter("");
            
            if(vo.getMultiCreateList().size() > 0){
                insCnt = sqlExe.executeBatch((ISQLTemplate)new CostStructureDBDAOMultiCostCodeCSQL(), vo.getMultiCreateList(), null);
                for(int i = 0; i < insCnt.length; i++){
                    if(insCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No"+ i + " SQL");
                }            	
            }
            
            if(vo.getMultiUpdateList().size() > 0){
            	updCnt = sqlExe.executeBatch((ISQLTemplate)new CostStructureDBDAOMultiCostCodeUSQL(), vo.getMultiUpdateList(), null);
                for(int i = 0; i < updCnt.length; i++){
                    if(updCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to update No"+ i + " SQL");
                }            	
            }
            
            if(vo.getMultiDeleteList().size() > 0){
                delCnt = sqlExe.executeBatch((ISQLTemplate)new CostStructureDBDAOMultiCostCodeDSQL(), vo.getMultiDeleteList(), null);
                for(int i = 0; i < delCnt.length; i++){
                    if(delCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to delete No"+ i + " SQL");
                }            	
            }            
        }catch (SQLException se) {
        	log.error("err "+se.toString(),se);
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
        	log.error("err "+ex.toString(),ex);
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
	 }	
	
	 
	/**
	 * So Cost Code의 모든 목록을 가져온다.<br>
	 * ESM_MAS_003
	 * 
	 * @param  CostStructureConditionVO vo
	 * @param  String userId 
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchSoCodeList(CostStructureConditionVO vo, String userId) throws DAOException {
		DBRowSet dbRowset = null;
		//헤더용
		DBRowSet dRs2 = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<String> cols  = new ArrayList();
		int saveCnt = 0;
		
		try{			
			Map<String, String> mapVO = vo.getColumnValues();				
			param.putAll(mapVO);
			velParam.putAll(mapVO);	
			
			//header 변수 세팅
			dRs2 = getVariableHeader();
			
			if(dRs2 != null){
				while(dRs2.next()){									
					cols.add(dRs2.getString("code"));
				}
			}
			velParam.put("allcols", cols);						
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CostStructureDBDAOSearchSoCodeListRSQL(), param, velParam);
			
			// MAS_ACT_GRP_COST_MAPG 테이블 싱크 처리 
			param.put("user_id"  , userId);
			saveCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new CostStructureDBDAOUpdateMasActGrpCostMapgCSQL(), param, velParam);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}
		
	/**
	 * 가변헤더를 가져온다. TABLE:PRD_ACT_GRP
	 * @return DBRowSet DB 처리 결과 "|"으로 연결
	 * @throws DAOException
	 */
	public DBRowSet getVariableHeader() throws DAOException{
		DBRowSet dbRowset = null;
		
		try{			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CostStructureDBDAOGetVariableHeaderRSQL(), null, null);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}
	
	
	/**
	 * So Cost Code의 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정, 삭제)<br>
	 * 입력, 수정, 삭제 작업은 MAS_COST_SRC_ACCT 테이블에서 일어난다.
	 * <br>
	 * 
	 * @param   SearchSoCodeListVO vo
	 * @see ESM_MAS_0003Event
	 * @throws  DAOException
	 */
	public void multiSoCodeSrcAcct(SearchSoCodeListVO vo) throws DAOException {
        int saveCnt[] = null;

        try{
            SQLExecuter sqlExe = new SQLExecuter("");
            if(vo.getMultiSaveList().size() > 0){
                saveCnt = sqlExe.executeBatch((ISQLTemplate)new CostStructureDBDAOMultiSoCodeSrcAcctCSQL(), vo.getMultiSaveList(), null);
                for(int i = 0; i < saveCnt.length; i++){
                    if(saveCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No"+ i + " SQL");
                }
            }

        }catch (SQLException se) {
            log.error("err "+se.toString(),se);
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error("err "+ex.toString(),ex);
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
    }
	
	/**
	 * So Cost Code의 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정, 삭제)<br>
	 * 입력, 수정, 삭제 작업은 MAS_ACT_GRP_COST_MAPG 테이블에서 일어난다.
	 * <br>
	 * 
	 * @param   SearchSoCodeListVO vo
	 * @see ESM_MAS_0003Event
	 * @throws  DAOException
	 */
	public void multiSoCodeCostMapg(SearchSoCodeListVO vo) throws DAOException {
        int saveCnt[] = null;

        try{
            SQLExecuter sqlExe = new SQLExecuter("");
            if(vo.getMultiSaveList2().size() > 0){
                saveCnt = sqlExe.executeBatch((ISQLTemplate)new CostStructureDBDAOMultiSoCodeCostMapgCSQL(), vo.getMultiSaveList2(), null);
                for(int i = 0; i < saveCnt.length; i++){
                    if(saveCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No"+ i + " SQL");
                }
            }

        }catch (SQLException se) {
            log.error("err "+se.toString(),se);
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error("err "+ex.toString(),ex);
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
    }
	
//	
//	/**
//	 * MDM_CNTR_TP_SZ 테이블의 cntr_tpsz_cd 값을 가져온다.<br>
//	 * main table MDM_CNTR_TP_SZ<br>
//	 * 
//	 * @return String DB 처리 결과 "|"으로 연결
//	 * @throws DAOException
//	 */
//	public String getContainerType() throws DAOException {
//		// Connection Interface
//		Connection con = null;
//		// 정적파싱을 지원하는 SQL Statement
//		PreparedStatement pstmt = null;
//		// DB ResultSet
//		ResultSet rs = null;
//		int i = 1;
//		
//		String cntTP = "";
//		String queryStr = "\nSELECT"
//			 + "\n	DISTINCT(cntr_tpsz_cd)"
//			 + "\n FROM mdm_cntr_tp_sz"
//			 + "\n WHERE 1=?"
//			 + "\n ORDER BY cntr_tpsz_cd";
//	
//		try {
//			con = getConnection(); 
//			
//			// Loggable Statement 사용에 의해 추가 
//			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
//				pstmt = new LoggableStatement(con, queryStr);
//				log.info("\n SQL :" + ((LoggableStatement)pstmt).getQueryString());
//			} else {
//				pstmt = con.prepareStatement(queryStr);
//				log.info("\n SQL :" + queryStr );
//			}
//			
//			pstmt.setInt(i++, 1);
//			
//			// Loggable Statement 사용에 의해 추가
//			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
//				log.info("\n SQL :" + ((LoggableStatement)pstmt).getQueryString());
//
//			} else {
//				log.info("\n SQL :" + queryStr );
//			}			
//			
//			rs = pstmt.executeQuery();
//			
//			if(rs != null){
//				while(rs.next()){
//					cntTP = cntTP + rs.getString("cntr_tpsz_cd");
//					cntTP = cntTP +  "|";
//				}
//			}
//
//		} catch (SQLException se) {
//			log.error(se.getMessage(), se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		} catch (DAOException de) {
//			log.error(de.getMessage(), de);
//			throw de;
//		} catch (Exception e) {
//			log.error(e.getMessage(), e);
//			throw new DAOException(e.getMessage());
//		} finally {
//			closeResultSet(rs);
//			closeStatement(pstmt);
//			closeConnection(con);
//		}
//		return cntTP;	
//	}	
//	
//	
//	/**
//	 *  Unit Cost 생성 모든 목록을 가져온다.<br>
//	 * @param et 
//	 * 
//	 * @return DBRowSet DB 처리 결과
//	 * @throws DAOException
//	 */
//	/*
//	public DBRowSet searchCostStructure108List(Event et) throws DAOException {
//		// Connection Interface
//		Connection con = null;
//		// 정적파싱을 지원하는 SQL Statement
//		PreparedStatement ps = null;
//		// DB ResultSet
//		ResultSet rs = null;
//		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
//		DBRowSet dRs = null;
//		// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
//		int i = 1;
//		ESM_MAS_108Event event = (ESM_MAS_108Event)et;
//	
//		StringBuffer queryStr = new StringBuffer();
//		queryStr.append("\n SELECT   ? cost_yrmon");
//		queryStr.append("\n         ,a2.intg_cd_val_ctnt cm_uc_cd");
//		queryStr.append("\n         ,a2.intg_cd_val_dp_desc cm_uc_nm");
//		queryStr.append("\n         ,a1.cost_cre_flg");
//		queryStr.append("\n         ,a1.ecc_cd");
//		queryStr.append("\n         ,a1.scc_cd");
//		queryStr.append("\n         ,a1.loc_cd");
//		
//		//queryStr.append("\n         ,a1.cost_if_sts_cd");
//		//full seteve, full trans, agt commision 일경우 completed로 설정
//		//queryStr.append("\n         ,DECODE(a2.intg_cd_val_ctnt, 'CVFS', 'C', 'CVFT', 'C', 'AGTC', 'C',  a1.cost_if_sts_cd) cost_if_sts_cd");		
//		queryStr.append("\n         ,a1.cost_if_sts_cd");		
//		queryStr.append("\n         ,DECODE(a2.intg_cd_val_ctnt, 'AGTC', 'C', a1.cost_cre_sts_cd) cost_cre_sts_cd" );
//		queryStr.append("\n         ,mas_get_cd_nm_fnc('CD00214', DECODE(a2.intg_cd_val_ctnt, 'AGTC', 'C', NVL(a1.cost_cre_sts_cd, 'R'))) cost_cre_sts_nm");
//		queryStr.append("\n         ,a1.cost_src_fm_yrmon");
//		queryStr.append("\n         ,a1.cost_src_to_yrmon");
//		queryStr.append("\n     FROM mas_ut_cost_cre_sts a1, com_intg_cd_dtl a2");
//		queryStr.append("\n    WHERE a1.cm_uc_cd(+) = a2.intg_cd_val_ctnt");
//		queryStr.append("\n      AND a2.intg_cd_id = 'CD00806'");
//		queryStr.append("\n      AND a1.cost_yrmon(+) = ?");
//		
//		queryStr.append("\n ORDER BY a2.intg_cd_val_dp_seq");
//
//		try {
//			con = getConnection();
//			
//	    	// Loggable Statement 사용에 의해 추가 
//			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
//				ps = new LoggableStatement(con, queryStr.toString());
//			} else {
//				ps = con.prepareStatement(queryStr.toString());
//			}
//	
//	    	ps.setString(i++, event.getString("f_cost_yrmon").replaceAll("-",""));
//	    	ps.setString(i++, event.getString("f_cost_yrmon").replaceAll("-",""));
//			
//			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
//				log.info("\n SQL : \n" + ((LoggableStatement)ps).getQueryString());
//			} else {
//				log.info("\n SQL : \n" + queryStr );
//			}
//	
//			rs = ps.executeQuery();
//	
//			// 결과를 DBRowset에 담는다.
//			dRs = new DBRowSet();
//			dRs.populate(rs);
//		} catch (SQLException se) {
//			log.error(se.getMessage(), se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		} catch (DAOException de) {
//			log.error(de.getMessage(), de);
//			throw de;
//		} catch (Exception e) {
//			log.error(e.getMessage(), e);
//			throw new DAOException(e.getMessage());
//		} finally {
//			closeResultSet(rs);
//			closeStatement(ps);
//			closeConnection(con);
//		}
//		return dRs;
//	}
//	*/
//	/**
//	 * Unit Cost의 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.<br>
//	 * (cost_if_sts_cd 수정)<br>
//	 * 
//	 * @param et 
//	 * @throws DAOException
//	 */
//	
//	/*
//	public void multiCostStructure108(Event et) throws DAOException {
//		log.debug("\n\n dao multiCostStructure108()");
//		Connection con = null;// Connection Interface
//		PreparedStatement ps = null;// 정적파싱을 지원하는 SQL Statement
//		int i = 1;// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
//
//		// pk : cost_yrmon, cm_uc_cd, table:mas_ut_cost_cre_sts
//		String f_cost_yrmon = "";
//		String[] cm_uc_cd = null;
//		String[] cost_if_sts_cd = null;
//		String[] ibflag = null;
//		String[] cost_cre_sts_cd_list = null;
//		String cost_cre_sts_cd = null;
//		String queryStr = "";
//			
//		ESM_MAS_108Event event = (ESM_MAS_108Event) et;
//		f_cost_yrmon = JSPUtil.getNull(event.getString("f_cost_yrmon"));
//		f_cost_yrmon = f_cost_yrmon.replaceAll("-", "");
//		cm_uc_cd = event.getObject("cm_uc_cd");
//		cost_if_sts_cd = event.getObject("cost_if_sts_cd");
//		cost_cre_sts_cd_list = event.getObject("cost_cre_sts_cd");
//		ibflag = event.getObject("ibflag");
//
//		try {
//
//			con = getConnection();
//
//			for (int j = 0; j < ibflag.length; j++) {
//				queryStr = "";
//				queryStr = queryStr + "\n UPDATE mas_ut_cost_cre_sts";
//				queryStr = queryStr + "\n    SET cost_if_sts_cd = ?";
//				if (!cost_cre_sts_cd_list[j].equals("P")) {
//					queryStr = queryStr + "\n      , cost_cre_sts_cd = ?";
//				}
//				queryStr = queryStr + "\n  WHERE cost_yrmon = ?";
//				queryStr = queryStr + "\n    AND cm_uc_cd = ?";
//
//				// Loggable Statement 사용에 의해 추가
//				if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
//					ps = new LoggableStatement(con, queryStr);
//
//				} else {
//					ps = con.prepareStatement(queryStr);
//				}
//
//				if ("U".equals(ibflag[j])) {
//					// 다음 코드는 배치를 안돌리므로 complete 되면 배치돈거 처럼 한다.
//					if (cm_uc_cd[j].equals("DMDT") 
//							|| cm_uc_cd[j].equals("MTRP")
//							|| cm_uc_cd[j].equals("EQHD") 
//							|| cm_uc_cd[j].equals("AGTC") 
//							|| cm_uc_cd[j].equals("POCN")
//							|| cm_uc_cd[j].equals("EMUA") 
//							|| cm_uc_cd[j].equals("SMUA") 
//							|| cm_uc_cd[j].equals("TMNL")
//							) {
//						if (cost_if_sts_cd[j].equals("C")) {
//							cost_cre_sts_cd = "C";
//						} else {
//							cost_cre_sts_cd = "R";
//						}
//					} else {
//						cost_cre_sts_cd = cost_cre_sts_cd_list[j];
//					}
//					log.debug("\n\ncm_uc_cd[j]:"+cm_uc_cd[j]
//					         +"\ncost_if_sts_cd[j]:"+cost_if_sts_cd[j]
//					         +"\ncost_cre_sts_cd:"+cost_cre_sts_cd);
//					// setting
//					i = 1;
//					ps.setString(i++, cost_if_sts_cd[j]);
//					if (!cost_cre_sts_cd_list[j].equals("P")) {
//						ps.setString(i++, cost_cre_sts_cd);
//					}
//					ps.setString(i++, f_cost_yrmon);
//					ps.setString(i++, cm_uc_cd[j]);
//					ps.executeUpdate();
//				}
//			}
//
//			// Loggable Statement 사용에 의해 추가
//			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
//				log.info("\n SQL :" + ((LoggableStatement) ps).getQueryString());
//			} else {
//				log.info("\n SQL :" + queryStr);
//			}
//
//		} catch (SQLException se) {
//			log.error(se.getMessage(), se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		} catch (DAOException de) {
//			log.error(de.getMessage(), de);
//			throw de;
//		} catch (Exception e) {
//			log.error(e.getMessage(), e);
//			throw new DAOException(e.getMessage());
//		} finally {
//			closeStatement(ps);
//			closeConnection(con);
//		}
//	}*/
//	
//
//	/**
//	 * CostStructure의 데이타 모델을 DB에 저장한다.<br>
//	 * 
//	 * @param et
//	 * 
//	 * @param model
//	 *            데이타 모델
//	 * @throws DAOException
//	 */
//	/*
//	public void addMAS_UT_COST_CRE_STS(Event et) throws DAOException {
//	    ESM_MAS_108Event event = (ESM_MAS_108Event)et;
//
//	    // Connection Interface
//		Connection con = null;
//		// 정적파싱을 지원하는 SQL Statement
//		PreparedStatement ps = null;
//		
//		StringBuffer queryStr = new StringBuffer() ;
//		
//		queryStr.append("\n MERGE INTO mas_ut_cost_cre_sts b1");
//		queryStr.append("\n    USING (SELECT ? cost_yrmon");
//		queryStr.append("\n                 ,intg_cd_val_ctnt cm_uc_cd");
//		queryStr.append("\n             FROM com_intg_cd_dtl");
//		queryStr.append("\n            WHERE intg_cd_id = 'CD00806') b2");
//		queryStr.append("\n    ON (    b1.cost_yrmon = b2.cost_yrmon");
//		queryStr.append("\n        AND b1.cm_uc_cd = b2.cm_uc_cd)");
//		queryStr.append("\n    WHEN NOT MATCHED THEN");
//		queryStr.append("\n       INSERT (b1.cost_yrmon, b1.cm_uc_cd, b1.cost_cre_sts_cd, b1.cre_usr_id, b1.cre_dt, b1.upd_usr_id, b1.upd_dt)");
//		queryStr.append("\n       VALUES (?, b2.cm_uc_cd, 'R', ?, SYSDATE, ?, SYSDATE)");
//
//		try {
//			con = getConnection();
//			
//			// Loggable Statement 사용에 의해 추가 
//			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
//				ps = new LoggableStatement(con, queryStr.toString());
//			} else {
//				ps = con.prepareStatement(queryStr.toString());
//			}
//			
//			// 쿼리에 변수 세팅. 
//			int i = 1;
//			ps.setString(i++, event.getString("f_cost_yrmon").replaceAll("-",""));
//			ps.setString(i++, event.getString("f_cost_yrmon").replaceAll("-",""));
//			ps.setString(i++, event.getUserId());
//			ps.setString(i++, event.getUserId());
//			
//			// Loggable Statement 사용에 의해 추가 
//			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
//				log.info("\n SQL :" + ((LoggableStatement)ps).getQueryString());
//			} else {
//				log.info("\n SQL :" + queryStr );
//			}
//			
//			ps.executeQuery();
//			
//		} catch (SQLException se) {
//			log.error(se.getMessage(), se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		} catch (DAOException de) {
//			log.error(de.getMessage(), de);
//			throw de;
//		} catch (Exception e) {
//			log.error(e.getMessage(), e);
//			throw new DAOException(e.getMessage());
//		} finally {
//			closeStatement(ps);
//			closeConnection(con);
//		}
//	}
//	*/
//
//	/**
//	 * CostStructure의 수정 된 데이타 모델을 DB에 반영한다.<br>
//	 * @param str 
//	 * 
//	 * @param model 데이타 모델
//	 * @throws DAOException
//	 */
//	public void modifyMAS_UT_COST_CRE_STS(String str) throws DAOException {
//		HashMap hm = Utils.createMap(str);
//
//	    // Connection Interface
//		Connection con = null;
//		// 정적파싱을 지원하는 SQL Statement
//		PreparedStatement ps = null;
//
//		StringBuffer queryStr = new StringBuffer() ;
//
//		queryStr.append("\n UPDATE mas_ut_cost_cre_sts");
//		queryStr.append("\n    SET cost_cre_sts_cd = ?");
//		queryStr.append("\n      , upd_usr_id = ?");
//		queryStr.append("\n      , upd_dt = SYSDATE");
//		queryStr.append("\n  WHERE cost_yrmon = ?");
//		queryStr.append("\n    AND cm_uc_cd = ?");
//		
//		try {
//			con = getConnection();
//			
//			// Loggable Statement 사용에 의해 추가 
//			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
//				ps = new LoggableStatement(con, queryStr.toString());
//			} else {
//				ps = con.prepareStatement(queryStr.toString());
//			}
//			
//			// 쿼리에 변수 세팅. 
//			int i = 1;
//			ps.setString(i++, ((String)hm.get("cost_cre_sts_cd")));
//			ps.setString(i++, ((String)hm.get("user_id")));
//			ps.setString(i++, ((String)hm.get("f_cost_yrmon")).replaceAll("-",""));
//			ps.setString(i++, ((String)hm.get("cm_uc_cd")));
//			
//			// Loggable Statement 사용에 의해 추가 
//			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
//				log.info("\n SQL :" + ((LoggableStatement)ps).getQueryString());
//			} else {
//				log.info("\n SQL :" + queryStr );
//			}
//			
//			ps.executeUpdate();
//		} catch (SQLException se) {
//			log.error(se.getMessage(), se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		} catch (DAOException de) {
//			log.error(de.getMessage(), de);
//			throw de;
//		} catch (Exception e) {
//			log.error(e.getMessage(), e);
//			throw new DAOException(e.getMessage());
//		} finally {
//			closeStatement(ps);
//			closeConnection(con);
//		}
//	}
//
//	/**
//	 * 공통코드 테이블에서 contribution margin unit cost code 값을 가져온다.<br>
//	 * "CD00806"
//	 * 
//	 * @return DBRowSet
//	 * @throws DAOException
//	 */
//	public DBRowSet getCMCostCode() throws DAOException{
//		// Connection Interface
//		Connection con = null;
//		// 정적파싱을 지원하는 SQL Statement
//		PreparedStatement pstmt = null;
//		// DB ResultSet
//		ResultSet rs = null;
//		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
//		DBRowSet dRs = null;
//		// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
//		int i = 1;
//
//		String queryStr = "\n SELECT intg_cd_val_ctnt code, intg_cd_val_dp_desc value"
//			 + "\n FROM com_intg_cd_dtl"
//			 + "\n WHERE intg_cd_id = ?"
//			 + "\n ORDER BY intg_cd_val_dp_seq";
//		
//		try {
//			con = getConnection(); 
//			
//			// Loggable Statement 사용에 의해 추가 
//			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
//				pstmt = new LoggableStatement(con, queryStr);
//				log.info("\n SQL :" + ((LoggableStatement)pstmt).getQueryString());
//			} else {
//				pstmt = con.prepareStatement(queryStr);
//				log.info("\n SQL :" + queryStr );
//			}
//			
//			pstmt.setString(i++, "CD00280");
//			
//			// Loggable Statement 사용에 의해 추가
//			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
//				log.info("\n SQL :" + ((LoggableStatement)pstmt).getQueryString());
//
//			} else {
//				log.info("\n SQL :" + queryStr );
//			}			
//			
//			rs = pstmt.executeQuery();
//			
//			// 결과를 DBRowset에 담는다.
//			dRs = new DBRowSet();
//			dRs.populate(rs);
//		} catch (SQLException se) {
//			log.error(se.getMessage(), se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		} catch (DAOException de) {
//			log.error(de.getMessage(), de);
//			throw de;
//		} catch (Exception e) {
//			log.error(e.getMessage(), e);
//			throw new DAOException(e.getMessage());
//		} finally {
//			closeResultSet(rs);
//			closeStatement(pstmt);
//			closeConnection(con);
//		}
//		return dRs;
//		
//	}
//	 
//	/**
//	 * 
//	 * @param e
//	 * @return boolean
//	 * @throws DAOException
//	 */
//	public boolean removePortTariff (Event e) throws DAOException {
//		e = null;
//		/*
//		delete from pso s/o port tariff
//		where cost year = '2006'
//		*/
//		return true;
//	}
//	
//	/**
//	 * NMS/YMS 공통 테이블 생성 - Java 버전..
//	 * @param str 
//	 * @return
//	 * @throws DAOException
//	 */
//	public int createFullSteve(String str) throws DAOException {
//		log.debug("### createFullSteve str:"+str);
//		HashMap hm = Utils.createMap(str);
//	
//		int i = 1; // PreparedStatement에 bind 변수를 넣을시 증가되는 변수
//		int resultCount = 0; // 수행 결과가 정상인지를 판별하기 위한 변수
//		Connection con = null; // Connection Interface
//		CallableStatement cs = null; // 정적파싱을 지원하는 SQL Statement
//	
//		StringBuffer queryStr = new StringBuffer();
//		queryStr.append(" call MAS_NOD_AVG_STND_COST_PRC(?,?,?)" + "\n");
//	
//		try {
//			con = getConnection();
//			
//			cs = con.prepareCall(queryStr.toString());
//	
//			// 쿼리에 변수 세팅.
//			i = 1;
//			cs.setString(i++, ((String)hm.get("f_cost_yrmon")).replaceAll("-",""));
//			cs.setString(i++, ((String)hm.get("user_id")));
//			cs.registerOutParameter(i++, OracleTypes.NUMBER);
//	
//			// Loggable Statement 사용에 의해 추가
//			log.info("\n SQL :\n" + queryStr.toString());
//			cs.executeUpdate();
//			resultCount = cs.getInt(3);
//			log.debug("### MAS_NOD_AVG_STND_COST_PRC result : " + resultCount);
//	
//		} catch (SQLException se) {
//			log.error(se.getMessage(), se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		} catch (DAOException de) {
//			log.error(de.getMessage(), de);
//			throw de;
//		} catch (Exception e) {
//			log.error(e.getMessage(), e);
//			throw new DAOException(e.getMessage());
//		} finally {
//			closeStatement(cs);
//			closeConnection(con);
//		}
//		return resultCount;
//	}
//
//	/**
//	 * NMS/YMS 공통 테이블 생성 - Java 버전..
//	 * @param str 
//	 * @return
//	 * @throws DAOException
//	 */
//	public int createAbcStpCost(String str) throws DAOException {
//		log.info("### createAbcStpCost str:"+str);
//		HashMap hm = Utils.createMap(str);
//	
//		int i = 1; // PreparedStatement에 bind 변수를 넣을시 증가되는 변수
//		int resultCount = 0; // 수행 결과가 정상인지를 판별하기 위한 변수
//		Connection con = null; // Connection Interface
//		CallableStatement cs = null; // 정적파싱을 지원하는 SQL Statement
//	
//		StringBuffer queryStr = new StringBuffer();
//		queryStr.append(" call MAS_ABC_STP_PRC(?)" + "\n");
//	
//		try {
//			con = getConnection();
//			
//			cs = con.prepareCall(queryStr.toString());
//	
//			// 쿼리에 변수 세팅.
//			i = 1;
//			cs.setString(i++, ((String)hm.get("f_cost_yrmon")).replaceAll("-",""));
//	
//			// Loggable Statement 사용에 의해 추가
//			log.info("\n SQL :\n" + queryStr.toString());
//			resultCount = cs.executeUpdate();
//			log.debug("### MAS_ABC_STP_PRC result : " + resultCount);
//	
//		} catch (SQLException se) {
//			log.error(se.getMessage(), se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		} catch (DAOException de) {
//			log.error(de.getMessage(), de);
//			throw de;
//		} catch (Exception e) {
//			log.error(e.getMessage(), e);
//			throw new DAOException(e.getMessage());
//		} finally {
//			closeStatement(cs);
//			closeConnection(con);
//		}
//		return resultCount;
//	}
//
//	/**
//	 * Full Trans(CVFT)
//	 * 
//	 * @param str
//	 * @return boolean 실행결과
//	 * @exception DAOException
//	 */
//	public int createFulTrans(String str) throws DAOException {
//		log.debug("### createFulTrans str:"+str);
//		HashMap hm = Utils.createMap(str);
//	
//		int i = 1; // PreparedStatement에 bind 변수를 넣을시 증가되는 변수
//		int resultCount = 0; // 수행 결과가 정상인지를 판별하기 위한 변수
//		Connection con = null; // Connection Interface
//		CallableStatement cs = null; // 정적파싱을 지원하는 SQL Statement
//	
//		StringBuffer queryStr = new StringBuffer();
//		queryStr.append(" call MAS_LNK_AVG_STND_COST_PRC(?,?,?)" + "\n");
//	
//		try {
//			con = getConnection();
//			
//			cs = con.prepareCall(queryStr.toString());
//	
//			// 쿼리에 변수 세팅.
//			i = 1;
//			cs.setString(i++, ((String)hm.get("f_cost_yrmon")).replaceAll("-",""));
//			cs.setString(i++, ((String)hm.get("user_id")));
//			cs.registerOutParameter(i++, OracleTypes.NUMBER);
//
//			// Loggable Statement 사용에 의해 추가
//			log.info("\n SQL :\n" + queryStr.toString());
//			cs.executeUpdate();
//			resultCount = cs.getInt(3);
//			log.debug("### MAS_LNK_AVG_STND_COST_PRC result : " + resultCount);
//	
//		} catch (SQLException se) {
//			log.error(se.getMessage(), se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		} catch (DAOException de) {
//			log.error(de.getMessage(), de);
//			throw de;
//		} catch (Exception e) {
//			log.error(e.getMessage(), e);
//			throw new DAOException(e.getMessage());
//		} finally {
//			closeStatement(cs);
//			closeConnection(con);
//		}
//		return resultCount;
//	}
//
//	/**
//	 * createEQBalance
//	 * 
//	 * @param str
//	 * @return boolean 실행결과
//	 * @exception DAOException
//	 */
//	public boolean createEQBalance(String str) throws DAOException {
//		log.debug("### createEQBalance str:"+str);
//		HashMap hm = Utils.createMap(str);
//
//		// Connection Interface
//		Connection con = null;
//		// 정적파싱을 지원하는 SQL Statement
//		PreparedStatement deletePs = null;
//		//PreparedStatement deletePs2 = null;
//		PreparedStatement insertPs = null;
//		PreparedStatement updatePs = null;
//		// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
//		int i = 1;
//
//		// 삭제 쿼리
//		//--------------------------------------------------------------------------------------------------------
//		StringBuffer deleteQuery = new StringBuffer() ;
//		deleteQuery.append("\n DELETE mas_cntr_repo_shtg_info");
//		deleteQuery.append("\n  WHERE cost_yrmon = ?");
//		//--------------------------------------------------------------------------------------------------------
//
//		// 삽입 쿼리 
//		//--------------------------------------------------------------------------------------------------------
//		StringBuffer insertQuery = new StringBuffer() ;
//		insertQuery.append("\nINSERT INTO mas_cntr_repo_shtg_info ");
//		insertQuery.append("\n   (cost_yrmon ");
//		insertQuery.append("\n  , cntr_tpsz_cd ");
//		insertQuery.append("\n  , ecc_cd ");
//		insertQuery.append("\n  , lcc_cd ");
//		insertQuery.append("\n  , rcc_cd ");
//		insertQuery.append("\n  , imbal_cr_lvl ");
//		insertQuery.append("\n  , opb_cr_lvl ");
//		insertQuery.append("\n  , mb_cr_lvl ");
//		insertQuery.append("\n  , imbal_amt ");
//		insertQuery.append("\n  , opb_amt ");
//		insertQuery.append("\n  , mb_amt ");
//		insertQuery.append("\n  , cre_usr_id ");
//		insertQuery.append("\n  , cre_dt ");
//		insertQuery.append("\n   ) ");
//		insertQuery.append("\n   SELECT ? ");
//		insertQuery.append("\n        , cntr_tpsz_cd ");
//		insertQuery.append("\n        , ecc_cd ");
//		insertQuery.append("\n        , lcc_cd ");
//		insertQuery.append("\n        , rcc_cd ");
//		insertQuery.append("\n        , (SELECT MAX (eq_repo_cr_lvl) ");
//		insertQuery.append("\n    FROM mas_cntr_repo_rule b ");
//		insertQuery.append("\n   WHERE b.cost_yrmon = ? ");
//		insertQuery.append("\n     AND b.cntr_tpsz_cd = a.cntr_tpsz_cd ");
//		insertQuery.append("\n     AND ( DECODE(b.eq_repo_cr_lvl, 'X', a.imbalance, a.inbal_ranking) >= b.imbal_fm_rto");
//		insertQuery.append("\n          OR DECODE(b.eq_repo_cr_lvl, 'X', a.imbalance, a.inbal_ranking) > b.imbal_to_rto");
//		insertQuery.append("\n         )");
//		insertQuery.append("\n     AND b.imbal_all_aply_flg = 'Y') imbalance_level ");
//		insertQuery.append("\n        , (SELECT b.eq_repo_cr_lvl ");
//		insertQuery.append("\n    FROM mas_cntr_repo_rule b ");
//		insertQuery.append("\n   WHERE b.cost_yrmon = ? ");
//		insertQuery.append("\n     AND b.cntr_tpsz_cd = a.cntr_tpsz_cd ");
//		insertQuery.append("\n     AND a.cmb BETWEEN b.opb_fm_amt AND b.opb_to_amt ");
//		insertQuery.append("\n     AND b.opb_all_aply_flg = 'Y') opb_level ");
//		insertQuery.append("\n        , (SELECT b.eq_repo_cr_lvl ");
//		insertQuery.append("\n    FROM mas_cntr_repo_rule b ");
//		insertQuery.append("\n   WHERE b.cost_yrmon = ? ");
//		insertQuery.append("\n     AND b.cntr_tpsz_cd = a.cntr_tpsz_cd ");
//		insertQuery.append("\n     AND a.matchback BETWEEN b.mb_fm_rto AND b.mb_to_rto ");
//		insertQuery.append("\n     AND b.mb_all_aply_flg = 'Y') mb_level ");
//		insertQuery.append("\n        , a.imbalance ");
//		insertQuery.append("\n        , a.cmb ");
//		insertQuery.append("\n        , a.matchback ");
//		insertQuery.append("\n        , 'system' ");
//		insertQuery.append("\n        , SYSDATE ");
//		insertQuery.append("\n     FROM ( ");
//		insertQuery.append("\n     SELECT cntr_tpsz_cd ");
//		insertQuery.append("\n       , ecc_cd ");
//		insertQuery.append("\n       , lcc_cd ");
//		insertQuery.append("\n       , rcc_cd ");
//		insertQuery.append("\n       , imbalance ");
//		insertQuery.append("\n       , inbal_ranking ");
//		insertQuery.append("\n       , NVL (cmb, 0) cmb ");
//		insertQuery.append("\n       , ROUND (matchback, 2) matchback ");
//		insertQuery.append("\n    FROM (SELECT b.ecc_cd "); //CSR NO.N200802010006 박보배씨 요청
//		insertQuery.append("\n      , b.lcc_cd ");
//		insertQuery.append("\n      , b.rcc_cd ");
//		insertQuery.append("\n      , a.cntr_tpsz_cd ");
//		insertQuery.append("\n      , a.cmb ");
//		insertQuery.append("\n      , imbalance ");
//		insertQuery.append("\n      , inbal_ranking ");
//		insertQuery.append("\n      , DECODE (SIGN (b.ob_vol - b.ib_vol), 1, -b.ib_vol / b.ob_vol, -1, b.ob_vol / b.ib_vol, 0, 1) ");
//		insertQuery.append("\n  matchback ");
//		insertQuery.append("\n   FROM (SELECT   c.ecc_cd ");
//		insertQuery.append("\n       , d.cntr_tpsz_cd ");
//		insertQuery.append("\n       , SUM (d.estm_cm_cost_amt) / SUM (d.bkg_qty) cmb ");
//		insertQuery.append("\n    FROM mas_mon_vvd a ");
//		insertQuery.append("\n       , MAS_RGST_BKG b ");
//		insertQuery.append("\n       , mas_location_v c ");
//		insertQuery.append("\n       , mas_bkg_rev_dtl d ");
//		insertQuery.append("\n       , mas_spcl_repo_cntr_rgst e ");
//		insertQuery.append("\n   WHERE a.trd_cd = b.trd_cd ");
//		insertQuery.append("\n     AND a.rlane_cd = b.rlane_cd ");
//		insertQuery.append("\n     AND a.ioc_cd = b.ioc_cd ");
//		insertQuery.append("\n     AND a.vsl_cd = b.vsl_cd ");
//		insertQuery.append("\n     AND a.skd_voy_no = b.skd_voy_no ");
//		insertQuery.append("\n     AND a.dir_cd = b.dir_cd ");
//		insertQuery.append("\n     AND b.bkg_no = d.bkg_no ");
//		insertQuery.append("\n     AND b.bkg_no_split = d.bkg_no_split ");
//		insertQuery.append("\n     AND a.cost_yrmon BETWEEN TO_CHAR (ADD_MONTHS (TO_DATE (?, 'yyyymm'), -1) ");
//		insertQuery.append("\n , 'yyyymm') ");
//		insertQuery.append("\n        AND ? ");
//		insertQuery.append("\n     AND b.bkg_sts_cd IN ('F', 'S') ");
//		insertQuery.append("\n     AND b.bkg_cgo_tp_cd <> 'P' ");
//		insertQuery.append("\n     AND b.bkg_por_cd = c.loc_cd ");
//		insertQuery.append("\n     AND e.repo_flg = 'Y' ");
//		insertQuery.append("\n     AND NVL (e.delt_flg, 'N') = 'N' ");
//		insertQuery.append("\n     AND d.cntr_tpsz_cd = e.cntr_tpsz_cd ");
//		insertQuery.append("\n     AND e.list_bx_set_lvl_cd = '0001' ");
//		insertQuery.append("\nGROUP BY c.ecc_cd, d.cntr_tpsz_cd) a ");
//		insertQuery.append("\n      , ( ");
//		insertQuery.append("\n/* Match Back */ ");
//		insertQuery.append("\nselect ecc_cd,lcc_cd,rcc_cd,cntr_tpsz_cd, ");
//		insertQuery.append("\n        CUME_DIST()OVER (PARTITION BY cntr_tpsz_cd ORDER BY ib_vol-ob_vol) inbal_ranking, ");
//		insertQuery.append("\n        ib_vol - ob_vol imbalance, ");
//		insertQuery.append("\n        ib_vol,ob_vol ");
//		insertQuery.append("\n  from ( ");
//		insertQuery.append("\nSELECT   b.ecc_cd ");
//		insertQuery.append("\n       , b.lcc_cd ");
//		insertQuery.append("\n       , b.rcc_cd ");
//		insertQuery.append("\n       , a.cntr_tpsz_cd ");
//		insertQuery.append("\n       , SUM (full_ib_qty) ib_vol ");
//		insertQuery.append("\n       , SUM (full_ob_qty) ob_vol ");
//		insertQuery.append("\n    FROM mas_mtch_bak_info a ");
//		insertQuery.append("\n       , mas_location_v b ");
//		insertQuery.append("\n       , mas_cntr_repo_rcc c ");
//		insertQuery.append("\n       , mas_spcl_repo_cntr_rgst e ");
//		insertQuery.append("\n   WHERE a.loc_cd = b.loc_cd ");
//		insertQuery.append("\n     AND b.rcc_cd = c.rcc_cd ");
//		insertQuery.append("\n     AND b.ecc_cd = c.ecc_cd ");
//		insertQuery.append("\n     AND a.cost_yrmon = c.cost_yrmon ");
//		insertQuery.append("\n     AND c.repo_flg = 'Y' ");
//		insertQuery.append("\n     AND e.repo_flg = 'Y' ");
//		insertQuery.append("\n     AND NVL (e.delt_flg, 'N') = 'N' ");
//		insertQuery.append("\n     AND a.cntr_tpsz_cd = e.cntr_tpsz_cd ");
//		insertQuery.append("\n     AND a.cost_yrmon = ? ");
//		insertQuery.append("\nGROUP BY b.ecc_cd, b.lcc_cd, b.rcc_cd, a.cntr_tpsz_cd)) b ");
//		insertQuery.append("\n  WHERE a.ecc_cd(+) = b.ecc_cd  "); //CSR NO.N200802010006 박보배씨 요청
//		insertQuery.append("\n    AND a.cntr_tpsz_cd(+) = b.cntr_tpsz_cd) "); //CSR NO.N200802010006 박보배씨 요청
//		insertQuery.append("\n    ) a ");
//		//--------------------------------------------------------------------------------------------------------
//
//		// 수정 쿼리  
//		//--------------------------------------------------------------------------------------------------------
//		StringBuffer updateQuery = new StringBuffer() ;
//		updateQuery.append("\n UPDATE mas_cntr_repo_shtg_info a");
//		updateQuery.append("\n    SET a.eq_repo_cr_rto =");
//		updateQuery.append("\n           (SELECT b.eq_repo_cr_rto");
//		updateQuery.append("\n              FROM mas_cntr_repo_cr b");
//		updateQuery.append("\n             WHERE b.cost_yrmon = ?");
//		updateQuery.append("\n               AND b.cntr_tpsz_cd = a.cntr_tpsz_cd");
//		updateQuery.append("\n               AND b.repo_lvl_grp_cd = a.imbal_cr_lvl || a.opb_cr_lvl || a.mb_cr_lvl)");
//		updateQuery.append("\n  WHERE a.cost_yrmon = ?");
//		//--------------------------------------------------------------------------------------------------------
////		CSR NO.N200802010006 박보배씨 요청 (delete 주석 처리)
////		StringBuffer deleteQuery2 = new StringBuffer() ; 
////		deleteQuery2.append("DELETE FROM mas_cntr_repo_shtg_info ");
////		deleteQuery2.append("      WHERE cost_yrmon = ? ");
////		deleteQuery2.append("        AND (   imbal_cr_lvl = 'X' ");
////		deleteQuery2.append("             OR imbal_cr_lvl IS NULL ");
////		deleteQuery2.append("             OR opb_cr_lvl = 'X' ");
////		deleteQuery2.append("             OR opb_cr_lvl IS NULL ");
////		deleteQuery2.append("             OR mb_cr_lvl = 'X' ");
////		deleteQuery2.append("             OR mb_cr_lvl IS NULL ");
////		deleteQuery2.append("            ) ");
//
//		try {
//			con = getConnection();
//			// 삭제  쿼리
//			//--------------------------------------------------------------------------------------------------------
//			// Loggable Statement 사용에 의해 추가 
//			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
//				deletePs = new LoggableStatement(con, deleteQuery.toString());
//			} else {
//				deletePs = con.prepareStatement(deleteQuery.toString());
//			}
//			
//			// 쿼리에 변수 세팅. 
//			i = 1;
//			deletePs.setString(i++, ((String)hm.get("f_cost_yrmon")).replaceAll("-",""));
//			
//			// Loggable Statement 사용에 의해 추가 
//			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
//				log.info("\n SQL :\n" + ((LoggableStatement)deletePs).getQueryString());
//			} else {
//				log.info("\n SQL :\n" + deleteQuery );
//			}
//			
//			deletePs.execute();
//			//--------------------------------------------------------------------------------------------------------
//
//			
//			// 삽입, 변경 쿼리 
//			//--------------------------------------------------------------------------------------------------------
//			// Loggable Statement 사용에 의해 추가
//			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
//				insertPs = new LoggableStatement(con, insertQuery.toString());
//				updatePs = new LoggableStatement(con, updateQuery.toString());
//				//deletePs2 = new LoggableStatement(con, deleteQuery2.toString());
//			} else {
//				insertPs = con.prepareStatement(insertQuery.toString());
//				updatePs = con.prepareStatement(updateQuery.toString());
//				//deletePs2 = con.prepareStatement(deleteQuery2.toString());
//			}
//			i = 1;
//			insertPs.setString(i++, ((String)hm.get("f_cost_yrmon")).replaceAll("-",""));
//			insertPs.setString(i++, ((String)hm.get("f_cost_yrmon")).replaceAll("-",""));
//			insertPs.setString(i++, ((String)hm.get("f_cost_yrmon")).replaceAll("-",""));
//			insertPs.setString(i++, ((String)hm.get("f_cost_yrmon")).replaceAll("-",""));
//			insertPs.setString(i++, ((String)hm.get("f_cost_yrmon")).replaceAll("-",""));
//			insertPs.setString(i++, ((String)hm.get("f_cost_yrmon")).replaceAll("-",""));
//			insertPs.setString(i++, ((String)hm.get("f_cost_yrmon")).replaceAll("-",""));
//
//			i = 1;
//			updatePs.setString(i++, ((String)hm.get("f_cost_yrmon")).replaceAll("-",""));
//			updatePs.setString(i++, ((String)hm.get("f_cost_yrmon")).replaceAll("-",""));
//
//			//i = 1;
//			//deletePs2.setString(i++, ((String)hm.get("f_cost_yrmon")).replaceAll("-",""));
//
//			// Loggable Statement 사용에 의해 추가
//			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
//				log.info("\n SQL :\n" + ((LoggableStatement) insertPs).getQueryString());
//				log.info("\n SQL :\n" + ((LoggableStatement) updatePs).getQueryString());
//				//log.info("\n SQL :\n" + ((LoggableStatement) deletePs2).getQueryString());
//			} else {
//				log.info("\n SQL :\n" + insertQuery);
//				log.info("\n SQL :\n" + updateQuery);
//				//log.info("\n SQL :\n" + deleteQuery2);
//			}
//
//			insertPs.execute();
//			updatePs.execute();
//			//deletePs2.execute();
//			//--------------------------------------------------------------------------------------------------------
//
//			return true;
//		} catch (SQLException se) {
//			log.error(se.getMessage(), se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		} catch (DAOException de) {
//			log.error(de.getMessage(), de);
//			throw de;
//		} catch (Exception e) {
//			log.error(e.getMessage(), e);
//			throw new DAOException(e.getMessage());
//		} finally {
//			closeStatement(deletePs);
//			//closeStatement(deletePs2);
//			closeStatement(insertPs);
//			closeStatement(updatePs);
//			
//			closeConnection(con);
//		}
//	}
//	
//	/**
//	 * EQ Holding Cost(EQHD)
//	 * @param str
//	 * @return boolean 실행결과
//	 * @exception DAOException
//	 */
//	public boolean createEQHoldingCost(String str) throws DAOException {
//		HashMap hm = Utils.createMap(str);
//	    // Connection Interface
//		Connection con = null;
//		// 정적파싱을 지원하는 SQL Statement
//		PreparedStatement mergePs = null;
//		int i = 1;
//		
//		//일수를 update
//		String queryStr = "\n"
//			+ "\n MERGE INTO mas_hld_cost d1"
//			+ "\n    USING (SELECT c1.cost_yrmon"
//			+ "\n                 ,c1.cntr_chss_div_cd"
//			+ "\n                 ,c2.eq_tpsz_cd"
//			+ "\n                 ,c2.stnd_cost_cd"
//			+ "\n                 ,c1.eq_hld_dys"
//			+ "\n                 ,c1.eq_bx_knt"
//			+ "\n                 ,'' upd_usr_id"
//			+ "\n                 ,SYSDATE upd_dt"
//			+ "\n             FROM (SELECT   cost_yrmon"
//			+ "\n                           ,cntr_tpsz_cd"
//			+ "\n                           ,'CNTR' cntr_chss_div_cd"
//			+ "\n                           ,SUM(cntr_qty) eq_bx_knt   --,SUM(fcgo_tz_dys * cntr_qty) fdays,SUM(mcgo_tz_dys * cntr_qty) mdays"
//			+ "\n                           ,ROUND((SUM(fcgo_tz_dys * cntr_qty) + SUM(mcgo_tz_dys * cntr_qty)) / SUM(cntr_qty)) eq_hld_dys"
//			+ "\n                       FROM (SELECT   ? cost_yrmon"
//			+ "\n                                     ,b1.bkg_no"
//			+ "\n                                     ,b1.bkg_no_split   --,b2.stnd_cost_cd"
//			+ "\n                                     ,mas_ut_tpsz_fnc(NULL, DECODE(b2.cntr_tpsz_cd, 'RD2', 'R2', 'RD5', 'R5', b2.cntr_tpsz_cd)) cntr_tpsz_cd   --,a3.cost_rout_no"
//			+ "\n                                     ,AVG(b2.cntr_qty) cntr_qty"
//			+ "\n                                     ,AVG(b2.fcgo_tz_dys) fcgo_tz_dys"
//			+ "\n                                     ,AVG(b2.mcgo_tz_dys) mcgo_tz_dys"
//			+ "\n                                 FROM (SELECT a1.bkg_no"
//			+ "\n                                             ,a1.bkg_no_split"
//			+ "\n                                         FROM MAS_RGST_BKG a1, mas_mon_vvd a2"
//			+ "\n                                        WHERE 1 = 1"
//			+ "\n                                          AND a1.bl_no_tp IN('M', '0')"
//			+ "\n                                          AND a1.bkg_sts_cd IN('F', 'S')"
//			+ "\n                                          AND a1.bkg_cgo_tp_cd NOT IN('P')"
//			+ "\n                                          AND a2.delt_flg = 'N'"
//			+ "\n                                          --AND a2.cost_yrmon = '200706'"
//			+ "\n                                          AND SUBSTR(a2.cost_yrmon, 0, 4) || a2.cost_wk BETWEEN '200723' AND '200724'"
//			+ "\n                                          AND a1.trd_cd = a2.trd_cd"
//			+ "\n                                          AND a1.rlane_cd = a2.rlane_cd"
//			+ "\n                                          AND a1.ioc_cd = a2.ioc_cd"
//			+ "\n                                          AND a1.vsl_cd = a2.vsl_cd"
//			+ "\n                                          AND a1.skd_voy_no = a2.skd_voy_no"
//			+ "\n                                          AND a1.dir_cd = a2.dir_cd) b1"
//			+ "\n                                     ,mas_bkg_cost_smry b2"
//			+ "\n                                WHERE 1 = 1"
//			+ "\n                                  AND b2.stnd_cost_cd = '52101011'"
//			+ "\n                                  AND b1.bkg_no = b2.bkg_no"
//			+ "\n                                  AND b1.bkg_no_split = b2.bkg_no_split"
//			+ "\n                             GROUP BY b1.bkg_no"
//			+ "\n                                     ,b1.bkg_no_split"
//			+ "\n                                     ,b2.stnd_cost_cd"
//			+ "\n                                     ,mas_ut_tpsz_fnc(NULL, DECODE(b2.cntr_tpsz_cd, 'RD2', 'R2', 'RD5', 'R5', b2.cntr_tpsz_cd))"
//			+ "\n                                     ,b2.cost_rout_no)"
//			+ "\n                   GROUP BY cost_yrmon, cntr_tpsz_cd) c1"
//			+ "\n                 ,(SELECT cost_yrmon"
//			+ "\n                         ,cntr_chss_div_cd"
//			+ "\n                         ,eq_tpsz_cd"
//			+ "\n                         ,stnd_cost_cd"
//			+ "\n                     FROM mas_hld_cost"
//			+ "\n                    WHERE cost_yrmon = ?"
//			+ "\n                      AND cntr_chss_div_cd = 'CNTR') c2"
//			+ "\n            WHERE c1.cost_yrmon = c2.cost_yrmon"
//			+ "\n              AND c1.cntr_chss_div_cd = c2.cntr_chss_div_cd"
//			+ "\n              AND c1.cntr_tpsz_cd = c2.eq_tpsz_cd) d2"
//			+ "\n    ON (    d1.cost_yrmon = d2.cost_yrmon"
//			+ "\n        AND d1.cntr_chss_div_cd = d2.cntr_chss_div_cd"
//			+ "\n        AND d1.eq_tpsz_cd = d2.eq_tpsz_cd"
//			+ "\n        AND d1.stnd_cost_cd = d2.stnd_cost_cd)"
//			+ "\n    WHEN MATCHED THEN"
//			+ "\n       UPDATE"
//			+ "\n          SET d1.eq_hld_dys = d2.eq_hld_dys, d1.eq_bx_knt = d2.eq_bx_knt, d1.upd_usr_id = d2.upd_usr_id, d1.upd_dt = d2.upd_dt"
//			;
//		
//		try {
//			con = getConnection();
//
//			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
//				mergePs = new LoggableStatement(con, queryStr);
//			} else {
//				mergePs = con.prepareStatement(queryStr);
//			}
//			
//			// 쿼리에 변수 세팅. 
//			i = 1;
//			
//			mergePs.setString(i++, ((String)hm.get("f_cost_yrmon")).replaceAll("-",""));
//			mergePs.setString(i++, ((String)hm.get("f_cost_yrmon")).replaceAll("-",""));
//			
//			// Loggable Statement 사용에 의해 추가 
//			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
//				log.info("\n SQL :\n" + ((LoggableStatement)mergePs).getQueryString());
//			} else {
//				log.info("\n SQL :\n" + queryStr );
//			}
//			
//			mergePs.execute();
//
//		} catch (SQLException se) {
//			log.error(se.getMessage(), se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		} catch (DAOException de) {
//			log.error(de.getMessage(), de);
//			throw de;
//		} catch (Exception e) {
//			log.error(e.getMessage(), e);
//			throw new DAOException(e.getMessage());
//		} finally {
//			closeStatement(mergePs);
//			closeConnection(con);
//		}
//		
//		return true;		
//	}
//	
//	/**
//	 * Chartered_Daily-Hire(CHDH)
//	 * 	
//	 * @param str
//	 * @return boolean 실행결과
//	 * @exception DAOException
//	 */
//	public boolean createCharteredDailyHire(String str) throws DAOException {
//		HashMap hm = Utils.createMap(str);
//	    // Connection Interface
//		Connection con = null;
//		// 정적파싱을 지원하는 SQL Statement
//		PreparedStatement selectSrcPs = null;
//		PreparedStatement insertPs = null;
//		PreparedStatement deletePs = null;
//		ResultSet rsSrc = null;
//		// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
//		int i = 1;
//		
//		
//		// 삭제 쿼리
//		//--------------------------------------------------------------------------------------------------------
//		StringBuffer deleteQuery = new StringBuffer() ;
//		deleteQuery.append("\n DELETE mas_chrg_vsl_dly_hir");
//		deleteQuery.append("\n  WHERE cost_yrmon = ?");
//
//		//--------------------------------------------------------------------------------------------------------
//		
//		// 원천 데이터 & 등록 
//		//--------------------------------------------------------------------------------------------------------
//		StringBuffer strSQL = new StringBuffer();
//		strSQL.append("INSERT INTO mas_chrg_vsl_dly_hir                    ") ;
//		strSQL.append("SELECT ? ") ;
//		strSQL.append("      ,vsl_cd ") ;
//		strSQL.append("      ,rate      ") ;
//		strSQL.append("      ,'system1' ") ;
//		strSQL.append("      ,sysdate ") ;
//		strSQL.append("      ,'system1' ") ;
//		strSQL.append("      ,sysdate ") ;
//		strSQL.append("FROM (  SELECT   a.vsl_cd ") ;
//		strSQL.append("                ,SUM (a.rate / DECODE (a.curr_cd, 'USD', 1, NVL (b.usd_locl_xch_rt, 0))) rate ") ;
//		strSQL.append("        FROM (  SELECT  vsl_cd, ") ;
//		strSQL.append("                        DECODE(NO,1,n1st_hir_rt,n2nd_hir_rt) rate, ") ;
//		strSQL.append("                        DECODE(NO,1,n1st_curr_cd,n2nd_curr_cd) curr_cd, ") ;
//		strSQL.append("                        ctrt_eff_fm_dt,ctrt_eff_to_dt ") ;
//		strSQL.append("                FROM (      ") ;
//		strSQL.append("                        SELECT   a.vsl_cd  ") ;
//		strSQL.append("                                ,DECODE(n2nd_curr_cd,NULL,1,2) seq  ") ;
//		strSQL.append("                                ,n1ST_hir_rt,n2nd_hir_rt,n1st_curr_cd,n2nd_curr_cd  ") ;
//		strSQL.append("                                ,TO_DATE (a.ctrt_eff_fm_dt, 'YYYYMMDD') ctrt_eff_fm_dt  ") ;
//		strSQL.append("                                ,TO_DATE (a.ctrt_eff_to_dt, 'YYYYMMDD') ctrt_eff_to_dt  ") ;
//		strSQL.append("                        FROM mas_vsl_chrg_if a, mas_vsl_rgst b  ") ;
//		strSQL.append("                            , ( SELECT   cost_yrmon  ") ;
//		strSQL.append("                                        ,vsl_cd  ") ;
//		strSQL.append("                                        ,chrg_ctrt_no  ") ;
//		strSQL.append("                                        ,MAX (chrg_ctrt_seq) chrg_ctrt_seq_max  ") ;
//		strSQL.append("                                FROM    mas_vsl_chrg_if x1  ") ;
//		strSQL.append("                                WHERE cost_yrmon = ? ") ;
//		strSQL.append("                                GROUP BY cost_yrmon, vsl_cd, chrg_ctrt_no) c  ") ;
//		strSQL.append("                        WHERE a.vsl_cd = b.vsl_cd  ") ;
//		strSQL.append("                        and a.cost_yrmon = c.cost_yrmon  ") ;
//		strSQL.append("                        and a.vsl_cd = c.vsl_cd  ") ;
//		strSQL.append("                        and a.chrg_ctrt_no = c.chrg_ctrt_no  ") ;
//		strSQL.append("                        and a.chrg_ctrt_seq = c.chrg_ctrt_seq_max  ") ;
//		strSQL.append("                        AND a.cost_yrmon = ?  ") ;
//		strSQL.append("                        AND NVL (b.delt_flg, 'N') = 'N'  ") ;
//		strSQL.append("                        AND b.vsl_tp_cd = 'C'  ") ;
//		strSQL.append("                        AND b.vsl_oshp_cd = 'CHT'  ") ;
//		strSQL.append("                    ),(SELECT cpy_no no FROM com_cpy_no WHERE cpy_no BETWEEN 1 AND 2)  ") ;
//		strSQL.append("                WHERE seq >= no ) a, gl_mon_xch_rt b  ") ;
//		strSQL.append("        WHERE a.curr_cd = b.curr_cd  ") ;
//		strSQL.append("        AND b.acct_xch_rt_lvl(+) = '1'  ") ;
//		strSQL.append("        AND b.acct_xch_rt_yrmon(+) = ? ") ;
//		strSQL.append("        GROUP BY a.vsl_cd   ) ") ;
//
////		StringBuffer selectSrcQuery = new StringBuffer();
////		selectSrcQuery.append(" SELECT vsl_cd ") ;
////		selectSrcQuery.append("       ,RATE chrg_dhir_amt ") ;
////		selectSrcQuery.append("   FROM (SELECT   a.vsl_cd ") ;
////		selectSrcQuery.append("                 ,SUM (a.rate / DECODE (a.curr_cd, 'USD', 1, NVL (b.usd_locl_xch_rt, 0))) RATE ") ;
////		selectSrcQuery.append("             FROM (SELECT VSL_CD, ") ;
////		selectSrcQuery.append("                          DECODE(NO,1,n1ST_hir_rt,n2nd_hir_rt) rate, ") ;
////		selectSrcQuery.append("                          DECODE(NO,1,n1st_curr_cd,n2nd_curr_cd) curr_cd, ") ;
////		selectSrcQuery.append("                          ctrt_eff_fm_dt,ctrt_eff_to_dt ") ;
////		selectSrcQuery.append("                     FROM (     ") ;
////		selectSrcQuery.append("                        SELECT a.vsl_cd ") ;
////		selectSrcQuery.append("                              ,DECODE(n2nd_curr_cd,NULL,1,2) SEQ ") ;
////		selectSrcQuery.append("                              ,n1ST_hir_rt,n2nd_hir_rt,n1st_curr_cd,n2nd_curr_cd ") ;
////		selectSrcQuery.append("                              ,TO_DATE (a.ctrt_eff_fm_dt, 'YYYYMMDD') ctrt_eff_fm_dt ") ;
////		selectSrcQuery.append("                              ,TO_DATE (a.ctrt_eff_to_dt, 'YYYYMMDD') ctrt_eff_to_dt ") ;
////		selectSrcQuery.append("                         FROM mas_vsl_chrg_if a, mas_vsl_rgst b ") ;
////		selectSrcQuery.append("                             , (SELECT   cost_yrmon ") ;
////		selectSrcQuery.append("                                        ,vsl_cd ") ;
////		selectSrcQuery.append("                                        ,chrg_ctrt_no ") ;
////		selectSrcQuery.append("                                        ,MAX (chrg_ctrt_seq) chrg_ctrt_seq_max ") ;
////		selectSrcQuery.append("                                    FROM mas_vsl_chrg_if x1 ") ;
////		selectSrcQuery.append("                                   WHERE cost_yrmon = ? ") ;
////		selectSrcQuery.append("                                GROUP BY cost_yrmon, vsl_cd, chrg_ctrt_no) c ") ;
////		selectSrcQuery.append("                        WHERE a.vsl_cd = b.vsl_cd ") ;
////		selectSrcQuery.append("                         and a.cost_yrmon = c.cost_yrmon ") ;
////		selectSrcQuery.append("                         and a.vsl_cd = c.vsl_cd ") ;
////		selectSrcQuery.append("                         and a.chrg_ctrt_no = c.chrg_ctrt_no ") ;
////		selectSrcQuery.append("                         and a.chrg_ctrt_seq = c.chrg_ctrt_seq_max ") ;
////		selectSrcQuery.append("                          AND a.cost_yrmon = ? ") ;
////		selectSrcQuery.append("                          AND NVL (b.delt_flg, 'N') = 'N' ") ;
////		selectSrcQuery.append("                          AND b.vsl_tp_cd = 'C' ") ;
////		selectSrcQuery.append("                          AND b.vsl_oshp_cd = 'CHT' ") ;
////		selectSrcQuery.append("                          ),(SELECT CPY_NO NO FROM COM_CPY_NO WHERE CPY_NO BETWEEN 1 AND 2) ") ;
////		selectSrcQuery.append("                    WHERE SEQ >= NO ) a ") ;
////		selectSrcQuery.append("                 ,gl_mon_xch_rt b ") ;
////		selectSrcQuery.append("            WHERE a.curr_cd = b.curr_cd ") ;
////		selectSrcQuery.append("              AND b.acct_xch_rt_lvl(+) = '1' ") ;
////		selectSrcQuery.append("              AND b.acct_xch_rt_yrmon(+) = ? ") ;
////		selectSrcQuery.append("         GROUP BY a.vsl_cd) ") ;
//		//--------------------------------------------------------------------------------------------------------
//		
//		// 삽입 쿼리
//		//--------------------------------------------------------------------------------------------------------
////		StringBuffer insertQuery = new StringBuffer() ;
////		insertQuery.append("\n INSERT INTO mas_chrg_vsl_dly_hir");
////		insertQuery.append("\n             (cost_yrmon");
////		insertQuery.append("\n            , vsl_cd");
////		insertQuery.append("\n            , chrg_dhir_amt");
////		insertQuery.append("\n            , cre_usr_id");
////		insertQuery.append("\n            , cre_dt");
////		insertQuery.append("\n            , upd_usr_id");
////		insertQuery.append("\n            , upd_dt");
////		insertQuery.append("\n             )");
////		insertQuery.append("\n      VALUES (?");
////		insertQuery.append("\n            , ?");
////		insertQuery.append("\n            , ?");
////		insertQuery.append("\n            , ?");
////		insertQuery.append("\n            , SYSDATE");
////		insertQuery.append("\n            , ?");
////		insertQuery.append("\n            , SYSDATE");
////		insertQuery.append("\n             )");
//
//		//--------------------------------------------------------------------------------------------------------
//
//
//		try {
//			con = getConnection();
//
//			// 삭제  쿼리
//			//--------------------------------------------------------------------------------------------------------
//			// Loggable Statement 사용에 의해 추가 
//			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
//				deletePs = new LoggableStatement(con, deleteQuery.toString());
//			} else {
//				deletePs = con.prepareStatement(deleteQuery.toString());
//			}
//			
//			// 쿼리에 변수 세팅. 
//			i = 1;
//			deletePs.setString(i++, ((String)hm.get("f_cost_yrmon")).replaceAll("-",""));
//			
//			// Loggable Statement 사용에 의해 추가 
//			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
//				log.info("\n SQL :\n" + ((LoggableStatement)deletePs).getQueryString());
//			} else {
//				log.info("\n SQL :\n" + deleteQuery );
//			}
//			
//			deletePs.execute();
//			//--------------------------------------------------------------------------------------------------------
//
//			// 원천 테이터  쿼리
//			//--------------------------------------------------------------------------------------------------------
//			// Loggable Statement 사용에 의해 추가
//			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
//				selectSrcPs = new LoggableStatement(con, strSQL.toString());
//			} else {
//				selectSrcPs = con.prepareStatement(strSQL.toString());
//			}			
////			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
////				selectSrcPs = new LoggableStatement(con, selectSrcQuery.toString());
////			} else {
////				selectSrcPs = con.prepareStatement(selectSrcQuery.toString());
////			}
//			
//			// 쿼리에 변수 세팅. 
//			i = 1;
//			selectSrcPs.setString(i++, ((String)hm.get("f_cost_yrmon")).replaceAll("-",""));
//			selectSrcPs.setString(i++, ((String)hm.get("f_cost_yrmon")).replaceAll("-",""));
//			selectSrcPs.setString(i++, ((String)hm.get("f_cost_yrmon")).replaceAll("-",""));
//			selectSrcPs.setString(i++, ((String)hm.get("f_cost_yrmon")).replaceAll("-",""));
////			selectSrcPs.setString(i++, ((String)hm.get("f_cost_yrmon")).replaceAll("-",""));
//			
//			// Loggable Statement 사용에 의해 추가 
//			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
//				log.info("\n SQL :\n" + ((LoggableStatement)selectSrcPs).getQueryString());
//			} else {
//				log.info("\n SQL :\n" + strSQL );
//			}
//			
//			rsSrc = selectSrcPs.executeQuery();
//			//--------------------------------------------------------------------------------------------------------
//
//			// 원천 데이터 처리
//			//--------------------------------------------------------------------------------------------------------
////			int cnt = 0;
////			while (rsSrc.next()) {
////				// 추가
////				if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
////					insertPs = new LoggableStatement(con, insertQuery.toString());
////				} else {
////					insertPs = con.prepareStatement(insertQuery.toString());
////				}
////				i = 1;
////				insertPs.setString(i++, ((String)hm.get("f_cost_yrmon")).replaceAll("-",""));
////				insertPs.setString(i++, rsSrc.getString("vsl_cd"));
////				insertPs.setString(i++, rsSrc.getString("chrg_dhir_amt"));
////				insertPs.setString(i++, ((String)hm.get("user_id")));
////				insertPs.setString(i++, ((String)hm.get("user_id")));
////				insertPs.execute();
////				cnt++;
////			}
////			log.debug("### Process Data Cnt: "+cnt);
//			// --------------------------------------------------------------------------------------------------------
//
//		} catch (SQLException se) {
//			log.error(se.getMessage(), se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		} catch (DAOException de) {
//			log.error(de.getMessage(), de);
//			throw de;
//		} catch (Exception e) {
//			log.error(e.getMessage(), e);
//			throw new DAOException(e.getMessage());
//		} finally {
//			closeResultSet(rsSrc);
//			closeStatement(selectSrcPs);
//			closeStatement(insertPs);
//			closeStatement(deletePs);
//			closeConnection(con);
//		}
//		return true;		
//	}
//
//	/**
//	 * Average Revenue Creation(RPBC)
//	 * 
//	 * @param str
//	 * @return boolean 실행결과
//	 * @exception DAOException
//	 */
//	public int createAverageRevenue(String str) throws DAOException {
//		log.debug("### createAverageRevenue str:"+str);
//		HashMap hm = Utils.createMap(str);
//	
//		int i = 1; // PreparedStatement에 bind 변수를 넣을시 증가되는 변수
//		int resultCount = 0; // 수행 결과가 정상인지를 판별하기 위한 변수
//		Connection con = null; // Connection Interface
//		CallableStatement cs = null; // 정적파싱을 지원하는 SQL Statement
//	
//		StringBuffer queryStr = new StringBuffer();
//		queryStr.append(" call MAS_MON_AVG_RPB_PRC(?,?,?)" + "\n");
//	
//		try {
//			con = getConnection();
//			
//			cs = con.prepareCall(queryStr.toString());
//	
//			// 쿼리에 변수 세팅.
//			i = 1;
//			//cs.setString(i++, ((String)hm.get("f_cost_yrmon")).replaceAll("-",""));
//			String yrmon = ((String)hm.get("f_cost_yrmon")).replaceAll("-","");
//			
//			cs.setString(i++, yrmon.length()>4?yrmon.substring(0,4):"0");
//			cs.setString(i++, "0");
//			cs.setString(i++, "0");
//			
//			// Loggable Statement 사용에 의해 추가
//			log.info("\n SQL :\n" + queryStr.toString());
//			resultCount = cs.executeUpdate();
//
//			log.debug("### MAS_MON_AVG_RPB_PRC result : " + resultCount);
//	
//		} catch (SQLException se) {
//			log.error(se.getMessage(), se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		} catch (DAOException de) {
//			log.error(de.getMessage(), de);
//			throw de;
//		} catch (Exception e) {
//			log.error(e.getMessage(), e);
//			throw new DAOException(e.getMessage());
//		} finally {
//			closeStatement(cs);
//			closeConnection(con);
//		}
//		return resultCount;
//	}	
//	
//	/**
//	 * createOwnDailyHire(OWDH)
//	 * 	
//	 * @param str
//	 * @return boolean 실행결과
//	 * @exception DAOException
//	 */
//	public boolean createOwnDailyHire(String str) throws DAOException {
//		HashMap hm = Utils.createMap(str);
//		
//	    // Connection Interface
//		Connection con = null;
//		// 정적파싱을 지원하는 SQL Statement
//		PreparedStatement deletePs = null;
//		PreparedStatement insertPs = null;
//		// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
//		int i = 1;
//		
//		
//		// 삭제 쿼리
//		//--------------------------------------------------------------------------------------------------------
//		StringBuffer deleteQuery = new StringBuffer() ;
//		deleteQuery.append("\n DELETE FROM mas_own_vsl_dly_hir");
//		deleteQuery.append("\n       WHERE cost_yrmon = ?");
//
//		//--------------------------------------------------------------------------------------------------------
//		
//		// 삽입 쿼리
//		//--------------------------------------------------------------------------------------------------------
//		StringBuffer insertQuery = new StringBuffer() ;
//		
//		insertQuery.append("\n INSERT INTO mas_own_vsl_dly_hir");
//		insertQuery.append("\n             (cost_yrmon");
//		insertQuery.append("\n             ,vsl_cd");
//		insertQuery.append("\n             ,vsl_clss_capa");
//		insertQuery.append("\n             ,stnd_cost_cd");
//		insertQuery.append("\n             ,dhir_amt");
//		insertQuery.append("\n             ,own_vsl_rmk");
//		insertQuery.append("\n             ,cre_usr_id");
//		insertQuery.append("\n             ,cre_dt");
//		insertQuery.append("\n             ,upd_usr_id");
//		insertQuery.append("\n             ,upd_dt");
//		insertQuery.append("\n             )");
//		insertQuery.append("\n    SELECT ?");
//		insertQuery.append("\n          ,vsl_cd");
//		insertQuery.append("\n          ,vsl_clss_capa");
//		insertQuery.append("\n          ,mng_acct_cd");
//		insertQuery.append("\n          ,damt");
//		insertQuery.append("\n          ,rmk");
//		insertQuery.append("\n          ,'system'");
//		insertQuery.append("\n          ,SYSDATE");
//		insertQuery.append("\n          ,'system'");
//		insertQuery.append("\n          ,SYSDATE");
//		insertQuery.append("\n      FROM (SELECT a.vsl_cd");
//		insertQuery.append("\n                  ,b.vsl_clss_capa");
//		insertQuery.append("\n                  ,a.mng_acct_cd");
//		insertQuery.append("\n                  ,   if_perf_amt");
//		insertQuery.append("\n                    / (  LEAST (b.vsl_retn_to_dt, LAST_DAY (TO_DATE (?, 'YYYYMM')))");
//		insertQuery.append("\n                       - GREATEST (b.vsl_retn_fm_dt");
//		insertQuery.append("\n                                  ,TO_DATE (   TO_CHAR (ADD_MONTHS (TO_DATE (?, 'YYYYMM'), -a.mon_vsl_knt + 1)");
//		insertQuery.append("\n                                                       ,'yyyymm'");
//		insertQuery.append("\n                                                       )");
//		insertQuery.append("\n                                            || '01'");
//		insertQuery.append("\n                                           ,'YYYYMMDD'");
//		insertQuery.append("\n                                           )");
//		insertQuery.append("\n                                  )");
//		insertQuery.append("\n                      ) damt");
//		insertQuery.append("\n                  ,'IF' rmk");
//		insertQuery.append("\n              FROM mas_own_vsl_hir_if a, mas_vsl_rgst b");
//		insertQuery.append("\n             WHERE a.cost_yrmon = ?");
//		insertQuery.append("\n               AND a.vsl_cd = b.vsl_cd");
//		insertQuery.append("\n               AND NVL (b.delt_flg, 'N') = 'N'");
//		insertQuery.append("\n               AND b.vsl_tp_cd = 'C'");
//		insertQuery.append("\n               AND b.vsl_oshp_cd = 'OWN'");
//		insertQuery.append("\n            UNION ALL");
//		insertQuery.append("\n            SELECT   'XXXX'");
//		insertQuery.append("\n                    ,vsl_clss_capa");
//		insertQuery.append("\n                    ,mng_acct_cd");
//		insertQuery.append("\n                    , SUM (damt) / cnt");
//		insertQuery.append("\n                    ,'AVG'");
//		insertQuery.append("\n                FROM (SELECT a.vsl_cd");
//		insertQuery.append("\n                            ,b.vsl_clss_capa");
//		insertQuery.append("\n                            ,a.mng_acct_cd");
//		insertQuery.append("\n                            ,if_perf_amt");
//		insertQuery.append("\n                            ,b.vsl_retn_fm_dt");
//		insertQuery.append("\n                            ,b.vsl_retn_to_dt");
//		insertQuery.append("\n                            , (  LEAST (b.vsl_retn_to_dt, LAST_DAY (TO_DATE (?, 'YYYYMM')))");
//		insertQuery.append("\n                               - GREATEST (b.vsl_retn_fm_dt");
//		insertQuery.append("\n                                          ,TO_DATE (   TO_CHAR (ADD_MONTHS (TO_DATE (?, 'YYYYMM')");
//		insertQuery.append("\n                                                                           , -a.mon_vsl_knt + 1");
//		insertQuery.append("\n                                                                           )");
//		insertQuery.append("\n                                                               ,'yyyymm'");
//		insertQuery.append("\n                                                               )");
//		insertQuery.append("\n                                                    || '01'");
//		insertQuery.append("\n                                                   ,'YYYYMMDD'");
//		insertQuery.append("\n                                                   )");
//		insertQuery.append("\n                                          )");
//		insertQuery.append("\n                              ) days");
//		insertQuery.append("\n                            ,   if_perf_amt");
//		insertQuery.append("\n                              / (  LEAST (b.vsl_retn_to_dt, LAST_DAY (TO_DATE (?, 'YYYYMM')))");
//		insertQuery.append("\n                                 - GREATEST (b.vsl_retn_fm_dt");
//		insertQuery.append("\n                                            ,TO_DATE (   TO_CHAR (ADD_MONTHS (TO_DATE (?, 'YYYYMM')");
//		insertQuery.append("\n                                                                             , -a.mon_vsl_knt + 1");
//		insertQuery.append("\n                                                                             )");
//		insertQuery.append("\n                                                                 ,'yyyymm'");
//		insertQuery.append("\n                                                                 )");
//		insertQuery.append("\n                                                      || '01'");
//		insertQuery.append("\n                                                     ,'YYYYMMDD'");
//		insertQuery.append("\n                                                     )");
//		insertQuery.append("\n                                            )");
//		insertQuery.append("\n                                ) damt");
//		insertQuery.append("\n                            ,COUNT (a.vsl_cd) OVER (PARTITION BY b.vsl_clss_capa, a.mng_acct_cd) cnt");
//		insertQuery.append("\n                        FROM mas_own_vsl_hir_if a, mas_vsl_rgst b");
//		insertQuery.append("\n                       WHERE a.cost_yrmon = ?");
//		insertQuery.append("\n                         AND a.vsl_cd = b.vsl_cd");
//		insertQuery.append("\n                         AND NVL (b.delt_flg, 'N') = 'N'");
//		insertQuery.append("\n                         AND b.vsl_tp_cd = 'C'");
//		insertQuery.append("\n                         AND b.vsl_oshp_cd = 'OWN')");
//		insertQuery.append("\n            GROUP BY vsl_clss_capa, mng_acct_cd, cnt)");
//		//--------------------------------------------------------------------------------------------------------
//
//		try {
//			con = getConnection();
//
//			// 삭제  쿼리
//			//--------------------------------------------------------------------------------------------------------
//			// Loggable Statement 사용에 의해 추가 
//			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
//				deletePs = new LoggableStatement(con, deleteQuery.toString());
//			} else {
//				deletePs = con.prepareStatement(deleteQuery.toString());
//			}
//			
//			// 쿼리에 변수 세팅. 
//			i = 1;
//			deletePs.setString(i++, ((String)hm.get("f_cost_yrmon")).replaceAll("-",""));
//			
//			// Loggable Statement 사용에 의해 추가 
//			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
//				log.info("\n SQL :\n" + ((LoggableStatement)deletePs).getQueryString());
//			} else {
//				log.info("\n SQL :\n" + deleteQuery );
//			}
//			
//			deletePs.execute();
//			//--------------------------------------------------------------------------------------------------------
//
//
//			//	 삽입 쿼리 
//			//--------------------------------------------------------------------------------------------------------
//			// Loggable Statement 사용에 의해 추가
//			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
//				insertPs = new LoggableStatement(con, insertQuery.toString());
//			} else {
//				insertPs = con.prepareStatement(insertQuery.toString());
//			}
//			i = 1;
//			insertPs.setString(i++, ((String)hm.get("f_cost_yrmon")).replaceAll("-",""));
//			insertPs.setString(i++, ((String)hm.get("f_cost_yrmon")).replaceAll("-",""));
//			insertPs.setString(i++, ((String)hm.get("f_cost_yrmon")).replaceAll("-",""));
//			insertPs.setString(i++, ((String)hm.get("f_cost_yrmon")).replaceAll("-",""));
//			insertPs.setString(i++, ((String)hm.get("f_cost_yrmon")).replaceAll("-",""));
//
//			insertPs.setString(i++, ((String)hm.get("f_cost_yrmon")).replaceAll("-",""));
//			insertPs.setString(i++, ((String)hm.get("f_cost_yrmon")).replaceAll("-",""));
//			insertPs.setString(i++, ((String)hm.get("f_cost_yrmon")).replaceAll("-",""));
//			insertPs.setString(i++, ((String)hm.get("f_cost_yrmon")).replaceAll("-",""));
//
//			// Loggable Statement 사용에 의해 추가
//			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
//				log.info("\n SQL :\n" + ((LoggableStatement) insertPs).getQueryString());
//			} else {
//				log.info("\n SQL :\n" + insertQuery);
//			}
//
//			insertPs.execute();
//			//--------------------------------------------------------------------------------------------------------
//
//			
//			return true;
//		} catch (SQLException se) {
//			log.error(se.getMessage(), se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		} catch (DAOException de) {
//			log.error(de.getMessage(), de);
//			throw de;
//		} catch (Exception e) {
//			log.error(e.getMessage(), e);
//			throw new DAOException(e.getMessage());
//		} finally {
//			closeStatement(insertPs);
//			closeStatement(deletePs);
//			closeConnection(con);
//		}
//	}
//
//	/**
//	 * createOwnDailyHire(OWDH)
//	 * 	
//	 * @param str
//	 * @return boolean 실행결과
//	 * @exception DAOException
//	 */
//	public boolean createBunkerFee(String str) throws DAOException {
//		HashMap hm = Utils.createMap(str);
//		
//	    // Connection Interface
//		Connection con = null;
//		// 정적파싱을 지원하는 SQL Statement
//		PreparedStatement deletePs = null;
//		PreparedStatement insertPs = null;
//		// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
//		int i = 1;
//		
//		
//		// 삭제 쿼리
//		//--------------------------------------------------------------------------------------------------------
//		StringBuffer deleteQuery = new StringBuffer() ;
//		deleteQuery.append("\n DELETE FROM mas_bnk_trf");
//		deleteQuery.append("\n       WHERE cost_yrmon = ?");
//	
//		//--------------------------------------------------------------------------------------------------------
//		
//		// 삽입 쿼리
//		//--------------------------------------------------------------------------------------------------------
//		StringBuffer insertQuery = new StringBuffer() ;
//		insertQuery.append("\n INSERT INTO mas_bnk_trf");
//		insertQuery.append("\n    SELECT ?");
//		insertQuery.append("\n          ,SUBSTR(rlane_cd, 1, 3) slan_cd");
//		insertQuery.append("\n          ,rlane_cd");
//		insertQuery.append("\n          ,skd_dir_cd");
//		insertQuery.append("\n          ,vsl_clss_capa");
//		insertQuery.append("\n          , fo_qty / ttl_days");
//		insertQuery.append("\n          ,ROUND(fo_amt / fo_qty, 13) fo_uc_amt");
//		insertQuery.append("\n          ,ROUND(fo_amt, 13)");
//		insertQuery.append("\n          , do_qty / ttl_days");
//		insertQuery.append("\n          ,ROUND(do_amt / fo_qty, 13) do_uc_amt");
//		insertQuery.append("\n          ,ROUND(do_amt, 13)");
//		insertQuery.append("\n          ,?");
//		insertQuery.append("\n          ,SYSDATE");
//		insertQuery.append("\n          ,?");
//		insertQuery.append("\n          ,SYSDATE");
//		insertQuery.append("\n      FROM (SELECT   a.rlane_cd");
//		insertQuery.append("\n                    ,c.vsl_clss_capa");
//		insertQuery.append("\n                    ,a.skd_dir_cd");
//		insertQuery.append("\n                    ,SUM(DECODE(a.bnk_cate_cd, 'FO',a.port_dys + a.sea_dys)) ttl_days");
//		insertQuery.append("\n                    ,SUM(DECODE(a.bnk_cate_cd, 'FO', a.act_csm_qty)) fo_qty");
//		insertQuery.append("\n                    ,SUM(DECODE(a.bnk_cate_cd, 'DO', a.act_csm_qty)) do_qty");
//		insertQuery.append("\n                    ,SUM(DECODE(a.bnk_cate_cd, 'FO', a.act_csm_amt / NVL(b.usd_locl_xch_rt, 0))) fo_amt");
//		insertQuery.append("\n                    ,SUM(DECODE(a.bnk_cate_cd, 'DO', a.act_csm_amt / NVL(b.usd_locl_xch_rt, 0))) do_amt");
//		insertQuery.append("\n                FROM mas_bnk_perf_if a, gl_mon_xch_rt b, mas_vsl_rgst c");
//		insertQuery.append("\n               WHERE b.curr_cd = 'KRW'");
//		insertQuery.append("\n                 AND b.acct_xch_rt_lvl(+) = '1'");
//		insertQuery.append("\n                 AND b.acct_xch_rt_yrmon(+) = ?");
//		insertQuery.append("\n                 AND a.cost_yrmon = ?");
//		insertQuery.append("\n                 AND A.VSL_CD = C.VSL_CD");
//		insertQuery.append("\n                 AND NVL(C.DELT_FLG,'N') = 'N'");
//		insertQuery.append("\n            GROUP BY a.rlane_cd, c.vsl_clss_capa, a.skd_dir_cd)");
//
//		//--------------------------------------------------------------------------------------------------------
//	
//		try {
//			con = getConnection();
//	
//			// 삭제  쿼리
//			//--------------------------------------------------------------------------------------------------------
//			// Loggable Statement 사용에 의해 추가 
//			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
//				deletePs = new LoggableStatement(con, deleteQuery.toString());
//			} else {
//				deletePs = con.prepareStatement(deleteQuery.toString());
//			}
//			
//			// 쿼리에 변수 세팅. 
//			i = 1;
//			deletePs.setString(i++, ((String)hm.get("f_cost_yrmon")).replaceAll("-",""));
//			
//			// Loggable Statement 사용에 의해 추가 
//			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
//				log.info("\n SQL :\n" + ((LoggableStatement)deletePs).getQueryString());
//			} else {
//				log.info("\n SQL :\n" + deleteQuery );
//			}
//			
//			deletePs.execute();
//			//--------------------------------------------------------------------------------------------------------
//	
//	
//			//	 삽입 쿼리 
//			//--------------------------------------------------------------------------------------------------------
//			// Loggable Statement 사용에 의해 추가
//			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
//				insertPs = new LoggableStatement(con, insertQuery.toString());
//			} else {
//				insertPs = con.prepareStatement(insertQuery.toString());
//			}
//			i = 1;
//			insertPs.setString(i++, ((String)hm.get("f_cost_yrmon")).replaceAll("-",""));
//			insertPs.setString(i++, ((String)hm.get("user_id")));
//			insertPs.setString(i++, ((String)hm.get("user_id")));
//			insertPs.setString(i++, ((String)hm.get("f_cost_yrmon")).replaceAll("-",""));
//			insertPs.setString(i++, ((String)hm.get("f_cost_yrmon")).replaceAll("-",""));
//	
//			// Loggable Statement 사용에 의해 추가
//			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
//				log.info("\n SQL :\n" + ((LoggableStatement) insertPs).getQueryString());
//			} else {
//				log.info("\n SQL :\n" + insertQuery);
//			}
//	
//			insertPs.execute();
//			//--------------------------------------------------------------------------------------------------------
//	
//			
//			return true;
//		} catch (SQLException se) {
//			log.error(se.getMessage(), se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		} catch (DAOException de) {
//			log.error(de.getMessage(), de);
//			throw de;
//		} catch (Exception e) {
//			log.error(e.getMessage(), e);
//			throw new DAOException(e.getMessage());
//		} finally {
//			closeStatement(insertPs);
//			closeStatement(deletePs);
//			closeConnection(con);
//		}
//	}
//
//	/**
//	 * 조회할 테이블 필드명 가져오기<br>
//	 * @param et 
//	 * 
//	 * @return DBRowSet DB 처리 결과
//	 * @throws DAOException
//	 */
//	public StringBuffer searchCostStructure137List(Event et) throws DAOException {
//		// Connection Interface
//		Connection con = null;
//		// 정적파싱을 지원하는 SQL Statement
//		PreparedStatement ps = null;
//		// DB ResultSet
//		ResultSet rs = null;		
//		// DB ResultSetMetaData
//		ResultSetMetaData rsmd = null;
//		StringBuffer sb_rslt = new StringBuffer();
//		ESM_MAS_137Event event = (ESM_MAS_137Event)et;
//	
//		StringBuffer queryStr = new StringBuffer();
//		queryStr.append("\n SELECT * ");
//		queryStr.append("\n FROM   "+event.getString("f_table_name")+" ");
//		queryStr.append("\n WHERE  ROWNUM = 1 ");		
//
//		try {
//			con = getConnection();
//			
//	    	// Loggable Statement 사용에 의해 추가 
//			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
//				ps = new LoggableStatement(con, queryStr.toString());
//			} else {
//				ps = con.prepareStatement(queryStr.toString());
//			}
//					
//			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
//				log.info("\n SQL : \n" + ((LoggableStatement)ps).getQueryString());
//			} else {
//				log.info("\n SQL : \n" + queryStr );
//			}
//
//			rs = ps.executeQuery();
//			rsmd = ps.getMetaData();
//			
//			sb_rslt.append(rsmd.getColumnCount()+"|");
//			for(int i=1;i<=rsmd.getColumnCount();i++){
//				sb_rslt.append(rsmd.getColumnName(i));
//				if(i!=rsmd.getColumnCount())
//					sb_rslt.append("|");
//			}
//					
//		} catch (SQLException se) {
//			log.error(se.getMessage(), se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		} catch (DAOException de) {
//			log.error(de.getMessage(), de);
//			throw de;
//		} catch (Exception e) {
//			log.error(e.getMessage(), e);
//			throw new DAOException(e.getMessage());
//		} finally {
//			closeResultSet(rs);
//			closeStatement(ps);
//			closeConnection(con);
//		}
//		return sb_rslt;
//	}
//	
//	/**
//	 * 조회할 테이블 필드명 가져오기<br>
//	 * @param et 
//	 * 
//	 * @return DBRowSet DB 처리 결과
//	 * @throws DAOException
//	 * @throws Exception 
//	 * @throws EventException 
//	 */
//	public DBRowSet searchCostStructure137List2(Event et) throws DAOException {
//		// Connection Interface
//		Connection con = null;
//		// 정적파싱을 지원하는 SQL Statement
//		PreparedStatement countps = null;
//		PreparedStatement ps = null;
//		// DB ResultSet
//		ResultSet countrs = null;
//		ResultSet rs = null;		
//		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
//		DBRowSet dRs = null;
//		ESM_MAS_137Event event = (ESM_MAS_137Event)et;
//	
//		StringBuffer queryStr = new StringBuffer();
//		StringBuffer countStr = new StringBuffer();		
//
//		String[] ibflag       = event.getObject("ibflag");
//		String[] colName      = event.getObject("colName");
//		String[] inEquality   = event.getObject("inEquality");
//		String[] value        = event.getObject("value");
//		
//		int		 rowCount   = 0;
//		int      msg_cnt    = 10000;
//		String   msg_action = "retrieve";		
//
//		try {
//			countStr.append("\n SELECT COUNT(*) rowCnt ");
//			countStr.append("\n FROM   "+event.getString("f_table_name")+" A, MAS_COST_SRC_ACCT B");
//			countStr.append("\n WHERE  A.MAS_COST_SRC_CD = B.MAS_COST_SRC_CD ");
//			if(ibflag!=null){
//				for(int i=0;i<ibflag.length;i++){
//					countStr.append("\n AND  (A."+colName[i]+" "+inEquality[i]+" "+value[i]+")");
//				}
//			}
//			
//			if ( event.getString("f_table_name").equals("MAS_NOD_AVG_STND_COST") ) {
//				queryStr.append("\n SELECT  A.COST_YRMON            COST_YRMON 									");
//				queryStr.append("\n        ,A.FULL_MTY_CD           FULL_MTY_CD 								");
//				queryStr.append("\n        ,A.CNTR_TPSZ_CD          CNTR_TPSZ_CD 								");
//				queryStr.append("\n        ,A.COST_LOC_GRP_CD       COST_LOC_GRP_CD 							");
//				queryStr.append("\n        ,A.NOD_CD                NOD_CD 										");
//				queryStr.append("\n        ,A.TRD_CD                TRD_CD 								        ");
//				queryStr.append("\n        ,B.STND_COST_CD          STND_COST_CD 								");				
//				queryStr.append("\n        ,A.MAS_COST_SRC_CD       MAS_COST_SRC_CD_V 							");
//				queryStr.append("\n        ,A.MAS_COST_SRC_CD       MAS_COST_SRC_CD 							");
//				queryStr.append("\n        ,A.LOCL_CURR_CD          LOCL_CURR_CD 								");
//				queryStr.append("\n        ,A.COST_FX_FLG           COST_FX_FLG 								");
//				queryStr.append("\n        ,A.STND_COST_USD_AMT     STND_COST_USD_AMT 							");
//				queryStr.append("\n        ,A.NOD_TTL_QTY           NOD_TTL_QTY 								");
//				queryStr.append("\n        ,A.NOD_TTL_AMT           NOD_TTL_AMT 								");
//				queryStr.append("\n        ,A.COST_VOL_CD           COST_VOL_CD 								");
//				queryStr.append("\n FROM   MAS_NOD_AVG_STND_COST A, MAS_COST_SRC_ACCT B							");
//				queryStr.append("\n WHERE  A.MAS_COST_SRC_CD = B.MAS_COST_SRC_CD 								");
//			} else {
//				queryStr.append("\n SELECT  A.COST_YRMON            COST_YRMON 									");
//				queryStr.append("\n        ,A.FULL_MTY_CD           FULL_MTY_CD 								");
//				queryStr.append("\n        ,A.CNTR_TPSZ_CD          CNTR_TPSZ_CD 								");
//				queryStr.append("\n        ,A.COST_LOC_GRP_CD       COST_LOC_GRP_CD 							");
//				queryStr.append("\n        ,A.LNK_FM_NOD_CD         LNK_FM_NOD_CD								");
//				queryStr.append("\n        ,A.LNK_TO_NOD_CD         LNK_TO_NOD_CD								");				
//				queryStr.append("\n        ,B.STND_COST_CD          STND_COST_CD 								");
//				queryStr.append("\n        ,A.MAS_COST_SRC_CD       MAS_COST_SRC_CD_V 							");
//				queryStr.append("\n        ,A.MAS_COST_SRC_CD       MAS_COST_SRC_CD 							");
//				queryStr.append("\n        ,A.CO_CD		            CO_CD		 								");				
//				queryStr.append("\n        ,A.LOCL_CURR_CD          LOCL_CURR_CD 								");
//				queryStr.append("\n        ,A.COST_FX_FLG           COST_FX_FLG 								");
//				queryStr.append("\n        ,A.STND_COST_USD_AMT     STND_COST_USD_AMT 							");
//				queryStr.append("\n        ,A.LNK_TTL_QTY           LNK_TTL_QTY 								");
//				queryStr.append("\n        ,A.LNK_TTL_AMT           LNK_TTL_AMT 								");
//				queryStr.append("\n        ,A.COST_VOL_CD           COST_VOL_CD 								");
//				queryStr.append("\n  	   ,(	SELECT DECODE(SUM(LNK_TTL_QTY), 0, 0 ,ROUND(SUM(LNK_TTL_AMT)/SUM(LNK_TTL_QTY), 3))");
//				queryStr.append("\n  		    FROM   MAS_LNK_AVG_STND_COST 									");
//				queryStr.append("\n			    WHERE  COST_YRMON       = A.COST_YRMON 							");
//				queryStr.append("\n 			AND    LNK_FM_NOD_CD    = A.LNK_FM_NOD_CD 						");
//				queryStr.append("\n 			AND    LNK_TO_NOD_CD    = A.LNK_TO_NOD_CD 						");
//				queryStr.append("\n 			AND    CO_CD            = A.CO_CD 								");
//				queryStr.append("\n 			AND    CNTR_TPSZ_CD     = A.CNTR_TPSZ_CD 						");
//				queryStr.append("\n 			AND    FULL_MTY_CD      = A.FULL_MTY_CD 						");
//				queryStr.append("\n 			AND    COST_LOC_GRP_CD  = A.COST_LOC_GRP_CD )	MTY_UC_AMT		");
//				queryStr.append("\n FROM   MAS_LNK_AVG_STND_COST A, MAS_COST_SRC_ACCT B							");
//				queryStr.append("\n WHERE  A.MAS_COST_SRC_CD = B.MAS_COST_SRC_CD 								");				
//			}
//			if(ibflag!=null){		
//				for(int j=0;j<ibflag.length;j++){
//					queryStr.append("\n AND  (A."+colName[j]+" "+inEquality[j]+" "+value[j]+")");
//				}
//			}
//
//			con = getConnection();
//			
//	    	// Loggable Statement 사용에 의해 추가 
//			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
//				countps = new LoggableStatement(con, countStr.toString());				
//				ps      = new LoggableStatement(con, queryStr.toString());
//			} else {
//				countps = con.prepareStatement(countStr.toString());				
//				ps = con.prepareStatement(queryStr.toString());
//			}
//			
//			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
//				log.info("\n SQL : \n" + ((LoggableStatement)countps).getQueryString());				
//				log.info("\n SQL : \n" + ((LoggableStatement)ps).getQueryString());
//			} else {
//				log.info("\n SQL : \n" + countStr.toString() );				
//				log.info("\n SQL : \n" + queryStr.toString() );
//			}
//
//			String[] errMessage = {msg_action, msg_cnt+""};
//			
//			countrs = countps.executeQuery();	
//			countrs.next();
//			rowCount = countrs.getInt(1);
//			
//			if(rowCount >= msg_cnt){	
//				log.info("\n You can't "+msg_action+" more than "+msg_cnt+" rows.");				
//				throw new DAOException(new ErrorHandler("MAS00030",errMessage).getMessage());				
//			}else{
//				rs = ps.executeQuery();
//				// 결과를 DBRowset에 담는다.
//				dRs = new DBRowSet();
//				dRs.populate(rs);					
//			}				
//		} catch (SQLException se) {
//			log.error(se.getMessage(), se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		} catch (DAOException de) {				
//			log.error(de.getMessage(), de);
//			throw de;
//		} catch (Exception e) {
//			log.error(e.getMessage(), e);
//			throw new DAOException(e.getMessage());
//		} finally {
//			closeResultSet(countrs);
//			closeResultSet(rs);
//			closeStatement(countps);
//			closeStatement(ps);
//			closeConnection(con);
//		}
//		return dRs;
//	}
//
//	/**
//	 * 데이터 저장하기<br>
//	 * @param et 
//	 * 
//	 * @return DBRowSet DB 처리 결과
//	 * @throws DAOException
//	 * @throws Exception 
//	 * @throws EventException 
//	 */
//	public void multiCostStructure137(Event et) throws DAOException {
//		// Connection Interface   
//		Connection con = null;
//		// MergeInto를 수행하기 위한 SQL Statement
//		PreparedStatement mergeIntoPs  = null;		
//		// DELETE를 수행하기 위한 SQL Statement
//		PreparedStatement deletePs = null;
//		// 수행 결과가 정상인지를 판별하기 위한 변수
//		// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
//		int i = 1;
//		
//		boolean isMergeInto = false ;
//		boolean isDelete    = false ;
//		
//		ESM_MAS_137Event event = (ESM_MAS_137Event)et;
//		
//		//
//		String userId		   = "";
//		String mergeIntoQuery  = null;			
//		String deleteQuery     = null;			
//		
//		StringBuffer strSQLMergeInto = new StringBuffer();
//		
//		int      msg_cnt    = 200;
//		String   msg_action = "save";		
//
//		//입력
//		if(event.getString("f_table_name").equals("MAS_NOD_AVG_STND_COST")){
////			mergeIntoQuery = 			
////			"\n MERGE INTO MAS_NOD_AVG_STND_COST B1							\n" +
////			"USING ( SELECT '1' FROM DUAL ) B2								\n" + 
////			"ON (    B1.COST_YRMON       = ?								\n" + 
////			"    AND B1.FULL_MTY_CD      = ?								\n" + 
////			"    AND B1.CNTR_TPSZ_CD     = ?								\n" + 
////			"    AND B1.COST_LOC_GRP_CD  = ?								\n" + 
////			"    AND B1.NOD_CD           = ?								\n" + 
////			"    AND B1.MAS_COST_SRC_CD  = ?)								\n" + 
////			"WHEN MATCHED THEN												\n" + 
////			"    UPDATE SET   B1.LOCL_CURR_CD         = ?					\n" + 
////			"                ,B1.STND_COST_USD_AMT    = ?					\n" + 
////			"                ,B1.NOD_TTL_QTY          = ?					\n" + 
////			"                ,B1.NOD_TTL_AMT          = ?					\n" + 
////			"                ,B1.COST_VOL_CD          = ?					\n" + 
////			"                ,B1.UPD_USR_ID           = ?					\n" + 
////			"                ,B1.UPD_DT               = SYSDATE				\n" + 
////			"                ,B1.COST_FX_FLG          = ?					\n" + 		
////			"WHEN NOT MATCHED THEN											\n" + 
////			"    INSERT														\n" + 
////			"    (COST_YRMON       , FULL_MTY_CD, CNTR_TPSZ_CD, COST_LOC_GRP_CD, NOD_CD    , MAS_COST_SRC_CD, LOCL_CURR_CD,				\n" + 
////			"     STND_COST_USD_AMT, NOD_TTL_QTY, NOD_TTL_AMT , COST_VOL_CD    , CRE_USR_ID, CRE_DT         , UPD_USR_ID  , UPD_DT, 	\n" +
////			"	  COST_FX_FLG)																											\n" + 
////			"    VALUES																													\n" + 
////			"    (?                , ?          , ?           , ?              , ?         , ?              , ?           ,				\n" + 
////			"     ?                , ?          , ?           , ?              , ?         , SYSDATE        , ?           , SYSDATE,	\n" +
////			"	  ? 	)";
//			strSQLMergeInto.append("\n MERGE INTO MAS_NOD_AVG_STND_COST B1							 ") ;
//			strSQLMergeInto.append("\n USING ( SELECT ? AS cost_yrmon ") ;
//			strSQLMergeInto.append("\n               ,? AS full_mty_cd ") ;
//			strSQLMergeInto.append("\n               ,? AS cntr_tpsz_cd ") ;
//			strSQLMergeInto.append("\n               ,? AS cost_loc_grp_cd ") ;
//			strSQLMergeInto.append("\n               ,? AS nod_cd ") ;
//			strSQLMergeInto.append("\n               ,? AS trd_cd ") ;
//			strSQLMergeInto.append("\n               ,? AS mas_cost_src_cd  ") ;
//			strSQLMergeInto.append("\n               ,? AS locl_curr_cd ") ;
//			strSQLMergeInto.append("\n               ,? AS stnd_cost_usd_amt ") ;
//			strSQLMergeInto.append("\n               ,? AS NOD_TTL_QTY ") ;
//			strSQLMergeInto.append("\n               ,? AS NOD_TTL_AMT ") ;
//			strSQLMergeInto.append("\n               ,? As COST_VOL_CD ") ;
//			strSQLMergeInto.append("\n               ,? AS UPD_USR_ID ") ;
//			strSQLMergeInto.append("\n               ,? AS COST_FX_FLG ") ;
//			strSQLMergeInto.append("\n           FROM DUAL ) B2 ") ;
//			strSQLMergeInto.append("\n ON (    B1.COST_YRMON       = B2.COST_YRMON ") ;
//			strSQLMergeInto.append("\n     AND B1.FULL_MTY_CD      = B2.FULL_MTY_CD	") ;
//			strSQLMergeInto.append("\n     AND B1.CNTR_TPSZ_CD     = B2.CNTR_TPSZ_CD ") ;
//			strSQLMergeInto.append("\n     AND B1.COST_LOC_GRP_CD  = B2.COST_LOC_GRP_CD	") ;
//			strSQLMergeInto.append("\n     AND B1.NOD_CD           = B2.NOD_CD ") ;
//			strSQLMergeInto.append("\n     AND B1.TRD_CD           = B2.TRD_CD ") ;
//			strSQLMergeInto.append("\n     AND B1.MAS_COST_SRC_CD  = B2.MAS_COST_SRC_CD) ") ;
//			strSQLMergeInto.append("\n WHEN MATCHED THEN ") ;
//			strSQLMergeInto.append("\n     UPDATE SET   B1.LOCL_CURR_CD         = B2.LOCL_CURR_CD ") ;
//			strSQLMergeInto.append("\n                 ,B1.STND_COST_USD_AMT    = B2.STND_COST_USD_AMT ") ;
//			strSQLMergeInto.append("\n                 ,B1.NOD_TTL_QTY          = B2.NOD_TTL_QTY ") ;
//			strSQLMergeInto.append("\n                 ,B1.NOD_TTL_AMT          = B2.NOD_TTL_AMT ") ;
//			strSQLMergeInto.append("\n                 ,B1.COST_VOL_CD          = B2.COST_VOL_CD ") ;
//			strSQLMergeInto.append("\n                 ,B1.UPD_USR_ID           = B2.UPD_USR_ID ") ;
//			strSQLMergeInto.append("\n                 ,B1.UPD_DT               = SYSDATE ") ;
//			strSQLMergeInto.append("\n                 ,B1.COST_FX_FLG          = B2.COST_FX_FLG ") ;
//			strSQLMergeInto.append("\n                 ,B1.COST_CALC_RMK        = B1.COST_CALC_RMK||'>AMT:'||B2.STND_COST_USD_AMT||',FX:'||B2.COST_FX_FLG ") ;
//			strSQLMergeInto.append("\n WHEN NOT MATCHED THEN ") ;
//			strSQLMergeInto.append("\n     INSERT ") ;
//			strSQLMergeInto.append("\n     (B1.COST_YRMON       , B1.FULL_MTY_CD, B1.CNTR_TPSZ_CD, B1.COST_LOC_GRP_CD, B1.NOD_CD    , B1.MAS_COST_SRC_CD, B1.LOCL_CURR_CD, ") ;
//			strSQLMergeInto.append("\n      B1.STND_COST_USD_AMT, B1.NOD_TTL_QTY, B1.NOD_TTL_AMT , B1.COST_VOL_CD    , B1.CRE_USR_ID, B1.CRE_DT         , B1.UPD_USR_ID  , B1.UPD_DT, ") ;
//			strSQLMergeInto.append("\n 	   B1.COST_FX_FLG      , B1.COST_CALC_RMK, B1.TRD_CD) ") ;
//			strSQLMergeInto.append("\n     VALUES ") ;
//			strSQLMergeInto.append("\n     (B2.COST_YRMON       , B2.FULL_MTY_CD, B2.CNTR_TPSZ_CD, B2.COST_LOC_GRP_CD, B2.NOD_CD    , B2.MAS_COST_SRC_CD, B2.LOCL_CURR_CD, ") ;
//			strSQLMergeInto.append("\n      B2.STND_COST_USD_AMT, B2.NOD_TTL_QTY, B2.NOD_TTL_AMT , B2.COST_VOL_CD    , B2.UPD_USR_ID, SYSDATE           , B2.UPD_USR_ID  , SYSDATE, ") ;
//			strSQLMergeInto.append("\n 	   B2.COST_FX_FLG      , '>AMT'||B2.STND_COST_USD_AMT||',FX'||B2.COST_FX_FLG, B2.TRD_CD) \n") ;
//			
//			//delete 
//			deleteQuery = 
//				"\n DELETE FROM MAS_NOD_AVG_STND_COST 	\n" + 
//				" WHERE cost_yrmon = ?					\n" + 
//				"   AND full_mty_cd = ?					\n" + 
//				"   AND cntr_tpsz_cd = ?				\n" + 
//				"   AND cost_loc_grp_cd = ?				\n" + 
//				"   AND nod_cd = ?						\n" +
//				"   AND trd_cd = ?						\n" +
//				"   AND mas_cost_src_cd = ?				";
//		}else{
////			mergeIntoQuery = 
////			"\n MERGE INTO MAS_LNK_AVG_STND_COST B1						\n" +
////			"USING ( SELECT '1' FROM DUAL  ) B2							\n" + 
////			"ON ( B1.COST_YRMON            = ?							\n" + 
////			"  AND  B1.LNK_FM_NOD_CD       = ?							\n" + 
////			"  AND  B1.LNK_TO_NOD_CD       = ?							\n" + 
////			"  AND  B1.CO_CD               = ?							\n" + 
////			"  AND  B1.CNTR_TPSZ_CD        = ?							\n" + 
////			"  AND  B1.FULL_MTY_CD         = ?							\n" + 
////			"  AND  B1.MAS_COST_SRC_CD     = ?							\n" + 
////			"  AND  B1.COST_LOC_GRP_CD     = ?)						\n" + 
////			"WHEN MATCHED THEN											\n" + 
////			"    UPDATE SET   B1.LOCL_CURR_CD       = ?					\n" + 
////			"                ,B1.STND_COST_USD_AMT  = ?					\n" + 
////			"                ,B1.LNK_TTL_QTY        = ?					\n" + 
////			"                ,B1.LNK_TTL_AMT        = ?					\n" + 
////			"                ,B1.COST_VOL_CD        = ?					\n" + 
////			"                ,B1.UPD_USR_ID         = ?					\n" + 
////			"                ,B1.UPD_DT             = SYSDATE			\n" + 
////			"                ,B1.COST_FX_FLG        = ?					\n" + 
////			"WHEN NOT MATCHED THEN										\n" + 
////			"    INSERT													\n" + 
////			"    (COST_YRMON    , LNK_FM_NOD_CD, LNK_TO_NOD_CD    , CO_CD      , CNTR_TPSZ_CD, FULL_MTY_CD, MAS_COST_SRC_CD,	\n" + 
////			"    COST_LOC_GRP_CD, LOCL_CURR_CD , STND_COST_USD_AMT, LNK_TTL_QTY, LNK_TTL_AMT , COST_VOL_CD,						\n" + 
////			"    CRE_USR_ID     , CRE_DT       , UPD_USR_ID       , UPD_DT	   , COST_FX_FLG                                  )	\n" + 
////			"    VALUES																											\n" + 
////			"    (?             , ?            , ?                , ?          , ?           , ?          , ?              ,	\n" + 
////			"     ?             , ?            , ?                , ?          , ?           , ?          ,						\n" + 
////			"     ?             , SYSDATE      , ?                , SYSDATE    , ?                                            )";
//			
//			strSQLMergeInto.append("\n MERGE INTO MAS_LNK_AVG_STND_COST B1						 ") ;
//			strSQLMergeInto.append("\n USING ( SELECT ? AS COST_YRMON ") ;
//			strSQLMergeInto.append("\n               ,? AS LNK_FM_NOD_CD ") ;
//			strSQLMergeInto.append("\n               ,? AS LNK_TO_NOD_CD ") ;
//			strSQLMergeInto.append("\n               ,? AS CO_CD ") ;
//			strSQLMergeInto.append("\n               ,? AS CNTR_TPSZ_CD ") ;
//			strSQLMergeInto.append("\n               ,? AS FULL_MTY_CD ") ;
//			strSQLMergeInto.append("\n               ,? AS MAS_COST_SRC_CD ") ;
//			strSQLMergeInto.append("\n               ,? AS COST_LOC_GRP_CD ") ;
//			strSQLMergeInto.append("\n               ,? AS LOCL_CURR_CD ") ;
//			strSQLMergeInto.append("\n               ,? AS STND_COST_USD_AMT ") ;
//			strSQLMergeInto.append("\n               ,? AS LNK_TTL_QTY ") ;
//			strSQLMergeInto.append("\n               ,? AS LNK_TTL_AMT ") ;
//			strSQLMergeInto.append("\n               ,? AS COST_VOL_CD ") ;
//			strSQLMergeInto.append("\n               ,? AS UPD_USR_ID ") ;
//			strSQLMergeInto.append("\n               ,? AS COST_FX_FLG ") ;
//			strSQLMergeInto.append("\n           FROM DUAL  ) B2							 ") ;
//			strSQLMergeInto.append("\n ON ( B1.COST_YRMON            = B2.COST_YRMON ") ;
//			strSQLMergeInto.append("\n   AND  B1.LNK_FM_NOD_CD       = B2.LNK_FM_NOD_CD ") ;
//			strSQLMergeInto.append("\n   AND  B1.LNK_TO_NOD_CD       = B2.LNK_TO_NOD_CD ") ;
//			strSQLMergeInto.append("\n   AND  B1.CO_CD               = B2.CO_CD ") ;
//			strSQLMergeInto.append("\n   AND  B1.CNTR_TPSZ_CD        = B2.CNTR_TPSZ_CD ") ;
//			strSQLMergeInto.append("\n   AND  B1.FULL_MTY_CD         = B2.FULL_MTY_CD ") ;
//			strSQLMergeInto.append("\n   AND  B1.MAS_COST_SRC_CD     = B2.MAS_COST_SRC_CD ") ;
//			strSQLMergeInto.append("\n   AND  B1.COST_LOC_GRP_CD     = B2.COST_LOC_GRP_CD)						 ") ;
//			strSQLMergeInto.append("\n WHEN MATCHED THEN											 ") ;
//			strSQLMergeInto.append("\n     UPDATE SET   B1.LOCL_CURR_CD       = B2.LOCL_CURR_CD ") ;
//			strSQLMergeInto.append("\n                 ,B1.STND_COST_USD_AMT  = B2.STND_COST_USD_AMT ") ;
//			strSQLMergeInto.append("\n                 ,B1.LNK_TTL_QTY        = B2.LNK_TTL_QTY ") ;
//			strSQLMergeInto.append("\n                 ,B1.LNK_TTL_AMT        = B2.LNK_TTL_AMT ") ;
//			strSQLMergeInto.append("\n                 ,B1.COST_VOL_CD        = B2.COST_VOL_CD ") ;
//			strSQLMergeInto.append("\n                 ,B1.UPD_USR_ID         = B2.UPD_USR_ID ") ;
//			strSQLMergeInto.append("\n                 ,B1.UPD_DT             = SYSDATE ") ;
//			strSQLMergeInto.append("\n                 ,B1.COST_FX_FLG        = B2.COST_FX_FLG ") ;
//			strSQLMergeInto.append("\n                 ,B1.COST_CALC_RMK        = B1.COST_CALC_RMK||'>AMT:'||B2.STND_COST_USD_AMT||',FX:'||B2.COST_FX_FLG ") ;
//			strSQLMergeInto.append("\n WHEN NOT MATCHED THEN										 ") ;
//			strSQLMergeInto.append("\n     INSERT													 ") ;
//			strSQLMergeInto.append("\n     (COST_YRMON    , LNK_FM_NOD_CD, LNK_TO_NOD_CD    , CO_CD      , CNTR_TPSZ_CD, FULL_MTY_CD, MAS_COST_SRC_CD,	 ") ;
//			strSQLMergeInto.append("\n     COST_LOC_GRP_CD, LOCL_CURR_CD , STND_COST_USD_AMT, LNK_TTL_QTY, LNK_TTL_AMT , COST_VOL_CD,						 ") ;
//			strSQLMergeInto.append("\n     CRE_USR_ID     , CRE_DT       , UPD_USR_ID       , UPD_DT	 , COST_FX_FLG , B1.COST_CALC_RMK) ") ;
//			strSQLMergeInto.append("\n     VALUES																											 ") ;
//			strSQLMergeInto.append("\n     (B2.COST_YRMON    , B2.LNK_FM_NOD_CD, B2.LNK_TO_NOD_CD    , B2.CO_CD      , B2.CNTR_TPSZ_CD, B2.FULL_MTY_CD, B2.MAS_COST_SRC_CD,	 ") ;
//			strSQLMergeInto.append("\n     B2.COST_LOC_GRP_CD, B2.LOCL_CURR_CD , B2.STND_COST_USD_AMT, B2.LNK_TTL_QTY, B2.LNK_TTL_AMT , B2.COST_VOL_CD,						 ") ;
//			strSQLMergeInto.append("\n     B2.UPD_USR_ID     , SYSDATE         , B2.UPD_USR_ID       , SYSDATE       , B2.COST_FX_FLG , '>AMT'||B2.STND_COST_USD_AMT||',FX'||B2.COST_FX_FLG) \n") ;
//			
//			//delete 
//			deleteQuery = 
//				"\n DELETE FROM MAS_LNK_AVG_STND_COST 	\n" +
//				" WHERE cost_yrmon = ?					\n" + 
//				"   AND lnk_fm_nod_cd = ?				\n" + 
//				"   AND lnk_to_nod_cd = ?				\n" +
//				"   AND co_cd = ?						\n" +		
//				"   AND cntr_tpsz_cd = ?				\n" + 				
//				"   AND full_mty_cd = ?					\n" + 
//				"   AND mas_cost_src_cd = ?				\n" + 
//				"   AND cost_loc_grp_cd = ?";
//		}
//		
//		mergeIntoQuery = strSQLMergeInto.toString();
//
//		try {
//			String[] nod_cd 				= null;
//			String[] trd_cd 				= null;
//			String[] nod_ttl_qty 			= null;
//			String[] nod_ttl_amt 			= null; 
//			String[] lnk_fm_nod_cd			= null;
//			String[] lnk_to_nod_cd			= null;
//			String[] co_cd					= null;	
//			String[] lnk_ttl_qty 			= null;
//			String[] lnk_ttl_amt 			= null;				
//			
//			userId							= event.getUserId();
//			String[] ibflag 				= event.getObject("ibflag");
//			String[] cost_yrmon 			= event.getObject("cost_yrmon");
//			String[] full_mty_cd 			= event.getObject("full_mty_cd");
//			String[] cntr_tpsz_cd 			= event.getObject("cntr_tpsz_cd");
//			String[] cost_loc_grp_cd 		= event.getObject("cost_loc_grp_cd");
//			if(event.getString("f_table_name").equals("MAS_NOD_AVG_STND_COST")){			
//				nod_cd 						= event.getObject("nod_cd");
//				trd_cd 						= event.getObject("trd_cd");
//				nod_ttl_qty 				= event.getObject("nod_ttl_qty");
//				nod_ttl_amt 				= event.getObject("nod_ttl_amt");				
//			}else{
//				lnk_fm_nod_cd				= event.getObject("lnk_fm_nod_cd");
//				lnk_to_nod_cd				= event.getObject("lnk_to_nod_cd");
//				co_cd						= event.getObject("co_cd");	
//				lnk_ttl_qty 				= event.getObject("lnk_ttl_qty");
//				lnk_ttl_amt 				= event.getObject("lnk_ttl_amt");				
//			}
//			String[] mas_cost_src_cd 		= event.getObject("mas_cost_src_cd");
//			String[] locl_curr_cd 			= event.getObject("locl_curr_cd");
//			String[] stnd_cost_usd_amt		= event.getObject("stnd_cost_usd_amt");
//			String[] cost_vol_cd 			= event.getObject("cost_vol_cd");		
//			String[] cost_fx_flg 			= event.getObject("cost_fx_flg");		
//						
//			String[] errMessage = {msg_action, msg_cnt+""};			
//
//			if(ibflag.length >= msg_cnt){
//				log.info("\n You can't "+msg_action+" more than "+msg_cnt+" rows.");				
//				throw new DAOException(new ErrorHandler("MAS00030",errMessage).getMessage());				
//			}
//			con = getConnection();
//			
//			// Loggable Statement 사용에 의해 추가
//			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
//				mergeIntoPs = new LoggableStatement(con, mergeIntoQuery);				
//				deletePs    = new LoggableStatement(con, deleteQuery);
//			} else {
//				mergeIntoPs = con.prepareStatement(mergeIntoQuery);				
//				deletePs    = con.prepareStatement(deleteQuery);
//			}		
//
//			String flg = "";
//			if(ibflag.length>0){
//				for (int j=0; j<ibflag.length; j++) {
//					i = 1;
//					flg = ibflag[j];
//					if (flg.equals("I")||flg.equals("U")) {
//						isMergeInto = true;
//						//setting 
//						if(event.getString("f_table_name").equals("MAS_NOD_AVG_STND_COST")){								
//							mergeIntoPs.setString(i++, cost_yrmon[j]);							
//							mergeIntoPs.setString(i++, full_mty_cd[j]);						
//							mergeIntoPs.setString(i++, cntr_tpsz_cd[j]);
//							mergeIntoPs.setString(i++, cost_loc_grp_cd[j]);							
//							mergeIntoPs.setString(i++, nod_cd[j]);
//							mergeIntoPs.setString(i++, trd_cd[j]);
//							mergeIntoPs.setString(i++, mas_cost_src_cd[j]);
//							
//							mergeIntoPs.setString(i++, locl_curr_cd[j]);	
//							mergeIntoPs.setString(i++, stnd_cost_usd_amt[j]);
//							mergeIntoPs.setString(i++, nod_ttl_qty[j]);
//							mergeIntoPs.setString(i++, nod_ttl_amt[j]);
//							mergeIntoPs.setString(i++, cost_vol_cd[j]);						
//							mergeIntoPs.setString(i++, userId);
//							mergeIntoPs.setString(i++, Utils.change10ToYN(cost_fx_flg[j]));
//	
//						}else{							
//							mergeIntoPs.setString(i++, cost_yrmon[j]);							
//							mergeIntoPs.setString(i++, lnk_fm_nod_cd[j]);								
//							mergeIntoPs.setString(i++, lnk_to_nod_cd[j]);
//							mergeIntoPs.setString(i++, co_cd[j]);								
//							mergeIntoPs.setString(i++, cntr_tpsz_cd[j]);							
//							mergeIntoPs.setString(i++, full_mty_cd[j]);						
//							mergeIntoPs.setString(i++, mas_cost_src_cd[j]);							
//							mergeIntoPs.setString(i++, cost_loc_grp_cd[j]);	
//							
//							mergeIntoPs.setString(i++, locl_curr_cd[j]);	
//							mergeIntoPs.setString(i++, stnd_cost_usd_amt[j]);
//							mergeIntoPs.setString(i++, lnk_ttl_qty[j]);
//							mergeIntoPs.setString(i++, lnk_ttl_amt[j]);
//							mergeIntoPs.setString(i++, cost_vol_cd[j]);						
//							mergeIntoPs.setString(i++, userId);					
//							mergeIntoPs.setString(i++, Utils.change10ToYN(cost_fx_flg[j]));			
//									
//						}
//						mergeIntoPs.addBatch();
//					} else if (flg.equals("D")) {
//						isDelete = true ;
//					
//						//setting 
//						if(event.getString("f_table_name").equals("MAS_NOD_AVG_STND_COST")){								
//							deletePs.setString(i++, cost_yrmon[j]);							
//							deletePs.setString(i++, full_mty_cd[j]);						
//							deletePs.setString(i++, cntr_tpsz_cd[j]);	
//							deletePs.setString(i++, cost_loc_grp_cd[j]);						
//							deletePs.setString(i++, nod_cd[j]);
//							deletePs.setString(i++, trd_cd[j]);
//							deletePs.setString(i++, mas_cost_src_cd[j]);
//						}else{							
//							deletePs.setString(i++, cost_yrmon[j]);							
//							deletePs.setString(i++, lnk_fm_nod_cd[j]);								
//							deletePs.setString(i++, lnk_to_nod_cd[j]);
//							deletePs.setString(i++, co_cd[j]);								
//							deletePs.setString(i++, cntr_tpsz_cd[j]);							
//							deletePs.setString(i++, full_mty_cd[j]);						
//							deletePs.setString(i++, mas_cost_src_cd[j]);							
//							deletePs.setString(i++, cost_loc_grp_cd[j]);														
//						}							
//						deletePs.addBatch();
//					}
//				}
//			}
//			
//			i = 1;
//			// Loggable Statement 사용에 의해 추가
//			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
//				log.info("\n SQL :" + ((LoggableStatement)mergeIntoPs).getQueryString());
//				log.info("\n SQL :" + ((LoggableStatement)deletePs).getQueryString());
//			} else {
//				log.info("\n SQL :" + mergeIntoQuery );
//				log.info("\n SQL :" + deleteQuery );
//			}	
//			
//			if( isMergeInto ) mergeIntoPs.executeBatch();
//			if( isDelete    ) deletePs.executeBatch();					
//			
//		} catch (SQLException se) {
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		} catch (DAOException de) {
//			log.error(de.getMessage(),de);
//			throw de;
//		} catch (Exception e) {
//			log.error(e.getMessage(),e);
//			throw new DAOException(e.getMessage());
//		} finally {
//			closeStatement(mergeIntoPs);
//			closeStatement(deletePs);
//			closeConnection(con);
//		}
//	}	
//	
	/**
	 * 조회할 테이블 필드명 가져오기<br>
	 * @param SearchConditionVO searchConditionVO 
	 * @return List<SearchCostStructure0139ListVO>
	 * @throws DAOException
	 */
	 public List<SearchCostStructure0139ListVO> searchCostStructure0139List(SearchConditionVO searchConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchCostStructure0139ListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchConditionVO != null){
				Map<String, String> mapVO = searchConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			//dbRowset으로값을 담음
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CostStructureDBDAOSearchCostStructure0139ListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchCostStructure0139ListVO .class);
			//list형 으로 변경해서 값을 리턴해줌
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
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<MasTrnsFdrTermVO> insModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addCostStructure0139(List<MasTrnsFdrTermVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new CostStructureDBDAOMasTrnsFdrTermVOCSQL(), insModels,null);
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
		return insCnt;
	}
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<MasTrnsFdrTermVO> updModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifyCostStructure0139(List<MasTrnsFdrTermVO> updModels) throws DAOException,Exception {
		int updCnt[] = null;
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new CostStructureDBDAOMasTrnsFdrTermVOCSQL(), updModels,null);
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
		return updCnt;
	}
		
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<MasTrnsFdrTermVO> delModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] removeCostStructure0139(List<MasTrnsFdrTermVO> delModels) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new CostStructureDBDAOMasTrnsFdrTermVODSQL(), delModels,null);
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
		return delCnt;
	}
		
	
	
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchCostStructure0140ListVO searchCostStructure0140ListVO
	 * @param SearchConditionVO searchCondition
	 * @return List<SearchCostStructure0140ListVO>
	 * @throws DAOException
	 */
	 public List<SearchCostStructure0140ListVO> searchCostStructure0140List(SearchCostStructure0140ListVO searchCostStructure0140ListVO
			                                                              ,SearchConditionVO searchCondition) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchCostStructure0140ListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchCostStructure0140ListVO != null){
				Map<String, String> mapVO = searchCostStructure0140ListVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			if(searchCondition != null){
				Map<String, String> mapVO = searchCondition .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CostStructureDBDAOSearchCostStructure0140ListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchCostStructure0140ListVO .class);
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
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<MasTrnsTermCalcVO> instupdModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	 public int[] modifyCostStructure0140(List<MasTrnsTermCalcVO> instupdModels) throws DAOException,Exception {
		int updCnt[] = null;
		// 데이터를 동시에 저장할 때 block할 건수
		int      msg_cnt    = 200;
		String   msg_action = "save";				
		String[] errMessage = {msg_action, msg_cnt+""};	
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(instupdModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new CostStructureDBDAOMasTrnsTermCalcVOCSQL(), instupdModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert or update No"+ i + " SQL");
				}
				
				if(updCnt.length >= msg_cnt){
					log.info("\n You can't "+msg_action+" more than "+msg_cnt+" rows.");				
					throw new DAOException(new ErrorHandler("MAS00030",errMessage).getMessage());	
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return updCnt;
	 }
		
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<MasTrnsTermCalcVO> delModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] removeCostStructure0140(List<MasTrnsTermCalcVO> delModels) throws DAOException,Exception {
		int delCnt[] = null;
		int      msg_cnt    = 200;
		String   msg_action = "delete";				
		String[] errMessage = {msg_action, msg_cnt+""};
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new CostStructureDBDAOMasTrnsTermCalcVODSQL(), delModels,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
				
				if(delCnt.length >= msg_cnt){
					log.info("\n You can't "+msg_action+" more than "+msg_cnt+" rows.");				
					throw new DAOException(new ErrorHandler("MAS00030",errMessage).getMessage());	
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return delCnt;
	}
		
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet getVariableHeader2() throws DAOException {
		DBRowSet dbRowset  = null;

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CostStructureDBDAOGetVariableheader2RSQL(), null, null);
			/*
			while(dbRowset.next()) {
				log.debug(dbRowset.getString("code"));
			} */
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}	
	
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchSoCode0160ListVO searchSoCode0160ListVO
	 * @param SearchConditionVO searchConditionVO
	 * @param GetVariableheader2VO variableheader2VO
	 * @return SearchSoCode0160ListVO
	 * @throws DAOException
	 */
	 public SearchSoCode0160ListVO searchSoCode0160List(SearchSoCode0160ListVO searchSoCode0160ListVO, SearchConditionVO searchConditionVO, GetVariableheader2VO variableheader2VO) throws DAOException {
			DBRowSet dbRowset = null;
			SearchSoCode0160ListVO retVo = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();		
			try{			
				if(searchConditionVO != null){
				    Map<String, String> mapVO = searchConditionVO.getColumnValues();
					    
					param.putAll(mapVO);
					velParam.putAll(mapVO);
					String tmp = variableheader2VO.getCode();
					 String[] header = tmp.split("[|]");
					List<String> aryYdSeq = new ArrayList();   
					
					for(int i = 0; i < header.length; i++){   
					    aryYdSeq.add(header[i]);   
					} 			
					
					velParam.put("header", aryYdSeq);
				}
			    dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CostStructureDBDAOSearchSoCode0160ListRSQL(), param, velParam);			
				
	            retVo = new SearchSoCode0160ListVO();
				retVo.setRowSet(dbRowset);			
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				log.error("err "+se.toString(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				log.error("err "+ex.toString(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return retVo;		
		}
		 
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param GetVariableheader2VO vo
	 * @throws DAOException
	 * @throws Exception
	 */
    public void modifySoCode0160(GetVariableheader2VO vo) throws DAOException {
        int insCnt[] = null;
        try{
        	SQLExecuter sqlExe = new SQLExecuter("");
            if(vo.getMultiCreateList().size() > 0){            	
                insCnt = sqlExe.executeBatch((ISQLTemplate)new CostStructureDBDAOMasAgmtRstrMgmtVOCSQL(), vo.getMultiCreateList(), null);
                for(int i = 0; i < insCnt.length; i++){
                    if(insCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No"+ i + " SQL");
                }            	
            }           
        }catch (SQLException se) {
        	log.error("err "+se.toString(),se);
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
        	log.error("err "+ex.toString(),ex);
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
    }	
			 
	/**
	 * Sheet1의 테이블의 컬럼 목록을 조회(NODE, LINK))<br>
	 * 
	 * @param String fTableName
	 * @return List<TableColumnVO>
	 * @throws DAOException
	 */
	public List<TableColumnVO> searchCostStructure0137List(String fTableName ) throws DAOException {
		DBRowSet dbRowset = null;
		List<TableColumnVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			velParam.put("f_col_only", "Y");
			velParam.put("f_table_name", fTableName);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CostStructureDBDAOSearchCostStructure0137ListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TableColumnVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
				 
	/**
	 * NODE,LINK 단가 조회<br>
	 * 
	 * @param String fTableName
	 * @param TableColumnVO[] tableColumnVOs
	 * @return List<NodLnkCostCodeVO>
	 * @throws DAOException
	 */
	public List<NodLnkCostCodeVO> searchCostStructure0137List2(String fTableName, TableColumnVO[] tableColumnVOs) throws DAOException {
		DBRowSet dbRowset = null;
		List<NodLnkCostCodeVO> list = null;
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<TableColumnVO> paramList = new ArrayList<TableColumnVO>();
		
		int msg_cnt    = 150000;
		String   msg_action = "retrieve";
		try{
			paramList = new ArrayList<TableColumnVO>();
			if(tableColumnVOs.length>0){
				for(int i=0; i<tableColumnVOs.length; i++) {
					if(!"".equals(tableColumnVOs[i].getValue())) 	paramList.add( tableColumnVOs[i]);
					log.debug("i=" + i + ">>>>>>>>" + tableColumnVOs[i].getColName() + tableColumnVOs[i].getInEquality() + tableColumnVOs[i].getValue());
				}
			}
			velParam.put("conditionArr", paramList);
			velParam.put("f_table_name", fTableName);
			
			//먼저 검색결과 개수를 센다.
			velParam.put("f_row_count", "Y");
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CostStructureDBDAOSearchCostStructure0137List2RSQL(), null, velParam);
			String[] errMessage = {msg_action, msg_cnt + ""};
			
			if(dbRowset != null){
				dbRowset.next(); 
				//결과가 지정한 값보다 크면 사용자에게 메시지를 보여준다.
				if(dbRowset.getInt(1) >= msg_cnt) {
					log.info("\n You can't "+msg_action+" more than "+msg_cnt+" rows.");
					throw new EventException(new ErrorHandler("MAS00030",errMessage).getMessage());
				}
				else {
					//데이터 조회를 하기 위해 새로 세팅해준다.
					velParam.put("f_row_count", "N");
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CostStructureDBDAOSearchCostStructure0137List2RSQL(), null, velParam);
					list = (List)RowSetUtil.rowSetToVOs(dbRowset, NodLnkCostCodeVO.class);
				}	
			}					
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
				
	/**
	 *NODE, LINK단가 입력/수정<br>
	 * 
	 * @param String fTableName
	 * @param List<NodLnkCostCodeVO> mergeModels
	 * @throws DAOException List<MasTrnsTermCalcVO>
	 * @throws Exception
	 */
	public void modifyCostStructure0137(String fTableName, List<NodLnkCostCodeVO> mergeModels) throws DAOException,Exception {
		int msg_cnt    = 1000;
		String   msg_action = "save";
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int mergeCnt[] = null;

			String[] errMessage = {msg_action, msg_cnt+""};
			log.debug("CostStructureDBDAO.multiCostStructure0137S fTableName=" + fTableName);
			if(mergeModels.size() > 0){
				if(mergeModels.size() > msg_cnt) {
					log.info("\n You can't "+msg_action+" more than "+msg_cnt+" rows.");
					throw new EventException(new ErrorHandler("MAS00030",errMessage).getMessage());
				} else {
					velParam.put("f_table_name", fTableName);
					mergeCnt = sqlExe.executeBatch((ISQLTemplate)new CostStructureDBDAOMultiCostStructure0137CSQL(), mergeModels,velParam);
					for(int i = 0; i < mergeCnt.length; i++){
						if(mergeCnt[i]== Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to merge No"+ i + " SQL");
					}
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
	 * NODE, LINK단가 삭제<br>
	 * 
	 * @param String fTableName
	 * @param List<NodLnkCostCodeVO> delModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] removeCostStructure0137(String fTableName, List<NodLnkCostCodeVO> delModels) throws DAOException,Exception {
		int msg_cnt    = 200;
		String   msg_action = "delete";
		int delCnt[] = null;
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			String[] errMessage = {msg_action, msg_cnt+""};
			log.debug("CostStructureDBDAO.deleteCostStructure0137 fTableName=" + fTableName);
			if(delModels.size() > 0){
				
				if(delModels.size() > msg_cnt) {
					log.info("\n You can't "+msg_action+" more than "+msg_cnt+" rows.");
					throw new EventException(new ErrorHandler("MAS00030",errMessage).getMessage());
				} else {
					velParam.put("f_table_name", fTableName);
					delCnt = sqlExe.executeBatch((ISQLTemplate)new CostStructureDBDAOMultiCostStructure0137DSQL(), delModels,velParam);
					for(int i = 0; i < delCnt.length; i++){
						if(delCnt[i]== Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to delete No"+ i + " SQL");
					}
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return delCnt;
	}
	
	/**
	 * ESM_MAS_0134 조회<br>
	 * 
	 * @param RevExpChargeVO revExpChargeVO
	 * @return List<RevExpChargeVO>
	 * @throws DAOException
	 */
	public List<RevExpChargeVO> searchRevExpChargeList(RevExpChargeVO revExpChargeVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RevExpChargeVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(revExpChargeVO != null){
				Map<String, String> mapVO = revExpChargeVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CostStructureDBDAORevExpChargeRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RevExpChargeVO.class);
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
	 * ESM_MAS_0134 - Modify<br>
	 *
	 * @param  @param List<RevExpChargeVO> updModels
	 * @throws DAOException
	 */	
	public void modifyRevExpCharge(List<RevExpChargeVO> mutiModels) throws DAOException,Exception {
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(mutiModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new CostStructureDBDAORevExpChargeUSQL(), mutiModels, null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}			
		}catch (SQLException se) {
			log.error("err " + se.toString(), se);
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * ESM_MAS_0134 - Delete<br>
	 *
	 * @param  @param List<RevExpChargeVO> updModels
	 * @throws DAOException
	 */
	public void removeRevExpCharge(List<RevExpChargeVO> mutiModels) throws DAOException,Exception {
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;			
			if(mutiModels.size() > 0){
                delCnt = sqlExe.executeBatch((ISQLTemplate)new CostStructureDBDAORevExpChargeDSQL(), mutiModels, null);
                for(int i = 0; i < delCnt.length; i++){
                    if(delCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to delete No"+ i + " SQL");
                }            	
            }
		}catch (SQLException se) {
			log.error("err " + se.toString(), se);
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	
				
}



