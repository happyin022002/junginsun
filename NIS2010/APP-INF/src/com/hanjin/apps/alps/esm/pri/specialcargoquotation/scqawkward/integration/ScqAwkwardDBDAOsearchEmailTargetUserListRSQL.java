/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ScqAwkwardDBDAOsearchEmailTargetUserListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.08
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2013.07.08 송호진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SongHoJin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ScqAwkwardDBDAOsearchEmailTargetUserListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 승인권자가 Approval , reject 시 해당 requester email 조회
	  * </pre>
	  */
	public ScqAwkwardDBDAOsearchEmailTargetUserListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scq_rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.integration").append("\n"); 
		query.append("FileName : ScqAwkwardDBDAOsearchEmailTargetUserListRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT TO_USER FROM " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT USR_EML AS TO_USER " ).append("\n"); 
		query.append("FROM COM_USER" ).append("\n"); 
		query.append("WHERE USR_ID = (" ).append("\n"); 
		query.append("                SELECT PROG_USR_ID FROM PRI_SCQ_PROG " ).append("\n"); 
		query.append("                WHERE 1=1" ).append("\n"); 
		query.append("                AND PROG_SEQ = (SELECT MAX(PROG_SEQ) FROM PRI_SCQ_PROG " ).append("\n"); 
		query.append("                                WHERE 1=1" ).append("\n"); 
		query.append("                                AND SPCL_CGO_TP_CD = 'AK' " ).append("\n"); 
		query.append("                                AND PROG_STS_CD = 'Q'" ).append("\n"); 
		query.append("                                AND SCQ_RQST_NO = @[scq_rqst_no]" ).append("\n"); 
		query.append("                                )" ).append("\n"); 
		query.append("                AND SPCL_CGO_TP_CD = 'AK' " ).append("\n"); 
		query.append("                AND PROG_STS_CD = 'Q'" ).append("\n"); 
		query.append("                AND SCQ_RQST_NO = @[scq_rqst_no]                " ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT SREP_EML AS TO_USER" ).append("\n"); 
		query.append("FROM MDM_SLS_REP " ).append("\n"); 
		query.append("WHERE SREP_CD = (SELECT RQST_SREP_CD FROM PRI_SCQ_AWK_MN" ).append("\n"); 
		query.append("                 WHERE 1=1" ).append("\n"); 
		query.append("                 AND SCQ_RQST_NO = @[scq_rqst_no]   " ).append("\n"); 
		query.append("                 AND SCQ_VER_NO = (SELECT MAX(SCQ_VER_NO) " ).append("\n"); 
		query.append("                                   FROM PRI_SCQ_AWK_MN" ).append("\n"); 
		query.append("                                   WHERE 1=1" ).append("\n"); 
		query.append("                                   AND SCQ_RQST_NO = @[scq_rqst_no])" ).append("\n"); 
		query.append("                 )" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}