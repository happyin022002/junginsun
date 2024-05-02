/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOModifyBkgRouteForVslSkdCngUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.22
*@LastModifier : 정인선
*@LastVersion : 1.0
* 2016.08.22 정인선
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author jung in sun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOModifyBkgRouteForVslSkdCngUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PORT
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOModifyBkgRouteForVslSkdCngUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("new_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOModifyBkgRouteForVslSkdCngUSQL").append("\n"); 
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
		query.append("   SET POR_NOD_CD       = CASE WHEN RCV_TERM_CD <> 'D' AND POR_NOD_CD = POL_NOD_CD " ).append("\n"); 
		query.append("										THEN DECODE(POL_CD, @[port_cd], @[new_yd_cd], POL_NOD_CD)" ).append("\n"); 
		query.append("							   ELSE POR_NOD_CD END" ).append("\n"); 
		query.append("	 , POL_NOD_CD		= DECODE(POL_CD, @[port_cd], @[new_yd_cd], POL_NOD_CD)" ).append("\n"); 
		query.append("  	 , POD_NOD_CD 		= DECODE(POD_CD, @[port_cd], @[new_yd_cd], POD_NOD_CD)	" ).append("\n"); 
		query.append("	 , DEL_NOD_CD		= CASE WHEN DE_TERM_CD <> 'D' AND DEL_NOD_CD = POD_NOD_CD" ).append("\n"); 
		query.append("										THEN DECODE(POD_CD, @[port_cd], @[new_yd_cd], POD_NOD_CD)" ).append("\n"); 
		query.append("							   ELSE DEL_NOD_CD END" ).append("\n"); 
		query.append("     , upd_usr_id 		= @[upd_usr_id]" ).append("\n"); 
		query.append("     , upd_dt 			= SYSDATE" ).append("\n"); 
		query.append(" WHERE BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}