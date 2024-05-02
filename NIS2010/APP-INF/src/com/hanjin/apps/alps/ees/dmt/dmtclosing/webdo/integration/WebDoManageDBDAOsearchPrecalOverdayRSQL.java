/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : WebDoManageDBDAOsearchPrecalOverdayRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.01.11
*@LastModifier : 
*@LastVersion : 1.0
* 2012.01.11 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.webdo.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WebDoManageDBDAOsearchPrecalOverdayRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * precalDRDateCharge 오퍼레이션 호출하여 계산된 결과 조회
	  * </pre>
	  */
	public WebDoManageDBDAOsearchPrecalOverdayRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sys_area_grp_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_cyc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_chg_loc_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_trf_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtclosing.webdo.integration").append("\n"); 
		query.append("FileName : WebDoManageDBDAOsearchPrecalOverdayRSQL").append("\n"); 
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
		query.append("SELECT  SYS_AREA_GRP_ID," ).append("\n"); 
		query.append("        CNTR_NO," ).append("\n"); 
		query.append("        CNTR_CYC_NO," ).append("\n"); 
		query.append("        DMDT_TRF_CD," ).append("\n"); 
		query.append("        DMDT_CHG_LOC_DIV_CD," ).append("\n"); 
		query.append("        CHG_SEQ," ).append("\n"); 
		query.append("        FM_MVMT_DT," ).append("\n"); 
		query.append("        TO_MVMT_DT," ).append("\n"); 
		query.append("        WEB_CRE_USR_ID," ).append("\n"); 
		query.append("        WEB_CRE_DT," ).append("\n"); 
		query.append("        FX_FT_OVR_DYS," ).append("\n"); 
		query.append("        BZC_TRF_CURR_CD," ).append("\n"); 
		query.append("        BIL_AMT" ).append("\n"); 
		query.append("FROM    DMT_CHG_PRE_CALC" ).append("\n"); 
		query.append("WHERE   SYS_AREA_GRP_ID = @[sys_area_grp_id]" ).append("\n"); 
		query.append("AND     CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("AND     CNTR_CYC_NO = @[cntr_cyc_no]" ).append("\n"); 
		query.append("AND     DMDT_TRF_CD = @[dmdt_trf_cd] " ).append("\n"); 
		query.append("AND     DMDT_CHG_LOC_DIV_CD = @[dmdt_chg_loc_div_cd]" ).append("\n"); 
		query.append("AND     CHG_SEQ = @[chg_seq]" ).append("\n"); 

	}
}