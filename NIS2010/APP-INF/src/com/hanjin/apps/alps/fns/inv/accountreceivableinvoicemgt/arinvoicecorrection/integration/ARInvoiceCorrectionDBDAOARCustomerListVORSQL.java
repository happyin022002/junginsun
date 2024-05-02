/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ARInvoiceCorrectionDBDAOARCustomerListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.28
*@LastModifier : 
*@LastVersion : 1.0
* 2014.07.28 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceCorrectionDBDAOARCustomerListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public ARInvoiceCorrectionDBDAOARCustomerListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fwdr_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fwdr_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("shpr_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("shpr_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.integration").append("\n"); 
		query.append("FileName : ARInvoiceCorrectionDBDAOARCustomerListVORSQL").append("\n"); 
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
		query.append("SELECT CUST_CD," ).append("\n"); 
		query.append("       CUST_LGL_ENG_NM," ).append("\n"); 
		query.append("       ADDR," ).append("\n"); 
		query.append("       ZIP_CD," ).append("\n"); 
		query.append("       CR_CLT_OFC_CD" ).append("\n"); 
		query.append("FROM  (" ).append("\n"); 
		query.append("		SELECT A.CUST_CNT_CD||LPAD(A.CUST_SEQ,6,0) CUST_CD," ).append("\n"); 
		query.append("       		   A.CUST_LGL_ENG_NM," ).append("\n"); 
		query.append("       		   C.BZET_ADDR ADDR," ).append("\n"); 
		query.append("       		   C.ZIP_CD," ).append("\n"); 
		query.append("       		   B.CR_CLT_OFC_CD," ).append("\n"); 
		query.append("       		   2 AS SEQ" ).append("\n"); 
		query.append("  		  FROM MDM_CUSTOMER A," ).append("\n"); 
		query.append("       		   MDM_CR_CUST  B," ).append("\n"); 
		query.append("       		   MDM_CUST_ADDR C" ).append("\n"); 
		query.append("		 WHERE A.CUST_CNT_CD = B.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("		   AND A.CUST_SEQ    = B.CUST_SEQ(+)" ).append("\n"); 
		query.append("		   AND A.CUST_CNT_CD = C.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("		   AND A.CUST_SEQ    = C.CUST_SEQ(+)" ).append("\n"); 
		query.append("		   AND C.PRMRY_CHK_FLG(+) = 'Y'" ).append("\n"); 
		query.append("		   AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("		   AND A.CUST_LGL_ENG_NM LIKE @[cust_nm]||'%'" ).append("\n"); 
		query.append("		   AND A.CUST_CNT_CD = (SELECT SUBSTR(LOC_CD,1,2) " ).append("\n"); 
		query.append("		                          FROM MDM_ORGANIZATION " ).append("\n"); 
		query.append("		                         WHERE OFC_CD = @[ofc_cd])" ).append("\n"); 
		query.append("        UNION" ).append("\n"); 
		query.append("        SELECT MC.CUST_CNT_CD||LPAD(MC.CUST_SEQ,6,0) CUST_CD," ).append("\n"); 
		query.append("               MC.CUST_LGL_ENG_NM AS CUST_LGL_ENG_NM," ).append("\n"); 
		query.append("               CA.BZET_ADDR AS ADDR," ).append("\n"); 
		query.append("               CA.ZIP_CD AS ZIP_CD," ).append("\n"); 
		query.append("               CR.CR_CLT_OFC_CD AS CR_CLT_OFC_CD," ).append("\n"); 
		query.append("               1 AS SEQ" ).append("\n"); 
		query.append("         FROM  MDM_CUSTOMER MC," ).append("\n"); 
		query.append("               MDM_CR_CUST  CR," ).append("\n"); 
		query.append("               MDM_CUST_ADDR CA" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND MC.CUST_CNT_CD = CR.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("           AND MC.CUST_SEQ = CR.CUST_SEQ(+)" ).append("\n"); 
		query.append("           AND MC.CUST_CNT_CD = CA.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("           AND MC.CUST_SEQ = CA.CUST_SEQ(+)" ).append("\n"); 
		query.append("           AND (MC.CUST_CNT_CD = NVL(@[shpr_cust_cnt_cd],' ') AND MC.CUST_SEQ = to_number(NVL(@[shpr_cust_seq],0)) " ).append("\n"); 
		query.append("                OR" ).append("\n"); 
		query.append("                MC.CUST_CNT_CD = NVL(@[fwdr_cust_cnt_cd],' ') AND MC.CUST_SEQ = to_number(NVL(@[fwdr_cust_seq],0)))" ).append("\n"); 
		query.append("           AND  SUBSTR(MC.LOC_CD,1,2)  = (SELECT SUBSTR(LOC_CD,1,2) " ).append("\n"); 
		query.append("                                           FROM MDM_ORGANIZATION " ).append("\n"); 
		query.append("                                          WHERE OFC_CD = @[ofc_cd]) " ).append("\n"); 
		query.append("     )  " ).append("\n"); 
		query.append("ORDER BY SEQ, CUST_LGL_ENG_NM" ).append("\n"); 

	}
}