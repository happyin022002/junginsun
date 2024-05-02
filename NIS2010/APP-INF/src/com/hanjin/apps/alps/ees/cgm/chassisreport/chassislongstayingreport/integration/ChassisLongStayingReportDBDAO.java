/*=========================================================
*Copyright(c) 2009 CyberLogitec 
*@FileName : ChassisLongStayingReportDBDAO.java
*@FileTitle 	: Chassis Long Staying Report
*Open Issues 	: 
 *Change history :
 *@LastModifyDate : 2015.04.07
 *@LastModifier : 이율규
 *@LastVersion : 1.0
 * 2015.04.07 이율규
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassisreport.chassislongstayingreport.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import monfox.toolkit.snmp.agent.modules.SnmpV2Mib.SysOREntry;

import com.hanjin.apps.alps.ees.cgm.chassisreport.chassislongstayingreport.vo.ChassisLongStayingVO;
import com.hanjin.apps.alps.ees.cgm.chassisreport.chassisreportinventory.basic.ChassisReportBCImpl;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * ALPS ChassisLongStayingReportDBDAO <br>
 * <br>
 * 
 * @author Lee, YulKyu
 * @see ChassisReportBCImpl 참조
 * @since J2EE 1.4  
 */
@SuppressWarnings("serial")
public class ChassisLongStayingReportDBDAO extends DBDAOSupport {
	/**
	 * [EES_CGM_1158]<br>
	 * Chassis L/Staying List의 정보를 조회<br>
	 *
	 * @return List<ChassisLongStayingVO>
	 * @param ChassisLongStayingVO chassisLongStayingVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ChassisLongStayingVO> searchLongStayingChassisList(ChassisLongStayingVO chassisLongStayingVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ChassisLongStayingVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{				
			if (chassisLongStayingVO != null) {
				Map<String, String> mapVO= chassisLongStayingVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//멀티로 넘어온 값 Location
				String locList = chassisLongStayingVO.getLocList();
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
				String cntrTpszCd = chassisLongStayingVO.getCntrTpszCd();
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
				String bkgNo = chassisLongStayingVO.getBkgNo();
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
				String scNo = chassisLongStayingVO.getScNo();
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
				String cntrNo = chassisLongStayingVO.getCntrNo();
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
				String vvdNo = chassisLongStayingVO.getVvdNo();
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
				

				//멀티로 넘어온 값 MVMT_STS_CD
				String mvmtStatusCode = chassisLongStayingVO.getMvmtStsCd();
				List<String> mvmtStatusCodeList = new ArrayList<String>();
				StringTokenizer st6 = new StringTokenizer(mvmtStatusCode, ",");
				if(!("").equals(mvmtStatusCode)) {
					while (st6.hasMoreTokens()) {
						mvmtStatusCodeList.add(st6.nextToken());
					}
					velParam.put("mvmt_sts_cd_list",  mvmtStatusCodeList);
				} else {
					velParam.put("mvmt_sts_cd_list",  "");
				}
				
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisLongStayingReportDBDAOSearchChassisLongStayingRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ChassisLongStayingVO .class);
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

