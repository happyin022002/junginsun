/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountReceivableAgentDBDAOSearchDuplicateColRfndRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.09
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.09 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableAgentDBDAOSearchDuplicateColRfndRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchDuplicateColRfnd
	  * </pre>
	  */
	public AccountReceivableAgentDBDAOSearchDuplicateColRfndRSQL(){
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
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.integration ").append("\n"); 
		query.append("FileName : AccountReceivableAgentDBDAOSearchDuplicateColRfndRSQL").append("\n"); 
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
		query.append("SELECT SUBSTR(XMLAGG (XMLELEMENT (X , ',', BL_NO) ORDER BY BL_NO).EXTRACT ( '//text()' ), 2) BL_LIST" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("        SELECT DISTINCT BL_NO" ).append("\n"); 
		query.append("        FROM (" ).append("\n"); 
		query.append("              SELECT AR_OFC_CD, BL_NO, INV_NO, CHG_TP_CD, 'USD' BL_CURR_CD, USD_AMT ADJ_AMT" ).append("\n"); 
		query.append("              FROM SAR_AGN_CLT_RFND_MST" ).append("\n"); 
		query.append("              WHERE ASA_NO = @[asa_no]" ).append("\n"); 
		query.append("              AND NVL(USD_AMT, 0) <> 0" ).append("\n"); 
		query.append("              UNION ALL" ).append("\n"); 
		query.append("              SELECT AR_OFC_CD, BL_NO, INV_NO, CHG_TP_CD, LOCL_CURR_CD BL_CURR_CD, LOCL_AMT ADJ_AMT" ).append("\n"); 
		query.append("              FROM SAR_AGN_CLT_RFND_MST" ).append("\n"); 
		query.append("              WHERE ASA_NO = @[asa_no]" ).append("\n"); 
		query.append("              AND NVL(LOCL_AMT, 0) <> 0" ).append("\n"); 
		query.append("              UNION ALL" ).append("\n"); 
		query.append("              SELECT AR_OFC_CD, BL_NO, INV_NO, CHG_TP_CD, N3RD_CURR_CD1 BL_CURR_CD, N3RD_AMT1 ADJ_AMT" ).append("\n"); 
		query.append("              FROM SAR_AGN_CLT_RFND_MST" ).append("\n"); 
		query.append("              WHERE ASA_NO = @[asa_no]" ).append("\n"); 
		query.append("              AND NVL(N3RD_AMT1, 0) <> 0" ).append("\n"); 
		query.append("              UNION ALL" ).append("\n"); 
		query.append("              SELECT AR_OFC_CD, BL_NO, INV_NO, CHG_TP_CD, N3RD_CURR_CD2 BL_CURR_CD, N3RD_AMT2 ADJ_AMT" ).append("\n"); 
		query.append("              FROM SAR_AGN_CLT_RFND_MST" ).append("\n"); 
		query.append("              WHERE ASA_NO = @[asa_no]" ).append("\n"); 
		query.append("              AND NVL(N3RD_AMT2, 0) <> 0" ).append("\n"); 
		query.append("              UNION ALL" ).append("\n"); 
		query.append("              SELECT AR_OFC_CD, BL_NO, INV_NO, CHG_TP_CD, N3RD_CURR_CD3 BL_CURR_CD, N3RD_AMT3 ADJ_AMT" ).append("\n"); 
		query.append("              FROM SAR_AGN_CLT_RFND_MST" ).append("\n"); 
		query.append("              WHERE ASA_NO = @[asa_no]" ).append("\n"); 
		query.append("              AND NVL(N3RD_AMT3, 0) <> 0" ).append("\n"); 
		query.append("              UNION ALL" ).append("\n"); 
		query.append("              SELECT AR_OFC_CD, BL_NO, INV_NO, CHG_TP_CD, N3RD_CURR_CD4 BL_CURR_CD, N3RD_AMT4 ADJ_AMT" ).append("\n"); 
		query.append("              FROM SAR_AGN_CLT_RFND_MST" ).append("\n"); 
		query.append("              WHERE ASA_NO = @[asa_no]" ).append("\n"); 
		query.append("              AND NVL(N3RD_AMT4, 0) <> 0" ).append("\n"); 
		query.append("             ) A" ).append("\n"); 
		query.append("        WHERE EXISTS (SELECT 'X'" ).append("\n"); 
		query.append("                      FROM SAR_OTS_DTL" ).append("\n"); 
		query.append("                      WHERE OTS_OFC_CD = A.AR_OFC_CD" ).append("\n"); 
		query.append("                      AND BL_NO = A.BL_NO" ).append("\n"); 
		query.append("                      AND INV_NO = A.INV_NO" ).append("\n"); 
		query.append("                      AND CHG_TP_CD = A.CHG_TP_CD" ).append("\n"); 
		query.append("                      AND BL_CURR_CD = A.BL_CURR_CD" ).append("\n"); 
		query.append("                      AND BAL_AMT = 0)" ).append("\n"); 
		query.append("     )" ).append("\n"); 

	}
}