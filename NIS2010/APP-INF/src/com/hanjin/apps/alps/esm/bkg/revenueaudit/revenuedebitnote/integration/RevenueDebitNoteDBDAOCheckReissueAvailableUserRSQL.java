/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : RevenueDebitNoteDBDAOCheckReissueAvailableUserRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.30
*@LastModifier : 
*@LastVersion : 1.0
* 2012.08.30 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.revenueaudit.revenuedebitnote.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RevenueDebitNoteDBDAOCheckReissueAvailableUserRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Re-issue 기능을 사용 가능한 ID인지 체크한다.
	  * Y : 사용 가능(DPCS Auditor)
	  * N : 사용 불가
	  * </pre>
	  */
	public RevenueDebitNoteDBDAOCheckReissueAvailableUserRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.revenueaudit.revenuedebitnote.integration").append("\n"); 
		query.append("FileName : RevenueDebitNoteDBDAOCheckReissueAvailableUserRSQL").append("\n"); 
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
		query.append("SELECT ATTR_CTNT1" ).append("\n"); 
		query.append("  FROM BKG_HRD_CDG_CTNT" ).append("\n"); 
		query.append(" WHERE HRD_CDG_ID = 'RDN_AUTO_MAIL_LIST'" ).append("\n"); 
		query.append("   AND ATTR_CTNT1 = @[usr_id]" ).append("\n"); 

	}
}