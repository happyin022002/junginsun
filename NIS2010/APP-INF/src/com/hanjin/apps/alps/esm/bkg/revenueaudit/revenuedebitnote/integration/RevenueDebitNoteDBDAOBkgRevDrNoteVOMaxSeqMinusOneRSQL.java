/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RevenueDebitNoteDBDAOBkgRevDrNoteVOMaxSeqMinusOneRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.08
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.06.08 이승준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.revenueaudit.revenuedebitnote.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Seung Jun Lee
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
		query.append("(" ).append("\n"); 
		query.append("SELECT MAX(RDN_NO) AS RDN_NO" ).append("\n"); 
		query.append("FROM  BKG_REV_DR_NOTE" ).append("\n"); 
		query.append("WHERE  SUBSTR(RDN_NO,0,6)" ).append("\n"); 
		query.append("LIKE ('RDN' || SUBSTR(TO_CHAR(SYSDATE,'YYYYMMD'),3,2)) || '%'" ).append("\n"); 
		query.append(") A1" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.esm.bkg.revenueaudit.revenuedebitnote.integration").append("\n"); 
		query.append("FileName : RevenueDebitNoteDBDAOBkgRevDrNoteVOMaxSeqMinusOneRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}