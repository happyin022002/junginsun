/*=========================================================
*Copyright(c) 2018 Hipluscard
*@FileName : SCProposalMainDBDAOPriSpInqRecListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.01.10
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2018.01.10 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG Min Seok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCProposalMainDBDAOPriSpInqRecListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PriSpOpenRecord 정보를 조회한다
	  * </pre>
	  */
	public SCProposalMainDBDAOPriSpInqRecListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("s_cust_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("lgin_ofc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_scrn_prog_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scrn_date_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_date_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scrn_date_from",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_date_from",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.integration").append("\n"); 
		query.append("FileName : SCProposalMainDBDAOPriSpInqRecListRSQL").append("\n"); 
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
		query.append("         N.SC_NO 		AS SC_NO" ).append("\n"); 
		query.append("        ,N.AMDT_SEQ 	AS AMDT_SEQ" ).append("\n"); 
		query.append("        ,N.PROP_NO  	AS PROP_NO                                               " ).append("\n"); 
		query.append("        ,N.CUST_NM 		AS CUST_NM" ).append("\n"); 
		query.append("        ,N.REAL_CUST_NM AS REAL_CUST_NM" ).append("\n"); 
		query.append("        ,N.CUST_TP_CD 	AS CUST_TP_CD " ).append("\n"); 
		query.append("        ,N.STATUS 		AS STATUS" ).append("\n"); 
		query.append("        ,N.FILE_DT 		AS FILE_DT " ).append("\n"); 
		query.append("        ,N.LGIN_ID 		AS LGIN_ID" ).append("\n"); 
		query.append("        ,N.USR_NM 		AS USR_NM" ).append("\n"); 
		query.append("        ,N.LGIN_OFC 	AS LGIN_OFC" ).append("\n"); 
		query.append("        ,N.SREP_CD   	AS SREP_CD   " ).append("\n"); 
		query.append("        ,N.IP_ADDR      AS IP_ADDR " ).append("\n"); 
		query.append("        ,N.DL_SCRN 		AS UI_NAME" ).append("\n"); 
		query.append("        ,N.OPEN_TIME    AS INQUIRY_TIME" ).append("\n"); 
		query.append("	    ,N.CTRT_OFC		AS PROP_OFC_CD" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("(SELECT" ).append("\n"); 
		query.append("        SH.SC_NO AS SC_NO      " ).append("\n"); 
		query.append("        ,SM.AMDT_SEQ AS AMDT_SEQ  " ).append("\n"); 
		query.append("        ,SH.PROP_NO  AS PROP_NO                                                " ).append("\n"); 
		query.append("        ,CP.CTRT_PTY_NM AS CUST_NM " ).append("\n"); 
		query.append("        ,(SELECT A.CUST_LGL_ENG_NM FROM MDM_CUSTOMER A WHERE A.CUST_CNT_CD = SM.REAL_CUST_CNT_CD AND A.CUST_SEQ = SM.REAL_CUST_SEQ) AS REAL_CUST_NM" ).append("\n"); 
		query.append("	,(SELECT INTG_CD_VAL_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD01714' AND INTG_CD_VAL_CTNT = NVL2(SM.REAL_CUST_CNT_CD, SM.REAL_CUST_TP_CD, CT.PRC_CTRT_CUST_TP_CD)) AS CUST_TP_CD" ).append("\n"); 
		query.append("        ,(SELECT INTG_CD_VAL_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD01722' AND INTG_CD_VAL_CTNT = SM.PROP_STS_CD) AS STATUS" ).append("\n"); 
		query.append("        ,TO_CHAR(SM.FILE_DT,'YYYY/MM/DD') AS FILE_DT " ).append("\n"); 
		query.append("        ,SR.CRE_USR_ID AS LGIN_ID" ).append("\n"); 
		query.append("        ,(SELECT A.USR_NM FROM COM_USER A WHERE A.USR_ID = SR.CRE_USR_ID AND ROWNUM =1 ) AS USR_NM" ).append("\n"); 
		query.append("        ,SR.CRE_OFC_CD AS LGIN_OFC" ).append("\n"); 
		query.append("	,(SELECT SREP_CD FROM MDM_SLS_REP WHERE EMPE_CD = SR.CRE_USR_ID AND SREP_STS_CD = 'N' AND ROWNUM =1 ) AS SREP_CD   " ).append("\n"); 
		query.append("        ,SR.LGIN_USR_IP      AS     IP_ADDR" ).append("\n"); 
		query.append("	,(SELECT INTG_CD_VAL_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD03561' AND INTG_CD_VAL_CTNT = SR.SP_SCRN_EVNT_PGM_CD) AS DL_SCRN" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if ( ${s_cur_tp_cd} == '' || ${s_cur_tp_cd} == 'KO' || ${s_cur_tp_cd} == 'SI' || ${s_cur_tp_cd} == 'SH' )" ).append("\n"); 
		query.append("        ,TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC('GMT',SR.SCRN_OPN_GDT,GLOBALDATE_PKG.GET_LOCCD_FNC('SELSC')),'YYYY/MM/DD HH24:MI:SS')  AS OPEN_TIME" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${s_cur_tp_cd} == 'NY')" ).append("\n"); 
		query.append("        ,TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC('GMT',SR.SCRN_OPN_GDT,GLOBALDATE_PKG.GET_LOCCD_FNC('NYCRA')),'YYYY/MM/DD HH24:MI:SS')  AS OPEN_TIME" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${s_cur_tp_cd} == 'HA')" ).append("\n"); 
		query.append("        ,TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC('GMT',SR.SCRN_OPN_GDT,GLOBALDATE_PKG.GET_LOCCD_FNC('HAMRU')),'YYYY/MM/DD HH24:MI:SS')  AS OPEN_TIME" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("        ,PRI_SUB_OFC_MATCH( 1, SM.PROP_OFC_CD ) AS CTRT_OFC" ).append("\n"); 
		query.append("FROM    PRI_SP_HDR          SH  ," ).append("\n"); 
		query.append("        PRI_SP_MN           SM  ," ).append("\n"); 
		query.append("        PRI_SP_CTRT_PTY     CP  ," ).append("\n"); 
		query.append("        PRI_SP_CTRT_CUST_TP CT  ," ).append("\n"); 
		query.append("        PRI_SP_INQ_REC       SR  ," ).append("\n"); 
		query.append("        PRI_SP_DUR          SD                                             " ).append("\n"); 
		query.append("WHERE   SM.PROP_NO            = SH.PROP_NO" ).append("\n"); 
		query.append("AND     CP.PROP_NO            = SM.PROP_NO" ).append("\n"); 
		query.append("AND     CP.AMDT_SEQ           = SM.AMDT_SEQ" ).append("\n"); 
		query.append("AND     CP.PRC_CTRT_PTY_TP_CD = 'C'" ).append("\n"); 
		query.append("AND     CT.PROP_NO            = CP.PROP_NO" ).append("\n"); 
		query.append("AND     CT.AMDT_SEQ           = CP.AMDT_SEQ" ).append("\n"); 
		query.append("AND     CT.PRC_CTRT_PTY_TP_CD = CP.PRC_CTRT_PTY_TP_CD" ).append("\n"); 
		query.append("AND     SM.PROP_NO            = SD.PROP_NO" ).append("\n"); 
		query.append("AND     SM.AMDT_SEQ           = SD.AMDT_SEQ" ).append("\n"); 
		query.append("AND     SM.PROP_NO            = SR.PROP_NO" ).append("\n"); 
		query.append("AND     SM.AMDT_SEQ           = SR.AMDT_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${sc_no} != '')" ).append("\n"); 
		query.append("AND     SH.SC_NO LIKE @[sc_no] || '%'         -- S/C No" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${amdt_seq} != '')" ).append("\n"); 
		query.append("AND     SM.AMDT_SEQ LIKE @[amdt_seq] || '%'         -- AMD No" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("#if (${s_cust_tp_cd} != '')" ).append("\n"); 
		query.append("AND     NVL2(SM.REAL_CUST_CNT_CD, SM.REAL_CUST_TP_CD, CT.PRC_CTRT_CUST_TP_CD) = @[s_cust_tp_cd]     -- Customer Type" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cust_nm} != '')" ).append("\n"); 
		query.append("AND    UPPER(CP.CTRT_PTY_NM) LIKE '%' || @[cust_nm] || '%'  --Customer name" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${lgin_ofc} != '')" ).append("\n"); 
		query.append("AND  UPPER(SR.CRE_OFC_CD)  = @[lgin_ofc]        -- Login Office " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${s_scrn_prog_cd} != '')" ).append("\n"); 
		query.append("AND     SR.SP_SCRN_EVNT_PGM_CD = @[s_scrn_prog_cd]        -- Screen Type" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${eff_date_from} != '' && ${eff_date_to} != '')" ).append("\n"); 
		query.append("AND TO_DATE(@[eff_date_from],'yyyy-MM-dd') <= SD.CTRT_EXP_DT AND TO_DATE(@[eff_date_to], 'yyyy-MM-DD') >= SD.CTRT_EFF_DT		--Effective Date" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${scrn_date_from} != '' && ${scrn_date_to} != '')" ).append("\n"); 
		query.append("AND SR.SCRN_OPN_GDT BETWEEN TO_DATE(@[scrn_date_from],'YYYY-MM-DD HH24:MI:SS') - 9/24 AND (TO_DATE(@[scrn_date_to],'YYYY-MM-DD HH24:MI:SS') + 0.99999)- 9/24 " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") N" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${prop_ofc_cd} != '')" ).append("\n"); 
		query.append("AND     N.CTRT_OFC   = @[prop_ofc_cd]        -- Contract Office " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${scrn_date_from} != '' && ${scrn_date_to} != '')" ).append("\n"); 
		query.append("AND TO_DATE(N.OPEN_TIME ,'YYYY-MM-DD HH24:MI:SS') BETWEEN TO_DATE(@[scrn_date_from],'YYYY-MM-DD HH24:MI:SS')  AND TO_DATE(@[scrn_date_to],'YYYY-MM-DD HH24:MI:SS') + 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY OPEN_TIME DESC" ).append("\n"); 

	}
}