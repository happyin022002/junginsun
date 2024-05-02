/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : BookingUtilDBDAOsearchAperakXterRqstNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.11.17
*@LastModifier : 
*@LastVersion : 1.0
* 2017.11.17 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingUtilDBDAOsearchAperakXterRqstNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * APEARK Xter rqst no
	  * </pre>
	  */
	public BookingUtilDBDAOsearchAperakXterRqstNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.integration").append("\n"); 
		query.append("FileName : BookingUtilDBDAOsearchAperakXterRqstNoRSQL").append("\n"); 
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
		query.append("SELECT BXRM.XTER_SNDR_ID SENDER_ID" ).append("\n"); 
		query.append("	, BXRM.XTER_RQST_NO RQST_NO" ).append("\n"); 
		query.append("	, BXRM.XTER_RQST_SEQ RQST_SEQ" ).append("\n"); 
		query.append("FROM BKG_XTER_RQST_MST BXRM" ).append("\n"); 
		query.append("     ,BKG_HRD_CDG_CTNT BHCC" ).append("\n"); 
		query.append("WHERE BXRM.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND BXRM.DOC_TP_CD = 'S'" ).append("\n"); 
		query.append("AND BXRM.BKG_UPLD_STS_CD IN ('F','N')" ).append("\n"); 
		query.append("AND BXRM.XTER_RQST_VIA_CD <> 'WEB'" ).append("\n"); 
		query.append("AND BHCC.ATTR_CTNT1 = BXRM.XTER_SNDR_ID" ).append("\n"); 
		query.append("AND BHCC.ATTR_CTNT6 = 'S'" ).append("\n"); 
		query.append("AND BHCC.ATTR_CTNT5 = 'APERAK'" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 

	}
}