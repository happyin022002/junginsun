/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : OptimumRoutePassDBDAOsearchOptmRoutPassDtlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.08
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2015.05.08 최종혁
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.report.optimumroutepassusa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CJH
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OptimumRoutePassDBDAOsearchOptmRoutPassDtlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Optimum Route Summary에서 선택한 세부사항을 조회한다.
	  * </pre>
	  */
	public OptimumRoutePassDBDAOsearchOptmRoutPassDtlRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("optm_rout_pass_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dscr_rsn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("input_office",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sel_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.report.optimumroutepassusa.integration").append("\n"); 
		query.append("FileName : OptimumRoutePassDBDAOsearchOptmRoutPassDtlRSQL").append("\n"); 
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
		query.append("    DECODE(A.SO_DSCR_RSN_CD, 'M', 'YES', 'NO') AS OPTIMUM_PASS_YN" ).append("\n"); 
		query.append("    ,A.CRE_OFC_CD AS WO_CRE_OFC_CD" ).append("\n"); 
		query.append("    ,DECODE(A.SO_DSCR_RSN_CD, 'D', 'Dest Change', 'I', 'Irregular', 'M', '', 'N', 'No Optimum IRG', 'O', 'Origin Change', 'P', 'Port/TMNL Change'," ).append("\n"); 
		query.append("              'R', 'Route Discrepancy', 'T', 'Transmode Discrepancy') AS SO_DSCR_RSN_CD" ).append("\n"); 
		query.append("    ,A.ROUT_ORG_NOD_CD, A.ROUT_DEST_NOD_CD, (SELECT LOC_NM FROM MDM_LOCATION WHERE LOC_CD=A.POR_DEL_CD) AS POR_DEL_NM" ).append("\n"); 
		query.append("    ,A.BKG_NO, DECODE(A.TRSP_BND_CD, 'O', A.RCV_TERM_CD, A.DE_TERM_CD) AS BKG_TREM" ).append("\n"); 
		query.append("    ,A.BKG_CNTR_QTY, A.ACT_CNTR_QTY, A.TRSP_BND_CD" ).append("\n"); 
		query.append("    ,A.TRSP_CRR_MOD_CTNT, A.RAIL_FM_NOD_CD, A.RAIL_TO_NOD_CD, A.FM_NOD_CD, A.TO_NOD_CD, A.DOR_NOD_CD" ).append("\n"); 
		query.append("    ,REPLACE(A.FCTRY_NM, CHR (13) || CHR (10),' ') AS FCTRY_NM, A.DOR_PST_CD" ).append("\n"); 
		query.append("    ,A.IRG_TRSP_CRR_MOD_CTNT, A.IRG_RAIL_FM_NOD_CD, A.IRG_RAIL_TO_NOD_CD, A.IRG_FM_NOD_CD, A.IRG_TO_NOD_CD, A.IRG_DOR_NOD_CD" ).append("\n"); 
		query.append("    ,A.POR_CD, A.POL_CD, A.POD_CD, A.DEL_CD" ).append("\n"); 
		query.append("    ,(SELECT REPLACE(CUST_NM, CHR (13) || CHR (10),' ') FROM BKG_CUSTOMER WHERE BKG_NO=A.BKG_NO AND BKG_CUST_TP_CD='S') AS SHIP_NM" ).append("\n"); 
		query.append("    ,(SELECT REPLACE(CUST_NM, CHR (13) || CHR (10),' ') FROM BKG_CUSTOMER WHERE BKG_NO=A.BKG_NO AND BKG_CUST_TP_CD='C') AS CNEE_NM" ).append("\n"); 
		query.append("    , @[input_office]     QRY_OFC_CD " ).append("\n"); 
		query.append("FROM TRS_TRSP_OPTM_USA_ROUT A" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if(${sel_date} == 'inv')" ).append("\n"); 
		query.append("    AND A.INV_CFM_DT BETWEEN TO_DATE(REPLACE(@[from_date],'-',''), 'YYYYMMDD')" ).append("\n"); 
		query.append("                          AND TO_DATE(REPLACE(@[to_date],'-',''), 'YYYYMMDD') + 0.999999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${sel_date} == 'wo')" ).append("\n"); 
		query.append("    AND A.WO_ISS_DT BETWEEN TO_DATE(REPLACE(@[from_date],'-',''), 'YYYYMMDD')" ).append("\n"); 
		query.append("                          AND TO_DATE(REPLACE(@[to_date],'-',''), 'YYYYMMDD') + 0.999999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	AND	A.SO_DSCR_RSN_CD IN (" ).append("\n"); 
		query.append("								SELECT	INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("								FROM	COM_INTG_CD_DTL" ).append("\n"); 
		query.append("								WHERE	INTG_CD_ID = 'CD03059'" ).append("\n"); 
		query.append("								AND		(  " ).append("\n"); 
		query.append("												(@[optm_rout_pass_flg] = 'A' AND (@[dscr_rsn_cd] = 'A' OR INSTR(@[dscr_rsn_cd], INTG_CD_VAL_CTNT) > 0)) -- ALL/ALL" ).append("\n"); 
		query.append("											OR	(@[optm_rout_pass_flg] = 'Y' AND INTG_CD_VAL_CTNT = 'M') -- Optimum Route일 경우 세부는 무시" ).append("\n"); 
		query.append("											OR	(@[optm_rout_pass_flg] = 'N' AND INTG_CD_VAL_CTNT <> 'M' AND (@[dscr_rsn_cd] = 'A' OR INSTR(@[dscr_rsn_cd], INTG_CD_VAL_CTNT) > 0))" ).append("\n"); 
		query.append("										)" ).append("\n"); 
		query.append("							)" ).append("\n"); 
		query.append("#if (${sel_op_tp} == 'SINGLE')" ).append("\n"); 
		query.append("    AND A.TRSP_BND_CD = @[bnd_cd]" ).append("\n"); 
		query.append("    AND A.CRE_OFC_CD IN (SELECT COLUMN_VALUE FROM TABLE(BKG_SPLIT_FNC(@[input_office], ',')))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sel_op_tp} != 'SINGLE')" ).append("\n"); 
		query.append("			AND	(A.CRE_OFC_CD, A.TRSP_BND_CD)" ).append("\n"); 
		query.append("				IN (" ).append("\n"); 
		query.append("			  #foreach ($user_condtions IN ${condtions})" ).append("\n"); 
		query.append("				#if($velocityCount < $condtions.size())" ).append("\n"); 
		query.append("				  $user_condtions," ).append("\n"); 
		query.append("				#else" ).append("\n"); 
		query.append("				  $user_condtions" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${sel_bkg_no} != '') " ).append("\n"); 
		query.append("    AND A.BKG_NO = @[sel_bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    AND A.RSLT_FLG = 'Y'" ).append("\n"); 
		query.append("    AND A.DELT_FLG = 'N'" ).append("\n"); 

	}
}