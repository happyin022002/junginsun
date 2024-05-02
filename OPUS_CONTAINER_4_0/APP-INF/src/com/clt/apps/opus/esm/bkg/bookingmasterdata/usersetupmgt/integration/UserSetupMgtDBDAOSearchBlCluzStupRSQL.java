/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : UserSetupMgtDBDAOSearchBlCluzStupRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.24
*@LastModifier : Maeda Atsushi
*@LastVersion : 1.0
* 2015.07.24 Maeda Atsushi
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingmasterdata.usersetupmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maeda Atsushi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UserSetupMgtDBDAOSearchBlCluzStupRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Select from BKG_BL_CLUZ_STUP
	  * </pre>
	  */
	public UserSetupMgtDBDAOSearchBlCluzStupRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingmasterdata.usersetupmgt.integration").append("\n"); 
		query.append("FileName : UserSetupMgtDBDAOSearchBlCluzStupRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("	ITM_SEQ" ).append("\n"); 
		query.append("	,ORG_CNT_CD" ).append("\n"); 
		query.append("	,POR_APPL_FLG" ).append("\n"); 
		query.append("	,POL_APPL_FLG" ).append("\n"); 
		query.append("	,POD_APPL_FLG" ).append("\n"); 
		query.append("	,DEL_APPL_FLG" ).append("\n"); 
		query.append("	,CMDT_DESC" ).append("\n"); 
		query.append("	,DELT_FLG" ).append("\n"); 
		query.append("	,CRE_USR_ID" ).append("\n"); 
		query.append("	,CRE_DT" ).append("\n"); 
		query.append("	,UPD_USR_ID" ).append("\n"); 
		query.append("	,TO_CHAR(UPD_DT,'YYYY-MM-DD  HH24:MI') AS UPD_DT" ).append("\n"); 
		query.append("FROM BKG_BL_CLUZ_STUP " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE 0=0" ).append("\n"); 
		query.append("AND ORG_CNT_CD LIKE NVL(@[org_cnt_cd], '') || '%'" ).append("\n"); 
		query.append("ORDER BY ORG_CNT_CD, ITM_SEQ" ).append("\n"); 

	}
}