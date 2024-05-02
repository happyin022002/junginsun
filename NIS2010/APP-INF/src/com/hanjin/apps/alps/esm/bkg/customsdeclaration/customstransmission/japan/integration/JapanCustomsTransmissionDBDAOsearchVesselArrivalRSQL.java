/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : JapanCustomsTransmissionDBDAOsearchVesselArrivalRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.05
*@LastModifier : 
*@LastVersion : 1.0
* 2014.03.05 
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

public class JapanCustomsTransmissionDBDAOsearchVesselArrivalRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchVesselArrival
	  * </pre>
	  */
	public JapanCustomsTransmissionDBDAOsearchVesselArrivalRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("in_eta_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_pod_cd_split",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japan.integration").append("\n"); 
		query.append("FileName : JapanCustomsTransmissionDBDAOsearchVesselArrivalRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("	RPAD(SUBSTR(NVL(A.CALL_SGN_NO,' '),1,9),9,' ') CALL_SIGN_NO,	" ).append("\n"); 
		query.append("	DECODE(L1.ATTR_CTNT2, NULL, DECODE(SUBSTR(@[in_pod_cd],1,2),'AW','AN','CS','CB','EU','ZY','KZ','KA','LI','ZY','RU','RS','TJ','TA','UA','UK','UZ','UB','YU','YE', SUBSTR(@[in_pod_cd],1,2))||'ZZZ', L1.ATTR_CTNT2) POD_CD," ).append("\n"); 
		query.append("	NVL(@[in_pod_cd_split],' ') POD_SPLIT," ).append("\n"); 
		query.append("	'    ' DATA1," ).append("\n"); 
		query.append("	' ' DATA2," ).append("\n"); 
		query.append("	RPAD(NVL(@[in_eta_dt],' '),8,' ') ETA_DT," ).append("\n"); 
		query.append("	RPAD(NVL(NULL,' '),2,' ') CSTMS_MF_CD," ).append("\n"); 
		query.append("	RPAD(BKG_SPCLCHAR_CONV_FNC(NVL(B.MF_RMK, ' '),'J'),140,' ') MF_RMK" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("	BKG_CSTMS_JP_VSL_SKD A,  " ).append("\n"); 
		query.append("	BKG_CSTMS_JP_VSL B," ).append("\n"); 
		query.append("	BKG_CSTMS_CD_CONV_CTNT L1" ).append("\n"); 
		query.append("WHERE A.VSL_CD     = SUBSTR(@[in_vvd_cd],1,4)" ).append("\n"); 
		query.append("AND A.SKD_VOY_NO   = SUBSTR(@[in_vvd_cd],5,4)" ).append("\n"); 
		query.append("AND A.SKD_DIR_CD   = SUBSTR(@[in_vvd_cd],9,1)" ).append("\n"); 
		query.append("AND A.POD_CD       = @[in_pod_cd] " ).append("\n"); 
		query.append("AND A.VSL_CD       = B.VSL_CD(+)" ).append("\n"); 
		query.append("AND A.SKD_VOY_NO   = B.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("AND A.SKD_DIR_CD   = B.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("AND A.POD_CD       = B.POD_CD(+)" ).append("\n"); 
		query.append("AND L1.CNT_CD(+)   = 'JP'" ).append("\n"); 
		query.append("AND L1.CSTMS_DIV_ID(+) = 'JAPAN_LOC'" ).append("\n"); 
		query.append("and L1.ATTR_CTNT1(+) = A.POD_CD" ).append("\n"); 

	}
}