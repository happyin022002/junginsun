/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RFAReportDBDAORsltSearchRFAListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.23
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfareport.rfareport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAReportDBDAORsltSearchRFAListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2011.12.05 이석준 [CHM-201114806-01] Login Office가 XXXBA일경우 RFA No or Proposal No가 해당 BA것 일경우만 S/C Viewing이 가능하거나
	  * 조회 가능토록 수정
	  * 2011.12.26 이석준 [CHM-201115205] RFA or Proposal 조회시 HAMRU 산하의 BA만
	  *                                                                     자신의 office만 조회 가능할 수 있도록 validation및 logic 수정
	  * 2012.02.08 이석준[CHM-201216074] RFA 조회시 HAMRU 산하의 BA OFFICE들이 상대방 BA RFA 조회 못하게 했던 부분을 다시 원래대로 조회 할 수 있도록 수정
	  * 2015.07.14 전지예 [CHM-201536783] RFA 조회 시 Scope의 Sales Rep이 조회되는걸 대표 Sales Rep이 조회되도록 수정
	  * 2016.05.03 RFA 효율화를 위한 요청 (1차) (CHM-201640671)
	  * </pre>
	  */
	public RFAReportDBDAORsltSearchRFAListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_cust_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_scp_srep_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_scp_ofc_srep_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exp_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_ctrt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prc_ctrt_cust_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_scp_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfareport.rfareport.integration").append("\n"); 
		query.append("FileName : RFAReportDBDAORsltSearchRFAListVORSQL").append("\n"); 
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
		query.append("WITH" ).append("\n"); 
		query.append("RA  AS" ).append("\n"); 
		query.append("(SELECT SUB.SVC_SCP_CD" ).append("\n"); 
		query.append("      , SUB.RFA_NO" ).append("\n"); 
		query.append("      , SUB.AMDT_SEQ" ).append("\n"); 
		query.append("      , SUB.PRC_CTRT_CUST_TP_CD" ).append("\n"); 
		query.append("      , SUB.CTRT_CUST_CNT_CD" ).append("\n"); 
		query.append("      , SUB.CTRT_CUST_SEQ" ).append("\n"); 
		query.append("      , SUB.CUST_NM" ).append("\n"); 
		query.append("      , SUB.PROP_SCP_OFC_CD" ).append("\n"); 
		query.append("      ---------------------------------------------------------      	  " ).append("\n"); 
		query.append("      , SUB.SVC_TGT_QTY     -- ADD" ).append("\n"); 
		query.append("      , SUB.MN_TGT_QTY      -- ADD" ).append("\n"); 
		query.append("      , SUB.DMDT_FT_TP_NM   -- ADD" ).append("\n"); 
		query.append("      , SUB.PROP_SREP_NM    -- ADD" ).append("\n"); 
		query.append("	  ---------------------------------------------------------" ).append("\n"); 
		query.append("      , SUB.PROP_SREP_CD -- PROP_SREP_CD로 수정" ).append("\n"); 
		query.append("      , SUB.CTRT_EFF_DT" ).append("\n"); 
		query.append("      , SUB.CTRT_EXP_DT" ).append("\n"); 
		query.append("      , SUB.RFA_CTRT_TP_CD" ).append("\n"); 
		query.append("      , SUB.ACT_CUST_NM" ).append("\n"); 
		query.append("#if (${act_cust_nm} != '')      " ).append("\n"); 
		query.append("      , SUB.ACT_CUST_IND  -- actual customer " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_nm} != '')      " ).append("\n"); 
		query.append("      , SUB.CUST_IND      -- customer name " ).append("\n"); 
		query.append("#end      " ).append("\n"); 
		query.append("      , ROW_NUMBER() OVER ( PARTITION BY SVC_SCP_CD, RFA_NO  ORDER BY AMDT_SEQ DESC " ).append("\n"); 
		query.append("                            #if (${cust_nm} != '') , CUST_IND DESC #end" ).append("\n"); 
		query.append("                            #if (${act_cust_nm} != '') , ACT_CUST_IND DESC #end" ).append("\n"); 
		query.append("                          ) ROW_NUMBER" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("            SELECT  RS.SVC_SCP_CD           ," ).append("\n"); 
		query.append("                    RH.RFA_NO               ," ).append("\n"); 
		query.append("                    RM.AMDT_SEQ             ," ).append("\n"); 
		query.append("                    RM.PRC_CTRT_CUST_TP_CD  , " ).append("\n"); 
		query.append("                    RM.CTRT_CUST_CNT_CD     ," ).append("\n"); 
		query.append("                    RM.CTRT_CUST_SEQ        ," ).append("\n"); 
		query.append("                    ( SELECT A.CUST_LGL_ENG_NM FROM MDM_CUSTOMER A WHERE A.CUST_CNT_CD = RM.CTRT_CUST_CNT_CD AND A.CUST_SEQ = RM.CTRT_CUST_SEQ ) CUST_NM ," ).append("\n"); 
		query.append("                    RS.PROP_SCP_OFC_CD      ," ).append("\n"); 
		query.append("					----------------------------------------------------------------------------" ).append("\n"); 
		query.append("                    (CASE WHEN RS.CNTR_LOD_UT_CD = 'T' THEN NVL(RS.TGT_MVC_QTY,0) WHEN RS.CNTR_LOD_UT_CD = 'F' THEN NVL(RS.TGT_MVC_QTY,0) * 2 END) AS SVC_TGT_QTY ,  --RFA 가 TEU 값이면 그대로, FEU 값이면 ×2" ).append("\n"); 
		query.append("                    (CASE WHEN RM.CNTR_LOD_UT_CD = 'T' THEN NVL(RM.TGT_MVC_QTY,0) WHEN RM.CNTR_LOD_UT_CD = 'F' THEN NVL(RM.TGT_MVC_QTY,0) * 2 END) AS MN_TGT_QTY  ,  --RFA 가 TEU 값이면 그대로, FEU 값이면 ×2" ).append("\n"); 
		query.append("                    ( SELECT CASE WHEN DMDT_FT_TP_CD = 'E' THEN 'Exception'" ).append("\n"); 
		query.append("                             ELSE 'Tariff' END " ).append("\n"); 
		query.append("                        FROM PRI_RP_DMDT " ).append("\n"); 
		query.append("                       WHERE PROP_NO  = RM.PROP_NO" ).append("\n"); 
		query.append("                         AND AMDT_SEQ = RM.AMDT_SEQ" ).append("\n"); 
		query.append("                    ) AS DMDT_FT_TP_NM              	, --E EXCEPTION / T TARIFF" ).append("\n"); 
		query.append("					--(SELECT SREP_NM FROM MDM_SLS_REP WHERE SREP_CD = RM.PROP_SREP_CD) AS PROP_SREP_NM ," ).append("\n"); 
		query.append("                    (SELECT USR_NM FROM COM_USER WHERE USR_ID = RM.PROP_USR_ID) AS PROP_SREP_NM , -- Requested by Staff" ).append("\n"); 
		query.append("                    ----------------------------------------------------------------------------" ).append("\n"); 
		query.append("                    RM.PROP_SREP_CD         , -- PROP_SREP_CD로 수정" ).append("\n"); 
		query.append("                    RD.CTRT_EFF_DT          ," ).append("\n"); 
		query.append("                    RD.CTRT_EXP_DT          ," ).append("\n"); 
		query.append("                    (SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD03493' AND INTG_CD_VAL_CTNT = RM.RFA_CTRT_TP_CD) AS RFA_CTRT_TP_CD," ).append("\n"); 
		query.append("                    (SELECT A.CUST_LGL_ENG_NM FROM MDM_CUSTOMER A WHERE A.CUST_CNT_CD = RA.CUST_CNT_CD AND A.CUST_SEQ = RA.CUST_SEQ) AS ACT_CUST_NM" ).append("\n"); 
		query.append("              #if (${act_cust_nm} != '')" ).append("\n"); 
		query.append("                  , NVL(( SELECT 1 FROM MDM_CUSTOMER MC" ).append("\n"); 
		query.append("                                  WHERE RA.PROP_NO       = RS.PROP_NO" ).append("\n"); 
		query.append("                                    AND RA.AMDT_SEQ      = RS.AMDT_SEQ" ).append("\n"); 
		query.append("                                    AND RA.SVC_SCP_CD    = RS.SVC_SCP_CD" ).append("\n"); 
		query.append("                                    AND RA.CUST_CNT_CD   = MC.CUST_CNT_CD " ).append("\n"); 
		query.append("                                    AND RA.CUST_SEQ      = MC.CUST_SEQ" ).append("\n"); 
		query.append("                                    AND RA.SRC_INFO_CD   <> 'AD'" ).append("\n"); 
		query.append("                                    AND MC.CUST_LGL_ENG_NM LIKE '%' || @[act_cust_nm] || '%'" ).append("\n"); 
		query.append("                                    AND ROWNUM = 1), 0 ) ACT_CUST_IND         " ).append("\n"); 
		query.append("              #end" ).append("\n"); 
		query.append("              #if (${cust_nm} != '')" ).append("\n"); 
		query.append("                  , NVL(( SELECT 1 FROM MDM_CUSTOMER MC" ).append("\n"); 
		query.append("                                  WHERE 1=1" ).append("\n"); 
		query.append("                                    AND RM.CTRT_CUST_CNT_CD   = MC.CUST_CNT_CD " ).append("\n"); 
		query.append("                                    AND RM.CTRT_CUST_SEQ      = MC.CUST_SEQ" ).append("\n"); 
		query.append("                                    AND MC.CUST_LGL_ENG_NM LIKE '%' || @[cust_nm] || '%'" ).append("\n"); 
		query.append("                                    AND ROWNUM = 1), 0 ) CUST_IND         " ).append("\n"); 
		query.append("              #end              " ).append("\n"); 
		query.append("                    FROM    PRI_RP_HDR     RH  ," ).append("\n"); 
		query.append("                            PRI_RP_MN      RM  ," ).append("\n"); 
		query.append("                            PRI_RP_SCP_MN  RS  , " ).append("\n"); 
		query.append("                            PRI_RP_SCP_DUR RD  ," ).append("\n"); 
		query.append("                            PRI_RP_SCP_RT_ACT_CUST RA" ).append("\n"); 
		query.append("                    WHERE   RM.PROP_NO       = RH.PROP_NO" ).append("\n"); 
		query.append("                    AND     RM.PROP_STS_CD   = 'A'" ).append("\n"); 
		query.append("                    AND     RS.PROP_NO       = RM.PROP_NO" ).append("\n"); 
		query.append("                    AND     RS.AMDT_SEQ      = RM.AMDT_SEQ" ).append("\n"); 
		query.append("                    AND     RD.PROP_NO       = RS.PROP_NO" ).append("\n"); 
		query.append("                    AND     RD.AMDT_SEQ      = RS.AMDT_SEQ" ).append("\n"); 
		query.append("                    AND     RD.SVC_SCP_CD    = RS.SVC_SCP_CD" ).append("\n"); 
		query.append("                    AND     RA.PROP_NO(+)    = RS.PROP_NO" ).append("\n"); 
		query.append("                    AND     RA.AMDT_SEQ(+)   = RS.AMDT_SEQ" ).append("\n"); 
		query.append("                    AND     RA.SVC_SCP_CD(+) = RS.SVC_SCP_CD" ).append("\n"); 
		query.append("                    #if (${rfa_no} != '')" ).append("\n"); 
		query.append("                    AND     RH.RFA_NO             LIKE @[rfa_no] || '%' -- RFA No" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                    #if (${prc_ctrt_cust_tp_cd} != '') " ).append("\n"); 
		query.append("                    AND    RM.PRC_CTRT_CUST_TP_CD = @[prc_ctrt_cust_tp_cd] -- Customer Type" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                    #if (${prop_scp_srep_cd} != '') " ).append("\n"); 
		query.append("                    AND    RS.PROP_SCP_SREP_CD    = @[prop_scp_srep_cd] -- S.Rep" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                    #if (${prop_scp_ofc_cd} != '') " ).append("\n"); 
		query.append("                    AND    RS.PROP_SCP_OFC_CD     = @[prop_scp_ofc_cd] -- Contract Office" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("					" ).append("\n"); 
		query.append("					#if (${prop_scp_ofc_srep_cd} != '') " ).append("\n"); 
		query.append("                    AND    RM.PROP_USR_ID    = @[prop_scp_ofc_srep_cd] -- Requested by Staff(Only Master use) [RFA 효율화를 위한 요청 (1차) (CHM-201640671)]" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                    #if (${svc_scp_cd} != '') " ).append("\n"); 
		query.append("                    AND    RS.SVC_SCP_CD          = @[svc_scp_cd] -- SVC Scope" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                    AND    RS.EFF_DT              <= TO_DATE(@[exp_dt], 'YYYY-MM-DD') -- Effective Date(To) or Access Date" ).append("\n"); 
		query.append("                    AND    RS.EXP_DT              >= TO_DATE(@[eff_dt], 'YYYY-MM-DD') -- Effective Date(From) or Access Date" ).append("\n"); 
		query.append("                    #if (${customer_code} == 'C' && ${ctrt_cust_cnt_cd} != '' && ${ctrt_cust_seq} != '') " ).append("\n"); 
		query.append("                    AND    RM.CTRT_CUST_CNT_CD = @[ctrt_cust_cnt_cd] -- Customer code" ).append("\n"); 
		query.append("                    AND    RM.CTRT_CUST_SEQ    = @[ctrt_cust_seq]    -- Customer code" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                    #if (${customer_code} == 'A' && ${ctrt_cust_cnt_cd} != '' && ${ctrt_cust_seq} != '') -- Actual Customer" ).append("\n"); 
		query.append("                    AND    EXISTS  (" ).append("\n"); 
		query.append("                                    SELECT  'X'" ).append("\n"); 
		query.append("                                    FROM    PRI_RP_SCP_RT_ACT_CUST  AC" ).append("\n"); 
		query.append("                                    WHERE   AC.PROP_NO     = RS.PROP_NO" ).append("\n"); 
		query.append("                                    AND     AC.AMDT_SEQ    = RS.AMDT_SEQ" ).append("\n"); 
		query.append("                                    AND     AC.SVC_SCP_CD  = RS.SVC_SCP_CD" ).append("\n"); 
		query.append("                                    AND     AC.CUST_CNT_CD = @[ctrt_cust_cnt_cd] -- Actual Customer" ).append("\n"); 
		query.append("                                    AND     AC.CUST_SEQ    = @[ctrt_cust_seq] -- Actual Customer" ).append("\n"); 
		query.append("                                   )" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                    #if (${customer_code} == 'F' && ${ctrt_cust_cnt_cd} != '' && ${ctrt_cust_seq} != '')  -- Affiliate" ).append("\n"); 
		query.append("                    AND    EXISTS  (" ).append("\n"); 
		query.append("                                    SELECT  'X'" ).append("\n"); 
		query.append("                                    FROM    PRI_RP_AFIL AF" ).append("\n"); 
		query.append("                                    WHERE   AF.PROP_NO     = RM.PROP_NO" ).append("\n"); 
		query.append("                                    AND     AF.AMDT_SEQ    = RM.AMDT_SEQ" ).append("\n"); 
		query.append("                                    AND     AF.CUST_CNT_CD = @[ctrt_cust_cnt_cd] -- Affiliate" ).append("\n"); 
		query.append("                                    AND     AF.CUST_SEQ    = @[ctrt_cust_seq] -- Affiliate" ).append("\n"); 
		query.append("                                   )" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                    #if (${rfa_ctrt_tp_cd} != '')" ).append("\n"); 
		query.append("                    AND    RM.RFA_CTRT_TP_CD = @[rfa_ctrt_tp_cd] -- RFA Type" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("        )SUB" ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append("SELECT  SVC_SCP_CD          ," ).append("\n"); 
		query.append("        RFA_NO              ," ).append("\n"); 
		query.append("        LPAD(AMDT_SEQ,3,0) AS AMDT_SEQ ," ).append("\n"); 
		query.append("        PRC_CTRT_CUST_TP_CD ," ).append("\n"); 
		query.append("		(SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD00779' AND INTG_CD_VAL_CTNT = A.PRC_CTRT_CUST_TP_CD) AS PRC_CTRT_CUST_TP_NM ," ).append("\n"); 
		query.append("        CTRT_CUST_CNT_CD    ," ).append("\n"); 
		query.append("        CTRT_CUST_SEQ       ," ).append("\n"); 
		query.append("	    CTRT_CUST_CNT_CD || LPAD(CTRT_CUST_SEQ,6,0) AS CODE ," ).append("\n"); 
		query.append("        CUST_NM             ," ).append("\n"); 
		query.append("        PROP_SCP_OFC_CD     ," ).append("\n"); 
		query.append("        ----------------------------------------------------------------------------" ).append("\n"); 
		query.append("        SVC_TGT_QTY         ,				-- ADD" ).append("\n"); 
		query.append("        MN_TGT_QTY          ,				-- ADD" ).append("\n"); 
		query.append("        DMDT_FT_TP_NM       ,				-- ADD      " ).append("\n"); 
		query.append("        PROP_SREP_NM AS PROP_SCP_SREP_NM , 	--ADD" ).append("\n"); 
		query.append("        ----------------------------------------------------------------------------" ).append("\n"); 
		query.append("        PROP_SREP_CD AS PROP_SCP_SREP_CD, -- PROP_SREP_CD로 수정" ).append("\n"); 
		query.append("        TO_CHAR(CTRT_EFF_DT,'YYYY-MM-DD') AS CTRT_EFF_DT ," ).append("\n"); 
		query.append("        TO_CHAR(CTRT_EXP_DT,'YYYY-MM-DD') AS CTRT_EXP_DT ," ).append("\n"); 
		query.append("        RFA_CTRT_TP_CD      ," ).append("\n"); 
		query.append("        ACT_CUST_NM         ," ).append("\n"); 
		query.append("        '' AS EFF_DT        , -- param" ).append("\n"); 
		query.append("        '' AS EXP_DT        , -- param" ).append("\n"); 
		query.append("        '' AS CUSTOMER_CODE   -- param" ).append("\n"); 
		query.append("FROM    RA  A" ).append("\n"); 
		query.append("WHERE   NOT EXISTS (" ).append("\n"); 
		query.append("                     SELECT  'X'" ).append("\n"); 
		query.append("                     FROM   RA B" ).append("\n"); 
		query.append("                     WHERE  B.RFA_NO     = A.RFA_NO" ).append("\n"); 
		query.append("                     AND    B.SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("                     AND    B.AMDT_SEQ   > A.AMDT_SEQ" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append(" AND    A.ROW_NUMBER = 1" ).append("\n"); 
		query.append("#if (${cust_nm} != '')" ).append("\n"); 
		query.append(" AND    A.CUST_IND = 1  -- customer name" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${act_cust_nm} != '')" ).append("\n"); 
		query.append(" AND    A.ACT_CUST_IND = 1  -- actual customer" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY SVC_SCP_CD, RFA_NO" ).append("\n"); 

	}
}