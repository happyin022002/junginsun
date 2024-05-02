/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BlRatingDBDAOManageTPFSurchargeCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.29
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.29 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BlRatingDBDAOManageTPFSurchargeCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TPF Interface
	  * Group Rating에서는 I/F여부를 사용자에게 확인받지 않고 무조건 I/F진행.
	  * </pre>
	  */
	public BlRatingDBDAOManageTPFSurchargeCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("ca_flag",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration").append("\n"); 
		query.append("FileName : BlRatingDBDAOManageTPFSurchargeCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_CHG_RT" ).append("\n"); 
		query.append("(      BKG_NO," ).append("\n"); 
		query.append("       RT_SEQ," ).append("\n"); 
		query.append("       DP_SEQ," ).append("\n"); 
		query.append("       FRT_TERM_CD," ).append("\n"); 
		query.append("       CGO_CATE_CD," ).append("\n"); 
		query.append("       CHG_CD," ).append("\n"); 
		query.append("       CURR_CD," ).append("\n"); 
		query.append("       RAT_UT_CD," ).append("\n"); 
		query.append("       RAT_AS_QTY," ).append("\n"); 
		query.append("       CHG_UT_AMT," ).append("\n"); 
		query.append("       CHG_AMT," ).append("\n"); 
		query.append("       RCV_TERM_CD," ).append("\n"); 
		query.append("       DE_TERM_CD," ).append("\n"); 
		query.append("       N3PTY_RCV_OFC_CD," ).append("\n"); 
		query.append("       N3PTY_CUST_CNT_CD," ).append("\n"); 
		query.append("       N3PTY_CUST_SEQ," ).append("\n"); 
		query.append("       FRT_INCL_XCLD_DIV_CD," ).append("\n"); 
		query.append("       PRN_HDN_FLG," ).append("\n"); 
		query.append("       AUTO_RAT_CD," ).append("\n"); 
		query.append("       CRE_USR_ID," ).append("\n"); 
		query.append("       CRE_DT," ).append("\n"); 
		query.append("       UPD_USR_ID," ).append("\n"); 
		query.append("       UPD_DT" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT DISTINCT BK.BKG_NO," ).append("\n"); 
		query.append("       NVL((SELECT MAX(RT_SEQ) " ).append("\n"); 
		query.append("             FROM BKG_CHG_RT " ).append("\n"); 
		query.append("            WHERE BKG_NO = @[bkg_no]), 0) + 1,       " ).append("\n"); 
		query.append("       (SELECT A.DP_SEQ FROM MDM_CHARGE A WHERE A.CHG_CD='TPF' AND DELT_FLG='N') DP_SEQ," ).append("\n"); 
		query.append("       DECODE(SR.PAY_TERM_CD, 'O', OFT_TERM_CD,SR.PAY_TERM_CD) FRT_TERM_CD," ).append("\n"); 
		query.append("       'DR' CGO_CATE_CD," ).append("\n"); 
		query.append("       'TPF' CHG_CD," ).append("\n"); 
		query.append("       SR.CURR_CD," ).append("\n"); 
		query.append("       SR.RAT_UT_CD," ).append("\n"); 
		query.append("       1 RAT_AS_QTY," ).append("\n"); 
		query.append("       SR.SCG_AMT CHG_UT_AMT," ).append("\n"); 
		query.append("       SR.SCG_AMT CHG_AMT," ).append("\n"); 
		query.append("       BK.RCV_TERM_CD," ).append("\n"); 
		query.append("       BK.DE_TERM_CD," ).append("\n"); 
		query.append("       DECODE(RT.OFC_CNT,1,N3PTY_RCV_OFC_CD) N3PTY_RCV_OFC_CD," ).append("\n"); 
		query.append("       DECODE(RT.CUST_CNT,1,N3PTY_CUST_CNT_CD) N3PTY_CUST_CNT_CD," ).append("\n"); 
		query.append("       DECODE(RT.CUST_CNT,1,N3PTY_CUST_SEQ) N3PTY_CUST_SEQ," ).append("\n"); 
		query.append("       'N' FRT_INCL_XCLD_DIV_CD," ).append("\n"); 
		query.append("       'N' PRN_HDN_FLG," ).append("\n"); 
		query.append("       'I' AUTO_RAT_CD," ).append("\n"); 
		query.append("       @[usr_id]," ).append("\n"); 
		query.append("       SYSDATE," ).append("\n"); 
		query.append("       @[usr_id]," ).append("\n"); 
		query.append("       SYSDATE" ).append("\n"); 
		query.append("FROM   PRI_SCG_PRF SP," ).append("\n"); 
		query.append("       PRI_SCG_RT SR," ).append("\n"); 
		query.append("       MDM_CHARGE MC," ).append("\n"); 
		query.append("       (SELECT DISTINCT BKG_NO, FRT_TERM_CD," ).append("\n"); 
		query.append("               CASE WHEN N3PTY_RCV_OFC_CD = 'HKGSC' OR L.CNT_CD <> 'CN' THEN N3PTY_RCV_OFC_CD" ).append("\n"); 
		query.append("                    ELSE NULL" ).append("\n"); 
		query.append("               END N3PTY_RCV_OFC_CD," ).append("\n"); 
		query.append("               N3PTY_CUST_CNT_CD," ).append("\n"); 
		query.append("               N3PTY_CUST_SEQ," ).append("\n"); 
		query.append("               COUNT(DISTINCT N3PTY_RCV_OFC_CD) OVER (PARTITION BY 1) OFC_CNT," ).append("\n"); 
		query.append("               COUNT(DISTINCT N3PTY_CUST_CNT_CD||N3PTY_CUST_SEQ) OVER (PARTITION BY 1) CUST_CNT" ).append("\n"); 
		query.append("        FROM BKG_CHG_RT R, MDM_ORGANIZATION O, MDM_LOCATION L" ).append("\n"); 
		query.append("        WHERE R.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("        AND @[ca_flag] = 'N'" ).append("\n"); 
		query.append("        AND R.FRT_INCL_XCLD_DIV_CD = 'N'" ).append("\n"); 
		query.append("        AND R.N3PTY_RCV_OFC_CD IS NOT NULL" ).append("\n"); 
		query.append("        AND O.OFC_CD = R.N3PTY_RCV_OFC_CD" ).append("\n"); 
		query.append("        AND L.LOC_CD = O.LOC_CD" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT DISTINCT BKG_NO, FRT_TERM_CD, " ).append("\n"); 
		query.append("               CASE WHEN N3PTY_RCV_OFC_CD = 'HKGSC' OR L.CNT_CD <> 'CN' THEN N3PTY_RCV_OFC_CD" ).append("\n"); 
		query.append("                    ELSE NULL" ).append("\n"); 
		query.append("               END N3PTY_RCV_OFC_CD," ).append("\n"); 
		query.append("               N3PTY_CUST_CNT_CD," ).append("\n"); 
		query.append("               N3PTY_CUST_SEQ," ).append("\n"); 
		query.append("               COUNT(DISTINCT N3PTY_RCV_OFC_CD) OVER (PARTITION BY 1) OFC_CNT," ).append("\n"); 
		query.append("               COUNT(DISTINCT N3PTY_CUST_CNT_CD||N3PTY_CUST_SEQ) OVER (PARTITION BY 1) CUST_CNT" ).append("\n"); 
		query.append("        FROM BKG_CHG_RT_HIS R, MDM_ORGANIZATION O, MDM_LOCATION L" ).append("\n"); 
		query.append("        WHERE R.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("        AND @[ca_flag] = 'Y'" ).append("\n"); 
		query.append("        AND R.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("        AND R.FRT_INCL_XCLD_DIV_CD = 'N'" ).append("\n"); 
		query.append("        AND R.N3PTY_RCV_OFC_CD IS NOT NULL" ).append("\n"); 
		query.append("        AND O.OFC_CD = R.N3PTY_RCV_OFC_CD" ).append("\n"); 
		query.append("        AND L.LOC_CD = O.LOC_CD) RT," ).append("\n"); 
		query.append("       (SELECT  BK.BKG_NO," ).append("\n"); 
		query.append("                BR.RT_APLY_DT," ).append("\n"); 
		query.append("                BK.SVC_SCP_CD," ).append("\n"); 
		query.append("                BK.RCV_TERM_CD," ).append("\n"); 
		query.append("                BK.DE_TERM_CD," ).append("\n"); 
		query.append("                BK.POR_CD," ).append("\n"); 
		query.append("                BK.POL_CD," ).append("\n"); 
		query.append("                BK.POD_CD," ).append("\n"); 
		query.append("                BK.DEL_CD," ).append("\n"); 
		query.append("                CASE WHEN POR.CNT_CD = 'CN' OR POL.CNT_CD = 'CN' THEN 'P'" ).append("\n"); 
		query.append("                     WHEN POD.CNT_CD = 'CN' OR DEL.CNT_CD = 'CN' THEN 'C'" ).append("\n"); 
		query.append("                     ELSE NULL" ).append("\n"); 
		query.append("                END FRT_TERM_CD," ).append("\n"); 
		query.append("                CASE WHEN PPD.CNT_CD <> 'CN' OR BR.PPD_RCV_OFC_CD = 'HKGSC' THEN BR.PPD_RCV_OFC_CD" ).append("\n"); 
		query.append("                     ELSE NULL" ).append("\n"); 
		query.append("                END PPD_RCV_OFC_CD," ).append("\n"); 
		query.append("                CASE WHEN CCT.CNT_CD <> 'CN' OR BR.CLT_OFC_CD = 'HKGSC' THEN BR.CLT_OFC_CD" ).append("\n"); 
		query.append("                END CLT_OFC_CD," ).append("\n"); 
		query.append("                POR.CNT_CD||POR.STE_CD POR_STE_CD," ).append("\n"); 
		query.append("                POR.RGN_CD POR_RGN_CD," ).append("\n"); 
		query.append("                POR.CNT_CD POR_CNT_CD," ).append("\n"); 
		query.append("                POL.CNT_CD||POL.STE_CD POL_STE_CD," ).append("\n"); 
		query.append("                POL.RGN_CD POL_RGN_CD," ).append("\n"); 
		query.append("                POL.CNT_CD POL_CNT_CD," ).append("\n"); 
		query.append("                POD.CNT_CD||POD.STE_CD POD_STE_CD," ).append("\n"); 
		query.append("                POD.RGN_CD POD_RGN_CD," ).append("\n"); 
		query.append("                POD.CNT_CD POD_CNT_CD," ).append("\n"); 
		query.append("                DEL.CNT_CD||DEL.STE_CD DEL_STE_CD," ).append("\n"); 
		query.append("                DEL.RGN_CD DEL_RGN_CD," ).append("\n"); 
		query.append("                DEL.CNT_CD DEL_CNT_CD," ).append("\n"); 
		query.append("               (SELECT FRT_TERM_CD" ).append("\n"); 
		query.append("                FROM BKG_CHG_RT " ).append("\n"); 
		query.append("                WHERE BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("                AND @[ca_flag] = 'N'" ).append("\n"); 
		query.append("                AND CHG_CD = 'OFT'" ).append("\n"); 
		query.append("                AND ROWNUM = 1) OFT_TERM_CD," ).append("\n"); 
		query.append("               (SELECT SUM(CHG_AMT)" ).append("\n"); 
		query.append("                FROM BKG_CHG_RT " ).append("\n"); 
		query.append("                WHERE BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("                AND @[ca_flag] = 'N'" ).append("\n"); 
		query.append("                AND FRT_INCL_XCLD_DIV_CD = 'N'" ).append("\n"); 
		query.append("                AND FRT_TERM_CD = 'P') PPD_AMT," ).append("\n"); 
		query.append("               (SELECT SUM(CHG_AMT)" ).append("\n"); 
		query.append("                FROM BKG_CHG_RT " ).append("\n"); 
		query.append("                WHERE BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("                AND @[ca_flag] = 'N'" ).append("\n"); 
		query.append("                AND FRT_INCL_XCLD_DIV_CD = 'N'" ).append("\n"); 
		query.append("                AND FRT_TERM_CD = 'C') CLT_AMT" ).append("\n"); 
		query.append("        FROM BKG_BOOKING BK," ).append("\n"); 
		query.append("             BKG_RATE    BR," ).append("\n"); 
		query.append("             MDM_ORGANIZATION PO," ).append("\n"); 
		query.append("             MDM_ORGANIZATION CO," ).append("\n"); 
		query.append("             MDM_LOCATION POR," ).append("\n"); 
		query.append("             MDM_LOCATION POL," ).append("\n"); 
		query.append("             MDM_LOCATION POD," ).append("\n"); 
		query.append("             MDM_LOCATION DEL," ).append("\n"); 
		query.append("             MDM_LOCATION PPD," ).append("\n"); 
		query.append("             MDM_LOCATION CCT" ).append("\n"); 
		query.append("        WHERE BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("        AND @[ca_flag]     = 'N'" ).append("\n"); 
		query.append("        AND BK.BKG_NO   = BR.BKG_NO" ).append("\n"); 
		query.append("        AND POR.LOC_CD  = BK.POR_CD " ).append("\n"); 
		query.append("        AND POL.LOC_CD  = BK.POL_CD " ).append("\n"); 
		query.append("        AND POD.LOC_CD  = BK.POD_CD " ).append("\n"); 
		query.append("        AND DEL.LOC_CD  = BK.DEL_CD" ).append("\n"); 
		query.append("        AND PO.OFC_CD   = BR.PPD_RCV_OFC_CD" ).append("\n"); 
		query.append("        AND PPD.LOC_CD  = PO.LOC_CD " ).append("\n"); 
		query.append("        AND CO.OFC_CD   = BR.CLT_OFC_CD" ).append("\n"); 
		query.append("        AND CCT.LOC_CD  = CO.LOC_CD " ).append("\n"); 
		query.append("        AND (   BR.PPD_RCV_OFC_CD = 'HKGSC'" ).append("\n"); 
		query.append("             OR BR.CLT_OFC_CD = 'HKGSC'" ).append("\n"); 
		query.append("             OR PPD.CNT_CD <> 'CN'" ).append("\n"); 
		query.append("             OR CCT.CNT_CD <> 'CN'" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        SELECT  BK.BKG_NO," ).append("\n"); 
		query.append("                BR.RT_APLY_DT," ).append("\n"); 
		query.append("                BK.SVC_SCP_CD," ).append("\n"); 
		query.append("                BK.RCV_TERM_CD," ).append("\n"); 
		query.append("                BK.DE_TERM_CD," ).append("\n"); 
		query.append("                BK.POR_CD," ).append("\n"); 
		query.append("                BK.POL_CD," ).append("\n"); 
		query.append("                BK.POD_CD," ).append("\n"); 
		query.append("                BK.DEL_CD," ).append("\n"); 
		query.append("                CASE WHEN POR.CNT_CD = 'CN' OR POL.CNT_CD = 'CN' THEN 'P'" ).append("\n"); 
		query.append("                     WHEN POD.CNT_CD = 'CN' OR DEL.CNT_CD = 'CN' THEN 'C'" ).append("\n"); 
		query.append("                     ELSE NULL" ).append("\n"); 
		query.append("                END FRT_TERM_CD," ).append("\n"); 
		query.append("                CASE WHEN PPD.CNT_CD <> 'CN' OR BR.PPD_RCV_OFC_CD = 'HKGSC' THEN BR.PPD_RCV_OFC_CD" ).append("\n"); 
		query.append("                     ELSE NULL" ).append("\n"); 
		query.append("                END PPD_RCV_OFC_CD," ).append("\n"); 
		query.append("                CASE WHEN CCT.CNT_CD <> 'CN' OR BR.CLT_OFC_CD = 'HKGSC' THEN BR.CLT_OFC_CD" ).append("\n"); 
		query.append("                END CLT_OFC_CD," ).append("\n"); 
		query.append("                POR.CNT_CD||POR.STE_CD POR_STE_CD," ).append("\n"); 
		query.append("                POR.RGN_CD POR_RGN_CD," ).append("\n"); 
		query.append("                POR.CNT_CD POR_CNT_CD," ).append("\n"); 
		query.append("                POL.CNT_CD||POL.STE_CD POL_STE_CD," ).append("\n"); 
		query.append("                POL.RGN_CD POL_RGN_CD," ).append("\n"); 
		query.append("                POL.CNT_CD POL_CNT_CD," ).append("\n"); 
		query.append("                POD.CNT_CD||POD.STE_CD POD_STE_CD," ).append("\n"); 
		query.append("                POD.RGN_CD POD_RGN_CD," ).append("\n"); 
		query.append("                POD.CNT_CD POD_CNT_CD," ).append("\n"); 
		query.append("                DEL.CNT_CD||DEL.STE_CD DEL_STE_CD," ).append("\n"); 
		query.append("                DEL.RGN_CD DEL_RGN_CD," ).append("\n"); 
		query.append("                DEL.CNT_CD DEL_CNT_CD," ).append("\n"); 
		query.append("               (SELECT FRT_TERM_CD" ).append("\n"); 
		query.append("                FROM BKG_CHG_RT_HIS " ).append("\n"); 
		query.append("                WHERE BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("                AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("                AND @[ca_flag] = 'Y'" ).append("\n"); 
		query.append("                AND CHG_CD = 'OFT'" ).append("\n"); 
		query.append("                AND ROWNUM = 1) OFT_TERM_CD," ).append("\n"); 
		query.append("               (SELECT SUM(CHG_AMT)" ).append("\n"); 
		query.append("                FROM BKG_CHG_RT_HIS " ).append("\n"); 
		query.append("                WHERE BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("                AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("                AND @[ca_flag] = 'Y'" ).append("\n"); 
		query.append("                AND FRT_INCL_XCLD_DIV_CD = 'N'" ).append("\n"); 
		query.append("                AND FRT_TERM_CD = 'P') PPD_AMT," ).append("\n"); 
		query.append("               (SELECT SUM(CHG_AMT)" ).append("\n"); 
		query.append("                FROM BKG_CHG_RT_HIS " ).append("\n"); 
		query.append("                WHERE BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("                AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("                AND @[ca_flag] = 'Y'" ).append("\n"); 
		query.append("                AND FRT_INCL_XCLD_DIV_CD = 'N'" ).append("\n"); 
		query.append("                AND FRT_TERM_CD = 'C') CLT_AMT" ).append("\n"); 
		query.append("        FROM BKG_BKG_HIS BK," ).append("\n"); 
		query.append("             BKG_RT_HIS  BR," ).append("\n"); 
		query.append("             MDM_ORGANIZATION PO," ).append("\n"); 
		query.append("             MDM_ORGANIZATION CO," ).append("\n"); 
		query.append("             MDM_LOCATION POR," ).append("\n"); 
		query.append("             MDM_LOCATION POL," ).append("\n"); 
		query.append("             MDM_LOCATION POD," ).append("\n"); 
		query.append("             MDM_LOCATION DEL," ).append("\n"); 
		query.append("             MDM_LOCATION PPD," ).append("\n"); 
		query.append("             MDM_LOCATION CCT" ).append("\n"); 
		query.append("        WHERE BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("        AND @[ca_flag]     = 'Y'" ).append("\n"); 
		query.append("        AND BK.BKG_NO   = BR.BKG_NO" ).append("\n"); 
		query.append("        AND BK.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("        AND BK.CORR_NO  = BR.CORR_NO" ).append("\n"); 
		query.append("        AND POR.LOC_CD  = BK.POR_CD " ).append("\n"); 
		query.append("        AND POL.LOC_CD  = BK.POL_CD " ).append("\n"); 
		query.append("        AND POD.LOC_CD  = BK.POD_CD " ).append("\n"); 
		query.append("        AND DEL.LOC_CD  = BK.DEL_CD" ).append("\n"); 
		query.append("        AND PO.OFC_CD   = BR.PPD_RCV_OFC_CD" ).append("\n"); 
		query.append("        AND PPD.LOC_CD  = PO.LOC_CD " ).append("\n"); 
		query.append("        AND CO.OFC_CD   = BR.CLT_OFC_CD" ).append("\n"); 
		query.append("        AND CCT.LOC_CD  = CO.LOC_CD " ).append("\n"); 
		query.append("        AND (   BR.PPD_RCV_OFC_CD = 'HKGSC'" ).append("\n"); 
		query.append("             OR BR.CLT_OFC_CD = 'HKGSC'" ).append("\n"); 
		query.append("             OR PPD.CNT_CD <> 'CN'" ).append("\n"); 
		query.append("             OR CCT.CNT_CD <> 'CN'" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("        ) BK" ).append("\n"); 
		query.append("WHERE SP.SVC_SCP_CD = BK.SVC_SCP_CD" ).append("\n"); 
		query.append("AND SP.CHG_CD     =  'TPF'" ).append("\n"); 
		query.append("AND SR.SVC_SCP_CD = SP.SVC_SCP_CD" ).append("\n"); 
		query.append("AND SR.CHG_CD     = SP.CHG_CD" ).append("\n"); 
		query.append("AND SR.WDR_FLG    =  'N'" ).append("\n"); 
		query.append("AND SR.DELT_FLG   =  'N'   -- Sucharge 적용 중지 여부 " ).append("\n"); 
		query.append("AND SR.SCG_RQST_PROC_CD = 'A'" ).append("\n"); 
		query.append("AND MC.CHG_CD     = SP.CHG_CD" ).append("\n"); 
		query.append("AND BK.RT_APLY_DT BETWEEN SR.EFF_DT AND SR.EXP_DT + 0.99999   -- 0.99999 는 23시 59분 59초를 의미 " ).append("\n"); 
		query.append("AND BK.BKG_NO     = RT.BKG_NO(+)" ).append("\n"); 
		query.append("AND BK.FRT_TERM_CD = RT.FRT_TERM_CD(+)" ).append("\n"); 
		query.append("/*******************************************************************************************" ).append("\n"); 
		query.append("R/D TERM CHECK ( MDM_CHARGE 의 R/D TERM CHECK 포함 )" ).append("\n"); 
		query.append("*******************************************************************************************/" ).append("\n"); 
		query.append("AND (" ).append("\n"); 
		query.append("        SR.PRC_RCV_TERM_CD  = BK.RCV_TERM_CD" ).append("\n"); 
		query.append("    OR  (" ).append("\n"); 
		query.append("            ( SP.RCV_DE_TERM_USE_FLG = 'N' OR SR.PRC_RCV_TERM_CD IS NULL )" ).append("\n"); 
		query.append("        AND (" ).append("\n"); 
		query.append("                MC.CHG_APLY_AREA_CD = 'C'" ).append("\n"); 
		query.append("                OR  BK.RCV_TERM_CD  IN ( DECODE(MC.NA_RD_TERM_FLG, 'Y', BK.RCV_TERM_CD), DECODE(MC.CY_RD_TERM_FLG, 'Y', 'Y'), DECODE(MC.DOR_RD_TERM_FLG, 'Y', 'D'), DECODE(MC.CFS_RD_TERM_FLG, 'Y', 'S'), DECODE(MC.TKL_TML_FLG, 'Y', 'T') )" ).append("\n"); 
		query.append("             )" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("AND (" ).append("\n"); 
		query.append("        SR.PRC_DE_TERM_CD   = BK.DE_TERM_CD" ).append("\n"); 
		query.append("    OR  (" ).append("\n"); 
		query.append("            (   SP.RCV_DE_TERM_USE_FLG = 'N' OR SR.PRC_DE_TERM_CD IS NULL )" ).append("\n"); 
		query.append("        AND (   " ).append("\n"); 
		query.append("                MC.CHG_APLY_AREA_CD = 'P'" ).append("\n"); 
		query.append("            OR  BK.DE_TERM_CD   IN ( DECODE(MC.NA_RD_TERM_FLG, 'Y', BK.DE_TERM_CD), DECODE(MC.CY_RD_TERM_FLG, 'Y', 'Y'), DECODE(MC.DOR_RD_TERM_FLG, 'Y', 'D'), DECODE(MC.CFS_RD_TERM_FLG, 'Y', 'S'), DECODE(MC.TKL_TML_FLG, 'Y', 'T') )" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* POR */ " ).append("\n"); 
		query.append("AND ( " ).append("\n"); 
		query.append("        SP.POR_USE_FLG  = 'N' " ).append("\n"); 
		query.append("    OR  SR.POR_DEF_CD   IS NULL " ).append("\n"); 
		query.append("    OR  (" ).append("\n"); 
		query.append("            SR.POR_DEF_CD   = DECODE(SR.POR_TP_CD, 'L', BK.POR_CD, 'T', BK.POR_STE_CD, 'R', BK.POR_RGN_CD, 'C', BK.POR_CNT_CD)" ).append("\n"); 
		query.append("        AND BK.POR_CD <> 'CNHKG' " ).append("\n"); 
		query.append("        AND  NVL(BK.PPD_AMT, 0) > 0" ).append("\n"); 
		query.append("        AND (   ( N3PTY_RCV_OFC_CD IS NOT NULL AND RT.FRT_TERM_CD = 'P' )" ).append("\n"); 
		query.append("            OR  ( PPD_RCV_OFC_CD IS NOT NULL AND RT.FRT_TERM_CD IS NULL ))" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("    OR  ( " ).append("\n"); 
		query.append("            SR.POR_TP_CD  = 'G' " ).append("\n"); 
		query.append("        AND EXISTS  ( " ).append("\n"); 
		query.append("                    SELECT  'X' " ).append("\n"); 
		query.append("                    FROM    PRI_SCG_GRP_LOC     GL  , " ).append("\n"); 
		query.append("                            PRI_SCG_GRP_LOC_DTL GD " ).append("\n"); 
		query.append("                    WHERE   GD.SVC_SCP_CD     = GL.SVC_SCP_CD " ).append("\n"); 
		query.append("                    AND     GD.CHG_CD         = GL.CHG_CD " ).append("\n"); 
		query.append("                    AND     GD.GRP_LOC_SEQ    = GL.GRP_LOC_SEQ " ).append("\n"); 
		query.append("                    AND     GL.SVC_SCP_CD     = SR.SVC_SCP_CD " ).append("\n"); 
		query.append("                    AND     GL.CHG_CD         = SR.CHG_CD " ).append("\n"); 
		query.append("                    AND     GL.SCG_GRP_LOC_CD = SR.POR_DEF_CD " ).append("\n"); 
		query.append("                    AND     GD.DTL_LOC_DEF_CD = DECODE(GD.DTL_LOC_TP_CD, 'L', BK.POR_CD, 'T', BK.POR_STE_CD, 'R', BK.POR_RGN_CD, 'C', BK.POR_CNT_CD)    " ).append("\n"); 
		query.append("                    AND     BK.RT_APLY_DT     BETWEEN GD.EFF_DT AND GD.EXP_DT + 0.99999   /* 0.99999 는 23시 59분 59초를 의미 */ " ).append("\n"); 
		query.append("                    AND     BK.POR_CD <> 'CNHKG' " ).append("\n"); 
		query.append("                    AND     NVL(BK.PPD_AMT, 0) > 0" ).append("\n"); 
		query.append("                    AND     (   ( N3PTY_RCV_OFC_CD IS NOT NULL AND RT.FRT_TERM_CD = 'P' )" ).append("\n"); 
		query.append("                            OR  ( PPD_RCV_OFC_CD IS NOT NULL AND RT.FRT_TERM_CD IS NULL ))" ).append("\n"); 
		query.append("                    ) " ).append("\n"); 
		query.append("        ) " ).append("\n"); 
		query.append("    ) " ).append("\n"); 
		query.append("/* POL */ " ).append("\n"); 
		query.append("AND ( " ).append("\n"); 
		query.append("        SP.POL_USE_FLG  = 'N' " ).append("\n"); 
		query.append("    OR  SR.POL_DEF_CD   IS NULL " ).append("\n"); 
		query.append("    OR  (" ).append("\n"); 
		query.append("            SR.POL_DEF_CD   = DECODE(SR.POL_TP_CD, 'L', BK.POL_CD, 'T', BK.POL_STE_CD, 'R', BK.POL_RGN_CD, 'C', BK.POL_CNT_CD) " ).append("\n"); 
		query.append("        AND BK.POL_CD <> 'CNHKG' " ).append("\n"); 
		query.append("        AND  NVL(BK.PPD_AMT, 0) > 0" ).append("\n"); 
		query.append("        AND (   ( N3PTY_RCV_OFC_CD IS NOT NULL AND RT.FRT_TERM_CD = 'P' )" ).append("\n"); 
		query.append("            OR  ( PPD_RCV_OFC_CD IS NOT NULL AND RT.FRT_TERM_CD IS NULL ))" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("    OR  ( " ).append("\n"); 
		query.append("            SR.POL_TP_CD  = 'G' " ).append("\n"); 
		query.append("        AND EXISTS  ( " ).append("\n"); 
		query.append("                    SELECT  'X' " ).append("\n"); 
		query.append("                    FROM    PRI_SCG_GRP_LOC     GL  , " ).append("\n"); 
		query.append("                            PRI_SCG_GRP_LOC_DTL GD " ).append("\n"); 
		query.append("                    WHERE   GD.SVC_SCP_CD     = GL.SVC_SCP_CD " ).append("\n"); 
		query.append("                    AND     GD.CHG_CD         = GL.CHG_CD " ).append("\n"); 
		query.append("                    AND     GD.GRP_LOC_SEQ    = GL.GRP_LOC_SEQ " ).append("\n"); 
		query.append("                    AND     GL.SVC_SCP_CD     = SR.SVC_SCP_CD " ).append("\n"); 
		query.append("                    AND     GL.CHG_CD         = SR.CHG_CD " ).append("\n"); 
		query.append("                    AND     GL.SCG_GRP_LOC_CD = SR.POL_DEF_CD " ).append("\n"); 
		query.append("                    AND     GD.DTL_LOC_DEF_CD = DECODE(GD.DTL_LOC_TP_CD, 'L', BK.POL_CD, 'T', BK.POL_STE_CD, 'R', BK.POL_RGN_CD, 'C', BK.POL_CNT_CD) " ).append("\n"); 
		query.append("                    AND     BK.RT_APLY_DT      BETWEEN GD.EFF_DT AND GD.EXP_DT + 0.99999   /* 0.99999 는 23시 59분 59초를 의미 */ " ).append("\n"); 
		query.append("                    AND     BK.POL_CD <> 'CNHKG' " ).append("\n"); 
		query.append("                    AND      NVL(BK.PPD_AMT, 0) > 0" ).append("\n"); 
		query.append("                    AND     (   ( N3PTY_RCV_OFC_CD IS NOT NULL AND RT.FRT_TERM_CD = 'P' )" ).append("\n"); 
		query.append("                            OR  ( PPD_RCV_OFC_CD IS NOT NULL AND RT.FRT_TERM_CD IS NULL ))" ).append("\n"); 
		query.append("                    ) " ).append("\n"); 
		query.append("        ) " ).append("\n"); 
		query.append("    ) " ).append("\n"); 
		query.append("/* POD */ " ).append("\n"); 
		query.append("AND ( " ).append("\n"); 
		query.append("        SP.POD_USE_FLG  = 'N' " ).append("\n"); 
		query.append("    OR  SR.POD_DEF_CD   IS NULL " ).append("\n"); 
		query.append("    OR  (" ).append("\n"); 
		query.append("            SR.POD_DEF_CD   = DECODE(SR.POD_TP_CD, 'L', BK.POD_CD, 'T', BK.POD_STE_CD, 'R', BK.POD_RGN_CD, 'C', BK.POD_CNT_CD)" ).append("\n"); 
		query.append("        AND BK.POD_CD <> 'CNHKG' " ).append("\n"); 
		query.append("        AND NVL(BK.CLT_AMT, 0) > 0" ).append("\n"); 
		query.append("        AND (   ( N3PTY_RCV_OFC_CD IS NOT NULL AND RT.FRT_TERM_CD = 'C' )" ).append("\n"); 
		query.append("            OR  ( CLT_OFC_CD IS NOT NULL AND RT.FRT_TERM_CD IS NULL ))" ).append("\n"); 
		query.append("        ) " ).append("\n"); 
		query.append("    OR  ( " ).append("\n"); 
		query.append("            SR.POD_TP_CD  = 'G' " ).append("\n"); 
		query.append("        AND EXISTS  ( " ).append("\n"); 
		query.append("                    SELECT  'X' " ).append("\n"); 
		query.append("                    FROM    PRI_SCG_GRP_LOC     GL  , " ).append("\n"); 
		query.append("                            PRI_SCG_GRP_LOC_DTL GD " ).append("\n"); 
		query.append("                    WHERE   GD.SVC_SCP_CD     = GL.SVC_SCP_CD " ).append("\n"); 
		query.append("                    AND     GD.CHG_CD         = GL.CHG_CD " ).append("\n"); 
		query.append("                    AND     GD.GRP_LOC_SEQ    = GL.GRP_LOC_SEQ " ).append("\n"); 
		query.append("                    AND     GL.SVC_SCP_CD     = SR.SVC_SCP_CD " ).append("\n"); 
		query.append("                    AND     GL.CHG_CD         = SR.CHG_CD " ).append("\n"); 
		query.append("                    AND     GL.SCG_GRP_LOC_CD = SR.POD_DEF_CD " ).append("\n"); 
		query.append("                    AND     GD.DTL_LOC_DEF_CD = DECODE(GD.DTL_LOC_TP_CD, 'L', BK.POD_CD, 'T', BK.POD_STE_CD, 'R', BK.POD_RGN_CD, 'C', BK.POD_CNT_CD) " ).append("\n"); 
		query.append("                    AND     BK.RT_APLY_DT     BETWEEN GD.EFF_DT AND GD.EXP_DT  + 0.99999   /* 0.99999 는 23시 59분 59초를 의미 */  " ).append("\n"); 
		query.append("                    AND     BK.POD_CD <> 'CNHKG' " ).append("\n"); 
		query.append("                    AND     NVL(BK.CLT_AMT, 0) > 0" ).append("\n"); 
		query.append("                    AND     (   ( N3PTY_RCV_OFC_CD IS NOT NULL AND RT.FRT_TERM_CD = 'C' )" ).append("\n"); 
		query.append("                            OR  ( CLT_OFC_CD IS NOT NULL AND RT.FRT_TERM_CD IS NULL ))" ).append("\n"); 
		query.append("                    ) " ).append("\n"); 
		query.append("        ) " ).append("\n"); 
		query.append("    ) " ).append("\n"); 
		query.append("/* DEL */ " ).append("\n"); 
		query.append("AND ( " ).append("\n"); 
		query.append("        SP.DEL_USE_FLG  = 'N' " ).append("\n"); 
		query.append("    OR  SR.DEL_DEF_CD   IS NULL " ).append("\n"); 
		query.append("    OR  (" ).append("\n"); 
		query.append("            SR.DEL_DEF_CD   = DECODE(SR.DEL_TP_CD, 'L', BK.DEL_CD, 'T', BK.DEL_STE_CD, 'R', BK.DEL_RGN_CD, 'C', BK.DEL_CNT_CD)" ).append("\n"); 
		query.append("        AND BK.DEL_CD <> 'CNHKG' " ).append("\n"); 
		query.append("        AND NVL(BK.CLT_AMT, 0) > 0" ).append("\n"); 
		query.append("        AND (   ( N3PTY_RCV_OFC_CD IS NOT NULL AND RT.FRT_TERM_CD = 'C' )" ).append("\n"); 
		query.append("            OR  ( CLT_OFC_CD IS NOT NULL AND RT.FRT_TERM_CD IS NULL ))" ).append("\n"); 
		query.append("        ) " ).append("\n"); 
		query.append("    OR  ( " ).append("\n"); 
		query.append("            SR.DEL_TP_CD  = 'G' " ).append("\n"); 
		query.append("        AND EXISTS  ( " ).append("\n"); 
		query.append("                    SELECT  'X' " ).append("\n"); 
		query.append("                    FROM    PRI_SCG_GRP_LOC     GL  , " ).append("\n"); 
		query.append("                            PRI_SCG_GRP_LOC_DTL GD " ).append("\n"); 
		query.append("                    WHERE   GD.SVC_SCP_CD     = GL.SVC_SCP_CD " ).append("\n"); 
		query.append("                    AND     GD.CHG_CD         = GL.CHG_CD " ).append("\n"); 
		query.append("                    AND     GD.GRP_LOC_SEQ    = GL.GRP_LOC_SEQ " ).append("\n"); 
		query.append("                    AND     GL.SVC_SCP_CD     = SR.SVC_SCP_CD " ).append("\n"); 
		query.append("                    AND     GL.CHG_CD         = SR.CHG_CD " ).append("\n"); 
		query.append("                    AND     GL.SCG_GRP_LOC_CD = SR.DEL_DEF_CD " ).append("\n"); 
		query.append("                    AND     GD.DTL_LOC_DEF_CD = DECODE(GD.DTL_LOC_TP_CD, 'L', BK.DEL_CD, 'T', BK.DEL_STE_CD, 'R', BK.DEL_RGN_CD, 'C', BK.DEL_CNT_CD) " ).append("\n"); 
		query.append("                    AND     BK.RT_APLY_DT      BETWEEN GD.EFF_DT AND GD.EXP_DT  + 0.99999   /* 0.99999 는 23시 59분 59초를 의미 */   " ).append("\n"); 
		query.append("                    AND     BK.DEL_CD <> 'CNHKG' " ).append("\n"); 
		query.append("                    AND     NVL(BK.CLT_AMT, 0) > 0" ).append("\n"); 
		query.append("                    AND     (   ( N3PTY_RCV_OFC_CD IS NOT NULL AND RT.FRT_TERM_CD = 'C' )" ).append("\n"); 
		query.append("                            OR  ( CLT_OFC_CD IS NOT NULL AND RT.FRT_TERM_CD IS NULL ))                        " ).append("\n"); 
		query.append("                    ) " ).append("\n"); 
		query.append("        ) " ).append("\n"); 
		query.append("    ) " ).append("\n"); 
		query.append("/* TPF Rating 여부 확인. 없는 경우에만 Charge 정보 조회 */" ).append("\n"); 
		query.append("AND (SELECT COUNT(CHG_CD)" ).append("\n"); 
		query.append("     FROM   (SELECT CHG_CD " ).append("\n"); 
		query.append("             FROM BKG_CHG_RT" ).append("\n"); 
		query.append("             WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("             AND CHG_CD = 'TPF'" ).append("\n"); 
		query.append("             AND @[ca_flag] = 'N'" ).append("\n"); 
		query.append("             UNION ALL" ).append("\n"); 
		query.append("             SELECT CHG_CD" ).append("\n"); 
		query.append("             FROM BKG_CHG_RT_HIS" ).append("\n"); 
		query.append("             WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("             AND CHG_CD = 'TPF'" ).append("\n"); 
		query.append("             AND @[ca_flag] = 'Y'" ).append("\n"); 
		query.append("             AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("             )) = 0" ).append("\n"); 

	}
}