/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : MexCustomsTransmissionDBDAOsearchCustomerRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.02
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.02 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.mexico.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MexCustomsTransmissionDBDAOsearchCustomerRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DWKIM, 0370, MxCustomerVO
	  * </pre>
	  */
	public MexCustomsTransmissionDBDAOsearchCustomerRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.mexico.integration").append("\n"); 
		query.append("FileName : MexCustomsTransmissionDBDAOsearchCustomerRSQL").append("\n"); 
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
		query.append("SELECT                                                                	" ).append("\n"); 
		query.append("         BCN.CUST_CNT_CD											NTFYCN                                                                  	" ).append("\n"); 
		query.append("         ,BCN.CUST_SEQ												NTFYCD                                                                  	" ).append("\n"); 
		query.append("         ,REPLACE(SCE_TOKEN_NL_FNC(BCN.CUST_NM, 1) ,'*','-')		NTFY1                                                                   	" ).append("\n"); 
		query.append("         ,REPLACE(SCE_TOKEN_NL_FNC(BCN.CUST_NM, 2) ,'*','-')		NTFY2                                                                   	" ).append("\n"); 
		query.append("         ,REPLACE(SCE_TOKEN_NL_FNC(BCN.CUST_ADDR, 1) ,'*','-')		NTFY3                                                                   	" ).append("\n"); 
		query.append("         ,REPLACE(SCE_TOKEN_NL_FNC(BCN.CUST_ADDR, 2) ,'*','-')		NTFY4                                                                   	" ).append("\n"); 
		query.append("         ,REPLACE(SCE_TOKEN_NL_FNC(BCN.CUST_ADDR, 3) ,'*','-')		NTFY5" ).append("\n"); 
		query.append("		 ,NVL(LIC.MX_NTFY_TAX_ID, ' ')								NTFYTAXID                                                                   	" ).append("\n"); 
		query.append("         ,BCA.CUST_CNT_CD											NTFY2CN                                                                 	" ).append("\n"); 
		query.append("         ,BCA.CUST_SEQ												NTFY2NM                                                                  	" ).append("\n"); 
		query.append("         ,REPLACE(SCE_TOKEN_NL_FNC(BCA.CUST_NM, 1) ,'*','-')		NTFY21                                                                   	" ).append("\n"); 
		query.append("         ,REPLACE(SCE_TOKEN_NL_FNC(BCA.CUST_NM, 2) ,'*','-')		NTFY22                                                                   	" ).append("\n"); 
		query.append("         ,REPLACE(SCE_TOKEN_NL_FNC(BCA.CUST_ADDR, 1) ,'*','-')		NTFY23                                                                   	" ).append("\n"); 
		query.append("         ,REPLACE(SCE_TOKEN_NL_FNC(BCA.CUST_ADDR, 2) ,'*','-')		NTFY24                                                                   	" ).append("\n"); 
		query.append("         ,REPLACE(SCE_TOKEN_NL_FNC(BCA.CUST_ADDR, 3) ,'*','-')		NTFY25                                                                   	" ).append("\n"); 
		query.append("         ,BCF.CUST_CNT_CD											FFWDCN                                                                   	" ).append("\n"); 
		query.append("         ,BCF.CUST_SEQ												FFWDCD                                                                   	" ).append("\n"); 
		query.append("         ,REPLACE(SCE_TOKEN_NL_FNC(BCF.CUST_NM, 1) ,'*','-')		FFWD1                                                                   	" ).append("\n"); 
		query.append("         ,REPLACE(SCE_TOKEN_NL_FNC(BCF.CUST_NM, 2) ,'*','-')		FFWD2                                                                    	" ).append("\n"); 
		query.append("         ,REPLACE(SCE_TOKEN_NL_FNC(BCF.CUST_ADDR, 1) ,'*','-')		FFWD3                                                                    	" ).append("\n"); 
		query.append("         ,REPLACE(SCE_TOKEN_NL_FNC(BCF.CUST_ADDR, 2) ,'*','-')		FFWD4                                                                    	" ).append("\n"); 
		query.append("         ,REPLACE(SCE_TOKEN_NL_FNC(BCF.CUST_ADDR, 3) ,'*','-')		FFWD5                                                                    	" ).append("\n"); 
		query.append("         ,BCE.CUST_CNT_CD											EXPOCN" ).append("\n"); 
		query.append("         ,BCE.CUST_SEQ												EXPOCD" ).append("\n"); 
		query.append("         ,REPLACE(SCE_TOKEN_NL_FNC(BCE.CUST_NM, 1) ,'*','-')		EXPO1" ).append("\n"); 
		query.append("         ,REPLACE(SCE_TOKEN_NL_FNC(BCE.CUST_NM, 2) ,'*','-')		EXPO2" ).append("\n"); 
		query.append("         ,REPLACE(SCE_TOKEN_NL_FNC(BCE.CUST_NM, 3) ,'*','-')		EXPO3" ).append("\n"); 
		query.append("         ,REPLACE(SCE_TOKEN_NL_FNC(BCE.CUST_NM, 4) ,'*','-')		EXPO4" ).append("\n"); 
		query.append("         ,REPLACE(SCE_TOKEN_NL_FNC(BCE.CUST_NM, 5) ,'*','-')		EXPO5	" ).append("\n"); 
		query.append("         ,NVL(BBI.BL_CPY_KNT, 0)						            BLCOPY                                                                   	" ).append("\n"); 
		query.append("         ,NVL(BBD.PCK_QTY, 0)										BLPKG                                                                    	" ).append("\n"); 
		query.append("         ,NVL(BBD.PCK_TP_CD, ' ')									BLPKGU  " ).append("\n"); 
		query.append("		 ,NVL(BBD.ACT_WGT, 0)       								BLWGT                                                                    	" ).append("\n"); 
		query.append("		 ,NVL(BBD.MEAS_QTY, 0)      								BLMEA " ).append("\n"); 
		query.append("         ,NVL(BBD.WGT_UT_CD, ' ')             						BL_WGT_UNIT                                                              	" ).append("\n"); 
		query.append("         ,NVL(BBD.MEAS_UT_CD, ' ')            						BL_MEA_UNIT                                                              	" ).append("\n"); 
		query.append("         ,NVL(BK.RCV_TERM_CD, ' ') || NVL(BK.DE_TERM_CD, ' ')		RDTYPE                                                                   	" ).append("\n"); 
		query.append("         ,NVL(BK.BKG_CGO_TP_CD, ' ')								CARGOTYPE                                                                 " ).append("\n"); 
		query.append("         ,NVL(BK.CMDT_CD, ' ') 										COMMODITY" ).append("\n"); 
		query.append("         ,NVL(BK.REP_CMDT_CD, ' ') 									BLREPCMDCD" ).append("\n"); 
		query.append("		 ,REPLACE(REPLACE(REPLACE(Translate(NVL(BK.INTER_RMK,' '),chr(13)||chr(10),' '),'$','S'),'#',' '),'*','-') REMARK" ).append("\n"); 
		query.append("         ,'' 														AUS_QUAR                                    														" ).append("\n"); 
		query.append("         ,BK.BKG_NO													BKGNBR" ).append("\n"); 
		query.append("         ,'' 														RGN_BKGNBR  " ).append("\n"); 
		query.append("         ,NVL(BR.PPD_RCV_OFC_CD, ' ')	 							PPDOFC                                                                   	" ).append("\n"); 
		query.append("         ,NVL(BR.CLT_OFC_CD, ' ')	     							CCTOFC                                                                     	" ).append("\n"); 
		query.append("         ,'USA'            											THDOFC                                           							" ).append("\n"); 
		query.append("         ,NVL(BK.SC_NO, ' ')										SCNO                                                                     	" ).append("\n"); 
		query.append("         ,NVL(BK.RFA_NO, ' ')										RFANO" ).append("\n"); 
		query.append("         ,BK.MTY_PKUP_YD_CD 										EQREL                                                                    	" ).append("\n"); 
		query.append("         ,TO_CHAR(BK.MTY_PKUP_DT,'RRRRMMDDHH24MI')    				EQPICKDT                                                                 	" ).append("\n"); 
		query.append("         ,BK.MTY_RTN_YD_CD  										EQRTN " ).append("\n"); 
		query.append("		-- 2009/09/18, DONG-IL HA, UD_CD IS STWG_CD IN BKG_BOOKING.    " ).append("\n"); 
		query.append("		 ,NVL(BK.STWG_CD, ' ')										UD_CD " ).append("\n"); 
		query.append("  FROM " ).append("\n"); 
		query.append("        BKG_BOOKING BK                                                                               " ).append("\n"); 
		query.append("        ,BKG_BL_ISS  BBI                                                                              " ).append("\n"); 
		query.append("        ,BKG_BL_DOC  BBD                                                                              " ).append("\n"); 
		query.append("        ,BKG_RATE    BR" ).append("\n"); 
		query.append("        ,BKG_CUSTOMER BCN                                                                             " ).append("\n"); 
		query.append("        ,BKG_CUSTOMER BCF                                                                             " ).append("\n"); 
		query.append("        ,BKG_CUSTOMER BCA                                                                             " ).append("\n"); 
		query.append("        ,BKG_CUSTOMER BCE" ).append("\n"); 
		query.append("		,BKG_XPT_IMP_LIC LIC                                                                        " ).append("\n"); 
		query.append(" WHERE   BK.BKG_NO          =   @[bkg_no]" ).append("\n"); 
		query.append("   AND   BK.BKG_NO          =   BBI.BKG_NO      (+)" ).append("\n"); 
		query.append("   AND   BK.BKG_NO          =   BBD.BKG_NO      (+)" ).append("\n"); 
		query.append("   AND   BK.BKG_NO          =   BR.BKG_NO" ).append("\n"); 
		query.append("   AND   BK.BKG_NO          =   BCN.BKG_NO      (+)" ).append("\n"); 
		query.append("   AND   BCN.BKG_CUST_TP_CD(+) =   'N'" ).append("\n"); 
		query.append("   AND   BK.BKG_NO          =   BCF.BKG_NO      (+)" ).append("\n"); 
		query.append("   AND   BCF.BKG_CUST_TP_CD(+) =   'F'" ).append("\n"); 
		query.append("   AND   BK.BKG_NO          =   BCA.BKG_NO      (+)" ).append("\n"); 
		query.append("   AND   BCA.BKG_CUST_TP_CD(+) =   'A'" ).append("\n"); 
		query.append("   AND   BK.BKG_NO          =   BCE.BKG_NO      (+)" ).append("\n"); 
		query.append("   AND   BCE.BKG_CUST_TP_CD(+) =   'E'" ).append("\n"); 
		query.append("   AND   BK.BKG_NO			=   LIC.BKG_NO		(+)" ).append("\n"); 
		query.append("   AND   ROWNUM = 1" ).append("\n"); 

	}
}