/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : RocsManifestListDownloadDBDAOsearchBlListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.10
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.10 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RocsManifestListDownloadDBDAOsearchBlListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ROCS(ROTTERDAM) 세관에 신고할 대상 BL 별 정보를 조회한다.
	  * </pre>
	  */
	public RocsManifestListDownloadDBDAOsearchBlListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_crn_number",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mt_flag",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.integration").append("\n"); 
		query.append("FileName : RocsManifestListDownloadDBDAOsearchBlListRSQL").append("\n"); 
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
		query.append("SELECT  DECODE(CSTMS_DAT_CFM_CD,'Y',DECODE(RTM_RE_MSG_STS_CD,null,'9','R','9','5'),'') kind," ).append("\n"); 
		query.append("		TRIM(BL_NO||BL_TP_CD) bl_no," ).append("\n"); 
		query.append("		TRIM(BL_NO||BL_TP_CD) bl_no2, " ).append("\n"); 
		query.append("		cntr.CNTR_NO, " ).append("\n"); 
		query.append("		bl.BKG_CGO_TP_CD," ).append("\n"); 
		query.append("		POR_CD, " ).append("\n"); 
		query.append("		POL_CD, " ).append("\n"); 
		query.append("		POD_CD, " ).append("\n"); 
		query.append("		DEL_CD, " ).append("\n"); 
		query.append("		PRE_RLY_PORT_CD, " ).append("\n"); 
		query.append("		PST_RLY_PORT_CD," ).append("\n"); 
		query.append("		cntr.PCK_QTY, cntr.PCK_TP_CD, " ).append("\n"); 
		query.append("		ROUND(cntr.CNTR_MF_WGT) CNTR_MF_WGT, " ).append("\n"); 
		query.append("		cntr.CNTR_WGT_UT_CD," ).append("\n"); 
		query.append("		NVL(T1_DOC_CD,'') T1_DOC_CD, " ).append("\n"); 
		query.append("		DECODE(BDR_FLG,'1','Y','2','N',BDR_FLG) BDR_FLG," ).append("\n"); 
		query.append("		SUBSTR(REPLACE(TRANSLATE(CNTR_MF_DESC,CHR(13)||CHR(10),' '),CHR(9),' '),1,45) CNTR_MF_DESC," ).append("\n"); 
		query.append("		SUBSTR(REPLACE(REPLACE(TRANSLATE(NTFY_ADDR,CHR(13)||CHR(10),' '),CHR(9),' '),'@',' '),1,35) NTFY_ADDR," ).append("\n"); 
		query.append("		RTM_SND_STS_CD, " ).append("\n"); 
		query.append("		SND_USR_ID, " ).append("\n"); 
		query.append("		TO_CHAR(MF_SND_DT,'yyyy-mm-dd') MF_SND_DT," ).append("\n"); 
		query.append("		RTM_RE_MSG_STS_CD, " ).append("\n"); 
		query.append("		TO_CHAR(RE_MSG_DT,'yyyy-mm-dd') RE_MSG_DT," ).append("\n"); 
		query.append("		CSTMS_DAT_CFM_CD DAT_CFM_FLG,	" ).append("\n"); 
		query.append("		CSTMS_DECL_USR_ID,	" ).append("\n"); 
		query.append("		TO_CHAR(BL_DAT_CFM_DT,'yyyy-mm-dd') BL_DAT_CFM_DT," ).append("\n"); 
		query.append("		bl.BKG_NO,	" ).append("\n"); 
		query.append("		NVL(bl.T1_DOC_CD,'') T1_DOC_CD," ).append("\n"); 
		query.append("		BL.VSL_CALL_REF_NO frm_crn_number," ).append("\n"); 
		query.append("		BL_TP_CD," ).append("\n"); 
		query.append("        DECODE(CSTMS_DAT_CFM_CD,'Y',DECODE(RTM_RE_MSG_STS_CD,null,'9','R','9','5'),'') BIGO_KIND" ).append("\n"); 
		query.append("FROM	BKG_CSTMS_RTM_BL BL," ).append("\n"); 
		query.append("		 (SELECT cntr.CNTR_NO, cntr.PCK_QTY, cntr.PCK_TP_CD, cntr.CNTR_MF_WGT," ).append("\n"); 
		query.append("			cntr.CNTR_WGT_UT_CD, cntr.VSL_CALL_REF_NO, cntr.BKG_NO, " ).append("\n"); 
		query.append("			(SELECT CNTR_MF_DESC " ).append("\n"); 
		query.append("			 FROM BKG_CSTMS_RTM_CGO_MF cmd" ).append("\n"); 
		query.append("			 WHERE cntr.VSL_CALL_REF_NO = cmd.VSL_CALL_REF_NO(+)" ).append("\n"); 
		query.append("		  	 AND   cntr.BKG_NO = cmd.BKG_NO(+)" ).append("\n"); 
		query.append("		  	 AND   cntr.CNTR_NO = cmd.CNTR_NO(+)" ).append("\n"); 
		query.append("			 AND   ROWNUM =1) AS CNTR_MF_DESC" ).append("\n"); 
		query.append("		  FROM   BKG_CSTMS_RTM_CNTR cntr" ).append("\n"); 
		query.append("		  WHERE  cntr.VSL_CALL_REF_NO = @[frm_crn_number]" ).append("\n"); 
		query.append("		  ) cntr" ).append("\n"); 
		query.append("WHERE BL.VSL_CALL_REF_NO = @[frm_crn_number]" ).append("\n"); 
		query.append("  AND NVL(BL.VSL_CD, @[vsl_cd]) = @[vsl_cd]" ).append("\n"); 
		query.append("  AND NVL(BL.SKD_VOY_NO, @[skd_voy_no]) = @[skd_voy_no]" ).append("\n"); 
		query.append("  AND NVL(BL.SKD_DIR_CD, @[skd_dir_cd]) = @[skd_dir_cd]" ).append("\n"); 
		query.append("  AND BL.VSL_CALL_REF_NO = cntr.VSL_CALL_REF_NO(+)" ).append("\n"); 
		query.append("  AND BL.BKG_NO = cntr.BKG_NO(+)" ).append("\n"); 
		query.append("#if (${pol_cd}!= '') " ).append("\n"); 
		query.append("  AND (POL_CD = @[pol_cd] OR PRE_RLY_PORT_CD = @[pol_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${mt_flag}!= 'P') " ).append("\n"); 
		query.append("  AND bl.BKG_CGO_TP_CD <> 'P'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("  AND bl.BKG_CGO_TP_CD = @[mt_flag]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY BL.BL_NO" ).append("\n"); 

	}
}