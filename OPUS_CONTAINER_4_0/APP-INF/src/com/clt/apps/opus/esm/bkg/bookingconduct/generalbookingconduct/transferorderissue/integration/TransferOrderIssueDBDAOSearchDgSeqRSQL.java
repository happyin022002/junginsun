/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TransferOrderIssueDBDAOSearchDgSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.11.07
*@LastModifier : 
*@LastVersion : 1.0
* 2016.11.07 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TransferOrderIssueDBDAOSearchDgSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ESM_BKG_0079_02A dq 콤보목록 조회
	  * </pre>
	  */
	public TransferOrderIssueDBDAOSearchDgSeqRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration").append("\n"); 
		query.append("FileName : TransferOrderIssueDBDAOSearchDgSeqRSQL").append("\n"); 
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
		query.append("SELECT DCGO_SEQ DG_SEQ" ).append("\n"); 
		query.append("       , 'UN No:'||IMDG_UN_NO||', IMO Class:'||IMDG_CLSS_CD" ).append("\n"); 
		query.append("            ||DECODE(NVL(SPCL_CGO_APRO_CD, 'X'), 'X', '', ' ('||INTG_CD_VAL_DP_DESC||')') DG_TRO_RMK" ).append("\n"); 
		query.append("       , DISPLAY_SEQ||'|CNTR seq:'||DG_CNTR_SEQ||', UN No:'||IMDG_UN_NO||', IMO Class:'||IMDG_CLSS_CD" ).append("\n"); 
		query.append("            ||DECODE(NVL(SPCL_CGO_APRO_CD, 'X'), 'X', '', ' ('||INTG_CD_VAL_DP_DESC||')') DISPLAY_NM" ).append("\n"); 
		query.append("  FROM ( SELECT DG_CNTR_SEQ," ).append("\n"); 
		query.append("                IMDG_UN_NO," ).append("\n"); 
		query.append("                ROW_NUMBER() OVER(PARTITION BY DG_CNTR_SEQ ORDER BY DCGO_SEQ) DISPLAY_SEQ," ).append("\n"); 
		query.append("                IMDG_CLSS_CD," ).append("\n"); 
		query.append("                DCGO_SEQ," ).append("\n"); 
		query.append("                CNTR_NO," ).append("\n"); 
		query.append("                INTG_CD_VAL_DP_DESC," ).append("\n"); 
		query.append("                SPCL_CGO_APRO_CD" ).append("\n"); 
		query.append("           FROM BKG_DG_CGO dg, com_intg_cd_dtl code" ).append("\n"); 
		query.append("          WHERE SPCL_CGO_APRO_CD = INTG_CD_VAL_CTNT(+)" ).append("\n"); 
		query.append("            AND 'CD01955'        = INTG_CD_ID(+)" ).append("\n"); 
		query.append("            AND BKG_NO 			= @[bkg_no] " ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append(" WHERE NVL(SPCL_CGO_APRO_CD, ' ') <> 'C'" ).append("\n"); 
		query.append(" ORDER BY CNTR_NO,DCGO_SEQ" ).append("\n"); 

	}
}