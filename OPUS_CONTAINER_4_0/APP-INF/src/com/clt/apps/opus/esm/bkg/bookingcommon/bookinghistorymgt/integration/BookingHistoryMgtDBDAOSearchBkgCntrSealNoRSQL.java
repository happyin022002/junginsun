/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BookingHistoryMgtDBDAOSearchBkgCntrSealNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.09
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.09 
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

public class BookingHistoryMgtDBDAOSearchBkgCntrSealNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BookingHistoryMgtDBDAOSearchBkgCntrSealNoRSQL
	  * </pre>
	  */
	public BookingHistoryMgtDBDAOSearchBkgCntrSealNoRSQL(){
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
		query.append("FileName : BookingHistoryMgtDBDAOSearchBkgCntrSealNoRSQL").append("\n"); 
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
		query.append(" 	 , CNTR_NO" ).append("\n"); 
		query.append("	 , CNTR_NO||'/'||" ).append("\n"); 
		query.append("	   BKG_JOIN_FNC( CURSOR(SELECT CNTR_SEAL_NO" ).append("\n"); 
		query.append("                    		  FROM BKG_CNTR_SEAL_NO B" ).append("\n"); 
		query.append("		                     WHERE B.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                               AND B.CNTR_NO = A.CNTR_NO" ).append("\n"); 
		query.append("							ORDER BY CNTR_SEAL_SEQ)) CNTR_SEAL_NO" ).append("\n"); 
		query.append("  FROM BKG_CONTAINER A" ).append("\n"); 
		query.append(" WHERE BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}