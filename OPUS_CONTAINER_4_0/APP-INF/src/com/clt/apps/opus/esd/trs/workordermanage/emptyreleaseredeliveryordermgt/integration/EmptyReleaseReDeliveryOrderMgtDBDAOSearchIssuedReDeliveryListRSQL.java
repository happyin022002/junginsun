/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EmptyReleaseReDeliveryOrderMgtDBDAOSearchIssuedReDeliveryListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.10.07
*@LastModifier : 박찬우
*@LastVersion : 1.0
* 2016.10.07 박찬우
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.emptyreleaseredeliveryordermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chanwoo Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EmptyReleaseReDeliveryOrderMgtDBDAOSearchIssuedReDeliveryListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public EmptyReleaseReDeliveryOrderMgtDBDAOSearchIssuedReDeliveryListRSQL(){
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
		params.put("p_yard2",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("issued",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.emptyreleaseredeliveryordermgt.integration").append("\n"); 
		query.append("FileName : EmptyReleaseReDeliveryOrderMgtDBDAOSearchIssuedReDeliveryListRSQL").append("\n"); 
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
		query.append("/** ISSUE - REDELIVERY **/" ).append("\n"); 
		query.append("SELECT   STK.STK_OFC_CD AS I_OFFICE," ).append("\n"); 
		query.append("         STK.STK_GATE_IO_CD AS BD," ).append("\n"); 
		query.append("         DECODE (STK.IO_BND_CD, 'I', 'IN', 'O', 'OUT', STK.IO_BND_CD) AS BD_DISP," ).append("\n"); 
		query.append("         STK.TRSP_CRR_MOD_CD AS MODE_CD," ).append("\n"); 
		query.append("         STK.TRSP_SO_TP_CD AS TYPE_CD," ).append("\n"); 
		query.append("         DECODE (STK.TRSP_SO_TP_CD, 'C', 'C/H', 'M', 'M/H', 'R', 'MT REPO', 'S', 'S/T', 'D', 'DOMESTIC', STK.TRSP_SO_TP_CD) AS TYPE_DISP," ).append("\n"); 
		query.append("         ORD.TRO_SEQ AS TRO_SEQ," ).append("\n"); 
		query.append("         NVL (STK.POL_CD, '') AS POL," ).append("\n"); 
		query.append("         NVL (STK.POD_CD, '') AS POD," ).append("\n"); 
		query.append("         STK.STK_YD_CD AS EMPTY_CY," ).append("\n"); 
		query.append("         DECODE(STK.TRSP_SO_TP_CD, 'C', MV.VNDR_SEQ, 'M', '', MV.VNDR_SEQ) AS S_P," ).append("\n"); 
		query.append("         MV.VNDR_LGL_ENG_NM AS VNDR_LGL_ENG_NM," ).append("\n"); 
		query.append("         TO_CHAR (STK.STK_JB_DT, 'YYYY-MM-DD') AS PD_DATE_DISP," ).append("\n"); 
		query.append("         TO_CHAR (STK.STK_JB_DT, 'YYYY-MM-DD') AS PD_DATE," ).append("\n"); 
		query.append("         NVL (NVL (NVL (STK.CNTR_NO, ORD.EQ_NO), ORD.EQ_NO), ORD.EQ_NO) AS CNTR_NO," ).append("\n"); 
		query.append("         ORD.CNTR_SLT_NO," ).append("\n"); 
		query.append("         STK.CNTR_TPSZ_CD AS TP," ).append("\n"); 
		query.append("         MST.LSTM_CD," ).append("\n"); 
		query.append("         ORD.CMB_SO_RLT_STS_FLG AS CB," ).append("\n"); 
		query.append("         ORD.TO_NOD_CD AS EMPTY_DEST," ).append("\n"); 
		query.append("         STK.STK_FAX_NO AS FAX_NO," ).append("\n"); 
		query.append("         STK.STK_EML AS EMAIL," ).append("\n"); 
		query.append("         STK.STK_OFC_CD AS OFFICE," ).append("\n"); 
		query.append("         STK.UPD_USR_ID AS USER_ID," ).append("\n"); 
		query.append("         TO_CHAR (STK.STK_EVNT_DT, 'YYYY-MM-DD HH24:MI') AS ISSUE_DT," ).append("\n"); 
		query.append("         STK.BKG_NO AS BKG_NO," ).append("\n"); 
		query.append("         STK.BL_NO AS BL_NO," ).append("\n"); 
		query.append("         STK.VSL_CD||STK.SKD_VOY_NO||STK.SKD_DIR_CD AS VVD," ).append("\n"); 
		query.append("         ORD.TRSP_WO_OFC_CTY_CD||ORD.TRSP_WO_SEQ AS WO_NO," ).append("\n"); 
		query.append("         RTRIM (ORD.SPCL_INSTR_RMK) AS SPCL_INST," ).append("\n"); 
		query.append("         REPLACE (REPLACE (REPLACE (REPLACE (REPLACE (SUBSTR (S.CUST_NM, 1, 50), CHR(92)||'R'||CHR(92)||'N', ' '), CHR(13)||CHR(10), ' '), CHR(34), ' '), CHR(9), ' '),  CHR(13),  ' ') AS SHPR," ).append("\n"); 
		query.append("         REPLACE (REPLACE (REPLACE (REPLACE (REPLACE (SUBSTR (C.CUST_NM, 1, 50), CHR(92)||'R'||CHR(92)||'N', ' '), CHR(13)||CHR(10), ' '), CHR(34), ' '), CHR(9), ' '),  CHR(13),  ' ') AS CNEE," ).append("\n"); 
		query.append("         REPLACE (REPLACE (REPLACE (REPLACE (REPLACE (SUBSTR (N.CUST_NM, 1, 50), CHR(92)||'R'||CHR(92)||'N', ' '), CHR(13)||CHR(10), ' '), CHR(34), ' '), CHR(9), ' '),  CHR(13),  ' ') AS NTFY," ).append("\n"); 
		query.append("         STK.SO_OFC_CTY_CD AS SO_OFC_CTY_CD," ).append("\n"); 
		query.append("         STK.SO_SEQ AS SO_SEQ," ).append("\n"); 
		query.append("         CASE 	WHEN NVL(STK.FAX_SND_NO, 'X') <> 'X' AND SUBSTR (STK.FAX_SND_NO, -3) <> 'TRS' THEN  DECODE (FAX.FAX_PROC_STS_CD, '6', TO_CHAR (STK.STK_EVNT_DT, 'YYYY-MM-DD HH24:MI')||'Success',  'Fail')" ).append("\n"); 
		query.append("            	WHEN NVL(STK.FAX_SND_NO, 'X') <> 'X' AND SUBSTR (STK.FAX_SND_NO, -3) = 'TRS'  THEN  DECODE (FAX.FAX_PROC_STS_CD, '5', TO_CHAR (STK.STK_EVNT_DT, 'YYYY-MM-DD HH24:MI')||'Success', '6', 'Fail', 'Sending')           " ).append("\n"); 
		query.append("         END AS FAX_RST," ).append("\n"); 
		query.append("         CASE	WHEN NVL(STK.EML_SND_NO, 'X') <> 'X'  THEN  DECODE (MAIL.EML_PROC_STS_CD, '3', TO_CHAR (STK.STK_EVNT_DT, 'YYYY-MM-DD HH24:MI')||'Success', 'Fail')" ).append("\n"); 
		query.append("         END AS EML_RST," ).append("\n"); 
		query.append("         ORD.REF_ID," ).append("\n"); 
		query.append("		 STK.EML_SND_NO," ).append("\n"); 
		query.append("		 CASE 	WHEN STK.STK_ISS_CD = 'D' THEN 'D'" ).append("\n"); 
		query.append("				WHEN NVL(STK.EML_SND_NO, 'X') <> 'X' THEN 'E'" ).append("\n"); 
		query.append("				WHEN NVL(STK.FAX_SND_NO, 'X') <> 'X' THEN 'F'" ).append("\n"); 
		query.append("		 END STK_ISS_CD," ).append("\n"); 
		query.append("         ORD.TRSP_COST_DTL_MOD_CD" ).append("\n"); 
		query.append("    FROM CIM_CNTR_STK STK," ).append("\n"); 
		query.append("         TRS_TRSP_SVC_ORD ORD," ).append("\n"); 
		query.append("         MDM_VENDOR MV," ).append("\n"); 
		query.append("         MDM_YARD MY," ).append("\n"); 
		query.append("#if (${p_yard2} == '' && ${p_yard1} == '' && ${lcc_cd} != '')" ).append("\n"); 
		query.append("         MDM_LOCATION ML," ).append("\n"); 
		query.append("         MDM_EQ_ORZ_CHT MC," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("         BKG_CUSTOMER S," ).append("\n"); 
		query.append("         BKG_CUSTOMER C," ).append("\n"); 
		query.append("         BKG_CUSTOMER N," ).append("\n"); 
		query.append("         COM_FAX_SND_INFO FAX," ).append("\n"); 
		query.append("         COM_EML_SND_INFO MAIL," ).append("\n"); 
		query.append("         MST_CONTAINER MST" ).append("\n"); 
		query.append("   WHERE 1 = 1" ).append("\n"); 
		query.append("     AND STK.SO_OFC_CTY_CD = ORD.TRSP_SO_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("     AND STK.SO_SEQ = ORD.TRSP_SO_SEQ(+)" ).append("\n"); 
		query.append("     AND MY.YD_CD = STK.STK_YD_CD" ).append("\n"); 
		query.append("#if ((${bkg_no} == '' && ${bl_no} == '' && ${cntr_no} == '' && ${wo_no} == '') && (${p_date1} != '' && ${p_date2} != ''))" ).append("\n"); 
		query.append("     AND STK.STK_EVNT_DT BETWEEN TO_DATE (@[p_date1], 'YYYY-MM-DD') AND TO_DATE (@[p_date2], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_no} != '')" ).append("\n"); 
		query.append("     AND ORD.BKG_NO LIKE @[bkg_no]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bl_no} != '')" ).append("\n"); 
		query.append("     AND ORD.BL_NO LIKE @[bl_no]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cntr_no} != '')" ).append("\n"); 
		query.append("     AND ORD.EQ_NO LIKE @[cntr_no]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${wo_no} != '')" ).append("\n"); 
		query.append("     AND ORD.TRSP_WO_OFC_CTY_CD = SUBSTR(@[wo_no], 1, 3)" ).append("\n"); 
		query.append("     AND ORD.TRSP_WO_SEQ = SUBSTR(@[wo_no], 4)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${p_yard2} != '')" ).append("\n"); 
		query.append("     AND ORD.FM_NOD_CD = @[p_yard1]||@[p_yard2]" ).append("\n"); 
		query.append("#elseif (${p_yard1} != '')" ).append("\n"); 
		query.append("     AND ORD.FM_NOD_CD LIKE @[p_yard1]||'%'" ).append("\n"); 
		query.append("#elseif (${lcc_cd} != '')" ).append("\n"); 
		query.append("     AND MC.LCC_CD LIKE @[lcc_cd]||'%'" ).append("\n"); 
		query.append("     AND MC.SCC_CD = ML.SCC_CD" ).append("\n"); 
		query.append("     AND ML.LOC_CD = MY.LOC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("     AND ORD.VNDR_SEQ = MV.VNDR_SEQ(+)" ).append("\n"); 
		query.append("     AND NVL (MV.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("--     AND STK.STL_FLG = 'N'" ).append("\n"); 
		query.append("     AND STK.STK_GATE_IO_CD = 'I'" ).append("\n"); 
		query.append("     AND STK.BKG_NO = S.BKG_NO(+)" ).append("\n"); 
		query.append("     AND S.BKG_CUST_TP_CD(+) = 'S'" ).append("\n"); 
		query.append("     AND STK.BKG_NO = C.BKG_NO(+)" ).append("\n"); 
		query.append("     AND C.BKG_CUST_TP_CD(+) = 'C'" ).append("\n"); 
		query.append("     AND STK.BKG_NO = N.BKG_NO(+)" ).append("\n"); 
		query.append("     AND N.BKG_CUST_TP_CD(+) = 'N'" ).append("\n"); 
		query.append("     AND STK.FAX_SND_NO = FAX.FAX_SND_NO(+)" ).append("\n"); 
		query.append("     AND STK.EML_SND_NO = MAIL.EML_SND_NO(+)" ).append("\n"); 
		query.append("     AND STK.CNTR_NO = MST.CNTR_NO(+)" ).append("\n"); 
		query.append("	 AND NVL(STK.STK_ISS_CD, 'X') = DECODE(@[issued], 'N', 'X',  STK.STK_ISS_CD)" ).append("\n"); 
		query.append("     AND ORD.TRSP_SO_TP_CD IN('Y', 'M')" ).append("\n"); 
		query.append("ORDER BY WO_NO, TP" ).append("\n"); 

	}
}