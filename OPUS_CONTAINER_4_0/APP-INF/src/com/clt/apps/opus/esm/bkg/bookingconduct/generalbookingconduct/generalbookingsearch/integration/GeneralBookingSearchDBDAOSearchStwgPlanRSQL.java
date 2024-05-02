/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOSearchStwgPlanRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.18
*@LastModifier : 이주현
*@LastVersion : 1.0
* 2015.03.18 이주현
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE JU HYUN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingSearchDBDAOSearchStwgPlanRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchStwgPlan
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOSearchStwgPlanRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration").append("\n"); 
		query.append("FileName : GeneralBookingSearchDBDAOSearchStwgPlanRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT SUBSTR (MC.CNTR_NO, 1, 10) CNTR_NO" ).append("\n"); 
		query.append("                    , SUBSTR (MC.CNTR_NO, 11, 1) CNTR_NO_PST" ).append("\n"); 
		query.append("                    , MC.CNTR_NO FULL_CNTR_NO" ).append("\n"); 
		query.append("                    , MC.CNTR_TPSZ_CD TPSZ_CD" ).append("\n"); 
		query.append("                    , MC.CNMV_STS_CD CNMV_STS_CD" ).append("\n"); 
		query.append("                    , BP.POD POD_CD " ).append("\n"); 
		query.append("                    , MC.PRE_STS_FLG PRE_STS_FLG" ).append("\n"); 
		query.append("  FROM BAY_PLAN BP, MST_CONTAINER MC" ).append("\n"); 
		query.append(" WHERE BP.VSL_CD    = SUBSTR (@[vvd], 0, 4)" ).append("\n"); 
		query.append("   AND BP.VOY_NO    = SUBSTR (@[vvd], 5, 4)" ).append("\n"); 
		query.append("   AND BP.DIR_CD    = SUBSTR (@[vvd], 9, 1)" ).append("\n"); 
		query.append("   AND BP.POL       = SUBSTR (@[yd_cd], 0, 5)" ).append("\n"); 
		query.append("   AND BP.POL       = BP.PORT_CD" ).append("\n"); 
		query.append("   AND BP.ID        = MC.CNTR_NO" ).append("\n"); 
		query.append("   AND BP.FE        = 'E'" ).append("\n"); 
		query.append("   AND MC.ACIAC_DIV_CD = 'A'" ).append("\n"); 
		query.append("ORDER BY MC.CNTR_NO" ).append("\n"); 

	}
}