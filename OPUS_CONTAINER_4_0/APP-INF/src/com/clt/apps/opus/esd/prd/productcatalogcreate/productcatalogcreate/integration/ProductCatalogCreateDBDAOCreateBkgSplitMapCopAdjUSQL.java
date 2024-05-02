/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ProductCatalogCreateDBDAOCreateBkgSplitMapCopAdjUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.09.01
*@LastModifier : 박만건
*@LastVersion : 1.0
* 2011.09.01 박만건
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author ParkMangeon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ProductCatalogCreateDBDAOCreateBkgSplitMapCopAdjUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Booking Split시 경우에 따라 COP가 삭제 상태로 계속 유지될 수 있다.
	  * 이 경우 COP를 Split되는 booking중 첫 Booking으로 전달한다.
	  * 
	  * 이것은 Booking split을 사용자가 이상하게 사용한 경우로
	  * cop가 어디에도 연결안되고 사라져버리는 경우를 방지하기 위함
	  * </pre>
	  */
	public ProductCatalogCreateDBDAOCreateBkgSplitMapCopAdjUSQL(){
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
		params.put("mapg_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("parent_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.integration").append("\n"); 
		query.append("FileName : ProductCatalogCreateDBDAOCreateBkgSplitMapCopAdjUSQL").append("\n"); 
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
		query.append("MERGE INTO PRD_BKG_COP_MAP A" ).append("\n"); 
		query.append("USING" ).append("\n"); 
		query.append("( SELECT ROWID AS ROW_ID" ).append("\n"); 
		query.append("       , @[bkg_no] AS BKG_NO  -- key" ).append("\n"); 
		query.append("       , @[mapg_seq] AS COP_MAPG_SEQ -- key" ).append("\n"); 
		query.append("       , DECODE(@[bkg_no],@[parent_bkg_no],'N','B') AS COP_OP_TP_CD" ).append("\n"); 
		query.append("       , (SELECT COUNT(1)" ).append("\n"); 
		query.append("            FROM TRS_TRSP_SVC_ORD" ).append("\n"); 
		query.append("           WHERE COP_NO = CMAP.COP_NO" ).append("\n"); 
		query.append("             AND TRSP_SO_TP_CD <> 'S'" ).append("\n"); 
		query.append("             AND NVL(DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("             AND NVL(RPLN_UMCH_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("             AND NVL(TRSP_FRST_FLG,'N') <> 'Y' )" ).append("\n"); 
		query.append("        +(SELECT COUNT(1)" ).append("\n"); 
		query.append("            FROM TRS_TRSP_RAIL_BIL_ORD A" ).append("\n"); 
		query.append("           WHERE A.COP_NO = CMAP.COP_NO" ).append("\n"); 
		query.append("             AND NVL(A.TRSP_FRST_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("             AND NVL(A.DELT_FLG,'N') <> 'Y')" ).append("\n"); 
		query.append("        AS COP_SO_KNT" ).append("\n"); 
		query.append("   FROM PRD_BKG_COP_MAP CMAP" ).append("\n"); 
		query.append("   WHERE CMAP.BKG_NO = @[parent_bkg_no]" ).append("\n"); 
		query.append("     AND CMAP.CRNT_FLG = 'Y'" ).append("\n"); 
		query.append("     AND CMAP.COP_OP_TP_CD = 'X' -- 삭제가 유지될 대상 중" ).append("\n"); 
		query.append("     AND ( CMAP.CNTR_NO IS NULL -- Container가 없는 COP를 대상으로" ).append("\n"); 
		query.append("          OR CMAP.CNTR_NO = 'COMU0000000')" ).append("\n"); 
		query.append("     AND (SELECT COUNT(1)  -- 살아있는 SO가 있는 경우 데이터 유지" ).append("\n"); 
		query.append("            FROM TRS_TRSP_SVC_ORD" ).append("\n"); 
		query.append("           WHERE COP_NO = CMAP.COP_NO" ).append("\n"); 
		query.append("            AND TRSP_SO_TP_CD <> 'S'" ).append("\n"); 
		query.append("            AND NVL(DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("            AND NVL(RPLN_UMCH_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("            AND NVL(TRSP_FRST_FLG,'N') <> 'Y' )" ).append("\n"); 
		query.append("       +(SELECT COUNT(1)" ).append("\n"); 
		query.append("           FROM TRS_TRSP_RAIL_BIL_ORD A" ).append("\n"); 
		query.append("          WHERE A.COP_NO = CMAP.COP_NO" ).append("\n"); 
		query.append("            AND NVL(A.TRSP_FRST_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("            AND NVL(A.DELT_FLG,'N') <> 'Y')" ).append("\n"); 
		query.append("      > 0" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("ON (A.ROWID = B.ROW_ID )" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE SET " ).append("\n"); 
		query.append("     A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("   , A.COP_MAPG_SEQ = B.COP_MAPG_SEQ" ).append("\n"); 
		query.append("   , A.COP_OP_TP_CD = B.COP_OP_TP_CD" ).append("\n"); 
		query.append("   , A.COP_SO_KNT = B.COP_SO_KNT" ).append("\n"); 
		query.append("   , A.UPD_USR_ID = 'SYSTEM3_U'" ).append("\n"); 
		query.append("   , A.UPD_DT = SYSDATE" ).append("\n"); 
		query.append("-- UPDATE 구문을 사용시 SET절에 SELECT + SELECT 구문을 사용하지 못하므로 MERGE 구문 사용" ).append("\n"); 

	}
}