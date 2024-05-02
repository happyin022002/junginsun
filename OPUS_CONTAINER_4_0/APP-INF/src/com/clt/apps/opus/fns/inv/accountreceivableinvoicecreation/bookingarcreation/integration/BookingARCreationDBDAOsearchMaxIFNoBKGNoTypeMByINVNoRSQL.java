/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BookingARCreationDBDAOsearchMaxIFNoBKGNoTypeMByINVNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.22
*@LastModifier : 정휘택
*@LastVersion : 1.0
* 2010.01.22 정휘택
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Hwi Taek
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingARCreationDBDAOsearchMaxIFNoBKGNoTypeMByINVNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BookingARCreationDBDAOsearchMaxIFNoBKGNoTypeMByINVNoRSQL
	  * </pre>
	  */
	public BookingARCreationDBDAOsearchMaxIFNoBKGNoTypeMByINVNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration").append("\n"); 
		query.append("FileName : BookingARCreationDBDAOsearchMaxIFNoBKGNoTypeMByINVNoRSQL").append("\n"); 
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
		query.append("SELECT MAX(AR_IF_NO) AR_IF_NO" ).append("\n"); 
		query.append(", NVL(BKG_NO, '') BKG_NO" ).append("\n"); 
		query.append(", IO_BND_CD" ).append("\n"); 
		query.append(", INV_REF_NO" ).append("\n"); 
		query.append("FROM INV_AR_MN" ).append("\n"); 
		query.append("WHERE AR_IF_NO IN (SELECT AR_IF_NO" ).append("\n"); 
		query.append("FROM INV_AR_ISS_DTL" ).append("\n"); 
		query.append("WHERE INV_NO = @[inv_no])" ).append("\n"); 
		query.append("AND REV_TP_CD = 'M'" ).append("\n"); 
		query.append("GROUP BY NVL(BKG_NO, '')" ).append("\n"); 
		query.append(", IO_BND_CD" ).append("\n"); 
		query.append(", INV_REF_NO" ).append("\n"); 

	}
}