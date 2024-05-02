/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : CSMSendEurDBDAOAddFlatFileCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.19
*@LastModifier : 홍성필
*@LastVersion : 1.0
* 2017.01.19 홍성필
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.csmsendeur.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Hong Seong Pil
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CSMSendEurDBDAOAddFlatFileCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AddFlatFile
	  * </pre>
	  */
	public CSMSendEurDBDAOAddFlatFileCSQL(){
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
		params.put("flt_file_ref_no",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.esd.sce.csmsendeur.integration").append("\n"); 
		query.append("FileName : CSMSendEurDBDAOAddFlatFileCSQL").append("\n"); 
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
		query.append("INSERT INTO SCE_CSM_FLT_FILE_EUR ( " ).append("\n"); 
		query.append("EDI_SND_YRMONDY, --to_char(sysdate, 'yymmdd')" ).append("\n"); 
		query.append("EDI_SND_SEQ, --sce_csm_flt_file_seq1.nextval" ).append("\n"); 
		query.append("CSM_CNT_CD, -- 추가" ).append("\n"); 
		query.append("EDI_SND_DESC, " ).append("\n"); 
		query.append("EDI_STS_CD, " ).append("\n"); 
		query.append("BL_NO, " ).append("\n"); 
		query.append("BKG_NO, " ).append("\n"); 
		query.append("CRE_USR_ID, " ).append("\n"); 
		query.append("CRE_DT, " ).append("\n"); 
		query.append("UPD_USR_ID, " ).append("\n"); 
		query.append("UPD_DT, " ).append("\n"); 
		query.append("ACT_RCV_DT, " ).append("\n"); 
		query.append("ACT_RCV_NO " ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append("( " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		select /*+ index_asc (SCE_CSM_TGT_EUR XPKSCE_CSM_TGT_EUR) */ " ).append("\n"); 
		query.append("		@[edi_snd_yrmondy],  --to_char(sysdate, 'yymmdd')" ).append("\n"); 
		query.append("		@[edi_snd_seq],  --sce_csm_flt_file_seq1.nextval" ).append("\n"); 
		query.append("        tgt.CSM_CNT_CD," ).append("\n"); 
		query.append("		'$$$MSGSTART:'||RPAD('SMLM', 20, ' ')||RPAD('EU_OLAF', 20, ' ')||RPAD('CSM315', 10, ' ')||@[flt_file_ref_no]||chr(13)||chr(10) ||  --to_char(sysdate, 'yymmdd'), sce_csm_flt_file_seq1.nextval" ).append("\n"); 
		query.append("		'MUID : ' || to_char(sysdate, 'yyyymmddhh24miss') || chr(13) || chr(10) || " ).append("\n"); 
		query.append("		'SNDID : ' || 'SMLM' || chr(13) || chr(10) || " ).append("\n"); 
		query.append("		'RCVID : ' || 'EU_OLAF' || chr(13) || chr(10) || " ).append("\n"); 
		query.append("		'322ID : ' || @[stnd_edi_sts_cd] || chr(13) || chr(10) ||  -- mapg.stnd_edi_sts_cd" ).append("\n"); 
		query.append("		'MSGID : ' || tgt.act_sts_mapg_cd || chr(13) || chr(10) || " ).append("\n"); 
		query.append("		'VIP_GRP_ID : ' || chr(13) || chr(10) || 					                                 " ).append("\n"); 
		query.append("		'BL NBR : ' || bkg.bl_no||bkg.bl_tp_cd || chr(13) || chr(10) ||                                                       " ).append("\n"); 
		query.append("		'BKG NBR : ' || bkg.bkg_no|| chr(13) || chr(10) ||  " ).append("\n"); 
		query.append("		'TO VSL CODE : ' || chr(13) || chr(10) || " ).append("\n"); 
		query.append("		'TO VOYAGE : ' || chr(13) || chr(10) || " ).append("\n"); 
		query.append("		'TO DIR : ' || chr(13) || chr(10) || " ).append("\n"); 
		query.append("		'VSL NAME : ' || chr(13) || chr(10) || " ).append("\n"); 
		query.append("		'VSL CNTR CODE : ' || chr(13) || chr(10) || " ).append("\n"); 
		query.append("		'POR NAME : ' || por.loc_nm || chr(13) || chr(10) ||                                                                       " ).append("\n"); 
		query.append("		'POR CODE : ' || bkg.por_cd || chr(13) || chr(10) ||                                                                        " ).append("\n"); 
		query.append("		'POR AMSQUAL : ' || decode(por.cnt_cd, 'US', 'D', 'K') || chr(13) || chr(10) ||                                       " ).append("\n"); 
		query.append("		'POR AMSPORT : ' || por.LOC_AMS_PORT_CD || chr(13) || chr(10) ||                                                          " ).append("\n"); 
		query.append("		'PORETD : ' || CHR(13) || chr(10) ||                                                                          " ).append("\n"); 
		query.append("		'PORETD_GMT : ' || chr(13) || chr(10) ||                                                                          " ).append("\n"); 
		query.append("		'PORATD : ' || chr(13) || chr(10) || " ).append("\n"); 
		query.append("		'PORATD_GMT : ' || chr(13) || chr(10) || " ).append("\n"); 
		query.append("		'POL NAME : ' || pol.loc_nm || chr(13) || chr(10) || " ).append("\n"); 
		query.append("		'POL CODE : ' || bkg.pol_cd || chr(13) || chr(10) || " ).append("\n"); 
		query.append("		'POL AMSQUAL : ' || decode(pol.cnt_cd, 'US', 'D', 'K') || chr(13) || chr(10) || " ).append("\n"); 
		query.append("		'POL AMSPORT : ' || pol.LOC_AMS_PORT_CD || chr(13) || chr(10) ||                                                 " ).append("\n"); 
		query.append("		'POLETA : ' || dinfo.pol_eta_lmt || chr(13) || chr(10) || " ).append("\n"); 
		query.append("		'POLETA_GMT : ' || dinfo.pol_eta_gmt || chr(13) || chr(10) || " ).append("\n"); 
		query.append("		'POLATA : ' || chr(13) || chr(10) || " ).append("\n"); 
		query.append("		'POLATA_GMT : ' || chr(13) || chr(10) || " ).append("\n"); 
		query.append("		'POLETD : ' || dinfo.pol_etd_lmt || chr(13) || chr(10) || " ).append("\n"); 
		query.append("		'POLETD_GMT : ' || dinfo.pol_etd_gmt || chr(13) || chr(10) || " ).append("\n"); 
		query.append("		'POLATD : ' || chr(13) || chr(10) || " ).append("\n"); 
		query.append("		'POLATD_GMT : ' || chr(13) || chr(10) || " ).append("\n"); 
		query.append("		'POD NAME : ' || pod.loc_nm || chr(13) || chr(10) || " ).append("\n"); 
		query.append("		'POD CODE : ' || bkg.pod_cd || chr(13) || chr(10) ||                                                                     " ).append("\n"); 
		query.append("		'POD AMSQUAL : ' || decode(pod.cnt_cd, 'US', 'D', 'K') || chr(13) || chr(10) ||                                    " ).append("\n"); 
		query.append("		'POD AMSPORT : ' || pod.LOC_AMS_PORT_CD || chr(13) || chr(10) ||                                                           " ).append("\n"); 
		query.append("		'PODETA : ' || dinfo.pod_eta_lmt || chr(13) || chr(10) ||                                                              " ).append("\n"); 
		query.append("		'PODETA_GMT : ' || dinfo.pod_eta_gmt || chr(13) || chr(10) ||                                                               " ).append("\n"); 
		query.append("		'PODATA : ' || chr(13) || chr(10) || " ).append("\n"); 
		query.append("		'PODATA_GMT : ' || chr(13) || chr(10) || " ).append("\n"); 
		query.append("		'PODETD : ' || chr(13) || chr(10) || " ).append("\n"); 
		query.append("		'PODETD_GMT : ' || chr(13) || chr(10) || " ).append("\n"); 
		query.append("		'PODATD : ' || chr(13) || chr(10) || " ).append("\n"); 
		query.append("		'PODATD_GMT : ' || chr(13) || chr(10) || " ).append("\n"); 
		query.append("		'DEL NAME : ' || del.loc_nm  || chr(13) || chr(10) ||                                                                        " ).append("\n"); 
		query.append("		'DEL CODE : ' || bkg.del_cd  || chr(13) || chr(10) ||                                                                        " ).append("\n"); 
		query.append("		'DEL AMSQUAL : ' || decode(del.cnt_cd, 'US', 'D', 'K')  || chr(13) || chr(10) ||                                             " ).append("\n"); 
		query.append("		'DEL AMSPORT : ' || del.LOC_AMS_PORT_CD || chr(13) || chr(10) ||                                                            " ).append("\n"); 
		query.append("		'DELETA : ' || chr(13) || chr(10) ||                                                                                  " ).append("\n"); 
		query.append("		'DELETA_GMT : ' || chr(13) || chr(10) ||                                                                              " ).append("\n"); 
		query.append("		'DELATA : ' || chr(13) || chr(10) ||                                                                                  " ).append("\n"); 
		query.append("		'DELATA_GMT : ' || chr(13) || chr(10) ||                                                                              " ).append("\n"); 
		query.append("		'FRD NAME : ' || chr(13) || chr(10) || " ).append("\n"); 
		query.append("		'FRD CODE : ' || chr(13) || chr(10) || " ).append("\n"); 
		query.append("		'FRDETA : ' || chr(13) || chr(10) || " ).append("\n"); 
		query.append("		'FRDETA_GMT : ' || chr(13) || chr(10) || " ).append("\n"); 
		query.append("		'RLY NAME : ' || rly.loc_nm || chr(13) || chr(10) ||                                                                        " ).append("\n"); 
		query.append("		'RLY CODE : ' || bkg.PRE_RLY_PORT_CD || chr(13) || chr(10) ||                                                               " ).append("\n"); 
		query.append("		'RLY AMSQUAL : ' || decode(rly.cnt_cd, 'US', 'D', 'K') || chr(13) || chr(10) ||                                             " ).append("\n"); 
		query.append("		'RLY AMSPORT : ' || rly.LOC_AMS_PORT_CD || chr(13) || chr(10) ||                                                            " ).append("\n"); 
		query.append("		'W_UNIT : ' || bkgd.WGT_UT_CD || chr(13) || chr(10) ||              --**BKG_BL_DOC                                                         " ).append("\n"); 
		query.append("		'WEIGHT : ' || bkgd.ACT_WGT || chr(13) || chr(10) ||                --**BKG_BL_DOC                                                                     " ).append("\n"); 
		query.append("		'MEA_UNIT : ' || chr(13) || chr(10) || " ).append("\n"); 
		query.append("		'MEA_QTY : ' || chr(13) || chr(10) || " ).append("\n"); 
		query.append("		'P_UNIT : ' || bkgd.PCK_TP_CD || chr(13) || chr(10) ||              --**BKG_BL_DOC                                                         " ).append("\n"); 
		query.append("		'PACKAGE : ' || bkgd.pck_qty || chr(13) || chr(10) ||               --**BKG_BL_DOC                                                         " ).append("\n"); 
		query.append("		'CNTR NBR : ' || tgt.cntr_no || chr(13) || chr(10) ||                                                                       " ).append("\n"); 
		query.append("		'CNTR TYPE : ' || cntr.CNTR_TPSZ_CD || chr(13) || chr(10) ||        --**BKG_CONTAINER" ).append("\n"); 
		query.append("		'F/M IND : ' || bkg.bkg_cgo_tp_cd || chr(13) || chr(10) ||                                                                   " ).append("\n"); 
		query.append("		'EVENT DATE : ' || TO_CHAR(TGT.ACT_DT, 'YYYYMMDDHH24MI') || chr(13) || chr(10) ||                                                                          " ).append("\n"); 
		query.append("		'EVENT DATE_GMT : ' || TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC(tgt.nod_cd, tgt.act_dt, 'GMT'), 'YYYYMMDDHH24MI') || chr(13) || chr(10) ||                 " ).append("\n"); 
		query.append("		'CUST_REF_NO : ' || BKGC.ref_no || chr(13) || chr(10) ||               --**BKG_CUSTOMER                                                          " ).append("\n"); 
		query.append("		'LLOYD_CODE : ' || chr(13) || chr(10) || " ).append("\n"); 
		query.append("		'EVENT_LOC : ' ||  tgt.nod_cd || chr(13) || chr(10) ||                                                                       " ).append("\n"); 
		query.append("		'EVENT_LOC_NAME : ' || yd.yd_nm || chr(13) || chr(10) ||                                                                                                            " ).append("\n"); 
		query.append("		'EVENT_LOC_AMSQUAL : ' || decode(yd_rl.cnt_cd, 'US', 'D', 'K')  || chr(13) || chr(10) ||                                              " ).append("\n"); 
		query.append("		'EVENT_LOC_AMSPORT : ' ||	yd_rl.LOC_AMS_PORT_CD  || chr(13) || chr(10) || " ).append("\n"); 
		query.append("		'PO NBR : ' || chr(13) || chr(10) || " ).append("\n"); 
		query.append("		'BL_PO_NBR : ' || chr(13) || chr(10) || " ).append("\n"); 
		query.append("		'CNTR_PO_NBR : ' || chr(13) || chr(10) || " ).append("\n"); 
		query.append("		'BL_STORE_NBR : ' || chr(13) || chr(10) || " ).append("\n"); 
		query.append("		'SHPRCODE : ' || chr(13) || chr(10) || " ).append("\n"); 
		query.append("		'SHPR1 : ' || chr(13) || chr(10) || " ).append("\n"); 
		query.append("		'SHPR2 : ' || chr(13) || chr(10) || " ).append("\n"); 
		query.append("		'SHPR3 : ' || chr(13) || chr(10) || " ).append("\n"); 
		query.append("		'SHPR4 : ' || chr(13) || chr(10) || " ).append("\n"); 
		query.append("		'SHPR5 : ' || chr(13) || chr(10) || " ).append("\n"); 
		query.append("		'SHPR_CITY_NM : ' || chr(13) || chr(10) || " ).append("\n"); 
		query.append("		'SHPR_STAT_CD : ' || chr(13) || chr(10) || " ).append("\n"); 
		query.append("		'SHPR_ZIP_CD : ' || chr(13) || chr(10) || " ).append("\n"); 
		query.append("		'SHPR_CNT_CD : ' || chr(13) || chr(10) || " ).append("\n"); 
		query.append("		'CNEECODE : ' || chr(13) || chr(10) || " ).append("\n"); 
		query.append("		'CNEE1 : ' || chr(13) || chr(10) || " ).append("\n"); 
		query.append("		'CNEE2 : ' || chr(13) || chr(10) || " ).append("\n"); 
		query.append("		'CNEE3 : ' || chr(13) || chr(10) || " ).append("\n"); 
		query.append("		'CNEE4 : ' || chr(13) || chr(10) || " ).append("\n"); 
		query.append("		'CNEE5 : ' || chr(13) || chr(10) || " ).append("\n"); 
		query.append("		'CNEE_CITY_NM : ' || chr(13) || chr(10) || " ).append("\n"); 
		query.append("		'CNEE_STAT_CD : ' || chr(13) || chr(10) || " ).append("\n"); 
		query.append("		'CNEE_ZIP_CD : ' || chr(13) || chr(10) || " ).append("\n"); 
		query.append("		'CNEE_CNT_CD : ' || chr(13) || chr(10) || " ).append("\n"); 
		query.append("		'NTFYCODE : ' || chr(13) || chr(10) || " ).append("\n"); 
		query.append("		'NTFY1 : ' || chr(13) || chr(10) || " ).append("\n"); 
		query.append("		'NTFY2 : ' || chr(13) || chr(10) || " ).append("\n"); 
		query.append("		'NTFY3 : ' || chr(13) || chr(10) || " ).append("\n"); 
		query.append("		'NTFY4 : ' || chr(13) || chr(10) || " ).append("\n"); 
		query.append("		'NTFY5 : ' || chr(13) || chr(10) || " ).append("\n"); 
		query.append("		'NTFY_CITY_NM : ' || chr(13) || chr(10) || " ).append("\n"); 
		query.append("		'NTFY_STAT_CD : ' || chr(13) || chr(10) || " ).append("\n"); 
		query.append("		'NTFY_ZIP_CD : ' || chr(13) || chr(10) || " ).append("\n"); 
		query.append("		'NTFY_CNT_CD : ' || chr(13) || chr(10) || " ).append("\n"); 
		query.append("		'REF_CUSTCODE : ' || chr(13) || chr(10) || " ).append("\n"); 
		query.append("		'INV_NBR : ' || chr(13) || chr(10) || " ).append("\n"); 
		query.append("		'RD_TERM : ' || chr(13) || chr(10) || " ).append("\n"); 
		query.append("		'CUST_EDATE : ' || chr(13) || chr(10) || " ).append("\n"); 
		query.append("		'CUST_EDATE_GMT : ' || chr(13) || chr(10) || " ).append("\n"); 
		query.append("		'CUST_ADATE : ' || chr(13) || chr(10) || " ).append("\n"); 
		query.append("		'CUST_ADATE_GMT : ' || chr(13) || chr(10) || " ).append("\n"); 
		query.append("		'CURRENT_VVD : ' || decode(tgt.vsl_cd, null, null, tgt.vsl_cd || tgt.skd_voy_no || tgt.skd_dir_cd)  || chr(13) || chr(10) || " ).append("\n"); 
		query.append("		'CURRENT_VSL_NM : ' || REPLACE(vsl.VSL_ENG_NM, CHR(39), ' ')  || chr(13) || chr(10) ||                                       " ).append("\n"); 
		query.append("		'CURRENT_VSL_CNT_CD : ' || VSL_RGST_CNT_CD  || chr(13) || chr(10) ||                                                         " ).append("\n"); 
		query.append("		'CURRENT_LLOYD_CD : ' || nvl(decode(LLOYD_NO, 'T.B.N.', 'TBN', 'T.B.N', 'TBN', VSL.LLOYD_NO), ' ')  || chr(13) || chr(10) ||                 " ).append("\n"); 
		query.append("		'SEL NBR : ' || REPLACE(NVL(cntrs.CNTR_SEAL_NO, ' '), '')  || chr(13) || chr(10) ||           --**BKG_CNTR_SEAL_NO              " ).append("\n"); 
		query.append("		'LANE : ' || chr(13) || chr(10) ||                  " ).append("\n"); 
		query.append("		'LANE_DESC : ' || chr(13) || chr(10) || " ).append("\n"); 
		query.append("		'SC NBR : ' || chr(13) || chr(10) || " ).append("\n"); 
		query.append("		'IT NBR : ' || chr(13) || chr(10) || " ).append("\n"); 
		query.append("		'PICKUP NBR : ' || (select pkup_no from bkg_pkup_ntc_pkup_no where bkg_no = bkg.bkg_no and cntr_no = tgt.cntr_no and rownum = 1) || chr(13) || chr(10) ||                                                                          " ).append("\n"); 
		query.append("		'SH REF NBR : ' || chr(13) || chr(10) || " ).append("\n"); 
		query.append("		'FW REF NBR : ' || chr(13) || chr(10) || " ).append("\n"); 
		query.append("		'{BKGVVD' || chr(13) || chr(10) || " ).append("\n"); 
		query.append("		'BVVD1:' || chr(13) || chr(10) || " ).append("\n"); 
		query.append("		'VSL_CALLSIGN1:' || chr(13) || chr(10) || " ).append("\n"); 
		query.append("		'VSL_LLOYDCODE1:' || chr(13) || chr(10) ||  " ).append("\n"); 
		query.append("		'VSL_FULLNAME1:' || chr(13) || chr(10) || " ).append("\n"); 
		query.append("		'BLPOL1:' || chr(13) || chr(10) || " ).append("\n"); 
		query.append("		'POL_FULLNAME1:' || chr(13) || chr(10) || " ).append("\n"); 
		query.append("		'BLPOD1:' || chr(13) || chr(10) || " ).append("\n"); 
		query.append("		'POD_FULLNAME1:' || chr(13) || chr(10) || " ).append("\n"); 
		query.append("		'POLETA1:' || chr(13) || chr(10) || " ).append("\n"); 
		query.append("		'POLETA1_GMT:' || chr(13) || chr(10) || " ).append("\n"); 
		query.append("		'POLATA1:' || chr(13) || chr(10) || " ).append("\n"); 
		query.append("		'POLATA1_GMT:' || chr(13) || chr(10) || " ).append("\n"); 
		query.append("		'POLETD1:' || chr(13) || chr(10) || " ).append("\n"); 
		query.append("		'POLETD1_GMT:' || chr(13) || chr(10) || " ).append("\n"); 
		query.append("		'POLATD1:' || chr(13) || chr(10) || " ).append("\n"); 
		query.append("		'POLATD1_GMT:' || chr(13) || chr(10) || " ).append("\n"); 
		query.append("		'PODETA1:' || chr(13) || chr(10) || " ).append("\n"); 
		query.append("		'PODETA1_GMT:' || chr(13) || chr(10) || " ).append("\n"); 
		query.append("		'PODATA1:' || chr(13) || chr(10) || " ).append("\n"); 
		query.append("		'PODATA1_GMT:' || chr(13) || chr(10) || " ).append("\n"); 
		query.append("		'PODETD1:' || chr(13) || chr(10) || " ).append("\n"); 
		query.append("		'PODETD1_GMT:' || chr(13) || chr(10) || " ).append("\n"); 
		query.append("		'PODATD1:' || chr(13) || chr(10) || " ).append("\n"); 
		query.append("		'PODATD1_GMT:' || chr(13) || chr(10) || " ).append("\n"); 
		query.append("		'}BKGVVD' || chr(13) || chr(10), " ).append("\n"); 
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
		query.append("				  CNTR_NO," ).append("\n"); 
		query.append(" 				  CSM_CNT_CD, " ).append("\n"); 
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
		query.append("				  UPD_DT " ).append("\n"); 
		query.append("				FROM SCE_CSM_TGT_EUR" ).append("\n"); 
		query.append("		    	WHERE " ).append("\n"); 
		query.append("		    	" ).append("\n"); 
		query.append("#if (${is_multi_rows} != 'T') " ).append("\n"); 
		query.append("					ACT_RCV_DT = @[act_rcv_dt] AND ACT_RCV_NO = @[act_rcv_no] AND		" ).append("\n"); 
		query.append("#end					" ).append("\n"); 
		query.append("		      ACT_UMCH_TP_CD = 'XX' ) TGT, " ).append("\n"); 
		query.append("		  bkg_booking bkg," ).append("\n"); 
		query.append("		  BKG_BL_DOC bkgd," ).append("\n"); 
		query.append("		  BKG_CUSTOMER bkgc," ).append("\n"); 
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
		query.append("		          sce_csm_tgt_eur tgt, " ).append("\n"); 
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
		query.append("		          sce_csm_tgt_eur tgt, -- 구주 타겟" ).append("\n"); 
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
		query.append("		  mdm_vsl_cntr vsl " ).append("\n"); 
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
		query.append("  " ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}