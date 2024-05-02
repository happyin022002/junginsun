/*=========================================================
*Copyright(c) 2017 Hi-Plus Card
*@FileName : JapanCustomsTransmissionDBDAOsearchBlGeneralRenewal2017RSQL.java
*@FileTitle : JapanCustomsTransmissionDBDAOsearchBlGeneralRenewal2017RSQL
*Open Issues :
*Change history :
*@LastModifyDate : 2017.08.14
*@LastModifier : 하대성
*@LastVersion : 1.0
* 2017.08.14 하대성
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

public class JapanCustomsTransmissionDBDAOsearchBlGeneralRenewal2017RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchBlGeneral
	  * </pre>
	  */
	public JapanCustomsTransmissionDBDAOsearchBlGeneralRenewal2017RSQL(){
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
		query.append("FileName : JapanCustomsTransmissionDBDAOsearchBlGeneralRenewal2017RSQL").append("\n"); 
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
		query.append("SELECT		" ).append("\n"); 
		query.append("--3.Correction reason code	" ).append("\n"); 
		query.append("	CASE WHEN @[in_msg_tp] = 'CMF02' AND @[in_msg_flag] = 2 THEN @[cmf_cd]" ).append("\n"); 
		query.append("		 WHEN @[in_msg_tp] = 'CMF02' AND @[in_msg_flag] = 5 THEN @[cmf_cd]" ).append("\n"); 
		query.append("		 ELSE ' ' " ).append("\n"); 
		query.append("		 END COR_CD, " ).append("\n"); 
		query.append("--4.Correction reason" ).append("\n"); 
		query.append("	CASE WHEN @[in_msg_flag] = 2 AND @[cmf_cd] = 6 THEN RPAD(@[cmf_reason], 210, ' ')" ).append("\n"); 
		query.append("		 WHEN @[in_msg_flag] = 5 AND @[cmf_cd] = 6 THEN RPAD(@[cmf_reason], 210, ' ')" ).append("\n"); 
		query.append("		 ELSE RPAD(' ', 210, ' ')" ).append("\n"); 
		query.append("		 END COR_REASON, " ).append("\n"); 
		query.append("--5.Reason for Deletion Code" ).append("\n"); 
		query.append("	CASE WHEN @[in_msg_flag] = 1 THEN @[cmf_cd]" ).append("\n"); 
		query.append("		 ELSE ' '" ).append("\n"); 
		query.append("	  	 END DEL_CD, " ).append("\n"); 
		query.append("--6.Deletion reason" ).append("\n"); 
		query.append("	CASE WHEN @[in_msg_flag] = 1 AND @[cmf_cd] = 5 THEN RPAD(@[cmf_reason], 210, ' ')" ).append("\n"); 
		query.append("		 ELSE RPAD(' ', 210, ' ')" ).append("\n"); 
		query.append("		 END DEL_REASON, " ).append("\n"); 
		query.append("--7.Vessel Code" ).append("\n"); 
		query.append("	RPAD(NVL(SUBSTR(@[in_call_sgn_no],1,9),' '),9,' ') IN_CALL_SGN_NO,	" ).append("\n"); 
		query.append("--8.Operating Carrier Voyage Number" ).append("\n"); 
		query.append("	CASE WHEN @[in_msg_flag] = 1 THEN RPAD(' ', 10, ' ')" ).append("\n"); 
		query.append("		 ELSE RPAD( NVL(JP_TML_VSL_NO, SUBSTR(@[in_vvd_cd],5,5)),10,' ')" ).append("\n"); 
		query.append("	     END OP_VVD_CD," ).append("\n"); 
		query.append("--9.Voyage number" ).append("\n"); 
		query.append("    RPAD( NVL(JP_TML_VSL_NO, SUBSTR(@[in_vvd_cd],5,5)),10,' ') IN_VVD_CD," ).append("\n"); 
		query.append("--POD Split No (1)으로 할당되어 있으나 EDI전송시 사용하지 않음	" ).append("\n"); 
		query.append("	RPAD(' ',1,' ') DATA1, " ).append("\n"); 
		query.append("--14.Container Operator Code	" ).append("\n"); 
		query.append("	RPAD(NVL(A.CY_OPR_ID,' '),5,' ') CY_OPR_CD,		" ).append("\n"); 
		query.append("--15.B/L No." ).append("\n"); 
		query.append("	RPAD('SMLM'||@[bl_no],35,' ') DATA2," ).append("\n"); 
		query.append("--16.Port of Loading Code" ).append("\n"); 
		query.append("	DECODE(L3.ATTR_CTNT2,NULL,DECODE(SUBSTR(L1.LOC_CD,1,2),'AW','AN','CS','CB','EU','ZY','KZ','KA','LI','ZY','RU','RS','TJ','TA','UA','UK','UZ','UB','YU','YE',SUBSTR(L1.LOC_CD,1,2))||'ZZZ',L3.ATTR_CTNT2) UN_LOC_ID1," ).append("\n"); 
		query.append("--17.Final destination code" ).append("\n"); 
		query.append("	RPAD(' ',5,' ') DATA3, 					" ).append("\n"); 
		query.append("--18.Final Destination Name" ).append("\n"); 
		query.append("	RPAD(' ',20,' ') DATA4,						" ).append("\n"); 
		query.append("--19.Place of Delivery Code" ).append("\n"); 
		query.append("	DECODE(L4.ATTR_CTNT2,NULL,DECODE(SUBSTR(L2.LOC_CD,1,2),'AW','AN','CS','CB','EU','ZY','KZ','KA','LI','ZY','RU','RS','TJ','TA','UA','UK','UZ','UB','YU','YE',SUBSTR(L1.LOC_CD,1,2))||'ZZZ',L4.ATTR_CTNT2) UN_LOC_ID2," ).append("\n"); 
		query.append("--20.Place of Delivery Name" ).append("\n"); 
		query.append("	RPAD(SUBSTR(DECODE(L4.ATTR_CTNT2,NULL,L2.LOC_NM,' '),1,20),20,' ') LOC_NM," ).append("\n"); 
		query.append("--62.HS Code" ).append("\n"); 
		query.append("	RPAD(' ',6,' ') DATA5, 					" ).append("\n"); 
		query.append("--64.Number of Packages" ).append("\n"); 
		query.append("	LPAD(NVL(A.PCK_QTY,0),8,' ') PCK_QTY,			" ).append("\n"); 
		query.append("--65.Number of Packages Unit Code" ).append("\n"); 
		query.append("	RPAD(DECODE(P.JP_CSTMS_PCK_CD,NULL,'ZZ',P.JP_CSTMS_PCK_CD),3,' ') PCK_CSTMS_CD," ).append("\n"); 
		query.append("--66.Gross Weight" ).append("\n"); 
		query.append("	LPAD(DECODE(NVL(A.GRS_WGT,0),0,0,SUBSTR(TO_CHAR(NVL(A.GRS_WGT,0),'0999999.999'),2)),10,' ') GRS_WGT," ).append("\n"); 
		query.append("--67.Weight Unit Code" ).append("\n"); 
		query.append("	DECODE(NVL(A.WGT_UT_CD,'KGS'),'LBS','LBR','KGS','KGM',A.WGT_UT_CD ) WGT_UT_CD," ).append("\n"); 
		query.append("--68.Net Weight" ).append("\n"); 
		query.append("	RPAD(' ',10,' ') DATA6,			" ).append("\n"); 
		query.append("--69.Weight Unit Code" ).append("\n"); 
		query.append("	RPAD(' ',3,' ') DATA7, 			" ).append("\n"); 
		query.append("--70.Measurement" ).append("\n"); 
		query.append("	LPAD(DECODE(NVL(A.MEAS_QTY,0),0,0,SUBSTR(TO_CHAR(NVL(A.MEAS_QTY,0),'0999999.999'),2)),10,' ') MEAS_QTY," ).append("\n"); 
		query.append("--71.Measurement Unit Code" ).append("\n"); 
		query.append("	DECODE(NVL(A.MEAS_UT_CD,'CBM'),'CMF','FTQ','MTQ') MEAS_UT_CD," ).append("\n"); 
		query.append("--72.Country of Origin Code" ).append("\n"); 
		query.append("	RPAD(' ',2,' ') DATA8, 		" ).append("\n"); 
		query.append("--73.Special Cargo Code" ).append("\n"); 
		query.append("	RPAD(' ',3,' ') DATA9, 					" ).append("\n"); 
		query.append("--74.Freight" ).append("\n"); 
		query.append("	RPAD(' ',18,' ') DATA10, " ).append("\n"); 
		query.append("--75.Freight Currency Code		" ).append("\n"); 
		query.append("	RPAD(' ',3,' ') DATA11, " ).append("\n"); 
		query.append("--76.Value" ).append("\n"); 
		query.append("	RPAD(' ',18,' ') DATA12, 		" ).append("\n"); 
		query.append("--77.Value Currency Code		" ).append("\n"); 
		query.append("	RPAD(' ',3,' ') DATA13, " ).append("\n"); 
		query.append("--78.General Customs Transit Approval Number		" ).append("\n"); 
		query.append("	RPAD(' ',11,' ') DATA14, " ).append("\n"); 
		query.append("--79.Temporary Landing Identifier		" ).append("\n"); 
		query.append("	DECODE(NVL(A.LOCL_TS_IND_CD,'L'),'T','28 ','   ') LOCL_TS_FLG1," ).append("\n"); 
		query.append("--80.Reason for Temporary Landing Code" ).append("\n"); 
		query.append("	DECODE(NVL(A.LOCL_TS_IND_CD,' '),'T',NVL(A.JP_CSTMS_TRNS_CD,' '),'   ') LOCL_TS_FLG2," ).append("\n"); 
		query.append("--81.Duration of Temporary Landing" ).append("\n"); 
		query.append("	DECODE(NVL(A.LOCL_TS_IND_CD,' '),'T',SUBSTR(TO_CHAR(NVL(A.LMT_NO,0),'99'),2),'  ') LOCL_TS_FLG3," ).append("\n"); 
		query.append("--82.Estimated Start Date of Transportation" ).append("\n"); 
		query.append("	RPAD(' ',8,' ') DATA15, " ).append("\n"); 
		query.append("--83.Estimated Finish Date of Transportation 						" ).append("\n"); 
		query.append("	RPAD(' ',8,' ') DATA16, " ).append("\n"); 
		query.append("--84.Code of Transportation Mode of Separate Transit/Customs Transit of Temporary Landing Cargo			" ).append("\n"); 
		query.append("	RPAD(' ',2,' ') DATA17,				" ).append("\n"); 
		query.append("--85.Arrival Place Code" ).append("\n"); 
		query.append("	RPAD(' ',5,' ') DATA18," ).append("\n"); 
		query.append("--86.Arrival Place Name				" ).append("\n"); 
		query.append("	RPAD(' ',35,' ') DATA19, " ).append("\n"); 
		query.append("--87.Code of Other Relevant Laws and Ordinances(반복1)		" ).append("\n"); 
		query.append("	RPAD(' ',2,' ') DATA20, " ).append("\n"); 
		query.append("--88.Code of Other Relevant Laws and Ordinances(반복2)		" ).append("\n"); 
		query.append("	RPAD(' ',2,' ') DATA21,	" ).append("\n"); 
		query.append("--89.Code of Other Relevant Laws and Ordinances(반복3)		" ).append("\n"); 
		query.append("	RPAD(' ',2,' ') DATA22,	" ).append("\n"); 
		query.append("--90.Code of Other Relevant Laws and Ordinances(반복4)" ).append("\n"); 
		query.append("	RPAD(' ',2,' ') DATA23,	" ).append("\n"); 
		query.append("--91.Code of Other Relevant Laws and Ordinances(반복5)" ).append("\n"); 
		query.append("	RPAD(' ',2,' ') DATA24," ).append("\n"); 
		query.append("--92.Remarks		" ).append("\n"); 
		query.append("	RPAD(' ',140,' ')  DATA25" ).append("\n"); 
		query.append("FROM BKG_CSTMS_JP_BL A, MDM_LOCATION L1,  MDM_LOCATION L2, MDM_PCK_TP P, BKG_CSTMS_CD_CONV_CTNT L3, BKG_CSTMS_CD_CONV_CTNT L4" ).append("\n"); 
		query.append("WHERE	A.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("AND	A.BL_SPLIT_NO = nvl(@[bl_split_no],'  ')" ).append("\n"); 
		query.append("AND A.BKG_POL_CD      = L1.LOC_CD(+)" ).append("\n"); 
		query.append("AND A.BKG_DEL_CD      = L2.LOC_CD(+)" ).append("\n"); 
		query.append("AND L3.CNT_CD(+) = 'JP'" ).append("\n"); 
		query.append("AND L3.CSTMS_DIV_ID(+) = 'JAPAN_LOC'" ).append("\n"); 
		query.append("AND A.BKG_POL_CD	  = L3.ATTR_CTNT1(+)" ).append("\n"); 
		query.append("AND L4.CNT_CD(+) = 'JP'" ).append("\n"); 
		query.append("AND L4.CSTMS_DIV_ID(+) = 'JAPAN_LOC'" ).append("\n"); 
		query.append("AND A.BKG_DEL_CD	  = L4.ATTR_CTNT1(+)" ).append("\n"); 
		query.append("AND A.PCK_TP_CD   = P.PCK_CD(+)" ).append("\n"); 
		query.append("AND P.DELT_FLG(+) = 'N'" ).append("\n"); 

	}
}