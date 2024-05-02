/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TCharterIOConsultationDBDAOAgmtCfmCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.04
*@LastModifier : 
*@LastVersion : 1.0
* 2015.09.04 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOConsultationDBDAOAgmtCfmCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public TCharterIOConsultationDBDAOAgmtCfmCdRSQL(){
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
		query.append("FileName : TCharterIOConsultationDBDAOAgmtCfmCdRSQL").append("\n"); 
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
		query.append("SELECT CASE WHEN (" ).append("\n"); 
		query.append("                  CASE WHEN COUNT(1) > 0 THEN 1" ).append("\n"); 
		query.append("                          ELSE 0" ).append("\n"); 
		query.append("                          END" ).append("\n"); 
		query.append("                 ) > 0 THEN 'Y' " ).append("\n"); 
		query.append("              ELSE 'N'     " ).append("\n"); 
		query.append("              END AGMT_CNT_YN" ).append("\n"); 
		query.append("FROM FMS_CONSULTATION FC" ).append("\n"); 
		query.append("    ,FMS_CONTRACT FC2" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND FC.FLET_CTRT_NO = FC2.FLET_CTRT_NO" ).append("\n"); 
		query.append("AND    FC.SLP_TP_CD" ).append("\n"); 
		query.append("    || FC.SLP_FUNC_CD" ).append("\n"); 
		query.append("    || FC.SLP_OFC_CD" ).append("\n"); 
		query.append("    || FC.SLP_ISS_DT" ).append("\n"); 
		query.append("    || FC.SLP_SER_NO = @[csr_no]" ).append("\n"); 
		query.append("AND FC2.AGMT_DOC_NO IS NOT NULL" ).append("\n"); 

	}
}