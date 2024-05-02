/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : AgreementHisDBDAOSearchDtlAgmtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.07.04
*@LastModifier : 
*@LastVersion : 1.0
* 2017.07.04 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AgreementHisDBDAOSearchDtlAgmtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Pair type Agreement 의 detail을 Inquiry
	  * </pre>
	  */
	public AgreementHisDBDAOSearchDtlAgmtRSQL(){
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
		params.put("delete_yn",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("costmode",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_nod",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("via_nod",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trspAgmtOfcCtyCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cur_page_cnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_nod",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eqtype",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cargo",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fmVndrPrmrySeq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fmAgmtTrspTpCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trspAgmtSeq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("approval_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dor_nod",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.integration").append("\n"); 
		query.append("FileName : AgreementHisDBDAOSearchDtlAgmtRSQL").append("\n"); 
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
		query.append("SELECT *" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("    SELECT ROWNUM NUM, X.*" ).append("\n"); 
		query.append("      FROM (" ).append("\n"); 
		query.append("        SELECT   /*+ INDEX(C XAK1TRS_AGMT_NOD) */" ).append("\n"); 
		query.append("                 E.VNDR_SEQ" ).append("\n"); 
		query.append("               ,(SELECT MDM.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("                  FROM MDM_VENDOR MDM" ).append("\n"); 
		query.append("                 WHERE MDM.VNDR_SEQ = E.VNDR_SEQ) VNDR_NM" ).append("\n"); 
		query.append("               ,A.TRSP_AGMT_OFC_CTY_CD " ).append("\n"); 
		query.append("               ,A.TRSP_AGMT_SEQ " ).append("\n"); 
		query.append("               ,A.TRSP_AGMT_OFC_CTY_CD||A.TRSP_AGMT_SEQ AGMT_NO" ).append("\n"); 
		query.append("               ,B.TRSP_COST_MOD_CD " ).append("\n"); 
		query.append("               ,B.CGO_TP_CD " ).append("\n"); 
		query.append("               ,DECODE(B.CUST_NOMI_TRKR_IND_CD, 'HJS', 'SML', B.CUST_NOMI_TRKR_IND_CD) AS CUST_NOMI_TRKR_IND_CD" ).append("\n"); 
		query.append("               ,DECODE(B.CUST_CNT_CD , 'XX', NULL, B.CUST_CNT_CD ) CUST_CNT_CD " ).append("\n"); 
		query.append("               ,DECODE(B.CUST_SEQ , '0', NULL, B.CUST_SEQ ) CUST_SEQ" ).append("\n"); 
		query.append("               ,DECODE(B.CUST_CNT_CD||B.CUST_SEQ, 'XX0', NULL, B.CUST_CNT_CD||B.CUST_SEQ) AS CUSTOMER_CD" ).append("\n"); 
		query.append("               ,DECODE(B.CMDT_GRP_CD, 'XXXX', NULL, B.CMDT_GRP_CD) CMDT_GRP_CD " ).append("\n"); 
		query.append("               ,DECODE(B.RAIL_SVC_TP_CD, '00', NULL, B.RAIL_SVC_TP_CD) RAIL_SVC_TP_CD " ).append("\n"); 
		query.append("               ,DECODE(C.FM_NOD_CD, '0000000', NULL, C.FM_NOD_CD) FM_NOD_CD " ).append("\n"); 
		query.append("               ,DECODE(C.VIA_NOD_CD, '0000000', NULL, C.VIA_NOD_CD) VIA_NOD_CD " ).append("\n"); 
		query.append("               ,DECODE(C.DOR_NOD_CD, '0000000', NULL, C.DOR_NOD_CD) DOR_NOD_CD " ).append("\n"); 
		query.append("               ,DECODE(C.TO_NOD_CD, '0000000', NULL, C.TO_NOD_CD) TO_NOD_CD" ).append("\n"); 
		query.append("               ,NVL(NVL(FM_Y.YD_NM, FM_S.LSE_CO_YD_NM), FM_L.LOC_NM) FM_NOD_CD_NM" ).append("\n"); 
		query.append("               ,NVL(NVL(VA_Y.YD_NM, VA_S.LSE_CO_YD_NM), VA_L.LOC_NM) VIA_NOD_CD_NM" ).append("\n"); 
		query.append("               ,NVL(DR_Z.ZN_NM, DR_L.LOC_NM) DOR_NOD_CD_NM" ).append("\n"); 
		query.append("               ,NVL(NVL(TO_Y.YD_NM, TO_S.LSE_CO_YD_NM), TO_L.LOC_NM) TO_NOD_CD_NM" ).append("\n"); 
		query.append("               ,D.TRSP_AGMT_EQ_TP_SZ_CD " ).append("\n"); 
		query.append("               ,DECODE(D.WTR_RCV_TERM_CD, '0', NULL, D.WTR_RCV_TERM_CD) WTR_RCV_TERM_CD --FEEDER TERM (R)" ).append("\n"); 
		query.append("               ,DECODE(D.WTR_DE_TERM_CD, '0', NULL, D.WTR_DE_TERM_CD) WTR_DE_TERM_CD --FEEDER TERM (D)" ).append("\n"); 
		query.append("               ,DECODE(D.TRSP_AGMT_BDL_QTY, '0', NULL, D.TRSP_AGMT_BDL_QTY) TRSP_AGMT_BDL_QTY --CHASSIS" ).append("\n"); 
		query.append("               ,DECODE(D.TO_WGT, '0', NULL, '999999.99', 'MAX', D.TO_WGT) TO_WGT --WEIGHT TIER" ).append("\n"); 
		query.append("               ,DECODE(D.WGT_MEAS_UT_CD, 'XXX', NULL, D.WGT_MEAS_UT_CD) WGT_MEAS_UT_CD --UOM" ).append("\n"); 
		query.append("               ,D.CURR_CD" ).append("\n"); 
		query.append("               ,B.AGMT_TRSP_TP_CD --TRANS MODE TYPE" ).append("\n"); 
		query.append("               ,D.TRSP_ONE_WY_RT" ).append("\n"); 
		query.append("               ,D.TRSP_RND_RT" ).append("\n"); 
		query.append("               ,A.CTRT_OFC_CD" ).append("\n"); 
		query.append("               ,D.TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("               ,TO_CHAR(D.EFF_FM_DT,'YYYYMMDD') EFF_FM_DT" ).append("\n"); 
		query.append("               ,TO_CHAR(D.EFF_TO_DT,'YYYYMMDD') EFF_TO_DT" ).append("\n"); 
		query.append("               ,D.TRSP_RVS_APLY_FLG" ).append("\n"); 
		query.append("               ,NVL(D.DELT_FLG, 'N') DELT_FLG" ).append("\n"); 
		query.append("               ,TO_CHAR(D.AGMT_APRO_DT,'YYYYMMDD') AGMT_APRO_DT" ).append("\n"); 
		query.append("               ,TO_CHAR(D.UPD_DT,'YYYYMMDD') UPD_DT" ).append("\n"); 
		query.append("               ,TO_CHAR(TO_DATE(TO_CHAR(D.AGMT_APRO_DT,'YYYYMMDD'),'YYYYMMDD') - TO_DATE(TO_CHAR(D.UPD_DT,'YYYYMMDD'),'YYYYMMDD')) DT_GAP" ).append("\n"); 
		query.append("               ,NVL((SELECT MAX(X.USR_NM) FROM COM_USER X WHERE X.USR_ID = D.UPD_USR_ID),D.UPD_USR_ID) UPD_USR_NM" ).append("\n"); 
		query.append("               ,B.CFM_FLG" ).append("\n"); 
		query.append("               ,NVL((SELECT MAX(X.USR_NM) FROM COM_USER X WHERE X.USR_ID = B.CFM_USR_ID),B.CFM_USR_ID) CFM_USR_NM" ).append("\n"); 
		query.append("           FROM TRS_AGMT_HDR A " ).append("\n"); 
		query.append("               ,TRS_AGMT_RT_TP B " ).append("\n"); 
		query.append("               ,TRS_AGMT_NOD C " ).append("\n"); 
		query.append("               ,TRS_AGMT_EQ_RT D" ).append("\n"); 
		query.append("               ,TRS_AGMT_APLY_VNDR E" ).append("\n"); 
		query.append("               ,MDM_YARD      FM_Y" ).append("\n"); 
		query.append("               ,MDM_LSE_CO_YD FM_S" ).append("\n"); 
		query.append("               ,MDM_LOCATION  FM_L" ).append("\n"); 
		query.append("               ,MDM_YARD      VA_Y" ).append("\n"); 
		query.append("               ,MDM_LSE_CO_YD VA_S" ).append("\n"); 
		query.append("               ,MDM_LOCATION  VA_L" ).append("\n"); 
		query.append("               ,MDM_ZONE      DR_Z" ).append("\n"); 
		query.append("               ,MDM_LOCATION  DR_L" ).append("\n"); 
		query.append("               ,MDM_YARD      TO_Y" ).append("\n"); 
		query.append("               ,MDM_LSE_CO_YD TO_S" ).append("\n"); 
		query.append("               ,MDM_LOCATION  TO_L" ).append("\n"); 
		query.append("          WHERE A.TRSP_AGMT_OFC_CTY_CD = B.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("            AND A.TRSP_AGMT_SEQ = B.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("            AND B.TRSP_AGMT_OFC_CTY_CD = C.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("            AND B.TRSP_AGMT_SEQ = C.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("            AND B.TRSP_AGMT_RT_TP_SER_NO = C.TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("            AND C.TRSP_AGMT_OFC_CTY_CD = D.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("            AND C.TRSP_AGMT_SEQ = D.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("            AND C.TRSP_AGMT_RT_TP_SER_NO = D.TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("            AND C.TRSP_AGMT_NOD_SEQ = D.TRSP_AGMT_NOD_SEQ" ).append("\n"); 
		query.append("            AND B.TRSP_AGMT_RT_TP_CD = 'P'" ).append("\n"); 
		query.append("            AND E.TRSP_AGMT_OFC_CTY_CD = A.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("            AND E.TRSP_AGMT_SEQ = A.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("            AND E.AGMT_VNDR_PRMRY_FLG = 'Y'" ).append("\n"); 
		query.append("            AND C.FM_NOD_CD = FM_Y.YD_CD(+)" ).append("\n"); 
		query.append("            AND C.FM_NOD_CD = FM_S.LSE_CO_YD_CD(+)" ).append("\n"); 
		query.append("            AND SUBSTR(C.FM_NOD_CD,1,5) = FM_L.LOC_CD(+)" ).append("\n"); 
		query.append("            AND C.VIA_NOD_CD = VA_Y.YD_CD(+)" ).append("\n"); 
		query.append("            AND C.VIA_NOD_CD = VA_S.LSE_CO_YD_CD(+)" ).append("\n"); 
		query.append("            AND SUBSTR(C.VIA_NOD_CD,1,5) = VA_L.LOC_CD(+)" ).append("\n"); 
		query.append("            AND C.DOR_NOD_CD = DR_Z.ZN_CD(+)" ).append("\n"); 
		query.append("            AND SUBSTR(C.DOR_NOD_CD,1,5) = DR_L.LOC_CD(+)" ).append("\n"); 
		query.append("            AND C.TO_NOD_CD = TO_Y.YD_CD(+)" ).append("\n"); 
		query.append("            AND C.TO_NOD_CD = TO_S.LSE_CO_YD_CD(+)" ).append("\n"); 
		query.append("            AND SUBSTR(C.TO_NOD_CD,1,5) = TO_L.LOC_CD(+)" ).append("\n"); 
		query.append("        #if (${delete_yn} != '')" ).append("\n"); 
		query.append("            AND NVL(D.DELT_FLG, 'N') = @[delete_yn]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${fm_nod} != '' )" ).append("\n"); 
		query.append("            AND C.FM_NOD_CD LIKE @[fm_nod]||'%'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${via_nod} != '' )" ).append("\n"); 
		query.append("            AND C.VIA_NOD_CD LIKE @[via_nod]||'%'" ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("            AND C.VIA_NOD_CD LIKE '%'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${to_nod} != '' )" ).append("\n"); 
		query.append("            AND C.TO_NOD_CD LIKE @[to_nod]||'%'" ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("            AND C.TO_NOD_CD LIKE '%'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${dor_nod} != '' )" ).append("\n"); 
		query.append("            AND C.DOR_NOD_CD LIKE @[dor_nod]||'%'" ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("            AND C.DOR_NOD_CD LIKE '%'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        #if (${costmode} != '') " ).append("\n"); 
		query.append("              AND B.TRSP_COST_MOD_CD = @[costmode]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        #if (${cargo} != '') " ).append("\n"); 
		query.append("              AND B.CGO_TP_CD = @[cargo]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("              AND D.EQ_KND_CD = @[eqtype]" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        #if ($eqtpsz.size() > 0)" ).append("\n"); 
		query.append("              AND D.TRSP_AGMT_EQ_TP_SZ_CD IN (" ).append("\n"); 
		query.append("        	#foreach($key in ${eqtpsz}) " ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        		#if($velocityCount < $eqtpsz.size()) " ).append("\n"); 
		query.append("        			'$key', " ).append("\n"); 
		query.append("        		#else " ).append("\n"); 
		query.append("        			'$key' " ).append("\n"); 
		query.append("        		#end " ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        	#end" ).append("\n"); 
		query.append("        	)" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        #if (${fmAgmtTrspTpCd} != '') " ).append("\n"); 
		query.append("              AND B.AGMT_TRSP_TP_CD = @[fmAgmtTrspTpCd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        #if (${fmEffectiveAgmt} != 'A' )" ).append("\n"); 
		query.append("              AND (SELECT GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(A.CTRT_OFC_CD) FROM DUAL) BETWEEN D.EFF_FM_DT AND D.EFF_TO_DT" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        #if (${fmVndrPrmrySeq} != '') " ).append("\n"); 
		query.append("              AND (A.TRSP_AGMT_OFC_CTY_CD, A.TRSP_AGMT_SEQ) IN (" ).append("\n"); 
		query.append("                  SELECT TRSP_AGMT_OFC_CTY_CD, TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("                    FROM TRS_AGMT_APLY_VNDR" ).append("\n"); 
		query.append("                   WHERE VNDR_SEQ = @[fmVndrPrmrySeq]" ).append("\n"); 
		query.append("                  )" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if (${trspAgmtOfcCtyCd} != '')" ).append("\n"); 
		query.append("			AND A.TRSP_AGMT_OFC_CTY_CD = @[trspAgmtOfcCtyCd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if (${trspAgmtSeq} != '')" ).append("\n"); 
		query.append("			AND A.TRSP_AGMT_SEQ LIKE @[trspAgmtSeq]||'%'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("        #if (${approval_date} != '')" ).append("\n"); 
		query.append("             AND D.AGMT_APRO_DT >= TO_DATE(REPLACE(@[approval_date],'-',''),'YYYYMMDD')" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    ) X" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE NUM BETWEEN 1 + ((@[cur_page_cnt]-1)*@[page_size]) AND (@[cur_page_cnt]*@[page_size])" ).append("\n"); 

	}
}