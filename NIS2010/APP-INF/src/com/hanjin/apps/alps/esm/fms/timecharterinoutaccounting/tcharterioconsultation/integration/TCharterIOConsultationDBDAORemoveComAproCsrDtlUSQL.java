/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : TCharterIOConsultationDBDAORemoveComAproCsrDtlUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.06.12
*@LastModifier : 
*@LastVersion : 1.0
* 2017.06.12 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOConsultationDBDAORemoveComAproCsrDtlUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Remove Com Apro Csr Dtl
	  * </pre>
	  */
	public TCharterIOConsultationDBDAORemoveComAproCsrDtlUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration ").append("\n"); 
		query.append("FileName : TCharterIOConsultationDBDAORemoveComAproCsrDtlUSQL").append("\n"); 
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
		query.append("UPDATE COM_APRO_CSR_DTL" ).append("\n"); 
		query.append("SET DELT_FLG = 'Y'" ).append("\n"); 
		query.append("WHERE APRO_RQST_NO IN (SELECT A.APRO_RQST_NO" ).append("\n"); 
		query.append("                       FROM COM_APRO_RQST_HDR A," ).append("\n"); 
		query.append("                            COM_APRO_CSR_DTL B" ).append("\n"); 
		query.append("                       WHERE A.APRO_RQST_NO = B.APRO_RQST_NO" ).append("\n"); 
		query.append("                       AND A.SUB_SYS_CD = 'FMS'" ).append("\n"); 
		query.append("                       AND B.CSR_NO = @[csr_no])" ).append("\n"); 

	}
}