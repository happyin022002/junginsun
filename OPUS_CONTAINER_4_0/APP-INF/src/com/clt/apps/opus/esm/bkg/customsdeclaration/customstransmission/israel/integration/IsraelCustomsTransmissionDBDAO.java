/*=========================================================
 *Copyright(c) 2013 CyberLogitec
*@FileName : IsraelCustomsTransmissionDBDAO.java
*@FileTitle : UI_BKG-1168
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.11
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2013.08.11 김보배
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.israel.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.vo.Eu24RcvMsgVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.israel.vo.searchBlCMinfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.israel.vo.searchBlCntrMfDescVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.israel.vo.searchBlCntrSealNoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.israel.vo.searchBlCntrVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.israel.vo.searchBlCustVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.israel.vo.searchBlDgCgoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.israel.vo.searchBlGeneralVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.israel.vo.searchBlRouteCountryVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.israel.vo.sendHistoryVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/**
 * OPUS IsraelCustomsTransmissionDBDAO <br>
 * - OPUS-CustomsDeclaration system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author BOBAE KIM
 * @see IsraelCustomsTransmissionBCImpl 참조
 * @since J2EE 1.4
 */
@SuppressWarnings("serial")
public class IsraelCustomsTransmissionDBDAO extends DBDAOSupport {

	
	/**
	 * BL 정보 조회<br>
	 * 
	 * @param String blNo 
	 * @param String vslCd 
	 * @param String skdVoyNo
	 * @param String skdDirCd 
	 * @param String cstmsPortCd 
	 * @return List<searchBlGeneralVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<searchBlGeneralVO>  searchBlGeneral ( String blNo , String vslCd , String skdVoyNo , String skdDirCd , String cstmsPortCd)throws DAOException {
		DBRowSet dbRowset = null;
		List<searchBlGeneralVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try
		{
			param.put("bl_no", blNo);
			param.put("vsl_cd", vslCd);
			param.put("skd_voy_no", skdVoyNo);
			param.put("skd_dir_cd", skdDirCd);
			param.put("cstms_port_cd", cstmsPortCd);

			velParam.put("bl_no", blNo);
			velParam.put("vsl_cd", vslCd);
			velParam.put("skd_voy_no", skdVoyNo);
			velParam.put("skd_dir_cd", skdDirCd);
			velParam.put("cstms_port_cd", cstmsPortCd);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new IsraelCustomsTransmissionDBDAOsearchBlGeneralRSQL(), param,velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, searchBlGeneralVO.class);
		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	
	
	/**
	 * BL 고객 정보 조회<br>
	 * 
	 * @param String blNo 
	 * @param String vslCd 
	 * @param String skdVoyNo
	 * @param String skdDirCd 
	 * @param String cstmsPortCd 
	 * @return List<searchBlCntrVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<searchBlCustVO>  searchBlCust ( String blNo , String vslCd , String skdVoyNo , String skdDirCd , String cstmsPortCd)throws DAOException {
		DBRowSet dbRowset = null;
		List<searchBlCustVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try
		{
			
			param.put("bl_no", blNo);
			param.put("vsl_cd", vslCd);
			param.put("skd_voy_no", skdVoyNo);
			param.put("skd_dir_cd", skdDirCd);
			param.put("cstms_port_cd", cstmsPortCd);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new IsraelCustomsTransmissionDBDAOsearchBlCustRSQL(), param,velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, searchBlCustVO.class);
		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	
	
	/**
	 * BL 컨테이너 정보 조회<br>
	 * 
	 * @param String blNo 
	 * @param String vslCd 
	 * @param String skdVoyNo
	 * @param String skdDirCd 
	 * @param String cstmsPortCd 
	 * @return List<searchBlCntrVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<searchBlCntrVO>  searchBlCntr ( String blNo , String vslCd , String skdVoyNo , String skdDirCd , String cstmsPortCd)throws DAOException {
		DBRowSet dbRowset = null;
		List<searchBlCntrVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try
		{
			
			param.put("bl_no", blNo);
			param.put("vsl_cd", vslCd);
			param.put("skd_voy_no", skdVoyNo);
			param.put("skd_dir_cd", skdDirCd);
			param.put("cstms_port_cd", cstmsPortCd);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new IsraelCustomsTransmissionDBDAOsearchBlCntrRSQL(), param,velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, searchBlCntrVO.class);
		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * BL 컨테이너별 DG Cargo 정보 조회<br>
	 * 
	 * @param String blNo 
	 * @param String vslCd 
	 * @param String skdVoyNo
	 * @param String skdDirCd 
	 * @param String cstmsPortCd 
	 * @param String cntrNo 
	 * @return List<searchBlDgCgoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<searchBlDgCgoVO>  searchBlDgCgo ( String blNo , String vslCd , String skdVoyNo , String skdDirCd ,String cstmsPortCd, String cntrNo)throws DAOException {
		DBRowSet dbRowset = null;
		List<searchBlDgCgoVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try
		{
			
			param.put("bl_no", blNo);
			param.put("vsl_cd", vslCd);
			param.put("skd_voy_no", skdVoyNo);
			param.put("skd_dir_cd", skdDirCd);
			param.put("cstms_port_cd", cstmsPortCd);
			param.put("cntr_no", cntrNo);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new IsraelCustomsTransmissionDBDAOsearchBlDgCgoRSQL(), param,velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, searchBlDgCgoVO.class);
		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * BL 컨테이너별 Manifest 정보 조회<br>
	 * 
	 * @param String blNo 
	 * @param String vslCd 
	 * @param String skdVoyNo
	 * @param String skdDirCd 
	 * @param String cstmsPortCd 
	 * @param String cntrNo 
	 * @return List<searchBlCntrMfDescVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<searchBlCntrMfDescVO>  searchBlCntrMfDesc ( String blNo , String vslCd , String skdVoyNo , String skdDirCd , String cstmsPortCd, String cntrNo)throws DAOException {
		DBRowSet dbRowset = null;
		List<searchBlCntrMfDescVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try
		{
			
			param.put("bl_no", blNo);
			param.put("vsl_cd", vslCd);
			param.put("skd_voy_no", skdVoyNo);
			param.put("skd_dir_cd", skdDirCd);
			param.put("cstms_port_cd", cstmsPortCd);
			param.put("cntr_no", cntrNo);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new IsraelCustomsTransmissionDBDAOsearchBlCntrMfDescRSQL(), param,velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, searchBlCntrMfDescVO.class);
		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}	
	
	/**
	 * BL 컨테이너 Seal No 정보 조회<br>
	 * 
	 * @param String blNo 
	 * @param String vslCd 
	 * @param String skdVoyNo
	 * @param String skdDirCd 
	 * @param String cstmsPortCd 
	 * @param String cntrNo 
	 * @return List<searchBlCntrSealNoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<searchBlCntrSealNoVO>  searchBlCntrSealNo ( String blNo , String vslCd , String skdVoyNo , String skdDirCd , String cstmsPortCd, String cntrNo)throws DAOException {
		DBRowSet dbRowset = null;
		List<searchBlCntrSealNoVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try
		{
			
			param.put("bl_no", blNo);
			param.put("vsl_cd", vslCd);
			param.put("skd_voy_no", skdVoyNo);
			param.put("skd_dir_cd", skdDirCd);
			param.put("cstms_port_cd", cstmsPortCd);
			param.put("cntr_no", cntrNo);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new IsraelCustomsTransmissionDBDAOsearchBlCntrSealNoRSQL(), param,velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, searchBlCntrSealNoVO.class);
		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}	
	
	/**
	 * BL 컨테이너 Manifest 정보 조회(BL별 MF 리스트)<br>
	 * 
	 * @param String blNo 
	 * @param String vslCd 
	 * @param String skdVoyNo
	 * @param String skdDirCd 
	 * @param String cstmsPortCd 
	 * @param String msgIdCd 
	 * @return List<searchBlCMinfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<searchBlCMinfoVO>  searchBlCMinfo ( String blNo , String vslCd , String skdVoyNo , String skdDirCd , String cstmsPortCd, String msgIdCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<searchBlCMinfoVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try
		{
			
			param.put("bl_no", blNo);
			param.put("vsl_cd", vslCd);
			param.put("skd_voy_no", skdVoyNo);
			param.put("skd_dir_cd", skdDirCd);
			param.put("cstms_port_cd", cstmsPortCd);
			param.put("cnt_cd", cstmsPortCd.substring(0,2));
			param.put("msg_id_cd", msgIdCd);
			velParam.put("cnt_cd", cstmsPortCd.substring(0,2));
			velParam.put("msg_id_cd", msgIdCd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new IsraelCustomsTransmissionDBDAOsearchBlCMinfoRSQL(), param,velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, searchBlCMinfoVO.class);
		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}	
	
	
	
	/**
	 * BL별 Route정보 조회<br>
	 * 
	 * @param String blNo 
	 * @param String vslCd 
	 * @param String skdVoyNo
	 * @param String skdDirCd 
	 * @return List<searchBlRouteCountryVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<searchBlRouteCountryVO>  searchBlRouteCountry ( String blNo,String vslCd , String skdVoyNo , String skdDirCd)throws DAOException {
		DBRowSet dbRowset = null;
		List<searchBlRouteCountryVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try
		{
			param.put("bl_no", blNo);
			param.put("vsl_cd", vslCd);
			param.put("skd_voy_no", skdVoyNo);
			param.put("skd_dir_cd", skdDirCd);	

			velParam.put("bl_no", blNo);
			velParam.put("vsl_cd", vslCd);
			velParam.put("skd_voy_no", skdVoyNo);
			velParam.put("skd_dir_cd", skdDirCd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new IsraelCustomsTransmissionDBDAOsearchBlRouteCountryRSQL(), param,velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, searchBlRouteCountryVO.class);
		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * 세관 신고 이력을 입력한다.
	 * 
	 * @param SendHistoryVO sendHistoryVO
	 * @throws EventException
	 * @throws DAOException 
	 */
	public void addSendLog(sendHistoryVO sendHistoryVO) throws EventException, DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = -1;
		try	{
			Map<String, String> mapVO = sendHistoryVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new IsraelCustomsTransmissionDBDAOaddSendLogCSQL(), param,	velParam);
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
	 * 세관 수신 데이타 저장.
	 * 
	 * @param Eu24RcvMsgVO eu24RcvMsgVO
	 * @throws EventException
	 * @throws DAOException 
	 */
	public void addRcvLogMst(Eu24RcvMsgVO eu24RcvMsgVO) throws EventException, DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = -1;
		try	{
			Map<String, String> mapVO = eu24RcvMsgVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new IsraelCustomsTransmissionDBDAOaddRcvLogMstCSQL(), param,	velParam);
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
	 * 세관 수신 에러 데이타 저장.
	 * 
	 * @param Eu24RcvMsgVO eu24RcvMsgVO
	 * @throws EventException
	 * @throws DAOException 
	 */
	public void addRcvLogErr(Eu24RcvMsgVO eu24RcvMsgVO) throws EventException, DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = -1;
		try	{
			Map<String, String> mapVO = eu24RcvMsgVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new IsraelCustomsTransmissionDBDAOaddRcvLogErrCSQL(), param,	velParam);
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
		
} 

