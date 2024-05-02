/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : DashboardDBDAOSearchStoredDashboardReportColumnRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.01.22
*@LastModifier : 
*@LastVersion : 1.0
* 2014.01.22 
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

public class DashboardDBDAOSearchStoredDashboardReportColumnRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 해당 사용자가 저장한 report form 의 report column 을 조회한다
	  * </pre>
	  */
	public DashboardDBDAOSearchStoredDashboardReportColumnRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpt_fom_nm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.dashboard.integration").append("\n"); 
		query.append("FileName : DashboardDBDAOSearchStoredDashboardReportColumnRSQL").append("\n"); 
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
		query.append("        D.RPT_FOM_NO" ).append("\n"); 
		query.append("        , D.RPT_ID" ).append("\n"); 
		query.append("        , D.DBD_IRR_TP_CD" ).append("\n"); 
		query.append("        , D.DP_NM" ).append("\n"); 
		query.append("        , D.DP_SEQ" ).append("\n"); 
		query.append("        , D.CRE_DT" ).append("\n"); 
		query.append("        , D.CRE_USR_ID" ).append("\n"); 
		query.append("        , D.UPD_DT" ).append("\n"); 
		query.append("        , D.UPD_USR_ID" ).append("\n"); 
		query.append("FROM BKG_DBD_RPT_FOM_DTL D" ).append("\n"); 
		query.append(", BKG_DBD_RPT_FOM F" ).append("\n"); 
		query.append("WHERE F.CRE_USR_ID = @[usr_id]" ).append("\n"); 
		query.append("AND F.RPT_FOM_NM = @[rpt_fom_nm]" ).append("\n"); 
		query.append("AND F.RPT_FOM_NO = D.RPT_FOM_NO" ).append("\n"); 
		query.append("AND F.CRE_USR_ID = D.CRE_USR_ID" ).append("\n"); 
		query.append("ORDER BY D.DP_SEQ" ).append("\n"); 

	}
}