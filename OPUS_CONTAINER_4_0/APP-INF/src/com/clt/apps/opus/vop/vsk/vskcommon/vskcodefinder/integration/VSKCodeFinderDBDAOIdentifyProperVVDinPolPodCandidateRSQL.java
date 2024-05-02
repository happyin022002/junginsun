/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : VSKCodeFinderDBDAOIdentifyProperVVDinPolPodCandidateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.07
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.07 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VSKCodeFinderDBDAOIdentifyProperVVDinPolPodCandidateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * POL, POD 고려한 VVD 추출하기
	  * </pre>
	  */
	public VSKCodeFinderDBDAOIdentifyProperVVDinPolPodCandidateRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lloyd_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ob_cssm_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("call_sgn_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.integration").append("\n"); 
		query.append("FileName : VSKCodeFinderDBDAOIdentifyProperVVDinPolPodCandidateRSQL").append("\n"); 
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
		query.append("SELECT      PS.SLAN_CD			AS VSL_SLAN_CD" ).append("\n"); 
		query.append("		 ,	PS.VSL_CD" ).append("\n"); 
		query.append("         ,  PS.SKD_VOY_NO" ).append("\n"); 
		query.append("         ,  PS.SKD_DIR_CD" ).append("\n"); 
		query.append("         ,  PS.VPS_PORT_CD" ).append("\n"); 
		query.append("         ,  PS.CLPT_IND_SEQ" ).append("\n"); 
		query.append("         ,  PS.CLPT_SEQ" ).append("\n"); 
		query.append("         ,  PS.IB_CSSM_VOY_NO" ).append("\n"); 
		query.append("         ,  PS.OB_CSSM_VOY_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		 ,  ''					AS CALL_SGN_NO" ).append("\n"); 
		query.append("		 ,  ''					AS LLOYD_NO" ).append("\n"); 
		query.append("		 ,	''					AS POL_CD" ).append("\n"); 
		query.append("		 ,  ''					AS MATCHED_VVD_COUNT" ).append("\n"); 
		query.append("		 ,  ''					AS EFFECTIVE_VVD_CHK_RSLT_CD" ).append("\n"); 
		query.append("		 ,	''					AS EFFECTIVE_VVD_CHK_RSLT_RMK" ).append("\n"); 
		query.append("FROM        VSK_VSL_PORT_SKD    PS" ).append("\n"); 
		query.append("     ,      VSK_VSL_PORT_SKD    PPS" ).append("\n"); 
		query.append("WHERE       1 = 1" ).append("\n"); 
		query.append("AND         PS.VSL_CD           = PPS.VSL_CD" ).append("\n"); 
		query.append("AND         PS.SKD_VOY_NO       = PPS.SKD_VOY_NO" ).append("\n"); 
		query.append("AND         PS.SKD_DIR_CD       = PPS.SKD_DIR_CD" ).append("\n"); 
		query.append("AND         PS.CLPT_SEQ         < PPS.CLPT_SEQ" ).append("\n"); 
		query.append("AND         PS.VT_ADD_CALL_FLG  IS NULL       --:Excluding Virtual Add Calling Port:--" ).append("\n"); 
		query.append("AND         PS.TURN_PORT_IND_CD IN ('Y','N')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND			NVL(PS.SKD_CNG_STS_CD,'*')	<> 'S'" ).append("\n"); 
		query.append("AND			NVL(PPS.SKD_CNG_STS_CD,'*')	<> 'S'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND         PS.CLPT_SEQ     	= (SELECT     MAX(P1.CLPT_SEQ)" ).append("\n"); 
		query.append("                                   FROM       VSK_VSL_PORT_SKD 		P1" ).append("\n"); 
		query.append("                                   WHERE      P1.VSL_CD       		= PS.VSL_CD" ).append("\n"); 
		query.append("                                   AND        P1.SKD_VOY_NO   		= PS.SKD_VOY_NO" ).append("\n"); 
		query.append("                                   AND        P1.SKD_DIR_CD   		= PS.SKD_DIR_CD" ).append("\n"); 
		query.append("                                   AND        P1.VPS_PORT_CD  		= PS.VPS_PORT_CD" ).append("\n"); 
		query.append("								   AND        P1.VT_ADD_CALL_FLG 	IS NULL" ).append("\n"); 
		query.append("                                  )" ).append("\n"); 
		query.append("AND         PPS.CLPT_SEQ     	= (SELECT     MAX(P1.CLPT_SEQ)" ).append("\n"); 
		query.append("                                   FROM       VSK_VSL_PORT_SKD 		P1" ).append("\n"); 
		query.append("                                   WHERE      P1.VSL_CD       		= PPS.VSL_CD" ).append("\n"); 
		query.append("                                   AND        P1.SKD_VOY_NO   		= PPS.SKD_VOY_NO" ).append("\n"); 
		query.append("                                   AND        P1.SKD_DIR_CD   		= PPS.SKD_DIR_CD" ).append("\n"); 
		query.append("                                   AND        P1.VPS_PORT_CD  		= PPS.VPS_PORT_CD" ).append("\n"); 
		query.append("                                  )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND         PS.VSL_CD           " ).append("\n"); 
		query.append("            IN" ).append("\n"); 
		query.append("            (" ).append("\n"); 
		query.append("            --==================================================================" ).append("\n"); 
		query.append("            SELECT  XX.VSL_CD" ).append("\n"); 
		query.append("                  --, XX.CALL_SGN_NO" ).append("\n"); 
		query.append("                  --, XX.LLOYD_NO" ).append("\n"); 
		query.append("                  --, XX.DELT_FLG" ).append("\n"); 
		query.append("            FROM    (" ).append("\n"); 
		query.append("                    ------------------------------------------------------------       " ).append("\n"); 
		query.append("                    SELECT  X.*" ).append("\n"); 
		query.append("                          , DENSE_RANK() OVER (ORDER BY VSL_CD_1ST_RNK ASC, DELT_FLG ASC) VSL_CD_2ND_RNK" ).append("\n"); 
		query.append("                    FROM    (" ).append("\n"); 
		query.append("                            ----------------------------------------------------" ).append("\n"); 
		query.append("                            SELECT  X.DELT_FLG" ).append("\n"); 
		query.append("                                  , X.VSL_CD" ).append("\n"); 
		query.append("                                  , X.CALL_SGN_NO" ).append("\n"); 
		query.append("                                  , X.LLOYD_NO" ).append("\n"); 
		query.append("                                  , CASE WHEN X.CALL_SGN_NO = @[call_sgn_no] THEN '1'" ).append("\n"); 
		query.append("                                         WHEN X.LLOYD_NO    = @[lloyd_no]	 THEN '2'" ).append("\n"); 
		query.append("                                         ELSE ''" ).append("\n"); 
		query.append("                                    END  AS VSL_CD_1ST_RNK" ).append("\n"); 
		query.append("                            FROM    MDM_VSL_CNTR      		X" ).append("\n"); 
		query.append("                            WHERE   (X.CALL_SGN_NO     		= @[call_sgn_no]" ).append("\n"); 
		query.append("                                     OR" ).append("\n"); 
		query.append("                                     X.LLOYD_NO        		= @[lloyd_no]" ).append("\n"); 
		query.append("                                    )                                 " ).append("\n"); 
		query.append("                            ----------------------------------------------------   " ).append("\n"); 
		query.append("                            ) X           " ).append("\n"); 
		query.append("                    ------------------------------------------------------------" ).append("\n"); 
		query.append("                    ) XX     " ).append("\n"); 
		query.append("            WHERE   XX.VSL_CD_2ND_RNK                  		= '1'     " ).append("\n"); 
		query.append("            --==================================================================               " ).append("\n"); 
		query.append("            ) " ).append("\n"); 
		query.append("AND         (" ).append("\n"); 
		query.append("				PS.OB_CSSM_VOY_NO                          	= @[ob_cssm_voy_no]" ).append("\n"); 
		query.append("			OR" ).append("\n"); 
		query.append("				SUBSTR(PS.OB_CSSM_VOY_NO,1,4)              	= @[ob_cssm_voy_no]" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("AND         PS.VPS_PORT_CD                             		= @[pol_cd]" ).append("\n"); 
		query.append("AND         PPS.VPS_PORT_CD                             	= @[pod_cd]" ).append("\n"); 

	}
}