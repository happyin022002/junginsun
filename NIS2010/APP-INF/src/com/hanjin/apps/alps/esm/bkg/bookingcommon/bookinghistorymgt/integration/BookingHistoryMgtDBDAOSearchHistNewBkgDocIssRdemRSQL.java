/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BookingHistoryMgtDBDAOSearchHistNewBkgDocIssRdemRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.04
*@LastModifier : 전성진
*@LastVersion : 1.0
* 2010.01.04 전성진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung Jin Jeon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingHistoryMgtDBDAOSearchHistNewBkgDocIssRdemRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BookingHistoryMgtDBDAOSearchHistNewBkgDocIssRdemRSQL
	  * </pre>
	  */
	public BookingHistoryMgtDBDAOSearchHistNewBkgDocIssRdemRSQL(){
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
		query.append("FileName : BookingHistoryMgtDBDAOSearchHistNewBkgDocIssRdemRSQL").append("\n"); 
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
		query.append("(SELECT 'ISSUE/RLS CANCEL' HIS_CATE_NM" ).append("\n"); 
		query.append(",'' PRE_CTNT" ).append("\n"); 
		query.append(",ISS_RDEM_KNT || '/' || EVNT_OFC_CD || '/' ||" ).append("\n"); 
		query.append("EVNT_USR_ID || '/' || TO_CHAR(EVNT_DT, 'YYYYMMDD') CRNT_CTNT" ).append("\n"); 
		query.append("FROM BKG_DOC_ISS_RDEM NOW" ).append("\n"); 
		query.append("WHERE NOW.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#if ($field_list.size() > 0)" ).append("\n"); 
		query.append("AND (BKG_NO, HIS_SEQ) NOT IN (" ).append("\n"); 
		query.append("#foreach($field_id in ${field_list})" ).append("\n"); 
		query.append("#if($velocityCount < $field_list.size()) $field_id,  #else $field_id  #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE CRNT_CTNT IS NOT NULL" ).append("\n"); 

	}
}