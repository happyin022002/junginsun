/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOsearchEdiFullCntrRlseOrderCntrInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.01
*@LastModifier : 
*@LastVersion : 1.0
* 2016.12.01 
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

public class CargoReleaseOrderDBDAOsearchEdiFullCntrRlseOrderCntrInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchEdiFullCntrRlseOrderCntrInfo
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOsearchEdiFullCntrRlseOrderCntrInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mty_rtn_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOsearchEdiFullCntrRlseOrderCntrInfoRSQL").append("\n"); 
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
		query.append("SELECT '{CNTR_INFO'                                 || CHR(10) ||" ).append("\n"); 
		query.append("       'CNTN:'|| BK.CNTR_NO                         || CHR(10) ||   -- 화면 입력 값 ( Container No ) " ).append("\n"); 
		query.append("       'CNTT:'|| BK.CNTR_TPSZ_CD                    || CHR(10) ||   -- 화면 입력값 ( Container Tp Size Code ) " ).append("\n"); 
		query.append("       'CNTR_SLOT:'|| BKG_GET_SLOT_NO_FNC(COP.COP_NO) || CHR(10) ||   -- CNTR_NO의 뒷자리 5문자 + AA" ).append("\n"); 
		query.append("       'HS_CD:' || (SELECT BCMD.CMDT_HS_CD " ).append("\n"); 
		query.append("                      FROM BKG_CNTR_MF_DESC BCMD " ).append("\n"); 
		query.append("                     WHERE BCMD.BKG_NO  = BK.BKG_NO " ).append("\n"); 
		query.append("                       AND BCMD.CNTR_NO = BK.CNTR_NO " ).append("\n"); 
		query.append("                       AND ROWNUM = 1)              || CHR(10) || " ).append("\n"); 
		query.append("       'RDIND:' || DECODE(BK.RD_CGO_FLG,'Y','1','0')|| CHR(10) ||     " ).append("\n"); 
		query.append("       'DIND:'|| DECODE(BK.DCGO_FLG,'Y','1','0')    || CHR(10) ||                 " ).append("\n"); 
		query.append("       'AIND:'|| DECODE(BK.AWK_CGO_FLG,'Y','1','0') || CHR(10) ||                 " ).append("\n"); 
		query.append("       'BIND:'|| DECODE(BK.BB_CGO_FLG,'Y','1','0')  || CHR(10) ||        " ).append("\n"); 
		query.append("       'RIND:'|| DECODE(BK.RC_FLG,'Y','1','0')      || CHR(10) ||  " ).append("\n"); 
		query.append("       'TEMP:'|| RF.FDO_TEMP   					    || CHR(10) ||           " ).append("\n"); 
		query.append("       'TUN:' || 'F'                                || CHR(10) || " ).append("\n"); 
		query.append("       'TEMP_C:'|| RF.CDO_TEMP   		     	    || CHR(10) ||           " ).append("\n"); 
		query.append("       'TUN_C:' || 'C'                              || CHR(10) || " ).append("\n"); 
		query.append("       'VENT:'  || CASE WHEN NVL(RF.VENT_RTO,0) = 0 THEN 'C'" ).append("\n"); 
		query.append("						WHEN NVL(RF.VENT_RTO,0) > 0 AND NVL(RF.VENT_RTO,0) < 35 THEN 'Q'" ).append("\n"); 
		query.append("						WHEN NVL(RF.VENT_RTO,0) >= 35 AND NVL(RF.VENT_RTO,0) < 65 THEN 'H'" ).append("\n"); 
		query.append("						WHEN NVL(RF.VENT_RTO,0) >= 65 AND NVL(RF.VENT_RTO,0) < 100 THEN 'T'" ).append("\n"); 
		query.append("						WHEN NVL(RF.VENT_RTO,0) = 100 THEN 'O' ELSE 'M' END		|| CHR(10) || " ).append("\n"); 
		query.append("       'VENT_NUM:' || RF.VENT_RTO || CHR(10) || " ).append("\n"); 
		query.append("       'VENT_CMH:' || RF.CBM_PER_HR_QTY || CHR(10) || " ).append("\n"); 
		query.append("       'GENSET:' || RF.PWR_SPL_CBL_FLG              || CHR(10) || " ).append("\n"); 
		query.append("       'RF_REMARK:' || REPLACE(RF.DIFF_RMK, CHR(10), ' ') || CHR(10) || " ).append("\n"); 
		query.append("       'AK_UNIT:'   || AK.WGT_UT_CD                 || CHR(10) || " ).append("\n"); 
		query.append("       'OVF:'       || AK.OVR_FWRD_LEN              || CHR(10) || " ).append("\n"); 
		query.append("       'OVR:'       || AK.OVR_BKWD_LEN              || CHR(10) || " ).append("\n"); 
		query.append("       'OVH:'       || AK.OVR_HGT                   || CHR(10) || " ).append("\n"); 
		query.append("       'OVLW:'      || AK.OVR_LF_LEN                || CHR(10) || " ).append("\n"); 
		query.append("       'OVRW:'      || AK.OVR_RT_LEN                || CHR(10) || " ).append("\n"); 
		query.append("       'OVWGT:'     || AK.GRS_WGT                   || CHR(10) || " ).append("\n"); 
		query.append("       'VOID_SLOT:' || AK.OVR_VOID_SLT_QTY          || CHR(10) || " ).append("\n"); 
		query.append("       'STWG_REQ:'  || AK.STWG_RQST_DESC            || CHR(10) || " ).append("\n"); 
		query.append("       'EQRTN:'     || NVL(@[mty_rtn_yd_cd], BUT.NOD_CD)              || CHR(10) || " ).append("\n"); 
		query.append("       'EQRTN_DT:'  || TO_CHAR(BUT.ACT_DT, 'RRRRMMDDHH24MI') || CHR(10) || " ).append("\n"); 
		query.append("       'CSTMS_VOY_NO:' || @[cstms_voy_no]           || CHR(10) || " ).append("\n"); 
		query.append("       'CSTMS_CONSORT_VOY:'                         || CHR(10)            " ).append("\n"); 
		query.append("FROM   BKG_CONTAINER BK" ).append("\n"); 
		query.append("     , BKG_RF_CGO RF" ).append("\n"); 
		query.append("     , BKG_AWK_CGO AK" ).append("\n"); 
		query.append("     , (SELECT /*+ INDEX_ASC(D XPKSCE_COP_DTL)*/ D.NOD_CD, H.BKG_NO, H.CNTR_NO, NVL(D.ACT_DT, D.ESTM_DT) ACT_DT" ).append("\n"); 
		query.append("            FROM SCE_COP_HDR H," ).append("\n"); 
		query.append("                 SCE_COP_DTL D," ).append("\n"); 
		query.append("                 SCE_ACT_ACT_MAPG MPG" ).append("\n"); 
		query.append("           WHERE H.COP_NO = D.COP_NO" ).append("\n"); 
		query.append("             AND H.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("             AND H.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("             AND H.COP_STS_CD <> 'X'" ).append("\n"); 
		query.append("             AND D.ACT_CD = MPG.ACT_CD" ).append("\n"); 
		query.append("             AND MPG.ACT_STS_MAPG_CD = 'MT'" ).append("\n"); 
		query.append("             AND D.ACT_CD ='MITYAD'" ).append("\n"); 
		query.append("             AND ROWNUM=1) BUT" ).append("\n"); 
		query.append("       , (SELECT COP_NO , BKG_NO, CNTR_NO, COP_STS_CD" ).append("\n"); 
		query.append("           FROM SCE_COP_HDR SCHC" ).append("\n"); 
		query.append("           WHERE SCHC.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("            AND  SCHC.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("            AND  SCHC.COP_STS_CD <> 'X'" ).append("\n"); 
		query.append("            AND ROWNUM =1 ) COP" ).append("\n"); 
		query.append("WHERE BK.BKG_NO  = @[bkg_no]" ).append("\n"); 
		query.append("  AND BK.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("  AND BK.BKG_NO  = RF.BKG_NO (+)" ).append("\n"); 
		query.append("  AND BK.BKG_NO  = AK.BKG_NO(+)" ).append("\n"); 
		query.append("  AND BK.BKG_NO  = BUT.BKG_NO(+)" ).append("\n"); 
		query.append("  AND BK.CNTR_NO = BUT.CNTR_NO(+)" ).append("\n"); 
		query.append("  AND BK.BKG_NO = COP.BKG_NO (+)" ).append("\n"); 
		query.append("  AND BK.CNTR_NO = COP.CNTR_NO (+)" ).append("\n"); 
		query.append("  AND COP.COP_STS_CD (+) <> 'X'" ).append("\n"); 

	}
}