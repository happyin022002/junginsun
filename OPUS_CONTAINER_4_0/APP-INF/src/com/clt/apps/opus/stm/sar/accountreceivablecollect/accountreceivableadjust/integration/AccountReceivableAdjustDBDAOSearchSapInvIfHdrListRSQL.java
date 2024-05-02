/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AccountReceivableAdjustDBDAOSearchSapInvIfHdrListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.18
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.18 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableAdjustDBDAOSearchSapInvIfHdrListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Retrieve AP INTERFACE Header Info
	  * </pre>
	  */
	public AccountReceivableAdjustDBDAOSearchSapInvIfHdrListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("func_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("adj_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ap_gl_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ap_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.integration").append("\n"); 
		query.append("FileName : AccountReceivableAdjustDBDAOSearchSapInvIfHdrListRSQL").append("\n"); 
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
		query.append("#if(${sys_tp_cd} == 'ADJ')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("       #if(${rvs_flg} == 'N')" ).append("\n"); 
		query.append("            CASE WHEN SIGN(SUM(SAD.ADJ_CRS_CURR_AMT) + MAX(SAH.GAIN_AND_LSS_AMT)) = -1 THEN" ).append("\n"); 
		query.append("                    OPUSADM.SAP_GEN_INV_NUM_FNC ('02','C',@[usr_id],SAH.AP_OFC_CD)" ).append("\n"); 
		query.append("                 ELSE" ).append("\n"); 
		query.append("                    OPUSADM.SAP_GEN_INV_NUM_FNC ('02','S',@[usr_id],SAH.AP_OFC_CD)" ).append("\n"); 
		query.append("            END AS INV_NO," ).append("\n"); 
		query.append("       #else" ).append("\n"); 
		query.append("            CASE WHEN SIGN(SUM(SAD.ADJ_CRS_CURR_AMT) + MAX(SAH.GAIN_AND_LSS_AMT)) = 1 THEN" ).append("\n"); 
		query.append("                    OPUSADM.SAP_GEN_INV_NUM_FNC ('02','C',@[usr_id],SAH.AP_OFC_CD)" ).append("\n"); 
		query.append("                 ELSE" ).append("\n"); 
		query.append("                    OPUSADM.SAP_GEN_INV_NUM_FNC ('02','S',@[usr_id],SAH.AP_OFC_CD)" ).append("\n"); 
		query.append("            END AS INV_NO," ).append("\n"); 
		query.append("       #end " ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       #if(${rvs_flg} == 'N')" ).append("\n"); 
		query.append("            DECODE(SIGN(SUM(SAD.ADJ_CRS_CURR_AMT) + MAX(SAH.GAIN_AND_LSS_AMT)),-1, 'CREDIT','STANDARD') AS INV_TP_LU_CD," ).append("\n"); 
		query.append("       #else" ).append("\n"); 
		query.append("            DECODE(SIGN(SUM(SAD.ADJ_CRS_CURR_AMT) + MAX(SAH.GAIN_AND_LSS_AMT)),1, 'CREDIT','STANDARD') AS INV_TP_LU_CD," ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       (" ).append("\n"); 
		query.append("          SELECT MAX(ADJ_APLY_DT) " ).append("\n"); 
		query.append("          FROM SAR_ADJ_HIS SAHH" ).append("\n"); 
		query.append("          WHERE SAHH.ADJ_NO = SAH.ADJ_NO" ).append("\n"); 
		query.append("       ) AS INV_DT," ).append("\n"); 
		query.append("       SAH.VNDR_NO AS VNDR_NO," ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       #if(${rvs_flg} == 'N')" ).append("\n"); 
		query.append("            SUM(SAD.ADJ_CRS_CURR_AMT) AS INV_AMT, " ).append("\n"); 
		query.append("       #else" ).append("\n"); 
		query.append("            (-1) * SUM(SAD.ADJ_CRS_CURR_AMT) AS INV_AMT," ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       SAD.ADJ_CRS_CURR_CD AS INV_CURR_CD," ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       #if(${ap_curr_cd} == ${func_curr_cd} )" ).append("\n"); 
		query.append("            1 AS INV_XCH_RT," ).append("\n"); 
		query.append("            NULL AS INV_XCH_RT_TP_CD," ).append("\n"); 
		query.append("       #else" ).append("\n"); 
		query.append("            (SELECT ROUND(GLXR.CONV_XCH_RT, 6) AS CONV_XCH_RT" ).append("\n"); 
		query.append("              FROM GL_DLY_XCH_RT GLXR " ).append("\n"); 
		query.append("              WHERE GLXR.ACCT_XCH_RT_DT = @[ap_gl_dt]" ).append("\n"); 
		query.append("              AND GLXR.FM_CURR_CD = @[ap_curr_cd]" ).append("\n"); 
		query.append("              AND GLXR.TO_CURR_CD = @[func_curr_cd]) AS INV_XCH_RT," ).append("\n"); 
		query.append("            1 AS INV_XCH_RT_TP_CD," ).append("\n"); 
		query.append("       #end " ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       @[ap_gl_dt] AS INV_XCH_DT," ).append("\n"); 
		query.append("       MV.GEN_PAY_TERM_CD AS INV_TERM_NM," ).append("\n"); 
		query.append("       SAH.AP_RMK AS INV_DESC, " ).append("\n"); 
		query.append("       'Refund' AS ATTR_CATE_NM," ).append("\n"); 
		query.append("       NULL AS ATTR_CTNT2," ).append("\n"); 
		query.append("       SAH.ADJ_NO AS ATTR_CTNT4," ).append("\n"); 
		query.append("       NULL AS ATTR_CTNT7," ).append("\n"); 
		query.append("       'NEW' AS INV_IF_STS_CD," ).append("\n"); 
		query.append("       'AR' AS IF_SRC_NM," ).append("\n"); 
		query.append("       SAD.ADJ_CRS_CURR_CD AS INV_PAY_CURR_CD," ).append("\n"); 
		query.append("       MV.PAY_MZD_CD AS AP_PAY_MZD_LU_CD," ).append("\n"); 
		query.append("       MO.AP_OFC_CD || '_O/EXP' AS PAY_GRP_LU_CD," ).append("\n"); 
		query.append("       (" ).append("\n"); 
		query.append("          SELECT MAX(ADJ_APLY_DT) " ).append("\n"); 
		query.append("          FROM SAR_ADJ_HIS SAHH" ).append("\n"); 
		query.append("          WHERE SAHH.ADJ_NO = SAH.ADJ_NO" ).append("\n"); 
		query.append("       ) AS INV_RCV_DT," ).append("\n"); 
		query.append("       @[ap_gl_dt] AS GL_DT," ).append("\n"); 
		query.append("       SAH.AP_OFC_CD AS OFC_CD,  " ).append("\n"); 
		query.append("       (" ).append("\n"); 
		query.append("          SELECT MAX(ADJ_APLY_DT) " ).append("\n"); 
		query.append("          FROM SAR_ADJ_HIS SAHH" ).append("\n"); 
		query.append("          WHERE SAHH.ADJ_NO = SAH.ADJ_NO" ).append("\n"); 
		query.append("       ) AS INV_TERM_DT,     " ).append("\n"); 
		query.append("       '01' AS CO_CD," ).append("\n"); 
		query.append("       MO.FINC_RGN_CD AS CNT_CD," ).append("\n"); 
		query.append("       MO.AP_CTR_CD AS CTR_CD," ).append("\n"); 
		query.append("       DECODE(NVL(MV.INTER_CO_FLG,'N'), 'Y',NVL(MV.SUBS_CO_CD,'00'),'00') AS INTER_CO_CD" ).append("\n"); 
		query.append("FROM SAR_ADJ_HDR SAH, " ).append("\n"); 
		query.append("     SAR_ADJ_DTL SAD," ).append("\n"); 
		query.append("     MDM_ORGANIZATION MO," ).append("\n"); 
		query.append("     MDM_VENDOR MV" ).append("\n"); 
		query.append("WHERE SAH.OTS_ADJ_SEQ = SAD.OTS_ADJ_SEQ" ).append("\n"); 
		query.append("AND SAH.ADJ_NO = @[adj_no]" ).append("\n"); 
		query.append("AND MO.OFC_CD = SAH.AP_OFC_CD" ).append("\n"); 
		query.append("AND MV.VNDR_SEQ = SAH.VNDR_NO " ).append("\n"); 
		query.append("GROUP BY SAH.ADJ_NO,  " ).append("\n"); 
		query.append("       SAH.ADJ_TP_CD, " ).append("\n"); 
		query.append("       SAH.BIL_TO_CUST_CNT_CD," ).append("\n"); 
		query.append("       SAH.BIL_TO_CUST_SEQ, " ).append("\n"); 
		query.append("       SAD.ADJ_CRS_CURR_CD, " ).append("\n"); 
		query.append("       SAH.VNDR_NO, " ).append("\n"); 
		query.append("       SAH.AP_OFC_CD, " ).append("\n"); 
		query.append("       -- 2016.01.18 block DECODE(SIGN(SAD.ADJ_AMT),-1, 'CREDIT','STANDARD')," ).append("\n"); 
		query.append("	   MV.GEN_PAY_TERM_CD," ).append("\n"); 
		query.append("       SAH.AP_RMK," ).append("\n"); 
		query.append("       DECODE(NVL(MV.INTER_CO_FLG,'N'), 'Y',NVL(MV.SUBS_CO_CD,'00'),'00')," ).append("\n"); 
		query.append("       MO.FINC_RGN_CD," ).append("\n"); 
		query.append("       MO.AP_CTR_CD," ).append("\n"); 
		query.append("       MV.PAY_MZD_CD," ).append("\n"); 
		query.append("       MO.AP_OFC_CD" ).append("\n"); 
		query.append("#elseif(${sys_tp_cd} == 'OFF')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT           " ).append("\n"); 
		query.append("       #if(${rvs_flg} == 'N')" ).append("\n"); 
		query.append("           SUM(SOM.OFFST_XCH_AMT) * (-1)  AS INV_AMT, " ).append("\n"); 
		query.append("       #else" ).append("\n"); 
		query.append("           SUM(SOM.OFFST_XCH_AMT)  AS INV_AMT," ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("       @[ap_gl_dt] AS INV_DT," ).append("\n"); 
		query.append("       SOM.VNDR_NO AS VNDR_NO," ).append("\n"); 
		query.append("       SOM.OFFST_CURR_CD AS INV_CURR_CD," ).append("\n"); 
		query.append("       #if(${ap_curr_cd} == ${func_curr_cd} )" ).append("\n"); 
		query.append("            1 AS INV_XCH_RT," ).append("\n"); 
		query.append("            NULL AS INV_XCH_RT_TP_CD," ).append("\n"); 
		query.append("       #else" ).append("\n"); 
		query.append("            (SELECT ROUND(GLXR.CONV_XCH_RT, 6) AS CONV_XCH_RT" ).append("\n"); 
		query.append("              FROM GL_DLY_XCH_RT GLXR " ).append("\n"); 
		query.append("              WHERE GLXR.ACCT_XCH_RT_DT = @[ap_gl_dt]" ).append("\n"); 
		query.append("              AND GLXR.FM_CURR_CD = @[ap_curr_cd]" ).append("\n"); 
		query.append("              AND GLXR.TO_CURR_CD = @[func_curr_cd]) AS INV_XCH_RT," ).append("\n"); 
		query.append("              '1' AS INV_XCH_RT_TP_CD," ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("       @[ap_gl_dt] AS INV_XCH_DT," ).append("\n"); 
		query.append("       MV.GEN_PAY_TERM_CD AS INV_TERM_NM," ).append("\n"); 
		query.append("       'ARAP CLEARING ' ||SOM.AP_RMK||' '||SOM.AR_OFFST_NO AS INV_DESC," ).append("\n"); 
		query.append("       'AR AP Offset' AS ATTR_CATE_NM," ).append("\n"); 
		query.append("       SOM.AR_OFFST_NO AS ATTR_CTNT2," ).append("\n"); 
		query.append("       NULL AS ATTR_CTNT4," ).append("\n"); 
		query.append("       NULL AS ATTR_CTNT7," ).append("\n"); 
		query.append("       'NEW' AS INV_IF_STS_CD," ).append("\n"); 
		query.append("       'AR' AS IF_SRC_NM," ).append("\n"); 
		query.append("       SOM.OFFST_CURR_CD AS INV_PAY_CURR_CD," ).append("\n"); 
		query.append("       MV.PAY_MZD_CD AS AP_PAY_MZD_LU_CD," ).append("\n"); 
		query.append("       MO.AP_OFC_CD || '_O/EXP' AS PAY_GRP_LU_CD," ).append("\n"); 
		query.append("       (" ).append("\n"); 
		query.append("          SELECT MAX(ADJ_APLY_DT) " ).append("\n"); 
		query.append("          FROM SAR_ADJ_HIS SAHH" ).append("\n"); 
		query.append("          WHERE SAHH.ADJ_NO = SOM.AR_OFFST_NO" ).append("\n"); 
		query.append("       )  AS INV_RCV_DT," ).append("\n"); 
		query.append("       @[ap_gl_dt] AS GL_DT," ).append("\n"); 
		query.append("       SOM.OFC_CD AS OFC_CD,       " ).append("\n"); 
		query.append("       MAX(SOM.AP_INV_TERM_DT) AS INV_TERM_DT," ).append("\n"); 
		query.append("       '01' AS CO_CD," ).append("\n"); 
		query.append("       --변경" ).append("\n"); 
		query.append("       --MO.FINC_RGN_CD AS CNT_CD," ).append("\n"); 
		query.append("       --MO.AP_CTR_CD AS CTR_CD," ).append("\n"); 
		query.append("       --DECODE(NVL(MV.INTER_CO_FLG,'N'), 'Y',NVL(MV.SUBS_CO_CD,'00'),'00') AS INTER_CO_CD" ).append("\n"); 
		query.append("       SLC.SGM_CTNT2 CNT_CD," ).append("\n"); 
		query.append("       SLC.SGM_CTNT3 CTR_CD," ).append("\n"); 
		query.append("       SLC.SGM_CTNT5 INTER_CO_CD," ).append("\n"); 
		query.append("       --추가" ).append("\n"); 
		query.append("       SLC.SGM_CTNT6 VVD_CD " ).append("\n"); 
		query.append("FROM SAR_OFFST_MST SOM, " ).append("\n"); 
		query.append("     MDM_ORGANIZATION MO," ).append("\n"); 
		query.append("     MDM_VENDOR MV," ).append("\n"); 
		query.append("     --추가" ).append("\n"); 
		query.append("     SAP_INV_HDR   SIH," ).append("\n"); 
		query.append("     SCO_LEGR_CD_CMB SLC" ).append("\n"); 
		query.append("WHERE SOM.AR_OFFST_NO = @[adj_no]" ).append("\n"); 
		query.append("AND MO.OFC_CD = SOM.OFC_CD" ).append("\n"); 
		query.append("AND MV.VNDR_SEQ = SOM.VNDR_NO " ).append("\n"); 
		query.append("--추가" ).append("\n"); 
		query.append("AND   SOM.AP_INV_NO = SIH.INV_NO" ).append("\n"); 
		query.append("AND   SIH.LIAB_CD_CMB_SEQ = SLC.CD_CMB_SEQ" ).append("\n"); 
		query.append("AND SOM.OFFST_TP_CD = 'AP'" ).append("\n"); 
		query.append("GROUP BY SOM.VNDR_NO," ).append("\n"); 
		query.append("       SOM.OFFST_CURR_CD," ).append("\n"); 
		query.append("          MV.GEN_PAY_TERM_CD," ).append("\n"); 
		query.append("       'ARAP CLEARING ' ||SOM.AP_RMK||' '||SOM.AR_OFFST_NO," ).append("\n"); 
		query.append("       SOM.AR_OFFST_NO," ).append("\n"); 
		query.append("       SOM.OFFST_CURR_CD," ).append("\n"); 
		query.append("       SOM.OFC_CD," ).append("\n"); 
		query.append("       '01'," ).append("\n"); 
		query.append("       --변경" ).append("\n"); 
		query.append("       --MO.FINC_RGN_CD," ).append("\n"); 
		query.append("       --MO.AP_CTR_CD," ).append("\n"); 
		query.append("       --DECODE(NVL(MV.INTER_CO_FLG,'N'), 'Y',NVL(MV.SUBS_CO_CD,'00'),'00')" ).append("\n"); 
		query.append("       SLC.SGM_CTNT2," ).append("\n"); 
		query.append("       SLC.SGM_CTNT3," ).append("\n"); 
		query.append("       SLC.SGM_CTNT5," ).append("\n"); 
		query.append("       --추가" ).append("\n"); 
		query.append("       SLC.SGM_CTNT6," ).append("\n"); 
		query.append("       MV.PAY_MZD_CD," ).append("\n"); 
		query.append("       MO.AP_OFC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}