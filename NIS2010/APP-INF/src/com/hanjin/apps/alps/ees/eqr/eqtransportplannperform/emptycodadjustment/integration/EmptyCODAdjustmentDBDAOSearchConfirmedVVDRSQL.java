/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EmptyCODAdjustmentDBDAOSearchConfirmedVVDRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.03
*@LastModifier : 나상보
*@LastVersion : 1.0
* 2011.05.03 나상보
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.eqtransportplannperform.emptycodadjustment.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sangbo La
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EmptyCODAdjustmentDBDAOSearchConfirmedVVDRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MTY 양하 계획 조정
	  * UI_CIM_1039
	  * MTY COD Confirmation
	  * 
	  * 2011.05.03 나상보 [CHM-201110558-01] [EQR] MTY COD Confirmation의 Created by 컬럼 수정 요청
	  * </pre>
	  */
	public EmptyCODAdjustmentDBDAOSearchConfirmedVVDRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("COD_CFM_DIV_CD",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.eqtransportplannperform.emptycodadjustment.integration").append("\n"); 
		query.append("FileName : EmptyCODAdjustmentDBDAOSearchConfirmedVVDRSQL").append("\n"); 
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
		query.append("SELECT		EV.SLAN_CD || '|' || EV.BAY_PLN_PORT_CD || '|' || EV.COD_CFM_STS_CD || '|' || EV.UPD_USR_ID || '|' || RMK.DIFF_RMK || '|' || TO_CHAR(EV.UPD_DT, 'YYYY-MM-DD') AS XXX" ).append("\n"); 
		query.append("	FROM	EQR_MTY_COD_VVD		EV, " ).append("\n"); 
		query.append("			EQR_MTY_COD_PORT	EP," ).append("\n"); 
		query.append("			EQR_MTY_COD_RMK		RMK" ).append("\n"); 
		query.append("	WHERE	EV.VSL_CD			=	SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("	AND		EV.SKD_VOY_NO		=	SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("	AND		EV.SKD_DIR_CD		=	SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("	AND		EV.COD_CFM_DIV_CD	=	@[COD_CFM_DIV_CD]       /* Cod Confirmation */" ).append("\n"); 
		query.append("	AND		EV.VSL_CD			=	EP.VSL_CD" ).append("\n"); 
		query.append("	AND		EV.SKD_VOY_NO		=	EP.SKD_VOY_NO" ).append("\n"); 
		query.append("	AND		EV.SKD_DIR_CD		=	EP.SKD_DIR_CD" ).append("\n"); 
		query.append("	AND		EV.COD_CFM_DIV_CD	=	EP.COD_CFM_DIV_CD" ).append("\n"); 
		query.append("	AND		EV.VSL_CD			=	RMK.VSL_CD			(+)" ).append("\n"); 
		query.append("	AND		EV.SKD_VOY_NO		=	RMK.SKD_VOY_NO		(+)" ).append("\n"); 
		query.append("	AND		EV.SKD_DIR_CD		=	RMK.SKD_DIR_CD		(+)" ).append("\n"); 
		query.append("	AND		EV.COD_CFM_DIV_CD	=	RMK.COD_CFM_DIV_CD	(+)" ).append("\n"); 

	}
}