/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : PerformanceReportDBDAOSearchDPSCCngUserGroupRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.05
*@LastModifier : 
*@LastVersion : 1.0
* 2013.04.05 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOSearchDPSCCngUserGroupRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PerformanceReportDBDAOSearchDPSCCngUserGroup
	  * </pre>
	  */
	public PerformanceReportDBDAOSearchDPSCCngUserGroupRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ui_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOSearchDPSCCngUserGroupRSQL").append("\n"); 
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
		query.append("    (SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID ='CD01986' AND INTG_CD_VAL_CTNT = HIS.SR_STS_CD AND ROWNUM = 1) AS DPCS_WRK_STS," ).append("\n"); 
		query.append("    TO_CHAR(HIS.SR_PROC_UPD_DT,'YYYY-MM-DD HH24:MI:SS') AS DPCS_WRK_DT," ).append("\n"); 
		query.append("    HIS.ATND_USR_ID USR_ID," ).append("\n"); 
		query.append("    (SELECT USR_NM FROM COM_USER WHERE USR_ID = ATND_USR_ID ) USR_NM," ).append("\n"); 
		query.append("    (SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL ,BKG_DPCS_USR_GRP GRP  WHERE INTG_CD_ID ='CD02100' AND INTG_CD_VAL_CTNT = DPCS_WRK_GRP_CD AND GRP.USR_ID = ATND_USR_ID) DPCS_WRK_GRP_NM," ).append("\n"); 
		query.append("    TO_CHAR(GLOBALDATE_PKG.TIME_LOCAL_FNC('MYPKG'),'YYYYMMDD HH24:MI:SS') WRK_ST_TM" ).append("\n"); 
		query.append("FROM BKG_SR_HIS HIS" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND SR_STS_CD = DECODE(@[ui_grp_cd],'A','AD','I','ID','R','RD')" ).append("\n"); 
		query.append("ORDER BY SR_PROC_UPD_DT DESC" ).append("\n"); 

	}
}