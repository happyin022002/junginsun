/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOmodifyBkgVvdForAssignUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.09
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2009.11.09 류대영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dae-Young RYU
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOmodifyBkgVvdForAssignUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * bkg_vdd테이블 갱신한다.
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOmodifyBkgVvdForAssignUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("old_vvd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("new_vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOmodifyBkgVvdForAssignUSQL").append("\n"); 
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
		query.append("update bkg_vvd" ).append("\n"); 
		query.append("set vsl_cd     = substr(@[new_vvd], 1, 4)" ).append("\n"); 
		query.append(", skd_voy_no = substr(@[new_vvd], 5, 4)" ).append("\n"); 
		query.append(", skd_dir_cd = substr(@[new_vvd], 9, 1)" ).append("\n"); 
		query.append(", slan_cd    = (select VSL_SLAN_CD" ).append("\n"); 
		query.append("from vsk_vsl_skd" ).append("\n"); 
		query.append("where vsl_cd     = substr(@[new_vvd], 1, 4)" ).append("\n"); 
		query.append("and skd_voy_no = substr(@[new_vvd], 5, 4)" ).append("\n"); 
		query.append("and skd_dir_cd = substr(@[new_vvd], 9, 1))" ).append("\n"); 
		query.append(", upd_dt     = sysdate" ).append("\n"); 
		query.append(", upd_usr_id = @[usr_id]" ).append("\n"); 
		query.append("where bkg_no     = @[bkg_no]" ).append("\n"); 
		query.append("and NVL(vsl_cd    ,'X') = NVL(substr(@[old_vvd], 1, 4),'X')" ).append("\n"); 
		query.append("and NVL(skd_voy_no,'X') = NVL(substr(@[old_vvd], 5, 4),'X')" ).append("\n"); 
		query.append("and NVL(skd_dir_cd,'X') = NVL(substr(@[old_vvd], 9, 1),'X')" ).append("\n"); 

	}
}