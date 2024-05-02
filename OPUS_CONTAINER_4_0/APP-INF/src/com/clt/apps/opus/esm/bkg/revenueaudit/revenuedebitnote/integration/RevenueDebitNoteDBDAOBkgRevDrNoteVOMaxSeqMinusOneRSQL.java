/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : RevenueDebitNoteDBDAOBkgRevDrNoteVOMaxSeqMinusOneRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.18
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.18 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.revenueaudit.revenuedebitnote.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RevenueDebitNoteDBDAOBkgRevDrNoteVOMaxSeqMinusOneRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * rdn no 저장된 최대값
	  * </pre>
	  */
	public RevenueDebitNoteDBDAOBkgRevDrNoteVOMaxSeqMinusOneRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.revenueaudit.revenuedebitnote.integration").append("\n"); 
		query.append("FileName : RevenueDebitNoteDBDAOBkgRevDrNoteVOMaxSeqMinusOneRSQL").append("\n"); 
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
		query.append("SELECT NVL(A1.RDN_NO,('RDN' || SUBSTR(TO_CHAR(SYSDATE,'YYYYMMD'),3,2) || '0001')) AS RDN_NO" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("    SELECT MAX(RDN_NO) AS RDN_NO " ).append("\n"); 
		query.append("     FROM  BKG_REV_DR_NOTE" ).append("\n"); 
		query.append("    WHERE  SUBSTR(RDN_NO,0,6) " ).append("\n"); 
		query.append("           LIKE ('RDN' || SUBSTR(TO_CHAR(SYSDATE,'YYYYMMD'),3,2)) || '%'" ).append("\n"); 
		query.append("    ) A1" ).append("\n"); 

	}
}