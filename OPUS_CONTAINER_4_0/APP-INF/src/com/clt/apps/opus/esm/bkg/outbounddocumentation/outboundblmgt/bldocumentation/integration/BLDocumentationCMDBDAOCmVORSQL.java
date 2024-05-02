/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BLDocumentationCMDBDAOCmVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.08
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2010.12.08 최도순
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Do Soon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationCMDBDAOCmVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    select
	  * </pre>
	  */
	public BLDocumentationCMDBDAOCmVORSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationCMDBDAOCmVORSQL").append("\n"); 
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
		query.append("#if (${ca_flg} == 'Y') " ).append("\n"); 
		query.append("SELECT A1.BKG_NO" ).append("\n"); 
		query.append(",	A1.CNTR_MF_SEQ" ).append("\n"); 
		query.append(",	A1.CNTR_NO" ).append("\n"); 
		query.append(",	A1.PCK_QTY" ).append("\n"); 
		query.append(",	A1.PCK_TP_CD" ).append("\n"); 
		query.append(",	A1.CNTR_MF_WGT" ).append("\n"); 
		query.append(",	A1.WGT_UT_CD" ).append("\n"); 
		query.append(",	A1.MEAS_QTY" ).append("\n"); 
		query.append(",	A1.MEAS_UT_CD" ).append("\n"); 
		query.append(",	A1.DCGO_FLG" ).append("\n"); 
		query.append(",	A1.BB_CGO_FLG" ).append("\n"); 
		query.append(",	A1.AWK_CGO_FLG" ).append("\n"); 
		query.append(",	A1.RC_FLG" ).append("\n"); 
		query.append(",	A1.RD_CGO_FLG" ).append("\n"); 
		query.append(",	A1.HNGR_FLG" ).append("\n"); 
		query.append(",	A1.CNTR_MF_MK_DESC" ).append("\n"); 
		query.append(",	A1.CNTR_MF_GDS_DESC" ).append("\n"); 
		query.append(",	A1.HBL_SEQ" ).append("\n"); 
		query.append(",	A1.HAMO_TRF_CD" ).append("\n"); 
		query.append(",	A1.CMDT_HS_CD" ).append("\n"); 
		query.append(",	A1.NCM_NO" ).append("\n"); 
		query.append(",	A1.PO_NO" ).append("\n"); 
		query.append(",	A1.CNTR_MF_NO" ).append("\n"); 
		query.append(",	A1.CSTMS_DECL_NO" ).append("\n"); 
		query.append(",	A1.CRE_USR_ID" ).append("\n"); 
		query.append(",	A1.UPD_USR_ID" ).append("\n"); 
		query.append(",	A1.DCGO_SEQ" ).append("\n"); 
		query.append("FROM  BKG_CNTR_MF_DESC_HIS A1" ).append("\n"); 
		query.append("     ,BKG_CNTR_HIS A2" ).append("\n"); 
		query.append("WHERE A1.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND   A1.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("AND   A1.BKG_NO = A2.BKG_NO" ).append("\n"); 
		query.append("AND   A1.CORR_NO = A2.CORR_NO" ).append("\n"); 
		query.append("AND   A1.CNTR_NO = A2.CNTR_NO" ).append("\n"); 
		query.append("ORDER BY A2.CNTR_DP_SEQ" ).append("\n"); 
		query.append("     ,A1.CNTR_MF_SEQ" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("SELECT A1.BKG_NO" ).append("\n"); 
		query.append(",	A1.CNTR_MF_SEQ" ).append("\n"); 
		query.append(",	A1.CNTR_NO" ).append("\n"); 
		query.append(",	A1.PCK_QTY" ).append("\n"); 
		query.append(",	A1.PCK_TP_CD" ).append("\n"); 
		query.append(",	A1.CNTR_MF_WGT" ).append("\n"); 
		query.append(",	A1.WGT_UT_CD" ).append("\n"); 
		query.append(",	A1.MEAS_QTY" ).append("\n"); 
		query.append(",	A1.MEAS_UT_CD" ).append("\n"); 
		query.append(",	A1.DCGO_FLG" ).append("\n"); 
		query.append(",	A1.BB_CGO_FLG" ).append("\n"); 
		query.append(",	A1.AWK_CGO_FLG" ).append("\n"); 
		query.append(",	A1.RC_FLG" ).append("\n"); 
		query.append(",	A1.RD_CGO_FLG" ).append("\n"); 
		query.append(",	A1.HNGR_FLG" ).append("\n"); 
		query.append(",	A1.CNTR_MF_MK_DESC" ).append("\n"); 
		query.append(",	A1.CNTR_MF_GDS_DESC" ).append("\n"); 
		query.append(",	A1.HBL_SEQ" ).append("\n"); 
		query.append(",	A1.HAMO_TRF_CD" ).append("\n"); 
		query.append(",	A1.CMDT_HS_CD" ).append("\n"); 
		query.append(",	A1.NCM_NO" ).append("\n"); 
		query.append(",	A1.PO_NO" ).append("\n"); 
		query.append(",	A1.CNTR_MF_NO" ).append("\n"); 
		query.append(",	A1.CSTMS_DECL_NO" ).append("\n"); 
		query.append(",	A1.CRE_USR_ID" ).append("\n"); 
		query.append(",	A1.UPD_USR_ID" ).append("\n"); 
		query.append(",	A1.DCGO_SEQ" ).append("\n"); 
		query.append("FROM BKG_CNTR_MF_DESC A1" ).append("\n"); 
		query.append("    ,BKG_CONTAINER A2" ).append("\n"); 
		query.append("WHERE	A1.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND     A1.BKG_NO = A2.BKG_NO" ).append("\n"); 
		query.append("AND     A1.CNTR_NO = A2.CNTR_NO" ).append("\n"); 
		query.append("ORDER BY A2.CNTR_DP_SEQ" ).append("\n"); 
		query.append("     ,A1.CNTR_MF_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}