/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CSMSendDBDAOAddFlatFileCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.11
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.11 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.csmsend.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CSMSendDBDAOAddFlatFileCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AddFlatFile
	  * </pre>
	  */
	public CSMSendDBDAOAddFlatFileCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_rcv_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_snd_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_snd_yrmondy",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stnd_edi_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_rcv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.csmsend.integration").append("\n"); 
		query.append("FileName : CSMSendDBDAOAddFlatFileCSQL").append("\n"); 
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
		query.append("INSERT " ).append("\n"); 
		query.append("INTO SCE_CNTR_STS_MSG_FLT_FILE ( " ).append("\n"); 
		query.append("EDI_SND_YRMONDY, " ).append("\n"); 
		query.append("EDI_SND_SEQ, " ).append("\n"); 
		query.append("EDI_SND_DESC, " ).append("\n"); 
		query.append("EDI_STS_CD, " ).append("\n"); 
		query.append("BL_NO, " ).append("\n"); 
		query.append("BKG_NO," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT, " ).append("\n"); 
		query.append("UPD_USR_ID, " ).append("\n"); 
		query.append("UPD_DT, " ).append("\n"); 
		query.append("ACT_RCV_DT, " ).append("\n"); 
		query.append("ACT_RCV_NO " ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append("( " ).append("\n"); 
		query.append("		select /*+ index_asc (SCE_CNTR_STS_MSG_TGT XPKSCE_CNTR_STS_MSG_TGT) */ " ).append("\n"); 
		query.append("		@[edi_snd_yrmondy],  --to_char(sysdate, 'yymmdd')" ).append("\n"); 
		query.append("		@[edi_snd_seq],  --sce_cntr_sts_msg_flt_file_seq1.nextval" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("        --------------- edi message start -----------------------" ).append("\n"); 
		query.append("        chr(34)||chr(34)||chr(44) --  Equipment Category" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("        ||chr(34)||substr(tgt.cntr_no,1,4)||chr(34)||chr(44) --Equipment Category," ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("        ||chr(34)||chr(34)||chr(44)  -- Equipment Number Prefix" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("        ||chr(34)||substr(tgt.cntr_no,5,6)||chr(34)||chr(44) --Equipment Number,Equipment Number Suffix" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("        ||chr(34)||substr(tgt.cntr_no,11,1)||chr(34)||chr(44)  --Equipment Check Digit" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("        ||chr(34)||decode(bkg.bkg_cgo_tp_cd,'F','L','E')||chr(34)||chr(44) --Equipment Status" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("        ||chr(34)||chr(34)||chr(44)  --Equipment Owner" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("        ||chr(34)||chr(34)||chr(44)  --Equipment Operator" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("        ||chr(34)||mcts.CNTR_TPSZ_ISO_CD||chr(34)||chr(44)" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("        ||chr(34)||STND_EDI_STS_CD||chr(34)||chr(44) -- Equipment Event Code" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("        ||chr(34)||TO_CHAR(TGT.ACT_DT, 'YYYYMMDD')||chr(34)||chr(44)  -- Equipment Size Type Code,Equipment Event Code,Equipment Event Date" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("        ||chr(34)||TO_CHAR(TGT.ACT_DT, 'HH24MISS')||chr(34)||chr(44) --Equipment Event Time" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("        ||chr(34)||'LT'||chr(34)||chr(44)  -- Equipment Event Time Zone" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("        ||chr(34)||DECODE(SUBSTR(tgt.nod_cd,1,5), BKG.por_cd, 'R', BKG.del_CD, 'E', BKG.POL_CD,'T', BKG.POD_CD, 'T','5')||chr(34)||chr(44) --Location Function Code" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("        ||chr(34)||'UN'||chr(34)||chr(44) --Equipment Event Location Code Qualifier" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("        ||chr(34)||(SELECT UN_LOC_CD FROM MDM_LOCATION WHERE LOC_CD = SUBSTR(TGT.NOD_CD,1,5))||chr(34)||chr(44) -- Equipment Event Location Code" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("        ||chr(34)||(SELECT YD_NM FROM MDM_YARD WHERE YD_CD = NOD_CD)||chr(34)||chr(44)     --Equipment Event Location Name " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("        ||chr(34)||chr(34)||chr(44) -- Leave blank," ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("        ||chr(34)||(SELECT LOC_NM FROM MDM_LOCATION WHERE LOC_CD = SUBSTR(TGT.NOD_CD,1,5))||chr(34)||chr(44)  -- Equipment Event Location City Name" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("        ||chr(34)||(SELECT STE_CD FROM MDM_LOCATION WHERE LOC_CD = SUBSTR(TGT.NOD_CD,1,5)AND SUBSTR(TGT.NOD_CD,1,2) IN ('US','CA'))||chr(34)||chr(44) --  Equipment Event Location State Code," ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("        ||chr(34)||(SELECT STE_NM FROM MDM_STATE S, MDM_LOCATION L WHERE L.LOC_CD = SUBSTR(TGT.NOD_CD,1,5) AND S.STE_CD = L.STE_CD AND L.CNT_CD = S.CNT_CD AND S.DELT_FLG = 'N' AND SUBSTR(TGT.NOD_CD,1,2) IN ('US','CA'))||chr(34)||chr(44)    --  Equipment Event Location State Name," ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("        ||chr(34)||(SELECT ZIP_CD FROM MDM_YARD WHERE YD_CD = NOD_CD)||chr(34)||chr(44) --  Equipment Event Location Postal Code" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("        ||chr(34)||SUBSTR(tgt.nod_cd,1,2)||chr(34)||chr(44) -- Equipment Event Location Country Code" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("        ||chr(34)||(SELECT CNT_NM FROM MDM_COUNTRY C, MDM_LOCATION L WHERE L.LOC_CD = SUBSTR(TGT.NOD_CD,1,5) AND C.CNT_CD = L.CNT_CD)||chr(34)||chr(44) -- Equipment Event Location Country Name,  " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("        ||chr(34)||'BN'||chr(34)||chr(44)  -- Reference Number Qualifier" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("        ||chr(34)||bkg.bkg_no||chr(34)||chr(44) --Reference Number," ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("        ||chr(34)||nvl(decode(LLOYD_NO, 'T.B.N.', 'TBN', VSL.LLOYD_NO), ' ')||chr(34)||chr(44) --lloyd number" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("        ||chr(34)||'L'||chr(34)||chr(44)  --Reference Number,    Vessel Code,Vessel Code Qualifier" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("        ||chr(34)||REPLACE(vsl.VSL_ENG_NM, CHR(39), ' ')||chr(34)||chr(44)" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("        ||chr(34)||(SELECT CNT_NM FROM MDM_COUNTRY WHERE CNT_CD = VSL_RGST_CNT_CD)||chr(34)||chr(44)  --Vessel Name,Vessel Country of Registry" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("        ||chr(34)||tgt.vsl_cd||tgt.skd_voy_no||chr(34)||chr(44) " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("        ||chr(34)||DECODE(tgt.skd_dir_cd, 'W', 'West', 'E', 'East', 'S', 'South', 'N','North', '')||chr(34)||chr(44)    --Voyage Number,Voyage Direction," ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("        ||chr(34)||chr(34)||chr(44)  --Vessel Owner Code" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("        ||chr(34)||(select DECODE(CRR_CD, 'OTH','', CRR_CD) FROM MDM_VSL_CNTR M WHERE M.VSL_CD = VSL.VSL_CD)||chr(34)||chr(44)   --Vessel Operator Code" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("        ||chr(34)||(select DECODE(CRR_CD, 'OTH','','NYKU') FROM MDM_VSL_CNTR M WHERE M.VSL_CD = VSL.VSL_CD)||chr(34)||chr(44)  --Vessel Carrier Code" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("        ||chr(34)||DECODE(SUBSTR(tgt.nod_cd,1,5), BKG.por_cd, 'R', BKG.del_CD, 'E', BKG.POL_CD,'T', BKG.POD_CD, 'T',bkg.PRE_RLY_PORT_CD, 'L', '5')||chr(34)||chr(44) --Location Function Code,  --Equipment Port Function Code" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("        ||chr(34)||'UN'||chr(34)||chr(44) --Equipment Port Location Code Qualifier," ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("        ||chr(34)||SUBSTR(tgt.nod_cd,1,5)||chr(34)||chr(44) -- Equipment Port Location Code" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("        ||chr(34)||(SELECT LOC_NM FROM MDM_LOCATION WHERE LOC_CD = SUBSTR(TGT.NOD_CD,1,5))||chr(34)||chr(44)  -- Equipment Port Location Name" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("        ||chr(34)||chr(34)||chr(44) -- Equipment Port Location City Code BLANK" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("        ||chr(34)||(SELECT LOC_NM FROM MDM_LOCATION WHERE LOC_CD = SUBSTR(TGT.NOD_CD,1,5))||chr(34)||chr(44)  -- Equipment Port Location City Name" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("        ||chr(34)||(SELECT STE_CD FROM MDM_LOCATION WHERE LOC_CD = SUBSTR(TGT.NOD_CD,1,5)AND SUBSTR(TGT.NOD_CD,1,2) IN ('US','CA'))||chr(34)||chr(44) --  Equipment Event Location State Code" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("        ||chr(34)||(SELECT STE_NM FROM MDM_STATE S, MDM_LOCATION L WHERE L.LOC_CD = SUBSTR(TGT.NOD_CD,1,5) AND S.STE_CD = L.STE_CD AND L.CNT_CD = S.CNT_CD AND S.DELT_FLG = 'N' AND SUBSTR(TGT.NOD_CD,1,2) IN ('US','CA'))||chr(34)||chr(44)     --  Equipment Event Location State Name" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("        ||chr(34)||yd.zip_cd||chr(34)||chr(44)" ).append("\n"); 
		query.append("        ||chr(34)||substr(tgt.nod_cd,1,2)||chr(34)||chr(44)  -- Equipment Port Location State Name, Equipment Port Location Postal Code,Equipment Port Location Country Code " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("        ||chr(34)||(SELECT REPLACE(CNT_NM, CHR(39), ' ') FROM MDM_COUNTRY WHERE  CNT_CD = substr(tgt.nod_cd,1,2))||chr(34)||chr(44)  --Equipment Port Location Country Name" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("        ||chr(34)||DECODE(STND_EDI_STS_CD, 'AE','ACA','UV','EDD','')||chr(34)||chr(44)" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("        ||chr(34)||DECODE(STND_EDI_STS_CD, 'AE',TO_CHAR(TGT.ACT_DT, 'YYYYMMDD'),'UV',TO_CHAR(TGT.ACT_DT, 'YYYYMMDD'),'')||chr(34)||chr(44) --Equipment Port Date Qualifier, event_date" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("        ||chr(34)||DECODE(STND_EDI_STS_CD, 'AE',TO_CHAR(TGT.ACT_DT, 'HH24MISS'),'UV',TO_CHAR(TGT.ACT_DT, 'HH24MISS'),'')||chr(34)||chr(44)" ).append("\n"); 
		query.append("        ||chr(34)||'LT'||chr(34),   " ).append("\n"); 
		query.append("   		--------------- edi message end -----------------------" ).append("\n"); 
		query.append("		@[stnd_edi_sts_cd],  --mapg.stnd_edi_sts_cd" ).append("\n"); 
		query.append("		bkg.bl_no, " ).append("\n"); 
		query.append("		bkg.bkg_no, " ).append("\n"); 
		query.append("		tgt.CRE_USR_ID, " ).append("\n"); 
		query.append("		sysdate, " ).append("\n"); 
		query.append("		tgt.UPD_USR_ID, " ).append("\n"); 
		query.append("		sysdate, " ).append("\n"); 
		query.append("		tgt.act_rcv_dt, " ).append("\n"); 
		query.append("		tgt.act_rcv_no " ).append("\n"); 
		query.append("		from ( " ).append("\n"); 
		query.append("				SELECT ACT_RCV_DT, " ).append("\n"); 
		query.append("				  ACT_RCV_NO, " ).append("\n"); 
		query.append("				  BKG_NO, " ).append("\n"); 
		query.append("				  CNTR_NO, " ).append("\n"); 
		query.append("				  ACT_DT, " ).append("\n"); 
		query.append("				  ACT_STS_MAPG_CD, " ).append("\n"); 
		query.append("				  NOD_CD, " ).append("\n"); 
		query.append("				  ACT_RCV_TP_CD, " ).append("\n"); 
		query.append("				  ACT_UMCH_TP_CD, " ).append("\n"); 
		query.append("				  UMCH_CHK_DT, " ).append("\n"); 
		query.append("				  VSL_CD, " ).append("\n"); 
		query.append("				  SKD_VOY_NO, " ).append("\n"); 
		query.append("				  SKD_DIR_CD, " ).append("\n"); 
		query.append("				  VPS_PORT_CD, " ).append("\n"); 
		query.append("				  CLPT_IND_SEQ, " ).append("\n"); 
		query.append("				  EDI_MSG_TP_CD, " ).append("\n"); 
		query.append("				  BND_VSKD_SEQ_CD, " ).append("\n"); 
		query.append("				  COP_EVNT_SEQ, " ).append("\n"); 
		query.append("				  ACT_DAT_RCV_DT, " ).append("\n"); 
		query.append("				  RAIL_DEST_N1ST_ETA_DT, " ).append("\n"); 
		query.append("				  CNTR_CGO_TP_CD, " ).append("\n"); 
		query.append("				  CNMV_CO_CD, " ).append("\n"); 
		query.append("				  CRE_USR_ID, " ).append("\n"); 
		query.append("				  CRE_DT, " ).append("\n"); 
		query.append("				  UPD_USR_ID, " ).append("\n"); 
		query.append("				  UPD_DT ," ).append("\n"); 
		query.append("  				  @[stnd_edi_sts_cd] STND_EDI_STS_CD" ).append("\n"); 
		query.append("				FROM SCE_CNTR_STS_MSG_TGT" ).append("\n"); 
		query.append("		    	WHERE   1 = 1 " ).append("\n"); 
		query.append("#if (${is_multi_rows} != 'T') " ).append("\n"); 
		query.append("					AND ACT_RCV_DT = @[act_rcv_dt] AND ACT_RCV_NO = @[act_rcv_no]" ).append("\n"); 
		query.append("#end					" ).append("\n"); 
		query.append("		      		AND ACT_UMCH_TP_CD = 'XX' " ).append("\n"); 
		query.append("			 		AND ROWNUM = 1" ).append("\n"); 
		query.append("		  ) TGT, " ).append("\n"); 
		query.append("		  bkg_booking bkg," ).append("\n"); 
		query.append("		  BKG_BL_DOC bkgd," ).append("\n"); 
		query.append("		  BKG_CUSTOMER bkgc, " ).append("\n"); 
		query.append("		  BKG_CONTAINER cntr, " ).append("\n"); 
		query.append("		  BKG_CNTR_SEAL_NO cntrs, " ).append("\n"); 
		query.append("		  --TRS_TRSP_SO_PKUP_CNTR trs, " ).append("\n"); 
		query.append("		  ( " ).append("\n"); 
		query.append("		    select bkg_no, " ).append("\n"); 
		query.append("		      max(decode(port_id_cd, 'POL', eta_lmt, '')) as pol_eta_lmt, " ).append("\n"); 
		query.append("		      max(decode(port_id_cd, 'POL', eta_gmt, '')) as pol_eta_gmt, " ).append("\n"); 
		query.append("		      max(decode(port_id_cd, 'POL', etd_lmt, '')) as pol_etd_lmt, " ).append("\n"); 
		query.append("		      max(decode(port_id_cd, 'POL', etd_gmt, '')) as pol_etd_gmt, " ).append("\n"); 
		query.append("		      max(decode(port_id_cd, 'POD', eta_lmt, '')) as pod_eta_lmt, " ).append("\n"); 
		query.append("		      max(decode(port_id_cd, 'POD', eta_gmt, '')) as pod_eta_gmt, " ).append("\n"); 
		query.append("		      max(decode(port_id_cd, 'POD', etd_lmt, '')) as pod_etd_lmt, " ).append("\n"); 
		query.append("		      max(decode(port_id_cd, 'POD', etd_gmt, '')) as pod_etd_gmt " ).append("\n"); 
		query.append("		    from ( " ).append("\n"); 
		query.append("		        select bkg.bkg_no, " ).append("\n"); 
		query.append("		          bkg.pol_cd as port_cd, " ).append("\n"); 
		query.append("		          'POL' as port_id_cd, " ).append("\n"); 
		query.append("		          TO_CHAR(vsk.VPS_ETA_DT, 'YYYYMMDDHH24MI') as ETA_LMT, " ).append("\n"); 
		query.append("		          TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC(vsk.VPS_PORT_CD, vsk.VPS_ETA_DT, 'GMT'), 'YYYYMMDDHH24MI') AS ETA_GMT, " ).append("\n"); 
		query.append("		          TO_CHAR(vsk.VPS_ETD_DT, 'YYYYMMDDHH24MI') AS ETD_LMT, " ).append("\n"); 
		query.append("		          TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC(vsk.VPS_PORT_CD, vsk.VPS_ETD_DT, 'GMT'), 'YYYYMMDDHH24MI') AS ETD_GMT " ).append("\n"); 
		query.append("		        from bkg_booking bkg, " ).append("\n"); 
		query.append("		          BKG_CUSTOMER bkgc," ).append("\n"); 
		query.append("		          sce_cntr_sts_msg_tgt tgt, " ).append("\n"); 
		query.append("		          BKG_VVD vvd, " ).append("\n"); 
		query.append("		          vsk_vsl_port_skd vsk " ).append("\n"); 
		query.append("		        where " ).append("\n"); 
		query.append("		        " ).append("\n"); 
		query.append("#if (${is_multi_rows} != 'T') " ).append("\n"); 
		query.append("					ACT_RCV_DT = @[act_rcv_dt] AND ACT_RCV_NO = @[act_rcv_no] AND		" ).append("\n"); 
		query.append("#end		" ).append("\n"); 
		query.append("						" ).append("\n"); 
		query.append("		      		act_umch_tp_cd = 'XX' " ).append("\n"); 
		query.append("		          and bkg.bkg_no = tgt.bkg_no " ).append("\n"); 
		query.append("		          and bkg.bkg_no = vvd.bkg_no " ).append("\n"); 
		query.append("		          AND BKGC.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("		          AND BKGC.BKG_CUST_TP_CD = 'C'" ).append("\n"); 
		query.append("		          and vvd.vsl_cd = vsk.vsl_cd (+) " ).append("\n"); 
		query.append("		          and vvd.skd_voy_no = vsk.skd_voy_no (+) " ).append("\n"); 
		query.append("		          and vvd.skd_dir_cd = vsk.skd_dir_cd (+) " ).append("\n"); 
		query.append("		          and vvd.pod_cd = vsk.vps_port_cd (+) " ).append("\n"); 
		query.append("		          and bkg.pol_cd = vvd.pod_cd " ).append("\n"); 
		query.append("		        union all " ).append("\n"); 
		query.append("		        select bkg.bkg_no, " ).append("\n"); 
		query.append("		          bkg.pod_cd as port_cd, " ).append("\n"); 
		query.append("		          'POD' as port_ind_cd, " ).append("\n"); 
		query.append("		          TO_CHAR(vsk.VPS_ETA_DT, 'YYYYMMDDHH24MI') as ETA_LMT, " ).append("\n"); 
		query.append("		          TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC(vsk.VPS_PORT_CD, vsk.VPS_ETA_DT, 'GMT'), 'YYYYMMDDHH24MI') AS eta_gmt, " ).append("\n"); 
		query.append("		          TO_CHAR(vsk.VPS_ETD_DT, 'YYYYMMDDHH24MI') AS ETD_LMT, " ).append("\n"); 
		query.append("		          TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC(vsk.VPS_PORT_CD, vsk.VPS_ETD_DT, 'GMT'), 'YYYYMMDDHH24MI') AS etd_gmt " ).append("\n"); 
		query.append("		        from bkg_booking bkg, " ).append("\n"); 
		query.append("		          BKG_CUSTOMER bkgc," ).append("\n"); 
		query.append("		          sce_cntr_sts_msg_tgt tgt, " ).append("\n"); 
		query.append("		          BKG_VVD vvd, " ).append("\n"); 
		query.append("		          vsk_vsl_port_skd vsk " ).append("\n"); 
		query.append("		    	 where " ).append("\n"); 
		query.append("		    	 " ).append("\n"); 
		query.append("#if (${is_multi_rows} != 'T') " ).append("\n"); 
		query.append("					ACT_RCV_DT = @[act_rcv_dt] AND ACT_RCV_NO = @[act_rcv_no] AND		" ).append("\n"); 
		query.append("#end	" ).append("\n"); 
		query.append("					" ).append("\n"); 
		query.append("		      	   act_umch_tp_cd = 'XX' " ).append("\n"); 
		query.append("		          and bkg.bkg_no = tgt.bkg_no " ).append("\n"); 
		query.append("		          and bkg.bkg_no = vvd.bkg_no " ).append("\n"); 
		query.append("		          AND BKGC.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("		          AND BKGC.BKG_CUST_TP_CD = 'C'		          " ).append("\n"); 
		query.append("		          and vvd.vsl_cd = vsk.vsl_cd (+) " ).append("\n"); 
		query.append("		          and vvd.skd_voy_no = vsk.skd_voy_no (+) " ).append("\n"); 
		query.append("		          and vvd.skd_dir_cd = vsk.skd_dir_cd (+) " ).append("\n"); 
		query.append("		          and vvd.pod_cd = vsk.vps_port_cd (+) " ).append("\n"); 
		query.append("		          and bkg.pod_cd = vvd.pod_cd ) " ).append("\n"); 
		query.append("		    group by bkg_no ) dinfo, " ).append("\n"); 
		query.append("		  mdm_location por, " ).append("\n"); 
		query.append("		  mdm_location pol, " ).append("\n"); 
		query.append("		  mdm_location pod, " ).append("\n"); 
		query.append("		  mdm_location del, " ).append("\n"); 
		query.append("		  mdm_location rly, " ).append("\n"); 
		query.append("		  mdm_yard yd, " ).append("\n"); 
		query.append("		  mdm_location yd_rl, " ).append("\n"); 
		query.append("		  mdm_vsl_cntr vsl," ).append("\n"); 
		query.append("          MDM_CNTR_TP_SZ mcts " ).append("\n"); 
		query.append("		where tgt.bkg_no = bkg.bkg_no " ).append("\n"); 
		query.append("		  and tgt.bkg_no = cntr.bkg_no " ).append("\n"); 
		query.append("		  and tgt.cntr_no = cntr.cntr_no " ).append("\n"); 
		query.append("		  and cntr.bkg_no = cntrs.bkg_no(+)" ).append("\n"); 
		query.append("		  and cntr.cntr_no = cntrs.cntr_no(+)" ).append("\n"); 
		query.append("		  and cntrs.cntr_seal_seq(+) = 1" ).append("\n"); 
		query.append("		  and bkgd.bkg_no = bkg.bkg_no" ).append("\n"); 
		query.append("		  and bkgc.bkg_no = bkg.bkg_no" ).append("\n"); 
		query.append("		  and bkgc.bkg_cust_tp_cd = 'C'" ).append("\n"); 
		query.append("		  --and tgt.cntr_no = trs.cntr_no (+) " ).append("\n"); 
		query.append("		  --and tgt.bkg_no = trs.bkg_no (+) " ).append("\n"); 
		query.append("		  and tgt.bkg_no = dinfo.bkg_no " ).append("\n"); 
		query.append("		  and bkg.por_cd = por.loc_cd (+) " ).append("\n"); 
		query.append("		  and bkg.pol_cd = pol.loc_cd (+) " ).append("\n"); 
		query.append("		  and bkg.pod_cd = pod.loc_cd (+) " ).append("\n"); 
		query.append("		  and bkg.del_cd = del.loc_cd (+) " ).append("\n"); 
		query.append("		  and tgt.nod_cd = yd.yd_cd (+) " ).append("\n"); 
		query.append("		  and bkg.PRE_RLY_PORT_CD = rly.loc_cd (+) " ).append("\n"); 
		query.append("		  and yd.loc_cd = yd_rl.loc_cd " ).append("\n"); 
		query.append("		  and vsl.vsl_cd (+) = tgt.vsl_cd " ).append("\n"); 
		query.append("          and cntr.cntr_tpsz_cd = mcts.cntr_tpsz_cd(+)  " ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}