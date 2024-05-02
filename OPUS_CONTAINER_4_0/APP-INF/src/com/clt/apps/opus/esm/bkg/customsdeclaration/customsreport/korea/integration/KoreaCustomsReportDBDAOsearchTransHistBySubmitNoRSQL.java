/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : KoreaCustomsReportDBDAOsearchTransHistBySubmitNoRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.24
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2010.05.24 박상훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SANGHUN PARK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KoreaCustomsReportDBDAOsearchTransHistBySubmitNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * 전송기록 조회
	  * </pre>
	  */
	public KoreaCustomsReportDBDAOsearchTransHistBySubmitNoRSQL(){
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
		params.put("in_sub_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_ks_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.integration").append("\n");
		query.append("FileName : KoreaCustomsReportDBDAOsearchTransHistBySubmitNoRSQL").append("\n");
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
		query.append("SELECT MSG_LOG_TP_ID A_MSG_LOG_TP_ID" ).append("\n");
		query.append(", MF_RCVR_USR_ID A_MF_RCVR_USR_ID" ).append("\n");
		query.append(", ' ' A_RECEIVER" ).append("\n");
		query.append(", CORR_CD1 A_CORR_CD1" ).append("\n");
		query.append(", TO_CHAR(SND_DT, 'YYYYMMDD') A_SND_DT_DD" ).append("\n");
		query.append(", TO_CHAR(SND_DT, 'HH24:MI:SS') A_SND_DT_TT" ).append("\n");
		query.append(", VSL_CD||SKD_VOY_NO||SKD_DIR_CD A_VVD_CD" ).append("\n");
		query.append(", POL_CD A_POL_CD" ).append("\n");
		query.append(", POD_CD A_POD_CD" ).append("\n");
		query.append(", OFC_CD A_OFC_CD" ).append("\n");
		query.append(", BL_NO A_BL_NO" ).append("\n");
		query.append(", SMT_AMD_NO A_SUBMIT_NO" ).append("\n");
		query.append(", BL_KNT A_BL_KNT" ).append("\n");
		query.append(", ' ' A_FLD_40_FT" ).append("\n");
		query.append(", ' ' A_FLD_20_FT" ).append("\n");
		query.append(", TRSM_USR_ID A_TRSM_USR_ID" ).append("\n");
		query.append(", DECODE(KR_CSTMS_DECL_CD,'N',' ',KR_CSTMS_DECL_CD) A_KS_TYPE" ).append("\n");
		query.append(", ' ' A_C_TP" ).append("\n");
		query.append(", ' ' A_E_SVC_SEND_DATE" ).append("\n");
		query.append(", MF_SND_SEQ MF_SND_SEQ" ).append("\n");
		query.append("FROM BKG_CSTMS_KR_SND_LOG" ).append("\n");
		query.append("WHERE MF_SND_SEQ = @[in_sub_no]" ).append("\n");
		query.append("AND NVL(KR_CSTMS_DECL_CD,' ') Like @[in_ks_type]||'%'" ).append("\n");
		query.append("AND NVL(POL_CD,' ') Like @[in_pol_cd]||'%'" ).append("\n");
		query.append("AND NVL(POD_CD,' ') Like @[in_pod_cd]||'%'" ).append("\n");
		query.append("AND NVL(OFC_CD,' ') Like @[in_ofc_cd]||'%'" ).append("\n");
		query.append("AND NVL(TRSM_USR_ID,' ') Like @[in_usr_id]||'%'" ).append("\n");

	}
}