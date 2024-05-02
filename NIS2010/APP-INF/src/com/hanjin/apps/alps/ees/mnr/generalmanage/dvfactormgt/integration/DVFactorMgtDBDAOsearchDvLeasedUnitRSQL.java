/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : DVFactorMgtDBDAOsearchDvLeasedUnitRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.27
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2011.04.27 김영오
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.generalmanage.dvfactormgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM YOUNG-OH
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DVFactorMgtDBDAOsearchDvLeasedUnitRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MNR-Total-DV 화면조회
	  * </pre>
	  */
	public DVFactorMgtDBDAOsearchDvLeasedUnitRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.generalmanage.dvfactormgt.integration").append("\n"); 
		query.append("FileName : DVFactorMgtDBDAOsearchDvLeasedUnitRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("LPAD(B.VNDR_SEQ, 6, '0') VNDR_SEQ" ).append("\n"); 
		query.append(",B.MNR_CNTC_PRNR_NM" ).append("\n"); 
		query.append(",B.INTL_PHN_NO" ).append("\n"); 
		query.append(",B.PHN_NO" ).append("\n"); 
		query.append(",B.INTL_FAX_NO" ).append("\n"); 
		query.append(",B.FAX_NO" ).append("\n"); 
		query.append(",B.MNR_PRNR_EML" ).append("\n"); 
		query.append(",B.MNR_PRNR_ADDR" ).append("\n"); 
		query.append(",B.MNR_PRNR_RMK" ).append("\n"); 
		query.append(",B.CRE_USR_ID" ).append("\n"); 
		query.append(",TO_CHAR(B.CRE_DT, 'YYYY-MM-DD') CRE_DT" ).append("\n"); 
		query.append(",B.UPD_USR_ID" ).append("\n"); 
		query.append(",TO_CHAR(B.UPD_DT, 'YYYY-MM-DD') UPD_DT" ).append("\n"); 
		query.append("FROM MNR_DPC_VAL_CNTC_PNT B" ).append("\n"); 
		query.append("ORDER BY B.VNDR_SEQ" ).append("\n"); 

	}
}