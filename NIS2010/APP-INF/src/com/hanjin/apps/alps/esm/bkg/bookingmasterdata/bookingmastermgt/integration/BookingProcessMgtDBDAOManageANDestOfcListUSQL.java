/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BookingProcessMgtDBDAOManageANDestOfcListUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.06
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2009.07.06 김경섭
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Gyoung Sub
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingProcessMgtDBDAOManageANDestOfcListUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *  0374  Arrival Notice의 Office Default  US Destination Office Setup 수정			
	  * </pre>
	  */
	public BookingProcessMgtDBDAOManageANDestOfcListUSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ntc_eml",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dest_ofc_cntc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_ctrl_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("phn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("diff_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hndl_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("MERGE INTO BKG_AN_DEST_OFC_STUP TA" ).append("\n"); 
		query.append("USING (" ).append("\n"); 
		query.append("SELECT   @[eq_ctrl_ofc_cd]   EQ_CTRL_OFC_CD" ).append("\n"); 
		query.append(", @[hndl_ofc_cd]      HNDL_OFC_CD" ).append("\n"); 
		query.append(", @[eq_ctrl_ofc_cd] P_EQ_CTRL_OFC_CD" ).append("\n"); 
		query.append(", @[hndl_ofc_cd]    P_HNDL_OFC_CD" ).append("\n"); 
		query.append(", @[dest_ofc_cntc_cd] DEST_OFC_CNTC_CD" ).append("\n"); 
		query.append(", @[phn_no]           PHN_NO" ).append("\n"); 
		query.append(", @[ntc_eml]          NTC_EML" ).append("\n"); 
		query.append(", @[diff_rmk]         DIFF_RMK" ).append("\n"); 
		query.append(", @[upd_usr_id]       UPD_USR_ID" ).append("\n"); 
		query.append("FROM   DUAL" ).append("\n"); 
		query.append(") TB" ).append("\n"); 
		query.append("ON(TA.EQ_CTRL_OFC_CD   = TB.EQ_CTRL_OFC_CD AND  TA.HNDL_OFC_CD = TB.HNDL_OFC_CD AND TA.DEST_OFC_CNTC_CD = TB.DEST_OFC_CNTC_CD)" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE SET PHN_NO      = TB.PHN_NO" ).append("\n"); 
		query.append(", NTC_EML     = TB.NTC_EML" ).append("\n"); 
		query.append(", DIFF_RMK    = TB.DIFF_RMK" ).append("\n"); 
		query.append(", UPD_USR_ID  =  TB.UPD_USR_ID" ).append("\n"); 
		query.append(", UPD_DT      = SYSDATE" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT (  EQ_CTRL_OFC_CD      , HNDL_OFC_CD      , DEST_OFC_CNTC_CD    , PHN_NO        , NTC_EML" ).append("\n"); 
		query.append(", DIFF_RMK            , CRE_USR_ID       , CRE_DT              , UPD_USR_ID    , UPD_DT )" ).append("\n"); 
		query.append("VALUES (  TB.P_EQ_CTRL_OFC_CD , TB.P_HNDL_OFC_CD , TB.DEST_OFC_CNTC_CD , TB.PHN_NO     , TB.NTC_EML" ).append("\n"); 
		query.append(", TB.DIFF_RMK         , TB.UPD_USR_ID    , SYSDATE             , TB.UPD_USR_ID , SYSDATE )" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.esm.bkg.bookingmasterdata.bookingmastermgt.integration").append("\n"); 
		query.append("FileName : BookingProcessMgtDBDAOManageANDestOfcListUSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}