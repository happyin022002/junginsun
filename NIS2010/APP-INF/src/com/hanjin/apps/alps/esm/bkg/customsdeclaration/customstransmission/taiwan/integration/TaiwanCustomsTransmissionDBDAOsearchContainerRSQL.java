/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TaiwanCustomsTransmissionDBDAOsearchContainerRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.20
*@LastModifier : 임재택
*@LastVersion : 1.0
* 2009.08.20 임재택
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.taiwan.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author LIM JAE TAEK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TaiwanCustomsTransmissionDBDAOsearchContainerRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 대만세관 신고용 Manifest Container 정보를 조회한다.
	  * </pre>
	  */
	public TaiwanCustomsTransmissionDBDAOsearchContainerRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.taiwan.integration").append("\n"); 
		query.append("FileName : TaiwanCustomsTransmissionDBDAOsearchContainerRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("NVL(C.CNTR_NO,' ') cntrnbr," ).append("\n"); 
		query.append("NVL(C.PCK_TP_CD,' ') punit," ).append("\n"); 
		query.append("NVL(C.PCK_QTY,0) pkg," ).append("\n"); 
		query.append("DECODE(NVL(C.WGT_UT_CD,' '),'LBS'," ).append("\n"); 
		query.append("ROUND(NVL(C.CNTR_WGT,0)*0.4536,3)" ).append("\n"); 
		query.append(",NVL(C.CNTR_WGT,0)) cntrwgt," ).append("\n"); 
		query.append("NVL(C.CNTR_TPSZ_CD,' ') cntrtype," ).append("\n"); 
		query.append("NVL(S.CNTR_SEAL_NO,' ') sealnbr," ).append("\n"); 
		query.append("@[bkgcgotp] fm_ind, -- searchBlGeneral ( ) 에서 조회한 값" ).append("\n"); 
		query.append("@[bkgsperf] rf_ind, -- searchBlGeneral ( ) 에서 조회한 값" ).append("\n"); 
		query.append("@[bkgspedg] dg_ind, -- searchBlGeneral ( ) 에서 조회한 값" ).append("\n"); 
		query.append("@[bkgspeak] ak_ind, -- searchBlGeneral ( ) 에서 조회한 값" ).append("\n"); 
		query.append("@[bkgspebb] bk_ind, -- searchBlGeneral ( ) 에서 조회한 값" ).append("\n"); 
		query.append("NVL(R.CDO_TEMP,0) temp," ).append("\n"); 
		query.append("'C' tunit," ).append("\n"); 
		query.append("' ' vent," ).append("\n"); 
		query.append("DECODE(NVL(C.MEAS_UT_CD,' '),'CBF'," ).append("\n"); 
		query.append("ROUND(NVL(C.MEAS_QTY,0)*0.0283,3)," ).append("\n"); 
		query.append("NVL(C.MEAS_QTY,0)) measure," ).append("\n"); 
		query.append("NVL(C.RCV_TERM_CD,' ')" ).append("\n"); 
		query.append("|| NVL(C. DE_TERM_CD,' ') rdtype," ).append("\n"); 
		query.append("@[cmdtdesc] cmdt_desc, -- searchBlGeneral ( ) 에서 조회한 값" ).append("\n"); 
		query.append("@[cmdtcd] cmdtcd, -- searchBlGeneral ( ) 에서 조회한 값" ).append("\n"); 
		query.append("REPLACE(NVL(R.DIFF_RMK,' '),CHR(13)||CHR(10),' ') rf_remark," ).append("\n"); 
		query.append("@[bkgsperd] rfdry_ind, -- searchBlGeneral ( ) 에서 조회한 값" ).append("\n"); 
		query.append("NVL(A.OVR_FWRD_LEN,0) ovf," ).append("\n"); 
		query.append("NVL(A.OVR_BKWD_LEN,0) ovr," ).append("\n"); 
		query.append("NVL(A.OVR_HGT,0) ovh," ).append("\n"); 
		query.append("NVL(A.OVR_LF_LEN,0) ovlw," ).append("\n"); 
		query.append("NVL(A.OVR_RT_LEN,0) ovrw," ).append("\n"); 
		query.append("DECODE(NVL(A.WGT_UT_CD,' '),'LBS',ROUND(NVL(A.GRS_WGT,0)*0.4536,3),NVL(A.GRS_WGT,0)) ovwgt," ).append("\n"); 
		query.append("NVL(A.OVR_VOID_SLT_QTY,0) void_slot," ).append("\n"); 
		query.append("NVL(A.STWG_RQST_DESC,' ') stwg_req, C.CNTR_NO" ).append("\n"); 
		query.append("FROM BKG_CONTAINER C, BKG_RF_CGO R, BKG_AWK_CGO A, BKG_CNTR_SEAL_NO S" ).append("\n"); 
		query.append("WHERE C.BKG_NO        = @[bkg_no]" ).append("\n"); 
		query.append("AND C.BKG_NO     = R.BKG_NO(+)" ).append("\n"); 
		query.append("AND C.CNTR_NO   = R.CNTR_NO(+)" ).append("\n"); 
		query.append("AND C.BKG_NO     = A.BKG_NO(+)" ).append("\n"); 
		query.append("AND C.CNTR_NO   = A.CNTR_NO(+)" ).append("\n"); 
		query.append("AND C.BKG_NO     = S.BKG_NO(+)" ).append("\n"); 
		query.append("AND C.CNTR_NO   = S.CNTR_NO(+)" ).append("\n"); 

	}
}