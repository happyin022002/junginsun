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
package com.hanjin.apps.alps.esd.sce.csmsend.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import com.hanjin.apps.alps.esd.sce.csmsend.vo.CSMSendVO;
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
public class CSMSendDBDAO extends DBDAOSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2143072738332663852L;


	/**
	 * booking 이 존재하는지, 존재하면 US bound 인지 조회
	 * bkg 미 존재시 'NOT_EXIST', 미주 향발이면 'US_BOUND' 아니면 'NOT_US_BOUND'
	 * @param cSMSendVO
	 * @return String
	 * @throws DAOException 
	 */
	public String searchBkgBound (CSMSendVO cSMSendVO) throws DAOException {
		/*Connection con = null;
		PreparedStatement ps = null; // 정적파싱을 지원하는 SQL Statement
		ResultSet rs = null; // DB ResultSet
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		String rtnStr = "";
		int i = 1;

		StringBuffer queryStr = new StringBuffer();
		queryStr.append("select case when pod_cd = 'NOT_EXIST' then pod_cd  \n") ;
		queryStr.append("            when pod_cd like 'US%' or del_cd like 'US%' then 'US_BOUND'  \n") ;
		queryStr.append("            else 'NOT_US_BOUND' end as CK \n") ;
		queryStr.append("from ( \n") ;
		queryStr.append("    select nvl(max(pod_cd), 'NOT_EXIST') as pod_cd, \n") ;
		queryStr.append("      nvl(max(del_cd), 'NOT_EXIST') as del_cd \n") ;
		queryStr.append("    from bkg_booking \n") ;
		queryStr.append("    where bkg_No = ? \n") ;
		queryStr.append("      and bkg_no_split = ?) \n") ;
		
		try {
			con = getConnection();
			*//** Loggable Statement 사용에 의해 추가 *//*
			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG)
					.equalsIgnoreCase("true")) {
				ps = new LoggableStatement(con, queryStr.toString());
			} else {
				ps = con.prepareStatement(queryStr.toString());
			}
			
			ps.setString(i++, bkg_no);
			ps.setString(i++, bkg_no_split);
			
			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG)
					.equalsIgnoreCase("true")) {
				log.info("\nSQL : " + ((LoggableStatement) ps).getQueryString());
			} else {
				log.info("\nSQL : " + queryStr.toString());
			}
			rs = ps.executeQuery();
			dRs = new DBRowSet();
			dRs.populate(rs);
			
			while (dRs.next()) {
				rtnStr = dRs.getString("CK");
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} finally {
			closeResultSet(rs);
			closeStatement(ps);
			closeConnection(con);
		}
		return rtnStr;*/
		
		
		String rtnStr = "";
		DBRowSet dbRowset = null;
		//List<CSMSendVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (cSMSendVO != null) {
				Map<String, String> mapVO = cSMSendVO
						.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("")
					.executeQuery(
							(ISQLTemplate) new CSMSendDBDAOSearchBkgBoundRSQL(),
							param, velParam);

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
	public void updateActUmchTpCd (CSMSendVO cSMSendVO) throws DAOException {
/*		Connection con = null;

		try {
			con = getConnection();
			updateActUmchTpCd(con, act_rcv_dt, act_rcv_no, act_umch_tp_cd);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} finally {
			closeConnection(con);
		}*/
		
		
		int updCnt = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {

			SQLExecuter sqlExe = new SQLExecuter("");
			if (cSMSendVO != null) {
				Map<String, String> mapVO = cSMSendVO
						.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
			}
			
			updCnt = sqlExe.executeUpdate((ISQLTemplate)new CSMSendDBDAOModifyActUmchTpCdUSQL(),param, velParam);
			
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
/*		Connection con = null;

		try {
			con = getConnection();
			updateActUmchTpCd(con, act_rcv_dt, act_rcv_no, act_umch_tp_cd);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} finally {
			closeConnection(con);
		}*/
		
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
					new CSMSendDBDAOModifyActUmchTpCdUSQL(),
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
	 * Empty container movement 를 대상으로 해당 mvmt 에 딸린 bkg 의 vvd 중 pod /del 도착까지 미주를 경유하는지 조회하여
	 * 대상이면 SCE_CNTR_STS_MSG_TGT 에 insert
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

//			param.put("act_rcv_dt", act_rcv_dt);
//			param.put("act_rcv_no", act_rcv_no);
//			param.put("act_umch_tp_cd", act_umch_tp_cd);
//			velParam.put("act_umch_tp_cd", act_umch_tp_cd);

			SQLExecuter sqlExe = new SQLExecuter("");

			updCnt = sqlExe.executeUpdate(new CSMSendDBDAOAddCSMTargetEmptyCntrCSQL(), param, velParam);
			if (updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update..");

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return updCnt;
	}	
	
	/**
	 * target data 의 interface 상태 (act_umch_tp_cd) 를 수정한다.
	 * 
	 * @param bkg_no
	 * @param bkg_no_split
	 * @param act_umch_tp_cd
	 * @return
	 * @throws DAOException
	 */
	/*private void updateActUmchTpCd (Connection con, String act_rcv_dt, String act_rcv_no, String act_umch_tp_cd) throws DAOException {
		PreparedStatement ps = null; // 정적파싱을 지원하는 SQL Statement
		int i = 1;
		
		StringBuffer queryStr = new StringBuffer();
		queryStr.append("UPDATE SCE_CNTR_STS_MSG_TGT \n") ;
		queryStr.append("SET ACT_UMCH_TP_CD = ? , \n") ;
		queryStr.append("  UPD_DT = SYSDATE , \n") ;
		queryStr.append("  UMCH_CHK_DT = SYSDATE  \n") ;
		
		if (!act_umch_tp_cd.equals("XX")) 
			queryStr.append("  , cop_evnt_seq = nvl(cop_evnt_seq, 0) + 1 \n") ;
		
		queryStr.append("where act_rcv_dt = ? \n") ;
		queryStr.append("  and act_rcv_no = ? \n") ;

		try {
			*//** Loggable Statement 사용에 의해 추가 *//*
			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG)
					.equalsIgnoreCase("true")) {
				ps = new LoggableStatement(con, queryStr.toString());
			} else {
				ps = con.prepareStatement(queryStr.toString());
			}
			
			ps.setString(i ++, act_umch_tp_cd);
			ps.setString(i ++, act_rcv_dt);
			ps.setString(i ++, act_rcv_no);
			
			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG)
					.equalsIgnoreCase("true")) {
				log.info("\nSQL : " + ((LoggableStatement) ps).getQueryString());
			} else {
				log.info("\nSQL : " + queryStr.toString());
			}
			ps.executeUpdate();
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} finally {
			closeStatement(ps);
		}
	}*/
	
	/**
	 * 불필요하다고 판단된 TARGET DATA 를 삭제한다.
	 * @param cSMSendVO
	 * @throws DAOException
	 */
	public void deleteCSMTarget(CSMSendVO cSMSendVO) throws DAOException {
		/*Connection con = null;
		PreparedStatement ps = null; // 정적파싱을 지원하는 SQL Statement
		int i = 1;
		
		StringBuffer queryStr = new StringBuffer();
		queryStr.append("DELETE FROM SCE_CNTR_STS_MSG_TGT WHERE ACT_RCV_DT = ? AND ACT_RCV_NO = ? \n") ;

		try {
			con = getConnection();
			*//** Loggable Statement 사용에 의해 추가 *//*
			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG)
					.equalsIgnoreCase("true")) {
				ps = new LoggableStatement(con, queryStr.toString());
			} else {
				ps = con.prepareStatement(queryStr.toString());
			}
			
			ps.setString(i ++, act_rcv_dt);
			ps.setString(i ++, act_rcv_no);
			
			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG)
					.equalsIgnoreCase("true")) {
				log.info("\nSQL : " + ((LoggableStatement) ps).getQueryString());
			} else {
				log.info("\nSQL : " + queryStr.toString());
			}
			ps.executeUpdate();
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} finally {
			closeStatement(ps);
			closeConnection(con);
		}*/
		
		
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int updCnt = 0;

		try {

			SQLExecuter sqlExe = new SQLExecuter("");
			
			if (cSMSendVO != null) {
				Map<String, String> mapVO = cSMSendVO
						.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			updCnt = sqlExe.executeUpdate(
					new CSMSendDBDAODeleteCSMTargetDSQL(),
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
	 * 미사용 METHOD
	 * 현재 기준으로 F/F 가 생성되어야 할 TARGET DATA 들을 GATHERING 하여 일괄 생성하려는 목적이었으나
	 * LOG 생성 등의 문제로 미사용
	 * 
	 * @return
	 * @throws DAOException
	 */
	/*public int insertFlatFile() throws DAOException {
		Connection con = null;
		PreparedStatement ps = null; // 정적파싱을 지원하는 SQL Statement
		int rowCnt = 0;
		StringBuffer queryStr = searchInsertFlatFileQuery(true);

		try {
			con = getConnection();
			*//** Loggable Statement 사용에 의해 추가 *//*
			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG)
					.equalsIgnoreCase("true")) {
				ps = new LoggableStatement(con, queryStr.toString());
			} else {
				ps = con.prepareStatement(queryStr.toString());
			}
			
			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG)
					.equalsIgnoreCase("true")) {
				log.info("\nSQL : " + ((LoggableStatement) ps).getQueryString());
			} else {
				log.info("\nSQL : " + queryStr.toString());
			}
			rowCnt = ps.executeUpdate();
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} finally {
			closeStatement(ps);
			closeConnection(con);
		}
		return rowCnt;
	}*/
	
	/**
	 * Flat file 을 생성하여 SCE_CNTR_STS_MSG_FLT_FILE table 에 input 한다.
	 * 주의: OP movement 는 2건의 flat file 이 생성 된다.
	 * 
	 * @param cSMSendVO
	 * @return int
	 * @throws DAOException
	 */
	public int insertFlatFile(CSMSendVO cSMSendVO) throws DAOException {

		int rowCnt = 0;
		int totCnt = 0;
		//StringBuffer queryStr = searchFlatFilePK();
		
		//ResultSet rstSet = null;
		
		DBRowSet dbRowset = null;
		//List<SearchNotificationVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
			
		try {			
			if (cSMSendVO != null) {
				Map<String, String> mapVO = cSMSendVO
						.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("")
					.executeQuery(
							(ISQLTemplate) new CSMSendDBDAOSearchFlatFilePKRSQL(),
							param, velParam);
			
			
			if (!dbRowset.next()) {
				// 해당 Movement 가 전송 대상이 아닌경우
				insertSendResult( cSMSendVO.getActRcvDt(),cSMSendVO.getActRcvNo() , "Wrong mvmt code : not in mapping");
				cSMSendVO.setActUmchTpCd("60");
				updateActUmchTpCd( cSMSendVO );
//				deleteCSMTarget(act_rcv_dt, act_rcv_no);
			} else {
				do {
					String edi_snd_yrmondy = dbRowset.getString("EDI_SND_YRMONDY");
					String edi_snd_seq = dbRowset.getString("EDI_SND_SEQ");
					String stnd_edi_sts_cd = dbRowset.getString("STND_EDI_STS_CD");
					String flt_file_ref_no = dbRowset.getString("FLT_FILE_REF_NO");
					String act_rcv_dt =  cSMSendVO.getActRcvDt();
					String act_rcv_no =  cSMSendVO.getActRcvNo();
					param.put("edi_snd_yrmondy", edi_snd_yrmondy);
					param.put("edi_snd_seq", edi_snd_seq);
					param.put("stnd_edi_sts_cd", stnd_edi_sts_cd);
					param.put("flt_file_ref_no", flt_file_ref_no);
					param.put("act_rcv_dt", act_rcv_dt);
					param.put("act_rcv_no", act_rcv_no);
					
					velParam.put("is_multi_rows", "F");
				
					rowCnt= new SQLExecuter("")
					.executeUpdate(
							 new CSMSendDBDAOAddFlatFileCSQL(),param, velParam);
					
					log.info("\nafter flat file, rowCnt = " + rowCnt);
					
					// flat file 생성 후의 처리 시작
					if (rowCnt >= 1) {
						insertSendResult( act_rcv_dt, act_rcv_no, edi_snd_yrmondy, edi_snd_seq, flt_file_ref_no, "F/F Creation Success");
					} else if (rowCnt == 0) {
						String rtnStr = searchBkgExistence( act_rcv_dt, act_rcv_no, "BKG_CONTAINER"); // booking container 에 booking no 로 조회
						if (rtnStr.equals("EXISTED")) {
							// booking 이 BKG_BKG_CNTR 에 존재하지만 CONTAINER 가 없을 경우를 확인
							String tmp = searchBkgCntrDetail( act_rcv_dt, act_rcv_no);
							if (tmp.equals("EXISTED")) { // booking cntr 에 bkg_no, cntr_no 가 존재하면 BKG_BKG_VVD 확인으로 넘어감
								rtnStr = searchBkgExistence( act_rcv_dt, act_rcv_no, "BKG_VVD");
								if (rtnStr.equals("EXISTED")) {
									insertSendResult( act_rcv_dt, act_rcv_no, "F/F Creation Failed");
									//updateActUmchTpCd(con, act_rcv_dt, act_rcv_no, "70");
									cSMSendVO.setActUmchTpCd("70");
									updateActUmchTpCd(cSMSendVO);
								} else {
									insertSendResult( act_rcv_dt, act_rcv_no, rtnStr);
									//updateActUmchTpCd(con, act_rcv_dt, act_rcv_no, "14");
									cSMSendVO.setActUmchTpCd("14");
									updateActUmchTpCd(cSMSendVO);
								}	
							} else { // booking cntr 에 bkg_no, cntr_no 가 존재하지 않으면 log 를 남김
								insertSendResult( act_rcv_dt, act_rcv_no, tmp);
								//updateActUmchTpCd(con, act_rcv_dt, act_rcv_no, "14");
								cSMSendVO.setActUmchTpCd("14");
								updateActUmchTpCd(cSMSendVO);
							}
						} else { // booking cntr 에 booking no 가 아예 없을 경우
							insertSendResult( act_rcv_dt, act_rcv_no, rtnStr);
							//updateActUmchTpCd(con, act_rcv_dt, act_rcv_no, "14");
							cSMSendVO.setActUmchTpCd("14");
							updateActUmchTpCd(cSMSendVO);
						}
					}
					totCnt += rowCnt;
					//closeStatement(ps);
				} while (dbRowset.next());
				if (totCnt != 0) 
					//updateActUmchTpCd(con, act_rcv_dt, act_rcv_no, "98");
					cSMSendVO.setActUmchTpCd("98");
					updateActUmchTpCd(cSMSendVO);
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
	

//	/**
//	 * 미사용
//	 * target data 별로 log 를 생성하여 준다.
//	 * 외부에서 호출 가능한 modifier
//	 * @param act_rcv_dt
//	 * @param act_rcv_no
//	 * @param err_msg
//	 * @throws DAOException
//	 */
/*	public void insertSendResult(String act_rcv_dt, String act_rcv_no, String err_msg) throws DAOException {
		Connection con = null;
		
		try {
			con = getConnection();
			insertSendResult(con, act_rcv_dt, act_rcv_no, err_msg);
		}catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} finally {
			closeConnection(con);
		}
	}*/
	
	
	/**
	 * target data 별로 log 를 생성하여 준다.
	 * 
	 * @param act_rcv_dt
	 * @param act_rcv_no
	 * @param err_msg
	 * @throws DAOException
	 */
	private void insertSendResult( String act_rcv_dt, String act_rcv_no, String err_msg) throws DAOException {
		/*PreparedStatement ps = null; // 정적파싱을 지원하는 SQL Statement
		int i = 1;
		
		//StringBuffer queryStr = searchInsertSendResultQuery(false);

		try {
			*//** Loggable Statement 사용에 의해 추가 *//*
			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG)
					.equalsIgnoreCase("true")) {
				ps = new LoggableStatement(con, queryStr.toString());
			} else {
				ps = con.prepareStatement(queryStr.toString());
			}
			ps.setString(i ++, err_msg);
			
			ps.setString(i ++, act_rcv_dt);
			ps.setString(i ++, act_rcv_no);
			ps.setString(i ++, act_rcv_dt);
			ps.setString(i ++, act_rcv_no);
			
			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG)
					.equalsIgnoreCase("true")) {
				log.info("\nSQL : " + ((LoggableStatement) ps).getQueryString());
			} else {
				log.info("\nSQL : " + queryStr.toString());
			}
			ps.executeUpdate();
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} finally {
			closeStatement(ps);
		}*/
		
		//int rowCnt = 0;
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
	private void insertSendResult( String act_rcv_dt, String act_rcv_no, String edi_snd_yrmondy, String edi_snd_seq, String flt_file_ref_no, String err_msg) throws DAOException {
/*		PreparedStatement ps = null; // 정적파싱을 지원하는 SQL Statement
		int i = 1;
		
		StringBuffer queryStr = searchInsertSendResultQuery(true);

		try {
			*//** Loggable Statement 사용에 의해 추가 *//*
			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG)
					.equalsIgnoreCase("true")) {
				ps = new LoggableStatement(con, queryStr.toString());
			} else {
				ps = con.prepareStatement(queryStr.toString());
			}
			ps.setString(i++, err_msg);
			
			ps.setString(i++, flt_file_ref_no);
			
			ps.setString(i++, act_rcv_dt);
			ps.setString(i++, act_rcv_no);

			ps.setString(i++, edi_snd_yrmondy);
			ps.setString(i++, edi_snd_seq);
			
			ps.setString(i ++, act_rcv_dt);
			ps.setString(i ++, act_rcv_no);
			

			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG)
					.equalsIgnoreCase("true")) {
				log.info("\nSQL : " + ((LoggableStatement) ps).getQueryString());
			} else {
				log.info("\nSQL : " + queryStr.toString());
			}
			ps.executeUpdate();
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} finally {
			closeStatement(ps);
		}*/
		
		//int rowCnt =0;
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
							(ISQLTemplate) new CSMSendDBDAOAddSendResultExistCSQL(),
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
					new CSMSendDBDAOModifySendResultUSQL(),
					param, velParam);
			if (updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update..");

			sqlExe = new SQLExecuter("");
			
			param = new HashMap<String, Object>();
			param.put("edi_snd_yrmondy",edi_snd_yrmondy);
			param.put("edi_snd_seq",edi_snd_seq);
			param.put("edi_snd_rslt_flg",edi_snd_rslt_flg);	
			
			updCnt = sqlExe.executeUpdate(
					new CSMSendDBDAOModifyFFRsltFlgUSQL(),
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
	 * interface 된 data 가 BKG_BKG_CNTR 에 존재하지만 Container 가
	 * mapping 되지 않은 건인지를 확인
	 * @param act_rcv_dt
	 * @param act_rcv_no
	 * @return String
	 * @throws DAOException
	 */
	private String searchBkgCntrDetail( String act_rcv_dt, String act_rcv_no) throws DAOException {
		/*PreparedStatement ps = null; // 정적파싱을 지원하는 SQL Statement
		int i = 1;
		StringBuffer rtnStrBf = new StringBuffer();
		
		ResultSet rstSet = null;
		
		StringBuffer queryStr = new StringBuffer();
		
		queryStr.append(" SELECT \n") ;
		queryStr.append(" '1' \n") ;
		queryStr.append(" FROM BKG_BKG_CNTR \n") ;
		queryStr.append(" WHERE (BKG_NO, BKG_NO_SPLIT, CNTR_NO) IN (SELECT BKG_NO, BKG_NO_SPLIT, CNTR_NO FROM SCE_CNTR_STS_MSG_TGT WHERE ACT_RCV_DT = ? AND ACT_RCV_NO = ?) \n");
		
		try {
			*//** Loggable Statement 사용에 의해 추가 *//*
			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG)
					.equalsIgnoreCase("true")) {
				ps = new LoggableStatement(con, queryStr.toString());
			} else {
				ps = con.prepareStatement(queryStr.toString());
			}
			
			ps.setString(i ++, act_rcv_dt);
			ps.setString(i ++, act_rcv_no);
						
			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG)
					.equalsIgnoreCase("true")) {
				log.info("\nSQL : " + ((LoggableStatement) ps).getQueryString());
			} else {
				log.info("\nSQL : " + queryStr.toString());
			}
			rstSet = ps.executeQuery();
			
			if (!rstSet.next()) {
				rtnStrBf.append("NO CONTAINER IN BKG_BKG_CNTR");
			} else {
				rtnStrBf.append("EXISTED");
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} finally {
			closeStatement(ps);
		}
		return rtnStrBf.toString();*/
		
		
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
							(ISQLTemplate) new CSMSendDBDAOSearchBkgCntrDetailRSQL(),
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
		/*PreparedStatement ps = null; // 정적파싱을 지원하는 SQL Statement
		int i = 1;
		StringBuffer rtnStrBf = new StringBuffer();
		
		ResultSet rstSet = null;
		
		StringBuffer queryStr = new StringBuffer();
		
		queryStr.append(" SELECT \n") ;
		queryStr.append("'") ;
		queryStr.append(table_name);
		queryStr.append("'") ;
		queryStr.append(" FROM \n") ;
		queryStr.append(table_name) ;
		queryStr.append(" WHERE (BKG_NO, BKG_NO_SPLIT) IN (SELECT BKG_NO, BKG_NO_SPLIT FROM SCE_CNTR_STS_MSG_TGT WHERE ACT_RCV_DT = ? AND ACT_RCV_NO = ?) \n");
		
		try {
			*//** Loggable Statement 사용에 의해 추가 *//*
			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG)
					.equalsIgnoreCase("true")) {
				ps = new LoggableStatement(con, queryStr.toString());
			} else {
				ps = con.prepareStatement(queryStr.toString());
			}
			
			ps.setString(i ++, act_rcv_dt);
			ps.setString(i ++, act_rcv_no);
						
			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG)
					.equalsIgnoreCase("true")) {
				log.info("\nSQL : " + ((LoggableStatement) ps).getQueryString());
			} else {
				log.info("\nSQL : " + queryStr.toString());
			}
			rstSet = ps.executeQuery();
			
			if (!rstSet.next()) {
				rtnStrBf.append("NOT EXISTED IN ");
				rtnStrBf.append(table_name);
			} else {
				rtnStrBf.append("EXISTED");
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} finally {
			closeStatement(ps);
		}
		return rtnStrBf.toString();*/
		
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
							(ISQLTemplate) new CSMSendDBDAOSearchBkgExistenceRSQL(),
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
	 * 전송 대상이 될 Flat file 을 조회한다.
	 * 
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchFlatFileToBeSent() throws DAOException {
		/*Connection con = null; // Connection Interface
		PreparedStatement ps = null; // 정적파싱을 지원하는 SQL Statement
		ResultSet rs = null; // DB ResultSet
		
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		StringBuffer queryStr = searchFlatFileToBeSentQuery(true);
		
		try {
			con = getConnection();
			*//** Loggable Statement 사용에 의해 추가 *//*
			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG)
					.equalsIgnoreCase("true")) {
				ps = new LoggableStatement(con, queryStr.toString());
			} else {
				ps = con.prepareStatement(queryStr.toString());
			}

			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG)
					.equalsIgnoreCase("true")) {
				log.info("\nSQL : " + ((LoggableStatement) ps).getQueryString());
			} else {
				log.info("\nSQL : " + queryStr.toString());
			}
			
			rs = ps.executeQuery();
			dRs = new DBRowSet();
			dRs.populate(rs);
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} finally {
			closeResultSet(rs);
			closeStatement(ps);
			closeConnection(con);
		}
		return dRs;*/
		
		
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			
			velParam.put("is_all_send", "T");
			
			dbRowset = new SQLExecuter("")
					.executeQuery(
							(ISQLTemplate) new CSMSendDBDAOSearchFlatFileToBeSentRSQL(),
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
	 * @param cSMSendVO
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean searchDupSndRslt(CSMSendVO cSMSendVO) throws DAOException {
		/*Connection con = null; // Connection Interface
		PreparedStatement ps = null; // 정적파싱을 지원하는 SQL Statement
		ResultSet rs = null; // DB ResultSet
		
		StringBuffer queryStr = searchDupSndRslt();
		
		boolean isExists = false;
		int i = 1;
		
		try {
			con = getConnection();
			*//** Loggable Statement 사용에 의해 추가 *//*
			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG)
					.equalsIgnoreCase("true")) {
				ps = new LoggableStatement(con, queryStr.toString());
			} else {
				ps = con.prepareStatement(queryStr.toString());
			}
			
			ps.setString (i ++, (String) rowMap.get("BKG_NO"));
			ps.setString (i ++, (String) rowMap.get("BKG_NO_SPLIT"));
			ps.setString (i ++, (String) rowMap.get("CNTR_NO"));
			ps.setString (i ++, (String) rowMap.get("ACT_DT"));
			ps.setString (i ++, (String) rowMap.get("ACT_STS_MAPG_CD"));
			ps.setString (i ++, (String) rowMap.get("NOD_CD"));
			ps.setString (i ++, (String) rowMap.get("ACT_RCV_DT"));
			ps.setString (i ++, (String) rowMap.get("ACT_RCV_NO"));

			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG)
					.equalsIgnoreCase("true")) {
				log.info("\nSQL : " + ((LoggableStatement) ps).getQueryString());
			} else {
				log.info("\nSQL : " + queryStr.toString());
			}
			
			rs = ps.executeQuery();
			
			isExists = rs.next();
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} finally {
			closeResultSet(rs);
			closeStatement(ps);
			closeConnection(con);
		}
		return isExists;*/
		
		
		boolean isExists = false;
		
		DBRowSet dbRowset = null;
		//List<CSMSendVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (cSMSendVO != null) {
				Map<String, String> mapVO = cSMSendVO
						.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("")
					.executeQuery(
							(ISQLTemplate) new CSMSendDBDAOSearchDupSndRsltRSQL(),
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
