/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ChargeCalculationDBDAOCheckEDIRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.11
*@LastModifier : KIM HYUN HWA
*@LastVersion : 1.0
* 2011.10.11 KIM HYUN HWA
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author ISD1
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeCalculationDBDAOCheckEDIRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * KOR 인경우 EDI 전송대상여부 check
	  * </pre>
	  */
	public ChargeCalculationDBDAOCheckEDIRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration ").append("\n"); 
		query.append("FileName : ChargeCalculationDBDAOCheckEDIRSQL").append("\n"); 
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
		query.append("SELECT 'Y' FROM DUAL" ).append("\n"); 
		query.append("WHERE EXISTS ( SELECT BKG.BKG_NO" ).append("\n"); 
		query.append("               FROM BKG_BOOKING        BKG," ).append("\n"); 
		query.append("                    BKG_CSTMS_KR_MF_SEQ_NO MSN" ).append("\n"); 
		query.append("               WHERE BKG.BKG_NO     = @[bkg_no]" ).append("\n"); 
		query.append("               AND MSN.BKG_NO       = BKG.BKG_NO" ).append("\n"); 
		query.append("               AND MSN.MF_CFM_FLG   ='Y'" ).append("\n"); 
		query.append("               AND MSN.MRN_BL_TS_CD = 'I'" ).append("\n"); 
		query.append("               AND MSN.CFM_DT       = ( SELECT MAX(SEQ.CFM_DT) " ).append("\n"); 
		query.append("                                        FROM BKG_CSTMS_KR_MF_SEQ_NO SEQ" ).append("\n"); 
		query.append("                                        WHERE SEQ.BKG_NO       = @[bkg_no]" ).append("\n"); 
		query.append("                                        AND   SEQ.MF_CFM_FLG   = 'Y'" ).append("\n"); 
		query.append("                                        AND   SEQ.MRN_BL_TS_CD = 'I' ) )" ).append("\n"); 

	}
}