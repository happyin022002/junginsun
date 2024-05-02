/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : RFATransportationAdditionalChargeProposalDBDAOFicGlineRtLocalAmtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.10
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.10 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFATransportationAdditionalChargeProposalDBDAOFicGlineRtLocalAmtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Guideline Rate Amount를 Local Currency로 조회한다.
	  * * history
	  *  2015.11.10 SELCMU/김현경 [CHM-201538112] Tariff 변경시 현 RFA 상 Arbitiary 탭 미반영 로직수정
	  * </pre>
	  */
	public RFATransportationAdditionalChargeProposalDBDAOFicGlineRtLocalAmtRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fic_gline_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.integration").append("\n"); 
		query.append("FileName : RFATransportationAdditionalChargeProposalDBDAOFicGlineRtLocalAmtRSQL").append("\n"); 
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
		query.append("SELECT USD_LOCL_XCH_RT * NVL(@[fic_gline_rt_amt], 0)" ).append("\n"); 
		query.append("FROM GL_MON_XCH_RT" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND ACCT_XCH_RT_YRMON = (SELECT MAX(ACCT_XCH_RT_YRMON) FROM GL_MON_XCH_RT" ).append("\n"); 
		query.append("                         WHERE 1=1" ).append("\n"); 
		query.append("                         AND ACCT_XCH_RT_LVL='1'" ).append("\n"); 
		query.append("                         AND CURR_CD=@[curr_cd]" ).append("\n"); 
		query.append("					#if (${eff_dt} != '') " ).append("\n"); 
		query.append("						 AND ACCT_XCH_RT_YRMON <= SUBSTR(@[eff_dt], 1, 6)" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("						)" ).append("\n"); 
		query.append("AND ACCT_XCH_RT_LVL='1'" ).append("\n"); 
		query.append("AND CURR_CD=@[curr_cd]" ).append("\n"); 

	}
}