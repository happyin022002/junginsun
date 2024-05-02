/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BookingHistoryMgtDBDAOSearchHistNewBkgReferenceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.16
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2009.12.16 류대영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dae-Young RYU
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingHistoryMgtDBDAOSearchHistNewBkgReferenceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BookingHistoryMgtDBDAOSearchHistNewBkgReferenceRSQL
	  * </pre>
	  */
	public BookingHistoryMgtDBDAOSearchHistNewBkgReferenceRSQL(){
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
		query.append("FileName : BookingHistoryMgtDBDAOSearchHistNewBkgReferenceRSQL").append("\n"); 
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
		query.append("SELECT (SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD01658' AND NOW_REF.BKG_REF_TP_CD = INTG_CD_VAL_CTNT) HIS_CATE_NM" ).append("\n"); 
		query.append(", '' PRE_CTNT" ).append("\n"); 
		query.append(", NOW_REF.CNTR_NO||" ).append("\n"); 
		query.append("'/'||NOW_REF.CUST_REF_NO_CTNT CRNT_CTNT" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("FROM BKG_REF_HIS NOW_REF" ).append("\n"); 
		query.append("WHERE NOW_REF.BKG_NO  = @[bkg_no]" ).append("\n"); 
		query.append("AND NOW_REF.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("FROM BKG_REFERENCE NOW_REF" ).append("\n"); 
		query.append("WHERE NOW_REF.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND NOW_REF.CNTR_NO IS NOT NULL" ).append("\n"); 
		query.append("AND NOW_REF.CUST_REF_NO_CTNT IS NOT NULL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ($field_list.size() > 0)" ).append("\n"); 
		query.append("AND (BKG_NO, REF_SEQ) NOT IN (" ).append("\n"); 
		query.append("#foreach($field_id in ${field_list})" ).append("\n"); 
		query.append("#if($velocityCount < $field_list.size()) $field_id,  #else $field_id  #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT (SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD01658' AND NOW_REF.BKG_REF_TP_CD = INTG_CD_VAL_CTNT) HIS_CATE_NM" ).append("\n"); 
		query.append(", '' PRE_CTNT" ).append("\n"); 
		query.append(", NOW_REF.CUST_REF_NO_CTNT CRNT_CTNT" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("FROM BKG_REF_HIS NOW_REF" ).append("\n"); 
		query.append("WHERE NOW_REF.BKG_NO  = @[bkg_no]" ).append("\n"); 
		query.append("AND NOW_REF.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("FROM BKG_REFERENCE NOW_REF" ).append("\n"); 
		query.append("WHERE NOW_REF.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND NOW_REF.CNTR_NO IS NULL" ).append("\n"); 
		query.append("AND NOW_REF.CUST_REF_NO_CTNT IS NOT NULL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ($field_list.size() > 0)" ).append("\n"); 
		query.append("AND (BKG_NO, REF_SEQ) NOT IN (" ).append("\n"); 
		query.append("#foreach($field_id in ${field_list})" ).append("\n"); 
		query.append("#if($velocityCount < $field_list.size()) $field_id,  #else $field_id  #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE CRNT_CTNT IS NOT NULL" ).append("\n"); 

	}
}