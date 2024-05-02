/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BDRCorrectionDBDAOSearchCltPayerCngRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.29
*@LastModifier : 
*@LastVersion : 1.0
* 2010.10.29 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcorrection.bdrcorrection.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BDRCorrectionDBDAOSearchCltPayerCngRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BDRCorrectionDBDAOSearchCltPayerCngRSQL
	  * 2010.10.29 신자영 [CHM-2010066461] C/A Exemption 하드코딩 Case추가
	  * </pre>
	  */
	public BDRCorrectionDBDAOSearchCltPayerCngRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcorrection.bdrcorrection.integration").append("\n"); 
		query.append("FileName : BDRCorrectionDBDAOSearchCltPayerCngRSQL").append("\n"); 
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
		query.append("SELECT NVL(DECODE(COUNT(*), 0, 'N', 'Y'), 'N') PAYER_CNG" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT CLT_OFC_CD" ).append("\n"); 
		query.append("FROM (SELECT CLT_OFC_CD" ).append("\n"); 
		query.append("FROM BKG_RATE" ).append("\n"); 
		query.append("WHERE BKG_NO  = @[bkg_no]" ).append("\n"); 
		query.append("MINUS" ).append("\n"); 
		query.append("SELECT CLT_OFC_CD" ).append("\n"); 
		query.append("FROM BKG_RT_HIS" ).append("\n"); 
		query.append("WHERE BKG_NO  = @[bkg_no]" ).append("\n"); 
		query.append("AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT *" ).append("\n"); 
		query.append("FROM (SELECT CLT_PAYR_CNT_CD||CLT_PAYR_CUST_SEQ CUST_CD" ).append("\n"); 
		query.append("FROM BKG_RATE" ).append("\n"); 
		query.append("WHERE BKG_NO  = @[bkg_no]" ).append("\n"); 
		query.append("MINUS" ).append("\n"); 
		query.append("SELECT CLT_PAYR_CNT_CD||CLT_PAYR_CUST_SEQ CUST_CD" ).append("\n"); 
		query.append("FROM BKG_RT_HIS" ).append("\n"); 
		query.append("WHERE BKG_NO  = @[bkg_no]" ).append("\n"); 
		query.append("AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}