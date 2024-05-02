/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ChangeOfDestinationMgtDBDAOOpfCodOldNewPodVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.26
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.26 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.changeofdestinationmgt.changeofdestinationmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChangeOfDestinationMgtDBDAOOpfCodOldNewPodVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * COD Detail - Calculation 시 Old POD, New POD, CNTR TP/SZ 조회 쿼리
	  * 
	  * History
	  * 2015.03.06 이병훈 [CHM-201534196] COD charges DVC 비용 관련 로직 수정
	  * </pre>
	  */
	public ChangeOfDestinationMgtDBDAOOpfCodOldNewPodVORSQL(){
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

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cod_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.changeofdestinationmgt.changeofdestinationmgt.integration").append("\n"); 
		query.append("FileName : ChangeOfDestinationMgtDBDAOOpfCodOldNewPodVORSQL").append("\n"); 
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
		query.append("-- OLD_POD CLPT_SEQ & NEW_POD CLPT_SEQ 추출" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("        SELECT MIN(CLPT_SEQ)" ).append("\n"); 
		query.append("        FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("        WHERE VSL_CD = OLDVVD.VSL_CD" ).append("\n"); 
		query.append("        AND SKD_VOY_NO = OLDVVD.SKD_VOY_NO" ).append("\n"); 
		query.append("        AND SKD_DIR_CD = OLDVVD.SKD_DIR_CD" ).append("\n"); 
		query.append("        AND VPS_PORT_CD = SUBSTR(OLDVVD.POD_YD_CD, 1, 5)" ).append("\n"); 
		query.append("        AND NVL(SKD_CNG_STS_CD,' ') <> 'S'" ).append("\n"); 
		query.append("    ) AS OLD_POD_CLPT_SEQ" ).append("\n"); 
		query.append("    ,(" ).append("\n"); 
		query.append("        SELECT MIN(CLPT_SEQ)" ).append("\n"); 
		query.append("        FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("        WHERE VSL_CD = NEWVVD.VSL_CD" ).append("\n"); 
		query.append("        AND SKD_VOY_NO = NEWVVD.SKD_VOY_NO" ).append("\n"); 
		query.append("        AND SKD_DIR_CD = NEWVVD.SKD_DIR_CD" ).append("\n"); 
		query.append("        AND VPS_PORT_CD = SUBSTR(NEWVVD.POD_YD_CD, 1, 5)" ).append("\n"); 
		query.append("        AND NVL(SKD_CNG_STS_CD,' ') <> 'S'" ).append("\n"); 
		query.append("    ) AS NEW_POD_CLPT_SEQ" ).append("\n"); 
		query.append("    ,NULL AS CNTR_TPSZ_CD" ).append("\n"); 
		query.append("    ,NULL AS CNTR_QTY" ).append("\n"); 
		query.append("FROM BKG_COD COD, BKG_COD_VVD OLDVVD, BKG_COD_VVD NEWVVD" ).append("\n"); 
		query.append("WHERE COD.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("    AND COD.COD_RQST_SEQ = @[cod_rqst_seq]" ).append("\n"); 
		query.append("    AND COD.BKG_NO = OLDVVD.BKG_NO" ).append("\n"); 
		query.append("    AND COD.COD_RQST_SEQ = OLDVVD.COD_RQST_SEQ" ).append("\n"); 
		query.append("    AND COD.BKG_NO = NEWVVD.BKG_NO" ).append("\n"); 
		query.append("    AND COD.COD_RQST_SEQ = NEWVVD.COD_RQST_SEQ" ).append("\n"); 
		query.append("    AND OLDVVD.VVD_OP_CD = 'O'" ).append("\n"); 
		query.append("    AND NEWVVD.VVD_OP_CD = 'N'" ).append("\n"); 
		query.append("    AND OLDVVD.VSL_CD||OLDVVD.SKD_VOY_NO||OLDVVD.SKD_DIR_CD = NEWVVD.VSL_CD||NEWVVD.SKD_VOY_NO||NEWVVD.SKD_DIR_CD" ).append("\n"); 
		query.append("    AND OLDVVD.POD_YD_CD <> NEWVVD.POD_YD_CD" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- CNTR_TPSZ_CD & CNTR_QTY 추출" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("    NULL AS OLD_POD_ETA" ).append("\n"); 
		query.append("    ,NULL AS NEW_POD_ETA" ).append("\n"); 
		query.append("    ,CNTR_TPSZ_CD" ).append("\n"); 
		query.append("    ,COUNT(*) CNTR_QTY" ).append("\n"); 
		query.append("FROM BKG_COD_CNTR" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("    AND COD_RQST_SEQ(+) = @[cod_rqst_seq]" ).append("\n"); 
		query.append("	AND COD_SLCT_FLG = 'Y'" ).append("\n"); 
		query.append("GROUP BY CNTR_TPSZ_CD" ).append("\n"); 

	}
}