/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ChargeCalculationDBDAOModifyChargeBySZPBBUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.01
*@LastModifier : 
*@LastVersion : 1.0
* 2016.12.01 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeCalculationDBDAOModifyChargeBySZPBBUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChargeCalculationDBDAOModifyChargeBySZPBBUSQL
	  * </pre>
	  */
	public ChargeCalculationDBDAOModifyChargeBySZPBBUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("to_mvmt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bzc_trf_grp_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_trf_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_trf_aply_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ft_dys",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_mvmt_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ft_end_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fx_ft_ovr_dys",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_cyc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_mvmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_mvmt_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bzc_trf_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_chg_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bzc_trf_aply_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bil_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ft_cmnc_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_ft_ovr_dys",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_mvmt_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bzc_trf_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_mvmt_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_chg_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("to_mvmt_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_mvmt_split_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_mvmt_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.integration").append("\n"); 
		query.append("FileName : ChargeCalculationDBDAOModifyChargeBySZPBBUSQL").append("\n"); 
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
		query.append("UPDATE	DMT_CHG_CALC" ).append("\n"); 
		query.append("SET (" ).append("\n"); 
		query.append("	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(",	UPD_OFC_CD" ).append("\n"); 
		query.append(",	FM_MVMT_STS_CD" ).append("\n"); 
		query.append(",	FM_MVMT_DT" ).append("\n"); 
		query.append(",	FM_MVMT_YD_CD" ).append("\n"); 
		query.append(",	TO_MVMT_STS_CD" ).append("\n"); 
		query.append(",	TO_MVMT_DT" ).append("\n"); 
		query.append(",	TO_MVMT_YD_CD" ).append("\n"); 
		query.append(",	TO_MVMT_YR" ).append("\n"); 
		query.append(",	TO_MVMT_SEQ" ).append("\n"); 
		query.append(",	TO_MVMT_SPLIT_NO" ).append("\n"); 
		query.append(",	FT_DYS" ).append("\n"); 
		query.append(",	FT_CMNC_DT" ).append("\n"); 
		query.append(",	FT_END_DT" ).append("\n"); 
		query.append(",	FX_FT_OVR_DYS" ).append("\n"); 
		query.append(",	ORG_FT_OVR_DYS" ).append("\n"); 
		query.append(",	BZC_TRF_CURR_CD" ).append("\n"); 
		query.append(",	DMDT_TRF_APLY_TP_CD" ).append("\n"); 
		query.append(",	ORG_CHG_AMT" ).append("\n"); 
		query.append(",	BIL_AMT" ).append("\n"); 
		query.append(",	DMDT_CHG_STS_CD" ).append("\n"); 
		query.append(",	BZC_TRF_SEQ" ).append("\n"); 
		query.append(",	BZC_TRF_GRP_SEQ" ).append("\n"); 
		query.append(",	BZC_TRF_APLY_DT" ).append("\n"); 
		query.append(",	CALC_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("=" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("	SELECT" ).append("\n"); 
		query.append("	@[upd_usr_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",	@[upd_ofc_cd]" ).append("\n"); 
		query.append(",	@[fm_mvmt_sts_cd]" ).append("\n"); 
		query.append(",	TO_DATE(@[fm_mvmt_dt],'YYYYMMDD')" ).append("\n"); 
		query.append(",	@[fm_mvmt_yd_cd]" ).append("\n"); 
		query.append(",	@[to_mvmt_sts_cd]" ).append("\n"); 
		query.append(",	TO_DATE(@[to_mvmt_dt],'YYYYMMDD')" ).append("\n"); 
		query.append(",	@[to_mvmt_yd_cd]" ).append("\n"); 
		query.append(",	@[to_mvmt_yr]" ).append("\n"); 
		query.append(",	@[to_mvmt_seq]" ).append("\n"); 
		query.append(",	@[to_mvmt_split_no]" ).append("\n"); 
		query.append(",	@[ft_dys]" ).append("\n"); 
		query.append(",	TO_DATE(@[ft_cmnc_dt],'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append(",	TO_DATE(@[ft_end_dt],'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append(",	@[fx_ft_ovr_dys]" ).append("\n"); 
		query.append(",	@[org_ft_ovr_dys]" ).append("\n"); 
		query.append(",	@[bzc_trf_curr_cd]" ).append("\n"); 
		query.append(",	@[dmdt_trf_aply_tp_cd]" ).append("\n"); 
		query.append(",	@[org_chg_amt]" ).append("\n"); 
		query.append(",	@[bil_amt]" ).append("\n"); 
		query.append(",	@[dmdt_chg_sts_cd]" ).append("\n"); 
		query.append(",	@[bzc_trf_seq]" ).append("\n"); 
		query.append(",	@[bzc_trf_grp_seq]" ).append("\n"); 
		query.append(",	TO_DATE(@[bzc_trf_aply_dt],'YYYYMMDD')" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append("	FROM	DUAL" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE	SYS_AREA_GRP_ID		= @[svr_id]" ).append("\n"); 
		query.append("AND		CNTR_NO				= @[cntr_no]" ).append("\n"); 
		query.append("AND		CNTR_CYC_NO			= @[cntr_cyc_no]" ).append("\n"); 
		query.append("AND		DMDT_TRF_CD			= @[dmdt_trf_cd]" ).append("\n"); 
		query.append("AND		DMDT_CHG_LOC_DIV_CD	= 'SZP'" ).append("\n"); 
		query.append("AND		CHG_SEQ				= @[chg_seq]" ).append("\n"); 

	}
}