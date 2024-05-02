/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BookingProcessMgtDBDAOBkgDocPerfOfcVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.27
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.27 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingProcessMgtDBDAOBkgDocPerfOfcVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public BookingProcessMgtDBDAOBkgDocPerfOfcVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.integration").append("\n"); 
		query.append("FileName : BookingProcessMgtDBDAOBkgDocPerfOfcVORSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("	BKG_OFC_CD" ).append("\n"); 
		query.append(",   POR_CD" ).append("\n"); 
		query.append(",	RGN_OFC_CD" ).append("\n"); 
		query.append(",	GSO_OFC_CD" ).append("\n"); 
		query.append(",	SUB_GRP_CTNT" ).append("\n"); 
		query.append(",	TEAM_NM AS SUB_GSO_OFC_CD" ).append("\n"); 
		query.append(",	USE_FLG" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(",	'' OFC_CD" ).append("\n"); 
		query.append(",	'' CHK_OP" ).append("\n"); 
		query.append(",	'' OPTION_TP" ).append("\n"); 
		query.append(",	'' OFC_TY" ).append("\n"); 
		query.append(",	'' CTRl_OFC_CD" ).append("\n"); 
		query.append(",	'' SI_NTFC_EML" ).append("\n"); 
		query.append(",	'' BKG_NTFC_EML" ).append("\n"); 
		query.append(",	'' HNDL_OFC_CD" ).append("\n"); 
		query.append(",	'' HNDL_OFC_SEQ" ).append("\n"); 
		query.append("FROM BKG_DOC_PERF_OFC" ).append("\n"); 
		query.append("#if (${chk_op} == '0' && ${ofc_cd} != '') " ).append("\n"); 
		query.append("WHERE	BKG_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("#elseif (${chk_op} == '1' && ${ofc_cd} != '')  " ).append("\n"); 
		query.append("WHERE	POR_CD = @[ofc_cd]" ).append("\n"); 
		query.append("#elseif (${chk_op} == '2' && ${ofc_cd} != '') " ).append("\n"); 
		query.append("WHERE	 GSO_OFC_CD= @[ofc_cd]" ).append("\n"); 
		query.append("#elseif (${chk_op} == '3' && ${ofc_cd} != '')  " ).append("\n"); 
		query.append("WHERE	 RGN_OFC_CD= @[ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}