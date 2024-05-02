/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JapanCustomsTransmissionDAO.java
*@FileTitle : UI_BKG-0730
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.21
*@LastModifier : 김승민
*@LastVersion : 1.0
* 2009.04.21 김승민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japanterminal.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japan.basic.JapanCustomsTransmissionBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japanterminal.vo.BkgJapanTerminalEdiVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japanterminal.vo.BkgTerminalEdiDgCgoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japanterminal.vo.BkgTerminalEdiJapanAwkCgoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japanterminal.vo.BkgTerminalEdiJapanBlVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japanterminal.vo.BkgTerminalEdiJapanCntrVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japanterminal.vo.BkgTerminalEdiJapanDgCgoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japanterminal.vo.BkgTerminalEdiJapanRfCgoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japanterminal.vo.JapanTerminalEdiCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japanterminal.vo.VvdJapanTerminalEdiVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgCstmsJpRcvLogDtlVO;
import com.hanjin.syscommon.common.table.BkgCstmsJpRcvLogVO;
import com.hanjin.syscommon.common.table.BkgCstmsJpSndLogDtlVO;
import com.hanjin.syscommon.common.table.BkgCstmsJpSndLogVO;

/**
 * ALPS JapanCustomsTransmissionDAO <br>
 * - ALPS-CustomsDeclaration system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author KIM SEUNG MIN
 * @see JapanCustomsTransmissionBCImpl 참조
 * @since J2EE 1.4 
 */
@SuppressWarnings("serial")
public class JapanTerminalTransmissionDBDAO extends DBDAOSupport {

