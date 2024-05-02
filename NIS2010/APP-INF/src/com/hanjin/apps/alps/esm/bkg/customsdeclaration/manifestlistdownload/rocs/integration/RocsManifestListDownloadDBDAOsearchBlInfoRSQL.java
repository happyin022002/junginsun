/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : RocsManifestListDownloadDBDAOsearchBlInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.24
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.24 
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
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dif_chr",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.integration").append("\n"); 
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
		query.append("SELECT BL.BKG_NO, BL.BL_NO, BL.FAX_NO,BL.CUST_EML," ).append("\n"); 
		query.append("       REGEXP_SUBSTR(BL.SHPR_ADDR, '[^'||@[dif_chr]||']*') SHPR_ADDR1," ).append("\n"); 
		query.append("       SUBSTR(BL.SHPR_ADDR,REGEXP_INSTR(BL.SHPR_ADDR,'['||@[dif_chr]||']')+2) SHPR_ADDR2," ).append("\n"); 
		query.append("       REGEXP_SUBSTR(BL.CNEE_ADDR, '[^'||@[dif_chr]||']*') CNEE_ADDR1," ).append("\n"); 
		query.append("       SUBSTR(BL.CNEE_ADDR,REGEXP_INSTR(BL.CNEE_ADDR,'['||@[dif_chr]||']')+2) CNEE_ADDR2," ).append("\n"); 
		query.append("       REGEXP_SUBSTR(BL.NTFY_ADDR, '[^'||@[dif_chr]||']*') NTFY_ADDR1," ).append("\n"); 
		query.append("       SUBSTR(BL.NTFY_ADDR,REGEXP_INSTR(BL.NTFY_ADDR,'['||@[dif_chr]||']')+2) NTFY_ADDR2," ).append("\n"); 
		query.append("       VSL.VSL_CD, VSL.SKD_VOY_NO, VSL.SKD_DIR_CD, BL.FRT_TERM_CD, BL.T1_DOC_CD," ).append("\n"); 
		query.append("       VSL.VSL_CD||VSL.SKD_VOY_NO||VSL.SKD_DIR_CD vvd_number," ).append("\n"); 
		query.append("       BL.FRT_TERM_CD, BL.T1_DOC_CD," ).append("\n"); 
		query.append("	   BL.SHPR_CNT_CD, " ).append("\n"); 
		query.append("	   BL.SHPR_CUST_SEQ," ).append("\n"); 
		query.append("	   BL.CNEE_CNT_CD," ).append("\n"); 
		query.append("	   BL.CNEE_CUST_SEQ," ).append("\n"); 
		query.append("	   BL.NTFY_CNT_CD," ).append("\n"); 
		query.append("	   BL.NTFY_CUST_SEQ," ).append("\n"); 
		query.append("	   BL.SHPR_EORI_NO," ).append("\n"); 
		query.append("	   BL.SHPR_CTY_NM," ).append("\n"); 
		query.append("	   BL.SHPR_CSTMS_DECL_CNT_CD," ).append("\n"); 
		query.append(" 	   BL.SHPR_ZIP_ID," ).append("\n"); 
		query.append("	   BL.SHPR_ST_NM," ).append("\n"); 
		query.append("	   BL.CNEE_EORI_NO," ).append("\n"); 
		query.append("	   BL.CNEE_CTY_NM," ).append("\n"); 
		query.append("	   BL.CNEE_CSTMS_DECL_CNT_CD," ).append("\n"); 
		query.append(" 	   BL.CNEE_ZIP_ID," ).append("\n"); 
		query.append("	   BL.CNEE_ST_NM," ).append("\n"); 
		query.append("	   BL.NTFY_EORI_NO," ).append("\n"); 
		query.append("	   BL.NTFY_CTY_NM," ).append("\n"); 
		query.append("	   BL.NTFY_CSTMS_DECL_CNT_CD," ).append("\n"); 
		query.append(" 	   BL.NTFY_ZIP_ID," ).append("\n"); 
		query.append("	   BL.NTFY_ST_NM" ).append("\n"); 
		query.append("FROM	 BKG_CSTMS_RTM_BL BL, BKG_CSTMS_RTM_VSL VSL" ).append("\n"); 
		query.append("#if (${bl_no} == '' && ${frm_crn_number}!= '') 	" ).append("\n"); 
		query.append("              WHERE   BL.VSL_CALL_REF_NO       = @[frm_crn_number] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bl_no}!= '' && ${frm_crn_number} == '') 	" ).append("\n"); 
		query.append("              WHERE BL.BL_NO = SUBSTR(@[bl_no],0,12) " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bl_no}!= '' && ${frm_crn_number} != '') " ).append("\n"); 
		query.append("              WHERE BL.BL_NO = SUBSTR(@[bl_no],0,12) " ).append("\n"); 
		query.append("              AND   BL.VSL_CALL_REF_NO       = @[frm_crn_number]	 " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bl_tp_cd}!= '')" ).append("\n"); 
		query.append("              AND   BL_TP_CD = @[bl_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND BL.VSL_CD = VSL.VSL_CD" ).append("\n"); 
		query.append("AND BL.SKD_VOY_NO= VSL.SKD_VOY_NO" ).append("\n"); 
		query.append("AND BL.SKD_DIR_CD = VSL.SKD_DIR_CD" ).append("\n"); 
		query.append("AND	 BL.VSL_CALL_REF_NO = VSL.VSL_CALL_REF_NO" ).append("\n"); 

	}
}