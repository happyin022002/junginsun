/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : TransferOrderIssueDBDAOSearchDgSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.12.12
*@LastModifier : 
*@LastVersion : 1.0
* 2011.12.12 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration").append("\n"); 
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
		query.append("SELECT DG_SEQ" ).append("\n"); 
		query.append(",DECODE(CNT_CGO_SEQ, 1, '', '(')|| DISPLAY_NM || DECODE(CNT_CGO_SEQ, 1, '', ')') AS DG_TRO_RMK" ).append("\n"); 
		query.append(",DG_SEQ || '|' || DECODE(CNT_CGO_SEQ, 1, '', '(')|| DISPLAY_NM || DECODE(CNT_CGO_SEQ, 1, '', ')') AS DISPLAY_NM" ).append("\n"); 
		query.append("FROM (SELECT DG_CNTR_SEQ DG_SEQ" ).append("\n"); 
		query.append(",CNTR_CGO_SEQ" ).append("\n"); 
		query.append(",MIN(CNTR_CGO_SEQ) OVER (PARTITION BY DG_CNTR_SEQ) AS MIN_CGO_SEQ" ).append("\n"); 
		query.append(",COUNT(CNTR_CGO_SEQ) OVER (PARTITION BY DG_CNTR_SEQ) AS CNT_CGO_SEQ" ).append("\n"); 
		query.append(",BKG_JOIN_FNC(CURSOR(SELECT 'UN No:'||IMDG_UN_NO||', IMO Class:'||IMDG_CLSS_CD ||DECODE(NVL(SPCL_CGO_APRO_CD, 'X'), 'X', '', ' ('||INTG_CD_VAL_DP_DESC||')') DG_TRO_RMK" ).append("\n"); 
		query.append("FROM BKG_DG_CGO DG" ).append("\n"); 
		query.append(",COM_INTG_CD_DTL CODE" ).append("\n"); 
		query.append("WHERE SPCL_CGO_APRO_CD = INTG_CD_VAL_CTNT(+)" ).append("\n"); 
		query.append("AND 'CD01955' = INTG_CD_ID(+)" ).append("\n"); 
		query.append("AND BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND DG.DG_CNTR_SEQ = DGCO.DG_CNTR_SEQ)) AS DISPLAY_NM" ).append("\n"); 
		query.append("FROM BKG_DG_CGO DGCO" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append("WHERE CNTR_CGO_SEQ = MIN_CGO_SEQ" ).append("\n"); 
		query.append("ORDER BY DG_SEQ" ).append("\n"); 

	}
}