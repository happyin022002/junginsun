/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SpecialManifestDBDAOsearchSSRNoRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2011.01.10
*@LastModifier :
*@LastVersion : 1.0
* 2011.01.10
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialManifestDBDAOsearchSSRNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * ANRBS에서 SVC_RQST_NO를 조회함(Declaration : Discharging인 것만 DEP_LOC_CD = Port_cd)
	  * </pre>
	  */
	public SpecialManifestDBDAOsearchSSRNoRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.integration").append("\n");
		query.append("FileName : SpecialManifestDBDAOsearchSSRNoRSQL").append("\n");
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
		query.append("SELECT" ).append("\n");
		query.append("      CASE" ).append("\n");
		query.append("        WHEN SUBSTR(@[ofc_cd], 1, 3) = 'ANR' " ).append("\n");
		query.append("            THEN (" ).append("\n");
		query.append("                    SELECT" ).append("\n");
		query.append("                        SVC_RQST_NO" ).append("\n");
		query.append("                    FROM BKG_CSTMS_ANR_VVD" ).append("\n");
		query.append("                    WHERE VSL_CD      = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n");
		query.append("                    AND   SKD_VOY_NO  = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n");
		query.append("                    AND   SKD_DIR_CD  = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n");
		query.append("                )" ).append("\n");
		query.append("" ).append("\n");
		query.append("		WHEN SUBSTR(@[ofc_cd], 1, 3) = 'FXT' " ).append("\n");
		query.append("         	 THEN (" ).append("\n");
		query.append("                                        " ).append("\n");
		query.append("                SELECT UQ_VSL_ID_NO" ).append("\n");
		query.append("                FROM BKG_VSL_DCHG_YD" ).append("\n");
		query.append("                WHERE VSL_CD              =  SUBSTR(@[vvd_cd], 1, 4)" ).append("\n");
		query.append("                AND   SKD_VOY_NO          =  SUBSTR(@[vvd_cd], 5, 4)" ).append("\n");
		query.append("                AND   SKD_DIR_CD          =  SUBSTR(@[vvd_cd], 9, 1)" ).append("\n");
		query.append("                AND   PORT_CD             =  @[port_cd]" ).append("\n");
		query.append("                AND   CLPT_IND_SEQ 		  =  '1'                        " ).append("\n");
		query.append("            )" ).append("\n");
		query.append("		WHEN NVL(@[port_cd],'X') = 'FRFOS'  " ).append("\n");
		query.append("         	 THEN (" ).append("\n");
		query.append("                                        " ).append("\n");
		query.append("                SELECT UQ_VSL_ID_NO" ).append("\n");
		query.append("                FROM BKG_VSL_DCHG_YD" ).append("\n");
		query.append("                WHERE VSL_CD              =  SUBSTR(@[vvd_cd], 1, 4)" ).append("\n");
		query.append("                AND   SKD_VOY_NO          =  SUBSTR(@[vvd_cd], 5, 4)" ).append("\n");
		query.append("                AND   SKD_DIR_CD          =  SUBSTR(@[vvd_cd], 9, 1)" ).append("\n");
		query.append("                AND   PORT_CD             =  @[port_cd]" ).append("\n");
		query.append("                AND   CLPT_IND_SEQ 		  =  '1'                        " ).append("\n");
		query.append("            )" ).append("\n");
		query.append("		WHEN NVL(@[port_cd],'X') = 'NLRTM' " ).append("\n");
		query.append("			 THEN (" ).append("\n");
		query.append("             SELECT MAX(NVL(VSL_CALL_REF_NO,''))" ).append("\n");
		query.append("               FROM BKG_CSTMS_RTM_VSL" ).append("\n");
		query.append("              WHERE VSL_CD = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n");
		query.append("                AND SKD_VOY_NO = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n");
		query.append("                AND SKD_DIR_CD = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n");
		query.append("                AND VSL_CALL_REF_NO LIKE 'NLRTM%'" ).append("\n");
		query.append("			)" ).append("\n");
		query.append("		ELSE ''" ).append("\n");
		query.append("      END SVC_RQST_NO" ).append("\n");
		query.append("FROM DUAL" ).append("\n");

	}
}