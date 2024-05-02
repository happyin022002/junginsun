/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : TransferOrderIssueDBDAOSearchEurTroCntrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.02.28
*@LastModifier : 조정민
*@LastVersion : 1.0
* 2014.02.28 조정민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author JEONGMIN CHO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TransferOrderIssueDBDAOSearchEurTroCntrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TransferOrderIssueDBDAOSearchEurTroCntrRSQL
	  * </pre>
	  */
	public TransferOrderIssueDBDAOSearchEurTroCntrRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration").append("\n"); 
		query.append("FileName : TransferOrderIssueDBDAOSearchEurTroCntrRSQL").append("\n"); 
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
		query.append("'CNTRLIST' as combo_cd," ).append("\n"); 
		query.append("cntr.cntr_no as val," ).append("\n"); 
		query.append("cntr.cntr_no as name" ).append("\n"); 
		query.append("FROM bkg_eur_tro   tro," ).append("\n"); 
		query.append("bkg_container cntr" ).append("\n"); 
		query.append("WHERE cntr.bkg_no  = tro.bkg_no(+)" ).append("\n"); 
		query.append("AND cntr.cntr_no = tro.cntr_no(+)" ).append("\n"); 
		query.append("AND cntr.bkg_no  = @[bkg_no]" ).append("\n"); 
		query.append("AND 'N'			= TRO.CXL_FLG(+)" ).append("\n"); 

	}
}