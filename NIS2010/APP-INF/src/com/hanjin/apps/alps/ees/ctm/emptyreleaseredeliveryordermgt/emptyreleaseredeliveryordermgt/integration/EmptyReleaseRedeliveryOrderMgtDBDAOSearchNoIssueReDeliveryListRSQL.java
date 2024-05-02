/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EmptyReleaseRedeliveryOrderMgtDBDAOSearchNoIssueReDeliveryListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.04
*@LastModifier : 강환
*@LastVersion : 1.0
* 2014.03.04 강환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Hwan, Kang
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EmptyReleaseRedeliveryOrderMgtDBDAOSearchNoIssueReDeliveryListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2010.08.27 김상수
	  *     [CHM-201005606-01] CTM의 Release/Redelivery Order 화면 변경
	  *         : [EES_CTM_0426] ReDerivery 조회시 sheet내에 lstm_cd 컬럼추가  by 김상수
	  * 
	  * </pre>
	  */
	public EmptyReleaseRedeliveryOrderMgtDBDAOSearchNoIssueReDeliveryListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_yard1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("office",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_yard2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("territory",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lcc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("wo_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_date2",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("p_date1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.integration").append("\n"); 
		query.append("FileName : EmptyReleaseRedeliveryOrderMgtDBDAOSearchNoIssueReDeliveryListRSQL").append("\n"); 
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
		query.append("/** REDELIVERY-01 **/" ).append("\n"); 
		query.append("     SELECT /*+ ORDERED */" ).append("\n"); 
		query.append("            CMO.CRE_OFC_CD AS I_OFFICE," ).append("\n"); 
		query.append("            CMO.TRSP_BND_CD AS BD," ).append("\n"); 
		query.append("            DECODE (CMO.TRSP_BND_CD, 'I', 'IN', 'O', 'OUT', CMO.TRSP_BND_CD) AS BD_DISP," ).append("\n"); 
		query.append("            CMO.TRSP_CRR_MOD_CD AS MODE_CD," ).append("\n"); 
		query.append("            'C' AS TYPE_CD," ).append("\n"); 
		query.append("            'C/H' AS TYPE_DISP," ).append("\n"); 
		query.append("            TRO.TRO_SEQ AS TRO_SEQ," ).append("\n"); 
		query.append("            NVL (BB.PRE_RLY_PORT_CD, BB.POL_CD) AS POL," ).append("\n"); 
		query.append("            NVL (BB.PST_RLY_PORT_CD, BB.POD_CD) AS POD," ).append("\n"); 
		query.append("            CMO.TO_NOD_CD AS EMPTY_CY," ).append("\n"); 
		query.append("            CMO.TO_NOD_CD AS ORG_EMPTY_CY," ).append("\n"); 
		query.append("            MV.VNDR_SEQ AS S_P," ).append("\n"); 
		query.append("            MV.VNDR_LGL_ENG_NM AS VNDR_LGL_ENG_NM," ).append("\n"); 
		query.append("            TO_CHAR (CMO.LST_NOD_PLN_DT, 'YYYY-MM-DD') AS PD_DATE_DISP," ).append("\n"); 
		query.append("            TO_CHAR (CMO.LST_NOD_PLN_DT, 'YYYY-MM-DD') AS PD_DATE," ).append("\n"); 
		query.append("            CMO.EQ_NO AS CNTR_NO," ).append("\n"); 
		query.append("            CMO.EQ_TPSZ_CD AS TP," ).append("\n"); 
		query.append("            MST.LSTM_CD," ).append("\n"); 
		query.append("            '' AS CB," ).append("\n"); 
		query.append("            '' AS EMPTY_DEST," ).append("\n"); 
		query.append("            CMO.FAX_NO AS FAX_NO," ).append("\n"); 
		query.append("            CMO.YD_EML AS EMAIL," ).append("\n"); 
		query.append("            '' AS OFFICE," ).append("\n"); 
		query.append("            '' AS USER_ID," ).append("\n"); 
		query.append("            '' AS ISSUE_DT," ).append("\n"); 
		query.append("            '' AS FAX_EMAIL_RST,    /** Fax/E-mail Result **/" ).append("\n"); 
		query.append("            CMO.BKG_NO AS BKG_NO," ).append("\n"); 
		query.append("            CMO.BL_NO AS BL_NO," ).append("\n"); 
		query.append("            BB.VSL_CD||BB.SKD_VOY_NO||BB.SKD_DIR_CD AS VVD," ).append("\n"); 
		query.append("            CMO.TRSP_WO_OFC_CTY_CD||CMO.TRSP_WO_SEQ AS WO_NO," ).append("\n"); 
		query.append("            NVL (REPLACE (REPLACE (REPLACE (REPLACE (REPLACE (RTRIM (TRO.SPCL_INSTR_RMK), CHR(92)||'r'||CHR(92)||'n', ' '), CHR(13)||CHR(10), ' '), CHR(34), ' '), CHR(9), ' '),  CHR(13),  ' '),  '') AS SPCL_INST," ).append("\n"); 
		query.append("            REPLACE (REPLACE (REPLACE (REPLACE (REPLACE (SUBSTR (S.CUST_NM, 1, 50), CHR(92)||'r'||CHR(92)||'n', ' '), CHR(13)||CHR(10), ' '), CHR(34), ' '), CHR(9), ' '),  CHR(13),  ' ') AS SHPR," ).append("\n"); 
		query.append("            REPLACE (REPLACE (REPLACE (REPLACE (REPLACE (SUBSTR (C.CUST_NM, 1, 50), CHR(92)||'r'||CHR(92)||'n', ' '), CHR(13)||CHR(10), ' '), CHR(34), ' '), CHR(9), ' '),  CHR(13),  ' ') AS CNEE," ).append("\n"); 
		query.append("            REPLACE (REPLACE (REPLACE (REPLACE (REPLACE (SUBSTR (N.CUST_NM, 1, 50), CHR(92)||'r'||CHR(92)||'n', ' '), CHR(13)||CHR(10), ' '), CHR(34), ' '), CHR(9), ' '),  CHR(13),  ' ') AS NTFY," ).append("\n"); 
		query.append("            CMO.TRSP_SO_OFC_CTY_CD AS SO_OFC_CTY_CD," ).append("\n"); 
		query.append("            CMO.TRSP_SO_SEQ AS SO_SEQ," ).append("\n"); 
		query.append("			(	SELECT NVL(T1.ACT_CRR_CD, T3.CRR_CD) AS CARRIER_CD FROM VSK_VSL_SKD T1, MDM_VSL_CNTR T3" ).append("\n"); 
		query.append("				WHERE T1.VSL_CD       = T3.VSL_CD" ).append("\n"); 
		query.append("				AND T1.VSL_CD = BB.VSL_CD" ).append("\n"); 
		query.append("				AND T1.SKD_VOY_NO = BB.SKD_VOY_NO" ).append("\n"); 
		query.append("				AND T1.SKD_DIR_CD = BB.SKD_DIR_CD" ).append("\n"); 
		query.append("			)	SHIP_OPR" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       FROM (SELECT" ).append("\n"); 
		query.append("               #if (${bkg_no} != '')" ).append("\n"); 
		query.append("                    /*+ INDEX(ORD XAK9TRS_TRSP_SVC_ORD) */" ).append("\n"); 
		query.append("               #elseif (${bl_no} != '')" ).append("\n"); 
		query.append("                    /*+ INDEX(ORD XAK8TRS_TRSP_SVC_ORD) */" ).append("\n"); 
		query.append("               #else" ).append("\n"); 
		query.append("                    /*+ ORDERED USE_NL (CT MY ORD) */" ).append("\n"); 
		query.append("               #end" ).append("\n"); 
		query.append("                    ORD.CRE_OFC_CD," ).append("\n"); 
		query.append("                    ORD.TRSP_BND_CD," ).append("\n"); 
		query.append("                    ORD.TRSP_CRR_MOD_CD," ).append("\n"); 
		query.append("                    ORD.TO_NOD_CD," ).append("\n"); 
		query.append("                    ORD.LST_NOD_PLN_DT," ).append("\n"); 
		query.append("                    ORD.EQ_NO," ).append("\n"); 
		query.append("                    ORD.EQ_TPSZ_CD," ).append("\n"); 
		query.append("                    MY.FAX_NO," ).append("\n"); 
		query.append("                    MY.YD_EML," ).append("\n"); 
		query.append("                    ORD.BKG_NO," ).append("\n"); 
		query.append("                    ORD.BL_NO," ).append("\n"); 
		query.append("                    ORD.TRSP_WO_OFC_CTY_CD," ).append("\n"); 
		query.append("                    ORD.TRSP_WO_SEQ," ).append("\n"); 
		query.append("                    ORD.VNDR_SEQ," ).append("\n"); 
		query.append("                    ORD.TRO_SEQ," ).append("\n"); 
		query.append("                    ORD.TRSP_SO_OFC_CTY_CD," ).append("\n"); 
		query.append("                    ORD.TRSP_SO_SEQ," ).append("\n"); 
		query.append("                    MY.LOC_CD" ).append("\n"); 
		query.append("               FROM CIM_TERRITORY CT," ).append("\n"); 
		query.append("                    MDM_YARD MY," ).append("\n"); 
		query.append("                    TRS_TRSP_SVC_ORD ORD" ).append("\n"); 
		query.append("              WHERE MY.YD_CD LIKE CT.CNT_CD||'%'" ).append("\n"); 
		query.append("                AND NOT EXISTS (SELECT 'A'" ).append("\n"); 
		query.append("                                  FROM CIM_CNTR_STK STK" ).append("\n"); 
		query.append("                                 WHERE STK.STK_LOC_CD = SUBSTR (ORD.TO_NOD_CD, 1, 5)" ).append("\n"); 
		query.append("                                   AND STK.STK_YD_CD = ORD.TO_NOD_CD" ).append("\n"); 
		query.append("                                   AND NVL (STK.IO_BND_CD, 'X') = NVL (ORD.TRSP_BND_CD, 'X')" ).append("\n"); 
		query.append("                                   AND STK.SO_OFC_CTY_CD = ORD.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("                                   AND STK.SO_SEQ = ORD.TRSP_SO_SEQ" ).append("\n"); 
		query.append("                                   AND STK.TRSP_SO_TP_CD = DECODE (ORD.TRSP_COST_DTL_MOD_CD, 'DR', 'C', 'CN', 'S', 'CF', 'S', 'ER', 'R', ORD.TRSP_COST_DTL_MOD_CD))" ).append("\n"); 
		query.append("           #if ((${bkg_no} == '' && ${bl_no} == '' && ${cntr_no} == '' && ${wo_no} == '') && (${p_date1} != '' && ${p_date2} != ''))" ).append("\n"); 
		query.append("                AND ORD.N1ST_NOD_PLN_DT BETWEEN TO_DATE (@[p_date1], 'YYYY-MM-DD') AND TO_DATE (@[p_date2], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (${bkg_no} != '')" ).append("\n"); 
		query.append("                AND ORD.BKG_NO LIKE @[bkg_no]||'%'" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (${bl_no} != '')" ).append("\n"); 
		query.append("                AND ORD.BL_NO LIKE @[bl_no]||'%'" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (${cntr_no} != '')" ).append("\n"); 
		query.append("                AND ORD.EQ_NO LIKE @[cntr_no]||'%'" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (${cntr_tpsz_cd} != '')" ).append("\n"); 
		query.append("                AND ORD.EQ_TPSZ_CD IN (${cntr_tpsz_cd})" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("                AND ORD.TO_NOD_CD = MY.YD_CD" ).append("\n"); 
		query.append("           #if (${p_yard2} != '')" ).append("\n"); 
		query.append("                AND ORD.TO_NOD_CD = @[p_yard1]||@[p_yard2]" ).append("\n"); 
		query.append("           #elseif (${p_yard1} != '')" ).append("\n"); 
		query.append("                AND ORD.TO_NOD_CD LIKE @[p_yard1]||'%'" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("                AND ORD.TRSP_WO_OFC_CTY_CD IS NOT NULL" ).append("\n"); 
		query.append("           #if (${wo_no} != '')" ).append("\n"); 
		query.append("                AND ORD.TRSP_WO_OFC_CTY_CD = SUBSTR(@[wo_no], 1, 3)" ).append("\n"); 
		query.append("                AND ORD.TRSP_WO_SEQ = SUBSTR(@[wo_no], 4)" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("                AND ORD.TRSP_BND_CD = 'I'" ).append("\n"); 
		query.append("                AND ORD.INV_NO IS NULL" ).append("\n"); 
		query.append("                AND ORD.TRSP_SO_TP_CD = 'Y'" ).append("\n"); 
		query.append("                AND ORD.TRSP_COST_DTL_MOD_CD = 'DR'    /** Carriou **/" ).append("\n"); 
		query.append("                AND NVL(ORD.TRSP_SO_CMB_TP_CD,'N') NOT IN ('FF','FM')" ).append("\n"); 
		query.append("                AND ORD.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                AND CT.CNTR_STK_TERR_CD = @[territory]" ).append("\n"); 
		query.append("                AND CT.OFC_CD = @[office]) CMO," ).append("\n"); 
		query.append("            BKG_EUR_TRO TRO," ).append("\n"); 
		query.append("            BKG_BOOKING BB," ).append("\n"); 
		query.append("            MDM_ORGANIZATION MO," ).append("\n"); 
		query.append("            MDM_LOCATION ML," ).append("\n"); 
		query.append("     #if (${lcc_cd} != '')" ).append("\n"); 
		query.append("            MDM_EQ_ORZ_CHT MC," ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("            MDM_VENDOR MV," ).append("\n"); 
		query.append("            BKG_CUSTOMER S," ).append("\n"); 
		query.append("            BKG_CUSTOMER C," ).append("\n"); 
		query.append("            BKG_CUSTOMER N," ).append("\n"); 
		query.append("            MST_CONTAINER MST" ).append("\n"); 
		query.append("      WHERE 1 = 1" ).append("\n"); 
		query.append("        /* AND SUBSTR(CMO.BKG_TRO_NO, 1, 1) = TRO.IO_BND_CD(+) */" ).append("\n"); 
		query.append("        AND CMO.TRO_SEQ = TRO.TRO_SEQ(+)" ).append("\n"); 
		query.append("        AND NVL (CMO.BKG_NO, 1) = BB.BKG_NO" ).append("\n"); 
		query.append("        AND CMO.BKG_NO = TRO.BKG_NO(+)" ).append("\n"); 
		query.append("     #if (${lcc_cd} != '')" ).append("\n"); 
		query.append("        AND MC.LCC_CD LIKE @[lcc_cd]||'%'" ).append("\n"); 
		query.append("        AND MC.SCC_CD = ML.SCC_CD" ).append("\n"); 
		query.append("        AND ML.LOC_CD = CMO.LOC_CD" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("        AND CMO.TRSP_BND_CD = TRO.IO_BND_CD(+)" ).append("\n"); 
		query.append("        AND MV.VNDR_SEQ = CMO.VNDR_SEQ" ).append("\n"); 
		query.append("        AND NVL (MV.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("        AND CMO.CRE_OFC_CD = MO.OFC_CD" ).append("\n"); 
		query.append("        AND MO.LOC_CD = ML.LOC_CD" ).append("\n"); 
		query.append("        AND ML.CONTI_CD = 'E'" ).append("\n"); 
		query.append("        AND CMO.BKG_NO = S.BKG_NO(+)" ).append("\n"); 
		query.append("        AND S.BKG_CUST_TP_CD(+) = 'S'" ).append("\n"); 
		query.append("        AND CMO.BKG_NO = C.BKG_NO(+)" ).append("\n"); 
		query.append("        AND C.BKG_CUST_TP_CD(+) = 'C'" ).append("\n"); 
		query.append("        AND CMO.BKG_NO = N.BKG_NO(+)" ).append("\n"); 
		query.append("        AND N.BKG_CUST_TP_CD(+) = 'N'" ).append("\n"); 
		query.append("        AND CMO.EQ_NO = MST.CNTR_NO(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${wo_no} == '')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/** REDELIVERY-02 **/" ).append("\n"); 
		query.append("     SELECT TRO.CFM_OFC_CD AS I_OFFICE," ).append("\n"); 
		query.append("            TRO.IO_BND_CD AS BD," ).append("\n"); 
		query.append("            DECODE (TRO.IO_BND_CD, 'I', 'IN', 'O', 'OUT', TRO.IO_BND_CD) AS BD_DISP," ).append("\n"); 
		query.append("            TRO.BKG_TRSP_MZD_CD AS MODE_CD," ).append("\n"); 
		query.append("            'M' AS TYPE_CD," ).append("\n"); 
		query.append("            'M/H' AS TYPE_DISP," ).append("\n"); 
		query.append("            TRO.TRO_SEQ AS TRO_SEQ," ).append("\n"); 
		query.append("            NVL (BB.PRE_RLY_PORT_CD, BB.POL_CD) AS POL," ).append("\n"); 
		query.append("            NVL (BB.PST_RLY_PORT_CD, BB.POD_CD) AS POD," ).append("\n"); 
		query.append("            TRO.CNTR_RTN_YD_CD AS EMPTY_CY," ).append("\n"); 
		query.append("            TRO.CNTR_RTN_YD_CD AS ORG_EMPTY_CY," ).append("\n"); 
		query.append("            0 AS S_P," ).append("\n"); 
		query.append("            '' AS VNDR_LGL_ENG_NM," ).append("\n"); 
		query.append("            TO_CHAR (TRO.CNTR_RTN_DT, 'YYYY-MM-DD') AS PD_DATE_DISP," ).append("\n"); 
		query.append("            TO_CHAR (TRO.CNTR_RTN_DT, 'YYYY-MM-DD') AS PD_DATE," ).append("\n"); 
		query.append("            TRO.CNTR_NO AS CNTR_NO," ).append("\n"); 
		query.append("            TRO.CNTR_TPSZ_CD AS TP," ).append("\n"); 
		query.append("            MST.LSTM_CD," ).append("\n"); 
		query.append("            '' AS CB," ).append("\n"); 
		query.append("            '' AS EMPTY_DEST," ).append("\n"); 
		query.append("            MY.FAX_NO AS FAX_NO," ).append("\n"); 
		query.append("            MY.YD_EML AS EMAIL," ).append("\n"); 
		query.append("            '' AS OFFICE," ).append("\n"); 
		query.append("            '' AS USER_ID," ).append("\n"); 
		query.append("            '' AS ISSUE_DT," ).append("\n"); 
		query.append("            '' AS FAX_EMAIL_RST,    /** Fax/E-mail Result **/" ).append("\n"); 
		query.append("            TRO.BKG_NO AS BKG_NO," ).append("\n"); 
		query.append("            BB.BL_NO AS BL_NO," ).append("\n"); 
		query.append("            BB.VSL_CD||BB.SKD_VOY_NO||BB.SKD_DIR_CD AS VVD," ).append("\n"); 
		query.append("            '' AS WO_NO," ).append("\n"); 
		query.append("            NVL (REPLACE (REPLACE (REPLACE (REPLACE (REPLACE (RTRIM (TRO.SPCL_INSTR_RMK), CHR(92)||'r'||CHR(92)||'n', ' '), CHR(13)||CHR(10), ' '), CHR(34), ' '), CHR(9), ' '),  CHR(13),  ' '),  '') AS SPCL_INST," ).append("\n"); 
		query.append("            REPLACE (REPLACE (REPLACE (REPLACE (REPLACE (SUBSTR (S.CUST_NM, 1, 50), CHR(92)||'r'||CHR(92)||'n', ' '), CHR(13)||CHR(10), ' '), CHR(34), ' '), CHR(9), ' '),  CHR(13),  ' ') AS SHPR," ).append("\n"); 
		query.append("            REPLACE (REPLACE (REPLACE (REPLACE (REPLACE (SUBSTR (C.CUST_NM, 1, 50), CHR(92)||'r'||CHR(92)||'n', ' '), CHR(13)||CHR(10), ' '), CHR(34), ' '), CHR(9), ' '),  CHR(13),  ' ') AS CNEE," ).append("\n"); 
		query.append("            REPLACE (REPLACE (REPLACE (REPLACE (REPLACE (SUBSTR (N.CUST_NM, 1, 50), CHR(92)||'r'||CHR(92)||'n', ' '), CHR(13)||CHR(10), ' '), CHR(34), ' '), CHR(9), ' '),  CHR(13),  ' ') AS NTFY," ).append("\n"); 
		query.append("            '' AS SO_OFC_CTY_CD," ).append("\n"); 
		query.append("            0 AS SO_SEQ," ).append("\n"); 
		query.append("			(	SELECT NVL(T1.ACT_CRR_CD, T3.CRR_CD) AS CARRIER_CD FROM VSK_VSL_SKD T1, MDM_VSL_CNTR T3" ).append("\n"); 
		query.append("				WHERE T1.VSL_CD       = T3.VSL_CD" ).append("\n"); 
		query.append("				AND T1.VSL_CD = BB.VSL_CD" ).append("\n"); 
		query.append("				AND T1.SKD_VOY_NO = BB.SKD_VOY_NO" ).append("\n"); 
		query.append("				AND T1.SKD_DIR_CD = BB.SKD_DIR_CD" ).append("\n"); 
		query.append("			)	SHIP_OPR" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       FROM CIM_TERRITORY CT," ).append("\n"); 
		query.append("            MDM_YARD MY," ).append("\n"); 
		query.append("   #if (${lcc_cd} != '')" ).append("\n"); 
		query.append("            MDM_LOCATION ML," ).append("\n"); 
		query.append("            MDM_EQ_ORZ_CHT MC," ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("            BKG_EUR_TRO TRO," ).append("\n"); 
		query.append("            BKG_BOOKING BB," ).append("\n"); 
		query.append("            BKG_CUSTOMER S," ).append("\n"); 
		query.append("            BKG_CUSTOMER C," ).append("\n"); 
		query.append("            BKG_CUSTOMER N," ).append("\n"); 
		query.append("            MST_CONTAINER MST" ).append("\n"); 
		query.append("      WHERE 1 = 1" ).append("\n"); 
		query.append("   #if ((${bkg_no} == '' && ${bl_no} == '' && ${cntr_no} == '' && ${wo_no} == '') && (${p_date1} != '' && ${p_date2} != ''))" ).append("\n"); 
		query.append("        AND TRO.CNTR_RTN_DT BETWEEN TO_DATE (@[p_date1], 'YYYY-MM-DD') AND TO_DATE (@[p_date2], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("        AND CT.CNTR_STK_TERR_CD = @[territory]" ).append("\n"); 
		query.append("        AND CT.OFC_CD = @[office]" ).append("\n"); 
		query.append("        AND MY.YD_CD LIKE CT.CNT_CD||'%'" ).append("\n"); 
		query.append("   #if (${bkg_no} != '')" ).append("\n"); 
		query.append("        AND BB.BKG_NO LIKE @[bkg_no]||'%'" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if (${bl_no} != '')" ).append("\n"); 
		query.append("        AND BB.BL_NO LIKE @[bl_no]||'%'" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("        AND TRO.BKG_NO = BB.BKG_NO" ).append("\n"); 
		query.append("   #if (${cntr_no} != '')" ).append("\n"); 
		query.append("        AND TRO.CNTR_NO LIKE @[cntr_no]||'%'" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if (${cntr_tpsz_cd} != '')" ).append("\n"); 
		query.append("        AND TRO.CNTR_TPSZ_CD IN (${cntr_tpsz_cd})" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if (${p_yard2} != '')" ).append("\n"); 
		query.append("        AND TRO.CNTR_RTN_YD_CD = @[p_yard1]||@[p_yard2]" ).append("\n"); 
		query.append("   #elseif (${p_yard1} != '')" ).append("\n"); 
		query.append("        AND TRO.CNTR_RTN_YD_CD LIKE @[p_yard1]||'%'" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if (${lcc_cd} != '')" ).append("\n"); 
		query.append("        AND MC.LCC_CD LIKE @[lcc_cd]||'%'" ).append("\n"); 
		query.append("        AND MC.SCC_CD = ML.SCC_CD" ).append("\n"); 
		query.append("        AND ML.LOC_CD = MY.LOC_CD" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("        AND TRO.CNTR_RTN_YD_CD = MY.YD_CD" ).append("\n"); 
		query.append("        AND TRO.TRO_PROC_CD = 'C'" ).append("\n"); 
		query.append("        AND TRO.HLG_TP_CD = 'M'" ).append("\n"); 
		query.append("        AND TRO.IO_BND_CD = 'I'" ).append("\n"); 
		query.append("        AND TRO.CXL_FLG = 'N'" ).append("\n"); 
		query.append("        AND TRO.CNTR_CFM_FLG = 'N'" ).append("\n"); 
		query.append("        AND TRO.BKG_NO = S.BKG_NO(+)" ).append("\n"); 
		query.append("        AND S.BKG_CUST_TP_CD(+) = 'S'" ).append("\n"); 
		query.append("        AND TRO.BKG_NO = C.BKG_NO(+)" ).append("\n"); 
		query.append("        AND C.BKG_CUST_TP_CD(+) = 'C'" ).append("\n"); 
		query.append("        AND TRO.BKG_NO = N.BKG_NO(+)" ).append("\n"); 
		query.append("        AND N.BKG_CUST_TP_CD(+) = 'N'" ).append("\n"); 
		query.append("        AND TRO.CNTR_NO = MST.CNTR_NO(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/** REDELIVERY-03 **/" ).append("\n"); 
		query.append("     SELECT CMO.CRE_OFC_CD AS I_OFFICE," ).append("\n"); 
		query.append("            'I' AS BD," ).append("\n"); 
		query.append("            '' AS BD_DISP," ).append("\n"); 
		query.append("            CMO.TRSP_CRR_MOD_CD AS MODE_CD," ).append("\n"); 
		query.append("            DECODE (CMO.TRSP_COST_DTL_MOD_CD , 'ER', 'R', 'S') AS TYPE_CD," ).append("\n"); 
		query.append("            DECODE (CMO.TRSP_COST_DTL_MOD_CD , 'ER', 'MT REPO', 'S/T') AS TYPE_CD," ).append("\n"); 
		query.append("            NULL AS TRO_SEQ," ).append("\n"); 
		query.append("            '' AS POL," ).append("\n"); 
		query.append("            '' AS POD," ).append("\n"); 
		query.append("            CMO.TO_NOD_CD AS EMPTY_CY," ).append("\n"); 
		query.append("            CMO.TO_NOD_CD AS ORG_EMPTY_CY," ).append("\n"); 
		query.append("            MV.VNDR_SEQ AS S_P," ).append("\n"); 
		query.append("            MV.VNDR_LGL_ENG_NM AS VNDR_LGL_ENG_NM," ).append("\n"); 
		query.append("            TO_CHAR (CMO.TRSP_MTY_RQST_DT, 'YYYY-MM-DD') AS PD_DATE_DISP," ).append("\n"); 
		query.append("            TO_CHAR (CMO.TRSP_MTY_RQST_DT, 'YYYY-MM-DD') AS PD_DATE," ).append("\n"); 
		query.append("            CMO.EQ_NO AS CNTR_NO," ).append("\n"); 
		query.append("            CMO.EQ_TPSZ_CD AS TP," ).append("\n"); 
		query.append("            MST.LSTM_CD," ).append("\n"); 
		query.append("            '' AS CB," ).append("\n"); 
		query.append("            CMO.TO_NOD_CD AS EMPTY_DEST," ).append("\n"); 
		query.append("            CMO.FAX_NO AS FAX_NO," ).append("\n"); 
		query.append("            CMO.YD_EML AS EMAIL," ).append("\n"); 
		query.append("            '' AS OFFICE," ).append("\n"); 
		query.append("            '' AS USER_ID," ).append("\n"); 
		query.append("            '' AS ISSUE_DT," ).append("\n"); 
		query.append("            '' AS FAX_EMAIL_RST,    /** Fax/E-mail Result **/" ).append("\n"); 
		query.append("            '' AS BKG_NO," ).append("\n"); 
		query.append("            '' AS BL_NO," ).append("\n"); 
		query.append("            '' AS VVD," ).append("\n"); 
		query.append("            CMO.TRSP_WO_OFC_CTY_CD||CMO.TRSP_WO_SEQ AS WO_NO," ).append("\n"); 
		query.append("            '' AS SPCL_INST," ).append("\n"); 
		query.append("            '' AS SHPR," ).append("\n"); 
		query.append("            '' AS CNEE," ).append("\n"); 
		query.append("            '' AS NTFY," ).append("\n"); 
		query.append("            CMO.TRSP_SO_OFC_CTY_CD AS SO_OFC_CTY_CD," ).append("\n"); 
		query.append("            CMO.TRSP_SO_SEQ AS SO_SEQ," ).append("\n"); 
		query.append("			'' AS SHIP_OPR" ).append("\n"); 
		query.append("       FROM (SELECT" ).append("\n"); 
		query.append("               #if (${bkg_no} != '')" ).append("\n"); 
		query.append("                    /*+ INDEX(ORD XAK9TRS_TRSP_SVC_ORD) */" ).append("\n"); 
		query.append("               #elseif (${bl_no} != '')" ).append("\n"); 
		query.append("                    /*+ INDEX(ORD XAK8TRS_TRSP_SVC_ORD) */" ).append("\n"); 
		query.append("               #else" ).append("\n"); 
		query.append("                    /*+ ORDERED USE_NL (CT MY ORD) */" ).append("\n"); 
		query.append("               #end" ).append("\n"); 
		query.append("                    ORD.CRE_OFC_CD," ).append("\n"); 
		query.append("                    ORD.TRSP_CRR_MOD_CD," ).append("\n"); 
		query.append("                    ORD.TRSP_COST_DTL_MOD_CD," ).append("\n"); 
		query.append("                    ORD.TO_NOD_CD," ).append("\n"); 
		query.append("                    ORD.TRSP_MTY_RQST_DT," ).append("\n"); 
		query.append("                    ORD.EQ_NO," ).append("\n"); 
		query.append("                    ORD.EQ_TPSZ_CD," ).append("\n"); 
		query.append("                    MY.FAX_NO," ).append("\n"); 
		query.append("                    MY.YD_EML," ).append("\n"); 
		query.append("                    ORD.TRSP_WO_OFC_CTY_CD," ).append("\n"); 
		query.append("                    ORD.TRSP_WO_SEQ," ).append("\n"); 
		query.append("                    ORD.VNDR_SEQ," ).append("\n"); 
		query.append("                    ORD.TRO_SEQ," ).append("\n"); 
		query.append("                    ORD.TRSP_SO_OFC_CTY_CD," ).append("\n"); 
		query.append("                    ORD.TRSP_SO_SEQ," ).append("\n"); 
		query.append("                    MY.LOC_CD" ).append("\n"); 
		query.append("               FROM CIM_TERRITORY CT," ).append("\n"); 
		query.append("                    MDM_YARD MY," ).append("\n"); 
		query.append("                    TRS_TRSP_SVC_ORD ORD" ).append("\n"); 
		query.append("              WHERE 1 = 1" ).append("\n"); 
		query.append("               #if ((${bkg_no} == '' && ${bl_no} == '' && ${cntr_no} == '' && ${wo_no} == '') && (${p_date1} != '' && ${p_date2} != ''))" ).append("\n"); 
		query.append("                    AND ORD.TRSP_MTY_RQST_DT BETWEEN TO_DATE (@[p_date1], 'YYYY-MM-DD') AND TO_DATE (@[p_date2], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("               #end" ).append("\n"); 
		query.append("               #if (${bkg_no} != '')" ).append("\n"); 
		query.append("                    AND ORD.BKG_NO LIKE @[bkg_no]||'%'" ).append("\n"); 
		query.append("               #end" ).append("\n"); 
		query.append("               #if (${bl_no} != '')" ).append("\n"); 
		query.append("                    AND ORD.BL_NO LIKE @[bl_no]||'%'" ).append("\n"); 
		query.append("               #end" ).append("\n"); 
		query.append("               #if (${cntr_no} != '')" ).append("\n"); 
		query.append("                    AND ORD.EQ_NO LIKE @[cntr_no]||'%'" ).append("\n"); 
		query.append("               #end" ).append("\n"); 
		query.append("               #if (${cntr_tpsz_cd} != '')" ).append("\n"); 
		query.append("                    AND ORD.EQ_TPSZ_CD IN (${cntr_tpsz_cd})" ).append("\n"); 
		query.append("               #end" ).append("\n"); 
		query.append("                    AND CT.CNTR_STK_TERR_CD = @[territory]" ).append("\n"); 
		query.append("                    AND CT.OFC_CD = @[office]" ).append("\n"); 
		query.append("                    AND MY.YD_CD LIKE CT.CNT_CD||'%'" ).append("\n"); 
		query.append("                    AND ORD.TO_NOD_CD = MY.YD_CD" ).append("\n"); 
		query.append("               #if (${p_yard2} != '')" ).append("\n"); 
		query.append("                    AND ORD.TO_NOD_CD = @[p_yard1]||@[p_yard2]" ).append("\n"); 
		query.append("               #elseif (${p_yard1} != '')" ).append("\n"); 
		query.append("                    AND ORD.TO_NOD_CD LIKE @[p_yard1]||'%'" ).append("\n"); 
		query.append("               #end" ).append("\n"); 
		query.append("                    AND ORD.TRSP_WO_OFC_CTY_CD IS NOT NULL" ).append("\n"); 
		query.append("               #if (${wo_no} != '')" ).append("\n"); 
		query.append("                    AND ORD.TRSP_WO_OFC_CTY_CD = SUBSTR(@[wo_no], 1, 3)" ).append("\n"); 
		query.append("                    AND ORD.TRSP_WO_SEQ = SUBSTR(@[wo_no], 4)" ).append("\n"); 
		query.append("               #end" ).append("\n"); 
		query.append("                    AND ORD.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                    AND NOT EXISTS (SELECT 'A'" ).append("\n"); 
		query.append("                                      FROM CIM_CNTR_STK STK" ).append("\n"); 
		query.append("                                     WHERE STK.STK_LOC_CD = SUBSTR (ORD.TO_NOD_CD, 1, 5)" ).append("\n"); 
		query.append("                                       AND STK.STK_YD_CD = ORD.TO_NOD_CD" ).append("\n"); 
		query.append("                                       AND NVL (STK.IO_BND_CD, 'X') = NVL (ORD.TRSP_BND_CD, 'X')" ).append("\n"); 
		query.append("                                       AND STK.SO_OFC_CTY_CD = ORD.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("                                       AND STK.SO_SEQ = ORD.TRSP_SO_SEQ" ).append("\n"); 
		query.append("                                       AND STK.TRSP_SO_TP_CD = DECODE (ORD.TRSP_COST_DTL_MOD_CD, 'DR', 'C', 'CN', 'S', 'CF', 'S', 'ER', 'R', ORD.TRSP_COST_DTL_MOD_CD))" ).append("\n"); 
		query.append("                    AND (ORD.TRSP_COST_DTL_MOD_CD = 'ER' OR ORD.TRSP_COST_DTL_MOD_CD = 'CN')    /** Carriou **/" ).append("\n"); 
		query.append("                    AND DECODE (ORD.TRSP_COST_DTL_MOD_CD, 'CN', ORD.MTY_RRO_ISS_FLG, ORD.MTY_RDE_ORD_ISS_FLG) IS NULL" ).append("\n"); 
		query.append("                    AND ORD.TRSP_COST_DTL_MOD_CD = NVL(@[bl_no], ORD.TRSP_COST_DTL_MOD_CD)" ).append("\n"); 
		query.append("                    AND ORD.INV_NO IS NULL) CMO," ).append("\n"); 
		query.append("            MDM_ORGANIZATION MO," ).append("\n"); 
		query.append("            MDM_VENDOR MV," ).append("\n"); 
		query.append("            MDM_LOCATION ML," ).append("\n"); 
		query.append("     #if (${lcc_cd} != '')" ).append("\n"); 
		query.append("            MDM_EQ_ORZ_CHT MC," ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("            MST_CONTAINER MST" ).append("\n"); 
		query.append("      WHERE 1 = 1" ).append("\n"); 
		query.append("     #if (${lcc_cd} != '')" ).append("\n"); 
		query.append("        AND MC.LCC_CD LIKE @[lcc_cd]||'%'" ).append("\n"); 
		query.append("        AND MC.SCC_CD = ML.SCC_CD" ).append("\n"); 
		query.append("        AND ML.LOC_CD = CMO.LOC_CD" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("        AND MV.VNDR_SEQ = CMO.VNDR_SEQ" ).append("\n"); 
		query.append("        AND NVL (MV.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("        AND CMO.CRE_OFC_CD = MO.OFC_CD" ).append("\n"); 
		query.append("        AND MO.LOC_CD = ML.LOC_CD" ).append("\n"); 
		query.append("        AND ML.CONTI_CD = 'E'" ).append("\n"); 
		query.append("        AND CMO.EQ_NO = MST.CNTR_NO(+)" ).append("\n"); 

	}
}