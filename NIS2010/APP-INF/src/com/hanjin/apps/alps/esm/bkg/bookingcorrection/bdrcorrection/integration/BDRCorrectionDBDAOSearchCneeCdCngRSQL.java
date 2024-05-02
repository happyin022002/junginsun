/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BDRCorrectionDBDAOSearchCneeCdCngRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.10
*@LastModifier : 신자영
*@LastVersion : 1.0
* 2010.11.10
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcorrection.bdrcorrection.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BDRCorrectionDBDAOSearchCneeCdCngRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BDRCorrectionDBDAOSearchCneeCdCngRSQL
	  * Customer화면에서 consignee code변경여부를 CA시에 check
	  * 2010.10.29 신자영 [CHM-2010066461] C/A Exemption 하드코딩 Case추가
	  * </pre>
	  */
	public BDRCorrectionDBDAOSearchCneeCdCngRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcorrection.bdrcorrection.integration").append("\n"); 
		query.append("FileName : BDRCorrectionDBDAOSearchCneeCdCngRSQL").append("\n"); 
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
		query.append("SELECT NVL(DECODE(COUNT(*), 0, 'N', 'Y'), 'N') CHN_FLG" ).append("\n"); 
		query.append("FROM BKG_CUSTOMER CUST" ).append("\n"); 
		query.append(", BKG_CUST_HIS HIS" ).append("\n"); 
		query.append("WHERE CUST.BKG_NO      = HIS.BKG_NO" ).append("\n"); 
		query.append("AND CUST.BKG_CUST_TP_CD = 'C'" ).append("\n"); 
		query.append("AND CUST.BKG_CUST_TP_CD = HIS.BKG_CUST_TP_CD" ).append("\n"); 
		query.append("AND HIS.CORR_NO  = 'TMP0000001'" ).append("\n"); 
		query.append("AND CUST.BKG_NO  = @[bkg_no]" ).append("\n"); 
		query.append("AND NVL(CUST.CUST_CNT_CD||CUST.CUST_SEQ, '*') != NVL(HIS.CUST_CNT_CD||HIS.CUST_SEQ, '*')" ).append("\n"); 

	}
}