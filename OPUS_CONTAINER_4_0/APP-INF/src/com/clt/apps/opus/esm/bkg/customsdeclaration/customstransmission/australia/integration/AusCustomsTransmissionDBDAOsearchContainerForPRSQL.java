/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AusCustomsTransmissionDBDAOsearchContainerForPRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.10
*@LastModifier :
*@LastVersion : 1.0
* 2010.04.10
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AusCustomsTransmissionDBDAOsearchContainerForPRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * 호주 항만청으로 전송할 Manifest Container 정보를 조회한다.
	  * </pre>
	  */
	public AusCustomsTransmissionDBDAOsearchContainerForPRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_spe_dg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_desc",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_spe_ak",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_spe_rd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_spe_bb",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_spe_rf",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_cgo_tp",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.integration").append("\n");
		query.append("FileName : AusCustomsTransmissionDBDAOsearchContainerForPRSQL").append("\n");
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
		query.append("		NVL(C.CNTR_NO,'') cntrnbr," ).append("\n");
		query.append("		NVL(C.PCK_TP_CD,'') punit," ).append("\n");
		query.append("		NVL(C.PCK_QTY,0) pkg," ).append("\n");
		query.append("		DECODE(NVL(C.WGT_UT_CD,''),'LBS'," ).append("\n");
		query.append("		ROUND(NVL(C.CNTR_WGT,0)*0.4536,3)" ).append("\n");
		query.append("		,NVL(C.CNTR_WGT,0)) cntrwgt," ).append("\n");
		query.append("		NVL(B.CNTR_TPSZ_ISO_CD,'') cntrtype," ).append("\n");
		query.append("		(  SELECT NVL(MIN(CNTR_SEAL_NO),' ') " ).append("\n");
		query.append("		   FROM BKG_CNTR_SEAL_NO" ).append("\n");
		query.append("		   WHERE BKG_NO = C.BKG_NO" ).append("\n");
		query.append("		   AND CNTR_NO = C.CNTR_NO) sealnbr," ).append("\n");
		query.append("		@[bkg_cgo_tp] fm_ind,		-- searchBlGeneralForM () 오퍼레이션에서 조회한 값" ).append("\n");
		query.append("		@[bkg_spe_rf] rf_ind,		-- searchBlGeneralForM () 오퍼레이션에서 조회한 값" ).append("\n");
		query.append("		@[bkg_spe_dg] dg_ind,		-- searchBlGeneralForM () 오퍼레이션에서 조회한 값" ).append("\n");
		query.append("		@[bkg_spe_ak] ak_ind,		-- searchBlGeneralForM () 오퍼레이션에서 조회한 값" ).append("\n");
		query.append("		@[bkg_spe_bb] bk_ind,		-- searchBlGeneralForM () 오퍼레이션에서 조회한 값" ).append("\n");
		query.append("		NVL(R.CDO_TEMP,0) temp," ).append("\n");
		query.append("		'C' tunit," ).append("\n");
		query.append("		 '' vent," ).append("\n");
		query.append("		DECODE(NVL(C.MEAS_UT_CD,''),'CBF'," ).append("\n");
		query.append("		ROUND(NVL(C.MEAS_QTY,0)*0.0283,3)," ).append("\n");
		query.append("		NVL(C.MEAS_QTY,0)) measure," ).append("\n");
		query.append("		NVL(C.RCV_TERM_CD,'')" ).append("\n");
		query.append("		||NVL(C. DE_TERM_CD,'') rdtype," ).append("\n");
		query.append("		@[cmdt_desc] cmdt_desc,		-- searchBlGeneralForM () 오퍼레이션에서 조회한 값" ).append("\n");
		query.append("		@[cmdt_cd] cmdtcd,		-- searchBlGeneralForM () 오퍼레이션에서 조회한 값" ).append("\n");
		query.append("		REPLACE(NVL(R.DIFF_RMK,''),CHR(10),'') rf_remark," ).append("\n");
		query.append("		@[bkg_spe_rd] rfdry_ind,		-- searchBlGeneralForM () 오퍼레이션에서 조회한 값" ).append("\n");
		query.append("		NVL(A.OVR_FWRD_LEN,0) ovf," ).append("\n");
		query.append("		NVL(A.OVR_BKWD_LEN,0) ovr," ).append("\n");
		query.append("		NVL(A.OVR_HGT,0) ovh," ).append("\n");
		query.append("		NVL(A.OVR_LF_LEN,0) ovlw," ).append("\n");
		query.append("		NVL(A.OVR_RT_LEN,0) ovrw," ).append("\n");
		query.append("		DECODE(NVL(A.WGT_UT_CD,''),'LBS',ROUND(NVL(A.GRS_WGT,0)*0.4536,3),NVL(A.GRS_WGT,0)) ovwgt," ).append("\n");
		query.append("		NVL(A.OVR_VOID_SLT_QTY,0) void_slot," ).append("\n");
		query.append("		NVL(A.STWG_RQST_DESC,'') stwg_req," ).append("\n");
		query.append("        C.CNTR_NO" ).append("\n");
		query.append("FROM BKG_CONTAINER C,BKG_RF_CGO R, BKG_AWK_CGO A, MDM_CNTR_TP_SZ B" ).append("\n");
		query.append("WHERE	C.BKG_NO        = R.BKG_NO(+)" ).append("\n");
		query.append("AND	C.CNTR_NO       = R.CNTR_NO(+)" ).append("\n");
		query.append("AND	C.BKG_NO        = @[bkg_no] " ).append("\n");
		query.append("AND	C.BKG_NO        = A.BKG_NO(+)" ).append("\n");
		query.append("AND	C.CNTR_NO        = A.CNTR_NO(+)" ).append("\n");
		query.append("AND C.CNTR_TPSZ_CD 	  = B.CNTR_TPSZ_CD(+)" ).append("\n");

	}
}