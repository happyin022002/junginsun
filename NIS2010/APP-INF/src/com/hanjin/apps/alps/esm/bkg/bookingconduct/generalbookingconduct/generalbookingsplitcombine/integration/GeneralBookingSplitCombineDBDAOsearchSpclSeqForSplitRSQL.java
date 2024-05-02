/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralBookingSplitCombineDBDAOsearchSpclSeqForSplitRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.02
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.09.02 최영희
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Yeoung Hee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingSplitCombineDBDAOsearchSpclSeqForSplitRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select
	  * </pre>
	  */
	public GeneralBookingSplitCombineDBDAOsearchSpclSeqForSplitRSQL(){
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
		query.append("FileName : GeneralBookingSplitCombineDBDAOsearchSpclSeqForSplitRSQL").append("\n"); 
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
		query.append("SELECT 'DG' CODE" ).append("\n"); 
		query.append(", CNTR_NO" ).append("\n"); 
		query.append(", DCGO_SEQ" ).append("\n"); 
		query.append("FROM BKG_DG_CGO" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("union" ).append("\n"); 
		query.append("SELECT 'RF' CODE" ).append("\n"); 
		query.append(", CNTR_NO" ).append("\n"); 
		query.append(", RC_SEQ DCGO_SEQ" ).append("\n"); 
		query.append("FROM BKG_RF_CGO" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("union" ).append("\n"); 
		query.append("SELECT 'AK' CODE" ).append("\n"); 
		query.append(", CNTR_NO" ).append("\n"); 
		query.append(", awk_cgo_SEQ DCGO_SEQ" ).append("\n"); 
		query.append("FROM BKG_awk_CGO" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}