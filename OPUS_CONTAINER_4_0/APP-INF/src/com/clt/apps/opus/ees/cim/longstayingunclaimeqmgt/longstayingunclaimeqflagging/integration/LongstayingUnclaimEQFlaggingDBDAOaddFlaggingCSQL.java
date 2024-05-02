/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LongstayingUnclaimEQFlaggingDBDAOaddFlaggingCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.22
*@LastModifier : 김종준
*@LastVersion : 1.0
* 2009.10.22 김종준
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author kim jong jun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LongstayingUnclaimEQFlaggingDBDAOaddFlaggingCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 장기체화장비(L/Staying) 및 Unclaim 장비 Flag 와 해소 방안을 등록한다.
	  * </pre>
	  */
	public LongstayingUnclaimEQFlaggingDBDAOaddFlaggingCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("uclm_rsn",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("uclm_ls_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("uclm_cntc_pnt_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_id_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmg_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("uclm_pln_rmk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("disp_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_gmt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("full_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stay_days",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("crnt_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("uclm_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("act_dys",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.integration").append("\n"); 
		query.append("FileName : LongstayingUnclaimEQFlaggingDBDAOaddFlaggingCSQL").append("\n"); 
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
		query.append("INSERT INTO CIM_UCLM_LONG_STAY_HIS(" ).append("\n"); 
		query.append("CNTR_NO" ).append("\n"); 
		query.append(",UCLM_LS_SEQ" ).append("\n"); 
		query.append(",CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",BKG_NO" ).append("\n"); 
		query.append(",BL_NO" ).append("\n"); 
		query.append(",CNMV_YR" ).append("\n"); 
		query.append(",CNMV_ID_NO" ).append("\n"); 
		query.append(",CNMV_STS_CD" ).append("\n"); 
		query.append(",CNMV_DT" ).append("\n"); 
		query.append(",CNMV_GDT" ).append("\n"); 
		query.append(",YD_CD" ).append("\n"); 
		query.append(",FULL_FLG" ).append("\n"); 
		query.append(",CNTR_DISP_FLG" ).append("\n"); 
		query.append(",CNTR_DMG_FLG" ).append("\n"); 
		query.append(",STAY_DYS" ).append("\n"); 
		query.append(",UCLM_LS_DIV_CD" ).append("\n"); 
		query.append(",UCLM_DT" ).append("\n"); 
		query.append(",UCLM_FREE_DYS" ).append("\n"); 
		query.append(",UCLM_END_DT" ).append("\n"); 
		query.append(",UCLM_ACT_STAY_DYS" ).append("\n"); 
		query.append(",UCLM_RSN" ).append("\n"); 
		query.append(",UCLM_PLN_RMK" ).append("\n"); 
		query.append(",UCLM_CNTC_PNT_NM" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("@[cntr_no]" ).append("\n"); 
		query.append(",(SELECT NVL(MAX(UCLM_LS_SEQ),0)+1 FROM CIM_UCLM_LONG_STAY_HIS WHERE  CNTR_NO=@[cntr_no] )" ).append("\n"); 
		query.append(",@[cntr_tpsz_cd]" ).append("\n"); 
		query.append(",@[bkg_no]" ).append("\n"); 
		query.append(",@[bl_no]" ).append("\n"); 
		query.append(",@[cnmv_yr]" ).append("\n"); 
		query.append(",@[cnmv_id_no]" ).append("\n"); 
		query.append(",@[cnmv_sts_cd]" ).append("\n"); 
		query.append(",TO_DATE(@[cnmv_dt],'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append(",TO_DATE(@[cnmv_gmt_dt],'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append(",@[crnt_yd_cd]" ).append("\n"); 
		query.append(",@[full_flg]" ).append("\n"); 
		query.append(",@[disp_flg]" ).append("\n"); 
		query.append(",@[dmg_flg]" ).append("\n"); 
		query.append(",@[stay_days]" ).append("\n"); 
		query.append(",@[uclm_ls_div_cd]" ).append("\n"); 
		query.append(",TO_DATE(@[uclm_dt],'YYYYMMDD')" ).append("\n"); 
		query.append(",@[ft_dys]" ).append("\n"); 
		query.append(",TO_DATE(@[ft_end_dt],'YYYYMMDD')" ).append("\n"); 
		query.append(",@[act_dys]" ).append("\n"); 
		query.append(",@[uclm_rsn]" ).append("\n"); 
		query.append(",@[uclm_pln_rmk]" ).append("\n"); 
		query.append(",@[uclm_cntc_pnt_nm]" ).append("\n"); 
		query.append(",@[cre_usr_id]" ).append("\n"); 
		query.append(",sysdate" ).append("\n"); 
		query.append(",@[upd_usr_id]" ).append("\n"); 
		query.append(",sysdate" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}