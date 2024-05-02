/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CopDetailReceiveDBDAOSearchAutoMVMTRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.03
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2015.04.03 김성욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.copdetailreceive.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Wook Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CopDetailReceiveDBDAOSearchAutoMVMTRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchAutoMVMT
	  * </pre>
	  */
	public CopDetailReceiveDBDAOSearchAutoMVMTRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdt_ext_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_dlay_rsn_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rail_dest_n1st_eta_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_id_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_split_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_rcv_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_dlay_rsn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bnd_vskd_seq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_msg_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("act_sts_mapg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_cyc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.copdetailreceive.integration").append("\n"); 
		query.append("FileName : CopDetailReceiveDBDAOSearchAutoMVMTRSQL").append("\n"); 
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
		query.append("CNTR_NO" ).append("\n"); 
		query.append(",BKG_NO" ).append("\n"); 
		query.append(",ACT_STS_MAPG_CD" ).append("\n"); 
		query.append(",NOD_CD" ).append("\n"); 
		query.append(",ACT_DT" ).append("\n"); 
		query.append(",EDI_MSG_TP_CD" ).append("\n"); 
		query.append(",CRE_TP_CD" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",VNDR_SEQ" ).append("\n"); 
		query.append(",BND_VSKD_SEQ_CD" ).append("\n"); 
		query.append(",ACT_DAT_RCV_DT" ).append("\n"); 
		query.append(",VSL_CD" ).append("\n"); 
		query.append(",SKD_VOY_NO" ).append("\n"); 
		query.append(",SKD_DIR_CD" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",CLPT_IND_SEQ" ).append("\n"); 
		query.append(",VSL_DLAY_RSN_CD" ).append("\n"); 
		query.append(",VSL_DLAY_RSN_DESC" ).append("\n"); 
		query.append(",VPS_LOC_CD" ).append("\n"); 
		query.append(",ACT_CD" ).append("\n"); 
		query.append(",RAIL_DEST_N1ST_ETA_DT" ).append("\n"); 
		query.append(",ACT_GDT" ).append("\n"); 
		query.append(",CNMV_YR" ).append("\n"); 
		query.append(",CNMV_ID_NO" ).append("\n"); 
		query.append(",CNMV_SEQ" ).append("\n"); 
		query.append(",CNMV_SPLIT_NO" ).append("\n"); 
		query.append(",CNMV_CYC_NO" ).append("\n"); 
		query.append(",IMDT_EXT_FLG" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("@[cntr_no] AS CNTR_NO" ).append("\n"); 
		query.append(",@[bkg_no] AS BKG_NO" ).append("\n"); 
		query.append(",DECODE(@[act_rcv_tp_cd],'21','ATA','22','ATB','23','ATD',@[act_sts_mapg_cd]) AS ACT_STS_MAPG_CD" ).append("\n"); 
		query.append(",@[nod_cd] AS NOD_CD" ).append("\n"); 
		query.append(",TO_CHAR(to_date(@[act_dt],'YYYYMMDDHH24MI'), 'YYYY/MM/DD HH24:MI:SS') AS ACT_DT" ).append("\n"); 
		query.append(",@[edi_msg_tp_cd] AS EDI_MSG_TP_CD" ).append("\n"); 
		query.append(",@[cre_tp_cd]  AS CRE_TP_CD" ).append("\n"); 
		query.append(",@[cre_usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append(",@[vndr_seq] AS VNDR_SEQ" ).append("\n"); 
		query.append(",@[bnd_vskd_seq_cd] AS BND_VSKD_SEQ_CD" ).append("\n"); 
		query.append(",TO_CHAR( GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL', sysdate, substr(@[nod_cd],1,5)),'YYYY/MM/DD HH24:MI:SS' )  ACT_DAT_RCV_DT" ).append("\n"); 
		query.append(",@[vsl_cd] AS VSL_CD" ).append("\n"); 
		query.append(",@[skd_voy_no] AS SKD_VOY_NO" ).append("\n"); 
		query.append(",@[skd_dir_cd] AS SKD_DIR_CD" ).append("\n"); 
		query.append(",@[cre_usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append(",@[vps_port_cd] AS VPS_PORT_CD" ).append("\n"); 
		query.append(",@[clpt_ind_seq] AS CLPT_IND_SEQ" ).append("\n"); 
		query.append(",@[vsl_dlay_rsn_cd] AS VSL_DLAY_RSN_CD" ).append("\n"); 
		query.append(",@[vsl_dlay_rsn_desc] AS VSL_DLAY_RSN_DESC" ).append("\n"); 
		query.append(",@[vps_loc_cd] AS VPS_LOC_CD" ).append("\n"); 
		query.append(",@[act_cd] AS ACT_CD" ).append("\n"); 
		query.append(",to_date(@[rail_dest_n1st_eta_dt],'YYYY/MM/DD HH24:MI:SS') AS RAIL_DEST_N1ST_ETA_DT" ).append("\n"); 
		query.append(",(CASE WHEN SUBSTR(@[nod_cd],1,5) IS NOT NULL" ).append("\n"); 
		query.append("       THEN GLOBALDATE_PKG.TIME_CONV_FNC(SUBSTR(@[nod_cd],1,5), to_date(@[act_dt],'YYYYMMDDHH24MI'), 'GMT')" ).append("\n"); 
		query.append("  END) AS ACT_GDT" ).append("\n"); 
		query.append(",@[cnmv_yr] AS CNMV_YR" ).append("\n"); 
		query.append(",TO_NUMBER(@[cnmv_id_no]) AS CNMV_ID_NO" ).append("\n"); 
		query.append(",TO_NUMBER(@[cnmv_seq]) AS CNMV_SEQ" ).append("\n"); 
		query.append(",@[cnmv_split_no] AS CNMV_SPLIT_NO" ).append("\n"); 
		query.append(",TO_NUMBER(@[cnmv_cyc_no]) AS CNMV_CYC_NO" ).append("\n"); 
		query.append(",@[imdt_ext_flg] AS IMDT_EXT_FLG" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT TO_CHAR(CNTR_NO)	CNTR_NO" ).append("\n"); 
		query.append(",TO_CHAR(BKG_NO) BKG_NO" ).append("\n"); 
		query.append(",TO_CHAR(MVMT_STS_CD) ACT_STS_MAPG_CD" ).append("\n"); 
		query.append(",TO_CHAR(ORG_YD_CD) NOD_CD" ).append("\n"); 
		query.append(",TO_CHAR(CNMV_EVNT_DT,'YYYY/MM/DD HH24:MI:SS') ACT_DT" ).append("\n"); 
		query.append(",TO_CHAR(CASE WHEN MVMT_EDI_MSG_TP_ID is null" ).append("\n"); 
		query.append("     THEN ( CASE WHEN MVMT_CRE_TP_CD in ('A', 'C', 'L','N','M','U','E')" ).append("\n"); 
		query.append("                 THEN 'SYSTEM'" ).append("\n"); 
		query.append("                 WHEN MVMT_CRE_TP_CD is null" ).append("\n"); 
		query.append("                 THEN SUBSTR(CRE_USR_ID,1,10)" ).append("\n"); 
		query.append("            END" ).append("\n"); 
		query.append("          )" ).append("\n"); 
		query.append("     ELSE MVMT_EDI_MSG_TP_ID" ).append("\n"); 
		query.append(" END) EDI_MSG_TP_CD" ).append("\n"); 
		query.append(",TO_CHAR(MVMT_CRE_TP_CD) CRE_TP_CD" ).append("\n"); 
		query.append(",'SCEFND' CRE_USR_ID" ).append("\n"); 
		query.append(",TO_CHAR(VNDR_SEQ) VNDR_SEQ" ).append("\n"); 
		query.append(",TO_CHAR(OB_CNTR_FLG) BND_VSKD_SEQ_CD" ).append("\n"); 
		query.append(",TO_CHAR(UPD_LOCL_DT,'YYYY/MM/DD HH24:MI:SS') ACT_DAT_RCV_DT" ).append("\n"); 
		query.append(",TO_CHAR(CRNT_VSL_CD) VSL_CD" ).append("\n"); 
		query.append(",TO_CHAR(CRNT_SKD_VOY_NO) SKD_VOY_NO" ).append("\n"); 
		query.append(",TO_CHAR(CRNT_SKD_DIR_CD) SKD_DIR_CD" ).append("\n"); 
		query.append(",CRE_USR_ID AS UPD_USR_ID" ).append("\n"); 
		query.append(",'' AS VPS_PORT_CD" ).append("\n"); 
		query.append(",'' AS CLPT_IND_SEQ" ).append("\n"); 
		query.append(",'' AS VSL_DLAY_RSN_CD" ).append("\n"); 
		query.append(",'' AS VSL_DLAY_RSN_DESC" ).append("\n"); 
		query.append(",'' AS VPS_LOC_CD" ).append("\n"); 
		query.append(",'' AS ACT_CD" ).append("\n"); 
		query.append(",NULL AS RAIL_DEST_N1ST_ETA_DT" ).append("\n"); 
		query.append(",(CASE WHEN SUBSTR(ORG_YD_CD,1,5) IS NOT NULL" ).append("\n"); 
		query.append("       THEN GLOBALDATE_PKG.TIME_CONV_FNC(SUBSTR(ORG_YD_CD,1,5), CNMV_EVNT_DT, 'GMT')" ).append("\n"); 
		query.append("  END) AS ACT_GDT" ).append("\n"); 
		query.append(",CNMV_YR" ).append("\n"); 
		query.append(",CNMV_ID_NO" ).append("\n"); 
		query.append(",CNMV_SEQ" ).append("\n"); 
		query.append(",CNMV_SPLIT_NO" ).append("\n"); 
		query.append(",CNMV_CYC_NO" ).append("\n"); 
		query.append(",imdt_ext_flg" ).append("\n"); 
		query.append("FROM CTM_MOVEMENT" ).append("\n"); 
		query.append("WHERE CNTR_NO=TO_CHAR(@[cntr_no])" ).append("\n"); 
		query.append("AND   CNMV_EVNT_DT = TO_DATE(@[act_dt],'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("AND		(" ).append("\n"); 
		query.append("			MVMT_STS_CD <> TO_CHAR(@[act_sts_mapg_cd])" ).append("\n"); 
		query.append("			OR" ).append("\n"); 
		query.append("			( MVMT_STS_CD = TO_CHAR(@[act_sts_mapg_cd]) AND ORG_YD_CD <> @[nod_cd] )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("union" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("		TO_CHAR(CNTR_NO)	CNTR_NO" ).append("\n"); 
		query.append("		,TO_CHAR(BKG_NO) BKG_NO" ).append("\n"); 
		query.append("		,TO_CHAR(MVMT_STS_CD) ACT_STS_MAPG_CD" ).append("\n"); 
		query.append("		,TO_CHAR(ORG_YD_CD) NOD_CD" ).append("\n"); 
		query.append("		,TO_CHAR(CNMV_EVNT_DT,'YYYY/MM/DD HH24:MI:SS') ACT_DT" ).append("\n"); 
		query.append("		,TO_CHAR(CASE WHEN MVMT_EDI_MSG_TP_ID is null" ).append("\n"); 
		query.append("			 THEN ( CASE WHEN MVMT_CRE_TP_CD in ('A', 'C', 'L','N','M','U','E')" ).append("\n"); 
		query.append("						 THEN 'SYSTEM'" ).append("\n"); 
		query.append("						 WHEN MVMT_CRE_TP_CD is null" ).append("\n"); 
		query.append("						 THEN SUBSTR(CRE_USR_ID,1,10)" ).append("\n"); 
		query.append("					END" ).append("\n"); 
		query.append("				  )" ).append("\n"); 
		query.append("			 ELSE MVMT_EDI_MSG_TP_ID" ).append("\n"); 
		query.append("		 END) EDI_MSG_TP_CD" ).append("\n"); 
		query.append("		,TO_CHAR(MVMT_CRE_TP_CD) CRE_TP_CD" ).append("\n"); 
		query.append("		,'SCE_U_FND' CRE_USR_ID" ).append("\n"); 
		query.append("		,TO_CHAR(VNDR_SEQ) VNDR_SEQ" ).append("\n"); 
		query.append("		,TO_CHAR(OB_CNTR_FLG) BND_VSKD_SEQ_CD" ).append("\n"); 
		query.append("        ,TO_CHAR(UPD_LOCL_DT,'YYYY/MM/DD HH24:MI:SS') ACT_DAT_RCV_DT" ).append("\n"); 
		query.append("		,TO_CHAR(CRNT_VSL_CD) VSL_CD" ).append("\n"); 
		query.append("		,TO_CHAR(CRNT_SKD_VOY_NO) SKD_VOY_NO" ).append("\n"); 
		query.append("		,TO_CHAR(CRNT_SKD_DIR_CD) SKD_DIR_CD" ).append("\n"); 
		query.append("		,CRE_USR_ID AS UPD_USR_ID" ).append("\n"); 
		query.append("		,'' AS VPS_PORT_CD" ).append("\n"); 
		query.append("		,'' AS CLPT_IND_SEQ" ).append("\n"); 
		query.append("		,'' AS VSL_DLAY_RSN_CD" ).append("\n"); 
		query.append("		,'' AS VSL_DLAY_RSN_DESC" ).append("\n"); 
		query.append("		,'' AS VPS_LOC_CD" ).append("\n"); 
		query.append("		,'' AS ACT_CD" ).append("\n"); 
		query.append("		,NULL AS RAIL_DEST_N1ST_ETA_DT" ).append("\n"); 
		query.append("		,(CASE WHEN SUBSTR(ORG_YD_CD,1,5) IS NOT NULL" ).append("\n"); 
		query.append("			   THEN GLOBALDATE_PKG.TIME_CONV_FNC(SUBSTR(ORG_YD_CD,1,5), CNMV_EVNT_DT, 'GMT')" ).append("\n"); 
		query.append("		  END) AS ACT_GDT" ).append("\n"); 
		query.append("		,CNMV_YR" ).append("\n"); 
		query.append("		,CNMV_ID_NO" ).append("\n"); 
		query.append("		,CNMV_SEQ" ).append("\n"); 
		query.append("		,CNMV_SPLIT_NO" ).append("\n"); 
		query.append("		,CNMV_CYC_NO" ).append("\n"); 
		query.append("		,imdt_ext_flg" ).append("\n"); 
		query.append("FROM	CTM_MOVEMENT	M	" ).append("\n"); 
		query.append("WHERE	1 = 1" ).append("\n"); 
		query.append("AND		M.CNTR_NO				=	@[cntr_no]" ).append("\n"); 
		query.append("AND		M.CNMV_CYC_NO			IN	( TO_NUMBER(@[cnmv_cyc_no]), (TO_NUMBER(@[cnmv_cyc_no]) - 1) )" ).append("\n"); 
		query.append("AND		M.MVMT_CRE_TP_CD	IN ('U','S')" ).append("\n"); 
		query.append("AND		NOT EXISTS	(" ).append("\n"); 
		query.append("						SELECT	'A'" ).append("\n"); 
		query.append("						FROM	SCE_ACT_RCV_IF	I" ).append("\n"); 
		query.append("						WHERE	1	=	1" ).append("\n"); 
		query.append("						AND		I.BKG_NO			=	M.BKG_NO" ).append("\n"); 
		query.append("						AND		I.CNTR_NO			=	M.CNTR_NO" ).append("\n"); 
		query.append("						AND		I.ACT_STS_MAPG_CD	=	M.MVMT_STS_CD" ).append("\n"); 
		query.append("						AND		I.NOD_CD			=	M.ORG_YD_CD" ).append("\n"); 
		query.append("						AND		I.ACT_DT			=	M.CNMV_EVNT_DT" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ORDER BY CNTR_NO, CNMV_YR, CNMV_ID_NO, CNMV_SEQ" ).append("\n"); 

	}
}