/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OwnDangerousCargoApprovalDBDAOScgRfCgoVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.27
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2009.11.27 이도형
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dohyoung Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OwnDangerousCargoApprovalDBDAOScgRfCgoVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SCG_RF_CGO의 내용을 조회합니다.
	  * </pre>
	  */
	public OwnDangerousCargoApprovalDBDAOScgRfCgoVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_cgo_apro_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.integration").append("\n"); 
		query.append("FileName : OwnDangerousCargoApprovalDBDAOScgRfCgoVORSQL").append("\n"); 
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
		query.append("CNTR_VOL_QTY" ).append("\n"); 
		query.append(",	BKG_NO" ).append("\n"); 
		query.append(",	SPCL_CGO_APRO_RQST_SEQ" ).append("\n"); 
		query.append(",	RC_SEQ" ).append("\n"); 
		query.append(",	CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",	CNTR_NO" ).append("\n"); 
		query.append(",	PCK_TP_CD" ).append("\n"); 
		query.append(",	PCK_QTY" ).append("\n"); 
		query.append(",	NET_WGT" ).append("\n"); 
		query.append(",	GRS_WGT" ).append("\n"); 
		query.append(",	WGT_UT_CD" ).append("\n"); 
		query.append(",	CMDT_CD" ).append("\n"); 
		query.append(",	CMDT_DESC" ).append("\n"); 
		query.append(",	FDO_TEMP" ).append("\n"); 
		query.append(",	CDO_TEMP" ).append("\n"); 
		query.append(",	CNTR_VENT_TP_CD" ).append("\n"); 
		query.append(",	VENT_RTO" ).append("\n"); 
		query.append(",	HUMID_NO" ).append("\n"); 
		query.append(",	DIFF_RMK" ).append("\n"); 
		query.append(",	RF_DCGO_SEQ" ).append("\n"); 
		query.append(",	PWR_SPL_CBL_FLG" ).append("\n"); 
		query.append(",	VLTG_NO" ).append("\n"); 
		query.append(",	CTRL_ATMS_FLG" ).append("\n"); 
		query.append(",	MODI_ATMS_FLG" ).append("\n"); 
		query.append(",	HUMID_CTRL_FLG" ).append("\n"); 
		query.append(",	CNTR_DRN_CD" ).append("\n"); 
		query.append(",	CLNG_TP_CD" ).append("\n"); 
		query.append(",	RQST_DT" ).append("\n"); 
		query.append(",	RQST_USR_ID" ).append("\n"); 
		query.append(",	SPCL_CGO_APRO_CD" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(",	CBM_PER_HR_QTY" ).append("\n"); 
		query.append("FROM SCG_RF_CGO" ).append("\n"); 
		query.append("WHERE	BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#if (${spcl_cgo_apro_rqst_seq} != '')" ).append("\n"); 
		query.append("AND	SPCL_CGO_APRO_RQST_SEQ = @[spcl_cgo_apro_rqst_seq]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND	SPCL_CGO_APRO_RQST_SEQ = (	SELECT MAX(SPCL_CGO_APRO_RQST_SEQ) FROM SCG_APRO_RQST WHERE SPCL_CGO_CATE_CD = 'RF' AND BKG_NO = @[bkg_no]	)" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}