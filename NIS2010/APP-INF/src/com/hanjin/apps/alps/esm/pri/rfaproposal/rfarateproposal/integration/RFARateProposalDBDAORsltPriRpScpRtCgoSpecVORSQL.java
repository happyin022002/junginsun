/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFARateProposalDBDAORsltPriRpScpRtCgoSpecVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.07
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.09.07 김재연
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author JaeYeon Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFARateProposalDBDAORsltPriRpScpRtCgoSpecVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Rate Specification을 조회한다.
	  * </pre>
	  */
	public RFARateProposalDBDAORsltPriRpScpRtCgoSpecVORSQL(){
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
		params.put("rt_seq",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rout_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.integration").append("\n"); 
		query.append("FileName : RFARateProposalDBDAORsltPriRpScpRtCgoSpecVORSQL").append("\n"); 
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
		query.append(", A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append(", A.ROUT_SEQ" ).append("\n"); 
		query.append(", A.RT_SEQ" ).append("\n"); 
		query.append(", B.RAT_UT_CD" ).append("\n"); 
		query.append(", B.CNTR_LEN" ).append("\n"); 
		query.append(", B.CNTR_WDT" ).append("\n"); 
		query.append(", B.CNTR_HGT" ).append("\n"); 
		query.append(", B.CNTR_WGT" ).append("\n"); 
		query.append(", DECODE(C.ACT_CGO_LEN, NULL, '.00', TO_CHAR(C.ACT_CGO_LEN, 'FM999,999,999.00')) AS ACT_CGO_LEN" ).append("\n"); 
		query.append(", DECODE(C.ACT_CGO_WDT, NULL, '.00', TO_CHAR(C.ACT_CGO_WDT, 'FM999,999,999.00')) AS ACT_CGO_WDT" ).append("\n"); 
		query.append(", DECODE(C.ACT_CGO_HGT, NULL, '.00', TO_CHAR(C.ACT_CGO_HGT, 'FM999,999,999.00')) AS ACT_CGO_HGT" ).append("\n"); 
		query.append(", DECODE(C.ACT_CGO_WGT, NULL, '.00', TO_CHAR(C.ACT_CGO_WGT, 'FM999,999,999.00')) AS ACT_CGO_WGT" ).append("\n"); 
		query.append(", C.CGO_SPEC_RMK" ).append("\n"); 
		query.append("FROM PRI_RP_SCP_RT A" ).append("\n"); 
		query.append(", PRI_RAT_UT B" ).append("\n"); 
		query.append(", PRI_RP_SCP_RT_CGO_SPEC C" ).append("\n"); 
		query.append("WHERE A.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND A.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND A.CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("AND A.ROUT_SEQ = @[rout_seq]" ).append("\n"); 
		query.append("AND A.RT_SEQ = @[rt_seq]" ).append("\n"); 
		query.append("AND B.RAT_UT_CD = A.RAT_UT_CD" ).append("\n"); 
		query.append("AND B.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND C.PROP_NO(+) = A.PROP_NO" ).append("\n"); 
		query.append("AND C.AMDT_SEQ(+) = A.AMDT_SEQ" ).append("\n"); 
		query.append("AND C.SVC_SCP_CD(+) = A.SVC_SCP_CD" ).append("\n"); 
		query.append("AND C.CMDT_HDR_SEQ(+) = A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND C.ROUT_SEQ(+) = A.ROUT_SEQ" ).append("\n"); 
		query.append("AND C.RT_SEQ(+) = A.RT_SEQ" ).append("\n"); 

	}
}