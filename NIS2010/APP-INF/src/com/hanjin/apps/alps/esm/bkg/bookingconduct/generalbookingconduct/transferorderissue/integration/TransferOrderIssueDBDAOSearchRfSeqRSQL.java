/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TransferOrderIssueDBDAOSearchRfSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.17
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.17 
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

public class TransferOrderIssueDBDAOSearchRfSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ESM_BKG_0079_02A rf 콤보목록 조회
	  * </pre>
	  */
	public TransferOrderIssueDBDAOSearchRfSeqRSQL(){
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
		query.append("FileName : TransferOrderIssueDBDAOSearchRfSeqRSQL").append("\n"); 
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
		query.append("SELECT RC_SEQ AS RF_SEQ" ).append("\n"); 
		query.append(", 'Temp:'||CDO_TEMP||', Vantilation:'||DECODE(CNTR_VENT_TP_CD, 'P', VENT_RTO, CBM_PER_HR_QTY)||DECODE(CNTR_VENT_TP_CD, 'P', '%', 'CMH')||', Humidity:'||HUMID_NO||'%, Drain:'||" ).append("\n"); 
		query.append("(SELECT INTG_CD_VAL_DESC" ).append("\n"); 
		query.append("FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("WHERE INTG_CD_VAL_CTNT = CNTR_DRN_CD" ).append("\n"); 
		query.append("AND INTG_CD_ID = 'CD01588')" ).append("\n"); 
		query.append("||DECODE(NVL(SPCL_CGO_APRO_CD, 'X'), 'X', '', ' ('||INTG_CD_VAL_DP_DESC||')') AS RF_TRO_RMK" ).append("\n"); 
		query.append("--       , RC_SEQ||'|'||'Temp:'||CDO_TEMP||'C, Vantilation:'||VENT_RTO||'%, Humidity:'||HUMID_NO||'%, Drain:'||" ).append("\n"); 
		query.append(", RC_SEQ||'|'||'Temp:'||CDO_TEMP||', Vantilation:'||DECODE(CNTR_VENT_TP_CD, 'P', VENT_RTO, CBM_PER_HR_QTY)||DECODE(CNTR_VENT_TP_CD, 'P', '%', 'CMH')||', Humidity:'||HUMID_NO||'%, Drain:'||" ).append("\n"); 
		query.append("(SELECT INTG_CD_VAL_DESC" ).append("\n"); 
		query.append("FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("WHERE INTG_CD_VAL_CTNT = CNTR_DRN_CD" ).append("\n"); 
		query.append("AND INTG_CD_ID = 'CD01588')" ).append("\n"); 
		query.append("||DECODE(NVL(SPCL_CGO_APRO_CD, 'X'), 'X', '', ' ('||INTG_CD_VAL_DP_DESC||')') AS DISPLAY_NM" ).append("\n"); 
		query.append("FROM BKG_RF_CGO, com_intg_cd_dtl code" ).append("\n"); 
		query.append("WHERE SPCL_CGO_APRO_CD = INTG_CD_VAL_CTNT(+)" ).append("\n"); 
		query.append("AND 'CD01955'        = INTG_CD_ID(+)" ).append("\n"); 
		query.append("AND BKG_NO 			= @[bkg_no]" ).append("\n"); 
		query.append("ORDER BY RF_SEQ" ).append("\n"); 

	}
}