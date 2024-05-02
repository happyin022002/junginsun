/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : DwellNotificationDBDAOSearchMSExptRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.20
*@LastModifier : 홍성필
*@LastVersion : 1.0
* 2017.01.20 홍성필
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.dwellnotification.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Hong Seong Pil
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DwellNotificationDBDAOSearchMSExptRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TMC(Team Management Concept) MS용 Dwell List 조회
	  * </pre>
	  */
	public DwellNotificationDBDAOSearchMSExptRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("snt_flg_",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_cd_",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cs_grp_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd_",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.dwellnotification.integration").append("\n"); 
		query.append("FileName : DwellNotificationDBDAOSearchMSExptRSQL").append("\n"); 
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
		query.append("SELECT COP_NO" ).append("\n"); 
		query.append("     , CNTR_NO" ).append("\n"); 
		query.append("     , CNTR_TPSZ_CD" ).append("\n"); 
		query.append("     , BKG_NO" ).append("\n"); 
		query.append("     , VVD" ).append("\n"); 
		query.append("     , POL_CD" ).append("\n"); 
		query.append("     , POD_CD" ).append("\n"); 
		query.append("     , DEL_CD" ).append("\n"); 
		query.append("     , ESTM_ID" ).append("\n"); 
		query.append("     , ESTM_OC " ).append("\n"); 
		query.append("     , ACT_ID" ).append("\n"); 
		query.append("     , ACT_OC " ).append("\n"); 
		query.append("     , SUBSTR(NUMTODSINTERVAL(ESTM_ID - ESTM_OC, 'DAY'), 9, 11) ESTM_TT " ).append("\n"); 
		query.append("     , SUBSTR(NUMTODSINTERVAL(ACT_ID - ACT_OC, 'DAY'), 9, 11) ACT_TT" ).append("\n"); 
		query.append("     , SUBSTR(NUMTODSINTERVAL(ACT_ID - ACT_OC, 'DAY') - NUMTODSINTERVAL(ESTM_ID - ESTM_OC, 'DAY'), 9, 11) DIFF" ).append("\n"); 
		query.append("     , SNT_FLG" ).append("\n"); 
		query.append("     , TO_CHAR(SYSDATE, 'YYYYMMDD') ACT_DT1" ).append("\n"); 
		query.append("     , TO_CHAR(SYSDATE, 'HH24MISS') ACT_DT2" ).append("\n"); 
		query.append("     , MS_DWLL_RSN_CD" ).append("\n"); 
		query.append("     , MS_DWLL_RMK" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT COP_NO" ).append("\n"); 
		query.append("         , MAX(CNTR_NO) CNTR_NO" ).append("\n"); 
		query.append("         , MAX(CNTR_TPSZ_CD) CNTR_TPSZ_CD" ).append("\n"); 
		query.append("         , MAX(BKG_NO) BKG_NO" ).append("\n"); 
		query.append("         , MAX(VVD) VVD" ).append("\n"); 
		query.append("         , MAX(POL_CD) POL_CD" ).append("\n"); 
		query.append("         , MAX(POD_CD) POD_CD" ).append("\n"); 
		query.append("         , MAX(DEL_CD) DEL_CD" ).append("\n"); 
		query.append("         , MAX(DECODE(STND_EDI_STS_CD, 'OAN', ESTM_DT)) ESTM_ID" ).append("\n"); 
		query.append("         , MAX(DECODE(STND_EDI_STS_CD, 'IO', ESTM_DT)) ESTM_OC " ).append("\n"); 
		query.append("         , MAX(DECODE(STND_EDI_STS_CD, 'OAN', ACT_DT)) ACT_ID " ).append("\n"); 
		query.append("         , MAX(DECODE(STND_EDI_STS_CD, 'IO', ACT_DT)) ACT_OC" ).append("\n"); 
		query.append("         , MAX(SNT_FLG) SNT_FLG" ).append("\n"); 
		query.append("         , MAX(MS_DWLL_RSN_CD) MS_DWLL_RSN_CD" ).append("\n"); 
		query.append("         , MAX(MS_DWLL_RMK) MS_DWLL_RMK" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("        SELECT RANK() OVER (PARTITION BY H.COP_NO, D.STND_EDI_STS_CD ORDER BY D.COP_DTL_SEQ) ASC_RANK" ).append("\n"); 
		query.append("             , RANK() OVER (PARTITION BY H.COP_NO, D.STND_EDI_STS_CD ORDER BY D.COP_DTL_SEQ DESC) DESC_RANK" ).append("\n"); 
		query.append("             , D.STND_EDI_STS_CD" ).append("\n"); 
		query.append("             , D.ACT_CD" ).append("\n"); 
		query.append("             , D.ACT_DT" ).append("\n"); 
		query.append("             , D.ESTM_DT" ).append("\n"); 
		query.append("             , H.COP_NO" ).append("\n"); 
		query.append("             , H.CNTR_NO" ).append("\n"); 
		query.append("             , H.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("             , H.BKG_NO" ).append("\n"); 
		query.append("             , H.TRNK_VSL_CD||H.TRNK_SKD_VOY_NO||H.TRNK_SKD_DIR_CD VVD" ).append("\n"); 
		query.append("             , SUBSTR(H.POL_NOD_CD, 1, 5) POL_CD" ).append("\n"); 
		query.append("             , SUBSTR(H.POD_NOD_CD, 1, 5) POD_CD" ).append("\n"); 
		query.append("             , SUBSTR(H.DEL_NOD_CD, 1, 5) DEL_CD" ).append("\n"); 
		query.append("             , NVL2(" ).append("\n"); 
		query.append("             (SELECT MAX(EDI_STS_CD) FROM SCE_EDI_SND_RSLT R WHERE R.EDI_GRP_CD = @[cs_grp_id] AND H.BKG_NO = R.BKG_NO AND H.CNTR_NO = R.CNTR_NO AND EDI_STS_CD = 'SD'), 'Y','N') SNT_FLG" ).append("\n"); 
		query.append("             , C.INTG_CD_VAL_DP_DESC MS_DWLL_RSN_CD" ).append("\n"); 
		query.append("             , C.MS_DWLL_RMK" ).append("\n"); 
		query.append("          FROM SCE_COP_HDR H" ).append("\n"); 
		query.append("             , SCE_COP_DTL D" ).append("\n"); 
		query.append("             , BKG_BOOKING B" ).append("\n"); 
		query.append("             , ( 																													" ).append("\n"); 
		query.append("                SELECT N.COP_NO, INTG_CD_VAL_DP_DESC, N.MS_DWLL_RMK 																					" ).append("\n"); 
		query.append("                  FROM SCE_MS_DWLL_NTFC N, COM_INTG_CD_DTL CD 				  																							" ).append("\n"); 
		query.append("                 WHERE 1=1" ).append("\n"); 
		query.append("                   AND INTG_CD_ID = 'CD03456'" ).append("\n"); 
		query.append("                   AND N.MS_DWLL_RSN_CD	= CD.INTG_CD_VAL_CTNT																									" ).append("\n"); 
		query.append("               ) C" ).append("\n"); 
		query.append("     WHERE 1=1" ).append("\n"); 
		query.append("       AND H.COP_NO = D.COP_NO" ).append("\n"); 
		query.append("       AND H.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("       AND H.COP_STS_CD <> 'X'" ).append("\n"); 
		query.append("       AND B.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("       AND H.CNTR_NO <> 'SMCU0000000'" ).append("\n"); 
		query.append("       AND H.COP_NO = C.COP_NO(+)" ).append("\n"); 
		query.append("       AND B.BKG_NO IN (SELECT  IB.BKG_NO" ).append("\n"); 
		query.append("                      FROM    BKG_CUSTOMER IB, BKG_BOOKING BB, EDI_GRP_CUST MS" ).append("\n"); 
		query.append("                      WHERE   1=1" ).append("\n"); 
		query.append("                      AND MS.EDI_GRP_CD = @[cs_grp_id]" ).append("\n"); 
		query.append("                      AND IB.CUST_CNT_CD       = MS.CUST_CNT_CD  " ).append("\n"); 
		query.append("                      AND IB.CUST_SEQ          = MS.CUST_SEQ" ).append("\n"); 
		query.append("                      AND MS.CGO_TRC_SVC_FLG   = 'Y'" ).append("\n"); 
		query.append("                      AND MS.IB_SVC_FLG        = 'N'" ).append("\n"); 
		query.append("                      AND NVL(MS.BKG_CUST_TP_DESC, IB.BKG_CUST_TP_CD) LIKE '%'||IB.BKG_CUST_TP_CD||'%'" ).append("\n"); 
		query.append("					  AND IB.BKG_NO            = BB.BKG_NO" ).append("\n"); 
		query.append("					  " ).append("\n"); 
		query.append("					  UNION" ).append("\n"); 
		query.append("					     " ).append("\n"); 
		query.append("                      SELECT  IB.BKG_NO" ).append("\n"); 
		query.append("                      FROM    BKG_BOOKING IB, EDI_GRP_CUST MS  " ).append("\n"); 
		query.append("                      WHERE   1=1" ).append("\n"); 
		query.append("                      AND MS.EDI_GRP_CD = @[cs_grp_id]" ).append("\n"); 
		query.append("                      AND MS.SC_NO             = IB.SC_NO" ).append("\n"); 
		query.append("                      AND MS.CGO_TRC_SVC_FLG   = 'Y'" ).append("\n"); 
		query.append("                      AND MS.IB_SVC_FLG        = 'N'" ).append("\n"); 
		query.append("                      AND MS.BKG_CTRT_DIV_CD   = '1'" ).append("\n"); 
		query.append("				      )" ).append("\n"); 
		query.append("		 " ).append("\n"); 
		query.append("		 /* condition - BKG_NO */" ).append("\n"); 
		query.append("		 #if(${bl_no_} != '')" ).append("\n"); 
		query.append("		 AND (H.BKG_NO IN (" ).append("\n"); 
		query.append("		 	#foreach( $ele in ${bl_no_})" ).append("\n"); 
		query.append("		 	#if($velocityCount == 1) '$ele'" ).append("\n"); 
		query.append("		 	#else ,'$ele'" ).append("\n"); 
		query.append("	     	#end" ).append("\n"); 
		query.append("	     	#end ))" ).append("\n"); 
		query.append("		 #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		 /* condition - CNTR_NO */" ).append("\n"); 
		query.append("		 #if(${cntr_no_} != '')" ).append("\n"); 
		query.append("		 AND (H.CNTR_NO IN (" ).append("\n"); 
		query.append("		 	#foreach( $ele in ${cntr_no_})" ).append("\n"); 
		query.append("		 	#if($velocityCount == 1) '$ele'" ).append("\n"); 
		query.append("		 	#else ,'$ele'" ).append("\n"); 
		query.append("	     	#end" ).append("\n"); 
		query.append("	     	#end ))" ).append("\n"); 
		query.append("		 #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		 /* condition - POD_CD */" ).append("\n"); 
		query.append("		 #if(${pod_cd_} != '')" ).append("\n"); 
		query.append("         AND B.POD_NOD_CD LIKE UPPER(@[pod_cd_]||'%')" ).append("\n"); 
		query.append("		 #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		 /* condition - DEL_CD */" ).append("\n"); 
		query.append("		 #if(${del_cd_} != '')" ).append("\n"); 
		query.append("         AND B.DEL_NOD_CD LIKE UPPER(@[del_cd_]||'%')" ).append("\n"); 
		query.append("		 #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		 /* condition - VVD */" ).append("\n"); 
		query.append("		 #if(${vvd_} != '')" ).append("\n"); 
		query.append("         AND EXISTS (SELECT 'X' FROM BKG_VVD V WHERE B.BKG_NO = V.BKG_NO AND (VSL_CD, SKD_VOY_NO, SKD_DIR_CD) IN " ).append("\n"); 
		query.append("						(" ).append("\n"); 
		query.append("						 #foreach( $ele in ${vvd_})" ).append("\n"); 
		query.append("		 				 #if($velocityCount == 1) (SUBSTR('$ele',1,4), SUBSTR('$ele',5,4), SUBSTR('$ele',9,1))" ).append("\n"); 
		query.append("		 				 #else ,(SUBSTR('$ele',1,4), SUBSTR('$ele',5,4), SUBSTR('$ele',9,1))" ).append("\n"); 
		query.append("	     				 #end" ).append("\n"); 
		query.append("	     				 #end	" ).append("\n"); 
		query.append("			 			) " ).append("\n"); 
		query.append("					 )" ).append("\n"); 
		query.append("	     #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       AND D.STND_EDI_STS_CD IN ('IO', 'OAN')" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("      AND (STND_EDI_STS_CD='OAN' AND ASC_RANK=1) OR (STND_EDI_STS_CD='IO' AND DESC_RANK=1)" ).append("\n"); 
		query.append("    GROUP BY COP_NO  " ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("WHERE 1=1 " ).append("\n"); 
		query.append("  /* condition - SNT_FLG */" ).append("\n"); 
		query.append("  #if(${snt_flg_} != 'A')" ).append("\n"); 
		query.append("  AND SNT_FLG = @[snt_flg_]" ).append("\n"); 
		query.append("  #end" ).append("\n"); 

	}
}