/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : DODInvoiceMgtDBDAODODPayrInfoVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.08
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.08 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.dodinvoicemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DODInvoiceMgtDBDAODODPayrInfoVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DODPayrInfoVO
	  * </pre>
	  */
	public DODInvoiceMgtDBDAODODPayrInfoVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("payer_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_rgst_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.dodinvoicemgt.integration").append("\n"); 
		query.append("FileName : DODInvoiceMgtDBDAODODPayrInfoVORSQL").append("\n"); 
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
		query.append("SELECT A.CUST_CNT_CD||LPAD(A.CUST_SEQ, 6, 0) CUST_CD, " ).append("\n"); 
		query.append("       A.CUST_LGL_ENG_NM CUST_NM," ).append("\n"); 
		query.append("       A.CUST_RGST_NO CUST_RGST_NO" ).append("\n"); 
		query.append("  FROM MDM_CUSTOMER A" ).append("\n"); 
		query.append(" WHERE A.DELT_FLG <> 'Y'" ).append("\n"); 
		query.append("   AND NVL(NMD_CUST_FLG, 'N') = 'N' " ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("#if (${payer_cd} != '')" ).append("\n"); 
		query.append("   AND A.CUST_CNT_CD = SUBSTR(@[payer_cd], 1, 2)" ).append("\n"); 
		query.append("   AND A.CUST_SEQ = TO_NUMBER(SUBSTR(@[payer_cd], 3))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cust_rgst_no} != '' && ${payer_cd} == '')" ).append("\n"); 
		query.append("   AND A.CUST_RGST_NO = REPLACE(@[cust_rgst_no],'-','')" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}