/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BookingHistoryMgtDBDAOaddBkgHisMstCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.11.03
*@LastModifier : 
*@LastVersion : 1.0
* 2016.11.03 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingHistoryMgtDBDAOaddBkgHisMstCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Booking History Master 를 기록한다.
	  * </pre>
	  */
	public BookingHistoryMgtDBDAOaddBkgHisMstCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("his_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("corr_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_his_iss_ui_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.integration").append("\n"); 
		query.append("FileName : BookingHistoryMgtDBDAOaddBkgHisMstCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_HIS_MST (" ).append("\n"); 
		query.append("	BKG_NO" ).append("\n"); 
		query.append(",	HIS_SEQ" ).append("\n"); 
		query.append(",	BKG_HIS_ISS_UI_ID" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",   CORR_NO" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(", 	EVNT_DT" ).append("\n"); 
		query.append(") VALUES( " ).append("\n"); 
		query.append("	@[bkg_no]" ).append("\n"); 
		query.append(",	@[his_seq]" ).append("\n"); 
		query.append(",	@[bkg_his_iss_ui_id]" ).append("\n"); 
		query.append(",	NVL(@[cre_usr_id], 'SYSTEM')" ).append("\n"); 
		query.append(",	NVL(@[upd_usr_id], 'SYSTEM')" ).append("\n"); 
		query.append(",   @[corr_no] " ).append("\n"); 
		query.append("--Batch call AutoratingTaxCalculate Hard Coding 'TAXBATCH'" ).append("\n"); 
		query.append("#if(${cre_usr_id} == 'TAXBATCH' || ${cre_usr_id} == 'EDI AUTO')" ).append("\n"); 
		query.append(", 	GLOBALDATE_PKG.TIME_LOCAL_FNC('KRPUS')" ).append("\n"); 
		query.append(", 	GLOBALDATE_PKG.TIME_LOCAL_FNC('KRPUS')" ).append("\n"); 
		query.append(", 	GLOBALDATE_PKG.TIME_LOCAL_FNC('KRPUS')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(", 	GLOBALDATE_PKG.TIME_CONV_FNC(COM_CONSTANTMGR_PKG.COM_GETBASELOCATIONCODE_FNC(),sysdate,BKG_COM_USER_LOC_FNC(@[cre_usr_id]))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}