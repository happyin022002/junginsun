/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : INVCommonDAOSearchARCustomerListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.03
*@LastModifier : 
*@LastVersion : 1.0
* 2013.04.03 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.invcommon.invcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class INVCommonDAOSearchARCustomerListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchARCustomerList
	  * </pre>
	  */
	public INVCommonDAOSearchARCustomerListRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_rgst_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.invcommon.invcommon.integration").append("\n"); 
		query.append("FileName : INVCommonDAOSearchARCustomerListRSQL").append("\n"); 
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
		query.append("SELECT A.CUST_CNT_CD" ).append("\n"); 
		query.append("     , A.CUST_SEQ" ).append("\n"); 
		query.append("     , B.CR_CURR_CD CR_CURR_CD" ).append("\n"); 
		query.append("     , B.CR_AMT CR_AMT" ).append("\n"); 
		query.append("     , B.IB_CR_TERM_DYS IB_CR_TERM_DYS" ).append("\n"); 
		query.append("	 , B.OB_CR_TERM_DYS OB_CR_TERM_DYS" ).append("\n"); 
		query.append("	 , B.CR_CLT_OFC_CD CR_CLT_OFC_CD" ).append("\n"); 
		query.append("	 , B.LOCL_NM CUST_NM" ).append("\n"); 
		query.append("     , A.CUST_LGL_ENG_NM CUST_ENG_NM" ).append("\n"); 
		query.append("     --, B.OB_PHN_NO OB_PHN_NO" ).append("\n"); 
		query.append("     --, B.IB_PHN_NO IB_PHN_NO" ).append("\n"); 
		query.append("     --, B.OB_FAX_NO OB_FAX_NO" ).append("\n"); 
		query.append("     --, B.IB_FAX_NO IB_FAX_NO" ).append("\n"); 
		query.append("     , D.PHN_NO OB_PHN_NO" ).append("\n"); 
		query.append("     , D.PHN_NO IB_PHN_NO" ).append("\n"); 
		query.append("     , D.FAX_NO OB_FAX_NO" ).append("\n"); 
		query.append("     , D.FAX_NO IB_FAX_NO" ).append("\n"); 
		query.append(" 	 , B.CNTC_PSON_NM CNTC_PSON_NM" ).append("\n"); 
		query.append("	 , B.BZCT_NM BZCT_NM" ).append("\n"); 
		query.append("	 , B.BZTP_NM BZTP_NM" ).append("\n"); 
		query.append("     , A.CUST_RGST_NO CUST_RGST_NO" ).append("\n"); 
		query.append("     , A.DELT_FLG DELT_FLG" ).append("\n"); 
		query.append("#if (${cust_cnt_cd} != '' && ${cust_seq} != '')      " ).append("\n"); 
		query.append("     , CASE WHEN TRIM(B.LOCL_ADDR1) IS NOT NULL THEN" ).append("\n"); 
		query.append("            TRIM(B.LOCL_ADDR1)||CASE WHEN B.LOCL_ADDR2 IS NOT NULL THEN ' '||TRIM(B.LOCL_ADDR2) ELSE '' END||CASE WHEN B.LOCL_ADDR3 IS NOT NULL THEN ' '||TRIM(B.LOCL_ADDR3) ELSE '' END||CASE WHEN B.LOCL_ADDR4 IS NOT NULL THEN ' '||TRIM(B.LOCL_ADDR4) ELSE '' END " ).append("\n"); 
		query.append("       ELSE" ).append("\n"); 
		query.append("            (SELECT BZET_ADDR||' '||CTY_NM||' '||STE_CD  " ).append("\n"); 
		query.append("             FROM MDM_CUST_ADDR " ).append("\n"); 
		query.append("             WHERE CUST_CNT_CD = NVL(@[cust_cnt_cd], '') " ).append("\n"); 
		query.append("             AND   CUST_SEQ = CASE WHEN REGEXP_INSTR(@[cust_seq], '[[:alpha:]]', 1, 1) = 0 THEN" ).append("\n"); 
		query.append("                                   TO_NUMBER(@[cust_seq])" ).append("\n"); 
		query.append("                              ELSE" ).append("\n"); 
		query.append("                                   -999999" ).append("\n"); 
		query.append("                              END " ).append("\n"); 
		query.append("             AND PRMRY_CHK_FLG = 'Y' " ).append("\n"); 
		query.append("             AND ROWNUM =1)" ).append("\n"); 
		query.append("       END LOCL_ADDR" ).append("\n"); 
		query.append("#elseif (${cust_rgst_no} != '')" ).append("\n"); 
		query.append("     , TRIM(B.LOCL_ADDR1)||CASE WHEN B.LOCL_ADDR2 IS NOT NULL THEN ' '||TRIM(B.LOCL_ADDR2) ELSE '' END||CASE WHEN B.LOCL_ADDR3 IS NOT NULL THEN ' '||TRIM(B.LOCL_ADDR3) ELSE '' END||CASE WHEN B.LOCL_ADDR4 IS NOT NULL THEN ' '||TRIM(B.LOCL_ADDR4) ELSE '' END LOCL_ADDR" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("     , B.ISS_DIV_CD" ).append("\n"); 
		query.append("     , A.INDIV_CORP_DIV_CD" ).append("\n"); 
		query.append("	 , B.CR_ST_DT" ).append("\n"); 
		query.append("     , B.CR_END_DT" ).append("\n"); 
		query.append("	 , B.CR_FLG" ).append("\n"); 
		query.append("  FROM MDM_CUSTOMER A, MDM_CR_CUST B, MDM_CUST_CNTC_PNT D" ).append("\n"); 
		query.append(" WHERE A.CUST_CNT_CD = B.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("   AND A.CUST_SEQ = B.CUST_SEQ(+)" ).append("\n"); 
		query.append("   AND A.CUST_CNT_CD = D.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("   AND A.CUST_SEQ = D.CUST_SEQ(+)" ).append("\n"); 
		query.append("   --AND NVL(A.BLK_DIV_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("   AND NVL(A.CNTR_DIV_FLG,'N') ='Y' --2010-06-04 김현화수석" ).append("\n"); 
		query.append(" --  AND A.CNTR_DIV_FLG = 'Y' " ).append("\n"); 
		query.append("   AND NVL(A.NMD_CUST_FLG,'N') ='N'--2010.04.27" ).append("\n"); 
		query.append("#if (${cust_cnt_cd} != '' && ${cust_seq} != '') " ).append("\n"); 
		query.append("   AND A.CUST_CNT_CD = NVL(@[cust_cnt_cd], '')" ).append("\n"); 
		query.append("   AND A.CUST_SEQ = CASE WHEN REGEXP_INSTR(@[cust_seq], '[[:alpha:]]', 1, 1) = 0 THEN" ).append("\n"); 
		query.append("                             TO_NUMBER(@[cust_seq])" ).append("\n"); 
		query.append("                          ELSE" ).append("\n"); 
		query.append("                             -999999" ).append("\n"); 
		query.append("                          END" ).append("\n"); 
		query.append("#elseif (${cust_rgst_no} != '')" ).append("\n"); 
		query.append("   AND A.CUST_RGST_NO = @[cust_rgst_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND ROWNUM = 1" ).append("\n"); 

	}
}