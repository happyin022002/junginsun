/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOSearchBkgCreTabByUserRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.09
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2010.04.09 류대영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Ryu Daeyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingSearchDBDAOSearchBkgCreTabByUserRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GeneralBookingSearchDBDAOSearchBkgCreTabByUserRSQL
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOSearchBkgCreTabByUserRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration").append("\n"); 
		query.append("FileName : GeneralBookingSearchDBDAOSearchBkgCreTabByUserRSQL").append("\n"); 
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
		query.append("SELECT CASE WHEN NVL((SELECT 'Y'" ).append("\n"); 
		query.append("FROM COM_USR_ROLE_MTCH" ).append("\n"); 
		query.append("WHERE USR_ROLE_CD IN ('BKG16','BKG17')--DOC CENTER는 EUR로 보임" ).append("\n"); 
		query.append("AND USR_ID = @[usr_id]" ).append("\n"); 
		query.append("AND ROWNUM = 1), 'N') = 'Y' THEN 'EUR'" ).append("\n"); 
		query.append("WHEN CNT_CD 	 = 'KR'    THEN 'KOR'" ).append("\n"); 
		query.append("WHEN CONTI_CD    = 'E'     THEN 'EUR'" ).append("\n"); 
		query.append("WHEN PRNT_OFC_CD = 'HAMUR' THEN 'EUR'" ).append("\n"); 
		query.append("ELSE 'GEN' END TROTAB" ).append("\n"); 
		query.append(", OFC_INFO.OFC_CD" ).append("\n"); 
		query.append(", OFC_INFO.PRNT_OFC_CD" ).append("\n"); 
		query.append("FROM MDM_LOCATION loc_info" ).append("\n"); 
		query.append(", (SELECT LOC_CD, PRNT_OFC_CD, OFC_CD" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("WHERE OFC_CD = @[ofc_cd]) ofc_info" ).append("\n"); 
		query.append("WHERE loc_info.LOC_CD = ofc_info.loc_cd" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}