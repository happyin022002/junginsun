/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CgmCodeMgtDBDAOSearchCPSScExptListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.15
*@LastModifier : 이영헌
*@LastVersion : 1.0
* 2013.05.15 이영헌
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author YoungHeon Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CgmCodeMgtDBDAOSearchCPSScExptListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * S/C Exception으로 등록된 리스트를 조회
	  * </pre>
	  */
	public CgmCodeMgtDBDAOSearchCPSScExptListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.integration").append("\n"); 
		query.append("FileName : CgmCodeMgtDBDAOSearchCPSScExptListDataRSQL").append("\n"); 
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
		query.append("SELECT A.CRE_OFC_CD," ).append("\n"); 
		query.append("       A.RHQ_CD," ).append("\n"); 
		query.append("       A.CTRT_OFC_CD," ).append("\n"); 
		query.append("       A.CUST_GRP_ID," ).append("\n"); 
		query.append("       DECODE(C.CUST_GRP_NM, '', B.CUST_LGL_ENG_NM, C.CUST_GRP_NM) CUST_GRP_NM," ).append("\n"); 
		query.append("       REPLACE((A.CUST_CNT_CD || TO_CHAR(A.CUST_SEQ, '000000')), ' ', '') CUST_CD," ).append("\n"); 
		query.append("       B.CUST_LGL_ENG_NM," ).append("\n"); 
		query.append("       A.SC_CUST_TP_CD," ).append("\n"); 
		query.append("       A.SC_NO," ).append("\n"); 
		query.append("	   A.EFF_YRMON," ).append("\n"); 
		query.append("	   A.LOC_CD," ).append("\n"); 
		query.append("       A.USA_SC_EXPT_RMK," ).append("\n"); 
		query.append("       '' ERR1," ).append("\n"); 
		query.append("       '' ERR2," ).append("\n"); 
		query.append("       '' ERR3," ).append("\n"); 
		query.append("	   '' ERR4," ).append("\n"); 
		query.append("       '' INSFLG," ).append("\n"); 
		query.append("       '' UPDFLG," ).append("\n"); 
		query.append("       '' DELFLG" ).append("\n"); 
		query.append("FROM CGM_CPS_SC_EXPT_LIST A, MDM_CUSTOMER B, MDM_CUST_PERF_GRP C" ).append("\n"); 
		query.append("WHERE A.CUST_CNT_CD = B.CUST_CNT_CD" ).append("\n"); 
		query.append("AND A.CUST_SEQ = B.CUST_SEQ" ).append("\n"); 
		query.append("AND A.CUST_GRP_ID = C.CUST_GRP_ID(+)" ).append("\n"); 
		query.append("#if (${eff_yrmon} != '')" ).append("\n"); 
		query.append("AND EFF_YRMON = @[eff_yrmon]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sc_no} != '')" ).append("\n"); 
		query.append("AND SC_NO = @[sc_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ctrt_ofc_cd} != '')" ).append("\n"); 
		query.append("AND CTRT_OFC_CD = @[ctrt_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cre_ofc_cd} != '')" ).append("\n"); 
		query.append("AND CRE_OFC_CD = @[cre_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY A.SC_NO, A.EFF_YRMON, A.LOC_CD" ).append("\n"); 

	}
}