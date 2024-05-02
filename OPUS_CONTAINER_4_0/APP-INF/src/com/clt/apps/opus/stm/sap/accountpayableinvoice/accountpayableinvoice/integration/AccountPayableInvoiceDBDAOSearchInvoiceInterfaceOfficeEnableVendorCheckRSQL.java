/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AccountPayableInvoiceDBDAOSearchInvoiceInterfaceOfficeEnableVendorCheckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.23
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.23 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountPayableInvoiceDBDAOSearchInvoiceInterfaceOfficeEnableVendorCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Office의 Region 정보와 Vendor의 Country 정보를 비교하여 11(본사) 지역의 경우 본사해당 Country을 갖는 Vendor만 사용하고 그외의 지역에는 본사외 해당 Country을 갖는 Vendor만을 사용하도록 체크
	  * </pre>
	  */
	public AccountPayableInvoiceDBDAOSearchInvoiceInterfaceOfficeEnableVendorCheckRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration").append("\n"); 
		query.append("FileName : AccountPayableInvoiceDBDAOSearchInvoiceInterfaceOfficeEnableVendorCheckRSQL").append("\n"); 
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
		query.append("SELECT  DECODE(MO.FINC_RGN_CD, '11', DECODE(ML.CNT_CD, NVL(OWNCT.LU_CD, 'N1'), 'Y', 'N'), DECODE(ML.CNT_CD, NVL(OWNCT.LU_CD, 'N1'), 'N', 'Y')) AS ENABLE_FLG" ).append("\n"); 
		query.append("FROM    MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("      , MDM_VENDOR MV" ).append("\n"); 
		query.append("      , MDM_LOCATION ML" ).append("\n"); 
		query.append("      , MDM_ORGANIZATION MO2" ).append("\n"); 
		query.append("      , MDM_COUNTRY MC" ).append("\n"); 
		query.append("      , (SELECT  SLD.LU_TP_CD, SLD.LU_CD, SLD.LU_DESC " ).append("\n"); 
		query.append("         FROM    SCO_LU_DTL SLD" ).append("\n"); 
		query.append("         WHERE   SLD.LU_TP_CD = 'NATIVE COUNTRY' AND SLD.ENBL_FLG = 'Y' AND NVL(SLD.LU_ST_DT, SYSDATE) >= SYSDATE AND ROWNUM = 1) OWNCT" ).append("\n"); 
		query.append("WHERE   MO.OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("AND     MV.VNDR_SEQ = @[vndr_cd]" ).append("\n"); 
		query.append("AND     MV.OFC_CD = MO2.OFC_CD" ).append("\n"); 
		query.append("AND     MO2.LOC_CD = ML.LOC_CD" ).append("\n"); 
		query.append("AND     ML.CNT_CD = MC.CNT_CD(+)" ).append("\n"); 
		query.append("AND     ML.CNT_CD = OWNCT.LU_CD(+)" ).append("\n"); 

	}
}