/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BlRatingDBDAOSearchRateCntrInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.27
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2010.01.27 김태경
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author kim tae kyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BlRatingDBDAOSearchRateCntrInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BlRatingDBDAOSearchCntrInfo
	  * </pre>
	  */
	public BlRatingDBDAOSearchRateCntrInfoRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration").append("\n"); 
		query.append("FileName : BlRatingDBDAOSearchRateCntrInfoRSQL").append("\n"); 
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
		query.append("#if (${caflag} == 'Y') " ).append("\n"); 
		query.append("SELECT BKG_NO" ).append("\n"); 
		query.append(",      CNTR_NO" ).append("\n"); 
		query.append(",      CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",      CNTR_DP_SEQ" ).append("\n"); 
		query.append(",      CNTR_PRT_FLG" ).append("\n"); 
		query.append(",      CNTR_VOL_QTY" ).append("\n"); 
		query.append(",      EQ_SUBST_TPSZ_CD" ).append("\n"); 
		query.append(",      decode(HNGR_FLG, 'Y', CNTR_VOL_QTY, 0) AS HNGR_FLG" ).append("\n"); 
		query.append(",      decode(DCGO_FLG, 'Y', CNTR_VOL_QTY, 0) AS DCGO_FLG" ).append("\n"); 
		query.append(",      decode(BB_CGO_FLG, 'Y', CNTR_VOL_QTY, 0) AS BB_CGO_FLG" ).append("\n"); 
		query.append(",      decode(AWK_CGO_FLG, 'Y', CNTR_VOL_QTY, 0) AS AWK_CGO_FLG" ).append("\n"); 
		query.append(",      decode(RC_FLG, 'Y', CNTR_VOL_QTY, 0) AS RC_FLG" ).append("\n"); 
		query.append(",      DECODE(SUBSTR(CNTR_TPSZ_CD, 1, 1), 'R', DECODE(RC_FLG, 'Y', 0, CNTR_VOL_QTY), DECODE(RC_FLG, 'Y',CNTR_VOL_QTY,0)) RD_CGO_FLG" ).append("\n"); 
		query.append(",      decode(SOC_FLG, 'Y', CNTR_VOL_QTY, 0) AS SOC_FLG" ).append("\n"); 
		query.append(",	   DE_TERM_CD" ).append("\n"); 
		query.append(",	   RCV_TERM_CD" ).append("\n"); 
		query.append(",	   (SELECT FLEX_HGT_FLG FROM BKG_BKG_HIS B WHERE B.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("        AND B.CORR_NO ='TMP0000001') FLEX_HGT_FLG" ).append("\n"); 
		query.append(",      (SELECT COUNT(SA.IMG_SEQ)" ).append("\n"); 
		query.append("FROM   BKG_IMG_STO SA, BKG_DG_CGO SB" ).append("\n"); 
		query.append("WHERE  SB.BKG_NO = SA.BKG_NO" ).append("\n"); 
		query.append("AND    SB.DCGO_SEQ = SA.DCGO_SEQ" ).append("\n"); 
		query.append("AND    SB.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("AND    SB.CNTR_NO = A.CNTR_NO) DCGO_CNT" ).append("\n"); 
		query.append("FROM   BKG_CNTR_HIS A" ).append("\n"); 
		query.append("WHERE  BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("ORDER BY CNTR_DP_SEQ" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("SELECT BKG_NO" ).append("\n"); 
		query.append(",      CNTR_NO" ).append("\n"); 
		query.append(",      CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",      CNTR_DP_SEQ" ).append("\n"); 
		query.append(",      CNTR_PRT_FLG" ).append("\n"); 
		query.append(",      CNTR_VOL_QTY" ).append("\n"); 
		query.append(",      EQ_SUBST_TPSZ_CD" ).append("\n"); 
		query.append(",      decode(HNGR_FLG, 'Y', CNTR_VOL_QTY, 0) AS HNGR_FLG" ).append("\n"); 
		query.append(",      decode(DCGO_FLG, 'Y', CNTR_VOL_QTY, 0) AS DCGO_FLG" ).append("\n"); 
		query.append(",      decode(BB_CGO_FLG, 'Y', CNTR_VOL_QTY, 0) AS BB_CGO_FLG" ).append("\n"); 
		query.append(",      decode(AWK_CGO_FLG, 'Y', CNTR_VOL_QTY, 0) AS AWK_CGO_FLG" ).append("\n"); 
		query.append(",      decode(RC_FLG, 'Y', CNTR_VOL_QTY, 0) AS RC_FLG" ).append("\n"); 
		query.append(",      DECODE(SUBSTR(CNTR_TPSZ_CD, 1, 1), 'R', DECODE(RC_FLG, 'Y', 0, CNTR_VOL_QTY), DECODE(RC_FLG, 'Y',CNTR_VOL_QTY,0)) RD_CGO_FLG" ).append("\n"); 
		query.append(",      decode(SOC_FLG, 'Y', CNTR_VOL_QTY, 0) AS SOC_FLG" ).append("\n"); 
		query.append(",	   DE_TERM_CD" ).append("\n"); 
		query.append(",	   RCV_TERM_CD" ).append("\n"); 
		query.append(",	   (SELECT FLEX_HGT_FLG FROM BKG_BOOKING B WHERE B.BKG_NO = A.BKG_NO) FLEX_HGT_FLG" ).append("\n"); 
		query.append(",      (SELECT COUNT(SA.IMG_SEQ)" ).append("\n"); 
		query.append("FROM   BKG_IMG_STO SA, BKG_DG_CGO SB" ).append("\n"); 
		query.append("WHERE  SB.BKG_NO = SA.BKG_NO" ).append("\n"); 
		query.append("AND    SB.DCGO_SEQ = SA.DCGO_SEQ" ).append("\n"); 
		query.append("AND    SB.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("AND    SB.CNTR_NO = A.CNTR_NO) DCGO_CNT" ).append("\n"); 
		query.append("FROM   BKG_CONTAINER A" ).append("\n"); 
		query.append("WHERE  BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("ORDER BY CNTR_DP_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}