/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BookingARCreationDBDAOSearchEurPpdOfcRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.07
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2010.05.07 최도순
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Do Soon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingARCreationDBDAOSearchEurPpdOfcRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public BookingARCreationDBDAOSearchEurPpdOfcRSQL(){
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
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration").append("\n"); 
		query.append("FileName : BookingARCreationDBDAOSearchEurPpdOfcRSQL").append("\n"); 
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
		query.append("SELECT PPD_RCV_OFC_CD OFC_CD" ).append("\n"); 
		query.append("	  ,PPD_PAYR_CNT_CD CUST_CNT_CD" ).append("\n"); 
		query.append("      ,PPD_PAYR_CUST_SEQ CUST_SEQ" ).append("\n"); 
		query.append("  FROM BKG_RATE A" ).append("\n"); 
		query.append("     , MDM_ORGANIZATION B" ).append("\n"); 
		query.append("     , COM_SYS_AREA_GRP_ID C" ).append("\n"); 
		query.append(" WHERE A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND A.PPD_RCV_OFC_CD = B.OFC_CD" ).append("\n"); 
		query.append("   AND SUBSTR(B.LOC_CD, 1, 2) = C.CNT_CD" ).append("\n"); 
		query.append("   AND C.CO_IND_CD = 'H'" ).append("\n"); 
		query.append("   AND C.SYS_AREA_GRP_ID = 'EUR'" ).append("\n"); 

	}
}