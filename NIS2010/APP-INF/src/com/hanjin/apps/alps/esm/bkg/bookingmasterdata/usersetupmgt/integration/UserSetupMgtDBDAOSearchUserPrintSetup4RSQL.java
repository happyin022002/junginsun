/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : UserSetupMgtDBDAOSearchUserPrintSetup4RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.16
*@LastModifier : 조원주
*@LastVersion : 1.0
* 2011.11.16 조원주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHO WON-JOO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UserSetupMgtDBDAOSearchUserPrintSetup4RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UserSetupMgtDBDAOSearchUserPrintSetup4RSQL
	  * </pre>
	  */
	public UserSetupMgtDBDAOSearchUserPrintSetup4RSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.integration").append("\n"); 
		query.append("FileName : UserSetupMgtDBDAOSearchUserPrintSetup4RSQL").append("\n"); 
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
		query.append("    BKG_JOIN_FNC(cursor( SELECT  BL_PRN_TP_CD||'>'||BL_PRN_CHG_TP_CD||'>'|| BL_PRN_CNTR_TP_CD||'>'||" ).append("\n"); 
		query.append("                                 BL_FACE_PRN_KNT||'>'||BL_RIDR_PRN_KNT||'>'||BL_FACE_PRN_DVC_NM||'>'||BL_RIDR_PRN_DVC_NM||'>'||" ).append("\n"); 
		query.append("								  NVL(BL_PRN_MGN_VAL,'0')" ).append("\n"); 
		query.append("                                FROM BKG_USR_BL_PRN_DFLT" ).append("\n"); 
		query.append("                                WHERE USR_ID = @[usr_id]" ).append("\n"); 
		query.append("                                ORDER BY BL_PRN_TP_CD" ).append("\n"); 
		query.append("                            ),'@' ) AS BL_PRN_SETUP" ).append("\n"); 
		query.append("FROM dual" ).append("\n"); 

	}
}