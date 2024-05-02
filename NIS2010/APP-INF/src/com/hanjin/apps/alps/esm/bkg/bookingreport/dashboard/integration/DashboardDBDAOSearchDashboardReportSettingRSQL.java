/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : DashboardDBDAOSearchDashboardReportSettingRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.12.30
*@LastModifier : 
*@LastVersion : 1.0
* 2013.12.30 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.dashboard.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DashboardDBDAOSearchDashboardReportSettingRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 오피스별 대쉬보드 세팅을 할 수 있도록 조회해오는 쿼리
	  * </pre>
	  */
	public DashboardDBDAOSearchDashboardReportSettingRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ofc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.dashboard.integration").append("\n"); 
		query.append("FileName : DashboardDBDAOSearchDashboardReportSettingRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("   B.DBD_IRR_TP_CD" ).append("\n"); 
		query.append(",   (SELECT OFC_CD " ).append("\n"); 
		query.append(" 	   FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append(" 	  WHERE OFC_CD = @[bkg_ofc] " ).append("\n"); 
		query.append("	    AND NVL(DELT_FLG,'N') ='N') BKG_OFC_CD" ).append("\n"); 
		query.append(",	B.DP_NM RPT_ITM_NM" ).append("\n"); 
		query.append(",   C.TO_VAL TODAY_AVG" ).append("\n"); 
		query.append(",   NVL(MAX(DECODE(A.LMT_STEP_NO, 1, A.FM_VAL )),0) GREEN_FR" ).append("\n"); 
		query.append(",   MAX(DECODE(A.LMT_STEP_NO, 1, A.TO_VAL )) GREEN_TO " ).append("\n"); 
		query.append(",   MAX(DECODE(A.LMT_STEP_NO, 2, A.FM_VAL )) YELLOW_FR " ).append("\n"); 
		query.append(",   MAX(DECODE(A.LMT_STEP_NO, 2, A.TO_VAL )) YELLOW_TO " ).append("\n"); 
		query.append(",   MAX(DECODE(A.LMT_STEP_NO, 3, A.FM_VAL )) RED_FR" ).append("\n"); 
		query.append(",   NVL(MAX(DECODE(A.LMT_STEP_NO, 3, A.TO_VAL )),100) RED_TO     " ).append("\n"); 
		query.append("FROM BKG_DBD_SET A , BKG_DBD_RPT_COL B, BKG_DBD_SET C" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND A.BKG_DBD_SET_TP_CD(+) = 'U'" ).append("\n"); 
		query.append("AND A.BKG_OFC_CD(+) = @[bkg_ofc]" ).append("\n"); 
		query.append("AND A.CRE_USR_ID(+) = @[usr_id]" ).append("\n"); 
		query.append("AND A.DBD_IRR_TP_CD(+) = B.DBD_IRR_TP_CD" ).append("\n"); 
		query.append("AND C.BKG_DBD_SET_TP_CD(+) = 'A'" ).append("\n"); 
		query.append("AND C.BKG_OFC_CD(+) = @[bkg_ofc]" ).append("\n"); 
		query.append("AND C.DBD_IRR_TP_CD(+) = B.DBD_IRR_TP_CD" ).append("\n"); 
		query.append("AND C.LMT_STEP_NO(+) = '1'" ).append("\n"); 
		query.append("GROUP BY A.BKG_OFC_CD, B.DBD_IRR_TP_CD, B.DP_NM, C.TO_VAL" ).append("\n"); 
		query.append("ORDER BY TO_NUMBER(DBD_IRR_TP_CD)" ).append("\n"); 

	}
}