/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : VesselScheduleMgtDBDAOModifyCanalTzBKGCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.23
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselScheduleMgtDBDAOModifyCanalTzBKGCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Canal Transit Booking 정보를 저장 및 업데이트
	  * </pre>
	  */
	public VesselScheduleMgtDBDAOModifyCanalTzBKGCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnl_tz_bkg_proc_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnl_tz_bkg_prd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnl_bkg_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnl_bkg_tz_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cnl_ot_svc_arr_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("start_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnl_ot_svc_apro_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bound",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration").append("\n"); 
		query.append("FileName : VesselScheduleMgtDBDAOModifyCanalTzBKGCSQL").append("\n"); 
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
		query.append("MERGE INTO VSK_CNL_TZ_BKG B" ).append("\n"); 
		query.append("USING " ).append("\n"); 
		query.append("      (    " ).append("\n"); 
		query.append("        SELECT   REPLACE(TO_CHAR(TO_DATE(@[start_date], 'YYYY-MM-DD'), 'YYYY-MM'), '-', '') AS CNL_TZ_BKG_YRMON" ).append("\n"); 
		query.append("               , SUBSTR(@[vvd],1,4)     AS VSL_CD" ).append("\n"); 
		query.append("               , SUBSTR(@[vvd],5,4)     AS SKD_VOY_NO" ).append("\n"); 
		query.append("               , SUBSTR(@[vvd],9,1)     AS SKD_DIR_CD" ).append("\n"); 
		query.append("               , @[vps_port_cd]         AS CNL_PORT_CD" ).append("\n"); 
		query.append("               , DECODE(@[bound], 'North Bound', 'N', 'South Bound', 'S')        AS SVC_SCP_BND_CD" ).append("\n"); 
		query.append("        FROM     DUAL" ).append("\n"); 
		query.append("      )   X" ).append("\n"); 
		query.append("ON    (" ).append("\n"); 
		query.append("        B.CNL_TZ_BKG_YRMON  = X.CNL_TZ_BKG_YRMON" ).append("\n"); 
		query.append("AND     B.VSL_CD            = X.VSL_CD" ).append("\n"); 
		query.append("AND     B.SKD_VOY_NO        = X.SKD_VOY_NO" ).append("\n"); 
		query.append("AND     B.SKD_DIR_CD        = X.SKD_DIR_CD" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("WHEN MATCHED THEN " ).append("\n"); 
		query.append("  UPDATE SET " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("	  CNL_TZ_BKG_PRD_CD        = @[cnl_tz_bkg_prd_cd]" ).append("\n"); 
		query.append("	, CNL_TZ_BKG_PROC_STS_CD   = @[cnl_tz_bkg_proc_sts_cd]" ).append("\n"); 
		query.append("    , CNL_BKG_TZ_DT            = TO_DATE(@[cnl_bkg_tz_dt], 'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("    , CNL_OT_SVC_APRO_FLG      = @[cnl_ot_svc_apro_flg]" ).append("\n"); 
		query.append("    , UPD_USR_ID               = @[usr_id]  " ).append("\n"); 
		query.append("    , UPD_DT                   = SYSDATE" ).append("\n"); 
		query.append("    , CNL_OT_SVC_ARR_DT        = TO_DATE(@[cnl_ot_svc_arr_dt], 'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("    , CNL_BKG_AMT              = @[cnl_bkg_amt] " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("  INSERT" ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append("     CNL_TZ_BKG_YRMON" ).append("\n"); 
		query.append("     , VSL_CD" ).append("\n"); 
		query.append("     , SKD_VOY_NO" ).append("\n"); 
		query.append("     , SKD_DIR_CD" ).append("\n"); 
		query.append("     , CNL_PORT_CD" ).append("\n"); 
		query.append("     , SVC_SCP_BND_CD" ).append("\n"); 
		query.append("     , CNL_TZ_BKG_PRD_CD" ).append("\n"); 
		query.append("     , CNL_TZ_BKG_PROC_STS_CD" ).append("\n"); 
		query.append("     , CNL_BKG_TZ_DT" ).append("\n"); 
		query.append("     , CNL_OT_SVC_APRO_FLG" ).append("\n"); 
		query.append("     , CRE_USR_ID" ).append("\n"); 
		query.append("     , CRE_DT" ).append("\n"); 
		query.append("     , UPD_USR_ID" ).append("\n"); 
		query.append("     , UPD_DT" ).append("\n"); 
		query.append("     , CNL_OT_SVC_ARR_DT" ).append("\n"); 
		query.append("     , CNL_BKG_AMT" ).append("\n"); 
		query.append("  )" ).append("\n"); 
		query.append("  VALUES" ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append("	   REPLACE(TO_CHAR(TO_DATE(@[start_date], 'YYYY-MM-DD'), 'YYYY-MM'), '-', '')" ).append("\n"); 
		query.append("     , SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("     , SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("     , SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("     , @[vps_port_cd]" ).append("\n"); 
		query.append("     , DECODE(@[bound], 'North Bound', 'N', 'South Bound', 'S')" ).append("\n"); 
		query.append("     " ).append("\n"); 
		query.append("     , @[cnl_tz_bkg_prd_cd]" ).append("\n"); 
		query.append("     , @[cnl_tz_bkg_proc_sts_cd]" ).append("\n"); 
		query.append("     , TO_DATE(@[cnl_bkg_tz_dt], 'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("     , @[cnl_ot_svc_apro_flg]" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("     , @[usr_id]  " ).append("\n"); 
		query.append("     , SYSDATE" ).append("\n"); 
		query.append("	 , @[usr_id]   " ).append("\n"); 
		query.append("     , SYSDATE" ).append("\n"); 
		query.append("     , TO_DATE(@[cnl_ot_svc_arr_dt], 'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("     , @[cnl_bkg_amt]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  )" ).append("\n"); 

	}
}