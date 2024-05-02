/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : DisposalMgtDBDAOsearchDisposalSoldListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.11.23
*@LastModifier : 
*@LastVersion : 1.0
* 2016.11.23 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DisposalMgtDBDAOsearchDisposalSoldListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Disposal Sold Creation 에서 Header 조회
	  * </pre>
	  */
	public DisposalMgtDBDAOsearchDisposalSoldListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("apro_dt_fr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_prnr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_prnr_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("apro_dt_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.integration").append("\n"); 
		query.append("FileName : DisposalMgtDBDAOsearchDisposalSoldListDataRSQL").append("\n"); 
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
		query.append("SELECT A.DISP_NO" ).append("\n"); 
		query.append("     , B.DISP_UT_TP_CD" ).append("\n"); 
		query.append("     , TO_CHAR(A.APRO_DT,'YYYY-MM-DD')  AS APRO_DT" ).append("\n"); 
		query.append("     , MNR_COMMON_PKG.MNR_CONV_PARTNER_CD_FNC(B.MNR_PRNR_SEQ, B.MNR_PRNR_CNT_CD) AS BUYER_CODE" ).append("\n"); 
		query.append("     , E.MNR_PRNR_LGL_ENG_NM AS BUYER_NAME" ).append("\n"); 
		query.append("     , B.SOLD_QTY" ).append("\n"); 
		query.append("     , B.PENDING_QTY" ).append("\n"); 
		query.append("     , B.TOTAL_QTY" ).append("\n"); 
		query.append("     , A.EQ_KND_CD" ).append("\n"); 
		query.append("	 , B.MNR_PRNR_CNT_CD" ).append("\n"); 
		query.append("     , B.MNR_PRNR_SEQ" ).append("\n"); 
		query.append("     , E.FAX_NO" ).append("\n"); 
		query.append("     , E.MNR_PRNR_EML" ).append("\n"); 
		query.append("  FROM MNR_DISP_HDR A" ).append("\n"); 
		query.append("     , (SELECT C.DISP_NO" ).append("\n"); 
		query.append("             , SUM(DECODE(D.DISP_SOLD_DT, NULL, 0, D.DISP_QTY)) AS SOLD_QTY" ).append("\n"); 
		query.append("             , SUM(DECODE(D.DISP_SOLD_DT, NULL, D.DISP_QTY)) AS PENDING_QTY" ).append("\n"); 
		query.append("             , SUM(D.DISP_QTY)  AS TOTAL_QTY" ).append("\n"); 
		query.append("			 , D.MNR_PRNR_CNT_CD" ).append("\n"); 
		query.append("			 , D.MNR_PRNR_SEQ  " ).append("\n"); 
		query.append(" 			 , D.MNR_PRNR_CNT_CD || D.MNR_PRNR_SEQ  AS BUYER_CODE " ).append("\n"); 
		query.append("             , D.DISP_UT_TP_CD" ).append("\n"); 
		query.append("          FROM MNR_DISP_HDR C" ).append("\n"); 
		query.append("             , MNR_DISP_DTL D" ).append("\n"); 
		query.append("         WHERE C.DISP_NO = D.DISP_NO" ).append("\n"); 
		query.append("           AND D.MNR_PRNR_CNT_CD IS NOT NULL " ).append("\n"); 
		query.append("           #if (${status} == 'S') " ).append("\n"); 
		query.append("           AND C.DISP_STS_CD = 'HE'" ).append("\n"); 
		query.append("           #else " ).append("\n"); 
		query.append("           AND C.DISP_STS_CD IN( 'HC', 'HP')" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		   #if (${eq_no} != '') " ).append("\n"); 
		query.append("           AND D.EQ_NO IN (" ).append("\n"); 
		query.append("           	   #foreach ($user_eq_no IN ${eq_no})" ).append("\n"); 
		query.append("  			       #if($velocityCount < $eq_no.size())" ).append("\n"); 
		query.append("  				       '$user_eq_no'," ).append("\n"); 
		query.append("  			       #else" ).append("\n"); 
		query.append("  				       '$user_eq_no'" ).append("\n"); 
		query.append("  			       #end" ).append("\n"); 
		query.append("  		       #end			  " ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("         " ).append("\n"); 
		query.append("		 GROUP BY C.DISP_NO,D.MNR_PRNR_CNT_CD,D.MNR_PRNR_SEQ,D.DISP_UT_TP_CD" ).append("\n"); 
		query.append("       ) B" ).append("\n"); 
		query.append("     , MNR_PARTNER E" ).append("\n"); 
		query.append(" WHERE A.DISP_NO = B.DISP_NO" ).append("\n"); 
		query.append("   AND A.RQST_OFC_CD = @[rqst_ofc_cd]" ).append("\n"); 
		query.append("   AND B.MNR_PRNR_CNT_CD = E.MNR_PRNR_CNT_CD(+)" ).append("\n"); 
		query.append("   AND B.MNR_PRNR_SEQ = E.MNR_PRNR_SEQ(+)" ).append("\n"); 
		query.append("   AND 'C' = E.MNR_PRNR_STS_CD(+)" ).append("\n"); 
		query.append("   AND E.MNR_GRP_TP_CD = 'DSP'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   #if (${status} == 'S') " ).append("\n"); 
		query.append("   AND A.DISP_STS_CD = 'HE'" ).append("\n"); 
		query.append("   #else " ).append("\n"); 
		query.append("   AND A.DISP_STS_CD IN ( 'HC', 'HP')" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   AND A.EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("   AND A.APRO_DT BETWEEN GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[user_ofc_cd],TO_DATE(@[apro_dt_fr], 'YYYY-MM-DD'), MNR_COMMON_PKG.MNR_GET_HOOFC_FNC()) " ).append("\n"); 
		query.append("                     AND GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[user_ofc_cd],TO_DATE(@[apro_dt_to]||'23:59:59','YYYY-MM-DD HH24:MI:SS'), MNR_COMMON_PKG.MNR_GET_HOOFC_FNC())" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   #if (${disp_no} != '') " ).append("\n"); 
		query.append("   AND A.DISP_NO IN ( " ).append("\n"); 
		query.append("  		#foreach ($user_disp_no IN ${disp_no})" ).append("\n"); 
		query.append("  			#if($velocityCount < $disp_no.size())" ).append("\n"); 
		query.append("  				'$user_disp_no'," ).append("\n"); 
		query.append("  			#else" ).append("\n"); 
		query.append("  				'$user_disp_no'" ).append("\n"); 
		query.append("  			#end" ).append("\n"); 
		query.append("  		#end			  " ).append("\n"); 
		query.append("   )" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   #if (${mnr_prnr_seq} != '') " ).append("\n"); 
		query.append("   AND B.MNR_PRNR_CNT_CD = @[mnr_prnr_cnt_cd]" ).append("\n"); 
		query.append("   AND B.MNR_PRNR_SEQ = TO_NUMBER(@[mnr_prnr_seq])" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" ORDER BY A.DISP_NO DESC" ).append("\n"); 

	}
}