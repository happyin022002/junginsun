/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : DwellNotificationDBDAOSearchDwllNtfcSvcItemRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.18
*@LastModifier : 
*@LastVersion : 1.0
* 2012.06.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.dwellnotification.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DwellNotificationDBDAOSearchDwllNtfcSvcItemRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Row 검색으로 SC_NO의 정보들을 찾아 온다.
	  * </pre>
	  */
	public DwellNotificationDBDAOSearchDwllNtfcSvcItemRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.dwellnotification.integration").append("\n"); 
		query.append("FileName : DwellNotificationDBDAOSearchDwllNtfcSvcItemRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("    A.SC_NO" ).append("\n"); 
		query.append(",   SEXP.DWLL_CUST_CNT_CD || LPAD(SEXP.DWLL_CUST_SEQ, 6, '0') AS CUST_CD" ).append("\n"); 
		query.append(",   A.CTRT_PTY_NM" ).append("\n"); 
		query.append(",   A.FNL_MQC_QTY AS PROP_MQC_QTY" ).append("\n"); 
		query.append(",   A.INTG_CD_VAL_DP_DESC UNIT_NM" ).append("\n"); 
		query.append(",	A.PROP_OFC_CD" ).append("\n"); 
		query.append(",   TO_CHAR(CTRT_EFF_DT,'YYYY-MM-DD') EFF_DT" ).append("\n"); 
		query.append(",   TO_CHAR(CTRT_EXP_DT,'YYYY-MM-DD') EXP_DT" ).append("\n"); 
		query.append(",   'Edit (Registered : '|| (SELECT COUNT(1) FROM SCE_DWLL_CUST_SVC_LIST S WHERE S.DWLL_CUST_CNT_CD = SEXP.DWLL_CUST_CNT_CD AND S.DWLL_CUST_SEQ = SEXP.DWLL_CUST_SEQ AND S.DELT_FLG = 'N' ) || ' )' EMAIL_LIST_CNT" ).append("\n"); 
		query.append(",	SEXP.DWLL_EXPT_RMK" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("    *" ).append("\n"); 
		query.append("    FROM" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("            ROW_NUMBER() OVER ( PARTITION BY CUST_CNT_CD, CUST_SEQ ORDER BY HDR.CRE_DT DESC, PTY.AMDT_SEQ DESC) SEL_SEQ" ).append("\n"); 
		query.append("        ,   PTY.PROP_NO" ).append("\n"); 
		query.append("        ,   PTY.AMDT_SEQ" ).append("\n"); 
		query.append("        ,   HDR.SC_NO" ).append("\n"); 
		query.append("        ,   PTY.CUST_CNT_CD" ).append("\n"); 
		query.append("        ,   PTY.CUST_SEQ" ).append("\n"); 
		query.append("        ,   PTY.CTRT_PTY_NM" ).append("\n"); 
		query.append("        ,   PTY.PRC_CTRT_PTY_TP_CD" ).append("\n"); 
		query.append("		, MN.PROP_OFC_CD" ).append("\n"); 
		query.append("        , CTRT_EFF_DT" ).append("\n"); 
		query.append("        , CTRT_EXP_DT" ).append("\n"); 
		query.append("        , MQC.FNL_MQC_QTY" ).append("\n"); 
		query.append("        ,   UNIT.INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("        FROM " ).append("\n"); 
		query.append("            PRI_SP_CTRT_PTY PTY" ).append("\n"); 
		query.append("        ,   PRI_SP_HDR HDR" ).append("\n"); 
		query.append("        ,   PRI_SP_DUR DUR" ).append("\n"); 
		query.append("        ,   PRI_SP_MQC MQC" ).append("\n"); 
		query.append("		,   PRI_SP_MN MN" ).append("\n"); 
		query.append("        ,   (SELECT INTG_CD_VAL_CTNT, INTG_CD_VAL_DP_DESC from COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD00897' ) UNIT" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("        AND PTY.PRC_CTRT_PTY_TP_CD='C'" ).append("\n"); 
		query.append("        AND SUBSTR(HDR.SC_NO, 1,3) IN ('AEF', 'AEN', 'ANW','ASE','AWE','ASW', 'AWN', 'GLO', 'SAN', 'SAS', 'CEN','ANW','CEF','MME')" ).append("\n"); 
		query.append("        AND HDR.PROP_NO = PTY.PROP_NO    " ).append("\n"); 
		query.append("        AND PTY.PROP_NO = DUR.PROP_NO" ).append("\n"); 
		query.append("        AND PTY.AMDT_SEQ = DUR.AMDT_SEQ" ).append("\n"); 
		query.append("		AND PTY.PROP_NO = MN.PROP_NO" ).append("\n"); 
		query.append("		AND PTY.AMDT_SEQ = MN.AMDT_SEQ" ).append("\n"); 
		query.append("        AND MQC.PROP_NO = DUR.PROP_NO" ).append("\n"); 
		query.append("        AND MQC.AMDT_SEQ = DUR.AMDT_SEQ" ).append("\n"); 
		query.append("        AND MQC.CNTR_LOD_UT_CD = UNIT.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    WHERE SEL_SEQ=1" ).append("\n"); 
		query.append("    ) A" ).append("\n"); 
		query.append(",   SCE_DWLL_NTFC_CUST_EXPT SEXP" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND SEXP.DWLL_CUST_CNT_CD = A.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("    AND SEXP.DWLL_CUST_SEQ = A.CUST_SEQ(+)" ).append("\n"); 
		query.append("    #if (${cust_cd} != '' )" ).append("\n"); 
		query.append("    AND SEXP.DWLL_CUST_CNT_CD = SUBSTR(@[cust_cd],1,2)" ).append("\n"); 
		query.append("    AND SEXP.DWLL_CUST_SEQ = TO_NUMBER(SUBSTR(@[cust_cd],3))" ).append("\n"); 
		query.append("    #end" ).append("\n"); 

	}
}