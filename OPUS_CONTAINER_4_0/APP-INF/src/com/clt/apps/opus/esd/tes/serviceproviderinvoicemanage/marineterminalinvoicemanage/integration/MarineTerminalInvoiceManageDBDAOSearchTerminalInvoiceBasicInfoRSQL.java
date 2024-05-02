/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : MarineTerminalInvoiceManageDBDAOSearchTerminalInvoiceBasicInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.11
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.11 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

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
		query.append("Path : com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration").append("\n"); 
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
		query.append("    , PAY_FLG                                             					                                                   					        " ).append("\n"); 
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
		query.append("	, COST_CD_FTR_RMK                    		    " ).append("\n"); 
		query.append("FROM TES_TML_SO_HDR                                                        		" ).append("\n"); 
		query.append("WHERE VNDR_SEQ = @[vndr_seq]                                                   	  		    " ).append("\n"); 
		query.append("AND   INV_NO   = @[inv_no]                                                   	  		    " ).append("\n"); 
		query.append("AND   NVL(DELT_FLG,'N')   <> 'Y'" ).append("\n"); 

	}
}