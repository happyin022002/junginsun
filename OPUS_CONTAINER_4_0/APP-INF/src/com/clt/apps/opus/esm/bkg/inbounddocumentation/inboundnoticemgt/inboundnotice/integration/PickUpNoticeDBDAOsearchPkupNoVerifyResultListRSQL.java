/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PickUpNoticeDBDAOsearchPkupNoVerifyResultListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.05
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.05 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PickUpNoticeDBDAOsearchPkupNoVerifyResultListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 철송 회사로 부터 e-mail을 받은 pick-up No upload 결과를 검증(Verify) 한다
	  * </pre>
	  */
	public PickUpNoticeDBDAOsearchPkupNoVerifyResultListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pkup_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("remark",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pkup_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pkup_aval_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lst_free_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration").append("\n"); 
		query.append("FileName : PickUpNoticeDBDAOsearchPkupNoVerifyResultListRSQL").append("\n"); 
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
		query.append("-- PkupNoRptVO 생성" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("	@[chk] AS CHK" ).append("\n"); 
		query.append(",	@[cntr_no] AS CNTR_NO" ).append("\n"); 
		query.append(",	@[bl_no] AS BL_NO" ).append("\n"); 
		query.append(",	@[pkup_no] AS PKUP_NO" ).append("\n"); 
		query.append(",	@[pkup_aval_dt] AS PKUP_AVAL_DT" ).append("\n"); 
		query.append(",	@[lst_free_dt] AS LST_FREE_DT" ).append("\n"); 
		query.append(",	@[pkup_yd_cd] AS PKUP_YD_CD" ).append("\n"); 
		query.append(",	@[remark] AS REMARK" ).append("\n"); 
		query.append(",	DECODE(CNTR_USE_FLG, 0, 'N', 'Y')  AS CNTR_NO_CHK_FLG" ).append("\n"); 
		query.append(",	DECODE(CNTR_USE_FLG, 0, 'Invalid~!', 'Clear~!')  AS CNTR_NO_CHK_MSG" ).append("\n"); 
		query.append(",	DECODE(BL_CHECK_FLG, 0, 'N', 'Y')  AS BL_NO_CHK_FLG" ).append("\n"); 
		query.append(",	DECODE(BL_CHECK_FLG, 0, 'Invalid~!', 'Clear~!')  AS BL_NO_CHK_MSG" ).append("\n"); 
		query.append(",	DECODE(YD_CHECK_FLG, 0, 'N', 'Y')  AS PKUP_YD_CD_CHK_FLG" ).append("\n"); 
		query.append(",	DECODE(YD_CHECK_FLG, 0, 'Invalid~!', 'Clear~!')  AS PKUP_YD_CD_CHK_MSG" ).append("\n"); 
		query.append(",	DECODE(AVL_CHECK_FLG, 0, 'N', 'Y') AS PKUP_AVAL_DT_CHK_FLG" ).append("\n"); 
		query.append(",	DECODE(AVL_CHECK_FLG, 0, 'Invalid~!', 'Clear~!') AS PKUP_AVAL_DT_CHK_MSG" ).append("\n"); 
		query.append(",	DECODE(FRE_CHECK_FLG, 0, 'N', 'Y') AS LST_FREE_DT_CHK_FLG" ).append("\n"); 
		query.append(",	DECODE(FRE_CHECK_FLG, 0, 'Invalid~!', 'Clear~!') AS LST_FREE_DT_CHK_MSG" ).append("\n"); 
		query.append("  FROM (SELECT NVL(COUNT(1), 0) AS CNTR_USE_FLG" ).append("\n"); 
		query.append("          FROM TRS_TRSP_RAIL_BIL_ORD" ).append("\n"); 
		query.append("         WHERE BL_NO = @[bl_no]" ).append("\n"); 
		query.append("           AND EQ_NO LIKE @[cntr_no] || '%'" ).append("\n"); 
		query.append("           AND TRSP_BND_CD  = 'I'" ).append("\n"); 
		query.append("           AND DELT_FLG     = 'N'" ).append("\n"); 
		query.append("       )," ).append("\n"); 
		query.append("       (SELECT NVL(COUNT(1), 0) AS BL_CHECK_FLG" ).append("\n"); 
		query.append("          FROM BKG_BOOKING   A" ).append("\n"); 
		query.append("              ,(" ).append("\n"); 
		query.append("                SELECT A.BKG_NO" ).append("\n"); 
		query.append("                  FROM (" ).append("\n"); 
		query.append("                        SELECT A.*" ).append("\n"); 
		query.append("                              ,MAX(A.CNMV_CYC_NO) OVER() AS MAX_CYC_NO" ).append("\n"); 
		query.append("                          FROM BKG_CONTAINER A" ).append("\n"); 
		query.append("                              ,BKG_BOOKING   B" ).append("\n"); 
		query.append("                         WHERE A.CNTR_NO = " ).append("\n"); 
		query.append("                               (SELECT EQ_NO" ).append("\n"); 
		query.append("                                  FROM TRS_TRSP_RAIL_BIL_ORD" ).append("\n"); 
		query.append("                                 WHERE BL_NO        = @[bl_no]" ).append("\n"); 
		query.append("                                   AND EQ_NO        LIKE @[cntr_no] || '%'" ).append("\n"); 
		query.append("                                   AND TRSP_BND_CD  = 'I'" ).append("\n"); 
		query.append("                                   AND DELT_FLG     = 'N'" ).append("\n"); 
		query.append("                                   AND ROWNUM       = 1" ).append("\n"); 
		query.append("                               )  " ).append("\n"); 
		query.append("                           AND A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                           AND B.BKG_STS_CD <> 'X'                               " ).append("\n"); 
		query.append("                       ) A" ).append("\n"); 
		query.append("                 WHERE A.MAX_CYC_NO = A.CNMV_CYC_NO" ).append("\n"); 
		query.append("               ) B" ).append("\n"); 
		query.append("         WHERE A.BL_NO              = @[bl_no]" ).append("\n"); 
		query.append("           AND A.BKG_CGO_TP_CD      IN ('F','R','B')" ).append("\n"); 
		query.append("         --  AND A.DEL_CD             LIKE 'US%'" ).append("\n"); 
		query.append("           AND SUBSTR(A.BKG_NO,1,4) <> 'DCHI'" ).append("\n"); 
		query.append("           AND SUBSTR(A.BKG_NO,1,4) <> 'TCHI'    " ).append("\n"); 
		query.append("           AND B.BKG_NO             = A.BKG_NO" ).append("\n"); 
		query.append("       )," ).append("\n"); 
		query.append("       (SELECT NVL(COUNT(1), 0) AS YD_CHECK_FLG" ).append("\n"); 
		query.append("          FROM MDM_YARD" ).append("\n"); 
		query.append("         WHERE YD_CD = @[pkup_yd_cd])," ).append("\n"); 
		query.append("       (SELECT NVL(COUNT(@[pkup_aval_dt]), 0) AS AVL_CHECK_FLG" ).append("\n"); 
		query.append("          FROM DUAL)," ).append("\n"); 
		query.append("       (SELECT NVL(COUNT(@[lst_free_dt]), 0) AS FRE_CHECK_FLG" ).append("\n"); 
		query.append("          FROM DUAL)" ).append("\n"); 

	}
}