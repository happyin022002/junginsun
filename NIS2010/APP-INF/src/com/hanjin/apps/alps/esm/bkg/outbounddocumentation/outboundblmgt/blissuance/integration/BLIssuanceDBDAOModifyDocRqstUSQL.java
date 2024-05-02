/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BLIssuanceDBDAOModifyDocRqstUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.09.02
*@LastModifier : 
*@LastVersion : 1.0
* 2014.09.02 
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

public class BLIssuanceDBDAOModifyDocRqstUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyDocRqst
	  * </pre>
	  */
	public BLIssuanceDBDAOModifyDocRqstUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("obl_rt_incl_knt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("wbl_rt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("wbl_eml",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("non_nego_rt_incl_knt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rqst_iss_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("non_nego_rt_xcld_knt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOModifyDocRqstUSQL").append("\n"); 
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
		query.append("	UPDATE " ).append("\n"); 
		query.append("		BKG_BL_ISS_HIS" ).append("\n"); 
		query.append("	SET    " ).append("\n"); 
		query.append("		RQST_BL_TP_CD		= @[rqst_bl_tp_cd]" ).append("\n"); 
		query.append("		,OBL_RT_INCL_KNT	= @[obl_rt_incl_knt]" ).append("\n"); 
		query.append("		,OBL_RT_XCLD_KNT	= @[obl_rt_xcld_knt]" ).append("\n"); 
		query.append("		,OBL_TTL_KNT		= @[obl_ttl_knt]" ).append("\n"); 
		query.append("		,NON_NEGO_RT_INCL_KNT	= @[non_nego_rt_incl_knt]" ).append("\n"); 
		query.append("		,NON_NEGO_RT_XCLD_KNT	= @[non_nego_rt_xcld_knt]" ).append("\n"); 
		query.append("		,CPY_TTL_KNT		= @[cpy_ttl_knt]" ).append("\n"); 
		query.append("		,RQST_ISS_PLC_NM	= @[rqst_iss_plc_nm]" ).append("\n"); 
		query.append("		,BL_DE_TO_CD		= @[bl_de_to_cd]" ).append("\n"); 
		query.append("		,BL_DE_MZD_CD		= @[bl_de_mzd_cd]" ).append("\n"); 
		query.append("		,BL_DOC_RQST_RMK	= @[bl_doc_rqst_rmk]" ).append("\n"); 
		query.append("		,WBL_RT_TP_CD	    = @[wbl_rt_tp_cd]" ).append("\n"); 
		query.append("        ,WBL_EML	        = @[wbl_eml]" ).append("\n"); 
		query.append("	#if (${rqst_bl_tp_cd} == 'W')" ).append("\n"); 
		query.append("		,BL_RDY_TP_CD		= 'W'" ).append("\n"); 
		query.append("	#elseif(${rqst_bl_tp_cd} == 'B')" ).append("\n"); 
		query.append("		,BL_RDY_TP_CD		= 'B'" ).append("\n"); 
		query.append("	#elseif(${rqst_bl_tp_cd} == 'S')" ).append("\n"); 
		query.append("		,BL_RDY_TP_CD		= 'B'" ).append("\n"); 
		query.append("	#elseif(${rqst_bl_tp_cd} == 'O')" ).append("\n"); 
		query.append("		,BL_RDY_TP_CD		= 'B'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${rqst_iss_dt} != '')" ).append("\n"); 
		query.append("		,RQST_ISS_DT 		= TO_DATE(replace(substr(@[rqst_iss_dt],1,10),'-',''),'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		,RQST_ISS_DT 		= ''" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	WHERE  " ).append("\n"); 
		query.append("		BKG_NO  = @[bkg_no]" ).append("\n"); 
		query.append("		AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	UPDATE " ).append("\n"); 
		query.append("		BKG_BL_ISS" ).append("\n"); 
		query.append("	SET    " ).append("\n"); 
		query.append("		RQST_BL_TP_CD		= @[rqst_bl_tp_cd]" ).append("\n"); 
		query.append("		,OBL_RT_INCL_KNT	= @[obl_rt_incl_knt]" ).append("\n"); 
		query.append("		,OBL_RT_XCLD_KNT	= @[obl_rt_xcld_knt]" ).append("\n"); 
		query.append("		,OBL_TTL_KNT		= @[obl_ttl_knt]" ).append("\n"); 
		query.append("		,NON_NEGO_RT_INCL_KNT	= @[non_nego_rt_incl_knt]" ).append("\n"); 
		query.append("		,NON_NEGO_RT_XCLD_KNT	= @[non_nego_rt_xcld_knt]" ).append("\n"); 
		query.append("		,CPY_TTL_KNT		= @[cpy_ttl_knt]" ).append("\n"); 
		query.append("		,RQST_ISS_PLC_NM	= @[rqst_iss_plc_nm]" ).append("\n"); 
		query.append("		,BL_DE_TO_CD		= @[bl_de_to_cd]" ).append("\n"); 
		query.append("		,BL_DE_MZD_CD		= @[bl_de_mzd_cd]" ).append("\n"); 
		query.append("		,BL_DOC_RQST_RMK	= @[bl_doc_rqst_rmk]" ).append("\n"); 
		query.append("		,WBL_RT_TP_CD	    = @[wbl_rt_tp_cd]" ).append("\n"); 
		query.append("        ,WBL_EML	        = @[wbl_eml]" ).append("\n"); 
		query.append("	#if (${rqst_bl_tp_cd} == 'W')" ).append("\n"); 
		query.append("		,BL_RDY_TP_CD		= 'W'" ).append("\n"); 
		query.append("	#elseif(${rqst_bl_tp_cd} == 'B')" ).append("\n"); 
		query.append("		,BL_RDY_TP_CD		= 'B'" ).append("\n"); 
		query.append("	#elseif(${rqst_bl_tp_cd} == 'S')" ).append("\n"); 
		query.append("		,BL_RDY_TP_CD		= 'B'" ).append("\n"); 
		query.append("	#elseif(${rqst_bl_tp_cd} == 'O')" ).append("\n"); 
		query.append("		,BL_RDY_TP_CD		= 'B'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${rqst_iss_dt} != '')" ).append("\n"); 
		query.append("		,RQST_ISS_DT 		= TO_DATE(replace(substr(@[rqst_iss_dt],1,10),'-',''),'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		,RQST_ISS_DT 		= ''" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	WHERE  " ).append("\n"); 
		query.append("		BKG_NO  = @[bkg_no]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}