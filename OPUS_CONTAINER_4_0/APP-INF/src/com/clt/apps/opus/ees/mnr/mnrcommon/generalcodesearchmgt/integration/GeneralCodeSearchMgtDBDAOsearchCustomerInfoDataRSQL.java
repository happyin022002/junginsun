/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : GeneralCodeSearchMgtDBDAOsearchCustomerInfoDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.21
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.02.21 김상수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.integration;

import java.util.HashMap;

import org.apache.log4j.Logger;

import com.clt.framework.core.layer.integration.DAO;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM, Sang Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralCodeSearchMgtDBDAOsearchCustomerInfoDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCustomerInfoData
	  * </pre>
	  */
	public GeneralCodeSearchMgtDBDAOsearchCustomerInfoDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.integration").append("\n"); 
		query.append("FileName : GeneralCodeSearchMgtDBDAOsearchCustomerInfoDataRSQL").append("\n"); 
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
		query.append("SELECT MNR_COMMON_PKG.MNR_CONV_PARTNER_CD_FNC(A.CUST_SEQ, A.CUST_CNT_CD) AS CUST_CD," ).append("\n"); 
		query.append("       A.CUST_CNT_CD," ).append("\n"); 
		query.append("       MNR_COMMON_PKG.MNR_CONV_PARTNER_CD_FNC(A.CUST_SEQ) AS CUST_SEQ," ).append("\n"); 
		query.append("       A.CUST_LGL_ENG_NM AS CUST_NM," ).append("\n"); 
		query.append("       A.OFC_CD," ).append("\n"); 
		query.append("       DECODE(A.SLS_DELT_EFF_DT, NULL, 'Y', 'N') AS SLS_DELT_EFF_DT," ).append("\n"); 
		query.append("       B.BZET_ADDR," ).append("\n"); 
		query.append("       B.STE_CD," ).append("\n"); 
		query.append("       B.ZIP_CD," ).append("\n"); 
		query.append("       A.LOC_CD," ).append("\n"); 
		query.append("       DECODE(A.CNTR_CUST_TP_CD,'B','BCO','Non-BCO') AS RVIS_CNTR_CUST_TP_CD," ).append("\n"); 
		query.append("       A.CUST_GRP_ID" ).append("\n"); 
		query.append("  FROM MDM_CUSTOMER A," ).append("\n"); 
		query.append("       MDM_CUST_ADDR B" ).append("\n"); 
		query.append(" WHERE A.CUST_CNT_CD = B.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("   AND A.CUST_SEQ = B.CUST_SEQ(+)" ).append("\n"); 
		query.append("   AND B.PRMRY_CHK_FLG(+) = 'Y'" ).append("\n"); 
		query.append("   AND A.CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("   AND A.CUST_SEQ = TO_NUMBER(@[cust_seq])" ).append("\n"); 
		query.append("   AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("   AND ROWNUM = 1" ).append("\n"); 

	}
}