/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BookingNumberGenarationDBDAO.java
*@FileTitle : BookingNumberGenarationDBDAO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.05
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2010.02.05 김기종
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingcommon.bookingnumbergenaration.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingnumbergenaration.basic.BookingNumberGenarationBCImpl;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgReferenceNoGenerationVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/**
 *  BookingNumberGenarationDBDAO <br>
 * - -BookingCommon system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Kim Ki Jong
 * @see BookingNumberGenarationBCImpl 참조
 * @since J2EE 1.5
 */
public class BookingNumberGenarationDBDAO extends DBDAOSupport {

	/**
	 * BkgNo,BlNo 를 생성,조회한다.<br>
	 * 
	 * @param String divCd
	 * @param String officeCd
	 * @param String usrId 
	 * @return BkgBlNoVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public BkgBlNoVO manageBkgNumberGeneration(String divCd, String officeCd, String usrId) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgBlNoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		BkgBlNoVO vo = null;

		try {
			param.put("bkg_no_gen_div_cd", divCd);
			param.put("cre_ofc_cd", officeCd);
			param.put("upd_usr_id", usrId);

			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new BookingNumberGenarationDBDAOManageBkgNumberGenerationRSQL(), param, null);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgBlNoVO.class);

			if (list != null && list.size() > 0) {
				vo = (BkgBlNoVO) list.get(0);
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return vo;
	}

	/**
	 * RPT,JPD,D/O,C/A,KOR,UIT,CAD,NCB Refrence No 조회 를 생성,조회한다.<br>
	 * 
	 * @param String divCd 
	 * @param String officeCd 
	 * @param String usrId 
	 * @return BkgReferenceNoGenerationVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public BkgReferenceNoGenerationVO manageBkgReferenceNumberGeneration(String divCd, String officeCd, String usrId) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgReferenceNoGenerationVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		BkgReferenceNoGenerationVO vo = null;

		try {
			param.put("bkg_no_gen_div_cd", divCd);
			param.put("cre_ofc_cd", officeCd);
			param.put("upd_usr_id", usrId);

			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new BookingNumberGenarationDBDAOBkgReferenceNoGenerationRSQL(), param, null);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgReferenceNoGenerationVO.class);

			if (list != null && list.size() > 0) {
				vo = (BkgReferenceNoGenerationVO) list.get(0);
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return vo;
	}
	
	/**
	 * 
	 * @param divCd
	 * @param officeCd
	 * @param usrId
	 * @return
	 * @throws DAOException
	 */
	public BkgBlNoVO manageToyotaBlNumberGeneration(String divCd, String officeCd, String usrId) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgBlNoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		BkgBlNoVO vo = null;

		try {
			param.put("bkg_no_gen_div_cd", divCd);
			param.put("cre_ofc_cd", officeCd);
			param.put("upd_usr_id", usrId);
			
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new BookingNumberGenarationDBDAOManageToyotaBlNumberGenerationRSQL(), param, null);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgBlNoVO.class);

			if (list != null && list.size() > 0) {
				vo = (BkgBlNoVO) list.get(0);
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return vo;
	}

	/**
	 *  
	 * @param bkgBlNoVO
	 * @return
	 * @throws DAOException
	 */
	public String validationToyotaBlNo(BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, String> param = null;
		String checkSeq = "0";
		try {
			param = bkgBlNoVO.getColumnValues();
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new BookingNumberGenarationDBDAOCheckValidationToyotaBlNumberRSQL(), param, null);
			while(dbRowset.next()){
				checkSeq = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return checkSeq;
	}
}
