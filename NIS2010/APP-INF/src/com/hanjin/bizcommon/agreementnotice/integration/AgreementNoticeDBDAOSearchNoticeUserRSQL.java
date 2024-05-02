/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AgreementNoticeDBDAOSearchNoticeUserRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.26
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.26 
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.agreementnotice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AgreementNoticeDBDAOSearchNoticeUserRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Notice popup user list 조회
	  * </pre>
	  */
	public AgreementNoticeDBDAOSearchNoticeUserRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pgm_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.bizcommon.agreementnotice.integration").append("\n"); 
		query.append("FileName : AgreementNoticeDBDAOSearchNoticeUserRSQL").append("\n"); 
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
		query.append("COUNT(M.SYS_CD) CNT" ).append("\n"); 
		query.append("FROM COM_CTRT_USR_MGMT M" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND M.ROOT_PGM_NO = @[pgm_no]" ).append("\n"); 
		query.append("AND EXISTS (" ).append("\n"); 
		query.append("    SELECT 'X'" ).append("\n"); 
		query.append("    FROM COM_CTRT_USR_LIST L" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("    AND L.SYS_CD = M.SYS_CD" ).append("\n"); 
		query.append("    AND L.CTRT_OFC_CD = M.CTRT_OFC_CD" ).append("\n"); 
		query.append("    AND L.AGMT_NO = M.AGMT_NO" ).append("\n"); 
		query.append("    AND L.NTC_USR_ID = @[user_id]" ).append("\n"); 
		query.append("    AND L.NTC_USR_SEQ <= COM_NTC_USR_KNT_FNC()" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}