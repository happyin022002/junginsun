/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : RFARateQuotationDBDAOPriRqRtVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.12.27
*@LastModifier : 이은섭
*@LastVersion : 1.0
* 2012.12.27 이은섭
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Eun-Sup Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFARateQuotationDBDAOPriRqRtVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public RFARateQuotationDBDAOPriRqRtVOCSQL(){
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
		params.put("fic_gline_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fic_dest_qttn_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prs_pfit_cmpb_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("qttn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dest_optm_trsp_mod_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prs_gid_cmpb_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
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
		params.put("org_optm_trsp_mod_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prs_pfit_cm_uc_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("src_info_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fic_org_rt_use_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prs_respb_cm_uc_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fic_rt_use_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("qttn_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fic_org_qttn_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prs_respb_opb_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fic_org_gline_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rout_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prs_scg_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("optm_trsp_mod_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("qttn_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prs_respb_opfit_uc_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prs_respb_cmpb_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fic_qttn_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.integration").append("\n"); 
		query.append("FileName : RFARateQuotationDBDAOPriRqRtVOCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_RQ_RT (" ).append("\n"); 
		query.append("  QTTN_NO" ).append("\n"); 
		query.append(",  QTTN_VER_NO" ).append("\n"); 
		query.append(",  CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",  ROUT_SEQ" ).append("\n"); 
		query.append(",  RT_SEQ" ).append("\n"); 
		query.append(",  RAT_UT_CD" ).append("\n"); 
		query.append(",  PRC_CGO_TP_CD" ).append("\n"); 
		query.append(",  CURR_CD" ).append("\n"); 
		query.append(",  PRS_SCG_AMT" ).append("\n"); 
		query.append(",  PRS_RESPB_CM_UC_AMT" ).append("\n"); 
		query.append(",  PRS_PFIT_CM_UC_AMT" ).append("\n"); 
		query.append(",  PRS_RESPB_OPFIT_UC_AMT" ).append("\n"); 
		query.append(",  PRS_RESPB_CMPB_AMT" ).append("\n"); 
		query.append(",  PRS_PFIT_CMPB_AMT" ).append("\n"); 
		query.append(",  PRS_RESPB_OPB_AMT" ).append("\n"); 
		query.append(",  PRS_GID_CMPB_AMT" ).append("\n"); 
		query.append(",  QTTN_INIT_RT_AMT" ).append("\n"); 
		query.append(",  QTTN_RT_AMT" ).append("\n"); 
		query.append(",  SRC_INFO_CD" ).append("\n"); 
		query.append(",  CRE_USR_ID" ).append("\n"); 
		query.append(",  CRE_DT" ).append("\n"); 
		query.append(",  UPD_USR_ID" ).append("\n"); 
		query.append(",  UPD_DT" ).append("\n"); 
		query.append(",  QTTN_RT_ADJ_TP_CD" ).append("\n"); 
		query.append(",  FIC_GLINE_RT_AMT" ).append("\n"); 
		query.append(",  FIC_QTTN_RT_AMT" ).append("\n"); 
		query.append(",  FIC_RT_USE_STS_CD" ).append("\n"); 
		query.append(",  FIC_GLINE_UPD_DT" ).append("\n"); 
		query.append(",  OPTM_TRSP_MOD_FLG" ).append("\n"); 
		query.append(",  FIC_ORG_GLINE_RT_AMT" ).append("\n"); 
		query.append(",  FIC_ORG_QTTN_RT_AMT" ).append("\n"); 
		query.append(",  FIC_ORG_RT_USE_STS_CD" ).append("\n"); 
		query.append(",  FIC_ORG_GLINE_UPD_DT" ).append("\n"); 
		query.append(",  ORG_OPTM_TRSP_MOD_FLG" ).append("\n"); 
		query.append(",  FIC_DEST_GLINE_RT_AMT" ).append("\n"); 
		query.append(",  FIC_DEST_QTTN_RT_AMT" ).append("\n"); 
		query.append(",  FIC_DEST_RT_USE_STS_CD" ).append("\n"); 
		query.append(",  FIC_DEST_GLINE_UPD_DT" ).append("\n"); 
		query.append(",  DEST_OPTM_TRSP_MOD_FLG" ).append("\n"); 
		query.append(") VALUES( " ).append("\n"); 
		query.append("   @[qttn_no]" ).append("\n"); 
		query.append(",  @[qttn_ver_no]" ).append("\n"); 
		query.append(",  @[cmdt_hdr_seq]" ).append("\n"); 
		query.append(",  @[rout_seq]" ).append("\n"); 
		query.append(",  (SELECT NVL(MAX(RT_SEQ), 0) + 1 FROM PRI_RQ_RT  WHERE QTTN_NO = @[qttn_no] AND QTTN_VER_NO = @[qttn_ver_no] AND CMDT_HDR_SEQ = @[cmdt_hdr_seq] AND ROUT_SEQ = @[rout_seq]) " ).append("\n"); 
		query.append(",  @[rat_ut_cd]" ).append("\n"); 
		query.append(",  @[prc_cgo_tp_cd]" ).append("\n"); 
		query.append(",  @[curr_cd]" ).append("\n"); 
		query.append(",  @[prs_scg_amt]" ).append("\n"); 
		query.append(",  @[prs_respb_cm_uc_amt]" ).append("\n"); 
		query.append(",  @[prs_pfit_cm_uc_amt]" ).append("\n"); 
		query.append(",  @[prs_respb_opfit_uc_amt]" ).append("\n"); 
		query.append(",  @[prs_respb_cmpb_amt]" ).append("\n"); 
		query.append(",  @[prs_pfit_cmpb_amt]" ).append("\n"); 
		query.append(",  @[prs_respb_opb_amt]" ).append("\n"); 
		query.append(",  @[prs_gid_cmpb_amt]" ).append("\n"); 
		query.append(",  @[qttn_rt_amt]" ).append("\n"); 
		query.append(",  @[qttn_rt_amt]" ).append("\n"); 
		query.append(",  DECODE(NVL(@[src_info_cd],''),'','NW',@[src_info_cd])" ).append("\n"); 
		query.append(",  @[cre_usr_id]" ).append("\n"); 
		query.append(",  SYSDATE" ).append("\n"); 
		query.append(",  @[upd_usr_id]" ).append("\n"); 
		query.append(",  SYSDATE" ).append("\n"); 
		query.append(",  'N'" ).append("\n"); 
		query.append(",  DECODE(NVL(@[fic_gline_rt_amt], 'N/A'), 'N/A', '', @[fic_gline_rt_amt])" ).append("\n"); 
		query.append(",  @[fic_qttn_rt_amt]" ).append("\n"); 
		query.append(",  @[fic_rt_use_sts_cd]" ).append("\n"); 
		query.append(",  DECODE(NVL(@[fic_gline_rt_amt], 'N/A'), 'N/A', '', SYSDATE)" ).append("\n"); 
		query.append(",  @[optm_trsp_mod_flg]" ).append("\n"); 
		query.append(",  DECODE(NVL(@[fic_org_gline_rt_amt], 'N/A'), 'N/A', '', @[fic_org_gline_rt_amt])" ).append("\n"); 
		query.append(",  @[fic_org_qttn_rt_amt]" ).append("\n"); 
		query.append(",  NVL(@[fic_org_rt_use_sts_cd], 'N')" ).append("\n"); 
		query.append(",  DECODE(NVL(@[fic_org_gline_rt_amt], 'N/A'), 'N/A', '', SYSDATE)" ).append("\n"); 
		query.append(",  NVL(@[org_optm_trsp_mod_flg], 'X')" ).append("\n"); 
		query.append(",  DECODE(NVL(@[fic_dest_gline_rt_amt], 'N/A'), 'N/A', '', @[fic_dest_gline_rt_amt])" ).append("\n"); 
		query.append(",  @[fic_dest_qttn_rt_amt]" ).append("\n"); 
		query.append(",  NVL(@[fic_dest_rt_use_sts_cd], 'N')" ).append("\n"); 
		query.append(",  DECODE(NVL(@[fic_dest_gline_rt_amt], 'N/A'), 'N/A', '', SYSDATE)" ).append("\n"); 
		query.append(",  NVL(@[dest_optm_trsp_mod_flg], 'X')" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}