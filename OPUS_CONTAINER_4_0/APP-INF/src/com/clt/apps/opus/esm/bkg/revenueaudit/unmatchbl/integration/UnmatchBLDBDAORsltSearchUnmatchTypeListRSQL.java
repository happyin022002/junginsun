/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UnmatchBLDBDAORsltSearchUnmatchTypeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.05
*@LastModifier : 김대호
*@LastVersion : 1.0
* 2009.10.05 김대호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author day-hoh Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UnmatchBLDBDAORsltSearchUnmatchTypeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Unmatch Description
	  * </pre>
	  */
	public UnmatchBLDBDAORsltSearchUnmatchTypeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.integration").append("\n"); 
		query.append("FileName : UnmatchBLDBDAORsltSearchUnmatchTypeListRSQL").append("\n"); 
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
		query.append("SELECT UT.UMCH_TP_CD" ).append("\n"); 
		query.append(",UT.UMCH_TP_DESC" ).append("\n"); 
		query.append(",(SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD02130' AND INTG_CD_VAL_CTNT = UT.REV_UMCH_CLSS_CD) AS REV_UMCH_CLSS_NM" ).append("\n"); 
		query.append("FROM   BKG_REV_UMCH_TP UT" ).append("\n"); 
		query.append("ORDER BY UT.DP_SEQ" ).append("\n"); 

	}
}