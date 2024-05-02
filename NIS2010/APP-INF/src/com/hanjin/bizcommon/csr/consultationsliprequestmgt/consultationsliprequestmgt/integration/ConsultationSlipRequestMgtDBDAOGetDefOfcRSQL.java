/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ConsultationSlipRequestMgtDBDAOGetDefOfcRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.24
*@LastModifier : 
*@LastVersion : 1.0
* 2015.09.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ConsultationSlipRequestMgtDBDAOGetDefOfcRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * default ofc구하기
	  * </pre>
	  */
	public ConsultationSlipRequestMgtDBDAOGetDefOfcRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.integration").append("\n"); 
		query.append("FileName : ConsultationSlipRequestMgtDBDAOGetDefOfcRSQL").append("\n"); 
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
		query.append("SELECT  WKPLC_NM DEF_OFC" ).append("\n"); 
		query.append("FROM    AP_WORKPLACE" ).append("\n"); 
		query.append("WHERE   1 = 1" ).append("\n"); 
		query.append("AND     (INACT_DT IS NULL OR (INACT_DT IS NOT NULL AND SYSDATE < INACT_DT))" ).append("\n"); 
		query.append("AND     SUBSTR(WKPLC_NM,1,3) = SUBSTR(@[ofc_cd],1,3)" ).append("\n"); 
		query.append("AND     ROWNUM =1" ).append("\n"); 

	}
}