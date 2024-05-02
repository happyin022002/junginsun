/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralCodeSearchMgtDBDAOsearchServiceProviderInfoListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.28
*@LastModifier : 권영법
*@LastVersion : 1.0
* 2009.10.28 권영법
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 권영법
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralCodeSearchMgtDBDAOsearchServiceProviderInfoListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select
	  * </pre>
	  */
	public GeneralCodeSearchMgtDBDAOsearchServiceProviderInfoListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("costcontrolofc",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.integration").append("\n"); 
		query.append("FileName : GeneralCodeSearchMgtDBDAOsearchServiceProviderInfoListDataRSQL").append("\n"); 
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
		query.append("MNR_COMMON_PKG.MNR_CONV_AGMT_NO_FNC(A.AGMT_OFC_CTY_CD, A.AGMT_SEQ) AGMT_NO," ).append("\n"); 
		query.append("B.AGMT_REF_NO AGMT_REF_NO," ).append("\n"); 
		query.append("B.EFF_DT||' ~ '||B.EXP_DT  EFFECT_DT," ).append("\n"); 
		query.append("B.AGMT_OFC_CD AGMT_OFC_CD," ).append("\n"); 
		query.append("B.VNDR_SEQ VNDR_SEQ," ).append("\n"); 
		query.append("C.VNDR_LGL_ENG_NM VNDR_LGL_ENG_NM," ).append("\n"); 
		query.append("C.ENG_ADDR ENG_ADDR" ).append("\n"); 
		query.append("FROM MNR_AGMT_APLY_OFC A, MNR_AGMT_HDR B, MDM_VENDOR C" ).append("\n"); 
		query.append("WHERE A.AGMT_OFC_TP_CD = 'COST'" ).append("\n"); 
		query.append("AND   A.AGMT_OFC_CTY_CD = B.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("AND   A.AGMT_SEQ = B.AGMT_SEQ" ).append("\n"); 
		query.append("AND   B.VNDR_SEQ = C.VNDR_SEQ" ).append("\n"); 
		query.append("AND   A.APLY_OFC_CD = @[costcontrolofc]" ).append("\n"); 

	}
}