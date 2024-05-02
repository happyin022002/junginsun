/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOsearchEdi301BlCntrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.23
*@LastModifier : 전용진
*@LastVersion : 1.0
* 2009.09.23 전용진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jun Yong Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingSearchDBDAOsearchEdi301BlCntrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchEdi301BlCntr
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOsearchEdi301BlCntrRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration").append("\n"); 
		query.append("FileName : GeneralBookingSearchDBDAOsearchEdi301BlCntrRSQL").append("\n"); 
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
		query.append("SELECT	'{BL_CNTR'																|| CHR(10)" ).append("\n"); 
		query.append("||	'HTYP:'			|| QTY.CNTR_TPSZ_CD										|| CHR(10)" ).append("\n"); 
		query.append("||	'ITYP:'			|| TS.CNTR_TPSZ_ISO_CD									|| CHR(10)" ).append("\n"); 
		query.append("||	'CNT:'			|| QTY.OP_CNTR_QTY										|| CHR(10)" ).append("\n"); 
		query.append("||	'}BL_CNTR' BL_CNTR" ).append("\n"); 
		query.append("FROM BKG_QUANTITY QTY, MDM_CNTR_TP_SZ TS" ).append("\n"); 
		query.append("WHERE QTY.CNTR_TPSZ_CD = TS.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("AND QTY.bkg_no		= @[bkg_no]" ).append("\n"); 

	}
}