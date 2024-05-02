/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RuLabelManagementDBDAOtotalCntRuLabelAttachmentListRSQL.java
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

public class RuLabelManagementDBDAOtotalCntRuLabelAttachmentListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RU Label Attachment Detachment 총갯수
	  * </pre>
	  */
	public RuLabelManagementDBDAOtotalCntRuLabelAttachmentListRSQL(){
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
		params.put("s_auth_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("lot_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("s_cntr_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("s_agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mst.ruLabelmanagement.ruLabelmanagement.integration").append("\n"); 
		query.append("FileName : RuLabelManagementDBDAOtotalCntRuLabelAttachmentListRSQL").append("\n"); 
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
		query.append("SELECT      COUNT(*) TOTAL_CNT " ).append("\n"); 
		query.append("        FROM" ).append("\n"); 
		query.append("		(" ).append("\n"); 
		query.append("SELECT    CNTR_NO" ).append("\n"); 
		query.append("        , CNTR_TPSZ_CD" ).append("\n"); 
		query.append("        , AGMT_NO" ).append("\n"); 
		query.append("        , LESSOR" ).append("\n"); 
		query.append("        , LESSOR_NM" ).append("\n"); 
		query.append("        , CNTR_AUTH_NO" ).append("\n"); 
		query.append("        , RU_LABEL_TYPE" ).append("\n"); 
		query.append("        , RU_LABEL_VALUE" ).append("\n"); 
		query.append("        , RU_LABEL_VALUE AS HIS_RU_LABEL_VALUE" ).append("\n"); 
		query.append("        , REMARK" ).append("\n"); 
		query.append("        , CNMV_YR                 " ).append("\n"); 
		query.append("        , CNMV_ID_NO              " ).append("\n"); 
		query.append("        , CNMV_SEQ                " ).append("\n"); 
		query.append("        , CNMV_SPLIT_NO  " ).append("\n"); 
		query.append("        , CRE_DT" ).append("\n"); 
		query.append("        , CRE_USR_ID" ).append("\n"); 
		query.append("        , UPD_DT" ).append("\n"); 
		query.append("        , UPD_USR_ID" ).append("\n"); 
		query.append("  FROM " ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("          SELECT  A.CNTR_NO" ).append("\n"); 
		query.append("                , A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                , A.AGMT_CTY_CD|| LTRIM(TO_CHAR(A.AGMT_SEQ,'000000')) AGMT_NO" ).append("\n"); 
		query.append("                , A.VNDR_SEQ  AS LESSOR" ).append("\n"); 
		query.append("                , (SELECT VNDR_LGL_ENG_NM FROM MDM_VENDOR B WHERE A.VNDR_SEQ = B.VNDR_SEQ) AS LESSOR_NM" ).append("\n"); 
		query.append("                , A.CNTR_AUTH_NO" ).append("\n"); 
		query.append("                , B.RSTR_USG_TP_CD  AS RU_LABEL_TYPE" ).append("\n"); 
		query.append("                , B.RSTR_USG_LBL_NM AS RU_LABEL_VALUE " ).append("\n"); 
		query.append("                , B.CNTR_RMK AS REMARK" ).append("\n"); 
		query.append("                , A.CNMV_YR                 " ).append("\n"); 
		query.append("                , A.CNMV_ID_NO              " ).append("\n"); 
		query.append("                , A.CNMV_SEQ                " ).append("\n"); 
		query.append("                , A.CNMV_SPLIT_NO           " ).append("\n"); 
		query.append("                , TO_CHAR(B.CRE_DT, 'YYYY-MM-DD HH24:MI:SS') CRE_DT" ).append("\n"); 
		query.append("                , B.CRE_USR_ID" ).append("\n"); 
		query.append("                , TO_CHAR(B.UPD_DT, 'YYYY-MM-DD HH24:MI:SS') UPD_DT" ).append("\n"); 
		query.append("                , B.UPD_USR_ID    " ).append("\n"); 
		query.append("            FROM MST_CONTAINER A, " ).append("\n"); 
		query.append("                 (" ).append("\n"); 
		query.append("                  SELECT   MC.CNTR_NO, MC.RSTR_USG_TP_CD, MCR.RSTR_USG_LBL_NM, MCR.CNTR_RMK" ).append("\n"); 
		query.append("                         , MC.CNTR_TPSZ_CD, MC.AGMT_CTY_CD, MC.AGMT_SEQ " ).append("\n"); 
		query.append("                         , MC.CNTR_AUTH_NO, MC.HIS_SEQ, MC.CHK_FLG" ).append("\n"); 
		query.append("                         , MMCR.CRE_DT" ).append("\n"); 
		query.append("                         , MMCR.CRE_USR_ID" ).append("\n"); 
		query.append("                         , MCR.UPD_DT" ).append("\n"); 
		query.append("                         , MCR.UPD_USR_ID " ).append("\n"); 
		query.append("                    FROM (" ).append("\n"); 
		query.append("                            SELECT   SMC.CNTR_NO" ).append("\n"); 
		query.append("                                   , SMCR.RSTR_USG_TP_CD" ).append("\n"); 
		query.append("                                   , SMC.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                   , SMC.AGMT_CTY_CD, SMC.AGMT_SEQ" ).append("\n"); 
		query.append("                                   , SMC.CNTR_AUTH_NO" ).append("\n"); 
		query.append("                                   , SMC.CNTR_STS_CD" ).append("\n"); 
		query.append("                                   , MAX(SMCR.RSTR_USG_HIS_SEQ) HIS_SEQ" ).append("\n"); 
		query.append("                                   , MIN(SMCR.RSTR_USG_HIS_SEQ) MIN_SEQ" ).append("\n"); 
		query.append("                                   , SUBSTR(MAX(TO_CHAR(SMCR.RSTR_USG_HIS_SEQ, '000000000')||TRIM(SMCR.RSTR_USG_UPD_TP_CD)), 11, 1) CHK_FLG" ).append("\n"); 
		query.append("                              FROM  (" ).append("\n"); 
		query.append("                                       SELECT *" ).append("\n"); 
		query.append("                                         FROM MST_CONTAINER " ).append("\n"); 
		query.append("                                        WHERE 1=1" ).append("\n"); 
		query.append("                                          AND (RSTR_USG_TP_LBL_NM1 IS NOT NULL" ).append("\n"); 
		query.append("                                               OR RSTR_USG_TP_LBL_NM2 IS NOT NULL" ).append("\n"); 
		query.append("                                               OR RSTR_USG_TP_LBL_NM3 IS NOT NULL" ).append("\n"); 
		query.append("                                               OR RSTR_USG_TP_LBL_NM4 IS NOT NULL" ).append("\n"); 
		query.append("                                               OR RSTR_USG_TP_LBL_NM5 IS NOT NULL" ).append("\n"); 
		query.append("                                               OR RSTR_USG_TP_LBL_NM6 IS NOT NULL" ).append("\n"); 
		query.append("                                               OR RSTR_USG_TP_LBL_NM7 IS NOT NULL" ).append("\n"); 
		query.append("                                               OR RSTR_USG_TP_LBL_NM8 IS NOT NULL" ).append("\n"); 
		query.append("                                               OR RSTR_USG_TP_LBL_NM9 IS NOT NULL" ).append("\n"); 
		query.append("                                               OR RSTR_USG_TP_LBL_NM10 IS NOT NULL" ).append("\n"); 
		query.append("                                               OR RSTR_USG_TP_LBL_NM11 IS NOT NULL" ).append("\n"); 
		query.append("                                               OR RSTR_USG_TP_LBL_NM12 IS NOT NULL" ).append("\n"); 
		query.append("                                               OR RSTR_USG_TP_LBL_NM13 IS NOT NULL" ).append("\n"); 
		query.append("                                               OR RSTR_USG_TP_LBL_NM14 IS NOT NULL" ).append("\n"); 
		query.append("                                               OR RSTR_USG_TP_LBL_NM15 IS NOT NULL)" ).append("\n"); 
		query.append("                                     ) SMC" ).append("\n"); 
		query.append("                                  , MST_CNTR_RSTR_USG_HIS SMCR" ).append("\n"); 
		query.append("                             WHERE 1=1" ).append("\n"); 
		query.append("                               AND SMC.CNTR_NO = SMCR.CNTR_NO" ).append("\n"); 
		query.append("                             GROUP BY  SMC.CNTR_NO, SMCR.RSTR_USG_TP_CD" ).append("\n"); 
		query.append("                                     , SMC.CNTR_TPSZ_CD, SMC.AGMT_CTY_CD, SMC.AGMT_SEQ" ).append("\n"); 
		query.append("                                     , SMC.CNTR_AUTH_NO, SMC.CNTR_STS_CD" ).append("\n"); 
		query.append("                          ) MC, MST_CNTR_RSTR_USG_HIS MCR, MST_CNTR_RSTR_USG_HIS MMCR" ).append("\n"); 
		query.append("                   WHERE 1=1" ).append("\n"); 
		query.append("                     AND MC.CNTR_NO = MCR.CNTR_NO" ).append("\n"); 
		query.append("                     AND MC.HIS_SEQ = MCR.RSTR_USG_HIS_SEQ" ).append("\n"); 
		query.append("                     AND MC.CNTR_NO = MMCR.CNTR_NO(+)" ).append("\n"); 
		query.append("                     AND MC.MIN_SEQ = MMCR.RSTR_USG_HIS_SEQ(+)                  " ).append("\n"); 
		query.append("                     AND MC.CHK_FLG !='D'" ).append("\n"); 
		query.append("                     " ).append("\n"); 
		query.append("                    #if (${cntr_list} != '')" ).append("\n"); 
		query.append("                        AND	MC.CNTR_NO IN (" ).append("\n"); 
		query.append("                            #foreach ($key IN ${cntr_list})" ).append("\n"); 
		query.append("                                #if($velocityCount < $cntr_list.size())" ).append("\n"); 
		query.append("                                    '$key'," ).append("\n"); 
		query.append("                                #else" ).append("\n"); 
		query.append("                                    '$key'" ).append("\n"); 
		query.append("                                #end" ).append("\n"); 
		query.append("                            #end			  " ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                    #if (${s_tp_cd} != '') " ).append("\n"); 
		query.append("                        AND MC.CNTR_TPSZ_CD IN ( " ).append("\n"); 
		query.append("                            SELECT COLUMN_VALUE" ).append("\n"); 
		query.append("                            FROM TABLE ( SELECT cast( CIM_IN_LIST_FNC( @[s_tp_cd] ) AS listItemType ) " ).append("\n"); 
		query.append("                            FROM dual )" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                    #if (${s_cntr_sts_cd} != '') " ).append("\n"); 
		query.append("                       AND     MC.CNTR_STS_CD IN (" ).append("\n"); 
		query.append("                               SELECT COLUMN_VALUE" ).append("\n"); 
		query.append("                                 FROM TABLE ( SELECT cast( CIM_IN_LIST_FNC( @[s_cntr_sts_cd] ) AS listItemType ) " ).append("\n"); 
		query.append("                                                FROM dual )                     " ).append("\n"); 
		query.append("                       )" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                    #if (${s_agmt_seq} != '')" ).append("\n"); 
		query.append("                        AND MC.AGMT_CTY_CD = @[s_agmt_cty_cd]" ).append("\n"); 
		query.append("                        AND MC.AGMT_SEQ   = @[s_agmt_seq]" ).append("\n"); 
		query.append("                    #end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("					#if (${s_multi_agmt_seq} != '') " ).append("\n"); 
		query.append("						AND     MC.AGMT_SEQ IN (" ).append("\n"); 
		query.append("						    #foreach ($key IN ${agmtseq_list})" ).append("\n"); 
		query.append("						        #if($velocityCount < $agmtseq_list.size())" ).append("\n"); 
		query.append("					    	        '$key'," ).append("\n"); 
		query.append("						        #else" ).append("\n"); 
		query.append("						            '$key'" ).append("\n"); 
		query.append("						        #end" ).append("\n"); 
		query.append("						    #end                          " ).append("\n"); 
		query.append("						)" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                    #if (${s_auth_no} != '')" ).append("\n"); 
		query.append("                        AND MC.CNTR_AUTH_NO    Like '%' || @[s_auth_no] || '%'" ).append("\n"); 
		query.append("                    #end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("					" ).append("\n"); 
		query.append("                     " ).append("\n"); 
		query.append("                    #if (${s_ru_label_type} != '') " ).append("\n"); 
		query.append("                        AND MC.RSTR_USG_TP_CD = @[s_ru_label_type]" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                    #if (${s_ru_label_value} != '') " ).append("\n"); 
		query.append("                        AND	MCR.RSTR_USG_LBL_NM IN (" ).append("\n"); 
		query.append("                            #foreach ($key IN ${labelvalue_list})" ).append("\n"); 
		query.append("                                #if($velocityCount < $labelvalue_list.size())" ).append("\n"); 
		query.append("                                    '$key'," ).append("\n"); 
		query.append("                                #else" ).append("\n"); 
		query.append("                                    '$key'" ).append("\n"); 
		query.append("                                #end" ).append("\n"); 
		query.append("                            #end			  " ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                 ) B" ).append("\n"); 
		query.append("           WHERE 1=1" ).append("\n"); 
		query.append("             AND A.CNTR_NO = B.CNTR_NO" ).append("\n"); 
		query.append("			#if (${cntr_spec_no} != '')" ).append("\n"); 
		query.append("               AND A.CNTR_SPEC_NO    = @[cntr_spec_no]" ).append("\n"); 
		query.append("            #end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			#if (${lot_no} != '')" ).append("\n"); 
		query.append("				AND A.CNTR_TPSZ_CD = @[cntr_lot_tpsz_cd]" ).append("\n"); 
		query.append("             	AND A.LOT_PLN_YR   = @[lot_pln_yr]" ).append("\n"); 
		query.append("             	AND A.LOT_LOC_CD   = @[lot_loc_cd]" ).append("\n"); 
		query.append("             	AND A.LOT_SEQ      = @[lot_seq]" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("        ) Z" ).append("\n"); 
		query.append("  WHERE 1=1" ).append("\n"); 
		query.append("    AND RU_LABEL_VALUE IS NOT NULL" ).append("\n"); 
		query.append("  )" ).append("\n"); 

	}
}