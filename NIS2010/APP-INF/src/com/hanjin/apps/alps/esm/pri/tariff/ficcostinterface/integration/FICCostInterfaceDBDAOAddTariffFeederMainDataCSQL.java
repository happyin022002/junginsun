/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : FICCostInterfaceDBDAOAddTariffFeederMainDataCSQL.java
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

public class FICCostInterfaceDBDAOAddTariffFeederMainDataCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PRI_TRF_FDR_MN INSERT
	  * </pre>
	  */
	public FICCostInterfaceDBDAOAddTariffFeederMainDataCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.tariff.ficcostinterface.integration").append("\n"); 
		query.append("FileName : FICCostInterfaceDBDAOAddTariffFeederMainDataCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_TRF_FDR_MN" ).append("\n"); 
		query.append("  (SVC_SCP_CD," ).append("\n"); 
		query.append("   ORG_DEST_TP_CD," ).append("\n"); 
		query.append("   FDR_TRF_NO," ).append("\n"); 
		query.append("   AMDT_SEQ," ).append("\n"); 
		query.append("   EFF_DT," ).append("\n"); 
		query.append("   EXP_DT," ).append("\n"); 
		query.append("   FIC_PROP_STS_CD," ).append("\n"); 
		query.append("   TRF_CURR_CD," ).append("\n"); 
		query.append("   LOCL_CURR_CD," ).append("\n"); 
		query.append("   CRE_USR_ID," ).append("\n"); 
		query.append("   CRE_DT," ).append("\n"); 
		query.append("   UPD_USR_ID," ).append("\n"); 
		query.append("   UPD_DT," ).append("\n"); 
		query.append("   CRE_OFC_CD)" ).append("\n"); 
		query.append("values" ).append("\n"); 
		query.append("  (@[svc_scp_cd]," ).append("\n"); 
		query.append("   @[org_dest_tp_cd]," ).append("\n"); 
		query.append("   @[fdr_trf_no]," ).append("\n"); 
		query.append("   0," ).append("\n"); 
		query.append("   TO_DATE(TO_CHAR(SYSDATE, 'YYYYMMDD'), 'YYYYMMDD')," ).append("\n"); 
		query.append("   TO_DATE('99991231', 'YYYYMMDD')," ).append("\n"); 
		query.append("   'I'," ).append("\n"); 
		query.append("   'USD'," ).append("\n"); 
		query.append("   (SELECT B.CURR_CD" ).append("\n"); 
		query.append("      FROM   #if(${rhq_cd} == 'HAMRU')    " ).append("\n"); 
		query.append("                 AOC_EUR_FDR_TRF_HDR  B" ).append("\n"); 
		query.append("             #end " ).append("\n"); 
		query.append("             #if(${rhq_cd} == 'SINRS')" ).append("\n"); 
		query.append("                 AOC_CHN_FDR_TRF_HDR  B" ).append("\n"); 
		query.append("             #end " ).append("\n"); 
		query.append("             #if(${rhq_cd} == 'SHARC')" ).append("\n"); 
		query.append("                 AOC_CHN_FDR_TRF_HDR  B" ).append("\n"); 
		query.append("             #end" ).append("\n"); 
		query.append("     WHERE B.COST_TRF_NO = @[cost_trf_no])," ).append("\n"); 
		query.append("   @[cre_usr_id]," ).append("\n"); 
		query.append("   SYSDATE," ).append("\n"); 
		query.append("   @[upd_usr_id]," ).append("\n"); 
		query.append("   SYSDATE," ).append("\n"); 
		query.append("   @[ofc_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}