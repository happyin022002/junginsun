/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CSMSendDBDAO.java
 *@FileTitle : CSM (Container Status Message) 미세관 전송 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009-02-05
 *@LastModifier : Kim In-soo
 *@LastVersion : 1.0
 * 1.0 최초 생성
 * 
 * 2009-03-04 iskim
 * 	(1) R200903040003	2월 소스품질 검토 결과 follow-up
=========================================================*/
package com.clt.apps.opus.esd.sce.csmsend.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import com.clt.apps.opus.esd.sce.csmsend.vo.CSMSendVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;

/**
 * SCEM Business Logic Basic Command implementation<br>
 * - SCEM에 대한 DB 작업을 처리한다.<br>
 * 
 * @author 2002701
 * @see
 * @since J2EE 1.4
 */
public class CSMSendDBDAO extends DBDAOSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2143072738332663852L;

	/**
	 * booking 이 존재하는지, 존재하면 US bound 인지 조회 bkg 미 존재시 'NOT_EXIST', 미주 향발이면 'US_BOUND' 아니면 'NOT_US_BOUND'
	 * 
	 * @param cSMSendVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchBkgBound(CSMSendVO cSMSendVO) throws DAOException {
		String rtnStr = "";
		DBRowSet dbRowset = null;
		// List<CSMSendVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (cSMSendVO != null) {
				Map<String, String> mapVO = cSMSendVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CSMSendDBDAOSearchBkgBoundRSQL(), param, velParam);

			while (dbRowset.next()) {
				rtnStr = dbRowset.getString("CK");
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnStr;

	}

	/**
	 * target data 의 interface 상태 (act_umch_tp_cd) 를 수정한다.
	 * 
	 * @param cSMSendVO
	 * @throws DAOException
	 */
	public void updateActUmchTpCd(CSMSendVO cSMSendVO) throws DAOException {

		int updCnt = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {

			SQLExecuter sqlExe = new SQLExecuter("");
			if (cSMSendVO != null) {
				Map<String, String> mapVO = cSMSendVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

			}

			updCnt = sqlExe.executeUpdate((ISQLTemplate) new CSMSendDBDAOModifyActUmchTpCdUSQL(), param, velParam);

			if (updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update..");

		} catch (SQLException se) {
			// se.printStackTrace();
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * target data 의 interface 상태 (act_umch_tp_cd) 를 수정한다.
	 * 
	 * @param act_rcv_dt
	 * @param act_rcv_no
	 * @param act_umch_tp_cd
	 * @throws DAOException
	 */
	public void updateActUmchTpCd(String act_rcv_dt, String act_rcv_no, String act_umch_tp_cd) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int updCnt = 0;

		try {

			param.put("act_rcv_dt", act_rcv_dt);
			param.put("act_rcv_no", act_rcv_no);
			param.put("act_umch_tp_cd", act_umch_tp_cd);
			velParam.put("act_umch_tp_cd", act_umch_tp_cd);

			SQLExecuter sqlExe = new SQLExecuter("");

			updCnt = sqlExe.executeUpdate(new CSMSendDBDAOModifyActUmchTpCdUSQL(), param, velParam);
			if (updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update..");

		} catch (SQLException se) {
			// se.printStackTrace();
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Empty container movement 를 대상으로 해당 mvmt 에 딸린 bkg 의 vvd 중 pod /del 도착까지 미주를 경유하는지 조회하여 대상이면 SCE_CNTR_STS_MSG_TGT 에 insert
	 * 
	 * @return int
	 * @throws DAOException
	 */
	public int addCSMTargetEmptyCntr() throws DAOException {

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int updCnt = 0;

		try {

			SQLExecuter sqlExe = new SQLExecuter("");

			updCnt = sqlExe.executeUpdate(new CSMSendDBDAOAddCSMTargetEmptyCntrCSQL(), param, velParam);
			if (updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update..");

		} catch (SQLException se) {
			// se.printStackTrace();
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return updCnt;
	}

	/**
	 * 불필요하다고 판단된 TARGET DATA 를 삭제한다.
	 * 
	 * @param cSMSendVO
	 * @throws DAOException
	 */
	public void deleteCSMTarget(CSMSendVO cSMSendVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int updCnt = 0;

		try {

			SQLExecuter sqlExe = new SQLExecuter("");

			if (cSMSendVO != null) {
				Map<String, String> mapVO = cSMSendVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			updCnt = sqlExe.executeUpdate(new CSMSendDBDAODeleteCSMTargetDSQL(), param, null);
			if (updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update..");

		} catch (SQLException se) {
			// se.printStackTrace();
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Flat file 을 생성하여 SCE_CNTR_STS_MSG_FLT_FILE table 에 input 한다. 주의: OP movement 는 2건의 flat file 이 생성 된다.
	 * 
	 * @param cSMSendVO
	 * @return int
	 * @throws DAOException
	 */
	public int insertFlatFile(CSMSendVO cSMSendVO) throws DAOException {
		// Connection con = null;
		// PreparedStatement ps = null; // 정적파싱을 지원하는 SQL Statement
		// PreparedStatement ps_pk = null;
		// int i = 1;
		int rowCnt = 0;
		int totCnt = 0;
		// StringBuffer queryStr = searchFlatFilePK();

		// ResultSet rstSet = null;

		DBRowSet dbRowset = null;
		// List<SearchNotificationVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		// searchInsertFlatFileQuery(false);
		try {

			if (cSMSendVO != null) {
				Map<String, String> mapVO = cSMSendVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CSMSendDBDAOSearchFlatFilePKRSQL(), param, velParam);

				// FLAT FILE REFERENCE NUMBER 변경 20141203 IGKIM
				// String referenceNumber = ReferenceNumberGeneratorBroker.getKey("CSM","SCE_CNTR_STS_MSG_FLT_FILE_SEQ1"); //기존 자리(13) 체크 필요하다.
				// log.debug("TEST======= NEW ===referenceNumber=========> "+referenceNumber);
				if (!dbRowset.next()) {
					// 해당 Movement 가 전송 대상이 아닌경우
					insertSendResult(cSMSendVO.getActRcvDt(), cSMSendVO.getActRcvNo(), "Wrong mvmt code : not in mapping");
					cSMSendVO.setActUmchTpCd("60");
					updateActUmchTpCd(cSMSendVO);

				} else {
					do {
						String edi_snd_yrmondy = dbRowset.getString("EDI_SND_YRMONDY");
						String edi_snd_seq = dbRowset.getString("EDI_SND_SEQ");
						String stnd_edi_sts_cd = dbRowset.getString("STND_EDI_STS_CD");
						// String flt_file_ref_no = dbRowset.getString("FLT_FILE_REF_NO");
						// String flt_file_ref_no = referenceNumber; //IGKIM 20141203 참조 MODIFY
						String flt_file_ref_no = "";
						String act_rcv_dt = cSMSendVO.getActRcvDt();
						String act_rcv_no = cSMSendVO.getActRcvNo();

						param.put("edi_snd_yrmondy", edi_snd_yrmondy);
						param.put("edi_snd_seq", edi_snd_seq);
						param.put("stnd_edi_sts_cd", stnd_edi_sts_cd);
						// param.put("flt_file_ref_no", flt_file_ref_no);
						param.put("act_rcv_dt", act_rcv_dt);
						param.put("act_rcv_no", act_rcv_no);

						velParam.put("is_multi_rows", "F");

						// rowCnt= new SQLExecuter("").executeUpdate(new CSMSendDBDAOAddFlatFileCSQL(),param, velParam);

						rowCnt = new SQLExecuter("").executeUpdate((ISQLTemplate) new CSMSendDBDAOAddFlatFileCSQL(), param, velParam);
						log.info("\nafter flat file, rowCnt = " + rowCnt);
						if (rowCnt == Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to insert..");

						// flat file 생성 후의 처리 시작
						if (rowCnt >= 1) {
							insertSendResult(act_rcv_dt, act_rcv_no, edi_snd_yrmondy, edi_snd_seq, flt_file_ref_no, "F/F Creation Success");
						} else if (rowCnt == 0) {
							String rtnStr = searchBkgExistence(act_rcv_dt, act_rcv_no, "BKG_CONTAINER"); // booking container 에 booking no 로 조회
							if (rtnStr.equals("EXISTED")) {
								// booking 이 BKG_BKG_CNTR 에 존재하지만 CONTAINER 가 없을 경우를 확인
								String tmp = searchBkgCntrDetail(act_rcv_dt, act_rcv_no);
								if (tmp.equals("EXISTED")) { // booking cntr 에 bkg_no, cntr_no 가 존재하면 BKG_BKG_VVD 확인으로 넘어감
									rtnStr = searchBkgExistence(act_rcv_dt, act_rcv_no, "BKG_VVD");
									if (rtnStr.equals("EXISTED")) {
										insertSendResult(act_rcv_dt, act_rcv_no, "F/F Creation Failed");
										// updateActUmchTpCd(con, act_rcv_dt, act_rcv_no, "70");
										cSMSendVO.setActUmchTpCd("70");
										updateActUmchTpCd(cSMSendVO);
									} else {
										insertSendResult(act_rcv_dt, act_rcv_no, rtnStr);
										// updateActUmchTpCd(con, act_rcv_dt, act_rcv_no, "14");
										cSMSendVO.setActUmchTpCd("14");
										updateActUmchTpCd(cSMSendVO);
									}
								} else { // booking cntr 에 bkg_no, cntr_no 가 존재하지 않으면 log 를 남김
									insertSendResult(act_rcv_dt, act_rcv_no, tmp);
									// updateActUmchTpCd(con, act_rcv_dt, act_rcv_no, "14");
									cSMSendVO.setActUmchTpCd("14");
									updateActUmchTpCd(cSMSendVO);
								}
							} else { // booking cntr 에 booking no 가 아예 없을 경우
								insertSendResult(act_rcv_dt, act_rcv_no, rtnStr);
								// updateActUmchTpCd(con, act_rcv_dt, act_rcv_no, "14");
								cSMSendVO.setActUmchTpCd("14");
								updateActUmchTpCd(cSMSendVO);
							}
						}
						totCnt += rowCnt;
						// closeStatement(ps);
					} while (dbRowset.next());
					// if (totCnt != 0) //updateActUmchTpCd(con, act_rcv_dt, act_rcv_no, "98");
					cSMSendVO.setActUmchTpCd("98");
					updateActUmchTpCd(cSMSendVO);
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}/*
		 * finally { //closeResultSet(rstSet); //closeStatement(ps_pk); //closeStatement(ps); //closeConnection(con); }
		 */
		return totCnt;
	}

	/**
	 * target data 별로 log 를 생성하여 준다.
	 * 
	 * @param act_rcv_dt
	 * @param act_rcv_no
	 * @param err_msg
	 * @throws DAOException
	 */
	private void insertSendResult(String act_rcv_dt, String act_rcv_no, String err_msg) throws DAOException {

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("err_msg", err_msg);
			param.put("act_rcv_dt", act_rcv_dt);
			param.put("act_rcv_no", act_rcv_no);

			new SQLExecuter("").executeUpdate(new CSMSendDBDAOAddSendResultCSQL(), param, null);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

	}

	/**
	 * target data 별로 log 를 생성하여 준다.
	 * 
	 * @param act_rcv_dt
	 * @param act_rcv_no
	 * @param edi_snd_yrmondy
	 * @param edi_snd_seq
	 * @param flt_file_ref_no
	 * @param err_msg
	 * @throws DAOException
	 */
	private void insertSendResult(String act_rcv_dt, String act_rcv_no, String edi_snd_yrmondy, String edi_snd_seq, String flt_file_ref_no, String err_msg) throws DAOException {

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("err_msg", err_msg);
			param.put("act_rcv_dt", act_rcv_dt);
			param.put("act_rcv_no", act_rcv_no);
			param.put("flt_file_ref_no", flt_file_ref_no);
			param.put("edi_snd_yrmondy", edi_snd_yrmondy);
			param.put("edi_snd_seq", edi_snd_seq);

			new SQLExecuter("").executeUpdate((ISQLTemplate) new CSMSendDBDAOAddSendResultExistCSQL(), param, null);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * log 의 message 와 전송 성공 여부를 update 한다.
	 * 
	 * @param edi_snd_yrmondy
	 * @param edi_snd_seq
	 * @param edi_snd_rslt_flg
	 * @param err_msg
	 * @param isAppendErrMsg : message 를 기존 data 뒤에 붙일 것인가
	 * @param edi_flt_file_ref_no
	 * @throws DAOException
	 */
	public void updateSendResultQuery(String edi_snd_yrmondy, int edi_snd_seq, String edi_snd_rslt_flg, String err_msg, String isAppendErrMsg, String edi_flt_file_ref_no) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int updCnt = 0;

		try {

			SQLExecuter sqlExe = new SQLExecuter("");

			param.put("edi_snd_yrmondy", edi_snd_yrmondy);
			param.put("edi_snd_seq", edi_snd_seq);
			param.put("edi_snd_rslt_flg", edi_snd_rslt_flg);
			param.put("edi_flt_file_ref_no", edi_flt_file_ref_no);
			param.put("err_msg", err_msg);
			velParam.put("is_append_err_msg", isAppendErrMsg);

			updCnt = sqlExe.executeUpdate(new CSMSendDBDAOModifySendResultUSQL(), param, velParam);
			if (updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update..");

			sqlExe = new SQLExecuter("");

			param = new HashMap<String, Object>();
			param.put("edi_snd_yrmondy", edi_snd_yrmondy);
			param.put("edi_snd_seq", edi_snd_seq);
			param.put("edi_snd_rslt_flg", edi_snd_rslt_flg);

			updCnt = sqlExe.executeUpdate(new CSMSendDBDAOModifyFFRsltFlgUSQL(), param, null);
			if (updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update..");

		} catch (SQLException se) {
			// se.printStackTrace();
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * interface 된 data 가 BKG_BKG_CNTR 에 존재하지만 Container 가 mapping 되지 않은 건인지를 확인
	 * 
	 * @param act_rcv_dt
	 * @param act_rcv_no
	 * @return String
	 * @throws DAOException
	 */
	private String searchBkgCntrDetail(String act_rcv_dt, String act_rcv_no) throws DAOException {
		StringBuffer rtnStrBf = new StringBuffer();
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			param.put("act_rcv_dt", act_rcv_dt);
			param.put("act_rcv_no", act_rcv_no);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CSMSendDBDAOSearchBkgCntrDetailRSQL(), param, velParam);

			if (!dbRowset.next()) {
				rtnStrBf.append("NO CONTAINER IN BKG_CONTAINER");
			} else {
				rtnStrBf.append("EXISTED");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnStrBf.toString();
	}

	/**
	 * table_name 에 해당하는 table 에 booking 정보가 존재하는 지 확인
	 * 
	 * @param act_rcv_dt
	 * @param act_rcv_no
	 * @param table_name
	 * @return String
	 * @throws DAOException
	 */
	private String searchBkgExistence(String act_rcv_dt, String act_rcv_no, String table_name) throws DAOException {
		StringBuffer rtnStrBf = new StringBuffer();
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			param.put("act_rcv_dt", act_rcv_dt);
			param.put("act_rcv_no", act_rcv_no);
			velParam.put("table_name", table_name);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CSMSendDBDAOSearchBkgExistenceRSQL(), param, velParam);

			if (!dbRowset.next()) {
				rtnStrBf.append("NOT EXISTED IN ");
				rtnStrBf.append(table_name);
			} else {
				rtnStrBf.append("EXISTED");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnStrBf.toString();
	}

	/**
	 * 전송 대상이 될 Flat file 을 조회한다.
	 * 
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchFlatFileToBeSent() throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {

			velParam.put("is_all_send", "T");

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CSMSendDBDAOSearchFlatFileToBeSentRSQL(), param, velParam);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}

	/**
	 * parameter 에 해당 되는 전송 성공 log 가 존재하는 지를 확인한다. 존재한다면 해당 전송은 skip 된다.
	 * 
	 * @param cSMSendVO
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean searchDupSndRslt(CSMSendVO cSMSendVO) throws DAOException {

		boolean isExists = false;

		DBRowSet dbRowset = null;
		// List<CSMSendVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (cSMSendVO != null) {
				Map<String, String> mapVO = cSMSendVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CSMSendDBDAOSearchDupSndRsltRSQL(), param, velParam);

			isExists = dbRowset.next();

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return isExists;
	}

	/**
	 * table_name 에 해당하는 table 에 booking 정보가 존재하는 지 확인
	 * 
	 * @param edi_snd_yrmondy String
	 * @param edi_snd_seq int
	 * @return String
	 * @throws DAOException
	 */
	public String searchFlatFileCLOB(String edi_snd_yrmondy, int edi_snd_seq) throws DAOException {
		String ediSendDesc = null;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			param.put("edi_snd_yrmondy", edi_snd_yrmondy);
			param.put("edi_snd_seq", edi_snd_seq);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CSMSendDBDAOSearchFlatFileCLOBRSQL(), param, velParam);

			while (dbRowset.next()) {
				ediSendDesc = dbRowset.getString("EDI_SEND_DESC");
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return ediSendDesc;
	}

}
