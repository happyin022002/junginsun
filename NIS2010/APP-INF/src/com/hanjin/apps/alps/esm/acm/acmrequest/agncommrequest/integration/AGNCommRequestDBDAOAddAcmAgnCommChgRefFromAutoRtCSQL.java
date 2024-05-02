/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AGNCommRequestDBDAOAddAcmAgnCommChgRefFromAutoRtCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.09
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.09 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmrequest.agncommrequest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGNCommRequestDBDAOAddAcmAgnCommChgRefFromAutoRtCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Surcharge 공제 대상 charge code 조회. Booking Auto Rating 사용
	  * </pre>
	  */
	public AGNCommRequestDBDAOAddAcmAgnCommChgRefFromAutoRtCSQL(){
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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rt_aply_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmrequest.agncommrequest.integration").append("\n"); 
		query.append("FileName : AGNCommRequestDBDAOAddAcmAgnCommChgRefFromAutoRtCSQL").append("\n"); 
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
		query.append("INSERT INTO ACM_AGN_COMM_CHG_REF" ).append("\n"); 
		query.append("SELECT BKG_NO," ).append("\n"); 
		query.append("  CHG_CD," ).append("\n"); 
		query.append("  BKG_AGMT_UT_CD," ).append("\n"); 
		query.append("  SPCL_CGO_CTNT," ).append("\n"); 
		query.append("  CURR_CD," ).append("\n"); 
		query.append("  ROUT_TRF_FX_AMT," ).append("\n"); 
		query.append("  ROUT_TRF_RT," ).append("\n"); 
		query.append("  @[usr_id]," ).append("\n"); 
		query.append("  SYSDATE," ).append("\n"); 
		query.append("  @[usr_id]," ).append("\n"); 
		query.append("  SYSDATE" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("  SELECT RT.BKG_NO," ).append("\n"); 
		query.append("    RT.CHG_CD," ).append("\n"); 
		query.append("    RT.RAT_UT_CD AS BKG_AGMT_UT_CD," ).append("\n"); 
		query.append("    RT.CGO_CATE_CD AS SPCL_CGO_CTNT," ).append("\n"); 
		query.append("    RT.CURR_CD," ).append("\n"); 
		query.append("    SUM(NVL(RT.CHG_AMT, 0)) AS ROUT_TRF_FX_AMT," ).append("\n"); 
		query.append("    0 AS ROUT_TRF_RT" ).append("\n"); 
		query.append("  FROM BKG_TRF_SCG_RT RT, --BKG_AUTO_RT_HIS RT," ).append("\n"); 
		query.append("    BKG_BOOKING BKG" ).append("\n"); 
		query.append("  WHERE BKG.BKG_NO = RT.BKG_NO" ).append("\n"); 
		query.append("    AND BKG.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("    AND RT.CHG_CD IN (CASE WHEN @[rt_aply_dt] > '20101231' AND RT.CHG_CD = 'FRC' THEN '*'" ).append("\n"); 
		query.append("                           WHEN RT.CHG_CD = 'CFR' AND BKG.RCV_TERM_CD = 'S' THEN 'CFR'" ).append("\n"); 
		query.append("                           WHEN RT.CHG_CD = 'CFD' AND BKG.DE_TERM_CD = 'S' THEN 'CFD'" ).append("\n"); 
		query.append("                           WHEN RT.CHG_CD = 'CFR' THEN '*'" ).append("\n"); 
		query.append("                           WHEN RT.CHG_CD = 'CFD' THEN '*'" ).append("\n"); 
		query.append("                           WHEN RT.CHG_CD = 'THC' AND (BKG.RCV_TERM_CD IN ('T', 'I', 'O') OR BKG.DE_TERM_CD IN ('T', 'I', 'O')) THEN '*'" ).append("\n"); 
		query.append("                           WHEN RT.CHG_CD = 'OTH' AND BKG.RCV_TERM_CD IN ('T', 'I') THEN '*'" ).append("\n"); 
		query.append("                           WHEN RT.CHG_CD = 'DTH' AND BKG.DE_TERM_CD  IN ('T','O') THEN '*'" ).append("\n"); 
		query.append("                           ELSE RT.CHG_CD" ).append("\n"); 
		query.append("                      END" ).append("\n"); 
		query.append("                     )" ).append("\n"); 
		query.append("  GROUP BY RT.BKG_NO, RT.CHG_CD, RT.RAT_UT_CD, RT.CGO_CATE_CD, RT.CURR_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}