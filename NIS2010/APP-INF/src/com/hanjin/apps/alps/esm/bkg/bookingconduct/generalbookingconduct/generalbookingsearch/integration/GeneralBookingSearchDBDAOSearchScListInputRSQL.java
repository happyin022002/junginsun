/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOSearchScListInputRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.27
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.27 
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

public class GeneralBookingSearchDBDAOSearchScListInputRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchScListInput 파라메터 조회
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOSearchScListInputRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration").append("\n"); 
		query.append("FileName : GeneralBookingSearchDBDAOSearchScListInputRSQL").append("\n"); 
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
		query.append("SELECT BK.BKG_NO" ).append("\n"); 
		query.append("     , BK.VSL_CD||BK.SKD_VOY_NO||BK.SKD_DIR_CD BKG_VVD" ).append("\n"); 
		query.append("     , BK.POR_CD" ).append("\n"); 
		query.append("     , BK.DEL_CD" ).append("\n"); 
		query.append("     , SHPR.CUST_CNT_CD  S_CUST_CNT_CD" ).append("\n"); 
		query.append("     , SHPR.CUST_SEQ     S_CUST_SEQ" ).append("\n"); 
		query.append("     , CNEE.CUST_CNT_CD  C_CUST_CNT_CD" ).append("\n"); 
		query.append("     , CNEE.CUST_SEQ     C_CUST_SEQ" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("  FROM BKG_BKG_HIS BK" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("  FROM BKG_BOOKING BK" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("     , BKG_CUSTOMER SHPR" ).append("\n"); 
		query.append("     , BKG_CUSTOMER CNEE" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND BK.BKG_NO = SHPR.BKG_NO" ).append("\n"); 
		query.append("   AND BK.BKG_NO = CNEE.BKG_NO" ).append("\n"); 
		query.append("   AND SHPR.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("   AND CNEE.BKG_CUST_TP_CD = 'C'" ).append("\n"); 
		query.append("   AND BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("   AND BK.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}