/*=========================================================
*Copyright(c) 2006 CyberLogitec
 *@FileName : SalesRPTDBDAO.java
 *@FileTitle : SalesRPTDBDAO
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier :
 *@LastVersion : 1.0
 * 2006-11-09 Sangwook_nam
 * 1.0 최초 생성
 * =========================================================
 * History
 =========================================================*/
package com.clt.apps.opus.esm.coa.multidimensionrpt.salesrpt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.coa.common.vo.CommonCoaRsVO;
import com.clt.apps.opus.esm.coa.common.vo.SearchConditionVO;
import com.clt.apps.opus.esm.coa.multidimensionrpt.salesrpt.basic.SalesRPTBCImpl;
import com.clt.apps.opus.esm.coa.multidimensionrpt.salesrpt.vo.BkgRpt0061VO;
import com.clt.apps.opus.esm.coa.multidimensionrpt.salesrpt.vo.MultiSetForm059SeqVO;
import com.clt.apps.opus.esm.coa.multidimensionrpt.salesrpt.vo.SalesOffiRepoConditionVO;
import com.clt.apps.opus.esm.coa.multidimensionrpt.salesrpt.vo.SalesRPTCommonVO;
import com.clt.apps.opus.esm.coa.multidimensionrpt.salesrpt.vo.SearchBkgRmk0170ListVO;
import com.clt.apps.opus.esm.coa.multidimensionrpt.salesrpt.vo.SearchMonthlyAvgConditionVO;
import com.clt.apps.opus.esm.coa.multidimensionrpt.salesrpt.vo.SearchRptItemVO;
import com.clt.apps.opus.esm.coa.multidimensionrpt.salesrpt.vo.SearchSetForm059List2VO;
import com.clt.apps.opus.esm.coa.multidimensionrpt.salesrpt.vo.SearchSetForm059ListVO;
import com.clt.apps.opus.esm.coa.multidimensionrpt.salesrpt.vo.ShipperVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter; 
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.apps.opus.esm.coa.multidimensionrpt.salesrpt.integration.SalesRPTDBDAOSearchBkgInfoRSQL;
import com.clt.apps.opus.esm.coa.multidimensionrpt.salesrpt.integration.SalesRPTDBDAOSearchBkgLoadRevRSQL;


/**
 * OPUS SalesRPTDBDAO <br>
 * - OPUS-MultiDimensionRPT system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author NAMKOONG Jin Ho
 * @see SalesRPTBCImpl 참조
 * @since J2EE 1.6
 */
