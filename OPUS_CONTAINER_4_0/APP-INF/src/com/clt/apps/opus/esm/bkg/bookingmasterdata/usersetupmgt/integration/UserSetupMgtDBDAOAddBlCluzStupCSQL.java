/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : UserSetupMgtDBDAOAddBlCluzStupCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.24
*@LastModifier : Maeda Atsushi
*@LastVersion : 1.0
* 2015.07.24 Maeda Atsushi
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingmasterdata.usersetupmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maeda Atsushi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UserSetupMgtDBDAOAddBlCluzStupCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Insert into KBG_BL_CLUZ_STUP
	  * </pre>
	  */
	public UserSetupMgtDBDAOAddBlCluzStupCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_desc",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("org_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_appl_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_appl_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_appl_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_appl_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingmasterdata.usersetupmgt.integration").append("\n"); 
		query.append("FileName : UserSetupMgtDBDAOAddBlCluzStupCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_BL_CLUZ_STUP ( " ).append("\n"); 
		query.append("	ITM_SEQ" ).append("\n"); 
		query.append("	,ORG_CNT_CD" ).append("\n"); 
		query.append("    ,POR_APPL_FLG" ).append("\n"); 
		query.append("    ,POL_APPL_FLG" ).append("\n"); 
		query.append("    ,POD_APPL_FLG" ).append("\n"); 
		query.append("    ,DEL_APPL_FLG" ).append("\n"); 
		query.append("    ,CMDT_DESC" ).append("\n"); 
		query.append("    ,CRE_USR_ID" ).append("\n"); 
		query.append("    ,CRE_DT" ).append("\n"); 
		query.append("    ,UPD_USR_ID" ).append("\n"); 
		query.append("    ,UPD_DT" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("	NVL((SELECT MAX(ITM_SEQ)+1 FROM BKG_BL_CLUZ_STUP), 1)" ).append("\n"); 
		query.append("	, @[org_cnt_cd]" ).append("\n"); 
		query.append("	, DECODE(@[por_appl_flg], '1', 'Y', '')" ).append("\n"); 
		query.append("	, DECODE(@[pol_appl_flg], '1', 'Y', '')" ).append("\n"); 
		query.append("	, DECODE(@[pod_appl_flg], '1', 'Y', '')" ).append("\n"); 
		query.append("	, DECODE(@[del_appl_flg], '1', 'Y', '')" ).append("\n"); 
		query.append("	, @[cmdt_desc]" ).append("\n"); 
		query.append("	, @[cre_usr_id]" ).append("\n"); 
		query.append("	, SYSDATE" ).append("\n"); 
		query.append("	, @[upd_usr_id]" ).append("\n"); 
		query.append("	, SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}