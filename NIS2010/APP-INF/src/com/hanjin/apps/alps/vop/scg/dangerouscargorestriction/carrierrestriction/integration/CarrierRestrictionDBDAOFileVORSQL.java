/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CarrierRestrictionDBDAOFileVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.09
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.09 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.carrierrestriction.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CarrierRestrictionDBDAOFileVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * file select
	  * </pre>
	  */
	public CarrierRestrictionDBDAOFileVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_opr_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.carrierrestriction.integration").append("\n"); 
		query.append("FileName : CarrierRestrictionDBDAOFileVORSQL").append("\n"); 
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
		query.append("    A.VSL_OPR_TP_CD" ).append("\n"); 
		query.append(",	A.IMDG_CRR_RSTR_FILE_SEQ" ).append("\n"); 
		query.append(",	B.FILE_UPLD_NM AS FILE_NM" ).append("\n"); 
		query.append(",	B.FILE_SAV_ID" ).append("\n"); 
		query.append(",	A.CRE_USR_ID" ).append("\n"); 
		query.append(",	TO_CHAR(A.CRE_DT,'YYYYMMDD') CRE_DT" ).append("\n"); 
		query.append(",	TO_CHAR(A.UPD_DT,'YYYYMMDD') UPD_DT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("SCG_IMDG_CRR_RSTR_FILE A, COM_UPLD_FILE B" ).append("\n"); 
		query.append("WHERE  A.VSL_OPR_TP_CD  = @[vsl_opr_tp_cd]" ).append("\n"); 
		query.append("  AND  A.FILE_SAV_ID    = B.FILE_SAV_ID" ).append("\n"); 

	}
}