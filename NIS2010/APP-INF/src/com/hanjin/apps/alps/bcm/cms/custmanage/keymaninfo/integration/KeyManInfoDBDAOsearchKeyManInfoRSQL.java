/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : KeyManInfoDBDAOsearchKeyManInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.07.20
*@LastModifier : 
*@LastVersion : 1.0
* 2017.07.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.cms.custmanage.keymaninfo.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KeyManInfoDBDAOsearchKeyManInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search Keyman info
	  * </pre>
	  */
	public KeyManInfoDBDAOsearchKeyManInfoRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.bcm.cms.custmanage.keymaninfo.integration").append("\n"); 
		query.append("FileName : KeyManInfoDBDAOsearchKeyManInfoRSQL").append("\n"); 
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
		query.append("SELECT KEYMAN.CUST_CNT_CD CUST_CNT_CD" ).append("\n"); 
		query.append("      ,KEYMAN.CUST_SEQ" ).append("\n"); 
		query.append("      ,KEYMAN.KEYMAN_SEQ" ).append("\n"); 
		query.append("      ,KEYMAN.PRMRY_CHK_FLG" ).append("\n"); 
		query.append("      ,KEYMAN.FST_NAME FST_NAME" ).append("\n"); 
		query.append("      ,KEYMAN.LAST_NAME" ).append("\n"); 
		query.append("      ,KEYMAN.PER_TITLE" ).append("\n"); 
		query.append("      ,KEYMAN.JOB_TITLE" ).append("\n"); 
		query.append("      ,KEYMAN.PAGER_PIN" ).append("\n"); 
		query.append("      ,KEYMAN.OCCUPATION" ).append("\n"); 
		query.append("      ,KEYMAN.EYE_COLOR" ).append("\n"); 
		query.append("      ,KEYMAN.EMAIL_ADDR" ).append("\n"); 
		query.append("      ,KEYMAN.SREP_CD" ).append("\n"); 
		query.append("      ,KEYMAN.CON_MANAGER_NAME" ).append("\n"); 
		query.append("      ,KEYMAN.WORK_PH_NUM" ).append("\n"); 
		query.append("      ,KEYMAN.FAX_PH_NUM" ).append("\n"); 
		query.append("      ,KEYMAN.CELL_PH_NUM" ).append("\n"); 
		query.append("      ,KEYMAN.HOME_PH_NUM" ).append("\n"); 
		query.append("      ,KEYMAN.HAIR_COLOR" ).append("\n"); 
		query.append("      ,KEYMAN.SPOUSE_NAME" ).append("\n"); 
		query.append("      ,TO_CHAR(KEYMAN.BIRTH_DT, 'YYYY-MM-DD') AS BIRTH_DT" ).append("\n"); 
		query.append("      ,TO_CHAR(KEYMAN.WED_ANVRSRY_DT, 'YYYY-MM-DD') AS WED_ANVRSRY_DT" ).append("\n"); 
		query.append("      ,CUST.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("FROM MDM_CUST_KEYMAN KEYMAN" ).append("\n"); 
		query.append("     ,MDM_CUSTOMER CUST" ).append("\n"); 
		query.append("WHERE KEYMAN.CUST_CNT_CD = CUST.CUST_CNT_CD" ).append("\n"); 
		query.append("AND   KEYMAN.CUST_SEQ = CUST.CUST_SEQ" ).append("\n"); 
		query.append("AND   KEYMAN.CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("AND   KEYMAN.CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("ORDER BY KEYMAN_SEQ" ).append("\n"); 

	}
}