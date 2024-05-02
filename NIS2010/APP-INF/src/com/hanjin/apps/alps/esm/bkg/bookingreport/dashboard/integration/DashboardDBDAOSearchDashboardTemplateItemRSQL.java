/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : DashboardDBDAOSearchDashboardTemplateItemRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.12.05
*@LastModifier : 
*@LastVersion : 1.0
* 2013.12.05 
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

public class DashboardDBDAOSearchDashboardTemplateItemRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * template에 정의된 Item List를 조회한다.
	  * </pre>
	  */
	public DashboardDBDAOSearchDashboardTemplateItemRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rpt_fom_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.dashboard.integration").append("\n"); 
		query.append("FileName : DashboardDBDAOSearchDashboardTemplateItemRSQL").append("\n"); 
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
		query.append("  A.RPT_FOM_NM" ).append("\n"); 
		query.append(", B.DBD_IRR_TP_CD" ).append("\n"); 
		query.append(", C.COL_NM" ).append("\n"); 
		query.append("FROM BKG_DBD_RPT_FOM A, BKG_DBD_RPT_FOM_DTL B" ).append("\n"); 
		query.append(", BKG_DBD_RPT_COL C" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND A.RPT_FOM_NO = @[f_rpt_fom_no]" ).append("\n"); 
		query.append("AND A.RPT_FOM_NO = B.RPT_FOM_NO" ).append("\n"); 
		query.append("AND B.RPT_ID = C.RPT_ID" ).append("\n"); 
		query.append("AND B.DBD_IRR_TP_CD = C.DBD_IRR_TP_CD" ).append("\n"); 
		query.append("ORDER BY B.DP_SEQ" ).append("\n"); 

	}
}