/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CommonPopUpManageDBDAOGetEMAILTemplateContentRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.14
*@LastModifier : 신한성
*@LastVersion : 1.0
* 2009.08.14 신한성
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.common.popup.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Shin Han Sung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonPopUpManageDBDAOGetEMAILTemplateContentRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GetEMAILTemplateContent
	  * </pre>
	  */
	public CommonPopUpManageDBDAOGetEMAILTemplateContentRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.common.popup.integration ").append("\n"); 
		query.append("FileName : CommonPopUpManageDBDAOGetEMAILTemplateContentRSQL").append("\n"); 
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
		query.append("SELECT note_tmplt_rmk" ).append("\n"); 
		query.append("FROM   SCE_EXPT_PG_STUP_MST" ).append("\n"); 
		query.append("WHERE  exe_usr_id=@[usr_id]" ).append("\n"); 
		query.append("AND	   mofc_id=@[ofc_cd]" ).append("\n"); 

	}
}