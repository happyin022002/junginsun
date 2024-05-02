/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChargeAmountDiscountMgtDBDAOSearchCalcTypeCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.04
*@LastModifier : 
*@LastVersion : 1.0
* 2009.11.04 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtclosing.chargeamountdiscountmgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeAmountDiscountMgtDBDAOSearchCalcTypeCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Location Code 와 I/O Bound Code 에 해당되는 Calculation Type Code 를 조회하는 쿼리
	  * </pre>
	  */
	public ChargeAmountDiscountMgtDBDAOSearchCalcTypeCodeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtclosing.chargeamountdiscountmgt.integration ").append("\n"); 
		query.append("FileName : ChargeAmountDiscountMgtDBDAOSearchCalcTypeCodeRSQL").append("\n"); 
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
		query.append("SELECT  DMDT_CALC_TP_CD" ).append("\n"); 
		query.append("FROM    DMT_CALC_TP" ).append("\n"); 
		query.append("WHERE   LOC_CD = @[loc_cd]" ).append("\n"); 
		query.append("#if(${cnt_cd} == 'CA' || ${cnt_cd} == 'US')" ).append("\n"); 
		query.append("OR (" ).append("\n"); 
		query.append("STE_CD =" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT	STE_CD" ).append("\n"); 
		query.append("FROM	MDM_LOCATION" ).append("\n"); 
		query.append("WHERE	LOC_CD = @[loc_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND LOC_CD = ' '" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("OR (" ).append("\n"); 
		query.append("RGN_CD =" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT	RGN_CD" ).append("\n"); 
		query.append("FROM	MDM_LOCATION" ).append("\n"); 
		query.append("WHERE	LOC_CD = @[loc_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND LOC_CD = ' '" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("OR (" ).append("\n"); 
		query.append("CNT_CD = @[cnt_cd]" ).append("\n"); 
		query.append("#if(${cnt_cd} == 'CA' || ${cnt_cd} == 'US')" ).append("\n"); 
		query.append("AND STE_CD = ' '" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND RGN_CD = ' '" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND LOC_CD = ' '" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY LOC_CD DESC, RGN_CD DESC, CNT_CD DESC" ).append("\n"); 

	}
}