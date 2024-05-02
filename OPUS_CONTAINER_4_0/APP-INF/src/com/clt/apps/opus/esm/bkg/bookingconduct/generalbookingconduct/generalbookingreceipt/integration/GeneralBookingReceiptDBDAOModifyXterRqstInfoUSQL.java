/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOModifyXterRqstInfoUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.30
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2010.04.30 류대영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Ryu Daeyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOModifyXterRqstInfoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Request Via Code 수정
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOModifyXterRqstInfoUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("auto_notification",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_rqst_via_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOModifyXterRqstInfoUSQL").append("\n"); 
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
		query.append("UPDATE BKG_BOOKING SET" ).append("\n"); 
		query.append("#if (${doc_tp_cd} == 'B')" ).append("\n"); 
		query.append("XTER_BKG_RQST_CD 		= @[xter_rqst_via_cd]," ).append("\n"); 
		query.append("XTER_BKG_RQST_REF_NO 	= @[rqst_no]," ).append("\n"); 
		query.append("#elseif  (${doc_tp_cd} == 'S')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${save_mode_cd} == 'C')" ).append("\n"); 
		query.append("XTER_BKG_RQST_CD 		= @[xter_rqst_via_cd]," ).append("\n"); 
		query.append("XTER_BKG_RQST_REF_NO 	= @[rqst_no]," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("XTER_SI_CD 				= @[xter_rqst_via_cd]," ).append("\n"); 
		query.append("XTER_SI_REF_NO 			= @[rqst_no]," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("XTER_RQST_AUTO_NTC_FLG = nvl(@[auto_notification], 'N')," ).append("\n"); 
		query.append("UPD_USR_ID 		= @[upd_usr_id]," ).append("\n"); 
		query.append("UPD_DT 			= SYSDATE" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}