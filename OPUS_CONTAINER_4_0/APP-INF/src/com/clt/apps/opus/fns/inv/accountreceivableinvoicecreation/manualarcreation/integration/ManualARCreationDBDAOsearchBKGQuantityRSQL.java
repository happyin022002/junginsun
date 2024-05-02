/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ManualARCreationDBDAOsearchBKGQuantityRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.23
*@LastModifier : 정휘택
*@LastVersion : 1.0
* 2009.06.23 정휘택
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.manualarcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Hwi Taek
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ManualARCreationDBDAOsearchBKGQuantityRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchBKGQuantity
	  * </pre>
	  */
	public ManualARCreationDBDAOsearchBKGQuantityRSQL(){
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
		query.append("SELECT CEIL(SUM(A.OP_CNTR_QTY)) BKG_TEU_QTY, CEIL(SUM(B.OP_CNTR_QTY)) BKG_FEU_QTY" ).append("\n"); 
		query.append("FROM    BKG_QUANTITY A, BKG_QUANTITY B" ).append("\n"); 
		query.append("WHERE   A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND     A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND     A.CNTR_TPSZ_CD LIKE '_2'" ).append("\n"); 
		query.append("AND     B.CNTR_TPSZ_CD NOT LIKE '_2'" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.manualarcreation.integration").append("\n"); 
		query.append("FileName : ManualARCreationDBDAOsearchBKGQuantityRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}