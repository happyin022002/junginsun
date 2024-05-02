/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TaiwanCustomsTransmissionDBDAOsearchBlChargeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.14
*@LastModifier : 
*@LastVersion : 1.0
* 2009.12.14 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.taiwan.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TaiwanCustomsTransmissionDBDAOsearchBlChargeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 대만세관 신고용 Manifest B/L Charge 정보를 조회한다.
	  * </pre>
	  */
	public TaiwanCustomsTransmissionDBDAOsearchBlChargeRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.taiwan.integration").append("\n"); 
		query.append("FileName : TaiwanCustomsTransmissionDBDAOsearchBlChargeRSQL").append("\n"); 
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
		query.append("NVL(CHG_CD, ' ') fctype," ).append("\n"); 
		query.append("NVL(CHG_UT_AMT, 0) rate," ).append("\n"); 
		query.append("NVL(RAT_AS_QTY,0) revenueton," ).append("\n"); 
		query.append("DECODE(FRT_TERM_CD,'P'," ).append("\n"); 
		query.append("NVL(CHG_AMT,0),0.0) ppd," ).append("\n"); 
		query.append("DECODE(FRT_TERM_CD,'C'," ).append("\n"); 
		query.append("NVL(CHG_AMT,0),0.0) cct," ).append("\n"); 
		query.append("NVL(CURR_CD,' ') currencycode," ).append("\n"); 
		query.append("NVL(TRF_ITM_NO,' ') tariff," ).append("\n"); 
		query.append("NVL(RAT_UT_CD,' ') pertype" ).append("\n"); 
		query.append("FROM   BKG_CHG_RT" ).append("\n"); 
		query.append("WHERE  BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND FRT_INCL_XCLD_DIV_CD = 'N'" ).append("\n"); 

	}
}