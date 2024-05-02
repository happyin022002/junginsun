/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GeneralCodeCheckMgtDBDAOsearchPayableINVInquiryCalCurrRateDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.04
*@LastModifier : 함형석
*@LastVersion : 1.0
* 2010.03.04 함형석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodecheckmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author HamHyungSeok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralCodeCheckMgtDBDAOsearchPayableINVInquiryCalCurrRateDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GeneralCodeCheckMgtDBDAOsearchPayableINVInquiryCalCurrRateDataRSQL
	  * </pre>
	  */
	public GeneralCodeCheckMgtDBDAOsearchPayableINVInquiryCalCurrRateDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tmp_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodecheckmgt.integration").append("\n"); 
		query.append("FileName : GeneralCodeCheckMgtDBDAOsearchPayableINVInquiryCalCurrRateDataRSQL").append("\n"); 
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
		query.append("SELECT A.TMP_SEQ, " ).append("\n"); 
		query.append("       A.TMP_DTL_SEQ," ).append("\n"); 
		query.append("       A.INP_MSG1," ).append("\n"); 
		query.append("       A.INP_MSG2," ).append("\n"); 
		query.append("       A.INP_MSG3, " ).append("\n"); 
		query.append("       MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(SYSDATE, 'YYYYMM'), A.INP_MSG2, A.INP_MSG3, A.INP_MSG1) INP_MSG4," ).append("\n"); 
		query.append("	   (SELECT DP_PRCS_KNT FROM MDM_CURRENCY WHERE CURR_CD = A.INP_MSG3) INP_MSG5" ).append("\n"); 
		query.append("FROM MNR_DAT_VRFY A" ).append("\n"); 
		query.append("WHERE A.TMP_SEQ = @[tmp_seq]" ).append("\n"); 

	}
}