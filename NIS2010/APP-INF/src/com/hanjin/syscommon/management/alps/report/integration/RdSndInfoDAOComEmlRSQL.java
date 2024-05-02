/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : RdSndInfoDAOComEmlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.29
*@LastModifier : 김용후
*@LastVersion : 1.0
* 2013.05.29 김용후
* 1.0 Creation
=========================================================*/
package com.hanjin.syscommon.management.alps.report.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM.YH
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RdSndInfoDAOComEmlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Email RD 전송 정보
	  * </pre>
	  */
	public RdSndInfoDAOComEmlRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("EML_SND_NO",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.syscommon.management.alps.report.integration").append("\n"); 
		query.append("FileName : RdSndInfoDAOComEmlRSQL").append("\n"); 
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
		query.append("select " ).append("\n"); 
		query.append("*" ).append("\n"); 
		query.append("from" ).append("\n"); 
		query.append("com_eml_snd_info" ).append("\n"); 
		query.append("where" ).append("\n"); 
		query.append("EML_SND_NO like @[EML_SND_NO]" ).append("\n"); 
		query.append("order by UPD_DT desc" ).append("\n"); 

	}
}