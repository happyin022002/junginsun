/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ProformaScheduleMgtDBDAOSearchOldSlotPriceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.10
*@LastModifier : 서창열
*@LastVersion : 1.0
* 2010.02.10 서창열
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SEO CHANG YUL
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ProformaScheduleMgtDBDAOSearchOldSlotPriceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchOldSlotPrice
	  * </pre>
	  */
	public ProformaScheduleMgtDBDAOSearchOldSlotPriceRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_qtr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slt_prc_wrk_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pf_svc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.integration").append("\n"); 
		query.append("FileName : ProformaScheduleMgtDBDAOSearchOldSlotPriceRSQL").append("\n"); 
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
		query.append("SELECT VSL_CSL1,VSL_CSL2,VSL_CSL3,ROUND((VSL_CSL1+VSL_CSL2+VSL_CSL3)/CLS_CNT,1) AS SLOT_SUM" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT MAX(COL1) AS VSL_CSL1, MAX(COL2) AS VSL_CSL2, MAX(COL3) AS VSL_CSL3,MAX(ROWRN) AS CLS_CNT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT  A.ROWRN,B.RN," ).append("\n"); 
		query.append("DECODE(A.ROWRN, 1 ," ).append("\n"); 
		query.append("DECODE(B.RN, 1,  SLT_PRC_TTL_AMT," ).append("\n"); 
		query.append("2,  SLT_PRC_RND_AMT," ).append("\n"); 
		query.append("3,  SLT_PRC_ONE_WY_AMT)) COL1," ).append("\n"); 
		query.append("DECODE(A.ROWRN, 2," ).append("\n"); 
		query.append("DECODE(B.RN, 1,  SLT_PRC_TTL_AMT," ).append("\n"); 
		query.append("2,  SLT_PRC_RND_AMT," ).append("\n"); 
		query.append("3,  SLT_PRC_ONE_WY_AMT)) COL2," ).append("\n"); 
		query.append("DECODE(A.ROWRN, 3," ).append("\n"); 
		query.append("DECODE(B.RN, 1,  SLT_PRC_TTL_AMT," ).append("\n"); 
		query.append("2,  SLT_PRC_RND_AMT," ).append("\n"); 
		query.append("3,  SLT_PRC_ONE_WY_AMT)) COL3" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT  ROW_NUMBER() OVER (ORDER BY VSL_CLSS_CD) ROWRN," ).append("\n"); 
		query.append("VSL_CLSS_CD," ).append("\n"); 
		query.append("SLT_PRC_TTL_AMT," ).append("\n"); 
		query.append("SLT_PRC_RND_AMT," ).append("\n"); 
		query.append("SLT_PRC_ONE_WY_AMT" ).append("\n"); 
		query.append("FROM    VSK_SLT_PRC_DTL" ).append("\n"); 
		query.append("WHERE   VSL_SLAN_CD = @[vsl_slan_cd]" ).append("\n"); 
		query.append("AND     PF_SVC_TP_CD = @[pf_svc_tp_cd]" ).append("\n"); 
		query.append("AND     SLT_PRC_WRK_YR = @[slt_prc_wrk_yr]" ).append("\n"); 
		query.append("AND     BSE_QTR_CD = @[bse_qtr_cd]" ).append("\n"); 
		query.append(")A, (SELECT ROWNUM RN FROM DICT WHERE ROWNUM<=3) B" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY RN" ).append("\n"); 
		query.append("ORDER BY RN" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}