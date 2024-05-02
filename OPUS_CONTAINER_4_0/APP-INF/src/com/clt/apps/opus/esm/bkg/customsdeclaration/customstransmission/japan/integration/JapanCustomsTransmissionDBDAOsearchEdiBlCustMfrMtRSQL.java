/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : JapanCustomsTransmissionDBDAOsearchEdiBlCustMfrMtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.09
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.09 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japan.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JapanCustomsTransmissionDBDAOsearchEdiBlCustMfrMtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public JapanCustomsTransmissionDBDAOsearchEdiBlCustMfrMtRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japan.integration").append("\n"); 
		query.append("FileName : JapanCustomsTransmissionDBDAOsearchEdiBlCustMfrMtRSQL").append("\n"); 
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
		query.append("SELECT --21.Shipper Code (17)" ).append("\n"); 
		query.append("       RPAD(' ', 17, ' ') AS DATA00," ).append("\n"); 
		query.append("       --22.Shipper Name1 (35)" ).append("\n"); 
		query.append("       RPAD(' ', 35, ' ') AS DATA01," ).append("\n"); 
		query.append("       --23.Shipper Name2 (35)" ).append("\n"); 
		query.append("       RPAD(' ', 35, ' ') AS DATA02," ).append("\n"); 
		query.append("       --24.Address Line1 (35)" ).append("\n"); 
		query.append("       RPAD(' ', 35, ' ') AS DATA03," ).append("\n"); 
		query.append("       --25.Address Line2 (35)" ).append("\n"); 
		query.append("       RPAD(' ', 35, ' ') AS DATA04," ).append("\n"); 
		query.append("       --26.Address Line3 (35)" ).append("\n"); 
		query.append("       RPAD(' ', 35, ' ') AS DATA05," ).append("\n"); 
		query.append("       --27.Resolved Field (35)" ).append("\n"); 
		query.append("       RPAD(' ', 35, ' ') AS DATA06," ).append("\n"); 
		query.append("       --28.Shipper Postal Code (Postcode identification) (9)" ).append("\n"); 
		query.append("       RPAD(' ', 9, ' ') AS DATA07," ).append("\n"); 
		query.append("       --29.Shipper Country Code (Country, coded) (2)" ).append("\n"); 
		query.append("       RPAD(' ', 2, ' ') AS DATA08," ).append("\n"); 
		query.append("       --30.Shipper Telephone Number (14)" ).append("\n"); 
		query.append("       RPAD(' ', 14, ' ') AS DATA09," ).append("\n"); 
		query.append("       ---------------------------------------------------------" ).append("\n"); 
		query.append("       --31.Consignee Code (17)" ).append("\n"); 
		query.append("       RPAD(' ', 17, ' ') AS DATA10," ).append("\n"); 
		query.append("       --32.Consignee Name1 (35)" ).append("\n"); 
		query.append("       RPAD(' ', 35, ' ') AS DATA11," ).append("\n"); 
		query.append("       --33.Consignee Name2 (35)" ).append("\n"); 
		query.append("       RPAD(' ', 35, ' ') AS DATA12," ).append("\n"); 
		query.append("       --34.Address Line1 (35)" ).append("\n"); 
		query.append("       RPAD(' ', 35, ' ') AS DATA13," ).append("\n"); 
		query.append("       --35.Address Line2 (35)" ).append("\n"); 
		query.append("       RPAD(' ', 35, ' ') AS DATA14," ).append("\n"); 
		query.append("       --36.Address Line3 (35)" ).append("\n"); 
		query.append("       RPAD(' ', 35, ' ') AS DATA15," ).append("\n"); 
		query.append("       --37.Resolved Field (35)" ).append("\n"); 
		query.append("       RPAD(' ', 35, ' ') AS DATA16," ).append("\n"); 
		query.append("       --38.Consignee Postal Code (Postcode identification) (9)" ).append("\n"); 
		query.append("       RPAD(' ', 9, ' ') AS DATA17," ).append("\n"); 
		query.append("       --39.Consignee Country Code (Country, coded) (2)" ).append("\n"); 
		query.append("       RPAD(' ', 2, ' ') AS DATA18," ).append("\n"); 
		query.append("       --40.Consignee Telephone Number (14)" ).append("\n"); 
		query.append("       RPAD(' ', 14, ' ') AS DATA19," ).append("\n"); 
		query.append("       ---------------------------------------------------------" ).append("\n"); 
		query.append("       --41.Notify Party Code (17) x2" ).append("\n"); 
		query.append("       RPAD(' ', 17, ' ') AS DATA20," ).append("\n"); 
		query.append("       --42.Notify Party Name1 (35)" ).append("\n"); 
		query.append("       RPAD(' ', 35, ' ') AS DATA21," ).append("\n"); 
		query.append("       --43.Notify Party Name2 (35)" ).append("\n"); 
		query.append("       RPAD(' ', 35, ' ') AS DATA22," ).append("\n"); 
		query.append("       --44.Address Line1 (35)" ).append("\n"); 
		query.append("       RPAD(' ', 35, ' ') AS DATA23," ).append("\n"); 
		query.append("       --45.Address Line2 (35)" ).append("\n"); 
		query.append("       RPAD(' ', 35, ' ') AS DATA24," ).append("\n"); 
		query.append("       --46.Address Line3 (35)" ).append("\n"); 
		query.append("       RPAD(' ', 35, ' ') AS DATA25," ).append("\n"); 
		query.append("       --47.Resolved Field (35)" ).append("\n"); 
		query.append("       RPAD(' ', 35, ' ') AS DATA26," ).append("\n"); 
		query.append("       --48.Notify Party Postal Code (Postcode identification) (9)" ).append("\n"); 
		query.append("       RPAD(' ', 9, ' ') AS DATA27," ).append("\n"); 
		query.append("       --49.Notify Party Country Code (Country, coded) (2)" ).append("\n"); 
		query.append("       RPAD(' ', 2, ' ') AS DATA28," ).append("\n"); 
		query.append("       --50.Notify Party Telephone Number (14)" ).append("\n"); 
		query.append("       RPAD(' ', 14, ' ') AS DATA29," ).append("\n"); 
		query.append("       ---------------------------------------------------------" ).append("\n"); 
		query.append("       --41.Notify Party Code (17)" ).append("\n"); 
		query.append("       RPAD(' ', 17, ' ') AS DATA30," ).append("\n"); 
		query.append("       --42.Notify Party Name1 (35)" ).append("\n"); 
		query.append("       RPAD(' ', 35, ' ') AS DATA31," ).append("\n"); 
		query.append("       --43.Notify Party Name2 (35)" ).append("\n"); 
		query.append("       RPAD(' ', 35, ' ') AS DATA32," ).append("\n"); 
		query.append("       --44.Address Line1 (35)" ).append("\n"); 
		query.append("       RPAD(' ', 35, ' ') AS DATA33," ).append("\n"); 
		query.append("       --45.Address Line2 (35)" ).append("\n"); 
		query.append("       RPAD(' ', 35, ' ') AS DATA34," ).append("\n"); 
		query.append("       --46.Address Line3 (35)" ).append("\n"); 
		query.append("       RPAD(' ', 35, ' ') AS DATA35," ).append("\n"); 
		query.append("       --47.Resolved Field (35)" ).append("\n"); 
		query.append("       RPAD(' ', 35, ' ') AS DATA36," ).append("\n"); 
		query.append("       --48.Notify Party Postal Code (Postcode identification) (9)" ).append("\n"); 
		query.append("       RPAD(' ', 9, ' ') AS DATA37," ).append("\n"); 
		query.append("       --49.Notify Party Country Code (Country, coded) (2)" ).append("\n"); 
		query.append("       RPAD(' ', 2, ' ') AS DATA38," ).append("\n"); 
		query.append("       --50.Notify Party Telephone Number (14)" ).append("\n"); 
		query.append("       RPAD(' ', 14, ' ') AS DATA39" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 

	}
}