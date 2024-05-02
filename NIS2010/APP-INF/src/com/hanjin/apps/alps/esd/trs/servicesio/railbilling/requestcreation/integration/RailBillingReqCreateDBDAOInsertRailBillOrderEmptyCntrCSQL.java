/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : RailBillingReqCreateDBDAOInsertRailBillOrderEmptyCntrCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.05
*@LastModifier : 윤권영
*@LastVersion : 1.0
* 2012.04.05 윤권영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.railbilling.requestcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author yun kwon-young
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RailBillingReqCreateDBDAOInsertRailBillOrderEmptyCntrCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * InsertRailBillOrderEmptyCntr
	  * </pre>
	  */
	public RailBillingReqCreateDBDAOInsertRailBillOrderEmptyCntrCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inlnd_rout_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inter_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ref_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_rail_bil_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rout_org_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pln_yrwk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prov_phn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_mty_cost_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_mty_rqst_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prov_cfm_mzd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("shpr_fax_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("prov_fax_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spnd_err_msg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rail_cmb_thru_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rout_dest_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("repo_pln_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rout_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prov_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rout_pln_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("shpr_cust_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spnd_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prov_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ref_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prov_eml",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eq_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_instr_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spnd_lang_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.servicesio.railbilling.requestcreation.integration").append("\n"); 
		query.append("FileName : RailBillingReqCreateDBDAOInsertRailBillOrderEmptyCntrCSQL").append("\n"); 
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
		query.append("INSERT INTO TRS_TRSP_RAIL_BIL_ORD (" ).append("\n"); 
		query.append("TRSP_SO_OFC_CTY_CD   ," ).append("\n"); 
		query.append("TRSP_SO_SEQ          ," ).append("\n"); 
		query.append("RAIL_CMB_THRU_TP_CD  ," ).append("\n"); 
		query.append("TRSP_SO_STS_CD       ," ).append("\n"); 
		query.append("TRSP_RAIL_BIL_TP_CD  ," ).append("\n"); 
		query.append("FM_NOD_CD            ," ).append("\n"); 
		query.append("TO_NOD_CD            ," ).append("\n"); 
		query.append("VSL_CD               ," ).append("\n"); 
		query.append("SKD_VOY_NO           ," ).append("\n"); 
		query.append("SKD_DIR_CD           ," ).append("\n"); 
		query.append("SLAN_CD              ," ).append("\n"); 
		query.append("TRSP_COST_DTL_MOD_CD ," ).append("\n"); 
		query.append("EQ_KND_CD             ," ).append("\n"); 
		query.append("EQ_NO                ," ).append("\n"); 
		query.append("EQ_TPSZ_CD           ," ).append("\n"); 
		query.append("CGO_TP_CD            ," ).append("\n"); 
		query.append("ROUT_ORG_NOD_CD      ," ).append("\n"); 
		query.append("ROUT_DEST_NOD_CD     ," ).append("\n"); 
		query.append("ROUT_SEQ             ," ).append("\n"); 
		query.append("ROUT_PLN_CD          ," ).append("\n"); 
		query.append("INLND_ROUT_RMK       ," ).append("\n"); 
		query.append("CRE_OFC_CD           ,  --세션" ).append("\n"); 
		query.append("LOG_UPD_DT           ,  --SYSTIME" ).append("\n"); 
		query.append("CRE_DT               ,  --SYSTIME" ).append("\n"); 
		query.append("CRE_USR_ID           ,  --세션" ).append("\n"); 
		query.append("UPD_DT               ,  --SYSTIME" ).append("\n"); 
		query.append("UPD_USR_ID           ,  --세션" ).append("\n"); 
		query.append("INTER_RMK            ,  --" ).append("\n"); 
		query.append("SPCL_INSTR_RMK       ,  --" ).append("\n"); 
		query.append("TRSP_MTY_COST_MOD_CD ," ).append("\n"); 
		query.append("REPO_PLN_ID          ," ).append("\n"); 
		query.append("PLN_YRWK             ," ).append("\n"); 
		query.append("REF_SEQ              ," ).append("\n"); 
		query.append("REF_ID               ," ).append("\n"); 
		query.append("TRSP_MTY_RQST_DT     ," ).append("\n"); 
		query.append("SPND_FLG             ," ).append("\n"); 
		query.append("SPND_ERR_MSG_CD      ," ).append("\n"); 
		query.append("SPND_LANG_TP_CD      ," ).append("\n"); 
		query.append("SHPR_CUST_NM         ," ).append("\n"); 
		query.append("SHPR_FAX_NO          ," ).append("\n"); 
		query.append("PROV_VNDR_SEQ        ," ).append("\n"); 
		query.append("PROV_USR_ID          ," ).append("\n"); 
		query.append("PROV_PHN_NO          ," ).append("\n"); 
		query.append("PROV_FAX_NO          ," ).append("\n"); 
		query.append("PROV_EML             ," ).append("\n"); 
		query.append("PROV_CFM_MZD_CD      ," ).append("\n"); 
		query.append("DELT_FLG             ,   --N" ).append("\n"); 
		query.append("LOCL_CRE_DT			," ).append("\n"); 
		query.append("LOCL_UPD_DT" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("@[trsp_so_ofc_cty_cd],  --TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("@[trsp_so_seq],  --TRSP_SO_SEQ" ).append("\n"); 
		query.append("@[rail_cmb_thru_tp_cd],  --RAIL_CMB_THRU_TP_CD" ).append("\n"); 
		query.append("@[trsp_so_sts_cd],  --TRSP_SO_STS_CD : C" ).append("\n"); 
		query.append("@[trsp_rail_bil_tp_cd],  --TRSP_RAIL_BIL_TP_CD : COP(c) MT(m) WRS(w)" ).append("\n"); 
		query.append("@[fm_nod_cd],  --FM_NOD_CD" ).append("\n"); 
		query.append("@[to_nod_cd],  --TO_NOD_CD" ).append("\n"); 
		query.append("@[vsl_cd],  --VSL_CD" ).append("\n"); 
		query.append("@[skd_voy_no],  --SKD_VOY_NO" ).append("\n"); 
		query.append("@[skd_dir_cd],  --SKD_DIR_CD" ).append("\n"); 
		query.append("@[slan_cd],  --SLAN_CD" ).append("\n"); 
		query.append("'ER'                    ,  --TRSP_COST_DTL_MOD_CD" ).append("\n"); 
		query.append("'U'                     ,  --EQ_KND_CD" ).append("\n"); 
		query.append("@[eq_no],  --EQ_NO" ).append("\n"); 
		query.append("@[eq_tpsz_cd],  --EQ_TPSZ_CD" ).append("\n"); 
		query.append("@[cgo_tp_cd],  --CGO_TP_CD" ).append("\n"); 
		query.append("@[rout_org_nod_cd],  --ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("@[rout_dest_nod_cd],  --ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("@[rout_seq],  --ROUT_SEQ" ).append("\n"); 
		query.append("@[rout_pln_cd],  --ROUT_PLN_CD" ).append("\n"); 
		query.append("@[inlnd_rout_rmk],  --INLND_ROUT_RMK" ).append("\n"); 
		query.append("@[cre_ofc_cd],  --CRE_OFC_CD" ).append("\n"); 
		query.append("sysdate ,  --LOG_UPD_DT" ).append("\n"); 
		query.append("sysdate ,  --CRE_DT" ).append("\n"); 
		query.append("@[cre_usr_id],  --CRE_USR_ID" ).append("\n"); 
		query.append("sysdate ,  --UPD_DT" ).append("\n"); 
		query.append("@[upd_usr_id],  --UPD_USR_ID" ).append("\n"); 
		query.append("@[inter_rmk],  --INTER_RMK" ).append("\n"); 
		query.append("@[spcl_instr_rmk],  --SPCL_INSTR_RMK" ).append("\n"); 
		query.append("@[trsp_mty_cost_mod_cd],  --TRSP_MTY_COST_MOD_CD" ).append("\n"); 
		query.append("@[repo_pln_id],  --REPO_PLN_ID" ).append("\n"); 
		query.append("@[pln_yrwk],  --PLN_YRWK" ).append("\n"); 
		query.append("@[ref_seq],  --REF_SEQ" ).append("\n"); 
		query.append("@[ref_id],  --REF_ID" ).append("\n"); 
		query.append("TO_DATE(@[trsp_mty_rqst_dt], 'YYYYMMDDHH24MISS') ,  --TRSP_MTY_RQST_DT" ).append("\n"); 
		query.append("@[spnd_flg],   --SPND_FLG" ).append("\n"); 
		query.append("@[spnd_err_msg_cd],   --SPND_ERR_MSG_CD" ).append("\n"); 
		query.append("@[spnd_lang_tp_cd],   --SPND_LANG_TP_CD" ).append("\n"); 
		query.append("@[shpr_cust_nm],   --SHPR_CUST_NM" ).append("\n"); 
		query.append("@[shpr_fax_no],   --SHPR_FAX_NO" ).append("\n"); 
		query.append("@[prov_vndr_seq],   --PROV_VNDR_SEQ" ).append("\n"); 
		query.append("@[prov_usr_id],   --PROV_USR_ID" ).append("\n"); 
		query.append("@[prov_phn_no],   --PROV_PHN_NO" ).append("\n"); 
		query.append("@[prov_fax_no],   --PROV_FAX_NO" ).append("\n"); 
		query.append("@[prov_eml],   --PROV_EML" ).append("\n"); 
		query.append("@[prov_cfm_mzd_cd],   --PROV_CFM_MZD_CD" ).append("\n"); 
		query.append("'N'  			 , --DELT_FLG" ).append("\n"); 
		query.append("globaldate_pkg.time_local_ofc_fnc(@[vndr_seq])," ).append("\n"); 
		query.append("globaldate_pkg.time_local_ofc_fnc(@[vndr_seq])" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}