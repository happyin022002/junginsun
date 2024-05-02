/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SCRateProposalDBDAORsltPriCostSimulationCheckRouteVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.23
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2010.03.23 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG MIN SEOK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCRateProposalDBDAORsltPriCostSimulationCheckRouteVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *   Pre CM/OP Simulation화면에서 입력한 POL,POD 가 정확한지 점사한다.
	  * </pre>
	  */
	public SCRateProposalDBDAORsltPriCostSimulationCheckRouteVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_de_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_hdr_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("gen_spcl_rt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rout_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_rcv_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.integration").append("\n"); 
		query.append("FileName : SCRateProposalDBDAORsltPriCostSimulationCheckRouteVORSQL").append("\n"); 
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
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT ORI.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("    ,ORI.RCV_DE_TERM_CD" ).append("\n"); 
		query.append("    ,ORI.PROP_NO" ).append("\n"); 
		query.append("    ,ORI.AMDT_SEQ" ).append("\n"); 
		query.append("    ,ORI.SVC_SCP_CD" ).append("\n"); 
		query.append("    ,ORI.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("    ,ORI.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("    ,ORI.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("    ,ORI.ROUT_SEQ" ).append("\n"); 
		query.append("FROM (    " ).append("\n"); 
		query.append("	SELECT GRP_DTL.LOC_CD AS ROUT_PNT_LOC_DEF_CD, NVL(PNT.RCV_DE_TERM_CD,'Y') AS RCV_DE_TERM_CD" ).append("\n"); 
		query.append("		, PNT.PROP_NO, PNT.AMDT_SEQ, PNT.SVC_SCP_CD, PNT.GEN_SPCL_RT_TP_CD,PNT.CMDT_HDR_SEQ, PNT.ORG_DEST_TP_CD,PNT.ROUT_SEQ " ).append("\n"); 
		query.append("	FROM PRI_SP_SCP_RT_ROUT_PNT PNT" ).append("\n"); 
		query.append("	    , PRI_SP_SCP_GRP_LOC GRP" ).append("\n"); 
		query.append("	    , PRI_SP_SCP_GRP_LOC_DTL GRP_DTL" ).append("\n"); 
		query.append("	WHERE  " ).append("\n"); 
		query.append("	   PNT.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("	    AND PNT.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("	    AND PNT.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("	    AND PNT.GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("	    AND PNT.CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("	    AND PNT.ORG_DEST_TP_CD = 'O'" ).append("\n"); 
		query.append("	    AND PNT.ROUT_SEQ = @[rout_seq]" ).append("\n"); 
		query.append("	    AND ROUT_PNT_LOC_TP_CD = 'G'" ).append("\n"); 
		query.append("	    AND PNT.SRC_INFO_CD <> 'AD' " ).append("\n"); 
		query.append("	    AND PNT.PROP_NO = GRP.PROP_NO" ).append("\n"); 
		query.append("	    AND PNT.AMDT_SEQ    = GRP.AMDT_SEQ" ).append("\n"); 
		query.append("	    AND PNT.SVC_SCP_CD  = GRP.SVC_SCP_CD" ).append("\n"); 
		query.append("	    AND PNT.ROUT_PNT_LOC_DEF_CD   = GRP.PRC_GRP_LOC_CD" ).append("\n"); 
		query.append("	    AND GRP.PROP_NO = GRP_DTL.PROP_NO" ).append("\n"); 
		query.append("	    AND GRP.AMDT_SEQ    = GRP_DTL.AMDT_SEQ" ).append("\n"); 
		query.append("	    AND GRP.SVC_SCP_CD  = GRP_DTL.SVC_SCP_CD" ).append("\n"); 
		query.append("	    AND GRP.GRP_LOC_SEQ   = GRP_DTL.GRP_LOC_SEQ" ).append("\n"); 
		query.append("	    AND GRP_DTL.LOC_CD = @[por_cd]" ).append("\n"); 
		query.append("	     AND  NVL(RCV_DE_TERM_CD,'Y') = @[bkg_rcv_term_cd]" ).append("\n"); 
		query.append("	UNION ALL    " ).append("\n"); 
		query.append("	select ROUT_PNT_LOC_DEF_CD, NVL(RCV_DE_TERM_CD,'Y') AS RCV_DE_TERM_CD" ).append("\n"); 
		query.append("		, PROP_NO, AMDT_SEQ, SVC_SCP_CD, GEN_SPCL_RT_TP_CD,CMDT_HDR_SEQ, ORG_DEST_TP_CD,ROUT_SEQ " ).append("\n"); 
		query.append("	from PRI_SP_SCP_RT_ROUT_PNT " ).append("\n"); 
		query.append("	where  PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("	       AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("	       AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("	       AND GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("	       AND CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("	       AND ORG_DEST_TP_CD = 'O'" ).append("\n"); 
		query.append("		   AND ROUT_SEQ = @[rout_seq]" ).append("\n"); 
		query.append("	       AND ROUT_PNT_LOC_TP_CD = 'L'" ).append("\n"); 
		query.append("	       AND SRC_INFO_CD <> 'AD' " ).append("\n"); 
		query.append("	       AND ROUT_PNT_LOC_DEF_CD = @[por_cd]" ).append("\n"); 
		query.append("	       AND  NVL(RCV_DE_TERM_CD,'Y') = @[bkg_rcv_term_cd]" ).append("\n"); 
		query.append("    ) ORI" ).append("\n"); 
		query.append("    ,(" ).append("\n"); 
		query.append("	SELECT GRP_DTL.LOC_CD AS ROUT_PNT_LOC_DEF_CD, NVL(PNT.RCV_DE_TERM_CD,'Y') AS RCV_DE_TERM_CD" ).append("\n"); 
		query.append("		, PNT.PROP_NO, PNT.AMDT_SEQ, PNT.SVC_SCP_CD, PNT.GEN_SPCL_RT_TP_CD,PNT.CMDT_HDR_SEQ, PNT.ORG_DEST_TP_CD,PNT.ROUT_SEQ " ).append("\n"); 
		query.append("	FROM PRI_SP_SCP_RT_ROUT_PNT PNT" ).append("\n"); 
		query.append("	    , PRI_SP_SCP_GRP_LOC GRP" ).append("\n"); 
		query.append("	    , PRI_SP_SCP_GRP_LOC_DTL GRP_DTL" ).append("\n"); 
		query.append("	WHERE  " ).append("\n"); 
		query.append("	   PNT.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("	    AND PNT.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("	    AND PNT.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("	    AND PNT.GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("	    AND PNT.CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("	    AND PNT.ORG_DEST_TP_CD = 'D'" ).append("\n"); 
		query.append("	    AND PNT.ROUT_SEQ = @[rout_seq]" ).append("\n"); 
		query.append("	    AND ROUT_PNT_LOC_TP_CD = 'G'" ).append("\n"); 
		query.append("	    AND PNT.SRC_INFO_CD <> 'AD' " ).append("\n"); 
		query.append("	    AND PNT.PROP_NO = GRP.PROP_NO" ).append("\n"); 
		query.append("	    AND PNT.AMDT_SEQ    = GRP.AMDT_SEQ" ).append("\n"); 
		query.append("	    AND PNT.SVC_SCP_CD  = GRP.SVC_SCP_CD" ).append("\n"); 
		query.append("	    AND PNT.ROUT_PNT_LOC_DEF_CD   = GRP.PRC_GRP_LOC_CD" ).append("\n"); 
		query.append("	    AND GRP.PROP_NO = GRP_DTL.PROP_NO" ).append("\n"); 
		query.append("	    AND GRP.AMDT_SEQ    = GRP_DTL.AMDT_SEQ" ).append("\n"); 
		query.append("	    AND GRP.SVC_SCP_CD  = GRP_DTL.SVC_SCP_CD" ).append("\n"); 
		query.append("	    AND GRP.GRP_LOC_SEQ   = GRP_DTL.GRP_LOC_SEQ" ).append("\n"); 
		query.append("	    AND GRP_DTL.LOC_CD = @[del_cd]" ).append("\n"); 
		query.append("	     AND  NVL(RCV_DE_TERM_CD,'Y') = @[bkg_de_term_cd]" ).append("\n"); 
		query.append("	UNION ALL    " ).append("\n"); 
		query.append("	select ROUT_PNT_LOC_DEF_CD, NVL(RCV_DE_TERM_CD,'Y') AS RCV_DE_TERM_CD" ).append("\n"); 
		query.append("		, PROP_NO, AMDT_SEQ, SVC_SCP_CD, GEN_SPCL_RT_TP_CD,CMDT_HDR_SEQ, ORG_DEST_TP_CD,ROUT_SEQ " ).append("\n"); 
		query.append("	from PRI_SP_SCP_RT_ROUT_PNT " ).append("\n"); 
		query.append("	where  PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("	       AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("	       AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("	       AND GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("	       AND CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("	       AND ORG_DEST_TP_CD = 'D'" ).append("\n"); 
		query.append("		   AND ROUT_SEQ = @[rout_seq]" ).append("\n"); 
		query.append("	       AND ROUT_PNT_LOC_TP_CD = 'L'" ).append("\n"); 
		query.append("	       AND SRC_INFO_CD <> 'AD' " ).append("\n"); 
		query.append("	       AND ROUT_PNT_LOC_DEF_CD = @[del_cd]" ).append("\n"); 
		query.append("	       AND  NVL(RCV_DE_TERM_CD,'Y') = @[bkg_de_term_cd]" ).append("\n"); 
		query.append("    ) DST   " ).append("\n"); 
		query.append("WHERE ORI.PROP_NO = DST.PROP_NO     " ).append("\n"); 
		query.append("    AND ORI.AMDT_SEQ = DST.AMDT_SEQ" ).append("\n"); 
		query.append("    AND ORI.SVC_SCP_CD = DST.SVC_SCP_CD" ).append("\n"); 
		query.append("    AND ORI.GEN_SPCL_RT_TP_CD = DST.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("    AND ORI.CMDT_HDR_SEQ = DST.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("    AND ORI.ROUT_SEQ = DST.ROUT_SEQ     " ).append("\n"); 
		query.append("       " ).append("\n"); 

	}
}