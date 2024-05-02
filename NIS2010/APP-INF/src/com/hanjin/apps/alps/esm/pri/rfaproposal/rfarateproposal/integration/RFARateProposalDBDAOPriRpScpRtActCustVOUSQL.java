/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : RFARateProposalDBDAOPriRpScpRtActCustVOUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.16
*@LastModifier : 이은섭
*@LastVersion : 1.0
* 2012.06.16 이은섭
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Eun-Sup Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFARateProposalDBDAOPriRpScpRtActCustVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CMDT수정
	  * </pre>
	  */
	public RFARateProposalDBDAOPriRpScpRtActCustVOUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_cmnc_amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("act_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prc_prog_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fic_rt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.integration").append("\n"); 
		query.append("FileName : RFARateProposalDBDAOPriRpScpRtActCustVOUSQL").append("\n"); 
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
		query.append("UPDATE PRI_RP_SCP_RT_ACT_CUST CMDT SET " ).append("\n"); 
		query.append("#if (${IS_ACCEPT} == 'N') " ).append("\n"); 
		query.append("#if (${IS_DEL_AMEND} == 'Y') " ).append("\n"); 
		query.append("	PRC_PROG_STS_CD = 'I'" ).append("\n"); 
		query.append(",	SRC_INFO_CD = 'AD'" ).append("\n"); 
		query.append(",	N1ST_CMNC_AMDT_SEQ = @[n1st_cmnc_amdt_seq]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append(",	CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append(",	PRC_PROG_STS_CD = @[prc_prog_sts_cd]" ).append("\n"); 
		query.append(",	SRC_INFO_CD = @[src_info_cd]" ).append("\n"); 
		query.append(",	N1ST_CMNC_AMDT_SEQ = @[n1st_cmnc_amdt_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#elseif (${IS_ACCEPT} == 'Y') " ).append("\n"); 
		query.append("	PRC_PROG_STS_CD = @[prc_prog_sts_cd]" ).append("\n"); 
		query.append(",	ACPT_USR_ID = @[acpt_usr_id]" ).append("\n"); 
		query.append(",	ACPT_OFC_CD = @[acpt_ofc_cd]" ).append("\n"); 
		query.append(",	ACPT_DT = TO_DATE(@[acpt_dt],'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",	UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append(",	UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHERE	PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND	AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND	SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("#if (${CASCADE_LEVEL} == '0') " ).append("\n"); 
		query.append("#if (${IS_ACCEPT} == 'Y') " ).append("\n"); 
		query.append("AND PRC_PROG_STS_CD = DECODE(@[prc_prog_sts_cd], 'A', 'I', 'I', 'A')" ).append("\n"); 
		query.append("AND AMDT_SEQ = N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("-- G,A를 구분해서 update한다." ).append("\n"); 
		query.append("AND EXISTS ( " ).append("\n"); 
		query.append("        SELECT 1 FROM  PRI_RP_SCP_RT_CMDT_HDR HDR " ).append("\n"); 
		query.append("            WHERE HDR.PROP_NO = CMDT.PROP_NO " ).append("\n"); 
		query.append("            AND HDR.AMDT_SEQ = CMDT.AMDT_SEQ " ).append("\n"); 
		query.append("            AND HDR.SVC_SCP_CD = CMDT.SVC_SCP_CD " ).append("\n"); 
		query.append("            AND HDR.CMDT_HDR_SEQ = CMDT.CMDT_HDR_SEQ " ).append("\n"); 
		query.append("            AND NVL(FIC_RT_TP_CD, 'G') = NVL(@[fic_rt_tp_cd], 'G'))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#elseif (${CASCADE_LEVEL} == '1') " ).append("\n"); 
		query.append("AND	CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND	CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("AND	ACT_CUST_SEQ = @[act_cust_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}