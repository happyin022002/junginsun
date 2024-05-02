/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : KeyManInfoDBDAOsearchKeyManDetailInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.07.04
*@LastModifier : 
*@LastVersion : 1.0
* 2017.07.04 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.cms.custmanage.keymaninfo.integration;

import java.util.HashMap;

import org.apache.log4j.Logger;

import com.hanjin.framework.core.layer.integration.DAO;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KeyManInfoDBDAOsearchKeyManDetailInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	 
	/**
	  * <pre>
	  * Search customer keyman info
	  * </pre>
	  */
	public KeyManInfoDBDAOsearchKeyManDetailInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("keyman_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.bcm.cms.custmanage.keymaninfo.integration").append("\n"); 
		query.append("FileName : KeyManInfoDBDAOsearchKeyManDetailInfoRSQL").append("\n"); 
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
		query.append("SELECT KEYMAN.CUST_CNT_CD" ).append("\n"); 
		query.append("      ,KEYMAN.CUST_SEQ" ).append("\n"); 
		query.append("      ,KEYMAN.KEYMAN_SEQ" ).append("\n"); 
		query.append("      ,KEYMAN.PRMRY_CHK_FLG" ).append("\n"); 
		query.append("      ,KEYMAN.FST_NAME" ).append("\n"); 
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
		query.append("      ,KEYMAN.BIRTH_DT" ).append("\n"); 
		query.append("      ,KEYMAN.WED_ANVRSRY_DT" ).append("\n"); 
		query.append("      ,KEYMAN_SEQ" ).append("\n"); 
		query.append("FROM MDM_CUST_KEYMAN KEYMAN" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND KEYMAN_SEQ = @[keyman_seq]" ).append("\n"); 

	}
}