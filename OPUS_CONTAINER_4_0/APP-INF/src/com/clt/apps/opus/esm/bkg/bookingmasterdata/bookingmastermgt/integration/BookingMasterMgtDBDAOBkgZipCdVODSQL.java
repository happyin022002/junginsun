/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BookingMasterMgtDBDAOBkgZipCdVODSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.18
*@LastModifier : 
*@LastVersion : 1.0
* 2011.02.18 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingMasterMgtDBDAOBkgZipCdVODSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * remove
	  * </pre>
	  */
	public BookingMasterMgtDBDAOBkgZipCdVODSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("evnt_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("evnt_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("zip_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.integration").append("\n"); 
		query.append("FileName : BookingMasterMgtDBDAOBkgZipCdVODSQL").append("\n"); 
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
		query.append("UPDATE BKG_ZIP_CD " ).append("\n"); 
		query.append("SET DELT_FLG='Y'" ).append("\n"); 
		query.append("   ,EVNT_USR_ID  = @[evnt_usr_id]" ).append("\n"); 
		query.append("   ,EVNT_OFC_CD  = @[evnt_ofc_cd]   " ).append("\n"); 
		query.append("   ,EVNT_DT      = GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[evnt_ofc_cd])       " ).append("\n"); 
		query.append("   ,EVNT_GDT     = GLOBALDATE_PKG.TIME_CONV_FNC(COM_CONSTANTMGR_PKG.COM_GETBASELOCATIONCODE_FNC(), SYSDATE, 'GMT' )" ).append("\n"); 
		query.append("   ,UPD_USR_ID   = @[upd_usr_id]      " ).append("\n"); 
		query.append("   ,UPD_DT       = SYSDATE" ).append("\n"); 
		query.append("WHERE CNT_CD = @[cnt_cd]" ).append("\n"); 
		query.append("AND   ZIP_CD = @[zip_cd]" ).append("\n"); 

	}
}