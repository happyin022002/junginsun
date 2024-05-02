/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RuLabelManagementDBDAOsearchRuLabelAttachmentListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.10.27
*@LastModifier : 
*@LastVersion : 1.0
* 2016.10.27 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mst.ruLabelmanagement.ruLabelmanagement.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RuLabelManagementDBDAOsearchRuLabelAttachmentListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RU Label Attachment / Detachment 조회
	  * </pre>
	  */
	public RuLabelManagementDBDAOsearchRuLabelAttachmentListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_ru_label_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_lot_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_auth_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("startno",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lot_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_cntr_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lot_pln_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lot_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_agmt_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_spec_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("endno",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mst.ruLabelmanagement.ruLabelmanagement.integration").append("\n"); 
		query.append("FileName : RuLabelManagementDBDAOsearchRuLabelAttachmentListRSQL").append("\n"); 
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
		query.append("SELECT SUB.ROW_SEQ" ).append("\n"); 
		query.append("     , SUB.CNTR_NO" ).append("\n"); 
		query.append("     , SUB.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("     , SUB.AGMT_NO" ).append("\n"); 
		query.append("     , SUB.LESSOR" ).append("\n"); 
		query.append("     , SUB.LESSOR_NM" ).append("\n"); 
		query.append("     , SUB.CNTR_AUTH_NO" ).append("\n"); 
		query.append("     , SUB.RU_LABEL_TYPE" ).append("\n"); 
		query.append("     , SUB.RU_LABEL_VALUE" ).append("\n"); 
		query.append("     , SUB.HIS_RU_LABEL_VALUE" ).append("\n"); 
		query.append("     , SUB.REMARK" ).append("\n"); 
		query.append("     , SUB.CNMV_YR" ).append("\n"); 
		query.append("     , SUB.CNMV_ID_NO" ).append("\n"); 
		query.append("     , SUB.CNMV_SEQ" ).append("\n"); 
		query.append("     , SUB.CNMV_SPLIT_NO" ).append("\n"); 
		query.append("     , SUB.CRE_DT" ).append("\n"); 
		query.append("     , SUB.CRE_USR_ID" ).append("\n"); 
		query.append("     , SUB.UPD_DT" ).append("\n"); 
		query.append("     , SUB.UPD_USR_ID" ).append("\n"); 
		query.append("     , (SELECT  LA.LSE_CTRT_NO" ).append("\n"); 
		query.append("          FROM LSE_AGREEMENT LA" ).append("\n"); 
		query.append("         WHERE LA.AGMT_CTY_CD = SUB.AGMT_CTY_CD" ).append("\n"); 
		query.append("             AND LA.AGMT_SEQ    = SUB.AGMT_SEQ" ).append("\n"); 
		query.append("             AND ROWNUM         = 1) AS LSE_CTRT_NO" ).append("\n"); 
		query.append("      , SUB.CRNT_YD_CD" ).append("\n"); 
		query.append("      , SUB.CNMV_STS_CD" ).append("\n"); 
		query.append("      , SUB.CNMV_DT" ).append("\n"); 
		query.append("      , SUB.FULL_FLG" ).append("\n"); 
		query.append("      , SUB.CNTR_STS_CD" ).append("\n"); 
		query.append("      , SUB.MFTR_VNDR_SEQ" ).append("\n"); 
		query.append("      , (SELECT MV.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("          FROM MDM_VENDOR MV" ).append("\n"); 
		query.append("        WHERE SUB.MFTR_VNDR_SEQ = MV.VNDR_SEQ" ).append("\n"); 
		query.append("           AND ROWNUM               = 1) MFTR_VNDR_NM" ).append("\n"); 
		query.append("      , SUB.MFT_DT" ).append("\n"); 
		query.append("      , SUB.RF_MKR_SEQ" ).append("\n"); 
		query.append("      , (SELECT MV.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("          FROM MDM_VENDOR MV" ).append("\n"); 
		query.append("        WHERE SUB.RF_MKR_SEQ = MV.VNDR_SEQ" ).append("\n"); 
		query.append("           AND ROWNUM               = 1) RF_MKR_NM     " ).append("\n"); 
		query.append("      , SUB.RF_MDL_NM" ).append("\n"); 
		query.append("      , SUB.LSTM_CD  " ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT  ROW_NUMBER() OVER (ORDER BY  MC.CNTR_NO, MH.RSTR_USG_TP_CD, MH.RSTR_USG_LBL_NM, MH.CRE_DT, MH.UPD_DT) AS ROW_SEQ" ).append("\n"); 
		query.append("		, MC.CNTR_NO AS CNTR_NO" ).append("\n"); 
		query.append("        , MC.CNTR_TPSZ_CD AS CNTR_TPSZ_CD" ).append("\n"); 
		query.append("        , MC.AGMT_CTY_CD|| LTRIM(TO_CHAR(MC.AGMT_SEQ,'000000')) AS AGMT_NO" ).append("\n"); 
		query.append("        , MC.VNDR_SEQ  AS LESSOR" ).append("\n"); 
		query.append("        , (SELECT B.VNDR_LGL_ENG_NM FROM MDM_VENDOR B WHERE MC.VNDR_SEQ = B.VNDR_SEQ) AS LESSOR_NM" ).append("\n"); 
		query.append("        , MC.CNTR_AUTH_NO AS CNTR_AUTH_NO" ).append("\n"); 
		query.append("        , MH.RSTR_USG_TP_CD  AS RU_LABEL_TYPE" ).append("\n"); 
		query.append("        , MH.RSTR_USG_LBL_NM AS RU_LABEL_VALUE " ).append("\n"); 
		query.append("        , MH.RSTR_USG_LBL_NM AS HIS_RU_LABEL_VALUE" ).append("\n"); 
		query.append("        , MH.CNTR_RMK AS REMARK" ).append("\n"); 
		query.append("        , MC.CNMV_YR   AS CNMV_YR              " ).append("\n"); 
		query.append("        , MC.CNMV_ID_NO        AS CNMV_ID_NO    " ).append("\n"); 
		query.append("        , MC.CNMV_SEQ           AS CNMV_SEQ     " ).append("\n"); 
		query.append("        , MC.CNMV_SPLIT_NO    AS CNMV_SPLIT_NO        " ).append("\n"); 
		query.append("        , TO_CHAR(MH.CRE_DT, 'YYYY-MM-DD HH24:MI:SS') AS CRE_DT" ).append("\n"); 
		query.append("        , MH.CRE_USR_ID AS CRE_USR_ID" ).append("\n"); 
		query.append("        , TO_CHAR(MH.UPD_DT, 'YYYY-MM-DD HH24:MI:SS') AS UPD_DT" ).append("\n"); 
		query.append("        , MH.UPD_USR_ID AS UPD_USR_ID" ).append("\n"); 
		query.append("        , MC.AGMT_CTY_CD" ).append("\n"); 
		query.append("        , MC.AGMT_SEQ" ).append("\n"); 
		query.append("        , MC.CRNT_YD_CD" ).append("\n"); 
		query.append("        , MC.CNMV_STS_CD" ).append("\n"); 
		query.append("        , TO_CHAR(MC.CNMV_DT, 'YYYY-MM-DD HH24:MI') AS CNMV_DT" ).append("\n"); 
		query.append("        , DECODE(MC.FULL_FLG, 'Y', 'F', 'M') AS FULL_FLG" ).append("\n"); 
		query.append("        , MC.CNTR_STS_CD" ).append("\n"); 
		query.append("        , MC.MFTR_VNDR_SEQ" ).append("\n"); 
		query.append("        , TO_CHAR(MC.MFT_DT, 'YYYY-MM-DD') AS MFT_DT" ).append("\n"); 
		query.append("        , DECODE(MC.RF_MKR_SEQ, 0, NULL, MC.RF_MKR_SEQ) RF_MKR_SEQ" ).append("\n"); 
		query.append("        , MC.RF_MDL_NM" ).append("\n"); 
		query.append("        , MC.LSTM_CD" ).append("\n"); 
		query.append("FROM (       " ).append("\n"); 
		query.append("            SELECT HIS.CNTR_NO" ).append("\n"); 
		query.append("                   ,  HIS.RSTR_USG_TP_CD AS RSTR_USG_TP_CD" ).append("\n"); 
		query.append("                   ,  MAX(HIS.RSTR_USG_HIS_SEQ) AS RSTR_USG_HIS_SEQ" ).append("\n"); 
		query.append("                   ,  SUBSTR(MAX(TO_CHAR(HIS.RSTR_USG_HIS_SEQ, '000000000')||TRIM(HIS.RSTR_USG_UPD_TP_CD)), 11, 1) CHK_FLG" ).append("\n"); 
		query.append("            FROM MST_CNTR_RSTR_USG_HIS HIS" ).append("\n"); 
		query.append("            GROUP BY HIS.CNTR_NO, HIS.RSTR_USG_TP_CD ) SUB" ).append("\n"); 
		query.append("      , MST_CONTAINER MC" ).append("\n"); 
		query.append("      , MST_CNTR_RSTR_USG_HIS MH" ).append("\n"); 
		query.append("WHERE SUB.CNTR_NO  = MC.CNTR_NO" ).append("\n"); 
		query.append("AND    SUB.CNTR_NO  = MH.CNTR_NO" ).append("\n"); 
		query.append("AND    SUB.RSTR_USG_HIS_SEQ = MH.RSTR_USG_HIS_SEQ" ).append("\n"); 
		query.append("AND    SUB.CHK_FLG    != 'D'" ).append("\n"); 
		query.append("AND (RSTR_USG_TP_LBL_NM1 IS NOT NULL" ).append("\n"); 
		query.append("     OR RSTR_USG_TP_LBL_NM2 IS NOT NULL" ).append("\n"); 
		query.append("     OR RSTR_USG_TP_LBL_NM3 IS NOT NULL" ).append("\n"); 
		query.append("     OR RSTR_USG_TP_LBL_NM4 IS NOT NULL" ).append("\n"); 
		query.append("     OR RSTR_USG_TP_LBL_NM5 IS NOT NULL" ).append("\n"); 
		query.append("     OR RSTR_USG_TP_LBL_NM6 IS NOT NULL" ).append("\n"); 
		query.append("     OR RSTR_USG_TP_LBL_NM7 IS NOT NULL" ).append("\n"); 
		query.append("     OR RSTR_USG_TP_LBL_NM8 IS NOT NULL" ).append("\n"); 
		query.append("     OR RSTR_USG_TP_LBL_NM9 IS NOT NULL" ).append("\n"); 
		query.append("     OR RSTR_USG_TP_LBL_NM10 IS NOT NULL" ).append("\n"); 
		query.append("     OR RSTR_USG_TP_LBL_NM11 IS NOT NULL" ).append("\n"); 
		query.append("     OR RSTR_USG_TP_LBL_NM12 IS NOT NULL" ).append("\n"); 
		query.append("     OR RSTR_USG_TP_LBL_NM13 IS NOT NULL" ).append("\n"); 
		query.append("     OR RSTR_USG_TP_LBL_NM14 IS NOT NULL" ).append("\n"); 
		query.append("     OR RSTR_USG_TP_LBL_NM15 IS NOT NULL)" ).append("\n"); 
		query.append("#if (${cntr_list} != '')" ).append("\n"); 
		query.append("AND     MC.CNTR_NO IN (" ).append("\n"); 
		query.append("    #foreach ($key IN ${cntr_list})" ).append("\n"); 
		query.append("        #if($velocityCount < $cntr_list.size())" ).append("\n"); 
		query.append("            '$key'," ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("            '$key'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("    #end                          " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${s_tp_cd} != '') " ).append("\n"); 
		query.append("AND MC.CNTR_TPSZ_CD IN ( " ).append("\n"); 
		query.append("    SELECT COLUMN_VALUE" ).append("\n"); 
		query.append("    FROM TABLE ( SELECT cast( CIM_IN_LIST_FNC( @[s_tp_cd] ) AS listItemType ) " ).append("\n"); 
		query.append("    FROM dual )" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${s_agmt_seq} != '')" ).append("\n"); 
		query.append("AND MC.AGMT_CTY_CD = @[s_agmt_cty_cd]" ).append("\n"); 
		query.append("AND MC.AGMT_SEQ   = @[s_agmt_seq]" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${s_multi_agmt_seq} != '') " ).append("\n"); 
		query.append("AND     MC.AGMT_SEQ IN (" ).append("\n"); 
		query.append("    #foreach ($key IN ${agmtseq_list})" ).append("\n"); 
		query.append("        #if($velocityCount < $agmtseq_list.size())" ).append("\n"); 
		query.append("            '$key'," ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("            '$key'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("    #end                          " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${s_auth_no} != '')" ).append("\n"); 
		query.append("AND MC.CNTR_AUTH_NO    Like '%' || @[s_auth_no] || '%'" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${s_ru_label_type} != '') " ).append("\n"); 
		query.append("AND MH.RSTR_USG_TP_CD = @[s_ru_label_type]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${s_ru_label_value} != '') " ).append("\n"); 
		query.append("AND     MH.RSTR_USG_LBL_NM IN (" ).append("\n"); 
		query.append("    #foreach ($key IN ${labelvalue_list})" ).append("\n"); 
		query.append("        #if($velocityCount < $labelvalue_list.size())" ).append("\n"); 
		query.append("            '$key'," ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("            '$key'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("    #end                          " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cntr_spec_no} != '')" ).append("\n"); 
		query.append("AND MC.CNTR_SPEC_NO    = @[cntr_spec_no]" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${s_cntr_sts_cd} != '') " ).append("\n"); 
		query.append("AND     MC.CNTR_STS_CD IN (" ).append("\n"); 
		query.append("    SELECT COLUMN_VALUE" ).append("\n"); 
		query.append("    FROM TABLE ( SELECT cast( CIM_IN_LIST_FNC( @[s_cntr_sts_cd] ) AS listItemType ) " ).append("\n"); 
		query.append("    FROM dual )                     " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${lot_no} != '')" ).append("\n"); 
		query.append("AND MC.CNTR_TPSZ_CD = @[cntr_lot_tpsz_cd]" ).append("\n"); 
		query.append("AND MC.LOT_PLN_YR   = @[lot_pln_yr]" ).append("\n"); 
		query.append("AND MC.LOT_LOC_CD   = @[lot_loc_cd]" ).append("\n"); 
		query.append("AND MC.LOT_SEQ      = @[lot_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") SUB" ).append("\n"); 
		query.append("#if (${startno} != '') " ).append("\n"); 
		query.append("  WHERE 	ROW_SEQ BETWEEN @[startno] AND @[endno]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}