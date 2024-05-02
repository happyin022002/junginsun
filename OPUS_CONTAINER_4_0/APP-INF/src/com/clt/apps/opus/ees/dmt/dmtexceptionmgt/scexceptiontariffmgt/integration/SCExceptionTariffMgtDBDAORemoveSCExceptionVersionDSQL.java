/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCExceptionTariffMgtDBDAORemoveSCExceptionVersionDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.30
*@LastModifier : 
*@LastVersion : 1.0
* 2009.12.30 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCExceptionTariffMgtDBDAORemoveSCExceptionVersionDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Version 에 해당되는 모든 Group 정보가 삭제되었다면, Version 정보도 삭제한다.
	  * </pre>
	  */
	public SCExceptionTariffMgtDBDAORemoveSCExceptionVersionDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_expt_ver_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.integration").append("\n"); 
		query.append("FileName : SCExceptionTariffMgtDBDAORemoveSCExceptionVersionDSQL").append("\n"); 
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
		query.append("DELETE FROM DMT_SC_EXPT_VER" ).append("\n"); 
		query.append("WHERE  	PROP_NO 		= @[prop_no]" ).append("\n"); 
		query.append("AND	SC_EXPT_VER_SEQ = @[sc_expt_ver_seq]" ).append("\n"); 

	}
}