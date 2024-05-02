/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCNoteConversionProposalDBDAO.java
*@FileTitle : Special Note Conversion
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.03
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.07.03 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scnoteconversionproposal.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.pri.scguideline.scbasicstandardnoteguideline.vo.RsltPriSgStndNoteHdrCopyVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scnoteconversionproposal.basic.SCNoteConversionProposalBCImpl;
import com.hanjin.apps.alps.esm.pri.scproposal.scnoteconversionproposal.vo.PriScNoteConvListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scnoteconversionproposal.vo.PriSpMnConvAuthFlagVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scnoteconversionproposal.vo.RsltNoteConvVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scnoteproposal.vo.PriSpScpNoteCtntListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scnoteproposal.vo.PriSpScpNoteListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scnoteproposal.vo.RsltNoteCtntListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltPropCopyVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo.RsltRtCnoteListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriScNoteConvVO;
import com.hanjin.syscommon.common.table.PriSgStndNoteCtntVO;
import com.hanjin.syscommon.common.table.PriSpMnVO;
import com.hanjin.syscommon.common.table.PriSpScpMnVO;
import com.hanjin.syscommon.common.table.PriSpScpNoteCtntVO;
import com.hanjin.syscommon.common.table.PriSpScpRtCmdtHdrVO;
import com.hanjin.syscommon.common.table.PriSpScpRtCmdtRnoteVO;
import com.hanjin.syscommon.common.table.PriSpScpRtCmdtRoutVO;
import com.hanjin.syscommon.common.table.PriSpScpRtCnoteVO;


/**
 * ALPS SCNoteConversionProposalDBDAO <br>
 * - ALPS-SCProposal system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author CHOI SUNG MIN
 * @see SCNoteConversionProposalBCImpl 참조
 * @since J2EE 1.6
 */
