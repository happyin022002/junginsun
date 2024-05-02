/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : PartnerLinesDangerousCargoApprovalDBDAOPreRestrictionLQRegulatoryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.12
*@LastModifier : KIM HYUN HWA
*@LastVersion : 1.0
* 2013.06.12 KIM HYUN HWA
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author ISD1
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PartnerLinesDangerousCargoApprovalDBDAOPreRestrictionLQRegulatoryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PreRestrictionLQRegulatory
	  * </pre>
	  */
	public PartnerLinesDangerousCargoApprovalDBDAOPreRestrictionLQRegulatoryRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_un_no_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("grs_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("net_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("out_imdg_pck_qty1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("grs_capa_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_un_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_imdg_pck_qty1",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.integration").append("\n"); 
		query.append("FileName : PartnerLinesDangerousCargoApprovalDBDAOPreRestrictionLQRegulatoryRSQL").append("\n"); 
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
		query.append("SELECT 'Limited Q'||''''||'TY' DIV_NM" ).append("\n"); 
		query.append("      ,CASE WHEN IMDG_LMT_QTY > 0 THEN IMDG_LMT_QTY||' '||IMDG_LMT_QTY_MEAS_UT_CD " ).append("\n"); 
		query.append("            ELSE '0'" ).append("\n"); 
		query.append("       END REGU_VAL" ).append("\n"); 
		query.append("      ,'Max Weight' MAX_WGT_NM" ).append("\n"); 
		query.append("#if(${in_imdg_pck_qty1} != '' || ${in_imdg_pck_cd1} != '')" ).append("\n"); 
		query.append("      ,CASE WHEN TO_NUMBER(@[grs_wgt])/TO_NUMBER(@[out_imdg_pck_qty1]) > 30 THEN 'Invaild'" ).append("\n"); 
		query.append("			WHEN IMDG_LMT_QTY_MEAS_UT_CD = 'L' THEN" ).append("\n"); 
		query.append("	#if(${grs_capa_qty} != '')" ).append("\n"); 
		query.append("              CASE WHEN IMDG_LMT_QTY < TO_NUMBER(@[grs_capa_qty])/TO_NUMBER(@[in_imdg_pck_qty1]) THEN 'Invalid'" ).append("\n"); 
		query.append("              ELSE 'Valid' END" ).append("\n"); 
		query.append("    #elseif(${net_wgt} != '')" ).append("\n"); 
		query.append("              CASE WHEN IMDG_LMT_QTY < TO_NUMBER(@[net_wgt])/TO_NUMBER(@[in_imdg_pck_qty1]) THEN 'Invalid'" ).append("\n"); 
		query.append("              ELSE 'Valid' END" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("			'Invalid'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("            WHEN IMDG_LMT_QTY_MEAS_UT_CD = 'KG' THEN" ).append("\n"); 
		query.append("	#if(${net_wgt} != '')" ).append("\n"); 
		query.append("              CASE WHEN IMDG_LMT_QTY < TO_NUMBER(@[net_wgt])/TO_NUMBER(@[in_imdg_pck_qty1]) THEN 'Invalid'" ).append("\n"); 
		query.append("              ELSE 'Valid' END" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("			'Invalid'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("            WHEN IMDG_LMT_QTY_MEAS_UT_CD IS NULL THEN 'Invalid'" ).append("\n"); 
		query.append("            END MAX_WGT_RSLT" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("      ,'Invalid' MAX_WGT_RSLT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      ,'PKG Type' PKG_TP_NM" ).append("\n"); 
		query.append("      ,'N/A' PKG_TP_RSLT" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("       SELECT IMDG_UN_NO" ).append("\n"); 
		query.append("             ,CASE WHEN IMDG_LMT_QTY_MEAS_UT_CD IN ('MLG', 'ML', 'G' )" ).append("\n"); 
		query.append("                   THEN TO_CHAR(IMDG_LMT_QTY/1000, '9990.99')" ).append("\n"); 
		query.append("              ELSE TO_CHAR(IMDG_LMT_QTY) END IMDG_LMT_QTY" ).append("\n"); 
		query.append("             ,CASE WHEN IMDG_LMT_QTY_MEAS_UT_CD IN ('MLG', 'G') THEN 'KG'" ).append("\n"); 
		query.append("                   WHEN IMDG_LMT_QTY_MEAS_UT_CD = 'ML' THEN 'L'" ).append("\n"); 
		query.append("              ELSE NVL(IMDG_LMT_QTY_MEAS_UT_CD, 'KG') END IMDG_LMT_QTY_MEAS_UT_CD" ).append("\n"); 
		query.append("         FROM SCG_IMDG_UN_NO" ).append("\n"); 
		query.append("        WHERE IMDG_UN_NO = @[imdg_un_no]" ).append("\n"); 
		query.append("          AND IMDG_UN_NO_SEQ = @[imdg_un_no_seq]" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'Excepted Q'||''''||'TY' DIV_NM" ).append("\n"); 
		query.append("      ,IMDG_EXPT_QTY_CD REGU_VAL" ).append("\n"); 
		query.append("      ,'Max Weight' MAX_WGT_NM" ).append("\n"); 
		query.append("      ,'N/A' MAX_WGT_RSLT" ).append("\n"); 
		query.append("      ,'PKG Type' PKG_TP_NM" ).append("\n"); 
		query.append("      ,'N/A' PKG_TP_RSLT" ).append("\n"); 
		query.append("  FROM SCG_IMDG_UN_NO S" ).append("\n"); 
		query.append(" WHERE S.IMDG_UN_NO = @[imdg_un_no]" ).append("\n"); 
		query.append("   AND S.IMDG_UN_NO_SEQ = @[imdg_un_no_seq]" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'Packing Instruction' DIV_NM" ).append("\n"); 
		query.append("      ,N1ST_IMDG_PCK_INSTR_CD||NVL2(N2ND_IMDG_PCK_INSTR_CD, ', '||N2ND_IMDG_PCK_INSTR_CD, NULL)" ).append("\n"); 
		query.append("       ||NVL2(N3RD_IMDG_PCK_INSTR_CD, ', '||N3RD_IMDG_PCK_INSTR_CD, NULL)" ).append("\n"); 
		query.append("       ||NVL2(N1ST_IMDG_IBC_INSTR_CD, ', '||N1ST_IMDG_IBC_INSTR_CD, NULL)" ).append("\n"); 
		query.append("       ||NVL2(N2ND_IMDG_IBC_INSTR_CD, ', '||N2ND_IMDG_IBC_INSTR_CD, NULL)" ).append("\n"); 
		query.append("       ||NVL2(N3RD_IMDG_IBC_INSTR_CD, ', '||N3RD_IMDG_IBC_INSTR_CD, NULL)" ).append("\n"); 
		query.append("       ||NVL2(N4TH_IMDG_IBC_INSTR_CD, ', '||N4TH_IMDG_IBC_INSTR_CD, NULL)" ).append("\n"); 
		query.append("       ||NVL2(N5TH_IMDG_IBC_INSTR_CD, ', '||N5TH_IMDG_IBC_INSTR_CD, NULL)" ).append("\n"); 
		query.append("       ||NVL2(N1ST_IMDG_PCK_PROVI_CD, '('||N1ST_IMDG_PCK_PROVI_CD" ).append("\n"); 
		query.append("       ||NVL2(N2ND_IMDG_PCK_PROVI_CD, ', '||N2ND_IMDG_PCK_PROVI_CD, NULL)" ).append("\n"); 
		query.append("             ||NVL2(N3RD_IMDG_PCK_PROVI_CD, ', '||N3RD_IMDG_PCK_PROVI_CD, NULL)" ).append("\n"); 
		query.append("             ||NVL2(N4TH_IMDG_PCK_PROVI_CD, ', '||N4TH_IMDG_PCK_PROVI_CD, NULL)" ).append("\n"); 
		query.append("             ||NVL2(N5TH_IMDG_PCK_PROVI_CD, ', '||N5TH_IMDG_PCK_PROVI_CD, NULL)" ).append("\n"); 
		query.append("             ||NVL2(N1ST_IMDG_IBC_PROVI_CD, ', '||N1ST_IMDG_IBC_PROVI_CD, NULL)" ).append("\n"); 
		query.append("             ||NVL2(N2ND_IMDG_IBC_PROVI_CD, ', '||N2ND_IMDG_IBC_PROVI_CD, NULL)" ).append("\n"); 
		query.append("             ||NVL2(N3RD_IMDG_IBC_PROVI_CD, ', '||N3RD_IMDG_IBC_PROVI_CD, NULL)" ).append("\n"); 
		query.append("             ||NVL2(N4TH_IMDG_IBC_PROVI_CD, ', '||N4TH_IMDG_IBC_PROVI_CD, NULL)" ).append("\n"); 
		query.append("             ||NVL2(N5TH_IMDG_IBC_PROVI_CD, ', '||N5TH_IMDG_IBC_PROVI_CD, NULL)||')', NULL) REGU_VAL" ).append("\n"); 
		query.append("      ,'Max Weight' MAX_WGT_NM" ).append("\n"); 
		query.append("      ,'N/A' MAX_WGT_RSLT" ).append("\n"); 
		query.append("      ,'PKG Type' PKG_TP_NM" ).append("\n"); 
		query.append("      ,'N/A' PKG_TP_RSLT" ).append("\n"); 
		query.append("  FROM SCG_IMDG_UN_NO S" ).append("\n"); 
		query.append(" WHERE S.IMDG_UN_NO = @[imdg_un_no]" ).append("\n"); 
		query.append("   AND S.IMDG_UN_NO_SEQ = @[imdg_un_no_seq]" ).append("\n"); 

	}
}