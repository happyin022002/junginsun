/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PartnerLinesDangerousCargoApprovalDBDAOScgPrnrAproRqstCgoIsSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.15
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.15 
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

public class PartnerLinesDangerousCargoApprovalDBDAOScgPrnrAproRqstCgoIsSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Dangerous CGO Application Details for Partner Lines 의 Cago 존재유무 조회
	  * </pre>
	  */
	public PartnerLinesDangerousCargoApprovalDBDAOScgPrnrAproRqstCgoIsSeqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_cgo_cate_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_opr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("prnr_cgo_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.integration").append("\n"); 
		query.append("FileName : PartnerLinesDangerousCargoApprovalDBDAOScgPrnrAproRqstCgoIsSeqRSQL").append("\n"); 
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
		query.append("SELECT   COUNT(*) SPCL_CGO_SEQ" ).append("\n"); 
		query.append("FROM     SCG_PRNR_APRO_RQST				 X" ).append("\n"); 
		query.append("      ,  SCG_PRNR_APRO_RQST_CGO          Y" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE   X.CRR_CD                        = Y.CRR_CD" ).append("\n"); 
		query.append("AND     X.BKG_REF_NO                    = Y.BKG_REF_NO" ).append("\n"); 
		query.append("AND		X.SPCL_CGO_RQST_SEQ				= Y.SPCL_CGO_RQST_SEQ" ).append("\n"); 
		query.append("AND     X.PRNR_CGO_RQST_SEQ    			= Y.PRNR_CGO_RQST_SEQ" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("AND		Y.SPCL_CGO_CATE_CD				= @[spcl_cgo_cate_cd]	-- :'DG','AK': --" ).append("\n"); 
		query.append("AND     Y.CRR_CD           				= COM_ConstantMgr_PKG.COM_getCompanyCode_FNC()" ).append("\n"); 
		query.append("AND     Y.BKG_REF_NO         			= @[bkg_ref_no]" ).append("\n"); 
		query.append("AND     Y.CGO_OPR_CD         			= @[cgo_opr_cd]" ).append("\n"); 
		query.append("AND     Y.PRNR_CGO_RQST_SEQ             = @[prnr_cgo_rqst_seq]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND     X.VSL_CD             			= @[vsl_cd]    " ).append("\n"); 
		query.append("AND     X.SKD_VOY_NO         			= @[skd_voy_no]" ).append("\n"); 
		query.append("AND     X.SKD_DIR_CD         			= @[skd_dir_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--AND     X.POL_CD             			= SUBSTR([pol_cd],1,5)    " ).append("\n"); 
		query.append("--AND     X.POD_CD             			= SUBSTR([pod_cd],1,5)" ).append("\n"); 

	}
}