/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOSearchEdoDoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.09
*@LastModifier : 
*@LastVersion : 1.0
* 2009.07.09 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOSearchEdoDoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UI_BKG_0133 화면에서 사용하는 쿼리이다.
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOSearchEdoDoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqstNo",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tpCd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOSearchEdoDoRSQL").append("\n"); 
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
		query.append("SELECT A.PAYR_NM," ).append("\n"); 
		query.append("A.PAY_AMT_CTNT," ).append("\n"); 
		query.append("A.PAY_CURR_CD," ).append("\n"); 
		query.append("A.PAYR_BANK_NM," ).append("\n"); 
		query.append("A.PAYR_BANK_ACCT_NO," ).append("\n"); 
		query.append("TO_CHAR(A.RQST_EDO_ISS_DT, 'YYYY-MM-DD') AS RQST_EDO_ISS_DT" ).append("\n"); 
		query.append("FROM BKG_EDO_DO A," ).append("\n"); 
		query.append("BKG_EDO_MST B" ).append("\n"); 
		query.append("WHERE A.EDO_RQST_NO  = @[rqstNo]" ).append("\n"); 
		query.append("AND A.EDO_RQST_SEQ = (SELECT MAX(EDO_RQST_SEQ)" ).append("\n"); 
		query.append("FROM BKG_EDO_MST" ).append("\n"); 
		query.append("WHERE EDO_RQST_NO  = @[rqstNo]" ).append("\n"); 
		query.append("AND EDO_TP_CD    = @[tpCd])" ).append("\n"); 
		query.append("AND A.EDO_RQST_NO  = B.EDO_RQST_NO" ).append("\n"); 
		query.append("AND A.EDO_RQST_SEQ = B.EDO_RQST_SEQ" ).append("\n"); 
		query.append("AND B.EDO_TP_CD    = @[tpCd]" ).append("\n"); 

	}
}