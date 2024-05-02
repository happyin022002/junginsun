/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ChargeCalculationDBDAOSearchChargeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.11
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.11 
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

public class ChargeCalculationDBDAOSearchChargeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChargeCalculationDBDAOSearchChargeRSQL
	  * </pre>
	  */
	public ChargeCalculationDBDAOSearchChargeRSQL(){
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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_trf_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration").append("\n"); 
		query.append("FileName : ChargeCalculationDBDAOSearchChargeRSQL").append("\n"); 
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
		query.append("SELECT A.cntr_cyc_no||'|'||A.dmdt_chg_loc_div_cd||'|'||A.CHG_SEQ||'|'||A.OFC_CD||'|'||A.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("       ||'|'||TO_CHAR(A.FM_MVMT_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("       ||'|'||TO_CHAR(A.TO_MVMT_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("       ||'|'||TO_CHAR(A.FT_CMNC_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("       ||'|'||TO_CHAR(A.FT_END_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("       ||'|'||A.BIL_AMT" ).append("\n"); 
		query.append("	   ||'|'||" ).append("\n"); 
		query.append("       ( SELECT COUNT(*) FROM DMT_CHG_DELT_RQST_APRO T1" ).append("\n"); 
		query.append("          WHERE 1=1" ).append("\n"); 
		query.append("            AND  T1.SYS_AREA_GRP_ID       = A.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("            AND  T1.CNTR_NO               = A.CNTR_NO" ).append("\n"); 
		query.append("            AND  T1.CNTR_CYC_NO           = A.CNTR_CYC_NO" ).append("\n"); 
		query.append("            and  T1.DMDT_TRF_CD           = A.DMDT_TRF_CD" ).append("\n"); 
		query.append("            and  T1.DMDT_CHG_LOC_DIV_CD   = A.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("            and  T1.CHG_SEQ               = A.CHG_SEQ " ).append("\n"); 
		query.append("            AND  T1.DMDT_DELT_RQST_STS_CD IN ( 'R','A' ))" ).append("\n"); 
		query.append("		||'|'||A.FM_MVMT_YD_CD" ).append("\n"); 
		query.append("		||'|'||A.TO_MVMT_YD_CD" ).append("\n"); 
		query.append("		||'|'||A.OFC_CD" ).append("\n"); 
		query.append("		||'|'||A.FM_MVMT_STS_CD" ).append("\n"); 
		query.append("		||'|'||A.TO_MVMT_STS_CD" ).append("\n"); 
		query.append("		||'|'||A.ORG_CHG_AMT" ).append("\n"); 
		query.append("       AS rtnValue" ).append("\n"); 
		query.append(" FROM DMT_CHG_CALC A, DMT_CHG_BKG_CNTR B" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND A.SYS_AREA_GRP_ID = B.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("AND A.CNTR_NO = B.CNTR_NO" ).append("\n"); 
		query.append("AND A.CNTR_CYC_NO = B.CNTR_CYC_NO" ).append("\n"); 
		query.append("AND B.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND A.DMDT_TRF_CD = @[dmdt_trf_cd]" ).append("\n"); 
		query.append("AND A.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("AND NOT (A.DUL_TP_EXPT_FLG  = 'Y' AND SUBSTR(A.DMDT_TRF_CD, 1, 1) = 'D')" ).append("\n"); 
		query.append("AND A.DMDT_CHG_LOC_DIV_CD NOT IN ('TSP', 'SZP')" ).append("\n"); 
		query.append("AND A.CHG_SEQ = DECODE(@[chg_type],'G',1, ( SELECT MAX(CHG_SEQ)" ).append("\n"); 
		query.append("                                         FROM DMT_CHG_CALC AA, DMT_CHG_BKG_CNTR BB" ).append("\n"); 
		query.append("                                        WHERE 1=1" ).append("\n"); 
		query.append("                                        AND AA.SYS_AREA_GRP_ID = BB.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("                                        AND AA.CNTR_NO = BB.CNTR_NO" ).append("\n"); 
		query.append("                                        AND AA.CNTR_CYC_NO = BB.CNTR_CYC_NO" ).append("\n"); 
		query.append("                                        AND BB.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                                        AND AA.DMDT_TRF_CD = @[dmdt_trf_cd]" ).append("\n"); 
		query.append("                                        AND AA.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("                                        AND AA.CHG_SEQ != 1 ))" ).append("\n"); 

	}
}