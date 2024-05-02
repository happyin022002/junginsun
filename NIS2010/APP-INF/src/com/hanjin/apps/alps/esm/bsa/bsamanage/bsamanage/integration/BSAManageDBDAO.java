/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : BSAManageDBDAO.java
 *@FileTitle : BSA Manage
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-10-02
 *@LastModifier : KimJongBeom
 *@LastVersion : 1.0
 * 2006-10-02 KimJongBeom
 * 1.0 최초 생성
 =========================================================
 * History :
 * 2008.05.07 PEJ Error Message 변경 
 * 2008.05.16 PEJ N200805130013 E-NIS Slot price 화면 에러 수정 요청 [028]
 * 2008.10.01 박칠서 CSR No.N200809030016 
 * 2008.10.01 전성진 CSR No.N200809059194 
 * 					 : Over Used Slot Price Table 생성
 * 2008.12.30 박은주 : BSA Table관련 조회기간 변경 to date를 사용하지 안도록 변경
 * 2009.03.26 박은주 : 품질검토결과 수정사항 반영                   
 * 2009.05.25 박은주 CSR No.N200902180050 : Legacy 전환 요건 협의 결과 요청사항 ( JOO vs BSA)                 
 * 2009.05.25 김종열 CSR No.N200904020151 : Legacy 전환 요건 협의 결과 요청사항 ( JOO vs BSA)
 * 2009.09.14 남궁진호 CSR No.CHM-200900987 -modifySpcJoOthCapa : D3 Type코드 추가
 * 										   -modifySpcScOthCapa : D3 Type코드 추가
 * 										   -addSpcJoCrrCapa : D3 Type코드 추가 
 * 										   -addSpcScCrrCapa : D3 Type코드 추가
 * 2009.09.14 Kim Ki-Dae ENIS --> ALPS 변환   
* 2009.11.18 남궁진호 CHM-200901152
*                  : Carrier Code의 MDM 통합관리에 따른 로직 수정
 * 2010.06.21 이행지  - CHM-201004175 : 소스품질검토결과 적용(20100503) 
 * 2013.10.22 진마리아 - printStackTrace 수정 미태깅으로 인한 LIVE LOG 발생 
 * 2014.12.11 김용습 [CHM-201433095] Overlapped Contract Inquiry 화면 추가 
 =========================================================*/

package com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.basic.BSAManageBCImpl;
import com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.vo.BsaAddCarrierSaveVO;
import com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.vo.BsaHighCubicRateSaveVO;
import com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.vo.BsaManageSltPrcSaveVO;
import com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.vo.BsaOverUsedSlotCostSaveVO;
import com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.vo.BsaTableSaveVO;
import com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.vo.CreateBSAVO;
import com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.vo.SearchOverlappedContractInquiryListVO;
import com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.vo.SearchBsaConditionVO;
import com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.vo.SearchBsaCrrRgstListVO;
import com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.vo.SearchChgSlotSwapListVO;
import com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.vo.SearchSpcJoPortDownDetailListVO;
import com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.vo.SearchSpcJoPortDownMasterListVO;
import com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.vo.SearchSpcScPortDownDetailListVO;
import com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.vo.SearchSpcScPortDownMasterListVO;
import com.hanjin.apps.alps.esm.bsa.common.vo.CommonBsaRsVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.BsaCrrInfoVO;
import com.hanjin.syscommon.common.table.BsaCrrRgstVO;
import com.hanjin.syscommon.common.table.BsaJntOpBzcVO;
import com.hanjin.syscommon.common.table.BsaJntOpCrrCapaVO;
import com.hanjin.syscommon.common.table.BsaJntOpPortDwnVO;
import com.hanjin.syscommon.common.table.BsaSltChtrBzcVO;
import com.hanjin.syscommon.common.table.BsaSltChtrCrrCapaVO;
import com.hanjin.syscommon.common.table.BsaSltChtrPortDwnVO;
import com.hanjin.syscommon.common.table.BsaSpcCtrlSwapVO;


/**
 * ALPS-BSAManage에 대한 DB 처리를 담당<br>
 * - ALPS-BSAManage Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author Kim Ki Dae
 * @see BSAManageBCImpl 참조
 * @since J2EE 1.6
 */
public class BSAManageDBDAO extends DBDAOSupport {

	/**
	 * BSAManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 *  - 사용 프로그램 : ESM_BSA_0021<br>
	 *  
	 * @param String bsaOpCd
	 * @return CommonBsaRsVO
	 * @throws DAOException
	 */

