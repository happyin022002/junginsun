/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KoreaCustomsReportDBDAOsearchImpCgoManiPrtCNTRInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.22
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.10.22 박상훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.korea.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SANGHUN PARK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KoreaCustomsReportDBDAOsearchImpCgoManiPrtCNTRInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Import Cargo Manifest Print를 위한 Container Information 조회한다.
	  * </pre>
	  */
	public KoreaCustomsReportDBDAOsearchImpCgoManiPrtCNTRInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.korea.integration").append("\n"); 
		query.append("FileName : KoreaCustomsReportDBDAOsearchImpCgoManiPrtCNTRInfoRSQL").append("\n"); 
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
		query.append("SELECT NVL(CNTR.CNTR_NO,' ')||'-'||NVL(CNTR.CNTR_TPSZ_CD,' ')||CHR(10)||'/'||NVL(SEAL.CNTR_SEAL_NO,' ') CNTR_INFO" ).append("\n"); 
		query.append("FROM BKG_CONTAINER CNTR, BKG_CNTR_SEAL_NO SEAL" ).append("\n"); 
		query.append("WHERE CNTR.BKG_NO  = @[bkg_no]" ).append("\n"); 
		query.append("AND CNTR.BKG_NO  = SEAL.BKG_NO(+)" ).append("\n"); 
		query.append("AND CNTR.CNTR_NO = SEAL.CNTR_NO(+)" ).append("\n"); 
		query.append("ORDER BY CNTR.CNTR_NO, SEAL.CNTR_SEAL_NO" ).append("\n"); 

	}
}