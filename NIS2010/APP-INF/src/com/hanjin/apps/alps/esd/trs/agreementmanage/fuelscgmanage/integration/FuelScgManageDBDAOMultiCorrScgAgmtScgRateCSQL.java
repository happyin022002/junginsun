/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : FuelScgManageDBDAOMultiCorrScgAgmtScgRateCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.11
*@LastModifier : 신동일
*@LastVersion : 1.0
* 2015.06.11 신동일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.agreementmanage.fuelscgmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DONG- IL, SHIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FuelScgManageDBDAOMultiCorrScgAgmtScgRateCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * FAU Surcharge Rate 입력
	  * </pre>
	  */
	public FuelScgManageDBDAOMultiCorrScgAgmtScgRateCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_scg_rt_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_agmt_scg_rt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_agmt_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_one_wy_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_agmt_rt_tp_ser_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_agmt_scg_nod_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_rnd_rt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("wgt_meas_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_to_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_agmt_eq_tp_sz_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.agreementmanage.fuelscgmanage.integration").append("\n"); 
		query.append("FileName : FuelScgManageDBDAOMultiCorrScgAgmtScgRateCSQL").append("\n"); 
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
		query.append("INSERT INTO TRS_AGMT_SCG_RT (" ).append("\n"); 
		query.append("  	   TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("	  ,TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("	  ,TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("	  ,TRSP_AGMT_SCG_NOD_SEQ" ).append("\n"); 
		query.append("	  ,TRSP_AGMT_SCG_RT_SEQ" ).append("\n"); 
		query.append("	  ,TRSP_AGMT_EQ_TP_SZ_CD" ).append("\n"); 
		query.append("	  ,EFF_FM_DT" ).append("\n"); 
		query.append("	  ,EFF_TO_DT" ).append("\n"); 
		query.append("	  ,TO_WGT" ).append("\n"); 
		query.append("	  ,WGT_MEAS_UT_CD" ).append("\n"); 
		query.append("	  ,CURR_CD" ).append("\n"); 
		query.append("	  ,TRSP_ONE_WY_RT" ).append("\n"); 
		query.append("	  ,TRSP_RND_RT" ).append("\n"); 
		query.append("	  ,EQ_KND_CD" ).append("\n"); 
		query.append("	  ,AGMT_SCG_RT_DIV_CD" ).append("\n"); 
		query.append("  	  ,CRE_USR_ID" ).append("\n"); 
		query.append(" 	  ,CRE_DT" ).append("\n"); 
		query.append("	  ,UPD_USR_ID" ).append("\n"); 
		query.append("	  ,UPD_DT" ).append("\n"); 
		query.append("	  ,DELT_FLG" ).append("\n"); 
		query.append("      ,CFM_FLG" ).append("\n"); 
		query.append(" )VALUES (" ).append("\n"); 
		query.append("	   @[trsp_agmt_ofc_cty_cd]" ).append("\n"); 
		query.append("  	  ,@[trsp_agmt_seq]" ).append("\n"); 
		query.append("      ,@[trsp_agmt_rt_tp_ser_no]" ).append("\n"); 
		query.append("	  ,@[trsp_agmt_scg_nod_seq]" ).append("\n"); 
		query.append("	  ,@[trsp_agmt_scg_rt_seq]" ).append("\n"); 
		query.append("	  ,@[trsp_agmt_eq_tp_sz_cd]" ).append("\n"); 
		query.append("	  ,TO_DATE(@[eff_fm_dt],'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("	  ,TO_DATE(@[eff_to_dt],'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("	  ,@[to_wgt]" ).append("\n"); 
		query.append("	  ,@[wgt_meas_ut_cd]" ).append("\n"); 
		query.append("	  ,@[curr_cd]" ).append("\n"); 
		query.append("	  ,@[trsp_one_wy_rt]" ).append("\n"); 
		query.append("	  ,@[trsp_rnd_rt]" ).append("\n"); 
		query.append("	  ,@[eq_knd_cd]" ).append("\n"); 
		query.append("	  ,@[agmt_scg_rt_div_cd]" ).append("\n"); 
		query.append("	  ,@[usr_id]" ).append("\n"); 
		query.append("	  ,SYSDATE" ).append("\n"); 
		query.append("	  ,@[usr_id]" ).append("\n"); 
		query.append("	  ,SYSDATE" ).append("\n"); 
		query.append("	  ,@[delt_flg]" ).append("\n"); 
		query.append("      ,'N'" ).append("\n"); 
		query.append(" )" ).append("\n"); 

	}
}