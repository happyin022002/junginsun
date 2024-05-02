/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : SettlementProcessDBDAOJoSettlementStatusOusRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.19
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SettlementProcessDBDAOJoSettlementStatusOusRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * JoSettlementStatusOus
	  * </pre>
	  */
	public SettlementProcessDBDAOJoSettlementStatusOusRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_crr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("re_divr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("page_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pagerows",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.integration").append("\n"); 
		query.append("FileName : SettlementProcessDBDAOJoSettlementStatusOusRSQL").append("\n"); 
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
		query.append("WITH ROB_LIST AS (" ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("     J.VSL_CD" ).append("\n"); 
		query.append("    ,J.SKD_VOY_NO" ).append("\n"); 
		query.append("    ,J.SKD_DIR_CD" ).append("\n"); 
		query.append("    ,J.VPS_PORT_CD" ).append("\n"); 
		query.append("    ,SUBSTR(J.YD_CD,6,2) AS TML_CD" ).append("\n"); 
		query.append("    ,J.CLPT_IND_SEQ" ).append("\n"); 
		query.append("    ,J.TRD_CD" ).append("\n"); 
		query.append("    ,A4.CRR_CD             " ).append("\n"); 
		query.append("    ,J.RLANE_CD" ).append("\n"); 
		query.append("    ,J.RE_DIVR_CD" ).append("\n"); 
		query.append("    ,J.YD_CD" ).append("\n"); 
		query.append("	,DECODE(J.ROB_ENBL_FLG,'Y','P','NP')	AS ROB_ENBL_FLG	" ).append("\n"); 
		query.append("    ,J.VPS_ETD_DT    " ).append("\n"); 
		query.append("    ,J.REV_DIR_CD" ).append("\n"); 
		query.append("    FROM JOO_ROB_CNTR_SMRY J" ).append("\n"); 
		query.append("        ,BSA_VVD_CRR_PERF A4    " ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("	AND J.VPS_ETD_DT BETWEEN TO_DATE('201510','YYYYMM') AND ADD_MONTHS(TO_DATE(REPLACE(@[rev_yrmon],'-',''),'YYYYMM'),1)" ).append("\n"); 
		query.append("    AND J.VSL_CD     = A4.VSL_CD(+) " ).append("\n"); 
		query.append("    AND J.SKD_VOY_NO = A4.SKD_VOY_NO(+) " ).append("\n"); 
		query.append("    AND J.SKD_DIR_CD = A4.SKD_DIR_CD(+) " ).append("\n"); 
		query.append("    AND J.TRD_CD     = A4.TRD_CD(+) " ).append("\n"); 
		query.append("    AND J.RLANE_CD   = A4.RLANE_CD(+) " ).append("\n"); 
		query.append("	AND A4.BSA_OP_JB_CD IN ('000','003','005')		-- Exp" ).append("\n"); 
		query.append("    AND A4.CRR_CD(+)  != 'SML' " ).append("\n"); 
		query.append("    AND A4.CRR_BSA_CAPA > 0   " ).append("\n"); 
		query.append("	#if (${trd_cd}!= '')" ).append("\n"); 
		query.append("		   AND   J.TRD_CD        =  @[trd_cd]  " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${rlane_cd}!= '')" ).append("\n"); 
		query.append("		   AND   J.RLANE_CD      =  @[rlane_cd]  " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${jo_crr_cd}!= '')" ).append("\n"); 
		query.append("		   AND   J.CRR_CD     	 =  @[jo_crr_cd]  " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${re_divr_cd}!= '')" ).append("\n"); 
		query.append("		   AND   J.RE_DIVR_CD    =  @[re_divr_cd]  " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${skd_dir_cd}!= '')" ).append("\n"); 
		query.append("		   AND   J.SKD_DIR_CD    =  @[skd_dir_cd]  " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${vvd_cd}!= '')" ).append("\n"); 
		query.append("		   AND   J.VSL_CD||J.SKD_VOY_NO||J.SKD_DIR_CD like @[vvd_cd]||'%'" ).append("\n"); 
		query.append("	#end	" ).append("\n"); 
		query.append("), ROB_LIST4 AS (" ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("         '' AS REV_YRMON" ).append("\n"); 
		query.append("        ,A.TRD_CD 		" ).append("\n"); 
		query.append("        ,A.RLANE_CD" ).append("\n"); 
		query.append("        ,A.CRR_CD" ).append("\n"); 
		query.append("        ,A.RE_DIVR_CD" ).append("\n"); 
		query.append("        ,A.VSL_CD               AS VSL  			" ).append("\n"); 
		query.append("        ,A.SKD_VOY_NO           AS VOY  			" ).append("\n"); 
		query.append("        ,A.SKD_DIR_CD           AS DIR 			" ).append("\n"); 
		query.append("        ,A.VPS_PORT_CD          AS PORT 			" ).append("\n"); 
		query.append("        ,SUBSTR(A.YD_CD,6,2)    AS TML 			" ).append("\n"); 
		query.append("        ,A.CLPT_IND_SEQ         AS IND 			" ).append("\n"); 
		query.append("		,A.JO_STL_RMK_CD 		AS RMK_TP 		" ).append("\n"); 
		query.append("		,A.JO_STL_RMK    		AS RMK 		" ).append("\n"); 
		query.append("        ,'' AS OUS 			" ).append("\n"); 
		query.append("        ,'' AS RF 			" ).append("\n"); 
		query.append("        ,'' AS OTHER     " ).append("\n"); 
		query.append("		,TO_CHAR(A.VPS_ETD_DT,'YYYYMMDDHH24MISS') AS VPS_ETD_DT " ).append("\n"); 
		query.append("        ,A.VVD_ETD_GROUP" ).append("\n"); 
		query.append("        ,NVL(A.STL_TGT_FLG,'0') AS STL_TGT_FLG" ).append("\n"); 
		query.append("        ,NVL(A.STL_CLZ_FLG,'0')	AS STL_CLZ_FLG   " ).append("\n"); 
		query.append("    FROM" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("        SELECT " ).append("\n"); 
		query.append("             J.REV_YRMON" ).append("\n"); 
		query.append("            ,J.REV_YRMON_SEQ" ).append("\n"); 
		query.append("            ,J.JO_STL_STS_CD" ).append("\n"); 
		query.append("            ,J.STL_TGT_FLG" ).append("\n"); 
		query.append("            ,J.STL_CLZ_FLG	" ).append("\n"); 
		query.append("            ,MIN(RL.VSL_CD || RL.SKD_VOY_NO || RL.SKD_DIR_CD || RL.VPS_ETD_DT) OVER (PARTITION BY RL.VSL_CD || RL.SKD_VOY_NO || RL.SKD_DIR_CD) AS VVD_ETD_GROUP        " ).append("\n"); 
		query.append("            ,RL.*" ).append("\n"); 
		query.append("            ,J.JO_STL_RMK_CD           " ).append("\n"); 
		query.append("            ,J.JO_STL_RMK              " ).append("\n"); 
		query.append("        FROM ROB_LIST RL, JOO_LODG_TGT J" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("        AND RL.TRD_CD = J.TRD_CD(+)" ).append("\n"); 
		query.append("--        AND RL.CRR_CD = J.CRR_CD(+)" ).append("\n"); 
		query.append("        AND RL.RLANE_CD = J.RLANE_CD(+)" ).append("\n"); 
		query.append("        AND RL.VSL_CD = J.VSL_CD(+)" ).append("\n"); 
		query.append("        AND RL.SKD_VOY_NO = J.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("        AND RL.SKD_DIR_CD = J.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("        AND RL.VPS_PORT_CD = J.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("        AND RL.YD_CD = J.YD_CD(+)" ).append("\n"); 
		query.append("        AND RL.CLPT_IND_SEQ  = J.CLPT_IND_SEQ(+)" ).append("\n"); 
		query.append("    ) A" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("  AA.SEQ_NO AS SEQ" ).append("\n"); 
		query.append(",'' AS REV_YRMON" ).append("\n"); 
		query.append(",TRD_CD 		" ).append("\n"); 
		query.append(",RLANE_CD" ).append("\n"); 
		query.append(",CRR_CD" ).append("\n"); 
		query.append(",RE_DIVR_CD" ).append("\n"); 
		query.append(",VSL  			" ).append("\n"); 
		query.append(",VOY  			" ).append("\n"); 
		query.append(",DIR 			" ).append("\n"); 
		query.append(",PORT 			" ).append("\n"); 
		query.append(",TML 			" ).append("\n"); 
		query.append(",IND" ).append("\n"); 
		query.append(",VPS_ETD_DT ETD 			" ).append("\n"); 
		query.append(",RMK_TP 		" ).append("\n"); 
		query.append(",RMK 			" ).append("\n"); 
		query.append(",(  SELECT J.STL_PIC_NM FROM JOO_STL_PIC J" ).append("\n"); 
		query.append("    WHERE J.TRD_CD = AA.TRD_CD" ).append("\n"); 
		query.append("	AND J.CRR_CD = AA.CRR_CD" ).append("\n"); 
		query.append("	AND J.RLANE_CD = AA.RLANE_CD" ).append("\n"); 
		query.append("	AND J.RE_DIVR_CD = AA.RE_DIVR_CD" ).append("\n"); 
		query.append(" ) PIC  " ).append("\n"); 
		query.append(",'' AS OUS 			" ).append("\n"); 
		query.append(",'' AS RF 			" ).append("\n"); 
		query.append(",'' AS OTHER " ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("      ROWNUM AS SEQ_NO" ).append("\n"); 
		query.append("     ,A.*" ).append("\n"); 
		query.append("    FROM" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("        SELECT R.*" ).append("\n"); 
		query.append("		FROM ROB_LIST4 R" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("        AND (STL_TGT_FLG = '0' AND STL_CLZ_FLG = '0')" ).append("\n"); 
		query.append("        ORDER BY SUBSTR(VVD_ETD_GROUP, 10), VSL || VOY || DIR, VPS_ETD_DT, PORT, CRR_CD" ).append("\n"); 
		query.append("    ) A" ).append("\n"); 
		query.append(") AA  " ).append("\n"); 
		query.append("#if (${page_no} != '')" ).append("\n"); 
		query.append("WHERE SEQ_NO BETWEEN 1 + ((@[page_no]-1)*@[pagerows]) AND (@[page_no]*@[pagerows])" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}