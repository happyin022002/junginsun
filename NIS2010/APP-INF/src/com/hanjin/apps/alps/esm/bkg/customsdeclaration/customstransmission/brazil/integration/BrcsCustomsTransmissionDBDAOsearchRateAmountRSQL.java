/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BrcsCustomsTransmissionDBDAOsearchRateAmountRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.16
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.16 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.brazil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BrcsCustomsTransmissionDBDAOsearchRateAmountRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Rate 정보를 조회한다.
	  * </pre>
	  */
	public BrcsCustomsTransmissionDBDAOsearchRateAmountRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.brazil.integration").append("\n"); 
		query.append("FileName : BrcsCustomsTransmissionDBDAOsearchRateAmountRSQL").append("\n"); 
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
		query.append("NVL(CHG_CD, '') FCTYPE" ).append("\n"); 
		query.append(",CHG_UT_AMT RATE" ).append("\n"); 
		query.append(",RAT_AS_QTY REVENUETON" ).append("\n"); 
		query.append(",DECODE(FRT_TERM_CD,'P', NVL(CHG_AMT,0),0.0) PPD" ).append("\n"); 
		query.append(",DECODE(FRT_TERM_CD,'C', NVL(CHG_AMT,0),0.0) CCT" ).append("\n"); 
		query.append(",CURR_CD CURRENCYCODE" ).append("\n"); 
		query.append(",'' EXCHRATE" ).append("\n"); 
		query.append(",TRF_ITM_NO TARIFF" ).append("\n"); 
		query.append(",RAT_UT_CD PERTYPE" ).append("\n"); 
		query.append(",N3PTY_RCV_OFC_CD RATEOFC" ).append("\n"); 
		query.append("FROM  BKG_CHG_RT" ).append("\n"); 
		query.append("WHERE BKG_NO          =   @[bkg_no]" ).append("\n"); 
		query.append("AND  FRT_INCL_XCLD_DIV_CD    =   'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${hide_check} == '1')" ).append("\n"); 
		query.append("AND  PRN_HDN_FLG = 'N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}