	/**
	 * 일본세관 신고용 Receive Log 테이블 Seq를 조회한다.<br>
	 * 
	 * @param String jpMsgTpCd
	 * @param String rcvDt
	 * @return int seqNumber
	 * @throws DAOException
	 */
	public int searchReceiveLogSeq(
			String jpMsgTpCd, 
			String rcvDt) throws DAOException {
		DBRowSet dbRowset = null;
		int seqNumber = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("jp_msg_tp_cd", jpMsgTpCd);
			param.put("rcv_dt", rcvDt);
 			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JapanTerminalTransmissionDBDAOsearchReceiveLogSeqRSQL(),param, velParam, true);
			 if (dbRowset.next()) {
				 seqNumber = dbRowset.getInt(1);
			 } else {
				 seqNumber = 0;					 
			 }			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return seqNumber;
	}	
	
	/**
	 * 일본세관 Manifest 수신 로그를 생성한다.<br>
	 * 
	 * @param BkgCstmsJpRcvLogVO bkgCstmsJpRcvLogVO
	 * @throws DAOException
	 */
	public void addReceiveLog(BkgCstmsJpRcvLogVO bkgCstmsJpRcvLogVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = bkgCstmsJpRcvLogVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);		
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new JapanTerminalTransmissionDBDAOaddReceiveLogCSQL(), param, velParam, true);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	
	/**
	 * 일본세관 Manifest 수신 로그(Detail)를 생성한다.<br>
	 * 
	 * @param BkgCstmsJpRcvLogDtlVO bkgCstmsJpRcvLogDtlVO
	 * @throws DAOException
	 */
	public void addReceiveLogDetail(BkgCstmsJpRcvLogDtlVO bkgCstmsJpRcvLogDtlVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = bkgCstmsJpRcvLogDtlVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);		
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new JapanTerminalTransmissionDBDAOaddReceiveLogDetailCSQL(), param, velParam, true);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 일본세관 Manifest 전송 로그를 생성한다.<br>
	 * 
	 * @param BkgCstmsJpSndLogVO bkgCstmsJpSndLogVO
	 * @param String bkgNo
	 * @param String bkgSkdSeq
	 * 
	 * @throws DAOException
	 */
	public void modifyBkgTmlEdiJpBl(BkgCstmsJpSndLogVO bkgCstmsJpSndLogVO, String bkgNo, String bkgSkdSeq) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = bkgCstmsJpSndLogVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);		
			param.put("bkg_no", bkgNo);
			param.put("bkg_skd_seq", bkgSkdSeq);
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new JapanTerminalTransmissionDBDAOmodifyBkgTmlEdiJpBlUSQL(), param, velParam, true);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 일본세관 Manifest 전송 로그를 생성한다.<br>
	 * 
	 * @param BkgCstmsJpSndLogVO bkgCstmsJpSndLogVO
	 * @throws DAOException
	 */
	public void addJapanTerminalSendLog(BkgCstmsJpSndLogVO bkgCstmsJpSndLogVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = bkgCstmsJpSndLogVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);		
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new JapanTerminalTransmissionDBDAOaddSendLogCSQL(), param, velParam, true);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 일본세관 Manifest 전송 로그(Detail)를 생성한다.<br>
	 * 
	 * @param BkgCstmsJpSndLogDtlVO bkgCstmsJpSndLogDtlVO
	 * @return int
	 * @throws DAOException
	 */
	public int addSendLogDetail(BkgCstmsJpSndLogDtlVO bkgCstmsJpSndLogDtlVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = bkgCstmsJpSndLogDtlVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);		
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new JapanTerminalTransmissionDBDAOaddSendLogDetailCSQL(), param, velParam, true);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	/**
	 *  조원주_Sea-NACCS 프로젝트 (20120312)
	 *  Japan batch schedule 조회
	 * 
	 * @param JapanTerminalEdiCondVO japanTerminalEdiCondVO
	 * @param SignOnUserAccount account
	 * @return List<VvdJapanTerminalEdiVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<VvdJapanTerminalEdiVO> searchVesselListForSchedule(JapanTerminalEdiCondVO japanTerminalEdiCondVO, SignOnUserAccount account) throws DAOException {
		DBRowSet dbRowset = null;
		List<VvdJapanTerminalEdiVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if (japanTerminalEdiCondVO != null){
				Map<String, String> mapVO = japanTerminalEdiCondVO.getColumnValues();
				
				param.put("usr_id", account.getUsr_id());
				param.put("ofc_cd", account.getOfc_cd());
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JapanTerminalTransmissionDBDAOsearchVesselListForScheduleRSQL(), param,velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, VvdJapanTerminalEdiVO.class);
		}catch (SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch (Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 *  조원주_Sea-NACCS 프로젝트 (20120312)
	 *  Japan batch schedule 조회
	 * 
	 * @param JapanTerminalEdiCondVO japanTerminalEdiCondVO
	 * @return List<VvdJapanTerminalEdiVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<VvdJapanTerminalEdiVO> searchVesselListForBKGRoute(JapanTerminalEdiCondVO japanTerminalEdiCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<VvdJapanTerminalEdiVO> list1 = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if (japanTerminalEdiCondVO != null){
				Map<String, String> mapVO = japanTerminalEdiCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JapanTerminalTransmissionDBDAOsearchVesselListForBkgRouteRSQL(), param,velParam);
			list1 = (List) RowSetUtil.rowSetToVOs(dbRowset, VvdJapanTerminalEdiVO.class);
		}catch (SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch (Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list1;
	}
	
	/**
	 * [CHM-201216099] Sea-NACCS 프로젝트스케줄 Retrieve 후 수정 SAVE<br>
	 * 
	 * @param VvdJapanTerminalEdiVO vvdJapanTerminalEdiVO
	 * @param  SignOnUserAccount account
	 * @throws EventException
	 * @throws DAOException 
	 */
	public void modifyVesselList(VvdJapanTerminalEdiVO vvdJapanTerminalEdiVO, SignOnUserAccount account) throws EventException, DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = -1;
		try	{
			Map<String, String> mapVO = vvdJapanTerminalEdiVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			param.put("ofc_cd", account.getOfc_cd());
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new JapanTerminalTransmissionDBDAOmodifyVesselListUSQL(), param,	velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		}catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [CHM-201216099] Sea-NACCS 프로젝트스케줄 Retrieve 후 수정 SAVE History 남김<br>
	 * 
	 * @param VvdJapanTerminalEdiVO vvdJapanTerminalEdiVO
	 * @throws EventException
	 * @throws DAOException 
	 */
	public void addVslSkdHis(VvdJapanTerminalEdiVO vvdJapanTerminalEdiVO) throws EventException, DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = -1;
		try	{
			Map<String, String> mapVO = vvdJapanTerminalEdiVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new JapanTerminalTransmissionDBDAOaddVslSkdHisCSQL(), param,	velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		}catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 *  김종옥_Sea-NACCS 프로젝트 (20120312)
	 *  Japan batch schedule 조회
	 * 
	 * @param JapanTerminalEdiCondVO japanTerminalEdiCondVO
	 * @param SignOnUserAccount account
	 * @return List<BkgJapanTerminalEdiVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgJapanTerminalEdiVO> searchBkgInfoForSchedule(JapanTerminalEdiCondVO japanTerminalEdiCondVO, SignOnUserAccount account) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgJapanTerminalEdiVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if (japanTerminalEdiCondVO != null){
				
				param.put("usr_id", account.getUsr_id());
				param.put("ofc_cd", account.getOfc_cd());
				
				Map<String, String> mapVO = japanTerminalEdiCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JapanTerminalTransmissionDBDAOsearchBkgInfoForScheduleRSQL(), param,velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgJapanTerminalEdiVO.class);
		}catch (SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch (Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 *  김종옥_Sea-NACCS 프로젝트 (20120312)
	 *  Japan batch schedule 조회
	 * 
	 * @param JapanTerminalEdiCondVO japanTerminalEdiCondVO
	 * @return List<BkgJapanTerminalEdiVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgJapanTerminalEdiVO> searchPartialBkgInfoForSchedule(JapanTerminalEdiCondVO japanTerminalEdiCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgJapanTerminalEdiVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if (japanTerminalEdiCondVO != null){
				Map<String, String> mapVO = japanTerminalEdiCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JapanTerminalTransmissionDBDAOsearchPartialBkgInfoForScheduleRSQL(), param,velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgJapanTerminalEdiVO.class);
		}catch (SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch (Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 *  판별로직 확인
	 *  Check 조회
	 * 
	 * @param BkgTerminalEdiJapanBlVO bkgTerminalEdiJapanBlVO
	 * @return String
	 * @throws EventException
	 * @throws SQLException
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchCheckColumns(BkgTerminalEdiJapanBlVO bkgTerminalEdiJapanBlVO) throws EventException,SQLException, DAOException {
		
		Map<String, String> velParam = new HashMap<String, String>();
		Map<String, String> param = new HashMap<String, String>();

		String out_chk_flg = "";
		param.put("bkg_no", bkgTerminalEdiJapanBlVO.getBkgNo());
		param.put("out_chk_flg", out_chk_flg);

		velParam.put("bkg_no", bkgTerminalEdiJapanBlVO.getBkgNo());
		param.put("out_chk_flg", out_chk_flg);

		SQLExecuter sqlExe = new SQLExecuter("");
		Map<String, Object> rtnrslt = sqlExe.executeSP((ISQLTemplate) new JapanTerminalTransmissionDBDAObkgTmlEdiJpColChkHisPrcRSQL(), param, velParam);
		
		String rtnStr = "";
		if (rtnrslt != null) 
			rtnStr = (String) rtnrslt.get("out_chk_flg");
		
		return rtnStr;
	}
	



	/**
	 *  searchNewBkgInfo
	 * 
	 * @param VvdJapanTerminalEdiVO vvdJapanTerminalEdiVO
	 * @return List<BkgTerminalEdiJapanBlVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgTerminalEdiJapanBlVO> searchNewBkgInfo(VvdJapanTerminalEdiVO vvdJapanTerminalEdiVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgTerminalEdiJapanBlVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
				
			Map<String, String> mapVO = vvdJapanTerminalEdiVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JapanTerminalTransmissionDBDAOsearchNewBkgInfoRSQL(), param,velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgTerminalEdiJapanBlVO.class);
		}catch (SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch (Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}	
	
	/**
	 *  searchCntrforNewBkgInfo
	 * 
	 * @param BkgTerminalEdiJapanBlVO bkgTerminalEdiJapanBlVO
	 * @return List<BkgTerminalEdiJapanCntrVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgTerminalEdiJapanCntrVO> searchCntrforNewBkgInfo(BkgTerminalEdiJapanBlVO bkgTerminalEdiJapanBlVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgTerminalEdiJapanCntrVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			Map<String, String> mapVO = bkgTerminalEdiJapanBlVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JapanTerminalTransmissionDBDAOsearchCntrforNewBkgInfoRSQL(), param,velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgTerminalEdiJapanCntrVO.class);
		}catch (SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch (Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}	
	
	/**
	 *  searchDgCgoforNewBkgInfo
	 * 
	 * @param BkgTerminalEdiJapanBlVO bkgTerminalEdiJapanBlVO
	 * @return List<BkgTerminalEdiJapanDgCgoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgTerminalEdiJapanDgCgoVO> searchDgCgoforNewBkgInfo(BkgTerminalEdiJapanBlVO bkgTerminalEdiJapanBlVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgTerminalEdiJapanDgCgoVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			Map<String, String> mapVO = bkgTerminalEdiJapanBlVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JapanTerminalTransmissionDBDAOsearchDgCgoforNewBkgInfoRSQL(), param,velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgTerminalEdiJapanDgCgoVO.class);
		}catch (SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch (Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 *  searchAwkCgoforNewBkgInfo
	 * 
	 * @param BkgTerminalEdiJapanBlVO bkgTerminalEdiJapanBlVO
	 * @return List<BkgTerminalEdiJapanAwkCgoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgTerminalEdiJapanAwkCgoVO> searchAwkCgoforNewBkgInfo(BkgTerminalEdiJapanBlVO bkgTerminalEdiJapanBlVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgTerminalEdiJapanAwkCgoVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			Map<String, String> mapVO = bkgTerminalEdiJapanBlVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JapanTerminalTransmissionDBDAOsearchAwkCgoforNewBkgInfoRSQL(), param,velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgTerminalEdiJapanAwkCgoVO.class);
		}catch (SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch (Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 *  searchRfCgoforNewBkgInfo
	 * 
	 * @param BkgTerminalEdiJapanBlVO bkgTerminalEdiJapanBlVO
	 * @return List<BkgTerminalEdiJapanRfCgoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgTerminalEdiJapanRfCgoVO> searchRfCgoforNewBkgInfo(BkgTerminalEdiJapanBlVO bkgTerminalEdiJapanBlVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgTerminalEdiJapanRfCgoVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			Map<String, String> mapVO = bkgTerminalEdiJapanBlVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JapanTerminalTransmissionDBDAOsearchRfCgoforNewBkgInfoRSQL(), param,velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgTerminalEdiJapanRfCgoVO.class);
		}catch (SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch (Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * addNewBkgInfo<br>
	 * 
	 * @param BkgTerminalEdiJapanBlVO bkgTerminalEdiJapanBlVO
	 * @param SignOnUserAccount account
	 * @throws DAOException 
	 */
	public void addNewBkgInfo(BkgTerminalEdiJapanBlVO bkgTerminalEdiJapanBlVO, SignOnUserAccount account) throws EventException, DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = -1;
		try	{
			Map<String, String> mapVO = bkgTerminalEdiJapanBlVO.getColumnValues();
			param.put("cre_usr_id", account.getUsr_id());
			param.put("upd_usr_id", account.getUsr_id());
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new JapanTerminalTransmissionDBDAOaddNewBkgInfoCSQL(), param,	velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		}catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * addNewBkgInfoMax<br>
	 * 
	 * @param BkgTerminalEdiJapanBlVO bkgTerminalEdiJapanBlVO
	 * @throws EventException
	 * @throws DAOException 
	 */
	public void addNewBkgInfoMax(BkgTerminalEdiJapanBlVO bkgTerminalEdiJapanBlVO) throws EventException, DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = -1;
		try	{
			Map<String, String> mapVO = bkgTerminalEdiJapanBlVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new JapanTerminalTransmissionDBDAOaddNewBkgInfoMaxCSQL(), param,	velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		}catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * updateNewBkgInfo<br>
	 * 
	 * @param BkgTerminalEdiJapanBlVO bkgTerminalEdiJapanBlVO
	 * @param SignOnUserAccount account
	 * @throws DAOException 
	 */
	public void updateNewBkgInfo(BkgTerminalEdiJapanBlVO bkgTerminalEdiJapanBlVO, SignOnUserAccount account) throws EventException, DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = -1;
		try	{
			Map<String, String> mapVO = bkgTerminalEdiJapanBlVO.getColumnValues();
			param.put("cre_usr_id", account.getUsr_id());
			param.put("upd_usr_id", account.getUsr_id());
			param.put("snd_ofc_cd", account.getOfc_cd());
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new JapanTerminalTransmissionDBDAOupdateNewBkgInfoUSQL(), param,	velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		}catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * updateNewBkgInfo<br>
	 * 
	 * @param BkgTerminalEdiJapanBlVO bkgTerminalEdiJapanBlVO
	 * @param SignOnUserAccount account
	 * @throws DAOException 
	 */
	public void updateNewBkgInfoVvdChk(BkgTerminalEdiJapanBlVO bkgTerminalEdiJapanBlVO, SignOnUserAccount account) throws EventException, DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = -1;
		try	{
			Map<String, String> mapVO = bkgTerminalEdiJapanBlVO.getColumnValues();
			param.put("cre_usr_id", account.getUsr_id());
			param.put("upd_usr_id", account.getUsr_id());
			param.put("snd_ofc_cd", account.getOfc_cd());
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new JapanTerminalTransmissionDBDAOupdateNewBkgInfoVvdChkUSQL(), param,	velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		}catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * addCntrforNewBkgInfo<br>
	 * 
	 * @param List<BkgTerminalEdiJapanCntrVO> insetVOs
	 * @param SignOnUserAccount account
	 * @throws DAOException 
	 */
	public void addCntrforNewBkgInfo(List<BkgTerminalEdiJapanCntrVO> insetVOs, SignOnUserAccount account) throws EventException, DAOException {
		try	{
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			int result = 0;
			for(int i=0; i<insetVOs.size(); i++){
				BkgTerminalEdiJapanCntrVO vo = insetVOs.get(i);
				Map<String, String> mapVO = vo.getColumnValues();
				param.put("cre_usr_id", account.getUsr_id());
				param.put("upd_usr_id", account.getUsr_id());
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new JapanTerminalTransmissionDBDAOaddCntrforNewBkgInfoCSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update SQL");
			}			
		}catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * addDgCgoforNewBkgInfo<br>
	 * 
	 * @param List<BkgTerminalEdiJapanDgCgoVO> insetVOs
	 * @param SignOnUserAccount account
	 * @throws DAOException 
	 */
	public void addDgCgoforNewBkgInfo(List<BkgTerminalEdiJapanDgCgoVO> insetVOs, SignOnUserAccount account) throws EventException, DAOException {
		try	{
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			int result = 0;
			for(int i=0; i<insetVOs.size(); i++){
				BkgTerminalEdiJapanDgCgoVO vo = insetVOs.get(i);
				Map<String, String> mapVO = vo.getColumnValues();
				param.put("cre_usr_id", account.getUsr_id());
				param.put("upd_usr_id", account.getUsr_id());
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new JapanTerminalTransmissionDBDAOaddDgCgoforNewBkgInfoCSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update SQL");
			}
		}catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * addAwkCgoforNewBkgInfo<br>
	 * 
	 * @param List<BkgTerminalEdiJapanAwkCgoVO> insetVOs
	 * @param SignOnUserAccount account
	 * @throws DAOException 
	 */
	public void addAwkCgoforNewBkgInfo(List<BkgTerminalEdiJapanAwkCgoVO> insetVOs, SignOnUserAccount account) throws EventException, DAOException {
		try	{
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			int result = 0;
			for(int i=0; i<insetVOs.size(); i++){
				BkgTerminalEdiJapanAwkCgoVO vo = insetVOs.get(i);
				Map<String, String> mapVO = vo.getColumnValues();
				param.put("cre_usr_id", account.getUsr_id());
				param.put("upd_usr_id", account.getUsr_id());
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new JapanTerminalTransmissionDBDAOaddAwkCgoforNewBkgInfoCSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update SQL");
			}
		}catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * addRfCgoforNewBkgInfo<br>
	 * 
	 * @param List<BkgTerminalEdiJapanRfCgoVO> insetVOs
	 * @param SignOnUserAccount account
	 * @throws DAOException 
	 */
	public void addRfCgoforNewBkgInfo(List<BkgTerminalEdiJapanRfCgoVO> insetVOs, SignOnUserAccount account) throws EventException, DAOException {
		try	{
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			int result = 0;
			for(int i=0; i<insetVOs.size(); i++){
				BkgTerminalEdiJapanRfCgoVO vo = insetVOs.get(i);
				Map<String, String> mapVO = vo.getColumnValues();
				param.put("cre_usr_id", account.getUsr_id());
				param.put("upd_usr_id", account.getUsr_id());
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new JapanTerminalTransmissionDBDAOaddRfCgoforNewBkgInfoCSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update SQL");
			}
		}catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [CHM-201216099] Sea-NACCS 프로젝트스케줄 check 후 삭제 <br>
	 * 
	 * @param VvdJapanTerminalEdiVO vvdJapanTerminalEdiVO
	 * @throws DAOException 
	 */
	public void removeVesselList(VvdJapanTerminalEdiVO vvdJapanTerminalEdiVO) throws EventException, DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = -1;
		try	{
			Map<String, String> mapVO = vvdJapanTerminalEdiVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new JapanTerminalTransmissionDBDAOremoveVesselListUSQL(), param,	velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		}catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [CHM-201216099] Sea-NACCS 프로젝트스케줄 check 후 삭제 <br>
	 * 
	 * @param VvdJapanTerminalEdiVO vvdJapanTerminalEdiVO
	 * @throws DAOException 
	 */
	public void removeVesselListBe(VvdJapanTerminalEdiVO vvdJapanTerminalEdiVO) throws EventException, DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = -1;
		try	{
			Map<String, String> mapVO = vvdJapanTerminalEdiVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			param.put("pol_yd_cd", vvdJapanTerminalEdiVO.getBePolYdCd());
			param.put("por_yd_cd", vvdJapanTerminalEdiVO.getBePorYdCd());
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new JapanTerminalTransmissionDBDAOremoveVesselListUSQL(), param,	velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		}catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * [CHM-201216099] Sea-NACCS 프로젝트스케줄 check 후 삭제 JP_BL 테이블에 삭제FLG 업데이트<br>
	 * 
	 * @param VvdJapanTerminalEdiVO vvdJapanTerminalEdiVO
	 * @throws DAOException 
	 */
	public void removeVesselListJpBl(VvdJapanTerminalEdiVO vvdJapanTerminalEdiVO) throws EventException, DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = -1;
		try	{
			Map<String, String> mapVO = vvdJapanTerminalEdiVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new JapanTerminalTransmissionDBDAOremoveVesselListJpBlUSQL(), param,	velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		}catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [CHM-201216099] Sea-NACCS 프로젝트스케줄 check 후 삭제 JP_BL 테이블에 삭제FLG 업데이트<br>
	 * 
	 * @param VvdJapanTerminalEdiVO vvdJapanTerminalEdiVO
	 * @throws DAOException 
	 */
	public void removeVesselListJpBlBe(VvdJapanTerminalEdiVO vvdJapanTerminalEdiVO) throws EventException, DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = -1;
		try	{
			Map<String, String> mapVO = vvdJapanTerminalEdiVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			param.put("pol_yd_cd", vvdJapanTerminalEdiVO.getBePolYdCd());
			param.put("por_yd_cd", vvdJapanTerminalEdiVO.getBePorYdCd());
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new JapanTerminalTransmissionDBDAOremoveVesselListJpBlUSQL(), param,	velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		}catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [CHM-201216099] Sea-NACCS 프로젝트스케줄 등록 <br>
	 * 
	 * @param VvdJapanTerminalEdiVO vvdJapanTerminalEdiVO
	 * @param SignOnUserAccount account
	 * @throws DAOException 
	 */
	public void addVesselListByBKGRoute(VvdJapanTerminalEdiVO vvdJapanTerminalEdiVO, SignOnUserAccount account) throws EventException, DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = -1;
		try	{
			Map<String, String> mapVO = vvdJapanTerminalEdiVO.getColumnValues();
			param.put("cre_usr_id", account.getUsr_id());
			param.put("ofc_cd", account.getOfc_cd());
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new JapanTerminalTransmissionDBDAOaddVesselListByBkgRouteCSQL(), param,	velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		}catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
    /**
     * [CHM-201216099][2012.03.15 By 조원주]BKG Route가 올바른 것인지 check flg 조회.
     * 배치 스케줄 Update, Insert 시에 BKG Route check하여 저장
     *  
     * @param VvdJapanTerminalEdiVO vvdJapanTerminalEdiVO
     * @return String chkFlg
     * @exception DAOException
     */
    public String searchCheckRoute(VvdJapanTerminalEdiVO vvdJapanTerminalEdiVO) throws DAOException {
    	// input_text
        String chkFlg = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            
        	Map<String, String> mapVO = vvdJapanTerminalEdiVO.getColumnValues();
            param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			JapanTerminalTransmissionDBDAOsearchCheckRouteRSQL template = new JapanTerminalTransmissionDBDAOsearchCheckRouteRSQL();

			DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);
			
			
			if (dbRowset.next()) {
				chkFlg = dbRowset.getString("OUTPUT_TEXT");
			} else {
				chkFlg = "";
			}
		
			
        } catch(SQLException ex) {
            // log.error(se.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch(Exception ex) {
            // log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return chkFlg;
    } 
    
    /**
     * [CHM-201216099][2012.03.15 By 조원주]BKG Route가 올바른 것인지 check flg 조회.
     * 배치 스케줄 Update, Insert 시에 BKG Route check하여 저장
     *  
     * @param VvdJapanTerminalEdiVO vvdJapanTerminalEdiVO
     * @return String flg
     * @exception DAOException
     */
    public String searchCheckTableData(VvdJapanTerminalEdiVO vvdJapanTerminalEdiVO) throws DAOException {
    	// input_text
        String flg = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            
        	Map<String, String> mapVO = vvdJapanTerminalEdiVO.getColumnValues();
            param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			JapanTerminalTransmissionDBDAOsearchTmlEdiJpBatVvdSkdRSQL template = new JapanTerminalTransmissionDBDAOsearchTmlEdiJpBatVvdSkdRSQL();

			DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);
				
			
			if (dbRowset.next()) {
				flg = dbRowset.getString("OUTPUT_TEXT");
			} else {
				flg = "";
			}
		
			
        } catch(SQLException ex) {
            // log.error(se.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch(Exception ex) {
            // log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return flg;
    }
    
	/**
	 * searchNewBkgSeq<br>
	 * 
	 * @param BkgTerminalEdiJapanBlVO bkgTerminalEdiJapanBlVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchNewBkgSeq(BkgTerminalEdiJapanBlVO bkgTerminalEdiJapanBlVO) throws DAOException {
		DBRowSet dbRowset = null;
		String max_seq = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgTerminalEdiJapanBlVO != null){
				Map<String, String> mapVO = bkgTerminalEdiJapanBlVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JapanTerminalTransmissionDBDAOsearchNewBkgSeqRSQL(), param, velParam);
			if(dbRowset.next()){
				max_seq = dbRowset.getString("max_seq");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return max_seq;
	}	

	/**
	 * searchCntrforNewBkgDelFlg<br>
	 * 
	 * @param BkgTerminalEdiJapanBlVO bkgTerminalEdiJapanBlVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchCntrforNewBkgDelFlg(BkgTerminalEdiJapanBlVO bkgTerminalEdiJapanBlVO) throws DAOException {
		DBRowSet dbRowset = null;
		String del_flg = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgTerminalEdiJapanBlVO != null){
				Map<String, String> mapVO = bkgTerminalEdiJapanBlVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JapanTerminalTransmissionDBDAOsearchCntrforNewBkgDelFlgRSQL(), param, velParam);
			if(dbRowset.next()){
				del_flg = dbRowset.getString("snaccs_tml_edi_sts_cd");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return del_flg;
	}	

	
	/**
	 * searchCntrforNewBkgSeq<br>
	 * 
	 * @param BkgTerminalEdiJapanBlVO bkgTerminalEdiJapanBlVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchCntrforNewBkgSeq(BkgTerminalEdiJapanBlVO bkgTerminalEdiJapanBlVO) throws DAOException {
		DBRowSet dbRowset = null;
		String max_seq = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgTerminalEdiJapanBlVO != null){
				Map<String, String> mapVO = bkgTerminalEdiJapanBlVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JapanTerminalTransmissionDBDAOsearchCntrforNewBkgSeqRSQL(), param, velParam);
			if(dbRowset.next()){
				max_seq = dbRowset.getString("max_seq");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return max_seq;
	}	

	/**
	 * addCntrforNewBkgInfoMax<br>
	 * 
	 * @param List<BkgTerminalEdiJapanCntrVO> insetVOs
	 * @param String max_seq
	 * @throws DAOException 
	 */
	public void addCntrforNewBkgInfoMax(List<BkgTerminalEdiJapanCntrVO> insetVOs, String max_seq) throws EventException, DAOException {
		try	{
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			int result = 0;
			//for(int i=0; i<insetVOs.size(); i++){
			for(int i=0; i<1; i++){				
				BkgTerminalEdiJapanCntrVO vo = insetVOs.get(i);
				Map<String, String> mapVO = vo.getColumnValues();
				param.put("max_seq", max_seq);				
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new JapanTerminalTransmissionDBDAOaddCntrforNewBkgInfoMaxCSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update SQL");
			}
		}catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	

	/**
	 * updateCntrforNewBkgInfo<br>
	 * 
	 * @param List<BkgTerminalEdiJapanCntrVO> insetVOs
	 * @param SignOnUserAccount account
	 * @throws DAOException 
	 */
	public void updateCntrforNewBkgInfo(List<BkgTerminalEdiJapanCntrVO> insetVOs, SignOnUserAccount account) throws EventException, DAOException {
		try	{
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			int result = 0;
			for(int i=0; i<insetVOs.size(); i++){
				BkgTerminalEdiJapanCntrVO vo = insetVOs.get(i);
				Map<String, String> mapVO = vo.getColumnValues();
				param.put("cre_usr_id", account.getUsr_id());
				param.put("upd_usr_id", account.getUsr_id());
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new JapanTerminalTransmissionDBDAOupdateCntrforNewBkgInfoUSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update SQL");
			}			
		}catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * deleteCntrforNewBkgInfo<br>
	 * 
	 * @param List<BkgTerminalEdiJapanCntrVO> insetVOs
	 * @throws DAOException 
	 */
	public void deleteCntrforNewBkgInfo(List<BkgTerminalEdiJapanCntrVO> insetVOs) throws EventException, DAOException {
		try	{
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			int result = 0;
			for(int i=0; i<1; i++){
				BkgTerminalEdiJapanCntrVO vo = insetVOs.get(i);
				Map<String, String> mapVO = vo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new JapanTerminalTransmissionDBDAOdeleteCntrforNewBkgInfoDSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update SQL");
			}			
		}catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * searchAwkCgoforNewBkgSeq<br>
	 * 
	 * @param BkgTerminalEdiJapanBlVO bkgTerminalEdiJapanBlVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchAwkCgoforNewBkgSeq(BkgTerminalEdiJapanBlVO bkgTerminalEdiJapanBlVO) throws DAOException {
		DBRowSet dbRowset = null;
		String max_seq = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgTerminalEdiJapanBlVO != null){
				Map<String, String> mapVO = bkgTerminalEdiJapanBlVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JapanTerminalTransmissionDBDAOsearchAwkCgoforNewBkgSeqRSQL(), param, velParam);
			if(dbRowset.next()){
				max_seq = dbRowset.getString("max_seq");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return max_seq;
	}	
	
	/**
	 * addAwkCgoforNewBkgInfoMax<br>
	 * 
	 * @param List<BkgTerminalEdiJapanAwkCgoVO> insetVOs
	 * @param String max_seq
	 * @throws DAOException 
	 */
	public void addAwkCgoforNewBkgInfoMax(List<BkgTerminalEdiJapanAwkCgoVO> insetVOs, String max_seq) throws EventException, DAOException {
		try	{
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			int result = 0;
			//for(int i=0; i<insetVOs.size(); i++){
			for(int i=0; i<1; i++){
				BkgTerminalEdiJapanAwkCgoVO vo = insetVOs.get(i);
				Map<String, String> mapVO = vo.getColumnValues();
				param.put("max_seq", max_seq);				
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new JapanTerminalTransmissionDBDAOaddAwkCgoforNewBkgInfoMaxCSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update SQL");
			}
		}catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	

	/**
	 * updateAwkCgoforNewBkgInfo<br>
	 * 
	 * @param List<BkgTerminalEdiJapanAwkCgoVO> insetVOs
	 * @param SignOnUserAccount account
	 * @throws DAOException 
	 */
	public void updateAwkCgoforNewBkgInfo(List<BkgTerminalEdiJapanAwkCgoVO> insetVOs, SignOnUserAccount account) throws EventException, DAOException {
		try	{
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			int result = 0;
			for(int i=0; i<insetVOs.size(); i++){
				BkgTerminalEdiJapanAwkCgoVO vo = insetVOs.get(i);
				Map<String, String> mapVO = vo.getColumnValues();
				param.put("cre_usr_id", account.getUsr_id());
				param.put("upd_usr_id", account.getUsr_id());
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new JapanTerminalTransmissionDBDAOupdateAwkCgoforNewBkgInfoUSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update SQL");
			}			
		}catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * deleteAwkCgoforNewBkgInfo<br>
	 * 
	 * @param List<BkgTerminalEdiJapanAwkCgoVO> insetVOs
	 * @throws DAOException 
	 */
	public void deleteAwkCgoforNewBkgInfo(List<BkgTerminalEdiJapanAwkCgoVO> insetVOs) throws EventException, DAOException {
		try	{
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			int result = 0;
			for(int i=0; i<1; i++){
				BkgTerminalEdiJapanAwkCgoVO vo = insetVOs.get(i);
				Map<String, String> mapVO = vo.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new JapanTerminalTransmissionDBDAOdeleteAwkCgoforNewBkgInfoDSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update SQL");
			}			
		}catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * searchDgCgoforNewBkgSeq<br>
	 * 
	 * @param BkgTerminalEdiJapanBlVO bkgTerminalEdiJapanBlVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchDgCgoforNewBkgSeq(BkgTerminalEdiJapanBlVO bkgTerminalEdiJapanBlVO) throws DAOException {
		DBRowSet dbRowset = null;
		String max_seq = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgTerminalEdiJapanBlVO != null){
				Map<String, String> mapVO = bkgTerminalEdiJapanBlVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JapanTerminalTransmissionDBDAOsearchDgCgoforNewBkgSeqRSQL(), param, velParam);
			if(dbRowset.next()){
				max_seq = dbRowset.getString("max_seq");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return max_seq;
	}	
	
	/**
	 * addDgCgoforNewBkgInfoMax<br>
	 * 
	 * @param List<BkgTerminalEdiJapanDgCgoVO> insetVOs
	 * @param String max_seq
	 * @throws EventException
	 * @throws DAOException 
	 */
	public void addDgCgoforNewBkgInfoMax(List<BkgTerminalEdiJapanDgCgoVO> insetVOs, String max_seq) throws EventException, DAOException {
		try	{
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			int result = 0;
			//for(int i=0; i<insetVOs.size(); i++){
			for(int i=0; i<1; i++){
				BkgTerminalEdiJapanDgCgoVO vo = insetVOs.get(i);
				Map<String, String> mapVO = vo.getColumnValues();
				param.put("max_seq", max_seq);				
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new JapanTerminalTransmissionDBDAOaddDgCgoforNewBkgInfoMaxCSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update SQL");
			}
		}catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	

	/**
	 * updateDgCgoforNewBkgInfo<br>
	 * 
	 * @param List<BkgTerminalEdiJapanDgCgoVO> insetVOs
	 * @param SignOnUserAccount account
	 * @throws DAOException 
	 */
	public void updateDgCgoforNewBkgInfo(List<BkgTerminalEdiJapanDgCgoVO> insetVOs, SignOnUserAccount account) throws EventException, DAOException {
		try	{
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			int result = 0;
			for(int i=0; i<insetVOs.size(); i++){
				BkgTerminalEdiJapanDgCgoVO vo = insetVOs.get(i);
				Map<String, String> mapVO = vo.getColumnValues();
				param.put("cre_usr_id", account.getUsr_id());
				param.put("upd_usr_id", account.getUsr_id());
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new JapanTerminalTransmissionDBDAOupdateDgCgoforNewBkgInfoUSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update SQL");
			}			
		}catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * deleteDgCgoforNewBkgInfo<br>
	 * 
	 * @param List<BkgTerminalEdiJapanDgCgoVO> insetVOs
	 * @throws DAOException 
	 */
	public void deleteDgCgoforNewBkgInfo(List<BkgTerminalEdiJapanDgCgoVO> insetVOs) throws EventException, DAOException {
		try	{
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			int result = 0;
			for(int i=0; i<1; i++){
				BkgTerminalEdiJapanDgCgoVO vo = insetVOs.get(i);
				Map<String, String> mapVO = vo.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new JapanTerminalTransmissionDBDAOdeleteDgCgoforNewBkgInfoDSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update SQL");
			}			
		}catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * searchRfCgoforNewBkgSeq<br>
	 * 
	 * @param BkgTerminalEdiJapanBlVO bkgTerminalEdiJapanBlVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchRfCgoforNewBkgSeq(BkgTerminalEdiJapanBlVO bkgTerminalEdiJapanBlVO) throws DAOException {
		DBRowSet dbRowset = null;
		String max_seq = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgTerminalEdiJapanBlVO != null){
				Map<String, String> mapVO = bkgTerminalEdiJapanBlVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JapanTerminalTransmissionDBDAOsearchRfCgoforNewBkgSeqRSQL(), param, velParam);
			if(dbRowset.next()){
				max_seq = dbRowset.getString("max_seq");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return max_seq;
	}	
	
	/**
	 * addRfCgoforNewBkgInfoMax<br>
	 * 
	 * @param List<BkgTerminalEdiJapanRfCgoVO> insetVOs
	 * @param String max_seq
	 * @throws EventException
	 * @throws DAOException 
	 */
	public void addRfCgoforNewBkgInfoMax(List<BkgTerminalEdiJapanRfCgoVO> insetVOs, String max_seq) throws EventException, DAOException {
		try	{
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			int result = 0;
			//for(int i=0; i<insetVOs.size(); i++){
			for(int i=0; i<1; i++){
				
				BkgTerminalEdiJapanRfCgoVO vo = insetVOs.get(i);
				Map<String, String> mapVO = vo.getColumnValues();
				param.put("max_seq", max_seq);				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new JapanTerminalTransmissionDBDAOaddRfCgoforNewBkgInfoMaxCSQL(), param, velParam);
				
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update SQL");
			}
		}catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	

	/**
	 * updateRfCgoforNewBkgInfo<br>
	 * 
	 * @param List<BkgTerminalEdiJapanRfCgoVO> insetVOs
	 * @param SignOnUserAccount account
	 * @throws DAOException 
	 */
	public void updateRfCgoforNewBkgInfo(List<BkgTerminalEdiJapanRfCgoVO> insetVOs, SignOnUserAccount account) throws EventException, DAOException {
		try	{
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			int result = 0;
			for(int i=0; i<insetVOs.size(); i++){
				BkgTerminalEdiJapanRfCgoVO vo = insetVOs.get(i);
				Map<String, String> mapVO = vo.getColumnValues();
				param.put("cre_usr_id", account.getUsr_id());
				param.put("upd_usr_id", account.getUsr_id());
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new JapanTerminalTransmissionDBDAOupdateRfCgoforNewBkgInfoUSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update SQL");
			}			
		}catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * deleteRfCgoforNewBkgInfo<br>
	 * 
	 * @param List<BkgTerminalEdiJapanRfCgoVO> insetVOs
	 * @throws DAOException 
	 */
	public void deleteRfCgoforNewBkgInfo(List<BkgTerminalEdiJapanRfCgoVO> insetVOs) throws EventException, DAOException {
		try	{
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			int result = 0;
			for(int i=0; i<1; i++){
				BkgTerminalEdiJapanRfCgoVO vo = insetVOs.get(i);
				Map<String, String> mapVO = vo.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new JapanTerminalTransmissionDBDAOdeleteRfCgoforNewBkgInfoDSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update SQL");
			}			
		}catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	 
    /**
     * [CHM-201216099][2012.03.15 By 조원주]BKG Route가 올바른 것인지 check flg 조회.
     * 배치 스케줄 Update, Insert 시에 BKG Route check하여 저장
     *  
     * @param String ydCd
     * @return String flg
     * @exception DAOException
     */
    public String searchCYCode(String ydCd) throws DAOException {
    	// input_text
        String flg = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
        	
        	param.put("yd_cd", ydCd);
        	velParam.put("yd_cd", ydCd);
			SQLExecuter sqlExe = new SQLExecuter("");
			JapanTerminalTransmissionDBDAOsearchJapanCYCodeRSQL template = new JapanTerminalTransmissionDBDAOsearchJapanCYCodeRSQL();

			DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);
			
			
			if (dbRowset.next()) {
				flg = dbRowset.getString("cy_cd");
			} else {
				flg = "";
			}
		
			
        } catch(SQLException ex) {
            // log.error(se.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch(Exception ex) {
            // log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return flg;
    } 
    
    /**
     * [CHM-201216099][2012.03.15 By 조원주]BKG Route가 올바른 것인지 check flg 조회.
     * 배치 스케줄 Update, Insert 시에 BKG Route check하여 저장
     *  
     * @param String ventRto
     * @return String flg
     * @exception DAOException
     */
    public String searchJapanTmlEdiVentRTO(String ventRto) throws DAOException {
    	// input_text
        String flg = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
        	
        	param.put("vent_rto", ventRto);
        	velParam.put("vent_rto", ventRto);
			SQLExecuter sqlExe = new SQLExecuter("");
			JapanTerminalTransmissionDBDAOsearchJapanTmlEdiVentRTORSQL template = new JapanTerminalTransmissionDBDAOsearchJapanTmlEdiVentRTORSQL();

			DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);
			
			
			if (dbRowset.next()) {
				flg = dbRowset.getString("vent_cd");
			} else {
				flg = "";
			}
		
			
        } catch(SQLException ex) {
            // log.error(se.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch(Exception ex) {
            // log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return flg;
    } 
    
    
    
    /**
     * [CHM-201216099][2012.03.15 By 조원주]공통코드 조회.
     * 
     *  
     * @param String inStsCd
     * @return String flg
     * @exception DAOException
     */
    public String searchEdiStsCode(String inStsCd) throws DAOException {
    	// input_text
        String flg = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
        	
        	param.put("in_sts_cd", inStsCd);
        	velParam.put("in_sts_cd", inStsCd);
			SQLExecuter sqlExe = new SQLExecuter("");
			JapanTerminalTransmissionDBDAOsearchJapanEdiStsCodeRSQL template = new JapanTerminalTransmissionDBDAOsearchJapanEdiStsCodeRSQL();

			DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);
			
			
			if (dbRowset.next()) {
				flg = dbRowset.getString("sts_cd");
			} else {
				flg = "";
			}
		
			
        } catch(SQLException ex) {
            // log.error(se.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch(Exception ex) {
            // log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return flg;
    } 
    
    
    /**
     * [CHM-201216099][2012.03.15 By 조원주]BKG Route가 올바른 것인지 check flg 조회.
     * 배치 스케줄 Update, Insert 시에 BKG Route check하여 저장
     *  
     * @param String bkgNo
     * @return BkgTerminalEdiJapanCntrVO cntrVO
     * @exception DAOException
     */
    public BkgTerminalEdiJapanCntrVO searchJapanCntrPKGInfo(String bkgNo) throws DAOException {
    	
    	BkgTerminalEdiJapanCntrVO cntrVO = new BkgTerminalEdiJapanCntrVO();
       
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
        	
        	param.put("bkg_no", bkgNo);
        	//velParam.put("bkg_no", bkgNo);
			SQLExecuter sqlExe = new SQLExecuter("");
			JapanTerminalTransmissionDBDAOsearchJapanCntrPKGInfoRSQL template = new JapanTerminalTransmissionDBDAOsearchJapanCntrPKGInfoRSQL();

			DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);
			
			
			if (dbRowset.next()) {
				cntrVO.setPckQty(dbRowset.getString("PCK_QTY"));
				cntrVO.setPckTpCd(dbRowset.getString("PCK_TP_CD"));
				cntrVO.setCntrWgt(dbRowset.getString("CNTR_WGT"));
				cntrVO.setWgtUtCd(dbRowset.getString("WGT_UT_CD"));
				cntrVO.setMeasQty(dbRowset.getString("MEAS_QTY"));
				cntrVO.setMeasUtCd(dbRowset.getString("MEAS_UT_CD"));
				
			} else {
				cntrVO.setPckTpCd("");
				cntrVO.setPckTpCd("");
				cntrVO.setCntrWgt("");
				cntrVO.setWgtUtCd("");
				cntrVO.setMeasQty("");
				cntrVO.setMeasUtCd("");
			}
		
			
        } catch(SQLException ex) {
            // log.error(se.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch(Exception ex) {
            // log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return cntrVO;
    } 
    
    /**
	 *  searchRfCgoforNewBkgInfo
	 * 
	 * @param String bkgNo
	 * @return List<BkgTerminalEdiJapanCntrVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgTerminalEdiJapanCntrVO> searchJapanCntrInfo(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgTerminalEdiJapanCntrVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			param.put("bkg_no", bkgNo);
			//param.putAll(mapVO);
			//velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JapanTerminalTransmissionDBDAOsearchJapanCntrInfoRSQL(), param,velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgTerminalEdiJapanCntrVO.class);
		}catch (SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch (Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
    
	
    
    /**
     * [CHM-201216099][2012.03.15 By 조원주]BKG Route가 올바른 것인지 check flg 조회.
     * 배치 스케줄 Update, Insert 시에 BKG Route check하여 저장
     *  
     * @param String bkgNo
     * @param String cntrTpszCd
     * @return BkgTerminalEdiJapanBlVO blVO
     * @exception DAOException
     */
    public BkgTerminalEdiJapanBlVO searchJapanCntrStowageInfo(String bkgNo, String cntrTpszCd) throws DAOException {
    	
    	BkgTerminalEdiJapanBlVO blVO = new BkgTerminalEdiJapanBlVO();
       
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
        	
        	param.put("bkg_no", bkgNo);
        	param.put("cntr_tpsz_cd", cntrTpszCd);
        	//velParam.put("bkg_no", bkgNo);
			SQLExecuter sqlExe = new SQLExecuter("");
			JapanTerminalTransmissionDBDAOsearchJapanStowageInfoRSQL template = new JapanTerminalTransmissionDBDAOsearchJapanStowageInfoRSQL();

			DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);
			
			
			if (dbRowset.next()) {
				blVO.setStwgRmk(dbRowset.getString("STWG_REMARK"));
				blVO.setBlckStwgCd(dbRowset.getString("BLKSTWG"));
				blVO.setDryCgoFlg(dbRowset.getString("RD_IND"));
				blVO.setMcntrFlg(dbRowset.getString("MT_IND"));
				blVO.setSocFlg(dbRowset.getString("SOC_IND"));
				blVO.setEqSubstFlg(dbRowset.getString("RF_RRE"));
				
				
			} else {
				blVO.setStwgRmk("");
				blVO.setBlckStwgCd("");
				blVO.setDryCgoFlg("");
				blVO.setMcntrFlg("");
				blVO.setSocFlg("");
				blVO.setEqSubstFlg("");
			}
		
			
        } catch(SQLException ex) {
            // log.error(se.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch(Exception ex) {
            // log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return blVO;
    } 
    
    /**
     * [CHM-201216099][2012.03.15 By 조원주]BKG Route가 올바른 것인지 check flg 조회.
     * 배치 스케줄 Update, Insert 시에 BKG Route check하여 저장
     *  
     * @param String bkgNo
     * @param String cntrTpszCd
     * @return BkgTerminalEdiJapanRfCgoVO rfVO
     * @exception DAOException
     */
    public BkgTerminalEdiJapanRfCgoVO searchJapanRFCgoInfo(String bkgNo, String cntrTpszCd) throws DAOException {
    	
    	BkgTerminalEdiJapanRfCgoVO rfVO = new BkgTerminalEdiJapanRfCgoVO();
       
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
        	
        	param.put("bkg_no", bkgNo);
        	param.put("cntr_tpsz_cd", cntrTpszCd);
        	//velParam.put("bkg_no", bkgNo);
			SQLExecuter sqlExe = new SQLExecuter("");
			JapanTerminalTransmissionDBDAOsearchJapanRFCgoInfoRSQL template = new JapanTerminalTransmissionDBDAOsearchJapanRFCgoInfoRSQL();

			DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);
			
			
			if (dbRowset.next()) {
				rfVO.setCdoTemp(dbRowset.getString("TEMP_MAX"));//CDO TEMP 확인
				rfVO.setClngTpCd(dbRowset.getString("TEMP_UNIT"));
				rfVO.setHumidNo(dbRowset.getString("HUMID"));
				rfVO.setVentRto(dbRowset.getString("VENT_RTO"));
				
			} else {
				rfVO.setCdoTemp("");
				rfVO.setClngTpCd("");
				rfVO.setHumidNo("");
				rfVO.setVentRto("");
			}
		
			
        } catch(SQLException ex) {
            // log.error(se.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch(Exception ex) {
            // log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return rfVO;
    } 
    
	/**
	 * chkStrNull
	 * sendTerminalEdi flat file 생성시 NULL 체크를 한다.
	 * 
	 * @param chkStr
	 * @return String
	 */
	public String chkStrNull(String chkStr){
		
		String strRslt="";
		if("".equals(chkStr)||chkStr==null){
			strRslt="";
		}else{
			strRslt=chkStr;
		}
		
		return strRslt;
	}
    
    /**
     * [CHM-201216099][2012.03.15 By 조원주]BKG Route가 올바른 것인지 check flg 조회.
     * 배치 스케줄 Update, Insert 시에 BKG Route check하여 저장
     *  
     * @param String bkgNo
     * @param String cntrTpszCd
     * @return BkgTerminalEdiJapanAwkCgoVO awkVO
     * @exception DAOException
     */
    public BkgTerminalEdiJapanAwkCgoVO searchJapanAWKCgoInfo(String bkgNo, String cntrTpszCd) throws DAOException {
    	
    	BkgTerminalEdiJapanAwkCgoVO awkVO = new BkgTerminalEdiJapanAwkCgoVO();
       
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
        	
        	param.put("bkg_no", bkgNo);
        	param.put("cntr_tpsz_cd", cntrTpszCd);
        	//velParam.put("bkg_no", bkgNo);
			SQLExecuter sqlExe = new SQLExecuter("");
			JapanTerminalTransmissionDBDAOsearchJapanAWKCgoInfoRSQL template = new JapanTerminalTransmissionDBDAOsearchJapanAWKCgoInfoRSQL();

			DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);
			
			
			if (dbRowset.next()) {
				awkVO.setOvrHgt(dbRowset.getString("OVH"));
				awkVO.setOvrLfLen(dbRowset.getString("OVLW"));
				awkVO.setOvrRtLen(dbRowset.getString("OVRW"));
				awkVO.setOvfr(dbRowset.getString("OVFR"));	
				awkVO.setOvrVoidSltQty(dbRowset.getString("VOID_SLOT"));
			} else {
				awkVO.setOvrHgt("");
				awkVO.setOvrLfLen("");
				awkVO.setOvrRtLen("");
				awkVO.setOvfr("");
				awkVO.setOvrVoidSltQty("");
			}
		
			
        } catch(SQLException ex) {
            // log.error(se.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch(Exception ex) {
            // log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return awkVO;
    }
    
    /**
     * [CHM-201216099][2012.03.15 By 조원주]BKG Route가 올바른 것인지 check flg 조회.
     * 배치 스케줄 Update, Insert 시에 BKG Route check하여 저장
     *  
     * @param String bkgNo 
     * @param String cntrTpszCd
     * @return BkgTerminalEdiJapanDgCgoVO dgVO
     * @exception DAOException
     */
    public BkgTerminalEdiJapanDgCgoVO searchJapanDGCgoInfo(String bkgNo, String cntrTpszCd) throws DAOException {
    	
    	BkgTerminalEdiJapanDgCgoVO dgVO = new BkgTerminalEdiJapanDgCgoVO();
       
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
        	
        	param.put("bkg_no", bkgNo);
        	param.put("cntr_tpsz_cd", cntrTpszCd);
        	//velParam.put("bkg_no", bkgNo);
			SQLExecuter sqlExe = new SQLExecuter("");
			JapanTerminalTransmissionDBDAOsearchJapanDGInfoRSQL template = new JapanTerminalTransmissionDBDAOsearchJapanDGInfoRSQL();

			DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);
			
			
			if (dbRowset.next()) {
				dgVO.setMrnPolutFlg(dbRowset.getString("MAR_POLL"));
				dgVO.setImdgLmtQtyFlg(dbRowset.getString("IMO_LIMIT"));
				
				
			} else {
				dgVO.setMrnPolutFlg("");
				dgVO.setImdgLmtQtyFlg("");
				
			}
		
			
        } catch(SQLException ex) {
            // log.error(se.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch(Exception ex) {
            // log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return dgVO;
    }
    
    
    /**
	 *  searchRfCgoforNewBkgInfo
	 * 
	 * @param String bkgNo
	 * @param String cntrTpszCd
	 * @return List<BkgTerminalEdiDgCgoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgTerminalEdiDgCgoVO> searchJapanDangerMainInfo(String bkgNo, String cntrTpszCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgTerminalEdiDgCgoVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			param.put("bkg_no", bkgNo);
			param.put("cntr_tpsz_cd", cntrTpszCd);
			//param.putAll(mapVO);
			//velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JapanTerminalTransmissionDBDAOsearchJapanDGMainInfoRSQL(), param,velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgTerminalEdiDgCgoVO.class);
		}catch (SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch (Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
    
    /**
	 *  searchRfCgoforNewBkgInfo
	 * 
	 * @param String bkgNo
	 * @param String cntrTpszCd
	 * @param String imdgClssCd
	 * @return List<BkgTerminalEdiDgCgoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgTerminalEdiDgCgoVO> searchJapanDangerDetailInfo(String bkgNo, String cntrTpszCd, String imdgClssCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgTerminalEdiDgCgoVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			param.put("bkg_no", bkgNo);
			param.put("cntr_tpsz_cd", cntrTpszCd);
			param.put("imdg_clss_cd", imdgClssCd);
			//param.putAll(mapVO);
			//velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JapanTerminalTransmissionDBDAOsearchJapanDGDetailInfoRSQL(), param,velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgTerminalEdiDgCgoVO.class);
		}catch (SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch (Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	

	
    /**
     * [CHM-201216099][2012.03.15 By 조원주]BKG Route가 올바른 것인지 check flg 조회.
     * 배치 스케줄 Update, Insert 시에 BKG Route check하여 저장
     *  
     * @param String sndDt
     * @return String logSeq
     * @exception DAOException
     */
    public String searchLogSeq(String sndDt) throws DAOException {
    	// input_text
        String logSeq = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
        	
        	param.put("snd_dt", sndDt);
			SQLExecuter sqlExe = new SQLExecuter("");
			JapanTerminalTransmissionDBDAOsearchSendLogSeqRSQL template = new JapanTerminalTransmissionDBDAOsearchSendLogSeqRSQL();

			DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);
			
			
			if (dbRowset.next()) {
				logSeq = dbRowset.getString("LOG_SEQ");
			} else {
				logSeq = "";
			}
		
			
        } catch(SQLException ex) {
            // log.error(se.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch(Exception ex) {
            // log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return logSeq;
    } 
	
 
	
    /**
     * [CHM-201216099][2012.03.15 By 조원주]BKG Route가 올바른 것인지 check flg 조회.
     * 배치 스케줄 Update, Insert 시에 BKG Route check하여 저장
     *  
     * @param String sndDt  
     * @param String msgTp
     * @param String ofcCd
     * @param String logSeq
     * @return String ediSndMsg
     * @exception DAOException
     */
    public String searchEdiSndMsg(String sndDt, String msgTp, String ofcCd, String logSeq ) throws DAOException {
    	// input_text
        String ediSndMsg = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
        	
        	param.put("msg_snd_dt", sndDt);
        	param.put("jp_snd_log_id", msgTp);
        	param.put("ofc_cd", ofcCd);
        	param.put("log_seq", logSeq);
        	
			SQLExecuter sqlExe = new SQLExecuter("");
			JapanTerminalTransmissionDBDAOsearchDetailInfoRSQL template = new JapanTerminalTransmissionDBDAOsearchDetailInfoRSQL();

			DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);
			
			
			if (dbRowset.next()) {
				ediSndMsg = dbRowset.getString("EDI_SND_MSG");
			} else {
				ediSndMsg = "";
			}
		
			
        } catch(SQLException ex) {
            // log.error(se.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch(Exception ex) {
            // log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return ediSndMsg;
    } 
    
	/**
	 * updatePartialBkgInfoForSchedule<br>
	 * 
	 * @param List<BkgJapanTerminalEdiVO> updModels
	 * @throws DAOException 
	 */
	public void updatePartialBkgInfoForSchedule(List<BkgJapanTerminalEdiVO> updModels) throws EventException, DAOException {
		try	{
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new JapanTerminalTransmissionDBDAOupdatePartialBkgInfoForScheduleUSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}		
		}catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	
	/**
	 * modifySnaccsTmlEdiStsCngFlg<br>
	 * 
	 * 
	 * @param String bkgNo
	 * @param String bkgSkdSeq
	 * @throws EventException 
	 * @throws DAOException
	 */
	public void modifySnaccsTmlEdiStsCngFlg(String bkgNo, String bkgSkdSeq) throws EventException, DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try	{
			param.put("bkg_no", bkgNo);
			param.put("bkg_skd_seq", bkgSkdSeq);
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new JapanTerminalTransmissionDBDAOmodifySnaccsTmlEdiStsCngFlgUSQL(), param, velParam, true);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");	
		}catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	   /**
     * [CHM-201216099][2012.03.15 By 조원주]공통코드 조회.
     * 
     *  
     * @param String isoCd
     * @return String flg
     * @exception DAOException
     */
    public String searchIsoGroupTpCd(String isoCd) throws DAOException {
    	// input_text
        String flg = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
        	
        	param.put("iso_cd", isoCd);
        	velParam.put("iso_cd", isoCd);
			SQLExecuter sqlExe = new SQLExecuter("");
			JapanTerminalTransmissionDBDAOsearchIsoGroupTpCdRSQL template = new JapanTerminalTransmissionDBDAOsearchIsoGroupTpCdRSQL();

			DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);
			
			
			if (dbRowset.next()) {
				flg = dbRowset.getString("grp_cd");
			} else {
				flg = "";
			}
		
			
        } catch(SQLException ex) {
            // log.error(se.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch(Exception ex) {
            // log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return flg;
    } 
    
	   /**
     * [CHM-201216099][2012.03.15 By 조원주]
     * 
     *  
     * @param String bkgNo
     * @param String vslCd
     * @param String skdVoyNo
     * @param String skdDirCd
     * @return String flg
     * @exception DAOException
     */
    public String searchPrePod(String bkgNo, String vslCd, String skdVoyNo,String skdDirCd) throws DAOException {
    	// input_text
        String flg = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
        	
        	param.put("bkg_no", bkgNo);
        	velParam.put("bkg_no", bkgNo);
         	param.put("vsl_cd", vslCd);
        	velParam.put("vsl_cd", vslCd);
         	param.put("skd_voy_no", skdVoyNo);
        	velParam.put("skd_voy_no", skdVoyNo);
         	param.put("skd_dir_cd", skdDirCd);
        	velParam.put("skd_dir_cd", skdDirCd);
			SQLExecuter sqlExe = new SQLExecuter("");
			JapanTerminalTransmissionDBDAOsearchPrePodRSQL template = new JapanTerminalTransmissionDBDAOsearchPrePodRSQL();

			DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);
			
			
			if (dbRowset.next()) {
				flg = dbRowset.getString("PRE_POD");
			} else {
				flg = "";
			}
		
			
        } catch(SQLException ex) {
            // log.error(se.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch(Exception ex) {
            // log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return flg;
    } 
    
	   /**
     * [CHM-201216099][2012.03.15 By 조원주]
     * 
     *  
     * @param String bkgNo
     * @param String polCd
     * @param String vslCd
     * @param String skdVoyNo
     * @param String skdDirCd
     * @return String flg
     * @exception DAOException
     */
    public String searchTrshUncd(String bkgNo, String polCd, String vslCd, String skdVoyNo,String skdDirCd) throws DAOException {
    	// input_text
        String flg = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
        	
        	param.put("bkg_no", bkgNo);
        	velParam.put("bkg_no", bkgNo);
        	param.put("pol_cd", polCd);
        	velParam.put("pol_cd", polCd);
         	param.put("vsl_cd", vslCd);
        	velParam.put("vsl_cd", vslCd);
         	param.put("skd_voy_no", skdVoyNo);
        	velParam.put("skd_voy_no", skdVoyNo);
         	param.put("skd_dir_cd", skdDirCd);
        	velParam.put("skd_dir_cd", skdDirCd);
			SQLExecuter sqlExe = new SQLExecuter("");
			JapanTerminalTransmissionDBDAOsearchTrshUncdRSQL template = new JapanTerminalTransmissionDBDAOsearchTrshUncdRSQL();

			DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);
			
			
			if (dbRowset.next()) {
				flg = dbRowset.getString("TRSH_UNCD");
			} else {
				flg = "";
			}
		
			
        } catch(SQLException ex) {
            // log.error(se.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch(Exception ex) {
            // log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return flg;
    } 
    
	/**
	 * [CHM-201217740-01] Sea-NACCS 프로젝트스케줄 check 후 삭제하면 이력화면에도 이력을 숨김<br>
	 * 
	 * @param VvdJapanTerminalEdiVO vvdJapanTerminalEdiVO
	 * @throws DAOException 
	 */
	public void removeTransmitHistory(VvdJapanTerminalEdiVO vvdJapanTerminalEdiVO) throws EventException, DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = -1;
		try	{
			Map<String, String> mapVO = vvdJapanTerminalEdiVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new JapanTerminalTransmissionDBDAOremoveVesselListTransHisUSQL(), param,	velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		}catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
    
	
	/**
	 * [CHM-201217738-01] Sea-NACCS voyage  number 수정 및 입력 시 By BKG 화면에서 쓰이는 BKG_TML_EDI_JP_BL 테이블에도 업데이트 시켜줌<br>
	 * 
	 * @param VvdJapanTerminalEdiVO vvdJapanTerminalEdiVO
	 * @throws EventException
	 * @throws DAOException 
	 */
	public void modifyVesselListJpBl(VvdJapanTerminalEdiVO vvdJapanTerminalEdiVO) throws EventException, DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = -1;
		try	{
			Map<String, String> mapVO = vvdJapanTerminalEdiVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new JapanTerminalTransmissionDBDAOmodifyVesselListJpBlUSQL(), param,	velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		}catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	
	/**
	 * [CHM-201216099] Sea-NACCS 프로젝트스케줄 check 후 삭제 BKG_TML_EDI_JP_CNTR 테이블에서 삭제<br>
	 * 
	 * @param VvdJapanTerminalEdiVO vvdJapanTerminalEdiVO
	 * @throws DAOException 
	 */
	public void removeVesselListBkgTmlEdiJpCntr(VvdJapanTerminalEdiVO vvdJapanTerminalEdiVO) throws EventException, DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = -1;
		try	{
			Map<String, String> mapVO = vvdJapanTerminalEdiVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new JapanTerminalTransmissionDBDAOremoveVesselListBkgTmlEdiJpCntrDSQL(), param,	velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		}catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	
	/**
	 * [CHM-201216099] Sea-NACCS 프로젝트스케줄 check 후 삭제 BKG_TML_EDI_JP_DG_CGO 테이블에서 삭제<br>
	 * 
	 * @param VvdJapanTerminalEdiVO vvdJapanTerminalEdiVO
	 * @throws DAOException 
	 */
	public void removeVesselListBkgTmlEdiJpDgCgo(VvdJapanTerminalEdiVO vvdJapanTerminalEdiVO) throws EventException, DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = -1;
		try	{
			Map<String, String> mapVO = vvdJapanTerminalEdiVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new JapanTerminalTransmissionDBDAOremoveVesselListBkgTmlEdiJpDgCgoDSQL(), param,	velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		}catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	


	/**
	 * [CHM-201216099] Sea-NACCS 프로젝트스케줄 check 후 삭제 BKG_TML_EDI_JP_RF_CGO 테이블에서 삭제<br>
	 * 
	 * @param VvdJapanTerminalEdiVO vvdJapanTerminalEdiVO
	 * @throws DAOException 
	 */
	public void removeVesselListBkgTmlEdiJpRfCgo(VvdJapanTerminalEdiVO vvdJapanTerminalEdiVO) throws EventException, DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = -1;
		try	{
			Map<String, String> mapVO = vvdJapanTerminalEdiVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new JapanTerminalTransmissionDBDAOremoveVesselListBkgTmlEdiJpRfCgoDSQL(), param,	velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		}catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	
	/**
	 * [CHM-201216099] Sea-NACCS 프로젝트스케줄 check 후 삭제 BKG_TML_EDI_JP_AWK_CGO 테이블에서 삭제<br>
	 * 
	 * @param VvdJapanTerminalEdiVO vvdJapanTerminalEdiVO
	 * @throws DAOException 
	 */
	public void removeVesselListBkgTmlEdiJpAwkCgo(VvdJapanTerminalEdiVO vvdJapanTerminalEdiVO) throws EventException, DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = -1;
		try	{
			Map<String, String> mapVO = vvdJapanTerminalEdiVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new JapanTerminalTransmissionDBDAOremoveVesselListBkgTmlEdiJpAwkCgoDSQL(), param,	velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		}catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	

	
	/**
	 * Flat File - MAIN MEANS 정보를 조회한다.  <br>
	 * 
	 * @param String bkgNo
	 * @return BkgTerminalEdiJapanBlVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public BkgTerminalEdiJapanBlVO searchNewBkgInfoForVvdChk(String bkgNo) throws DAOException {
		BkgTerminalEdiJapanBlVO blVO = new BkgTerminalEdiJapanBlVO();

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			param.put("bkg_no", bkgNo);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new JapanTerminalTransmissionDBDAOsearchNewBkgInfoForVvdChkRSQL(), param, velParam);
			
			List<BkgTerminalEdiJapanBlVO> list = (List) RowSetUtil.rowSetToVOs(dbRowset,BkgTerminalEdiJapanBlVO.class);
			
			if (list != null && list.size() > 0) {
				blVO = (BkgTerminalEdiJapanBlVO) list.get(list.size() - 1);
			}
			
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return blVO;
	}
	

	
//	/**
//	 * [CHM-201217738-01] Sea-NACCS voyage  number 수정 및 입력 시 By BKG 화면에서 쓰이는 BKG_TML_EDI_JP_BL 테이블에도 업데이트 시켜줌<br>
//	 * 
//	 * @param VvdJapanTerminalEdiVO vvdJapanTerminalEdiVO
//	 * @param  SignOnUserAccount account
//	 * @throws EventException
//	 * @throws DAOException 
//	 */
//	public void modifyVesselListJpBl(VvdJapanTerminalEdiVO vvdJapanTerminalEdiVO, SignOnUserAccount account) throws EventException, DAOException {
//		// query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		// velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
//
//		int result = -1;
//		try	{
//			Map<String, String> mapVO = vvdJapanTerminalEdiVO.getColumnValues();
//			param.putAll(mapVO);
//			velParam.putAll(mapVO);
//			param.put("ofc_cd", account.getOfc_cd());
//			SQLExecuter sqlExe = new SQLExecuter("");
//			result = sqlExe.executeUpdate((ISQLTemplate) new JapanTerminalTransmissionDBDAOmodifyVesselListJpBlUSQL(), param,	velParam);
//			if (result == Statement.EXECUTE_FAILED)
//				throw new DAOException("Fail to insert SQL");
//		}catch (SQLException se){
//			log.error(se.getMessage(), se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		}catch (Exception ex){
//			log.error(ex.getMessage(), ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage());
//		}
//	}
//    
//    /**
//     * [CHM-201217738-01][2012.05.18 By 조원주]vsl이 SML 가 아니면 Voyage number를 직접 입력하도록 체크.
//     * 
//     *  
//     * @param VvdJapanTerminalEdiVO vvdJapanTerminalEdiVO
//     * @return String chkVslFlg
//     * @exception DAOException
//     */
//    public String searchCheckVsl(String vvdCd) throws DAOException {
//    	// input_text
//        String chkVslFlg = null;
//        // query parameter
//        Map<String, Object> param = new HashMap<String, Object>();
//        // velocity parameter
//        Map<String, Object> velParam = new HashMap<String, Object>();
//
//        try {
//            
//        	//Map<String, String> mapVO = vvdJapanTerminalEdiVO.getColumnValues();
//            //param.putAll(mapVO);
//			//velParam.putAll(mapVO);
//        	param.put("vvd_cd", vvdCd);
//			SQLExecuter sqlExe = new SQLExecuter("");
//			JapanTerminalTransmissionDBDAOsearchMdmVslCntrRSQL template = new JapanTerminalTransmissionDBDAOsearchMdmVslCntrRSQL();
//
//			DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);
//			
//			
//			if (dbRowset.next()) {
//				chkVslFlg = dbRowset.getString("CRR_CD");
//			} else {
//				chkVslFlg = "";
//			}
//		
//			
//        } catch(SQLException ex) {
//            // log.error(se.getMessage(), ex);
//            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
//        } catch(Exception ex) {
//            // log.error(ex.getMessage(), ex);
//            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
//        }
//        return chkVslFlg;
//    } 
	
}
