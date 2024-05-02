/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : TCharterIOConsultationDBDAOPrintFmsCsrAgmtInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.12
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2014.12.12 민정호
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

public class TCharterIOConsultationDBDAOPrintFmsCsrAgmtInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * groupware 전송 xmlData Agreement info
	  * </pre>
	  */
	public TCharterIOConsultationDBDAOPrintFmsCsrAgmtInfoRSQL(){
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
		query.append("FileName : TCharterIOConsultationDBDAOPrintFmsCsrAgmtInfoRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append(" FC2.AGMT_DOC_NO 	AS l_assetcd  		" ).append("\n"); 
		query.append(",FC2.AGMT_DOC_DESC	AS l_document_title 	" ).append("\n"); 
		query.append("FROM FMS_CONSULTATION FC" ).append("\n"); 
		query.append("    ,FMS_CONTRACT FC2" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND FC.FLET_CTRT_NO = FC2.FLET_CTRT_NO" ).append("\n"); 
		query.append("AND    FC.SLP_TP_CD" ).append("\n"); 
		query.append("    || FC.SLP_FUNC_CD" ).append("\n"); 
		query.append("    || FC.SLP_OFC_CD" ).append("\n"); 
		query.append("    || FC.SLP_ISS_DT" ).append("\n"); 
		query.append("    || FC.SLP_SER_NO = @[csr_no]" ).append("\n"); 
		query.append("AND FC2.AGMT_DOC_NO IS NOT NULL   " ).append("\n"); 

	}
}