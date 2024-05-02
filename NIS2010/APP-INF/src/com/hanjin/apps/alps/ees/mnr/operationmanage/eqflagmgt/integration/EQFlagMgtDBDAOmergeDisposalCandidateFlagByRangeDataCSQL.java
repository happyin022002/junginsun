/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EQFlagMgtDBDAOmergeDisposalCandidateFlagByRangeDataCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.19
*@LastModifier : 권영법
*@LastVersion : 1.0
* 2009.10.19 권영법
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EQFlagMgtDBDAOmergeDisposalCandidateFlagByRangeDataCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EQFlagMgtDBDAOmergeDisposalCandidateFlagByRangeDataCSQL
	  * </pre>
	  */
	public EQFlagMgtDBDAOmergeDisposalCandidateFlagByRangeDataCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_warr_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_grp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_disp_sel_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_mkr_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("warr_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_mdl_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_warr_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_ser_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mft_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_ser_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("lot_eq_pfx_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_qty",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.integration").append("\n"); 
		query.append("FileName : EQFlagMgtDBDAOmergeDisposalCandidateFlagByRangeDataCSQL").append("\n"); 
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
		query.append("MERGE INTO MNR_EQ_RNG_STS" ).append("\n"); 
		query.append("USING DUAL" ).append("\n"); 
		query.append("ON (LOT_EQ_PFX_CD = @[lot_eq_pfx_cd] AND" ).append("\n"); 
		query.append("FM_SER_NO = @[fm_ser_no] AND" ).append("\n"); 
		query.append("TO_SER_NO = @[to_ser_no] AND" ).append("\n"); 
		query.append("MNR_GRP_TP_CD = @[mnr_grp_tp_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE" ).append("\n"); 
		query.append("SET MNR_DISP_SEL_FLG = DECODE(@[mnr_disp_sel_flg],'1','Y','N')," ).append("\n"); 
		query.append("MNR_DISP_SEL_FLG_DT = DECODE(@[mnr_disp_sel_flg],'1',SYSDATE,null)," ).append("\n"); 
		query.append("UPD_USR_ID = @[cre_usr_id]," ).append("\n"); 
		query.append("UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHERE LOT_EQ_PFX_CD = @[lot_eq_pfx_cd]" ).append("\n"); 
		query.append("AND FM_SER_NO = @[fm_ser_no]" ).append("\n"); 
		query.append("AND TO_SER_NO = @[to_ser_no]" ).append("\n"); 
		query.append("AND MNR_GRP_TP_CD = @[mnr_grp_tp_cd]" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT (" ).append("\n"); 
		query.append("LOT_EQ_PFX_CD" ).append("\n"); 
		query.append(",FM_SER_NO" ).append("\n"); 
		query.append(",TO_SER_NO" ).append("\n"); 
		query.append(",MNR_GRP_TP_CD" ).append("\n"); 
		query.append(",EQ_KND_CD" ).append("\n"); 
		query.append(",EQ_TPSZ_CD" ).append("\n"); 
		query.append(",EQ_MKR_NM" ).append("\n"); 
		query.append(",EQ_MDL_NM" ).append("\n"); 
		query.append(",MNR_DISP_SEL_FLG" ).append("\n"); 
		query.append(",MNR_DISP_SEL_FLG_DT" ).append("\n"); 
		query.append(",FM_WARR_DT" ).append("\n"); 
		query.append(",TO_WARR_DT" ).append("\n"); 
		query.append(",WARR_RMK" ).append("\n"); 
		query.append(",MFT_YR" ).append("\n"); 
		query.append(",EQ_QTY" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(") VALUES(" ).append("\n"); 
		query.append("@[lot_eq_pfx_cd]" ).append("\n"); 
		query.append(",@[fm_ser_no]" ).append("\n"); 
		query.append(",@[to_ser_no]" ).append("\n"); 
		query.append(",@[mnr_grp_tp_cd]" ).append("\n"); 
		query.append(",@[eq_knd_cd]" ).append("\n"); 
		query.append(",@[eq_tpsz_cd]" ).append("\n"); 
		query.append(",@[eq_mkr_nm]" ).append("\n"); 
		query.append(",@[eq_mdl_nm]" ).append("\n"); 
		query.append(",DECODE(@[mnr_disp_sel_flg],'1','Y','N')" ).append("\n"); 
		query.append(",DECODE(@[mnr_disp_sel_flg],'1',SYSDATE,null)" ).append("\n"); 
		query.append(",TO_DATE(@[fm_warr_dt], 'yyyy-mm-dd')" ).append("\n"); 
		query.append(",TO_DATE(@[to_warr_dt], 'yyyy-mm-dd')" ).append("\n"); 
		query.append(",@[warr_rmk]" ).append("\n"); 
		query.append(",@[mft_yr]" ).append("\n"); 
		query.append(",NVL(@[eq_qty],0)" ).append("\n"); 
		query.append(",@[cre_usr_id]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(",@[upd_usr_id]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}