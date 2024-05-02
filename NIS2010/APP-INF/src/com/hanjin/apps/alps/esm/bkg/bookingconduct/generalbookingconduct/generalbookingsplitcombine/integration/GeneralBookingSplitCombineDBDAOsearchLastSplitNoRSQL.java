/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralBookingSplitCombineDBDAOsearchLastSplitNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.11
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2009.11.11 류대영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dae-Young RYU
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingSplitCombineDBDAOsearchLastSplitNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 해당 bkg의 마지막 split no를 찾는다(다음 split no를 계산하기 위해)
	  * </pre>
	  */
	public GeneralBookingSplitCombineDBDAOsearchLastSplitNoRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.integration").append("\n"); 
		query.append("FileName : GeneralBookingSplitCombineDBDAOsearchLastSplitNoRSQL").append("\n"); 
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
		query.append("select custSplitNo" ).append("\n"); 
		query.append(", to_char(to_number(memoSplitNo) + 1) memoSplitNo" ).append("\n"); 
		query.append("from (SELECT nvl(SUBSTR(MAX(bkg_no), 11, 2), '00') custSplitNo" ).append("\n"); 
		query.append("FROM bkg_booking" ).append("\n"); 
		query.append("WHERE bkg_no                like substr(@[bkg_no], 1, 10)||'%'" ).append("\n"); 
		query.append("AND substr(bkg_no, 11, 2) >= '00'" ).append("\n"); 
		query.append("AND substr(bkg_no, 11, 2) < '91') cust_split," ).append("\n"); 
		query.append("(SELECT nvl(SUBSTR(MAX(bkg_no), 11, 2), '90') memoSplitNo" ).append("\n"); 
		query.append("FROM bkg_booking" ).append("\n"); 
		query.append("WHERE bkg_no                like substr(@[bkg_no], 1, 10)||'%'" ).append("\n"); 
		query.append("AND substr(bkg_no, 11, 2) >= '91') memo_split" ).append("\n"); 

	}
}