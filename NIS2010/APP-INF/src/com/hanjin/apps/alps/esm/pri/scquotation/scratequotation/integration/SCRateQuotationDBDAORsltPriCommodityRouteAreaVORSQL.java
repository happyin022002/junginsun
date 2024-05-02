/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCRateQuotationDBDAORsltPriCommodityRouteAreaVORSQL.java
*@FileTitle : S/C Quotation - Rate Adjust
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.19
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2009.08.19 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG MIN SEOK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCRateQuotationDBDAORsltPriCommodityRouteAreaVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public SCRateQuotationDBDAORsltPriCommodityRouteAreaVORSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.integration").append("\n"); 
		query.append("FileName : SCRateQuotationDBDAORsltPriCommodityRouteAreaVORSQL").append("\n"); 
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
		query.append("SELECT RN, QTTN_NO,QTTN_VER_NO, GEN_SPCL_RT_TP_CD ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append(", MAX(ORI_LOC_DEF_CD) AS ORI_LOC_DEF_CD" ).append("\n"); 
		query.append(", MAX(DEST_LOC_DEF_CD) AS DEST_LOC_DEF_CD" ).append("\n"); 
		query.append(", MAX(ORI_VIA_DEF_CD) AS ORI_VIA_DEF_CD" ).append("\n"); 
		query.append(", MAX(DEST_VIA_DEF_CD) AS DEST_VIA_DEF_CD" ).append("\n"); 
		query.append("from (" ).append("\n"); 
		query.append("SELECT ROWNUM AS RN, QTTN_NO, QTTN_VER_NO,GEN_SPCL_RT_TP_CD ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",ROUT_PNT_LOC_DEF_CD AS ORI_LOC_DEF_CD , '' AS DEST_LOC_DEF_CD , '' AS ORI_VIA_DEF_CD, '' AS DEST_VIA_DEF_CD" ).append("\n"); 
		query.append("FROM PRI_SQ_RT_ROUT_PNT" ).append("\n"); 
		query.append("WHERE QTTN_NO = @[qttn_no]" ).append("\n"); 
		query.append("AND QTTN_VER_NO = @[qttn_ver_no]" ).append("\n"); 
		query.append("AND GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("AND CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("AND ORG_DEST_TP_CD = 'O'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT ROWNUM AS RN, QTTN_NO, QTTN_VER_NO,GEN_SPCL_RT_TP_CD ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",'' AS ORI_LOC_DEF_CD , ROUT_PNT_LOC_DEF_CD AS DEST_LOC_DEF_CD, '' AS ORI_VIA_DEF_CD, '' AS DEST_VIA_DEF_CD" ).append("\n"); 
		query.append("FROM PRI_SQ_RT_ROUT_PNT" ).append("\n"); 
		query.append("WHERE QTTN_NO = @[qttn_no]" ).append("\n"); 
		query.append("AND QTTN_VER_NO = @[qttn_ver_no]" ).append("\n"); 
		query.append("AND GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("AND CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("AND ORG_DEST_TP_CD = 'D'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT ROWNUM AS RN, QTTN_NO, QTTN_VER_NO,GEN_SPCL_RT_TP_CD ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",'' AS ORI_LOC_DEF_CD, '' AS DEST_LOC_DEF_CD ,ROUT_VIA_PORT_DEF_CD AS ORI_VIA_DEF_CD , '' AS DEST_VIA_DEF_CD" ).append("\n"); 
		query.append("FROM PRI_SQ_RT_ROUT_VIA" ).append("\n"); 
		query.append("WHERE QTTN_NO = @[qttn_no]" ).append("\n"); 
		query.append("AND QTTN_VER_NO = @[qttn_ver_no]" ).append("\n"); 
		query.append("AND GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("AND CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("AND ORG_DEST_TP_CD = 'O'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT ROWNUM AS RN, QTTN_NO, QTTN_VER_NO,GEN_SPCL_RT_TP_CD ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",'' AS ORI_LOC_DEF_CD, '' AS DEST_LOC_DEF_CD, '' AS ORI_VIA_DEF_CD ,ROUT_VIA_PORT_DEF_CD AS DEST_VIA_DEF_CD" ).append("\n"); 
		query.append("FROM PRI_SQ_RT_ROUT_VIA" ).append("\n"); 
		query.append("WHERE QTTN_NO = @[qttn_no]" ).append("\n"); 
		query.append("AND QTTN_VER_NO = @[qttn_ver_no]" ).append("\n"); 
		query.append("AND GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("AND CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("AND ORG_DEST_TP_CD = 'D'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("group by RN, QTTN_NO,QTTN_VER_NO, GEN_SPCL_RT_TP_CD ,CMDT_HDR_SEQ" ).append("\n"); 

	}
}