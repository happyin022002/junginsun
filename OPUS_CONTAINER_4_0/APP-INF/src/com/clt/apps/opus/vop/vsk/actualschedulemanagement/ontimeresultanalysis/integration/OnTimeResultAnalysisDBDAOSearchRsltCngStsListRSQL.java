/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : OnTimeResultAnalysisDBDAOSearchRsltCngStsListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.03
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.03 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.actualschedulemanagement.ontimeresultanalysis.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OnTimeResultAnalysisDBDAOSearchRsltCngStsListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchRsltCngStsList
	  * </pre>
	  */
	public OnTimeResultAnalysisDBDAOSearchRsltCngStsListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane_grp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane_grp_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("intg_cd_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_inp_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_inp_to_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.vop.vsk.actualschedulemanagement.ontimeresultanalysis.integration").append("\n"); 
		query.append("FileName : OnTimeResultAnalysisDBDAOSearchRsltCngStsListRSQL").append("\n"); 
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
		query.append("SELECT   MAX_SEQ, GROUP_FLG, VVD" ).append("\n"); 
		query.append("        ,MAX(DECODE(T2.SEQ, 01, PORT)) AS PORT1" ).append("\n"); 
		query.append("        ,MAX(DECODE(T2.SEQ, 01, STS))  AS STATE1" ).append("\n"); 
		query.append("        ,MAX(DECODE(T2.SEQ, 02, PORT)) AS PORT2" ).append("\n"); 
		query.append("        ,MAX(DECODE(T2.SEQ, 02, STS))  AS STATE2" ).append("\n"); 
		query.append("        ,MAX(DECODE(T2.SEQ, 03, PORT)) AS PORT3" ).append("\n"); 
		query.append("        ,MAX(DECODE(T2.SEQ, 03, STS))  AS STATE3" ).append("\n"); 
		query.append("        ,MAX(DECODE(T2.SEQ, 04, PORT)) AS PORT4" ).append("\n"); 
		query.append("        ,MAX(DECODE(T2.SEQ, 04, STS))  AS STATE4" ).append("\n"); 
		query.append("        ,MAX(DECODE(T2.SEQ, 05, PORT)) AS PORT5" ).append("\n"); 
		query.append("        ,MAX(DECODE(T2.SEQ, 05, STS))  AS STATE5" ).append("\n"); 
		query.append("        ,MAX(DECODE(T2.SEQ, 06, PORT)) AS PORT6" ).append("\n"); 
		query.append("        ,MAX(DECODE(T2.SEQ, 06, STS))  AS STATE6" ).append("\n"); 
		query.append("        ,MAX(DECODE(T2.SEQ, 07, PORT)) AS PORT7" ).append("\n"); 
		query.append("        ,MAX(DECODE(T2.SEQ, 07, STS))  AS STATE7" ).append("\n"); 
		query.append("        ,MAX(DECODE(T2.SEQ, 08, PORT)) AS PORT8" ).append("\n"); 
		query.append("        ,MAX(DECODE(T2.SEQ, 08, STS))  AS STATE8" ).append("\n"); 
		query.append("        ,MAX(DECODE(T2.SEQ, 09, PORT)) AS PORT9" ).append("\n"); 
		query.append("        ,MAX(DECODE(T2.SEQ, 09, STS))  AS STATE9" ).append("\n"); 
		query.append("        ,MAX(DECODE(T2.SEQ, 10, PORT)) AS PORT10" ).append("\n"); 
		query.append("        ,MAX(DECODE(T2.SEQ, 10, STS))  AS STATE10" ).append("\n"); 
		query.append("        ,MAX(DECODE(T2.SEQ, 11, PORT)) AS PORT11" ).append("\n"); 
		query.append("        ,MAX(DECODE(T2.SEQ, 11, STS))  AS STATE11" ).append("\n"); 
		query.append("        ,MAX(DECODE(T2.SEQ, 12, PORT)) AS PORT12" ).append("\n"); 
		query.append("        ,MAX(DECODE(T2.SEQ, 12, STS))  AS STATE12" ).append("\n"); 
		query.append("        ,MAX(DECODE(T2.SEQ, 13, PORT)) AS PORT13" ).append("\n"); 
		query.append("        ,MAX(DECODE(T2.SEQ, 13, STS))  AS STATE13" ).append("\n"); 
		query.append("        ,MAX(DECODE(T2.SEQ, 14, PORT)) AS PORT14" ).append("\n"); 
		query.append("        ,MAX(DECODE(T2.SEQ, 14, STS))  AS STATE14" ).append("\n"); 
		query.append("        ,MAX(DECODE(T2.SEQ, 15, PORT)) AS PORT15" ).append("\n"); 
		query.append("        ,MAX(DECODE(T2.SEQ, 15, STS))  AS STATE15" ).append("\n"); 
		query.append("        ,MAX(DECODE(T2.SEQ, 16, PORT)) AS PORT16" ).append("\n"); 
		query.append("        ,MAX(DECODE(T2.SEQ, 16, STS))  AS STATE16" ).append("\n"); 
		query.append("        ,MAX(DECODE(T2.SEQ, 17, PORT)) AS PORT17" ).append("\n"); 
		query.append("        ,MAX(DECODE(T2.SEQ, 17, STS))  AS STATE17" ).append("\n"); 
		query.append("        ,MAX(DECODE(T2.SEQ, 18, PORT)) AS PORT18" ).append("\n"); 
		query.append("        ,MAX(DECODE(T2.SEQ, 18, STS))  AS STATE18" ).append("\n"); 
		query.append("        ,MAX(DECODE(T2.SEQ, 19, PORT)) AS PORT19" ).append("\n"); 
		query.append("        ,MAX(DECODE(T2.SEQ, 19, STS))  AS STATE19" ).append("\n"); 
		query.append("        ,MAX(DECODE(T2.SEQ, 20, PORT)) AS PORT20" ).append("\n"); 
		query.append("        ,MAX(DECODE(T2.SEQ, 20, STS))  AS STATE20" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("        SELECT  GROUP_FLG, VVD, PORT, STS, SEQ" ).append("\n"); 
		query.append("                ,((MAX(SEQ) OVER () * 2) + 2) MAX_SEQ" ).append("\n"); 
		query.append("        FROM    (" ).append("\n"); 
		query.append("                SELECT  " ).append("\n"); 
		query.append("                        #if (${grp_flg} == 'L')" ).append("\n"); 
		query.append("                            T1.SLAN_CD AS GROUP_FLG" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                        #if (${grp_flg} == 'P')" ).append("\n"); 
		query.append("                            T1.VPS_PORT_CD AS GROUP_FLG" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                        #if (${grp_flg} == 'V')" ).append("\n"); 
		query.append("                            T1.VSL_CD AS GROUP_FLG" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                       , T1.VSL_CD || T1.SKD_VOY_NO || T1.SKD_DIR_CD  VVD" ).append("\n"); 
		query.append("                       , T1.VPS_PORT_CD PORT" ).append("\n"); 
		query.append("                       ,(SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = @[intg_cd_id] AND INTG_CD_VAL_CTNT = SKD_CNG_STS_CD) STS" ).append("\n"); 
		query.append("                       ," ).append("\n"); 
		query.append("                        #if (${grp_flg} == 'L')" ).append("\n"); 
		query.append("                        ROW_NUMBER() OVER (PARTITION BY T1.SLAN_CD, T1.VSL_CD, T1.SKD_VOY_NO, T1.SKD_DIR_CD ORDER BY T1.CLPT_SEQ) AS SEQ" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                        #if (${grp_flg} == 'P')" ).append("\n"); 
		query.append("                        ROW_NUMBER() OVER (PARTITION BY T1.VPS_PORT_CD, T1.VSL_CD, T1.SKD_VOY_NO, T1.SKD_DIR_CD ORDER BY T1.CLPT_SEQ) AS SEQ" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                        #if (${grp_flg} == 'V')" ).append("\n"); 
		query.append("                        ROW_NUMBER() OVER (PARTITION BY T1.VSL_CD, T1.SKD_VOY_NO, T1.SKD_DIR_CD ORDER BY T1.CLPT_SEQ) AS SEQ" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                FROM    VSK_VSL_PORT_SKD T1, MDM_VSL_CNTR T2" ).append("\n"); 
		query.append("                WHERE   1 = 1" ).append("\n"); 
		query.append("                AND     T1.VSL_CD         = T2.VSL_CD" ).append("\n"); 
		query.append("                AND     T1.SKD_CNG_STS_CD IN ('R', 'A', 'I', 'O', 'S')" ).append("\n"); 
		query.append("                AND     T1.TURN_PORT_IND_CD NOT IN ('D', 'V', 'F')" ).append("\n"); 
		query.append("                AND   ((DECODE(@[lane_grp], 'I', T1.SLAN_CD) = NVL(@[vsl_slan_cd], T1.SLAN_CD))  OR  (DECODE(@[lane_grp], 'G', T1.SLAN_CD) IN  (SELECT VSL_SLAN_CD FROM VSK_USR_LANE_GRP WHERE USR_ID = @[usr_id] AND LANE_GRP_NM = @[lane_grp_nm])))" ).append("\n"); 
		query.append("                AND     T1.VPS_ETD_DT    >= TO_DATE(@[act_inp_fm_dt], 'YYYYMM') " ).append("\n"); 
		query.append("                AND     T1.VPS_ETD_DT    <= LAST_DAY(TO_DATE(@[act_inp_to_dt], 'YYYYMM')) + 0.99999" ).append("\n"); 
		query.append("                AND     T1.VSL_CD        LIKE @[vsl_cd]        || '%'" ).append("\n"); 
		query.append("                AND     T1.VPS_PORT_CD   LIKE @[vps_port_cd]   || '%'" ).append("\n"); 
		query.append("                AND     T2.CRR_CD        LIKE @[crr_cd]        || '%'" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("        ) T1, ( SELECT ST + LEVEL - 1 SEQ  FROM (SELECT 1 ST, 20 ED FROM DUAL) CONNECT BY LEVEL <= ED ) T2" ).append("\n"); 
		query.append("WHERE   T1.SEQ     = T2.SEQ" ).append("\n"); 
		query.append("GROUP BY GROUP_FLG, VVD, MAX_SEQ" ).append("\n"); 
		query.append("ORDER BY GROUP_FLG, VVD, MAX_SEQ" ).append("\n"); 

	}
}