/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : DefaultCurrDBDAOVerifyCountryCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.07
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.07 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.aoc.common.defaultcurr.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DefaultCurrDBDAOVerifyCountryCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VerifyCountryCode
	  * CHM-201433025 ZA Code 신규 등록 SINRS 기존 서남아시아에 AFRICA를 추가함. 
	  * A.CONTI_CD = 'A' -> A.CONTI_CD IN ('A', 'F')
	  * </pre>
	  */
	public DefaultCurrDBDAOVerifyCountryCodeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.aoc.common.defaultcurr.integration").append("\n"); 
		query.append("FileName : DefaultCurrDBDAOVerifyCountryCodeRSQL").append("\n"); 
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
		query.append("#if (${rhq_cd} == 'SHARC')" ).append("\n"); 
		query.append("/* SHARC */" ).append("\n"); 
		query.append("        select count(0) knt" ).append("\n"); 
		query.append("        from   MDM_CONTINENT A, MDM_SUBCONTINENT B, MDM_COUNTRY C" ).append("\n"); 
		query.append("        where  A.CONTI_CD = 'A'" ).append("\n"); 
		query.append("        and    A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("        and    A.CONTI_CD = B.CONTI_CD" ).append("\n"); 
		query.append("        and    B.SCONTI_CD = 'AF'" ).append("\n"); 
		query.append("        and    B.DELT_FLG = 'N'" ).append("\n"); 
		query.append("        and    B.SCONTI_CD = C.SCONTI_CD" ).append("\n"); 
		query.append("        and    C.DELT_FLG = 'N'" ).append("\n"); 
		query.append("		and    C.CNT_CD = @[cnt_cd]" ).append("\n"); 
		query.append("#elseif (${rhq_cd} == 'SINRS')" ).append("\n"); 
		query.append("        /* SINRS */" ).append("\n"); 
		query.append("        select count(0) knt" ).append("\n"); 
		query.append("        from   MDM_CONTINENT A, MDM_SUBCONTINENT B, MDM_COUNTRY C" ).append("\n"); 
		query.append("        where  A.CONTI_CD IN ('A', 'F')" ).append("\n"); 
		query.append("        and    A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("        and    A.CONTI_CD = B.CONTI_CD" ).append("\n"); 
		query.append("        and    B.SCONTI_CD <> 'AF'" ).append("\n"); 
		query.append("        and    B.DELT_FLG = 'N'" ).append("\n"); 
		query.append("        and    B.SCONTI_CD = C.SCONTI_CD" ).append("\n"); 
		query.append("        and    C.DELT_FLG = 'N'" ).append("\n"); 
		query.append("		and    C.CNT_CD = @[cnt_cd]" ).append("\n"); 
		query.append("#elseif (${rhq_cd} == 'NYCRA')" ).append("\n"); 
		query.append("        /* NYCRA */" ).append("\n"); 
		query.append("        select count(0) knt" ).append("\n"); 
		query.append("        from   MDM_CONTINENT A, MDM_SUBCONTINENT B, MDM_COUNTRY C" ).append("\n"); 
		query.append("        where  A.CONTI_CD = 'M'" ).append("\n"); 
		query.append("        and    A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("        and    A.CONTI_CD = B.CONTI_CD" ).append("\n"); 
		query.append("        and    B.DELT_FLG = 'N'" ).append("\n"); 
		query.append("        and    B.SCONTI_CD = C.SCONTI_CD" ).append("\n"); 
		query.append("        and    C.DELT_FLG = 'N'" ).append("\n"); 
		query.append("		and    C.CNT_CD = @[cnt_cd]" ).append("\n"); 
		query.append("#elseif (${rhq_cd} == 'HAMRU')" ).append("\n"); 
		query.append("        /* HAMRU */" ).append("\n"); 
		query.append("        select count(0) knt" ).append("\n"); 
		query.append("        from   MDM_CONTINENT A, MDM_SUBCONTINENT B, MDM_COUNTRY C" ).append("\n"); 
		query.append("        where  A.CONTI_CD IN ('E', 'F')" ).append("\n"); 
		query.append("        and    A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("        and    A.CONTI_CD = B.CONTI_CD" ).append("\n"); 
		query.append("        and    B.DELT_FLG = 'N'" ).append("\n"); 
		query.append("        and    B.SCONTI_CD = C.SCONTI_CD" ).append("\n"); 
		query.append("        and    C.DELT_FLG = 'N'" ).append("\n"); 
		query.append("		and    C.CNT_CD = @[cnt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}