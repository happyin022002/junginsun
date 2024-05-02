/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OwnDangerousCargoApprovalDBDAOScgNonDcgoRequestCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.19
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OwnDangerousCargoApprovalDBDAOScgNonDcgoRequestCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * OwnDangerousCargoApprovalDBDAOScgNonDcgoRequest
	  * </pre>
	  */
	public OwnDangerousCargoApprovalDBDAOScgNonDcgoRequestCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("non_dcgo_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.integration").append("\n"); 
		query.append("FileName : OwnDangerousCargoApprovalDBDAOScgNonDcgoRequestCSQL").append("\n"); 
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
		query.append("INSERT INTO SCG_NON_DG_CGO_UDECL_HIS " ).append("\n"); 
		query.append("(	BKG_NO" ).append("\n"); 
		query.append("	, RQST_DT" ).append("\n"); 
		query.append("	, NON_DCGO_RQST_SEQ" ).append("\n"); 
		query.append("	, UDECL_DT" ).append("\n"); 
		query.append("	, RQST_OFC_CD" ).append("\n"); 
		query.append("	, VSL_CD" ).append("\n"); 
		query.append("	, SKD_VOY_NO" ).append("\n"); 
		query.append("	, SKD_DIR_CD" ).append("\n"); 
		query.append("	, SLAN_CD" ).append("\n"); 
		query.append("	, ON_BRD_FLG" ).append("\n"); 
		query.append("	, CSTMS_DESC" ).append("\n"); 
		query.append("	, CNTR_MF_GDS_DESC" ).append("\n"); 
		query.append("	, CMDT_DESC" ).append("\n"); 
		query.append("	, XTER_RMK" ).append("\n"); 
		query.append("	, INTER_RMK" ).append("\n"); 
		query.append("	, CRE_USR_ID" ).append("\n"); 
		query.append("	, CRE_DT" ).append("\n"); 
		query.append("	, UPD_USR_ID" ).append("\n"); 
		query.append("	, UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT A.BKG_NO" ).append("\n"); 
		query.append("		, A.RQST_DT" ).append("\n"); 
		query.append("        , A.NON_DCGO_RQST_SEQ" ).append("\n"); 
		query.append("		, SYSDATE --UDECL_DT" ).append("\n"); 
		query.append("        , A.RQST_OFC_CD" ).append("\n"); 
		query.append("        , A.VSL_CD" ).append("\n"); 
		query.append("        , A.SKD_VOY_NO" ).append("\n"); 
		query.append("        , A.SKD_DIR_CD" ).append("\n"); 
		query.append("        , A.SLAN_CD" ).append("\n"); 
		query.append("        , 'N'--ON_BRD_FLG" ).append("\n"); 
		query.append("        , A.CSTMS_DESC" ).append("\n"); 
		query.append("        , A.CNTR_MF_GDS_DESC" ).append("\n"); 
		query.append("        , A.CMDT_DESC" ).append("\n"); 
		query.append("        , A.XTER_RMK" ).append("\n"); 
		query.append("        , A.INTER_RMK" ).append("\n"); 
		query.append("        , @[cre_usr_id]" ).append("\n"); 
		query.append("        , SYSDATE" ).append("\n"); 
		query.append("        , @[upd_usr_id]" ).append("\n"); 
		query.append("        , SYSDATE" ).append("\n"); 
		query.append("FROM    SCG_NON_DG_CGO_KW_RQST A" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND A.NON_DCGO_RQST_SEQ = @[non_dcgo_rqst_seq]" ).append("\n"); 

	}
}