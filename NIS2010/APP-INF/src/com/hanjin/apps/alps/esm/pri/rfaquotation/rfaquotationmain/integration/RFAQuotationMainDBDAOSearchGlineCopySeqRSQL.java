/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFAQuotationMainDBDAOSearchGlineCopySeqRSQL.java
*@FileTitle : RFA Quotation Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.02
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.09.02 이승준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaquotation.rfaquotationmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Seung-Jun,Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAQuotationMainDBDAOSearchGlineCopySeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * gline copy seq 조회
	  * </pre>
	  */
	public RFAQuotationMainDBDAOSearchGlineCopySeqRSQL(){
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
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaquotation.rfaquotationmain.integration").append("\n"); 
		query.append("FileName : RFAQuotationMainDBDAOSearchGlineCopySeqRSQL").append("\n"); 
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
		query.append("SELECT  GLINE_SEQ" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT SVC_SCP_CD" ).append("\n"); 
		query.append(", GLINE_SEQ" ).append("\n"); 
		query.append(", ROW_NUMBER() OVER (ORDER BY EFF_DT DESC) AS SEQ" ).append("\n"); 
		query.append("FROM  PRI_RG_MN" ).append("\n"); 
		query.append("WHERE SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND   CFM_FLG = 'Y'" ).append("\n"); 
		query.append("AND   TO_CHAR(EFF_DT,'YYYY-MM-DD') <= @[eff_dt]" ).append("\n"); 
		query.append("AND   TO_CHAR(EXP_DT,'YYYY-MM-DD') >= @[eff_dt]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE SEQ = 1" ).append("\n"); 

	}
}