/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : HongKongCustomsTransmissionDBDAOsearchCntrDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.09
*@LastModifier : 조원주
*@LastVersion : 1.0
* 2012.10.09 조원주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.hongkong.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHO WON-JOO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class HongKongCustomsTransmissionDBDAOsearchCntrDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 홍콩세관 신고용 Manifest Container Detail 정보를 조회한다.
	  * </pre>
	  */
	public HongKongCustomsTransmissionDBDAOsearchCntrDetailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkgspeak",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkgspedg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdtdesc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkgcgotp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkgsperd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amend_bl",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkgspebb",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkgsperf",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdtcd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.hongkong.integration").append("\n"); 
		query.append("FileName : HongKongCustomsTransmissionDBDAOsearchCntrDetailRSQL").append("\n"); 
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
		query.append("SELECT   " ).append("\n"); 
		query.append("           NVL(C.CNTR_NO,'') CNTRNBR," ).append("\n"); 
		query.append("           NVL(C.PCK_TP_CD,'') PUNIT," ).append("\n"); 
		query.append("           NVL(C.PCK_QTY,0) PKG," ).append("\n"); 
		query.append("           NVL(C.WGT_UT_CD,'') WUNIT," ).append("\n"); 
		query.append("           DECODE(NVL(C.WGT_UT_CD,''),'LBS', ROUND(NVL(C.CNTR_WGT,0)*0.4536,3),NVL(C.CNTR_WGT,0)) CNTRWGT," ).append("\n"); 
		query.append("           NVL(C.CNTR_TPSZ_CD,'') CNTRTYPE," ).append("\n"); 
		query.append("			(  SELECT NVL(MIN(CNTR_SEAL_NO),'') " ).append("\n"); 
		query.append("			   FROM BKG_CNTR_SEAL_NO" ).append("\n"); 
		query.append("			   WHERE BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("			   AND CNTR_NO = C.CNTR_NO) SEALNBR," ).append("\n"); 
		query.append("           @[bkgcgotp] FM_IND, -- searchBlGeneral ( ) 에서 조회한 값" ).append("\n"); 
		query.append("           @[bkgsperf] RF_IND, -- searchBlGeneral ( ) 에서 조회한 값" ).append("\n"); 
		query.append("           @[bkgspedg] DG_IND, -- searchBlGeneral ( ) 에서 조회한 값" ).append("\n"); 
		query.append("           @[bkgspeak] AK_IND, -- searchBlGeneral ( ) 에서 조회한 값" ).append("\n"); 
		query.append("           @[bkgspebb] BK_IND, -- searchBlGeneral ( ) 에서 조회한 값" ).append("\n"); 
		query.append("           NVL(R.CDO_TEMP,'') TEMP," ).append("\n"); 
		query.append("           DECODE(R.CDO_TEMP,NULL,'','','','C') TUNIT," ).append("\n"); 
		query.append("           '' VENT," ).append("\n"); 
		query.append("           NVL(C.MEAS_UT_CD,'') MUNIT," ).append("\n"); 
		query.append("           DECODE(NVL(C.MEAS_UT_CD,''),'CBF', ROUND(NVL(C.MEAS_QTY,0)*0.0283,3), NVL(C.MEAS_QTY,0)) MEASURE," ).append("\n"); 
		query.append("           NVL(C.RCV_TERM_CD,'')||NVL(C.DE_TERM_CD,'') RDTYPE," ).append("\n"); 
		query.append("           @[cmdtdesc] CMDT_DESC, -- searchBlGeneral ( ) 에서 조회한 값" ).append("\n"); 
		query.append("           @[cmdtcd] CMDTCD, -- searchBlGeneral ( ) 에서 조회한 값" ).append("\n"); 
		query.append("           REPLACE(NVL(R.DIFF_RMK,''),CHR(13)||CHR(10),'') RF_REMARK," ).append("\n"); 
		query.append("           @[bkgsperd] RFDRY_IND, -- searchBlGeneral ( ) 에서 조회한 값" ).append("\n"); 
		query.append("           NVL(A.OVR_FWRD_LEN,0) OVF," ).append("\n"); 
		query.append("           NVL(A.OVR_BKWD_LEN,0) OVR," ).append("\n"); 
		query.append("           NVL(A.OVR_HGT,0) OVH," ).append("\n"); 
		query.append("           NVL(A.OVR_LF_LEN,0) OVLW," ).append("\n"); 
		query.append("           NVL(A.OVR_RT_LEN,0) OVRW," ).append("\n"); 
		query.append("           DECODE(NVL(A.WGT_UT_CD,''),'LBS',ROUND(NVL(A.GRS_WGT,0)*0.4536,3),NVL(A.GRS_WGT,0)) OVWGT," ).append("\n"); 
		query.append("           NVL(A.OVR_VOID_SLT_QTY,0) VOID_SLOT," ).append("\n"); 
		query.append("           SUBSTR(REPLACE(REPLACE(NVL(STWG_RQST_DESC,''),CHR(10),''),CHR(13),''),1,512) STWG_REQ," ).append("\n"); 
		query.append("           NVL(@[amend_bl],'N') AMEND_CNTR, -- searchBlGeneral ( ) 에서 조회한 값" ).append("\n"); 
		query.append("           NVL(D.CSTMS_DESC,'') CUSTOMS_DESC, C.CNTR_NO" ).append("\n"); 
		query.append("      FROM BKG_CONTAINER C, BKG_RF_CGO R, BKG_AWK_CGO A, BKG_BL_DOC D" ).append("\n"); 
		query.append("     WHERE C.BKG_NO        = @[bkg_no]" ).append("\n"); 
		query.append("       AND C.BKG_NO        = R.BKG_NO(+)" ).append("\n"); 
		query.append("       AND C.CNTR_NO       = R.CNTR_NO(+)" ).append("\n"); 
		query.append("       AND C.BKG_NO        = A.BKG_NO(+)" ).append("\n"); 
		query.append("       AND C.CNTR_NO       = A.CNTR_NO(+)" ).append("\n"); 
		query.append("       AND C.BKG_NO        = D.BKG_NO(+)" ).append("\n"); 

	}
}