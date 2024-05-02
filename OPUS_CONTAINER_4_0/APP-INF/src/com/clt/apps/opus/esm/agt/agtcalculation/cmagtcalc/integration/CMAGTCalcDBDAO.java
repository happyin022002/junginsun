/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : CMAGTCalcDBDAO.java
*@FileTitle : Calculation
*Open Issues :
*Change history :
*@LastModifyDate : 2007-01-11
*@LastModifier : SangJun Kwon
*@LastVersion : 1.0
2007-01-11 SangJun Kwon
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esm.agt.agtcalculation.cmagtcalc.integration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;

import com.clt.apps.opus.esm.agt.agtcalculation.cmagtcalc.basic.CMAGTCalcBCImpl;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.loggable.LoggableStateFactory;
import com.clt.framework.component.util.loggable.LoggableStatement;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.integration.DBDAOSupport;

/**
 * OPUS-AGT Batch에 대한 DB 처리를 담당<br>
 * - OPUS-AGT Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author SangJun Kwon
 * @see CMAGTCalcBCImpl 참조
 * @since J2EE 1.4
 */
public class CMAGTCalcDBDAO extends DBDAOSupport {

	/**
	 * COP MAIN을 찾아서 없으면 PRODUCT CTL에서 main 정보 가져오기<br>
	 * 
	 * @param receive_cd coa에서 넘겨준 코드
	 * @return HashMap DB 처리 결과
	 * @throws DAOException
	 */
	public HashMap searchPrdCtlInfoforComm(String receive_cd) throws DAOException {
		
		Connection con = null;					// Connection Interface  
        ResultSet rs01   = null;				// DB ResultSet
        ResultSet rs02   = null;				// DB ResultSet
        ResultSet rs03   = null;				// DB ResultSet
        ResultSet rs04   = null;				// DB ResultSet
        ResultSet rs05   = null;				// DB ResultSet
        PreparedStatement ps01  = null;			// SELECT를 수행하기 위한 SQL Statement
        PreparedStatement ps02  = null;			// SELECT를 수행하기 위한 SQL Statement
        PreparedStatement ps03  = null;			// SELECT를 수행하기 위한 SQL Statement
        PreparedStatement ps04  = null;			// SELECT를 수행하기 위한 SQL Statement
        PreparedStatement ps05  = null;			// SELECT를 수행하기 위한 SQL Statement
		int i = 1;								// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
		ResultSetMetaData mataData = null;
		
		StringBuffer selectQuery01 = new StringBuffer();
		StringBuffer selectQuery02 = new StringBuffer();
		StringBuffer selectQuery03 = new StringBuffer();
		StringBuffer selectQuery04 = new StringBuffer();
		StringBuffer selectQuery05 = new StringBuffer();
		selectQuery01.append("SELECT a.cop_no coa_no " + "\n");
		selectQuery01.append("     , NVL (a.bkg_no, ' ') bkg_no " + "\n");
//		selectQuery01.append("     , NVL (a.bkg_no_split, ' ') bkg_no_split " + "\n");
		selectQuery01.append("     , a.por_cd por_cd " + "\n");
		selectQuery01.append("     , b.cnt_cd por_cnt_cd " + "\n");
		selectQuery01.append("     , b.conti_cd por_conti_cd " + "\n");
		selectQuery01.append("     , DECODE (cc.ar_ofc_cd, 'GLWBA', cc.ar_ofc_cd, DECODE (f.ar_ofc_cd, 'BSLBA', f.ar_ofc_cd, bb.ar_ofc_cd)) por_ar_ofc_cd " + "\n");
		selectQuery01.append("     , a.pol_cd pol_cd " + "\n");
		selectQuery01.append("     , c.cnt_cd pol_cnt_cd " + "\n");
		selectQuery01.append("     , c.conti_cd pol_conti_cd " + "\n");
		selectQuery01.append("     , cc.ar_ofc_cd pol_ar_ofc_cd " + "\n");
		selectQuery01.append("     , a.pod_cd pod_cd " + "\n");
		selectQuery01.append("     , d.cnt_cd pod_cnt_cd " + "\n");
		selectQuery01.append("     , d.conti_cd pod_conti_cd " + "\n");
		selectQuery01.append("     , dd.ar_ofc_cd pod_ar_ofc_cd " + "\n");
		selectQuery01.append("     , a.del_cd del_cd " + "\n");
		selectQuery01.append("     , e.cnt_cd del_cnt_cd " + "\n");
		selectQuery01.append("     , e.conti_cd " + "\n");
		selectQuery01.append("     , DECODE (dd.ar_ofc_cd, 'GLWBA', dd.ar_ofc_cd, DECODE (a.clt_ofc_cd, 'BSLBA', l.ar_ofc_cd, ee.ar_ofc_cd)) del_ar_ofc_cd " + "\n");
		selectQuery01.append("     , NVL (a.n1st_ts_port_cd, ' ') n1st_ts_port_cd " + "\n");
		selectQuery01.append("     , NVL (h.cnt_cd, ' ') n1st_cnt_cd " + "\n");
		selectQuery01.append("     , NVL (h.conti_cd, ' ') n1st_conti_cd " + "\n");
		selectQuery01.append("     , NVL (hh.ar_ofc_cd, ' ') n1st_ar_ofc_cd " + "\n");
		selectQuery01.append("     , NVL (a.n2nd_ts_port_cd, ' ') n2nd_ts_port_cd " + "\n");
		selectQuery01.append("     , NVL (i.cnt_cd, ' ') n2nd_cnt_cd " + "\n");
		selectQuery01.append("     , NVL (i.conti_cd, ' ') n2nd_conti_cd " + "\n");
		selectQuery01.append("     , NVL (ii.ar_ofc_cd, ' ') n2nd_ar_ofc_cd " + "\n");
		selectQuery01.append("     , NVL (a.n3rd_ts_port_cd, ' ') n3rd_ts_port_cd " + "\n");
		selectQuery01.append("     , NVL (j.cnt_cd, ' ') n3rd_cnt_cd " + "\n");
		selectQuery01.append("     , NVL (j.conti_cd, ' ') n3rd_conti_cd " + "\n");
		selectQuery01.append("     , NVL (jj.ar_ofc_cd, ' ') n3rd_ar_ofc_cd " + "\n");
		selectQuery01.append("     , NVL (a.bkg_cgo_tp_cd, ' ') bkg_cgo_tp_cd " + "\n");
		selectQuery01.append("     , NVL (a.sls_ofc_cd, ' ') sls_ofc_cd " + "\n");
		selectQuery01.append("     , NVL (g.ar_ofc_cd, ' ') sls_ar_ofc_cd " + "\n");
		selectQuery01.append("     , NVL (g.loc_cd, ' ') sls_loc_cd " + "\n");
		selectQuery01.append("     , NVL (a.bkg_ofc_cd, ' ') bkg_ofc_cd " + "\n");
		selectQuery01.append("     , NVL (f.ar_ofc_cd, ' ') bkg_ar_ofc_cd " + "\n");
		selectQuery01.append("     , NVL (f.loc_cd, ' ') bkg_loc_cd " + "\n");
		selectQuery01.append("  FROM (SELECT a.cop_no " + "\n");
		selectQuery01.append("             , a.bkg_no " + "\n");
//		selectQuery01.append("             , a.bkg_no_split " + "\n");
		selectQuery01.append("             , D.por_cd " + "\n");
		selectQuery01.append("             , D.pol_cd " + "\n");
		selectQuery01.append("             , D.pod_cd " + "\n");
		selectQuery01.append("             , D.del_cd " + "\n");
		selectQuery01.append("             , D.n1st_ts_port_cd " + "\n");
		selectQuery01.append("             , D.n2nd_ts_port_cd " + "\n");
		selectQuery01.append("             , D.n3rd_ts_port_cd " + "\n");
		selectQuery01.append("             , b.bkg_cgo_tp_cd " + "\n");
		selectQuery01.append("             , b.OB_sls_ofc_cd sls_ofc_cd " + "\n");
		selectQuery01.append("             , b.bkg_ofc_cd bkg_ofc_cd " + "\n");
		selectQuery01.append("             , c.clt_ofc_cd clt_ofc_cd " + "\n");
		selectQuery01.append("          FROM sce_cop_hdr a, bkg_booking b, bkg_RATE c, PRD_PROD_CTL_MST D " + "\n");
		selectQuery01.append("         WHERE a.cop_no = ? " + "\n");
		selectQuery01.append("           AND a.bkg_no = b.bkg_no " + "\n");
		selectQuery01.append("           AND A.PCTL_NO = D.PCTL_NO " + "\n");
		selectQuery01.append("           AND a.bkg_no = c.bkg_no " + "\n");
//		selectQuery01.append("           AND a.bkg_no_split = c.bkg_no_split " + "\n");
		selectQuery01.append("           ) a " + "\n");
		selectQuery01.append("     , mdm_location b " + "\n");
		selectQuery01.append("     , mdm_location c " + "\n");
		selectQuery01.append("     , mdm_location d " + "\n");
		selectQuery01.append("     , mdm_location e " + "\n");
		selectQuery01.append("     , mdm_location h " + "\n");
		selectQuery01.append("     , mdm_location i " + "\n");
		selectQuery01.append("     , mdm_location j " + "\n");
		selectQuery01.append("     , mdm_organization bb " + "\n");
		selectQuery01.append("     , mdm_organization cc " + "\n");
		selectQuery01.append("     , mdm_organization dd " + "\n");
		selectQuery01.append("     , mdm_organization ee " + "\n");
		selectQuery01.append("     , mdm_organization hh " + "\n");
		selectQuery01.append("     , mdm_organization ii " + "\n");
		selectQuery01.append("     , mdm_organization jj " + "\n");
		selectQuery01.append("     , mdm_organization f " + "\n");
		selectQuery01.append("     , mdm_organization g " + "\n");
		selectQuery01.append("     , mdm_organization l " + "\n");
		selectQuery01.append(" WHERE a.cop_no = ? " + "\n");
		selectQuery01.append("   AND a.por_cd = b.loc_cd(+) " + "\n");
		selectQuery01.append("   AND a.pol_cd = c.loc_cd(+) " + "\n");
		selectQuery01.append("   AND a.pod_cd = d.loc_cd(+) " + "\n");
		selectQuery01.append("   AND a.del_cd = e.loc_cd(+) " + "\n");
		selectQuery01.append("   AND a.n1st_ts_port_cd = h.loc_cd(+) " + "\n");
		selectQuery01.append("   AND a.n2nd_ts_port_cd = i.loc_cd(+) " + "\n");
		selectQuery01.append("   AND a.n3rd_ts_port_cd = j.loc_cd(+) " + "\n");
		selectQuery01.append("   AND b.finc_ctrl_ofc_cd = bb.ofc_cd(+) " + "\n");
		selectQuery01.append("   AND NVL(bb.delt_flg, 'N') = 'N' " + "\n");
		selectQuery01.append("   AND c.finc_ctrl_ofc_cd = cc.ofc_cd(+) " + "\n");
		selectQuery01.append("   AND NVL(cc.delt_flg, 'N') = 'N' " + "\n");
		selectQuery01.append("   AND d.finc_ctrl_ofc_cd = dd.ofc_cd(+) " + "\n");
		selectQuery01.append("   AND NVL(dd.delt_flg, 'N') = 'N' " + "\n");
		selectQuery01.append("   AND e.finc_ctrl_ofc_cd = ee.ofc_cd(+) " + "\n");
		selectQuery01.append("   AND NVL(ee.delt_flg, 'N') = 'N' " + "\n");
		selectQuery01.append("   AND h.finc_ctrl_ofc_cd = hh.ofc_cd(+) " + "\n");
		selectQuery01.append("   AND NVL(hh.delt_flg, 'N') = 'N' " + "\n");
		selectQuery01.append("   AND i.finc_ctrl_ofc_cd = ii.ofc_cd(+) " + "\n");
		selectQuery01.append("   AND NVL(ii.delt_flg, 'N') = 'N' " + "\n");
		selectQuery01.append("   AND j.finc_ctrl_ofc_cd = jj.ofc_cd(+) " + "\n");
		selectQuery01.append("   AND NVL(jj.delt_flg, 'N') = 'N' " + "\n");
		selectQuery01.append("   AND a.bkg_ofc_cd = f.ofc_cd(+) " + "\n");
		selectQuery01.append("   AND NVL(f.delt_flg, 'N') = 'N' " + "\n");
		selectQuery01.append("   AND a.sls_ofc_cd = g.ofc_cd(+) " + "\n");
		selectQuery01.append("   AND NVL(g.delt_flg, 'N') = 'N' " + "\n");
		selectQuery01.append("   AND a.clt_ofc_cd = l.ofc_cd(+) " + "\n");
		selectQuery01.append("   AND NVL(l.delt_flg, 'N') = 'N' " + "\n");
		
		selectQuery02.append("SELECT a.pctl_no coa_no " + "\n");
		selectQuery02.append("     , ' ' bkg_no " + "\n");
		selectQuery02.append("     , a.por_cd por_cd " + "\n");
		selectQuery02.append("     , b.cnt_cd por_por_cd " + "\n");
		selectQuery02.append("     , b.conti_cd por_conti_cd " + "\n");
		selectQuery02.append("     , DECODE (cc.ar_ofc_cd, 'GLWBA', cc.ar_ofc_cd, bb.ar_ofc_cd) por_ar_ofc_cd " + "\n");
		selectQuery02.append("     , a.pol_cd pol_cd " + "\n");
		selectQuery02.append("     , c.cnt_cd pol_cnt_cd " + "\n");
		selectQuery02.append("     , c.conti_cd pol_conti_cd " + "\n");
		selectQuery02.append("     , cc.ar_ofc_cd pol_ar_ofc_cd " + "\n");
		selectQuery02.append("     , a.pod_cd pod_cd " + "\n");
		selectQuery02.append("     , d.cnt_cd pod_cnt_cd " + "\n");
		selectQuery02.append("     , d.conti_cd pod_conti_cd " + "\n");
		selectQuery02.append("     , dd.ar_ofc_cd pod_ar_ofc_cd " + "\n");
		selectQuery02.append("     , a.del_cd del_cd " + "\n");
		selectQuery02.append("     , e.cnt_cd del_cnt_cd " + "\n");
		selectQuery02.append("     , e.conti_cd del_conti_cd " + "\n");
		selectQuery02.append("     , DECODE (cc.ar_ofc_cd, 'GLWBA', dd.ar_ofc_cd, ee.ar_ofc_cd) del_ar_ofc_cd " + "\n");
		selectQuery02.append("     , NVL (a.n1st_ts_port_cd, ' ') n1st_ts_port_cd " + "\n");
		selectQuery02.append("     , NVL (h.cnt_cd, ' ') n1st_cnt_cd " + "\n");
		selectQuery02.append("     , NVL (h.conti_cd, ' ') n1st_conti_cd " + "\n");
		selectQuery02.append("     , NVL (hh.ar_ofc_cd, ' ') n1st_ar_ofc_cd " + "\n");
		selectQuery02.append("     , NVL (a.n2nd_ts_port_cd, ' ') n2nd_ts_port_cd " + "\n");
		selectQuery02.append("     , NVL (i.cnt_cd, ' ') n2nd_cnt_cd " + "\n");
		selectQuery02.append("     , NVL (i.conti_cd, ' ') n2nd_conti_cd " + "\n");
		selectQuery02.append("     , NVL (ii.ar_ofc_cd, ' ') n2nd_ar_ofc_cd " + "\n");
		selectQuery02.append("     , NVL (a.n3rd_ts_port_cd, ' ') n3rd_ts_port_cd " + "\n");
		selectQuery02.append("     , NVL (j.cnt_cd, ' ') n3rd_cnt_cd " + "\n");
		selectQuery02.append("     , NVL (j.conti_cd, ' ') n3rd_conti_cd " + "\n");
		selectQuery02.append("     , NVL (jj.ar_ofc_cd, ' ') n3rd_ar_ofc_cd " + "\n");
		selectQuery02.append("     , NVL (a.bkg_cgo_tp_cd, ' ') bkg_cgo_tp_cd " + "\n");
		selectQuery02.append("     , NVL (a.sls_ofc_cd, ' ') sls_ofc_cd " + "\n");
		selectQuery02.append("     , NVL (g.ar_ofc_cd, ' ') sls_ar_ofc_cd " + "\n");
		selectQuery02.append("     , NVL (g.loc_cd, ' ') sls_loc_cd " + "\n");
		selectQuery02.append("     , NVL (a.bkg_ofc_cd, ' ') bkg_ofc_cd " + "\n");
		selectQuery02.append("     , NVL (f.ar_ofc_cd, ' ') bkg_ar_ofc_cd " + "\n");
		selectQuery02.append("     , NVL (f.loc_cd, ' ') bkg_loc_cd " + "\n");
		selectQuery02.append("  FROM prd_prod_ctl_mst a " + "\n");
		selectQuery02.append("     , mdm_location b " + "\n");
		selectQuery02.append("     , mdm_location c " + "\n");
		selectQuery02.append("     , mdm_location d " + "\n");
		selectQuery02.append("     , mdm_location e " + "\n");
		selectQuery02.append("     , mdm_location h " + "\n");
		selectQuery02.append("     , mdm_location i " + "\n");
		selectQuery02.append("     , mdm_location j " + "\n");
		selectQuery02.append("     , mdm_organization bb " + "\n");
		selectQuery02.append("     , mdm_organization cc " + "\n");
		selectQuery02.append("     , mdm_organization dd " + "\n");
		selectQuery02.append("     , mdm_organization ee " + "\n");
		selectQuery02.append("     , mdm_organization hh " + "\n");
		selectQuery02.append("     , mdm_organization ii " + "\n");
		selectQuery02.append("     , mdm_organization jj " + "\n");
		selectQuery02.append("     , mdm_organization f " + "\n");
		selectQuery02.append("     , mdm_organization g " + "\n");
		selectQuery02.append(" WHERE a.pctl_no = ? " + "\n");
		selectQuery02.append("   AND a.por_cd = b.loc_cd(+) " + "\n");
		selectQuery02.append("   AND a.pol_cd = c.loc_cd(+) " + "\n");
		selectQuery02.append("   AND a.pod_cd = d.loc_cd(+) " + "\n");
		selectQuery02.append("   AND a.del_cd = e.loc_cd(+) " + "\n");
		selectQuery02.append("   AND a.n1st_ts_port_cd = h.loc_cd(+) " + "\n");
		selectQuery02.append("   AND a.n2nd_ts_port_cd = i.loc_cd(+) " + "\n");
		selectQuery02.append("   AND a.n3rd_ts_port_cd = j.loc_cd(+) " + "\n");
		selectQuery02.append("   AND b.finc_ctrl_ofc_cd = bb.ofc_cd(+) " + "\n");
		selectQuery02.append("   AND NVL(bb.delt_flg, 'N') = 'N' " + "\n");
		selectQuery02.append("   AND c.finc_ctrl_ofc_cd = cc.ofc_cd(+) " + "\n");
		selectQuery02.append("   AND NVL(cc.delt_flg, 'N') = 'N' " + "\n");
		selectQuery02.append("   AND d.finc_ctrl_ofc_cd = dd.ofc_cd(+) " + "\n");
		selectQuery02.append("   AND NVL(dd.delt_flg, 'N') = 'N' " + "\n");
		selectQuery02.append("   AND e.finc_ctrl_ofc_cd = ee.ofc_cd(+) " + "\n");
		selectQuery02.append("   AND NVL(ee.delt_flg, 'N') = 'N' " + "\n");
		selectQuery02.append("   AND h.finc_ctrl_ofc_cd = hh.ofc_cd(+) " + "\n");
		selectQuery02.append("   AND NVL(hh.delt_flg, 'N') = 'N' " + "\n");
		selectQuery02.append("   AND i.finc_ctrl_ofc_cd = ii.ofc_cd(+) " + "\n");
		selectQuery02.append("   AND NVL(ii.delt_flg, 'N') = 'N' " + "\n");
		selectQuery02.append("   AND j.finc_ctrl_ofc_cd = jj.ofc_cd(+) " + "\n");
		selectQuery02.append("   AND NVL(jj.delt_flg, 'N') = 'N' " + "\n");
		selectQuery02.append("   AND a.bkg_ofc_cd = f.ofc_cd(+) " + "\n");
		selectQuery02.append("   AND NVL(f.delt_flg, 'N') = 'N' " + "\n");
		selectQuery02.append("   AND a.sls_ofc_cd = g.ofc_cd(+) " + "\n");
		selectQuery02.append("   AND NVL(g.delt_flg, 'N') = 'N' " + "\n");

		
		selectQuery03.append("SELECT SUBSTR (NVL (NVL (NVL (n4th_finc_vvd_cd, n3rd_finc_vvd_cd), n2nd_finc_vvd_cd), NVL(n1st_finc_vvd_cd,' ')), 1, 4) finc_vvd_cd " + "\n");
		selectQuery03.append("  FROM coa_com_para " + "\n");
		selectQuery03.append(" WHERE pctl_no = ? " + "\n");
		
		selectQuery04.append("SELECT NVL(NVL(NVL(N4TH_RLANE_CD, N3RD_RLANE_CD), N2ND_RLANE_CD), NVL(N1ST_RLANE_CD, ' ')) rlane_cd " + "\n");
		selectQuery04.append("  FROM coa_com_para " + "\n");
		selectQuery04.append(" WHERE pctl_no = ? " + "\n");
		
		selectQuery05.append("SELECT SUBSTR (finc_ofc_cd, 1, 3) || chn_agn_cd bkg_ofc_cd " + "\n");
		selectQuery05.append("  FROM BKG_chn_agn " + "\n");
		selectQuery05.append(" WHERE chn_agn_cd = SUBSTR (?, 5, 2) " + "\n");
		HashMap cmMap = new HashMap();		//return용 HashMap 생성
		
		try {
			con = getConnection();
			int getRowCount = 0;			// SELECT 한 값이 있는지 유무
			// COP MAIN을 검색
			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
				ps01 = new LoggableStatement(con, selectQuery01.toString());
			} else {
				ps01 = con.prepareStatement(selectQuery01.toString());
			}			
            // 쿼리에 변수 세팅.
			i = 1;
			ps01.setString(i++, receive_cd);
			ps01.setString(i++, receive_cd);
			log.info("\n SQL1 : \n" + ((LoggableStatement)ps01).getQueryString());
			rs01 = ps01.executeQuery();            

			if(rs01.next()){
				getRowCount = 1;
				mataData = rs01.getMetaData();

				for(int j = 1; j <= mataData.getColumnCount(); j++) {
					cmMap.put(mataData.getColumnName(j), rs01.getString(mataData.getColumnName(j))); // 결과를 HashMap에 담는다.
				}
			}
			
			// COP MAIN 에서 없으면 PRODUCT CTL에서 main 정보 검색
			if(getRowCount == 0){
				if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
					ps02 = new LoggableStatement(con, selectQuery02.toString());
				} else {
					ps02 = con.prepareStatement(selectQuery02.toString());
				}
				//쿼리에 변수 세팅.
				i = 1;
				ps02.setString(i++, receive_cd);
				log.info("\n SQL1 : \n" + ((LoggableStatement)ps02).getQueryString());
				rs02 = ps02.executeQuery();                

	            if(rs02.next()){
					getRowCount = 1;
					mataData = rs02.getMetaData();

					for(int j = 1; j <= mataData.getColumnCount(); j++) {
						cmMap.put(mataData.getColumnName(j), rs02.getString(mataData.getColumnName(j))); // 결과를 HashMap에 담는다.
					}
				}
			}

