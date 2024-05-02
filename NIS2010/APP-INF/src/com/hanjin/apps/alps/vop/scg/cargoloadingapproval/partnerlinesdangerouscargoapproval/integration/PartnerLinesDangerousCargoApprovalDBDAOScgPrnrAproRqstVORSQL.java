/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : PartnerLinesDangerousCargoApprovalDBDAOScgPrnrAproRqstVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.21
*@LastModifier : 
*@LastVersion : 1.0
* 2011.04.21 
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

public class PartnerLinesDangerousCargoApprovalDBDAOScgPrnrAproRqstVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Dangerous CGO Application Details for Partner Lines 의 Booking 조회
	  * </pre>
	  */
	public PartnerLinesDangerousCargoApprovalDBDAOScgPrnrAproRqstVORSQL(){
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
		params.put("rgn_shp_opr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_cgo_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cgo_opr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.integration").append("\n"); 
		query.append("FileName : PartnerLinesDangerousCargoApprovalDBDAOScgPrnrAproRqstVORSQL").append("\n"); 
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
		query.append("	BKG.CRR_CD" ).append("\n"); 
		query.append(",	BKG.BKG_REF_NO" ).append("\n"); 
		query.append(",	BKG.SPCL_CGO_RQST_SEQ" ).append("\n"); 
		query.append(",	BKG.VSL_CD" ).append("\n"); 
		query.append(",	BKG.SKD_VOY_NO" ).append("\n"); 
		query.append(",	BKG.SKD_DIR_CD" ).append("\n"); 
		query.append(",	BKG.SLAN_CD" ).append("\n"); 
		query.append(",	BKG.RGN_SHP_OPR_CD" ).append("\n"); 
		query.append(",	(BKG.POL_CD||BKG.POL_CLPT_IND_SEQ) AS POL_CD" ).append("\n"); 
		query.append(",	(BKG.POD_CD||BKG.POD_CLPT_IND_SEQ) AS POD_CD" ).append("\n"); 
		query.append(",	TO_CHAR(BKG.ETA_DT,'YYYY-MM-DD HH24:MI:SS') ETA_DT" ).append("\n"); 
		query.append(",	BKG.DG_FLG" ).append("\n"); 
		query.append(",	BKG.AWK_FLG" ).append("\n"); 
		query.append(",	BKG.CRE_USR_ID" ).append("\n"); 
		query.append(",	BKG.CRE_DT" ).append("\n"); 
		query.append(",	BKG.UPD_USR_ID" ).append("\n"); 
		query.append(",	BKG.UPD_DT" ).append("\n"); 
		query.append(",   '' CGO_OPR_CD" ).append("\n"); 
		query.append(",   '' POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append(",   '' POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append(",   '' ME_FLAG " ).append("\n"); 
		query.append("/* ME_FLAG - MASTER EXISTENCE FLAG : " ).append("\n"); 
		query.append("   DG Tab 을 통하여 입력되는 신규건중 기존에 있는 조합과 같은 조합의 값이 들어올 경우 " ).append("\n"); 
		query.append("   INS 에서 제외시키기 위한 Flag 값. 서버에서 INS 건 별로 체크하여 찾는 값이므로 " ).append("\n"); 
		query.append("     클라이언트에서 넘어오는 값이 아님 . 2011.04.21 */" ).append("\n"); 
		query.append("FROM SCG_PRNR_APRO_RQST BKG" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${crr_cd} != '')" ).append("\n"); 
		query.append("AND	BKG.CRR_CD         = @[crr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_ref_no} != '')" ).append("\n"); 
		query.append("AND	BKG.BKG_REF_NO     = @[bkg_ref_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${spcl_cgo_rqst_seq} != '')" ).append("\n"); 
		query.append("AND	BKG.SPCL_CGO_RQST_SEQ = @[spcl_cgo_rqst_seq]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${rgn_shp_opr_cd} != '')" ).append("\n"); 
		query.append("AND BKG.RGN_SHP_OPR_CD = @[rgn_shp_opr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vsl_cd} != '')" ).append("\n"); 
		query.append("AND	BKG.VSL_CD         = @[vsl_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${skd_voy_no} != '')" ).append("\n"); 
		query.append("AND	BKG.SKD_VOY_NO     = @[skd_voy_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${skd_dir_cd} != '')" ).append("\n"); 
		query.append("AND	BKG.SKD_DIR_CD     = @[skd_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pol_cd} != '')" ).append("\n"); 
		query.append("AND	BKG.POL_CD||BKG.POL_CLPT_IND_SEQ = @[pol_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod_cd} != '')" ).append("\n"); 
		query.append("AND	BKG.POD_CD||BKG.POD_CLPT_IND_SEQ = @[pod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND EXISTS (" ).append("\n"); 
		query.append("	SELECT 'X'" ).append("\n"); 
		query.append("      FROM SCG_PRNR_APRO_RQST_CGO CGO" ).append("\n"); 
		query.append("     WHERE CGO.CRR_CD = BKG.CRR_CD" ).append("\n"); 
		query.append("       AND CGO.BKG_REF_NO = BKG.BKG_REF_NO" ).append("\n"); 
		query.append("	   AND CGO.SPCL_CGO_RQST_SEQ = BKG.SPCL_CGO_RQST_SEQ" ).append("\n"); 
		query.append("#if (${crr_cd} != '')" ).append("\n"); 
		query.append("       AND CGO.CRR_CD = @[crr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_ref_no} != '')" ).append("\n"); 
		query.append("       AND CGO.BKG_REF_NO     = @[bkg_ref_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${spcl_cgo_rqst_seq} != '')" ).append("\n"); 
		query.append("       AND CGO.SPCL_CGO_RQST_SEQ = @[spcl_cgo_rqst_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cgo_opr_cd} != '')" ).append("\n"); 
		query.append("       AND CGO.CGO_OPR_CD = @[cgo_opr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}