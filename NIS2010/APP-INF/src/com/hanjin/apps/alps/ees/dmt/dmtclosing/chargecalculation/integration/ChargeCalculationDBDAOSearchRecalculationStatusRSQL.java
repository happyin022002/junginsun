/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : ChargeCalculationDBDAOSearchRecalculationStatusRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.07.12
*@LastModifier : 
*@LastVersion : 1.0
* 2017.07.12 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeCalculationDBDAOSearchRecalculationStatusRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChargeCalculationDBDAOSearchRecalculationStatusRSQL
	  * </pre>
	  */
	public ChargeCalculationDBDAOSearchRecalculationStatusRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dmdt_chg_loc_div_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dmdt_trf_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration").append("\n"); 
		query.append("FileName : ChargeCalculationDBDAOSearchRecalculationStatusRSQL").append("\n"); 
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
		query.append("SELECT  CASE " ).append("\n"); 
		query.append("			WHEN DMDT_CHG_STS_CD = 'D' THEN 'N'	--// INACT 된 경우, RECALC 불가" ).append("\n"); 
		query.append("            ELSE" ).append("\n"); 
		query.append("				CASE " ).append("\n"); 
		query.append("					WHEN " ).append("\n"); 
		query.append("						(" ).append("\n"); 
		query.append("							SELECT  NVL(MAX(DMDT_DELT_RQST_STS_CD), 'C')" ).append("\n"); 
		query.append("							  FROM  DMT_CHG_DELT_RQST_APRO A" ).append("\n"); 
		query.append("							 WHERE  A.SYS_AREA_GRP_ID     = T1.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("							   AND  A.CNTR_NO             = T1.CNTR_NO" ).append("\n"); 
		query.append("							   AND  A.CNTR_CYC_NO         = T1.CNTR_CYC_NO" ).append("\n"); 
		query.append("							   AND  A.DMDT_TRF_CD         = T1.DMDT_TRF_CD" ).append("\n"); 
		query.append("							   AND  A.DMDT_CHG_LOC_DIV_CD = T1.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("							   AND  A.CHG_SEQ             = T1.CHG_SEQ" ).append("\n"); 
		query.append("							   AND  A.CHG_OFC_CD          = @[ofc_cd]" ).append("\n"); 
		query.append("							   AND  A.DELT_SEQ            =" ).append("\n"); 
		query.append("									(" ).append("\n"); 
		query.append("										SELECT  /*+ INDEX_DESC( B XPKDMT_CHG_DELT_RQST_APRO ) */ DELT_SEQ" ).append("\n"); 
		query.append("										  FROM  DMT_CHG_DELT_RQST_APRO B" ).append("\n"); 
		query.append("										 WHERE  B.SYS_AREA_GRP_ID     = A.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("										   AND  B.CNTR_NO             = A.CNTR_NO" ).append("\n"); 
		query.append("										   AND  B.CNTR_CYC_NO         = A.CNTR_CYC_NO" ).append("\n"); 
		query.append("										   AND  B.DMDT_TRF_CD         = A.DMDT_TRF_CD" ).append("\n"); 
		query.append("										   AND  B.DMDT_CHG_LOC_DIV_CD = A.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("										   AND  B.CHG_SEQ             = A.CHG_SEQ" ).append("\n"); 
		query.append("										   AND  B.CHG_OFC_CD          = A.CHG_OFC_CD" ).append("\n"); 
		query.append("										   AND  ROWNUM                = 1" ).append("\n"); 
		query.append("									)" ).append("\n"); 
		query.append("						) IN ('C', 'E', 'F', 'G') THEN 'Y'		--// INACT REQ. 요청한 이력이 없거나 CANCEL 및 REJECT 한 경우, RECALC 가능 (E : BBG REJECT, F : RHQ REJECT, G : HDO REJECT )" ).append("\n"); 
		query.append("					ELSE" ).append("\n"); 
		query.append("						'N'						--// INACT REQ. 요청한 이력이 있을 경우, RECALC 불가" ).append("\n"); 
		query.append("				END" ).append("\n"); 
		query.append("		END RECALC_YN" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("  FROM  DMT_CHG_CALC T1" ).append("\n"); 
		query.append(" WHERE  T1.SYS_AREA_GRP_ID     = @[svr_id]" ).append("\n"); 
		query.append("   AND  T1.CNTR_NO             = @[cntr_no]" ).append("\n"); 
		query.append("   AND  T1.CNTR_CYC_NO         = @[cntr_cyc_no]" ).append("\n"); 
		query.append("   AND  T1.DMDT_TRF_CD         = @[dmdt_trf_cd]" ).append("\n"); 
		query.append("   AND  T1.DMDT_CHG_LOC_DIV_CD = @[dmdt_chg_loc_div_cd]" ).append("\n"); 
		query.append("   AND  T1.CHG_SEQ             = @[chg_seq]" ).append("\n"); 

	}
}