/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFAGroupCommodityGuidelineDBDAOPriRgGrpCmdtDtlVORSQL.java
*@FileTitle : RFA Guideline Creation - Arbitrary[Load Excel]
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.30
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.07.30 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaguideline.rfagroupcommodityguideline.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI SUNG MIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAGroupCommodityGuidelineDBDAOPriRgGrpCmdtDtlVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Commodity Guideline Detail Select
	  * </pre>
	  */
	public RFAGroupCommodityGuidelineDBDAOPriRgGrpCmdtDtlVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("grp_cmdt_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("gline_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaguideline.rfagroupcommodityguideline.integration").append("\n"); 
		query.append("FileName : RFAGroupCommodityGuidelineDBDAOPriRgGrpCmdtDtlVORSQL").append("\n"); 
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
		query.append("SELECT A.SVC_SCP_CD" ).append("\n"); 
		query.append(", A.GLINE_SEQ" ).append("\n"); 
		query.append(", A.GRP_CMDT_SEQ" ).append("\n"); 
		query.append(", A.GRP_CMDT_DTL_SEQ" ).append("\n"); 
		query.append(", A.PRC_CMDT_TP_CD" ).append("\n"); 
		query.append(", A.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append(", CASE WHEN A.PRC_CMDT_TP_CD = 'C' THEN B.CMDT_NM" ).append("\n"); 
		query.append("WHEN A.PRC_CMDT_TP_CD = 'R' THEN C.REP_CMDT_NM" ).append("\n"); 
		query.append("END LOC_DES" ).append("\n"); 
		query.append(", TO_CHAR(A.CRE_DT,'YYYYMMDD') CRE_DT" ).append("\n"); 
		query.append("FROM PRI_RG_GRP_CMDT_DTL A" ).append("\n"); 
		query.append(", MDM_COMMODITY B" ).append("\n"); 
		query.append(", MDM_REP_CMDT C" ).append("\n"); 
		query.append("WHERE A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND A.GLINE_SEQ = @[gline_seq]" ).append("\n"); 
		query.append("AND A.GRP_CMDT_SEQ = @[grp_cmdt_seq]" ).append("\n"); 
		query.append("AND A.PRC_CMDT_DEF_CD = B.CMDT_CD(+)" ).append("\n"); 
		query.append("AND A.PRC_CMDT_DEF_CD = C.REP_CMDT_CD(+)" ).append("\n"); 
		query.append("ORDER BY A.PRC_CMDT_TP_CD DESC, A.PRC_CMDT_DEF_CD" ).append("\n"); 

	}
}