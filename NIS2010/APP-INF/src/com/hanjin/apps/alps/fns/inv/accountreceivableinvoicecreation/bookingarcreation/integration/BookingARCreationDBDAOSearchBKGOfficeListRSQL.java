/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BookingARCreationDBDAOSearchBKGOfficeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.13
*@LastModifier : 
*@LastVersion : 1.0
* 2011.10.13 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingARCreationDBDAOSearchBKGOfficeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BookingARCreationDBDAOSearchBKGOfficeListRSQL
	  * </pre>
	  */
	public BookingARCreationDBDAOSearchBKGOfficeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration").append("\n"); 
		query.append("FileName : BookingARCreationDBDAOSearchBKGOfficeListRSQL").append("\n"); 
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
		query.append("SELECT BKG.IO_BND_CD IO_BND_CD," ).append("\n"); 
		query.append("BKG.CUST_CNT_CD CUST_CNT_CD," ).append("\n"); 
		query.append("BKG.CUST_SEQ CUST_SEQ," ).append("\n"); 
		query.append("BKG.N3RD_FLG N3RD_FLG," ).append("\n"); 
		query.append("BKG.OFC_CD OFC_CD," ).append("\n"); 
		query.append("BKG.CHG_SEQ CHG_SEQ," ).append("\n"); 
		query.append("ORG.AR_OFC_CD M_AR_OFC_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(SELECT IO_BND_CD," ).append("\n"); 
		query.append("CUST_CNT_CD," ).append("\n"); 
		query.append("CUST_SEQ," ).append("\n"); 
		query.append("N3RD_FLG," ).append("\n"); 
		query.append("OFC_CD," ).append("\n"); 
		query.append("CHG_SEQ" ).append("\n"); 
		query.append("FROM INV_BKG_IF_CHG" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND BKG_SEQ = @[bkg_seq])BKG, MDM_ORGANIZATION ORG" ).append("\n"); 
		query.append("WHERE BKG.OFC_CD = ORG.OFC_CD" ).append("\n"); 

	}
}