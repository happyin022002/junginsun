/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : GeneralCodeSearchMgtDBDAOsearchRfUnitMakerDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.04.05
*@LastModifier : 
*@LastVersion : 1.0
* 2017.04.05 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralCodeSearchMgtDBDAOsearchRfUnitMakerDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchRfUnitMakerData
	  * </pre>
	  */
	public GeneralCodeSearchMgtDBDAOsearchRfUnitMakerDataRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.integration").append("\n"); 
		query.append("FileName : GeneralCodeSearchMgtDBDAOsearchRfUnitMakerDataRSQL").append("\n"); 
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
		query.append("	A.DISP_FLG AS DSP_FLAG" ).append("\n"); 
		query.append("	, (SELECT NVL(VNDR_ABBR_NM, VNDR_LGL_ENG_NM) " ).append("\n"); 
		query.append("        FROM MDM_VENDOR " ).append("\n"); 
		query.append("        WHERE VNDR_SEQ = NVL(A.RF_MKR_SEQ,L.RF_MKR_SEQ)" ).append("\n"); 
		query.append("    ) AS MKR_NM" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("    MST_CONTAINER A" ).append("\n"); 
		query.append("    , MST_CNTR_LOT L" ).append("\n"); 
		query.append("WHERE " ).append("\n"); 
		query.append("    SUBSTR(A.CNTR_NO,0,10) BETWEEN L.LOT_CNTR_PFX_CD(+)||L.FM_SER_NO(+) AND L.LOT_CNTR_PFX_CD(+)||L.TO_SER_NO(+)" ).append("\n"); 
		query.append("    AND A.CNTR_NO = @[eq_no]" ).append("\n"); 
		query.append("    AND ROWNUM =  1" ).append("\n"); 

	}
}