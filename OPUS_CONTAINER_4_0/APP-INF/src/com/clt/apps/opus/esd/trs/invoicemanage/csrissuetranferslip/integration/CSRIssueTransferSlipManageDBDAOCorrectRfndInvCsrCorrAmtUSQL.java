/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CSRIssueTransferSlipManageDBDAOCorrectRfndInvCsrCorrAmtUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.01
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.01 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.csrissuetranferslip.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CSRIssueTransferSlipManageDBDAOCorrectRfndInvCsrCorrAmtUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * REFUND    AMOUNT CORRECTION
	  * </pre>
	  */
	public CSRIssueTransferSlipManageDBDAOCorrectRfndInvCsrCorrAmtUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("INV_VNDR_SEQ",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.invoicemanage.csrissuetranferslip.integration").append("\n"); 
		query.append("FileName : CSRIssueTransferSlipManageDBDAOCorrectRfndInvCsrCorrAmtUSQL").append("\n"); 
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
		query.append("UPDATE       TRS_TRSP_RFND_INV RFF																																" ).append("\n"); 
		query.append("SET         (RFF.CSR_RFND_MON_KNT, RFF.CSR_RFND_CORR_AMT)                                                                                               		" ).append("\n"); 
		query.append("				   =  (                                                                                                                 		" ).append("\n"); 
		query.append("					SELECT                                                                                                          		" ).append("\n"); 
		query.append("						   RF.RFND_MON_KNT	                                                                                     		" ).append("\n"); 
		query.append("						 , CASE NVL((SELECT DP_PRCS_KNT FROM MDM_CURRENCY WHERE CURR_CD = W.INV_CURR_CD AND NVL(DELT_FLG, 'N') = 'N'), 0) WHEN  0 THEN ROUND(TRSP_RFND_INV_AMT, 0)                             		" ).append("\n"); 
		query.append("							ELSE                                     ROUND(TRSP_RFND_INV_AMT, 2)                             		" ).append("\n"); 
		query.append("						   END                                                                                                  		" ).append("\n"); 
		query.append("						   -                                                                                                    		" ).append("\n"); 
		query.append("						   CASE NVL((SELECT DP_PRCS_KNT FROM MDM_CURRENCY WHERE CURR_CD = W.INV_CURR_CD), 0) WHEN 0  THEN ROUND((RF.TRSP_RFND_INV_AMT/RFND_MON_KNT), 0)          		" ).append("\n"); 
		query.append("							ELSE                                     ROUND((RF.TRSP_RFND_INV_AMT/RFND_MON_KNT), 2)          		" ).append("\n"); 
		query.append("						   END * RFND_MON_KNT	                                                                                  		" ).append("\n"); 
		query.append("					FROM       TRS_TRSP_INV_WRK   W                                                                                 		" ).append("\n"); 
		query.append("						 , (                                                                                                    		" ).append("\n"); 
		query.append("						      SELECT                                                                                            		" ).append("\n"); 
		query.append("							       RF.INV_NO                                                                                		" ).append("\n"); 
		query.append("							    ,  RF.INV_VNDR_SEQ                                                                          		" ).append("\n"); 
		query.append("							    ,  RF.SUB_INV_SEQ                                                                           		" ).append("\n"); 
		query.append("							    ,  RF.TRSP_RFND_INV_AMT                                                                     		" ).append("\n"); 
		query.append("							    ,  RF.HNDL_PRD_FM_DT                                                                        		" ).append("\n"); 
		query.append("							    ,  RF.HNDL_PRD_TO_DT                                                                        		" ).append("\n"); 
		query.append("							    ,  TO_NUMBER(MONTHS_BETWEEN	(TO_DATE(TO_CHAR(HNDL_PRD_TO_DT,'YYYYMM'), 'YYYYMM'),TO_DATE(TO_CHAR(HNDL_PRD_FM_DT,'YYYYMM'), 'YYYYMM'))) + 1 RFND_MON_KNT		                                           					" ).append("\n"); 
		query.append("						      FROM TRS_TRSP_RFND_INV RF                                                                     		" ).append("\n"); 
		query.append("						   )  RF                                                                                                		" ).append("\n"); 
		query.append("					WHERE      W.INV_NO              = RF.INV_NO                                                                    		" ).append("\n"); 
		query.append("					AND        W.INV_VNDR_SEQ        = RF.INV_VNDR_SEQ                                                              		" ).append("\n"); 
		query.append("					AND        RF.INV_NO             = RFF.INV_NO                                                                   		" ).append("\n"); 
		query.append("					AND        RF.INV_VNDR_SEQ       = RFF.INV_VNDR_SEQ                                                             		" ).append("\n"); 
		query.append("					AND        RF.SUB_INV_SEQ        = RFF.SUB_INV_SEQ                                                              		" ).append("\n"); 
		query.append("				      )                                                                                                                 		" ).append("\n"); 
		query.append("WHERE       1 = 1                                                                                                                                      			" ).append("\n"); 
		query.append("AND         RFF.INV_VNDR_SEQ       		= @[INV_VNDR_SEQ]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ($INV_NO.size() > 0) " ).append("\n"); 
		query.append("	AND	RFF.INV_NO	IN	(" ).append("\n"); 
		query.append("		#foreach( ${key} in ${INV_NO}) " ).append("\n"); 
		query.append("			#if($velocityCount < $INV_NO.size()) " ).append("\n"); 
		query.append("				'$key', " ).append("\n"); 
		query.append("			#else " ).append("\n"); 
		query.append("				'$key' " ).append("\n"); 
		query.append("			#end " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}