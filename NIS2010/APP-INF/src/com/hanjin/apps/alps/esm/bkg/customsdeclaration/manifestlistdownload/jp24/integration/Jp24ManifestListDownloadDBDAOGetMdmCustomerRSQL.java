/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : Jp24ManifestListDownloadDBDAOGetMdmCustomerRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.26
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2013.08.26 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM, Sang-Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Jp24ManifestListDownloadDBDAOGetMdmCustomerRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public Jp24ManifestListDownloadDBDAOGetMdmCustomerRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.integration").append("\n"); 
		query.append("FileName : Jp24ManifestListDownloadDBDAOGetMdmCustomerRSQL").append("\n"); 
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
		query.append("SELECT CUST.FINC_STS_LVL_CD," ).append("\n"); 
		query.append("       CUST.DELT_FLG," ).append("\n"); 
		query.append("       UPPER(CUST.CUST_LGL_ENG_NM) AS CUST_LGL_ENG_NM," ).append("\n"); 
		query.append("       (SELECT UPPER(BZET_ADDR)" ).append("\n"); 
		query.append("          FROM MDM_CUST_ADDR" ).append("\n"); 
		query.append("         WHERE CUST_CNT_CD = CUST.CUST_CNT_CD" ).append("\n"); 
		query.append("           AND CUST_SEQ = CUST.CUST_SEQ" ).append("\n"); 
		query.append("           AND PRMRY_CHK_FLG = 'Y'" ).append("\n"); 
		query.append("           AND ROWNUM = 1) AS BZET_ADDR" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM MDM_CUSTOMER CUST" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE CUST.CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("   AND CUST.CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("   AND CUST.CNTR_DIV_FLG = 'Y'" ).append("\n"); 

	}
}