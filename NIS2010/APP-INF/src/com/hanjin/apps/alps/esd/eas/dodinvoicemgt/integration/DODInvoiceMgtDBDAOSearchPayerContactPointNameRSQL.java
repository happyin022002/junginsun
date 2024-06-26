/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : DODInvoiceMgtDBDAOSearchPayerContactPointNameRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.16
*@LastModifier : KIM HYUN HWA
*@LastVersion : 1.0
* 2013.09.16 KIM HYUN HWA
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.dodinvoicemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author ISD1
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DODInvoiceMgtDBDAOSearchPayerContactPointNameRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Payer의 ContactPointName들을 조회함. list box 용
	  * </pre>
	  */
	public DODInvoiceMgtDBDAOSearchPayerContactPointNameRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.dodinvoicemgt.integration").append("\n"); 
		query.append("FileName : DODInvoiceMgtDBDAOSearchPayerContactPointNameRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT 'EAS' AS JOB_TP" ).append("\n"); 
		query.append("    ,'' AS GUBUN" ).append("\n"); 
		query.append("    ,CNTC_PNT_NM 	AS CNTC_PNT_NM " ).append("\n"); 
		query.append("FROM EAS_PAYR_CNTC_PNT" ).append("\n"); 
		query.append("WHERE CUST_CNT_CD 	= SUBSTR(@[s_cust_cd], 1, 2)" ).append("\n"); 
		query.append("AND   CUST_SEQ 			= SUBSTR(@[s_cust_cd], 3)" ).append("\n"); 
		query.append("AND CNTC_PNT_NM IS NOT NULL" ).append("\n"); 
		query.append("#if (${s_cust_gubun} == '1')" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT DISTINCT 'MDM'" ).append("\n"); 
		query.append("    ,'CREDIT'" ).append("\n"); 
		query.append("    ,A.CNTC_PSON_NM" ).append("\n"); 
		query.append("FROM MDM_VENDOR A, MDM_VNDR_CNTC_PNT B" ).append("\n"); 
		query.append("WHERE A.VNDR_SEQ 		= B.VNDR_SEQ" ).append("\n"); 
		query.append("AND A.VNDR_SEQ 			= @[s_cust_cd]" ).append("\n"); 
		query.append("AND A.CNTC_PSON_NM IS NOT NULL" ).append("\n"); 
		query.append("#elseif (${s_cust_gubun} == '2') " ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT DISTINCT 'MDM'" ).append("\n"); 
		query.append("    ,'CREDIT'" ).append("\n"); 
		query.append("    ,B.CNTC_PSON_NM" ).append("\n"); 
		query.append("FROM MDM_CUSTOMER A, MDM_CR_CUST B" ).append("\n"); 
		query.append("WHERE A.CUST_CNT_CD 	= B.CUST_CNT_CD" ).append("\n"); 
		query.append("AND A.CUST_SEQ 			= B.CUST_SEQ" ).append("\n"); 
		query.append("AND A.CUST_CNT_CD 		= SUBSTR(@[s_cust_cd], 1, 2)" ).append("\n"); 
		query.append("AND A.CUST_SEQ 			= SUBSTR(@[s_cust_cd], 3)" ).append("\n"); 
		query.append("AND B.CNTC_PSON_NM IS NOT NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}