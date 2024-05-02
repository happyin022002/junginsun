/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFAGroupLocationGuidelineDBDAORsltPriRgGrpLocExcelRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.07
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.08.07 최성민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaguideline.rfagrouplocationguideline.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI SUNG MIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAGroupLocationGuidelineDBDAORsltPriRgGrpLocExcelRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GroupLocation Excel조회
	  * </pre>
	  */
	public RFAGroupLocationGuidelineDBDAORsltPriRgGrpLocExcelRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.pri.rfaguideline.rfagrouplocationguideline.integration").append("\n"); 
		query.append("FileName : RFAGroupLocationGuidelineDBDAORsltPriRgGrpLocExcelRSQL").append("\n"); 
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
		query.append("SELECT A.SVC_SCP_CD," ).append("\n"); 
		query.append("A.GLINE_SEQ," ).append("\n"); 
		query.append("A.GRP_LOC_SEQ," ).append("\n"); 
		query.append("B.GRP_LOC_DTL_SEQ," ).append("\n"); 
		query.append("A.ORG_DEST_TP_CD," ).append("\n"); 
		query.append("(SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("WHERE INTG_CD_ID = 'CD02166'" ).append("\n"); 
		query.append("AND INTG_CD_VAL_CTNT = A.ORG_DEST_TP_CD ) AS ORG_DEST_TP_DESC," ).append("\n"); 
		query.append("A.PRC_GRP_LOC_CD," ).append("\n"); 
		query.append("A.PRC_GRP_LOC_DESC," ).append("\n"); 
		query.append("B.LOC_CD," ).append("\n"); 
		query.append("C.LOC_NM," ).append("\n"); 
		query.append("C.SCONTI_CD," ).append("\n"); 
		query.append("(SELECT SCONTI_NM" ).append("\n"); 
		query.append("FROM MDM_SUBCONTINENT" ).append("\n"); 
		query.append("WHERE SCONTI_CD = C.SCONTI_CD" ).append("\n"); 
		query.append("AND ROWNUM = 1) AS SCONTI_NM" ).append("\n"); 
		query.append("FROM PRI_RG_GRP_LOC A, PRI_RG_GRP_LOC_DTL B, MDM_LOCATION C" ).append("\n"); 
		query.append("WHERE A.SVC_SCP_CD = B.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("AND A.GLINE_SEQ = B.GLINE_SEQ(+)" ).append("\n"); 
		query.append("AND A.GRP_LOC_SEQ = B.GRP_LOC_SEQ(+)" ).append("\n"); 
		query.append("AND B.LOC_CD = C.LOC_CD(+)" ).append("\n"); 
		query.append("AND A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND A.GLINE_SEQ = @[gline_seq]" ).append("\n"); 
		query.append("ORDER BY A.ORG_DEST_TP_CD DESC" ).append("\n"); 
		query.append(", A.PRC_GRP_LOC_CD ASC" ).append("\n"); 

	}
}