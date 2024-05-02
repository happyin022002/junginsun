/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BLIssuanceDBDAOsearchN3ptyBlRqstRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.18
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAOsearchN3ptyBlRqstRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BLIssuanceDBDAOsearchN3ptyBlRqstRSQL
	  * </pre>
	  */
	public BLIssuanceDBDAOsearchN3ptyBlRqstRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_from_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3pty_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("payr_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_bl_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_iss_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("accss_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("n3pty_bl_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("payr_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOsearchN3ptyBlRqstRSQL").append("\n"); 
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
		query.append("SELECT *" ).append("\n"); 
		query.append("  FROM " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    select RQST.BKG_NO" ).append("\n"); 
		query.append("          ,RQST.POL_CD" ).append("\n"); 
		query.append("          ,RQST.N3PTY_OFC_CD" ).append("\n"); 
		query.append("          ,RQST.PAYR_CUST_CNT_CD" ).append("\n"); 
		query.append("          ,RQST.PAYR_CUST_SEQ" ).append("\n"); 
		query.append("          ,RQST.PAYR_CUST_CNT_CD||LPAD(RQST.PAYR_CUST_SEQ,6,'0') AS PAYR_CUST_CD" ).append("\n"); 
		query.append("		  ,(SELECT CUST_LGL_ENG_NM FROM MDM_CUSTOMER MDM WHERE RQST.PAYR_CUST_CNT_CD = MDM.CUST_CNT_CD AND RQST.PAYR_CUST_SEQ = MDM.CUST_SEQ AND DELT_FLG = 'N') PAYR_CUST_NM" ).append("\n"); 
		query.append("          ,RQST.SHPR_CNTC_PHN_NO " ).append("\n"); 
		query.append("          ,RQST.N3PTY_BL_STS_CD" ).append("\n"); 
		query.append("          ,NVL(DECODE((SELECT RT.FRT_TERM_CD FROM BKG_CHG_RT RT WHERE RT.BKG_NO = RQST.BKG_NO AND RT.N3PTY_RCV_OFC_CD = RQST.N3PTY_OFC_CD AND RT.CHG_CD = 'OFT' AND RT.FRT_INCL_XCLD_DIV_CD='N' AND ROWNUM = 1),'P',ISS.ORG_N3PTY_PPD_CD,ISS.DEST_N3PTY_CLT_CD),'N') AS N3PTY_PAY_STS" ).append("\n"); 
		query.append("          ,TO_CHAR(NVL(RQST.N3PTY_BL_STS_RQST_DT,RQST.cre_Dt),'YYYY-MM-DD HH24:MI:SS') AS RQST_DT" ).append("\n"); 
		query.append("          ,TO_CHAR(RQST.N3PTY_BL_STS_UPD_DT,'YYYY-MM-DD HH24:MI:SS') as ACT_DT" ).append("\n"); 
		query.append("          ,RQST.N3PTY_BL_STS_RQST_USR_ID AS USR_ID" ).append("\n"); 
		query.append("          ,RQST.BL_RMK" ).append("\n"); 
		query.append("          ,DECODE((SELECT COUNT(*) " ).append("\n"); 
		query.append("             FROM BKG_N3RD_PTY_BL_FILE_STO STO" ).append("\n"); 
		query.append("            WHERE STO.BKG_NO = RQST.BKG_NO" ).append("\n"); 
		query.append("              AND STO.POL_CD = RQST.POL_CD" ).append("\n"); 
		query.append("              AND STO.N3PTY_OFC_CD = RQST.N3PTY_OFC_CD" ).append("\n"); 
		query.append("              AND STO.PAYR_CUST_CNT_CD = RQST.PAYR_CUST_CNT_CD" ).append("\n"); 
		query.append("              AND STO.PAYR_CUST_SEQ = RQST.PAYR_CUST_SEQ" ).append("\n"); 
		query.append("              AND STO.OBL_ISS_OFC_CD = RQST.OBL_ISS_OFC_CD" ).append("\n"); 
		query.append("              AND STO.N3PTY_BL_CHG_TTL_AMT = RQST.N3PTY_BL_CHG_TTL_AMT" ).append("\n"); 
		query.append("              AND STO.FRT_TERM_CD = RQST.FRT_TERM_CD" ).append("\n"); 
		query.append("           ),0,'N','Y') AS BL_ATCH" ).append("\n"); 
		query.append("          ,BKG.VSL_CD||BKG.SKD_VOY_NO||BKG.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("          ,TO_CHAR(VPS_ETD_DT, 'YYYY-MM-DD') ETD_DT" ).append("\n"); 
		query.append("          ,CASE WHEN (SELECT USR_EML FROM COM_USER WHERE USR_ID = RQST.CRE_USR_ID AND USE_FLG = 'Y') = (SELECT USR_EML FROM COM_USER WHERE USR_ID = BKG.DOC_USR_ID  AND USE_FLG = 'Y') THEN (SELECT USR_EML FROM COM_USER WHERE USR_ID = RQST.CRE_USR_ID AND USE_FLG = 'Y')" ).append("\n"); 
		query.append("                ELSE (SELECT USR_EML FROM COM_USER WHERE USR_ID = RQST.CRE_USR_ID AND USE_FLG = 'Y')||';'||(SELECT USR_EML FROM COM_USER WHERE USR_ID = BKG.DOC_USR_ID  AND USE_FLG = 'Y')" ).append("\n"); 
		query.append("                END AS USR_EML" ).append("\n"); 
		query.append("          ,RQST.N3PTY_BL_STS_CD AS OLD_N3PTY_BL_STS_CD" ).append("\n"); 
		query.append("          ,BKG.OB_SLS_OFC_CD AS POL_OFC_CD" ).append("\n"); 
		query.append("          ,BKG.BKG_OFC_CD" ).append("\n"); 
		query.append("          ,RQST.CRE_USR_ID AS BKG_USR_ID" ).append("\n"); 
		query.append("          ,RQST.FRT_TERM_CD" ).append("\n"); 
		query.append("          ,RQST.N3PTY_BL_CHG_TTL_AMT" ).append("\n"); 
		query.append("          ,RQST.OBL_ISS_OFC_CD AS BL_ISS_OFC_CD" ).append("\n"); 
		query.append("          ,CASE WHEN RQST.N3PTY_OFC_CD = OFC.OFC_N7TH_LVL_CD THEN 'Y'" ).append("\n"); 
		query.append("                WHEN RQST.N3PTY_OFC_CD = OFC.OFC_N6TH_LVL_CD THEN 'Y'" ).append("\n"); 
		query.append("                WHEN RQST.N3PTY_OFC_CD = OFC.OFC_N5TH_LVL_CD THEN 'Y'" ).append("\n"); 
		query.append("                WHEN RQST.N3PTY_OFC_CD = OFC.OFC_N4TH_LVL_CD THEN 'Y'" ).append("\n"); 
		query.append("                WHEN RQST.N3PTY_OFC_CD = OFC.OFC_N3RD_LVL_CD THEN 'Y'" ).append("\n"); 
		query.append("                WHEN RQST.N3PTY_OFC_CD = OFC.OFC_CD THEN 'Y'" ).append("\n"); 
		query.append("           ELSE 'N'" ).append("\n"); 
		query.append("           END AS accss_ofc_cd" ).append("\n"); 
		query.append("         ,ROW_NUMBER() OVER (PARTITION BY RQST.BKG_NO ORDER BY RQST.N3PTY_BL_STS_RQST_DT DESC) ROW_ID" ).append("\n"); 
		query.append("         ,BKG.POD_CD" ).append("\n"); 
		query.append("      from BKG_N3RD_PTY_BL_BIL_RQST RQST" ).append("\n"); 
		query.append("          ,BKG_BL_ISS ISS" ).append("\n"); 
		query.append("          ,BKG_BOOKING BKG" ).append("\n"); 
		query.append("         ,(SELECT VVD.BKG_NO,VSK.VPS_ETA_DT VPS_ETA_DT ,VSK.VPS_ETD_DT VPS_ETD_DT, VSK.SLAN_CD SLAN_CD, VSK.YD_CD YD_CD,VSK.SKD_DIR_CD SKD_DIR_CD  " ).append("\n"); 
		query.append("             FROM BKG_VVD VVD, VSK_VSL_PORT_SKD VSK" ).append("\n"); 
		query.append("           WHERE 1=1" ).append("\n"); 
		query.append("             AND VVD.VSL_CD = VSK.VSL_CD" ).append("\n"); 
		query.append("             AND VVD.SKD_VOY_NO = VSK.SKD_VOY_NO" ).append("\n"); 
		query.append("             AND VVD.SKD_DIR_CD = VSK.SKD_DIR_CD" ).append("\n"); 
		query.append("             AND VVD.POL_CD = VSK.VPS_PORT_CD" ).append("\n"); 
		query.append("             AND VVD.POL_CLPT_IND_SEQ = VSK.CLPT_IND_SEQ" ).append("\n"); 
		query.append("             AND VVD.VSL_PRE_PST_CD||VVD.VSL_SEQ = ( SELECT MIN(VSL_PRE_PST_CD||VSL_SEQ) FROM BKG_VVD VVD2 WHERE VVD2.BKG_NO = VVD.BKG_NO)) VVD  " ).append("\n"); 
		query.append("          ,(SELECT OFC_N7TH_LVL_CD,OFC_N6TH_LVL_CD,OFC_N5TH_LVL_CD,OFC_N4TH_LVL_CD,OFC_N3RD_LVL_CD,OFC_CD" ).append("\n"); 
		query.append("              FROM(" ).append("\n"); 
		query.append("                    SELECT OFC_N7TH_LVL_CD,OFC_N6TH_LVL_CD,OFC_N5TH_LVL_CD,OFC_N4TH_LVL_CD,OFC_N3RD_LVL_CD,OFC_CD " ).append("\n"); 
		query.append("                             FROM BKG_OFC_LVL_V" ).append("\n"); 
		query.append("                             WHERE OFC_CD = @[accss_ofc_cd]" ).append("\n"); 
		query.append("                            union all" ).append("\n"); 
		query.append("                            SELECT '' AS OFC_N7TH_LVL_CD" ).append("\n"); 
		query.append("                                  ,'' AS OFC_N6TH_LVL_CD" ).append("\n"); 
		query.append("                                  ,'' AS OFC_N5TH_LVL_CD" ).append("\n"); 
		query.append("                                  ,'' AS OFC_N4TH_LVL_CD" ).append("\n"); 
		query.append("                                  ,'' AS OFC_N3RD_LVL_CD" ).append("\n"); 
		query.append("                                  ,@[accss_ofc_cd] AS OFC_CD" ).append("\n"); 
		query.append("                              FROM DUAL" ).append("\n"); 
		query.append("                  )" ).append("\n"); 
		query.append("            WHERE ROWNUM = 1) OFC" ).append("\n"); 
		query.append("     WHERE BKG.BKG_NO = ISS.BKG_NO" ).append("\n"); 
		query.append("       AND BKG.BKG_NO = RQST.BKG_NO" ).append("\n"); 
		query.append("       AND BKG.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("    #if (${bkg_no} == '') " ).append("\n"); 
		query.append("    #if (${rqst_from_dt} != '') " ).append("\n"); 
		query.append("       AND RQST.CRE_DT >= TO_DATE(@[rqst_from_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${rqst_to_dt} != '') " ).append("\n"); 
		query.append("       AND RQST.CRE_DT < TO_DATE(@[rqst_to_dt], 'YYYY-MM-DD') + 1" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${n3pty_ofc_cd} != '') " ).append("\n"); 
		query.append("       AND RQST.N3PTY_OFC_CD = @[n3pty_ofc_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${pol_cd} != '') " ).append("\n"); 
		query.append("       AND RQST.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${pod_cd} != '') " ).append("\n"); 
		query.append("       AND BKG.POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${bkg_no} != '') " ).append("\n"); 
		query.append("       AND RQST.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${n3pty_bl_sts_cd} != 'All' && ${n3pty_bl_sts_cd} != '') " ).append("\n"); 
		query.append("       AND RQST.N3PTY_BL_STS_CD = @[n3pty_bl_sts_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${pol_ofc_cd} != '') " ).append("\n"); 
		query.append("       AND BKG.OB_SLS_OFC_CD = @[pol_ofc_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${sc_no} != '') " ).append("\n"); 
		query.append("       AND BKG.SC_NO = @[sc_no]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${rfa_no} != '') " ).append("\n"); 
		query.append("       AND BKG.RFA_NO = @[rfa_no]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${bl_iss_ofc_cd} != '') " ).append("\n"); 
		query.append("       AND ISS.OBL_ISS_OFC_CD = @[bl_iss_ofc_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${rqst_bl_tp_cd} != 'All' && ${rqst_bl_tp_cd} != '') " ).append("\n"); 
		query.append("        AND NVL(BKG.BL_TP_CD,DECODE(ISS.OBL_SRND_FLG,'Y','S',DECODE(ISS.OBL_RLSE_FLG,'Y','O',''))) = @[rqst_bl_tp_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${shpr_cd} != '')" ).append("\n"); 
		query.append("        AND RQST.PAYR_CUST_CNT_CD = @[payr_cust_cnt_cd]" ).append("\n"); 
		query.append("        AND RQST.PAYR_CUST_SEQ = @[payr_cust_seq]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${vvd} != '')" ).append("\n"); 
		query.append("        AND EXISTS (SELECT 'Y' FROM BKG_VVD WHERE BKG_NO = RQST.BKG_NO AND VSL_CD||SKD_VOY_NO||SKD_DIR_CD = @[vvd])" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${set_qry_where} != '') " ).append("\n"); 
		query.append("        ${set_qry_where} )" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${bkg_no} == '') " ).append("\n"); 
		query.append("  AND ROW_ID = 1" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY BKG_NO,RQST_DT" ).append("\n"); 

	}
}