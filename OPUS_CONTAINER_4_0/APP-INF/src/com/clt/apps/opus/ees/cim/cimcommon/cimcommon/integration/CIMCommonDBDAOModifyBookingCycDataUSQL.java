/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CIMCommonDBDAOModifyBookingCycDataUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.31
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.31 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cim.cimcommon.cimcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CIMCommonDBDAOModifyBookingCycDataUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CYC Change Modify
	  * </pre>
	  */
	public CIMCommonDBDAOModifyBookingCycDataUSQL(){
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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cim.cimcommon.cimcommon.integration").append("\n"); 
		query.append("FileName : CIMCommonDBDAOModifyBookingCycDataUSQL").append("\n"); 
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
		query.append("#if (${app_cd} == 'OSCAR')" ).append("\n"); 
		query.append("	UPDATE CTM_BKG_CNTR SET " ).append("\n"); 
		query.append("		#if (${cnmv_cyc_no_chg} == 'F')" ).append("\n"); 
		query.append("			CNMV_CYC_NO = 0" ).append("\n"); 
		query.append("		#elseif (${cnmv_cyc_no_chg} == 'T')" ).append("\n"); 
		query.append("			CNMV_CYC_NO = 9999" ).append("\n"); 
		query.append("		#elseif (${cnmv_cyc_no_chg} == 'H')" ).append("\n"); 
		query.append("			CNMV_CYC_NO = 9998" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	WHERE " ).append("\n"); 
		query.append("		BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("	AND CNTR_NO  = @[cntr_no]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${app_cd} == 'OPUS')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	UPDATE BKG_CONTAINER SET " ).append("\n"); 
		query.append("		#if (${cnmv_cyc_no_chg} == 'F')" ).append("\n"); 
		query.append("			CNMV_CYC_NO = 0" ).append("\n"); 
		query.append("		#elseif (${cnmv_cyc_no_chg} == 'T')" ).append("\n"); 
		query.append("			CNMV_CYC_NO = 9999" ).append("\n"); 
		query.append("		#elseif (${cnmv_cyc_no_chg} == 'H')" ).append("\n"); 
		query.append("			CNMV_CYC_NO = 9998" ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("	WHERE " ).append("\n"); 
		query.append("		BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("	AND CNTR_NO  = @[cntr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}