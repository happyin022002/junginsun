/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : UsaCustomsReportDBDAOsearchTransmissionCheckListByVVDRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.30
*@LastModifier : 
*@LastVersion : 1.0
* 2013.08.30 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaCustomsReportDBDAOsearchTransmissionCheckListByVVDRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dwkim, 0359 Manifest Status 조회용
	  * </pre>
	  */
	public UsaCustomsReportDBDAOsearchTransmissionCheckListByVVDRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("min_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("blmi",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bofc",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.usa.integration").append("\n"); 
		query.append("FileName : UsaCustomsReportDBDAOsearchTransmissionCheckListByVVDRSQL").append("\n"); 
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
		query.append("SELECT DENSE_RANK() OVER(ORDER BY MBL_NO, ams_file_no) seq," ).append("\n"); 
		query.append("	gubun, ams_file_no, m_f, " ).append("\n"); 
		query.append("	filer, mbl_no, o_pol, " ).append("\n"); 
		query.append("	t_pol, t_pod, t_vvd, " ).append("\n"); 
		query.append("	sts, v_mi, mi, " ).append("\n"); 
		query.append("	vvd, sent_time, curr_stage, " ).append("\n"); 
		query.append("	update_dt, b_ofc, cntr_no, " ).append("\n"); 
		query.append("	mf_sts, user_action, t_vvd2, " ).append("\n"); 
		query.append("	t_pol2, filer2, " ).append("\n"); 
		query.append("	' ' tmp1, ' ' tmp2, ' ' tmp3" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("	SELECT '00' gubun," ).append("\n"); 
		query.append("		B.BL_NO ams_file_no, 'M' m_f," ).append("\n"); 
		query.append("		B.USA_CSTMS_FILE_CD filer," ).append("\n"); 
		query.append("		B.BL_NO mbl_no," ).append("\n"); 
		query.append("		F.POL_CD o_pol," ).append("\n"); 
		query.append("		A2.POL_CD t_pol," ).append("\n"); 
		query.append("		A2.POD_CD t_pod," ).append("\n"); 
		query.append("		B.VSL_CD || B.SKD_VOY_NO || B.SKD_DIR_CD t_vvd, " ).append("\n"); 
		query.append("		B.BKG_STS_CD sts," ).append("\n"); 
		query.append("		DECODE(E.SND_DT, null, 'N', 'Y') v_mi, " ).append("\n"); 
		query.append("		DECODE(F.MF_SND_DT, null, 'N', 'Y') mi," ).append("\n"); 
		query.append("		F.VSL_CD || F.SKD_VOY_NO || F.SKD_DIR_CD vvd,               " ).append("\n"); 
		query.append("		TO_CHAR(F.MF_SND_DT, 'YYYY-MM-DD HH24:MI') sent_time," ).append("\n"); 
		query.append("		F.CSTMS_MF_TP_CD curr_stage," ).append("\n"); 
		query.append("		DECODE(F.CSTMS_MF_TP_CD, 'MI', TO_CHAR(F.MF_SND_DT, 'YYYY-MM-DD HH24:MI'), 'AI', TO_CHAR(F.AMDT_SND_DT, 'YYYY-MM-DD HH24:MI')) update_dt," ).append("\n"); 
		query.append("		B.BKG_OFC_CD b_ofc," ).append("\n"); 
		query.append("		D.CNTR_NO cntr_no," ).append("\n"); 
		query.append("		CASE WHEN F.MF_SND_DT is NOT null AND F.AMDT_SND_DT is null THEN" ).append("\n"); 
		query.append("			'Sent By MI'" ).append("\n"); 
		query.append("		WHEN F.MF_SND_DT is NOT null AND F.AMDT_SND_DT is NOT null THEN" ).append("\n"); 
		query.append("			'Sent By MI'" ).append("\n"); 
		query.append("		WHEN F.MF_SND_DT is null AND F.AMDT_SND_DT is NOT null THEN" ).append("\n"); 
		query.append("			'Added By AI'" ).append("\n"); 
		query.append("		WHEN F.MF_SND_DT is null AND F.AMDT_SND_DT is null THEN" ).append("\n"); 
		query.append("			'Un-Manifested'" ).append("\n"); 
		query.append("		ELSE" ).append("\n"); 
		query.append("			'Error'" ).append("\n"); 
		query.append("		END mf_sts," ).append("\n"); 
		query.append("		CASE WHEN F.VSL_CD is null THEN " ).append("\n"); 
		query.append("			'ADD'" ).append("\n"); 
		query.append("		WHEN F.VSL_CD || F.SKD_VOY_NO || F.SKD_DIR_CD || F.CSTMS_POL_CD || F.CSTMS_POD_CD" ).append("\n"); 
		query.append("			<> B.VSL_CD || B.SKD_VOY_NO || B.SKD_DIR_CD || B.POL_CD || B.POD_CD THEN" ).append("\n"); 
		query.append("			--'Roll Over'" ).append("\n"); 
		query.append("			'None'" ).append("\n"); 
		query.append("		ELSE" ).append("\n"); 
		query.append("			'None'" ).append("\n"); 
		query.append("		END user_action," ).append("\n"); 
		query.append("		'' t_vvd2, '' t_pol2, '' filer2" ).append("\n"); 
		query.append("        ,A2.VSL_CD" ).append("\n"); 
		query.append("        ,A2.SKD_VOY_NO" ).append("\n"); 
		query.append("        ,A2.SKD_DIR_CD" ).append("\n"); 
		query.append("	FROM BKG_VVD A, BKG_VVD A2, BKG_BOOKING B, BKG_BL_DOC C, BKG_CONTAINER D, BKG_CSTMS_ADV_SND_LOG E, BKG_CSTMS_ADV_BL F, MDM_LOCATION L2" ).append("\n"); 
		query.append("	WHERE A.VSL_CD					= SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("		AND A.SKD_VOY_NO			= SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("		AND A.SKD_DIR_CD			= SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("	#if (${pol} != '') " ).append("\n"); 
		query.append("		AND A.POL_CD				= @[pol]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("		AND A.BKG_NO				= A2.BKG_NO" ).append("\n"); 
		query.append("		AND A2.VSL_PRE_PST_CD		= 'T'" ).append("\n"); 
		query.append("	#if (${pod} != '') " ).append("\n"); 
		query.append("		AND A2.POD_CD				= @[pod]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("		--조회대상 query 수정 : 현재는 ASIA 향 B/L 까지 조회가 됩니다." ).append("\n"); 
		query.append("		-- a. POD가 US 이거나" ).append("\n"); 
		query.append("		-- b. US T/S 이거나" ).append("\n"); 
		query.append("		-- c. US FROB" ).append("\n"); 
		query.append("		-- 10/09 하수석, 아래내용을 MDM_LOCATION.CONTI_CD = 'M'인 조건으로 수정함.(멕시코가 조회안되는 사유)" ).append("\n"); 
		query.append("		--AND (A.POD_CD like 'US%' or A.POD_CD like 'CA%' or A2.POD_CD like 'US%' or A2.POD_CD like 'CA%')" ).append("\n"); 
		query.append("		AND A2.POD_CD = L2.LOC_CD AND L2.CONTI_CD = 'M'" ).append("\n"); 
		query.append("	#if (${trunkfirst} == 'S') " ).append("\n"); 
		query.append("		AND A.POL_CD				= B.POL_CD" ).append("\n"); 
		query.append("	#else " ).append("\n"); 
		query.append("		AND A.VSL_PRE_PST_CD		= 'T'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("		AND B.BKG_NO				= A.BKG_NO" ).append("\n"); 
		query.append("		AND B.BKG_CGO_TP_CD 		IN ('R', 'F')" ).append("\n"); 
		query.append("		AND B.BKG_STS_CD			<> 'X'" ).append("\n"); 
		query.append("		--AND (B.BKG_STS_CD = 'X'  AND  ( F.MF_STS_CD <> 'D'  OR  F.AMDT_SND_DT IS NULL ))" ).append("\n"); 
		query.append("	#if (${bofc} != '')" ).append("\n"); 
		query.append("		AND B.BKG_OFC_CD			= @[bofc]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("		AND C.BKG_NO				= B.BKG_NO" ).append("\n"); 
		query.append("		AND D.BKG_NO(+)				= C.BKG_NO" ).append("\n"); 
		query.append("		AND F.CNT_CD(+)				= 'US'" ).append("\n"); 
		query.append("		AND F.BL_NO(+)				= B.BL_NO" ).append("\n"); 
		query.append("		AND E.CNT_CD(+)				= 'US'" ).append("\n"); 
		query.append("		AND E.VSL_CD(+)				= A.VSL_CD" ).append("\n"); 
		query.append("		AND E.SKD_VOY_NO(+)			= A.SKD_VOY_NO" ).append("\n"); 
		query.append("		AND E.SKD_DIR_CD(+)			= A.SKD_DIR_CD" ).append("\n"); 
		query.append("		AND E.POL_CD(+)				= A.POL_CD" ).append("\n"); 
		query.append("		AND E.POD_CD(+)				= A.POD_CD" ).append("\n"); 
		query.append("		AND E.TRSM_MSG_TP_ID(+)		= 'MI'" ).append("\n"); 
		query.append("		AND E.IO_BND_CD(+)			= 'I'" ).append("\n"); 
		query.append("		AND E.DELT_FLG(+)			= 'N'" ).append("\n"); 
		query.append("	UNION ALL" ).append("\n"); 
		query.append("	SELECT TO_CHAR(G.HBL_SEQ)," ).append("\n"); 
		query.append("		G.CNTR_MF_NO ams_file_no, 'H'," ).append("\n"); 
		query.append("		--B.USA_CSTMS_FILE_CD filer," ).append("\n"); 
		query.append("		--2009/10/07 H.B/L Filer 는 null 이어야 함 BY jung" ).append("\n"); 
		query.append("		'0' filer," ).append("\n"); 
		query.append("		B.BL_NO mbl_no," ).append("\n"); 
		query.append("		B.POL_CD o_pol," ).append("\n"); 
		query.append("		A2.POL_CD t_pol," ).append("\n"); 
		query.append("		A2.POD_CD t_pod," ).append("\n"); 
		query.append("		B.VSL_CD || B.SKD_VOY_NO || B.SKD_DIR_CD t_vvd, " ).append("\n"); 
		query.append("		B.BKG_STS_CD sts," ).append("\n"); 
		query.append("		DECODE(E.SND_DT, null, 'N', 'Y') v_mi, " ).append("\n"); 
		query.append("		DECODE(F.MF_SND_DT, null, 'N', 'Y') mi," ).append("\n"); 
		query.append("		F.VSL_CD || F.SKD_VOY_NO || F.SKD_DIR_CD vvd,               " ).append("\n"); 
		query.append("		TO_CHAR(F.MF_SND_DT, 'YYYY-MM-DD HH24:MI') sent_time," ).append("\n"); 
		query.append("		F.CSTMS_MF_TP_CD curr_stage," ).append("\n"); 
		query.append("		DECODE(F.CSTMS_MF_TP_CD, 'MI', TO_CHAR(F.MF_SND_DT, 'YYYY-MM-DD HH24:MI'), 'AI', TO_CHAR(F.AMDT_SND_DT, 'YYYY-MM-DD HH24:MI')) update_dt," ).append("\n"); 
		query.append("		B.BKG_OFC_CD b_ofc," ).append("\n"); 
		query.append("		D.CNTR_NO cntr_no," ).append("\n"); 
		query.append("		CASE WHEN F.MF_SND_DT is NOT null AND F.AMDT_SND_DT is null THEN" ).append("\n"); 
		query.append("			'Sent By MI'" ).append("\n"); 
		query.append("		WHEN F.MF_SND_DT is NOT null AND F.AMDT_SND_DT is NOT null THEN" ).append("\n"); 
		query.append("			'Sent By MI'" ).append("\n"); 
		query.append("		WHEN F.MF_SND_DT is null AND F.AMDT_SND_DT is NOT null THEN" ).append("\n"); 
		query.append("			'Added By AI'" ).append("\n"); 
		query.append("		WHEN F.MF_SND_DT is null AND F.AMDT_SND_DT is null THEN" ).append("\n"); 
		query.append("			'Un-Manifested'" ).append("\n"); 
		query.append("		ELSE" ).append("\n"); 
		query.append("			'Error'" ).append("\n"); 
		query.append("		END mf_sts," ).append("\n"); 
		query.append("		CASE WHEN F.VSL_CD is null THEN " ).append("\n"); 
		query.append("			'ADD'" ).append("\n"); 
		query.append("		WHEN F.VSL_CD || F.SKD_VOY_NO || F.SKD_DIR_CD || F.CSTMS_POL_CD || F.CSTMS_POD_CD" ).append("\n"); 
		query.append("			<> A.VSL_CD || A.SKD_VOY_NO || A.SKD_DIR_CD || A.POL_CD || A.POD_CD THEN" ).append("\n"); 
		query.append("			'Roll Over'" ).append("\n"); 
		query.append("		ELSE" ).append("\n"); 
		query.append("			'None'" ).append("\n"); 
		query.append("		END user_action," ).append("\n"); 
		query.append("		'' t_vvd2, '' t_pol2, '' filer2" ).append("\n"); 
		query.append("        ,A2.VSL_CD" ).append("\n"); 
		query.append("        ,A2.SKD_VOY_NO" ).append("\n"); 
		query.append("        ,A2.SKD_DIR_CD" ).append("\n"); 
		query.append("	FROM BKG_VVD A, BKG_VVD A2, BKG_BOOKING B, BKG_BL_DOC C, BKG_HBL G, BKG_CNTR_MF_DESC D, BKG_CSTMS_ADV_SND_LOG E, BKG_CSTMS_ADV_BL F, MDM_LOCATION L2" ).append("\n"); 
		query.append("	WHERE A.VSL_CD					= SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("		AND A.SKD_VOY_NO			= SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("		AND A.SKD_DIR_CD			= SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("	#if (${pol} != '') " ).append("\n"); 
		query.append("		AND A.POL_CD				= @[pol]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("		AND A.BKG_NO				= A2.BKG_NO" ).append("\n"); 
		query.append("		AND A2.VSL_PRE_PST_CD		= 'T'" ).append("\n"); 
		query.append("	#if (${pod} != '') " ).append("\n"); 
		query.append("		AND A2.POD_CD				= @[pod]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("		--조회대상 query 수정 : 현재는 ASIA 향 B/L 까지 조회가 됩니다." ).append("\n"); 
		query.append("		-- a. POD가 US 이거나" ).append("\n"); 
		query.append("		-- b. US T/S 이거나" ).append("\n"); 
		query.append("		-- c. US FROB" ).append("\n"); 
		query.append("		-- 10/09 하수석, 아래내용을 MDM_LOCATION.CONTI_CD = 'M'인 조건으로 수정함.(멕시코가 조회안되는 사유)" ).append("\n"); 
		query.append("		--AND (A.POD_CD like 'US%' or A.POD_CD like 'CA%' or A2.POD_CD like 'US%' or A2.POD_CD like 'CA%')" ).append("\n"); 
		query.append("		AND A2.POD_CD = L2.LOC_CD AND L2.CONTI_CD = 'M'" ).append("\n"); 
		query.append("	#if (${trunkfirst} == 'S') " ).append("\n"); 
		query.append("		AND A.POL_CD				= B.POL_CD" ).append("\n"); 
		query.append("	#else " ).append("\n"); 
		query.append("		AND A.VSL_PRE_PST_CD		= 'T'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("		AND B.BKG_NO				= A.BKG_NO" ).append("\n"); 
		query.append("		AND B.BKG_CGO_TP_CD			IN ('R', 'F')" ).append("\n"); 
		query.append("		AND B.BKG_STS_CD			<> 'X'" ).append("\n"); 
		query.append("		--AND (B.BKG_STS_CD = 'X'  AND  ( F.MF_STS_CD <> 'D'  OR  F.AMDT_SND_DT IS NULL ))" ).append("\n"); 
		query.append("	#if (${bofc} != '')" ).append("\n"); 
		query.append("		AND B.BKG_OFC_CD			= @[bofc]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("		AND C.BKG_NO				= B.BKG_NO" ).append("\n"); 
		query.append("		--as-IS에서는 아래 조건이 사용되나, TO-BE에서 다운로드 화면과 조회수량이 차이가 나므로 아래 조건을 블록한다. " ).append("\n"); 
		query.append("	    -- 20100531 블록을 다시 활성화" ).append("\n"); 
		query.append("		AND B.USA_CSTMS_FILE_CD 	= '1'" ).append("\n"); 
		query.append("		AND G.BKG_NO				= C.BKG_NO" ).append("\n"); 
		query.append("		AND F.CNT_CD(+)				= 'US'" ).append("\n"); 
		query.append("		AND F.BL_NO(+)				= G.CNTR_MF_NO" ).append("\n"); 
		query.append("		AND F.BKG_NO(+)				= G.BKG_NO" ).append("\n"); 
		query.append("		AND E.CNT_CD(+)				= 'US'" ).append("\n"); 
		query.append("		AND E.VSL_CD(+)				= A.VSL_CD" ).append("\n"); 
		query.append("		AND E.SKD_VOY_NO(+)			= A.SKD_VOY_NO" ).append("\n"); 
		query.append("		AND E.SKD_DIR_CD(+)			= A.SKD_DIR_CD" ).append("\n"); 
		query.append("		AND E.POL_CD(+)				= A.POL_CD" ).append("\n"); 
		query.append("		AND E.POD_CD(+)				= A.POD_CD" ).append("\n"); 
		query.append("		AND E.TRSM_MSG_TP_ID(+)		= 'MI'" ).append("\n"); 
		query.append("		AND E.IO_BND_CD(+)			= 'I'" ).append("\n"); 
		query.append("		AND E.DELT_FLG(+)			= 'N'" ).append("\n"); 
		query.append("		AND D.BKG_NO(+)				= G.BKG_NO" ).append("\n"); 
		query.append("		AND D.CNTR_MF_NO(+)			= G.CNTR_MF_NO" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append(", VSK_VSL_PORT_SKD SKD" ).append("\n"); 
		query.append("WHERE  1 = 1" ).append("\n"); 
		query.append("  AND  A.VSL_CD = SKD.VSL_CD" ).append("\n"); 
		query.append("  AND  A.SKD_VOY_NO = SKD.SKD_VOY_NO" ).append("\n"); 
		query.append("  AND  A.SKD_DIR_CD = SKD.SKD_DIR_CD" ).append("\n"); 
		query.append("  AND  A.T_POD      = SKD.VPS_PORT_CD" ).append("\n"); 
		query.append("  AND  SKD.CLPT_IND_SEQ = 1" ).append("\n"); 
		query.append("  AND  SKD.CLPT_SEQ >= @[min_seq]" ).append("\n"); 
		query.append("#if (${allerror} != 'ALL') " ).append("\n"); 
		query.append("	AND VVD != T_VVD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${blmi} == 'Manifested') " ).append("\n"); 
		query.append("	AND (mf_sts = 'Sent By MI' OR mf_sts = 'Added By AI')" ).append("\n"); 
		query.append("#elseif (${blmi} != '') " ).append("\n"); 
		query.append("	AND mf_sts = @[blmi]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND NOT EXISTS (" ).append("\n"); 
		query.append("                    SELECT 'Y'" ).append("\n"); 
		query.append("                    FROM BKG_BOOKING " ).append("\n"); 
		query.append("                    WHERE FM_BKG_NO = A.MBL_NO" ).append("\n"); 
		query.append("                    AND BL_NO_TP = '9'" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY mbl_no, gubun" ).append("\n"); 

	}
}