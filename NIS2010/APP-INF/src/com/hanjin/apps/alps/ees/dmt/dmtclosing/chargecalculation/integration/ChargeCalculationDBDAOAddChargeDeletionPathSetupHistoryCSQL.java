/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : ChargeCalculationDBDAOAddChargeDeletionPathSetupHistoryCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.09.12
*@LastModifier : 
*@LastVersion : 1.0
* 2017.09.12 
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

public class ChargeCalculationDBDAOAddChargeDeletionPathSetupHistoryCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChargeCalculationDBDAOAddChargeDeletionPathSetupHistoryCSQL
	  * </pre>
	  */
	public ChargeCalculationDBDAOAddChargeDeletionPathSetupHistoryCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_delt_path_stup_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("chg_delt_path_stup_his_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration").append("\n"); 
		query.append("FileName : ChargeCalculationDBDAOAddChargeDeletionPathSetupHistoryCSQL").append("\n"); 
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
		query.append("INSERT INTO " ).append("\n"); 
		query.append("	DMT_CHG_DELT_PATH_STUP_HIS" ).append("\n"); 
		query.append("	(" ).append("\n"); 
		query.append("		CHG_DELT_PATH_STUP_SEQ" ).append("\n"); 
		query.append("	   ,CHG_DELT_PATH_STUP_HIS_SEQ" ).append("\n"); 
		query.append("	   ,EFF_DT" ).append("\n"); 
		query.append("	   ,EXP_DT" ).append("\n"); 
		query.append("	   ,CHG_DELT_RHQ_CD" ).append("\n"); 
		query.append("	   ,DMDT_BRNC_OFC_OP_MGR_FLG" ).append("\n"); 
		query.append("       ,DMDT_BRNC_FLG" ).append("\n"); 
		query.append("       ,DMDT_RHQ_FLG" ).append("\n"); 
		query.append("       ,DMDT_HO_FLG" ).append("\n"); 
		query.append("	   ,CRE_USR_ID" ).append("\n"); 
		query.append("	   ,CRE_DT" ).append("\n"); 
		query.append("	   ,CRE_OFC_CD" ).append("\n"); 
		query.append("	   ,UPD_USR_ID" ).append("\n"); 
		query.append("	   ,UPD_DT" ).append("\n"); 
		query.append("	   ,UPD_OFC_CD" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("SELECT  CHG_DELT_PATH_STUP_SEQ" ).append("\n"); 
		query.append("       ,@[chg_delt_path_stup_his_seq]" ).append("\n"); 
		query.append("       ,EFF_DT" ).append("\n"); 
		query.append("       ,EXP_DT" ).append("\n"); 
		query.append("       ,CHG_DELT_RHQ_CD" ).append("\n"); 
		query.append("	   ,DMDT_BRNC_OFC_OP_MGR_FLG" ).append("\n"); 
		query.append("       ,DMDT_BRNC_FLG" ).append("\n"); 
		query.append("       ,DMDT_RHQ_FLG" ).append("\n"); 
		query.append("       ,DMDT_HO_FLG" ).append("\n"); 
		query.append("	   ,CRE_USR_ID" ).append("\n"); 
		query.append("	   ,CRE_DT" ).append("\n"); 
		query.append("	   ,CRE_OFC_CD" ).append("\n"); 
		query.append("	   ,@[upd_usr_id]" ).append("\n"); 
		query.append("	   ,nvl(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[upd_ofc_cd]), SYSDATE)" ).append("\n"); 
		query.append("	   ,@[upd_ofc_cd]	   " ).append("\n"); 
		query.append("  FROM  DMT_CHG_DELT_PATH_STUP " ).append("\n"); 
		query.append(" WHERE  CHG_DELT_PATH_STUP_SEQ = TO_NUMBER(@[chg_delt_path_stup_seq])" ).append("\n"); 

	}
}