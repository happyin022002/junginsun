/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : JapanTerminalTransmissionDBDAOupdateNewBkgInfoVvdChkUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.12.20
*@LastModifier : 조원주
*@LastVersion : 1.0
* 2012.12.20 조원주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japanterminal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHO WON-JOO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JapanTerminalTransmissionDBDAOupdateNewBkgInfoVvdChkUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * updateNewBkgInfoVvdChk
	  * </pre>
	  */
	public JapanTerminalTransmissionDBDAOupdateNewBkgInfoVvdChkUSQL(){
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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("snaccs_tml_edi_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japanterminal.integration").append("\n"); 
		query.append("FileName : JapanTerminalTransmissionDBDAOupdateNewBkgInfoVvdChkUSQL").append("\n"); 
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
		query.append("UPDATE BKG_TML_EDI_JP_BL SET " ).append("\n"); 
		query.append("  BKG_SKD_DELT_FLG           = (SELECT BKG_SKD_DELT_FLG " ).append("\n"); 
		query.append("   								   FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("    							  WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("     								AND BKG_SKD_SEQ=(SELECT NVL(MAX(BKG_SKD_SEQ), 0)" ).append("\n"); 
		query.append("		                		                       FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("                       							      WHERE BKG_NO = @[bkg_no]))" ).append("\n"); 
		query.append(", SNACCS_TML_EDI_STS_CD      = @[snaccs_tml_edi_sts_cd]" ).append("\n"); 
		query.append(", EDI_SND_DT                 = SYSDATE" ).append("\n"); 
		query.append(", EDI_SND_OFC_CD             = (SELECT EDI_SND_OFC_CD  " ).append("\n"); 
		query.append("   								   FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("    							  WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("     								AND BKG_SKD_SEQ=(SELECT NVL(MAX(BKG_SKD_SEQ), 0) " ).append("\n"); 
		query.append("		                		                       FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("                       							      WHERE BKG_NO = @[bkg_no]))" ).append("\n"); 
		query.append(", EDI_SND_USR_ID             = (SELECT EDI_SND_USR_ID    " ).append("\n"); 
		query.append("   								   FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("    							  WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("     								AND BKG_SKD_SEQ=(SELECT NVL(MAX(BKG_SKD_SEQ), 0) " ).append("\n"); 
		query.append("		                		                       FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("                       							      WHERE BKG_NO = @[bkg_no]))" ).append("\n"); 
		query.append(", VSL_CD                     =   (SELECT VSL_CD " ).append("\n"); 
		query.append("   								   FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("    							  WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("     								AND BKG_SKD_SEQ=(SELECT NVL(MAX(BKG_SKD_SEQ), 0) " ).append("\n"); 
		query.append("		                		                       FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("                       							      WHERE BKG_NO = @[bkg_no]))" ).append("\n"); 
		query.append(", SKD_VOY_NO                 = (SELECT SKD_VOY_NO " ).append("\n"); 
		query.append("   								   FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("    							  WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("     								AND BKG_SKD_SEQ=(SELECT NVL(MAX(BKG_SKD_SEQ), 0) " ).append("\n"); 
		query.append("		                		                       FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("                       							      WHERE BKG_NO = @[bkg_no]))" ).append("\n"); 
		query.append(", SKD_DIR_CD                 = (SELECT SKD_DIR_CD " ).append("\n"); 
		query.append("   								   FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("    							  WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("     								AND BKG_SKD_SEQ=(SELECT NVL(MAX(BKG_SKD_SEQ), 0) " ).append("\n"); 
		query.append("		                		                       FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("                       							      WHERE BKG_NO = @[bkg_no]))" ).append("\n"); 
		query.append(", JP_TML_VSL_NO 			 = (SELECT JP_TML_VSL_NO " ).append("\n"); 
		query.append("   								   FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("    							  WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("     								AND BKG_SKD_SEQ=(SELECT NVL(MAX(BKG_SKD_SEQ), 0) " ).append("\n"); 
		query.append("		                		                       FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("                       							      WHERE BKG_NO = @[bkg_no]))" ).append("\n"); 
		query.append(", POL_CD                     = (SELECT POL_CD " ).append("\n"); 
		query.append("   								   FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("    							  WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("     								AND BKG_SKD_SEQ=(SELECT NVL(MAX(BKG_SKD_SEQ), 0) " ).append("\n"); 
		query.append("		                		                       FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("                       							      WHERE BKG_NO = @[bkg_no]))" ).append("\n"); 
		query.append(", POL_YD_CD                  = (SELECT POL_YD_CD " ).append("\n"); 
		query.append("   								   FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("    							  WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("     								AND BKG_SKD_SEQ=(SELECT NVL(MAX(BKG_SKD_SEQ), 0) " ).append("\n"); 
		query.append("		                		                       FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("                       							      WHERE BKG_NO = @[bkg_no]))" ).append("\n"); 
		query.append(", POR_CD                     = (SELECT POR_CD " ).append("\n"); 
		query.append("   								   FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("    							  WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("     								AND BKG_SKD_SEQ=(SELECT NVL(MAX(BKG_SKD_SEQ), 0) " ).append("\n"); 
		query.append("		                		                       FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("                       							      WHERE BKG_NO = @[bkg_no]))" ).append("\n"); 
		query.append(", POR_YD_CD                  = (SELECT POR_YD_CD  " ).append("\n"); 
		query.append("   								   FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("    							  WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("     								AND BKG_SKD_SEQ=(SELECT NVL(MAX(BKG_SKD_SEQ), 0) " ).append("\n"); 
		query.append("		                		                       FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("                       							      WHERE BKG_NO = @[bkg_no]))" ).append("\n"); 
		query.append(", OTR_NTFY_YD_CD             = (SELECT OTR_NTFY_YD_CD  " ).append("\n"); 
		query.append("   								   FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("    							  WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("     								AND BKG_SKD_SEQ=(SELECT NVL(MAX(BKG_SKD_SEQ), 0) " ).append("\n"); 
		query.append("		                		                       FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("                       							      WHERE BKG_NO = @[bkg_no]))" ).append("\n"); 
		query.append(", CNTR_TPSZ_CD1              = (SELECT CNTR_TPSZ_CD1  " ).append("\n"); 
		query.append("   								   FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("    							  WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("     								AND BKG_SKD_SEQ=(SELECT NVL(MAX(BKG_SKD_SEQ), 0) " ).append("\n"); 
		query.append("		                		                       FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("                       							      WHERE BKG_NO = @[bkg_no]))" ).append("\n"); 
		query.append(", CNTR_VOL_QTY1              = (SELECT CNTR_VOL_QTY1  " ).append("\n"); 
		query.append("   								   FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("    							  WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("     								AND BKG_SKD_SEQ=(SELECT NVL(MAX(BKG_SKD_SEQ), 0) " ).append("\n"); 
		query.append("		                		                       FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("                       							      WHERE BKG_NO = @[bkg_no]))" ).append("\n"); 
		query.append(", CNTR_TPSZ_CD2              = (SELECT CNTR_TPSZ_CD2  " ).append("\n"); 
		query.append("   								   FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("    							  WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("     								AND BKG_SKD_SEQ=(SELECT NVL(MAX(BKG_SKD_SEQ), 0) " ).append("\n"); 
		query.append("		                		                       FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("                       							      WHERE BKG_NO = @[bkg_no]))" ).append("\n"); 
		query.append(", CNTR_VOL_QTY2              = (SELECT CNTR_VOL_QTY2  " ).append("\n"); 
		query.append("   								   FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("    							  WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("     								AND BKG_SKD_SEQ=(SELECT NVL(MAX(BKG_SKD_SEQ), 0) " ).append("\n"); 
		query.append("		                		                       FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("                       							      WHERE BKG_NO = @[bkg_no]))" ).append("\n"); 
		query.append(", CNTR_TPSZ_CD3              = (SELECT CNTR_TPSZ_CD3  " ).append("\n"); 
		query.append("   								   FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("    							  WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("     								AND BKG_SKD_SEQ=(SELECT NVL(MAX(BKG_SKD_SEQ), 0) " ).append("\n"); 
		query.append("		                		                       FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("                       							      WHERE BKG_NO = @[bkg_no]))" ).append("\n"); 
		query.append(", CNTR_VOL_QTY3              = (SELECT CNTR_TPSZ_CD3  " ).append("\n"); 
		query.append("   								   FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("    							  WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("     								AND BKG_SKD_SEQ=(SELECT NVL(MAX(BKG_SKD_SEQ), 0) " ).append("\n"); 
		query.append("		                		                       FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("                       							      WHERE BKG_NO = @[bkg_no]))" ).append("\n"); 
		query.append(", CNTR_TPSZ_CD4              = (SELECT CNTR_TPSZ_CD4  " ).append("\n"); 
		query.append("   								   FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("    							  WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("     								AND BKG_SKD_SEQ=(SELECT NVL(MAX(BKG_SKD_SEQ), 0) " ).append("\n"); 
		query.append("		                		                       FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("                       							      WHERE BKG_NO = @[bkg_no]))" ).append("\n"); 
		query.append(", CNTR_VOL_QTY4              = (SELECT CNTR_VOL_QTY4  " ).append("\n"); 
		query.append("   								   FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("    							  WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("     								AND BKG_SKD_SEQ=(SELECT NVL(MAX(BKG_SKD_SEQ), 0) " ).append("\n"); 
		query.append("		                		                       FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("                       							      WHERE BKG_NO = @[bkg_no]))" ).append("\n"); 
		query.append(", CNTR_TPSZ_CD5              = (SELECT CNTR_TPSZ_CD5  " ).append("\n"); 
		query.append("   								   FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("    							  WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("     								AND BKG_SKD_SEQ=(SELECT NVL(MAX(BKG_SKD_SEQ), 0) " ).append("\n"); 
		query.append("		                		                       FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("                       							      WHERE BKG_NO = @[bkg_no]))" ).append("\n"); 
		query.append(", CNTR_VOL_QTY5              = (SELECT CNTR_VOL_QTY5 " ).append("\n"); 
		query.append("   								   FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("    							  WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("     								AND BKG_SKD_SEQ=(SELECT NVL(MAX(BKG_SKD_SEQ), 0) " ).append("\n"); 
		query.append("		                		                       FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("                       							      WHERE BKG_NO = @[bkg_no]))" ).append("\n"); 
		query.append(", PRT_FLG                    = (SELECT PRT_FLG   " ).append("\n"); 
		query.append("   								   FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("    							  WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("     								AND BKG_SKD_SEQ=(SELECT NVL(MAX(BKG_SKD_SEQ), 0) " ).append("\n"); 
		query.append("		                		                       FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("                       							      WHERE BKG_NO = @[bkg_no]))" ).append("\n"); 
		query.append(", CALL_SGN_NO                = (SELECT CALL_SGN_NO  " ).append("\n"); 
		query.append("   								   FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("    							  WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("     								AND BKG_SKD_SEQ=(SELECT NVL(MAX(BKG_SKD_SEQ), 0) " ).append("\n"); 
		query.append("		                		                       FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("                       							      WHERE BKG_NO = @[bkg_no]))" ).append("\n"); 
		query.append(", VSL_ENG_NM                 = (SELECT VSL_ENG_NM  " ).append("\n"); 
		query.append("   								   FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("    							  WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("     								AND BKG_SKD_SEQ=(SELECT NVL(MAX(BKG_SKD_SEQ), 0) " ).append("\n"); 
		query.append("		                		                       FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("                       							      WHERE BKG_NO = @[bkg_no]))" ).append("\n"); 
		query.append(", BKG_CRE_DT                 = (SELECT BKG_CRE_DT  " ).append("\n"); 
		query.append("   								   		  FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("    							 		 WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("     									   AND BKG_SKD_SEQ=(SELECT NVL(MAX(BKG_SKD_SEQ), 0) " ).append("\n"); 
		query.append("		                		                      		  FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("                       							      		 WHERE BKG_NO = @[bkg_no]))" ).append("\n"); 
		query.append(", ETD_DT                     = (SELECT ETD_DT  " ).append("\n"); 
		query.append("   								   		  FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("    							 		 WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("     									   AND BKG_SKD_SEQ=(SELECT NVL(MAX(BKG_SKD_SEQ), 0) " ).append("\n"); 
		query.append("		                		                      		  FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("                       							      		 WHERE BKG_NO = @[bkg_no]))" ).append("\n"); 
		query.append(", SHPR_CNT_CD                = (SELECT SHPR_CNT_CD" ).append("\n"); 
		query.append("   								   FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("    							  WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("     								AND BKG_SKD_SEQ=(SELECT NVL(MAX(BKG_SKD_SEQ), 0) " ).append("\n"); 
		query.append("		                		                       FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("                       							      WHERE BKG_NO = @[bkg_no]))" ).append("\n"); 
		query.append(", SHPR_CUST_SEQ              = (SELECT SHPR_CUST_SEQ " ).append("\n"); 
		query.append("   								   FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("    							  WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("     								AND BKG_SKD_SEQ=(SELECT NVL(MAX(BKG_SKD_SEQ), 0) " ).append("\n"); 
		query.append("		                		                       FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("                       							      WHERE BKG_NO = @[bkg_no]))" ).append("\n"); 
		query.append(", SHPR_CUST_NM               = (SELECT SHPR_CUST_NM" ).append("\n"); 
		query.append("   								   FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("    							  WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("     								AND BKG_SKD_SEQ=(SELECT NVL(MAX(BKG_SKD_SEQ), 0) " ).append("\n"); 
		query.append("		                		                       FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("                       							      WHERE BKG_NO = @[bkg_no]))" ).append("\n"); 
		query.append(", FRT_FWRD_CNT_CD            = (SELECT FRT_FWRD_CNT_CD" ).append("\n"); 
		query.append("   								   FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("    							  WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("     								AND BKG_SKD_SEQ=(SELECT NVL(MAX(BKG_SKD_SEQ), 0) " ).append("\n"); 
		query.append("		                		                       FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("                       							      WHERE BKG_NO = @[bkg_no]))" ).append("\n"); 
		query.append(", FRT_FWRD_CUST_SEQ          = (SELECT FRT_FWRD_CUST_SEQ" ).append("\n"); 
		query.append("   								   FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("    							  WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("     								AND BKG_SKD_SEQ=(SELECT NVL(MAX(BKG_SKD_SEQ), 0) " ).append("\n"); 
		query.append("		                		                       FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("                       							      WHERE BKG_NO = @[bkg_no]))" ).append("\n"); 
		query.append(", FRT_FWRD_CUST_NM           = (SELECT FRT_FWRD_CUST_NM " ).append("\n"); 
		query.append("   								   FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("    							  WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("     								AND BKG_SKD_SEQ=(SELECT NVL(MAX(BKG_SKD_SEQ), 0) " ).append("\n"); 
		query.append("		                		                       FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("                       							      WHERE BKG_NO = @[bkg_no]))" ).append("\n"); 
		query.append(", SNACCS_TML_EDI_RCV_TERM_CD = (SELECT SNACCS_TML_EDI_RCV_TERM_CD " ).append("\n"); 
		query.append("   								   FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("    							  WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("     								AND BKG_SKD_SEQ=(SELECT NVL(MAX(BKG_SKD_SEQ), 0) " ).append("\n"); 
		query.append("		                		                       FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("                       							      WHERE BKG_NO = @[bkg_no]))" ).append("\n"); 
		query.append(", POD_CD                     = (SELECT POD_CD " ).append("\n"); 
		query.append("   								   FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("    							  WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("     								AND BKG_SKD_SEQ=(SELECT NVL(MAX(BKG_SKD_SEQ), 0) " ).append("\n"); 
		query.append("		                		                       FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("                       							      WHERE BKG_NO = @[bkg_no]))" ).append("\n"); 
		query.append(", DEL_CD                     = (SELECT DEL_CD " ).append("\n"); 
		query.append("   								   FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("    							  WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("     								AND BKG_SKD_SEQ=(SELECT NVL(MAX(BKG_SKD_SEQ), 0) " ).append("\n"); 
		query.append("		                		                       FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("                       							      WHERE BKG_NO = @[bkg_no]))" ).append("\n"); 
		query.append(", SNACCS_TML_EDI_DE_TERM_CD  = (SELECT SNACCS_TML_EDI_DE_TERM_CD " ).append("\n"); 
		query.append("   								   FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("    							  WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("     								AND BKG_SKD_SEQ=(SELECT NVL(MAX(BKG_SKD_SEQ), 0) " ).append("\n"); 
		query.append("		                		                       FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("                       							      WHERE BKG_NO = @[bkg_no]))" ).append("\n"); 
		query.append(", FNL_DEST_CD                = (SELECT FNL_DEST_CD " ).append("\n"); 
		query.append("   								   FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("    							  WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("     								AND BKG_SKD_SEQ=(SELECT NVL(MAX(BKG_SKD_SEQ), 0) " ).append("\n"); 
		query.append("		                		                       FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("                       							      WHERE BKG_NO = @[bkg_no]))" ).append("\n"); 
		query.append(", FNL_DEST_NM                = (SELECT FNL_DEST_NM" ).append("\n"); 
		query.append("   								   FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("    							  WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("     								AND BKG_SKD_SEQ=(SELECT NVL(MAX(BKG_SKD_SEQ), 0) " ).append("\n"); 
		query.append("		                		                       FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("                       							      WHERE BKG_NO = @[bkg_no]))" ).append("\n"); 
		query.append(", SNACCS_TML_EDI_CGO_TP_CD   = (SELECT SNACCS_TML_EDI_CGO_TP_CD" ).append("\n"); 
		query.append("   								   FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("    							  WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("     								AND BKG_SKD_SEQ=(SELECT NVL(MAX(BKG_SKD_SEQ), 0) " ).append("\n"); 
		query.append("		                		                       FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("                       							      WHERE BKG_NO = @[bkg_no]))" ).append("\n"); 
		query.append(", SNACCS_TML_EDI_CGO_KND_CD  = (SELECT SNACCS_TML_EDI_CGO_KND_CD" ).append("\n"); 
		query.append("   								   FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("    							  WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("     								AND BKG_SKD_SEQ=(SELECT NVL(MAX(BKG_SKD_SEQ), 0) " ).append("\n"); 
		query.append("		                		                       FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("                       							      WHERE BKG_NO = @[bkg_no]))" ).append("\n"); 
		query.append(", PCK_TP_CD                  = (SELECT PCK_TP_CD " ).append("\n"); 
		query.append("   								   FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("    							  WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("     								AND BKG_SKD_SEQ=(SELECT NVL(MAX(BKG_SKD_SEQ), 0) " ).append("\n"); 
		query.append("		                		                       FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("                       							      WHERE BKG_NO = @[bkg_no]))" ).append("\n"); 
		query.append(", CMDT_NM                    = (SELECT CMDT_NM " ).append("\n"); 
		query.append("   								   FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("    							  WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("     								AND BKG_SKD_SEQ=(SELECT NVL(MAX(BKG_SKD_SEQ), 0) " ).append("\n"); 
		query.append("		                		                       FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("                       							      WHERE BKG_NO = @[bkg_no]))" ).append("\n"); 
		query.append(", XTER_RMK                   = (SELECT XTER_RMK " ).append("\n"); 
		query.append("   								   FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("    							  WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("     								AND BKG_SKD_SEQ=(SELECT NVL(MAX(BKG_SKD_SEQ), 0) " ).append("\n"); 
		query.append("		                		                       FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("                       							      WHERE BKG_NO = @[bkg_no]))" ).append("\n"); 
		query.append(", PCK_QTY                    = NVL((SELECT PCK_QTY" ).append("\n"); 
		query.append("   								   FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("    							  WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("     								AND BKG_SKD_SEQ=(SELECT NVL(MAX(BKG_SKD_SEQ), 0) " ).append("\n"); 
		query.append("		                		                       FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("                       							      WHERE BKG_NO = @[bkg_no])),0)" ).append("\n"); 
		query.append(", TTL_PCK_TP_CD              = (SELECT TTL_PCK_TP_CD " ).append("\n"); 
		query.append("   								   FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("    							  WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("     								AND BKG_SKD_SEQ=(SELECT NVL(MAX(BKG_SKD_SEQ), 0) " ).append("\n"); 
		query.append("		                		                       FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("                       							      WHERE BKG_NO = @[bkg_no]))" ).append("\n"); 
		query.append(", GRS_WGT                    = NVL((SELECT GRS_WGT  " ).append("\n"); 
		query.append("   								   FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("    							  WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("     								AND BKG_SKD_SEQ=(SELECT NVL(MAX(BKG_SKD_SEQ), 0) " ).append("\n"); 
		query.append("		                		                       FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("                       							      WHERE BKG_NO = @[bkg_no])),0)" ).append("\n"); 
		query.append(", WGT_UT_CD                  = (SELECT WGT_UT_CD " ).append("\n"); 
		query.append("   								   FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("    							  WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("     								AND BKG_SKD_SEQ=(SELECT NVL(MAX(BKG_SKD_SEQ), 0) " ).append("\n"); 
		query.append("		                		                       FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("                       							      WHERE BKG_NO = @[bkg_no]))" ).append("\n"); 
		query.append(", MEAS_QTY                   = NVL((SELECT MEAS_QTY " ).append("\n"); 
		query.append("   								   FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("    							  WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("     								AND BKG_SKD_SEQ=(SELECT NVL(MAX(BKG_SKD_SEQ), 0) " ).append("\n"); 
		query.append("		                		                       FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("                       							      WHERE BKG_NO = @[bkg_no])),0)" ).append("\n"); 
		query.append(", MEAS_UT_CD                 = (SELECT MEAS_UT_CD   " ).append("\n"); 
		query.append("   								   FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("    							  WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("     								AND BKG_SKD_SEQ=(SELECT NVL(MAX(BKG_SKD_SEQ), 0) " ).append("\n"); 
		query.append("		                		                       FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("                       							      WHERE BKG_NO = @[bkg_no]))" ).append("\n"); 
		query.append(", SNACCS_TML_EDI_STWG_CD     = (SELECT SNACCS_TML_EDI_STWG_CD   " ).append("\n"); 
		query.append("   								   FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("    							  WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("     								AND BKG_SKD_SEQ=(SELECT NVL(MAX(BKG_SKD_SEQ), 0) " ).append("\n"); 
		query.append("		                		                       FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("                       							      WHERE BKG_NO = @[bkg_no]))" ).append("\n"); 
		query.append(", STWG_RMK                   = (SELECT STWG_RMK  " ).append("\n"); 
		query.append("   								   FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("    							  WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("     								AND BKG_SKD_SEQ=(SELECT NVL(MAX(BKG_SKD_SEQ), 0) " ).append("\n"); 
		query.append("		                		                       FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("                       							      WHERE BKG_NO = @[bkg_no]))" ).append("\n"); 
		query.append(", BLCK_STWG_CD               = (SELECT BLCK_STWG_CD " ).append("\n"); 
		query.append("   								   FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("    							  WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("     								AND BKG_SKD_SEQ=(SELECT NVL(MAX(BKG_SKD_SEQ), 0) " ).append("\n"); 
		query.append("		                		                       FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("                       							      WHERE BKG_NO = @[bkg_no]))" ).append("\n"); 
		query.append(", DRY_CGO_FLG                = (SELECT DRY_CGO_FLG  " ).append("\n"); 
		query.append("   								   FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("    							  WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("     								AND BKG_SKD_SEQ=(SELECT NVL(MAX(BKG_SKD_SEQ), 0) " ).append("\n"); 
		query.append("		                		                       FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("                       							      WHERE BKG_NO = @[bkg_no]))" ).append("\n"); 
		query.append(", MCNTR_FLG                  = (SELECT MCNTR_FLG " ).append("\n"); 
		query.append("   								   FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("    							  WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("     								AND BKG_SKD_SEQ=(SELECT NVL(MAX(BKG_SKD_SEQ), 0) " ).append("\n"); 
		query.append("		                		                       FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("                       							      WHERE BKG_NO = @[bkg_no]))" ).append("\n"); 
		query.append(", SOC_FLG                    =  (SELECT SOC_FLG " ).append("\n"); 
		query.append("   								   FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("    							  WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("     								AND BKG_SKD_SEQ=(SELECT NVL(MAX(BKG_SKD_SEQ), 0) " ).append("\n"); 
		query.append("		                		                       FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("                       							      WHERE BKG_NO = @[bkg_no]))" ).append("\n"); 
		query.append(", RF_CNTR_PRE_CLNG_FLG       =  (SELECT RF_CNTR_PRE_CLNG_FLG" ).append("\n"); 
		query.append("   								   FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("    							  WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("     								AND BKG_SKD_SEQ=(SELECT NVL(MAX(BKG_SKD_SEQ), 0) " ).append("\n"); 
		query.append("		                		                       FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("                       							      WHERE BKG_NO = @[bkg_no]))" ).append("\n"); 
		query.append(", DCGO_FLG                   =  (SELECT DCGO_FLG " ).append("\n"); 
		query.append("   								   FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("    							  WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("     								AND BKG_SKD_SEQ=(SELECT NVL(MAX(BKG_SKD_SEQ), 0) " ).append("\n"); 
		query.append("		                		                       FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("                       							      WHERE BKG_NO = @[bkg_no]))" ).append("\n"); 
		query.append(", AWK_CGO_FLG                =  (SELECT AWK_CGO_FLG   " ).append("\n"); 
		query.append("   								   FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("    							  WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("     								AND BKG_SKD_SEQ=(SELECT NVL(MAX(BKG_SKD_SEQ), 0) " ).append("\n"); 
		query.append("		                		                       FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("                       							      WHERE BKG_NO = @[bkg_no]))" ).append("\n"); 
		query.append(", BB_CGO_FLG                 =  (SELECT BB_CGO_FLG" ).append("\n"); 
		query.append("   								   FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("    							  WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("     								AND BKG_SKD_SEQ=(SELECT NVL(MAX(BKG_SKD_SEQ), 0) " ).append("\n"); 
		query.append("		                		                       FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("                       							      WHERE BKG_NO = @[bkg_no]))" ).append("\n"); 
		query.append(", RD_CGO_FLG                 =  (SELECT RD_CGO_FLG  " ).append("\n"); 
		query.append("   								   FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("    							  WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("     								AND BKG_SKD_SEQ=(SELECT NVL(MAX(BKG_SKD_SEQ), 0) " ).append("\n"); 
		query.append("		                		                       FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("                       							      WHERE BKG_NO = @[bkg_no]))" ).append("\n"); 
		query.append(", SNACCS_TML_EDI_STS_CNG_FLG =  (SELECT SNACCS_TML_EDI_STS_CNG_FLG" ).append("\n"); 
		query.append("   								   FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("    							  WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("     								AND BKG_SKD_SEQ=(SELECT NVL(MAX(BKG_SKD_SEQ), 0) " ).append("\n"); 
		query.append("		                		                       FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("                       							      WHERE BKG_NO = @[bkg_no]))" ).append("\n"); 
		query.append(", CRE_USR_ID                 = @[cre_usr_id]" ).append("\n"); 
		query.append(", CRE_DT                     = SYSDATE" ).append("\n"); 
		query.append(", UPD_USR_ID                 = @[cre_usr_id]" ).append("\n"); 
		query.append(", UPD_DT                     = SYSDATE" ).append("\n"); 
		query.append("WHERE BKG_NO       = @[bkg_no]" ).append("\n"); 
		query.append("  AND BKG_SKD_SEQ  = 0" ).append("\n"); 

	}
}