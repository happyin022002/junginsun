/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BookingHistoryMgtDBDAOSearchBkgTroDtlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.13
*@LastModifier : 
*@LastVersion : 1.0
* 2010.01.13 
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

public class BookingHistoryMgtDBDAOSearchBkgTroDtlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BookingHistoryMgtDBDAOSearchBkgTroDtlRSQL
	  * </pre>
	  */
	public BookingHistoryMgtDBDAOSearchBkgTroDtlRSQL(){
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
		query.append("FileName : BookingHistoryMgtDBDAOSearchBkgTroDtlRSQL").append("\n"); 
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
		query.append(", TRO_SUB_SEQ" ).append("\n"); 
		query.append(", CNTR_TPSZ_CD" ).append("\n"); 
		query.append(", TRO_QTY" ).append("\n"); 
		query.append(", CNTR_NO" ).append("\n"); 
		query.append(", TO_CHAR(DOR_ARR_DT, 'YYYY-MM-DD HH24:MI') DOR_ARR_DT" ).append("\n"); 
		query.append(", PKUP_LOC_CD" ).append("\n"); 
		query.append(", PKUP_YD_CD" ).append("\n"); 
		query.append(", RTN_LOC_CD" ).append("\n"); 
		query.append(", RTN_YD_CD" ).append("\n"); 
		query.append(", CMDT_CD" ).append("\n"); 
		query.append(", PCTL_NO" ).append("\n"); 
		query.append(", CXL_FLG" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", TO_CHAR(CRE_DT, 'YYYY-MM-DD HH24:MI:SS') CRE_DT" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", TO_CHAR(UPD_DT, 'YYYY-MM-DD HH24:MI:SS') UPD_DT" ).append("\n"); 
		query.append("FROM BKG_TRO_DTL" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}