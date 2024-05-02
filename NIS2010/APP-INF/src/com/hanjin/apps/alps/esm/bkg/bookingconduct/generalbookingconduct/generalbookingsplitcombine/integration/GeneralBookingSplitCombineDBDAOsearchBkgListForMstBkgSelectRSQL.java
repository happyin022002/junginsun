/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GeneralBookingSplitCombineDBDAOsearchBkgListForMstBkgSelectRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.16
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2010.04.16 류대영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Ryu Daeyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingSplitCombineDBDAOsearchBkgListForMstBkgSelectRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchBkgListForMstBkgSelect
	  * </pre>
	  */
	public GeneralBookingSplitCombineDBDAOsearchBkgListForMstBkgSelectRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.integration").append("\n"); 
		query.append("FileName : GeneralBookingSplitCombineDBDAOsearchBkgListForMstBkgSelectRSQL").append("\n"); 
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
		query.append("SELECT BKG_NO" ).append("\n"); 
		query.append(", BL_NO" ).append("\n"); 
		query.append(", BKG_STS_CD" ).append("\n"); 
		query.append(", TWN_SO_NO" ).append("\n"); 
		query.append(", REPLACE((SELECT CUST_NM" ).append("\n"); 
		query.append("FROM BKG_CUSTOMER CUST" ).append("\n"); 
		query.append("WHERE CUST.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("AND CUST.BKG_CUST_TP_CD = 'S'), CHR(13)||CHR(10), ' ') SHIPPER" ).append("\n"); 
		query.append(", POR_CD" ).append("\n"); 
		query.append(", SUBSTR(POR_NOD_CD, 6, 2) POR_NOD_CD" ).append("\n"); 
		query.append(", DEL_CD" ).append("\n"); 
		query.append(", SUBSTR(DEL_NOD_CD, 6, 2) DEL_NOD_CD" ).append("\n"); 
		query.append(", BKG_JOIN_FNC( CURSOR(SELECT CNTR_TPSZ_CD||'-'||LTRIM(TO_CHAR(COUNT(1),'990.99'))" ).append("\n"); 
		query.append("FROM BKG_CONTAINER" ).append("\n"); 
		query.append("WHERE BKG_NO = bk.BKG_NO" ).append("\n"); 
		query.append("GROUP BY CNTR_TPSZ_CD)) CNTR_VOL" ).append("\n"); 
		query.append("FROM BKG_BOOKING BK" ).append("\n"); 
		query.append("WHERE BK.BKG_NO IN (" ).append("\n"); 
		query.append("#foreach( ${bkg_no} in ${bkg_no_list})" ).append("\n"); 
		query.append("#if($velocityCount < $bkg_no_list.size()) '$bkg_no', #else '$bkg_no' #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND BK.BKG_STS_CD <> 'X'" ).append("\n"); 

	}
}