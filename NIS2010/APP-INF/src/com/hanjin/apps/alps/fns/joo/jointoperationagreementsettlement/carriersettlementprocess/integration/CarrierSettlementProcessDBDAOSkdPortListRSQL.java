/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CarrierSettlementProcessDBDAOSkdPortListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.22
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2015.06.22 민정호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Ho Min
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CarrierSettlementProcessDBDAOSkdPortListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 스케줄상의 Port 조회
	  * </pre>
	  */
	public CarrierSettlementProcessDBDAOSkdPortListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration").append("\n"); 
		query.append("FileName : CarrierSettlementProcessDBDAOSkdPortListRSQL").append("\n"); 
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
		query.append("WITH PRE_VVD AS (" ).append("\n"); 
		query.append("--이전 VVD 구하기 " ).append("\n"); 
		query.append("SELECT DISTINCT " ).append("\n"); 
		query.append("   VSL_CD" ).append("\n"); 
		query.append("  ,TURN_SKD_VOY_NO AS SKD_VOY_NO" ).append("\n"); 
		query.append("  ,TURN_SKD_DIR_CD AS SKD_DIR_CD" ).append("\n"); 
		query.append("FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND LEVEL <= FLOOR(TO_NUMBER('3')/2)" ).append("\n"); 
		query.append("AND (TURN_SKD_VOY_NO IS NOT NULL OR TURN_SKD_DIR_CD IS NOT NULL) START WITH VSL_CD = SUBSTR(@[in_vvd_cd],1,4)" ).append("\n"); 
		query.append("AND SKD_VOY_NO = SUBSTR(@[in_vvd_cd],5,4)" ).append("\n"); 
		query.append("AND SKD_DIR_CD = SUBSTR(@[in_vvd_cd],9,1)" ).append("\n"); 
		query.append("AND TURN_PORT_IND_CD IN ('Y','N') CONNECT BY PRIOR TURN_SKD_VOY_NO = SKD_VOY_NO" ).append("\n"); 
		query.append("AND PRIOR TURN_SKD_DIR_CD = SKD_DIR_CD" ).append("\n"); 
		query.append("AND PRIOR VSL_CD = VSL_CD" ).append("\n"); 
		query.append("AND TURN_PORT_IND_CD IN ('Y','N')" ).append("\n"); 
		query.append("AND LEVEL <= FLOOR(TO_NUMBER('3')/2)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", VSL_SKD AS (" ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("	 A.GUBUN" ).append("\n"); 
		query.append("    ,A.CLPT_SEQ" ).append("\n"); 
		query.append("	,A.VPS_PORT_CD" ).append("\n"); 
		query.append("	,A.YD_CD" ).append("\n"); 
		query.append("	,A.TML_CD" ).append("\n"); 
		query.append("    ,A.CLPT_IND_SEQ" ).append("\n"); 
		query.append("    ,A.VPS_ETA_DT" ).append("\n"); 
		query.append("    ,A.VPS_ETB_DT" ).append("\n"); 
		query.append("    ,A.VPS_ETD_DT" ).append("\n"); 
		query.append("    FROM" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("        SELECT  " ).append("\n"); 
		query.append("          DECODE(T1.SKD_DIR_CD,SUBSTR(@[in_vvd_cd],9,1),2,1) AS GUBUN" ).append("\n"); 
		query.append("         ,T2.CLPT_SEQ" ).append("\n"); 
		query.append("         ,T2.VPS_PORT_CD" ).append("\n"); 
		query.append("         ,T2.YD_CD" ).append("\n"); 
		query.append("         ,DECODE(T2.YD_CD, NULL, '', SUBSTR(T2.YD_CD, 6, 2)) AS TML_CD" ).append("\n"); 
		query.append("         ,T2.CLPT_IND_SEQ" ).append("\n"); 
		query.append("         ,T2.VPS_ETA_DT " ).append("\n"); 
		query.append("         ,T2.VPS_ETB_DT " ).append("\n"); 
		query.append("         ,T2.VPS_ETD_DT " ).append("\n"); 
		query.append("        FROM VSK_VSL_SKD T1" ).append("\n"); 
		query.append("           , VSK_VSL_PORT_SKD T2" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("        AND T1.VSL_CD      = T2.VSL_CD" ).append("\n"); 
		query.append("        AND T1.SKD_VOY_NO    = T2.SKD_VOY_NO" ).append("\n"); 
		query.append("        AND T1.SKD_DIR_CD    = T2.SKD_DIR_CD" ).append("\n"); 
		query.append("        AND (" ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                    T1.VSL_CD        = (SELECT VSL_CD FROM PRE_VVD)" ).append("\n"); 
		query.append("                AND T1.SKD_VOY_NO    = (SELECT SKD_VOY_NO FROM PRE_VVD)" ).append("\n"); 
		query.append("                AND T1.SKD_DIR_CD    = (SELECT SKD_DIR_CD FROM PRE_VVD)" ).append("\n"); 
		query.append("                ) " ).append("\n"); 
		query.append("                OR " ).append("\n"); 
		query.append("                (            " ).append("\n"); 
		query.append("                    T1.VSL_CD     = SUBSTR(@[in_vvd_cd],1,4)" ).append("\n"); 
		query.append("                AND T1.SKD_VOY_NO = SUBSTR(@[in_vvd_cd],5,4)" ).append("\n"); 
		query.append("                AND T1.SKD_DIR_CD = SUBSTR(@[in_vvd_cd],9,1)                     " ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("            )                " ).append("\n"); 
		query.append("        AND T2.TURN_PORT_IND_CD NOT IN ('D','V','F')   -- 가상포트 제외" ).append("\n"); 
		query.append("        AND NVL(T2.SKD_CNG_STS_CD, 'A') <>  'S'    " ).append("\n"); 
		query.append("    ) A        " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("     V.CLPT_SEQ" ).append("\n"); 
		query.append("	,V.VPS_PORT_CD" ).append("\n"); 
		query.append("	,V.YD_CD" ).append("\n"); 
		query.append("	,V.TML_CD" ).append("\n"); 
		query.append("    ,V.CLPT_IND_SEQ" ).append("\n"); 
		query.append("    ,TO_CHAR(V.VPS_ETA_DT,'YYYY-MM-DD HH24:MI') AS ETA_DT" ).append("\n"); 
		query.append("    ,TO_CHAR(V.VPS_ETB_DT,'YYYY-MM-DD HH24:MI') AS ETB_DT" ).append("\n"); 
		query.append("    ,TO_CHAR(V.VPS_ETD_DT,'YYYY-MM-DD HH24:MI') AS ETD_DT" ).append("\n"); 
		query.append("FROM VSL_SKD V" ).append("\n"); 
		query.append("WHERE V.GUBUN = '2'" ).append("\n"); 
		query.append("ORDER BY V.GUBUN ASC, V.CLPT_SEQ ASC" ).append("\n"); 

	}
}