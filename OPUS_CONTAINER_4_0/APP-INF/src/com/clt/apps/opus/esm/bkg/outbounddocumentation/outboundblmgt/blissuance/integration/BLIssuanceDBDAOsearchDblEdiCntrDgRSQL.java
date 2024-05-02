/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BLIssuanceDBDAOsearchDblEdiCntrDgRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.06
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.06 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAOsearchDblEdiCntrDgRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select
	  * </pre>
	  */
	public BLIssuanceDBDAOsearchDblEdiCntrDgRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOsearchDblEdiCntrDgRSQL").append("\n"); 
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
		query.append("SELECT '{CNTR_DANGER' || CHR(10) " ).append("\n"); 
		query.append("   || 'UNNBR:' || DG.IMDG_UN_NO || CHR(10) " ).append("\n"); 
		query.append("   || 'CLASS:' || UN.IMDG_CLSS_CD || CHR(10) " ).append("\n"); 
		query.append("   || 'DG_DESC:' || DG.PRP_SHP_NM || CHR(10) " ).append("\n"); 
		query.append("   || 'PHONE:' || DG.EMER_CNTC_PHN_NO_CTNT || CHR(10) " ).append("\n"); 
		query.append("   || 'PAGE:' || CHR(10) " ).append("\n"); 
		query.append("   || 'FLSH_TEMP:' || UN.FLSH_PNT_TEMP_CTNT || CHR(10) " ).append("\n"); 
		query.append("   || 'FLSH_UNIT:' || CHR(10) " ).append("\n"); 
		query.append("   || 'DG_REMARK:' || REPLACE(NVL(DG.DIFF_RMK, ' '), CHR(10), ' ')|| CHR(10) " ).append("\n"); 
		query.append("   || 'EMSNO:' || CHR(10) " ).append("\n"); 
		query.append("   || 'PSACLS:' || CHR(10) " ).append("\n"); 
		query.append("   || 'PKGGRP:' || CHR(10) " ).append("\n"); 
		query.append("   || 'MFAG1:' || CHR(10) " ).append("\n"); 
		query.append("   || 'MFAG2:' || CHR(10) " ).append("\n"); 
		query.append("   || 'MAR_POLL:' || DG.MRN_POLUT_FLG || CHR(10) " ).append("\n"); 
		query.append("   || 'LABEL_CD:' || CHR(10) " ).append("\n"); 
		query.append("   || 'LABEL_DESC:' || CHR(10) " ).append("\n"); 
		query.append("   || 'DG_PKG:' || CHR(10) " ).append("\n"); 
		query.append("   || 'DG_PKGUNIT:' || CHR(10) " ).append("\n"); 
		query.append("   || 'NWGT:' || DG.NET_WGT || CHR(10) " ).append("\n"); 
		query.append("   || 'NWGT_UNIT:' || DG.WGT_UT_CD || CHR(10) " ).append("\n"); 
		query.append("   || 'GWGT:' || DG.GRS_WGT || CHR(10) " ).append("\n"); 
		query.append("   || 'GWGT_UNIT:' || DG.WGT_UT_CD || CHR(10) " ).append("\n"); 
		query.append("   || 'MEA:' || DG.MEAS_QTY || CHR(10) " ).append("\n"); 
		query.append("   || 'MEA_UNIT:' || DG.MEAS_UT_CD || CHR(10) " ).append("\n"); 
		query.append("   || 'HAZ_CONT:' || DG.HZD_DESC || CHR(10) " ).append("\n"); 
		query.append("   || 'STWG:' || DG.SPCL_STWG_RQST_DESC || CHR(10) " ).append("\n"); 
		query.append("   || 'PACK_GP:' || DG.IMDG_PCK_GRP_CD || CHR(10) " ).append("\n"); 
		query.append("   || '}CNTR_DANGER' || CHR(10)" ).append("\n"); 
		query.append("FROM BKG_DG_CGO DG, SCG_IMDG_UN_NO UN" ).append("\n"); 
		query.append("WHERE DG.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND DG.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("AND DG.IMDG_UN_NO = UN.IMDG_UN_NO(+)" ).append("\n"); 
		query.append("AND DG.IMDG_UN_NO_SEQ = UN.IMDG_UN_NO_SEQ(+)" ).append("\n"); 

	}
}