/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PortLimitManagmentDBDAOModifyPortLimitsDataUSQL.java
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

public class PortLimitManagmentDBDAOModifyPortLimitsDataUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Port별 Lane & Entry Typr & IMDG & Weight & Property 정보를 변경 후 Data를 수정한다.
	  * </pre>
	  */
	public PortLimitManagmentDBDAOModifyPortLimitsDataUSQL(){
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
		params.put("dchg_max_teu_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : PortLimitManagmentDBDAOModifyPortLimitsDataUSQL").append("\n"); 
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
		query.append("UPDATE SCG_IMDG_PORT_LMT_MST" ).append("\n"); 
		query.append("    SET      LMT_WGT_TP_CD 		  = @[lmt_wgt_tp_cd]" ).append("\n"); 
		query.append("			,PIER_TP_CD		      = NVL(@[pier_tp_cd],'C1')" ).append("\n"); 
		query.append("			,PORT_LMT_REP_DESC    = @[port_lmt_rep_desc]" ).append("\n"); 
		query.append("			--,IMDG_SUBS_RSK_LBL_CD = imdg_subs_rsk_lbl_cd" ).append("\n"); 
		query.append("			,IMDG_PCK_GRP_CD      = @[imdg_pck_grp_cd]" ).append("\n"); 
		query.append("			,FLSH_PNT_TEMP        = @[flsh_pnt_temp]" ).append("\n"); 
		query.append("			,PORT_LMT_SUB_PPT_CD  = @[port_lmt_sub_ppt_cd]" ).append("\n"); 
		query.append("			,CNTR_TP_CD           = @[cntr_tp_cd]" ).append("\n"); 
		query.append("			,CMDT_CD              = @[cmdt_cd]" ).append("\n"); 
		query.append("			,ARR_DEP_PROHI_FLG    = DECODE(@[arr_dep_prohi_flg], '0', 'N', 1, 'Y', @[arr_dep_prohi_flg])" ).append("\n"); 
		query.append("			,LDIS_APLY_TGT_FLG    = DECODE(@[ldis_aply_tgt_flg], '0', 'N', 1, 'Y', @[ldis_aply_tgt_flg])" ).append("\n"); 
		query.append("			,ARR_MAX_QTY          = @[arr_max_qty]" ).append("\n"); 
		query.append("			,LOD_MAX_QTY          = @[lod_max_qty]" ).append("\n"); 
		query.append("			,DCHG_MAX_QTY         = @[dchg_max_qty]" ).append("\n"); 
		query.append("			,DEP_MAX_QTY          = @[dep_max_qty]" ).append("\n"); 
		query.append("			,PPT_EXPLO_FLG        = DECODE(@[ppt_explo_flg], '0', 'N', 1, 'Y', @[ppt_explo_flg])" ).append("\n"); 
		query.append("			,PPT_PROHI_FLG        = DECODE(@[ppt_prohi_flg], '0', 'N', 1, 'Y', @[ppt_prohi_flg])" ).append("\n"); 
		query.append("			,DP_SEQ               = @[dp_seq]" ).append("\n"); 
		query.append("			,CRE_OFC_CD           = @[cre_ofc_cd]" ).append("\n"); 
		query.append("			,UPD_OFC_CD           = @[upd_ofc_cd]" ).append("\n"); 
		query.append("			,UPD_USR_ID           = @[upd_usr_id]" ).append("\n"); 
		query.append("			,UPD_DT               = SYSDATE" ).append("\n"); 
		query.append("            ,YD_CD                = @[yd_cd]" ).append("\n"); 
		query.append("	        ,LOD_MAX_TEU_QTY      = @[lod_max_teu_qty]" ).append("\n"); 
		query.append("	        ,DCHG_MAX_TEU_QTY     = @[dchg_max_teu_qty]" ).append("\n"); 
		query.append("WHERE PORT_CD = @[port_cd]" ).append("\n"); 
		query.append("  AND PORT_LMT_SEQ = @[port_lmt_seq]" ).append("\n"); 

	}
}