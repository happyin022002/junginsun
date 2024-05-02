/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CODCorrectionDBDAO.java
*@FileTitle : COD Status Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.23
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.07.23 최영희
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.basic.CODCorrectionBCImpl;
import com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.vo.BkgCODMgtConditionVO;
import com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.vo.BkgCodCostSumVO;
import com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.vo.BkgCodInfoVO;
import com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.vo.CodAuthVO;
import com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.vo.CodCntrDgInfoVO;
import com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.vo.CodCntrVO;
import com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.vo.CodEtcVO;
import com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.vo.CodHistoryVO;
import com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.vo.CodLastHistoryVO;
import com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.vo.CodOldNewRhndPortVvdVO;
import com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.vo.CodRsoVO;
import com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.vo.CodStsInputVO;
import com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.vo.CodStsVO;
import com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.vo.PrnrCodRcvrVO;
import com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.vo.PrnrCodRqstVO;
import com.clt.bizcommon.comm.Constants;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BkgCodCntrVO;
import com.clt.syscommon.common.table.BkgCodCostVO;
import com.clt.syscommon.common.table.BkgCodHisDtlVO;
import com.clt.syscommon.common.table.BkgCodVO;
import com.clt.syscommon.common.table.BkgCodVvdVO;


/**
 * OPUS CODCorrectionDBDAO <br>
 * - OPUS-BookingCorrection system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Choi Yeoung Hee
 * @see CODCorrectionBCImpl 참조
 * @since J2EE 1.6 
 */
