/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BookingUtilDBDDAOUserPgmRoleMachRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.12
*@LastModifier : 정인선
*@LastVersion : 1.0
* 2016.04.12 정인선
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author jung in sun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingUtilDBDDAOUserPgmRoleMachRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public BookingUtilDBDDAOUserPgmRoleMachRSQL(){
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
		params.put("pgm_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration").append("\n"); 
		query.append("FileName : BookingUtilDBDDAOUserPgmRoleMachRSQL").append("\n"); 
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
		query.append("	COUNT(B.USR_ID) CNT" ).append("\n"); 
		query.append("FROM COM_PGM_ROLE A" ).append("\n"); 
		query.append("     ,COM_USR_ROLE_MTCH B" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND A.USR_ROLE_CD = B.USR_ROLE_CD" ).append("\n"); 
		query.append("#if (${pgm_id} != '') " ).append("\n"); 
		query.append("AND A.PGM_NO = @[pgm_id]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND B.USR_ID = @[usr_id]" ).append("\n"); 
		query.append("AND A.USR_ROLE_CD IN (SELECT ATTR_CTNT1 FROM BKG_HRD_CDG_CTNT WHERE HRD_CDG_ID = 'WORK_WITH_BKG_ROLE')" ).append("\n"); 

	}
}