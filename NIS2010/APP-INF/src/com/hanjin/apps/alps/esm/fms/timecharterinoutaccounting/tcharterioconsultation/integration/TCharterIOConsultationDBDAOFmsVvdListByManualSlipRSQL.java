/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TCharterIOConsultationDBDAOFmsVvdListByManualSlipRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.25
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.08.25 최우석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi,Woo-Seok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOConsultationDBDAOFmsVvdListByManualSlipRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Manual Slip – Brokerage / Window Select
	  * </pre>
	  */
	public TCharterIOConsultationDBDAOFmsVvdListByManualSlipRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exp_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flet_ctrt_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration").append("\n"); 
		query.append("FileName : TCharterIOConsultationDBDAOFmsVvdListByManualSlipRSQL").append("\n"); 
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
		query.append("SELECT VVD_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT VVD_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT    FV.VSL_CD" ).append("\n"); 
		query.append("|| FV.SKD_VOY_NO" ).append("\n"); 
		query.append("|| FV.SKD_DIR_CD" ).append("\n"); 
		query.append("|| FV.REV_DIR_CD VVD_CD," ).append("\n"); 
		query.append("FV.VST_DT," ).append("\n"); 
		query.append("FV.VED_DT" ).append("\n"); 
		query.append("FROM FMS_CONTRACT FC, FMS_VVD FV" ).append("\n"); 
		query.append("WHERE FC.FLET_CTRT_NO = @[flet_ctrt_no]" ).append("\n"); 
		query.append("AND FC.VSL_CD = FV.VSL_CD" ).append("\n"); 
		query.append("AND FV.VST_DT >= (SELECT MIN(VST_DT)" ).append("\n"); 
		query.append("FROM FMS_VVD" ).append("\n"); 
		query.append("WHERE VSL_CD = FC.VSL_CD)" ).append("\n"); 
		query.append("AND FV.VED_DT <= (SELECT MAX(VED_DT)" ).append("\n"); 
		query.append("FROM FMS_VVD" ).append("\n"); 
		query.append("WHERE VSL_CD = FC.VSL_CD)" ).append("\n"); 
		query.append(") WHERE (   REPLACE(@[eff_dt],'-','') BETWEEN VST_DT AND VED_DT" ).append("\n"); 
		query.append("OR REPLACE(@[exp_dt],'-','') BETWEEN VST_DT AND VED_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT VVD_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT    FV.VSL_CD" ).append("\n"); 
		query.append("|| FV.SKD_VOY_NO" ).append("\n"); 
		query.append("|| FV.SKD_DIR_CD" ).append("\n"); 
		query.append("|| FV.REV_DIR_CD VVD_CD," ).append("\n"); 
		query.append("FV.VST_DT," ).append("\n"); 
		query.append("FV.VED_DT" ).append("\n"); 
		query.append("FROM FMS_ID_VSL FI, FMS_VVD FV" ).append("\n"); 
		query.append("WHERE FI.FLET_CTRT_NO = @[flet_ctrt_no]" ).append("\n"); 
		query.append("AND FI.USE_FLG = 'Y'" ).append("\n"); 
		query.append("AND FI.VSL_CD = FV.VSL_CD" ).append("\n"); 
		query.append("AND FV.VST_DT >= (SELECT MIN(VST_DT)" ).append("\n"); 
		query.append("FROM FMS_VVD" ).append("\n"); 
		query.append("WHERE VSL_CD = FI.VSL_CD)" ).append("\n"); 
		query.append("AND FV.VED_DT <= (SELECT MAX(VED_DT)" ).append("\n"); 
		query.append("FROM FMS_VVD" ).append("\n"); 
		query.append("WHERE VSL_CD = FI.VSL_CD)" ).append("\n"); 
		query.append(") WHERE (   REPLACE(@[eff_dt],'-','') BETWEEN VST_DT AND VED_DT" ).append("\n"); 
		query.append("OR REPLACE(@[exp_dt],'-','') BETWEEN VST_DT AND VED_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}