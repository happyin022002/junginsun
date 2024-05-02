/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCRateQuotationDBDAORsltPriCommodityRouteVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.23
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2009.09.23 송민석
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

public class SCRateQuotationDBDAORsltPriCommodityRouteVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public SCRateQuotationDBDAORsltPriCommodityRouteVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		query.append("FileName : SCRateQuotationDBDAORsltPriCommodityRouteVORSQL").append("\n"); 
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
		query.append("SELECT 	 CMDT.QTTN_NO,CMDT.QTTN_VER_NO" ).append("\n"); 
		query.append(",CMDT.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append(",CMDT.CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",SUBSTR(MAX(SYS_CONNECT_BY_PATH(PRC_CMDT_DEF_CD , ' / ')),3) AS CMDT_NM" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT QTTN_NO,QTTN_VER_NO" ).append("\n"); 
		query.append(",GEN_SPCL_RT_TP_CD ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",CMDT_SEQ,PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append(",ROW_NUMBER() OVER(PARTITION BY QTTN_NO" ).append("\n"); 
		query.append(",QTTN_VER_NO" ).append("\n"); 
		query.append(",GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append(",CMDT_HDR_SEQ" ).append("\n"); 
		query.append("ORDER BY QTTN_NO" ).append("\n"); 
		query.append(",QTTN_VER_NO" ).append("\n"); 
		query.append(",PRC_CMDT_TP_CD DESC" ).append("\n"); 
		query.append(",GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append(",CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",CMDT_SEQ) AS RN" ).append("\n"); 
		query.append("FROM PRI_SQ_RT_CMDT" ).append("\n"); 
		query.append("WHERE QTTN_NO = @[qttn_no]" ).append("\n"); 
		query.append("AND QTTN_VER_NO = @[qttn_ver_no]" ).append("\n"); 
		query.append("AND GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") CMDT" ).append("\n"); 
		query.append("START WITH RN = 1" ).append("\n"); 
		query.append("CONNECT BY PRIOR CMDT.CMDT_HDR_SEQ = CMDT.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND PRIOR CMDT.GEN_SPCL_RT_TP_CD = CMDT.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("AND PRIOR  CMDT.RN = CMDT.RN - 1" ).append("\n"); 
		query.append("GROUP BY CMDT.QTTN_NO" ).append("\n"); 
		query.append(",CMDT.QTTN_VER_NO" ).append("\n"); 
		query.append(",CMDT.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append(",CMDT.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY CMDT.GEN_SPCL_RT_TP_CD , CMDT.CMDT_HDR_SEQ" ).append("\n"); 

	}
}