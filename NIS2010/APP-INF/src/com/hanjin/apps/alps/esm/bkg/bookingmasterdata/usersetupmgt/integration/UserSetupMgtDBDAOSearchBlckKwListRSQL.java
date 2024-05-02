/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : UserSetupMgtDBDAOSearchBlckKwListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.30
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.30 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UserSetupMgtDBDAOSearchBlckKwListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * bkg_blck_kw_list 조회
	  * </pre>
	  */
	public UserSetupMgtDBDAOSearchBlckKwListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("blck_kw_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.integration").append("\n"); 
		query.append("FileName : UserSetupMgtDBDAOSearchBlckKwListRSQL").append("\n"); 
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
		query.append("select   BLCK_KW_TP_CD" ).append("\n"); 
		query.append("		,BLCK_KW_TP_SEQ" ).append("\n"); 
		query.append("		,BLCK_KW_NM" ).append("\n"); 
		query.append("		,BLCK_KW_CTNT" ).append("\n"); 
		query.append("		,BLCK_KW_RMK" ).append("\n"); 
		query.append("		,CRE_USR_ID" ).append("\n"); 
		query.append("		,TO_CHAR(CRE_DT,'YYYY/MM/DD HH24:MI') CRE_DT" ).append("\n"); 
		query.append("		,UPD_USR_ID" ).append("\n"); 
		query.append("		,TO_CHAR(UPD_DT,'YYYY/MM/DD HH24:MI') UPD_DT" ).append("\n"); 
		query.append("from bkg_blck_kw_list" ).append("\n"); 
		query.append("where BLCK_KW_TP_CD = @[blck_kw_tp_cd]" ).append("\n"); 

	}
}