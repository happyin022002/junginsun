/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : SettlementProcessDBDAOJoSettlementStatusOusDetailTotalRSQL.java
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

public class SettlementProcessDBDAOJoSettlementStatusOusDetailTotalRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 미정산 VVD 조회
	  * </pre>
	  */
	public SettlementProcessDBDAOJoSettlementStatusOusDetailTotalRSQL(){
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
		params.put("pagerows",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.integration").append("\n"); 
		query.append("FileName : SettlementProcessDBDAOJoSettlementStatusOusDetailTotalRSQL").append("\n"); 
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
		query.append("WITH OUS_TGT AS (" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("           J.REV_YRMON" ).append("\n"); 
		query.append("          ,J.REV_YRMON_SEQ" ).append("\n"); 
		query.append("          ,J.TRD_CD" ).append("\n"); 
		query.append("          ,J.RLANE_CD" ).append("\n"); 
		query.append("          ,A4.CRR_CD" ).append("\n"); 
		query.append("          ,J.RE_DIVR_CD" ).append("\n"); 
		query.append("          ,J.VSL_CD" ).append("\n"); 
		query.append("          ,J.SKD_VOY_NO" ).append("\n"); 
		query.append("          ,J.SKD_DIR_CD" ).append("\n"); 
		query.append("          ,J.VPS_PORT_CD" ).append("\n"); 
		query.append("          ,J.YD_CD" ).append("\n"); 
		query.append("          ,J.CLPT_IND_SEQ" ).append("\n"); 
		query.append("	      ,TO_CHAR(J.VPS_ETD_DT,'YYYYMMDDHH24MISS') AS VPS_ETD_DT    " ).append("\n"); 
		query.append("          ,DECODE(L.LEV,'1','OUS','2','R/F','3','OTH') AS JO_STL_ITM_CD   " ).append("\n"); 
		query.append("          ,MIN(J.VSL_CD || J.SKD_VOY_NO || J.SKD_DIR_CD || TO_CHAR(J.VPS_ETD_DT,'YYYYMMDDHH24MI')) OVER (PARTITION BY J.VSL_CD || J.SKD_VOY_NO || J.SKD_DIR_CD) AS VVD_ETD_GROUP	" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("            SELECT LEVEL AS LEV" ).append("\n"); 
		query.append("            FROM DUAL CONNECT BY LEVEL <= 3" ).append("\n"); 
		query.append("         ) L" ).append("\n"); 
		query.append("         ,JOO_LODG_TGT J" ).append("\n"); 
		query.append("         ,BSA_VVD_CRR_PERF A4             " ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("    AND J.STL_TGT_FLG = '1'" ).append("\n"); 
		query.append("    AND J.STL_CLZ_FLG = '0'" ).append("\n"); 
		query.append("	AND (J.REV_YRMON >= '201510' AND J.REV_YRMON <= REPLACE(@[rev_yrmon],'-',''))" ).append("\n"); 
		query.append("    AND J.VSL_CD     = A4.VSL_CD(+) " ).append("\n"); 
		query.append("    AND J.SKD_VOY_NO = A4.SKD_VOY_NO(+) " ).append("\n"); 
		query.append("    AND J.SKD_DIR_CD = A4.SKD_DIR_CD(+) " ).append("\n"); 
		query.append("    AND J.TRD_CD     = A4.TRD_CD(+) " ).append("\n"); 
		query.append("    AND J.RLANE_CD   = A4.RLANE_CD(+) " ).append("\n"); 
		query.append("	#if (${re_divr_cd} == 'R')" ).append("\n"); 
		query.append("    AND J.CRR_CD     = A4.CRR_CD(+)" ).append("\n"); 
		query.append("	AND A4.BSA_OP_JB_CD IN ('001','002','004')" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("	AND A4.BSA_OP_JB_CD IN ('000','003','005')" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    AND A4.CRR_CD(+)  != 'SML' " ).append("\n"); 
		query.append("    AND A4.CRR_BSA_CAPA > 0   " ).append("\n"); 
		query.append("	#if (${trd_cd}!= '')" ).append("\n"); 
		query.append("    AND   J.TRD_CD        =  @[trd_cd]  " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${rlane_cd}!= '')" ).append("\n"); 
		query.append("    AND   J.RLANE_CD      =  @[rlane_cd]  " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${jo_crr_cd}!= '')" ).append("\n"); 
		query.append("    AND   J.CRR_CD     	 =  @[jo_crr_cd]  " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${re_divr_cd}!= '')" ).append("\n"); 
		query.append("    AND   J.RE_DIVR_CD    =  @[re_divr_cd]  " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${skd_dir_cd}!= '')" ).append("\n"); 
		query.append("    AND   J.SKD_DIR_CD    =  @[skd_dir_cd]  " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${vvd_cd}!= '')" ).append("\n"); 
		query.append("    AND   J.VSL_CD||J.SKD_VOY_NO||J.SKD_DIR_CD like @[vvd_cd]||'%'" ).append("\n"); 
		query.append("	#end	" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append(", OUS_TGT2 AS (" ).append("\n"); 
		query.append("    SELECT  T.TRD_CD" ).append("\n"); 
		query.append("           ,T.RLANE_CD" ).append("\n"); 
		query.append("           ,T.CRR_CD" ).append("\n"); 
		query.append("           ,T.RE_DIVR_CD" ).append("\n"); 
		query.append("           ,T.VSL_CD" ).append("\n"); 
		query.append("           ,T.SKD_VOY_NO" ).append("\n"); 
		query.append("           ,T.SKD_DIR_CD" ).append("\n"); 
		query.append("           ,T.VPS_PORT_CD AS PORT" ).append("\n"); 
		query.append("           ,SUBSTR(T.YD_CD,6,2) AS TML" ).append("\n"); 
		query.append("           ,T.CLPT_IND_SEQ AS IND" ).append("\n"); 
		query.append("           ,T.JO_STL_ITM_CD" ).append("\n"); 
		query.append("           ,DECODE(NVL(S.STL_TGT_FLG,'0') + NVL(S.STL_CLZ_FLG,'0'),1,1,2,1,0) AS TGT_FLG" ).append("\n"); 
		query.append("           ,T.VVD_ETD_GROUP " ).append("\n"); 
		query.append("           ,T.VPS_ETD_DT" ).append("\n"); 
		query.append("    FROM OUS_TGT T, JOO_STL_TGT S" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("    AND T.REV_YRMON = S.REV_YRMON(+)" ).append("\n"); 
		query.append("    AND T.REV_YRMON_SEQ = S.REV_YRMON_SEQ(+)" ).append("\n"); 
		query.append("    AND T.JO_STL_ITM_CD = S.JO_STL_ITM_CD(+)" ).append("\n"); 
		query.append("), OUS_TGT3 AS (" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("            '' AS REV_YRMON" ).append("\n"); 
		query.append("           ,T.TRD_CD" ).append("\n"); 
		query.append("           ,T.RLANE_CD" ).append("\n"); 
		query.append("           ,T.CRR_CD" ).append("\n"); 
		query.append("           ,T.RE_DIVR_CD" ).append("\n"); 
		query.append("           ,T.VSL_CD        AS VSL" ).append("\n"); 
		query.append("           ,T.SKD_VOY_NO    AS VOY" ).append("\n"); 
		query.append("           ,T.SKD_DIR_CD    AS DIR" ).append("\n"); 
		query.append("           ,T.PORT" ).append("\n"); 
		query.append("           ,T.TML" ).append("\n"); 
		query.append("           ,T.IND" ).append("\n"); 
		query.append("           ,T.VVD_ETD_GROUP " ).append("\n"); 
		query.append("           ,T.VPS_ETD_DT" ).append("\n"); 
		query.append("           ,T.VSL_CD || T.SKD_VOY_NO || T.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("           ,MAX(DECODE(T.JO_STL_ITM_CD,'OUS',T.TGT_FLG,0)) AS OUS" ).append("\n"); 
		query.append("           ,MAX(DECODE(T.JO_STL_ITM_CD,'R/F',T.TGT_FLG,0)) AS RF" ).append("\n"); 
		query.append("           ,MAX(DECODE(T.JO_STL_ITM_CD,'OTH',T.TGT_FLG,0)) AS OTHER" ).append("\n"); 
		query.append("FROM OUS_TGT2 T" ).append("\n"); 
		query.append("GROUP BY " ).append("\n"); 
		query.append("            T.TRD_CD" ).append("\n"); 
		query.append("           ,T.RLANE_CD" ).append("\n"); 
		query.append("           ,T.CRR_CD" ).append("\n"); 
		query.append("           ,T.RE_DIVR_CD" ).append("\n"); 
		query.append("           ,T.VSL_CD" ).append("\n"); 
		query.append("           ,T.SKD_VOY_NO" ).append("\n"); 
		query.append("           ,T.SKD_DIR_CD" ).append("\n"); 
		query.append("           ,T.PORT" ).append("\n"); 
		query.append("           ,T.TML" ).append("\n"); 
		query.append("           ,T.IND" ).append("\n"); 
		query.append("           ,T.VVD_ETD_GROUP " ).append("\n"); 
		query.append("           ,T.VPS_ETD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT CEIL(COUNT(1)/TO_NUMBER(@[pagerows])) AS TOT_PAGE_CNT" ).append("\n"); 
		query.append("FROM OUS_TGT3" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND OUS * RF * OTHER = 0" ).append("\n"); 

	}
}