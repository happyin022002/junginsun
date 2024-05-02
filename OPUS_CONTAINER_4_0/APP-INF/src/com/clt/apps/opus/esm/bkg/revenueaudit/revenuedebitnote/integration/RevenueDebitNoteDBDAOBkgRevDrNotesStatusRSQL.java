/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RevenueDebitNoteDBDAOBkgRevDrNotesStatusRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.16
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2010.11.16 김태경
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.revenueaudit.revenuedebitnote.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author kim tae kyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RevenueDebitNoteDBDAOBkgRevDrNotesStatusRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RDN STATUS LIST
	  * </pre>
	  */
	public RevenueDebitNoteDBDAOBkgRevDrNotesStatusRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rdn_iss_dt_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rdn_iss_dt_from",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("respb_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("respb_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ctrt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rdn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_aud_tool_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rct_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rct_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.revenueaudit.revenuedebitnote.integration").append("\n"); 
		query.append("FileName : RevenueDebitNoteDBDAOBkgRevDrNotesStatusRSQL").append("\n"); 
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
		query.append("SELECT  A2.ISS_OFC_CD" ).append("\n"); 
		query.append(",       A2.RCT_RHQ_CD" ).append("\n"); 
		query.append(",       A2.RCT_OFC_CD" ).append("\n"); 
		query.append(",       A2.RESPB_RHQ_CD" ).append("\n"); 
		query.append(",       A2.RESPB_OFC_CD" ).append("\n"); 
		query.append(",       A2.BKG_NO" ).append("\n"); 
		query.append(",       A2.BL_NO" ).append("\n"); 
		query.append(",       A2.SC_RFA_NO" ).append("\n"); 
		query.append(",       DECODE(A2.CTRT_TP_CD,'R','RFA','S','S/C','TAA') CTRT_TP_CD" ).append("\n"); 
		query.append(",       A2.RDN_NO" ).append("\n"); 
		query.append(",       A2.RVIS_SEQ" ).append("\n"); 
		query.append(",       A2.RDN_STS_CD" ).append("\n"); 
		query.append(",       A2.RDN_STS_NM" ).append("\n"); 
		query.append(",       A2.UMCH_TP_CD" ).append("\n"); 
		query.append(",       A2.UMCH_SUB_TP_CD" ).append("\n"); 
		query.append(",       A2.RDN_ISS_RSN_CD" ).append("\n"); 
		query.append(",       A2.USD_AMT" ).append("\n"); 
		query.append(",       A2.UMCH_RMK" ).append("\n"); 
		query.append(",       A2.BKG_CORR_NO" ).append("\n"); 
		query.append(",       P1.RDN_RMK  OFFICE_RDN_RMK" ).append("\n"); 
		query.append(",       P2.RDN_RMK  RECEIVER_RDN_RMK" ).append("\n"); 
		query.append(",       A2.REV_AUD_TOOL_CD" ).append("\n"); 
		query.append(",       A2.REV_AUD_TOOL_NM" ).append("\n"); 
		query.append(",       TO_CHAR(A2.RDN_ISS_DT, 'YYYY-MM-DD')  RDN_ISS_DT" ).append("\n"); 
		query.append(",       ( SELECT TO_CHAR(MAX(A.CRE_DT),'YYYY-MM-DD') FROM BKG_REV_DR_NOTE_PROG A WHERE A.RDN_NO = A2.RDN_NO AND A.RVIS_SEQ = A2.RVIS_SEQ )  UPD_DT" ).append("\n"); 
		query.append(",       A2.CRE_USR_ID ISS_USR_ID" ).append("\n"); 
		query.append(",       CASE" ).append("\n"); 
		query.append("        WHEN  P1.RDN_STS_CD IN ( 'ST', 'CL' ) THEN P1.CRE_USR_ID" ).append("\n"); 
		query.append("        ELSE  NULL" ).append("\n"); 
		query.append("        END STL_USR_ID" ).append("\n"); 
		query.append(",       P2.CRE_USR_ID AS RECEIVER_USR_ID                                     --RDN_ISS_DT가 AC,RR,CR 인 경우의 유저 아이디" ).append("\n"); 
		query.append(",       ''  RDN_ISS_DT_FROM" ).append("\n"); 
		query.append(",       ''  RDN_ISS_DT_TO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("        SELECT  DN.ISS_OFC_CD                                                         --이슈오피스 코드" ).append("\n"); 
		query.append("        ,       DN.RCT_RHQ_CD                                                         --오피스 대분류" ).append("\n"); 
		query.append("        ,       DN.RCT_OFC_CD                                                         --오피스 소분류" ).append("\n"); 
		query.append("        ,       DN.BKG_NO" ).append("\n"); 
		query.append("        ,       BK.BL_NO                                                              --BL NO" ).append("\n"); 
		query.append("        ,       DECODE(BR.BKG_CTRT_TP_CD, 'S', BK.SC_NO, 'R', BK.RFA_NO, 'T', BK.TAA_NO)  SC_RFA_NO" ).append("\n"); 
		query.append("        ,       BR.BKG_CTRT_TP_CD CTRT_TP_CD                                          -- 계약 TYPE" ).append("\n"); 
		query.append("        ,       DN.RDN_NO" ).append("\n"); 
		query.append("        ,       DN.RVIS_SEQ" ).append("\n"); 
		query.append("        ,       DN.RDN_STS_CD                                                         --상태코드" ).append("\n"); 
		query.append("        ,       ( SELECT INTG_CD_VAL_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD01568' AND INTG_CD_VAL_CTNT = DN.RDN_STS_CD )            RDN_STS_NM" ).append("\n"); 
		query.append("        ,       ( SELECT UMCH_TP_DESC FROM BKG_REV_UMCH_TP WHERE UMCH_TP_CD = DN.UMCH_TP_CD )                                                 UMCH_TP_CD" ).append("\n"); 
		query.append("        ,       ( SELECT UMCH_SUB_TP_DESC FROM BKG_REV_UMCH_SUB_TP WHERE UMCH_TP_CD = DN.UMCH_TP_CD AND UMCH_SUB_TP_CD = DN.UMCH_SUB_TP_CD )  UMCH_SUB_TP_CD" ).append("\n"); 
		query.append("        ,       ( SELECT INTG_CD_VAL_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD01567' AND INTG_CD_VAL_CTNT = DN.RDN_ISS_RSN_CD )        RDN_ISS_RSN_CD" ).append("\n"); 
		query.append("        ,       DN.UMCH_RMK                                                           --Details" ).append("\n"); 
		query.append("        ,       DN.BKG_CORR_NO                                                        --CA NO" ).append("\n"); 
		query.append("        ,       DN.RDN_ISS_DT                                                         --ISSUE DATE" ).append("\n"); 
		query.append("        ,       DN.RESPB_RHQ_CD" ).append("\n"); 
		query.append("        ,       DN.RESPB_OFC_CD" ).append("\n"); 
		query.append("        ,       DN.REV_AUD_TOOL_CD" ).append("\n"); 
		query.append("        ,       DN.CRE_USR_ID                                                         --처음 생성한 유저 아이디" ).append("\n"); 
		query.append("        ,       ( SELECT INTG_CD_VAL_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD02371' AND INTG_CD_VAL_CTNT = DN.REV_AUD_TOOL_CD )       REV_AUD_TOOL_NM" ).append("\n"); 
		query.append("        ,       (" ).append("\n"); 
		query.append("                SELECT  SUM(ROUND(DA.DR_AMT / XR.USD_LOCL_XCH_RT, 2))" ).append("\n"); 
		query.append("                FROM    BKG_REV_DR_AMT  DA  ," ).append("\n"); 
		query.append("                        GL_MON_XCH_RT   XR" ).append("\n"); 
		query.append("                WHERE   XR.ACCT_XCH_RT_YRMON  = TO_CHAR(DN.RDN_ISS_DT, 'YYYYMM')" ).append("\n"); 
		query.append("                AND     XR.ACCT_XCH_RT_LVL    = '1'" ).append("\n"); 
		query.append("                AND     XR.CURR_CD            = DA.CURR_CD" ).append("\n"); 
		query.append("                AND     DA.RDN_NO             = DN.RDN_NO" ).append("\n"); 
		query.append("                AND     DA.RVIS_SEQ           = DN.RVIS_SEQ" ).append("\n"); 
		query.append("                )   USD_AMT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        FROM    BKG_REV_DR_NOTE DN  ," ).append("\n"); 
		query.append("                BKG_BOOKING     BK  ," ).append("\n"); 
		query.append("                BKG_RATE        BR" ).append("\n"); 
		query.append("        WHERE   BK.BKG_NO = DN.BKG_NO" ).append("\n"); 
		query.append("        AND     BR.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("        AND     ( DN.RDN_NO, DN.RVIS_SEQ )  IN  (" ).append("\n"); 
		query.append("                                                SELECT  RDN_NO        ," ).append("\n"); 
		query.append("                                                        MAX(RVIS_SEQ)" ).append("\n"); 
		query.append("                                                FROM    BKG_REV_DR_NOTE" ).append("\n"); 
		query.append("                                                GROUP BY" ).append("\n"); 
		query.append("                                                        RDN_NO" ).append("\n"); 
		query.append("                                                )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if (${rct_rhq_cd} != '')" ).append("\n"); 
		query.append("        AND     DN.RCT_RHQ_CD   = @[rct_rhq_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${rct_ofc_cd} != '')" ).append("\n"); 
		query.append("        AND     DN.RCT_OFC_CD   = @[rct_ofc_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${respb_rhq_cd} != '')" ).append("\n"); 
		query.append("        AND     DN.RESPB_RHQ_CD = @[respb_rhq_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${respb_ofc_cd} != '')" ).append("\n"); 
		query.append("        AND     DN.RESPB_OFC_CD = @[respb_ofc_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append(" 		#if ('All'!=${umch_tp_cd} && ''!=${umch_tp_cd})" ).append("\n"); 
		query.append("           AND DN.UMCH_TP_CD IN (${umch_tp_cd})" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        #if (${rdn_iss_dt_from} != '')" ).append("\n"); 
		query.append("        AND     DN.RDN_ISS_DT   >= TO_DATE(@[rdn_iss_dt_from], 'YYYY/MM/DD')" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${rdn_iss_dt_to} != '')" ).append("\n"); 
		query.append("        AND     DN.RDN_ISS_DT   <= TO_DATE(@[rdn_iss_dt_to], 'YYYY/MM/DD') + 0.99999" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if (${rdn_no} != '')" ).append("\n"); 
		query.append("        AND   DN.RDN_NO         LIKE @[rdn_no] || '%'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${bl_no} != '')" ).append("\n"); 
		query.append("        AND   BK.BL_NO          LIKE @[bl_no] || '%'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if (${bkg_ctrt_tp_cd} != '')" ).append("\n"); 
		query.append("        AND   BR.BKG_CTRT_TP_CD     = @[bkg_ctrt_tp_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if (${rev_aud_tool_cd} != '')" ).append("\n"); 
		query.append("        AND   DN.REV_AUD_TOOL_CD  = @[rev_aud_tool_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if (${rdn_sts_cd} != '')" ).append("\n"); 
		query.append("        AND   DN.RDN_STS_CD     IN ( ${rdn_sts_cd} )" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        ) A2  ," ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("        SELECT  DP.RDN_NO" ).append("\n"); 
		query.append("        ,       DP.RVIS_SEQ" ).append("\n"); 
		query.append("        ,       DP.PROG_SEQ" ).append("\n"); 
		query.append("        ,       DP.RDN_STS_CD" ).append("\n"); 
		query.append("        ,       DP.RDN_RMK" ).append("\n"); 
		query.append("        ,       DP.CRE_USR_ID" ).append("\n"); 
		query.append("        ,       ROW_NUMBER() OVER ( PARTITION BY DP.RDN_NO ORDER BY DP.RVIS_SEQ DESC, DP.PROG_SEQ DESC )  ROW_NUMBER" ).append("\n"); 
		query.append("        FROM    BKG_REV_DR_NOTE_PROG  DP" ).append("\n"); 
		query.append("        WHERE     DP.RDN_STS_CD IN ( 'IS', 'RV', 'ST', 'CL' )" ).append("\n"); 
		query.append("        ) P1  ," ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("        SELECT  DP.RDN_NO" ).append("\n"); 
		query.append("        ,       DP.RVIS_SEQ" ).append("\n"); 
		query.append("        ,       DP.PROG_SEQ" ).append("\n"); 
		query.append("        ,       DP.RDN_STS_CD" ).append("\n"); 
		query.append("        ,       DP.RDN_RMK" ).append("\n"); 
		query.append("        ,       DP.CRE_USR_ID" ).append("\n"); 
		query.append("        ,       ROW_NUMBER() OVER ( PARTITION BY DP.RDN_NO ORDER BY DP.RVIS_SEQ DESC, DP.PROG_SEQ DESC )  ROW_NUMBER" ).append("\n"); 
		query.append("        FROM    BKG_REV_DR_NOTE_PROG  DP" ).append("\n"); 
		query.append("        WHERE     DP.RDN_STS_CD IN ( 'AC', 'RR', 'CR' )" ).append("\n"); 
		query.append("        ) P2" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE   P1.RDN_NO(+)      = A2.RDN_NO" ).append("\n"); 
		query.append("AND     P1.ROW_NUMBER(+)  = 1" ).append("\n"); 
		query.append("AND     P2.RDN_NO(+)      = A2.RDN_NO" ).append("\n"); 
		query.append("AND     P2.ROW_NUMBER(+)  = 1" ).append("\n"); 
		query.append("--AND     A2.USD_AMT IS NOT NULL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("        A2.RDN_NO   DESC" ).append("\n"); 

	}
}