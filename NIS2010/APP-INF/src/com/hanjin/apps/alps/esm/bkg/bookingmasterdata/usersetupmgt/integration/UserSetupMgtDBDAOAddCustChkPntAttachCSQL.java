/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : UserSetupMgtDBDAOAddCustChkPntAttachCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.13
*@LastModifier : Do Soon Choi
*@LastVersion : 1.0
* 2015.07.13 Do Soon Choi
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Do Soon Choi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UserSetupMgtDBDAOAddCustChkPntAttachCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Attachment 를 등록한다.
	  * </pre>
	  */
	public UserSetupMgtDBDAOAddCustChkPntAttachCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("file_sav_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("atch_file_lnk_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.integration").append("\n"); 
		query.append("FileName : UserSetupMgtDBDAOAddCustChkPntAttachCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_ATCH_FILE " ).append("\n"); 
		query.append("(   ATCH_FILE_LNK_ID," ).append("\n"); 
		query.append("    ATCH_FILE_LNK_SEQ," ).append("\n"); 
		query.append("    FILE_SAV_ID," ).append("\n"); 
		query.append("    CRE_USR_ID," ).append("\n"); 
		query.append("    CRE_DT," ).append("\n"); 
		query.append("    UPD_USR_ID," ).append("\n"); 
		query.append("    UPD_DT" ).append("\n"); 
		query.append(") VALUES" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    @[atch_file_lnk_id]," ).append("\n"); 
		query.append("    (SELECT NVL(MAX(ATCH_FILE_LNK_SEQ),0) + 1" ).append("\n"); 
		query.append("     FROM BKG_ATCH_FILE" ).append("\n"); 
		query.append("     WHERE ATCH_FILE_LNK_ID = @[atch_file_lnk_id])," ).append("\n"); 
		query.append("    @[file_sav_id]," ).append("\n"); 
		query.append("    @[cre_usr_id]," ).append("\n"); 
		query.append("    SYSDATE," ).append("\n"); 
		query.append("    @[upd_usr_id]," ).append("\n"); 
		query.append("    SYSDATE    " ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}