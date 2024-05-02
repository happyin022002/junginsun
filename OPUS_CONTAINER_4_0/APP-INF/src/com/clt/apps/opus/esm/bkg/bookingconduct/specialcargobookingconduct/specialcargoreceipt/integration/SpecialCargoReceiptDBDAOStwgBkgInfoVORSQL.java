/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SpecialCargoReceiptDBDAOStwgBkgInfoVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.12
*@LastModifier : Maeda Atsushi
*@LastVersion : 1.0
* 2015.01.12 Maeda Atsushi
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maeda Atsushi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialCargoReceiptDBDAOStwgBkgInfoVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * StwgBkgInfoVO
	  * </pre>
	  */
	public SpecialCargoReceiptDBDAOStwgBkgInfoVORSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.integration").append("\n"); 
		query.append("FileName : SpecialCargoReceiptDBDAOStwgBkgInfoVORSQL").append("\n"); 
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
		query.append("#if (${ca_flg}== 'Y') " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT BK.BKG_NO" ).append("\n"); 
		query.append(",   BK.POR_CD" ).append("\n"); 
		query.append(",   BK.DEL_CD" ).append("\n"); 
		query.append(",	BK.RCV_TERM_CD" ).append("\n"); 
		query.append(",	BK.DE_TERM_CD" ).append("\n"); 
		query.append(",	BL.BDR_FLG" ).append("\n"); 
		query.append(",	BL.CORR_NO" ).append("\n"); 
		query.append("FROM BKG_BKG_HIS BK" ).append("\n"); 
		query.append(",BKG_BL_DOC BL" ).append("\n"); 
		query.append("WHERE BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND   BK.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND BK.BKG_NO = BL.BKG_NO(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT BK.BKG_NO" ).append("\n"); 
		query.append(",   BK.POR_CD" ).append("\n"); 
		query.append(",   BK.DEL_CD" ).append("\n"); 
		query.append(",	BK.RCV_TERM_CD" ).append("\n"); 
		query.append(",	BK.DE_TERM_CD" ).append("\n"); 
		query.append(",	BL.BDR_FLG" ).append("\n"); 
		query.append(",	BL.CORR_NO" ).append("\n"); 
		query.append("FROM BKG_BOOKING BK" ).append("\n"); 
		query.append(",BKG_BL_DOC BL" ).append("\n"); 
		query.append("WHERE BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND BK.BKG_NO = BL.BKG_NO(+)" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}