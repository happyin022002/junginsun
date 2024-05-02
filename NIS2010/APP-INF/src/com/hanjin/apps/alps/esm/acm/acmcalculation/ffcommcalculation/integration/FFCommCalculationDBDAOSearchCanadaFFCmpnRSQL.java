/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : FFCommCalculationDBDAOSearchCanadaFFCmpnRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.19
*@LastModifier : 이윤정
*@LastVersion : 1.0
* 2013.02.19 이윤정
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmcalculation.ffcommcalculation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE YOUNJUNG
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FFCommCalculationDBDAOSearchCanadaFFCmpnRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Canada Brokerage로 지급불가되어야 할 case 체크
	  * </pre>
	  */
	public FFCommCalculationDBDAOSearchCanadaFFCmpnRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmcalculation.ffcommcalculation.integration").append("\n"); 
		query.append("FileName : FFCommCalculationDBDAOSearchCanadaFFCmpnRSQL").append("\n"); 
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
		query.append("SELECT COUNT(1)as CANADA_CHECK" ).append("\n"); 
		query.append("FROM BKG_BOOKING B, BKG_CUSTOMER CF, BKG_CUSTOMER CS" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND B.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND SUBSTR(B.POR_CD,1,2) = 'US'" ).append("\n"); 
		query.append("AND SUBSTR(B.POL_CD,1,2) = 'US'" ).append("\n"); 
		query.append("AND CF.BKG_NO            = B.BKG_NO " ).append("\n"); 
		query.append("AND CF.BKG_CUST_TP_CD    = 'F' " ).append("\n"); 
		query.append("AND CF.CUST_CNT_CD       = 'CA' " ).append("\n"); 
		query.append("AND CS.BKG_NO            = B.BKG_NO " ).append("\n"); 
		query.append("AND CS.BKG_CUST_TP_CD    = 'S' " ).append("\n"); 
		query.append("AND CS.CUST_CNT_CD       = 'CA' " ).append("\n"); 
		query.append("AND NVL(CF.CUST_SEQ,-1)  = NVL(CS.CUST_SEQ ,-2) --> 둘다 Null 일경우 지급 불가하도록 nvl 처리" ).append("\n"); 

	}
}