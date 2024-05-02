/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MexCustomsTransmissionDBDAOsearchChargeInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.30
*@LastModifier : 경종윤
*@LastVersion : 1.0
* 2009.10.30 경종윤
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.mexico.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kyoung Jong Yun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MexCustomsTransmissionDBDAOsearchChargeInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DWKIM, 0370, OUTVO: MxChgVO
	  * </pre>
	  */
	public MexCustomsTransmissionDBDAOsearchChargeInfoRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.mex.integration").append("\n"); 
		query.append("FileName : MexCustomsTransmissionDBDAOsearchChargeInfoRSQL").append("\n"); 
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
		query.append("NVL(CHG_CD,  ' ') 								FCTYPE" ).append("\n"); 
		query.append(",NVL(CHG_UT_AMT, 0) 							RATE" ).append("\n"); 
		query.append(",NVL(RAT_AS_QTY, 0) 							REVENUETON" ).append("\n"); 
		query.append(",DECODE(FRT_TERM_CD,'P', NVL(CHG_UT_AMT,0), 0)	PPD" ).append("\n"); 
		query.append(",DECODE(FRT_TERM_CD,'C', NVL(CHG_UT_AMT,0), 0)	CCT" ).append("\n"); 
		query.append(",NVL(CURR_CD, ' ') 								CURRENCYCODE" ).append("\n"); 
		query.append(",'' EXCHRATE" ).append("\n"); 
		query.append(",NVL(TRF_ITM_NO, ' ') TARIFF" ).append("\n"); 
		query.append(",NVL(RAT_UT_CD, ' ') PERTYPE" ).append("\n"); 
		query.append(",NVL(N3PTY_RCV_OFC_CD, ' ') RATEOFC" ).append("\n"); 
		query.append("FROM  BKG_CHG_RT" ).append("\n"); 
		query.append("WHERE BKG_NO          		 =   @[bkg_no]" ).append("\n"); 
		query.append("AND   FRT_INCL_XCLD_DIV_CD   =   'N'" ).append("\n"); 

	}
}