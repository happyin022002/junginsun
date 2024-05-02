/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOaddFullCntrRlseOrderCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.02.04
*@LastModifier : 
*@LastVersion : 1.0
* 2014.02.04 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOaddFullCntrRlseOrderCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * addFullCntrRlseOrder
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOaddFullCntrRlseOrderCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlse_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_trsp_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eml_snd_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("do_iss_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("do_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_pkup_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlse_ntc_eml",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("veh_rgst_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cxl_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlse_exp_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlse_hdr_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("diff_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlse_instr_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("road_hlg_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgor_mzd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("uq_vsl_id_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlse_ftr_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pin_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_crr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rlse_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("co_bdg_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOaddFullCntrRlseOrderCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_FULL_CGO_RLSE_ORD " ).append("\n"); 
		query.append("( " ).append("\n"); 
		query.append("           BKG_NO" ).append("\n"); 
		query.append("          ,CNTR_NO" ).append("\n"); 
		query.append("          ,RLSE_ORD_SEQ" ).append("\n"); 
		query.append("          ,YD_CD" ).append("\n"); 
		query.append("          ,CGO_PKUP_DT" ).append("\n"); 
		query.append("          ,BKG_TRSP_MOD_CD" ).append("\n"); 
		query.append("          ,CUST_NM" ).append("\n"); 
		query.append("          ,RLSE_USR_ID" ).append("\n"); 
		query.append("          ,RLSE_OFC_CD" ).append("\n"); 
		query.append("          ,CGOR_MZD_CD" ).append("\n"); 
		query.append("          ,RLSE_CRE_DT" ).append("\n"); 
		query.append("          ,RLSE_CRE_GDT" ).append("\n"); 
		query.append("		  ,RLSE_EXP_DT" ).append("\n"); 
		query.append("          ,RLSE_HDR_CTNT" ).append("\n"); 
		query.append("          ,RLSE_FTR_CTNT" ).append("\n"); 
		query.append("          ,RLSE_INSTR_CTNT" ).append("\n"); 
		query.append("          ,DIFF_RMK" ).append("\n"); 
		query.append("          ,CXL_FLG" ).append("\n"); 
		query.append("          ,POD_CD" ).append("\n"); 
		query.append("          ,DO_NO" ).append("\n"); 
		query.append("          ,DO_NO_SPLIT" ).append("\n"); 
		query.append("          ,DO_ISS_DT" ).append("\n"); 
		query.append("		  ,CO_BDG_ID" ).append("\n"); 
		query.append("		  ,CGO_CRR_ID" ).append("\n"); 
		query.append("		  ,PIN_NO" ).append("\n"); 
		query.append("		  ,VEH_RGST_ID" ).append("\n"); 
		query.append("		  ,ROAD_HLG_ID" ).append("\n"); 
		query.append("		  ,UQ_VSL_ID_NO" ).append("\n"); 
		query.append("		  ,RLSE_NTC_EML" ).append("\n"); 
		query.append("		  ,EML_SND_ID" ).append("\n"); 
		query.append("		  ,CSTMS_VOY_NO       " ).append("\n"); 
		query.append("          ,CRE_USR_ID" ).append("\n"); 
		query.append("          ,CRE_DT" ).append("\n"); 
		query.append("          ,UPD_USR_ID" ).append("\n"); 
		query.append("          ,UPD_DT" ).append("\n"); 
		query.append(") VALUES ( @[bkg_no]" ).append("\n"); 
		query.append("          ,@[cntr_no]" ).append("\n"); 
		query.append("          ,(SELECT NVL(MAX(RLSE_ORD_SEQ), 0) + 1 FROM BKG_FULL_CGO_RLSE_ORD WHERE BKG_NO = @[bkg_no] AND CNTR_NO = @[cntr_no])" ).append("\n"); 
		query.append("          ,@[yd_cd]" ).append("\n"); 
		query.append("          ,TO_DATE(@[cgo_pkup_dt], 'YYYYMMDD')" ).append("\n"); 
		query.append("          ,@[bkg_trsp_mod_cd]" ).append("\n"); 
		query.append("          ,@[cust_nm]" ).append("\n"); 
		query.append("          ,@[rlse_usr_id]" ).append("\n"); 
		query.append("          ,@[rlse_ofc_cd]" ).append("\n"); 
		query.append("          ,@[cgor_mzd_cd]" ).append("\n"); 
		query.append("          ,GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL',sysdate,GLOBALDATE_PKG.GET_LOCCD_FNC(@[rlse_ofc_cd]) )     " ).append("\n"); 
		query.append("          ,GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL',sysdate,'GMT')  -- Rlse GMT" ).append("\n"); 
		query.append("		  ,TO_DATE(DECODE(@[rlse_exp_dt],null,null,@[rlse_exp_dt]||'2359'),'YYYY/MM/DD HH24:MI')" ).append("\n"); 
		query.append("          ,@[rlse_hdr_ctnt]" ).append("\n"); 
		query.append("          ,@[rlse_ftr_ctnt]" ).append("\n"); 
		query.append("          ,NVL(@[rlse_instr_ctnt],'N')" ).append("\n"); 
		query.append("          ,@[diff_rmk]" ).append("\n"); 
		query.append("          ,NVL(@[cxl_flg],'N')" ).append("\n"); 
		query.append("          ,@[pod_cd]" ).append("\n"); 
		query.append("          ,SUBSTR(@[do_no], 0, 10)" ).append("\n"); 
		query.append("          ,SUBSTR(@[do_no], 11, 2)" ).append("\n"); 
		query.append("          ,TO_DATE(@[do_iss_dt],'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("		  ,@[co_bdg_id]" ).append("\n"); 
		query.append("		  ,@[cgo_crr_id]" ).append("\n"); 
		query.append("		  ,@[pin_no]" ).append("\n"); 
		query.append("		  ,@[veh_rgst_id]" ).append("\n"); 
		query.append("		  ,@[road_hlg_id]" ).append("\n"); 
		query.append("		  ,@[uq_vsl_id_no]" ).append("\n"); 
		query.append("          ,@[rlse_ntc_eml]" ).append("\n"); 
		query.append("		  ,@[eml_snd_id]" ).append("\n"); 
		query.append("          ,@[cstms_voy_no]" ).append("\n"); 
		query.append("          ,@[cre_usr_id]" ).append("\n"); 
		query.append("          ,SYSDATE" ).append("\n"); 
		query.append("          ,@[upd_usr_id]" ).append("\n"); 
		query.append("          ,SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}