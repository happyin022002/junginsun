/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KrWharfageDecMgtDBDAOmergeBkgKrWhfBlCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.24
*@LastModifier : 민동진
*@LastVersion : 1.0
* 2009.11.24 민동진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Min, DongJin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KrWharfageDecMgtDBDAOmergeBkgKrWhfBlCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * m
	  * </pre>
	  */
	public KrWharfageDecMgtDBDAOmergeBkgKrWhfBlCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("meas_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ob_sls_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amount",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("meas_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("whf_bl_thru_ts_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("option_w",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("revenue",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("de_term_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wgt_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pck_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pck_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
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
		params.put("por_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("whf_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.integration").append("\n"); 
		query.append("FileName : KrWharfageDecMgtDBDAOmergeBkgKrWhfBlCSQL").append("\n"); 
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
		query.append("MERGE INTO BKG_KR_WHF_BL" ).append("\n"); 
		query.append("USING DUAL" ).append("\n"); 
		query.append("ON (    VSL_CD     = @[vsl_cd]" ).append("\n"); 
		query.append("AND SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("AND SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND BL_NO      = @[bl_no]" ).append("\n"); 
		query.append("AND WHF_BND_CD = @[whf_bnd_cd] )" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE SET" ).append("\n"); 
		query.append("BKG_NO               = @[bkg_no]" ).append("\n"); 
		query.append(",POL_CD              = @[pol_cd]" ).append("\n"); 
		query.append(",POD_CD              = @[pod_cd]" ).append("\n"); 
		query.append(",POR_CD              = @[por_cd]" ).append("\n"); 
		query.append(",DEL_CD              = @[del_cd]" ).append("\n"); 
		query.append(",WHF_BL_STS_CD       = DECODE(@[bkg_sts_cd],'X', 'D', 'I')" ).append("\n"); 
		query.append(",RCV_TERM_CD         = @[rcv_term_cd]" ).append("\n"); 
		query.append(",DE_TERM_CD          = @[de_term_cd]" ).append("\n"); 
		query.append(",WHF_POL_CD          = DECODE( SUBSTR(@[whf_bnd_cd], 1, 1), 'O', @[port_cd], ''  )" ).append("\n"); 
		query.append(",WHF_POD_CD          = DECODE( SUBSTR(@[whf_bnd_cd], 1, 1), 'I', @[port_cd], ''  )" ).append("\n"); 
		query.append(",PCK_QTY             = @[pck_qty]" ).append("\n"); 
		query.append(",PCK_TP_CD           = @[pck_tp_cd]" ).append("\n"); 
		query.append(",WGT_QTY             = @[act_wgt]" ).append("\n"); 
		query.append(",WGT_UT_CD           = @[wgt_ut_cd]" ).append("\n"); 
		query.append(",MEAS_QTY            = @[meas_qty]" ).append("\n"); 
		query.append(",MEAS_UT_CD          = @[meas_ut_cd]" ).append("\n"); 
		query.append(",RTON_WGT            = @[revenue]" ).append("\n"); 
		query.append(",WHF_AMT             = DECODE(@[option_w],@[skd_dir_cd],(SELECT NVL(WHF_AMT,0)" ).append("\n"); 
		query.append("FROM BKG_KR_WHF_BL" ).append("\n"); 
		query.append("WHERE BL_NO       = @[bl_no]" ).append("\n"); 
		query.append("AND VSL_CD        = @[vsl_cd]" ).append("\n"); 
		query.append("AND SKD_VOY_NO    = @[skd_voy_no]" ).append("\n"); 
		query.append("AND SKD_DIR_cd    = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND WHF_BND_CD     = @[whf_bnd_cd])" ).append("\n"); 
		query.append(",0)" ).append("\n"); 
		query.append(",WHF_BL_ADD_RSN_CD   = DECODE( (@[vsl_cd]  || @[skd_voy_no] || @[skd_dir_cd]), (@[bkg_vsl_cd]  || @[bkg_skd_voy_no] || @[bkg_skd_dir_cd]), 'A', 'C' )" ).append("\n"); 
		query.append(",WHF_BL_THRU_TS_FLG  = @[whf_bl_thru_ts_flg]" ).append("\n"); 
		query.append(",WHF_BL_CGO_TP_CD    = @[bkg_cgo_tp_cd]" ).append("\n"); 
		query.append(",SLS_OFC_CD          = @[ob_sls_ofc_cd]" ).append("\n"); 
		query.append(",RLANE_CD            = @[slan_cd]" ).append("\n"); 
		query.append(",UPD_USR_ID          = @[upd_usr_id]" ).append("\n"); 
		query.append(",UPD_DT              = SYSDATE" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("VSL_CD" ).append("\n"); 
		query.append(",SKD_VOY_NO" ).append("\n"); 
		query.append(",SKD_DIR_CD" ).append("\n"); 
		query.append(",WHF_BND_CD" ).append("\n"); 
		query.append(",BL_NO" ).append("\n"); 
		query.append(",BKG_NO" ).append("\n"); 
		query.append(",POL_CD" ).append("\n"); 
		query.append(",POD_CD" ).append("\n"); 
		query.append(",POR_CD" ).append("\n"); 
		query.append(",DEL_CD" ).append("\n"); 
		query.append(",WHF_BL_STS_CD" ).append("\n"); 
		query.append(",RCV_TERM_CD" ).append("\n"); 
		query.append(",DE_TERM_CD" ).append("\n"); 
		query.append(",WHF_POL_CD" ).append("\n"); 
		query.append(",WHF_POD_CD" ).append("\n"); 
		query.append(",PCK_QTY" ).append("\n"); 
		query.append(",PCK_TP_CD" ).append("\n"); 
		query.append(",WGT_QTY" ).append("\n"); 
		query.append(",WGT_UT_CD" ).append("\n"); 
		query.append(",MEAS_QTY" ).append("\n"); 
		query.append(",MEAS_UT_CD" ).append("\n"); 
		query.append(",RTON_WGT" ).append("\n"); 
		query.append(",WHF_AMT" ).append("\n"); 
		query.append(",WHF_BL_ADD_RSN_CD" ).append("\n"); 
		query.append(",WHF_BL_THRU_TS_FLG" ).append("\n"); 
		query.append(",WHF_BL_CGO_TP_CD" ).append("\n"); 
		query.append(",WFG_EXPT_CD" ).append("\n"); 
		query.append(",SLS_OFC_CD" ).append("\n"); 
		query.append(",RLANE_CD" ).append("\n"); 
		query.append(",CSTMS_DECL_TP_CD" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES (" ).append("\n"); 
		query.append("@[vsl_cd]" ).append("\n"); 
		query.append(",@[skd_voy_no]" ).append("\n"); 
		query.append(",@[skd_dir_cd]" ).append("\n"); 
		query.append(",@[whf_bnd_cd]" ).append("\n"); 
		query.append(",@[bl_no]" ).append("\n"); 
		query.append(",@[bkg_no]" ).append("\n"); 
		query.append(",@[pol_cd]" ).append("\n"); 
		query.append(",@[pod_cd]" ).append("\n"); 
		query.append(",@[por_cd]" ).append("\n"); 
		query.append(",@[del_cd]" ).append("\n"); 
		query.append(",DECODE(@[bkg_sts_cd],'X', 'D', 'I')" ).append("\n"); 
		query.append(",@[rcv_term_cd]" ).append("\n"); 
		query.append(",@[de_term_cd]" ).append("\n"); 
		query.append(",DECODE( SUBSTR(@[whf_bnd_cd], 1, 1), 'O', @[port_cd], '' )" ).append("\n"); 
		query.append(",DECODE( SUBSTR(@[whf_bnd_cd], 1, 1), 'I', @[port_cd], '' )" ).append("\n"); 
		query.append(",@[pck_qty]" ).append("\n"); 
		query.append(",@[pck_tp_cd]" ).append("\n"); 
		query.append(",@[act_wgt]" ).append("\n"); 
		query.append(",@[wgt_ut_cd]" ).append("\n"); 
		query.append(",@[meas_qty]" ).append("\n"); 
		query.append(",@[meas_ut_cd]" ).append("\n"); 
		query.append(",@[revenue]" ).append("\n"); 
		query.append(",DECODE(@[option_w], @[skd_dir_cd], @[amount],0)" ).append("\n"); 
		query.append(",DECODE( (@[vsl_cd]  || @[skd_voy_no] || @[skd_dir_cd]), (@[bkg_vsl_cd]  || @[bkg_skd_voy_no] || @[bkg_skd_dir_cd]), 'A', 'C' )" ).append("\n"); 
		query.append(",@[whf_bl_thru_ts_flg]" ).append("\n"); 
		query.append(",@[bkg_cgo_tp_cd]" ).append("\n"); 
		query.append(",NULL" ).append("\n"); 
		query.append(",@[ob_sls_ofc_cd]" ).append("\n"); 
		query.append(",@[slan_cd]" ).append("\n"); 
		query.append(",CASE WHEN @[whf_bnd_cd] = 'OO' THEN 'E'" ).append("\n"); 
		query.append("WHEN @[whf_bnd_cd] = 'OT' THEN 'R'" ).append("\n"); 
		query.append("WHEN @[whf_bnd_cd] = 'II' THEN 'I'" ).append("\n"); 
		query.append("WHEN @[whf_bnd_cd] = 'IT' THEN 'T'" ).append("\n"); 
		query.append("ELSE NULL" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append(",@[cre_usr_id]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(",@[upd_usr_id]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}