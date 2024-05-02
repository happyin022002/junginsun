/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GEMMasterCodeMgtDAO.java
*@FileTitle : Expense Office Maintenance
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.17
*@LastModifier : 최정미
*@LastVersion : 1.0
* 2009.04.17 최정미
* 1.0 Creation
* ------------------------------------------------------------------
* 2010.07.01 윤진영 CHM-201004242 searchMdmVndrRfndList 메쏘드 추가 
             mdm_customer에서 refund_seq를 구해오는 DAO
* 2010.12.10 이준범 [CHM-201007236-01]
* 1.제목 : CNI Main Code Creation Logic 보완 및 Popup 화면 추가 요청
* 2.처리내역
*  2.1 Main code creation시 Code 생성 규칙에 따른 중복 유사 Code를 검색하여 
*      그 결과를 Popup display하며 User의 선택에  따라 생성 또는 Detail 
*      information을 확인할 수 있는 Main Code View 화면으로 이동하도록 보완              
=========================================================*/
package com.hanjin.apps.alps.cps.cni.codemgt.codemgt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.StringTokenizer;

import com.hanjin.apps.alps.cps.cni.codemgt.codemgt.vo.ClassCodeVO;
import com.hanjin.apps.alps.cps.cni.codemgt.codemgt.vo.CniClassCodeVO;
import com.hanjin.apps.alps.cps.cni.codemgt.codemgt.vo.CniCntcPntVO;
import com.hanjin.apps.alps.cps.cni.codemgt.codemgt.vo.CniMiscCodeVO;
import com.hanjin.apps.alps.cps.cni.codemgt.codemgt.vo.CniPartyVO;
import com.hanjin.apps.alps.cps.cni.codemgt.codemgt.vo.ContactPointVO;
import com.hanjin.apps.alps.cps.cni.codemgt.codemgt.vo.HandlerHistoryVO;
import com.hanjin.apps.alps.cps.cni.codemgt.codemgt.vo.MdmOrganizationVO;
import com.hanjin.apps.alps.cps.cni.codemgt.codemgt.vo.MiscCodeVO;
import com.hanjin.apps.alps.cps.cni.codemgt.codemgt.vo.MiscellaneousVO;
import com.hanjin.apps.alps.cps.cni.codemgt.codemgt.vo.PartyInquiryCondVO;
import com.hanjin.apps.alps.cps.cni.codemgt.codemgt.vo.PartyInquiryVO;
import com.hanjin.apps.alps.cps.cni.codemgt.codemgt.vo.PartyVO;
import com.hanjin.apps.alps.cps.cni.codemgt.codemgt.vo.VvdSkdCondVO;
import com.hanjin.apps.alps.cps.cni.codemgt.codemgt.vo.VvdSkdVO;
import com.hanjin.apps.alps.cps.gem.common.GemUtil;
import com.hanjin.apps.alps.cps.gem.gemcommon.gemmastercodemgt.basic.GEMMasterCodeMgtBCImpl;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.apps.alps.cps.cni.codemgt.codemgt.vo.CniUsrRoleMtchVO;


/**
 * NIS2010 GEMMasterCodeMgtDAO <br>
 * - NIS2010-GEMCommon system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author cjm
 * @see GEMMasterCodeMgtBCImpl 참조
 * @since J2EE 1.4
 */
public class CodeMgtDBDAO extends DBDAOSupport {

	// ---------------------------------------------------------------------------
	// 공통 SQL
	// ---------------------------------------------------------------------------
	
