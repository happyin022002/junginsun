/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RevenueDebitNoteDBDAOBkgRevDrNoteVOMaxSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.04
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.04 
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.revenueaudit.revenuedebitnote.integration").append("\n"); 
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
		query.append("SELECT  SUBSTR(RDN_NO, 1, 5) || LPAD(TO_NUMBER(SUBSTR(RDN_NO, 6, 5)) + 1, 5, '00000')  RDN_NO" ).append("\n"); 
		query.append("FROM  (" ).append("\n"); 
		query.append("      SELECT  NVL(MAX(RDN_NO), 'RDN' || TO_CHAR(SYSDATE,'YY') || '0000')  RDN_NO" ).append("\n"); 
		query.append("      FROM    BKG_REV_DR_NOTE" ).append("\n"); 
		query.append("      WHERE   RDN_NO  LIKE 'RDN' || TO_CHAR(SYSDATE, 'YY') || '%'" ).append("\n"); 
		query.append("      )" ).append("\n"); 

	}
}