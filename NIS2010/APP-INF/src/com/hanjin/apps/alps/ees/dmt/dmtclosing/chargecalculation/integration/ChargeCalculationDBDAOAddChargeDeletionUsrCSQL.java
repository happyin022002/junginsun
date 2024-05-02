/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ChargeCalculationDBDAOAddChargeDeletionUsrCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.15
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeCalculationDBDAOAddChargeDeletionUsrCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChargeCalculationDBDAOAddChargeDeletionUsrCSQL
	  * </pre>
	  */
	public ChargeCalculationDBDAOAddChargeDeletionUsrCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_delt_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_chg_loc_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_delt_usr_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sys_area_grp_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("chg_delt_path_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration").append("\n"); 
		query.append("FileName : ChargeCalculationDBDAOAddChargeDeletionUsrCSQL").append("\n"); 
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
		query.append("insert into DMT_CHG_DELT_USR(" ).append("\n"); 
		query.append("	SYS_AREA_GRP_ID " ).append("\n"); 
		query.append("   ,CNTR_NO" ).append("\n"); 
		query.append("   ,CNTR_CYC_NO" ).append("\n"); 
		query.append("   ,DMDT_TRF_CD" ).append("\n"); 
		query.append("   ,DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("   ,CHG_SEQ" ).append("\n"); 
		query.append("   ,CHG_OFC_CD" ).append("\n"); 
		query.append("   ,DELT_SEQ" ).append("\n"); 
		query.append("   ,CHG_DELT_PATH_CD" ).append("\n"); 
		query.append("   ,CHG_DELT_USR_ID" ).append("\n"); 
		query.append("   ,CHG_DELT_USR_OFC_CD" ).append("\n"); 
		query.append("   ,CRE_USR_ID" ).append("\n"); 
		query.append("   ,CRE_DT" ).append("\n"); 
		query.append("   ,CRE_OFC_CD" ).append("\n"); 
		query.append("   ,UPD_USR_ID" ).append("\n"); 
		query.append("   ,UPD_DT" ).append("\n"); 
		query.append("   ,UPD_OFC_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("values(" ).append("\n"); 
		query.append("	@[sys_area_grp_id]" ).append("\n"); 
		query.append("   ,@[cntr_no]" ).append("\n"); 
		query.append("   ,@[cntr_cyc_no]" ).append("\n"); 
		query.append("   ,@[dmdt_trf_cd]" ).append("\n"); 
		query.append("   ,@[dmdt_chg_loc_div_cd]" ).append("\n"); 
		query.append("   ,@[chg_seq]" ).append("\n"); 
		query.append("   ,@[chg_ofc_cd]" ).append("\n"); 
		query.append("   ,@[delt_seq]" ).append("\n"); 
		query.append("   ,@[chg_delt_path_cd]" ).append("\n"); 
		query.append("   ,@[chg_delt_usr_id]" ).append("\n"); 
		query.append("   ,@[chg_delt_usr_ofc_cd]" ).append("\n"); 
		query.append("   ,@[cre_usr_id]" ).append("\n"); 
		query.append("   ,nvl(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[cre_ofc_cd]), sysdate)" ).append("\n"); 
		query.append("   ,@[cre_ofc_cd]" ).append("\n"); 
		query.append("   ,@[upd_usr_id]" ).append("\n"); 
		query.append("   ,nvl(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[upd_ofc_cd]), sysdate)" ).append("\n"); 
		query.append("   ,@[upd_ofc_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}