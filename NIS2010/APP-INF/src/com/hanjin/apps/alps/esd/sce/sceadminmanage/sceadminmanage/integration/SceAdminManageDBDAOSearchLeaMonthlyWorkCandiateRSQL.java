/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SceAdminManageDBDAOSearchLeaMonthlyWorkCandiateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.09.15
*@LastModifier : 
*@LastVersion : 1.0
* 2011.09.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.sceadminmanage.sceadminmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SceAdminManageDBDAOSearchLeaMonthlyWorkCandiateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * LEA 월간 결산 대상 Data 조회
	  * </pre>
	  */
	public SceAdminManageDBDAOSearchLeaMonthlyWorkCandiateRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("leaAccMon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.sceadminmanage.sceadminmanage.integration").append("\n"); 
		query.append("FileName : SceAdminManageDBDAOSearchLeaMonthlyWorkCandiateRSQL").append("\n"); 
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
		query.append("DISTINCT BKG_NO," ).append("\n"); 
		query.append("CNTR_NO," ).append("\n"); 
		query.append("INV_COST_ACT_GRP_CD COST_ACT_GRP_CD," ).append("\n"); 
		query.append("INV_COST_ACT_GRP_SEQ COST_ACT_GRP_SEQ," ).append("\n"); 
		query.append("TO_CHAR(ADD_MONTHS(SYSDATE,-1), 'YYYYMM')||'LEA' CRE_USR_ID," ).append("\n"); 
		query.append("SYSDATE CRE_DT," ).append("\n"); 
		query.append("TO_CHAR(ADD_MONTHS(SYSDATE,-1), 'YYYYMM')||'LEA' UPD_USR_ID," ).append("\n"); 
		query.append("SYSDATE UPD_DT" ).append("\n"); 
		query.append("FROM LEA_CSR_MNTR" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("EXE_YRMON = NVL(@[leaAccMon], TO_CHAR(ADD_MONTHS(SYSDATE,-1),'YYYYMM'))" ).append("\n"); 
		query.append("AND INV_SYS_ID='TRS'" ).append("\n"); 
		query.append("AND ACT_MAPG_RSLT_CD in ('ND','AG','BK')" ).append("\n"); 

	}
}