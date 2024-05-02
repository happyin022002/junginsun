/*=========================================================
*Copyright(c) 2018 SM Line
*@FileName : ReportDBDAOZoneReportVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.04.02
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.report.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReportDBDAOZoneReportVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ZoneReport 조회한다
	  * </pre>
	  */
	public ReportDBDAOZoneReportVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("zn_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("zn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rep_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("status",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.bcm.ccd.commoncode.report.integration").append("\n"); 
		query.append("FileName : ReportDBDAOZoneReportVORSQL").append("\n"); 
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
		query.append("select ZN_CD," ).append("\n"); 
		query.append("       ZN_NM," ).append("\n"); 
		query.append("       CGO_HNDL_TM_HRS," ).append("\n"); 
		query.append("       TZTM_HRS," ).append("\n"); 
		query.append("       REP_YD_CD," ).append("\n"); 
		query.append("       LNK_DIST," ).append("\n"); 
		query.append("       DIST_UT_CD," ).append("\n"); 
		query.append("       DECODE(DELT_FLG,'Y','Delete','Active') DELT_FLG," ).append("\n"); 
		query.append("       CRE_USR_ID," ).append("\n"); 
		query.append("       TO_CHAR(CRE_DT, 'YYYY-MM-DD HH24:MI:SS') CRE_DT," ).append("\n"); 
		query.append("       UPD_USR_ID," ).append("\n"); 
		query.append("       TO_CHAR(UPD_DT, 'YYYY-MM-DD HH24:MI:SS') UPD_DT" ).append("\n"); 
		query.append("from OPUSADM.MDM_ZONE" ).append("\n"); 
		query.append("WHERE  1 = 1 " ).append("\n"); 
		query.append("#if (${zn_cd} != '')" ).append("\n"); 
		query.append("AND ZN_CD like '%'||@[zn_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${zn_nm} != '')" ).append("\n"); 
		query.append("AND ZN_NM like '%'||@[zn_nm]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${loc_cd} != '')" ).append("\n"); 
		query.append("AND LOC_CD like '%'||@[loc_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rep_yd_cd} != '')" ).append("\n"); 
		query.append("AND REP_YD_CD like '%'||@[rep_yd_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${status} != '')" ).append("\n"); 
		query.append("AND DECODE(DELT_FLG,'Y','D','A') =  @[status]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}