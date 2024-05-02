/*=========================================================
*Copyright(c) 2009 CyberLogitec 
*@FileName : ChassisReportDBDAO.java
*@FileTitle : ChassisReportDBDAO
*Open Issues :
*Change history : 2015-03-17 CHM-201534671, 신용찬, 1. COP_HDR 에서 MASTER='Y' 인 MST_BKG_NO 로 TRS 정보를 조회(TRS는 MASTER BKG 으로 W/O 생성)
                                                   2. FACTORY NAME 정보 추가
                                                   3. NTFY 조회 되던 내용 CNEE 로 수정
                                                   4. VVD 검색조건 추가, (EVENT DATE 는 OPTINAL)
*@LastModifyDate : 2014.04.16
*@LastModifier : 최덕우
*@LastVersion : 1.0
* 2014.04.16 최덕우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassisreport.chassisreportinventory.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.hanjin.apps.alps.ees.cgm.chassisreport.chassisreportinventory.basic.ChassisReportBCImpl;
import com.hanjin.apps.alps.ees.cgm.chassisreport.chassisreportinventory.vo.LandInvMonitoringVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * ALPS ChassisReportDBDAO <br>
 * - ALPS-ChassisMgsetAgreementInvoice system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Choi, Duk Woo
 * @see ChassisReportBCImpl 참조
 * @since J2EE 1.4  
 */
public class ChassisReportDBDAO extends DBDAOSupport {

