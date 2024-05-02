/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : OwnDangerousCargoApprovalDBDAOScgAwkCgoVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.09
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2010.03.09 이도형
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dohyoung Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OwnDangerousCargoApprovalDBDAOScgAwkCgoVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BKG_AWK_CGO 에서 SCG_AWK_CGO으로 DATA 복제
	  * </pre>
	  */
	public OwnDangerousCargoApprovalDBDAOScgAwkCgoVOCSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.integration").append("\n"); 
		query.append("FileName : OwnDangerousCargoApprovalDBDAOScgAwkCgoVOCSQL").append("\n"); 
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
		query.append("INSERT INTO SCG_AWK_CGO (" ).append("\n"); 
		query.append("	BKG_NO" ).append("\n"); 
		query.append(",	SPCL_CGO_APRO_RQST_SEQ" ).append("\n"); 
		query.append(",	AWK_CGO_SEQ" ).append("\n"); 
		query.append(",	RCV_TERM_CD" ).append("\n"); 
		query.append(",	DE_TERM_CD" ).append("\n"); 
		query.append(",	CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",	CNTR_NO" ).append("\n"); 
		query.append(",	PCK_TP_CD" ).append("\n"); 
		query.append(",	PCK_QTY" ).append("\n"); 
		query.append(",	GRS_WGT" ).append("\n"); 
		query.append(",	NET_WGT" ).append("\n"); 
		query.append(",	WGT_UT_CD" ).append("\n"); 
		query.append(",	OVR_FWRD_LEN" ).append("\n"); 
		query.append(",	OVR_BKWD_LEN" ).append("\n"); 
		query.append(",	OVR_HGT" ).append("\n"); 
		query.append(",	OVR_LF_LEN" ).append("\n"); 
		query.append(",	OVR_RT_LEN" ).append("\n"); 
		query.append(",	OVR_VOID_SLT_QTY" ).append("\n"); 
		query.append(",	TTL_DIM_LEN" ).append("\n"); 
		query.append(",	TTL_DIM_WDT" ).append("\n"); 
		query.append(",	TTL_DIM_HGT" ).append("\n"); 
		query.append(",	AWK_DCGO_SEQ" ).append("\n"); 
		query.append(",	CMDT_CD" ).append("\n"); 
		query.append(",	IN_GA_FLG" ).append("\n"); 
		query.append(",	CRN_PST_STS_CD" ).append("\n"); 
		query.append(",	XTD_OVR_QTY" ).append("\n"); 
		query.append(",	PST_LCK_PIN_FLG" ).append("\n"); 
		query.append(",	STWG_RQST_DESC" ).append("\n"); 
		query.append(",	DIFF_RMK" ).append("\n"); 
		query.append(",	RQST_DT" ).append("\n"); 
		query.append(",	RQST_GDT" ).append("\n"); 
		query.append(",	RQST_USR_ID" ).append("\n"); 
		query.append(",	SPCL_CGO_APRO_CD" ).append("\n"); 
		query.append(",	CNTR_VOL_QTY" ).append("\n"); 
		query.append(",	GRAV_CTR_DESC" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("	BKG_NO" ).append("\n"); 
		query.append("#if (${spcl_cgo_apro_rqst_seq} != '') " ).append("\n"); 
		query.append(",	@[spcl_cgo_apro_rqst_seq]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",	(	SELECT MAX(SPCL_CGO_APRO_RQST_SEQ) FROM SCG_APRO_RQST WHERE BKG_NO = @[bkg_no] AND SPCL_CGO_CATE_CD = 'AK'	)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",	AWK_CGO_SEQ" ).append("\n"); 
		query.append(",	RCV_TERM_CD" ).append("\n"); 
		query.append(",	DE_TERM_CD" ).append("\n"); 
		query.append(",	CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",	CNTR_NO" ).append("\n"); 
		query.append(",	PCK_TP_CD" ).append("\n"); 
		query.append(",	PCK_QTY" ).append("\n"); 
		query.append(",	GRS_WGT" ).append("\n"); 
		query.append(",	NET_WGT" ).append("\n"); 
		query.append(",	WGT_UT_CD" ).append("\n"); 
		query.append(",	OVR_FWRD_LEN" ).append("\n"); 
		query.append(",	OVR_BKWD_LEN" ).append("\n"); 
		query.append(",	OVR_HGT" ).append("\n"); 
		query.append(",	OVR_LF_LEN" ).append("\n"); 
		query.append(",	OVR_RT_LEN" ).append("\n"); 
		query.append(",	OVR_VOID_SLT_QTY" ).append("\n"); 
		query.append(",	TTL_DIM_LEN" ).append("\n"); 
		query.append(",	TTL_DIM_WDT" ).append("\n"); 
		query.append(",	TTL_DIM_HGT" ).append("\n"); 
		query.append(",	AWK_DCGO_SEQ" ).append("\n"); 
		query.append(",	CMDT_CD" ).append("\n"); 
		query.append(",	IN_GA_FLG" ).append("\n"); 
		query.append(",	CRN_PST_STS_CD" ).append("\n"); 
		query.append(",	XTD_OVR_QTY" ).append("\n"); 
		query.append(",	PST_LCK_PIN_FLG" ).append("\n"); 
		query.append(",	STWG_RQST_DESC" ).append("\n"); 
		query.append(",	DIFF_RMK" ).append("\n"); 
		query.append(",	RQST_DT" ).append("\n"); 
		query.append(",	RQST_GDT" ).append("\n"); 
		query.append(",	RQST_USR_ID" ).append("\n"); 
		query.append(",	SPCL_CGO_APRO_CD" ).append("\n"); 
		query.append(",	CNTR_VOL_QTY" ).append("\n"); 
		query.append(",	GRAV_CTR_DESC" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append("FROM BKG_AWK_CGO" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#if (${spcl_cgo_apro_rqst_seq} != '' || ${cgo_seq} == '') " ).append("\n"); 
		query.append("AND SPCL_CGO_APRO_CD not in ('C','D')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cgo_seq} != '') " ).append("\n"); 
		query.append("AND AWK_CGO_SEQ = @[cgo_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}