/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : RASCommonDBDAOSearchCodRequestResonCodeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.08
*@LastModifier : 
*@LastVersion : 1.0
* 2013.07.08 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.revenueauditcommon.rascommon.rascommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RASCommonDBDAOSearchCodRequestResonCodeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * COD Request Resaon Code 조회
	  * </pre>
	  */
	public RASCommonDBDAOSearchCodRequestResonCodeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.revenueauditcommon.rascommon.rascommon.integration").append("\n"); 
		query.append("FileName : RASCommonDBDAOSearchCodRequestResonCodeListRSQL").append("\n"); 
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
		query.append("SELECT   INTG_CD_VAL_CTNT CD" ).append("\n"); 
		query.append(",        INTG_CD_VAL_DESC NM" ).append("\n"); 
		query.append("FROM     COM_INTG_CD_DTL" ).append("\n"); 
		query.append("WHERE    INTG_CD_ID = 'CD02153'" ).append("\n"); 
		query.append("AND      (APLY_ST_DT <= TO_CHAR(SYSDATE, 'YYYYMMDD') AND APLY_END_DT >= TO_CHAR(SYSDATE, 'YYYYMMDD'))" ).append("\n"); 
		query.append("ORDER BY INTG_CD_VAL_DP_SEQ" ).append("\n"); 

	}
}