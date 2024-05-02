/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOSearchEdiEdoCusagdDoMstRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.30
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.30 
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

public class CargoReleaseOrderDBDAOSearchEdiEdoCusagdDoMstRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * .
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOSearchEdiEdoCusagdDoMstRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOSearchEdiEdoCusagdDoMstRSQL").append("\n"); 
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
		query.append("SELECT  '$$$MSGSTART:'  " ).append("\n"); 
		query.append("     || 'SSCOMC0001          '" ).append("\n"); 
		query.append("     || 'KTNMFCSDO           '" ).append("\n"); 
		query.append("     || 'CUSAGD    '                              " ).append("\n"); 
		query.append("     ||  RPAD(NVL(TRIM('EDO'),' '),3) ||" ).append("\n"); 
		query.append("         TO_CHAR(SYSDATE,'rrmmdd')    ||" ).append("\n"); 
		query.append("         LTRIM(TO_CHAR(BKG_DO_EDI_SEQ.nextval,'00009'),' ')                     || CHR(10)" ).append("\n"); 
		query.append("     || 'MRN_NO:'         || MSN.MF_REF_NO||MSN.MRN_CHK_NO                      || CHR(10)" ).append("\n"); 
		query.append("     || 'ARV_DTM:'        || TO_CHAR(VSKD.VPS_ETA_DT, 'YYYYMMDD')               || CHR(10)" ).append("\n"); 
		query.append("     || 'DO_ISS:'         || COM_ConstantMgr_PKG.COM_getScacCode_FNC 		    || CHR(10)" ).append("\n"); 
		query.append("     || 'VSL_VD:'         || BVVD.SKD_VOY_NO || BVVD.SKD_DIR_CD                 || CHR(10)" ).append("\n"); 
		query.append("     || 'VSL_NM:'         || VSL.VSL_ENG_NM                     				|| CHR(10)" ).append("\n"); 
		query.append("     || 'POL_LOC:'        || BK.POL_CD                     					    || CHR(10)" ).append("\n"); 
		query.append("     || 'POD_LOC:'        || BK.POD_CD                     					    || CHR(10)" ).append("\n"); 
		query.append("     || 'DEL_LOC:'        || BK.DEL_CD                     					    || CHR(10)" ).append("\n"); 
		query.append("     || 'BL_NO:'          || BK.BL_NO                       					|| CHR(10)" ).append("\n"); 
		query.append("     || 'MSN_NO:'         || MSN.MF_SEQ_NO                					    || CHR(10)" ).append("\n"); 
		query.append("     || 'DO_NO:'          || BDO.DO_NO || BDO.DO_NO_SPLIT                       || CHR(10)" ).append("\n"); 
		query.append("     || 'DO_DTM:'         || TO_CHAR(BDDTL.EVNT_DT, 'YYYYMMDDHH24MISS')         || CHR(10)" ).append("\n"); 
		query.append("     || 'BL_TP:'          || MSN.KR_CSTMS_BL_TP_CD             					|| CHR(10)" ).append("\n"); 
		query.append("     || 'BND_TP:'         || MSN.BD_TP_CD                     					|| CHR(10)" ).append("\n"); 
		query.append("     || 'BRAC:'           || DECODE ( (SELECT COUNT(*)                      " ).append("\n"); 
		query.append("                                         FROM BKG_EDO_LOG " ).append("\n"); 
		query.append("                                         WHERE BKG_NO = BK.BKG_NO " ).append("\n"); 
		query.append("                                          AND EDO_RSLT_CD  = 'A' ),0,'O','U' )                  || CHR(10)" ).append("\n"); 
		query.append("     || 'SELF_IND:'      ||  DECODE(BDO.SELF_TRNS_FLG,'Y','S','N')                     		    || CHR(10)" ).append("\n"); 
		query.append("     || 'CNEE_NM:'       || SUBSTR(REPLACE(NVL(CN.CUST_NM,' ')  ,CHR(10),' '),1,  35)  || CHR(10)" ).append("\n"); 
		query.append("     || 'CNEE_ADDR1:'    || SUBSTR(REPLACE(NVL(CN.CUST_ADDR,' '),CHR(10),' '),1,  35)  || CHR(10)" ).append("\n"); 
		query.append("     || 'CNEE_ADDR2:'    || SUBSTR(REPLACE(NVL(CN.CUST_ADDR,' '),CHR(10),' '),36, 35)  || CHR(10)" ).append("\n"); 
		query.append("     || 'CNEE_ADDR3:'    || SUBSTR(REPLACE(NVL(CN.CUST_ADDR,' '),CHR(10),' '),70, 35)  || CHR(10)" ).append("\n"); 
		query.append("     || 'NTFY_NM:'       || SUBSTR(REPLACE(NVL(NF.CUST_NM,' ')  ,CHR(10),' '),1,  35)  || CHR(10)" ).append("\n"); 
		query.append("     || 'NTFY_ADDR1:'    || SUBSTR(REPLACE(NVL(NF.CUST_ADDR,' '),CHR(10),' '),1,  35)  || CHR(10)" ).append("\n"); 
		query.append("     || 'NTFY_ADDR2:'    || SUBSTR(REPLACE(NVL(NF.CUST_ADDR,' '),CHR(10),' '),36, 35)  || CHR(10)" ).append("\n"); 
		query.append("     || 'NTFY_ADDR3:'    || SUBSTR(REPLACE(NVL(NF.CUST_ADDR,' '),CHR(10),' '),70, 35)  || CHR(10)" ).append("\n"); 
		query.append("     || 'ASHP_NM:'       ||SUBSTR(NVL(REPLACE(DECODE(BK.CUST_TO_ORD_FLG, 'Y', NF.CUST_NM, CN.CUST_NM), CHR(10),' '), ' ') , 1, 35)                     || CHR(10)" ).append("\n"); 
		query.append("     || 'ASHP_NO:'       ||BDO.RCVR_BIZ_NO                     					|| CHR(10)" ).append("\n"); 
		query.append("     || 'TRUCKER:'       || ''                     						|| CHR(10)" ).append("\n"); 
		query.append("     || 'DISC_LOC1:'     || MSN.CSTMS_DCHG_LOC_WH_CD               				|| CHR(10)" ).append("\n"); 
		query.append("     || 'DISC_LOC2:'     || DECODE( MSN.CSTMS_CLR_WH_CD,'0000000004', MSN.CSTMS_DCHG_LOC_WH_CD" ).append("\n"); 
		query.append("                                                       ,'0000000012', MSN.CSTMS_DCHG_LOC_WH_CD" ).append("\n"); 
		query.append("                                                       ,'0000000018', MSN.CSTMS_DCHG_LOC_WH_CD" ).append("\n"); 
		query.append("                                                       ,'0000000014', MSN.CSTMS_DCHG_LOC_WH_CD" ).append("\n"); 
		query.append("                                                       ,'0000000017', MSN.CSTMS_DCHG_LOC_WH_CD" ).append("\n"); 
		query.append("                                                       ,'0000000006', MSN.CSTMS_DCHG_LOC_WH_CD" ).append("\n"); 
		query.append("                                                       ,'0000000003', MSN.CSTMS_DCHG_LOC_WH_CD" ).append("\n"); 
		query.append("                                                       ,MSN.CSTMS_CLR_WH_CD)                   || CHR(10)  -- DISC_LOC2" ).append("\n"); 
		query.append("     || 'CMDT_DESC:'     || CMDT.REP_CMDT_NM                     	                           || CHR(10)" ).append("\n"); 
		query.append("     || 'PKG_NO:'        || TO_CHAR(DOC.PCK_QTY)                     	                       || CHR(10)" ).append("\n"); 
		query.append("     || 'PKG_CD:'        ||  DOC.PCK_TP_CD                     		                           || CHR(10)" ).append("\n"); 
		query.append("     || 'WGT_QTY:'       || TO_CHAR(DOC.ACT_WGT)                     	                       || CHR(10)" ).append("\n"); 
		query.append("     || 'MEA_QTY:'       || TO_CHAR(DOC.MEAS_QTY)                      	                       || CHR(10)" ).append("\n"); 
		query.append("     || 'CNTR_CNT:'      ||  ( SELECT TO_CHAR(COUNT(*))" ).append("\n"); 
		query.append("                               FROM BKG_CONTAINER CNTR" ).append("\n"); 
		query.append("                               WHERE CNTR.BKG_NO = BK.BKG_NO )                     	           || CHR(10)" ).append("\n"); 
		query.append("FROM BKG_BOOKING  BK" ).append("\n"); 
		query.append("   , BKG_CSTMS_KR_MF_SEQ_NO MSN" ).append("\n"); 
		query.append("   , BKG_VVD      BVVD" ).append("\n"); 
		query.append("   , VSK_VSL_PORT_SKD VSKD" ).append("\n"); 
		query.append("   , MDM_VSL_CNTR VSL" ).append("\n"); 
		query.append("   , BKG_DO       BDO " ).append("\n"); 
		query.append("   , BKG_DO_DTL   BDDTL " ).append("\n"); 
		query.append("   , BKG_CUSTOMER CN" ).append("\n"); 
		query.append("   , BKG_CUSTOMER NF" ).append("\n"); 
		query.append("   , MDM_REP_CMDT CMDT" ).append("\n"); 
		query.append("   , BKG_BL_DOC   DOC" ).append("\n"); 
		query.append("WHERE BK.BKG_NO=@[bkg_no]" ).append("\n"); 
		query.append("  AND BVVD.BKG_NO          = BK.BKG_NO " ).append("\n"); 
		query.append("  AND BVVD.POD_CD          = BK.POD_CD" ).append("\n"); 
		query.append("  AND BVVD.VSL_PRE_PST_CD IN ('T', 'U')  " ).append("\n"); 
		query.append("  AND VSKD.VSL_CD(+)       = BVVD.VSL_CD " ).append("\n"); 
		query.append("  AND VSKD.SKD_VOY_NO(+)   = BVVD.SKD_VOY_NO " ).append("\n"); 
		query.append("  AND VSKD.SKD_DIR_CD(+)   = BVVD.SKD_DIR_CD " ).append("\n"); 
		query.append("  AND VSKD.VPS_PORT_CD(+)  = BVVD.POD_CD " ).append("\n"); 
		query.append("  AND VSKD.CLPT_IND_SEQ(+) = BVVD.POD_CLPT_IND_SEQ  " ).append("\n"); 
		query.append("  AND VSL.VSL_CD           = BVVD.VSL_CD " ).append("\n"); 
		query.append("  AND BDO.BKG_NO(+)        = BK.BKG_NO " ).append("\n"); 
		query.append("  AND BDO.RLSE_SEQ(+)      = 1" ).append("\n"); 
		query.append("  AND BDDTL.BKG_NO(+)      = BDO.BKG_NO  " ).append("\n"); 
		query.append("  AND BDDTL.RLSE_SEQ(+)    = BDO.RLSE_SEQ  " ).append("\n"); 
		query.append("  AND BDDTL.RLSE_STS_CD(+) = 'R'" ).append("\n"); 
		query.append("  AND BK.BKG_NO            = CN.BKG_NO" ).append("\n"); 
		query.append("  AND CN.BKG_CUST_TP_CD    = 'C'" ).append("\n"); 
		query.append("  AND BK.BKG_NO            = NF.BKG_NO" ).append("\n"); 
		query.append("  AND NF.BKG_CUST_TP_CD    = 'N' " ).append("\n"); 
		query.append("  AND CMDT.REP_CMDT_CD(+)  =  BK.REP_CMDT_CD" ).append("\n"); 
		query.append("  AND DOC.BKG_NO           = BK.BKG_NO" ).append("\n"); 
		query.append("  AND MSN.BKG_NO           = BK.BKG_NO" ).append("\n"); 
		query.append("  AND MSN.MF_CFM_FLG       = 'Y'" ).append("\n"); 
		query.append("  AND MSN.MRN_BL_TS_CD     = 'I'" ).append("\n"); 
		query.append("  AND MSN.CFM_DT           = ( SELECT MAX(SEQ.CFM_DT) " ).append("\n"); 
		query.append("                               FROM BKG_CSTMS_KR_MF_SEQ_NO SEQ" ).append("\n"); 
		query.append("                               WHERE SEQ.BKG_NO     = @[bkg_no]" ).append("\n"); 
		query.append("                               AND   SEQ.MF_CFM_FLG  = 'Y'" ).append("\n"); 
		query.append("                               AND   SEQ.MRN_BL_TS_CD  = 'I' )" ).append("\n"); 

	}
}