public class SalesRPTDBDAO extends DBDAOSupport { 
	
	
	/**
	 * 데이타 모델에 해당되는 값을 불러온다.<br>
	 * - 사용 프로그램 : ESM_COA_0035
	 *
	 * @param  SalesOffiRepoConditionVO vo
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchCntrTpSzList(SalesOffiRepoConditionVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		
		try{			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SalesRPTDBDAOSearchCntrTpSzListRSQL(), param, velParam);
			
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
	 * 데이타 모델에 해당되는 값을 불러온다.(Account 조회)<br>
	 * - 사용 프로그램 : ESM_COA_0035
	 *
	 * @param SalesOffiRepoConditionVO vo
	 * @param List<String> cols
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchInqSrcDtAcct0035List(SalesOffiRepoConditionVO vo, List<String> cols) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
				
		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);					
				
				velParam.put("allcols", cols); // 가변컬럼				
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SalesRPTDBDAOSearchInqSrcDtAcct0035ListRSQL(), param, velParam);
			
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
	 * 데이타 모델에 해당되는 값을 불러온다.(Type Size 조회)<br>
	 * - 사용 프로그램 : ESM_COA_0035
	 *
	 * @param SalesOffiRepoConditionVO vo
	 * @param List<String> cols
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchInqSrcDtTpsz0035List(SalesOffiRepoConditionVO vo, List<String> cols) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
				
		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();				
				param.putAll(mapVO);
				velParam.putAll(mapVO);		
				
				//header 변수 세팅				
				velParam.put("allcols", cols);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SalesRPTDBDAOSearchInqSrcDtTpsz0035ListRSQL(), param, velParam);
			
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
		 * searchBkgRemarkList 조회<br>
		 * 
		 * @param SearchConditionVO vo
		 * @return List<SearchBkgRmk0170ListVO>
		 * @throws DAOException
		 */
		public List<SearchBkgRmk0170ListVO> searchBkgRemarkList(SearchConditionVO vo) throws DAOException {
			DBRowSet dbRowset = null;
			List<SearchBkgRmk0170ListVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(vo != null){
					Map<String, String> mapVO = vo.getColumnValues();
					mapVO.put("f_epp_tp_cd", vo.getFTypeCd());				//SJH.20141016.ADD
					
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SalesRPTDBDDAOSearchBkgRmk0170ListRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchBkgRmk0170ListVO .class);
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
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return List<BkgRpt0061VO>
	 * @throws DAOException
	 */
	public List<BkgRpt0061VO> searchBKG0061List(SearchConditionVO searchConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgRpt0061VO> list = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SalesRPTDBDAOsearchBkg0061ListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgRpt0061VO .class);
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
	 * Inquiry By BKG 레포트의 두번째  SHEET 내용 조회<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @param String pHeader
	 * @return CommonCoaRsVO
	 * @throws DAOException
	 */
	public CommonCoaRsVO searchBKG0061List2(SearchConditionVO searchConditionVO, String pHeader ) throws DAOException {
		DBRowSet dbRowset = null;
		CommonCoaRsVO commonCoaRsVO = new CommonCoaRsVO();

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(searchConditionVO != null){
				Map<String, String> mapVO = searchConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				String tmpStr = pHeader;
		        if(tmpStr.equals("")) tmpStr = " | ";
		        String[] header = tmpStr.split("[|]");

		        List<String> tpsz = new ArrayList(); 
				for(int i = 0; i < header.length; i++){   
					tpsz.add(header[i]);   
				}   
				velParam.put("f_tpsz", tpsz);				
 			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SalesRPTDBDAOsearchBkg0061List2RSQL(), param, velParam); 
			commonCoaRsVO.setDbRowset(dbRowset);
			commonCoaRsVO.setHeader(pHeader);
			commonCoaRsVO.setEventName("GS2");

		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return commonCoaRsVO;
	}
	/**
	 * Inquiry By BKG Report의 Sheet3 조회<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return CommonCoaRsVO
	 * @throws DAOException
	 */
	public CommonCoaRsVO searchBKG0061List3(SearchConditionVO searchConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		CommonCoaRsVO commonCoaRsVO = new CommonCoaRsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchConditionVO != null){
				Map<String, String> mapVO = searchConditionVO .getColumnValues();
				log.debug("@@@@@@@@@@@@ mapVO"+mapVO);
				mapVO.put("f_epp_tp_cd", searchConditionVO.getFTypeCd());			//SJH.20141016.ADD
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SalesRPTDBDAOsearchBkg0061List3RSQL(), param, velParam);
			commonCoaRsVO.setDbRowset(dbRowset);
			commonCoaRsVO.setEventName("GS3");

		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return commonCoaRsVO;
	}
	/**
	 *coa_rpt_itm_info_dtl 목록을 가져온다.<br>
	 * 
	 * @param  SearchConditionVO searchConditionVO
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchRptItem3(SearchConditionVO searchConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SalesRPTDBDAOsearchRptItem3RSQL(), param, velParam);

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
     * COA_BSA_CRR_RGST 목록을 가져온다.<br>
     *  
     *
     * @param SalesRPTCommonVO vo
     * @see SalesRPTBCImpl
     * @return List<SearchSetForm059ListVO>
     * @throws DAOException
     */		
    public List<SearchSetForm059ListVO> searchSetForm059List(SalesRPTCommonVO vo) throws DAOException {
        DBRowSet dbRowset = null;
        List<SearchSetForm059ListVO> list = null;
        try{
            if(vo == null) return null;
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SalesRPTDBDAOSearchSetForm059ListRSQL(), vo.getIndirectQueryParameter(), vo.getIndirectVelocityParameter());
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSetForm059ListVO.class);
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
	 * COA_BSA_CRR_RGST 목록을 가져온다.<br>
	 * 
	 * @사용프로그램 ESM_COA_059
	 * 
     * @param SalesRPTCommonVO vo
     * @see SalesRPTBCImpl
     * @return List<SearchSetForm059List2VO>
	 * @throws DAOException
	 */
    public List<SearchSetForm059List2VO> searchSetForm059List2(SalesRPTCommonVO vo) throws DAOException {
        DBRowSet dbRowset = null;
        List<SearchSetForm059List2VO> list = null;
        try{
            if(vo == null) return null;
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SalesRPTDBDAOSearchSetForm059List2RSQL(), vo.getIndirectQueryParameter(), null);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSetForm059List2VO.class);
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
	 * COA_RPT_ITM_INFO_MST, COA_RPT_ITM_INFO_DTL의 여러 데이타 모델을 <BR>
	 * 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정, 삭제)<BR>
	 * 
	 * @param SalesRPTCommonVO vo
	 * @return List<MultiSetForm059SeqVO>
	 * @throws DAOException
	 */
    public List<MultiSetForm059SeqVO> multiSetForm059Seq(SalesRPTCommonVO vo) throws DAOException {
        DBRowSet dbRowset = null;
        List<MultiSetForm059SeqVO> list = null;
        try{
            if(vo == null) return null;
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SalesRPTDBDAOMultiSetForm059SeqRSQL(), vo.getIndirectQueryParameter(), null);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, MultiSetForm059SeqVO.class);
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
	 * Set Customerized RPT Form에서 Multi처리한다. <BR>
	 * 
	 * @param  SalesRPTCommonVO vo
	 * @throws DAOException
	 */
    public void multiSetForm059RegistMaster(SalesRPTCommonVO vo) throws DAOException {
        int insCnt[] = null;

        try{
            SQLExecuter sqlExe = new SQLExecuter("");

            if(vo.getMultiCreateList() != null && vo.getMultiCreateList().size() > 0){
                insCnt = sqlExe.executeBatch((ISQLTemplate)new SalesRPTDBDAOMultiSetForm059RegistMasterCSQL(), vo.getMultiCreateList(), null);
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
	 * Set Customerized RPT Form에서 Multi 수정처리한다. <BR>
	 * 
	 * @param  SalesRPTCommonVO vo
	 * @throws DAOException
	 */
    public void multiSetForm059ModifyMaster(SalesRPTCommonVO vo) throws DAOException {
        int updCnt[] = null;

        try{
            SQLExecuter sqlExe = new SQLExecuter("");

            if(vo.getMultiUpdateList() != null && vo.getMultiUpdateList().size() > 0){
            	updCnt = sqlExe.executeBatch((ISQLTemplate)new SalesRPTDBDAOMultiSetForm059ModifyMasterUSQL(), vo.getMultiUpdateList(), null);
                for(int i = 0; i < updCnt.length; i++){
                    if(updCnt[i]== Statement.EXECUTE_FAILED)
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
	 * Set Customerized RPT Form에서 detail화면이다.<BR>
	 * 
	 * @param  SalesRPTCommonVO vo
	 * @throws DAOException
	 */
    public void multiSetForm059RegistDetail(SalesRPTCommonVO vo) throws DAOException {
        int insCnt[] = null;

        try{
            SQLExecuter sqlExe = new SQLExecuter("");   
            
            if(vo.getMultiCreateList() != null && vo.getMultiCreateList().size() > 0){
                insCnt = sqlExe.executeBatch((ISQLTemplate)new SalesRPTDBDAOMultiSetForm059RegistDetailCSQL(), vo.getMultiCreateList(), null);
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
	 * Set Customerized RPT Form에서 MASTER 삭제처리한다.<BR>
	 * 
	 * @param  SalesRPTCommonVO vo
	 * @throws DAOException
	 */
    public void multiSetForm059RemoveMaster(SalesRPTCommonVO vo) throws DAOException {
        int delCnt[] = null;

        try{
            SQLExecuter sqlExe = new SQLExecuter("");   
            
            if(vo.getMultiDeleteList() != null && vo.getMultiDeleteList().size() > 0){
                delCnt = sqlExe.executeBatch((ISQLTemplate)new SalesRPTDBDAOMultiSetForm059RemoveMasterDSQL(), vo.getMultiDeleteList(), null);
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
	 * Set Customerized RPT Form에서 DETAIL 삭제처리한다.<BR>
	 * 
	 * @param  SalesRPTCommonVO vo
	 * @throws DAOException
	 */
    public void multiSetForm059RemoveDetail(SalesRPTCommonVO vo) throws DAOException {
        int delCnt[] = null;

        try{
            SQLExecuter sqlExe = new SQLExecuter("");   
            
            if(vo.getMultiDeleteList() != null && vo.getMultiDeleteList().size() > 0){
                delCnt = sqlExe.executeBatch((ISQLTemplate)new SalesRPTDBDAOMultiSetForm059RemoveDetailDSQL(), vo.getMultiDeleteList(), vo.getIndirectVelocityParameter());
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
	 * COA_SPCL_REPO_CNTR_RGST의 여러 데이타 모델을 <BR>
	 * 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정, 삭제)<BR>
	 * 입력, 수정,삭제 작업은 COA_SPCL_REPO_CNTR_RGST테이블에서 일어난다. <BR>
	 * 
	 * @param SalesRPTCommonVO vo
	 * @return SalesRPTCommonVO
	 * @throws DAOException
	 */
    public SalesRPTCommonVO searchInqByCondition060List(SalesRPTCommonVO vo) throws DAOException {
        DBRowSet dbRowset = null;
        SalesRPTCommonVO retVo = null;
        try{
            if(vo == null) return null;
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SalesRPTDBDAOSearchInqByCondition060ListRSQL(), vo.getIndirectQueryParameter(), vo.getIndirectVelocityParameter());
            retVo = new SalesRPTCommonVO();
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
     * coa_rpt_itm_info_dtl 목록을 가져온다.<br>
     *  - List 타입의 View Adapter용 조회
     *
     * @param SalesRPTCommonVO vo
     * @see SearchRptBCImpl
     * @return List<SearchRptItemVO>
     * @throws DAOException
     */
    public List<SearchRptItemVO> searchRptItem(SalesRPTCommonVO vo) throws DAOException {
        DBRowSet dbRowset = null;
        List<SearchRptItemVO> list = null;
        try{
            if(vo == null) return null;
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SalesRPTDBDAOSearchRptItemRSQL(), vo.getIndirectQueryParameter(), null);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchRptItemVO.class);
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
	 *MDM COSTOMER 테이블에서 Customer 정보 조회<br>
	 * 
	 * @param  SearchConditionVO searchConditionVO
	 * @return List<ShipperVO>
	 * @throws DAOException
	 */
	public List<ShipperVO> searchShipperList(SearchConditionVO searchConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ShipperVO> list = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SalesRPTDBDAOsearchShipperListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ShipperVO .class);
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
	 * 목록을 조회한다.
	 * 
	 * @param SalesOffiRepoConditionVO vo
	 * @return DBRowSet
	 * @throws DAOException
	 */	
	public DBRowSet searchRPTbyOfc0070List11(SalesOffiRepoConditionVO vo) throws DAOException {
		DBRowSet dbRowset = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SalesRPTDBDAOSearchRPTbyOfc070List11RSQL(), param, velParam);
			//list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchRPTbyOfc070List11VO .class);
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
	 * 목록을 조회한다.
	 * 
	 * @param SalesOffiRepoConditionVO vo
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchRPTbyOfc0070List12(SalesOffiRepoConditionVO vo) throws DAOException {
		DBRowSet dbRowset = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SalesRPTDBDAOSearchRPTbyOfc070List12RSQL(), param, velParam);
			//list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchRPTbyOfc070List12VO .class);
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
	 * 삭제된 BKG정보인지 확인<br> - 사용 프로그램 : ESM_COA_0061
	 * -- COA_RGST_BKG, BKG_BOOKING	테이블을 조인걸어 없거나 삭제된 부킹일 경우 TRUE로 RETURN한다.
	 * 
	 * @param  String bkg_no
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean isDeletedBooking(String bkg_no) throws DAOException {
		DBRowSet dbRowset = null;
		boolean isDeleted = false;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			param.put("bkg_no",bkg_no);		
						
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SalesRPTDBDAOIsDeleteBookingRSQL(), param, null);
			
			if(dbRowset.getRowCount() == 0){
				isDeleted = true;
			}
			while (dbRowset.next()) {
				if ("X".equals(dbRowset.getString("bkg_sts_cd")))
					isDeleted = true;
			}
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return isDeleted;
	}	
	/**
	 * BKG에 대한 정보를 조회한다.Sheet1<br> - 사용 프로그램 : ESM_COA_156
	 * 
	 * @param  SalesOffiRepoConditionVO vo
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchBkgInfo(SalesOffiRepoConditionVO vo) throws DAOException {
		DBRowSet dbRowset = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SalesRPTDBDAOSearchBkgInfoRSQL(), param, velParam);
			
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
	 * BKG에 대한 Type Size별  Load, Revenue를 조회한다.Sheet2<br> - 사용 프로그램 : ESM_COA_156
	 * 
	 * @param  SalesOffiRepoConditionVO vo
	 * @param  List<String> cols
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchBkgLoadRev(SalesOffiRepoConditionVO vo, List<String> cols) throws DAOException {
		DBRowSet dbRowset = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{			
			Map<String, String> mapVO = vo.getColumnValues();				
			param.putAll(mapVO);
			velParam.putAll(mapVO);	
						
			// 가변컬럼세팅			
			velParam.put("allcols", cols);			
						
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SalesRPTDBDAOSearchBkgLoadRevRSQL(), param, velParam);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}	
	
}

