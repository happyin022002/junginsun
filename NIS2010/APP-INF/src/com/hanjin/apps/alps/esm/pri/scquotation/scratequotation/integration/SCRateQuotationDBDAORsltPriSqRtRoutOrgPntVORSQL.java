/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCRateQuotationDBDAORsltPriSqRtRoutOrgPntVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.01
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.12.01 이승준
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

public class SCRateQuotationDBDAORsltPriSqRtRoutOrgPntVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public SCRateQuotationDBDAORsltPriSqRtRoutOrgPntVORSQL(){
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
		params.put("gen_spcl_rt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rout_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.integration").append("\n"); 
		query.append("FileName : SCRateQuotationDBDAORsltPriSqRtRoutOrgPntVORSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("A.QTTN_NO" ).append("\n"); 
		query.append(",	A.QTTN_VER_NO" ).append("\n"); 
		query.append(",	A.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append(",	A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",	A.ROUT_SEQ" ).append("\n"); 
		query.append(",	A.ORG_DEST_TP_CD" ).append("\n"); 
		query.append(",	A.ROUT_PNT_SEQ" ).append("\n"); 
		query.append(",	A.ROUT_PNT_LOC_TP_CD" ).append("\n"); 
		query.append(",	A.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append(",	A.RCV_DE_TERM_CD" ).append("\n"); 
		query.append(",	A.PRC_TRSP_MOD_CD" ).append("\n"); 
		query.append(",	A.SRC_INFO_CD" ).append("\n"); 
		query.append(",	A.CRE_USR_ID" ).append("\n"); 
		query.append(",	A.CRE_DT" ).append("\n"); 
		query.append(",	A.UPD_USR_ID" ).append("\n"); 
		query.append(",	A.UPD_DT" ).append("\n"); 
		query.append(",	DECODE(A.ROUT_PNT_LOC_TP_CD," ).append("\n"); 
		query.append("'G',                                                 --GROUP LOCATION" ).append("\n"); 
		query.append("(SELECT PRC_GRP_LOC_DESC" ).append("\n"); 
		query.append("FROM PRI_SQ_GRP_LOC" ).append("\n"); 
		query.append("WHERE QTTN_NO = A.QTTN_NO" ).append("\n"); 
		query.append("AND QTTN_VER_NO = A.QTTN_VER_NO" ).append("\n"); 
		query.append("AND PRC_GRP_LOC_CD = A.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("AND ROWNUM = 1)," ).append("\n"); 
		query.append("'R'," ).append("\n"); 
		query.append("(SELECT RGN_NM                                       --REGION" ).append("\n"); 
		query.append("FROM MDM_REGION" ).append("\n"); 
		query.append("WHERE RGN_CD = A.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("AND ROWNUM = 1)," ).append("\n"); 
		query.append("'C',                                                --COUNTRY" ).append("\n"); 
		query.append("(SELECT CNT_NM" ).append("\n"); 
		query.append("FROM MDM_COUNTRY" ).append("\n"); 
		query.append("WHERE CNT_CD = A.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("AND ROWNUM = 1)," ).append("\n"); 
		query.append("'L',                                                --LOCATION" ).append("\n"); 
		query.append("(SELECT LOC_NM" ).append("\n"); 
		query.append("FROM MDM_LOCATION" ).append("\n"); 
		query.append("WHERE LOC_CD = A.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("AND ROWNUM = 1)) AS ROUT_PNT_LOC_DEF_NM" ).append("\n"); 
		query.append(",	(SELECT INTG_CD_VAL_DESC" ).append("\n"); 
		query.append("FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("WHERE INTG_CD_ID = 'CD02138'" ).append("\n"); 
		query.append("AND   INTG_CD_VAL_CTNT = A.RCV_DE_TERM_CD) AS RCV_DE_TERM_NM" ).append("\n"); 
		query.append("FROM PRI_SQ_RT_ROUT_PNT A" ).append("\n"); 
		query.append("WHERE	A.QTTN_NO = @[qttn_no]" ).append("\n"); 
		query.append("AND	A.QTTN_VER_NO = @[qttn_ver_no]" ).append("\n"); 
		query.append("AND	A.GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("AND	A.CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("AND	A.ROUT_SEQ = @[rout_seq]" ).append("\n"); 
		query.append("AND	A.ORG_DEST_TP_CD = 'O'" ).append("\n"); 
		query.append("ORDER BY DECODE(A.ROUT_PNT_LOC_TP_CD, 'C', '1', 'R', '2', 'G', '3', 'L', '4'), A.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 

	}
}