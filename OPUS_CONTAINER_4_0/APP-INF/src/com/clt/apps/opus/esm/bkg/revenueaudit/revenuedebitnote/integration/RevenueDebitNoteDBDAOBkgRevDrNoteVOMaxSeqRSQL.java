/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RevenueDebitNoteDBDAOBkgRevDrNoteVOMaxSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.30
*@LastModifier : 류선우
*@LastVersion : 1.0
* 2010.03.30 류선우
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.revenueaudit.revenuedebitnote.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Ryu Sun Woo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RevenueDebitNoteDBDAOBkgRevDrNoteVOMaxSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * note RDN Max seq
	  * </pre>
	  */
	public RevenueDebitNoteDBDAOBkgRevDrNoteVOMaxSeqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.revenueaudit.revenuedebitnote.integration").append("\n"); 
		query.append("FileName : RevenueDebitNoteDBDAOBkgRevDrNoteVOMaxSeqRSQL").append("\n"); 
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
		query.append("SELECT  SUBSTR(RDN_NO, 1, 5) || LPAD(TO_NUMBER(SUBSTR(RDN_NO, 6, 4)) + 1, 4, '0000')  RDN_NO" ).append("\n"); 
		query.append("FROM  (" ).append("\n"); 
		query.append("      SELECT  NVL(MAX(RDN_NO), 'RDN' || TO_CHAR(SYSDATE,'YY') || '0000')  RDN_NO" ).append("\n"); 
		query.append("      FROM    BKG_REV_DR_NOTE" ).append("\n"); 
		query.append("      WHERE   RDN_NO  LIKE 'RDN' || TO_CHAR(SYSDATE, 'YY') || '%'" ).append("\n"); 
		query.append("      )" ).append("\n"); 

	}
}