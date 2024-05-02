/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SCReportDBDAORsltSearchSCRateSearchListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.09.20
*@LastModifier : 김경미
*@LastVersion : 1.0
* 2016.09.20 김경미
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.screport.screport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KYEONGMI KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCReportDBDAORsltSearchSCRateSearchListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * rate search
	  * </pre>
	  */
	public SCReportDBDAORsltSearchSCRateSearchListRSQL(){
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
		params.put("rat_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gen_spcl_rt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cmdt_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rout_via_port_def_cd_dest",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.screport.screport.integration").append("\n"); 
		query.append("FileName : SCReportDBDAORsltSearchSCRateSearchListRSQL").append("\n"); 
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
		query.append("RT AS " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT  SH.PROP_NO          ," ).append("\n"); 
		query.append("            SS.PROP_SCP_OFC_CD  , -- 추가" ).append("\n"); 
		query.append("            SS.PROP_SCP_SREP_CD , -- 추가" ).append("\n"); 
		query.append("            RT.AMDT_SEQ         ," ).append("\n"); 
		query.append("            RT.SVC_SCP_CD       ," ).append("\n"); 
		query.append("            SH.SC_NO            ," ).append("\n"); 
		query.append("            CH.GEN_SPCL_RT_TP_CD ," ).append("\n"); 
		query.append("            CH.CMDT_HDR_SEQ      ," ).append("\n"); 
		query.append("            CH.BLET_DP_SEQ       ," ).append("\n"); 
		query.append("            CR.ROUT_SEQ          ," ).append("\n"); 
		query.append("            RT.RT_SEQ            ," ).append("\n"); 
		query.append("            'OFT'   CHG_CD       ," ).append("\n"); 
		query.append("            RT.RAT_UT_CD         ," ).append("\n"); 
		query.append("            RT.PRC_CGO_TP_CD     ," ).append("\n"); 
		query.append("            RT.CURR_CD           ," ).append("\n"); 
		query.append("            RT.FNL_FRT_RT_AMT " ).append("\n"); 
		query.append("    FROM    PRI_SP_HDR              SH  ," ).append("\n"); 
		query.append("            PRI_SP_MN               SM  ," ).append("\n"); 
		query.append("            PRI_SP_CTRT_PTY         CP  ," ).append("\n"); 
		query.append("            PRI_SP_CTRT_CUST_TP     CT  ," ).append("\n"); 
		query.append("            PRI_SP_SCP_MN           SS  ," ).append("\n"); 
		query.append("            PRI_SP_SCP_MQC          SQ  ," ).append("\n"); 
		query.append("            PRI_SP_SCP_RT_CMDT_HDR  CH  ," ).append("\n"); 
		query.append("            PRI_SP_SCP_RT_CMDT_ROUT CR  ," ).append("\n"); 
		query.append("            PRI_SP_SCP_RT_ROUT_PNT  OP  ," ).append("\n"); 
		query.append("            PRI_SP_SCP_RT_ROUT_PNT  DP  ," ).append("\n"); 
		query.append("            PRI_SP_SCP_RT           RT" ).append("\n"); 
		query.append("    WHERE   SM.PROP_NO            = SH.PROP_NO" ).append("\n"); 
		query.append("    AND     SM.PROP_STS_CD        = 'F'" ).append("\n"); 
		query.append("    AND     CP.PROP_NO            = SM.PROP_NO" ).append("\n"); 
		query.append("    AND     CP.AMDT_SEQ           = SM.AMDT_SEQ" ).append("\n"); 
		query.append("    AND     CP.PRC_CTRT_PTY_TP_CD = 'C'" ).append("\n"); 
		query.append("    AND     CT.PROP_NO            = CP.PROP_NO" ).append("\n"); 
		query.append("    AND     CT.AMDT_SEQ           = CP.AMDT_SEQ" ).append("\n"); 
		query.append("    AND     CT.PRC_CTRT_PTY_TP_CD = CP.PRC_CTRT_PTY_TP_CD" ).append("\n"); 
		query.append("    AND     SS.PROP_NO            = SM.PROP_NO" ).append("\n"); 
		query.append("    AND     SS.AMDT_SEQ           = SM.AMDT_SEQ" ).append("\n"); 
		query.append("    AND     SQ.PROP_NO            = SS.PROP_NO" ).append("\n"); 
		query.append("    AND     SQ.AMDT_SEQ           = SS.AMDT_SEQ" ).append("\n"); 
		query.append("    AND     SQ.SVC_SCP_CD         = SS.SVC_SCP_CD" ).append("\n"); 
		query.append("    AND     CH.PROP_NO            = SS.PROP_NO" ).append("\n"); 
		query.append("    AND     CH.AMDT_SEQ           = SS.AMDT_SEQ" ).append("\n"); 
		query.append("    AND     CH.SVC_SCP_CD         = SS.SVC_SCP_CD" ).append("\n"); 
		query.append("    AND     CR.PROP_NO            = CH.PROP_NO" ).append("\n"); 
		query.append("    AND     CR.AMDT_SEQ           = CH.AMDT_SEQ" ).append("\n"); 
		query.append("    AND     CR.SVC_SCP_CD         = CH.SVC_SCP_CD" ).append("\n"); 
		query.append("    AND     CR.GEN_SPCL_RT_TP_CD  = CH.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("    AND     CR.CMDT_HDR_SEQ       = CH.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("    AND     OP.PROP_NO            = CR.PROP_NO" ).append("\n"); 
		query.append("    AND     OP.AMDT_SEQ           = CR.AMDT_SEQ" ).append("\n"); 
		query.append("    AND     OP.SVC_SCP_CD         = CR.SVC_SCP_CD" ).append("\n"); 
		query.append("    AND     OP.CMDT_HDR_SEQ       = CR.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("    AND     OP.GEN_SPCL_RT_TP_CD  = CR.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("    AND     OP.ROUT_SEQ           = CR.ROUT_SEQ" ).append("\n"); 
		query.append("    AND     OP.ORG_DEST_TP_CD     = 'O'" ).append("\n"); 
		query.append("    AND     OP.SRC_INFO_CD        <> 'AD'" ).append("\n"); 
		query.append("    AND     DP.PROP_NO            = CR.PROP_NO" ).append("\n"); 
		query.append("    AND     DP.AMDT_SEQ           = CR.AMDT_SEQ" ).append("\n"); 
		query.append("    AND     DP.SVC_SCP_CD         = CR.SVC_SCP_CD" ).append("\n"); 
		query.append("    AND     DP.GEN_SPCL_RT_TP_CD  = DP.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("    AND     DP.CMDT_HDR_SEQ       = CR.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("    AND     DP.ROUT_SEQ           = CR.ROUT_SEQ" ).append("\n"); 
		query.append("    AND     DP.ORG_DEST_TP_CD     = 'D'" ).append("\n"); 
		query.append("    AND     DP.SRC_INFO_CD        <> 'AD'" ).append("\n"); 
		query.append("    AND     RT.PROP_NO            = CR.PROP_NO" ).append("\n"); 
		query.append("    AND     RT.AMDT_SEQ           = CR.AMDT_SEQ" ).append("\n"); 
		query.append("    AND     RT.SVC_SCP_CD         = CR.SVC_SCP_CD" ).append("\n"); 
		query.append("    AND     RT.GEN_SPCL_RT_TP_CD  = CR.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("    AND     RT.CMDT_HDR_SEQ       = CR.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("    AND     RT.ROUT_SEQ           = CR.ROUT_SEQ" ).append("\n"); 
		query.append("    AND     RT.SRC_INFO_CD        <> 'AD'" ).append("\n"); 
		query.append("    #if (${exp_dt} != '')" ).append("\n"); 
		query.append("    AND         SS.EFF_DT         <= TO_DATE(@[exp_dt], 'YYYY-MM-DD') -- Effective Date(To)" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${eff_dt} != '')" ).append("\n"); 
		query.append("    AND         SS.EXP_DT         >= TO_DATE(@[eff_dt], 'YYYY-MM-DD') -- Effective Date(From)" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${rout_pnt_loc_def_cd_ori} != '')" ).append("\n"); 
		query.append("    AND (    " ).append("\n"); 
		query.append("            OP.ROUT_PNT_LOC_DEF_CD IN" ).append("\n"); 
		query.append("			(" ).append("\n"); 
		query.append("			SELECT	    GL.PRC_GRP_LOC_CD" ).append("\n"); 
		query.append("			FROM		PRI_SP_SCP_GRP_LOC		GL	," ).append("\n"); 
		query.append("						PRI_SP_SCP_GRP_LOC_DTL	GD" ).append("\n"); 
		query.append("			WHERE		GD.PROP_NO			= GL.PROP_NO" ).append("\n"); 
		query.append("			AND			GD.AMDT_SEQ			= GL.AMDT_SEQ" ).append("\n"); 
		query.append("			AND			GD.SVC_SCP_CD		= GL.SVC_SCP_CD" ).append("\n"); 
		query.append("			AND			GD.GRP_LOC_SEQ		= GL.GRP_LOC_SEQ" ).append("\n"); 
		query.append("			AND			GL.PROP_NO			= SS.PROP_NO" ).append("\n"); 
		query.append("			AND			GL.AMDT_SEQ			= SS.AMDT_SEQ" ).append("\n"); 
		query.append("			AND			GL.SVC_SCP_CD		= SS.SVC_SCP_CD" ).append("\n"); 
		query.append("			AND			GD.SRC_INFO_CD		<> 'AD'" ).append("\n"); 
		query.append("			AND			GD.LOC_CD			LIKE @[rout_pnt_loc_def_cd_ori] || '%' -- Origin" ).append("\n"); 
		query.append("	        )" ).append("\n"); 
		query.append("	        OR" ).append("\n"); 
		query.append("		    OP.ROUT_PNT_LOC_DEF_CD LIKE @[rout_pnt_loc_def_cd_ori] || '%' -- Origin" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${rout_pnt_loc_def_cd_dest} != '')" ).append("\n"); 
		query.append("    AND  (" ).append("\n"); 
		query.append("            DP.ROUT_PNT_LOC_DEF_CD IN" ).append("\n"); 
		query.append("			(" ).append("\n"); 
		query.append("			SELECT	GL.PRC_GRP_LOC_CD" ).append("\n"); 
		query.append("			FROM		PRI_SP_SCP_GRP_LOC		GL	," ).append("\n"); 
		query.append("						PRI_SP_SCP_GRP_LOC_DTL	GD" ).append("\n"); 
		query.append("			WHERE		GD.PROP_NO			= GL.PROP_NO" ).append("\n"); 
		query.append("			AND			GD.AMDT_SEQ			= GL.AMDT_SEQ" ).append("\n"); 
		query.append("			AND			GD.SVC_SCP_CD		= GL.SVC_SCP_CD" ).append("\n"); 
		query.append("			AND			GD.GRP_LOC_SEQ		= GL.GRP_LOC_SEQ" ).append("\n"); 
		query.append("			AND			GL.PROP_NO			= SS.PROP_NO" ).append("\n"); 
		query.append("			AND			GL.AMDT_SEQ			= SS.AMDT_SEQ" ).append("\n"); 
		query.append("			AND			GL.SVC_SCP_CD		= SS.SVC_SCP_CD" ).append("\n"); 
		query.append("			AND			GD.SRC_INFO_CD		<> 'AD'" ).append("\n"); 
		query.append("			AND			GD.LOC_CD			LIKE @[rout_pnt_loc_def_cd_dest] || '%' -- Destination" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("	        OR" ).append("\n"); 
		query.append("	        DP.ROUT_PNT_LOC_DEF_CD LIKE @[rout_pnt_loc_def_cd_dest] || '%' -- Destination" ).append("\n"); 
		query.append("          )" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${rout_via_port_def_cd_ori} != '')" ).append("\n"); 
		query.append("    AND     EXISTS  (" ).append("\n"); 
		query.append("                    SELECT  'X'" ).append("\n"); 
		query.append("                    FROM    PRI_SP_SCP_RT_ROUT_VIA  OV" ).append("\n"); 
		query.append("                    WHERE   OV.PROP_NO              = CR.PROP_NO" ).append("\n"); 
		query.append("                    AND     OV.AMDT_SEQ             = CR.AMDT_SEQ" ).append("\n"); 
		query.append("                    AND     OV.SVC_SCP_CD           = CR.SVC_SCP_CD" ).append("\n"); 
		query.append("                    AND     OV.GEN_SPCL_RT_TP_CD    = CR.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                    AND     OV.CMDT_HDR_SEQ         = CR.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                    AND     OV.ROUT_SEQ             = CR.ROUT_SEQ" ).append("\n"); 
		query.append("                    AND     OV.ORG_DEST_TP_CD       = 'O'" ).append("\n"); 
		query.append("                    AND     OV.SRC_INFO_CD          <> 'AD'" ).append("\n"); 
		query.append("                    AND     OV.ROUT_VIA_PORT_DEF_CD LIKE @[rout_via_port_def_cd_ori] || '%'	-- Origin Via" ).append("\n"); 
		query.append("					UNION ALL" ).append("\n"); 
		query.append("					SELECT	'X'" ).append("\n"); 
		query.append("					FROM	PRI_SP_SCP_RT_ROUT_VIA  OV	," ).append("\n"); 
		query.append("							PRI_SP_SCP_GRP_LOC		GL	," ).append("\n"); 
		query.append("							PRI_SP_SCP_GRP_LOC_DTL	GD" ).append("\n"); 
		query.append("                    WHERE   OV.PROP_NO              = CR.PROP_NO" ).append("\n"); 
		query.append("                    AND     OV.AMDT_SEQ             = CR.AMDT_SEQ" ).append("\n"); 
		query.append("                    AND     OV.SVC_SCP_CD           = CR.SVC_SCP_CD" ).append("\n"); 
		query.append("                    AND     OV.GEN_SPCL_RT_TP_CD    = CR.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                    AND     OV.CMDT_HDR_SEQ         = CR.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                    AND     OV.ROUT_SEQ             = CR.ROUT_SEQ" ).append("\n"); 
		query.append("                    AND     OV.ORG_DEST_TP_CD       = 'O'" ).append("\n"); 
		query.append("                    AND     OV.SRC_INFO_CD          <> 'AD'" ).append("\n"); 
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
		query.append("" ).append("\n"); 
		query.append("    #if (${rout_via_port_def_cd_dest} != '')" ).append("\n"); 
		query.append("    AND     EXISTS  (" ).append("\n"); 
		query.append("                    SELECT  'X'" ).append("\n"); 
		query.append("                    FROM    PRI_SP_SCP_RT_ROUT_VIA  DV" ).append("\n"); 
		query.append("                    WHERE   DV.PROP_NO              = CR.PROP_NO" ).append("\n"); 
		query.append("                    AND     DV.AMDT_SEQ             = CR.AMDT_SEQ" ).append("\n"); 
		query.append("                    AND     DV.SVC_SCP_CD           = CR.SVC_SCP_CD" ).append("\n"); 
		query.append("                    AND     DV.GEN_SPCL_RT_TP_CD    = CR.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                    AND     DV.CMDT_HDR_SEQ         = CR.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                    AND     DV.ROUT_SEQ             = CR.ROUT_SEQ" ).append("\n"); 
		query.append("                    AND     DV.ORG_DEST_TP_CD       = 'D'" ).append("\n"); 
		query.append("                    AND     DV.SRC_INFO_CD          <> 'AD'" ).append("\n"); 
		query.append("                    AND     DV.ROUT_VIA_PORT_DEF_CD LIKE @[rout_via_port_def_cd_dest] || '%' -- Dest Via" ).append("\n"); 
		query.append("					UNION ALL" ).append("\n"); 
		query.append("					SELECT	'X'" ).append("\n"); 
		query.append("					FROM	PRI_SP_SCP_RT_ROUT_VIA  DV	," ).append("\n"); 
		query.append("							PRI_SP_SCP_GRP_LOC		GL	," ).append("\n"); 
		query.append("							PRI_SP_SCP_GRP_LOC_DTL	GD" ).append("\n"); 
		query.append("                    WHERE   DV.PROP_NO              = CR.PROP_NO" ).append("\n"); 
		query.append("                    AND     DV.AMDT_SEQ             = CR.AMDT_SEQ" ).append("\n"); 
		query.append("                    AND     DV.SVC_SCP_CD           = CR.SVC_SCP_CD" ).append("\n"); 
		query.append("                    AND     DV.GEN_SPCL_RT_TP_CD    = CR.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                    AND     DV.CMDT_HDR_SEQ         = CR.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                    AND     DV.ROUT_SEQ             = CR.ROUT_SEQ" ).append("\n"); 
		query.append("                    AND     DV.ORG_DEST_TP_CD       = 'O'" ).append("\n"); 
		query.append("                    AND     DV.SRC_INFO_CD          <> 'AD'" ).append("\n"); 
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
		query.append("" ).append("\n"); 
		query.append("    #if (${prc_ctrt_cust_tp_cd} != '')" ).append("\n"); 
		query.append("    AND         CT.PRC_CTRT_CUST_TP_CD  = NVL(@[prc_ctrt_cust_tp_cd], CT.PRC_CTRT_CUST_TP_CD)   -- Customer Type" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${prc_cmdt_def_cd} != '')" ).append("\n"); 
		query.append("    AND    EXISTS  (" ).append("\n"); 
		query.append("                     SELECT  'X'" ).append("\n"); 
		query.append("                     FROM        PRI_SP_SCP_RT_CMDT  RC" ).append("\n"); 
		query.append("                     WHERE       RC.PROP_NO           = CH.PROP_NO" ).append("\n"); 
		query.append("                     AND         RC.AMDT_SEQ          = CH.AMDT_SEQ" ).append("\n"); 
		query.append("                     AND         RC.SVC_SCP_CD        = CH.SVC_SCP_CD" ).append("\n"); 
		query.append("                     AND         RC.GEN_SPCL_RT_TP_CD = CH.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                     AND         RC.CMDT_HDR_SEQ      = CH.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                     AND         RC.PRC_CMDT_TP_CD    = 'C'" ).append("\n"); 
		query.append("                     AND         RC.SRC_INFO_CD       <> 'AD'" ).append("\n"); 
		query.append("                     AND         RC.PRC_CMDT_DEF_CD   LIKE @[prc_cmdt_def_cd] || '%'   -- Commodity" ).append("\n"); 
		query.append("                     UNION ALL" ).append("\n"); 
		query.append("                     SELECT  'X'" ).append("\n"); 
		query.append("                     FROM        PRI_SP_SCP_RT_CMDT  RC" ).append("\n"); 
		query.append("                     WHERE       RC.PROP_NO           = CH.PROP_NO" ).append("\n"); 
		query.append("                     AND         RC.AMDT_SEQ          = CH.AMDT_SEQ" ).append("\n"); 
		query.append("                     AND         RC.SVC_SCP_CD        = CH.SVC_SCP_CD" ).append("\n"); 
		query.append("                     AND         RC.GEN_SPCL_RT_TP_CD = CH.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                     AND         RC.CMDT_HDR_SEQ      = CH.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                     AND         RC.PRC_CMDT_TP_CD    = 'G'" ).append("\n"); 
		query.append("                     AND         RC.SRC_INFO_CD       <> 'AD'" ).append("\n"); 
		query.append("                     AND         EXISTS  (" ).append("\n"); 
		query.append("                                           SELECT  'X'" ).append("\n"); 
		query.append("                                           FROM        PRI_SP_SCP_GRP_CMDT     G ," ).append("\n"); 
		query.append("                                                       PRI_SP_SCP_GRP_CMDT_DTL D" ).append("\n"); 
		query.append("                                           WHERE       D.PROP_NO         = G.PROP_NO" ).append("\n"); 
		query.append("                                           AND         D.AMDT_SEQ        = G.AMDT_SEQ" ).append("\n"); 
		query.append("                                           AND         D.SVC_SCP_CD      = G.SVC_SCP_CD" ).append("\n"); 
		query.append("                                           AND         D.GRP_CMDT_SEQ    = G.GRP_CMDT_SEQ" ).append("\n"); 
		query.append("                                           AND         D.PRC_CMDT_TP_CD  = 'C'" ).append("\n"); 
		query.append("                                           AND         D.SRC_INFO_CD     <> 'AD'" ).append("\n"); 
		query.append("                                           AND         D.PRC_CMDT_DEF_CD LIKE @[prc_cmdt_def_cd] || '%' -- Commodity" ).append("\n"); 
		query.append("                                           AND         G.PROP_NO         = RC.PROP_NO" ).append("\n"); 
		query.append("                                           AND         G.AMDT_SEQ        = RC.AMDT_SEQ" ).append("\n"); 
		query.append("                                           AND         G.SVC_SCP_CD      = RC.SVC_SCP_CD" ).append("\n"); 
		query.append("                                           AND         G.PRC_GRP_CMDT_CD = RC.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("                                          )" ).append("\n"); 
		query.append("                 )" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${rat_ut_cd} != '')" ).append("\n"); 
		query.append("    AND    RT.RAT_UT_CD         = @[rat_ut_cd]                   -- RATING UNIT" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    #if (${prc_cgo_tp_cd} != '')" ).append("\n"); 
		query.append("    AND    RT.PRC_CGO_TP_CD     = @[prc_cgo_tp_cd]               -- CARGO TYPE" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${chg_cd} == 'OFT' && ${fnl_frt_rt} != '')" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    #if (${fnl_frt_rt} == '<' && ${fnl_frt_rt_amt} != '')" ).append("\n"); 
		query.append("    AND    RT.FNL_FRT_RT_AMT < TO_NUMBER(REPLACE(@[fnl_frt_rt_amt],',','')) -- RATE" ).append("\n"); 
		query.append("    #elseif (${fnl_frt_rt} == '>' && ${fnl_frt_rt_amt} != '')" ).append("\n"); 
		query.append("    AND    RT.FNL_FRT_RT_AMT > TO_NUMBER(REPLACE(@[fnl_frt_rt_amt],',','')) -- RATE" ).append("\n"); 
		query.append("    #elseif (${fnl_frt_rt} == '<=' && ${fnl_frt_rt_amt} != '')" ).append("\n"); 
		query.append("    AND    RT.FNL_FRT_RT_AMT <= TO_NUMBER(REPLACE(@[fnl_frt_rt_amt],',','')) -- RATE" ).append("\n"); 
		query.append("    #elseif (${fnl_frt_rt} == '>=' && ${fnl_frt_rt_amt} != '')" ).append("\n"); 
		query.append("    AND    RT.FNL_FRT_RT_AMT >= TO_NUMBER(REPLACE(@[fnl_frt_rt_amt],',','')) -- RATE" ).append("\n"); 
		query.append("    #elseif (${fnl_frt_rt} == '=' && ${fnl_frt_rt_amt} != '')" ).append("\n"); 
		query.append("    AND    RT.FNL_FRT_RT_AMT = TO_NUMBER(REPLACE(@[fnl_frt_rt_amt],',','')) -- RATE" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    #if (${fnl_mqc} != '')" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    #if (${fnl_mqc} == '<' && ${fnl_mqc_qty} != '')" ).append("\n"); 
		query.append("    AND    SQ.FNL_MQC_QTY < TO_NUMBER(REPLACE(@[fnl_mqc_qty],',','')) -- MQC" ).append("\n"); 
		query.append("    #elseif (${fnl_mqc} == '>' && ${fnl_mqc_qty} != '')" ).append("\n"); 
		query.append("    AND    SQ.FNL_MQC_QTY > TO_NUMBER(REPLACE(@[fnl_mqc_qty],',','')) -- MQC" ).append("\n"); 
		query.append("    #elseif (${fnl_mqc} == '<=' && ${fnl_mqc_qty} != '')" ).append("\n"); 
		query.append("    AND    SQ.FNL_MQC_QTY <= TO_NUMBER(REPLACE(@[fnl_mqc_qty],',','')) -- MQC" ).append("\n"); 
		query.append("    #elseif (${fnl_mqc} == '>=' && ${fnl_mqc_qty} != '')" ).append("\n"); 
		query.append("    AND    SQ.FNL_MQC_QTY >= TO_NUMBER(REPLACE(@[fnl_mqc_qty],',','')) -- MQC" ).append("\n"); 
		query.append("    #elseif (${fnl_mqc} == '=' && ${fnl_mqc_qty} != '')" ).append("\n"); 
		query.append("    AND    SQ.FNL_MQC_QTY = TO_NUMBER(REPLACE(@[fnl_mqc_qty],',','')) -- MQC" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${prop_scp_ofc_cd} != '')" ).append("\n"); 
		query.append("    AND    SS.PROP_SCP_OFC_CD   = @[prop_scp_ofc_cd]    -- REQUEST OFFICE" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    #if (${prop_scp_srep_cd} != '')" ).append("\n"); 
		query.append("    AND    SS.PROP_SCP_SREP_CD  = @[prop_scp_srep_cd]   -- SALES REP" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    #if (${sc_no} != '')" ).append("\n"); 
		query.append("    AND    SH.SC_NO LIKE @[sc_no] || '%'    -- S/C NO" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    #if (${svc_scp_cd} != '')" ).append("\n"); 
		query.append("    AND    SS.SVC_SCP_CD        = @[svc_scp_cd]         -- SVC SCOPE CODE" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    #if (${gen_spcl_rt_tp_cd} != '')" ).append("\n"); 
		query.append("    AND    CH.GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]  -- RATE TYPE" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")   ," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("CG AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    SELECT  RT.PROP_NO          ," ).append("\n"); 
		query.append("            RT.PROP_SCP_OFC_CD  , -- 추가" ).append("\n"); 
		query.append("            RT.PROP_SCP_SREP_CD , -- 추가" ).append("\n"); 
		query.append("            RT.AMDT_SEQ          ," ).append("\n"); 
		query.append("            RT.SVC_SCP_CD        ," ).append("\n"); 
		query.append("            RT.SC_NO             ," ).append("\n"); 
		query.append("            RT.GEN_SPCL_RT_TP_CD ," ).append("\n"); 
		query.append("            RT.CMDT_HDR_SEQ      ," ).append("\n"); 
		query.append("            RT.BLET_DP_SEQ       ," ).append("\n"); 
		query.append("            RT.ROUT_SEQ          ," ).append("\n"); 
		query.append("            RT.RT_SEQ            ," ).append("\n"); 
		query.append("            RT.CHG_CD            ," ).append("\n"); 
		query.append("            RT.RAT_UT_CD         ," ).append("\n"); 
		query.append("            RT.PRC_CGO_TP_CD     ," ).append("\n"); 
		query.append("            RT.CURR_CD           ," ).append("\n"); 
		query.append("            RT.FNL_FRT_RT_AMT" ).append("\n"); 
		query.append("    FROM    RT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")   ," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SC AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    SELECT  CG.SC_NO                    ," ).append("\n"); 
		query.append("            CG.PROP_NO                  ," ).append("\n"); 
		query.append("            CP.CTRT_PTY_NM              ," ).append("\n"); 
		query.append("            DECODE(SQ.CNTR_LOD_UT_CD, 'T', SQ.FNL_MQC_QTY / 2, SQ.FNL_MQC_QTY)  FNL_MQC_QTY ," ).append("\n"); 
		query.append("            CG.PROP_SCP_OFC_CD          , -- 추가" ).append("\n"); 
		query.append("            CG.PROP_SCP_SREP_CD         , -- 추가" ).append("\n"); 
		query.append("            CG.AMDT_SEQ                 ," ).append("\n"); 
		query.append("            CG.SVC_SCP_CD               ," ).append("\n"); 
		query.append("            CG.GEN_SPCL_RT_TP_CD        ," ).append("\n"); 
		query.append("            CG.BLET_DP_SEQ              ," ).append("\n"); 
		query.append("            CG.CMDT_HDR_SEQ             , -- 추가" ).append("\n"); 
		query.append("            CG.ROUT_SEQ                 , -- 추가" ).append("\n"); 
		query.append("            CG.RT_SEQ                   , -- 추가" ).append("\n"); 
		query.append("            RC.CMDT_NM                  ," ).append("\n"); 
		query.append("            NVL(REPLACE(AC.ACT_CUST_NM, '^|^', ' / '), 'N/A')  ACT_CUST_NM ," ).append("\n"); 
		query.append("            --OP.ORG_NM                   ," ).append("\n"); 
		query.append("            OP.ORG_CD                   ," ).append("\n"); 
		query.append("            --OV.ORG_VIA_NM               ," ).append("\n"); 
		query.append("			OV.ORG_VIA_CD               ," ).append("\n"); 
		query.append("            --DV.DEST_VIA_NM              ," ).append("\n"); 
		query.append("			DV.DEST_VIA_CD              ," ).append("\n"); 
		query.append("            --DP.DEST_NM                  ," ).append("\n"); 
		query.append("			DP.DEST_CD                  ," ).append("\n"); 
		query.append("            CG.CHG_CD                   ," ).append("\n"); 
		query.append("            CG.RAT_UT_CD                ," ).append("\n"); 
		query.append("            CG.PRC_CGO_TP_CD            ," ).append("\n"); 
		query.append("            CG.CURR_CD                  ," ).append("\n"); 
		query.append("            CG.FNL_FRT_RT_AMT " ).append("\n"); 
		query.append("    FROM    CG  ," ).append("\n"); 
		query.append("            PRI_SP_CTRT_PTY         CP  ," ).append("\n"); 
		query.append("            PRI_SP_SCP_MQC          SQ  ," ).append("\n"); 
		query.append("            (" ).append("\n"); 
		query.append("             SELECT  PROP_NO           ," ).append("\n"); 
		query.append("                     AMDT_SEQ          ," ).append("\n"); 
		query.append("                     SVC_SCP_CD        ," ).append("\n"); 
		query.append("                     GEN_SPCL_RT_TP_CD ," ).append("\n"); 
		query.append("                     CMDT_HDR_SEQ      ," ).append("\n"); 
		query.append("                     LTRIM(SYS_CONNECT_BY_PATH(CMDT_NM,' / '),' / ') CMDT_NM" ).append("\n"); 
		query.append("              FROM   (" ).append("\n"); 
		query.append("                       SELECT  /*+ ORDERED */" ).append("\n"); 
		query.append("                               CG.PROP_NO           ," ).append("\n"); 
		query.append("                               CG.AMDT_SEQ          ," ).append("\n"); 
		query.append("                               CG.SVC_SCP_CD        ," ).append("\n"); 
		query.append("                               CG.GEN_SPCL_RT_TP_CD ," ).append("\n"); 
		query.append("                               CG.CMDT_HDR_SEQ      ," ).append("\n"); 
		query.append("                               ROW_NUMBER() OVER ( PARTITION BY CG.PROP_NO, CG.AMDT_SEQ, CG.SVC_SCP_CD, CG.GEN_SPCL_RT_TP_CD, CG.CMDT_HDR_SEQ ORDER BY RC.CMDT_SEQ ) ROW_NUMBER    ," ).append("\n"); 
		query.append("                               COUNT(1) OVER ( PARTITION BY CG.PROP_NO, CG.AMDT_SEQ, CG.SVC_SCP_CD, CG.GEN_SPCL_RT_TP_CD, CG.CMDT_HDR_SEQ ) CNT    ," ).append("\n"); 
		query.append("                               DECODE(RC.PRC_CMDT_TP_CD, 'C', MC.CMDT_NM, 'G', GC.PRC_GRP_CMDT_DESC) CMDT_NM" ).append("\n"); 
		query.append("                       FROM    (" ).append("\n"); 
		query.append("                                 SELECT  DISTINCT" ).append("\n"); 
		query.append("                                         PROP_NO             ," ).append("\n"); 
		query.append("                                         AMDT_SEQ            ," ).append("\n"); 
		query.append("                                         SVC_SCP_CD          ," ).append("\n"); 
		query.append("                                         GEN_SPCL_RT_TP_CD   ," ).append("\n"); 
		query.append("                                         CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                                 FROM    CG" ).append("\n"); 
		query.append("                                )   CG                ," ).append("\n"); 
		query.append("                               PRI_SP_SCP_RT_CMDT  RC ," ).append("\n"); 
		query.append("                               MDM_COMMODITY       MC ," ).append("\n"); 
		query.append("                               PRI_SP_SCP_GRP_CMDT GC" ).append("\n"); 
		query.append("                       WHERE   MC.CMDT_CD(+)         = RC.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("                       AND     GC.PROP_NO(+)         = RC.PROP_NO" ).append("\n"); 
		query.append("                       AND     GC.AMDT_SEQ(+)        = RC.AMDT_SEQ" ).append("\n"); 
		query.append("                       AND     GC.SVC_SCP_CD(+)      = RC.SVC_SCP_CD" ).append("\n"); 
		query.append("                       AND     GC.PRC_GRP_CMDT_CD(+) = RC.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("                       AND     RC.SRC_INFO_CD        <> 'AD'" ).append("\n"); 
		query.append("                       AND     RC.PROP_NO            = CG.PROP_NO" ).append("\n"); 
		query.append("                       AND     RC.AMDT_SEQ           = CG.AMDT_SEQ" ).append("\n"); 
		query.append("                       AND     RC.SVC_SCP_CD         = CG.SVC_SCP_CD" ).append("\n"); 
		query.append("                       AND     RC.GEN_SPCL_RT_TP_CD  = CG.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                       AND     RC.CMDT_HDR_SEQ       = CG.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                     )" ).append("\n"); 
		query.append("                WHERE       LEVEL       = CNT" ).append("\n"); 
		query.append("                START WITH ROW_NUMBER = 1" ).append("\n"); 
		query.append("                CONNECT BY" ).append("\n"); 
		query.append("                            PROP_NO           = PRIOR PROP_NO" ).append("\n"); 
		query.append("                AND         AMDT_SEQ          = PRIOR AMDT_SEQ" ).append("\n"); 
		query.append("                AND         SVC_SCP_CD        = PRIOR SVC_SCP_CD" ).append("\n"); 
		query.append("                AND         GEN_SPCL_RT_TP_CD = PRIOR GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                AND         CMDT_HDR_SEQ      = PRIOR CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                AND         ROW_NUMBER        = PRIOR ROW_NUMBER + 1" ).append("\n"); 
		query.append("               )   RC  ," ).append("\n"); 
		query.append("               (" ).append("\n"); 
		query.append("                SELECT  PROP_NO            ," ).append("\n"); 
		query.append("                        AMDT_SEQ           ," ).append("\n"); 
		query.append("                        SVC_SCP_CD         ," ).append("\n"); 
		query.append("                        GEN_SPCL_RT_TP_CD  ," ).append("\n"); 
		query.append("                        CMDT_HDR_SEQ       ," ).append("\n"); 
		query.append("                        LTRIM(SYS_CONNECT_BY_PATH(ACT_CUST_NM,'^|^'),'^|^') ACT_CUST_NM" ).append("\n"); 
		query.append("                FROM    (" ).append("\n"); 
		query.append("                          SELECT  /*+ ORDERED */" ).append("\n"); 
		query.append("                                  CG.PROP_NO           ," ).append("\n"); 
		query.append("                                  CG.AMDT_SEQ          ," ).append("\n"); 
		query.append("                                  CG.SVC_SCP_CD        ," ).append("\n"); 
		query.append("                                  CG.GEN_SPCL_RT_TP_CD ," ).append("\n"); 
		query.append("                                  CG.CMDT_HDR_SEQ      ," ).append("\n"); 
		query.append("                                  ROW_NUMBER() OVER ( PARTITION BY CG.PROP_NO, CG.AMDT_SEQ, CG.SVC_SCP_CD, CG.GEN_SPCL_RT_TP_CD, CG.CMDT_HDR_SEQ ORDER BY AC.ACT_CUST_SEQ ) ROW_NUMBER    ," ).append("\n"); 
		query.append("                                  COUNT(1) OVER ( PARTITION BY CG.PROP_NO, CG.AMDT_SEQ, CG.SVC_SCP_CD, CG.GEN_SPCL_RT_TP_CD, CG.CMDT_HDR_SEQ ) CNT    ," ).append("\n"); 
		query.append("                                  MC.CUST_LGL_ENG_NM  ACT_CUST_NM" ).append("\n"); 
		query.append("                          FROM    (" ).append("\n"); 
		query.append("                                    SELECT  DISTINCT" ).append("\n"); 
		query.append("                                            PROP_NO           ," ).append("\n"); 
		query.append("                                            AMDT_SEQ          ," ).append("\n"); 
		query.append("                                            SVC_SCP_CD        ," ).append("\n"); 
		query.append("                                            GEN_SPCL_RT_TP_CD ," ).append("\n"); 
		query.append("                                            CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                                    FROM    CG" ).append("\n"); 
		query.append("                                  )   CG                      ," ).append("\n"); 
		query.append("                                  PRI_SP_SCP_RT_ACT_CUST  AC  ," ).append("\n"); 
		query.append("                                  MDM_CUSTOMER            MC" ).append("\n"); 
		query.append("                          WHERE   MC.CUST_CNT_CD(+)    = AC.CUST_CNT_CD" ).append("\n"); 
		query.append("                          AND     MC.CUST_SEQ(+)       = AC.CUST_SEQ" ).append("\n"); 
		query.append("                          AND     MC.CNTR_DIV_FLG      = 'Y'" ).append("\n"); 
		query.append("                          AND     AC.PROP_NO           = CG.PROP_NO" ).append("\n"); 
		query.append("                          AND     AC.AMDT_SEQ          = CG.AMDT_SEQ" ).append("\n"); 
		query.append("                          AND     AC.SVC_SCP_CD        = CG.SVC_SCP_CD" ).append("\n"); 
		query.append("                          AND     AC.GEN_SPCL_RT_TP_CD = CG.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                          AND     AC.CMDT_HDR_SEQ      = CG.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                          AND     AC.SRC_INFO_CD       <> 'AD'" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("                WHERE       LEVEL       = CNT" ).append("\n"); 
		query.append("                START WITH ROW_NUMBER = 1" ).append("\n"); 
		query.append("                CONNECT BY" ).append("\n"); 
		query.append("                           PROP_NO             = PRIOR PROP_NO" ).append("\n"); 
		query.append("                AND        AMDT_SEQ            = PRIOR AMDT_SEQ" ).append("\n"); 
		query.append("                AND        SVC_SCP_CD          = PRIOR SVC_SCP_CD" ).append("\n"); 
		query.append("                AND        GEN_SPCL_RT_TP_CD   = PRIOR GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                AND        CMDT_HDR_SEQ        = PRIOR CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                AND        ROW_NUMBER          = PRIOR ROW_NUMBER + 1" ).append("\n"); 
		query.append("               )   AC  ," ).append("\n"); 
		query.append("               (" ).append("\n"); 
		query.append("                SELECT  PROP_NO           ," ).append("\n"); 
		query.append("                        AMDT_SEQ          ," ).append("\n"); 
		query.append("                        SVC_SCP_CD        ," ).append("\n"); 
		query.append("                        GEN_SPCL_RT_TP_CD ," ).append("\n"); 
		query.append("                        CMDT_HDR_SEQ      ," ).append("\n"); 
		query.append("                        ROUT_SEQ          ," ).append("\n"); 
		query.append("                        --LTRIM(SYS_CONNECT_BY_PATH(ORG_NM,'^|^ '),'^|^ ') ORG_NM" ).append("\n"); 
		query.append("                        --LTRIM(SYS_CONNECT_BY_PATH(ORG_CD,'^|^ '),'^|^ ') ORG_CD" ).append("\n"); 
		query.append("                        LTRIM(SYS_CONNECT_BY_PATH(ORG_CD || NVL2(RCV_DE_TERM_NM, '(' || RCV_DE_TERM_NM || ')', ''),'^|^ '),'^|^ ') ORG_CD" ).append("\n"); 
		query.append("                FROM    (" ).append("\n"); 
		query.append("                          SELECT  /*+ ORDERED */" ).append("\n"); 
		query.append("                                  CG.PROP_NO           ," ).append("\n"); 
		query.append("                                  CG.AMDT_SEQ          ," ).append("\n"); 
		query.append("                                  CG.SVC_SCP_CD        ," ).append("\n"); 
		query.append("                                  CG.GEN_SPCL_RT_TP_CD ," ).append("\n"); 
		query.append("                                  CG.CMDT_HDR_SEQ      ," ).append("\n"); 
		query.append("                                  CG.ROUT_SEQ          ," ).append("\n"); 
		query.append("                                  ROW_NUMBER() OVER ( PARTITION BY CG.PROP_NO, CG.AMDT_SEQ, CG.SVC_SCP_CD, CG.GEN_SPCL_RT_TP_CD, CG.CMDT_HDR_SEQ, CG.ROUT_SEQ ORDER BY OP.ROUT_PNT_SEQ ) ROW_NUMBER   ," ).append("\n"); 
		query.append("                                  COUNT(1) OVER ( PARTITION BY CG.PROP_NO, CG.AMDT_SEQ, CG.SVC_SCP_CD, CG.GEN_SPCL_RT_TP_CD, CG.CMDT_HDR_SEQ, CG.ROUT_SEQ ) CNT   ," ).append("\n"); 
		query.append("                                  --DECODE(OP.ROUT_PNT_LOC_TP_CD, 'L', ML.LOC_NM, 'G', GL.PRC_GRP_LOC_DESC) ORG_NM" ).append("\n"); 
		query.append("                                  OP.ROUT_PNT_LOC_DEF_CD ORG_CD" ).append("\n"); 
		query.append("                                 --,OP.RCV_DE_TERM_CD" ).append("\n"); 
		query.append("                                 ,(SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("                                     FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("                                    WHERE INTG_CD_ID = 'CD02138'" ).append("\n"); 
		query.append("                                      AND INTG_CD_VAL_CTNT = OP.RCV_DE_TERM_CD" ).append("\n"); 
		query.append("                                      AND ROWNUM = 1) AS RCV_DE_TERM_NM                                                                    " ).append("\n"); 
		query.append("                          FROM    (" ).append("\n"); 
		query.append("                                    SELECT  DISTINCT" ).append("\n"); 
		query.append("                                            PROP_NO            ," ).append("\n"); 
		query.append("                                            AMDT_SEQ           ," ).append("\n"); 
		query.append("                                            SVC_SCP_CD         ," ).append("\n"); 
		query.append("                                            GEN_SPCL_RT_TP_CD  ," ).append("\n"); 
		query.append("                                            CMDT_HDR_SEQ       ," ).append("\n"); 
		query.append("                                            ROUT_SEQ" ).append("\n"); 
		query.append("                                    FROM    CG" ).append("\n"); 
		query.append("                                  )   CG                      ," ).append("\n"); 
		query.append("                                  PRI_SP_SCP_RT_ROUT_PNT  OP  --," ).append("\n"); 
		query.append("                                  --MDM_LOCATION            ML  ," ).append("\n"); 
		query.append("                                  --PRI_SP_SCP_GRP_LOC      GL" ).append("\n"); 
		query.append("                          WHERE   --ML.LOC_CD(+)         = OP.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("                          --AND     GL.PROP_NO(+)        = OP.PROP_NO" ).append("\n"); 
		query.append("                          --AND     GL.AMDT_SEQ(+)       = OP.AMDT_SEQ" ).append("\n"); 
		query.append("                          --AND     GL.SVC_SCP_CD(+)     = OP.SVC_SCP_CD" ).append("\n"); 
		query.append("                          --AND     GL.PRC_GRP_LOC_CD(+) = OP.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("                                    OP.PROP_NO           = CG.PROP_NO" ).append("\n"); 
		query.append("                          AND     OP.AMDT_SEQ          = CG.AMDT_SEQ" ).append("\n"); 
		query.append("                          AND     OP.SVC_SCP_CD        = CG.SVC_SCP_CD" ).append("\n"); 
		query.append("                          AND     OP.GEN_SPCL_RT_TP_CD = CG.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                          AND     OP.CMDT_HDR_SEQ      = CG.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                          AND     OP.ROUT_SEQ          = CG.ROUT_SEQ" ).append("\n"); 
		query.append("                          AND     OP.ORG_DEST_TP_CD    = 'O'" ).append("\n"); 
		query.append("                          AND     OP.SRC_INFO_CD       <> 'AD'" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("                WHERE       LEVEL       = CNT" ).append("\n"); 
		query.append("                START WITH ROW_NUMBER = 1" ).append("\n"); 
		query.append("                CONNECT BY" ).append("\n"); 
		query.append("                            PROP_NO           = PRIOR PROP_NO" ).append("\n"); 
		query.append("                AND         AMDT_SEQ          = PRIOR AMDT_SEQ" ).append("\n"); 
		query.append("                AND         SVC_SCP_CD        = PRIOR SVC_SCP_CD" ).append("\n"); 
		query.append("                AND         GEN_SPCL_RT_TP_CD = PRIOR GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                AND         CMDT_HDR_SEQ      = PRIOR CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                AND         ROUT_SEQ          = PRIOR ROUT_SEQ" ).append("\n"); 
		query.append("                AND         ROW_NUMBER        = PRIOR ROW_NUMBER + 1" ).append("\n"); 
		query.append("               )   OP  ," ).append("\n"); 
		query.append("               (" ).append("\n"); 
		query.append("                SELECT  PROP_NO           ," ).append("\n"); 
		query.append("                        AMDT_SEQ          ," ).append("\n"); 
		query.append("                        SVC_SCP_CD        ," ).append("\n"); 
		query.append("                        GEN_SPCL_RT_TP_CD ," ).append("\n"); 
		query.append("                        CMDT_HDR_SEQ      ," ).append("\n"); 
		query.append("                        ROUT_SEQ          ," ).append("\n"); 
		query.append("                        --LTRIM(SYS_CONNECT_BY_PATH(ORG_VIA_NM,'^|^ '),'^|^ ') ORG_VIA_NM" ).append("\n"); 
		query.append("						LTRIM(SYS_CONNECT_BY_PATH(ORG_VIA_CD,'^|^ '),'^|^ ') ORG_VIA_CD" ).append("\n"); 
		query.append("                FROM    (" ).append("\n"); 
		query.append("                          SELECT  /*+ ORDERED */" ).append("\n"); 
		query.append("                                  CG.PROP_NO           ," ).append("\n"); 
		query.append("                                  CG.AMDT_SEQ          ," ).append("\n"); 
		query.append("                                  CG.SVC_SCP_CD        ," ).append("\n"); 
		query.append("                                  CG.GEN_SPCL_RT_TP_CD ," ).append("\n"); 
		query.append("                                  CG.CMDT_HDR_SEQ      ," ).append("\n"); 
		query.append("                                  CG.ROUT_SEQ          ," ).append("\n"); 
		query.append("                                  ROW_NUMBER() OVER ( PARTITION BY CG.PROP_NO, CG.AMDT_SEQ, CG.SVC_SCP_CD, CG.GEN_SPCL_RT_TP_CD, CG.CMDT_HDR_SEQ, CG.ROUT_SEQ ORDER BY OV.ROUT_VIA_SEQ ) ROW_NUMBER   ," ).append("\n"); 
		query.append("                                  COUNT(1) OVER ( PARTITION BY CG.PROP_NO, CG.AMDT_SEQ, CG.SVC_SCP_CD, CG.GEN_SPCL_RT_TP_CD, CG.CMDT_HDR_SEQ, CG.ROUT_SEQ ) CNT   ," ).append("\n"); 
		query.append("                                  --DECODE(OV.ROUT_VIA_PORT_TP_CD, 'L', ML.LOC_NM, 'G', GL.PRC_GRP_LOC_DESC) ORG_VIA_NM" ).append("\n"); 
		query.append("								  OV.ROUT_VIA_PORT_DEF_CD AS ORG_VIA_CD" ).append("\n"); 
		query.append("                          FROM    (" ).append("\n"); 
		query.append("                                    SELECT  DISTINCT" ).append("\n"); 
		query.append("                                            PROP_NO           ," ).append("\n"); 
		query.append("                                            AMDT_SEQ          ," ).append("\n"); 
		query.append("                                            SVC_SCP_CD        ," ).append("\n"); 
		query.append("                                            GEN_SPCL_RT_TP_CD ," ).append("\n"); 
		query.append("                                            CMDT_HDR_SEQ      ," ).append("\n"); 
		query.append("                                            ROUT_SEQ" ).append("\n"); 
		query.append("                                    FROM    CG" ).append("\n"); 
		query.append("                                  )   CG                      ," ).append("\n"); 
		query.append("                                  PRI_SP_SCP_RT_ROUT_VIA  OV  --," ).append("\n"); 
		query.append("                                  --MDM_LOCATION            ML  ," ).append("\n"); 
		query.append("                                  --PRI_SP_SCP_GRP_LOC      GL" ).append("\n"); 
		query.append("                          WHERE   --ML.LOC_CD(+)         = OV.ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("                          --AND     GL.PROP_NO(+)        = OV.PROP_NO" ).append("\n"); 
		query.append("                          --AND     GL.AMDT_SEQ(+)       = OV.AMDT_SEQ" ).append("\n"); 
		query.append("                          --AND     GL.SVC_SCP_CD(+)     = OV.SVC_SCP_CD" ).append("\n"); 
		query.append("                          --AND     GL.PRC_GRP_LOC_CD(+) = OV.ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("                                  OV.PROP_NO           = CG.PROP_NO" ).append("\n"); 
		query.append("                          AND     OV.AMDT_SEQ          = CG.AMDT_SEQ" ).append("\n"); 
		query.append("                          AND     OV.SVC_SCP_CD        = CG.SVC_SCP_CD" ).append("\n"); 
		query.append("                          AND     OV.GEN_SPCL_RT_TP_CD = CG.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                          AND     OV.CMDT_HDR_SEQ      = CG.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                          AND     OV.ROUT_SEQ          = CG.ROUT_SEQ" ).append("\n"); 
		query.append("                          AND     OV.ORG_DEST_TP_CD    = 'O'" ).append("\n"); 
		query.append("                          AND     OV.SRC_INFO_CD       <> 'AD'" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("                WHERE       LEVEL       = CNT" ).append("\n"); 
		query.append("                START WITH ROW_NUMBER = 1" ).append("\n"); 
		query.append("                CONNECT BY" ).append("\n"); 
		query.append("                           PROP_NO           = PRIOR PROP_NO" ).append("\n"); 
		query.append("                AND        AMDT_SEQ          = PRIOR AMDT_SEQ" ).append("\n"); 
		query.append("                AND        SVC_SCP_CD        = PRIOR SVC_SCP_CD" ).append("\n"); 
		query.append("                AND        GEN_SPCL_RT_TP_CD = PRIOR GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                AND        CMDT_HDR_SEQ      = PRIOR CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                AND        ROUT_SEQ          = PRIOR ROUT_SEQ" ).append("\n"); 
		query.append("                AND        ROW_NUMBER        = PRIOR ROW_NUMBER + 1" ).append("\n"); 
		query.append("               )   OV  ," ).append("\n"); 
		query.append("               (" ).append("\n"); 
		query.append("                SELECT  PROP_NO           ," ).append("\n"); 
		query.append("                        AMDT_SEQ          ," ).append("\n"); 
		query.append("                        SVC_SCP_CD        ," ).append("\n"); 
		query.append("                        GEN_SPCL_RT_TP_CD ," ).append("\n"); 
		query.append("                        CMDT_HDR_SEQ      ," ).append("\n"); 
		query.append("                        ROUT_SEQ          ," ).append("\n"); 
		query.append("                        --LTRIM(SYS_CONNECT_BY_PATH(DEST_VIA_NM,'^|^ '),'^|^ ') DEST_VIA_NM" ).append("\n"); 
		query.append("					    LTRIM(SYS_CONNECT_BY_PATH(DEST_VIA_CD,'^|^ '),'^|^ ') DEST_VIA_CD" ).append("\n"); 
		query.append("                FROM    (" ).append("\n"); 
		query.append("                          SELECT  /*+ ORDERED */" ).append("\n"); 
		query.append("                                  CG.PROP_NO           ," ).append("\n"); 
		query.append("                                  CG.AMDT_SEQ          ," ).append("\n"); 
		query.append("                                  CG.SVC_SCP_CD        ," ).append("\n"); 
		query.append("                                  CG.GEN_SPCL_RT_TP_CD ," ).append("\n"); 
		query.append("                                  CG.CMDT_HDR_SEQ      ," ).append("\n"); 
		query.append("                                  CG.ROUT_SEQ          ," ).append("\n"); 
		query.append("                                  ROW_NUMBER() OVER ( PARTITION BY CG.PROP_NO, CG.AMDT_SEQ, CG.SVC_SCP_CD, CG.GEN_SPCL_RT_TP_CD, CG.CMDT_HDR_SEQ, CG.ROUT_SEQ ORDER BY DV.ROUT_VIA_SEQ ) ROW_NUMBER   ," ).append("\n"); 
		query.append("                                  COUNT(1) OVER ( PARTITION BY CG.PROP_NO, CG.AMDT_SEQ, CG.SVC_SCP_CD, CG.GEN_SPCL_RT_TP_CD, CG.CMDT_HDR_SEQ, CG.ROUT_SEQ ) CNT   ," ).append("\n"); 
		query.append("                                  --DECODE(DV.ROUT_VIA_PORT_TP_CD, 'L', ML.LOC_NM, 'G', GL.PRC_GRP_LOC_DESC) DEST_VIA_NM" ).append("\n"); 
		query.append("								  DV.ROUT_VIA_PORT_DEF_CD AS DEST_VIA_CD" ).append("\n"); 
		query.append("                          FROM    (" ).append("\n"); 
		query.append("                                    SELECT  DISTINCT" ).append("\n"); 
		query.append("                                            PROP_NO           ," ).append("\n"); 
		query.append("                                            AMDT_SEQ          ," ).append("\n"); 
		query.append("                                            SVC_SCP_CD        ," ).append("\n"); 
		query.append("                                            GEN_SPCL_RT_TP_CD ," ).append("\n"); 
		query.append("                                            CMDT_HDR_SEQ      ," ).append("\n"); 
		query.append("                                            ROUT_SEQ" ).append("\n"); 
		query.append("                                    FROM    CG" ).append("\n"); 
		query.append("                                  )   CG                      ," ).append("\n"); 
		query.append("                                  PRI_SP_SCP_RT_ROUT_VIA  DV  --," ).append("\n"); 
		query.append("                                  --MDM_LOCATION            ML  ," ).append("\n"); 
		query.append("                                  --PRI_SP_SCP_GRP_LOC      GL" ).append("\n"); 
		query.append("                          WHERE   --ML.LOC_CD(+)         = DV.ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("                          --AND     GL.PROP_NO(+)        = DV.PROP_NO" ).append("\n"); 
		query.append("                          --AND     GL.AMDT_SEQ(+)       = DV.AMDT_SEQ" ).append("\n"); 
		query.append("                          --AND     GL.SVC_SCP_CD(+)     = DV.SVC_SCP_CD" ).append("\n"); 
		query.append("                          --AND     GL.PRC_GRP_LOC_CD(+) = DV.ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("                                  DV.PROP_NO           = CG.PROP_NO" ).append("\n"); 
		query.append("                          AND     DV.AMDT_SEQ          = CG.AMDT_SEQ" ).append("\n"); 
		query.append("                          AND     DV.SVC_SCP_CD        = CG.SVC_SCP_CD" ).append("\n"); 
		query.append("                          AND     DV.GEN_SPCL_RT_TP_CD = CG.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                          AND     DV.CMDT_HDR_SEQ      = CG.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                          AND     DV.ROUT_SEQ          = CG.ROUT_SEQ" ).append("\n"); 
		query.append("                          AND     DV.ORG_DEST_TP_CD    = 'D'" ).append("\n"); 
		query.append("                          AND     DV.SRC_INFO_CD       <> 'AD'" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("                WHERE       LEVEL       = CNT" ).append("\n"); 
		query.append("                START WITH ROW_NUMBER = 1" ).append("\n"); 
		query.append("                CONNECT BY" ).append("\n"); 
		query.append("                            PROP_NO                     = PRIOR PROP_NO" ).append("\n"); 
		query.append("                AND         AMDT_SEQ                    = PRIOR AMDT_SEQ" ).append("\n"); 
		query.append("                AND         SVC_SCP_CD              = PRIOR SVC_SCP_CD" ).append("\n"); 
		query.append("                AND         GEN_SPCL_RT_TP_CD   = PRIOR GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                AND         CMDT_HDR_SEQ            = PRIOR CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                AND         ROUT_SEQ                    = PRIOR ROUT_SEQ" ).append("\n"); 
		query.append("                AND         ROW_NUMBER              = PRIOR ROW_NUMBER + 1" ).append("\n"); 
		query.append("               )   DV  ," ).append("\n"); 
		query.append("               (" ).append("\n"); 
		query.append("                SELECT  PROP_NO           ," ).append("\n"); 
		query.append("                        AMDT_SEQ          ," ).append("\n"); 
		query.append("                        SVC_SCP_CD        ," ).append("\n"); 
		query.append("                        GEN_SPCL_RT_TP_CD ," ).append("\n"); 
		query.append("                        CMDT_HDR_SEQ      ," ).append("\n"); 
		query.append("                        ROUT_SEQ          ," ).append("\n"); 
		query.append("                        --LTRIM(SYS_CONNECT_BY_PATH(DEST_NM,'^|^ '),'^|^ ') DEST_NM" ).append("\n"); 
		query.append("                        --LTRIM(SYS_CONNECT_BY_PATH(DEST_CD,'^|^ '),'^|^ ') DEST_CD" ).append("\n"); 
		query.append("                        LTRIM(SYS_CONNECT_BY_PATH(DEST_CD || NVL2(RCV_DE_TERM_NM, '(' || RCV_DE_TERM_NM || ')', ''),'^|^ '),'^|^ ') DEST_CD" ).append("\n"); 
		query.append("                FROM    (" ).append("\n"); 
		query.append("                          SELECT  /*+ ORDERED */" ).append("\n"); 
		query.append("                                  CG.PROP_NO           ," ).append("\n"); 
		query.append("                                  CG.AMDT_SEQ          ," ).append("\n"); 
		query.append("                                  CG.SVC_SCP_CD        ," ).append("\n"); 
		query.append("                                  CG.GEN_SPCL_RT_TP_CD ," ).append("\n"); 
		query.append("                                  CG.CMDT_HDR_SEQ      ," ).append("\n"); 
		query.append("                                  CG.ROUT_SEQ          ," ).append("\n"); 
		query.append("                                  ROW_NUMBER() OVER ( PARTITION BY CG.PROP_NO, CG.AMDT_SEQ, CG.SVC_SCP_CD, CG.GEN_SPCL_RT_TP_CD, CG.CMDT_HDR_SEQ, CG.ROUT_SEQ ORDER BY DP.ROUT_PNT_SEQ ) ROW_NUMBER   ," ).append("\n"); 
		query.append("                                  COUNT(1) OVER ( PARTITION BY CG.PROP_NO, CG.AMDT_SEQ, CG.SVC_SCP_CD, CG.GEN_SPCL_RT_TP_CD, CG.CMDT_HDR_SEQ, CG.ROUT_SEQ ) CNT   ," ).append("\n"); 
		query.append("                                  --DECODE(DP.ROUT_PNT_LOC_TP_CD, 'L', ML.LOC_NM, 'G', GL.PRC_GRP_LOC_DESC) DEST_NM" ).append("\n"); 
		query.append("								  DP.ROUT_PNT_LOC_DEF_CD AS DEST_CD" ).append("\n"); 
		query.append("                                 --,DP.RCV_DE_TERM_CD" ).append("\n"); 
		query.append("                                 ,(SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("                                     FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("                                    WHERE INTG_CD_ID = 'CD02139'" ).append("\n"); 
		query.append("                                      AND INTG_CD_VAL_CTNT = DP.RCV_DE_TERM_CD" ).append("\n"); 
		query.append("                                      AND ROWNUM = 1) AS RCV_DE_TERM_NM" ).append("\n"); 
		query.append("                          FROM    (" ).append("\n"); 
		query.append("                                    SELECT  DISTINCT" ).append("\n"); 
		query.append("                                            PROP_NO           ," ).append("\n"); 
		query.append("                                            AMDT_SEQ          ," ).append("\n"); 
		query.append("                                            SVC_SCP_CD        ," ).append("\n"); 
		query.append("                                            GEN_SPCL_RT_TP_CD ," ).append("\n"); 
		query.append("                                            CMDT_HDR_SEQ      ," ).append("\n"); 
		query.append("                                            ROUT_SEQ" ).append("\n"); 
		query.append("                                    FROM    CG" ).append("\n"); 
		query.append("                                   )   CG                      ," ).append("\n"); 
		query.append("                                   PRI_SP_SCP_RT_ROUT_PNT  DP  --," ).append("\n"); 
		query.append("                                   --MDM_LOCATION            ML  ," ).append("\n"); 
		query.append("                                   --PRI_SP_SCP_GRP_LOC      GL" ).append("\n"); 
		query.append("                          WHERE    --ML.LOC_CD(+)         = DP.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("                          --AND      GL.PROP_NO(+)        = DP.PROP_NO" ).append("\n"); 
		query.append("                          --AND      GL.AMDT_SEQ(+)       = DP.AMDT_SEQ" ).append("\n"); 
		query.append("                          --AND      GL.SVC_SCP_CD(+)     = DP.SVC_SCP_CD" ).append("\n"); 
		query.append("                          --AND      GL.PRC_GRP_LOC_CD(+) = DP.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("                                   DP.PROP_NO           = CG.PROP_NO" ).append("\n"); 
		query.append("                          AND      DP.AMDT_SEQ          = CG.AMDT_SEQ" ).append("\n"); 
		query.append("                          AND      DP.SVC_SCP_CD        = CG.SVC_SCP_CD" ).append("\n"); 
		query.append("                          AND      DP.GEN_SPCL_RT_TP_CD = CG.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                          AND      DP.CMDT_HDR_SEQ      = CG.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                          AND      DP.ROUT_SEQ          = CG.ROUT_SEQ" ).append("\n"); 
		query.append("                          AND      DP.ORG_DEST_TP_CD    = 'D'" ).append("\n"); 
		query.append("                          AND      DP.SRC_INFO_CD       <> 'AD'" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("                WHERE       LEVEL       = CNT" ).append("\n"); 
		query.append("                START WITH ROW_NUMBER = 1" ).append("\n"); 
		query.append("                CONNECT BY" ).append("\n"); 
		query.append("                            PROP_NO           = PRIOR PROP_NO" ).append("\n"); 
		query.append("                AND         AMDT_SEQ          = PRIOR AMDT_SEQ" ).append("\n"); 
		query.append("                AND         SVC_SCP_CD        = PRIOR SVC_SCP_CD" ).append("\n"); 
		query.append("                AND         GEN_SPCL_RT_TP_CD = PRIOR GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                AND         CMDT_HDR_SEQ      = PRIOR CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                AND         ROUT_SEQ          = PRIOR ROUT_SEQ" ).append("\n"); 
		query.append("                AND         ROW_NUMBER        = PRIOR ROW_NUMBER + 1" ).append("\n"); 
		query.append("              )   DP" ).append("\n"); 
		query.append("    WHERE    CP.PROP_NO              = CG.PROP_NO" ).append("\n"); 
		query.append("    AND      CP.AMDT_SEQ             = CG.AMDT_SEQ" ).append("\n"); 
		query.append("    AND      CP.PRC_CTRT_PTY_TP_CD   = 'C'" ).append("\n"); 
		query.append("    AND      SQ.PROP_NO              = CG.PROP_NO" ).append("\n"); 
		query.append("    AND      SQ.AMDT_SEQ             = CG.AMDT_SEQ" ).append("\n"); 
		query.append("    AND      SQ.SVC_SCP_CD           = CG.SVC_SCP_CD" ).append("\n"); 
		query.append("    AND      RC.PROP_NO(+)           = CG.PROP_NO" ).append("\n"); 
		query.append("    AND      RC.AMDT_SEQ(+)          = CG.AMDT_SEQ" ).append("\n"); 
		query.append("    AND      RC.SVC_SCP_CD(+)        = CG.SVC_SCP_CD" ).append("\n"); 
		query.append("    AND      RC.GEN_SPCL_RT_TP_CD(+) = CG.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("    AND      RC.CMDT_HDR_SEQ(+)      = CG.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("    AND      AC.PROP_NO(+)           = CG.PROP_NO" ).append("\n"); 
		query.append("    AND      AC.AMDT_SEQ(+)          = CG.AMDT_SEQ" ).append("\n"); 
		query.append("    AND      AC.SVC_SCP_CD(+)        = CG.SVC_SCP_CD" ).append("\n"); 
		query.append("    AND      AC.GEN_SPCL_RT_TP_CD(+) = CG.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("    AND      AC.CMDT_HDR_SEQ(+)      = CG.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("    AND      OP.PROP_NO(+)           = CG.PROP_NO" ).append("\n"); 
		query.append("    AND      OP.AMDT_SEQ(+)          = CG.AMDT_SEQ" ).append("\n"); 
		query.append("    AND      OP.SVC_SCP_CD(+)        = CG.SVC_SCP_CD" ).append("\n"); 
		query.append("    AND      OP.GEN_SPCL_RT_TP_CD(+) = CG.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("    AND      OP.CMDT_HDR_SEQ(+)      = CG.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("    AND      OP.ROUT_SEQ(+)          = CG.ROUT_SEQ" ).append("\n"); 
		query.append("    AND      OV.PROP_NO(+)           = CG.PROP_NO" ).append("\n"); 
		query.append("    AND      OV.AMDT_SEQ(+)          = CG.AMDT_SEQ" ).append("\n"); 
		query.append("    AND      OV.SVC_SCP_CD(+)        = CG.SVC_SCP_CD" ).append("\n"); 
		query.append("    AND      OV.GEN_SPCL_RT_TP_CD(+) = CG.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("    AND      OV.CMDT_HDR_SEQ(+)      = CG.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("    AND      OV.ROUT_SEQ(+)          = CG.ROUT_SEQ" ).append("\n"); 
		query.append("    AND      DV.PROP_NO(+)           = CG.PROP_NO" ).append("\n"); 
		query.append("    AND      DV.AMDT_SEQ(+)          = CG.AMDT_SEQ" ).append("\n"); 
		query.append("    AND      DV.SVC_SCP_CD(+)        = CG.SVC_SCP_CD" ).append("\n"); 
		query.append("    AND      DV.GEN_SPCL_RT_TP_CD(+) = CG.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("    AND      DV.CMDT_HDR_SEQ(+)      = CG.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("    AND      DV.ROUT_SEQ(+)          = CG.ROUT_SEQ" ).append("\n"); 
		query.append("    AND      DP.PROP_NO(+)           = CG.PROP_NO" ).append("\n"); 
		query.append("    AND      DP.AMDT_SEQ(+)          = CG.AMDT_SEQ" ).append("\n"); 
		query.append("    AND      DP.SVC_SCP_CD(+)        = CG.SVC_SCP_CD" ).append("\n"); 
		query.append("    AND      DP.GEN_SPCL_RT_TP_CD(+) = CG.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("    AND      DP.CMDT_HDR_SEQ(+)      = CG.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("    AND      DP.ROUT_SEQ(+)          = CG.ROUT_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT  T_SC.SC_NO               ," ).append("\n"); 
		query.append("        T_SC.PROP_NO             ," ).append("\n"); 
		query.append("        T_SC.CTRT_PTY_NM         ," ).append("\n"); 
		query.append("        T_SC.FNL_MQC_QTY         ," ).append("\n"); 
		query.append("        T_SC.PROP_SCP_OFC_CD     , -- 추가" ).append("\n"); 
		query.append("        T_SC.PROP_SCP_SREP_CD    , -- 추가" ).append("\n"); 
		query.append("        T_SC.AMDT_SEQ            ," ).append("\n"); 
		query.append("        T_SC.SVC_SCP_CD          ," ).append("\n"); 
		query.append("        T_SC.GEN_SPCL_RT_TP_CD   ," ).append("\n"); 
		query.append("        T_SC.CMDT_HDR_SEQ        , -- 추가" ).append("\n"); 
		query.append("        T_SC.ROUT_SEQ            , -- 추가" ).append("\n"); 
		query.append("        T_SC.RT_SEQ              , -- 추가" ).append("\n"); 
		query.append("        T_SC.CMDT_NM             ," ).append("\n"); 
		query.append("        T_SC.ACT_CUST_NM         ," ).append("\n"); 
		query.append("        --REPLACE(ORG_NM     , '^|^', ';') AS ORG_NM      ," ).append("\n"); 
		query.append("        REPLACE(T_SC.ORG_CD     , '^|^', ';') AS ORG_CD      ," ).append("\n"); 
		query.append("        --REPLACE(ORG_VIA_NM , '^|^', ';') AS ORG_VIA_NM  ," ).append("\n"); 
		query.append("		REPLACE(T_SC.ORG_VIA_CD , '^|^', ';') AS ORG_VIA_CD  ," ).append("\n"); 
		query.append("        --REPLACE(DEST_VIA_NM, '^|^', ';') AS DEST_VIA_NM ," ).append("\n"); 
		query.append("		REPLACE(T_SC.DEST_VIA_CD, '^|^', ';') AS DEST_VIA_CD ," ).append("\n"); 
		query.append("        --REPLACE(DEST_NM    , '^|^', ';') AS DEST_NM     ," ).append("\n"); 
		query.append("		REPLACE(T_SC.DEST_CD    , '^|^', ';') AS DEST_CD     ," ).append("\n"); 
		query.append("        T_SC.CHG_CD              ," ).append("\n"); 
		query.append("        T_SC.RAT_UT_CD           ," ).append("\n"); 
		query.append("        T_SC.PRC_CGO_TP_CD       ," ).append("\n"); 
		query.append("        T_SC.CURR_CD             ," ).append("\n"); 
		query.append("        T_SC.FNL_FRT_RT_AMT      ," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		(SELECT  CASE WHEN COUNT(T.NOTE_CTNT) > 0 THEN 'Y' ELSE 'N' END" ).append("\n"); 
		query.append("                FROM    PRI_SP_SCP_RT_CNOTE T" ).append("\n"); 
		query.append("                WHERE   T.PROP_NO            = T_SC.PROP_NO" ).append("\n"); 
		query.append("                AND     T.AMDT_SEQ           = T_SC.AMDT_SEQ" ).append("\n"); 
		query.append("                AND     T.SVC_SCP_CD         = T_SC.SVC_SCP_CD" ).append("\n"); 
		query.append("                AND     T.GEN_SPCL_RT_TP_CD  = T_SC.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                AND     T.CMDT_HDR_SEQ       = T_SC.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                AND     T.SRC_INFO_CD        <> 'AD'" ).append("\n"); 
		query.append("                AND     T.NOTE_CTNT IS NOT NULL" ).append("\n"); 
		query.append("        ) AS CNOTE_FLAG," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        (SELECT  CASE WHEN COUNT(T.NOTE_CTNT) > 0 THEN 'Y' ELSE 'N' END" ).append("\n"); 
		query.append("                FROM    PRI_SP_SCP_RT_CMDT_RNOTE T" ).append("\n"); 
		query.append("                WHERE   T.PROP_NO            = T_SC.PROP_NO" ).append("\n"); 
		query.append("                AND     T.AMDT_SEQ           = T_SC.AMDT_SEQ" ).append("\n"); 
		query.append("                AND     T.SVC_SCP_CD         = T_SC.SVC_SCP_CD" ).append("\n"); 
		query.append("                AND     T.GEN_SPCL_RT_TP_CD  = T_SC.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                AND     T.CMDT_HDR_SEQ       = T_SC.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                AND     T.ROUT_SEQ           = T_SC.ROUT_SEQ" ).append("\n"); 
		query.append("                AND     T.SRC_INFO_CD        <> 'AD'" ).append("\n"); 
		query.append("        ) AS RNOTE_FLAG," ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        (SELECT CASE WHEN COUNT(SNDO.NOTE_CTNT) > 0 THEN 'Y' ELSE 'N' END" ).append("\n"); 
		query.append("                FROM PRI_SP_SCP_NOTE SNO, PRI_SP_SCP_NOTE_CTNT SNDO" ).append("\n"); 
		query.append("                WHERE SNO.PROP_NO = SNDO.PROP_NO" ).append("\n"); 
		query.append("                AND SNO.AMDT_SEQ = SNDO.AMDT_SEQ" ).append("\n"); 
		query.append("                AND SNO.SVC_SCP_CD = SNDO.SVC_SCP_CD" ).append("\n"); 
		query.append("                AND SNO.NOTE_TP_CD = SNDO.NOTE_TP_CD" ).append("\n"); 
		query.append("                AND SNO.NOTE_SEQ = SNDO.NOTE_SEQ" ).append("\n"); 
		query.append("                AND SNO.NOTE_TP_CD = 'P' --Special Note" ).append("\n"); 
		query.append("                AND SNO.NOTE_CLSS_CD <> 'D' --O:Surcharge Exceptions S:Fixed Surcharge D:DEM/DET" ).append("\n"); 
		query.append("                AND SNDO.SRC_INFO_CD <> 'AD' --DELETE" ).append("\n"); 
		query.append("                AND SNO.PROP_NO = T_SC.PROP_NO" ).append("\n"); 
		query.append("                AND SNO.AMDT_SEQ = T_SC.AMDT_SEQ" ).append("\n"); 
		query.append("                AND SNO.SVC_SCP_CD = T_SC.SVC_SCP_CD" ).append("\n"); 
		query.append("        ) AS SNOTE_FLAG," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        '' AS EFF_DT                    , -- param" ).append("\n"); 
		query.append("        '' AS EXP_DT                    , -- param" ).append("\n"); 
		query.append("        '' AS ROUT_PNT_LOC_DEF_CD_ORI   , -- param" ).append("\n"); 
		query.append("        '' AS ROUT_PNT_LOC_DEF_CD_DEST  , -- param" ).append("\n"); 
		query.append("        '' AS ROUT_VIA_PORT_DEF_CD_ORI  , -- param" ).append("\n"); 
		query.append("        '' AS ROUT_VIA_PORT_DEF_CD_DEST , -- param" ).append("\n"); 
		query.append("        '' AS PRC_CTRT_CUST_TP_CD       , -- param" ).append("\n"); 
		query.append("        '' AS PRC_CMDT_DEF_CD           , -- param" ).append("\n"); 
		query.append("        '' AS FNL_FRT_RT                , -- param" ).append("\n"); 
		query.append("        '' AS FNL_MQC                     -- param" ).append("\n"); 
		query.append("FROM        SC T_SC" ).append("\n"); 
		query.append("WHERE   1 = 1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cmdt_nm} != '')" ).append("\n"); 
		query.append("AND      CMDT_NM         = @[cmdt_nm] -- Commodity Group" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${act_cust_nm} != '')" ).append("\n"); 
		query.append("AND      ACT_CUST_NM     = @[act_cust_nm] -- Actual Customer" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("         SC_NO," ).append("\n"); 
		query.append("         AMDT_SEQ DESC," ).append("\n"); 
		query.append("         SVC_SCP_CD," ).append("\n"); 
		query.append("         GEN_SPCL_RT_TP_CD," ).append("\n"); 
		query.append("         BLET_DP_SEQ," ).append("\n"); 
		query.append("         --ORG_NM," ).append("\n"); 
		query.append("         --ORG_VIA_NM," ).append("\n"); 
		query.append("         --DEST_VIA_NM," ).append("\n"); 
		query.append("         --DEST_NM," ).append("\n"); 
		query.append("         RAT_UT_CD," ).append("\n"); 
		query.append("         PRC_CGO_TP_CD" ).append("\n"); 

	}
}