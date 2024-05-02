/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AgreementHisDBDAOSearchDtlAgmtTotRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.15
*@LastModifier : 
*@LastVersion : 1.0
* 2014.05.15 
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

public class AgreementHisDBDAOSearchDtlAgmtTotRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Pair type Agreement 의 detail을 Inquiry 총계정보 조회
	  * </pre>
	  */
	public AgreementHisDBDAOSearchDtlAgmtTotRSQL(){
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
		query.append("FileName : AgreementHisDBDAOSearchDtlAgmtTotRSQL").append("\n"); 
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
		query.append("SELECT /*+ INDEX_SS(C XAK1TRS_AGMT_NOD) */" ).append("\n"); 
		query.append("    CEIL(COUNT(1)/@[page_size]) AS TOT_CNT" ).append("\n"); 
		query.append("    FROM TRS_AGMT_HDR A " ).append("\n"); 
		query.append("       , TRS_AGMT_RT_TP B " ).append("\n"); 
		query.append("       , TRS_AGMT_NOD C " ).append("\n"); 
		query.append("       , TRS_AGMT_EQ_RT D" ).append("\n"); 
		query.append("       , TRS_AGMT_APLY_VNDR E" ).append("\n"); 
		query.append("    WHERE A.TRSP_AGMT_OFC_CTY_CD = B.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("      AND A.TRSP_AGMT_SEQ = B.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("      AND B.TRSP_AGMT_OFC_CTY_CD = C.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("      AND B.TRSP_AGMT_SEQ = C.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("      AND B.TRSP_AGMT_RT_TP_SER_NO = C.TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("      AND C.TRSP_AGMT_OFC_CTY_CD = D.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("      AND C.TRSP_AGMT_SEQ = D.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("      AND C.TRSP_AGMT_RT_TP_SER_NO = D.TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("      AND C.TRSP_AGMT_NOD_SEQ = D.TRSP_AGMT_NOD_SEQ" ).append("\n"); 
		query.append("      AND B.TRSP_AGMT_RT_TP_CD = 'P'" ).append("\n"); 
		query.append("      AND E.TRSP_AGMT_OFC_CTY_CD = A.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("      AND E.TRSP_AGMT_SEQ = A.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("      AND E.AGMT_VNDR_PRMRY_FLG = 'Y'" ).append("\n"); 
		query.append("#if (${delete_yn} != '')" ).append("\n"); 
		query.append("    AND NVL(D.DELT_FLG, 'N') = @[delete_yn]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${fm_nod} != '' )" ).append("\n"); 
		query.append("    AND C.FM_NOD_CD LIKE @[fm_nod]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${via_nod} != '' )" ).append("\n"); 
		query.append("    AND C.VIA_NOD_CD LIKE @[via_nod]||'%'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("    AND C.VIA_NOD_CD LIKE '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${to_nod} != '' )" ).append("\n"); 
		query.append("    AND C.TO_NOD_CD LIKE @[to_nod]||'%'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("    AND C.TO_NOD_CD LIKE '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${dor_nod} != '' )" ).append("\n"); 
		query.append("    AND C.DOR_NOD_CD LIKE @[dor_nod]||'%'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("    AND C.DOR_NOD_CD LIKE '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${costmode} != '') " ).append("\n"); 
		query.append("    AND B.TRSP_COST_MOD_CD = @[costmode]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cargo} != '') " ).append("\n"); 
		query.append("    AND B.CGO_TP_CD = @[cargo]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    AND D.EQ_KND_CD = @[eqtype]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ($eqtpsz.size() > 0)" ).append("\n"); 
		query.append("    AND D.TRSP_AGMT_EQ_TP_SZ_CD IN (" ).append("\n"); 
		query.append("	#foreach($key in ${eqtpsz}) " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if($velocityCount < $eqtpsz.size()) " ).append("\n"); 
		query.append("			'$key', " ).append("\n"); 
		query.append("		#else " ).append("\n"); 
		query.append("			'$key' " ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${fmAgmtTrspTpCd} != '') " ).append("\n"); 
		query.append("    AND B.AGMT_TRSP_TP_CD = @[fmAgmtTrspTpCd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${fmEffectiveAgmt} != 'A' )" ).append("\n"); 
		query.append("    AND (SELECT GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(A.CTRT_OFC_CD) FROM DUAL) BETWEEN D.EFF_FM_DT AND D.EFF_TO_DT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${fmVndrPrmrySeq} != '') " ).append("\n"); 
		query.append("    AND (A.TRSP_AGMT_OFC_CTY_CD, A.TRSP_AGMT_SEQ) IN (" ).append("\n"); 
		query.append("        SELECT TRSP_AGMT_OFC_CTY_CD, TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("          FROM TRS_AGMT_APLY_VNDR" ).append("\n"); 
		query.append("         WHERE VNDR_SEQ = @[fmVndrPrmrySeq]" ).append("\n"); 
		query.append("          )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if (${trspAgmtOfcCtyCd} != '')" ).append("\n"); 
		query.append("			AND A.TRSP_AGMT_OFC_CTY_CD = @[trspAgmtOfcCtyCd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if (${trspAgmtSeq} != '')" ).append("\n"); 
		query.append("			AND A.TRSP_AGMT_SEQ LIKE @[trspAgmtSeq]||'%'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("#if (${approval_date} != '')" ).append("\n"); 
		query.append(" AND D.AGMT_APRO_DT >= TO_DATE(REPLACE(@[approval_date],'-',''),'YYYYMMDD')" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}