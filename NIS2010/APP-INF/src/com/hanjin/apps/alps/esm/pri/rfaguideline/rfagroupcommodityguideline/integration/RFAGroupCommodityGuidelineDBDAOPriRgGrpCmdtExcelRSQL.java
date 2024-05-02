/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFAGroupCommodityGuidelineDBDAOPriRgGrpCmdtExcelRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.08
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.10.08 최성민
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

public class RFAGroupCommodityGuidelineDBDAOPriRgGrpCmdtExcelRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EXCEL 다운로드
	  * </pre>
	  */
	public RFAGroupCommodityGuidelineDBDAOPriRgGrpCmdtExcelRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		query.append("FileName : RFAGroupCommodityGuidelineDBDAOPriRgGrpCmdtExcelRSQL").append("\n"); 
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
		query.append("SELECT B.PRC_GRP_CMDT_CD," ).append("\n"); 
		query.append("B.PRC_GRP_CMDT_DESC," ).append("\n"); 
		query.append("A.PRC_CMDT_DEF_CD," ).append("\n"); 
		query.append("CASE WHEN A.PRC_CMDT_TP_CD = 'C' THEN C.CMDT_NM" ).append("\n"); 
		query.append("WHEN A.PRC_CMDT_TP_CD = 'R' THEN D.REP_CMDT_NM" ).append("\n"); 
		query.append("END CMDT_NM" ).append("\n"); 
		query.append("FROM PRI_RG_GRP_CMDT_DTL A" ).append("\n"); 
		query.append(", PRI_RG_GRP_CMDT B" ).append("\n"); 
		query.append(", MDM_COMMODITY C" ).append("\n"); 
		query.append(", MDM_REP_CMDT D" ).append("\n"); 
		query.append("WHERE B.SVC_SCP_CD 		= A.SVC_SCP_CD" ).append("\n"); 
		query.append("AND   B.GLINE_SEQ 		= A.GLINE_SEQ" ).append("\n"); 
		query.append("AND   B.GRP_CMDT_SEQ 	= A.GRP_CMDT_SEQ" ).append("\n"); 
		query.append("AND A.PRC_CMDT_DEF_CD = C.CMDT_CD(+)" ).append("\n"); 
		query.append("AND A.PRC_CMDT_DEF_CD = D.REP_CMDT_CD(+)" ).append("\n"); 
		query.append("AND   B.SVC_SCP_CD 		= @[svc_scp_cd]" ).append("\n"); 
		query.append("AND   B.GLINE_SEQ 		= @[gline_seq]" ).append("\n"); 
		query.append("ORDER BY B.PRC_GRP_CMDT_CD, A.PRC_CMDT_DEF_CD" ).append("\n"); 

	}
}