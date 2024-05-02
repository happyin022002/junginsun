/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : DMTCommonDBDAOSearchAttentionOfCustomerRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.16
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.16 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DMTCommonDBDAOSearchAttentionOfCustomerRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Customer 의 상세정보를 조회하는 쿼리
	  * </pre>
	  */
	public DMTCommonDBDAOSearchAttentionOfCustomerRSQL(){
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
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.integration").append("\n"); 
		query.append("FileName : DMTCommonDBDAOSearchAttentionOfCustomerRSQL").append("\n"); 
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
		query.append("#if(${cust_cnt_cd} == '00')" ).append("\n"); 
		query.append("SELECT  VNDR.VNDR_SEQ AS CUST_SEQ" ).append("\n"); 
		query.append(",   VNDR.VNDR_CNT_CD AS CUST_CNT_CD" ).append("\n"); 
		query.append(",   '1' AS CUST_CNTC_PNT_SEQ" ).append("\n"); 
		query.append(",   VNDR.CNTC_PSON_NM AS DMDT_PAYR_CNTC_PNT_NM" ).append("\n"); 
		query.append(",   VNDR_CNTC_PNT.PHN_NO AS PAYR_CNTC_PNT_PHN_NO" ).append("\n"); 
		query.append(",   VNDR_CNTC_PNT.FAX_NO AS PAYR_CNTC_PNT_FAX_NO" ).append("\n"); 
		query.append(",   VNDR_CNTC_PNT.VNDR_EML AS PAYR_CNTC_PNT_EML" ).append("\n"); 
		query.append("FROM    MDM_VENDOR VNDR" ).append("\n"); 
		query.append(",   MDM_VNDR_CNTC_PNT VNDR_CNTC_PNT" ).append("\n"); 
		query.append("WHERE   VNDR.VNDR_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("AND VNDR.VNDR_SEQ = VNDR_CNTC_PNT.VNDR_SEQ(+)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT  CUST_CNTC_PNT.CUST_SEQ" ).append("\n"); 
		query.append(",   CUST_CNTC_PNT.CUST_CNT_CD" ).append("\n"); 
		query.append(",   '1' AS CUST_CNTC_PNT_SEQ" ).append("\n"); 
		query.append(",   CR_CUST.CNTC_PSON_NM AS DMDT_PAYR_CNTC_PNT_NM" ).append("\n"); 
		query.append(",   DECODE(CR_CUST.IB_PHN_NO, NULL, CUST_CNTC_PNT.PHN_NO, CR_CUST.IB_PHN_NO) AS PAYR_CNTC_PNT_PHN_NO" ).append("\n"); 
		query.append(",   DECODE(CR_CUST.IB_FAX_NO, NULL, CUST_CNTC_PNT.FAX_NO, CR_CUST.IB_FAX_NO) AS PAYR_CNTC_PNT_FAX_NO" ).append("\n"); 
		query.append(",   DECODE(CR_CUST.IB_EML, NULL, CUST_CNTC_PNT.CUST_EML, CR_CUST.IB_EML) AS PAYR_CNTC_PNT_EML" ).append("\n"); 
		query.append("FROM    MDM_CUSTOMER CUST" ).append("\n"); 
		query.append(",   MDM_CUST_CNTC_PNT CUST_CNTC_PNT" ).append("\n"); 
		query.append(",   MDM_CR_CUST CR_CUST" ).append("\n"); 
		query.append("WHERE   CUST.CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("AND CUST.CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("AND CUST.CUST_CNT_CD = CUST_CNTC_PNT.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("AND CUST.CUST_SEQ = CUST_CNTC_PNT.CUST_SEQ(+)" ).append("\n"); 
		query.append("AND CUST.CUST_CNT_CD = CR_CUST.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("AND CUST.CUST_SEQ = CR_CUST.CUST_SEQ(+)" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}