/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BLIssuanceDBDAOsearchDblEdiCustIbcsRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.23
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.23 
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

public class BLIssuanceDBDAOsearchDblEdiCustIbcsRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select
	  * </pre>
	  */
	public BLIssuanceDBDAOsearchDblEdiCustIbcsRSQL(){
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
		query.append("FileName : BLIssuanceDBDAOsearchDblEdiCustIbcsRSQL").append("\n"); 
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
		query.append("SELECT FF" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT 'SH_IBCS_C_NM1:'        || BKG_TOKEN_NL_FNC(NVL(SH.CNTC_NM,''), 1, '')    || CHR(10)||" ).append("\n"); 
		query.append("       'SH_IBCS_C_NM2:'        || BKG_TOKEN_NL_FNC(NVL(SH.CNTC_NM,''), 2, '')    || CHR(10)||" ).append("\n"); 
		query.append("       'NF_IBCS_C_NM1:'        || BKG_TOKEN_NL_FNC(NVL(NF.CNTC_NM,''), 1, '')    || CHR(10)||" ).append("\n"); 
		query.append("       'NF_IBCS_C_NM2:'        || BKG_TOKEN_NL_FNC(NVL(NF.CNTC_NM,''), 2, '')    || CHR(10)||" ).append("\n"); 
		query.append("       'CN_IBCS_C_NM1:'        || BKG_TOKEN_NL_FNC(NVL(CN.CNTC_NM,''), 1, '')    || CHR(10)||" ).append("\n"); 
		query.append("       'CN_IBCS_C_NM2:'        || BKG_TOKEN_NL_FNC(NVL(CN.CNTC_NM,''), 2, '')  || CHR(10)||" ).append("\n"); 
		query.append("       'FW_IBCS_C_NM1:'        || BKG_TOKEN_NL_FNC(NVL(FW.CNTC_NM,''), 1, '')  || CHR(10)||" ).append("\n"); 
		query.append("       'FW_IBCS_C_NM2:'        || BKG_TOKEN_NL_FNC(NVL(FW.CNTC_NM,''), 2, '')  || CHR(10)||" ).append("\n"); 
		query.append("       'AN_IBCS_C_NM1:'        || BKG_TOKEN_NL_FNC(NVL(AN.CNTC_NM,''), 1, '')    || CHR(10)||" ).append("\n"); 
		query.append("       'AN_IBCS_C_NM2:'        || BKG_TOKEN_NL_FNC(NVL(AN.CNTC_NM,''), 2, '')  || CHR(10) AS FF" ).append("\n"); 
		query.append("        ,ROW_NUMBER() OVER(PARTITION BY BK.XTER_SNDR_ID,BK.XTER_RQST_NO ORDER BY BK.UPLD_DT DESC) RNUM " ).append("\n"); 
		query.append("        ,BK.*" ).append("\n"); 
		query.append("  FROM BKG_XTER_RQST_MST BK" ).append("\n"); 
		query.append("      ,BKG_XTER_CUST SH" ).append("\n"); 
		query.append("      ,BKG_XTER_CUST NF" ).append("\n"); 
		query.append("      ,BKG_XTER_CUST CN" ).append("\n"); 
		query.append("      ,BKG_XTER_CUST FW" ).append("\n"); 
		query.append("      ,BKG_XTER_CUST AN" ).append("\n"); 
		query.append("WHERE BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND BKG_UPLD_STS_CD ='F'" ).append("\n"); 
		query.append("   AND BK.XTER_RQST_NO = SH.XTER_RQST_NO(+)" ).append("\n"); 
		query.append("   AND BK.XTER_RQST_SEQ = SH.XTER_RQST_SEQ(+)" ).append("\n"); 
		query.append("   AND BK.XTER_SNDR_ID = SH.XTER_SNDR_ID(+)" ).append("\n"); 
		query.append("   AND SH.XTER_CUST_TP_CD(+) = 'S'" ).append("\n"); 
		query.append("   AND BK.XTER_RQST_NO = NF.XTER_RQST_NO(+)" ).append("\n"); 
		query.append("   AND BK.XTER_RQST_SEQ = NF.XTER_RQST_SEQ(+)" ).append("\n"); 
		query.append("   AND BK.XTER_SNDR_ID = NF.XTER_SNDR_ID(+)" ).append("\n"); 
		query.append("   AND NF.XTER_CUST_TP_CD(+) = 'N'" ).append("\n"); 
		query.append("   AND BK.XTER_RQST_NO = CN.XTER_RQST_NO(+)" ).append("\n"); 
		query.append("   AND BK.XTER_RQST_SEQ = CN.XTER_RQST_SEQ(+)" ).append("\n"); 
		query.append("   AND BK.XTER_SNDR_ID = CN.XTER_SNDR_ID(+)" ).append("\n"); 
		query.append("   AND CN.XTER_CUST_TP_CD(+) = 'C'" ).append("\n"); 
		query.append("   AND BK.XTER_RQST_NO = FW.XTER_RQST_NO(+)" ).append("\n"); 
		query.append("   AND BK.XTER_RQST_SEQ = FW.XTER_RQST_SEQ(+)" ).append("\n"); 
		query.append("   AND BK.XTER_SNDR_ID = FW.XTER_SNDR_ID(+)" ).append("\n"); 
		query.append("   AND FW.XTER_CUST_TP_CD(+) = 'F'" ).append("\n"); 
		query.append("   AND BK.XTER_RQST_NO = AN.XTER_RQST_NO(+)" ).append("\n"); 
		query.append("   AND BK.XTER_RQST_SEQ = AN.XTER_RQST_SEQ(+)" ).append("\n"); 
		query.append("   AND BK.XTER_SNDR_ID = AN.XTER_SNDR_ID(+)" ).append("\n"); 
		query.append("   AND AN.XTER_CUST_TP_CD(+) = 'A'" ).append("\n"); 
		query.append("   AND BK.UPLD_GDT = (SELECT MAX(BXRM.UPLD_GDT) " ).append("\n"); 
		query.append("                       FROM BKG_XTER_RQST_MST BXRM" ).append("\n"); 
		query.append("                       WHERE BXRM.BKG_NO =  @[bkg_no]" ).append("\n"); 
		query.append("                         AND BXRM.BKG_UPLD_STS_CD = 'F') " ).append("\n"); 
		query.append("   ) FF" ).append("\n"); 
		query.append("WHERE RNUM =1" ).append("\n"); 
		query.append("AND ROWNUM =1" ).append("\n"); 

	}
}