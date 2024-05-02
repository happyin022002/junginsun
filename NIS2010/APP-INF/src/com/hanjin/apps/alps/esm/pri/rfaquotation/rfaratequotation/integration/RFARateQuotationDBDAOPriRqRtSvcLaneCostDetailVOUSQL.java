/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RFARateQuotationDBDAOPriRqRtSvcLaneCostDetailVOUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.12
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2010.01.12 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG MIN SEOK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFARateQuotationDBDAOPriRqRtSvcLaneCostDetailVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * pri_rq_rt를 일괄 조정한다.
	  * </pre>
	  */
	public RFARateQuotationDBDAOPriRqRtSvcLaneCostDetailVOUSQL(){
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
		params.put("qttn_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("qttn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rout_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.integration").append("\n"); 
		query.append("FileName : RFARateQuotationDBDAOPriRqRtSvcLaneCostDetailVOUSQL").append("\n"); 
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
		query.append("" ).append("\n"); 
		query.append("MERGE INTO PRI_RQ_RT A " ).append("\n"); 
		query.append("USING (" ).append("\n"); 
		query.append("        SELECT A.QTTN_NO, A.QTTN_VER_NO" ).append("\n"); 
		query.append("              ,A.CMDT_HDR_SEQ, A.ROUT_SEQ, A.RT_SEQ" ).append("\n"); 
		query.append("              ,DECODE(COST_ROUT_NO, '1', SUBSTR(N1ST_RLANE_CD, 1,3), '2', SUBSTR(N2ND_RLANE_CD, 1,3), '3', SUBSTR(N3RD_RLANE_CD, 1,3), '4', SUBSTR(N4TH_RLANE_CD, 1,3))" ).append("\n"); 
		query.append("               AS SVC_LANE" ).append("\n"); 
		query.append("         FROM  PRI_RQ_RT_USD_ROUT_CS A" ).append("\n"); 
		query.append("              ,PRI_PRS_USD_ROUT_CS_INFO B" ).append("\n"); 
		query.append("        WHERE  A.QTTN_NO = @[qttn_no]" ).append("\n"); 
		query.append("          AND  A.QTTN_VER_NO = @[qttn_ver_no]" ).append("\n"); 
		query.append("		  AND  A.CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("          AND  A.ROUT_SEQ = @[rout_seq]" ).append("\n"); 
		query.append("          AND  A.RT_SEQ = @[rt_seq]" ).append("\n"); 
		query.append("          AND  A.USD_ROUT_CS_SEL_FLG = 'Y'" ).append("\n"); 
		query.append("          AND  A.ROUT_CS_SRC_DT = B.ROUT_CS_SRC_DT" ).append("\n"); 
		query.append("          AND  A.ROUT_CS_NO = B.ROUT_CS_NO" ).append("\n"); 
		query.append("    ) B" ).append("\n"); 
		query.append("ON (" ).append("\n"); 
		query.append("   A.QTTN_NO = B.QTTN_NO" ).append("\n"); 
		query.append("   AND  A.QTTN_VER_NO = B.QTTN_VER_NO" ).append("\n"); 
		query.append("   AND  A.CMDT_HDR_SEQ = B.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("   AND  A.ROUT_SEQ = B.ROUT_SEQ" ).append("\n"); 
		query.append("   AND  A.RT_SEQ = B.RT_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE SET A.VSL_SLAN_CD = B.SVC_LANE" ).append("\n"); 

	}
}