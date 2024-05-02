/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : WeeklyCMDBDAOCoaSltMgmtUtVOUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.14
*@LastModifier : 박수훈
*@LastVersion : 1.0
* 2009.10.14 박수훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.weeklypfmc.weeklycm.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SOO HOON PARK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WeeklyCMDBDAOCoaSltMgmtUtVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SMU 단가 수정(저장)   
	  * </pre>
	  */
	public WeeklyCMDBDAOCoaSltMgmtUtVOUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("plcy_prc_ut_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_uc_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cost_lane_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.weeklypfmc.weeklycm.integration").append("\n"); 
		query.append("FileName : WeeklyCMDBDAOCoaSltMgmtUtVOUSQL").append("\n"); 
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
		query.append("MERGE INTO COA_SLT_MGMT_UT A" ).append("\n"); 
		query.append("USING (SELECT @[cost_yrmon] COST_YRMON" ).append("\n"); 
		query.append(",@[trd_cd] TRD_CD" ).append("\n"); 
		query.append(",@[rlane_cd] RLANE_CD" ).append("\n"); 
		query.append(",@[vsl_slan_dir_cd] VSL_SLAN_DIR_CD" ).append("\n"); 
		query.append(",@[cost_lane_tp_cd] COST_LANE_TP_CD" ).append("\n"); 
		query.append(",@[bse_uc_amt] BSE_UC_AMT" ).append("\n"); 
		query.append(",@[plcy_prc_ut_amt] PLCY_PRC_UT_AMT" ).append("\n"); 
		query.append(",@[cre_usr_id] CRE_USR_ID" ).append("\n"); 
		query.append(",SYSDATE CRE_DT" ).append("\n"); 
		query.append(",@[upd_usr_id] UPD_USR_ID" ).append("\n"); 
		query.append(",SYSDATE UPD_DT" ).append("\n"); 
		query.append("FROM DUAL) B" ).append("\n"); 
		query.append("ON (    A.COST_YRMON = B.COST_YRMON" ).append("\n"); 
		query.append("AND A.TRD_CD = B.TRD_CD" ).append("\n"); 
		query.append("AND A.RLANE_CD = B.RLANE_CD" ).append("\n"); 
		query.append("AND A.VSL_SLAN_DIR_CD = B.VSL_SLAN_DIR_CD" ).append("\n"); 
		query.append("AND A.COST_LANE_TP_CD = B.COST_LANE_TP_CD)" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT (COST_YRMON, TRD_CD, RLANE_CD, VSL_SLAN_DIR_CD, COST_LANE_TP_CD, BSE_UC_AMT, PLCY_PRC_UT_AMT" ).append("\n"); 
		query.append(",CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT)" ).append("\n"); 
		query.append("VALUES (B.COST_YRMON, B.TRD_CD, B.RLANE_CD, B.VSL_SLAN_DIR_CD, B.COST_LANE_TP_CD, B.BSE_UC_AMT, B.PLCY_PRC_UT_AMT" ).append("\n"); 
		query.append(",B.CRE_USR_ID, B.CRE_DT, B.UPD_USR_ID, B.UPD_DT)" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE" ).append("\n"); 
		query.append("SET A.BSE_UC_AMT = B.BSE_UC_AMT, A.PLCY_PRC_UT_AMT = B.PLCY_PRC_UT_AMT" ).append("\n"); 
		query.append(",A.UPD_USR_ID = B.UPD_USR_ID, A.UPD_DT = B.UPD_DT" ).append("\n"); 

	}
}