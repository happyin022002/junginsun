/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BookingARCreationBackEndDBDAOModifyOTSHeaderRateFlgUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.27
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.27 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingARCreationBackEndDBDAOModifyOTSHeaderRateFlgUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Modify OTS Header Rate Flg
	  * </pre>
	  */
	public BookingARCreationBackEndDBDAOModifyOTSHeaderRateFlgUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_if_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ar_if_ser_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration ").append("\n"); 
		query.append("FileName : BookingARCreationBackEndDBDAOModifyOTSHeaderRateFlgUSQL").append("\n"); 
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
		query.append("UPDATE SAR_OTS_HDR A" ).append("\n"); 
		query.append("  SET OTS_RT_FLG = NVL((SELECT 'N' " ).append("\n"); 
		query.append("       	   				FROM SAR_OTS_DTL" ).append("\n"); 
		query.append("           				WHERE RHQ_CD = A.RHQ_CD" ).append("\n"); 
		query.append("           				AND OTS_OFC_CD = A.OTS_OFC_CD" ).append("\n"); 
		query.append("           				AND BL_NO = A.BL_NO" ).append("\n"); 
		query.append("           				AND INV_NO = A.INV_NO" ).append("\n"); 
		query.append("						AND NVL(INV_AMT, 0) <> 0" ).append("\n"); 
		query.append("	       				AND (NVL(LOCL_XCH_RT, 0) = 0 OR NVL(USD_XCH_RT, 0) = 0)" ).append("\n"); 
		query.append("           				AND ROWNUM = 1), 'Y')," ).append("\n"); 
		query.append("	  UPD_USR_ID = @[upd_usr_id]," ).append("\n"); 
		query.append("	  UPD_DT = SYSDATE " ).append("\n"); 
		query.append("WHERE (RHQ_CD, OTS_OFC_CD, BL_NO) IN " ).append("\n"); 
		query.append("      (SELECT RHQ_CD, OTS_OFC_CD, BL_NO" ).append("\n"); 
		query.append("       FROM SAR_OTS_HIS" ).append("\n"); 
		query.append("       WHERE IF_NO = @[ar_if_no]||@[ar_if_ser_no]" ).append("\n"); 
		query.append("       AND OTS_HIS_TP_CD = 'OTS')" ).append("\n"); 

	}
}