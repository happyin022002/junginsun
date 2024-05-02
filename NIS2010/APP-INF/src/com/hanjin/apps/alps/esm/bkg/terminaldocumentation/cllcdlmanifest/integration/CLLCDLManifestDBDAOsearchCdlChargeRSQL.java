/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CLLCDLManifestDBDAOsearchCdlChargeRSQL.java
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

public class CLLCDLManifestDBDAOsearchCdlChargeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCdlCharge
	  * </pre>
	  */
	public CLLCDLManifestDBDAOsearchCdlChargeRSQL(){
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
		query.append("FileName : CLLCDLManifestDBDAOsearchCdlChargeRSQL").append("\n"); 
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
		query.append("SELECT	'{CHARGE'||CHR(10)||" ).append("\n"); 
		query.append("'FCTYPE:'||NVL(CHG_CD, ' ')||CHR(10)||" ).append("\n"); 
		query.append("'RATE:'||NVL(CHG_UT_AMT, 0)||CHR(10)||" ).append("\n"); 
		query.append("'REVENUETON:'||NVL(RAT_AS_QTY,0)||CHR(10)||" ).append("\n"); 
		query.append("DECODE(FRT_TERM_CD,'P','PPD:'||" ).append("\n"); 
		query.append("NVL(CHG_AMT,0),'PPD:'||0.0)||CHR(10)||" ).append("\n"); 
		query.append("DECODE(FRT_TERM_CD,'C','CCT:'||" ).append("\n"); 
		query.append("NVL(CHG_AMT,0),'CCT:'||0.0)||CHR(10)||" ).append("\n"); 
		query.append("'CURRENCYCODE:'||NVL(CURR_CD,' ')||CHR(10)||" ).append("\n"); 
		query.append("'EXCHRATE:'||CHR(10)||" ).append("\n"); 
		query.append("'TARIFF:'||NVL(TRF_ITM_NO,' ')||CHR(10)||" ).append("\n"); 
		query.append("'PERTYPE:'||NVL(RAT_UT_CD,' ')||CHR(10)||" ).append("\n"); 
		query.append("'RATEOFC:'||NVL(N3PTY_RCV_OFC_CD,' ')||CHR(10)||" ).append("\n"); 
		query.append("'}CHARGE'||CHR(10) CHARGE_INFO" ).append("\n"); 
		query.append("FROM	BKG_CHG_RT" ).append("\n"); 
		query.append("WHERE	BKG_NO = @[in_bkg_no]" ).append("\n"); 
		query.append("AND	FRT_INCL_XCLD_DIV_CD = 'N'" ).append("\n"); 

	}
}