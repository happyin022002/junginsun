/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : SCContractPartyProposalDBDAOPriSpCtrtPtyVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.03.16
*@LastModifier : 
*@LastVersion : 1.0
* 2017.03.16 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.sccontractpartyproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCContractPartyProposalDBDAOPriSpCtrtPtyVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * insert
	  * </pre>
	  */
	public SCContractPartyProposalDBDAOPriSpCtrtPtyVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_pty_addr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prc_ctrt_pty_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("acpt_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_cust_sls_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_cust_srep_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
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
		params.put("moc_lic_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
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
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("acpt_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ctrt_pty_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ctrt_cust_val_sgm_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acpt_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.sccontractpartyproposal.integration").append("\n"); 
		query.append("FileName : SCContractPartyProposalDBDAOPriSpCtrtPtyVOCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_SP_CTRT_PTY (" ).append("\n"); 
		query.append("	PROP_NO" ).append("\n"); 
		query.append(",	AMDT_SEQ" ).append("\n"); 
		query.append(",	PRC_CTRT_PTY_TP_CD" ).append("\n"); 
		query.append(",	CUST_CNT_CD" ).append("\n"); 
		query.append(",	CUST_SEQ" ).append("\n"); 
		query.append(",	CTRT_CUST_VAL_SGM_CD" ).append("\n"); 
		query.append(",	CTRT_CUST_SREP_CD" ).append("\n"); 
		query.append(",	CTRT_CUST_SLS_OFC_CD" ).append("\n"); 
		query.append(",	CTRT_PTY_NM" ).append("\n"); 
		query.append(",	CTRT_PTY_ADDR" ).append("\n"); 
		query.append(",	CTRT_PTY_SGN_NM" ).append("\n"); 
		query.append(",	CTRT_PTY_SGN_TIT_NM" ).append("\n"); 
		query.append(",	PRC_PROG_STS_CD" ).append("\n"); 
		query.append(",	SRC_INFO_CD" ).append("\n"); 
		query.append(",	N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append(",	ACPT_USR_ID" ).append("\n"); 
		query.append(",	ACPT_OFC_CD" ).append("\n"); 
		query.append(",	ACPT_DT" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(",   MOC_LIC_NO" ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("	@[prop_no]" ).append("\n"); 
		query.append(",	@[amdt_seq]" ).append("\n"); 
		query.append(",	@[prc_ctrt_pty_tp_cd]" ).append("\n"); 
		query.append(",	@[cust_cnt_cd]" ).append("\n"); 
		query.append(",	@[cust_seq]" ).append("\n"); 
		query.append(",	@[ctrt_cust_val_sgm_cd]" ).append("\n"); 
		query.append(",	@[ctrt_cust_srep_cd]" ).append("\n"); 
		query.append(",	@[ctrt_cust_sls_ofc_cd]" ).append("\n"); 
		query.append(",	@[ctrt_pty_nm]" ).append("\n"); 
		query.append(",	@[ctrt_pty_addr]" ).append("\n"); 
		query.append(", DECODE(PTY.CTRT_PTY_SGN_NM, NULL,'Please Input',PTY.CTRT_PTY_SGN_NM)" ).append("\n"); 
		query.append(", DECODE(PTY.CTRT_PTY_SGN_TIT_NM, NULL,'Please Input',CTRT_PTY_SGN_TIT_NM)" ).append("\n"); 
		query.append(",	@[prc_prog_sts_cd]" ).append("\n"); 
		query.append(",	@[src_info_cd]" ).append("\n"); 
		query.append(",	@[amdt_seq]" ).append("\n"); 
		query.append(",	@[acpt_usr_id]" ).append("\n"); 
		query.append(",	@[acpt_ofc_cd]" ).append("\n"); 
		query.append(",	TO_DATE(@[acpt_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	sysdate" ).append("\n"); 
		query.append(",	@[upd_usr_id]" ).append("\n"); 
		query.append(",	sysdate" ).append("\n"); 
		query.append(",   @[moc_lic_no]" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION ORG" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("SELECT PTY.CTRT_PTY_SGN_NM" ).append("\n"); 
		query.append("      ,PTY.CTRT_PTY_SGN_TIT_NM" ).append("\n"); 
		query.append("      ,PROP_OFC_CD" ).append("\n"); 
		query.append("FROM   PRI_SP_MN MN" ).append("\n"); 
		query.append("      ,PRI_SP_CTRT_PTY PTY" ).append("\n"); 
		query.append("WHERE  MN.PROP_NO = PTY.PROP_NO" ).append("\n"); 
		query.append("AND    MN.AMDT_SEQ = PTY.AMDT_SEQ" ).append("\n"); 
		query.append("AND    MN.PROP_STS_CD = 'F'" ).append("\n"); 
		query.append("AND    MN.PROP_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("AND    PTY.CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("AND    PTY.CUST_SEQ    = @[cust_seq]" ).append("\n"); 
		query.append("AND    PTY.PRC_CTRT_PTY_TP_CD = 'C'" ).append("\n"); 
		query.append("AND    PTY.UPD_DT =" ).append("\n"); 
		query.append("          (SELECT MAX (PTY.UPD_DT)" ).append("\n"); 
		query.append("           FROM   PRI_SP_MN MN" ).append("\n"); 
		query.append("                 ,PRI_SP_CTRT_PTY PTY" ).append("\n"); 
		query.append("           WHERE  MN.PROP_NO = PTY.PROP_NO" ).append("\n"); 
		query.append("           AND    MN.AMDT_SEQ = PTY.AMDT_SEQ" ).append("\n"); 
		query.append("		   AND    MN.PROP_STS_CD = 'F'" ).append("\n"); 
		query.append("		   AND    MN.PROP_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("		   AND    PTY.CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("		   AND    PTY.CUST_SEQ    = @[cust_seq]" ).append("\n"); 
		query.append("           AND    PTY.PRC_CTRT_PTY_TP_CD = 'C'" ).append("\n"); 
		query.append("			) " ).append("\n"); 
		query.append("AND   ROWNUM = 1" ).append("\n"); 
		query.append(")PTY" ).append("\n"); 
		query.append("WHERE OFC_CD = @[ofc_cd] " ).append("\n"); 
		query.append("AND PROP_OFC_CD (+) = OFC_CD" ).append("\n"); 

	}
}