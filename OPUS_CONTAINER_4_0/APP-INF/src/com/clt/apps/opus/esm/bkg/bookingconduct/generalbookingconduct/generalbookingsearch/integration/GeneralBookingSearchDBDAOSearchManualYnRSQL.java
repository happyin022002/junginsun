/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOSearchManualYnRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.26
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2015.01.26 이도형
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE, do hyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingSearchDBDAOSearchManualYnRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchManualYn
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOSearchManualYnRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration ").append("\n"); 
		query.append("FileName : GeneralBookingSearchDBDAOSearchManualYnRSQL").append("\n"); 
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
		query.append("SELECT 'Y' AS RST_YN" ).append("\n"); 
		query.append("FROM BKG_CHN_BKG_NO_GEN BCB" ).append("\n"); 
		query.append("WHERE BCB.BKG_NO_USE_FLG = 'N'" ).append("\n"); 
		query.append("AND   NOT EXISTS (SELECT 'X' FROM BKG_BOOKING BB WHERE BB.BKG_NO = BCB.BKG_NO)" ).append("\n"); 
		query.append("AND   BCB.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND   ROWNUM = 1" ).append("\n"); 

	}
}