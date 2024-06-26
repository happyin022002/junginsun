/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : TransferOrderIssueDBDAOModifyBkgTroDtlByBkgUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.12.22
*@LastModifier : 
*@LastVersion : 1.0
* 2017.12.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TransferOrderIssueDBDAOModifyBkgTroDtlByBkgUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TRO KR Update - Return CY
	  * </pre>
	  */
	public TransferOrderIssueDBDAOModifyBkgTroDtlByBkgUSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration").append("\n"); 
		query.append("FileName : TransferOrderIssueDBDAOModifyBkgTroDtlByBkgUSQL").append("\n"); 
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
		query.append("UPDATE BKG_TRO_DTL SET " ).append("\n"); 
		query.append("  RTN_LOC_CD = (select substr(FULL_RTN_YD_CD, 1, 5) from bkg_booking where bkg_no = @[bkg_no])" ).append("\n"); 
		query.append("  ,RTN_YD_CD = (select FULL_RTN_YD_CD from bkg_booking where bkg_no = @[bkg_no])" ).append("\n"); 
		query.append("  ,UPD_USR_ID = @[usr_id]" ).append("\n"); 
		query.append("  ,UPD_DT = sysdate " ).append("\n"); 
		query.append("WHERE BKG_NO      = @[bkg_no]" ).append("\n"); 
		query.append("  AND IO_BND_CD   = 'O'" ).append("\n"); 
		query.append("  AND RTN_TRO_FLG = 'N'" ).append("\n"); 
		query.append("  AND NVL(CXL_FLG, 'N') = 'N'" ).append("\n"); 

	}
}