/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PartnerLinesDangerousCargoApprovalDBDAOScgPrnrAproDcgoRefNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.13
*@LastModifier : 
*@LastVersion : 1.0
* 2016.12.13 
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

public class PartnerLinesDangerousCargoApprovalDBDAOScgPrnrAproDcgoRefNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DG Ref No의 중복체크
	  * </pre>
	  */
	public PartnerLinesDangerousCargoApprovalDBDAOScgPrnrAproDcgoRefNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dcgo_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.integration").append("\n"); 
		query.append("FileName : PartnerLinesDangerousCargoApprovalDBDAOScgPrnrAproDcgoRefNoRSQL").append("\n"); 
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
		query.append("SELECT COUNT(1)" ).append("\n"); 
		query.append("FROM SCG_PRNR_APRO_RQST_CGO CGO, SCG_PRNR_APRO_RQST RQS" ).append("\n"); 
		query.append("WHERE CGO.CRR_CD = RQS.CRR_CD " ).append("\n"); 
		query.append("AND CGO.BKG_REF_NO = RQS.BKG_REF_NO" ).append("\n"); 
		query.append("AND CGO.SPCL_CGO_RQST_SEQ = RQS.SPCL_CGO_RQST_SEQ" ).append("\n"); 
		query.append("AND CGO.PRNR_CGO_RQST_SEQ = RQS.PRNR_CGO_RQST_SEQ" ).append("\n"); 
		query.append("--SR 22631 " ).append("\n"); 
		query.append("--2016-12-13 DG Ref No 유효성 체크 단위 VVD로 변경" ).append("\n"); 
		query.append("AND CGO.DCGO_REF_NO = @[dcgo_ref_no] " ).append("\n"); 
		query.append("AND RQS.VSL_CD = @[vsl_cd] " ).append("\n"); 
		query.append("AND RQS.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("AND RQS.SKD_DIR_CD = @[skd_dir_cd] " ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("--AND RQS.POL_CD = SUBSTR([pol_cd],0,5)" ).append("\n"); 
		query.append("--AND RQS.POD_CD = SUBSTR([pod_cd],0,5)" ).append("\n"); 
		query.append("--AND CGO.DCGO_REF_NO = [dcgo_ref_no]" ).append("\n"); 
		query.append("--AND CGO.CGO_OPR_CD = [cgo_opr_cd]" ).append("\n"); 

	}
}