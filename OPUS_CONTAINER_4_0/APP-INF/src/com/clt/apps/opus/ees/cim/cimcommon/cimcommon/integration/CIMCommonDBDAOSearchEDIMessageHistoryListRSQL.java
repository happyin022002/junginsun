/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CIMCommonDBDAOSearchEDIMessageHistoryListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.13
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.13 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cim.cimcommon.cimcommon.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CIMCommonDBDAOSearchEDIMessageHistoryListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EDI Message History List
	  * </pre>
	  */
	public CIMCommonDBDAOSearchEDIMessageHistoryListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("p_cntrno",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cim.cimcommon.cimcommon.integration ").append("\n"); 
		query.append("FileName : CIMCommonDBDAOSearchEDIMessageHistoryListRSQL").append("\n"); 
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
		query.append("SELECT BKG_NO," ).append("\n"); 
		query.append("	BL_NO," ).append("\n"); 
		query.append("	CALL_SGN_LLOYD," ).append("\n"); 
		query.append("	CALL_SGN_NO," ).append("\n"); 
		query.append("	LLOYD_NO," ).append("\n"); 
		query.append("	CHSS_NO," ).append("\n"); 
		query.append("	CNTR_FULL_STS_CD," ).append("\n"); 
		query.append("	CNTR_NO," ).append("\n"); 
		query.append("	CNTR_SEAL_NO," ).append("\n"); 
		query.append("	CNTR_TPSZ_CD," ).append("\n"); 
		query.append("	CRE_LOCL_DT," ).append("\n"); 
		query.append("	VVD_CD," ).append("\n"); 
		query.append("	CRNT_VSL_CD, " ).append("\n"); 
		query.append("	CRNT_SKD_VOY_NO," ).append("\n"); 
		query.append("	CRNT_SKD_DIR_CD," ).append("\n"); 
		query.append("	DEST_YD_CD," ).append("\n"); 
		query.append("	POL_CD," ).append("\n"); 
		query.append("	POD_CD," ).append("\n"); 
		query.append("	EDI_BKG_NO," ).append("\n"); 
		query.append("	EDI_GATE_IO_CD," ).append("\n"); 
		query.append("	EDI_MVMT_STS_CD," ).append("\n"); 
		query.append("	EVNT_DT," ).append("\n"); 
		query.append("	EVNT_YD_CD," ).append("\n"); 
		query.append("	MVMT_EDI_MSG_AREA_CD," ).append("\n"); 
		query.append("	MVMT_EDI_MSG_SEQ," ).append("\n"); 
		query.append("	MVMT_EDI_MSG_TP_ID," ).append("\n"); 
		query.append("	MVMT_EDI_MSG_YRMONDY," ).append("\n"); 
		query.append("	MVMT_EDI_TP_CD," ).append("\n"); 
		query.append("	MVMT_EDI_RMK," ).append("\n"); 
		query.append("	CNMV_RMK," ).append("\n"); 
		query.append("	MVMT_EDI_RSLT_CD," ).append("\n"); 
		query.append("	MVMT_EDI_SGHT_CD," ).append("\n"); 
		query.append("	MVMT_TRSP_MOD_CD," ).append("\n"); 
		query.append("	RTY_KNT," ).append("\n"); 
		query.append("	VNDR_SEQ," ).append("\n"); 
		query.append("	MGST_NO," ).append("\n"); 
		query.append("	WBL_NO," ).append("\n"); 
		query.append("	PKUP_NO," ).append("\n"); 
		query.append("	LCC_CD," ).append("\n"); 
		query.append("	WO_NO," ).append("\n"); 
		query.append("	EDI_VVD_CD," ).append("\n"); 
		query.append("	TIR_NO," ).append("\n"); 
		query.append("	MTY_PLN_NO," ).append("\n"); 
		query.append("	MTY_REPO_NO," ).append("\n"); 
		query.append("	EDI_CRR_NO," ).append("\n"); 
		query.append("	TRSP_DOC_NO," ).append("\n"); 
		query.append("	FLT_FILE_REF_NO" ).append("\n"); 
		query.append("	FROM (" ).append("\n"); 
		query.append("		SELECT ROW_NUMBER() OVER (ORDER BY EVNT_DT) AS ROWNO," ).append("\n"); 
		query.append("			BKG_NO," ).append("\n"); 
		query.append("			BL_NO," ).append("\n"); 
		query.append("			CALL_SGN_LLOYD," ).append("\n"); 
		query.append("			CALL_SGN_NO," ).append("\n"); 
		query.append("			LLOYD_NO," ).append("\n"); 
		query.append("			CHSS_NO," ).append("\n"); 
		query.append("			CNTR_FULL_STS_CD," ).append("\n"); 
		query.append("			CNTR_NO," ).append("\n"); 
		query.append("			CNTR_SEAL_NO," ).append("\n"); 
		query.append("			CNTR_TPSZ_CD," ).append("\n"); 
		query.append("			CRE_LOCL_DT," ).append("\n"); 
		query.append("			VVD_CD," ).append("\n"); 
		query.append("			CRNT_VSL_CD," ).append("\n"); 
		query.append("			CRNT_SKD_VOY_NO," ).append("\n"); 
		query.append("			CRNT_SKD_DIR_CD," ).append("\n"); 
		query.append("			DEST_YD_CD," ).append("\n"); 
		query.append("			POL_CD," ).append("\n"); 
		query.append("			POD_CD," ).append("\n"); 
		query.append("			EDI_BKG_NO," ).append("\n"); 
		query.append("			EDI_GATE_IO_CD," ).append("\n"); 
		query.append("			EDI_MVMT_STS_CD," ).append("\n"); 
		query.append("			EVNT_DT," ).append("\n"); 
		query.append("			EVNT_YD_CD," ).append("\n"); 
		query.append("			MVMT_EDI_MSG_AREA_CD," ).append("\n"); 
		query.append("			MVMT_EDI_MSG_SEQ," ).append("\n"); 
		query.append("			MVMT_EDI_MSG_TP_ID," ).append("\n"); 
		query.append("			MVMT_EDI_MSG_YRMONDY," ).append("\n"); 
		query.append("			MVMT_EDI_TP_CD," ).append("\n"); 
		query.append("			MVMT_EDI_RMK," ).append("\n"); 
		query.append("			CNMV_RMK," ).append("\n"); 
		query.append("			MVMT_EDI_SGHT_CD," ).append("\n"); 
		query.append("			MVMT_TRSP_MOD_CD," ).append("\n"); 
		query.append("			MVMT_EDI_RSLT_CD," ).append("\n"); 
		query.append("			RTY_KNT," ).append("\n"); 
		query.append("			VNDR_SEQ," ).append("\n"); 
		query.append("			MGST_NO," ).append("\n"); 
		query.append("			WBL_NO," ).append("\n"); 
		query.append("			PKUP_NO," ).append("\n"); 
		query.append("			LCC_CD," ).append("\n"); 
		query.append("			WO_NO," ).append("\n"); 
		query.append("			EDI_VVD_CD," ).append("\n"); 
		query.append("			TIR_NO," ).append("\n"); 
		query.append("			MTY_PLN_NO," ).append("\n"); 
		query.append("			MTY_REPO_NO," ).append("\n"); 
		query.append("			EDI_CRR_NO," ).append("\n"); 
		query.append("			TRSP_DOC_NO," ).append("\n"); 
		query.append("			FLT_FILE_REF_NO" ).append("\n"); 
		query.append("		FROM (" ).append("\n"); 
		query.append("			SELECT /*+ USE_NL(D B A) */" ).append("\n"); 
		query.append("				D.BKG_NO," ).append("\n"); 
		query.append("				D.EDI_BL_NO AS BL_NO," ).append("\n"); 
		query.append("				NVL(D.CALL_SGN_NO, D.LLOYD_NO) AS CALL_SGN_LLOYD," ).append("\n"); 
		query.append("				D.CALL_SGN_NO AS CALL_SGN_NO," ).append("\n"); 
		query.append("				D.LLOYD_NO AS LLOYD_NO," ).append("\n"); 
		query.append("				D.CHSS_NO," ).append("\n"); 
		query.append("				D.CNTR_FULL_STS_CD," ).append("\n"); 
		query.append("				D.CNTR_NO," ).append("\n"); 
		query.append("				D.CNTR_SEAL_NO," ).append("\n"); 
		query.append("				D.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("				TO_CHAR(D.CRE_LOCL_DT, 'YYYYMMDDHH24MI') AS CRE_LOCL_DT," ).append("\n"); 
		query.append("				D.CRNT_VSL_CD||D.CRNT_SKD_VOY_NO||D.CRNT_SKD_DIR_CD AS VVD_CD," ).append("\n"); 
		query.append("				D.CRNT_VSL_CD," ).append("\n"); 
		query.append("				D.CRNT_SKD_VOY_NO," ).append("\n"); 
		query.append("				D.CRNT_SKD_DIR_CD," ).append("\n"); 
		query.append("				D.DEST_YD_CD," ).append("\n"); 
		query.append("				D.BKG_POL_CD AS POL_CD," ).append("\n"); 
		query.append("				D.BKG_POD_CD AS POD_CD," ).append("\n"); 
		query.append("				D.EDI_BKG_NO," ).append("\n"); 
		query.append("				D.EDI_GATE_IO_CD," ).append("\n"); 
		query.append("				D.EDI_MVMT_STS_CD," ).append("\n"); 
		query.append("				TO_CHAR(D.EVNT_DT, 'YYYYMMDDHH24MI') AS EVNT_DT," ).append("\n"); 
		query.append("				D.EVNT_YD_CD," ).append("\n"); 
		query.append("				D.MVMT_EDI_MSG_AREA_CD," ).append("\n"); 
		query.append("				D.MVMT_EDI_MSG_SEQ," ).append("\n"); 
		query.append("				D.MVMT_EDI_MSG_TP_ID," ).append("\n"); 
		query.append("				D.MVMT_EDI_MSG_YRMONDY," ).append("\n"); 
		query.append("				D.MVMT_EDI_TP_CD," ).append("\n"); 
		query.append("				D.MVMT_EDI_RMK," ).append("\n"); 
		query.append("				D.CNMV_RMK," ).append("\n"); 
		query.append("				D.MVMT_EDI_SGHT_CD," ).append("\n"); 
		query.append("				D.MVMT_TRSP_MOD_CD," ).append("\n"); 
		query.append("				D.MVMT_EDI_RSLT_CD," ).append("\n"); 
		query.append("				D.RTY_KNT," ).append("\n"); 
		query.append("				D.VNDR_SEQ," ).append("\n"); 
		query.append("				D.MGST_NO," ).append("\n"); 
		query.append("				D.WBL_NO," ).append("\n"); 
		query.append("				D.PKUP_NO," ).append("\n"); 
		query.append("				A.LCC_CD," ).append("\n"); 
		query.append("				D.WO_NO," ).append("\n"); 
		query.append("				D.EDI_VVD_CD," ).append("\n"); 
		query.append("				D.TIR_NO," ).append("\n"); 
		query.append("				D.MTY_PLN_NO," ).append("\n"); 
		query.append("				D.MTY_REPO_NO," ).append("\n"); 
		query.append("				D.EDI_CRR_NO," ).append("\n"); 
		query.append("				D.TRSP_DOC_NO," ).append("\n"); 
		query.append("				D.FLT_FILE_REF_NO" ).append("\n"); 
		query.append("			FROM " ).append("\n"); 
		query.append("				CTM_MVMT_EDI_MSG D, " ).append("\n"); 
		query.append("				MDM_LOCATION B, " ).append("\n"); 
		query.append("				MDM_EQ_ORZ_CHT A, " ).append("\n"); 
		query.append("				COM_SYS_AREA_GRP_ID G, " ).append("\n"); 
		query.append("				MDM_YARD M" ).append("\n"); 
		query.append("			WHERE 1 = 1" ).append("\n"); 
		query.append("			AND   D.EVNT_YD_CD          = M.YD_CD(+)" ).append("\n"); 
		query.append("			AND   SUBSTR(M.YD_CD, 1, 2) = G.CNT_CD(+)" ).append("\n"); 
		query.append("			AND D.CNTR_NO = @[p_cntrno]||@[check_digit]             " ).append("\n"); 
		query.append("			AND A.SCC_CD(+) = B.SCC_CD" ).append("\n"); 
		query.append("			AND B.LOC_CD(+) = SUBSTR(D.EVNT_YD_CD, 0, 5)" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("ORDER BY ROWNO" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}