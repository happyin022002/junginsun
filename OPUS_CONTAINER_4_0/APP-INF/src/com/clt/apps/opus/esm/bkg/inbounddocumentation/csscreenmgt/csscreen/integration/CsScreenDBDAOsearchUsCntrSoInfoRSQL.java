/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CsScreenDBDAOsearchUsCntrSoInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.05
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.05 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CsScreenDBDAOsearchUsCntrSoInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 고객 응대를 위한 Container별 S/O & W/O 발행 Status 정보를 조회한다.
	  * </pre>
	  */
	public CsScreenDBDAOsearchUsCntrSoInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.integration").append("\n"); 
		query.append("FileName : CsScreenDBDAOsearchUsCntrSoInfoRSQL").append("\n"); 
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
		query.append("SELECT BKG_NO" ).append("\n"); 
		query.append("      ,CNTR_NO" ).append("\n"); 
		query.append("      ,MAX(CNTR_TPSZ_CD) cntr_tpsz_cd" ).append("\n"); 
		query.append("      ,MAX(BND_CD) bnd_cd" ).append("\n"); 
		query.append("      ,MAX(POD_CD) pod_cd" ).append("\n"); 
		query.append("      ,MAX(DEL_CD) del_cd" ).append("\n"); 
		query.append("      ,MAX(DE_TERM_CD) de_term_cd" ).append("\n"); 
		query.append("      ,NVL(MAX(DECODE(SO_TYPE, 'R', STS_CD)), MAX(DECODE(SO_TYPE, 'S',STS_CD))) STS_CD " ).append("\n"); 
		query.append("      ,SUM(ISS_CNT) ISS_CNT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("     SELECT  SO_TYPE" ).append("\n"); 
		query.append("            ,BKG_NO" ).append("\n"); 
		query.append("            ,CNTR_NO" ).append("\n"); 
		query.append("            ,CNTR_TPSZ_CD" ).append("\n"); 
		query.append("            ,BND_CD" ).append("\n"); 
		query.append("            ,ISS_CNT" ).append("\n"); 
		query.append("            ,POD_CD" ).append("\n"); 
		query.append("            ,DEL_CD" ).append("\n"); 
		query.append("            ,STS_CD" ).append("\n"); 
		query.append("            ,DE_TERM_CD" ).append("\n"); 
		query.append("     FROM " ).append("\n"); 
		query.append("     (" ).append("\n"); 
		query.append("         SELECT 'S'                              AS SO_TYPE" ).append("\n"); 
		query.append("               ,SORD.TRSP_SO_OFC_CTY_CD               AS SO_OFC_CTY_CD" ).append("\n"); 
		query.append("               ,SORD.TRSP_SO_SEQ                      AS SO_SEQ" ).append("\n"); 
		query.append("               ,SORD.BKG_NO                           AS BKG_NO" ).append("\n"); 
		query.append("               ,SORD.EQ_NO                            AS CNTR_NO           -- CONTAINER NO" ).append("\n"); 
		query.append("               ,SORD.EQ_TPSZ_CD                       AS CNTR_TPSZ_CD       -- TP/SZ" ).append("\n"); 
		query.append("               ,'I/B'                            AS BND_CD              -- BOUND" ).append("\n"); 
		query.append("               ,SUM(DECODE(SORD.TRSP_SO_STS_CD, 'C', 1, 'I', 1, 'R', 1, 0)) OVER (PARTITION BY SORD.BKG_NO, SORD.EQ_NO , SORD.TRSP_BND_CD)  AS ISS_CNT  -- S/O ISSUED  " ).append("\n"); 
		query.append("               ,SORD.POD_CD                           AS POD_CD         -- POD" ).append("\n"); 
		query.append("               ,SORD.DEL_CD                           AS DEL_CD         -- DEL" ).append("\n"); 
		query.append("               ,SORD.BKG_RCVDE_TERM_CD                AS DE_TERM_CD     -- DELIEVERY TERM" ).append("\n"); 
		query.append("               ,CID.INTG_CD_VAL_DP_DESC                AS STS_CD" ).append("\n"); 
		query.append("               ,MAX(SORD.TRSP_SO_SEQ) OVER (PARTITION BY SORD.BKG_NO,SORD.EQ_NO,SORD.TRSP_BND_CD) MAX_SO_SEQ" ).append("\n"); 
		query.append("         FROM TRS_TRSP_SVC_ORD SORD" ).append("\n"); 
		query.append("             ,COM_INTG_CD_DTL   CID" ).append("\n"); 
		query.append("         WHERE SORD.BKG_NO             = @[bkg_no]" ).append("\n"); 
		query.append("         AND   SORD.TRSP_BND_CD        = 'I'" ).append("\n"); 
		query.append("         AND   SORD.DELT_FLG           = 'N'" ).append("\n"); 
		query.append("         AND   CID.INTG_CD_VAL_CTNT(+) = SORD.TRSP_SO_STS_CD" ).append("\n"); 
		query.append("         AND   CID.INTG_CD_ID(+)       = 'CD00275'" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("     WHERE SO_SEQ = MAX_SO_SEQ" ).append("\n"); 
		query.append("     UNION ALL" ).append("\n"); 
		query.append("     SELECT 'R'                                          AS SO_TYPE     -- 우선" ).append("\n"); 
		query.append("           ,ORD.BKG_NO                                   AS BKG_NO" ).append("\n"); 
		query.append("           ,ORD.EQ_NO                                    AS EQ_NO" ).append("\n"); 
		query.append("           ,ORD.EQ_TPSZ_CD                               AS CNTR_TPSZ_CD      -- TP/SZ" ).append("\n"); 
		query.append("           ,'I/B'                                        AS BND_CD" ).append("\n"); 
		query.append("           ,SUM(DECODE(ORD.TRSP_SO_STS_CD, 'C', 1, 'I', 1, 'R', 1, 0)) OVER (PARTITION BY ORD.BKG_NO, ORD.EQ_NO , ORD.TRSP_BND_CD, ORD.TRSP_SO_SEQ) AS ISS_CNT" ).append("\n"); 
		query.append("           ,ORD.POD_CD                                   AS POD_CD" ).append("\n"); 
		query.append("           ,ORD.DEL_CD                                   AS DEL_CD          " ).append("\n"); 
		query.append("           ,CID.INTG_CD_VAL_DP_DESC                      AS STS_CD" ).append("\n"); 
		query.append("           ,ORD.BKG_RCVDE_TERM_CD                        AS DE_TERM_CD" ).append("\n"); 
		query.append("     FROM TRS_TRSP_RAIL_BIL_ORD  ORD" ).append("\n"); 
		query.append("         ,COM_INTG_CD_DTL        CID" ).append("\n"); 
		query.append("     WHERE ORD.BKG_NO              = @[bkg_no]" ).append("\n"); 
		query.append("     AND   ORD.TRSP_BND_CD         = 'I'" ).append("\n"); 
		query.append("     AND   ORD.DELT_FLG            = 'N'" ).append("\n"); 
		query.append("     AND   CID.INTG_CD_VAL_CTNT(+) = ORD.TRSP_SO_STS_CD" ).append("\n"); 
		query.append("     AND   CID.INTG_CD_ID(+)       = 'CD00275'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY BKG_NO,CNTR_NO" ).append("\n"); 

	}
}