/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CimCommonDBDAOOscarEdiErrorInformationListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.03
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.03 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cim.cimcommon.cimcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CimCommonDBDAOOscarEdiErrorInformationListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Edi Error Search
	  * </pre>
	  */
	public CimCommonDBDAOOscarEdiErrorInformationListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_yard1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_yard2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_message",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_edi_rslt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flt_file_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("check_digit",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_edi_msg_tp_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_cntrno",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_value",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lcc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("start_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_date2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_date1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_bl",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_edi_msg_area_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("end_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cim.cimcommon.cimcommon.integration").append("\n"); 
		query.append("FileName : CimCommonDBDAOOscarEdiErrorInformationListRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("    CRE_LOCL_DT  -- Receving Date" ).append("\n"); 
		query.append("   , CNTR_NO     -- Container No." ).append("\n"); 
		query.append("   , CNTR_TPSZ_CD  -- T/S" ).append("\n"); 
		query.append("   , EDI_MVMT_STS_CD  -- STS" ).append("\n"); 
		query.append("   , EVNT_YD_CD  -- ORG YD" ).append("\n"); 
		query.append("   , EVNT_DT -- Event Date" ).append("\n"); 
		query.append("   , MVMT_EDI_RMK  -- Result error message " ).append("\n"); 
		query.append("   , EDI_GATE_IO_CD -- GATE I/O" ).append("\n"); 
		query.append("   , MVMT_EDI_SGHT_CD -- Sight" ).append("\n"); 
		query.append("   , CNTR_FULL_STS_CD  -- Full STS" ).append("\n"); 
		query.append("   , RCV_TP  -- RCV TP                                              " ).append("\n"); 
		query.append("   , BKG_NO                                       -- Booking No." ).append("\n"); 
		query.append("   , BL_NO                       -- BL No." ).append("\n"); 
		query.append("   , CALL_SGN_LLOYD  --hidden" ).append("\n"); 
		query.append("   , CALL_SGN_NO  -- Call Sign" ).append("\n"); 
		query.append("   , LLOYD_NO            -- Lloyd" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT /*+ USE_NL(D B A) */" ).append("\n"); 
		query.append("		ROWNUM AS ROW_SEQ" ).append("\n"); 
		query.append("       , TO_CHAR (D.CRE_LOCL_DT, 'YYYY-MM-DD HH24:MI') AS CRE_LOCL_DT  -- Receving Date" ).append("\n"); 
		query.append("       , D.CNTR_NO     -- Container No." ).append("\n"); 
		query.append("       , D.CNTR_TPSZ_CD  -- T/S" ).append("\n"); 
		query.append("       , D.EDI_MVMT_STS_CD  -- STS" ).append("\n"); 
		query.append("       , D.EVNT_YD_CD  -- ORG YD" ).append("\n"); 
		query.append("       , TO_CHAR (D.EVNT_DT, 'YYYY-MM-DD HH24:MI') AS EVNT_DT -- Event Date" ).append("\n"); 
		query.append("       , D.MVMT_EDI_RMK  -- Result error message" ).append("\n"); 
		query.append("       , D.EDI_GATE_IO_CD -- GATE I/O" ).append("\n"); 
		query.append("       , D.MVMT_EDI_SGHT_CD -- Sight" ).append("\n"); 
		query.append("       , D.CNTR_FULL_STS_CD  -- Full STS" ).append("\n"); 
		query.append("       , SUBSTR(D.FLT_FILE_REF_NO, 1, 3) RCV_TP  -- RCV TP                                              " ).append("\n"); 
		query.append("       , D.BKG_NO                                       -- Booking No." ).append("\n"); 
		query.append("       , D.EDI_BL_NO AS BL_NO                       -- BL No." ).append("\n"); 
		query.append("       , NVL (D.CALL_SGN_NO, D.LLOYD_NO) AS CALL_SGN_LLOYD  --hidden" ).append("\n"); 
		query.append("       , D.CALL_SGN_NO AS CALL_SGN_NO  -- Call Sign" ).append("\n"); 
		query.append("       , D.LLOYD_NO AS LLOYD_NO            -- Lloyd" ).append("\n"); 
		query.append("FROM CTM_MVMT_EDI_MSG D" ).append("\n"); 
		query.append("      , MDM_LOCATION B" ).append("\n"); 
		query.append("      , MDM_EQ_ORZ_CHT A" ).append("\n"); 
		query.append("      , COM_SYS_AREA_GRP_ID G" ).append("\n"); 
		query.append("      , MDM_YARD M" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND D.EVNT_YD_CD = M.YD_CD(+)" ).append("\n"); 
		query.append("AND SUBSTR (M.YD_CD, 1, 2) = G.CNT_CD(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${event_receive} == 'RECEIVE')" ).append("\n"); 
		query.append("	#if (${p_date3} != '')" ).append("\n"); 
		query.append("   		AND D.IDX_CRE_LOCL_DT IN (${p_date3})" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("   		AND D.IDX_CRE_LOCL_DT BETWEEN REPLACE (@[p_date1], '-', '') AND REPLACE (@[p_date2], '-', '')" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	#if (${p_date3} != '')" ).append("\n"); 
		query.append("   		AND D.IDX_EVNT_DT IN (${p_date3})" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("   		AND D.IDX_EVNT_DT BETWEEN REPLACE (@[p_date1], '-', '') AND REPLACE (@[p_date2], '-', '')" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" #if (${bkg_bl} != '' || ${p_cntrno} != '')" ).append("\n"); 
		query.append("	#if (${p_cntrno} == 'HJCU')" ).append("\n"); 
		query.append("	   #if (${mvmt_edi_msg_area_cd} != '')" ).append("\n"); 
		query.append("		  AND NVL(D.MVMT_EDI_MSG_AREA_CD, G.SYS_AREA_GRP_ID) = @[mvmt_edi_msg_area_cd]" ).append("\n"); 
		query.append("	   #else" ).append("\n"); 
		query.append("		  AND D.MVMT_EDI_MSG_AREA_CD IN ('KOR', 'CHN', 'SWA', 'EUR', 'USA')" ).append("\n"); 
		query.append("	   #end" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("	   #if (${mvmt_edi_msg_area_cd} != '')" ).append("\n"); 
		query.append("		  AND NVL(D.MVMT_EDI_MSG_AREA_CD, G.SYS_AREA_GRP_ID) = @[mvmt_edi_msg_area_cd]" ).append("\n"); 
		query.append("	   #else" ).append("\n"); 
		query.append("		  AND TRIM (D.MVMT_EDI_MSG_AREA_CD) IN ('KOR', 'CHN', 'SWA', 'EUR', 'USA')" ).append("\n"); 
		query.append("	   #end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${bkg_bl} != '')" ).append("\n"); 
		query.append("	   AND (D.BKG_NO LIKE @[bkg_bl]||'%' OR D.EDI_BL_NO LIKE @[bkg_bl]||'%')" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${check_digit} != '')" ).append("\n"); 
		query.append("	   AND D.CNTR_NO = @[p_cntrno]||@[check_digit]" ).append("\n"); 
		query.append("	#elseif (${p_cntrno} != '')" ).append("\n"); 
		query.append("	   AND D.CNTR_NO LIKE @[p_cntrno]||'%'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append(" #else" ).append("\n"); 
		query.append("	#if (${mvmt_edi_msg_area_cd} != '')" ).append("\n"); 
		query.append("	   AND NVL(D.MVMT_EDI_MSG_AREA_CD, G.SYS_AREA_GRP_ID) = @[mvmt_edi_msg_area_cd]" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("	   AND D.MVMT_EDI_MSG_AREA_CD IN ('KOR', 'CHN', 'SWA', 'EUR', 'USA')" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cntr_tpsz_cd} != '')" ).append("\n"); 
		query.append("	AND D.CNTR_TPSZ_CD IN (${cntr_tpsz_cd})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${p_yard2} != '')" ).append("\n"); 
		query.append("##/* AND D.EVNT_YD_CD = @[p_yard1]||@[p_yard2] */" ).append("\n"); 
		query.append("	AND D.EVNT_YD_CD LIKE @[p_yard1]||@[p_yard2]" ).append("\n"); 
		query.append("#elseif (${p_yard1} != '')" ).append("\n"); 
		query.append("	AND D.EVNT_YD_CD LIKE @[p_yard1]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" #if (${tml_nm} != '')" ).append("\n"); 
		query.append("	AND UPPER(D.TML_NM) LIKE '%'||@[tml_nm] ||'%'" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(" #if (${lcc_cd} != '')" ).append("\n"); 
		query.append("	AND A.LCC_CD = @[lcc_cd]" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(" #if (${rcc_cd} != '')" ).append("\n"); 
		query.append("	AND A.RCC_CD = @[rcc_cd]" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" #if (${vvd_value} != '')" ).append("\n"); 
		query.append("	#if (${vvd_combo} == 'VVD_CD')" ).append("\n"); 
		query.append("	   AND D.CRNT_VSL_CD||D.CRNT_SKD_VOY_NO||D.CRNT_SKD_DIR_CD LIKE @[vvd_value]||'%'" ).append("\n"); 
		query.append("	#elseif (${vvd_combo} == 'CALL_SGN_NO')" ).append("\n"); 
		query.append("	   AND D.CALL_SGN_NO  LIKE @[vvd_value]||'%'" ).append("\n"); 
		query.append("	#elseif (${vvd_combo} == 'LLOYD_NO')" ).append("\n"); 
		query.append("	   AND D.LLOYD_NO  LIKE @[vvd_value]||'%'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(" #if (${cntr_full_sts_cd} == 'F')" ).append("\n"); 
		query.append("	AND TRIM (D.CNTR_FULL_STS_CD) IN ('F', 'L', 'AH')" ).append("\n"); 
		query.append(" #elseif (${cntr_full_sts_cd} == 'M')" ).append("\n"); 
		query.append("	AND TRIM (D.CNTR_FULL_STS_CD) IN ('E', 'M', 'AB', 'AJ')" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(" #if (${mvmt_edi_msg_tp_id} != '')" ).append("\n"); 
		query.append("	#if (${mvmt_edi_msg_tp_id} != 'ALL')" ).append("\n"); 
		query.append("	   AND D.MVMT_EDI_MSG_TP_ID = @[mvmt_edi_msg_tp_id]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(" #if (${mvmt_edi_rslt_cd} != '')" ).append("\n"); 
		query.append("	#if (${mvmt_edi_rslt_cd} == 'ALL')" ).append("\n"); 
		query.append("	   AND D.MVMT_EDI_RSLT_CD NOT IN ('D')" ).append("\n"); 
		query.append("	#elseif (${mvmt_edi_rslt_cd} == 'X')" ).append("\n"); 
		query.append("	   AND D.MVMT_EDI_RSLT_CD IN ('X', 'I')" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("	   AND D.MVMT_EDI_RSLT_CD = @[mvmt_edi_rslt_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(" #if (${edi_mvmt_sts_cd} != '')" ).append("\n"); 
		query.append("	AND D.EDI_MVMT_STS_CD IN (${edi_mvmt_sts_cd})" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(" #if (${rty_knt} != '')" ).append("\n"); 
		query.append("	#if (${rty_knt} == '0')" ).append("\n"); 
		query.append("	   AND D.RTY_KNT = 0" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("	   AND D.RTY_KNT > 0" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(" #if (${edi_gate_io_cd} != '')" ).append("\n"); 
		query.append("	AND TRIM (D.EDI_GATE_IO_CD) IN (${edi_gate_io_cd})" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" #if (${flt_file_ref_no} != '')" ).append("\n"); 
		query.append("	AND D.FLT_FILE_REF_NO LIKE  @[flt_file_ref_no]||'%'" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${s_message} != '')" ).append("\n"); 
		query.append("	AND UPPER(D.MVMT_EDI_RMK) LIKE '%'||UPPER(@[s_message])||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND A.SCC_CD(+) = B.SCC_CD" ).append("\n"); 
		query.append("AND B.LOC_CD(+) = SUBSTR (D.EVNT_YD_CD, 0, 5)" ).append("\n"); 
		query.append(")Z WHERE 1=1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${start_no} != '') " ).append("\n"); 
		query.append("  AND 	ROW_SEQ BETWEEN @[start_no] AND @[end_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}