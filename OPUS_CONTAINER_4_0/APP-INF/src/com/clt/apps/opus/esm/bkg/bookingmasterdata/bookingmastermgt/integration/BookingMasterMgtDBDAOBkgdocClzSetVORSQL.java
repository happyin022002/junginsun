/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BookingMasterMgtDBDAOBkgdocClzSetVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.24
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2009.07.24 강동윤
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author kang dong yun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingMasterMgtDBDAOBkgdocClzSetVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * search
	  * </pre>
	  */
	public BookingMasterMgtDBDAOBkgdocClzSetVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.integration").append("\n"); 
		query.append("FileName : BookingMasterMgtDBDAOBkgdocClzSetVORSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("VSL_SLAN_CD" ).append("\n"); 
		query.append(",	YD_CD" ).append("\n"); 
		query.append(",	DEST_CNT_CD" ).append("\n"); 
		query.append(",	DOC_CLZ_TP_CD" ).append("\n"); 
		query.append(",	ITVAL_HRS" ).append("\n"); 
		query.append(",	XCLD_HOL_FLG" ).append("\n"); 
		query.append(",	DELT_FLG" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append("FROM BKG_DOC_CLZ_SET" ).append("\n"); 
		query.append("WHERE YD_CD = @[yd_cd]" ).append("\n"); 
		query.append("#if (${vsl_slan_cd} != '')" ).append("\n"); 
		query.append("AND	VSL_SLAN_CD = @[vsl_slan_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}