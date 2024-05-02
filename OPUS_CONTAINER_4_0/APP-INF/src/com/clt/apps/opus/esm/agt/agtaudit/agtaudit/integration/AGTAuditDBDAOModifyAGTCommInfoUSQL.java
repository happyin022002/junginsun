/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AGTAuditDBDAOModifyAGTCommInfoUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.19
*@LastModifier : 이호진
*@LastVersion : 1.0
* 2010.02.19 이호진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.agt.agtaudit.agtaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Ho Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGTAuditDBDAOModifyAGTCommInfoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyAGTCommInfo
	  * </pre>
	  */
	public AGTAuditDBDAOModifyAGTCommInfoUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.agt.agtaudit.agtaudit.integration").append("\n"); 
		query.append("FileName : AGTAuditDBDAOModifyAGTCommInfoUSQL").append("\n"); 
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
		query.append("UPDATE AGT_AGN_COMM A" ).append("\n"); 
		query.append("SET A.COMM_PROC_STS_CD  = 'IF'," ).append("\n"); 
		query.append("A.COMM_PROC_STS_RSN = 'Interface OK!'," ).append("\n"); 
		query.append("A.ACCL_FLG          = 'Y'," ).append("\n"); 
		query.append("A.AC_IF_USR_ID      = 'AGT System'," ).append("\n"); 
		query.append("A.AC_IF_DT" ).append("\n"); 
		query.append("=" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',SYSDATE,LOC_CD)" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("WHERE OFC_CD = DECODE(VNDR_CNT_CD,'CN',A.AR_OFC_CD,A.AGN_CD) AND NVL(DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("A.UPD_USR_ID        = 'AGT System'," ).append("\n"); 
		query.append("A.UPD_DT            = SYSDATE" ).append("\n"); 
		query.append("WHERE A.CSR_NO            = @[csr_no]" ).append("\n"); 

	}
}