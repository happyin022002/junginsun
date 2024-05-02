/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOsearchEdiFullCntrRlseOrderBlInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.01.22
*@LastModifier : 
*@LastVersion : 1.0
* 2014.01.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
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
		query.append("       'TOVSL:'           || BVVD.VSL_CD                                            || CHR(10) ||  " ).append("\n"); 
		query.append("       'LOYD:'            || VSL.LLOYD_NO                                           || CHR(10) ||      " ).append("\n"); 
		query.append("       'VSLNAME:'         || VSL.VSL_ENG_NM                                         || CHR(10) || " ).append("\n"); 
		query.append("       'VSL_CALL_SIGN:'   || VSL.CALL_SGN_NO                                        || CHR(10) ||    " ).append("\n"); 
		query.append("       'TOVOY:'           || BVVD.SKD_VOY_NO                                        || CHR(10) ||" ).append("\n"); 
		query.append("       'TODIR:'           || BVVD.SKD_DIR_CD                                        || CHR(10) ||" ).append("\n"); 
		query.append("       'NAME:'            || NVL(POR.LOC_NM,' ')                                    || CHR(10) ||" ).append("\n"); 
		query.append("       'QUAL:'                                                                      || CHR(10) ||" ).append("\n"); 
		query.append("       'PORT:'                                                                      || CHR(10) ||" ).append("\n"); 
		query.append("       'UNLC:'            || BKGM.POR_CD                                            || CHR(10) ||" ).append("\n"); 
		query.append("       'NAME:'            || NVL(POL.LOC_NM,' ')                                    || CHR(10) ||" ).append("\n"); 
		query.append("       'QUAL:'                                                                      || CHR(10) ||" ).append("\n"); 
		query.append("       'PORT:'                                                                      || CHR(10) ||" ).append("\n"); 
		query.append("       'UNLC:'            || BKGM.POL_CD                                            || CHR(10) ||" ).append("\n"); 
		query.append("       'ETA:'                                                                       || CHR(10) ||" ).append("\n"); 
		query.append("       'ETD:'                                                                       || CHR(10) ||" ).append("\n"); 
		query.append("       'NAME:'            || NVL(POD.LOC_NM,' ')                                    || CHR(10) ||" ).append("\n"); 
		query.append("       'QUAL:'                                                                      || CHR(10) ||" ).append("\n"); 
		query.append("       'PORT:'                                                                      || CHR(10) ||" ).append("\n"); 
		query.append("       'UNLC:'            || BKGM.POD_CD                                            || CHR(10) ||" ).append("\n"); 
		query.append("       'ETA:'                                                                       || CHR(10) ||" ).append("\n"); 
		query.append("       'ETD:'                                                                       || CHR(10) ||" ).append("\n"); 
		query.append("       'NAME:'            || NVL(DEL.LOC_NM,' ')                                    || CHR(10) ||" ).append("\n"); 
		query.append("       'QUAL:'                                                                      || CHR(10) ||" ).append("\n"); 
		query.append("       'PORT:'                                                                      || CHR(10) ||" ).append("\n"); 
		query.append("       'UNLC:'            || BKGM.DEL_CD                                            || CHR(10) ||" ).append("\n"); 
		query.append("       'ETA:'                                                                       || CHR(10) ||" ).append("\n"); 
		query.append("       'NAME:'                                                                      || CHR(10) ||" ).append("\n"); 
		query.append("       'QUAL:'                                                                      || CHR(10) ||" ).append("\n"); 
		query.append("       'PORT:'                                                                      || CHR(10) ||" ).append("\n"); 
		query.append("       'UNLC:'                                                                      || CHR(10) ||" ).append("\n"); 
		query.append("       'PUNIT:'           || BDOC.PCK_TP_CD                                         || CHR(10) ||" ).append("\n"); 
		query.append("       'PKG:'             || NVL(PCK_QTY,0)                                         || CHR(10) ||" ).append("\n"); 
		query.append("       'WUNIT:'           || SUBSTR(BDOC.WGT_UT_CD, 1, 1)                           || CHR(10) ||" ).append("\n"); 
		query.append("       'WGT:'             || NVL(BDOC.ACT_WGT,0)                                    || CHR(10) ||" ).append("\n"); 
		query.append("       'MUNIT:'           || SUBSTR(BDOC.MEAS_UT_CD, 3, 1)                          || CHR(10) ||" ).append("\n"); 
		query.append("       'MEAS:'            || NVL(BDOC.MEAS_QTY,0)                                   || CHR(10) ||" ).append("\n"); 
		query.append("       'RDTYP:'           || BKGM.RCV_TERM_CD ||BKGM.DE_TERM_CD                     || CHR(10) ||" ).append("\n"); 
		query.append("       'SMOD:'            || BKGM.DEST_TRNS_SVC_MOD_CD                              || CHR(10) ||" ).append("\n"); 
		query.append("       'TRUCK:'                                                                     || CHR(10) ||" ).append("\n"); 
		query.append("       'REMARK:'          || REPLACE(@[diff_rmk], CHR(13)||CHR(10), ' ')            || CHR(10) ||" ).append("\n"); 
		query.append("       'INSTRUCTION:'     || REPLACE(NULL, CHR(13)||CHR(10), ' ')                   || CHR(10) ||" ).append("\n"); 
		query.append("       'CMD:'             || NVL(CMDT.CMDT_CD, RCMDT.REP_CMDT_CD)                   || CHR(10) ||" ).append("\n"); 
		query.append("       'CMDD:'            || NVL(CMDT.CMDT_NM, RCMDT.REP_CMDT_NM)                   || CHR(10) ||" ).append("\n"); 
		query.append("       'EQREL:'           || BKGM.MTY_PKUP_YD_CD                                    || CHR(10) ||" ).append("\n"); 
		query.append("       'SHN1:'            || NVL(REPLACE(BSH.CUST_NM, CHR(13)||CHR(10), ' '),' ')   || CHR(10) ||" ).append("\n"); 
		query.append("       'FFN1:'            || NVL(REPLACE(BFW.CUST_NM, CHR(13)||CHR(10), ' '),' ')   || CHR(10) ||" ).append("\n"); 
		query.append("       'CNE1:'            || @[cust_nm]                                             || CHR(10) ||" ).append("\n"); 
		query.append("       'CANCEL_BIT:'      || BKGM.BKG_STS_CD                                        || CHR(10) ||" ).append("\n"); 
		query.append("       'CARGOTYPE:'       || BKGM.BKG_CGO_TP_CD                                     || CHR(10) ||" ).append("\n"); 
		query.append("       'DR_IND:'          || DECODE(BKGM.DCGO_FLG,'Y','1','0')                      || CHR(10) ||" ).append("\n"); 
		query.append("       'RF_IND:'          || DECODE(BKGM.RC_FLG,'Y','1','0')                        || CHR(10) ||" ).append("\n"); 
		query.append("       'AK_IND:'          || DECODE(BKGM.AWK_CGO_FLG,'Y','1','0')                   || CHR(10) ||" ).append("\n"); 
		query.append("       'BB_IND:'          || DECODE(BKGM.BB_CGO_FLG,'Y','1','0')                    || CHR(10) ||" ).append("\n"); 
		query.append("       'SALES_OFFICE:'    || BKGM.OB_SLS_OFC_CD                                     || CHR(10) ||" ).append("\n"); 
		query.append("       'SALES_NAME:'      || SREP.SREP_NM                                           || CHR(10) ||" ).append("\n"); 
		query.append("       'CONTACT_NAME:'    || BPSN.CNTC_PSON_NM                                      || CHR(10) ||" ).append("\n"); 
		query.append("       'BOUND_IND:'       || 'E'                                                    || CHR(10) ||" ).append("\n"); 
		query.append("       'REGIONAL_BKGNBR:' || NVL(BREF2.CUST_REF_NO_CTNT,'')                         || CHR(10) ||" ).append("\n"); 
		query.append("       'CUST_REF_NO:'     || NVL(BREF1.CUST_REF_NO_CTNT,'')                         || CHR(10) ||" ).append("\n"); 
		query.append("       'REF_VOYAGE:'                                                                || CHR(10) ||" ).append("\n"); 
		query.append("       'SO_NO:'           || BKGM.TWN_SO_NO                                         || CHR(10) ||" ).append("\n"); 
		query.append("       'BLKSTWG:'         || NVL(BLCK_STWG_CD,'')                                   || CHR(10) ||" ).append("\n"); 
		query.append("       'EQPICKDT:'        || @[cgo_pkup_dt]                                         || CHR(10) " ).append("\n"); 
		query.append("       " ).append("\n"); 
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

	}
}