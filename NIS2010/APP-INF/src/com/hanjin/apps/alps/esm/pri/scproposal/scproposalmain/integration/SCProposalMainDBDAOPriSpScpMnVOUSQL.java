/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SCProposalMainDBDAOPriSpScpMnVOUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.03
*@LastModifier : 
*@LastVersion : 1.0
* 2012.02.03 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCProposalMainDBDAOPriSpScpMnVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PRI SP SCP MN 수정
	  * 2012.02.03 이석준[CHM-201215685] CHSS_EXPT_FLG, GRI_APPL_FLG, NEW_SCG_FLG 추가 컬럼 조회 반영
	  * </pre>
	  */
	public SCProposalMainDBDAOPriSpScpMnVOUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_scp_srep_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prs_xch_rt_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chss_expt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("new_scg_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exp_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gri_appl_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("prop_scp_apro_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_scp_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_scp_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("note_hdr_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.integration").append("\n"); 
		query.append("FileName : SCProposalMainDBDAOPriSpScpMnVOUSQL").append("\n"); 
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
		query.append("UPDATE PRI_SP_SCP_MN SET" ).append("\n"); 
		query.append("    SVC_SCP_CD              = NVL(@[svc_scp_cd],svc_scp_cd)                    ," ).append("\n"); 
		query.append("    EFF_DT                  = NVL(TO_DATE(@[eff_dt],'YYYY-MM-DD'), EFF_DT)                             ," ).append("\n"); 
		query.append("    EXP_DT                  = NVL(TO_DATE(@[exp_dt],'YYYY-MM-DD'), EXP_DT)                            ," ).append("\n"); 
		query.append("    PROP_SCP_SREP_CD        = NVL(@[prop_scp_srep_cd],prop_scp_srep_cd)        ," ).append("\n"); 
		query.append("    PROP_SCP_OFC_CD         = NVL(@[prop_scp_ofc_cd],prop_scp_ofc_cd)          ," ).append("\n"); 
		query.append("    PROP_SCP_APRO_OFC_CD    = NVL(@[prop_scp_apro_ofc_cd],prop_scp_apro_ofc_cd)," ).append("\n"); 
		query.append("    PROP_SCP_STS_CD         = NVL(@[prop_scp_sts_cd],prop_scp_sts_cd)          ," ).append("\n"); 
		query.append("    NOTE_HDR_SEQ            = NVL(@[note_hdr_seq],note_hdr_seq)                ," ).append("\n"); 
		query.append("    UPD_USR_ID              = @[upd_usr_id]                                    ," ).append("\n"); 
		query.append("	PRS_XCH_RT_YRMON        = NVL(@[prs_xch_rt_yrmon],prs_xch_rt_yrmon)        ," ).append("\n"); 
		query.append("    CHSS_EXPT_FLG           = DECODE(@[chss_expt_flg],'1','Y','N'), " ).append("\n"); 
		query.append("    GRI_APPL_FLG            = DECODE(@[gri_appl_flg] ,'1','Y','N'), " ).append("\n"); 
		query.append("    NEW_SCG_FLG             = DECODE(@[new_scg_flg]  ,'1','Y','N')," ).append("\n"); 
		query.append("    UPD_DT                  = sysdate" ).append("\n"); 
		query.append("WHERE " ).append("\n"); 
		query.append("	PROP_NO                 = @[prop_no]" ).append("\n"); 
		query.append("AND AMDT_SEQ                = @[amdt_seq]" ).append("\n"); 
		query.append("AND SVC_SCP_CD              = @[svc_scp_cd]" ).append("\n"); 

	}
}