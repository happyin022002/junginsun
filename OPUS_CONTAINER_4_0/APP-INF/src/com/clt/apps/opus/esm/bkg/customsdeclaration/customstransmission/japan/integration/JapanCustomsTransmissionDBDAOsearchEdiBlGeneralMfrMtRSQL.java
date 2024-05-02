/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : JapanCustomsTransmissionDBDAOsearchEdiBlGeneralMfrMtRSQL.java
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

public class JapanCustomsTransmissionDBDAOsearchEdiBlGeneralMfrMtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public JapanCustomsTransmissionDBDAOsearchEdiBlGeneralMfrMtRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_split_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_call_sgn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japan.integration").append("\n"); 
		query.append("FileName : JapanCustomsTransmissionDBDAOsearchEdiBlGeneralMfrMtRSQL").append("\n"); 
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
		query.append("SELECT --06.Vessel Code (9)" ).append("\n"); 
		query.append("       RPAD(NVL(SUBSTR(@[in_call_sgn_no], 1, 9), ' '), 9, ' ') AS DATA00," ).append("\n"); 
		query.append("       --07.Operating Carrier Voyage Number (10)" ).append("\n"); 
		query.append("       RPAD(NVL(JP_TML_VSL_NO, SUBSTR(@[in_vvd_cd], 5, 5)), 10, ' ') AS DATA01," ).append("\n"); 
		query.append("       --08.Voyage Number (10)" ).append("\n"); 
		query.append("       RPAD(NVL(JP_TML_VSL_NO, SUBSTR(@[in_vvd_cd], 5, 5)), 10, ' ') AS DATA02," ).append("\n"); 
		query.append("       --09.Consortium Voyage Number (10)" ).append("\n"); 
		query.append("       RPAD(NVL(JP_TML_VSL_NO, ' '), 10, ' ') AS DATA03," ).append("\n"); 
		query.append("       --10.Carrier Code (4)" ).append("\n"); 
		query.append("       COM_ConstantMgr_PKG.COM_getScacCode_FNC() AS DATA04," ).append("\n"); 
		query.append("       --------------------------------------------------------------------" ).append("\n"); 
		query.append("       --14.Container Operator Code (5)" ).append("\n"); 
		query.append("       RPAD(NVL(CY_OPR_ID, ' '), 5, ' ') AS DATA05," ).append("\n"); 
		query.append("       --15.B/L Number (35)" ).append("\n"); 
		query.append("       RPAD(' ', 35, ' ') AS DATA06," ).append("\n"); 
		query.append("       --16.Port of Loading Code (5)" ).append("\n"); 
		query.append("       RPAD(' ', 5, ' ') AS DATA07," ).append("\n"); 
		query.append("       --17.Final Destination Code (5)" ).append("\n"); 
		query.append("       RPAD(' ', 5, ' ') AS DATA08," ).append("\n"); 
		query.append("       --18.Final Destination Name (20)" ).append("\n"); 
		query.append("       RPAD(' ', 20, ' ') AS DATA09," ).append("\n"); 
		query.append("       --19.Place of Delivery Code (5)" ).append("\n"); 
		query.append("       RPAD(' ', 5, ' ') AS DATA10," ).append("\n"); 
		query.append("       --20.Place of Delivery Name (20)" ).append("\n"); 
		query.append("       RPAD(' ', 20, ' ') AS DATA11," ).append("\n"); 
		query.append("       --------------------------------------------------------------------" ).append("\n"); 
		query.append("       --52.HS Code (The First 6-digit) (6)" ).append("\n"); 
		query.append("       RPAD(' ', 6, ' ') AS DATA12," ).append("\n"); 
		query.append("       --54.Number of Packages (8)" ).append("\n"); 
		query.append("       RPAD(' ', 8, ' ') AS DATA13," ).append("\n"); 
		query.append("       --55.Number of Packages Unit Code (3)" ).append("\n"); 
		query.append("       RPAD(' ', 3, ' ') AS DATA14," ).append("\n"); 
		query.append("       --56.Gross Weight (10)" ).append("\n"); 
		query.append("       RPAD(' ', 10, ' ') AS DATA15," ).append("\n"); 
		query.append("       --57.Weight Unit Code (3)" ).append("\n"); 
		query.append("       RPAD(' ', 3, ' ') AS DATA16," ).append("\n"); 
		query.append("       --58.Net Weight (10)" ).append("\n"); 
		query.append("       RPAD(' ', 10, ' ') AS DATA17," ).append("\n"); 
		query.append("       --59.Weight Unit Code (3)" ).append("\n"); 
		query.append("       RPAD(' ', 3, ' ') AS DATA18," ).append("\n"); 
		query.append("       --60.Measurement (10)" ).append("\n"); 
		query.append("       RPAD(' ', 10, ' ') AS DATA19," ).append("\n"); 
		query.append("       --61.Measurement Unit Code (3)" ).append("\n"); 
		query.append("       RPAD(' ', 3, ' ') AS DATA20," ).append("\n"); 
		query.append("       --62.Country of Origin Code (2)" ).append("\n"); 
		query.append("       RPAD(' ', 2, ' ') AS DATA21," ).append("\n"); 
		query.append("       --63.Dangerous Cargo Code (3)" ).append("\n"); 
		query.append("       RPAD(' ', 3, ' ') AS DATA22," ).append("\n"); 
		query.append("       --64.Freight (18)" ).append("\n"); 
		query.append("       RPAD(' ', 18, ' ') AS DATA23," ).append("\n"); 
		query.append("       --65.Freight Currency Code (3)" ).append("\n"); 
		query.append("       RPAD(' ', 3, ' ') AS DATA24," ).append("\n"); 
		query.append("       --66.Value (18)" ).append("\n"); 
		query.append("       RPAD(' ', 18, ' ') AS DATA25," ).append("\n"); 
		query.append("       --67.Value Currency Code (3)" ).append("\n"); 
		query.append("       RPAD(' ', 3, ' ') AS DATA26," ).append("\n"); 
		query.append("       --68.Comprehensive In-Bond Transportation Approval Number (11)" ).append("\n"); 
		query.append("       RPAD(' ', 11, ' ') AS DATA27," ).append("\n"); 
		query.append("       --69.Temporary Discharge Identifier (3)" ).append("\n"); 
		query.append("       RPAD(' ', 3, ' ') AS DATA28," ).append("\n"); 
		query.append("       --70.Reason for Temporary Discharge Code (3)" ).append("\n"); 
		query.append("       RPAD(' ', 3, ' ') AS DATA29," ).append("\n"); 
		query.append("       --71.Duration of Temporary Discharge (2)" ).append("\n"); 
		query.append("       RPAD(' ', 2, ' ') AS DATA30," ).append("\n"); 
		query.append("       --72.Estimated Start Date of Transportation (8)" ).append("\n"); 
		query.append("       RPAD(' ', 8, ' ') AS DATA31," ).append("\n"); 
		query.append("       --73.Estimated Finish Date of Transportation (8)" ).append("\n"); 
		query.append("       RPAD(' ', 8, ' ') AS DATA32," ).append("\n"); 
		query.append("       --74.Code of Transportation Mode of Separate Transit/In-Bond Transportation of Temporary Discharge Cargo (2)" ).append("\n"); 
		query.append("       RPAD(' ', 2, ' ') AS DATA33," ).append("\n"); 
		query.append("       --75.Arrival Place Code (5)" ).append("\n"); 
		query.append("       RPAD(' ', 5, ' ') AS DATA34," ).append("\n"); 
		query.append("       --76.Arrival Place Name (35)" ).append("\n"); 
		query.append("       RPAD(' ', 35, ' ') AS DATA35," ).append("\n"); 
		query.append("       --77.Code of Other Relevant Laws and Ordinances (2) x5" ).append("\n"); 
		query.append("       RPAD(' ', 2, ' ') AS DATA36," ).append("\n"); 
		query.append("       RPAD(' ', 2, ' ') AS DATA37," ).append("\n"); 
		query.append("       RPAD(' ', 2, ' ') AS DATA38," ).append("\n"); 
		query.append("       RPAD(' ', 2, ' ') AS DATA39," ).append("\n"); 
		query.append("       RPAD(' ', 2, ' ') AS DATA40," ).append("\n"); 
		query.append("       --78.Remark (140)" ).append("\n"); 
		query.append("       RPAD(' ', 140, ' ') AS DATA41" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_JP_BL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE BL_NO = @[bl_no]" ).append("\n"); 
		query.append("   AND BL_SPLIT_NO = NVL(@[bl_split_no], '  ')" ).append("\n"); 
		query.append("   AND ROWNUM = 1" ).append("\n"); 

	}
}