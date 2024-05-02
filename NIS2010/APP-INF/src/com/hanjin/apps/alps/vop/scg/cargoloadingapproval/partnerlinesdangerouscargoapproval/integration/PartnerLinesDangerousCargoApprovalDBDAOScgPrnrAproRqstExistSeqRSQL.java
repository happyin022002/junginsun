/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : PartnerLinesDangerousCargoApprovalDBDAOScgPrnrAproRqstExistSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.01.11
*@LastModifier : 
*@LastVersion : 1.0
* 2012.01.11 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PartnerLinesDangerousCargoApprovalDBDAOScgPrnrAproRqstExistSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Dangerous CGO Application Details for Partner Lines 의 신규 입력된 
	  * 데이터 건에 대해서 기존에 존재하는 건과 
	  * bkg_ref_no, vvd, bkg operator, pol+(calling seq ), pod+(calling seq ) 의 조합이
	  * 같은 건이 있는 경우 해당 건은 insert 가 되지 않아야 하며 
	  * 존재하던 spcl_cgo_rqst_seq 를 리턴받아 detail 건에 적용 해야 한다.
	  * -------------------------------------------------------------------------------------------
	  * 2012.01.11 김민아 [CHM-201115273-01] [VOP-SCG] SPCL CGO APVL for Partner Lines - AWK 보완
	  * </pre>
	  */
	public PartnerLinesDangerousCargoApprovalDBDAOScgPrnrAproRqstExistSeqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("awk_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pod_clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dg_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.integration").append("\n"); 
		query.append("FileName : PartnerLinesDangerousCargoApprovalDBDAOScgPrnrAproRqstExistSeqRSQL").append("\n"); 
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
		query.append("SELECT NVL(MAX(A.SPCL_CGO_RQST_SEQ),0) SPCL_CGO_RQST_SEQ" ).append("\n"); 
		query.append("FROM   SCG_PRNR_APRO_RQST A" ).append("\n"); 
		query.append("     , SCG_PRNR_APRO_RQST_CGO B " ).append("\n"); 
		query.append("WHERE  A.CRR_CD            = B.CRR_CD" ).append("\n"); 
		query.append("AND    A.BKG_REF_NO        = B.BKG_REF_NO" ).append("\n"); 
		query.append("AND    A.SPCL_CGO_RQST_SEQ = B.SPCL_CGO_RQST_SEQ" ).append("\n"); 
		query.append("AND    A.DG_FLG            = @[dg_flg]" ).append("\n"); 
		query.append("AND    A.AWK_FLG           = @[awk_flg]" ).append("\n"); 
		query.append("AND    B.CGO_OPR_CD    = @[cgo_opr_cd]" ).append("\n"); 
		query.append("AND    A.BKG_REF_NO    = @[bkg_ref_no]" ).append("\n"); 
		query.append("AND    A.VSL_CD        = @[vsl_cd]" ).append("\n"); 
		query.append("AND    A.SKD_VOY_NO    = @[skd_voy_no]" ).append("\n"); 
		query.append("AND    A.SKD_DIR_CD    = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND    A.POL_CD = SUBSTR(@[pol_cd],1,5)" ).append("\n"); 
		query.append("AND    A.POL_CLPT_IND_SEQ = DECODE ( SUBSTR(@[pol_cd],6,1), NULL, @[pol_clpt_ind_seq], SUBSTR(@[pol_cd],6,1) )" ).append("\n"); 
		query.append("AND    A.POD_CD = SUBSTR(@[pod_cd],1,5)" ).append("\n"); 
		query.append("AND    A.POD_CLPT_IND_SEQ = DECODE ( SUBSTR(@[pod_cd],6,1), NULL, @[pod_clpt_ind_seq], SUBSTR(@[pod_cd],6,1) )" ).append("\n"); 

	}
}