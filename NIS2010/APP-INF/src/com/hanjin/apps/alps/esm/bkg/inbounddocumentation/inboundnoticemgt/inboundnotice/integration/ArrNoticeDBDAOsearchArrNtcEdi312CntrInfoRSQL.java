/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ArrNoticeDBDAOsearchArrNtcEdi312CntrInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.20
*@LastModifier : 
*@LastVersion : 1.0
* 2012.02.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ArrNoticeDBDAOsearchArrNtcEdi312CntrInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchArrNtcEdi312CntrInfo
	  * </pre>
	  */
	public ArrNoticeDBDAOsearchArrNtcEdi312CntrInfoRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration").append("\n"); 
		query.append("FileName : ArrNoticeDBDAOsearchArrNtcEdi312CntrInfoRSQL").append("\n"); 
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
		query.append("SELECT BCNTR.BKG_NO" ).append("\n"); 
		query.append("      ,BCNTR.CNTR_NO" ).append("\n"); 
		query.append("      ,'{CNTR_INFO'                              		   || CHR(10) " ).append("\n"); 
		query.append("       ||'CNTRNBR:'    || BCNTR.CNTR_NO      			   || CHR(10)" ).append("\n"); 
		query.append("       ||'CNTR_CD:'    || BCNTR.CNTR_TPSZ_CD 			   || CHR(10)   " ).append("\n"); 
		query.append("       ||'TERM:'       || ''          		                   || CHR(10)  " ).append("\n"); 
		query.append("       ||'WGT_TP:'     || BCNTR.WGT_UT_CD 			   || CHR(10)  " ).append("\n"); 
		query.append("       ||'WGT:'        || BCNTR.CNTR_WGT 			   || CHR(10)  " ).append("\n"); 
		query.append("       ||'TWUN:'       || '' 					   || CHR(10)  " ).append("\n"); 
		query.append("       ||'TWGT:'       || '' 					   || CHR(10)  " ).append("\n"); 
		query.append("       ||'MEASURE_TP:' || BCNTR.MEAS_UT_CD 			   || CHR(10)  " ).append("\n"); 
		query.append("       ||'MEASURE:'    || BCNTR.MEAS_QTY 			   || CHR(10)  " ).append("\n"); 
		query.append("       ||'PKG_CD:'     || BCNTR.PCK_TP_CD 			   || CHR(10)  " ).append("\n"); 
		query.append("       ||'PKG:'        || NVL(BCNTR.PCK_QTY, 0) 		   || CHR(10)  " ).append("\n"); 
		query.append("       ||'RDTY:'       ||  '' 					   || CHR(10)  " ).append("\n"); 
		query.append("       ||'FMF:'        || '' 					   || CHR(10)  " ).append("\n"); 
		query.append("       ||'EDAT:'       || '' 					   || CHR(10)  " ).append("\n"); 
		query.append("       ||'DEST:'       || '' 					   || CHR(10)  " ).append("\n"); 
		query.append("       ||'RIND:'       || DECODE(BCNTR.RC_FLG, 'Y', '1', '0') 	   || CHR(10)  " ).append("\n"); 
		query.append("       ||'DIND:'       || DECODE(BCNTR.DCGO_FLG, 'Y', '1', '0')    || CHR(10)  " ).append("\n"); 
		query.append("       ||'AIND:'       || DECODE(BCNTR.AWK_CGO_FLG, 'Y', '1', '0') || CHR(10)  " ).append("\n"); 
		query.append("       ||'BIND:'       || DECODE(BCNTR.BB_CGO_FLG, 'Y', '1', '0')  || CHR(10)  " ).append("\n"); 
		query.append("       ||'OVF:'        || AK.OVR_FWRD_LEN 			   || CHR(10)  " ).append("\n"); 
		query.append("       ||'OVR:'        || AK.OVR_BKWD_LEN			   || CHR(10)  " ).append("\n"); 
		query.append("       ||'OVH:'        || AK.OVR_HGT 				   || CHR(10)  " ).append("\n"); 
		query.append("       ||'OVLW:'       || AK.OVR_LF_LEN 			   || CHR(10)  " ).append("\n"); 
		query.append("       ||'OVRW:'       || AK.OVR_RT_LEN 			   || CHR(10)  " ).append("\n"); 
		query.append("       ||'OVWGT:'      || AK.GRS_WGT 				   || CHR(10)  " ).append("\n"); 
		query.append("       ||'OVWGT_UNIT:'|| AK.WGT_UT_CD 				   || CHR(10)  " ).append("\n"); 
		query.append("       ||'VOID_SLOT:'|| AK.OVR_VOID_SLT_QTY 			   || CHR(10)  " ).append("\n"); 
		query.append("       ||'STWG_REQ:'  || AK.STWG_RQST_DESC 			   || CHR(10)  " ).append("\n"); 
		query.append("       ||'TEMP:'       || RF.CDO_TEMP 				   || CHR(10)  " ).append("\n"); 
		query.append("       ||'TUNIT:'      || 'C' 					   || CHR(10)  " ).append("\n"); 
		query.append("       ||'VENT:'       || CASE WHEN RF.VENT_RTO = 0 THEN 'C'" ).append("\n"); 
		query.append("                               WHEN RF.VENT_RTO > 0 AND RF.VENT_RTO <= 34 THEN 'Q'" ).append("\n"); 
		query.append("                               WHEN RF.VENT_RTO > 34 AND RF.VENT_RTO <= 64 THEN 'H'" ).append("\n"); 
		query.append("                               WHEN RF.VENT_RTO > 65 AND RF.VENT_RTO <= 99 THEN 'T'" ).append("\n"); 
		query.append("                               WHEN RF.VENT_RTO = 100 THEN 'O'" ).append("\n"); 
		query.append("                          END 					  || CHR(10)  " ).append("\n"); 
		query.append("       ||'HUMID:'     || RF.HUMID_NO      || CHR(10) cntr" ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append(" FROM BKG_CONTAINER BCNTR" ).append("\n"); 
		query.append("      ,BKG_RF_CGO RF" ).append("\n"); 
		query.append("      ,BKG_AWK_CGO AK" ).append("\n"); 
		query.append("WHERE BCNTR.BKG_NO    = @[bkg_no]" ).append("\n"); 
		query.append("AND   RF.BKG_NO(+)   = BCNTR.BKG_NO " ).append("\n"); 
		query.append("AND   RF.CNTR_NO(+)  = BCNTR.CNTR_NO " ).append("\n"); 
		query.append("AND   AK.BKG_NO(+)   = BCNTR.BKG_NO " ).append("\n"); 
		query.append("AND   AK.CNTR_NO(+)  = BCNTR.CNTR_NO" ).append("\n"); 

	}
}