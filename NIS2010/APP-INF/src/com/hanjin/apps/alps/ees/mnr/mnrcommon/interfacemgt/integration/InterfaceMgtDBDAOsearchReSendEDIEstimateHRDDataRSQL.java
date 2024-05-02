/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InterfaceMgtDBDAOsearchReSendEDIEstimateHRDDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.07
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2010.04.07 박명신
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author park myoung sin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InterfaceMgtDBDAOsearchReSendEDIEstimateHRDDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchReSendEDIEstimateHRDData
	  * </pre>
	  */
	public InterfaceMgtDBDAOsearchReSendEDIEstimateHRDDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.integration ").append("\n"); 
		query.append("FileName : InterfaceMgtDBDAOsearchReSendEDIEstimateHRDDataRSQL").append("\n"); 
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
		query.append("RQST_EQ_NO" ).append("\n"); 
		query.append(",RPR_RQST_TMP_SEQ" ).append("\n"); 
		query.append(",RPR_RQST_TMP_VER_NO" ).append("\n"); 
		query.append(",RPR_RQST_LST_VER_FLG" ).append("\n"); 
		query.append(",EQ_KND_CD" ).append("\n"); 
		query.append(",EQ_TPSZ_CD" ).append("\n"); 
		query.append(",VNDR_SEQ" ).append("\n"); 
		query.append(",RPR_STS_CD" ).append("\n"); 
		query.append(",RPR_DTL_STS_CD" ).append("\n"); 
		query.append(",RQST_REF_NO" ).append("\n"); 
		query.append(",MNR_INP_TP_CD" ).append("\n"); 
		query.append(",COST_OFC_CD" ).append("\n"); 
		query.append(",RQST_DT" ).append("\n"); 
		query.append(",RQST_USR_ID" ).append("\n"); 
		query.append(",MNR_MEAS_UT_CD" ).append("\n"); 
		query.append(",APRO_OFC_CD" ).append("\n"); 
		query.append(",APRO_DT" ).append("\n"); 
		query.append(",APRO_USR_ID" ).append("\n"); 
		query.append(",RPR_OFFH_FLG" ).append("\n"); 
		query.append(",RPR_RSLT_DT" ).append("\n"); 
		query.append(",CURR_CD" ).append("\n"); 
		query.append(",RPR_YD_CD" ).append("\n"); 
		query.append(",EQ_DMG_DT" ).append("\n"); 
		query.append(",EQ_DMG_TP_CD" ).append("\n"); 
		query.append(",RPR_WRK_TP_CD" ).append("\n"); 
		query.append(",MNR_EDI_NM" ).append("\n"); 
		query.append(",MNR_ORD_ISS_DT" ).append("\n"); 
		query.append(",MNR_ORD_SND_DT" ).append("\n"); 
		query.append(",N3PTY_FLG" ).append("\n"); 
		query.append(",INV_OFC_CD" ).append("\n"); 
		query.append(",INV_NO" ).append("\n"); 
		query.append(",IF_TRC_SEQ" ).append("\n"); 
		query.append(",MNR_LBR_AMT" ).append("\n"); 
		query.append(",MNR_MTRL_AMT" ).append("\n"); 
		query.append(",INV_AMT" ).append("\n"); 
		query.append(",MNR_TTL_AMT" ).append("\n"); 
		query.append(",DISP_FLG" ).append("\n"); 
		query.append(",DISP_NO" ).append("\n"); 
		query.append(",DISP_DTL_SEQ" ).append("\n"); 
		query.append(",FILE_SEQ" ).append("\n"); 
		query.append(",MNR_RPR_RMK" ).append("\n"); 
		query.append(",EDI_ID" ).append("\n"); 
		query.append(",MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append(",MNR_ORD_SEQ" ).append("\n"); 
		query.append(",AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append(",AGMT_SEQ" ).append("\n"); 
		query.append(",AGMT_VER_NO" ).append("\n"); 
		query.append(",EDI_ERR_CD" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",TO_CHAR(CRE_DT, 'yyyy-mm-dd') CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",TO_CHAR(UPD_DT, 'yyyy-mm-dd') UPD_DT" ).append("\n"); 
		query.append("FROM MNR_RPR_RQST_TMP_HDR" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("EDI_ERR_CD = 'XX'" ).append("\n"); 

	}
}