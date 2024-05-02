/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AgreementImportDBDAOMultiCorrRateAgmtRateTypeCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.04
*@LastModifier : 신동일
*@LastVersion : 1.0
* 2015.12.04 신동일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DONG- IL, SHIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AgreementImportDBDAOMultiCorrRateAgmtRateTypeCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Rate Type Update
	  * </pre>
	  */
	public AgreementImportDBDAOMultiCorrRateAgmtRateTypeCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_account_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_trsp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trsp_cost_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_nomi_trkr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rail_svc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_nomi_trkr_ind_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_account_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_agmt_rt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.integration").append("\n"); 
		query.append("FileName : AgreementImportDBDAOMultiCorrRateAgmtRateTypeCSQL").append("\n"); 
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
		query.append("INSERT INTO TRS_AGMT_RT_TP (" ).append("\n"); 
		query.append("	   TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("	  ,TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("	  ,TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("	  ,TRSP_AGMT_RT_TP_CD" ).append("\n"); 
		query.append("	  ,CGO_TP_CD" ).append("\n"); 
		query.append("	  ,CUST_NOMI_TRKR_FLG" ).append("\n"); 
		query.append("      ,CUST_NOMI_TRKR_IND_CD" ).append("\n"); 
		query.append("	  ,CUST_CNT_CD" ).append("\n"); 
		query.append("	  ,CUST_SEQ" ).append("\n"); 
		query.append("	  ,TRSP_COST_MOD_CD" ).append("\n"); 
		query.append("	  ,AGMT_TRSP_TP_CD" ).append("\n"); 
		query.append("	  ,CMDT_GRP_CD" ).append("\n"); 
		query.append("	  ,RAIL_SVC_TP_CD" ).append("\n"); 
		query.append("	  ,CRE_USR_ID" ).append("\n"); 
		query.append("	  ,CRE_DT" ).append("\n"); 
		query.append("	  ,CRE_OFC_CD" ).append("\n"); 
		query.append("	  ,UPD_USR_ID" ).append("\n"); 
		query.append("	  ,UPD_OFC_CD" ).append("\n"); 
		query.append("	  ,UPD_DT" ).append("\n"); 
		query.append(" )VALUES (" ).append("\n"); 
		query.append("	   @[trsp_agmt_ofc_cty_cd]" ).append("\n"); 
		query.append("	  ,@[trsp_agmt_seq]" ).append("\n"); 
		query.append("	  ,(SELECT NVL(MAX(TRSP_AGMT_RT_TP_SER_NO),0) + 1 FROM TRS_AGMT_RT_TP WHERE TRSP_AGMT_OFC_CTY_CD = @[trsp_agmt_ofc_cty_cd] AND TRSP_AGMT_SEQ = @[trsp_agmt_seq])" ).append("\n"); 
		query.append("	  ,@[trsp_agmt_rt_tp_cd]" ).append("\n"); 
		query.append("	  ,@[cgo_tp_cd]" ).append("\n"); 
		query.append("	  ,@[cust_nomi_trkr_flg]" ).append("\n"); 
		query.append("      ,NVL(@[cust_nomi_trkr_ind_cd],'HJS')" ).append("\n"); 
		query.append("	  ,@[cust_cnt_cd]" ).append("\n"); 
		query.append("	  ,@[cust_seq]" ).append("\n"); 
		query.append("	  ,@[trsp_cost_mod_cd]" ).append("\n"); 
		query.append("	  ,@[agmt_trsp_tp_cd]" ).append("\n"); 
		query.append("	  ,@[cmdt_grp_cd]" ).append("\n"); 
		query.append("	  ,@[rail_svc_tp_cd]" ).append("\n"); 
		query.append("	  ,@[fm_account_usr_id]" ).append("\n"); 
		query.append("	  ,SYSDATE" ).append("\n"); 
		query.append("	  ,@[fm_account_ofc_cd]" ).append("\n"); 
		query.append("	  ,@[fm_account_usr_id]" ).append("\n"); 
		query.append("	  ,@[fm_account_ofc_cd] " ).append("\n"); 
		query.append("	  ,SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}