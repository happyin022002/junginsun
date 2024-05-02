/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BLDocumentationBLDBDAOHblCntrMfDescRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.22
*@LastModifier : 김영출
*@LastVersion : 1.0
* 2009.10.22 김영출
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Youngchul
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationBLDBDAOHblCntrMfDescRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select
	  * </pre>
	  */
	public BLDocumentationBLDBDAOHblCntrMfDescRSQL(){
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
		query.append("FileName : BLDocumentationBLDBDAOHblCntrMfDescRSQL").append("\n"); 
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
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("SELECT B.BKG_NO" ).append("\n"); 
		query.append(",      B.CNTR_MF_SEQ" ).append("\n"); 
		query.append(",      B.CNTR_NO" ).append("\n"); 
		query.append(",      B.PCK_QTY" ).append("\n"); 
		query.append(",      B.PCK_TP_CD" ).append("\n"); 
		query.append(",      B.CNTR_MF_WGT" ).append("\n"); 
		query.append(",      B.WGT_UT_CD" ).append("\n"); 
		query.append(",      B.MEAS_QTY" ).append("\n"); 
		query.append(",      B.MEAS_UT_CD" ).append("\n"); 
		query.append(",      B.DCGO_FLG" ).append("\n"); 
		query.append(",      B.BB_CGO_FLG" ).append("\n"); 
		query.append(",      B.AWK_CGO_FLG" ).append("\n"); 
		query.append(",      B.RC_FLG" ).append("\n"); 
		query.append(",      B.RD_CGO_FLG" ).append("\n"); 
		query.append(",      B.HNGR_FLG" ).append("\n"); 
		query.append(",      B.CNTR_MF_MK_DESC" ).append("\n"); 
		query.append(",      B.CNTR_MF_GDS_DESC" ).append("\n"); 
		query.append(",      B.HAMO_TRF_CD" ).append("\n"); 
		query.append(",      B.CMDT_HS_CD" ).append("\n"); 
		query.append(",      B.NCM_NO" ).append("\n"); 
		query.append(",      B.CNTR_MF_NO" ).append("\n"); 
		query.append(",      B.HBL_SEQ" ).append("\n"); 
		query.append("FROM   BKG_HBL_HIS A, BKG_CNTR_MF_DESC_HIS B" ).append("\n"); 
		query.append("WHERE  A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND    A.CNTR_MF_NO = B.CNTR_MF_NO" ).append("\n"); 
		query.append("AND    A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND    A.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("AND    B.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT B.BKG_NO" ).append("\n"); 
		query.append(",      B.CNTR_MF_SEQ" ).append("\n"); 
		query.append(",      B.CNTR_NO" ).append("\n"); 
		query.append(",      B.PCK_QTY" ).append("\n"); 
		query.append(",      B.PCK_TP_CD" ).append("\n"); 
		query.append(",      B.CNTR_MF_WGT" ).append("\n"); 
		query.append(",      B.WGT_UT_CD" ).append("\n"); 
		query.append(",      B.MEAS_QTY" ).append("\n"); 
		query.append(",      B.MEAS_UT_CD" ).append("\n"); 
		query.append(",      B.DCGO_FLG" ).append("\n"); 
		query.append(",      B.BB_CGO_FLG" ).append("\n"); 
		query.append(",      B.AWK_CGO_FLG" ).append("\n"); 
		query.append(",      B.RC_FLG" ).append("\n"); 
		query.append(",      B.RD_CGO_FLG" ).append("\n"); 
		query.append(",      B.HNGR_FLG" ).append("\n"); 
		query.append(",      B.CNTR_MF_MK_DESC" ).append("\n"); 
		query.append(",      B.CNTR_MF_GDS_DESC" ).append("\n"); 
		query.append(",      B.HAMO_TRF_CD" ).append("\n"); 
		query.append(",      B.CMDT_HS_CD" ).append("\n"); 
		query.append(",      B.NCM_NO" ).append("\n"); 
		query.append(",      B.CNTR_MF_NO" ).append("\n"); 
		query.append(",      B.HBL_SEQ" ).append("\n"); 
		query.append("FROM   BKG_HBL A, BKG_CNTR_MF_DESC B" ).append("\n"); 
		query.append("WHERE  A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND    A.CNTR_MF_NO = B.CNTR_MF_NO" ).append("\n"); 
		query.append("AND    A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}