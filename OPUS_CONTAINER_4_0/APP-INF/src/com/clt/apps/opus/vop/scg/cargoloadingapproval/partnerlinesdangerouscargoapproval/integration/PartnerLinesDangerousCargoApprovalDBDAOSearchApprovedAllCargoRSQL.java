/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PartnerLinesDangerousCargoApprovalDBDAOSearchApprovedAllCargoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.16
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.16 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PartnerLinesDangerousCargoApprovalDBDAOSearchApprovedAllCargoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * All of the Cargo are approved or not
	  * </pre>
	  */
	public PartnerLinesDangerousCargoApprovalDBDAOSearchApprovedAllCargoRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_cgo_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.integration ").append("\n"); 
		query.append("FileName : PartnerLinesDangerousCargoApprovalDBDAOSearchApprovedAllCargoRSQL").append("\n"); 
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
		query.append("DECODE(COUNT(A.BKG_REF_NO),  (" ).append("\n"); 
		query.append("								SELECT COUNT(B.BKG_REF_NO) FROM " ).append("\n"); 
		query.append("								SCG_PRNR_APRO_RQST_CGO B" ).append("\n"); 
		query.append("								WHERE B.BKG_REF_NO = A.BKG_REF_NO " ).append("\n"); 
		query.append("                                AND   B.SPCL_CGO_RQST_SEQ = A.SPCL_CGO_RQST_SEQ" ).append("\n"); 
		query.append("                                AND   B.PRNR_CGO_RQST_SEQ = A.PRNR_CGO_RQST_SEQ" ).append("\n"); 
		query.append("								--AND   B.AUTH_STS_CD ='Y'" ).append("\n"); 
		query.append("								AND   B.SPCL_CGO_CATE_CD = 'DG'" ).append("\n"); 
		query.append("                              	), 'O', 'X'	                " ).append("\n"); 
		query.append("		        				) AS ALL_APRO_STS_CD" ).append("\n"); 
		query.append("					FROM SCG_PRNR_APRO_RQST_CGO A" ).append("\n"); 
		query.append("                    WHERE CRR_CD = COM_ConstantMgr_PKG.COM_getCompanyCode_FNC()" ).append("\n"); 
		query.append("                    AND	A.BKG_REF_NO = @[bkg_ref_no]" ).append("\n"); 
		query.append("                    AND	A.SPCL_CGO_RQST_SEQ = @[spcl_cgo_rqst_seq]" ).append("\n"); 
		query.append("                    --AND	A.SPCL_CNTR_SEQ = [spcl_cntr_seq]" ).append("\n"); 
		query.append("                    --AND	A.SPCL_CGO_SEQ = [spcl_cgo_seq]" ).append("\n"); 
		query.append("                    AND	A.PRNR_CGO_RQST_SEQ = @[prnr_cgo_rqst_seq]" ).append("\n"); 
		query.append("					AND A.AUTH_STS_CD = 'Y'" ).append("\n"); 
		query.append("					GROUP BY A.BKG_REF_NO, A.SPCL_CGO_RQST_SEQ, A.PRNR_CGO_RQST_SEQ" ).append("\n"); 

	}
}