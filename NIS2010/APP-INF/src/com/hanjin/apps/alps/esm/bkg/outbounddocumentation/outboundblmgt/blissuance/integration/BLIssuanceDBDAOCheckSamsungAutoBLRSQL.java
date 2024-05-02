/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : BLIssuanceDBDAOCheckSamsungAutoBLRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.04.25
*@LastModifier : 
*@LastVersion : 1.0
* 2017.04.25 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAOCheckSamsungAutoBLRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BL Issue시에 해당 조건에 맞으면 정해진 이메일 주소로 BL과 함께 이메일 전송
	  * </pre>
	  */
	public BLIssuanceDBDAOCheckSamsungAutoBLRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOCheckSamsungAutoBLRSQL").append("\n"); 
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
		query.append("SELECT 'Y'" ).append("\n"); 
		query.append("FROM BKG_BOOKING BKG, BKG_HRD_CDG_CTNT HRD, BKG_CUSTOMER CUS" ).append("\n"); 
		query.append("WHERE HRD_CDG_ID = 'SAMSUNG'" ).append("\n"); 
		query.append("AND BKG.BKG_NO = CUS.BKG_NO" ).append("\n"); 
		query.append("--AND CUS.BKG_CUST_TP_CD ='C'" ).append("\n"); 
		query.append("AND CUS.CUST_CNT_CD = HRD.ATTR_CTNT2" ).append("\n"); 
		query.append("AND CUS.CUST_SEQ = TO_NUMBER(HRD.ATTR_CTNT3)" ).append("\n"); 
		query.append("--AND BKG.RFA_NO = HRD.ATTR_CTNT4" ).append("\n"); 
		query.append("--AND SUBSTR(BKG.POD_CD,0,2) = HRD.ATTR_CTNT5" ).append("\n"); 
		query.append("AND BKG.BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}