public class CODCorrectionDBDAO extends DBDAOSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4092500379238452156L;

	/**
	 * COD의 요청,승인,거절 등의 이력을 조회한다<br>
	 * 
	 * @param CodStsInputVO codStsHisInputVO
	 * @return List<CodStsVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CodStsVO> searchCodStsList(CodStsInputVO codStsHisInputVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CodStsVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int currentPage = codStsHisInputVO.getIPage();
		int startNo = Constants.PAGE_SIZE_50 * (currentPage -1) +1;
		int endNo   = Constants.PAGE_SIZE_50 *  currentPage;  
		try{
			if(codStsHisInputVO != null){
				Map<String, String> mapVO = codStsHisInputVO.getColumnValues();
			
				param.putAll(mapVO);
				param.put("startno", startNo);
				param.put("endno", endNo);
				velParam.putAll(mapVO);
				velParam.put("startno", startNo);
				velParam.put("endno", endNo);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CODCorrectionDBDAOsearchCodStsListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CodStsVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}
	
	/**
	 * 해당 bkg으로 bkg_cod의 cod_rqst_seq를 조회한다.<br>
     * 
	 * @param  BkgBlNoVO bkgBlNoVO
	 * @return List<BkgComboVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgComboVO> searchCodRqstSeq(BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgComboVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CODCorrectionDBDAOsearchCodRqstSeqRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgComboVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}
	
	/**
	 * 
	 * @param bkgBlNoVO
	 * @param codRqstSeq
	 * @return
	 * @throws DAOException
	 */
	public List<CodHistoryVO> searchCodHistory(BkgBlNoVO bkgBlNoVO,String  codRqstSeq) throws DAOException {
		DBRowSet dbRowset = null;
		List<CodHistoryVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("cod_rqst_seq", codRqstSeq);
				velParam.put("cod_rqst_seq", codRqstSeq);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CODCorrectionDBDAOsearchCodHistoryRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CodHistoryVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	} 
	/**
	 *  cod 요청 정보를 생성한다.<br>
     *  
	 * @param  BkgCodVO bkgCodVO
	 * @param  SignOnUserAccount account
	 * @exception DAOException
	 */
	public void addBkgCod(BkgCodVO bkgCodVO,SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		SQLExecuter sqlExe = new SQLExecuter("");
		try{
			if(bkgCodVO != null){
				Map<String, String> mapVO = bkgCodVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("usr_id", account.getUsr_id());
				velParam.put("usr_id", account.getUsr_id());
				param.put("pctl_no", bkgCodVO.getPctlNo());
				velParam.put("pctl_no", bkgCodVO.getPctlNo());
				param.put("cod_rqst_ofc_cd", account.getOfc_cd());
				velParam.put("cod_rqst_ofc_cd", account.getOfc_cd());
				
			}
			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new CODCorrectionDBDAOaddBkgCodCSQL(), param,velParam);
			if(insCnt == Statement.EXECUTE_FAILED) throw new DAOException(new ErrorHandler("BKG01153").getMessage());
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		 
	} 
	
	/**
	 *  bkg_cod_vvd 요청 정보를 생성한다.<br>
     *  
	 * @param  BkgCodVvdVO bkgCodVvdVO
	 * @param  String pctlNo
	 * @param  SignOnUserAccount account
	 * @exception DAOException
	 */
	public void addBkgCodVvd(BkgCodVvdVO bkgCodVvdVO,String pctlNo,SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		SQLExecuter sqlExe = new SQLExecuter("");
		try{
			if(bkgCodVvdVO != null){
				Map<String, String> mapVO = bkgCodVvdVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);				
				param.put("pctl_no", pctlNo);		
				velParam.put("pctl_no", pctlNo);
				param.put("usr_id", account.getUsr_id());
				velParam.put("usr_id", account.getUsr_id());
			}
			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new CODCorrectionDBDAOaddBkgCodVvdCSQL(), param,velParam);
			if(insCnt == Statement.EXECUTE_FAILED) throw new DAOException(new ErrorHandler("BKG01153").getMessage());
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		 
	} 
	
	/**
	 *  bkg_cod_cntr 요청 정보를 생성한다.<br>
     *  
	 * @param  BkgCodCntrVO bkgCodCntrVO
	 * @param  SignOnUserAccount account
	 * @exception DAOException
	 */
	public void addBkgCodCntr(BkgCodCntrVO bkgCodCntrVO,SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		SQLExecuter sqlExe = new SQLExecuter("");
		try{
			if(bkgCodCntrVO != null){
				Map<String, String> mapVO = bkgCodCntrVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("usr_id", account.getUsr_id());
				velParam.put("usr_id", account.getUsr_id());
			}
			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new CODCorrectionDBDAOaddBkgCodCntrCSQL(), param,velParam);
			if(insCnt == Statement.EXECUTE_FAILED) throw new DAOException(new ErrorHandler("BKG01153").getMessage());
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		 
	} 
	
	/**
	 *  bkg_cod_cost 요청 정보를 생성한다.<br>
     *  
	 * @param  BkgCodCostVO bkgCodCostVO
	 * @param  SignOnUserAccount account
	 * @exception DAOException
	 */
	public void addBkgCodCost(BkgCodCostVO bkgCodCostVO,SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		SQLExecuter sqlExe = new SQLExecuter("");
		try{
			if(bkgCodCostVO != null){
				Map<String, String> mapVO = bkgCodCostVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("usr_id", account.getUsr_id());
				velParam.put("usr_id", account.getUsr_id());
			}
			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new CODCorrectionDBDAOaddBkgCodCostCSQL(), param,velParam);
			if(insCnt == Statement.EXECUTE_FAILED) throw new DAOException(new ErrorHandler("BKG01153").getMessage());
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		 
	} 
	
	/**
	 *  bkg_cod_his 요청 정보를 생성한다.<br>
     *  
	 * @param  BkgBlNoVO bkgBlNoVO
	 * @param  String codRqstSeq
	 * @param  SignOnUserAccount account
	 * @exception DAOException
	 */
	public void addBkgCodHis(BkgBlNoVO bkgBlNoVO , String codRqstSeq,SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		SQLExecuter sqlExe = new SQLExecuter("");
		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("cod_rqst_seq", codRqstSeq);
				velParam.put("cod_rqst_seq", codRqstSeq);
				param.put("iss_ofc_cd", account.getOfc_cd());
				velParam.put("iss_ofc_cd", account.getOfc_cd());
				param.put("usr_id", account.getUsr_id());
				velParam.put("usr_id", account.getUsr_id());
			}
			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new CODCorrectionDBDAOaddBkgCodHisCSQL(), param,velParam);
			if(insCnt == Statement.EXECUTE_FAILED) throw new DAOException(new ErrorHandler("BKG01153").getMessage());
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		 
	} 
	
	/**
	 *  bkg_cod_his_dtl 요청 정보를 생성한다.<br>
	 *  
	 * @param BkgCodHisDtlVO bkgCodHisDtlVO
	 * @param SignOnUserAccount account
	 * @exception DAOException
	 */
	public void addBkgCodHisDtl(BkgCodHisDtlVO bkgCodHisDtlVO,SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		SQLExecuter sqlExe = new SQLExecuter("");
		try{
			if(bkgCodHisDtlVO != null){
				Map<String, String> mapVO = bkgCodHisDtlVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				 
				param.put("usr_id", account.getUsr_id());
				velParam.put("usr_id", account.getUsr_id());
			}
			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new CODCorrectionDBDAOaddBkgCodHisDtlCSQL(), param,velParam);
			if(insCnt == Statement.EXECUTE_FAILED) throw new DAOException(new ErrorHandler("BKG01153").getMessage());
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		 
	} 
	
	/**
	 * 해당 cod 진행건의 cod status를 조회한다.<br>
	 * 
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param String codRqstSeq
	 * @return String
	 * @exception DAOException
	 */
	public String searchCodRqstSts(BkgBlNoVO bkgBlNoVO,String codRqstSeq) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnString = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("cod_rqst_seq", codRqstSeq);
				velParam.put("cod_rqst_seq", codRqstSeq);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CODCorrectionDBDAOsearchCodRqstStsRSQL(), param, velParam);
			if(dbRowset.next()){
				rtnString = dbRowset.getString("cod_sts_cd");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return rtnString;
	}
	
	/**
	 * COD 요청 내역을 수정<br>
     * 
	 * @param  BkgCodVO bkgCodVO
	 * @param  SignOnUserAccount account
	 * @return int
	 * @exception DAOException
	 */
	public int modifyBkgCod(BkgCodVO bkgCodVO,SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		SQLExecuter sqlExe = new SQLExecuter("");
		try{
			if(bkgCodVO != null){
				Map<String, String> mapVO = bkgCodVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("usr_id", account.getUsr_id());
				velParam.put("usr_id", account.getUsr_id());
			}
			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new CODCorrectionDBDAOmodifyBkgCodUSQL(), param,velParam);
			if(insCnt == Statement.EXECUTE_FAILED) throw new DAOException(new ErrorHandler("BKG01154").getMessage());

			return insCnt;
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	} 
	/**
	 * COD 요청 내역을 삭제<br>
     * 
	 * @param  BkgBlNoVO bkgBlNoVO
	 * @param  String codRqstSeq
	 * @exception DAOException
	 */
	public void removeBkgCod(BkgBlNoVO bkgBlNoVO,String codRqstSeq) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		SQLExecuter sqlExe = new SQLExecuter("");
		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("cod_rqst_seq", codRqstSeq);
				velParam.put("cod_rqst_seq", codRqstSeq);
			}
			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new CODCorrectionDBDAOremoveBkgCodDSQL(), param,velParam);
			if(insCnt == Statement.EXECUTE_FAILED) throw new DAOException(new ErrorHandler("BKG01155").getMessage());
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		 
	} 
	
	/**
	 * bkg_cod_vvd 자료를 삭제<br>
     * 
	 * @param  BkgBlNoVO bkgBlNoVO
	 * @param  String codRqstSeq
	 * @param  String vvdOpCd
	 * @exception DAOException
	 */
	public void removeBkgCodVvd(BkgBlNoVO bkgBlNoVO,String codRqstSeq, String vvdOpCd) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		SQLExecuter sqlExe = new SQLExecuter("");
		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("cod_rqst_seq", codRqstSeq);
				velParam.put("cod_rqst_seq", codRqstSeq);
				param.put("vvd_op_cd", vvdOpCd);
				velParam.put("vvd_op_cd", vvdOpCd);
				
			}
			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new CODCorrectionDBDAOremoveBkgCodVvdDSQL(), param,velParam);
			if(insCnt == Statement.EXECUTE_FAILED) throw new DAOException(new ErrorHandler("BKG01155").getMessage());
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		 
	} 
	
	/**
	 * bkg_cod_cntr 자료를 삭제<br>
     * 
	 * @param  BkgBlNoVO bkgBlNoVO
	 * @param  String codRqstSeq
	 * @exception DAOException
	 */
	public void removeBkgCodCntr(BkgBlNoVO bkgBlNoVO,String codRqstSeq) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		SQLExecuter sqlExe = new SQLExecuter("");
		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("cod_rqst_seq", codRqstSeq);
				velParam.put("cod_rqst_seq", codRqstSeq);
			}
			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new CODCorrectionDBDAOremoveBkgCodCntrDSQL(), param,velParam);
			if(insCnt == Statement.EXECUTE_FAILED) throw new DAOException(new ErrorHandler("BKG01155").getMessage());
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		 
	} 
	
	/**
	 * bkg_cod_cost자료를 삭제<br>
     * 
	 * @param  BkgBlNoVO bkgBlNoVO
	 * @param  String codRqstSeq
	 * @exception DAOException
	 */
	public void removeBkgCodCost(BkgBlNoVO bkgBlNoVO,String codRqstSeq) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		SQLExecuter sqlExe = new SQLExecuter("");
		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("cod_rqst_seq", codRqstSeq);
				velParam.put("cod_rqst_seq", codRqstSeq);
			}
			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new CODCorrectionDBDAOremoveBkgCodCostDSQL(), param,velParam);
			if(insCnt == Statement.EXECUTE_FAILED) throw new DAOException(new ErrorHandler("BKG01155").getMessage());
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		 
	}
	
	/**
	 * bkg_cod_cntr을 조회한다<br>
	 * 
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param String codRqstSeq
	 * @param  String codStsCd
	 * @return List<BkgCodCntrVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CodCntrVO> searchCodCntr(BkgBlNoVO bkgBlNoVO,String codRqstSeq, String codStsCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<CodCntrVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgBlNoVO != null){
				param.put("bkgNo", bkgBlNoVO.getBkgNo());
				param.put("codRqstSeq", codRqstSeq);
				velParam.put("bkgNo", bkgBlNoVO.getBkgNo());
				velParam.put("codRqstSeq", codRqstSeq);
				param.put("cod_sts_cd", codStsCd);
				velParam.put("cod_sts_cd", codStsCd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CODCorrectionDBDAOsearchCodCntrRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CodCntrVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	} 
	
	 
	
	/**
	 * bkg_cod_cost에서 조회한다.<br>
	 * 
	 * @param  BkgBlNoVO bkgBlNoVO
	 * @param  String codRqstSeq
	 * @return List<BkgCodCostVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgCodCostVO> searchCodCost(BkgBlNoVO bkgBlNoVO,String codRqstSeq) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgCodCostVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgBlNoVO != null){
				param.put("bkgNo", bkgBlNoVO.getBkgNo());
				param.put("codRqstSeq", codRqstSeq);
				velParam.put("bkgNo", bkgBlNoVO.getBkgNo());
				velParam.put("codRqstSeq", codRqstSeq);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CODCorrectionDBDAOsearchCodCostRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgCodCostVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	} 
	/**
	 * 마지막으로 변경된 이력을 조회한다.<br>
	 * 
	 * @param  BkgBlNoVO bkgBlNoVO
	 * @param  String codRqstSeq
	 * @return List<CodHistoryVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CodLastHistoryVO> searchCodLastHistory(BkgBlNoVO bkgBlNoVO,String codRqstSeq) throws DAOException {
		DBRowSet dbRowset = null;
		List<CodLastHistoryVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgBlNoVO != null){
				param.put("bkgNo", bkgBlNoVO.getBkgNo());
				param.put("codRqstSeq", codRqstSeq);
				velParam.put("bkgNo", bkgBlNoVO.getBkgNo());
				velParam.put("codRqstSeq", codRqstSeq);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CODCorrectionDBDAOsearchCodLastHistoryRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CodLastHistoryVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	} 
	/**
	 *  Cod 정보와 Route정보 조회<br>
	 *  
	 * @param  BkgBlNoVO bkgBlNoVO
	 * @param  String codRqstSeq
	 * @return List<CodEtcVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CodEtcVO> searchBkgCod(BkgBlNoVO bkgBlNoVO,String codRqstSeq) throws DAOException {
		DBRowSet dbRowset = null;
		List<CodEtcVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgBlNoVO != null){
				param.put("bkgNo", bkgBlNoVO.getBkgNo());
				param.put("codRqstSeq", codRqstSeq);
				velParam.put("bkgNo", bkgBlNoVO.getBkgNo());
				velParam.put("codRqstSeq", codRqstSeq);
				param.put("pctl_no", bkgBlNoVO.getPctlNo());
				velParam.put("pctl_no", bkgBlNoVO.getPctlNo());
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CODCorrectionDBDAOsearchBkgCodRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CodEtcVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	} 
	
	/**
	 * Bkg Old Route 조회<br>
	 * 
	 * @param  BkgBlNoVO bkgBlNoVO
	 * @param  String codRqstSeq
	 * @return List<BkgCodVvdVO> 
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgCodVvdVO> searchCodOldRoute(BkgBlNoVO bkgBlNoVO,String codRqstSeq) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgCodVvdVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgBlNoVO != null){
				param.put("bkgNo", bkgBlNoVO.getBkgNo());
				param.put("codRqstSeq", codRqstSeq);
				velParam.put("bkgNo", bkgBlNoVO.getBkgNo());
				velParam.put("codRqstSeq", codRqstSeq);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CODCorrectionDBDAOsearchCodOldRouteRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgCodVvdVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	} 
	
	/**
	 * Bkg New Route 조회<br>
	 * 
	 * @param  BkgBlNoVO bkgBlNoVO
	 * @param  String codRqstSeq
	 * @return List<BkgCodVvdVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgCodVvdVO> searchCodNewRoute(BkgBlNoVO bkgBlNoVO,String codRqstSeq) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgCodVvdVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("cod_rqst_seq", codRqstSeq);
				velParam.put("cod_rqst_seq", codRqstSeq);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CODCorrectionDBDAOsearchCodNewRouteRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgCodVvdVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}
	
	/**
	 *  Currency별 합계 조회<br>
	 * 
	 * @param  BkgBlNoVO bkgBlNoVO
	 * @param  String codRqstSeq
	 * @return List<BkgCodCostSumVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgCodCostSumVO> searchCodCostSum(BkgBlNoVO bkgBlNoVO,String codRqstSeq) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgCodCostSumVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgBlNoVO != null){
				param.put("bkgNo", bkgBlNoVO.getBkgNo());
				param.put("codRqstSeq", codRqstSeq);
				velParam.put("bkgNo", bkgBlNoVO.getBkgNo());
				velParam.put("codRqstSeq", codRqstSeq);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CODCorrectionDBDAOsearchCodCostSumRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgCodCostSumVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}
	/**
	 * cod 요청의 상태를 변경한다<br>
     * 
	 * @param  BkgBlNoVO bkgBlNoVO
	 * @param  String codRqstSeq
	 * @param  String codStsCd
	 * @param  String codRqstRsnCd
	 * @param  SignOnUserAccount account
	 * @exception DAOException
	 */
	public void modifyCodStatus(BkgBlNoVO bkgBlNoVO, String codRqstSeq,String codStsCd,String codRqstRsnCd, SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		SQLExecuter sqlExe = new SQLExecuter("");
		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("cod_rqst_seq", codRqstSeq);
				velParam.put("cod_rqst_seq", codRqstSeq);
				param.put("cod_sts_cd", codStsCd);
				velParam.put("cod_sts_cd", codStsCd);
				param.put("cod_rqst_rsn_cd", codRqstRsnCd);
				velParam.put("cod_rqst_rsn_cd", codRqstRsnCd);
				param.put("usr_id", account.getUsr_id());
				velParam.put("usr_id", account.getUsr_id());
				param.put("ofc_cd", account.getOfc_cd());
				velParam.put("ofc_cd", account.getOfc_cd());
			}
			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new CODCorrectionDBDAOmodifyCodStatusUSQL(), param,velParam);
			if(insCnt == Statement.EXECUTE_FAILED) throw new DAOException(new ErrorHandler("BKG01154").getMessage());
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		 
	} 
	
	
	/**
	 * bkg_cod에 cod_chg_ttl_cost_amt에 bkg_cod_cost의 chg_amt의 합을 update<br>
     * chgRmk가 있으면 cod_cng_cost_rmk에 update<br>
     * 
	 * @param BkgCodCostVO bkgCodCostVO
	 * @param String chgRmk
	 * @param SignOnUserAccount account
	 * @exception DAOException
	 */
	public void modifyBkgCodTotalCost(BkgCodCostVO bkgCodCostVO,String chgRmk, SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		SQLExecuter sqlExe = new SQLExecuter("");
		try{
			if(bkgCodCostVO != null){
				Map<String, String> mapVO = bkgCodCostVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("cod_cng_cost_rmk", chgRmk);
				velParam.put("cod_cng_cost_rmk", chgRmk);
				param.put("usr_id", account.getUsr_id());
				velParam.put("usr_id", account.getUsr_id());
			}
			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new CODCorrectionDBDAOmodifyBkgCodTotalCostUSQL(), param,velParam);
			if(insCnt == Statement.EXECUTE_FAILED) throw new DAOException(new ErrorHandler("BKG01154").getMessage());
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		 
	}
	
	/**
	 * 해당 COD 요청 건에 대해서 승인 상태로 update한다.<br>
     * 
	 * @param CodAuthVO codAuthVO
	 * @param SignOnUserAccount account
	 * @exception DAOException
	 */
	public void confirmCodRqst(CodAuthVO codAuthVO, SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		SQLExecuter sqlExe = new SQLExecuter("");
		try{
			if(codAuthVO != null){
				Map<String, String> mapVO = codAuthVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				 
				param.put("cod_auth_flg", codAuthVO.getAuthflag());
				velParam.put("cod_auth_flg", codAuthVO.getAuthflag());
				param.put("cod_sts_cd", codAuthVO.getCodstscd());
				velParam.put("cod_sts_cd", codAuthVO.getCodstscd());
				param.put("usr_id", account.getUsr_id());
				velParam.put("usr_id", account.getUsr_id());
			}
			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new CODCorrectionDBDAOconfirmCodRqstUSQL(), param,velParam);
			if(insCnt == Statement.EXECUTE_FAILED) throw new DAOException(new ErrorHandler("BKG01154").getMessage());
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		 
	}
	/**
	 * 해당 COD 요청 건에 대해서 거절 상태로 update한다.<br>
     * 
	 * @param CodAuthVO codAuthVO
	 * @param SignOnUserAccount account
	 * @exception DAOException
	 */
	public void rejectCodRqst(CodAuthVO codAuthVO, SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		SQLExecuter sqlExe = new SQLExecuter("");
		try{
			if(codAuthVO != null){
				Map<String, String> mapVO = codAuthVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				 
				param.put("cod_auth_flg", codAuthVO.getAuthflag());
				velParam.put("cod_auth_flg", codAuthVO.getAuthflag());
				param.put("cod_rjct_cd", codAuthVO.getRejectcd());
				velParam.put("cod_rjct_cd", codAuthVO.getRejectcd());
				param.put("cod_rjct_rsn_rmk", codAuthVO.getRejectrmk());
				velParam.put("cod_rjct_rsn_rmk", codAuthVO.getRejectrmk());
				param.put("usr_id", account.getUsr_id());
				velParam.put("usr_id", account.getUsr_id());
				param.put("diff_rmk", codAuthVO.getCodRemark());
				velParam.put("diff_rmk", codAuthVO.getCodRemark());
			}
			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new CODCorrectionDBDAOrejectCodRqstUSQL(), param,velParam);
			if(insCnt == Statement.EXECUTE_FAILED) throw new DAOException(new ErrorHandler("BKG01154").getMessage());
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		 
	}
	
	/**
	 * OPF에서 bkg_no, cod_rqst_seq에 맞는 bkg_cod에 rgn_code를 update한다.<br>
	 *
	 * @param BkgCodVO bkgCodVO
	 * @param SignOnUserAccount account
	 * @exception DAOException
	 */
	public void modifyCodRso(BkgCodVO bkgCodVO, SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		SQLExecuter sqlExe = new SQLExecuter("");
		try{
			if(bkgCodVO != null){
				param.put("bkg_no", bkgCodVO.getBkgNo());
				velParam.put("bkg_no", bkgCodVO.getBkgNo());
				param.put("cod_rqst_seq", bkgCodVO.getCodRqstSeq());
				velParam.put("cod_rqst_seq", bkgCodVO.getCodRqstSeq());
				param.put("rgn_cd", bkgCodVO.getRgnCd());
				velParam.put("rgn_cd", bkgCodVO.getRgnCd());
				param.put("usr_id", account.getUsr_id());
				velParam.put("usr_id", account.getUsr_id());
			}
			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new CODCorrectionDBDAOmodifyCodRsoUSQL(), param,velParam);
			if(insCnt == Statement.EXECUTE_FAILED) throw new DAOException(new ErrorHandler("BKG01154").getMessage());
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		 
	}
	/**
	 * cod rqst건에 대한 rehandling port를 판단한다..<br>
	 *
	 * @param     BkgBlNoVO bkgBlNoVO
	 * @param     String codRqstSeq
	 * @return    String
	 * @exception DAOException
	 */
	public String searchRehandlingPort(BkgBlNoVO bkgBlNoVO, String codRqstSeq) throws DAOException{
		DBRowSet dbRowset = null;
		String rtnString = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("cod_rqst_seq", codRqstSeq);
				velParam.put("cod_rqst_seq", codRqstSeq);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CODCorrectionDBDAOSearchRehandlingPortRSQL(), param, velParam);
			if(dbRowset.next()){
				rtnString = dbRowset.getString("rehandling_port");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return rtnString;
	}
	/**
	 * cod rqst건에 대한 pctl no를 update한다.<br>
	 *
	 * @param     BkgBlNoVO bkgBlNoVO
	 * @param     String codRqstSeq
	 * @param     SignOnUserAccount account
	 * @exception DAOException
	 */
	public void modifyCodPctlNo(BkgBlNoVO bkgBlNoVO, String codRqstSeq, SignOnUserAccount account) throws DAOException{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		SQLExecuter sqlExe = new SQLExecuter("");
		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("cod_rqst_seq", codRqstSeq);
				velParam.put("cod_rqst_seq", codRqstSeq);
				param.put("usr_id", account.getUsr_id());
				velParam.put("usr_id", account.getUsr_id());
			}
			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new CODCorrectionDBDAOmodifyCodPctlNoUSQL(), param,velParam);
			if(insCnt == Statement.EXECUTE_FAILED) throw new DAOException(new ErrorHandler("BKG01154").getMessage());
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	/**
	 * route 변경건에 대한 RSO와 OPF 요청 대상인지 조회한다.<br>
	 *
	 * @param     BkgBlNoVO bkgBlNoVO
	 * @param     String codRqstSeq
	 * @param     String rehandlingPort
	 * @return    CodRsoVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public CodRsoVO searchCodRso(BkgBlNoVO bkgBlNoVO, String codRqstSeq, String rehandlingPort) throws DAOException{
		DBRowSet dbRowset = null;
		CodRsoVO codRsoVO = null;
		List<CodRsoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO .getColumnValues();

				param.putAll(mapVO);
				param.put("cod_rhnd_port_cd", rehandlingPort);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new CODCorrectionDBDAOSearchCodRsoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CodRsoVO .class);
			if(list != null && list.size() > 0){
				codRsoVO = list.get(0);
			}

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return codRsoVO;
	} 
	
	/**
	 * opf에서 호출시 해당 request 건의 rehandling vvd를 조회한다.<br>
	 * 
	 * @param String bkgNo
	 * @param String codRqstSeq
	 * @return CodOldNewRhndPortVvdVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public CodOldNewRhndPortVvdVO searchRehandlingVvd(String bkgNo, String codRqstSeq) throws DAOException{
		DBRowSet dbRowset = null;
		CodOldNewRhndPortVvdVO codOldNewRhndPortVvdVO = null;
		List<CodOldNewRhndPortVvdVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("bkg_no", bkgNo);
			velParam.put("bkg_no", bkgNo); 
			param.put("cod_rqst_seq", codRqstSeq);
			velParam.put("cod_rqst_seq", codRqstSeq);
			 
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CODCorrectionDBDAOsearchRehandlingVvdRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CodOldNewRhndPortVvdVO .class);
			if(list != null && list.size() > 0){
				codOldNewRhndPortVvdVO = list.get(0);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return codOldNewRhndPortVvdVO;
	}

	/**
	 * 해당 Cntr의 stowage code를 조회한다..<br>
	 * 
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param String codRqstSeq
	 * @param String rhndVvd
	 * @param String rhndYdCd
	 * @return List<CodCntrVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CodCntrVO> searchStowageCd(BkgBlNoVO bkgBlNoVO, String codRqstSeq, String rhndVvd, String rhndYdCd)throws DAOException{
		DBRowSet dbRowset = null;
		List<CodCntrVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("bkg_no", bkgBlNoVO.getBkgNo()); 
			param.put("cod_rqst_seq", codRqstSeq);
			param.put("rhnd_vvd", rhndVvd);
			param.put("rhnd_yd_cd", rhndYdCd);
			 
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CODCorrectionDBDAOSearchCodStowageCdRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CodCntrVO.class);

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}
	
	/**
	 * mail 관련 cntr조회
	 * 
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param String codRqstSeq
	 * @return List<CodCntrVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CodCntrVO> searchPrnrCodCntr(BkgBlNoVO bkgBlNoVO, String codRqstSeq)throws DAOException{
		DBRowSet dbRowset = null;
		List<CodCntrVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("bkg_no", bkgBlNoVO.getBkgNo()); 
			param.put("cod_rqst_seq", codRqstSeq);
			 
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CODCorrectionDBDAOsearchPrnrCodCntrRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CodCntrVO.class);

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}
	
	/**
	 * mail 보내고 받는 사람 정보 조회 
	 * @param BkgBlNoVO bkgBlNoVO 
	 * @param String codRqstSeq
	 * @param String rhndVvd
	 * @param SignOnUserAccount account
	 * @return PrnrCodRcvrVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public PrnrCodRcvrVO searchPrnrCodRcvr(BkgBlNoVO bkgBlNoVO, String codRqstSeq, String rhndVvd, SignOnUserAccount account) throws DAOException{
		DBRowSet dbRowset = null;
		PrnrCodRcvrVO prnrCodRcvrVO = null;
		List<PrnrCodRcvrVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = bkgBlNoVO .getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			param.put("cod_rqst_seq", codRqstSeq);
			param.put("rhnd_vvd", rhndVvd);
			param.put("usr_id", account.getUsr_id());
			velParam.put("rhnd_vvd", rhndVvd); 
			velParam.put("cod_rqst_seq", codRqstSeq);
			velParam.put("usr_id", account.getUsr_id());
			 
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CODCorrectionDBDAOsearchPrnrCodRcvrRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PrnrCodRcvrVO .class);
			if(list != null && list.size() > 0){
				prnrCodRcvrVO = list.get(0);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return prnrCodRcvrVO;
	}
	
	/**
	 * mail 내용 조회 
	 * 
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param String codRqstSeq
	 * @return PrnrCodRqstVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public PrnrCodRqstVO searchPrnrCodRqst(BkgBlNoVO bkgBlNoVO, String codRqstSeq) throws DAOException{
		DBRowSet dbRowset = null;
		PrnrCodRqstVO prnrCodRqstVO = null;
		List<PrnrCodRqstVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("bkg_no", bkgBlNoVO.getBkgNo()); 
			param.put("cod_rqst_seq", codRqstSeq);
			 
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CODCorrectionDBDAOsearchPrnrCodRqstRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PrnrCodRqstVO .class);
			if(list != null && list.size() > 0){
				prnrCodRqstVO = list.get(0);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return prnrCodRqstVO;
	}

	/**
	 * bkg_cod_his자료를 삭제<br>
     * 
	 * @param  BkgBlNoVO bkgBlNoVO
	 * @param  String codRqstSeq
	 * @exception DAOException
	 */
	public void removeBkgCodHis(BkgBlNoVO bkgBlNoVO, String codRqstSeq) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		SQLExecuter sqlExe = new SQLExecuter("");
		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("cod_rqst_seq", codRqstSeq);
				velParam.put("cod_rqst_seq", codRqstSeq);
			}
			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new CODCorrectionDBDAORemoveBkgCodHisDSQL(), param,velParam);
			if(insCnt == Statement.EXECUTE_FAILED) throw new DAOException(new ErrorHandler("BKG01155").getMessage());
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	/**
	 * cod 대상 cntr의 dg 정보를 조회한다.<br>
     * 
	 * @param  BkgBlNoVO bkgBlNoVO
	 * @param  String codRqstSeq
	 * @return List<CodCntrDgInfoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CodCntrDgInfoVO> searchCodCntrDgInfo(BkgBlNoVO bkgBlNoVO, String codRqstSeq) throws DAOException{
		DBRowSet dbRowset = null;
		List<CodCntrDgInfoVO> dgInfoVOs = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("bkg_no", bkgBlNoVO.getBkgNo()); 
			param.put("cod_rqst_seq", codRqstSeq);
			 
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CODCorrectionDBDAOSearchCodCntrDgInfoRSQL(), param, velParam);
			dgInfoVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, CodCntrDgInfoVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return dgInfoVOs;
	}
	
	 /**
	 * RSO, LANE 별 EMAIL 을 조회 합니다.<br>
	 * 
	 * @param BkgCODMgtConditionVO bkgCODMgtConditionVO
	 * @return List<BkgCodInfoVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<BkgCodInfoVO> searchCODEmailsendList(BkgCODMgtConditionVO bkgCODMgtConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgCodInfoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgCODMgtConditionVO != null){
				Map<String, String> mapVO = bkgCODMgtConditionVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CODCorrectionDBDAOCODEmailSendRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgCodInfoVO.class);
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
	 * 해당 BKG의 NEW,OLD POD CODE 를 조회 합니다..<br>
	 * 
	 * @param BkgCODMgtConditionVO bkgCODMgtConditionVO
	 * @return List<BkgCodInfoVO>
	 * @exception EventException
	 */	 
	 @SuppressWarnings("unchecked")
	 public List<BkgCodInfoVO> searchCODNewOldPODCd(BkgCODMgtConditionVO bkgCODMgtConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgCodInfoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgCODMgtConditionVO != null){
				Map<String, String> mapVO = bkgCODMgtConditionVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CODCorrectionDBDAOCODNewOldPODRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgCodInfoVO.class);
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
		 * SCE COP updateBkgForBkgCod 메서드 호출 대상 여부 및 파라미터를 조회 한다.<br>
		 * POD, DEL 국가가 바뀌었을 때 COP 호출한다.
		 *  
		 * @param  BkgBlNoVO bkgBlNoVO
		 * @param  String codRqstSeq
		 * @return CodEtcVO
		 * @exception DAOException
		 */
		@SuppressWarnings("unchecked")
		public CodEtcVO searchCopForBkgCodParam(BkgBlNoVO bkgBlNoVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<CodEtcVO> list = null;
			CodEtcVO codEtcVO = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(bkgBlNoVO != null){
					param.put("bkg_no", bkgBlNoVO.getBkgNo());
					velParam.put("bkg_no", bkgBlNoVO.getBkgNo());
					param.put("pctl_no", bkgBlNoVO.getPctlNo());
					velParam.put("pctl_no", bkgBlNoVO.getPctlNo());
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CODCorrectionDBDAOSearchCopForBkgCodParamRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, CodEtcVO.class);
				if(list != null && list.size() > 0){
					codEtcVO = list.get(0);
				}
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(),se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
			}
			return codEtcVO;
		} 
		

		/**
		 * Booking Creation, E-BKG/SI Upload 화면에서 Auto COD를 insert한다<br>
	     * 
		 * @param  BkgBlNoVO bkgBlNoVO
		 * @param  String rsoCd
		 * @param  String rehandlingPort
		 * @param  String codRqstRsnCd
		 * @param  SignOnUserAccount account
		 * @return int
		 * @exception DAOException
		 */
		public int addAutoCod(BkgBlNoVO bkgBlNoVO, String rsoCd, String rehandlingPort, String codRqstRsnCd, SignOnUserAccount account) throws DAOException{ 
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			SQLExecuter sqlExe = new SQLExecuter("");
			try{
				if(bkgBlNoVO != null){
					Map<String, String> mapVO = bkgBlNoVO.getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
					param.put("rso_cd", rsoCd);
					param.put("cod_rhnd_port_cd", rehandlingPort);
					param.put("cod_rqst_rsn_cd", codRqstRsnCd);
					param.put("usr_id", account.getUsr_id());
					velParam.put("rso_cd", rsoCd);
					velParam.put("cod_rhnd_port_cd", rehandlingPort);
					velParam.put("cod_rqst_rsn_cd", codRqstRsnCd);
					velParam.put("usr_id", account.getUsr_id());				
				}
				int insCnt = sqlExe.executeUpdate((ISQLTemplate)new CODCorrectionDBDAOaddAutoCodCSQL(), param,velParam);
				if(insCnt == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert SQL");
				return insCnt;
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(),se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
			}	
		}
		
		/**
		 * Booking Creation, E-BKG/SI Upload 화면에서 Auto COD VVD를 insert한다<br>
	     * 
		 * @param  BkgBlNoVO bkgBlNoVO
		 * @param  String codRqstSeq
		 * @param  String codRqstRsnCd
		 * @param  SignOnUserAccount account
		 * @return int
		 * @exception DAOException
		 */
		public int addCodOldNewVvd(BkgBlNoVO bkgBlNoVO, String codRqstSeq, String codRqstRsnCd, SignOnUserAccount account) throws DAOException{ 
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			SQLExecuter sqlExe = new SQLExecuter("");
			try{
				if(bkgBlNoVO != null){
					Map<String, String> mapVO = bkgBlNoVO.getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
					param.put("cod_rqst_seq", codRqstSeq);
					param.put("cod_rqst_rsn_cd", codRqstRsnCd);
					param.put("usr_id", account.getUsr_id());
					velParam.put("cod_rqst_seq", codRqstSeq);
					velParam.put("usr_id", account.getUsr_id());	
					velParam.put("cod_rqst_rsn_cd", codRqstRsnCd);			
				}
				int insCnt = sqlExe.executeUpdate((ISQLTemplate)new CODCorrectionDBDAOaddAutoCodVvdCSQL(), param,velParam);
				if(insCnt == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert SQL");
				return insCnt;
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(),se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
			}	
		}
}