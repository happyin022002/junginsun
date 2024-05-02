/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : MstMgmtDBDAOSearchAuthTpCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.04
*@LastModifier : 
*@LastVersion : 1.0
* 2013.07.04 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.bcm.ccd.commoncode.mstmgmt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MstMgmtDBDAOSearchAuthTpCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Auth Type Code 조회
	  * </pre>
	  */
	public MstMgmtDBDAOSearchAuthTpCdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mst_dat_subj_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.bcm.ccd.commoncode.mstmgmt.integration").append("\n"); 
		query.append("FileName : MstMgmtDBDAOSearchAuthTpCdRSQL").append("\n"); 
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
		query.append("SELECT AUTH_TP_CD" ).append("\n"); 
		query.append("  FROM MDM_USR_AUTH" ).append("\n"); 
		query.append(" WHERE USR_ID = @[rqst_usr_id]" ).append("\n"); 
		query.append("   AND MST_DAT_SUBJ_CD = ( CASE WHEN ( SELECT count(1) FROM MDM_USR_AUTH " ).append("\n"); 
		query.append("                                        WHERE USR_ID = @[rqst_usr_id] " ).append("\n"); 
		query.append("                                          AND MST_DAT_SUBJ_CD = 'MDAA') = 0 " ).append("\n"); 
		query.append("                           THEN UPPER(@[mst_dat_subj_cd])" ).append("\n"); 
		query.append("                           ELSE 'MDAA'" ).append("\n"); 
		query.append("                           END ) " ).append("\n"); 

	}
}