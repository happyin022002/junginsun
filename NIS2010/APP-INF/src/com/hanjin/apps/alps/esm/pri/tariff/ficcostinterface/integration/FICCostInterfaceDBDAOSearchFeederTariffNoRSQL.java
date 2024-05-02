/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : FICCostInterfaceDBDAOSearchFeederTariffNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.07
*@LastModifier : CHLOE MIJIN SEO
*@LastVersion : 1.0
* 2012.11.07 CHLOE MIJIN SEO
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.tariff.ficcostinterface.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHLOE MIJIN SEO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FICCostInterfaceDBDAOSearchFeederTariffNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * FDR_TRF_NO 조회
	  * </pre>
	  */
	public FICCostInterfaceDBDAOSearchFeederTariffNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_dest_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.tariff.ficcostinterface.integration").append("\n"); 
		query.append("FileName : FICCostInterfaceDBDAOSearchFeederTariffNoRSQL").append("\n"); 
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
		query.append("SELECT @[svc_scp_cd] || DECODE(@[org_dest_tp_cd],'D','I','O','O') || SUBSTR(@[rhq_cd], 1, 3) || TO_CHAR(SYSDATE, 'YY') " ).append("\n"); 
		query.append("||  NVL(TO_CHAR(TO_NUMBER(SUBSTR(TRF_NO, 10, 2))+1,'FM09'), '01'  ) FDR_TRF_NO" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT MAX( FDR_TRF_NO ) AS TRF_NO" ).append("\n"); 
		query.append("    FROM PRI_TRF_FDR_HDR" ).append("\n"); 
		query.append("    WHERE SVC_SCP_CD = @[svc_scp_cd]  AND ORG_DEST_TP_CD = @[org_dest_tp_cd] AND RHQ_CD = @[rhq_cd]" ).append("\n"); 
		query.append("    )" ).append("\n"); 

	}
}