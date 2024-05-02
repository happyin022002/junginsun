/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : RepairMgtDBDAOsearchIFEstimateHRDDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.08
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.08 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RepairMgtDBDAOsearchIFEstimateHRDDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchIFEstimateHRDData
	  * </pre>
	  */
	public RepairMgtDBDAOsearchIFEstimateHRDDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpr_rqst_lst_ver_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpr_rqst_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_eq_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpr_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cur_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.integration").append("\n"); 
		query.append("FileName : RepairMgtDBDAOsearchIFEstimateHRDDataRSQL").append("\n"); 
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
		query.append("         A.RQST_EQ_NO" ).append("\n"); 
		query.append("        ,A.RPR_RQST_SEQ" ).append("\n"); 
		query.append("        ,A.RPR_RQST_VER_NO" ).append("\n"); 
		query.append("        ,A.RPR_RQST_LST_VER_FLG" ).append("\n"); 
		query.append("        ,A.EQ_KND_CD" ).append("\n"); 
		query.append("        ,A.EQ_TPSZ_CD" ).append("\n"); 
		query.append("        ,MNR_COMMON_PKG.MNR_CONV_PARTNER_CD_FNC(A.VNDR_SEQ) AS VNDR_SEQ" ).append("\n"); 
		query.append("        ,A.RPR_STS_CD" ).append("\n"); 
		query.append("        ,A.RPR_DTL_STS_CD" ).append("\n"); 
		query.append("        ,A.RQST_REF_NO" ).append("\n"); 
		query.append("        ,A.MNR_INP_TP_CD" ).append("\n"); 
		query.append("        ,A.COST_OFC_CD" ).append("\n"); 
		query.append("        ,TO_CHAR(A.RQST_DT, 'YYYY-MM-DD') AS RQST_DT" ).append("\n"); 
		query.append("        ,A.RQST_USR_ID" ).append("\n"); 
		query.append("		,NVL(MNR_COMMON_PKG.MNR_GET_USR_NM_FNC(A.RQST_USR_ID),A.RQST_USR_ID) AS RQST_USR_NM" ).append("\n"); 
		query.append("        ,A.MNR_MEAS_UT_CD" ).append("\n"); 
		query.append("        ,A.APRO_OFC_CD" ).append("\n"); 
		query.append("        ,TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(MNR_COMMON_PKG.MNR_GET_HOOFC_FNC(),A.APRO_DT,@[cur_ofc_cd]),'YYYY-MM-DD') AS APRO_DT" ).append("\n"); 
		query.append("        ,A.APRO_USR_ID" ).append("\n"); 
		query.append("        ,A.RPR_OFFH_FLG" ).append("\n"); 
		query.append("        ,TO_CHAR(A.RPR_RSLT_DT,'YYYY-MM-DD') AS RPR_RSLT_DT" ).append("\n"); 
		query.append("        ,A.CURR_CD" ).append("\n"); 
		query.append("        ,A.RPR_YD_CD" ).append("\n"); 
		query.append("        ,TO_CHAR(A.EQ_DMG_DT,'YYYY-MM-DD') AS EQ_DMG_DT" ).append("\n"); 
		query.append("        ,A.EQ_DMG_TP_CD" ).append("\n"); 
		query.append("        ,A.RPR_WRK_TP_CD" ).append("\n"); 
		query.append("        ,A.MNR_EDI_NM" ).append("\n"); 
		query.append("        ,A.N3PTY_FLG" ).append("\n"); 
		query.append("        ,A.IF_TRC_SEQ" ).append("\n"); 
		query.append("        ,A.MNR_AGMT_AMT" ).append("\n"); 
		query.append("        ,A.MNR_WRK_AMT" ).append("\n"); 
		query.append("        ,A.N3PTY_BIL_TTL_AMT" ).append("\n"); 
		query.append("        ,A.DISP_FLG" ).append("\n"); 
		query.append("        ,A.DISP_NO" ).append("\n"); 
		query.append("        ,A.DISP_DTL_SEQ" ).append("\n"); 
		query.append("        ,A.FILE_SEQ" ).append("\n"); 
		query.append("        ,A.MNR_RPR_RMK" ).append("\n"); 
		query.append("        ,A.EDI_ID" ).append("\n"); 
		query.append("        ,A.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("        ,A.MNR_ORD_SEQ" ).append("\n"); 
		query.append("        ,A.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("        ,A.AGMT_SEQ" ).append("\n"); 
		query.append("        ,A.AGMT_VER_NO" ).append("\n"); 
		query.append("        ,A.RPR_RQST_TMP_SEQ" ).append("\n"); 
		query.append("        ,A.CRE_USR_ID" ).append("\n"); 
		query.append("        ,TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(MNR_COMMON_PKG.MNR_GET_HOOFC_FNC(),A.CRE_DT,@[cur_ofc_cd]),'YYYY-MM-DD') AS CRE_DT" ).append("\n"); 
		query.append("        ,A.UPD_USR_ID" ).append("\n"); 
		query.append("        ,TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(MNR_COMMON_PKG.MNR_GET_HOOFC_FNC(),A.UPD_DT,@[cur_ofc_cd]),'YYYY-MM-DD') AS UPD_DT" ).append("\n"); 
		query.append("   , DECODE(EQ.MVMT_CD," ).append("\n"); 
		query.append("    'MT',EQ.MVMT_DT," ).append("\n"); 
		query.append("    'IC',EQ.MVMT_DT," ).append("\n"); 
		query.append("    'OC',EQ.MVMT_DT," ).append("\n"); 
		query.append("    (SELECT /*+ INDEX_DESC(CTM_MOVEMENT XPKCTM_MOVEMENT) */ TO_CHAR(CNMV_EVNT_DT,'YYYY-MM-DD')" ).append("\n"); 
		query.append("      FROM CTM_MOVEMENT" ).append("\n"); 
		query.append("     WHERE CNTR_NO = @[rqst_eq_no]" ).append("\n"); 
		query.append("       AND CNMV_YR IN (TO_CHAR(SYSDATE, 'YYYY'), TO_CHAR(SYSDATE, 'YYYY') - 1)" ).append("\n"); 
		query.append("       AND CNMV_ID_NO > 0 " ).append("\n"); 
		query.append("       AND MVMT_STS_CD IN ('MT', 'IC', 'OC')" ).append("\n"); 
		query.append("       AND ROWNUM = 1)" ).append("\n"); 
		query.append("   )  MVMT_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM MNR_RPR_RQST_HDR A,MNR_EQ_STS_V EQ" ).append("\n"); 
		query.append("WHERE A.RQST_EQ_NO = EQ.EQ_NO" ).append("\n"); 
		query.append("AND   A.RQST_EQ_NO = @[rqst_eq_no]" ).append("\n"); 
		query.append("AND   A.RPR_RQST_SEQ = @[rpr_rqst_seq]" ).append("\n"); 
		query.append("AND   A.RPR_RQST_VER_NO = @[rpr_rqst_ver_no]" ).append("\n"); 
		query.append("AND   A.RPR_RQST_LST_VER_FLG = @[rpr_rqst_lst_ver_flg]" ).append("\n"); 

	}
}