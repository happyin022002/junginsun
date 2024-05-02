/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountReceivableCommonDBDAOsearchMDMinfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.05
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.05 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableCommonDBDAOsearchMDMinfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchMDMinfo
	  * </pre>
	  */
	public AccountReceivableCommonDBDAOsearchMDMinfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.integration").append("\n"); 
		query.append("FileName : AccountReceivableCommonDBDAOsearchMDMinfoRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("    SUP_YN," ).append("\n"); 
		query.append("    QEQ_FMT, " ).append("\n"); 
		query.append("    CUST_FLG," ).append("\n"); 
		query.append("    SUBSTR(MAX(SYS_CONNECT_BY_PATH(CUST_EML,';')),2) AS CUST_EML," ).append("\n"); 
		query.append("	REGEXP_REPLACE(MAX(FAX_NO), '[ ]|[-]','') AS FAX_NO," ).append("\n"); 
		query.append("    MAX(CUST_LGL_ENG_NM) AS CUST_NM  " ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT ROWNUM AS SEQ,SUP_YN,QEQ_FMT,CUST_FLG,CUST_EML,FAX_NO,CUST_LGL_ENG_NM FROM" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("         SELECT" ).append("\n"); 
		query.append("             DISTINCT" ).append("\n"); 
		query.append("               NVL(SPRS_PAY_LTR_FLG,'N') AS SUP_YN" ).append("\n"); 
		query.append("             , NVL(PAY_RQST_LTR_FMT_CD,'PDF') AS QEQ_FMT" ).append("\n"); 
		query.append("             , NVL2(MCC.CR_FLG,MCC.CR_FLG,'N') AS CUST_FLG" ).append("\n"); 
		query.append("             , MCP.CUST_EML" ).append("\n"); 
		query.append("			 , MCP. INTL_FAX_NO || MCP.FAX_NO AS FAX_NO" ).append("\n"); 
		query.append("             , MC.CUST_LGL_ENG_NM " ).append("\n"); 
		query.append("          FROM MDM_CUSTOMER MC" ).append("\n"); 
		query.append("             , MDM_CR_CUST MCC" ).append("\n"); 
		query.append("             , MDM_CUST_CNTC_PNT MCP" ).append("\n"); 
		query.append("         WHERE 1 = 1" ).append("\n"); 
		query.append("           AND MC.CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("           AND MC.CUST_SEQ = TO_NUMBER(@[cust_seq])" ).append("\n"); 
		query.append("           AND MC.DELT_FLG = 'N'" ).append("\n"); 
		query.append("           AND MC.CUST_CNT_CD = MCC.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("           AND MC.CUST_SEQ = MCC.CUST_SEQ(+)" ).append("\n"); 
		query.append("           AND MC.CUST_CNT_CD = MCP.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("           AND MC.CUST_SEQ = MCP.CUST_SEQ(+)" ).append("\n"); 
		query.append("           AND MC.DELT_FLG = MCC.DELT_FLG(+)" ).append("\n"); 
		query.append("		   AND MCP.PAY_RQST_LTR_FLG(+) = 'Y'" ).append("\n"); 
		query.append("     ) " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("START WITH SEQ = 1 CONNECT BY PRIOR SEQ = SEQ - 1" ).append("\n"); 
		query.append("GROUP BY SUP_YN,QEQ_FMT,CUST_FLG" ).append("\n"); 

	}
}