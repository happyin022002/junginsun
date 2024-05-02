/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SurchargeAutoRatingDBDAOSearchHinterlandApplyFlagRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.12.12
*@LastModifier : 
*@LastVersion : 1.0
* 2012.12.12 
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

public class SurchargeAutoRatingDBDAOSearchHinterlandApplyFlagRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 구주 Hinterland 업무 개선 T/F 
	  *  AEE, AEW Scope에 대해 신규 적용되는 Autorating 로직 적용 기준일자를 확인하여
	  *  신규 로직으로 Rating할지의 여부를 조회한다.
	  * 
	  * 2차 T/F 적용일 : 2013.1.1
	  *  - 미주가 포함되지 않은 전 Scope에 Add-On, IHC Tariff를 적용한다.
	  *  - 2013.1.1~18까지는 RFA 업데이트 유예기간으로, 
	  *    이 기간동안 Rating시에는 RFA가 업데이트 되었는지를 확인 후
	  *    업데이트 된 경우에는 신규로직, 업데이트 되지 않은 경우 기존 로직으로 Rating 한다.
	  * </pre>
	  */
	public SurchargeAutoRatingDBDAOSearchHinterlandApplyFlagRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rt_aply_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : SurchargeAutoRatingDBDAOSearchHinterlandApplyFlagRSQL").append("\n"); 
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
		query.append("SELECT CASE WHEN SUBSTR(BK.POR_CD,1,2) IN ('US','CA') OR SUBSTR(BK.DEL_CD,1,2) IN ('US','CA') THEN 'N'" ).append("\n"); 
		query.append("            WHEN TO_DATE(@[rt_aply_dt],'YYYYMMDD') BETWEEN TO_DATE(ATTR_CTNT1,'YYYYMMDD') AND TO_DATE(ATTR_CTNT2,'YYYYMMDD')-1 THEN 'Y'" ).append("\n"); 
		query.append("            WHEN TO_DATE(@[rt_aply_dt],'YYYYMMDD') >= TO_DATE(ATTR_CTNT2,'YYYYMMDD') " ).append("\n"); 
		query.append("                 AND TO_DATE(@[rt_aply_dt],'YYYYMMDD') <= TO_DATE(ATTR_CTNT3,'YYYYMMDD')" ).append("\n"); 
		query.append("                 AND (SELECT D.CTRT_EFF_DT " ).append("\n"); 
		query.append("                        FROM PRI_RP_HDR H, PRI_RP_DUR D" ).append("\n"); 
		query.append("                       WHERE H.RFA_NO = BK.RFA_NO" ).append("\n"); 
		query.append("                         AND H.PROP_NO = D.PROP_NO" ).append("\n"); 
		query.append("                         AND TO_DATE(@[rt_aply_dt],'YYYYMMDD') BETWEEN D.CTRT_EFF_DT AND D.CTRT_EXP_DT" ).append("\n"); 
		query.append("                         AND ROWNUM = 1) < TO_DATE(ATTR_CTNT2,'YYYYMMDD') THEN 'Y'" ).append("\n"); 
		query.append("            WHEN TO_DATE(@[rt_aply_dt],'YYYYMMDD') >= TO_DATE(ATTR_CTNT2,'YYYYMMDD') THEN 'FIC'" ).append("\n"); 
		query.append("            ELSE 'N'" ).append("\n"); 
		query.append("            END HINTERLAND_APLY_FLG" ).append("\n"); 
		query.append("FROM BKG_HRD_CDG_CTNT," ).append("\n"); 
		query.append("	(SELECT RFA_NO, POR_CD, DEL_CD FROM BKG_BOOKING WHERE BKG_NO = @[bkg_no] AND 'N' = @[ca_flg]" ).append("\n"); 
		query.append("	 UNION ALL" ).append("\n"); 
		query.append("	 SELECT RFA_NO, POR_CD, DEL_CD FROM BKG_BKG_HIS WHERE BKG_NO = @[bkg_no] AND CORR_NO = 'TMP0000001' AND 'Y' = @[ca_flg]) BK" ).append("\n"); 
		query.append("WHERE HRD_CDG_ID = 'HINTERLAND_APLY_FLG'" ).append("\n"); 

	}
}