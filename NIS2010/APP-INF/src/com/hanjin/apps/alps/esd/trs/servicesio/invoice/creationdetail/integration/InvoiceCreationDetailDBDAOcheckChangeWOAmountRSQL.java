/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : InvoiceCreationDetailDBDAOcheckChangeWOAmountRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.19
*@LastModifier : 윤권영
*@LastVersion : 1.0
* 2015.03.19 윤권영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.invoice.creationdetail.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yun Kwon-Young
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceCreationDetailDBDAOcheckChangeWOAmountRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Submit to HJS 시 W/O Amount 변경여부 체크 
	  * </pre>
	  */
	public InvoiceCreationDetailDBDAOcheckChangeWOAmountRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("NEGO_AMT",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("SO_NO_OFC_CTY",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ETC_ADD_AMT",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("FUEL_SCG_AMT",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("SO_NO_SEQ",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("CURR_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("TOLL_FEE_AMT",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("VNDR_SEQ",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("SCG_VAT_AMT",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("BZC_AMT",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.servicesio.invoice.creationdetail.integration").append("\n"); 
		query.append("FileName : InvoiceCreationDetailDBDAOcheckChangeWOAmountRSQL").append("\n"); 
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
		query.append("SELECT   TRSP_WO_OFC_CTY_CD||TRSP_WO_SEQ				  				 AS WoNo" ).append("\n"); 
		query.append("		,EQ_NO															 AS EqNo" ).append("\n"); 
		query.append("		,DECODE(NVL(A.CURR_CD,0) 	   ,NVL(@[CURR_CD]     ,0) ,'N','Y') AS CurrChgFlg" ).append("\n"); 
		query.append("        ,DECODE(NVL(A.BZC_AMT,0)       ,NVL(TO_NUMBER(@[BZC_AMT])     ,0) ,'N','Y') AS BzcChgFlg" ).append("\n"); 
		query.append("        ,DECODE(NVL(A.ETC_ADD_AMT,0)   ,NVL(TO_NUMBER(@[ETC_ADD_AMT]) ,0) ,'N','Y') AS EtcChgFlg" ).append("\n"); 
		query.append("        ,DECODE(NVL(A.FUEL_SCG_AMT,0)  ,NVL(TO_NUMBER(@[FUEL_SCG_AMT]),0) ,'N','Y') AS FuelChgFlg" ).append("\n"); 
		query.append("		,DECODE(NVL(A.SCG_VAT_AMT,0)   ,NVL(TO_NUMBER(@[SCG_VAT_AMT]) ,0) ,'N','Y') AS VatChgFlg " ).append("\n"); 
		query.append("        ,DECODE(NVL(A.NEGO_AMT,0)      ,NVL(TO_NUMBER(@[NEGO_AMT])    ,0) ,'N','Y') AS NegoChgFlg" ).append("\n"); 
		query.append("		,DECODE(NVL(A.TOLL_FEE_AMT,0)  ,NVL(TO_NUMBER(@[TOLL_FEE_AMT])    ,0) ,'N','Y') AS TollChgFlg" ).append("\n"); 
		query.append("FROM (SELECT   TRSP_WO_OFC_CTY_CD" ).append("\n"); 
		query.append("			  ,TRSP_WO_SEQ" ).append("\n"); 
		query.append("			  ,EQ_NO" ).append("\n"); 
		query.append("			  ,CURR_CD" ).append("\n"); 
		query.append("              ,BZC_AMT" ).append("\n"); 
		query.append("              ,ETC_ADD_AMT" ).append("\n"); 
		query.append("              ,FUEL_SCG_AMT" ).append("\n"); 
		query.append("			  ,SCG_VAT_AMT" ).append("\n"); 
		query.append("              ,NEGO_AMT" ).append("\n"); 
		query.append("			  ,TOLL_FEE_AMT" ).append("\n"); 
		query.append("      FROM TRS_TRSP_SVC_ORD" ).append("\n"); 
		query.append("      WHERE 1=1" ).append("\n"); 
		query.append("      AND TRSP_SO_OFC_CTY_CD = @[SO_NO_OFC_CTY]" ).append("\n"); 
		query.append("      AND TRSP_SO_SEQ = @[SO_NO_SEQ]" ).append("\n"); 
		query.append("      AND VNDR_SEQ = @[VNDR_SEQ]" ).append("\n"); 
		query.append("      AND DELT_FLG = 'N'" ).append("\n"); 
		query.append(") A" ).append("\n"); 

	}
}