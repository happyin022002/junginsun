/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BookingHistoryMgtDBDAOSearchBkgRateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.09.12
*@LastModifier : 
*@LastVersion : 1.0
* 2016.09.12 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingHistoryMgtDBDAOSearchBkgRateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BookingHistoryMgtDBDAOSearchBkgRateRSQL
	  * </pre>
	  */
	public BookingHistoryMgtDBDAOSearchBkgRateRSQL(){
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
		query.append("FileName : BookingHistoryMgtDBDAOSearchBkgRateRSQL").append("\n"); 
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
		query.append(", RT_BL_TP_CD" ).append("\n"); 
		query.append(", FRT_TERM_CD" ).append("\n"); 
		query.append(", BKG_CTRT_TP_CD" ).append("\n"); 
		query.append(", PPD_RCV_OFC_CD" ).append("\n"); 
		query.append(", PPD_PAYR_CNT_CD" ).append("\n"); 
		query.append(", PPD_PAYR_CUST_SEQ" ).append("\n"); 
		query.append(", CLT_OFC_CD" ).append("\n"); 
		query.append(", CLT_PAYR_CNT_CD" ).append("\n"); 
		query.append(", CLT_PAYR_CUST_SEQ" ).append("\n"); 
		query.append(", REV_DIV_CD" ).append("\n"); 
		query.append(", BKG_RT_WHF_EXPT_CD" ).append("\n"); 
		query.append(", WHF_SHPR_RGST_NO" ).append("\n"); 
		query.append(", TO_CHAR(RT_APLY_DT, 'YYYY-MM-DD HH24:MI:SS') RT_APLY_DT" ).append("\n"); 
		query.append(", TO_CHAR(CGO_RCV_DT, 'YYYY-MM-DD HH24:MI:SS') CGO_RCV_DT" ).append("\n"); 
		query.append(", DIFF_RMK" ).append("\n"); 
		query.append(", AUD_STS_CD" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", TO_CHAR(CRE_DT, 'YYYY-MM-DD HH24:MI:SS') CRE_DT" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", TO_CHAR(UPD_DT, 'YYYY-MM-DD HH24:MI:SS') UPD_DT" ).append("\n"); 
		query.append(", PRC_RT_MTCH_PATT_CD" ).append("\n"); 
		query.append(", PRC_GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append(", PRC_CMDT_HDR_SEQ" ).append("\n"); 
		query.append(", PRC_ROUT_SEQ" ).append("\n"); 
		query.append(", DOC_LOC_CD" ).append("\n"); 
		query.append("  FROM BKG_RATE" ).append("\n"); 
		query.append(" WHERE BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}