	/**
	 * [EES_CGM_1157]<br>
	 * Land Inventory Monitoring의 Summary Tab 정보를 조회<br>
	 *
	 * @param LandInvMonitoringVO landInvMonitoringVO
	 * @return List<LandInvMonitoringVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<LandInvMonitoringVO> searchLandInvMonitoringSummary(LandInvMonitoringVO landInvMonitoringVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<LandInvMonitoringVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (landInvMonitoringVO != null) {
				Map<String, String> mapVO = landInvMonitoringVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//멀티로 넘어온 값 Location
				String locList = landInvMonitoringVO.getLocList();
				List<String> locListList = new ArrayList<String>();
				StringTokenizer st = new StringTokenizer(locList, ",");
				if(!("").equals(locList)) {
					while (st.hasMoreTokens()) {
						locListList.add(st.nextToken());
					}
					velParam.put("loc_list_list",  locListList);
				} else {
					velParam.put("loc_list_list",  "");
				}
				
				//멀티로 넘어온 값 TP/SZ
				String cntrTpszCd = landInvMonitoringVO.getCntrTpszCd();
				List<String> cntrTpszCdList = new ArrayList<String>();
				StringTokenizer st1 = new StringTokenizer(cntrTpszCd, ",");
				if(!("").equals(cntrTpszCd)) {
					while (st1.hasMoreTokens()) {
						cntrTpszCdList.add(st1.nextToken());
					}
					velParam.put("cntr_tpsz_cd_list",  cntrTpszCdList);
				} else {
					velParam.put("cntr_tpsz_cd_list",  "");
				}
				
				//멀티로 넘어온 값 BKG_NO
				String bkgNo = landInvMonitoringVO.getBkgNo();
				List<String> bkgNoList = new ArrayList<String>();
				StringTokenizer st2 = new StringTokenizer(bkgNo, ",");
				if(!("").equals(bkgNo)) {
					while (st2.hasMoreTokens()) {
						bkgNoList.add(st2.nextToken());
					}
					velParam.put("bkg_no_list",  bkgNoList);
				} else {
					velParam.put("bkg_no_list",  "");
				}
				
				//멀티로 넘어온 값 SC NO
				String scNo = landInvMonitoringVO.getScNo();
				List<String> scNoList = new ArrayList<String>();
				StringTokenizer st3 = new StringTokenizer(scNo, ",");
				if(!("").equals(scNo)) {
					while (st3.hasMoreTokens()) {
						scNoList.add(st3.nextToken());
					}
					velParam.put("sc_no_list",  scNoList);
				} else {
					velParam.put("sc_no_list",  "");
				}
				
				//멀티로 넘어온 값 CNTR NO
				String cntrNo = landInvMonitoringVO.getCntrNo();
				List<String> cntrNoList = new ArrayList<String>();
				StringTokenizer st4 = new StringTokenizer(cntrNo, ",");
				if(!("").equals(cntrNo)) {
					while (st4.hasMoreTokens()) {
						cntrNoList.add(st4.nextToken());
					}
					velParam.put("cntr_no_list",  cntrNoList);
				} else {
					velParam.put("cntr_no_list",  "");
				}			
				
				//멀티로 넘어온 값 VVD NO
				String vvdNo = landInvMonitoringVO.getVvdNo();
				List<String> vvdNoList = new ArrayList<String>();
				StringTokenizer st5 = new StringTokenizer(vvdNo, ",");
				String vvdNo_token = "";
				if(!("").equals(vvdNo)) {
					while (st5.hasMoreTokens()) {
						vvdNo_token = st5.nextToken();
						if(vvdNo_token.length() >= 9) vvdNoList.add(vvdNo_token);  // vvd 가 9자리 이상만 담습니다.(substr 오류방지)
					}
					velParam.put("vvd_no_list",  vvdNoList);
				} else {
					velParam.put("vvd_no_list",  "");
				}							
				
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisReportDBDAOSearchLandInvMonitoringSummaryRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, LandInvMonitoringVO .class);
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
	 * [EES_CGM_1157]<br>
	 * Land Inventory Monitoring의 Detail Tab 정보를 조회<br>
	 *
	 * @param LandInvMonitoringVO landInvMonitoringVO
	 * @return List<LandInvMonitoringVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<LandInvMonitoringVO> searchLandInvMonitoringDetail(LandInvMonitoringVO landInvMonitoringVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<LandInvMonitoringVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (landInvMonitoringVO != null) {
				Map<String, String> mapVO = landInvMonitoringVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//멀티로 넘어온 값 Location
				String locList = landInvMonitoringVO.getLocList();
				List<String> locListList = new ArrayList<String>();
				StringTokenizer st = new StringTokenizer(locList, ",");
				if(!("").equals(locList)) {
					while (st.hasMoreTokens()) {
						locListList.add(st.nextToken());
					}
					velParam.put("loc_list_list",  locListList);
				} else {
					velParam.put("loc_list_list",  "");
				}
				
				//멀티로 넘어온 값 TP/SZ
				String cntrTpszCd = landInvMonitoringVO.getCntrTpszCd();
				List<String> cntrTpszCdList = new ArrayList<String>();
				StringTokenizer st1 = new StringTokenizer(cntrTpszCd, ",");
				if(!("").equals(cntrTpszCd)) {
					while (st1.hasMoreTokens()) {
						cntrTpszCdList.add(st1.nextToken());
					}
					velParam.put("cntr_tpsz_cd_list",  cntrTpszCdList);
				} else {
					velParam.put("cntr_tpsz_cd_list",  "");
				}
				
				//멀티로 넘어온 값 BKG_NO
				String bkgNo = landInvMonitoringVO.getBkgNo();
				List<String> bkgNoList = new ArrayList<String>();
				StringTokenizer st2 = new StringTokenizer(bkgNo, ",");
				if(!("").equals(bkgNo)) {
					while (st2.hasMoreTokens()) {
						bkgNoList.add(st2.nextToken());
					}
					velParam.put("bkg_no_list",  bkgNoList);
				} else {
					velParam.put("bkg_no_list",  "");
				}
				
				//멀티로 넘어온 값 SC NO
				String scNo = landInvMonitoringVO.getScNo();
				List<String> scNoList = new ArrayList<String>();
				StringTokenizer st3 = new StringTokenizer(scNo, ",");
				if(!("").equals(scNo)) {
					while (st3.hasMoreTokens()) {
						scNoList.add(st3.nextToken());
					}
					velParam.put("sc_no_list",  scNoList);
				} else {
					velParam.put("sc_no_list",  "");
				}
				
				//멀티로 넘어온 값 CNTR NO
				String cntrNo = landInvMonitoringVO.getCntrNo();
				List<String> cntrNoList = new ArrayList<String>();
				StringTokenizer st4 = new StringTokenizer(cntrNo, ",");
				if(!("").equals(cntrNo)) {
					while (st4.hasMoreTokens()) {
						cntrNoList.add(st4.nextToken());
					}
					velParam.put("cntr_no_list",  cntrNoList);
				} else {
					velParam.put("cntr_no_list",  "");
				}	
				
				//멀티로 넘어온 값 VVD NO
				String vvdNo = landInvMonitoringVO.getVvdNo();
				List<String> vvdNoList = new ArrayList<String>();
				StringTokenizer st5 = new StringTokenizer(vvdNo, ",");
				String vvdNo_token = "";
				if(!("").equals(vvdNo)) {
					while (st5.hasMoreTokens()) {
						vvdNo_token = st5.nextToken();
						if(vvdNo_token.length() >= 9) vvdNoList.add(vvdNo_token);  // vvd 가 9자리 이상만 담습니다.(substr 오류방지)
					}
					velParam.put("vvd_no_list",  vvdNoList);
				} else {
					velParam.put("vvd_no_list",  "");
				}					
				
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisReportDBDAOSearchLandInvMonitoringRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, LandInvMonitoringVO .class);
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
	 * [EES_CGM_1157]<br>
	 * TP/SZ List의 정보를 조회<br>
	 *
	 * @return List<LandInvMonitoringVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<LandInvMonitoringVO> searchTpszList() throws DAOException {
		DBRowSet dbRowset = null;
		List<LandInvMonitoringVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{				
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisReportDBDAOSearchTpszListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, LandInvMonitoringVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 
}

