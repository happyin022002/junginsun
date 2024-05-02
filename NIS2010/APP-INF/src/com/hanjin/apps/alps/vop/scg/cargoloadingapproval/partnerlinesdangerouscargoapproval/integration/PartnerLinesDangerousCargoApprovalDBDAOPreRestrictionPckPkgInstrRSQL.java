/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : PartnerLinesDangerousCargoApprovalDBDAOPreRestrictionPckPkgInstrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.25
*@LastModifier : KIM HYUN HWA
*@LastVersion : 1.0
* 2013.06.25 KIM HYUN HWA
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

public class PartnerLinesDangerousCargoApprovalDBDAOPreRestrictionPckPkgInstrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PreRestrictionPckPkgInstr
	  * </pre>
	  */
	public PartnerLinesDangerousCargoApprovalDBDAOPreRestrictionPckPkgInstrRSQL(){
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
		params.put("imdg_pck_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : PartnerLinesDangerousCargoApprovalDBDAOPreRestrictionPckPkgInstrRSQL").append("\n"); 
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
		query.append("WITH PKG_INSTR AS (" ).append("\n"); 
		query.append("SELECT S.IMDG_PCK_INSTR_CD" ).append("\n"); 
		query.append("      ,S.IMDG_PCK_INSTR_SEQ" ).append("\n"); 
		query.append("      ,S.PCK_STY_CD" ).append("\n"); 
		query.append("      ,S.SUB_SEQ" ).append("\n"); 
		query.append("      ,(SELECT IMDG_PCK_CD" ).append("\n"); 
		query.append("          FROM SCG_IMDG_PCK_CD" ).append("\n"); 
		query.append("         WHERE IMDG_PCK_CD = S.IMDG_PCK_CD" ).append("\n"); 
		query.append("           AND PCK_KND_CD IS NOT NULL" ).append("\n"); 
		query.append("           AND PCK_MTRL_TP_CD IS NOT NULL" ).append("\n"); 
		query.append("       ) IMDG_PCK_CD" ).append("\n"); 
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
		query.append("      ,S.GRP_N1ST_PROHI_FLG" ).append("\n"); 
		query.append("      ,S.GRP_N1ST_REF_NO" ).append("\n"); 
		query.append("      ,S.GRP_N1ST_QTY" ).append("\n"); 
		query.append("      ,S.GRP_N1ST_MEAS_UT_CD" ).append("\n"); 
		query.append("      ,S.GRP_N2ND_PROHI_FLG" ).append("\n"); 
		query.append("      ,S.GRP_N2ND_QTY" ).append("\n"); 
		query.append("      ,S.GRP_N2ND_MEAS_UT_CD" ).append("\n"); 
		query.append("      ,S.GRP_N3RD_PROHI_FLG" ).append("\n"); 
		query.append("      ,S.GRP_N3RD_QTY" ).append("\n"); 
		query.append("      ,S.GRP_N3RD_MEAS_UT_CD" ).append("\n"); 
		query.append("      ,NVL(U.IMDG_PCK_GRP_CD, @[imdg_pck_grp_cd]) IMDG_PCK_GRP_CD" ).append("\n"); 
		query.append("  FROM SCG_PCK_STY S" ).append("\n"); 
		query.append("      ,SCG_IMDG_UN_NO U" ).append("\n"); 
		query.append(" WHERE U.IMDG_UN_NO = @[imdg_un_no]" ).append("\n"); 
		query.append("   AND U.IMDG_UN_NO_SEQ = @[imdg_un_no_seq]" ).append("\n"); 
		query.append("   AND SUBSTR(S.IMDG_PCK_INSTR_CD, 0, 1) = @[pck_div_cd]" ).append("\n"); 
		query.append("#if(${pck_div_cd} == 'P' || ${pck_div_cd} == 'L')" ).append("\n"); 
		query.append("   AND S.IMDG_PCK_INSTR_CD||S.IMDG_PCK_INSTR_SEQ IN (U.N1ST_IMDG_PCK_INSTR_CD||U.N1ST_IMDG_PCK_INSTR_SEQ" ).append("\n"); 
		query.append("                   			   ,U.N2ND_IMDG_PCK_INSTR_CD||U.N2ND_IMDG_PCK_INSTR_SEQ" ).append("\n"); 
		query.append("                   			   ,U.N3RD_IMDG_PCK_INSTR_CD||U.N3RD_IMDG_PCK_INSTR_SEQ" ).append("\n"); 
		query.append("                   			  )" ).append("\n"); 
		query.append("#elseif(${pck_div_cd} == 'I')" ).append("\n"); 
		query.append("   AND S.IMDG_PCK_INSTR_CD||S.IMDG_PCK_INSTR_SEQ IN (U.N1ST_IMDG_IBC_INSTR_CD||U.N1ST_IMDG_IBC_INSTR_SEQ" ).append("\n"); 
		query.append("                   			   ,U.N2ND_IMDG_IBC_INSTR_CD||U.N2ND_IMDG_IBC_INSTR_SEQ" ).append("\n"); 
		query.append("                   			   ,U.N3RD_IMDG_IBC_INSTR_CD||U.N3RD_IMDG_IBC_INSTR_SEQ" ).append("\n"); 
		query.append("                   			   ,U.N4TH_IMDG_IBC_INSTR_CD||U.N4TH_IMDG_IBC_INSTR_SEQ" ).append("\n"); 
		query.append("                   			   ,U.N5TH_IMDG_IBC_INSTR_CD||U.N5TH_IMDG_IBC_INSTR_SEQ" ).append("\n"); 
		query.append("                   			   )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND S.DELT_FLG = 'N'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(",PKG_INSTR_CNT AS (" ).append("\n"); 
		query.append("SELECT DISTINCT" ).append("\n"); 
		query.append("       (SELECT COUNT(1)" ).append("\n"); 
		query.append("          FROM SCG_PCK_STY S2" ).append("\n"); 
		query.append("         WHERE S2.PCK_STY_CD = 'O'" ).append("\n"); 
		query.append("           AND S2.IMDG_PCK_INSTR_CD = S.IMDG_PCK_INSTR_CD" ).append("\n"); 
		query.append("           AND S2.IMDG_PCK_INSTR_SEQ = S.IMDG_PCK_INSTR_SEQ" ).append("\n"); 
		query.append("       ) OUT_PKG_CNT" ).append("\n"); 
		query.append("      ,(SELECT COUNT(1)" ).append("\n"); 
		query.append("          FROM SCG_PCK_STY S2" ).append("\n"); 
		query.append("         WHERE S2.PCK_STY_CD = 'I'" ).append("\n"); 
		query.append("           AND S2.IMDG_PCK_INSTR_CD = S.IMDG_PCK_INSTR_CD" ).append("\n"); 
		query.append("           AND S2.IMDG_PCK_INSTR_SEQ = S.IMDG_PCK_INSTR_SEQ" ).append("\n"); 
		query.append("       ) IN_PKG_CNT" ).append("\n"); 
		query.append("      ,(SELECT COUNT(1)" ).append("\n"); 
		query.append("          FROM SCG_PCK_STY S2" ).append("\n"); 
		query.append("         WHERE S2.PCK_STY_CD = 'M'" ).append("\n"); 
		query.append("           AND S2.IMDG_PCK_INSTR_CD = S.IMDG_PCK_INSTR_CD" ).append("\n"); 
		query.append("           AND S2.IMDG_PCK_INSTR_SEQ = S.IMDG_PCK_INSTR_SEQ" ).append("\n"); 
		query.append("       ) INTMD_PKG_CNT" ).append("\n"); 
		query.append("      ,(SELECT COUNT(1)" ).append("\n"); 
		query.append("          FROM SCG_PCK_STY S2" ).append("\n"); 
		query.append("         WHERE S2.PCK_STY_CD = 'S'" ).append("\n"); 
		query.append("           AND S2.IMDG_PCK_INSTR_CD = S.IMDG_PCK_INSTR_CD" ).append("\n"); 
		query.append("           AND S2.IMDG_PCK_INSTR_SEQ = S.IMDG_PCK_INSTR_SEQ" ).append("\n"); 
		query.append("       ) SGL_PKG_CNT" ).append("\n"); 
		query.append("       , S.IMDG_PCK_INSTR_CD, S.IMDG_PCK_GRP_CD" ).append("\n"); 
		query.append("  FROM PKG_INSTR S" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(",INPUT_PKG_CD AS (" ).append("\n"); 
		query.append("SELECT IMDG_PCK_CD" ).append("\n"); 
		query.append("      ,PCK_KND_CD" ).append("\n"); 
		query.append("      ,PCK_MTRL_TP_CD" ).append("\n"); 
		query.append("      ,IMDG_PCK_TP_CD" ).append("\n"); 
		query.append("  FROM SCG_IMDG_PCK_CD" ).append("\n"); 
		query.append(" WHERE IMDG_PCK_CD = @[intmd_imdg_pck_cd1]" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT IMDG_PCK_CD" ).append("\n"); 
		query.append("      ,PCK_KND_CD" ).append("\n"); 
		query.append("      ,PCK_MTRL_TP_CD" ).append("\n"); 
		query.append("      ,IMDG_PCK_TP_CD" ).append("\n"); 
		query.append("  FROM SCG_IMDG_PCK_CD" ).append("\n"); 
		query.append(" WHERE IMDG_PCK_CD = @[in_imdg_pck_cd1]" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT IMDG_PCK_CD" ).append("\n"); 
		query.append("      ,PCK_KND_CD" ).append("\n"); 
		query.append("      ,PCK_MTRL_TP_CD" ).append("\n"); 
		query.append("      ,DECODE(@[pck_sty_cd] , 'S', 'S', IMDG_PCK_TP_CD) IMDG_PCK_TP_CD" ).append("\n"); 
		query.append("  FROM SCG_IMDG_PCK_CD" ).append("\n"); 
		query.append(" WHERE IMDG_PCK_CD = @[out_imdg_pck_cd1]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT CASE WHEN (SELECT COUNT(1) CNT" ).append("\n"); 
		query.append("          		    FROM PKG_INSTR" ).append("\n"); 
		query.append("       		     ) = 0 THEN 'CHD'" ).append("\n"); 
		query.append("            WHEN R.PCK_EXPT_FLG = 'Y' THEN 'CHP|'||R.IMDG_PCK_INSTR_CD" ).append("\n"); 
		query.append("            ELSE 'V'" ).append("\n"); 
		query.append("            END VLD_CHK" ).append("\n"); 
		query.append("  FROM SCG_PCK_INSTR R" ).append("\n"); 
		query.append("      ,SCG_IMDG_UN_NO U" ).append("\n"); 
		query.append(" WHERE U.IMDG_UN_NO = @[imdg_un_no]" ).append("\n"); 
		query.append("   AND U.IMDG_UN_NO_SEQ = @[imdg_un_no_seq]" ).append("\n"); 
		query.append("   AND SUBSTR(R.IMDG_PCK_INSTR_CD, 0, 1) = @[pck_div_cd]" ).append("\n"); 
		query.append("#if(${pck_div_cd} == 'P' || ${pck_div_cd} == 'L')" ).append("\n"); 
		query.append("   AND R.IMDG_PCK_INSTR_CD||R.IMDG_PCK_INSTR_SEQ IN (U.N1ST_IMDG_PCK_INSTR_CD||U.N1ST_IMDG_PCK_INSTR_SEQ" ).append("\n"); 
		query.append("                   			   ,U.N2ND_IMDG_PCK_INSTR_CD||U.N2ND_IMDG_PCK_INSTR_SEQ" ).append("\n"); 
		query.append("                   			   ,U.N3RD_IMDG_PCK_INSTR_CD||U.N3RD_IMDG_PCK_INSTR_SEQ" ).append("\n"); 
		query.append("                   			  )" ).append("\n"); 
		query.append("#elseif(${pck_div_cd} == 'I')" ).append("\n"); 
		query.append("   AND R.IMDG_PCK_INSTR_CD||R.IMDG_PCK_INSTR_SEQ IN (U.N1ST_IMDG_IBC_INSTR_CD||U.N1ST_IMDG_IBC_INSTR_SEQ" ).append("\n"); 
		query.append("                   			   ,U.N2ND_IMDG_IBC_INSTR_CD||U.N2ND_IMDG_IBC_INSTR_SEQ" ).append("\n"); 
		query.append("                   			   ,U.N3RD_IMDG_IBC_INSTR_CD||U.N3RD_IMDG_IBC_INSTR_SEQ" ).append("\n"); 
		query.append("                   			   ,U.N4TH_IMDG_IBC_INSTR_CD||U.N4TH_IMDG_IBC_INSTR_SEQ" ).append("\n"); 
		query.append("                   			   ,U.N5TH_IMDG_IBC_INSTR_CD||U.N5TH_IMDG_IBC_INSTR_SEQ" ).append("\n"); 
		query.append("                   			   )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("#if(${pck_sty_cd} != 'S')" ).append("\n"); 
		query.append("SELECT CASE WHEN C.INTMD_PKG_CNT > 0" ).append("\n"); 
		query.append("            THEN (SELECT DECODE(COUNT(1), 0, 'PMI|'||C.IMDG_PCK_INSTR_CD||'|'||@[imdg_un_no]||'|', 'V')" ).append("\n"); 
		query.append("                    FROM PKG_INSTR I" ).append("\n"); 
		query.append("						,INPUT_PKG_CD P" ).append("\n"); 
		query.append("                   WHERE I.PCK_STY_CD = 'M'" ).append("\n"); 
		query.append("                     AND I.PCK_STY_CD = P.IMDG_PCK_TP_CD" ).append("\n"); 
		query.append("                     AND (I.IMDG_PCK_CD = P.IMDG_PCK_CD" ).append("\n"); 
		query.append("                          OR (I.IMDG_PCK_CD IS NULL" ).append("\n"); 
		query.append("				         	  AND (I.PCK_TP_CD = P.PCK_KND_CD" ).append("\n"); 
		query.append("                			       OR I.PCK_MTRL_TP_CD = P.PCK_MTRL_TP_CD" ).append("\n"); 
		query.append("                     			  )" ).append("\n"); 
		query.append("					         )" ).append("\n"); 
		query.append("                          )" ).append("\n"); 
		query.append("                      GROUP BY C.IMDG_PCK_INSTR_CD" ).append("\n"); 
		query.append("                 )" ).append("\n"); 
		query.append("            ELSE 'V'" ).append("\n"); 
		query.append("            END VLD_CHK" ).append("\n"); 
		query.append("  FROM PKG_INSTR_CNT C" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("UNION ALL  " ).append("\n"); 
		query.append("SELECT CASE WHEN C.IN_PKG_CNT > 0" ).append("\n"); 
		query.append("            THEN (CASE WHEN (SELECT COUNT(1) " ).append("\n"); 
		query.append("                               FROM PKG_INSTR I" ).append("\n"); 
		query.append("						  		   ,INPUT_PKG_CD P" ).append("\n"); 
		query.append("                              WHERE I.PCK_STY_CD = 'I'" ).append("\n"); 
		query.append("                                AND I.PCK_STY_CD = P.IMDG_PCK_TP_CD" ).append("\n"); 
		query.append("                                AND (I.IMDG_PCK_CD = P.IMDG_PCK_CD" ).append("\n"); 
		query.append("                                     OR (I.IMDG_PCK_CD IS NULL" ).append("\n"); 
		query.append("						                 AND (I.PCK_TP_CD = P.PCK_KND_CD" ).append("\n"); 
		query.append("                     					 	  OR I.PCK_MTRL_TP_CD = P.PCK_MTRL_TP_CD" ).append("\n"); 
		query.append("                     						 )" ).append("\n"); 
		query.append("					                    )" ).append("\n"); 
		query.append("                                    )				" ).append("\n"); 
		query.append("                            ) = 0 THEN 'PII|'||C.IMDG_PCK_INSTR_CD||'|'||@[imdg_un_no]||'|'" ).append("\n"); 
		query.append("                       WHEN (SELECT COUNT(1)" ).append("\n"); 
		query.append("                               FROM PKG_INSTR I" ).append("\n"); 
		query.append("						  		   ,INPUT_PKG_CD P" ).append("\n"); 
		query.append("                              WHERE I.PCK_STY_CD = 'I'" ).append("\n"); 
		query.append("                                AND I.PCK_STY_CD = P.IMDG_PCK_TP_CD" ).append("\n"); 
		query.append("                                AND (I.IMDG_PCK_CD = P.IMDG_PCK_CD" ).append("\n"); 
		query.append("                                     OR (I.IMDG_PCK_CD IS NULL" ).append("\n"); 
		query.append("						                 AND (I.PCK_TP_CD = P.PCK_KND_CD" ).append("\n"); 
		query.append("                     					 	  OR I.PCK_MTRL_TP_CD = P.PCK_MTRL_TP_CD" ).append("\n"); 
		query.append("                     						 )" ).append("\n"); 
		query.append("					                    )" ).append("\n"); 
		query.append("                                    )" ).append("\n"); 
		query.append("                                AND ((I.GRP_N1ST_MEAS_UT_CD = 'G'" ).append("\n"); 
		query.append("                                      AND I.GRP_N1ST_QTY > TO_NUMBER(@[net_wgt])/TO_NUMBER(@[in_imdg_pck_qty1])*1000" ).append("\n"); 
		query.append("                                     )" ).append("\n"); 
		query.append("                                     OR (I.GRP_N1ST_MEAS_UT_CD = 'M'" ).append("\n"); 
		query.append("#if(${grs_capa_qty} != '' && ${grs_capa_qty}> 0)" ).append("\n"); 
		query.append("                                         AND I.GRP_N1ST_QTY >= TO_NUMBER(@[grs_capa_qty])/TO_NUMBER(@[in_imdg_pck_qty1])*1000" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                                         AND I.GRP_N1ST_QTY >= TO_NUMBER(@[net_wgt])/TO_NUMBER(@[in_imdg_pck_qty1])*1000" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                        )" ).append("\n"); 
		query.append("                                     OR (I.GRP_N1ST_MEAS_UT_CD = 'K'" ).append("\n"); 
		query.append("                                         AND I.GRP_N1ST_QTY >= TO_NUMBER(@[net_wgt])/TO_NUMBER(@[in_imdg_pck_qty1])" ).append("\n"); 
		query.append("                                        )" ).append("\n"); 
		query.append("                                     OR (I.GRP_N1ST_MEAS_UT_CD = 'L'" ).append("\n"); 
		query.append("#if(${grs_capa_qty} != '' && ${grs_capa_qty}> 0)" ).append("\n"); 
		query.append("                                         AND I.GRP_N1ST_QTY >= TO_NUMBER(@[grs_capa_qty])/TO_NUMBER(@[in_imdg_pck_qty1])" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                                         AND I.GRP_N1ST_QTY >= TO_NUMBER(@[net_wgt])/TO_NUMBER(@[in_imdg_pck_qty1])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                        )" ).append("\n"); 
		query.append("                                     OR (I.GRP_N1ST_MEAS_UT_CD = 'M3'" ).append("\n"); 
		query.append("#if(${grs_capa_qty} != '' && ${grs_capa_qty}> 0)" ).append("\n"); 
		query.append("                                         AND I.GRP_N1ST_QTY >= TO_NUMBER(@[grs_capa_qty])/TO_NUMBER(@[in_imdg_pck_qty1])/1000" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                                         AND I.GRP_N1ST_QTY >= TO_NUMBER(@[net_wgt])/TO_NUMBER(@[in_imdg_pck_qty1])/1000" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                        )" ).append("\n"); 
		query.append("                                     OR I.GRP_N1ST_QTY IS NULL" ).append("\n"); 
		query.append("                                    )" ).append("\n"); 
		query.append("                            ) = 0 THEN 'WII|'||C.IMDG_PCK_INSTR_CD||'|'||@[imdg_un_no]||'|'" ).append("\n"); 
		query.append("                       ELSE 'V'" ).append("\n"); 
		query.append("                       END" ).append("\n"); 
		query.append("                 )" ).append("\n"); 
		query.append("            ELSE 'V'" ).append("\n"); 
		query.append("            END VLD_CHK      " ).append("\n"); 
		query.append("  FROM PKG_INSTR_CNT C" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT CASE WHEN C.OUT_PKG_CNT > 0" ).append("\n"); 
		query.append("            THEN (CASE WHEN (SELECT COUNT(1)" ).append("\n"); 
		query.append("                               FROM PKG_INSTR I" ).append("\n"); 
		query.append("						  		   ,INPUT_PKG_CD P" ).append("\n"); 
		query.append("                              WHERE I.PCK_STY_CD = 'O'" ).append("\n"); 
		query.append("                                AND I.PCK_STY_CD = P.IMDG_PCK_TP_CD" ).append("\n"); 
		query.append("                                AND (I.IMDG_PCK_CD = P.IMDG_PCK_CD" ).append("\n"); 
		query.append("                                     OR (I.IMDG_PCK_CD IS NULL" ).append("\n"); 
		query.append("						                 AND (I.PCK_TP_CD = P.PCK_KND_CD" ).append("\n"); 
		query.append("                     					 	  OR I.PCK_MTRL_TP_CD = P.PCK_MTRL_TP_CD" ).append("\n"); 
		query.append("                     						 )" ).append("\n"); 
		query.append("					                    )" ).append("\n"); 
		query.append("                                    )" ).append("\n"); 
		query.append("                            ) = 0 THEN 'POI|'||C.IMDG_PCK_INSTR_CD||'|'||@[imdg_un_no]||'|'" ).append("\n"); 
		query.append("                       WHEN (SELECT COUNT(1)" ).append("\n"); 
		query.append("                               FROM PKG_INSTR I" ).append("\n"); 
		query.append("						  		   ,INPUT_PKG_CD P" ).append("\n"); 
		query.append("                              WHERE I.PCK_STY_CD = 'O'" ).append("\n"); 
		query.append("                                AND I.PCK_STY_CD = P.IMDG_PCK_TP_CD" ).append("\n"); 
		query.append("                                AND (I.IMDG_PCK_CD = P.IMDG_PCK_CD" ).append("\n"); 
		query.append("                                     OR (I.IMDG_PCK_CD IS NULL" ).append("\n"); 
		query.append("						                 AND (I.PCK_TP_CD = P.PCK_KND_CD" ).append("\n"); 
		query.append("                     					 	  OR I.PCK_MTRL_TP_CD = P.PCK_MTRL_TP_CD" ).append("\n"); 
		query.append("                     						 )" ).append("\n"); 
		query.append("					                    )" ).append("\n"); 
		query.append("                                    )" ).append("\n"); 
		query.append("                                AND ((I.IMDG_PCK_GRP_CD = '1'" ).append("\n"); 
		query.append("                                      AND ((I.GRP_N1ST_MEAS_UT_CD = 'G'" ).append("\n"); 
		query.append("                                            AND I.GRP_N1ST_QTY >= TO_NUMBER(@[net_wgt])/TO_NUMBER(@[out_imdg_pck_qty1])*1000" ).append("\n"); 
		query.append("                                           )" ).append("\n"); 
		query.append("                                           OR (I.GRP_N1ST_MEAS_UT_CD = 'M'" ).append("\n"); 
		query.append("#if(${grs_capa_qty} != '' && ${grs_capa_qty}> 0)" ).append("\n"); 
		query.append("                                         AND I.GRP_N1ST_QTY >= TO_NUMBER(@[grs_capa_qty])/TO_NUMBER(@[out_imdg_pck_qty1])*1000" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                                         AND I.GRP_N1ST_QTY >= TO_NUMBER(@[net_wgt])/TO_NUMBER(@[out_imdg_pck_qty1])*1000" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                              )" ).append("\n"); 
		query.append("                                           OR (I.GRP_N1ST_MEAS_UT_CD = 'K'" ).append("\n"); 
		query.append("                                               AND I.GRP_N1ST_QTY >= TO_NUMBER(@[net_wgt])/TO_NUMBER(@[out_imdg_pck_qty1])" ).append("\n"); 
		query.append("                                              )" ).append("\n"); 
		query.append("                                           OR (I.GRP_N1ST_MEAS_UT_CD = 'L'" ).append("\n"); 
		query.append("#if(${grs_capa_qty} != '' && ${grs_capa_qty}> 0)" ).append("\n"); 
		query.append("                                         AND I.GRP_N1ST_QTY >= TO_NUMBER(@[grs_capa_qty])/TO_NUMBER(@[out_imdg_pck_qty1])" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                                         AND I.GRP_N1ST_QTY >= TO_NUMBER(@[net_wgt])/TO_NUMBER(@[out_imdg_pck_qty1])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                              )" ).append("\n"); 
		query.append("                                           OR (I.GRP_N1ST_MEAS_UT_CD = 'M3'" ).append("\n"); 
		query.append("#if(${grs_capa_qty} != '' && ${grs_capa_qty}> 0)" ).append("\n"); 
		query.append("                                         AND I.GRP_N1ST_QTY >= TO_NUMBER(@[grs_capa_qty])/TO_NUMBER(@[out_imdg_pck_qty1])/1000" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                                         AND I.GRP_N1ST_QTY >= TO_NUMBER(@[net_wgt])/TO_NUMBER(@[out_imdg_pck_qty1])/1000" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                              )" ).append("\n"); 
		query.append("                                         )" ).append("\n"); 
		query.append("                                     )" ).append("\n"); 
		query.append("                                     OR (I.IMDG_PCK_GRP_CD = '2'" ).append("\n"); 
		query.append("                                         AND ((I.GRP_N2ND_MEAS_UT_CD = 'G'" ).append("\n"); 
		query.append("                                               AND I.GRP_N2ND_QTY >= TO_NUMBER(@[net_wgt])/TO_NUMBER(@[out_imdg_pck_qty1])*1000" ).append("\n"); 
		query.append("                                              )" ).append("\n"); 
		query.append("                                              OR (I.GRP_N2ND_MEAS_UT_CD = 'M'" ).append("\n"); 
		query.append("#if(${grs_capa_qty} != '' && ${grs_capa_qty}> 0)" ).append("\n"); 
		query.append("                                         AND I.GRP_N2ND_QTY >= TO_NUMBER(@[grs_capa_qty])/TO_NUMBER(@[out_imdg_pck_qty1])*1000" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                                         AND I.GRP_N2ND_QTY >= TO_NUMBER(@[net_wgt])/TO_NUMBER(@[out_imdg_pck_qty1])*1000" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                                 )" ).append("\n"); 
		query.append("                                              OR (I.GRP_N2ND_MEAS_UT_CD = 'K'" ).append("\n"); 
		query.append("                                                  AND I.GRP_N2ND_QTY >= TO_NUMBER(@[net_wgt])/TO_NUMBER(@[out_imdg_pck_qty1])" ).append("\n"); 
		query.append("                                                 )" ).append("\n"); 
		query.append("                                              OR (I.GRP_N2ND_MEAS_UT_CD = 'L'" ).append("\n"); 
		query.append("#if(${grs_capa_qty} != '' && ${grs_capa_qty}> 0)" ).append("\n"); 
		query.append("                                         AND I.GRP_N2ND_QTY >= TO_NUMBER(@[grs_capa_qty])/TO_NUMBER(@[out_imdg_pck_qty1])" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                                         AND I.GRP_N2ND_QTY >= TO_NUMBER(@[net_wgt])/TO_NUMBER(@[out_imdg_pck_qty1])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                                 )" ).append("\n"); 
		query.append("                                              OR (I.GRP_N2ND_MEAS_UT_CD = 'M3'" ).append("\n"); 
		query.append("#if(${grs_capa_qty} != '' && ${grs_capa_qty}> 0)" ).append("\n"); 
		query.append("                                         AND I.GRP_N2ND_QTY >= TO_NUMBER(@[grs_capa_qty])/TO_NUMBER(@[out_imdg_pck_qty1])/1000" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                                         AND I.GRP_N2ND_QTY >= TO_NUMBER(@[net_wgt])/TO_NUMBER(@[out_imdg_pck_qty1])/1000" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                                 )" ).append("\n"); 
		query.append("                                            )" ).append("\n"); 
		query.append("                                        )" ).append("\n"); 
		query.append("                                     OR (I.IMDG_PCK_GRP_CD = '3'" ).append("\n"); 
		query.append("                                         AND ((I.GRP_N3RD_MEAS_UT_CD = 'G'" ).append("\n"); 
		query.append("                                               AND I.GRP_N3RD_QTY >= TO_NUMBER(@[net_wgt])/TO_NUMBER(@[out_imdg_pck_qty1])*1000" ).append("\n"); 
		query.append("                                              )" ).append("\n"); 
		query.append("                                              OR (I.GRP_N3RD_MEAS_UT_CD = 'M'" ).append("\n"); 
		query.append("#if(${grs_capa_qty} != '' && ${grs_capa_qty}> 0)" ).append("\n"); 
		query.append("                                         AND I.GRP_N3RD_QTY >= TO_NUMBER(@[grs_capa_qty])/TO_NUMBER(@[out_imdg_pck_qty1])*1000" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                                         AND I.GRP_N3RD_QTY >= TO_NUMBER(@[net_wgt])/TO_NUMBER(@[out_imdg_pck_qty1])*1000" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                                 )" ).append("\n"); 
		query.append("                                              OR (I.GRP_N3RD_MEAS_UT_CD = 'K'" ).append("\n"); 
		query.append("                                                  AND I.GRP_N3RD_QTY >= TO_NUMBER(@[net_wgt])/TO_NUMBER(@[out_imdg_pck_qty1])" ).append("\n"); 
		query.append("                                                 )" ).append("\n"); 
		query.append("                                              OR (I.GRP_N3RD_MEAS_UT_CD = 'L'" ).append("\n"); 
		query.append("#if(${grs_capa_qty} != '' && ${grs_capa_qty}> 0)" ).append("\n"); 
		query.append("                                         AND I.GRP_N3RD_QTY >= TO_NUMBER(@[grs_capa_qty])/TO_NUMBER(@[out_imdg_pck_qty1])" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                                         AND I.GRP_N3RD_QTY >= TO_NUMBER(@[net_wgt])/TO_NUMBER(@[out_imdg_pck_qty1])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                                 )" ).append("\n"); 
		query.append("                                              OR (I.GRP_N3RD_MEAS_UT_CD = 'M3'" ).append("\n"); 
		query.append("#if(${grs_capa_qty} != '' && ${grs_capa_qty}> 0)" ).append("\n"); 
		query.append("                                         AND I.GRP_N3RD_QTY >= TO_NUMBER(@[grs_capa_qty])/TO_NUMBER(@[out_imdg_pck_qty1])/1000" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                                         AND I.GRP_N3RD_QTY >= TO_NUMBER(@[net_wgt])/TO_NUMBER(@[out_imdg_pck_qty1])/1000" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                                 )" ).append("\n"); 
		query.append("                                            )" ).append("\n"); 
		query.append("                                        )" ).append("\n"); 
		query.append("                                    OR ((I.IMDG_PCK_GRP_CD IS NULL" ).append("\n"); 
		query.append("                                         OR (I.GRP_N1ST_QTY IS NULL" ).append("\n"); 
		query.append("                                             AND I.GRP_N2ND_QTY IS NULL" ).append("\n"); 
		query.append("                                             AND I.GRP_N3RD_QTY IS NULL" ).append("\n"); 
		query.append("                                            )" ).append("\n"); 
		query.append("                                        )" ).append("\n"); 
		query.append("                                        AND (SUBSTR(I.IMDG_PCK_INSTR_CD, 0, 1) = 'P'" ).append("\n"); 
		query.append("                                             AND (TO_NUMBER(@[net_wgt])/TO_NUMBER(@[out_imdg_pck_qty1]) <= 400" ).append("\n"); 
		query.append("                                                  OR TO_NUMBER(@[grs_capa_qty])/TO_NUMBER(@[out_imdg_pck_qty1]) <= 450" ).append("\n"); 
		query.append("                                                 )" ).append("\n"); 
		query.append("                                            )" ).append("\n"); 
		query.append("                                            OR (SUBSTR(I.IMDG_PCK_INSTR_CD, 0, 1) = 'L'" ).append("\n"); 
		query.append("                                                AND (TO_NUMBER(@[net_wgt])/TO_NUMBER(@[out_imdg_pck_qty1]) >= 400" ).append("\n"); 
		query.append("                                                     OR TO_NUMBER(@[grs_capa_qty])/TO_NUMBER(@[out_imdg_pck_qty1]) >= 450" ).append("\n"); 
		query.append("                                                    )" ).append("\n"); 
		query.append("#if(${grs_capa_qty} != '' && ${grs_capa_qty}> 0)" ).append("\n"); 
		query.append("                                         AND TO_NUMBER(@[grs_capa_qty])/TO_NUMBER(@[out_imdg_pck_qty1]) <= 3000" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                                         AND TO_NUMBER(@[net_wgt])/TO_NUMBER(@[out_imdg_pck_qty1]) <= 3000" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                               )" ).append("\n"); 
		query.append("                                            OR (SUBSTR(I.IMDG_PCK_INSTR_CD, 0, 1) = 'I'" ).append("\n"); 
		query.append("#if(${grs_capa_qty} != '' && ${grs_capa_qty}> 0)" ).append("\n"); 
		query.append("                                         AND TO_NUMBER(@[grs_capa_qty])/TO_NUMBER(@[out_imdg_pck_qty1]) <= 3000" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                                         AND TO_NUMBER(@[net_wgt])/TO_NUMBER(@[out_imdg_pck_qty1]) <= 3000" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                               )" ).append("\n"); 
		query.append("                                       )" ).append("\n"); 
		query.append("                                 )" ).append("\n"); 
		query.append("                            ) = 0 THEN 'WOI|'||C.IMDG_PCK_GRP_CD||'|'||DECODE( C.IMDG_PCK_GRP_CD,'1', PPI.GRP_N1ST_QTY, '2', PPI.GRP_N2ND_QTY, '3', PPI.GRP_N3RD_QTY )||'|'" ).append("\n"); 
		query.append("                       ELSE 'V'" ).append("\n"); 
		query.append("                       END" ).append("\n"); 
		query.append("                 )" ).append("\n"); 
		query.append("            ELSE 'CHD'" ).append("\n"); 
		query.append("            END VLD_CHK" ).append("\n"); 
		query.append("  FROM PKG_INSTR_CNT C," ).append("\n"); 
		query.append("      (SELECT PI.IMDG_PCK_INSTR_CD, PI.IMDG_PCK_GRP_CD, PI.GRP_N1ST_QTY, PI.GRP_N2ND_QTY, PI.GRP_N3RD_QTY" ).append("\n"); 
		query.append("       FROM PKG_INSTR PI, INPUT_PKG_CD PP" ).append("\n"); 
		query.append("       WHERE PI.PCK_STY_CD = 'O'" ).append("\n"); 
		query.append("       AND PI.PCK_STY_CD = PP.IMDG_PCK_TP_CD" ).append("\n"); 
		query.append("       AND (PI.IMDG_PCK_CD = PP.IMDG_PCK_CD" ).append("\n"); 
		query.append("             OR (PI.IMDG_PCK_CD IS NULL   " ).append("\n"); 
		query.append("				 AND (PI.PCK_TP_CD = PP.PCK_KND_CD" ).append("\n"); 
		query.append("                      OR PI.PCK_MTRL_TP_CD = PP.PCK_MTRL_TP_CD" ).append("\n"); 
		query.append("                      )" ).append("\n"); 
		query.append("				 )" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("      ) PPI" ).append("\n"); 
		query.append("  WHERE C.IMDG_PCK_INSTR_CD = PPI.IMDG_PCK_INSTR_CD(+)" ).append("\n"); 
		query.append("    AND C.IMDG_PCK_GRP_CD   = PPI.IMDG_PCK_GRP_CD(+)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT CASE WHEN C.SGL_PKG_CNT > 0" ).append("\n"); 
		query.append("            THEN (CASE WHEN (SELECT COUNT(1)" ).append("\n"); 
		query.append("                               FROM PKG_INSTR I" ).append("\n"); 
		query.append("						  		   ,INPUT_PKG_CD P" ).append("\n"); 
		query.append("                              WHERE I.PCK_STY_CD = 'S'" ).append("\n"); 
		query.append("                                AND I.PCK_STY_CD = P.IMDG_PCK_TP_CD" ).append("\n"); 
		query.append("                                AND (I.IMDG_PCK_CD = P.IMDG_PCK_CD" ).append("\n"); 
		query.append("                                     OR (I.IMDG_PCK_CD IS NULL" ).append("\n"); 
		query.append("						                 AND (I.PCK_TP_CD = P.PCK_KND_CD" ).append("\n"); 
		query.append("                     					 	  OR I.PCK_MTRL_TP_CD = P.PCK_MTRL_TP_CD" ).append("\n"); 
		query.append("                     						 )" ).append("\n"); 
		query.append("					                    )" ).append("\n"); 
		query.append("                                    )" ).append("\n"); 
		query.append("                            ) = 0 THEN 'PGI|'||C.IMDG_PCK_INSTR_CD||'|'||@[imdg_un_no]||'|'" ).append("\n"); 
		query.append("                       WHEN (SELECT COUNT(1)" ).append("\n"); 
		query.append("                               FROM PKG_INSTR I" ).append("\n"); 
		query.append("						  		   ,INPUT_PKG_CD P" ).append("\n"); 
		query.append("                              WHERE I.PCK_STY_CD = 'S'" ).append("\n"); 
		query.append("                                AND I.PCK_STY_CD = P.IMDG_PCK_TP_CD" ).append("\n"); 
		query.append("                                AND (I.IMDG_PCK_CD = P.IMDG_PCK_CD" ).append("\n"); 
		query.append("                                     OR (I.IMDG_PCK_CD IS NULL" ).append("\n"); 
		query.append("						                 AND (I.PCK_TP_CD = P.PCK_KND_CD" ).append("\n"); 
		query.append("                     					 	  OR I.PCK_MTRL_TP_CD = P.PCK_MTRL_TP_CD" ).append("\n"); 
		query.append("                     						 )" ).append("\n"); 
		query.append("					                    )" ).append("\n"); 
		query.append("                                    )" ).append("\n"); 
		query.append("                                AND ((I.IMDG_PCK_GRP_CD = '1'" ).append("\n"); 
		query.append("                                      AND ((I.GRP_N1ST_MEAS_UT_CD = 'G'" ).append("\n"); 
		query.append("                                            AND I.GRP_N1ST_QTY >= TO_NUMBER(@[net_wgt])/TO_NUMBER(@[out_imdg_pck_qty1])*1000" ).append("\n"); 
		query.append("                                           )" ).append("\n"); 
		query.append("                                           OR (I.GRP_N1ST_MEAS_UT_CD = 'M'" ).append("\n"); 
		query.append("#if(${grs_capa_qty} != '' && ${grs_capa_qty}> 0)" ).append("\n"); 
		query.append("                                         AND I.GRP_N1ST_QTY >= TO_NUMBER(@[grs_capa_qty])/TO_NUMBER(@[out_imdg_pck_qty1])*1000" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                                         AND I.GRP_N1ST_QTY >= TO_NUMBER(@[net_wgt])/TO_NUMBER(@[out_imdg_pck_qty1])*1000" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                              )" ).append("\n"); 
		query.append("                                           OR (I.GRP_N1ST_MEAS_UT_CD = 'K'" ).append("\n"); 
		query.append("                                               AND I.GRP_N1ST_QTY >= TO_NUMBER(@[net_wgt])/TO_NUMBER(@[out_imdg_pck_qty1])" ).append("\n"); 
		query.append("                                              )" ).append("\n"); 
		query.append("                                           OR (I.GRP_N1ST_MEAS_UT_CD = 'L'" ).append("\n"); 
		query.append("#if(${grs_capa_qty} != '' && ${grs_capa_qty}> 0)" ).append("\n"); 
		query.append("                                         AND I.GRP_N1ST_QTY >= TO_NUMBER(@[grs_capa_qty])/TO_NUMBER(@[out_imdg_pck_qty1])" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                                         AND I.GRP_N1ST_QTY >= TO_NUMBER(@[net_wgt])/TO_NUMBER(@[out_imdg_pck_qty1])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                              )" ).append("\n"); 
		query.append("                                           OR (I.GRP_N1ST_MEAS_UT_CD = 'M3'" ).append("\n"); 
		query.append("#if(${grs_capa_qty} != '' && ${grs_capa_qty}> 0)" ).append("\n"); 
		query.append("                                         AND I.GRP_N1ST_QTY >= TO_NUMBER(@[grs_capa_qty])/TO_NUMBER(@[out_imdg_pck_qty1])/1000" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                                         AND I.GRP_N1ST_QTY >= TO_NUMBER(@[net_wgt])/TO_NUMBER(@[out_imdg_pck_qty1])/1000" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                              )" ).append("\n"); 
		query.append("                                         )" ).append("\n"); 
		query.append("                                     )" ).append("\n"); 
		query.append("                                     OR (I.IMDG_PCK_GRP_CD = '2'" ).append("\n"); 
		query.append("                                         AND ((I.GRP_N2ND_MEAS_UT_CD = 'G'" ).append("\n"); 
		query.append("                                               AND I.GRP_N2ND_QTY >= TO_NUMBER(@[net_wgt])/TO_NUMBER(@[out_imdg_pck_qty1])*1000" ).append("\n"); 
		query.append("                                              )" ).append("\n"); 
		query.append("                                              OR (I.GRP_N2ND_MEAS_UT_CD = 'M'" ).append("\n"); 
		query.append("#if(${grs_capa_qty} != '' && ${grs_capa_qty}> 0)" ).append("\n"); 
		query.append("                                         AND I.GRP_N2ND_QTY >= TO_NUMBER(@[grs_capa_qty])/TO_NUMBER(@[out_imdg_pck_qty1])*1000" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                                         AND I.GRP_N2ND_QTY >= TO_NUMBER(@[net_wgt])/TO_NUMBER(@[out_imdg_pck_qty1])*1000" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                                 )" ).append("\n"); 
		query.append("                                              OR (I.GRP_N2ND_MEAS_UT_CD = 'K'" ).append("\n"); 
		query.append("                                                  AND I.GRP_N2ND_QTY >= TO_NUMBER(@[net_wgt])/TO_NUMBER(@[out_imdg_pck_qty1])" ).append("\n"); 
		query.append("                                                 )" ).append("\n"); 
		query.append("                                              OR (I.GRP_N2ND_MEAS_UT_CD = 'L'" ).append("\n"); 
		query.append("#if(${grs_capa_qty} != '' && ${grs_capa_qty}> 0)" ).append("\n"); 
		query.append("                                         AND I.GRP_N2ND_QTY >= TO_NUMBER(@[grs_capa_qty])/TO_NUMBER(@[out_imdg_pck_qty1])" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                                         AND I.GRP_N2ND_QTY >= TO_NUMBER(@[net_wgt])/TO_NUMBER(@[out_imdg_pck_qty1])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                                 )" ).append("\n"); 
		query.append("                                              OR (I.GRP_N2ND_MEAS_UT_CD = 'M3'" ).append("\n"); 
		query.append("#if(${grs_capa_qty} != '' && ${grs_capa_qty}> 0)" ).append("\n"); 
		query.append("                                         AND I.GRP_N2ND_QTY >= TO_NUMBER(@[grs_capa_qty])/TO_NUMBER(@[out_imdg_pck_qty1])/1000" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                                         AND I.GRP_N2ND_QTY >= TO_NUMBER(@[net_wgt])/TO_NUMBER(@[out_imdg_pck_qty1])/1000" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                                 )" ).append("\n"); 
		query.append("                                            )" ).append("\n"); 
		query.append("                                        )" ).append("\n"); 
		query.append("                                     OR (I.IMDG_PCK_GRP_CD = '3'" ).append("\n"); 
		query.append("                                         AND ((I.GRP_N3RD_MEAS_UT_CD = 'G'" ).append("\n"); 
		query.append("                                               AND I.GRP_N3RD_QTY >= TO_NUMBER(@[net_wgt])/TO_NUMBER(@[out_imdg_pck_qty1])*1000" ).append("\n"); 
		query.append("                                              )" ).append("\n"); 
		query.append("                                              OR (I.GRP_N3RD_MEAS_UT_CD = 'M'" ).append("\n"); 
		query.append("#if(${grs_capa_qty} != '' && ${grs_capa_qty}> 0)" ).append("\n"); 
		query.append("                                         AND I.GRP_N3RD_QTY >= TO_NUMBER(@[grs_capa_qty])/TO_NUMBER(@[out_imdg_pck_qty1])*1000" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                                         AND I.GRP_N3RD_QTY >= TO_NUMBER(@[net_wgt])/TO_NUMBER(@[out_imdg_pck_qty1])*1000" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                                 )" ).append("\n"); 
		query.append("                                              OR (I.GRP_N3RD_MEAS_UT_CD = 'K'" ).append("\n"); 
		query.append("                                                  AND I.GRP_N3RD_QTY >= TO_NUMBER(@[net_wgt])/TO_NUMBER(@[out_imdg_pck_qty1])" ).append("\n"); 
		query.append("                                                 )" ).append("\n"); 
		query.append("                                              OR (I.GRP_N3RD_MEAS_UT_CD = 'L'" ).append("\n"); 
		query.append("#if(${grs_capa_qty} != '' && ${grs_capa_qty}> 0)" ).append("\n"); 
		query.append("                                         AND I.GRP_N3RD_QTY >= TO_NUMBER(@[grs_capa_qty])/TO_NUMBER(@[out_imdg_pck_qty1])" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                                         AND I.GRP_N3RD_QTY >= TO_NUMBER(@[net_wgt])/TO_NUMBER(@[out_imdg_pck_qty1])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                                 )" ).append("\n"); 
		query.append("                                              OR (I.GRP_N3RD_MEAS_UT_CD = 'M3'" ).append("\n"); 
		query.append("#if(${grs_capa_qty} != '' && ${grs_capa_qty}> 0)" ).append("\n"); 
		query.append("                                         AND I.GRP_N3RD_QTY >= TO_NUMBER(@[grs_capa_qty])/TO_NUMBER(@[out_imdg_pck_qty1])/1000" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                                         AND I.GRP_N3RD_QTY >= TO_NUMBER(@[net_wgt])/TO_NUMBER(@[out_imdg_pck_qty1])/1000" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                                 )" ).append("\n"); 
		query.append("                                            )" ).append("\n"); 
		query.append("                                        )" ).append("\n"); 
		query.append("                                    OR ((I.IMDG_PCK_GRP_CD IS NULL" ).append("\n"); 
		query.append("                                         OR (I.GRP_N1ST_QTY IS NULL" ).append("\n"); 
		query.append("                                             AND I.GRP_N2ND_QTY IS NULL" ).append("\n"); 
		query.append("                                             AND I.GRP_N3RD_QTY IS NULL" ).append("\n"); 
		query.append("                                            )" ).append("\n"); 
		query.append("                                        )" ).append("\n"); 
		query.append("                                        AND (SUBSTR(I.IMDG_PCK_INSTR_CD, 0, 1) = 'P'" ).append("\n"); 
		query.append("                                             AND (TO_NUMBER(@[net_wgt])/TO_NUMBER(@[out_imdg_pck_qty1]) <= 400" ).append("\n"); 
		query.append("                                                  OR TO_NUMBER(@[grs_capa_qty])/TO_NUMBER(@[out_imdg_pck_qty1]) <= 450" ).append("\n"); 
		query.append("                                                 )" ).append("\n"); 
		query.append("                                            )" ).append("\n"); 
		query.append("                                            OR (SUBSTR(I.IMDG_PCK_INSTR_CD, 0, 1) = 'L'" ).append("\n"); 
		query.append("                                                AND (TO_NUMBER(@[net_wgt])/TO_NUMBER(@[out_imdg_pck_qty1]) >= 400" ).append("\n"); 
		query.append("                                                     OR TO_NUMBER(@[grs_capa_qty])/TO_NUMBER(@[out_imdg_pck_qty1]) >= 450" ).append("\n"); 
		query.append("                                                    )" ).append("\n"); 
		query.append("#if(${grs_capa_qty} != '' && ${grs_capa_qty}> 0)" ).append("\n"); 
		query.append("                                         AND TO_NUMBER(@[grs_capa_qty])/TO_NUMBER(@[out_imdg_pck_qty1]) <= 3000" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                                         AND TO_NUMBER(@[net_wgt])/TO_NUMBER(@[out_imdg_pck_qty1]) <= 3000" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                               )" ).append("\n"); 
		query.append("                                            OR (SUBSTR(I.IMDG_PCK_INSTR_CD, 0, 1) = 'I'" ).append("\n"); 
		query.append("#if(${grs_capa_qty} != '' && ${grs_capa_qty}> 0)" ).append("\n"); 
		query.append("                                         AND TO_NUMBER(@[grs_capa_qty])/TO_NUMBER(@[out_imdg_pck_qty1]) <= 3000" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                                         AND TO_NUMBER(@[net_wgt])/TO_NUMBER(@[out_imdg_pck_qty1]) <= 3000" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                               )" ).append("\n"); 
		query.append("                                       )" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("                                    )" ).append("\n"); 
		query.append("                            ) = 0 THEN 'WGI|'||C.IMDG_PCK_GRP_CD||'|'||DECODE( C.IMDG_PCK_GRP_CD,'1', PPI.GRP_N1ST_QTY, '2', PPI.GRP_N2ND_QTY, '3', PPI.GRP_N3RD_QTY )||'|'" ).append("\n"); 
		query.append("                       ELSE 'V'" ).append("\n"); 
		query.append("                       END" ).append("\n"); 
		query.append("                 )" ).append("\n"); 
		query.append("            ELSE 'PGI|'||C.IMDG_PCK_INSTR_CD||'|'||@[imdg_un_no]||'|'" ).append("\n"); 
		query.append("            END VLD_CHK" ).append("\n"); 
		query.append("  FROM PKG_INSTR_CNT C," ).append("\n"); 
		query.append(" (SELECT PI.IMDG_PCK_INSTR_CD, PI.IMDG_PCK_GRP_CD, PI.GRP_N1ST_QTY, PI.GRP_N2ND_QTY, PI.GRP_N3RD_QTY" ).append("\n"); 
		query.append("       FROM PKG_INSTR PI, INPUT_PKG_CD PP" ).append("\n"); 
		query.append("       WHERE PI.PCK_STY_CD = 'S'" ).append("\n"); 
		query.append("       AND PI.PCK_STY_CD = PP.IMDG_PCK_TP_CD" ).append("\n"); 
		query.append("       AND (PI.IMDG_PCK_CD = PP.IMDG_PCK_CD" ).append("\n"); 
		query.append("            OR (PI.IMDG_PCK_CD IS NULL   " ).append("\n"); 
		query.append("				AND (PI.PCK_TP_CD = PP.PCK_KND_CD" ).append("\n"); 
		query.append("                      OR PI.PCK_MTRL_TP_CD = PP.PCK_MTRL_TP_CD" ).append("\n"); 
		query.append("                     )" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("      ) PPI" ).append("\n"); 
		query.append("  WHERE C.IMDG_PCK_INSTR_CD = PPI.IMDG_PCK_INSTR_CD(+)" ).append("\n"); 
		query.append("  AND   C.IMDG_PCK_GRP_CD = PPI.IMDG_PCK_GRP_CD(+)" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}