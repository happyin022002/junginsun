/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OwnDangerousCargoApprovalDBDAOSearchScgAuthorizationInputVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.06
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.06 
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

public class OwnDangerousCargoApprovalDBDAOSearchScgAuthorizationInputVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SCG_AUTHORIZATION에 기존에 같은 조건으로 Insert된 Data가 있는지 체크한다.
	  * </pre>
	  */
	public OwnDangerousCargoApprovalDBDAOSearchScgAuthorizationInputVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stwg_cgo_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bb_cgo_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_pre_pst_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rc_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("awk_cgo_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dcgo_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.integration").append("\n"); 
		query.append("FileName : OwnDangerousCargoApprovalDBDAOSearchScgAuthorizationInputVORSQL").append("\n"); 
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
		query.append("	BKG_NO" ).append("\n"); 
		query.append(",	SPCL_CGO_APRO_RQST_SEQ" ).append("\n"); 
		query.append(",	VSL_PRE_PST_CD" ).append("\n"); 
		query.append(",	VSL_SEQ" ).append("\n"); 
		query.append(",	SPCL_CGO_AUTH_SEQ" ).append("\n"); 
		query.append(",	SPCL_CGO_CATE_CD" ).append("\n"); 
		query.append(",	DCGO_SEQ" ).append("\n"); 
		query.append(",	RC_SEQ" ).append("\n"); 
		query.append(",	BB_CGO_SEQ" ).append("\n"); 
		query.append(",	AWK_CGO_SEQ" ).append("\n"); 
		query.append(",   STWG_CGO_SEQ" ).append("\n"); 
		query.append(",	RGN_SHP_OPR_CD" ).append("\n"); 
		query.append(",	SPCL_CGO_AUTH_CD" ).append("\n"); 
		query.append(",	AUTH_OFC_CD" ).append("\n"); 
		query.append(",	AUTH_USR_ID" ).append("\n"); 
		query.append(",	AUTH_DT" ).append("\n"); 
		query.append(",	SPCL_CGO_AUTH_NO" ).append("\n"); 
		query.append(",	SPCL_CGO_AUTH_RJCT_CD" ).append("\n"); 
		query.append(",	APRO_REF_NO" ).append("\n"); 
		query.append(",	SPCL_CGO_AUTH_RMK" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	TO_CHAR(CRE_DT, 'YYYYMMDDHH24MI') AS CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	TO_CHAR(UPD_DT, 'YYYYMMDDHH24MI') AS UPD_DT" ).append("\n"); 
		query.append("FROM SCG_AUTHORIZATION" ).append("\n"); 
		query.append("WHERE	BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND	SPCL_CGO_APRO_RQST_SEQ = @[spcl_cgo_apro_rqst_seq]" ).append("\n"); 
		query.append("AND	VSL_PRE_PST_CD = @[vsl_pre_pst_cd]" ).append("\n"); 
		query.append("AND	VSL_SEQ = @[vsl_seq]" ).append("\n"); 
		query.append("AND SPCL_CGO_CATE_CD = @[spcl_cgo_cate_cd]" ).append("\n"); 
		query.append("AND(  " ).append("\n"); 
		query.append("	DCGO_SEQ = @[dcgo_seq]" ).append("\n"); 
		query.append("	OR AWK_CGO_SEQ = @[awk_cgo_seq]" ).append("\n"); 
		query.append("	OR BB_CGO_SEQ = @[bb_cgo_seq]" ).append("\n"); 
		query.append("	OR RC_SEQ = @[rc_seq]" ).append("\n"); 
		query.append("	OR STWG_CGO_SEQ = @[stwg_cgo_seq]" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("--AND DCGO_SEQ = [dcgo_seq]" ).append("\n"); 
		query.append("--AND AWK_CGO_SEQ = [awk_cgo_seq]" ).append("\n"); 
		query.append("--AND BB_CGO_SEQ = [bb_cgo_seq]" ).append("\n"); 
		query.append("--AND RC_SEQ = [rc_seq]" ).append("\n"); 
		query.append("--AND STWG_CGO_SEQ = [stwg_cgo_seq]" ).append("\n"); 
		query.append("--AND SPCL_CGO_AUTH_CD IS NOT NULL " ).append("\n"); 
		query.append("AND SPCL_CGO_AUTH_CD IS NOT NULL" ).append("\n"); 
		query.append("--AND SPCL_CGO_AUTH_CD IN('Y', 'N')" ).append("\n"); 

	}
}