	public CommonBsaRsVO searchBSATableHeaderList(String bsaOpCd) throws DAOException {
		log.debug("################# BSAManageDBDAO.searchBSATableHeaderList() ############################[START]");
		DBRowSet dbRowset = null;
		CommonBsaRsVO rsVo = new CommonBsaRsVO();		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			if(bsaOpCd != null){
				param.put("bsa_op_cd",bsaOpCd);				
			}	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BSAManageDBDAOSearchBSATableHeaderListRSQL(), param, null);
			rsVo.setDbRowset(dbRowset);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		log.debug("################# BSAManageDBDAO.searchBSATableHeaderList() ############################[END]");
		return rsVo;		
	}		

	/**
	 * BSAManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * - 사용 프로그램 : ESM_BSA_0021
	 *
	 * @param SearchBsaConditionVO vo
	 * @param List<SearchBsaCrrRgstListVO> codeArr
	 * @return CommonBsaRsVO
	 * @throws DAOException
	 */
	public CommonBsaRsVO searchBSATableJOList(SearchBsaConditionVO vo,List<SearchBsaCrrRgstListVO> codeArr) throws DAOException {
		log.debug("################# BSAManageDBDAO.searchBSATableJOList() ############################[START]");
		DBRowSet dbRowset = null;
		CommonBsaRsVO rsVo = new CommonBsaRsVO();
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			
			if(vo != null){
				Map<String, String> mapVO = vo .getColumnValues();
				param.putAll(mapVO);				
				velParam.putAll(mapVO);
				velParam.put("keyList",codeArr);
		
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BSAManageDBDAOSearchBSATableJOListRSQL(), param, velParam);
			rsVo.setDbRowset(dbRowset);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		log.debug("################# BSAManageDBDAO.searchBSATableJOList() ############################[END]");
		return rsVo;
	}

	/**
	 * BSAManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * - 사용 프로그램 : ESM_BSA_0021
	 *
	 * @param SearchBsaConditionVO vo
	 * @param List<SearchBsaCrrRgstListVO> codeArr
	 * @return CommonBsaRsVO
	 * @throws DAOException
	 */
	public CommonBsaRsVO searchBSATableSCList(SearchBsaConditionVO vo,List<SearchBsaCrrRgstListVO> codeArr) throws DAOException {
		log.debug("################# BSAManageDBDAO.searchBSATableSCList() ############################[START]");
		DBRowSet dbRowset = null;
		CommonBsaRsVO rsVo = new CommonBsaRsVO();
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(vo != null){
				Map<String, String> mapVO = vo .getColumnValues();
				param.putAll(mapVO);				
				velParam.putAll(mapVO);
				velParam.put("keyList",codeArr);
		
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BSAManageDBDAOSearchBSATableSCListRSQL(), param, velParam);
			rsVo.setDbRowset(dbRowset);			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		log.debug("################# BSAManageDBDAO.searchBSATableSCList() ############################[END]");
		return rsVo;			
	}	

	
	/**
	 * 선택된 ROW에 대한 레코드를 삭제한다.<br>
	 * - 사용 프로그램 : ESM_BSA_0021
	 * - 삭제 테이블 : BSA_JNT_OP_BZC, BSA_JNT_OP_CRR_CAPA, BSA_SPC_CTRL_SWAP, BSA_JNT_OP_PORT_DWN
	 *
	 * @param List<BsaJntOpPortDwnVO> delModels
	 * @return int[]
	 * @throws DAOException
	 */
	public int[] removeBSATableJO1(List<BsaJntOpPortDwnVO> delModels) throws DAOException,Exception {
        int delCnt[] = null;
		
        try{
        	SQLExecuter sqlExe = new SQLExecuter("");
            if(delModels.size() > 0){
            	delCnt = sqlExe.executeBatch((ISQLTemplate)new BSAManageDBDAORemoveBSATableJO1DSQL(),delModels, null);
                for(int i = 0; i < delCnt.length; i++){
                    if(delCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to delete1 No"+ i + " SQL");
                }            	
            }
                      
        } catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return delCnt;
	}

	/**
	 * 선택된 ROW에 대한 레코드를 삭제한다.<br>
	 * - 사용 프로그램 : ESM_BSA_0021
	 * - 삭제 테이블 : BSA_JNT_OP_BZC, BSA_JNT_OP_CRR_CAPA, BSA_SPC_CTRL_SWAP, BSA_JNT_OP_PORT_DWN
	 *
	 * @param List<BsaJntOpCrrCapaVO> delModels
	 * @return int[]
	 * @throws DAOException
	 */
	public int[] removeBSATableJO2(List<BsaJntOpCrrCapaVO> delModels) throws DAOException,Exception {
        int delCnt[] = null;
		
        try{
        	SQLExecuter sqlExe = new SQLExecuter("");
            
            if(delModels.size() > 0){
            	delCnt = sqlExe.executeBatch((ISQLTemplate)new BSAManageDBDAORemoveBSATableJO2DSQL(), delModels, null);
                for(int i = 0; i < delCnt.length; i++){
                    if(delCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to delete2 No"+ i + " SQL");
                }            	
            }
            
        } catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return delCnt;
	}
	
	/**
	 * 선택된 ROW에 대한 레코드를 삭제한다.<br>
	 * - 사용 프로그램 : ESM_BSA_0021
	 * - 삭제 테이블 : BSA_JNT_OP_BZC, BSA_JNT_OP_CRR_CAPA, BSA_SPC_CTRL_SWAP, BSA_JNT_OP_PORT_DWN
	 *
	 * @param List<BsaSpcCtrlSwapVO> delModels
	 * @return int[]
	 * @throws DAOException
	 */
	public int[] removeBSATableJO3(List<BsaSpcCtrlSwapVO> delModels) throws DAOException,Exception {
        int delCnt[] = null;
		
        try{
        	SQLExecuter sqlExe = new SQLExecuter("");
            if(delModels.size() > 0){
            	delCnt = sqlExe.executeBatch((ISQLTemplate)new BSAManageDBDAORemoveBSATableJO3DSQL(), delModels, null);
                for(int i = 0; i < delCnt.length; i++){
                    if(delCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to delete3 No"+ i + " SQL");
                }            	
            }
            
        } catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return delCnt;
	}
	
	/**
	 * 선택된 ROW에 대한 레코드를 삭제한다.<br>
	 * - 사용 프로그램 : ESM_BSA_0021
	 * - 삭제 테이블 : BSA_JNT_OP_BZC, BSA_JNT_OP_CRR_CAPA, BSA_SPC_CTRL_SWAP, BSA_JNT_OP_PORT_DWN
	 *
	 * @param List<BsaJntOpBzcVO>  delModels
	 * @return int[]
	 * @throws DAOException
	 */
	public int[] removeBSATableJO4(List<BsaJntOpBzcVO>  delModels) throws DAOException,Exception {
        int delCnt[] = null;
		
        try{
        	SQLExecuter sqlExe = new SQLExecuter("");
            
            if(delModels.size() > 0){
            	delCnt = sqlExe.executeBatch((ISQLTemplate)new BSAManageDBDAORemoveBSATableJO4DSQL(), delModels, null);
                for(int i = 0; i < delCnt.length; i++){
                    if(delCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to delete4 No"+ i + " SQL");
                }            	
            }            
        }catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return delCnt;
    }	
	
	/**
	 * 선택된 ROW에 대한 레코드를 삭제한다.<br>
	 * - 사용 프로그램 : ESM_BSA_0021
	 * - 삭제 테이블 : BSA_SLT_CHTR_BZC, BSA_SLT_CHTR_CRR_CAPA, BSA_SLT_CHTR_PORT_DWN
	 *
	 * @param List<BsaSltChtrPortDwnVO> delModels
	 * @return int[]
	 * @throws DAOException
	 */
    public int[] removeBSATableSC1(List<BsaSltChtrPortDwnVO> delModels) throws DAOException,Exception {
        int delCnt[] = null;
        try{
        	SQLExecuter sqlExe = new SQLExecuter("");
            if(delModels.size() > 0){
            	delCnt = sqlExe.executeBatch((ISQLTemplate)new BSAManageDBDAORemoveBSATableSC1DSQL(), delModels, null);
                for(int i = 0; i < delCnt.length; i++){
                    if(delCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to delete1 No"+ i + " SQL");
                }            	
            }
            
        }catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return delCnt;
    }	
    
    /**
	 * 선택된 ROW에 대한 레코드를 삭제한다.<br>
	 * - 사용 프로그램 : ESM_BSA_0021
	 * - 삭제 테이블 : BSA_SLT_CHTR_BZC, BSA_SLT_CHTR_CRR_CAPA, BSA_SLT_CHTR_PORT_DWN
	 *
	 * @param List<BsaSltChtrCrrCapaVO> delModels
	 * @return int[]
	 * @throws DAOException
	 */
    public int[] removeBSATableSC2(List<BsaSltChtrCrrCapaVO> delModels) throws DAOException,Exception {
        int delCnt[] = null;
		
        try{
        	SQLExecuter sqlExe = new SQLExecuter("");
            if(delModels.size() > 0){
            	delCnt = sqlExe.executeBatch((ISQLTemplate)new BSAManageDBDAORemoveBSATableSC2DSQL(), delModels, null);
                for(int i = 0; i < delCnt.length; i++){
                    if(delCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to delete2 No"+ i + " SQL");
                }            	
            }
            
        }catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return delCnt;
    }	
    
    /**
	 * 선택된 ROW에 대한 레코드를 삭제한다.<br>
	 * - 사용 프로그램 : ESM_BSA_0021
	 * - 삭제 테이블 : BSA_SLT_CHTR_BZC, BSA_SLT_CHTR_CRR_CAPA, BSA_SLT_CHTR_PORT_DWN
	 *
	 * @param List<BsaSltChtrBzcVO> delModels
	 * @return int[]
	 * @throws DAOException
	 */
    public int[] removeBSATableSC3(List<BsaSltChtrBzcVO>  delModels) throws DAOException,Exception {
        int delCnt[] = null;
		
        try{
        	SQLExecuter sqlExe = new SQLExecuter("");
            if(delModels.size() > 0){
            	delCnt = sqlExe.executeBatch((ISQLTemplate)new BSAManageDBDAORemoveBSATableSC3DSQL(), delModels, null);
                for(int i = 0; i < delCnt.length; i++){
                    if(delCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to delete3 No"+ i + " SQL");
                }            	
            }          
        }catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return delCnt;
    }	
	
	/**
	 * BSA_JNT_OP_BZC의 신규 데이터 입력시 SEQ 채번<br>
	 * - 사용 프로그램 : ESM_BSA_0021
	 *
	 * @param BsaTableSaveVO vo
	 * @return String
	 * @throws DAOException
	 */

    public String bsaJntOpBzcSeqno(BsaTableSaveVO vo) throws DAOException {
        DBRowSet dbRowset = null;
        String bsaSeq ="";
      //query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			if(vo != null){
				param.put("trd_cd",vo.getTrdcd());		
				param.put("rlane_cd",vo.getRlanecd());
				param.put("dir_cd",vo.getDircd());
				param.put("vop_cd",vo.getVopcd());
				param.put("vsl_capa",vo.getVslcapa());
			}	
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BSAManageDBDAOBsaJntOpBzcSeqnoRSQL(), param, null);
            
            if(dbRowset.getRowCount() > 0 )
            	dbRowset.next();
            	bsaSeq = dbRowset.getString("seq");
            
		}catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return bsaSeq;
    }
    
    	
    
    /**
	 * BSA_JNT_OP_BZC의 지정된 ibflag 값에 따라 DB에 반영한다.(추가)<br>
	 * - 사용 프로그램 : ESM_BSA_0021
	 *
	 * @param List<BsaJntOpBzcVO> insModels
	 * @return  int[]
	 * @throws DAOException
	 */
	
	public int[] addMultiBsaJntOpBzc(List<BsaJntOpBzcVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new BSAManageDBDAOAddMultiBsaJntOpBzcCSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
	
	/**
	 * BSA_JNT_OP_BZC의 지정된 ibflag 값에 따라 DB에 반영한다.( 수정)<br>
	 * - 사용 프로그램 : ESM_BSA_0021
	 *
	 * @param List<BsaJntOpBzcVO> updModels
	 * @return  int[]
	 * @throws DAOException
	 */
	public int[] modifyMultiBsaJntOpBzc(List<BsaJntOpBzcVO> updModels) throws DAOException,Exception {
		int updCnt[] = null; 
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new BSAManageDBDAOModifyMultiBsaJntOpBzcUSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return updCnt;
	}

	/**
	 * BSA_JNT_OP_CRR_CAPA의 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정, 삭제)<br>
	 * - 사용 프로그램 : ESM_BSA_0021
	 *
	 * @param List<BsaJntOpCrrCapaVO> multModels
	 * @return  int[]
	 * @throws DAOException
	 */
    public int[] multiBsaJntOpCrrCapa(List<BsaJntOpCrrCapaVO> multModels) throws DAOException {
        int multCnt[] = null;
		
        try{
        	SQLExecuter sqlExe = new SQLExecuter("");
            if(multModels.size() > 0){
            	multCnt = sqlExe.executeBatch((ISQLTemplate)new BSAManageDBDAOMultiBsaJntOpCrrCapaCSQL(), multModels, null);
                for(int i = 0; i < multCnt.length; i++){
                    if(multCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No"+ i + " SQL");
                }            	
            }         
        }catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return multCnt;
    }		

	/**
	 * BSA_SPC_CTRL_SWAP의 지정된 ibflag 값에 따라 DB에 반영한다.(추가)<br>
	 * - 사용 프로그램 : ESM_BSA_0021
	 *
	 * @param List<BsaSpcCtrlSwapVO> insModels
	 * @throws DAOException
	 */
    public void addBsaSpcCtrlSwap(List<BsaSpcCtrlSwapVO> insModels) throws DAOException {
        int insCnt[] = null;
		
        try{
        	SQLExecuter sqlExe = new SQLExecuter("");
            if(insModels.size() > 0){
                insCnt = sqlExe.executeBatch((ISQLTemplate)new BSAManageDBDAOAddBsaSpcCtrlSwapCSQL(), insModels, null);
                for(int i = 0; i < insCnt.length; i++){
                    if(insCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No"+ i + " SQL");
                }            	
            }                       
        }catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
    }	


	
	/**
	 * BSA_SLT_CHTR_BZC의 SEQ 채번(추가)<br>
	 * - 사용 프로그램 : ESM_BSA_0021
	 *
	 * @param BsaTableSaveVO vo
	 * @return String 
	 * @throws DAOException
	 */
    public String bsaSltChtrBzcSeqno(BsaTableSaveVO vo) throws DAOException {
        DBRowSet dbRowset = null;
        String bsaSeq ="";
      //query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			if(vo != null){
				param.put("trd_cd",vo.getTrdcd());		
				param.put("rlane_cd",vo.getRlanecd());
				param.put("dir_cd",vo.getDircd());
				param.put("vop_cd",vo.getVopcd());
				param.put("vsl_capa",vo.getVslcapa());
			}	
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BSAManageDBDAOBsaSltChtrBzcSeqnoRSQL(), param, null);
            
            if(dbRowset.getRowCount() > 0 )
            	dbRowset.next();
            	bsaSeq = dbRowset.getString("seq");
            
		}catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return bsaSeq;
    }
      
	/**
	 * BSA_SLT_CHTR_BZC의 지정된 ibflag 값에 따라 DB에 반영한다.(추가)<br>
	 * - 사용 프로그램 : ESM_BSA_0021
	 *
	 * @param List<BsaSltChtrBzcVO> insModels
	 * @return  int[]
	 * @throws DAOException
	 */
    public int[] addMultiBsaSltChtrBzc(List<BsaSltChtrBzcVO> insModels) throws DAOException {
        int insCnt[] = null;
        log.debug("############ BSAManageDBDAO.addMultiBsaSltChtrBzc() #################### [START]");
        try{
        	SQLExecuter sqlExe = new SQLExecuter("");
            if(insModels.size() > 0){
                insCnt = sqlExe.executeBatch((ISQLTemplate)new BSAManageDBDAOAddMultiBsaSltChtrBzcCSQL(), insModels, null);
                for(int i = 0; i < insCnt.length; i++){
                    if(insCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No"+ i + " SQL");
                }            	
            }
            log.debug("############ BSAManageDBDAO.addMultiBsaSltChtrBzc() #################### [END]");           
        } catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
    }		

    /**
	 * BSA_SLT_CHTR_BZC의 지정된 ibflag 값에 따라 DB에 반영한다.( 수정)<br>
	 * - 사용 프로그램 : ESM_BSA_0021
	 *
	 * @param List<BsaSltChtrBzcVO> updModels
	 * @return  int[]
	 * @throws DAOException
	 */
    public int[] modifyMultiBsaSltChtrBzc(List<BsaSltChtrBzcVO> updModels) throws DAOException {
    	log.debug("############ BSAManageDBDAO.modifyMultiBsaSltChtrBzc() #################### [START]");
        int updCnt[] = null;
		
        try{
        	SQLExecuter sqlExe = new SQLExecuter("");
            if(updModels.size() > 0){
            	updCnt = sqlExe.executeBatch((ISQLTemplate)new BSAManageDBDAOModifyMultiBsaSltChtrBzcUSQL(), updModels, null);
                for(int i = 0; i < updCnt.length; i++){
                    if(updCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to update No"+ i + " SQL");
                }            	
            }
                       
        } catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		  log.debug("############ BSAManageDBDAO.modifyMultiBsaSltChtrBzc() #################### [END]");
		return updCnt;
    }		
      
	/**
	 * BSA_SLT_CHTR_CRR_CAPA의 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정, 삭제)<br>
	 * - 사용 프로그램 : ESM_BSA_0021
	 *
	 * @param List<BsaSltChtrCrrCapaVO> multModels
	 * @return  int[]
	 * @throws DAOException
	 */
    public int[] multiBsaSltChtrCrrCapa(List<BsaSltChtrCrrCapaVO> multModels) throws DAOException {
    	log.debug("############ BSAManageDBDAO.multiBsaSltChtrCrrCapa() #################### [START]");
        int multCnt[] = null;
		
        try{
        	SQLExecuter sqlExe = new SQLExecuter("");
            if(multModels.size() > 0){
            	multCnt = sqlExe.executeBatch((ISQLTemplate)new BSAManageDBDAOMultiBsaSltChtrCrrCapaCSQL(), multModels, null);
                for(int i = 0; i < multCnt.length; i++){
                    if(multCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No"+ i + " SQL");
                }            	
            }         
            log.debug("############ BSAManageDBDAO.multiBsaSltChtrCrrCapa() #################### [END]");
        }catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return multCnt;
    }	    


	/**
	 * BSA_JNT_OP_BZC의 지정된 ibflag 값에 따라 DB에 반영한다.(추가)<br>
	 * - 추가된 데이터에 대한 Capa 추가
	 * - 사용 프로그램 : ESM_BSA_0021
	 *
	 * @param List<BsaJntOpCrrCapaVO> insModels
	 * @throws DAOException
	 */
    public void addSpcJoCrrCapa(List<BsaJntOpCrrCapaVO> insModels) throws DAOException {
        int insCnt[] = null;
		
        try{
        	SQLExecuter sqlExe = new SQLExecuter("");
            if(insModels.size() > 0){
                insCnt = sqlExe.executeBatch((ISQLTemplate)new BSAManageDBDAOAddSpcJoCrrCapaCSQL(), insModels, null);
                for(int i = 0; i < insCnt.length; i++){
                    if(insCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No"+ i + " SQL");
                }            	
            }
                       
        }catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
    }	

	/**
	 * BSA_JNT_OP_BZC의 지정된 ibflag 값에 따라 DB에 반영한다.(추가)<br>
	 * - 추가된 데이터에 대한 Port 추가
	 * - 사용 프로그램 : ESM_BSA_0021
	 *
	 * @param List<BsaJntOpPortDwnVO> insModels
	 * @throws DAOException
	 */
    
    public void addSpcJoPortDwn(List<BsaJntOpPortDwnVO> insModels) throws DAOException {
        int insCnt[] = null;
		
        try{
        	SQLExecuter sqlExe = new SQLExecuter("");
            if(insModels.size() > 0){
                insCnt = sqlExe.executeBatch((ISQLTemplate)new BSAManageDBDAOAddSpcJoPortDwnCSQL(),insModels, null);
                for(int i = 0; i < insCnt.length; i++){
                    if(insCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No"+ i + " SQL");
                }            	
            }
                       
        }catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
    }	


	/**
	 *  BSA_JNT_OP_CRR_CAPA의 지정된 ibflag 값에 따라 DB에 반영한다.(수정)<br>
	 * - 변경된 데이터에 대한 '007','009'를 재작업 --> ESM_BSA_024에서 사용
	 * - 사용 프로그램 : ESM_BSA_0021
	 *
	 * @param List<BsaJntOpCrrCapaVO>  updModels
	 * @throws DAOException
	 */
    public void modifySpcJoBsaCapa(List<BsaJntOpCrrCapaVO>  updModels) throws DAOException {
        int updCnt[] = null;
		
        try{
        	SQLExecuter sqlExe = new SQLExecuter("");
        	
            if(updModels.size() > 0){
            	updCnt = sqlExe.executeBatch((ISQLTemplate)new BSAManageDBDAOModifySpcJoBsaCapaUSQL(),updModels, null);
                for(int i = 0; i < updCnt.length; i++){
                    if(updCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to update No"+ i + " SQL");
                }            	
            }
                       
        }catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
    }	
	
	/**
	 *  BSA_JNT_OP_CRR_CAPA의 지정된 ibflag 값에 따라 DB에 반영한다.(수정)<br>
	 * - 변경된 데이터에 대한 '007','009'를 재작업 --> ESM_BSA_024에서 사용
	 * - 사용 프로그램 : ESM_BSA_0021
	 *
	 * @param List<BsaJntOpCrrCapaVO> updModels
	 * @throws DAOException
	 */
    public void modifySpcJoHJSBsaCapa(List<BsaJntOpCrrCapaVO> updModels) throws DAOException {
        int updCnt[] = null;
		
        try{
        	SQLExecuter sqlExe = new SQLExecuter("");
            if(updModels.size() > 0){
            	updCnt = sqlExe.executeBatch((ISQLTemplate)new BSAManageDBDAOModifySpcJoHJSBsaCapaUSQL(), updModels, null);
                for(int i = 0; i < updCnt.length; i++){
                    if(updCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to update No"+ i + " SQL");
                }            	
            }
           
        }catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
    }	
	
	/**
	 *  BSA_JNT_OP_CRR_CAPA의 지정된 ibflag 값에 따라 DB에 반영한다.(수정)<br>
	 * - 변경된 데이터에 대한 '007','009'를 재작업 --> ESM_BSA_024에서 사용
	 * - 사용 프로그램 : ESM_BSA_0021
	 *
	 * @param List<BsaJntOpCrrCapaVO>  updModels
	 * @throws DAOException
	 */
    public void modifySpcJoOthCapa(List<BsaJntOpCrrCapaVO>  updModels) throws DAOException {
        int updCnt[] = null;
		
        try{
        	SQLExecuter sqlExe = new SQLExecuter("");
            if(updModels.size() > 0){
            	updCnt = sqlExe.executeBatch((ISQLTemplate)new BSAManageDBDAOModifySpcJoOthCapaUSQL(), updModels, null);
                for(int i = 0; i < updCnt.length; i++){
                    if(updCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to update No"+ i + " SQL");
                }            	
            }           
        }catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
    }	
	

	/**
	 * BSA_SLT_CHTR_BZC의 지정된 ibflag 값에 따라 DB에 반영한다.(추가)<br>
	 * - 추가된 데이터에 대한 Capa 추가
	 * - 사용 프로그램 : ESM_BSA_0021
	 *
	 * @param List<BsaSltChtrCrrCapaVO> insModels
	 * @return  int[]
	 * @throws DAOException
	 */
    public int[] addSpcScCrrCapa(List<BsaSltChtrCrrCapaVO> insModels) throws DAOException {
    	log.debug("############ BSAManageDBDAO.addSpcScCrrCapa() #################### [START]");
        int insCnt[] = null;
		
        try{
        	SQLExecuter sqlExe = new SQLExecuter("");
            if(insModels.size() > 0){
                insCnt = sqlExe.executeBatch((ISQLTemplate)new BSAManageDBDAOAddSpcScCrrCapaCSQL(), insModels, null);
                for(int i = 0; i < insCnt.length; i++){
                    if(insCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No"+ i + " SQL");
                }            	
            }
            log.debug("############ BSAManageDBDAO.addSpcScCrrCapa() #################### [END]");
        }catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return insCnt;
    }	
	
	

	/**
	 * BSA_SLT_CHTR_BZC의 지정된 ibflag 값에 따라 DB에 반영한다.(추가)<br>
	 * - 추가된 데이터에 대한 Port 추가
	 * - 사용 프로그램 : ESM_BSA_0021
	 *
	 * @param List<BsaSltChtrPortDwnVO> insModels
	 * @return  int[]
	 * @throws DAOException
	 */
    public int[] addSpcScPortDwn(List<BsaSltChtrPortDwnVO> insModels) throws DAOException {
    	log.debug("############ BSAManageDBDAO.addSpcScPortDwn() #################### [START]");
        int insCnt[] = null;
		
        try{
        	SQLExecuter sqlExe = new SQLExecuter("");
            if(insModels.size() > 0){
                insCnt = sqlExe.executeBatch((ISQLTemplate)new BSAManageDBDAOAddSpcScPortDwnCSQL(), insModels, null);
                for(int i = 0; i < insCnt.length; i++){
                    if(insCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No"+ i + " SQL");
                }            	
            }
            log.debug("############ BSAManageDBDAO.addSpcScPortDwn() #################### [END]");
        }catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return insCnt;
    }		


	/**
	 *  BSA[007]의 Carrier정보를 다시 계산한다.[I/U]
	 * - 사용 프로그램 : ESM_BSA_0021
	 *
	 * @param List<BsaSltChtrCrrCapaVO> updModels
	 * @return  int[]
	 * @throws DAOException
	 */
    public int[] modifySpcScBsaCapa(List<BsaSltChtrCrrCapaVO> updModels) throws DAOException {
    	log.debug("############ BSAManageDBDAO.modifySpcScBsaCapa() #################### [START]");
        int updCnt[] = null;
        try{
        	SQLExecuter sqlExe = new SQLExecuter("");
        	
            if(updModels.size() > 0){
            	updCnt = sqlExe.executeBatch((ISQLTemplate)new BSAManageDBDAOModifySpcScBsaCapaUSQL(), updModels, null);
                for(int i = 0; i < updCnt.length; i++){
                    if(updCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to update No"+ i + " SQL");
                }            	
            }
            log.debug("############ BSAManageDBDAO.modifySpcScBsaCapa() #################### [END]");
        }catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return updCnt;
    }    


	/**
	 * 이전 seq의 Weigth Per TEU, RF, D2, D4, D5, D7의 capa정보를 복제한다.[I]
	 * - 사용 프로그램 : ESM_BSA_0021
	 *
	 * @param List<BsaSltChtrCrrCapaVO> updModels
	 * @return  int[]
	 * @throws DAOException
	 */
    public int[] modifySpcScOthCapa(List<BsaSltChtrCrrCapaVO> updModels) throws DAOException {
    	log.debug("############ BSAManageDBDAO.modifySpcScOthCapa() #################### [START]");
        int updCnt[] = null;
		
        try{
        	SQLExecuter sqlExe = new SQLExecuter("");
            if(updModels.size() > 0){
            	updCnt = sqlExe.executeBatch((ISQLTemplate)new BSAManageDBDAOModifySpcScOthCapaUSQL(), updModels, null);
                for(int i = 0; i < updCnt.length; i++){
                    if(updCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to update No"+ i + " SQL");
                }            	
            }           
            log.debug("############ BSAManageDBDAO.modifySpcScOthCapa() #################### [END]");
        }catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return updCnt;
    }    
	
	/**
	 *  BSA의 HJS정보를 FNL_HJS_BSA_CAPA정보로 업데이트 한다.[I/U]
	 * - 사용 프로그램 : ESM_BSA_0021
	 *
	 * @param List<BsaSltChtrCrrCapaVO> updModels
	 * @return  int[]
	 * @throws DAOException
	 */
    public int[] modifySpcScHJSBsaCapa(List<BsaSltChtrCrrCapaVO> updModels) throws DAOException {
    	log.debug("############ BSAManageDBDAO.modifySpcScHJSBsaCapa() #################### [START]");
        int updCnt[] = null;
        try{
        	SQLExecuter sqlExe = new SQLExecuter("");

            if(updModels.size() > 0){
            	updCnt = sqlExe.executeBatch((ISQLTemplate)new BSAManageDBDAOModifySpcScHJSBsaCapaUSQL(), updModels, null);
                for(int i = 0; i < updCnt.length; i++){
                    if(updCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to update No"+ i + " SQL");
                }            	
            }
            log.debug("############ BSAManageDBDAO.modifySpcScHJSBsaCapa() #################### [END]");
        }catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return updCnt;
    }    
	
	/**
	 * BSAManage의 데이타 모델에 해당되는 값을 생성하기 위한 정보를 조회.<br>
	 * - 사용 프로그램 : ESM_BSA_0021
	 *
	 * @param SearchBsaConditionVO vo
	 * @return  DBRowSet
	 * @throws DAOException
	 */	
	public DBRowSet searchCreateBSAInfo(SearchBsaConditionVO vo) throws DAOException {
		DBRowSet dbRowset  = new DBRowSet();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if(vo != null){
				String fm_yrwk   = vo.getTxtsdate().equals("")?"":vo.getTxtsdate().substring(0,6);
				String to_yrwk   = vo.getTxtedate().equals("")?"":vo.getTxtedate().substring(0,6);
				param.put("fm_yrwk",fm_yrwk);
				param.put("to_yrwk",to_yrwk);		
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BSAManageDBDAOSearchCreateBSAInfoRSQL(), param, null);
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
	 * BSAManage의 데이타 모델에 해당되는 값을 생성한다.<br>
	 * - 사용 프로그램 : ESM_BSA_0021
	 *
	 * @param CreateBSAVO vo
	 * @return  CreateBSAVO
	 * @throws DAOException
	 */	
	@SuppressWarnings("unchecked")
    public CreateBSAVO createBSA(CreateBSAVO vo) throws DAOException,Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> result = new HashMap<String, Object>();
		
		String err_cd ="";
		String err_msg ="";
		
        try{
        	if(vo != null){
        		Map<String, String> mapVO = vo .getColumnValues();
				param.putAll(mapVO);	
			}        	
        	
        	SQLExecuter sqlExe = new SQLExecuter("");
        	result = sqlExe.executeSP((ISQLTemplate)new BSAManageDBDAOCreateBSACSQL(), param, null);
        	
        	err_cd = (String)result.get("p_error_code");
        	err_msg = (String)result.get("p_error_msg");
        	
        	if(vo != null){
        		vo.setPErrorCode(err_cd);
        		vo.setPErrorMsg(err_msg);
        	}
         
        }catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return vo;
    }	
	
		
   /**
	 * ESM_BSA_0021에서 받아온 조건으로 VSL LIST조회<br>
	 * - 사용 프로그램 : ESM_BSA_0123
	 *
	 * @param SearchBsaConditionVO vo
	 * @return List<BsaTableSaveVO>
	 * @throws DAOException
	 */
	public List<BsaTableSaveVO> searchBSATableVvdList(SearchBsaConditionVO vo) throws DAOException {
        DBRowSet dbRowset = null;
        List<BsaTableSaveVO> list = null;
        //query parameter
      	Map<String, Object> param = new HashMap<String, Object>();
      	//velocity parameter
      	Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);				
				velParam.putAll(mapVO);	
			}
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BSAManageDBDAOSearchBSATableVvdListRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, BsaTableSaveVO.class);
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
	 * BSAManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 사용 프로그램 : ESM_BSA_0023
	 *
	 * @return CommonBsaRsVO
	 * @throws DAOException
	 */

	public CommonBsaRsVO searchCarrierRegisterHeaderList() throws DAOException {
		DBRowSet dbRowset = null;
		CommonBsaRsVO retVo = new CommonBsaRsVO();
		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BSAManageDBDAOSearchCarrierRegisterHeaderListRSQL(), null, null);
			retVo.setDbRowset(dbRowset);			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return retVo;
	}

	/**
	 * BSAManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 사용 프로그램 : ESM_BSA_0023
	 *
	 * @param String bsaOpCd
	 * @return CommonBsaRsVO
	 * @throws DAOException
	 */

	public CommonBsaRsVO searchCarrierRegisterMasterList(String bsaOpCd) throws DAOException {
		DBRowSet dbRowset = null;
		CommonBsaRsVO retVo = new CommonBsaRsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			
			if(bsaOpCd != null){
				param.put("bsa_op_cd",bsaOpCd);				
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BSAManageDBDAOSearchCarrierRegisterMasterListRSQL(), param,null);
			retVo.setDbRowset(dbRowset);			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return retVo;		
	}	

	/**
	 * BSAManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 사용 프로그램 : ESM_BSA_0023
	 *
	 * @param String bsaOpCd
	 * @return CommonBsaRsVO
	 * @throws DAOException
	 */

	public CommonBsaRsVO searchCarrierRegisterDetailList(String bsaOpCd) throws DAOException {
		DBRowSet dbRowset = null;
		CommonBsaRsVO retVo = new CommonBsaRsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			
			if(bsaOpCd != null){
				param.put("bsa_op_cd",bsaOpCd);				
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BSAManageDBDAOSearchCarrierRegisterDetailListRSQL(), param, null);
			retVo.setDbRowset(dbRowset);			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return retVo;		
	}	

	/**
	 * BSAManage의 수정 된 데이타 모델을 DB에 반영한다.<br>
	 * 사용 프로그램 : ESM_BSA_0023
	 *
	 * @param List<BsaAddCarrierSaveVO> updModels
	 * @throws DAOException
	 */
    public void modifyCarrierRegisterJO(List<BsaAddCarrierSaveVO> updModels) throws DAOException,Exception {
        int insCnt[] = null;
        int updCnt[] = null;
		
        try{
        	SQLExecuter sqlExe = new SQLExecuter("");
        	 if(updModels.size() > 0){
             	updCnt = sqlExe.executeBatch((ISQLTemplate)new BSAManageDBDAOModifyCarrierRegisterJOUSQL(), updModels, null);
                 for(int i = 0; i < updCnt.length; i++){
                     if(updCnt[i]== Statement.EXECUTE_FAILED)
                         throw new DAOException("Fail to update No"+ i + " SQL");
                 }            	
             }
        	 
            if(updModels.size() > 0){
                insCnt = sqlExe.executeBatch((ISQLTemplate)new BSAManageDBDAOModifyCarrierRegisterJO1CSQL(), updModels, null);
                for(int i = 0; i < insCnt.length; i++){
                    if(insCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No"+ i + " SQL");
                }            	
            }
            
            if(updModels.size() > 0){
                insCnt = sqlExe.executeBatch((ISQLTemplate)new BSAManageDBDAOModifyCarrierRegisterJO2CSQL(), updModels, null);
                for(int i = 0; i < insCnt.length; i++){
                    if(insCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No"+ i + " SQL");
                }            	
            }            
            
           
          
        }catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
    }	

	/**
	 * BSAManage의 수정 된 데이타 모델을 DB에 반영한다.<br>
	 * 사용 프로그램 : ESM_BSA_0023
	 *
	 * @param List<BsaAddCarrierSaveVO> insModels
	 * @return int[]
	 * @throws DAOException
	 */
    public int[] addCarrierRegisterSC(List<BsaAddCarrierSaveVO> insModels) throws DAOException,Exception {
        int insCnt[] = null;
		
        try{
        	SQLExecuter sqlExe = new SQLExecuter("");
            if(insModels.size() > 0){
                insCnt = sqlExe.executeBatch((ISQLTemplate)new BSAManageDBDAOModifyCarrierRegisterSCCSQL(), insModels, null);
                for(int i = 0; i < insCnt.length; i++){
                    if(insCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No"+ i + " SQL");
                }            	
            }      
          
        } catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
    }
    
    /**
	 * BSAManage의 수정 된 데이타 모델을 DB에 반영한다.<br>
	 * 사용 프로그램 : ESM_BSA_0023
	 *
	 * @param List<BsaAddCarrierSaveVO> updModels
	 * @return int[]
	 * @throws DAOException
	 */
    public int[] modifyCarrierRegisterSC(List<BsaAddCarrierSaveVO> updModels) throws DAOException,Exception {
        int updCnt[] = null;
		
        try{
        	SQLExecuter sqlExe = new SQLExecuter("");
            
            if(updModels.size() > 0){
            	updCnt = sqlExe.executeBatch((ISQLTemplate)new BSAManageDBDAOModifyCarrierRegisterSCUSQL(), updModels, null);
                for(int i = 0; i < updCnt.length; i++){
                    if(updCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to update No"+ i + " SQL");
                }            	
            }
          
        } catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return updCnt;
	}

	/**
	 * BSAManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * - 사용 프로그램 : ESM_BSA_0026
	 * 
	 * @param  SearchBsaConditionVO vo
	 * @return List<SearchSpcJoPortDownMasterListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchSpcJoPortDownMasterListVO> searchSpcJoPortDownMasterList(SearchBsaConditionVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSpcJoPortDownMasterListVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(vo != null){
				Map<String, String> mapVO = vo .getColumnValues();
				param.putAll(mapVO);				
				velParam.putAll(mapVO);
		
			}	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BSAManageDBDAOSearchSpcJoPortDownMasterListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSpcJoPortDownMasterListVO.class);
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
	 * BSAManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * - 사용 프로그램 : ESM_BSA_0026
	 * 
	 * @param  SearchBsaConditionVO vo
	 * @return List<SearchSpcJoPortDownDetailListVO> 
	 * @throws DAOException
	 */ 
	@SuppressWarnings("unchecked")
	public List<SearchSpcJoPortDownDetailListVO> searchSpcJoPortDownDetailList(SearchBsaConditionVO vo) throws DAOException {
		log.debug("################# BSAManageDBDAO.searchSpcJoPortDownDetailList() [Jo]############################[START]");
		DBRowSet dbRowset = null;
		List<SearchSpcJoPortDownDetailListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(vo != null){
				Map<String, String> mapVO = vo .getColumnValues();
				param.putAll(mapVO);				
				velParam.putAll(mapVO);
		
			}	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BSAManageDBDAOSearchSpcJoPortDownDetailListRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSpcJoPortDownDetailListVO.class);
			log.debug("################# BSAManageDBDAO.searchSpcJoPortDownDetailList() [Jo]############################[END]");
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
	 * BSAManage의 데이타 모델에 해당되는 값을 삭제한다.<br>
	 * - 사용 프로그램 : ESM_BSA_0026
	 * 
	 * @param  SearchBsaConditionVO vo
	 * @throws DAOException
	 */
    @SuppressWarnings("unchecked")
	public void removeSpcJoPortDownDetail(SearchBsaConditionVO vo) throws DAOException {
        int delCnt[] = null;
        List deleteList = new ArrayList();
        
      //query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
        try{
        	SQLExecuter sqlExe = new SQLExecuter("");
        	if(vo != null){
        		param.put("bsa_seq", vo.getMBsaSeq());
				param.put("bsa_op_cd", vo.getMBsaOpCd());
				param.put("bsa_op_jb_cd", vo.getMBsaOpJbCd());
				param.put("crr_cd", vo.getMCrrCd());
				param.put("trd_cd", vo.getMTrdCd());
				param.put("rlane_cd", vo.getMRlaneCd());
				param.put("dir_cd", vo.getMDirCd());
				param.put("vop_cd", vo.getMVopCd());
				param.put("vsl_capa", vo.getMVslCapa());
				
				deleteList.add(param);
				
			}
            if(deleteList.size() > 0){
                delCnt = sqlExe.executeBatch((ISQLTemplate)new BSAManageDBDAORemoveSpcJoPortDownDetailDSQL(),deleteList, null);
                for(int i = 0; i < delCnt.length; i++){
                    if(delCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to delete No"+ i + " SQL");
                }            	
            }            
        }catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
    }	

	/**
	 * BSAManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * - 사용 프로그램 : ESM_BSA_0026
	 * 
	 * @param SearchBsaConditionVO vo
	 * @param String updUsrId
	 * @throws DAOException
	 */
    @SuppressWarnings("unchecked")
	public void resetSpcJoPortDown(SearchBsaConditionVO vo,String updUsrId) throws DAOException {
    	/*	테이블 컬럼의  수정 값을 저장하는  List */
    	List updateList = new ArrayList();
    	int updCnt[] = null;
    	  
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(vo != null){
				param.put("upd_usr_id", updUsrId);
				param.put("bsa_op_cd", vo.getRdoopcd());
				param.put("bsa_op_jb_cd", vo.getRdotype());
				param.put("crr_cd", vo.getCobCarrier());
				param.put("trd_cd", vo.getCobtrade());
				param.put("rlane_cd", vo.getCoblane());
				param.put("dir_cd", vo.getCobdir());
				param.put("bsa_fm_dt", vo.getTxtsdate().replaceAll("-", ""));
				param.put("bsa_to_dt", vo.getTxtedate().replaceAll("-", ""));
				
				updateList.add(param);
				
				velParam.put("trd_cd", vo.getCobtrade());
				velParam.put("rlane_cd", vo.getCoblane());
				velParam.put("dir_cd", vo.getCobdir());
				velParam.put("bsa_to_dt", vo.getTxtedate().replaceAll("-", ""));
		
			}
			if(updateList.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new BSAManageDBDAOResetSpcJoPortDownUSQL(), updateList, velParam);
				 for(int i = 0; i < updCnt.length; i++){
	                 if(updCnt[i]== Statement.EXECUTE_FAILED)
	                     throw new DAOException("Fail to Update No"+ i + " SQL");
	             } 
			}
        }catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
    }	

	/**
	 * BSAManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * - 사용 프로그램 : ESM_BSA_0026
	 * 
	 * @param SearchBsaConditionVO vo
	 * @param String usrId
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
    public void createSpcJoPortDownDetail(SearchBsaConditionVO vo,String usrId) throws DAOException {
        int insCnt[] = null;
        List insertList = new ArrayList();
    	  
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
        	SQLExecuter sqlExe = new SQLExecuter("");
        	if(vo != null){
        		param.put("bsa_seq", vo.getMBsaSeq());
				param.put("bsa_op_cd", vo.getMBsaOpCd());
				param.put("bsa_op_jb_cd", vo.getMBsaOpJbCd());
				param.put("crr_cd", vo.getMCrrCd());
				param.put("trd_cd", vo.getMTrdCd());
				param.put("rlane_cd", vo.getMRlaneCd());
				param.put("dir_cd", vo.getMDirCd());
				param.put("vop_cd", vo.getMVopCd());
				param.put("vsl_capa", vo.getMVslCapa());
				param.put("cre_usr_id", usrId);
				param.put("upd_usr_id", usrId);
				
				insertList.add(param);
				
			}
            if(insertList.size() > 0){
                insCnt = sqlExe.executeBatch((ISQLTemplate)new BSAManageDBDAOCreateSpcJoPortDownDetailCSQL(), insertList, null);
                for(int i = 0; i < insCnt.length; i++){
                    if(insCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No"+ i + " SQL");
                }            	
            }           
        }catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
    }	

	/**
	 * BSA_JNT_OP_CRR_CAPA의 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정, 삭제)<br>
	 * - 사용 프로그램 : ESM_BSA_0026
	 * 
	 * @param List<BsaJntOpCrrCapaVO> updmodels
	 * @return int[]
	 * @throws DAOException
	 */
    public int[] modifyJOCrrCapa(List<BsaJntOpCrrCapaVO> updmodels) throws DAOException,Exception {
        int updCnt[] = null;
        try{
        	SQLExecuter sqlExe = new SQLExecuter("");
            if(updmodels.size() > 0){
            	updCnt = sqlExe.executeBatch((ISQLTemplate)new BSAManageDBDAOModifyJOCrrCapaUSQL(), updmodels, null);
                for(int i = 0; i < updCnt.length; i++){
                    if(updCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to update No"+ i + " SQL");
                }            	
            }           
        } catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return updCnt;
    }	

	
	/**
	 * BSA_JNT_OP_PORT_DWN의 지정된 ibflag 값에 따라 DB에 반영한다.(추가)<br>
	 * 사용 프로그램 : ESM_BSA_0026
	 * 
	 * @param List<BsaJntOpPortDwnVO> insModels
	 * @return int[]
	 * @throws DAOException
	 */
	
	public int[] addMultiBsaJntOpPortDwn(List<BsaJntOpPortDwnVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new BSAManageDBDAOAddMultiBsaJntOpPortDwnCSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
	
	/**
	 * BSA_JNT_OP_PORT_DWN의 지정된 ibflag 값에 따라 DB에 반영한다.(수정)<br>
	 * 사용 프로그램 : ESM_BSA_0026
	 * 
	 * @param List<BsaJntOpPortDwnVO> updModels
	 * @return int[]
	 * @throws DAOException
	 */
	
	public int[] modifyMultiBsaJntOpPortDwn(List<BsaJntOpPortDwnVO> updModels) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new BSAManageDBDAOModifyMultiBsaJntOpPortDwnUSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return updCnt;
	}
	
	/**
	 * BSA_JNT_OP_PORT_DWN의 지정된 ibflag 값에 따라 DB에 반영한다.(삭제)<br>
	 * 사용 프로그램 : ESM_BSA_0026
	 * 
	 * @param List<BsaJntOpPortDwnVO> delModels
	 * @return int[]
	 * @throws DAOException
	 */
	
	public int[] removeMultiBsaJntOpPortDwn(List<BsaJntOpPortDwnVO> delModels) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new BSAManageDBDAORemoveMultiBsaJntOpPortDwnDSQL(), delModels,null);
				
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return delCnt;
	}
	
	/**
	 * BSAManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * - 사용 프로그램 : ESM_BSA_0026
	 * 
	 * @param  SearchBsaConditionVO vo
	 * @return List<SearchSpcScPortDownMasterListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchSpcScPortDownMasterListVO> searchSpcScPortDownMasterList(SearchBsaConditionVO vo) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		List<SearchSpcScPortDownMasterListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(vo != null){
				Map<String, String> mapVO = vo .getColumnValues();
				param.putAll(mapVO);				
				velParam.putAll(mapVO);
		
			}	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BSAManageDBDAOSearchSpcScPortDownMasterListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSpcScPortDownMasterListVO.class);
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
	 * BSAManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * - 사용 프로그램 : ESM_BSA_0026
	 * 
	 * @param  SearchBsaConditionVO vo
	 * @return List<SearchSpcScPortDownDetailListVO>
	 * @throws DAOException
	 */ 
	@SuppressWarnings("unchecked")
	public List<SearchSpcScPortDownDetailListVO> searchSpcScPortDownDetailList(SearchBsaConditionVO vo) throws DAOException {
		log.debug("################# BSAManageDBDAO.searchSpcScPortDownDetailList() [SC] ############################[START]");
		DBRowSet dbRowset = null;
		List<SearchSpcScPortDownDetailListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(vo != null){
				Map<String, String> mapVO = vo .getColumnValues();
				param.putAll(mapVO);				
				velParam.putAll(mapVO);
		
			}	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BSAManageDBDAOSearchSpcScPortDownDetailListRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSpcScPortDownDetailListVO.class);
			log.debug("################# BSAManageDBDAO.searchSpcScPortDownDetailList() [SC] ############################[END]");
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
	 * BSAManage의 데이타 모델에 해당되는 값을 삭제한다.<br>
	 * - 사용 프로그램 : ESM_BSA_026
	 * 
	 * @param  SearchBsaConditionVO vo
	 * @throws DAOException 
	 */
	@SuppressWarnings("unchecked")
    public void removeSpcScPortDownDetail(SearchBsaConditionVO vo) throws DAOException {
		 int delCnt[] = null;
	        List deleteList = new ArrayList();
	        
	      //query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			
	        try{
	        	SQLExecuter sqlExe = new SQLExecuter("");
	        	if(vo != null){
	        		param.put("bsa_seq", vo.getMBsaSeq());
					param.put("bsa_op_cd", vo.getMBsaOpCd());
					param.put("bsa_op_jb_cd", vo.getMBsaOpJbCd());
					param.put("crr_cd", vo.getMCrrCd());
					param.put("trd_cd", vo.getMTrdCd());
					param.put("rlane_cd", vo.getMRlaneCd());
					param.put("dir_cd", vo.getMDirCd());
					param.put("vsl_seq", vo.getMVslSeq());
					param.put("vsl_capa", vo.getMVslCapa());
					
					deleteList.add(param);
					
				}
	            if(deleteList.size() > 0){
                delCnt = sqlExe.executeBatch((ISQLTemplate)new BSAManageDBDAORemoveSpcScPortDownDetailDSQL(), deleteList, null);
                for(int i = 0; i < delCnt.length; i++){
                    if(delCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to delete No"+ i + " SQL");
                }            	
            }            
        }catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
    }	

	/**
	 * BSAManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * - 사용 프로그램 : ESM_BSA_0026
	 * 
	 * @param SearchBsaConditionVO vo
	 * @param String updUsrId
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
    public void resetSpcScPortDown(SearchBsaConditionVO vo, String updUsrId) throws DAOException {
		/*	테이블 컬럼의  수정 값을 저장하는  List */
    	List updateList = new ArrayList();
    	int updCnt[] = null;
    	  
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(vo != null){
				param.put("upd_usr_id", updUsrId);
				param.put("bsa_op_cd", vo.getRdoopcd());
				param.put("bsa_op_jb_cd", vo.getRdotype());
				param.put("crr_cd", vo.getCobCarrier());
				param.put("trd_cd", vo.getCobtrade());
				param.put("rlane_cd", vo.getCoblane());
				param.put("dir_cd", vo.getCobdir());
				param.put("bsa_fm_dt", vo.getTxtsdate().replaceAll("-", ""));
				param.put("bsa_to_dt", vo.getTxtedate().replaceAll("-", ""));
				
				updateList.add(param);
				
				velParam.put("trd_cd", vo.getCobtrade());
				velParam.put("rlane_cd", vo.getCoblane());
				velParam.put("dir_cd", vo.getCobdir());
				velParam.put("bsa_fm_dt", vo.getTxtsdate().replaceAll("-", ""));
				velParam.put("bsa_to_dt", vo.getTxtedate().replaceAll("-", ""));
		
			}
			if(updateList.size() > 0){
            	updCnt = sqlExe.executeBatch((ISQLTemplate)new BSAManageDBDAOResetSpcScPortDownUSQL(),updateList, velParam);
                for(int i = 0; i < updCnt.length; i++){
                    if(updCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to update No"+ i + " SQL");
                }            	
            }           
        }catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
    }	

	/**
	 * BSAManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * - 사용 프로그램 : ESM_BSA_0026
	 * 
	 * @param  SearchBsaConditionVO vo
	 * @param  String usrId
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
    public void createSpcScPortDownDetail(SearchBsaConditionVO vo,String usrId) throws DAOException {
		 int insCnt[] = null;
	        List insertList = new ArrayList();
	    	  
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();

			try{
	        	SQLExecuter sqlExe = new SQLExecuter("");
	        	if(vo != null){
	        		param.put("bsa_seq", vo.getMBsaSeq());
					param.put("bsa_op_cd", vo.getMBsaOpCd());
					param.put("bsa_op_jb_cd", vo.getMBsaOpJbCd());
					param.put("crr_cd", vo.getMCrrCd());
					param.put("trd_cd", vo.getMTrdCd());
					param.put("rlane_cd", vo.getMRlaneCd());
					param.put("dir_cd", vo.getMDirCd());
					param.put("vsl_seq", vo.getMVslSeq());
					param.put("cre_usr_id", usrId);
					param.put("upd_usr_id", usrId);
					
					insertList.add(param);
					
				}
	            if(insertList.size() > 0){
                insCnt = sqlExe.executeBatch((ISQLTemplate)new BSAManageDBDAOCreateSpcScPortDownDetailCSQL(), insertList, null);
                for(int i = 0; i < insCnt.length; i++){
                    if(insCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No"+ i + " SQL");
                }            	
            }          
        }catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
    }	

	/**
	 * BSA_SLT_CHTR_CRR_CAPA의 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정, 삭제)<br>
	 * - 사용 프로그램 : ESM_BSA_0026
	 * 
	 * @param  List<BsaSltChtrCrrCapaVO> updmodels
	 * @return int[]
	 * @throws DAOException
	 */
    public int[] modifySCCrrCapa(List<BsaSltChtrCrrCapaVO> updmodels) throws DAOException {
        int updCnt[] = null;
		
        try{
        	SQLExecuter sqlExe = new SQLExecuter("");
            
            if(updmodels.size() > 0){
            	updCnt = sqlExe.executeBatch((ISQLTemplate)new BSAManageDBDAOModifySCCrrCapaUSQL(), updmodels, null);
                for(int i = 0; i < updCnt.length; i++){
                    if(updCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to update No"+ i + " SQL");
                }            	
            }          
        } catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return updCnt;
    }	

  	
	/**
	   * BSA_SLT_CHTR_PORT_DWN의 지정된 ibflag 값에 따라 DB에 반영한다.(추가)<br>
	   * - 사용 프로그램 : ESM_BSA_0026
	   *
	   * @param List<BsaSltChtrPortDwnVO> insModels
	   * @return int[]
	   * @throws DAOException
	   */
	
	public int[] addMultiBsaSltChtrPortDwn(List<BsaSltChtrPortDwnVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new BSAManageDBDAOAddMultiBsaSltChtrPortDwnCSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
	
	/**
	   * BSA_SLT_CHTR_PORT_DWN의 지정된 ibflag 값에 따라 DB에 반영한다.(수정)<br>
	   * - 사용 프로그램 : ESM_BSA_0026
	   *
	   * @param List<BsaSltChtrPortDwnVO> updModels
	   * @return int[]
	   * @throws DAOException
	   */
	
	public int[] modifyMultiBsaSltChtrPortDwn(List<BsaSltChtrPortDwnVO> updModels) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new BSAManageDBDAOModifyMultiBsaSltChtrPortDwnUSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return updCnt;
	}
	
	/**
	   * BSA_SLT_CHTR_PORT_DWN의 지정된 ibflag 값에 따라 DB에 반영한다.(삭제)<br>
	   * - 사용 프로그램 : ESM_BSA_0026
	   *
	   * @param List<BsaSltChtrPortDwnVO> delModels
	   * @return int[]
	   * @throws DAOException
	   */
	
	public int[] removeMultiBsaSltChtrPortDwn(List<BsaSltChtrPortDwnVO> delModels) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new BSAManageDBDAORemoveMultiBsaSltChtrPortDwnDSQL(), delModels,null);
				
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return delCnt;
	}
	
	/**
	 * PrototypeDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 *  - List 타입의 View Adapter용 조회
	 *  
	 * @param String bsaOpCd
	 * @return List<BsaCrrRgstVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BsaCrrRgstVO> searchCarrierItem(String bsaOpCd) throws DAOException {
		DBRowSet dbRowset  = new DBRowSet();

		List<BsaCrrRgstVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			
			if(bsaOpCd != null){
				param.put("bsa_op_cd",bsaOpCd);
				velParam.put("bsa_op_cd",bsaOpCd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BSAManageDBDAOSearchCarrierItemRSQL(), param, velParam);
			
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BsaCrrRgstVO .class);
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
     *  BSA_JNT_OP_BZC, BSA_JNT_OP_CRR_CAPA목록을 가져온다.<br>
     * 
     * @param SearchBsaConditionVO vo
     * @param String[] codeArr
     * @return CommonBsaRsVO
     * @throws DAOException
     */

	public CommonBsaRsVO searchSpcJoBSA(SearchBsaConditionVO vo, String[] codeArr) throws DAOException {
		DBRowSet dbRowset  = new DBRowSet();
		CommonBsaRsVO rsVo = new CommonBsaRsVO();
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			
			if(vo != null){
				Map<String, String> mapVO = vo .getColumnValues();
				param.putAll(mapVO);				
				velParam.putAll(mapVO);
				velParam.put("keysList",codeArr);
		
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BSAManageDBDAOSearchSpcJoBSARSQL(), param, velParam);
			rsVo.setDbRowset(dbRowset);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rsVo;
	}

    
	/**
     * BSA_JNT_OP_CRR_CAPA 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(수정)<br>
     *  - 관련 테이블은 SIM_INFO.<br>
     *
     * @param List<BsaJntOpCrrCapaVO> updModels
     * @param String bsaOpJbCd
     * @throws DAOException	
	 */    
    public void multiSpcJoBSA(List<BsaJntOpCrrCapaVO> updModels, String bsaOpJbCd) throws DAOException {
        int updCnt[] = null;
      //velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
        try{
        	SQLExecuter sqlExe = new SQLExecuter("");
            
            if(updModels.size() > 0){
            	
            	velParam.put("bsa_op_jb_cd",bsaOpJbCd );
            	
            	updCnt = sqlExe.executeBatch((ISQLTemplate)new BSAManageDBDAOMultiSpcJoBSAUSQL(), updModels, velParam);
                for(int i = 0; i < updCnt.length; i++){
                    if(updCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to update No"+ i + " SQL");
                }            	
            }            
        }catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
    }	

	/**
	 *  BSA, Weight Per TEU가 변경되었을때 TTL Weight의 값도 변경시켜준다. 1  <br>
	 *  BSA_JNT_OP_CRR_CAPA
	 * 
	 * @param List<BsaJntOpCrrCapaVO> updModels
	 * @throws DAOException
	 */	
    public void modifySpcJoTTLWeight1(List<BsaJntOpCrrCapaVO> updModels) throws DAOException {
        int updCnt[] = null;
		
        try{
        	SQLExecuter sqlExe = new SQLExecuter("");
            if(updModels.size() > 0){
            	updCnt = sqlExe.executeBatch((ISQLTemplate)new BSAManageDBDAOModifySpcJoTTLWeight1USQL(), updModels, null);
                for(int i = 0; i < updCnt.length; i++){
                    if(updCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to update No"+ i + " SQL");
                }            	
            }
        }catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
    }
	/**
	 *  BSA, Weight Per TEU가 변경되었을때 TTL Weight의 값도 변경시켜준다. 2  <br>
	 *  BSA_JNT_OP_CRR_CAPA
	 * 
	 * @param List<BsaJntOpCrrCapaVO> updModels
	 * @throws DAOException
	 */	    
    public void modifySpcJoTTLWeight2(List<BsaJntOpCrrCapaVO> updModels) throws DAOException {
        int updCnt[] = null;
		
        try{
        	SQLExecuter sqlExe = new SQLExecuter("");
            if(updModels.size() > 0){
            	updCnt = sqlExe.executeBatch((ISQLTemplate)new BSAManageDBDAOModifySpcJoTTLWeight2USQL(), updModels, null);
                for(int i = 0; i < updCnt.length; i++){
                    if(updCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to update No"+ i + " SQL");
                }            	
            }           
        }catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
    }    
	
	/**
	 *  BSA, TTL Weight 탭의 값이 변경되면 Weight Per TEU값도 재계산하여 업데이트 한다.<br>
	 *  BSA_JNT_OP_CRR_CAPA
	 *  
	 * @param List<BsaJntOpCrrCapaVO>  updModels
	 * @throws DAOException
	 */
    public void modifySpcJoWeightPerTEU(List<BsaJntOpCrrCapaVO> updModels) throws DAOException {
        int updCnt[] = null;
		
        try{
        	SQLExecuter sqlExe = new SQLExecuter("");
            if(updModels.size() > 0){
            	updCnt = sqlExe.executeBatch((ISQLTemplate)new BSAManageDBDAOModifySpcJoWeightPerTEUUSQL(), updModels, null);
                for(int i = 0; i < updCnt.length; i++){
                    if(updCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to update No"+ i + " SQL");
                }            	
            }           
        }catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
    }	
	
	/**
	 *  TTL Weight 탭의 Own Vessel Weight값을 BSA_JNT_OP_BZC 테이블에 업데이트 한다.<br>
	 *  BSA_JNT_OP_CRR_CAPA
	 *  
	 * @param List<BsaJntOpBzcVO> updModels
	 * @throws DAOException
	 */
    public void modifySpcJoOwnVslWeight(List<BsaJntOpBzcVO> updModels) throws DAOException {
        int updCnt[] = null;
		
        try{
        	SQLExecuter sqlExe = new SQLExecuter("");
            if(updModels.size() > 0){
            	updCnt = sqlExe.executeBatch((ISQLTemplate)new BSAManageDBDAOModifySpcJoOwnVslWeightUSQL(), updModels, null);
                for(int i = 0; i < updCnt.length; i++){
                    if(updCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to update No"+ i + " SQL");
                }            	
            }           
        }catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
    }	

	/**
	 *  BSA[007]이면 Solt Swap정보를 가지고 계산된 값을 spc_ctrl_slt_capa에 적용한다.  <br>
	 *  화면에서 선택한 모든 정보에 일괄적용한다.
	 *  BSA_JNT_OP_CRR_CAPA
	 * 
	 * @param List<BsaJntOpCrrCapaVO>  updModels
	 * @throws DAOException
	 */
	public void modifySpcJoSwapCapa(List<BsaJntOpCrrCapaVO>  updModels) throws DAOException,Exception {
        int updCnt[] = null;
        
        try{
        	SQLExecuter sqlExe = new SQLExecuter("");
            if(updModels.size() > 0){
            	updCnt = sqlExe.executeBatch((ISQLTemplate)new BSAManageDBDAOModifySpcJoSwapCapaUSQL(),updModels, null);
                for(int i = 0; i < updCnt.length; i++){
                    if(updCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to update No"+ i + " SQL");
                }            	
            }
                       
        }catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
    }	
	
	/**
	 *  BSA가 변경되었을때 BSA_JNT_OP_PORT_DWN의 값도 변경시켜준다.  <br>
	 *  BSA_JNT_OP_PORT_DWN
	 * 
	 * @param List<BsaJntOpPortDwnVO> updModels
	 * @throws DAOException
	 */
    public void modifySpcJoPortDwn(List<BsaJntOpPortDwnVO> updModels) throws DAOException {
        int updCnt[] = null;
		
        try{
        	SQLExecuter sqlExe = new SQLExecuter("");
            if(updModels.size() > 0){
            	updCnt = sqlExe.executeBatch((ISQLTemplate)new BSAManageDBDAOModifySpcJoPortDwnUSQL(), updModels, null);
                for(int i = 0; i < updCnt.length; i++){
                    if(updCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to update No"+ i + " SQL");
                }            	
            }           
        }catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
    }	

    /**
     *  BSA_SPC_CTRL_SWAP 목록을 가져온다.<br>
     * 
     * @param SearchBsaConditionVO VO
     * @return List<SearchChgSlotSwapListVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
	public List<SearchChgSlotSwapListVO> searchChgSlotSwapList(SearchBsaConditionVO VO) throws DAOException {
    	DBRowSet dbRowset = null;
		List<SearchChgSlotSwapListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			
			if(VO != null){
				Map<String, String> mapVO = VO .getColumnValues();
				param.putAll(mapVO);				
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BSAManageDBDAOSearchChgSlotSwapListRSQL(), param, velParam);
			
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchChgSlotSwapListVO .class);
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
	 *  BSA_SPC_CTRL_SWAP 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(수정)<br>
	 * 
	 * @param List<BsaSpcCtrlSwapVO> insModels
	 * @return int[]
	 * @throws DAOException
	 */
 	public int[] addmultiChgSlotSwap(List<BsaSpcCtrlSwapVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new BSAManageDBDAOAddmultiChgSlotSwapCSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
 	
 	/**
	 *  BSA_SPC_CTRL_SWAP 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(수정)<br>
	 * 
	 * @param List<BsaSpcCtrlSwapVO> delModels
	 * @return int[]
	 * @throws DAOException
	 */
 	public int[] removemultiChgSlotSwap(List<BsaSpcCtrlSwapVO> delModels) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new BSAManageDBDAORemovemultiChgSlotSwapDSQL(), delModels,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return delCnt;
	}
 	
 	/**
	 *  BSA_SPC_CTRL_SWAP 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(수정)<br>
	 * 
	 * @param List<BsaSpcCtrlSwapVO> updModels
	 * @return int[]
	 * @throws DAOException
	 */
 	public int[] modifyemultiChgSlotSwap(List<BsaSpcCtrlSwapVO> updModels) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new BSAManageDBDAOModifyemultiChgSlotSwapUSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return updCnt;
	}

    /**
     *  목록을 가져온다.<br>
     * 
     * @param SearchBsaConditionVO vo
     * @param String[] codeArr
     * @return CommonBsaRsVO
     * @throws DAOException
     */

	public CommonBsaRsVO searchSpcScBSA(SearchBsaConditionVO vo, String[] codeArr) throws DAOException {
		DBRowSet dbRowset  = new DBRowSet();
		CommonBsaRsVO rsVo = new CommonBsaRsVO();
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			
			if(vo != null){
				Map<String, String> mapVO = vo .getColumnValues();
				param.putAll(mapVO);				
				velParam.putAll(mapVO);
				velParam.put("keysList",codeArr);
		
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BSAManageDBDAOSearchSpcScBSARSQL(), param, velParam);
			rsVo.setDbRowset(dbRowset);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rsVo;
	}
	
    /**
	 * BSA_SLT_CHTR_CRR_CAPA 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(수정)<br>
	 * 
	 * @param List<BsaSltChtrCrrCapaVO> updModels 
	 * @throws DAOException
	 */
    public void multiSpcScBSA(List<BsaSltChtrCrrCapaVO> updModels) throws DAOException {
        int updCnt[] = null;
        try{
        	SQLExecuter sqlExe = new SQLExecuter("");
            if(updModels.size() > 0){            	
            	updCnt = sqlExe.executeBatch((ISQLTemplate)new BSAManageDBDAOMultiSpcScBSAUSQL(), updModels, null);
                for(int i = 0; i < updCnt.length; i++){
                    if(updCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to update No"+ i + " SQL");
                }            	
            }           
        }catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
    }	

    /**
	 * BSA_SLT_CHTR_CRR_CAPA 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(수정)<br>
	 * BSA(007) or Weight Per TEU(008)일경우 BSA_SLT_CHTR_CRR_CAPA테이블에 TTL Weight(009)를 Update한다.
	 * 
	 * @param List<BsaSltChtrCrrCapaVO> updModels
	 * @throws DAOException
	 */
    public void modifySpcScTTLWeight(List<BsaSltChtrCrrCapaVO> updModels) throws DAOException {
    	log.debug("############ BSAManageDBDAO.modifySpcScTTLWeight() #################### [START]");
        int updCnt[] = null;
		
        try{
        	SQLExecuter sqlExe = new SQLExecuter("");
            if(updModels.size() > 0){
            	updCnt = sqlExe.executeBatch((ISQLTemplate)new BSAManageDBDAOModifySpcScTTLWeightUSQL(), updModels, null);
                for(int i = 0; i < updCnt.length; i++){
                    if(updCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to update No"+ i + " SQL");
                }            	
            }           
        }catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        log.debug("############ BSAManageDBDAO.modifySpcScTTLWeight() #################### [END]");
    }
    
	
	/**
	 * BSA_SLT_CHTR_CRR_CAPA 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(수정)<br>
	 * TTL Weight가 변경되었을때 Weight Per TEU의 값을 변경시켜준다.
	 * 
	 * @param List<BsaSltChtrCrrCapaVO> updModels
	 * @throws DAOException
	 */
    public void modifySpcScWeightPerTEU(List<BsaSltChtrCrrCapaVO> updModels) throws DAOException {
    	log.debug("############ BSAManageDBDAO.modifySpcScWeightPerTEU() #################### [START]");
        int updCnt[] = null;
		
        try{
        	SQLExecuter sqlExe = new SQLExecuter("");
            if(updModels.size() > 0){
            	updCnt = sqlExe.executeBatch((ISQLTemplate)new BSAManageDBDAOModifySpcScWeightPerTEUUSQL(), updModels, null);
                for(int i = 0; i < updCnt.length; i++){
                    if(updCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to update No"+ i + " SQL");
                }            	
            }           
        }catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        log.debug("############ BSAManageDBDAO.modifySpcScWeightPerTEU() #################### [END]");
    }	    

    /**
	 * BSA_SLT_CHTR_CRR_CAPA 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(수정)<br>
	 * BSA(007)일 경우 BSA_SLT_CHTR_PORT_DWN테이블에 Carrier정보를 Update한다.
	 * 
	 * @param List<BsaSltChtrPortDwnVO> updModels
	 * @return int[]
	 * @throws DAOException
	 */
    public int[] modifySpcScPortDwn(List<BsaSltChtrPortDwnVO> updModels) throws DAOException {
        int updCnt[] = null;
		
        try{
        	SQLExecuter sqlExe = new SQLExecuter("");
            if(updModels.size() > 0){
            	updCnt = sqlExe.executeBatch((ISQLTemplate)new BSAManageDBDAOModifySpcScPortDwnUSQL(), updModels, null);
                for(int i = 0; i < updCnt.length; i++){
                    if(updCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to update No"+ i + " SQL");
                }            	
            }            
        }catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return updCnt;
    }	

	/**
	 * BSAManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 사용 프로그램 : ESM_BSA_0120
	 * @return List<BsaCrrInfoVO> 
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BsaCrrInfoVO> searchCarrierInfoList() throws DAOException {
		DBRowSet dbRowset = null;
		List<BsaCrrInfoVO> list = null;

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BSAManageDBDAOSearchCarrierInfoListRSQL(), null, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BsaCrrInfoVO .class);
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
	 * BSA_CRR_INFO의 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정)<br>
	 * 사용 프로그램 : ESM_BSA_0120
	 * 
	 * @param List<BsaCrrInfoVO> insModels
	 * @return int[]
	 * @throws DAOException
	 */
	
	public int[] addMultiBsaCrrInfo(List<BsaCrrInfoVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new BSAManageDBDAOMultiBsaCrrInfoCSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
	
	/**
	 * BSA_CRR_INFO의 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정)<br>
	 * 사용 프로그램 : ESM_BSA_0120
	 * 
	 * @param List<BsaCrrRgstVO> insModels
	 * @return int[]
	 * @throws DAOException
	 */
	
	public int[] addMultiBsaCrrRgst(List<BsaCrrRgstVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new BSAManageDBDAOMultiBsaCrrRgstCSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
	
	/**
	 * BSA_CRR_INFO의 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정)<br>
	 * 사용 프로그램 : ESM_BSA_0120
	 * 
	 * @param List<BsaCrrInfoVO> updModels
	 * @return int[]
	 * @throws DAOException
	 */
	public int[] modifyMultiBsaCrrInfo(List<BsaCrrInfoVO> updModels) throws DAOException,Exception {
		int updCnt[] = null; 
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new BSAManageDBDAOMultiBsaCrrInfoUSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return updCnt;
	}

		/**
		 * BSAManage의 데이타 모델에 해당되는 값을 불러온다.<br>
		 * 
		 * @return CommonBsaRsVO
		 * @throws DAOException
		 */
		public CommonBsaRsVO searchBsaCrrRgstList() throws DAOException {

			DBRowSet dbRowset = new DBRowSet();
			CommonBsaRsVO rsVo = new CommonBsaRsVO();

			try{
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BSAManageDBDAOSearchBsaCrrRgstListRSQL(), null, null);
				rsVo.setDbRowset(dbRowset);
				
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return rsVo;
		}

	/**
	 * BSAManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * - 사용 프로그램 : ESM_BSA_0028
	 * 
	 * @param SearchSlotCostConditionVO searchSlotCostConditionVO
	 * @param List<SearchBsaCrrRgstListVO> codeArr
	 * @return CommonBsaRsVO
	 * @throws DAOException
	 */
	public CommonBsaRsVO searchSlotCostList(SearchBsaConditionVO searchSlotCostConditionVO,List<SearchBsaCrrRgstListVO> codeArr) throws DAOException {
		DBRowSet dbRowset  = new DBRowSet();

//		List<SearchSlotCostListVO> list = null;
		CommonBsaRsVO rsVo = new CommonBsaRsVO();
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			
			if(searchSlotCostConditionVO != null){
				Map<String, String> mapVO = searchSlotCostConditionVO .getColumnValues();
				param.putAll(mapVO);				
				velParam.putAll(mapVO);
				velParam.put("keyList",codeArr);
		
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BSAManageDBDAOSearchSlotCostListRSQL(), param, velParam);
			rsVo.setDbRowset(dbRowset);
			
//			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSlotCostListVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rsVo;
	}

	
	/**
	 * BSAManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * - 사용 프로그램 : ESM_BSA_0028
	 * 
	 * @param SearchBsaConditionVO searchSlotCostConditionVO
	 * @param String[] codeArr
	 * @return CommonBsaRsVO
	 * @throws DAOException
	 */
	public CommonBsaRsVO searchRFCostList(SearchBsaConditionVO searchSlotCostConditionVO,String[] codeArr) throws DAOException {
		DBRowSet dbRowset  = new DBRowSet();

//		List<SearchSlotCostListVO> list = null;
		CommonBsaRsVO rsVo = new CommonBsaRsVO();
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			
			if(searchSlotCostConditionVO != null){
				Map<String, String> mapVO = searchSlotCostConditionVO .getColumnValues();
				param.putAll(mapVO);				
				velParam.putAll(mapVO);
				velParam.put("keyList",codeArr);
		
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BSAManageDBDAOSearchRFCostListRSQL(), param, velParam);
			rsVo.setDbRowset(dbRowset);
		
			
//			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSlotCostListVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rsVo;
			
	}

	
	/**
	 * BSAManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * - 사용 프로그램 : ESM_BSA_028
	 * 
	 * @param SearchBsaConditionVO searchSlotCostConditionVO
	 * @param String[] codeArr
	 * @return CommonBsaRsVO
	 * @throws DAOException
	 */
	public CommonBsaRsVO searchOverCostList(SearchBsaConditionVO searchSlotCostConditionVO,String[] codeArr) throws DAOException {
		DBRowSet dbRowset  = new DBRowSet();

//		List<SearchSlotCostListVO> list = null;
		CommonBsaRsVO rsVo = new CommonBsaRsVO();
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			
			if(searchSlotCostConditionVO != null){
				Map<String, String> mapVO = searchSlotCostConditionVO .getColumnValues();
				param.putAll(mapVO);				
				velParam.putAll(mapVO);
				velParam.put("keyList",codeArr);
		
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BSAManageDBDAOSearchOverCostListRSQL(), param, velParam);
			rsVo.setDbRowset(dbRowset);
		
			
//			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSlotCostListVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rsVo;
			
	}
	
	/**
	 * BSA_SLT_PRC의 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정)<br>
	 * - 사용 프로그램 : ESM_BSA_0028
	 * 
	 * @param List<BsaManageSltPrcSaveVO> models 
	 * @return int[]
	 * @throws DAOException
	 */
	public int[] multiBsaSltPrc(List<BsaManageSltPrcSaveVO> models ) throws DAOException,Exception {
		int insCnt[] = null; 
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(models.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new BSAManageDBDAOMultiBsaSltPrcCSQL(), models,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}

	/**
	 * BSA_SLT_PRC_CRR의 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정, 삭제)<br>
	 * - 사용 프로그램 : ESM_BSA_0028
	 * 
	 * @param List<BsaManageSltPrcSaveVO> models
	 * @return int[]
	 * @throws DAOException
	 */
	public int[] multiBsaSltPrcCrr(List<BsaManageSltPrcSaveVO> models) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(models.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new BSAManageDBDAOMultiBsaSltPrcCrrCSQL(), models,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
	
	/**
	 * BSA_SLT_PRC_CRR의 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정, 삭제)<br>
	 * - 사용 프로그램 : ESM_BSA_0028
	 * 
	 * @param List<BsaManageSltPrcSaveVO> models
	 * @return int[]
	 * @throws DAOException
	 */
	public int[] removeBsaSltPrc(List<BsaManageSltPrcSaveVO> models) throws DAOException,Exception {
		int delCnt[] = null; 
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(models.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new BSAManageDBDAORemoveSlotCostList1DDSQL(), models, null);
				delCnt = sqlExe.executeBatch((ISQLTemplate)new BSAManageDBDAORemoveSlotCostList2DDSQL(), models, null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return delCnt;	
	}

	/**
	 * BSA_SLT_PRC의 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정)<br>
	 * - 사용 프로그램 : ESM_BSA_0028
	 * 
	 * @param List<BsaManageSltPrcSaveVO> models
	 * @return int[]
	 * @throws DAOException
	 */
	public int[] multiRFCost(List<BsaManageSltPrcSaveVO> models  ) throws DAOException,Exception {
		int insCnt[]=null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(models.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new BSAManageDBDAOMultiRFCostCSQL(), models,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
	
	/**
	 * BSA_SLT_PRC의 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정)<br>
	 * - 사용 프로그램 : ESM_BSA_0028
	 * 
	 * @param List<BsaManageSltPrcSaveVO> models 
	 * @return int[]
	 * @throws DAOException
	 */
	public int[] multiOverCost(List<BsaManageSltPrcSaveVO> models  ) throws DAOException,Exception {
		int insCnt[]=null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(models.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new BSAManageDBDAOMultiOverostCSQL(), models,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
	
	/**
	 * BSAManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * - 사용 프로그램 : ESM_BSA_0162
	 * 
	 * @param SearchBsaConditionVO searchBsaConditionVO
	 * @param List<SearchBsaCrrRgstListVO> codeArr
	 * @return CommonBsaRsVO
	 * @throws DAOException
	 */
	public CommonBsaRsVO searchOverUsedSlotCostList(SearchBsaConditionVO searchBsaConditionVO,List<SearchBsaCrrRgstListVO> codeArr) throws DAOException {
		DBRowSet dbRowset  = new DBRowSet();
		CommonBsaRsVO rsVo = new CommonBsaRsVO();
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			
			if(searchBsaConditionVO != null){
				Map<String, String> mapVO = searchBsaConditionVO .getColumnValues();
				param.putAll(mapVO);				
				velParam.putAll(mapVO);
				velParam.put("keyList",codeArr);
		
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BSAManageDBDAOSearchOverUsedSlotCostListRSQL(), param, velParam);
			rsVo.setDbRowset(dbRowset);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rsVo;
	}
	
	/**
	 * ESM_0162의 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정)<br>
	 * - 사용 프로그램 : ESM_BSA_0162
	 * 
	 * @param List<BsaOverUsedSlotCostSaveVO> models
	 * @return int[]
	 * @throws DAOException
	 */
	public int[] multiOverUsedSlotCost(List<BsaOverUsedSlotCostSaveVO> models  ) throws DAOException,Exception {
			int insCnt[]=null;
			try {
				SQLExecuter sqlExe = new SQLExecuter("");
				if(models.size() > 0){
					insCnt = sqlExe.executeBatch((ISQLTemplate)new BSAManageDBDAOMultiOverUsedSlotCostCSQL(), models,null);
					for(int i = 0; i < insCnt.length; i++){
						if(insCnt[i]== Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to insert No"+ i + " SQL");
					}
				}
				
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return insCnt;
		}

	/**
	 * BSAManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * - 사용 프로그램 : ESM_BSA_0172
	 * 
	 * @param SearchBsaConditionVO searchBsaConditionVO
	 * @param String[] codeArr
	 * @return CommonBsaRsVO
	 * @throws DAOException
	 */
	public CommonBsaRsVO searchBSARateList(SearchBsaConditionVO searchBsaConditionVO,String[] codeArr) throws DAOException {
		DBRowSet dbRowset  = new DBRowSet();
		CommonBsaRsVO rsVo = new CommonBsaRsVO();
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			
			if(searchBsaConditionVO != null){
				Map<String, String> mapVO = searchBsaConditionVO .getColumnValues();
				param.putAll(mapVO);				
				velParam.putAll(mapVO);
				velParam.put("keyList",codeArr);
		
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BSAManageDBDAOSearchBSARateListRSQL(), param, velParam);
			rsVo.setDbRowset(dbRowset);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rsVo;
	}

	
	/**
	 * BSA_SLT_PRC의 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정)<br>
	 * - 사용 프로그램 : ESM_BSA_0172
	 * 
	 * @param List<BsaHighCubicRateSaveVO> models
	 * @return int[]
	 * @throws DAOException
	 */
	public int[] multiBSARate(List<BsaHighCubicRateSaveVO> models  ) throws DAOException,Exception {
		int insCnt[]=null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(models.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new BSAManageDBDAOMultiBSARateCSQL(), models,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
	
	/**
	 * BSAManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * - 사용 프로그램 : ESM_BSA_0035 (JOINT OPERATING)
	 *
	 * @param SearchBsaConditionVO vo
	 * @return List<SearchOverlappedContractInquiryListVO>
	 * @throws DAOException
	 */
	public List<SearchOverlappedContractInquiryListVO> searchOverlappedContractInquiryJOList(SearchBsaConditionVO vo) throws DAOException {
		log.debug("################# BSAManageDBDAO.searchOverlappedContractInquiryJOList() ############################[START]");
		DBRowSet dbRowset = null;
		List<SearchOverlappedContractInquiryListVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			
			if(vo != null){
				Map<String, String> mapVO = vo .getColumnValues();
				param.putAll(mapVO);				
		
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BSAManageDBDAOSearchOverlappedContractInquiryJOListRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchOverlappedContractInquiryListVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		log.debug("################# BSAManageDBDAO.searchOverlappedContractInquiryJOList() ############################[END]");
		return list;
	}
	
	/**
	 * BSAManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * - 사용 프로그램 : ESM_BSA_0035 (SPACE CHARTERING)
	 *
	 * @param SearchBsaConditionVO vo
	 * @return List<SearchOverlappedContractCheckListVO>
	 * @throws DAOException
	 */
	public List<SearchOverlappedContractInquiryListVO> searchOverlappedContractInquirySCList(SearchBsaConditionVO vo) throws DAOException {
		log.debug("################# BSAManageDBDAO.searchOverlappedContractInquirySCList() ############################[START]");
		DBRowSet dbRowset = null;
		List<SearchOverlappedContractInquiryListVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			
			if(vo != null){
				Map<String, String> mapVO = vo .getColumnValues();
				param.putAll(mapVO);				
		
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BSAManageDBDAOSearchOverlappedContractInquirySCListRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchOverlappedContractInquiryListVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		log.debug("################# BSAManageDBDAO.searchOverlappedContractInquirySCList() ############################[END]");
		return list;
	}
	
	/**
	 * BSAManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * - 사용 프로그램 : ESM_BSA_0035 (SLOT PRICE
	 *
	 * @param SearchBsaConditionVO vo
	 * @return List<SearchOverlappedContractInquiryListVO>
	 * @throws DAOException
	 */
	public List<SearchOverlappedContractInquiryListVO> searchOverlappedContractInquirySPList(SearchBsaConditionVO vo) throws DAOException {
		log.debug("################# BSAManageDBDAO.searchOverlappedContractInquirySPList() ############################[START]");
		DBRowSet dbRowset = null;
		List<SearchOverlappedContractInquiryListVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			
			if(vo != null){
				Map<String, String> mapVO = vo .getColumnValues();
				param.putAll(mapVO);				
		
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BSAManageDBDAOSearchOverlappedContractInquirySPListRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchOverlappedContractInquiryListVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		log.debug("################# BSAManageDBDAO.searchOverlappedContractInquirySPList() ############################[END]");
		return list;
	}

}