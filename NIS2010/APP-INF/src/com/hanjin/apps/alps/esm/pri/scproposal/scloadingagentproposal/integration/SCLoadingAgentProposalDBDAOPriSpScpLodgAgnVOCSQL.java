/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SCLoadingAgentProposalDBDAOPriSpScpLodgAgnVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.05
*@LastModifier : 
*@LastVersion : 1.0
* 2013.07.05 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scloadingagentproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCLoadingAgentProposalDBDAOPriSpScpLodgAgnVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * History---------------------------------------
	  * 2011.03.30 이행지 [CHM-201109659-01]  Loading Agent POA Attach(L/Agent section) 기능 개발요청
	  *                          - PRI_SP_SCP_LODG_AGN.POA_ATCH_FILE_ID 컬럼 추가로 인한 쿼리 수정
	  * 2013.07.05 전윤주 [CHM-201325627] ALPS 데이터품질 - PRI validation 로직보완 - MNL_INP_FLG 입력 부분 보완
	  * </pre>
	  */
	public SCLoadingAgentProposalDBDAOPriSpScpLodgAgnVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lodg_agn_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mnl_inp_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prc_prog_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_addr",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("poa_atch_file_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.scloadingagentproposal.integration").append("\n"); 
		query.append("FileName : SCLoadingAgentProposalDBDAOPriSpScpLodgAgnVOCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_SP_SCP_LODG_AGN" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("	 PROP_NO" ).append("\n"); 
		query.append("	,AMDT_SEQ" ).append("\n"); 
		query.append("	,SVC_SCP_CD" ).append("\n"); 
		query.append("	,LODG_AGN_SEQ" ).append("\n"); 
		query.append("	,CUST_CNT_CD" ).append("\n"); 
		query.append("	,CUST_SEQ" ).append("\n"); 
		query.append("	,MNL_INP_FLG" ).append("\n"); 
		query.append("	,CUST_NM" ).append("\n"); 
		query.append("	,CUST_ADDR" ).append("\n"); 
		query.append("	,CUST_LOC_CD" ).append("\n"); 
		query.append("	,PRC_PROG_STS_CD" ).append("\n"); 
		query.append("	,SRC_INFO_CD" ).append("\n"); 
		query.append("	,N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("	,ACPT_USR_ID" ).append("\n"); 
		query.append("	,ACPT_OFC_CD" ).append("\n"); 
		query.append("	,ACPT_DT" ).append("\n"); 
		query.append("	,CRE_USR_ID" ).append("\n"); 
		query.append("	,CRE_DT" ).append("\n"); 
		query.append("	,UPD_USR_ID" ).append("\n"); 
		query.append("	,UPD_DT" ).append("\n"); 
		query.append("	,POA_ATCH_FILE_ID" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("	 @[prop_no]" ).append("\n"); 
		query.append("	,@[amdt_seq]" ).append("\n"); 
		query.append("	,@[svc_scp_cd] " ).append("\n"); 
		query.append("	,@[lodg_agn_seq]" ).append("\n"); 
		query.append("	,@[cust_cnt_cd]" ).append("\n"); 
		query.append("	,@[cust_seq]" ).append("\n"); 
		query.append("	,DECODE(@[mnl_inp_flg], '1', 'Y', 'N')" ).append("\n"); 
		query.append("	,@[cust_nm]" ).append("\n"); 
		query.append("	,@[cust_addr]" ).append("\n"); 
		query.append("	,@[cust_loc_cd]" ).append("\n"); 
		query.append("	,@[prc_prog_sts_cd]" ).append("\n"); 
		query.append("	,@[src_info_cd]" ).append("\n"); 
		query.append("	,@[amdt_seq]" ).append("\n"); 
		query.append("	,null" ).append("\n"); 
		query.append("	,null" ).append("\n"); 
		query.append("	,null" ).append("\n"); 
		query.append("	,@[cre_usr_id]" ).append("\n"); 
		query.append("	,sysdate" ).append("\n"); 
		query.append("	,@[upd_usr_id]" ).append("\n"); 
		query.append("	,sysdate" ).append("\n"); 
		query.append("	,@[poa_atch_file_id]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}