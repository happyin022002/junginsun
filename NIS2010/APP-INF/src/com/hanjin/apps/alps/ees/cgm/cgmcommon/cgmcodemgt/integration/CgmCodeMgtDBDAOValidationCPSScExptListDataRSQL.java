/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CgmCodeMgtDBDAOValidationCPSScExptListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.15
*@LastModifier : 이영헌
*@LastVersion : 1.0
* 2013.05.15 이영헌
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author YoungHeon Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CgmCodeMgtDBDAOValidationCPSScExptListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * S/C Exception List에 대한 유효성을 체크한다.
	  * </pre>
	  */
	public CgmCodeMgtDBDAOValidationCPSScExptListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("eff_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_grp_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.integration").append("\n"); 
		query.append("FileName : CgmCodeMgtDBDAOValidationCPSScExptListDataRSQL").append("\n"); 
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
		query.append("SELECT (SELECT A.AR_HD_QTR_OFC_CD AS RHQ_CD" ).append("\n"); 
		query.append("        FROM   MDM_ORGANIZATION A" ).append("\n"); 
		query.append("        WHERE  A.OFC_CD = @[ctrt_ofc_cd]) RHQ_CD," ).append("\n"); 
		query.append("       (SELECT CUST_GRP_NM" ).append("\n"); 
		query.append("        FROM MDM_CUST_PERF_GRP" ).append("\n"); 
		query.append("        WHERE CUST_GRP_ID = @[cust_grp_id]) CUST_GRP_NM," ).append("\n"); 
		query.append("       (SELECT CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("        FROM MDM_CUSTOMER" ).append("\n"); 
		query.append("        WHERE CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("        AND CUST_SEQ = TRANSLATE(@[cust_seq], '0123456789' || @[cust_seq], '0123456789')) CUST_LGL_ENG_NM," ).append("\n"); 
		query.append("       (SELECT SCC_CD" ).append("\n"); 
		query.append("        FROM (SELECT ML.SCC_CD" ).append("\n"); 
		query.append("              FROM MDM_LOCATION ML, MDM_COUNTRY MC, MDM_EQ_ORZ_CHT ME" ).append("\n"); 
		query.append("              WHERE 1 = 1" ).append("\n"); 
		query.append("              AND ML.CNT_CD = MC.CNT_CD(+)" ).append("\n"); 
		query.append("              AND ML.SCC_CD = ME.SCC_CD(+)" ).append("\n"); 
		query.append("              AND NVL(ML.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("              AND NVL(MC.DELT_FLG, 'N') <> 'Y')" ).append("\n"); 
		query.append("        WHERE SCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("        AND ROWNUM = 1) SCC_CD," ).append("\n"); 
		query.append("       (SELECT CASE WHEN COUNT(*) = 1 THEN 'Y' ELSE 'N' END AS DUP" ).append("\n"); 
		query.append("        FROM CGM_CPS_SC_EXPT_LIST" ).append("\n"); 
		query.append("        WHERE EFF_YRMON = @[eff_yrmon]" ).append("\n"); 
		query.append("        AND SC_NO = @[sc_no]" ).append("\n"); 
		query.append("        AND LOC_CD = @[loc_cd]) DUP" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}