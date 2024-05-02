/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : WebGateDBDAO.java
 *@FileTitle : WebGate
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2007-07-10
 *@LastModifier : cho_gilhong@naver.com
 *@LastVersion : 1.0
 * 2007-07-10 cho_gilhong@naver.com
 * 1.0 최초 생성
 =========================================================*/
package com.clt.apps.opus.esd.sce.servicesio.newwebgate.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.clt.apps.opus.esd.sce.servicesio.newwebgate.basic.WebGateBCImpl;
import com.clt.apps.opus.esd.sce.servicesio.newwebgate.event.CntrMvmt;
import com.clt.apps.opus.esd.sce.servicesio.newwebgate.event.Movement;
import com.clt.apps.opus.esd.sce.servicesio.newwebgate.event.SppSce0001Event;
import com.clt.apps.opus.esd.sce.servicesio.newwebgate.event.SppSce0001EventResponse;
import com.clt.apps.opus.esd.sce.servicesio.newwebgate.event.SppSce0002Event;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;

//import com.clt.apps.opus.esd.trs.servicesio.railbilling.common.TraceLogUtil;

/**
 * SPP-SCE 에 대한 DB 처리를 담당<br>
 * - SPP-SCE Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author kwon kidu
 * @see WebGateBCImpl 참조
 * @since J2EE 1.4
 */
public class WebGateDBDAO extends DBDAOSupport {
	private static final String ERROR_01 = "Error: Unavailable container No and booking No for the selected status.";
	//private static final String ERROR_02 = "Error: No In or Outbound activity for the container NO.";
	//private static final String ERROR_03 = "Error: No transportation information for the container No.";
	private static final String ERROR_04 = "Error: System error (DB insert failed)";
//	private static final String ERROR_05 = "Error: Future date/time must be within 3 times.";
//	private static final String ERROR_06 = "Error: Event date/time must be within 7 days.";
	private static final String ERROR_08 = "Error: Duplicate.";
	private static final String UNHANDLED_EXPT_MSG = "UnHandled Exception Error.";

	private static final long serialVersionUID = 1L;
//	private TraceLogUtil trcLogUtil = new TraceLogUtil("CONTAINER MOVEMENT");
	
	
	// activity type
	private int getActivityType(String mov_tp) {
		int iType = -1;

		if ("MOB".equals(mov_tp) || "MIB".equals(mov_tp)) {
			iType = 0; // direct
		} else if ("LOADING".equals(mov_tp) || "UNLOADING".equals(mov_tp)) {
			iType = 1;
		}
		return iType;
	}

	// TruckMovement
	private String getActivityTruckMovement(String mov_tp) {
		String strRet = "";

		if ("MOB".equals(mov_tp)) {
			strRet = "MOTZAD";
		} else if ("MIB".equals(mov_tp)) {
			strRet = "FITZAD";
		}
		return strRet;
	}

	// Yard & Terminal >> Loaded
	private String getActivityYardTerminalLoaded(String direction, String moved_by, String mov_tp) {
		String strRet = "";

		if ("OB".equals(direction)) {
			if ("RAIL".equals(moved_by)) {
				if ("LOADING".equals(mov_tp)) {
					strRet = "FORRLO";
				} else if ("UNLOADING".equals(mov_tp)) {
					strRet = "FORRUD";
				}
			} else if ("BARGE".equals(moved_by)) {
				if ("LOADING".equals(mov_tp)) {
					strRet = "FOWMLO";
				} else if ("UNLOADING".equals(mov_tp)) {
					strRet = "FLWMUD";
				}
			}
		} else if ("IB".equals(direction)) {
			if ("RAIL".equals(moved_by)) {
				if ("LOADING".equals(mov_tp)) {
					strRet = "FIRRLO";
				} else if ("UNLOADING".equals(mov_tp)) {
					strRet = "FIRRUD";
				}
			} else if ("BARGE".equals(moved_by)) {
				if ("LOADING".equals(mov_tp)) {
					strRet = "FUWMLO";
				} else if ("UNLOADING".equals(mov_tp)) {
					strRet = "FIWMUD";
				}
			}
		}
		return strRet;
	}

