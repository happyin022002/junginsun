/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : JOCandidateConfirmDBDAOSearchCheckTrdPartyRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.29
*@LastModifier : 변종건
*@LastVersion : 1.0
* 2010.06.29 변종건
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.jocasemanage.jocandidateconfirm.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong-Geon Byeon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JOCandidateConfirmDBDAOSearchCheckTrdPartyRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * JO Candidate Confirm의 Third Party Value Validation Check
	  * </pre>
	  */
	public JOCandidateConfirmDBDAOSearchCheckTrdPartyRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_party_val",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tpb.jocasemanage.jocandidateconfirm.integration").append("\n"); 
		query.append("FileName : JOCandidateConfirmDBDAOSearchCheckTrdPartyRSQL").append("\n"); 
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
		query.append("#if (${vndr_cust_div_cd} == 'V')" ).append("\n"); 
		query.append("-- Vendor" ).append("\n"); 
		query.append("SELECT DECODE(COUNT(VNDR_SEQ),0,'N','Y') VALIDYN" ).append("\n"); 
		query.append("FROM MDM_VENDOR" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND VNDR_SEQ = TO_NUMBER(@[trd_party_val])" ).append("\n"); 
		query.append("AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND RFND_PSDO_CUST_CD IS NOT NULL" ).append("\n"); 
		query.append("#elseif (${vndr_cust_div_cd} == 'C')" ).append("\n"); 
		query.append("-- Customer" ).append("\n"); 
		query.append("SELECT DECODE(COUNT(CUST_CNT_CD||LPAD(CUST_SEQ,6,'0')),0,'N','Y') VALIDYN" ).append("\n"); 
		query.append("FROM MDM_CUSTOMER" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND (NMD_CUST_FLG IS NULL OR NMD_CUST_FLG != 'Y')" ).append("\n"); 
		query.append("AND CUST_CNT_CD = SUBSTRB(TRIM(@[trd_party_val]),1,2)" ).append("\n"); 
		query.append("AND CUST_SEQ = TO_NUMBER(SUBSTRB(TRIM(@[trd_party_val]),3))" ).append("\n"); 
		query.append("AND CNTR_DIV_FLG = 'Y'" ).append("\n"); 
		query.append("AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("#elseif (${vndr_cust_div_cd} == 'S')" ).append("\n"); 
		query.append("-- Staff" ).append("\n"); 
		query.append("SELECT DECODE(COUNT(M.OFC_CD),0,'N','Y') VALIDYN" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION M," ).append("\n"); 
		query.append("TPB_HNDL_OFC H" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND M.OFC_CD = @[trd_party_val]" ).append("\n"); 
		query.append("AND M.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND H.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND M.OFC_CD = H.OFC_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("-- ELSE" ).append("\n"); 
		query.append("SELECT 'N' VALIDYN" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}