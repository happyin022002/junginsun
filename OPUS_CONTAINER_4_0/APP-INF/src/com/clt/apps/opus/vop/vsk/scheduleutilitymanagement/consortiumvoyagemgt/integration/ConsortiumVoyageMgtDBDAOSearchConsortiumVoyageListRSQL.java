/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ConsortiumVoyageMgtDBDAOSearchConsortiumVoyageListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.13
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.13 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.scheduleutilitymanagement.consortiumvoyagemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ConsortiumVoyageMgtDBDAOSearchConsortiumVoyageListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchConsortiumVoyageList
	  * </pre>
	  */
	public ConsortiumVoyageMgtDBDAOSearchConsortiumVoyageListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.scheduleutilitymanagement.consortiumvoyagemgt.integration").append("\n"); 
		query.append("FileName : ConsortiumVoyageMgtDBDAOSearchConsortiumVoyageListRSQL").append("\n"); 
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
		query.append("SELECT  A.SLAN_CD AS VSL_SLAN_CD" ).append("\n"); 
		query.append("	  ,	A.VSL_CD" ).append("\n"); 
		query.append("      ,	A.SKD_VOY_NO" ).append("\n"); 
		query.append("	  ,	A.SKD_DIR_CD" ).append("\n"); 
		query.append("	  ,	A.VPS_PORT_CD" ).append("\n"); 
		query.append("	  , A.CLPT_SEQ" ).append("\n"); 
		query.append("	  , A.TURN_PORT_FLG" ).append("\n"); 
		query.append("	  , A.TURN_SKD_VOY_NO" ).append("\n"); 
		query.append("	  , A.TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("      , A.CSSM_VOY_INIT_CRE_FLG" ).append("\n"); 
		query.append("	  , A.TURN_PORT_IND_CD" ).append("\n"); 
		query.append("	  , A.VT_ADD_CALL_FLG" ).append("\n"); 
		query.append("	  , A.CLPT_IND_SEQ" ).append("\n"); 
		query.append("	  ,(SELECT LISTAGG(SKD_DIR_CD, ':') WITHIN GROUP (ORDER BY MIN(PORT_ROTN_SEQ))" ).append("\n"); 
		query.append("        FROM VSK_PF_SKD_DTL " ).append("\n"); 
		query.append("        WHERE VSL_SLAN_CD  = A.SLAN_CD" ).append("\n"); 
		query.append("        AND PF_SVC_TP_CD = B.PF_SKD_TP_CD " ).append("\n"); 
		query.append("        GROUP BY SKD_DIR_CD) SKD_DIR_CD_ORD" ).append("\n"); 
		query.append("	  ,	TO_CHAR(PF_ETA_DT  , 'YYYY-MM-DD HH24:MI') AS PF_ETA_DT" ).append("\n"); 
		query.append("	  ,	TO_CHAR(PF_ETB_DT  , 'YYYY-MM-DD HH24:MI') AS PF_ETB_DT	 " ).append("\n"); 
		query.append("	  ,	TO_CHAR(PF_ETD_DT  , 'YYYY-MM-DD HH24:MI') AS PF_ETD_DT " ).append("\n"); 
		query.append("	  ,	TO_CHAR(INIT_ETA_DT, 'YYYY-MM-DD HH24:MI') AS INIT_ETA_DT " ).append("\n"); 
		query.append("	  ,	TO_CHAR(INIT_ETB_DT, 'YYYY-MM-DD HH24:MI') AS INIT_ETB_DT " ).append("\n"); 
		query.append("	  ,	TO_CHAR(INIT_ETD_DT, 'YYYY-MM-DD HH24:MI') AS INIT_ETD_DT " ).append("\n"); 
		query.append("	  ,	TO_CHAR(VPS_ETA_DT , 'YYYY-MM-DD HH24:MI') AS VPS_ETA_DT " ).append("\n"); 
		query.append("	  ,	TO_CHAR(VPS_ETB_DT , 'YYYY-MM-DD HH24:MI') AS VPS_ETB_DT" ).append("\n"); 
		query.append("	  ,	TO_CHAR(VPS_ETD_DT , 'YYYY-MM-DD HH24:MI') AS VPS_ETD_DT" ).append("\n"); 
		query.append("	  ,	A.IB_CSSM_VOY_NO IB_CSSM_VOY_NO" ).append("\n"); 
		query.append("	  ,	A.OB_CSSM_VOY_NO OB_CSSM_VOY_NO" ).append("\n"); 
		query.append("	  ,	A.UPD_USR_ID     UPD_USR_ID" ).append("\n"); 
		query.append("	  ,	TO_CHAR(A.UPD_DT,'YYYYMMDDHH24MISS')         UPD_DT" ).append("\n"); 
		query.append("	  , CASE WHEN A.TURN_PORT_IND_CD IN ('D','V','F') THEN 'V' " ).append("\n"); 
		query.append("			 WHEN A.CLPT_SEQ = '1' AND A.TURN_PORT_FLG = 'Y' THEN 'Y' " ).append("\n"); 
		query.append("        ELSE A.TURN_PORT_IND_CD" ).append("\n"); 
		query.append("        END REAL_TURN_PORT_IND_CD -- P/F 상 첫번째 Port의 TURN_PORT_IND 를 'Y'로 표시하기 위한 조건 " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	,	CASE 	WHEN A.TURN_PORT_IND_CD IN ('Y','N') THEN NULL" ).append("\n"); 
		query.append("            	ELSE RANK() OVER (PARTITION BY A.VSL_CD,A.SKD_VOY_NO,A.SKD_DIR_CD ORDER BY DECODE(A.TURN_PORT_IND_CD,'F',1,'D',2,'V',2,9) ASC, A.VPS_ETB_DT ASC) " ).append("\n"); 
		query.append("       	END  	VIR_PORT_CLPT_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       , CASE   WHEN A.TURN_PORT_IND_CD IN ('Y','N') THEN" ).append("\n"); 
		query.append("                (SELECT		MIN(PS.CLPT_SEQ)" ).append("\n"); 
		query.append("              	FROM      	VSK_VSL_PORT_SKD      PS" ).append("\n"); 
		query.append("              	WHERE     	PS.VSL_CD             = A.VSL_CD" ).append("\n"); 
		query.append("              	AND       	PS.SKD_VOY_NO         = A.SKD_VOY_NO" ).append("\n"); 
		query.append("              	AND       	PS.SKD_DIR_CD         = A.SKD_DIR_CD" ).append("\n"); 
		query.append("              	AND       	PS.TURN_SKD_VOY_NO    IS NOT NULL" ).append("\n"); 
		query.append("              	AND       	PS.TURN_PORT_IND_CD   IN ('Y','N')" ).append("\n"); 
		query.append("              	)" ).append("\n"); 
		query.append("              	ELSE NULL" ).append("\n"); 
		query.append("        END 	FIRST_TURN_PORT_CLPT_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       , CASE	WHEN A.TURN_PORT_IND_CD IN ('Y','N') AND A.TURN_SKD_VOY_NO IS NOT NULL THEN ROW_NUMBER() OVER (PARTITION BY A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD ORDER BY DECODE(A.TURN_SKD_VOY_NO,NULL,9,1) ASC, A.CLPT_SEQ ASC)" ).append("\n"); 
		query.append("				ELSE NULL" ).append("\n"); 
		query.append("		END		REAL_CLPT_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   FROM VSK_VSL_PORT_SKD 	A" ).append("\n"); 
		query.append("      , VSK_VSL_SKD 		B" ).append("\n"); 
		query.append("  WHERE 1 = 1" ).append("\n"); 
		query.append("    #if (${vsl_slan_cd} != '') " ).append("\n"); 
		query.append("    AND A.SLAN_CD      			= @[vsl_slan_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    --::2015-05-15:by TOP::--AND A.CLPT_IND_SEQ 			= 1" ).append("\n"); 
		query.append("	AND A.VSL_CD       			= B.VSL_CD" ).append("\n"); 
		query.append("    AND A.SKD_VOY_NO   			= B.SKD_VOY_NO" ).append("\n"); 
		query.append("	AND	A.SKD_DIR_CD   			= B.SKD_DIR_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    --AND B.SKD_DIR_CD 			= XX.SKD_DIR_CD" ).append("\n"); 
		query.append("    --AND B.PF_SKD_TP_CD 		= XX.PF_SVC_TP_CD" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if(${vsl_cd} == '' || ${skd_voy_no} == '')  " ).append("\n"); 
		query.append("      #if (${fm_dt} != '')       " ).append("\n"); 
		query.append("      AND EXISTS (SELECT 1 FROM VSK_VSL_PORT_SKD SKD" ).append("\n"); 
		query.append("                   WHERE SKD.VPS_ETB_DT BETWEEN TO_DATE(REPLACE(@[fm_dt], '-', ''), 'YYYYMMDD') AND TO_DATE(REPLACE(@[to_dt], '-', ''), 'YYYYMMDD')" ).append("\n"); 
		query.append("                   -- AND CLPT_SEQ    = 1" ).append("\n"); 
		query.append("                    AND VSL_CD      = A.VSL_CD" ).append("\n"); 
		query.append("                    AND SKD_VOY_NO  = A.SKD_VOY_NO" ).append("\n"); 
		query.append("                    AND SKD_DIR_CD  = A.SKD_DIR_CD" ).append("\n"); 
		query.append("                 )" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#if(${cv_cbm2} == '1')" ).append("\n"); 
		query.append("AND " ).append("\n"); 
		query.append("	A.CSSM_VOY_INIT_CRE_FLG ='Y'" ).append("\n"); 
		query.append("#elseif(${cv_cbm2} == '2')" ).append("\n"); 
		query.append("AND" ).append("\n"); 
		query.append("	A.CSSM_VOY_INIT_CRE_FLG ='N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	#if (${vsl_cd} != '') " ).append("\n"); 
		query.append("	AND A.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${skd_voy_no} != '') " ).append("\n"); 
		query.append("	AND A.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${skd_dir_cd} != '') " ).append("\n"); 
		query.append("	AND A.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    #if (${chk_virtual_port} == '')" ).append("\n"); 
		query.append("    AND TURN_PORT_IND_CD NOT IN ('D','V','F')" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  ORDER BY 		SLAN_CD" ).append("\n"); 
		query.append("	     	, 	VSL_CD" ).append("\n"); 
		query.append("         	, 	SKD_VOY_NO" ).append("\n"); 
		query.append("	     	, DECODE(SKD_DIR_CD, SUBSTR(SKD_DIR_CD_ORD, 1, 1), 1, SUBSTR(SKD_DIR_CD_ORD, 3, 1), 2, 3)" ).append("\n"); 
		query.append("			--,	PORT_ORD_SEQ" ).append("\n"); 
		query.append("         	, 	CLPT_SEQ" ).append("\n"); 
		query.append("         	, 	VPS_ETA_DT" ).append("\n"); 

	}
}