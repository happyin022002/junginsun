/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOsearchCustAdvisoryNoticeSendCtntRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.05.23
*@LastModifier : 
*@LastVersion : 1.0
* 2018.05.23 
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

public class GeneralBookingSearchDBDAOsearchCustAdvisoryNoticeSendCtntRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VVD 별로 기 등록된 Advisory Notice 정보를 조회한다.
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOsearchCustAdvisoryNoticeSendCtntRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration").append("\n"); 
		query.append("FileName : GeneralBookingSearchDBDAOsearchCustAdvisoryNoticeSendCtntRSQL").append("\n"); 
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
		query.append("SELECT  TO_CHAR( sysdate , 'DD Month RRRR', 'NLS_DATE_LANGUAGE = English') AS SND_DT" ).append("\n"); 
		query.append("      , BKG_JOIN_FNC(" ).append("\n"); 
		query.append("              CURSOR (SELECT ' ' || CNTR.CNTR_NO " ).append("\n"); 
		query.append("                      FROM BKG_CUST_AVC_NTC_CNTR CNTR" ).append("\n"); 
		query.append("                      WHERE BL_NO = @[bl_no] )" ).append("\n"); 
		query.append("                     )   AS CNTR_NO" ).append("\n"); 
		query.append("      , BR.IMPT_NTC_RMK RMK" ).append("\n"); 
		query.append("	  , BR.EML_SUBJ_CTNT" ).append("\n"); 
		query.append("	  , BR.FILE_DESC" ).append("\n"); 
		query.append("FROM    BKG_CUST_AVC_NTC_RMK BR " ).append("\n"); 
		query.append("WHERE   BR.VSL_CD   = SUBSTR(@[vvd], 1,4) " ).append("\n"); 
		query.append("AND     BR.SKD_VOY_NO = SUBSTR(@[vvd], 5,4)" ).append("\n"); 
		query.append("AND     BR.SKD_DIR_CD = SUBSTR(@[vvd], 9,1)" ).append("\n"); 
		query.append("AND     BR.OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("AND     BR.RMK_USE_FLG = 'Y'" ).append("\n"); 

	}
}