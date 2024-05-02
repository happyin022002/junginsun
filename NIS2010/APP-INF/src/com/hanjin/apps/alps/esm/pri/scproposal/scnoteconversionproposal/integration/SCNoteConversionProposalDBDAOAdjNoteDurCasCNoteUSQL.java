/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SCNoteConversionProposalDBDAOAdjNoteDurCasCNoteUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.14
*@LastModifier : 박성수
*@LastVersion : 1.0
* 2010.01.14 박성수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scnoteconversionproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sungsoo Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCNoteConversionProposalDBDAOAdjNoteDurCasCNoteUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Commodity Note가 변경(AM, AD)되었을때 Conversion Duration을 이에 맞춰주는 작업
	  * </pre>
	  */
	public SCNoteConversionProposalDBDAOAdjNoteDurCasCNoteUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("gen_spcl_rt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_note_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.scnoteconversionproposal.integration").append("\n"); 
		query.append("FileName : SCNoteConversionProposalDBDAOAdjNoteDurCasCNoteUSQL").append("\n"); 
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
		query.append("MERGE INTO PRI_SC_NOTE_CONV A" ).append("\n"); 
		query.append("USING (SELECT N.NOTE_CONV_MAPG_ID, M.EFF_DT, M.EXP_DT" ).append("\n"); 
		query.append("FROM PRI_SP_SCP_RT_CNOTE N, PRI_SP_SCP_MN M" ).append("\n"); 
		query.append("WHERE N.PROP_NO = M.PROP_NO" ).append("\n"); 
		query.append("AND N.AMDT_SEQ = M.AMDT_SEQ" ).append("\n"); 
		query.append("AND N.SVC_SCP_CD = M.SVC_SCP_CD" ).append("\n"); 
		query.append("AND N.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND N.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND N.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("#if (${CASCADE_LEVEL} == \"0\")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${CASCADE_LEVEL} == \"1\")" ).append("\n"); 
		query.append("AND N.GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("AND N.CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND N.GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("AND N.CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("AND N.CMDT_NOTE_SEQ = @[cmdt_note_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("ON (A.NOTE_CONV_MAPG_ID = B.NOTE_CONV_MAPG_ID)" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE" ).append("\n"); 
		query.append("SET A.EFF_DT = GREATEST(A.EFF_DT, B.EFF_DT), A.EXP_DT = LEAST(A.EXP_DT, B.EXP_DT)" ).append("\n"); 
		query.append("--   WHERE (A.EFF_DT BETWEEN B.EFF_DT AND B.EXP_DT OR A.EXP_DT BETWEEN B.EFF_DT AND B.EXP_DT OR" ).append("\n"); 
		query.append("--         (A.EFF_DT <= B.EFF_DT AND A.EXP_DT > B.EXP_DT))" ).append("\n"); 
		query.append("DELETE" ).append("\n"); 
		query.append("WHERE (A.EFF_DT > B.EXP_DT OR A.EXP_DT < B.EFF_DT)" ).append("\n"); 
		query.append("AND (A.NOTE_CONV_RULE_CD IS NULL OR A.NOTE_CONV_RULE_CD <> 'APP')" ).append("\n"); 

	}
}