/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UsaCustomsReportDAO.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.02
*@LastModifier : 전창현
*@LastVersion : 1.0
* 2009.09.02 전창현
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.china.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.china.vo.BkgCstmsChnDeModCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.china.vo.BkgCstmsChnDeModDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.china.vo.ChinaManifestListTransmitHistDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.china.vo.ChinaManifestSendDetailListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.china.vo.ChinaTransmitHistCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.china.vo.DelModeListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.china.vo.SearchLocationVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;

/**
 * ALPS CustomsReportDAO <br>
 * - ALPS-customsreport system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author 전창현
 * @see BCImpl 참조
 * @since J2EE 1.4
 */
@SuppressWarnings("serial")
public class ChinaCustomsReportDBDAO extends DBDAOSupport {

	/**
	 * 중국 DEL 지역별 운송 Mode를 조회한다.
	 *
	 * @param bkgCstmsChnDeModCondVO
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<DelModeListVO> searchDelMode(BkgCstmsChnDeModCondVO bkgCstmsChnDeModCondVO) throws DAOException {

		List<DelModeListVO> list = null;
		//DBRowSet dbRowset = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (bkgCstmsChnDeModCondVO != null) {
				Map<String, String> mapVO = bkgCstmsChnDeModCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ChinaCustomsReportDBDAOsearchDelModeRSQL(), param, velParam);
			list =(List) RowSetUtil.rowSetToVOs(dbRowset, DelModeListVO.class);
		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * 중국 DEL 지역별 운송 Mode를 입력한다.
	 *
	 * @param List<BkgCstmsChnDeModDetailVO> insModels
	 * @throws DAOException
	 */
	public void addDelMode(List<BkgCstmsChnDeModDetailVO> insModels) throws DAOException {

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;

			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new ChinaCustomsReportDBDAOaddDelModeCSQL(), insModels, null);
				for(int i = 0; i < insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
						//throw new DAOException("Fail to insert No"+ i + " SQL");
						//throw new DAOException(new ErrorHandler("BKG00102", new String[] {}).getUserMessage());
						throw new DAOException(new ErrorHandler("BKG00628", new String[] {}).getUserMessage());
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			//throw new DAOException(new ErrorHandler(se).getMessage());
			throw new DAOException(new ErrorHandler("BKG00110", new String[] {}).getUserMessage());

		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

	}

	/**
	 * 중국 DEL 지역별 운송 Mode를 수정한다.
	 *
	 * @param List<BkgCstmsChnDeModDetailVO> insModels
	 * @throws DAOException
	 */
	public void modifyDelMode(List<BkgCstmsChnDeModDetailVO> insModels) throws DAOException {

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;

			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new ChinaCustomsReportDBDAOmodifyDelModeUSQL(), insModels, null);
				for(int i = 0; i < insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
						//throw new DAOException("Fail to insert No"+ i + " SQL");
						//throw new DAOException(new ErrorHandler("BKG00102", new String[] {}).getUserMessage());
						throw new DAOException(new ErrorHandler("BKG00628", new String[] {}).getUserMessage());
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			//throw new DAOException(new ErrorHandler(se).getMessage());
			throw new DAOException(new ErrorHandler("BKG00110", new String[] {}).getUserMessage());

		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

	}

	/**
	 * 중국 DEL 지역별 운송 Mode를 삭제한다.
	 *
	 * @param List<BkgCstmsChnDeModDetailVO> insModels
	 * @throws DAOException
	 */
	public void removeDelMode(List<BkgCstmsChnDeModDetailVO> insModels) throws DAOException {

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;

			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new ChinaCustomsReportDBDAOremoveDelModeDSQL(), insModels, null);
				for(int i = 0; i < insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
						//throw new DAOException("Fail to insert No"+ i + " SQL");
						//throw new DAOException(new ErrorHandler("BKG00102", new String[] {}).getUserMessage());
						throw new DAOException(new ErrorHandler("BKG00628", new String[] {}).getUserMessage());
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			//throw new DAOException(new ErrorHandler(se).getMessage());
			throw new DAOException(new ErrorHandler("BKG00110", new String[] {}).getUserMessage());

		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

	}

	/**
	 * 중국세관으로 전송한 History를 조회한다.<br>
	 *
	 * @param ChinaTransmitHistCondVO chinaTransmitHistCondVO
	 * @return List<ChinaManifestListTransmitHistDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<ChinaManifestListTransmitHistDetailVO> searchChinaManifestSendList(ChinaTransmitHistCondVO chinaTransmitHistCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ChinaManifestListTransmitHistDetailVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		log.info("#########################################");
		log.info("IPage1 :" + chinaTransmitHistCondVO.getIPage() ==null+":");
		log.info("IPage2 :" + chinaTransmitHistCondVO.getIPage().equals("") +":");
		log.info("#########################################");
		int currentPage = Integer.parseInt(chinaTransmitHistCondVO.getIPage().equals("") ?"1":chinaTransmitHistCondVO.getIPage());
		int startNo   = Integer.parseInt(chinaTransmitHistCondVO.getPagerows().equals("") ?"100":chinaTransmitHistCondVO.getPagerows()) *(currentPage - 1) + 1;
		int endNo     = Integer.parseInt(chinaTransmitHistCondVO.getPagerows().equals("") ?"100":chinaTransmitHistCondVO.getPagerows()) * currentPage;
		log.info("#########################################");
		log.info("startNo : " + startNo);
		log.info("endNo : " + endNo);
		log.info("#########################################");

		try {
			if (chinaTransmitHistCondVO != null) {
				Map<String, String> mapVO = chinaTransmitHistCondVO.getColumnValues();
				param.put("startno", startNo);
				param.put("endno", endNo);
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new ChinaCustomsReportDBDAOsearchChinaSendListRSQL(), param, velParam);
			list =(List) RowSetUtil.rowSetToVOs(dbRowset, ChinaManifestListTransmitHistDetailVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * 중국세관 POD, DEL Validation 을 체크한다.
	 * @param searchLocationVO
	 * @return SearchLocationVO
	 * @throws EventException
	 */
	public String searchLocation(SearchLocationVO searchLocationVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		DBRowSet dbRowset = null;
		String locCd = null;

		try {
			Map<String, String> mapVO = searchLocationVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ChinaCustomsReportDBDAOsearchLocationRSQL(), param, velParam);
			if (dbRowset.next()) locCd = dbRowset.getString("LOC_CD");
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return locCd;
	}

	/**
	 * 중국세관으로 전송한 History의 Detail을 조회한다.<br>
	 *
	 * @param String ediRefId
	 * @param String podCd
	 * @return List<ChinaManifestSendDetailListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<ChinaManifestSendDetailListVO> searchChinaSendDetailList(String ediRefId, String podCd) throws DAOException {

		List<ChinaManifestSendDetailListVO> list = null;

		try {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("edi_ref_id", ediRefId);
			param.put("pod_cd", podCd);

			DBRowSet dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new ChinaCustomsReportDBDAOsearchChinaSendDetailListRSQL(), param, null);
			list =(List) RowSetUtil.rowSetToVOs(dbRowset, ChinaManifestSendDetailListVO.class);
		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

}