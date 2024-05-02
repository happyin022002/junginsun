/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AccountReceivableAgentDBDAOSearchAcutalOTSAmtByOffcdRSQL.java
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

public class AccountReceivableAgentDBDAOSearchAcutalOTSAmtByOffcdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search OTS Amount By Offce code
	  * </pre>
	  */
	public AccountReceivableAgentDBDAOSearchAcutalOTSAmtByOffcdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ots_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("asa_prd_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.integration").append("\n"); 
		query.append("FileName : AccountReceivableAgentDBDAOSearchAcutalOTSAmtByOffcdRSQL").append("\n"); 
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
		query.append("SELECT NVL(SUM(ROUND(NVL(SOD.BAL_AMT,0) * NVL(SAR_GET_GL_XCH_RT_FNC('1',GLX.MAX_XCH_DT,SOD.BL_CURR_CD,'USD'),0),2)),0) AS OTS_USD_AMT            " ).append("\n"); 
		query.append("  FROM   SAR_OTS_HDR   SOH " ).append("\n"); 
		query.append("       , SAR_OTS_DTL   SOD" ).append("\n"); 
		query.append("	   , (SELECT MAX(ACCT_XCH_RT_DT) MAX_XCH_DT" ).append("\n"); 
		query.append("          FROM    GL_DLY_XCH_RT" ).append("\n"); 
		query.append("          WHERE   ACCT_XCH_RT_LVL = '1') GLX" ).append("\n"); 
		query.append("  WHERE 1=1" ).append("\n"); 
		query.append("  AND SOH.RHQ_CD              = SOD.RHQ_CD" ).append("\n"); 
		query.append("  AND SOH.OTS_OFC_CD          = SOD.OTS_OFC_CD" ).append("\n"); 
		query.append("  AND SOH.BL_NO               = SOD.BL_NO " ).append("\n"); 
		query.append("  AND SOH.INV_NO              = SOD.INV_NO" ).append("\n"); 
		query.append("  AND SOH.OTS_TP_CD IS NULL" ).append("\n"); 
		query.append("  AND SOH.REV_TP_SRC_CD != 'ASA'" ).append("\n"); 
		query.append("  AND SOH.OTS_OFC_CD          = @[ots_ofc_cd] " ).append("\n"); 
		query.append("  AND SOH.DUE_DT <=  REPLACE(@[asa_prd_to_dt],'-','')     -- period_to" ).append("\n"); 

	}
}