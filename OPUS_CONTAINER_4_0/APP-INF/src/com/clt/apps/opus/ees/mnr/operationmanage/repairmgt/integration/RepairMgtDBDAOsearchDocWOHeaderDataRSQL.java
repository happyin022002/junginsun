/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RepairMgtDBDAOsearchDocWOHeaderDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.18
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.18 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RepairMgtDBDAOsearchDocWOHeaderDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchDocWOHeaderData
	  * </pre>
	  */
	public RepairMgtDBDAOsearchDocWOHeaderDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.integration").append("\n"); 
		query.append("FileName : RepairMgtDBDAOsearchDocWOHeaderDataRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("(A.MNR_ORD_OFC_CTY_CD || A.MNR_ORD_SEQ) MNR_ORD_SEQ " ).append("\n"); 
		query.append(",A.MNR_WO_TP_CD  WO_TYPE_CODE" ).append("\n"); 
		query.append(",A.MNR_GRP_TP_CD" ).append("\n"); 
		query.append(",D.MNR_CD_DESC WO_TYPE" ).append("\n"); 
		query.append(",MNR_COMMON_PKG.MNR_CONV_PARTNER_CD_FNC(A.VNDR_SEQ) VNDR_SEQ" ).append("\n"); 
		query.append(",B.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append(",C.TRSM_MOD_CD" ).append("\n"); 
		query.append("--,DECODE(A.MNR_WO_TP_CD,'EST', 'Repair Approval(WO#: '|| (A.MNR_ORD_OFC_CTY_CD || A.MNR_ORD_SEQ) || ')'" ).append("\n"); 
		query.append("--                            , 'MNR WO Notice(WO#: ' || (A.MNR_ORD_OFC_CTY_CD || A.MNR_ORD_SEQ) || ')'" ).append("\n"); 
		query.append("--        ) DOC_SUBJECT" ).append("\n"); 
		query.append(", 'MNR WORK ORDER ' || (A.MNR_ORD_OFC_CTY_CD || A.MNR_ORD_SEQ) AS DOC_SUBJECT" ).append("\n"); 
		query.append(",C.FAX_NO" ).append("\n"); 
		query.append(",C.MNR_PRNR_EML" ).append("\n"); 
		query.append(",C.EDI_ID" ).append("\n"); 
		query.append("FROM MNR_ORD_HDR A, MDM_VENDOR B, MNR_PARTNER C, MNR_GEN_CD D, MNR_RPR_RQST_HDR L" ).append("\n"); 
		query.append("WHERE A.VNDR_SEQ = B.VNDR_SEQ(+)" ).append("\n"); 
		query.append("AND A.COST_OFC_CD = C.CTRL_OFC_CD" ).append("\n"); 
		query.append("AND   A.VNDR_SEQ = C.MNR_PRNR_SEQ(+)" ).append("\n"); 
		query.append("AND	A.MNR_ORD_OFC_CTY_CD IN (" ).append("\n"); 
		query.append("	#foreach ($user_mnrOrdOfcCtyCds IN ${mnrOrdOfcCtyCds})" ).append("\n"); 
		query.append("		#if($velocityCount < $mnrOrdOfcCtyCds.size())" ).append("\n"); 
		query.append("			'$user_mnrOrdOfcCtyCds'," ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			'$user_mnrOrdOfcCtyCds'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end			  " ).append("\n"); 
		query.append(")	" ).append("\n"); 
		query.append("AND A.MNR_ORD_SEQ in (${mnr_ord_seq})" ).append("\n"); 
		query.append("AND D.PRNT_CD_ID(+)='CD00020'" ).append("\n"); 
		query.append("AND A.MNR_WO_TP_CD = D.MNR_CD_ID(+)" ).append("\n"); 
		query.append("AND A.MNR_ORD_SEQ = L.MNR_ORD_SEQ(+)" ).append("\n"); 
		query.append("AND A.MNR_ORD_OFC_CTY_CD = L.MNR_ORD_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("AND A.AGMT_OFC_CTY_CD = C.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("AND A.AGMT_SEQ = C.AGMT_SEQ" ).append("\n"); 
		query.append("AND A.AGMT_VER_NO = C.AGMT_VER_NO" ).append("\n"); 

	}
}