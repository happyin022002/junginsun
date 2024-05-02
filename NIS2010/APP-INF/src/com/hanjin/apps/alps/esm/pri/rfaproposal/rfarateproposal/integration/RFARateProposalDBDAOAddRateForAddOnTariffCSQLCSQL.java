/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : RFARateProposalDBDAOAddRateForAddOnTariffCSQLCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.08
*@LastModifier : 이은섭
*@LastVersion : 1.0
* 2012.10.08 이은섭
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Eun-Sup Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFARateProposalDBDAOAddRateForAddOnTariffCSQLCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Rate 등록
	  * </pre>
	  */
	public RFARateProposalDBDAOAddRateForAddOnTariffCSQLCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fic_dest_gline_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fic_dest_rt_use_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fic_org_prop_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dest_optm_trsp_mod_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_frt_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fic_org_fnl_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_hdr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fic_dest_coffr_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_optm_trsp_mod_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fic_dest_fnl_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("prc_cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fic_org_coffr_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rat_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("coffr_frt_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fic_org_rt_use_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fnl_frt_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fic_org_gline_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rout_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fic_dest_prop_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.integration ").append("\n"); 
		query.append("FileName : RFARateProposalDBDAOAddRateForAddOnTariffCSQLCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_RP_SCP_RT (" ).append("\n"); 
		query.append("  PROP_NO" ).append("\n"); 
		query.append(",  AMDT_SEQ" ).append("\n"); 
		query.append(",  SVC_SCP_CD" ).append("\n"); 
		query.append(",  CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",  ROUT_SEQ" ).append("\n"); 
		query.append(",  RT_SEQ" ).append("\n"); 
		query.append(",  RAT_UT_CD" ).append("\n"); 
		query.append(",  PRC_CGO_TP_CD" ).append("\n"); 
		query.append(",  CURR_CD" ).append("\n"); 
		query.append(",  PROP_FRT_RT_AMT" ).append("\n"); 
		query.append(",  COFFR_FRT_RT_AMT" ).append("\n"); 
		query.append(",  FNL_FRT_RT_AMT" ).append("\n"); 
		query.append(",  GRI_APPL_TP_CD" ).append("\n"); 
		query.append(",  GRI_APPL_AMT" ).append("\n"); 
		query.append(",  PRC_PROG_STS_CD" ).append("\n"); 
		query.append(",  SRC_INFO_CD" ).append("\n"); 
		query.append(",  N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append(",  CRE_USR_ID" ).append("\n"); 
		query.append(",  CRE_DT" ).append("\n"); 
		query.append(",  UPD_USR_ID" ).append("\n"); 
		query.append(",  UPD_DT" ).append("\n"); 
		query.append(",  FIC_ORG_PROP_RT_AMT" ).append("\n"); 
		query.append(",  FIC_ORG_COFFR_RT_AMT" ).append("\n"); 
		query.append(",  FIC_ORG_FNL_RT_AMT" ).append("\n"); 
		query.append(",  FIC_ORG_GLINE_RT_AMT" ).append("\n"); 
		query.append(",  FIC_ORG_GLINE_UPD_DT" ).append("\n"); 
		query.append(",  ORG_OPTM_TRSP_MOD_FLG" ).append("\n"); 
		query.append(",  FIC_ORG_RT_USE_STS_CD" ).append("\n"); 
		query.append(",  FIC_DEST_PROP_RT_AMT" ).append("\n"); 
		query.append(",  FIC_DEST_COFFR_RT_AMT" ).append("\n"); 
		query.append(",  FIC_DEST_FNL_RT_AMT" ).append("\n"); 
		query.append(",  FIC_DEST_GLINE_RT_AMT" ).append("\n"); 
		query.append(",  FIC_DEST_GLINE_UPD_DT" ).append("\n"); 
		query.append(",  DEST_OPTM_TRSP_MOD_FLG" ).append("\n"); 
		query.append(",  FIC_DEST_RT_USE_STS_CD" ).append("\n"); 
		query.append(") VALUES( " ).append("\n"); 
		query.append("  @[prop_no]" ).append("\n"); 
		query.append(",  @[amdt_seq]" ).append("\n"); 
		query.append(",  @[svc_scp_cd]" ).append("\n"); 
		query.append(",  @[cmdt_hdr_seq]" ).append("\n"); 
		query.append(",  @[rout_seq]" ).append("\n"); 
		query.append(",  @[rt_seq]" ).append("\n"); 
		query.append(",  @[rat_ut_cd]" ).append("\n"); 
		query.append(",  @[prc_cgo_tp_cd]" ).append("\n"); 
		query.append(",  @[curr_cd]" ).append("\n"); 
		query.append(",  @[prop_frt_rt_amt]" ).append("\n"); 
		query.append(",  @[coffr_frt_rt_amt]" ).append("\n"); 
		query.append(",  @[fnl_frt_rt_amt]" ).append("\n"); 
		query.append(",  'N'" ).append("\n"); 
		query.append(",  0" ).append("\n"); 
		query.append(",  'I'" ).append("\n"); 
		query.append(",  'NW'" ).append("\n"); 
		query.append(",  @[amdt_seq]" ).append("\n"); 
		query.append(",  @[cre_usr_id]" ).append("\n"); 
		query.append(",  SYSDATE" ).append("\n"); 
		query.append(",  @[upd_usr_id]" ).append("\n"); 
		query.append(",  SYSDATE" ).append("\n"); 
		query.append(",   @[fic_org_prop_rt_amt]" ).append("\n"); 
		query.append(",   @[fic_org_coffr_rt_amt]" ).append("\n"); 
		query.append(",   @[fic_org_fnl_rt_amt]" ).append("\n"); 
		query.append(",   DECODE(@[fic_org_gline_rt_amt], 'N/A', NULL, @[fic_org_gline_rt_amt])" ).append("\n"); 
		query.append(",   SYSDATE" ).append("\n"); 
		query.append(",   NVL(@[org_optm_trsp_mod_flg], 'N')" ).append("\n"); 
		query.append(",   NVL(@[fic_org_rt_use_sts_cd], 'X')" ).append("\n"); 
		query.append(",   @[fic_dest_prop_rt_amt]" ).append("\n"); 
		query.append(",   @[fic_dest_coffr_rt_amt]" ).append("\n"); 
		query.append(",   @[fic_dest_fnl_rt_amt]" ).append("\n"); 
		query.append(",   DECODE(@[fic_dest_gline_rt_amt], 'N/A', NULL, @[fic_dest_gline_rt_amt])" ).append("\n"); 
		query.append(",   SYSDATE" ).append("\n"); 
		query.append(",   NVL(@[dest_optm_trsp_mod_flg], 'N')" ).append("\n"); 
		query.append(",   NVL(@[fic_dest_rt_use_sts_cd], 'X')" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}