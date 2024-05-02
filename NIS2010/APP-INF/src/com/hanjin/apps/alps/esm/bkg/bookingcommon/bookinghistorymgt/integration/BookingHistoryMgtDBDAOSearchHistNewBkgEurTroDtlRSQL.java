/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BookingHistoryMgtDBDAOSearchHistNewBkgEurTroDtlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.13
*@LastModifier : 
*@LastVersion : 1.0
* 2010.01.13 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingHistoryMgtDBDAOSearchHistNewBkgEurTroDtlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BookingHistoryMgtDBDAOSearchHistNewBkgEurTroDtlRSQL
	  * </pre>
	  */
	public BookingHistoryMgtDBDAOSearchHistNewBkgEurTroDtlRSQL(){
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
		query.append("FileName : BookingHistoryMgtDBDAOSearchHistNewBkgEurTroDtlRSQL").append("\n"); 
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
		query.append("SELECT 'TRO DOOR' HIS_CATE_NM" ).append("\n"); 
		query.append(", '' PRE_CTNT" ).append("\n"); 
		query.append(", NOW.LOC_CD||" ).append("\n"); 
		query.append("'/'||NOW.ZN_CD||" ).append("\n"); 
		query.append("'/'||NOW.DOR_ZIP_ID||" ).append("\n"); 
		query.append("'/'||NOW.DOR_ADDR||" ).append("\n"); 
		query.append("'/'||TO_CHAR(NOW.ARR_DT, 'YYYY-MM-DD HH24:MI') CRNT_CTNT" ).append("\n"); 
		query.append("FROM BKG_EUR_TRO_DTL NOW" ).append("\n"); 
		query.append("WHERE NOW.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#if ($field_list.size() > 0)" ).append("\n"); 
		query.append("AND (BKG_NO, IO_BND_CD, TRO_SEQ, TRO_SUB_SEQ) NOT IN (" ).append("\n"); 
		query.append("#foreach($field_id in ${field_list})" ).append("\n"); 
		query.append("#if($velocityCount < $field_list.size()) $field_id,  #else $field_id  #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND (NOW.LOC_CD IS NOT NULL OR NOW.ZN_CD IS NOT NULL OR NOW.DOR_ZIP_ID IS NOT NULL OR  NOW.DOR_ADDR IS NOT NULL OR NOW.ARR_DT IS NOT NULL)" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'TRO CONTACT' HIS_CATE_NM" ).append("\n"); 
		query.append(", '' PRE_CTNT" ).append("\n"); 
		query.append(", NOW.CNTC_PSON_NM||" ).append("\n"); 
		query.append("'/'||NOW.CNTC_PHN_NO||" ).append("\n"); 
		query.append("'/'||NOW.CNTC_EML CRNT_CTNT" ).append("\n"); 
		query.append("FROM BKG_EUR_TRO_DTL NOW" ).append("\n"); 
		query.append("WHERE NOW.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#if ($field_list.size() > 0)" ).append("\n"); 
		query.append("AND (BKG_NO, IO_BND_CD, TRO_SEQ, TRO_SUB_SEQ) NOT IN (" ).append("\n"); 
		query.append("#foreach($field_id in ${field_list})" ).append("\n"); 
		query.append("#if($velocityCount < $field_list.size()) $field_id,  #else $field_id  #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND (NOW.CNTC_PSON_NM IS NOT NULL OR NOW.CNTC_PHN_NO IS NOT NULL OR NOW.CNTC_EML IS NOT NULL)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE CRNT_CTNT IS NOT NULL" ).append("\n"); 

	}
}