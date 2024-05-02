/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UserSetupMgtDBDAOManageUserPrintSetupUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.22
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2009.09.22 김경섭
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingmasterdata.usersetupmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Gyoung Sub
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UserSetupMgtDBDAOManageUserPrintSetupUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UserSetupMgtDBDAOManageUserPrintSetupUSQL
	  * </pre>
	  */
	public UserSetupMgtDBDAOManageUserPrintSetupUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_ridr_prn_dvc_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_prn_dvc_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bl_face_prn_dvc_nm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingmasterdata.usersetupmgt.integration").append("\n"); 
		query.append("FileName : UserSetupMgtDBDAOManageUserPrintSetupUSQL").append("\n"); 
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
		query.append("MERGE INTO BKG_USR_DFLT_SET TA" ).append("\n"); 
		query.append("USING (" ).append("\n"); 
		query.append("SELECT  @[usr_id] USR_ID" ).append("\n"); 
		query.append(", @[bl_face_prn_dvc_nm] BL_FACE_PRN_DVC_NM" ).append("\n"); 
		query.append(", @[bl_ridr_prn_dvc_nm] BL_RIDR_PRN_DVC_NM" ).append("\n"); 
		query.append(", @[bl_prn_dvc_nm] BL_PRN_DVC_NM" ).append("\n"); 
		query.append("FROM   DUAL" ).append("\n"); 
		query.append(") TB" ).append("\n"); 
		query.append("ON(TA.USR_ID   = TB.USR_ID )" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE SET    BL_FACE_PRN_DVC_NM = TB.BL_FACE_PRN_DVC_NM" ).append("\n"); 
		query.append(", BL_RIDR_PRN_DVC_NM = TB.BL_RIDR_PRN_DVC_NM" ).append("\n"); 
		query.append(", BL_PRN_DVC_NM      = TB.BL_PRN_DVC_NM" ).append("\n"); 
		query.append(", CRE_USR_ID         = TB.USR_ID" ).append("\n"); 
		query.append(", CRE_DT             = SYSDATE" ).append("\n"); 
		query.append(", UPD_USR_ID         = TB.USR_ID" ).append("\n"); 
		query.append(", UPD_DT             = SYSDATE" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT (  USR_ID,    BL_FACE_PRN_DVC_NM,    BL_RIDR_PRN_DVC_NM,    BL_PRN_DVC_NM,     CRE_USR_ID, CRE_DT,  UPD_USR_ID, UPD_DT )" ).append("\n"); 
		query.append("VALUES (  TB.USR_ID, TB.BL_FACE_PRN_DVC_NM, TB.BL_RIDR_PRN_DVC_NM, TB.BL_PRN_DVC_NM,  TB.USR_ID,  SYSDATE, TB.USR_ID,  SYSDATE)" ).append("\n"); 

	}
}