/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BLIssuanceDBDAOAddBkgEblAvcChgCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.19
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2011.04.19 김태경
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author kim tae kyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAOAddBkgEblAvcChgCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public BLIssuanceDBDAOAddBkgEblAvcChgCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hidden_data",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rate",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ebl_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOAddBkgEblAvcChgCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_EBL_AVC_CHG" ).append("\n"); 
		query.append("	(BKG_NO" ).append("\n"); 
		query.append("	,BL_NO" ).append("\n"); 
		query.append("	,BKG_EBL_SEQ" ).append("\n"); 
		query.append("	,CNTR_SEQ" ).append("\n"); 
		query.append("	,DOC_PARA_NO1" ).append("\n"); 
		query.append("	,DOC_PARA_NO2" ).append("\n"); 
		query.append("	,EBL_CHG_CTNT" ).append("\n"); 
		query.append("	,CHG_NM" ).append("\n"); 
		query.append("	,FRT_TERM_CD" ).append("\n"); 
		query.append("	,RT_INTER_RMK1" ).append("\n"); 
		query.append("	,RT_INTER_RMK2" ).append("\n"); 
		query.append("	,RT_INTER_RMK3" ).append("\n"); 
		query.append("	,RT_INTER_RMK4" ).append("\n"); 
		query.append("	,RT_INTER_RMK5" ).append("\n"); 
		query.append("	,CHG_UT_AMT1" ).append("\n"); 
		query.append("	,CURR_CD1" ).append("\n"); 
		query.append("	,CHG_UT_AMT2" ).append("\n"); 
		query.append("	,CURR_CD2" ).append("\n"); 
		query.append("	,CHG_UT_AMT3" ).append("\n"); 
		query.append("	,CURR_CD3" ).append("\n"); 
		query.append("	,CHG_UT_AMT4" ).append("\n"); 
		query.append("	,CURR_CD4" ).append("\n"); 
		query.append("	,CHG_UT_AMT5" ).append("\n"); 
		query.append("	,CURR_CD5" ).append("\n"); 
		query.append("	,CHG_UT_AMT6" ).append("\n"); 
		query.append("	,CURR_CD6" ).append("\n"); 
		query.append("	,CHG_UT_AMT7" ).append("\n"); 
		query.append("	,CURR_CD7" ).append("\n"); 
		query.append("	,CHG_UT_AMT8" ).append("\n"); 
		query.append("	,CURR_CD8" ).append("\n"); 
		query.append("	,CHG_UT_AMT9" ).append("\n"); 
		query.append("	,CURR_CD9" ).append("\n"); 
		query.append("	,CHG_AMT" ).append("\n"); 
		query.append("	,CURR_CD" ).append("\n"); 
		query.append("	,EBL_RAT_UT_CD" ).append("\n"); 
		query.append("	,EBL_RAT_AS_QTY" ).append("\n"); 
		query.append("	,CURR_CD11" ).append("\n"); 
		query.append("	,IF_FLG" ).append("\n"); 
		query.append("	,CRE_USR_ID" ).append("\n"); 
		query.append("	,CRE_DT" ).append("\n"); 
		query.append("	,UPD_USR_ID" ).append("\n"); 
		query.append("	,UPD_DT" ).append("\n"); 
		query.append("	,RT_INTER_RMK6)" ).append("\n"); 
		query.append("SELECT	R.BKG_NO BKG_NO" ).append("\n"); 
		query.append("	,B.BL_NO BL_NO" ).append("\n"); 
		query.append("	,@[bkg_ebl_seq] BKG_EBL_SEQ" ).append("\n"); 
		query.append("	,ROWNUM CNTR_SEQ" ).append("\n"); 
		query.append("	,R.BKG_NO||LTRIM(TO_CHAR(@[bkg_ebl_seq], '0000')) DOC_PARA_NO1" ).append("\n"); 
		query.append("	,R.BKG_NO||LTRIM(TO_CHAR(@[bkg_ebl_seq], '0000'))||LTRIM(TO_CHAR(ROWNUM, '0000')) DOC_PARA_NO2" ).append("\n"); 
		query.append("	,R.CHG_CD EBL_CHG_CTNT" ).append("\n"); 
		query.append("	,SUBSTR(R.CHG_CD||'  '||R.TRF_ITM_NO ,1,26) CHG_NM" ).append("\n"); 
		query.append("	,R.FRT_TERM_CD FRT_TERM_CD" ).append("\n"); 
		query.append("	,'' RT_INTER_RMK1" ).append("\n"); 
		query.append("	,'' RT_INTER_RMK2" ).append("\n"); 
		query.append("	,'' RT_INTER_RMK3" ).append("\n"); 
		query.append("	,'' RT_INTER_RMK4" ).append("\n"); 
		query.append("	,'' RT_INTER_RMK5" ).append("\n"); 
		query.append("	,R.CHG_AMT CHG_UT_AMT1" ).append("\n"); 
		query.append("	,R.CURR_CD CURR_CD1" ).append("\n"); 
		query.append("	,'' CHG_UT_AMT2" ).append("\n"); 
		query.append("	,'' CURR_CD2" ).append("\n"); 
		query.append("	,'' CHG_UT_AMT3" ).append("\n"); 
		query.append("	,'' CURR_CD3" ).append("\n"); 
		query.append("	,'' CHG_UT_AMT4" ).append("\n"); 
		query.append("	,'' CURR_CD4" ).append("\n"); 
		query.append("	,'' CHG_UT_AMT5" ).append("\n"); 
		query.append("	,'' CURR_CD5" ).append("\n"); 
		query.append("	,'' CHG_UT_AMT6" ).append("\n"); 
		query.append("	,'' CURR_CD6" ).append("\n"); 
		query.append("	,'' CHG_UT_AMT7" ).append("\n"); 
		query.append("	,'' CURR_CD7" ).append("\n"); 
		query.append("	,'' CHG_UT_AMT8" ).append("\n"); 
		query.append("	,'' CURR_CD8" ).append("\n"); 
		query.append("	,'' CHG_UT_AMT9" ).append("\n"); 
		query.append("	,'' CURR_CD9" ).append("\n"); 
		query.append("	,R.CHG_UT_AMT CHG_AMT" ).append("\n"); 
		query.append("	,R.CURR_CD CURR_CD" ).append("\n"); 
		query.append("	,R.RAT_UT_CD EBL_RAT_UT_CD" ).append("\n"); 
		query.append("	,R.RAT_AS_QTY EBL_RAT_AS_QTY" ).append("\n"); 
		query.append("	,'' CURR_CD11" ).append("\n"); 
		query.append("	,'N' IF_FLG" ).append("\n"); 
		query.append("	,@[usr_id] CRE_USR_ID" ).append("\n"); 
		query.append("	,SYSDATE CRE_DT" ).append("\n"); 
		query.append("	,@[usr_id] UPD_USR_ID" ).append("\n"); 
		query.append("	,SYSDATE UPD_DT" ).append("\n"); 
		query.append("	,'' RT_INTER_RMK6" ).append("\n"); 
		query.append("  FROM	BKG_CHG_RT R," ).append("\n"); 
		query.append("        BKG_BOOKING B" ).append("\n"); 
		query.append(" WHERE 	R.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("   AND  R.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND 	FRT_INCL_XCLD_DIV_CD = 'N' " ).append("\n"); 
		query.append("#if (${hidden_data} != '') " ).append("\n"); 
		query.append("   AND 	PRN_HDN_FLG = CASE WHEN 'Y' = @[hidden_data] THEN PRN_HDN_FLG ELSE 'N' END" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rate} != '')   " ).append("\n"); 
		query.append("   AND 	FRT_TERM_CD = CASE @[rate] " ).append("\n"); 
		query.append("            WHEN '1' THEN FRT_TERM_CD   -- Normal " ).append("\n"); 
		query.append("            WHEN '2' THEN FRT_TERM_CD   -- B/L for Audit " ).append("\n"); 
		query.append("            WHEN '3' THEN 'X'           -- FRT ALL as Arranged " ).append("\n"); 
		query.append("            WHEN '4' THEN 'P'           -- FRT CCT as Arranged " ).append("\n"); 
		query.append("            WHEN '5' THEN 'C'           -- FRT PPD as Arranged " ).append("\n"); 
		query.append("            WHEN '6' THEN 'X'           -- No Charge " ).append("\n"); 
		query.append("        END " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" ORDER BY DP_SEQ" ).append("\n"); 

	}
}