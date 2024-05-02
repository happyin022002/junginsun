/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : CndExpCustomsTransmissionDBDAOsearchVesselArrival2RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.12.07
*@LastModifier : 
*@LastVersion : 1.0
* 2017.12.07 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CndExpCustomsTransmissionDBDAOsearchVesselArrival2RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchVesselArrival2
	  * </pre>
	  */
	public CndExpCustomsTransmissionDBDAOsearchVesselArrival2RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.integration").append("\n"); 
		query.append("FileName : CndExpCustomsTransmissionDBDAOsearchVesselArrival2RSQL").append("\n"); 
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
		query.append("SELECT  " ).append("\n"); 
		query.append("      /* 포트가 추가 되어 포트별로 설정이 가능한데, 같은 포트에서 셋업된 것을 우선적으로 적용한다. CVY_REF_NO는 VVD별로 대부분 같다. */" ).append("\n"); 
		query.append("		SUBSTR(MAX(DECODE(A.CSTMS_PORT_CD, B.PORT_CD,'1','0') || B.CVY_REF_NO),2) CVY_REF_NO" ).append("\n"); 
		query.append("  FROM  BKG_CSTMS_AMER_BL A, BKG_CSTMS_CND_XPT_VSL B" ).append("\n"); 
		query.append(" WHERE  A.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("   AND  A.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND  A.SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("   AND  A.CNT_CD = 'CA'" ).append("\n"); 
		query.append("   AND  A.IO_BND_CD = 'O'" ).append("\n"); 
		query.append("   AND  A.BL_NO = @[bl_no]" ).append("\n"); 

	}
}