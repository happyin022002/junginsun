/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TAAProposalDBDAOTempVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.26
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.11.26 문동규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.triproposal.taaproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Moon Dong Gyu
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TAAProposalDBDAOTempVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public TAAProposalDBDAOTempVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.triproposal.taaproposal.integration").append("\n"); 
		query.append("FileName : TAAProposalDBDAOTempVORSQL").append("\n"); 
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
		query.append("-- Taa Main" ).append("\n"); 
		query.append("/*" ).append("\n"); 
		query.append("SELECT '' TAA_NO" ).append("\n"); 
		query.append(", '' TAA_PROP_NO" ).append("\n"); 
		query.append(", 0 AMDT_SEQ" ).append("\n"); 
		query.append(", '' SVC_SCP_CD" ).append("\n"); 
		query.append(", SYSDATE EFF_DT" ).append("\n"); 
		query.append(", SYSDATE EXP_DT" ).append("\n"); 
		query.append(", SYSDATE CFM_EXP_DT" ).append("\n"); 
		query.append(", '' CTRT_CUST_CNT_CD" ).append("\n"); 
		query.append(", 0 CTRT_CUST_SEQ" ).append("\n"); 
		query.append(", '' PRC_CTRT_CUST_TP_CD" ).append("\n"); 
		query.append(", '' CTRT_CUST_VAL_SGM_CD" ).append("\n"); 
		query.append(", '' RESPB_SLS_OFC_CD" ).append("\n"); 
		query.append(", '' RESPB_SREP_CD" ).append("\n"); 
		query.append(", '' CFM_FLG" ).append("\n"); 
		query.append(", '' CFM_NM" ).append("\n"); 
		query.append(", '' AS CRE_USR_ID" ).append("\n"); 
		query.append(", SYSDATE AS CRE_DT" ).append("\n"); 
		query.append(", '' AS UPD_USR_ID" ).append("\n"); 
		query.append(", SYSDATE AS UPD_DT" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- Tri List" ).append("\n"); 
		query.append("SELECT '' AS TAA_PROP_NO" ).append("\n"); 
		query.append(", '' AS TAA_NO" ).append("\n"); 
		query.append(", 0 AS AMDT_SEQ" ).append("\n"); 
		query.append(", '' AS TRI_PROP_NO" ).append("\n"); 
		query.append(", 0 AS TRI_AMDT_SEQ" ).append("\n"); 
		query.append(", '' AS ORG_PNT_LOC_CD" ).append("\n"); 
		query.append(", '' AS DEST_PNT_LOC_CD" ).append("\n"); 
		query.append(", '' AS ORG_VIA_PORT_CD" ).append("\n"); 
		query.append(", '' AS DEST_VIA_PORT_CD" ).append("\n"); 
		query.append(", '' AS ORG_PNT_LOC_NM" ).append("\n"); 
		query.append(", '' AS DEST_PNT_LOC_NM" ).append("\n"); 
		query.append(", '' AS ORG_VIA_PORT_NM" ).append("\n"); 
		query.append(", '' AS DEST_VIA_PORT_NM" ).append("\n"); 
		query.append(", '' AS RAT_UT_CD" ).append("\n"); 
		query.append(", '' AS PRC_CGO_TP_CD" ).append("\n"); 
		query.append(", '' AS CURR_CD" ).append("\n"); 
		query.append(", '' AS FNL_FRT_RT_AMT" ).append("\n"); 
		query.append(", '' AS NOTE_CTNT" ).append("\n"); 
		query.append(", '' AS NOTE_CONV_MAPG_ID" ).append("\n"); 
		query.append(", SYSDATE AS EFF_DT" ).append("\n"); 
		query.append(", SYSDATE AS EXP_DT" ).append("\n"); 
		query.append(", '' AS CRE_USR_ID" ).append("\n"); 
		query.append(", SYSDATE AS CRE_DT" ).append("\n"); 
		query.append(", '' AS UPD_USR_ID" ).append("\n"); 
		query.append(", SYSDATE AS UPD_DT" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}