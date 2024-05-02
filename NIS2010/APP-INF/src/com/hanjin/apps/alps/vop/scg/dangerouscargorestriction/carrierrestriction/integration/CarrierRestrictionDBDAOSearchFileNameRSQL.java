/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CarrierRestrictionDBDAOSearchFileNameRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.26
*@LastModifier : 
*@LastVersion : 1.0
* 2012.04.26 
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

public class CarrierRestrictionDBDAOSearchFileNameRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 첨부파일명을 검색한다
	  * </pre>
	  */
	public CarrierRestrictionDBDAOSearchFileNameRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.carrierrestriction.integration").append("\n"); 
		query.append("FileName : CarrierRestrictionDBDAOSearchFileNameRSQL").append("\n"); 
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
		query.append(" FILE_NM||' ('||(select count(*) from SCG_IMDG_CRR_RSTR_FILE where VSL_OPR_TP_CD = @[crr_cd])||')' file_nm" ).append("\n"); 
		query.append(" FROM SCG_IMDG_CRR_RSTR_FILE" ).append("\n"); 
		query.append(" WHERE VSL_OPR_TP_CD = @[crr_cd] and  rownum='1'" ).append("\n"); 

	}
}