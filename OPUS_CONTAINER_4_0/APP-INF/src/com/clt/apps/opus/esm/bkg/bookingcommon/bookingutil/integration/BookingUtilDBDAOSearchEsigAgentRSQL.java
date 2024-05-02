/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : BookingUtilDBDAOSearchEsigAgentRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.05
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.05 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingUtilDBDAOSearchEsigAgentRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 사인 flag 조회
	  * </pre>
	  */
	public BookingUtilDBDAOSearchEsigAgentRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration").append("\n"); 
		query.append("FileName : BookingUtilDBDAOSearchEsigAgentRSQL").append("\n"); 
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
		query.append("SELECT BL_ESIG_FLG" ).append("\n"); 
		query.append("	   , BL_CPY_ESIG_FLG" ).append("\n"); 
		query.append("	   , BL_KNT_FLG" ).append("\n"); 
		query.append("FROM BKG_BL_ESIG_OFC_ASGN" ).append("\n"); 
		query.append("WHERE BL_ISS_OFC_CD = DECODE((SELECT OBL_ISS_OFC_CD FROM BKG_BL_ISS WHERE BKG_NO = @[bkg_no] ), NULL, (SELECT BKG_OFC_CD FROM BKG_BOOKING WHERE BKG_NO = @[bkg_no])," ).append("\n"); 
		query.append("                             (SELECT OBL_ISS_OFC_CD FROM BKG_BL_ISS WHERE BKG_NO = @[bkg_no] ))" ).append("\n"); 

	}
}