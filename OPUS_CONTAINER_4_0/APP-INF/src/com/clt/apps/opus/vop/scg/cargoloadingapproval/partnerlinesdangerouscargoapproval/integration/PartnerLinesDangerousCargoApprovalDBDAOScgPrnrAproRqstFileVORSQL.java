/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PartnerLinesDangerousCargoApprovalDBDAOScgPrnrAproRqstFileVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.29
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.29 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PartnerLinesDangerousCargoApprovalDBDAOScgPrnrAproRqstFileVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Dangerous CGO Application Details for Partner Lines 의 File 조회
	  * </pre>
	  */
	public PartnerLinesDangerousCargoApprovalDBDAOScgPrnrAproRqstFileVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prnr_cgo_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_cgo_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.integration").append("\n"); 
		query.append("FileName : PartnerLinesDangerousCargoApprovalDBDAOScgPrnrAproRqstFileVORSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("	CRR_CD" ).append("\n"); 
		query.append(",	BKG_REF_NO" ).append("\n"); 
		query.append(",	SPCL_CGO_RQST_SEQ" ).append("\n"); 
		query.append(",	SPCL_CGO_RQST_ATCH_FILE_SEQ" ).append("\n"); 
		query.append(",	FILE_NM" ).append("\n"); 
		query.append(",	FILE_SAV_ID" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	TO_CHAR(CRE_DT,'YYYY-MM-DD') CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	TO_CHAR(UPD_DT,'YYYY-MM-DD') UPD_DT" ).append("\n"); 
		query.append(",   '' FILE_SET_YN" ).append("\n"); 
		query.append(",   PRNR_CGO_RQST_SEQ" ).append("\n"); 
		query.append("FROM 	SCG_PRNR_APRO_RQST_FILE" ).append("\n"); 
		query.append("WHERE	CRR_CD 					= COM_ConstantMgr_PKG.COM_getCompanyCode_FNC()" ).append("\n"); 
		query.append("AND		BKG_REF_NO 				= @[bkg_ref_no]" ).append("\n"); 
		query.append("AND		SPCL_CGO_RQST_SEQ 		= @[spcl_cgo_rqst_seq]" ).append("\n"); 
		query.append("AND		PRNR_CGO_RQST_SEQ		= @[prnr_cgo_rqst_seq]" ).append("\n"); 
		query.append(" " ).append("\n"); 

	}
}