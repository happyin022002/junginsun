/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BookingHistoryMgtDBDAOSearchHistNewBkgRefDtlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.16
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2009.12.16 류대영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dae-Young RYU
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingHistoryMgtDBDAOSearchHistNewBkgRefDtlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BookingHistoryMgtDBDAOSearchHistNewBkgRefDtlRSQL
	  * </pre>
	  */
	public BookingHistoryMgtDBDAOSearchHistNewBkgRefDtlRSQL(){
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
		query.append("FileName : BookingHistoryMgtDBDAOSearchHistNewBkgRefDtlRSQL").append("\n"); 
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
		query.append("SELECT HIS_CATE_NM" ).append("\n"); 
		query.append(", PRE_CTNT" ).append("\n"); 
		query.append(", CRNT_CTNT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT 'P/O & OTHER NO' HIS_CATE_NM" ).append("\n"); 
		query.append(", '' PRE_CTNT" ).append("\n"); 
		query.append(", NOW.CNTR_NO||" ).append("\n"); 
		query.append("'/'||NOW.PO_NO||" ).append("\n"); 
		query.append("'/'||NOW.ITM_NO||" ).append("\n"); 
		query.append("'/PACKAGE:'||NOW.PCK_QTY||' '||NOW.PCK_TP_CD||" ).append("\n"); 
		query.append("'/WEIGHT:'||NOW.CNTR_WGT||' '||NOW.WGT_UT_CD||" ).append("\n"); 
		query.append("'/MEASURE:'||NOW.MEAS_QTY||' '||NOW.MEAS_UT_CD CRNT_CTNT" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("FROM BKG_REF_DTL_HIS NOW" ).append("\n"); 
		query.append("WHERE NOW.BKG_NO  = @[bkg_no]" ).append("\n"); 
		query.append("AND NOW.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("FROM BKG_REF_DTL NOW" ).append("\n"); 
		query.append("WHERE NOW.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ($filed_list.size() > 0)" ).append("\n"); 
		query.append("AND (BKG_NO, REF_SEQ) NOT IN (" ).append("\n"); 
		query.append("#foreach($filed_id in ${filed_list})" ).append("\n"); 
		query.append("#if($velocityCount < $filed_list.size()) $filed_id,  #else $filed_id  #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE CRNT_CTNT IS NOT NULL" ).append("\n"); 

	}
}