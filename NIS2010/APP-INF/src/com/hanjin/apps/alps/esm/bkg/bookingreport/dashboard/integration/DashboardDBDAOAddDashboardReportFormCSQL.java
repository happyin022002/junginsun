/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : DashboardDBDAOAddDashboardReportFormCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.11.11
*@LastModifier : 
*@LastVersion : 1.0
* 2013.11.11 
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

public class DashboardDBDAOAddDashboardReportFormCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BKG_DBD_RPT_FOM 에 데이타를 업데이트 하거나 인서트 하는 merge 문
	  * </pre>
	  */
	public DashboardDBDAOAddDashboardReportFormCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpt_fom_desc",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : DashboardDBDAOAddDashboardReportFormCSQL").append("\n"); 
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
		query.append("MERGE INTO BKG_DBD_RPT_FOM" ).append("\n"); 
		query.append("USING DUAL" ).append("\n"); 
		query.append("   ON (@[usr_id]=BKG_DBD_RPT_FOM.CRE_USR_ID AND @[rpt_fom_nm]=BKG_DBD_RPT_FOM.RPT_FOM_NM)" ).append("\n"); 
		query.append(" WHEN MATCHED THEN" ).append("\n"); 
		query.append("		UPDATE SET BKG_DBD_RPT_FOM.RPT_FOM_DESC =@[rpt_fom_desc]" ).append("\n"); 
		query.append("				 , BKG_DBD_RPT_FOM.UPD_USR_ID = @[usr_id] " ).append("\n"); 
		query.append("				 , BKG_DBD_RPT_FOM.UPD_DT = SYSDATE" ).append("\n"); 
		query.append("			     " ).append("\n"); 
		query.append(" WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("		INSERT " ).append("\n"); 
		query.append("	  		(" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("				RPT_FOM_NO," ).append("\n"); 
		query.append("				RPT_FOM_NM," ).append("\n"); 
		query.append("				RPT_FOM_DESC," ).append("\n"); 
		query.append("				CRE_DT," ).append("\n"); 
		query.append("				CRE_USR_ID," ).append("\n"); 
		query.append("				UPD_DT," ).append("\n"); 
		query.append("				UPD_USR_ID" ).append("\n"); 
		query.append("	        )" ).append("\n"); 
		query.append("		VALUES(" ).append("\n"); 
		query.append(" 			 BKG_DBD_RPT_FOM_SEQ1.NEXTVAL" ).append("\n"); 
		query.append("		   , @[rpt_fom_nm]" ).append("\n"); 
		query.append("	       , @[rpt_fom_desc]" ).append("\n"); 
		query.append("	       , SYSDATE" ).append("\n"); 
		query.append("	       , @[usr_id]" ).append("\n"); 
		query.append("   		   , SYSDATE" ).append("\n"); 
		query.append("		   , @[usr_id]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            )" ).append("\n"); 

	}
}