/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GEMConsultationSlipDBDAOModifyCSRRequestUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.10
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.10 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.gem.gemconsultationslip.gemconsultationslip.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GEMConsultationSlipDBDAOModifyCSRRequestUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * csr no udpate
	  * </pre>
	  */
	public GEMConsultationSlipDBDAOModifyCSRRequestUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gen_expn_rqst_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pln_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gen_expn_rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.cps.gem.gemconsultationslip.gemconsultationslip.integration").append("\n"); 
		query.append("FileName : GEMConsultationSlipDBDAOModifyCSRRequestUSQL").append("\n"); 
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
		query.append("UPDATE GEM_REQUEST SET" ).append("\n"); 
		query.append("UPD_DT = sysdate" ).append("\n"); 
		query.append("#if (${pln_yrmon} != '') " ).append("\n"); 
		query.append(",	PLN_YRMON = @[pln_yrmon]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${gen_expn_rqst_tp_cd} != '') " ).append("\n"); 
		query.append(",	GEN_EXPN_RQST_TP_CD = @[gen_expn_rqst_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rqst_ofc_cd} != '') " ).append("\n"); 
		query.append(",	RQST_OFC_CD = @[rqst_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${upd_usr_id} != '') " ).append("\n"); 
		query.append(",	UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",      GEN_EXPN_RQST_NO = @[gen_expn_rqst_no]" ).append("\n"); 
		query.append("WHERE	GEN_EXPN_RQST_NO = (" ).append("\n"); 
		query.append("SELECT MAX (GEN_EXPN_RQST_NO) GEN_EXPN_RQST_NO" ).append("\n"); 
		query.append("FROM   GEM_REQUEST" ).append("\n"); 
		query.append("WHERE  GEN_EXPN_RQST_NO LIKE  RQST_OFC_CD || TO_CHAR (GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[rqst_ofc_cd]), 'YYYYMMDD') ||   '%'" ).append("\n"); 
		query.append("AND GEN_EXPN_RQST_TP_CD = @[gen_expn_rqst_tp_cd]" ).append("\n"); 
		query.append("AND RQST_OFC_CD = @[rqst_ofc_cd])" ).append("\n"); 

	}
}