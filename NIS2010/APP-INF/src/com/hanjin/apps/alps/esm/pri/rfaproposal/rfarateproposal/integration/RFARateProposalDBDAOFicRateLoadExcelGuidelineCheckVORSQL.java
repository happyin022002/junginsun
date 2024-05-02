/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : RFARateProposalDBDAOFicRateLoadExcelGuidelineCheckVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.11
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2012.07.11 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG MIN SEOK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFARateProposalDBDAOFicRateLoadExcelGuidelineCheckVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Load Excel 중 IHC 데이터를 조회 하기 위한  parameter VO
	  * </pre>
	  */
	public RFARateProposalDBDAOFicRateLoadExcelGuidelineCheckVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.integration").append("\n"); 
		query.append("FileName : RFARateProposalDBDAOFicRateLoadExcelGuidelineCheckVORSQL").append("\n"); 
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
		query.append("SELECT 	'' AS H_SEQ" ).append("\n"); 
		query.append("	,'' AS CMDT_DP_SEQ" ).append("\n"); 
		query.append("	,'' AS ROUT_DP_SEQ" ).append("\n"); 
		query.append("	,'' AS DEST_ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("	,'' AS DEST_ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("	,'' AS DEST_RCV_DE_TERM_NM" ).append("\n"); 
		query.append("	,'' AS DEST_PRC_TRSP_MOD_NM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	,'' AS ORG_ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("	,'' AS ORG_ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("	,'' AS ORG_RCV_DE_TERM_NM" ).append("\n"); 
		query.append("	,'' AS ORG_PRC_TRSP_MOD_NM" ).append("\n"); 
		query.append("	,'' AS PROP_NO" ).append("\n"); 
		query.append("	,'' AS AMDT_SEQ" ).append("\n"); 
		query.append("	,'' AS SVC_SCP_CD" ).append("\n"); 
		query.append("	,'' AS CMDT_HDR_SEQ" ).append("\n"); 
		query.append("	,'' AS EFF_DT" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}