/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : DwellNotificationDBDAOSearchDwellCandidateListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.26
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2012.06.26 채창호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.dwellnotification.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chae Change Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DwellNotificationDBDAOSearchDwellCandidateListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchDwellCandidateList 조회
	  * </pre>
	  */
	public DwellNotificationDBDAOSearchDwellCandidateListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rail_so_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rail_dest",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mode_input",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sent",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dwll_tm_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("search_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.dwellnotification.integration").append("\n"); 
		query.append("FileName : DwellNotificationDBDAOSearchDwellCandidateListRSQL").append("\n"); 
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
		query.append("FROM ( SELECT A.CNTR_NO" ).append("\n"); 
		query.append(", A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(", A.DWLL_TM_TP_CD" ).append("\n"); 
		query.append(", DECODE(A.DWLL_TM_TP_CD , 'T96', '96 hrs Terminal Dwell' , 'D72', '72 hrs Destination Dwell' , 'E48', '48 hrs En-route Dwell' , 'V24', '24 hrs Vessel Delay' , NULL) DWLL_TM_TP_CD_DESC" ).append("\n"); 
		query.append(", A.SC_NO" ).append("\n"); 
		query.append(", (" ).append("\n"); 
		query.append("SELECT M.CUST_CNT_CD||DECODE(CUST_SEQ, NULL, '', 0, '', LPAD(CUST_SEQ, 6, '0'))||NVL2(M.CUST_LGL_ENG_NM, '('||M.CUST_LGL_ENG_NM||')', '')" ).append("\n"); 
		query.append("FROM MDM_CUSTOMER M" ).append("\n"); 
		query.append("WHERE A.SC_CUST_CNT_CD = M.CUST_CNT_CD" ).append("\n"); 
		query.append("AND A.SC_CUST_SEQ = M.CUST_SEQ) CUST_CD_NM" ).append("\n"); 
		query.append(", C.CUST_SEQ CNEE_CUST_SEQ --A.CNEE_CUST_SEQ ," ).append("\n"); 
		query.append(", C.CUST_NM CNEE_CUST_NM --A.CNEE_CUST_NM ," ).append("\n"); 
		query.append(", A.BKG_NO" ).append("\n"); 
		query.append(", A.BKG_NO BL_NO" ).append("\n"); 
		query.append(", A.VSL_SLAN_CD" ).append("\n"); 
		query.append(", A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD VVD_CD" ).append("\n"); 
		query.append(", A.POL_CD" ).append("\n"); 
		query.append(", A.POD_CD" ).append("\n"); 
		query.append(", A.DEL_CD" ).append("\n"); 
		query.append(", A.DE_TERM_CD" ).append("\n"); 
		query.append(", A.CNMV_STS_CD||'/'||A.ORG_YD_CD MVMT_STS_YD" ).append("\n"); 
		query.append(", TO_CHAR(A.CNMV_EVNT_DT, 'YYYY-MM-DD HH24:MI:SS') CNMV_EVNT_DT" ).append("\n"); 
		query.append(", A.DWLL_HRS" ).append("\n"); 
		query.append(", A.DWLL_RSN" ).append("\n"); 
		query.append(", A.FRT_CLT_FLG" ).append("\n"); 
		query.append(", A.OBL_RDEM_FLG" ).append("\n"); 
		query.append(", A.CSTMS_CLR_CD" ).append("\n"); 
		query.append(", TO_CHAR(A.CSTMS_CLR_LST_DT, 'YYYY-MM-DD HH24:MI:SS') CSTMS_CLR_LST_DT" ).append("\n"); 
		query.append(", A.CSTMS_LOC_CD" ).append("\n"); 
		query.append(", NVL( (SELECT 'Y' FROM SCE_DWLL_NTFC_EML_SND_RSLT R" ).append("\n"); 
		query.append("WHERE A.EML_SND_DT = R.EML_SND_DT" ).append("\n"); 
		query.append("AND A.DWLL_TM_TP_CD = R.DWLL_TM_TP_CD" ).append("\n"); 
		query.append("AND A.CNTR_NO = R.CNTR_NO" ).append("\n"); 
		query.append("AND A.BKG_NO = R.BKG_NO" ).append("\n"); 
		query.append("AND S.CUST_CNT_CD = R.DWLL_CUST_CNT_CD" ).append("\n"); 
		query.append("AND S.CUST_SEQ = R.DWLL_CUST_SEQ" ).append("\n"); 
		query.append("AND ROWNUM=1" ).append("\n"); 
		query.append("), 'N') SND_STS" ).append("\n"); 
		query.append(", NVL( (SELECT 'Y' FROM SCE_DWLL_NTFC_EML_SND_RSLT R" ).append("\n"); 
		query.append("WHERE A.EML_SND_DT = R.EML_SND_DT" ).append("\n"); 
		query.append("AND A.DWLL_TM_TP_CD = R.DWLL_TM_TP_CD" ).append("\n"); 
		query.append("AND A.CNTR_NO = R.CNTR_NO" ).append("\n"); 
		query.append("AND A.BKG_NO = R.BKG_NO" ).append("\n"); 
		query.append("AND C.CUST_CNT_CD = R.DWLL_CUST_CNT_CD" ).append("\n"); 
		query.append("AND C.CUST_SEQ = R.DWLL_CUST_SEQ" ).append("\n"); 
		query.append("AND ROWNUM=1" ).append("\n"); 
		query.append("), 'N') CNEE_SND_STS" ).append("\n"); 
		query.append(", NVL( (SELECT 'Y' FROM SCE_DWLL_NTFC_EML_SND_RSLT R" ).append("\n"); 
		query.append("WHERE A.EML_SND_DT = R.EML_SND_DT" ).append("\n"); 
		query.append("AND A.DWLL_TM_TP_CD = R.DWLL_TM_TP_CD" ).append("\n"); 
		query.append("AND A.CNTR_NO = R.CNTR_NO" ).append("\n"); 
		query.append("AND A.BKG_NO = R.BKG_NO" ).append("\n"); 
		query.append("AND N.CUST_CNT_CD = R.DWLL_CUST_CNT_CD" ).append("\n"); 
		query.append("AND N.CUST_SEQ = R.DWLL_CUST_SEQ" ).append("\n"); 
		query.append("AND ROWNUM=1" ).append("\n"); 
		query.append("), 'N') NTFY_SND_STS" ).append("\n"); 
		query.append(", (SELECT 'Edit (Registered :'||COUNT(*)||')'" ).append("\n"); 
		query.append("FROM SCE_DWLL_CUST_SVC_LIST R" ).append("\n"); 
		query.append("WHERE S.CUST_CNT_CD = R.DWLL_CUST_CNT_CD" ).append("\n"); 
		query.append("AND S.CUST_SEQ = R.DWLL_CUST_SEQ" ).append("\n"); 
		query.append("AND R.DELT_FLG = 'N') EML_CNT" ).append("\n"); 
		query.append(", (SELECT 'Edit (Registered :'||COUNT(*)||')'" ).append("\n"); 
		query.append("FROM SCE_DWLL_CUST_SVC_LIST R" ).append("\n"); 
		query.append("WHERE C.CUST_CNT_CD = R.DWLL_CUST_CNT_CD" ).append("\n"); 
		query.append("AND C.CUST_SEQ = R.DWLL_CUST_SEQ" ).append("\n"); 
		query.append("AND R.DELT_FLG = 'N') CNEE_EML_CNT" ).append("\n"); 
		query.append(", (SELECT 'Edit (Registered :'||COUNT(*)||')'" ).append("\n"); 
		query.append("FROM SCE_DWLL_CUST_SVC_LIST R" ).append("\n"); 
		query.append("WHERE N.CUST_CNT_CD = R.DWLL_CUST_CNT_CD" ).append("\n"); 
		query.append("AND N.CUST_SEQ = R.DWLL_CUST_SEQ" ).append("\n"); 
		query.append("AND R.DELT_FLG = 'N' ) NTFY_EML_CNT" ).append("\n"); 
		query.append(", CASE WHEN S.CUST_DWLL_EXPT_FLG = 'Y' OR CNTR_DWLL_EXPT_FLG = 'Y' THEN 'Y' ELSE 'N' END EXCP_STS" ).append("\n"); 
		query.append(", CASE WHEN C.CUST_DWLL_EXPT_FLG = 'Y' OR CNTR_DWLL_EXPT_FLG = 'Y' THEN 'Y' ELSE 'N' END CNEE_EXCP_STS" ).append("\n"); 
		query.append(", CASE WHEN N.CUST_DWLL_EXPT_FLG = 'Y' OR CNTR_DWLL_EXPT_FLG = 'Y' THEN 'Y' ELSE 'N' END NTFY_EXCP_STS" ).append("\n"); 
		query.append(", S.CUST_CNT_CD||DECODE(S.CUST_SEQ, NULL, '', 0, '', LPAD(S.CUST_SEQ, 6, '0'))||NVL2(S.CUST_NM,'('||S.CUST_NM||')', '') SHPR_CUST_CD_NM" ).append("\n"); 
		query.append(", C.CUST_CNT_CD||DECODE(C.CUST_SEQ, NULL, '', 0, '', LPAD(C.CUST_SEQ, 6, '0'))||NVL2(C.CUST_NM,'('||C.CUST_NM||')', '') CNEE_CUST_CD_NM" ).append("\n"); 
		query.append(", N.CUST_CNT_CD||DECODE(N.CUST_SEQ, NULL, '', 0, '', LPAD(N.CUST_SEQ, 6, '0'))||NVL2(N.CUST_NM,'('||N.CUST_NM||')', '') NTFY_CUST_CD_NM" ).append("\n"); 
		query.append(", DECODE(A.RAIL_SO_FLG,'Y','Rail','N','Port local','') SO_MODE" ).append("\n"); 
		query.append(", TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS', TO_DATE(A.EML_SND_DT ||'1600', 'YYYYMMDDHH24MI'), 'USNYC'), 'YYYYMMDD') EML_SND_DT" ).append("\n"); 
		query.append(", A.RAIL_DEST_YD_CD" ).append("\n"); 
		query.append(", A.RAIL_ORG_YD_CD" ).append("\n"); 
		query.append(", A.CRNT_LOC_CD" ).append("\n"); 
		query.append(", TO_CHAR(A.CRNT_EVNT_DT,'YYYY-MM-DD HH24:MI:SS') CRNT_EVNT_DT" ).append("\n"); 
		query.append(", TO_CHAR(A.RAIL_ARR_ETA_DT,'YYYY-MM-DD HH24:MI:SS') RAIL_ARR_ETA_DT" ).append("\n"); 
		query.append(", TO_CHAR(A.LST_FREE_DT,'YYYY-MM-DD HH24:MI:SS') LST_FREE_DT" ).append("\n"); 
		query.append(", TO_CHAR(A.PKUP_NTC_EVNT_DT,'YYYY-MM-DD HH24:MI:SS') PKUP_NTC_EVNT_DT" ).append("\n"); 
		query.append(", TO_CHAR(A.PKUP_AVAL_DT,'YYYY-MM-DD HH24:MI:SS') PKUP_AVAL_DT" ).append("\n"); 
		query.append(", TO_CHAR(A.VPS_PLN_ETA_DT,'YYYY-MM-DD HH24:MI:SS') VPS_PLN_ETA_DT" ).append("\n"); 
		query.append(", TO_CHAR(A.VPS_ETA_DT,'YYYY-MM-DD HH24:MI:SS') VPS_ETA_DT" ).append("\n"); 
		query.append(", DLAY_CALL_HRS" ).append("\n"); 
		query.append(", A.CRNT_LOC_NM" ).append("\n"); 
		query.append(", TO_CHAR(A.FT_END_DT,'YYYY-MM-DD') FT_END_DT" ).append("\n"); 
		query.append(", A.DWLL_RSN_TP_CD" ).append("\n"); 
		query.append(", A.DWLL_RSN_TP_CD  DWLL_RSN_TP_CD1" ).append("\n"); 
		query.append("FROM SCE_DWLL_NTFC_CNDDT A" ).append("\n"); 
		query.append(",  SCE_DWLL_CNDDT_CUST S" ).append("\n"); 
		query.append(",  SCE_DWLL_CNDDT_CUST C" ).append("\n"); 
		query.append(",  SCE_DWLL_CNDDT_CUST N" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND A.EML_SND_DT = (SELECT TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC('USNYC', TO_DATE(@[search_dt] ||'0300', 'YYYYMMDDHH24MI'), 'KRPUS'), 'YYYYMMDD') FROM DUAL)" ).append("\n"); 
		query.append("AND A.DWLL_TM_TP_CD = @[dwll_tm_tp_cd]" ).append("\n"); 
		query.append("#if(${rail_dest} != '')" ).append("\n"); 
		query.append("AND A.RAIL_DEST_YD_CD LIKE @[rail_dest] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if($scNoArr.size() > 0)" ).append("\n"); 
		query.append("AND SUBSTR(A.SC_NO, 0,3) IN (" ).append("\n"); 
		query.append("#foreach( ${key} in ${scNoArr})" ).append("\n"); 
		query.append("#if($velocityCount == 1)" ).append("\n"); 
		query.append("'${key}'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",'${key}'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${sc_no} != '')" ).append("\n"); 
		query.append("AND A.SC_NO LIKE CASE WHEN ASCII(SUBSTR(@[sc_no],1,1)) BETWEEN 48 AND 57 THEN '___' END || @[sc_no] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${pod_cd} != '')" ).append("\n"); 
		query.append("AND A.POD_CD LIKE @[pod_cd] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${del_cd} != '')" ).append("\n"); 
		query.append("AND A.DEL_CD LIKE @[del_cd] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${vvd} != '')" ).append("\n"); 
		query.append("AND A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD = @[vvd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${mode_input} != '')" ).append("\n"); 
		query.append("AND A.RAIL_SO_FLG  = @[mode_input]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${bkg_no} != '')" ).append("\n"); 
		query.append("AND A.BKG_NO  = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${bl_no} != '')" ).append("\n"); 
		query.append("AND A.BKG_NO  = @[bl_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${cntr_no} != '')" ).append("\n"); 
		query.append("AND A.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_cd} != '')" ).append("\n"); 
		query.append("AND (SUBSTR(@[cust_cd],1,2) ,TO_NUMBER(SUBSTR(@[cust_cd],3,6))) IN ( (S.CUST_CNT_CD,S.CUST_SEQ), (C.CUST_CNT_CD,C.CUST_SEQ), (N.CUST_CNT_CD,N.CUST_SEQ))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND A.RAIL_SO_FLG = NVL(@[rail_so_flg], A.RAIL_SO_FLG)" ).append("\n"); 
		query.append("AND A.EML_SND_DT = S.EML_SND_DT(+)" ).append("\n"); 
		query.append("AND A.DWLL_TM_TP_CD = S.DWLL_TM_TP_CD(+)" ).append("\n"); 
		query.append("AND A.CNTR_NO = S.CNTR_NO(+)" ).append("\n"); 
		query.append("AND A.BKG_NO = S.BKG_NO(+)" ).append("\n"); 
		query.append("AND 'D' = S.BKG_CUST_TP_CD(+)" ).append("\n"); 
		query.append("AND A.EML_SND_DT = C.EML_SND_DT(+)" ).append("\n"); 
		query.append("AND A.DWLL_TM_TP_CD = C.DWLL_TM_TP_CD(+)" ).append("\n"); 
		query.append("AND A.CNTR_NO = C.CNTR_NO(+)" ).append("\n"); 
		query.append("AND A.BKG_NO = C.BKG_NO(+)" ).append("\n"); 
		query.append("AND 'C' = C.BKG_CUST_TP_CD(+)" ).append("\n"); 
		query.append("AND A.EML_SND_DT = N.EML_SND_DT(+)" ).append("\n"); 
		query.append("AND A.DWLL_TM_TP_CD = N.DWLL_TM_TP_CD(+)" ).append("\n"); 
		query.append("AND A.CNTR_NO = N.CNTR_NO(+)" ).append("\n"); 
		query.append("AND A.BKG_NO = N.BKG_NO(+)" ).append("\n"); 
		query.append("AND 'N' = N.BKG_CUST_TP_CD(+)" ).append("\n"); 
		query.append(") AA" ).append("\n"); 
		query.append("#if(${sent} != '')" ).append("\n"); 
		query.append("WHERE AA.SND_STS = @[sent]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${dwll_tm_tp_cd} == 'T96')" ).append("\n"); 
		query.append("ORDER BY POD_CD, DEL_CD, DE_TERM_CD, RAIL_ORG_YD_CD, RAIL_DEST_YD_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}