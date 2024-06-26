/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOsearchBkgMkFileRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.03
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.03 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOsearchBkgMkFileRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ...
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOsearchBkgMkFileRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_msg_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_eta_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("final_eta_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_snp_snd_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vps_etd_dt_gmt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsk_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("init_etd_dt_gmt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ref_number",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_dspo_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("init_etd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_snd_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_eta_dt_gmt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("new_cstms_clr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_rcv_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsk_vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_snp_rcv_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("po_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("init_eta_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_etd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("init_eta_dt_gmt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsk_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("final_eta_dt_gmt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOsearchBkgMkFileRSQL").append("\n"); 
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
		query.append("SELECT  /*+ INDEX_ASC(F XPKBKG_CSTMS_ADV_CNTR) */" ).append("\n"); 
		query.append("       '$$$MSGSTART:'||RPAD(@[edi_snd_id],20)||RPAD(@[edi_rcv_id],20)||RPAD('TDC315',10) ||" ).append("\n"); 
		query.append("       @[ref_number] || CHR(10) || " ).append("\n"); 
		query.append("       'MUID:'              || TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC(COM_ConstantMgr_PKG.COM_getBaseLocationCode_FNC,SYSDATE,'USNYC'), 'yyyymmddhh24mi')  || CHR(10) ||" ).append("\n"); 
		query.append("       'SNDID:'             || @[edi_snd_id]                         || CHR(10) ||" ).append("\n"); 
		query.append("       'RCVID:'             || DECODE(@[edi_rcv_id],'PA','TRADIANT','PQ','TRADIANT',@[edi_rcv_id]) || CHR(10) ||" ).append("\n"); 
		query.append("       '322ID:'             || DECODE(CG.CSTMS_CLR_LST_DT,NULL,'',DECODE(@[new_cstms_clr_cd],'P','Y',@[new_cstms_clr_cd])) || CHR(10) ||" ).append("\n"); 
		query.append("       'MSGID:'             || @[edi_msg_id]                         || CHR(10) FLAT_FILE_HEADER," ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       '$$$MSGSTART:'||RPAD(@[edi_snp_snd_id],20)||RPAD(@[edi_snp_rcv_id],20)||RPAD('TDC315',10) ||" ).append("\n"); 
		query.append("       @[ref_number] || CHR(10) || " ).append("\n"); 
		query.append("       'MUID:'              || TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC(COM_ConstantMgr_PKG.COM_getBaseLocationCode_FNC,SYSDATE,'USNYC'), 'yyyymmddhh24mi')  || CHR(10) ||" ).append("\n"); 
		query.append("       'SNDID:'             || @[edi_snp_snd_id]                             || CHR(10) ||" ).append("\n"); 
		query.append("       'RCVID:'             || @[edi_snp_rcv_id] || CHR(10) ||" ).append("\n"); 
		query.append("       '322ID:'             || DECODE(CG.CSTMS_CLR_LST_DT,NULL,'',DECODE(@[new_cstms_clr_cd],'P','Y',@[new_cstms_clr_cd])) || CHR(10) ||" ).append("\n"); 
		query.append("       'MSGID:'             || @[edi_msg_id]                         || CHR(10) SNP_FILE_HEADER,  /* 추가 Inalnd 에 보낼때 사용 */" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       'VIP_GRP_ID:'                                           || chr(10) ||" ).append("\n"); 
		query.append("       'BL_NBR:'        || @[bl_no]                             || chr(10) ||" ).append("\n"); 
		query.append("       'BKG_NBR:'       || @[bkg_no]                            || chr(10) ||" ).append("\n"); 
		query.append("       'TO_VSL_CODE:'   || SUBSTR(@[vsk_vvd_cd], 1, 4)              || chr(10) ||" ).append("\n"); 
		query.append("       'TO_VOYAGE:'     || SUBSTR(@[vsk_vvd_cd], 5, 4)              || chr(10) ||" ).append("\n"); 
		query.append("       'TO_DIR:'        || SUBSTR(@[vsk_vvd_cd], 9, 1)              || chr(10) ||" ).append("\n"); 
		query.append("       'TO_CONSORT_VOY:' || NVL(X.IB_CSSM_VOY_NO, ' ')          || CHR(10) ||" ).append("\n"); 
		query.append("       'VSL_NAME:'      || NVL(C.VSL_ENG_NM, ' ')              || chr(10) ||" ).append("\n"); 
		query.append("       'VSL_CNTR_CODE:' || NVL(C.VSL_RGST_CNT_CD, ' ')         || chr(10) ||" ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       'POR_NAME:'      || LA.LOC_NM                           || chr(10) ||" ).append("\n"); 
		query.append("       'POR_CODE:'      || LA.LOC_CD                           || chr(10) ||" ).append("\n"); 
		query.append("       'POR_AMSQUAL:'   || decode(LA.CNT_CD, 'US', 'D', 'K')   || chr(10) ||" ).append("\n"); 
		query.append("       'POR_AMSPORT:'   || LA.LOC_AMS_PORT_CD                  || chr(10) ||" ).append("\n"); 
		query.append("       'PORETD:'                                               || chr(10) ||" ).append("\n"); 
		query.append("       'PORETD_GMT:'                                           || chr(10) ||" ).append("\n"); 
		query.append("       'PORATD:'                                               || chr(10) ||" ).append("\n"); 
		query.append("       'PORATD_GMT:'                                           || chr(10) ||" ).append("\n"); 
		query.append("       'POL_NAME:'      || LB.LOC_NM                           || chr(10) ||" ).append("\n"); 
		query.append("       'POL_CODE:'      || LB.LOC_CD                           || chr(10) ||" ).append("\n"); 
		query.append("       'POL_AMSQUAL:'   || decode(LB.CNT_CD, 'US', 'D', 'K')   || chr(10) ||" ).append("\n"); 
		query.append("       'POL_AMSPORT:'   || LB.LOC_AMS_PORT_CD                  || chr(10) ||" ).append("\n"); 
		query.append("       'POLETA:'                                               || chr(10) ||" ).append("\n"); 
		query.append("       'POLETA_GMT:'                                           || chr(10) ||" ).append("\n"); 
		query.append("       'POLATA:'                                               || chr(10) ||" ).append("\n"); 
		query.append("       'POLATA_GMT:'                                           || chr(10) ||" ).append("\n"); 
		query.append("       'POLETD:'        || @[vps_etd_dt]                         || chr(10) ||" ).append("\n"); 
		query.append("       'POLETD_GMT:'    || @[vps_etd_dt_gmt]                      || chr(10) ||" ).append("\n"); 
		query.append("       'POLATD:'        || @[init_etd_dt]                        || chr(10) ||" ).append("\n"); 
		query.append("       'POLATD_GMT:'    || @[init_etd_dt_gmt]                     || chr(10) ||" ).append("\n"); 
		query.append("       'POD_NAME:'      || LC.LOC_NM                           || chr(10) ||" ).append("\n"); 
		query.append("       'POD_CODE:'      || LC.LOC_CD                           || chr(10) ||" ).append("\n"); 
		query.append("       'POD_AMSQUAL:'   || decode(LC.CNT_CD, 'US', 'D', 'K')   || chr(10) ||" ).append("\n"); 
		query.append("       'POD_AMSPORT:'   || LC.LOC_AMS_PORT_CD                  || chr(10) ||" ).append("\n"); 
		query.append("       'PODETA:'        || @[vps_eta_dt]                         || chr(10) ||" ).append("\n"); 
		query.append("       'PODETA_GMT:'    || @[vps_eta_dt_gmt]                      || chr(10) ||" ).append("\n"); 
		query.append("       'PODATA:'        || @[init_eta_dt]                        || chr(10) ||" ).append("\n"); 
		query.append("       'PODATA_GMT:'    || @[init_eta_dt_gmt]                     || chr(10) ||" ).append("\n"); 
		query.append("       'PODETD:'                                               || chr(10) ||" ).append("\n"); 
		query.append("       'PODETD_GMT:'                                           || chr(10) ||" ).append("\n"); 
		query.append("       'PODATD:'                                               || chr(10) ||" ).append("\n"); 
		query.append("       'PODATD_GMT:'                                           || chr(10) ||" ).append("\n"); 
		query.append("       'DEL_NAME:'      || LD.LOC_NM                           || chr(10) ||" ).append("\n"); 
		query.append("       'DEL_CODE:'      || LD.LOC_CD                           || chr(10) ||" ).append("\n"); 
		query.append("       'DEL_AMSQUAL:'   || decode(LD.CNT_CD, 'US', 'D', 'K')   || chr(10) ||" ).append("\n"); 
		query.append("       'DEL_AMSPORT:'   || LD.LOC_AMS_PORT_CD                  || chr(10) ||" ).append("\n"); 
		query.append("       'DELETA:'        || NVL(@[final_eta_dt], '')                || chr(10) ||" ).append("\n"); 
		query.append("       'DELETA_GMT:'    || NVL(@[final_eta_dt_gmt], '')             || chr(10) ||" ).append("\n"); 
		query.append("       'DELATA:'                                               || chr(10) ||" ).append("\n"); 
		query.append("       'DELATA_GMT:'                                           || chr(10) ||" ).append("\n"); 
		query.append("       'RLY_NAME:'                                             || chr(10) ||" ).append("\n"); 
		query.append("       'RLY_CODE:'                                             || chr(10) ||" ).append("\n"); 
		query.append("       'RLY_AMSQUAL:'                                          || chr(10) ||" ).append("\n"); 
		query.append("       'RLY_AMSPORT:'                                          || chr(10) ||" ).append("\n"); 
		query.append("       'W_UNIT:'        || BD.WGT_UT_CD                        || chr(10) ||" ).append("\n"); 
		query.append("       'WEIGHT:'        || BD.ACT_WGT                          || chr(10) ||" ).append("\n"); 
		query.append("       'P_UNIT:'        || BD.PCK_TP_CD                        || chr(10) ||" ).append("\n"); 
		query.append("       'PACKAGE:'       || BD.PCK_QTY                          || chr(10) ||" ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       'CNTR_NBR:'      || F.cntr_no	                          || CHR(10) ||" ).append("\n"); 
		query.append("       'CNTR_TYPE:'     || F.CNTR_TPSZ_CD	                  || CHR(10) ||" ).append("\n"); 
		query.append("       'F/M_IND:'       || DECODE(B.BKG_CGO_TP_CD, 'F', 'F', 'M')	|| CHR(10) ||" ).append("\n"); 
		query.append("       'EVENT_DATE:'    || TO_CHAR(sysdate, 'yyyymmddhh24mi')	    || CHR(10) ||" ).append("\n"); 
		query.append("       'EVENT_DATE_GMT:' || NVL(TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC('USNYC',SYSDATE,'GMT' ), 'YYYYMMDDHH24MI'), ' ') || chr(10) ||" ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       'CUST_REF_NO:'        || NVL(T.CUST_REF_NO_CTNT, ' ')              || chr(10) ||" ).append("\n"); 
		query.append("       'LLOYD_CODE:'         || NVL(C.LLOYD_NO, ' ')                      || chr(10) ||" ).append("\n"); 
		query.append("       'EVENT_LOC:'          || NVL(B.POD_CD, ' ')                        || chr(10) ||" ).append("\n"); 
		query.append("       'EVENT_LOC_NAME:'     || NVL(E.LOC_NM, ' ')                        || chr(10) ||" ).append("\n"); 
		query.append("       'EVENT_LOC_AMSQUAL:'  || DECODE(E.CNT_CD, 'US', 'D', 'K')          || chr(10) ||" ).append("\n"); 
		query.append("       'EVENT_LOC_AMSPORT:'  || NVL(E.LOC_AMS_PORT_CD, ' ')               || chr(10) ||" ).append("\n"); 
		query.append("       'PO_NBR:'             || @[po_no]                                   || chr(10) ||" ).append("\n"); 
		query.append("       'BL_PO_NBR:'          || NVL(M.CUST_REF_NO_CTNT, '')               || chr(10) ||" ).append("\n"); 
		query.append("       'CNTR_PO_NBR:'        || NVL(M.CUST_REF_NO_CTNT, '')               || chr(10) ||" ).append("\n"); 
		query.append("       'BL_STORE_NBR:'                                                    || chr(10) ||" ).append("\n"); 
		query.append("       'SHPRCODE:'           || cs.CUST_CNT_CD || LPAD(cs.CUST_SEQ, 6, 0) || chr(10) ||" ).append("\n"); 
		query.append("       'SHPR1:'              || BKG_TOKEN_NL_FNC(CS.CUST_NM, 1, '')       || chr(10) ||" ).append("\n"); 
		query.append("       'SHPR2:'              || BKG_TOKEN_NL_FNC(CS.CUST_NM, 2, '')       || chr(10) ||" ).append("\n"); 
		query.append("       'SHPR3:'              || BKG_TOKEN_NL_FNC(CS.CUST_ADDR, 1, '')     || chr(10) ||" ).append("\n"); 
		query.append("       'SHPR4:'              || BKG_TOKEN_NL_FNC(CS.CUST_ADDR, 2, '')     || chr(10) ||" ).append("\n"); 
		query.append("       'SHPR5:'              || BKG_TOKEN_NL_FNC(CS.CUST_ADDR, 3, '')     || chr(10) ||" ).append("\n"); 
		query.append("       'SHPR_CITY_NM:'	    || cs.CUST_CTY_NM                             || chr(10) ||" ).append("\n"); 
		query.append("       'SHPR_STAT_CD:'	    || cs.CUST_STE_CD                             || chr(10) ||" ).append("\n"); 
		query.append("       'SHPR_ZIP_CD:'	    || cs.CUST_ZIP_ID                             || chr(10) ||" ).append("\n"); 
		query.append("       'SHPR_CNT_CD:'	    || cs.CSTMS_DECL_CNT_CD                       || chr(10) ||" ).append("\n"); 
		query.append("       'CNEECODE:'	        || cc.CUST_CNT_CD || LPAD(cc.CUST_SEQ, 6, 0)  || chr(10) ||" ).append("\n"); 
		query.append("       'CNEE1:'              || BKG_TOKEN_NL_FNC(CC.CUST_NM, 1, '')       || chr(10) ||" ).append("\n"); 
		query.append("       'CNEE2:'              || BKG_TOKEN_NL_FNC(CC.CUST_NM, 2, '')       || chr(10) ||" ).append("\n"); 
		query.append("       'CNEE3:'              || BKG_TOKEN_NL_FNC(CC.CUST_ADDR, 1, '')     || chr(10) ||" ).append("\n"); 
		query.append("       'CNEE4:'              || BKG_TOKEN_NL_FNC(CC.CUST_ADDR, 2, '')     || chr(10) ||" ).append("\n"); 
		query.append("       'CNEE5:'              || BKG_TOKEN_NL_FNC(CC.CUST_ADDR, 3, '')     || chr(10) ||" ).append("\n"); 
		query.append("       'CNEE_CITY_NM:'	    || cc.CUST_CTY_NM                             || chr(10) ||" ).append("\n"); 
		query.append("       'CNEE_STAT_CD:'	    || cc.CUST_STE_CD                             || chr(10) ||" ).append("\n"); 
		query.append("       'CNEE_ZIP_CD:'	    || cc.CUST_ZIP_ID                             || chr(10) ||" ).append("\n"); 
		query.append("       'CNEE_CNT_CD:'	    || cc.CSTMS_DECL_CNT_CD                       || chr(10) ||" ).append("\n"); 
		query.append("       'NTFYCODE:'           || cn.CUST_CNT_CD || LPAD(cn.CUST_SEQ, 6, 0) || chr(10) ||" ).append("\n"); 
		query.append("       'NTFY1:'              || BKG_TOKEN_NL_FNC(CN.CUST_NM, 1, '')       || chr(10) ||" ).append("\n"); 
		query.append("       'NTFY2:'              || BKG_TOKEN_NL_FNC(CN.CUST_NM, 2, '')       || chr(10) ||" ).append("\n"); 
		query.append("       'NTFY3:'              || BKG_TOKEN_NL_FNC(CN.CUST_ADDR, 1, '')     || chr(10) ||" ).append("\n"); 
		query.append("       'NTFY4:'              || BKG_TOKEN_NL_FNC(CN.CUST_ADDR, 2, '')     || chr(10) ||" ).append("\n"); 
		query.append("       'NTFY5:'              || BKG_TOKEN_NL_FNC(CN.CUST_ADDR, 3, '')     || chr(10) ||" ).append("\n"); 
		query.append("       'NTFY_CITY_NM:'	    || cn.CUST_CTY_NM                             || chr(10) ||" ).append("\n"); 
		query.append("       'NTFY_STAT_CD:'	    || cn.CUST_STE_CD                             || chr(10) ||" ).append("\n"); 
		query.append("       'NTFY_ZIP_CD:'	    || cn.CUST_ZIP_ID                             || chr(10) ||" ).append("\n"); 
		query.append("       'NTFY_CNT_CD:'	    || cn.CSTMS_DECL_CNT_CD                       || chr(10) ||" ).append("\n"); 
		query.append("       'REF_CUSTCODE:'    || DECODE(SUBSTR(@[edi_rcv_id], 1, 3), 'MTC', NVL(B.USA_CSTMS_FILE_CD, ''), 'TTI', NVL(B.USA_CSTMS_FILE_CD, ''), 'GPA', NVL(B.USA_CSTMS_FILE_CD, ''), 'MAH', NVL(B.USA_CSTMS_FILE_CD, ''), NVL(@[cust_cd], '')) || chr(10) ||" ).append("\n"); 
		query.append("       'INV_NBR:'            || DECODE(SUBSTR(@[edi_rcv_id], 1, 3), 'MTC', @[cstms_dspo_cd], 'TTI', @[cstms_dspo_cd], 'GPA', @[cstms_dspo_cd], 'MAH', @[cstms_dspo_cd], 'TRA', @[cstms_dspo_cd], NVL(O.CUST_REF_NO_CTNT, '')) || chr(10) ||" ).append("\n"); 
		query.append("       'RD_TERM:'            || B.RCV_TERM_CD || B.DE_TERM_CD             || chr(10) ||" ).append("\n"); 
		query.append("       'CUST_EDATE:'         || TO_CHAR(SYSDATE, 'YYYYMMDDHH24MI')        || chr(10) ||" ).append("\n"); 
		query.append("       'CUST_EDATE_GMT:'     || NVL(TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC('USNYC',SYSDATE,'GMT' ), 'YYYYMMDDHH24MI'), ' ') || chr(10) ||" ).append("\n"); 
		query.append("       'CUST_ADATE:'         || TO_CHAR(SYSDATE, 'YYYYMMDDHH24MI')        || chr(10) ||" ).append("\n"); 
		query.append("       'CUST_ADATE_GMT:'     || NVL(TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC('USNYC',SYSDATE,'GMT' ), 'YYYYMMDDHH24MI'), ' ') || chr(10) ||" ).append("\n"); 
		query.append("       'CURRENT_VVD:'        || @[vsk_vvd_cd]                                  || chr(10) ||" ).append("\n"); 
		query.append("       'CONSORT_VOY:'        || NVL(X.IB_CSSM_VOY_NO, ' ')                     || CHR(10) ||" ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       'SEL_NBR:'            || NVL(G.CNTR_SEAL_NO, ' ')	|| CHR(10) ||" ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       'LANE:'               || NVL(B.SLAN_CD, '')                  || chr(10) ||" ).append("\n"); 
		query.append("       'LANE_DESC:'          || @[vsl_slan_nm]                           || chr(10) ||" ).append("\n"); 
		query.append("       'SC_NBR:'             || NVL(B.SC_NO, '')                    || chr(10) ||" ).append("\n"); 
		query.append("       'IT_NBR:'                                                    || CHR(10) ||" ).append("\n"); 
		query.append("       'PICKUP_NBR:'                                                || CHR(10) FLAT_FILE_BODY" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("  FROM BKG_BOOKING      B," ).append("\n"); 
		query.append("       BKG_REFERENCE    O," ).append("\n"); 
		query.append("       MDM_VSL_CNTR     C," ).append("\n"); 
		query.append("       MDM_LOCATION     E," ).append("\n"); 
		query.append("       BKG_REFERENCE    M," ).append("\n"); 
		query.append("       BKG_CUSTOMER     CS," ).append("\n"); 
		query.append("       BKG_CUSTOMER     CC," ).append("\n"); 
		query.append("       BKG_CUSTOMER     CN," ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       BKG_REFERENCE    T," ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       MDM_LOCATION     LA," ).append("\n"); 
		query.append("       MDM_LOCATION     LB," ).append("\n"); 
		query.append("       MDM_LOCATION     LC," ).append("\n"); 
		query.append("       MDM_LOCATION     LD," ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       BKG_CONTAINER    F," ).append("\n"); 
		query.append("       BKG_CNTR_SEAL_NO G," ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       BKG_BL_DOC       BD," ).append("\n"); 
		query.append("       BKG_CGO_RLSE     CG," ).append("\n"); 
		query.append("       VSK_VSL_PORT_SKD X" ).append("\n"); 
		query.append(" WHERE B.BKG_NO             = @[bkg_no]" ).append("\n"); 
		query.append("   AND B.BKG_NO             = O.BKG_NO(+)" ).append("\n"); 
		query.append("   AND O.BKG_REF_TP_CD(+)   = 'BKPO'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   AND C.VSL_CD             = SUBSTR(@[vsk_vvd_cd], 1, 4)" ).append("\n"); 
		query.append("   AND B.POD_CD             = E.LOC_CD(+)" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("   AND B.BKG_NO             = M.BKG_NO(+)" ).append("\n"); 
		query.append("   AND M.BKG_REF_TP_CD(+)   = 'BKPO'" ).append("\n"); 
		query.append("   AND B.BKG_NO             = CS.BKG_NO(+)" ).append("\n"); 
		query.append("   AND CS.BKG_CUST_TP_CD(+) = 'S'" ).append("\n"); 
		query.append("   AND B.BKG_NO             = CC.BKG_NO(+)" ).append("\n"); 
		query.append("   AND CC.BKG_CUST_TP_CD(+) = 'C'" ).append("\n"); 
		query.append("   AND B.BKG_NO             = CN.BKG_NO(+)" ).append("\n"); 
		query.append("   AND CN.BKG_CUST_TP_CD(+) = 'N'" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("   AND B.BKG_NO             = T.BKG_NO(+)" ).append("\n"); 
		query.append("   AND T.BKG_REF_TP_CD(+)   = 'EBRF'	" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("   AND B.POR_CD             = LA.LOC_CD(+)" ).append("\n"); 
		query.append("   AND LB.LOC_CD(+)         = @[vsk_pol_cd]" ).append("\n"); 
		query.append("   AND LC.LOC_CD(+)         = @[vsk_pod_cd]" ).append("\n"); 
		query.append("   AND B.DEL_CD	            = LD.LOC_CD(+)" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("   AND B.BKG_NO             = F.BKG_NO(+)" ).append("\n"); 
		query.append("   AND F.BKG_NO             = G.BKG_NO(+)" ).append("\n"); 
		query.append("   AND F.CNTR_NO            = G.CNTR_NO(+)" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("   AND B.BKG_NO             = BD.BKG_NO" ).append("\n"); 
		query.append("   AND B.BL_NO              = CG.BL_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   AND X.VSL_CD             = SUBSTR(@[vsk_vvd_cd], 1, 4)" ).append("\n"); 
		query.append("   AND X.SKD_VOY_NO         = SUBSTR(@[vsk_vvd_cd], 5, 4)" ).append("\n"); 
		query.append("   AND X.SKD_DIR_CD         = SUBSTR(@[vsk_vvd_cd], 9, 1)" ).append("\n"); 
		query.append("   AND X.POD_CD             = @[vsk_pol_cd]" ).append("\n"); 
		query.append("   AND X.CLPT_IND_SEQ(+)    = '1'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${edi_bl_cntr_ind} == 'B') " ).append("\n"); 
		query.append("   AND ROWNUM = 1" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}