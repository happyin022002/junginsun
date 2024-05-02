/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : RFAReportDBDAORsltSearchRFARateSearchListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.17
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.17 
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

public class RFAReportDBDAORsltSearchRFARateSearchListVORSQL implements ISQLTemplate{

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
	  * 2012.11.26 송호진[CHM-201221500] 11월 PRS 배치 수행 요청 - Surcharge 조회시 Currency Column 을 PRI_RP_SCP_RT_SCG 에서 가져오도로 수정
	  * 2013.09.11 송호진 SQL Tuning 개선 - Route 조건의 Type 지정 
	  * 2014.04.29 서미진 [CHM-201429649] Rate Search 화면 상 BOF 표시 추가
	  * 2014.07.15 전윤주 ALPS Errorlog 해결 위해 SYS_CONNECT_BY_PATH 제거하고 BKG Function으로 대체
	  * </pre>
	  */
	public RFAReportDBDAORsltSearchRFARateSearchListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rat_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("prc_cmdt_def_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fnl_frt_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rout_via_port_def_cd_ori",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rout_via_port_def_cd_dest",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rout_pnt_loc_def_cd_ori",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rout_pnt_loc_def_cd_dest",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fnl_mqc_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prc_cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfareport.rfareport.integration").append("\n"); 
		query.append("FileName : RFAReportDBDAORsltSearchRFARateSearchListVORSQL").append("\n"); 
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
		query.append("RT AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("/*******************************************************************************************" ).append("\n"); 
		query.append("조회 조건에 해당하는 RATE DATA" ).append("\n"); 
		query.append("*******************************************************************************************/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    SELECT  " ).append("\n"); 
		query.append("            ROWNUM AS ROW_SUBSUM_GROUP ," ).append("\n"); 
		query.append("            RS.PROP_NO      ," ).append("\n"); 
		query.append("            RS.AMDT_SEQ     ," ).append("\n"); 
		query.append("            RS.SVC_SCP_CD   ," ).append("\n"); 
		query.append("            RS.EFF_DT       ," ).append("\n"); 
		query.append("            CH.CMDT_HDR_SEQ ," ).append("\n"); 
		query.append("            CR.ROUT_SEQ     , " ).append("\n"); 
		query.append("            RT.RT_SEQ       ," ).append("\n"); 
		query.append("            RH.RFA_NO       ," ).append("\n"); 
		query.append("            ( SELECT A.CUST_LGL_ENG_NM FROM MDM_CUSTOMER A WHERE A.CUST_CNT_CD = RM.CTRT_CUST_CNT_CD AND A.CUST_SEQ = RM.CTRT_CUST_SEQ ) CUST_NM    ," ).append("\n"); 
		query.append("            DECODE(RS.CNTR_LOD_UT_CD, 'F', RS.TGT_MVC_QTY * 2, RS.TGT_MVC_QTY)  FNL_MQC_QTY ," ).append("\n"); 
		query.append("            RS.PROP_SCP_OFC_CD    ," ).append("\n"); 
		query.append("            RS.PROP_SCP_SREP_CD   , " ).append("\n"); 
		query.append("            OP.ROUT_PNT_LOC_TP_CD  ORG_PNT_LOC_TP_CD   ," ).append("\n"); 
		query.append("            OP.ROUT_PNT_LOC_DEF_CD ORG_PNT_LOC_DEF_CD  ," ).append("\n"); 
		query.append("            OP.RCV_DE_TERM_CD      RCV_TERM_CD         ," ).append("\n"); 
		query.append("            DP.ROUT_PNT_LOC_TP_CD  DEST_PNT_LOC_TP_CD  ," ).append("\n"); 
		query.append("            DP.ROUT_PNT_LOC_DEF_CD DEST_PNT_LOC_DEF_CD ," ).append("\n"); 
		query.append("            DP.RCV_DE_TERM_CD      DE_TERM_CD          ," ).append("\n"); 
		query.append("            'OFT'                  CHG_CD              ," ).append("\n"); 
		query.append("            RT.RAT_UT_CD       ," ).append("\n"); 
		query.append("            RT.PRC_CGO_TP_CD   ," ).append("\n"); 
		query.append("            RT.CURR_CD         ," ).append("\n"); 
		query.append("            RT.FNL_FRT_RT_AMT  ," ).append("\n"); 
		query.append("            CR.PRS_CRNT_LOD_QTY," ).append("\n"); 
		query.append("            RM.RFA_CTRT_TP_CD  ," ).append("\n"); 
		query.append("            CH.FIC_RT_TP_CD    ," ).append("\n"); 
		query.append("            RT.FIC_FNL_RT_AMT  ," ).append("\n"); 
		query.append("            CASE WHEN TO_CHAR(RD.CTRT_EFF_DT,'YYYYMMDD') > '20120630' AND '20130101' > TO_CHAR(RD.CTRT_EFF_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("                      AND (RS.SVC_SCP_CD = 'AEE' OR RS.SVC_SCP_CD = 'AEW') THEN 1  -- Hinterland (20120630 ~ 20130101)" ).append("\n"); 
		query.append("                 WHEN '20130101' <= TO_CHAR(RD.CTRT_EFF_DT,'YYYYMMDD') THEN 2      -- after Hinterland (20130101 ~)" ).append("\n"); 
		query.append("                 ELSE 0 -- before Hinterland ( ~ 20120630)" ).append("\n"); 
		query.append("                 END FIC_TP    ," ).append("\n"); 
		query.append("            NVL(RT.FIC_ORG_FNL_RT_AMT,0) + NVL(RT.FIC_DEST_FNL_RT_AMT,0) AS FIC_ORG_DEST" ).append("\n"); 
		query.append("	FROM    PRI_RP_HDR              RH  ," ).append("\n"); 
		query.append("            PRI_RP_MN               RM  ," ).append("\n"); 
		query.append("            PRI_RP_SCP_MN           RS  ," ).append("\n"); 
		query.append("            PRI_RP_SCP_DUR          RD  ," ).append("\n"); 
		query.append("            PRI_RP_SCP_RT_CMDT_HDR  CH  ," ).append("\n"); 
		query.append("            PRI_RP_SCP_RT_CMDT_ROUT CR  ," ).append("\n"); 
		query.append("            PRI_RP_SCP_RT_ROUT_PNT  OP  ," ).append("\n"); 
		query.append("            PRI_RP_SCP_RT_ROUT_PNT  DP  ," ).append("\n"); 
		query.append("            PRI_RP_SCP_RT           RT" ).append("\n"); 
		query.append("    WHERE   RM.PROP_NO            = RH.PROP_NO" ).append("\n"); 
		query.append("    AND     RM.PROP_STS_CD    = 'A'" ).append("\n"); 
		query.append("    AND     RS.PROP_NO        = RM.PROP_NO" ).append("\n"); 
		query.append("    AND     RS.AMDT_SEQ       = RM.AMDT_SEQ" ).append("\n"); 
		query.append("    AND     RD.PROP_NO        = RS.PROP_NO" ).append("\n"); 
		query.append("    AND     RD.AMDT_SEQ       = RS.AMDT_SEQ" ).append("\n"); 
		query.append("    AND     RD.SVC_SCP_CD     = RS.SVC_SCP_CD" ).append("\n"); 
		query.append("    AND     CH.PROP_NO        = RS.PROP_NO" ).append("\n"); 
		query.append("    AND     CH.AMDT_SEQ       = RS.AMDT_SEQ" ).append("\n"); 
		query.append("    AND     CH.SVC_SCP_CD     = RS.SVC_SCP_CD" ).append("\n"); 
		query.append("    AND     CR.PROP_NO        = CH.PROP_NO" ).append("\n"); 
		query.append("    AND     CR.AMDT_SEQ       = CH.AMDT_SEQ" ).append("\n"); 
		query.append("    AND     CR.SVC_SCP_CD     = CH.SVC_SCP_CD" ).append("\n"); 
		query.append("    AND     CR.CMDT_HDR_SEQ   = CH.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("    AND     OP.PROP_NO        = CR.PROP_NO" ).append("\n"); 
		query.append("    AND     OP.AMDT_SEQ       = CR.AMDT_SEQ" ).append("\n"); 
		query.append("    AND     OP.SVC_SCP_CD     = CR.SVC_SCP_CD" ).append("\n"); 
		query.append("    AND     OP.CMDT_HDR_SEQ   = CR.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("    AND     OP.ROUT_SEQ       = CR.ROUT_SEQ" ).append("\n"); 
		query.append("    AND     OP.ORG_DEST_TP_CD = 'O'" ).append("\n"); 
		query.append("    AND     OP.SRC_INFO_CD   <> 'AD'" ).append("\n"); 
		query.append("    AND     DP.PROP_NO         = CR.PROP_NO" ).append("\n"); 
		query.append("    AND     DP.AMDT_SEQ        = CR.AMDT_SEQ" ).append("\n"); 
		query.append("    AND     DP.SVC_SCP_CD      = CR.SVC_SCP_CD" ).append("\n"); 
		query.append("    AND     DP.CMDT_HDR_SEQ    = CR.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("    AND     DP.ROUT_SEQ        = CR.ROUT_SEQ" ).append("\n"); 
		query.append("    AND     DP.ORG_DEST_TP_CD  = 'D'" ).append("\n"); 
		query.append("    AND     DP.SRC_INFO_CD     <> 'AD'" ).append("\n"); 
		query.append("    AND     RT.PROP_NO         = CR.PROP_NO" ).append("\n"); 
		query.append("    AND     RT.AMDT_SEQ        = CR.AMDT_SEQ" ).append("\n"); 
		query.append("    AND     RT.SVC_SCP_CD      = CR.SVC_SCP_CD" ).append("\n"); 
		query.append("    AND     RT.CMDT_HDR_SEQ    = CR.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("    AND     RT.ROUT_SEQ        = CR.ROUT_SEQ" ).append("\n"); 
		query.append("    AND     RT.SRC_INFO_CD     <> 'AD'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${svc_scp_cd} != '') " ).append("\n"); 
		query.append("    AND     RS.SVC_SCP_CD          = @[svc_scp_cd] -- SVC Scope" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${exp_dt} != '') " ).append("\n"); 
		query.append("    AND     RS.EFF_DT              <= TO_DATE(@[exp_dt], 'YYYY/MM/DD')  -- Effective Date(To) or Access Date" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${eff_dt} != '') " ).append("\n"); 
		query.append("    AND     RS.EXP_DT              >= TO_DATE(@[eff_dt], 'YYYY/MM/DD')  -- Effective Date(From) or Access Date" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${rout_pnt_loc_def_cd_ori} != '') " ).append("\n"); 
		query.append("    AND (    " ).append("\n"); 
		query.append("			(" ).append("\n"); 
		query.append("			OP.ROUT_PNT_LOC_TP_CD = 'G'" ).append("\n"); 
		query.append("			AND " ).append("\n"); 
		query.append("            OP.ROUT_PNT_LOC_DEF_CD IN" ).append("\n"); 
		query.append("			(" ).append("\n"); 
		query.append("			SELECT	    GL.PRC_GRP_LOC_CD" ).append("\n"); 
		query.append("			FROM		PRI_RP_SCP_GRP_LOC		GL	," ).append("\n"); 
		query.append("						PRI_RP_SCP_GRP_LOC_DTL	GD" ).append("\n"); 
		query.append("			WHERE		GD.PROP_NO			= GL.PROP_NO" ).append("\n"); 
		query.append("			AND			GD.AMDT_SEQ			= GL.AMDT_SEQ" ).append("\n"); 
		query.append("			AND			GD.SVC_SCP_CD		= GL.SVC_SCP_CD" ).append("\n"); 
		query.append("			AND			GD.GRP_LOC_SEQ		= GL.GRP_LOC_SEQ" ).append("\n"); 
		query.append("			AND			GL.PROP_NO			= RS.PROP_NO" ).append("\n"); 
		query.append("			AND			GL.AMDT_SEQ			= RS.AMDT_SEQ" ).append("\n"); 
		query.append("			AND			GL.SVC_SCP_CD		= RS.SVC_SCP_CD" ).append("\n"); 
		query.append("			AND			GD.SRC_INFO_CD		<> 'AD'" ).append("\n"); 
		query.append("			AND			GD.LOC_CD			LIKE @[rout_pnt_loc_def_cd_ori] || '%' -- Origin" ).append("\n"); 
		query.append("	        ) )" ).append("\n"); 
		query.append("	        OR" ).append("\n"); 
		query.append("			(" ).append("\n"); 
		query.append("			OP.ROUT_PNT_LOC_TP_CD <> 'G'" ).append("\n"); 
		query.append("			AND " ).append("\n"); 
		query.append("		    OP.ROUT_PNT_LOC_DEF_CD LIKE @[rout_pnt_loc_def_cd_ori] || '%' -- Origin" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${rout_pnt_loc_def_cd_dest} != '') " ).append("\n"); 
		query.append("    AND  (" ).append("\n"); 
		query.append("			(" ).append("\n"); 
		query.append("			DP.ROUT_PNT_LOC_TP_CD = 'G'" ).append("\n"); 
		query.append("			AND" ).append("\n"); 
		query.append("            DP.ROUT_PNT_LOC_DEF_CD IN" ).append("\n"); 
		query.append("			(" ).append("\n"); 
		query.append("			SELECT	GL.PRC_GRP_LOC_CD" ).append("\n"); 
		query.append("			FROM		PRI_RP_SCP_GRP_LOC		GL	," ).append("\n"); 
		query.append("						PRI_RP_SCP_GRP_LOC_DTL	GD" ).append("\n"); 
		query.append("			WHERE		GD.PROP_NO			= GL.PROP_NO" ).append("\n"); 
		query.append("			AND			GD.AMDT_SEQ			= GL.AMDT_SEQ" ).append("\n"); 
		query.append("			AND			GD.SVC_SCP_CD		= GL.SVC_SCP_CD" ).append("\n"); 
		query.append("			AND			GD.GRP_LOC_SEQ		= GL.GRP_LOC_SEQ" ).append("\n"); 
		query.append("			AND			GL.PROP_NO			= RS.PROP_NO" ).append("\n"); 
		query.append("			AND			GL.AMDT_SEQ			= RS.AMDT_SEQ" ).append("\n"); 
		query.append("			AND			GL.SVC_SCP_CD		= RS.SVC_SCP_CD" ).append("\n"); 
		query.append("			AND			GD.SRC_INFO_CD		<> 'AD'" ).append("\n"); 
		query.append("			AND			GD.LOC_CD			LIKE @[rout_pnt_loc_def_cd_dest] || '%' -- Destination" ).append("\n"); 
		query.append("			) )" ).append("\n"); 
		query.append("	        OR" ).append("\n"); 
		query.append("			(" ).append("\n"); 
		query.append("			DP.ROUT_PNT_LOC_TP_CD <> 'G'" ).append("\n"); 
		query.append("			AND" ).append("\n"); 
		query.append("	        DP.ROUT_PNT_LOC_DEF_CD LIKE @[rout_pnt_loc_def_cd_dest] || '%' -- Destination" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("          )" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    /* ORIGIN VIA */" ).append("\n"); 
		query.append("    #if (${rout_via_port_def_cd_ori} != '') " ).append("\n"); 
		query.append("    AND     EXISTS  (" ).append("\n"); 
		query.append("                    SELECT  'X'" ).append("\n"); 
		query.append("                    FROM    PRI_RP_SCP_RT_ROUT_VIA  OV" ).append("\n"); 
		query.append("                    WHERE   OV.PROP_NO              = CR.PROP_NO" ).append("\n"); 
		query.append("                    AND     OV.AMDT_SEQ             = CR.AMDT_SEQ" ).append("\n"); 
		query.append("                    AND     OV.SVC_SCP_CD           = CR.SVC_SCP_CD" ).append("\n"); 
		query.append("                    AND     OV.CMDT_HDR_SEQ         = CR.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                    AND     OV.ROUT_SEQ             = CR.ROUT_SEQ" ).append("\n"); 
		query.append("                    AND     OV.ORG_DEST_TP_CD       = 'O'" ).append("\n"); 
		query.append("                    AND     OV.SRC_INFO_CD          <> 'AD'" ).append("\n"); 
		query.append("					AND		OV.ROUT_VIA_PORT_TP_CD	<> 'G'" ).append("\n"); 
		query.append("                    AND     OV.ROUT_VIA_PORT_DEF_CD LIKE @[rout_via_port_def_cd_ori] || '%'	-- Origin Via" ).append("\n"); 
		query.append("					UNION ALL" ).append("\n"); 
		query.append("					SELECT	'X'" ).append("\n"); 
		query.append("					FROM	PRI_RP_SCP_RT_ROUT_VIA  OV	," ).append("\n"); 
		query.append("							PRI_RP_SCP_GRP_LOC		GL	," ).append("\n"); 
		query.append("							PRI_RP_SCP_GRP_LOC_DTL	GD" ).append("\n"); 
		query.append("                    WHERE   OV.PROP_NO              = CR.PROP_NO" ).append("\n"); 
		query.append("                    AND     OV.AMDT_SEQ             = CR.AMDT_SEQ" ).append("\n"); 
		query.append("                    AND     OV.SVC_SCP_CD           = CR.SVC_SCP_CD" ).append("\n"); 
		query.append("                    AND     OV.CMDT_HDR_SEQ         = CR.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                    AND     OV.ROUT_SEQ             = CR.ROUT_SEQ" ).append("\n"); 
		query.append("                    AND     OV.ORG_DEST_TP_CD       = 'O'" ).append("\n"); 
		query.append("                    AND     OV.SRC_INFO_CD          <> 'AD'" ).append("\n"); 
		query.append("					AND		OV.ROUT_VIA_PORT_TP_CD	= 'G'" ).append("\n"); 
		query.append("					AND		OV.ROUT_VIA_PORT_DEF_CD	= GL.PRC_GRP_LOC_CD" ).append("\n"); 
		query.append("					AND		GD.PROP_NO				= GL.PROP_NO" ).append("\n"); 
		query.append("					AND		GD.AMDT_SEQ				= GL.AMDT_SEQ" ).append("\n"); 
		query.append("					AND		GD.SVC_SCP_CD			= GL.SVC_SCP_CD" ).append("\n"); 
		query.append("					AND		GD.GRP_LOC_SEQ			= GL.GRP_LOC_SEQ" ).append("\n"); 
		query.append("					AND		GL.PROP_NO				= CR.PROP_NO" ).append("\n"); 
		query.append("					AND		GL.AMDT_SEQ				= CR.AMDT_SEQ" ).append("\n"); 
		query.append("					AND		GL.SVC_SCP_CD			= CR.SVC_SCP_CD" ).append("\n"); 
		query.append("					AND		GD.SRC_INFO_CD			<> 'AD'" ).append("\n"); 
		query.append("					AND		GD.LOC_CD				LIKE @[rout_via_port_def_cd_ori] || '%'	-- Origin Via" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    /* DEST VIA */" ).append("\n"); 
		query.append("    #if (${rout_via_port_def_cd_dest} != '') " ).append("\n"); 
		query.append("    AND     EXISTS  (" ).append("\n"); 
		query.append("                    SELECT  'X'" ).append("\n"); 
		query.append("                    FROM    PRI_RP_SCP_RT_ROUT_VIA  DV" ).append("\n"); 
		query.append("                    WHERE   DV.PROP_NO              = CR.PROP_NO" ).append("\n"); 
		query.append("                    AND     DV.AMDT_SEQ             = CR.AMDT_SEQ" ).append("\n"); 
		query.append("                    AND     DV.SVC_SCP_CD           = CR.SVC_SCP_CD" ).append("\n"); 
		query.append("                    AND     DV.CMDT_HDR_SEQ         = CR.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                    AND     DV.ROUT_SEQ             = CR.ROUT_SEQ" ).append("\n"); 
		query.append("                    AND     DV.ORG_DEST_TP_CD       = 'D'" ).append("\n"); 
		query.append("                    AND     DV.SRC_INFO_CD          <> 'AD'" ).append("\n"); 
		query.append("					AND		DV.ROUT_VIA_PORT_TP_CD	<> 'G'" ).append("\n"); 
		query.append("                    AND     DV.ROUT_VIA_PORT_DEF_CD LIKE @[rout_via_port_def_cd_dest] || '%' -- Dest Via" ).append("\n"); 
		query.append("					UNION ALL" ).append("\n"); 
		query.append("					SELECT	'X'" ).append("\n"); 
		query.append("					FROM	PRI_RP_SCP_RT_ROUT_VIA  DV	," ).append("\n"); 
		query.append("							PRI_RP_SCP_GRP_LOC		GL	," ).append("\n"); 
		query.append("							PRI_RP_SCP_GRP_LOC_DTL	GD" ).append("\n"); 
		query.append("                    WHERE   DV.PROP_NO              = CR.PROP_NO" ).append("\n"); 
		query.append("                    AND     DV.AMDT_SEQ             = CR.AMDT_SEQ" ).append("\n"); 
		query.append("                    AND     DV.SVC_SCP_CD           = CR.SVC_SCP_CD" ).append("\n"); 
		query.append("                    AND     DV.CMDT_HDR_SEQ         = CR.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                    AND     DV.ROUT_SEQ             = CR.ROUT_SEQ" ).append("\n"); 
		query.append("                    AND     DV.ORG_DEST_TP_CD       = 'D'" ).append("\n"); 
		query.append("                    AND     DV.SRC_INFO_CD          <> 'AD'" ).append("\n"); 
		query.append("					AND		DV.ROUT_VIA_PORT_TP_CD	= 'G'" ).append("\n"); 
		query.append("					AND		DV.ROUT_VIA_PORT_DEF_CD	= GL.PRC_GRP_LOC_CD" ).append("\n"); 
		query.append("					AND		GD.PROP_NO				= GL.PROP_NO" ).append("\n"); 
		query.append("					AND		GD.AMDT_SEQ				= GL.AMDT_SEQ" ).append("\n"); 
		query.append("					AND		GD.SVC_SCP_CD			= GL.SVC_SCP_CD" ).append("\n"); 
		query.append("					AND		GD.GRP_LOC_SEQ			= GL.GRP_LOC_SEQ" ).append("\n"); 
		query.append("					AND		GL.PROP_NO				= CR.PROP_NO" ).append("\n"); 
		query.append("					AND		GL.AMDT_SEQ				= CR.AMDT_SEQ" ).append("\n"); 
		query.append("					AND		GL.SVC_SCP_CD			= CR.SVC_SCP_CD" ).append("\n"); 
		query.append("					AND		GD.SRC_INFO_CD			<> 'AD'" ).append("\n"); 
		query.append("					AND		GD.LOC_CD				LIKE @[rout_via_port_def_cd_dest] || '%' -- Dest Via" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${rat_ut_cd} != '') " ).append("\n"); 
		query.append("    AND     RT.RAT_UT_CD = @[rat_ut_cd] -- RATING UNIT" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${prc_cgo_tp_cd} != '') " ).append("\n"); 
		query.append("    AND     RT.PRC_CGO_TP_CD = @[prc_cgo_tp_cd] -- CARGO TYPE" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${fnl_frt_rt} == '<' && ${fnl_frt_rt_amt} != '') " ).append("\n"); 
		query.append("    AND     RT.FNL_FRT_RT_AMT < TO_NUMBER(REPLACE(@[fnl_frt_rt_amt],',','')) -- RATE ( >,<,<=,>=,= 별로 로직적용)" ).append("\n"); 
		query.append("    #elseif (${fnl_frt_rt} == '>' && ${fnl_frt_rt_amt} != '')" ).append("\n"); 
		query.append("    AND     RT.FNL_FRT_RT_AMT > TO_NUMBER(REPLACE(@[fnl_frt_rt_amt],',','')) -- RATE ( >,<,<=,>=,= 별로 로직적용)" ).append("\n"); 
		query.append("    #elseif (${fnl_frt_rt} == '<=' && ${fnl_frt_rt_amt} != '')" ).append("\n"); 
		query.append("    AND     RT.FNL_FRT_RT_AMT <= TO_NUMBER(REPLACE(@[fnl_frt_rt_amt],',','')) -- RATE ( >,<,<=,>=,= 별로 로직적용)" ).append("\n"); 
		query.append("    #elseif (${fnl_frt_rt} == '>=' && ${fnl_frt_rt_amt} != '')" ).append("\n"); 
		query.append("    AND     RT.FNL_FRT_RT_AMT >= TO_NUMBER(REPLACE(@[fnl_frt_rt_amt],',','')) -- RATE ( >,<,<=,>=,= 별로 로직적용)" ).append("\n"); 
		query.append("    #elseif (${fnl_frt_rt} == '=' && ${fnl_frt_rt_amt} != '')" ).append("\n"); 
		query.append("    AND     RT.FNL_FRT_RT_AMT = TO_NUMBER(REPLACE(@[fnl_frt_rt_amt],',','')) -- RATE ( >,<,<=,>=,= 별로 로직적용)" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${fnl_mqc} == '<' && ${fnl_mqc_qty} != '') " ).append("\n"); 
		query.append("    AND     RS.TGT_MVC_QTY < TO_NUMBER(REPLACE(@[fnl_mqc_qty],',','')) -- MQC  ( >,<,<=,>=,= 별로 로직적용)" ).append("\n"); 
		query.append("    #elseif (${fnl_mqc} == '>' && ${fnl_mqc_qty} != '')" ).append("\n"); 
		query.append("    AND     RS.TGT_MVC_QTY > TO_NUMBER(REPLACE(@[fnl_mqc_qty],',','')) -- MQC  ( >,<,<=,>=,= 별로 로직적용)" ).append("\n"); 
		query.append("    #elseif (${fnl_mqc} == '<=' && ${fnl_mqc_qty} != '')" ).append("\n"); 
		query.append("    AND     RS.TGT_MVC_QTY <= TO_NUMBER(REPLACE(@[fnl_mqc_qty],',','')) -- MQC  ( >,<,<=,>=,= 별로 로직적용)" ).append("\n"); 
		query.append("    #elseif (${fnl_mqc} == '>=' && ${fnl_mqc_qty} != '')" ).append("\n"); 
		query.append("    AND     RS.TGT_MVC_QTY >= TO_NUMBER(REPLACE(@[fnl_mqc_qty],',','')) -- MQC  ( >,<,<=,>=,= 별로 로직적용)" ).append("\n"); 
		query.append("    #elseif (${fnl_mqc} == '=' && ${fnl_mqc_qty} != '')" ).append("\n"); 
		query.append("    AND     RS.TGT_MVC_QTY = TO_NUMBER(REPLACE(@[fnl_mqc_qty],',','')) -- MQC  ( >,<,<=,>=,= 별로 로직적용)" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${prop_scp_ofc_cd} != '') " ).append("\n"); 
		query.append("    AND     RS.PROP_SCP_OFC_CD LIKE @[prop_scp_ofc_cd] || '%' -- REQUEST OFFICE" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${prop_scp_srep_cd} != '') " ).append("\n"); 
		query.append("    AND     RS.PROP_SCP_SREP_CD LIKE @[prop_scp_srep_cd] || '%' -- SALES REP" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${rfa_no} != '') " ).append("\n"); 
		query.append("    AND     RH.RFA_NO LIKE @[rfa_no] || '%' -- RFA No" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${ctrt_cust_cnt_cd} != '') " ).append("\n"); 
		query.append("    AND     RM.CTRT_CUST_CNT_CD LIKE @[ctrt_cust_cnt_cd] || '%' -- Customer" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${ctrt_cust_seq} != '') " ).append("\n"); 
		query.append("    AND     RM.CTRT_CUST_SEQ LIKE TO_NUMBER(@[ctrt_cust_seq]) || '%' -- Customer" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${prc_ctrt_cust_tp_cd} != '') " ).append("\n"); 
		query.append("    AND     RM.PRC_CTRT_CUST_TP_CD = @[prc_ctrt_cust_tp_cd] -- Customer Type" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    /* COMMODITY */" ).append("\n"); 
		query.append("    #if (${prc_cmdt_def_cd} != '') " ).append("\n"); 
		query.append("    AND     EXISTS  (" ).append("\n"); 
		query.append("                      SELECT  'X'" ).append("\n"); 
		query.append("                      FROM     PRI_RP_SCP_RT_CMDT  RC" ).append("\n"); 
		query.append("                      WHERE    RC.PROP_NO         = CH.PROP_NO" ).append("\n"); 
		query.append("                      AND      RC.AMDT_SEQ        = CH.AMDT_SEQ" ).append("\n"); 
		query.append("                      AND      RC.SVC_SCP_CD      = CH.SVC_SCP_CD" ).append("\n"); 
		query.append("                      AND      RC.CMDT_HDR_SEQ    = CH.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                      AND      RC.PRC_CMDT_TP_CD  = 'C'" ).append("\n"); 
		query.append("                      AND      RC.PRC_CMDT_DEF_CD LIKE @[prc_cmdt_def_cd] || '%' -- Commodity" ).append("\n"); 
		query.append("                      UNION ALL" ).append("\n"); 
		query.append("                      SELECT  'X'" ).append("\n"); 
		query.append("                      FROM    PRI_RP_SCP_RT_CMDT  RC" ).append("\n"); 
		query.append("                      WHERE   RC.PROP_NO        = CH.PROP_NO" ).append("\n"); 
		query.append("                      AND     RC.AMDT_SEQ       = CH.AMDT_SEQ" ).append("\n"); 
		query.append("                      AND     RC.SVC_SCP_CD     = CH.SVC_SCP_CD" ).append("\n"); 
		query.append("                      AND     RC.CMDT_HDR_SEQ   = CH.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                      AND     RC.PRC_CMDT_TP_CD = 'G'" ).append("\n"); 
		query.append("                      AND     EXISTS  (" ).append("\n"); 
		query.append("                                       SELECT  'X'" ).append("\n"); 
		query.append("                                       FROM    PRI_RP_SCP_GRP_CMDT         G   ," ).append("\n"); 
		query.append("                                               PRI_RP_SCP_GRP_CMDT_DTL D" ).append("\n"); 
		query.append("                                       WHERE   D.PROP_NO          = G.PROP_NO" ).append("\n"); 
		query.append("                                       AND     D.AMDT_SEQ         = G.AMDT_SEQ" ).append("\n"); 
		query.append("                                       AND     D.SVC_SCP_CD       = G.SVC_SCP_CD" ).append("\n"); 
		query.append("                                       AND     D.GRP_CMDT_SEQ     = G.GRP_CMDT_SEQ" ).append("\n"); 
		query.append("                                       AND     D.PRC_CMDT_TP_CD   = 'C'" ).append("\n"); 
		query.append("     								   AND     D.SRC_INFO_CD      <> 'AD'" ).append("\n"); 
		query.append("                                       AND     D.PRC_CMDT_DEF_CD  LIKE @[prc_cmdt_def_cd] || '%' -- Commodity" ).append("\n"); 
		query.append("                                       AND     G.PROP_NO          = RC.PROP_NO" ).append("\n"); 
		query.append("                                       AND     G.AMDT_SEQ         = RC.AMDT_SEQ" ).append("\n"); 
		query.append("                                       AND     G.SVC_SCP_CD       = RC.SVC_SCP_CD" ).append("\n"); 
		query.append("                                       AND     G.PRC_GRP_CMDT_CD  = RC.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("                                      )" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    /* ACTUAL CUSTOMER */" ).append("\n"); 
		query.append("    #if (${cust_cnt_cd} != '' || ${cust_seq} != '') " ).append("\n"); 
		query.append("    AND     EXISTS  (" ).append("\n"); 
		query.append("                     SELECT  'X'" ).append("\n"); 
		query.append("                     FROM    PRI_RP_SCP_RT_ACT_CUST  AC" ).append("\n"); 
		query.append("                     WHERE   AC.PROP_NO      = CH.PROP_NO" ).append("\n"); 
		query.append("                     AND     AC.AMDT_SEQ     = CH.AMDT_SEQ" ).append("\n"); 
		query.append("                     AND     AC.SVC_SCP_CD   = CH.SVC_SCP_CD" ).append("\n"); 
		query.append("                     AND     AC.CMDT_HDR_SEQ = CH.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                     AND     AC.SRC_INFO_CD  <> 'AD'" ).append("\n"); 
		query.append("    				 #if (${cust_cnt_cd} != '') " ).append("\n"); 
		query.append("                     AND     AC.CUST_CNT_CD  LIKE @[cust_cnt_cd] || '%' -- Actual Customer" ).append("\n"); 
		query.append("     				 #end" ).append("\n"); 
		query.append("    				 #if (${cust_seq} != '') " ).append("\n"); 
		query.append("                     AND     AC.CUST_SEQ     LIKE TO_NUMBER(@[cust_seq]) || '%' -- Actual Customer" ).append("\n"); 
		query.append("     				 #end" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${rfa_ctrt_tp_cd} != '') " ).append("\n"); 
		query.append("    AND     RM.RFA_CTRT_TP_CD = @[rfa_ctrt_tp_cd] -- RFA Type" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append(")   ," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("CG AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("/*******************************************************************************************" ).append("\n"); 
		query.append("CHG_CD 의 값이 따라, RT 에 CHARGE CODE 부분은 가져온다." ).append("\n"); 
		query.append("*******************************************************************************************/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${chg_cd} == 'OFT') " ).append("\n"); 
		query.append("    SELECT  " ).append("\n"); 
		query.append("            ROW_SUBSUM_GROUP    ," ).append("\n"); 
		query.append("            PROP_NO             ," ).append("\n"); 
		query.append("            AMDT_SEQ            ," ).append("\n"); 
		query.append("            SVC_SCP_CD          , -- 소계그룹" ).append("\n"); 
		query.append("            EFF_DT              ," ).append("\n"); 
		query.append("            RFA_NO              ," ).append("\n"); 
		query.append("            CUST_NM             ," ).append("\n"); 
		query.append("            FNL_MQC_QTY         ," ).append("\n"); 
		query.append("            PROP_SCP_OFC_CD     ," ).append("\n"); 
		query.append("            PROP_SCP_SREP_CD    ," ).append("\n"); 
		query.append("            ORG_PNT_LOC_TP_CD   ," ).append("\n"); 
		query.append("            ORG_PNT_LOC_DEF_CD  ," ).append("\n"); 
		query.append("            RCV_TERM_CD         ," ).append("\n"); 
		query.append("            DEST_PNT_LOC_TP_CD  ," ).append("\n"); 
		query.append("            DEST_PNT_LOC_DEF_CD ," ).append("\n"); 
		query.append("            DE_TERM_CD          ," ).append("\n"); 
		query.append("            CMDT_HDR_SEQ        , -- 소계그룹" ).append("\n"); 
		query.append("            ROUT_SEQ            , -- 소계그룹" ).append("\n"); 
		query.append("            RT_SEQ              , -- 소계그룹" ).append("\n"); 
		query.append("            CHG_CD              ," ).append("\n"); 
		query.append("            RAT_UT_CD           ," ).append("\n"); 
		query.append("            PRC_CGO_TP_CD       ," ).append("\n"); 
		query.append("            CURR_CD             ," ).append("\n"); 
		query.append("            FNL_FRT_RT_AMT      ," ).append("\n"); 
		query.append("            PRS_CRNT_LOD_QTY    ," ).append("\n"); 
		query.append("            RFA_CTRT_TP_CD      ," ).append("\n"); 
		query.append("            FIC_RT_TP_CD        ," ).append("\n"); 
		query.append("            FIC_FNL_RT_AMT      ," ).append("\n"); 
		query.append("            FIC_TP              ," ).append("\n"); 
		query.append("            FIC_ORG_DEST        " ).append("\n"); 
		query.append("    FROM    RT" ).append("\n"); 
		query.append("    #elseif (${chg_cd} != '' && ${chg_cd} != 'OFT')" ).append("\n"); 
		query.append("    SELECT  " ).append("\n"); 
		query.append("            RT.ROW_SUBSUM_GROUP    ," ).append("\n"); 
		query.append("            RT.PROP_NO             ," ).append("\n"); 
		query.append("            RT.AMDT_SEQ            ," ).append("\n"); 
		query.append("            RT.SVC_SCP_CD          , -- 소계그룹" ).append("\n"); 
		query.append("            RT.EFF_DT              ," ).append("\n"); 
		query.append("            RT.RFA_NO              ," ).append("\n"); 
		query.append("            RT.CUST_NM             ," ).append("\n"); 
		query.append("            RT.FNL_MQC_QTY         ," ).append("\n"); 
		query.append("            RT.PROP_SCP_OFC_CD     ," ).append("\n"); 
		query.append("            RT.PROP_SCP_SREP_CD    ," ).append("\n"); 
		query.append("            RT.ORG_PNT_LOC_TP_CD   ," ).append("\n"); 
		query.append("            RT.ORG_PNT_LOC_DEF_CD  ," ).append("\n"); 
		query.append("            RT.RCV_TERM_CD         ," ).append("\n"); 
		query.append("            RT.DEST_PNT_LOC_TP_CD  ," ).append("\n"); 
		query.append("            RT.DEST_PNT_LOC_DEF_CD ," ).append("\n"); 
		query.append("            RT.DE_TERM_CD          ," ).append("\n"); 
		query.append("            RT.CMDT_HDR_SEQ        , -- 소계그룹" ).append("\n"); 
		query.append("            RT.ROUT_SEQ            , -- 소계그룹" ).append("\n"); 
		query.append("            RT.RT_SEQ              , -- 소계그룹" ).append("\n"); 
		query.append("            RS.CHG_CD              ," ).append("\n"); 
		query.append("            RS.BKG_RAT_UT_CD  RAT_UT_CD  ," ).append("\n"); 
		query.append("            RT.PRC_CGO_TP_CD             ," ).append("\n"); 
		query.append("            RS.CURR_CD                   ," ).append("\n"); 
		query.append("            RS.TRF_SCG_AMT    FNL_FRT_RT_AMT  ," ).append("\n"); 
		query.append("            RT.PRS_CRNT_LOD_QTY    ," ).append("\n"); 
		query.append("            RT.RFA_CTRT_TP_CD      ," ).append("\n"); 
		query.append("            RT.FIC_RT_TP_CD        ," ).append("\n"); 
		query.append("            RT.FIC_FNL_RT_AMT      ," ).append("\n"); 
		query.append("            RT.FIC_TP              ," ).append("\n"); 
		query.append("            RT.FIC_ORG_DEST        " ).append("\n"); 
		query.append("    FROM    RT  ," ).append("\n"); 
		query.append("            PRI_RP_SCP_RT_SCG   RS" ).append("\n"); 
		query.append("    WHERE   RS.PROP_NO       = RT.PROP_NO" ).append("\n"); 
		query.append("    AND     RS.AMDT_SEQ      = RT.AMDT_SEQ" ).append("\n"); 
		query.append("    AND     RS.SVC_SCP_CD    = RT.SVC_SCP_CD" ).append("\n"); 
		query.append("    AND     RS.CMDT_HDR_SEQ  = RT.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("    AND     RS.ROUT_SEQ      = RT.ROUT_SEQ" ).append("\n"); 
		query.append("    AND     RS.RT_SEQ        = RT.RT_SEQ" ).append("\n"); 
		query.append("    AND     RS.CHG_CD        = @[chg_cd]         -- Charge ( BAF, CAF, PSC )" ).append("\n"); 
		query.append("    #else " ).append("\n"); 
		query.append("    SELECT  " ).append("\n"); 
		query.append("            ROW_SUBSUM_GROUP ," ).append("\n"); 
		query.append("            PROP_NO             ," ).append("\n"); 
		query.append("            AMDT_SEQ            ," ).append("\n"); 
		query.append("            SVC_SCP_CD          , -- 소계그룹" ).append("\n"); 
		query.append("            EFF_DT              ," ).append("\n"); 
		query.append("            RFA_NO              ," ).append("\n"); 
		query.append("            CUST_NM             ," ).append("\n"); 
		query.append("            FNL_MQC_QTY         ," ).append("\n"); 
		query.append("            PROP_SCP_OFC_CD     ," ).append("\n"); 
		query.append("            PROP_SCP_SREP_CD    ," ).append("\n"); 
		query.append("            ORG_PNT_LOC_TP_CD   ," ).append("\n"); 
		query.append("            ORG_PNT_LOC_DEF_CD  ," ).append("\n"); 
		query.append("            RCV_TERM_CD         ," ).append("\n"); 
		query.append("            DEST_PNT_LOC_TP_CD  ," ).append("\n"); 
		query.append("            DEST_PNT_LOC_DEF_CD ," ).append("\n"); 
		query.append("            DE_TERM_CD          ," ).append("\n"); 
		query.append("            CMDT_HDR_SEQ        , -- 소계그룹" ).append("\n"); 
		query.append("            ROUT_SEQ            , -- 소계그룹" ).append("\n"); 
		query.append("            RT_SEQ              , -- 소계그룹" ).append("\n"); 
		query.append("            CHG_CD              ," ).append("\n"); 
		query.append("            RAT_UT_CD           ," ).append("\n"); 
		query.append("            PRC_CGO_TP_CD       ," ).append("\n"); 
		query.append("            CURR_CD             ," ).append("\n"); 
		query.append("            FNL_FRT_RT_AMT      ," ).append("\n"); 
		query.append("            PRS_CRNT_LOD_QTY    ," ).append("\n"); 
		query.append("            RFA_CTRT_TP_CD      ," ).append("\n"); 
		query.append("            FIC_RT_TP_CD        ," ).append("\n"); 
		query.append("            FIC_FNL_RT_AMT      ," ).append("\n"); 
		query.append("            FIC_TP              ," ).append("\n"); 
		query.append("            FIC_ORG_DEST        " ).append("\n"); 
		query.append("    FROM    RT -- OFT" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT  " ).append("\n"); 
		query.append("            RT.ROW_SUBSUM_GROUP    ," ).append("\n"); 
		query.append("            RT.PROP_NO             ," ).append("\n"); 
		query.append("            RT.AMDT_SEQ            ," ).append("\n"); 
		query.append("            RT.SVC_SCP_CD          , -- 소계그룹" ).append("\n"); 
		query.append("            RT.EFF_DT              ," ).append("\n"); 
		query.append("            RT.RFA_NO              ," ).append("\n"); 
		query.append("            RT.CUST_NM             ," ).append("\n"); 
		query.append("            RT.FNL_MQC_QTY         ," ).append("\n"); 
		query.append("            RT.PROP_SCP_OFC_CD     ," ).append("\n"); 
		query.append("            RT.PROP_SCP_SREP_CD    ," ).append("\n"); 
		query.append("            RT.ORG_PNT_LOC_TP_CD   ," ).append("\n"); 
		query.append("            RT.ORG_PNT_LOC_DEF_CD  ," ).append("\n"); 
		query.append("            RT.RCV_TERM_CD         ," ).append("\n"); 
		query.append("            RT.DEST_PNT_LOC_TP_CD  ," ).append("\n"); 
		query.append("            RT.DEST_PNT_LOC_DEF_CD ," ).append("\n"); 
		query.append("            RT.DE_TERM_CD          ," ).append("\n"); 
		query.append("            RT.CMDT_HDR_SEQ        , -- 소계그룹" ).append("\n"); 
		query.append("            RT.ROUT_SEQ            , -- 소계그룹" ).append("\n"); 
		query.append("            RT.RT_SEQ              , -- 소계그룹" ).append("\n"); 
		query.append("            RS.CHG_CD              ," ).append("\n"); 
		query.append("            RS.BKG_RAT_UT_CD  RAT_UT_CD ," ).append("\n"); 
		query.append("            RT.PRC_CGO_TP_CD            ," ).append("\n"); 
		query.append("            RS.CURR_CD                  ," ).append("\n"); 
		query.append("            RS.TRF_SCG_AMT   FNL_FRT_RT_AMT  ," ).append("\n"); 
		query.append("            RT.PRS_CRNT_LOD_QTY    ," ).append("\n"); 
		query.append("            RT.RFA_CTRT_TP_CD      ," ).append("\n"); 
		query.append("            RT.FIC_RT_TP_CD        ," ).append("\n"); 
		query.append("            RT.FIC_FNL_RT_AMT      ," ).append("\n"); 
		query.append("            RT.FIC_TP              ," ).append("\n"); 
		query.append("            RT.FIC_ORG_DEST        " ).append("\n"); 
		query.append("    FROM    RT  ," ).append("\n"); 
		query.append("            PRI_RP_SCP_RT_SCG   RS" ).append("\n"); 
		query.append("    WHERE   RS.PROP_NO      = RT.PROP_NO" ).append("\n"); 
		query.append("    AND     RS.AMDT_SEQ     = RT.AMDT_SEQ" ).append("\n"); 
		query.append("    AND     RS.SVC_SCP_CD   = RT.SVC_SCP_CD" ).append("\n"); 
		query.append("    AND     RS.CMDT_HDR_SEQ = RT.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("    AND     RS.ROUT_SEQ     = RT.ROUT_SEQ" ).append("\n"); 
		query.append("    AND     RS.RT_SEQ       = RT.RT_SEQ" ).append("\n"); 
		query.append("    --AND     RS.CHG_CD       IN ( 'BAF', 'CAF', 'PSC' ) /* charge 미선택시 다보여준다  : 2009.10.12 */" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append(")   ," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("RA AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("/*******************************************************************************************" ).append("\n"); 
		query.append("최종 조회를 위한 추가적 DATA 를 만든다." ).append("\n"); 
		query.append("*******************************************************************************************/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    SELECT  " ).append("\n"); 
		query.append("    		CG.ROW_SUBSUM_GROUP ," ).append("\n"); 
		query.append("            CG.PROP_NO          ," ).append("\n"); 
		query.append("            CG.AMDT_SEQ         ," ).append("\n"); 
		query.append("            CG.SVC_SCP_CD       ," ).append("\n"); 
		query.append("            CG.EFF_DT           ," ).append("\n"); 
		query.append("            CG.CMDT_HDR_SEQ     ," ).append("\n"); 
		query.append("            CG.ROUT_SEQ         ," ).append("\n"); 
		query.append("            CG.RT_SEQ           ," ).append("\n"); 
		query.append("            CG.RFA_NO           ," ).append("\n"); 
		query.append("            CG.CUST_NM          ," ).append("\n"); 
		query.append("            CG.FNL_MQC_QTY      ," ).append("\n"); 
		query.append("            CG.PROP_SCP_OFC_CD  ," ).append("\n"); 
		query.append("            CG.PROP_SCP_SREP_CD ," ).append("\n"); 
		query.append("            RC.CMDT_NM          ," ).append("\n"); 
		query.append("            NVL(AC.ACT_CUST_NM, 'N/A')  ACT_CUST_NM ," ).append("\n"); 
		query.append("            CG.ORG_PNT_LOC_TP_CD   ," ).append("\n"); 
		query.append("            CG.ORG_PNT_LOC_DEF_CD  ," ).append("\n"); 
		query.append("            CG.RCV_TERM_CD         ," ).append("\n"); 
		query.append("            CG.DEST_PNT_LOC_TP_CD  ," ).append("\n"); 
		query.append("            CG.DEST_PNT_LOC_DEF_CD ," ).append("\n"); 
		query.append("            CG.DE_TERM_CD          ," ).append("\n"); 
		query.append("            OV.ORG_VIA_NM          ," ).append("\n"); 
		query.append("            DV.DEST_VIA_NM         ," ).append("\n"); 
		query.append("            CG.CHG_CD              ," ).append("\n"); 
		query.append("            CG.RAT_UT_CD           ," ).append("\n"); 
		query.append("            CG.PRC_CGO_TP_CD       ," ).append("\n"); 
		query.append("            CG.CURR_CD             ," ).append("\n"); 
		query.append("            CG.FNL_FRT_RT_AMT      ," ).append("\n"); 
		query.append("            CG.PRS_CRNT_LOD_QTY    ," ).append("\n"); 
		query.append("            CG.RFA_CTRT_TP_CD      ," ).append("\n"); 
		query.append("            CG.FIC_RT_TP_CD        ," ).append("\n"); 
		query.append("            CG.FIC_FNL_RT_AMT      ," ).append("\n"); 
		query.append("            CG.FIC_TP              ," ).append("\n"); 
		query.append("            CG.FIC_ORG_DEST        " ).append("\n"); 
		query.append("    FROM    CG  ," ).append("\n"); 
		query.append("            (" ).append("\n"); 
		query.append("            SELECT  CG.PROP_NO      ," ).append("\n"); 
		query.append("                    CG.AMDT_SEQ     ," ).append("\n"); 
		query.append("                    CG.SVC_SCP_CD   ," ).append("\n"); 
		query.append("                    CG.CMDT_HDR_SEQ ," ).append("\n"); 
		query.append("                    DBMS_LOB.SUBSTR ( " ).append("\n"); 
		query.append("                        BKG_JOIN_CLOB_FNC (" ).append("\n"); 
		query.append("                            CURSOR ( SELECT /*+ ORDERED */" ).append("\n"); 
		query.append("                                            /*CG.PROP_NO      ," ).append("\n"); 
		query.append("                                              CG.AMDT_SEQ     ," ).append("\n"); 
		query.append("                                              CG.SVC_SCP_CD   ," ).append("\n"); 
		query.append("                                              CG.CMDT_HDR_SEQ ," ).append("\n"); 
		query.append("                                              ROW_NUMBER() OVER ( PARTITION BY CG.PROP_NO, CG.AMDT_SEQ, CG.SVC_SCP_CD, CG.CMDT_HDR_SEQ ORDER BY RC.CMDT_SEQ ) ROW_NUMBER  ," ).append("\n"); 
		query.append("                                              COUNT(1) OVER ( PARTITION BY CG.PROP_NO, CG.AMDT_SEQ, CG.SVC_SCP_CD, CG.CMDT_HDR_SEQ ) CNT  ,*/" ).append("\n"); 
		query.append("                                              DECODE(RC.PRC_CMDT_TP_CD, 'C', MC.CMDT_NM, 'G', GC.PRC_GRP_CMDT_DESC, 'R', MRC.REP_CMDT_NM) CMDT_NM" ).append("\n"); 
		query.append("                                       FROM  PRI_RP_SCP_RT_CMDT  RC  ," ).append("\n"); 
		query.append("                                             MDM_COMMODITY       MC  ," ).append("\n"); 
		query.append("                                             PRI_RP_SCP_GRP_CMDT GC  ," ).append("\n"); 
		query.append("							                 MDM_REP_CMDT        MRC      " ).append("\n"); 
		query.append("                                       WHERE   MC.CMDT_CD(+)         = RC.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("                                         AND   GC.PROP_NO(+)         = RC.PROP_NO" ).append("\n"); 
		query.append("                                         AND   GC.AMDT_SEQ(+)        = RC.AMDT_SEQ" ).append("\n"); 
		query.append("                                         AND   GC.SVC_SCP_CD(+)      = RC.SVC_SCP_CD" ).append("\n"); 
		query.append("                                         AND   GC.PRC_GRP_CMDT_CD(+) = RC.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("                                         AND   RC.PROP_NO            = CG.PROP_NO" ).append("\n"); 
		query.append("                                         AND   RC.AMDT_SEQ           = CG.AMDT_SEQ" ).append("\n"); 
		query.append("                                         AND   RC.SVC_SCP_CD         = CG.SVC_SCP_CD" ).append("\n"); 
		query.append("                                         AND   RC.CMDT_HDR_SEQ       = CG.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("					                     AND   MRC.REP_CMDT_CD(+)    = RC.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("                                         ORDER BY RC.CMDT_SEQ ) , ';' ), 4000, 1 ) AS CMDT_NM" ).append("\n"); 
		query.append("                    -- REPLACE(LTRIM(SYS_CONNECT_BY_PATH(CMDT_NM,'^|^ '),'^|^ '),'^|^',';') CMDT_NM" ).append("\n"); 
		query.append("            FROM     (" ).append("\n"); 
		query.append("                      SELECT  DISTINCT" ).append("\n"); 
		query.append("                              PROP_NO     ," ).append("\n"); 
		query.append("                              AMDT_SEQ    ," ).append("\n"); 
		query.append("                              SVC_SCP_CD  ," ).append("\n"); 
		query.append("                              CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                      FROM    CG" ).append("\n"); 
		query.append("                      )   CG " ).append("\n"); 
		query.append("           -- WHERE    LEVEL        = CNT" ).append("\n"); 
		query.append("           -- START WITH ROW_NUMBER = 1" ).append("\n"); 
		query.append("           -- CONNECT BY" ).append("\n"); 
		query.append("           --          PROP_NO      = PRIOR PROP_NO" ).append("\n"); 
		query.append("           -- AND      AMDT_SEQ     = PRIOR AMDT_SEQ" ).append("\n"); 
		query.append("           -- AND      SVC_SCP_CD   = PRIOR SVC_SCP_CD" ).append("\n"); 
		query.append("           -- AND      CMDT_HDR_SEQ = PRIOR CMDT_HDR_SEQ" ).append("\n"); 
		query.append("           -- AND      ROW_NUMBER   = PRIOR ROW_NUMBER + 1" ).append("\n"); 
		query.append("            )   RC  ," ).append("\n"); 
		query.append("            (" ).append("\n"); 
		query.append("            SELECT  CG.PROP_NO      ," ).append("\n"); 
		query.append("                    CG.AMDT_SEQ     ," ).append("\n"); 
		query.append("                    CG.SVC_SCP_CD   ," ).append("\n"); 
		query.append("                    CG.CMDT_HDR_SEQ ," ).append("\n"); 
		query.append("                    DBMS_LOB.SUBSTR ( " ).append("\n"); 
		query.append("                        BKG_JOIN_CLOB_FNC (" ).append("\n"); 
		query.append("                            CURSOR ( SELECT  /*+ ORDERED */" ).append("\n"); 
		query.append("                                            /* CG.PROP_NO      ," ).append("\n"); 
		query.append("                                            CG.AMDT_SEQ     ," ).append("\n"); 
		query.append("                                            CG.SVC_SCP_CD   ," ).append("\n"); 
		query.append("                                            CG.CMDT_HDR_SEQ ," ).append("\n"); 
		query.append("                                            ROW_NUMBER() OVER ( PARTITION BY CG.PROP_NO, CG.AMDT_SEQ, CG.SVC_SCP_CD, CG.CMDT_HDR_SEQ ORDER BY AC.ACT_CUST_SEQ ) ROW_NUMBER  ," ).append("\n"); 
		query.append("                                            COUNT(1) OVER ( PARTITION BY CG.PROP_NO, CG.AMDT_SEQ, CG.SVC_SCP_CD, CG.CMDT_HDR_SEQ ) CNT  , */" ).append("\n"); 
		query.append("                                            MC.CUST_LGL_ENG_NM  ACT_CUST_NM" ).append("\n"); 
		query.append("                                     FROM   PRI_RP_SCP_RT_ACT_CUST  AC  ," ).append("\n"); 
		query.append("                                            MDM_CUSTOMER            MC" ).append("\n"); 
		query.append("                                    WHERE   MC.CUST_CNT_CD(+) = AC.CUST_CNT_CD" ).append("\n"); 
		query.append("                                      AND   MC.CUST_SEQ(+)    = AC.CUST_SEQ" ).append("\n"); 
		query.append("                                      AND   AC.PROP_NO        = CG.PROP_NO" ).append("\n"); 
		query.append("                                      AND   AC.AMDT_SEQ       = CG.AMDT_SEQ" ).append("\n"); 
		query.append("                                      AND   AC.SVC_SCP_CD     = CG.SVC_SCP_CD" ).append("\n"); 
		query.append("                                      AND   AC.CMDT_HDR_SEQ   = CG.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                                    ORDER BY AC.ACT_CUST_SEQ ) , ';' ), 4000, 1 ) AS ACT_CUST_NM" ).append("\n"); 
		query.append("               --REPLACE(LTRIM(SYS_CONNECT_BY_PATH(ACT_CUST_NM,'^|^ '),'^|^ '),'^|^',';') ACT_CUST_NM" ).append("\n"); 
		query.append("            FROM    ( SELECT  DISTINCT" ).append("\n"); 
		query.append("                              PROP_NO      ," ).append("\n"); 
		query.append("                              AMDT_SEQ     ," ).append("\n"); 
		query.append("                              SVC_SCP_CD   ," ).append("\n"); 
		query.append("                              CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                       FROM   CG" ).append("\n"); 
		query.append("                    )   CG   " ).append("\n"); 
		query.append("          --  WHERE   LEVEL         = CNT" ).append("\n"); 
		query.append("          --  START WITH ROW_NUMBER = 1" ).append("\n"); 
		query.append("          --  CONNECT BY" ).append("\n"); 
		query.append("          --         PROP_NO      = PRIOR PROP_NO" ).append("\n"); 
		query.append("          --  AND    AMDT_SEQ     = PRIOR AMDT_SEQ" ).append("\n"); 
		query.append("          --  AND    SVC_SCP_CD   = PRIOR SVC_SCP_CD" ).append("\n"); 
		query.append("          --  AND    CMDT_HDR_SEQ = PRIOR CMDT_HDR_SEQ" ).append("\n"); 
		query.append("          --  AND    ROW_NUMBER   = PRIOR ROW_NUMBER + 1" ).append("\n"); 
		query.append("            )   AC  ," ).append("\n"); 
		query.append("            (" ).append("\n"); 
		query.append("            SELECT   CG.PROP_NO        ," ).append("\n"); 
		query.append("                     CG.AMDT_SEQ      ," ).append("\n"); 
		query.append("                     CG.SVC_SCP_CD    ," ).append("\n"); 
		query.append("                     CG.CMDT_HDR_SEQ  ," ).append("\n"); 
		query.append("                     CG.ROUT_SEQ      ," ).append("\n"); 
		query.append("                     DBMS_LOB.SUBSTR ( " ).append("\n"); 
		query.append("                        BKG_JOIN_CLOB_FNC (" ).append("\n"); 
		query.append("                            CURSOR ( SELECT  /*+ ORDERED */" ).append("\n"); 
		query.append("                                             /* CG.PROP_NO      ," ).append("\n"); 
		query.append("                                                CG.AMDT_SEQ     ," ).append("\n"); 
		query.append("                                                CG.SVC_SCP_CD   ," ).append("\n"); 
		query.append("                                                CG.CMDT_HDR_SEQ ," ).append("\n"); 
		query.append("                                                CG.ROUT_SEQ     ," ).append("\n"); 
		query.append("                                                ROW_NUMBER() OVER ( PARTITION BY CG.PROP_NO, CG.AMDT_SEQ, CG.SVC_SCP_CD, CG.CMDT_HDR_SEQ, CG.ROUT_SEQ ORDER BY OV.ROUT_VIA_SEQ ) ROW_NUMBER ," ).append("\n"); 
		query.append("                                                COUNT(1) OVER ( PARTITION BY CG.PROP_NO, CG.AMDT_SEQ, CG.SVC_SCP_CD, CG.CMDT_HDR_SEQ, CG.ROUT_SEQ ) CNT , */" ).append("\n"); 
		query.append("                                             DECODE(OV.ROUT_VIA_PORT_TP_CD, 'L', ML.LOC_NM, 'G', GL.PRC_GRP_LOC_DESC) ORG_VIA_NM" ).append("\n"); 
		query.append("                                       FROM  PRI_RP_SCP_RT_ROUT_VIA  OV  ," ).append("\n"); 
		query.append("                                             MDM_LOCATION            ML  ," ).append("\n"); 
		query.append("                                             PRI_RP_SCP_GRP_LOC      GL" ).append("\n"); 
		query.append("                                      WHERE   ML.LOC_CD(+)         = OV.ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("                                        AND   GL.PROP_NO(+)        = OV.PROP_NO" ).append("\n"); 
		query.append("                                        AND   GL.AMDT_SEQ(+)       = OV.AMDT_SEQ" ).append("\n"); 
		query.append("                                        AND   GL.SVC_SCP_CD(+)     = OV.SVC_SCP_CD" ).append("\n"); 
		query.append("                                        AND   GL.PRC_GRP_LOC_CD(+) = OV.ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("                                        AND   OV.PROP_NO           = CG.PROP_NO" ).append("\n"); 
		query.append("                                        AND   OV.AMDT_SEQ          = CG.AMDT_SEQ" ).append("\n"); 
		query.append("                                        AND   OV.SVC_SCP_CD        = CG.SVC_SCP_CD" ).append("\n"); 
		query.append("                                        AND   OV.CMDT_HDR_SEQ      = CG.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                                        AND   OV.ROUT_SEQ          = CG.ROUT_SEQ" ).append("\n"); 
		query.append("                                        AND   OV.ORG_DEST_TP_CD    = 'O'" ).append("\n"); 
		query.append("                                        ORDER BY OV.ROUT_VIA_SEQ)  , ';' ), 4000, 1 ) AS ORG_VIA_NM" ).append("\n"); 
		query.append("                     --REPLACE(LTRIM(SYS_CONNECT_BY_PATH(ORG_VIA_NM,'^|^ '),'^|^ '),'^|^',';') ORG_VIA_NM" ).append("\n"); 
		query.append("            FROM     (SELECT  DISTINCT" ).append("\n"); 
		query.append("                              PROP_NO      ," ).append("\n"); 
		query.append("                              AMDT_SEQ     ," ).append("\n"); 
		query.append("                              SVC_SCP_CD   ," ).append("\n"); 
		query.append("                              CMDT_HDR_SEQ ," ).append("\n"); 
		query.append("                              ROUT_SEQ" ).append("\n"); 
		query.append("                        FROM  CG" ).append("\n"); 
		query.append("                      )   CG " ).append("\n"); 
		query.append("           -- WHERE       LEVEL     = CNT" ).append("\n"); 
		query.append("           -- START WITH ROW_NUMBER = 1" ).append("\n"); 
		query.append("           -- CONNECT BY" ).append("\n"); 
		query.append("           --         PROP_NO      = PRIOR PROP_NO" ).append("\n"); 
		query.append("           -- AND     AMDT_SEQ     = PRIOR AMDT_SEQ" ).append("\n"); 
		query.append("           -- AND     SVC_SCP_CD   = PRIOR SVC_SCP_CD" ).append("\n"); 
		query.append("           -- AND     CMDT_HDR_SEQ = PRIOR CMDT_HDR_SEQ" ).append("\n"); 
		query.append("           -- AND     ROUT_SEQ     = PRIOR ROUT_SEQ" ).append("\n"); 
		query.append("           -- AND     ROW_NUMBER   = PRIOR ROW_NUMBER + 1" ).append("\n"); 
		query.append("            )   OV  ," ).append("\n"); 
		query.append("            (" ).append("\n"); 
		query.append("            SELECT  CG.PROP_NO      ," ).append("\n"); 
		query.append("                    CG.AMDT_SEQ     ," ).append("\n"); 
		query.append("                    CG.SVC_SCP_CD   ," ).append("\n"); 
		query.append("                    CG.CMDT_HDR_SEQ ," ).append("\n"); 
		query.append("                    CG.ROUT_SEQ     ," ).append("\n"); 
		query.append("                    DBMS_LOB.SUBSTR ( " ).append("\n"); 
		query.append("                        BKG_JOIN_CLOB_FNC (" ).append("\n"); 
		query.append("                            CURSOR ( SELECT  /*+ ORDERED */" ).append("\n"); 
		query.append("                                             /* CG.PROP_NO      ," ).append("\n"); 
		query.append("                                                CG.AMDT_SEQ     ," ).append("\n"); 
		query.append("                                                CG.SVC_SCP_CD   ," ).append("\n"); 
		query.append("                                                CG.CMDT_HDR_SEQ ," ).append("\n"); 
		query.append("                                                CG.ROUT_SEQ     ," ).append("\n"); 
		query.append("                                                ROW_NUMBER() OVER ( PARTITION BY CG.PROP_NO, CG.AMDT_SEQ, CG.SVC_SCP_CD, CG.CMDT_HDR_SEQ, CG.ROUT_SEQ ORDER BY DV.ROUT_VIA_SEQ ) ROW_NUMBER ," ).append("\n"); 
		query.append("                                                COUNT(1) OVER ( PARTITION BY CG.PROP_NO, CG.AMDT_SEQ, CG.SVC_SCP_CD, CG.CMDT_HDR_SEQ, CG.ROUT_SEQ ) CNT , */" ).append("\n"); 
		query.append("                                             DECODE(DV.ROUT_VIA_PORT_TP_CD, 'L', ML.LOC_NM, 'G', GL.PRC_GRP_LOC_DESC) DEST_VIA_NM" ).append("\n"); 
		query.append("                                      FROM   PRI_RP_SCP_RT_ROUT_VIA  DV  ," ).append("\n"); 
		query.append("                                             MDM_LOCATION            ML  ," ).append("\n"); 
		query.append("                                             PRI_RP_SCP_GRP_LOC      GL" ).append("\n"); 
		query.append("                                     WHERE   ML.LOC_CD(+)         = DV.ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("                                       AND     GL.PROP_NO(+)        = DV.PROP_NO" ).append("\n"); 
		query.append("                                       AND     GL.AMDT_SEQ(+)       = DV.AMDT_SEQ" ).append("\n"); 
		query.append("                                       AND     GL.SVC_SCP_CD(+)     = DV.SVC_SCP_CD" ).append("\n"); 
		query.append("                                       AND     GL.PRC_GRP_LOC_CD(+) = DV.ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("                                       AND     DV.PROP_NO           = CG.PROP_NO" ).append("\n"); 
		query.append("                                       AND     DV.AMDT_SEQ          = CG.AMDT_SEQ" ).append("\n"); 
		query.append("                                       AND     DV.SVC_SCP_CD        = CG.SVC_SCP_CD" ).append("\n"); 
		query.append("                                       AND     DV.CMDT_HDR_SEQ      = CG.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                                       AND     DV.ROUT_SEQ          = CG.ROUT_SEQ" ).append("\n"); 
		query.append("                                       AND     DV.ORG_DEST_TP_CD    = 'D'" ).append("\n"); 
		query.append("                                       ORDER BY DV.ROUT_VIA_SEQ)  , ';' ), 4000, 1 ) AS DEST_VIA_NM" ).append("\n"); 
		query.append("                  --  REPLACE(LTRIM(SYS_CONNECT_BY_PATH(DEST_VIA_NM,'^|^ '),'^|^ '),'^|^',';') DEST_VIA_NM" ).append("\n"); 
		query.append("            FROM    (SELECT  DISTINCT" ).append("\n"); 
		query.append("                             PROP_NO      ," ).append("\n"); 
		query.append("                             AMDT_SEQ     ," ).append("\n"); 
		query.append("                             SVC_SCP_CD   ," ).append("\n"); 
		query.append("                             CMDT_HDR_SEQ ," ).append("\n"); 
		query.append("                             ROUT_SEQ" ).append("\n"); 
		query.append("                       FROM    CG" ).append("\n"); 
		query.append("                     )   CG  " ).append("\n"); 
		query.append("           -- WHERE   LEVEL         = CNT" ).append("\n"); 
		query.append("           -- START WITH ROW_NUMBER = 1" ).append("\n"); 
		query.append("           -- CONNECT BY" ).append("\n"); 
		query.append("           --         PROP_NO      = PRIOR PROP_NO" ).append("\n"); 
		query.append("           -- AND     AMDT_SEQ     = PRIOR AMDT_SEQ" ).append("\n"); 
		query.append("           -- AND     SVC_SCP_CD   = PRIOR SVC_SCP_CD" ).append("\n"); 
		query.append("           -- AND     CMDT_HDR_SEQ = PRIOR CMDT_HDR_SEQ" ).append("\n"); 
		query.append("           -- AND     ROUT_SEQ     = PRIOR ROUT_SEQ" ).append("\n"); 
		query.append("           -- AND     ROW_NUMBER   = PRIOR ROW_NUMBER + 1" ).append("\n"); 
		query.append("            )   DV" ).append("\n"); 
		query.append("    WHERE   RC.PROP_NO(+)      = CG.PROP_NO" ).append("\n"); 
		query.append("    AND     RC.AMDT_SEQ(+)     = CG.AMDT_SEQ" ).append("\n"); 
		query.append("    AND     RC.SVC_SCP_CD(+)   = CG.SVC_SCP_CD" ).append("\n"); 
		query.append("    AND     RC.CMDT_HDR_SEQ(+) = CG.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("    AND     AC.PROP_NO(+)      = CG.PROP_NO" ).append("\n"); 
		query.append("    AND     AC.AMDT_SEQ(+)     = CG.AMDT_SEQ" ).append("\n"); 
		query.append("    AND     AC.SVC_SCP_CD(+)   = CG.SVC_SCP_CD" ).append("\n"); 
		query.append("    AND     AC.CMDT_HDR_SEQ(+) = CG.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("    AND     OV.PROP_NO(+)      = CG.PROP_NO" ).append("\n"); 
		query.append("    AND     OV.AMDT_SEQ(+)     = CG.AMDT_SEQ" ).append("\n"); 
		query.append("    AND     OV.SVC_SCP_CD(+)   = CG.SVC_SCP_CD" ).append("\n"); 
		query.append("    AND     OV.CMDT_HDR_SEQ(+) = CG.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("    AND     OV.ROUT_SEQ(+)     = CG.ROUT_SEQ" ).append("\n"); 
		query.append("    AND     DV.PROP_NO(+)      = CG.PROP_NO" ).append("\n"); 
		query.append("    AND     DV.AMDT_SEQ(+)     = CG.AMDT_SEQ" ).append("\n"); 
		query.append("    AND     DV.SVC_SCP_CD(+)   = CG.SVC_SCP_CD" ).append("\n"); 
		query.append("    AND     DV.CMDT_HDR_SEQ(+) = CG.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("    AND     DV.ROUT_SEQ(+)     = CG.ROUT_SEQ" ).append("\n"); 
		query.append("    AND     NOT EXISTS  (" ).append("\n"); 
		query.append("                         SELECT  'X'" ).append("\n"); 
		query.append("                         FROM    CG B" ).append("\n"); 
		query.append("                         WHERE   B.RFA_NO     = CG.RFA_NO" ).append("\n"); 
		query.append("                         AND     B.SVC_SCP_CD = CG.SVC_SCP_CD" ).append("\n"); 
		query.append("                         AND     B.AMDT_SEQ   > CG.AMDT_SEQ" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append(")   ," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("PR AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("/*******************************************************************************************" ).append("\n"); 
		query.append("PREVIOUS RATE 를 가져온다." ).append("\n"); 
		query.append("*******************************************************************************************/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${is_prerate} == '' || ${is_prerate} == 'null' || ${is_prerate} == 'NULL' || ${is_prerate} == 'N')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    -- if -- Previous Rate 미 선택시" ).append("\n"); 
		query.append("    SELECT  NULL PROP_NO       ," ).append("\n"); 
		query.append("            NULL AMDT_SEQ      ," ).append("\n"); 
		query.append("            NULL SVC_SCP_CD    ," ).append("\n"); 
		query.append("            NULL CMDT_HDR_SEQ  ," ).append("\n"); 
		query.append("            NULL ROUT_SEQ      ," ).append("\n"); 
		query.append("            NULL RT_SEQ        ," ).append("\n"); 
		query.append("            NULL FNL_FRT_RT_AMT" ).append("\n"); 
		query.append("    FROM    DUAL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #else " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    -- else -- Previous Rate 선택시" ).append("\n"); 
		query.append("    SELECT  RT.PROP_NO       ," ).append("\n"); 
		query.append("            RT.AMDT_SEQ      ," ).append("\n"); 
		query.append("            RT.SVC_SCP_CD    ," ).append("\n"); 
		query.append("            RT.CMDT_HDR_SEQ  ," ).append("\n"); 
		query.append("            RT.ROUT_SEQ      ," ).append("\n"); 
		query.append("            RT.RT_SEQ        ," ).append("\n"); 
		query.append("            RT.FNL_FRT_RT_AMT" ).append("\n"); 
		query.append("    FROM    RA  ," ).append("\n"); 
		query.append("            PRI_RP_SCP_MN           RS  ," ).append("\n"); 
		query.append("            PRI_RP_SCP_RT_CMDT_HDR  CH  ," ).append("\n"); 
		query.append("            PRI_RP_SCP_RT_CMDT_ROUT CR  ," ).append("\n"); 
		query.append("            PRI_RP_SCP_RT_ROUT_PNT  OP  ," ).append("\n"); 
		query.append("            PRI_RP_SCP_RT_ROUT_PNT  DP  ," ).append("\n"); 
		query.append("            PRI_RP_SCP_RT   RT" ).append("\n"); 
		query.append("    WHERE   RS.PROP_NO        = RA.PROP_NO" ).append("\n"); 
		query.append("    AND     RS.AMDT_SEQ       < RA.AMDT_SEQ" ).append("\n"); 
		query.append("    AND     RS.SVC_SCP_CD     = RA.SVC_SCP_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    /* 조회조건 */" ).append("\n"); 
		query.append("    #if (${exp_dt} != '')" ).append("\n"); 
		query.append("    --AND      RS.EFF_DT <= TO_DATE('exp_dt', 'YYYY/MM/DD')  -- Effective Date(To) or Access Date   /* previous rate 보여주기 위해 막음, 맞나 ? 2009-12-29 */" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${eff_dt} != '')" ).append("\n"); 
		query.append("    --AND      RS.EXP_DT >= TO_DATE('eff_dt', 'YYYY/MM/DD')  -- Effective Date(From) or Access Date /* previous rate 보여주기 위해 막음, 맞나 ? 2009-12-29 */" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    AND     CH.CMDT_HDR_SEQ   = RA.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("    AND     CH.PROP_NO        = RS.PROP_NO" ).append("\n"); 
		query.append("    AND     CH.AMDT_SEQ       = RS.AMDT_SEQ" ).append("\n"); 
		query.append("    AND     CH.SVC_SCP_CD     = RS.SVC_SCP_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    /* COMMODITY */" ).append("\n"); 
		query.append("    AND     NOT EXISTS  (" ).append("\n"); 
		query.append("                         SELECT  'X'" ).append("\n"); 
		query.append("                         FROM     PRI_RP_SCP_RT_CMDT  A" ).append("\n"); 
		query.append("                         WHERE    A.PROP_NO      = RA.PROP_NO" ).append("\n"); 
		query.append("                         AND      A.AMDT_SEQ     = RA.AMDT_SEQ" ).append("\n"); 
		query.append("                         AND      A.SVC_SCP_CD   = RA.SVC_SCP_CD" ).append("\n"); 
		query.append("                         AND      A.CMDT_HDR_SEQ = RA.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                         AND      NOT EXISTS  (" ).append("\n"); 
		query.append("                                                SELECT  'X'" ).append("\n"); 
		query.append("                                                FROM    PRI_RP_SCP_RT_CMDT  B" ).append("\n"); 
		query.append("                                                WHERE   B.PROP_NO         = CH.PROP_NO" ).append("\n"); 
		query.append("                                                AND     B.AMDT_SEQ        = CH.AMDT_SEQ" ).append("\n"); 
		query.append("                                                AND     B.SVC_SCP_CD      = CH.SVC_SCP_CD" ).append("\n"); 
		query.append("                                                AND     B.CMDT_HDR_SEQ    = CH.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                                                AND     B.PRC_CMDT_TP_CD  = A.PRC_CMDT_TP_CD" ).append("\n"); 
		query.append("                                                AND     B.PRC_CMDT_DEF_CD = A.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("                                              )" ).append("\n"); 
		query.append("                       )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    /* ACTUAL CUSTOMER */" ).append("\n"); 
		query.append("    AND      NOT EXISTS  ( " ).append("\n"); 
		query.append("                          SELECT  'X'" ).append("\n"); 
		query.append("                          FROM     PRI_RP_SCP_RT_ACT_CUST  A" ).append("\n"); 
		query.append("                          WHERE    A.PROP_NO      = RA.PROP_NO" ).append("\n"); 
		query.append("                          AND      A.AMDT_SEQ     = RA.AMDT_SEQ" ).append("\n"); 
		query.append("                          AND      A.SVC_SCP_CD   = RA.SVC_SCP_CD" ).append("\n"); 
		query.append("                          AND      A.CMDT_HDR_SEQ = RA.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                          AND      A.SRC_INFO_CD  <> 'AD'" ).append("\n"); 
		query.append("                          AND      NOT EXISTS  (" ).append("\n"); 
		query.append("                                                SELECT  'X'" ).append("\n"); 
		query.append("                                                FROM    PRI_RP_SCP_RT_ACT_CUST  B" ).append("\n"); 
		query.append("                                                WHERE   B.PROP_NO      = CH.PROP_NO" ).append("\n"); 
		query.append("                                                AND     B.AMDT_SEQ     = CH.AMDT_SEQ" ).append("\n"); 
		query.append("                                                AND     B.SVC_SCP_CD   = CH.SVC_SCP_CD" ).append("\n"); 
		query.append("                                                AND     B.CMDT_HDR_SEQ = CH.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                                                AND     B.CUST_CNT_CD  = A.CUST_CNT_CD" ).append("\n"); 
		query.append("                                                AND     B.CUST_SEQ     = A.CUST_SEQ" ).append("\n"); 
		query.append("                                                AND     B.SRC_INFO_CD  <> 'AD'" ).append("\n"); 
		query.append("                                               )" ).append("\n"); 
		query.append("                         )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    AND     CR.PROP_NO        = CH.PROP_NO" ).append("\n"); 
		query.append("    AND     CR.AMDT_SEQ       = CH.AMDT_SEQ" ).append("\n"); 
		query.append("    AND     CR.SVC_SCP_CD     = CH.SVC_SCP_CD" ).append("\n"); 
		query.append("    AND     CR.CMDT_HDR_SEQ   = CH.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("    AND     CR.ROUT_SEQ       = RA.ROUT_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    /* ORIGIN & DEST VIA */" ).append("\n"); 
		query.append("    AND      NOT EXISTS  (" ).append("\n"); 
		query.append("                          SELECT  'X'" ).append("\n"); 
		query.append("                          FROM    PRI_RP_SCP_RT_ROUT_VIA  A" ).append("\n"); 
		query.append("                          WHERE   A.PROP_NO      = RA.PROP_NO" ).append("\n"); 
		query.append("                          AND     A.AMDT_SEQ     = RA.AMDT_SEQ" ).append("\n"); 
		query.append("                          AND     A.SVC_SCP_CD   = RA.SVC_SCP_CD" ).append("\n"); 
		query.append("                          AND     A.CMDT_HDR_SEQ = RA.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                          AND     A.ROUT_SEQ     = RA.ROUT_SEQ" ).append("\n"); 
		query.append("                          AND     A.SRC_INFO_CD  <> 'AD'" ).append("\n"); 
		query.append("                          AND     NOT EXISTS  (" ).append("\n"); 
		query.append("                                                SELECT  'X'" ).append("\n"); 
		query.append("                                                FROM     PRI_RP_SCP_RT_ROUT_VIA  B" ).append("\n"); 
		query.append("                                                WHERE    B.PROP_NO              = CR.PROP_NO" ).append("\n"); 
		query.append("                                                AND      B.AMDT_SEQ             = CR.AMDT_SEQ" ).append("\n"); 
		query.append("                                                AND      B.SVC_SCP_CD           = CR.SVC_SCP_CD" ).append("\n"); 
		query.append("                                                AND      B.CMDT_HDR_SEQ         = CR.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                                                AND      B.ROUT_SEQ             = CR.ROUT_SEQ" ).append("\n"); 
		query.append("                                                AND      B.ORG_DEST_TP_CD       = A.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("                                                AND      B.ROUT_VIA_PORT_TP_CD  = A.ROUT_VIA_PORT_TP_CD" ).append("\n"); 
		query.append("                                                AND      B.ROUT_VIA_PORT_DEF_CD = A.ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("                                                AND      B.SRC_INFO_CD          <> 'AD'" ).append("\n"); 
		query.append("                                              )" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    AND     OP.ROUT_PNT_LOC_TP_CD  = RA.ORG_PNT_LOC_TP_CD" ).append("\n"); 
		query.append("    AND     OP.ROUT_PNT_LOC_DEF_CD = RA.ORG_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("    AND     OP.RCV_DE_TERM_CD      = RA.RCV_TERM_CD" ).append("\n"); 
		query.append("    AND     OP.PROP_NO        = CR.PROP_NO" ).append("\n"); 
		query.append("    AND     OP.AMDT_SEQ       = CR.AMDT_SEQ" ).append("\n"); 
		query.append("    AND     OP.SVC_SCP_CD     = CR.SVC_SCP_CD" ).append("\n"); 
		query.append("    AND     OP.CMDT_HDR_SEQ   = CR.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("    AND     OP.ROUT_SEQ       = CR.ROUT_SEQ" ).append("\n"); 
		query.append("    AND     OP.ORG_DEST_TP_CD = 'O'" ).append("\n"); 
		query.append("    AND     OP.SRC_INFO_CD    <> 'AD'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    AND     DP.ROUT_PNT_LOC_TP_CD  = RA.DEST_PNT_LOC_TP_CD" ).append("\n"); 
		query.append("    AND     DP.ROUT_PNT_LOC_DEF_CD = RA.DEST_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("    AND     DP.RCV_DE_TERM_CD      = RA.DE_TERM_CD" ).append("\n"); 
		query.append("    AND     DP.PROP_NO        = CR.PROP_NO" ).append("\n"); 
		query.append("    AND     DP.AMDT_SEQ       = CR.AMDT_SEQ" ).append("\n"); 
		query.append("    AND     DP.SVC_SCP_CD     = CR.SVC_SCP_CD" ).append("\n"); 
		query.append("    AND     DP.CMDT_HDR_SEQ   = CR.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("    AND     DP.ROUT_SEQ       = CR.ROUT_SEQ" ).append("\n"); 
		query.append("    AND     DP.ORG_DEST_TP_CD = 'D'" ).append("\n"); 
		query.append("    AND     DP.SRC_INFO_CD    <> 'AD'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    AND     RT.RT_SEQ         = RA.RT_SEQ" ).append("\n"); 
		query.append("    AND     RT.RAT_UT_CD      = RA.RAT_UT_CD" ).append("\n"); 
		query.append("    AND     RT.PRC_CGO_TP_CD  = RA.PRC_CGO_TP_CD" ).append("\n"); 
		query.append("    AND     RT.CURR_CD        = RA.CURR_CD" ).append("\n"); 
		query.append("    AND     RT.FNL_FRT_RT_AMT <> RA.FNL_FRT_RT_AMT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    AND     RT.PROP_NO        = CR.PROP_NO" ).append("\n"); 
		query.append("    AND     RT.AMDT_SEQ       = CR.AMDT_SEQ" ).append("\n"); 
		query.append("    AND     RT.SVC_SCP_CD     = CR.SVC_SCP_CD" ).append("\n"); 
		query.append("    AND     RT.CMDT_HDR_SEQ   = CR.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("    AND     RT.ROUT_SEQ       = CR.ROUT_SEQ" ).append("\n"); 
		query.append("    AND     RT.SRC_INFO_CD    <> 'AD'" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT  " ).append("\n"); 
		query.append("        RA.ROW_SUBSUM_GROUP ," ).append("\n"); 
		query.append("        RA.RFA_NO           ," ).append("\n"); 
		query.append("        RA.CUST_NM          ," ).append("\n"); 
		query.append("        RA.FNL_MQC_QTY      ," ).append("\n"); 
		query.append("        RA.PROP_SCP_OFC_CD  ," ).append("\n"); 
		query.append("        RA.PROP_SCP_SREP_CD ," ).append("\n"); 
		query.append("        RA.CMDT_NM          ," ).append("\n"); 
		query.append("        NVL(RA.ACT_CUST_NM, 'N/A') AS ACT_CUST_NM ," ).append("\n"); 
		query.append("        RA.ORG_PNT_LOC_DEF_CD  ," ).append("\n"); 
		query.append("        RA.ORG_VIA_NM          ," ).append("\n"); 
		query.append("        RA.DEST_VIA_NM         ," ).append("\n"); 
		query.append("        RA.DEST_PNT_LOC_DEF_CD ," ).append("\n"); 
		query.append("        RA.RCV_TERM_CD || '/' || RA.DE_TERM_CD AS RCV_DE_TERM_CD ," ).append("\n"); 
		query.append("        RA.CHG_CD         ," ).append("\n"); 
		query.append("        RA.RAT_UT_CD      ," ).append("\n"); 
		query.append("        RA.PRC_CGO_TP_CD  ," ).append("\n"); 
		query.append("        RA.CURR_CD        ," ).append("\n"); 
		query.append("        PR.FNL_FRT_RT_AMT ,             -- PR.FNL_FRT_RT_AMT : pre rate" ).append("\n"); 
		query.append("        RA.FNL_FRT_RT_AMT AS RATE ,     -- RA.FNL_FRT_RT_AMT : rate" ).append("\n"); 
		query.append("		(SELECT	RA.FNL_FRT_RT_AMT / XR.USD_LOCL_XCH_RT AS FNL_FRT_RT_USD_AMT" ).append("\n"); 
		query.append("		  FROM	GL_MON_XCH_RT XR" ).append("\n"); 
		query.append("		  WHERE	XR.ACCT_XCH_RT_YRMON = TO_CHAR(RA.EFF_DT, 'YYYYMM')" ).append("\n"); 
		query.append("			AND	XR.ACCT_XCH_RT_LVL	 = '1'" ).append("\n"); 
		query.append("			AND	XR.CURR_CD			 = RA.CURR_CD" ).append("\n"); 
		query.append("		) AS RATE_USD," ).append("\n"); 
		query.append("        RA.FNL_FRT_RT_AMT - PR.FNL_FRT_RT_AMT AS DIFF_AMT ," ).append("\n"); 
		query.append("        TO_CHAR(RA.EFF_DT,'YYYY-MM-DD') AS EFF_DT         ," ).append("\n"); 
		query.append("        RA.PRS_CRNT_LOD_QTY ," ).append("\n"); 
		query.append("		NVL(RA.SVC_SCP_CD,'X') || NVL(TO_CHAR(RA.CMDT_HDR_SEQ),'X') || NVL(TO_CHAR(RA.ROUT_SEQ),'X') || NVL(TO_CHAR(RA.RT_SEQ),'X') AS SUBSUM_GROUP ," ).append("\n"); 
		query.append("		RA.SVC_SCP_CD       , -- param 같이, 소계그룹" ).append("\n"); 
		query.append("		RA.CMDT_HDR_SEQ     , -- 소계그룹" ).append("\n"); 
		query.append("		RA.ROUT_SEQ			, -- 소계그룹" ).append("\n"); 
		query.append("		RA.RT_SEQ			, -- 소계그룹" ).append("\n"); 
		query.append("        (SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD03264' AND INTG_CD_VAL_CTNT = RA.RFA_CTRT_TP_CD) AS RFA_CTRT_TP_CD,				" ).append("\n"); 
		query.append("		CASE WHEN RA.FIC_TP = 1 AND RA.FIC_RT_TP_CD = 'A' THEN DECODE(RA.FNL_FRT_RT_AMT, NULL, 0.00, TRUNC(TRUNC(RA.FNL_FRT_RT_AMT,2) - TRUNC(NVL(RA.FIC_FNL_RT_AMT,0),2),2))" ).append("\n"); 
		query.append("             WHEN RA.FIC_TP = 2 AND RA.FIC_RT_TP_CD = 'A' THEN DECODE(RA.FNL_FRT_RT_AMT, NULL, 0.00, TRUNC(TRUNC(RA.FNL_FRT_RT_AMT,2) - TRUNC(RA.FIC_ORG_DEST,2),2))" ).append("\n"); 
		query.append("             ELSE RA.FNL_FRT_RT_AMT" ).append("\n"); 
		query.append("             END FNL_BOF_AMT," ).append("\n"); 
		query.append("        '' AS EXP_DT                    , -- param" ).append("\n"); 
		query.append("		'' AS ROUT_PNT_LOC_DEF_CD_ORI   , -- param" ).append("\n"); 
		query.append("		'' AS ROUT_PNT_LOC_DEF_CD_DEST  , -- param" ).append("\n"); 
		query.append("		'' AS ROUT_VIA_PORT_DEF_CD_ORI  , -- param" ).append("\n"); 
		query.append("		'' AS ROUT_VIA_PORT_DEF_CD_DEST , -- param" ).append("\n"); 
		query.append("		'' AS FNL_FRT_RT                , -- param" ).append("\n"); 
		query.append("		'' AS FNL_MQC                   , -- param" ).append("\n"); 
		query.append("		'' AS CTRT_CUST_CNT_CD          , -- param" ).append("\n"); 
		query.append("		'' AS CTRT_CUST_SEQ             , -- param" ).append("\n"); 
		query.append("		'' AS CUST_CNT_CD               , -- param" ).append("\n"); 
		query.append("		'' AS CUST_SEQ                  , -- param" ).append("\n"); 
		query.append("		'' AS PRC_CTRT_CUST_TP_CD       , -- param" ).append("\n"); 
		query.append("		'' AS PRC_CMDT_DEF_CD           , -- param" ).append("\n"); 
		query.append("        '' AS IS_PRERATE                  -- param" ).append("\n"); 
		query.append("FROM    RA  ," ).append("\n"); 
		query.append("            (" ).append("\n"); 
		query.append("            SELECT  A.PROP_NO       ," ).append("\n"); 
		query.append("                    A.AMDT_SEQ      ," ).append("\n"); 
		query.append("                    A.SVC_SCP_CD    ," ).append("\n"); 
		query.append("                    A.CMDT_HDR_SEQ  ," ).append("\n"); 
		query.append("                    A.ROUT_SEQ      ," ).append("\n"); 
		query.append("                    A.RT_SEQ        ," ).append("\n"); 
		query.append("                    A.FNL_FRT_RT_AMT" ).append("\n"); 
		query.append("            FROM    PR  A" ).append("\n"); 
		query.append("            WHERE   NOT EXISTS  (" ).append("\n"); 
		query.append("                                 SELECT  'X'" ).append("\n"); 
		query.append("                                 FROM     PR  B" ).append("\n"); 
		query.append("                                 WHERE    B.PROP_NO      = A.PROP_NO" ).append("\n"); 
		query.append("                                 AND      B.AMDT_SEQ     > A.AMDT_SEQ" ).append("\n"); 
		query.append("                                 AND      B.SVC_SCP_CD   = A.SVC_SCP_CD" ).append("\n"); 
		query.append("                                 AND      B.CMDT_HDR_SEQ = A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                                 AND      B.ROUT_SEQ     = A.ROUT_SEQ" ).append("\n"); 
		query.append("							     AND      B.RT_SEQ       = A.RT_SEQ" ).append("\n"); 
		query.append("                                )" ).append("\n"); 
		query.append("            )   PR" ).append("\n"); 
		query.append("WHERE   PR.PROP_NO(+)      = RA.PROP_NO" ).append("\n"); 
		query.append("AND     PR.SVC_SCP_CD(+)   = RA.SVC_SCP_CD" ).append("\n"); 
		query.append("AND     PR.CMDT_HDR_SEQ(+) = RA.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND     PR.ROUT_SEQ(+)     = RA.ROUT_SEQ" ).append("\n"); 
		query.append("AND     PR.RT_SEQ(+)       = RA.RT_SEQ" ).append("\n"); 
		query.append("ORDER BY RA.ROW_SUBSUM_GROUP, RA.RFA_NO, RA.SVC_SCP_CD, RA.CMDT_HDR_SEQ, RA.ROUT_SEQ, RA.RT_SEQ" ).append("\n"); 

	}
}