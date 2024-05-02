/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : UserSetupMgtDBDAOSearchUserInternetAuthRSQL.java
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

public class UserSetupMgtDBDAOSearchUserInternetAuthRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UserSetupMgtDBDAOSearchUserInternetAuthRSQL.Query
	  * </pre>
	  */
	public UserSetupMgtDBDAOSearchUserInternetAuthRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ibflag",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("usr_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingmasterdata.usersetupmgt.integration").append("\n"); 
		query.append("FileName : UserSetupMgtDBDAOSearchUserInternetAuthRSQL").append("\n"); 
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
		query.append("SELECT /*+ ORDERED */  " ).append("\n"); 
		query.append("      A.USR_ID,B.USR_NM,B.OFC_CD, TO_CHAR(A.UPD_DT,'YYYY-MM-DD  HH24:MI')UPD_DT, C.USR_NM UPD_NM, C.OFC_CD UPD_OFC_CD" ).append("\n"); 
		query.append("      , DECODE(NVL(INET_AUTH_FLG,' '),'Y','1','0')     AS INET_AUTH_FLG" ).append("\n"); 
		query.append("      , DECODE(NVL(INET_FTP_AUTH_FLG,' '),'Y','1','0') AS INET_FTP_AUTH_FLG" ).append("\n"); 
		query.append("FROM BKG_INET_AUTH A, COM_USER B, COM_USER C" ).append("\n"); 
		query.append("WHERE A.USR_ID = B.USR_ID" ).append("\n"); 
		query.append("AND A.UPD_USR_ID = C.USR_ID(+)" ).append("\n"); 
		query.append("AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND 'R' = @[ibflag]" ).append("\n"); 
		query.append("#if (${usr_id} != '') " ).append("\n"); 
		query.append("AND UPPER(A.USR_ID) LIKE '%'||UPPER(@[usr_id])||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${usr_nm} != '') " ).append("\n"); 
		query.append("AND UPPER(B.USR_NM) LIKE '%'||UPPER(@[usr_nm])||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${ofc_cd} != '') " ).append("\n"); 
		query.append("AND B.OFC_CD LIKE '%'||@[ofc_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT USR_ID, USR_NM, OFC_CD,'','','','',''" ).append("\n"); 
		query.append("FROM COM_USER B" ).append("\n"); 
		query.append("WHERE 'R2' = @[ibflag]" ).append("\n"); 
		query.append("AND UPPER(USR_ID) = UPPER(@[usr_id])" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY USR_ID" ).append("\n"); 

	}
}