			if(getRowCount == 1){
				// VSL 구하기
				if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
					ps03 = new LoggableStatement(con, selectQuery03.toString());
				} else {
					ps03 = con.prepareStatement(selectQuery03.toString());
				}
				//쿼리에 변수 세팅.
				i = 1;
				ps03.setString(i++, receive_cd);
				log.info("\n SQL1 : \n" + ((LoggableStatement)ps03).getQueryString());
				rs03 = ps03.executeQuery();
                
	            if(rs03.next()){
					getRowCount = 1;
					cmMap.put("FINC_VVD_CD", rs03.getString("finc_vvd_cd")); // 결과를 HashMap에 담는다.
					log.info("\n\nfinc_vvd_cd: "+rs03.getString("finc_vvd_cd")+"\n");
				}else{
					cmMap.put("FINC_VVD_CD", " ");
					log.info("\n\nfinc_vvd_cd: NULL\n");
				}
				
				
				// Lane 구하기
				if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
					ps04 = new LoggableStatement(con, selectQuery04.toString());
				} else {
					ps04 = con.prepareStatement(selectQuery04.toString());
				}
				//쿼리에 변수 세팅.
				i = 1;
				ps04.setString(i++, receive_cd);
                log.info("\n SQL1 : \n" + ((LoggableStatement)ps04).getQueryString());
				rs04 = ps04.executeQuery();

	            if(rs04.next()){
					getRowCount = 1;
					cmMap.put("RLANE_CD", rs04.getString("rlane_cd")); // 결과를 HashMap에 담는다.
				}else{
					cmMap.put("RLANE_CD", " ");
				}
	            
	            // Outbound 북중국 bkg ar office 구하여 바꾸기
	            String bKG_OFC_CD = (String)cmMap.get("BKG_OFC_CD");
	            String bKG_NO = cmMap.get("BKG_NO")==null?"":((String)cmMap.get("BKG_NO")).trim();
	            
	            if(bKG_OFC_CD.equals("DLCBB") || bKG_OFC_CD.equals("NKGBB") || bKG_OFC_CD.equals("SHABB") || bKG_OFC_CD.equals("TAOBB") || bKG_OFC_CD.equals("TSNBB")){
	            	if(!bKG_NO.equals("")){
	            		if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
							ps05 = new LoggableStatement(con, selectQuery05.toString());
						} else {
							ps05 = con.prepareStatement(selectQuery05.toString());
						}
						//쿼리에 변수 세팅.
						i = 1;
						ps05.setString(i++, bKG_NO);
		                log.info("\n SQL1 : \n" + ((LoggableStatement)ps05).getQueryString());
						rs05 = ps05.executeQuery();

			            if(rs05.next()){
							getRowCount = 1;
							cmMap.put("BKG_OFC_CD", rs05.getString("bkg_ofc_cd")); // 결과를 HashMap에 담는다.
						}
	            	}	            	
	            }
	            cmMap.put("CM_ERROR", "");
			}else{
				//COP MAIN과 PRODUCT CTL에서 main 정보가 없으면 에러처리!!
//				throw new DAOException((new ErrorHandler("AGT00031")).getMessage());
				cmMap.put("CM_ERROR", "PCTL_NO : "+ receive_cd +", ERROR : "+(new ErrorHandler("AGT00031")).getMessage());
//				this.createLog("PCTL_NO : "+ receive_cd +", ERROR : "+(new ErrorHandler("AGT00031")).getMessage());
			}
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
			closeResultSet(rs01);
			closeResultSet(rs02);
			closeResultSet(rs03);
			closeResultSet(rs04);
			closeResultSet(rs05);
			closeStatement(ps01);
			closeStatement(ps02);
			closeStatement(ps03);
			closeStatement(ps04);
			closeStatement(ps05);
			closeConnection(con);
		}
		
		return cmMap;
	}	
	
	/**
	 * BKG QTY물량 가져오기<br>
	 * 
	 * @param cmMap HashMap
	 * @return HashMap DB 처리 결과
	 * @throws DAOException
	 */
	public HashMap searchPrdCtlQTYInfo(HashMap cmMap) throws DAOException {
		
		Connection con = null;					// Connection Interface  
        ResultSet rs01   = null;				// DB ResultSet
        PreparedStatement ps01  = null;			// SELECT를 수행하기 위한 SQL Statement
     	int i = 1;								// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
     	DBRowSet dRs = null;
     	
		StringBuffer selectQuery01 = new StringBuffer();
		
		selectQuery01.append("SELECT cntr_tpsz_cd " + "\n");
		selectQuery01.append("  FROM coa_com_qty_para " + "\n");
		selectQuery01.append(" WHERE pctl_no = ? " + "\n");
		//HashMap cmMap = new HashMap();		//return용 HashMap 생성
		String receive_cd = (String)cmMap.get("COA_NO");
		
		try {
			con = getConnection();

			// COP MAIN을 검색
			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
				ps01 = new LoggableStatement(con, selectQuery01.toString());
			} else {
				ps01 = con.prepareStatement(selectQuery01.toString());
			}			
            // 쿼리에 변수 세팅.
			i = 1;
			ps01.setString(i++, receive_cd);
            log.info("\n SQL1 : \n" + ((LoggableStatement)ps01).getQueryString());
			rs01 = ps01.executeQuery();

            //결과를 DBRowset에 담는다.
            dRs = new DBRowSet();
            dRs.populate(rs01);
            int count = dRs.getRowCount();
            String[] cNTR_TPSZ_CD = new String[count];
            if(count > 0){
            	int j = 0;
            	while(dRs.next()){
            		cNTR_TPSZ_CD[j] = dRs.getString("cntr_tpsz_cd");
            		j++;
            	}
            	cmMap.put("CNTR_TPSZ_CD", cNTR_TPSZ_CD); 
            	log.info("CNTR_TPSZ_CD :"+cmMap.get("CNTR_TPSZ_CD"));
            }else{
				cmMap.put("CNTR_TPSZ_CD", " "); 	// 결과를 HashMap에 담는다.
				log.info("CNTR_TPSZ_CD :"+cmMap.get("CNTR_TPSZ_CD"));
			}
            
			log.info("count :"+count);
			if(count == 0){
				// BKG QTY물량 정보가 없으면 에러처리!!
//				throw new DAOException((new ErrorHandler("AGT00032")).getMessage());
				cmMap.put("CM_ERROR", "PCTL_NO : "+ receive_cd +", ERROR : "+(new ErrorHandler("AGT00032")).getMessage());
//				this.createLog("PCTL_NO : "+ receive_cd +", ERROR : "+(new ErrorHandler("AGT00032")).getMessage());
			}else{
				cmMap.put("CM_ERROR", "");
			}
			
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
			closeResultSet(rs01);
			closeStatement(ps01);
			closeConnection(con);
		}
		
		return cmMap;
	}
	
	/**
	 * 중국일 경우 <br>
	 * 
	 * @param cmMap HashMap
	 * @return HashMap DB 처리 결과
	 * @throws DAOException
	 */
	public HashMap searchPrdCtlAGTCHNAROFCInfo(HashMap cmMap) throws DAOException {
		
		Connection con = null;					// Connection Interface  
        ResultSet rs01   = null;				// DB ResultSet
        ResultSet rs02   = null;				// DB ResultSet
        ResultSet rs03   = null;				// DB ResultSet
        PreparedStatement ps01  = null;			// SELECT를 수행하기 위한 SQL Statement
        PreparedStatement ps02  = null;			// SELECT를 수행하기 위한 SQL Statement
        PreparedStatement ps03  = null;			// SELECT를 수행하기 위한 SQL Statement
     	int i = 1;								// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
		
		StringBuffer selectQuery01 = new StringBuffer();
		StringBuffer selectQuery02 = new StringBuffer();
		StringBuffer selectQuery03 = new StringBuffer();
		
		selectQuery01.append("SELECT b.agn_finc_ofc_cd agn_finc_ofc_cd" + "\n");
		selectQuery01.append("  FROM agt_chn_vsl_agn b " 				+ "\n");
		selectQuery01.append(" WHERE b.vsl_cd = ? "						+ "\n");
		
		selectQuery02.append("SELECT b.agn_finc_ofc_cd agn_finc_ofc_cd" + "\n");
		selectQuery02.append("  FROM agt_chn_lane_agn b " 				+ "\n");
		selectQuery02.append(" WHERE b.slan_cd = ? " 					+ "\n");
		selectQuery02.append("   AND b.pod_cd = ? " 					+ "\n");
		
		selectQuery03.append("SELECT b.agn_finc_ofc_cd agn_finc_ofc_cd" + "\n");
		selectQuery03.append("  FROM agt_chn_lane_agn b " 				+ "\n");
		selectQuery03.append(" WHERE b.slan_cd = 'ALL' " 				+ "\n");
		selectQuery03.append("   AND b.pod_cd = ? " 					+ "\n");		

		//HashMap cmMap = new HashMap();		//return용 HashMap 생성
		
		try {
			con = getConnection();
			int getRowCount = 0;			// SELECT 한 값이 있는지 유무
			String pod_cd = (String)cmMap.get("POD_CD");
			String finc_vvd_cd = (String)cmMap.get("FINC_VVD_CD");
			String rlane_cd = (String)cmMap.get("RLANE_CD");
			
			// SUBSTR(pod_cd, 0, 2) = 'CN' 이면 INBOUND Booking Commission의 AR Office를 찾아야함.
			if(pod_cd.substring(0,2).equals("CN")){
				if(!finc_vvd_cd.equals(" ")){
					if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
						ps01 = new LoggableStatement(con, selectQuery01.toString());
					} else {
						ps01 = con.prepareStatement(selectQuery01.toString());
					}			
		            // 쿼리에 변수 세팅.
					i = 1;
					ps01.setString(i++, finc_vvd_cd);
	                log.info("\n SQL1 : \n" + ((LoggableStatement)ps01).getQueryString());
					rs01 = ps01.executeQuery();

					if(rs01.next()){
						getRowCount = 1;
						cmMap.put("DEL_AR_OFC_CD", rs01.getString("agn_finc_ofc_cd")); 	// 결과를 HashMap에 담는다.
					}
					
					if(getRowCount == 0){
						if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
							ps02 = new LoggableStatement(con, selectQuery02.toString());
						} else {
							ps02 = con.prepareStatement(selectQuery02.toString());
						}			
			            // 쿼리에 변수 세팅.
						i = 1;
						ps02.setString(i++, rlane_cd);
						ps02.setString(i++, pod_cd);
		                log.info("\n SQL1 : \n" + ((LoggableStatement)ps02).getQueryString());
						rs02 = ps02.executeQuery();

						if(rs02.next()){
							getRowCount = 1;
							cmMap.put("DEL_AR_OFC_CD", rs02.getString("agn_finc_ofc_cd")); 	// 결과를 HashMap에 담는다.
							log.info("2:DEL_AR_OFC_CD :"+cmMap.get("DEL_AR_OFC_CD"));
						}
					}
					
					if(getRowCount == 0){
						if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
							ps03 = new LoggableStatement(con, selectQuery03.toString());
						} else {
							ps03 = con.prepareStatement(selectQuery03.toString());
						}			
			            // 쿼리에 변수 세팅.
						i = 1;
						ps03.setString(i++, pod_cd);
		                log.info("\n SQL1 : \n" + ((LoggableStatement)ps03).getQueryString());
						rs03 = ps03.executeQuery();

						if(rs03.next()){
							getRowCount = 1;
							cmMap.put("DEL_AR_OFC_CD", rs03.getString("agn_finc_ofc_cd")); 	// 결과를 HashMap에 담는다.
							log.info("3:DEL_AR_OFC_CD :"+cmMap.get("DEL_AR_OFC_CD"));
						}
					}					
				}					
			}
								
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
			closeResultSet(rs01);
			closeResultSet(rs02);
			closeResultSet(rs03);
			closeStatement(ps01);
			closeStatement(ps02);
			closeStatement(ps03);
			closeConnection(con);
		}
		
		return cmMap;
	}
	
	/**
	 * Out, In 경우 <br>
	 * 
	 * @param cmMap HashMap
	 * @return HashMap DB 처리 결과
	 * @throws DAOException
	 */
	public int searchAccountCostbyOffice(HashMap cmMap) throws DAOException {
		int returnInt = 0;
		Connection con = null;					// Connection Interface  
        //Out
		double og_512621 = 0;					//(G)Common 512621    : BKG_OFC 없으면 AR_OFC 로 두번 조회
        double ok_512641 = 0;					//(K)Brokerage 512641 : BKG_OFC 없으면 AR_OFC 로 두번 조회
        double oh_512661 = 0;					//(H)CHF 512661       : POR_OFC AR_OFC
        double os_512631 = 0;					//(S)T/S 512631       : N1ST_TS_PORT_CD, N2ST_TS_PORT_CD, N3ST_TS_PORT_CD의 AR_OFC
        double or_512631 = 0;					//(R)T/R 512631       : POL_OFC (POR_AR_OFC != POL_AR_OFC) //POL의 AR_OFFICE 에 커미션 준다.
        //In
        double ig_512611 = 0;					//(G)Common 512611    : DEL_OFC AR_OFC
        double ih_512661 = 0;					//(H)CHF 512661       : DEL_OFC AR_OFC
        double ir_512631 = 0;					//(R)T/R 512631       : POD_OFC (POD_AR_OFC != DEL_AR_OFC) //POD의 AR_OFFICE 에 커미션 준다.
        //Out
        double ob_512641 = 0;					//(B) 512641 미주 BROKERAGE : POR_CNT = US or CA POL_OFC_AR_OFC
        double of_512641 = 0;					//(F)FAC 512641 : POR_CONTI = 'E' 인 경우이고 sls_ofc_cd 의 ar_ofc_cdf 를 가져간다.
		
        String coa_no			= cmMap.get("COA_NO")==null?"":((String)cmMap.get("COA_NO")).trim();
        String bkg_ofc_cd 		= cmMap.get("BKG_OFC_CD")==null?"":((String)cmMap.get("BKG_OFC_CD")).trim();
		String bkg_ar_ofc_cd 	= cmMap.get("BKG_AR_OFC_CD")==null?"":((String)cmMap.get("BKG_AR_OFC_CD")).trim();
		String por_ar_ofc_cd	= cmMap.get("POR_AR_OFC_CD")==null?"":((String)cmMap.get("POR_AR_OFC_CD")).trim();
		String n1st_ar_ofc_cd	= cmMap.get("N1ST_AR_OFC_CD")==null?"":((String)cmMap.get("N1ST_AR_OFC_CD")).trim();
		String n2st_ar_ofc_cd	= cmMap.get("N2ST_AR_OFC_CD")==null?"":((String)cmMap.get("N2ST_AR_OFC_CD")).trim();
		String n3st_ar_ofc_cd	= cmMap.get("N3ST_AR_OFC_CD")==null?"":(String)cmMap.get("N3ST_AR_OFC_CD");

		String pol_ar_ofc_cd 	= cmMap.get("POL_AR_OFC_CD")==null?"":((String)cmMap.get("POL_AR_OFC_CD")).trim();
		String del_ar_ofc_cd	= cmMap.get("DEL_AR_OFC_CD")==null?"":((String)cmMap.get("DEL_AR_OFC_CD")).trim();
		String pod_ar_ofc_cd 	= cmMap.get("POD_AR_OFC_CD")==null?"":((String)cmMap.get("POD_AR_OFC_CD")).trim();
		
		String por_cd			= cmMap.get("POR_CD")==null?"":((String)cmMap.get("POR_CD")).trim();
		String del_cd			= cmMap.get("DEL_CD")==null?"":((String)cmMap.get("DEL_CD")).trim();
		String[] cntr_tpsz_cd 	= (String[])cmMap.get("CNTR_TPSZ_CD");
		
		String por_cnt_cd 		= cmMap.get("POR_CNT_CD")==null?"":((String)cmMap.get("POR_CNT_CD")).trim();
		String por_conti_cd 	= cmMap.get("POR_CONTI_CD")==null?"":((String)cmMap.get("POR_CONTI_CD")).trim();
		String sls_ar_ofc_cd	= cmMap.get("SLS_AR_OFC_CD")==null?"":((String)cmMap.get("SLS_AR_OFC_CD")).trim();
		
		// COA_COM_COST_PARA 테이블에 Update 값
		double sum_512621		= 0;
		double sum_512641		= 0;
		double sum_512661		= 0;
		double sum_512631		= 0;
		double sum_512611		= 0;		

		try {
			con = getConnection();
			int count = cntr_tpsz_cd.length;
			
			int updateCnt = 0;
			if(count > 0){
				// TPSZ 별로 루프를 돌면서 Update 처리
				for(int i=0; i<count; i++){
					//Out
					//1. (G)Common 512621    : BKG_OFC 없으면 AR_OFC 로 두번 조회
					if(!bkg_ofc_cd.equals("")){
						og_512621 = this.calcPrdCtlCostInfo(con,bkg_ofc_cd,"O","G",por_cd,del_cd,cntr_tpsz_cd[i]);
						if(!(og_512621 != 0)){
							if(!bkg_ar_ofc_cd.equals("")){
								og_512621 = this.calcPrdCtlCostInfo(con,bkg_ar_ofc_cd,"O","G",por_cd,del_cd,cntr_tpsz_cd[i]);
							}					
						}
					}						
					
					//2. (K)Brokerage 512641 : BKG_OFC 없으면 AR_OFC 로 두번 조회
					if(!bkg_ofc_cd.equals("")){
						ok_512641 = this.calcPrdCtlCostInfo(con,bkg_ofc_cd,"O","K",por_cd,del_cd,cntr_tpsz_cd[i]);
						if(!bkg_ar_ofc_cd.equals("")){
							if(!(ok_512641 != 0)){
								ok_512641 = this.calcPrdCtlCostInfo(con,bkg_ar_ofc_cd,"O","K",por_cd,del_cd,cntr_tpsz_cd[i]);
							}
						}				
					}						
					
					//3. (H)CHF 512661       : POR_OFC AR_OFC
					if(!por_ar_ofc_cd.equals("")){
						oh_512661 = this.calcPrdCtlCostInfo(con,por_ar_ofc_cd,"O","H",por_cd,del_cd,cntr_tpsz_cd[i]);
					}
					
								
					//4. (S)T/S 512631       : N1ST_TS_PORT_CD, N2ST_TS_PORT_CD, N3ST_TS_PORT_CD의 AR_OFC
					if(!n1st_ar_ofc_cd.equals("")){
						os_512631 = this.calcPrdCtlCostInfo(con,n1st_ar_ofc_cd,"O","S",por_cd,del_cd,cntr_tpsz_cd[i]);
					}			
					if(!n2st_ar_ofc_cd.equals("")){
						os_512631 = os_512631 + this.calcPrdCtlCostInfo(con,n2st_ar_ofc_cd,"O","S",por_cd,del_cd,cntr_tpsz_cd[i]);
					}
					if(!n3st_ar_ofc_cd.equals("")){
						os_512631 = os_512631 + this.calcPrdCtlCostInfo(con,n3st_ar_ofc_cd,"O","S",por_cd,del_cd,cntr_tpsz_cd[i]);
					}
					
					//5. (R)T/R 512631       : POL_OFC (POR_AR_OFC != POL_AR_OFC) //POL의 AR_OFFICE 에 커미션 준다.
					if(!por_ar_ofc_cd.equals(pol_ar_ofc_cd)){
						if(!pol_ar_ofc_cd.equals("")){
							or_512631 = this.calcPrdCtlCostInfo(con,pol_ar_ofc_cd,"O","R",por_cd,del_cd,cntr_tpsz_cd[i]);
						}				
					}			
					
					//In
					//6. (G)Common 512611    : DEL_OFC AR_OFC
					if(!del_ar_ofc_cd.equals("")){
						ig_512611 = this.calcPrdCtlCostInfo(con,del_ar_ofc_cd,"I","G",por_cd,del_cd,cntr_tpsz_cd[i]);
					}
											
					//7. (H)CHF 512661       : DEL_OFC AR_OFC
					if(!del_ar_ofc_cd.equals("")){
						ih_512661 = this.calcPrdCtlCostInfo(con,del_ar_ofc_cd,"I","H",por_cd,del_cd,cntr_tpsz_cd[i]);
					}			
								
					//8. (R)T/R 512631       : POD_OFC (POD_AR_OFC != DEL_AR_OFC) //POD의 AR_OFFICE 에 커미션 준다.
					if(!por_ar_ofc_cd.equals(del_ar_ofc_cd)){
						if(!pod_ar_ofc_cd.equals("")){
							ir_512631 = this.calcPrdCtlCostInfo(con,pod_ar_ofc_cd,"I","R",por_cd,del_cd,cntr_tpsz_cd[i]);
						}				
					}			
					
					//Out
					//9. (B) 512641 미주 BROKERAGE : POR_CNT = US or CA POL_AR_OFC
					if(!por_cnt_cd.equals("")){
						if(por_cnt_cd.equals("US") || por_cnt_cd.equals("CA")){
							if(!pol_ar_ofc_cd.equals("")){
								ob_512641 = this.calcPrdCtlCostInfo(con,pol_ar_ofc_cd,"O","B",por_cd,del_cd,cntr_tpsz_cd[i]);
							}				
						}
					}						
					
					//10.(F)FAC 512641 : POR_CONTI = 'E' 인 경우이고 sls_ofc_cd 의 ar_ofc_cdf 를 가져간다.
					if(!por_conti_cd.equals("")){
						if(por_conti_cd.equals("E")){
							if(!sls_ar_ofc_cd.equals("")){
								of_512641 = this.calcPrdCtlCostInfo(con,sls_ar_ofc_cd,"O","F",por_cd,del_cd,cntr_tpsz_cd[i]);
							}				
						}
					}
								
					
					log.info("(G)Common OG_512621 : "+ og_512621);
					log.info("(K)Brokerage OK_512641 : "+ ok_512641);
					log.info("(H)CHF OH_512661 : "+ oh_512661);
					log.info("(S)T/S OS_512631 : "+ os_512631);
					log.info("(R)T/R OR_512631 : "+ or_512631);
					log.info("(G)Common IG_512611 : "+ ig_512611);
					log.info("(H)CHF IH_512661 : "+ ih_512661);
					log.info("(R)T/R IR_512631 : "+ ir_512631);
					log.info("(B) 512641 미주 BROKERAGE OB_512641 : "+ ob_512641);
					log.info("(F)FAC OF_512641 : "+ of_512641);
					
					// COA_COM_COST_PARA update 처리
					sum_512621 = og_512621;
					sum_512641 = ok_512641 + ob_512641 + of_512641;
					sum_512661 = oh_512661 + ih_512661;
					sum_512631 = os_512631 + or_512631 + ir_512631;
					sum_512611 = ig_512611;
					
					log.info("sum_512621 : "+ sum_512621);
					log.info("sum_512641(OK_512641 + OB_512641 + OF_512641) : "+ sum_512641);
					log.info("sum_512661(OH_512661 + IH_512661) : "+ sum_512661);
					log.info("sum_512631(OS_512631 + OR_512631 + IR_512631) : "+ sum_512631);
					log.info("sum_512611 : "+ sum_512611);
										
					updateCnt = this.modifyPrdCtlCostInfo(con, sum_512621, coa_no, cntr_tpsz_cd[i], "512621");
					updateCnt = this.modifyPrdCtlCostInfo(con, sum_512641, coa_no, cntr_tpsz_cd[i], "512641");
					updateCnt = this.modifyPrdCtlCostInfo(con, sum_512661, coa_no, cntr_tpsz_cd[i], "512661");
					updateCnt = this.modifyPrdCtlCostInfo(con, sum_512631, coa_no, cntr_tpsz_cd[i], "512631");
					updateCnt = this.modifyPrdCtlCostInfo(con, sum_512611, coa_no, cntr_tpsz_cd[i], "512611");
				}
				
			}
			
			if(updateCnt > 0){
				returnInt = 0;
			}else{
				returnInt = -1;
			}
			log.info("returnInt = " + returnInt);
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} finally {
			closeConnection(con);
		}
		
		return returnInt;
	}
	
	/**
	 *  Out, In 일 경우 계산 <br>
	 * 
	 * @param con Connection
	 * @param agn_cd String
	 * @param io_bnd_cd String
	 * @param ac_tp_cd String
	 * @param bkg_por_cd String
	 * @param bkg_del_cd String
	 * @param tpsz String
	 * @return double DB 처리 결과
	 * @throws DAOException
	 */
	public double calcPrdCtlCostInfo(Connection con, String agn_cd, String io_bnd_cd, String ac_tp_cd, String bkg_por_cd, String bkg_del_cd, String tpsz) throws DAOException {
		
		ResultSet rs     = null;				// DB ResultSet
		ResultSet rs01   = null;				// DB ResultSet
        ResultSet rs02   = null;				// DB ResultSet
        ResultSet rs03   = null;				// DB ResultSet
        PreparedStatement ps    = null;			// SELECT를 수행하기 위한 SQL Statement
        PreparedStatement ps01  = null;			// SELECT를 수행하기 위한 SQL Statement
        PreparedStatement ps02  = null;			// SELECT를 수행하기 위한 SQL Statement
        PreparedStatement ps03  = null;			// SELECT를 수행하기 위한 SQL Statement
     	int i = 1;								// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
     	int count = 0;							// OFC_CD 가 대리점인지 유무
     	double returnAmt = 0;					// return 값
		
     	StringBuffer selectQuery   = new StringBuffer();
		StringBuffer selectQuery01 = new StringBuffer();
		StringBuffer selectQuery02 = new StringBuffer();
		StringBuffer selectQuery03 = new StringBuffer();
		
		selectQuery.append("SELECT count(*) cnt " + "\n");
		selectQuery.append("  FROM agt_finc_ofc_info " + "\n");
		selectQuery.append(" WHERE ar_ofc_cd = ? " + "\n");
		selectQuery.append("   AND NVL (delt_flg, 'N') = 'N' " + "\n");
		
		selectQuery01.append("SELECT comm_ut_amt " + "\n");
		selectQuery01.append("  FROM agt_otr_ut_cost " + "\n");
		selectQuery01.append(" WHERE comm_yrmon = TO_CHAR (SYSDATE, 'YYYYMM') " + "\n");
//		selectQuery01.append(" WHERE comm_yrmon IN ( " + "\n");
//		selectQuery01.append("          SELECT DISTINCT MAX (comm_yrmon) " + "\n");
//		selectQuery01.append("            FROM agt_otr_ut_cost " + "\n");
//		selectQuery01.append("           WHERE comm_yrmon = TO_CHAR (SYSDATE, 'YYYYMM')  " + "\n");
//		selectQuery01.append("           AND ofc_cd = ? " + "\n");
//		selectQuery01.append("           AND io_bnd_cd = ? " + "\n");
//		selectQuery01.append("           AND ac_tp_cd = ? " + "\n");
//		selectQuery01.append("           AND bkg_por_cd = ? " + "\n");
//		selectQuery01.append("           AND bkg_del_cd = ? " + "\n");
//		selectQuery01.append("           AND cntr_tpsz_cd = ? ) " + "\n");
		selectQuery01.append("  AND ofc_cd = ? " + "\n");
		selectQuery01.append("  AND io_bnd_cd = ? " + "\n");
		selectQuery01.append("  AND ac_tp_cd = ? " + "\n");
		selectQuery01.append("  AND bkg_por_cd = ? " + "\n");
		selectQuery01.append("  AND bkg_del_cd = ? " + "\n");
		selectQuery01.append("  AND cntr_tpsz_cd = ? " + "\n");
		
		selectQuery02.append("SELECT AVG (a.comm_ut_amt) comm_ut_amt " + "\n");
		selectQuery02.append("  FROM agt_otr_ut_cost a, coa_location_v b, coa_location_v c " + "\n");
		selectQuery02.append(" WHERE a.comm_yrmon = TO_CHAR (SYSDATE, 'YYYYMM') " + "\n");
//		selectQuery02.append(" WHERE a.comm_yrmon IN ( " + "\n");
//		selectQuery02.append("          SELECT MAX (comm_yrmon) " + "\n");
//		selectQuery02.append("            FROM agt_otr_ut_cost " + "\n");
//		selectQuery02.append("           WHERE comm_yrmon = TO_CHAR (SYSDATE, 'YYYYMM') " + "\n");
//		selectQuery02.append("             AND ofc_cd = ? " + "\n");
//		selectQuery02.append("             AND io_bnd_cd = ? " + "\n");
//		selectQuery02.append("             AND ac_tp_cd = ? " + "\n");
//		selectQuery02.append("             AND cntr_tpsz_cd = ? " + "\n");
//		selectQuery02.append("             ) " + "\n");
		selectQuery02.append("   AND a.ofc_cd       = ? " + "\n");
		selectQuery02.append("   AND a.io_bnd_cd    = ? " + "\n");
		selectQuery02.append("   AND a.ac_tp_cd     = ? " + "\n");
		selectQuery02.append("   AND a.cntr_tpsz_cd = ? " + "\n");
		selectQuery02.append("   AND a.bkg_por_cd = b.ecc_cd " + "\n");
		selectQuery02.append("   AND a.bkg_del_cd = c.ecc_cd " + "\n");
		
		selectQuery03.append("SELECT AVG (a.comm_ut_amt) comm_ut_amt " + "\n");
		selectQuery03.append("  FROM agt_otr_ut_cost a, coa_location_v b, coa_location_v c " + "\n");
		selectQuery03.append(" WHERE a.comm_yrmon IN ( " + "\n");
		selectQuery03.append("          SELECT MAX (comm_yrmon) " + "\n");
		selectQuery03.append("            FROM agt_otr_ut_cost " + "\n");
		selectQuery03.append("           WHERE comm_yrmon BETWEEN TO_CHAR (ADD_MONTHS (SYSDATE, -2), 'YYYYMM') " + "\n");
		selectQuery03.append("            AND TO_CHAR (SYSDATE, 'YYYYMM') " + "\n");
		selectQuery03.append("             AND ofc_cd    = ? " + "\n");
		selectQuery03.append("             AND io_bnd_cd = ? " + "\n");
		selectQuery03.append("             AND ac_tp_cd  = ? " + "\n");
		selectQuery03.append("             AND cntr_tpsz_cd = ? " + "\n");
		selectQuery03.append("             ) " + "\n");
		selectQuery03.append("   AND a.ofc_cd    = ?    " + "\n");
		selectQuery03.append("   AND a.io_bnd_cd = ? " + "\n");
		selectQuery03.append("   AND a.ac_tp_cd  = ? " + "\n");
		selectQuery03.append("   AND a.cntr_tpsz_cd = ? " + "\n");
		selectQuery03.append("   AND a.bkg_por_cd = b.ecc_cd " + "\n");
		selectQuery03.append("   AND a.bkg_del_cd = c.ecc_cd " + "\n");		
		
		try {
			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
				ps = new LoggableStatement(con, selectQuery.toString());
			} else {
				ps = con.prepareStatement(selectQuery.toString());
			}			
            // 쿼리에 변수 세팅.
			i = 1;
			ps.setString(i++, agn_cd);
			log.info("\n SQL1 : \n" + ((LoggableStatement)ps).getQueryString());
			rs = ps.executeQuery();
            
			if(rs.next()){
				count = rs.getInt("cnt");				
			}
						
			if(count > 0){
				if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
					ps01 = new LoggableStatement(con, selectQuery01.toString());
				} else {
					ps01 = con.prepareStatement(selectQuery01.toString());
				}			
	            // 쿼리에 변수 세팅.
				i = 1;
//				ps01.setString(i++, agn_cd);
//				ps01.setString(i++, io_bnd_cd);
//				ps01.setString(i++, ac_tp_cd);
//				ps01.setString(i++, bkg_por_cd);
//				ps01.setString(i++, bkg_del_cd);
//				ps01.setString(i++, tpsz);
				ps01.setString(i++, agn_cd);
				ps01.setString(i++, io_bnd_cd);
				ps01.setString(i++, ac_tp_cd);
				ps01.setString(i++, bkg_por_cd);
				ps01.setString(i++, bkg_del_cd);
				ps01.setString(i++, tpsz);
                log.info("\n SQL1 : \n" + ((LoggableStatement)ps01).getQueryString());
				rs01 = ps01.executeQuery();

				if(rs01.next()){
					returnAmt = rs01.getDouble("comm_ut_amt");
				}
				
				if(!(returnAmt != 0)){
					if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
						ps02 = new LoggableStatement(con, selectQuery02.toString());
					} else {
						ps02 = con.prepareStatement(selectQuery02.toString());
					}			
		            // 쿼리에 변수 세팅.
					i = 1;
//					ps02.setString(i++, agn_cd);
//					ps02.setString(i++, io_bnd_cd);
//					ps02.setString(i++, ac_tp_cd);
//					ps02.setString(i++, tpsz);
					ps02.setString(i++, agn_cd);
					ps02.setString(i++, io_bnd_cd);
					ps02.setString(i++, ac_tp_cd);
					ps02.setString(i++, tpsz);
	                log.info("\n SQL1 : \n" + ((LoggableStatement)ps02).getQueryString());
					rs02 = ps02.executeQuery();

		            if(rs02.next()){
						returnAmt = rs02.getDouble("comm_ut_amt");
					}
				}
				
				if(!(returnAmt != 0)){
					if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
						ps03 = new LoggableStatement(con, selectQuery03.toString());
					} else {
						ps03 = con.prepareStatement(selectQuery03.toString());
					}			
		            // 쿼리에 변수 세팅.
					i = 1;
					ps03.setString(i++, agn_cd);
					ps03.setString(i++, io_bnd_cd);
					ps03.setString(i++, ac_tp_cd);
					ps03.setString(i++, tpsz);
					ps03.setString(i++, agn_cd);
					ps03.setString(i++, io_bnd_cd);
					ps03.setString(i++, ac_tp_cd);
					ps03.setString(i++, tpsz);
	                log.info("\n SQL1 : \n" + ((LoggableStatement)ps03).getQueryString());
					rs03 = ps03.executeQuery();

		            if(rs03.next()){
						returnAmt = rs03.getDouble("comm_ut_amt");
					}
				}
			}
			
			// 2008.08.20 권상준 추가 agn_cd 가 xxxBB 일때 평균단가 금액 0 으로 리턴
			log.info("Agn_cd : "+agn_cd);
			log.info("Substring Agn_cd : "+agn_cd.substring(3,5));
			if(agn_cd.substring(3,5).equals("BB")){
				returnAmt = 0;
			}
								
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} finally {
			closeResultSet(rs);
			closeResultSet(rs01);
			closeResultSet(rs02);
			closeResultSet(rs03);
			closeStatement(ps);
			closeStatement(ps01);
			closeStatement(ps02);
			closeStatement(ps03);
		}
		
		return returnAmt;
	}
	
	/**
     * COA_COM_COST_PARA 테이블에 Update 한다.<br>
     * 
     * @param  con Connection
     * @param  unit_cost double
     * @param  coa_no String
     * @param  tpsz String
     * @param  coa_cost_src_cd String
     * @return int
     * @throws DAOException
     */
    public int modifyPrdCtlCostInfo(Connection con, double unit_cost, String coa_no, String tpsz, String coa_cost_src_cd) throws DAOException {
    	int i = 1;							// PreparedStatement에 bind 변수를 넣을시 증가되는 변수

        int returnYn = 0;
                
        PreparedStatement updatePs  = null;	// UPDATE를 수행하기 위한 SQL Statement
        StringBuffer updateQuery = new StringBuffer();			// update
        
        updateQuery.append("UPDATE coa_com_cost_para " + "\n");
        updateQuery.append("   SET estm_uc_amt = decode(estm_uc_amt, 0, ?, estm_uc_amt) " + "\n");
        updateQuery.append("     , respb_uc_amt = decode(respb_uc_amt, 0, ?, respb_uc_amt) " + "\n");
        updateQuery.append("     , cost_ut_amt_cd = 'BOX' " + "\n");
        updateQuery.append("     , cost_src_sys_cd = 'AGT' " + "\n");
        updateQuery.append("     , cost_ass_bse_cd = decode(estm_uc_amt, 0, 'A', cost_ass_bse_cd) " + "\n");
        updateQuery.append(" WHERE pctl_no = ? " + "\n");
        updateQuery.append("   AND cntr_tpsz_cd = ? " + "\n");
        updateQuery.append("   AND coa_cost_src_cd = ? " + "\n");
        updateQuery.append("   AND stnd_cost_cd = '51401011' " + "\n");
       
        try {
            // Loggable Statement 사용에 의해 추가
            if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
            	updatePs = new LoggableStatement(con, updateQuery.toString());
            } else {
            	updatePs = con.prepareStatement(updateQuery.toString());
            }

            i = 1;
            updatePs.setDouble(i++, unit_cost);
            updatePs.setDouble(i++, unit_cost);
            updatePs.setString(i++, coa_no);
            updatePs.setString(i++, tpsz);
            updatePs.setString(i++, coa_cost_src_cd);
            log.info("\n AGT_CM SQL1 : \n" + ((LoggableStatement)updatePs).getQueryString());
            returnYn = updatePs.executeUpdate();
           
        } catch (SQLException se) {
            log.error(se.getMessage(),se); 
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            throw new DAOException(e.getMessage());
        } finally {
            closeStatement(updatePs);
        }
        return returnYn;
    }    
}
