/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CLLCDLManifestDBDAOsearchCdlChargeTotalRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.30
*@LastModifier : 경종윤
*@LastVersion : 1.0
* 2009.10.30 경종윤
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kyoung Jong Yun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CLLCDLManifestDBDAOsearchCdlChargeTotalRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCdlChargeTotal
	  * </pre>
	  */
	public CLLCDLManifestDBDAOsearchCdlChargeTotalRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.integration").append("\n"); 
		query.append("FileName : CLLCDLManifestDBDAOsearchCdlChargeTotalRSQL").append("\n"); 
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
		query.append("SELECT	'{CHARGE_TTL'||CHR(10)||" ).append("\n"); 
		query.append("'PPD_TOTAL:'||sum(DECODE(FRT_TERM_CD,'P',CHG_AMT,0))||CHR(10)||" ).append("\n"); 
		query.append("'CCT_TOTAL:'||sum(DECODE(FRT_TERM_CD,'C',CHG_AMT,0))||CHR(10)||" ).append("\n"); 
		query.append("'TOTAL_CUR:'||NVL(CURR_CD, ' ')||CHR(10)||" ).append("\n"); 
		query.append("'}CHARGE_TTL'||CHR(10) CHARGE_TOTAL_INFO" ).append("\n"); 
		query.append("FROM	BKG_CHG_RT" ).append("\n"); 
		query.append("WHERE	BKG_NO		= @[in_bkg_no]" ).append("\n"); 
		query.append("AND	FRT_INCL_XCLD_DIV_CD 	= 'N'" ).append("\n"); 
		query.append("GROUP BY FRT_TERM_CD, NVL(CURR_CD,' ')" ).append("\n"); 

	}
}