	// COP count
	private int getCOPCount(String cntr_no, String bkg_no, String act_cd, int iMode, String mov_tp, String direction) {
		int iRet = -1;
		DBRowSet rs = null;

		try {
			
			Map<String, Object> param = new HashMap<String, Object>();
    		param.put("cntr_no", cntr_no);
    		param.put("bkg_no", bkg_no);
    		param.put("act_cd", act_cd);
    		
    		Map<String, Object> velParam = new HashMap<String, Object>();
    		velParam.put("iMode",iMode);
    		velParam.put("mov_tp",mov_tp);
    		velParam.put("direction",direction);
    		
    		SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
    		WebGateDBDAOGetCOPCountRSQL template = new WebGateDBDAOGetCOPCountRSQL();
    		
            rs = sqlExe.executeQuery(template,param,velParam);
			
			if (rs.next()) {
				iRet = rs.getInt("COP_NUM");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			iRet = -1;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			iRet = -2;
		} 
		
		return iRet;
	}

	// NodCd
	private String getNodCd(String cntr_no, String bkg_no, String act_cd, int iMode, String mov_tp, String direction) {
		String stReturn = "";
		DBRowSet rs = null;

		try {
			
			Map<String, Object> param = new HashMap<String, Object>();
    		param.put("cntr_no", cntr_no);
    		param.put("bkg_no", bkg_no);
    		param.put("act_cd", act_cd);
    		
    		Map<String, Object> velParam = new HashMap<String, Object>();
    		velParam.put("iMode",iMode);
    		velParam.put("mov_tp",mov_tp);
    		velParam.put("direction",direction);
    		
    		SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
    		WebGateDBDAOGetNodCdRSQL template = new WebGateDBDAOGetNodCdRSQL();
    		
            rs = sqlExe.executeQuery(template,param,velParam);
            
			if (rs.next()) {
				stReturn = rs.getString("NOD_CD");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} 

		return stReturn;
	}

	// Act_dt count
	private String getActDt(String cntr_no, String bkg_no, String act_cd, int iMode, String mov_tp, String direction) {
		String stReturn = "";
		DBRowSet rs = null;

		try {
			
			Map<String, Object> param = new HashMap<String, Object>();
    		param.put("cntr_no", cntr_no);
    		param.put("bkg_no", bkg_no);
    		param.put("act_cd", act_cd);
    		
    		Map<String, Object> velParam = new HashMap<String, Object>();
    		velParam.put("iMode",iMode);
    		velParam.put("mov_tp",mov_tp);
    		velParam.put("direction",direction);
    		
    		SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
    		WebGateDBDAOGetActDtRSQL template = new WebGateDBDAOGetActDtRSQL();
    		
            rs = sqlExe.executeQuery(template,param,velParam);

			if (rs.next()) {
				stReturn = rs.getString("ACT_DT");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} 

		return stReturn;
	}

	// select activity code
	private String getFullBkgNo(String bl_no) {
		String strRet = "";
		DBRowSet rs = null;

		try {
			
			Map<String, Object> param = new HashMap<String, Object>();
    		param.put("bl_no", bl_no);
    		
    		SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
    		WebGateDBDAOGetFullBkgNoRSQL template = new WebGateDBDAOGetFullBkgNoRSQL();
    		
            rs = sqlExe.executeQuery(template,param,null);

			if (rs.next()) {
				strRet = checkString(rs.getString("FULL_BOOKING_NO"));
			} else {
				strRet = "";
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			strRet = "";
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			strRet = "";
		} 

		return strRet;
	}

	// insert movement
	private int insertMovement(String bkg_no,String cntr_no, String act_dt, String act_cd, String nod_cd, String office, String vndr_seq, String user_id) {
		int iRet = -1;
		
		try {
			
			Map<String, Object> param = new HashMap<String, Object>();
    		param.put("bkg_no", bkg_no);
    		param.put("cntr_no", cntr_no);
    		param.put("act_dt", act_dt);
    		param.put("act_cd", act_cd);
    		param.put("nod_cd", nod_cd);
    		param.put("office", office);
    		param.put("vndr_seq", vndr_seq);
    		param.put("user_id", user_id);
    		
    		SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
    		WebGateDBDAOInsertMovementCSQL template = new WebGateDBDAOInsertMovementCSQL();
    		
    		iRet = sqlExe.executeUpdate(template,param,null);

		} catch (SQLException se) {
			log.error(ERROR_04 + " at CNTR_NO = " + cntr_no + " : " + se.getMessage());
			iRet = -1;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			iRet = -1;
		} finally {
			log.info("insert movement of " + cntr_no + " at " + act_dt);
		}
		return iRet;
	}

	private String checkString(String strArg) {
		if (strArg == null) {
			return "";
		} else {
			return strArg.trim();
		}
	}

	/**
	 * 각 Container 에 대한 Movement 를 입력한다.<br>
	 * 
	 * @param et SPP_SCE_001Event
	 * @return EventResponse SPP_SCE_001EventResponse
	 * @throws DAOException
	 */
	public EventResponse createMovement(Event et) throws DAOException {

		SppSce0001Event event = (SppSce0001Event) et;
		SppSce0001EventResponse eventResponse = new SppSce0001EventResponse();

		int nCount = 0;

		// get main parameter
		String mov_tp = checkString(event.getMov_tp());
		String nod_cd = checkString(event.getNod_cd());
		String direction = checkString(event.getDirection());
		String moved_by = checkString(event.getMoved_by());
		String user_id = checkString(event.getUser_id());
		String office = checkString(event.getOffice());
		String vndr_seq = checkString(event.getVndr_seq());
		Movement[] mov = event.getMov();

		String act_cd = null;
		
		// get Movement Status
		int iMode = getActivityType(mov_tp);
		
		switch (iMode) {
		case 0:
			act_cd = getActivityTruckMovement(mov_tp);
			break;
		case 1:
			act_cd = getActivityYardTerminalLoaded(direction, moved_by, mov_tp);
			break;
		default:
			String msg = "Error: Invalid Movement Status = " + mov_tp;
			log.error(msg);
			throw new DAOException(msg);
		}

		try {

			for (int i = 0; i < mov.length; i++) {
				// check previous data
				if ("OK".equals(mov[i].getRmk().trim())) {
					continue;
				}

				// check mandantory data
				String cntr_no = checkString(mov[i].getCntr_no());
				String act_dt = checkString(mov[i].getAct_dt());
				String bkg_no_org = checkString(mov[i].getBkg_no());
				String bkg_no = "";
				String tmp = "";
				
				// check BkgNo
				bkg_no = bkg_no_org;
				if (bkg_no.length() == 12) { 
					tmp = getFullBkgNo(bkg_no_org);
					if(tmp != null && !tmp.equals("")) {
						bkg_no = tmp;
					} else {
						mov[i].setRmk("Error: Wrong B/L NO");
						continue;
					}
				}

				// check COP validation
				int iRet = getCOPCount(cntr_no, bkg_no, act_cd, iMode, mov_tp, direction);
				if (iRet < 1) {
					mov[i].setRmk(ERROR_01);
					continue;
				}

				// get NodCD
				//System.out.println("nod_cd:::::::::::::::::::" + nod_cd);
				//if (nod_cd == null || "".equals(nod_cd)) {
					nod_cd = getNodCd(cntr_no, bkg_no, act_cd, iMode, mov_tp, direction);
				//}

				// Duplicate validation
				String duplicate = getActDt(cntr_no, bkg_no, act_cd, iMode, mov_tp, direction);
				if (!(duplicate == null || "".equals(duplicate))) {
					mov[i].setRmk(ERROR_08);
					continue;
				}

				// insert Movement
				if (insertMovement(bkg_no, cntr_no, act_dt, act_cd, nod_cd, office, vndr_seq, user_id) < 0) {
					mov[i].setRmk(ERROR_04);
				} else {
					mov[i].setRmk("OK");
					nCount++;
				}
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} 

		// set EventResponse
		eventResponse.setSuccessFlag("SUCCESS");
		eventResponse.setSuccess_count(nCount);
		eventResponse.setFail_count(mov.length - nCount);
		eventResponse.setMov(mov);

		return eventResponse;
	}

	/**
	 * <br>
	 * 
	 * @param et
	 * @return
	 * @throws DAOException
	 */
	public Object[] selectCntrMvmt(Event et) throws DAOException {

		DBRowSet rs = null;
		Object[] result = new Object[2];

		try {
			
			SppSce0002Event event = (SppSce0002Event) et;
			String bkbl_no = event.getBkbl_no();
			String cntr_no = event.getCntr_no();
			
			if(event.getBkbl_no() == null || event.getBkbl_no().equals("")) {
				throw new Exception("Please enter Booking Number Or B/L Number");
		    		}
			if(event.getCntr_no() == null || event.getCntr_no().equals("")) {
				throw new Exception("Please enter Container Number");
		    		}

			//query parameter
    		Map<String, Object> param = new HashMap<String, Object>();
    		param.put("bkbl_no", bkbl_no);
    		param.put("cntr_no", cntr_no);
    		
    		//velocity parameter
    		Map<String, Object> velParam = new HashMap<String, Object>();
    		
    		SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
    		WebGateDBDAOSelectCntrMvmtRSQL template = new WebGateDBDAOSelectCntrMvmtRSQL();
    		
            rs = sqlExe.executeQuery(template,param,velParam);

			int rstIdx = 1;

			ArrayList<CntrMvmt> args = new ArrayList<CntrMvmt>();
			while (rs != null && rs.next()) {
				CntrMvmt mvmt = new CntrMvmt();
				mvmt.setSeq(String.valueOf(rstIdx++));
				mvmt.setCompany(rs.getString("company"));
				mvmt.setMvmt_sts(rs.getString("mvmt_sts"));
				mvmt.setYard(rs.getString("yard"));
				mvmt.setEvnt_dt(rs.getString("evnt_dt"));
				args.add(mvmt);
			}

			// 조회결과
			if (args.size() == 0) {
				result[0] = null;
			} else {
				result[0] = (CntrMvmt[]) args.toArray(new CntrMvmt[0]);
			}
			result[1] = new Integer(args.size());
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(UNHANDLED_EXPT_MSG);
		}

		return result;
	}
}