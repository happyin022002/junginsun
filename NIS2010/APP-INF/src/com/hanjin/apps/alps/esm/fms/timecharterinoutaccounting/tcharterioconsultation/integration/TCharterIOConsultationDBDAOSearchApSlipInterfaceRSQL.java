/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : TCharterIOConsultationDBDAOSearchApSlipInterfaceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.28
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2014.07.28 민정호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Ho Min
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOConsultationDBDAOSearchApSlipInterfaceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 전표 품위자의 정보 변환 조회
	  * </pre>
	  */
	public TCharterIOConsultationDBDAOSearchApSlipInterfaceRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration").append("\n"); 
		query.append("FileName : TCharterIOConsultationDBDAOSearchApSlipInterfaceRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append(" J.CSR_USR_ID" ).append("\n"); 
		query.append(",J.SLP_OFC_CD" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("    SELECT A.USR_EML FROM COM_USER A" ).append("\n"); 
		query.append("    WHERE A.USR_ID = J.CSR_USR_ID" ).append("\n"); 
		query.append(" ) AS USR_EML" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("    SELECT A.USR_NM FROM COM_USER A" ).append("\n"); 
		query.append("    WHERE A.USR_ID = J.CSR_USR_ID" ).append("\n"); 
		query.append(" ) AS USR_NM" ).append("\n"); 
		query.append("FROM FMS_CONSULTATION J" ).append("\n"); 
		query.append("WHERE J.SLP_TP_CD||J.SLP_FUNC_CD||J.SLP_OFC_CD||J.SLP_ISS_DT||J.SLP_SER_NO = @[csr_no]" ).append("\n"); 

	}
}