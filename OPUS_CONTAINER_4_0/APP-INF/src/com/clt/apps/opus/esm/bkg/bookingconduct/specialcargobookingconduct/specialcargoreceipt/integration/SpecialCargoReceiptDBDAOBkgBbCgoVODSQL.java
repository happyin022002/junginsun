/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SpecialCargoReceiptDBDAOBkgBbCgoVODSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.12
*@LastModifier : 이병규
*@LastVersion : 1.0
* 2009.11.12 이병규
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Byung Kyu
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialCargoReceiptDBDAOBkgBbCgoVODSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BkgBbCgoVO
	  * </pre>
	  */
	public SpecialCargoReceiptDBDAOBkgBbCgoVODSQL(){
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

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bb_cgo_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.integration").append("\n"); 
		query.append("FileName : SpecialCargoReceiptDBDAOBkgBbCgoVODSQL").append("\n"); 
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
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("DELETE FROM BKG_BB_CGO_HIS" ).append("\n"); 
		query.append("WHERE	BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND	BB_CGO_SEQ = @[bb_cgo_seq]" ).append("\n"); 
		query.append("AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("DELETE FROM BKG_BB_CGO" ).append("\n"); 
		query.append("WHERE	BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND	BB_CGO_SEQ = @[bb_cgo_seq]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}