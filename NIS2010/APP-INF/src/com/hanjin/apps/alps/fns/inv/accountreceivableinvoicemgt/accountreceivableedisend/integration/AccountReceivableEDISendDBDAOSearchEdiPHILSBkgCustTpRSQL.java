/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountReceivableEDISendDBDAOSearchEdiPHILSBkgCustTpRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.09
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.09 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableEDISendDBDAOSearchEdiPHILSBkgCustTpRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchEdiPHILSBkgCustTp
	  * </pre>
	  */
	public AccountReceivableEDISendDBDAOSearchEdiPHILSBkgCustTpRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration").append("\n"); 
		query.append("FileName : AccountReceivableEDISendDBDAOSearchEdiPHILSBkgCustTpRSQL").append("\n"); 
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
		query.append("SELECT DECODE(BC.BKG_CUST_TP_CD, 'S', 'SF', 'ST') P_CUST_TP," ).append("\n"); 
		query.append("       REPLACE(BC.CUST_NM,chr(13)||chr(10),' ') CUST_NM, " ).append("\n"); 
		query.append("       REPLACE(BC.CUST_ADDR,chr(13)||chr(10),' ') CUST_ADDR, " ).append("\n"); 
		query.append("       REPLACE(BC.CUST_CTY_NM,chr(13)||chr(10),' ') CUST_CTY_NM, " ).append("\n"); 
		query.append("       ML.UN_LOC_CD, " ).append("\n"); 
		query.append("       MC.LOC_CD" ).append("\n"); 
		query.append("FROM   BKG_BOOKING BK," ).append("\n"); 
		query.append("       BKG_CUSTOMER BC," ).append("\n"); 
		query.append("       MDM_CUSTOMER MC," ).append("\n"); 
		query.append("       MDM_LOCATION ML" ).append("\n"); 
		query.append("WHERE  BK.BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("AND    BC.CUST_CNT_CD = MC.CUST_CNT_CD" ).append("\n"); 
		query.append("AND    BC.CUST_SEQ = MC.CUST_SEQ" ).append("\n"); 
		query.append("AND    MC.LOC_CD  =  ML.LOC_CD" ).append("\n"); 
		query.append("AND    BK.BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("AND    BC.BKG_CUST_TP_CD IN ('S','C','N')" ).append("\n"); 
		query.append("AND   ((CUST_TO_ORD_FLG = 'N' AND BKG_CUST_TP_CD IN ('S','C')) OR (CUST_TO_ORD_FLG = 'Y' AND BKG_CUST_TP_CD IN ('S','N')))" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'BY' P_CUST_TP," ).append("\n"); 
		query.append("       REPLACE(MC.CUST_LGL_ENG_NM,chr(13)||chr(10),' ') CUST_NM, " ).append("\n"); 
		query.append("       REPLACE(UPPER(SUBSTR(CA.BZET_ADDR||' '||CA.CTY_NM||' '||CA.STE_CD,1,400)),chr(13)||chr(10),' ') CUST_ADDR, " ).append("\n"); 
		query.append("       REPLACE(UPPER(CA.CTY_NM),chr(13)||chr(10),' ') CUST_CTY_NM, " ).append("\n"); 
		query.append("       ML.UN_LOC_CD, " ).append("\n"); 
		query.append("       EPL.PHILS_LOC_CD_CTNT  LOC_CD" ).append("\n"); 
		query.append("FROM   INV_EDI_PHILS_LOC EPL," ).append("\n"); 
		query.append("       MDM_CUSTOMER MC," ).append("\n"); 
		query.append("       MDM_LOCATION ML," ).append("\n"); 
		query.append("       MDM_CUST_ADDR CA" ).append("\n"); 
		query.append("WHERE  EPL.CUST_CNT_CD = MC.CUST_CNT_CD" ).append("\n"); 
		query.append("AND    EPL.CUST_SEQ = MC.CUST_SEQ" ).append("\n"); 
		query.append("AND    EPL.CUST_CNT_CD = CA.CUST_CNT_CD" ).append("\n"); 
		query.append("AND    EPL.CUST_SEQ = CA.CUST_SEQ" ).append("\n"); 
		query.append("AND    MC.LOC_CD  =  ML.LOC_CD" ).append("\n"); 
		query.append("AND    CA.PRMRY_CHK_FLG = 'Y'" ).append("\n"); 
		query.append("AND    EPL.CUST_CNT_CD = NVL(@[inv_cust_cnt_cd], '')" ).append("\n"); 
		query.append("AND    EPL.CUST_SEQ = CASE WHEN REGEXP_INSTR(@[inv_cust_seq], '[[:alpha:]]', 1, 1) = 0 THEN" ).append("\n"); 
		query.append("                                TO_NUMBER(@[inv_cust_seq])" ).append("\n"); 
		query.append("                           ELSE" ).append("\n"); 
		query.append("                                -999999" ).append("\n"); 
		query.append("                           END " ).append("\n"); 
		query.append("AND    ROWNUM = 1" ).append("\n"); 

	}
}