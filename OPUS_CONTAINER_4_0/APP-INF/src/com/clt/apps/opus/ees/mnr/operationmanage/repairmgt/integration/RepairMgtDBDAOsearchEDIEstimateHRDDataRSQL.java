/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RepairMgtDBDAOsearchEDIEstimateHRDDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.15
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2009.12.15 박명신
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author park myoung sin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RepairMgtDBDAOsearchEDIEstimateHRDDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchEDIEstimateHRDData
	  * </pre>
	  */
	public RepairMgtDBDAOsearchEDIEstimateHRDDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.integration ").append("\n"); 
		query.append("FileName : RepairMgtDBDAOsearchEDIEstimateHRDDataRSQL").append("\n"); 
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
		query.append("A.RQST_EQ_NO" ).append("\n"); 
		query.append(",A.RPR_RQST_TMP_SEQ AS RPR_RQST_SEQ" ).append("\n"); 
		query.append(",A.RPR_RQST_TMP_VER_NO AS RPR_RQST_VER_NO" ).append("\n"); 
		query.append(",A.RPR_RQST_LST_VER_FLG" ).append("\n"); 
		query.append(",A.EQ_KND_CD" ).append("\n"); 
		query.append(",A.EQ_TPSZ_CD" ).append("\n"); 
		query.append(",A.VNDR_SEQ" ).append("\n"); 
		query.append(",A.RPR_STS_CD" ).append("\n"); 
		query.append(",A.RPR_DTL_STS_CD" ).append("\n"); 
		query.append(",A.RQST_REF_NO" ).append("\n"); 
		query.append(",A.MNR_INP_TP_CD" ).append("\n"); 
		query.append(",A.COST_OFC_CD" ).append("\n"); 
		query.append(",TO_CHAR(A.RQST_DT, 'yyyy-mm-dd') RQST_DT" ).append("\n"); 
		query.append(",A.RQST_USR_ID" ).append("\n"); 
		query.append(",MNR_COMMON_PKG.MNR_GET_USR_NM_FNC(A.RQST_USR_ID) AS RQST_USR_NM" ).append("\n"); 
		query.append(",A.MNR_MEAS_UT_CD" ).append("\n"); 
		query.append(",A.APRO_OFC_CD" ).append("\n"); 
		query.append(",TO_CHAR(A.APRO_DT, 'yyyy-mm-dd') APRO_DT" ).append("\n"); 
		query.append(",A.APRO_USR_ID" ).append("\n"); 
		query.append(",A.RPR_OFFH_FLG" ).append("\n"); 
		query.append(",TO_CHAR(A.RPR_RSLT_DT, 'yyyy-mm-dd') RPR_RSLT_DT" ).append("\n"); 
		query.append(",A.CURR_CD" ).append("\n"); 
		query.append(",A.RPR_YD_CD" ).append("\n"); 
		query.append(",TO_CHAR(A.EQ_DMG_DT, 'yyyy-mm-dd') EQ_DMG_DT" ).append("\n"); 
		query.append(",A.EQ_DMG_TP_CD" ).append("\n"); 
		query.append(",A.RPR_WRK_TP_CD" ).append("\n"); 
		query.append(",A.MNR_EDI_NM" ).append("\n"); 
		query.append(",TO_CHAR(A.MNR_ORD_ISS_DT, 'yyyy-mm-dd') MNR_ORD_ISS_DT" ).append("\n"); 
		query.append(",TO_CHAR(A.MNR_ORD_SND_DT, 'yyyy-mm-dd') MNR_ORD_SND_DT" ).append("\n"); 
		query.append(",A.N3PTY_FLG" ).append("\n"); 
		query.append(",A.INV_OFC_CD" ).append("\n"); 
		query.append(",A.INV_NO" ).append("\n"); 
		query.append(",A.IF_TRC_SEQ" ).append("\n"); 
		query.append(",A.MNR_LBR_AMT AS MNR_AGMT_AMT" ).append("\n"); 
		query.append(",(A.MNR_LBR_AMT + A.MNR_MTRL_AMT) AS MNR_WRK_AMT" ).append("\n"); 
		query.append(",A.INV_AMT" ).append("\n"); 
		query.append(",A.MNR_TTL_AMT AS N3PTY_BIL_TTL_AMT" ).append("\n"); 
		query.append(",A.DISP_FLG" ).append("\n"); 
		query.append(",A.DISP_NO" ).append("\n"); 
		query.append(",A.DISP_DTL_SEQ" ).append("\n"); 
		query.append(",A.FILE_SEQ" ).append("\n"); 
		query.append(",A.MNR_RPR_RMK" ).append("\n"); 
		query.append(",A.EDI_ID" ).append("\n"); 
		query.append(",A.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append(",A.MNR_ORD_SEQ" ).append("\n"); 
		query.append(",A.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append(",A.AGMT_SEQ" ).append("\n"); 
		query.append(",A.AGMT_VER_NO" ).append("\n"); 
		query.append(",A.RPR_RQST_TMP_SEQ" ).append("\n"); 
		query.append(",A.CRE_USR_ID" ).append("\n"); 
		query.append(",TO_CHAR(A.CRE_DT, 'yyyy-mm-dd') CRE_DT" ).append("\n"); 
		query.append(",A.UPD_USR_ID" ).append("\n"); 
		query.append(",TO_CHAR(A.UPD_DT, 'yyyy-mm-dd') UPD_DT" ).append("\n"); 
		query.append("FROM MNR_RPR_RQST_TMP_HDR A" ).append("\n"); 
		query.append("WHERE A.RQST_EQ_NO = @[rqst_eq_no]" ).append("\n"); 
		query.append("AND   A.RPR_RQST_TMP_SEQ = @[rpr_rqst_seq]" ).append("\n"); 
		query.append("AND   A.RPR_RQST_TMP_VER_NO = @[rpr_rqst_ver_no]" ).append("\n"); 

	}
}