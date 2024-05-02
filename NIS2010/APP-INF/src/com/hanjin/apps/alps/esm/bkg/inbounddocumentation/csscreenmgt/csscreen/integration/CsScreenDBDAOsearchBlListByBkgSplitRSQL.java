/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CsScreenDBDAOsearchBlListByBkgSplitRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.06
*@LastModifier : 윤한
*@LastVersion : 1.0
* 2010.05.06 윤한
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author YH
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CsScreenDBDAOsearchBlListByBkgSplitRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * P.O. No에 둘이상의 B/L 또는 관련 B/L 목록을 List Up하고 아니면 단건의 B/L 항목을 조회한다.
	  * </pre>
	  */
	public CsScreenDBDAOsearchBlListByBkgSplitRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.integration").append("\n"); 
		query.append("FileName : CsScreenDBDAOsearchBlListByBkgSplitRSQL").append("\n"); 
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
		query.append("SELECT BKGM.BKG_NO    " ).append("\n"); 
		query.append("      ,BKGM.BL_NO             -- BL_NO" ).append("\n"); 
		query.append("      ,BKGM.BL_TP_CD          -- BL_TP_CD" ).append("\n"); 
		query.append("      ,BCST.CUST_NM         AS CSTMS_DESC  -- CNEE NAME      " ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT DISTINCT BKG_NO      " ).append("\n"); 
		query.append("    FROM" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("        SELECT FM_BKG_NO BKG_NO, 1 NO --입력 BKG이 SPLIT된 BKG일 때 상위 BKG" ).append("\n"); 
		query.append("        FROM BKG_BOOKING" ).append("\n"); 
		query.append("        WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("        AND BKG_CRE_TP_CD = 'S'" ).append("\n"); 
		query.append("        UNION" ).append("\n"); 
		query.append("        SELECT bkg_no, 2 NO --입력 BKG" ).append("\n"); 
		query.append("        FROM bkg_booking" ).append("\n"); 
		query.append("        WHERE bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("        UNION" ).append("\n"); 
		query.append("        SELECT bkg_no, 3 NO --입력 BKG으로부터 SPLIT된 BKG" ).append("\n"); 
		query.append("        FROM bkg_booking" ).append("\n"); 
		query.append("        WHERE fm_bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("        AND BKG_CRE_TP_CD = 'S'" ).append("\n"); 
		query.append("        UNION" ).append("\n"); 
		query.append("        SELECT bkg_no, 4 no --입력 bkg과 같은 from bkg을 가지는 bkg" ).append("\n"); 
		query.append("        FROM bkg_booking" ).append("\n"); 
		query.append("        WHERE fm_bkg_no IN (SELECT fm_bkg_no" ).append("\n"); 
		query.append("        FROM bkg_booking" ).append("\n"); 
		query.append("        WHERE bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("        AND BKG_CRE_TP_CD = 'S')" ).append("\n"); 
		query.append("        AND BKG_CRE_TP_CD = 'S'" ).append("\n"); 
		query.append("        UNION" ).append("\n"); 
		query.append("        SELECT /*+ INDEX(BKG_BOOKING XPKBKG_BOOKING) */" ).append("\n"); 
		query.append("        BKG_NO, 5 no --empty bkg을 위한 추가 처리" ).append("\n"); 
		query.append("        FROM BKG_BOOKING" ).append("\n"); 
		query.append("        WHERE BKG_CGO_TP_CD = 'P'" ).append("\n"); 
		query.append("        AND BKG_NO LIKE @[bkg_no]||'%'" ).append("\n"); 
		query.append("        AND BKG_NO <> @[bkg_no]" ).append("\n"); 
		query.append("        AND LENGTH(@[bkg_no]) = 11" ).append("\n"); 
		query.append("        UNION" ).append("\n"); 
		query.append("        SELECT /*+ INDEX(BKG_BOOKING XPKBKG_BOOKING) */" ).append("\n"); 
		query.append("        BKG_NO, 5 no --empty bkg을 위한 추가 처리" ).append("\n"); 
		query.append("        FROM BKG_BOOKING" ).append("\n"); 
		query.append("        WHERE BKG_CGO_TP_CD = 'P'" ).append("\n"); 
		query.append("        AND BKG_NO LIKE substr(@[bkg_no], 1, 11)||'%'" ).append("\n"); 
		query.append("        AND BKG_NO <> @[bkg_no]" ).append("\n"); 
		query.append("        AND LENGTH(@[bkg_no]) = 13" ).append("\n"); 
		query.append("        ORDER BY NO" ).append("\n"); 
		query.append("    ) RST1" ).append("\n"); 
		query.append(") RST2, " ).append("\n"); 
		query.append("  BKG_BOOKING BKGM," ).append("\n"); 
		query.append("  BKG_CUSTOMER BCST" ).append("\n"); 
		query.append("WHERE BKGM.BKG_NO = RST2.BKG_NO" ).append("\n"); 
		query.append("AND   BCST.BKG_NO = BKGM.BKG_NO " ).append("\n"); 
		query.append("AND   BCST.BKG_CUST_TP_CD = DECODE(BKGM.CUST_TO_ORD_FLG, 'Y', 'N', 'C')" ).append("\n"); 
		query.append("ORDER BY BKGM.BKG_NO" ).append("\n"); 

	}
}