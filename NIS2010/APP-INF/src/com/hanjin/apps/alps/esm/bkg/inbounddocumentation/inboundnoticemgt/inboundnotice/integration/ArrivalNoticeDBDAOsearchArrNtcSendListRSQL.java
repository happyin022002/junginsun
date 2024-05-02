/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ArrivalNoticeDBDAOsearchArrNtcSendListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.14
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.14 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ArrivalNoticeDBDAOsearchArrNtcSendListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 0381 조회 쿼리
	  * </pre>
	  */
	public ArrivalNoticeDBDAOsearchArrNtcSendListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eml_scs_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("c_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fax_scs_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_eta_dt_end",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ts_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("is_validated",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hub_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_eta_dt_start",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration").append("\n"); 
		query.append("FileName : ArrivalNoticeDBDAOsearchArrNtcSendListRSQL").append("\n"); 
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
		query.append("SELECT     INQR.VSL_CD" ).append("\n"); 
		query.append("         , INQR.SKD_VOY_NO" ).append("\n"); 
		query.append("         , INQR.SKD_DIR_CD" ).append("\n"); 
		query.append("         , INQR.VVD" ).append("\n"); 
		query.append("         , INQR.CHK_FAX" ).append("\n"); 
		query.append("         , INQR.CHK_EMAIL" ).append("\n"); 
		query.append("         , INQR.AN_FOM_CD" ).append("\n"); 
		query.append("         , INQR.BKG_NO" ).append("\n"); 
		query.append("         , INQR.CHG_DP_FLG" ).append("\n"); 
		query.append("         , INQR.BL_NO" ).append("\n"); 
		query.append("         , INQR.BKG_CUST_TP_CD" ).append("\n"); 
		query.append("         , INQR.CUST_CNT_CD" ).append("\n"); 
		query.append("         , INQR.CUST_SEQ" ).append("\n"); 
		query.append("         , INQR.SC_NO" ).append("\n"); 
		query.append("         , INQR.CUST_CD" ).append("\n"); 
		query.append("         , INQR.CUST_NM" ).append("\n"); 
		query.append("         , INQR.AN_SENT" ).append("\n"); 
		query.append("         , INQR.FAX_NO1" ).append("\n"); 
		query.append("         , INQR.FAX_NO2 " ).append("\n"); 
		query.append("         , INQR.FAX_NO3" ).append("\n"); 
		query.append("         , INQR.FAX_NO4" ).append("\n"); 
		query.append("         , INQR.FAX_NO5" ).append("\n"); 
		query.append("         , NVL(INQR.FAX_NO6,DECODE(SUBSTR(INQR.POD_CD,1,2),'US',BKG_GET_TOKEN_FNC(SC_A1_INFO,2),NULL)) FAX_NO6" ).append("\n"); 
		query.append("         , NVL(INQR.FAX_NO7,DECODE(SUBSTR(INQR.POD_CD,1,2),'US',BKG_GET_TOKEN_FNC(SC_A2_INFO,2),NULL)) FAX_NO7" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         , INQR.FAX_SND_FLG1" ).append("\n"); 
		query.append("         , INQR.FAX_SND_FLG2" ).append("\n"); 
		query.append("         , INQR.FAX_SND_FLG3" ).append("\n"); 
		query.append("         , INQR.FAX_SND_FLG4" ).append("\n"); 
		query.append("         , INQR.FAX_SND_FLG5" ).append("\n"); 
		query.append("         , INQR.FAX_SND_FLG6" ).append("\n"); 
		query.append("         , INQR.FAX_SND_FLG7" ).append("\n"); 
		query.append("         , INQR.FAX_NTC_SND_RSLT_CD1" ).append("\n"); 
		query.append("         , INQR.FAX_NTC_SND_RSLT_NM1  -- Fax전송 상태" ).append("\n"); 
		query.append("         , INQR.FAX_NTC_SND_RSLT_CD2" ).append("\n"); 
		query.append("         , INQR.FAX_NTC_SND_RSLT_NM2 -- Fax전송 상태" ).append("\n"); 
		query.append("         , INQR.FAX_NTC_SND_RSLT_CD3" ).append("\n"); 
		query.append("         , INQR.FAX_NTC_SND_RSLT_NM3 -- Fax전송 상태" ).append("\n"); 
		query.append("         , INQR.FAX_NTC_SND_RSLT_CD4" ).append("\n"); 
		query.append("         , INQR.FAX_NTC_SND_RSLT_NM4 -- Fax전송 상태" ).append("\n"); 
		query.append("         , INQR.FAX_NTC_SND_RSLT_CD5" ).append("\n"); 
		query.append("         , INQR.FAX_NTC_SND_RSLT_NM5 -- Fax전송 상태" ).append("\n"); 
		query.append("         , INQR.FAX_NTC_SND_RSLT_CD6" ).append("\n"); 
		query.append("         , INQR.FAX_NTC_SND_RSLT_NM6 -- Fax전송 상태" ).append("\n"); 
		query.append("         , INQR.FAX_NTC_SND_RSLT_CD7" ).append("\n"); 
		query.append("         , INQR.FAX_NTC_SND_RSLT_NM7 -- Fax전송 상태" ).append("\n"); 
		query.append("         , INQR.FAX_SND_DT" ).append("\n"); 
		query.append("         , INQR.FAX_EVNT_FLG1" ).append("\n"); 
		query.append("         , INQR.FAX_EVNT_FLG2" ).append("\n"); 
		query.append("         , INQR.FAX_EVNT_FLG3" ).append("\n"); 
		query.append("         , INQR.FAX_EVNT_FLG4" ).append("\n"); 
		query.append("         , INQR.FAX_EVNT_FLG5" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         /* POD가 US SC No.로 세팅된 정보가 있으면 1,0 */" ).append("\n"); 
		query.append("         , DECODE(SUBSTR(INQR.POD_CD,1,2),'US',NVL2(NVL(INQR.FAX_NO6,BKG_GET_TOKEN_FNC(SC_A1_INFO,2)),1,0),0) FAX_EVNT_FLG6" ).append("\n"); 
		query.append("         , DECODE(SUBSTR(INQR.POD_CD,1,2),'US',NVL2(NVL(INQR.FAX_NO7,BKG_GET_TOKEN_FNC(SC_A2_INFO,2)),1,0),0) FAX_EVNT_FLG7" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         , INQR.NTC_EML1" ).append("\n"); 
		query.append("         , INQR.NTC_EML2" ).append("\n"); 
		query.append("         , INQR.NTC_EML3" ).append("\n"); 
		query.append("         , INQR.NTC_EML4" ).append("\n"); 
		query.append("         , INQR.NTC_EML5" ).append("\n"); 
		query.append("          /* POD가 US SC No.로 세팅된 정보*/" ).append("\n"); 
		query.append("         , NVL(INQR.NTC_EML6,DECODE(SUBSTR(INQR.POD_CD,1,2),'US',BKG_GET_TOKEN_FNC(SC_A1_INFO,3),NULL)) NTC_EML6" ).append("\n"); 
		query.append("         , NVL(INQR.NTC_EML7,DECODE(SUBSTR(INQR.POD_CD,1,2),'US',BKG_GET_TOKEN_FNC(SC_A2_INFO,3),NULL)) NTC_EML7" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         , INQR.EML_SND_FLG1" ).append("\n"); 
		query.append("         , INQR.EML_SND_FLG2" ).append("\n"); 
		query.append("         , INQR.EML_SND_FLG3" ).append("\n"); 
		query.append("         , INQR.EML_SND_FLG4" ).append("\n"); 
		query.append("         , INQR.EML_SND_FLG5" ).append("\n"); 
		query.append("         , INQR.EML_SND_FLG6" ).append("\n"); 
		query.append("         , INQR.EML_SND_FLG7" ).append("\n"); 
		query.append("         , INQR.EML_NTC_SND_RSLT_CD1" ).append("\n"); 
		query.append("         , INQR.EML_NTC_SND_RSLT_NM1  -- RD E-MAIL전송 상태" ).append("\n"); 
		query.append("         , INQR.EML_NTC_SND_RSLT_CD2" ).append("\n"); 
		query.append("         , INQR.EML_NTC_SND_RSLT_NM2  -- RD E-MAIL전송 상태" ).append("\n"); 
		query.append("         , INQR.EML_NTC_SND_RSLT_CD3" ).append("\n"); 
		query.append("         , INQR.EML_NTC_SND_RSLT_NM3  -- RD E-MAIL전송 상태" ).append("\n"); 
		query.append("         , INQR.EML_NTC_SND_RSLT_CD4" ).append("\n"); 
		query.append("         , INQR.EML_NTC_SND_RSLT_NM4  -- RD E-MAIL전송 상태" ).append("\n"); 
		query.append("         , INQR.EML_NTC_SND_RSLT_CD5" ).append("\n"); 
		query.append("         , INQR.EML_NTC_SND_RSLT_NM5  -- RD E-MAIL전송 상태" ).append("\n"); 
		query.append("         , INQR.EML_NTC_SND_RSLT_CD6" ).append("\n"); 
		query.append("         , INQR.EML_NTC_SND_RSLT_NM6  -- RD E-MAIL전송 상태" ).append("\n"); 
		query.append("         , INQR.EML_NTC_SND_RSLT_CD7" ).append("\n"); 
		query.append("         , INQR.EML_NTC_SND_RSLT_NM7  -- RD E-MAIL전송 상태" ).append("\n"); 
		query.append("         , INQR.EML_SND_DT" ).append("\n"); 
		query.append("         , INQR.EML_EVNT_FLG1" ).append("\n"); 
		query.append("         , INQR.EML_EVNT_FLG2" ).append("\n"); 
		query.append("         , INQR.EML_EVNT_FLG3" ).append("\n"); 
		query.append("         , INQR.EML_EVNT_FLG4" ).append("\n"); 
		query.append("         , INQR.EML_EVNT_FLG5" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         /* POD가 US SC No.로 세팅된 정보가 있으면 1,0 */" ).append("\n"); 
		query.append("         , DECODE(SUBSTR(INQR.POD_CD,1,2),'US',NVL2(NVL(INQR.NTC_EML6,BKG_GET_TOKEN_FNC(SC_A1_INFO,3)),1,0),0) EML_EVNT_FLG6" ).append("\n"); 
		query.append("         , DECODE(SUBSTR(INQR.POD_CD,1,2),'US',NVL2(NVL(INQR.NTC_EML7,BKG_GET_TOKEN_FNC(SC_A2_INFO,3)),1,0),0) EML_EVNT_FLG7  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         , INQR.CSTMS_CLR_TP_CD" ).append("\n"); 
		query.append("         , INQR.HUB_LOC_CD" ).append("\n"); 
		query.append("         , INQR.POD_CD" ).append("\n"); 
		query.append("         , INQR.DEL_CD" ).append("\n"); 
		query.append("         , INQR.DE_TERM_CD" ).append("\n"); 
		query.append("         , INQR.IS_HOLD" ).append("\n"); 
		query.append("         , INQR.USR_ID" ).append("\n"); 
		query.append("         , INQR.DIFF_RMK" ).append("\n"); 
		query.append("         , INQR.SND_USR_ID" ).append("\n"); 
		query.append("         , INQR.USR_NM" ).append("\n"); 
		query.append("         , INQR.FILE_KEY" ).append("\n"); 
		query.append("         , INQR.IS_VALIDATED" ).append("\n"); 
		query.append("         , INQR.BKG_CGO_TP_CD" ).append("\n"); 
		query.append("         , INQR.RVIS_FLG" ).append("\n"); 
		query.append("         , INQR.TS_FLG" ).append("\n"); 
		query.append("         , INQR.RD_PRT_FLG" ).append("\n"); 
		query.append("         , NTWD.ARR_PRV_FOM_CD    -- LOCAL LANGUAGE FLAG" ).append("\n"); 
		query.append("         , NTWD.LOCL_LANG_FLG     -- LOCAL LANGUAGE FLAG" ).append("\n"); 
		query.append("         , NTWD.ECLZ_BL_CPY_FLG  -- ORIGINAL B/L COPY 여부" ).append("\n"); 
		query.append("         , HDG.ATTR_CTNT4 AS MRD_ID            -- MRD_ID" ).append("\n"); 
		query.append("         , HDG.ATTR_CTNT5 || HDG.ATTR_CTNT6 AS COM_PARAM -- 공통적으로 붙는 파라미터" ).append("\n"); 
		query.append("		 , NVL( ( SELECT 'Y' " ).append("\n"); 
		query.append("                   FROM BKG_HRD_CDG_CTNT " ).append("\n"); 
		query.append("                  WHERE HRD_CDG_ID ='ARR_NTC_EDI_CUST_CD' " ).append("\n"); 
		query.append("                  AND   ATTR_CTNT1=INQR.CUST_CNT_CD " ).append("\n"); 
		query.append("                  AND ATTR_CTNT2 =INQR.CUST_SEQ ),'N') EDI_SND_FLG" ).append("\n"); 
		query.append("         , INQR.EDI_SND_DT      " ).append("\n"); 
		query.append("         , INQR.EDI_SND_USR_ID" ).append("\n"); 
		query.append("	     , INQR.FRT_TERM_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT SUBQ.VSL_CD" ).append("\n"); 
		query.append("         , SUBQ.SKD_VOY_NO" ).append("\n"); 
		query.append("         , SUBQ.SKD_DIR_CD" ).append("\n"); 
		query.append("         , SUBQ.VVD" ).append("\n"); 
		query.append("         , 0 AS CHK_FAX" ).append("\n"); 
		query.append("         , 0 AS CHK_EMAIL" ).append("\n"); 
		query.append("         , ANTC.AN_FOM_CD" ).append("\n"); 
		query.append("         , SUBQ.BKG_NO" ).append("\n"); 
		query.append("         , DECODE(SUBQ.CHG_DP_FLG_BY_FRT_TERM, SUBQ.CHG_DP_FLG, SUBQ.CHG_DP_FLG_BY_FRT_TERM, SUBQ.CHG_DP_FLG) AS CHG_DP_FLG --Default 값으로 Prepaid는 Y, Collect는 N으로 보여주되, Customer 테이블에 저장된 값을 우선으로 보여준다." ).append("\n"); 
		query.append("         , SUBQ.BL_NO" ).append("\n"); 
		query.append("         , SUBQ.BKG_CUST_TP_CD" ).append("\n"); 
		query.append("         , SUBQ.CUST_CNT_CD" ).append("\n"); 
		query.append("         , SUBQ.CUST_SEQ" ).append("\n"); 
		query.append("         , SUBQ.SC_NO" ).append("\n"); 
		query.append("         , SUBQ.CUST_CD" ).append("\n"); 
		query.append("         , SUBQ.CUST_NM" ).append("\n"); 
		query.append("         , CASE WHEN" ).append("\n"); 
		query.append("                    ( NVL(SUBQ.FAX_NTC_SND_RSLT_CD1,' ') = @[fax_scs_cd] OR" ).append("\n"); 
		query.append("                      NVL(SUBQ.FAX_NTC_SND_RSLT_CD2,' ') = @[fax_scs_cd] OR" ).append("\n"); 
		query.append("                      NVL(SUBQ.FAX_NTC_SND_RSLT_CD3,' ') = @[fax_scs_cd] OR" ).append("\n"); 
		query.append("                      NVL(SUBQ.FAX_NTC_SND_RSLT_CD4,' ') = @[fax_scs_cd] OR" ).append("\n"); 
		query.append("                      NVL(SUBQ.FAX_NTC_SND_RSLT_CD5,' ') = @[fax_scs_cd] OR" ).append("\n"); 
		query.append("                      NVL(SUBQ.FAX_NTC_SND_RSLT_CD6,' ') = @[fax_scs_cd] OR" ).append("\n"); 
		query.append("                      NVL(SUBQ.FAX_NTC_SND_RSLT_CD7,' ') = @[fax_scs_cd] " ).append("\n"); 
		query.append("                     )" ).append("\n"); 
		query.append("                      AND" ).append("\n"); 
		query.append("                    ( NVL(SUBQ.EML_NTC_SND_RSLT_CD1,' ') = @[eml_scs_cd] OR" ).append("\n"); 
		query.append("                      NVL(SUBQ.EML_NTC_SND_RSLT_CD2,' ') = @[eml_scs_cd] OR" ).append("\n"); 
		query.append("                      NVL(SUBQ.EML_NTC_SND_RSLT_CD3,' ') = @[eml_scs_cd] OR" ).append("\n"); 
		query.append("                      NVL(SUBQ.EML_NTC_SND_RSLT_CD4,' ') = @[eml_scs_cd] OR" ).append("\n"); 
		query.append("                      NVL(SUBQ.EML_NTC_SND_RSLT_CD5,' ') = @[eml_scs_cd] OR" ).append("\n"); 
		query.append("                      NVL(SUBQ.EML_NTC_SND_RSLT_CD6,' ') = @[eml_scs_cd] OR" ).append("\n"); 
		query.append("                      NVL(SUBQ.EML_NTC_SND_RSLT_CD7,' ') = @[eml_scs_cd] " ).append("\n"); 
		query.append("                    )  THEN 'Both'" ).append("\n"); 
		query.append("                WHEN" ).append("\n"); 
		query.append("                    ( NVL(SUBQ.FAX_NTC_SND_RSLT_CD1,' ') = @[fax_scs_cd] OR" ).append("\n"); 
		query.append("                      NVL(SUBQ.FAX_NTC_SND_RSLT_CD2,' ') = @[fax_scs_cd] OR" ).append("\n"); 
		query.append("                      NVL(SUBQ.FAX_NTC_SND_RSLT_CD3,' ') = @[fax_scs_cd] OR" ).append("\n"); 
		query.append("                      NVL(SUBQ.FAX_NTC_SND_RSLT_CD4,' ') = @[fax_scs_cd] OR" ).append("\n"); 
		query.append("                      NVL(SUBQ.FAX_NTC_SND_RSLT_CD5,' ') = @[fax_scs_cd] OR" ).append("\n"); 
		query.append("                      NVL(SUBQ.FAX_NTC_SND_RSLT_CD6,' ') = @[fax_scs_cd] OR" ).append("\n"); 
		query.append("                      NVL(SUBQ.FAX_NTC_SND_RSLT_CD7,' ') = @[fax_scs_cd] " ).append("\n"); 
		query.append("                     )" ).append("\n"); 
		query.append("                      AND" ).append("\n"); 
		query.append("                    ( NVL(SUBQ.EML_NTC_SND_RSLT_CD1,' ') <> @[eml_scs_cd] AND" ).append("\n"); 
		query.append("                      NVL(SUBQ.EML_NTC_SND_RSLT_CD2,' ') <> @[eml_scs_cd] AND" ).append("\n"); 
		query.append("                      NVL(SUBQ.EML_NTC_SND_RSLT_CD3,' ') <> @[eml_scs_cd] AND" ).append("\n"); 
		query.append("                      NVL(SUBQ.EML_NTC_SND_RSLT_CD4,' ') <> @[eml_scs_cd] AND" ).append("\n"); 
		query.append("                      NVL(SUBQ.EML_NTC_SND_RSLT_CD5,' ') <> @[eml_scs_cd] AND" ).append("\n"); 
		query.append("                      NVL(SUBQ.EML_NTC_SND_RSLT_CD6,' ') <> @[eml_scs_cd] AND" ).append("\n"); 
		query.append("                      NVL(SUBQ.EML_NTC_SND_RSLT_CD7,' ') <> @[eml_scs_cd] " ).append("\n"); 
		query.append("					)  THEN 'Fax'" ).append("\n"); 
		query.append("                WHEN" ).append("\n"); 
		query.append("                    ( NVL(SUBQ.FAX_NTC_SND_RSLT_CD1,' ') <> @[fax_scs_cd] AND" ).append("\n"); 
		query.append("                      NVL(SUBQ.FAX_NTC_SND_RSLT_CD2,' ') <> @[fax_scs_cd] AND" ).append("\n"); 
		query.append("                      NVL(SUBQ.FAX_NTC_SND_RSLT_CD3,' ') <> @[fax_scs_cd] AND" ).append("\n"); 
		query.append("                      NVL(SUBQ.FAX_NTC_SND_RSLT_CD4,' ') <> @[fax_scs_cd] AND" ).append("\n"); 
		query.append("                      NVL(SUBQ.FAX_NTC_SND_RSLT_CD5,' ') <> @[fax_scs_cd] AND" ).append("\n"); 
		query.append("                      NVL(SUBQ.FAX_NTC_SND_RSLT_CD6,' ') <> @[fax_scs_cd] AND" ).append("\n"); 
		query.append("                      NVL(SUBQ.FAX_NTC_SND_RSLT_CD7,' ') <> @[fax_scs_cd]" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("                      AND" ).append("\n"); 
		query.append("                    ( NVL(SUBQ.EML_NTC_SND_RSLT_CD1,' ') = @[eml_scs_cd] OR" ).append("\n"); 
		query.append("                      NVL(SUBQ.EML_NTC_SND_RSLT_CD2,' ') = @[eml_scs_cd] OR" ).append("\n"); 
		query.append("                      NVL(SUBQ.EML_NTC_SND_RSLT_CD3,' ') = @[eml_scs_cd] OR" ).append("\n"); 
		query.append("                      NVL(SUBQ.EML_NTC_SND_RSLT_CD4,' ') = @[eml_scs_cd] OR" ).append("\n"); 
		query.append("                      NVL(SUBQ.EML_NTC_SND_RSLT_CD5,' ') = @[eml_scs_cd] OR" ).append("\n"); 
		query.append("                      NVL(SUBQ.EML_NTC_SND_RSLT_CD6,' ') = @[eml_scs_cd] OR" ).append("\n"); 
		query.append("                      NVL(SUBQ.EML_NTC_SND_RSLT_CD7,' ') = @[eml_scs_cd]" ).append("\n"); 
		query.append("					)  THEN 'Email'" ).append("\n"); 
		query.append("                ELSE 'NO'" ).append("\n"); 
		query.append("           END AS AN_SENT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         , SUBQ.FAX_NO1" ).append("\n"); 
		query.append("         , SUBQ.FAX_NO2" ).append("\n"); 
		query.append("         , SUBQ.FAX_NO3" ).append("\n"); 
		query.append("         , SUBQ.FAX_NO4" ).append("\n"); 
		query.append("         , SUBQ.FAX_NO5" ).append("\n"); 
		query.append("         , SUBQ.FAX_NO6" ).append("\n"); 
		query.append("         , SUBQ.FAX_NO7" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         , SUBQ.FAX_SND_FLG1" ).append("\n"); 
		query.append("         , SUBQ.FAX_SND_FLG2" ).append("\n"); 
		query.append("         , SUBQ.FAX_SND_FLG3" ).append("\n"); 
		query.append("         , SUBQ.FAX_SND_FLG4" ).append("\n"); 
		query.append("         , SUBQ.FAX_SND_FLG5" ).append("\n"); 
		query.append("         , SUBQ.FAX_SND_FLG6" ).append("\n"); 
		query.append("         , SUBQ.FAX_SND_FLG7" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         , SUBQ.FAX_NTC_SND_RSLT_CD1" ).append("\n"); 
		query.append("         , BKG_COM_INTG_CD_NM_FNC('CD00959', SUBQ.FAX_NTC_SND_RSLT_CD1 ) AS FAX_NTC_SND_RSLT_NM1  -- Fax전송 상태" ).append("\n"); 
		query.append("         , SUBQ.FAX_NTC_SND_RSLT_CD2" ).append("\n"); 
		query.append("         , BKG_COM_INTG_CD_NM_FNC('CD00959', SUBQ.FAX_NTC_SND_RSLT_CD2 ) AS FAX_NTC_SND_RSLT_NM2 -- Fax전송 상태" ).append("\n"); 
		query.append("         , SUBQ.FAX_NTC_SND_RSLT_CD3" ).append("\n"); 
		query.append("         , BKG_COM_INTG_CD_NM_FNC('CD00959', SUBQ.FAX_NTC_SND_RSLT_CD3 ) AS FAX_NTC_SND_RSLT_NM3 -- Fax전송 상태" ).append("\n"); 
		query.append("         , SUBQ.FAX_NTC_SND_RSLT_CD4" ).append("\n"); 
		query.append("         , BKG_COM_INTG_CD_NM_FNC('CD00959', SUBQ.FAX_NTC_SND_RSLT_CD4 ) AS FAX_NTC_SND_RSLT_NM4 -- Fax전송 상태" ).append("\n"); 
		query.append("         , SUBQ.FAX_NTC_SND_RSLT_CD5" ).append("\n"); 
		query.append("         , BKG_COM_INTG_CD_NM_FNC('CD00959', SUBQ.FAX_NTC_SND_RSLT_CD5 ) AS FAX_NTC_SND_RSLT_NM5 -- Fax전송 상태" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         , SUBQ.FAX_NTC_SND_RSLT_CD6" ).append("\n"); 
		query.append("         , BKG_COM_INTG_CD_NM_FNC('CD00959', SUBQ.FAX_NTC_SND_RSLT_CD6 ) AS FAX_NTC_SND_RSLT_NM6 -- Fax전송 상태" ).append("\n"); 
		query.append("         , SUBQ.FAX_NTC_SND_RSLT_CD7" ).append("\n"); 
		query.append("         , BKG_COM_INTG_CD_NM_FNC('CD00959', SUBQ.FAX_NTC_SND_RSLT_CD6 ) AS FAX_NTC_SND_RSLT_NM7 -- Fax전송 상태" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         , SUBQ.FAX_SND_DT" ).append("\n"); 
		query.append("         , DECODE(SUBQ.FAX_NO1, NULL, 0, 1) AS FAX_EVNT_FLG1" ).append("\n"); 
		query.append("         , DECODE(SUBQ.FAX_NO2, NULL, 0, 1) AS FAX_EVNT_FLG2" ).append("\n"); 
		query.append("         , DECODE(SUBQ.FAX_NO3, NULL, 0, 1) AS FAX_EVNT_FLG3" ).append("\n"); 
		query.append("         , DECODE(SUBQ.FAX_NO4, NULL, 0, 1) AS FAX_EVNT_FLG4" ).append("\n"); 
		query.append("         , DECODE(SUBQ.FAX_NO5, NULL, 0, 1) AS FAX_EVNT_FLG5" ).append("\n"); 
		query.append("         , DECODE(SUBQ.FAX_NO6, NULL, 0, 1) AS FAX_EVNT_FLG6" ).append("\n"); 
		query.append("         , DECODE(SUBQ.FAX_NO7, NULL, 0, 1) AS FAX_EVNT_FLG7" ).append("\n"); 
		query.append("         , SUBQ.NTC_EML1" ).append("\n"); 
		query.append("         , SUBQ.NTC_EML2" ).append("\n"); 
		query.append("         , SUBQ.NTC_EML3" ).append("\n"); 
		query.append("         , SUBQ.NTC_EML4" ).append("\n"); 
		query.append("         , SUBQ.NTC_EML5" ).append("\n"); 
		query.append("         , SUBQ.NTC_EML6" ).append("\n"); 
		query.append("         , SUBQ.NTC_EML7" ).append("\n"); 
		query.append("         , SUBQ.EML_SND_FLG1" ).append("\n"); 
		query.append("         , SUBQ.EML_SND_FLG2" ).append("\n"); 
		query.append("         , SUBQ.EML_SND_FLG3" ).append("\n"); 
		query.append("         , SUBQ.EML_SND_FLG4" ).append("\n"); 
		query.append("         , SUBQ.EML_SND_FLG5" ).append("\n"); 
		query.append("         , SUBQ.EML_SND_FLG6" ).append("\n"); 
		query.append("         , SUBQ.EML_SND_FLG7" ).append("\n"); 
		query.append("         , SUBQ.EML_NTC_SND_RSLT_CD1" ).append("\n"); 
		query.append("         , BKG_COM_INTG_CD_NM_FNC('CD00960', SUBQ.EML_NTC_SND_RSLT_CD1 ) AS EML_NTC_SND_RSLT_NM1  -- RD E-MAIL전송 상태" ).append("\n"); 
		query.append("         , SUBQ.EML_NTC_SND_RSLT_CD2" ).append("\n"); 
		query.append("         , BKG_COM_INTG_CD_NM_FNC('CD00960', SUBQ.EML_NTC_SND_RSLT_CD2 ) AS EML_NTC_SND_RSLT_NM2  -- RD E-MAIL전송 상태" ).append("\n"); 
		query.append("         , SUBQ.EML_NTC_SND_RSLT_CD3" ).append("\n"); 
		query.append("         , BKG_COM_INTG_CD_NM_FNC('CD00960', SUBQ.EML_NTC_SND_RSLT_CD3 ) AS EML_NTC_SND_RSLT_NM3  -- RD E-MAIL전송 상태" ).append("\n"); 
		query.append("         , SUBQ.EML_NTC_SND_RSLT_CD4" ).append("\n"); 
		query.append("         , BKG_COM_INTG_CD_NM_FNC('CD00960', SUBQ.EML_NTC_SND_RSLT_CD4 ) AS EML_NTC_SND_RSLT_NM4  -- RD E-MAIL전송 상태" ).append("\n"); 
		query.append("         , SUBQ.EML_NTC_SND_RSLT_CD5" ).append("\n"); 
		query.append("         , BKG_COM_INTG_CD_NM_FNC('CD00960', SUBQ.EML_NTC_SND_RSLT_CD5 ) AS EML_NTC_SND_RSLT_NM5  -- RD E-MAIL전송 상태" ).append("\n"); 
		query.append("         , SUBQ.EML_NTC_SND_RSLT_CD6" ).append("\n"); 
		query.append("         , BKG_COM_INTG_CD_NM_FNC('CD00960', SUBQ.EML_NTC_SND_RSLT_CD6 ) AS EML_NTC_SND_RSLT_NM6  -- RD E-MAIL전송 상태" ).append("\n"); 
		query.append("         , SUBQ.EML_NTC_SND_RSLT_CD7" ).append("\n"); 
		query.append("         , BKG_COM_INTG_CD_NM_FNC('CD00960', SUBQ.EML_NTC_SND_RSLT_CD7 ) AS EML_NTC_SND_RSLT_NM7  -- RD E-MAIL전송 상태" ).append("\n"); 
		query.append("         , SUBQ.EML_SND_DT" ).append("\n"); 
		query.append("         , DECODE(SUBQ.NTC_EML1, NULL, 0, 1) AS EML_EVNT_FLG1" ).append("\n"); 
		query.append("         , DECODE(SUBQ.NTC_EML2, NULL, 0, 1) AS EML_EVNT_FLG2" ).append("\n"); 
		query.append("         , DECODE(SUBQ.NTC_EML3, NULL, 0, 1) AS EML_EVNT_FLG3" ).append("\n"); 
		query.append("         , DECODE(SUBQ.NTC_EML4, NULL, 0, 1) AS EML_EVNT_FLG4" ).append("\n"); 
		query.append("         , DECODE(SUBQ.NTC_EML5, NULL, 0, 1) AS EML_EVNT_FLG5" ).append("\n"); 
		query.append("         , DECODE(SUBQ.NTC_EML6, NULL, 0, 1) AS EML_EVNT_FLG6" ).append("\n"); 
		query.append("         , DECODE(SUBQ.NTC_EML7, NULL, 0, 1) AS EML_EVNT_FLG7" ).append("\n"); 
		query.append("         , DECODE(CADV.CSTMS_CLR_TP_CD, 'I', 'IT', 'LOCAL') AS CSTMS_CLR_TP_CD" ).append("\n"); 
		query.append("         , CBL.HUB_LOC_CD     AS HUB_LOC_CD" ).append("\n"); 
		query.append("         , SUBQ.POD_CD" ).append("\n"); 
		query.append("         , SUBQ.DEL_CD" ).append("\n"); 
		query.append("         , SUBQ.DE_TERM_CD" ).append("\n"); 
		query.append("         , (SELECT DECODE(COUNT(1), 1, 'Y', 'N')" ).append("\n"); 
		query.append("              FROM BKG_ARR_NTC_CNTR ACNT" ).append("\n"); 
		query.append("             WHERE ACNT.BKG_NO = SUBQ.BKG_NO" ).append("\n"); 
		query.append("               AND ACNT.HLD_FLG = 'Y'" ).append("\n"); 
		query.append("               AND ROWNUM = 1 ) AS IS_HOLD" ).append("\n"); 
		query.append("         , '' USR_ID" ).append("\n"); 
		query.append("         , NVL(ANTC.DIFF_RMK,USET.AN_RMK) AS DIFF_RMK" ).append("\n"); 
		query.append("         , SUBQ.SND_USR_ID" ).append("\n"); 
		query.append("         , CUSR.USR_NM" ).append("\n"); 
		query.append("         , '' AS FILE_KEY" ).append("\n"); 
		query.append("         , SUBQ.IS_VALIDATED" ).append("\n"); 
		query.append("         , SUBQ.BKG_CGO_TP_CD" ).append("\n"); 
		query.append("         , ANTC.NTC_RVIS_FLG AS RVIS_FLG" ).append("\n"); 
		query.append("         , NVL(@[ts_flg],'N') AS TS_FLG" ).append("\n"); 
		query.append("         , DECODE(@[ts_flg], 'Y', 'Y', DECODE(TRIM(DVVD.SKD_VOY_NO), NULL, 'N', 'Y')) AS RD_PRT_FLG -- RD를 출력하기 위한 기본요건을 갖추었는지 점검하는 Flag (2010 03 31 Park Mangeon)" ).append("\n"); 
		query.append("         , BKG_ARR_NTC_STUP_SEQ_FNC(SUBQ.BKG_NO,@[ofc_cd],'N') AS AN_SEQ" ).append("\n"); 
		query.append("		 , SUBQ.EDI_SND_DT      " ).append("\n"); 
		query.append("         , SUBQ.EDI_SND_USR_ID " ).append("\n"); 
		query.append("         , DECODE( SUBSTR(LOC.LOC_CD,1,2),'KR','KR'" ).append("\n"); 
		query.append("                                         ,'JP','JP'" ).append("\n"); 
		query.append("                                         ,'CN','CN'" ).append("\n"); 
		query.append("                                         ,'TW','CN'" ).append("\n"); 
		query.append("                                         ,'US','US'" ).append("\n"); 
		query.append("  										 ,'CA','CA'		" ).append("\n"); 
		query.append("                                         ,'AE','AE'" ).append("\n"); 
		query.append("                                         ,'*')     AS CNT_CD" ).append("\n"); 
		query.append("          , CASE  WHEN MDM.CNT_CD ='KR'" ).append("\n"); 
		query.append("                    OR MDM.CNT_CD ='JP'" ).append("\n"); 
		query.append("                    OR MDM.CNT_CD ='CN'" ).append("\n"); 
		query.append("                    OR MDM.CNT_CD ='TW'" ).append("\n"); 
		query.append("                    OR MDM.CNT_CD ='US'" ).append("\n"); 
		query.append("                    OR MDM.CNT_CD ='CA' " ).append("\n"); 
		query.append("                    OR MDM.CNT_CD ='AE' THEN  DECODE( MDM.SCONTI_CD,'AF','AF'" ).append("\n"); 
		query.append("                                                                   ,'MN','MN'" ).append("\n"); 
		query.append("                                                                   ,'EN','EN'" ).append("\n"); 
		query.append("																   ,'AM','AM'" ).append("\n"); 
		query.append("                                                                   ,'*' )" ).append("\n"); 
		query.append("                  ELSE DECODE( MDM.SCONTI_CD,'EN','EN'" ).append("\n"); 
		query.append("                                           ,'EC','EC'" ).append("\n"); 
		query.append("                                           ,'EE','EE'" ).append("\n"); 
		query.append("                                           ,'ES','ES'" ).append("\n"); 
		query.append("                                               ,'*' ) END AS CONTI_CD" ).append("\n"); 
		query.append("           , SUBQ.FRT_TERM_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           , DECODE(SUBSTR(SUBQ.POD_CD,1,2),'US',BKG_IB_AN_GET_ANTFY_FNC(SUBQ.SC_NO,SUBQ.CUST_CNT_CD||LPAD(SUBQ.CUST_SEQ,6,'0'),SUBQ.POD_CD,'A1' )) AS SC_A1_INFO -- SC No.로 매핑된 Also notify 정보 조회" ).append("\n"); 
		query.append("           , DECODE(SUBSTR(SUBQ.POD_CD,1,2),'US',BKG_IB_AN_GET_ANTFY_FNC(SUBQ.SC_NO,SUBQ.CUST_CNT_CD||LPAD(SUBQ.CUST_SEQ,6,'0'),SUBQ.POD_CD,'A2' )) AS SC_A2_INFO -- SC No.로 매핑된 Also notify 정보 조회" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("               MAX(BKGM.VSL_CD     ) AS VSL_CD" ).append("\n"); 
		query.append("             , MAX(BKGM.SKD_VOY_NO ) AS SKD_VOY_NO" ).append("\n"); 
		query.append("             , MAX(BKGM.SKD_DIR_CD ) AS SKD_DIR_CD" ).append("\n"); 
		query.append("             , MAX(BKGM.VSL_CD || BKGM.SKD_VOY_NO || BKGM.SKD_DIR_CD) AS VVD" ).append("\n"); 
		query.append("             , MAX(BKGM.BKG_NO        ) AS BKG_NO" ).append("\n"); 
		query.append("             , MAX(BKGM.CHG_DP_FLG    ) AS CHG_DP_FLG" ).append("\n"); 
		query.append("             , MAX(BKGM.CHG_DP_FLG_BY_FRT_TERM ) AS CHG_DP_FLG_BY_FRT_TERM" ).append("\n"); 
		query.append("             , BKGM.BL_NO" ).append("\n"); 
		query.append("             , BKGM.BKG_CUST_TP_CD" ).append("\n"); 
		query.append("             , MAX(BKGM.CUST_CNT_CD   ) AS CUST_CNT_CD" ).append("\n"); 
		query.append("             , MAX(BKGM.CUST_SEQ      ) AS CUST_SEQ" ).append("\n"); 
		query.append("             , MAX(BKGM.SC_NO         ) AS SC_NO" ).append("\n"); 
		query.append("             , MAX(BKGM.CUST_CNT_CD || DECODE(BKGM.CUST_SEQ, 0, NULL, NULL, NULL, LPAD(BKGM.CUST_SEQ, 6, '0'))) AS CUST_CD" ).append("\n"); 
		query.append("             , MAX(BKGM.CUST_NM       ) AS CUST_NM" ).append("\n"); 
		query.append("             , MAX(DECODE(ADTL.CUST_CNTC_TP_CD, 'C1', ADTL.FAX_NO      , NULL)) AS FAX_NO1" ).append("\n"); 
		query.append("             , MAX(DECODE(ADTL.CUST_CNTC_TP_CD, 'C2', ADTL.FAX_NO      , NULL)) AS FAX_NO2" ).append("\n"); 
		query.append("             , MAX(DECODE(ADTL.CUST_CNTC_TP_CD, 'B1', ADTL.FAX_NO      , NULL)) AS FAX_NO3" ).append("\n"); 
		query.append("             , MAX(DECODE(ADTL.CUST_CNTC_TP_CD, 'B2', ADTL.FAX_NO      , NULL)) AS FAX_NO4" ).append("\n"); 
		query.append("             , MAX(DECODE(ADTL.CUST_CNTC_TP_CD, 'AN', ADTL.FAX_NO      , NULL)) AS FAX_NO5" ).append("\n"); 
		query.append("             , MAX(DECODE(ADTL.CUST_CNTC_TP_CD, 'A1', ADTL.FAX_NO      , NULL)) AS FAX_NO6" ).append("\n"); 
		query.append("             , MAX(DECODE(ADTL.CUST_CNTC_TP_CD, 'A2', ADTL.FAX_NO      , NULL)) AS FAX_NO7" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("             , MAX(DECODE(ADTL.CUST_CNTC_TP_CD, 'C1', ADTL.FAX_SND_FLG , NULL)) AS FAX_SND_FLG1" ).append("\n"); 
		query.append("             , MAX(DECODE(ADTL.CUST_CNTC_TP_CD, 'C2', ADTL.FAX_SND_FLG , NULL)) AS FAX_SND_FLG2" ).append("\n"); 
		query.append("             , MAX(DECODE(ADTL.CUST_CNTC_TP_CD, 'B1', ADTL.FAX_SND_FLG , NULL)) AS FAX_SND_FLG3" ).append("\n"); 
		query.append("             , MAX(DECODE(ADTL.CUST_CNTC_TP_CD, 'B2', ADTL.FAX_SND_FLG , NULL)) AS FAX_SND_FLG4" ).append("\n"); 
		query.append("             , MAX(DECODE(ADTL.CUST_CNTC_TP_CD, 'AN', ADTL.FAX_SND_FLG , NULL)) AS FAX_SND_FLG5" ).append("\n"); 
		query.append("             , MAX(DECODE(ADTL.CUST_CNTC_TP_CD, 'A1', ADTL.FAX_SND_FLG , NULL)) AS FAX_SND_FLG6" ).append("\n"); 
		query.append("             , MAX(DECODE(ADTL.CUST_CNTC_TP_CD, 'A2', ADTL.FAX_SND_FLG , NULL)) AS FAX_SND_FLG7" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("             , MAX(DECODE(ADTL.CUST_CNTC_TP_CD, 'C1', NVL(ADTL.FAX_NTC_SND_RSLT_CD, FXSD.FAX_PROC_STS_CD) , NULL)) AS FAX_NTC_SND_RSLT_CD1" ).append("\n"); 
		query.append("             , MAX(DECODE(ADTL.CUST_CNTC_TP_CD, 'C2', NVL(ADTL.FAX_NTC_SND_RSLT_CD, FXSD.FAX_PROC_STS_CD) , NULL)) AS FAX_NTC_SND_RSLT_CD2" ).append("\n"); 
		query.append("             , MAX(DECODE(ADTL.CUST_CNTC_TP_CD, 'B1', NVL(ADTL.FAX_NTC_SND_RSLT_CD, FXSD.FAX_PROC_STS_CD) , NULL)) AS FAX_NTC_SND_RSLT_CD3" ).append("\n"); 
		query.append("             , MAX(DECODE(ADTL.CUST_CNTC_TP_CD, 'B2', NVL(ADTL.FAX_NTC_SND_RSLT_CD, FXSD.FAX_PROC_STS_CD) , NULL)) AS FAX_NTC_SND_RSLT_CD4" ).append("\n"); 
		query.append("             , MAX(DECODE(ADTL.CUST_CNTC_TP_CD, 'AN', NVL(ADTL.FAX_NTC_SND_RSLT_CD, FXSD.FAX_PROC_STS_CD) , NULL)) AS FAX_NTC_SND_RSLT_CD5" ).append("\n"); 
		query.append("             , MAX(DECODE(ADTL.CUST_CNTC_TP_CD, 'A1', NVL(ADTL.FAX_NTC_SND_RSLT_CD, FXSD.FAX_PROC_STS_CD) , NULL)) AS FAX_NTC_SND_RSLT_CD6" ).append("\n"); 
		query.append("             , MAX(DECODE(ADTL.CUST_CNTC_TP_CD, 'A2', NVL(ADTL.FAX_NTC_SND_RSLT_CD, FXSD.FAX_PROC_STS_CD) , NULL)) AS FAX_NTC_SND_RSLT_CD7" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("             , MAX(NVL(ADTL.FAX_SND_DT, FXSD.FAX_SND_LOCL_DT)) AS FAX_SND_DT" ).append("\n"); 
		query.append("             , MAX(DECODE(ADTL.CUST_CNTC_TP_CD, 'C1', ADTL.NTC_EML     , NULL)) AS NTC_EML1" ).append("\n"); 
		query.append("             , MAX(DECODE(ADTL.CUST_CNTC_TP_CD, 'C2', ADTL.NTC_EML     , NULL)) AS NTC_EML2" ).append("\n"); 
		query.append("             , MAX(DECODE(ADTL.CUST_CNTC_TP_CD, 'B1', ADTL.NTC_EML     , NULL)) AS NTC_EML3" ).append("\n"); 
		query.append("             , MAX(DECODE(ADTL.CUST_CNTC_TP_CD, 'B2', ADTL.NTC_EML     , NULL)) AS NTC_EML4" ).append("\n"); 
		query.append("             , MAX(DECODE(ADTL.CUST_CNTC_TP_CD, 'AN', ADTL.NTC_EML     , NULL)) AS NTC_EML5" ).append("\n"); 
		query.append("             , MAX(DECODE(ADTL.CUST_CNTC_TP_CD, 'A1', ADTL.NTC_EML     , NULL)) AS NTC_EML6" ).append("\n"); 
		query.append("             , MAX(DECODE(ADTL.CUST_CNTC_TP_CD, 'A2', ADTL.NTC_EML     , NULL)) AS NTC_EML7" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("             , MAX(DECODE(ADTL.CUST_CNTC_TP_CD, 'C1', ADTL.EML_SND_FLG , NULL)) AS EML_SND_FLG1" ).append("\n"); 
		query.append("             , MAX(DECODE(ADTL.CUST_CNTC_TP_CD, 'C2', ADTL.EML_SND_FLG , NULL)) AS EML_SND_FLG2" ).append("\n"); 
		query.append("             , MAX(DECODE(ADTL.CUST_CNTC_TP_CD, 'B1', ADTL.EML_SND_FLG , NULL)) AS EML_SND_FLG3" ).append("\n"); 
		query.append("             , MAX(DECODE(ADTL.CUST_CNTC_TP_CD, 'B2', ADTL.EML_SND_FLG , NULL)) AS EML_SND_FLG4" ).append("\n"); 
		query.append("             , MAX(DECODE(ADTL.CUST_CNTC_TP_CD, 'AN', ADTL.EML_SND_FLG , NULL)) AS EML_SND_FLG5" ).append("\n"); 
		query.append("             , MAX(DECODE(ADTL.CUST_CNTC_TP_CD, 'A1', ADTL.EML_SND_FLG , NULL)) AS EML_SND_FLG6" ).append("\n"); 
		query.append("             , MAX(DECODE(ADTL.CUST_CNTC_TP_CD, 'A2', ADTL.EML_SND_FLG , NULL)) AS EML_SND_FLG7" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("             , MAX(DECODE(ADTL.CUST_CNTC_TP_CD, 'C1', NVL(ADTL.EML_NTC_SND_RSLT_CD, EMSD.EML_PROC_STS_CD) , NULL)) AS EML_NTC_SND_RSLT_CD1" ).append("\n"); 
		query.append("             , MAX(DECODE(ADTL.CUST_CNTC_TP_CD, 'C2', NVL(ADTL.EML_NTC_SND_RSLT_CD, EMSD.EML_PROC_STS_CD) , NULL)) AS EML_NTC_SND_RSLT_CD2" ).append("\n"); 
		query.append("             , MAX(DECODE(ADTL.CUST_CNTC_TP_CD, 'B1', NVL(ADTL.EML_NTC_SND_RSLT_CD, EMSD.EML_PROC_STS_CD) , NULL)) AS EML_NTC_SND_RSLT_CD3" ).append("\n"); 
		query.append("             , MAX(DECODE(ADTL.CUST_CNTC_TP_CD, 'B2', NVL(ADTL.EML_NTC_SND_RSLT_CD, EMSD.EML_PROC_STS_CD) , NULL)) AS EML_NTC_SND_RSLT_CD4" ).append("\n"); 
		query.append("             , MAX(DECODE(ADTL.CUST_CNTC_TP_CD, 'AN', NVL(ADTL.EML_NTC_SND_RSLT_CD, EMSD.EML_PROC_STS_CD) , NULL)) AS EML_NTC_SND_RSLT_CD5" ).append("\n"); 
		query.append("             , MAX(DECODE(ADTL.CUST_CNTC_TP_CD, 'A1', NVL(ADTL.EML_NTC_SND_RSLT_CD, EMSD.EML_PROC_STS_CD) , NULL)) AS EML_NTC_SND_RSLT_CD6" ).append("\n"); 
		query.append("             , MAX(DECODE(ADTL.CUST_CNTC_TP_CD, 'A2', NVL(ADTL.EML_NTC_SND_RSLT_CD, EMSD.EML_PROC_STS_CD) , NULL)) AS EML_NTC_SND_RSLT_CD7" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("             , MAX(NVL(ADTL.EML_SND_DT, GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL',EMSD.EML_DT,GLOBALDATE_PKG.GET_LOCCD_FNC(@[ofc_cd]) ) )) EML_SND_DT" ).append("\n"); 
		query.append("             , MAX(BKGM.POD_CD    ) AS POD_CD" ).append("\n"); 
		query.append("             , MAX(BKGM.DEL_CD    ) AS DEL_CD" ).append("\n"); 
		query.append("             , MAX(BKGM.DE_TERM_CD) AS DE_TERM_CD" ).append("\n"); 
		query.append("             , CASE WHEN MAX(NVL(TO_CHAR( NVL(ADTL.EML_SND_DT,GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL',EMSD.EML_DT,BKGM.LOC_CD)), 'YYYYMMDDHH24MISS'),'00000000000000') || ADTL.EML_SND_USR_ID) >  MAX(NVL(TO_CHAR( NVL(ADTL.FAX_SND_DT,FXSD.FAX_SND_LOCL_DT), 'YYYYMMDDHH24MISS'),'00000000000000') || ADTL.FAX_SND_USR_ID)" ).append("\n"); 
		query.append("                       THEN SUBSTR(MAX(NVL(TO_CHAR(NVL(ADTL.EML_SND_DT,GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL',EMSD.EML_DT,(SELECT B.LOC_CD" ).append("\n"); 
		query.append("                                                                                                     FROM COM_USER A" ).append("\n"); 
		query.append("                                                                                                         ,MDM_ORGANIZATION B" ).append("\n"); 
		query.append("                                                                                                     WHERE A.USR_ID=@[usr_id]" ).append("\n"); 
		query.append("                              AND   A.OFC_CD = B.OFC_CD" ).append("\n"); 
		query.append("                                                                                                     AND   B.DELT_FLG='N' ) ) ), 'YYYYMMDDHH24MISS'),'00000000000000') || ADTL.EML_SND_USR_ID), 15)" ).append("\n"); 
		query.append("                    ELSE SUBSTR(MAX(NVL(TO_CHAR(NVL(ADTL.FAX_SND_DT,FXSD.FAX_SND_LOCL_DT), 'YYYYMMDDHH24MISS'),'00000000000000') || ADTL.FAX_SND_USR_ID), 15)" ).append("\n"); 
		query.append("               END AS SND_USR_ID" ).append("\n"); 
		query.append("             , 'US' CSTMS_CLR_TP_CNT_CD  -- outer join을 위해 선언" ).append("\n"); 
		query.append("             , @[usr_id]               AS LOGIN_USR_ID" ).append("\n"); 
		query.append("             , MAX(BKGM.IS_VALIDATED)  AS IS_VALIDATED" ).append("\n"); 
		query.append("             , MAX(BKGM.BKG_CGO_TP_CD) AS BKG_CGO_TP_CD" ).append("\n"); 
		query.append("             , MAX(BKGM.LOC_CD)        AS LOC_CD" ).append("\n"); 
		query.append("			 , MAX(ADTL.EDI_SND_DT)      AS EDI_SND_DT" ).append("\n"); 
		query.append("             , MAX(ADTL.EDI_SND_DT)      AS EDI_SND_USR_ID" ).append("\n"); 
		query.append("             , MAX(BKGM.FRT_TERM_CD) AS FRT_TERM_CD" ).append("\n"); 
		query.append("         FROM (" ).append("\n"); 
		query.append("                 SELECT" ).append("\n"); 
		query.append("                        BKGM.BKG_NO" ).append("\n"); 
		query.append("                      , DECODE( @[ts_flg],'Y', BKGM.PST_RLY_PORT_CD, BKGM.POD_CD) AS POD_CD" ).append("\n"); 
		query.append("                      , BKGM.DEL_CD" ).append("\n"); 
		query.append("                      , NVL(BKGM.SC_NO,BKGM.RFA_NO) AS SC_NO" ).append("\n"); 
		query.append("                      , VSKD.VSL_CD" ).append("\n"); 
		query.append("                      , VSKD.SKD_VOY_NO" ).append("\n"); 
		query.append("                      , VSKD.SKD_DIR_CD" ).append("\n"); 
		query.append("                      , BKGM.BL_NO" ).append("\n"); 
		query.append("                      , BKGM.DE_TERM_CD" ).append("\n"); 
		query.append("                      , BCST.BKG_CUST_TP_CD" ).append("\n"); 
		query.append("                      , BCST.AN_SND_FLG AS IS_VALIDATED" ).append("\n"); 
		query.append("                      , BCST.CUST_CNT_CD" ).append("\n"); 
		query.append("                      , BCST.CUST_SEQ" ).append("\n"); 
		query.append("                      , NVL(BCST.IB_CUST_NM,BCST.CUST_NM)  AS CUST_NM" ).append("\n"); 
		query.append("                      , NVL(BCST.IB_CUST_ADDR,BCST.CUST_ADDR) AS CUST_ADDR" ).append("\n"); 
		query.append("                      , BCST.VAL_CD" ).append("\n"); 
		query.append("                      , BCST.MTCH_FLG" ).append("\n"); 
		query.append("                      , BCST.CUST_FAX_NO" ).append("\n"); 
		query.append("                      , BCST.CUST_EML" ).append("\n"); 
		query.append("                      , BCST.CHG_DP_FLG " ).append("\n"); 
		query.append("                      , DECODE(NVL(BCHG.FRT_TERM_CD,'C'),'P','Y','C','N') CHG_DP_FLG_BY_FRT_TERM" ).append("\n"); 
		query.append("                      , CASE WHEN DECODE(BKGM.RC_FLG,'Y',1,0)     +DECODE(BKGM.DCGO_FLG,'Y',1,0)+" ).append("\n"); 
		query.append("                                  DECODE(BKGM.AWK_CGO_FLG,'Y',1,0)+DECODE(BKGM.SOC_FLG,'Y',1,0) +DECODE(BKGM.BB_CGO_FLG,'Y',1,0) > 1 THEN 'MX'" ).append("\n"); 
		query.append("                             WHEN DECODE(BKGM.RC_FLG,'Y',1,0)     +DECODE(BKGM.DCGO_FLG,'Y',1,0)+" ).append("\n"); 
		query.append("                                 DECODE(BKGM.AWK_CGO_FLG,'Y',1,0)+DECODE(BKGM.SOC_FLG,'Y',1,0) +DECODE(BKGM.BB_CGO_FLG,'Y',1,0) < 1 THEN 'DR'" ).append("\n"); 
		query.append("                             WHEN BKGM.RC_FLG      = 'Y' THEN 'RF'" ).append("\n"); 
		query.append("                             WHEN BKGM.DCGO_FLG    = 'Y' THEN 'DG'" ).append("\n"); 
		query.append("                             WHEN BKGM.AWK_CGO_FLG = 'Y' THEN 'AK'" ).append("\n"); 
		query.append("                             WHEN BKGM.SOC_FLG     = 'Y' THEN 'SO'" ).append("\n"); 
		query.append("                             WHEN BKGM.BB_CGO_FLG  = 'Y' THEN 'BB'END AS BKG_CGO_TP_CD" ).append("\n"); 
		query.append("                      , GLOBALDATE_PKG.GET_LOCCD_FNC(@[ofc_cd]) AS LOC_CD" ).append("\n"); 
		query.append("                      , BCHG.FRT_TERM_CD AS FRT_TERM_CD" ).append("\n"); 
		query.append("                 FROM VSK_VSL_PORT_SKD VSKD" ).append("\n"); 
		query.append("                    , BKG_VVD BVVD" ).append("\n"); 
		query.append("                    , BKG_BOOKING BKGM" ).append("\n"); 
		query.append("                    , BKG_CUSTOMER BCST" ).append("\n"); 
		query.append("                    , BKG_RATE BCHG" ).append("\n"); 
		query.append("                 WHERE 1 = 1" ).append("\n"); 
		query.append("    #if (${sch_tp} == 'V')" ).append("\n"); 
		query.append("                   AND BVVD.VSL_CD  = SUBSTR(@[vvd],1,4)      -- VVD (OPTIONAL 1)" ).append("\n"); 
		query.append("                   AND BVVD.SKD_VOY_NO = SUBSTR(@[vvd],5,4)   -- VVD (OPTIONAL 1)" ).append("\n"); 
		query.append("                   AND BVVD.SKD_DIR_CD = SUBSTR(@[vvd],9,1)   -- VVD (OPTIONAL 1)" ).append("\n"); 
		query.append("                   AND BVVD.POD_CD = @[pod_cd]                -- (OPTIONAL 3)" ).append("\n"); 
		query.append("    #elseif (${sch_tp} == 'D')" ).append("\n"); 
		query.append("                   AND VSKD.VPS_ETA_DT" ).append("\n"); 
		query.append("                       BETWEEN TO_DATE(@[vps_eta_dt_start], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("                           AND TO_DATE(@[vps_eta_dt_end], 'YYYY-MM-DD') +1  -- DURATION (OPTIONAL 2)" ).append("\n"); 
		query.append("                   AND VSKD.VPS_PORT_CD = @[pod_cd] -- (OPTIONAL 3)" ).append("\n"); 
		query.append("    #elseif (${sch_tp} == 'B')" ).append("\n"); 
		query.append("                   AND BKGM.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${sch_tp} != 'B' && ${pod_cd} != '' && ${ts_flg} == 'Y')" ).append("\n"); 
		query.append("                   AND BKGM.PST_RLY_PORT_CD = @[pod_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${sch_tp} != 'B' && ${del_cd} != '' )" ).append("\n"); 
		query.append("                   AND BKGM.DEL_CD LIKE @[del_cd] || '%'  -- DELIVERY PORT CD (OPTIONAL 4)" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${pol_cd} != '')" ).append("\n"); 
		query.append("                   AND BKGM.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${cust_cnt_cd} != '')" ).append("\n"); 
		query.append("                   AND BCST.CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${cust_seq} != '')" ).append("\n"); 
		query.append("                   AND BCST.CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${s_no} != '' && ${c_no} != '') " ).append("\n"); 
		query.append("				   AND BKGM.SC_NO = @[s_no]||@[c_no]" ).append("\n"); 
		query.append("	#elseif (${s_no} != '') " ).append("\n"); 
		query.append("                   AND BKGM.SC_NO LIKE @[s_no]||'%'" ).append("\n"); 
		query.append("	#elseif (${c_no} != '') " ).append("\n"); 
		query.append("                   AND BKGM.SC_NO LIKE '%'||@[c_no]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${cust_nm} != '') " ).append("\n"); 
		query.append("                   AND UPPER(BCST.CUST_NM) LIKE UPPER(@[cust_nm]) || '%'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${cust_ref_no} != '')" ).append("\n"); 
		query.append("                   AND EXISTS (SELECT 1" ).append("\n"); 
		query.append("                                 FROM BKG_REFERENCE" ).append("\n"); 
		query.append("                                WHERE BKG_REF_TP_CD = 'BKPO'" ).append("\n"); 
		query.append("                                  AND BKG_NO = BKGM.BKG_NO" ).append("\n"); 
		query.append("                                  AND CUST_REF_NO_CTNT = @[cust_ref_no]" ).append("\n"); 
		query.append("                           )" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${sch_tp} == 'D')" ).append("\n"); 
		query.append("                   AND BVVD.VSL_CD = VSKD.VSL_CD   -- Join의 방향성 때문에 Duration인 경우와 아닌 경우를 분리함" ).append("\n"); 
		query.append("                   AND BVVD.SKD_VOY_NO = VSKD.SKD_VOY_NO" ).append("\n"); 
		query.append("                   AND BVVD.SKD_DIR_CD = VSKD.SKD_DIR_CD" ).append("\n"); 
		query.append("                   AND BVVD.POD_CD = VSKD.VPS_PORT_CD" ).append("\n"); 
		query.append("                   AND BVVD.POD_CLPT_IND_SEQ = VSKD.CLPT_IND_SEQ" ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("                   AND BVVD.VSL_CD = VSKD.VSL_CD(+)  -- Duration이 아닌경우에는 데이터를 추출하기 위하여 해당과 같이 처리한다. (20100106 Park Mangeon)" ).append("\n"); 
		query.append("                   AND BVVD.SKD_VOY_NO = VSKD.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("                   AND BVVD.SKD_DIR_CD = VSKD.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("                   AND BVVD.POD_CD = VSKD.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("                   AND BVVD.POD_CLPT_IND_SEQ = VSKD.CLPT_IND_SEQ(+)" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("                   AND BKGM.BKG_NO =BVVD.BKG_NO" ).append("\n"); 
		query.append("    #if ( ${ts_flg} != 'Y')" ).append("\n"); 
		query.append("                   AND BKGM.POD_CD = BVVD.POD_CD  ------------ ts_flg != 'Y'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if ( ${ts_flg} == 'Y')" ).append("\n"); 
		query.append("                   AND BKGM.PST_RLY_PORT_CD = BVVD.POD_CD  --------- ts_flg == 'Y'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                   AND BKGM.BKG_STS_CD NOT IN( 'X', 'S')" ).append("\n"); 
		query.append("                   AND BKGM.BL_NO IS NOT NULL" ).append("\n"); 
		query.append("                   AND BKGM.BKG_CGO_TP_CD IN ('F', 'R')                           -------- modified by 0672-01" ).append("\n"); 
		query.append("                   AND BCST.BKG_NO = BKGM.BKG_NO" ).append("\n"); 
		query.append("                   AND BCST.BKG_CUST_TP_CD IN ('C', 'N')" ).append("\n"); 
		query.append("                   AND NVL(BCST.VAL_CD, '*') <> 'S'        -- modified 20100108 Park Mangeon" ).append("\n"); 
		query.append("                   AND (" ).append("\n"); 
		query.append("                            (BKGM.SAM_CNEE_NTFY_FLG = 'N'" ).append("\n"); 
		query.append("                             AND BKGM.CUST_TO_ORD_FLG = 'N' -- Consignee, Notify둘다 생성" ).append("\n"); 
		query.append("                            )" ).append("\n"); 
		query.append("                         OR (BKGM.SAM_CNEE_NTFY_FLG = 'Y'  -- Notify는 Consignee와 같으므로 Consignee만 생성" ).append("\n"); 
		query.append("                             AND BCST.BKG_CUST_TP_CD = 'C'" ).append("\n"); 
		query.append("                            )" ).append("\n"); 
		query.append("                         OR (BKGM.CUST_TO_ORD_FLG = 'Y'    -- Notify에게 연락하므로 Notify만 생성" ).append("\n"); 
		query.append("                             AND BCST.BKG_CUST_TP_CD = 'N'" ).append("\n"); 
		query.append("                            )" ).append("\n"); 
		query.append("                       )" ).append("\n"); 
		query.append("                    AND BKGM.BKG_NO = BCHG.BKG_NO" ).append("\n"); 
		query.append("    #if ( ${frt_term_cd} == 'P')" ).append("\n"); 
		query.append("                   AND BCHG.FRT_TERM_CD = 'P' " ).append("\n"); 
		query.append("    #elseif ( ${frt_term_cd} == 'C')" ).append("\n"); 
		query.append("                   AND BCHG.FRT_TERM_CD = 'C' " ).append("\n"); 
		query.append("    #else " ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${cntc_info_aval} != '')" ).append("\n"); 
		query.append("        #if (${cntc_info_aval} == 'Y')" ).append("\n"); 
		query.append("                       AND EXISTS " ).append("\n"); 
		query.append("       #elseif (${cntc_info_aval} == 'N')" ).append("\n"); 
		query.append("                       AND NOT EXISTS " ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("                               ( " ).append("\n"); 
		query.append("                                SELECT 'Y'" ).append("\n"); 
		query.append("                                  FROM BKG_ARR_NTC_DTL DTL" ).append("\n"); 
		query.append("                                 WHERE DTL.BKG_NO = BKGM.BKG_NO" ).append("\n"); 
		query.append("                                   AND ( DTL.FAX_NO IS NOT NULL OR DTL.NTC_EML IS NOT NULL) " ).append("\n"); 
		query.append("                               )" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   #if (${donot_snd_flg} != '')" ).append("\n"); 
		query.append("		AND EXISTS (SELECT 'Y' FROM BKG_ARR_NTC_DTL DTL WHERE DTL.BKG_NO = BKGM.BKG_NO AND (FAX_SND_FLG = 'N' OR EML_SND_FLG = 'N'))" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   #if (${hub_loc_cd} != '')" ).append("\n"); 
		query.append("		AND EXISTS ( SELECT 'Y' FROM BKG_CSTMS_ADV_BL  CBL WHERE CBL.CNT_CD = 'US' AND CBL.BL_NO = BKGM.BL_NO AND CBL.HUB_LOC_CD = @[hub_loc_cd])" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   #if (${cstms_loc_cd} != '')" ).append("\n"); 
		query.append("		AND EXISTS ( SELECT 'Y' FROM BKG_CSTMS_ADV_BL  CBL WHERE CBL.CNT_CD = 'US' AND CBL.BL_NO = BKGM.BL_NO AND CBL.CSTMS_LOC_CD = @[cstms_loc_cd])" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${entr_tp} != '')" ).append("\n"); 
		query.append("                    AND EXISTS (SELECT 'Y'" ).append("\n"); 
		query.append("                                  FROM BKG_CSTMS_ADV_IBD CADV" ).append("\n"); 
		query.append("                                 WHERE CADV.CNT_CD = 'US'" ).append("\n"); 
		query.append("                                   AND CADV.BL_NO = BKGM.BL_NO" ).append("\n"); 
		query.append("		        #if (${entr_tp} == 'I')" ).append("\n"); 
		query.append("                                   AND CADV.CSTMS_CLR_TP_CD = 'I'" ).append("\n"); 
		query.append("				#else " ).append("\n"); 
		query.append("                                   AND CADV.CSTMS_CLR_TP_CD != 'I'" ).append("\n"); 
		query.append("			    #end" ).append("\n"); 
		query.append("                               )" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("    #if (${hub_loc_cd} != '' || ${entrcstms_loc_cd} != '' || ${entr_tp} != '')" ).append("\n"); 
		query.append("         /* POD US,CA 체크*/" ).append("\n"); 
		query.append("        AND SUBSTR(BKGM.POD_CD,1,2) IN ('US','CA')" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("              ) BKGM" ).append("\n"); 
		query.append("            , BKG_ARR_NTC_DTL ADTL" ).append("\n"); 
		query.append("            , COM_FAX_SND_INFO FXSD" ).append("\n"); 
		query.append("            , COM_EML_SND_INFO EMSD" ).append("\n"); 
		query.append("        WHERE 1 = 1" ).append("\n"); 
		query.append("          AND ADTL.BKG_NO(+)          = BKGM.BKG_NO" ).append("\n"); 
		query.append("          AND ADTL.BKG_CUST_TP_CD(+)  = BKGM.BKG_CUST_TP_CD" ).append("\n"); 
		query.append("          AND FXSD.FAX_SND_NO(+) = ADTL.FAX_NTC_SND_ID" ).append("\n"); 
		query.append("          AND EMSD.EML_SND_NO(+) = ADTL.EML_NTC_SND_ID" ).append("\n"); 
		query.append("       GROUP BY BKGM.BL_NO" ).append("\n"); 
		query.append("             , BKGM.BKG_CUST_TP_CD" ).append("\n"); 
		query.append("    #if (${is_validated} != '')" ).append("\n"); 
		query.append("       HAVING MAX(BKGM.IS_VALIDATED) = @[is_validated]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("         ) SUBQ" ).append("\n"); 
		query.append("         , BKG_ARR_NTC ANTC" ).append("\n"); 
		query.append("         , BKG_CSTMS_ADV_IBD CADV" ).append("\n"); 
		query.append("         , BKG_CSTMS_ADV_BL  CBL" ).append("\n"); 
		query.append("         , (SELECT USR_ID" ).append("\n"); 
		query.append("                 , AN_RMK" ).append("\n"); 
		query.append("              FROM BKG_USR_DFLT_SET" ).append("\n"); 
		query.append("             WHERE USR_ID = @[usr_id] ) USET" ).append("\n"); 
		query.append("         , COM_USER         CUSR" ).append("\n"); 
		query.append("         , BKG_VVD          DVVD  -- DISCHARGE VVD" ).append("\n"); 
		query.append("         , MDM_LOCATION     LOC" ).append("\n"); 
		query.append("         , MDM_COUNTRY      MDM" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("          AND ANTC.BKG_NO(+)  = SUBQ.BKG_NO" ).append("\n"); 
		query.append("          AND CADV.CNT_CD (+) = SUBQ.CSTMS_CLR_TP_CNT_CD" ).append("\n"); 
		query.append("          AND CADV.BL_NO(+)   = SUBQ.BL_NO" ).append("\n"); 
		query.append("          AND CBL.CNT_CD (+)  = SUBQ.CSTMS_CLR_TP_CNT_CD" ).append("\n"); 
		query.append("          AND CBL.BL_NO(+)    = SUBQ.BL_NO" ).append("\n"); 
		query.append("          AND USET.USR_ID(+)  = SUBQ.LOGIN_USR_ID" ).append("\n"); 
		query.append("          AND CUSR.USR_ID(+)  = SUBQ.SND_USR_ID" ).append("\n"); 
		query.append("          AND DVVD.BKG_NO(+)  = SUBQ.BKG_NO" ).append("\n"); 
		query.append("          AND DVVD.POD_CD(+)  = SUBQ.POD_CD" ).append("\n"); 
		query.append("          AND LOC.LOC_CD(+)   = SUBQ.LOC_CD" ).append("\n"); 
		query.append("          AND MDM.CNT_CD(+)   = LOC.CNT_CD" ).append("\n"); 
		query.append("    ORDER BY SUBQ.BL_NO, SUBQ.BKG_CUST_TP_CD" ).append("\n"); 
		query.append(") INQR" ).append("\n"); 
		query.append("  LEFT OUTER JOIN BKG_ARR_NTC_WD NTWD" ).append("\n"); 
		query.append("    ON ( NTWD.AN_SEQ    = INQR.AN_SEQ )" ).append("\n"); 
		query.append("  LEFT OUTER JOIN BKG_HRD_CDG_CTNT HDG" ).append("\n"); 
		query.append("    ON ( HDG.HRD_CDG_ID  = 'ARR_NTC_MRD_ID'" ).append("\n"); 
		query.append("         AND HDG.ATTR_CTNT1  = INQR.CONTI_CD       -- CONTINENT CODE" ).append("\n"); 
		query.append("         AND HDG.ATTR_CTNT2  = INQR.CNT_CD" ).append("\n"); 
		query.append("         AND HDG.ATTR_CTNT3  = NTWD.ARR_PRV_FOM_CD" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  #if (${an_snt_sts} == 'Y')" ).append("\n"); 
		query.append("	AND UPPER(AN_SENT) != 'NO'" ).append("\n"); 
		query.append("  #elseif (${an_snt_sts} == 'N')" ).append("\n"); 
		query.append("	AND UPPER(AN_SENT) = 'NO' " ).append("\n"); 
		query.append("  #end" ).append("\n"); 

	}
}