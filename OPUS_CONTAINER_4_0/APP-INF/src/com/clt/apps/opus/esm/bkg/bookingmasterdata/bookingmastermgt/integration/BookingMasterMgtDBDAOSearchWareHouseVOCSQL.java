/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BookingMasterMgtDBDAOSearchWareHouseVOCSQL.java
*@FileTitle : Package Table
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.20
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.05.20 김기종
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Ki Jong
 * @see DAO 참조
 * @since J2EE 1.4
 */

public class BookingMasterMgtDBDAOSearchWareHouseVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public BookingMasterMgtDBDAOSearchWareHouseVOCSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = "12,n";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wh_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,n";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,n";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("phn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,n";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wh_addr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,n";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fax_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,n";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wh_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,n";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "91,n";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,n";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,n";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,n";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pson_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "91,n";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,n";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("diff_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,n";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("INSERT INTO bkg_warehouse (" ).append("\n"); 
		query.append("cnt_cd" ).append("\n"); 
		query.append(",	wh_cd" ).append("\n"); 
		query.append(",	wh_nm" ).append("\n"); 
		query.append(",	wh_addr" ).append("\n"); 
		query.append(",	loc_cd" ).append("\n"); 
		query.append(",	cstms_cd" ).append("\n"); 
		query.append(",	phn_no" ).append("\n"); 
		query.append(",	fax_no" ).append("\n"); 
		query.append(",	pson_nm" ).append("\n"); 
		query.append(",	diff_rmk" ).append("\n"); 
		query.append(",	cre_usr_id" ).append("\n"); 
		query.append(",	cre_dt" ).append("\n"); 
		query.append(",	upd_usr_id" ).append("\n"); 
		query.append(",	upd_dt" ).append("\n"); 
		query.append(") VALUES(" ).append("\n"); 
		query.append("@[cnt_cd]" ).append("\n"); 
		query.append(",	@[wh_cd]" ).append("\n"); 
		query.append(",	@[wh_nm]" ).append("\n"); 
		query.append(",	@[wh_addr]" ).append("\n"); 
		query.append(",	@[loc_cd]" ).append("\n"); 
		query.append(",	@[cstms_cd]" ).append("\n"); 
		query.append(",	@[phn_no]" ).append("\n"); 
		query.append(",	@[fax_no]" ).append("\n"); 
		query.append(",	@[pson_nm]" ).append("\n"); 
		query.append(",	@[diff_rmk]" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	sysdate" ).append("\n"); 
		query.append(",	@[upd_usr_id]" ).append("\n"); 
		query.append(",	sysdate" ).append("\n"); 
		query.append(")" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.integration").append("\n"); 
		query.append("FileName : BookingMasterMgtDBDAOSearchWareHouseVOCSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}