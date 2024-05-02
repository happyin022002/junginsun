/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFANoteConversionProposalDBDAO.java
*@FileTitle : Special Note Conversion
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.03
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.07.03 최성민
* 1.0 Creation
=========================================================
 * History
 * 2016.05.03 RFA 효율화를 위한 요청 (1차) (CHM-201640671)
 * 2016.07.20 [CHM-201642287] Master RFA Cancel시 Basic RFA 점검 로직 개발 요청
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfanoteconversionproposal.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.pri.rfaproposal.rfanoteconversionproposal.basic.RFANoteConversionProposalBCImpl;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfanoteconversionproposal.vo.PriRfaNoteConvListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfanoteconversionproposal.vo.RsltNoteConvVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfanoteproposal.vo.PriRpScpNoteCtntListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfanoteproposal.vo.PriRpScpNoteListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfanoteproposal.vo.RsltNoteCtntListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltRfaPropCopyVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltRoutHdrSmryListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.PriRfaNoteConvVO;
import com.hanjin.syscommon.common.table.PriRpMnVO;
import com.hanjin.syscommon.common.table.PriRpScpMnVO;
import com.hanjin.syscommon.common.table.PriRpScpNoteCtntVO;
import com.hanjin.syscommon.common.table.PriRpScpRtCmdtHdrVO;
import com.hanjin.syscommon.common.table.PriRpScpRtCmdtRnoteVO;
import com.hanjin.syscommon.common.table.PriRpScpRtCmdtRoutVO;
import com.hanjin.syscommon.common.table.PriRpScpRtCnoteVO;


/**
 * ALPS RFANoteConversionProposalDBDAO <br>
 * - ALPS-SCProposal system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author CHOI SUNG MIN
 * @see RFANoteConversionProposalBCImpl 참조
 * @since J2EE 1.6
 */
