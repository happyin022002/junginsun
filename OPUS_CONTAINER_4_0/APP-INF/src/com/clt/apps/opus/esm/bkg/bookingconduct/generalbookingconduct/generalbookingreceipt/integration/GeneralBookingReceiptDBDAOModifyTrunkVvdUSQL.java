/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOModifyTrunkVvdUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.29
*@LastModifier : 김병규
*@LastVersion : 1.0
* 2009.07.29 김병규
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KimByungKyu
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOModifyTrunkVvdUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Trunk VVD 를 수정한다.
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOModifyTrunkVvdUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration ").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOModifyTrunkVvdUSQL").append("\n"); 
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
		query.append("set vsl_cd = substr(@[vvd], 1, 4)" ).append("\n"); 
		query.append(", skd_voy_no = substr(@[vvd], 5, 4)" ).append("\n"); 
		query.append(", skd_dir_cd = substr(@[vvd], 9, 1)" ).append("\n"); 
		query.append(", slan_cd = (select slan_Cd from vsk_vsl_skd where vsl_cd = substr(@[vvd], 1, 4) and skd_voy_no = substr(@[vvd], 5, 4) and skd_Dir_Cd = substr(@[vvd], 9, 1))" ).append("\n"); 
		query.append(", upd_usr_id = @[upd_usr_id]" ).append("\n"); 
		query.append(", upd_dt = SYSDATE" ).append("\n"); 
		query.append("where bkg_no = @[bkg_no]" ).append("\n"); 

	}
}