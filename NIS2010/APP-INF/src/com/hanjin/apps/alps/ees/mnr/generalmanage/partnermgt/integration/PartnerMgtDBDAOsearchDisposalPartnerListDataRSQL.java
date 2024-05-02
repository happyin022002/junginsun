/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : PartnerMgtDBDAOsearchDisposalPartnerListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.04.27
*@LastModifier : 
*@LastVersion : 1.0
* 2018.04.27 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.generalmanage.partnermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PartnerMgtDBDAOsearchDisposalPartnerListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2012.11.08 조경완 [CHM-201220026-01] CTRL RHQ AND OFFICE 로 조회하는 기능 구현 요청
	  * 								- Creation Office 조건은 MNR_PARTNER.CTRL_OFC_CD IN (Multi CreOfc), 
	  * 								- CTRL Office 조회는 MNR_PRNR_CNTC_PNT.OFC_CD IN (Multi CtrlOfc) 로 조회된 Data Display되도록 개발 
	  * </pre>
	  */
	public PartnerMgtDBDAOsearchDisposalPartnerListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_prnr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tocal",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_grp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_prnr_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_prnr_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_mnr_prnr_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_mnr_prnr_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fromcal",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("param_ctrl_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sp_ptal_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrl_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.generalmanage.partnermgt.integration").append("\n"); 
		query.append("FileName : PartnerMgtDBDAOsearchDisposalPartnerListDataRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("         A.MNR_PRNR_CRE_SEQ" ).append("\n"); 
		query.append("        ,A.CTRL_OFC_CD" ).append("\n"); 
		query.append("        ,(SELECT MPCP.OFC_CD" ).append("\n"); 
		query.append("            FROM MNR_PRNR_CNTC_PNT MPCP" ).append("\n"); 
		query.append("           WHERE MPCP.MNR_PRNR_CRE_SEQ = A.MNR_PRNR_CRE_SEQ" ).append("\n"); 
		query.append("             AND ROWNUM = 1" ).append("\n"); 
		query.append("          ) AS CRE_OFC_CD" ).append("\n"); 
		query.append("        ,A.MNR_GRP_TP_CD" ).append("\n"); 
		query.append("        ,A.MNR_PRNR_TP_CD" ).append("\n"); 
		query.append("        ,A.MNR_PRNR_KND_CD" ).append("\n"); 
		query.append("        ,A.MNR_PRNR_KND_DTL_CD" ).append("\n"); 
		query.append("        ,A.MNR_PRNR_STS_CD" ).append("\n"); 
		query.append("        ,A.MNR_PRNR_CNT_CD" ).append("\n"); 
		query.append("        ,MNR_COMMON_PKG.MNR_CONV_PARTNER_CD_FNC(A.MNR_PRNR_SEQ) AS MNR_PRNR_SEQ" ).append("\n"); 
		query.append("        ,MNR_COMMON_PKG.MNR_CONV_PARTNER_CD_FNC(A.MNR_PRNR_SEQ, A.MNR_PRNR_CNT_CD) AS MNR_PRNR_CNT_CD_SEQ" ).append("\n"); 
		query.append("        ,A.EDI_ID" ).append("\n"); 
		query.append("        ,A.SP_PTAL_ID" ).append("\n"); 
		query.append("        ,A.SP_PTAL_PWD" ).append("\n"); 
		query.append("        ,A.MNR_PRNR_LGL_ENG_NM" ).append("\n"); 
		query.append("        ,A.MNR_PRNR_LOCL_LANG_NM" ).append("\n"); 
		query.append("        ,A.MNR_PRNR_ADDR" ).append("\n"); 
		query.append("        ,A.BZET_ADDR" ).append("\n"); 
		query.append("        ,A.MNR_BIL_TO_NM" ).append("\n"); 
		query.append("        ,TO_CHAR(A.EFF_DT, 'yyyy-mm-dd') EFF_DT" ).append("\n"); 
		query.append("        ,TO_CHAR(A.EXP_DT, 'yyyy-mm-dd') EXP_DT" ).append("\n"); 
		query.append("        ,A.BANK_NM" ).append("\n"); 
		query.append("        ,A.BANK_ACCT_NO" ).append("\n"); 
		query.append("        ,A.PAY_MZD_CD" ).append("\n"); 
		query.append("        ,A.PAY_TERM_DYS" ).append("\n"); 
		query.append("        ,A.ZIP_CD" ).append("\n"); 
		query.append("        ,A.OWNR_NM" ).append("\n"); 
		query.append("        ,A.BZCT_NM" ).append("\n"); 
		query.append("        ,A.BZTP_NM" ).append("\n"); 
		query.append("        ,A.BIZ_RGST_NO" ).append("\n"); 
		query.append("        ,A.MNR_SHOP_FLG" ).append("\n"); 
		query.append("        ,A.MNR_PAYR_CNT_CD" ).append("\n"); 
		query.append("        ,A.MNR_PAYR_SEQ" ).append("\n"); 
		query.append("        ,A.MNR_PRNR_CAPI_AMT" ).append("\n"); 
		query.append("        ,A.EMPE_KNT" ).append("\n"); 
		query.append("        ,A.DPT_DESC" ).append("\n"); 
		query.append("        ,A.MNR_PRNR_ABBR_NM" ).append("\n"); 
		query.append("        ,A.INTL_PHN_NO" ).append("\n"); 
		query.append("        ,A.PHN_NO" ).append("\n"); 
		query.append("        ,A.INTL_FAX_NO" ).append("\n"); 
		query.append("        ,A.FAX_NO" ).append("\n"); 
		query.append("        ,A.MNR_PRNR_EML" ).append("\n"); 
		query.append("        ,A.MNR_PRNR_RMK" ).append("\n"); 
		query.append("        ,A.TRSM_MOD_CD" ).append("\n"); 
		query.append("        ,A.FILE_SEQ" ).append("\n"); 
		query.append("        ,A.CRE_USR_ID" ).append("\n"); 
		query.append("		,A.DELT_FLG" ).append("\n"); 
		query.append("		,TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(MNR_COMMON_PKG.MNR_GET_HOOFC_FNC(), A.CRE_DT,@[user_ofc_cd]), 'YYYY-MM-DD') AS CRE_DT" ).append("\n"); 
		query.append("        ,A.UPD_USR_ID" ).append("\n"); 
		query.append("        ,TO_CHAR(A.UPD_DT, 'yyyy-mm-dd') UPD_DT" ).append("\n"); 
		query.append("		,(SELECT" ).append("\n"); 
		query.append("				A1.CUST_LGL_ENG_NM " ).append("\n"); 
		query.append("				FROM MDM_CUSTOMER A1, MDM_CUST_ADDR B1" ).append("\n"); 
		query.append("				WHERE 1 = 1" ).append("\n"); 
		query.append("				AND A1.CUST_CNT_CD = B1.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("				AND A1.CUST_SEQ = B1.CUST_SEQ(+)" ).append("\n"); 
		query.append("				AND B1.PRMRY_CHK_FLG(+) = 'Y'" ).append("\n"); 
		query.append("                AND A1.CUST_CNT_CD  = A.MNR_PRNR_CNT_CD" ).append("\n"); 
		query.append("                AND A1.CUST_SEQ = A.MNR_PRNR_SEQ" ).append("\n"); 
		query.append("				AND MNR_COMMON_PKG.MNR_CONV_PARTNER_CD_FNC(A1.CUST_SEQ, A1.CUST_CNT_CD) =MNR_COMMON_PKG.MNR_CONV_PARTNER_CD_FNC(A.MNR_PRNR_SEQ, A.MNR_PRNR_CNT_CD)" ).append("\n"); 
		query.append("		        AND ROWNUM = 1" ).append("\n"); 
		query.append("         ) AS MNR_PRNR_CNT_NM" ).append("\n"); 
		query.append("		,(SELECT" ).append("\n"); 
		query.append("		  A1.MNR_CD_DP_DESC" ).append("\n"); 
		query.append("		  FROM MNR_GEN_CD A1" ).append("\n"); 
		query.append("		  WHERE A1.PRNT_CD_ID = 'CD00053'" ).append("\n"); 
		query.append("		  AND A1.MNR_CD_ID=A.MNR_PRNR_STS_CD" ).append("\n"); 
		query.append("		 ) AS MNR_PRNR_STS_NM" ).append("\n"); 
		query.append("        ,A.MNR_SWIFT_NO" ).append("\n"); 
		query.append("		,(SELECT COUNT(*)" ).append("\n"); 
		query.append("           FROM MNR_DISP_DTL" ).append("\n"); 
		query.append("           WHERE MNR_PRNR_SEQ IS NOT NULL" ).append("\n"); 
		query.append("             AND MNR_PRNR_CNT_CD =A.MNR_PRNR_CNT_CD" ).append("\n"); 
		query.append("             AND MNR_PRNR_SEQ =A.MNR_PRNR_SEQ" ).append("\n"); 
		query.append("		     AND ROWNUM = 1" ).append("\n"); 
		query.append("         ) AS DISP_CNT" ).append("\n"); 
		query.append("		,DECODE(@[user_ofc_cd],MNR_COMMON_PKG.MNR_GET_HOOFC_FNC(),'A'" ).append("\n"); 
		query.append("               ,MNR_COMMON_PKG.MNR_GET_RHQ_OFC_FNC(@[user_ofc_cd]),DECODE(A.MNR_PRNR_KND_CD,'G','C','A')" ).append("\n"); 
		query.append("               ,DECODE(A.MNR_PRNR_KND_CD,'G','C','B')) AS BTN_FLG" ).append("\n"); 
		query.append("FROM MNR_PARTNER A" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${ctrl_ofc_cd} != '') " ).append("\n"); 
		query.append("AND   A.CTRL_OFC_CD = @[ctrl_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${mnr_grp_tp_cd} != '') " ).append("\n"); 
		query.append("AND   A.MNR_GRP_TP_CD = @[mnr_grp_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${mnr_prnr_tp_cd} != '') " ).append("\n"); 
		query.append("AND   A.MNR_PRNR_TP_CD = @[mnr_prnr_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${in_mnr_prnr_knd_cd} != '') " ).append("\n"); 
		query.append("AND   A.MNR_PRNR_KND_CD = @[in_mnr_prnr_knd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${in_mnr_prnr_sts_cd} != '') " ).append("\n"); 
		query.append("AND   A.MNR_PRNR_STS_CD = @[in_mnr_prnr_sts_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${fromcal} != '' && ${tocal} != '') " ).append("\n"); 
		query.append("AND A.CRE_DT BETWEEN GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[user_ofc_cd], TO_DATE(@[fromcal], 'YYYY-MM-DD'),MNR_COMMON_PKG.MNR_GET_HOOFC_FNC()) AND GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[user_ofc_cd], TO_DATE(@[tocal] , 'YYYY-MM-DD'),MNR_COMMON_PKG.MNR_GET_HOOFC_FNC())+0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${mnr_prnr_cnt_cd} != '') " ).append("\n"); 
		query.append("AND A.MNR_PRNR_CNT_CD = @[mnr_prnr_cnt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${mnr_prnr_seq} != '') " ).append("\n"); 
		query.append("AND lpad(NVL(A.MNR_PRNR_SEQ,0),6,0) = @[mnr_prnr_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sp_ptal_id} != '') " ).append("\n"); 
		query.append("AND A.SP_PTAL_ID = @[sp_ptal_id]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND A.MNR_PRNR_CRE_SEQ IN (" ).append("\n"); 
		query.append("    SELECT MP.MNR_PRNR_CRE_SEQ" ).append("\n"); 
		query.append("    FROM   MNR_PARTNER MP, MNR_PRNR_CNTC_PNT MPCP" ).append("\n"); 
		query.append("    WHERE  MP.MNR_PRNR_KND_CD = 'G'" ).append("\n"); 
		query.append("    AND    MP.MNR_PRNR_CRE_SEQ = MPCP.MNR_PRNR_CRE_SEQ" ).append("\n"); 
		query.append("    AND    @[user_ofc_cd] IN ('SINRS', 'SINRSO', 'NYCRA', 'NYCRAO', 'HAMRU', 'HAMRUO', 'SHARC', 'SHARCO', 'SELCON')" ).append("\n"); 
		query.append("    -- 2011514 조경완 [CHM-201220026] Creation Offic, CTRL Office 조건으로 조회" ).append("\n"); 
		query.append("    #if(${cre_ofc_cd} != '')" ).append("\n"); 
		query.append("	   AND MP.CTRL_OFC_CD = @[cre_ofc_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if(${param_ctrl_ofc_cd} != '')" ).append("\n"); 
		query.append("       AND MPCP.OFC_CD = @[param_ctrl_ofc_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT MP.MNR_PRNR_CRE_SEQ" ).append("\n"); 
		query.append("    FROM   MNR_PARTNER MP, MNR_PRNR_CNTC_PNT MPCP " ).append("\n"); 
		query.append("    WHERE  MP.MNR_PRNR_KND_CD = 'R'" ).append("\n"); 
		query.append("    AND    MP.MNR_PRNR_CRE_SEQ = MPCP.MNR_PRNR_CRE_SEQ" ).append("\n"); 
		query.append("    AND    MPCP.OFC_CD = DECODE(@[user_ofc_cd], MNR_COMMON_PKG.MNR_GET_HOOFC_FNC(), MPCP.OFC_CD, MNR_COMMON_PKG.MNR_GET_RHQ_OFC_FNC(@[user_ofc_cd]))" ).append("\n"); 
		query.append("    AND    @[user_ofc_cd] IN ('SINRS', 'SINRSO', 'NYCRA', 'NYCRAO', 'HAMRU', 'HAMRUO', 'SHARC', 'SHARCO', 'SELCON')" ).append("\n"); 
		query.append("    #if(${cre_ofc_cd} != '')" ).append("\n"); 
		query.append("	   AND MP.CTRL_OFC_CD = @[cre_ofc_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if(${param_ctrl_ofc_cd} != '')" ).append("\n"); 
		query.append("       AND MPCP.OFC_CD = @[param_ctrl_ofc_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT MP.MNR_PRNR_CRE_SEQ" ).append("\n"); 
		query.append("    FROM   MNR_PARTNER MP, MNR_PRNR_CNTC_PNT MPCP " ).append("\n"); 
		query.append("    WHERE  MP.MNR_PRNR_KND_CD  = 'L'" ).append("\n"); 
		query.append("    AND    MP.MNR_PRNR_CRE_SEQ = MPCP.MNR_PRNR_CRE_SEQ" ).append("\n"); 
		query.append("    AND    (MPCP.OFC_CD         = DECODE(@[user_ofc_cd], MNR_COMMON_PKG.MNR_GET_HOOFC_FNC(), MPCP.OFC_CD, @[user_ofc_cd])" ).append("\n"); 
		query.append("            OR     MP.CTRL_OFC_CD        = DECODE(@[user_ofc_cd], MNR_COMMON_PKG.MNR_GET_HOOFC_FNC(), MPCP.OFC_CD, @[user_ofc_cd]))" ).append("\n"); 
		query.append("    #if(${cre_ofc_cd} != '')" ).append("\n"); 
		query.append("	   AND MP.CTRL_OFC_CD = @[cre_ofc_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if(${param_ctrl_ofc_cd} != '')" ).append("\n"); 
		query.append("       AND MPCP.OFC_CD = @[param_ctrl_ofc_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("ORDER BY A.MNR_PRNR_CRE_SEQ DESC" ).append("\n"); 

	}
}