	/**
	 * CNI GMT(YYYY-MM-DD)  조회<br>
	 * @author 진윤오
	 * @category common
	 * @category searchGmtDate 
	 * @param String userId
     * @return String
     * @throws DAOException
     */
    public String searchGmtDate(String userId) throws DAOException {
        DBRowSet dbRowset = null;
        
        try{    
        	// query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            
        	//  로그인 userId
        	param.put("user_id", userId);        	
        	// velocity parameter 설정 
            velParam.putAll(param);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CodeMgtDBDAOSearchGmtDateRSQL(), param, velParam);
            
            if (dbRowset.next()) {
            	return dbRowset.getString(1);
            }
            
            return null;
            
        } catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(),se);
        } catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
       
    }		
	
	/**
	 * CNI 시퀀스 조회<br>
	 * @author 진윤오
	 * @category common
	 * @category searchSequenceNo 
	 * @param String sequenceName
     * @return String
     * @throws DAOException
     */
    public String searchSequenceNo(String sequenceName) throws DAOException {
        DBRowSet dbRowset = null;
        
        try{    
        	// query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            
        	//  Claim Party No
        	param.put("seq_name", sequenceName);        	
        	// velocity parameter 설정 
            velParam.putAll(param);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CodeMgtDBDAOSearchSequenceNoRSQL(), param, velParam);
            
            if (dbRowset.next()) {
            	return dbRowset.getString("seq");
            }
            
            return null;
            
        } catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(),se);
        } catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
       
    }	
	
	
	
	// 진윤오  ===========================================================================	
	
	// ---------------------------------------------------------------------------
	// [CPS_CNI-0025] Main Code Creation
	// ---------------------------------------------------------------------------
	
	/**
	 * Claim Party 정보 조회<br>
	 * @author 진윤오
	 * @category CPS_CNI_0025
	 * @category searchPartyInfo 
	 * @param String clmPtyNo
     * @return PartyVO
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public PartyVO searchPartyInfo(String clmPtyNo) throws DAOException {
        DBRowSet dbRowset = null;
        
        List<PartyVO> list = null;        
       
        try{    
        	// query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            
        	//  Claim Party No
        	param.put("clm_pty_no", clmPtyNo);
        	// velocity parameter 설정 
            velParam.putAll(param);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CodeMgtDBDAOSearchPartyInfoRSQL(), param, velParam);
            
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, PartyVO.class);
            
            if (list != null && !list.isEmpty()) {
            	return list.get(0);
            }
            
            return null;
            
        } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
        
    }
  
    
	/**
	 * Code name의 자리수별 max값 리스트 조회<br>
	 * @author 진윤오
	 * @category CPS_CNI_0025
	 * @category searchPartyMaxCodeList 
	 * @param String clmPtyAbbrNm
     * @return String MaxCode
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public String searchPartyMaxCodeList(String clmPtyAbbrNm) throws DAOException {
        DBRowSet dbRowset = null;
        
       
        try{    
        	// query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            
        	//  clm_pty_abbr_nm  Code의 5자리만
            int len = clmPtyAbbrNm.length();
        	param.put("clm_pty_abbr_nm", clmPtyAbbrNm);
        	
        	//마지막 문자열 INDEX가 숫자인경우만 검색
            if (len == 7) {
            	// 1자리 
            	param.put("cond", "[0-9]$");
            } else if (len == 6) {
            	// 10자리
            	param.put("cond", "[0-9][0-9]$");
            } else if (len == 5) {
            	// 100자리
            	param.put("cond", "[0-9][0-9][0-9]$");
            }
        	
        	param.put("clm_pty_abbr_nm", clmPtyAbbrNm);
        	
        	// velocity parameter 설정 
            velParam.putAll(param);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CodeMgtDBDAOSearchPartyMaxCodeListRSQL(), param, velParam);
            
            if (dbRowset.next()) {
            	return dbRowset.getString(1);
            }
                 
            return null;
            
        } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
       
    }        
    
    
	/**
	 * Code name의 존재하는 갯수 조회<br>
	 * @author 진윤오
	 * @category CPS_CNI_0025
	 * @category searchClmPtyAbbrNmCount 
	 * @param String clmPtyAbbrNm
     * @return int count
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public int searchClmPtyAbbrNmCount(String clmPtyAbbrNm) throws DAOException {
        DBRowSet dbRowset = null;
        
        try{    
        	// query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
        
        	param.put("clm_pty_abbr_nm", clmPtyAbbrNm);
        
        	// velocity parameter 설정 
            velParam.putAll(param);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CodeMgtDBDAOSearchClmPtyAbbrNmCountRSQL(), param, velParam);
            
            if (dbRowset.next()) {
            	return dbRowset.getInt(1);
            }
                 
            return 0;
            
        } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
       
    }            
    
	/**
	 * Claim Party 별 Cni Contact Point 리스트 조회<br>
	 * @author 진윤오
	 * @category CPS_CNI_0025
	 * @category searchContactPointList 
	 * @param String clmPtyNo
     * @return List<ContactPointVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<ContactPointVO> searchContactPointList(String clmPtyNo) throws DAOException {
        DBRowSet dbRowset = null;
        
        List<ContactPointVO> list = null;        
       
        try{    
        	// query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            
        	//  Claim Party No
        	param.put("clm_pty_no", clmPtyNo);
        	
        	// velocity parameter 설정 
            velParam.putAll(param);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CodeMgtDBDAOSearchContactPointListRSQL(), param, velParam);
            
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, ContactPointVO.class);
                 
            return list;
            
        } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
       
    }    
    
	/**
	 * Claim Party 추가<br>
	 * @author 진윤오
	 * @category CPS_CNI_0025
	 * @category addParty 
	 * @param CniPartyVO cniPartyVO
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public void addParty(CniPartyVO cniPartyVO) throws DAOException {        
        try{    
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> velParam = new HashMap<String, Object>();			
			Map<String , String> paramMap = cniPartyVO.getColumnValues();			
			sqlExe.executeUpdate((ISQLTemplate) new CodeMgtDBDAOAddPartyCSQL(), paramMap, velParam);            
        } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
       
    }       

	/**
	 * Claim Party 수정<br>
	 * @author 진윤오
	 * @category CPS_CNI_0025
	 * @category modifyParty 
	 * @param CniPartyVO cniPartyVO
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public void modifyParty(CniPartyVO cniPartyVO) throws DAOException {        
        try{    
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> velParam = new HashMap<String, Object>();			
			Map<String , String> paramMap = cniPartyVO.getColumnValues();			
			sqlExe.executeUpdate((ISQLTemplate) new CodeMgtDBDAOModifyPartyUSQL(), paramMap, velParam);            
        } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
       
    }     
    
	/**
	 * Claim Party 삭제<br>
	 * @author 진윤오
	 * @category CPS_CNI_0025
	 * @category removeParty 
	 * @param CniPartyVO cniPartyVO
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public void removeParty(CniPartyVO cniPartyVO) throws DAOException {        
        try{    
			SQLExecuter sqlExe = new SQLExecuter("");
			// query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            
        	//  Claim Party No
        	param.put("upd_usr_id", cniPartyVO.getUpdUsrId());        	
        	param.put("clm_pty_no", cniPartyVO.getClmPtyNo());
        	velParam.putAll(param);
        	
			sqlExe.executeUpdate((ISQLTemplate) new CodeMgtDBDAORemovePartyDSQL(), param, velParam);            
        } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
       
    }     
    
	/**
	 * Claim Contact Point 추가<br>
	 * @author 진윤오
	 * @category CPS_CNI_0025
	 * @category addContactPoint 
	 * @param CniCntcPntVO cniCntcPntVO
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public void addContactPoint(CniCntcPntVO cniCntcPntVO) throws DAOException {        
        try{    
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> velParam = new HashMap<String, Object>();			
			Map<String , String> paramMap = cniCntcPntVO.getColumnValues();			
			sqlExe.executeUpdate((ISQLTemplate) new CodeMgtDBDAOAddContactPointCSQL(), paramMap, velParam);            
        } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
       
    }       

	/**
	 * Claim Contact Point 수정<br>
	 * @author 진윤오
	 * @category CPS_CNI_0025
	 * @category modifyContactPoint 
	 * @param CniCntcPntVO cniCntcPntVO
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public void modifyContactPoint(CniCntcPntVO cniCntcPntVO) throws DAOException {        
        try{    
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> velParam = new HashMap<String, Object>();			
			Map<String , String> paramMap = cniCntcPntVO.getColumnValues();			
			sqlExe.executeUpdate((ISQLTemplate) new CodeMgtDBDAOModifyContactPointUSQL(), paramMap, velParam);            
        } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
       
    }  

    
	/**
	 * Claim Contact Point 삭제<br>
	 * @author 진윤오
	 * @category CPS_CNI_0025
	 * @category removeContactPoint 
	 * @param CniCntcPntVO cniCntcPntVO
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public void removeContactPoint(CniCntcPntVO cniCntcPntVO) throws DAOException {        
        try{    
			SQLExecuter sqlExe = new SQLExecuter("");
			// query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            
        	//  Claim Party No
        	param.put("clm_pty_no", cniCntcPntVO.getClmPtyNo());
        	param.put("clm_cntc_pnt_seq", cniCntcPntVO.getClmCntcPntSeq());
        	velParam.putAll(param);        	
			sqlExe.executeUpdate((ISQLTemplate) new CodeMgtDBDAORemoveContactPointDSQL(), param, velParam);
			
        } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
       
    }  
    
	// ---------------------------------------------------------------------------
	// [CPS_CNI-0042] 
	// ---------------------------------------------------------------------------    
    /**
     * CCC VVD & SKD Inquiry 
	 * vvd  Vessel schedule 리스트 조회<br>
	 * @author 진윤오
	 * @category CPS_CNI_0042
	 * @category searchVvdSkdList 
	 * @param VvdSkdCondVO vvdSkdCondVO
     * @return List<VvdSkdVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<VvdSkdVO> searchVvdSkdList(VvdSkdCondVO vvdSkdCondVO) throws DAOException {
        DBRowSet dbRowset = null;
        
        List<VvdSkdVO> list = null;        
       
        try{    
        	// query parameter
            Map<String, String> param = new HashMap<String, String>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            param = vvdSkdCondVO.getColumnValues();
            velParam.putAll(param);        	
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CodeMgtDBDAOSearchVvdSkdListRSQL(), param, velParam);            
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, VvdSkdVO.class);                 
            return list;
            
        } catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(),se);
        } catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
    }        
    
    //====================================================================================
    // 정행룡
    //====================================================================================
    // ---------------------------------------------------------------------------
	// [CPS_CNI-0004] Handler History
	// ---------------------------------------------------------------------------  
    /**
	 * Claim No 별 Handler History 리스트 조회<br>
	 * @author 정행룡
	 * @category CPS_CNI_0004
	 * @category searchHandlerHistoryList 
	 * @param String cgoClmNo
	 * @param String mgrHdlrDivCd
     * @return List<HandlerHistoryVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<HandlerHistoryVO> searchHandlerHistoryList(String cgoClmNo, String mgrHdlrDivCd) throws DAOException {
        DBRowSet dbRowset = null;
        
        List<HandlerHistoryVO> list = null;        
       
        try{    
        	// query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            
        	//  Claim No
        	param.put("cgo_clm_no", cgoClmNo);
        	
        	param.put("mgr_hdlr_div_cd", mgrHdlrDivCd);
        	
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CodeMgtDBDAOSearchHandlerHistoryListRSQL(), param, velParam);
            
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, HandlerHistoryVO.class);
                 
            return list;
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
    }
    
    // ---------------------------------------------------------------------------
	// [CPS_CNI-0005] Manager History
	// ---------------------------------------------------------------------------
    /**
	 * Claim No 별 Manager History 리스트 조회<br>
	 * @author 정행룡
	 * @category CPS_CNI_0005
	 * @category searchManagerHistoryList 
	 * @param String cgoClmNo
	 * @param String mgrHdlrDivCd
     * @return List<HandlerHistoryVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<HandlerHistoryVO> searchManagerHistoryList(String cgoClmNo, String mgrHdlrDivCd) throws DAOException {
        DBRowSet dbRowset = null;
        
        List<HandlerHistoryVO> list = null;        
       
        try{    
        	// query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            
        	//  Claim No
        	param.put("cgo_clm_no", cgoClmNo);
        	
        	param.put("mgr_hdlr_div_cd", mgrHdlrDivCd);
        	
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CodeMgtDBDAOSearchHandlerHistoryListRSQL(), param, velParam);
            
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, HandlerHistoryVO.class);
                 
            return list;
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
    }

    /**
	 * Manager History 데이터를 일괄적으로 등록한다.<br>
	 * @author 정행룡
	 * @category CPS_CNI_0005
	 * @category addManagerHistory
	 * @param List<HandlerHistoryVO> addVoList
	 * @throws DAOException
	 */
	public void addManagerHistory(List<HandlerHistoryVO> addVoList) throws DAOException, Exception {
		try {
			int insCnt = 0;

			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			if (addVoList.size() > 0) {
				for (int i =0; i<addVoList.size();i++){
					Map<String, Object> param = new HashMap<String, Object>();
					Map<String, String> dataVO = new HashMap<String, String>();
					HandlerHistoryVO handlerHistoryVO = addVoList.get(i);
					 
					dataVO = handlerHistoryVO.getColumnValues();

					param.putAll( dataVO );
					param.put("mgr_hdlr_div_cd", "M");
					param.put("cgo_clm_his_tp_cd", "M");
					
				    insCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new CodeMgtDBDAOAddManagerHistoryCSQL(),  param, velParam);	
				    if (insCnt == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to Add No" + i + " SQL");
					}
				}
			}	
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
		
	/**
	 * Manager History 다건의 데이터를 일괄적으로 수정한다.<br>
	 * @author 정행룡
	 * @category CPS_CNI_0039
	 * @category modifyManagerHistory
	 * @param List<HandlerHistoryVO> modifyVoList
	 * @throws DAOException
	 */
    public void modifyManagerHistory(List<HandlerHistoryVO> modifyVoList) throws DAOException {    	  
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (modifyVoList.size() > 0) {
				Map<String, Object> velParam = new HashMap<String, Object>();
				insCnt = sqlExe.executeBatch((ISQLTemplate) new CodeMgtDBDAOModifyManagerHistoryUSQL(), modifyVoList, velParam);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modify No" + i + " SQL");
				}
			}			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
    }
    
    /**
	 * Manager History 다건의 데이터를 일괄적으로 삭제한다.<br>
	 * @author 정행룡
	 * @category CPS_CNI_0005
	 * @category removeManagerHistory
	 * @param List<HandlerHistoryVO> deleteVoList
	 * @throws DAOException
	 */
    public void removeManagerHistory(List<HandlerHistoryVO> deleteVoList) throws DAOException {    	  
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (deleteVoList.size() > 0) {
				Map<String, Object> velParam = new HashMap<String, Object>();
				insCnt = sqlExe.executeBatch((ISQLTemplate) new CodeMgtDBDAORemoveManagerHistoryDSQL(), deleteVoList, velParam);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to Delete No" + i + " SQL");
				}
			}			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
    }
    
    /**
	 * Handler History 데이터를 등록한다.<br>
	 * @author 정행룡
	 * @category CPS_CNI_0003
	 * @category addHandlerHistory
	 * @param HandlerHistoryVO handlerHistoryVO
	 * @throws DAOException
	 */
	public void addHandlerHistory(HandlerHistoryVO handlerHistoryVO) throws DAOException, Exception {
		try {

			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> velParam = new HashMap<String, Object>();			
			Map<String , String> paramMap = handlerHistoryVO.getColumnValues();			
			sqlExe.executeUpdate((ISQLTemplate) new CodeMgtDBDAOAddHandlerHistoryCSQL(), paramMap, velParam);     
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
		
	/**
	 *  Handler History 데이터를 수정한다.<br>
	 * @author 정행룡
	 * @category CPS_CNI_0003
	 * @category modifyHandlerHistory
	 * @param HandlerHistoryVO handlerHistoryVO
	 * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public void modifyHandlerHistory(HandlerHistoryVO handlerHistoryVO) throws DAOException {        
        try{    
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> velParam = new HashMap<String, Object>();			
			Map<String , String> paramMap = handlerHistoryVO.getColumnValues();			
			sqlExe.executeUpdate((ISQLTemplate) new CodeMgtDBDAOModifyHandlerHistoryUSQL(), paramMap, velParam);            
        } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
       
    }  
    
    /**
	 * Class Code Validation 체크 조회<br>
	 * @author 정행룡
	 * @category CPS_CNI_0003
	 * @category searchMiscCodeExist
	 * @param String clssClmMiscCd
	 * @param String clmMiscCd
     * @return String
     * @throws EventException
     */
    public String searchMiscCodeExist(String clssClmMiscCd, String clmMiscCd) throws DAOException {
        DBRowSet dbRowset = null;
        
        try{    
        	// query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            
        	
        	param.put("clss_clm_misc_cd", clssClmMiscCd);   
        	param.put("clm_misc_cd", clmMiscCd);   
        	
        	// velocity parameter 설정 
            velParam.putAll(param);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CodeMgtDBDAOSearchMiscCodeExsitRSQL(), param, velParam);
            
            if (dbRowset.next()) {
            	return dbRowset.getString(1);
            }
            
            return "N";
            
        } catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(),se);
        } catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
    }
    
    /**
	 * Office Code 체크 조회<br>
	 * @author 정행룡
	 * @category CPS_CNI_0003
	 * @category searchMdmOrganizationExist
	 * @param String ofcCd
     * @return String
     * @throws EventException
     */
    public String searchMdmOrganizationExist(String ofcCd) throws DAOException {
        DBRowSet dbRowset = null;
        
        try{    
        	// query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            
        	
        	param.put("ofc_cd", ofcCd);   
        	
        	// velocity parameter 설정 
            velParam.putAll(param);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CodeMgtDBDAOSearchMdmOrganizationExistRSQL(), param, velParam);
            
            if (dbRowset.next()) {
            	return dbRowset.getString(1);
            }
            
            return "N";
            
        } catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(),se);
        } catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
    }	
    
	// 양정란  ===========================================================================	
	
	// ---------------------------------------------------------------------------
	// [CPS_CNI-0007] Office Code Table
	// ---------------------------------------------------------------------------    
    
	/**
	 * Office Code 리스트 조회<br>
	 * @author 양정란
	 * @category CPS_CNI_0007
	 * @category searchMdmOrganizationList 
	 * @param String ofcCd
     * @return List<MdmOrganizationVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<MdmOrganizationVO> searchMdmOrganizationList(String ofcCd) throws DAOException {
        DBRowSet dbRowset = null;
        
        List<MdmOrganizationVO> list = null;        
       
        try{    
        	// query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            
        	//  Claim Party No
        	param.put("ofc_cd", ofcCd);
        	
        	// velocity parameter 설정 
            velParam.putAll(param);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CodeMgtDBDAOSearchMdmOrganizationRSQL(), param, velParam);
            
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, MdmOrganizationVO.class);
                 
            return list;
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
       
    }    
    
	// 윤진영  ===========================================================================	
	
	// ---------------------------------------------------------------------------
	// [CPS_CNI-0027] Main Code Creation
	// ---------------------------------------------------------------------------    
    
	/**
	 * mdm_customer에서 vender_cd 또는 refund cd를 구한다.<br>
	 * @author 윤진영
	 * @category CPS_CNI_0027
	 * @category searchMdmVndrRfndCd
	 * @param String cntCd
	 * @param String custSeq
     * @return String vndr_cd
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public String searchMdmVndrRfndList(String cntCd,String custSeq) throws DAOException {
    	String vndrCd = null;
        try{    
        	// query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            
        	//  Claim Party No
        	param.put("cnt_cd", cntCd);
        	param.put("cust_seq", custSeq);
        	
        	// velocity parameter 설정 
            velParam.putAll(param);
            
            DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CodeMgtDbDAOSearchMdmVndrRfndCdRSQL(), param, velParam);
            if(dbRowset.next()) {
            	vndrCd = dbRowset.getString("vndr_cd");
            }
            return vndrCd;
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
       
    }    
    
    /**
	 * Office Code 입력값 validation<br>
	 * @author 양정란
	 * @category CPS_CNI_0036
	 * @category searchOfcCd 
	 * @param String ofcCd
     * @return String[] 
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public String[] searchOfcCd(String ofcCd) throws DAOException {
        DBRowSet dbRowset = null;
        
        String returnStr[] = null;
       
        try{    
        	// query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            
        	// 조회조건
        	param.put("trns_to_ofc_cd", ofcCd);
        	
        	// velocity parameter 설정 
            velParam.putAll(param);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CodeMgtDBDAOSearchOfcCdRSQL(), param, velParam);
            returnStr = GemUtil.getArrayString(dbRowset, "EXIST_OFC_CD");
            
            return returnStr;
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
       
    }  
    
    /**
	 * UsrId 입력값 validation<br>
	 * @author 양정란
	 * @category CPS_CNI_0036
	 * @category searchUsrId 
	 * @param String ofcCd
	 * @param String usrId
     * @return String[] 
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public String[] searchUsrId(String ofcCd, String usrId) throws DAOException {
        DBRowSet dbRowset = null;
        
        String returnStr[] = null;
       
        try{    
        	// query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            
        	// 조회조건
        	param.put("ofc_cd", ofcCd);
        	param.put("usr_id", usrId);
        	
        	// velocity parameter 설정 
            velParam.putAll(param);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CodeMgtDBDAOSearchUsrIdRSQL(), param, velParam);
            returnStr = GemUtil.getArrayString(dbRowset, "EXIST_USR_ID");
            
            return returnStr;
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
       
    }       
    
	// ---------------------------------------------------------------------------
	// [CPS_CNI_0026] Main Code-Inquiry
	// ---------------------------------------------------------------------------
	/**
	 * Claim Party 리스트 조회<br>
	 * @author 진윤오
	 * @category CPS_CNI_0026
	 * @category searchPartyInquiryList 
	 * @param PartyInquiryCondVO partyInquiryCondVO
     * @return party 정보 
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<PartyInquiryVO> searchPartyInquiryList(PartyInquiryCondVO partyInquiryCondVO) throws DAOException {
        DBRowSet dbRowset = null;
        
        List<PartyInquiryVO> list = null;        
       
        try{    
        	// query parameter
        	Map<String , String> param = partyInquiryCondVO.getColumnValues();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            
        	// velocity parameter 설정 
            velParam.putAll(param);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CodeMgtDBDAOSearchPartyInquiryListRSQL(), param, velParam);
            
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, PartyInquiryVO.class);
                 
            return list;
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
       
    }      
	// ---------------------------------------------------------------------------
	// [CPS_CNI_0095] Main Code-Popup
	// ---------------------------------------------------------------------------
	/**
	 * Claim Party 리스트 조회<br>
	 * @author 이준범
	 * @category CPS_CNI_0095
	 * @category searchPartyPopupList 
	 * @param String ptyNm
     * @return party 정보 
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<PartyInquiryVO> searchPartyPopupList(String ptyNm) throws DAOException {
        DBRowSet dbRowset = null;
        
        List<PartyInquiryVO> list = null;  
        
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();       

		try{    
            
        	// velocity parameter 설정 
			param.put("pty_nm", ptyNm);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CodeMgtDBDAOSearchPartyPopupListRSQL(), param, velParam);
            
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, PartyVO.class);
                 
            return list;
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
       
    }         
    
    
    
    // ===========================================================================
    // 박제성
    // ===========================================================================

    // ---------------------------------------------------------------------------
    // [CPS_CNI_0039] Class Code Creation
    // ---------------------------------------------------------------------------
	    
    
	/**
	 * Class Code 리스트 조회<br>
	 * @author 박제성
	 * @category CPS_CNI_0039
	 * @category searchClassCodeList 
	
     * @return List<ClassCodeVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<ClassCodeVO> searchClassCodeList() throws DAOException {
        DBRowSet dbRowset = null;
        
        List<ClassCodeVO> list = null;        
       
        try{    
        	// query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
                    	
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CodeMgtDBDAOSearchClassCodeRSQL(), param, velParam);
            
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, ClassCodeVO.class);
                 
            return list;
            
        } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
       
    }
    
    /**
	 * Class Code 다건의 데이터를 일괄적으로 생성한다.<br>
	 * 
	 * @author 박제성
	 * @category CPS_CNI_0039
	 * @category addClassCode
	 * 
	 * @param CniClassCodeVO cniClassCodeVO
	 *           
	 * @throws DAOException
	 */
    @SuppressWarnings("unchecked")
	public void addClassCode(CniClassCodeVO cniClassCodeVO) throws DAOException, Exception {
		
        try{    
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> velParam = new HashMap<String, Object>();			
			Map<String , String> paramMap = cniClassCodeVO.getColumnValues();			
			sqlExe.executeUpdate((ISQLTemplate) new CodeMgtDBDAOAddClassCodeCSQL(), paramMap, velParam);            
        } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
    	
	}
		
	/**
	 * Class Code 다건의 데이터를 일괄적으로 수정한다.<br>
	 * 
	 * @author 박제성
	 * @category CPS_CNI_0039
	 * @category modifyClassCode
	 * 
	 * @param CniClassCodeVO cniClassCodeVO
	 *           
	 * @throws DAOException
	 */
    @SuppressWarnings("unchecked")
    public void modifyClassCode(CniClassCodeVO cniClassCodeVO) throws DAOException {    	  
		
        try{    
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> velParam = new HashMap<String, Object>();			
			Map<String , String> paramMap = cniClassCodeVO.getColumnValues();			
			sqlExe.executeUpdate((ISQLTemplate) new CodeMgtDBDAOModifyClassCodeUSQL(), paramMap, velParam);            
        } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}    	
 
    }
    
    /**
	 * Class Code 다건의 데이터를 일괄적으로 삭제한다.<br>
	 * 
	 * @author 박제성
	 * @category CPS_CNI_0039
	 * @category removeClassCode
	 * 
	 * @param CniClassCodeVO cniClassCodeVO
	 *           
	 * @throws DAOException
	 */
    @SuppressWarnings("unchecked")
    public void removeClassCode(CniClassCodeVO cniClassCodeVO) throws DAOException {    	  
		
        try{    
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> velParam = new HashMap<String, Object>();			
			Map<String , String> paramMap = cniClassCodeVO.getColumnValues();			
			sqlExe.executeUpdate((ISQLTemplate) new CodeMgtDBDAORemoveClassCodeDSQL(), paramMap, velParam);            
        } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}       	

    }
    
    
    
    
    // ===========================================================================
    // 박제성
    // ===========================================================================

    // ---------------------------------------------------------------------------
    // [CPS_CNI_0028] Miscellaneous Code Creation
    // ---------------------------------------------------------------------------
	/**
	 * Miscellaneous Code 리스트 조회<br>
	 * @author 진윤오
	 * @category CPS_CNI_0028
	 * @category searchMiscellaneousList 
	 * @param String clssClmMiscCd
     * @return List<MiscellaneousVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<MiscellaneousVO> searchMiscellaneousList(String clssClmMiscCd) throws DAOException {
        DBRowSet dbRowset = null;
        
        List<MiscellaneousVO> list = null;        
       
        try{    
        	// query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            
            // clssClmMiscCd
        	param.put("clss_clm_misc_cd", clssClmMiscCd);        	
        	// velocity parameter 설정 
            velParam.putAll(param);                    	
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CodeMgtDBDAOSearchMiscellaneousListRSQL(), param, velParam);
            
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, MiscellaneousVO.class);
                 
            return list;
            
        } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
       
    }	    
    
	/**
	 * Miscellaneous Code 리스트 조회<br>
	 * @author 박제성
	 * @category CPS_CNI_0028
	 * @category searchMiscCodeList 
	 * @param String clssClmMiscCd
	 * @param String clmMiscCd
	 * @param String clmMiscNm
     * @return List<MiscCodeVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<MiscCodeVO> searchMiscCodeList(String clssClmMiscCd, String clmMiscCd, String clmMiscNm) throws DAOException {
        DBRowSet dbRowset = null;
        
        List<MiscCodeVO> list = null;        
       
        try{    
        	// query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            
        //  clssClmMiscCd
        	param.put("clss_clm_misc_cd", clssClmMiscCd);
        	param.put("clm_misc_cd", clmMiscCd);
        	param.put("clm_misc_nm", clmMiscNm);  
        	// velocity parameter 설정 
            velParam.putAll(param);
                    	
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CodeMgtDBDAOSearchMiscCodeRSQL(), param, velParam);
            
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, MiscCodeVO.class);
                 
            return list;
            
        } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
       
    }
    
    /**
	 * Miscellaneous Code 다건의 데이터를 일괄적으로 생성한다.<br>
	 * 
	 * @author 박제성
	 * @category CPS_CNI_0028
	 * @category addMiscCode
	 * 
	 * @param CniMiscCodeVO cniMiscCodeVO
	 *           
	 * @throws DAOException
	 */
    @SuppressWarnings("unchecked")
	public void addMiscCode(CniMiscCodeVO cniMiscCodeVO) throws DAOException, Exception {
		
        try{    
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> velParam = new HashMap<String, Object>();			
			Map<String , String> paramMap = cniMiscCodeVO.getColumnValues();			
			sqlExe.executeUpdate((ISQLTemplate) new CodeMgtDBDAOAddMiscCodeCSQL(), paramMap, velParam);            
        } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
    	
    }
		
	/**
	 * Miscellaneous Code 다건의 데이터를 일괄적으로 수정한다.<br>
	 * 
	 * @author 박제성
	 * @category CPS_CNI_0028
	 * @category modifyMiscCode
	 * 
	 * @param CniMiscCodeVO cniMiscCodeVO
	 *         
	 * @throws DAOException
	 */
    @SuppressWarnings("unchecked")
    public void modifyMiscCode(CniMiscCodeVO cniMiscCodeVO) throws DAOException {    	  
		
        try{    
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> velParam = new HashMap<String, Object>();			
			Map<String , String> paramMap = cniMiscCodeVO.getColumnValues();			
			sqlExe.executeUpdate((ISQLTemplate) new CodeMgtDBDAOModifyMiscCodeUSQL(), paramMap, velParam);            
        } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
    	
    }
    
    /**
	 * Miscellaneous Code 다건의 데이터를 일괄적으로 삭제한다.<br>
	 * 
	 * @author 박제성
	 * @category CPS_CNI_0028
	 * @category removeMiscCode
	 * 
	 * @param CniMiscCodeVO cniMiscCodeVO
	 *            
	 * @throws DAOException
	 */
    @SuppressWarnings("unchecked")
    public void removeMiscCode(CniMiscCodeVO cniMiscCodeVO) throws DAOException {    	  
		
        try{    
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> velParam = new HashMap<String, Object>();			
			Map<String , String> paramMap = cniMiscCodeVO.getColumnValues();			
			sqlExe.executeUpdate((ISQLTemplate) new CodeMgtDBDAORemoveMiscCodeDSQL(), paramMap, velParam);            
        } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
    	
    }
    
	/**
	 * DMT User별 Role 정보를 조회한다. <br> 
	 * @param CniUsrRoleMtchVO dmtUsrRoleMtchVO
	 * @return List<CniUsrRoleMtchVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CniUsrRoleMtchVO> searchCNIUserRoleInfoList(CniUsrRoleMtchVO dmtUsrRoleMtchVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CniUsrRoleMtchVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (dmtUsrRoleMtchVO != null) {
				Map<String, String> mapVO = dmtUsrRoleMtchVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				String usrRoleCd = dmtUsrRoleMtchVO.getUsrRoleCd();
				List<String> usrRoleCdList = new ArrayList<String>();
				StringTokenizer st1 = new StringTokenizer(usrRoleCd, ",");
				if(!("").equals(usrRoleCd)){
				    while (st1.hasMoreTokens()) {
				    	usrRoleCdList.add(st1.nextToken());
				    }
				    velParam.put("usr_role_cd_list", usrRoleCdList);
				}else {
					velParam.put("usr_role_cd_list", "");
				}
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CodeMgtDBDAOSearchCNIUserRoleInfoListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CniUsrRoleMtchVO.class);
			
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
	 * DMT User별 Role 정보를 생성 합니다. <br> 
	 * 
	 * @param List<CniUsrRoleMtchVO> cniUsrRoleMtchVO
	 * @throws DAOException
	 */
	public void addCNIUserRoleInfoList(List<CniUsrRoleMtchVO> cniUsrRoleMtchVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(cniUsrRoleMtchVO.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new CodeMgtDBDAOAddCNIUserRoleInfoListCSQL(), cniUsrRoleMtchVO, null);
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
	 * CNI User별 Role 정보를 삭제 합니다. <br> 
	 * 
	 * @param List<CniUsrRoleMtchVO> cniUsrRoleMtchVO
	 * @throws DAOException
	 */
	public void removeCNIUserRoleInfoList(List<CniUsrRoleMtchVO> cniUsrRoleMtchVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(cniUsrRoleMtchVO.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new CodeMgtDBDAORemoveCNIUserRoleInfoListDSQL(), cniUsrRoleMtchVO, null);
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
	 * User Role Code에 해당하는 Description을 조회한다.<br>
	 * @author 강 환
	 * @category CPS_CNI_00967
	 * @category searchRoleDesc
	 * @param String roleCd
     * @return String role_desc
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public String searchRoleDesc(String roleCd) throws DAOException {
    	String roleDesc = null;
        try{    
        	// query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            
        	//  Claim Party No
        	param.put("role_code", roleCd);
        	
        	// velocity parameter 설정 
            velParam.putAll(param);
            
            DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CodeMgtDBDAOsearchRoleDescRSQL(), param, velParam);
            if(dbRowset.next()) {
            	roleDesc = dbRowset.getString("intg_cd_val_desc");
            }
            return roleDesc;
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
       
    }    

}
