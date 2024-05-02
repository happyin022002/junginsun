/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CSMSendEurDBDAO.java
*@FileTitle : CSM (Container Status Message) 구주세관 전송 
*Open Issues :
*Change history :
*@LastModifyDate : 2016-06-15
*@LastModifier :
*@LastVersion : 1.0
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.sce.csmsendeur.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import com.hanjin.apps.alps.esd.sce.csmsendeur.vo.CSMSendEurVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * ENIS-SCEM Business Logic Basic Command implementation<br>
 * - ENIS-SCEM에 대한 DB 작업을 처리한다.<br>
 * @author 2002701
 * @see
 * @since J2EE 1.4
 */
public class CSMSendEurDBDAO extends DBDAOSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2143072738332663852L;

	
	/**
	 * target data 의 interface 상태 (act_umch_tp_cd) 를 수정한다.
	 * 
	 * @param cSMSendEurVO
	 * @throws DAOException
	 */
	public void updateActUmchTpCd (CSMSendEurVO cSMSendEurVO) throws DAOException {
		
		int updCnt = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {

			SQLExecuter sqlExe = new SQLExecuter("");
			if (cSMSendEurVO != null) {
				Map<String, String> mapVO = cSMSendEurVO
						.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
			}
			
			updCnt = sqlExe.executeUpdate((ISQLTemplate)new CSMSendEurDBDAOModifyActUmchTpCdUSQL(),param, velParam);
			
			if (updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update..");
			

		} catch (SQLException se) {
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
	public void updateActUmchTpCd (String act_rcv_dt, String act_rcv_no, String act_umch_tp_cd) throws DAOException {

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

			updCnt = sqlExe.executeUpdate(
					new CSMSendEurDBDAOModifyActUmchTpCdUSQL(),
					param, velParam);
			if (updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update..");
			

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	
	/**
	 * Flat File 을 생성하여 SCE_CSM_FLT_FILE_EUR table 에 input 한다.
	 * 
	 * @param cSMSendEurVO
	 * @return int
	 * @throws DAOException
	 */
	public int insertFlatFile(CSMSendEurVO cSMSendEurVO) throws DAOException {

		int rowCnt = 0;
		int totCnt = 0;
		
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
			
		try {			
			if (cSMSendEurVO != null) {
				Map<String, String> mapVO = cSMSendEurVO
						.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				dbRowset = new SQLExecuter("")
					.executeQuery((ISQLTemplate) new CSMSendEurDBDAOSearchFlatFilePKRSQL(),param, velParam);
			
				if (!dbRowset.next()) {
					// 해당 Movement 가 전송 대상이 아닌경우
					insertSendResult(cSMSendEurVO.getActRcvDt(),cSMSendEurVO.getActRcvNo(),
							"Wrong mvmt code : not in mapping");
					cSMSendEurVO.setActUmchTpCd("60");
					
					
				} else {
					do {
						String edi_snd_yrmondy = dbRowset.getString("EDI_SND_YRMONDY");
						String edi_snd_seq = dbRowset.getString("EDI_SND_SEQ");
						String stnd_edi_sts_cd = dbRowset.getString("STND_EDI_STS_CD");
						String flt_file_ref_no = dbRowset.getString("FLT_FILE_REF_NO");
						String act_rcv_dt =  cSMSendEurVO.getActRcvDt();
						String act_rcv_no =  cSMSendEurVO.getActRcvNo();
						
						param.put("edi_snd_yrmondy", edi_snd_yrmondy);
						param.put("edi_snd_seq", edi_snd_seq);
						param.put("stnd_edi_sts_cd", stnd_edi_sts_cd);
						param.put("flt_file_ref_no", flt_file_ref_no);
						param.put("act_rcv_dt", act_rcv_dt);
						param.put("act_rcv_no", act_rcv_no);
						
						velParam.put("is_multi_rows", "F"); // false (not multi rows)
					
						rowCnt= new SQLExecuter("")
						.executeUpdate(
								 new CSMSendEurDBDAOAddFlatFileCSQL(),param, velParam);
						
						log.info("\n after flat file, rowCnt = " + rowCnt);
						
						// Flat File 생성 후의 처리 시작
						if (rowCnt >= 1) {
							insertSendResult(act_rcv_dt, act_rcv_no, edi_snd_yrmondy, edi_snd_seq, flt_file_ref_no, "F/F Creation Success");
						} else if (rowCnt == 0) {
							String rtnStr = searchBkgExistence(act_rcv_dt, act_rcv_no, "BKG_CONTAINER"); // BKG_CONTAINER 에 Booking no. 로 조회
							if (rtnStr.equals("EXISTED")) {
								// Booking 이 BKG_CONTAINER 에 존재하지만 Container 가 없을 경우를 확인
								String tmp = searchBkgCntrDetail(act_rcv_dt, act_rcv_no);
								if (tmp.equals("EXISTED")) { // BKG_CONTAINER 에 BKG_NO, CNTR_NO 가 존재하면 BKG_VVD 확인으로 넘어감
									rtnStr = searchBkgExistence(act_rcv_dt, act_rcv_no, "BKG_VVD");
									if (rtnStr.equals("EXISTED")) {
										insertSendResult(act_rcv_dt, act_rcv_no, "F/F Creation Failed");
										cSMSendEurVO.setActUmchTpCd("70");
									} else { // BKG_CONTAINER 정보는 존재하지만 VVD 정보가 없는 경우는 14로 매핑
										insertSendResult(act_rcv_dt, act_rcv_no, rtnStr);
										cSMSendEurVO.setActUmchTpCd("14"); // 재 처리 대상
									}	
								} else { // BKG_CONTAINER 에 BKG_NO, CNTR_NO 가 존재하지 않으면 log 를 남김
									insertSendResult(act_rcv_dt, act_rcv_no, tmp);
									cSMSendEurVO.setActUmchTpCd("14"); // 재 처리 대상
								}
							} else { // BKG_CONTAINER 에 Booking no. 가 아예 없을 경우
								insertSendResult(act_rcv_dt, act_rcv_no, rtnStr);
								cSMSendEurVO.setActUmchTpCd("14"); // 재 처리 대상
							}
						}
						totCnt += rowCnt;
					} while (dbRowset.next());
					if (totCnt != 0) 
						cSMSendEurVO.setActUmchTpCd("98"); // Queue 로 보내기 전 insert 완료 - 98
				}
				updateActUmchTpCd(cSMSendEurVO);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} 
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
			
			new SQLExecuter("").executeUpdate(new CSMSendEurDBDAOAddSendResultCSQL(), param, null);

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
	private void insertSendResult( String act_rcv_dt, String act_rcv_no, String edi_snd_yrmondy, String edi_snd_seq, String flt_file_ref_no, String err_msg) throws DAOException {

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("err_msg", err_msg);
			param.put("act_rcv_dt", act_rcv_dt);
			param.put("act_rcv_no", act_rcv_no);
			param.put("flt_file_ref_no", flt_file_ref_no);
			param.put("edi_snd_yrmondy", edi_snd_yrmondy);
			param.put("edi_snd_seq", edi_snd_seq);
			
			new SQLExecuter("").executeUpdate(
							(ISQLTemplate) new CSMSendEurDBDAOAddSendResultExistCSQL(),
							param, null);

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
	 * @param edi_snd_yrmondy
	 * @param edi_snd_seq
	 * @param edi_snd_rslt_flg
	 * @param err_msg
	 * @param isAppendErrMsg : message 를 기존 data 뒤에 붙일 것인가
	 * @throws DAOException
	 */
	public void updateSendResultQuery(String edi_snd_yrmondy, int edi_snd_seq, String edi_snd_rslt_flg, String err_msg, String isAppendErrMsg) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int updCnt = 0;

		try {

			SQLExecuter sqlExe = new SQLExecuter("");
			
			param.put("edi_snd_yrmondy",edi_snd_yrmondy);
			param.put("edi_snd_seq",edi_snd_seq);
			param.put("edi_snd_rslt_flg",edi_snd_rslt_flg);
			param.put("err_msg",err_msg);
			velParam.put("is_append_err_msg",isAppendErrMsg);
			
			updCnt = sqlExe.executeUpdate(
					new CSMSendEurDBDAOModifySendResultUSQL(),
					param, velParam);
			if (updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update..");

			sqlExe = new SQLExecuter("");
			
			param = new HashMap<String, Object>();
			param.put("edi_snd_yrmondy",edi_snd_yrmondy);
			param.put("edi_snd_seq",edi_snd_seq);
			param.put("edi_snd_rslt_flg",edi_snd_rslt_flg);	
			
			updCnt = sqlExe.executeUpdate(
					new CSMSendEurDBDAOModifyFFRsltFlgUSQL(),
					param, null);
			if (updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update..");
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * interface 된 data 가 BKG_CONTAINER 에 존재하지만 Container 가
	 * mapping 되지 않은 건인지를 확인
	 * @param act_rcv_dt
	 * @param act_rcv_no
	 * @return String
	 * @throws DAOException
	 */
	private String searchBkgCntrDetail( String act_rcv_dt, String act_rcv_no) throws DAOException {

		StringBuffer rtnStrBf = new StringBuffer();
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			param.put("act_rcv_dt", act_rcv_dt);
			param.put("act_rcv_no", act_rcv_no);
			
			dbRowset = new SQLExecuter("")
					.executeQuery(
							(ISQLTemplate) new CSMSendEurDBDAOSearchBkgCntrDetailRSQL(),
							param, velParam);
			
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
	 * @param act_rcv_dt
	 * @param act_rcv_no
	 * @param table_name
	 * @return String
	 * @throws DAOException
	 */
	private String searchBkgExistence ( String act_rcv_dt, String act_rcv_no, String table_name) throws DAOException {
		
		StringBuffer rtnStrBf = new StringBuffer();
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			param.put("act_rcv_dt", act_rcv_dt);
			param.put("act_rcv_no", act_rcv_no);
			velParam.put("table_name", table_name);
			
			dbRowset = new SQLExecuter("")
					.executeQuery(
							(ISQLTemplate) new CSMSendEurDBDAOSearchBkgExistenceRSQL(),
							param, velParam);
			
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
	 * 전송 대상이 될 Flat File 을 조회한다.
	 * 
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchFlatFileToBeSent(CSMSendEurVO cSMSendEurVO) throws DAOException {

		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			
			String act_rcv_dt = cSMSendEurVO.getActRcvDt();
			String act_rcv_no = cSMSendEurVO.getActRcvNo();
			
			param.put("act_rcv_dt", act_rcv_dt);
			param.put("act_rcv_no", act_rcv_no);
			
			dbRowset = new SQLExecuter("")
					.executeQuery(
							(ISQLTemplate) new CSMSendEurDBDAOSearchFlatFileToBeSentRSQL(),
							param, velParam);
			
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
	 * parameter 에 해당 되는 전송 성공 log 가 존재하는 지를 확인한다.
	 * 존재한다면 해당 전송은 skip 된다.
	 * @param cSMSendEurVO
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean searchDupSndRslt(CSMSendEurVO cSMSendEurVO) throws DAOException {

		boolean isExists = false;
		
		DBRowSet dbRowset = null;
		//List<CSMSendEurVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (cSMSendEurVO != null) {
				Map<String, String> mapVO = cSMSendEurVO
						.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("")
					.executeQuery(
							(ISQLTemplate) new CSMSendEurDBDAOSearchDupSndRsltRSQL(),
							param, velParam);

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
	
	
	
}
