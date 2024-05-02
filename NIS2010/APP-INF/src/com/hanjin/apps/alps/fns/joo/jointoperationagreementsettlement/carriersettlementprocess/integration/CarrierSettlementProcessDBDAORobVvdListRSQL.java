/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CarrierSettlementProcessDBDAORobVvdListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.12
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2015.05.12 민정호
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

public class CarrierSettlementProcessDBDAORobVvdListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ROB 컨테이너 조회시 ETD기준 VVD List를 조회
	  * </pre>
	  */
	public CarrierSettlementProcessDBDAORobVvdListRSQL(){
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
		params.put("pre_fr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pre_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration").append("\n"); 
		query.append("FileName : CarrierSettlementProcessDBDAORobVvdListRSQL").append("\n"); 
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
		query.append(" ROWNUM AS SEQ_NO" ).append("\n"); 
		query.append(",AAAA.*" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("    AAA.*" ).append("\n"); 
		query.append("    FROM" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append(" MIN(AA.VVD || AA.VPS_ETD_DT) OVER (PARTITION BY AA.VVD) AS VVD_ETD_GROUP         " ).append("\n"); 
		query.append(",AA.VVD" ).append("\n"); 
		query.append(",AA.VSL_CD" ).append("\n"); 
		query.append(",AA.SKD_VOY_NO" ).append("\n"); 
		query.append(",AA.SKD_DIR_CD  " ).append("\n"); 
		query.append(",AA.VPS_PORT_CD" ).append("\n"); 
		query.append(",AA.TML_CD" ).append("\n"); 
		query.append(",AA.SPLIT_NO" ).append("\n"); 
		query.append(",AA.CLPT_SEQ" ).append("\n"); 
		query.append(",AA.VPS_ETD_DT" ).append("\n"); 
		query.append(",CASE WHEN V.RDR_FLG = 'Y' THEN 'R'" ).append("\n"); 
		query.append("      WHEN V.RDR_FLG = 'N' THEN ''" ).append("\n"); 
		query.append("      ELSE DECODE(AA.VPS_PORT_CD,H.PORT_CD,'R','')" ).append("\n"); 
		query.append("      END AS RDR_FLG" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("		SELECT " ).append("\n"); 
		query.append("             (K.VSL_CD || K.SKD_VOY_NO || K.SKD_DIR_CD) AS VVD" ).append("\n"); 
		query.append("            ,K.VSL_CD" ).append("\n"); 
		query.append("            ,K.SKD_VOY_NO" ).append("\n"); 
		query.append("            ,K.SKD_DIR_CD       " ).append("\n"); 
		query.append("            ,SUBSTR(K.YD_CD,1,5) 	AS VPS_PORT_CD" ).append("\n"); 
		query.append("            ,SUBSTR(K.YD_CD,6,2) 	AS TML_CD" ).append("\n"); 
		query.append("            ,K.CLPT_IND_SEQ 		AS SPLIT_NO " ).append("\n"); 
		query.append("			,TO_CHAR(K.VPS_ETD_DT,'YYYYMMDDHH24MISS') AS VPS_ETD_DT" ).append("\n"); 
		query.append("            ,K.CLPT_SEQ" ).append("\n"); 
		query.append("            ,K.SLAN_CD            " ).append("\n"); 
		query.append("            ,K.YD_CD " ).append("\n"); 
		query.append("        FROM VSK_VSL_PORT_SKD K" ).append("\n"); 
		query.append("        WHERE 1=1   " ).append("\n"); 
		query.append("        AND ( (K.VPS_ETD_DT BETWEEN TO_DATE (REPLACE (@[pre_fr],'-',''), 'YYYYMMDD')" ).append("\n"); 
		query.append("                                AND TO_DATE (REPLACE (@[pre_to],'-',''), 'YYYYMMDD') + 0.99999) " ).append("\n"); 
		query.append("             OR K.VPS_ETD_DT IS NULL" ).append("\n"); 
		query.append("            )             " ).append("\n"); 
		query.append("       	AND K.SLAN_CD LIKE @[rlane_cd] || '%'    " ).append("\n"); 
		query.append("		#if (${vvd} != '') " ).append("\n"); 
		query.append("		AND K.VSL_CD || K.SKD_VOY_NO || K.SKD_DIR_CD LIKE @[vvd] || '%' " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${skd_dir_cd} != '') " ).append("\n"); 
		query.append("		AND K.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("        AND K.TURN_PORT_IND_CD NOT IN ('D','V','F')" ).append("\n"); 
		query.append("        AND NVL(K.SKD_CNG_STS_CD, 'A') <>  'S'  " ).append("\n"); 
		query.append("        ORDER BY VVD ASC, CLPT_SEQ ASC" ).append("\n"); 
		query.append(") AA, RDR_HEADER H, JOO_RDR_PORT V" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND AA.VSL_CD 		= H.VSL_CD(+)" ).append("\n"); 
		query.append("AND AA.SKD_VOY_NO 	= H.VOY_NO(+)" ).append("\n"); 
		query.append("AND AA.SKD_DIR_CD 	= H.DIR_CD(+)  " ).append("\n"); 
		query.append("AND AA.VPS_PORT_CD 	= H.PORT_CD(+)" ).append("\n"); 
		query.append("AND AA.VSL_CD       = V.VSL_CD(+)" ).append("\n"); 
		query.append("AND AA.SKD_VOY_NO   = V.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("AND AA.SKD_DIR_CD   = V.SKD_DIR_CD(+)  " ).append("\n"); 
		query.append("AND AA.VPS_PORT_CD  = V.VPS_PORT_CD(+)  " ).append("\n"); 
		query.append("AND AA.SPLIT_NO     = V.CLPT_IND_SEQ(+)" ).append("\n"); 
		query.append("AND AA.SLAN_CD      = V.SLAN_CD(+)" ).append("\n"); 
		query.append("AND AA.YD_CD        = V.YD_CD(+)" ).append("\n"); 
		query.append("#if (${rdr_flg} == 'R') " ).append("\n"); 
		query.append("AND DECODE(AA.VPS_PORT_CD,H.PORT_CD,'R','') = 'R'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    ) AAA" ).append("\n"); 
		query.append("    ORDER BY SUBSTR(VVD_ETD_GROUP, 10), VVD, VPS_ETD_DT, VPS_PORT_CD" ).append("\n"); 
		query.append(") AAAA" ).append("\n"); 

	}
}