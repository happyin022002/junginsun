/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BLDocumentationCMDBDAOContainerUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.10.21
*@LastModifier : 
*@LastVersion : 1.0
* 2016.10.21 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationCMDBDAOContainerUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * update
	  * </pre>
	  */
	public BLDocumentationCMDBDAOContainerUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_vol_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("adv_shtg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_prt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_wgt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cgo_rcv_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hngr_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pck_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_subst_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_dp_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pck_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_cfm_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("meas_qty",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationCMDBDAOContainerUSQL").append("\n"); 
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
		query.append("#if (${ca_flg} == 'Y') " ).append("\n"); 
		query.append("UPDATE BKG_CNTR_HIS " ).append("\n"); 
		query.append("SET    PCK_TP_CD        = @[pck_tp_cd]" ).append("\n"); 
		query.append(",      PCK_QTY          = @[pck_qty]" ).append("\n"); 
		query.append(",      CNTR_WGT         = @[cntr_wgt]" ).append("\n"); 
		query.append(",      WGT_UT_CD        = @[wgt_ut_cd]" ).append("\n"); 
		query.append(",      MEAS_QTY         = @[meas_qty]" ).append("\n"); 
		query.append(",      MEAS_UT_CD       = @[meas_ut_cd]" ).append("\n"); 
		query.append(",      CNTR_PRT_FLG     = DECODE(@[cntr_prt_flg], '1', 'Y', 'Y', 'Y', 'N')" ).append("\n"); 
		query.append("#if (${ui_num} != 'ESM_BKG_0229') " ).append("\n"); 
		query.append(",	   CNTR_TPSZ_CD     = @[cntr_tpsz_cd]" ).append("\n"); 
		query.append(",      CNTR_DP_SEQ      = @[cntr_dp_seq]" ).append("\n"); 
		query.append(",      RCV_TERM_CD      = @[rcv_term_cd]" ).append("\n"); 
		query.append(",      DE_TERM_CD       = @[de_term_cd]" ).append("\n"); 
		query.append(",      ORG_YD_CD        = @[org_yd_cd]" ).append("\n"); 
		query.append(",      CNTR_VOL_QTY     = @[cntr_vol_qty]" ).append("\n"); 
		query.append(",      ADV_SHTG_CD      = @[adv_shtg_cd]" ).append("\n"); 
		query.append(",      HNGR_FLG         = DECODE(@[hngr_flg], '1', 'Y', 'Y', 'Y', 'N')" ).append("\n"); 
		query.append(",      EQ_SUBST_TPSZ_CD = @[eq_subst_tpsz_cd]" ).append("\n"); 
		query.append(",      CGO_RCV_DT       = TO_DATE(@[cgo_rcv_dt], 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append(",      DIFF_RMK         = @[diff_rmk]" ).append("\n"); 
		query.append(",      CNTR_CFM_FLG     = DECODE(@[cntr_cfm_flg], '1', 'Y', 'Y', 'Y', 'N')" ).append("\n"); 
		query.append(",      CNTR_DELT_FLG    = 'N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",      UPD_USR_ID       = @[upd_usr_id]" ).append("\n"); 
		query.append(",      UPD_DT           = sysdate    " ).append("\n"); 
		query.append("WHERE  BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND    CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("AND	   CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("UPDATE BKG_CONTAINER SET" ).append("\n"); 
		query.append("      PCK_TP_CD        = @[pck_tp_cd]" ).append("\n"); 
		query.append(",      PCK_QTY          = @[pck_qty]" ).append("\n"); 
		query.append(",      CNTR_WGT         = @[cntr_wgt]" ).append("\n"); 
		query.append(",      WGT_UT_CD        = @[wgt_ut_cd]" ).append("\n"); 
		query.append(",      MEAS_QTY         = @[meas_qty]" ).append("\n"); 
		query.append(",      MEAS_UT_CD       = @[meas_ut_cd]" ).append("\n"); 
		query.append(",    CNTR_PRT_FLG     = DECODE(@[cntr_prt_flg], '1', 'Y', 'Y', 'Y', 'N')" ).append("\n"); 
		query.append("#if (${ui_num} != 'ESM_BKG_0229') " ).append("\n"); 
		query.append(",    CNTR_TPSZ_CD     = @[cntr_tpsz_cd]" ).append("\n"); 
		query.append(",    CNTR_DP_SEQ      = @[cntr_dp_seq]" ).append("\n"); 
		query.append(",    RCV_TERM_CD      = @[rcv_term_cd]" ).append("\n"); 
		query.append(",    DE_TERM_CD       = @[de_term_cd]" ).append("\n"); 
		query.append(",    ORG_YD_CD        = @[org_yd_cd]" ).append("\n"); 
		query.append(",    CNTR_VOL_QTY     = @[cntr_vol_qty]" ).append("\n"); 
		query.append(",    ADV_SHTG_CD      = @[adv_shtg_cd]" ).append("\n"); 
		query.append(",    HNGR_FLG         = DECODE(@[hngr_flg], '1', 'Y', 'Y', 'Y', 'N')" ).append("\n"); 
		query.append(",    EQ_SUBST_TPSZ_CD = @[eq_subst_tpsz_cd]" ).append("\n"); 
		query.append(",    CGO_RCV_DT       = TO_DATE(@[cgo_rcv_dt], 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append(",    DO_NO            = @[do_no]" ).append("\n"); 
		query.append(",    DIFF_RMK         = @[diff_rmk]" ).append("\n"); 
		query.append(",    CNTR_CFM_FLG     = DECODE(@[cntr_cfm_flg], '1', 'Y', 'Y', 'Y', 'N')" ).append("\n"); 
		query.append(",    CNTR_DELT_FLG    = 'N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",   UPD_USR_ID       = @[upd_usr_id]" ).append("\n"); 
		query.append(",   UPD_DT           = sysdate " ).append("\n"); 
		query.append("WHERE	BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND	CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}