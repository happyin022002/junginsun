/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : RFAQuotationMainDBDAOSearchDetailCntRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.20
*@LastModifier : 이은섭
*@LastVersion : 1.0
* 2012.11.20 이은섭
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaquotation.rfaquotationmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Eun-Sup Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAQuotationMainDBDAOSearchDetailCntRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 각 탭별 건수 조회
	  * </pre>
	  */
	public RFAQuotationMainDBDAOSearchDetailCntRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaquotation.rfaquotationmain.integration").append("\n"); 
		query.append("FileName : RFAQuotationMainDBDAOSearchDetailCntRSQL").append("\n"); 
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
		query.append("SELECT (SELECT COUNT(*)" ).append("\n"); 
		query.append("          FROM PRI_RQ_GRP_LOC" ).append("\n"); 
		query.append("         WHERE QTTN_NO = @[qttn_no]" ).append("\n"); 
		query.append("           AND QTTN_VER_NO = @[qttn_ver_no]) AS GRP_LOC_CNT," ).append("\n"); 
		query.append("       (SELECT COUNT(*)" ).append("\n"); 
		query.append("          FROM PRI_RQ_GRP_CMDT" ).append("\n"); 
		query.append("         WHERE QTTN_NO = @[qttn_no]" ).append("\n"); 
		query.append("           AND QTTN_VER_NO = @[qttn_ver_no]) AS GRP_CMDT_CNT," ).append("\n"); 
		query.append("       (SELECT COUNT(*)" ).append("\n"); 
		query.append("          FROM PRI_RQ_RT_CMDT_HDR HDR, PRI_RQ_MN MN" ).append("\n"); 
		query.append("         WHERE HDR.QTTN_NO = @[qttn_no]" ).append("\n"); 
		query.append("           AND HDR.QTTN_VER_NO = @[qttn_ver_no]" ).append("\n"); 
		query.append("           AND HDR.QTTN_NO = MN.QTTN_NO" ).append("\n"); 
		query.append("           AND HDR.QTTN_VER_NO = MN.QTTN_VER_NO) AS RATE_G_CNT," ).append("\n"); 
		query.append("	     '0' AS RATE_CNT," ).append("\n"); 
		query.append("       '0' AS RATE_S_CNT" ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 

	}
}