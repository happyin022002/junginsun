/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : RateMgtDBDAOremoveAgmtAtchDataDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.20
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.agreementmanage.ratemgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RateMgtDBDAOremoveAgmtAtchDataDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RateMgtDBDAOremoveAgmtAtchDataDSQL
	  * </pre>
	  */
	public RateMgtDBDAOremoveAgmtAtchDataDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.agreementmanage.ratemgt.integration ").append("\n"); 
		query.append("FileName : RateMgtDBDAOremoveAgmtAtchDataDSQL").append("\n"); 
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
		query.append("DELETE FROM MNR_AGMT_ATCH" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND AGMT_OFC_CTY_CD = @[agmt_ofc_cty_cd]" ).append("\n"); 
		query.append("AND AGMT_SEQ = @[agmt_seq] " ).append("\n"); 
		query.append("AND AGMT_VER_NO = @[agmt_ver_no]" ).append("\n"); 

	}
}