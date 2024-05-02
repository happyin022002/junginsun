/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OwnContainerBookingForecastMgtDBDAOCheckYardCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.23
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OwnContainerBookingForecastMgtDBDAOCheckYardCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * yard code
	  * </pre>
	  */
	public OwnContainerBookingForecastMgtDBDAOCheckYardCodeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_pol_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.integration").append("\n"); 
		query.append("FileName : OwnContainerBookingForecastMgtDBDAOCheckYardCodeRSQL").append("\n"); 
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
		query.append("WITH V_YARD AS (" ).append("\n"); 
		query.append("   SELECT A.YD_CD, 'A' AS FLG" ).append("\n"); 
		query.append("     FROM MDM_YARD A, VSK_VSL_PORT_SKD B" ).append("\n"); 
		query.append("    WHERE SUBSTR (A.YD_CD, 1, 5) like @[edi_pol_yd_cd]||'%'" ).append("\n"); 
		query.append("      AND A.DELT_FLG                = 'N'" ).append("\n"); 
		query.append("      AND A.YD_FCTY_TP_MRN_TML_FLG  = 'Y'" ).append("\n"); 
		query.append("      AND A.YD_CD                   = B.YD_CD" ).append("\n"); 
		query.append("      AND B.VSL_CD                  = substr(@[vvd],1,4)" ).append("\n"); 
		query.append("      AND B.SKD_VOY_NO              = substr(@[vvd],5,4)" ).append("\n"); 
		query.append("      AND B.SKD_DIR_CD              = substr(@[vvd],9,1)" ).append("\n"); 
		query.append("      AND B.TURN_PORT_IND_CD IN ('Y','N') " ).append("\n"); 
		query.append("     UNION ALL" ).append("\n"); 
		query.append("     SELECT A.YD_CD, 'B' AS FLG" ).append("\n"); 
		query.append("     FROM MDM_YARD A" ).append("\n"); 
		query.append("    WHERE SUBSTR (A.YD_CD, 1, 5) like @[edi_pol_yd_cd]||'%'" ).append("\n"); 
		query.append("      AND A.DELT_FLG                = 'N'" ).append("\n"); 
		query.append("      AND A.YD_FCTY_TP_MRN_TML_FLG  = 'Y' )" ).append("\n"); 
		query.append("  SELECT YD_CD" ).append("\n"); 
		query.append("   FROM V_YARD " ).append("\n"); 
		query.append("  WHERE FLG IN  (  SELECT  CASE WHEN ( SELECT MAX(YD_CD)  " ).append("\n"); 
		query.append("                                         FROM V_YARD" ).append("\n"); 
		query.append("                                        GROUP BY YD_CD " ).append("\n"); 
		query.append("                                        HAVING COUNT(1) > 1 ) IS NOT NULL THEN 'A'" ).append("\n"); 
		query.append("                            ELSE 'B'" ).append("\n"); 
		query.append("                            END AS FLG" ).append("\n"); 
		query.append("                     FROM V_YARD )" ).append("\n"); 

	}
}