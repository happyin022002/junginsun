/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OwnDangerousCargoApprovalDBDAOSearchScgRfCgoAutoApprovalRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.08
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.08 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OwnDangerousCargoApprovalDBDAOSearchScgRfCgoAutoApprovalRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Reefer Cargo 자동 승인 대상을 조회한다.
	  * </pre>
	  */
	public OwnDangerousCargoApprovalDBDAOSearchScgRfCgoAutoApprovalRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
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
		query.append("FileName : OwnDangerousCargoApprovalDBDAOSearchScgRfCgoAutoApprovalRSQL").append("\n"); 
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
		query.append("  RQ.BKG_NO" ).append("\n"); 
		query.append(", RQ.SPCL_CGO_APRO_RQST_SEQ" ).append("\n"); 
		query.append(", SV.VSL_PRE_PST_CD" ).append("\n"); 
		query.append(", SV.VSL_SEQ" ).append("\n"); 
		query.append("--, SV.SLAN_CD" ).append("\n"); 
		query.append("--, SV.VSL_CD" ).append("\n"); 
		query.append("--, SV.SKD_VOY_NO" ).append("\n"); 
		query.append("--, SV.SKD_DIR_CD" ).append("\n"); 
		query.append("--, SV.POL_CD" ).append("\n"); 
		query.append("--, SV.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("--, SV.POD_CD" ).append("\n"); 
		query.append("--, SV.POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append("--, SPCL_CGO_AUTH_SEQ" ).append("\n"); 
		query.append(", RQ.SPCL_CGO_CATE_CD --'RF'" ).append("\n"); 
		query.append("--, DCGO_SEQ" ).append("\n"); 
		query.append(", RF.RC_SEQ" ).append("\n"); 
		query.append(", SV.POL_CD" ).append("\n"); 
		query.append(", RSO.LOC_CD" ).append("\n"); 
		query.append(", RSO.RGN_SHP_OPR_CD" ).append("\n"); 
		query.append("----AUTH 정보----" ).append("\n"); 
		query.append("--, AUTH_OFC_CD" ).append("\n"); 
		query.append("--, AUTH_USR_ID" ).append("\n"); 
		query.append("--, AUTH_DT" ).append("\n"); 
		query.append("--, AUTH_GDT" ).append("\n"); 
		query.append(", RQ.RQST_USR_ID" ).append("\n"); 
		query.append(", RQ.RQST_OFC_CD" ).append("\n"); 
		query.append(", RQ.RQST_DT" ).append("\n"); 
		query.append(", RQ.RQST_GDT" ).append("\n"); 
		query.append("----AUTH 정보----" ).append("\n"); 
		query.append(", RQ.CRE_USR_ID" ).append("\n"); 
		query.append(", RQ.CRE_DT" ).append("\n"); 
		query.append(", RQ.UPD_USR_ID" ).append("\n"); 
		query.append(", RQ.UPD_DT" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("SCG_APRO_RQST RQ," ).append("\n"); 
		query.append("SCG_VVD_APRO_RQST SV," ).append("\n"); 
		query.append("SCG_RF_CGO RF," ).append("\n"); 
		query.append("SCG_RGN_SHP_OPR_PORT RSO" ).append("\n"); 
		query.append("WHERE  " ).append("\n"); 
		query.append("RQ.BKG_NO = SV.BKG_NO" ).append("\n"); 
		query.append("AND RQ.BKG_NO = RF.BKG_NO" ).append("\n"); 
		query.append("AND RQ.SPCL_CGO_APRO_RQST_SEQ = SV.SPCL_CGO_APRO_RQST_SEQ" ).append("\n"); 
		query.append("AND RQ.SPCL_CGO_APRO_RQST_SEQ = RF.SPCL_CGO_APRO_RQST_SEQ" ).append("\n"); 
		query.append("AND RQ.LST_RQST_DAT_FLG = 'Y'" ).append("\n"); 
		query.append("AND RF.SPCL_CGO_APRO_CD NOT IN('C','D')" ).append("\n"); 
		query.append("AND SV.POL_CD = RSO.LOC_CD" ).append("\n"); 
		query.append("AND RSO.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND RQ.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#if (${spcl_cgo_apro_rqst_seq} != '') " ).append("\n"); 
		query.append("AND	RQ.SPCL_CGO_APRO_RQST_SEQ = @[spcl_cgo_apro_rqst_seq]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND	RQ.SPCL_CGO_APRO_RQST_SEQ = (	SELECT MAX(A.SPCL_CGO_APRO_RQST_SEQ) FROM SCG_APRO_RQST A WHERE A.SPCL_CGO_CATE_CD = 'RF' AND A.BKG_NO = @[bkg_no]	)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY " ).append("\n"); 
		query.append("  RQ.BKG_NO" ).append("\n"); 
		query.append(", RQ.SPCL_CGO_APRO_RQST_SEQ" ).append("\n"); 
		query.append(", SV.VSL_PRE_PST_CD" ).append("\n"); 
		query.append(", SV.VSL_SEQ" ).append("\n"); 
		query.append(", RQ.SPCL_CGO_CATE_CD --'RF'" ).append("\n"); 
		query.append(", RF.RC_SEQ" ).append("\n"); 
		query.append(", SV.POL_CD" ).append("\n"); 
		query.append(", RSO.LOC_CD" ).append("\n"); 
		query.append(", RSO.RGN_SHP_OPR_CD" ).append("\n"); 
		query.append(", RQ.RQST_USR_ID" ).append("\n"); 
		query.append(", RQ.RQST_OFC_CD" ).append("\n"); 
		query.append(", RQ.RQST_DT" ).append("\n"); 
		query.append(", RQ.RQST_GDT" ).append("\n"); 
		query.append(", RQ.CRE_USR_ID" ).append("\n"); 
		query.append(", RQ.CRE_DT" ).append("\n"); 
		query.append(", RQ.UPD_USR_ID" ).append("\n"); 
		query.append(", RQ.UPD_DT" ).append("\n"); 
		query.append("ORDER BY " ).append("\n"); 
		query.append("  RQ.BKG_NO" ).append("\n"); 
		query.append(", SV.VSL_PRE_PST_CD" ).append("\n"); 
		query.append(", RF.RC_SEQ" ).append("\n"); 

	}
}