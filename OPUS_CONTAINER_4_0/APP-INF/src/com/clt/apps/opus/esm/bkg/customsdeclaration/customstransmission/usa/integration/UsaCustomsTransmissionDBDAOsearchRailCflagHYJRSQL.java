/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : UsaCustomsTransmissionDBDAOsearchRailCflagHYJRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.16
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2014.10.16 김보배
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author BOBAE KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaCustomsTransmissionDBDAOsearchRailCflagHYJRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 이전 Dspo Cd 별 Enter/Release Qty 합산하여 Cntr_Pck_Qty 와 동일할 경우, C-flag =Y or J. 아니면 N
	  * </pre>
	  */
	public UsaCustomsTransmissionDBDAOsearchRailCflagHYJRSQL(){
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
		params.put("in_cntr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("icr_qty",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaCustomsTransmissionDBDAOsearchRailCflagHYJRSQL").append("\n"); 
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
		query.append("CASE        WHEN (TB.HOLD_QTY - TB.REMV_QTY) > 0 THEN 'H'" ).append("\n"); 
		query.append("            WHEN TB.PCK_QTY  = TB.Y_ENT_QTY AND TB.PCK_QTY = TB.Y_RLS_QTY THEN 'Y'" ).append("\n"); 
		query.append("            WHEN Y_TOT_FLG = 'Y' AND TB.PCK_QTY  = TB.Y_TOT_QTY THEN 'Y'" ).append("\n"); 
		query.append("            WHEN J_QTY = TB.PCK_QTY  THEN 'J'" ).append("\n"); 
		query.append("            ELSE 'N'" ).append("\n"); 
		query.append("       END new_cFLAG" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("		SELECT" ).append("\n"); 
		query.append("         MAX(Y.Y_TOT_FLG) Y_TOT_FLG" ).append("\n"); 
		query.append("        ,MAX(Y.Y_TOT_QTY) Y_TOT_QTY" ).append("\n"); 
		query.append("        ,MAX( ( SELECT NVL(SUM(CM.PCK_QTY), 0) qty_69" ).append("\n"); 
		query.append("                  FROM BKG_CSTMS_ADV_BL A" ).append("\n"); 
		query.append("                  ,BKG_CSTMS_ADV_BL B" ).append("\n"); 
		query.append("                  ,BKG_CSTMS_ADV_CNTR C" ).append("\n"); 
		query.append("                  ,BKG_CSTMS_ADV_CNTR_MF CM" ).append("\n"); 
		query.append("                 WHERE 1=1 " ).append("\n"); 
		query.append("                   AND C.CNT_CD     = 'US'" ).append("\n"); 
		query.append("                   AND C.CNTR_NO    LIKE TRIM( @[in_cntr] )||'%'" ).append("\n"); 
		query.append("                   AND B.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("                   AND A.CNT_CD = B.CNT_CD" ).append("\n"); 
		query.append("                   AND A.VSL_CD     = B.VSL_CD" ).append("\n"); 
		query.append("                   AND A.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("                   AND A.SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("                   AND C.CNT_CD     = A.CNT_CD" ).append("\n"); 
		query.append("                   AND C.BL_NO      = A.BL_NO" ).append("\n"); 
		query.append("                   AND A.MF_NO IS NULL" ).append("\n"); 
		query.append("                   AND C.CNT_CD = CM.CNT_CD" ).append("\n"); 
		query.append("                   AND C.BL_NO = CM.BL_NO" ).append("\n"); 
		query.append("                   AND C.CNTR_NO = CM.CNTR_NO" ).append("\n"); 
		query.append("             ) ) PCK_QTY" ).append("\n"); 
		query.append("            ,SUM(DECODE(CD.CSTMS_DIV_ID, 'CARGO_RLS_Y_CD', DECODE(CD.ATTR_CTNT1, 'ENTR', DECODE(CD.ATTR_CTNT2, 'PLUS', 1, 'MINUS', -1, 0) * RS.CNTR_QTY)))   Y_ENT_QTY" ).append("\n"); 
		query.append("            ,SUM(DECODE(CD.CSTMS_DIV_ID, 'CARGO_RLS_Y_CD', DECODE(CD.ATTR_CTNT1, 'RLSE', DECODE(CD.ATTR_CTNT2, 'PLUS', 1, 'MINUS', -1, 0) * RS.CNTR_QTY)))   Y_RLS_QTY" ).append("\n"); 
		query.append("            ,SUM(DECODE(CD.CSTMS_DIV_ID, 'CARGO_RLS_J_CD', DECODE(CD.ATTR_CTNT2, 'PLUS', 1, 'MINUS', -1, 0) * RS.CNTR_QTY ))    J_QTY" ).append("\n"); 
		query.append("            ,NVL(SUM(DECODE(CD.CSTMS_DIV_ID, 'CARGO_RLS_H_CD', RS.CNTR_QTY))    ,0) HOLD_QTY" ).append("\n"); 
		query.append("            ,NVL(SUM(DECODE(CD.CSTMS_DIV_ID, 'CARGO_RLS_R_CD', RS.CNTR_QTY))   ,0) REMV_QTY" ).append("\n"); 
		query.append("            , SUBSTR(  max( LPAD(CSTMS_SEQ,5,0)  ||rs.dspo_cd) ,6)  DSPO" ).append("\n"); 
		query.append("            , SUBSTR(  max( LPAD(CSTMS_SEQ,5,0)  ||rs.cstms_clr_cd) ,6)  oldCflag" ).append("\n"); 
		query.append("		  FROM    " ).append("\n"); 
		query.append("		      (SELECT CNT_CD, BL_NO,CSTMS_SEQ,CNTR_NO,CNTR_QTY,dspo_cd,cstms_clr_cd FROM  BKG_CSTMS_ADV_cntr_RSLT " ).append("\n"); 
		query.append("		            UNION ALL" ).append("\n"); 
		query.append("		       SELECT 'US', @[bl_no], 10000, @[in_cntr], TO_NUMBER(@[icr_qty] ) , @[icr_code],  '' from dual  -- 수신 데이터가 선입력 되지 않아 UNION ALL처리" ).append("\n"); 
		query.append("		      )RS" ).append("\n"); 
		query.append("		      ,BKG_CSTMS_CD_CONV_CTNT CD" ).append("\n"); 
		query.append("              ,BKG_CSTMS_ADV_BL BL" ).append("\n"); 
		query.append("              ,(" ).append("\n"); 
		query.append("                SELECT CASE WHEN SUM(FLAG) > 1 THEN 'Y' ELSE 'N' END AS Y_TOT_FLG" ).append("\n"); 
		query.append("                      ,SUM(CNTR_QTY) Y_TOT_QTY" ).append("\n"); 
		query.append("                  FROM (" ).append("\n"); 
		query.append("                        SELECT DECODE(MAX(RS.DSPO_CD),NULL, 0, 1) AS FLAG" ).append("\n"); 
		query.append("                              ,SUM(DECODE(BL.PCK_QTY, RS.CNTR_QTY, 0, RS.CNTR_QTY)) AS CNTR_QTY" ).append("\n"); 
		query.append("                          FROM BKG_CSTMS_ADV_CNTR_RSLT RS" ).append("\n"); 
		query.append("                              ,BKG_CSTMS_ADV_BL BL" ).append("\n"); 
		query.append("                         WHERE BL.CNT_CD = 'US'" ).append("\n"); 
		query.append("                           AND BL.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("                           AND rs.CNTR_NO LIKE TRIM( @[in_cntr]  )||'%'" ).append("\n"); 
		query.append("                           AND BL.CNT_CD = RS.CNT_CD" ).append("\n"); 
		query.append("                           AND BL.BL_NO = RS.BL_NO" ).append("\n"); 
		query.append("                           AND RS.DSPO_CD = '1C'" ).append("\n"); 
		query.append("                        UNION ALL" ).append("\n"); 
		query.append("                        SELECT 0 AS FLAG" ).append("\n"); 
		query.append("                              ,(SUM(RS.CNTR_QTY) * -1) AS CNTR_QTY" ).append("\n"); 
		query.append("                          FROM BKG_CSTMS_ADV_CNTR_RSLT RS" ).append("\n"); 
		query.append("                         WHERE RS.CNT_CD = 'US'" ).append("\n"); 
		query.append("                           AND RS.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("                           AND rs.CNTR_NO LIKE TRIM( @[in_cntr]  )||'%'                           " ).append("\n"); 
		query.append("                           AND RS.DSPO_CD = '4A'" ).append("\n"); 
		query.append("                           AND RS.CSTMS_SEQ > " ).append("\n"); 
		query.append("                               (SELECT MIN(CSTMS_SEQ) FROM BKG_CSTMS_ADV_CNTR_RSLT WHERE CNT_CD = 'US' AND BL_NO = @[bl_no] AND DSPO_CD = '1C')" ).append("\n"); 
		query.append("                        UNION ALL" ).append("\n"); 
		query.append("                        SELECT DECODE(MAX(RS.DSPO_CD),NULL, 0, 1) AS FLAG" ).append("\n"); 
		query.append("                              ,SUM(DECODE(BL.PCK_QTY, RS.CNTR_QTY, 0, RS.CNTR_QTY)) AS CNTR_QTY" ).append("\n"); 
		query.append("                          FROM BKG_CSTMS_ADV_CNTR_RSLT RS" ).append("\n"); 
		query.append("                              ,BKG_CSTMS_ADV_BL BL" ).append("\n"); 
		query.append("                         WHERE BL.CNT_CD = 'US'" ).append("\n"); 
		query.append("                           AND BL.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("                           AND rs.CNTR_NO LIKE TRIM( @[in_cntr]  )||'%'" ).append("\n"); 
		query.append("                           AND BL.CNT_CD = RS.CNT_CD" ).append("\n"); 
		query.append("                           AND BL.BL_NO = RS.BL_NO" ).append("\n"); 
		query.append("                           AND RS.DSPO_CD = '1W'" ).append("\n"); 
		query.append("                        UNION ALL" ).append("\n"); 
		query.append("                        SELECT DECODE(MAX(RS.DSPO_CD),NULL, 0, 1) AS FLAG" ).append("\n"); 
		query.append("                              ,SUM(DECODE(BL.PCK_QTY, RS.CNTR_QTY, 0, DECODE(SUBSTR(RS.ENTR_NO, 1, 3), BKG_GET_BKG_CTMS_CD_FNC('US','AMS_ASGN_CO_CD',1,1), 0, RS.CNTR_QTY))) AS CNTR_QTY" ).append("\n"); 
		query.append("                          FROM BKG_CSTMS_ADV_CNTR_RSLT RS" ).append("\n"); 
		query.append("                              ,BKG_CSTMS_ADV_BL BL" ).append("\n"); 
		query.append("                         WHERE BL.CNT_CD = 'US'" ).append("\n"); 
		query.append("                           AND BL.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("                           AND rs.CNTR_NO LIKE TRIM( @[in_cntr]  )||'%'" ).append("\n"); 
		query.append("                           AND BL.CNT_CD = RS.CNT_CD" ).append("\n"); 
		query.append("                           AND BL.BL_NO = RS.BL_NO" ).append("\n"); 
		query.append("                           AND RS.DSPO_CD = '1J'" ).append("\n"); 
		query.append("                       )" ).append("\n"); 
		query.append("                ) Y" ).append("\n"); 
		query.append("		 WHERE RS.CNT_CD   = 'US'" ).append("\n"); 
		query.append("		   AND RS.BL_NO    = @[bl_no]" ).append("\n"); 
		query.append("		   AND rs.CNTR_NO LIKE TRIM( @[in_cntr]  )||'%'" ).append("\n"); 
		query.append("           AND RS.CNT_CD   = BL.CNT_CD" ).append("\n"); 
		query.append("           AND RS.BL_NO    = BL.BL_NO" ).append("\n"); 
		query.append("		   AND RS.CNT_CD   = CD.CNT_CD(+)" ).append("\n"); 
		query.append("		   AND RS.DSPO_CD  = CD.ATTR_CTNT3(+)" ).append("\n"); 
		query.append("#if (${cstms_seq} != '') " ).append("\n"); 
		query.append("           AND RS.CSTMS_SEQ NOT IN (${cstms_seq})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("--           AND RS.CSTMS_SEQ <= NVL( :cstms_seq , 1000 )" ).append("\n"); 
		query.append("       ) TB" ).append("\n"); 

	}
}