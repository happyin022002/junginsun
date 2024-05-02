/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : UsaManifestListDownloadDBDAOsearchBkgCustomerByBlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.01
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2015.06.01 김민정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Minjung Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaManifestListDownloadDBDAOsearchBkgCustomerByBlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UsaBkgCustomerVO
	  * </pre>
	  */
	public UsaManifestListDownloadDBDAOsearchBkgCustomerByBlRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration").append("\n"); 
		query.append("FileName : UsaManifestListDownloadDBDAOsearchBkgCustomerByBlRSQL").append("\n"); 
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
		query.append("SELECT 'US' CNT_CD" ).append("\n"); 
		query.append("	  ,B.BL_NO" ).append("\n"); 
		query.append("      ,C.BKG_CUST_TP_CD" ).append("\n"); 
		query.append("      ,C.CUST_SEQ" ).append("\n"); 
		query.append("      ,C.CUST_CNT_CD" ).append("\n"); 
		query.append("      ,REPLACE(NVL(UPPER(C.CUST_NM),' '),CHR(180),CHR(39)) AS CUST_NM" ).append("\n"); 
		query.append("      ,REPLACE(NVL(UPPER(C.CUST_ADDR),' '),CHR(180),CHR(39)) AS CUST_ADDR" ).append("\n"); 
		query.append("      ,C.CUST_CTY_NM" ).append("\n"); 
		query.append("      ,C.CUST_STE_CD" ).append("\n"); 
		query.append("      ,C.CSTMS_DECL_CNT_CD" ).append("\n"); 
		query.append("      ,C.CUST_ZIP_ID" ).append("\n"); 
		query.append("      ,C.EUR_CSTMS_ST_NM" ).append("\n"); 
		query.append("	  ,@[usr_id] CRE_USR_ID" ).append("\n"); 
		query.append("	  ,@[usr_id] UPD_USR_ID" ).append("\n"); 
		query.append("FROM  BKG_BOOKING B, BKG_CUSTOMER C" ).append("\n"); 
		query.append("WHERE 1=1 " ).append("\n"); 
		query.append("AND ( #foreach($field_id in ${field_list}) " ).append("\n"); 
		query.append("      	#if($velocityCount > 1)" ).append("\n"); 
		query.append("      	OR #end      B.BKG_NO IN ( $field_id )" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND   B.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("--and   C.BKG_CUST_TP_CD IN ('S','C','N')" ).append("\n"); 

	}
}