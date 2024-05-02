/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AgreementCorrectionDBDAOSearchCorrScgAgmtTotRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.29
*@LastModifier : 신동일
*@LastVersion : 1.0
* 2015.10.29 신동일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DONG- IL, SHIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AgreementCorrectionDBDAOSearchCorrScgAgmtTotRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Agreement Surcharge Rate 총계 조회
	  * </pre>
	  */
	public AgreementCorrectionDBDAOSearchCorrScgAgmtTotRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("page_size",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_agmtno",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_trsp_agmt_rt_tp_ser_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_eq_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.integration").append("\n"); 
		query.append("FileName : AgreementCorrectionDBDAOSearchCorrScgAgmtTotRSQL").append("\n"); 
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
		query.append("SELECT CEIL(COUNT(1)/@[page_size]) AS TOT_CNT" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("    SELECT 1" ).append("\n"); 
		query.append("      FROM  TRS_AGMT_HDR   A" ).append("\n"); 
		query.append("           ,TRS_AGMT_RT_TP C" ).append("\n"); 
		query.append("           ,TRS_AGMT_SCG_NOD   D" ).append("\n"); 
		query.append("           ,TRS_AGMT_SCG_RT E" ).append("\n"); 
		query.append("     WHERE A.TRSP_AGMT_OFC_CTY_CD   = C.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("       AND A.TRSP_AGMT_SEQ          = C.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("       AND C.TRSP_AGMT_OFC_CTY_CD   = D.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("       AND C.TRSP_AGMT_SEQ          = D.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("       AND C.TRSP_AGMT_RT_TP_SER_NO = D.TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("       AND D.TRSP_AGMT_OFC_CTY_CD   = E.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("       AND D.TRSP_AGMT_SEQ          = E.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("       AND D.TRSP_AGMT_RT_TP_SER_NO = E.TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("       AND D.TRSP_AGMT_SCG_NOD_SEQ  = E.TRSP_AGMT_SCG_NOD_SEQ" ).append("\n"); 
		query.append("       AND A.TRSP_AGMT_OFC_CTY_CD   = SUBSTR(@[fm_agmtno],1,3)" ).append("\n"); 
		query.append("       AND A.TRSP_AGMT_SEQ          = SUBSTR(@[fm_agmtno],4)" ).append("\n"); 
		query.append("       AND NVL(E.DELT_FLG, 'N')     = 'N'" ).append("\n"); 
		query.append("       #if (${fm_trsp_agmt_rt_tp_ser_no} != '' )" ).append("\n"); 
		query.append("          AND C.TRSP_AGMT_RT_TP_SER_NO = @[fm_trsp_agmt_rt_tp_ser_no]" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("       #if (${fm_effective_agmt} != 'A' )" ).append("\n"); 
		query.append("          AND (SELECT GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(A.CTRT_OFC_CD) FROM DUAL) BETWEEN E.EFF_FM_DT AND E.EFF_TO_DT" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       #if (${fm_eq_knd_cd} != '' )" ).append("\n"); 
		query.append("          AND E.EQ_KND_CD = @[fm_eq_knd_cd]" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	 GROUP BY C.TRSP_AGMT_RT_TP_CD" ).append("\n"); 
		query.append("             ,C.TRSP_COST_MOD_CD" ).append("\n"); 
		query.append("             ,C.AGMT_TRSP_TP_CD" ).append("\n"); 
		query.append("             ,C.CGO_TP_CD" ).append("\n"); 
		query.append("		     ,C.CUST_NOMI_TRKR_FLG" ).append("\n"); 
		query.append("             ,C.CUST_NOMI_TRKR_IND_CD" ).append("\n"); 
		query.append("             ,C.CUST_CNT_CD||C.CUST_SEQ" ).append("\n"); 
		query.append("             ,C.CMDT_GRP_CD" ).append("\n"); 
		query.append("             ,C.RAIL_SVC_TP_CD" ).append("\n"); 
		query.append("             ,D.TRSP_SCG_CD" ).append("\n"); 
		query.append("             ,D.AGMT_ROUT_ALL_FLG" ).append("\n"); 
		query.append("             ,SUBSTR(D.FM_NOD_CD,1,5)" ).append("\n"); 
		query.append("             ,SUBSTR(D.FM_NOD_CD,6)" ).append("\n"); 
		query.append("             ,SUBSTR(D.VIA_NOD_CD,1,5)" ).append("\n"); 
		query.append("             ,SUBSTR(D.VIA_NOD_CD,6)" ).append("\n"); 
		query.append("             ,SUBSTR(D.DOR_NOD_CD,1,5)" ).append("\n"); 
		query.append("             ,SUBSTR(D.DOR_NOD_CD,6)" ).append("\n"); 
		query.append("             ,SUBSTR(D.TO_NOD_CD,1,5)" ).append("\n"); 
		query.append("             ,SUBSTR(D.TO_NOD_CD,6)" ).append("\n"); 
		query.append("             ,D.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("             ,D.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("             ,D.TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("             ,D.TRSP_AGMT_SCG_NOD_SEQ" ).append("\n"); 
		query.append("             ,E.CURR_CD" ).append("\n"); 
		query.append("             ,E.TRSP_ONE_WY_RT" ).append("\n"); 
		query.append("             ,E.TRSP_RND_RT" ).append("\n"); 
		query.append("             ,E.TO_WGT" ).append("\n"); 
		query.append("             ,E.WGT_MEAS_UT_CD" ).append("\n"); 
		query.append("             ,TO_CHAR(E.EFF_FM_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("             ,TO_CHAR(E.EFF_TO_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("             ,CASE WHEN SUBSTR(E.TRSP_AGMT_EQ_TP_SZ_CD,1,2) = 'AL' THEN 1" ).append("\n"); 
		query.append("                   WHEN SUBSTR(E.TRSP_AGMT_EQ_TP_SZ_CD,2,2) = 'AL' THEN 1" ).append("\n"); 
		query.append("                   WHEN SUBSTR(E.TRSP_AGMT_EQ_TP_SZ_CD,3,2) = 'AL' THEN 1" ).append("\n"); 
		query.append("                   ELSE 0" ).append("\n"); 
		query.append("              END" ).append("\n"); 
		query.append("             ,AGMT_SCG_RT_DIV_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}