/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : IncomeMgtDBDAOcheckReceivableInvoiceDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.07
*@LastModifier : 함형석
*@LastVersion : 1.0
* 2010.01.07 함형석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.accountmanage.incomemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author HamHyungSeok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class IncomeMgtDBDAOcheckReceivableInvoiceDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * IncomeMgtDBDAOcheckReceivableInvoiceDataRSQL
	  * </pre>
	  */
	public IncomeMgtDBDAOcheckReceivableInvoiceDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_inv_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("buyer_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("input_inv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.accountmanage.incomemgt.integration").append("\n"); 
		query.append("FileName : IncomeMgtDBDAOcheckReceivableInvoiceDataRSQL").append("\n"); 
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
		query.append("SELECT MNR_INV_STS_CD" ).append("\n"); 
		query.append("FROM MNR_RCV_INV_WRK" ).append("\n"); 
		query.append("WHERE INV_NO = @[input_inv_no]" ).append("\n"); 
		query.append("AND MNR_PRNR_CNT_CD = SUBSTR(@[buyer_cd],1,2)" ).append("\n"); 
		query.append("AND MNR_PRNR_SEQ = TO_NUMBER(SUBSTR(@[buyer_cd],3))" ).append("\n"); 
		query.append("AND  MNR_INV_STS_CD IN ( 'HS', 'HC', 'HE')" ).append("\n"); 
		query.append("#if (${rcv_inv_seq} != '')" ).append("\n"); 
		query.append("AND  RCV_INV_SEQ <> @[rcv_inv_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND ROWNUM  = 1" ).append("\n"); 

	}
}