/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ArrivalNoticeDBDAOaddArrNtcValInfoCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.15
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ArrivalNoticeDBDAOaddArrNtcValInfoCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Code Validation을 통해 Arrival Notice Master정보를 생성
	  * </pre>
	  */
	public ArrivalNoticeDBDAOaddArrNtcValInfoCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ts_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration").append("\n"); 
		query.append("FileName : ArrivalNoticeDBDAOaddArrNtcValInfoCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_ARR_NTC " ).append("\n"); 
		query.append("       (BKG_NO" ).append("\n"); 
		query.append("      , VSL_CD" ).append("\n"); 
		query.append("      , SKD_VOY_NO" ).append("\n"); 
		query.append("      , SKD_DIR_CD" ).append("\n"); 
		query.append("      , CRE_USR_ID" ).append("\n"); 
		query.append("      , CRE_DT  " ).append("\n"); 
		query.append("      , UPD_USR_ID -- 15" ).append("\n"); 
		query.append("      , UPD_DT " ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("SELECT DISTINCT BKGM.BKG_NO" ).append("\n"); 
		query.append("     , BVVD.VSL_CD" ).append("\n"); 
		query.append("     , BVVD.SKD_VOY_NO" ).append("\n"); 
		query.append("     , BVVD.SKD_DIR_CD" ).append("\n"); 
		query.append("     , @[usr_id]" ).append("\n"); 
		query.append("     , SYSDATE" ).append("\n"); 
		query.append("     , @[usr_id]" ).append("\n"); 
		query.append("     , SYSDATE" ).append("\n"); 
		query.append(" FROM BKG_CUSTOMER BCST" ).append("\n"); 
		query.append("     JOIN BKG_BOOKING BKGM ON" ).append("\n"); 
		query.append("        ( BKGM.BKG_NO =BCST.BKG_NO ) " ).append("\n"); 
		query.append("     JOIN BKG_VVD BVVD ON" ).append("\n"); 
		query.append("        ( BVVD.BKG_NO = BKGM.BKG_NO" ).append("\n"); 
		query.append("          AND BVVD.VSL_PRE_PST_CD IN ('T', 'U')" ).append("\n"); 
		query.append("          AND BVVD.POD_CD = DECODE(@[ts_flg], 'Y', BKGM.PST_RLY_PORT_CD, BKGM.POD_CD)" ).append("\n"); 
		query.append("		  /* 이집트의 경우  POL POD가 같을 수 있어 데이타가 중복 발생을 방지하기 위해 YARD까지 체크함. 2014.10.15 추가함 */" ).append("\n"); 
		query.append("          AND DECODE(SUBSTR(BKGM.POD_CD,1,2),'EG',BVVD.POD_YD_CD,1) = DECODE(SUBSTR(BKGM.POD_CD,1,2),'EG',BKGM.POD_NOD_CD,1)" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("WHERE BCST.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("  AND BCST.BKG_CUST_TP_CD IN ('C', 'N')" ).append("\n"); 
		query.append("  AND BCST.AN_SND_FLG = 'Y' " ).append("\n"); 
		query.append("  AND BKGM.BKG_STS_CD NOT IN ('X', 'S') -- 무효한 bkg제거 -- AS IS와 동일하게 하기위해 추가 20091124" ).append("\n"); 
		query.append("  AND BKGM.BL_NO IS NOT NULL  -- AS IS와 동일하게 하기위해 추가 20091124" ).append("\n"); 
		query.append("  AND BKGM.BKG_CGO_TP_CD IN ('F', 'R') -- full, revenue empty container" ).append("\n"); 
		query.append("  AND NOT EXISTS ( SELECT 1 " ).append("\n"); 
		query.append("                       FROM BKG_ARR_NTC ANTC" ).append("\n"); 
		query.append("                      WHERE ANTC.BKG_NO = BKGM.BKG_NO" ).append("\n"); 
		query.append("                   )" ).append("\n"); 

	}
}