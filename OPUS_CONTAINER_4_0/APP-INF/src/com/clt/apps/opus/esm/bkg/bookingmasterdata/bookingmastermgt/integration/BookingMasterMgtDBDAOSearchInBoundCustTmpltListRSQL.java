/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BookingMasterMgtDBDAOSearchInBoundCustTmpltListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.21
*@LastModifier : 
*@LastVersion : 1.0
* 2010.06.21 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingMasterMgtDBDAOSearchInBoundCustTmpltListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *  0192 B/L Customer Information Template 조회			
	  * </pre>
	  */
	public BookingMasterMgtDBDAOSearchInBoundCustTmpltListRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.integration").append("\n"); 
		query.append("FileName : BookingMasterMgtDBDAOSearchInBoundCustTmpltListRSQL").append("\n"); 
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
		query.append("SELECT     UPPER(CUST_CNT_CD) AS CUST_CNT_CD" ).append("\n"); 
		query.append(",  UPPER(CUST_SEQ) AS CUST_SEQ" ).append("\n"); 
		query.append(",  UPPER(TMPLT_SEQ) AS TMPLT_SEQ" ).append("\n"); 
		query.append(",  UPPER(CUST_NM) AS CUST_NM" ).append("\n"); 
		query.append(",  UPPER(CUST_ADDR) AS CUST_ADDR" ).append("\n"); 
		query.append(",  UPPER(CUST_PHN_NO) AS CUST_PHN_NO" ).append("\n"); 
		query.append(",  UPPER(ATND_NM) AS PIC" ).append("\n"); 
		query.append(",  UPPER(CRE_USR_ID) AS CRE_USR_ID" ).append("\n"); 
		query.append(",  UPPER(CUST_FAX_NO) AS CUST_FAX_NO" ).append("\n"); 
		query.append(",  UPPER(CUST_CTY_NM) AS CUST_CTY_NM" ).append("\n"); 
		query.append(",  UPPER(CUST_STE_CD) AS CUST_STE_CD" ).append("\n"); 
		query.append(",  UPPER(CUST_ZIP_CD) AS CUST_ZIP_CD" ).append("\n"); 
		query.append(",  UPPER(CUST_EML) AS CUST_EML" ).append("\n"); 
		query.append(",  UPPER(TMPLT_RMK) AS TMPLT_RMK" ).append("\n"); 
		query.append(",  UPPER(CRE_USR_ID) AS CRE_USR_ID" ).append("\n"); 
		query.append(",  UPPER(UPD_USR_ID) AS UPD_USR_ID" ).append("\n"); 
		query.append(",  CSTMS_DECL_CNT_CD AS CSTMS_DECL_CNT_CD" ).append("\n"); 
		query.append(", UPPER(EUR_CSTMS_ST_NM) AS EUR_CSTMS_ST_NM" ).append("\n"); 
		query.append(", UPPER(EORI_NO) AS EORI_NO" ).append("\n"); 
		query.append("FROM   BKG_CUST_TMPLT" ).append("\n"); 
		query.append("WHERE CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("AND   CUST_SEQ    = @[cust_seq]" ).append("\n"); 

	}
}