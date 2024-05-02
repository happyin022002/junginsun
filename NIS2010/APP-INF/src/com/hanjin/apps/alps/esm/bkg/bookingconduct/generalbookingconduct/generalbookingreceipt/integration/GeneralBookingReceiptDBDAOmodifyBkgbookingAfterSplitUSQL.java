/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOmodifyBkgbookingAfterSplitUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.22
*@LastModifier : 
*@LastVersion : 1.0
* 2012.02.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOmodifyBkgbookingAfterSplitUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * modifyBkgbookingAfterSplit
	  * 2011.06.08 이일민 [CHM-201110982-01] e-SI & DPCS BKG Split & Combine 기능 구현 요청
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOmodifyBkgbookingAfterSplitUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("split_rsn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_hld_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("splitCount",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rd_cgo_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOmodifyBkgbookingAfterSplitUSQL").append("\n"); 
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
		query.append("update bkg_booking" ).append("\n"); 
		query.append(" set split_rsn_cd = @[split_rsn_cd]" ).append("\n"); 
		query.append(" , split_flg = 'Y'" ).append("\n"); 
		query.append(" , split_dt = GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL',sysdate,(SELECT POR_CD FROM BKG_BOOKING WHERE BKG_NO = @[bkg_no]))" ).append("\n"); 
		query.append(" , split_rto = split_rto / @[splitCount]" ).append("\n"); 
		query.append(" , vsl_cd = @[vsl_cd] " ).append("\n"); 
		query.append(" , skd_voy_no = @[skd_voy_no] " ).append("\n"); 
		query.append(" , skd_dir_cd = @[skd_dir_cd]" ).append("\n"); 
		query.append(" , edi_hld_flg = nvl(@[edi_hld_flg],'N')" ).append("\n"); 
		query.append(" , slan_cd =(SELECT VSL_SLAN_CD FROM VSK_VSL_SKD" ).append("\n"); 
		query.append("	 WHERE vsl_cd = @[vsl_cd]" ).append("\n"); 
		query.append("     AND skd_voy_no = @[skd_voy_no] " ).append("\n"); 
		query.append("     AND skd_dir_cd = @[skd_dir_cd])" ).append("\n"); 
		query.append(" , upd_usr_id =@[usr_id]" ).append("\n"); 
		query.append(" , upd_dt = sysdate" ).append("\n"); 
		query.append(" , rd_cgo_flg = nvl(@[rd_cgo_flg],'N')" ).append("\n"); 
		query.append("where bkg_no = @[bkg_no]" ).append("\n"); 

	}
}