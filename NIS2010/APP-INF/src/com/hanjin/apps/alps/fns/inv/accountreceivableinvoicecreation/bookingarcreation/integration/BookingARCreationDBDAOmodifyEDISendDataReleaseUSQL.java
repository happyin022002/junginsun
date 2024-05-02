/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BookingARCreationDBDAOmodifyEDISendDataReleaseUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.12
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.12 
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

public class BookingARCreationDBDAOmodifyEDISendDataReleaseUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VLCSC의 EDI 다운로드 했던 데이터에 대해서 INV_AR_MN의 EDI_SND_DT 값을 Null 를 update 한다.
	  * </pre>
	  */
	public BookingARCreationDBDAOmodifyEDISendDataReleaseUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_inv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration").append("\n"); 
		query.append("FileName : BookingARCreationDBDAOmodifyEDISendDataReleaseUSQL").append("\n"); 
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
		query.append("UPDATE  INV_AR_MN" ).append("\n"); 
		query.append("SET     EDI_SND_DT = NULL" ).append("\n"); 
		query.append("WHERE   EDI_SND_DT IS NOT NULL" ).append("\n"); 
		query.append("AND     AR_IF_NO    IN (SELECT  AR_IF_NO" ).append("\n"); 
		query.append("                        FROM    INV_AR_ISS_DTL" ).append("\n"); 
		query.append("                        WHERE   INV_NO  BETWEEN @[fm_inv_no] AND @[to_inv_no]" ).append("\n"); 
		query.append("                        GROUP BY AR_IF_NO" ).append("\n"); 
		query.append("                       )" ).append("\n"); 

	}
}