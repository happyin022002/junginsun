/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : AgreementRegistrationDBDAOcalculationInterrstDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.18
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2011.03.18 박명신
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleaseagreementregistration.agreementregistration.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Myoung Sin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AgreementRegistrationDBDAOcalculationInterrstDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Interest calculation 조회
	  * </pre>
	  */
	public AgreementRegistrationDBDAOcalculationInterrstDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("i_rate",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("principal",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n_payment",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("i_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("payment_term",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.lse.containerleaseagreementregistration.agreementregistration.integration").append("\n"); 
		query.append("FileName : AgreementRegistrationDBDAOcalculationInterrstDataRSQL").append("\n"); 
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
		query.append("WITH  LV_PARA AS" ).append("\n"); 
		query.append("(SELECT REPLACE (@[i_rate], ',', '') RATE," ).append("\n"); 
		query.append("REPLACE (@[principal], ',', '') PV," ).append("\n"); 
		query.append("REPLACE (@[n_payment], ',', '') NPER," ).append("\n"); 
		query.append("DECODE(@[payment_term],'4','3','1') TERM," ).append("\n"); 
		query.append("NVL(@[i_type],0) TYPE" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", LV_FIRST_DATA AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT RATE," ).append("\n"); 
		query.append("PV," ).append("\n"); 
		query.append("NPER," ).append("\n"); 
		query.append("TERM," ).append("\n"); 
		query.append("LSE_PMT_FNC(RATE,TERM,NPER,PV,TYPE) INSTALLMENT" ).append("\n"); 
		query.append("FROM LV_PARA" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT SEQ," ).append("\n"); 
		query.append("LSE_RTN_AMT_FNC(1,RATE,TERM,PV,INSTALLMENT,SEQ,@[i_type]) BAL," ).append("\n"); 
		query.append("LSE_RTN_AMT_FNC(2,RATE,TERM,PV,INSTALLMENT,SEQ,@[i_type]) PRINCIPAL," ).append("\n"); 
		query.append("LSE_RTN_AMT_FNC(3,RATE,TERM,PV,INSTALLMENT,SEQ,@[i_type]) INTEREST ," ).append("\n"); 
		query.append("INSTALLMENT" ).append("\n"); 
		query.append("FROM LV_FIRST_DATA A , (SELECT LEVEL  SEQ FROM LV_PARA CONNECT BY LEVEL <= NPER)" ).append("\n"); 

	}
}