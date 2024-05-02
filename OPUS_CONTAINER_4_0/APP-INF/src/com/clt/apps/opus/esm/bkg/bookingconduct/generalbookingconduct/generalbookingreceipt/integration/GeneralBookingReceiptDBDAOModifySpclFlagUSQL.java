/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOModifySpclFlagUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.22
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2009.10.22 류대영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dae-Young RYU
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOModifySpclFlagUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * split, combine 후 변경된 data로 bkg_booking의 spcl flag를 수정함
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOModifySpclFlagUSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration ").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOModifySpclFlagUSQL").append("\n"); 
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
		query.append("UPDATE BKG_BOOKING" ).append("\n"); 
		query.append("SET DCGO_FLG    = (SELECT DECODE(NVL(COUNT(1), 0), 0, 'N', 'Y')" ).append("\n"); 
		query.append("FROM BKG_DG_CGO" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no])" ).append("\n"); 
		query.append(", RC_FLG      = (SELECT DECODE(NVL(COUNT(1), 0), 0, 'N', 'Y')" ).append("\n"); 
		query.append("FROM BKG_RF_CGO" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no])" ).append("\n"); 
		query.append(", AWK_CGO_FLG = (SELECT DECODE(NVL(COUNT(1), 0), 0, 'N', 'Y')" ).append("\n"); 
		query.append("FROM BKG_AWK_CGO" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no])" ).append("\n"); 
		query.append(", BB_CGO_FLG  = (SELECT DECODE(NVL(COUNT(1), 0), 0, 'N', 'Y')" ).append("\n"); 
		query.append("FROM BKG_BB_CGO" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no])" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}