public class RFANoteConversionProposalDBDAO extends DBDAOSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * [Special Note Detail] 정보를 [조회] 합니다.<br>
	 * 
	 * @param PriRpScpNoteCtntVO priSpScpNoteCtntVO
	 * @return List<RsltNoteCtntListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltNoteCtntListVO> searchNoteContentList(PriRpScpNoteCtntVO priSpScpNoteCtntVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltNoteCtntListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSpScpNoteCtntVO != null){
				Map<String, String> mapVO = priSpScpNoteCtntVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RFANoteConversionProposalDBDAORsltNoteCtntListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltNoteCtntListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	 
	/**
	 * [Commodity Note Detail] 정보를 [조회] 합니다.<br>
	 * 
	 * @param PriRpScpRtCnoteVO priSpScpRtCnoteVO
	 * @return List<PriRpScpRtCnoteVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<PriRpScpRtCnoteVO> searchCommodityNoteContentList(PriRpScpRtCnoteVO priSpScpRtCnoteVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PriRpScpRtCnoteVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSpScpRtCnoteVO != null){
				Map<String, String> mapVO = priSpScpRtCnoteVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RFANoteConversionProposalDBDAOPriRpScpRtCnoteVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PriRpScpRtCnoteVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	 
	/**
	 * [Special Note Conversion ] 정보를 [조회] 합니다.<br>
	 * 
	 * @param PriRfaNoteConvVO priRfaNoteConvVO
	 * @return List<PriRfaNoteConvVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltNoteConvVO> searchNoteConversionList(PriRfaNoteConvVO priRfaNoteConvVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltNoteConvVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priRfaNoteConvVO != null){
				Map<String, String> mapVO = priRfaNoteConvVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RFANoteConversionProposalDBDAOPriRfaNoteConvVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltNoteConvVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	 
	 
	/**
	 * [Special Note Conversion] 정보를 [붙여넣기] 합니다.<br>
	 * 
	 * @param PriRfaNoteConvVO priRfaNoteConvVO
	 * @return List<PriRfaNoteConvVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltNoteConvVO> searchNoteConversionListCopy(PriRfaNoteConvVO priRfaNoteConvVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltNoteConvVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priRfaNoteConvVO != null){
				Map<String, String> mapVO = priRfaNoteConvVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RFANoteConversionProposalDBDAOPriRfaNoteConvCopyVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltNoteConvVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
		
	/**
	 * [Special Note Conversion] 정보를 [추가] 합니다.<br>
	 * 
	 * @param List<PriRfaNoteConvListVO> insModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addNoteConversion(List<PriRfaNoteConvListVO> insModels) throws DAOException,Exception {
        Map<String, Object> velParam = new HashMap<String, Object>();
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new RFANoteConversionProposalDBDAOPriRfaNoteConvVOCSQL(), insModels,velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return insCnt;
	}
	
	
	/**
	 * [Special Note Conversion] 정보를 [수정] 합니다.<br>
	 * 
	 * @param List<PriRfaNoteConvListVO> updModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifyNoteConversion(List<PriRfaNoteConvListVO> updModels) throws DAOException,Exception {
        Map<String, Object> velParam = new HashMap<String, Object>();
        
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new RFANoteConversionProposalDBDAOPriRfaNoteConvVOUSQL(), updModels,velParam);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return updCnt;
	}
	
    /**
     *  NOTE CONVERSION의 데이터를 삭제처리한다.<br>
     * 
     * @param PriRpScpNoteCtntVO priRpScpNoteCtntVO
     * @exception DAOException
     */
    public void removeNoteConversion (PriRpScpNoteCtntVO priRpScpNoteCtntVO) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = priRpScpNoteCtntVO.getColumnValues();

            param.putAll(mapVO);
            velParam.put("is_scope_delete", "N"); // SCOPE별 삭제시 사용
			velParam.put("is_master_delete", "N");// MASTER에서 DELETE 버튼 이벤트시 사용

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new RFANoteConversionProposalDBDAOPriRfaNoteConvVODSQL(), param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
            }                        
        } catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
    }
   	
	/**
	 * [Special Note Conversion] 정보를 [삭제] 합니다.<br>
	 * 
	 * @param List<PriRfaNoteConvListVO> delModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] removeNoteConversion(List<PriRfaNoteConvListVO> delModels) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new RFANoteConversionProposalDBDAOPriRfaNoteConvSeqVODSQL(), delModels,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return delCnt;
	}
	
	
	/**
	 * COPY된 데이터를 아이디별로 삭제한다.<br>
	 * 
	 * @param PriRfaNoteConvListVO priRfaNoteConvListVO
	 * @return int
	 * @throws DAOException
	 */
	public int removeNoteConversionCopy(PriRfaNoteConvListVO priRfaNoteConvListVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = priRfaNoteConvListVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new RFANoteConversionProposalDBDAOPriRfaNoteConvCopyVODSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to delete SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	/**
	 * Standard Note Conversion Creation 의 SHEET 데이터를 일괄적으로 COPY 한다.<br>
	 * 
	 * @param List<PriRfaNoteConvListVO> insModels
	 * @throws DAOException
	 */
	public void addNoteConversionCopy(List<PriRfaNoteConvListVO> insModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new RFANoteConversionProposalDBDAOPriRfaNoteConvCopyVOCSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	

	
	/**
	 * Note Conversion의 데이터를 AMEND SEQ +1 생성한다.<br>
	 * 
	 * @param List<PriRpMnVO> insModels
	 * @throws DAOException
	 */
	public void addProposalNoteConversionAmend(List<PriRpMnVO> insModels) throws DAOException,Exception {
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new RFANoteConversionProposalDBDAOPriRfaNoteConvAmdVOCSQL(), insModels, velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	

	/**
	 * Note Conversion의 데이터를 AMEND SEQ +1 생성한다.<br>
	 * 
	 * @param List<PriRpMnVO> insModels
	 * @throws DAOException
	 */
	public void addProposalNoteConversionAmendMst(List<PriRpMnVO> insModels) throws DAOException,Exception {
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			velParam.put("IS_MASTER", "Y");// MASTER에서 Amend 시 사용
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new RFANoteConversionProposalDBDAOPriRfaNoteConvAmdVOCSQL(), insModels, velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	

	/**
	 * Master RFA에서 가져온  Note Conversion의 데이터를 AMEND SEQ +1 생성한다.<br>
	 * 
	 * @param List<RsltRoutHdrSmryListVO> insertVoList
	 * @throws DAOException
	 */
	public void addProposalNoteConversionAmendBasic(List<RsltRoutHdrSmryListVO> insertVoList) throws DAOException,Exception {
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insertVoList.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new RFANoteConversionProposalDBDAOPriRfaNoteConvAmdBasicVOCSQL(), insertVoList, velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	
	/**
	 * Note Conversion의 데이터를 AMEND 후 Exp_Dt를 변경한다.<br>
	 * 
	 * @param List<PriRpMnVO> updModels
	 * @throws DAOException
	 */
	public void modifyProposalNoteConversionAmendExp(List<PriRpMnVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new RFANoteConversionProposalDBDAOPriRfaNoteConvAmdExpVOUSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	
	
	/**
	 * Main Duration Expire Date변경시 Conversion 의 Expire Date를 변경한다.<br>
	 * 
	 * @param List<PriRpScpMnVO> updModels
	 * @throws DAOException
	 */
	public void modifyNoteConversionExpDate(List<PriRpScpMnVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new RFANoteConversionProposalDBDAOPriRfaNoteConvExpVOUSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * Main Duration Effective Date변경시 Conversion 의 Effective Date를 변경한다.<br>
	 * 
	 * @param List<PriRpScpMnVO> updModels
	 * @throws DAOException
	 */
	public void modifyNoteConversionEffDate(List<PriRpScpMnVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new RFANoteConversionProposalDBDAOPriRfaNoteConvEffVOUSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}	
	
    /**
     * RFA Proposal Special Note Conversion 정보를 생성합니다.<br>
     * 
     * @param RsltRfaPropCopyVO rsltRfaPropCopyVO
     * @throws DAOException
     */
    public void addCopyProposalRfaNoteConversion (RsltRfaPropCopyVO rsltRfaPropCopyVO) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = rsltRfaPropCopyVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new RFANoteConversionProposalDBDAOPropCpPriRfaNoteConvCSQL(),
                    param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
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
     * RFA Proposal Rate Route Note Conversion 정보를 생성합니다.<br>
     * 
     * @param RsltRfaPropCopyVO rsltRfaPropCopyVO
     * @throws DAOException
     */
    public void addCopyProposalRoutNoteConversion (RsltRfaPropCopyVO rsltRfaPropCopyVO) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = rsltRfaPropCopyVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new RFANoteConversionProposalDBDAOPropCpPriRpScpRtCmdtRnoteConvCSQL(),
                    param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
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
     * Master RFA Proposal Rate Route Note Conversion 정보를 생성합니다.<br>
     * 
     * @param RsltRoutHdrSmryListVO vo
     * @param List<String> routSeqList
     * @throws DAOException
     */
    public void addCopyProposalRoutNoteConversionMst (RsltRoutHdrSmryListVO vo, List<String> routSeqList) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

			velParam.put("rout_seq_list", routSeqList);
			velParam.put("IS_MASTER_COPY", "Y");

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new RFANoteConversionProposalDBDAOPropCpPriRpScpRtCmdtRnoteConvCSQL(),
                    param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
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
     * RFA Proposal Rate Commodity Note Conversion 정보를 생성합니다.<br>
     * 
     * @param RsltRfaPropCopyVO rsltRfaPropCopyVO
     * @throws DAOException
     */
    public void addCopyProposalCmdtNoteConversion(RsltRfaPropCopyVO rsltRfaPropCopyVO) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = rsltRfaPropCopyVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new RFANoteConversionProposalDBDAOPropCpPriRpScpRtCnoteConvCSQL(),
                    param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
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
	 * SPECIAL NOTE GROUP정보를 수정시 CONVERSION 데이터를 삭제합니다.<br>
	 * 
	 * @param List<PriRpScpNoteListVO> updModels
	 * @exception DAOException
	 */
	public void removeNoteMasterAmend(List<PriRpScpNoteListVO> updModels) throws DAOException,Exception {
		try {				
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(updModels.size() > 0){				
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("is_scope_delete", "N"); // SCOPE별 삭제시 사용
				velParam.put("is_master_delete", "Y");// MASTER에서 DELETE 버튼 이벤트시 사용
				
				//CONVERSION 삭제
				delCnt = sqlExe.executeBatch((ISQLTemplate)new RFANoteConversionProposalDBDAOPriRfaNoteConvVODSQL(), updModels,velParam);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/*
	 * SPECIAL NOTE GROUP정보를 수정시 CONVERSION 데이터를 수정합니다.<br>
	 * 
	 * @param List<PriRpScpNoteListVO> updModels
	 * @param String masterDelChk
	 * @exception DAOException
	 */
	/*public void modifyNoteMaster(List<PriRpScpNoteListVO> updModels, String masterDelChk) throws DAOException,Exception {
		try {				
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				
				//MASTER DELETE ROW
				if(masterDelChk.equals("Y")) {
					HashMap<String, Object> velParam = new HashMap<String, Object>();
					velParam.put("is_scope_delete", "N"); // SCOPE별 삭제시 사용
					velParam.put("is_master_delete", "Y");// MASTER에서 DELETE 버튼 이벤트시 사용
					
					//CONVERSION 수정
					updCnt = sqlExe.executeBatch((ISQLTemplate)new RFANoteConversionProposalDBDAOPriRfaNoteConvAmendVOUSQL(), updModels,velParam);
					for(int i = 0; i < updCnt.length; i++){
						if(updCnt[i]== Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to insert No"+ i + " SQL");
					}									
				}
			}
			
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}*/
	
	/**
	 * SPECIAL NOTE GROUP 정보를 삭제시 CONVERSION 데이터를 삭제합니다.<br>
	 * 
	 * @param List<PriRpScpNoteListVO> delModels
	 * @exception DAOException
	 */
	public void removeNote(List<PriRpScpNoteListVO> delModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(delModels.size() > 0){
				
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("is_scope_delete", "N"); // SCOPE별 삭제시 사용
				velParam.put("is_master_delete", "Y");// MASTER에서 DELETE 버튼 이벤트시 사용
				
				//NOTE CONVERSION 삭제
				delCnt = sqlExe.executeBatch((ISQLTemplate)new RFANoteConversionProposalDBDAOPriRfaNoteConvVODSQL(), delModels, velParam);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}				
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/*
	 * SPECIAL NOTE GROUP CONTENTS정보를 변경시 CONVERSION 데이터를 변경합니다.<br>
	 * 
	 * @param List<PriRpScpNoteCtntListVO> updModels
	 * @exception DAOException
	 */
	/*public void modifyNoteContent(List<PriRpScpNoteCtntListVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			//int updCnt[] = null;
			PriRpScpNoteCtntListVO priRpScpNoteCtntListVO = new PriRpScpNoteCtntListVO();
			if(updModels.size() > 0){
				
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("is_master_delete", "N");
				
				
				 * CONTENTS SOURCE CODE가 DELETE일경우 CONVERSION의 EXP_DT, EFF_DT를 업데이트한다.
				 * LOOP로 처리 
				 
				Map<String, Object> param = new HashMap<String, Object>();
				Map<String, String> mapVO = new HashMap<String, String>();
				int result = 0;
				
				for(int i=0; i<updModels.size(); i++) {
					priRpScpNoteCtntListVO = (PriRpScpNoteCtntListVO) updModels.get(i);
					
					if(priRpScpNoteCtntListVO.getSrcInfoCd().equals("D") && priRpScpNoteCtntListVO.getAmdtSeq().equals(priRpScpNoteCtntListVO.getN1stCmncAmdtSeq())) {
						//DAO 호출
						mapVO = priRpScpNoteCtntListVO.getColumnValues();
						param.putAll(mapVO);
						
						sqlExe = new SQLExecuter("");
						result = sqlExe.executeUpdate((ISQLTemplate)new RFANoteConversionProposalDBDAOPriRfaNoteConvAmendVOUSQL(), param, velParam);
						if(result == Statement.EXECUTE_FAILED)
								throw new DAOException("Fail to insert SQL");
					}
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}*/
	
	/**
	 * SPECIAL NOTE GROUP CONTENTS정보를 삭제시 CONVERSION 데이터를 삭제합니다.<br>
	 * 
	 * @param List<PriRpScpNoteCtntListVO> delModels
	 * @exception DAOException
	 */
	public void removeNoteContent(List<PriRpScpNoteCtntListVO> delModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(delModels.size() > 0){
				
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("is_scope_delete", "N"); // SCOPE별 삭제시 사용
				velParam.put("is_master_delete", "N");// MASTER에서 DELETE 버튼 이벤트시 사용
				
				//NOTE CONVERSION 삭제
				delCnt = sqlExe.executeBatch((ISQLTemplate)new RFANoteConversionProposalDBDAOPriRfaNoteConvVODSQL(), delModels, velParam);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No"+ i + " SQL");
				}
				
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
    //////////////////////// 2009.10.27 박성수. From Rate //////////////////////////
    
    /**
     * 다건의 데이터를 일괄적으로 생성한다.<br>
     *
     * @param List<PriRfaNoteConvListVO> insModels
     * @exception DAOException
     */
    public void addRfaNoteConv(List<PriRfaNoteConvListVO> insModels) throws DAOException {
        try {
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            SQLExecuter sqlExe = new SQLExecuter("");
            int insCnt[] = null;
            if (insModels.size() > 0) {
                insCnt = sqlExe.executeBatch((ISQLTemplate) new RFANoteConversionProposalDBDAOPriRfaNoteConvVOCSQL(), insModels, velParam);
                for (int i = 0; i < insCnt.length; i++) {
                    if (insCnt[i] == Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No" + i + " SQL");
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
     * Master RFA 에서 다건의 데이터를 일괄적으로 생성한다.<br>
     *
     * @param List<PriRfaNoteConvListVO> insModels
     * @exception DAOException
     */
    public void addRfaNoteConvMst(List<PriRfaNoteConvListVO> insModels) throws DAOException {
        try {
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            SQLExecuter sqlExe = new SQLExecuter("");
			velParam.put("IS_MASTER", "Y");// MASTER에서 Amend 시 사용
            int insCnt[] = null;
            if (insModels.size() > 0) {
                insCnt = sqlExe.executeBatch((ISQLTemplate) new RFANoteConversionProposalDBDAOPriRfaNoteConvVOCSQL(), insModels, velParam);
                for (int i = 0; i < insCnt.length; i++) {
                    if (insCnt[i] == Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No" + i + " SQL");
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
     * 다건의 데이터를 일괄적으로 갱신한다.<br>
     *
     * @param List<PriRfaNoteConvListVO> updModels
     * @param String isAccept
     * @exception DAOException
     */
    public void modifyRfaNoteConv(List<PriRfaNoteConvListVO> updModels, String isAccept) throws DAOException {
        Map<String, Object> velParam = new HashMap<String, Object>();
        velParam.put("IS_ACCEPT", isAccept);

        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            int updCnt[] = null;
            if (updModels.size() > 0) {
                updCnt = sqlExe.executeBatch((ISQLTemplate) new RFANoteConversionProposalDBDAOPriRfaNoteConvVOUSQL(), updModels,
                        velParam);
                for (int i = 0; i < updCnt.length; i++) {
                    if (updCnt[i] == Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No" + i + " SQL");
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
     * Master RFA에서 다건의 데이터를 일괄적으로 갱신한다.<br>
     *
     * @param List<PriRfaNoteConvListVO> updModels
     * @param String isAccept
     * @exception DAOException
     */
    public void modifyRfaNoteConvMst(List<PriRfaNoteConvListVO> updModels, String isAccept) throws DAOException {
        Map<String, Object> velParam = new HashMap<String, Object>();
        velParam.put("IS_ACCEPT", isAccept);
		velParam.put("IS_MASTER", "Y");// MASTER에서 사용 시

        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            int updCnt[] = null;
            if (updModels.size() > 0) {
            	// RFANoteConversionProposalDBDAORtPriRfaNoteConvRnoteCascadeVODSQL
            	// 이것으로 쓰자.
                updCnt = sqlExe.executeBatch((ISQLTemplate) new RFANoteConversionProposalDBDAOPriRfaNoteConvVOUSQL(), updModels,
                        velParam);
                for (int i = 0; i < updCnt.length; i++) {
                    if (updCnt[i] == Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No" + i + " SQL");
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
     * Master RFA에서 Route 데이터를 삭제한다..<br>
     *
     * @param List<PriRpScpRtCmdtRoutVO> delModels
     * @exception DAOException
     */
    public void removeRNoteConvDelAmend(List<PriRpScpRtCmdtRoutVO> delModels) throws DAOException {
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            int updCnt[] = null;
            if (Integer.parseInt(delModels.get(0).getAmdtSeq()) > 0) {
            	velParam.put("CASCADE_LEVEL", "2");
            	velParam.put("IS_DEL_AMEND", "Y");
                velParam.put("IS_MASTER", "Y");
            	
                updCnt = sqlExe.executeBatch((ISQLTemplate) new RFANoteConversionProposalDBDAORtPriRfaNoteConvRnoteCascadeVODSQL(), delModels,
                        velParam);
                for (int i = 0; i < updCnt.length; i++) {
                    if (updCnt[i] == Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No" + i + " SQL");
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
     * 다건의 데이터를 일괄적으로 삭제한다.<br>
     *
     * @param List<PriRfaNoteConvListVO> delModels
     * @exception DAOException
     */
    public void removeRfaNoteConv(List<PriRfaNoteConvListVO> delModels) throws DAOException {
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            int delCnt[] = null;
            if (delModels.size() > 0) {
                HashMap<String, Object> velParam = new HashMap<String, Object>();

                delCnt = sqlExe.executeBatch((ISQLTemplate) new RFANoteConversionProposalDBDAOPriRfaNoteConvVODSQL(), delModels,
                        velParam);
                for (int i = 0; i < delCnt.length; i++) {
                    if (delCnt[i] == Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No" + i + " SQL");
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
     * RATE의 COMMODITY GROUP 을 DELETE할때 COMMODITY NOTE CONVERSION 데이터를 삭제한다.<br>
     *
     * @param List<PriRpScpRtCmdtHdrVO> delModels
     * @exception DAOException
     */
    public void removeCNoteConvCascadeCommodity(List<PriRpScpRtCmdtHdrVO> delModels) throws DAOException {
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            int delCnt[] = null;
            if (delModels.size() > 0) {
                HashMap<String, Object> velParam = new HashMap<String, Object>();
                velParam.put("CASCADE_LEVEL", "1");
                //20100805 무의미한 조건으로 사용하지 않기 위해서 'N'으로 설정함
                if (Integer.parseInt(delModels.get(0).getAmdtSeq()) > 0) {
                    velParam.put("IS_DEL_AMEND", "N");
                }

                delCnt = sqlExe.executeBatch((ISQLTemplate) new RFANoteConversionProposalDBDAORtPriRfaNoteConvCnoteCascadeVODSQL(), delModels,
                        velParam);
                for (int i = 0; i < delCnt.length; i++) {
                    if (delCnt[i] == Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No" + i + " SQL");
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
     * 다건의 데이터를 일괄적으로 삭제한다.<br>
     *
     * @param List<PriRpScpRtCnoteVO> delModels
     * @exception DAOException
     */
    public void removeCNoteConvCascadeCnote(List<PriRpScpRtCnoteVO> delModels) throws DAOException {
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            int delCnt[] = null;
            if (delModels.size() > 0) {
                HashMap<String, Object> velParam = new HashMap<String, Object>();
                velParam.put("CASCADE_LEVEL", "2");
                if (Integer.parseInt(delModels.get(0).getAmdtSeq()) > 0) {
                    velParam.put("IS_DEL_AMEND", "Y");
                }

                delCnt = sqlExe.executeBatch((ISQLTemplate) new RFANoteConversionProposalDBDAORtPriRfaNoteConvCnoteCascadeVODSQL(), delModels,
                        velParam);
                for (int i = 0; i < delCnt.length; i++) {
                    if (delCnt[i] == Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No" + i + " SQL");
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
     * RATE의 ROUTE DETAIL 을 DELETE할때 ROUTE NOTE CONVERSION 데이터를 삭제한다.<br>
     *
     * @param List<PriRpScpRtCmdtHdrVO> delModels
     * @exception DAOException
     */
    public void removeRNoteConvCascadeCommodity(List<PriRpScpRtCmdtHdrVO> delModels) throws DAOException {
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            int delCnt[] = null;
            if (delModels.size() > 0) {
                HashMap<String, Object> velParam = new HashMap<String, Object>();
                velParam.put("CASCADE_LEVEL", "1");

                //20100805 무의미한 조건으로 사용하지 않기 위해서 'N'으로 설정함
                if (Integer.parseInt(delModels.get(0).getAmdtSeq()) > 0) {
                    velParam.put("IS_DEL_AMEND", "N");
                }

                delCnt = sqlExe.executeBatch((ISQLTemplate) new RFANoteConversionProposalDBDAORtPriRfaNoteConvRnoteCascadeVODSQL(), delModels,
                        velParam);
                for (int i = 0; i < delCnt.length; i++) {
                    if (delCnt[i] == Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No" + i + " SQL");
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
     * 다건의 데이터를 일괄적으로 삭제한다.<br>
     *
     * @param List<PriRpScpRtCmdtRoutVO> delModels
     * @exception DAOException
     */
    public void removeRNoteConvCascadeRoute(List<PriRpScpRtCmdtRoutVO> delModels) throws DAOException {
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            int delCnt[] = null;
            if (delModels.size() > 0) {
                HashMap<String, Object> velParam = new HashMap<String, Object>();
                velParam.put("CASCADE_LEVEL", "2");
                if (Integer.parseInt(delModels.get(0).getAmdtSeq()) > 0) {
                    velParam.put("IS_DEL_AMEND", "Y");
                }

                delCnt = sqlExe.executeBatch((ISQLTemplate) new RFANoteConversionProposalDBDAORtPriRfaNoteConvRnoteCascadeVODSQL(), delModels,
                        velParam);
                for (int i = 0; i < delCnt.length; i++) {
                    if (delCnt[i] == Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No" + i + " SQL");
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
     * Master RFA에서 다건의 데이터를 일괄적으로 삭제한다.<br>
     *
     * @param List<PriRpScpRtCmdtRoutVO> delModels
     * @exception DAOException
     */
    public void removeRNoteConvCascadeRouteMst(List<PriRpScpRtCmdtRoutVO> delModels) throws DAOException {
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            int delCnt[] = null;
            if (delModels.size() > 0) {
                HashMap<String, Object> velParam = new HashMap<String, Object>();
                velParam.put("CASCADE_LEVEL", "2");
                velParam.put("IS_ACCEPT", "N");
                if (Integer.parseInt(delModels.get(0).getAmdtSeq()) > 0) {
                    velParam.put("IS_DEL_AMEND", "Y");
                }
                // Master RFA에서 수행
                velParam.put("IS_MASTER", "Y");
                delCnt = sqlExe.executeBatch((ISQLTemplate) new RFANoteConversionProposalDBDAORtPriRfaNoteConvRnoteCascadeVODSQL(), delModels,
                        velParam);
                for (int i = 0; i < delCnt.length; i++) {
                    if (delCnt[i] == Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No" + i + " SQL");
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
     * 다건의 데이터를 일괄적으로 삭제한다.<br>
     *
     * @param List<PriRpScpRtCmdtRnoteVO> delModels
     * @exception DAOException
     */
    public void removeRNoteConvCascadeRnote(List<PriRpScpRtCmdtRnoteVO> delModels) throws DAOException {
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            int delCnt[] = null;
            if (delModels.size() > 0) {
                HashMap<String, Object> velParam = new HashMap<String, Object>();
                velParam.put("CASCADE_LEVEL", "3");
                if (Integer.parseInt(delModels.get(0).getAmdtSeq()) > 0) {
                    velParam.put("IS_DEL_AMEND", "Y");
                }

                delCnt = sqlExe.executeBatch((ISQLTemplate) new RFANoteConversionProposalDBDAORtPriRfaNoteConvRnoteCascadeVODSQL(), delModels,
                        velParam);
                for (int i = 0; i < delCnt.length; i++) {
                    if (delCnt[i] == Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No" + i + " SQL");
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
	 * Proposal Cancel시 Conversion을 삭제한다.<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @exception EventException
	 */
    public void removeProposalConversion (PriRpMnVO priRpMnVO) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = priRpMnVO.getColumnValues();
            param.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new RFANoteConversionProposalDBDAOPriRfaPropConvVODSQL(), param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to delete SQL");
            }                        
        } catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
    }    
    
	/**
	 * Master RFA의 Note Conversion 정보를 [추가/수정] 합니다.<br>
	 * 
	 * @param PriRfaNoteConvListVO insModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void mergeMstNoteConversion(PriRfaNoteConvListVO insModels) throws DAOException,Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = insModels.getColumnValues();
            param.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new RFANoteConversionProposalDBDAOPriMstRfaPropConvVOCSQL(), param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to delete SQL");
            }                        
        } catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
    }
}