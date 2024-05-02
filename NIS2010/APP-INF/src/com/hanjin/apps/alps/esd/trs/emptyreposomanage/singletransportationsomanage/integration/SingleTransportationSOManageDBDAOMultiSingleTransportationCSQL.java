/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SingleTransportationSOManageDBDAOMultiSingleTransportationCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.13
*@LastModifier : 신동일
*@LastVersion : 1.0
* 2012.06.13 신동일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.emptyreposomanage.singletransportationsomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SHIN DONG IL
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SingleTransportationSOManageDBDAOMultiSingleTransportationCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EmptyRepo S/O를 입력
	  * </pre>
	  */
	public SingleTransportationSOManageDBDAOMultiSingleTransportationCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inter_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ref_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
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
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lse_cntr_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("lnk_dist_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ownr_co_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_cmb_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cbstatus",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_cmb_srt_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trsp_crr_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ttl_dist",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("conti_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ctrl_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eq_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.emptyreposomanage.singletransportationsomanage.integration").append("\n"); 
		query.append("FileName : SingleTransportationSOManageDBDAOMultiSingleTransportationCSQL").append("\n"); 
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
		query.append("INSERT INTO TRS_TRSP_SVC_ORD (" ).append("\n"); 
		query.append("TRSP_SO_OFC_CTY_CD," ).append("\n"); 
		query.append("TRSP_SO_SEQ," ).append("\n"); 
		query.append("FM_NOD_CD," ).append("\n"); 
		query.append("TO_NOD_CD," ).append("\n"); 
		query.append("EQ_NO," ).append("\n"); 
		query.append("EQ_TPSZ_CD," ).append("\n"); 
		query.append("TRSP_COST_DTL_MOD_CD," ).append("\n"); 
		query.append("TRSP_CRR_MOD_CD," ).append("\n"); 
		query.append("TRSP_SO_STS_CD," ).append("\n"); 
		query.append("TRSP_SO_TP_CD," ).append("\n"); 
		query.append("EQ_KND_CD," ).append("\n"); 
		query.append("CGO_TP_CD," ).append("\n"); 
		query.append("CONTI_CD ," ).append("\n"); 
		query.append("VSL_CD," ).append("\n"); 
		query.append("SKD_VOY_NO," ).append("\n"); 
		query.append("SKD_DIR_CD," ).append("\n"); 
		query.append("SLAN_CD," ).append("\n"); 
		query.append("OWNR_CO_CD," ).append("\n"); 
		query.append("REPO_PLN_ID," ).append("\n"); 
		query.append("PLN_YRWK," ).append("\n"); 
		query.append("REF_ID," ).append("\n"); 
		query.append("REF_SEQ," ).append("\n"); 
		query.append("TRSP_MTY_RQST_DT," ).append("\n"); 
		query.append("INTER_RMK," ).append("\n"); 
		query.append("CRE_OFC_CD," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("UPD_DT," ).append("\n"); 
		query.append("LOCL_CRE_DT," ).append("\n"); 
		query.append("LOCL_UPD_DT," ).append("\n"); 
		query.append("TRSP_MTY_COST_MOD_CD," ).append("\n"); 
		query.append("TRSP_SO_CMB_TP_CD," ).append("\n"); 
		query.append("LSE_CNTR_FLG," ).append("\n"); 
		query.append("#if( ${cbstatus} == 'CF' )" ).append("\n"); 
		query.append("TRSP_SO_CMB_SEQ," ).append("\n"); 
		query.append("CMB_SO_RLT_STS_FLG," ).append("\n"); 
		query.append("TRSP_SO_CMB_SRT_NO," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("DELT_FLG," ).append("\n"); 
		query.append("TTL_DIST," ).append("\n"); 
		query.append("LNK_DIST_DIV_CD" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("@[trsp_so_ofc_cty_cd],						--TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("@[trsp_so_seq],							--TRSP_SO_SEQ" ).append("\n"); 
		query.append("@[fm_nod_cd],							--FM_NOD_CD" ).append("\n"); 
		query.append("@[to_nod_cd],							--TO_NOD_CD" ).append("\n"); 
		query.append("@[eq_no],							--EQ_NO" ).append("\n"); 
		query.append("@[eq_tpsz_cd],							--EQ_TPSZ_CD" ).append("\n"); 
		query.append("@[trsp_mty_cost_mod_cd],					--TRSP_COST_DTL_MOD_CD" ).append("\n"); 
		query.append("@[trsp_crr_mod_cd],						--TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append("'C',								--TRSP_SO_STS_CD : C" ).append("\n"); 
		query.append("'M',								--TRSP_SO_TP_CD" ).append("\n"); 
		query.append("'U',								--EQ_KND_CD" ).append("\n"); 
		query.append("'M',								--CGO_TP_CD" ).append("\n"); 
		query.append("@[conti_cd],							--   conti_cd  추가. 2008.01.14" ).append("\n"); 
		query.append("@[vsl_cd],							--VSL_CD" ).append("\n"); 
		query.append("@[skd_voy_no],							--SKD_VOY_NO" ).append("\n"); 
		query.append("@[skd_dir_cd],							--SKD_DIR_CD" ).append("\n"); 
		query.append("@[slan_cd],							--SLAN_CD" ).append("\n"); 
		query.append("@[ownr_co_cd],							--OWNR_CO_CD" ).append("\n"); 
		query.append("@[repo_pln_id],							--REPO_PLN_ID" ).append("\n"); 
		query.append("@[pln_yrwk],							--PLN_YRWK" ).append("\n"); 
		query.append("@[ref_id],							--REF_ID" ).append("\n"); 
		query.append("@[ref_seq],							--REF_SEQ" ).append("\n"); 
		query.append("TO_DATE(@[trsp_mty_rqst_dt], 'YYYYMMDD'),  --TRSP_MTY_RQST_DT" ).append("\n"); 
		query.append("@[inter_rmk],							--INTER_RMK" ).append("\n"); 
		query.append("@[ctrl_ofc_cd],						--CRE_OFC_CD" ).append("\n"); 
		query.append("@[cre_usr_id],							--CRE_USR_ID" ).append("\n"); 
		query.append("SYSDATE,							--CRE_DT" ).append("\n"); 
		query.append("@[upd_usr_id],							--UPD_USR_ID" ).append("\n"); 
		query.append("SYSDATE,							--UPD_DT" ).append("\n"); 
		query.append("GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ctrl_ofc_cd]),		--LOCL_CRE_DT" ).append("\n"); 
		query.append("GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ctrl_ofc_cd]),		--LOCL_UPD_DT" ).append("\n"); 
		query.append("@[trsp_mty_cost_mod_cd],					--TRSP_MTY_COST_MOD_CD" ).append("\n"); 
		query.append("@[cbstatus],							--TRSP_SO_CMB_TP_CD" ).append("\n"); 
		query.append("@[lse_cntr_flg],										--LSE_CNTR_FLG" ).append("\n"); 
		query.append("#if( ${cbstatus} == 'CF' )" ).append("\n"); 
		query.append("@[trsp_so_cmb_seq],						--TRSP_SO_CMB_SEQ   cmbSeq.substring(0,1)" ).append("\n"); 
		query.append("'F',								--CMB_SO_RLT_STS_FLG" ).append("\n"); 
		query.append("@[trsp_so_cmb_srt_no],					--TRSP_SO_CMB_SRT_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("'N'," ).append("\n"); 
		query.append("@[ttl_dist]," ).append("\n"); 
		query.append("@[lnk_dist_div_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}