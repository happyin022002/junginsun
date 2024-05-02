/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : HongKongCustomsTransmissionDBDAOsearchCntrDangerRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.19
*@LastModifier : 김승민
*@LastVersion : 1.0
* 2010.02.19 김승민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.hongkong.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM SEUNG MIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class HongKongCustomsTransmissionDBDAOsearchCntrDangerRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * 홍콩세관 신고용 Manifest Container Danger 정보를 조회한다.
	  * </pre>
	  */
	public HongKongCustomsTransmissionDBDAOsearchCntrDangerRSQL(){
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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.hongkong.integration").append("\n");
		query.append("FileName : HongKongCustomsTransmissionDBDAOsearchCntrDangerRSQL").append("\n");
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
		query.append("SELECT  " ).append("\n");
		query.append("   'UNNBR:'||NVL(DG.IMDG_UN_NO,'') UNNBR," ).append("\n");
		query.append("   'CLASS:'||NVL(UN.IMDG_CLSS_CD,'') IMDG_CLSS_CD," ).append("\n");
		query.append("   'DESC:'||NVL(DG.PRP_SHP_NM,'') DESCNM," ).append("\n");
		query.append("   'PHONE:'||NVL(DG.EMER_CNTC_PHN_NO_CTNT,'') PHONE," ).append("\n");
		query.append("   'PAGE:'||'' PAGE," ).append("\n");
		query.append("   'FLSH_TEMP:'||NVL(UN.FLSH_PNT_TEMP_CTNT,0) FLSH_TEMP," ).append("\n");
		query.append("   'FLSH_UNIT:'||'' FLSH_UNIT," ).append("\n");
		query.append("   'DG_REMARK:'||REPLACE(NVL(DG.DIFF_RMK,''),CHR(10),'') DG_REMARK," ).append("\n");
		query.append("   'EMSNO:'||NVL(UN.IMDG_EMER_NO,'') EMSNO," ).append("\n");
		query.append("   'PSACLS:'||NVL(DG.PSA_NO,'') PSACLS," ).append("\n");
		query.append("   'PKGGRP:'||NVL(DG.IMDG_PCK_GRP_CD,'') PKGGRP," ).append("\n");
		query.append("   'MFAG1:'||'' MFAG1," ).append("\n");
		query.append("   'MFAG2:'||'' MFAG2," ).append("\n");
		query.append("   'MAR_POLL:'||NVL(DG.MRN_POLUT_FLG,'') MAR_POLL," ).append("\n");
		query.append("   'LABEL_CD:'||'' LABEL_CD," ).append("\n");
		query.append("   'LABEL_DESC:' LABEL_DESC," ).append("\n");
		query.append("   'PKG:'||NVL(DG.OUT_IMDG_PCK_QTY1,0) PKG," ).append("\n");
		query.append("   'PKGUNIT:'||NVL(DG.OUT_IMDG_PCK_CD1,'') PKGUNIT," ).append("\n");
		query.append("   'NWGT:'||NVL(DG.NET_WGT,0) NWGT," ).append("\n");
		query.append("   'GWGT:'||DECODE(NVL(DG.WGT_UT_CD,''),'LBS',ROUND(NVL(DG.GRS_WGT,0)*0.4536,3),NVL(DG.GRS_WGT,0)) GWGT," ).append("\n");
		query.append("   'MEA:'||DECODE(NVL(DG.MEAS_UT_CD,''),'CBF',ROUND(NVL(DG.MEAS_QTY,0)*0.0283,3),NVL(DG.MEAS_QTY,0)) MEA," ).append("\n");
		query.append("   'HAZ_CONT:'||NVL(DG.HZD_DESC,'') HAZ_CONT," ).append("\n");
		query.append("   'STWG:'||NVL(DG.SPCL_STWG_RQST_DESC,'') STWG," ).append("\n");
		query.append("   'LABEL:'||'' LABEL    " ).append("\n");
		query.append("FROM  BKG_DG_CGO DG, SCG_IMDG_UN_NO UN" ).append("\n");
		query.append("WHERE DG.IMDG_UN_NO = UN.IMDG_UN_NO(+)" ).append("\n");
		query.append("and   DG.IMDG_UN_NO_SEQ = UN.IMDG_UN_NO_SEQ(+)" ).append("\n");
		query.append("and   DG.CNTR_NO(+)    = @[cntr_no]" ).append("\n");
		query.append("and   DG.BKG_NO        = @[bkg_no]" ).append("\n");

	}
}