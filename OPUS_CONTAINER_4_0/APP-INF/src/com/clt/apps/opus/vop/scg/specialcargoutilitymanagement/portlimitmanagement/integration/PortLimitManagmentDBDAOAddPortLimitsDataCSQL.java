/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PortLimitManagmentDBDAOAddPortLimitsDataCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.27
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.27 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.portlimitmanagement.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortLimitManagmentDBDAOAddPortLimitsDataCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Port별 Lane & Entry Typr & IMDG & Weight & Property 정보를 입력 후 Data를 생성한다.
	  * </pre>
	  */
	public PortLimitManagmentDBDAOAddPortLimitsDataCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_lmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_pck_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flsh_pnt_temp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dchg_max_teu_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("arr_dep_prohi_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dp_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_lmt_rep_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lod_max_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dchg_max_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("arr_max_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ppt_explo_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ldis_aply_tgt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dep_max_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ppt_prohi_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_lmt_sub_ppt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lod_max_teu_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pier_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lmt_wgt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.portlimitmanagement.integration").append("\n"); 
		query.append("FileName : PortLimitManagmentDBDAOAddPortLimitsDataCSQL").append("\n"); 
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
		query.append("INSERT INTO SCG_IMDG_PORT_LMT_MST(" ).append("\n"); 
		query.append("	 PORT_CD" ).append("\n"); 
		query.append("	,LMT_WGT_TP_CD" ).append("\n"); 
		query.append("	,PORT_LMT_SEQ" ).append("\n"); 
		query.append("	,PIER_TP_CD" ).append("\n"); 
		query.append("	,PORT_LMT_REP_DESC" ).append("\n"); 
		query.append("	--,IMDG_SUBS_RSK_LBL_CD" ).append("\n"); 
		query.append("	,IMDG_PCK_GRP_CD" ).append("\n"); 
		query.append("	,FLSH_PNT_TEMP" ).append("\n"); 
		query.append("	,PORT_LMT_SUB_PPT_CD" ).append("\n"); 
		query.append("	,CNTR_TP_CD" ).append("\n"); 
		query.append("	,CMDT_CD" ).append("\n"); 
		query.append("	,ARR_DEP_PROHI_FLG" ).append("\n"); 
		query.append("	,LDIS_APLY_TGT_FLG" ).append("\n"); 
		query.append("	,ARR_MAX_QTY" ).append("\n"); 
		query.append("	,LOD_MAX_QTY" ).append("\n"); 
		query.append("	,DCHG_MAX_QTY" ).append("\n"); 
		query.append("	,DEP_MAX_QTY" ).append("\n"); 
		query.append("	,PPT_EXPLO_FLG" ).append("\n"); 
		query.append("	,PPT_PROHI_FLG" ).append("\n"); 
		query.append("	,DP_SEQ" ).append("\n"); 
		query.append("	,CRE_OFC_CD" ).append("\n"); 
		query.append("	,UPD_OFC_CD" ).append("\n"); 
		query.append("	,CRE_USR_ID" ).append("\n"); 
		query.append("	,CRE_DT" ).append("\n"); 
		query.append("	,UPD_USR_ID" ).append("\n"); 
		query.append("	,UPD_DT" ).append("\n"); 
		query.append("    ,YD_CD" ).append("\n"); 
		query.append("	,LOD_MAX_TEU_QTY" ).append("\n"); 
		query.append("	,DCHG_MAX_TEU_QTY" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("	 @[port_cd]" ).append("\n"); 
		query.append("	,@[lmt_wgt_tp_cd]" ).append("\n"); 
		query.append("#if (${port_lmt_seq} != '') " ).append("\n"); 
		query.append("	,@[port_lmt_seq]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	,(SELECT NVL(MAX(PORT_LMT_SEQ), 0)+1" ).append("\n"); 
		query.append("        FROM SCG_IMDG_PORT_LMT_MST" ).append("\n"); 
		query.append("       WHERE PORT_CD = port_cd" ).append("\n"); 
		query.append("         AND LMT_WGT_TP_CD = lmt_wgt_tp_cd" ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	,NVL(@[pier_tp_cd],'C1')" ).append("\n"); 
		query.append("	,@[port_lmt_rep_desc]" ).append("\n"); 
		query.append("	--,imdg_subs_rsk_lbl_cd" ).append("\n"); 
		query.append("	,@[imdg_pck_grp_cd]" ).append("\n"); 
		query.append("	,@[flsh_pnt_temp]" ).append("\n"); 
		query.append("	,@[port_lmt_sub_ppt_cd]" ).append("\n"); 
		query.append("	,@[cntr_tp_cd]" ).append("\n"); 
		query.append("	,@[cmdt_cd]" ).append("\n"); 
		query.append("	,DECODE(@[arr_dep_prohi_flg], '0', 'N', 1, 'Y', @[arr_dep_prohi_flg])" ).append("\n"); 
		query.append("	,DECODE(@[ldis_aply_tgt_flg], '0', 'N', 1, 'Y', @[ldis_aply_tgt_flg])" ).append("\n"); 
		query.append("	,@[arr_max_qty]" ).append("\n"); 
		query.append("	,@[lod_max_qty]" ).append("\n"); 
		query.append("	,@[dchg_max_qty]" ).append("\n"); 
		query.append("	,@[dep_max_qty]" ).append("\n"); 
		query.append("	,DECODE(@[ppt_explo_flg], '0', 'N', 1, 'Y', @[ppt_explo_flg])" ).append("\n"); 
		query.append("	,DECODE(@[ppt_prohi_flg], '0', 'N', 1, 'Y', @[ppt_prohi_flg])" ).append("\n"); 
		query.append("	,@[dp_seq]" ).append("\n"); 
		query.append("	,@[cre_ofc_cd]" ).append("\n"); 
		query.append("	,@[upd_ofc_cd]" ).append("\n"); 
		query.append("	,@[cre_usr_id]" ).append("\n"); 
		query.append("	,sysdate" ).append("\n"); 
		query.append("	,@[upd_usr_id]" ).append("\n"); 
		query.append("	,sysdate" ).append("\n"); 
		query.append("    ,@[yd_cd]" ).append("\n"); 
		query.append("    ,@[lod_max_teu_qty]" ).append("\n"); 
		query.append("    ,@[dchg_max_teu_qty]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}