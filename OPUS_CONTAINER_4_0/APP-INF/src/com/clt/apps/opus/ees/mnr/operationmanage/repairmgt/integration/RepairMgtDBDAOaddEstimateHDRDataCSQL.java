/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : RepairMgtDBDAOaddEstimateHDRDataCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.21
*@LastModifier : 박광석
*@LastVersion : 1.0
* 2014.11.21 박광석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author PARK KWANG SEOK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RepairMgtDBDAOaddEstimateHDRDataCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * addEstimateHDRData
	  * </pre>
	  */
	public RepairMgtDBDAOaddEstimateHDRDataCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpr_rslt_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mvmt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("apro_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpr_wrk_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("apro_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpr_dtl_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpr_rqst_tmp_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_agmt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_rpr_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("file_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_ord_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpr_rqst_lst_ver_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_meas_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpr_rqst_ver_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rqst_eq_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_ord_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3pty_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("apro_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_edi_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rpr_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("disp_dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpr_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3pty_bil_ttl_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("if_trc_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("disp_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_wrk_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpr_offh_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("disp_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_inp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_dmg_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_dmg_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpr_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.integration").append("\n"); 
		query.append("FileName : RepairMgtDBDAOaddEstimateHDRDataCSQL").append("\n"); 
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
		query.append("INSERT INTO MNR_RPR_RQST_HDR(" ).append("\n"); 
		query.append("         RQST_EQ_NO" ).append("\n"); 
		query.append("        ,RPR_RQST_SEQ" ).append("\n"); 
		query.append("        ,RPR_RQST_VER_NO" ).append("\n"); 
		query.append("        ,RPR_RQST_LST_VER_FLG" ).append("\n"); 
		query.append("        ,EQ_KND_CD" ).append("\n"); 
		query.append("        ,EQ_TPSZ_CD" ).append("\n"); 
		query.append("        ,VNDR_SEQ" ).append("\n"); 
		query.append("        ,RPR_STS_CD" ).append("\n"); 
		query.append("        ,RPR_DTL_STS_CD" ).append("\n"); 
		query.append("        ,RQST_REF_NO" ).append("\n"); 
		query.append("        ,MNR_INP_TP_CD" ).append("\n"); 
		query.append("        ,COST_OFC_CD" ).append("\n"); 
		query.append("        ,RQST_DT" ).append("\n"); 
		query.append("        ,RQST_USR_ID" ).append("\n"); 
		query.append("        ,MNR_MEAS_UT_CD" ).append("\n"); 
		query.append("        ,APRO_OFC_CD" ).append("\n"); 
		query.append("        ,APRO_DT" ).append("\n"); 
		query.append("        ,APRO_USR_ID" ).append("\n"); 
		query.append("        ,RPR_OFFH_FLG" ).append("\n"); 
		query.append("        ,RPR_RSLT_DT" ).append("\n"); 
		query.append("        ,CURR_CD" ).append("\n"); 
		query.append("        ,RPR_YD_CD" ).append("\n"); 
		query.append("        ,EQ_DMG_DT" ).append("\n"); 
		query.append("        ,EQ_DMG_TP_CD" ).append("\n"); 
		query.append("        ,RPR_WRK_TP_CD" ).append("\n"); 
		query.append("        ,MNR_EDI_NM" ).append("\n"); 
		query.append("        ,N3PTY_FLG" ).append("\n"); 
		query.append("        ,IF_TRC_SEQ" ).append("\n"); 
		query.append("        ,MNR_AGMT_AMT" ).append("\n"); 
		query.append("        ,MNR_WRK_AMT" ).append("\n"); 
		query.append("        ,N3PTY_BIL_TTL_AMT" ).append("\n"); 
		query.append("        ,DISP_FLG" ).append("\n"); 
		query.append("        ,DISP_NO" ).append("\n"); 
		query.append("        ,DISP_DTL_SEQ" ).append("\n"); 
		query.append("        ,FILE_SEQ" ).append("\n"); 
		query.append("        ,MNR_RPR_RMK" ).append("\n"); 
		query.append("        ,EDI_ID" ).append("\n"); 
		query.append("        ,MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("        ,MNR_ORD_SEQ" ).append("\n"); 
		query.append("        ,AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("        ,AGMT_SEQ" ).append("\n"); 
		query.append("        ,AGMT_VER_NO" ).append("\n"); 
		query.append("        ,RPR_RQST_TMP_SEQ" ).append("\n"); 
		query.append("        ,MNR_WARR_FLG" ).append("\n"); 
		query.append("        ,CRE_USR_ID" ).append("\n"); 
		query.append("        ,CRE_DT" ).append("\n"); 
		query.append("        ,UPD_USR_ID" ).append("\n"); 
		query.append("        ,UPD_DT" ).append("\n"); 
		query.append("		,MVMT_GATE_IN_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("select  	@[rqst_eq_no]" ).append("\n"); 
		query.append("           ,@[rpr_rqst_seq]" ).append("\n"); 
		query.append("           ,@[rpr_rqst_ver_no]" ).append("\n"); 
		query.append("           ,@[rpr_rqst_lst_ver_flg]" ).append("\n"); 
		query.append("           ,EQ_TYPE" ).append("\n"); 
		query.append("           ,EQ_TPSZ_CD" ).append("\n"); 
		query.append("           ,TO_NUMBER(@[vndr_seq])" ).append("\n"); 
		query.append("           ,@[rpr_sts_cd]" ).append("\n"); 
		query.append("           ,@[rpr_dtl_sts_cd]" ).append("\n"); 
		query.append("           ,@[rqst_ref_no]" ).append("\n"); 
		query.append("           ,@[mnr_inp_tp_cd]" ).append("\n"); 
		query.append("           ,@[cost_ofc_cd]" ).append("\n"); 
		query.append("           ,TO_DATE(@[rqst_dt], 'yyyy-mm-dd')" ).append("\n"); 
		query.append("           ,@[rqst_usr_id]" ).append("\n"); 
		query.append("           ,@[mnr_meas_ut_cd]" ).append("\n"); 
		query.append("           ,@[apro_ofc_cd]" ).append("\n"); 
		query.append("           ,TO_DATE(@[apro_dt], 'yyyy-mm-dd')" ).append("\n"); 
		query.append("           ,@[apro_usr_id]" ).append("\n"); 
		query.append("           ,@[rpr_offh_flg]" ).append("\n"); 
		query.append("           ,TO_DATE(@[rpr_rslt_dt], 'yyyy-mm-dd')" ).append("\n"); 
		query.append("           ,@[curr_cd]" ).append("\n"); 
		query.append("           ,@[rpr_yd_cd]" ).append("\n"); 
		query.append("           ,TO_DATE(@[eq_dmg_dt], 'yyyy-mm-dd')" ).append("\n"); 
		query.append("           ,@[eq_dmg_tp_cd]" ).append("\n"); 
		query.append("           ,@[rpr_wrk_tp_cd]" ).append("\n"); 
		query.append("           ,@[mnr_edi_nm]" ).append("\n"); 
		query.append("           ,@[n3pty_flg]" ).append("\n"); 
		query.append("           ,@[if_trc_seq]" ).append("\n"); 
		query.append("           ,@[mnr_agmt_amt]" ).append("\n"); 
		query.append("           ,@[mnr_wrk_amt]" ).append("\n"); 
		query.append("           ,@[n3pty_bil_ttl_amt]" ).append("\n"); 
		query.append("           ,@[disp_flg]" ).append("\n"); 
		query.append("           ,@[disp_no]" ).append("\n"); 
		query.append("           ,@[disp_dtl_seq]" ).append("\n"); 
		query.append("           ,@[file_seq]" ).append("\n"); 
		query.append("           ,@[mnr_rpr_rmk]" ).append("\n"); 
		query.append("           ,@[edi_id]" ).append("\n"); 
		query.append("           ,@[mnr_ord_ofc_cty_cd]" ).append("\n"); 
		query.append("           ,@[mnr_ord_seq]" ).append("\n"); 
		query.append("           ,@[agmt_ofc_cty_cd]" ).append("\n"); 
		query.append("           ,@[agmt_seq]" ).append("\n"); 
		query.append("           ,@[agmt_ver_no]" ).append("\n"); 
		query.append("           ,@[rpr_rqst_tmp_seq]" ).append("\n"); 
		query.append("           ,DECODE(" ).append("\n"); 
		query.append("			(SELECT COUNT(*)" ).append("\n"); 
		query.append("				FROM MNR_EQ_RNG_STS A" ).append("\n"); 
		query.append("				WHERE " ).append("\n"); 
		query.append("  					A.MNR_GRP_TP_CD = 'RPR'" ).append("\n"); 
		query.append("  					AND SUBSTRB(@[rqst_eq_no],1,4) = A.LOT_EQ_PFX_CD " ).append("\n"); 
		query.append("  					AND A.FM_SER_NO <= SUBSTRB(@[rqst_eq_no],5,LENGTH(@[rqst_eq_no]) -1)" ).append("\n"); 
		query.append("  					AND A.TO_SER_NO >= SUBSTRB(@[rqst_eq_no],5,LENGTH(@[rqst_eq_no]) -1)" ).append("\n"); 
		query.append("  					AND SYSDATE BETWEEN A.FM_WARR_DT AND A.TO_WARR_DT + 0.99999" ).append("\n"); 
		query.append("  					AND ROWNUM = 1),1,'Y','N')" ).append("\n"); 
		query.append("           ,@[cre_usr_id]" ).append("\n"); 
		query.append("           ,sysdate" ).append("\n"); 
		query.append("           ,@[upd_usr_id]" ).append("\n"); 
		query.append("           ,sysdate	" ).append("\n"); 
		query.append("		   ,TO_DATE(@[mvmt_dt], 'yyyy-mm-dd')" ).append("\n"); 
		query.append("FROM MNR_EQ_STS_V" ).append("\n"); 
		query.append("WHERE EQ_NO = @[rqst_eq_no]" ).append("\n"); 

	}
}