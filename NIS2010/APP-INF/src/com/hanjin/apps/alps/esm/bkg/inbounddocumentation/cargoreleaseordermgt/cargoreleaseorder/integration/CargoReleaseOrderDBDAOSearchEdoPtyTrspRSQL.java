/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOSearchEdoPtyTrspRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.01.31
*@LastModifier : 
*@LastVersion : 1.0
* 2012.01.31 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOSearchEdoPtyTrspRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UI_BKG_0133에서 사용하는 SQL문이다.
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOSearchEdoPtyTrspRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOSearchEdoPtyTrspRSQL").append("\n"); 
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
		query.append("SELECT A.EDO_RQST_NO," ).append("\n"); 
		query.append("       A.EDO_RQST_SEQ," ).append("\n"); 
		query.append("       A.EDO_PTY_CD," ).append("\n"); 
		query.append("       A.PTY_RGST_NO," ).append("\n"); 
		query.append("       A.PTY_CNTC_PSON_NM," ).append("\n"); 
		query.append("       A.PTY_REP_NM," ).append("\n"); 
		query.append("       A.PHN_NO," ).append("\n"); 
		query.append("       A.PTY_NM1," ).append("\n"); 
		query.append("       A.PTY_NM2," ).append("\n"); 
		query.append("       A.PTY_NM3," ).append("\n"); 
		query.append("       A.PTY_ADDR1," ).append("\n"); 
		query.append("       A.PTY_ADDR2," ).append("\n"); 
		query.append("       A.PTY_ADDR3," ).append("\n"); 
		query.append("       A.CRE_USR_ID," ).append("\n"); 
		query.append("       A.CRE_DT," ).append("\n"); 
		query.append("       A.UPD_USR_ID," ).append("\n"); 
		query.append("       A.UPD_DT," ).append("\n"); 
		query.append("	   A.PTY_EML" ).append("\n"); 
		query.append("  FROM BKG_EDO_PTY_TRSP A," ).append("\n"); 
		query.append("       BKG_EDO_MST      B" ).append("\n"); 
		query.append(" WHERE A.EDO_RQST_NO  = @[rqstNo]" ).append("\n"); 
		query.append("   AND A.EDO_RQST_SEQ = (SELECT MAX(EDO_RQST_SEQ)" ).append("\n"); 
		query.append("                           FROM BKG_EDO_MST" ).append("\n"); 
		query.append("                          WHERE EDO_RQST_NO    = @[rqstNo]" ).append("\n"); 
		query.append("                            AND EDO_TP_CD      = @[tpCd])" ).append("\n"); 
		query.append("   AND A.EDO_RQST_NO  = B.EDO_RQST_NO" ).append("\n"); 
		query.append("   AND A.EDO_RQST_SEQ = B.EDO_RQST_SEQ" ).append("\n"); 
		query.append("   AND B.EDO_TP_CD    = @[tpCd]" ).append("\n"); 

	}
}