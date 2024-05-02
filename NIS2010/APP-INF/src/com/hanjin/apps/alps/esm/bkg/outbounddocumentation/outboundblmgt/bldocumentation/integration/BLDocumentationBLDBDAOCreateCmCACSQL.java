/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BLDocumentationBLDBDAOCreateCmCACSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.07
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.07 
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

public class BLDocumentationBLDBDAOCreateCmCACSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BLDocumentationBLDBDAOCreateCmCACSQL
	  * </pre>
	  */
	public BLDocumentationBLDBDAOCreateCmCACSQL(){
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
		query.append("FileName : BLDocumentationBLDBDAOCreateCmCACSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_CNTR_MF_DESC (" ).append("\n"); 
		query.append("    BKG_NO " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("INSERT INTO BKG_CNTR_MF_DESC_HIS (" ).append("\n"); 
		query.append("    BKG_NO " ).append("\n"); 
		query.append("    , CORR_NO " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    , CNTR_MF_SEQ " ).append("\n"); 
		query.append("    , CNTR_NO " ).append("\n"); 
		query.append("    , PCK_QTY " ).append("\n"); 
		query.append("    , PCK_TP_CD " ).append("\n"); 
		query.append("    , CNTR_MF_WGT " ).append("\n"); 
		query.append("    , WGT_UT_CD " ).append("\n"); 
		query.append("    , MEAS_QTY " ).append("\n"); 
		query.append("    , MEAS_UT_CD " ).append("\n"); 
		query.append("    , DCGO_FLG " ).append("\n"); 
		query.append("    , BB_CGO_FLG " ).append("\n"); 
		query.append("    , AWK_CGO_FLG " ).append("\n"); 
		query.append("    , RC_FLG " ).append("\n"); 
		query.append("    , RD_CGO_FLG " ).append("\n"); 
		query.append("    , HNGR_FLG " ).append("\n"); 
		query.append("    , CNTR_MF_MK_DESC " ).append("\n"); 
		query.append("    , CNTR_MF_GDS_DESC 		" ).append("\n"); 
		query.append("    , HBL_SEQ " ).append("\n"); 
		query.append("    , HAMO_TRF_CD " ).append("\n"); 
		query.append("    , NCM_NO " ).append("\n"); 
		query.append("    , PO_NO " ).append("\n"); 
		query.append("    , CNTR_MF_NO " ).append("\n"); 
		query.append("    , CSTMS_DECL_NO " ).append("\n"); 
		query.append("    , CRE_USR_ID " ).append("\n"); 
		query.append("    , CRE_DT " ).append("\n"); 
		query.append("    , UPD_USR_ID " ).append("\n"); 
		query.append("    , UPD_DT " ).append("\n"); 
		query.append("    , CMDT_HS_CD " ).append("\n"); 
		query.append("	, DCGO_SEQ" ).append("\n"); 
		query.append("    , WPM_TRT_CD" ).append("\n"); 
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
		query.append("        , CNTR_MF_SEQ " ).append("\n"); 
		query.append("        , CNTR_NO " ).append("\n"); 
		query.append("        , PCK_QTY " ).append("\n"); 
		query.append("        , PCK_TP_CD " ).append("\n"); 
		query.append("        , CNTR_MF_WGT " ).append("\n"); 
		query.append("        , WGT_UT_CD " ).append("\n"); 
		query.append("        , MEAS_QTY " ).append("\n"); 
		query.append("        , MEAS_UT_CD " ).append("\n"); 
		query.append("        , DCGO_FLG " ).append("\n"); 
		query.append("        , BB_CGO_FLG " ).append("\n"); 
		query.append("        , AWK_CGO_FLG " ).append("\n"); 
		query.append("        , RC_FLG " ).append("\n"); 
		query.append("        , RD_CGO_FLG " ).append("\n"); 
		query.append("        , HNGR_FLG " ).append("\n"); 
		query.append("        , CNTR_MF_MK_DESC " ).append("\n"); 
		query.append("        , CNTR_MF_GDS_DESC " ).append("\n"); 
		query.append("        , HBL_SEQ " ).append("\n"); 
		query.append("        , HAMO_TRF_CD " ).append("\n"); 
		query.append("        , NCM_NO " ).append("\n"); 
		query.append("        , PO_NO " ).append("\n"); 
		query.append("        , CNTR_MF_NO " ).append("\n"); 
		query.append("        , CSTMS_DECL_NO " ).append("\n"); 
		query.append("        , CRE_USR_ID " ).append("\n"); 
		query.append("        , CRE_DT " ).append("\n"); 
		query.append("        , UPD_USR_ID " ).append("\n"); 
		query.append("        , sysdate" ).append("\n"); 
		query.append("        , CMDT_HS_CD " ).append("\n"); 
		query.append("		, DCGO_SEQ" ).append("\n"); 
		query.append("    , WPM_TRT_CD" ).append("\n"); 
		query.append("#if (${copy_type_cd} == 'BKG')" ).append("\n"); 
		query.append("  FROM BKG_CNTR_MF_DESC_HIS" ).append("\n"); 
		query.append(" WHERE BKG_NO  = @[bkg_no]" ).append("\n"); 
		query.append("   AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("  FROM BKG_CNTR_MF_DESC" ).append("\n"); 
		query.append(" WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}