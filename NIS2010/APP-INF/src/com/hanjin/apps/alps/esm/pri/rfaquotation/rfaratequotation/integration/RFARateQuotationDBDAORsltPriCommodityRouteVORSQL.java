/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : RFARateQuotationDBDAORsltPriCommodityRouteVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.31
*@LastModifier : 이은섭
*@LastVersion : 1.0
* 2012.07.31 이은섭
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Eun-Sup Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFARateQuotationDBDAORsltPriCommodityRouteVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public RFARateQuotationDBDAORsltPriCommodityRouteVORSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fic_rt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.integration").append("\n"); 
		query.append("FileName : RFARateQuotationDBDAORsltPriCommodityRouteVORSQL").append("\n"); 
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
		query.append("SELECT CMDT.QTTN_NO," ).append("\n"); 
		query.append("       CMDT.QTTN_VER_NO," ).append("\n"); 
		query.append("       CMDT.CMDT_HDR_SEQ," ).append("\n"); 
		query.append("       SUBSTR(MAX(SYS_CONNECT_BY_PATH(PRC_CMDT_DEF_CD, ' / ')), 3) AS CMDT_NM" ).append("\n"); 
		query.append("  FROM (SELECT A.QTTN_NO," ).append("\n"); 
		query.append("               A.QTTN_VER_NO," ).append("\n"); 
		query.append("               A.CMDT_HDR_SEQ," ).append("\n"); 
		query.append("               A.CMDT_SEQ," ).append("\n"); 
		query.append("               A.PRC_CMDT_DEF_CD," ).append("\n"); 
		query.append("               ROW_NUMBER() OVER(PARTITION BY A.QTTN_NO, A.QTTN_VER_NO, A.CMDT_HDR_SEQ ORDER BY A.QTTN_NO, A.QTTN_VER_NO, DECODE(A.PRC_CMDT_TP_CD, 'G', 1, DECODE(A.PRC_CMDT_TP_CD, 'R', 2, 3)), A.CMDT_HDR_SEQ, A.CMDT_SEQ) AS RN" ).append("\n"); 
		query.append("          FROM PRI_RQ_RT_CMDT     A," ).append("\n"); 
		query.append("               PRI_RQ_RT_CMDT_HDR X" ).append("\n"); 
		query.append("         WHERE A.QTTN_NO = @[qttn_no]" ).append("\n"); 
		query.append("               AND A.QTTN_VER_NO = @[qttn_ver_no]" ).append("\n"); 
		query.append("               AND A.QTTN_NO = X.QTTN_NO" ).append("\n"); 
		query.append("               AND A.QTTN_VER_NO = X.QTTN_VER_NO" ).append("\n"); 
		query.append("               AND A.CMDT_HDR_SEQ = X.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("               AND NVL(X.FIC_RT_TP_CD, 'G') = NVL(@[fic_rt_tp_cd], 'G')        " ).append("\n"); 
		query.append("        ) CMDT" ).append("\n"); 
		query.append(" START WITH RN = 1" ).append("\n"); 
		query.append("CONNECT BY PRIOR CMDT.CMDT_HDR_SEQ = CMDT.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("           AND PRIOR CMDT.RN = CMDT.RN - 1" ).append("\n"); 
		query.append(" GROUP BY CMDT.QTTN_NO," ).append("\n"); 
		query.append("          CMDT.QTTN_VER_NO," ).append("\n"); 
		query.append("          CMDT.CMDT_HDR_SEQ" ).append("\n"); 
		query.append(" ORDER BY CMDT.CMDT_HDR_SEQ" ).append("\n"); 

	}
}