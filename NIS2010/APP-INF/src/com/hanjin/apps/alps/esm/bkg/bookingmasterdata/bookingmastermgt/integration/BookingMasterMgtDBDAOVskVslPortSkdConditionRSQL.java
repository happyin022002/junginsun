/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BookingMasterMgtDBDAOVskVslPortSkdConditionRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.24
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingMasterMgtDBDAOVskVslPortSkdConditionRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Vessel code 및 SKD 조회 화면(UI_BKG-0019) Vessel SKD & Code Inquiry
	  * </pre>
	  */
	public BookingMasterMgtDBDAOVskVslPortSkdConditionRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_eng_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_port_pol",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pf_etd_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pf_etd_from_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pf_etb_from_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_port_pod",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pf_etb_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.integration").append("\n"); 
		query.append("FileName : BookingMasterMgtDBDAOVskVslPortSkdConditionRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("/* 2014.11.03 추가 */" ).append("\n"); 
		query.append("( SELECT	VSL_ENG_NM FROM MDM_VSL_CNTR WHERE VSL_CD = SUBSTR(YY.VVD,1,4) AND DELT_FLG = 'N' ) AS VSL_ENG_NM" ).append("\n"); 
		query.append(",YY.*" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vsl_cd} != '')" ).append("\n"); 
		query.append("------------------------------------------------------------------------" ).append("\n"); 
		query.append("--1.VVD 입력시" ).append("\n"); 
		query.append("------------------------------------------------------------------------" ).append("\n"); 
		query.append("SELECT         VVD" ).append("\n"); 
		query.append("                , LANE" ).append("\n"); 
		query.append("                , POL" ).append("\n"); 
		query.append("                , CLPT_IND_SEQ" ).append("\n"); 
		query.append("                , CLPT_SEQ" ).append("\n"); 
		query.append("                , TERMINAL" ).append("\n"); 
		query.append("	            , CCT" ).append("\n"); 
		query.append("                , TO_CHAR(CCT,'YYYY-MM-DD HH24:MI') CCT_DT" ).append("\n"); 
		query.append("                , TO_CHAR(CCT,'HH24:MI') CCT_TM" ).append("\n"); 
		query.append("                , ETB" ).append("\n"); 
		query.append("                , ETB_DT" ).append("\n"); 
		query.append("                , ETB_TM" ).append("\n"); 
		query.append("                , ETD" ).append("\n"); 
		query.append("                , ETD_DT" ).append("\n"); 
		query.append("                , ETD_TM" ).append("\n"); 
		query.append("			    , T_TIME" ).append("\n"); 
		query.append("                , POD" ).append("\n"); 
		query.append("                , POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append("                , POD_CLPT_SEQ" ).append("\n"); 
		query.append("                , TERMINAL2" ).append("\n"); 
		query.append("                , ETB2" ).append("\n"); 
		query.append("                , ETB2_DT" ).append("\n"); 
		query.append("                , ETB2_TM" ).append("\n"); 
		query.append("                , VPS_RMK" ).append("\n"); 
		query.append("                , UPD_DT" ).append("\n"); 
		query.append("                , UPD_TM" ).append("\n"); 
		query.append("                , SLAN_CD" ).append("\n"); 
		query.append("                , VSL_CD" ).append("\n"); 
		query.append("                , SKD_VOY_NO" ).append("\n"); 
		query.append("                , SKD_DIR_CD" ).append("\n"); 
		query.append("                ,'' VPS_PORT_POL" ).append("\n"); 
		query.append("                ,'' PF_ETD_FROM_DT" ).append("\n"); 
		query.append("                ,'' PF_ETD_TO_DT" ).append("\n"); 
		query.append("                ,'' PF_ETB_FROM_DT" ).append("\n"); 
		query.append("                ,'' PF_ETB_TO_DT" ).append("\n"); 
		query.append("                ,'' VPS_PORT_POD" ).append("\n"); 
		query.append("				,'' OLD_TICK" ).append("\n"); 
		query.append("                , (SELECT CRR_CD FROM MDM_VSL_CNTR MVSL WHERE MVSL.VSL_CD = X.VSL_CD AND DELT_FLG = 'N') CRR_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	FROM (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		SELECT SKD1.VSL_CD || SKD1.SKD_VOY_NO || SKD1.SKD_DIR_CD VVD" ).append("\n"); 
		query.append("                ,VS.VSL_SLAN_CD LANE" ).append("\n"); 
		query.append("                ,SKD1.VPS_PORT_CD POL" ).append("\n"); 
		query.append("				,SKD1.CLPT_IND_SEQ" ).append("\n"); 
		query.append("				,SKD1.CLPT_SEQ" ).append("\n"); 
		query.append("                ,SKD1.YD_CD TERMINAL" ).append("\n"); 
		query.append("                ,NVL(PRD_GET_CCT_FNC(SKD1.Yd_Cd,SKD1.Slan_Cd,SKD1.SKD_DIR_CD, 'F', SKD1.VPS_ETB_DT, SKD1.VPS_ETD_DT, SKD1.VSL_CD||SKD1.SKD_VOY_NO||SKD1.SKD_DIR_CD ) , SKD1.VPS_ETB_DT -10/24)  CCT" ).append("\n"); 
		query.append("			--	,TO_CHAR(NVL(PRD_GET_CCT_FNC(SKD1.Yd_Cd,SKD1.Slan_Cd,SKD1.SKD_DIR_CD, 'F', SKD1.VPS_ETB_DT, SKD1.VPS_ETD_DT, SKD1.VSL_CD||SKD1.SKD_VOY_NO||SKD1.SKD_DIR_CD ) , SKD1.VPS_ETB_DT -10/24), 'YYYY-MM-DD HH24:MI')  CCT_DT" ).append("\n"); 
		query.append("			--	,TO_CHAR(NVL(PRD_GET_CCT_FNC(SKD1.Yd_Cd,SKD1.Slan_Cd,SKD1.SKD_DIR_CD, 'F', SKD1.VPS_ETB_DT, SKD1.VPS_ETD_DT, SKD1.VSL_CD||SKD1.SKD_VOY_NO||SKD1.SKD_DIR_CD ) , SKD1.VPS_ETB_DT -10/24), 'HH24:MI')  CCT_TM" ).append("\n"); 
		query.append("				,TO_CHAR(SKD1.VPS_ETB_DT, 'YYYY-MM-DD HH24:MI') ETB  " ).append("\n"); 
		query.append("                ,TO_CHAR(SKD1.VPS_ETB_DT, 'YYYY-MM-DD') ETB_DT  " ).append("\n"); 
		query.append("                ,TO_CHAR(SKD1.VPS_ETB_DT, 'HH24:MI') ETB_TM  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                ,TO_CHAR(SKD1.VPS_ETD_DT, 'YYYY-MM-DD HH24:MI') ETD  " ).append("\n"); 
		query.append("                ,TO_CHAR(SKD1.VPS_ETD_DT, 'YYYY-MM-DD') ETD_DT  " ).append("\n"); 
		query.append("                ,TO_CHAR(SKD1.VPS_ETD_DT, 'HH24:MI') ETD_TM  " ).append("\n"); 
		query.append("                ,TRUNC(TO_DATE(TO_CHAR(SKD2.VPS_ETB_DT, 'YYYYMMDD'), 'YYYYMMDD') - TO_DATE(TO_CHAR(SKD1.VPS_ETD_DT, 'YYYYMMDD'), 'YYYYMMDD')) T_TIME" ).append("\n"); 
		query.append("				" ).append("\n"); 
		query.append("                ,SKD2.VPS_PORT_CD POD" ).append("\n"); 
		query.append("				,SKD2.CLPT_IND_SEQ AS POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append("				,SKD2.CLPT_SEQ AS POD_CLPT_SEQ" ).append("\n"); 
		query.append("				,SKD2.YD_CD TERMINAL2" ).append("\n"); 
		query.append("                ,TO_CHAR(SKD2.VPS_ETB_DT, 'YYYY-MM-DD HH24:MI') ETB2" ).append("\n"); 
		query.append("                ,TO_CHAR(SKD2.VPS_ETB_DT, 'YYYY-MM-DD HH24:MI') ETB2_DT" ).append("\n"); 
		query.append("                ,TO_CHAR(SKD2.VPS_ETB_DT, 'HH24:MI') ETB2_TM" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                ,VS.SKD_RMK || replace(SKD1.VPS_RMK, chr(13)||chr(10), ' ')  VPS_RMK" ).append("\n"); 
		query.append("                ,TO_CHAR(SKD1.UPD_DT, 'YYYY-MM-DD') UPD_DT" ).append("\n"); 
		query.append("                ,TO_CHAR(SKD1.UPD_DT, 'HH24:MI') UPD_TM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                ,SKD1.SLAN_CD" ).append("\n"); 
		query.append("                ,SKD1.VSL_CD" ).append("\n"); 
		query.append("                ,SKD1.SKD_VOY_NO" ).append("\n"); 
		query.append("                ,SKD1.SKD_DIR_CD" ).append("\n"); 
		query.append("                ,'' VPS_PORT_POL" ).append("\n"); 
		query.append("                ,'' PF_ETD_FROM_DT" ).append("\n"); 
		query.append("                ,'' PF_ETD_TO_DT" ).append("\n"); 
		query.append("                ,'' PF_ETB_FROM_DT" ).append("\n"); 
		query.append("                ,'' PF_ETB_TO_DT" ).append("\n"); 
		query.append("                ,'' VPS_PORT_POD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          FROM   VSK_VSL_PORT_SKD SKD1, VSK_VSL_PORT_SKD SKD2, VSK_VSL_SKD VS" ).append("\n"); 
		query.append("          WHERE  1=1" ).append("\n"); 
		query.append("	   --   AND    VS.SKD_STS_CD !='CLO'  " ).append("\n"); 
		query.append("#if (${vsl_cd} != '')" ).append("\n"); 
		query.append("          AND    VS.VSL_CD      LIKE SUBSTR(@[vsl_cd],1,4) || '%'" ).append("\n"); 
		query.append("          AND    VS.SKD_VOY_NO  LIKE SUBSTR(@[vsl_cd],5,4) || '%'" ).append("\n"); 
		query.append("          AND    VS.SKD_DIR_CD  LIKE SUBSTR(@[vsl_cd],9,1) || '%'" ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pf_etd_from_dt} != '') " ).append("\n"); 
		query.append("AND  SKD1.VPS_ETD_DT >= TO_DATE(@[pf_etd_from_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pf_etd_to_dt} != '') " ).append("\n"); 
		query.append("AND  SKD1.VPS_ETD_DT <= TO_DATE(@[pf_etd_to_dt], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pf_etb_from_dt} != '') " ).append("\n"); 
		query.append("AND  SKD2.VPS_ETB_DT >= TO_DATE(@[pf_etb_from_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pf_etb_to_dt} != '') " ).append("\n"); 
		query.append("AND  SKD2.VPS_ETB_DT <= TO_DATE(@[pf_etb_to_dt], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${slan_cd} != '') " ).append("\n"); 
		query.append("  		  AND    VS.VSL_SLAN_CD IN( ${slan_cd} )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	      AND    VS.VSL_CD = SKD1.VSL_CD " ).append("\n"); 
		query.append("          AND    VS.SKD_VOY_NO = SKD1.SKD_VOY_NO " ).append("\n"); 
		query.append("          AND    VS.SKD_DIR_CD = SKD1.SKD_DIR_CD " ).append("\n"); 
		query.append("          AND    NVL(SKD1.SKD_CNG_STS_CD, ' ') <> 'S' " ).append("\n"); 
		query.append("#if (${vps_port_pol} != '') " ).append("\n"); 
		query.append(" 		  AND    SKD1.VPS_PORT_CD = @[vps_port_pol]		  " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("		  AND    SKD1.TURN_PORT_IND_CD IN ('Y','N')" ).append("\n"); 
		query.append("          AND    SKD1.VSL_CD = SKD2.VSL_CD " ).append("\n"); 
		query.append("          AND    SKD1.SKD_VOY_NO = SKD2.SKD_VOY_NO " ).append("\n"); 
		query.append("          AND    SKD1.SKD_DIR_CD = SKD2.SKD_DIR_CD " ).append("\n"); 
		query.append("          AND    SKD1.CLPT_SEQ < SKD2.CLPT_SEQ " ).append("\n"); 
		query.append("          AND    NVL(SKD2.SKD_CNG_STS_CD, ' ') <> 'S' " ).append("\n"); 
		query.append("#if (${vps_port_pod} != '') " ).append("\n"); 
		query.append("   		  AND   SKD2.VPS_PORT_CD = @[vps_port_pod]" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vsl_eng_nm} != '') " ).append("\n"); 
		query.append("          AND   EXISTS ( SELECT 'Y' " ).append("\n"); 
		query.append("                           FROM MDM_VSL_CNTR MVSL" ).append("\n"); 
		query.append("                          WHERE 1=1" ).append("\n"); 
		query.append("                            AND MVSL.VSL_CD = VS.VSL_CD" ).append("\n"); 
		query.append("                            AND MVSL.VSL_ENG_NM LIKE UPPER(@[vsl_eng_nm]) || '%'" ).append("\n"); 
		query.append("                            AND MVSL.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          ORDER  BY SKD1.VSL_CD, SKD1.SKD_VOY_NO, SKD1.SKD_DIR_CD, SKD1.CLPT_SEQ, SKD2.CLPT_SEQ" ).append("\n"); 
		query.append(" ) X" ).append("\n"); 
		query.append("#elseif (${vps_port_pol} != '' && ${vps_port_pod} != ''  ) " ).append("\n"); 
		query.append("------------------------------------------------------------------------" ).append("\n"); 
		query.append("--2.POL,POD입력시" ).append("\n"); 
		query.append("------------------------------------------------------------------------" ).append("\n"); 
		query.append("		 SELECT" ).append("\n"); 
		query.append("                 VVD" ).append("\n"); 
		query.append("		        ,LANE" ).append("\n"); 
		query.append("		        ,POL" ).append("\n"); 
		query.append("		        ,CLPT_IND_SEQ" ).append("\n"); 
		query.append("		        ,CLPT_SEQ" ).append("\n"); 
		query.append("		        ,TERMINAL" ).append("\n"); 
		query.append("		        ,CCT" ).append("\n"); 
		query.append("                ,TO_CHAR(CCT,'YYYY-MM-DD HH24:MI') CCT_DT" ).append("\n"); 
		query.append("                ,TO_CHAR(CCT,'HH24:MI') CCT_TM" ).append("\n"); 
		query.append("                , ETB" ).append("\n"); 
		query.append("                , ETB_DT" ).append("\n"); 
		query.append("                , ETB_TM" ).append("\n"); 
		query.append("                , ETD" ).append("\n"); 
		query.append("                , ETD_DT" ).append("\n"); 
		query.append("                , ETD_TM" ).append("\n"); 
		query.append("			    , T_TIME" ).append("\n"); 
		query.append("                , POD" ).append("\n"); 
		query.append("                , POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append("                , POD_CLPT_SEQ" ).append("\n"); 
		query.append("                , TERMINAL2" ).append("\n"); 
		query.append("                , ETB2" ).append("\n"); 
		query.append("                , ETB2_DT" ).append("\n"); 
		query.append("                , ETB2_TM" ).append("\n"); 
		query.append("                , VPS_RMK" ).append("\n"); 
		query.append("                , UPD_DT" ).append("\n"); 
		query.append("                , UPD_TM" ).append("\n"); 
		query.append("                ,SLAN_CD" ).append("\n"); 
		query.append("                ,VSL_CD" ).append("\n"); 
		query.append("                ,SKD_VOY_NO" ).append("\n"); 
		query.append("                ,SKD_DIR_CD" ).append("\n"); 
		query.append("                ,'' VPS_PORT_POL" ).append("\n"); 
		query.append("                ,'' PF_ETD_FROM_DT" ).append("\n"); 
		query.append("                ,'' PF_ETD_TO_DT" ).append("\n"); 
		query.append("                ,'' PF_ETB_FROM_DT" ).append("\n"); 
		query.append("                ,'' PF_ETB_TO_DT" ).append("\n"); 
		query.append("                ,'' VPS_PORT_POD" ).append("\n"); 
		query.append("				,'' OLD_TICK" ).append("\n"); 
		query.append("                , (SELECT CRR_CD FROM MDM_VSL_CNTR MVSL WHERE MVSL.VSL_CD = X.VSL_CD AND DELT_FLG = 'N') CRR_CD" ).append("\n"); 
		query.append("         FROM(" ).append("\n"); 
		query.append("          SELECT	/*+ use_nl(skd1 skd2) */ /* @@ 힌트적용  2014.11.24 튜닝 */" ).append("\n"); 
		query.append("				SKD1.VSL_CD || SKD1.SKD_VOY_NO || SKD1.SKD_DIR_CD VVD" ).append("\n"); 
		query.append("                ,VS.VSL_SLAN_CD LANE" ).append("\n"); 
		query.append("                ,SKD1.VPS_PORT_CD POL" ).append("\n"); 
		query.append("				,SKD1.CLPT_IND_SEQ" ).append("\n"); 
		query.append("				,SKD1.CLPT_SEQ" ).append("\n"); 
		query.append("  				,SKD1.YD_CD TERMINAL" ).append("\n"); 
		query.append("                 /* 2014.11.24 튜닝 */" ).append("\n"); 
		query.append("                ,NVL((select PRD_GET_CCT_FNC(SKD1.Yd_Cd,SKD1.Slan_Cd,SKD1.SKD_DIR_CD, 'F', SKD1.VPS_ETB_DT, SKD1.VPS_ETD_DT, SKD1.VSL_CD||SKD1.SKD_VOY_NO||SKD1.SKD_DIR_CD ) from dual) , SKD1.VPS_ETB_DT -10/24)  CCT /* @@ 힌트적용  2014.11.24 튜닝 */" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                ,TO_CHAR(SKD1.VPS_ETB_DT, 'YYYY-MM-DD HH24:MI') ETB  " ).append("\n"); 
		query.append("                ,TO_CHAR(SKD1.VPS_ETB_DT, 'YYYY-MM-DD') ETB_DT  " ).append("\n"); 
		query.append("                ,TO_CHAR(SKD1.VPS_ETB_DT, 'HH24:MI') ETB_TM  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                ,TO_CHAR(SKD1.VPS_ETD_DT, 'YYYY-MM-DD HH24:MI') ETD  " ).append("\n"); 
		query.append("                ,TO_CHAR(SKD1.VPS_ETD_DT, 'YYYY-MM-DD') ETD_DT  " ).append("\n"); 
		query.append("                ,TO_CHAR(SKD1.VPS_ETD_DT, 'HH24:MI') ETD_TM  " ).append("\n"); 
		query.append("                ,TRUNC(TO_DATE(TO_CHAR(SKD2.VPS_ETB_DT, 'YYYYMMDD'), 'YYYYMMDD') - TO_DATE(TO_CHAR(SKD1.VPS_ETD_DT, 'YYYYMMDD'), 'YYYYMMDD')) T_TIME" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                ,SKD2.VPS_PORT_CD POD" ).append("\n"); 
		query.append("			    ,SKD2.CLPT_IND_SEQ AS POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append("				,SKD2.CLPT_SEQ AS POD_CLPT_SEQ" ).append("\n"); 
		query.append("				,SKD2.YD_CD TERMINAL2" ).append("\n"); 
		query.append("                ,TO_CHAR(SKD2.VPS_ETB_DT, 'YYYY-MM-DD HH24:MI') ETB2" ).append("\n"); 
		query.append("                ,TO_CHAR(SKD2.VPS_ETB_DT, 'YYYY-MM-DD HH24:MI') ETB2_DT" ).append("\n"); 
		query.append("                ,TO_CHAR(SKD2.VPS_ETB_DT, 'HH24:MI') ETB2_TM" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                ,VS.SKD_RMK || replace(SKD1.VPS_RMK, chr(13)||chr(10), ' ')  VPS_RMK" ).append("\n"); 
		query.append("                ,TO_CHAR(SKD1.UPD_DT, 'YYYY-MM-DD') UPD_DT" ).append("\n"); 
		query.append("                ,TO_CHAR(SKD1.UPD_DT, 'HH24:MI') UPD_TM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                ,SKD1.SLAN_CD" ).append("\n"); 
		query.append("                ,SKD1.VSL_CD" ).append("\n"); 
		query.append("                ,SKD1.SKD_VOY_NO" ).append("\n"); 
		query.append("                ,SKD1.SKD_DIR_CD" ).append("\n"); 
		query.append("                ,'' VPS_PORT_POL" ).append("\n"); 
		query.append("                ,'' PF_ETD_FROM_DT" ).append("\n"); 
		query.append("                ,'' PF_ETD_TO_DT" ).append("\n"); 
		query.append("                ,'' PF_ETB_FROM_DT" ).append("\n"); 
		query.append("                ,'' PF_ETB_TO_DT" ).append("\n"); 
		query.append("                ,'' VPS_PORT_POD" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("		  FROM   VSK_VSL_PORT_SKD SKD1, VSK_VSL_PORT_SKD SKD2, VSK_VSL_SKD VS" ).append("\n"); 
		query.append("                 " ).append("\n"); 
		query.append("          WHERE  1=1" ).append("\n"); 
		query.append("		--  AND    VS.SKD_STS_CD !='CLO'  	" ).append("\n"); 
		query.append("		  AND	 SKD1.VSL_CD = SKD2.VSL_CD(+) " ).append("\n"); 
		query.append("          AND    SKD1.SKD_VOY_NO = SKD2.SKD_VOY_NO(+) " ).append("\n"); 
		query.append("          AND    SKD1.SKD_DIR_CD = SKD2.SKD_DIR_CD(+) " ).append("\n"); 
		query.append("          AND    SKD1.VSL_CD = VS.VSL_CD " ).append("\n"); 
		query.append("          AND    SKD1.SKD_VOY_NO = VS.SKD_VOY_NO " ).append("\n"); 
		query.append("          AND    SKD1.SKD_DIR_CD = VS.SKD_DIR_CD " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vsl_cd} != '')" ).append("\n"); 
		query.append("          AND    VS.VSL_CD      LIKE SUBSTR(@[vsl_cd],1,4) || '%'" ).append("\n"); 
		query.append("          AND    VS.SKD_VOY_NO  LIKE SUBSTR(@[vsl_cd],5,4) || '%'" ).append("\n"); 
		query.append("          AND    VS.SKD_DIR_CD  LIKE SUBSTR(@[vsl_cd],9,1) || '%'          " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${slan_cd} != '') " ).append("\n"); 
		query.append("  		  AND    VS.VSL_SLAN_CD IN( ${slan_cd} )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vps_port_pol} != '') " ).append("\n"); 
		query.append(" 		  AND   SKD1.VPS_PORT_CD = @[vps_port_pol]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" 		  AND   SKD1.TURN_PORT_IND_CD IN ('Y','N')" ).append("\n"); 
		query.append("#if (${vps_port_pod} != '') " ).append("\n"); 
		query.append("   		  AND   SKD2.VPS_PORT_CD = @[vps_port_pod]" ).append("\n"); 
		query.append("#end          " ).append("\n"); 
		query.append("	      AND    SKD1.CLPT_SEQ < SKD2.CLPT_SEQ " ).append("\n"); 
		query.append("          AND    NVL(SKD1.SKD_CNG_STS_CD, ' ') <> 'S' " ).append("\n"); 
		query.append("          AND    NVL(SKD2.SKD_CNG_STS_CD, ' ') <> 'S' " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pf_etd_from_dt} != '') " ).append("\n"); 
		query.append("AND  SKD1.VPS_ETD_DT >= TO_DATE(@[pf_etd_from_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pf_etd_to_dt} != '') " ).append("\n"); 
		query.append("AND  SKD1.VPS_ETD_DT <= TO_DATE(@[pf_etd_to_dt], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pf_etb_from_dt} != '') " ).append("\n"); 
		query.append("AND  SKD2.VPS_ETB_DT >= TO_DATE(@[pf_etb_from_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pf_etb_to_dt} != '') " ).append("\n"); 
		query.append("AND  SKD2.VPS_ETB_DT <= TO_DATE(@[pf_etb_to_dt], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vsl_eng_nm} != '') " ).append("\n"); 
		query.append("          AND   EXISTS ( SELECT 'Y' " ).append("\n"); 
		query.append("                           FROM MDM_VSL_CNTR MVSL" ).append("\n"); 
		query.append("                          WHERE 1=1" ).append("\n"); 
		query.append("                            AND MVSL.VSL_CD = VS.VSL_CD" ).append("\n"); 
		query.append("                            AND MVSL.VSL_ENG_NM LIKE UPPER(@[vsl_eng_nm]) || '%'" ).append("\n"); 
		query.append("                            AND MVSL.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         ORDER  BY SKD1.VPS_ETD_DT, VS.VSL_SLAN_CD, SKD1.VSL_CD, SKD1.SKD_VOY_NO, SKD1.SKD_DIR_CD" ).append("\n"); 
		query.append(") X" ).append("\n"); 
		query.append("#elseif (${vps_port_pol} != '' ) " ).append("\n"); 
		query.append("------------------------------------------------------------------------" ).append("\n"); 
		query.append("--3.POL만 입력시" ).append("\n"); 
		query.append("------------------------------------------------------------------------" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("	VVD" ).append("\n"); 
		query.append("	,LANE" ).append("\n"); 
		query.append("	,POL" ).append("\n"); 
		query.append("	,CLPT_IND_SEQ" ).append("\n"); 
		query.append("	,CLPT_SEQ" ).append("\n"); 
		query.append("	,TERMINAL" ).append("\n"); 
		query.append("    ,CCT" ).append("\n"); 
		query.append("    ,TO_CHAR(CCT,'YYYY-MM-DD HH24:MI') CCT_DT" ).append("\n"); 
		query.append("    ,TO_CHAR(CCT,'HH24:MI') CCT_TM" ).append("\n"); 
		query.append("	,ETB  " ).append("\n"); 
		query.append("	,ETB_DT  " ).append("\n"); 
		query.append("	,ETB_TM  " ).append("\n"); 
		query.append("	,ETD  " ).append("\n"); 
		query.append("	,ETD_DT  " ).append("\n"); 
		query.append("	,ETD_TM  " ).append("\n"); 
		query.append("	,T_TIME" ).append("\n"); 
		query.append("	,POD" ).append("\n"); 
		query.append("	,POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append("	,POD_CLPT_SEQ" ).append("\n"); 
		query.append("	,TERMINAL2" ).append("\n"); 
		query.append("	,ETB2" ).append("\n"); 
		query.append("	,ETB2_DT" ).append("\n"); 
		query.append("	,ETB2_TM       " ).append("\n"); 
		query.append("	,VPS_RMK" ).append("\n"); 
		query.append("	,UPD_DT" ).append("\n"); 
		query.append("	,UPD_TM" ).append("\n"); 
		query.append("	,SLAN_CD" ).append("\n"); 
		query.append("	,VSL_CD" ).append("\n"); 
		query.append("	,SKD_VOY_NO" ).append("\n"); 
		query.append("	,SKD_DIR_CD" ).append("\n"); 
		query.append("	,VPS_PORT_POL" ).append("\n"); 
		query.append("	,PF_ETD_FROM_DT" ).append("\n"); 
		query.append("	,PF_ETD_TO_DT" ).append("\n"); 
		query.append("	,PF_ETB_FROM_DT" ).append("\n"); 
		query.append("	,PF_ETB_TO_DT" ).append("\n"); 
		query.append("	,VPS_PORT_POD" ).append("\n"); 
		query.append("	,'' OLD_TICK" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    , (SELECT CRR_CD FROM MDM_VSL_CNTR MVSL WHERE MVSL.VSL_CD = X.VSL_CD AND DELT_FLG = 'N') CRR_CD" ).append("\n"); 
		query.append(" FROM (" ).append("\n"); 
		query.append("		SELECT SKD1.VSL_CD || SKD1.SKD_VOY_NO || SKD1.SKD_DIR_CD VVD" ).append("\n"); 
		query.append("                ,VS.VSL_SLAN_CD LANE" ).append("\n"); 
		query.append("                ,SKD1.VPS_PORT_CD POL" ).append("\n"); 
		query.append("				,SKD1.CLPT_IND_SEQ" ).append("\n"); 
		query.append("				,SKD1.CLPT_SEQ" ).append("\n"); 
		query.append("				,SKD1.YD_CD TERMINAL" ).append("\n"); 
		query.append("                ,NVL(PRD_GET_CCT_FNC(SKD1.Yd_Cd,SKD1.Slan_Cd,SKD1.SKD_DIR_CD, 'F', SKD1.VPS_ETB_DT, SKD1.VPS_ETD_DT, SKD1.VSL_CD||SKD1.SKD_VOY_NO||SKD1.SKD_DIR_CD ) , SKD1.VPS_ETB_DT -10/24)  CCT" ).append("\n"); 
		query.append("				--,TO_CHAR(NVL(PRD_GET_CCT_FNC(SKD1.Yd_Cd,SKD1.Slan_Cd,SKD1.SKD_DIR_CD, 'F', SKD1.VPS_ETB_DT, SKD1.VPS_ETD_DT, SKD1.VSL_CD||SKD1.SKD_VOY_NO||SKD1.SKD_DIR_CD ) , SKD1.VPS_ETB_DT -10/24), 'YYYY-MM-DD HH24:MI')  CCT_DT" ).append("\n"); 
		query.append("				--,TO_CHAR(NVL(PRD_GET_CCT_FNC(SKD1.Yd_Cd,SKD1.Slan_Cd,SKD1.SKD_DIR_CD, 'F', SKD1.VPS_ETB_DT, SKD1.VPS_ETD_DT, SKD1.VSL_CD||SKD1.SKD_VOY_NO||SKD1.SKD_DIR_CD ) , SKD1.VPS_ETB_DT -10/24), 'HH24:MI')  CCT_TM" ).append("\n"); 
		query.append("				,TO_CHAR(SKD1.VPS_ETB_DT, 'YYYY-MM-DD HH24:MI') ETB  " ).append("\n"); 
		query.append("                ,TO_CHAR(SKD1.VPS_ETB_DT, 'YYYY-MM-DD') ETB_DT  " ).append("\n"); 
		query.append("                ,TO_CHAR(SKD1.VPS_ETB_DT, 'HH24:MI') ETB_TM  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                ,TO_CHAR(SKD1.VPS_ETD_DT, 'YYYY-MM-DD HH24:MI') ETD  " ).append("\n"); 
		query.append("                ,TO_CHAR(SKD1.VPS_ETD_DT, 'YYYY-MM-DD') ETD_DT  " ).append("\n"); 
		query.append("                ,TO_CHAR(SKD1.VPS_ETD_DT, 'HH24:MI') ETD_TM  " ).append("\n"); 
		query.append("                ,'' T_TIME" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                ,'' POD" ).append("\n"); 
		query.append("				,'' AS POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append("				,'' AS POD_CLPT_SEQ" ).append("\n"); 
		query.append("				,'' TERMINAL2" ).append("\n"); 
		query.append("                ,'' ETB2" ).append("\n"); 
		query.append("                ,'' ETB2_DT" ).append("\n"); 
		query.append("                ,'' ETB2_TM" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                ,VS.SKD_RMK || replace(SKD1.VPS_RMK, chr(13)||chr(10), ' ')  VPS_RMK" ).append("\n"); 
		query.append("                ,TO_CHAR(SKD1.UPD_DT, 'YYYY-MM-DD') UPD_DT" ).append("\n"); 
		query.append("                ,TO_CHAR(SKD1.UPD_DT, 'HH24:MI') UPD_TM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                ,SKD1.SLAN_CD" ).append("\n"); 
		query.append("                ,SKD1.VSL_CD" ).append("\n"); 
		query.append("                ,SKD1.SKD_VOY_NO" ).append("\n"); 
		query.append("                ,SKD1.SKD_DIR_CD" ).append("\n"); 
		query.append("                ,'' VPS_PORT_POL" ).append("\n"); 
		query.append("                ,'' PF_ETD_FROM_DT" ).append("\n"); 
		query.append("                ,'' PF_ETD_TO_DT" ).append("\n"); 
		query.append("                ,'' PF_ETB_FROM_DT" ).append("\n"); 
		query.append("                ,'' PF_ETB_TO_DT" ).append("\n"); 
		query.append("                ,'' VPS_PORT_POD" ).append("\n"); 
		query.append("		FROM   VSK_VSL_PORT_SKD SKD1, VSK_VSL_SKD VS" ).append("\n"); 
		query.append("          WHERE  1=1" ).append("\n"); 
		query.append("		--  AND    VS.SKD_STS_CD !='CLO'  " ).append("\n"); 
		query.append("#if (${vps_port_pol} != '') " ).append("\n"); 
		query.append(" 		  AND   SKD1.VPS_PORT_CD = @[vps_port_pol]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("		  AND   SKD1.TURN_PORT_IND_CD IN ('Y','N')" ).append("\n"); 
		query.append("          AND    NVL(SKD1.SKD_CNG_STS_CD, ' ') <> 'S' " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${old_tick} != '')" ).append("\n"); 
		query.append("	      AND SKD1.VPS_ETD_DT > SYSDATE -730" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pf_etd_from_dt} != '') " ).append("\n"); 
		query.append("AND  SKD1.VPS_ETD_DT >= TO_DATE(@[pf_etd_from_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pf_etd_to_dt} != '') " ).append("\n"); 
		query.append("AND  SKD1.VPS_ETD_DT <= TO_DATE(@[pf_etd_to_dt], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vsl_cd} != '')" ).append("\n"); 
		query.append("		  AND    SKD1.VSL_CD || SKD1.SKD_VOY_NO || SKD1.SKD_DIR_CD LIKE RTRIM(@[vsl_cd]) || '%'" ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("#end         " ).append("\n"); 
		query.append("          AND    SKD1.VSL_CD = VS.VSL_CD " ).append("\n"); 
		query.append("          AND    SKD1.SKD_VOY_NO = VS.SKD_VOY_NO " ).append("\n"); 
		query.append("          AND    SKD1.SKD_DIR_CD = VS.SKD_DIR_CD " ).append("\n"); 
		query.append("#if (${slan_cd} != '') " ).append("\n"); 
		query.append("  		  AND    VS.VSL_SLAN_CD IN( ${slan_cd} )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vsl_eng_nm} != '') " ).append("\n"); 
		query.append("          AND   EXISTS ( SELECT 'Y' " ).append("\n"); 
		query.append("                           FROM MDM_VSL_CNTR MVSL" ).append("\n"); 
		query.append("                          WHERE 1=1" ).append("\n"); 
		query.append("                            AND MVSL.VSL_CD = VS.VSL_CD" ).append("\n"); 
		query.append("                            AND MVSL.VSL_ENG_NM LIKE UPPER(@[vsl_eng_nm]) || '%'" ).append("\n"); 
		query.append("                            AND MVSL.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          AND    EXISTS         (SELECT 'X'" ).append("\n"); 
		query.append("                                FROM    VSK_VSL_PORT_SKD SKD2" ).append("\n"); 
		query.append("                                WHERE   SKD2.VSL_CD = SKD1.VSL_CD " ).append("\n"); 
		query.append("                                AND     SKD2.SKD_VOY_NO = SKD1.SKD_VOY_NO " ).append("\n"); 
		query.append("                                AND     SKD2.SKD_DIR_CD = SKD1.SKD_DIR_CD " ).append("\n"); 
		query.append("                                AND     SKD2.CLPT_SEQ > SKD1.CLPT_SEQ " ).append("\n"); 
		query.append("                                AND     NVL(SKD2.SKD_CNG_STS_CD, ' ') <> 'S' " ).append("\n"); 
		query.append("                                AND ROWNUM = 1)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          ORDER  BY SKD1.VPS_ETD_DT, VS.VSL_SLAN_CD, SKD1.VSL_CD, SKD1.SKD_VOY_NO, SKD1.SKD_DIR_CD" ).append("\n"); 
		query.append(") X" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${vps_port_pod} != ''  ) " ).append("\n"); 
		query.append("------------------------------------------------------------------------" ).append("\n"); 
		query.append("--4.POD만 입력시" ).append("\n"); 
		query.append("------------------------------------------------------------------------" ).append("\n"); 
		query.append("		SELECT SKD2.VSL_CD || SKD2.SKD_VOY_NO || SKD2.SKD_DIR_CD VVD" ).append("\n"); 
		query.append("                ,VS.VSL_SLAN_CD LANE" ).append("\n"); 
		query.append("                ,'' POL" ).append("\n"); 
		query.append("				,'' CLPT_IND_SEQ" ).append("\n"); 
		query.append("				,'' CLPT_SEQ" ).append("\n"); 
		query.append("				,'' TERMINAL" ).append("\n"); 
		query.append("                ,'' CCT" ).append("\n"); 
		query.append("				,'' CCT_DT" ).append("\n"); 
		query.append("				,'' CCT_TM" ).append("\n"); 
		query.append("                ,'' ETB  " ).append("\n"); 
		query.append("                ,'' ETB_DT  " ).append("\n"); 
		query.append("                ,'' ETB_TM  " ).append("\n"); 
		query.append("                ,'' ETD  " ).append("\n"); 
		query.append("                ,'' ETD_DT  " ).append("\n"); 
		query.append("                ,'' ETD_TM  " ).append("\n"); 
		query.append("                ,'' T_TIME" ).append("\n"); 
		query.append("                ,SKD2.VPS_PORT_CD POD" ).append("\n"); 
		query.append("				,SKD2.CLPT_IND_SEQ AS POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append("				,SKD2.CLPT_SEQ AS POD_CLPT_SEQ" ).append("\n"); 
		query.append("				,SKD2.YD_CD TERMINAL2" ).append("\n"); 
		query.append("                ,TO_CHAR(SKD2.VPS_ETB_DT, 'YYYY-MM-DD HH24:MI') ETB2" ).append("\n"); 
		query.append("                ,TO_CHAR(SKD2.VPS_ETB_DT, 'YYYY-MM-DD HH24:MI') ETB2_DT" ).append("\n"); 
		query.append("                ,TO_CHAR(SKD2.VPS_ETB_DT, 'YYYY-MM-DD HH24:MI') ETB2_TM" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                ,VS.SKD_RMK || replace(SKD2.VPS_RMK, chr(13)||chr(10), ' ')  VPS_RMK" ).append("\n"); 
		query.append("                ,TO_CHAR(SKD2.UPD_DT, 'YYYY-MM-DD') UPD_DT" ).append("\n"); 
		query.append("                ,TO_CHAR(SKD2.UPD_DT, 'HH24:MI') UPD_TM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                ,SKD2.SLAN_CD" ).append("\n"); 
		query.append("                ,SKD2.VSL_CD" ).append("\n"); 
		query.append("                ,SKD2.SKD_VOY_NO" ).append("\n"); 
		query.append("                ,SKD2.SKD_DIR_CD" ).append("\n"); 
		query.append("                ,'' VPS_PORT_POL" ).append("\n"); 
		query.append("                ,'' PF_ETD_FROM_DT" ).append("\n"); 
		query.append("                ,'' PF_ETD_TO_DT" ).append("\n"); 
		query.append("                ,'' PF_ETB_FROM_DT" ).append("\n"); 
		query.append("                ,'' PF_ETB_TO_DT" ).append("\n"); 
		query.append("                ,'' VPS_PORT_POD  " ).append("\n"); 
		query.append("				,'' OLD_TICK" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                , (SELECT CRR_CD FROM MDM_VSL_CNTR MVSL WHERE MVSL.VSL_CD = VS.VSL_CD AND DELT_FLG = 'N') CRR_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		FROM   VSK_VSL_PORT_SKD SKD2, VSK_VSL_SKD VS" ).append("\n"); 
		query.append("        WHERE  1=1" ).append("\n"); 
		query.append("	  --  AND    VS.SKD_STS_CD !='CLO'  " ).append("\n"); 
		query.append("#if (${vps_port_pod} != '') " ).append("\n"); 
		query.append("   		AND    SKD2.VPS_PORT_CD = @[vps_port_pod]" ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("		AND    NVL(SKD2.SKD_CNG_STS_CD, ' ') <> 'S' " ).append("\n"); 
		query.append("#if (${old_tick} != '')" ).append("\n"); 
		query.append("		AND SKD2.VPS_ETB_DT > SYSDATE -730" ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("#if (${pf_etb_from_dt} != '') " ).append("\n"); 
		query.append("AND  SKD2.VPS_ETB_DT >= TO_DATE(@[pf_etb_from_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pf_etb_to_dt} != '') " ).append("\n"); 
		query.append("AND  SKD2.VPS_ETB_DT <= TO_DATE(@[pf_etb_to_dt], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vsl_cd} != '')" ).append("\n"); 
		query.append("		AND    SKD2.VSL_CD || SKD2.SKD_VOY_NO || SKD2.SKD_DIR_CD LIKE RTRIM(@[vsl_cd]) || '%'" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("        AND    SKD2.VSL_CD = VS.VSL_CD " ).append("\n"); 
		query.append("        AND    SKD2.SKD_VOY_NO = VS.SKD_VOY_NO " ).append("\n"); 
		query.append("        AND    SKD2.SKD_DIR_CD = VS.SKD_DIR_CD " ).append("\n"); 
		query.append("#if (${slan_cd} != '') " ).append("\n"); 
		query.append("  		AND    VS.VSL_SLAN_CD IN( ${slan_cd} )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vsl_eng_nm} != '') " ).append("\n"); 
		query.append("          AND   EXISTS ( SELECT 'Y' " ).append("\n"); 
		query.append("                           FROM MDM_VSL_CNTR MVSL" ).append("\n"); 
		query.append("                          WHERE 1=1" ).append("\n"); 
		query.append("                            AND MVSL.VSL_CD = VS.VSL_CD" ).append("\n"); 
		query.append("                            AND MVSL.VSL_ENG_NM LIKE UPPER(@[vsl_eng_nm]) || '%'" ).append("\n"); 
		query.append("                            AND MVSL.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        AND    EXISTS         (SELECT 'X'" ).append("\n"); 
		query.append("                              FROM   VSK_VSL_PORT_SKD SKD1" ).append("\n"); 
		query.append("                              WHERE  SKD1.VSL_CD = SKD2.VSL_CD " ).append("\n"); 
		query.append("                              AND    SKD1.SKD_VOY_NO = SKD2.SKD_VOY_NO " ).append("\n"); 
		query.append("                              AND    SKD1.SKD_DIR_CD = SKD2.SKD_DIR_CD " ).append("\n"); 
		query.append("                              AND    SKD1.CLPT_SEQ < SKD2.CLPT_SEQ " ).append("\n"); 
		query.append("                              AND    NVL(SKD1.SKD_CNG_STS_CD, ' ') <> 'S' " ).append("\n"); 
		query.append("							  AND    SKD1.TURN_PORT_IND_CD IN ('Y','N')" ).append("\n"); 
		query.append("                              AND ROWNUM = 1)" ).append("\n"); 
		query.append("        ORDER  BY SKD2.VPS_ETB_DT, VS.VSL_SLAN_CD, SKD2.VSL_CD, SKD2.SKD_VOY_NO, SKD2.SKD_DIR_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") YY" ).append("\n"); 

	}
}