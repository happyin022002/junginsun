/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BookingUtilDBDAOCheckJapanStampRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.06
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.06 
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

public class BookingUtilDBDAOCheckJapanStampRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 일본 지역의 issue booking check 쿼리
	  * </pre>
	  */
	public BookingUtilDBDAOCheckJapanStampRSQL(){
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
		query.append("FileName : BookingUtilDBDAOCheckJapanStampRSQL").append("\n"); 
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
		query.append("SELECT DECODE(COUNT(*),0,'N','WEB') AS WEB_FLG" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("	/* form_rqst_via_cd 값이 WEB으로 넘어오면 찍혀요 */" ).append("\n"); 
		query.append("    SELECT  'Y' " ).append("\n"); 
		query.append("    FROM BKG_BL_ISS ISS" ).append("\n"); 
		query.append("    WHERE ISS.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("      AND ISS.OBL_ISS_FLG ='Y'" ).append("\n"); 
		query.append("      AND EXISTS (SELECT 'Y' FROM MDM_ORGANIZATION " ).append("\n"); 
		query.append("                  WHERE OFC_CD = ISS.OBL_ISS_OFC_CD" ).append("\n"); 
		query.append("                    AND LOC_CD LIKE 'JP%'" ).append("\n"); 
		query.append("                    AND ROWNUM =1 )" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}