/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : TCharterIOConsultationDBDAOCustomConsultationVOUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.01
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.01 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOConsultationDBDAOCustomConsultationVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public TCharterIOConsultationDBDAOCustomConsultationVOUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cxl_desc",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration").append("\n"); 
		query.append("FileName : TCharterIOConsultationDBDAOCustomConsultationVOUSQL").append("\n"); 
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
		query.append("#if (${modify_type} == 'Approval') " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	UPDATE FMS_CONSULTATION SET " ).append("\n"); 
		query.append("		APRO_FLG = 'Y'" ).append("\n"); 
		query.append("    ,	APRO_DT = SYSDATE" ).append("\n"); 
		query.append("	,	UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("	,	UPD_DT = SYSDATE" ).append("\n"); 
		query.append("	WHERE	SLP_TP_CD || SLP_FUNC_CD || SLP_OFC_CD || SLP_ISS_DT || SLP_SER_NO 	= @[csr_no]" ).append("\n"); 
		query.append("#elseif (${modify_type} == 'Cancel') " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	UPDATE FMS_CONSULTATION SET " ).append("\n"); 
		query.append("		APRO_FLG = 'N'" ).append("\n"); 
		query.append("	,	CXL_FLG = 'Y'" ).append("\n"); 
		query.append("	,	CXL_DESC = @[cxl_desc]" ).append("\n"); 
		query.append("	,	UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("	,	UPD_DT = SYSDATE" ).append("\n"); 
		query.append("	WHERE	SLP_TP_CD || SLP_FUNC_CD || SLP_OFC_CD || SLP_ISS_DT || SLP_SER_NO 	= @[csr_no]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${modify_type} == 'CancelOrigin') " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	UPDATE FMS_CSUL_SLP A SET " ).append("\n"); 
		query.append("		STL_FLG = 'N'" ).append("\n"); 
		query.append("	,	UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("	,	UPD_DT = SYSDATE" ).append("\n"); 
		query.append("	WHERE	EXISTS (SELECT NULL " ).append("\n"); 
		query.append("					FROM   FMS_CSUL_SLP " ).append("\n"); 
		query.append("					WHERE  SLP_TP_CD || SLP_FUNC_CD || SLP_OFC_CD || SLP_ISS_DT || SLP_SER_NO = @[csr_no]" ).append("\n"); 
		query.append("					AND    ORG_SLP_TP_CD   = A.SLP_TP_CD" ).append("\n"); 
		query.append("					AND    ORG_SLP_FUNC_CD = A.SLP_FUNC_CD " ).append("\n"); 
		query.append("					AND    ORG_SLP_OFC_CD  = A.SLP_OFC_CD " ).append("\n"); 
		query.append("					AND    ORG_ISS_DT      = A.SLP_ISS_DT " ).append("\n"); 
		query.append("					AND    ORG_SLP_SER_NO  = A.SLP_SER_NO " ).append("\n"); 
		query.append("					AND    ORG_SLP_SEQ_NO  = A.SLP_SEQ_NO) " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}