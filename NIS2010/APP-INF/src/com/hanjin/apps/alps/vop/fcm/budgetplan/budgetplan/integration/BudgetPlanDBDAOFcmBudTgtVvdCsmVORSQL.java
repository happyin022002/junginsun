/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BudgetPlanDBDAOFcmBudTgtVvdCsmVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.29
*@LastModifier : 
*@LastVersion : 1.0
* 2011.11.29 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.fcm.budgetplan.budgetplan.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BudgetPlanDBDAOFcmBudTgtVvdCsmVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * FcmBudTgtVvdCsmVO
	  * </pre>
	  */
	public BudgetPlanDBDAOFcmBudTgtVvdCsmVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sn_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sn_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.fcm.budgetplan.budgetplan.integration").append("\n"); 
		query.append("FileName : BudgetPlanDBDAOFcmBudTgtVvdCsmVORSQL").append("\n"); 
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
		query.append("SELECT T1.BUD_TGT_VVD_SEQ," ).append("\n"); 
		query.append("T1.BUD_SCNR_NO," ).append("\n"); 
		query.append("T1.BUD_YRMON," ).append("\n"); 
		query.append("T1.RLANE_CD," ).append("\n"); 
		query.append("T1.BUD_WK," ).append("\n"); 
		query.append("T1.TRD_CD," ).append("\n"); 
		query.append("T1.SUB_TRD_CD," ).append("\n"); 
		query.append("T1.VSL_CD," ).append("\n"); 
		query.append("T1.CNTR_VSL_CLSS_CAPA," ).append("\n"); 
		query.append("T1.CRR_CD," ).append("\n"); 
		query.append("T1.PF_SKD_TP_CD," ).append("\n"); 
		query.append("T1.TRND_LINE_TP_CD," ).append("\n"); 
		query.append("T1.ST_PORT_CD," ).append("\n"); 
		query.append("T1.END_PORT_CD," ).append("\n"); 
		query.append("TO_CHAR(T1.UPD_DT, 'YYYY-MM-DD') UPD_DT," ).append("\n"); 
		query.append("T2.PORT_DYS," ).append("\n"); 
		query.append("T2.SEA_DYS," ).append("\n"); 
		query.append("T2.MNVR_DYS," ).append("\n"); 
		query.append("T2.CRE_USR_ID," ).append("\n"); 
		query.append("TO_CHAR(T2.CRE_DT, 'YYYY-MM-DD') CRE_DT," ).append("\n"); 
		query.append("T2.FOIL_PORT_CSM_WGT," ).append("\n"); 
		query.append("T2.FOIL_SEA_CSM_WGT," ).append("\n"); 
		query.append("T2.FOIL_MNVR_CSM_WGT," ).append("\n"); 
		query.append("T2.FOIL_UC_AMT," ).append("\n"); 
		query.append("T2.FOIL_CSM_AMT," ).append("\n"); 
		query.append("T2.DOIL_PORT_CSM_WGT," ).append("\n"); 
		query.append("T2.DOIL_SEA_CSM_WGT," ).append("\n"); 
		query.append("T2.DOIL_MNVR_CSM_WGT," ).append("\n"); 
		query.append("T2.DOIL_UC_AMT," ).append("\n"); 
		query.append("T2.DOIL_CSM_AMT," ).append("\n"); 
		query.append("T2.TTL_CSM_AMT" ).append("\n"); 
		query.append("FROM FCM_BUD_TGT_VVD T1, FCM_BUD_TGT_VVD_CSM T2" ).append("\n"); 
		query.append("WHERE T1.BUD_TGT_VVD_SEQ = T2.BUD_TGT_VVD_SEQ (+)" ).append("\n"); 
		query.append("#if( ${sn_dt} != '' && ${sn_cd} != '' )" ).append("\n"); 
		query.append("AND T1.BUD_SCNR_NO = @[sn_dt]||@[sn_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( ${fm_dt} != '' )" ).append("\n"); 
		query.append("AND TO_DATE(T1.BUD_YRMON, 'YYYY-MM') BETWEEN TO_DATE(@[fm_dt], 'YYYY-MM')     -- 화면조건 : FM_DT" ).append("\n"); 
		query.append("AND TO_DATE(@[to_dt], 'YYYY-MM')+0.99999 -- 화면조건 : TO_DT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY T1.BUD_TGT_VVD_SEQ" ).append("\n"); 

	}
}