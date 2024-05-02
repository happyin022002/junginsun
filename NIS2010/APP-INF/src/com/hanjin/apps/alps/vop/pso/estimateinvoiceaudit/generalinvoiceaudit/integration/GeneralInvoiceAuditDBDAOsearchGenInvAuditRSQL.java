/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : GeneralInvoiceAuditDBDAOsearchGenInvAuditRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.20
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralInvoiceAuditDBDAOsearchGenInvAuditRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Invoice 정보를 조회합니다.
	  * 
	  * =======================================
	  * * 2012.11.26 진마리아 CHM-201220618-01 TPB 비용 정보 지정시 해당 정보를 TPB IF용 테이블에 저장하고 제어함
	  * * 2015.03.19 CHM-201534621 TONNAGE 배분 관련 조회 항목 추가함
	  * </pre>
	  */
	public GeneralInvoiceAuditDBDAOsearchGenInvAuditRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration").append("\n"); 
		query.append("FileName : GeneralInvoiceAuditDBDAOsearchGenInvAuditRSQL").append("\n"); 
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
		query.append("select  X1.*" ).append("\n"); 
		query.append("	   ,X2.CURR_CD AS TRF_CURR_CD" ).append("\n"); 
		query.append("  from  (" ).append("\n"); 
		query.append("          select  T2.ISS_CTY_CD" ).append("\n"); 
		query.append("                 ,T2.SO_SEQ" ).append("\n"); 
		query.append("                 ,max(T1.COST_OFC_CD)         AS COST_OFC_CD" ).append("\n"); 
		query.append("                 ,min(T2.SO_DTL_SEQ)          AS SO_DTL_SEQ" ).append("\n"); 
		query.append("                 ,max(T1.PSO_CHG_STS_CD)      AS PSO_CHG_STS_CD" ).append("\n"); 
		query.append("                 ,max(T2.VSL_CD)              AS VSL_CD" ).append("\n"); 
		query.append("                 ,max(decode(T2.SO_DTL_SEQ, ORG_SO_DTL_SEQ, T2.SKD_VOY_NO,'')) AS SKD_VOY_NO" ).append("\n"); 
		query.append("                 ,max(decode(T2.SO_DTL_SEQ, ORG_SO_DTL_SEQ, T2.SKD_DIR_CD,'')) AS SKD_DIR_CD" ).append("\n"); 
		query.append("                 ,max(T2.LGS_COST_CD)			AS ACCT_CD" ).append("\n"); 
		query.append("                 ,max(" ).append("\n"); 
		query.append("                      (select X.ACCT_CD from TES_LGS_COST X where X.LGS_COST_CD = T2.LGS_COST_CD)" ).append("\n"); 
		query.append("          		) AS COST_CD" ).append("\n"); 
		query.append("                 ,max(decode(DP_IO_BND_CD, 'I', 'IN', 'O', 'OUT', 'INOUT')) AS IO" ).append("\n"); 
		query.append("                 ,max(" ).append("\n"); 
		query.append("                      (select  X.LGS_COST_FULL_NM from TES_LGS_COST X where X.LGS_COST_CD = T2.LGS_COST_CD)" ).append("\n"); 
		query.append("          		) 							AS LGS_COST_FULL_NM" ).append("\n"); 
		query.append("                 ,sum(T2.CALC_AMT) 			AS TARIFF_COST" ).append("\n"); 
		query.append("                 ,sum(decode(T2.CALC_AMT, null, decode(T2.ADJ_AMT, null, T2.LOCL_AMT, T2.ADJ_AMT), T2.ADJ_AMT)) AS ADJCOST" ).append("\n"); 
		query.append("                 ,SUM(T2.LOCL_AMT)        	AS AMOUNT" ).append("\n"); 
		query.append("                 ,max(T2.FOML_DESC)       	AS FOML1" ).append("\n"); 
		query.append("                 ,max(T2.XPR_DESC)        	AS FOML2" ).append("\n"); 
		query.append("                 ,max(T2.XPR_DESC)        	AS COND1" ).append("\n"); 
		query.append("                 ,max(T2.FOML_DESC)       	AS COND2" ).append("\n"); 
		query.append("                 ,max(T2.DIFF_RMK)        	AS REMARK" ).append("\n"); 
		query.append("                 ,max(TO_CHAR(T2.COST_CALC_EFF_FM_DT,'YYYYMMDD')) AS COST_CALC_EFF_FM_DT" ).append("\n"); 
		query.append("                 ,max(TO_CHAR(T2.COST_CALC_EFF_TO_DT,'YYYYMMDD')) AS COST_CALC_EFF_TO_DT" ).append("\n"); 
		query.append("                 ,max(T1.VNDR_SEQ)        	AS VNDR_SEQ" ).append("\n"); 
		query.append("                 ,max(T1.YD_CD)           	AS YD_CD" ).append("\n"); 
		query.append("                 ,max(T2.YD_CHG_NO)       	AS YD_CHG_NO" ).append("\n"); 
		query.append("                 ,max(T2.YD_CHG_VER_SEQ)  	AS YD_CHG_VER_SEQ" ).append("\n"); 
		query.append("                 ,max(" ).append("\n"); 
		query.append("                      (" ).append("\n"); 
		query.append("                        select  TO_CHAR(min(X.VPS_ETD_DT), 'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("                          from  VSK_VSL_PORT_SKD  X" ).append("\n"); 
		query.append("                         where  X.VSL_CD = T2.VSL_CD" ).append("\n"); 
		query.append("                           and  X.SKD_VOY_NO = T2.SKD_VOY_NO" ).append("\n"); 
		query.append("                           and  X.SKD_DIR_CD = T2.SKD_DIR_CD" ).append("\n"); 
		query.append("                           and  X.YD_CD = T1.YD_CD" ).append("\n"); 
		query.append("                      )" ).append("\n"); 
		query.append("                  ) 							AS ATD" ).append("\n"); 
		query.append("                 ,max(T1.TTL_LOCL_AMT)		AS TTL_LOCL_AMT" ).append("\n"); 
		query.append("                 ,max(T1.INV_LOCL_AMT)		AS INV_LOCL_AMT		--Invoice Local Amount" ).append("\n"); 
		query.append("                 ,max(T1.LOCL_TAX_AMT)		AS LOCL_TAX_AMT" ).append("\n"); 
		query.append("                 ,max(T1.LOCL_WHLD_TAX_AMT)	AS LOCL_WHLD_TAX_AMT" ).append("\n"); 
		query.append("                 ,max(T1.CURR_CD)				AS CURR_CD" ).append("\n"); 
		query.append("                 ,max(to_char(T1.EFF_DT, 'YYYY-MM-DD')) AS EFF_DT" ).append("\n"); 
		query.append("                 ,extractvalue(xmltype(nvl(max(T2.INV_COND_DESC),'<o></o>')), '//o86') night" ).append("\n"); 
		query.append("                 ,extractvalue(xmltype(nvl(max(T2.INV_COND_DESC),'<o></o>')), '//o75') holiday" ).append("\n"); 
		query.append("                 ,extractvalue(xmltype(nvl(max(T2.INV_COND_DESC),'<o></o>')), '//o17') boat" ).append("\n"); 
		query.append("                 ,extractvalue(xmltype(nvl(max(T2.INV_COND_DESC),'<o></o>')), '//o110') tugrope" ).append("\n"); 
		query.append("                 ,extractvalue(xmltype(nvl(max(T2.INV_COND_DESC),'<o></o>')), '//o57') buoy" ).append("\n"); 
		query.append("                 ,extractvalue(xmltype(nvl(max(T2.INV_COND_DESC),'<o></o>')), '//o97') sanitation" ).append("\n"); 
		query.append("                 ,extractvalue(xmltype(nvl(max(T2.INV_COND_DESC),'<o></o>')), '//o52') barge" ).append("\n"); 
		query.append("                 ,extractvalue(xmltype(nvl(max(T2.INV_COND_DESC),'<o></o>')), '//o78') inspection" ).append("\n"); 
		query.append("                 ,extractvalue(xmltype(nvl(max(T2.INV_COND_DESC),'<o></o>')), '//o8') arrtp" ).append("\n"); 
		query.append("                 ,extractvalue(xmltype(nvl(max(T2.INV_COND_DESC),'<o></o>')), '//o9') deptp" ).append("\n"); 
		query.append("                 ,extractvalue(xmltype(nvl(max(T2.INV_COND_DESC),'<o></o>')), '//o6') arrnt" ).append("\n"); 
		query.append("                 ,extractvalue(xmltype(nvl(max(T2.INV_COND_DESC),'<o></o>')), '//o7') depnt" ).append("\n"); 
		query.append("                 ,extractvalue(xmltype(nvl(max(T2.INV_COND_DESC),'<o></o>')), '//o10') arrtuh" ).append("\n"); 
		query.append("                 ,extractvalue(xmltype(nvl(max(T2.INV_COND_DESC),'<o></o>')), '//o11') deptuh" ).append("\n"); 
		query.append("                 ,extractvalue(xmltype(nvl(max(T2.INV_COND_DESC),'<o></o>')), '//o50') arrlh" ).append("\n"); 
		query.append("                 ,extractvalue(xmltype(nvl(max(T2.INV_COND_DESC),'<o></o>')), '//o60') deplh" ).append("\n"); 
		query.append("                 ,extractvalue(xmltype(nvl(max(T2.INV_COND_DESC),'<o></o>')), '//o111') usdhrs" ).append("\n"); 
		query.append("          	   ,extractvalue(xmltype(nvl(max(T2.INV_COND_DESC),'<o></o>')), '//o119') newservice" ).append("\n"); 
		query.append("          	   ,extractvalue(xmltype(nvl(max(T2.INV_COND_DESC),'<o></o>')), '//o125') copilot" ).append("\n"); 
		query.append("          	   ,max(T1.PSO_TRNS_SLP_CTNT)	AS PSO_TRNS_SLP_CTNT" ).append("\n"); 
		query.append("          	   ,to_char(max(T1.ISS_DT), 'YYYYMMDD')     AS ISS_DT" ).append("\n"); 
		query.append("          	   ,to_char(max(T1.ACPT_DT), 'YYYYMMDD')    AS ACPT_DT" ).append("\n"); 
		query.append("          	   ,max(T2.VSL_CD) || max(decode(T2.SO_DTL_SEQ, ORG_SO_DTL_SEQ, T2.SKD_VOY_NO,'')) || max(decode(T2.SO_DTL_SEQ, ORG_SO_DTL_SEQ, T2.SKD_DIR_CD,'')) AS VVD" ).append("\n"); 
		query.append("          	   ,decode(nvl(max(T3.ISS_CTY_CD),'N'),'N','N','Y') AS N3PTY_BIL_IF_FLG" ).append("\n"); 
		query.append("          	   ,max(T3.N3PTY_BIL_TP_CD) 	AS N3PTY_BIL_TP_CD" ).append("\n"); 
		query.append("          	   ,max(T3.IF_RMK) 				AS IF_RMK" ).append("\n"); 
		query.append("          	   ,max(T3.VNDR_SEQ) 			AS N3PTY_VNDR_SEQ" ).append("\n"); 
		query.append("			   ,max(T2.MNL_INP_XCH_RT)		AS MNL_INP_XCH_RT" ).append("\n"); 
		query.append("            from  PSO_CHARGE			T1" ).append("\n"); 
		query.append("                 ,PSO_CHG_DTL			T2" ).append("\n"); 
		query.append("                 ,PSO_N3RD_PTY_IF		T3" ).append("\n"); 
		query.append("           where  T1.ISS_CTY_CD = T2.ISS_CTY_CD" ).append("\n"); 
		query.append("             and  T1.SO_SEQ = T2.SO_SEQ" ).append("\n"); 
		query.append("             and  T2.ISS_CTY_CD = T3.ISS_CTY_CD(+)" ).append("\n"); 
		query.append("             and  T2.SO_SEQ = T3.SO_SEQ(+)" ).append("\n"); 
		query.append("             and  T2.SO_DTL_SEQ = T3.SO_DTL_SEQ(+)" ).append("\n"); 
		query.append("             and  T1.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("             and  T1.INV_NO = @[inv_no]" ).append("\n"); 
		query.append("          group by T2.ISS_CTY_CD, T2.SO_SEQ, T2.ORG_SO_DTL_SEQ" ).append("\n"); 
		query.append("        ) X1" ).append("\n"); 
		query.append("        , PSO_YD_CHG X2" ).append("\n"); 
		query.append(" where  X1.YD_CHG_NO = X2.YD_CHG_NO(+)" ).append("\n"); 
		query.append("   and  X1.YD_CHG_VER_SEQ = X2.YD_CHG_VER_SEQ(+)" ).append("\n"); 

	}
}