/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ARInvoiceExRateMgtDBDAOSearch3rdExRateNotExistRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.10
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.10 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceExRateMgtDBDAOSearch3rdExRateNotExistRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search3rdExRateNotExist
	  * </pre>
	  */
	public ARInvoiceExRateMgtDBDAOSearch3rdExRateNotExistRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("multi_office_list",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.integration").append("\n"); 
		query.append("FileName : ARInvoiceExRateMgtDBDAOSearch3rdExRateNotExistRSQL").append("\n"); 
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
		query.append("SELECT SUBSTR(MAX(RPAD(LEVEL, 16) || SYS_CONNECT_BY_PATH(AA.VVD_CD||' '||AA.BND, ' , ')), 20) VVD_LIST" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT A.FM_DT" ).append("\n"); 
		query.append("          ,B.VSL_CD||B.SKD_VOY_NO||B.SKD_DIR_CD VVD_CD" ).append("\n"); 
		query.append("          ,DECODE(B.IO_BND_CD,'O','O/B','I/B') BND" ).append("\n"); 
		query.append("          ,ROW_NUMBER() OVER(PARTITION BY A.FM_DT ORDER BY B.VSL_CD||B.SKD_VOY_NO||B.SKD_DIR_CD) AS RN" ).append("\n"); 
		query.append("      FROM INV_CUST_AND_DLY_XCH_RT A, INV_VVD_XCH_RT_DT B" ).append("\n"); 
		query.append("     WHERE A.FM_DT = B.XCH_RT_DT" ).append("\n"); 
		query.append("      AND A.AR_OFC_CD = B.AR_OFC_CD" ).append("\n"); 
		query.append("      AND A.AR_OFC_CD IN ( @[multi_office_list] )" ).append("\n"); 
		query.append("      AND A.FM_DT = @[fm_dt]" ).append("\n"); 
		query.append("      AND NOT EXISTS (SELECT 'X' FROM INV_VVD_XCH_RT C" ).append("\n"); 
		query.append("                      WHERE B.XCH_RT_DT = C.XCH_RT_DT" ).append("\n"); 
		query.append("                       AND B.VSL_CD = C.VSL_CD" ).append("\n"); 
		query.append("                       AND B.SKD_VOY_NO = C.SKD_VOY_NO" ).append("\n"); 
		query.append("                       AND B.SKD_DIR_CD = C.SKD_DIR_CD" ).append("\n"); 
		query.append("                       AND B.PORT_CD = C.PORT_CD" ).append("\n"); 
		query.append("                       AND B.SVC_SCP_CD = C.SVC_SCP_CD" ).append("\n"); 
		query.append("                       AND B.IO_BND_CD = C.IO_BND_CD" ).append("\n"); 
		query.append("                       AND B.AR_OFC_CD = C.AR_OFC_CD)" ).append("\n"); 
		query.append("      GROUP BY A.FM_DT, B.VSL_CD||B.SKD_VOY_NO||B.SKD_DIR_CD, B.IO_BND_CD) AA" ).append("\n"); 
		query.append("CONNECT BY PRIOR RN = RN - 1 AND PRIOR AA.FM_DT = AA.FM_DT" ).append("\n"); 
		query.append("GROUP BY AA.FM_DT" ).append("\n"); 
		query.append("ORDER BY AA.FM_DT" ).append("\n"); 

	}
}