/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RepairMgtDBDAOaddEstimateHDRDataFromTmpDataCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.10
*@LastModifier : 이석준
*@LastVersion : 1.0
* 2010.08.10 이석준
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Joon(Suk-Joon) LEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RepairMgtDBDAOaddEstimateHDRDataFromTmpDataCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * addEstimateHDRDataFromTmpData
	  * </pre>
	  */
	public RepairMgtDBDAOaddEstimateHDRDataFromTmpDataCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("new_rpr_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("new_rpr_rqst_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("new_rqst_eq_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpr_rqst_tmp_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpr_rqst_tmp_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.integration").append("\n"); 
		query.append("FileName : RepairMgtDBDAOaddEstimateHDRDataFromTmpDataCSQL").append("\n"); 
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
		query.append("INSERT INTO MNR_RPR_RQST_HDR(" ).append("\n"); 
		query.append("         RQST_EQ_NO" ).append("\n"); 
		query.append("        ,RPR_RQST_SEQ" ).append("\n"); 
		query.append("        ,RPR_RQST_VER_NO" ).append("\n"); 
		query.append("        ,RPR_RQST_LST_VER_FLG" ).append("\n"); 
		query.append("        ,EQ_KND_CD" ).append("\n"); 
		query.append("        ,EQ_TPSZ_CD" ).append("\n"); 
		query.append("        ,VNDR_SEQ" ).append("\n"); 
		query.append("        ,RPR_STS_CD" ).append("\n"); 
		query.append("        ,RPR_DTL_STS_CD" ).append("\n"); 
		query.append("        ,RQST_REF_NO" ).append("\n"); 
		query.append("        ,MNR_INP_TP_CD" ).append("\n"); 
		query.append("        ,COST_OFC_CD" ).append("\n"); 
		query.append("        ,RQST_DT" ).append("\n"); 
		query.append("        ,RQST_USR_ID" ).append("\n"); 
		query.append("        ,MNR_MEAS_UT_CD" ).append("\n"); 
		query.append("        ,APRO_OFC_CD" ).append("\n"); 
		query.append("        ,APRO_DT" ).append("\n"); 
		query.append("        ,APRO_USR_ID" ).append("\n"); 
		query.append("        ,RPR_OFFH_FLG" ).append("\n"); 
		query.append("        ,RPR_RSLT_DT" ).append("\n"); 
		query.append("        ,CURR_CD" ).append("\n"); 
		query.append("        ,RPR_YD_CD" ).append("\n"); 
		query.append("        ,EQ_DMG_DT" ).append("\n"); 
		query.append("        ,EQ_DMG_TP_CD" ).append("\n"); 
		query.append("        ,RPR_WRK_TP_CD" ).append("\n"); 
		query.append("        ,MNR_EDI_NM" ).append("\n"); 
		query.append("        ,N3PTY_FLG" ).append("\n"); 
		query.append("        ,IF_TRC_SEQ" ).append("\n"); 
		query.append("        ,MNR_AGMT_AMT" ).append("\n"); 
		query.append("        ,MNR_WRK_AMT" ).append("\n"); 
		query.append("        ,N3PTY_BIL_TTL_AMT" ).append("\n"); 
		query.append("        ,DISP_FLG" ).append("\n"); 
		query.append("        ,DISP_NO" ).append("\n"); 
		query.append("        ,DISP_DTL_SEQ" ).append("\n"); 
		query.append("        ,FILE_SEQ" ).append("\n"); 
		query.append("        ,MNR_RPR_RMK" ).append("\n"); 
		query.append("        ,EDI_ID" ).append("\n"); 
		query.append("        ,MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("        ,MNR_ORD_SEQ" ).append("\n"); 
		query.append("        ,AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("        ,AGMT_SEQ" ).append("\n"); 
		query.append("        ,AGMT_VER_NO" ).append("\n"); 
		query.append("        ,RPR_RQST_TMP_SEQ" ).append("\n"); 
		query.append("        ,RPR_RQST_TMP_VER_NO" ).append("\n"); 
		query.append("		,MNR_WARR_FLG" ).append("\n"); 
		query.append("        ,CRE_USR_ID" ).append("\n"); 
		query.append("        ,CRE_DT" ).append("\n"); 
		query.append("        ,UPD_USR_ID" ).append("\n"); 
		query.append("        ,UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("         @[new_rqst_eq_no]" ).append("\n"); 
		query.append("        ,@[new_rpr_rqst_seq]" ).append("\n"); 
		query.append("        ,@[new_rpr_rqst_ver_no]" ).append("\n"); 
		query.append("        ,A.RPR_RQST_LST_VER_FLG" ).append("\n"); 
		query.append("        ,B.EQ_TYPE" ).append("\n"); 
		query.append("        ,B.EQ_TPSZ_CD" ).append("\n"); 
		query.append("        ,A.VNDR_SEQ" ).append("\n"); 
		query.append("        ,A.RPR_STS_CD" ).append("\n"); 
		query.append("        ,A.RPR_DTL_STS_CD" ).append("\n"); 
		query.append("        ,A.RQST_REF_NO" ).append("\n"); 
		query.append("        ,A.MNR_INP_TP_CD" ).append("\n"); 
		query.append("        ,A.COST_OFC_CD" ).append("\n"); 
		query.append("        ,A.RQST_DT" ).append("\n"); 
		query.append("        ,A.RQST_USR_ID" ).append("\n"); 
		query.append("        ,A.MNR_MEAS_UT_CD" ).append("\n"); 
		query.append("        ,A.APRO_OFC_CD" ).append("\n"); 
		query.append("        ,A.APRO_DT" ).append("\n"); 
		query.append("        ,A.APRO_USR_ID" ).append("\n"); 
		query.append("        ,A.RPR_OFFH_FLG" ).append("\n"); 
		query.append("        ,A.RPR_RSLT_DT" ).append("\n"); 
		query.append("        ,A.CURR_CD" ).append("\n"); 
		query.append("        ,A.RPR_YD_CD" ).append("\n"); 
		query.append("        ,A.EQ_DMG_DT" ).append("\n"); 
		query.append("        ,A.EQ_DMG_TP_CD" ).append("\n"); 
		query.append("        ,A.RPR_WRK_TP_CD" ).append("\n"); 
		query.append("        ,A.MNR_EDI_NM" ).append("\n"); 
		query.append("        ,A.N3PTY_FLG" ).append("\n"); 
		query.append("        ,A.IF_TRC_SEQ" ).append("\n"); 
		query.append("        ,A.MNR_LBR_AMT" ).append("\n"); 
		query.append("        ,A.MNR_TTL_AMT" ).append("\n"); 
		query.append("        ,''" ).append("\n"); 
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
		query.append("        ,A.RPR_RQST_TMP_VER_NO" ).append("\n"); 
		query.append("		,DECODE(" ).append("\n"); 
		query.append("		(SELECT COUNT(*)" ).append("\n"); 
		query.append("			FROM MNR_EQ_RNG_STS A" ).append("\n"); 
		query.append("			WHERE " ).append("\n"); 
		query.append("  			A.MNR_GRP_TP_CD = 'RPR'" ).append("\n"); 
		query.append("  			AND SUBSTRB(@[rqst_eq_no],1,4) = A.LOT_EQ_PFX_CD " ).append("\n"); 
		query.append("  			AND A.FM_SER_NO <= SUBSTRB(@[rqst_eq_no],5,LENGTH(@[rqst_eq_no]) -1)" ).append("\n"); 
		query.append("  			AND A.TO_SER_NO >= SUBSTRB(@[rqst_eq_no],5,LENGTH(@[rqst_eq_no]) -1)" ).append("\n"); 
		query.append("  			AND SYSDATE BETWEEN A.FM_WARR_DT AND A.TO_WARR_DT + 0.99999" ).append("\n"); 
		query.append("  			AND ROWNUM = 1),1,'Y','N')" ).append("\n"); 
		query.append("        ,A.CRE_USR_ID" ).append("\n"); 
		query.append("        ,A.CRE_DT" ).append("\n"); 
		query.append("        ,A.UPD_USR_ID" ).append("\n"); 
		query.append("        ,A.UPD_DT" ).append("\n"); 
		query.append(" FROM MNR_RPR_RQST_TMP_HDR A,MNR_EQ_STS_V B" ).append("\n"); 
		query.append("WHERE A.RQST_EQ_NO = @[rqst_eq_no]" ).append("\n"); 
		query.append("  AND A.RPR_RQST_TMP_SEQ = @[rpr_rqst_tmp_seq]" ).append("\n"); 
		query.append("  AND A.RPR_RQST_TMP_VER_NO = @[rpr_rqst_tmp_ver_no]" ).append("\n"); 
		query.append("  AND A.RQST_EQ_NO = B.EQ_NO" ).append("\n"); 

	}
}