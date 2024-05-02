/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ChassisMgsetInvoiceDBDAOSearchSCExceptionRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.11
*@LastModifier : 박정민
*@LastVersion : 1.0
* 2016.04.11 박정민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeong Min Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetInvoiceDBDAOSearchSCExceptionRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * S/C Exception Data를 조회한다.
	  * 
	  * * 첫행의 타이틀에 갈 SCC 값 세팅 하는 조건 
	  * * 마지막행의 qty 값 세팅 하는 조건 
	  * 
	  * 2015.12.18 [CHM-201539416] SC EXEPTION 화면 변경 : Effective Date, Expire Date 추가
	  * </pre>
	  */
	public ChassisMgsetInvoiceDBDAOSearchSCExceptionRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.integration").append("\n"); 
		query.append("FileName : ChassisMgsetInvoiceDBDAOSearchSCExceptionRSQL").append("\n"); 
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
		query.append("WITH LV_EXP_LIST AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("       P.SC_NO," ).append("\n"); 
		query.append("       (SELECT Z.CUST_CNT_CD||Z.CUST_SEQ" ).append("\n"); 
		query.append("        FROM  PRI_SP_CTRT_PTY Z , MDM_CUSTOMER M" ).append("\n"); 
		query.append("        WHERE P.PROP_NO = Z.PROP_NO" ).append("\n"); 
		query.append("        AND   Z.PRC_CTRT_PTY_TP_CD='C'" ).append("\n"); 
		query.append("        AND   Z.CUST_CNT_CD = M.CUST_CNT_CD" ).append("\n"); 
		query.append("        AND   Z.CUST_SEQ = M.CUST_SEQ" ).append("\n"); 
		query.append("        AND   ROWNUM=1" ).append("\n"); 
		query.append("       ) SC_CUST_NO," ).append("\n"); 
		query.append("       /* CHM-201539416 수정 추가 */" ).append("\n"); 
		query.append("       A.EFF_DT," ).append("\n"); 
		query.append("       A.EXP_DT," ).append("\n"); 
		query.append("       /* CHM-201539416 수정 추가 */" ).append("\n"); 
		query.append("       A.LOC_CD," ).append("\n"); 
		query.append("       A.CUST_CNT_CD," ).append("\n"); 
		query.append("       A.CUST_SEQ," ).append("\n"); 
		query.append("       NVL((SELECT M.CUST_CNT_CD||M.CUST_SEQ||'('||M.CUST_LGL_ENG_NM||')'  FROM MDM_CUSTOMER M WHERE A.CUST_CNT_CD =M.CUST_CNT_CD AND A.CUST_SEQ = M.CUST_SEQ),'Cust*')||'/'||" ).append("\n"); 
		query.append("       NVL(A.CHSS_CNTR_CGO_TP_CD,'Cgo*')||'/'||" ).append("\n"); 
		query.append("       NVL((SELECT M.CMDT_CD||'('||M.CMDT_NM||')' FROM MDM_COMMODITY M WHERE A.CMDT_CD = M.CMDT_CD),'Cmdt*')||" ).append("\n"); 
		query.append("       DECODE(A.USA_SC_EXPT_RMK,NULL,'','/'||A.USA_SC_EXPT_RMK) AS SPCL_INFO," ).append("\n"); 
		query.append("       DECODE(NVL(A.CUST_CNT_CD,'*')||NVL(A.CHSS_CNTR_CGO_TP_CD,'*')||NVL(A.CMDT_CD,'*')||DECODE(NVL(A.FT_DYS, 0), 0, '*'),'****','Y','N') ALL_FLG," ).append("\n"); 
		query.append("       A.USA_SC_EXPT_RMK," ).append("\n"); 
		query.append("       NVL(V.FT_FLG, 'N') FT_FLG," ).append("\n"); 
		query.append("       DECODE(NVL(A.FT_DYS, 0), 0, '', '-Freetime(' || A.FT_DYS || 'Days)') FT_DYS" ).append("\n"); 
		query.append("FROM CGM_SC_EXPT_LIST A , PRI_SP_HDR P , CGM_SC_EXPT_VER V" ).append("\n"); 
		query.append("WHERE  A.PROP_NO = P.PROP_NO(+)" ).append("\n"); 
		query.append("and    A.PROP_NO = V.PROP_NO" ).append("\n"); 
		query.append("AND    A.SC_EXPT_VER_SEQ = V.SC_EXPT_VER_SEQ" ).append("\n"); 
		query.append("AND    V.CHSS_EXPT_VER_STS_CD = 'L'" ).append("\n"); 
		query.append("AND    (TO_DATE(@[sc_fm_dt], 'YYYY-MM-DD') BETWEEN V.EFF_DT AND V.EXP_DT OR TO_DATE(@[sc_to_dt], 'YYYY-MM-DD') BETWEEN V.EFF_DT AND V.EXP_DT)" ).append("\n"); 
		query.append("#if (${loc_cd} != '') " ).append("\n"); 
		query.append("AND    A.LOC_CD IN (	" ).append("\n"); 
		query.append("    #foreach($loc_cd_num IN ${loc_cd})" ).append("\n"); 
		query.append("    	#if($velocityCount < $loc_cd.size()) " ).append("\n"); 
		query.append("    	'$loc_cd_num', " ).append("\n"); 
		query.append("    	#else " ).append("\n"); 
		query.append("    	'$loc_cd_num' " ).append("\n"); 
		query.append("    	#end " ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sc_no} != '') " ).append("\n"); 
		query.append("AND	P.SC_NO IN (	" ).append("\n"); 
		query.append("    #foreach($sc_no_num IN ${sc_no})" ).append("\n"); 
		query.append("    	#if($velocityCount < $sc_no.size()) " ).append("\n"); 
		query.append("    	'$sc_no_num', " ).append("\n"); 
		query.append("    	#else " ).append("\n"); 
		query.append("    	'$sc_no_num' " ).append("\n"); 
		query.append("    	#end " ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", LV_EXP_LIST2 AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT A.SC_NO," ).append("\n"); 
		query.append("       A.SC_CUST_NO," ).append("\n"); 
		query.append("       A.LOC_CD," ).append("\n"); 
		query.append("       /* CHM-201539416 수정 추가 */" ).append("\n"); 
		query.append("       A.EFF_DT," ).append("\n"); 
		query.append("       A.EXP_DT," ).append("\n"); 
		query.append("       /* CHM-201539416 수정 추가 */" ).append("\n"); 
		query.append("       A.FT_FLG," ).append("\n"); 
		query.append("       WM_CONCAT(DECODE(A.ALL_FLG,'Y',A.SC_NO||DECODE(A.USA_SC_EXPT_RMK,NULL,'','/'||A.USA_SC_EXPT_RMK),A.SC_NO||'-'||A.SPCL_INFO||A.FT_DYS||'')) DSP_INFO" ).append("\n"); 
		query.append("FROM LV_EXP_LIST A" ).append("\n"); 
		query.append("WHERE A.SC_NO IS NOT NULL" ).append("\n"); 
		query.append("/* CHM-201539416 수정 추가 */" ).append("\n"); 
		query.append("GROUP BY A.SC_NO,A.SC_CUST_NO,A.LOC_CD,A.EFF_DT,A.EXP_DT, A.FT_FLG" ).append("\n"); 
		query.append("/* CHM-201539416 수정 추가 */" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",LV_SCC_LIST AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("#if (${scc_sort_tp} == 'A')" ).append("\n"); 
		query.append("      RANK() OVER (PARTITION BY 1 ORDER BY LOC_CD ASC) SCC_SEQ," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("     RANK() OVER (PARTITION BY 1 ORDER BY LOC_SC_TCNT DESC, LOC_CD ASC)SCC_SEQ," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       LOC_CD," ).append("\n"); 
		query.append("       LOC_SC_TCNT" ).append("\n"); 
		query.append("FROM(" ).append("\n"); 
		query.append("    SELECT LOC_CD ,COUNT(DISTINCT SC_NO) AS LOC_SC_TCNT" ).append("\n"); 
		query.append("    FROM LV_EXP_LIST" ).append("\n"); 
		query.append("    GROUP BY LOC_CD" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(",LV_EXP_LIST3 AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT A.SC_NO," ).append("\n"); 
		query.append("       A.SC_CUST_NO," ).append("\n"); 
		query.append("       /* CHM-201539416 수정 추가 */" ).append("\n"); 
		query.append("       A.EFF_DT," ).append("\n"); 
		query.append("       A.EXP_DT," ).append("\n"); 
		query.append("       /* CHM-201539416 수정 추가 */" ).append("\n"); 
		query.append("       A.LOC_CD," ).append("\n"); 
		query.append("       A.DSP_INFO," ).append("\n"); 
		query.append("       A.FT_FLG" ).append("\n"); 
		query.append("FROM LV_EXP_LIST2 A" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT '1' AS SC_NO," ).append("\n"); 
		query.append("        '1'  AS SC_CUST_NO," ).append("\n"); 
		query.append("        /* CHM-201539416 수정 추가 */" ).append("\n"); 
		query.append("        sysdate AS EFF_DT," ).append("\n"); 
		query.append("        sysdate AS EXP_DT," ).append("\n"); 
		query.append("        /* CHM-201539416 수정 추가 */" ).append("\n"); 
		query.append("        B.LOC_CD," ).append("\n"); 
		query.append("        B.LOC_CD AS DSP_INFO," ).append("\n"); 
		query.append("        '' FT_FLG" ).append("\n"); 
		query.append("FROM DUAL A , LV_SCC_LIST B" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'zzzzzz' AS SC_NO," ).append("\n"); 
		query.append("        'zz'  AS SC_CUST_NO," ).append("\n"); 
		query.append("        /* CHM-201539416 수정 추가 */" ).append("\n"); 
		query.append("        sysdate AS EFF_DT," ).append("\n"); 
		query.append("        sysdate AS EXP_DT," ).append("\n"); 
		query.append("        /* CHM-201539416 수정 추가 */" ).append("\n"); 
		query.append("        B.LOC_CD," ).append("\n"); 
		query.append("        TO_CHAR(B.LOC_SC_TCNT) AS DSP_INFO," ).append("\n"); 
		query.append("        '' FT_FLG" ).append("\n"); 
		query.append("FROM DUAL A , LV_SCC_LIST B" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("      A.SC_NO," ).append("\n"); 
		query.append("      A.SC_CUST_NO," ).append("\n"); 
		query.append("      (SELECT M.CUST_LGL_ENG_NM  FROM MDM_CUSTOMER M WHERE SUBSTR(A.SC_CUST_NO,1,2) =M.CUST_CNT_CD AND SUBSTR(A.SC_CUST_NO,3) = M.CUST_SEQ) AS SC_CUST_NM," ).append("\n"); 
		query.append("      /* CHM-201539416 수정 추가 */" ).append("\n"); 
		query.append("      to_char(A.EFF_DT, 'yyyymmdd') AS EFF_DT," ).append("\n"); 
		query.append("      to_char(A.EXP_DT, 'yyyymmdd') AS EXP_DT," ).append("\n"); 
		query.append("      /* CHM-201539416 수정 추가 */" ).append("\n"); 
		query.append("      COUNT(*) SC_LOC_TCNT," ).append("\n"); 
		query.append("      A.FT_FLG," ).append("\n"); 
		query.append("      MAX(DECODE(C.SCC_SEQ,1 ,A.DSP_INFO)) SCC1," ).append("\n"); 
		query.append("      MAX(DECODE(C.SCC_SEQ,2 ,A.DSP_INFO)) SCC2," ).append("\n"); 
		query.append("      MAX(DECODE(C.SCC_SEQ,3 ,A.DSP_INFO)) SCC3," ).append("\n"); 
		query.append("      MAX(DECODE(C.SCC_SEQ,4 ,A.DSP_INFO)) SCC4," ).append("\n"); 
		query.append("      MAX(DECODE(C.SCC_SEQ,5 ,A.DSP_INFO)) SCC5," ).append("\n"); 
		query.append("      MAX(DECODE(C.SCC_SEQ,6 ,A.DSP_INFO)) SCC6," ).append("\n"); 
		query.append("      MAX(DECODE(C.SCC_SEQ,7 ,A.DSP_INFO)) SCC7," ).append("\n"); 
		query.append("      MAX(DECODE(C.SCC_SEQ,8 ,A.DSP_INFO)) SCC8," ).append("\n"); 
		query.append("      MAX(DECODE(C.SCC_SEQ,9 ,A.DSP_INFO)) SCC9," ).append("\n"); 
		query.append("      MAX(DECODE(C.SCC_SEQ,10,A.DSP_INFO)) SCC10," ).append("\n"); 
		query.append("      MAX(DECODE(C.SCC_SEQ,11,A.DSP_INFO)) SCC11," ).append("\n"); 
		query.append("      MAX(DECODE(C.SCC_SEQ,12,A.DSP_INFO)) SCC12," ).append("\n"); 
		query.append("      MAX(DECODE(C.SCC_SEQ,13,A.DSP_INFO)) SCC13," ).append("\n"); 
		query.append("      MAX(DECODE(C.SCC_SEQ,14,A.DSP_INFO)) SCC14," ).append("\n"); 
		query.append("      MAX(DECODE(C.SCC_SEQ,15,A.DSP_INFO)) SCC15," ).append("\n"); 
		query.append("      MAX(DECODE(C.SCC_SEQ,16,A.DSP_INFO)) SCC16," ).append("\n"); 
		query.append("      MAX(DECODE(C.SCC_SEQ,17,A.DSP_INFO)) SCC17," ).append("\n"); 
		query.append("      MAX(DECODE(C.SCC_SEQ,18,A.DSP_INFO)) SCC18," ).append("\n"); 
		query.append("      MAX(DECODE(C.SCC_SEQ,19,A.DSP_INFO)) SCC19," ).append("\n"); 
		query.append("      MAX(DECODE(C.SCC_SEQ,20,A.DSP_INFO)) SCC20," ).append("\n"); 
		query.append("      MAX(DECODE(C.SCC_SEQ,21,A.DSP_INFO)) SCC21," ).append("\n"); 
		query.append("      MAX(DECODE(C.SCC_SEQ,22,A.DSP_INFO)) SCC22," ).append("\n"); 
		query.append("      MAX(DECODE(C.SCC_SEQ,23,A.DSP_INFO)) SCC23," ).append("\n"); 
		query.append("      MAX(DECODE(C.SCC_SEQ,24,A.DSP_INFO)) SCC24," ).append("\n"); 
		query.append("      MAX(DECODE(C.SCC_SEQ,25,A.DSP_INFO)) SCC25," ).append("\n"); 
		query.append("      MAX(DECODE(C.SCC_SEQ,26,A.DSP_INFO)) SCC26," ).append("\n"); 
		query.append("      MAX(DECODE(C.SCC_SEQ,27,A.DSP_INFO)) SCC27," ).append("\n"); 
		query.append("      MAX(DECODE(C.SCC_SEQ,28,A.DSP_INFO)) SCC28," ).append("\n"); 
		query.append("      MAX(DECODE(C.SCC_SEQ,29,A.DSP_INFO)) SCC29," ).append("\n"); 
		query.append("      MAX(DECODE(C.SCC_SEQ,30,A.DSP_INFO)) SCC30," ).append("\n"); 
		query.append("      MAX(DECODE(C.SCC_SEQ,31,A.DSP_INFO)) SCC31," ).append("\n"); 
		query.append("      MAX(DECODE(C.SCC_SEQ,32,A.DSP_INFO)) SCC32," ).append("\n"); 
		query.append("      MAX(DECODE(C.SCC_SEQ,33,A.DSP_INFO)) SCC33," ).append("\n"); 
		query.append("      MAX(DECODE(C.SCC_SEQ,34,A.DSP_INFO)) SCC34," ).append("\n"); 
		query.append("      MAX(DECODE(C.SCC_SEQ,35,A.DSP_INFO)) SCC35," ).append("\n"); 
		query.append("      MAX(DECODE(C.SCC_SEQ,36,A.DSP_INFO)) SCC36," ).append("\n"); 
		query.append("      MAX(DECODE(C.SCC_SEQ,37,A.DSP_INFO)) SCC37," ).append("\n"); 
		query.append("      MAX(DECODE(C.SCC_SEQ,38,A.DSP_INFO)) SCC38," ).append("\n"); 
		query.append("      MAX(DECODE(C.SCC_SEQ,39,A.DSP_INFO)) SCC39," ).append("\n"); 
		query.append("      MAX(DECODE(C.SCC_SEQ,40,A.DSP_INFO)) SCC40," ).append("\n"); 
		query.append("      MAX(DECODE(C.SCC_SEQ,41,A.DSP_INFO)) SCC41," ).append("\n"); 
		query.append("      MAX(DECODE(C.SCC_SEQ,42,A.DSP_INFO)) SCC42," ).append("\n"); 
		query.append("      MAX(DECODE(C.SCC_SEQ,43,A.DSP_INFO)) SCC43," ).append("\n"); 
		query.append("      MAX(DECODE(C.SCC_SEQ,44,A.DSP_INFO)) SCC44," ).append("\n"); 
		query.append("      MAX(DECODE(C.SCC_SEQ,45,A.DSP_INFO)) SCC45," ).append("\n"); 
		query.append("      MAX(DECODE(C.SCC_SEQ,46,A.DSP_INFO)) SCC46," ).append("\n"); 
		query.append("      MAX(DECODE(C.SCC_SEQ,47,A.DSP_INFO)) SCC47," ).append("\n"); 
		query.append("      MAX(DECODE(C.SCC_SEQ,48,A.DSP_INFO)) SCC48," ).append("\n"); 
		query.append("      MAX(DECODE(C.SCC_SEQ,49,A.DSP_INFO)) SCC49," ).append("\n"); 
		query.append("      MAX(DECODE(C.SCC_SEQ,50,A.DSP_INFO)) SCC50," ).append("\n"); 
		query.append("      MAX(DECODE(C.SCC_SEQ,51,A.DSP_INFO)) SCC51," ).append("\n"); 
		query.append("      MAX(DECODE(C.SCC_SEQ,52,A.DSP_INFO)) SCC52," ).append("\n"); 
		query.append("      MAX(DECODE(C.SCC_SEQ,53,A.DSP_INFO)) SCC53," ).append("\n"); 
		query.append("      MAX(DECODE(C.SCC_SEQ,54,A.DSP_INFO)) SCC54," ).append("\n"); 
		query.append("      MAX(DECODE(C.SCC_SEQ,55,A.DSP_INFO)) SCC55," ).append("\n"); 
		query.append("      MAX(DECODE(C.SCC_SEQ,56,A.DSP_INFO)) SCC56," ).append("\n"); 
		query.append("      MAX(DECODE(C.SCC_SEQ,57,A.DSP_INFO)) SCC57," ).append("\n"); 
		query.append("      MAX(DECODE(C.SCC_SEQ,58,A.DSP_INFO)) SCC58," ).append("\n"); 
		query.append("      MAX(DECODE(C.SCC_SEQ,59,A.DSP_INFO)) SCC59," ).append("\n"); 
		query.append("      MAX(DECODE(C.SCC_SEQ,60,A.DSP_INFO)) SCC60,        " ).append("\n"); 
		query.append("      MAX(DECODE(C.SCC_SEQ,61,A.DSP_INFO)) SCC61, " ).append("\n"); 
		query.append("      MAX(DECODE(C.SCC_SEQ,62,A.DSP_INFO)) SCC62,      " ).append("\n"); 
		query.append("      MAX(DECODE(C.SCC_SEQ,63,A.DSP_INFO)) SCC63," ).append("\n"); 
		query.append("      MAX(DECODE(C.SCC_SEQ,64,A.DSP_INFO)) SCC64," ).append("\n"); 
		query.append("      MAX(DECODE(C.SCC_SEQ,65,A.DSP_INFO)) SCC65                                                   " ).append("\n"); 
		query.append("FROM  LV_EXP_LIST3 A, LV_SCC_LIST C" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND   A.LOC_CD = C.LOC_CD" ).append("\n"); 
		query.append("/* CHM-201539416 수정 추가 */" ).append("\n"); 
		query.append("GROUP BY A.SC_NO,A.SC_CUST_NO,A.EFF_DT,A.EXP_DT,A.FT_FLG" ).append("\n"); 
		query.append("/* CHM-201539416 수정 추가 */" ).append("\n"); 
		query.append("ORDER BY DECODE(SC_NO,'1',999999,'zzzzzz',-1,SC_LOC_TCNT) DESC, A.SC_NO,A.SC_CUST_NO" ).append("\n"); 

	}
}