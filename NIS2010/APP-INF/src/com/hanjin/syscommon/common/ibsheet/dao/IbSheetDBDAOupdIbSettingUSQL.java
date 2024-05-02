/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : IbSheetDBDAOupdIbSettingUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.29
*@LastModifier : heo
*@LastVersion : 1.0
* 2014.07.29 heo
* 1.0 Creation
=========================================================*/
package com.hanjin.syscommon.common.ibsheet.dao;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 허은정
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class IbSheetDBDAOupdIbSettingUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * updIbSetting
	  * </pre>
	  */
	public IbSheetDBDAOupdIbSettingUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hdr_len_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sh_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("scrn_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hdr_desc",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.syscommon.common.ibsheet.dao").append("\n"); 
		query.append("FileName : IbSheetDBDAOupdIbSettingUSQL").append("\n"); 
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
		query.append("UPDATE com_sh_hdr_info		  	" ).append("\n"); 
		query.append(" SET hdr_desc = @[hdr_desc]   , hdr_len_ctnt = @[hdr_len_ctnt]      			" ).append("\n"); 
		query.append(" WHERE usr_id=@[usr_id] AND scrn_id=@[scrn_id] AND sh_id=@[sh_id]" ).append("\n"); 

	}
}