/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : OnOffHireAuditDBDAOaddImportOnOffHireListCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.17
*@LastModifier : 진준성
*@LastVersion : 1.0
* 2010.02.17 진준성
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.containercostanalysis.onoffhireaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jin Jun Sung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OnOffHireAuditDBDAOaddImportOnOffHireListCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * create ImportOnOffHireList
	  * </pre>
	  */
	public OnOffHireAuditDBDAOaddImportOnOffHireListCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("offh_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("aud_ver_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("onh_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lse_aud_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("offh_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("audit_remark",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("onh_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lr_offh_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lr_onh_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lr_onh_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aud_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("onf_hir_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bil_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bil_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lstm_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("lr_offh_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.lse.containercostanalysis.onoffhireaudit.integration").append("\n"); 
		query.append("FileName : OnOffHireAuditDBDAOaddImportOnOffHireListCSQL").append("\n"); 
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
		query.append("INSERT INTO LSE_ONF_HIR_AUD(" ).append("\n"); 
		query.append("     VNDR_SEQ" ).append("\n"); 
		query.append("   , AUD_SEQ" ).append("\n"); 
		query.append("   , AUD_VER_SEQ" ).append("\n"); 
		query.append("   , AGMT_CTY_CD" ).append("\n"); 
		query.append("   , AGMT_SEQ" ).append("\n"); 
		query.append("   , LSTM_CD" ).append("\n"); 
		query.append("   , CNTR_NO" ).append("\n"); 
		query.append("   , CNTR_TPSZ_CD" ).append("\n"); 
		query.append("   , ONH_DT" ).append("\n"); 
		query.append("   , ONH_LOC_CD" ).append("\n"); 
		query.append("   , OFFH_DT" ).append("\n"); 
		query.append("   , OFFH_LOC_CD" ).append("\n"); 
		query.append("   , LR_ONH_DT" ).append("\n"); 
		query.append("   , LR_ONH_LOC_CD" ).append("\n"); 
		query.append("   , LR_OFFH_DT" ).append("\n"); 
		query.append("   , LR_OFFH_LOC_CD" ).append("\n"); 
		query.append("   , LSE_AUD_TP_CD" ).append("\n"); 
		query.append("   , ONF_HIR_STS_CD" ).append("\n"); 
		query.append("   , CRE_USR_ID" ).append("\n"); 
		query.append("   , CRE_DT" ).append("\n"); 
		query.append("   , UPD_USR_ID" ).append("\n"); 
		query.append("   , UPD_DT" ).append("\n"); 
		query.append("   , REF_NO" ).append("\n"); 
		query.append("   , BIL_FM_DT" ).append("\n"); 
		query.append("   , BIL_TO_DT" ).append("\n"); 
		query.append("   , AUD_RMK" ).append("\n"); 
		query.append(") VALUES(" ).append("\n"); 
		query.append("     @[vndr_seq]" ).append("\n"); 
		query.append("   , @[aud_seq]" ).append("\n"); 
		query.append("   , @[aud_ver_seq]" ).append("\n"); 
		query.append("   , @[agmt_cty_cd]" ).append("\n"); 
		query.append("   , @[agmt_seq]" ).append("\n"); 
		query.append("   , @[lstm_cd]" ).append("\n"); 
		query.append("   , @[cntr_no]" ).append("\n"); 
		query.append("   , @[cntr_tpsz_cd]" ).append("\n"); 
		query.append("   , TO_DATE(@[onh_dt], 'yyyymmdd')" ).append("\n"); 
		query.append("   , @[onh_loc_cd]" ).append("\n"); 
		query.append("   , TO_DATE(@[offh_dt], 'yyyymmdd')       " ).append("\n"); 
		query.append("   , @[offh_loc_cd]" ).append("\n"); 
		query.append("   , TO_DATE(@[lr_onh_dt] , 'yyyymmdd')" ).append("\n"); 
		query.append("   , @[lr_onh_loc_cd]" ).append("\n"); 
		query.append("   , TO_DATE(@[lr_offh_dt], 'yyyymmdd')" ).append("\n"); 
		query.append("   , @[lr_offh_loc_cd]" ).append("\n"); 
		query.append("   , @[lse_aud_tp_cd]" ).append("\n"); 
		query.append("   , @[onf_hir_sts_cd]" ).append("\n"); 
		query.append("   , @[cre_usr_id]" ).append("\n"); 
		query.append("   , SYSDATE" ).append("\n"); 
		query.append("   , @[upd_usr_id]" ).append("\n"); 
		query.append("   , SYSDATE" ).append("\n"); 
		query.append("   , @[ref_no]" ).append("\n"); 
		query.append("   , TO_DATE(@[bil_fm_dt], 'yyyymmdd')" ).append("\n"); 
		query.append("   , TO_DATE(@[bil_to_dt], 'yyyymmdd')" ).append("\n"); 
		query.append("   , @[audit_remark]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}