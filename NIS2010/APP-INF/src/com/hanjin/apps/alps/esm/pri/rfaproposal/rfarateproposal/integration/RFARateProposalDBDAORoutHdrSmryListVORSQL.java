/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RFARateProposalDBDAORoutHdrSmryListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.30
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.30 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFARateProposalDBDAORoutHdrSmryListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Master RFA Creation & Amendment > Route & Summary 조회
	  * </pre>
	  */
	public RFARateProposalDBDAORoutHdrSmryListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_rout_pnt_loc_def_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dest_rout_pnt_loc_def_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_de_term_cd_dest",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_dir_call_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ts_port_def_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("org_rout_via_port_def_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dest_rout_via_port_def_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_de_term_cd_ori",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.integration").append("\n"); 
		query.append("FileName : RFARateProposalDBDAORoutHdrSmryListVORSQL").append("\n"); 
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
		query.append("SELECT A.PROP_NO ," ).append("\n"); 
		query.append("       A.AMDT_SEQ ," ).append("\n"); 
		query.append("       A.SVC_SCP_CD ," ).append("\n"); 
		query.append("       A.CMDT_HDR_SEQ ," ).append("\n"); 
		query.append("       A.ROUT_SEQ ," ).append("\n"); 
		query.append("       B.ROUT_PNT_LOC_DEF_CD AS ORG_ROUT_PNT_LOC_DEF_CD ," ).append("\n"); 
		query.append("       B.RCV_DE_TERM_CD AS RCV_DE_TERM_CD_ORI ," ).append("\n"); 
		query.append("       C.ROUT_VIA_PORT_DEF_CD AS ORG_ROUT_VIA_PORT_DEF_CD ," ).append("\n"); 
		query.append("       D.ROUT_VIA_PORT_DEF_CD AS DEST_ROUT_VIA_PORT_DEF_CD ," ).append("\n"); 
		query.append("       E.ROUT_PNT_LOC_DEF_CD AS DEST_ROUT_PNT_LOC_DEF_CD ," ).append("\n"); 
		query.append("       E.RCV_DE_TERM_CD AS RCV_DE_TERM_CD_DEST," ).append("\n"); 
		query.append("       F.BKG_DIR_CALL_FLG ," ).append("\n"); 
		query.append("       F.BKG_TS_PORT_DEF_CD ," ).append("\n"); 
		query.append("       F.BKG_SLAN_CD ," ).append("\n"); 
		query.append("       F.BKG_VVD_CD ," ).append("\n"); 
		query.append("       A.N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("  FROM PRI_RP_SCP_RT_CMDT_ROUT A ," ).append("\n"); 
		query.append("       PRI_RP_SCP_RT_ROUT_PNT B ," ).append("\n"); 
		query.append("       PRI_RP_SCP_RT_ROUT_VIA C ," ).append("\n"); 
		query.append("       PRI_RP_SCP_RT_ROUT_VIA D ," ).append("\n"); 
		query.append("       PRI_RP_SCP_RT_ROUT_PNT E ," ).append("\n"); 
		query.append("       (SELECT A.PROP_NO ," ).append("\n"); 
		query.append("               A.AMDT_SEQ ," ).append("\n"); 
		query.append("               A.SVC_SCP_CD ," ).append("\n"); 
		query.append("               A.CMDT_HDR_SEQ ," ).append("\n"); 
		query.append("               A.ROUT_SEQ ," ).append("\n"); 
		query.append("               MAX(DECODE(NOTE_CONV_RULE_CD, 'APP', B.BKG_DIR_CALL_FLG, '')) AS BKG_DIR_CALL_FLG ," ).append("\n"); 
		query.append("               MAX(DECODE(NOTE_CONV_RULE_CD, 'APP', B.BKG_TS_PORT_DEF_CD, '')) AS BKG_TS_PORT_DEF_CD ," ).append("\n"); 
		query.append("               MAX(DECODE(NOTE_CONV_RULE_CD, 'APP', B.BKG_SLAN_CD, '')) AS BKG_SLAN_CD ," ).append("\n"); 
		query.append("               MAX(DECODE(NOTE_CONV_RULE_CD, 'APP', (B.BKG_VSL_CD || B.BKG_SKD_VOY_NO || B.BKG_SKD_DIR_CD), '')) AS BKG_VVD_CD" ).append("\n"); 
		query.append("          FROM PRI_RP_SCP_RT_CMDT_RNOTE A," ).append("\n"); 
		query.append("               PRI_RFA_NOTE_CONV B" ).append("\n"); 
		query.append("         WHERE A.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("           AND A.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("           AND A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("           AND A.CMDT_HDR_SEQ = '1'          " ).append("\n"); 
		query.append("           AND A.NOTE_CONV_MAPG_ID = B.NOTE_CONV_MAPG_ID" ).append("\n"); 
		query.append("         GROUP BY A.PROP_NO ," ).append("\n"); 
		query.append("               A.AMDT_SEQ ," ).append("\n"); 
		query.append("               A.SVC_SCP_CD ," ).append("\n"); 
		query.append("               A.CMDT_HDR_SEQ ," ).append("\n"); 
		query.append("               A.ROUT_SEQ) F" ).append("\n"); 
		query.append(" WHERE A.PROP_NO = B.PROP_NO(+)" ).append("\n"); 
		query.append("   AND A.AMDT_SEQ = B.AMDT_SEQ(+)" ).append("\n"); 
		query.append("   AND A.SVC_SCP_CD = B.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("   AND A.CMDT_HDR_SEQ = B.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("   AND A.ROUT_SEQ = B.ROUT_SEQ(+)" ).append("\n"); 
		query.append("   AND A.PROP_NO = C.PROP_NO(+)" ).append("\n"); 
		query.append("   AND A.AMDT_SEQ = C.AMDT_SEQ(+)" ).append("\n"); 
		query.append("   AND A.SVC_SCP_CD = C.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("   AND A.CMDT_HDR_SEQ = C.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("   AND A.ROUT_SEQ = C.ROUT_SEQ(+)" ).append("\n"); 
		query.append("   AND A.PROP_NO = D.PROP_NO(+)" ).append("\n"); 
		query.append("   AND A.AMDT_SEQ = D.AMDT_SEQ(+)" ).append("\n"); 
		query.append("   AND A.SVC_SCP_CD = D.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("   AND A.CMDT_HDR_SEQ = D.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("   AND A.ROUT_SEQ = D.ROUT_SEQ(+)" ).append("\n"); 
		query.append("   AND A.PROP_NO = E.PROP_NO(+)" ).append("\n"); 
		query.append("   AND A.AMDT_SEQ = E.AMDT_SEQ(+)" ).append("\n"); 
		query.append("   AND A.SVC_SCP_CD = E.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("   AND A.CMDT_HDR_SEQ = E.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("   AND A.ROUT_SEQ = E.ROUT_SEQ(+)" ).append("\n"); 
		query.append("   AND A.PROP_NO = F.PROP_NO(+)" ).append("\n"); 
		query.append("   AND A.AMDT_SEQ = F.AMDT_SEQ(+)" ).append("\n"); 
		query.append("   AND A.SVC_SCP_CD = F.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("   AND A.CMDT_HDR_SEQ = F.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("   AND A.ROUT_SEQ = F.ROUT_SEQ(+)" ).append("\n"); 
		query.append("   AND B.ORG_DEST_TP_CD = 'O'" ).append("\n"); 
		query.append("   AND C.ORG_DEST_TP_CD(+) = 'O'" ).append("\n"); 
		query.append("   AND D.ORG_DEST_TP_CD(+) = 'D'" ).append("\n"); 
		query.append("   AND E.ORG_DEST_TP_CD = 'D'" ).append("\n"); 
		query.append("   AND A.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("   AND A.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("   AND A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("   AND A.CMDT_HDR_SEQ = '1'" ).append("\n"); 
		query.append("   AND B.ROUT_PNT_LOC_DEF_CD = @[org_rout_pnt_loc_def_cd]" ).append("\n"); 
		query.append("   AND B.RCV_DE_TERM_CD = @[rcv_de_term_cd_ori]" ).append("\n"); 
		query.append("   AND C.ROUT_VIA_PORT_DEF_CD = @[org_rout_via_port_def_cd]" ).append("\n"); 
		query.append("   AND D.ROUT_VIA_PORT_DEF_CD = @[dest_rout_via_port_def_cd]" ).append("\n"); 
		query.append("   AND E.ROUT_PNT_LOC_DEF_CD = @[dest_rout_pnt_loc_def_cd]" ).append("\n"); 
		query.append("   AND E.RCV_DE_TERM_CD = @[rcv_de_term_cd_dest]" ).append("\n"); 
		query.append("#if (${bkg_dir_call_flg} != '')" ).append("\n"); 
		query.append("   AND F.BKG_DIR_CALL_FLG = @[bkg_dir_call_flg]" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("   AND F.BKG_DIR_CALL_FLG IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_ts_port_def_cd} != '')" ).append("\n"); 
		query.append("   AND F.BKG_TS_PORT_DEF_CD = @[bkg_ts_port_def_cd]" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("   AND F.BKG_TS_PORT_DEF_CD IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_slan_cd} != '')" ).append("\n"); 
		query.append("   AND F.BKG_SLAN_CD = @[bkg_slan_cd]" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("   AND F.BKG_SLAN_CD IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_vvd_cd} != '')" ).append("\n"); 
		query.append("   AND F.BKG_VVD_CD = @[bkg_vvd_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND F.BKG_VVD_CD IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" ORDER BY ROUT_SEQ" ).append("\n"); 

	}
}