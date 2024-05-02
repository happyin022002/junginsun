/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : RFATransportationAdditionalChargeProposalDBDAORsltCdListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.24
*@LastModifier : 이은섭
*@LastVersion : 1.0
* 2012.10.24 이은섭
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Eun-Sup Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFATransportationAdditionalChargeProposalDBDAORsltCdListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 공통코드 조회
	  * </pre>
	  */
	public RFATransportationAdditionalChargeProposalDBDAORsltCdListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etc6",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etc7",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etc4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etc8",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etc9",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("etc1",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("etc10",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etc2",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.integration").append("\n"); 
		query.append("FileName : RFATransportationAdditionalChargeProposalDBDAORsltCdListVORSQL").append("\n"); 
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
		query.append("#if (${code_tp} == 'LOC') " ).append("\n"); 
		query.append("SELECT LOC_CD CD" ).append("\n"); 
		query.append("	 , LOC_NM NM" ).append("\n"); 
		query.append("  FROM MDM_LOCATION" ).append("\n"); 
		query.append(" WHERE LOC_CD = @[cd]" ).append("\n"); 
		query.append("   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${code_tp} == 'GRP') " ).append("\n"); 
		query.append("SELECT PRC_GRP_LOC_CD CD" ).append("\n"); 
		query.append("     , PRC_GRP_LOC_DESC NM" ).append("\n"); 
		query.append("  FROM PRI_RP_SCP_GRP_LOC" ).append("\n"); 
		query.append(" WHERE SVC_SCP_CD 	= @[svc_scp_cd]" ).append("\n"); 
		query.append("   AND PROP_NO 		= @[prop_no]" ).append("\n"); 
		query.append("   AND AMDT_SEQ 	= @[amdt_seq]" ).append("\n"); 
		query.append("   AND PRC_GRP_LOC_CD  = @[cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${code_tp} == 'CUST') " ).append("\n"); 
		query.append("SELECT A.CUST_CNT_CD||LPAD(A.CUST_SEQ,6,0) CD" ).append("\n"); 
		query.append("     , B.CUST_LGL_ENG_NM NM" ).append("\n"); 
		query.append("  FROM PRI_RP_SCP_RT_ACT_CUST A" ).append("\n"); 
		query.append("     , MDM_CUSTOMER B" ).append("\n"); 
		query.append(" WHERE A.CUST_CNT_CD 	= B.CUST_CNT_CD" ).append("\n"); 
		query.append("   AND A.CUST_SEQ 		= B.CUST_SEQ" ).append("\n"); 
		query.append("   AND A.PROP_NO 		= @[prop_no]" ).append("\n"); 
		query.append("   AND A.AMDT_SEQ 		= @[amdt_seq]" ).append("\n"); 
		query.append("   AND A.SVC_SCP_CD 	= @[svc_scp_cd]" ).append("\n"); 
		query.append("   AND A.CUST_CNT_CD 	= @[cd]" ).append("\n"); 
		query.append("   AND A.CUST_SEQ 		= @[etc1]" ).append("\n"); 
		query.append("   AND B.CNTR_DIV_FLG 	= 'Y'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${code_tp} == 'ARBI_DUP') " ).append("\n"); 
		query.append("SELECT PROP_NO CD" ).append("\n"); 
		query.append("  FROM PRI_RP_SCP_TRSP_ADD_CHG" ).append("\n"); 
		query.append(" WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("       AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("       AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("       AND ADD_CHG_TP_CD = @[etc1]" ).append("\n"); 
		query.append("       AND ORG_DEST_TP_CD = @[etc2]" ).append("\n"); 
		query.append("       AND BSE_PORT_DEF_CD = @[etc4]" ).append("\n"); 
		query.append("       AND ROUT_PNT_LOC_DEF_CD = @[etc6]" ).append("\n"); 
		query.append("       AND RAT_UT_CD = @[etc7]" ).append("\n"); 
		query.append("       AND PRC_CGO_TP_CD = @[etc8]" ).append("\n"); 
		query.append("       AND PRC_TRSP_MOD_CD = @[etc9]" ).append("\n"); 
		query.append("       AND RCV_DE_TERM_CD = @[etc10]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}