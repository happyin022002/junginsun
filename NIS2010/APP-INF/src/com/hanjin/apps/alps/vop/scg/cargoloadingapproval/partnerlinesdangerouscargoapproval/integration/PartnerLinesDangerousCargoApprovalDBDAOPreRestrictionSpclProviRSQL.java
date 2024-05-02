/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : PartnerLinesDangerousCargoApprovalDBDAOPreRestrictionSpclProviRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.21
*@LastModifier : 원종규
*@LastVersion : 1.0
* 2013.06.21 원종규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jongkyu Weon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PartnerLinesDangerousCargoApprovalDBDAOPreRestrictionSpclProviRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PreRestrictionSpclProvi
	  * </pre>
	  */
	public PartnerLinesDangerousCargoApprovalDBDAOPreRestrictionSpclProviRSQL(){
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
		params.put("out_imdg_pck_cd1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_imdg_pck_cd1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("intmd_imdg_pck_cd1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pck_sty_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("imdg_un_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pck_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_imdg_pck_qty1",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.integration").append("\n"); 
		query.append("FileName : PartnerLinesDangerousCargoApprovalDBDAOPreRestrictionSpclProviRSQL").append("\n"); 
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
		query.append("WITH SPCL_PROVI AS(" ).append("\n"); 
		query.append("SELECT U.IMDG_UN_NO " ).append("\n"); 
		query.append("	  ,S.IMDG_PCK_INSTR_CD" ).append("\n"); 
		query.append("      ,S.IMDG_PCK_INSTR_SEQ" ).append("\n"); 
		query.append("      ,S.SPCL_PCK_PROVI_CD" ).append("\n"); 
		query.append("      ,S.SUB_SEQ" ).append("\n"); 
		query.append("      ,S.SPCL_PCK_PROVI_DIV_CD" ).append("\n"); 
		query.append("      ,S.PRMT_CHK_CD" ).append("\n"); 
		query.append("      ,S.COND_PCK_STY_CD" ).append("\n"); 
		query.append("      ,DECODE(S.COND_PCK_CD, null, S.COND_PCK_TP_CD, " ).append("\n"); 
		query.append("             (SELECT PCK_KND_CD" ).append("\n"); 
		query.append("                FROM SCG_IMDG_PCK_CD" ).append("\n"); 
		query.append("               WHERE IMDG_PCK_CD = S.IMDG_PCK_CD" ).append("\n"); 
		query.append("             )) COND_PCK_TP_CD" ).append("\n"); 
		query.append("      ,DECODE(S.COND_PCK_CD, null, S.COND_PCK_MTRL_TP_CD," ).append("\n"); 
		query.append("             (SELECT PCK_MTRL_TP_CD" ).append("\n"); 
		query.append("                FROM SCG_IMDG_PCK_CD" ).append("\n"); 
		query.append("               WHERE IMDG_PCK_CD = S.IMDG_PCK_CD" ).append("\n"); 
		query.append("             )) COND_PCK_MTRL_TP_CD" ).append("\n"); 
		query.append("      ,S.COND_PCK_CD" ).append("\n"); 
		query.append("      ,S.GRP_N1ST_USE_FLG" ).append("\n"); 
		query.append("      ,S.GRP_N2ND_USE_FLG" ).append("\n"); 
		query.append("      ,S.GRP_N3RD_USE_FLG" ).append("\n"); 
		query.append("      ,S.CAPA_MASS_USE_FLG" ).append("\n"); 
		query.append("      ,S.CAPA_MASS_MIN_QTY" ).append("\n"); 
		query.append("      ,S.CAPA_MASS_MAX_QTY" ).append("\n"); 
		query.append("      ,S.CAPA_MASS_MEAS_UT_CD" ).append("\n"); 
		query.append("      ,S.RULE_APLY_TP_CD" ).append("\n"); 
		query.append("      ,DECODE(S.PCK_STY_CD, 'S', 'O', S.PCK_STY_CD) PCK_STY_CD" ).append("\n"); 
		query.append("      ,S.PCK_STY_CD PCK_STY" ).append("\n"); 
		query.append("      ,DECODE(S.IMDG_PCK_CD, null, S.PCK_TP_CD, " ).append("\n"); 
		query.append("             (SELECT PCK_KND_CD" ).append("\n"); 
		query.append("                FROM SCG_IMDG_PCK_CD" ).append("\n"); 
		query.append("               WHERE IMDG_PCK_CD = S.IMDG_PCK_CD" ).append("\n"); 
		query.append("             )) PCK_TP_CD" ).append("\n"); 
		query.append("      ,DECODE(S.IMDG_PCK_CD, null, S.PCK_MTRL_TP_CD," ).append("\n"); 
		query.append("             (SELECT PCK_MTRL_TP_CD" ).append("\n"); 
		query.append("                FROM SCG_IMDG_PCK_CD" ).append("\n"); 
		query.append("               WHERE IMDG_PCK_CD = S.IMDG_PCK_CD" ).append("\n"); 
		query.append("             )) PCK_MTRL_TP_CD" ).append("\n"); 
		query.append("      ,(SELECT IMDG_PCK_CD" ).append("\n"); 
		query.append("          FROM SCG_IMDG_PCK_CD" ).append("\n"); 
		query.append("         WHERE IMDG_PCK_CD = S.IMDG_PCK_CD" ).append("\n"); 
		query.append("           AND PCK_KND_CD IS NOT NULL" ).append("\n"); 
		query.append("           AND PCK_MTRL_TP_CD IS NOT NULL" ).append("\n"); 
		query.append("       ) IMDG_PCK_CD" ).append("\n"); 
		query.append("  FROM SCG_IMDG_UN_NO U" ).append("\n"); 
		query.append("      ,SCG_SPCL_PCK_PROVI S" ).append("\n"); 
		query.append(" WHERE U.IMDG_UN_NO = @[imdg_un_no]" ).append("\n"); 
		query.append("   AND U.IMDG_UN_NO_SEQ = @[imdg_un_no_seq]" ).append("\n"); 
		query.append("   AND SUBSTR(S.IMDG_PCK_INSTR_CD, 0, 1) = @[pck_div_cd]" ).append("\n"); 
		query.append("#if(${pck_div_cd} == 'P' || ${pck_div_cd} == 'L')" ).append("\n"); 
		query.append("   AND S.SPCL_PCK_PROVI_CD IN (U.N1ST_IMDG_PCK_PROVI_CD" ).append("\n"); 
		query.append("                   ,U.N2ND_IMDG_PCK_PROVI_CD" ).append("\n"); 
		query.append("                   ,U.N3RD_IMDG_PCK_PROVI_CD" ).append("\n"); 
		query.append("                   ,U.N4TH_IMDG_PCK_PROVI_CD" ).append("\n"); 
		query.append("                   ,U.N5TH_IMDG_PCK_PROVI_CD" ).append("\n"); 
		query.append("                   )" ).append("\n"); 
		query.append("   AND S.IMDG_PCK_INSTR_CD||S.IMDG_PCK_INSTR_SEQ IN (U.N1ST_IMDG_PCK_INSTR_CD||U.N1ST_IMDG_PCK_INSTR_SEQ" ).append("\n"); 
		query.append("                   			   ,U.N2ND_IMDG_PCK_INSTR_CD||U.N2ND_IMDG_PCK_INSTR_SEQ" ).append("\n"); 
		query.append("                   			   ,U.N3RD_IMDG_PCK_INSTR_CD||U.N3RD_IMDG_PCK_INSTR_SEQ" ).append("\n"); 
		query.append("                   			  )" ).append("\n"); 
		query.append("#elseif(${pck_div_cd} == 'I')" ).append("\n"); 
		query.append("   AND S.SPCL_PCK_PROVI_CD IN (U.N1ST_IMDG_IBC_PROVI_CD" ).append("\n"); 
		query.append("                   ,U.N2ND_IMDG_IBC_PROVI_CD" ).append("\n"); 
		query.append("                   ,U.N3RD_IMDG_IBC_PROVI_CD" ).append("\n"); 
		query.append("                   ,U.N4TH_IMDG_IBC_PROVI_CD" ).append("\n"); 
		query.append("                   ,U.N5TH_IMDG_IBC_PROVI_CD" ).append("\n"); 
		query.append("                   )" ).append("\n"); 
		query.append("   AND S.IMDG_PCK_INSTR_CD||S.IMDG_PCK_INSTR_SEQ IN (U.N1ST_IMDG_IBC_INSTR_CD||U.N1ST_IMDG_IBC_INSTR_SEQ" ).append("\n"); 
		query.append("                   			   ,U.N2ND_IMDG_IBC_INSTR_CD||U.N2ND_IMDG_IBC_INSTR_SEQ" ).append("\n"); 
		query.append("                   			   ,U.N3RD_IMDG_IBC_INSTR_CD||U.N3RD_IMDG_IBC_INSTR_SEQ" ).append("\n"); 
		query.append("                   			   ,U.N4TH_IMDG_IBC_INSTR_CD||U.N4TH_IMDG_IBC_INSTR_SEQ" ).append("\n"); 
		query.append("                   			   ,U.N5TH_IMDG_IBC_INSTR_CD||U.N5TH_IMDG_IBC_INSTR_SEQ" ).append("\n"); 
		query.append("                   			   )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND S.RULE_APLY_TP_CD IN ('F', 'P')" ).append("\n"); 
		query.append("   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("INPUT_PCK_CD AS (" ).append("\n"); 
		query.append("SELECT IMDG_PCK_CD" ).append("\n"); 
		query.append("      ,IMDG_PCK_TP_CD" ).append("\n"); 
		query.append("      ,PCK_KND_CD" ).append("\n"); 
		query.append("      ,PCK_MTRL_TP_CD" ).append("\n"); 
		query.append("  FROM SCG_IMDG_PCK_CD" ).append("\n"); 
		query.append(" WHERE IMDG_PCK_CD = @[out_imdg_pck_cd1]" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT IMDG_PCK_CD" ).append("\n"); 
		query.append("      ,IMDG_PCK_TP_CD" ).append("\n"); 
		query.append("      ,PCK_KND_CD" ).append("\n"); 
		query.append("      ,PCK_MTRL_TP_CD" ).append("\n"); 
		query.append("  FROM SCG_IMDG_PCK_CD" ).append("\n"); 
		query.append(" WHERE IMDG_PCK_CD = @[in_imdg_pck_cd1]" ).append("\n"); 
		query.append(" UNION ALL" ).append("\n"); 
		query.append("SELECT IMDG_PCK_CD" ).append("\n"); 
		query.append("      ,IMDG_PCK_TP_CD" ).append("\n"); 
		query.append("      ,PCK_KND_CD" ).append("\n"); 
		query.append("      ,PCK_MTRL_TP_CD" ).append("\n"); 
		query.append("  FROM SCG_IMDG_PCK_CD" ).append("\n"); 
		query.append(" WHERE IMDG_PCK_CD = @[intmd_imdg_pck_cd1]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT S.IMDG_UN_NO" ).append("\n"); 
		query.append("      ,S.IMDG_PCK_INSTR_CD" ).append("\n"); 
		query.append("      ,S.IMDG_PCK_INSTR_SEQ" ).append("\n"); 
		query.append("      ,S.SPCL_PCK_PROVI_CD" ).append("\n"); 
		query.append("      ,S.SUB_SEQ" ).append("\n"); 
		query.append("      ,S.SPCL_PCK_PROVI_DIV_CD" ).append("\n"); 
		query.append("      ,S.PRMT_CHK_CD" ).append("\n"); 
		query.append("      ,S.RULE_APLY_TP_CD" ).append("\n"); 
		query.append("      ,S.GRP_N1ST_USE_FLG" ).append("\n"); 
		query.append("      ,S.GRP_N2ND_USE_FLG" ).append("\n"); 
		query.append("      ,S.GRP_N3RD_USE_FLG" ).append("\n"); 
		query.append("      ,@[out_imdg_pck_cd1] out_imdg_pck_cd1" ).append("\n"); 
		query.append("      ,@[in_imdg_pck_cd1] in_imdg_pck_cd1" ).append("\n"); 
		query.append("      ,@[intmd_imdg_pck_cd1] intmd_imdg_pck_cd1" ).append("\n"); 
		query.append("  FROM SPCL_PROVI S" ).append("\n"); 
		query.append("      ,INPUT_PCK_CD I" ).append("\n"); 
		query.append(" WHERE (S.IMDG_PCK_CD IN (I.IMDG_PCK_CD)   --PKG_CD가 일치하는 경우" ).append("\n"); 
		query.append("        OR (S.IMDG_PCK_CD IS NULL          --각 PKG_STY(O,M,I) 별로 PKG TP나 MTRL TP가 일치하는 경우 : PKG_CD 가 NULL이어야함" ).append("\n"); 
		query.append("            AND" ).append("\n"); 
		query.append("            S.PCK_STY_CD = I.IMDG_PCK_TP_CD" ).append("\n"); 
		query.append("            AND (S.PCK_TP_CD = I.PCK_KND_CD" ).append("\n"); 
		query.append("                 OR S.PCK_MTRL_TP_CD = I.PCK_MTRL_TP_CD" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("        OR (S.IMDG_PCK_CD IS NULL           --각 PKG_STY(O,M,I)에 상관없이 PKG TP나 MTRL TP가 일치하는 경우 : PKG_CD/PKG_STY_CD가 NULL이어야함" ).append("\n"); 
		query.append("            AND" ).append("\n"); 
		query.append("            S.PCK_STY_CD IS NULL" ).append("\n"); 
		query.append("            AND (S.PCK_TP_CD = I.PCK_KND_CD" ).append("\n"); 
		query.append("                 OR S.PCK_MTRL_TP_CD = I.PCK_MTRL_TP_CD" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("        OR (S.CAPA_MASS_MEAS_UT_CD = ('G')      --OUTER/INNER 무게/부피 규정 이내인 경우 : 단위에 따라 분기" ).append("\n"); 
		query.append("            AND ((S.PCK_STY_CD = 'O'" ).append("\n"); 
		query.append("    	          AND S.CAPA_MASS_MAX_QTY < TO_NUMBER(@[net_wgt])/TO_NUMBER(@[out_imdg_pck_qty1])*1000" ).append("\n"); 
		query.append("    			 )" ).append("\n"); 
		query.append("                OR (S.PCK_STY_CD = 'I'" ).append("\n"); 
		query.append("	                AND S.CAPA_MASS_MAX_QTY < TO_NUMBER(@[net_wgt])/TO_NUMBER(@[in_imdg_pck_qty1])*1000" ).append("\n"); 
		query.append("		    	   ) " ).append("\n"); 
		query.append("			    )" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("	    OR (S.CAPA_MASS_MEAS_UT_CD = ('M')" ).append("\n"); 
		query.append(" 	        AND ((S.PCK_STY_CD = 'O'" ).append("\n"); 
		query.append("#if(${grs_capa_qty} != '')" ).append("\n"); 
		query.append(" 		          AND S.CAPA_MASS_MAX_QTY < TO_NUMBER(@[grs_capa_qty])/TO_NUMBER(@[out_imdg_pck_qty1])*1000" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(" 		          AND S.CAPA_MASS_MAX_QTY < TO_NUMBER(@[net_wgt])/TO_NUMBER(@[out_imdg_pck_qty1])*1000" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("				 )" ).append("\n"); 
		query.append("            	OR (S.PCK_STY_CD = 'I'" ).append("\n"); 
		query.append("#if(${grs_capa_qty} != '')" ).append("\n"); 
		query.append(" 		          AND S.CAPA_MASS_MAX_QTY < TO_NUMBER(@[grs_capa_qty])/TO_NUMBER(@[in_imdg_pck_qty1])*1000" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(" 		          AND S.CAPA_MASS_MAX_QTY < TO_NUMBER(@[net_wgt])/TO_NUMBER(@[in_imdg_pck_qty1])*1000" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("			   	   ) " ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("       	   )" ).append("\n"); 
		query.append("    	OR (S.CAPA_MASS_MEAS_UT_CD = ('K')" ).append("\n"); 
		query.append("        	AND ((S.PCK_STY_CD = 'O'" ).append("\n"); 
		query.append("	             AND S.CAPA_MASS_MAX_QTY < TO_NUMBER(@[net_wgt])/TO_NUMBER(@[out_imdg_pck_qty1])" ).append("\n"); 
		query.append("			    )" ).append("\n"); 
		query.append("            	OR (S.PCK_STY_CD = 'I'" ).append("\n"); 
		query.append("	            	AND S.CAPA_MASS_MAX_QTY < TO_NUMBER(@[net_wgt])/TO_NUMBER(@[in_imdg_pck_qty1])" ).append("\n"); 
		query.append("			   	   ) " ).append("\n"); 
		query.append("			    )" ).append("\n"); 
		query.append("       	   )" ).append("\n"); 
		query.append("	    OR (S.CAPA_MASS_MEAS_UT_CD = ('L')" ).append("\n"); 
		query.append("    	    AND ((S.PCK_STY_CD = 'O'" ).append("\n"); 
		query.append("#if(${grs_capa_qty} != '')" ).append("\n"); 
		query.append(" 		          AND S.CAPA_MASS_MAX_QTY < TO_NUMBER(@[grs_capa_qty])/TO_NUMBER(@[out_imdg_pck_qty1])" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(" 		          AND S.CAPA_MASS_MAX_QTY < TO_NUMBER(@[net_wgt])/TO_NUMBER(@[out_imdg_pck_qty1])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("            	OR (S.PCK_STY_CD = 'I'" ).append("\n"); 
		query.append("#if(${grs_capa_qty} != '')" ).append("\n"); 
		query.append(" 		          AND S.CAPA_MASS_MAX_QTY < TO_NUMBER(@[grs_capa_qty])/TO_NUMBER(@[in_imdg_pck_qty1])*1000" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(" 		          AND S.CAPA_MASS_MAX_QTY < TO_NUMBER(@[net_wgt])/TO_NUMBER(@[in_imdg_pck_qty1])*1000" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("			   	   ) " ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("       	   )" ).append("\n"); 
		query.append("       	)" ).append("\n"); 
		query.append("   OR (S.GRP_N1ST_USE_FLG = 'Y' 			--각 PACKING GROUP 별로 PI의 그룹을 따르는 경우" ).append("\n"); 
		query.append("       OR S.GRP_N2ND_USE_FLG = 'Y'" ).append("\n"); 
		query.append("       OR S.GRP_N3RD_USE_FLG = 'Y'" ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("   OR (S.IMDG_PCK_CD IS NULL		--PKG_STY_CD만 존재하며 값이 COMBINE이나 SINGLE일 경우" ).append("\n"); 
		query.append("       AND S.PCK_TP_CD IS NULL" ).append("\n"); 
		query.append("       AND S.PCK_MTRL_TP_CD IS NULL" ).append("\n"); 
		query.append("       AND S.PCK_STY IN ('C', 'S')" ).append("\n"); 
		query.append("       AND S.PCK_STY = @[pck_sty_cd]" ).append("\n"); 
		query.append("      )" ).append("\n"); 

	}
}