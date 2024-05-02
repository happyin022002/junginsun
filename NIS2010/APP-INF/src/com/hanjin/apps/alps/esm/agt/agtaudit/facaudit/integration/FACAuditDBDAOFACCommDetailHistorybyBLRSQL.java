/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : FACAuditDBDAOFACCommDetailHistorybyBLRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.22
*@LastModifier : 이호진
*@LastVersion : 1.0
* 2010.02.22 이호진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtaudit.facaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Ho Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FACAuditDBDAOFACCommDetailHistorybyBLRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ESM_AGT_015 FAC Commission의 History Detail 목록 조회
	  * </pre>
	  */
	public FACAuditDBDAOFACCommDetailHistorybyBLRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.agt.agtaudit.facaudit.integration").append("\n"); 
		query.append("FileName : FACAuditDBDAOFACCommDetailHistorybyBLRSQL").append("\n"); 
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
		query.append("B.FAC_SEQ AS FAC_SEQ," ).append("\n"); 
		query.append("DECODE(SUBSTR(B.FAC_DIV_CD,1,1),'B',DECODE(B.FAC_DIV_CD,'BL',B.ACT_COMM_AMT, 0),0) AS BL_COMM_AMT," ).append("\n"); 
		query.append("DECODE(SUBSTR(B.FAC_DIV_CD,1,1),'B',DECODE(B.FAC_DIV_CD,'BL',0,B.ACT_COMM_AMT),0) AS ACT_COMM_AMT," ).append("\n"); 
		query.append("B.BKG_BX_QTY AS BKG_BX_QTY," ).append("\n"); 
		query.append("B.FAC_BX_RT AS FAC_BX_RT," ).append("\n"); 
		query.append("B.BKG_TEU_QTY AS BKG_TEU_QTY," ).append("\n"); 
		query.append("B.FAC_TEU_RT AS FAC_TEU_RT," ).append("\n"); 
		query.append("B.BKG_FEU_QTY AS BKG_FEU_QTY," ).append("\n"); 
		query.append("B.FAC_FEU_RT AS FAC_FEU_RT," ).append("\n"); 
		query.append("B.BKG_RF_TEU_QTY AS BKG_RF_TEU_QTY," ).append("\n"); 
		query.append("B.FAC_RF_TEU_RT AS FAC_RF_TEU_RT," ).append("\n"); 
		query.append("B.BKG_RF_FEU_QTY AS BKG_RF_FEU_QTY," ).append("\n"); 
		query.append("B.FAC_RF_FEU_RT AS FAC_RF_FEU_RT," ).append("\n"); 
		query.append("DECODE(SUBSTR(B.FAC_DIV_CD,1,1),'C',B.ACT_COMM_AMT,0) AS CNTR_COMM_AMT," ).append("\n"); 
		query.append("B.ACT_PRE_COMM_AMT AS ACT_PRE_COMM_AMT," ).append("\n"); 
		query.append("TO_CHAR (B.CRE_DT, 'YYYYMMDD') AS CRE_DT," ).append("\n"); 
		query.append("REPLACE(B.FAC_RMK, '&', '&amp;') AS FAC_RMK," ).append("\n"); 
		query.append("B.COMM_PROC_STS_CD AS COMM_PROC_STS_CD," ).append("\n"); 
		query.append("REPLACE(B.COMM_PROC_RSLT_RSN, '&', '&amp;') AS COMM_PROC_RSLT_RSN," ).append("\n"); 
		query.append("TO_CHAR (B.FAC_IF_DT, 'YYYYMMDD') AS FAC_IF_DT," ).append("\n"); 
		query.append("B.FAC_OFC_CD AS FAC_OFC_CD," ).append("\n"); 
		query.append("B.AGMT_CNT_CD AS AGMT_CNT_CD," ).append("\n"); 
		query.append("B.AGMT_CUST_SEQ AS AGMT_CUST_SEQ," ).append("\n"); 
		query.append("B.AGMT_RT_SEQ AS AGMT_RT_SEQ" ).append("\n"); 
		query.append("FROM AGT_COMM_BKG_INFO A, AGT_FAC_COMM B" ).append("\n"); 
		query.append("WHERE A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("#if (${bl_no} != '')" ).append("\n"); 
		query.append("AND A.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_no} != '')" ).append("\n"); 
		query.append("AND A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY FAC_SEQ DESC" ).append("\n"); 

	}
}