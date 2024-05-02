/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BookingProcessMgtDBDAOSearchANDestOfcListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.24
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2009.12.24 김경섭
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

public class BookingProcessMgtDBDAOSearchANDestOfcListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *  0374  Arrival Notice의 Office Default  US Destination Office Setup 조회			
	  * </pre>
	  */
	public BookingProcessMgtDBDAOSearchANDestOfcListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_eq_ctrl_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_hndl_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.integration").append("\n"); 
		query.append("FileName : BookingProcessMgtDBDAOSearchANDestOfcListRSQL").append("\n"); 
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
		query.append("SELECT EQ_CTRL_OFC_CD" ).append("\n"); 
		query.append(", HNDL_OFC_CD" ).append("\n"); 
		query.append(", DEST_OFC_CNTC_CD" ).append("\n"); 
		query.append(", PHN_NO" ).append("\n"); 
		query.append(", NTC_EML" ).append("\n"); 
		query.append(", DIFF_RMK" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", '' P_EQ_CTRL_OFC_CD" ).append("\n"); 
		query.append(", '' P_HNDL_OFC_CD" ).append("\n"); 
		query.append("FROM   BKG_AN_DEST_OFC_STUP" ).append("\n"); 
		query.append("WHERE  EQ_CTRL_OFC_CD = @[p_eq_ctrl_ofc_cd]" ).append("\n"); 
		query.append("#if (${p_hndl_ofc_cd} != '')" ).append("\n"); 
		query.append("AND    HNDL_OFC_CD    = @[p_hndl_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}