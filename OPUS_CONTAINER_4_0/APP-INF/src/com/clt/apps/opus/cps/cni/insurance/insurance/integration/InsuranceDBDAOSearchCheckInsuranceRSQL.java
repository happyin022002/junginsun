/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InsuranceDBDAOSearchCheckInsuranceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.02
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.12.02 윤세영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.cni.insurance.insurance.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yoon, Seyeong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InsuranceDBDAOSearchCheckInsuranceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Insurance 보험 등록 되어있는지 검사한다
	  * </pre>
	  */
	public InsuranceDBDAOSearchCheckInsuranceRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("insur_plcy_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("insur_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.cps.cni.insurance.insurance.integration ").append("\n"); 
		query.append("FileName : InsuranceDBDAOSearchCheckInsuranceRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("INSUR_TP_CD" ).append("\n"); 
		query.append("FROM CNI_INSUR_CTRT" ).append("\n"); 
		query.append("WHERE	INSUR_TP_CD = @[insur_tp_cd]" ).append("\n"); 
		query.append("AND	INSUR_PLCY_YR = @[insur_plcy_yr]" ).append("\n"); 

	}
}