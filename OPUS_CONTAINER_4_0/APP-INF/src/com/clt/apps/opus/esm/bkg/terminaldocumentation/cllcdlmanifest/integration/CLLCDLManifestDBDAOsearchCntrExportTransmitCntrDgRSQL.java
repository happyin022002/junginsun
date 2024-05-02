/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CLLCDLManifestDBDAOsearchCntrExportTransmitCntrDgRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.30
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.30 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CLLCDLManifestDBDAOsearchCntrExportTransmitCntrDgRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Container Export EDI 전송시 DG정보를 구하는 쿼리.
	  * </pre>
	  */
	public CLLCDLManifestDBDAOsearchCntrExportTransmitCntrDgRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_dcgo_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("form_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.integration").append("\n"); 
		query.append("FileName : CLLCDLManifestDBDAOsearchCntrExportTransmitCntrDgRSQL").append("\n"); 
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
		query.append("SELECT NVL(DG.IMDG_UN_NO,' ') UNNBR," ).append("\n"); 
		query.append("	   NVL(UN.IMDG_CLSS_CD,' ') DCLASS," ).append("\n"); 
		query.append("	   NVL(DG.PRP_SHP_NM,' ') DG_DESC," ).append("\n"); 
		query.append("	   NVL(DG.EMER_CNTC_PHN_NO_CTNT,' ') PHONE," ).append("\n"); 
		query.append("	   ' ' PAGE," ).append("\n"); 
		query.append("	   NVL(UN.FLSH_PNT_TEMP_CTNT,'') FLSH_TEMP," ).append("\n"); 
		query.append("	   ' ' FLSH_UNIT," ).append("\n"); 
		query.append("	   REPLACE(NVL(DG.DIFF_RMK,' '),chr(10),' ') DG_REMARK," ).append("\n"); 
		query.append("	   NVL(UN.IMDG_EMER_NO,' ') EMSNO," ).append("\n"); 
		query.append("	   NVL(DG.PSA_NO,' ') PSACLS," ).append("\n"); 
		query.append("	   NVL(DG.IMDG_PCK_GRP_CD,' ') PKGGRP," ).append("\n"); 
		query.append("	   ' ' MFAG1," ).append("\n"); 
		query.append("	   ' ' MFAG2," ).append("\n"); 
		query.append("	   NVL(DG.MRN_POLUT_FLG,' ') MAR_POLL," ).append("\n"); 
		query.append("	   NVL(DG.IMDG_SUBS_RSK_LBL_CD1,' ')||' '||NVL(DG.IMDG_SUBS_RSK_LBL_CD2,' ')||' '||NVL(DG.IMDG_SUBS_RSK_LBL_CD3,' ') LABEL_CD," ).append("\n"); 
		query.append("	   '' LABEL_DESC," ).append("\n"); 
		query.append("	   NVL(DG.OUT_IMDG_PCK_QTY1,0) D_PKG," ).append("\n"); 
		query.append("	   NVL(DG.OUT_IMDG_PCK_CD1,' ') D_PKGUNIT," ).append("\n"); 
		query.append("	   NVL(DG.NET_WGT,0) NWGT," ).append("\n"); 
		query.append("	   'KGM' NWGT_UNIT," ).append("\n"); 
		query.append("	   NVL(DG.GRS_WGT,'') GWGT," ).append("\n"); 
		query.append("	   NVL(DG.WGT_UT_CD,' ') GWGT_UNIT," ).append("\n"); 
		query.append("	   NVL(DG.MEAS_QTY,'') MEA," ).append("\n"); 
		query.append("	   NVL(DG.MEAS_UT_CD,' ') MEA_UNIT," ).append("\n"); 
		query.append("	   NVL(DG.HZD_DESC,' ') HAZ_CONT," ).append("\n"); 
		query.append("	   NVL(DG.SPCL_STWG_RQST_DESC,' ') STWG," ).append("\n"); 
		query.append("	   NVL(DG.IMDG_SUBS_RSK_LBL_CD1,' ')||' '||NVL(DG.IMDG_SUBS_RSK_LBL_CD2,' ')||' '||NVL(DG.IMDG_SUBS_RSK_LBL_CD3,' ') LABEL" ).append("\n"); 
		query.append("FROM   BKG_DG_CGO DG, SCG_IMDG_UN_NO UN" ).append("\n"); 
		query.append("WHERE  DG.IMDG_UN_NO            = UN.IMDG_UN_NO(+)  and" ).append("\n"); 
		query.append("	   DG.IMDG_UN_NO_SEQ        = UN.IMDG_UN_NO_SEQ(+)  and" ).append("\n"); 
		query.append("	   NVL(DG.CNTR_NO,'%')	    LIKE NVL(DECODE(@[in_cntr_no],' ',NULL),'%') and" ).append("\n"); 
		query.append("	   DG.DCGO_SEQ				= TO_NUMBER(@[in_dcgo_seq]) and" ).append("\n"); 
		query.append("	   DG.BKG_NO        		= @[form_bkg_no]" ).append("\n"); 

	}
}