/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MexCustomsTransmissionDBDAOsearchDangerCgoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.25
*@LastModifier : 김도완
*@LastVersion : 1.0
* 2009.09.25 김도완
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.mexico.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Do-Wan, Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MexCustomsTransmissionDBDAOsearchDangerCgoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dwkim, 0370, MxDgInfoVO
	  * </pre>
	  */
	public MexCustomsTransmissionDBDAOsearchDangerCgoRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.mex.integration").append("\n"); 
		query.append("FileName : MexCustomsTransmissionDBDAOsearchDangerCgoRSQL").append("\n"); 
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
		query.append("NVL(A.IMDG_UN_NO, ' ') UNNBR" ).append("\n"); 
		query.append(",NVL(B.IMDG_CLSS_CD, ' ') CLASS1" ).append("\n"); 
		query.append(",NVL(A.PRP_SHP_NM, ' ') DG_DESC" ).append("\n"); 
		query.append(",NVL(A.EMER_CNTC_PHN_NO_CTNT, ' ') PHONE" ).append("\n"); 
		query.append(",'' PAGE" ).append("\n"); 
		query.append(",NVL(B.FLSH_PNT_TEMP_CTNT,' ') FLSH_TEMP" ).append("\n"); 
		query.append(",'' FLSH_UNIT" ).append("\n"); 
		query.append(",REPLACE(NVL(A.DIFF_RMK,' '),CHR(13)||CHR(10),' ') DG_REMARK" ).append("\n"); 
		query.append(",NVL(B.IMDG_EMER_NO, ' ') EMSNO" ).append("\n"); 
		query.append(",NVL(A.PSA_NO, ' ') PSACLS" ).append("\n"); 
		query.append(",'' PKGGRP" ).append("\n"); 
		query.append(",'' MFAG1" ).append("\n"); 
		query.append(",'' MFAG2" ).append("\n"); 
		query.append(",NVL(A.MRN_POLUT_FLG, ' ') MAR_POLL" ).append("\n"); 
		query.append(",'' LABEL_CD" ).append("\n"); 
		query.append(",'' LABEL_DESC" ).append("\n"); 
		query.append(",'' D_PKG" ).append("\n"); 
		query.append(",NVL(A.OUT_IMDG_PCK_CD1, ' ') D_PKGUNIT" ).append("\n"); 
		query.append(",NVL(NET_WGT, 0) NWGT" ).append("\n"); 
		query.append(",'KGS' NWGT_UNIT" ).append("\n"); 
		query.append(",NVL(GRS_WGT, 0) GWGT" ).append("\n"); 
		query.append(",NVL(WGT_UT_CD, ' ') GWGT_UNIT" ).append("\n"); 
		query.append(",NVL(MEAS_QTY, 0) MEA" ).append("\n"); 
		query.append(",NVL(MEAS_UT_CD, ' ') MEA_UNIT" ).append("\n"); 
		query.append(",NVL(HZD_DESC, ' ') HAZ_CONT" ).append("\n"); 
		query.append(",NVL(SPCL_STWG_RQST_DESC, ' ') STWG" ).append("\n"); 
		query.append(",'' LABEL" ).append("\n"); 
		query.append("FROM BKG_DG_CGO A, SCG_IMDG_UN_NO B" ).append("\n"); 
		query.append("WHERE   A.IMDG_UN_NO = B.IMDG_UN_NO(+)" ).append("\n"); 
		query.append("AND     A.IMDG_UN_NO_SEQ = B.IMDG_UN_NO_SEQ(+)" ).append("\n"); 
		query.append("AND     A.BKG_NO        = @[bkg_no]" ).append("\n"); 
		query.append("AND     A.CNTR_NO(+)    = @[cntr_no]" ).append("\n"); 

	}
}