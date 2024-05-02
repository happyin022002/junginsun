/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SCRateGuidelineDBDAORsltRtCmdtRnoteListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.10.25
*@LastModifier : 
*@LastVersion : 1.0
* 2013.10.25 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scguideline.scrateguideline.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCRateGuidelineDBDAORsltRtCmdtRnoteListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Rnote조회
	  * * 2013.10.25 전윤주 [CHM-201327107] S/C Note 하 Chassis 항목 추가
	  * </pre>
	  */
	public SCRateGuidelineDBDAORsltRtCmdtRnoteListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
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
		params.put("prc_cust_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gline_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rout_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scguideline.scrateguideline.integration").append("\n"); 
		query.append("FileName : SCRateGuidelineDBDAORsltRtCmdtRnoteListVORSQL").append("\n"); 
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
		query.append("SELECT SVC_SCP_CD," ).append("\n"); 
		query.append("       GLINE_SEQ," ).append("\n"); 
		query.append("       PRC_CUST_TP_CD," ).append("\n"); 
		query.append("       CMDT_HDR_SEQ," ).append("\n"); 
		query.append("       ROUT_SEQ," ).append("\n"); 
		query.append("       ROUT_NOTE_SEQ," ).append("\n"); 
		query.append("       NOTE_CLSS_CD," ).append("\n"); 
		query.append("       CHG_CD," ).append("\n"); 
		query.append("       NOTE_CTNT," ).append("\n"); 
		query.append("       CRE_USR_ID," ).append("\n"); 
		query.append("       CRE_DT," ).append("\n"); 
		query.append("       UPD_USR_ID," ).append("\n"); 
		query.append("       UPD_DT" ).append("\n"); 
		query.append("  FROM PRI_SG_RT_CMDT_RNOTE" ).append("\n"); 
		query.append(" WHERE SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("   AND GLINE_SEQ = @[gline_seq]" ).append("\n"); 
		query.append("   AND PRC_CUST_TP_CD = @[prc_cust_tp_cd]" ).append("\n"); 
		query.append("   AND CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("   AND ROUT_SEQ = @[rout_seq]" ).append("\n"); 
		query.append(" ORDER BY DECODE(NOTE_CLSS_CD, 'G', '1', 'S', '2', 'D', '3', 'C', '4', 'O', '5', '99')" ).append("\n"); 

	}
}