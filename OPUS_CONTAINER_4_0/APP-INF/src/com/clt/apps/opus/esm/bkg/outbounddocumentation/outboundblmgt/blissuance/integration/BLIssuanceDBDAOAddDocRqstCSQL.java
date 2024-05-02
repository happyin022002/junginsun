/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BLIssuanceDBDAOAddDocRqstCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.08
*@LastModifier : 정인선
*@LastVersion : 1.0
* 2016.03.08 정인선
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author jung in sun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAOAddDocRqstCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AddDocRqst
	  * </pre>
	  */
	public BLIssuanceDBDAOAddDocRqstCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("obl_rt_incl_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("obl_clt_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cpy_ttl_knt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("non_nego_rt_incl_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("obl_ppd_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_iss_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_de_to_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("non_nego_clt_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("obl_ttl_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_de_mzd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("obl_rt_xcld_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("non_nego_ppd_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_iss_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_iss_plc_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_doc_rqst_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("non_nego_rt_xcld_knt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOAddDocRqstCSQL").append("\n"); 
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
		query.append("#if (${caFlag} == 'Y')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	INSERT INTO BKG_BL_ISS_HIS " ).append("\n"); 
		query.append("	( " ).append("\n"); 
		query.append("	BKG_NO" ).append("\n"); 
		query.append("	, CORR_NO" ).append("\n"); 
		query.append("	, RQST_BL_TP_CD" ).append("\n"); 
		query.append("	#if (${bl_iss_tp_cd} != '')" ).append("\n"); 
		query.append("	, BL_ISS_TP_CD" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	, OBL_RT_INCL_KNT" ).append("\n"); 
		query.append("	, OBL_RT_XCLD_KNT" ).append("\n"); 
		query.append("	, OBL_PPD_KNT" ).append("\n"); 
		query.append("	, OBL_CLT_KNT" ).append("\n"); 
		query.append("	, OBL_TTL_KNT" ).append("\n"); 
		query.append("	, NON_NEGO_RT_INCL_KNT" ).append("\n"); 
		query.append("	, NON_NEGO_RT_XCLD_KNT" ).append("\n"); 
		query.append("	, NON_NEGO_PPD_KNT" ).append("\n"); 
		query.append("	, NON_NEGO_CLT_KNT" ).append("\n"); 
		query.append("	, CPY_TTL_KNT" ).append("\n"); 
		query.append("	, RQST_ISS_PLC_NM" ).append("\n"); 
		query.append("	, BL_DE_TO_CD" ).append("\n"); 
		query.append("	, BL_DE_MZD_CD" ).append("\n"); 
		query.append("	, BL_DOC_RQST_RMK" ).append("\n"); 
		query.append("	, BL_RDY_TP_CD" ).append("\n"); 
		query.append("	#if (${rqst_iss_dt} != '')" ).append("\n"); 
		query.append("	, RQST_ISS_DT" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	, CRE_USR_ID" ).append("\n"); 
		query.append("	, CRE_DT" ).append("\n"); 
		query.append("	, UPD_USR_ID" ).append("\n"); 
		query.append("	, UPD_DT" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("	VALUES " ).append("\n"); 
		query.append("	( " ).append("\n"); 
		query.append("	@[bkg_no]" ).append("\n"); 
		query.append("	, 'TMP0000001'" ).append("\n"); 
		query.append("	, @[rqst_bl_tp_cd]" ).append("\n"); 
		query.append("	#if (${bl_iss_tp_cd} != '')" ).append("\n"); 
		query.append("	, @[bl_iss_tp_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	, @[obl_rt_incl_knt]" ).append("\n"); 
		query.append("	, @[obl_rt_xcld_knt]" ).append("\n"); 
		query.append("	, @[obl_ppd_knt]" ).append("\n"); 
		query.append("	, @[obl_clt_knt]" ).append("\n"); 
		query.append("	, @[obl_ttl_knt]" ).append("\n"); 
		query.append("	, @[non_nego_rt_incl_knt]" ).append("\n"); 
		query.append("	, @[non_nego_rt_xcld_knt]" ).append("\n"); 
		query.append("	, @[non_nego_ppd_knt]" ).append("\n"); 
		query.append("	, @[non_nego_clt_knt]" ).append("\n"); 
		query.append("	, @[cpy_ttl_knt]" ).append("\n"); 
		query.append("	, @[rqst_iss_plc_nm]" ).append("\n"); 
		query.append("	, @[bl_de_to_cd]" ).append("\n"); 
		query.append("	, @[bl_de_mzd_cd]" ).append("\n"); 
		query.append("	, @[bl_doc_rqst_rmk]" ).append("\n"); 
		query.append("	, @[rqst_bl_tp_cd]" ).append("\n"); 
		query.append("	#if (${rqst_iss_dt} != '')" ).append("\n"); 
		query.append("	,TO_DATE(replace(substr(@[rqst_iss_dt],1,10),'-',''),'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	, @[user_id]" ).append("\n"); 
		query.append("	, SYSDATE" ).append("\n"); 
		query.append("	, @[user_id]" ).append("\n"); 
		query.append("	, SYSDATE " ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	INSERT INTO BKG_BL_ISS " ).append("\n"); 
		query.append("	( " ).append("\n"); 
		query.append("	BKG_NO" ).append("\n"); 
		query.append("	, RQST_BL_TP_CD" ).append("\n"); 
		query.append("	#if (${bl_iss_tp_cd} != '')" ).append("\n"); 
		query.append("	, BL_ISS_TP_CD" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	, OBL_RT_INCL_KNT" ).append("\n"); 
		query.append("	, OBL_RT_XCLD_KNT" ).append("\n"); 
		query.append("	, OBL_PPD_KNT" ).append("\n"); 
		query.append("	, OBL_CLT_KNT" ).append("\n"); 
		query.append("	, OBL_TTL_KNT" ).append("\n"); 
		query.append("	, NON_NEGO_RT_INCL_KNT" ).append("\n"); 
		query.append("	, NON_NEGO_RT_XCLD_KNT" ).append("\n"); 
		query.append("	, NON_NEGO_PPD_KNT" ).append("\n"); 
		query.append("	, NON_NEGO_CLT_KNT" ).append("\n"); 
		query.append("	, CPY_TTL_KNT" ).append("\n"); 
		query.append("	, RQST_ISS_PLC_NM" ).append("\n"); 
		query.append("	, BL_DE_TO_CD" ).append("\n"); 
		query.append("	, BL_DE_MZD_CD" ).append("\n"); 
		query.append("	, BL_DOC_RQST_RMK" ).append("\n"); 
		query.append("	, BL_RDY_TP_CD" ).append("\n"); 
		query.append("	#if (${rqst_iss_dt} != '')" ).append("\n"); 
		query.append("	, RQST_ISS_DT" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	, CRE_USR_ID" ).append("\n"); 
		query.append("	, CRE_DT" ).append("\n"); 
		query.append("	, UPD_USR_ID" ).append("\n"); 
		query.append("	, UPD_DT" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("	VALUES " ).append("\n"); 
		query.append("	( " ).append("\n"); 
		query.append("	@[bkg_no]" ).append("\n"); 
		query.append("	, @[rqst_bl_tp_cd]" ).append("\n"); 
		query.append("	#if (${bl_iss_tp_cd} != '')" ).append("\n"); 
		query.append("	, @[bl_iss_tp_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	, @[obl_rt_incl_knt]" ).append("\n"); 
		query.append("	, @[obl_rt_xcld_knt]" ).append("\n"); 
		query.append("	, @[obl_ppd_knt]" ).append("\n"); 
		query.append("	, @[obl_clt_knt]" ).append("\n"); 
		query.append("	, @[obl_ttl_knt]" ).append("\n"); 
		query.append("	, @[non_nego_rt_incl_knt]" ).append("\n"); 
		query.append("	, @[non_nego_rt_xcld_knt]" ).append("\n"); 
		query.append("	, @[non_nego_ppd_knt]" ).append("\n"); 
		query.append("	, @[non_nego_clt_knt]" ).append("\n"); 
		query.append("	, @[cpy_ttl_knt]" ).append("\n"); 
		query.append("	, @[rqst_iss_plc_nm]" ).append("\n"); 
		query.append("	, @[bl_de_to_cd]" ).append("\n"); 
		query.append("	, @[bl_de_mzd_cd]" ).append("\n"); 
		query.append("	, @[bl_doc_rqst_rmk]" ).append("\n"); 
		query.append("	, @[rqst_bl_tp_cd]" ).append("\n"); 
		query.append("	#if (${rqst_iss_dt} != '')" ).append("\n"); 
		query.append("	,TO_DATE(replace(substr(@[rqst_iss_dt],1,10),'-',''),'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	, @[user_id]" ).append("\n"); 
		query.append("	, SYSDATE" ).append("\n"); 
		query.append("	, @[user_id]" ).append("\n"); 
		query.append("	, SYSDATE " ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}