/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SpecialManifestDBDAOsearchBayPlanInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.19
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2012.03.19 김경섭
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.specialmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Gyoung Sub
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialManifestDBDAOsearchBayPlanInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VVD와 Port를 가지고 Bay Plan에서 Cell position을 자동으로 가져 왔는 지 여부를 조회 한다.
	  * </pre>
	  */
	public SpecialManifestDBDAOsearchBayPlanInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.terminaldocumentation.specialmanifest.integration").append("\n"); 
		query.append("FileName : SpecialManifestDBDAOsearchBayPlanInfoRSQL").append("\n"); 
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
		query.append("SELECT VSL_BAY_NO || VSL_ROW_NO || VSL_TR_NO CRNT_CELL_PSN_NO" ).append("\n"); 
		query.append("FROM OPF_BAY_PLN_LDIS" ).append("\n"); 
		query.append("WHERE VSL_CD      = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("AND   SKD_VOY_NO  = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("AND   SKD_DIR_CD  = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${d_type} == 'D' || ${d_type} == 'DO') -- Discharging" ).append("\n"); 
		query.append("AND   POD_CD      = @[port_cd]" ).append("\n"); 
		query.append("#elseif (${d_type} == 'O') -- On-Carriage" ).append("\n"); 
		query.append("AND   POL_CD = @[port_cd] AND POD_CD = 'NLRTM'" ).append("\n"); 
		query.append("#elseif (${d_type} == 'L' || ${d_type} == 'PL' || ${d_type} == 'L') -- Loading" ).append("\n"); 
		query.append("AND   POL_CD      = @[port_cd]" ).append("\n"); 
		query.append("#elseif (${d_type} == 'P') -- Pre-Carriage" ).append("\n"); 
		query.append("AND   POL_CD = 'NLRTM' AND POD_CD = @[port_cd]" ).append("\n"); 
		query.append("#else -- transit" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND POL_CD        IN  (SELECT VPS_PORT_CD" ).append("\n"); 
		query.append("                            FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                           WHERE VSL_CD      = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("                             AND SKD_VOY_NO  = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("                             AND SKD_DIR_CD  = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("                             AND CLPT_SEQ < (     SELECT CLPT_SEQ" ).append("\n"); 
		query.append("                                                    FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                                                   WHERE VSL_CD      = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("                                                     AND SKD_VOY_NO  = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("                                                     AND SKD_DIR_CD  = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("                                                     AND VPS_PORT_CD = @[port_cd]" ).append("\n"); 
		query.append("                                                 )" ).append("\n"); 
		query.append("                         )" ).append("\n"); 
		query.append("AND POD_CD        IN  (SELECT VPS_PORT_CD" ).append("\n"); 
		query.append("                            FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                           WHERE VSL_CD      = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("                             AND SKD_VOY_NO  = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("                             AND SKD_DIR_CD  = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("                             AND CLPT_SEQ  > (    SELECT CLPT_SEQ" ).append("\n"); 
		query.append("                                                    FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                                                   WHERE VSL_CD      = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("                                                     AND SKD_VOY_NO  = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("                                                     AND SKD_DIR_CD  = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("                                                     AND VPS_PORT_CD = @[port_cd]" ).append("\n"); 
		query.append("                                                 )" ).append("\n"); 
		query.append("                         )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${ui_type} == 'ESM_BKG_0965')" ).append("\n"); 
		query.append("	AND   (POL_CD = @[port_cd] OR POD_CD = @[port_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--AND   LODG_DCHG_IND_CD = 'L'" ).append("\n"); 
		query.append("AND	  ROWNUM = 1" ).append("\n"); 

	}
}