/*=========================================================
 *Copyright(c) 2016 CyberLogitec
 *@FileName : CgmEdiSendDBDAO.java
 *@FileTitle : CgmEdiSend
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2016.07.18
 *@LastModifier : 두기민
 *@LastVersion : 1.0
 * 2016.07.18 두기민
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmedisend.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmedisend.basic.CgmEdiSendBCImpl;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmedisend.vo.CgmEdiPodBookingListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * ALPS CgmEdiSendDBDAO <br>
 * - ALPS-CgmCommon system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author DOO KI MIN
 * @see CgmEdiSendBCImpl 참조
 * @since J2EE 1.4
 */
public class CgmEdiSendDBDAO extends DBDAOSupport {

	/**
	 * 미주 및 캐나다 EDI Booking 목록 조회(Import) <br>
	 * 
	 * @return List<CgmEdiPodBookingListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CgmEdiPodBookingListVO> usCaPodBookingList()
			throws DAOException {
		DBRowSet dbRowset = null;
		List<CgmEdiPodBookingListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			CgmEdiSendDBDAOUsCaPodBookingListRSQL template = new CgmEdiSendDBDAOUsCaPodBookingListRSQL();
			dbRowset = sqlExe.executeQuery(template, param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,
					CgmEdiPodBookingListVO.class);
		} catch (SQLException ex) {
			// log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		} catch (Exception ex) {
			// log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}
		return list;
	}

	/**
	 * 미주 및 캐나다 EDI Booking 목록 조회(Export) <br>
	 * 
	 * @return List<CgmEdiPodBookingListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CgmEdiPodBookingListVO> usCaPodBookingExportList()
			throws DAOException {
		DBRowSet dbRowset = null;
		List<CgmEdiPodBookingListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			CgmEdiSendDBDAOUsCaPodBookingExportListRSQL template = new CgmEdiSendDBDAOUsCaPodBookingExportListRSQL();
			dbRowset = sqlExe.executeQuery(template, param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,
					CgmEdiPodBookingListVO.class);
		} catch (SQLException ex) {
			// log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		} catch (Exception ex) {
			// log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}
		return list;
	}

	/**
	 * 미주 및 캐나다 EDI Container 목록 조회 <br>
	 * 
	 * @param CgmEdiPodBookingListVO
	 *            cgmEdiPodBookingListVO
	 * @return List<CgmEdiPodBookingListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CgmEdiPodBookingListVO> usCaPodContainerList(
			CgmEdiPodBookingListVO cgmEdiPodBookingListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CgmEdiPodBookingListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			param.putAll(cgmEdiPodBookingListVO.getColumnValues());

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			CgmEdiSendDBDAOUsCaPodCntrListRSQL template = new CgmEdiSendDBDAOUsCaPodCntrListRSQL();
			dbRowset = sqlExe.executeQuery(template, param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,
					CgmEdiPodBookingListVO.class);
		} catch (SQLException ex) {
			// log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		} catch (Exception ex) {
			// log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}
		return list;
	}

	/**
	 * Chss 예외 여부 판별을 위한 정보 조회 <br>
	 * 
	 * @param CgmEdiPodBookingListVO
	 *            cgmEdiPodBookingListVO
	 * @return List<CgmEdiPodBookingListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CgmEdiPodBookingListVO> chssExceptInfo(
			CgmEdiPodBookingListVO cgmEdiPodBookingListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CgmEdiPodBookingListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			param.putAll(cgmEdiPodBookingListVO.getColumnValues());

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			CgmEdiSendDBDAOChssExceptInfoDataRSQL template = new CgmEdiSendDBDAOChssExceptInfoDataRSQL();
			dbRowset = sqlExe.executeQuery(template, param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,
					CgmEdiPodBookingListVO.class);
		} catch (SQLException ex) {
			// log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		} catch (Exception ex) {
			// log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}
		return list;
	}

	/**
	 *Chss 예외 여부 조회 <br>
	 * 
	 * @param CgmEdiPodBookingListVO
	 *            cgmEdiPodBookingListVO
	 * @return List<CgmEdiPodBookingListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CgmEdiPodBookingListVO> chssExceptFlag(
			CgmEdiPodBookingListVO cgmEdiPodBookingListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CgmEdiPodBookingListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			param.putAll(cgmEdiPodBookingListVO.getColumnValues());

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			CgmEdiSendDBDAOChssExceptFlagRSQL template = new CgmEdiSendDBDAOChssExceptFlagRSQL();
			dbRowset = sqlExe.executeQuery(template, param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,
					CgmEdiPodBookingListVO.class);
		} catch (SQLException ex) {
			// log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		} catch (Exception ex) {
			// log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}
		return list;
	}

	/**
	 * chssExceptDays 조회 <br>
	 * 
	 * @param CgmEdiPodBookingListVO
	 *            cgmEdiPodBookingListVO
	 * @return List<CgmEdiPodBookingListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CgmEdiPodBookingListVO> chssExceptDays(
			CgmEdiPodBookingListVO cgmEdiPodBookingListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CgmEdiPodBookingListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			param.putAll(cgmEdiPodBookingListVO.getColumnValues());

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			CgmEdiSendDBDAOChssExceptDaysRSQL template = new CgmEdiSendDBDAOChssExceptDaysRSQL();
			dbRowset = sqlExe.executeQuery(template, param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,
					CgmEdiPodBookingListVO.class);
		} catch (SQLException ex) {
			// log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		} catch (Exception ex) {
			// log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}
		return list;
	}

	/**
	 * EDI 전문 HEADER 부분에 붙을 식별자를 생성한다.<br>
	 * 
	 * @return String
	 * @exception DAOException
	 */
	public String searchEdiHdSeqToUsCa() throws DAOException {
		DBRowSet dbRowset = null;
		String headerSeq = null;

		try {
			dbRowset = new SQLExecuter("")
					.executeQuery(
							(ISQLTemplate) new CgmEdiSendDBDAOSearchEdiHdSeqToUsCaRSQL(),
							null, null);
			if (dbRowset != null) {
				if (dbRowset.next()) {
					headerSeq = dbRowset.getString("HEADERSEQ");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return headerSeq;
	}

	/**
	 * EDI 전문 HEADER 부분에 붙을 식별자를 생성한다.<br>
	 * 
	 * @param String headerSeq
	 * @param String headInfo
	 * @return String
	 * @exception DAOException
	 */
	public String searchEdiHdToUsCa(String headerSeq, String headInfo) throws DAOException {
		DBRowSet dbRowset = null;
		String header = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {

			param.put("headerSeq", headerSeq);
			param.put("headInfo", headInfo);

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CgmEdiSendDBDAOSearchEdiHdToUsCaRSQL(),
					param, null);
			if (dbRowset != null) {
				if (dbRowset.next()) {
					header = dbRowset.getString("HEADER");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return header;
	}

	/**
	 * 미주 및 캐나다에 전송한 EDI MESSAGE를 반환한다.<br>
	 * 
	 * @param CgmEdiPodBookingListVO
	 *            cgmEdiPodBookingListVO
	 * @return List<CgmEdiPodBookingListVO>
	 * @exception DAOException
	 */
	public List<CgmEdiPodBookingListVO> searchEdiMsgToUsCa(
			CgmEdiPodBookingListVO cgmEdiPodBookingListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CgmEdiPodBookingListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			param.putAll(cgmEdiPodBookingListVO.getColumnValues());

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			CgmEdiSendDBDAOSearchEdiMsgToUsCaRSQL template = new CgmEdiSendDBDAOSearchEdiMsgToUsCaRSQL();
			dbRowset = sqlExe.executeQuery(template, param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,
					CgmEdiPodBookingListVO.class);
		} catch (SQLException ex) {
			// log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		} catch (Exception ex) {
			// log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}
		return list;
	}

	/**
	 * 미주 및 캐나다에 전송한 EDI MESSAGE를 반환한다.<br>
	 * 
	 * @param CgmEdiPodBookingListVO
	 *            cgmEdiPodBookingListVO
	 * @return List<CgmEdiPodBookingListVO>
	 * @exception DAOException
	 */
	public List<CgmEdiPodBookingListVO> searchEdiMsgToUsCaCntInfo(
			CgmEdiPodBookingListVO cgmEdiPodBookingListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CgmEdiPodBookingListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			param.putAll(cgmEdiPodBookingListVO.getColumnValues());

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			CgmEdiSendDBDAOSearchEdiMsgToUsCaCntInfoRSQL template = new CgmEdiSendDBDAOSearchEdiMsgToUsCaCntInfoRSQL();
			dbRowset = sqlExe.executeQuery(template, param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,
					CgmEdiPodBookingListVO.class);
		} catch (SQLException ex) {
			// log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		} catch (Exception ex) {
			// log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}
		return list;
	}

	/**
	 * 미주 및 캐나다에 전송한 EDI MESSAGE를 반환한다.<br>
	 * 
	 * @param CgmEdiPodBookingListVO
	 *            cgmEdiPodBookingListVO
	 * @return  List<CgmEdiPodBookingListVO>
	 * @exception DAOException
	 */
	public List<CgmEdiPodBookingListVO> searchEdiMsgToUsCaSealInfo(
			CgmEdiPodBookingListVO cgmEdiPodBookingListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CgmEdiPodBookingListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			param.putAll(cgmEdiPodBookingListVO.getColumnValues());

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			CgmEdiSendDBDAOSearchEdiMsgToUsCaSealInfoRSQL template = new CgmEdiSendDBDAOSearchEdiMsgToUsCaSealInfoRSQL();
			dbRowset = sqlExe.executeQuery(template, param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,
					CgmEdiPodBookingListVO.class);
		} catch (SQLException ex) {
			// log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		} catch (Exception ex) {
			// log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * 미주 및 캐나다에 전송한 EDI 정보 저장.<br>
	 *
	 * @param CgmEdiPodBookingListVO cgmEdiPodBookingListVO
	 * @exception DAOException
	 */
	public void addCgmChssExptEdiHis(CgmEdiPodBookingListVO cgmEdiPodBookingListVO) throws DAOException{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if(cgmEdiPodBookingListVO != null){
				 Map<String, String> mapVO = cgmEdiPodBookingListVO.getColumnValues();
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
				 
				 SQLExecuter sqlExe = new SQLExecuter("");
				 int result = sqlExe.executeUpdate((ISQLTemplate)new CgmEdiSendDBDAOAddCgmChssExptEdiHisCSQL(), param, velParam);

				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
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
	 * 미주 및 캐나다에 전송할 TP/SZ 조회.<br>
	 * 
	 * @param CgmEdiPodBookingListVO cgmEdiPodBookingListVO
	 * @return List<CgmEdiPodBookingListVO>
	 * @exception DAOException
	 */
	public List<CgmEdiPodBookingListVO> searchUsCaCntrTpszCnt(CgmEdiPodBookingListVO cgmEdiPodBookingListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CgmEdiPodBookingListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			param.putAll(cgmEdiPodBookingListVO.getColumnValues());

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			CgmEdiSendDBDAOSearchUsCaCntrTpszCntRSQL template = new CgmEdiSendDBDAOSearchUsCaCntrTpszCntRSQL();
			dbRowset = sqlExe.executeQuery(template, param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,
					CgmEdiPodBookingListVO.class);
		} catch (SQLException ex) {
			// log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		} catch (Exception ex) {
			// log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}
		return list;	
	}	
}
