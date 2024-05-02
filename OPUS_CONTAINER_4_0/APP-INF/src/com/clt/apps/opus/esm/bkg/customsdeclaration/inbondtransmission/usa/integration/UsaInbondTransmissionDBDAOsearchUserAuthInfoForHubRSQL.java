/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : UsaInbondTransmissionDBDAOsearchUserAuthInfoForHubRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.21
*@LastModifier : 이영헌
*@LastVersion : 1.0
* 2012.11.21 이영헌
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.inbondtransmission.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author YoungHeon Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaInbondTransmissionDBDAOsearchUserAuthInfoForHubRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dwkim, 0408, Hub수정권한 조회, outVO: None.
	  * </pre>
	  */
	public UsaInbondTransmissionDBDAOsearchUserAuthInfoForHubRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.inbondtransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaInbondTransmissionDBDAOsearchUserAuthInfoForHubRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("(SELECT CSTMS_AUTH_FLG FROM BKG_CSTMS_COM_USR_AUTH " ).append("\n"); 
		query.append("WHERE CNT_CD = 'US'" ).append("\n"); 
		query.append("AND PROC_ID = 'MIB'" ).append("\n"); 
		query.append("AND ACT_ID = 'HUB'" ).append("\n"); 
		query.append("AND USR_ID = @[usr_id]" ).append("\n"); 
		query.append("AND ROWNUM=1" ).append("\n"); 
		query.append(") HUB_AUTH" ).append("\n"); 
		query.append(",(SELECT CSTMS_AUTH_FLG FROM BKG_CSTMS_COM_USR_AUTH " ).append("\n"); 
		query.append("WHERE CNT_CD = 'US'" ).append("\n"); 
		query.append("AND PROC_ID = 'MIB'" ).append("\n"); 
		query.append("AND ACT_ID = 'CSTMS'" ).append("\n"); 
		query.append("AND USR_ID = @[usr_id]" ).append("\n"); 
		query.append("AND ROWNUM=1" ).append("\n"); 
		query.append(") CSTMS_AUTH" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}