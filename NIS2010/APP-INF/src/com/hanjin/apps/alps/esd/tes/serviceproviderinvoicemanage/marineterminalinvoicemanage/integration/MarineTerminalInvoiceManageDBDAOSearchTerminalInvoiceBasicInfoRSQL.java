/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : MarineTerminalInvoiceManageDBDAOSearchTerminalInvoiceBasicInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.07.26
*@LastModifier : 
*@LastVersion : 1.0
* 2017.07.26 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MarineTerminalInvoiceManageDBDAOSearchTerminalInvoiceBasicInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchTerminalInvoiceBasicInfo
	  * </pre>
	  */
	public MarineTerminalInvoiceManageDBDAOSearchTerminalInvoiceBasicInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration").append("\n"); 
		query.append("FileName : MarineTerminalInvoiceManageDBDAOSearchTerminalInvoiceBasicInfoRSQL").append("\n"); 
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
		query.append("SELECT                                                                             " ).append("\n"); 
		query.append("	TML_SO_OFC_CTY_CD  								  						        " ).append("\n"); 
		query.append("    , TML_SO_SEQ                                          					        " ).append("\n"); 
		query.append("    , INV_OFC_CD                                          					        " ).append("\n"); 
		query.append("    , COST_OFC_CD                                         					        " ).append("\n"); 
		query.append("    , INV_NO                                              					        " ).append("\n"); 
		query.append("    , LPAD(VNDR_SEQ, 6, '0') VNDR_SEQ                    						    " ).append("\n"); 
		query.append("    , YD_CD                                               					        " ).append("\n"); 
		query.append("    , TES_GET_YARDNM_FNC(YD_CD)    		YD_NM								    " ).append("\n"); 
		query.append("    , CURR_CD                                             					        " ).append("\n"); 
		query.append("    , TTL_INV_AMT                                         					        " ).append("\n"); 
		query.append("    , VAT_AMT                                             					        " ).append("\n"); 
		query.append("    , WHLD_TAX_AMT                                        					        " ).append("\n"); 
		query.append("    , TTL_CALC_AMT                                        					        " ).append("\n"); 
		query.append("    , TO_CHAR(TO_DATE(FM_PRD_DT,'YYYYMMDD'),'YYYY-MM-DD') 	FM_PRD_DT		        " ).append("\n"); 
		query.append("    , HLD_FLG                                             					        " ).append("\n"); 
		query.append("    , HLD_RMK                                             					        " ).append("\n"); 
		query.append("    , TO_CHAR(TO_DATE(TO_PRD_DT,'YYYYMMDD'),'YYYY-MM-DD')  TO_PRD_DT			    " ).append("\n"); 
		query.append("    , TML_INV_TP_CD                                       					        " ).append("\n"); 
		query.append("    , TML_COST_GRP_CD                                     					        " ).append("\n"); 
		query.append("    , TML_CALC_IND_CD                                     					        " ).append("\n"); 
		query.append("    , STO_DYS_IND_CD                                      					        " ).append("\n"); 
		query.append("    , TO_CHAR(ISS_DT,'YYYY-MM-DD') 				ISS_DT          			    " ).append("\n"); 
		query.append("    , TO_CHAR(RCV_DT,'YYYY-MM-DD') 				RCV_DT          			    " ).append("\n"); 
		query.append("    , TO_CHAR(EFF_DT,'YYYY-MM-DD') 				EFF_DT          			    " ).append("\n"); 
		query.append("    , TO_CHAR(PAY_DUE_DT,'YYYY-MM-DD') 			PAY_DUE_DT     				    " ).append("\n"); 
		query.append("    , PAY_FLG                                             					        " ).append("\n"); 
		query.append("    , EDI_FLG             " ).append("\n"); 
		query.append("	, NVL(" ).append("\n"); 
		query.append("	CASE" ).append("\n"); 
		query.append("	WHEN H.EDI_FLG = 'Y'" ).append("\n"); 
		query.append("	THEN  (" ).append("\n"); 
		query.append("    	SELECT " ).append("\n"); 
		query.append("        	CASE" ).append("\n"); 
		query.append("	        WHEN F.FILE_SEQ IS NOT NULL AND F.ORG_FILE_NM IS NOT NULL AND F.FILE_SAV_ID IS NOT NULL AND C.FILE_SAV_ID IS NOT NULL" ).append("\n"); 
		query.append("    	    THEN 'Y'" ).append("\n"); 
		query.append("        	ELSE 'N'" ).append("\n"); 
		query.append("	        END FILE_CHK" ).append("\n"); 
		query.append("    	FROM TES_EDI_SO_HDR E, TES_EDI_SO_FILE F, COM_UPLD_FILE C" ).append("\n"); 
		query.append("	    WHERE 1=1" ).append("\n"); 
		query.append("	    AND E.TML_SO_OFC_CTY_CD = H.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("	    AND E.TML_SO_SEQ = H.TML_SO_SEQ" ).append("\n"); 
		query.append("	    AND NVL(E.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("	    AND ((E.TML_EDI_SO_OFC_CTY_CD = F.TML_EDI_SO_OFC_CTY_CD AND E.TML_EDI_SO_SEQ = F.TML_EDI_SO_SEQ) " ).append("\n"); 
		query.append("				OR" ).append("\n"); 
		query.append("			 (E.TML_SO_OFC_CTY_CD = F.TML_SO_OFC_CTY_CD AND E.TML_SO_SEQ = F.TML_SO_SEQ))" ).append("\n"); 
		query.append("	    AND NVL(F.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("	    AND F.FILE_SAV_ID = C.FILE_SAV_ID" ).append("\n"); 
		query.append("	    AND NVL(C.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("		AND ROWNUM = 1" ).append("\n"); 
		query.append("    	)" ).append("\n"); 
		query.append("	ELSE 'N'" ).append("\n"); 
		query.append("	END,'N') FILE_CHK	                                					        " ).append("\n"); 
		query.append("    , RTRO_TML_INV_FLG                                             					" ).append("\n"); 
		query.append("    , TML_INV_STS_CD                                      					        " ).append("\n"); 
		query.append("	, COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD00172',TML_INV_STS_CD) TML_INV_STS_NM    " ).append("\n"); 
		query.append("    , TML_INV_RJCT_STS_CD                                 					        " ).append("\n"); 
		query.append("    , TO_CHAR(INV_CFM_DT,'YYYY-MM-DD') 			INV_CFM_DT      			    " ).append("\n"); 
		query.append("    , INV_RJCT_RMK                                        					        " ).append("\n"); 
		query.append("    , CRE_USR_ID                                          					        " ).append("\n"); 
		query.append("    , TO_CHAR(CRE_DT,'YYYY-MM-DD') 				CRE_DT          			    " ).append("\n"); 
		query.append("    , UPD_USR_ID                                          					        " ).append("\n"); 
		query.append("    , TO_CHAR(UPD_DT,'YYYY-MM-DD')  			UPD_DT" ).append("\n"); 
		query.append("	, AP_RVS_CNG_FLG         " ).append("\n"); 
		query.append("	, DBT_NOTE_NO  -- india " ).append("\n"); 
		query.append("	, IDA_CGST_AMT -- india   " ).append("\n"); 
		query.append("	, IDA_SGST_AMT -- india " ).append("\n"); 
		query.append("	, IDA_IGST_AMT -- india " ).append("\n"); 
		query.append("	, IDA_UGST_AMT -- india       		    " ).append("\n"); 
		query.append("FROM TES_TML_SO_HDR H                                                       		" ).append("\n"); 
		query.append("WHERE VNDR_SEQ = @[vndr_seq]                                                   	  		    " ).append("\n"); 
		query.append("AND   INV_NO   = @[inv_no]                                                   	  		    " ).append("\n"); 
		query.append("AND   NVL(DELT_FLG,'N')   <> 'Y'" ).append("\n"); 

	}
}