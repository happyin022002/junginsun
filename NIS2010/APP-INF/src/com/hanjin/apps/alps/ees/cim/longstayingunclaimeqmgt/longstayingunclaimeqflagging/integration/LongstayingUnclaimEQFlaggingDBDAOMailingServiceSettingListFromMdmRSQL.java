/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : LongstayingUnclaimEQFlaggingDBDAOMailingServiceSettingListFromMdmRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.17
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.17 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LongstayingUnclaimEQFlaggingDBDAOMailingServiceSettingListFromMdmRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * [EES_CIM_0062] Mailing Service Setting List From MDM_COUNTRY
	  * </pre>
	  */
	public LongstayingUnclaimEQFlaggingDBDAOMailingServiceSettingListFromMdmRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.integration").append("\n"); 
		query.append("FileName : LongstayingUnclaimEQFlaggingDBDAOMailingServiceSettingListFromMdmRSQL").append("\n"); 
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
		query.append("SELECT SCONTI_CD as SCONTI_CD_H" ).append("\n"); 
		query.append("	,'Y' SCONTI_CHK" ).append("\n"); 
		query.append("	, SCONTI_CD" ).append("\n"); 
		query.append("	, CNT_CD as CNT_CD_H" ).append("\n"); 
		query.append("	, 'Y' CNT_CHK" ).append("\n"); 
		query.append("	, CNT_CD" ).append("\n"); 
		query.append("	, CNT_NM" ).append("\n"); 
		query.append("  FROM MDM_COUNTRY" ).append("\n"); 
		query.append(" WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("ORDER BY SCONTI_CD, CNT_CD" ).append("\n"); 

	}
}