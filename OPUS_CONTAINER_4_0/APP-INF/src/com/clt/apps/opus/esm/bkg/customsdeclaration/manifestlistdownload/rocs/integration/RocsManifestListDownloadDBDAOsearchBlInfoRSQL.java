/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RocsManifestListDownloadDBDAOsearchBlInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.25
*@LastModifier : 이종길
*@LastVersion : 1.0
* 2016.04.25 이종길
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong-Kil LEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RocsManifestListDownloadDBDAOsearchBlInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ROCS(ROTTERDAM) 세관 신고용 B/L 일반 정보를 조회한다.
	  * </pre>
	  */
	public RocsManifestListDownloadDBDAOsearchBlInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bl_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dif_chr",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.integration").append("\n"); 
		query.append("FileName : RocsManifestListDownloadDBDAOsearchBlInfoRSQL").append("\n"); 
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
		query.append("SELECT BKG_NO, BL_NO, FAX_NO,CUST_EML," ).append("\n"); 
		query.append("       REGEXP_SUBSTR(SHPR_ADDR, '[^'||@[dif_chr]||']*') SHPR_ADDR1," ).append("\n"); 
		query.append("       SUBSTR(SHPR_ADDR,REGEXP_INSTR(SHPR_ADDR,'['||@[dif_chr]||']')+2) SHPR_ADDR2," ).append("\n"); 
		query.append("       REGEXP_SUBSTR(CNEE_ADDR, '[^'||@[dif_chr]||']*') CNEE_ADDR1," ).append("\n"); 
		query.append("       SUBSTR(CNEE_ADDR,REGEXP_INSTR(CNEE_ADDR,'['||@[dif_chr]||']')+2) CNEE_ADDR2," ).append("\n"); 
		query.append("       REGEXP_SUBSTR(NTFY_ADDR, '[^'||@[dif_chr]||']*') NTFY_ADDR1," ).append("\n"); 
		query.append("       SUBSTR(NTFY_ADDR,REGEXP_INSTR(NTFY_ADDR,'['||@[dif_chr]||']')+2) NTFY_ADDR2," ).append("\n"); 
		query.append("       VSL.VSL_CD, VSL.SKD_VOY_NO, VSL.SKD_DIR_CD, FRT_TERM_CD, T1_DOC_CD," ).append("\n"); 
		query.append("       VSL.VSL_CD||VSL.SKD_VOY_NO||VSL.SKD_DIR_CD vvd_number," ).append("\n"); 
		query.append("       FRT_TERM_CD, T1_DOC_CD," ).append("\n"); 
		query.append("	   SHPR_CNT_CD, " ).append("\n"); 
		query.append("	   SHPR_CUST_SEQ," ).append("\n"); 
		query.append("	   CNEE_CNT_CD," ).append("\n"); 
		query.append("	   CNEE_CUST_SEQ," ).append("\n"); 
		query.append("	   NTFY_CNT_CD," ).append("\n"); 
		query.append("	   NTFY_CUST_SEQ," ).append("\n"); 
		query.append("	   SHPR_EORI_NO," ).append("\n"); 
		query.append("	   SHPR_CTY_NM," ).append("\n"); 
		query.append("	   SHPR_CSTMS_DECL_CNT_CD," ).append("\n"); 
		query.append(" 	   SHPR_ZIP_ID," ).append("\n"); 
		query.append("	   SHPR_ST_NM," ).append("\n"); 
		query.append("	   CNEE_EORI_NO," ).append("\n"); 
		query.append("	   CNEE_CTY_NM," ).append("\n"); 
		query.append("	   CNEE_CSTMS_DECL_CNT_CD," ).append("\n"); 
		query.append(" 	   CNEE_ZIP_ID," ).append("\n"); 
		query.append("	   CNEE_ST_NM," ).append("\n"); 
		query.append("	   NTFY_EORI_NO," ).append("\n"); 
		query.append("	   NTFY_CTY_NM," ).append("\n"); 
		query.append("	   NTFY_CSTMS_DECL_CNT_CD," ).append("\n"); 
		query.append(" 	   NTFY_ZIP_ID," ).append("\n"); 
		query.append("	   NTFY_ST_NM" ).append("\n"); 
		query.append("FROM	 BKG_CSTMS_RTM_BL BL, BKG_CSTMS_RTM_VSL VSL" ).append("\n"); 
		query.append("#if (${bl_no} == '' && ${frm_crn_number}!= '') 	" ).append("\n"); 
		query.append("              WHERE   BL.VSL_CALL_REF_NO       = @[frm_crn_number] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bl_no}!= '' && ${frm_crn_number} == '') 	" ).append("\n"); 
		query.append("              WHERE BL_NO = SUBSTR(@[bl_no],0,12) " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bl_no}!= '' && ${frm_crn_number} != '') " ).append("\n"); 
		query.append("              WHERE BL_NO = SUBSTR(@[bl_no],0,12) " ).append("\n"); 
		query.append("              AND   BL.VSL_CALL_REF_NO       = @[frm_crn_number] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bl_tp_cd}!= '')" ).append("\n"); 
		query.append("              AND   BL_TP_CD = @[bl_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" 			  AND   BL.VSL_CD = VSL.VSL_CD" ).append("\n"); 
		query.append("              AND   BL.SKD_VOY_NO = VSL.SKD_VOY_NO" ).append("\n"); 
		query.append("              AND   BL.SKD_DIR_CD = VSL.SKD_DIR_CD" ).append("\n"); 
		query.append("AND	 BL.VSL_CALL_REF_NO = VSL.VSL_CALL_REF_NO" ).append("\n"); 

	}
}