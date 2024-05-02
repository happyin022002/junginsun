/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AgncommagmthistoryDBDAOSearchAgncommagmthistoryListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.26
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.26 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmhistory.agncommagmthistory.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AgncommagmthistoryDBDAOSearchAgncommagmthistoryListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchAgncommagmthistoryList
	  * </pre>
	  */
	public AgncommagmthistoryDBDAOSearchAgncommagmthistoryListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("login_ofc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.acm.acmhistory.agncommagmthistory.integration").append("\n"); 
		query.append("FileName : AgncommagmthistoryDBDAOSearchAgncommagmthistoryListRSQL").append("\n"); 
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
		query.append(" AGN_CD" ).append("\n"); 
		query.append(",AGN_AGMT_NO" ).append("\n"); 
		query.append(",AGMT_HIS_NO" ).append("\n"); 
		query.append(",AGMT_FM_DT_CD" ).append("\n"); 
		query.append(",AGMT_FM_DT" ).append("\n"); 
		query.append(",AGMT_TO_DT_CD" ).append("\n"); 
		query.append(",AGMT_TO_DT" ).append("\n"); 
		query.append(",AGN_AGMT_RMK" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",TO_CHAR (CRE_LOCL_DT, 'YYYY-MM-DD') AS CRE_LOCL_DT" ).append("\n"); 
		query.append(",TO_CHAR (CRE_LOCL_DT, 'HH24:MI') CRE_LOCL_DT_TM" ).append("\n"); 
		query.append(",TO_CHAR (CRE_GDT, 'YYYY-MM-DD') AS CRE_GDT" ).append("\n"); 
		query.append(",TO_CHAR (CRE_GDT, 'HH24:MI') CRE_GDT_TM" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",DELT_FLG" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT A.AGN_CD," ).append("\n"); 
		query.append("           A.AGN_AGMT_NO," ).append("\n"); 
		query.append("           A.AGMT_HIS_NO," ).append("\n"); 
		query.append("           A.AGMT_FM_DT_CD," ).append("\n"); 
		query.append("           TO_CHAR(TO_DATE(A.AGMT_FM_DT, 'YYYYMMDD'), 'YYYY-MM-DD') AS AGMT_FM_DT," ).append("\n"); 
		query.append("           A.AGMT_TO_DT_CD," ).append("\n"); 
		query.append("           TO_CHAR(TO_DATE(A.AGMT_TO_DT, 'YYYYMMDD'), 'YYYY-MM-DD') AS AGMT_TO_DT," ).append("\n"); 
		query.append("           A.AGN_AGMT_RMK," ).append("\n"); 
		query.append("           TO_CHAR (A.CRE_DT,  'YYYY-MM-DD HH24:MI') AS CRE_DT," ).append("\n"); 
		query.append("		   GLOBALDATE_PKG.TIME_CONV_OFC_FNC('SINHO',A.CRE_DT,@[login_ofc]) AS CRE_LOCL_DT," ).append("\n"); 
		query.append("           A.CRE_GDT," ).append("\n"); 
		query.append("           (SELECT USR_NM FROM COM_USER C WHERE C.USR_ID = A.CRE_USR_ID) AS CRE_USR_ID," ).append("\n"); 
		query.append("           NVL (A.DELT_FLG, 'N') AS DELT_FLG" ).append("\n"); 
		query.append("    FROM ACM_AGN_AGMT_MST_HIS A" ).append("\n"); 
		query.append("#if (${agn_cd} != '')" ).append("\n"); 
		query.append("    WHERE AGN_CD = @[agn_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    union all" ).append("\n"); 
		query.append("    SELECT B.AGN_CD," ).append("\n"); 
		query.append("           B.AGN_AGMT_NO," ).append("\n"); 
		query.append("           B.AGMT_DTL_HIS_NO," ).append("\n"); 
		query.append("           '' AS AGMT_FM_DT_CD," ).append("\n"); 
		query.append("           '' AS AGMT_FM_DT," ).append("\n"); 
		query.append("           '' AS AGMT_TO_DT_CD," ).append("\n"); 
		query.append("           '' AS AGMT_TO_DT," ).append("\n"); 
		query.append("           '' AS AGN_AGMT_RMK," ).append("\n"); 
		query.append("           TO_CHAR (B.CRE_DT,  'YYYY-MM-DD HH24:MI') AS CRE_DT," ).append("\n"); 
		query.append("		   GLOBALDATE_PKG.TIME_CONV_OFC_FNC('SINHO',B.CRE_DT,@[login_ofc]) AS CRE_LOCL_DT," ).append("\n"); 
		query.append("           B.CRE_GDT," ).append("\n"); 
		query.append("           (SELECT USR_NM FROM COM_USER C WHERE C.USR_ID = B.CRE_USR_ID) AS CRE_USR_ID," ).append("\n"); 
		query.append("           NVL (B.DELT_FLG, 'N') AS DELT_FLG" ).append("\n"); 
		query.append("    FROM ACM_AGN_AGMT_DTL_HIS B" ).append("\n"); 
		query.append("   WHERE 1=1" ).append("\n"); 
		query.append("#if (${agn_cd} != '')" ).append("\n"); 
		query.append("    AND AGN_CD = @[agn_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    AND NOT EXISTS (" ).append("\n"); 
		query.append("        SELECT 1 FROM ACM_AGN_AGMT_MST_HIS M WHERE M.AGN_CD = B.AGN_CD AND M.AGMT_HIS_NO = B.AGMT_DTL_HIS_NO" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ORDER BY AGMT_HIS_NO, CRE_DT" ).append("\n"); 

	}
}