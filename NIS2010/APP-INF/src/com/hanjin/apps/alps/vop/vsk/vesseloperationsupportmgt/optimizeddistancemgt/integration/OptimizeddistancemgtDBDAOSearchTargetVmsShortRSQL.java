/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : OptimizeddistancemgtDBDAOSearchTargetVmsShortRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.29
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.29 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.optimizeddistancemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OptimizeddistancemgtDBDAOSearchTargetVmsShortRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VMS Short 클릭시 해당 값의 target이 되는 vsk_pasg_pln_rpt의 key정보를 조회한다.
	  * </pre>
	  */
	public OptimizeddistancemgtDBDAOSearchTargetVmsShortRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sheet_fm_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sheet_to_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vms_shtg_dist",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.optimizeddistancemgt.integration").append("\n"); 
		query.append("FileName : OptimizeddistancemgtDBDAOSearchTargetVmsShortRSQL").append("\n"); 
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
		query.append("SELECT    P.VSL_CD" ).append("\n"); 
		query.append("        , P.SKD_VOY_NO" ).append("\n"); 
		query.append("        , P.SKD_DIR_CD" ).append("\n"); 
		query.append("        , TO_CHAR (P.PASG_PLN_DT, 'YYYY-MM-DD HH24:MI') AS PASG_PLN_DT" ).append("\n"); 
		query.append("        , P.DEP_PORT_CD" ).append("\n"); 
		query.append("        , P.ARR_PORT_CD" ).append("\n"); 
		query.append("        , TO_CHAR (V.VPS_ETA_DT, 'YYYY-MM-DD HH24:MI') AS VPS_ETA_DT    " ).append("\n"); 
		query.append("FROM      VSK_PASG_PLN_RPT      P " ).append("\n"); 
		query.append("        , MDM_VSL_CNTR          VC" ).append("\n"); 
		query.append("        , VSK_PORT_OPMZ_DIST    H" ).append("\n"); 
		query.append("        , VSK_VSL_PORT_SKD      V" ).append("\n"); 
		query.append("        ,( SELECT   PS.VSL_CD" ).append("\n"); 
		query.append("                    ,PS.SKD_VOY_NO" ).append("\n"); 
		query.append("                    ,PS.SKD_DIR_CD" ).append("\n"); 
		query.append("                    ,PS.VPS_PORT_CD" ).append("\n"); 
		query.append("                    ,PS.YD_CD" ).append("\n"); 
		query.append("                    ,NVL(YG.YD_GRP_ID ,'All') as YD_GRP_ID" ).append("\n"); 
		query.append("           FROM     VSK_VSL_PORT_SKD PS" ).append("\n"); 
		query.append("                    , VSK_YD_GRP       YG" ).append("\n"); 
		query.append("           WHERE    PS.YD_CD = YG.YD_CD(+) ) FM_PC        " ).append("\n"); 
		query.append("        ,( SELECT   PS.VSL_CD" ).append("\n"); 
		query.append("                    ,PS.SKD_VOY_NO" ).append("\n"); 
		query.append("                    ,PS.SKD_DIR_CD" ).append("\n"); 
		query.append("                    ,PS.VPS_PORT_CD" ).append("\n"); 
		query.append("                    ,PS.YD_CD" ).append("\n"); 
		query.append("                    ,NVL(YG.YD_GRP_ID,'All') as YD_GRP_ID" ).append("\n"); 
		query.append("           FROM     VSK_VSL_PORT_SKD PS" ).append("\n"); 
		query.append("                    , VSK_YD_GRP       YG" ).append("\n"); 
		query.append("          WHERE PS.YD_CD = YG.YD_CD(+) ) TO_PC" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND P.VSL_CD            = VC.VSL_CD" ).append("\n"); 
		query.append("AND P.VSL_CD            = FM_PC.VSL_CD (+)" ).append("\n"); 
		query.append("AND P.SKD_VOY_NO        = FM_PC.SKD_VOY_NO (+)" ).append("\n"); 
		query.append("AND P.SKD_DIR_CD        = FM_PC.SKD_DIR_CD (+)" ).append("\n"); 
		query.append("AND P.DEP_PORT_CD       = FM_PC.VPS_PORT_CD (+)" ).append("\n"); 
		query.append("--AND FM_PC.YD_GRP_ID     = H.FM_YD_GRP_ID" ).append("\n"); 
		query.append("AND P.VSL_CD            = TO_PC.VSL_CD (+)" ).append("\n"); 
		query.append("AND P.SKD_VOY_NO        = TO_PC.SKD_VOY_NO (+)" ).append("\n"); 
		query.append("AND P.SKD_DIR_CD        = TO_PC.SKD_DIR_CD (+)" ).append("\n"); 
		query.append("AND P.ARR_PORT_CD       = TO_PC.VPS_PORT_CD (+)" ).append("\n"); 
		query.append("--AND TO_PC.YD_GRP_ID     = H.TO_YD_GRP_ID" ).append("\n"); 
		query.append("AND P.DEP_PORT_CD       = SUBSTR(H.FM_YD_CD,1,5) " ).append("\n"); 
		query.append("AND P.ARR_PORT_CD       = SUBSTR(H.TO_YD_CD,1,5)" ).append("\n"); 
		query.append("AND P.VSL_CD            = V.VSL_CD (+)     " ).append("\n"); 
		query.append("AND P.SKD_VOY_NO        = V.SKD_VOY_NO (+)  " ).append("\n"); 
		query.append("AND P.SKD_DIR_CD        = V.SKD_DIR_CD (+) " ).append("\n"); 
		query.append("AND P.ARR_PORT_CD       = V.VPS_PORT_CD (+)" ).append("\n"); 
		query.append("AND P.PORT_TO_PORT_MLG_DIST BETWEEN H.RNG_MIN_DIST AND DECODE(H.RNG_MAX_DIST,NULL,99999,0,99999,H.RNG_MAX_DIST)" ).append("\n"); 
		query.append("AND P.PASG_PLN_DT BETWEEN TO_DATE(@[fm_date],'YYYY-MM-DD') AND TO_DATE(@[to_date],'YYYY-MM-DD')+0.99999" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${fm_port_cd} != '')" ).append("\n"); 
		query.append("AND P.DEP_PORT_CD 			= @[fm_port_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${sheet_fm_port_cd} != '')" ).append("\n"); 
		query.append("AND P.DEP_PORT_CD 			= @[sheet_fm_port_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${sheet_to_port_cd} != '')" ).append("\n"); 
		query.append("AND P.ARR_PORT_CD 			= @[sheet_to_port_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vms_shtg_dist} != '')" ).append("\n"); 
		query.append("AND P.PORT_TO_PORT_MLG_DIST = @[vms_shtg_dist]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY P.PASG_PLN_DT DESC" ).append("\n"); 

	}
}