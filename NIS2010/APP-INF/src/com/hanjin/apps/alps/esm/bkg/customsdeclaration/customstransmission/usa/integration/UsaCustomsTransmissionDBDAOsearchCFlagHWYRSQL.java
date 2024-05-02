/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : UsaCustomsTransmissionDBDAOsearchCFlagHWYRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.04.11
*@LastModifier : 
*@LastVersion : 1.0
* 2017.04.11 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaCustomsTransmissionDBDAOsearchCFlagHWYRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * C-Flag 조회 H->W->Y(P)
	  * </pre>
	  */
	public UsaCustomsTransmissionDBDAOsearchCFlagHWYRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("icr_code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaCustomsTransmissionDBDAOsearchCFlagHWYRSQL").append("\n"); 
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
		query.append("SELECT CASE WHEN (TB.HOLD_QTY - TB.REMV_QTY) > 0 THEN 'H'" ).append("\n"); 
		query.append("            WHEN TB.PCK_QTY  = TB.W_QTY THEN 'W'" ).append("\n"); 
		query.append("            WHEN TB.PCK_QTY  = TB.Y_ENT_QTY AND TB.PCK_QTY = TB.Y_RLS_QTY THEN 'Y'" ).append("\n"); 
		query.append("            WHEN Y_TOT_FLG = 'Y' AND TB.PCK_QTY  = TB.Y_TOT_QTY THEN 'Y'" ).append("\n"); 
		query.append("            ELSE 'N'" ).append("\n"); 
		query.append("       END C_FLAG" ).append("\n"); 
		query.append("  FROM ( " ).append("\n"); 
		query.append("		SELECT NVL(SUM(DECODE(CD.CSTMS_DIV_ID, 'CARGO_RLS_H_CD', RS.CNTR_QTY)),0) HOLD_QTY" ).append("\n"); 
		query.append("		      ,NVL(SUM(DECODE(CD.CSTMS_DIV_ID, 'CARGO_RLS_R_CD', RS.CNTR_QTY)),0) REMV_QTY" ).append("\n"); 
		query.append("		      ,SUM(DECODE(CD.CSTMS_DIV_ID, 'CARGO_RLS_Y_CD', DECODE(CD.ATTR_CTNT1, 'ENTR', DECODE(CD.ATTR_CTNT2, 'PLUS', 1, 'MINUS', -1, 0) * RS.CNTR_QTY))) Y_ENT_QTY" ).append("\n"); 
		query.append("		      ,SUM(DECODE(CD.CSTMS_DIV_ID, 'CARGO_RLS_Y_CD', DECODE(CD.ATTR_CTNT1, 'RLSE', DECODE(CD.ATTR_CTNT2, 'PLUS', 1, 'MINUS', -1, 0) * RS.CNTR_QTY))) Y_RLS_QTY" ).append("\n"); 
		query.append("		      ,SUM(DECODE(CD.CSTMS_DIV_ID, 'CARGO_RLS_W_CD', DECODE(CD.ATTR_CTNT2, 'PLUS', 1, 'MINUS', -1, 0) * RS.CNTR_QTY)) W_QTY" ).append("\n"); 
		query.append("              ,NVL(MAX(DECODE(@[icr_code], '54', DECODE(BL.MF_STS_CD, 'D', 0, BL.PCK_QTY), BL.PCK_QTY)),0) AS PCK_QTY" ).append("\n"); 
		query.append("              ,MAX(Y.Y_TOT_FLG) Y_TOT_FLG " ).append("\n"); 
		query.append("              ,MAX(Y.Y_TOT_QTY) Y_TOT_QTY" ).append("\n"); 
		query.append("		  FROM BKG_CSTMS_ADV_RSLT RS" ).append("\n"); 
		query.append("		      ,BKG_CSTMS_CD_CONV_CTNT CD" ).append("\n"); 
		query.append("              ,BKG_CSTMS_ADV_BL BL" ).append("\n"); 
		query.append("              ,(" ).append("\n"); 
		query.append("                SELECT CASE WHEN SUM(FLAG) > 1 THEN 'Y' ELSE 'N' END AS Y_TOT_FLG" ).append("\n"); 
		query.append("                      ,SUM(CNTR_QTY) Y_TOT_QTY" ).append("\n"); 
		query.append("                  FROM (" ).append("\n"); 
		query.append("                        SELECT DECODE(MAX(RS.DSPO_CD),NULL, 0, 1) AS FLAG" ).append("\n"); 
		query.append("                              ,SUM(DECODE(BL.PCK_QTY, RS.CNTR_QTY, 0, RS.CNTR_QTY)) AS CNTR_QTY" ).append("\n"); 
		query.append("                          FROM BKG_CSTMS_ADV_RSLT RS" ).append("\n"); 
		query.append("                              ,BKG_CSTMS_ADV_BL BL" ).append("\n"); 
		query.append("                         WHERE BL.CNT_CD = 'US'" ).append("\n"); 
		query.append("                           AND BL.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("                           AND BL.CNT_CD = RS.CNT_CD" ).append("\n"); 
		query.append("                           AND BL.BL_NO = RS.BL_NO" ).append("\n"); 
		query.append("                           AND RS.DSPO_CD = '1C'" ).append("\n"); 
		query.append("                           AND NVL(RS.RSND_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("                           AND RS.BL_NVOCC_TP_CD = 'M'" ).append("\n"); 
		query.append("                        UNION ALL" ).append("\n"); 
		query.append("                        SELECT 0 AS FLAG" ).append("\n"); 
		query.append("                              ,(SUM(RS.CNTR_QTY) * -1) AS CNTR_QTY" ).append("\n"); 
		query.append("                          FROM BKG_CSTMS_ADV_RSLT RS" ).append("\n"); 
		query.append("                         WHERE RS.CNT_CD = 'US'" ).append("\n"); 
		query.append("                           AND RS.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("                           AND RS.DSPO_CD = '4A'" ).append("\n"); 
		query.append("                           AND NVL(RS.RSND_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("                           AND RS.BL_NVOCC_TP_CD = 'M'" ).append("\n"); 
		query.append("                           AND RS.CSTMS_SEQ > " ).append("\n"); 
		query.append("                               (SELECT MIN(CSTMS_SEQ) FROM BKG_CSTMS_ADV_RSLT WHERE CNT_CD = 'US' AND BL_NO = @[bl_no] AND DSPO_CD = '1C')" ).append("\n"); 
		query.append("                        UNION ALL" ).append("\n"); 
		query.append("                        SELECT DECODE(MAX(RS.DSPO_CD),NULL, 0, 1) AS FLAG" ).append("\n"); 
		query.append("                              ,SUM(DECODE(BL.PCK_QTY, RS.CNTR_QTY, 0, RS.CNTR_QTY)) AS CNTR_QTY" ).append("\n"); 
		query.append("                          FROM BKG_CSTMS_ADV_RSLT RS" ).append("\n"); 
		query.append("                              ,BKG_CSTMS_ADV_BL BL" ).append("\n"); 
		query.append("                         WHERE BL.CNT_CD = 'US'" ).append("\n"); 
		query.append("                           AND BL.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("                           AND BL.CNT_CD = RS.CNT_CD" ).append("\n"); 
		query.append("                           AND BL.BL_NO = RS.BL_NO" ).append("\n"); 
		query.append("                           AND RS.DSPO_CD = '1W'" ).append("\n"); 
		query.append("                           AND NVL(RS.RSND_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("                           AND RS.BL_NVOCC_TP_CD = 'M'" ).append("\n"); 
		query.append("                        UNION ALL" ).append("\n"); 
		query.append("                        SELECT DECODE(MAX(RS.DSPO_CD),NULL, 0, 1) AS FLAG" ).append("\n"); 
		query.append("                              ,SUM(DECODE(BL.PCK_QTY, RS.CNTR_QTY, 0, DECODE(SUBSTR(RS.ENTR_NO, 1, 3), 'V5N', 0, RS.CNTR_QTY))) AS CNTR_QTY" ).append("\n"); 
		query.append("                          FROM BKG_CSTMS_ADV_RSLT RS" ).append("\n"); 
		query.append("                              ,BKG_CSTMS_ADV_BL BL" ).append("\n"); 
		query.append("                         WHERE BL.CNT_CD = 'US'" ).append("\n"); 
		query.append("                           AND BL.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("                           AND BL.CNT_CD = RS.CNT_CD" ).append("\n"); 
		query.append("                           AND BL.BL_NO = RS.BL_NO" ).append("\n"); 
		query.append("                           AND RS.DSPO_CD = '1J'" ).append("\n"); 
		query.append("                           AND NVL(RS.RSND_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("                           AND RS.BL_NVOCC_TP_CD = 'M'" ).append("\n"); 
		query.append("                       )" ).append("\n"); 
		query.append("                ) Y" ).append("\n"); 
		query.append("		 WHERE RS.CNT_CD   = 'US'" ).append("\n"); 
		query.append("		   AND RS.BL_NO    = @[bl_no]" ).append("\n"); 
		query.append("           AND RS.CNT_CD   = BL.CNT_CD" ).append("\n"); 
		query.append("           AND RS.BL_NO    = BL.BL_NO" ).append("\n"); 
		query.append("		   AND RS.CNT_CD   = CD.CNT_CD(+)" ).append("\n"); 
		query.append("		   AND RS.DSPO_CD  = CD.ATTR_CTNT3(+)" ).append("\n"); 
		query.append("		   AND NVL(RS.RSND_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("		   AND RS.BL_NVOCC_TP_CD = 'M'" ).append("\n"); 
		query.append("#if (${cstms_seq} != '') " ).append("\n"); 
		query.append("           AND RS.CSTMS_SEQ NOT IN (${cstms_seq})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       ) TB" ).append("\n"); 

	}
}