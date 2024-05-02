/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BLIssuanceDBDAOsearchDblEdiIbShRefRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.22
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.22 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAOsearchDblEdiIbShRefRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select
	  * </pre>
	  */
	public BLIssuanceDBDAOsearchDblEdiIbShRefRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOsearchDblEdiIbShRefRSQL").append("\n"); 
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
		query.append("SELECT FF FROM (" ).append("\n"); 
		query.append("SELECT 'IB_SH_REF_NO:' || NVL(SHPR_REF_NO,ESSH.CUST_REF_NO_CTNT) || CHR (10) ||" ).append("\n"); 
		query.append("	   'IB_EXP_REF_NO:' || NVL(XPT_REF_NO,ESFF.CUST_REF_NO_CTNT) || CHR (10) ||" ).append("\n"); 
		query.append("       'IB_SC_NO:' || CASE WHEN NVL(SC_NO,'DUM') NOT LIKE 'DUM%' THEN SC_NO" ).append("\n"); 
		query.append("                           WHEN NVL(RFA_NO,'DUM') NOT LIKE 'DUM%' THEN RFA_NO" ).append("\n"); 
		query.append("                           WHEN NVL(TAA_NO, 'DUM') NOT LIKE 'DUM%' THEN TAA_NO" ).append("\n"); 
		query.append("                      ELSE CTRT_NO" ).append("\n"); 
		query.append("                     END  || CHR (10)  AS FF" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM  BKG_BOOKING BB, " ).append("\n"); 
		query.append("      (SELECT SHPR_REF_NO, XPT_REF_NO, CTRT_NO, BKG_NO" ).append("\n"); 
		query.append("              ,ROW_NUMBER() OVER(PARTITION BY BK.XTER_SNDR_ID,BK.XTER_RQST_NO ORDER BY BK.UPLD_DT DESC) RNUM " ).append("\n"); 
		query.append("       FROM BKG_XTER_RQST_MST BK" ).append("\n"); 
		query.append("       WHERE 1=1" ).append("\n"); 
		query.append("       AND BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("       AND BKG_UPLD_STS_CD ='F'" ).append("\n"); 
		query.append("         AND BK.UPLD_GDT = (SELECT MAX(BXRM.UPLD_GDT) " ).append("\n"); 
		query.append("                            FROM BKG_XTER_RQST_MST BXRM" ).append("\n"); 
		query.append("                            WHERE BXRM.BKG_NO =  @[bkg_no]" ).append("\n"); 
		query.append("                              AND BXRM.BKG_UPLD_STS_CD = 'F')  " ).append("\n"); 
		query.append("       ) BK                              " ).append("\n"); 
		query.append("       , BKG_REFERENCE ESSH, BKG_REFERENCE ESFF" ).append("\n"); 
		query.append("WHERE BB.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("  AND BB.BKG_NO = BK.BKG_NO(+)" ).append("\n"); 
		query.append("  AND BB.BKG_NO = ESSH.BKG_NO(+)" ).append("\n"); 
		query.append("  AND ESSH.BKG_REF_TP_CD(+) = 'ESSH'" ).append("\n"); 
		query.append("  AND BB.BKG_NO = ESFF.BKG_NO(+)" ).append("\n"); 
		query.append("  AND ESFF.BKG_REF_TP_CD(+) = 'ESFF'" ).append("\n"); 
		query.append("  ) FF" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND ROWNUM =1" ).append("\n"); 

	}
}