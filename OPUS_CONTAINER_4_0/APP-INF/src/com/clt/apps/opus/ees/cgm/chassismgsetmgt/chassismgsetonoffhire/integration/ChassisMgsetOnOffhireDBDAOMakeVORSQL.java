/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChassisMgsetOnOffhireDBDAOMakeVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.02
*@LastModifier : 박의수
*@LastVersion : 1.0
* 2009.07.02 박의수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Eui-su Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetOnOffhireDBDAOMakeVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public ChassisMgsetOnOffhireDBDAOMakeVORSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
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
		query.append("SELECT '' AS AGMT_LSTM_CD," ).append("\n"); 
		query.append("'' AS AGMT_REF_NO," ).append("\n"); 
		query.append("'' AS AGREEMENT_NO," ).append("\n"); 
		query.append("'' AS CHSS_ALS_NO," ).append("\n"); 
		query.append("'' AS CHSS_RGST_EXP_DT," ).append("\n"); 
		query.append("'' AS CHSS_RGST_LIC_NO," ).append("\n"); 
		query.append("'' AS CHSS_RGST_STE_CD," ).append("\n"); 
		query.append("'' AS CHSS_RGST_YR," ).append("\n"); 
		query.append("'' AS CHSS_TARE_WGT," ).append("\n"); 
		query.append("'' AS CHSS_TIT_NO," ).append("\n"); 
		query.append("'' AS CHSS_VEH_ID_NO," ).append("\n"); 
		query.append("'' AS CRE_DT," ).append("\n"); 
		query.append("'' AS CRE_USR_ID," ).append("\n"); 
		query.append("'' AS EQ_NO," ).append("\n"); 
		query.append("'' AS EQ_TPSZ_CD," ).append("\n"); 
		query.append("'' AS MFT_DT," ).append("\n"); 
		query.append("'' AS ONH_DT," ).append("\n"); 
		query.append("'' AS ONH_OFC_CD," ).append("\n"); 
		query.append("'' AS ONH_YD_CD," ).append("\n"); 
		query.append("'' AS VNDR_LGL_ENG_NM," ).append("\n"); 
		query.append("'' AS VNDR_SEQ" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.integration ").append("\n"); 
		query.append("FileName : ChassisMgsetOnOffhireDBDAOMakeVORSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}