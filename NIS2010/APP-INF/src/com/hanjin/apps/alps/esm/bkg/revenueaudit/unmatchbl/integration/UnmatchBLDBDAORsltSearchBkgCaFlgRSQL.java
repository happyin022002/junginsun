/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : UnmatchBLDBDAORsltSearchBkgCaFlgRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.10
*@LastModifier : 김진주
*@LastVersion : 1.0
* 2014.11.10 김진주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Jin Joo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UnmatchBLDBDAORsltSearchBkgCaFlgRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * bl no 로 bkg_no, caFlg , ctrt_tp_cd 조회
	  * </pre>
	  */
	public UnmatchBLDBDAORsltSearchBkgCaFlgRSQL(){
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
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.integration").append("\n"); 
		query.append("FileName : UnmatchBLDBDAORsltSearchBkgCaFlgRSQL").append("\n"); 
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
		query.append("SELECT  BKG.BL_NO  ," ).append("\n"); 
		query.append("        BKG.BKG_NO ," ).append("\n"); 
		query.append("        BKG.SVC_SCP_CD ," ).append("\n"); 
		query.append("        NVL(CALC_CTRT_TP_CD,BKG_CTRT_TP_CD) CTRT_TP_CD  ," ).append("\n"); 
		query.append("        'N' CA_FLG     ," ).append("\n"); 
		query.append("         (SELECT ATTR_CTNT1 " ).append("\n"); 
		query.append("          FROM BKG_HRD_CDG_CTNT " ).append("\n"); 
		query.append("          WHERE HRD_CDG_ID = 'SC_AUTORATING_TYPE' " ).append("\n"); 
		query.append("          AND ATTR_CTNT2 = BKG.SVC_SCP_CD) SC_RT_TP," ).append("\n"); 
		query.append("         (SELECT CASE WHEN SUBSTR(BKG.POR_CD,1,2) IN ('US','CA') OR SUBSTR(BKG.DEL_CD,1,2) IN ('US','CA') THEN 'N'" ).append("\n"); 
		query.append("                      WHEN RT.RT_APLY_DT >= TO_DATE(ATTR_CTNT2,'YYYYMMDD') " ).append("\n"); 
		query.append("                           AND RT.RT_APLY_DT <= TO_DATE(ATTR_CTNT3,'YYYYMMDD')" ).append("\n"); 
		query.append("                           AND (SELECT D.CTRT_EFF_DT " ).append("\n"); 
		query.append("                                FROM PRI_RP_HDR H, PRI_RP_DUR D" ).append("\n"); 
		query.append("                                WHERE H.RFA_NO = BKG.RFA_NO" ).append("\n"); 
		query.append("                                AND H.PROP_NO = D.PROP_NO" ).append("\n"); 
		query.append("                                AND RT.RT_APLY_DT BETWEEN D.CTRT_EFF_DT AND D.CTRT_EXP_DT" ).append("\n"); 
		query.append("                                AND ROWNUM = 1) < TO_DATE(ATTR_CTNT2,'YYYYMMDD') THEN 'Y'" ).append("\n"); 
		query.append("                      WHEN RT.RT_APLY_DT >=  TO_DATE(ATTR_CTNT2,'YYYYMMDD') THEN 'FIC'" ).append("\n"); 
		query.append("                      WHEN RT.RT_APLY_DT BETWEEN TO_DATE(ATTR_CTNT1,'YYYYMMDD') AND TO_DATE(ATTR_CTNT2,'YYYYMMDD') THEN 'Y'" ).append("\n"); 
		query.append("                      ELSE 'N'" ).append("\n"); 
		query.append("                 END HINTER_FLG" ).append("\n"); 
		query.append("          FROM BKG_HRD_CDG_CTNT H" ).append("\n"); 
		query.append("          WHERE HRD_CDG_ID = 'HINTERLAND_APLY_FLG') HINTER_FLG ," ).append("\n"); 
		query.append(" 		 RT.FRT_TERM_CD" ).append("\n"); 
		query.append(" FROM    BKG_BOOKING BKG" ).append("\n"); 
		query.append("        ,BKG_RATE RT" ).append("\n"); 
		query.append(" WHERE   (BKG.BL_NO = @[bl_no] OR BKG.BKG_NO = @[bl_no])" ).append("\n"); 
		query.append("   AND   BKG.BKG_NO = RT.BKG_NO" ).append("\n"); 
		query.append("   AND   'N' = @[ca_flg]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" UNION ALL" ).append("\n"); 
		query.append(" SELECT  BKG.BL_NO  ," ).append("\n"); 
		query.append("         BKG.BKG_NO ," ).append("\n"); 
		query.append("         BKG.SVC_SCP_CD ," ).append("\n"); 
		query.append("         NVL(CALC_CTRT_TP_CD,BKG_CTRT_TP_CD)," ).append("\n"); 
		query.append("         'Y' CA_FLG," ).append("\n"); 
		query.append("         (SELECT ATTR_CTNT1 " ).append("\n"); 
		query.append("          FROM BKG_HRD_CDG_CTNT " ).append("\n"); 
		query.append("          WHERE HRD_CDG_ID = 'SC_AUTORATING_TYPE' " ).append("\n"); 
		query.append("          AND ATTR_CTNT2 = SVC_SCP_CD) SC_RT_TP ," ).append("\n"); 
		query.append("         (SELECT CASE WHEN SUBSTR(BKG.POR_CD,1,2) IN ('US','CA') OR SUBSTR(BKG.DEL_CD,1,2) IN ('US','CA') THEN 'N'" ).append("\n"); 
		query.append("                      WHEN RT.RT_APLY_DT >= TO_DATE(ATTR_CTNT2,'YYYYMMDD') " ).append("\n"); 
		query.append("                           AND RT.RT_APLY_DT <= TO_DATE(ATTR_CTNT3,'YYYYMMDD')" ).append("\n"); 
		query.append("                           AND (SELECT D.CTRT_EFF_DT " ).append("\n"); 
		query.append("                                FROM PRI_RP_HDR H, PRI_RP_DUR D" ).append("\n"); 
		query.append("                                WHERE H.RFA_NO = BKG.RFA_NO" ).append("\n"); 
		query.append("                                AND H.PROP_NO = D.PROP_NO" ).append("\n"); 
		query.append("                                AND RT.RT_APLY_DT BETWEEN D.CTRT_EFF_DT AND D.CTRT_EXP_DT" ).append("\n"); 
		query.append("                                AND ROWNUM = 1) < TO_DATE(ATTR_CTNT2,'YYYYMMDD') THEN 'Y'" ).append("\n"); 
		query.append("                      WHEN RT.RT_APLY_DT >=  TO_DATE(ATTR_CTNT2,'YYYYMMDD') THEN 'FIC'" ).append("\n"); 
		query.append("                      WHEN RT.RT_APLY_DT BETWEEN TO_DATE(ATTR_CTNT1,'YYYYMMDD') AND TO_DATE(ATTR_CTNT2,'YYYYMMDD') THEN 'Y'" ).append("\n"); 
		query.append("                      ELSE 'N'" ).append("\n"); 
		query.append("                 END HINTER_FLG" ).append("\n"); 
		query.append("          FROM BKG_HRD_CDG_CTNT H" ).append("\n"); 
		query.append("          WHERE HRD_CDG_ID = 'HINTERLAND_APLY_FLG')HINTER_FLG ," ).append("\n"); 
		query.append("		 RT.FRT_TERM_CD" ).append("\n"); 
		query.append(" FROM    BKG_BKG_HIS BKG" ).append("\n"); 
		query.append("        ,BKG_RATE RT" ).append("\n"); 
		query.append(" WHERE   (BKG.BL_NO = @[bl_no] OR BKG.BKG_NO = @[bl_no])" ).append("\n"); 
		query.append(" AND     BKG.BKG_NO = RT.BKG_NO" ).append("\n"); 
		query.append(" AND     CORR_NO = 'TMP0000001'  -- CORRECTION 중인 DATA 를 나타내는 고정된 상수값" ).append("\n"); 
		query.append(" AND     'Y' = @[ca_flg]" ).append("\n"); 

	}
}