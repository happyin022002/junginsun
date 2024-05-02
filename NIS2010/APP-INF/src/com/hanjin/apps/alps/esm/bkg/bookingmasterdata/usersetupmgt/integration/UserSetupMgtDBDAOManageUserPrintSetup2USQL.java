/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : UserSetupMgtDBDAOManageUserPrintSetup2USQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.15
*@LastModifier : 조원주
*@LastVersion : 1.0
* 2011.11.15 조원주
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

public class UserSetupMgtDBDAOManageUserPrintSetup2USQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UserSetupMgtDBDAOManageUserPrintSetup2USQL
	  * </pre>
	  */
	public UserSetupMgtDBDAOManageUserPrintSetup2USQL(){
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
		params.put("bl_prn_setup",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.integration").append("\n"); 
		query.append("FileName : UserSetupMgtDBDAOManageUserPrintSetup2USQL").append("\n"); 
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
		query.append("MERGE INTO BKG_USR_BL_PRN_DFLT TA" ).append("\n"); 
		query.append("    USING (" ).append("\n"); 
		query.append("            SELECT  @[usr_id] USR_ID " ).append("\n"); 
		query.append("                   , BKG_GET_TOKEN_FNC(@[bl_prn_setup],1,'>') AS BL_PRN_TP_CD" ).append("\n"); 
		query.append("                   , BKG_GET_TOKEN_FNC(@[bl_prn_setup],2,'>') AS BL_PRN_CHG_TP_CD" ).append("\n"); 
		query.append("                   , BKG_GET_TOKEN_FNC(@[bl_prn_setup],3,'>') AS BL_PRN_CNTR_TP_CD" ).append("\n"); 
		query.append("                   , BKG_GET_TOKEN_FNC(@[bl_prn_setup],4,'>') AS BL_FACE_PRN_KNT" ).append("\n"); 
		query.append("                   , BKG_GET_TOKEN_FNC(@[bl_prn_setup],5,'>') AS BL_RIDR_PRN_KNT" ).append("\n"); 
		query.append("                   , BKG_GET_TOKEN_FNC(@[bl_prn_setup],6,'>') AS BL_FACE_PRN_DVC_NM" ).append("\n"); 
		query.append("                   , BKG_GET_TOKEN_FNC(@[bl_prn_setup],7,'>') AS BL_RIDR_PRN_DVC_NM" ).append("\n"); 
		query.append("				   , BKG_GET_TOKEN_FNC(@[bl_prn_setup],8,'>') AS BL_PRN_MGN_VAL" ).append("\n"); 
		query.append("            FROM   DUAL" ).append("\n"); 
		query.append("          ) TB " ).append("\n"); 
		query.append("    ON(TA.USR_ID   = TB.USR_ID AND TA.BL_PRN_TP_CD = TB.BL_PRN_TP_CD)" ).append("\n"); 
		query.append(" WHEN MATCHED THEN " ).append("\n"); 
		query.append("    UPDATE SET    BL_PRN_CHG_TP_CD  = TB.BL_PRN_CHG_TP_CD" ).append("\n"); 
		query.append("                , BL_PRN_CNTR_TP_CD = TB.BL_PRN_CNTR_TP_CD" ).append("\n"); 
		query.append("                , BL_FACE_PRN_KNT   = TB.BL_FACE_PRN_KNT" ).append("\n"); 
		query.append("                , BL_RIDR_PRN_KNT   = TB.BL_RIDR_PRN_KNT" ).append("\n"); 
		query.append("				, BL_FACE_PRN_DVC_NM = TB.BL_FACE_PRN_DVC_NM" ).append("\n"); 
		query.append("                , BL_RIDR_PRN_DVC_NM = TB.BL_RIDR_PRN_DVC_NM" ).append("\n"); 
		query.append("                , BL_PRN_MGN_VAL    =  TB.BL_PRN_MGN_VAL" ).append("\n"); 
		query.append("                , UPD_USR_ID        = TB.USR_ID " ).append("\n"); 
		query.append("                , UPD_DT            = SYSDATE" ).append("\n"); 
		query.append(" WHEN NOT MATCHED THEN " ).append("\n"); 
		query.append("    INSERT ( USR_ID,    BL_PRN_TP_CD,    BL_PRN_CHG_TP_CD,    BL_PRN_CNTR_TP_CD,    BL_FACE_PRN_KNT,    BL_RIDR_PRN_KNT,    BL_FACE_PRN_DVC_NM,    BL_RIDR_PRN_DVC_NM,   BL_PRN_MGN_VAL,  CRE_USR_ID, CRE_DT,   UPD_USR_ID, UPD_DT ) " ).append("\n"); 
		query.append("    VALUES ( TB.USR_ID, TB.BL_PRN_TP_CD, TB.BL_PRN_CHG_TP_CD, TB.BL_PRN_CNTR_TP_CD, TB.BL_FACE_PRN_KNT, TB.BL_RIDR_PRN_KNT, TB.BL_FACE_PRN_DVC_NM, TB.BL_RIDR_PRN_DVC_NM, TB.BL_PRN_MGN_VAL, TB.USR_ID,     SYSDATE,  TB.USR_ID,  SYSDATE)" ).append("\n"); 

	}
}