public class SCNoteConversionProposalDBDAO extends DBDAOSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * [Special Note Detail] 정보를 [조회] 합니다.<br>
	 * 
	 * @param PriSpScpNoteCtntVO priSpScpNoteCtntVO
	 * @return List<RsltNoteCtntListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltNoteCtntListVO> searchNoteContentList(PriSpScpNoteCtntVO priSpScpNoteCtntVO) throws DAOException {
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCNoteConversionProposalDBDAORsltNoteCtntListVORSQL(), param, velParam);
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
	 * @param PriSpScpRtCnoteVO priSpScpRtCnoteVO
	 * @return List<RsltRtCnoteListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltRtCnoteListVO> searchCommodityNoteContentList(PriSpScpRtCnoteVO priSpScpRtCnoteVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRtCnoteListVO> list = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCNoteConversionProposalDBDAOPriSpScpRtCnoteVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltRtCnoteListVO .class);
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
	 * @param PriSpScpRtCnoteVO priSpScpRtCnoteVO
	 * @return List<RsltRtCnoteListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltRtCnoteListVO> searchCommodityNoteContentInquiryList(PriSpScpRtCnoteVO priSpScpRtCnoteVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRtCnoteListVO> list = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCNoteConversionProposalDBDAOPriSpScpRtCnoteInquiryVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltRtCnoteListVO .class);
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
	 * @param PriScNoteConvVO priScNoteConvVO
	 * @return List<RsltNoteConvVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltNoteConvVO> searchNoteConversionList(PriScNoteConvVO priScNoteConvVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltNoteConvVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priScNoteConvVO != null){
				Map<String, String> mapVO = priScNoteConvVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCNoteConversionProposalDBDAOPriScNoteConvVORSQL(), param, velParam);
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
	 * @param PriScNoteConvVO priScNoteConvVO
	 * @return List<RsltNoteConvVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltNoteConvVO> searchNoteConversionListCopy(PriScNoteConvVO priScNoteConvVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltNoteConvVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priScNoteConvVO != null){
				Map<String, String> mapVO = priScNoteConvVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCNoteConversionProposalDBDAOPriScNoteConvCopyVORSQL(), param, velParam);
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
	 * @param List<PriScNoteConvListVO> insModels
	 * @exception DAOException
	 * @exception Exception
	 */
	public void addNoteConversion(List<PriScNoteConvListVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SCNoteConversionProposalDBDAOPriScNoteConvVOCSQL(), insModels,null);
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
	 * [Special Note Conversion] 정보를 [수정] 합니다.<br>
	 * 
	 * @param List<PriScNoteConvListVO> updModels
	 * @exception DAOException
	 * @exception Exception
	 */
	public void modifyNoteConversion(List<PriScNoteConvListVO> updModels) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SCNoteConversionProposalDBDAOPriScNoteConvVOUSQL(), updModels,null);
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
	}
	
	/**
	 * [Special Note Conversion] 정보를 [삭제] 합니다.<br>
	 * 
	 * @param List<PriScNoteConvListVO> delModels
	 * @exception DAOException
	 * @exception Exception
	 */
	public void removeNoteConversion(List<PriScNoteConvListVO> delModels) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new SCNoteConversionProposalDBDAOPriScNoteConvVODSQL(), delModels,null);
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
	}
	
	
	/**
	 * COPY된 데이터를 아이디별로 삭제한다.<br>
	 * 
	 * @param PriScNoteConvListVO priScNoteConvListVO
	 * @return int
	 * @exception DAOException
	 */
	public int removeNoteConversionCopy(PriScNoteConvListVO priScNoteConvListVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = priScNoteConvListVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new SCNoteConversionProposalDBDAOPriScNoteConvCopyVODSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
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
	 * @param List<PriScNoteConvListVO> insModels
	 * @exception DAOException
	 */
	public void addNoteConversionCopy(List<PriScNoteConvListVO> insModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SCNoteConversionProposalDBDAOPriScNoteConvCopyVOCSQL(), insModels,null);
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
	 * CONVERSION 데이터를 생성한다.<br>
	 * 
	 * @param List<PriSpMnVO> insModels
	 * @exception DAOException
	 */
	public void addProposalNoteConversionAmend(List<PriSpMnVO> insModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SCNoteConversionProposalDBDAOPriScNoteConvAmdVOCSQL(), insModels,null);
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
	 * Main Duration Expire Date 변경시 Conversion 의 Expire Date를 수정 한다.<br>
	 * 
	 * @param List<PriSpScpMnVO> updModels
	 * @exception DAOException
	 */
	public void modifyNoteConversionExpDate(List<PriSpScpMnVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SCNoteConversionProposalDBDAOPriScNoteConvExpVOUSQL(), updModels,null);
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
	}	
	
	/**
	 * Duration Effective Date 변경시 Conversion 의 Effective Date를 수정 한다.<br>
	 * 
	 * @param List<PriSpScpMnVO> updModels
	 * @exception DAOException
	 */
	public void modifyNoteConversionEffDate(List<PriSpScpMnVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SCNoteConversionProposalDBDAOPriScNoteConvEffVOUSQL(), updModels,null);
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
	}		
	
	
    /**
     * S/C Proposal Special Note Conversion 데이터를 생성합니다.<br>
     * 
     * @param RsltPropCopyVO rsltPropCopyVO
     * @exception DAOException
     */
    public void addCopyProposalScNoteConversion (RsltPropCopyVO rsltPropCopyVO) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = rsltPropCopyVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new SCNoteConversionProposalDBDAOPropCpPriScNoteConvCSQL(),
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
     * S/C Proposal Route Note Conversion 데이터를 생성합니다.<br>
     * 
     * @param RsltPropCopyVO rsltPropCopyVO
     * @exception DAOException
     */
    public void addCopyProposalRoutNoteConversion (RsltPropCopyVO rsltPropCopyVO) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = rsltPropCopyVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new SCNoteConversionProposalDBDAOPropCpPriSpScpRtCmdtRnoteConvCSQL(),
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
     * S/C Proposal Commodity Note Conversion 데이터를 생성합니다.<br>
     * 
     * @param RsltPropCopyVO rsltPropCopyVO
     * @exception DAOException
     */
    public void addCopyProposalCmdtNoteConversion(RsltPropCopyVO rsltPropCopyVO) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = rsltPropCopyVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new SCNoteConversionProposalDBDAOPropCpPriSpScpRtCnoteConvCSQL(),
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
     *  SCOPE에 해당하는 모든 CONVERSION 데이터를 삭제처리한다.<br>
     * 
     * @param PriSpScpMnVO priSpScpMnVO
     * @exception DAOException
     */
    public void removeProposalConversion (PriSpScpMnVO priSpScpMnVO) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = priSpScpMnVO.getColumnValues();

            param.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new SCNoteConversionProposalDBDAOPriScNoteConvAllVODSQL(), param, velParam);
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
     *  NOTE CONVERSION의 데이터를 삭제처리한다.<br>
     * 
     * @param PriSpScpNoteCtntVO priSpScpNoteCtntVO
     * @exception DAOException
     */
    public void removeNoteConversion (PriSpScpNoteCtntVO priSpScpNoteCtntVO) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = priSpScpNoteCtntVO.getColumnValues();

            param.putAll(mapVO);
            velParam.put("is_scope_delete", "N"); // SCOPE별 삭제시 사용
			velParam.put("is_master_delete", "N");// MASTER에서 DELETE 버튼 이벤트시 사용

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new SCNoteConversionProposalDBDAOPriScNoteConvVODSQL(), param, velParam);
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
	 * Special Note Conversion 정보를 삭제한다.<br>
	 * 
	 * @param List<PriSpScpNoteListVO> delModels
	 * @exception DAOException
	 */
	public void removeNote(List<PriSpScpNoteListVO> delModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(delModels.size() > 0){
				
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("is_scope_delete", "N"); 	// SCOPE별 삭제시 사용
				velParam.put("is_type_delete", "N");	// TYPE별 삭제시 사용
				velParam.put("is_master_delete", "Y");	// MASTER에서 DELETE 버튼 이벤트시 사용
				
				//NOTE CONVERSION 삭제
				delCnt = sqlExe.executeBatch((ISQLTemplate)new SCNoteConversionProposalDBDAOPriScNoteConvGrpVODSQL(), delModels, velParam);
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
	
	/**
	 * Special Note Conversion 삭제한다.<br>
	 * 
	 * @param List<PriSpScpNoteListVO> updModels
	 * @param String masterDelChk
	 * @exception DAOException
	 */
	public void removeNoteMaster(List<PriSpScpNoteListVO> updModels, String masterDelChk) throws DAOException,Exception {
		try {				
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(updModels.size() > 0){
				
				//MASTER DELETE ROW
				if(masterDelChk.equals("Y")) {
					HashMap<String, Object> velParam = new HashMap<String, Object>();
					velParam.put("is_scope_delete", "N"); 	// SCOPE별 삭제시 사용
					velParam.put("is_type_delete", "N");	// TYPE별 삭제시 사용
					velParam.put("is_master_delete", "Y");	// MASTER에서 DELETE 버튼 이벤트시 사용
					
					//NOTE CONVERSION 삭제
					delCnt = sqlExe.executeBatch((ISQLTemplate)new SCNoteConversionProposalDBDAOPriScNoteConvVODSQL(), updModels, velParam);
					for(int i = 0; i < delCnt.length; i++){
						if(delCnt[i]== Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to delete No"+ i + " SQL");
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
	}
	
	/**
	 * Special Note Conversion 정보를 삭제한다.<br>
	 * 
	 * @param List<PriSpScpNoteListVO> updModels
	 * @exception DAOException
	 */
	public void removeNoteMasterAmend(List<PriSpScpNoteListVO> updModels) throws DAOException,Exception {
		try {				
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(updModels.size() > 0){
				
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("is_master_delete", "Y");	// MASTER에서 DELETE 버튼 이벤트시 사용
				
				//NOTE CONVERSION 삭제(CONVERSION.EFF_DT > AMEND.EXP_DT)
				delCnt = sqlExe.executeBatch((ISQLTemplate)new SCNoteConversionProposalDBDAOPriSpScpNoteConvAmendDSQL(), updModels, velParam);
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
	
	/**
	 * Special Note Conversion 정보를 갱신한다.<br>
	 * 
	 * @param List<PriSpScpNoteListVO> updModels
	 * @param String masterDelChk
	 * @exception DAOException
	 */
	public void modifyNoteMaster(List<PriSpScpNoteListVO> updModels, String masterDelChk) throws DAOException,Exception {
		try {				
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				
				//MASTER DELETE ROW
				if(masterDelChk.equals("Y")) {
					HashMap<String, Object> velParam = new HashMap<String, Object>();
					velParam.put("is_scope_delete", "N"); 	// SCOPE별 삭제시 사용
					velParam.put("is_type_delete", "N");	// TYPE별 삭제시 사용
					velParam.put("is_master_delete", "Y");	// MASTER에서 DELETE 버튼 이벤트시 사용
					
					//NOTE CONVERSION 수정(날짜 변경)
					updCnt = sqlExe.executeBatch((ISQLTemplate)new SCNoteConversionProposalDBDAOPriSpScpNoteConvAmendUSQL(), updModels, velParam);
					for(int i = 0; i < updCnt.length; i++){
						if(updCnt[i]== Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to update No"+ i + " SQL");
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
	}
	
	
	/**
	 * Special Note Content 갱신시 Conversion 정보를 삭제한다.<br>
	 * 
	 * @param PriSpScpNoteCtntListVO priSpScpNoteCtntListVO
	 * @exception DAOException
	 */
	public void removeNoteContentAmend(PriSpScpNoteCtntListVO priSpScpNoteCtntListVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = priSpScpNoteCtntListVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.put("is_master_delete", "N");
			velParam.put("action_mode", priSpScpNoteCtntListVO.getActionMode());
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new SCNoteConversionProposalDBDAOPriSpScpNoteConvAmendDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Special Note Content 갱신시 Conversion 정보를 수정한다.<br>
	 * 
	 * @param PriSpScpNoteCtntListVO priSpScpNoteCtntListVO
	 * @exception DAOException
	 */
	public void modifyNoteContentAmend(PriSpScpNoteCtntListVO priSpScpNoteCtntListVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = priSpScpNoteCtntListVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.put("is_master_delete", "N");
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new SCNoteConversionProposalDBDAOPriSpScpNoteConvAmendUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Special Note Content 갱신시 Conversion 정보를 추가한다.<br>
	 * 
	 * @param PriSpScpNoteCtntListVO priSpScpNoteCtntListVO
	 * @exception DAOException
	 */
	public void addNoteContentAmend(PriSpScpNoteCtntListVO priSpScpNoteCtntListVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = priSpScpNoteCtntListVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.put("is_master_delete", "N");
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new SCNoteConversionProposalDBDAOPriSpScpNoteConvAmendCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	

	/*
	 * Special Note Conversion 정보를 갱신한다.<br>
	 * 
	 * @param List<PriSpScpNoteCtntListVO> updModels
	 * @exception DAOException
	 */
	/*public void modifyNoteContent(List<PriSpScpNoteCtntListVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updModels.size() > 0){
				// query parameter
		        Map<String, Object> param = new HashMap<String, Object>();
		        // velocity parameter		       				
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("is_master_delete", "N");
				
				////////////////////////////////////////////////////////////////////////////////
				//CONVERSION 
				PriSpScpNoteCtntListVO priSpScpNoteCtntListVO = new PriSpScpNoteCtntListVO();				
				Map<String, String> mapConvVO = null;
				
				
				for(int i = 0; i<updModels.size(); i++) {
					priSpScpNoteCtntListVO = updModels.get(i);
					
					////////////
					// 11-COMMAND01 : AMEND
					// 12-COMMAND02 : AMEND CANCEL
					//  8-IBDELETE : AMEND DELETE
					
					mapConvVO = priSpScpNoteCtntListVO.getColumnValues();
		            param.putAll(mapConvVO);
		            velParam.putAll(mapConvVO);
		            
					if("11".equals(priSpScpNoteCtntListVO.getActionMode())) {				            
			            //1. 날짜가 포함되어 있지 않으면 삭제
			            sqlExe = new SQLExecuter("");
			            int result = sqlExe.executeUpdate((ISQLTemplate) new SCNoteConversionProposalDBDAOPriSpScpNoteConvAmendDSQL(), param, velParam);
			            if (result == Statement.EXECUTE_FAILED) {
			                throw new DAOException("Fail to delete SQL");
			            }
			            
			            //2.날짜 변경
			            sqlExe = new SQLExecuter("");
			            result = sqlExe.executeUpdate((ISQLTemplate) new SCNoteConversionProposalDBDAOPriSpScpNoteConvAmendUSQL(), param, velParam);
			            if (result == Statement.EXECUTE_FAILED) {
			                throw new DAOException("Fail to update SQL");
			            }
			            
						
					} else if("12".equals(priSpScpNoteCtntListVO.getActionMode())) {							
						//1. 기존데이터 삭제
						sqlExe = new SQLExecuter("");
						int result = sqlExe.executeUpdate((ISQLTemplate) new SCNoteConversionProposalDBDAOPriSpScpNoteConvAmendDSQL(), param, velParam);
						if (result == Statement.EXECUTE_FAILED) {
							throw new DAOException("Fail to delete SQL");
						}
						//2. 원복
						sqlExe = new SQLExecuter("");
			            result = sqlExe.executeUpdate((ISQLTemplate) new SCNoteConversionProposalDBDAOPriSpScpNoteConvAmendCSQL(), param, velParam);
			            if (result == Statement.EXECUTE_FAILED) {
			                throw new DAOException("Fail to insert SQL");
			            }
						
					} else if("8".equals(priSpScpNoteCtntListVO.getActionMode())) {
						//1. 날짜가 포함되어 있지 않으면 삭제
			            sqlExe = new SQLExecuter("");
			            int result = sqlExe.executeUpdate((ISQLTemplate) new SCNoteConversionProposalDBDAOPriSpScpNoteConvAmendDSQL(), param, velParam);
			            if (result == Statement.EXECUTE_FAILED) {
			                throw new DAOException("Fail to delete SQL");
			            }
			            
			            //2.날짜 변경
			            sqlExe = new SQLExecuter("");
			            result = sqlExe.executeUpdate((ISQLTemplate) new SCNoteConversionProposalDBDAOPriSpScpNoteConvAmendUSQL(), param, velParam);
			            if (result == Statement.EXECUTE_FAILED) {
			                throw new DAOException("Fail to update SQL");
			            }
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
	 * Special Note Conversion 정보를 삭제한다.<br>
	 * 
	 * @param List<PriSpScpNoteCtntListVO> delModels
	 * @exception DAOException
	 */
	public void removeNoteContent(List<PriSpScpNoteCtntListVO> delModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(delModels.size() > 0){
				
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("is_scope_delete", "N"); 	// SCOPE별 삭제시 사용
				velParam.put("is_type_delete", "N");	// TYPE별 삭제시 사용
				velParam.put("is_master_delete", "N");	// MASTER에서 DELETE 버튼 이벤트시 사용
				
				delCnt = sqlExe.executeBatch((ISQLTemplate)new SCNoteConversionProposalDBDAOPriScNoteConvGrpVODSQL(), delModels, velParam);
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
	
	/**
     * S/C Standard Note Copy 시 Conversion 데이터를 생성합니다.<br>
     * 
     * @param RsltPriSgStndNoteHdrCopyVO rsltPriSgStndNoteHdrCopyVO
     * @exception DAOException
     */
    public void addCopyScStndNoteConversion (RsltPriSgStndNoteHdrCopyVO rsltPriSgStndNoteHdrCopyVO) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = rsltPriSgStndNoteHdrCopyVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new SCNoteConversionProposalDBDAOPriScStandardNoteConvCopyCSQL(),
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
	 * STANDARD NOTE에서 CTNT 삭제시 해당 CONVERSION 삭제한다.<br>
	 * 
	 * @param PriSgStndNoteCtntVO priSgStndNoteCtntVO
	 * @return int
	 * @exception DAOException
	 */
	public int removeScStndNoteConversion(PriSgStndNoteCtntVO priSgStndNoteCtntVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = priSgStndNoteCtntVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new SCNoteConversionProposalDBDAOPriScStandardNoteConvDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
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
     * S/C Standard Note DURATION UPDATE 시 Conversion DURATION 를 수정합니다.<br>
     * 
     * @param RsltPriSgStndNoteHdrCopyVO rsltPriSgStndNoteHdrCopyVO
     * @exception DAOException
     */
	public void modifyDurationScStndNoteConversion(RsltPriSgStndNoteHdrCopyVO rsltPriSgStndNoteHdrCopyVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = rsltPriSgStndNoteHdrCopyVO.getColumnValues();
			
			param.putAll(mapVO);
            velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new SCNoteConversionProposalDBDAOPriScStandardNoteConvDurationUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
    /**
     *  Filing시 Conversion 의 Effective Date를 수정한다.<br>
     * 
     * @param PriSpMnVO priSpMnVO
     * @exception DAOException
     */
	public void modifyNoteConversionEffDateFiling(PriSpMnVO priSpMnVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = priSpMnVO.getColumnValues();
			
			param.putAll(mapVO);
            velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new SCNoteConversionProposalDBDAOPriScNoteConvEffFilingVOUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to Update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	
    /**
     *  Commodity Note 수정시 Conversion의 EffDt/ExpDt를 조정한다.<br>
     * 
     * @param List<PriSpScpRtCnoteVO> updModels
     * @exception DAOException
     */
	public void modifyNoteConversionDurationCascadeCNote(List<PriSpScpRtCnoteVO> updModels) throws DAOException,Exception {
		Map<String, Object> velParam = new HashMap<String, Object>();
		velParam.put("CASCADE_LEVEL", "2");

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (updModels.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new SCNoteConversionProposalDBDAOAdjNoteDurCasCNoteUSQL(), updModels,
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
     *  Commodity 수정시 Conversion의 EffDt/ExpDt를 조정한다.<br>
     * 
     * @param List<PriSpScpRtCmdtHdrVO> updModels
     * @exception DAOException
     */
	public void modifyNoteConversionDurationCascadeCommodityCNote(List<PriSpScpRtCmdtHdrVO> updModels) throws DAOException,Exception {
		Map<String, Object> velParam = new HashMap<String, Object>();
		velParam.put("CASCADE_LEVEL", "1");

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (updModels.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new SCNoteConversionProposalDBDAOAdjNoteDurCasCNoteUSQL(), updModels,
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
     *  Route Note 수정시 Conversion의 EffDt/ExpDt를 조정한다.<br>
     * 
     * @param List<PriSpScpRtCmdtRnoteVO> updModels
     * @exception DAOException
     */
	public void modifyNoteConversionDurationCascadeRNote(List<PriSpScpRtCmdtRnoteVO> updModels) throws DAOException,Exception {
		Map<String, Object> velParam = new HashMap<String, Object>();
		velParam.put("CASCADE_LEVEL", "3");

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (updModels.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new SCNoteConversionProposalDBDAOAdjNoteDurCasRNoteUSQL(), updModels,
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
     *  Route 수정시 Conversion의 EffDt/ExpDt를 조정한다.<br>
     * 
     * @param List<PriSpScpRtCmdtRoutVO> updModels
     * @exception DAOException
     */
	public void modifyNoteConversionDurationCascadeRouteRNote(List<PriSpScpRtCmdtRoutVO> updModels) throws DAOException,Exception {
		Map<String, Object> velParam = new HashMap<String, Object>();
		velParam.put("CASCADE_LEVEL", "2");

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (updModels.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new SCNoteConversionProposalDBDAOAdjNoteDurCasRNoteUSQL(), updModels,
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
     *  Commodity 수정시 Conversion의 EffDt/ExpDt를 조정한다.<br>
     * 
     * @param List<PriSpScpRtCmdtHdrVO> updModels
     * @exception DAOException
     */
	public void modifyNoteConversionDurationCascadeCommodityRNote(List<PriSpScpRtCmdtHdrVO> updModels) throws DAOException,Exception {
		Map<String, Object> velParam = new HashMap<String, Object>();
		velParam.put("CASCADE_LEVEL", "1");

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (updModels.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new SCNoteConversionProposalDBDAOAdjNoteDurCasRNoteUSQL(), updModels,
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
     *  Commodity Note 수정시 Conversion의 EffDt/ExpDt를 조정한다.<br>
     * 
     * @param List<PriSpScpRtCnoteVO> updModels
     * @exception DAOException
     */
	public void addCopyNoteConversionCascadeCNote(List<PriSpScpRtCnoteVO> updModels) throws DAOException,Exception {
		Map<String, Object> velParam = new HashMap<String, Object>();
		velParam.put("CASCADE_LEVEL", "2");

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (updModels.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new SCNoteConversionProposalDBDAOCpPrevNoteCasCNoteCSQL(), updModels,
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
     *  Commodity 수정시 Conversion의 EffDt/ExpDt를 조정한다.<br>
     * 
     * @param List<PriSpScpRtCmdtHdrVO> updModels
     * @exception DAOException
     */
	public void addCopyNoteConversionCascadeCommodityCNote(List<PriSpScpRtCmdtHdrVO> updModels) throws DAOException,Exception {
		Map<String, Object> velParam = new HashMap<String, Object>();
		velParam.put("CASCADE_LEVEL", "1");

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (updModels.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new SCNoteConversionProposalDBDAOCpPrevNoteCasCNoteCSQL(), updModels,
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
     *  Route Note 수정시 Conversion의 EffDt/ExpDt를 조정한다.<br>
     * 
     * @param List<PriSpScpRtCmdtRnoteVO> updModels
     * @exception DAOException
     */
	public void addCopyNoteConversionCascadeRNote(List<PriSpScpRtCmdtRnoteVO> updModels) throws DAOException,Exception {
		Map<String, Object> velParam = new HashMap<String, Object>();
		velParam.put("CASCADE_LEVEL", "3");

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (updModels.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new SCNoteConversionProposalDBDAOCpPrevNoteCasRNoteCSQL(), updModels,
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
     *  Route 수정시 Conversion의 EffDt/ExpDt를 조정한다.<br>
     * 
     * @param List<PriSpScpRtCmdtRoutVO> updModels
     * @exception DAOException
     */
	public void addCopyNoteConversionCascadeRouteRNote(List<PriSpScpRtCmdtRoutVO> updModels) throws DAOException,Exception {
		Map<String, Object> velParam = new HashMap<String, Object>();
		velParam.put("CASCADE_LEVEL", "2");

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (updModels.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new SCNoteConversionProposalDBDAOCpPrevNoteCasRNoteCSQL(), updModels,
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
     *  Commodity 수정시 Conversion의 EffDt/ExpDt를 조정한다.<br>
     * 
     * @param List<PriSpScpRtCmdtHdrVO> updModels
     * @exception DAOException
     */
	public void addCopyNoteConversionCascadeCommodityRNote(List<PriSpScpRtCmdtHdrVO> updModels) throws DAOException,Exception {
		Map<String, Object> velParam = new HashMap<String, Object>();
		velParam.put("CASCADE_LEVEL", "1");

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (updModels.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new SCNoteConversionProposalDBDAOCpPrevNoteCasRNoteCSQL(), updModels,
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
     *  Commodity Note 수정시 Conversion의 EffDt/ExpDt를 조정한다.<br>
     * 
     * @param List<PriSpScpRtCnoteVO> updModels
     * @exception DAOException
     */
	public void removeNoteConversionCascadeCNote(List<PriSpScpRtCnoteVO> updModels) throws DAOException,Exception {
		Map<String, Object> velParam = new HashMap<String, Object>();
		velParam.put("CASCADE_LEVEL", "2");

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (updModels.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new SCNoteConversionProposalDBDAODelNoteCasCNoteDSQL(), updModels,
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
     *  Commodity 수정시 Conversion의 EffDt/ExpDt를 조정한다.<br>
     * 
     * @param List<PriSpScpRtCmdtHdrVO> updModels
     * @exception DAOException
     */
	public void removeNoteConversionCascadeCommodityCNote(List<PriSpScpRtCmdtHdrVO> updModels) throws DAOException,Exception {
		Map<String, Object> velParam = new HashMap<String, Object>();
		velParam.put("CASCADE_LEVEL", "1");

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (updModels.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new SCNoteConversionProposalDBDAODelNoteCasCNoteDSQL(), updModels,
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
     *  Route Note 수정시 Conversion의 EffDt/ExpDt를 조정한다.<br>
     * 
     * @param List<PriSpScpRtCmdtRnoteVO> updModels
     * @exception DAOException
     */
	public void removeNoteConversionCascadeRNote(List<PriSpScpRtCmdtRnoteVO> updModels) throws DAOException,Exception {
		Map<String, Object> velParam = new HashMap<String, Object>();
		velParam.put("CASCADE_LEVEL", "3");

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (updModels.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new SCNoteConversionProposalDBDAODelNoteCasRNoteDSQL(), updModels,
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
     *  Route 수정시 Conversion의 EffDt/ExpDt를 조정한다.<br>
     * 
     * @param List<PriSpScpRtCmdtRoutVO> updModels
     * @exception DAOException
     */
	public void removeNoteConversionCascadeRouteRNote(List<PriSpScpRtCmdtRoutVO> updModels) throws DAOException,Exception {
		Map<String, Object> velParam = new HashMap<String, Object>();
		velParam.put("CASCADE_LEVEL", "2");

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (updModels.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new SCNoteConversionProposalDBDAODelNoteCasRNoteDSQL(), updModels,
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
     *  Commodity 수정시 Conversion의 EffDt/ExpDt를 조정한다.<br>
     * 
     * @param List<PriSpScpRtCmdtHdrVO> updModels
     * @exception DAOException
     */
	public void removeNoteConversionCascadeCommodityRNote(List<PriSpScpRtCmdtHdrVO> updModels) throws DAOException,Exception {
		Map<String, Object> velParam = new HashMap<String, Object>();
		velParam.put("CASCADE_LEVEL", "1");

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (updModels.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new SCNoteConversionProposalDBDAODelNoteCasRNoteDSQL(), updModels,
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
     * 헤더 테이블에서 이행데이터 타입 정보를 조회한다.<br>
     * @param PriScNoteConvVO priScNoteConvVO
     * @return String
     * @throws DAOException
     */
    public String searchCreationTypeCode (PriScNoteConvVO priScNoteConvVO) throws DAOException {
        DBRowSet dbRowset = null;
        String prcPropCreTpCd = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
        	if(priScNoteConvVO != null){
				Map<String, String> mapVO = priScNoteConvVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCNoteConversionProposalDBDAOPriSpHdrCreationTypeCdRSQL(), param,
                    velParam);
            if (dbRowset.next()) {
            	prcPropCreTpCd = dbRowset.getString(1);
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(),se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
        return prcPropCreTpCd;
    }
    
	
    /**
     * Legacy I/F Flag 정보를 조회한다.<br>
     * @param PriScNoteConvVO priScNoteConvVO
     * @return String
     * @throws DAOException
     */
    public String searchLegacyIfFlag (PriScNoteConvVO priScNoteConvVO) throws DAOException {
        DBRowSet dbRowset = null;
        String prcPropCreTpCd = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
        	if(priScNoteConvVO != null){
				Map<String, String> mapVO = priScNoteConvVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCNoteConversionProposalDBDAOPriSpMnLgcyIfFlgRSQL(), param,
                    velParam);
            if (dbRowset.next()) {
            	prcPropCreTpCd = dbRowset.getString(1);
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(),se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
        return prcPropCreTpCd;
    }
    
    /**
     * CONVERSION 입력 가능한가를 확인하기 위해서 CONVERSION CONFIRM FLAG정보를 조회한다.<br>
     * @param PriScNoteConvVO priScNoteConvVO
     * @return String
     * @throws DAOException
     */
    public String searchConversionConfirmFlag (PriScNoteConvVO priScNoteConvVO) throws DAOException {
        DBRowSet dbRowset = null;
        String convCfmFlg = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
        	if(priScNoteConvVO != null){
				Map<String, String> mapVO = priScNoteConvVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCNoteConversionProposalDBDAOPriSpMnConvConfirmFlagRSQL(), param,
                    velParam);
            if (dbRowset.next()) {
            	convCfmFlg = dbRowset.getString(1);
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(),se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
        return convCfmFlg;
    }
    
    
    

    /**
     * CONVERSION 입력 가능한가를 확인하기 위해서 권한이 있는지 정보를 조회한다.<br>
     * @param PriScNoteConvVO priScNoteConvVO
     * @param SignOnUserAccount account
     * @return String
     * @throws DAOException
     */
    public List<PriSpMnConvAuthFlagVO> searchConversionAuthFlag (PriScNoteConvVO priScNoteConvVO,SignOnUserAccount account) throws DAOException {
        DBRowSet dbRowset = null;
        List<PriSpMnConvAuthFlagVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            if(priScNoteConvVO != null){
                Map<String, String> mapVO = priScNoteConvVO .getColumnValues();
                mapVO.put("srep_cd",account.getSrep_cd());  
                mapVO.put("ofc_cd",account.getOfc_cd());  


                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCNoteConversionProposalDBDAOPriSpMnConvAuthFlagRSQL(), param,
                    velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, PriSpMnConvAuthFlagVO .class);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(),se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
        return list;
    }
	
    /**
     * 이전 Amend Seq.를 기준으로 Special Note Conversion을 추가합니다.<br>
     * 
     * @param PriSpMnVO priSpMnVO
     * @exception DAOException
     */
    public void addConversionSpecialNote(PriSpMnVO priSpMnVO) throws DAOException,Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = priSpMnVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new SCNoteConversionProposalDBDAOPriScNoteConvUptVOCSQL(),
                    param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(),se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
    }	
    
    /**
     * 이전 Amend Seq.를 기준으로 Rate Route Conversion을 추가합니다.<br>
     * 
     * @param PriSpMnVO priSpMnVO
     * @exception DAOException
     */
    public void addConversionRateCnote(PriSpMnVO priSpMnVO) throws DAOException,Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = priSpMnVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new SCNoteConversionProposalDBDAOPriScNoteConvUptCnoteVOCSQL(),
                    param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(),se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
    }
    
    /**
     * 이전 Amend Seq.를 기준으로 Rate Commodity Conversion을 추가합니다.<br>
     * 
     * @param PriSpMnVO priSpMnVO
     * @exception DAOException
     */
    public void addConversionRateCommodity(PriSpMnVO priSpMnVO) throws DAOException,Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = priSpMnVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new SCNoteConversionProposalDBDAOPriScNoteConvUptRnoteVOCSQL(),
                    param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(),se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
    }    
	
	/**
	 * Conversion Update시 Confirm 대상의 다음 Amend Seq.의 데이터를 삭제한다.<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @exception DAOException
	 */
	public void removeConversionUpdate(PriSpMnVO priSpMnVO) throws DAOException,Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = priSpMnVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new SCNoteConversionProposalDBDAOPriScNoteConvUptVODSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to delete SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}  
	
	   
    /**
     * CONVERSION HISTORY 입력할때 EXP_DT를 입력하기 위해서 현재 AMDT_SEQ의 DURATION EXP_DT를 조회한다.<br>
     * @param PriScNoteConvVO priScNoteConvVO
     * @return String
     * @throws DAOException
     */
    public String searchDurationExpDate (PriScNoteConvVO priScNoteConvVO) throws DAOException {
        DBRowSet dbRowset = null;
        String sCtrtExpDt = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
        	if(priScNoteConvVO != null){
				Map<String, String> mapVO = priScNoteConvVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCNoteConversionProposalDBDAOPriSpScpDurVORSQL(), param,
                    velParam);
            if (dbRowset.next()) {
            	sCtrtExpDt = dbRowset.getString("ctrt_exp_dt");
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(),se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
        return sCtrtExpDt;
    }
	
	
	
}