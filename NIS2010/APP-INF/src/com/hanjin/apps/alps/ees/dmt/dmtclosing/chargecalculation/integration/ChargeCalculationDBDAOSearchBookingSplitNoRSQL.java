/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ChargeCalculationDBDAOSearchBookingSplitNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.12.06
*@LastModifier : 임창빈
*@LastVersion : 1.0
* 2013.12.06 임창빈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lim Chang Bin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeCalculationDBDAOSearchBookingSplitNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Booking & Container 를 이용하여 Dem/Det Charge가 생성된 Booking No를 조회한다.
	  * Ex) SUB300333300~1이 소수점으로 Container Q'ty를 쪼개지만, DMT에서 Movement 중심으로 어느 한쪽 Booking으로 Charge를 생성한다.
	  * </pre>
	  */
	public ChargeCalculationDBDAOSearchBookingSplitNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration").append("\n"); 
		query.append("FileName : ChargeCalculationDBDAOSearchBookingSplitNoRSQL").append("\n"); 
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
		query.append("SELECT  T1.BKG_NO" ).append("\n"); 
		query.append("FROM    BKG_CONTAINER       T1," ).append("\n"); 
		query.append("        DMT_CHG_BKG_CNTR    T2" ).append("\n"); 
		query.append("WHERE   1=1" ).append("\n"); 
		query.append("AND     T1.BKG_NO   = T2.BKG_NO" ).append("\n"); 
		query.append("AND     T1.CNTR_NO  = T2.CNTR_NO" ).append("\n"); 
		query.append("AND     T1.CNTR_NO  = @[cntr_no]" ).append("\n"); 
		query.append("AND     T1.BKG_NO   LIKE SUBSTR(@[bkg_no], 1, 11) ||'%'" ).append("\n"); 
		query.append("AND     1           = NVL2(@[bkg_no], 1, 0)          -- BKG_NO가 null 일 경우 Query 결과가 없도록 한다. null인 경우 위 LIKE 조건에 문제가 생기 때문에... " ).append("\n"); 
		query.append("AND     ROWNUM      = 1" ).append("\n"); 

	}
}