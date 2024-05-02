/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EccLinkInfoManageDBDAOMergeEccLinkInfoCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.28
*@LastModifier : 
*@LastVersion : 1.0
* 2009.07.28 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage.ecclinkinfomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EccLinkInfoManageDBDAOMergeEccLinkInfoCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EQR_SCNR_ECC_LNK 테이블 데이터 입력/수정
	  * </pre>
	  */
	public EccLinkInfoManageDBDAOMergeEccLinkInfoCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_freq_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tz_40ft_cost_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_max_capa_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_ecc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("expt_to_yrwk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tz_dys",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_ecc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tz_20ft_cost_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tz_45ft_cost_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scnr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("expt_max_capa_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("expt_fm_yrwk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_vol_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("expt_vol_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.scenariomanage.ecclinkinfomanage.integration").append("\n"); 
		query.append("FileName : EccLinkInfoManageDBDAOMergeEccLinkInfoCSQL").append("\n"); 
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
		query.append("MERGE INTO EQR_SCNR_ECC_LNK I" ).append("\n"); 
		query.append("USING (" ).append("\n"); 
		query.append("SELECT @[scnr_id] AS SCNR_ID" ).append("\n"); 
		query.append(",@[fm_ecc_cd] AS FM_ECC_CD" ).append("\n"); 
		query.append(",@[to_ecc_cd] AS TO_ECC_CD" ).append("\n"); 
		query.append(",@[trsp_mod_cd] AS TRSP_MOD_CD" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append(") M" ).append("\n"); 
		query.append("ON (" ).append("\n"); 
		query.append("I.SCNR_ID     = M.SCNR_ID" ).append("\n"); 
		query.append("AND I.FM_ECC_CD   = M.FM_ECC_CD" ).append("\n"); 
		query.append("AND I.TO_ECC_CD   = M.TO_ECC_CD" ).append("\n"); 
		query.append("AND I.TRSP_MOD_CD = M.TRSP_MOD_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE SET" ).append("\n"); 
		query.append("I.TZ_20FT_COST_AMT  = @[tz_20ft_cost_amt]," ).append("\n"); 
		query.append("I.TZ_40FT_COST_AMT  = @[tz_40ft_cost_amt]," ).append("\n"); 
		query.append("I.TZ_45FT_COST_AMT  = @[tz_45ft_cost_amt]," ).append("\n"); 
		query.append("I.EXPT_FM_YRWK      = @[expt_fm_yrwk]," ).append("\n"); 
		query.append("I.EXPT_TO_YRWK 	    = @[expt_to_yrwk]," ).append("\n"); 
		query.append("I.EXPT_MAX_CAPA_QTY = @[expt_max_capa_qty]," ).append("\n"); 
		query.append("I.EXPT_VOL_UT_CD    = @[expt_vol_ut_cd]," ).append("\n"); 
		query.append("I.UPD_USR_ID        = @[upd_usr_id]," ).append("\n"); 
		query.append("I.UPD_DT            = SYSDATE" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT (" ).append("\n"); 
		query.append("I.SCNR_ID" ).append("\n"); 
		query.append(",I.FM_ECC_CD" ).append("\n"); 
		query.append(",I.TO_ECC_CD" ).append("\n"); 
		query.append(",I.TRSP_MOD_CD" ).append("\n"); 
		query.append(",I.TZ_DYS" ).append("\n"); 
		query.append(",I.TZ_20FT_COST_AMT" ).append("\n"); 
		query.append(",I.TZ_40FT_COST_AMT" ).append("\n"); 
		query.append(",I.TZ_45FT_COST_AMT" ).append("\n"); 
		query.append(",I.CNTR_MAX_CAPA_QTY" ).append("\n"); 
		query.append(",I.CNTR_VOL_UT_CD" ).append("\n"); 
		query.append(",I.TRSP_FREQ_KNT" ).append("\n"); 
		query.append(",I.EXPT_FM_YRWK" ).append("\n"); 
		query.append(",I.EXPT_TO_YRWK" ).append("\n"); 
		query.append(",I.EXPT_MAX_CAPA_QTY" ).append("\n"); 
		query.append(",I.EXPT_VOL_UT_CD" ).append("\n"); 
		query.append(",I.CRE_USR_ID" ).append("\n"); 
		query.append(",I.CRE_DT" ).append("\n"); 
		query.append(",I.UPD_USR_ID" ).append("\n"); 
		query.append(",I.UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES (" ).append("\n"); 
		query.append("@[scnr_id]" ).append("\n"); 
		query.append(", @[fm_ecc_cd]" ).append("\n"); 
		query.append(", @[to_ecc_cd]" ).append("\n"); 
		query.append(", @[trsp_mod_cd]" ).append("\n"); 
		query.append(", @[tz_dys]" ).append("\n"); 
		query.append(", @[tz_20ft_cost_amt]" ).append("\n"); 
		query.append(", @[tz_40ft_cost_amt]" ).append("\n"); 
		query.append(", @[tz_45ft_cost_amt]" ).append("\n"); 
		query.append(", @[cntr_max_capa_qty]" ).append("\n"); 
		query.append(", @[cntr_vol_ut_cd]" ).append("\n"); 
		query.append(", @[trsp_freq_knt]" ).append("\n"); 
		query.append(", @[expt_fm_yrwk]" ).append("\n"); 
		query.append(", @[expt_to_yrwk]" ).append("\n"); 
		query.append(", @[expt_max_capa_qty]" ).append("\n"); 
		query.append(", @[expt_vol_ut_cd]" ).append("\n"); 
		query.append(", @[upd_usr_id]" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append(", @[upd_usr_id]" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}