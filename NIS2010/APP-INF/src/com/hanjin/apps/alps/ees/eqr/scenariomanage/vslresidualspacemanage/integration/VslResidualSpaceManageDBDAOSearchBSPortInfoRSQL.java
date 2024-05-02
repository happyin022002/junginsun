/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VslResidualSpaceManageDBDAOSearchBSPortInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.06
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009.11.06 정은호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage.vslresidualspacemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author ChungEunHo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VslResidualSpaceManageDBDAOSearchBSPortInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EQR_SCNR_BSA_PORT 테이블에서 scnr bsa port정보 조회
	  * </pre>
	  */
	public VslResidualSpaceManageDBDAOSearchBSPortInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("company_code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("company_code1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_yrwk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scnr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("st_key",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trade_code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_yrwk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("co_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.scenariomanage.vslresidualspacemanage.integration").append("\n"); 
		query.append("FileName : VslResidualSpaceManageDBDAOSearchBSPortInfoRSQL").append("\n"); 
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
		query.append("#if(${st_key} == 'Y')" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("MAX(DECODE ( rumm , 1 ,VSL_PORT_CALL_SEQ)) VESSEL_PORT_CALL_SEQUENCE ," ).append("\n"); 
		query.append("MAX(DECODE (CO_CD , @[company_code] ,VSL_PORT_CD))   VESSEL_PORT_CODE," ).append("\n"); 
		query.append("MAX(DECODE (CO_CD , @[company_code] ,VSL_PORT_SPC))  VESSEL_PORT_SPACE," ).append("\n"); 
		query.append("MAX(DECODE (CO_CD , @[company_code] ,VSL_PORT_AVG_WGT)) VESSEL_PORT_AVERAGE_WEIGHT," ).append("\n"); 
		query.append("MAX(DECODE (CO_CD , @[company_code1] ,VSL_PORT_CD))   VESSEL_PORT_CODE1," ).append("\n"); 
		query.append("MAX(DECODE (CO_CD , @[company_code1] ,VSL_PORT_SPC))  VESSEL_PORT_SPACE1," ).append("\n"); 
		query.append("MAX(DECODE (CO_CD , @[company_code1] ,VSL_PORT_AVG_WGT)) VESSEL_PORT_AVERAGE_WEIGHT1," ).append("\n"); 
		query.append("SCNR_ID," ).append("\n"); 
		query.append("FM_YRWK FROM_YEAR_WEEK ," ).append("\n"); 
		query.append("TO_YRWK TO_YEAR_WEEK," ).append("\n"); 
		query.append("VSL_CD," ).append("\n"); 
		query.append("SKD_VOY_NO," ).append("\n"); 
		query.append("SKD_DIR_CD," ).append("\n"); 
		query.append("MAX(DECODE (CO_CD , @[company_code] ,CO_CD)) COMPANY_CODE ," ).append("\n"); 
		query.append("TRD_CD TRADE_CODE ," ).append("\n"); 
		query.append("@[st_key] V" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("VSL_PORT_CALL_SEQ," ).append("\n"); 
		query.append("VSL_PORT_CD," ).append("\n"); 
		query.append("VSL_PORT_SPC," ).append("\n"); 
		query.append("VSL_PORT_AVG_WGT," ).append("\n"); 
		query.append("SCNR_ID," ).append("\n"); 
		query.append("FM_YRWK," ).append("\n"); 
		query.append("TO_YRWK," ).append("\n"); 
		query.append("VSL_CD," ).append("\n"); 
		query.append("SKD_VOY_NO," ).append("\n"); 
		query.append("SKD_DIR_CD," ).append("\n"); 
		query.append("CO_CD," ).append("\n"); 
		query.append("TRD_CD ," ).append("\n"); 
		query.append("ROW_NUMBER() OVER (PARTITION BY CO_CD ,VSL_PORT_CALL_SEQ  ORDER BY ROWNUM) RUMM" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_SCNR_BSA_PORT" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("SCNR_ID = @[scnr_id]" ).append("\n"); 
		query.append("AND FM_YRWK    = @[fm_yrwk]" ).append("\n"); 
		query.append("AND TO_YRWK    = @[to_yrwk]" ).append("\n"); 
		query.append("AND VSL_CD     = @[vsl_cd]" ).append("\n"); 
		query.append("AND SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("AND SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND TRD_CD     = @[trade_code]" ).append("\n"); 
		query.append("AND CO_CD      = @[co_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("rumm" ).append("\n"); 
		query.append(",VSL_PORT_CALL_SEQ" ).append("\n"); 
		query.append(", FM_YRWK,TO_YRWK" ).append("\n"); 
		query.append(", VSL_CD" ).append("\n"); 
		query.append(", SKD_VOY_NO" ).append("\n"); 
		query.append(", SKD_DIR_CD" ).append("\n"); 
		query.append(", SKD_DIR_CD" ).append("\n"); 
		query.append(", SCNR_ID" ).append("\n"); 
		query.append(", TRD_CD" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("TO_NUMBER(VSL_PORT_CALL_SEQ)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("VSL_PORT_CALL_SEQ VESSEL_PORT_CALL_SEQUENCE," ).append("\n"); 
		query.append("VSL_PORT_CD VESSEL_PORT_CODE," ).append("\n"); 
		query.append("VSL_PORT_SPC VESSEL_PORT_SPACE," ).append("\n"); 
		query.append("VSL_PORT_AVG_WGT VESSEL_PORT_AVERAGE_WEIGHT," ).append("\n"); 
		query.append("'' VESSEL_PORT_CODE1," ).append("\n"); 
		query.append("'' VESSEL_PORT_SPACE1," ).append("\n"); 
		query.append("'' VESSEL_PORT_AVERAGE_WEIGHT1," ).append("\n"); 
		query.append("SCNR_ID," ).append("\n"); 
		query.append("FM_YRWK FROM_YEAR_WEEK," ).append("\n"); 
		query.append("TO_YRWK TO_YEAR_WEEK," ).append("\n"); 
		query.append("VSL_CD," ).append("\n"); 
		query.append("SKD_VOY_NO," ).append("\n"); 
		query.append("SKD_DIR_CD," ).append("\n"); 
		query.append("CO_CD COMPANY_CODE," ).append("\n"); 
		query.append("TRD_CD TRADE_CODE ," ).append("\n"); 
		query.append("@[st_key] CHECKED" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_SCNR_BSA_PORT" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("SCNR_ID = @[scnr_id]" ).append("\n"); 
		query.append("AND FM_YRWK    = @[fm_yrwk]" ).append("\n"); 
		query.append("AND TO_YRWK    = @[to_yrwk]" ).append("\n"); 
		query.append("AND VSL_CD     = @[vsl_cd]" ).append("\n"); 
		query.append("AND SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("AND SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND TRD_CD     = @[trade_code]" ).append("\n"); 
		query.append("AND CO_CD      = @[co_cd]" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("TO_NUMBER(VSL_PORT_CALL_SEQ) ASC" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}