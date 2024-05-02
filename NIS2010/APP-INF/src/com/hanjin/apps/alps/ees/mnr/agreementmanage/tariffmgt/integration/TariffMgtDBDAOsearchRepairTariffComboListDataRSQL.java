/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TariffMgtDBDAOsearchRepairTariffComboListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.07
*@LastModifier : 박정민
*@LastVersion : 1.0
* 2015.08.07 박정민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.agreementmanage.tariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeong Min Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TariffMgtDBDAOsearchRepairTariffComboListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	  * searchRepairTariffComboListData
	  * 2014-03-17 Ticket : CHM-201429359 Title : ALPS - MNR-Agreement/Tariff Creation 시에 Tariff No가 Agreement No에 Interface가 안되는 문제 TD : Jonghee HAN DEV : Jonghee HAN -> CRE_DT 조건 제외하고 가장 최근 TARIFF를 1건 보여줌
	  * -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	  * 2015-02-24 Ticket : CHM-201534100 - 한국지역 조직도 setting 요청
	  * DESC : RQST_OFC_CD에 하위 OFFICE를 포함하여 조회
	  *           TYOSC(TYOIB), SELSC(SELIB)는 DB구조상 예외를 둔다
	  * By : Jeong-Min, Park
	  * ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	  * </pre>
	  */
	public TariffMgtDBDAOsearchRepairTariffComboListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_trf_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_trf_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.agreementmanage.tariffmgt.integration").append("\n"); 
		query.append("FileName : TariffMgtDBDAOsearchRepairTariffComboListDataRSQL").append("\n"); 
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
		query.append("SELECT    A.TRF_NO" ).append("\n"); 
		query.append(", A.MNR_TRF_KND_CD" ).append("\n"); 
		query.append(", MNR_COMMON_PKG.MNR_CONV_PARTNER_CD_FNC(A.VNDR_SEQ) AS VNDR_SEQ" ).append("\n"); 
		query.append(", (SELECT B.VNDR_LGL_ENG_NM FROM MDM_VENDOR B WHERE B.VNDR_SEQ = A.VNDR_SEQ) VNDR_NM" ).append("\n"); 
		query.append(", A.EQ_KND_CD" ).append("\n"); 
		query.append(", TO_CHAR(A.EFF_DT,'YYYY-MM-DD') EFF_DT" ).append("\n"); 
		query.append(", A.MNR_MEAS_UT_CD" ).append("\n"); 
		query.append(", A.CURR_CD" ).append("\n"); 
		query.append(", TO_CHAR(A.CRE_DT,'YYYY-MM-DD') CRE_DT" ).append("\n"); 
		query.append(", A.RQST_OFC_CD" ).append("\n"); 
		query.append(", A.CRE_USR_ID" ).append("\n"); 
		query.append(", MNR_COMMON_PKG.MNR_GET_USR_NM_FNC(A.CRE_USR_ID)  CRE_USR_NM" ).append("\n"); 
		query.append(", A.MNR_TRF_STS_CD" ).append("\n"); 
		query.append(", (SELECT C.MNR_CD_DESC FROM MNR_GEN_CD C WHERE C.MNR_CD_ID = A.MNR_TRF_KND_CD AND PRNT_CD_ID = 'CD00011') AS MNR_TRF_KND_NM" ).append("\n"); 
		query.append(", (SELECT C.MNR_CD_DESC FROM MNR_GEN_CD C WHERE C.MNR_CD_ID = A.EQ_KND_CD AND PRNT_CD_ID = 'CD00002') AS EQ_KND_NM" ).append("\n"); 
		query.append(", (SELECT C.MNR_CD_DESC FROM MNR_GEN_CD C WHERE C.MNR_CD_ID = A.MNR_TRF_STS_CD AND PRNT_CD_ID = 'CD00007') AS MNR_TRF_STS_NM" ).append("\n"); 
		query.append(", (SELECT C.MNR_CD_DESC FROM MNR_GEN_CD C WHERE C.MNR_CD_ID = A.MNR_MEAS_UT_CD AND PRNT_CD_ID = 'CD00010') AS MNR_MEAS_UT_NM" ).append("\n"); 
		query.append("FROM MNR_RPR_TRF_HDR A" ).append("\n"); 
		query.append("WHERE " ).append("\n"); 
		query.append("A.TRF_NO = " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("   SELECT TRF_NO" ).append("\n"); 
		query.append("   FROM" ).append("\n"); 
		query.append("   (  " ).append("\n"); 
		query.append("     SELECT MTH.TRF_NO," ).append("\n"); 
		query.append("            MTH.EFF_DT,	" ).append("\n"); 
		query.append("            RANK() OVER(ORDER BY MTH.EFF_DT DESC) AS LVL" ).append("\n"); 
		query.append("       FROM MNR_RPR_TRF_HDR MTH" ).append("\n"); 
		query.append("      WHERE MTH.RQST_OFC_CD IN (" ).append("\n"); 
		query.append("            SELECT DISTINCT A.OFC_CD" ).append("\n"); 
		query.append("              FROM MDM_ORGANIZATION A" ).append("\n"); 
		query.append("             WHERE A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("               AND A.AR_HD_QTR_OFC_CD LIKE '%'|| DECODE(NVL(@[ofc_cd],''), 'SELSC', 'SELIB', 'TYOSC', 'TYOIB', NVL(@[ofc_cd],'')) ||'%'" ).append("\n"); 
		query.append("                OR A.OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("		#if (${mnr_trf_knd_cd} != '')" ).append("\n"); 
		query.append("		AND MTH.MNR_TRF_KND_CD = @[mnr_trf_knd_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${eq_knd_cd} != '')	        " ).append("\n"); 
		query.append("		AND MTH.EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("		#if (${mnr_trf_sts_cd} != '')" ).append("\n"); 
		query.append("		AND MTH.MNR_TRF_STS_CD = @[mnr_trf_sts_cd] 	" ).append("\n"); 
		query.append("		#end 	" ).append("\n"); 
		query.append("		AND MTH.VNDR_SEQ = TO_NUMBER(@[vndr_seq])" ).append("\n"); 
		query.append("   ) " ).append("\n"); 
		query.append("   WHERE LVL = '1'" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}