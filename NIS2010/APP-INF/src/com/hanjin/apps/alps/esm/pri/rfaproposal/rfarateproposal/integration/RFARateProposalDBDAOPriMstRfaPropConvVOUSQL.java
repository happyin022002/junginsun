/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RFARateProposalDBDAOPriMstRfaPropConvVOUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.30
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.30 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFARateProposalDBDAOPriMstRfaPropConvVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Master RFA의 Note Conversion 수정
	  * </pre>
	  */
	public RFARateProposalDBDAOPriMstRfaPropConvVOUSQL(){
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
		params.put("note_conv_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("note_conv_mapg_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("prc_prog_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.integration").append("\n"); 
		query.append("FileName : RFARateProposalDBDAOPriMstRfaPropConvVOUSQL").append("\n"); 
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
		query.append("UPDATE PRI_RFA_NOTE_CONV CMDT SET " ).append("\n"); 
		query.append("#if (${IS_ACCEPT} == 'N') " ).append("\n"); 
		query.append("#if (${IS_DEL_AMEND} == 'Y') " ).append("\n"); 
		query.append("	PRC_PROG_STS_CD = 'I'" ).append("\n"); 
		query.append(",	SRC_INFO_CD = 'AD'" ).append("\n"); 
		query.append(",	N1ST_CMNC_AMDT_SEQ = @[n1st_cmnc_amdt_seq]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	PRC_PROG_STS_CD = @[prc_prog_sts_cd]" ).append("\n"); 
		query.append(",	SRC_INFO_CD = @[src_info_cd]" ).append("\n"); 
		query.append(",	N1ST_CMNC_AMDT_SEQ = @[n1st_cmnc_amdt_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#elseif (${IS_ACCEPT} == 'Y') " ).append("\n"); 
		query.append("	PRC_PROG_STS_CD = @[prc_prog_sts_cd]" ).append("\n"); 
		query.append("-- 보여주는 부분이 없어서 comment 처리. 추후 필요가 있을 경우 컬럼 추가 필요." ).append("\n"); 
		query.append("--,	ACPT_USR_ID = [acpt_usr_id]" ).append("\n"); 
		query.append("--,	ACPT_OFC_CD = [acpt_ofc_cd]" ).append("\n"); 
		query.append("--,	ACPT_DT = TO_DATE([acpt_dt],'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",	UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append(",	UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHERE	PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND	AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND	SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("#if (${CASCADE_LEVEL} == '0')" ).append("\n"); 
		query.append("#if (${IS_ACCEPT} == 'Y')" ).append("\n"); 
		query.append("AND PRC_PROG_STS_CD = DECODE(@[prc_prog_sts_cd], 'A', 'I', 'I', 'A')" ).append("\n"); 
		query.append("AND AMDT_SEQ = N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#elseif (${CASCADE_LEVEL} == '1')" ).append("\n"); 
		query.append("#elseif (${CASCADE_LEVEL} == '2')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND	NOTE_CONV_SEQ = @[note_conv_seq]" ).append("\n"); 
		query.append("AND NOTE_CONV_MAPG_ID = @[note_conv_mapg_id]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}