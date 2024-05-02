/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ChassisMgsetOnOffhireDBDAOsearchMGSOffhireInfoDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.09.26
*@LastModifier : 
*@LastVersion : 1.0
* 2014.09.26 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetOnOffhireDBDAOsearchMGSOffhireInfoDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public ChassisMgsetOnOffhireDBDAOsearchMGSOffhireInfoDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.integration").append("\n"); 
		query.append("FileName : ChassisMgsetOnOffhireDBDAOsearchMGSOffhireInfoDataRSQL").append("\n"); 
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
		query.append("SELECT A.EQ_NO" ).append("\n"); 
		query.append("      ,A.EQ_TPSZ_CD" ).append("\n"); 
		query.append("      ,A.AGMT_LSTM_CD" ).append("\n"); 
		query.append("      ,A.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("      ,TO_CHAR(A.ONH_DT,'yyyymmdd') as ONH_DT" ).append("\n"); 
		query.append("      ,A.AGMT_OFC_CTY_CD || B.AGMT_SEQ AGREEMENT" ).append("\n"); 
		query.append("      ,B.AGMT_SEQ" ).append("\n"); 
		query.append("      ,B.AGMT_REF_NO" ).append("\n"); 
		query.append("      ,B.VNDR_SEQ" ).append("\n"); 
		query.append("      ,C.VNDR_LGL_ENG_NM VNDR_NM" ).append("\n"); 
		query.append("      ,'' VERIFY" ).append("\n"); 
		query.append("      ,'' STS_EVNT_OFC_CD" ).append("\n"); 
		query.append("      ,'' STS_EVNT_YD_CD" ).append("\n"); 
		query.append("      ,'' STS_EVNT_DT" ).append("\n"); 
		query.append("      ,'' NO" ).append("\n"); 
		query.append("      ,'' USER_ID" ).append("\n"); 
		query.append("FROM CGM_EQUIPMENT A" ).append("\n"); 
		query.append("   , CGM_AGREEMENT B" ).append("\n"); 
		query.append("   , MDM_VENDOR    C" ).append("\n"); 
		query.append("WHERE A.EQ_KND_CD = 'G'" ).append("\n"); 
		query.append("  AND A.AGMT_OFC_CTY_CD = B.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("  AND A.AGMT_VER_NO     = B.AGMT_VER_NO" ).append("\n"); 
		query.append("  AND A.AGMT_SEQ        = B.AGMT_SEQ" ).append("\n"); 
		query.append("  AND B.VNDR_SEQ        = C.VNDR_SEQ" ).append("\n"); 
		query.append("  AND A.EQ_NO           = @[eq_no]" ).append("\n"); 

	}
}