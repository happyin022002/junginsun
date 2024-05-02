/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : KoreaCustomsReportDBDAOsearchTransHistBySndDtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.15
*@LastModifier : 
*@LastVersion : 1.0
* 2011.11.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.korea.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KoreaCustomsReportDBDAOsearchTransHistBySndDtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Send Date를 이용하여 Transmit History를 조회한다.
	  * </pre>
	  */
	public KoreaCustomsReportDBDAOsearchTransHistBySndDtRSQL(){
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
		params.put("in_snd_dt_s",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_snd_dt_e",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("in_msg_type",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.korea.integration").append("\n"); 
		query.append("FileName : KoreaCustomsReportDBDAOsearchTransHistBySndDtRSQL").append("\n"); 
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
		query.append("SELECT /*+ ORDERED */distinct" ).append("\n"); 
		query.append("DECODE(SLOG.MSG_LOG_TP_ID,'5ID',DECODE(vvd.DCHG_RPT_SND_DT,null,'Un-Send','Send'),'6TA',DECODE(SLOG.SND_DT,null,'Un-Send','Send'),'6TC',DECODE(SLOG.SND_DT,null,'Un-Send','Send'),decode(vvd.MF_SND_DT,null,'Un-Send','Send')) IF_SENDED" ).append("\n"); 
		query.append(", MSG_LOG_TP_ID  A_MSG_LOG_TP_ID" ).append("\n"); 
		query.append(", TRIM(MF_RCVR_USR_ID) A_MF_RCVR_USR_ID" ).append("\n"); 
		query.append(", ' ' A_RECEIVER" ).append("\n"); 
		query.append(", CORR_CD1 A_CORR_CD1" ).append("\n"); 
		query.append(", DECODE(SLOG.MSG_LOG_TP_ID,'5ID',DECODE(vvd.DCHG_RPT_SND_DT,null,' ',TO_CHAR(SLOG.SND_DT,'YYYYMMDD')),'6TA',TO_CHAR(SLOG.SND_DT,'YYYYMMDD'),'6TC',TO_CHAR(SLOG.SND_DT,'YYYYMMDD'),DECODE(vvd.MF_SND_DT,null,' ',TO_CHAR(SLOG.SND_DT, 'YYYYMMDD'))) A_SND_DT_DD" ).append("\n"); 
		query.append(", DECODE(SLOG.MSG_LOG_TP_ID,'5ID',DECODE(vvd.DCHG_RPT_SND_DT,null,' ',TO_CHAR(SLOG.SND_DT,'hh24:mi:ss')),'6TA',TO_CHAR(SLOG.SND_DT,'hh24:mi:ss'),'6TC',TO_CHAR(SLOG.SND_DT,'hh24:mi:ss'),DECODE(vvd.MF_SND_DT,null,' ',TO_CHAR(SLOG.SND_DT, 'hh24:mi:ss'))) A_SND_DT_TT" ).append("\n"); 
		query.append(", VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD A_VVD_CD" ).append("\n"); 
		query.append(", POL_CD A_POL_CD" ).append("\n"); 
		query.append(", POD_CD A_POD_CD" ).append("\n"); 
		query.append(", OFC_CD A_OFC_CD" ).append("\n"); 
		query.append(", BL_NO A_BL_NO" ).append("\n"); 
		query.append(", SMT_AMD_NO A_SUBMIT_NO" ).append("\n"); 
		query.append(", BL_KNT A_BL_KNT" ).append("\n"); 
		query.append(", TTL_FEU_KNT A_FLD_40FT" ).append("\n"); 
		query.append(", TTL_TEU_KNT A_FLD_20FT" ).append("\n"); 
		query.append(", TRSM_USR_ID A_TRSM_USR_ID" ).append("\n"); 
		query.append(", DECODE(KR_CSTMS_DECL_CD,'N',' ',KR_CSTMS_DECL_CD) A_KS_TYPE" ).append("\n"); 
		query.append(", ' ' A_C_TP" ).append("\n"); 
		query.append(", ' ' A_E_SVC_SEND_DATE" ).append("\n"); 
		query.append(", SLOG.MF_SND_SEQ MF_SND_SEQ" ).append("\n"); 
		query.append(", (SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD02959' AND INTG_CD_VAL_CTNT = SLOG.TRSM_CXL_TP_CD) TRSM_CXL_TP_CD" ).append("\n"); 
		query.append(", (SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD02960' AND INTG_CD_VAL_CTNT = SLOG.TRSM_CXL_RSN_CD) TRSM_CXL_RSN_CD" ).append("\n"); 
		query.append(", SLOG.TRSM_CXL_DESC" ).append("\n"); 
		query.append("FROM BKG_CSTMS_KR_VVD_SMRY VVD, BKG_CSTMS_KR_SND_LOG SLOG" ).append("\n"); 
		query.append("WHERE VVD.VSL_CD(+) = SLOG.VSL_CD" ).append("\n"); 
		query.append("AND VVD.SKD_VOY_NO(+) = SLOG.SKD_VOY_NO" ).append("\n"); 
		query.append("AND VVD.SKD_DIR_CD(+) = SLOG.SKD_DIR_CD" ).append("\n"); 
		query.append("AND MSG_LOG_TP_ID = NVL(@[in_msg_type],MSG_LOG_TP_ID)" ).append("\n"); 
		query.append("AND SLOG.SND_DT >= TO_DATE(@[in_snd_dt_s]||'000000', 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("AND SLOG.SND_DT <= TO_DATE(@[in_snd_dt_e]||'235959', 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("AND NVL(KR_CSTMS_DECL_CD,' ') Like @[in_ks_type]||'%'" ).append("\n"); 
		query.append("AND NVL(POL_CD,' ') Like @[in_pol_cd]||'%'" ).append("\n"); 
		query.append("AND NVL(POD_CD,' ') Like @[in_pod_cd]||'%'" ).append("\n"); 
		query.append("AND NVL(OFC_CD,' ') Like @[in_ofc_cd]||'%'" ).append("\n"); 
		query.append("AND NVL(TRSM_USR_ID,' ') Like @[in_usr_id]||'%'" ).append("\n"); 
		query.append("ORDER BY A_SND_DT_DD, A_SND_DT_TT" ).append("\n"); 

	}
}