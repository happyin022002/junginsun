/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BookingHistoryMgtDBDAOSearchBkgBbCgoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.14
*@LastModifier : 이남경
*@LastVersion : 1.0
* 2009.08.14 이남경
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Nam Kyung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingHistoryMgtDBDAOSearchBkgBbCgoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BookingHistoryMgtDBDAOSearchBkgBbCgoRSQL
	  * </pre>
	  */
	public BookingHistoryMgtDBDAOSearchBkgBbCgoRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.integration").append("\n"); 
		query.append("FileName : BookingHistoryMgtDBDAOSearchBkgBbCgoRSQL").append("\n"); 
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
		query.append(", BB_CGO_SEQ" ).append("\n"); 
		query.append(", RCV_TERM_CD" ).append("\n"); 
		query.append(", DE_TERM_CD" ).append("\n"); 
		query.append(", PCK_QTY" ).append("\n"); 
		query.append(", PCK_TP_CD" ).append("\n"); 
		query.append(", GRS_WGT" ).append("\n"); 
		query.append(", NET_WGT" ).append("\n"); 
		query.append(", WGT_UT_CD" ).append("\n"); 
		query.append(", DIM_LEN" ).append("\n"); 
		query.append(", DIM_WDT" ).append("\n"); 
		query.append(", DIM_HGT" ).append("\n"); 
		query.append(", CGO_WGT" ).append("\n"); 
		query.append(", STWG_INSTR_DESC" ).append("\n"); 
		query.append(", BB_DCGO_SEQ" ).append("\n"); 
		query.append(", CMDT_CD" ).append("\n"); 
		query.append(", SLNG_PNT_FLG" ).append("\n"); 
		query.append(", GRAV_CTR_DESC" ).append("\n"); 
		query.append(", PCK_DTL_DESC" ).append("\n"); 
		query.append(", CGO_LODG_MZD_CD" ).append("\n"); 
		query.append(", SCR_DNG_CTNT" ).append("\n"); 
		query.append(", SPCL_RQST_DESC" ).append("\n"); 
		query.append(", DIFF_RMK" ).append("\n"); 
		query.append(", TO_CHAR(RQST_DT, 'YYYY-MM-DD HH24:MI:SS') RQST_DT" ).append("\n"); 
		query.append(", RQST_USR_ID" ).append("\n"); 
		query.append(", SPCL_CGO_APRO_CD" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", TO_CHAR(CRE_DT, 'YYYY-MM-DD HH24:MI:SS') CRE_DT" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", TO_CHAR(UPD_DT, 'YYYY-MM-DD HH24:MI:SS') UPD_DT" ).append("\n"); 
		query.append("FROM BKG_BB_CGO" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}