/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BLDocumentationCMDBDAOSearchPreCycleCntrInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.11.30
*@LastModifier : 
*@LastVersion : 1.0
* 2016.11.30 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationCMDBDAOSearchPreCycleCntrInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchPreCycleCntrInfo
	  * </pre>
	  */
	public BLDocumentationCMDBDAOSearchPreCycleCntrInfoRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_cyc_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationCMDBDAOSearchPreCycleCntrInfoRSQL").append("\n"); 
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
		query.append("SELECT CNTR.BKG_NO" ).append("\n"); 
		query.append("      ,CNTR.CNTR_NO" ).append("\n"); 
		query.append("      ,MOVE.MVMT_STS_CD" ).append("\n"); 
		query.append("      ,(SELECT DECODE(COUNT(*), 0, 'N', 'Y')" ).append("\n"); 
		query.append("          FROM BKG_DOC_PROC_SKD K" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND K.BKG_NO = CNTR.BKG_NO" ).append("\n"); 
		query.append("           AND K.BKG_DOC_PROC_TP_CD = 'CNTCFM'" ).append("\n"); 
		query.append("           AND DOC_PERF_DELT_FLG = 'N' ) AS CFM_FLG" ).append("\n"); 
		query.append("  FROM BKG_CONTAINER CNTR" ).append("\n"); 
		query.append("      ,(SELECT /*+ INDEX_DESC(CTM_MOVEMENT XUK1CTM_MOVEMENT) */ " ).append("\n"); 
		query.append("               CNTR_NO" ).append("\n"); 
		query.append("              ,CNMV_CYC_NO" ).append("\n"); 
		query.append("              ,MVMT_STS_CD" ).append("\n"); 
		query.append("          FROM CTM_MOVEMENT" ).append("\n"); 
		query.append("         WHERE CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("           AND MVMT_STS_CD = 'OP'" ).append("\n"); 
		query.append("           AND ROWNUM = 1) MOVE" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("  AND MOVE.CNMV_CYC_NO <> @[cnmv_cyc_no]" ).append("\n"); 
		query.append("  AND MOVE.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("  AND MOVE.CNTR_NO = CNTR.CNTR_NO" ).append("\n"); 
		query.append("  AND CNTR.CNMV_CYC_NO IN (@[cnmv_cyc_no] -1,'9999','9998')" ).append("\n"); 
		query.append("  AND CNTR.CNMV_STS_CD ='OP'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT CNTR.BKG_NO" ).append("\n"); 
		query.append("      ,CNTR.CNTR_NO" ).append("\n"); 
		query.append("      ,MOVE.MVMT_STS_CD" ).append("\n"); 
		query.append("      ,(SELECT DECODE(COUNT(*), 0, 'N', 'Y')" ).append("\n"); 
		query.append("          FROM BKG_DOC_PROC_SKD K" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND K.BKG_NO = CNTR.BKG_NO" ).append("\n"); 
		query.append("           AND K.BKG_DOC_PROC_TP_CD = 'CNTCFM'" ).append("\n"); 
		query.append("           AND DOC_PERF_DELT_FLG = 'N' ) AS CFM_FLG" ).append("\n"); 
		query.append("  FROM BKG_CONTAINER CNTR" ).append("\n"); 
		query.append("      ,(SELECT /*+ INDEX_DESC(CTM_MOVEMENT XUK1CTM_MOVEMENT) */ " ).append("\n"); 
		query.append("               CNTR_NO" ).append("\n"); 
		query.append("              ,CNMV_CYC_NO" ).append("\n"); 
		query.append("              ,MVMT_STS_CD" ).append("\n"); 
		query.append("          FROM CTM_MOVEMENT" ).append("\n"); 
		query.append("         WHERE CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("           AND MVMT_STS_CD = 'OP'" ).append("\n"); 
		query.append("           AND ROWNUM = 1) MOVE" ).append("\n"); 
		query.append("      ,BKG_BOOKING BKG1" ).append("\n"); 
		query.append("      ,BKG_BOOKING BKG2" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("  AND MOVE.CNMV_CYC_NO = @[cnmv_cyc_no]" ).append("\n"); 
		query.append("  AND MOVE.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("  AND MOVE.CNTR_NO = CNTR.CNTR_NO" ).append("\n"); 
		query.append("  AND CNTR.CNMV_CYC_NO IN (@[cnmv_cyc_no],'9999','9998')" ).append("\n"); 
		query.append("  AND CNTR.CNMV_STS_CD ='OP'" ).append("\n"); 
		query.append("  AND CNTR.BKG_NO = BKG1.BKG_NO" ).append("\n"); 
		query.append("  AND BKG2.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("  AND BKG1.BKG_NO <> BKG2.BKG_NO" ).append("\n"); 
		query.append("  AND BKG1.VSL_CD = BKG2.VSL_CD" ).append("\n"); 
		query.append("  AND BKG1.SKD_VOY_NO = BKG2.SKD_VOY_NO" ).append("\n"); 
		query.append("  AND BKG1.SKD_DIR_CD = BKG2.SKD_DIR_CD" ).append("\n"); 
		query.append("  AND BKG1.SKD_DIR_CD = BKG2.SKD_DIR_CD" ).append("\n"); 
		query.append("  AND BKG1.BKG_STS_CD IN ('F','W')" ).append("\n"); 
		query.append("  AND NOT EXISTS (SELECT /*+ ORDERED USE_NL(BC BK) */" ).append("\n"); 
		query.append("                       'X'" ).append("\n"); 
		query.append("                  FROM  BKG_CONTAINER BC, BKG_BOOKING BK" ).append("\n"); 
		query.append("                  WHERE 1=1                                    " ).append("\n"); 
		query.append("                    AND BC.CNTR_PRT_FLG ='Y'" ).append("\n"); 
		query.append("                    AND BK.BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("                    AND BC.CNTR_NO =  @[cntr_no]" ).append("\n"); 
		query.append("                    AND BC.CRE_DT >= (SYSDATE - 90) /* 오래된 bkg_no과 연결된 cntr_no는 해당 없음 */" ).append("\n"); 
		query.append("                    AND BK.VSL_CD = BKG1.VSL_CD" ).append("\n"); 
		query.append("                    AND BK.SKD_VOY_NO = BKG1.SKD_VOY_NO" ).append("\n"); 
		query.append("                    AND BK.SKD_DIR_CD = BKG1.SKD_DIR_CD" ).append("\n"); 
		query.append("                    AND ROWNUM = 1 " ).append("\n"); 
		query.append("  )" ).append("\n"); 
		query.append("  AND NOT EXISTS (SELECT /*+ ORDERED USE_NL(BC BK) */" ).append("\n"); 
		query.append("                       'X' " ).append("\n"); 
		query.append("                   FROM  BKG_CONTAINER BC, BKG_BOOKING BK" ).append("\n"); 
		query.append("                  WHERE BK.FM_BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                    AND BK.BL_NO_TP = '9'" ).append("\n"); 
		query.append("                    AND BK.BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("                    AND BC.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("                    AND BC.CRE_DT >= (SYSDATE - 90) /* 오래된 bkg_no과 연결된 cntr_no는 해당 없음 */" ).append("\n"); 
		query.append("                )	" ).append("\n"); 

	}
}