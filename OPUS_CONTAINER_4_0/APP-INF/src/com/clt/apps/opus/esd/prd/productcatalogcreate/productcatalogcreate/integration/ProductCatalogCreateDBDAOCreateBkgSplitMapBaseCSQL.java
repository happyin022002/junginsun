/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ProductCatalogCreateDBDAOCreateBkgSplitMapBaseCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.19
*@LastModifier : 박만건
*@LastVersion : 1.0
* 2010.10.19 박만건
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Mangeon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ProductCatalogCreateDBDAOCreateBkgSplitMapBaseCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Booking Split 또는 MEMO 생성시 prd_bkg_cop_map을 1세트 생성시킨다.
	  * </pre>
	  */
	public ProductCatalogCreateDBDAOCreateBkgSplitMapBaseCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("parent_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.integration").append("\n"); 
		query.append("FileName : ProductCatalogCreateDBDAOCreateBkgSplitMapBaseCSQL").append("\n"); 
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
		query.append("INSERT INTO PRD_BKG_COP_MAP" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("       PCTL_NO" ).append("\n"); 
		query.append("     , BKG_NO" ).append("\n"); 
		query.append("     , COP_NO" ).append("\n"); 
		query.append("     , COP_MAPG_SEQ" ).append("\n"); 
		query.append("     , CRNT_FLG" ).append("\n"); 
		query.append("     , CNTR_NO" ).append("\n"); 
		query.append("     , CNTR_TPSZ_CD" ).append("\n"); 
		query.append("     , COP_OP_TP_CD" ).append("\n"); 
		query.append("     , BKG_OP_RMK" ).append("\n"); 
		query.append("--     , OB_ITCHG_CTNT" ).append("\n"); 
		query.append("--     , IB_ITCHG_CTNT" ).append("\n"); 
		query.append("--     , OCN_ITCHG_CTNT" ).append("\n"); 
		query.append("--     , MTY_PKUP_YD_CD" ).append("\n"); 
		query.append("--     , MTY_RTN_YD_CD" ).append("\n"); 
		query.append("--     , POR_NOD_CD" ).append("\n"); 
		query.append("--     , POL_NOD_CD" ).append("\n"); 
		query.append("--     , BKG_RCV_TERM_CD" ).append("\n"); 
		query.append("--     , BKG_DE_TERM_CD" ).append("\n"); 
		query.append("     , OB_TRO_FLG" ).append("\n"); 
		query.append("     , IB_TRO_FLG" ).append("\n"); 
		query.append("--     , COP_PATT_ORD_NO" ).append("\n"); 
		query.append("     , COP_SO_KNT" ).append("\n"); 
		query.append("     , CRE_USR_ID" ).append("\n"); 
		query.append("     , CRE_DT" ).append("\n"); 
		query.append("     , UPD_USR_ID" ).append("\n"); 
		query.append("     , UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT PCTL_NO" ).append("\n"); 
		query.append("     , BKG_NO" ).append("\n"); 
		query.append("     , COP_NO" ).append("\n"); 
		query.append("     , @[mapg_seq] COP_MAPG_SEQ -- 모두 새로운 SEQ" ).append("\n"); 
		query.append("     , 'Y' CRNT_FLG" ).append("\n"); 
		query.append("     , CNTR_NO" ).append("\n"); 
		query.append("     , CNTR_TPSZ_CD" ).append("\n"); 
		query.append("     , 'X' COP_OP_TP_CD  -- 모두 일단 X" ).append("\n"); 
		query.append("     , 'SPLIT' BKG_OP_RMK" ).append("\n"); 
		query.append("--     , OB_ITCHG_CTNT" ).append("\n"); 
		query.append("--     , IB_ITCHG_CTNT" ).append("\n"); 
		query.append("--     , OCN_ITCHG_CTNT" ).append("\n"); 
		query.append("--     , MTY_PKUP_YD_CD" ).append("\n"); 
		query.append("--     , MTY_RTN_YD_CD" ).append("\n"); 
		query.append("--     , POR_NOD_CD" ).append("\n"); 
		query.append("--     , POL_NOD_CD" ).append("\n"); 
		query.append("--     , BKG_RCV_TERM_CD" ).append("\n"); 
		query.append("--     , BKG_DE_TERM_CD" ).append("\n"); 
		query.append("     , OB_TRO_FLG" ).append("\n"); 
		query.append("     , IB_TRO_FLG" ).append("\n"); 
		query.append("--     , COP_PATT_ORD_NO" ).append("\n"); 
		query.append("     , (SELECT COUNT(*)" ).append("\n"); 
		query.append("        FROM TRS_TRSP_SVC_ORD" ).append("\n"); 
		query.append("        WHERE COP_NO = S.COP_NO " ).append("\n"); 
		query.append("          AND TRSP_SO_TP_CD <> 'S' " ).append("\n"); 
		query.append("          AND NVL(DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("          AND NVL(RPLN_UMCH_FLG,'N') <> 'Y' -- 2010.04.09 추가 by j" ).append("\n"); 
		query.append("          AND NVL(TRSP_FRST_FLG,'N') <> 'Y' ) +" ).append("\n"); 
		query.append("        (SELECT COUNT(*)" ).append("\n"); 
		query.append("         FROM TRS_TRSP_RAIL_BIL_ORD A " ).append("\n"); 
		query.append("         WHERE A.COP_NO = S.COP_NO" ).append("\n"); 
		query.append("          AND NVL(A.TRSP_FRST_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("          AND NVL(A.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("          ) COP_SO_KNT" ).append("\n"); 
		query.append("     , 'SYSTEM' CRE_USR_ID" ).append("\n"); 
		query.append("     , SYSDATE CRE_DT" ).append("\n"); 
		query.append("     , 'SYSTEM' UPD_USR_ID" ).append("\n"); 
		query.append("     , SYSDATE UPD_DT" ).append("\n"); 
		query.append("FROM SCE_COP_HDR S" ).append("\n"); 
		query.append("WHERE BKG_NO = @[parent_bkg_no]" ).append("\n"); 
		query.append("AND NVL(COP_STS_CD, 'N') <> 'X'" ).append("\n"); 

	}
}