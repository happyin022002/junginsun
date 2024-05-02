/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOmodifyCargoClosingTimeUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.15
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.15 
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

public class GeneralBookingReceiptDBDAOmodifyCargoClosingTimeUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * update
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOmodifyCargoClosingTimeUSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnl_set_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clz_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ntc_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOmodifyCargoClosingTimeUSQL").append("\n"); 
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
		query.append("UPDATE BKG_CLZ_TM " ).append("\n"); 
		query.append("   SET MNL_SET_USR_ID = CASE WHEN NVL(@[mnl_set_dt], 'X') =  NVL(TO_CHAR(MNL_SET_DT,'YYYYMMDDHH24MISS'),'X') THEN CASE WHEN NVL(MNL_SET_USR_ID, 'X')='X' THEN 'SYSTEM' ELSE MNL_SET_USR_ID END" ).append("\n"); 
		query.append("                        WHEN NVL(@[mnl_set_dt], 'X') <> NVL(TO_CHAR(MNL_SET_DT,'YYYYMMDDHH24MISS'),'X') THEN @[upd_usr_id]" ).append("\n"); 
		query.append("                        ELSE 'SYSTEM'" ).append("\n"); 
		query.append("                        END" ).append("\n"); 
		query.append("     , MNL_SET_DT = TO_DATE(@[mnl_set_dt],'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("     , NTC_FLG = @[ntc_flg] " ).append("\n"); 
		query.append("     , UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("     , UPD_DT = sysdate" ).append("\n"); 
		query.append("WHERE	BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("AND CLZ_TP_CD = @[clz_tp_cd]" ).append("\n"); 

	}
}