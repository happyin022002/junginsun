/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOSearchCaTmpRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.28
*@LastModifier : 
*@LastVersion : 1.0
* 2011.02.28 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOSearchCaTmpRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * c/a tmp를 지워야 하는지 조회
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOSearchCaTmpRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOSearchCaTmpRSQL").append("\n"); 
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
		query.append("select CORR_USR_ID" ).append("\n"); 
		query.append("from bkg_correction" ).append("\n"); 
		query.append("where corr_no = 'TMP0000001'" ).append("\n"); 
		query.append("and corr_gdt < GLOBALDATE_PKG.TIME_CONV_FNC(COM_ConstantMgr_PKG.COM_getBaseLocationCode_FNC(), sysdate, 'GMT') - 1/24/2 --30분보다 이전" ).append("\n"); 
		query.append("and bkg_no = @[bkg_no]" ).append("\n"); 

	}
}