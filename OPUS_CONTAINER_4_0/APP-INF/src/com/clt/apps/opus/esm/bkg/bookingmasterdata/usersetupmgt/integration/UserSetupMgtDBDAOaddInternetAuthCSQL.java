/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : UserSetupMgtDBDAOaddInternetAuthCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.23
*@LastModifier : 
*@LastVersion : 1.0
* 2016.12.23 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingmasterdata.usersetupmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UserSetupMgtDBDAOaddInternetAuthCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UserSetupMgtDBDAOaddInternetAuthCSQL
	  * </pre>
	  */
	public UserSetupMgtDBDAOaddInternetAuthCSQL(){
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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inet_ftp_auth_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inet_auth_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingmasterdata.usersetupmgt.integration").append("\n"); 
		query.append("FileName : UserSetupMgtDBDAOaddInternetAuthCSQL").append("\n"); 
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
		query.append("MERGE INTO BKG_INET_AUTH TA" ).append("\n"); 
		query.append("    USING (SELECT @[usr_id] USR_ID FROM DUAL) TB" ).append("\n"); 
		query.append("    ON(TA.USR_ID = TB.USR_ID)" ).append("\n"); 
		query.append(" WHEN MATCHED THEN " ).append("\n"); 
		query.append("    UPDATE SET TA.DELT_FLG = 'N', UPD_USR_ID = @[upd_usr_id],UPD_DT = SYSDATE" ).append("\n"); 
		query.append(" WHEN NOT MATCHED THEN " ).append("\n"); 
		query.append("    INSERT (USR_ID    , RGST_USR_ID   , RGST_DT, DELT_FLG, CRE_USR_ID, CRE_DT , UPD_USR_ID, UPD_DT, INET_AUTH_FLG, INET_FTP_AUTH_FLG)" ).append("\n"); 
		query.append("    VALUES (@[usr_id] , @[upd_usr_id] , SYSDATE, 'N'     , @[upd_usr_id] , SYSDATE, @[upd_usr_id] , SYSDATE" ).append("\n"); 
		query.append("            , DECODE(@[inet_auth_flg],'1','Y','N'), DECODE(@[inet_ftp_auth_flg],'1','Y','N'))" ).append("\n"); 

	}
}