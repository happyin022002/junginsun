/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOSearchBkgTmlEdiBatchYardCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.25
*@LastModifier : 정인선
*@LastVersion : 1.0
* 2016.05.25 정인선
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author jung in sun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingSearchDBDAOSearchBkgTmlEdiBatchYardCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GeneralBookingSearchDBDAOSearchBkgTmlEdiBatchYardCdRSQL
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOSearchBkgTmlEdiBatchYardCdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration").append("\n"); 
		query.append("FileName : GeneralBookingSearchDBDAOSearchBkgTmlEdiBatchYardCdRSQL").append("\n"); 
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
		query.append("SELECT LNK.RCVR_TRD_PRNR_ID || '|' || LNK.PRNR_SUB_LNK_CD AS EDI_REF_CD" ).append("\n"); 
		query.append("     , LNK.RCVR_TRD_PRNR_ID AS EDI_RCV_ID" ).append("\n"); 
		query.append("	 , LNK.RCVR_TRD_PRNR_ID || '(' || LNK.PRNR_SUB_LNK_CD  || ')'  AS EDI_RCV_DESC" ).append("\n"); 
		query.append("	 , LNK.PRNR_SUB_LNK_CD AS PORT" ).append("\n"); 
		query.append("  FROM BKG_EDI_SUB_LNK_MSG MSG" ).append("\n"); 
		query.append("     , BKG_EDI_TRD_PRNR_SUB_LNK LNK" ).append("\n"); 
		query.append(" WHERE MSG.EDI_MSG_TP_ID = '301'" ).append("\n"); 
		query.append("   AND MSG.EDI_MSG_IND_CD = 9" ).append("\n"); 
		query.append("   AND MSG.TRD_PRNR_SUB_LNK_SEQ = LNK.TRD_PRNR_SUB_LNK_SEQ" ).append("\n"); 
		query.append("   AND LNK.PRNR_SUB_LNK_DIV_CD = '1'" ).append("\n"); 

	}
}