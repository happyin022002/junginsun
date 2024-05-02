/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AccountReceivableAgentDBDAOSearchAsaUsdTtlAmtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.28
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.28 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableAgentDBDAOSearchAsaUsdTtlAmtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ASA Collect & Refund USD Total Amount By ASA_NO
	  * </pre>
	  */
	public AccountReceivableAgentDBDAOSearchAsaUsdTtlAmtRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("asa_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.integration").append("\n"); 
		query.append("FileName : AccountReceivableAgentDBDAOSearchAsaUsdTtlAmtRSQL").append("\n"); 
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
		query.append("SELECT NVL(SUM(NVL(ACF.USD_AMT, 0) + ROUND(NVL(ACF.LOCL_AMT, 0) * NVL(SAR_GET_GL_XCH_RT_FNC('1',GLX.MAX_XCH_DT,ACF.LOCL_CURR_CD,'USD'),0),2)" ).append("\n"); 
		query.append("                                   + ROUND(NVL(ACF.N3RD_AMT1, 0) * NVL(SAR_GET_GL_XCH_RT_FNC('1',GLX.MAX_XCH_DT,ACF.N3RD_CURR_CD1,'USD'),0),2)" ).append("\n"); 
		query.append("                                   + ROUND(NVL(ACF.N3RD_AMT2, 0) * NVL(SAR_GET_GL_XCH_RT_FNC('1',GLX.MAX_XCH_DT,ACF.N3RD_CURR_CD2,'USD'),0),2)" ).append("\n"); 
		query.append("                                   + ROUND(NVL(ACF.N3RD_AMT3, 0) * NVL(SAR_GET_GL_XCH_RT_FNC('1',GLX.MAX_XCH_DT,ACF.N3RD_CURR_CD3,'USD'),0),2)" ).append("\n"); 
		query.append("                                   + ROUND(NVL(ACF.N3RD_AMT4, 0) * NVL(SAR_GET_GL_XCH_RT_FNC('1',GLX.MAX_XCH_DT,ACF.N3RD_CURR_CD4,'USD'),0),2)),0) ASA_USD_AMT" ).append("\n"); 
		query.append("          FROM   SAR_AGN_CLT_RFND_MST ACF" ).append("\n"); 
		query.append("               , SAR_OTS_HDR   SOH" ).append("\n"); 
		query.append("			   , (SELECT MAX(ACCT_XCH_RT_DT) MAX_XCH_DT" ).append("\n"); 
		query.append("                  FROM    GL_DLY_XCH_RT" ).append("\n"); 
		query.append("                  WHERE   ACCT_XCH_RT_LVL = '1') GLX" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("          AND    ACF.ASA_NO      = @[asa_no]" ).append("\n"); 
		query.append("          AND    ACF.BL_NO       = SOH.BL_NO" ).append("\n"); 
		query.append("		  AND    ACF.INV_NO      = SOH.INV_NO" ).append("\n"); 
		query.append("          AND    ACF.AR_OFC_CD   = SOH.OTS_OFC_CD" ).append("\n"); 
		query.append("          AND    SOH.OTS_TP_CD IS NULL" ).append("\n"); 

	}
}