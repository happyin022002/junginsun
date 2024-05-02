/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BSAManageDBDAOSearchSlotCostListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.06
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.06 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BSAManageDBDAOSearchSlotCostListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BSAManageDBDAOSearchSlotCostListRSQL
	  * </pre>
	  */
	public BSAManageDBDAOSearchSlotCostListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("coblane",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("txtsdate",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rdotype",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cobdir",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cobtrade",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.integration").append("\n"); 
		query.append("FileName : BSAManageDBDAOSearchSlotCostListRSQL").append("\n"); 
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
		query.append("      RANK() OVER (ORDER BY A.TRD_CD||A.RLANE_CD||A.DIR_CD||A.BSA_SLT_COST_TP_CD) GRP," ).append("\n"); 
		query.append("	  MAX(A.SLT_PRC_SEQ) OVER(PARTITION BY A.TRD_CD||A.RLANE_CD||A.DIR_CD||A.BSA_SLT_COST_TP_CD) MAXSEQ, " ).append("\n"); 
		query.append("	  A.TRD_CD, " ).append("\n"); 
		query.append("	  A.RLANE_CD, " ).append("\n"); 
		query.append("	  A.DIR_CD, " ).append("\n"); 
		query.append("	  A.BSA_SLT_COST_TP_CD, " ).append("\n"); 
		query.append("	  A.SLT_PRC_SEQ, " ).append("\n"); 
		query.append("	  A.VVD_CD, " ).append("\n"); 
		query.append("	  A.BSA_SLT_PRC_FM_DT, " ).append("\n"); 
		query.append("	  A.BSA_SLT_PRC_TO_DT, " ).append("\n"); 
		query.append("	  A.CO_BFR_SUB_CAPA, " ).append("\n"); 
		query.append("	  A.SUB_CHTR_BSA_CAPA, " ).append("\n"); 
		query.append("	  A.CRS_CHTR_BSA_CAPA, " ).append("\n"); 
		query.append("	  SUM(CASE WHEN A.CO_BFR_SUB_CAPA = 0  AND C.SRC_BZC_CAPA > 0 THEN 1 ELSE 0 END) AS BZC_FLG, " ).append("\n"); 
		query.append("	  SUM(CASE WHEN A.SUB_CHTR_BSA_CAPA = 0 AND C.SRC_SUB_CAPA > 0 THEN 1 ELSE 0 END) AS SUB_FLG, " ).append("\n"); 
		query.append("	  SUM(CASE WHEN A.CRS_CHTR_BSA_CAPA = 0 AND C.SRC_CRS_CAPA > 0 THEN 1 ELSE 0 END) AS CRS_FLG" ).append("\n"); 
		query.append("	  #set($count = 0) " ).append("\n"); 
		query.append("	  #foreach( ${keys} in ${keyList}) " ).append("\n"); 
		query.append("		#if (${keys.bsaOpJbCd}=='001')" ).append("\n"); 
		query.append("		,MAX(CASE WHEN B.BSA_OP_JB_CD = '${keys.bsaOpJbCd}' AND B.CRR_CD ='${keys.crrCd}'" ).append("\n"); 
		query.append("           		 THEN B.SLT_PRC_CAPA ELSE 0 END) AS SLT_PRC_CAPA$count" ).append("\n"); 
		query.append("	   	,SUM(CASE WHEN B.BSA_OP_JB_CD = '${keys.bsaOpJbCd}' AND B.CRR_CD ='${keys.crrCd}' AND C.VOP_CD = COM_ConstantMgr_PKG.COM_getCompanyCode_FNC" ).append("\n"); 
		query.append("		                          AND ((B.SLT_PRC_CAPA = 0 AND C.CRR_BSA_CAPA$count > 0) " ).append("\n"); 
		query.append("				                    OR (B.SLT_PRC_CAPA > 0 AND C.CRR_BSA_CAPA$count = 0)) " ).append("\n"); 
		query.append("				 THEN 1 ELSE 0 END) AS CAPA_FLG$count  " ).append("\n"); 
		query.append("				 #set($count = $count + 1)				" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("		,MAX(CASE WHEN B.BSA_OP_JB_CD = '${keys.bsaOpJbCd}' AND B.CRR_CD ='${keys.crrCd}'" ).append("\n"); 
		query.append("           		 THEN B.SLT_PRC_CAPA ELSE 0 END) AS SLT_PRC_CAPA$count" ).append("\n"); 
		query.append("	   	,SUM(CASE WHEN B.BSA_OP_JB_CD = '${keys.bsaOpJbCd}' AND B.CRR_CD ='${keys.crrCd}'" ).append("\n"); 
		query.append("		                          AND ((B.SLT_PRC_CAPA = 0 AND C.CRR_BSA_CAPA$count > 0) " ).append("\n"); 
		query.append("				                    OR (B.SLT_PRC_CAPA > 0 AND C.CRR_BSA_CAPA$count = 0)) " ).append("\n"); 
		query.append("				 THEN 1 ELSE 0 END) AS CAPA_FLG$count  	" ).append("\n"); 
		query.append("				 #set($count = $count + 1)			" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	  #end" ).append("\n"); 
		query.append("			--예) ,SUM(CASE WHEN b.bsa_op_jb_cd = '001' AND b.crr_cd ='ACL' THEN b.slt_prc_capa ELSE 0 END) AS slt_prc_capa0 " ).append("\n"); 
		query.append("			--예) ,SUM(CASE WHEN b.bsa_op_jb_cd='001' AND b.crr_cd ='ACL' AND ((b.slt_prc_capa = 0 AND c.crr_bsa_capa0 > 0) OR (b.slt_prc_capa > 0 AND c.crr_bsa_capa0 = 0)) THEN 1 ELSE 0 END ) AS flg0 " ).append("\n"); 
		query.append("FROM    " ).append("\n"); 
		query.append("    BSA_SLT_PRC     A " ).append("\n"); 
		query.append("   ,BSA_SLT_PRC_CRR B " ).append("\n"); 
		query.append("   ,(SELECT  " ).append("\n"); 
		query.append("          MIN(K.BSA_FM_DT) AS BSA_FM_DT " ).append("\n"); 
		query.append("         ,MAX(K.BSA_TO_DT) AS BSA_TO_DT " ).append("\n"); 
		query.append("         ,K.TRD_CD " ).append("\n"); 
		query.append("         ,K.RLANE_CD " ).append("\n"); 
		query.append("         ,K.DIR_CD" ).append("\n"); 
		query.append("		 ,K.VOP_CD" ).append("\n"); 
		query.append("         ,SUM(DECODE(K.VOP_CD,'OTH',K.CO_BSA_BFR_SUB_CAPA,0)) AS SRC_BZC_CAPA " ).append("\n"); 
		query.append("         ,SUM(DECODE(K.BSA_OP_JB_CD,'003',K.CRR_BSA_CAPA,0)) AS SRC_SUB_CAPA " ).append("\n"); 
		query.append("         ,SUM(DECODE(K.BSA_OP_JB_CD,'005',K.CRR_BSA_CAPA,0)) AS SRC_CRS_CAPA " ).append("\n"); 
		query.append("        #set($count = 0) " ).append("\n"); 
		query.append("        #foreach( ${keys} in ${keyList}) " ).append("\n"); 
		query.append("	       ,SUM(CASE WHEN K.BSA_OP_JB_CD = '${keys.bsaOpJbCd}' AND K.CRR_CD ='${keys.crrCd}'" ).append("\n"); 
		query.append("                   THEN K.CRR_BSA_CAPA ELSE 0 END) AS CRR_BSA_CAPA$count				" ).append("\n"); 
		query.append("          #set($count = $count + 1)" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        --예),SUM(CASE WHEN k.bsa_op_jb_cd = '001' AND k.crr_cd ='ACL' THEN k.crr_bsa_capa ELSE 0 END) AS crr_bsa_capa0 " ).append("\n"); 
		query.append("      FROM    " ).append("\n"); 
		query.append("          (SELECT  " ).append("\n"); 
		query.append("                 Z.BSA_FM_DT " ).append("\n"); 
		query.append("                ,Z.BSA_TO_DT " ).append("\n"); 
		query.append("                ,Z.TRD_CD " ).append("\n"); 
		query.append("                ,Z.VOP_CD " ).append("\n"); 
		query.append("                ,Z.RLANE_CD " ).append("\n"); 
		query.append("                ,Z.DIR_CD " ).append("\n"); 
		query.append("                ,Z.BSA_OP_JB_CD /* 003,005일때는 선사와 상관없이 Lane,Dir별로 있는지 Check */ " ).append("\n"); 
		query.append("                ,Z.CRR_CD " ).append("\n"); 
		query.append("                ,MAX(Z.CO_BSA_BFR_SUB_CAPA) AS CO_BSA_BFR_SUB_CAPA /* J OTHER,SC일 경우 */ " ).append("\n"); 
		query.append("                ,SUM(Z.CRR_BSA_CAPA) AS CRR_BSA_CAPA " ).append("\n"); 
		query.append("           FROM    " ).append("\n"); 
		query.append("                (SELECT  " ).append("\n"); 
		query.append("                        X.BSA_FM_DT " ).append("\n"); 
		query.append("                       ,X.BSA_TO_DT " ).append("\n"); 
		query.append("                       ,X.TRD_CD " ).append("\n"); 
		query.append("                       ,X.VOP_CD " ).append("\n"); 
		query.append("                       ,X.RLANE_CD " ).append("\n"); 
		query.append("                       ,X.DIR_CD " ).append("\n"); 
		query.append("                       ,Y.BSA_OP_JB_CD " ).append("\n"); 
		query.append("                       ,Y.CRR_CD " ).append("\n"); 
		query.append("                       ,X.CO_BSA_BFR_SUB_CAPA " ).append("\n"); 
		query.append("                       ,Y.CRR_BSA_CAPA " ).append("\n"); 
		query.append("                FROM    BSA_JNT_OP_BZC      X " ).append("\n"); 
		query.append("                       ,BSA_JNT_OP_CRR_CAPA Y " ).append("\n"); 
		query.append("                WHERE   X.BSA_SEQ   = Y.BSA_SEQ " ).append("\n"); 
		query.append("                AND     X.RLANE_CD  = Y.RLANE_CD " ).append("\n"); 
		query.append("                AND     X.DIR_CD    = Y.DIR_CD " ).append("\n"); 
		query.append("                AND     X.TRD_CD    = Y.TRD_CD " ).append("\n"); 
		query.append("                AND     X.VOP_CD    = Y.VOP_CD " ).append("\n"); 
		query.append("                AND     X.VSL_CAPA  = Y.VSL_CAPA " ).append("\n"); 
		query.append("                AND     Y.BSA_OP_CD = 'J' " ).append("\n"); 
		query.append("                AND     Y.BSA_OP_JB_CD IN ('001','002','003','004','005') " ).append("\n"); 
		query.append("                UNION ALL " ).append("\n"); 
		query.append("                SELECT  " ).append("\n"); 
		query.append("                       X.BSA_FM_DT " ).append("\n"); 
		query.append("                       ,X.BSA_TO_DT " ).append("\n"); 
		query.append("                       ,X.TRD_CD " ).append("\n"); 
		query.append("                       ,'OTH' AS VOP_CD " ).append("\n"); 
		query.append("                       ,X.RLANE_CD " ).append("\n"); 
		query.append("                       ,X.DIR_CD " ).append("\n"); 
		query.append("                       ,Y.BSA_OP_JB_CD " ).append("\n"); 
		query.append("                       ,Y.CRR_CD " ).append("\n"); 
		query.append("                       ,X.CO_BSA_BFR_SUB_CAPA " ).append("\n"); 
		query.append("                       ,Y.CRR_BSA_CAPA " ).append("\n"); 
		query.append("                FROM    BSA_SLT_CHTR_BZC      X " ).append("\n"); 
		query.append("                       ,BSA_SLT_CHTR_CRR_CAPA Y " ).append("\n"); 
		query.append("                WHERE   X.BSA_SEQ   = Y.BSA_SEQ " ).append("\n"); 
		query.append("                AND     X.RLANE_CD  = Y.RLANE_CD " ).append("\n"); 
		query.append("                AND     X.DIR_CD    = Y.DIR_CD " ).append("\n"); 
		query.append("                AND     X.TRD_CD    = Y.TRD_CD " ).append("\n"); 
		query.append("                AND     X.VSL_SEQ   = Y.VSL_SEQ " ).append("\n"); 
		query.append("                AND     Y.BSA_OP_CD = 'S' " ).append("\n"); 
		query.append("                AND     Y.BSA_OP_JB_CD IN ('002','003','004','005') " ).append("\n"); 
		query.append("               ) Z " ).append("\n"); 
		query.append("           GROUP BY " ).append("\n"); 
		query.append("                   Z.BSA_FM_DT " ).append("\n"); 
		query.append("                  ,Z.BSA_TO_DT " ).append("\n"); 
		query.append("                  ,Z.TRD_CD " ).append("\n"); 
		query.append("                  ,Z.VOP_CD " ).append("\n"); 
		query.append("                  ,Z.RLANE_CD " ).append("\n"); 
		query.append("                  ,Z.DIR_CD " ).append("\n"); 
		query.append("                  ,Z.BSA_OP_JB_CD " ).append("\n"); 
		query.append("                  ,Z.CRR_CD " ).append("\n"); 
		query.append("          ) K " ).append("\n"); 
		query.append("        GROUP BY " ).append("\n"); 
		query.append("--		          K.BSA_FM_DT " ).append("\n"); 
		query.append("--		         ,K.BSA_TO_DT " ).append("\n"); 
		query.append("                K.TRD_CD " ).append("\n"); 
		query.append("               ,K.RLANE_CD " ).append("\n"); 
		query.append("               ,K.DIR_CD" ).append("\n"); 
		query.append("			   ,K.VOP_CD	  " ).append("\n"); 
		query.append("       ) C " ).append("\n"); 
		query.append("WHERE   A.TRD_CD             = B.TRD_CD " ).append("\n"); 
		query.append("AND     A.RLANE_CD           = B.RLANE_CD " ).append("\n"); 
		query.append("AND     A.DIR_CD             = B.DIR_CD " ).append("\n"); 
		query.append("AND     A.BSA_SLT_COST_TP_CD = B.BSA_SLT_COST_TP_CD " ).append("\n"); 
		query.append("AND     A.SLT_PRC_SEQ        = B.SLT_PRC_SEQ " ).append("\n"); 
		query.append("AND     B.BSA_SLT_PRC_FM_DT <= C.BSA_FM_DT (+) " ).append("\n"); 
		query.append("AND     B.BSA_SLT_PRC_TO_DT >= C.BSA_TO_DT (+) " ).append("\n"); 
		query.append("AND     B.TRD_CD             = C.TRD_CD (+) " ).append("\n"); 
		query.append("AND     B.RLANE_CD           = C.RLANE_CD (+) " ).append("\n"); 
		query.append("AND     B.DIR_CD             = C.DIR_CD (+) " ).append("\n"); 
		query.append("AND     A.BSA_SLT_PRC_TO_DT >= @[txtsdate] " ).append("\n"); 
		query.append("#if (${cobtrade} !='') " ).append("\n"); 
		query.append("  AND     A.TRD_CD = @[cobtrade] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${coblane}!='') " ).append("\n"); 
		query.append("  AND     A.RLANE_CD = @[coblane] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cobdir}!='') " ).append("\n"); 
		query.append("  AND     A.DIR_CD = @[cobdir] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rdotype}!='') " ).append("\n"); 
		query.append("  AND     A.BSA_SLT_COST_TP_CD = @[rdotype] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY " ).append("\n"); 
		query.append("       A.TRD_CD, " ).append("\n"); 
		query.append("       A.RLANE_CD, " ).append("\n"); 
		query.append("       A.DIR_CD, " ).append("\n"); 
		query.append("       A.BSA_SLT_COST_TP_CD, " ).append("\n"); 
		query.append("       A.SLT_PRC_SEQ, " ).append("\n"); 
		query.append("       A.VVD_CD, " ).append("\n"); 
		query.append("       A.BSA_SLT_PRC_FM_DT, " ).append("\n"); 
		query.append("       A.BSA_SLT_PRC_TO_DT, " ).append("\n"); 
		query.append("       A.CO_BFR_SUB_CAPA, " ).append("\n"); 
		query.append("       A.SUB_CHTR_BSA_CAPA, " ).append("\n"); 
		query.append("       A.CRS_CHTR_BSA_CAPA " ).append("\n"); 
		query.append("ORDER BY " ).append("\n"); 
		query.append("       A.TRD_CD, " ).append("\n"); 
		query.append("       A.RLANE_CD, " ).append("\n"); 
		query.append("       A.DIR_CD, " ).append("\n"); 
		query.append("       A.SLT_PRC_SEQ, " ).append("\n"); 
		query.append("       A.BSA_SLT_PRC_FM_DT, " ).append("\n"); 
		query.append("       A.BSA_SLT_COST_TP_CD,  " ).append("\n"); 
		query.append("       A.BSA_SLT_PRC_TO_DT" ).append("\n"); 

	}
}