/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCRateQuotationDBDAOPriSqRtCmdtVOAddGlineCopyCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.16
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.09.16 이승준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Seung-Jun,Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCRateQuotationDBDAOPriSqRtCmdtVOAddGlineCopyCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Gline copy insert
	  * </pre>
	  */
	public SCRateQuotationDBDAOPriSqRtCmdtVOAddGlineCopyCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("estm_mqc_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.integration").append("\n"); 
		query.append("FileName : SCRateQuotationDBDAOPriSqRtCmdtVOAddGlineCopyCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_SQ_RT_CMDT (" ).append("\n"); 
		query.append("QTTN_NO" ).append("\n"); 
		query.append(",	QTTN_VER_NO" ).append("\n"); 
		query.append(",	GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append(",	CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",	CMDT_SEQ" ).append("\n"); 
		query.append(",	PRC_CMDT_TP_CD" ).append("\n"); 
		query.append(",	PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append(",	SRC_INFO_CD" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT  @[qttn_no]" ).append("\n"); 
		query.append(",       @[qttn_ver_no]" ).append("\n"); 
		query.append(",       'G'" ).append("\n"); 
		query.append(",       A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",		A.CMDT_SEQ" ).append("\n"); 
		query.append(",		A.PRC_CMDT_TP_CD" ).append("\n"); 
		query.append(",		A.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append(",       'GC'" ).append("\n"); 
		query.append(",       @[cre_usr_id]" ).append("\n"); 
		query.append(",       SYSDATE" ).append("\n"); 
		query.append(",       @[upd_usr_id]" ).append("\n"); 
		query.append(",       SYSDATE" ).append("\n"); 
		query.append("FROM    PRI_SG_RT_CMDT A" ).append("\n"); 
		query.append("WHERE   1=1" ).append("\n"); 
		query.append("AND    (A.SVC_SCP_CD, A.GLINE_SEQ) =  (" ).append("\n"); 
		query.append("SELECT  SVC_SCP_CD" ).append("\n"); 
		query.append(",       GLINE_SEQ" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT SVC_SCP_CD" ).append("\n"); 
		query.append(", GLINE_SEQ" ).append("\n"); 
		query.append(", ROW_NUMBER() OVER (ORDER BY EFF_DT DESC) AS SEQ" ).append("\n"); 
		query.append("FROM  PRI_SG_MN" ).append("\n"); 
		query.append("WHERE SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND   CFM_FLG = 'Y'" ).append("\n"); 
		query.append("AND   TO_CHAR(EFF_DT,'YYYY-MM-DD') <= @[eff_dt]" ).append("\n"); 
		query.append("AND   TO_CHAR(EXP_DT,'YYYY-MM-DD') >= @[eff_dt]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE SEQ = 1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND   A.PRC_CUST_TP_CD = @[prc_cust_tp_cd]" ).append("\n"); 
		query.append("AND   EXISTS (" ).append("\n"); 
		query.append("SELECT 'X'" ).append("\n"); 
		query.append("FROM PRI_SG_RT B" ).append("\n"); 
		query.append("WHERE A.SVC_SCP_CD = B.SVC_SCP_CD" ).append("\n"); 
		query.append("AND   A.GLINE_SEQ = B.GLINE_SEQ" ).append("\n"); 
		query.append("AND   A.PRC_CUST_TP_CD = B.PRC_CUST_TP_CD" ).append("\n"); 
		query.append("AND   A.CMDT_HDR_SEQ = B.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND   @[estm_mqc_qty] BETWEEN B.MQC_RNG_FM_QTY AND B.MQC_RNG_TO_QTY" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}