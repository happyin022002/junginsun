/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : BLIssuanceDBDAOSearchBlPrintGrpRcvFtpRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.19
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.19 
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

public class BLIssuanceDBDAOSearchBlPrintGrpRcvFtpRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Booking BL을 전송할 FTP 정보를 조회한다.(FTP Send)
	  * </pre>
	  */
	public BLIssuanceDBDAOSearchBlPrintGrpRcvFtpRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOSearchBlPrintGrpRcvFtpRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT GRP.BL_GRP_SEQ, GRP.BL_VW_RT_TP_CD" ).append("\n"); 
		query.append("       ,GRP.FTP_SVR_NM                       ---- FTP 주소" ).append("\n"); 
		query.append("       ,GRP.FTP_SVR_USR_NM                   ----FTP USER ID" ).append("\n"); 
		query.append("       ,GRP.FTP_SVR_PWD                      ----FTP USER PASSWORD" ).append("\n"); 
		query.append("       ,GRP.FTP_SVR_DIR_NM                   ---- FTP DIRECTORY" ).append("\n"); 
		query.append("       ,GRP.RTY_KNT                          ---- FTP RETRY COUNT" ).append("\n"); 
		query.append("       ,GRP.RTY_ITVAL_NO                     ---- FTP RETRY INTERVAL" ).append("\n"); 
		query.append("       ,(SELECT TO_CHAR(SYSTIMESTAMP, 'YYYYMMDDHH24MISSFF3') FROM DUAL)||BI.BKG_NO AS FTP_FILE -- FTP FILENAME" ).append("\n"); 
		query.append("       ,GRP.XPT_FILE_NM" ).append("\n"); 
		query.append("       ,GRP.FTP_DIR_CTNT" ).append("\n"); 
		query.append("       ,GRP.FTP_DIR_CTNT2" ).append("\n"); 
		query.append("       ,GRP.FTP_DIR_CTNT3" ).append("\n"); 
		query.append("       ,GRP.FTP_DIR_CTNT4" ).append("\n"); 
		query.append("	   ,GRP.BL_TP_CD" ).append("\n"); 
		query.append("       ,GRP.ERR_NTC_FLG" ).append("\n"); 
		query.append("       ,GRP.SCS_NTC_FLG" ).append("\n"); 
		query.append("       ,GRP.EML_PDF_ADDR" ).append("\n"); 
		query.append("       ,NVL((SELECT CUST_REF_NO_CTNT" ).append("\n"); 
		query.append("             FROM BKG_REFERENCE" ).append("\n"); 
		query.append("             WHERE 1=1" ).append("\n"); 
		query.append("             AND BKG_NO = BI.BKG_NO" ).append("\n"); 
		query.append("             AND BKG_REF_TP_CD ='EBFF'" ).append("\n"); 
		query.append("             AND ROWNUM =1 )" ).append("\n"); 
		query.append("         , ' ') AS FFREFNO" ).append("\n"); 
		query.append("FROM  BKG_BL_ISS BI" ).append("\n"); 
		query.append("      ,BKG_INET_BL_CTRL_PTY CP" ).append("\n"); 
		query.append("      ,BKG_CTRL_PTY_BL_GRP GRP" ).append("\n"); 
		query.append("      ,BKG_CTRL_BL_GRP_CUST BL" ).append("\n"); 
		query.append("WHERE BI.INET_CTRL_PTY_NM = CP.CUST_CNT_CD" ).append("\n"); 
		query.append("AND   BI.INET_CTRL_PTY_NO = CP.CUST_SEQ" ).append("\n"); 
		query.append("AND   CP.CTRL_PTY_SEQ = GRP.CTRL_PTY_SEQ" ).append("\n"); 
		query.append("AND   GRP.ALTN_DE_FLG = 'Y'" ).append("\n"); 
		query.append("AND   GRP.BL_GRP_SEQ = BL.BL_GRP_SEQ" ).append("\n"); 
		query.append("AND   BI.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("    AND   EXISTS (SELECT 'X' FROM BKG_CTRL_BL_GRP_CUST BCBG " ).append("\n"); 
		query.append("                  WHERE BCBG.BL_GRP_SEQ = BL.BL_GRP_SEQ " ).append("\n"); 
		query.append("                     AND BCBG.CUST_CNT_CD||BCBG.CUST_SEQ IN (SELECT BC.CUST_CNT_CD||BC.CUST_SEQ FROM BKG_CUSTOMER BC WHERE BC.BKG_NO = @[bkg_no] AND BC.BKG_CUST_TP_CD IN ('S','C','N','F'))" ).append("\n"); 
		query.append("                  )" ).append("\n"); 

	}
}