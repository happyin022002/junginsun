/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : MASDBDAOCreateCopyAbcStpCostCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.28
*@LastModifier : 
*@LastVersion : 1.0
* 2012.08.28 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.stdunitcost.mas.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MASDBDAOCreateCopyAbcStpCostCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2012.08.27 이석준[CHM-201219844-01]   ABC(PA)/STP Cost(RA)화면에 Month Copy 기능 추가
	  * </pre>
	  */
	public MASDBDAOCreateCopyAbcStpCostCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_tar_mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_src_mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.stdunitcost.mas.integration").append("\n"); 
		query.append("FileName : MASDBDAOCreateCopyAbcStpCostCSQL").append("\n"); 
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
		query.append("#if(${table_name} =='MAS_SVC_TRNS_PRC')" ).append("\n"); 
		query.append("INSERT INTO MAS_SVC_TRNS_PRC" ).append("\n"); 
		query.append("(COST_YRMON,OFC_CD,OFC_ACT_CD,SVC_TRNS_PRC_CNT_CD,OFC_ACT_NM,DIV_MEAS_CD," ).append("\n"); 
		query.append("DIV_MEAS_NM,ACT_OFC_TTL_QTY,ACT_OFC_TTL_AMT,ACT_COST_UT_AMT,CNT_AVG_UC_AMT," ).append("\n"); 
		query.append("STP_MGN_RTO,SVC_TRNS_PRC_UT_AMT,SVC_TRNS_PRC_FLG,CRE_USR_ID,CRE_DT,UPD_USR_ID,UPD_DT)" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("    @[f_tar_mon] AS COST_YRMON," ).append("\n"); 
		query.append("    OFC_CD," ).append("\n"); 
		query.append("    OFC_ACT_CD," ).append("\n"); 
		query.append("    SVC_TRNS_PRC_CNT_CD," ).append("\n"); 
		query.append("    OFC_ACT_NM," ).append("\n"); 
		query.append("    DIV_MEAS_CD," ).append("\n"); 
		query.append("    DIV_MEAS_NM," ).append("\n"); 
		query.append("    ACT_OFC_TTL_QTY," ).append("\n"); 
		query.append("    ACT_OFC_TTL_AMT," ).append("\n"); 
		query.append("    ACT_COST_UT_AMT," ).append("\n"); 
		query.append("    CNT_AVG_UC_AMT," ).append("\n"); 
		query.append("    STP_MGN_RTO," ).append("\n"); 
		query.append("    SVC_TRNS_PRC_UT_AMT," ).append("\n"); 
		query.append("    SVC_TRNS_PRC_FLG," ).append("\n"); 
		query.append("    @[user_id]," ).append("\n"); 
		query.append("    SYSDATE," ).append("\n"); 
		query.append("    @[user_id]," ).append("\n"); 
		query.append("    SYSDATE" ).append("\n"); 
		query.append("FROM  MAS_SVC_TRNS_PRC" ).append("\n"); 
		query.append("WHERE COST_YRMON = @[f_src_mon]" ).append("\n"); 
		query.append("#elseif (${table_name} =='MAS_SVC_TRNS_OFC_MAPG')" ).append("\n"); 
		query.append("INSERT INTO MAS_SVC_TRNS_OFC_MAPG" ).append("\n"); 
		query.append("(COST_YRMON,OFC_CD,OFC_ACT_CD,DIV_MEAS_CD," ).append("\n"); 
		query.append(" PFITCTR_FLG,SVC_TRNS_PRC_FLG,CRE_USR_ID,CRE_DT,UPD_USR_ID,UPD_DT)" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("    @[f_tar_mon] AS COST_YRMON," ).append("\n"); 
		query.append("    OFC_CD," ).append("\n"); 
		query.append("    OFC_ACT_CD," ).append("\n"); 
		query.append("    DIV_MEAS_CD," ).append("\n"); 
		query.append("    PFITCTR_FLG," ).append("\n"); 
		query.append("    SVC_TRNS_PRC_FLG," ).append("\n"); 
		query.append("    @[user_id]," ).append("\n"); 
		query.append("    SYSDATE," ).append("\n"); 
		query.append("    @[user_id]," ).append("\n"); 
		query.append("    SYSDATE" ).append("\n"); 
		query.append("FROM  MAS_SVC_TRNS_OFC_MAPG" ).append("\n"); 
		query.append("WHERE COST_YRMON = @[f_src_mon]" ).append("\n"); 
		query.append("#elseif (${table_name} =='MAS_OFC_ROUT_MAPG')" ).append("\n"); 
		query.append("INSERT INTO MAS_OFC_ROUT_MAPG" ).append("\n"); 
		query.append("(COST_YRMON,OFC_CLSS_CD,SLS_ACT_CD,DIV_MEAS_CD,SLS_OFC_CLSS_NM," ).append("\n"); 
		query.append(" SLS_ACT_DESC,DIV_MEAS_NM,CRE_USR_ID,CRE_DT,UPD_USR_ID,UPD_DT)" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("    @[f_tar_mon] AS COST_YRMON," ).append("\n"); 
		query.append("    OFC_CLSS_CD," ).append("\n"); 
		query.append("    SLS_ACT_CD," ).append("\n"); 
		query.append("    DIV_MEAS_CD," ).append("\n"); 
		query.append("    SLS_OFC_CLSS_NM," ).append("\n"); 
		query.append("    SLS_ACT_DESC," ).append("\n"); 
		query.append("    DIV_MEAS_NM," ).append("\n"); 
		query.append("    @[user_id]," ).append("\n"); 
		query.append("    SYSDATE," ).append("\n"); 
		query.append("    @[user_id]," ).append("\n"); 
		query.append("    SYSDATE" ).append("\n"); 
		query.append("FROM  MAS_OFC_ROUT_MAPG" ).append("\n"); 
		query.append("WHERE COST_YRMON = @[f_src_mon]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${table_name} =='MAS_SVC_TRNS_PRC_MGN')" ).append("\n"); 
		query.append("INSERT INTO MAS_SVC_TRNS_PRC_MGN" ).append("\n"); 
		query.append("(COST_YRMON,OFC_ACT_CD,STP_MGN_RTO,CRE_USR_ID,CRE_DT,UPD_USR_ID,UPD_DT)" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("    @[f_tar_mon] AS COST_YRMON," ).append("\n"); 
		query.append("    OFC_ACT_CD," ).append("\n"); 
		query.append("    STP_MGN_RTO," ).append("\n"); 
		query.append("    @[user_id]," ).append("\n"); 
		query.append("    SYSDATE," ).append("\n"); 
		query.append("    @[user_id]," ).append("\n"); 
		query.append("    SYSDATE" ).append("\n"); 
		query.append("FROM  MAS_SVC_TRNS_PRC_MGN" ).append("\n"); 
		query.append("WHERE COST_YRMON = @[f_src_mon]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}