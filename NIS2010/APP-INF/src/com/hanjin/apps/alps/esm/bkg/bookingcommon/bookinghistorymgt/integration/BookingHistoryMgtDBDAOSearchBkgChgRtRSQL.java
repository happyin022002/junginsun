/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BookingHistoryMgtDBDAOSearchBkgChgRtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.30
*@LastModifier : 이남경
*@LastVersion : 1.0
* 2009.10.30 이남경
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Nam Kyung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingHistoryMgtDBDAOSearchBkgChgRtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BookingHistoryMgtDBDAOSearchBkgChgRtRSQL
	  * </pre>
	  */
	public BookingHistoryMgtDBDAOSearchBkgChgRtRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.integration").append("\n"); 
		query.append("FileName : BookingHistoryMgtDBDAOSearchBkgChgRtRSQL").append("\n"); 
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
		query.append("SELECT BKG_NO" ).append("\n"); 
		query.append(", RT_SEQ" ).append("\n"); 
		query.append(", DP_SEQ" ).append("\n"); 
		query.append(", FRT_TERM_CD" ).append("\n"); 
		query.append(", TRF_ITM_NO" ).append("\n"); 
		query.append(", CGO_CATE_CD" ).append("\n"); 
		query.append(", IMDG_CLSS_CD" ).append("\n"); 
		query.append(", CHG_CD" ).append("\n"); 
		query.append(", CURR_CD" ).append("\n"); 
		query.append(", RAT_UT_CD" ).append("\n"); 
		query.append(", BKG_QTY" ).append("\n"); 
		query.append(", RAT_AS_QTY" ).append("\n"); 
		query.append(", CHG_UT_AMT" ).append("\n"); 
		query.append(", CHG_AMT" ).append("\n"); 
		query.append(", RCV_TERM_CD" ).append("\n"); 
		query.append(", DE_TERM_CD" ).append("\n"); 
		query.append(", N3PTY_RCV_OFC_CD" ).append("\n"); 
		query.append(", N3PTY_CUST_CNT_CD" ).append("\n"); 
		query.append(", N3PTY_CUST_SEQ" ).append("\n"); 
		query.append("--, INCL_OFT_FLG" ).append("\n"); 
		query.append(", FRT_INCL_XCLD_DIV_CD" ).append("\n"); 
		query.append(", INV_STS_CD" ).append("\n"); 
		query.append(", PRN_HDN_FLG" ).append("\n"); 
		query.append(", AUTO_RAT_CD" ).append("\n"); 
		query.append(", APLY_XCH_RTO" ).append("\n"); 
		query.append(", AGMT_RAT_UT_CD" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", TO_CHAR(CRE_DT, 'YYYY-MM-DD HH24:MI:SS') CRE_DT" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", TO_CHAR(UPD_DT, 'YYYY-MM-DD HH24:MI:SS') UPD_DT" ).append("\n"); 
		query.append("FROM BKG_CHG_RT" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}