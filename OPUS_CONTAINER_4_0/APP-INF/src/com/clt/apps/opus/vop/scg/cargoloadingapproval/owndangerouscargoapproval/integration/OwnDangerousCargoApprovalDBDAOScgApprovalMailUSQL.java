/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : OwnDangerousCargoApprovalDBDAOScgApprovalMailUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.24
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.24 
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

public class OwnDangerousCargoApprovalDBDAOScgApprovalMailUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * .
	  * </pre>
	  */
	public OwnDangerousCargoApprovalDBDAOScgApprovalMailUSQL(){
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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eml_snd_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.integration").append("\n"); 
		query.append("FileName : OwnDangerousCargoApprovalDBDAOScgApprovalMailUSQL").append("\n"); 
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
		query.append("UPDATE SCG_VVD_APRO_RQST " ).append("\n"); 
		query.append("   SET " ).append("\n"); 
		query.append("#if (${eml_snd_tp_cd} != '' && ${eml_snd_tp_cd} == 'B') " ).append("\n"); 
		query.append("      OALL_EML_SND_NO  = @[eml_snd_no]  /*일괄 발송*/" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("      INDIV_EML_SND_NO  = @[eml_snd_no] /*개별 발송*/" ).append("\n"); 
		query.append("#end       " ).append("\n"); 
		query.append("     , UPD_USR_ID       = @[upd_usr_id]" ).append("\n"); 
		query.append("     , UPD_DT           = SYSDATE" ).append("\n"); 
		query.append(" WHERE BKG_NO           = @[bkg_no]" ).append("\n"); 
		query.append("   AND SPCL_CGO_APRO_RQST_SEQ = @[spcl_cgo_apro_rqst_seq]" ).append("\n"); 
		query.append("   AND VSL_PRE_PST_CD   = @[vsl_pre_pst_cd]" ).append("\n"); 
		query.append("   AND VSL_SEQ          = @[vsl_seq]" ).append("\n"); 

	}
}