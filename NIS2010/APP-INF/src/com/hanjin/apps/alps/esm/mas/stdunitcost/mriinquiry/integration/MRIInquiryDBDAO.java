/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName       : MRIInquiryDBDAO.java
*@FileTitle      : MRI 운임수입 단가 생성
*Open Issues     :
*Change history  :
*@LastModifyDate : 2009-09-17
*@LastModifier   : PEJ
*@LastVersion    : 1.3
* 2008-04-30 PEJ
* 1.0 최초 생성
* ========================================================
* 2008.05.26 PEJ N200805260007 MAS_Misc OP Rev 반영 관련
*                Rlane/Bound 별로 가지고 있던 단가를 Trade/Bound 레벨까지 관리하면서 화면단도 수정
* 2009.06.01 박은주 CSR No.R200905280002 품질검토결과 수정사항 반영
* 2009.06.25 박은주 CSR No.N200906230048 IMU노선 처리   
* 2009.09.17 장영석  New Framework 적용 [0152]      
* 2010.02.05 임옥영 품질검토 결과 반영
=========================================================*/
package com.hanjin.apps.alps.esm.mas.stdunitcost.mriinquiry.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.mriinquiry.vo.SearchMRIInquiryListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.MasMonMiscRevPreTeuVO;

/**
 * ENIS-MAS에 대한 DB 처리를 담당<br>
 * - ENIS-MAS Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author IM OKYOUNG
 * @see eqholdingBCImpl 참조
 * @since J2EE 1.4
 */
public class MRIInquiryDBDAO extends DBDAOSupport {

	/**
	 * 조회 이벤트 처리<br>
	 * ESM_MAS_0152 화면 대한 조회 이벤트 처리<br>
	 * 
	 * @param SearchMRIInquiryListVO searchMRIInquiryListVO
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchMRIInquiryListVO>
	 * @throws DAOException
	 */
	public List<SearchMRIInquiryListVO> searchMRIInquiryList(SearchMRIInquiryListVO searchMRIInquiryListVO 
															,SearchConditionVO searchConditionVO) throws DAOException {
		 DBRowSet dbRowset = null;
		List<SearchMRIInquiryListVO> list = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MRIInquiryDBDAOSearchMRIInquiryListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMRIInquiryListVO .class);
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
	 * 멀티 이벤트 처리<br>
	 * ESM_MAS_152 화면에 대한 멀티 이벤트 처리(INSERT)<br>
	 * 
	 * @param List<MasMonMiscRevPreTeuVO> masMonMiscRevPreTeuVO
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addMasMonMiscRevPreTeu(List<MasMonMiscRevPreTeuVO> masMonMiscRevPreTeuVO) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(masMonMiscRevPreTeuVO .size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new MRIInquiryDBDAOMasMonMiscRevPreTeuVOCSQL(), masMonMiscRevPreTeuVO,null);
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
	 * 멀티 이벤트 처리<br>
	 * ESM_MAS_152 화면에 대한 멀티 이벤트 처리(UPDATE)<br>
	 * 
	 * @param updModels List<MasMonMiscRevPreTeuVO>
	 * @param searchConditionVO SearchConditionVO
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifyMasMonMiscRevPreTeu(List<MasMonMiscRevPreTeuVO> updModels, SearchConditionVO searchConditionVO) throws DAOException,Exception {
		int updCnt[] = null;
		
		//valocity parameter 받아오기
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(searchConditionVO != null){
				Map<String, String> mapVO = searchConditionVO .getColumnValues();
				
				velParam.putAll(mapVO);
			}
				
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updModels .size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new MRIInquiryDBDAOMasMonMiscRevPreTeuVOUSQL(), updModels,velParam);
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
     * 멀티 이벤트 처리<br>
     * ESM_MAS_152 화면에 대한 멀티 이벤트 처리(DELETE)<br>
     * 
     * @param updModels List<MasMonMiscRevPreTeuVO>
     * @param searchConditionVO SearchConditionVO
     * @return int[]
     * @throws DAOException
     * @throws Exception
     */
    public int[] removeMasMonMiscRevPreTeu(List<MasMonMiscRevPreTeuVO> updModels, SearchConditionVO searchConditionVO) throws DAOException,Exception {
        int updCnt[] = null;
        
        //valocity parameter 받아오기
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        try {
            if(searchConditionVO != null){
                Map<String, String> mapVO = searchConditionVO .getColumnValues();
                
                velParam.putAll(mapVO);
            }
                
            SQLExecuter sqlExe = new SQLExecuter("");
            if(updModels .size() > 0){
                updCnt = sqlExe.executeBatch((ISQLTemplate)new MRIInquiryDBDAOMasMonMiscRevPreTeuVODSQL(), updModels,velParam);
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
     * Daily Hire FMS 테이블을 전월 copy 한다.
     *
     * @param HashMap<String, String> map
     * @throws DAOException
     */
    public void addMRIInquiryMonthCopy(HashMap<String, String> param) throws DAOException {

        int saveCnt = 0;
        try{
        
            saveCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new MRIInquiryDBDAOMultiMRIInquiryMonthCopyCSQL(), param, null);
            
            if(saveCnt == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to insert No SQL");

        } catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }

    }
    

    /**
     * [처리대상] 정보를 [행위] 합니다.<br>
     * 
     * @param SearchConditionVO conditionVO
     * @return List<MRIInquiryVO>
     * @throws DAOException
     */
    public Integer searchMRIInquiryMonthCount(SearchConditionVO conditionVO) throws DAOException {
        DBRowSet dbRowset = null;
        int cnt = 0;
//query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            if(conditionVO != null){
                Map<String, String> mapVO = conditionVO .getColumnValues();
            
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MRIInquiryDBDAOSearchMRIInquiryMonthCountRSQL(), param, velParam);
            
            if (dbRowset.next()) {
                cnt = dbRowset.getInt(1);
            }
        } catch(SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch(Exception ex) {
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return cnt;
    }
    

    /**
     * [처리대상] 정보를 [행위] 합니다.<br>
     * 
     * @param List<MRIInquiryVO> MRIInquiryVO
     * @return int[]
     * @throws DAOException
     * @throws Exception
     */
    public void removeMRIInquiryMonth(HashMap<String, String> param) throws DAOException,Exception {
         try {
             new SQLExecuter("").executeUpdate((ISQLTemplate)new MRIInquiryDBDAOMultiMRIInquiryMonthDSQL(), param, null);

        } catch(SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch(Exception ex) {
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
     }  
    
    /**
     * [Domestic Saving Credit 의 생성] 정보를 [복사] 합니다.<br>
     * 
     * @param HashMap<String, String> map
     * @return int
     * @throws DAOException
     * @throws Exception
     */
    public int addMRIInquiryStatusMonthCopy(HashMap<String, String> map) throws DAOException,Exception {
        
        int result = 0;
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate((ISQLTemplate)new MRIInquiryDBDAOMultiMRIInquiryCreationStatusUSQL(), map, null);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to modify SQL");
            
        } catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }
    

}