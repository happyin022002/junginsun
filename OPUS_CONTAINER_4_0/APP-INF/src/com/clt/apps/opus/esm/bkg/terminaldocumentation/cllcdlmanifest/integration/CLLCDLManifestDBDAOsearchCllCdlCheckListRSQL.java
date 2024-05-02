/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CLLCDLManifestDBDAOsearchCllCdlCheckListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.24
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CLLCDLManifestDBDAOsearchCllCdlCheckListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCllCdlCheckList
	  * </pre>
	  */
	public CLLCDLManifestDBDAOsearchCllCdlCheckListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_cr_vslname",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_cr_yard",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_cr_indate_start",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_cr_indate_end",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_cr_edate_start",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_cr_edate_end",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_cr_callsign",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.integration").append("\n"); 
		query.append("FileName : CLLCDLManifestDBDAOsearchCllCdlCheckListRSQL").append("\n"); 
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
		query.append("#if (${in_list_type} == 'L' ) 	" ).append("\n"); 
		query.append("#if (${in_check_gubun} == '5' ) 	" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("	TML_MSG_MTCH_ID MTCH_FLG," ).append("\n"); 
		query.append("	TML_VVD_ID VVD_CD," ).append("\n"); 
		query.append("	CNTR_NO,	" ).append("\n"); 
		query.append("	CNTR_TPSZ_CD, 	" ).append("\n"); 
		query.append("	CNTR_SEAL_NO, " ).append("\n"); 
		query.append("	CNTR_SEAL_NO2," ).append("\n"); 
		query.append("	DECODE(CGO_STS_ID, '2','EXPORT', '3','IMPORT', '6','T/S', CGO_STS_ID) CGO_STS_ID,	" ).append("\n"); 
		query.append("	EVNT_YD_CD," ).append("\n"); 
		query.append("	POL_CD, " ).append("\n"); 
		query.append("	POD_CD," ).append("\n"); 
		query.append("	N1ST_POD_CD, 	" ).append("\n"); 
		query.append("	GRS_WGT," ).append("\n"); 
		query.append("	DECODE(CGO_TP_CD," ).append("\n"); 
		query.append("			'0','NORMAL', '1','REEFER', '2','RF/IMO', '3','IMO', '9','EMPTY'," ).append("\n"); 
		query.append("			CGO_TP_CD" ).append("\n"); 
		query.append("	) CGO_TP_CD," ).append("\n"); 
		query.append("	IMDG_CLSS_ID, " ).append("\n"); 
		query.append("	EUR_TML_DMG_ID,	" ).append("\n"); 
		query.append("	DECODE(TRSP_MOD_ID, 'T','TRUCK', 'R','RAIL', 'F','FEEDER', TRSP_MOD_ID) TRSP_MOD_ID," ).append("\n"); 
		query.append("	DECODE(EXP_DT," ).append("\n"); 
		query.append("			NULL,TO_CHAR(TO_DATE(CNTR_LDIS_DT,'YYYY-MM-DD HH24:MI:SS'),'YYYY-MM-DD HH24:MI')," ).append("\n"); 
		query.append("			TO_CHAR(EXP_DT,'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("	) CNTR_LDIS_DT,	" ).append("\n"); 
		query.append("	BKG_NO,	" ).append("\n"); 
		query.append("	CALL_SGN_NO, 	" ).append("\n"); 
		query.append("	VSL_NM, 	" ).append("\n"); 
		query.append("	TO_CHAR(EDI_RPT_MSG_RCV_DT,'YYYY-MM-DD HH24:MI') EDI_RPT_MSG_RCV_DT," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	ORG_YD_CD," ).append("\n"); 
		query.append("	EDI_SNDR_ID, " ).append("\n"); 
		query.append(" 	CO_RPT_ID, " ).append("\n"); 
		query.append("	CNTR_LDIS_DT CNTR_LDIS_DT2, " ).append("\n"); 
		query.append("	STWG_CELL_NO," ).append("\n"); 
		query.append("	TO_CHAR(UPD_DT,'YYYY-MM-DD HH24:MI') UPD_DT," ).append("\n"); 
		query.append("	'' TEMP1, " ).append("\n"); 
		query.append("	'' TEMP2," ).append("\n"); 
		query.append("	DECODE(CRR_CD, NULL,CO_RPT_ID, CRR_CD) CRR_CD, " ).append("\n"); 
		query.append("	CSTMS_DECL_NO, " ).append("\n"); 
		query.append("	CNTR_TARE_WGT" ).append("\n"); 
		query.append(" FROM	BKG_CSTMS_TML_EUR" ).append("\n"); 
		query.append(" WHERE	EVNT_YD_CD	LIKE @[in_cr_yard]||'%'" ).append("\n"); 
		query.append("#if (${in_cr_indate_start} != '' && ${in_cr_indate_end} != '' ) " ).append("\n"); 
		query.append(" AND	EDI_RPT_MSG_RCV_DT BETWEEN TO_DATE(REPLACE(@[in_cr_indate_start], '-', '')|| '000000','YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("					  AND TO_DATE(REPLACE(@[in_cr_indate_end], '-', '')|| '235959','YYYYMMDDHH24MISS')  " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${in_cr_edate_start} != '' && ${in_cr_edate_end} != '' ) " ).append("\n"); 
		query.append(" AND	DECODE(EXP_DT,NULL,CNTR_LDIS_DT,EXP_DT) BETWEEN TO_DATE(REPLACE(@[in_cr_edate_start], '-', '')|| '000000','YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("					  AND TO_DATE(REPLACE(@[in_cr_edate_end], '-', '')|| '235959','YYYYMMDDHH24MISS') " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append(" AND	TML_VVD_ID	LIKE @[in_vvd_cd]||'%'" ).append("\n"); 
		query.append(" AND	POL_CD	LIKE @[in_pol_cd]||'%'" ).append("\n"); 
		query.append(" AND	POD_CD	LIKE @[in_pod_cd]||'%'" ).append("\n"); 
		query.append(" AND	CNTR_NO	LIKE @[in_cntr_no]||'%'" ).append("\n"); 
		query.append(" AND	CALL_SGN_NO	LIKE @[in_cr_callsign]||'%'" ).append("\n"); 
		query.append(" AND	VSL_NM	LIKE @[in_cr_vslname]||'%'" ).append("\n"); 
		query.append(" AND	CNTR_LODG_DCHG_CD = 'L'" ).append("\n"); 
		query.append(" ORDER BY EDI_RPT_MSG_RCV_DT" ).append("\n"); 
		query.append("#elseif (${in_check_gubun} == '1' ) 	" ).append("\n"); 
		query.append("SELECT	" ).append("\n"); 
		query.append("	A.TML_VVD_ID VVD_CD, " ).append("\n"); 
		query.append("	A.POL_CD, " ).append("\n"); 
		query.append("	A.POD_CD, " ).append("\n"); 
		query.append("	A.CNTR_NO, " ).append("\n"); 
		query.append("	A.BKG_NO, " ).append("\n"); 
		query.append("	'M' MTCH_FLG" ).append("\n"); 
		query.append("FROM	BKG_CSTMS_TML_EUR A, BKG_BOOKING BK, BKG_CONTAINER BC, BKG_VVD BV" ).append("\n"); 
		query.append("WHERE	A.TML_VVD_ID	= @[in_vvd_cd]" ).append("\n"); 
		query.append("AND	A.POL_CD	= @[in_pol_cd]" ).append("\n"); 
		query.append("AND	BV.POL_CD	= A.POL_CD" ).append("\n"); 
		query.append("AND	BK.BKG_STS_CD	<> 'X'" ).append("\n"); 
		query.append("AND	BK.BKG_STS_CD	<> 'S'" ).append("\n"); 
		query.append("AND	BK.BKG_NO	= BC.BKG_NO" ).append("\n"); 
		query.append("AND	BK.BKG_NO	= BV.BKG_NO" ).append("\n"); 
		query.append("AND	BV.VSL_CD	= SUBSTR(A.TML_VVD_ID, 1, 4)" ).append("\n"); 
		query.append("AND	BV.SKD_VOY_NO	= SUBSTR(A.TML_VVD_ID, 5, 4)" ).append("\n"); 
		query.append("AND	BV.SKD_DIR_CD	= SUBSTR(A.TML_VVD_ID, 9, 1)" ).append("\n"); 
		query.append("AND	BC.CNTR_NO	= A.CNTR_NO" ).append("\n"); 
		query.append("#elseif (${in_check_gubun} == '2' ) 	" ).append("\n"); 
		query.append("SELECT	" ).append("\n"); 
		query.append("	BV.VSL_CD||BV.SKD_VOY_NO||BV.SKD_DIR_CD VVD_CD, " ).append("\n"); 
		query.append("	BV.POL_CD, " ).append("\n"); 
		query.append("	BV.POD_CD, " ).append("\n"); 
		query.append("	BC.CNTR_NO, " ).append("\n"); 
		query.append("	BK.BKG_NO, " ).append("\n"); 
		query.append("	'B' MTCH_FLG" ).append("\n"); 
		query.append("FROM BKG_BOOKING BK, BKG_CONTAINER BC, BKG_VVD BV, (" ).append("\n"); 
		query.append("		SELECT	BC.CNTR_NO x, 'B' y" ).append("\n"); 
		query.append("		FROM	BKG_BOOKING BK, BKG_CONTAINER BC, BKG_VVD BV" ).append("\n"); 
		query.append("		WHERE	BK.BKG_STS_CD	<> 'X'" ).append("\n"); 
		query.append("		AND	BK.BKG_STS_CD	<> 'S'" ).append("\n"); 
		query.append("		AND	BK.BKG_NO	= BC.BKG_NO" ).append("\n"); 
		query.append("		AND	BK.BKG_NO	= BV.BKG_NO" ).append("\n"); 
		query.append("		AND	BV.VSL_CD	= SUBSTR(@[in_vvd_cd], 1, 4)" ).append("\n"); 
		query.append("		AND	BV.SKD_VOY_NO	= SUBSTR(@[in_vvd_cd], 5, 4)" ).append("\n"); 
		query.append("		AND	BV.SKD_DIR_CD	= SUBSTR(@[in_vvd_cd], 9, 1)" ).append("\n"); 
		query.append("		AND	BV.POL_CD	= @[in_pol_cd]" ).append("\n"); 
		query.append("		MINUS " ).append("\n"); 
		query.append("		SELECT	CNTR_NO, 'B'" ).append("\n"); 
		query.append("		FROM	BKG_CSTMS_TML_EUR" ).append("\n"); 
		query.append("		WHERE	TML_VVD_ID	= @[in_vvd_cd]" ).append("\n"); 
		query.append("		AND	POL_CD		= @[in_pol_cd]" ).append("\n"); 
		query.append("		AND	CNTR_LODG_DCHG_CD = 'L'" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("WHERE	BK.BKG_STS_CD	<> 'X'" ).append("\n"); 
		query.append("AND     BK.BKG_STS_CD	<> 'S'" ).append("\n"); 
		query.append("AND     BK.BKG_NO	= BC.BKG_NO" ).append("\n"); 
		query.append("AND     BK.BKG_NO	= BV.BKG_NO" ).append("\n"); 
		query.append("AND     BV.VSL_CD	= SUBSTR(@[in_vvd_cd], 1, 4)" ).append("\n"); 
		query.append("AND     BV.SKD_VOY_NO	= SUBSTR(@[in_vvd_cd], 5, 4)" ).append("\n"); 
		query.append("AND     BV.SKD_DIR_CD	= SUBSTR(@[in_vvd_cd], 9, 1)" ).append("\n"); 
		query.append("AND     BV.POL_CD	= @[in_pol_cd]" ).append("\n"); 
		query.append("AND     BC.CNTR_NO	= x" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT	" ).append("\n"); 
		query.append("	A.TML_VVD_ID VVD_CD, " ).append("\n"); 
		query.append("	A.POL_CD, " ).append("\n"); 
		query.append("	A.POD_CD, " ).append("\n"); 
		query.append("	A.BKG_NO, " ).append("\n"); 
		query.append("	A.CNTR_NO, " ).append("\n"); 
		query.append("	'R' MTCH_FLG" ).append("\n"); 
		query.append("FROM	BKG_CSTMS_TML_EUR A, (" ).append("\n"); 
		query.append("			SELECT  CNTR_NO x, 'R'" ).append("\n"); 
		query.append("			FROM  BKG_CSTMS_TML_EUR" ).append("\n"); 
		query.append("			WHERE	TML_VVD_ID	= @[in_vvd_cd]" ).append("\n"); 
		query.append("			AND	POL_CD		= @[in_pol_cd]" ).append("\n"); 
		query.append("			AND	CNTR_LODG_DCHG_CD = 'L'" ).append("\n"); 
		query.append("			MINUS" ).append("\n"); 
		query.append("			SELECT BC.CNTR_NO, 'R'" ).append("\n"); 
		query.append("			FROM    BKG_BOOKING BK, BKG_CONTAINER BC, BKG_VVD BV" ).append("\n"); 
		query.append("			WHERE   BK.BKG_STS_CD	<> 'X'" ).append("\n"); 
		query.append("			AND     BK.BKG_STS_CD	<> 'S'" ).append("\n"); 
		query.append("			AND     BK.BKG_NO	= BC.BKG_NO" ).append("\n"); 
		query.append("			AND     BK.BKG_NO	= BV.BKG_NO" ).append("\n"); 
		query.append("			AND     BV.VSL_CD		= SUBSTR(@[in_vvd_cd], 1, 4)" ).append("\n"); 
		query.append("			AND     BV.SKD_VOY_NO	= SUBSTR(@[in_vvd_cd], 5, 4)" ).append("\n"); 
		query.append("			AND     BV.SKD_DIR_CD	= SUBSTR(@[in_vvd_cd], 9, 1)" ).append("\n"); 
		query.append("			AND     BV.POL_CD		= @[in_pol_cd]" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("WHERE	A.TML_VVD_ID	= @[in_vvd_cd]" ).append("\n"); 
		query.append("AND	A.POL_CD	= @[in_pol_cd]" ).append("\n"); 
		query.append("AND	A.CNTR_NO	= x " ).append("\n"); 
		query.append("AND	A.CNTR_LODG_DCHG_CD = 'L'" ).append("\n"); 
		query.append("#elseif (${in_check_gubun} == '3' ) " ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("	TML_MSG_MTCH_ID MTCH_FLG," ).append("\n"); 
		query.append("	TML_VVD_ID VVD_CD," ).append("\n"); 
		query.append("	CNTR_NO,	" ).append("\n"); 
		query.append("	CNTR_TPSZ_CD, 	" ).append("\n"); 
		query.append("	CNTR_SEAL_NO, " ).append("\n"); 
		query.append("	CNTR_SEAL_NO2," ).append("\n"); 
		query.append("	DECODE(CGO_STS_ID, '2','EXPORT', '3','IMPORT', '6','T/S', CGO_STS_ID) CGO_STS_ID,	" ).append("\n"); 
		query.append("	EVNT_YD_CD," ).append("\n"); 
		query.append("	POL_CD, " ).append("\n"); 
		query.append("	POD_CD," ).append("\n"); 
		query.append("	N1ST_POD_CD, " ).append("\n"); 
		query.append("	GRS_WGT," ).append("\n"); 
		query.append("	DECODE(CGO_TP_CD," ).append("\n"); 
		query.append("			'0','NORMAL', '1','REEFER', '2','RF/IMO', '3','IMO', '9','EMPTY'," ).append("\n"); 
		query.append("			CGO_TP_CD" ).append("\n"); 
		query.append("	) CGO_TP_CD," ).append("\n"); 
		query.append("	IMDG_CLSS_ID, " ).append("\n"); 
		query.append("	EUR_TML_DMG_ID,	" ).append("\n"); 
		query.append("	DECODE(TRSP_MOD_ID, 'T','TRUCK', 'R','RAIL', 'F','FEEDER', TRSP_MOD_ID) TRSP_MOD_ID," ).append("\n"); 
		query.append("	DECODE(EXP_DT," ).append("\n"); 
		query.append("			NULL,TO_CHAR(TO_DATE(CNTR_LDIS_DT,'YYYY-MM-DD HH24:MI:SS'),'YYYY-MM-DD HH24:MI:SS')," ).append("\n"); 
		query.append("			TO_CHAR(EXP_DT,'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("	) CNTR_LDIS_DT,	" ).append("\n"); 
		query.append("	BKG_NO,	" ).append("\n"); 
		query.append("	CALL_SGN_NO, 	" ).append("\n"); 
		query.append("	VSL_NM, 	" ).append("\n"); 
		query.append("	TO_CHAR(EDI_RPT_MSG_RCV_DT,'YYYY-MM-DD HH24:MI:SS') EDI_RPT_MSG_RCV_DT," ).append("\n"); 
		query.append("	ORG_YD_CD," ).append("\n"); 
		query.append("	EDI_SNDR_ID, " ).append("\n"); 
		query.append(" 	CO_RPT_ID, " ).append("\n"); 
		query.append("	CNTR_LDIS_DT CNTR_LDIS_DT2, " ).append("\n"); 
		query.append("	STWG_CELL_NO," ).append("\n"); 
		query.append("	TO_CHAR(UPD_DT,'YYYY-MM-DD HH24:MI:SS') UPD_DT," ).append("\n"); 
		query.append("	'' TEMP1, " ).append("\n"); 
		query.append("	'' TEMP2," ).append("\n"); 
		query.append("	DECODE(CRR_CD, NULL,CO_RPT_ID, CRR_CD) CRR_CD, " ).append("\n"); 
		query.append("	CSTMS_DECL_NO, " ).append("\n"); 
		query.append("	CNTR_TARE_WGT" ).append("\n"); 
		query.append(" FROM	BKG_CSTMS_TML_EUR" ).append("\n"); 
		query.append(" WHERE	EVNT_YD_CD	LIKE @[in_cr_yard]||'%'" ).append("\n"); 
		query.append("#if (${in_cr_indate_start} != '' && ${in_cr_indate_end} != '' ) " ).append("\n"); 
		query.append(" AND	EDI_RPT_MSG_RCV_DT BETWEEN TO_DATE(REPLACE(@[in_cr_indate_start], '-', '')|| '000000','YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("					  AND TO_DATE(REPLACE(@[in_cr_indate_end], '-', '')|| '235959','YYYYMMDDHH24MISS')  " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${in_cr_edate_start} != '' && ${in_cr_edate_end} != '' ) " ).append("\n"); 
		query.append(" AND	DECODE(EXP_DT,NULL,CNTR_LDIS_DT,EXP_DT) BETWEEN TO_DATE(REPLACE(@[in_cr_edate_start], '-', '')|| '000000','YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("					  AND TO_DATE(REPLACE(@[in_cr_edate_end], '-', '')|| '235959','YYYYMMDDHH24MISS') " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append(" AND	TML_VVD_ID	LIKE @[in_vvd_cd]||'%'" ).append("\n"); 
		query.append(" AND	POL_CD	LIKE @[in_pol_cd]||'%'" ).append("\n"); 
		query.append(" AND	POD_CD	LIKE @[in_pod_cd]||'%'" ).append("\n"); 
		query.append(" AND	CNTR_NO	LIKE @[in_cntr_no]||'%'" ).append("\n"); 
		query.append(" AND	CALL_SGN_NO	LIKE @[in_cr_callsign]||'%'" ).append("\n"); 
		query.append(" AND	VSL_NM	LIKE @[in_cr_vslname]||'%'" ).append("\n"); 
		query.append(" AND	TML_MSG_MTCH_ID	<>    'R'" ).append("\n"); 
		query.append(" AND	CNTR_LODG_DCHG_CD = 'L'" ).append("\n"); 
		query.append(" ORDER BY EDI_RPT_MSG_RCV_DT" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("	TML_MSG_MTCH_ID MTCH_FLG," ).append("\n"); 
		query.append("	TML_VVD_ID VVD_CD," ).append("\n"); 
		query.append("	POL_CD, " ).append("\n"); 
		query.append("	POD_CD,	" ).append("\n"); 
		query.append("	CNTR_NO," ).append("\n"); 
		query.append("	BKG_NO,	" ).append("\n"); 
		query.append("	CNTR_SEAL_NO, 	" ).append("\n"); 
		query.append("	CNTR_TPSZ_CD, " ).append("\n"); 
		query.append("	CNTR_SEAL_NO2," ).append("\n"); 
		query.append("	DECODE(CGO_STS_ID, '2','EXPORT', '3','IMPORT', '6','T/S', CGO_STS_ID) CGO_STS_ID,	" ).append("\n"); 
		query.append("	EVNT_YD_CD," ).append("\n"); 
		query.append("	N1ST_POD_CD, " ).append("\n"); 
		query.append("	GRS_WGT," ).append("\n"); 
		query.append("	DECODE(CGO_TP_CD," ).append("\n"); 
		query.append("			'0','NORMAL', '1','REEFER', '2','RF/IMO', '3','IMO', '9','EMPTY'," ).append("\n"); 
		query.append("			CGO_TP_CD" ).append("\n"); 
		query.append("	) CGO_TP_CD," ).append("\n"); 
		query.append("	IMDG_CLSS_ID, " ).append("\n"); 
		query.append("	EUR_TML_DMG_ID,	" ).append("\n"); 
		query.append("	DECODE(TRSP_MOD_ID, 'T','TRUCK', 'R','RAIL', 'F','FEEDER', TRSP_MOD_ID) TRSP_MOD_ID," ).append("\n"); 
		query.append("	DECODE(EXP_DT," ).append("\n"); 
		query.append("			NULL,TO_CHAR(TO_DATE(CNTR_LDIS_DT,'YYYY-MM-DD HH24:MI:SS'),'YYYY-MM-DD HH24:MI:SS')," ).append("\n"); 
		query.append("			TO_CHAR(EXP_DT,'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("	) CNTR_LDIS_DT,	" ).append("\n"); 
		query.append("	CALL_SGN_NO, 	" ).append("\n"); 
		query.append("	VSL_NM, 	" ).append("\n"); 
		query.append("	TO_CHAR(EDI_RPT_MSG_RCV_DT,'YYYY-MM-DD HH24:MI:SS') EDI_RPT_MSG_RCV_DT," ).append("\n"); 
		query.append("	ORG_YD_CD," ).append("\n"); 
		query.append("	EDI_SNDR_ID, " ).append("\n"); 
		query.append(" 	CO_RPT_ID, " ).append("\n"); 
		query.append("	TO_CHAR(CNTR_LDIS_DT,'YYYY-MM-DD HH24:MI:SS') CNTR_LDIS_DT2," ).append("\n"); 
		query.append("	STWG_CELL_NO," ).append("\n"); 
		query.append("	TO_CHAR(UPD_DT,'YYYY-MM-DD HH24:MI:SS') UPD_DT," ).append("\n"); 
		query.append("	'' TEMP1, " ).append("\n"); 
		query.append("	'' TEMP2," ).append("\n"); 
		query.append("	DECODE(CRR_CD, NULL,CO_RPT_ID, CRR_CD) CRR_CD, " ).append("\n"); 
		query.append("	CSTMS_DECL_NO, " ).append("\n"); 
		query.append("	TO_CHAR(CNTR_TARE_WGT,'9,999.999') CNTR_TARE_WGT" ).append("\n"); 
		query.append(" FROM	BKG_CSTMS_TML_EUR" ).append("\n"); 
		query.append(" WHERE	EVNT_YD_CD	LIKE @[in_cr_yard]||'%'" ).append("\n"); 
		query.append("#if (${in_cr_indate_start} != '' && ${in_cr_indate_end} != '' ) " ).append("\n"); 
		query.append(" AND	EDI_RPT_MSG_RCV_DT BETWEEN TO_DATE(REPLACE(@[in_cr_indate_start], '-', '')|| '000000','YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("					  AND TO_DATE(REPLACE(@[in_cr_indate_end], '-', '')|| '235959','YYYYMMDDHH24MISS')  " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${in_cr_edate_start} != '' && ${in_cr_edate_end} != '' ) " ).append("\n"); 
		query.append(" AND	DECODE(EXP_DT,NULL,CNTR_LDIS_DT,EXP_DT) BETWEEN TO_DATE(REPLACE(@[in_cr_edate_start], '-', '')|| '000000','YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("					  AND TO_DATE(REPLACE(@[in_cr_edate_end], '-', '')|| '235959','YYYYMMDDHH24MISS') " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append(" AND	TML_VVD_ID	LIKE @[in_vvd_cd]||'%'" ).append("\n"); 
		query.append(" AND	POL_CD	LIKE @[in_pol_cd]||'%'" ).append("\n"); 
		query.append(" AND	POD_CD	LIKE @[in_pod_cd]||'%'" ).append("\n"); 
		query.append(" AND	CNTR_NO	LIKE @[in_cntr_no]||'%'" ).append("\n"); 
		query.append(" AND	CALL_SGN_NO	LIKE @[in_cr_callsign]||'%'" ).append("\n"); 
		query.append(" AND	VSL_NM	LIKE @[in_cr_vslname]||'%'" ).append("\n"); 
		query.append(" AND	TML_MSG_MTCH_ID 	=    'R'" ).append("\n"); 
		query.append(" --ORDER BY EDI_RPT_MSG_RCV_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT	" ).append("\n"); 
		query.append("	DECODE(C.EDI_RCV_STS_CD,'W','I','I','I',C.EDI_RCV_STS_CD) MTCH_FLG," ).append("\n"); 
		query.append("	C.VSL_CD||C.SKD_VOY_NO||C.SKD_DIR_CD VVD_CD, " ).append("\n"); 
		query.append("	C.POL_CD, " ).append("\n"); 
		query.append("	C.POD_CD," ).append("\n"); 
		query.append("	C.CNTR_NO, " ).append("\n"); 
		query.append("	C.BKG_NO," ).append("\n"); 
		query.append("	C.CNTR_SEAL_NO, " ).append("\n"); 
		query.append("	C.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("	'',	" ).append("\n"); 
		query.append("	''," ).append("\n"); 
		query.append("	''," ).append("\n"); 
		query.append("	''," ).append("\n"); 
		query.append("	0," ).append("\n"); 
		query.append("	''," ).append("\n"); 
		query.append("	''," ).append("\n"); 
		query.append("	''," ).append("\n"); 
		query.append("	''," ).append("\n"); 
		query.append("	''," ).append("\n"); 
		query.append("	''," ).append("\n"); 
		query.append("	''," ).append("\n"); 
		query.append("	''," ).append("\n"); 
		query.append("	''," ).append("\n"); 
		query.append("	''," ).append("\n"); 
		query.append("	''," ).append("\n"); 
		query.append("	''," ).append("\n"); 
		query.append("	''," ).append("\n"); 
		query.append("	''," ).append("\n"); 
		query.append("	''," ).append("\n"); 
		query.append("	''," ).append("\n"); 
		query.append("	''," ).append("\n"); 
		query.append("	''," ).append("\n"); 
		query.append("	''" ).append("\n"); 
		query.append(" FROM	BKG_CSTMS_TML_CLL C" ).append("\n"); 
		query.append(" WHERE	VSL_CD		= SUBSTR(@[in_vvd_cd], 1, 4)" ).append("\n"); 
		query.append(" AND	SKD_VOY_NO	= SUBSTR(@[in_vvd_cd], 5, 4)" ).append("\n"); 
		query.append(" AND	SKD_DIR_CD	= SUBSTR(@[in_vvd_cd], 9, 1)" ).append("\n"); 
		query.append(" AND	PORT_CD			= @[in_pol_cd]" ).append("\n"); 
		query.append(" AND	C.EDI_RCV_STS_CD	= 'W'" ).append("\n"); 
		query.append(" --ORDER BY C.CNTR_NO, C.BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("	TML_MSG_MTCH_ID MTCH_FLG," ).append("\n"); 
		query.append("	TML_VVD_ID VVD_CD," ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	CNTR_NO,	" ).append("\n"); 
		query.append("	CNTR_TPSZ_CD, 	" ).append("\n"); 
		query.append("	CNTR_SEAL_NO, " ).append("\n"); 
		query.append("	CNTR_SEAL_NO2," ).append("\n"); 
		query.append("	DECODE(CGO_STS_ID, '2','EXPORT', '3','IMPORT', '6','T/S', CGO_STS_ID) CGO_STS_ID,	" ).append("\n"); 
		query.append("	EVNT_YD_CD," ).append("\n"); 
		query.append("	POL_CD, " ).append("\n"); 
		query.append("	POD_CD," ).append("\n"); 
		query.append("	N1ST_POD_CD, 	" ).append("\n"); 
		query.append("	GRS_WGT," ).append("\n"); 
		query.append("	DECODE(CGO_TP_CD," ).append("\n"); 
		query.append("			'0','NORMAL', '1','REEFER', '2','RF/IMO', '3','IMO', '9','EMPTY'," ).append("\n"); 
		query.append("			CGO_TP_CD" ).append("\n"); 
		query.append("	) CGO_TP_CD," ).append("\n"); 
		query.append("	IMDG_CLSS_ID, " ).append("\n"); 
		query.append("	EUR_TML_DMG_ID,	" ).append("\n"); 
		query.append("	DECODE(TRSP_MOD_ID, 'T','TRUCK', 'R','RAIL', 'F','FEEDER', TRSP_MOD_ID) TRSP_MOD_ID," ).append("\n"); 
		query.append("	DECODE(EXP_DT," ).append("\n"); 
		query.append("			NULL,TO_CHAR(TO_DATE(CNTR_LDIS_DT,'YYYY-MM-DD HH24:MI:SS'),'YYYY-MM-DD HH24:MI:SS')," ).append("\n"); 
		query.append("			TO_CHAR(EXP_DT,'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("	) CNTR_LDIS_DT,		" ).append("\n"); 
		query.append("	BKG_NO,	" ).append("\n"); 
		query.append("	CALL_SGN_NO, 	" ).append("\n"); 
		query.append("	VSL_NM, 	" ).append("\n"); 
		query.append("	TO_CHAR(EDI_RPT_MSG_RCV_DT,'YYYY-MM-DD HH24:MI:SS') EDI_RPT_MSG_RCV_DT," ).append("\n"); 
		query.append("	ORG_YD_CD," ).append("\n"); 
		query.append("	EDI_SNDR_ID, " ).append("\n"); 
		query.append(" 	CO_RPT_ID, " ).append("\n"); 
		query.append("	CNTR_LDIS_DT CNTR_LDIS_DT2, " ).append("\n"); 
		query.append("	STWG_CELL_NO," ).append("\n"); 
		query.append("	TO_CHAR(UPD_DT,'YYYY-MM-DD HH24:MI:SS') UPD_DT," ).append("\n"); 
		query.append("	'' TEMP1, " ).append("\n"); 
		query.append("	'' TEMP2," ).append("\n"); 
		query.append("	DECODE(CRR_CD, NULL,CO_RPT_ID, CRR_CD) CRR_CD, " ).append("\n"); 
		query.append("	CSTMS_DECL_NO, " ).append("\n"); 
		query.append("	CNTR_TARE_WGT" ).append("\n"); 
		query.append(" FROM	BKG_CSTMS_TML_EUR " ).append("\n"); 
		query.append(" WHERE	EVNT_YD_CD	LIKE @[in_cr_yard]||'%'" ).append("\n"); 
		query.append("#if (${in_cr_indate_start} != '' && ${in_cr_indate_end} != '' ) " ).append("\n"); 
		query.append(" AND	EDI_RPT_MSG_RCV_DT BETWEEN TO_DATE(REPLACE(@[in_cr_indate_start], '-', '')|| '000000','YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("					  AND TO_DATE(REPLACE(@[in_cr_indate_end], '-', '')|| '235959','YYYYMMDDHH24MISS')  " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${in_cr_edate_start} != '' && ${in_cr_edate_end} != '' ) " ).append("\n"); 
		query.append(" AND	DECODE(EXP_DT,NULL,CNTR_LDIS_DT,EXP_DT) BETWEEN TO_DATE(REPLACE(@[in_cr_edate_start], '-', '')|| '000000','YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("					  AND TO_DATE(REPLACE(@[in_cr_edate_end], '-', '')|| '235959','YYYYMMDDHH24MISS') " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append(" AND	TML_VVD_ID	LIKE @[in_vvd_cd]||'%'" ).append("\n"); 
		query.append(" AND	POL_CD	LIKE @[in_pol_cd]||'%'" ).append("\n"); 
		query.append(" AND	POD_CD	LIKE @[in_pod_cd]||'%'" ).append("\n"); 
		query.append(" AND	CNTR_NO	LIKE @[in_cntr_no]||'%'" ).append("\n"); 
		query.append(" AND	CALL_SGN_NO	LIKE @[in_cr_callsign]||'%'" ).append("\n"); 
		query.append(" AND	VSL_NM	LIKE @[in_cr_vslname]||'%'" ).append("\n"); 
		query.append(" AND	CNTR_LODG_DCHG_CD = 'D'" ).append("\n"); 
		query.append(" ORDER BY EDI_RPT_MSG_RCV_DT" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}