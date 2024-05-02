/*=========================================================
*Copyright(c) 2017 Hi-Plus Card
*@FileName : JapanCustomsTransmissionDBDAOsearchEmptyBlRenewal2017RSQL.java
*@FileTitle : JapanCustomsTransmissionDBDAOsearchEmptyBlRenewal2017RSQL
*Open Issues :
*Change history :
*@LastModifyDate : 2017.08.16
*@LastModifier : 하대성
*@LastVersion : 1.0
* 2017.08.16 하대성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japan.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JapanCustomsTransmissionDBDAOsearchEmptyBlRenewal2017RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchEmptyBl
	  * </pre>
	  */
	public JapanCustomsTransmissionDBDAOsearchEmptyBlRenewal2017RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_msg_flag",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmf_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmf_reason",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("in_msg_tp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japan.integration").append("\n"); 
		query.append("FileName : JapanCustomsTransmissionDBDAOsearchEmptyBlRenewal2017RSQL").append("\n"); 
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
		query.append("	CASE WHEN @[in_msg_tp] = 'CMF02' AND @[in_msg_flag] = 2 THEN @[cmf_cd]" ).append("\n"); 
		query.append("		 WHEN @[in_msg_tp] = 'CMF02' AND @[in_msg_flag] = 5 THEN @[cmf_cd]" ).append("\n"); 
		query.append("		 ELSE ' ' " ).append("\n"); 
		query.append("		 END COR_CD, --3.Correction reason code" ).append("\n"); 
		query.append("	CASE WHEN @[in_msg_flag] = 2 AND @[cmf_cd] = 6 THEN RPAD(@[cmf_reason], 210, ' ')" ).append("\n"); 
		query.append("		 WHEN @[in_msg_flag] = 5 AND @[cmf_cd] = 6 THEN RPAD(@[cmf_reason], 210, ' ')" ).append("\n"); 
		query.append("		 ELSE RPAD(' ', 210, ' ')" ).append("\n"); 
		query.append("		 END COR_REASON, --4.Correction reason" ).append("\n"); 
		query.append("	CASE WHEN @[in_msg_flag] = 1 THEN @[cmf_cd]" ).append("\n"); 
		query.append("		 ELSE ' '" ).append("\n"); 
		query.append("	  	 END DEL_CD, --5.Reason for Deletion Code" ).append("\n"); 
		query.append("	CASE WHEN @[in_msg_flag] = 1 AND @[cmf_cd] = 5 THEN RPAD(@[cmf_reason], 210, ' ')" ).append("\n"); 
		query.append("		 ELSE RPAD(' ', 210, ' ')" ).append("\n"); 
		query.append("		 END DEL_REASON, --6.Deletion reason" ).append("\n"); 
		query.append("	RPAD(SUBSTR(@[in_call_sgn_no],1,9),9,' ') IN_CALL_SGN_NO, --7.Vessel Code 	" ).append("\n"); 
		query.append("	CASE WHEN @[in_msg_flag] = 1 THEN RPAD(' ', 10, ' ')" ).append("\n"); 
		query.append("		 ELSE RPAD( NVL(JP_TML_VSL_NO, SUBSTR(@[in_vvd_cd],5,5)),10,' ')" ).append("\n"); 
		query.append("	     END OP_VVD_CD, --8.Operating Carrier Voyage Number	" ).append("\n"); 
		query.append("    RPAD( NVL(JP_TML_VSL_NO, SUBSTR(@[in_vvd_cd],5,5)),10,' ') IN_VVD_CD, --9.Voyage number" ).append("\n"); 
		query.append("	RPAD(' ',1,' ') DATA1, --POD Split No(사용하지 않음) 	" ).append("\n"); 
		query.append("	RPAD(NVL(CY_OPR_ID,' '),5,' ') CY_OPR_CD, --14.Container Operator Code" ).append("\n"); 
		query.append("	RPAD(' ',35,' ') DATA2,	--15.B/L No.		" ).append("\n"); 
		query.append("	RPAD(' ',5,' ') DATA3, --16.Port of Loading Code			" ).append("\n"); 
		query.append("	RPAD(' ',5,' ') DATA4, --17.Final destination code			" ).append("\n"); 
		query.append("	RPAD(' ',20,' ') DATA5, --18.Final Destination Name			" ).append("\n"); 
		query.append("	RPAD(' ',5,' ') DATA6, --19.Place of Delivery Code" ).append("\n"); 
		query.append("	RPAD(' ',20,' ') DATA7, --20.Place of Delivery Name" ).append("\n"); 
		query.append("	RPAD(' ',17,' ') DATA8,	--21.Shipper Code		" ).append("\n"); 
		query.append("	RPAD(' ',70,' ') DATA9, --22.Shipper Name			" ).append("\n"); 
		query.append("	RPAD(' ',175,' ') DATA10, --23.Shipper Address (block entry)		" ).append("\n"); 
		query.append("	RPAD(' ',70,' ') DATA11, --24.Shipper Address 1/4 (Street and number/P.O. Box)						" ).append("\n"); 
		query.append("	RPAD(' ',35,' ') DATA12, --25.Shipper Address 2/4 (Street and number/P.O. Box)					" ).append("\n"); 
		query.append("	RPAD(' ',35,' ') DATA13, --26.Shipper Address 3/4 (City name)		" ).append("\n"); 
		query.append("	RPAD(' ',35,' ') DATA14, --27.Shipper Address 4/4 (Country sub-entity, name)						" ).append("\n"); 
		query.append("	RPAD(' ',9,' ') DATA15, --28.Shipper Postal Code (Postcode identification)					" ).append("\n"); 
		query.append("	RPAD(' ',2,' ') DATA16, --29.Shipper Country Code (Country, coded)	" ).append("\n"); 
		query.append("	RPAD(' ',14,' ') DATA17, --30.Shipper Telephone Number		" ).append("\n"); 
		query.append("	RPAD(' ',17,' ') DATA18, --31.Consignee Code		" ).append("\n"); 
		query.append("	RPAD(' ',70,' ') DATA19, --32.Consignee Name" ).append("\n"); 
		query.append("	RPAD(' ',175,' ') DATA20, --33.Consignee Address (block entry)" ).append("\n"); 
		query.append("	RPAD(' ',70,' ') DATA21, --34.Consignee Address 1/4 (Street and number/P.O. Box)			" ).append("\n"); 
		query.append("	RPAD(' ',35,' ') DATA22, --35.Consignee Address 2/4 (Street and number/P.O. Box)		" ).append("\n"); 
		query.append("	RPAD(' ',35,' ') DATA23, --36.Consignee Address 3/4 (City name)" ).append("\n"); 
		query.append("	RPAD(' ',35,' ') DATA24, --37.Consignee Address 4/4 (Country sub-entity, name)				" ).append("\n"); 
		query.append("	RPAD(' ',9,' ') DATA25,	--38.Consignee Postal Code (Postcode identification)" ).append("\n"); 
		query.append("	RPAD(' ',2,' ') DATA26,	--39.Consignee Country Code (Country, coded)	" ).append("\n"); 
		query.append("	RPAD(' ',14,' ') DATA27, --40.Consignee Telephone Number		" ).append("\n"); 
		query.append("	RPAD(' ',17,' ') DATA28, --41.Notify Party Code" ).append("\n"); 
		query.append("	RPAD(' ',70,' ') DATA29, --42.Notify Party Name" ).append("\n"); 
		query.append("	RPAD(' ',175,' ') DATA30, --43.Notify Party Address (block entry)" ).append("\n"); 
		query.append("	RPAD(' ',70,' ') DATA31, --44.Notify Party Address 1/4(Street and number/P.O.Box)" ).append("\n"); 
		query.append("	RPAD(' ',35,' ') DATA32, --45.Notify Party Address 2/4(Street and number/P.O.Box)	" ).append("\n"); 
		query.append("	RPAD(' ',35,' ') DATA33, --46.Notify Party Address 3/4(City name)" ).append("\n"); 
		query.append("	RPAD(' ',35,' ') DATA34, --47.Notify Party Address 4/4(Country sub- entity, name)" ).append("\n"); 
		query.append("	RPAD(' ',9,' ') DATA35, --48.Notify Party Postal Code (Postcode identification)" ).append("\n"); 
		query.append("	RPAD(' ',2,' ') DATA36, --49.Notify Party Country Code (Country, coded)" ).append("\n"); 
		query.append("	RPAD(' ',14,' ') DATA37, --50.Notify Party Telephone Number" ).append("\n"); 
		query.append("	RPAD(' ',17,' ') DATA38, --51.Notify Party Code(반복2)	" ).append("\n"); 
		query.append("	RPAD(' ',70,' ') DATA39, --52.Notify Party Name(반복2)	" ).append("\n"); 
		query.append("	RPAD(' ',175,' ') DATA40, --53.Notify Party Address (block entry)(반복2)" ).append("\n"); 
		query.append("	RPAD(' ',70,' ') DATA41, --54.Notify Party Address 1/4（Street and number/P.O.Box）(반복2)			" ).append("\n"); 
		query.append("	RPAD(' ',35,' ') DATA42, --55.Notify Party Address 2/4（Street and number/P.O.Box）(반복2)					" ).append("\n"); 
		query.append("	RPAD(' ',35,' ') DATA43, --56.Notify Party Address 3/4（City name）(반복2)" ).append("\n"); 
		query.append("	RPAD(' ',35,' ') DATA44, --57.Notify Party Address 4/4（Country sub- entity, name）(반복2)  								" ).append("\n"); 
		query.append("	RPAD(' ',9,' ') DATA45, --58.Notify Party Postal Code (Postcode identification)(반복2)					" ).append("\n"); 
		query.append("	RPAD(' ',2,' ') DATA46, --59.Notify Party Country Code (Country, coded)(반복2)" ).append("\n"); 
		query.append("	RPAD(' ',14,' ') DATA47, --60.Notify Party Telephone Number(반복2)		" ).append("\n"); 
		query.append("	RPAD(' ',350,' ') DATA48, --61.Goods Description" ).append("\n"); 
		query.append("	RPAD(' ',6,' ') DATA49,	 --62.HS Code	" ).append("\n"); 
		query.append("	RPAD(' ',140,' ') DATA50, --63.Marks and Numbers		" ).append("\n"); 
		query.append("	RPAD(' ',8,' ') DATA51,	--64.Number of Packages					" ).append("\n"); 
		query.append("	RPAD(' ',3,' ') DATA52,	--65.Number of Packages Unit Code			" ).append("\n"); 
		query.append("	RPAD(' ',10,' ') DATA53, --66.Gross Weight		" ).append("\n"); 
		query.append("	RPAD(' ',3,' ') DATA54, --67.Weight Unit Code				" ).append("\n"); 
		query.append("	RPAD(' ',10,' ') DATA55, --68.Net Weight				" ).append("\n"); 
		query.append("	RPAD(' ',3,' ') DATA56,	--69.Weight Unit Code	" ).append("\n"); 
		query.append("	RPAD(' ',10,' ') DATA57, --70.Measurement	" ).append("\n"); 
		query.append("	RPAD(' ',3,' ') DATA58,	--71.Measurement Unit Code				" ).append("\n"); 
		query.append("	RPAD(' ',2,' ') DATA59, --72.Country of Origin Code			" ).append("\n"); 
		query.append("	RPAD(' ',3,' ') DATA60, --73.Special Cargo Code" ).append("\n"); 
		query.append("	RPAD(' ',18,' ') DATA61, --74.Freight	" ).append("\n"); 
		query.append("	RPAD(' ',3,' ') DATA62, --75.Freight Currency Code		" ).append("\n"); 
		query.append("	RPAD(' ',18,' ') DATA63, --76.Value		" ).append("\n"); 
		query.append("	RPAD(' ',3,' ') DATA64, --77.Value Currency Code		" ).append("\n"); 
		query.append("	RPAD(' ',11,' ') DATA65, --78.General Customs Transit Approval Number		" ).append("\n"); 
		query.append("	RPAD(' ',3,' ') DATA66, --79.Temporary Landing Identifier					" ).append("\n"); 
		query.append("	RPAD(' ',3,' ') DATA67, --80.Reason for Temporary Landing Code			" ).append("\n"); 
		query.append("	RPAD(' ',2,' ') DATA68, --81.Duration of Temporary Landing" ).append("\n"); 
		query.append("	RPAD(' ',8,' ') DATA69,	--82.Estimated Start Date of Transportation	" ).append("\n"); 
		query.append("	RPAD(' ',8,' ') DATA70, --83.Estimated Finish Date of Transportation				" ).append("\n"); 
		query.append("	RPAD(' ',2,' ') DATA71, --84.Code of Transportation Mode of Separate Transit/Customs Transit of Temporary Landing Cargo" ).append("\n"); 
		query.append("	RPAD(' ',5,' ') DATA72, --85.Arrival Place Code			" ).append("\n"); 
		query.append("	RPAD(' ',35,' ') DATA73, --86.Arrival Place Name" ).append("\n"); 
		query.append("	RPAD(' ',2,' ') DATA74, --87.Code of Other Relevant Laws and Ordinances(반복1)		" ).append("\n"); 
		query.append("	RPAD(' ',2,' ') DATA75, --88.Code of Other Relevant Laws and Ordinances(반복2)" ).append("\n"); 
		query.append("	RPAD(' ',2,' ') DATA76, --89.Code of Other Relevant Laws and Ordinances(반복3)" ).append("\n"); 
		query.append("	RPAD(' ',2,' ') DATA77, --90.Code of Other Relevant Laws and Ordinances(반복4)	" ).append("\n"); 
		query.append("	RPAD(' ',2,' ') DATA78, --91.Code of Other Relevant Laws and Ordinances(반복5)" ).append("\n"); 
		query.append("	RPAD(' ',140,' ')  DATA79 --92.Remarks" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("	BKG_CSTMS_JP_BL" ).append("\n"); 
		query.append("WHERE	BL_NO = @[bl_no]" ).append("\n"); 
		query.append("AND	BL_SPLIT_NO = nvl(@[bl_split_no],'  ')" ).append("\n"); 

	}
}