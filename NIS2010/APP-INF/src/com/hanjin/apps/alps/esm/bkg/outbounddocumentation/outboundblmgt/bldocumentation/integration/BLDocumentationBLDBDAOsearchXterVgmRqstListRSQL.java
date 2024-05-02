/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BLDocumentationBLDBDAOsearchXterVgmRqstListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.15
*@LastModifier : 문동선
*@LastVersion : 1.0
* 2016.07.15 문동선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dongsun Moon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationBLDBDAOsearchXterVgmRqstListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * XterVgm 조회
	  * </pre>
	  */
	public BLDocumentationBLDBDAOsearchXterVgmRqstListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vgm_upld_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationBLDBDAOsearchXterVgmRqstListRSQL").append("\n"); 
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
		query.append("SELECT RQST.XTER_SNDR_ID" ).append("\n"); 
		query.append("     , RQST.XTER_VGM_RQST_NO" ).append("\n"); 
		query.append("     , RQST.XTER_VGM_SEQ" ).append("\n"); 
		query.append("     , RQST.BKG_NO" ).append("\n"); 
		query.append("     , RQST.CNTR_NO" ).append("\n"); 
		query.append("     , TO_CHAR(RQST.RQST_DT,'YYYY-MM-DD HH24:MI') RQST_DT" ).append("\n"); 
		query.append("     , RQST.XTER_RQST_VIA_CD" ).append("\n"); 
		query.append("     , RQST.CUST_ID" ).append("\n"); 
		query.append("     , RQST.VGM_UPLD_STS_CD" ).append("\n"); 
		query.append("     , RQST.UPLD_USR_ID" ).append("\n"); 
		query.append("     , TO_CHAR(RQST.UPLD_DT,'YYYY-MM-DD HH24:MI')  UPLD_DT" ).append("\n"); 
		query.append("     , TO_CHAR(RQST.UPLD_GDT,'YYYY-MM-DD HH24:MI') UPLD_GDT" ).append("\n"); 
		query.append("     , RQST.VGM_WGT" ).append("\n"); 
		query.append("     , RQST.VGM_WGT_UT_CD" ).append("\n"); 
		query.append("     , TO_CHAR(RQST.VGM_VRFY_DT,'YYYY-MM-DD HH24:MI') VGM_VRFY_DT" ).append("\n"); 
		query.append("     , TO_CHAR(RQST.VGM_DTMN_DT,'YYYY-MM-DD HH24:MI') VGM_DTMN_DT" ).append("\n"); 
		query.append("     , RQST.VGM_MZD_TP_CD" ).append("\n"); 
		query.append("     , RQST.SMT_NM" ).append("\n"); 
		query.append("     , RQST.SMT_EML" ).append("\n"); 
		query.append("     , RQST.SMT_PHN_NO" ).append("\n"); 
		query.append("     , (NVL((SELECT AUTH_PSON_NM " ).append("\n"); 
		query.append("               FROM BKG_XTER_VRFD_WGT_PTY PTY " ).append("\n"); 
		query.append("              WHERE PTY.XTER_SNDR_ID     = RQST.XTER_SNDR_ID" ).append("\n"); 
		query.append("                AND PTY.XTER_VGM_RQST_NO = RQST.XTER_VGM_RQST_NO " ).append("\n"); 
		query.append("                AND PTY.XTER_VGM_SEQ     = RQST.XTER_VGM_SEQ" ).append("\n"); 
		query.append("                AND PTY.CNTR_NO          = RQST.CNTR_NO" ).append("\n"); 
		query.append("                AND PTY.VGM_PTY_TP_CD    = 'SPC'" ).append("\n"); 
		query.append("             ),NVL((SELECT AUTH_PSON_NM " ).append("\n"); 
		query.append("                      FROM BKG_XTER_VRFD_WGT_PTY PTY " ).append("\n"); 
		query.append("                     WHERE PTY.XTER_SNDR_ID     = RQST.XTER_SNDR_ID" ).append("\n"); 
		query.append("                       AND PTY.XTER_VGM_RQST_NO = RQST.XTER_VGM_RQST_NO " ).append("\n"); 
		query.append("                       AND PTY.XTER_VGM_SEQ     = RQST.XTER_VGM_SEQ" ).append("\n"); 
		query.append("                       AND PTY.CNTR_NO          = RQST.CNTR_NO" ).append("\n"); 
		query.append("                       AND PTY.VGM_PTY_TP_CD    = 'WPA'" ).append("\n"); 
		query.append("             ),NVL((SELECT AUTH_PSON_NM " ).append("\n"); 
		query.append("                      FROM BKG_XTER_VRFD_WGT_PTY PTY " ).append("\n"); 
		query.append("                     WHERE PTY.XTER_SNDR_ID     = RQST.XTER_SNDR_ID" ).append("\n"); 
		query.append("                       AND PTY.XTER_VGM_RQST_NO = RQST.XTER_VGM_RQST_NO " ).append("\n"); 
		query.append("                       AND PTY.XTER_VGM_SEQ     = RQST.XTER_VGM_SEQ" ).append("\n"); 
		query.append("                       AND PTY.CNTR_NO          = RQST.CNTR_NO" ).append("\n"); 
		query.append("                       AND PTY.VGM_PTY_TP_CD    = 'AM'" ).append("\n"); 
		query.append("             ),NVL((SELECT AUTH_PSON_NM " ).append("\n"); 
		query.append("                      FROM BKG_XTER_VRFD_WGT_PTY PTY " ).append("\n"); 
		query.append("                     WHERE PTY.XTER_SNDR_ID     = RQST.XTER_SNDR_ID" ).append("\n"); 
		query.append("                       AND PTY.XTER_VGM_RQST_NO = RQST.XTER_VGM_RQST_NO " ).append("\n"); 
		query.append("                       AND PTY.XTER_VGM_SEQ     = RQST.XTER_VGM_SEQ" ).append("\n"); 
		query.append("                       AND PTY.CNTR_NO          = RQST.CNTR_NO" ).append("\n"); 
		query.append("                       AND PTY.VGM_PTY_TP_CD    = 'WC'" ).append("\n"); 
		query.append("             ),(SELECT AUTH_PSON_NM " ).append("\n"); 
		query.append("                  FROM BKG_XTER_VRFD_WGT_PTY PTY " ).append("\n"); 
		query.append("                 WHERE PTY.XTER_SNDR_ID     = RQST.XTER_SNDR_ID" ).append("\n"); 
		query.append("                   AND PTY.XTER_VGM_RQST_NO = RQST.XTER_VGM_RQST_NO " ).append("\n"); 
		query.append("                   AND PTY.XTER_VGM_SEQ     = RQST.XTER_VGM_SEQ" ).append("\n"); 
		query.append("                   AND PTY.CNTR_NO          = RQST.CNTR_NO" ).append("\n"); 
		query.append("                   AND PTY.VGM_PTY_TP_CD    = 'OB'" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("             ))))" ).append("\n"); 
		query.append("       )VGM_VRFY_SIG_CTNT -- SPC,WPA,AM,WC,OB 순으로 하나만 SIGNATURE로 함" ).append("\n"); 
		query.append("     , RQST.XTER_BKG_RQST_REF_NO" ).append("\n"); 
		query.append("     , RQST.XTER_SI_REF_NO" ).append("\n"); 
		query.append("     , RQST.RJCT_RSN_RMK" ).append("\n"); 
		query.append("     , RQST.UPD_USR_ID" ).append("\n"); 
		query.append("     , TO_CHAR(RQST.UPD_DT,'YYYY-MM-DD HH24:MI') UPD_DT" ).append("\n"); 
		query.append("  FROM BKG_XTER_VRFD_WGT_RQST RQST" ).append("\n"); 
		query.append("     , BKG_BOOKING            BK" ).append("\n"); 
		query.append("#if (${bkg_no} == '' && ${f_vvd} != '')" ).append("\n"); 
		query.append("     , BKG_VVD                VVD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" WHERE RQST.BKG_NO = BK.BKG_NO(+)" ).append("\n"); 
		query.append("#if (${bkg_no} != '')" ).append("\n"); 
		query.append("   --booking no 입력시 (다른 조건 전부 비활성화)" ).append("\n"); 
		query.append("   AND RQST.BKG_NO IN ( ${bkg_no} )" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("    #if (${f_vvd} != '')" ).append("\n"); 
		query.append("   AND VVD.BKG_NO     = BK.BKG_NO" ).append("\n"); 
		query.append("   AND VVD.VSL_CD     = SUBSTR(@[f_vvd], 1, 4)" ).append("\n"); 
		query.append("   AND VVD.SKD_VOY_NO = SUBSTR(@[f_vvd], 5, 4)" ).append("\n"); 
		query.append("   AND VVD.SKD_DIR_CD = SUBSTR(@[f_vvd], 9, 1)" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("	#if (${cntr_no} != '')" ).append("\n"); 
		query.append("   AND RQST.CNTR_NO IN ( ${cntr_no} )" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${rqst_from_dt} != '')" ).append("\n"); 
		query.append("   AND RQST.RQST_DT >= TO_DATE(@[rqst_from_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${rqst_to_dt} != '')" ).append("\n"); 
		query.append("   AND RQST.RQST_DT <= TO_DATE(@[rqst_to_dt],'YYYY-MM-DD')+1" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${vgm_upld_sts_cd} != '')" ).append("\n"); 
		query.append("   AND RQST.VGM_UPLD_STS_CD = @[vgm_upld_sts_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${pol_cd} != '')" ).append("\n"); 
		query.append("   AND BK.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${bkg_ofc_cd} != '')" ).append("\n"); 
		query.append("   AND BK.BKG_OFC_CD = @[bkg_ofc_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" ORDER BY RQST.RQST_DT, RQST.BKG_NO, RQST.XTER_VGM_SEQ,  RQST.CNTR_NO" ).append("\n"); 

	}
}