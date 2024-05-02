/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PerformanceInquiryDBDAOSearchNonTPBListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.04
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.04 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tpb.statusinquiry.performanceinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceInquiryDBDAOSearchNonTPBListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchNonTPBList
	  * </pre>
	  */
	public PerformanceInquiryDBDAOSearchNonTPBListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_if_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_edate",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_date_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_if_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_sdate",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_if_ctrl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tpb.statusinquiry.performanceinquiry.integration").append("\n"); 
		query.append("FileName : PerformanceInquiryDBDAOSearchNonTPBListRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
	
	public String getSQL(){
		return query.toString();
	}
	
	public HashMap<String,String[]> getParams() {
		return params;
	}

	/**
	 * Query 생성
	 */
	public void setQuery(){
		query.append("#if (${s_if_rhq_cd} == 'all')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT NVL(a.cfm_ofc_cd, 'Total') if_ofc_cd" ).append("\n"); 
		query.append("      ,NVL(a.cd_type,'S.TTL') cd_type" ).append("\n"); 
		query.append("      ,total_cnt, '' total_ratio" ).append("\n"); 
		query.append("      ,tes_cnt, '' tes_ratio" ).append("\n"); 
		query.append("      ,trs_cnt, '' trs_ratio" ).append("\n"); 
		query.append("      ,mnr_cnt, '' mnr_ratio" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("          SELECT b.cfm_ofc_cd, DECODE(b.intg_cd_val_ctnt,'CD','Duplication','CN','Notification','Cancel') cd_type" ).append("\n"); 
		query.append("                ,SUM(a.cnt) total_cnt" ).append("\n"); 
		query.append("                ,SUM(DECODE(a.n3pty_expn_tp_cd, 'TES', a.cnt)) tes_cnt" ).append("\n"); 
		query.append("                ,SUM(DECODE(a.n3pty_expn_tp_cd, 'TRS', a.cnt)) trs_cnt" ).append("\n"); 
		query.append("                ,SUM(DECODE(a.n3pty_expn_tp_cd, 'MNR', a.cnt)) mnr_cnt" ).append("\n"); 
		query.append("            FROM (" ).append("\n"); 
		query.append("                    SELECT m.rhq AS cfm_ofc_cd, n3pty_non_cfm_rsn_cd, n3pty_expn_tp_cd, COUNT(a.ots_dtl_seq) cnt" ).append("\n"); 
		query.append("                      FROM tpb_ots_dtl a," ).append("\n"); 
		query.append("                           (" ).append("\n"); 
		query.append("                              SELECT rhq_cd rhq, ofc_cd ofc" ).append("\n"); 
		query.append("                                FROM TPB_HNDL_OFC" ).append("\n"); 
		query.append("                               WHERE n3pty_ofc_tp_cd='T' AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("#if (${s_if_rhq_cd} != '' && ${s_if_rhq_cd} != 'all')" ).append("\n"); 
		query.append("                                 AND rhq_cd = @[s_if_rhq_cd]     /* bind */" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_if_ctrl_cd} != '' && ${s_if_ctrl_cd} != 'all')" ).append("\n"); 
		query.append("                                 AND n3pty_ctrl_ofc_cd = @[s_if_ctrl_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_if_ofc_cd} != '' && ${s_if_ofc_cd} != 'all')" ).append("\n"); 
		query.append("                                 AND ofc_cd = @[s_if_ofc_cd]     /* bind */" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                           ) m" ).append("\n"); 
		query.append("                     WHERE a.cfm_ofc_cd = m.ofc" ).append("\n"); 
		query.append("                       AND a.n3pty_cfm_cd = 'N'" ).append("\n"); 
		query.append("                       AND if_dt >= DECODE(@[s_date_type], 'L', TPB_GET_SRCH_DATE_FNC(@[s_sdate],'YYYY-MM-DD',@[user_ofc_cd]), TO_DATE(@[s_sdate],'YYYY-MM-DD') + 9/24 )" ).append("\n"); 
		query.append("                       AND if_dt < DECODE(@[s_date_type], 'L', TPB_GET_SRCH_DATE_FNC(@[s_edate],'YYYY-MM-DD',@[user_ofc_cd]),TO_DATE(@[s_edate], 'YYYY-MM-DD') + 9/24 ) + 1" ).append("\n"); 
		query.append("                       AND a.n3pty_delt_tp_cd IN ('N','S')" ).append("\n"); 
		query.append("                  GROUP BY m.rhq,n3pty_non_cfm_rsn_cd,n3pty_expn_tp_cd" ).append("\n"); 
		query.append("                 ) a," ).append("\n"); 
		query.append("                 (" ).append("\n"); 
		query.append("                    SELECT a.rhq AS  cfm_ofc_cd, b.intg_cd_val_ctnt" ).append("\n"); 
		query.append("                      FROM (" ).append("\n"); 
		query.append("                              SELECT rhq_cd rhq, ofc_cd ofc" ).append("\n"); 
		query.append("                                FROM TPB_HNDL_OFC AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                               WHERE n3pty_ofc_tp_cd='T'" ).append("\n"); 
		query.append("#if (${s_if_rhq_cd} != '' && ${s_if_rhq_cd} != 'all')" ).append("\n"); 
		query.append("                                 AND rhq_cd = @[s_if_rhq_cd]     /* bind */" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_if_ctrl_cd} != '' && ${s_if_ctrl_cd} != 'all')" ).append("\n"); 
		query.append("                                 AND n3pty_ctrl_ofc_cd = @[s_if_ctrl_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_if_ofc_cd} != '' && ${s_if_ofc_cd} != 'all')" ).append("\n"); 
		query.append("                                 AND ofc_cd = @[s_if_ofc_cd]     /* bind */" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                           ) a, com_intg_cd_dtl b" ).append("\n"); 
		query.append("                     WHERE b.intg_cd_id = 'CD00902'" ).append("\n"); 
		query.append("                  GROUP BY a.rhq, b.intg_cd_val_ctnt" ).append("\n"); 
		query.append("                 ) b" ).append("\n"); 
		query.append("           WHERE a.n3pty_non_cfm_rsn_cd(+) = b.intg_cd_val_ctnt" ).append("\n"); 
		query.append("             AND a.cfm_ofc_cd(+) = b.cfm_ofc_cd" ).append("\n"); 
		query.append("        GROUP BY CUBE(b.cfm_ofc_cd, DECODE(b.intg_cd_val_ctnt,'CD','Duplication','CN','Notification','Cancel'))" ).append("\n"); 
		query.append("       ) a" ).append("\n"); 
		query.append(" ORDER BY a.cfm_ofc_cd,DECODE(a.cd_type,'Duplication',3,'Notification',2,'Cancel',1,4)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT NVL(a.cfm_ofc_cd, 'Total') if_ofc_cd" ).append("\n"); 
		query.append("      ,NVL(a.cd_type,'S.TTL') cd_type" ).append("\n"); 
		query.append("      ,total_cnt, '' total_ratio" ).append("\n"); 
		query.append("      ,tes_cnt, '' tes_ratio" ).append("\n"); 
		query.append("      ,trs_cnt, '' trs_ratio" ).append("\n"); 
		query.append("      ,mnr_cnt, '' mnr_ratio" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("          SELECT b.cfm_ofc_cd, DECODE(b.intg_cd_val_ctnt,'CD','Duplication','CN','Notification','Cancel') cd_type" ).append("\n"); 
		query.append("                ,SUM(a.cnt) total_cnt" ).append("\n"); 
		query.append("                ,SUM(DECODE(a.n3pty_expn_tp_cd, 'TES', a.cnt)) tes_cnt" ).append("\n"); 
		query.append("                ,SUM(DECODE(a.n3pty_expn_tp_cd, 'TRS', a.cnt)) trs_cnt" ).append("\n"); 
		query.append("                ,SUM(DECODE(a.n3pty_expn_tp_cd, 'MNR', a.cnt)) mnr_cnt" ).append("\n"); 
		query.append("            FROM (" ).append("\n"); 
		query.append("                    SELECT m.ofc AS cfm_ofc_cd, n3pty_non_cfm_rsn_cd, n3pty_expn_tp_cd, COUNT(a.ots_dtl_seq) cnt" ).append("\n"); 
		query.append("                      FROM tpb_ots_dtl a," ).append("\n"); 
		query.append("                           (" ).append("\n"); 
		query.append("                              SELECT rhq_cd rhq, ofc_cd ofc" ).append("\n"); 
		query.append("                                FROM TPB_HNDL_OFC" ).append("\n"); 
		query.append("                               WHERE n3pty_ofc_tp_cd='T' AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("#if (${s_if_rhq_cd} != '' && ${s_if_rhq_cd} != 'all')" ).append("\n"); 
		query.append("                                 AND rhq_cd = @[s_if_rhq_cd]     /* bind */" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_if_ctrl_cd} != '' && ${s_if_ctrl_cd} != 'all')" ).append("\n"); 
		query.append("                                 AND n3pty_ctrl_ofc_cd = @[s_if_ctrl_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_if_ofc_cd} != '' && ${s_if_ofc_cd} != 'all')" ).append("\n"); 
		query.append("                                 AND ofc_cd = @[s_if_ofc_cd]     /* bind */" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                           ) m" ).append("\n"); 
		query.append("                     WHERE a.cfm_ofc_cd = m.ofc" ).append("\n"); 
		query.append("                       AND a.n3pty_cfm_cd = 'N'" ).append("\n"); 
		query.append("                       AND if_dt >= DECODE(@[s_date_type], 'L', TPB_GET_SRCH_DATE_FNC(@[s_sdate],'YYYY-MM-DD',@[user_ofc_cd]), TO_DATE(@[s_sdate],'YYYY-MM-DD') + 9/24 )" ).append("\n"); 
		query.append("                       AND if_dt < DECODE(@[s_date_type], 'L', TPB_GET_SRCH_DATE_FNC(@[s_edate],'YYYY-MM-DD',@[user_ofc_cd]),TO_DATE(@[s_edate], 'YYYY-MM-DD') + 9/24 ) + 1" ).append("\n"); 
		query.append("                       AND a.n3pty_delt_tp_cd IN ('N','S')" ).append("\n"); 
		query.append("                  GROUP BY m.ofc,n3pty_non_cfm_rsn_cd,n3pty_expn_tp_cd" ).append("\n"); 
		query.append("                 ) a," ).append("\n"); 
		query.append("                 (" ).append("\n"); 
		query.append("                    SELECT a.ofc AS  cfm_ofc_cd, b.intg_cd_val_ctnt" ).append("\n"); 
		query.append("                      FROM (" ).append("\n"); 
		query.append("                              SELECT rhq_cd rhq, ofc_cd ofc" ).append("\n"); 
		query.append("                                FROM TPB_HNDL_OFC" ).append("\n"); 
		query.append("                               WHERE n3pty_ofc_tp_cd='T' AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("#if (${s_if_rhq_cd} != '' && ${s_if_rhq_cd} != 'all')" ).append("\n"); 
		query.append("                                 AND rhq_cd = @[s_if_rhq_cd]     /* bind */" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_if_ctrl_cd} != '' && ${s_if_ctrl_cd} != 'all')" ).append("\n"); 
		query.append("                                 AND n3pty_ctrl_ofc_cd = @[s_if_ctrl_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_if_ofc_cd} != '' && ${s_if_ofc_cd} != 'all')" ).append("\n"); 
		query.append("                                 AND ofc_cd = @[s_if_ofc_cd]     /* bind */" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                           ) a, com_intg_cd_dtl b" ).append("\n"); 
		query.append("                     WHERE b.intg_cd_id = 'CD00902'" ).append("\n"); 
		query.append("                  GROUP BY a.ofc, b.intg_cd_val_ctnt" ).append("\n"); 
		query.append("                 ) b" ).append("\n"); 
		query.append("           WHERE a.n3pty_non_cfm_rsn_cd(+) = b.intg_cd_val_ctnt" ).append("\n"); 
		query.append("             AND a.cfm_ofc_cd(+) = b.cfm_ofc_cd" ).append("\n"); 
		query.append("        GROUP BY CUBE(b.cfm_ofc_cd, DECODE(b.intg_cd_val_ctnt,'CD','Duplication','CN','Notification','Cancel'))" ).append("\n"); 
		query.append("       ) a" ).append("\n"); 
		query.append(" ORDER BY a.cfm_ofc_cd,DECODE(a.cd_type,'Duplication',3,'Notification',2,'Cancel',1,4)" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}