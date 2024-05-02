/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ManualARCreationDBDAOSearchBlNoCntForMOSRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.10.04
*@LastModifier : 
*@LastVersion : 1.0
* 2016.10.04 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.manualarcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ManualARCreationDBDAOSearchBlNoCntForMOSRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * B/L No.가 Invoice Main 과 Booking Main 에 있는지 체크
	  * </pre>
	  */
	public ManualARCreationDBDAOSearchBlNoCntForMOSRSQL(){
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
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.manualarcreation.integration").append("\n"); 
		query.append("FileName : ManualARCreationDBDAOSearchBlNoCntForMOSRSQL").append("\n"); 
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
		query.append("SELECT DECODE(SUM(CNT), 0, 'N', 'Y') AS CHK_BLNO" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append(" SELECT COUNT(*) CNT" ).append("\n"); 
		query.append(" FROM INV_AR_MN" ).append("\n"); 
		query.append(" WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append(" UNION   " ).append("\n"); 
		query.append(" SELECT COUNT(*) CNT" ).append("\n"); 
		query.append(" FROM BKG_BOOKING" ).append("\n"); 
		query.append(" WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}