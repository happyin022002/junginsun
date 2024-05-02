/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : PaperlessDBDAOSearchPaperlessListALPSBRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.16
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.16 
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.paperless.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PaperlessDBDAOSearchPaperlessListALPSBRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PaperlessDBDAOSearchPaperlessListALPSBRSQL
	  * </pre>
	  */
	public PaperlessDBDAOSearchPaperlessListALPSBRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fr_cre_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pprl_eml_rcv_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("snd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("to_cre_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sndr_eml",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("t_vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("shpr",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.bizcommon.paperless.integration").append("\n"); 
		query.append("FileName : PaperlessDBDAOSearchPaperlessListALPSBRSQL").append("\n"); 
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
		query.append("    ARC_TYPE," ).append("\n"); 
		query.append("    BKG_NO," ).append("\n"); 
		query.append("    BL_NO," ).append("\n"); 
		query.append("    SLAN_CD," ).append("\n"); 
		query.append("    T_VVD," ).append("\n"); 
		query.append("    POL_CD," ).append("\n"); 
		query.append("    POD_CD," ).append("\n"); 
		query.append("    OFC_CD," ).append("\n"); 
		query.append("    SHPR," ).append("\n"); 
		query.append("    SND_USR_ID," ).append("\n"); 
		query.append("    SNDR_EML," ).append("\n"); 
		query.append("    PPRL_EML_CTNT," ).append("\n"); 
		query.append("    EML_TIT_NM," ).append("\n"); 
		query.append("    USE_FLG," ).append("\n"); 
		query.append("    FILE_UPLD_NM," ).append("\n"); 
		query.append("    ATCH_FILE_PATH_CTNT," ).append("\n"); 
		query.append("	ORG_FILE_NM," ).append("\n"); 
		query.append("    TO_CHAR(CRE_DT,'YYYY-MM-DD HH24:MI:SS') AS CRE_DT," ).append("\n"); 
		query.append("	PPRL_EML_RCV_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT '' ARC_TYPE," ).append("\n"); 
		query.append("      B.BKG_NO," ).append("\n"); 
		query.append("      B.BL_NO||B.BL_NO_TP BL_NO," ).append("\n"); 
		query.append("      B.SLAN_CD," ).append("\n"); 
		query.append("      B.VSL_CD||B.SKD_VOY_NO||B.SKD_DIR_CD T_VVD," ).append("\n"); 
		query.append("      B.POL_CD," ).append("\n"); 
		query.append("      B.POD_CD," ).append("\n"); 
		query.append("      (" ).append("\n"); 
		query.append("        SELECT OFC_CD" ).append("\n"); 
		query.append("        FROM COM_USER U" ).append("\n"); 
		query.append("        WHERE USR_EML = EML.SNDR_EML AND ROWNUM = 1) OFC_CD," ).append("\n"); 
		query.append("      S.CUST_CNT_CD||LPAD(CUST_SEQ, 6, 0) SHPR," ).append("\n"); 
		query.append("      (" ).append("\n"); 
		query.append("		SELECT USR_ID" ).append("\n"); 
		query.append("		FROM COM_USER U" ).append("\n"); 
		query.append("		WHERE USR_EML = EML.SNDR_EML AND ROWNUM = 1) SND_USR_ID," ).append("\n"); 
		query.append("      EML.SNDR_EML," ).append("\n"); 
		query.append("      EML.PPRL_EML_CTNT," ).append("\n"); 
		query.append("      EML.EML_TIT_NM," ).append("\n"); 
		query.append("      '' USE_FLG," ).append("\n"); 
		query.append("      EML.FILE_UPLD_NM," ).append("\n"); 
		query.append("      EML.FILE_PATH_NM||EML.ORG_FILE_NM ATCH_FILE_PATH_CTNT," ).append("\n"); 
		query.append("		EML.ORG_FILE_NM," ).append("\n"); 
		query.append("      EML.CRE_DT," ).append("\n"); 
		query.append("		EML.PPRL_EML_RCV_CD" ).append("\n"); 
		query.append("    FROM BIS_BOOKING B," ).append("\n"); 
		query.append("      BIS_CUSTOMER S," ).append("\n"); 
		query.append("      (" ).append("\n"); 
		query.append("       SELECT A.BKG_NO" ).append("\n"); 
		query.append("          ,A.BL_NO" ).append("\n"); 
		query.append("          ,A.PPRL_EML_RCV_CD" ).append("\n"); 
		query.append("          ,A.EML_TIT_NM" ).append("\n"); 
		query.append("          ,A.PPRL_EML_CTNT" ).append("\n"); 
		query.append("          ,A.SNDR_EML" ).append("\n"); 
		query.append("          ,A.SND_USR_ID" ).append("\n"); 
		query.append("          ,A.FILE_PATH_NM" ).append("\n"); 
		query.append("          ,A.ORG_FILE_NM" ).append("\n"); 
		query.append("          ,B.FILE_UPLD_NM" ).append("\n"); 
		query.append("          ,A.CRE_DT" ).append("\n"); 
		query.append("      FROM  COM_PPRL_EML_SAV_RSLT A , COM_UPLD_FILE B" ).append("\n"); 
		query.append("      WHERE A.ORG_FILE_NM = B.FILE_SAV_ID" ).append("\n"); 
		query.append("      AND   B.PGM_SUB_SYS_CD = 'PPR'" ).append("\n"); 
		query.append("      AND   A.PPRL_EML_RCV_CD ='NOR') EML" ).append("\n"); 
		query.append("    WHERE EML.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("      AND B.BKG_NO = S.BKG_NO" ).append("\n"); 
		query.append("      AND S.BKG_CUST_TP_CD = 'S' " ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT '' ARC_TYPE," ).append("\n"); 
		query.append("      B.BKG_NO," ).append("\n"); 
		query.append("      B.BL_NO||B.BL_NO_TP BL_NO," ).append("\n"); 
		query.append("      B.SLAN_CD," ).append("\n"); 
		query.append("      B.VSL_CD||B.SKD_VOY_NO||B.SKD_DIR_CD T_VVD," ).append("\n"); 
		query.append("      B.POL_CD," ).append("\n"); 
		query.append("      B.POD_CD," ).append("\n"); 
		query.append("      (" ).append("\n"); 
		query.append("        SELECT OFC_CD" ).append("\n"); 
		query.append("        FROM COM_USER U" ).append("\n"); 
		query.append("        WHERE USR_EML = EML.SNDR_EML AND ROWNUM = 1) OFC_CD," ).append("\n"); 
		query.append("      S.CUST_CNT_CD||LPAD(CUST_SEQ, 6, 0) SHPR," ).append("\n"); 
		query.append("      EML.SND_USR_ID," ).append("\n"); 
		query.append("      EML.SNDR_EML," ).append("\n"); 
		query.append("      EML.PPRL_EML_CTNT," ).append("\n"); 
		query.append("      EML.EML_TIT_NM," ).append("\n"); 
		query.append("      '' USE_FLG," ).append("\n"); 
		query.append("      EML.ORG_FILE_NM AS FILE_UPLD_NM," ).append("\n"); 
		query.append("      EML.FILE_PATH_NM||EML.ORG_FILE_NM ATCH_FILE_PATH_CTNT," ).append("\n"); 
		query.append("		EML.ORG_FILE_NM," ).append("\n"); 
		query.append("      EML.CRE_DT," ).append("\n"); 
		query.append("		EML.PPRL_EML_RCV_CD" ).append("\n"); 
		query.append("    FROM BIS_BOOKING B," ).append("\n"); 
		query.append("      BIS_CUSTOMER S," ).append("\n"); 
		query.append("      (" ).append("\n"); 
		query.append("       SELECT A.BKG_NO" ).append("\n"); 
		query.append("          ,A.BL_NO" ).append("\n"); 
		query.append("          ,A.PPRL_EML_RCV_CD" ).append("\n"); 
		query.append("          ,A.EML_TIT_NM" ).append("\n"); 
		query.append("          ,A.PPRL_EML_CTNT" ).append("\n"); 
		query.append("          ,A.SNDR_EML" ).append("\n"); 
		query.append("          ,A.SND_USR_ID" ).append("\n"); 
		query.append("          ,A.FILE_PATH_NM" ).append("\n"); 
		query.append("          ,A.ORG_FILE_NM" ).append("\n"); 
		query.append("          ,A.CRE_DT" ).append("\n"); 
		query.append("      FROM  COM_PPRL_EML_SAV_RSLT A " ).append("\n"); 
		query.append("      WHERE   A.PPRL_EML_RCV_CD IN ('DPC', 'NPC')) EML" ).append("\n"); 
		query.append("    WHERE EML.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("      AND B.BKG_NO = S.BKG_NO" ).append("\n"); 
		query.append("      AND S.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("    #if (${bkg_no} != '') " ).append("\n"); 
		query.append("        AND BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${t_vvd} != '') " ).append("\n"); 
		query.append("        AND T_VVD = @[t_vvd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${slan_cd} != '') " ).append("\n"); 
		query.append("        AND SLAN_CD = @[slan_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${pol_cd} != '') " ).append("\n"); 
		query.append("        AND POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${pod_cd} != '') " ).append("\n"); 
		query.append("        AND POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${fr_cre_dt} != '') " ).append("\n"); 
		query.append("        AND (TO_CHAR(CRE_DT, 'YYYYMMDD') BETWEEN REPLACE(@[fr_cre_dt],'-','') AND REPLACE(@[to_cre_dt],'-',''))" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${ofc_cd} != '') " ).append("\n"); 
		query.append("        AND OFC_CD = @[ofc_cd]   " ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${shpr} != '') " ).append("\n"); 
		query.append("        AND SHPR = @[shpr]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${snd_usr_id} != '') " ).append("\n"); 
		query.append("        AND SND_USR_ID = @[snd_usr_id]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${sndr_eml} != '') " ).append("\n"); 
		query.append("        AND SNDR_EML = @[sndr_eml]   " ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${pprl_eml_rcv_cd} != '') " ).append("\n"); 
		query.append("        AND PPRL_EML_RCV_CD = @[pprl_eml_rcv_cd]   " ).append("\n"); 
		query.append("    #end" ).append("\n"); 

	}
}