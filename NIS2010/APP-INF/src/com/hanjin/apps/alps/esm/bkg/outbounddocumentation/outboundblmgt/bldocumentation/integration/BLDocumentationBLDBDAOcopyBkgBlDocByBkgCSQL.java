/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BLDocumentationBLDBDAOcopyBkgBlDocByBkgCSQL.java
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

public class BLDocumentationBLDBDAOcopyBkgBlDocByBkgCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * insert
	  * </pre>
	  */
	public BLDocumentationBLDBDAOcopyBkgBlDocByBkgCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_wgt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("meas_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("targetBkg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pck_qty",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationBLDBDAOcopyBkgBlDocByBkgCSQL").append("\n"); 
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
		query.append("insert into bkg_bl_doc" ).append("\n"); 
		query.append("        (BKG_NO" ).append("\n"); 
		query.append("        , PCK_QTY" ).append("\n"); 
		query.append("        , PCK_TP_CD" ).append("\n"); 
		query.append("        , MEAS_QTY" ).append("\n"); 
		query.append("        , MEAS_UT_CD" ).append("\n"); 
		query.append("        , ACT_WGT" ).append("\n"); 
		query.append("        , WGT_UT_CD" ).append("\n"); 
		query.append("        , ACT_WGT_PRN_FLG" ).append("\n"); 
		query.append("        , HBL_TTL_KNT" ).append("\n"); 
		query.append("        , SPCL_CGO_AUTH_KNT" ).append("\n"); 
		query.append("        , BL_OBRD_TP_CD" ).append("\n"); 
		query.append("        , BL_OBRD_DT" ).append("\n"); 
		query.append("        , AUD_ERR_CTNT" ).append("\n"); 
		query.append("        , IB_MF_CFM_FLG" ).append("\n"); 
		query.append("        , BIS_SYS_FLG" ).append("\n"); 
		query.append("        , ORG_CNT_NM" ).append("\n"); 
		query.append("        , POR_CD" ).append("\n"); 
		query.append("        , POR_NM" ).append("\n"); 
		query.append("        , POL_CD" ).append("\n"); 
		query.append("        , POL_NM" ).append("\n"); 
		query.append("        , POD_CD" ).append("\n"); 
		query.append("        , POD_NM" ).append("\n"); 
		query.append("        , DEL_CD" ).append("\n"); 
		query.append("        , DEL_NM" ).append("\n"); 
		query.append("        , BL_MV_TP_NM" ).append("\n"); 
		query.append("        , FNL_DEST_NM" ).append("\n"); 
		query.append("        , VSL_NM" ).append("\n"); 
		query.append("        , PRE_VSL_NM" ).append("\n"); 
		query.append("        , BL_CVRD_TP_CD" ).append("\n"); 
		query.append("        , MST_CVRD_BL_NO" ).append("\n"); 
		query.append("        , BDR_FLG" ).append("\n"); 
		query.append("        , BDR_DT" ).append("\n"); 
		query.append("        , BDR_CNG_FLG" ).append("\n"); 
		query.append("        , BKG_CLZ_FLG" ).append("\n"); 
		query.append("        , BKG_CLZ_CNG_FLG" ).append("\n"); 
		query.append("        , BKG_CLZ_CNG_CFM_FLG" ).append("\n"); 
		query.append("        , TTL_PCK_DESC" ).append("\n"); 
		query.append("        , CSTMS_DESC" ).append("\n"); 
		query.append("        , MK_DESC_CFM_FLG" ).append("\n"); 
		query.append("        , PCK_CMDT_DESC" ).append("\n"); 
		query.append("        , CNTR_CMDT_DESC" ).append("\n"); 
		query.append("        , CMDT_HS_CD" ).append("\n"); 
		query.append("        , CRE_USR_ID" ).append("\n"); 
		query.append("        , CRE_DT" ).append("\n"); 
		query.append("        , UPD_USR_ID" ).append("\n"); 
		query.append("        , UPD_DT)" ).append("\n"); 
		query.append("select @[targetBkg] BKG_NO" ).append("\n"); 
		query.append("    , @[pck_qty] PCK_QTY" ).append("\n"); 
		query.append("    , PCK_TP_CD" ).append("\n"); 
		query.append("    , @[meas_qty] MEAS_QTY" ).append("\n"); 
		query.append("    , MEAS_UT_CD" ).append("\n"); 
		query.append("    , @[act_wgt] ACT_WGT" ).append("\n"); 
		query.append("    , WGT_UT_CD" ).append("\n"); 
		query.append("    , ACT_WGT_PRN_FLG" ).append("\n"); 
		query.append("    , 0 HBL_TTL_KNT" ).append("\n"); 
		query.append("    , 0 SPCL_CGO_AUTH_KNT" ).append("\n"); 
		query.append("    , BL_OBRD_TP_CD" ).append("\n"); 
		query.append("    , BL_OBRD_DT" ).append("\n"); 
		query.append("    , AUD_ERR_CTNT" ).append("\n"); 
		query.append("    , 'N' IB_MF_CFM_FLG" ).append("\n"); 
		query.append("    , 'N' BIS_SYS_FLG" ).append("\n"); 
		query.append("    , ORG_CNT_NM" ).append("\n"); 
		query.append("    , POR_CD" ).append("\n"); 
		query.append("    , POR_NM" ).append("\n"); 
		query.append("    , POL_CD" ).append("\n"); 
		query.append("    , POL_NM" ).append("\n"); 
		query.append("    , POD_CD" ).append("\n"); 
		query.append("    , POD_NM" ).append("\n"); 
		query.append("    , DEL_CD" ).append("\n"); 
		query.append("    , DEL_NM" ).append("\n"); 
		query.append("    , BL_MV_TP_NM" ).append("\n"); 
		query.append("    , FNL_DEST_NM" ).append("\n"); 
		query.append("    , (select vsl_eng_nm||' '||bk.skd_voy_no||bk.skd_dir_cd" ).append("\n"); 
		query.append("       from mdm_vsl_cntr vsl, bkg_booking bk " ).append("\n"); 
		query.append("       where bk.bkg_no = @[targetBkg]" ).append("\n"); 
		query.append("        and bk.vsl_cd = vsl.vsl_cd) VSL_NM" ).append("\n"); 
		query.append("    , PRE_VSL_NM" ).append("\n"); 
		query.append("    , BL_CVRD_TP_CD" ).append("\n"); 
		query.append("    , MST_CVRD_BL_NO" ).append("\n"); 
		query.append("    , BDR_FLG" ).append("\n"); 
		query.append("    , BDR_DT" ).append("\n"); 
		query.append("    , BDR_CNG_FLG" ).append("\n"); 
		query.append("    , 'N' BKG_CLZ_FLG" ).append("\n"); 
		query.append("    , 'N' BKG_CLZ_CNG_FLG" ).append("\n"); 
		query.append("    , 'N' BKG_CLZ_CNG_CFM_FLG" ).append("\n"); 
		query.append("    , TTL_PCK_DESC" ).append("\n"); 
		query.append("    , CSTMS_DESC" ).append("\n"); 
		query.append("    , MK_DESC_CFM_FLG" ).append("\n"); 
		query.append("    , PCK_CMDT_DESC" ).append("\n"); 
		query.append("    , CNTR_CMDT_DESC" ).append("\n"); 
		query.append("    , CMDT_HS_CD" ).append("\n"); 
		query.append("    , @[usr_id] CRE_USR_ID" ).append("\n"); 
		query.append("    , sysdate CRE_DT" ).append("\n"); 
		query.append("    , @[usr_id] UPD_USR_ID" ).append("\n"); 
		query.append("    , sysdate UPD_DT" ).append("\n"); 
		query.append("  from bkg_bl_doc" ).append("\n"); 
		query.append(" where bkg_no = @[bkg_no]" ).append("\n"); 

	}
}