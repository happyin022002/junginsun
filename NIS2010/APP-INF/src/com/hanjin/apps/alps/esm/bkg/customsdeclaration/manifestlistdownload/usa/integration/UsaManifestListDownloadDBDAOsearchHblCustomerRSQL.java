/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : UsaManifestListDownloadDBDAOsearchHblCustomerRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.12
*@LastModifier : 이영헌
*@LastVersion : 1.0
* 2012.06.12 이영헌
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author YoungHeon Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaManifestListDownloadDBDAOsearchHblCustomerRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchHblCustomer
	  * </pre>
	  */
	public UsaManifestListDownloadDBDAOsearchHblCustomerRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration").append("\n"); 
		query.append("FileName : UsaManifestListDownloadDBDAOsearchHblCustomerRSQL").append("\n"); 
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
		query.append("      ,H.CNTR_MF_NO BL_NO" ).append("\n"); 
		query.append("      ,C.BKG_CUST_TP_CD" ).append("\n"); 
		query.append("      ,C.CUST_CNT_CD" ).append("\n"); 
		query.append("      ,C.CUST_SEQ" ).append("\n"); 
		query.append("      ,REPLACE(NVL(UPPER(C.CUST_NM),' '),CHR(180),CHR(39)) AS CUST_NM" ).append("\n"); 
		query.append("      ,REPLACE(NVL(UPPER(C.CUST_ADDR),' '),CHR(180),CHR(39)) AS CUST_ADDR" ).append("\n"); 
		query.append("      ,@[usr_id] CRE_USR_ID" ).append("\n"); 
		query.append("      ,@[usr_id] UPD_USR_ID" ).append("\n"); 
		query.append("  FROM BKG_HBL_CUST C" ).append("\n"); 
		query.append("      ,BKG_HBL H ,  BKG_BOOKING BK" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND H.BKG_NO > ' '" ).append("\n"); 
		query.append("   AND ( #foreach($field_id in ${field_list}) " ).append("\n"); 
		query.append("          #if($velocityCount > 1)" ).append("\n"); 
		query.append("          OR #end H.CNTR_MF_NO IN ( $field_id )" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("   AND C.BKG_NO = H.BKG_NO" ).append("\n"); 
		query.append("   AND C.HBL_SEQ = H.HBL_SEQ" ).append("\n"); 
		query.append("   AND H.BKG_NO= BK.BKG_NO" ).append("\n"); 
		query.append("   AND BK.BKG_STS_CD NOT IN ('X')" ).append("\n"); 

	}
}