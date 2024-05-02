/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : UserDAOComAppBaseMenuViewUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.03.22
*@LastModifier : 
*@LastVersion : 1.0
* 2017.03.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.syscommon.management.alps.user.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UserDAOComAppBaseMenuViewUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Insert com_usr_pgm_mtch
	  * </pre>
	  */
	public UserDAOComAppBaseMenuViewUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",n";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",n";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("view_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.syscommon.management.alps.user.integration").append("\n"); 
		query.append("FileName : UserDAOComAppBaseMenuViewUSQL").append("\n"); 
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
		query.append("MERGE INTO COM_APP_BASE_MENU_VIEW TT USING" ).append("\n"); 
		query.append("(SELECT @[usr_id] AS USR_ID FROM DUAL) SO ON (TT.USR_ID = SO.USR_ID)" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("  UPDATE SET USE_FLG = @[view_flg], UPD_DT = SYSDATE, UPD_USR_ID = @[cre_usr_id]" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("  INSERT" ).append("\n"); 
		query.append("    ( USR_ID, USE_FLG, CRE_USR_ID, UPD_USR_ID" ).append("\n"); 
		query.append("    ) VALUES" ).append("\n"); 
		query.append("    ( @[usr_id], @[view_flg], @[cre_usr_id], @[cre_usr_id]" ).append("\n"); 
		query.append("    )" ).append("\n"); 

	}
}