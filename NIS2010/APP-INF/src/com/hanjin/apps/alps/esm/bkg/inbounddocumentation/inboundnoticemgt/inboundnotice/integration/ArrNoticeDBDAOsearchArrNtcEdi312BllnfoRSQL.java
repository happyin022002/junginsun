/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : ArrNoticeDBDAOsearchArrNtcEdi312BllnfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.02.01
*@LastModifier : 
*@LastVersion : 1.0
* 2017.02.01 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ArrNoticeDBDAOsearchArrNtcEdi312BllnfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchArrNtcEdi312Bllnfo
	  * </pre>
	  */
	public ArrNoticeDBDAOsearchArrNtcEdi312BllnfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("rcv_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration").append("\n"); 
		query.append("FileName : ArrNoticeDBDAOsearchArrNtcEdi312BllnfoRSQL").append("\n"); 
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
		query.append("SELECT 'BL_NO:'          || BKGM.BL_NO 						                                || CHR(10) || " ).append("\n"); 
		query.append("       'BKG_NO:'         || BKGM.BKG_NO								                || CHR(10) || " ).append("\n"); 
		query.append("       'FUNC_CODE:'      || ''                                                                                  || CHR(10) ||" ).append("\n"); 
		query.append("       'GROUP_ID:'       || (SELECT  decode(seq, 'A', id, id||lPAD(seq, 5, '0'))" ).append("\n"); 
		query.append("			      FROM    (SELECT substr(esvc_grp_cd, 1, 3) id" ).append("\n"); 
		query.append("			                    , min(trim(substr(nvl(esvc_grp_cd, 'A'), 4, 7))) seq" ).append("\n"); 
		query.append("			                FROM    bkg_edi_grp eg" ).append("\n"); 
		query.append("			                WHERE   eg.cust_trd_prnr_id = @[rcv_id]" ).append("\n"); 
		query.append("			                and     eg.esvc_grp_delt_flg = 'N'" ).append("\n"); 
		query.append("			                GROUP BY substr(esvc_grp_cd, 1, 3)" ).append("\n"); 
		query.append("			                ORDER BY substr(esvc_grp_cd, 1, 3)" ).append("\n"); 
		query.append("			               ) " ).append("\n"); 
		query.append("			     WHERE   rownum  = 1)                                                                || CHR(10) ||" ).append("\n"); 
		query.append("       'SR_NO:'          || ''                                                                                   || CHR(10) ||" ).append("\n"); 
		query.append("       'LC_NO:'          || ''                                                                                   || CHR(10) ||" ).append("\n"); 
		query.append("       'VSL_CD:'         || BVVD.VSL_CD                                                                          || CHR(10) ||" ).append("\n"); 
		query.append("       'LLOYD:'          || VSL.LLOYD_NO                                                                         || CHR(10) ||" ).append("\n"); 
		query.append("       'CALL_SIGN:'      || VSL.CALL_SGN_NO                                                                      || CHR(10) ||" ).append("\n"); 
		query.append("       'VSL_FLAG:'       || VSL.VSL_RGST_CNT_CD                                                                  || CHR(10) ||" ).append("\n"); 
		query.append("       'VSL_NAME:'       || VSL.VSL_ENG_NM                                                                       || CHR(10) ||" ).append("\n"); 
		query.append("       'TOVOY:'          || BVVD.SKD_VOY_NO                                                                      || CHR(10) ||" ).append("\n"); 
		query.append("       'TODIR:'          || BVVD.SKD_DIR_CD                                                                      || CHR(10) ||" ).append("\n"); 
		query.append("       'BLDATE:'         || TO_CHAR( BISS.OBL_ISS_DT , 'YYYYMMDDHH24MISS')                                       || CHR(10) ||" ).append("\n"); 
		query.append("       'BLPLACE:'        || BISS.OBL_ISS_OFC_CD                                                                  || CHR(10) ||" ).append("\n"); 
		query.append("       'VSL_ETB:'        || TO_CHAR( VSK.VPS_ETB_DT , 'YYYYMMDDHH24MISS')                                        || CHR(10) ||" ).append("\n"); 
		query.append("       'VSL_ETD:'        || TO_CHAR( VSK.VPS_ETD_DT , 'YYYYMMDDHH24MISS')        				 || CHR(10) ||" ).append("\n"); 
		query.append("       'VSL_ETA:'        || TO_CHAR( VSK.VPS_ETA_DT , 'YYYYMMDDHH24MISS')        				 || CHR(10) ||" ).append("\n"); 
		query.append("       'BLPOR:'          || BKGM.POR_CD                                                                          || CHR(10) ||" ).append("\n"); 
		query.append("       'POR_NAME:'       || NVL(POR.LOC_NM,' ')                                                                  || CHR(10) ||" ).append("\n"); 
		query.append("       'POR_COUN:'       || POR.CNT_CD                                                                           || CHR(10) ||" ).append("\n"); 
		query.append("       'POR_ETA:'        || ''                                                                                   || CHR(10) ||" ).append("\n"); 
		query.append("       'POR_ETD:'        || ''                                                                                   || CHR(10) ||" ).append("\n"); 
		query.append("       'POR_AMSQUAL:'    || DECODE(LENGTH(POR.LOC_AMS_PORT_CD), 4, 'D', 5, 'K', ' ')                             || CHR(10) ||" ).append("\n"); 
		query.append("       'POR_AMSPORT:'    || POR.LOC_AMS_PORT_CD                                                                  || CHR(10) ||" ).append("\n"); 
		query.append("       'BLPOL:'          || BKGM.POL_CD                                                                          || CHR(10) ||" ).append("\n"); 
		query.append("       'POL_NAME:'       || NVL(POL.LOC_NM,' ')                                                                  || CHR(10) ||" ).append("\n"); 
		query.append("       'POL_COUN:'       || POL.CNT_CD                                                                           || CHR(10) ||" ).append("\n"); 
		query.append("       'POL_ETA:'        || ''                                                                                   || CHR(10) ||" ).append("\n"); 
		query.append("       'POL_ETD:'        || ''                                                                                   || CHR(10) ||" ).append("\n"); 
		query.append("       'POL_AMSQUAL:'    || DECODE(LENGTH(POL.LOC_AMS_PORT_CD), 4, 'D', 5, 'K', ' ')                             || CHR(10) ||" ).append("\n"); 
		query.append("       'POL_AMSPORT:'    || POL.LOC_AMS_PORT_CD                                                                  || CHR(10) ||" ).append("\n"); 
		query.append("       'BLPOD:'          || BKGM.POD_CD                                                                          || CHR(10) ||" ).append("\n"); 
		query.append("       'POD_NAME:'       || NVL(POD.LOC_NM,' ')                                                                  || CHR(10) ||" ).append("\n"); 
		query.append("       'POD_COUN:'       || POD.CNT_CD                                                                           || CHR(10) ||" ).append("\n"); 
		query.append("       'POD_ETA:'        || ''                                                                                   || CHR(10) ||" ).append("\n"); 
		query.append("       'POD_ETD:'        || ''                                                                                   || CHR(10) ||" ).append("\n"); 
		query.append("       'POD_AMSQUAL:'   || DECODE(LENGTH(POD.LOC_AMS_PORT_CD), 4, 'D', 5, 'K', ' ')                             || CHR(10) ||" ).append("\n"); 
		query.append("       'POD_AMSPORT:'   || POD.LOC_AMS_PORT_CD                                                                  || CHR(10) ||" ).append("\n"); 
		query.append("       'BLDEL:'          || BKGM.DEL_CD                                                                          || CHR(10) ||" ).append("\n"); 
		query.append("       'DEL_NAME:'       || NVL(DEL.LOC_NM,' ')                                                                  || CHR(10) ||" ).append("\n"); 
		query.append("       'DEL_COUN:'       || DEL.CNT_CD                                                                           || CHR(10) ||" ).append("\n"); 
		query.append("       'DEL_ETA:'        || ''                                                                                   || CHR(10) ||" ).append("\n"); 
		query.append("       'DEL_ETD:'        || ''                                                                                   || CHR(10) ||" ).append("\n"); 
		query.append("       'DEL_AMSQUAL:'    || DECODE(LENGTH(DEL.LOC_AMS_PORT_CD), 4, 'D', 5, 'K', ' ')                             || CHR(10) ||" ).append("\n"); 
		query.append("       'DEL_AMSPORT:'    || DEL.LOC_AMS_PORT_CD                                                                  || CHR(10) ||" ).append("\n"); 
		query.append("       'WUNIT:'          || 'G'                                                                                  || CHR(10) ||" ).append("\n"); 
		query.append("       'TOT_WGT:'        || BDOC.ACT_WGT                                       									 || CHR(10) ||" ).append("\n"); 
		query.append("       'MUNIT:'          || SUBSTR(BDOC.MEAS_UT_CD, 3, 1)                                                        || CHR(10) ||" ).append("\n"); 
		query.append("       'TOT_MEAS:'       || BDOC.MEAS_QTY									                                     || CHR(10) ||" ).append("\n"); 
		query.append("       'PUNIT:'          || BDOC.PCK_TP_CD                                                                       || CHR(10) ||" ).append("\n"); 
		query.append("       'TOT_PKG:'        || BDOC.PCK_QTY							                                             || CHR(10) ||" ).append("\n"); 
		query.append("       'RDTYP:'          || BKGM.RCV_TERM_CD ||BKGM.DE_TERM_CD                                                   || CHR(10) ||" ).append("\n"); 
		query.append("       'SCAC:'           || 'SMLM'                                                                           	 || CHR(10) ||" ).append("\n"); 
		query.append("       'SMOD:'           || BKGM.DEST_TRNS_SVC_MOD_CD                                                            || CHR(10) ||" ).append("\n"); 
		query.append("       'SMANC:'          || BKGM.OB_SREP_CD                                                                      || CHR(10) ||" ).append("\n"); 
		query.append("       'REMARK:'         || BKGM.INTER_RMK                                                                       || CHR(10) ||" ).append("\n"); 
		query.append("       'SMANN:'          || SREP.SREP_NM                                                                         || CHR(10) ||" ).append("\n"); 
		query.append("       'CMD:'            || NVL(CMDT.CMDT_CD, RCMDT.REP_CMDT_CD)                                                 || CHR(10) ||" ).append("\n"); 
		query.append("       'CMDD:'           || NVL(CMDT.CMDT_NM, RCMDT.REP_CMDT_NM)                                                 || CHR(10) ||" ).append("\n"); 
		query.append("       'CANCEL_BIT:'     || BKGM.BKG_STS_CD                                                                      || CHR(10) ||" ).append("\n"); 
		query.append("       'SALES_OFC:'      || BKGM.OB_SLS_OFC_CD                                                                   || CHR(10) ||" ).append("\n"); 
		query.append("       'CARGOTYPE:'      || BKGM.BKG_CGO_TP_CD                                                                   || CHR(10) ||" ).append("\n"); 
		query.append("       'DR_IND:'         || DECODE(BKGM.DCGO_FLG,'Y','1','0')                                                    || CHR(10) ||" ).append("\n"); 
		query.append("       'RF_IND:'         || DECODE(BKGM.RC_FLG,'Y','1','0')                                                      || CHR(10) ||" ).append("\n"); 
		query.append("       'AK_IND:'         || DECODE(BKGM.AWK_CGO_FLG,'Y','1','0')                                                 || CHR(10) ||" ).append("\n"); 
		query.append("       'BN_POD_DT:'      || TO_CHAR(ANTC.POD_ARR_DT , 'YYYYMMDDHH24MISS')                                        || CHR(10) ||" ).append("\n"); 
		query.append("       'BN_DEL_DT:'      || TO_CHAR(ANTC.DEL_ARR_DT , 'YYYYMMDDHH24MISS')         				 || CHR(10) ||" ).append("\n"); 
		query.append("       'BN_AVAIL_DT:'    || TO_CHAR(ANTC.PKUP_AVAL_DT , 'YYYYMMDDHH24MISS')      				 || CHR(10) ||" ).append("\n"); 
		query.append("       'BN_FREE_DT:'     || TO_CHAR(ANTC.PKUP_FREE_DT , 'YYYYMMDDHH24MISS')       				 || CHR(10) ||" ).append("\n"); 
		query.append("       'GEN_OR_DT:'      || TO_CHAR(ANTC.PKUP_FREE_DT + 15 , 'YYYYMMDDHH24MISS')  				 || CHR(10) ||" ).append("\n"); 
		query.append("       'BLINFO_FRTIND:' || DECODE(NVL(RATE.FRT_TERM_CD,''), 'C','CC','P','PP','')                             || CHR(10) ||" ).append("\n"); 
		query.append("       'ANDATE:'         || TO_CHAR(SYSDATE , 'YYYYMMDDHH24MISS')                                                || CHR(10) ||" ).append("\n"); 
		query.append("       'SAILDATE:'       || TO_CHAR(ANTC.POD_ARR_DT , 'YYYYMMDDHH24MISS')  || CHR(10)       " ).append("\n"); 
		query.append(" FROM BKG_BOOKING        BKGM                                                                                     " ).append("\n"); 
		query.append("    , BKG_VVD            BVVD" ).append("\n"); 
		query.append("    , MDM_VSL_CNTR       VSL" ).append("\n"); 
		query.append("    , BKG_BL_ISS         BISS" ).append("\n"); 
		query.append("    , VSK_VSL_PORT_SKD   VSK" ).append("\n"); 
		query.append("    , MDM_LOCATION       POR" ).append("\n"); 
		query.append("    , MDM_LOCATION       POL" ).append("\n"); 
		query.append("    , MDM_LOCATION       POD" ).append("\n"); 
		query.append("    , MDM_LOCATION       DEL" ).append("\n"); 
		query.append("    , BKG_BL_DOC         BDOC" ).append("\n"); 
		query.append("    , MDM_COMMODITY      CMDT" ).append("\n"); 
		query.append("    , MDM_REP_CMDT       RCMDT" ).append("\n"); 
		query.append("    , MDM_SLS_REP        SREP   " ).append("\n"); 
		query.append("    , BKG_ARR_NTC        ANTC" ).append("\n"); 
		query.append("    , BKG_RATE           RATE   " ).append("\n"); 
		query.append("WHERE BKGM.BKG_NO          = @[bkg_no]" ).append("\n"); 
		query.append("AND   BVVD.BKG_NO(+)       = BKGM.BKG_NO  " ).append("\n"); 
		query.append("AND   BVVD.POD_CD(+)       = BKGM.POD_CD                          " ).append("\n"); 
		query.append("AND   VSL.VSL_CD(+)        = BVVD.VSL_CD                         " ).append("\n"); 
		query.append("AND   BISS.BKG_NO(+)       = BKGM.BKG_NO                         " ).append("\n"); 
		query.append("AND   VSK.VSL_CD           = BVVD.VSL_CD" ).append("\n"); 
		query.append("AND   VSK.SKD_VOY_NO       = BVVD.SKD_VOY_NO" ).append("\n"); 
		query.append("AND   VSK.SKD_DIR_CD       = BVVD.SKD_DIR_CD" ).append("\n"); 
		query.append("AND   VSK.VPS_PORT_CD      = BVVD.POD_CD" ).append("\n"); 
		query.append("AND   VSK.CLPT_IND_SEQ     = BVVD.POD_CLPT_IND_SEQ                         " ).append("\n"); 
		query.append("AND   POR.LOC_CD           = BKGM.POR_CD" ).append("\n"); 
		query.append("AND   POL.LOC_CD           = BKGM.POL_CD" ).append("\n"); 
		query.append("AND   POD.LOC_CD           = BKGM.POD_CD" ).append("\n"); 
		query.append("AND   DEL.LOC_CD           = BKGM.DEL_CD                         " ).append("\n"); 
		query.append("AND   BDOC.BKG_NO          = BKGM.BKG_NO" ).append("\n"); 
		query.append("AND   CMDT.CMDT_CD(+)      = BKGM.CMDT_CD  " ).append("\n"); 
		query.append("AND   RCMDT.REP_CMDT_CD(+) = BKGM.REP_CMDT_CD" ).append("\n"); 
		query.append("AND   SREP.SREP_CD(+)      = BKGM.OB_SREP_CD" ).append("\n"); 
		query.append("AND   ANTC.BKG_NO          = BKGM.BKG_NO" ).append("\n"); 
		query.append("--AND   BCGO.BL_NO(+)        = BKGM.BL_NO" ).append("\n"); 
		query.append("AND   RATE.BKG_NO(+)       = BKGM.BKG_NO " ).append("\n"); 

	}
}