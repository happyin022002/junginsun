/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BLDocumentationBLDBDAOCreateBlDocCACSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.24
*@LastModifier : 
*@LastVersion : 1.0
* 2015.09.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationBLDBDAOCreateBlDocCACSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BLDocumentationBLDBDAOCreateBlDocCACSQL
	  * </pre>
	  */
	public BLDocumentationBLDBDAOCreateBlDocCACSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ca_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationBLDBDAOCreateBlDocCACSQL").append("\n"); 
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
		query.append("#if (${copy_type_cd} == 'BKG')" ).append("\n"); 
		query.append("INSERT INTO BKG_BL_DOC (" ).append("\n"); 
		query.append("    BKG_NO " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("INSERT INTO BKG_BL_DOC_HIS (" ).append("\n"); 
		query.append("    BKG_NO " ).append("\n"); 
		query.append("    , CORR_NO " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    , PCK_QTY " ).append("\n"); 
		query.append("    , PCK_TP_CD " ).append("\n"); 
		query.append("    , MEAS_QTY " ).append("\n"); 
		query.append("    , MEAS_UT_CD " ).append("\n"); 
		query.append("    , ACT_WGT " ).append("\n"); 
		query.append("    , WGT_UT_CD " ).append("\n"); 
		query.append("    , ACT_WGT_PRN_FLG " ).append("\n"); 
		query.append("    , HBL_TTL_KNT " ).append("\n"); 
		query.append("    , SPCL_CGO_AUTH_KNT " ).append("\n"); 
		query.append("    , BL_OBRD_TP_CD " ).append("\n"); 
		query.append("    , BL_OBRD_DT " ).append("\n"); 
		query.append("    , AUD_ERR_CTNT " ).append("\n"); 
		query.append("    , IB_MF_CFM_FLG " ).append("\n"); 
		query.append("    , BIS_SYS_FLG " ).append("\n"); 
		query.append("    , ORG_CNT_NM " ).append("\n"); 
		query.append("    , POR_CD " ).append("\n"); 
		query.append("    , POR_NM " ).append("\n"); 
		query.append("    , POL_CD " ).append("\n"); 
		query.append("    , POL_NM " ).append("\n"); 
		query.append("    , POD_CD " ).append("\n"); 
		query.append("    , POD_NM " ).append("\n"); 
		query.append("    , DEL_CD " ).append("\n"); 
		query.append("    , DEL_NM " ).append("\n"); 
		query.append("    , BL_MV_TP_NM " ).append("\n"); 
		query.append("    , FNL_DEST_NM " ).append("\n"); 
		query.append("    , VSL_NM " ).append("\n"); 
		query.append("    , PRE_VSL_NM " ).append("\n"); 
		query.append("    , BL_CVRD_TP_CD " ).append("\n"); 
		query.append("    , MST_CVRD_BL_NO " ).append("\n"); 
		query.append("    , BDR_FLG " ).append("\n"); 
		query.append("    , BDR_DT " ).append("\n"); 
		query.append("    , BDR_CNG_FLG " ).append("\n"); 
		query.append("    , CORR_USR_ID " ).append("\n"); 
		query.append("    , CORR_OFC_CD " ).append("\n"); 
		query.append("    , CORR_N1ST_DT " ).append("\n"); 
		query.append("    , CORR_DT " ).append("\n"); 
		query.append("    , CORR_RMK " ).append("\n"); 
		query.append("    , BKG_CLZ_FLG " ).append("\n"); 
		query.append("    , BKG_CLZ_CNG_FLG " ).append("\n"); 
		query.append("    , BKG_CLZ_CNG_CFM_FLG " ).append("\n"); 
		query.append("    , TTL_PCK_DESC " ).append("\n"); 
		query.append("    , CSTMS_DESC " ).append("\n"); 
		query.append("    , MK_DESC_CFM_FLG " ).append("\n"); 
		query.append("    , PCK_CMDT_DESC " ).append("\n"); 
		query.append("    , CNTR_CMDT_DESC " ).append("\n"); 
		query.append("    , CRE_USR_ID " ).append("\n"); 
		query.append("    , CRE_DT " ).append("\n"); 
		query.append("    , UPD_USR_ID " ).append("\n"); 
		query.append("    , UPD_DT " ).append("\n"); 
		query.append("    , BDR_GDT " ).append("\n"); 
		query.append("    , CORR_GDT " ).append("\n"); 
		query.append("    , COBIZ_AUTH_NO " ).append("\n"); 
		query.append("    , CMDT_HS_CD" ).append("\n"); 
		query.append("   )" ).append("\n"); 
		query.append("#if (${copy_type_cd} == 'BKG')" ).append("\n"); 
		query.append("SELECT BKG_NO " ).append("\n"); 
		query.append("#elseif (${copy_type_cd} == 'TEMP')" ).append("\n"); 
		query.append("SELECT BKG_NO " ).append("\n"); 
		query.append("        , 'TMP0000001' CORR_NO " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT BKG_NO " ).append("\n"); 
		query.append("        , @[ca_no] CORR_NO " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        , PCK_QTY " ).append("\n"); 
		query.append("        , PCK_TP_CD " ).append("\n"); 
		query.append("        , MEAS_QTY " ).append("\n"); 
		query.append("        , MEAS_UT_CD " ).append("\n"); 
		query.append("        , ACT_WGT " ).append("\n"); 
		query.append("        , WGT_UT_CD " ).append("\n"); 
		query.append("        , ACT_WGT_PRN_FLG " ).append("\n"); 
		query.append("        , HBL_TTL_KNT " ).append("\n"); 
		query.append("        , SPCL_CGO_AUTH_KNT " ).append("\n"); 
		query.append("        , BL_OBRD_TP_CD " ).append("\n"); 
		query.append("        , BL_OBRD_DT " ).append("\n"); 
		query.append("        , AUD_ERR_CTNT " ).append("\n"); 
		query.append("        , IB_MF_CFM_FLG " ).append("\n"); 
		query.append("        , BIS_SYS_FLG " ).append("\n"); 
		query.append("        , ORG_CNT_NM " ).append("\n"); 
		query.append("        , POR_CD " ).append("\n"); 
		query.append("        , POR_NM " ).append("\n"); 
		query.append("        , POL_CD " ).append("\n"); 
		query.append("        , POL_NM " ).append("\n"); 
		query.append("        , POD_CD " ).append("\n"); 
		query.append("        , POD_NM " ).append("\n"); 
		query.append("        , DEL_CD " ).append("\n"); 
		query.append("        , DEL_NM " ).append("\n"); 
		query.append("        , BL_MV_TP_NM " ).append("\n"); 
		query.append("        , FNL_DEST_NM " ).append("\n"); 
		query.append("        , VSL_NM " ).append("\n"); 
		query.append("        , PRE_VSL_NM " ).append("\n"); 
		query.append("        , BL_CVRD_TP_CD " ).append("\n"); 
		query.append("        , MST_CVRD_BL_NO " ).append("\n"); 
		query.append("        , BDR_FLG " ).append("\n"); 
		query.append("        , BDR_DT " ).append("\n"); 
		query.append("        , BDR_CNG_FLG " ).append("\n"); 
		query.append("        , CORR_USR_ID " ).append("\n"); 
		query.append("        , CORR_OFC_CD " ).append("\n"); 
		query.append("        , CORR_N1ST_DT " ).append("\n"); 
		query.append("        , CORR_DT " ).append("\n"); 
		query.append("        , CORR_RMK " ).append("\n"); 
		query.append("        , BKG_CLZ_FLG " ).append("\n"); 
		query.append("        , BKG_CLZ_CNG_FLG " ).append("\n"); 
		query.append("        , BKG_CLZ_CNG_CFM_FLG " ).append("\n"); 
		query.append("        , TTL_PCK_DESC " ).append("\n"); 
		query.append("        , CSTMS_DESC " ).append("\n"); 
		query.append("        , MK_DESC_CFM_FLG " ).append("\n"); 
		query.append("        , PCK_CMDT_DESC " ).append("\n"); 
		query.append("        , CNTR_CMDT_DESC " ).append("\n"); 
		query.append("        , CRE_USR_ID " ).append("\n"); 
		query.append("        , CRE_DT " ).append("\n"); 
		query.append("        , UPD_USR_ID " ).append("\n"); 
		query.append("        , sysdate" ).append("\n"); 
		query.append("        , BDR_GDT " ).append("\n"); 
		query.append("        , CORR_GDT " ).append("\n"); 
		query.append("        , COBIZ_AUTH_NO " ).append("\n"); 
		query.append("        , CMDT_HS_CD" ).append("\n"); 
		query.append("#if (${copy_type_cd} == 'BKG')" ).append("\n"); 
		query.append("  FROM BKG_BL_DOC_HIS" ).append("\n"); 
		query.append(" WHERE BKG_NO  = @[bkg_no]" ).append("\n"); 
		query.append("   AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("  FROM BKG_BL_DOC" ).append("\n"); 
		query.append(" WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}