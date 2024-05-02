/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : JointOperationConsultationDBDAOCsrVOUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.02
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.02 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationConsultationDBDAOCsrVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Approval   
	  * </pre>
	  */
	public JointOperationConsultationDBDAOCsrVOUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("apro_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cxl_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.integration").append("\n"); 
		query.append("FileName : JointOperationConsultationDBDAOCsrVOUSQL").append("\n"); 
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
		query.append("UPDATE JOO_CSR X SET" ).append("\n"); 
		query.append("	APRO_FLG = @[apro_flg]" ).append("\n"); 
		query.append(",   APRO_DT = DECODE(@[apro_flg],'Y',GLOBALDATE_PKG.TIME_LOCAL_FNC((" ).append("\n"); 
		query.append("           SELECT A.LOC_CD" ).append("\n"); 
		query.append("           FROM   MDM_ORGANIZATION A" ).append("\n"); 
		query.append("           WHERE  A.OFC_CD = X.SLP_ISS_OFC_CD" ).append("\n"); 
		query.append("        )),NULL)" ).append("\n"); 
		query.append(",	CXL_FLG = @[cxl_flg]" ).append("\n"); 
		query.append(",	CXL_DESC = @[cxl_desc]" ).append("\n"); 
		query.append(",   UPD_DT   = SYSDATE" ).append("\n"); 
		query.append(",   UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("WHERE 1= 1" ).append("\n"); 
		query.append("AND   SLP_TP_CD || SLP_FUNC_CD || SLP_OFC_CD || SLP_ISS_DT || SLP_SER_NO  = @[csr_no]" ).append("\n"); 

	}
}