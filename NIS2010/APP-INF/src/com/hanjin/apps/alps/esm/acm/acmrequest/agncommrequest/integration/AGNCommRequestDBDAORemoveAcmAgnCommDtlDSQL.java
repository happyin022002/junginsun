/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : AGNCommRequestDBDAORemoveAcmAgnCommDtlDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.01.22
*@LastModifier : 이윤정
*@LastVersion : 1.0
* 2013.01.22 이윤정
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmrequest.agncommrequest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE YOUNJUNG
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGNCommRequestDBDAORemoveAcmAgnCommDtlDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RemoveAcmAgnCommDtl
	  * </pre>
	  */
	public AGNCommRequestDBDAORemoveAcmAgnCommDtlDSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmrequest.agncommrequest.integration").append("\n"); 
		query.append("FileName : AGNCommRequestDBDAORemoveAcmAgnCommDtlDSQL").append("\n"); 
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
		query.append("DELETE ACM_AGN_COMM_DTL" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND (BKG_NO,AGN_CD,IO_BND_CD,AC_TP_CD,AC_SEQ) NOT IN " ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("        SELECT BKG_NO,AGN_CD,IO_BND_CD,AC_TP_CD,AC_SEQ" ).append("\n"); 
		query.append("        FROM   ACM_AGN_COMM" ).append("\n"); 
		query.append("        WHERE  BKG_NO    = @[bkg_no]" ).append("\n"); 
		query.append("    )" ).append("\n"); 

	}
}