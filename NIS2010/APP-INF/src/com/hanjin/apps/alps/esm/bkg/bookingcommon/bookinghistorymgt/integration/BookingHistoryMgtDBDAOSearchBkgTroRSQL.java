/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BookingHistoryMgtDBDAOSearchBkgTroRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.21
*@LastModifier : 이남경
*@LastVersion : 1.0
* 2009.09.21 이남경
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

public class BookingHistoryMgtDBDAOSearchBkgTroRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BookingHistoryMgtDBDAOSearchBkgTroRSQL
	  * </pre>
	  */
	public BookingHistoryMgtDBDAOSearchBkgTroRSQL(){
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
		query.append("FileName : BookingHistoryMgtDBDAOSearchBkgTroRSQL").append("\n"); 
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
		query.append(", IO_BND_CD" ).append("\n"); 
		query.append(", RTN_TRO_FLG" ).append("\n"); 
		query.append(", TRO_SEQ" ).append("\n"); 
		query.append(", RCV_TERM_CD" ).append("\n"); 
		query.append(", TO_CHAR(RQST_DT, 'YYYY-MM-DD HH24:MI:SS') RQST_DT" ).append("\n"); 
		query.append(", RQST_USR_ID" ).append("\n"); 
		query.append(", OWNR_TRK_FLG" ).append("\n"); 
		query.append("--, RC_SEQ" ).append("\n"); 
		query.append("--, AWK_CGO_SEQ" ).append("\n"); 
		query.append(", ACT_SHPR_CNT_CD" ).append("\n"); 
		query.append(", ACT_SHPR_SEQ" ).append("\n"); 
		query.append(", ACT_SHPR_NM" ).append("\n"); 
		query.append(", ACT_SHPR_PHN_NO" ).append("\n"); 
		query.append(", ACT_SHPR_ADDR" ).append("\n"); 
		query.append(", ZN_CD" ).append("\n"); 
		query.append(", DOR_LOC_CD" ).append("\n"); 
		query.append(", DOR_PST_NO" ).append("\n"); 
		query.append(", BIZ_RGST_NO" ).append("\n"); 
		query.append(", CFM_FLG" ).append("\n"); 
		query.append(", TO_CHAR(CFM_DT, 'YYYY-MM-DD HH24:MI:SS') CFM_DT" ).append("\n"); 
		query.append(", DIFF_RMK" ).append("\n"); 
		query.append(", CNTC_PSON_NM" ).append("\n"); 
		query.append(", CNTC_FAX_NO" ).append("\n"); 
		query.append(", CNTC_PHN_NO" ).append("\n"); 
		query.append(", CNTC_MPHN_NO" ).append("\n"); 
		query.append(", CXL_FLG" ).append("\n"); 
		query.append(", SO_FLG" ).append("\n"); 
		query.append(", SO_ACT_CUST_NO" ).append("\n"); 
		query.append(", SO_ACT_CUST_SEQ" ).append("\n"); 
		query.append(", PCTL_NO" ).append("\n"); 
		query.append(", VSL_CD" ).append("\n"); 
		query.append(", SKD_VOY_NO" ).append("\n"); 
		query.append(", SKD_DIR_CD" ).append("\n"); 
		query.append(", POL_CD" ).append("\n"); 
		query.append(", POD_CD" ).append("\n"); 
		query.append(", TRO_BKG_NO" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", TO_CHAR(CRE_DT, 'YYYY-MM-DD HH24:MI:SS') CRE_DT" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", TO_CHAR(UPD_DT, 'YYYY-MM-DD HH24:MI:SS') UPD_DT" ).append("\n"); 
		query.append("FROM BKG_TRO" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}