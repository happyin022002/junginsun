/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DOFChgTrfmanageDBDAOsearchEffDTRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.19
*@LastModifier : 
*@LastVersion : 1.0
* 2009.10.19 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.eas.transportmanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DOFChgTrfmanageDBDAOsearchEffDTRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 선택된 Customer 정보로 Effect date List Search
	  * </pre>
	  */
	public DOFChgTrfmanageDBDAOsearchEffDTRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_info",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("strcnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.eas.transportmanage.integration ").append("\n"); 
		query.append("FileName : DOFChgTrfmanageDBDAOsearchEffDTRSQL").append("\n"); 
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
		query.append("select (100000 +(rownum * 10) ) as sortKey," ).append("\n"); 
		query.append("to_char(a.eff_dt, 'YYYYMMDD') as code," ).append("\n"); 
		query.append("to_char(a.eff_dt, 'YYYY/MM/DD') as name" ).append("\n"); 
		query.append("from" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("select distinct  eff_dt" ).append("\n"); 
		query.append("from trs_drff_chg_trf" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if( ${strcnt_cd} != '')" ).append("\n"); 
		query.append("where fm_loc_cd like @[strcnt_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if( ${cust_info} != '')" ).append("\n"); 
		query.append("where cnt_cd = substr(@[cust_info],0,2)" ).append("\n"); 
		query.append("and cust_seq = substr(@[cust_info],3)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") a" ).append("\n"); 
		query.append("order by code" ).append("\n"); 

	}
}