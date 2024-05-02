/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : FICCostInterfaceDBDAOSearchIhcTariffNoRSQL.java
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

public class FICCostInterfaceDBDAOSearchIhcTariffNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * IHC_TRF_NO 조회
	  * </pre>
	  */
	public FICCostInterfaceDBDAOSearchIhcTariffNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : FICCostInterfaceDBDAOSearchIhcTariffNoRSQL").append("\n"); 
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
		query.append("SELECT @[svc_scp_cd] || DECODE(@[org_dest_tp_cd],'D','I','O','O') || @[cnt_cd]  || TO_CHAR(SYSDATE, 'YY')  " ).append("\n"); 
		query.append("||  NVL(TO_CHAR(TO_NUMBER(SUBSTR(TRF_NO, 9, 2))+1,'FM09'), '01'  ) IHC_TRF_NO" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    select MAX( IHC_TRF_NO ) AS TRF_NO" ).append("\n"); 
		query.append("    FROM PRI_TRF_IHC_HDR" ).append("\n"); 
		query.append("    where SVC_SCP_CD = @[svc_scp_cd]  and ORG_DEST_TP_CD = @[org_dest_tp_cd]  and COST_CNT_CD = @[cnt_cd] " ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}