/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFANoteConversionProposalDBDAOPriRpScpRtCnoteVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.20
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.07.20 최성민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaproposal.rfanoteconversionproposal.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI SUNG MIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFANoteConversionProposalDBDAOPriRpScpRtCnoteVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PRI_RP_SCP_RT_CNOTE 조회
	  * </pre>
	  */
	public RFANoteConversionProposalDBDAOPriRpScpRtCnoteVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("gen_spcl_rt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.rfaproposal.rfanoteconversionproposal.integration ").append("\n"); 
		query.append("FileName : RFANoteConversionProposalDBDAOPriRpScpRtCnoteVORSQL").append("\n"); 
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
		query.append("SELECT A.PROP_NO" ).append("\n"); 
		query.append(", A.AMDT_SEQ" ).append("\n"); 
		query.append(", A.SVC_SCP_CD" ).append("\n"); 
		query.append(", A.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append(", A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append(", A.CMDT_NOTE_SEQ" ).append("\n"); 
		query.append(", A.NOTE_CLSS_CD" ).append("\n"); 
		query.append(", A.CHG_CD" ).append("\n"); 
		query.append(", A.NOTE_CTNT" ).append("\n"); 
		query.append(", A.NOTE_CONV_MAPG_ID" ).append("\n"); 
		query.append(", A.NOTE_CHG_TP_CD" ).append("\n"); 
		query.append(", A.PRC_PROG_STS_CD" ).append("\n"); 
		query.append(", A.SRC_INFO_CD" ).append("\n"); 
		query.append(", A.N1ST_CMNC_DT" ).append("\n"); 
		query.append("FROM PRI_RP_SCP_RT_CNOTE A" ).append("\n"); 
		query.append(", COM_INTG_CD_DTL B" ).append("\n"); 
		query.append("WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("AND CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("AND A.NOTE_CLSS_CD = B.INTG_CD_VAL_CTNT(+)" ).append("\n"); 
		query.append("AND B.INTG_CD_ID = 'CD01711'" ).append("\n"); 
		query.append("ORDER BY B.INTG_CD_VAL_DP_SEQ, CHG_CD" ).append("\n"); 

	}
}