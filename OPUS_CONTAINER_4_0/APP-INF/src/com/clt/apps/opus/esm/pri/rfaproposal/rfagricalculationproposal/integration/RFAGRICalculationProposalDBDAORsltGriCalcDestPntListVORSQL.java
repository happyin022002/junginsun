/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RFAGRICalculationProposalDBDAORsltGriCalcDestPntListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.12
*@LastModifier : 박성수
*@LastVersion : 1.0
* 2010.01.12 박성수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaproposal.rfagricalculationproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sungsoo Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAGRICalculationProposalDBDAORsltGriCalcDestPntListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GRI Calc. Destination 조회
	  * </pre>
	  */
	public RFAGRICalculationProposalDBDAORsltGriCalcDestPntListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gri_grp_seq",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.rfaproposal.rfagricalculationproposal.integration").append("\n"); 
		query.append("FileName : RFAGRICalculationProposalDBDAORsltGriCalcDestPntListVORSQL").append("\n"); 
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
		query.append("SELECT PROP_NO" ).append("\n"); 
		query.append(",AMDT_SEQ" ).append("\n"); 
		query.append(",SVC_SCP_CD" ).append("\n"); 
		query.append(",GRI_GRP_SEQ" ).append("\n"); 
		query.append(",ORG_DEST_TP_CD" ).append("\n"); 
		query.append(",GRI_ROUT_PNT_SEQ" ).append("\n"); 
		query.append(",ROUT_PNT_LOC_TP_CD" ).append("\n"); 
		query.append(",ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append(",DECODE(ROUT_PNT_LOC_TP_CD" ).append("\n"); 
		query.append(",'G'" ).append("\n"); 
		query.append(",(SELECT PRC_GRP_LOC_DESC" ).append("\n"); 
		query.append("FROM PRI_RP_SCP_GRP_LOC" ).append("\n"); 
		query.append("WHERE PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("AND AMDT_SEQ = A.AMDT_SEQ" ).append("\n"); 
		query.append("AND SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("AND PRC_GRP_LOC_CD = A.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("AND ROWNUM = 1)" ).append("\n"); 
		query.append(",'C'" ).append("\n"); 
		query.append(",(SELECT CNT_NM" ).append("\n"); 
		query.append("FROM MDM_COUNTRY" ).append("\n"); 
		query.append("WHERE CNT_CD = A.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("AND ROWNUM = 1)" ).append("\n"); 
		query.append(",'L'" ).append("\n"); 
		query.append(",(SELECT LOC_NM" ).append("\n"); 
		query.append("FROM MDM_LOCATION" ).append("\n"); 
		query.append("WHERE LOC_CD = A.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("AND ROWNUM = 1)) AS ROUT_PNT_LOC_DEF_NM" ).append("\n"); 
		query.append(",RCV_DE_TERM_CD" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append("FROM PRI_RP_SCP_GRI_ROUT_PNT A" ).append("\n"); 
		query.append("WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND GRI_GRP_SEQ = @[gri_grp_seq]" ).append("\n"); 
		query.append("AND ORG_DEST_TP_CD = 'D'" ).append("\n"); 
		query.append("ORDER BY DECODE(ROUT_PNT_LOC_TP_CD, 'C', '1', 'G', '2', 'L', '3'), ROUT_PNT_LOC_DEF_CD" ).append("\n"); 

	}
}