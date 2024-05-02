/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOSearchTroCfmRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.08
*@LastModifier : 
*@LastVersion : 1.0
* 2009.11.08 
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

public class GeneralBookingReceiptDBDAOSearchTroCfmRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * POR, POL, POD, DEL, R/D TERM이 변경되어 TRO가 UNCONFIRM된 경우
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOSearchTroCfmRSQL(){
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
		query.append("FileName : GeneralBookingReceiptDBDAOSearchTroCfmRSQL").append("\n"); 
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
		query.append("select nvl(max(tro), 0) cnt" ).append("\n"); 
		query.append("from (select 1 tro" ).append("\n"); 
		query.append("from bkg_tro" ).append("\n"); 
		query.append("where bkg_no      = @[bkg_no]" ).append("\n"); 
		query.append("and io_bnd_cd   = 'O'" ).append("\n"); 
		query.append("and rtn_tro_flg = 'N'" ).append("\n"); 
		query.append("and cfm_flg     = 'Y'" ).append("\n"); 
		query.append("and rownum      = 1" ).append("\n"); 
		query.append("union" ).append("\n"); 
		query.append("select 1 tro" ).append("\n"); 
		query.append("from bkg_eur_tro" ).append("\n"); 
		query.append("where bkg_no      = @[bkg_no]" ).append("\n"); 
		query.append("and io_bnd_cd   = 'O'" ).append("\n"); 
		query.append("and cfm_flg     = 'Y'" ).append("\n"); 
		query.append("and rownum      = 1)" ).append("\n"); 

	}
}