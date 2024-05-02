/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : ProductCatalogCreateDBDAOCreateBkgSplitMapCntrCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.03.14
*@LastModifier : 
*@LastVersion : 1.0
* 2017.03.14 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ProductCatalogCreateDBDAOCreateBkgSplitMapCntrCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Container 번호가 있는 SPLIT의 경우 처리 (다른 BKG이 Container를 가져갔을 경우 C로 생성한다.)
	  * 2011.04.04 mgpark 한 세션중에 bkg_no가 2회 이상 호출되는 경우, 데이터가 다중 생성되는 것을 방지하기 위한 로직 추가
	  * </pre>
	  */
	public ProductCatalogCreateDBDAOCreateBkgSplitMapCntrCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ofc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_lst",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mapg_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no_list",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.integration").append("\n"); 
		query.append("FileName : ProductCatalogCreateDBDAOCreateBkgSplitMapCntrCSQL").append("\n"); 
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
		query.append("MERGE INTO PRD_BKG_COP_MAP T" ).append("\n"); 
		query.append("USING (" ).append("\n"); 
		query.append("    SELECT DECODE(COP_OP_TP_CD, 'X', ROWID, NULL) ROW_ID" ).append("\n"); 
		query.append("         , CASE WHEN COP_OP_TP_CD = 'X' THEN PCTL_NO" ).append("\n"); 
		query.append("                ELSE NVL((SELECT PCTL_NO FROM BKG_BOOKING WHERE BKG_NO = @[bkg_no]) , PCTL_NO)" ).append("\n"); 
		query.append("           END AS PCTL_NO  -- KEY" ).append("\n"); 
		query.append("         , @[bkg_no] BKG_NO   -- KEY" ).append("\n"); 
		query.append("         , CASE WHEN COP_OP_TP_CD = 'X' THEN COP_NO" ).append("\n"); 
		query.append("                ELSE SCE_NEW_COP_NO_FNC (@[bkg_ofc])" ).append("\n"); 
		query.append("           END AS COP_NO   -- KEY" ).append("\n"); 
		query.append("         , @[mapg_seq] COP_MAPG_SEQ -- KEY" ).append("\n"); 
		query.append("         , CRNT_FLG" ).append("\n"); 
		query.append("         , CNTR_NO" ).append("\n"); 
		query.append("         , CNTR_TPSZ_CD" ).append("\n"); 
		query.append("         , DECODE(COP_OP_TP_CD, 'X', DECODE(BKG_NO, @[bkg_no], 'N', 'B'), 'C') COP_OP_TP_CD -- N변경없음, B BKG_NO변경, C 신규" ).append("\n"); 
		query.append("         , BKG_OP_RMK" ).append("\n"); 
		query.append("         , OB_ITCHG_CTNT" ).append("\n"); 
		query.append("         , IB_ITCHG_CTNT" ).append("\n"); 
		query.append("         , OCN_ITCHG_CTNT" ).append("\n"); 
		query.append("         , MTY_PKUP_YD_CD" ).append("\n"); 
		query.append("         , MTY_RTN_YD_CD" ).append("\n"); 
		query.append("         , POR_NOD_CD" ).append("\n"); 
		query.append("         , POL_NOD_CD" ).append("\n"); 
		query.append("         , BKG_RCV_TERM_CD" ).append("\n"); 
		query.append("         , BKG_DE_TERM_CD" ).append("\n"); 
		query.append("         , DECODE(COP_OP_TP_CD, 'X', OB_TRO_FLG, 'N') OB_TRO_FLG -- 신규는 초기화" ).append("\n"); 
		query.append("         , DECODE(COP_OP_TP_CD, 'X', IB_TRO_FLG, 'N') IB_TRO_FLG -- 신규는 초기화" ).append("\n"); 
		query.append("         , COP_PATT_ORD_NO" ).append("\n"); 
		query.append("         , DECODE(COP_OP_TP_CD, 'X', COP_SO_KNT, 0) COP_SO_KNT -- 신규는 초기화" ).append("\n"); 
		query.append("         , CRE_USR_ID" ).append("\n"); 
		query.append("         , CRE_DT" ).append("\n"); 
		query.append("         , UPD_USR_ID" ).append("\n"); 
		query.append("         , UPD_DT" ).append("\n"); 
		query.append("    FROM PRD_BKG_COP_MAP" ).append("\n"); 
		query.append("    WHERE BKG_NO IN " ).append("\n"); 
		query.append("           ( SELECT COLUMN_VALUE AS BKG_NO " ).append("\n"); 
		query.append("               FROM TABLE(SELECT BKG_SPLIT_FNC(@[bkg_no_list], ',') BKG_NO_TBL_STR FROM DUAL ))" ).append("\n"); 
		query.append("    AND CRNT_FLG = 'Y'" ).append("\n"); 
		query.append("    AND COP_OP_TP_CD in ('X', 'N', 'B')" ).append("\n"); 
		query.append("    AND INSTR(@[cntr_lst], CNTR_NO) > 0" ).append("\n"); 
		query.append("    AND 0 = (SELECT COUNT(1) -- 2011.04.04 mgpark 한 세션중에 bkg_no가 2회 이상 호출되는 경우, 데이터가 다중 생성되는 것을 방지하기 위한 로직" ).append("\n"); 
		query.append("               FROM PRD_BKG_COP_MAP" ).append("\n"); 
		query.append("              WHERE CRNT_FLG = 'Y'" ).append("\n"); 
		query.append("                AND COP_OP_TP_CD in ('N', 'B')" ).append("\n"); 
		query.append("                AND BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                AND CNTR_NO <> 'SMCU0000000'" ).append("\n"); 
		query.append("                AND ROWNUM = 1" ).append("\n"); 
		query.append("             )" ).append("\n"); 
		query.append(") S" ).append("\n"); 
		query.append("ON ( T.ROWID  = S.ROW_ID )" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE SET" ).append("\n"); 
		query.append("        T.BKG_NO = S.BKG_NO" ).append("\n"); 
		query.append("      , T.COP_OP_TP_CD = S.COP_OP_TP_CD" ).append("\n"); 
		query.append("      , T.COP_MAPG_SEQ = S.COP_MAPG_SEQ" ).append("\n"); 
		query.append("      , T.UPD_USR_ID   = 'SYSTEM1_U'" ).append("\n"); 
		query.append("      , T.UPD_DT       = SYSDATE" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT (PCTL_NO, BKG_NO, COP_NO, COP_MAPG_SEQ" ).append("\n"); 
		query.append("      , CRNT_FLG, CNTR_NO, CNTR_TPSZ_CD, COP_OP_TP_CD, BKG_OP_RMK, OB_ITCHG_CTNT" ).append("\n"); 
		query.append("      , IB_ITCHG_CTNT, OCN_ITCHG_CTNT, MTY_PKUP_YD_CD, MTY_RTN_YD_CD, POR_NOD_CD" ).append("\n"); 
		query.append("      , POL_NOD_CD, BKG_RCV_TERM_CD, BKG_DE_TERM_CD, OB_TRO_FLG, IB_TRO_FLG" ).append("\n"); 
		query.append("      , COP_PATT_ORD_NO, COP_SO_KNT, CRE_USR_ID, CRE_DT, UPD_USR_ID" ).append("\n"); 
		query.append("      , UPD_DT" ).append("\n"); 
		query.append(" )" ).append("\n"); 
		query.append("VALUES ( S.PCTL_NO, S.BKG_NO, S.COP_NO, S.COP_MAPG_SEQ" ).append("\n"); 
		query.append("      , S.CRNT_FLG , S.CNTR_NO, S.CNTR_TPSZ_CD, S.COP_OP_TP_CD, S.BKG_OP_RMK, S.OB_ITCHG_CTNT" ).append("\n"); 
		query.append("      , S.IB_ITCHG_CTNT, S.OCN_ITCHG_CTNT, S.MTY_PKUP_YD_CD, S.MTY_RTN_YD_CD, S.POR_NOD_CD" ).append("\n"); 
		query.append("      , S.POL_NOD_CD, S.BKG_RCV_TERM_CD, S.BKG_DE_TERM_CD, S.OB_TRO_FLG, S.IB_TRO_FLG" ).append("\n"); 
		query.append("      , S.COP_PATT_ORD_NO, S.COP_SO_KNT, S.CRE_USR_ID, S.CRE_DT, 'SYSTEM1_C'" ).append("\n"); 
		query.append("      , SYSDATE " ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}