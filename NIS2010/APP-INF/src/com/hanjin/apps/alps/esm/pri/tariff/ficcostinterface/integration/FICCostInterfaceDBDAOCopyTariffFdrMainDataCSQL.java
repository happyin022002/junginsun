/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : FICCostInterfaceDBDAOCopyTariffFdrMainDataCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.05
*@LastModifier : 
*@LastVersion : 1.0
* 2013.03.05 
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

public class FICCostInterfaceDBDAOCopyTariffFdrMainDataCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CopyTariffFdrMainData
	  * 2013.03.05 [CHM-201323352] 전윤주 copy 시 confirm date를 copy한 날짜로, confrim user는 copy한 user 로 변경
	  * </pre>
	  */
	public FICCostInterfaceDBDAOCopyTariffFdrMainDataCSQL(){
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
		params.put("ori_fdr_trf_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ori_amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ori_svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.tariff.ficcostinterface.integration").append("\n"); 
		query.append("FileName : FICCostInterfaceDBDAOCopyTariffFdrMainDataCSQL").append("\n"); 
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
		query.append("   CFM_DT," ).append("\n"); 
		query.append("   FIC_PROP_STS_CD," ).append("\n"); 
		query.append("   TRF_CURR_CD," ).append("\n"); 
		query.append("   LOCL_CURR_CD," ).append("\n"); 
		query.append("   CFM_USR_ID," ).append("\n"); 
		query.append("   CFM_OFC_CD," ).append("\n"); 
		query.append("   CRE_OFC_CD," ).append("\n"); 
		query.append("   CRE_USR_ID," ).append("\n"); 
		query.append("   CRE_DT," ).append("\n"); 
		query.append("   UPD_USR_ID," ).append("\n"); 
		query.append("   UPD_DT)" ).append("\n"); 
		query.append("SELECT @[svc_scp_cd]" ).append("\n"); 
		query.append("     , @[org_dest_tp_cd]" ).append("\n"); 
		query.append("     , @[fdr_trf_no]  " ).append("\n"); 
		query.append("     , '0'" ).append("\n"); 
		query.append("     , TO_DATE(@[eff_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("     , TO_DATE('99991231', 'YYYYMMDD')" ).append("\n"); 
		query.append("     , SYSDATE CFM_DT --confrim date는 copy 하는 날짜로(정석환 차장 요청)" ).append("\n"); 
		query.append("     , MN.FIC_PROP_STS_CD" ).append("\n"); 
		query.append("     , MN.TRF_CURR_CD" ).append("\n"); 
		query.append("     , MN.LOCL_CURR_CD" ).append("\n"); 
		query.append("     , @[cre_usr_id] CFM_USR_ID --confirm user를 copy 하는 user로 (정석환 차장 요청)" ).append("\n"); 
		query.append("     , @[cre_ofc_cd] CFM_OFC_CD --confirm office를 copy 하는 user office로 (정석환 차장 요청)" ).append("\n"); 
		query.append("     , @[cre_ofc_cd] CRE_OFC_CD" ).append("\n"); 
		query.append("     , @[cre_usr_id]" ).append("\n"); 
		query.append("     , SYSDATE" ).append("\n"); 
		query.append("     , @[upd_usr_id]" ).append("\n"); 
		query.append("     , SYSDATE" ).append("\n"); 
		query.append(" FROM PRI_TRF_FDR_MN MN" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("   AND MN.SVC_SCP_CD     = @[ori_svc_scp_cd] " ).append("\n"); 
		query.append("   AND MN.ORG_DEST_TP_CD = @[org_dest_tp_cd]" ).append("\n"); 
		query.append("   AND MN.FDR_TRF_NO     = @[ori_fdr_trf_no] " ).append("\n"); 
		query.append("   AND MN.AMDT_SEQ       = @[ori_amdt_seq]" ).append("\n"); 

	}
}