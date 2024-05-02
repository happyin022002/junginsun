/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UsaManifestListDownloadDBDAOsearchCustomer2RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.22
*@LastModifier : 
*@LastVersion : 1.0
* 2009.10.22 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaManifestListDownloadDBDAOsearchCustomer2RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UsaBlCustomerSecondVO
	  * </pre>
	  */
	public UsaManifestListDownloadDBDAOsearchCustomer2RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration").append("\n"); 
		query.append("FileName : UsaManifestListDownloadDBDAOsearchCustomer2RSQL").append("\n"); 
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
		query.append("SELECT CNT_CD" ).append("\n"); 
		query.append(",BL_NO" ).append("\n"); 
		query.append(",BKG_CUST_TP_CD" ).append("\n"); 
		query.append(",CUST_CNT_CD" ).append("\n"); 
		query.append(",DECODE(CUST_SEQ, 0, '', CUST_SEQ) AS CUST_SEQ" ).append("\n"); 
		query.append(",CUST_NM" ).append("\n"); 
		query.append(",CUST_ADDR" ).append("\n"); 
		query.append(",CUST_NM || CUST_ADDR AS CUST_NM_ADDR" ).append("\n"); 
		query.append(",PHN_NO" ).append("\n"); 
		query.append(",FAX_NO" ).append("\n"); 
		query.append("FROM   BKG_CSTMS_ADV_CUST" ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append("AND    CNT_CD = @[cnt_cd]" ).append("\n"); 
		query.append("AND    BL_NO = @[bl_no]" ).append("\n"); 
		query.append("AND    BKG_CUST_TP_CD IN ('F','A')" ).append("\n"); 
		query.append("ORDER BY BKG_CUST_TP_CD" ).append("\n"); 

	}
}