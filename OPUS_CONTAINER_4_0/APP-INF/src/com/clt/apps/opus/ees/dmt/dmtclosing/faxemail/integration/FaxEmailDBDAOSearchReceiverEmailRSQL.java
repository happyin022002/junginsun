/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FaxEmailDBDAOSearchReceiverEmailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.23
*@LastModifier : 
*@LastVersion : 1.0
* 2009.09.23 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtclosing.faxemail.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FaxEmailDBDAOSearchReceiverEmailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Email 을 보낼 수신자의 정보를 조회하는 쿼리
	  * </pre>
	  */
	public FaxEmailDBDAOSearchReceiverEmailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aft_expt_dar_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtclosing.faxemail.integration").append("\n"); 
		query.append("FileName : FaxEmailDBDAOSearchReceiverEmailRSQL").append("\n"); 
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
		query.append("SELECT  DISTINCT USR.USR_EML" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM    DMT_AFT_BKG_ADJ_RQST_DTL ADJ_RQST_DTL" ).append("\n"); 
		query.append(",   DMT_AFT_BKG_CNTR AFT_CNTR" ).append("\n"); 
		query.append(",   DMT_CHG_CALC CHG_CALC" ).append("\n"); 
		query.append(",   DMT_APRO_EML_RCVR EML_RCVR" ).append("\n"); 
		query.append(",   DMT_APRO_EML_RCVR_TRF_TP EML_RCVR_TRF_TP" ).append("\n"); 
		query.append(",   COM_USER USR" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE   ADJ_RQST_DTL.AFT_EXPT_DAR_NO = @[aft_expt_dar_no]" ).append("\n"); 
		query.append("AND ADJ_RQST_DTL.AFT_EXPT_DAR_NO = AFT_CNTR.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("AND ADJ_RQST_DTL.AFT_EXPT_ADJ_SEQ = AFT_CNTR.AFT_EXPT_ADJ_SEQ" ).append("\n"); 
		query.append("AND AFT_CNTR.SYS_AREA_GRP_ID = CHG_CALC.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("AND AFT_CNTR.CNTR_NO = CHG_CALC.CNTR_NO" ).append("\n"); 
		query.append("AND AFT_CNTR.CNTR_CYC_NO = CHG_CALC.CNTR_CYC_NO" ).append("\n"); 
		query.append("AND AFT_CNTR.DMDT_TRF_CD = CHG_CALC.DMDT_TRF_CD" ).append("\n"); 
		query.append("AND AFT_CNTR.DMDT_CHG_LOC_DIV_CD = CHG_CALC.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("AND AFT_CNTR.CHG_SEQ = CHG_CALC.CHG_SEQ" ).append("\n"); 
		query.append("AND CHG_CALC.OFC_CD = EML_RCVR.REF_OFC_CD" ).append("\n"); 
		query.append("AND EML_RCVR.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND EML_RCVR.REF_OFC_CD = EML_RCVR_TRF_TP.REF_OFC_CD" ).append("\n"); 
		query.append("AND CHG_CALC.DMDT_TRF_CD = EML_RCVR_TRF_TP.DMDT_TRF_CD" ).append("\n"); 
		query.append("AND EML_RCVR.DMDT_USR_ID = USR.USR_ID" ).append("\n"); 

	}
}