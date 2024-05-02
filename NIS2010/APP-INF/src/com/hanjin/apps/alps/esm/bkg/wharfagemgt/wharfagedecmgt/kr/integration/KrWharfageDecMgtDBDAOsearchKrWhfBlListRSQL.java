/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : KrWharfageDecMgtDBDAOsearchKrWhfBlListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.12
*@LastModifier : 
*@LastVersion : 1.0
* 2013.02.12 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KrWharfageDecMgtDBDAOsearchKrWhfBlListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 한국 WHF 신고 대상 BL 목록 조회
	  * 2011.03.30 김영철 [CHM-201109395] Korea Wharfage 보완 요청 - Cancel Booking 인지 값 조회
	  * </pre>
	  */
	public KrWharfageDecMgtDBDAOsearchKrWhfBlListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mrn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("whf_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("whf_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.integration").append("\n"); 
		query.append("FileName : KrWharfageDecMgtDBDAOsearchKrWhfBlListRSQL").append("\n"); 
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
		query.append("--3. 국내 개항간 B/L  I(I/B) 존재" ).append("\n"); 
		query.append("--   국내 개항간이라고 함은, 부산에서 양하하여 T/S 되어 인천, 광양 평택 등을 가는 화물입니다." ).append("\n"); 
		query.append("--    이는 국내화물로 볼 수 있으나 부산에서 T/S  됨으로  WHF 신고시 T/S로 인식되어 야 합니다." ).append("\n"); 
		query.append("--   상기 모선에 순수 I/B B/L 건수는 114개 인데요, 제가 NIS&ALPS 확인해 보니까 국내 항간" ).append("\n"); 
		query.append("--   B/L이 4건이 추가 되어 있었습니다." ).append("\n"); 
		query.append("--   국내 항간   B/L은 I/F 시 T(T/S)로 분류 될 수 있게 부탁 드립니다." ).append("\n"); 
		query.append("--(EX) HNBN0042W, KRPUS, INBOUND, MEXY8105004" ).append("\n"); 
		query.append("-- ==> BOOKING의 LAST POD와 비교하여 같으면 II (I), 다르면 IT (T)로 구분" ).append("\n"); 
		query.append("SELECT DISTINCT" ).append("\n"); 
		query.append("BBBB.BKG_NO, BBBB.BL_NO," ).append("\n"); 
		query.append("CASE WHEN SUBSTR(@[whf_bnd_cd], 1, 1) = 'I' AND SUBSTR(BBBB.POD_CD, 1, 2) = 'KR' AND BBBB.POD_CD != BBBB.DMST_PORT_CD THEN 'T' ELSE BBBB.CSTMS_DECL_TP_CD END AS CSTMS_DECL_TP_CD," ).append("\n"); 
		query.append("'O' AS DNLD_STS," ).append("\n"); 
		query.append("DECODE(CCCC.BKG_STS_CD,'X','Cancel Booking','') AS RESULTS" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT BBB.BKG_NO, BBB.CSTMS_DECL_TP_CD, BBB.VSL_CD, BBB.SKD_VOY_NO,BBB.SKD_DIR_CD, MAX(TRNS_SEQ) AS TRNS_SEQ" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT DISTINCT AA.VSL_CD, AA.SKD_VOY_NO, AA.SKD_DIR_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT A.MRN_NO, A.MRN_CHK_NO, A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.IO_BND_CD, A.PORT_CD, A.OB_DECL_TP_CD, MAX(VVD_SEQ) AS VVD_SEQ" ).append("\n"); 
		query.append("FROM BKG_CSTMS_KR_VVD_SMRY A" ).append("\n"); 
		query.append("WHERE A.MRN_NO = SUBSTR(@[mrn_no], 1, 10)" ).append("\n"); 
		query.append("AND A.MRN_CHK_NO = SUBSTR(@[mrn_no], 11, 1)" ).append("\n"); 
		query.append("AND A.IO_BND_CD = SUBSTR(@[whf_bnd_cd], 1, 1)" ).append("\n"); 
		query.append("AND A.PORT_CD = @[whf_pol_cd]" ).append("\n"); 
		query.append("GROUP BY A.MRN_NO, A.MRN_CHK_NO, A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.IO_BND_CD, A.PORT_CD, A.OB_DECL_TP_CD) AA," ).append("\n"); 
		query.append("BKG_CSTMS_KR_VVD_SMRY BB" ).append("\n"); 
		query.append("WHERE BB.MRN_NO = AA.MRN_NO" ).append("\n"); 
		query.append("AND BB.MRN_CHK_NO = AA.MRN_CHK_NO" ).append("\n"); 
		query.append("AND BB.VSL_CD = AA.VSL_CD" ).append("\n"); 
		query.append("AND BB.SKD_VOY_NO = AA.SKD_VOY_NO" ).append("\n"); 
		query.append("AND BB.SKD_DIR_CD = AA.SKD_dIR_CD" ).append("\n"); 
		query.append("AND BB.OB_DECL_TP_CD = AA.OB_DECL_TP_CD" ).append("\n"); 
		query.append("AND BB.VVD_SEQ = AA.VVD_SEQ) AAA," ).append("\n"); 
		query.append("BKG_CSTMS_KR_BL BBB, MDM_LOCATION CCC" ).append("\n"); 
		query.append("WHERE BBB.VSL_CD = AAA.VSL_CD" ).append("\n"); 
		query.append("AND BBB.SKD_VOY_NO = AAA.SKD_VOY_NO" ).append("\n"); 
		query.append("AND BBB.SKD_DIR_CD = AAA.SKD_DIR_CD" ).append("\n"); 
		query.append("AND BBB.CSTMS_DECL_TP_CD IN (DECODE(@[whf_bnd_cd], 'OO', 'E', 'I'), DECODE(@[whf_bnd_cd], 'OO', 'R', 'T'))" ).append("\n"); 
		query.append("AND DECODE(@[whf_bnd_cd], 'II', BBB.TS_POD_CD, BBB.TS_POL_CD) = @[whf_pol_cd]" ).append("\n"); 
		query.append("AND NVL(BBB.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("AND CCC.LOC_CD = DECODE(@[whf_bnd_cd], 'II', BBB.TS_POD_CD, BBB.TS_POL_CD)" ).append("\n"); 
		query.append("GROUP BY BBB.BKG_NO, BBB.CSTMS_DECL_TP_CD,BBB.VSL_CD, BBB.SKD_VOY_NO,BBB.SKD_DIR_CD) AAAA," ).append("\n"); 
		query.append("BKG_CSTMS_KR_BL BBBB," ).append("\n"); 
		query.append("BKG_BOOKING CCCC" ).append("\n"); 
		query.append("WHERE BBBB.BKG_NO = AAAA.BKG_NO" ).append("\n"); 
		query.append("AND BBBB.TRNS_SEQ = AAAA.TRNS_SEQ" ).append("\n"); 
		query.append("AND BBBB.VSL_CD = AAAA.VSL_CD" ).append("\n"); 
		query.append("AND BBBB.SKD_VOY_NO = AAAA.SKD_VOY_NO" ).append("\n"); 
		query.append("AND BBBB.SKD_DIR_CD = AAAA.SKD_DIR_CD" ).append("\n"); 
		query.append("AND BBBB.CSTMS_DECL_TP_CD = AAAA.CSTMS_DECL_TP_CD" ).append("\n"); 
		query.append("AND BBBB.TRNS_SEQ = AAAA.TRNS_SEQ" ).append("\n"); 
		query.append("AND CCCC.BKG_NO(+) = BBBB.BKG_NO" ).append("\n"); 
		query.append("ORDER BY BKG_NO" ).append("\n"); 

	}
}