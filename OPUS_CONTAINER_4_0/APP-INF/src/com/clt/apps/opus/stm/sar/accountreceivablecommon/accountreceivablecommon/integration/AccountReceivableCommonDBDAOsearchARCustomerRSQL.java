/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AccountReceivableCommonDBDAOsearchARCustomerRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.19
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.19 
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

public class AccountReceivableCommonDBDAOsearchARCustomerRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AR Customer 정보 조회
	  * </pre>
	  */
	public AccountReceivableCommonDBDAOsearchARCustomerRSQL(){
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
		query.append("FileName : AccountReceivableCommonDBDAOsearchARCustomerRSQL").append("\n"); 
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
		query.append("     , B.CR_FLG" ).append("\n"); 
		query.append("     , B.CR_CURR_CD" ).append("\n"); 
		query.append("     , B.CR_AMT" ).append("\n"); 
		query.append("     , B.IB_CR_TERM_DYS" ).append("\n"); 
		query.append("	 , B.OB_CR_TERM_DYS" ).append("\n"); 
		query.append("	 , B.CR_CLT_OFC_CD" ).append("\n"); 
		query.append("	 , NVL(B.LOCL_NM, A.CUST_LGL_ENG_NM) CUST_NM" ).append("\n"); 
		query.append(" 	 , B.CNTC_PSON_NM" ).append("\n"); 
		query.append("	 , B.BZCT_NM" ).append("\n"); 
		query.append("	 , B.BZTP_NM" ).append("\n"); 
		query.append("     , A.CUST_RGST_NO" ).append("\n"); 
		query.append("     , TRIM(B.LOCL_ADDR1)||CASE WHEN B.LOCL_ADDR2 IS NOT NULL THEN ' '||TRIM(B.LOCL_ADDR2) ELSE '' END||CASE WHEN B.LOCL_ADDR3 IS NOT NULL THEN ' '||TRIM(B.LOCL_ADDR3) ELSE '' END||CASE WHEN B.LOCL_ADDR4 IS NOT NULL THEN ' '||TRIM(B.LOCL_ADDR4) ELSE '' END LOCL_ADDR" ).append("\n"); 
		query.append("     , B.ISS_DIV_CD" ).append("\n"); 
		query.append("     , A.INDIV_CORP_DIV_CD" ).append("\n"); 
		query.append("     , B.CUST_RLSE_CTRL_FLG" ).append("\n"); 
		query.append("	 , (" ).append("\n"); 
		query.append("        SELECT DECODE(SIGN(count(*)),1,'Y','N') FROM MDM_CUSTOMER MC WHERE MC.CNSD_CUST_CNT_CD = A.CUST_CNT_CD AND MC.CNSD_CUST_SEQ = A.CUST_SEQ" ).append("\n"); 
		query.append("     ) AS CNSD_CUST_FLG" ).append("\n"); 
		query.append("  FROM MDM_CUSTOMER A, MDM_CR_CUST B" ).append("\n"); 
		query.append(" WHERE A.CUST_CNT_CD = B.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("   AND A.CUST_SEQ = B.CUST_SEQ(+)" ).append("\n"); 
		query.append("   AND A.CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("   AND A.CUST_SEQ = TO_NUMBER(@[cust_seq])" ).append("\n"); 
		query.append("#if (${cust_use_flg} != 'N') " ).append("\n"); 
		query.append("   AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND B.DELT_FLG(+) = 'N'" ).append("\n"); 

	}
}