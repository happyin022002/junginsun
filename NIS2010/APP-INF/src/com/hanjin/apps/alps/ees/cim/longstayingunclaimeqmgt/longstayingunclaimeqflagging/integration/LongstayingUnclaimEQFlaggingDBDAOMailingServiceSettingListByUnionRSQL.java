/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : LongstayingUnclaimEQFlaggingDBDAOMailingServiceSettingListByUnionRSQL.java
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

public class LongstayingUnclaimEQFlaggingDBDAOMailingServiceSettingListByUnionRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * [EES_CIM_0062] Mailing Service Setting List By Union
	  * </pre>
	  */
	public LongstayingUnclaimEQFlaggingDBDAOMailingServiceSettingListByUnionRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.integration").append("\n"); 
		query.append("FileName : LongstayingUnclaimEQFlaggingDBDAOMailingServiceSettingListByUnionRSQL").append("\n"); 
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
		query.append("SELECT *" ).append("\n"); 
		query.append("  FROM " ).append("\n"); 
		query.append("(   " ).append("\n"); 
		query.append("	SELECT E.SCONTI_CD as SCONTI_CD_H" ).append("\n"); 
		query.append("	    , 'N' SCONTI_CHK" ).append("\n"); 
		query.append("	    , E.SCONTI_CD" ).append("\n"); 
		query.append("	    , E.CNT_CD as CNT_CD_H" ).append("\n"); 
		query.append("	    , 'Y' CNT_CHK" ).append("\n"); 
		query.append("	    , E.CNT_CD" ).append("\n"); 
		query.append("	    , E.CNT_NM" ).append("\n"); 
		query.append("	  FROM  CIM_EQ_SPLS_DFCT_EML D, MDM_COUNTRY E" ).append("\n"); 
		query.append("	 WHERE E.CNT_CD  = D.CNT_CD" ).append("\n"); 
		query.append("	   AND D.USR_ID    = @[usr_id]" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	UNION" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	SELECT SCONTI_CD as SCONTI_CD_H" ).append("\n"); 
		query.append("	    , 'N' SCONTI_CHK" ).append("\n"); 
		query.append("	    , SCONTI_CD" ).append("\n"); 
		query.append("	    , CNT_CD as CNT_CD_H" ).append("\n"); 
		query.append("	    , 'N' CNT_CHK" ).append("\n"); 
		query.append("	    , CNT_CD" ).append("\n"); 
		query.append("	    , CNT_NM" ).append("\n"); 
		query.append("	  FROM MDM_COUNTRY" ).append("\n"); 
		query.append("	 WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("	   AND CNT_CD NOT IN " ).append("\n"); 
		query.append("	( " ).append("\n"); 
		query.append("		SELECT D.CNT_CD" ).append("\n"); 
		query.append("	      FROM  CIM_EQ_SPLS_DFCT_EML D" ).append("\n"); 
		query.append("	     WHERE D.USR_ID    = @[usr_id]" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ORDER BY SCONTI_CD, CNT_CD" ).append("\n"); 

	}
}