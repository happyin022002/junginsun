/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EServiceCompensationDBDAOPriCmpnEsvcVODSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.09
*@LastModifier : 김대호
*@LastVersion : 1.0
* 2009.08.09 김대호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.surcharge.eservicecompensation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author day-hoh Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EServiceCompensationDBDAOPriCmpnEsvcVODSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * E-SVC Compensation Creation 일괄삭제
	  * </pre>
	  */
	public EServiceCompensationDBDAOPriCmpnEsvcVODSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmpn_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.surcharge.eservicecompensation.integration").append("\n"); 
		query.append("FileName : EServiceCompensationDBDAOPriCmpnEsvcVODSQL").append("\n"); 
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
		query.append("DELETE FROM PRI_CMPN_ESVC" ).append("\n"); 
		query.append("WHERE	SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND	CMPN_SEQ = @[cmpn_seq]" ).append("\n"); 

	}
}