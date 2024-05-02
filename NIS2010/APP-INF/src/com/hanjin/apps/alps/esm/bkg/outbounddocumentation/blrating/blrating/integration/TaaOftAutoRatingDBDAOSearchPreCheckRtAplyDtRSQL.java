/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TaaOftAutoRatingDBDAOSearchPreCheckRtAplyDtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.24
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TaaOftAutoRatingDBDAOSearchPreCheckRtAplyDtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Taa OFT계산 가능 여부를 확인하기를 위해 Rate Application Date를 YYYYMMDD 형식으로 조회
	  * </pre>
	  */
	public TaaOftAutoRatingDBDAOSearchPreCheckRtAplyDtRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ca_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration").append("\n"); 
		query.append("FileName : TaaOftAutoRatingDBDAOSearchPreCheckRtAplyDtRSQL").append("\n"); 
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
		query.append("SELECT TO_CHAR((CASE  WHEN RT_APLY_DT - CTRT_EXP_DT BETWEEN 0 AND 7 THEN CTRT_EXP_DT" ).append("\n"); 
		query.append("                      ELSE RT_APLY_DT" ).append("\n"); 
		query.append("                END), 'YYYYMMDD') RT_APLY_DT" ).append("\n"); 
		query.append("FROM ( SELECT NVL(BKG_REV_APLY_DT_PKG.BKG_GET_APLY_DT_FOR_PREC_FNC(@[bkg_no], @[ca_flg]), " ).append("\n"); 
		query.append("                  NVL(BKG_REV_APLY_DT_PKG.BKG_GET_ETD_DT_FNC(@[bkg_no], @[ca_flg]), SYSDATE)) RT_APLY_DT," ).append("\n"); 
		query.append("             (SELECT MAX(M.EXP_DT)" ).append("\n"); 
		query.append("                FROM BKG_BOOKING B, PRI_TAA_HDR H, PRI_TAA_MN M" ).append("\n"); 
		query.append("                WHERE B.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                AND H.TAA_NO = B.TAA_NO" ).append("\n"); 
		query.append("                AND H.TAA_PROP_NO = M.TAA_PROP_NO" ).append("\n"); 
		query.append("                AND M.CFM_FLG = 'Y'" ).append("\n"); 
		query.append("                AND NVL(BKG_REV_APLY_DT_PKG.BKG_GET_APLY_DT_FOR_PREC_FNC(@[bkg_no], @[ca_flg]), " ).append("\n"); 
		query.append("                    NVL(BKG_REV_APLY_DT_PKG.BKG_GET_ETD_DT_FNC(@[bkg_no], @[ca_flg]), SYSDATE))  -- Application Date" ).append("\n"); 
		query.append("                    > M.EXP_DT" ).append("\n"); 
		query.append("                AND 'N' = NVL((SELECT 'Y'     -- 유효기간내에 Application Date가 없는 경우에만 데이터가 조회" ).append("\n"); 
		query.append("                               FROM PRI_TAA_MN" ).append("\n"); 
		query.append("                               WHERE TAA_PROP_NO = M.TAA_PROP_NO" ).append("\n"); 
		query.append("                               AND NVL(BKG_REV_APLY_DT_PKG.BKG_GET_APLY_DT_FOR_PREC_FNC(@[bkg_no], @[ca_flg]), " ).append("\n"); 
		query.append("                                        NVL(BKG_REV_APLY_DT_PKG.BKG_GET_ETD_DT_FNC(@[bkg_no], @[ca_flg]), SYSDATE))" ).append("\n"); 
		query.append("                                    BETWEEN EFF_DT AND EXP_DT" ).append("\n"); 
		query.append("                               AND CFM_FLG = 'Y'" ).append("\n"); 
		query.append("                               AND ROWNUM = 1),'N')" ).append("\n"); 
		query.append("                ) CTRT_EXP_DT" ).append("\n"); 
		query.append("       FROM DUAL" ).append("\n"); 
		query.append("      )" ).append("\n"); 

	}
}