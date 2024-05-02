/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BDRCorrectionDBDAOSearchModifyChargeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.15
*@LastModifier : 이남경
*@LastVersion : 1.0
* 2009.09.15 이남경
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcorrection.bdrcorrection.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Nam Kyung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BDRCorrectionDBDAOSearchModifyChargeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BDRCorrectionDBDAOSearchModifyChargeRSQL
	  * </pre>
	  */
	public BDRCorrectionDBDAOSearchModifyChargeRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcorrection.bdrcorrection.integration ").append("\n"); 
		query.append("FileName : BDRCorrectionDBDAOSearchModifyChargeRSQL").append("\n"); 
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
		query.append("SELECT RATE.CHG_CD" ).append("\n"); 
		query.append("FROM BKG_CHG_RT     RATE" ).append("\n"); 
		query.append(", BKG_CHG_RT_HIS RTHIS" ).append("\n"); 
		query.append("WHERE RATE.BKG_NO   = RTHIS.BKG_NO" ).append("\n"); 
		query.append("AND RATE.RT_SEQ   = RTHIS.RT_SEQ" ).append("\n"); 
		query.append("AND RATE.UPD_DT   != RTHIS.UPD_DT" ).append("\n"); 
		query.append("AND RTHIS.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("AND RATE.BKG_NO   = @[bkg_no]" ).append("\n"); 

	}
}