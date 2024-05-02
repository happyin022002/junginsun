/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOsearchEdiFullCntrRlseOrderBlInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.02
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.02 
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

public class CargoReleaseOrderDBDAOsearchEdiFullCntrRlseOrderBlInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchEdiFullCntrRlseOrderBlInfo
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOsearchEdiFullCntrRlseOrderBlInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("psan_ref_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fw_cust_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cxl_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ebrf_ref_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sh_cust_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_cntc_pson_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("diff_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_pkup_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOsearchEdiFullCntrRlseOrderBlInfoRSQL").append("\n"); 
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
		query.append("SELECT  CHR(10) ||" ).append("\n"); 
		query.append("       'BKGNBR:'          || BKGM.BKG_NO                                  || CHR(10) || " ).append("\n"); 
		query.append("       'RELREF:'          || @[cntr_no]                                             || CHR(10) ||" ).append("\n"); 
		query.append("       'BRAC:'            || @[cxl_flg]                                             || CHR(10) ||" ).append("\n"); 
		query.append("       'BL_NO:'           || BKGM.BL_NO                                             || CHR(10) ||" ).append("\n"); 
		query.append("       'HAULAGE_IND:'     || NVL(BET.HLG_TP_CD,DECODE(BKGM.DE_TERM_CD,'D','C','M')) || CHR(10) ||" ).append("\n"); 
		query.append("       'TOVSL:'           || BVVD.VSL_CD                                            || CHR(10) ||  " ).append("\n"); 
		query.append("       'LOYD:'            || VSL.LLOYD_NO                                           || CHR(10) ||      " ).append("\n"); 
		query.append("       'VSLNAME:'         || VSL.VSL_ENG_NM                                         || CHR(10) || " ).append("\n"); 
		query.append("       'VSL_CALL_SIGN:'   || VSL.CALL_SGN_NO                                        || CHR(10) ||    " ).append("\n"); 
		query.append("       'TOVOY:'           || BVVD.SKD_VOY_NO                                        || CHR(10) ||" ).append("\n"); 
		query.append("       'TODIR:'           || BVVD.SKD_DIR_CD                                        || CHR(10) ||" ).append("\n"); 
		query.append("       'CONSORT_VOY:'     || NVL(VSK.IB_CSSM_VOY_NO, ' ')                           || CHR(10) ||" ).append("\n"); 
		query.append("       'POR_NAME:'        || NVL(POR.LOC_NM,' ')                                    || CHR(10) ||" ).append("\n"); 
		query.append("       'POR_PORT:'        || BKGM.POR_CD                                            || CHR(10) ||" ).append("\n"); 
		query.append("       'POR_UNLC:'        || NVL(POR.UN_LOC_CD,' ')                                 || CHR(10) ||" ).append("\n"); 
		query.append("       'POL_NAME:'        || NVL(POL.LOC_NM,' ')                                    || CHR(10) ||" ).append("\n"); 
		query.append("       'POL_PORT:'        || BKGM.POL_CD                                            || CHR(10) ||" ).append("\n"); 
		query.append("       'POL_UNLC:'        || NVL(POL.UN_LOC_CD,' ')                                 || CHR(10) ||" ).append("\n"); 
		query.append("	   'POL_ETA:'	   	  || TO_CHAR(n1st_skd.vps_eta_dt, 'RRRRMMDDHH24MI')			|| CHR(10) ||" ).append("\n"); 
		query.append("	   'POL_ETD:'         || TO_CHAR(n1st_skd.vps_etd_dt, 'RRRRMMDDHH24MI')			|| CHR(10) ||" ).append("\n"); 
		query.append("       'POD_NAME:'        || NVL(POD.LOC_NM,' ')                                    || CHR(10) ||" ).append("\n"); 
		query.append("       'POD_PORT:'        || BKGM.POD_CD                                            || CHR(10) ||" ).append("\n"); 
		query.append("       'POD_UNLC:'        || NVL(POD.UN_LOC_CD,' ')                                 || CHR(10) ||" ).append("\n"); 
		query.append("	   'POD_ETA:'	      || TO_CHAR(last_skd.vps_eta_dt,     'RRRRMMDDHH24MI')     || CHR(10) ||" ).append("\n"); 
		query.append("	   'POD_ETD:'         || TO_CHAR(last_skd.vps_etd_dt,     'RRRRMMDDHH24MI')     || CHR(10) ||" ).append("\n"); 
		query.append("       'DEL_NAME:'        || NVL(DEL.LOC_NM,' ')                                    || CHR(10) ||" ).append("\n"); 
		query.append("       'DEL_PORT:'        || BKGM.DEL_CD                                            || CHR(10) ||" ).append("\n"); 
		query.append("       'DEL_UNLC:'        || NVL(DEL.UN_LOC_CD,' ')                                 || CHR(10) ||" ).append("\n"); 
		query.append("       'DEL_ETA:'         || (SELECT to_char(MAX(ESTM_DT), 'RRRRMMDDHH24MI', 'NLS_DATE_LANGUAGE=ENGLISH') as DEL_EST_ARRIVAL_DATE" ).append("\n"); 
		query.append("							  FROM SCE_COP_HDR HDR, SCE_COP_DTL DTL" ).append("\n"); 
		query.append("							 WHERE BKGM.BKG_NO = HDR.BKG_NO" ).append("\n"); 
		query.append("							   AND HDR.COP_NO  = DTL.COP_NO" ).append("\n"); 
		query.append("							   AND DTL.NOD_CD  = BKGM.DEL_NOD_CD" ).append("\n"); 
		query.append("							   AND HDR.COP_STS_CD IN ('C', 'T', 'F')" ).append("\n"); 
		query.append("							   AND (DTL.ACT_CD LIKE 'FI__A_' OR DTL.ACT_CD LIKE 'FU__U_')) || CHR(10) ||" ).append("\n"); 
		query.append("       'CFS_YARD:'        ||   DECODE(YD.YD_FCTY_TP_CFS_FLG, 'Y', BKGM.POD_NOD_CD, BKGM.DEL_NOD_CD)     || CHR(10) ||" ).append("\n"); 
		query.append("	   'PARTY_ADD1:'	  || BKG_TOKEN_NL_FNC(replace(replace(BXC.CUST_NM, chr(13), ' '), chr(10), ' ' ), 1, '')  || CHR(10) ||" ).append("\n"); 
		query.append("	   'PARTY_ADD2:'      || BKG_TOKEN_NL_FNC(replace(replace(BXC.CUST_NM, chr(13), ' '), chr(10), ' ' ), 2, '')  || CHR(10) ||" ).append("\n"); 
		query.append("	   'PARTY_ADD3:'      || BKG_TOKEN_NL_FNC(replace(replace(BXC.CUST_ADDR, chr(13), ' '), chr(10), ' ' ), 1, '')  || CHR(10) ||" ).append("\n"); 
		query.append("	   'PARTY_ADD4:'      || BKG_TOKEN_NL_FNC(replace(replace(BXC.CUST_ADDR, chr(13), ' '), chr(10), ' ' ), 2, '')  || CHR(10) ||" ).append("\n"); 
		query.append("	   'PARTY_ADD5:'      || BKG_TOKEN_NL_FNC(replace(replace(BXC.CUST_ADDR, chr(13), ' '), chr(10), ' ' ), 3, '')  || CHR(10) ||" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       'PUNIT:'           || BDOC.PCK_TP_CD                                         || CHR(10) ||" ).append("\n"); 
		query.append("       'PKG:'             || NVL(PCK_QTY,0)                                         || CHR(10) ||" ).append("\n"); 
		query.append("       'WUNIT:'           || SUBSTR(BDOC.WGT_UT_CD, 1, 1)                           || CHR(10) ||" ).append("\n"); 
		query.append("       'WGT:'             || NVL(BDOC.ACT_WGT,0)                                    || CHR(10) ||" ).append("\n"); 
		query.append("       'MUNIT:'           || SUBSTR(BDOC.MEAS_UT_CD, 3, 1)                          || CHR(10) ||" ).append("\n"); 
		query.append("       'MEAS:'            || NVL(BDOC.MEAS_QTY,0)                                   || CHR(10) ||" ).append("\n"); 
		query.append("       'RDTYP:'           || BKGM.RCV_TERM_CD ||BKGM.DE_TERM_CD                     || CHR(10) ||" ).append("\n"); 
		query.append("       'SMOD:'            || BKGM.DEST_TRNS_SVC_MOD_CD                              || CHR(10) ||" ).append("\n"); 
		query.append("       'TRUCK:'           || (select SYS_AREA_GRP_ID from bkg_pfx_rout where ofc_pfx_cd = substr(BKGM.BKG_OFC_CD, 1, 3)) || CHR(10) ||" ).append("\n"); 
		query.append("       'REMARK:'          || REPLACE(@[diff_rmk], CHR(10), ' ')                     || CHR(10) ||" ).append("\n"); 
		query.append("       'INSTRUCTION:'     || REPLACE(NULL, CHR(10), ' ')                            || CHR(10) ||" ).append("\n"); 
		query.append("       'CMD:'             || NVL(CMDT.CMDT_CD, RCMDT.REP_CMDT_CD)                   || CHR(10) ||" ).append("\n"); 
		query.append("       'CMDD:'            || NVL(CMDT.CMDT_NM, RCMDT.REP_CMDT_NM)                   || CHR(10) ||" ).append("\n"); 
		query.append("       'EQREL:'           || @[yd_cd]                                               || CHR(10) ||" ).append("\n"); 
		query.append("       'SHN1:'            || NVL(REPLACE(BSH.CUST_NM, CHR(10), ' '),' ')            || CHR(10) ||" ).append("\n"); 
		query.append("       'FFN1:'            || NVL(REPLACE(BFW.CUST_NM, CHR(10), ' '),' ')            || CHR(10) ||" ).append("\n"); 
		query.append("       'CNE1:'            || NVL(REPLACE(REPLACE(@[cust_nm], CHR(13), ''),CHR(10),''),'')             || CHR(10) ||" ).append("\n"); 
		query.append("       'CANCEL_BIT:'      || BKGM.BKG_STS_CD                                        || CHR(10) ||" ).append("\n"); 
		query.append("       'CARGOTYPE:'       || BKGM.BKG_CGO_TP_CD                                     || CHR(10) ||" ).append("\n"); 
		query.append("       'DR_IND:'          || DECODE(BKGM.DCGO_FLG,'Y','1','0')                      || CHR(10) ||" ).append("\n"); 
		query.append("       'RF_IND:'          || DECODE(BKGM.RC_FLG,'Y','1','0')                        || CHR(10) ||" ).append("\n"); 
		query.append("       'AK_IND:'          || DECODE(BKGM.AWK_CGO_FLG,'Y','1','0')                   || CHR(10) ||" ).append("\n"); 
		query.append("       'BB_IND:'          || DECODE(BKGM.BB_CGO_FLG,'Y','1','0')                    || CHR(10) ||" ).append("\n"); 
		query.append("       'SOC_IND:'         || DECODE(BKGM.soc_flg,'Y','1','0')                       || CHR(10) ||" ).append("\n"); 
		query.append("       'SALES_OFFICE:'    || BKGM.OB_SLS_OFC_CD                                     || CHR(10) ||" ).append("\n"); 
		query.append("       'SALES_NAME:'      || SREP.SREP_NM                                           || CHR(10) ||" ).append("\n"); 
		query.append("       'CONTACT_NAME:'    || BPSN.CNTC_PSON_NM                                      || CHR(10) ||" ).append("\n"); 
		query.append("       'BOUND_IND:'       || 'I'                                                    || CHR(10) ||" ).append("\n"); 
		query.append("       'REGIONAL_BKGNBR:' || NVL(BREF2.CUST_REF_NO_CTNT,'')                         || CHR(10) ||" ).append("\n"); 
		query.append("       'CUST_REF_NO:'     || NVL(BREF1.CUST_REF_NO_CTNT,'')                         || CHR(10) ||" ).append("\n"); 
		query.append("       'SO_NO:'           || BKGM.TWN_SO_NO                                         || CHR(10) ||" ).append("\n"); 
		query.append("       'BLKSTWG:'         || NVL(BLCK_STWG_CD,'')                                   || CHR(10) ||" ).append("\n"); 
		query.append("       'EQPICKDT:'        || @[cgo_pkup_dt]                                         || CHR(10) " ).append("\n"); 
		query.append("  FROM BKG_BOOKING  BKGM" ).append("\n"); 
		query.append("     , BKG_CUSTOMER BSH" ).append("\n"); 
		query.append("     , BKG_CUSTOMER BFW" ).append("\n"); 
		query.append("     , BKG_VVD      BVVD" ).append("\n"); 
		query.append("     , MDM_VSL_CNTR VSL" ).append("\n"); 
		query.append("     , MDM_LOCATION POR" ).append("\n"); 
		query.append("     , MDM_LOCATION POL" ).append("\n"); 
		query.append("     , MDM_LOCATION POD" ).append("\n"); 
		query.append("     , MDM_LOCATION DEL" ).append("\n"); 
		query.append("     , BKG_BL_DOC    BDOC" ).append("\n"); 
		query.append("     , BKG_CNTC_PSON BPSN" ).append("\n"); 
		query.append("     , MDM_COMMODITY CMDT" ).append("\n"); 
		query.append("     , MDM_REP_CMDT RCMDT" ).append("\n"); 
		query.append("     , MDM_SLS_REP SREP" ).append("\n"); 
		query.append("     ,(SELECT BKG_NO,CUST_REF_NO_CTNT FROM BKG_REFERENCE WHERE BKG_NO = @[bkg_no]  AND BKG_REF_TP_CD  = @[ebrf_ref_tp_cd]  AND ROWNUM =1 ) BREF1  " ).append("\n"); 
		query.append("     ,(SELECT BKG_NO,CUST_REF_NO_CTNT FROM BKG_REFERENCE WHERE BKG_NO = @[bkg_no]  AND BKG_REF_TP_CD  = @[psan_ref_tp_cd]  AND ROWNUM =1 ) BREF2    " ).append("\n"); 
		query.append("     ,(SELECT A.BKG_NO, A.HLG_TP_CD" ).append("\n"); 
		query.append("         FROM BKG_EUR_TRO A," ).append("\n"); 
		query.append("              (SELECT MAX(TRO_SEQ) AS TRO_SEQ " ).append("\n"); 
		query.append("                 FROM BKG_EUR_TRO " ).append("\n"); 
		query.append("                WHERE BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("                  AND IO_BND_CD = 'I' ) B" ).append("\n"); 
		query.append("        WHERE A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("          AND A.IO_BND_CD = 'I'" ).append("\n"); 
		query.append("          AND A.TRO_SEQ = B.TRO_SEQ) BET" ).append("\n"); 
		query.append("     , VSK_VSL_PORT_SKD VSK " ).append("\n"); 
		query.append("     , BKG_VVD          n1st_vvd" ).append("\n"); 
		query.append("     , VSK_VSL_PORT_SKD n1st_skd" ).append("\n"); 
		query.append("     , bkg_vvd          last_vvd" ).append("\n"); 
		query.append("     , vsk_vsl_port_skd last_skd" ).append("\n"); 
		query.append("     , (SELECT A.XTER_RQST_NO AS BKG_NO, A.CUST_ADDR, A.CUST_NM" ).append("\n"); 
		query.append("          FROM BKG_XTER_CUST A," ).append("\n"); 
		query.append("               (SELECT MAX(XTER_RQST_NO) XTER_RQST_NO" ).append("\n"); 
		query.append("                  FROM BKG_XTER_CUST" ).append("\n"); 
		query.append("                 WHERE XTER_SNDR_ID = 'WEB'" ).append("\n"); 
		query.append("                   AND XTER_RQST_NO = @[bkg_no]" ).append("\n"); 
		query.append("                   AND XTER_CUST_TP_CD = 'B') B" ).append("\n"); 
		query.append("         WHERE A.XTER_SNDR_ID = 'WEB'" ).append("\n"); 
		query.append("           AND A.XTER_RQST_NO = @[bkg_no]" ).append("\n"); 
		query.append("           AND A.XTER_RQST_NO = B.XTER_RQST_NO" ).append("\n"); 
		query.append("           AND A.XTER_CUST_TP_CD = 'B') BXC" ).append("\n"); 
		query.append("      , MDM_YARD  YD  " ).append("\n"); 
		query.append(" WHERE BKGM.BKG_NO                 = @[bkg_no]" ).append("\n"); 
		query.append("   AND BKGM.POR_CD                 = POR.LOC_CD(+)" ).append("\n"); 
		query.append("   AND BKGM.POL_CD                 = POL.LOC_CD(+)" ).append("\n"); 
		query.append("   AND BKGM.POD_CD                 = POD.LOC_CD(+)" ).append("\n"); 
		query.append("   AND BKGM.DEL_CD                 = DEL.LOC_CD(+)  " ).append("\n"); 
		query.append("   AND BSH.BKG_NO(+)               = BKGM.BKG_NO " ).append("\n"); 
		query.append("   AND BSH.BKG_CUST_TP_CD(+)       = @[sh_cust_tp_cd]" ).append("\n"); 
		query.append("   AND BFW.BKG_NO(+)               = BKGM.BKG_NO " ).append("\n"); 
		query.append("   AND BFW.BKG_CUST_TP_CD(+)       = @[fw_cust_tp_cd]  " ).append("\n"); 
		query.append("   AND BVVD.BKG_NO(+)              = BKGM.BKG_NO  " ).append("\n"); 
		query.append("   AND BVVD.POD_CD(+)              = BKGM.POD_CD " ).append("\n"); 
		query.append("   AND VSL.VSL_CD(+)               = BVVD.VSL_CD   " ).append("\n"); 
		query.append("   AND BDOC.BKG_NO(+)              = BKGM.BKG_NO" ).append("\n"); 
		query.append("   AND BREF1.BKG_NO(+)             = BKGM.BKG_NO                " ).append("\n"); 
		query.append("   AND BREF2.BKG_NO(+)             = BKGM.BKG_NO " ).append("\n"); 
		query.append("   AND BPSN.BKG_NO(+)              = BKGM.BKG_NO           " ).append("\n"); 
		query.append("   AND BPSN.BKG_CNTC_PSON_TP_CD(+) = @[bkg_cntc_pson_tp_cd]" ).append("\n"); 
		query.append("   AND CMDT.CMDT_CD(+)             = BKGM.CMDT_CD  " ).append("\n"); 
		query.append("   AND RCMDT.REP_CMDT_CD(+)        = BKGM.REP_CMDT_CD" ).append("\n"); 
		query.append("   AND SREP.SREP_CD(+)             = BKGM.OB_SREP_CD" ).append("\n"); 
		query.append("   AND BET.BKG_NO(+)               = BKGM.BKG_NO" ).append("\n"); 
		query.append("   AND BVVD.VSL_CD                 = VSK.VSL_CD(+)" ).append("\n"); 
		query.append("   AND BVVD.SKD_VOY_NO             = VSK.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("   AND BVVD.SKD_DIR_CD             = VSK.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("   AND BVVD.POD_CD                 = VSK.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("   AND VSK.CLPT_IND_SEQ(+)         = '1'" ).append("\n"); 
		query.append("   and n1st_vvd.bkg_no (+)         = BKGM.bkg_no" ).append("\n"); 
		query.append("   and n1st_vvd.pol_cd (+)         = BKGM.pol_cd" ).append("\n"); 
		query.append("   and n1st_vvd.vsl_pre_pst_cd  in ('S', 'T')" ).append("\n"); 
		query.append("   and n1st_vvd.vsl_cd             = n1st_skd.vsl_cd(+) " ).append("\n"); 
		query.append("   and n1st_vvd.skd_voy_no         = n1st_skd.skd_voy_no(+)" ).append("\n"); 
		query.append("   and n1st_vvd.skd_dir_cd         = n1st_skd.skd_dir_cd(+)" ).append("\n"); 
		query.append("   and n1st_vvd.pol_cd             = n1st_skd.vps_port_cd(+)" ).append("\n"); 
		query.append("   and n1st_vvd.pol_clpt_ind_seq   = n1st_skd.clpt_ind_seq(+)" ).append("\n"); 
		query.append("   and BKGM.bkg_no                 = last_vvd.bkg_no(+)" ).append("\n"); 
		query.append("   and BKGM.pod_cd                 = last_vvd.pod_cd(+)" ).append("\n"); 
		query.append("   and last_vvd.vsl_pre_pst_cd  in ('T', 'U')" ).append("\n"); 
		query.append("   and last_vvd.vsl_cd          = last_skd.vsl_cd       (+)" ).append("\n"); 
		query.append("   and last_vvd.skd_voy_no      = last_skd.skd_voy_no   (+)" ).append("\n"); 
		query.append("   and last_vvd.skd_dir_cd      = last_skd.skd_dir_cd   (+)" ).append("\n"); 
		query.append("   and last_vvd.pod_cd          = last_skd.vps_port_cd  (+)" ).append("\n"); 
		query.append("   and last_vvd.pod_clpt_ind_seq= last_skd.clpt_ind_seq (+)" ).append("\n"); 
		query.append("   and BXC.BKG_NO(+)            = BKGM.BKG_NO" ).append("\n"); 
		query.append("   and YD.YD_CD (+)             = BKGM.POD_NOD_CD" ).append("\n"); 

	}
}