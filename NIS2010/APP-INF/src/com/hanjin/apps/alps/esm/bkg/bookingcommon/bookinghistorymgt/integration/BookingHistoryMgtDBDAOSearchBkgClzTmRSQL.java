/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BookingHistoryMgtDBDAOSearchBkgClzTmRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.12
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.12 
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

public class BookingHistoryMgtDBDAOSearchBkgClzTmRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BookingHistoryMgtDBDAOSearchBkgClzTmRSQL
	  * </pre>
	  */
	public BookingHistoryMgtDBDAOSearchBkgClzTmRSQL(){
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
		query.append("FileName : BookingHistoryMgtDBDAOSearchBkgClzTmRSQL").append("\n"); 
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
		query.append(", CLZ_TP_CD" ).append("\n"); 
		query.append(", CLZ_YD_CD" ).append("\n"); 
		query.append(", TO_CHAR(MNL_SET_DT, 'YYYY-MM-DD HH24:MI:SS') MNL_SET_DT" ).append("\n"); 
		query.append(", MNL_SET_USR_ID" ).append("\n"); 
		query.append(", TO_CHAR(SYS_SET_DT, 'YYYY-MM-DD HH24:MI:SS') SYS_SET_DT" ).append("\n"); 
		query.append(", NTC_FLG" ).append("\n"); 
		query.append("FROM BKG_CLZ_TM" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}