/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : FICCostInterfaceDBDAOAddTariffFeederCostVersionMappingDataCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.06
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.06 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.tariff.ficcostinterface.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FICCostInterfaceDBDAOAddTariffFeederCostVersionMappingDataCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Insert - Pricing Tariff Feeder Cost Version Mapping
	  * </pre>
	  */
	public FICCostInterfaceDBDAOAddTariffFeederCostVersionMappingDataCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ver_mapg_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_trf_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("org_dest_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fdr_trf_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.tariff.ficcostinterface.integration").append("\n"); 
		query.append("FileName : FICCostInterfaceDBDAOAddTariffFeederCostVersionMappingDataCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_TRF_FDR_COST_VER_MAPG" ).append("\n"); 
		query.append("  (SVC_SCP_CD," ).append("\n"); 
		query.append("   ORG_DEST_TP_CD," ).append("\n"); 
		query.append("   FDR_TRF_NO," ).append("\n"); 
		query.append("   VER_MAPG_SEQ," ).append("\n"); 
		query.append("   RHQ_CD," ).append("\n"); 
		query.append("   FDR_COST_TRF_NO," ).append("\n"); 
		query.append("   CRE_USR_ID," ).append("\n"); 
		query.append("   CRE_DT," ).append("\n"); 
		query.append("   UPD_USR_ID," ).append("\n"); 
		query.append("   UPD_DT)" ).append("\n"); 
		query.append("  SELECT @[svc_scp_cd] SVC_SCP_CD," ).append("\n"); 
		query.append("         @[org_dest_tp_cd] ORG_DEST_TP_CD," ).append("\n"); 
		query.append("         @[fdr_trf_no] FDR_TRF_NO," ).append("\n"); 
		query.append("         @[ver_mapg_seq] VER_MAPG_SEQ," ).append("\n"); 
		query.append("         @[rhq_cd] RHQ_CD," ).append("\n"); 
		query.append("         A.COST_TRF_NO FDR_COST_TRF_NO," ).append("\n"); 
		query.append("         @[cre_usr_id] CRE_USR_ID," ).append("\n"); 
		query.append("         SYSDATE CRE_DT," ).append("\n"); 
		query.append("         @[upd_usr_id] UPD_USR_ID," ).append("\n"); 
		query.append("         SYSDATE UPD_DT" ).append("\n"); 
		query.append("    FROM #if(${rhq_cd} == 'HAMRU')    " ).append("\n"); 
		query.append("             AOC_EUR_FDR_TRF_HDR  A " ).append("\n"); 
		query.append("         #end " ).append("\n"); 
		query.append("         #if(${rhq_cd} == 'SINRS')" ).append("\n"); 
		query.append("             AOC_CHN_FDR_TRF_HDR  A" ).append("\n"); 
		query.append("         #end " ).append("\n"); 
		query.append("         #if(${rhq_cd} == 'SHARC')" ).append("\n"); 
		query.append("             AOC_CHN_FDR_TRF_HDR  A" ).append("\n"); 
		query.append("         #end" ).append("\n"); 
		query.append("   WHERE A.COST_TRF_NO = @[cost_trf_no]" ).append("\n"); 

	}
}