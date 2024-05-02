/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOsearchTmnl301BracRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.22
*@LastModifier : 
*@LastVersion : 1.0
* 2010.07.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingSearchDBDAOsearchTmnl301BracRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchTmnl301Brac
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOsearchTmnl301BracRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration").append("\n"); 
		query.append("FileName : GeneralBookingSearchDBDAOsearchTmnl301BracRSQL").append("\n"); 
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
		query.append("SELECT CASE WHEN TML_NTC_SND_STS_CD = 'R' THEN 'N'" ).append("\n"); 
		query.append("ELSE 'U' END BRAC" ).append("\n"); 
		query.append("FROM (SELECT TML_NTC_SND_STS_CD, MAX(HIS_SEQ) HIS_SEQ--마지막 전송 기록" ).append("\n"); 
		query.append("FROM BKG_NTC_HIS" ).append("\n"); 
		query.append("WHERE BKG_NO      = @[bkg_no]" ).append("\n"); 
		query.append("AND NTC_VIA_CD  = 'E'" ).append("\n"); 
		query.append("AND EDI_ID      = @[rcv_id]" ).append("\n"); 
		query.append("AND TML_NTC_SND_STS_CD IS NOT NULL" ).append("\n"); 
		query.append("GROUP BY TML_NTC_SND_STS_CD" ).append("\n"); 
		query.append("ORDER BY HIS_SEQ DESC)" ).append("\n"); 
		query.append("WHERE rownum = 1" ).append("\n"); 

	}
}